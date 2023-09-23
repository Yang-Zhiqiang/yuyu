package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 解約返戻金計算拡張Bean
 */
public class KeisanWExtBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syouhncd;

    private int syouhnsdno = 0;

    private String ryouritusdno;

    private BizNumber yoteiriritu = BizNumber.ZERO;

    private C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

    private C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.BLNK;

    private C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.BLNK;

    private int hknkkn = 0;

    private int hrkkkn = 0;

    private int hhknnen = 0;

    private C_Hhknsei hhknsei = C_Hhknsei.BLNK;

    private BizCurrency kihons = BizCurrency.valueOf(0);

    private BizCurrency hokenryou = BizCurrency.valueOf(0);

    private BizDate kykymd;

    private C_Tuukasyu tuukasyu = C_Tuukasyu.BLNK;

    private BizNumber kyksjkkktyouseiriritu = BizNumber.ZERO;

    private BizNumber kaiyakusjkkktyouseiriritu = BizNumber.ZERO;

    private BizDateYM tmttkntaisyouym;

    private BizCurrency teiritutmttkngk = BizCurrency.valueOf(0);

    private BizCurrency sisuurendoutmttkngk = BizCurrency.valueOf(0);

    private BizNumber tmttknhaneisisuu = BizNumber.ZERO;

    private BizNumber tumitateriritu = BizNumber.ZERO;

    private BizDateYM jkipjytym;

    private BizCurrency ptmttkngk = BizCurrency.valueOf(0);

    private BizCurrency kihrkmpstgk = BizCurrency.valueOf(0);

    private BizDate fstpryosyuymd;

    private BizNumber yoteirrthendohosyurrt = BizNumber.ZERO;

    private C_KhSisanSyuruiKbn sisansyuruikbn = C_KhSisanSyuruiKbn.JISSEKI;

    private BizNumber sisanyoteiriritu = BizNumber.ZERO;

    private BizNumber sisankawaserate = BizNumber.ZERO;

    private BizDate sisansyoriymd;

    private BizDate yendthnkymd;

    private C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.NONE;

    private Integer dai1hknkkn = 0;

    private C_Kykjyoutai kykJyoutai = C_Kykjyoutai.BLNK;

    public KeisanWExtBean() {
        super();
    }

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    public int getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(int pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }

    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    public void setYoteiriritu(BizNumber pYoteiriritu) {
        yoteiriritu = pYoteiriritu;
    }

    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    public C_HknkknsmnKbn getHknkknsmnkbn() {
        return hknkknsmnkbn;
    }

    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {
        hknkknsmnkbn = pHknkknsmnkbn;
    }

    public int getHknkkn() {
        return hknkkn;
    }

    public void setHknkkn(int pHknkkn) {
        hknkkn = pHknkkn;
    }

    public C_HrkkknsmnKbn getHrkkknsmnkbn() {
        return hrkkknsmnkbn;
    }

    public void setHrkkknsmnkbn(C_HrkkknsmnKbn pHrkkknsmnkbn) {
        hrkkknsmnkbn = pHrkkknsmnkbn;
    }

    public int getHrkkkn() {
        return hrkkkn;
    }

    public void setHrkkkn(int pHrkkkn) {
        hrkkkn = pHrkkkn;
    }

    public int getHhknnen() {
        return hhknnen;
    }

    public void setHhknnen(int pHhknnen) {
        hhknnen = pHhknnen;
    }

    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    public BizCurrency getKihons() {
        return kihons;
    }

    public void setKihons(BizCurrency pKihons) {
        kihons = pKihons;
    }

    public BizCurrency getHokenryou() {
        return hokenryou;
    }

    public void setHokenryou(BizCurrency pHokenryou) {
        hokenryou = pHokenryou;
    }

    public BizDate getKykymd() {
        return kykymd;
    }

    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    public BizNumber getKyksjkkktyouseiriritu() {
        return kyksjkkktyouseiriritu;
    }

    public void setKyksjkkktyouseiriritu(BizNumber pKyksjkkktyouseiriritu) {
        kyksjkkktyouseiriritu = pKyksjkkktyouseiriritu;
    }

    public BizNumber getKaiyakusjkkktyouseiriritu() {
        return kaiyakusjkkktyouseiriritu;
    }

    public void setKaiyakusjkkktyouseiriritu(BizNumber pKaiyakusjkkktyouseiriritu) {
        kaiyakusjkkktyouseiriritu = pKaiyakusjkkktyouseiriritu;
    }

    public BizDateYM getTmttkntaisyouym() {
        return tmttkntaisyouym;
    }

    public void setTmttkntaisyouym(BizDateYM pTmttkntaisyouym) {
        tmttkntaisyouym = pTmttkntaisyouym;
    }

    public BizCurrency getTeiritutmttkngk() {
        return teiritutmttkngk;
    }

    public void setTeiritutmttkngk(BizCurrency pTeiritutmttkngk) {
        teiritutmttkngk = pTeiritutmttkngk;
    }

    public BizCurrency getSisuurendoutmttkngk() {
        return sisuurendoutmttkngk;
    }

    public void setSisuurendoutmttkngk(BizCurrency pSisuurendoutmttkngk) {
        sisuurendoutmttkngk = pSisuurendoutmttkngk;
    }


    public BizNumber getTmttknhaneisisuu() {
        return tmttknhaneisisuu;
    }

    public void setTmttknhaneisisuu(BizNumber pTmttknhaneisisuu) {
        tmttknhaneisisuu = pTmttknhaneisisuu;
    }

    public BizNumber getTumitateriritu() {
        return tumitateriritu;
    }

    public void setTumitateriritu(BizNumber pTumitateriritu) {
        tumitateriritu = pTumitateriritu;
    }

    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    public BizCurrency getPtmttkngk() {
        return ptmttkngk;
    }

    public void setPtmttkngk(BizCurrency pPtmttkngk) {
        ptmttkngk = pPtmttkngk;
    }

    public BizCurrency getKihrkmpstgk() {
        return kihrkmpstgk;
    }

    public void setKihrkmpstgk(BizCurrency pKihrkmpstgk) {
        kihrkmpstgk = pKihrkmpstgk;
    }

    public BizDate getFstpryosyuymd() {
        return fstpryosyuymd;
    }

    public void setFstpryosyuymd(BizDate pFstpryosyuymd) {
        fstpryosyuymd = pFstpryosyuymd;
    }

    public BizNumber getYoteirrthendohosyurrt() {
        return yoteirrthendohosyurrt;
    }

    public void setYoteirrthendohosyurrt(BizNumber pYoteirrthendohosyurrt) {
        yoteirrthendohosyurrt = pYoteirrthendohosyurrt;
    }

    public C_KhSisanSyuruiKbn getSisansyuruikbn() {
        return sisansyuruikbn;
    }

    public void setSisansyuruikbn(C_KhSisanSyuruiKbn pSisansyuruikbn) {
        sisansyuruikbn = pSisansyuruikbn;
    }

    public BizNumber getSisanyoteiriritu() {
        return sisanyoteiriritu;
    }

    public void setSisanyoteiriritu(BizNumber pSisanyoteiriritu) {
        sisanyoteiriritu = pSisanyoteiriritu;
    }

    public BizNumber getSisankawaserate() {
        return sisankawaserate;
    }

    public void setSisankawaserate(BizNumber pSisankawaserate) {
        sisankawaserate = pSisankawaserate;
    }

    public BizDate getSisansyoriymd() {
        return sisansyoriymd;
    }

    public void setSisansyoriymd(BizDate pSisansyoriymd) {
        sisansyoriymd = pSisansyoriymd;
    }

    public BizDate getYendthnkymd() {
        return yendthnkymd;
    }

    public void setYendthnkymd(BizDate pYendthnkymd) {
        yendthnkymd = pYendthnkymd;
    }

    public C_UmuKbn getTeikishrtkykhukaumu() {
        return teikishrtkykhukaumu;
    }

    public void setTeikishrtkykhukaumu(C_UmuKbn pTeikishrtkykhukaumu) {
        teikishrtkykhukaumu = pTeikishrtkykhukaumu;
    }

    public Integer getDai1hknkkn() {
        return dai1hknkkn;
    }

    public void setDai1hknkkn(Integer pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }

    public C_Kykjyoutai getKykJyoutai() {
        return kykJyoutai;
    }

    public void setKykJyoutai(C_Kykjyoutai pKykJyoutai) {
        kykJyoutai = pKykJyoutai;
    }
}
