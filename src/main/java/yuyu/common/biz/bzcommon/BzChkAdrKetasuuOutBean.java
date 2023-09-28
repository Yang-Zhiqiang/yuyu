package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import yuyu.def.classification.C_JyougenketasuutyoukaKbn;

/**
 * 業務共通 業務共通 住所桁数チェック出力Beanクラス
 */
public class BzChkAdrKetasuuOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_JyougenketasuutyoukaKbn jyougenKetasuuTyoukaKbn;

    private int inKetasuu;

    private int inJyougenKetasuu;

    public C_JyougenketasuutyoukaKbn getJyougenKetasuuTyoukaKbn() {
        return jyougenKetasuuTyoukaKbn;
    }

    public void setJyougenKetasuuTyoukaKbn(C_JyougenketasuutyoukaKbn pJyougenKetasuuTyoukaKbn) {
        jyougenKetasuuTyoukaKbn = pJyougenKetasuuTyoukaKbn;
    }

    public int getInKetasuu() {
        return inKetasuu;
    }

    public void setInKetasuu(int pInKetasuu) {
        inKetasuu = pInKetasuu;
    }

    public int getInJyougenKetasuu() {
        return inJyougenKetasuu;
    }

    public void setInJyougenKetasuu(int pInJyougenKetasuu) {
        inJyougenKetasuu = pInJyougenKetasuu;
    }
}
