package yuyu.common.siharai.koutei;

import java.io.Serializable;

/**
 * 保険金給付金支払 工程 支払分岐条件Bean（IWFAPI用）
 */
public class SiIwfApiRuleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoriKekkaNaiyou;

    private String sateiYhNaiyou;

    private String sessyouYhNaiyou;

    private String sateiSanjiKaisouUmuNaiyou;

    private String hubiModorijiSenisakiNodeNm;

    public SiIwfApiRuleBean() {
        super();
    }

    public String getSyoriKekkaNaiyou() {
        return syoriKekkaNaiyou;
    }

    public void setSyoriKekkaNaiyou(String pSyoriKekkaNaiyou) {
        this.syoriKekkaNaiyou = pSyoriKekkaNaiyou;
    }

    public String getSateiYhNaiyou() {
        return sateiYhNaiyou;
    }

    public void setSateiYhNaiyou(String pSateiYhNaiyou) {
        this.sateiYhNaiyou = pSateiYhNaiyou;
    }

    public String getSessyouYhNaiyou() {
        return sessyouYhNaiyou;
    }

    public void setSessyouYhNaiyou(String pSessyouYhNaiyou) {
        this.sessyouYhNaiyou = pSessyouYhNaiyou;
    }

    public String getSateiSanjiKaisouUmuNaiyou() {
        return sateiSanjiKaisouUmuNaiyou;
    }

    public void setSateiSanjiKaisouUmuNaiyou(String pSateiSanjiKaisouUmuNaiyou) {
        this.sateiSanjiKaisouUmuNaiyou = pSateiSanjiKaisouUmuNaiyou;
    }

    public String getHubiModorijiSenisakiNodeNm() {
        return hubiModorijiSenisakiNodeNm;
    }

    public void setHubiModorijiSenisakiNodeNm(String pHubiModorijiSenisakiNodeNm) {
        this.hubiModorijiSenisakiNodeNm = pHubiModorijiSenisakiNodeNm;
    }
}
