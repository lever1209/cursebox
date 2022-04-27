package pkg.deepCurse.pandora.mixin;

import java.util.function.ToIntFunction;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import pkg.deepCurse.pandora.core.PandoraLightDictionary;

@Mixin(Blocks.class)
public class BlocksMixin {
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=lava")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfLavaBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.lava;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=brown_mushroom")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfBrownMushroomBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.brownMushroom;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=torch")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfTorchBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.torch;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=wall_torch")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfWallTorchBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.wallTorch;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=fire")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfFireBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.fire;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=soul_fire")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfSoulFireBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.soulFire;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=furnace")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfFurnaceBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.furnace;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=redstone_ore")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfRedstoneOreBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.redstoneOre;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=redstone_torch")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfRedstoneTorchBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.redstoneTorch;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=redstone_wall_torch")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfRedstoneWallTorchBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.redstoneWallTorch;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=soul_torch")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfSoulTorchBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.soulTorch;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=soul_wall_torch")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfSoulWallTorchBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.soulWallTorch;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=glowstone")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfGlowstoneBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.glowstone;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=nether_portal")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfNetherPortalBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.netherPortal;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=jack_o_lantern")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfJackOLanternBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.jackOLantern;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=glow_lichen")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfGlowLichenBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.glowLichen;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=enchanting_table")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfEnchantingTableBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.enchantingTable;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=brewing_stand")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfBrewingStandBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.brewingStand;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=lava_cauldron")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfLavaCauldronBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.lavaCauldron;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=end_portal")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfEndPortalBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.endPortal;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=end_portal_frame")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfEndPortalFrameBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.endPortalFrame;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=dragon_egg")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfDragonEggBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.dragonEgg;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=redstone_lamp")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfRedstoneLampBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.redstoneLamp;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=ender_chest")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfEnderChestBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.enderChest;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=beacon")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfBeaconBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.beacon;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=light")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfLightBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.light;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=sea_lantern")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfSeaLanternBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.seaLantern;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=end_rod")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfEndRodBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.endRod;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=end_gateway")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfEndGatewayBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.endGateway;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=magma_block")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfMagmaBlockBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.magma;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=sea_pickle")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfSeaPickleBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.seaPickle;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=conduit")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfConduitBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.conduit;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=smoker")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfSmokerBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.smoker;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=blast_furnace")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfBlastFurnaceBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.blastFurnace;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=lantern")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfLanternBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.lantern;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=soul_campfire")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfSoulCampfireBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.soulCampfire;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=shroom_light")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfShroomLightBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.shroomLight;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=crying_obsidian")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfCryingObsidianBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.cryingObsidian;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=respawn_anchor")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfRespawnAnchorBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.respawnAnchor;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=candle")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfCandleBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.candle;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=candle_cake")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfCandleCakeBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.candleCake;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=amethyst_cluster")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfAmethystClusterBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.amethystCluster;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=large_amethyst_bud")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfLargeAmethystBudBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.largeAmethystBud;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=medium_amethyst_bud")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfMediumAmethystBudBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.mediumAmethystBud;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=small_amethyst_bud")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfSmallAmethystBudBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.smallAmethystBud;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=sculk_sensor")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfSculkSensorBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.sculkSensor;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=cave_vines")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfCaveVinesBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.caveVines;
	}
	@ModifyArg(slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=cave_vines_plant")), method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0), index = 0)
	private static ToIntFunction<BlockState> changeLuminenceOfCaveVinesPlantBlock(
			ToIntFunction<BlockState> oldVal) {
		return blockstate -> PandoraLightDictionary.caveVinesPlant;
	}
}
