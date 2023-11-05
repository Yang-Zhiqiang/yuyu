package yuyu.app.base.ref;

public class Key {

    private String key;

    public Key(String key) {
        this.key = key;
    }

    public String getKeyValue(){
        return this.key;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Key) {
            return key.equals(((Key) obj).key);
        }
        return false;
    }

    @Override
    public int hashCode() {

        return key.hashCode();
    }

}
