//package pkg.deepCurse.curseBox.blocks;
//
//import java.util.Random;
//
//import org.jetbrains.annotations.Nullable;
//
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.minecraft.class_2394;
//import net.minecraft.class_2586;
//import net.minecraft.class_265;
//import net.minecraft.class_2680;
//import net.minecraft.class_3218;
//import net.minecraft.class_3726;
//import net.minecraft.class_3965;
//import net.minecraft.class_4538;
//import net.minecraft.block.Block;
//import net.minecraft.block.Blocks;
//import net.minecraft.class_4970.class_2251;
//import net.minecraft.entity.ai.pathing.NavigationType;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.util.ActionResult;
//import net.minecraft.util.Hand;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import net.minecraft.world.BlockView;
//import net.minecraft.world.World;
//import net.minecraft.world.WorldAccess;
//import pkg.deepCurse.curseBox.blockEntities.TorchBlockEntity;
//import pkg.deepCurse.curseBox.core.CurseBox;
//
//public class TimedTorchBlock extends Block {
//	protected static final class_265 BOUNDING_SHAPE = Block.method_9541(6.0D, 0.0D, 6.0D, 10.0D, 10.0D, 10.0D);
//	protected final class_2394 particle;
//	protected boolean shouldDieOut;
//	protected int age;
//
//	public TimedTorchBlock(class_2251 settings, class_2394 particle, Boolean shouldDieOut, int totalTickTime) {
//		super(settings);
//		this.particle = particle;
//		this.shouldDieOut = shouldDieOut;
//		this.age = totalTickTime;
//	}
//
//	public int getMinAge() {
//		return 0;
//	}
//
//	public class_265 method_9530(class_2680 state, BlockView world, BlockPos pos, class_3726 context) {
//		return BOUNDING_SHAPE;
//	}
//
//	public class_2680 method_9559(class_2680 state, Direction direction, class_2680 neighborState, WorldAccess world,
//			BlockPos pos, BlockPos neighborPos) {
//		return direction == Direction.field_11033 && !this.method_9558(state, world, pos)
//				? Blocks.field_10124.method_9564()
//				: super.method_9559(state, direction, neighborState, world, pos, neighborPos);
//	}
//
//	public boolean method_9558(class_2680 state, class_4538 world, BlockPos pos) {
//		return method_20044(world, pos.method_10074(), Direction.field_11036);
//	}
//
//	public boolean hasRandomTicks() {
//		return false;
//	}
//
//	@Nullable
//	public class_2586 createBlockEntity(BlockView world) {
//		return new TorchBlockEntity();
//	}
//
//	public ActionResult method_9534(class_2680 state, World world, BlockPos pos, PlayerEntity player,
//			Hand hand, class_3965 hit) {
//		return ActionResult.field_5812;
//	}
//
//	public boolean method_9516(class_2680 state, BlockView world, BlockPos pos, NavigationType type) {
//		return true;
//	}
//
//	public void method_9514(class_2680 state, class_3218 world, BlockPos pos, Random random) {
//		++this.age;
//		if (this.shouldDieOut) {
//			if ((random.nextInt(100) > 33 || CurseBox.accelerateTorchDeath) && CurseBox.accelerateTorchDeath) {
//				;
//			}
//
//			if (this.age <= 0) {
//				world.method_8650(pos, false);
//			}
//		}
//
//	}
//
//	@Environment(EnvType.CLIENT)
//	public void method_9496(class_2680 state, World world, BlockPos pos, Random random) {
//		double d = (double) pos.method_10263() + 0.5D;
//		double e = (double) pos.method_10264() + 0.7D;
//		double f = (double) pos.method_10260() + 0.5D;
//		world.method_8406(class_2398.field_11251, d, e, f, 0.0D, 0.0D, 0.0D);
//		world.method_8406(this.particle, d, e, f, 0.0D, 0.0D, 0.0D);
//	}
//}