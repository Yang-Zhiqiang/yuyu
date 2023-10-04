package yuyu.batch.hozen.khansyuu.khuriageseikyuukekkatrsks;

import java.io.Serializable;

import yuyu.def.db.entity.IT_UriageSkDataSyuKnr;

/**
 * 突合せチェック１結果Beanクラスです。<br />
 */
public class TukiawaseCheck1KekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean result;

    private IT_UriageSkDataSyuKnr uriageSkDataSyuKnr;

    private int uriageSkDataSyuKnrTblEditKbn;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean pResult) {
        this.result = pResult;
    }

    public IT_UriageSkDataSyuKnr getUriageSkDataSyuKnr() {
        return uriageSkDataSyuKnr;
    }

    public void setUriageSkDataSyuKnr(IT_UriageSkDataSyuKnr pUriageSkDataSyuKnr) {
        this.uriageSkDataSyuKnr = pUriageSkDataSyuKnr;
    }

    public int getUriageSkDataSyuKnrTblEditKbn() {
        return uriageSkDataSyuKnrTblEditKbn;
    }

    public void setUriageSkDataSyuKnrTblEditKbn(int pUriageSkDataSyuKnrTblEditKbn) {
        this.uriageSkDataSyuKnrTblEditKbn = pUriageSkDataSyuKnrTblEditKbn;
    }


}
