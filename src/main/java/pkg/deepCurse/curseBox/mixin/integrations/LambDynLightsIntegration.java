package pkg.deepCurse.curseBox.mixin.integrations;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import pkg.deepCurse.curseBox.core.CurseBoxConfig;

@Pseudo
@Mixin(targets = "dev.lambdaurora.lambdynlights.LambDynLights")
public class LambDynLightsIntegration {

	@Inject(at = @At("INVOKE"), method = "onInitializeClient()V")
	public void init(CallbackInfo info) {
		CurseBoxConfig.lambDynLightsIsPresent = true;
	}

}
