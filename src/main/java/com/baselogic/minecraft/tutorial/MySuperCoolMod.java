package com.baselogic.minecraft.tutorial;

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
/** IMPORT SECTION ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */

import com.baselogic.minecraft.tutorial.items.CoolSword;
import com.baselogic.minecraft.tutorial.items.ItemFactory;
import com.baselogic.minecraft.tutorial.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

/**
 * This is the file that MineCraft runs, and uses to include the extra things
 * you want to add to your mineCraft world.
 */
@Mod(name=MySuperCoolMod.MODNAME, modid = MySuperCoolMod.MODID, version = MySuperCoolMod.VERSION)
public class MySuperCoolMod {

    public static final String MODNAME = "Micks Cool Mod";
    public static final String MODID = "micks_super_cool_mod";
    public static final String VERSION = "2.2";

    /*	PROXY INFO */
    @SidedProxy(clientSide = "com.baselogic.minecraft.tutorial.proxies.ClientProxy",
            serverSide = "com.baselogic.minecraft.tutorial.proxies.CommonProxy")
    public static CommonProxy proxy;


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
                    1561,           // Maximum Uses
                    8.0F,           // Efficiency (How efficient is this material??? )
                    3.0F,           // Damage
                    10              // Enchantability Level
            );


    /* ^ END ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        /* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
        /* LOAD SECTION ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
        /* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
        //  LOAD THE SWORD
        myCoolSword_1 = ItemFactory.create( CoolSword.class,
                                            myCoolToolMaterial,
                                            "CoolSword_image_1",
                                            "My Cool Sword");


        /* ^ END ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
    }

    @EventHandler
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

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

    }

} // ^ The End... ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
