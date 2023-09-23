package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_TuutisakuseitaisyouKbn;

/**
 * 契約保全 契約保全共通 直送対象者Beanクラス<br />
 */
public class TyokusouTaisyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_TuutisakuseitaisyouKbn tuutiSakuseiTaisyouKbn;

    private String nmkj;

    private BizDate seiYmd;

    private String yno;

    private String adr1kj;

    private String adr2kj;

    private String adr3kj;

    private String telno;

    public TyokusouTaisyouBean() {
        super();
    }

    public C_TuutisakuseitaisyouKbn getTuutiSakuseiTaisyouKbn() {
        return tuutiSakuseiTaisyouKbn;
    }

    public void setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn pTuutiSakuseiTaisyouKbn) {
        tuutiSakuseiTaisyouKbn = pTuutiSakuseiTaisyouKbn;
    }

    public String getNmkj() {
        return nmkj;
    }

    public void setNmkj(String pNmkj) {
        nmkj = pNmkj;
    }

    public BizDate getSeiYmd() {
        return seiYmd;
    }

    public void setSeiYmd(BizDate pSeiYmd) {
        seiYmd = pSeiYmd;
    }

    public String getYno() {
        return yno;
    }

    public void setYno(String pYno) {
        yno = pYno;
    }

    public String getAdr1kj() {
        return adr1kj;
    }

    public void setAdr1kj(String pAdr1kj) {
        adr1kj = pAdr1kj;
    }

    public String getAdr2kj() {
        return adr2kj;
    }

    public void setAdr2kj(String pAdr2kj) {
        adr2kj = pAdr2kj;
    }

    public String getAdr3kj() {
        return adr3kj;
    }

    public void setAdr3kj(String pAdr3kj) {
        adr3kj = pAdr3kj;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String pTelno) {
        telno = pTelno;
    }
}
