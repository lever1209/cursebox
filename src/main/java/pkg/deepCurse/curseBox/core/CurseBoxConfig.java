package pkg.deepCurse.curseBox.core;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import net.fabricmc.loader.api.FabricLoader;

public class CurseBoxConfig {

	public static File getConfigFile() {
		return new File(FabricLoader.getInstance().getConfigDir().toFile(),
				"cursebox.toml");
	}
	
	public static CommentedFileConfig config = CommentedFileConfig
			.builder(getConfigFile()).autosave()
			.defaultResource("/assets/cursebox/cursebox.toml").build();
	
	// integration
	public static boolean lambDynLightsIsPresent = FabricLoader.getInstance().isModLoaded("lambdynlights");
	// grondags darkness
	public static boolean enableCustomFog;
	public static boolean enableEndFog;
	public static boolean enableNetherFog;
	public static boolean enableOverworldFog;
	// grues
	public static boolean gruesCanEatItems;
	public static boolean gruesOnlyAttackPlayers;
	public static boolean gruesCanAttackAnimals;
	public static boolean gruesCanAttackVillagers;
	public static boolean gruesCanAttackHostileMobs;
	public static boolean gruesCanAttackBossMobs;
	public static boolean gruesCanAttackInWater;
	public static boolean hardcoreAffectsOtherMobs;
	public static int grueAttackLightLevelMaximum;
	// darkness
	public static boolean villagersFearDarkness;
	public static boolean passiveFearDarkness;
	public static boolean hostileMobsFearDarkness;
	// gamma
	public static boolean resetGamma;
	public static double defaultGammaValue;
	// debug
	public static boolean accelerateTorchDeath;
	public static boolean resetGrueAttackChance;

	public static void loadConfig() {

		config.load();
		
		// grondag.fog
		enableCustomFog = config.getOrElse("grondag.fog.enableCustomFog", true);
		enableEndFog = config.getOrElse("grondag.fog.enableEndFog", false);
		enableNetherFog = config.getOrElse("grondag.fog.enableNetherFog", true);
		enableOverworldFog = config.getOrElse("grondag.fog.enableOverworldFog",
				true);
		// grues
		gruesCanEatItems = config.getOrElse("grues.gruesCanEatItems", true);
		gruesOnlyAttackPlayers = config
				.getOrElse("grues.gruesOnlyAttackPlayers", true);
		gruesCanAttackAnimals = config.getOrElse("grues.gruesCanAttackAnimals",
				false);
		gruesCanAttackVillagers = config
				.getOrElse("grues.gruesCanAttackVillagers", true);
		gruesCanAttackHostileMobs = config
				.getOrElse("grues.gruesCanAttackHostileMobs", false);
		gruesCanAttackBossMobs = config
				.getOrElse("grues.gruesCanAttackBossMobs", false);
		gruesCanAttackInWater = config.getOrElse("grues.gruesCanAttackInWater",
				false);
		hardcoreAffectsOtherMobs = config
				.getOrElse("grues.hardcoreAffectsOtherMobs", false);
		grueAttackLightLevelMaximum = config
				.getOrElse("grues.grueAttackLightLevelMaximum", 2);
		// darkness
		villagersFearDarkness = config
				.getOrElse("darkness.villagersFearDarkness", true);
		passiveFearDarkness = config.getOrElse("darkness.passiveFearDarkness",
				false);
		hostileMobsFearDarkness = config
				.getOrElse("darkness.hostileMobsFearDarkness", false);
		// gamma
		resetGamma = config.getOrElse("darkness.resetGamma", true);
		defaultGammaValue = config.getOrElse("darkness.defaultGammaValue", 1.0);
	}

	public static boolean isDynamicLightingEnabled() {
		return lambDynLightsIsPresent;
	}
	
	
	
}
