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
package p455w0rd.endermanevo.client.model.layers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import p455w0rd.endermanevo.client.render.RenderEvolvedEnderman;
import p455w0rd.endermanevo.entity.EntityEvolvedEnderman;
import p455w0rd.endermanevo.init.ModGlobals;

/**
 * @author p455w0rd
 *
 */
public class LayerEndermanEvolvedEyes implements LayerRenderer<EntityEvolvedEnderman> {
	private static final ResourceLocation RES_ENDERMAN_EYES = new ResourceLocation(ModGlobals.MODID, "textures/entity/enderman_evolved_eyes.png");
	private final RenderEvolvedEnderman endermanRenderer;

	public LayerEndermanEvolvedEyes(RenderEvolvedEnderman endermanRendererIn) {
		endermanRenderer = endermanRendererIn;
	}

	@Override
	public void doRenderLayer(EntityEvolvedEnderman entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		endermanRenderer.bindTexture(RES_ENDERMAN_EYES);
		GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
		GlStateManager.disableLighting();
		GlStateManager.depthMask(!entitylivingbaseIn.isInvisible());

		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0F, 0.0F);
		GlStateManager.enableLighting();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		endermanRenderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		endermanRenderer.setLightmap(entitylivingbaseIn);
		GlStateManager.depthMask(true);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}