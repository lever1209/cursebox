package pkg.deepCurse.pandora.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import grondag.darkness.Darkness;
import net.fabricmc.loader.api.FabricLoader;

public class PandoraConfig {

	private static Logger logger = LoggerFactory.getLogger(PandoraConfig.class);

	public static File getConfigFile() {
		return new File(FabricLoader.getInstance().getConfigDir().toFile(),
				"pandora.toml");
	}

	public static CommentedFileConfig config = CommentedFileConfig
			.builder(getConfigFile()).autosave().preserveInsertionOrder()
			.defaultResource("/assets/pandora/pandora.toml").build();

	// integration
	public static boolean lambDynLightsIsPresent = FabricLoader.getInstance()
			.isModLoaded("lambdynlights");
	// grondags darkness
	public static boolean enabled;
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
	public static double resetGammaValue = config
			.getOrElse("darkness.defaultGammaValue", 1.0);
	// debug
	public static boolean accelerateTorchDeath;
	public static boolean resetGrueAttackChance;

	public static List<String> grueWards;
	public static List<String> blacklistedEntityType;

	public static void loadConfig() {

		config.load();

		// grondag.fog
		Darkness.enabled = config.getOrElse("grondag.fog.enableCustomFog", true);
		Darkness.darkEnd= config.getOrElse("grondag.fog.enableEndFog", false);
		Darkness.darkNether = config.getOrElse("grondag.fog.enableNetherFog", true);
		Darkness.darkOverworld = config.getOrElse("grondag.fog.enableOverworldFog",
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
		resetGammaValue = config.getOrElse("darkness.defaultGammaValue", 1.0);
	}

	public static boolean isDynamicLightingEnabled() {
		return lambDynLightsIsPresent;
	}

	public static void saveConfigs() {

		config.setComment("grondag",
				"# Pandora TOML config\n\n# Settings used by Grondags True Darkness (https://github.com/grondag/darkness)\n# The version bundled with Pandora is modified, and can be obtained from (https://github.com/lever1209/darkness)");
		config.setComment("grondag.fog", " Fog options");
		config.setComment("grondag.fog.enableCustomFog",
				" Enables all custom fog used by Darkness (default: true)");
		config.set("grondag.fog.enableCustomFog", enabled);
		config.setComment("grondag.fog.enableEndFog",
				" Enables custom fog in the End (default: false)");
		config.set("grondag.fog.enableEndFog", enableEndFog);
		config.setComment("grondag.fog.enableNetherFog",
				" Enables custom fog in the Nether (default: true)");
		config.set("grondag.fog.enableNetherFog", enableNetherFog);
		config.setComment("grondag.fog.enableOverworldFog",
				" Enables custom fog in the Overworld (default: true)");
		config.set("grondag.fog.enableOverworldFog", enableOverworldFog);
		config.setComment("grues",
				" Settings relating to the looming threat in the darkness");
		config.setComment("grues.gruesCanEatItems",
				" The chances a grue will eat an item on the ground (default: true)");
		config.set("grues.gruesCanEatItems", gruesCanEatItems);
		config.setComment("grues.gruesOnlyAttackPlayers",
				" Will grues only target players (default: false)");
		config.set("grues.gruesOnlyAttackPlayers", gruesOnlyAttackPlayers);
		config.setComment("grues.gruesCanAttackAnimals",
				" Can grues attack Animals/Passive Entities (default: false)");
		config.set("grues.gruesCanAttackAnimals", gruesCanAttackAnimals);
		config.setComment("grues.gruesCanAttackVillagers",
				" Can grues attack villagers (default: true)");
		config.set("grues.gruesCanAttackVillagers", gruesCanAttackVillagers);
		config.setComment("grues.gruesCanAttackHostileMobs",
				" Can grues attack hostile mobs excluding bosses (default: false)");
		config.set("grues.gruesCanAttackHostileMobs",
				gruesCanAttackHostileMobs);
		config.setComment("grues.gruesCanAttackBossMobs",
				" Can grues attack boss monsters (default: false)");
		config.set("grues.gruesCanAttackBossMobs", gruesCanAttackBossMobs);
		config.setComment("grues.gruesCanAttackInWater",
				" Can grues attack you or any other mob in water (default: false)\n Exploring anything under water becomes almost impossible because water source blocks suck up light\n I recommend leaving this at false");
		config.set("grues.gruesCanAttackInWater", gruesCanAttackInWater);
		config.setComment("grues.hardcoreAffectsOtherMobs", " Can hardcore mode effect other mobs (default: false) Hardcore mode deals 8 damage about every 4 seconds, thats a heart a second regardless of armor type\n I recommend leaving this at false unless you are very familliar with this mod, or have a cheat light source");
		config.set("grues.hardcoreAffectsOtherMobs", hardcoreAffectsOtherMobs);
		config.setComment("grues.grueAttackLightLevelMaximum", " The maximum light level a grue needs to attack you (default: 2)\n this number is tuned for max gamma, darkness/custom fog enabled");
		config.set("grues.grueAttackLightLevelMaximum",
				grueAttackLightLevelMaximum);
		config.setComment("grues.grueWards", " Items you can hold to become mostly immune to grues");
		config.set("grues.grueWards", grueWards);
		config.setComment("darkness", " Settings that change the behavior of the darkness, and whatevers in it");
		config.setComment("darkness.villagersFearDarkness", " Should villagers fear darkness (default: true)");
		config.set("darkness.villagersFearDarkness", villagersFearDarkness);
		config.setComment("darkness.animalsFearDarkness", " Should Animals/Passive mobs fear darkness (default: false)");
		config.set("darkness.animalsFearDarkness", animalsFearDarkness);
		config.setComment("darkness.hostileMobsFearDarkness", " Should hostile mobs fear darkness (default: false)");
		config.set("darkness.hostileMobsFearDarkness", hostileMobsFearDarkness);
		config.setComment("gamma", " Settings to do with how Pandora will modify in game gamma settings");
		config.setComment("gamma.resetGamma", " Should Pandora lock your gamma to the next value (default: true)\n This is recommended to be left at default");
		config.set("gamma.resetGamma", resetGamma);
		config.setComment("gamma.defaultGammaValue", "The default gamma value if resetGamma is true, max value is 1.0 (default: 1.0)");
		config.set("gamma.defaultGammaValue", resetGammaValue);

		config.save();
	}

	public static void newConfig() {
		config = CommentedFileConfig.builder(getConfigFile()).autosave()
				.preserveInsertionOrder().build();
	}

	public static void unpackageConfig() throws IOException {
		logger.info("upackaging config");

		FileWriter writer = new FileWriter(getConfigFile());
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(PandoraConfig.class
						.getResourceAsStream("/assets/pandora/pandora.toml")));

		for (int t; (t = reader.read()) != -1;) {
			writer.write(t);
		}

		writer.close();
		reader.close();
	}

	public static boolean deleteConfig() {
		try {
			getConfigFile().delete();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
