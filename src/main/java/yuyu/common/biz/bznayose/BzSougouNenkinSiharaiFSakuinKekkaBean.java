package yuyu.common.biz.bznayose;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_NkKankeisyaKbn;
import yuyu.def.classification.C_SounenfKykJyoutaiKbn;

/**
 * 総合年金支払Ｆ索引結果Beanクラスです。<br />
 */
public class BzSougouNenkinSiharaiFSakuinKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sounenfnksysyno;

    private C_NkKankeisyaKbn sounenfnkkankeisyakbn;

    private String sounenfsougounkfkojinkbn;

    private C_SounenfKykJyoutaiKbn sounenfkykjyoutaikbn;

    private BizDate sounenfsyokainkshrymd;

    private BizDate sounenfkykymd;

    private String sounenfnksyoumetucd;

    private BizDate sounenfsyoumetuymd;

    private BizDate sounenftaisyouseiymd;

    public BzSougouNenkinSiharaiFSakuinKekkaBean() {
        super();
    }

    public String getSounenfnksysyno() {
        return sounenfnksysyno;
    }

    public void setSounenfnksysyno(String pSounenfnksysyno) {
        sounenfnksysyno = pSounenfnksysyno;
    }

    public C_NkKankeisyaKbn getSounenfnkkankeisyakbn() {
        return sounenfnkkankeisyakbn;
    }

    public void setSounenfnkkankeisyakbn(C_NkKankeisyaKbn pSounenfnkkankeisyakbn) {
        sounenfnkkankeisyakbn = pSounenfnkkankeisyakbn;
    }

    public String getSounenfsougounkfkojinkbn() {
        return sounenfsougounkfkojinkbn;
    }

    public void setSounenfsougounkfkojinkbn(String pSounenfsougounkfkojinkbn) {
        sounenfsougounkfkojinkbn = pSounenfsougounkfkojinkbn;
    }

    public C_SounenfKykJyoutaiKbn getSounenfkykjyoutaikbn() {
        return sounenfkykjyoutaikbn;
    }

    public void setSounenfkykjyoutaikbn(C_SounenfKykJyoutaiKbn pSounenfkykjyoutaikbn) {
        sounenfkykjyoutaikbn = pSounenfkykjyoutaikbn;
    }

    public BizDate getSounenfsyokainkshrymd() {
        return sounenfsyokainkshrymd;
    }

    public void setSounenfsyokainkshrymd(BizDate pSounenfsyokainkshrymd) {
        sounenfsyokainkshrymd = pSounenfsyokainkshrymd;
    }

    public BizDate getSounenfkykymd() {
        return sounenfkykymd;
    }

    public void setSounenfkykymd(BizDate pSounenfkykymd) {
        sounenfkykymd = pSounenfkykymd;
    }

    public String getSounenfnksyoumetucd() {
        return sounenfnksyoumetucd;
    }

    public void setSounenfnksyoumetucd(String pSounenfnksyoumetucd) {
        sounenfnksyoumetucd = pSounenfnksyoumetucd;
    }

    public BizDate getSounenfsyoumetuymd() {
        return sounenfsyoumetuymd;
    }

    public void setSounenfsyoumetuymd(BizDate pSounenfsyoumetuymd) {
        sounenfsyoumetuymd = pSounenfsyoumetuymd;
    }

    public BizDate getSounenftaisyouseiymd() {
        return sounenftaisyouseiymd;
    }

    public void setSounenftaisyouseiymd(BizDate pSounenftaisyouseiymd) {
        sounenftaisyouseiymd = pSounenftaisyouseiymd;
    }

}
