package com.nrjam.glade.datagen;

import com.nrjam.glade.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter exporter) {
        return new RecipeGenerator(wrapperLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                List<Item> armorTrims = List.of(
                        Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE
                );

                armorTrims.forEach(item -> offerTrimCopyRecipe(this, item, exporter));
                createShaped(RecipeCategory.MISC, ModItems.BLANK_ARMOR_TRIM_SMITHING_TEMPLATE)
                        .pattern("xox")
                        .pattern("xox")
                        .pattern("xox")
                        .input('x', Items.DIAMOND)
                        .input('o', ItemTags.WOOL)
                        .criterion("has_diamond", conditionsFromItem(Items.DIAMOND))
                        .offerTo(exporter);
            }
        };
    }

    private void offerTrimCopyRecipe(RecipeGenerator generator, Item item, RecipeExporter exporter) {
        generator.createShapeless(RecipeCategory.MISC, item, 2)
                .input(ModItems.BLANK_ARMOR_TRIM_SMITHING_TEMPLATE)
                .input(item)
                .criterion("has_blank", generator.conditionsFromItem(ModItems.BLANK_ARMOR_TRIM_SMITHING_TEMPLATE))
                .offerTo(exporter);
    }

    @Override
    public String getName() {
        return "GladeRecipeProvider";
    }
}
