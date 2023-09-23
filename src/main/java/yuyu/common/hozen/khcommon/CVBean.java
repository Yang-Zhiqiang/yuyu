package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UnitFundKbn;

/**
 * 契約保全 契約保全共通 変額積立金Bean
 */
public class CVBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_UnitFundKbn unitFundKbn;

    private BizNumber unitSuu;

    private BizDate unitKouryokuhasseiYmd;

    private BizNumber fundIndex;

    private BizDate fundHyoukaYmd;

    private BizCurrency fundBetuTumitatekin;

    private int wariAi;

    private C_UmuKbn historyFlag;

    public CVBean() {

        unitFundKbn = null;

        unitSuu = null;

        unitKouryokuhasseiYmd = null;

        fundIndex = null;

        fundHyoukaYmd = null;

        fundBetuTumitatekin = null;

        wariAi = 0;

        historyFlag = null;
    }

    public C_UnitFundKbn getUnitFundKbn() {
        return unitFundKbn;
    }

    public void setUnitFundKbn(C_UnitFundKbn pUnitFundKbn) {
        unitFundKbn = pUnitFundKbn;
    }

    public BizNumber getUnitSuu() {
        return unitSuu;
    }

    public void setUnitSuu(BizNumber pUnitSuu) {
        unitSuu = pUnitSuu;
    }

    public BizDate getUnitKouryokuhasseiYmd() {
        return unitKouryokuhasseiYmd;
    }

    public void setUnitKouryokuhasseiYmd(BizDate pUnitKouryokuhasseiYmd) {
        unitKouryokuhasseiYmd = pUnitKouryokuhasseiYmd;
    }

    public BizNumber getFundIndex() {
        return fundIndex;
    }

    public void setFundIndex(BizNumber pFundIndex) {
        fundIndex = pFundIndex;
    }

    public BizDate getFundHyoukaYmd() {
        return fundHyoukaYmd;
    }

    public void setFundHyoukaYmd(BizDate pFundHyoukaYmd) {
        fundHyoukaYmd = pFundHyoukaYmd;
    }

    public BizCurrency getFundBetuTumitatekin() {
        return fundBetuTumitatekin;
    }

    public void setFundBetuTumitatekin(BizCurrency pFundBetuTumitatekin) {
        fundBetuTumitatekin = pFundBetuTumitatekin;
    }

    public int getWariAi() {
        return wariAi;
    }

    public void setWariAi(int pWariAi) {
        wariAi = pWariAi;
    }

    public C_UmuKbn getHistoryFlag() {
        return historyFlag;
    }

    public void setHistoryFlag(C_UmuKbn pHistoryFlag) {
        historyFlag = pHistoryFlag;
    }
}
