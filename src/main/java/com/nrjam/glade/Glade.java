package com.nrjam.glade;

import com.nrjam.glade.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Glade implements ModInitializer {
	public static final String MOD_ID = "glade";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.RegisterItems();
	}
}