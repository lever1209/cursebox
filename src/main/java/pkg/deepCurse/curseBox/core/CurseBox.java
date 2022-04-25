package pkg.deepCurse.curseBox.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class CurseBox implements ModInitializer {

	public static boolean debug = true;

	public static final Logger LOGGER = LogManager
			.getLogger(CurseBox.class.getSimpleName());

	public static File configFile;

	static {
		LOGGER.info(debug ? "[cursebox] class init" : "");

		loadConfig();
	}

	// FOG
	public static boolean enableCustomFog; // true
	public static boolean enableEndFog; // false
	public static boolean enableNetherFog; // true
	public static boolean enableOverworldFog; // true

	// GRUES
	public static boolean gruesCanEatItems; // true
	public static boolean resetGrueAttackChance; // false
	public static boolean gruesOnlyAttackPlayers; // false
	public static boolean gruesCanAttackAnimals; // false
	public static boolean gruesCanAttackVillagers; // true
	public static boolean gruesCanAttackHostileMobs; // false
	public static boolean gruesCanAttackBossMobs; // false
	public static boolean gruesCanAttackInWater; // false
	public static boolean hardcoreAffectsOtherMobs; // false
	public static int grueAttackLightLevelMaximum; // 2

	// DARKNESS
	public static boolean villagersFearDarkness; // true
	public static boolean passiveFearDarkness; // false
	public static boolean hostileMobsFearDarkness; // false

	// GAMMA
	public static boolean resetGamma; // true
	public static double defaultGammaValue; // 1.0

	// LIGHT BLOCKS
	public static boolean accelerateTorchDeath; // false

	// public static Properties properties = new Properties();

	@Override
	public void onInitialize() {

		// Toml toml = new Toml().read(configFile);
		//// String name = toml.getString("name");
		//// Long port = toml.getLong("server.ip"); // compound key. Is
		// equivalent
		//// // to:
		//// Long port2 = toml.getTable("server").getLong("ip");
		//
		// Builder builder = new Builder();
		//
		//
		//
		// TomlWriter writer = new TomlWriter();

		// writer.write(toml, configFile);

		if (debug) {
			LOGGER.info(
					"[cursebox] HEY DUMBASS, MAKE SURE YOUR MIXINS ARE LISTED IN THE MIXIN FILE (i have wasted <14.4> hour(s) because i forgot to add it to mixins)");
		}
		if (resetGamma) {
			LOGGER.warn(
					"[cursebox] THIS MOD WILL RESET YOUR BRIGHTESS TO MAX ON BOOT UNLESS YOU DISABLE IT IN CONFIG (its basically a requirement, and the whole stigma about it being cheating or whatever doesnt matter because of grondags true darkness)");
		}
		LOGGER.info("[cursebox] Initializing. . .");
		LOGGER.info("[cursebox] Initializing Registers. . .");
		// CurseBoxObjectRegister cursedObjects = new CurseBoxObjectRegister();
		LOGGER.info("[cursebox] Initializing items. . .");
		// cursedObjects.itemRegister();
		LOGGER.info("[cursebox] Initializing blocks. . .");
		// cursedObjects.blockRegister();
		LOGGER.info("[cursebox] Initializing logic. . .");
		LOGGER.info("[cursebox] Registering fuel sources. . .");
		// FuelRegistry.INSTANCE.add(cursedObjects.TEXTURED_BLOCK, 67);
		LOGGER.info("[cursebox] Loaded and ready. . .");
		// LOGGER.info("[cursebox] config values : " + properties);

	}

	public static boolean loadConfig() {
		configFile = getConfigFile();
		if (!configFile.exists()) {
			LOGGER.info("[cursebox] creating config");
			if (!fixConfigFile()) {
				LOGGER.error(
						"[cursebox] Unable to read or create the config file, something has gone horribly wrong, loading default values");
				CurseBoxConfig.loadDefaultValues();
				return false;
			}
		}
		LOGGER.info("[cursebox] config loaded");
		CurseBoxConfig.loadValuesFromFile(configFile);
		return true;
	}

	private static File getConfigFile() {
		return new File(FabricLoader.getInstance().getConfigDir().toFile(),
				"cursebox.toml");
	}

	private static boolean fixConfigFile() {
		try {

			if (configFile.isDirectory()) {
				if (configFile.listFiles().length <= 0) {
					configFile.delete();
				}
			}

			FileWriter writer = new FileWriter(configFile);
			// BufferedReader reader = new BufferedReader(
			// // InputStreamReader reader =
			// new InputStreamReader());

			String url = CurseBox.class
					.getResource("/assets/cursebox/cursebox.toml").toString();
			LOGGER.info(url.toString());
//			InputStream is = new FileInputStream();
//
//			for (int t; (t = is.read()) != -1;) {
//				writer.write(t);
//			}
//
//			writer.close();
//			writer.flush();
//			is.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// LOGGER.error(e);
			return false;
		}
	}

	// public static void saveConfig() {
	// File configFile = getConfigFile();
	// Properties properties = new Properties();
	// properties.put("log_debug_messages", Boolean.toString(debug));
	// // properties.put("enable_dynamic_lighting",
	// // Boolean.toString(enableDynamicLighting));
	// properties.put("reset_gamma", Boolean.toString(resetGamma));
	// properties.put("default_gamma_value",
	// Double.toString(defaultGammaValue));
	// properties.put("grues_can_eat_items",
	// Boolean.toString(gruesCanEatItems));
	// properties.put("grues_can_attack_animals",
	// Boolean.toString(gruesCanAttackAnimals));
	// properties.put("grues_can_attack_hostile_mobs",
	// Boolean.toString(gruesCanAttackHostileMobs));
	// properties.put("grues_can_attack_villagers",
	// Boolean.toString(gruesCanAttackVillagers));
	// properties.put("grues_can_attack_in_water",
	// Boolean.toString(gruesCanAttackInWater));
	// properties.put("passive_fear_darkness",
	// Boolean.toString(passiveFearDarkness));
	// properties.put("hostile_mobs_fear_darkness",
	// Boolean.toString(hostileMobsFearDarkness));
	// properties.put("villagers_fear_darkness",
	// Boolean.toString(villagersFearDarkness));
	// properties.put("hardcore_kills_other_mobs",
	// Boolean.toString(hardcoreAffectsOtherMobs));
	// // properties.put("replace_ore_stack_count",
	// // Boolean.toString(replaceOres));
	//
	// try {
	// FileOutputStream stream = new FileOutputStream(configFile);
	//
	// try {
	// properties.store(stream, "Curse Box toml file");
	// } catch (Throwable var6) {
	// try {
	// stream.close();
	// } catch (Throwable var5) {
	// var6.addSuppressed(var5);
	// }
	//
	// throw var6;
	// }
	//
	// stream.close();
	// } catch (IOException var7) {
	// LOGGER.warn("[cursebox] Failed to save toml file '"
	// + configFile.getAbsolutePath() + "'", var7);
	// }
	//
	// }
	//
	// static {
	// if (configFile.exists()) {
	// try {
	// FileInputStream stream = new FileInputStream(configFile);
	//
	// try {
	// properties.load(stream);
	// } catch (Throwable var5) {
	// try {
	// stream.close();
	// } catch (Throwable var4) {
	// var5.addSuppressed(var4);
	// }
	//
	// throw var5;
	// }
	//
	// stream.close();
	// } catch (IOException var6) {
	// LOGGER.warn("[cursebox] Could not read property file '"
	// + configFile.getAbsolutePath() + "'", var6);
	// }
	// }
	//
	// debug = properties.computeIfAbsent("log_debug_messages", (a) -> {
	// return "false";
	// }).equals("true");
	// // enableDynamicLighting = properties
	// // .computeIfAbsent("enable_dynamic_lighting", (a) -> {
	// // return "true";
	// // }).equals("true");
	// resetGamma = properties.computeIfAbsent("reset_gamma", (a) -> {
	// return "true";
	// }).equals("true");
	//
	// try {
	// defaultGammaValue = Double.parseDouble(
	// properties.computeIfAbsent("default_gamma_value", (a) -> {
	// return "1.0";
	// }).toString());
	// defaultGammaValue = MathHelper.clamp(defaultGammaValue, 0.0D, 1.0D);
	// } catch (Exception var3) {
	// defaultGammaValue = 1.0D;
	// }
	//
	// gruesCanEatItems = properties
	// .computeIfAbsent("grues_can_eat_items", (a) -> {
	// return "true";
	// }).equals("true");
	// gruesCanAttackAnimals = properties
	// .computeIfAbsent("grues_can_attack_animals", (a) -> {
	// return "true";
	// }).equals("true");
	// gruesCanAttackHostileMobs = properties
	// .computeIfAbsent("grues_can_attack_hostile_mobs", (a) -> {
	// return "false";
	// }).equals("true");
	// gruesCanAttackVillagers = properties
	// .computeIfAbsent("grues_can_attack_villagers", (a) -> {
	// return "true";
	// }).equals("true");
	// gruesCanAttackInWater = properties
	// .computeIfAbsent("grues_can_attack_in_water", (a) -> {
	// return "true";
	// }).equals("true");
	// passiveFearDarkness = properties
	// .computeIfAbsent("passive_fear_darkness", (a) -> {
	// return "true";
	// }).equals("true");
	// hostileMobsFearDarkness = properties
	// .computeIfAbsent("hostile_mobs_fear_darkness", (a) -> {
	// return "false";
	// }).equals("true");
	// villagersFearDarkness = properties
	// .computeIfAbsent("villagers_fear_darkness", (a) -> {
	// return "true";
	// }).equals("true");
	// hardcoreAffectsOtherMobs = properties
	// .computeIfAbsent("hardcore_kills_other_mobs", (a) -> {
	// return "true";
	// }).equals("true");
	// // replaceOres = properties
	// // .computeIfAbsent("replace_ore_stack_count", (a) -> {
	// // return "false";
	// // }).equals("true");
	// saveConfig();
	// }
}
