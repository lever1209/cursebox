package pkg.deepCurse.pandora.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.option.GameOptions;
import pkg.deepCurse.pandora.core.PandoraConfig;

@Mixin({GameOptions.class})
public class GameOptionsMixin {

	@Shadow
	public double gamma;

	@Inject(method = {"load"}, at = {@At("RETURN")})
	private void pandoraOptions$load(CallbackInfo ci) {
		if (PandoraConfig.resetGamma) {
			this.gamma = PandoraConfig.resetGammaValue;
		}
	}
}
