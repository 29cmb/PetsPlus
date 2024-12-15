package devcmb.petsplus.util.recipe;

import devcmb.petsplus.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.List;
import java.util.Map;

public class PetManager {
    // why is the NO DOCUMENTATION for custom recipes
    public static final List<Map<Item, List<Item>>> recipes = List.of(
            Map.of(ModBlocks.PET_MANAGER.asItem(), List.of(
                    Items.DIAMOND_BLOCK,
                    Items.DIAMOND_BLOCK,
                    Items.DIAMOND_BLOCK,
                    Items.DIAMOND_BLOCK,
                    Items.DIAMOND_BLOCK,
                    Items.DIAMOND_BLOCK,
                    Items.DIAMOND_BLOCK,
                    Items.DIAMOND_BLOCK
            ))
    );
}
