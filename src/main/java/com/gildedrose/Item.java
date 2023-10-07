package com.gildedrose;

public class Item {

  public static final int MINIMUM_QUALITY = 0;
  public static final int MAXIMUM_QUALITY = 50;
  public static final String AGED_BRIE = "Aged Brie";
  public static final String BACKSTAGE =
    "Backstage passes to a TAFKAL80ETC concert";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  public String name;
  public int sellIn;
  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }

  public boolean isAgedBrie() {
    return this.name == AGED_BRIE;
  }

  public boolean isBackstagePass() {
    return this.name == BACKSTAGE;
  }

  public boolean isSulfuras() {
    return this.name == SULFURAS;
  }

  public void updateItemQuality() {
    if (!this.isSulfuras()) {
      if (!this.isAgedBrie() && !this.isBackstagePass()) {
        if (this.quality > MINIMUM_QUALITY) {
          this.quality -= 1;
        }
      } else {
        if (this.quality < MAXIMUM_QUALITY) {
          this.quality += 1;

          if (this.name.equals(BACKSTAGE)) {
            if (this.sellIn < 11 ) {
              this.quality = Math.min(this.quality+1,MAXIMUM_QUALITY);
            }

            if (this.sellIn < 6) {
              this.quality = Math.min(this.quality+1,MAXIMUM_QUALITY);
            }
          }
        }
      }

      this.sellIn -= 1;

      if (this.sellIn < 0) {
        if (!this.name.equals(AGED_BRIE)) {
          if (!this.name.equals(BACKSTAGE) && this.quality > MINIMUM_QUALITY) {
            this.quality -= 1;
          } else {
            this.quality = 0;
          }
        } else {
          if (this.quality < MAXIMUM_QUALITY) {
            this.quality += 1;
          }
        }
      }
    }
  }
}
