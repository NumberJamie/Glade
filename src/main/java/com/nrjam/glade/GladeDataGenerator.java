package com.nrjam.glade;

import com.nrjam.glade.datagen.ModelProvider;
import com.nrjam.glade.datagen.RecipeProvider;
import com.nrjam.glade.datagen.lang.EnglishLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class GladeDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EnglishLangProvider::new);

		pack.addProvider(ModelProvider::new);
		pack.addProvider(RecipeProvider::new);
	}
}
