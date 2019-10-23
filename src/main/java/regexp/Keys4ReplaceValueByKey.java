package regexp;

public enum Keys4ReplaceValueByKey {
    CARD_NUMBER("card_number"),
    CARD_MASK_NUMBER("card_mask_number"),
    CARD_EXTRA_RS("card_extrars"),
    CARD_EXPIRE_DATE("card_expire");

    public String keyName;

    Keys4ReplaceValueByKey(String key) {
        this.keyName = key;
    }
}
