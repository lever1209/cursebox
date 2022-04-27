package pkg.deepCurse.pandora.core;

public class PandoraLightDictionary {

	// CLASSES
	private static final int maximumLight = 15;
	private static final int cookingBlock = 4;
	private static final int redstoneBlock = 9;
	private static final int fireLight = 12;
	// FIRE
	public static int lava = maximumLight;
	public static int lavaCauldron = lava - 6;
	public static int fire = fireLight;
	public static int torch = fireLight;
	public static int wallTorch = torch;
	public static int furnace = cookingBlock - 2;
	public static int candle = 5;
	public static int candleCake = 5;
	public static int campfire = fireLight;
	public static int lantern = fireLight - 3;
	public static int magma = cookingBlock + 2;
	public static int smoker = cookingBlock;
	public static int blastFurnace = cookingBlock;

	// soul
	public static int soulFire = 14;
	public static int soulTorch = soulFire;
	public static int soulWallTorch = soulTorch;
	public static int soulLantern = soulTorch - 3;
	public static int soulCampfire = soulFire + 3;

	// redstone
	public static int redstoneOre = redstoneBlock;
	public static int redstoneTorch = 0;
	public static int redstoneWallTorch = redstoneTorch;
	public static int redstoneLamp = 0;

	// low grade magic
	public static int glowstone = 0;
	public static int netherPortal = 0;
	public static int brewingStand = 0;
	public static int seaLantern = 0;
	public static int cryingObsidian = 0;
	public static int enderChest = 0;
	public static int conduit = 0;
	public static int respawnAnchor = 0;
	public static int amethystCluster = 0;
	public static int largeAmethystBud = 0;
	public static int mediumAmethystBud = 0;
	public static int smallAmethystBud = 0;

	// high grade magic
	public static int enchantingTable = 0;
	public static int endPortal = 0;
	public static int endPortalFrame = 0;
	public static int endRod = 0;
	public static int endGateway = 0;
	public static int dragonEgg = 0;
	public static int light = 0;
	public static int beacon = 0;

	// glowing plants
	public static int glowLichen = 0; // SHEARS
	public static int caveVines = 0;
	public static int caveVinesPlant = 0;
	public static int seaPickle = 0; // blockState ->
										// SeaPickleBlock.isDry(blockState) ? 0
										// : 3 + 3 *
										// blockState.get(SeaPickleBlock.PICKLES)
	public static int shroomLight = 0;
	public static int jackOLantern = 0;
	public static int brownMushroom = 0;
	public static int sculkSensor = 0;
}
