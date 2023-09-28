package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import yuyu.def.classification.C_RirekiKbn;

/**
 * 業務共通 共通 業務共通工程履歴取得入力Bean
 */
public class BzGetProcessRecordInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jimuTetuzukiCd = null;

    private String kouteiKanriId = null;

    private C_RirekiKbn rirekiKbn;

    public String getJimuTetuzukiCd() {
        return jimuTetuzukiCd;
    }

    public void setJimuTetuzukiCd(String pJimutetuzukiCd) {
        jimuTetuzukiCd = pJimutetuzukiCd;
    }

    public String getKouteiKanriId() {
        return kouteiKanriId;
    }

    public void setKouteiKanriId(String pKouteiKanriId) {
        kouteiKanriId = pKouteiKanriId;
    }

    public C_RirekiKbn getRirekiKbn() {
        return rirekiKbn;
    }

    public void setRirekiKbn(C_RirekiKbn pRirekiKbn) {
        this.rirekiKbn = pRirekiKbn;
    }
}
