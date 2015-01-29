package com.baselogic.minecraft.tutorial;

import com.baselogic.minecraft.tutorial.items.CoolSword;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Arrays;

/**
 * Recipe Factory
 */
public class RecipeFactory {

//    private static GameRegistry gameRegistry;
//
//    public RecipeFactory(GameRegistry registry){
//        this.gameRegistry = registry;
//    }

    public static Item create(Item item, int someNumber, Object ... ingredients){

        if(ingredientsAreValid(ingredients)) {

            // RECIPE
            GameRegistry.addRecipe(new ItemStack(item, someNumber), ingredients);

            return item;
        } else {
            throw new IllegalArgumentException("Ingredients for recipe are invalid: " + ingredients);
        }
    }

    protected static boolean ingredientsAreValid(Object ... ingredients){

        boolean returnValue = false;

        // ingredients can have:
        // 3 rows of one, two or three characters
        // then up to 9 pairs of:
        //   1 char IDENTIFIER
        //   2 Item
        // 18 total elements at the most.

        String row1 = (String)ingredients[0];
        String row2 = (String)ingredients[1];
        String row3 = (String)ingredients[2];

        if(row1.length() == row2.length() && row1.length() == row3.length()){
            // So far, so good
            returnValue = true;
        } else {
            throw new IllegalArgumentException("All three rows must contain the same number of item slots (1..3): " + ingredients);
        }

        // Must have at least 2 elements for one index, and a maximum of 18 elements
        Object[] identifiers = Arrays.copyOfRange(ingredients, 3, ingredients.length);

        if(identifiers.length >=2 && identifiers.length <=18 && identifiers.length % 2 == 0){
            returnValue = true;
        }

        return returnValue;
    }


}
