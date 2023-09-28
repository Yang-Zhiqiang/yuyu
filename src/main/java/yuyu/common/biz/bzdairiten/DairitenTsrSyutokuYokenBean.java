package yuyu.common.biz.bzdairiten;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 代理店 代理店手数料取得与件BEAN
 */
public class DairitenTsrSyutokuYokenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String oyaDrtenCd;

    private String syouhnCd;

    private String ryourituSdNo;

    private C_Hrkkaisuu hrkKaisuu;

    private String saimankiKeiyakuHyouji;

    private String hhknNen;

    private int hknKkn;

    private int pHaraikomiKikan;

    private BizCurrency syuKeiyakuP;

    private String drtenTsryHushrKykHyouji;

    private BizNumber yenKnsnTekiRate;

    private C_Tuukasyu syuKeiyakuPTuukaSyu;

    private BizNumber yoteiRiritu;

    private BizDate calckijyunymd;

    private BizCurrency syupHrktuuka;

    private C_Tuukasyu hrktuukasyu;

    private C_IkkatubaraiKbn ikkatubaraikbn;

    private C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu;

    private BizCurrency kihonnS;

    public DairitenTsrSyutokuYokenBean() {
        super();

        oyaDrtenCd = "";
        syouhnCd = "";
        ryourituSdNo = "";
        hrkKaisuu = C_Hrkkaisuu.BLNK;
        saimankiKeiyakuHyouji = "0";
        hhknNen = "";
        hknKkn = 0;
        pHaraikomiKikan = 0;
        syuKeiyakuP = null;
        drtenTsryHushrKykHyouji = "0";
        yenKnsnTekiRate = null;
        syuKeiyakuPTuukaSyu = C_Tuukasyu.BLNK;
        yoteiRiritu = BizNumber.ZERO;
        calckijyunymd = null;
        syupHrktuuka = null;
        hrktuukasyu = C_Tuukasyu.BLNK;
        ikkatubaraikbn = C_IkkatubaraiKbn.BLNK;
        ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.BLNK;
        kihonnS = null;
    }

    public String getOyaDrtenCd() {
        return oyaDrtenCd;
    }

    public void setOyaDrtenCd(String pOyaDrtenCd) {
        this.oyaDrtenCd = pOyaDrtenCd;
    }

    public String getSyouhnCd() {
        return syouhnCd;
    }

    public void setSyouhnCd(String pSyouhnCd) {
        this.syouhnCd = pSyouhnCd;
    }

    public String getRyourituSdNo() {
        return ryourituSdNo;
    }

    public void setRyourituSdNo(String pRyourituSdNo) {
        this.ryourituSdNo = pRyourituSdNo;
    }

    public C_Hrkkaisuu getHrkKaisuu() {
        return hrkKaisuu;
    }

    public void setHrkKaisuu(C_Hrkkaisuu pHrkKaisuu) {
        this.hrkKaisuu = pHrkKaisuu;
    }

    public String getSaimankiKeiyakuHyouji() {
        return saimankiKeiyakuHyouji;
    }

    public void setSaimankiKeiyakuHyouji(String pSaimankiKeiyakuHyouji) {
        this.saimankiKeiyakuHyouji = pSaimankiKeiyakuHyouji;
    }

    public String getHhknNen() {
        return hhknNen;
    }

    public void setHhknNen(String pHhknNen) {
        this.hhknNen = pHhknNen;
    }

    public int getHknKkn() {
        return hknKkn;
    }

    public void setHknKkn(int pHknKkn) {
        this.hknKkn = pHknKkn;
    }

    public int getpHaraikomiKikan() {
        return pHaraikomiKikan;
    }

    public void setpHaraikomiKikan(int pPHaraikomiKikan) {
        this.pHaraikomiKikan = pPHaraikomiKikan;
    }

    public BizCurrency getSyuKeiyakuP() {
        return syuKeiyakuP;
    }

    public void setSyuKeiyakuP(BizCurrency pSyuKeiyakuP) {
        this.syuKeiyakuP = pSyuKeiyakuP;
    }

    public String getDrtenTsryHushrKykHyouji() {
        return drtenTsryHushrKykHyouji;
    }

    public void setDrtenTsryHushrKykHyouji(String pDrtenTsryHushrKykHyouji) {
        drtenTsryHushrKykHyouji = pDrtenTsryHushrKykHyouji;
    }

    public BizNumber getYenKnsnTekiRate() {
        return yenKnsnTekiRate;
    }

    public void setYenKnsnTekiRate(BizNumber pYenKnsnTekiRate) {
        this.yenKnsnTekiRate = pYenKnsnTekiRate;
    }

    public C_Tuukasyu getSyuKeiyakuPTuukaSyu() {
        return syuKeiyakuPTuukaSyu;
    }

    public void setSyuKeiyakuPTuukaSyu(C_Tuukasyu pSyuKeiyakuPTuukaSyu) {
        this.syuKeiyakuPTuukaSyu = pSyuKeiyakuPTuukaSyu;
    }

    public BizNumber getYoteiRiritu() {
        return yoteiRiritu;
    }

    public void setYoteiRiritu(BizNumber pYoteiRiritu) {
        this.yoteiRiritu = pYoteiRiritu;
    }

    public BizDate getCalckijyunymd() {
        return calckijyunymd;
    }

    public void setCalckijyunymd(BizDate pCalckijyunymd) {
        this.calckijyunymd = pCalckijyunymd;
    }

    public BizCurrency getSyupHrktuuka() {
        return syupHrktuuka;
    }

    public void setSyupHrktuuka(BizCurrency pSyupHrktuuka) {
        this.syupHrktuuka = pSyupHrktuuka;
    }

    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        this.hrktuukasyu = pHrktuukasyu;
    }

    public C_IkkatubaraiKbn getIkkatubaraikbn() {
        return ikkatubaraikbn;
    }

    public void setIkkatubaraikbn(C_IkkatubaraiKbn pIkkatubaraikbn) {
        this.ikkatubaraikbn = pIkkatubaraikbn;
    }

    public C_IkkatubaraiKaisuuKbn getIkkatubaraikaisuu() {
        return ikkatubaraikaisuu;
    }

    public void setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu) {
        this.ikkatubaraikaisuu = pIkkatubaraikaisuu;
    }

    public BizCurrency getKihonnS() {
        return kihonnS;
    }

    public void setKihonnS(BizCurrency pKihonnS) {
        this.kihonnS = pKihonnS;
    }
}
