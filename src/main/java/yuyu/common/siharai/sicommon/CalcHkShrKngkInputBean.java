package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金額計算入力Beanクラス
 */
public class CalcHkShrKngkInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syouhnCd;

    private Integer syouhnSdno;

    private String ryouritusdNo;

    private BizNumber yoteiRiritu;

    private C_Hrkkaisuu hrkKaisuu;

    private C_HknkknsmnKbn hknkknsmnKbn;

    private Integer hknKkn;

    private Integer hrkKkn;

    private Integer hhknNen;

    private C_Hhknsei hhknSei;

    private BizCurrency kihonS;

    private BizDate kykYmd;

    private BizDate calckijyunYmd;

    private String syoNo;

    private C_Tuukasyu tuukaSyu;

    private Integer dai1hknKkn;

    private C_SiinKbn siinKbn;

    private C_HokenkinsyuruiKbn hokenkinsyuruiKbn;

    private BizCurrency hokenRyou;

    private BizNumber kaiyakusjkkktyouseiRiritu;

    private BizNumber kyksjkkktyouseiRiritu;

    private BizDateYM tmttkntaisyouYm;

    private BizCurrency teiritutmttKngk;

    private BizCurrency  sisuurendoutmttKngk;

    private BizNumber tumitateRiritu;

    private C_HrkkknsmnKbn hrkkknsmnKbn;

    private BizDateYM jkipjytYm;

    private BizCurrency ptmttKngk;

    private BizCurrency kihrkmPStgk;

    private BizDate fstPryosyuYmd;

    private BizNumber yoteirrthendohosyuRiritu;

    private C_Kykjyoutai kykJyoutai;

    private BizDate yendthnkYmd;

    private BM_SyouhnZokusei syouhnZokusei;

    private C_Sdpd sdpdkbn;

    private C_Hrkkeiro hrkkeiro;

    public CalcHkShrKngkInputBean() {
        super();
    }

    public String getSyouhncd() {
        return syouhnCd;
    }

    public void setSyouhncd(String pSyouhnCd) {
        this.syouhnCd = pSyouhnCd;
    }

    public Integer getSyouhnsdno() {
        return syouhnSdno;
    }

    public void setSyouhnsdno(Integer pSyouhnSdno) {
        this.syouhnSdno = pSyouhnSdno;
    }

    public String getRyouritusdno() {
        return ryouritusdNo;
    }

    public void setRyouritusdno(String pRyouritusdNo) {
        this.ryouritusdNo = pRyouritusdNo;
    }

    public BizNumber getYoteiriritu() {
        return yoteiRiritu;
    }

    public void setYoteiriritu(BizNumber pYoteiRiritu) {
        this.yoteiRiritu = pYoteiRiritu;
    }

    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkKaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkKaisuu) {
        this.hrkKaisuu = pHrkKaisuu;
    }

    public C_HknkknsmnKbn getHknkknsmnkbn() {
        return hknkknsmnKbn;
    }

    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnKbn) {
        this.hknkknsmnKbn = pHknkknsmnKbn;
    }

    public Integer getHknkkn() {
        return hknKkn;
    }

    public void setHknkkn(Integer pHknKkn) {
        this.hknKkn = pHknKkn;
    }

    public Integer getHrkkkn() {
        return hrkKkn;
    }

    public void setHrkkkn(Integer pHrkKkn) {
        this.hrkKkn = pHrkKkn;
    }

    public Integer getHhknnen() {
        return hhknNen;
    }

    public void setHhknnen(Integer pHhknNen) {
        this.hhknNen = pHhknNen;
    }

    public C_Hhknsei getHhknsei() {
        return hhknSei;
    }

    public void setHhknsei(C_Hhknsei pHhknSei) {
        this.hhknSei = pHhknSei;
    }

    public BizCurrency getKihons() {
        return kihonS;
    }

    public void setKihons(BizCurrency pKihonS) {
        this.kihonS = pKihonS;
    }

    public BizDate getKykymd() {
        return kykYmd;
    }

    public void setKykymd(BizDate pKykYmd) {
        this.kykYmd = pKykYmd;
    }

    public BizDate getCalckijyunymd() {
        return calckijyunYmd;
    }

    public void setCalckijyunymd(BizDate pCalckijyunYmd) {
        this.calckijyunYmd = pCalckijyunYmd;
    }

    public String getSyono() {
        return syoNo;
    }

    public void setSyono(String pSyoNo) {
        this.syoNo = pSyoNo;
    }

    public C_Tuukasyu getTuukasyu() {
        return tuukaSyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukaSyu) {
        this.tuukaSyu = pTuukaSyu;
    }

    public Integer getDai1hknkkn() {
        return dai1hknKkn;
    }

    public void setDai1hknkkn(Integer pDai1hknKkn) {
        this.dai1hknKkn = pDai1hknKkn;
    }
    public C_SiinKbn getSiinkbn() {
        return siinKbn;
    }

    public void setSiinkbn(C_SiinKbn pSiinKbn) {
        this.siinKbn = pSiinKbn;
    }

    public C_HokenkinsyuruiKbn getHokenkinsyuruikbn() {
        return hokenkinsyuruiKbn;
    }

    public void setHokenkinsyuruikbn(C_HokenkinsyuruiKbn pHokenkinsyuruiKbn) {
        this.hokenkinsyuruiKbn = pHokenkinsyuruiKbn;
    }

    public BizCurrency getHokenryou() {
        return hokenRyou;
    }

    public void setHokenryou(BizCurrency pHokenRyou) {
        this.hokenRyou = pHokenRyou;
    }

    public BizNumber getKaiyakusjkkktyouseiriritu() {
        return kaiyakusjkkktyouseiRiritu;
    }

    public void setKaiyakusjkkktyouseiriritu(BizNumber pKaiyakusjkkktyouseiRiritu) {
        this.kaiyakusjkkktyouseiRiritu = pKaiyakusjkkktyouseiRiritu;
    }

    public BizNumber getKyksjkkktyouseiriritu() {
        return kyksjkkktyouseiRiritu;
    }

    public void setKyksjkkktyouseiriritu(BizNumber pKyksjkkktyouseiRiritu) {
        this.kyksjkkktyouseiRiritu = pKyksjkkktyouseiRiritu;
    }

    public BizDateYM getTmttkntaisyouym() {
        return tmttkntaisyouYm;
    }

    public void setTmttkntaisyouym(BizDateYM pTmttkntaisyouYm) {
        this.tmttkntaisyouYm = pTmttkntaisyouYm;
    }

    public BizCurrency getTeiritutmttkngk() {
        return teiritutmttKngk;
    }

    public void setTeiritutmttkngk(BizCurrency pTeiritutmttKngk) {
        this.teiritutmttKngk = pTeiritutmttKngk;
    }

    public BizCurrency getSisuurendoutmttkngk() {
        return sisuurendoutmttKngk;
    }

    public void setSisuurendoutmttkngk(BizCurrency pSisuurendoutmttKngk) {
        this.sisuurendoutmttKngk = pSisuurendoutmttKngk;
    }

    public BizNumber getTumitateriritu() {
        return tumitateRiritu;
    }

    public void setTumitateriritu(BizNumber pTumitateRiritu) {
        this.tumitateRiritu = pTumitateRiritu;
    }

    public C_HrkkknsmnKbn getHrkkknsmnKbn() {
        return hrkkknsmnKbn;
    }

    public void setHrkkknsmnKbn(C_HrkkknsmnKbn hrkkknsmnKbn) {
        this.hrkkknsmnKbn = hrkkknsmnKbn;
    }

    public BizDateYM getJkipjytYm() {
        return jkipjytYm;
    }

    public void setJkipjytYm(BizDateYM jkipjytYm) {
        this.jkipjytYm = jkipjytYm;
    }

    public BizCurrency getPtmttKngk() {
        return ptmttKngk;
    }

    public void setPtmttKngk(BizCurrency ptmttKngk) {
        this.ptmttKngk = ptmttKngk;
    }

    public BizCurrency getKihrkmPStgk() {
        return kihrkmPStgk;
    }

    public void setKihrkmPStgk(BizCurrency kihrkmPStgk) {
        this.kihrkmPStgk = kihrkmPStgk;
    }

    public BizDate getFstPryosyuYmd() {
        return fstPryosyuYmd;
    }

    public void setFstPryosyuYmd(BizDate fstPryosyuYmd) {
        this.fstPryosyuYmd = fstPryosyuYmd;
    }

    public BizNumber getYoteirrthendohosyuRiritu() {
        return yoteirrthendohosyuRiritu;
    }

    public void setYoteirrthendohosyuRiritu(BizNumber yoteirrthendohosyuRiritu) {
        this.yoteirrthendohosyuRiritu = yoteirrthendohosyuRiritu;
    }

    public C_Kykjyoutai getKykJyoutai() {
        return kykJyoutai;
    }

    public void setKykJyoutai(C_Kykjyoutai kykJyoutai) {
        this.kykJyoutai = kykJyoutai;
    }

    public BizDate getYendthnkYmd() {
        return yendthnkYmd;
    }

    public void setYendthnkYmd(BizDate yendthnkYmd) {
        this.yendthnkYmd = yendthnkYmd;
    }

    public BM_SyouhnZokusei getSyouhnZokusei() {
        return syouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei syouhnZokusei) {
        this.syouhnZokusei = syouhnZokusei;
    }

    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        this.sdpdkbn = pSdpdkbn;
    }

    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        this.hrkkeiro = pHrkkeiro;
    }


}
