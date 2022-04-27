package pkg.deepCurse.pandora.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import pkg.deepCurse.pandora.callbacks.EndServerTickCallback;

public class Pandora implements ModInitializer {

	public static boolean debug = true;

	public static final Logger LOGGER = LogManager
			.getLogger(Pandora.class.getSimpleName());

	static {
		PandoraConfig.loadConfig();
	}

	@Override
	public void onInitialize() { // TODO @ modify arg

		if (debug) {
			LOGGER.info(
					"[cursebox] HEY DUMBASS, MAKE SURE YOUR MIXINS ARE LISTED IN THE MIXIN FILE (i have wasted <15.4> hour(s) because i forgot to add it to mixins)");
		}

		LOGGER.info("[cursebox] Initializing. . .");
		ServerTickEvents.END_SERVER_TICK.register((MinecraftServer) -> {
			EndServerTickCallback.onEndTick(MinecraftServer);
		});
		LOGGER.info("[cursebox] Loaded and ready. . .");

	}
}
