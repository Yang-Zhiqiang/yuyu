package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;


/**
 * 保険金給付金支払 保険金給付金支払帳票編集 障害診断書編集Bean
 */
public class EditSyougaisindansyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private String hhknnmKn;

    private String hhknnmKj;

    private BizDate hhknseiYmd;

    public EditSyougaisindansyoBean() {
        super();
    }

    public SiTyouhyouHensyuuCommonBean getSiTyouhyouHensyuuCommonBean() {
        return siTyouhyouHensyuuCommonBean;
    }

    public void setSiTyouhyouHensyuuCommonBean(SiTyouhyouHensyuuCommonBean pSiTyouhyouHensyuuCommonBean) {
        siTyouhyouHensyuuCommonBean = pSiTyouhyouHensyuuCommonBean;
    }

    public String getHhknnmKn() {
        return hhknnmKn;
    }

    public void setHhknnmKn(String pHhknnmKn) {
        hhknnmKn = pHhknnmKn;
    }

    public String getHhknnmKj() {
        return hhknnmKj;
    }

    public void setHhknnmKj(String pHhknnmKj) {
        hhknnmKj = pHhknnmKj;
    }

    public BizDate getHhknseiYmd() {
        return hhknseiYmd;
    }

    public void setHhknseiYmd(BizDate pHhknseiYmd) {
        hhknseiYmd = pHhknseiYmd;
    }

}
