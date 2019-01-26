/*
 * This file is part of Enderman Evolution.
 * Copyright (c) 2016, p455w0rd (aka TheRealp455w0rd), All rights reserved
 * unless
 * otherwise stated.
 *
 * Enderman Evolution is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License.
 *
 * Enderman Evolution is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * MIT License for more details.
 *
 * You should have received a copy of the MIT License
 * along with Enderman Evolution. If not, see
 * <https://opensource.org/licenses/MIT>.
 */
package p455w0rd.endermanevo.client.render;

import net.minecraft.client.model.ModelEnderMite;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import p455w0rd.endermanevo.entity.EntityEvolvedEndermite;
import p455w0rd.endermanevo.init.ModGlobals;
import p455w0rd.endermanevo.init.ModRendering;

/**
 * @author p455w0rd
 *
 */
@SideOnly(Side.CLIENT)
public class RenderEvolvedEndermite extends RenderLiving<EntityEvolvedEndermite> {
	private static final ResourceLocation ENDERMITE_TEXTURES = new ResourceLocation(ModGlobals.MODID, "textures/entity/endermite2.png");

	public RenderEvolvedEndermite() {
		super(ModRendering.getRenderManager(), new ModelEnderMite(), 0.3F);
	}

	@Override
	protected float getDeathMaxRotation(EntityEvolvedEndermite entityLivingBaseIn) {
		return 180.0F;
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(EntityEvolvedEndermite entity) {
		return ENDERMITE_TEXTURES;
	}
}