package yuyu.common.biz.bzcommon;

import javax.persistence.Column;

import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.mapping.GenZT_DsKariPasswordTuutiRn;


public class ConvClass5 {

    private String zrnatesakiyno;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNATESAKIYNO)
    public String getZrnatesakiyno() {
        return zrnatesakiyno;
    }

    @Padding(mode = "right", padChar = '0', length = 8)
    public void setZrnatesakiyno(String pZrnatesakiyno) {
        zrnatesakiyno = pZrnatesakiyno;
    }
}
