public class Card {
    private String name;
    private String type;
    private int count;

    public Card(String name, String type, int count) {
        this.name = name;
        this.type = type;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return name + " (" + type + ") x" + count;
    }
}

    
