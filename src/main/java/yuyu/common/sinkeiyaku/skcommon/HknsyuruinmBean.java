package yuyu.common.sinkeiyaku.skcommon;

import java.io.Serializable;

import yuyu.def.classification.C_AisyoumeiKbn;

/**
 * 新契約 新契約共通 保険種類名Bean
 */
public class HknsyuruinmBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String hknsyuruinm;

    private String aisyoumei;

    private String aisyoumeikakko;

    private C_AisyoumeiKbn aisyoumeikbn;

    private String kokyakuhknnsyuruinm;

    private String kokyakuhknnsyuruinmtwogyou1;

    private String kokyakuhknnsyuruinmtwogyou2;

    public String getHknsyuruinm() {
        return hknsyuruinm;
    }

    public void setHknsyuruinm(String pHknsyuruinm) {
        this.hknsyuruinm = pHknsyuruinm;
    }

    public String getAisyoumei() {
        return aisyoumei;
    }

    public void setAisyoumei(String pAisyoumei) {
        this.aisyoumei = pAisyoumei;
    }

    public String getAisyoumeikakko() {
        return aisyoumeikakko;
    }

    public void setAisyoumeikakko(String pAisyoumeikakko) {
        this.aisyoumeikakko = pAisyoumeikakko;
    }

    public C_AisyoumeiKbn getAisyoumeikbn() {
        return aisyoumeikbn;
    }

    public void setAisyoumeikbn(C_AisyoumeiKbn pAisyoumeikbn) {
        this.aisyoumeikbn = pAisyoumeikbn;
    }

    public String getKokyakuhknnsyuruinm() {
        return kokyakuhknnsyuruinm;
    }

    public void setKokyakuhknnsyuruinm(String pKokyakuhknnsyuruinm) {
        this.kokyakuhknnsyuruinm = pKokyakuhknnsyuruinm;
    }

    public String getKokyakuhknnsyuruinmtwogyou1() {
        return kokyakuhknnsyuruinmtwogyou1;
    }

    public void setKokyakuhknnsyuruinmtwogyou1(String pKokyakuhknnsyuruinmtwogyou1) {
        this.kokyakuhknnsyuruinmtwogyou1 = pKokyakuhknnsyuruinmtwogyou1;
    }

    public String getKokyakuhknnsyuruinmtwogyou2() {
        return kokyakuhknnsyuruinmtwogyou2;
    }

    public void setKokyakuhknnsyuruinmtwogyou2(String pKokyakuhknnsyuruinmtwogyou2) {
        this.kokyakuhknnsyuruinmtwogyou2 = pKokyakuhknnsyuruinmtwogyou2;
    }

}