package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HknkknsmnKbn;

/**
 * 業務共通 業務共通 市場価格調整用利率取得用Beanクラス
 */
public class GetSjkkktyouseiyourirituBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syouhncd;

    private BizDate kijyunymd;

    private BizDate sknnkaisiymd;

    private BizDate kykymd;

    private int hknkkn;

    private C_HknkknsmnKbn hknkknsmnkbn;

    private int hhknnen;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }

    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    public BizDate getKykymd() {
        return kykymd;
    }

    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    public int getHknkkn() {
        return hknkkn;
    }

    public void setHknkkn(int pHknkkn) {
        hknkkn = pHknkkn;
    }

    public C_HknkknsmnKbn getHknkknsmnkbn() {
        return hknkknsmnkbn;
    }

    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {
        hknkknsmnkbn = pHknkknsmnkbn;
    }

    public int getHhknnen() {
        return hhknnen;
    }

    public void setHhknnen(int pHhknnen) {
        hhknnen = pHhknnen;
    }

}
