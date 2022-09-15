package zombie.apocalypse.kata;

public class Item {
    public final Scope scope;
    public final String type;

    public Item(Scope scope, String type) {
        this.scope = scope;
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
