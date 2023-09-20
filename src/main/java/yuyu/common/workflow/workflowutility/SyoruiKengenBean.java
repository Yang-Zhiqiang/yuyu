package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * 権限詳細(書類)情報Bean の処理結果クラスです。<br />
 */
public class SyoruiKengenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kengenId;

    public String getKengenId() {
        return kengenId;
    }

    public void setKengenId(String pKengenId) {
        kengenId = pKengenId;
    }

    private String syoruiCd;

    public String getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(String pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private String syoruiNm;

    public String getSyoruiNm() {
        return syoruiNm;
    }

    public void setSyoruiNm(String pSyoruiNm) {
        syoruiNm = pSyoruiNm;
    }

    private String jimutetuzukiCd;

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd) {
        jimutetuzukiCd = pJimutetuzukiCd;
    }

    public String kengenFlg;

    public String getKengenFlg() {
        return kengenFlg;
    }

    public void setKengenFlg(String kengenFlg) {
        this.kengenFlg = kengenFlg;
    }


}
