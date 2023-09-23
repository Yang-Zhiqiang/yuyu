package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 契約保全 契約保全共通 ＰＡＬ契約ＭＦ索引結果Beanクラス
 */
public class PALKykMFSakuinKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String palBtkykSyoNo;

    private BizDate palBtkykKykYMD;

    private String palBtkykSymtCd;

    private BizDate palBtkykSymtYMD;

    public String getPalBtkykSyoNo() {
        return this.palBtkykSyoNo;
    }

    public void setPalBtkykSyoNo(String pPalBtkykSyoNo) {
        this.palBtkykSyoNo = pPalBtkykSyoNo;
    }

    public BizDate getPalBtkykKykYMD() {
        return this.palBtkykKykYMD;
    }

    public void setPalBtkykKykYMD(BizDate pPalBtkykKykYMD) {
        this.palBtkykKykYMD = pPalBtkykKykYMD;
    }

    public String getPalBtkykSymtCd() {
        return this.palBtkykSymtCd;
    }

    public void setPalBtkykSymtCd(String pPalBtkykSymtCd) {
        this.palBtkykSymtCd = pPalBtkykSymtCd;
    }

    public BizDate getPalBtkykSymtYMD() {
        return this.palBtkykSymtYMD;
    }

    public void setPalBtkykSymtYMD(BizDate pPalBtkykSymtYMD) {
        this.palBtkykSymtYMD = pPalBtkykSymtYMD;
    }
}
