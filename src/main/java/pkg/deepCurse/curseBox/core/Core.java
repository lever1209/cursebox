package pkg.deepCurse.curseBox.core;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Core implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("cursebox");

	@Override
	public void onInitialize() {
		
		LOGGER.info("Init");
		
	}

}
