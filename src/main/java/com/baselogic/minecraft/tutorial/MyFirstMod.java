package com.baselogic.minecraft.tutorial;

import com.baselogic.minecraft.tutorial.items.ItemFactory;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
/* IMPORT / INCLUDE SECTION ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
// Import our Sword
import com.baselogic.minecraft.tutorial.items.CoolSword;
import net.minecraftforge.common.util.EnumHelper;

/* ^ END ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */


/**
 *
 * This is the file that MineCraft runs, and uses to include the extra things
 * you want to add to your mineCraft world.
 */
@Mod(modid = MyFirstMod.MODID, version = MyFirstMod.VERSION)
public class MyFirstMod {

    public static final String MODID = "SLC Modification";
    public static final String VERSION = "1.0";


    /* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
    /* DECLARATION SECTION ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
    /* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
    //  DECLARE THE SWORD
    public static Item myCoolSword_1;

    //  DECLARE NEW TOOL MATERIAL
    public static Item.ToolMaterial myCoolToolMaterial =
            EnumHelper.addToolMaterial(
                    "Awesomeness",  // Material Name
                    3,              // Harvest Level
                    99999,           // Maximum Uses
                    8.0F,           // Efficiency (How efficient is this material??? )
                    15.0F,           // Damage
                    20              // Enchantability Level
            );


    /* ^ END ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        /* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
        /* LOAD SECTION ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
        /* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
        //  LOAD THE SWORD
        myCoolSword_1 = ItemFactory.create( CoolSword.class,
                myCoolToolMaterial,
                "MyCoolSword_image_1",
                "My Cool Sword");


        /* ^ END ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {

        /* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
        /* RECIPES SECTION ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
        /* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
        RecipeFactory.create(myCoolSword_1, 1,
                "BBB", // Row 1
                " S ", // Row 2
                " S ", // Row 3
                'B', Items.brick, // Index
                'S', Items.stick // Index
        );



        /* ^ END ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {}

} // ^ The End... ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
