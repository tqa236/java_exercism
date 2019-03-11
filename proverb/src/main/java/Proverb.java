class Proverb {

  private String[] objects;

  Proverb(String[] words) {
    objects = words;
  }

  public String recite() {
    String proverb = "";
    for (int i = 0; i < objects.length - 1; i++) {
      proverb = proverb + "For want of a " + objects[i] + " the " + objects[i + 1] + " was lost.\n";
    }
    if (objects.length > 0) {
      proverb = proverb + "And all for the want of a " + objects[0] + ".";
    }
    return proverb;
  }
}
