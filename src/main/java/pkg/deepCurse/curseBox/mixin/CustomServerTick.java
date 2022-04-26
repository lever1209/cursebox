package pkg.deepCurse.curseBox.mixin;

import static net.minecraft.entity.EntityType.ENDER_DRAGON;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import pkg.deepCurse.curseBox.core.CurseBoxConfig;
import pkg.deepCurse.curseBox.core.CurseBoxTools;
import pkg.deepCurse.curseBox.core.CustomDamageSource;
import pkg.deepCurse.curseBox.core.objects.TimedTask;

@Mixin({ MinecraftServer.class })
public class CustomServerTick {

	private MinecraftServer mcSv;
	private byte tick20 = 20;

	@Inject(at = { @At("TAIL") }, method = { "tick" })
	private void onEndTick(boolean shouldKeepTicking, CallbackInfo info) {
		this.mcSv = ((MinecraftServer) (Object) this);
		boolean tick20b = false;
		TimedTask.tickAllTasks();
		if (this.tick20 <= 0) {
			tick20b = true;
		}

		--this.tick20;
		Iterator<ServerWorld> var4 = mcSv.getWorlds().iterator();

		while (var4.hasNext()) {
			ServerWorld world = (ServerWorld) var4.next();
			Random r = world.getRandom();
			Iterator<Entity> var7 = world.iterateEntities().iterator();

			while (var7.hasNext()) {
				Entity entity = (Entity) var7.next();
				if (tick20b) {
					int randomDelay = r.nextInt(20);
					TimedTask.createTimedTask("doDarknessDamage" + entity.getUuidAsString(), true, randomDelay + 20,
							() -> {
								this.doDarknessDamage(entity, 0.0F, world);
							});
					this.tick20 = 20;
				}
			}
		}

	}

	private void doDarknessDamage(Entity entity, float damageAmount, ServerWorld world) {
		if (entity != null) {
			if (entity instanceof PlayerEntity || !CurseBoxConfig.gruesOnlyAttackPlayers) {
				if (CurseBoxConfig.isDynamicLightingEnabled()) {
					List<Item> grueWards = Arrays.asList();
					Iterator<ItemStack> var5 = entity.getItemsHand().iterator();

					while (var5.hasNext()) {
						ItemStack i = (ItemStack) var5.next();
						if (grueWards.contains(i.getItem())) {
							return;
						}
					}
				}

				Random random = world.getRandom();
				float resetGrueAttackChance = random.nextFloat();
				if (CurseBoxConfig.resetGrueAttackChance) {
					resetGrueAttackChance = 0.0F;
				}

				BlockPos entityLocation = entity.getBlockPos();
				if (world.getBlockState(entityLocation).getBlock() == Blocks.SOUL_SAND) {
					entityLocation = entityLocation.up();
				}

				Difficulty difficulty = world.getDifficulty();
				float trueDamageAmount = damageAmount;
				if (damageAmount <= 0.0F) {
					switch (difficulty) {
					case HARD:
						trueDamageAmount = 8.0F;
						break;
					case NORMAL:
						trueDamageAmount = 4.0F;
						break;
					case EASY:
						trueDamageAmount = 2.0F;
						break;
					case PEACEFUL:
						trueDamageAmount = 1.0F;
					}
				}

				if (!CurseBoxTools.isNearLight(world, entityLocation)) {
					boolean isItem = false;
					if (!(entity instanceof PlayerEntity)) {
						boolean skipRaceDiscovery = false;
						if (!skipRaceDiscovery && entity instanceof HostileEntity) {
							if (!CurseBoxConfig.gruesCanAttackHostileMobs) {
								return;
							}

							skipRaceDiscovery = true;
							trueDamageAmount /= 2.0F;
						}

						if (!skipRaceDiscovery && entity instanceof VillagerEntity) {
							if (!CurseBoxConfig.gruesCanAttackVillagers) {
								return;
							}

							skipRaceDiscovery = true;
						}

						if (!skipRaceDiscovery && entity instanceof AnimalEntity) {
							if (!CurseBoxConfig.gruesCanAttackAnimals) {
								return;
							}

							skipRaceDiscovery = true;
						}

						if (entity.getType() == EntityType.ITEM) {
							isItem = true;
						}

						if (!(entity instanceof LivingEntity) & !isItem) {
							return;
						}

						if (isItem) {
							if ((double) resetGrueAttackChance <= 1.5E-4D && CurseBoxConfig.gruesCanEatItems) {
								entity.kill();
								return;
							}

							return;
						}

						if ((double) resetGrueAttackChance > 0.045D) {
							return;
						}
					} else if (entity instanceof PlayerEntity) {
						if (((PlayerEntity) entity).isCreative()) {
						return;
						}
					}

					if (!(entity instanceof LivingEntity) || !((LivingEntity) entity).getActiveStatusEffects()
							.containsKey(StatusEffects.NIGHT_VISION)) {
						if (!entity.isSubmergedInWater() || CurseBoxConfig.gruesCanAttackInWater) {
							List<EntityType<?>> list = Arrays.asList(ENDER_DRAGON); // TODO cloth configurable enemies
																					// that the grues dont like
							if (!list.contains(entity.getType())) {
								if (this.mcSv.isHardcore() && entity instanceof PlayerEntity
										&& CurseBoxConfig.hardcoreAffectsOtherMobs) {
									entity.damage(CustomDamageSource.GRUE, Float.MAX_VALUE);
								} else {
									entity.damage(CustomDamageSource.GRUE, trueDamageAmount);
								}

							}
						}
					}
				}
			}
		}
	}
}
