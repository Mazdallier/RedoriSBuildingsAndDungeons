package com.gollum.rbd.client.render.blocks;

import com.gollum.core.tools.helper.IBlockMetadataHelper;
import com.gollum.rbd.client.model.blocks.ModelStrangeGame;
import com.gollum.rbd.common.tileentities.TileEntityCommonReward;
import com.gollum.rbd.inits.ModBlocks;

import net.minecraft.tileentity.TileEntity;

public class CommonRewardBlockRenderer extends RBDTileEntitySpecialRenderer {
	
	private ModelStrangeGame modelStrangeGame = new ModelStrangeGame();
	
	@Override
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int metadata, float rotation) {
		
		TileEntityCommonReward tileEntityCommonReward = (TileEntityCommonReward)tileEntity;
		int subBlock = ((IBlockMetadataHelper)ModBlocks.blockLightRewardOn).getEnabledMetadata(metadata);
		
		
		
		switch (subBlock) {
			default:
			case 0:
				this.scale = 0.5;
				this.scaleInventory = 1.5F;
				if (!this.isInventory) {
					rotation = (rotation+90)%360;
				}
				this.renderModel(this.modelStrangeGame, "strangegame"  , x, y, z, rotation);
				this.rendedModelBoard (x, y, z, rotation);
				this.scaleInventory = 1.0F;
				this.scale = 1.0;
				
				break;
		}
	}
	
	protected void rendedModelBoard (double x, double y, double z, float rotation) {
		this.alpha = 0.65F;
		this.beforeRender("strangegame", x, y, z, rotation);
		this.modelStrangeGame.renderModelBoard(0.0625F);
		this.endRender();
		this.alpha = 1.0F;
	}
}