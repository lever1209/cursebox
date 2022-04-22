 package pkg.deepCurse.curseBox.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.screen.TitleScreen;
import pkg.deepCurse.curseBox.core.CurseBox;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
	
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		
		CurseBox.LOGGER.info("Title mixin");
		
	}
	
}
