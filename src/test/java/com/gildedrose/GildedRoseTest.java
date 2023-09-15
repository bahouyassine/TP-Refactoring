package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

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
  @DisplayName("Test that quality is less then 50 ")
  void test_quality_less_then_50() {
    Item element = new Item("Aged Brie", 0, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertTrue(element.quality <=50,"La qualité supérieur à 50" );

  }


  
  @Test
  @DisplayName("Test that quality of Aged Brie increases proproly")
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
  void test_quality_invrease_Aged_Brie() {
    Item element = new Item("Aged Brie", 5, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(1, element.quality, "the name changed");


  
  }

}
