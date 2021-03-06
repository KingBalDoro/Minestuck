package com.mraof.minestuck.client.model;

import com.mraof.minestuck.entity.underling.BasiliskEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class BasiliskModel<T extends BasiliskEntity> extends EntityModel<T>
{
	private RendererModel head;
	private RendererModel body;
	private RendererModel leftFrontLeg;
	private RendererModel rightFrontLeg;
	private RendererModel leftBackLeg;
	private RendererModel rightBackLeg;
	private RendererModel tail0;
	private RendererModel tail1;
	private RendererModel tail2;
	public BasiliskModel()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		float offsetY = 24;
		//setTextureOffset("null.Tongue", 84, 0);
		head = new RendererModel(this, 0, 0);
		head.addBox(-15F, -16F, -6F, 30, 16, 12);
		head.func_217178_a("Tongue", -3F, -5F, -8F, 6, 12, 2, 0.0f, 84, 0);
		head.setRotationPoint(0F, -16 + offsetY, -24F);
		body = new RendererModel(this, 0, 28);
		body.addBox(-7, 0, -20, 14, 14, 40);
		body.setRotationPoint(0F, -24 + offsetY, 0F);
		leftFrontLeg = new RendererModel(this, 100, 0);
		leftFrontLeg.addBox(-2, 0, -2, 4, 14, 4);
		leftFrontLeg.setRotationPoint(-9F, -14 + offsetY, -14);
		rightFrontLeg = new RendererModel(this, 100, 0);
		rightFrontLeg.addBox(-2, 0, -2, 4, 14, 4);
		rightFrontLeg.setRotationPoint(9F, -14 + offsetY, -14);
		leftBackLeg = new RendererModel(this, 100, 0);
		leftBackLeg.addBox(-2, 0, -2, 4, 14, 4);
		leftBackLeg.setRotationPoint(-9F, -14 + offsetY, 14);
		rightBackLeg = new RendererModel(this, 100, 0);
		rightBackLeg.addBox(-2, 0, -2, 4, 14, 4);
		rightBackLeg.setRotationPoint(9F, -14 + offsetY, 14);
		tail0 = new RendererModel(this, 0, 82);
		tail0.addBox(-5, 0, -2, 10, 10, 20);
		tail0.setRotationPoint(0F, -22 + offsetY, 18F);
		tail1 = new RendererModel(this, 60, 82);
		tail1.addBox(-3, 0, -2, 6, 6, 20);
		tail1.setRotationPoint(0F, -18 + offsetY, 36F);
		tail2 = new RendererModel(this, 68, 28);
		tail2.addBox(-3, 0, -2, 4, 4, 20);
		tail2.setRotationPoint(0F, -15 + offsetY, 54F);
	}
	
	@Override
	public void render(T entity, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		this.setRotationAngles(entity, par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.body.render(par7);
		this.leftFrontLeg.render(par7);
		this.rightFrontLeg.render(par7);
		this.leftBackLeg.render(par7);
		this.rightBackLeg.render(par7);
		this.tail0.render(par7);
		this.tail1.render(par7);
		this.tail2.render(par7);
	}
	
	@Override
	public void setRotationAngles(T par7Entity, float par1, float par2, float par3, float par4, float par5, float par6)
	{
		this.head.rotateAngleY = par4 / 2 / (180F / (float)Math.PI);
		this.head.rotateAngleX = (par5) / (180F / (float)Math.PI);
		this.leftFrontLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.7F * par2;
		this.rightFrontLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.7F * par2;
		this.leftBackLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.2F * par2 * 0.5F;
		this.rightBackLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.2F * par2 * 0.5F;
		this.tail0.rotateAngleY = MathHelper.cos(par1 + (float)Math.PI) * par2 / 2;
		this.tail1.rotationPointX = this.tail0.rotationPointX + 18 * MathHelper.sin(this.tail0.rotateAngleY);
		this.tail1.rotationPointZ = this.tail0.rotationPointZ + 18 * MathHelper.cos(this.tail0.rotateAngleY);
//		this.tail1.rotateAngleY = MathHelper.cos(par1 + (float)Math.PI) * -par2 / 2;
		this.tail2.rotationPointX = this.tail1.rotationPointX + 18 * MathHelper.sin(this.tail1.rotateAngleY);
		this.tail2.rotationPointZ = this.tail1.rotationPointZ + 18 * MathHelper.cos(this.tail1.rotateAngleY);
		this.tail2.rotateAngleY = MathHelper.cos(par1 + (float)Math.PI) * -par2;
	}
}
