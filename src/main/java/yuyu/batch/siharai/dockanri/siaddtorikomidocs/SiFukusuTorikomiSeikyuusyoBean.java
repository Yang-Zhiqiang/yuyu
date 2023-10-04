package yuyu.batch.siharai.dockanri.siaddtorikomidocs;

import java.io.Serializable;

/**
 * 複数取込請求書リストに必要となるすべての項目を文字列型で保持するクラス。<br />
 */
public class SiFukusuTorikomiSeikyuusyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kouteiKanriId;

    private String seikyuuNo;

    private String syoukenNo;

    private String syoruiCode;

    public String getKouteiKanriId() {
        return kouteiKanriId;
    }

    public void setKouteiKanriId(String pKouteiKanriId) {
        kouteiKanriId = pKouteiKanriId;
    }

    public String getSyoruiCode() {
        return syoruiCode;
    }

    public void setSyoruiCode(String pSyoruiCode) {
        syoruiCode = pSyoruiCode;
    }

    public String getSyoukenNo() {
        return syoukenNo;
    }

    public void setSyoukenNo(String pSyoukenNo) {
        syoukenNo = pSyoukenNo;
    }

    public String getSeikyuuNo() {
        return seikyuuNo;
    }

    public void setSeikyuuNo(String pSeikyuuNo) {
        seikyuuNo = pSeikyuuNo;
    }
}

