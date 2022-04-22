package pkg.deepCurse.curseBox.core;

import java.util.HashMap;

public class CurseBoxConfig {

	private static HashMap<String, Object> configMap = new HashMap<>();
	
	/**
	 * valid keys are:
	 * 
	 * <pre>
	 * bool : lambDynLightsIsPresent
	 * </pre>
	 */
	public static void setConfig(String key, Object b) {
		if (key.startsWith("F$") && key.contains(key)) {
			throw new IllegalStateException("[cursebox] Key: " + key
					+ " is final, and may not be changed after it is set. . .");
		}
		configMap.put(key, b);
	}

}
