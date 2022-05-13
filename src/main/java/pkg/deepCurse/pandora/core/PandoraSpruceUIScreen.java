package pkg.deepCurse.pandora.core;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;

public class PandoraSpruceUIScreen extends Screen {

	private Screen parent;

	public PandoraSpruceUIScreen(Screen parent) {
		super(new TranslatableText("E"));
		this.parent = parent;
	}
	
	
	
	
	
}
