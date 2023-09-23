package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import yuyu.common.hozen.khcommon.dba4setyuuyokknmanryobi.SetYuuyokknmanryobiDao;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_Tokusin;

/**
 * 契約保全 契約保全共通 猶予期間満了日設定
 */
public class SetYuuyokknmanryobi {

    //    private static final BizDate MAX_YMD = BizDate.valueOf("99991231");

    private BizDate yuuyokknMnryBi;

    private BizDate tksnYuuyokknMnryBi;

    //    private BizDate sikkouBi;

    private BizDate syoumetuBi;

    @Inject
    private SetYuuyokknmanryobiDao setYuuyokknmanryobiDao;

    public SetYuuyokknmanryobi() {
        super();
    }

    public BizDate getYuuyokknMnrybi() {
        return yuuyokknMnryBi;
    }

    public BizDate getTksnYuuyokknMnrybi() {
        return tksnYuuyokknMnryBi;
    }

    //    public BizDate getSikkoubi() {
    //        return sikkouBi;
    //    }

    public BizDate getSyoumetubi() {
        return syoumetuBi;
    }

    public void exec(String pSyono, BizDateYM pJyutouYM) {

        //        IT_KykKihon kykKihon = setYuuyokknmanryobiDao.getKykKihon(pSyono);
        //        if (kykKihon == null) {
        //            throw new CommonBizAppException("契約基本テーブルにデータが存在しません。");
        //        }
        //
        //        if (C_Hrkkaisuu.ITIJI.eq(kykKihon.getHrkkaisuu())) {
        //
        //            yuuyokknMnryBi = MAX_YMD;
        //            tksnYuuyokknMnryBi = MAX_YMD;
        //            sikkouBi = MAX_YMD;
        //
        //            return;
        //        }
        //
        //        List<IT_KykSyouhn> kykSyouhnLst = setYuuyokknmanryobiDao.getKykSyouhns(kykKihon, C_SyutkKbn.SYU);
        //        if (kykSyouhnLst == null || kykSyouhnLst.size() == 0) {
        //            throw new CommonBizAppException("契約商品テーブルにデータが存在しません。");
        //        }
        //
        //        BizDate wkYuuyokknMnryBi = null;
        //
        //        if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {
        //
        //            BizDate wkYuuyokknMnrybiTaihi = BizDate.valueOf(pJyutouYM + "01");
        //
        //            wkYuuyokknMnrybiTaihi = wkYuuyokknMnrybiTaihi.getBizDateYM().getNextMonth().getLastDay();
        //
        //            BizDate kykYMD = kykSyouhnLst.get(0).getKykymd();
        //
        //            if (wkYuuyokknMnrybiTaihi.isHoliday()) {
        //                wkYuuyokknMnrybiTaihi = wkYuuyokknMnrybiTaihi.getBusinessDay(CHolidayAdjustingMode.NEXT);
        //            }
        //
        //            wkYuuyokknMnryBi = wkYuuyokknMnrybiTaihi;
        //        }
        //        else {
        //            if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu()) ||
        //                C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {
        //
        //                BizDate wkKykymdmove = kykSyouhnLst.get(0).getKykymd();
        //
        //                wkKykymdmove = wkKykymdmove.getBizDateYM().getLastDay();
        //
        //                BizDate wkKykymd = kykSyouhnLst.get(0).getKykymd();
        //
        //                if (wkKykymdmove.compareTo(wkKykymd) == 0) {
        //                    BizDate wkYuuyokknMnrybiTaihi = BizDate.valueOf(pJyutouYM + "01");
        //
        //                    wkYuuyokknMnrybiTaihi = wkYuuyokknMnrybiTaihi.getBizDateYM().getNextMonth().getNextMonth().getLastDay();
        //
        //                    if (wkYuuyokknMnrybiTaihi.isHoliday()) {
        //                        wkYuuyokknMnrybiTaihi = wkYuuyokknMnrybiTaihi.getBusinessDay(CHolidayAdjustingMode.NEXT);
        //                    }
        //                    wkYuuyokknMnryBi = wkYuuyokknMnrybiTaihi;
        //                }
        //                else {
        //
        //                    BizDate wkKykymdmv2 = BizDate.valueOf(pJyutouYM + "01");
        //                    BizDateSpan bizDateSpan = new BizDateSpan(0, 2, 0);
        //                    wkKykymdmv2 = wkKykymdmv2.add(bizDateSpan);
        //                    wkKykymdmv2 = BizDate.valueOf(wkKykymdmv2.getBizDateYM()
        //                        + kykSyouhnLst.get(0).getKykymd().toString().substring(6)).getRekijyou();
        //
        //                    if (wkKykymdmv2.isHoliday()) {
        //                        wkKykymdmv2 = wkKykymdmv2.getBusinessDay(CHolidayAdjustingMode.NEXT);
        //                    }
        //                    wkYuuyokknMnryBi = wkKykymdmv2;
        //
        //                }
        //            }
        //        }
        //
        //        IT_Tokusin tokusin = setYuuyokknmanryobiDao.getTokusin(pSyono);
        //
        //        BizDate wkTksnYuuyokknMnrybi = null;
        //
        //        BizDate wkSikkoubi = null;
        //
        //        if (tokusin == null) {
        //            wkTksnYuuyokknMnrybi = wkYuuyokknMnryBi;
        //            wkSikkoubi = wkYuuyokknMnryBi;
        //        }
        //        else {
        //
        //            wkTksnYuuyokknMnrybi = tokusin.getTokusinendymd();
        //
        //            if (wkTksnYuuyokknMnrybi.compareTo(wkYuuyokknMnryBi) < 0) {
        //
        //                wkTksnYuuyokknMnrybi = wkYuuyokknMnryBi;
        //            }
        //
        //            if (C_TokusinKbn.HISAIGAI.eq(tokusin.getTokusinkbn())) {
        //                wkSikkoubi = wkTksnYuuyokknMnrybi;
        //
        //            } else {
        //                wkSikkoubi = wkYuuyokknMnryBi;
        //
        //            }
        //        }
        //
        //        wkSikkoubi = wkSikkoubi.getNextDay();
        //
        //        yuuyokknMnryBi = wkYuuyokknMnryBi;
        //
        //        tksnYuuyokknMnryBi = wkTksnYuuyokknMnrybi;
        //
        //        sikkouBi = wkSikkoubi;

        IT_KykKihon kykKihon = setYuuyokknmanryobiDao.getKykKihon(pSyono);

        C_Hrkkaisuu hrkkaisuu = kykKihon.getHrkkaisuu();

        BizDate wkYuuyokknMnryBi = null;

        BizDate wkYuuyokknMnrybiTaihi = null;

        if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu) || C_Hrkkaisuu.NEN.eq(hrkkaisuu) || C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {

            wkYuuyokknMnrybiTaihi = BizDate.valueOf(pJyutouYM + "01");

            wkYuuyokknMnrybiTaihi = wkYuuyokknMnrybiTaihi.getBizDateYM().addMonths(2).getLastDay();

            if (wkYuuyokknMnrybiTaihi.isHoliday()) {

                wkYuuyokknMnrybiTaihi = wkYuuyokknMnrybiTaihi.getBusinessDay(CHolidayAdjustingMode.NEXT);
            }
            wkYuuyokknMnryBi = wkYuuyokknMnrybiTaihi;
        }

        IT_Tokusin tokusin = setYuuyokknmanryobiDao.getTokusin(pSyono);

        BizDate wkTksnYuuyokknMnrybi = null;

        BizDate wkSyoumetubi = null;

        if (tokusin == null) {
            wkTksnYuuyokknMnrybi = wkYuuyokknMnryBi;

            wkSyoumetubi = wkYuuyokknMnryBi;
        }
        else {

            wkTksnYuuyokknMnrybi = tokusin.getTokusinendymd();

            if (wkTksnYuuyokknMnrybi.compareTo(wkYuuyokknMnryBi) < 0) {

                wkTksnYuuyokknMnrybi = wkYuuyokknMnryBi;
            }

            if (C_TokusinKbn.HISAIGAI.eq(tokusin.getTokusinkbn())) {
                wkSyoumetubi = wkTksnYuuyokknMnrybi;
            } else {
                wkSyoumetubi = wkYuuyokknMnryBi;
            }
        }

        wkSyoumetubi = wkSyoumetubi.getNextDay();

        yuuyokknMnryBi = wkYuuyokknMnryBi;

        tksnYuuyokknMnryBi = wkTksnYuuyokknMnrybi;

        syoumetuBi = wkSyoumetubi;
    }
}