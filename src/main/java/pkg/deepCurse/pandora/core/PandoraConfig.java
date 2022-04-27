package pkg.deepCurse.pandora.core;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class PandoraConfig {

	public static File getConfigFile() {
		return new File(FabricLoader.getInstance().getConfigDir().toFile(),
				"pandora.toml");
	}

	public static CommentedFileConfig config = CommentedFileConfig
			.builder(getConfigFile()).autosave()
			.defaultResource("/assets/pandora/pandora.toml")
			.preserveInsertionOrder().build();
	
	public static boolean lambDynLightsIsPresent = FabricLoader.getInstance()
			.isModLoaded("lambdynlights");
	
	/**
	 * <pre>
	 * GRONDAGS DARKNESS
	 * public static boolean enableCustomFog;
	 * public static boolean enableEndFog;
	 * public static boolean enableNetherFog;
	 * public static boolean enableOverworldFog;
	 * GRUES
	 * public static boolean gruesCanEatItems;
	 * public static boolean gruesOnlyAttackPlayers;
	 * public static boolean gruesCanAttackAnimals;
	 * public static boolean gruesCanAttackVillagers;
	 * public static boolean gruesCanAttackHostileMobs;
	 * public static boolean gruesCanAttackBossMobs;
	 * public static boolean gruesCanAttackInWater;
	 * public static boolean hardcoreAffectsOtherMobs;
	 * public static int grueAttackLightLevelMaximum;
	 * DARKNESS
	 * public static boolean villagersFearDarkness;
	 * public static boolean passiveFearDarkness;
	 * public static boolean hostileMobsFearDarkness;
	 * GAMMA
	 * public static boolean resetGamma;
	 * public static double defaultGammaValue;
	 * DEBUG
	 * public static boolean accelerateTorchDeath;
	 * public static boolean resetGrueAttackChance;
	 * </pre>
	 */
	private static HashMap<String, Object> configMap = new HashMap<>();
	/**
	 * valid keys are:
	 * 
	 * <pre>
	 * MOD DETECTION :
	 * bool		: lambDynLightsIsPresent
	 * 
	 * DEBUG VALUES :
	 * 
	 * bool		: resetGrueAttackChance
	 * bool		: accelerateTorchDeath
	 * 
	 * TOML CONFIG :
	 * 
	 * bool		: enableCustomFog
	 * bool		: enableEndFog
	 * bool		: enableNetherFog
	 * bool		: enableOverworldFog
	 * bool		: gruesCanEatItems
	 * bool		: gruesOnlyAttackPlayers
	 * bool		: gruesCanAttackAnimals
	 * bool		: gruesCanAttackVillagers
	 * bool		: gruesCanAttackHostileMobs
	 * bool		: gruesCanAttackBossMobs
	 * bool		: gruesCanAttackInWater
	 * bool		: hardcoreAffectsOtherMobs
	 * int		: grueAttackLightLevelMaximum
	 * bool		: villagersFearDarkness
	 * bool		: passiveFearDarkness
	 * bool		: hostileMobsFearDarkness
	 * bool		: resetGamma
	 * double		: defaultGammaValue
	 * Identifier[]	: grueWards
	 * Identifier[]	: blacklistedEntityType
	 * </pre>
	 */
	public static void setConfigValue(String key, Object b) {
		if (key.startsWith("F$") && key.contains(key)) {
			throw new IllegalStateException("[cursebox] Key: " + key
					+ " is final, and may not be changed after it is set. . .");
		}
		configMap.put(key, b);
	}

	public static Object getConfigValue(String key) {
		try {
			if (!configMap.containsKey(key)) {
				return null;
			}
			return configMap.get(key);
		} catch (Exception e) {
			return null;
		}
	}

	public static void loadConfig(File configFile) {

		config.load();

		// grondag.fog
		setConfigValue("enableCustomFog",
				config.getOrElse("grondag.fog.enableCustomFog", true));
		setConfigValue("enableEndFog",
				config.getOrElse("grondag.fog.enableEndFog", false));
		setConfigValue("enableNetherFog",
				config.getOrElse("grondag.fog.enableNetherFog", true));
		setConfigValue("enableOverworldFog",
				config.getOrElse("grondag.fog.enableOverworldFog", true));
		// grues
		setConfigValue("gruesCanEatItems",
				config.getOrElse("grues.gruesCanEatItems", true));
		setConfigValue("gruesOnlyAttackPlayers",
				config.getOrElse("grues.gruesOnlyAttackPlayers", true));
		setConfigValue("gruesCanAttackAnimals",
				config.getOrElse("grues.gruesCanAttackAnimals", false));
		setConfigValue("gruesCanAttackVillagers",
				config.getOrElse("grues.gruesCanAttackVillagers", true));
		setConfigValue("gruesCanAttackHostileMobs",
				config.getOrElse("grues.gruesCanAttackHostileMobs", false));
		setConfigValue("gruesCanAttackBossMobs",
				config.getOrElse("grues.gruesCanAttackBossMobs", false));
		setConfigValue("gruesCanAttackInWater",
				config.getOrElse("grues.gruesCanAttackInWater", false));
		setConfigValue("hardcoreAffectsOtherMobs",
				config.getOrElse("grues.hardcoreAffectsOtherMobs", false));
		setConfigValue("grueAttackLightLevelMaximum",
				config.getOrElse("grues.grueAttackLightLevelMaximum", 2));
		// darkness
		setConfigValue("villagersFearDarkness",
				config.getOrElse("darkness.villagersFearDarkness", true));
		setConfigValue("passiveFearDarkness",
				config.getOrElse("darkness.passiveFearDarkness", false));
		setConfigValue("hostileMobsFearDarkness",
				config.getOrElse("darkness.hostileMobsFearDarkness", false));
		// gamma
		setConfigValue("resetGamma",
				config.getOrElse("darkness.resetGamma", true));
		setConfigValue("defaultGammaValue",
				config.getOrElse("darkness.defaultGammaValue", 1.0));
	}
	// public static void loadConfig() {
	//
	// config.load();
	//
	// // fog
	// enableCustomFog = config.getOrElse(
	// Arrays.asList(new String[]{"fog", "enableCustomFog"}), true);
	// enableEndFog = config.getOrElse("fog.enableEndFog", false);
	// enableNetherFog = config.getOrElse("fog.enableNetherFog", true);
	// enableOverworldFog = config.getOrElse("fog.enableOverworldFog", true);
	// // grues
	// gruesCanEatItems = config.getOrElse("grues.gruesCanEatItems", true);
	// gruesOnlyAttackPlayers = config
	// .getOrElse("grues.gruesOnlyAttackPlayers", true);
	// gruesCanAttackAnimals = config.getOrElse("grues.gruesCanAttackAnimals",
	// false);
	// gruesCanAttackVillagers = config
	// .getOrElse("grues.gruesCanAttackVillagers", true);
	// gruesCanAttackHostileMobs = config
	// .getOrElse("grues.gruesCanAttackHostileMobs", false);
	// gruesCanAttackBossMobs = config
	// .getOrElse("grues.gruesCanAttackBossMobs", false);
	// gruesCanAttackInWater = config.getOrElse("grues.gruesCanAttackInWater",
	// false);
	// hardcoreAffectsOtherMobs = config
	// .getOrElse("grues.hardcoreAffectsOtherMobs", false);
	// grueAttackLightLevelMaximum = config
	// .getOrElse("grues.grueAttackLightLevelMaximum", 2);
	// grueWards = config.getOrElse("grues.grueWards",
	// new Identifier[]{new Identifier("minecraft:torch"),
	// new Identifier("minecraft:soul_torch")});
	// blacklistedEntityType = config.getOrElse("grues.blacklistedEntityType",
	// new Identifier[]{new Identifier("minecraft:ender_dragon")});
	// // darkness
	// villagersFearDarkness = config
	// .getOrElse("darkness.villagersFearDarkness", true);
	// passiveFearDarkness = config.getOrElse("darkness.passiveFearDarkness",
	// false);
	// hostileMobsFearDarkness = config
	// .getOrElse("darkness.hostileMobsFearDarkness", false);
	// // gamma
	// resetGamma = config.getOrElse("darkness.resetGamma", true);
	// defaultGammaValue = config.getOrElse("darkness.defaultGammaValue", 1.0);
	// }

	public static boolean isDynamicLightingEnabled() {
		 return lambDynLightsIsPresent;
	}

	public static void saveConfigs() {

		config.set("grondag.fog.enableCustomFog", enableCustomFog);
		config.set("grondag.fog.enableEndFog", enableEndFog);
		config.set("grondag.fog.enableOverworldFog", enableOverworldFog);
		config.set("grondag.fog.enableNetherFog", enableNetherFog);
		config.set("grues.gruesCanAttackAnimals", gruesCanAttackAnimals);
		config.set("grues.gruesCanEatItems", gruesCanEatItems);

		config.save();
	}

}
