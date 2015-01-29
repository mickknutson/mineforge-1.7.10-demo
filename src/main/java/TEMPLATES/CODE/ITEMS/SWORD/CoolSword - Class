package com.baselogic.minecraft.tutorial.items;

import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.*;


public class CoolSword extends ItemSword {

    private String texturePath = "mymod:";

    public CoolSword(ToolMaterial material, String textureName) {
        super(material);
        this.setUnlocalizedName(textureName);
        texturePath += textureName;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(texturePath);
    }


}
