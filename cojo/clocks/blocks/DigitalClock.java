package cojo.clocks.blocks;

import net.minecraft.block.material.Material;

public class DigitalClock extends ClockBlock {

	public DigitalClock(int id) {
		super(id, Material.circuits);
	}

	@Override
	public String getImageName() {
		return "digiclock";
	}

}
