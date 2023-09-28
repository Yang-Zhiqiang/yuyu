package yuyu.common.biz.bzcommon;

import java.io.Serializable;

/**
 * 業務共通 共通 組織窓口情報取得結果Bean
 */
public class BzGetSosikiMadogutiInfoKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kanjisosikinm;

    private String hassoukbn;

    private String kanjisosikiadr1;

    private String kanjisosikiadr2;

    private String kanjisosikiadr3;

    private String postalCd;

    private String telno;

    private String faxno;

    private String sisyaharaidasikznm;

    private String kouzanocd;

    private String sisyaharaidasikouzano;

    public BzGetSosikiMadogutiInfoKekkaBean() {
        super();
    }

    public String getKanjisosikinm() {
        return kanjisosikinm;
    }

    public void setKanjisosikinm(String pKanjisosikinm) {
        kanjisosikinm = pKanjisosikinm;
    }

    public String getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(String pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    public String getKanjisosikiadr1() {
        return kanjisosikiadr1;
    }

    public void setKanjisosikiadr1(String pKanjisosikiadr1) {
        kanjisosikiadr1 = pKanjisosikiadr1;
    }

    public String getKanjisosikiadr2() {
        return kanjisosikiadr2;
    }

    public void setKanjisosikiadr2(String pKanjisosikiadr2) {
        kanjisosikiadr2 = pKanjisosikiadr2;
    }

    public String getKanjisosikiadr3() {
        return kanjisosikiadr3;
    }

    public void setKanjisosikiadr3(String pKanjisosikiadr3) {
        kanjisosikiadr3 = pKanjisosikiadr3;
    }

    public String getPostalCd() {
        return postalCd;
    }

    public void setPostalCd(String pPostalCd) {
        postalCd = pPostalCd;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String pTelno) {
        telno = pTelno;
    }

    public String getFaxno() {
        return faxno;
    }

    public void setFaxno(String pFaxno) {
        faxno = pFaxno;
    }

    public String getSisyaharaidasikznm() {
        return sisyaharaidasikznm;
    }

    public void setSisyaharaidasikznm(String pSisyaharaidasikznm) {
        sisyaharaidasikznm = pSisyaharaidasikznm;
    }

    public String getKouzanocd() {
        return kouzanocd;
    }

    public void setKouzanocd(String pKouzanocd) {
        kouzanocd = pKouzanocd;
    }

    public String getSisyaharaidasikouzano() {
        return sisyaharaidasikouzano;
    }

    public void setSisyaharaidasikouzano(String pSisyaharaidasikouzano) {
        sisyaharaidasikouzano = pSisyaharaidasikouzano;
    }

}
