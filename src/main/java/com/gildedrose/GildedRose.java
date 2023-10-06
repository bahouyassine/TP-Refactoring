package com.gildedrose;

class GildedRose {

  public static final int MINIMUM_QUALITY = 0;
  public static final int MAXIMUM_QUALITY = 50;
  public static final String AGED_BRIE = "Aged Brie";
  public static final String BACKSTAGE =
    "Backstage passes to a TAFKAL80ETC concert";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  Item[] items;
  int i;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      items[i].updateItemQuality();
    }
  }
}
