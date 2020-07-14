package com.eonzenx.mcppmod.client.gui;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.containers.SoupPotBlockContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class SoupPotBlockScreen extends ContainerScreen<SoupPotBlockContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(MCPPMod.MOD_ID, "textures/gui/soup_pot.png");

    public SoupPotBlockScreen(SoupPotBlockContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 175;
        this.ySize = 165;
    }

    @Override
    protected void init() {
        super.init();
        int x = (this.width - this.xSize)/2;
        int y = (this.height - this.ySize)/2;

        this.addButton(new ImageButton(x + 66, y + 43, 44, 12, 176, 0, 12,
                BACKGROUND_TEXTURE,
                new Button.IPressable() {
                    @Override
                    public void onPress(Button button) {
                        System.out.println("fck");
                    }
                }));
    }

    /**
     * Draw GUI Container Background Layer
     * @param matrixStack
     * @param partialTicks
     * @param mouseX
     * @param mouseY
     */
    @Override
    protected void func_230450_a_(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.getMinecraft().getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int x = (this.width - this.xSize)/2;
        int y = (this.height - this.ySize)/2;
        this.blit(matrixStack, x, y, 0, 0, this.xSize, this.ySize);
        super.func_230459_a_(matrixStack, mouseX, mouseY);
    }

    @Override
    public void render(MatrixStack matrixStack, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, p_230430_2_, p_230430_3_, p_230430_4_);

        // hovered tooltip
        this.func_230459_a_(matrixStack, p_230430_2_, p_230430_3_);
    }
}
