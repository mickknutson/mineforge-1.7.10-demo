package com.baselogic.minecraft.tutorial.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import joptsimple.internal.Reflection;
import net.minecraft.item.Item;
import scala.reflect.runtime.ReflectionUtils;

import java.lang.reflect.Constructor;

/**
 * Generic Item Builder
 */
public class ItemFactory {

//    public static String TEXTURE_PATH = "mod:";
//    public static String MY_COOL_SWORD_IMAGE_NAME = "CoolSword_image_1";
//    public static String MY_COOL_SWORD_ITEM_NAME = "My Cool Sword";

//    public <I> buildItem(<I> itemClass){
//        return item;
//    }

    public static Item create(Class<? extends Item> clazz,
                             Item.ToolMaterial material,
                             String imageName,
                             String itemName){

        Item item = null;

        // Get Constructor
        try {
            Constructor<? extends Item> constructor = clazz.getConstructor(Item.ToolMaterial.class, String.class);

            // Instantiate Object
            item = constructor.newInstance(material, imageName);
            GameRegistry.registerItem(item, imageName);

            /**
             * Deprecated for removal in 1.8. Use the assets lang system
             */
            LanguageRegistry.addName(item, itemName);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        return item;
    }

}
