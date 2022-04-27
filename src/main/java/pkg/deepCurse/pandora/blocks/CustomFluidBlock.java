package pkg.deepCurse.pandora.blocks;
// package pkg.deepCurse.curseBox.blocks;
//
// import com.google.common.collect.Lists;
// import java.util.Collections;
// import java.util.List;
// import java.util.Random;
// import net.fabricmc.api.EnvType;
// import net.fabricmc.api.Environment;
// import net.minecraft.NavigationType;
// import net.minecraft.class_1799;
// import net.minecraft.class_1922;
// import net.minecraft.class_1936;
// import net.minecraft.class_1937;
// import net.minecraft.class_2246;
// import net.minecraft.class_2248;
// import net.minecraft.class_2263;
// import net.minecraft.class_2338;
// import net.minecraft.class_2350;
// import net.minecraft.class_2464;
// import net.minecraft.class_259;
// import net.minecraft.class_265;
// import net.minecraft.class_2680;
// import net.minecraft.class_2741;
// import net.minecraft.class_2758;
// import net.minecraft.class_2769;
// import net.minecraft.class_3218;
// import net.minecraft.class_3486;
// import net.minecraft.class_3609;
// import net.minecraft.class_3610;
// import net.minecraft.class_3611;
// import net.minecraft.class_3612;
// import net.minecraft.class_3726;
// import net.minecraft.class_2689.class_2690;
// import net.minecraft.class_47.class_48;
// import net.minecraft.class_4970.class_2251;
// import net.minecraft.tag.FluidTags;
//
// public class CustomFluidBlock extends class_2248 implements class_2263 {
// public static final class_2758 LEVEL;
// protected final class_3609 fluid;
// private final List<class_3610> statesByLevel;
// public static final class_265 COLLISION_SHAPE;
//
// public CustomFluidBlock(class_3609 fluid, class_2251 settings) {
// super(settings);
// this.fluid = fluid;
// this.statesByLevel = Lists.newArrayList();
// this.statesByLevel.add(fluid.method_15729(false));
//
// for (int i = 1; i < 8; ++i) {
// this.statesByLevel.add(fluid.method_15728(8 - i, false));
// }
//
// this.statesByLevel.add(fluid.method_15728(8, true));
// this.method_9590((class_2680) ((class_2680)
// this.field_10647.method_11664()).method_11657(LEVEL, 0));
// }
//
// public class_265 method_9549(class_2680 state, class_1922 world, class_2338
// pos, class_3726 context) {
// return context.method_16192(COLLISION_SHAPE, pos, true) && (Integer)
// state.method_11654(LEVEL) == 0
// && context.method_27866(world.method_8316(pos.method_10084()), this.fluid)
// ? COLLISION_SHAPE
// : class_259.method_1073();
// }
//
// public boolean method_9542(class_2680 state) {
// return state.method_26227().method_15773();
// }
//
// public void method_9514(class_2680 state, class_3218 world, class_2338 pos,
// Random random) {
// state.method_26227().method_15757(world, pos, random);
// }
//
// public boolean method_9579(class_2680 state, class_1922 world, class_2338
// pos) {
// return false;
// }
//
// public boolean method_9516(class_2680 state, class_1922 world, class_2338
// pos, NavigationType type) {
// return !this.fluid.method_15791(FluidTags.WATER);
// }
//
// public class_3610 method_9545(class_2680 state) {
// int i = (Integer) state.method_11654(LEVEL);
// return (class_3610) this.statesByLevel.get(Math.min(i, 8));
// }
//
// @Environment(EnvType.CLIENT)
// public boolean method_9522(class_2680 state, class_2680 stateFrom, class_2350
// direction) {
// return stateFrom.method_26227().method_15772().method_15780(this.fluid);
// }
//
// public class_2464 method_9604(class_2680 state) {
// return class_2464.field_11455;
// }
//
// public List<class_1799> method_9560(class_2680 state, class_48 builder) {
// return Collections.emptyList();
// }
//
// public class_265 method_9530(class_2680 state, class_1922 world, class_2338
// pos, class_3726 context) {
// return class_259.method_1073();
// }
//
// public void method_9615(class_2680 state, class_1937 world, class_2338 pos,
// class_2680 oldState, boolean notify) {
// if (this.receiveNeighborFluids(world, pos, state)) {
// world.method_8405().method_8676(pos, state.method_26227().method_15772(),
// this.fluid.method_15789(world));
// }
//
// }
//
// public class_2680 method_9559(class_2680 state, class_2350 direction,
// class_2680 neighborState, class_1936 world,
// class_2338 pos, class_2338 neighborPos) {
// if (state.method_26227().method_15771() ||
// neighborState.method_26227().method_15771()) {
// world.method_8405().method_8676(pos, state.method_26227().method_15772(),
// this.fluid.method_15789(world));
// }
//
// return super.method_9559(state, direction, neighborState, world, pos,
// neighborPos);
// }
//
// public void method_9612(class_2680 state, class_1937 world, class_2338 pos,
// class_2248 block, class_2338 fromPos,
// boolean notify) {
// if (this.receiveNeighborFluids(world, pos, state)) {
// world.method_8405().method_8676(pos, state.method_26227().method_15772(),
// this.fluid.method_15789(world));
// }
//
// }
//
// private boolean receiveNeighborFluids(class_1937 world, class_2338 pos,
// class_2680 state) {
// if (this.fluid.method_15791(class_3486.field_15518)) {
// boolean bl =
// world.method_8320(pos.method_10074()).method_27852(class_2246.field_22090);
// class_2350[] var5 = class_2350.values();
// int var6 = var5.length;
//
// for (int var7 = 0; var7 < var6; ++var7) {
// class_2350 direction = var5[var7];
// if (direction != class_2350.field_11033) {
// class_2338 blockPos = pos.method_10093(direction);
// if (world.method_8316(blockPos).method_15767(class_3486.field_15517)) {
// class_2248 block = world.method_8316(pos).method_15771()
// ? class_2246.field_10540
// : class_2246.field_10445;
// world.method_8501(pos, block.method_9564());
// this.playExtinguishSound(world, pos);
// return false;
// }
//
// if (bl && world.method_8320(blockPos).method_27852(class_2246.field_10384)) {
// world.method_8501(pos, class_2246.field_22091.method_9564());
// this.playExtinguishSound(world, pos);
// return false;
// }
// }
// }
// }
//
// return true;
// }
//
// private void playExtinguishSound(class_1936 world, class_2338 pos) {
// world.method_20290(1501, pos, 0);
// }
//
// protected void method_9515(class_2690<class_2248, class_2680> builder) {
// builder.method_11667(new class_2769[]{LEVEL});
// }
//
// public class_3611 method_9700(class_1936 world, class_2338 pos, class_2680
// state) {
// if ((Integer) state.method_11654(LEVEL) == 0) {
// world.method_8652(pos, class_2246.field_10124.method_9564(), 11);
// return this.fluid;
// } else {
// return class_3612.field_15906;
// }
// }
//
// static {
// LEVEL = class_2741.field_12538;
// COLLISION_SHAPE = class_2248.method_9541(0.0D, 0.0D, 0.0D, 16.0D, 8.0D,
// 16.0D);
// }
// }