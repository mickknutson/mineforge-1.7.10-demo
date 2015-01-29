package com.baselogic.minecraft.tutorial;

import com.baselogic.minecraft.tutorial.items.CoolSword;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

//import org.mockito.Mock;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class RecipeFactoryTest {

//    private static final Logger logger = LoggerFactory
//            .getLogger(KioskServiceTests.class);
//
//    @Mock
//    private DVDInfoDAO dao;

    private Item item;


    @Before
    public void beforeEachTest() {

    }

    @Test
    public void validRecipeWithOneIndex() {
//        logger.info("validRecipeWithOneIndex");

        item = new CoolSword(Item.ToolMaterial.IRON, "Test Sword");

        RecipeFactory.create(item, 1,
                "BBB", // Row 1
                " B ", // Row 2
                " B ", // Row 3
                'B', Items.brick // Index
        );

    }

    @Test
    public void ingredientsAreValid_validInputs() {
//        logger.info("validRecipeWithOneIndex");

        String[] rowData = new String[]
                {
                        " ", "  ", "   ",
                        "B", "B ", " B", "BB",
                        "B  ", " B ", "  B",
                        "BB ", " BB", "B B", "BBB",
                };
        for (String s : rowData) {
            boolean result = RecipeFactory.ingredientsAreValid(s, // Row 1
                    s, // Row 2
                    s, // Row 3
                    'B', Items.brick // Index
            );
            assertThat(result, is(true));
        }
    }

    @Test
    public void ingredientsAreValid_invalidInputs() {
//        logger.info("validRecipeWithOneIndex");

        String[] rowData = new String[]
                {
                        " ", "  ", "   ",
                        "B", "B ", " B", "BB",
                        "B  ", " B ", "  B",
                        "BB ", " BB", "B B", "BBB",
                };
        for (String s : rowData) {
            try {
                boolean result = RecipeFactory.ingredientsAreValid(s + s, // Row 1
                        s, // Row 2
                        s, // Row 3
                        'B', Items.brick // Index
                );

                fail();
            } catch (IllegalArgumentException e) {
                assertThat(e.getMessage(), is(notNullValue()));
            }
        }

        for (String s : rowData) {
            try {
                boolean result = RecipeFactory.ingredientsAreValid(s, // Row 1
                        s + s, // Row 2
                        s, // Row 3
                        'B', Items.brick // Index
                );

                fail();
            } catch (IllegalArgumentException e) {
                assertThat(e.getMessage(), is(notNullValue()));
            }
        }

        for (String s : rowData) {
            try {
                boolean result = RecipeFactory.ingredientsAreValid(s, // Row 1
                        s, // Row 2
                        s + s, // Row 3
                        'B', Items.brick // Index
                );

                fail();
            } catch (IllegalArgumentException e) {
                assertThat(e.getMessage(), is(notNullValue()));
            }
        }

    }


} // The End...
