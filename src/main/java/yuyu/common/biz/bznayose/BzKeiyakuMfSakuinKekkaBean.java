package yuyu.common.biz.bznayose;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_KykJyoutaiKbn;

/**
 * 契約ＭＦ索引結果Beanクラスです。<br />
 */
public class BzKeiyakuMfSakuinKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kykmfsyono;

    private C_KankeisyaKbn kykmfkykkankeisyakbn;

    private String kykmfkykmfkojinkbn;

    private C_KykJyoutaiKbn kykmfkykjyoutaikbn;

    private BizDate kykmfkykymd;

    private String kykmfsyoumetucd;

    private BizDate kykmfsyoumetuymd;

    private BizDateYM kykmfbosyuuym;

    private BizDate kykmftaisyouseiymd;

    public BzKeiyakuMfSakuinKekkaBean() {
        super();
    }

    public String getKykmfsyono() {
        return kykmfsyono;
    }

    public void setKykmfsyono(String pKykmfsyono) {
        kykmfsyono = pKykmfsyono;
    }

    public C_KankeisyaKbn getKykmfkykkankeisyakbn() {
        return kykmfkykkankeisyakbn;
    }

    public void setKykmfkykkankeisyakbn(C_KankeisyaKbn pKykmfkykkankeisyakbn) {
        kykmfkykkankeisyakbn = pKykmfkykkankeisyakbn;
    }

    public String getKykmfkykmfkojinkbn() {
        return kykmfkykmfkojinkbn;
    }

    public void setKykmfkykmfkojinkbn(String pKykmfkykmfkojinkbn) {
        kykmfkykmfkojinkbn = pKykmfkykmfkojinkbn;
    }

    public C_KykJyoutaiKbn getKykmfkykjyoutaikbn() {
        return kykmfkykjyoutaikbn;
    }

    public void setKykmfkykjyoutaikbn(C_KykJyoutaiKbn pKykmfkykjyoutaikbn) {
        kykmfkykjyoutaikbn = pKykmfkykjyoutaikbn;
    }

    public BizDate getKykmfkykymd() {
        return kykmfkykymd;
    }

    public void setKykmfkykymd(BizDate pKykmfkykymd) {
        kykmfkykymd = pKykmfkykymd;
    }

    public String getKykmfsyoumetucd() {
        return kykmfsyoumetucd;
    }

    public void setKykmfsyoumetucd(String pKykmfsyoumetucd) {
        kykmfsyoumetucd = pKykmfsyoumetucd;
    }

    public BizDate getKykmfsyoumetuymd() {
        return kykmfsyoumetuymd;
    }

    public void setKykmfsyoumetuymd(BizDate pKykmfsyoumetuymd) {
        kykmfsyoumetuymd = pKykmfsyoumetuymd;
    }

    public BizDateYM getKykmfbosyuuym() {
        return kykmfbosyuuym;
    }

    public void setKykmfbosyuuym(BizDateYM pKykmfbosyuuym) {
        kykmfbosyuuym = pKykmfbosyuuym;
    }

    public BizDate getKykmftaisyouseiymd() {
        return kykmftaisyouseiymd;
    }

    public void setKykmftaisyouseiymd(BizDate pKykmftaisyouseiymd) {
        kykmftaisyouseiymd = pKykmftaisyouseiymd;
    }

}
