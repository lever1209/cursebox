package pkg.deepCurse.pandora.core;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

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

	public static Item[] grueWards;
	public static EntityType<?>[] blacklistedEntityType;

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
				new Item[]{Items.TORCH, Items.SOUL_TORCH});
		blacklistedEntityType = config.getOrElse("grues.blacklistedEntityType",
				new EntityType[]{EntityType.ENDER_DRAGON, EntityType.WITHER,
						EntityType.IRON_GOLEM});
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
