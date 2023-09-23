package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import yuyu.common.biz.bzcommon.BizDateUtil;

/**
 * 契約保全 契約保全共通 口座振替日設定処理
 */
public class SetHurikaebi {

    private BizDate tyokuzenHurikaeBi;

    private BizDate tyokugoHurikaeBi;

    private BizDate tyokuzenAnnaiBi;

    private BizDate tyokugoAnnaiBi;

    public SetHurikaebi() {
        super();
    }

    public BizDate getTyokuzenHurikaebi() {
        return tyokuzenHurikaeBi;
    }

    public BizDate getTyokugoHurikaebi() {
        return tyokugoHurikaeBi;
    }

    public BizDate getTyokuzenAnnaibi() {
        return tyokuzenAnnaiBi;
    }

    public BizDate getTyokugoAnnaibi() {
        return tyokugoAnnaiBi;
    }

    public void exec(BizDate pSyoriBi) {

        BizDate huriKaeBi = getHurikaebi(pSyoriBi.getBizDateYM());

        BizDate annaiBi = getAnnaibi(huriKaeBi);

        BizDate previousMonth = pSyoriBi.getPreviousMonth();

        BizDate previousHuriKaeBi = getHurikaebi(previousMonth.getBizDateYM());

        BizDate previousAnnaiBi = getAnnaibi(previousHuriKaeBi);

        BizDate nextMonth = pSyoriBi.getNextMonth();

        BizDate nextHuriKaebi = getHurikaebi(nextMonth.getBizDateYM());

        BizDate nextAnnaibi = getAnnaibi(nextHuriKaebi);

        if (BizDateUtil.compareYmd(pSyoriBi, huriKaeBi) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(pSyoriBi, huriKaeBi) == BizDateUtil.COMPARE_EQUAL) {
            tyokuzenHurikaeBi = previousHuriKaeBi;
            tyokugoHurikaeBi = huriKaeBi;
        }
        else {
            tyokuzenHurikaeBi = huriKaeBi;
            tyokugoHurikaeBi = nextHuriKaebi;
        }

        if (BizDateUtil.compareYmd(pSyoriBi, annaiBi) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(pSyoriBi, annaiBi) == BizDateUtil.COMPARE_EQUAL) {
            tyokuzenAnnaiBi = previousAnnaiBi;
            tyokugoAnnaiBi = annaiBi;
        }
        else {
            tyokuzenAnnaiBi = annaiBi;
            tyokugoAnnaiBi = nextAnnaibi;
        }

    }

    private BizDate getHurikaebi(BizDateYM pSyoriYm) {

        BizDate hurikaebi = BizDate.valueOf(pSyoriYm + "27");

        if (hurikaebi.isHoliday()) {

            hurikaebi = hurikaebi.getBusinessDay(CHolidayAdjustingMode.NEXT);
        }

        return hurikaebi;
    }

    private BizDate getAnnaibi(BizDate pHurikaeBi) {

        BizDate annaibi = pHurikaeBi;

        annaibi = annaibi.addBusinessDays(-9);

        return annaibi;
    }

}
