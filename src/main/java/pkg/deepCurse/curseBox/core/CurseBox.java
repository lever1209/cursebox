package pkg.deepCurse.curseBox.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class CurseBox implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("cursebox");
	public static boolean enableCustomFog = true;
	public static boolean enableEndFog = true;
	public static boolean enableNetherFog = true;
	public static boolean supremeDebug = false;
	public static boolean resetChance = false;
	public static boolean attackOnlyPlayers = false;
	public static boolean accelerateTorchDeath = false;
	public static int grueAttackLightLevelMaximum = 2;
	public static boolean debug;
	// public static final String debugKey = "log_debug_messages";
	public static boolean enableDynamicLighting;
	// public static final String enableDynamicLightingKey =
	// "enable_dynamic_lighting";
	public static boolean resetGamma;
	// public static final String resetGammaKey = "reset_gamma";
	public static double defaultGammaValue;
	// public static final String defaultGammaValueKey = "default_gamma_value";
	public static boolean gruesCanEatItems;
	// public static final String gruesCanEatItemsKey = "grues_can_eat_items";
	public static boolean gruesCanAttackAnimals;
	// public static final String gruesCanAttackPassiveKey =
	// "grues_can_attack_animals";
	public static boolean gruesCanAttackVillagers;
	// public static final String gruesAttackVillagersKey =
	// "grues_can_attack_villagers";
	public static boolean gruesCanAttackHostileMobs;
	// public static final String gruesCanAttackHostileMobsKey =
	// "grues_can_attack_hostile_mobs";
	public static boolean gruesCanAttackInWater;
	// public static final String gruesAttackInWaterKey =
	// "grues_can_attack_in_water";
	public static boolean villagersFearDarkness;
	// public static final String villagersFearDarknessKey =
	// "villagers_fear_darkness";
	public static boolean passiveFearDarkness;
	// public static final String passiveFearDarknessKey =
	// "passive_fear_darkness";
	public static boolean hostileMobsFearDarkness;
	// public static final String hostileMobsFearDarknessKey =
	// "hostile_mobs_fear_darkness";
	public static boolean hardcoreAffectsOtherMobs;
	// public static final String hardcoreAffectsOtherMobsKey =
	// "hardcore_kills_other_mobs";
	public static boolean replaceOres;
	// public static final String replaceOresKey = "replace_ore_stack_count";
	// public static File configFile = getConfigFile();
	// public static Properties properties = new Properties();

	@Override
	public void onInitialize() {

		LOGGER.info("Init");

		if (debug) {
			LOGGER.info(
					"HEY DUMBASS, MAKE SURE YOUR MIXINS ARE LISTED IN THE MIXIN FILE (i have wasted <13.4> hour(s) because i forgot to add it to mixins)");
		}

		if (resetGamma) {
			LOGGER.warn(
					"THIS MOD WILL RESET YOUR BRIGHTESS TO MAX ON BOOT UNLESS YOU DISABLE IT IN CONFIG (its basically a requirement, and the whole stigma about it being cheating or whatever doesnt matter because of grondags true darkness)");
		}

		LOGGER.info("Initializing. . .");
		LOGGER.info("Initializing Registers. . .");
		// CurseBoxObjectRegister cursedObjects = new CurseBoxObjectRegister();
		LOGGER.info("Initializing items. . .");
		// cursedObjects.itemRegister();
		LOGGER.info("Initializing blocks. . .");
		// cursedObjects.blockRegister();
		LOGGER.info("Initializing logic. . .");
		LOGGER.info("Registering fuel sources. . .");
		// FuelRegistry.INSTANCE.add(cursedObjects.TEXTURED_BLOCK, 67);
		LOGGER.info("Loaded and ready. . .");
		// LOGGER.info("[cursebox] config values : " + properties);

	}

	// private static File getConfigFile() {
	// File configDir = FabricLoader.getInstance().getConfigDir().toFile();
	// if (!configDir.exists()) {
	// LOGGER.warn("[Curse Box] Could not access configuration directory: "
	// + configDir.getAbsolutePath());
	// }
	//
	// return new File(configDir, "cursebox.properties");
	// }
	//
	// public static void saveConfig() {
	// File configFile = getConfigFile();
	// Properties properties = new Properties();
	// properties.put("log_debug_messages", Boolean.toString(debug));
	// properties.put("enable_dynamic_lighting",
	// Boolean.toString(enableDynamicLighting));
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
	// properties.put("replace_ore_stack_count",
	// Boolean.toString(replaceOres));
	//
	// try {
	// FileOutputStream stream = new FileOutputStream(configFile);
	//
	// try {
	// properties.store(stream, "Curse Box properties file");
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
	// LOGGER.warn("[Curse Box] Could not store property file '"
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
	// LOGGER.warn("[Curse Box] Could not read property file '"
	// + configFile.getAbsolutePath() + "'", var6);
	// }
	// }
	//
	// debug = properties.computeIfAbsent("log_debug_messages", (a) -> {
	// return "false";
	// }).equals("true");
	// enableDynamicLighting = properties
	// .computeIfAbsent("enable_dynamic_lighting", (a) -> {
	// return "true";
	// }).equals("true");
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
	// replaceOres = properties
	// .computeIfAbsent("replace_ore_stack_count", (a) -> {
	// return "false";
	// }).equals("true");
	// saveConfig();
	// }
}
