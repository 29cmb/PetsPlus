package devcmb.petsplus;

import devcmb.petsplus.screen.ModScreens;
import devcmb.petsplus.screen.block.PetManagerBlockScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class PetsPlusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreens.PETS_MANAGER_SCREEN_HANDLER, PetManagerBlockScreen::new);
    }
}
