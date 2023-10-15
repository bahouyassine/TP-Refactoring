package com.gildedrose;

public class Item {

  public static final int MINIMUM_QUALITY = 0;
  public static final int MAXIMUM_QUALITY = 50;
  public static final String AGED_BRIE = "Aged Brie";
  public static final String BACKSTAGE =
    "Backstage passes to a TAFKAL80ETC concert";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  public static final String CONJURED = "Conjured Mana Cake";

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

  public void updateItemQuality() {
    switch (this.name) {
        case SULFURAS:
            break;
        case AGED_BRIE:
            updateQualityForAgedBrie();
            break;
        case BACKSTAGE:
            updateQualityForBackstage();
            break;
        case CONJURED:
            updateQualityForConjured();
            break;
        default:
            updateQualityForRegularItem();
            break;
    }
}

private void updateQualityForAgedBrie() {
    this.quality = Math.min(this.quality + 1, MAXIMUM_QUALITY);
    this.sellIn -= 1;
    if (this.sellIn < 0) {
        this.quality = Math.min(this.quality + 1, MAXIMUM_QUALITY);
    }
}

private void updateQualityForBackstage() {
    if (this.sellIn >= 11) {
        this.quality = Math.min(this.quality + 1, MAXIMUM_QUALITY);
    } else if (this.sellIn >= 6) {
        this.quality = Math.min(this.quality + 2, MAXIMUM_QUALITY);
    } else if (this.sellIn >= 0) {
        this.quality = Math.min(this.quality + 3, MAXIMUM_QUALITY);
    }
    this.sellIn -= 1;
    if (this.sellIn < 0) {
        this.quality = 0;
    }
}

private void updateQualityForConjured() {
    if (this.sellIn > 0) {
        this.quality -= 2;
    } else {
        this.quality -= 4;
    }
}

private void updateQualityForRegularItem() {
    this.quality = Math.max(this.quality - 1, MINIMUM_QUALITY);
    this.sellIn -= 1;
    if (this.sellIn < 0) {
        this.quality = Math.max(this.quality - 1, MINIMUM_QUALITY);
    }
}

}
