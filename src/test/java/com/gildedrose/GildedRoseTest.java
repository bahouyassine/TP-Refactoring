package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/*

sellin --> days left to sell
quality ---> degrades at diffrent speeds depending on the type of the product and sellin
updateQuality--> Update the values at the end of each day




tests to do : 
	- when "sellIn"== 0 the "quality" decreses X2
	- "quality">0
	- if name = Aged Brie ----> "quality" += 1
	- "qualitu" < 50
	- "Sulfuras" "sellin" fix and "quality" fix
	- "Backstage passes" 
		- quality += 2 if sellin <=10
		- quality += 3 if 0 < sellin <=5 
		- quality == 0 if sellin == 0
	- Conjured --> quality -= 2 
  */
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
  @DisplayName("Test that quality of Backstage passes increases proproly")
  void test_quality_invrease_Backstage_passes_to_a_TAFKAL80ETC_concert() {
    Item[] items = new Item[] {
      new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), //
      new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20), //
      new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20), //
      new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20), //
     };

    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(21,items[0].quality,"Value needs to be increased to 21" );
    assertEquals(22,items[1].quality,"Value needs to be increased to 22" );
    assertEquals(23,items[2].quality,"Value needs to be increased to 23" );
    assertEquals(0,items[3].quality,"Value needs to be decreased to 0" );

  
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




/* --
/* -----------------------------not yet implemented----------------------
 @Test
  @DisplayName("Test that quality of Conjured Mana Cake decreses proproly sellin not zero")
  void test_quality_decrease_Conjured_sellin_non_zero() {
    Item element = new Item("Conjured Mana Cake", 5, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(8, element.quality, "expected quality to be 8");
  
  }


 @Test
  @DisplayName("Test that quality of Conjured Mana Cake decreses proproly sellin zero")
  void test_quality_decrease_Conjured_zero() {
    Item element = new Item("Conjured Mana Cake", 0, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(6, element.quality, "expected quality to be 6");
  
  }
*/
}
