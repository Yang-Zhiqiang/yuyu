package yuyu.common.biz.bznayose;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_MrsignalhanteigyoumuKbn;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 索引通算照会与件Beanクラスです。<br />
 */
public class BzSakuinTsnSyoukaiYokenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SakuintsnSyoukaiKbn skintsnsyoukaikbn;

    private C_Huho2kyknoKbn huho2kyknokbn;

    private String huho2kykno;

    private C_SakuintsnTaisyouKbn skintsntaisyoukbn;

    private String taisyounmkn;

    private String taisyounmkj;

    private BizDate taisyouseiymd;

    private String taisyouyno;

    private String hhknyno;

    private String hhknsykgycd;

    private String kankeinmkn1;

    private String kankeinmkj1;

    private String kankeinmkn2;

    private String kankeinmkj2;

    private String kankeinmkn3;

    private String kankeinmkj3;

    private String kankeinmkn4;

    private String kankeinmkj4;

    private String kankeinmkn5;

    private String kankeinmkj5;

    private String kanrisosikicd1;

    private String kanrisosikicd2;

    private String tsintelno;

    private C_Hrkkeiro hrkkeiro;

    private String bankcd;

    private String shitencd;

    private C_YokinKbn yokinkbn;

    private String kouzano;

    private C_YouhiKbn skininfosyoukaiyhkbn;

    private C_SakuintaisyoukykKbn skintaisyoukykkbn;

    private C_Huho2kyknoKbn skintsghuho2kyknokbn;

    private String skintsghuho2kykno;

    private BizDate skinkijyunymd;

    private C_YouhiKbn mrsignalsyoukaiyhkbn;

    private C_MrsignalhanteigyoumuKbn mrsignalhanteigyoumukbn;

    private C_YouhiKbn tsngksyoukaiyhkbn;

    private C_Huho2kyknoKbn tsntsghuho2kyknokbn;

    private String tsntsghuho2kykno;

    private BizDate tsnkijyunymd;

    private C_YouhiKbn kykdrtentsnsssyoukaiyhkbn;

    private C_Huho2kyknoKbn drtentsntsghuho2kyknokbn;

    private String drtentsntsghuho2kykno;

    private BizDate kykdrtentsnkijyunymd;

    private String dairitencd1;

    private String dairitencd2;

    private C_YouhiKbn mossakuseikahisyoukaiyhkbn;

    private C_YouhiKbn hndketyhsyoukaiyhkbn;

    public BzSakuinTsnSyoukaiYokenBean() {
        super();
    }

    public C_SakuintsnSyoukaiKbn getSkintsnsyoukaikbn() {
        return skintsnsyoukaikbn;
    }

    public void setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn pSkintsnsyoukaikbn) {
        skintsnsyoukaikbn = pSkintsnsyoukaikbn;
    }

    public C_Huho2kyknoKbn getHuho2kyknokbn() {
        return huho2kyknokbn;
    }

    public void setHuho2kyknokbn(C_Huho2kyknoKbn pHuho2kyknokbn) {
        huho2kyknokbn = pHuho2kyknokbn;
    }

    public String getHuho2kykno() {
        return huho2kykno;
    }

    public void setHuho2kykno(String pHuho2kykno) {
        huho2kykno = pHuho2kykno;
    }

    public C_SakuintsnTaisyouKbn getSkintsntaisyoukbn() {
        return skintsntaisyoukbn;
    }

    public void setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn pSkintsntaisyoukbn) {
        skintsntaisyoukbn = pSkintsntaisyoukbn;
    }

    public String getTaisyounmkn() {

        taisyounmkn = "シメイ　イチ";
        return taisyounmkn;
    }

    public void setTaisyounmkn(String pTaisyounmkn) {
        taisyounmkn = pTaisyounmkn;
    }

    public String getTaisyounmkj() {
        return taisyounmkj;
    }

    public void setTaisyounmkj(String pTaisyounmkj) {
        taisyounmkj = pTaisyounmkj;
    }

    public BizDate getTaisyouseiymd() {
        return taisyouseiymd;
    }

    public void setTaisyouseiymd(BizDate pTaisyouseiymd) {
        taisyouseiymd = pTaisyouseiymd;
    }

    public String getTaisyouyno() {
        return taisyouyno;
    }

    public void setTaisyouyno(String pTaisyouyno) {
        taisyouyno = pTaisyouyno;
    }

    public String getHhknyno() {
        return hhknyno;
    }

    public void setHhknyno(String pHhknyno) {
        hhknyno = pHhknyno;
    }

    public String getHhknsykgycd() {
        return hhknsykgycd;
    }

    public void setHhknsykgycd(String pHhknsykgycd) {
        hhknsykgycd = pHhknsykgycd;
    }

    public String getKankeinmkn1() {
        return kankeinmkn1;
    }

    public void setKankeinmkn1(String pKankeinmkn1) {
        kankeinmkn1 = pKankeinmkn1;
    }

    public String getKankeinmkj1() {
        return kankeinmkj1;
    }

    public void setKankeinmkj1(String pKankeinmkj1) {
        kankeinmkj1 = pKankeinmkj1;
    }

    public String getKankeinmkn2() {
        return kankeinmkn2;
    }

    public void setKankeinmkn2(String pKankeinmkn2) {
        kankeinmkn2 = pKankeinmkn2;
    }

    public String getKankeinmkj2() {
        return kankeinmkj2;
    }

    public void setKankeinmkj2(String pKankeinmkj2) {
        kankeinmkj2 = pKankeinmkj2;
    }

    public String getKankeinmkn3() {
        return kankeinmkn3;
    }

    public void setKankeinmkn3(String pKankeinmkn3) {
        kankeinmkn3 = pKankeinmkn3;
    }

    public String getKankeinmkj3() {
        return kankeinmkj3;
    }

    public void setKankeinmkj3(String pKankeinmkj3) {
        kankeinmkj3 = pKankeinmkj3;
    }

    public String getKankeinmkn4() {
        return kankeinmkn4;
    }

    public void setKankeinmkn4(String pKankeinmkn4) {
        kankeinmkn4 = pKankeinmkn4;
    }

    public String getKankeinmkj4() {
        return kankeinmkj4;
    }

    public void setKankeinmkj4(String pKankeinmkj4) {
        kankeinmkj4 = pKankeinmkj4;
    }

    public String getKankeinmkn5() {
        return kankeinmkn5;
    }

    public void setKankeinmkn5(String pKankeinmkn5) {
        kankeinmkn5 = pKankeinmkn5;
    }

    public String getKankeinmkj5() {
        return kankeinmkj5;
    }

    public void setKankeinmkj5(String pKankeinmkj5) {
        kankeinmkj5 = pKankeinmkj5;
    }

    public String getKanrisosikicd1() {
        return kanrisosikicd1;
    }

    public void setKanrisosikicd1(String pKanrisosikicd1) {
        kanrisosikicd1 = pKanrisosikicd1;
    }

    public String getKanrisosikicd2() {
        return kanrisosikicd2;
    }

    public void setKanrisosikicd2(String pKanrisosikicd2) {
        kanrisosikicd2 = pKanrisosikicd2;
    }

    public String getTsintelno() {
        return tsintelno;
    }

    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    public String getBankcd() {
        return bankcd;
    }

    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    public String getShitencd() {
        return shitencd;
    }

    public void setShitencd(String pShitencd) {
        shitencd = pShitencd;
    }

    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    public String getKouzano() {
        return kouzano;
    }

    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    public C_YouhiKbn getSkininfosyoukaiyhkbn() {
        return skininfosyoukaiyhkbn;
    }

    public void setSkininfosyoukaiyhkbn(C_YouhiKbn pSkininfosyoukaiyhkbn) {
        skininfosyoukaiyhkbn = pSkininfosyoukaiyhkbn;
    }

    public C_SakuintaisyoukykKbn getSkintaisyoukykkbn() {
        return skintaisyoukykkbn;
    }

    public void setSkintaisyoukykkbn(C_SakuintaisyoukykKbn pSkintaisyoukykkbn) {
        skintaisyoukykkbn = pSkintaisyoukykkbn;
    }

    public C_Huho2kyknoKbn getSkintsghuho2kyknokbn() {
        return skintsghuho2kyknokbn;
    }

    public void setSkintsghuho2kyknokbn(C_Huho2kyknoKbn pSkintsghuho2kyknokbn) {
        skintsghuho2kyknokbn = pSkintsghuho2kyknokbn;
    }

    public String getSkintsghuho2kykno() {
        return skintsghuho2kykno;
    }

    public void setSkintsghuho2kykno(String pSkintsghuho2kykno) {
        skintsghuho2kykno = pSkintsghuho2kykno;
    }

    public BizDate getSkinkijyunymd() {
        return skinkijyunymd;
    }

    public void setSkinkijyunymd(BizDate pSkinkijyunymd) {
        skinkijyunymd = pSkinkijyunymd;
    }

    public C_YouhiKbn getMrsignalsyoukaiyhkbn() {
        return mrsignalsyoukaiyhkbn;
    }

    public void setMrsignalsyoukaiyhkbn(C_YouhiKbn pMrsignalsyoukaiyhkbn) {
        mrsignalsyoukaiyhkbn = pMrsignalsyoukaiyhkbn;
    }

    public C_MrsignalhanteigyoumuKbn getMrsignalhanteigyoumukbn() {
        return mrsignalhanteigyoumukbn;
    }

    public void setMrsignalhanteigyoumukbn(C_MrsignalhanteigyoumuKbn pMrsignalhanteigyoumukbn) {
        mrsignalhanteigyoumukbn = pMrsignalhanteigyoumukbn;
    }

    public C_YouhiKbn getTsngksyoukaiyhkbn() {
        return tsngksyoukaiyhkbn;
    }

    public void setTsngksyoukaiyhkbn(C_YouhiKbn pTsngksyoukaiyhkbn) {
        tsngksyoukaiyhkbn = pTsngksyoukaiyhkbn;
    }

    public C_Huho2kyknoKbn getTsntsghuho2kyknokbn() {
        return tsntsghuho2kyknokbn;
    }

    public void setTsntsghuho2kyknokbn(C_Huho2kyknoKbn pTsntsghuho2kyknokbn) {
        tsntsghuho2kyknokbn = pTsntsghuho2kyknokbn;
    }

    public String getTsntsghuho2kykno() {
        return tsntsghuho2kykno;
    }

    public void setTsntsghuho2kykno(String pTsntsghuho2kykno) {
        tsntsghuho2kykno = pTsntsghuho2kykno;
    }

    public BizDate getTsnkijyunymd() {
        return tsnkijyunymd;
    }

    public void setTsnkijyunymd(BizDate pTsnkijyunymd) {
        tsnkijyunymd = pTsnkijyunymd;
    }

    public C_YouhiKbn getKykdrtentsnsssyoukaiyhkbn() {
        return kykdrtentsnsssyoukaiyhkbn;
    }

    public void setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn pKykdrtentsnsssyoukaiyhkbn) {
        kykdrtentsnsssyoukaiyhkbn = pKykdrtentsnsssyoukaiyhkbn;
    }

    public C_Huho2kyknoKbn getDrtentsntsghuho2kyknokbn() {
        return drtentsntsghuho2kyknokbn;
    }

    public void setDrtentsntsghuho2kyknokbn(C_Huho2kyknoKbn pDrtentsntsghuho2kyknokbn) {
        drtentsntsghuho2kyknokbn = pDrtentsntsghuho2kyknokbn;
    }

    public String getDrtentsntsghuho2kykno() {
        return drtentsntsghuho2kykno;
    }

    public void setDrtentsntsghuho2kykno(String pDrtentsntsghuho2kykno) {
        drtentsntsghuho2kykno = pDrtentsntsghuho2kykno;
    }

    public BizDate getKykdrtentsnkijyunymd() {
        return kykdrtentsnkijyunymd;
    }

    public void setKykdrtentsnkijyunymd(BizDate pKykdrtentsnkijyunymd) {
        kykdrtentsnkijyunymd = pKykdrtentsnkijyunymd;
    }

    public String getDairitencd1() {
        return dairitencd1;
    }

    public void setDairitencd1(String pDairitencd1) {
        dairitencd1 = pDairitencd1;
    }

    public String getDairitencd2() {
        return dairitencd2;
    }

    public void setDairitencd2(String pDairitencd2) {
        dairitencd2 = pDairitencd2;
    }

    public C_YouhiKbn getMossakuseikahisyoukaiyhkbn() {
        return mossakuseikahisyoukaiyhkbn;
    }

    public void setMossakuseikahisyoukaiyhkbn(C_YouhiKbn pMossakuseikahisyoukaiyhkbn) {
        mossakuseikahisyoukaiyhkbn = pMossakuseikahisyoukaiyhkbn;
    }

    public C_YouhiKbn getHndketyhsyoukaiyhkbn() {
        return hndketyhsyoukaiyhkbn;
    }

    public void setHndketyhsyoukaiyhkbn(C_YouhiKbn pHndketyhsyoukaiyhkbn) {
        hndketyhsyoukaiyhkbn = pHndketyhsyoukaiyhkbn;
    }

}
