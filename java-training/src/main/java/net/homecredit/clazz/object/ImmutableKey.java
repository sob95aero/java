package net.homecredit.clazz.object;

public final class ImmutableKey {

    private String identifier;
    private Long value;

    public ImmutableKey(String key, Long value) {
        this.identifier = key;
        this.value = value;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Long getValue() {
        return value;
    }


    public ImmutableKey updateIdentifier(String key) {
        return new ImmutableKey(key, this.getValue());
    }
}
