package pkg.deepCurse.pandora.core.integrations;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import pkg.deepCurse.pandora.core.PandoraConfig;

public class ModMenuIntegration implements ModMenuApi {
	
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return screen -> createNewConfigScreen(screen);
	}

	public Screen createNewConfigScreen(Screen parent) {
		ConfigBuilder builder = ConfigBuilder.create().setParentScreen(parent)
				.setTitle(new TranslatableText("pandora.config.menu.title"))
				.setSavingRunnable(() -> {
					PandoraConfig.saveConfigs();
				}).setDefaultBackgroundTexture(new Identifier("minecraft",
						"textures/block/cobbled_deepslate.png"));

		ConfigCategory grondag = builder.getOrCreateCategory(
				new TranslatableText("pandora.config.menu.category.grondag"));
		ConfigCategory grues = builder.getOrCreateCategory(
				new TranslatableText("pandora.config.menu.category.grues"));
		ConfigCategory darkness = builder.getOrCreateCategory(
				new TranslatableText("pandora.config.menu.category.darkness"));
		ConfigCategory gamma = builder.getOrCreateCategory(
				new TranslatableText("pandora.config.menu.category.gamma"));

		ConfigEntryBuilder entryBuilder = builder.entryBuilder();

		grondag.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.grondag.enable.custom.fog"),
				PandoraConfig.enableCustomFog)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.grondag.enable.custom.fog.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.enableCustomFog = newValue)
				.setYesNoTextSupplier((bool) -> {
					return new TranslatableText(
							bool ? "options.on" : "options.off");
				}).build());
		grondag.addEntry(entryBuilder
				.startBooleanToggle(new TranslatableText(
						"pandora.config.menu.category.grondag.enable.end.fog"),
						PandoraConfig.enableEndFog)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.grondag.enable.end.fog.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.enableEndFog = newValue)
				.setYesNoTextSupplier((bool) -> {
					return new TranslatableText(
							bool ? "options.on" : "options.off");
				}).build());
		grondag.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.grondag.enable.nether.fog"),
				PandoraConfig.enableNetherFog)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.grondag.enable.nether.fog.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.enableNetherFog = newValue)
				.setYesNoTextSupplier((bool) -> {
					return new TranslatableText(
							bool ? "options.on" : "options.off");
				}).build());
		grondag.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.grondag.enable.overworld.fog"),
				PandoraConfig.enableOverworldFog)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.grondag.enable.overworld.fog.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.enableOverworldFog = newValue)
				.setYesNoTextSupplier((bool) -> {
					return new TranslatableText(
							bool ? "options.on" : "options.off");
				}).setDefaultValue(true).build());
		//
		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.grues.grues.can.eat.items"),
				PandoraConfig.gruesCanEatItems)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.grues.grues.can.eat.items.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.gruesCanEatItems = newValue)
				.setYesNoTextSupplier((bool) -> {
					return new TranslatableText(
							bool ? "options.on" : "options.off");
				}).build());
		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.grues.grues.only.attack.players"),
				PandoraConfig.gruesOnlyAttackPlayers)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.grues.grues.only.attack.players.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.gruesOnlyAttackPlayers = newValue)
				.setYesNoTextSupplier((bool) -> {
					return new TranslatableText(
							bool ? "options.on" : "options.off");
				}).build());
		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.grues.grues.can.attack.villagers"),
				PandoraConfig.gruesCanAttackVillagers)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.grues.grues.can.attack.villagers.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.gruesCanAttackVillagers = newValue)
				.setYesNoTextSupplier((bool) -> {
					return new TranslatableText(
							bool ? "options.on" : "options.off");
				}).build());
		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.grues.grues.can.attack.animals"),
				PandoraConfig.gruesCanAttackAnimals)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.grues.grues.can.attack.animals.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.gruesCanAttackAnimals = newValue)
				.setYesNoTextSupplier((bool) -> {
					return new TranslatableText(
							bool ? "options.on" : "options.off");
				}).build());
		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.grues.grues.can.attack.hostile.mobs"),
				PandoraConfig.gruesCanAttackHostileMobs)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.grues.grues.can.attack.hostile.mobs.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.gruesCanAttackHostileMobs = newValue)
				.setYesNoTextSupplier((bool) -> {
					return new TranslatableText(
							bool ? "options.on" : "options.off");
				}).build());
		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.grues.grues.can.attack.boss.mobs"),
				PandoraConfig.gruesCanAttackBossMobs)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.grues.grues.can.attack.boss.mobs.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.gruesCanAttackBossMobs = newValue)
				.setYesNoTextSupplier((bool) -> {
					return new TranslatableText(
							bool ? "options.on" : "options.off");
				}).build());
		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.grues.grues.can.attack.in.water"),
				PandoraConfig.gruesCanAttackInWater)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.grues.grues.can.attack.in.water.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.gruesCanAttackInWater = newValue)
				.setYesNoTextSupplier((bool) -> {
					return new TranslatableText(
							bool ? "options.on" : "options.off");
				}).setDefaultValue(false).build());
		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.grues.hardcore.affects.other.mobs"),
				PandoraConfig.hardcoreAffectsOtherMobs)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.grues.hardcore.affects.other.mobs.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.hardcoreAffectsOtherMobs = newValue)
				.setYesNoTextSupplier((bool) -> {
					return new TranslatableText(
							bool ? "options.on" : "options.off");
				}).build());
		grues.addEntry(entryBuilder.startIntSlider(new TranslatableText(
				"pandora.config.menu.category.grues.grue.attack.light.level.maximum"),
				PandoraConfig.grueAttackLightLevelMaximum, 0, 15)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.grues.grue.attack.light.level.maximum.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.grueAttackLightLevelMaximum = newValue)
				.setTextGetter((val) -> {
					return new TranslatableText(String.valueOf(val));
				}).build());
		grues.addEntry(entryBuilder
				.startStrList(new TranslatableText(
						"pandora.config.menu.category.grues.grue.wards"),
						PandoraConfig.grueWards)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.grues.grue.wards.tooltip"))
				.setSaveConsumer(newValue -> PandoraConfig.grueWards = newValue)
				.build());
		darkness.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.darkness.villagers.fear.darkness"),
				PandoraConfig.villagersFearDarkness)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.darkness.villagers.fear.darkness.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.villagersFearDarkness = newValue)
				.setDefaultValue(true).requireRestart()
				.setYesNoTextSupplier((bool) -> new TranslatableText(
						bool ? "pandora.true" : "pandora.false"))
				.build());
		darkness.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.darkness.animals.fear.darkness"),
				PandoraConfig.animalsFearDarkness)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.darkness.animals.fear.darkness.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.animalsFearDarkness = newValue)
				.setDefaultValue(true).requireRestart()
				.setYesNoTextSupplier((bool) -> new TranslatableText(
						bool ? "pandora.true" : "pandora.false"))
				.build());
		darkness.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.darkness.hostile.mobs.fear.darkness"),
				PandoraConfig.hostileMobsFearDarkness)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.darkness.hostile.mobs.fear.darkness.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.hostileMobsFearDarkness= newValue)
				.setDefaultValue(true).requireRestart()
				.setYesNoTextSupplier((bool) -> new TranslatableText(
						bool ? "pandora.true" : "pandora.false"))
				.build());
		
		gamma.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
				"pandora.config.menu.category.gamma.reset.gamma"),
				PandoraConfig.resetGamma)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.gamma.reset.gamma.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.resetGamma = newValue)
				.setDefaultValue(true).requireRestart()
				.setYesNoTextSupplier((bool) -> new TranslatableText(
						bool ? "pandora.true" : "pandora.false"))
				.build());
		
		gamma.addEntry(entryBuilder.startDoubleField(new TranslatableText(
				"pandora.config.menu.category.gamma.default.gamma.value"),
				PandoraConfig.defaultGammaValue).setMax(1F).setMin(0F)
				.setTooltip(new TranslatableText(
						"pandora.config.menu.category.gamma.default.gamma.value.tooltip"))
				.setSaveConsumer(
						newValue -> PandoraConfig.defaultGammaValue = newValue)
				.setDefaultValue(1F)
				.build());
		
		return builder.build();
	}
}
