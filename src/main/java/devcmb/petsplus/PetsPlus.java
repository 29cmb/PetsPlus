package devcmb.petsplus;

import devcmb.petsplus.block.ModBlocks;
import devcmb.petsplus.item.ModItemGroups;
import devcmb.petsplus.item.ModItems;
import devcmb.petsplus.screen.ModScreens;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PetsPlus implements ModInitializer {
	public static final String MOD_ID = "petsplus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Pets Plus Initialized");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerModItemGroups();
		ModScreens.registerModScreens();
	}
}