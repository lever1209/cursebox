package pkg.deepCurse.pandora.core.integrations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import grondag.darkness.Darkness;
import grondag.darkness.DimensionConfigInfoObject;
import me.shedaniel.clothconfig2.ClothConfigDemo;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.gui.entries.MultiElementListEntry;
import me.shedaniel.clothconfig2.gui.entries.NestedListListEntry;
import me.shedaniel.clothconfig2.impl.builders.BooleanToggleBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import pkg.deepCurse.pandora.core.Pandora;
import pkg.deepCurse.pandora.core.PandoraConfig;
import pkg.deepCurse.pandora.core.PandoraSpruceUIScreen;

public class ModMenuConfigIntegration implements ModMenuApi {

	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return screen -> createNewConfigScreen(screen);
	}

	public Screen createNewConfigScreen(Screen parent) {
		return new PandoraSpruceUIScreen(parent);
////		return ClothConfigDemo.getConfigBuilderWithDemo().build();
//
//		ConfigBuilder builder = ConfigBuilder.create().setParentScreen(parent)
//				.setTitle(new TranslatableText("pandora.config.menu.title"))
//				.setSavingRunnable(() -> {
//					PandoraConfig.saveConfigs();
//				}).setDefaultBackgroundTexture(new Identifier("minecraft",
//						"textures/block/cobbled_deepslate.png"));
//
//		ConfigCategory grondag = builder.getOrCreateCategory(
//				new TranslatableText("pandora.config.menu.category.grondag"));
//		ConfigCategory grues = builder.getOrCreateCategory(
//				new TranslatableText("pandora.config.menu.category.grues"));
//		ConfigCategory darkness = builder.getOrCreateCategory(
//				new TranslatableText("pandora.config.menu.category.darkness"));
//		ConfigCategory gamma = builder.getOrCreateCategory(
//				new TranslatableText("pandora.config.menu.category.gamma"));
//		ConfigCategory debug = builder.getOrCreateCategory(
//				new TranslatableText("pandora.config.menu.category.debug"));
//
//		ConfigEntryBuilder entryBuilder = builder.entryBuilder();
//
//		grondag.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grondag.enable.grondag.darkness"),
//				Darkness.enabled)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grondag.enable.grondag.darkness.tooltip"))
//				.setSaveConsumer(newValue -> Darkness.enabled = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).setDefaultValue(true).build());
//		grondag.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grondag.enable.end.darkness"),
//				Darkness.darkEnd).setDefaultValue(false)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grondag.enable.end.darkness.tooltip"))
//				.setSaveConsumer(newValue -> Darkness.darkEnd = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).build());
//		grondag.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grondag.enable.nether.darkness"),
//				Darkness.darkNether).setDefaultValue(true)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grondag.enable.nether.darkness.tooltip"))
//				.setSaveConsumer(newValue -> Darkness.darkNether = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).build());
//		grondag.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grondag.enable.overworld.darkness"),
//				Darkness.darkOverworld)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grondag.enable.overworld.darkness.tooltip"))
//				.setSaveConsumer(newValue -> Darkness.darkOverworld = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).setDefaultValue(true).build());
//		grondag.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grondag.enable.modded.dimension.darkness"),
//				Darkness.enableModdedDarkDimensions)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grondag.enable.modded.dimesnion.darkness.tooltip"))
//				.setSaveConsumer(
//						newValue -> Darkness.enableModdedDarkDimensions = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).setDefaultValue(true).build());
//
//		grondag.addEntry(entryBuilder
//				.startDoubleField(new TranslatableText(
//						"pandora.config.menu.category.grondag.dark.end"),
//						Darkness.darkEndFogConfigured)
//				.setMin(0.0F).setMax(1.0F)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grondag.dark.end.tooltip"))
//				.setSaveConsumer(
//						newValue -> Darkness.darkEndFogConfigured = newValue)
//				.build()); // TODO check tooltip array for multi line
//
//		grondag.addEntry(entryBuilder
//				.startDoubleField(new TranslatableText(
//						"pandora.config.menu.category.grondag.dark.nether"),
//						Darkness.darkNetherFogConfigured)
//				.setMin(0.0F).setMax(1.0F)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grondag.dark.nether.tooltip"))
//				.setSaveConsumer(
//						newValue -> Darkness.darkNetherFogConfigured = newValue)
//				.build());
//
//		grondag.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grondag.ignore.moon.phase"),
//				Darkness.ignoreMoonPhase)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grondag.ignore.moon.phase.tooltip"))
//				.setSaveConsumer(
//						newValue -> Darkness.ignoreMoonPhase = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).setDefaultValue(true).build());
//		grondag.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grondag.only.affect.block.light"),
//				Darkness.blockLightOnly)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grondag.only.affect.block.light.tooltip"))
//				.setSaveConsumer(newValue -> Darkness.blockLightOnly = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).setDefaultValue(true).build());
//
//		grondag.addEntry(
//				new NestedListListEntry<DimensionConfigInfoObject, MultiElementListEntry<DimensionConfigInfoObject>>(
//						new TranslatableText("title"),
//						PandoraConfig.getSimpleDimensions(), true,
//						Optional::empty, list -> {
//							PandoraConfig.saveSimpleDimensionList(list);
//							System.out.println("saving: " + list);
//						}, () -> PandoraConfig.getSimpleDimensions(),
//						new TranslatableText("Reset"), true, true,
//						(element, nestedEntry) -> {
//
//							// default values in case element is null
//							// (on item creation)
//							String dimensionID = "minecraft:overworld";
//							Boolean isEnabled = true;
//							Double intensity = 1.0;
//
//							if (element != null) {
//								dimensionID = element.getId();
//								isEnabled = element.isEnabled();
//								intensity = element.getIntensity();
//							}
//
//							System.out.println("on element creation: "
//									+ element.toString());
//
//							MultiElementListEntry<DimensionConfigInfoObject> entry = new MultiElementListEntry<DimensionConfigInfoObject>(
//									new TranslatableText("Dimension"), element,
//									Lists.newArrayList(
//											entryBuilder.startStrField(
//													new TranslatableText(
//															"Dimension ID"),
//													dimensionID).build(),
//											entryBuilder.startBooleanToggle(
//													new TranslatableText(
//															"Is Enabled"),
//													isEnabled).build(),
//											entryBuilder.startDoubleField(
//													new TranslatableText(
//															"Intensity"),
//													intensity).build()),
//									true);
//							System.out.println("final entry to return: "
//									+ entry.getValue().toString());
//							return entry;
//						}));
//
//		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grues.grues.can.eat.items"),
//				PandoraConfig.gruesCanEatItems).setDefaultValue(true)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grues.grues.can.eat.items.tooltip"))
//				.setSaveConsumer(
//						newValue -> PandoraConfig.gruesCanEatItems = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).build());
//		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grues.grues.only.attack.players"),
//				PandoraConfig.gruesOnlyAttackPlayers).setDefaultValue(false)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grues.grues.only.attack.players.tooltip"))
//				.setSaveConsumer(
//						newValue -> PandoraConfig.gruesOnlyAttackPlayers = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).build());
//		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grues.grues.can.attack.animals"),
//				PandoraConfig.gruesCanAttackAnimals).setDefaultValue(false)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grues.grues.can.attack.animals.tooltip"))
//				.setSaveConsumer(
//						newValue -> PandoraConfig.gruesCanAttackAnimals = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).build());
//		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grues.grues.can.attack.villagers"),
//				PandoraConfig.gruesCanAttackVillagers).setDefaultValue(true)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grues.grues.can.attack.villagers.tooltip"))
//				.setSaveConsumer(
//						newValue -> PandoraConfig.gruesCanAttackVillagers = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).build());
//		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grues.grues.can.attack.hostile.mobs"),
//				PandoraConfig.gruesCanAttackHostileMobs).setDefaultValue(false)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grues.grues.can.attack.hostile.mobs.tooltip"))
//				.setSaveConsumer(
//						newValue -> PandoraConfig.gruesCanAttackHostileMobs = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).build());
//		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grues.grues.can.attack.boss.mobs"),
//				PandoraConfig.gruesCanAttackBossMobs).setDefaultValue(false)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grues.grues.can.attack.boss.mobs.tooltip"))
//				.setSaveConsumer(
//						newValue -> PandoraConfig.gruesCanAttackBossMobs = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).build());
//		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grues.grues.can.attack.in.water"),
//				PandoraConfig.gruesCanAttackInWater).setDefaultValue(false)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grues.grues.can.attack.in.water.tooltip"))
//				.setSaveConsumer(
//						newValue -> PandoraConfig.gruesCanAttackInWater = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).setDefaultValue(false).build());
//		grues.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.grues.hardcore.affects.other.mobs"),
//				PandoraConfig.hardcoreAffectsOtherMobs).setDefaultValue(false)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grues.hardcore.affects.other.mobs.tooltip"))
//				.setSaveConsumer(
//						newValue -> PandoraConfig.hardcoreAffectsOtherMobs = newValue)
//				.setYesNoTextSupplier((bool) -> {
//					return new TranslatableText(
//							bool ? "options.on" : "options.off");
//				}).build());
//		grues.addEntry(entryBuilder.startIntSlider(new TranslatableText(
//				"pandora.config.menu.category.grues.grue.attack.light.level.maximum"),
//				PandoraConfig.grueAttackLightLevelMaximum, 0, 15)
//				.setDefaultValue(2)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grues.grue.attack.light.level.maximum.tooltip"))
//				.setSaveConsumer(
//						newValue -> PandoraConfig.grueAttackLightLevelMaximum = newValue)
//				.setTextGetter((val) -> {
//					return new TranslatableText(String.valueOf(val));
//				}).build());
//		grues.addEntry(entryBuilder
//				.startStrList(new TranslatableText(
//						"pandora.config.menu.category.grues.grue.wards"),
//						PandoraConfig.grueWards)
//				.setDefaultValue(new ArrayList<String>())
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.grues.grue.wards.tooltip"))
//				.setSaveConsumer(newValue -> PandoraConfig.grueWards = newValue)
//				.build());
//		darkness.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.darkness.villagers.fear.darkness"),
//				PandoraConfig.villagersFearDarkness).setDefaultValue(true)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.darkness.villagers.fear.darkness.tooltip"))
//				.setSaveConsumer(
//						newValue -> PandoraConfig.villagersFearDarkness = newValue)
//				.setDefaultValue(true).requireRestart()
//				.setYesNoTextSupplier((bool) -> new TranslatableText(
//						bool ? "pandora.true" : "pandora.false"))
//				.build());
//		darkness.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.darkness.animals.fear.darkness"),
//				PandoraConfig.animalsFearDarkness).setDefaultValue(false)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.darkness.animals.fear.darkness.tooltip"))
//				.setSaveConsumer(
//						newValue -> PandoraConfig.animalsFearDarkness = newValue)
//				.requireRestart()
//				.setYesNoTextSupplier((bool) -> new TranslatableText(
//						bool ? "pandora.true" : "pandora.false"))
//				.build());
//		darkness.addEntry(entryBuilder.startBooleanToggle(new TranslatableText(
//				"pandora.config.menu.category.darkness.hostile.mobs.fear.darkness"),
//				PandoraConfig.hostileMobsFearDarkness).setDefaultValue(false)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.darkness.hostile.mobs.fear.darkness.tooltip"))
//				.setSaveConsumer(
//						newValue -> PandoraConfig.hostileMobsFearDarkness = newValue)
//				.requireRestart()
//				.setYesNoTextSupplier((bool) -> new TranslatableText(
//						bool ? "pandora.true" : "pandora.false"))
//				.build());
//
//		gamma.addEntry(entryBuilder
//				.startBooleanToggle(new TranslatableText(
//						"pandora.config.menu.category.gamma.reset.gamma"),
//						PandoraConfig.resetGamma)
//				.setDefaultValue(true)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.gamma.reset.gamma.tooltip"))
//				.setSaveConsumer(
//						newValue -> PandoraConfig.resetGamma = newValue)
//				.setDefaultValue(true).requireRestart()
//				.setYesNoTextSupplier((bool) -> new TranslatableText(
//						bool ? "pandora.true" : "pandora.false"))
//				.build());
//
//		gamma.addEntry(entryBuilder.startDoubleField(new TranslatableText(
//				"pandora.config.menu.category.gamma.default.gamma.value"),
//				PandoraConfig.resetGammaValue).setMax(1F).setMin(0F)
//				.setTooltip(new TranslatableText(
//						"pandora.config.menu.category.gamma.default.gamma.value.tooltip"))
//				.setSaveConsumer(
//						newValue -> PandoraConfig.resetGammaValue = newValue)
//				.setDefaultValue(1F).build());
//
//		debug.addEntry(entryBuilder
//				.startBooleanToggle(new TranslatableText(
//						"pandora.config.menu.category.debug.enable.debug"),
//						Pandora.debug)
//				.setSaveConsumer(newValue -> Pandora.debug = newValue).build());
//		builder.setDoesConfirmSave(true);
//
//		return builder.build();
	}
}
