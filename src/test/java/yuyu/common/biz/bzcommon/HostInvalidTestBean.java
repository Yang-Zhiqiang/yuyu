package yuyu.common.biz.bzcommon;

import yuyu.infr.validation.constraints.HostInvalidCharacter;

public class HostInvalidTestBean {

    @HostInvalidCharacter
    private String toHostInvalidItem1;

    @HostInvalidCharacter
    private String toHostInvalidItem2;

    private String item;

    public String getToHostInvalidItem1() {
        return toHostInvalidItem1;
    }

    public void setToHostInvalidItem1(String toHostInvalidItem1) {
        this.toHostInvalidItem1 = toHostInvalidItem1;
    }

    public String getToHostInvalidItem2() {
        return toHostInvalidItem2;
    }

    public void setToHostInvalidItem2(String toHostInvalidItem2) {
        this.toHostInvalidItem2 = toHostInvalidItem2;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}
