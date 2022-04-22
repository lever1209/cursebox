package pkg.deepCurse.curseBox.core.integrations;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class ModMenuIntegration implements ModMenuApi {

	// private Screen generateScreen(Screen parent) {
	// ConfigBuilder builder = ConfigBuilder.create().setParentScreen(parent)
	// .setTitle(new TranslatableText("cursebox.config.title"));
	// return builder.build();
	// }

//	private String stringA;

	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return ModMenuIntegrationScreen::new;
		
//		ConfigScreenFactory obj = parent -> {
//			ConfigBuilder builder = ConfigBuilder.create()
//					.setParentScreen(parent).setSavingRunnable(() -> {
//						System.out.println(stringA);
//					})
//					.setTitle(new TranslatableText("cursebox.config.title"));
//
//			ConfigCategory general = builder.getOrCreateCategory(
//					new TranslatableText("category.examplemod.general"));
//			ConfigEntryBuilder entryBuilder = builder.entryBuilder();
//			general.addEntry(
//					entryBuilder
//							.startStrField(
//									new TranslatableText(
//											"option.examplemod.optionA"),
//									stringA)
//							.setDefaultValue("This is the default value")
//							.setTooltip(new TranslatableText(
//									"This option is awesome!"))
//							.setSaveConsumer(
//									newValue -> stringA = newValue)
//							.build());
//
//			return builder.build();
//		};
//		return obj;
	}
}
