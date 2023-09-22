package yuyu.common.sinkeiyaku.skcommon;

import java.io.Serializable;

/**
 * 新契約 新契約共通 不備内容取得出力Bean
 */
public class HubiNaiyouOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String hubiKoumokuCd;

    private String hubiNaiyouCd;

    private String iraiNaiyou;

    private String tyoubunFlg;

    private String renrakuJikou;

    public String getHubiKoumokuCd() {
        return hubiKoumokuCd;
    }

    public void setHubiKoumokuCd(String pHubiKoumokuCd) {
        this.hubiKoumokuCd = pHubiKoumokuCd;
    }

    public String getHubiNaiyouCd() {
        return hubiNaiyouCd;
    }

    public void setHubiNaiyouCd(String pHubiNaiyouCd) {
        this.hubiNaiyouCd = pHubiNaiyouCd;
    }

    public String getIraiNaiyou() {
        return iraiNaiyou;
    }

    public void setIraiNaiyou(String pIraiNaiyou) {
        this.iraiNaiyou = pIraiNaiyou;
    }

    public String getTyoubunFlg() {
        return tyoubunFlg;
    }

    public void setTyoubunFlg(String pTyoubunFlg) {
        this.tyoubunFlg = pTyoubunFlg;
    }

    public String getRenrakuJikou() {
        return renrakuJikou;
    }

    public void setRenrakuJikou(String pRenrakuJikou) {
        renrakuJikou = pRenrakuJikou;
    }
}