package com.nrjam.glade.datagen;

import com.nrjam.glade.block.ModBlocks;
import com.nrjam.glade.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.ModelVariant;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        this.registerWaterLilyPad(blockStateModelGenerator, ModBlocks.WATER_LILY_PAD);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BLANK_ARMOR_TRIM_SMITHING_TEMPLATE, Models.GENERATED);
    }

    private void registerWaterLilyPad(BlockStateModelGenerator generator, Block block){
        generator.registerItemModel(block);
        ModelVariant modelVariant = BlockStateModelGenerator.createModelVariant(ModelIds.getBlockModelId(block));
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block, BlockStateModelGenerator.modelWithYRotation(modelVariant)));
    }
}
