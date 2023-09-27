package yuyu.common.direct.dscommon;

import java.io.Serializable;

import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_SoukinyoukzchkkekkaKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通 送金用口座正当性チェック結果Beanクラス
 */
public class CheckSoukinyoukzResultBean implements Serializable  {

    private static final long serialVersionUID = 1L;

    private C_ChkkekkaKbn chkkekkaKbn;

    private C_SoukinyoukzchkkekkaKbn soukinyoukzchkkekkaKbn;

    public C_ChkkekkaKbn getChkkekkaKbn() {
        return chkkekkaKbn;
    }

    public void setChkkekkaKbn(C_ChkkekkaKbn pChkkekkaKbn) {
        chkkekkaKbn = pChkkekkaKbn;
    }

    public C_SoukinyoukzchkkekkaKbn getSoukinyoukzchkkekkaKbn() {
        return soukinyoukzchkkekkaKbn;
    }

    public void setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn pSoukinyoukzchkkekkaKbn) {
        soukinyoukzchkkekkaKbn = pSoukinyoukzchkkekkaKbn;
    }

}
