package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 契約保全 契約保全共通 ＰＡＬ保険金据置Ｆ索引結果Beanクラス
 */
public class PALSueokiFSakuinKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String palBtkykSosysyNo;

    private BizDate palBtkykSosYMD;

    public String getPalBtkykSosysyNo() {
        return this.palBtkykSosysyNo;
    }

    public void setPalBtkykSosysyNo(String pPalBtkykSosysyNo) {
        this.palBtkykSosysyNo = pPalBtkykSosysyNo;
    }

    public BizDate getPalBtkykSosYMD() {
        return this.palBtkykSosYMD;
    }

    public void setPalBtkykSosYMD(BizDate pPalBtkykSosYMD) {
        this.palBtkykSosYMD = pPalBtkykSosYMD;
    }
}
