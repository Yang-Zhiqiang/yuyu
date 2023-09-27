package yuyu.common.direct.dscommon;

import java.io.Serializable;

import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_DsZokuseinochkkekkaKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通 属性番号チェック結果Beanクラス
 */
public class CheckZokuseinoResultBean implements Serializable  {

    private static final long serialVersionUID = 1L;

    private C_ChkkekkaKbn chkkekkaKbn;

    private C_DsZokuseinochkkekkaKbn dsZokuseinochkkekkaKbn;

    public C_ChkkekkaKbn getChkkekkaKbn() {
        return chkkekkaKbn;
    }

    public void setChkkekkaKbn(C_ChkkekkaKbn pChkkekkaKbn) {
        chkkekkaKbn = pChkkekkaKbn;
    }

    public C_DsZokuseinochkkekkaKbn getDsZokuseinochkkekkaKbn() {
        return dsZokuseinochkkekkaKbn;
    }

    public void setDsZokuseinochkkekkaKbn(C_DsZokuseinochkkekkaKbn pDsZokuseinochkkekkaKbn) {
        dsZokuseinochkkekkaKbn = pDsZokuseinochkkekkaKbn;
    }

}
