package devcmb.petsplus.datagen;

import devcmb.petsplus.PetsPlus;
import devcmb.petsplus.block.ModBlocks;
import devcmb.petsplus.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeWithCustomTextures(
                ModBlocks.PET_MANAGER,
                Blocks.OBSIDIAN,
                (block, bottom) -> new TextureMap()
                        .put(TextureKey.SIDE, Identifier.of(PetsPlus.MOD_ID, "block/pet_manager-side"))
                        .put(TextureKey.UP, Identifier.of(PetsPlus.MOD_ID, "block/pet_manager-top"))
                        .put(TextureKey.DOWN, Identifier.ofVanilla("block/obsidian"))
                        .put(TextureKey.PARTICLE, Identifier.ofVanilla("block/obsidian"))
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PET_CORE, Models.GENERATED);
    }
}