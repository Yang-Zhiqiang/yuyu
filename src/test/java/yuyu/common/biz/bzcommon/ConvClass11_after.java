package yuyu.common.biz.bzcommon;

import javax.persistence.Column;

import yuyu.def.db.mapping.GenZT_HonsyaToukeiRn;

public class ConvClass11_after {

    private String zrnkojincd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKOJINCD)
    public String getZrnkojincd() {
        return zrnkojincd;
    }

    public void setZrnkojincd(String pZrnkojincd) {
        zrnkojincd = pZrnkojincd;
    }
}
