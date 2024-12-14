package devcmb.petsplus.screen;

import devcmb.petsplus.PetsPlus;
import devcmb.petsplus.screen.block.PetsManagerBlockScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreens {
    public static final ScreenHandlerType<PetsManagerBlockScreenHandler> PETS_MANAGER_SCREEN_HANDLER =
            new ScreenHandlerType<>(PetsManagerBlockScreenHandler::new, null);

    public static void registerModScreens() {
        Registry.register(
                Registries.SCREEN_HANDLER,
                Identifier.of(PetsPlus.MOD_ID, "custom_crafting"),
                PETS_MANAGER_SCREEN_HANDLER
        );
    }
}
