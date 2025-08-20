package rabiosa_studios.vanilla_arrows_plus;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rabiosa_studios.vanilla_arrows_plus.effect.ModEffects;
import rabiosa_studios.vanilla_arrows_plus.entity.ModEntities;
import rabiosa_studios.vanilla_arrows_plus.item.ModItemGroups;
import rabiosa_studios.vanilla_arrows_plus.item.ModItems;

public class VanillaArrowsPlus implements ModInitializer {
	public static final String MOD_NAME = "Vanilla Arrows Plus";
	public static final String MOD_ID = "vanilla-arrows-plus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info('\"' + MOD_NAME + '\"' + " is loading...");

		ModItems.registerItems();
		ModItemGroups.registerItemGroups();
		ModEntities.registerModEntities();
		ModEffects.registerEffects();

		LOGGER.info('\"' + MOD_NAME + '\"' + " loaded!");
	}
}