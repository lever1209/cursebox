package pkg.deepCurse.pandora.core;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import net.fabricmc.loader.api.FabricLoader;

public class PandoraConfig {

	public static File getConfigFile() {
		return new File(FabricLoader.getInstance().getConfigDir().toFile(),
				"pandora.toml");
	}

	public static CommentedFileConfig config = CommentedFileConfig
			.builder(getConfigFile()).autosave()
			.defaultResource("/assets/pandora/pandora.toml").build();

	// integration
	public static boolean lambDynLightsIsPresent = FabricLoader.getInstance()
			.isModLoaded("lambdynlights");
	// grondags darkness
	public static boolean enableCustomFog;
	public static boolean enableEndFog;
	public static boolean enableNetherFog;
	public static boolean enableOverworldFog;
	// TODO identifier:String[] for modded dimensions
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
	public static boolean animalsFearDarkness;
	public static boolean hostileMobsFearDarkness;
	// gamma
	public static boolean resetGamma;
	public static double defaultGammaValue = config.getOrElse("darkness.defaultGammaValue", 1.0);
	// debug
	public static boolean accelerateTorchDeath;
	public static boolean resetGrueAttackChance;

	public static List<String> grueWards;
	public static List<String> blacklistedEntityType;

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
		grueWards = config.getOrElse("grues.grueWards",
				Arrays.asList(new String[]{"minecraft:torch"}));
		blacklistedEntityType = config.getOrElse("grues.blacklistedEntityType",
				Arrays.asList(new String[]{"minecraft:skeleton"}));
		// darkness
		villagersFearDarkness = config
				.getOrElse("darkness.villagersFearDarkness", true);
		animalsFearDarkness = config.getOrElse("darkness.animalsFearDarkness",
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

	public static void saveConfigs() {

		config.set("grues.grueWards", grueWards);

		config.save();
	}

	public static void newConfig() {
		config = CommentedFileConfig.builder(getConfigFile()).autosave()
				.defaultResource("/assets/pandora/pandora.toml")
				.preserveInsertionOrder().build();
	}

}

// package pkg.deepCurse.pandora.core;
//
// import java.io.File;
// import java.util.Arrays;
// import java.util.HashMap;
//
// import com.electronwill.nightconfig.core.file.CommentedFileConfig;
//
// import net.fabricmc.loader.api.FabricLoader;
// import net.minecraft.entity.EntityType;
// import net.minecraft.item.Item;
// import net.minecraft.item.Items;
// import net.minecraft.util.Identifier;
//
// public class PandoraConfig {
//
// public static File getConfigFile() {
// return new File(FabricLoader.getInstance().getConfigDir().toFile(),
// "pandora.toml");
// }
//
// public static CommentedFileConfig config = CommentedFileConfig
// .builder(getConfigFile()).autosave()
// .defaultResource("/assets/pandora/pandora.toml")
// .preserveInsertionOrder().build();
//
// public static boolean lambDynLightsIsPresent = FabricLoader.getInstance()
// .isModLoaded("lambdynlights");
//
// /**
// * <pre>
// * GRONDAGS DARKNESS
// * public static boolean enableCustomFog;
// * public static boolean enableEndFog;
// * public static boolean enableNetherFog;
// * public static boolean enableOverworldFog;
// * GRUES
// * public static boolean gruesCanEatItems;
// * public static boolean gruesOnlyAttackPlayers;
// * public static boolean gruesCanAttackAnimals;
// * public static boolean gruesCanAttackVillagers;
// * public static boolean gruesCanAttackHostileMobs;
// * public static boolean gruesCanAttackBossMobs;
// * public static boolean gruesCanAttackInWater;
// * public static boolean hardcoreAffectsOtherMobs;
// * public static int grueAttackLightLevelMaximum;
// * DARKNESS
// * public static boolean villagersFearDarkness;
// * public static boolean passiveFearDarkness;
// * public static boolean hostileMobsFearDarkness;
// * GAMMA
// * public static boolean resetGamma;
// * public static double defaultGammaValue;
// * DEBUG
// * public static boolean accelerateTorchDeath;
// * public static boolean resetGrueAttackChance;
// * </pre>
// */
// private static HashMap<String, Object> configMap = new HashMap<>();
// /**
// * valid keys are:
// *
// * <pre>
// * MOD DETECTION :
// * bool : lambDynLightsIsPresent
// *
// * DEBUG VALUES :
// *
// * bool : resetGrueAttackChance
// * bool : accelerateTorchDeath
// *
// * TOML CONFIG :
// *
// * bool : enableCustomFog
// * bool : enableEndFog
// * bool : enableNetherFog
// * bool : enableOverworldFog
// * bool : gruesCanEatItems
// * bool : gruesOnlyAttackPlayers
// * bool : gruesCanAttackAnimals
// * bool : gruesCanAttackVillagers
// * bool : gruesCanAttackHostileMobs
// * bool : gruesCanAttackBossMobs
// * bool : gruesCanAttackInWater
// * bool : hardcoreAffectsOtherMobs
// * int : grueAttackLightLevelMaximum
// * bool : villagersFearDarkness
// * bool : passiveFearDarkness
// * bool : hostileMobsFearDarkness
// * bool : resetGamma
// * double : defaultGammaValue
// * Identifier[] : grueWards
// * Identifier[] : blacklistedEntityType
// * </pre>
// */
// public static void setConfigValue(String key, Object b) {
// if (key.startsWith("F$") && key.contains(key)) {
// throw new IllegalStateException("[cursebox] Key: " + key
// + " is final, and may not be changed after it is set. . .");
// }
// configMap.put(key, b);
// }
//
// public static <T> T getConfigValue(String key) {
// try {
// if (!configMap.containsKey(key)) {
// return null;
// }
// return (T) configMap.get(key);
// } catch (Exception e) {
// return null;
// }
// }
//
// public static void loadConfig() {
//
// config.load();
//
// // grondag.fog
// setConfigValue("grondag.fog.enableCustomFog",
// config.getOrElse("grondag.fog.enableCustomFog", true));
// setConfigValue("grondag.fog.enableEndFog",
// config.getOrElse("grondag.fog.enableEndFog", false));
// setConfigValue("grondag.fog.enableNetherFog",
// config.getOrElse("grondag.fog.enableNetherFog", true));
// setConfigValue("grondag.fog.enableOverworldFog",
// config.getOrElse("grondag.fog.enableOverworldFog", true));
// // grues
// setConfigValue("grues.gruesCanEatItems",
// config.getOrElse("grues.gruesCanEatItems", true));
// setConfigValue("grues.gruesOnlyAttackPlayers",
// config.getOrElse("grues.gruesOnlyAttackPlayers", true));
// setConfigValue("grues.gruesCanAttackAnimals",
// config.getOrElse("grues.gruesCanAttackAnimals", false));
// setConfigValue("grues.gruesCanAttackVillagers",
// config.getOrElse("grues.gruesCanAttackVillagers", true));
// setConfigValue("grues.gruesCanAttackHostileMobs",
// config.getOrElse("grues.gruesCanAttackHostileMobs", false));
// setConfigValue("grues.gruesCanAttackBossMobs",
// config.getOrElse("grues.gruesCanAttackBossMobs", false));
// setConfigValue("grues.gruesCanAttackInWater",
// config.getOrElse("grues.gruesCanAttackInWater", false));
// setConfigValue("grues.hardcoreAffectsOtherMobs",
// config.getOrElse("grues.hardcoreAffectsOtherMobs", false));
// setConfigValue("grues.grueAttackLightLevelMaximum",
// config.getOrElse("grues.grueAttackLightLevelMaximum", 2));
// // darkness
// setConfigValue("darkness.villagersFearDarkness",
// config.getOrElse("darkness.villagersFearDarkness", true));
// setConfigValue("darkness.passiveFearDarkness",
// config.getOrElse("darkness.passiveFearDarkness", false));
// setConfigValue("darkness.hostileMobsFearDarkness",
// config.getOrElse("darkness.hostileMobsFearDarkness", false));
// // gamma
// setConfigValue("gamma.resetGamma",
// config.getOrElse("darkness.resetGamma", true));
// setConfigValue("gamma.defaultGammaValue",
// config.getOrElse("darkness.defaultGammaValue", 1.0));
// }
// // public static void loadConfig() {
// //
// // config.load();
// //
// // // fog
// // enableCustomFog = config.getOrElse(
// // Arrays.asList(new String[]{"fog", "enableCustomFog"}), true);
// // enableEndFog = config.getOrElse("fog.enableEndFog", false);
// // enableNetherFog = config.getOrElse("fog.enableNetherFog", true);
// // enableOverworldFog = config.getOrElse("fog.enableOverworldFog", true);
// // // grues
// // gruesCanEatItems = config.getOrElse("grues.gruesCanEatItems", true);
// // gruesOnlyAttackPlayers = config
// // .getOrElse("grues.gruesOnlyAttackPlayers", true);
// // gruesCanAttackAnimals = config.getOrElse("grues.gruesCanAttackAnimals",
// // false);
// // gruesCanAttackVillagers = config
// // .getOrElse("grues.gruesCanAttackVillagers", true);
// // gruesCanAttackHostileMobs = config
// // .getOrElse("grues.gruesCanAttackHostileMobs", false);
// // gruesCanAttackBossMobs = config
// // .getOrElse("grues.gruesCanAttackBossMobs", false);
// // gruesCanAttackInWater = config.getOrElse("grues.gruesCanAttackInWater",
// // false);
// // hardcoreAffectsOtherMobs = config
// // .getOrElse("grues.hardcoreAffectsOtherMobs", false);
// // grueAttackLightLevelMaximum = config
// // .getOrElse("grues.grueAttackLightLevelMaximum", 2);
// // grueWards = config.getOrElse("grues.grueWards",
// // new Identifier[]{new Identifier("minecraft:torch"),
// // new Identifier("minecraft:soul_torch")});
// // blacklistedEntityType = config.getOrElse("grues.blacklistedEntityType",
// // new Identifier[]{new Identifier("minecraft:ender_dragon")});
// // // darkness
// // villagersFearDarkness = config
// // .getOrElse("darkness.villagersFearDarkness", true);
// // passiveFearDarkness = config.getOrElse("darkness.passiveFearDarkness",
// // false);
// // hostileMobsFearDarkness = config
// // .getOrElse("darkness.hostileMobsFearDarkness", false);
// // // gamma
// // resetGamma = config.getOrElse("darkness.resetGamma", true);
// // defaultGammaValue = config.getOrElse("darkness.defaultGammaValue", 1.0);
// // }
//
// public static boolean isDynamicLightingEnabled() {
// return lambDynLightsIsPresent;
// }
//
// public static void saveConfigs() {
//
// for (String i : configMap.keySet()) {
// config.set(i, getConfigValue(i));
// }
//
// config.save();
// }
//
// public static void newConfig() {
// config = CommentedFileConfig.builder(getConfigFile()).autosave()
// .defaultResource("/assets/pandora/pandora.toml")
// .preserveInsertionOrder().build();
// }
//
// }
