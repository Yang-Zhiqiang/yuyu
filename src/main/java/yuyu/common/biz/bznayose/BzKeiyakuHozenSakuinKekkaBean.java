package yuyu.common.biz.bznayose;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;


/**
 * 契約保全索引結果Beanクラスです。<br />
 */
public class BzKeiyakuHozenSakuinKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String khsyono;

    private C_KankeisyaKbn khkykkankeisyakbn;

    private String khkykfkojinkbn;

    private C_YuukousyoumetuKbn khyuukousyoumetukbn;

    private C_Kykjyoutai khkykjyoutai;

    private BizDate khkykymd;

    private C_Syoumetujiyuu khsyoumetujiyuu;

    private BizDate khsyoumetuymd;

    private String khsyouhncd;

    private BizDateYM khbosyuuym;

    private BizDate khtaisyouseiymd;

    private Integer khsyouhnsdno;

    public BzKeiyakuHozenSakuinKekkaBean() {
        super();
    }

    public String getKhsyono() {
        return khsyono;
    }

    public void setKhsyono(String pKhsyono) {
        khsyono = pKhsyono;
    }

    public C_KankeisyaKbn getKhkykkankeisyakbn() {
        return khkykkankeisyakbn;
    }

    public void setKhkykkankeisyakbn(C_KankeisyaKbn pKhkykkankeisyakbn) {
        khkykkankeisyakbn = pKhkykkankeisyakbn;
    }

    public String getKhkykfkojinkbn() {
        return khkykfkojinkbn;
    }

    public void setKhkykfkojinkbn(String pKhkykfkojinkbn) {
        khkykfkojinkbn = pKhkykfkojinkbn;
    }

    public C_YuukousyoumetuKbn getKhyuukousyoumetukbn() {
        return khyuukousyoumetukbn;
    }

    public void setKhyuukousyoumetukbn(C_YuukousyoumetuKbn pKhyuukousyoumetukbn) {
        khyuukousyoumetukbn = pKhyuukousyoumetukbn;
    }

    public C_Kykjyoutai getKhkykjyoutai() {
        return khkykjyoutai;
    }

    public void setKhkykjyoutai(C_Kykjyoutai pKhkykjyoutai) {
        khkykjyoutai = pKhkykjyoutai;
    }

    public BizDate getKhkykymd() {
        return khkykymd;
    }

    public void setKhkykymd(BizDate pKhkykymd) {
        khkykymd = pKhkykymd;
    }

    public C_Syoumetujiyuu getKhsyoumetujiyuu() {
        return khsyoumetujiyuu;
    }

    public void setKhsyoumetujiyuu(C_Syoumetujiyuu pKhsyoumetujiyuu) {
        khsyoumetujiyuu = pKhsyoumetujiyuu;
    }

    public BizDate getKhsyoumetuymd() {
        return khsyoumetuymd;
    }

    public void setKhsyoumetuymd(BizDate pKhsyoumetuymd) {
        khsyoumetuymd = pKhsyoumetuymd;
    }

    public String getKhsyouhncd() {
        return khsyouhncd;
    }

    public void setKhsyouhncd(String pKhsyouhncd) {
        khsyouhncd = pKhsyouhncd;
    }

    public BizDateYM getKhbosyuuym() {
        return khbosyuuym;
    }

    public void setKhbosyuuym(BizDateYM pKhbosyuuym) {
        khbosyuuym = pKhbosyuuym;
    }

    public BizDate getKhtaisyouseiymd() {
        return khtaisyouseiymd;
    }

    public void setKhtaisyouseiymd(BizDate pKhtaisyouseiymd) {
        khtaisyouseiymd = pKhtaisyouseiymd;
    }

    public Integer getKhsyouhnsdno() {
        return khsyouhnsdno;
    }

    public void setKhsyouhnsdno(Integer pKhsyouhnsdno) {
        khsyouhnsdno = pKhsyouhnsdno;
    }
}
