package yuyu.common.biz.bznayose;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_SueokiJyoutaiKbn;


/**
 * 保険金据置Ｆ索引結果Beanクラスです。<br />
 */
public class BzHokenkinSueokiFSakuinKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sueokifsysyno;

    private C_KankeisyaKbn sueokifhknkinkankeisyakbn;

    private String sueokifhknkinkojinkbn;

    private C_SueokiJyoutaiKbn sueokifsueokijtkbn;

    private BizDate sueokifsueokikaisiymd;

    private int sueokifsueokikkn;

    private BizDate sueokifuktseiymd;

    public BzHokenkinSueokiFSakuinKekkaBean() {
        super();
    }

    public String getSueokifsysyno() {
        return sueokifsysyno;
    }

    public void setSueokifsysyno(String pSueokifsysyno) {
        sueokifsysyno = pSueokifsysyno;
    }

    public C_KankeisyaKbn getSueokifhknkinkankeisyakbn() {
        return sueokifhknkinkankeisyakbn;
    }

    public void setSueokifhknkinkankeisyakbn(C_KankeisyaKbn pSueokifhknkinkankeisyakbn) {
        sueokifhknkinkankeisyakbn = pSueokifhknkinkankeisyakbn;
    }

    public String getSueokifhknkinkojinkbn() {
        return sueokifhknkinkojinkbn;
    }

    public void setSueokifhknkinkojinkbn(String pSueokifhknkinkojinkbn) {
        sueokifhknkinkojinkbn = pSueokifhknkinkojinkbn;
    }

    public C_SueokiJyoutaiKbn getSueokifsueokijtkbn() {
        return sueokifsueokijtkbn;
    }

    public void setSueokifsueokijtkbn(C_SueokiJyoutaiKbn pSueokifsueokijtkbn) {
        sueokifsueokijtkbn = pSueokifsueokijtkbn;
    }

    public BizDate getSueokifsueokikaisiymd() {
        return sueokifsueokikaisiymd;
    }

    public void setSueokifsueokikaisiymd(BizDate pSueokifsueokikaisiymd) {
        sueokifsueokikaisiymd = pSueokifsueokikaisiymd;
    }

    public int getSueokifsueokikkn() {
        return sueokifsueokikkn;
    }

    public void setSueokifsueokikkn(int pSueokifsueokikkn) {
        sueokifsueokikkn = pSueokifsueokikkn;
    }

    public BizDate getSueokifuktseiymd() {
        return sueokifuktseiymd;
    }

    public void setSueokifuktseiymd(BizDate pSueokifuktseiymd) {
        sueokifuktseiymd = pSueokifuktseiymd;
    }

}
