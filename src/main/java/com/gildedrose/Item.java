package com.gildedrose;

public class Item {


  public static final int MINIMUM_QUALITY = 0;
  public static final int MAXIMUM_QUALITY = 50;
  public static final String AGED_BRIE = "Aged Brie";
  public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
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



//    public void inceraseQuality(){
//         if (this.quality < MAXIMUM_QUALITY) {
//            this.quality += 1;

//           if (this.name.equals(BACKSTAGE)) {
//             if (this.sellIn < 11 && this.quality < MAXIMUM_QUALITY) {
//                 this.quality +=  1;
//             }

//             if (this.sellIn < 6 && this.quality < MAXIMUM_QUALITY) {
//                 this.quality +=  1;
//             }
//           }
//         }

//          if (this.sellIn < 0 && this.quality < MAXIMUM_QUALITY) {
//              if (this.quality < MAXIMUM_QUALITY) {
//             this.quality += 1;
//           }}

//     } 


    public void updateQuality() {

          // switch(this.name ) {
          //   case AGED_BRIE:
          //     // code block
          //     break;
          //   case BACKSTAGE:
          //     // code block
          //     break;
          //   case SULFURAS:
          //       break;

          //   default:
          //      this.sellIn -= 1;



}

    
      }

