package yuyu.common.sinkeiyaku.skcommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Uketorinin;

/**
 * 新契約 新契約共通 新契約当日異動変更前内容Bean
 */
public class SkIdounaiyouBeforeBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private HT_SyoriCTL syoriCTL;

    private HT_MosKihon mosKihon;

    private HT_MosSyouhn mosSyouhn;

    private HT_Uketorinin sbUketorinin1;

    private HT_Uketorinin sbUketorinin2;

    private HT_Uketorinin sbUketorinin3;

    private HT_Uketorinin sbUketorinin4;

    private HT_Uketorinin stDrSkUketorinin1;

    private HT_MosDairiten mosDairiten1;

    private HT_MosDairiten mosDairiten2;

    private HT_MosTrkKzk mosTrkKzk1;

    private HT_MosTrkKzk mosTrkKzk2;

    private HT_KouzaJyouhou kouzaJyouhou;

    private int sbUktNin;

    private int stDrSkNin;

    private int mosDrt;

    private int mosTrkKzkNin;

    private BizCurrency tsnSibouS;

    private BizCurrency itijiP;

    private BizCurrency tsnyouNkGns;

    private BizCurrency tsnyEnNyknkGk;

    private C_Tuukasyu tsnyTuukasyu;

    public HT_SyoriCTL getSyoriCTL() {
        return syoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pSyoriCTL) {
        this.syoriCTL = pSyoriCTL;
    }

    public HT_MosKihon getMosKihon() {
        return mosKihon;
    }

    public void setMosKihon(HT_MosKihon pMosKihon) {
        this.mosKihon = pMosKihon;
    }

    public HT_MosSyouhn getMosSyouhn() {
        return mosSyouhn;
    }

    public void setMosSyouhn(HT_MosSyouhn pMosSyouhn) {
        this.mosSyouhn = pMosSyouhn;
    }

    public HT_Uketorinin getSbUketorinin1() {
        return sbUketorinin1;
    }

    public void setSbUketorinin1(HT_Uketorinin pSbUketorinin1) {
        this.sbUketorinin1 = pSbUketorinin1;
    }

    public HT_Uketorinin getSbUketorinin2() {
        return sbUketorinin2;
    }

    public void setSbUketorinin2(HT_Uketorinin pSbUketorinin2) {
        this.sbUketorinin2 = pSbUketorinin2;
    }

    public HT_Uketorinin getSbUketorinin3() {
        return sbUketorinin3;
    }

    public void setSbUketorinin3(HT_Uketorinin pSbUketorinin3) {
        this.sbUketorinin3 = pSbUketorinin3;
    }

    public HT_Uketorinin getSbUketorinin4() {
        return sbUketorinin4;
    }

    public void setSbUketorinin4(HT_Uketorinin pSbUketorinin4) {
        this.sbUketorinin4 = pSbUketorinin4;
    }

    public HT_Uketorinin getStDrSkUketorinin1() {
        return stDrSkUketorinin1;
    }

    public void setStDrSkUketorinin1(HT_Uketorinin pStDrSkUketorinin1) {
        this.stDrSkUketorinin1 = pStDrSkUketorinin1;
    }

    public HT_MosDairiten getMosDairiten1() {
        return mosDairiten1;
    }

    public void setMosDairiten1(HT_MosDairiten pMosDairiten1) {
        this.mosDairiten1 = pMosDairiten1;
    }

    public HT_MosDairiten getMosDairiten2() {
        return mosDairiten2;
    }

    public void setMosDairiten2(HT_MosDairiten pMosDairiten2) {
        this.mosDairiten2 = pMosDairiten2;
    }

    public HT_MosTrkKzk getMosTrkKzk1() {
        return mosTrkKzk1;
    }

    public void setMosTrkKzk1(HT_MosTrkKzk pMosTrkKzk1) {
        this.mosTrkKzk1 = pMosTrkKzk1;
    }

    public HT_MosTrkKzk getMosTrkKzk2() {
        return mosTrkKzk2;
    }

    public void setMosTrkKzk2(HT_MosTrkKzk pMosTrkKzk2) {
        this.mosTrkKzk2 = pMosTrkKzk2;
    }

    public HT_KouzaJyouhou getKouzaJyouhou() {
        return kouzaJyouhou;
    }

    public void setKouzaJyouhou(HT_KouzaJyouhou pKouzaJyouhou) {
        this.kouzaJyouhou = pKouzaJyouhou;
    }

    public int getSbUktNin() {
        return sbUktNin;
    }

    public void setSbUktNin(int pSbUktNin) {
        this.sbUktNin = pSbUktNin;
    }

    public int getStDrSkNin() {
        return stDrSkNin;
    }

    public void setStDrSkNin(int pStDrSkNin) {
        this.stDrSkNin = pStDrSkNin;
    }

    public int getMosDrt() {
        return mosDrt;
    }

    public void setMosDrt(int pMosDrt) {
        this.mosDrt = pMosDrt;
    }

    public int getMosTrkKzkNin() {
        return mosTrkKzkNin;
    }

    public void setMosTrkKzkNin(int pMosTrkKzkNin) {
        this.mosTrkKzkNin = pMosTrkKzkNin;
    }

    public BizCurrency getTsnSibouS() {
        return tsnSibouS;
    }

    public void setTsnSibouS(BizCurrency pTsnSibouS) {
        this.tsnSibouS = pTsnSibouS;
    }

    public BizCurrency getItijiP() {
        return itijiP;
    }

    public void setItijiP(BizCurrency pItijiP) {
        this.itijiP = pItijiP;
    }

    public BizCurrency getTsnyouNkGns() {
        return tsnyouNkGns;
    }

    public void setTsnyouNkGns(BizCurrency pTsnyouNkGns) {
        this.tsnyouNkGns = pTsnyouNkGns;
    }

    public BizCurrency getTsnyEnNyknkGk() {
        return tsnyEnNyknkGk;
    }

    public void setTsnyEnNyknkGk(BizCurrency pTsnyEnNyknkGk) {
        this.tsnyEnNyknkGk = pTsnyEnNyknkGk;
    }

    public C_Tuukasyu getTsnyTuukasyu() {
        return tsnyTuukasyu;
    }

    public void setTsnyTuukasyu(C_Tuukasyu pTsnyTuukasyu) {
        this.tsnyTuukasyu = pTsnyTuukasyu;
    }
}