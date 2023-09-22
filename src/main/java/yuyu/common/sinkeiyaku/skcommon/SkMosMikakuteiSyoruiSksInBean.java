package yuyu.common.sinkeiyaku.skcommon;

import java.io.Serializable;

import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 新契約 新契約共通 新契約申込未確定書類作成入力Bean
 */
public class SkMosMikakuteiSyoruiSksInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SyoruiCdKbn syoruiCd;

    private String documentId;

    public SkMosMikakuteiSyoruiSksInBean() {
        super();
        syoruiCd = C_SyoruiCdKbn.BLNK;
        documentId = "";
    }
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        this.syoruiCd = pSyoruiCd;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String pDocumentid) {
        this.documentId = pDocumentid;
    }

}
