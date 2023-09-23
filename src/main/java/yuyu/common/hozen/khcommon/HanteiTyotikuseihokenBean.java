package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 貯蓄性保険判定Bean
 */
public class HanteiTyotikuseihokenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syouhnCd;

    private int syouhnsdNo;

    private String ryouritusdNo;

    private BizNumber yoteiriritu;

    private C_Hrkkaisuu hrkkaisuu;

    private C_HknkknsmnKbn hknkknsmnkbn;

    private C_HrkkknsmnKbn hrkkknsmnkbn;

    private int hrkkkn;

    private int hknkkn;

    private int hhknnen;

    private C_Hhknsei hhknsei;

    private BizCurrency kihons;

    private BizCurrency hokenryou;

    private BizDate kykymd;

    private C_Tuukasyu kyktuukaSyu;

    private BizDate mosymd;

    private BizNumber yoteirrthendohosyurrt;

    private C_Hrkkeiro hrkkeiro;

    private BizDate haraimanymd;

    private boolean tyotikuseihokenhyoujihanteiflag = false;

    private int dai1hknkkn;

    public HanteiTyotikuseihokenBean() {
        super();
    }

    public String getSyouhnCd() {
        return syouhnCd;
    }

    public void setSyouhnCd(String pSyouhncd) {
        syouhnCd = pSyouhncd;
    }

    public int getSyouhnsdNo() {
        return syouhnsdNo;
    }

    public void setSyouhnsdNo(int pSyouhnsdNo) {
        syouhnsdNo = pSyouhnsdNo;
    }

    public String getRyouritusdNo() {
        return ryouritusdNo;
    }

    public void setRyouritusdNo(String pRyouritusdNo) {
        ryouritusdNo = pRyouritusdNo;
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

    public int getHknkkn() {
        return hknkkn;
    }

    public void setHknkkn(int pHknkkn) {
        hknkkn = pHknkkn;
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

    public C_Tuukasyu getKyktuukaSyu() {
        return kyktuukaSyu;
    }

    public void setKyktuukaSyu(C_Tuukasyu pKyktuukaSyu) {
        kyktuukaSyu = pKyktuukaSyu;
    }

    public BizDate getMosymd() {
        return mosymd;
    }

    public void setMosymd(BizDate pMosymd) {
        mosymd = pMosymd;
    }

    public BizNumber getYoteirrthendohosyurrt() {
        return yoteirrthendohosyurrt;
    }

    public void setYoteirrthendohosyurrt(BizNumber pYoteirrthendohosyurrt) {
        yoteirrthendohosyurrt = pYoteirrthendohosyurrt;
    }

    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    public BizDate getHaraimanymd() {
        return haraimanymd;
    }

    public void setHaraimanymd(BizDate pHaraimanymd) {
        haraimanymd = pHaraimanymd;
    }

    public boolean getTyotikuseihokenhyoujihanteiflag() {
        return tyotikuseihokenhyoujihanteiflag;
    }

    public void setTyotikuseihokenhyoujihanteiflag(boolean pTyotikuseihokenhyoujihanteiflag) {
        tyotikuseihokenhyoujihanteiflag = pTyotikuseihokenhyoujihanteiflag;
    }

    public int getDai1hknkkn() {
        return dai1hknkkn;
    }

    public void setDai1hknkkn(int pDai1hknkkn) {
        this.dai1hknkkn = pDai1hknkkn;
    }

}
