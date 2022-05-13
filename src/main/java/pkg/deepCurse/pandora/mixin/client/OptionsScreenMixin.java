package pkg.deepCurse.pandora.mixin.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.TranslatableText;
import pkg.deepCurse.pandora.core.DebugScreen;

@Mixin(OptionsScreen.class)
public class OptionsScreenMixin extends Screen {

	protected OptionsScreenMixin() {
		super(null);
	}

	Logger logger = LoggerFactory.getLogger("OptionsScreen");

	@Shadow
	private final Screen parent = null;

	@Inject(at = @At("TAIL"), method = "init()V")
	private void init(CallbackInfo info) {
		logger.info("init");
		this.addDrawableChild(new ButtonWidget(4, 4, 20, 20,
				new TranslatableText("pandora.menu.debug.button"),
				button -> this.client.setScreen(new DebugScreen(this))));
	}

}
