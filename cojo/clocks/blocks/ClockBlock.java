package cojo.clocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cojo.clocks.ModInfo;

public abstract class ClockBlock extends Block {

	public ClockBlock(int par1, Material par2Material) {
		super(par1, par2Material);
	}

    /**
     * Register all Icons used in this block
     */
    @Override
    public void registerIcons(IconRegister iconRegistry) {
        this.blockIcon = iconRegistry.registerIcon(ModInfo.ICONLOCATION + getImageName());
    }

    /**
     * Returns the file name of the image icon
     * @return File name of image icon for this Block
     */
    public abstract String getImageName();
}
