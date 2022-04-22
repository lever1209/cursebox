package pkg.deepCurse.curseBox.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;
import com.moandjiezana.toml.TomlWriter.Builder;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.math.MathHelper;

public class CurseBox implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("cursebox");

	static {
		LOGGER.info("[cursebox] \"CurseBox.class\" LOADED");
	}

	// FOG
	public static boolean enableCustomFog = true;
	public static boolean enableEndFog = true;
	public static boolean enableNetherFog = true;
	public static boolean enableOverworldFog = true;

	// GRUES
	public static boolean gruesCanEatItems;
	public static boolean resetGrueAttackChance;
	public static boolean gruesOnlyAttackPlayers = false;
	public static boolean gruesCanAttackAnimals;
	public static boolean gruesCanAttackVillagers;
	public static boolean gruesCanAttackHostileMobs;
	public static boolean gruesCanAttackInWater;
	public static boolean hardcoreAffectsOtherMobs;
	public static int grueAttackLightLevelMaximum = 2;

	// DARKNESS
	public static boolean villagersFearDarkness;
	public static boolean passiveFearDarkness;
	public static boolean hostileMobsFearDarkness;

	// GAMMA
	public static boolean resetGamma;
	public static double defaultGammaValue;

	// LIGHT BLOCKS
	public static boolean accelerateTorchDeath = false;

	// DEBUG
	public static boolean debug;

	public static boolean enableDynamicLighting; // TODO suggest lamb dynamic
													// lights
	public static boolean replaceOres; // XXX REMOVE OR RELOCATE TO ANOTHER
										// MODLET

	public static File configFile = getConfigFile();
	public static Properties properties = new Properties();

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

		LOGGER.info("Init");

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

	private static File getConfigFile() {
		File configDir = FabricLoader.getInstance().getConfigDir().toFile();
		if (!configDir.exists()) {
			LOGGER.warn("[cursebox] CurseBox cannot read the configs folder: '"
					+ configDir.getAbsolutePath() + "'");
		}

		return new File(configDir, "cursebox.toml");
	}

	public static void saveConfig() {
		File configFile = getConfigFile();
		Properties properties = new Properties();
		properties.put("log_debug_messages", Boolean.toString(debug));
		// properties.put("enable_dynamic_lighting",
		// Boolean.toString(enableDynamicLighting));
		properties.put("reset_gamma", Boolean.toString(resetGamma));
		properties.put("default_gamma_value",
				Double.toString(defaultGammaValue));
		properties.put("grues_can_eat_items",
				Boolean.toString(gruesCanEatItems));
		properties.put("grues_can_attack_animals",
				Boolean.toString(gruesCanAttackAnimals));
		properties.put("grues_can_attack_hostile_mobs",
				Boolean.toString(gruesCanAttackHostileMobs));
		properties.put("grues_can_attack_villagers",
				Boolean.toString(gruesCanAttackVillagers));
		properties.put("grues_can_attack_in_water",
				Boolean.toString(gruesCanAttackInWater));
		properties.put("passive_fear_darkness",
				Boolean.toString(passiveFearDarkness));
		properties.put("hostile_mobs_fear_darkness",
				Boolean.toString(hostileMobsFearDarkness));
		properties.put("villagers_fear_darkness",
				Boolean.toString(villagersFearDarkness));
		properties.put("hardcore_kills_other_mobs",
				Boolean.toString(hardcoreAffectsOtherMobs));
		// properties.put("replace_ore_stack_count",
		// Boolean.toString(replaceOres));

		try {
			FileOutputStream stream = new FileOutputStream(configFile);

			try {
				properties.store(stream, "Curse Box toml file");
			} catch (Throwable var6) {
				try {
					stream.close();
				} catch (Throwable var5) {
					var6.addSuppressed(var5);
				}

				throw var6;
			}

			stream.close();
		} catch (IOException var7) {
			LOGGER.warn("[cursebox] Failed to save toml file '"
					+ configFile.getAbsolutePath() + "'", var7);
		}

	}

	static {
		if (configFile.exists()) {
			try {
				FileInputStream stream = new FileInputStream(configFile);

				try {
					properties.load(stream);
				} catch (Throwable var5) {
					try {
						stream.close();
					} catch (Throwable var4) {
						var5.addSuppressed(var4);
					}

					throw var5;
				}

				stream.close();
			} catch (IOException var6) {
				LOGGER.warn("[cursebox] Could not read property file '"
						+ configFile.getAbsolutePath() + "'", var6);
			}
		}

		debug = properties.computeIfAbsent("log_debug_messages", (a) -> {
			return "false";
		}).equals("true");
		// enableDynamicLighting = properties
		// .computeIfAbsent("enable_dynamic_lighting", (a) -> {
		// return "true";
		// }).equals("true");
		resetGamma = properties.computeIfAbsent("reset_gamma", (a) -> {
			return "true";
		}).equals("true");

		try {
			defaultGammaValue = Double.parseDouble(
					properties.computeIfAbsent("default_gamma_value", (a) -> {
						return "1.0";
					}).toString());
			defaultGammaValue = MathHelper.clamp(defaultGammaValue, 0.0D, 1.0D);
		} catch (Exception var3) {
			defaultGammaValue = 1.0D;
		}

		gruesCanEatItems = properties
				.computeIfAbsent("grues_can_eat_items", (a) -> {
					return "true";
				}).equals("true");
		gruesCanAttackAnimals = properties
				.computeIfAbsent("grues_can_attack_animals", (a) -> {
					return "true";
				}).equals("true");
		gruesCanAttackHostileMobs = properties
				.computeIfAbsent("grues_can_attack_hostile_mobs", (a) -> {
					return "false";
				}).equals("true");
		gruesCanAttackVillagers = properties
				.computeIfAbsent("grues_can_attack_villagers", (a) -> {
					return "true";
				}).equals("true");
		gruesCanAttackInWater = properties
				.computeIfAbsent("grues_can_attack_in_water", (a) -> {
					return "true";
				}).equals("true");
		passiveFearDarkness = properties
				.computeIfAbsent("passive_fear_darkness", (a) -> {
					return "true";
				}).equals("true");
		hostileMobsFearDarkness = properties
				.computeIfAbsent("hostile_mobs_fear_darkness", (a) -> {
					return "false";
				}).equals("true");
		villagersFearDarkness = properties
				.computeIfAbsent("villagers_fear_darkness", (a) -> {
					return "true";
				}).equals("true");
		hardcoreAffectsOtherMobs = properties
				.computeIfAbsent("hardcore_kills_other_mobs", (a) -> {
					return "true";
				}).equals("true");
		// replaceOres = properties
		// .computeIfAbsent("replace_ore_stack_count", (a) -> {
		// return "false";
		// }).equals("true");
		saveConfig();
	}
}
