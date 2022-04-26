package pkg.deepCurse.curseBox.core;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class CurseBoxTools {
	public static boolean isNearLight(World world, BlockPos pos) {
		return isNearLight(world, pos, CurseBoxConfig.grueAttackLightLevelMaximum);
	}

	public static boolean isNearLight(World world, BlockPos pos, int grueAttackLightLevelMaximum) {
		int blockLightLevel = world.getLightLevel(LightType.BLOCK, pos);
		int skyLightLevel = world.getLightLevel(LightType.SKY, pos);
		if (blockLightLevel >= grueAttackLightLevelMaximum) {
			return true;
		} else {
			if (world.getDimension().hasSkyLight() && skyLightLevel >= grueAttackLightLevelMaximum) {
				float angle = world.getDimension().getSkyAngle(world.getLunarTime());
				if (angle < 0.26F || angle > 0.73F) {
					return true;
				}

				if ((double) world.getMoonSize() > 0.5D) {
					return true;
				}
			}

			return false;
		}
	}
}