package devcmb.petsplus.item;

import devcmb.petsplus.PetsPlus;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PET_CORE = registerItem("pet_core", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PetsPlus.MOD_ID, name), item);
    }

    public static void registerModItems() {}
}
