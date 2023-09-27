package yuyu.common.direct.dscommon;

import java.io.Serializable;

import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_SoukinyoukzinputchkkekkaKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通 送金用口座入力チェック結果Beanクラス
 */
public class CheckSoukinyoukzinputResultBean implements Serializable  {

    private static final long serialVersionUID = 1L;

    private C_ChkkekkaKbn chkkekkaKbn;

    private C_SoukinyoukzinputchkkekkaKbn soukinyoukzinputchkkekkaKbn;

    public C_ChkkekkaKbn getChkkekkaKbn() {
        return chkkekkaKbn;
    }

    public void setChkkekkaKbn(C_ChkkekkaKbn pChkkekkaKbn) {
        chkkekkaKbn = pChkkekkaKbn;
    }

    public C_SoukinyoukzinputchkkekkaKbn getSoukinyoukzinputchkkekkaKbn() {
        return soukinyoukzinputchkkekkaKbn;
    }

    public void setSoukinyoukzinputchkkekkaKbn(C_SoukinyoukzinputchkkekkaKbn pSoukinyoukzinputchkkekkaKbn) {
        soukinyoukzinputchkkekkaKbn = pSoukinyoukzinputchkkekkaKbn;
    }

}
