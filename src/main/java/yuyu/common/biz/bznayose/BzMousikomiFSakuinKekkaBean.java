package yuyu.common.biz.bznayose;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_MossyoumetuKbn;

/**
 * 申込Ｆ索引結果Beanクラスです。<br />
 */
public class BzMousikomiFSakuinKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mosfmosno;

    private C_KankeisyaKbn mosfmoskankeisyakbn;

    private String mosfmofkojinkbn;

    private C_Mfrenflg mosfmfrenflg;

    private BizDate mosfmosymd;

    private BizDate mosfkykymd;

    private C_MossyoumetuKbn mosfmossyoumetukbn;

    private BizDate mosfmossyoumetukktiymd;

    private BizDateYM mosfbosyuuym;

    private BizDate mosftaisyouseiymd;

    public BzMousikomiFSakuinKekkaBean() {
        super();
    }

    public String getMosfmosno() {
        return mosfmosno;
    }

    public void setMosfmosno(String pMosfmosno) {
        mosfmosno = pMosfmosno;
    }

    public C_KankeisyaKbn getMosfmoskankeisyakbn() {
        return mosfmoskankeisyakbn;
    }

    public void setMosfmoskankeisyakbn(C_KankeisyaKbn pMosfmoskankeisyakbn) {
        mosfmoskankeisyakbn = pMosfmoskankeisyakbn;
    }

    public String getMosfmofkojinkbn() {
        return mosfmofkojinkbn;
    }

    public void setMosfmofkojinkbn(String pMosfmofkojinkbn) {
        mosfmofkojinkbn = pMosfmofkojinkbn;
    }

    public C_Mfrenflg getMosfmfrenflg() {
        return mosfmfrenflg;
    }

    public void setMosfmfrenflg(C_Mfrenflg pMosfmfrenflg) {
        mosfmfrenflg = pMosfmfrenflg;
    }

    public BizDate getMosfmosymd() {
        return mosfmosymd;
    }

    public void setMosfmosymd(BizDate pMosfmosymd) {
        mosfmosymd = pMosfmosymd;
    }

    public BizDate getMosfkykymd() {
        return mosfkykymd;
    }

    public void setMosfkykymd(BizDate pMosfkykymd) {
        mosfkykymd = pMosfkykymd;
    }

    public C_MossyoumetuKbn getMosfmossyoumetukbn() {
        return mosfmossyoumetukbn;
    }

    public void setMosfmossyoumetukbn(C_MossyoumetuKbn pMosfmossyoumetukbn) {
        mosfmossyoumetukbn = pMosfmossyoumetukbn;
    }

    public BizDate getMosfmossyoumetukktiymd() {
        return mosfmossyoumetukktiymd;
    }

    public void setMosfmossyoumetukktiymd(BizDate pMosfmossyoumetukktiymd) {
        mosfmossyoumetukktiymd = pMosfmossyoumetukktiymd;
    }

    public BizDateYM getMosfbosyuuym() {
        return mosfbosyuuym;
    }

    public void setMosfbosyuuym(BizDateYM pMosfbosyuuym) {
        mosfbosyuuym = pMosfbosyuuym;
    }

    public BizDate getMosftaisyouseiymd() {
        return mosftaisyouseiymd;
    }

    public void setMosftaisyouseiymd(BizDate pMosftaisyouseiymd) {
        mosftaisyouseiymd = pMosftaisyouseiymd;
    }

}
