package cojo.clocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;

public class ClockBlocks {
	
	public static Block clock;
	
	public static void init() {
		
	}
	
	private static void registerBlock(Block block, String name) {
		LanguageRegistry.addName(block, name);
		GameRegistry.registerBlock(block, name);
	}
}
