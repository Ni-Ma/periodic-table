package periodictable;

public enum Type {
    METALLOID("ff6235"),
    OTHER_NONMETAL("bf2b00"),
    HALOGEN("00ea6c"),
    NOBLE_GAS("005c2b"),
    ALKALI_METAL("065179"),
    ALKALINE_EARTH_METAL("821d00"),
    LANTHANOID("824700"),
    ACTINOID("ffa335"),
    TRANSITION_METAL("ff8b00"),
    POST_TRANSITION_METAL("0b98e4");

    private final String color; // color of button for element type
    Type(String color) {
        this.color = color;
    }
    public String color(){  return color;   }
}
