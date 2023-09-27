package yuyu.common.direct.dscommon;

import java.io.Serializable;

import yuyu.def.classification.C_UmuKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ顧客有効契約判定Bean<br/>
 */
public class DsKokyakuYuukouKeiyakuHanteiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_UmuKbn yuukouKeiyakuUmuKbn;

    public C_UmuKbn getYuukouKeiyakuUmuKbn() {
        return yuukouKeiyakuUmuKbn;
    }

    public void setYuukouKeiyakuUmuKbn(C_UmuKbn pYuukouKeiyakuUmuKbn) {
        yuukouKeiyakuUmuKbn = pYuukouKeiyakuUmuKbn;
    }
}
