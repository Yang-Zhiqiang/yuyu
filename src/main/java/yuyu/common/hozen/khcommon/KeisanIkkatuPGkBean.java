package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 一括払Ｐ計算用Bean
 */
public class KeisanIkkatuPGkBean {

    private String syouhnCd;

    private int syouhnsdNo;

    private String ryouritusdNo;

    private BizNumber yoteiRiritu;

    private BizCurrency hokenryou;

    private int keikamon;

    private C_Hrkkaisuu hrkkaisuu;

    private C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn;

    private int hhknnen;

    private C_Hhknsei hhknsei;

    private C_HknkknsmnKbn hknkknsmnKbn;

    private int hknkkn;

    private int hrkkkn;

    private BizCurrency hokenkngk;

    private C_Tuukasyu kykTuukasyu;

    private C_Kykjyoutai kykjyoutai;

    private int dai1hknkkn;

    private C_Hrkkeiro hrkkeiro;

    public String getSyouhnCd() {
        return syouhnCd;
    }

    public void setSyouhnCd(String pSyouhnCd) {
        syouhnCd = pSyouhnCd;
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

    public BizNumber getYoteiRiritu() {
        return yoteiRiritu;
    }

    public void setYoteiRiritu(BizNumber pYoteiRiritu) {
        yoteiRiritu = pYoteiRiritu;
    }

    public BizCurrency getHokenryou() {
        return hokenryou;
    }

    public void setHokenryou(BizCurrency pHokenryou) {
        hokenryou = pHokenryou;
    }

    public int getKeikamon() {
        return keikamon;
    }

    public void setKeikamon(int pKeikamon) {
        keikamon = pKeikamon;
    }

    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    public C_TkiktbrisyuruiKbn getTkiktbrisyuruiKbn() {
        return tkiktbrisyuruiKbn;
    }

    public void setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn pTkiktbrisyuruiKbn) {
        tkiktbrisyuruiKbn = pTkiktbrisyuruiKbn;
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

    public C_HknkknsmnKbn getHknkknsmnKbn() {
        return hknkknsmnKbn;
    }

    public void setHknkknsmnKbn(C_HknkknsmnKbn pHknkknsmnKbn) {
        hknkknsmnKbn = pHknkknsmnKbn;
    }

    public int getHknkkn() {
        return hknkkn;
    }

    public void setHknkkn(int pHknkkn) {
        hknkkn = pHknkkn;
    }

    public int getHrkkkn() {
        return hrkkkn;
    }

    public void setHrkkkn(int pHrkkkn) {
        hrkkkn = pHrkkkn;
    }

    public BizCurrency getHokenkngk() {
        return hokenkngk;
    }

    public void setHokenkngk(BizCurrency pHokenkngk) {
        hokenkngk = pHokenkngk;
    }

    public C_Tuukasyu getKykTuukasyu() {
        return kykTuukasyu;
    }

    public void setKykTuukasyu(C_Tuukasyu pKykTuukasyu) {
        kykTuukasyu = pKykTuukasyu;
    }

    public C_Kykjyoutai getKykjyoutai() {
        return kykjyoutai;
    }

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
        kykjyoutai = pKykjyoutai;
    }

    public int getDai1hknkkn() {
        return dai1hknkkn;
    }

    public void setDai1hknkkn(int pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }

    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }
}
