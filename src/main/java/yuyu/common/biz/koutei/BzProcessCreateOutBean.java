package yuyu.common.biz.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;

/**
 * 業務共通 工程 業務共通工程作成出力Bean
 */
public class BzProcessCreateOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_KouteiSakuseiKekkaKbn kouteiSakuseiKekkaKbn;

    private String kouteiKanriId;

    public C_KouteiSakuseiKekkaKbn getKouteiSakuseiKekkaKbn() {
        return kouteiSakuseiKekkaKbn;
    }

    public void setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn pKouteiSakuseiKekkaKbn) {
        kouteiSakuseiKekkaKbn = pKouteiSakuseiKekkaKbn;
    }

    public String getKouteiKanriId() {
        return kouteiKanriId;
    }

    public void setKouteiKanriId(String pKouteiKanriId) {
        kouteiKanriId = pKouteiKanriId;
    }
}
