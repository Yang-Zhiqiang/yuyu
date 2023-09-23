package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 契約保全 契約保全共通 ＰＡＬ総合年金支払Ｆ索引結果Beanクラス
 */
public class PALSouNenkinFSakuinKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String palBtkykNkSysyNo;

    private BizDate palBtkykNkShrYMD;

    private String palBtkykNkSymtCd;

    private BizDate palBtkykNkSymtYMD;

    public String getPalBtkykNkSysyNo() {
        return this.palBtkykNkSysyNo;
    }

    public void setPalBtkykNkSysyNo(String pPalBtkykNkSysyNo) {
        this.palBtkykNkSysyNo = pPalBtkykNkSysyNo;
    }

    public BizDate getPalBtkykNkShrYMD() {
        return this.palBtkykNkShrYMD;
    }

    public void setPalBtkykNkShrYMD(BizDate pPalBtkykNkShrYMD) {
        this.palBtkykNkShrYMD = pPalBtkykNkShrYMD;
    }

    public String getPalBtkykNkSymtCd() {
        return this.palBtkykNkSymtCd;
    }

    public void setPalBtkykNkSymtCd(String pPalBtkykNkSymtCd) {
        this.palBtkykNkSymtCd = pPalBtkykNkSymtCd;
    }

    public BizDate getPalBtkykNkSymtYMD() {
        return this.palBtkykNkSymtYMD;
    }

    public void setPalBtkykNkSymtYMD(BizDate pPalBtkykNkSymtYMD) {
        this.palBtkykNkSymtYMD = pPalBtkykNkSymtYMD;
    }
}
