package devcmb.petsplus.item;

import devcmb.petsplus.PetsPlus;
import devcmb.petsplus.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PETS_PLUS = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(PetsPlus.MOD_ID, "pets_plus_group"),
            FabricItemGroup.builder().icon(() -> ModBlocks.PET_MANAGER.asItem().getDefaultStack())
            .displayName(Text.translatable("itemgroup.petspls.pets_plus_group"))
            .entries((displayContext, entries) -> {
                entries.add(ModBlocks.PET_MANAGER.asItem());
                entries.add(ModItems.PET_CORE);
            })
            .build()
    );

    public static void registerModItemGroups() {}
}
