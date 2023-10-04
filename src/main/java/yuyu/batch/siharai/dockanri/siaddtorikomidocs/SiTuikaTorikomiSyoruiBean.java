package yuyu.batch.siharai.dockanri.siaddtorikomidocs;

import java.io.Serializable;

import yuyu.def.classification.C_ShrSkJyoukyou;
import yuyu.def.classification.C_ShrSkJyoukyouGtymd;

/**
 * 追加取込書類リストに必要となるすべての項目を文字列型で保持するクラス。<br />
 */
public class SiTuikaTorikomiSyoruiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ShrSkJyoukyou skJyoukyou;

    private String syoukenNo;

    private String seikyuuNo;

    private C_ShrSkJyoukyouGtymd skJyoukyouGtymd;

    private String hiDuke;

    private String syoruiCode;

    private String syoruiNm;

    public C_ShrSkJyoukyou getSkJyoukyou() {
        return skJyoukyou;
    }

    public void setSkJyoukyou(C_ShrSkJyoukyou pSkJyoukyou) {
        skJyoukyou = pSkJyoukyou;
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

    public C_ShrSkJyoukyouGtymd getSkJyoukyouGtymd() {
        return skJyoukyouGtymd;
    }

    public void setSkJyoukyouGtymd(C_ShrSkJyoukyouGtymd pSkJyoukyouGtymd) {
        skJyoukyouGtymd = pSkJyoukyouGtymd;
    }

    public String getHiduke() {
        return hiDuke;
    }

    public void setHiduke(String pHiduke) {
        hiDuke = pHiduke;
    }

    public String getSyoruiCode() {
        return syoruiCode;
    }

    public void setSyoruiCode(String pSyoruiCode) {
        syoruiCode = pSyoruiCode;
    }

    public String getSyoruiNm() {
        return syoruiNm;
    }

    public void setSyoruiNm(String pSyoruiNm) {
        syoruiNm = pSyoruiNm;
    }
}
