package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
class GildedRoseTest {


// test to string
  @Test
  @DisplayName("Test tooString")
  void test_toString() {
    Item element = new Item("foo", 0, 0);    String tmp = element.toString();
    assertEquals(element.name + ", " + element.sellIn + ", " + element.quality, tmp, "the outputis not correct  ");
  }


  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals("foo", element.name, "the name changed");
  }
  

  @Test
  @DisplayName("Test that quality is positive after update")
  void test_quality_positive() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertTrue(element.quality>=0,"sellIn is negative" );

  }

  @Test
  @DisplayName("Test that quality of Aged Brie is less then 50 ")
  void test_quality_of_AgedBrie_less_then_50() {
    Item element = new Item("Aged Brie", 0, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertTrue(element.quality <=50,"La qualité supérieur à 50" );

  }

  @Test
  @DisplayName("Test that quality of Backstage passes to a TAFKAL80ETC concert is less then 50 ")
  void test_quality_of_backstage_less_then_50() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertTrue(element.quality <=50,"La qualité supérieur à 50" );

  }


 @Test
  @DisplayName("Test that Sulfuras sellin fix ")
  void test_sulfuras_sellin_fix() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 100, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(100, element.sellIn, "the sellin of sulfuras changed");

  }

@Test
  @DisplayName("Test that Sulfuras quality fix ")
  void test_sulfuras_quality_fix() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 100, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(80, element.quality, "the quality of sulfuras changed");

  }

@Test
  @DisplayName("test_general_type_seelin_negative_qulaity_positive ")
  void test_general_type_seelin_negative_qulaity_positive() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -10, 30);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(30, element.quality, "the quality is expected to be 30");

  }




@Test
  @DisplayName("test_quality_invrease_Backstage_passes_sellin_more_10 ")
  void test_quality_invrease_Backstage_passes_sellin_more_10() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(21,element.quality,"Value needs to be increased to 21" );

  }

@Test
  @DisplayName("test_quality_invrease_Backstage_passes_sellin__less_10_more_5 ")
  void test_quality_invrease_Backstage_passes_sellin_less_10_more_5() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(22,element.quality,"Value needs to be increased to 22" );

  }

  @Test
  @DisplayName("test_quality_invrease_Backstage_passes_sellin_less_5_more_0 ")
  void test_quality_invrease_Backstage_passes_sellin_less_5_more_0() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(23,element.quality,"Value needs to be increased to 23" );

  }

  @Test
  @DisplayName("test_quality_invrease_Backstage_passes_sellin_less_0 ")
  void test_quality_invrease_Backstage_passes_sellin_less_0() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0,element.quality,"Value needs to be increased to 0" );

  }



@Test
  @DisplayName("test_backstage_mutation_sellin11 ")
  void test_backstage_mutation_sellin11() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(1, element.quality, "the quality is expected to be 1");

  }
@Test
  @DisplayName("test_backstage_mutation_sellin6 ")
  void test_backstage_mutation_sellin6() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(2, element.quality, "the quality is expected to be 2");

  }
  @Test
  @DisplayName("test_backstage_mutation_sellin0 ")
  void test_backstage_mutation_sellin0() {
    Item element = new Item("foo", 1, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(1, element.quality, "the quality is expected to be 2");

  }


  @Test
  @DisplayName("Test that quality of Aged Brie increases proproly")
  void test_quality_increase_Aged_Brie() {
    Item element = new Item("Aged Brie", 5, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(1, element.quality, "the name changed");


  
  }


  @Test
  @DisplayName(" test_quality_decrease_general_case")
  void test_quality_decrease_general_case() {
    Item element = new Item("foo", 5, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(4, element.quality, "expected quality to be 4");


  
  }
  @Test
  @DisplayName("test_quality_decrease_general_case_sellin_negative")
  void test_quality_decrease_general_case_sellin_negative() {
    Item element = new Item("foo", 0, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(3, element.quality, "expected quality to be 3");


  
  }


   @Test
  @DisplayName("test_quality_increase_agedbrie_sellin_negative_quality_less_50")
  void test_quality_increase_agedbrie_sellin_negative_quality_less_50() {
    Item element = new Item("Aged Brie", -1, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(7, element.quality, "expected quality to be 3");

  }

  @Test
  @DisplayName("test_backsatge_quality_from_49_to_50_sellin_less_then_10")
  void test_backsatge_quality_from_49_to_50_sellin_less_then_10() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "expected quality to be 50");

  }
  @Test 
  @DisplayName("test_backsatge_quality_from_49_to_50_sellin_less_then_5")
  void test_backsatge_quality_from_49_to_50_sellin_less_then_5() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "expected quality to be 50");

  }
  @Test 
  @DisplayName("test_Conjured_sell_more_then_0")
  void test_Conjured_sell_more_then_0() {
    Item element = new Item("Conjured Mana Cake", 5, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(47, element.quality, "expected quality to be 47");

  }

  @Test 
  @DisplayName("test_Conjured_sell_less_then_0")
  void test_Conjured_sell_less_then_0() {
    Item element = new Item("Conjured Mana Cake", -1, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(45, element.quality, "expected quality to be 47");

  }
  @Test 
  @DisplayName("test_Conjured_sellIn_decrease")
  void test_Conjured_sellIn_decrease() {
    Item element = new Item("Conjured Mana Cake", 5, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(4, element.sellIn, "expected quality to be 4");

  }
}
