package pkg.deepCurse.curseBox.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class CurseBox implements ModInitializer {

	public static boolean debug = true;

	public static final Logger LOGGER = LogManager
			.getLogger(CurseBox.class.getSimpleName());

	static {
		LOGGER.info(debug ? "[cursebox] class init" : "");

		CurseBoxConfig.loadConfig();
	}

	@Override
	public void onInitialize() {

		if (debug) {
			LOGGER.info(
					"[cursebox] HEY DUMBASS, MAKE SURE YOUR MIXINS ARE LISTED IN THE MIXIN FILE (i have wasted <15.4> hour(s) because i forgot to add it to mixins)");
		}

		LOGGER.info("[cursebox] Initializing. . .");
		LOGGER.info("[cursebox] Loaded and ready. . .");

	}
}
