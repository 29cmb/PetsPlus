package devcmb.petsplus.datagen;

import devcmb.petsplus.block.ModBlocks;
import devcmb.petsplus.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PET_CORE)
                .pattern("GGG")
                .pattern("GEG")
                .pattern("GGG")
                .input('G', Items.GOLD_INGOT.asItem())
                .input('E', Items.EGG)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PET_MANAGER)
                .pattern("RRR")
                .pattern("RCR")
                .pattern("OOO")
                .input('R', Blocks.REDSTONE_BLOCK.asItem())
                .input('C', ModItems.PET_CORE)
                .input('O', Blocks.OBSIDIAN.asItem())
                .criterion(hasItem(ModItems.PET_CORE), conditionsFromItem(ModItems.PET_CORE))
                .offerTo(exporter);
    }
}