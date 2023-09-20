package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * 取込書類マスタBean の処理結果クラスです。<br />
 */
public class TorikomiSyoruiMstAndKengenBean implements Serializable {

    private static final long serialVersionUID = 1L;

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


    private String syoruiRyakuNm;

    public String getSyoruiRyakuNm() {
        return syoruiRyakuNm;
    }

    public void setSyoruiRyakuNm(String pSyoruiRyakuNm) {
        syoruiRyakuNm = pSyoruiRyakuNm;
    }


    private String syzkSyouBunruiId;

    public String getSyzkSyouBunruiId() {
        return syzkSyouBunruiId;
    }

    public void setSyzkSyouBunruiId(String pSyzkSyouBunruiId) {
        syzkSyouBunruiId = pSyzkSyouBunruiId;
    }


    private String syzkDaiBunruiId;

    public String getSyzkDaiBunruiId() {
        return syzkDaiBunruiId;
    }

    public void setSyzkDaiBunruiId(String pSyzkDaiBunruiId) {
        syzkDaiBunruiId = pSyzkDaiBunruiId;
    }

    private String jimutetuzukiCd;

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd) {
        jimutetuzukiCd = pJimutetuzukiCd;
    }


    private String zipHozonKbn;

    public String getZipHozonKbn() {
        return zipHozonKbn;
    }

    public void setZipHozonKbn(String pZipHozonKbn) {
        zipHozonKbn = pZipHozonKbn;
    }


    private String kouteiSeigyoUmuKbn;

    public String getKouteiSeigyoUmuKbn() {
        return kouteiSeigyoUmuKbn;
    }

    public void setKouteiSeigyoUmuKbn(String pKouteiSeigyoUmuKbn) {
        kouteiSeigyoUmuKbn = pKouteiSeigyoUmuKbn;
    }

    private String taskNm;

    public String getTaskNm() {
        return taskNm;
    }

    public void setTaskNm(String pTaskNm) {
        taskNm = pTaskNm;
    }

    private String kengenUmu;

    public String getKengenUmu() {
        return kengenUmu;
    }

    public void setKengenUmu(String pKengenUmu) {
        kengenUmu = pKengenUmu;
    }
}
