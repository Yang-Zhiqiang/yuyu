package yuyu.infr.report.swakreport.config;

/**
 * セキュリティ情報格納部品
 */
public class EncryptInfoConfig {

    @Deprecated
    public EncryptInfoConfig() { }

    private String userPassword;

    private String ownerPassword;

    private boolean print;

    private boolean contents;

    private boolean copy;

    private boolean notesAndField;

    public String getUserPassword() {
        return userPassword;
    }

    @Deprecated
    public void setUserPassword(String pUserPassword) {
        userPassword = pUserPassword;
    }

    public String getOwnerPassword() {
        return ownerPassword;
    }

    @Deprecated
    public void setOwnerPassword(String pOwnerPassword) {
        ownerPassword = pOwnerPassword;
    }

    public boolean isPrint() {
        return print;
    }

    @Deprecated
    public void setPrint(boolean pPrint) {
        print = pPrint;
    }

    public boolean isContents() {
        return contents;
    }

    @Deprecated
    public void setContents(boolean pContents) {
        contents = pContents;
    }

    public boolean isCopy() {
        return copy;
    }

    @Deprecated
    public void setCopy(boolean pCopy) {
        copy = pCopy;
    }

    public boolean isNotesAndField() {
        return notesAndField;
    }

    @Deprecated
    public void setNotesAndField(boolean pNotesAndField) {
        notesAndField = pNotesAndField;
    }

    @Override
    public EncryptInfoConfig clone() {
        EncryptInfoConfig conf = new EncryptInfoConfig();
        conf.setUserPassword    (this.getUserPassword());
        conf.setOwnerPassword   (this.getOwnerPassword());
        conf.setPrint           (this.isPrint());
        conf.setContents        (this.isContents());
        conf.setCopy            (this.isCopy());
        conf.setNotesAndField   (this.isNotesAndField());
        return conf;
    }
}
