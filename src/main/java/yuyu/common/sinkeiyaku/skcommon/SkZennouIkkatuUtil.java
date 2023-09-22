package yuyu.common.sinkeiyaku.skcommon;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkSyouhnBean;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.sinkeiyaku.skcommon.dba4skzennouikkatuutil.SkZennouIkkatuUtilDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkHrkPTani;
import yuyu.def.db.entity.BM_IkkatuKeisuu;
import yuyu.def.db.entity.BM_ZennouGenkaRitu2;

/**
 * 新契約 新契約共通 新契約前納一括払関連ユーティリティクラス
 */
public class SkZennouIkkatuUtil {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SkZennouIkkatuUtilDao sKZennouIkkatuUtilDao;

    public SkZennouIkkatuUtil() {
        super();
    }

    public BizCurrency getInRangeIkkatuTukiPSpecifiedZennouPYen(
        BizDate pKijyunymd,
        String pSyusyouhncd,
        Integer pSyusyouhnsdno,
        String pSyuryouritusdno,
        boolean pHrkptanityouseiflg,
        C_Channelcd pKiteichkchannelcd,
        String pKiteichkoyadrtencd,
        Integer pZnnkaisyonendo,
        BizCurrency pZennoupsyonendo) {

        logger.debug("▽ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　開始");

        BizCurrency teikiikkatu12tkbrip = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (pKijyunymd == null) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　終了");

            return teikiikkatu12tkbrip;
        }

        if (!pKijyunymd.isRekijyou()) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　終了");

            return teikiikkatu12tkbrip;
        }

        if (BizUtil.isBlank(pSyusyouhncd)) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　終了");

            return teikiikkatu12tkbrip;
        }

        if (pSyusyouhnsdno == null || pSyusyouhnsdno <= 0) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　終了");

            return teikiikkatu12tkbrip;
        }

        if (BizUtil.isBlank(pSyuryouritusdno)) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　終了");

            return teikiikkatu12tkbrip;
        }

        if (pZnnkaisyonendo == null || pZnnkaisyonendo <= 1) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　終了");

            return teikiikkatu12tkbrip;
        }

        if (pZennoupsyonendo == null
            || pZennoupsyonendo.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　終了");

            return teikiikkatu12tkbrip;
        }

        BizCurrency sisanjyuutoup = getNenbaraiPFromZennouP(
            pKijyunymd,
            pZnnkaisyonendo,
            pZennoupsyonendo);

        if (sisanjyuutoup.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　終了");

            return teikiikkatu12tkbrip;
        }

        BizCurrency sisantkbrip = getTukibaraiPFromIkkatuPYen(
            pSyusyouhncd,
            pSyuryouritusdno,
            C_IkkatubaraiKaisuuKbn.IKKATU12,
            sisanjyuutoup);

        if (sisantkbrip.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　終了");

            return teikiikkatu12tkbrip;
        }

        if (!pHrkptanityouseiflg) {

            teikiikkatu12tkbrip = sisantkbrip;

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　終了");

            return teikiikkatu12tkbrip;
        }

        BizCurrency tkbrihrkptani = getHaraikomiPTanni(
            pSyusyouhncd,
            pSyusyouhnsdno,
            C_Hrkkaisuu.TUKI,
            pKiteichkchannelcd,
            pKiteichkoyadrtencd,
            C_Tuukasyu.JPY);

        if (tkbrihrkptani.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　終了");

            return teikiikkatu12tkbrip;
        }

        BizCurrency tyouseigoGk = roundDownHaraikomiPTanni(
            sisantkbrip,
            tkbrihrkptani);

        if (tyouseigoGk.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　終了");

            return teikiikkatu12tkbrip;
        }

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency tkbrip = tyouseigoGk;

        do {

            tkbrip = tkbrip.add(tkbrihrkptani);

            zennoupsyonendo = getZennouPFrom12IkkatuTukiPYenforMsg(
                true,
                pSyusyouhncd,
                pSyusyouhnsdno,
                pSyuryouritusdno,
                pKijyunymd,
                tkbrip,
                tkbrihrkptani,
                pZnnkaisyonendo,
                0);

            if (zennoupsyonendo.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

                logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　終了");

                return teikiikkatu12tkbrip;
            }
        }
        while (zennoupsyonendo.compareTo(pZennoupsyonendo) <= 0);

        teikiikkatu12tkbrip = tkbrip.subtract(tkbrihrkptani);

        logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（前納Ｐ指定・円）　終了");

        return teikiikkatu12tkbrip;
    }

    public BizCurrency getInRangeIkkatuTukiPSpecifiedIkkatuPYen(
        String pSyusyouhncd,
        Integer pSyusyouhnsdno,
        String pSyuryouritusdno,
        boolean pHrkptanityouseiflg,
        C_Channelcd pKiteichkchannelcd,
        String pKiteichkoyadrtencd,
        C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu,
        BizCurrency pTeikiikkatup) {

        logger.debug("▽ 指定額範囲内定期一括払月払Ｐ算出（定期一括払Ｐ指定・円）　開始");

        BizCurrency teikiikkatutkbrip = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (BizUtil.isBlank(pSyusyouhncd)) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（定期一括払Ｐ指定・円）　終了");

            return teikiikkatutkbrip;
        }

        if (pSyusyouhnsdno == null || pSyusyouhnsdno <= 0) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（定期一括払Ｐ指定・円）　終了");

            return teikiikkatutkbrip;
        }

        if (BizUtil.isBlank(pSyuryouritusdno)) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（定期一括払Ｐ指定・円）　終了");

            return teikiikkatutkbrip;
        }

        if (pIkkatubaraikaisuu == null) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（定期一括払Ｐ指定・円）　終了");

            return teikiikkatutkbrip;
        }
        else if (!C_IkkatubaraiKaisuuKbn.IKKATU6.eq(pIkkatubaraikaisuu)
            && !C_IkkatubaraiKaisuuKbn.IKKATU12.eq(pIkkatubaraikaisuu)) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（定期一括払Ｐ指定・円）　終了");

            return teikiikkatutkbrip;
        }

        if (pTeikiikkatup == null
            || pTeikiikkatup.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（定期一括払Ｐ指定・円）　終了");

            return teikiikkatutkbrip;
        }

        BizCurrency sisantkbrip = getTukibaraiPFromIkkatuPYen(
            pSyusyouhncd,
            pSyuryouritusdno,
            pIkkatubaraikaisuu,
            pTeikiikkatup);

        if (sisantkbrip.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（定期一括払Ｐ指定・円）　終了");

            return teikiikkatutkbrip;
        }

        if (!pHrkptanityouseiflg) {

            teikiikkatutkbrip = sisantkbrip;

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（定期一括払Ｐ指定・円）　終了");

            return teikiikkatutkbrip;
        }

        BizCurrency tkbrihrkptani = getHaraikomiPTanni(
            pSyusyouhncd,
            pSyusyouhnsdno,
            C_Hrkkaisuu.TUKI,
            pKiteichkchannelcd,
            pKiteichkoyadrtencd,
            C_Tuukasyu.JPY);

        if (tkbrihrkptani.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（定期一括払Ｐ指定・円）　終了");

            return teikiikkatutkbrip;
        }

        BizCurrency tyouseigoGk = roundDownHaraikomiPTanni(
            sisantkbrip,
            tkbrihrkptani);

        if (tyouseigoGk.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（定期一括払Ｐ指定・円）　終了");

            return teikiikkatutkbrip;
        }

        BizCurrency teikiikkatup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency tkbrip = tyouseigoGk;

        do {

            tkbrip = tkbrip.add(tkbrihrkptani);

            teikiikkatup = getIkkatuPFromIkkatuTukiPYenforMsg(
                true,
                pSyusyouhncd,
                pSyusyouhnsdno,
                pSyuryouritusdno,
                tkbrip,
                tkbrihrkptani,
                pIkkatubaraikaisuu,
                0);

            if (teikiikkatup.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

                logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（定期一括払Ｐ指定・円）　終了");

                return teikiikkatutkbrip;
            }
        }
        while (teikiikkatup.compareTo(pTeikiikkatup) <= 0);

        teikiikkatutkbrip = tkbrip.subtract(tkbrihrkptani);

        logger.debug("△ 指定額範囲内定期一括払月払Ｐ算出（定期一括払Ｐ指定・円）　終了");

        return teikiikkatutkbrip;
    }

    public BizCurrency getZennouPFrom12IkkatuTukiPYenforMsg(
        boolean pMaxkngkkansflg,
        String pSyusyouhncd,
        Integer pSyusyouhnsdno,
        String pSyuryouritusdno,
        BizDate pKijyunymd,
        BizCurrency pKijyunteikiikkatu12tkbrip,
        BizCurrency pTkbrihrkptani,
        Integer pZnnkaisyonendo,
        int pZennoupsiteitaniskru) {

        logger.debug("▽ 定期１２か月一括払月払Ｐ→前納Ｐ計算（円・メッセージ勧奨用）　開始");

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (BizUtil.isBlank(pSyusyouhncd)) {

            logger.debug("△ 定期１２か月一括払月払Ｐ→前納Ｐ計算（円・メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        if (pSyusyouhnsdno == null || pSyusyouhnsdno <= 0) {

            logger.debug("△ 定期１２か月一括払月払Ｐ→前納Ｐ計算（円・メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        if (BizUtil.isBlank(pSyuryouritusdno)) {

            logger.debug("△ 定期１２か月一括払月払Ｐ→前納Ｐ計算（円・メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        if (pKijyunymd == null) {

            logger.debug("△ 定期１２か月一括払月払Ｐ→前納Ｐ計算（円・メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        if (!pKijyunymd.isRekijyou()) {

            logger.debug("△ 定期１２か月一括払月払Ｐ→前納Ｐ計算（円・メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        if (pKijyunteikiikkatu12tkbrip == null
            || pKijyunteikiikkatu12tkbrip.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 定期１２か月一括払月払Ｐ→前納Ｐ計算（円・メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        if (pTkbrihrkptani == null
            || pTkbrihrkptani.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 定期１２か月一括払月払Ｐ→前納Ｐ計算（円・メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        if (pZnnkaisyonendo == null || pZnnkaisyonendo <= 1) {

            logger.debug("△ 定期１２か月一括払月払Ｐ→前納Ｐ計算（円・メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        BizCurrency kijyuntkbriptyousei = pKijyunteikiikkatu12tkbrip;

        if (pMaxkngkkansflg && pZennoupsiteitaniskru != 0) {

            kijyuntkbriptyousei = pKijyunteikiikkatu12tkbrip.add(pTkbrihrkptani);
        }

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkBean.class);

        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<KeisanIkkatuNyuukinGkSyouhnBean>();

        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = SWAKInjector
            .getInstance(KeisanIkkatuNyuukinGkSyouhnBean.class);

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd(pSyusyouhncd);

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(pSyusyouhnsdno);

        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo(pSyuryouritusdno);

        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.ZERO);

        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(kijyuntkbriptyousei);

        keisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        C_Tuukasyu kijyunteikiikkatu12tkbripType = henkanTuuka.henkanTuukaTypeToKbn(pKijyunteikiikkatu12tkbrip.getType());

        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(keisanIkkatuNyuukinGkSyouhnBeanList);

        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);

        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        keisanIkkatuNyuukinGkBean.setRstuukasyu(kijyunteikiikkatu12tkbripType);

        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.BLNK);

        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.BLNK);

        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(null);

        keisanIkkatuNyuukinGkBean.setJyutoustartYm(null);

        C_ErrorKbn errorKbn = keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean, false);

        if (!C_ErrorKbn.OK.eq(errorKbn)) {

            logger.debug("△ 定期１２か月一括払月払Ｐ→前納Ｐ計算（円・メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        BizCurrency iktnyknkgk = keisanTukiIkkatuNyuukinGk.getIktnyknkgk();

        if (iktnyknkgk == null
            || iktnyknkgk.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 定期１２か月一括払月払Ｐ→前納Ｐ計算（円・メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        KeisanZennouNyuukinGk2 keisanZennouNyuukinGk2 = SWAKInjector.getInstance(KeisanZennouNyuukinGk2.class);

        errorKbn = keisanZennouNyuukinGk2.execKeisanSinkeiyakuDoujiZennouNyuukinGk(
            pKijyunymd,
            iktnyknkgk,
            pZnnkaisyonendo - 1,
            C_Tuukasyu.BLNK,
            null,
            null);

        if (!C_ErrorKbn.OK.eq(errorKbn)) {

            logger.debug("△ 定期１２か月一括払月払Ｐ→前納Ｐ計算（円・メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        BizCurrency zennouNyuukinGk = keisanZennouNyuukinGk2.getZennouNyuukinGk();

        if (zennouNyuukinGk == null
            || zennouNyuukinGk.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 定期１２か月一括払月払Ｐ→前納Ｐ計算（円・メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        if (pMaxkngkkansflg) {

            zennoupsyonendo = zennouNyuukinGk.round(pZennoupsiteitaniskru, RoundingMode.DOWN);
        }
        else {

            zennoupsyonendo = zennouNyuukinGk.round(pZennoupsiteitaniskru, RoundingMode.UP);
        }

        logger.debug("△ 定期１２か月一括払月払Ｐ→前納Ｐ計算（円・メッセージ勧奨用）　終了");

        return zennoupsyonendo;
    }

    public BizCurrency getIkkatuPFromIkkatuTukiPYenforMsg(
        boolean pMaxkngkkansflg,
        String pSyusyouhncd,
        Integer pSyusyouhnsdno,
        String pSyuryouritusdno,
        BizCurrency pTeikiikkatutkbrip,
        BizCurrency pTkbrihrkptani,
        C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu,
        int pIkkatupsiteitaniskru) {

        logger.debug("▽ 定期一括払月払Ｐ→定期一括払Ｐ計算（円・メッセージ勧奨用）　開始");

        BizCurrency teikiikkatup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (BizUtil.isBlank(pSyusyouhncd)) {

            logger.debug("△ 定期一括払月払Ｐ→定期一括払Ｐ計算（円・メッセージ勧奨用）　終了");

            return teikiikkatup;
        }

        if (pSyusyouhnsdno == null || pSyusyouhnsdno <= 0) {

            logger.debug("△ 定期一括払月払Ｐ→定期一括払Ｐ計算（円・メッセージ勧奨用）　終了");

            return teikiikkatup;
        }

        if (BizUtil.isBlank(pSyuryouritusdno)) {

            logger.debug("△ 定期一括払月払Ｐ→定期一括払Ｐ計算（円・メッセージ勧奨用）　終了");

            return teikiikkatup;
        }

        if (pTeikiikkatutkbrip == null
            || pTeikiikkatutkbrip.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 定期一括払月払Ｐ→定期一括払Ｐ計算（円・メッセージ勧奨用）　終了");

            return teikiikkatup;
        }

        if (pTkbrihrkptani == null
            || pTkbrihrkptani.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 定期一括払月払Ｐ→定期一括払Ｐ計算（円・メッセージ勧奨用）　終了");

            return teikiikkatup;
        }

        if (pIkkatubaraikaisuu == null) {

            logger.debug("△ 定期一括払月払Ｐ→定期一括払Ｐ計算（円・メッセージ勧奨用）　終了");

            return teikiikkatup;
        }
        else if (!C_IkkatubaraiKaisuuKbn.IKKATU6.eq(pIkkatubaraikaisuu)
            && !C_IkkatubaraiKaisuuKbn.IKKATU12.eq(pIkkatubaraikaisuu)) {

            logger.debug("△ 定期一括払月払Ｐ→定期一括払Ｐ計算（円・メッセージ勧奨用）　終了");

            return teikiikkatup;
        }

        BizCurrency kijyuntkbriptyousei = pTeikiikkatutkbrip;

        if (pMaxkngkkansflg && pIkkatupsiteitaniskru != 0) {

            kijyuntkbriptyousei = pTeikiikkatutkbrip.add(pTkbrihrkptani);
        }

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkBean.class);

        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<KeisanIkkatuNyuukinGkSyouhnBean>();

        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = SWAKInjector
            .getInstance(KeisanIkkatuNyuukinGkSyouhnBean.class);

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd(pSyusyouhncd);

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(pSyusyouhnsdno);

        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo(pSyuryouritusdno);

        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.ZERO);

        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(kijyuntkbriptyousei);

        keisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(keisanIkkatuNyuukinGkSyouhnBeanList);

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        C_Tuukasyu teikiikkatutkbripType = henkanTuuka.henkanTuukaTypeToKbn(pTeikiikkatutkbrip.getType());

        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(Integer.valueOf(pIkkatubaraikaisuu.getValue()));

        if (C_IkkatubaraiKaisuuKbn.IKKATU12.eq(pIkkatubaraikaisuu)) {

            keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
        }
        else {

            keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        }

        keisanIkkatuNyuukinGkBean.setRstuukasyu(teikiikkatutkbripType);

        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.BLNK);

        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.BLNK);

        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(null);

        keisanIkkatuNyuukinGkBean.setJyutoustartYm(null);

        C_ErrorKbn errorKbn = keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean, false);

        if (!C_ErrorKbn.OK.eq(errorKbn)) {

            logger.debug("△ 定期一括払月払Ｐ→定期一括払Ｐ計算（円・メッセージ勧奨用）　終了");

            return teikiikkatup;
        }

        BizCurrency iktnyknkgk = keisanTukiIkkatuNyuukinGk.getIktnyknkgk();

        if (iktnyknkgk == null
            || iktnyknkgk.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) <= 0) {

            logger.debug("△ 定期一括払月払Ｐ→定期一括払Ｐ計算（円・メッセージ勧奨用）　終了");

            return teikiikkatup;
        }

        if (pMaxkngkkansflg) {

            teikiikkatup = iktnyknkgk.round(pIkkatupsiteitaniskru, RoundingMode.DOWN);
        }
        else {

            teikiikkatup = iktnyknkgk.round(pIkkatupsiteitaniskru, RoundingMode.UP);
        }

        logger.debug("△ 定期一括払月払Ｐ→定期一括払Ｐ計算（円・メッセージ勧奨用）　終了");

        return teikiikkatup;
    }

    public BizCurrency getHaraikomiPTanni(
        String pSyusyouhncd,
        Integer pSyusyouhnsdno,
        C_Hrkkaisuu pHrkkaisuu,
        C_Channelcd pKiteichkchannelcd,
        String pKiteichkoyadrtencd,
        C_Tuukasyu pTuukasyu) {

        logger.debug("▽ 払込Ｐ単位取得　開始");

        BizCurrency hrkptani = null;

        if (pTuukasyu == null || C_Tuukasyu.BLNK.eq(pTuukasyu)) {

            hrkptani = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }
        else {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pTuukasyu);

            hrkptani = BizCurrency.valueOf(0, currencyType);
        }

        if (BizUtil.isBlank(pSyusyouhncd)) {

            logger.debug("△ 払込Ｐ単位取得　終了");

            return hrkptani;
        }

        if (pSyusyouhnsdno == null || pSyusyouhnsdno <= 0) {

            logger.debug("△ 払込Ｐ単位取得　終了");

            return hrkptani;
        }

        if (pHrkkaisuu == null) {

            logger.debug("△ 払込Ｐ単位取得　終了");

            return hrkptani;
        }

        if (pTuukasyu == null || C_Tuukasyu.BLNK.eq(pTuukasyu)) {

            logger.debug("△ 払込Ｐ単位取得　終了");

            return hrkptani;
        }

        ConvertChannelcd convertChannelcd = SWAKInjector.getInstance(ConvertChannelcd.class);

        C_Channelcd kiteiChkChannelCd = convertChannelcd.exec(pKiteichkchannelcd, pKiteichkoyadrtencd);

        if (kiteiChkChannelCd == null || C_Channelcd.BLNK.eq(kiteiChkChannelCd)) {

            logger.debug("△ 払込Ｐ単位取得　終了");

            return hrkptani;
        }

        List<BM_ChkHrkPTani> chkHrkPTaniList = bizDomManager.getChkHrkPTanisByPK(
            pSyusyouhncd,
            pHrkkaisuu,
            pSyusyouhnsdno,
            kiteiChkChannelCd,
            pTuukasyu);

        if (chkHrkPTaniList == null || chkHrkPTaniList.size() <= 0) {

            logger.debug("△ 払込Ｐ単位取得　終了");

            return hrkptani;
        }

        hrkptani = chkHrkPTaniList.get(0).getHrkptani();

        logger.debug("△ 払込Ｐ単位取得　終了");

        return hrkptani;
    }

    public BizCurrency getInRangeNenbaraiPSpecifiedZennouP(
        BizDate pKijyunymd,
        String pSyusyouhncd,
        Integer pSyusyouhnsdno,
        String pSyuryouritusdno,
        boolean pHrkptanityouseiflg,
        C_Channelcd pKiteichkchannelcd,
        String pKiteichkoyadrtencd,
        Integer pZnnkaisyonendo,
        BizCurrency pZennoupsyonendo) {

        logger.debug("▽ 指定額範囲内年払相当Ｐ算出（前納Ｐ指定）　開始");

        BizCurrency jyuutoup = null;

        CurrencyType currencyType = null;

        if (pZennoupsyonendo == null || pZennoupsyonendo.isOptional()) {

            currencyType = BizCurrencyTypes.YEN;

            jyuutoup = BizCurrency.valueOf(0, currencyType);
        }
        else {

            currencyType = pZennoupsyonendo.getType();

            jyuutoup = BizCurrency.valueOf(0, currencyType);
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(currencyType);


        if (pKijyunymd == null) {

            logger.debug("△ 指定額範囲内年払相当Ｐ算出（前納Ｐ指定）　終了");

            return jyuutoup;

        }

        if (!pKijyunymd.isRekijyou()) {

            logger.debug("△ 指定額範囲内年払相当Ｐ算出（前納Ｐ指定）　終了");

            return jyuutoup;

        }

        if (BizUtil.isBlank(pSyusyouhncd)) {

            logger.debug("△ 指定額範囲内年払相当Ｐ算出（前納Ｐ指定）　終了");

            return jyuutoup;
        }

        if (pSyusyouhnsdno == null || pSyusyouhnsdno <= 0) {

            logger.debug("△ 指定額範囲内年払相当Ｐ算出（前納Ｐ指定）　終了");

            return jyuutoup;
        }

        if (BizUtil.isBlank(pSyuryouritusdno)) {

            logger.debug("△ 指定額範囲内年払相当Ｐ算出（前納Ｐ指定）　終了");

            return jyuutoup;
        }

        if (pZnnkaisyonendo == null || pZnnkaisyonendo <= 1) {

            logger.debug("△ 指定額範囲内年払相当Ｐ算出（前納Ｐ指定）　終了");

            return jyuutoup;
        }

        if (pZennoupsyonendo == null || pZennoupsyonendo.isOptional()
            || pZennoupsyonendo.compareTo(BizCurrency.valueOf(0, currencyType)) <= 0) {

            logger.debug("△ 指定額範囲内年払相当Ｐ算出（前納Ｐ指定）　終了");

            return jyuutoup;
        }

        BizCurrency sisanjyuutoup = getNenbaraiPFromZennouP(
            pKijyunymd,
            pZnnkaisyonendo,
            pZennoupsyonendo);

        if (sisanjyuutoup.compareTo(BizCurrency.valueOf(0, currencyType)) <= 0) {

            logger.debug("△ 指定額範囲内年払相当Ｐ算出（前納Ｐ指定）　終了");

            return jyuutoup;
        }


        if (!pHrkptanityouseiflg) {

            jyuutoup = sisanjyuutoup;

            logger.debug("△ 指定額範囲内年払相当Ｐ算出（前納Ｐ指定）　終了");

            return jyuutoup;
        }

        BizCurrency hrkptani = getHaraikomiPTanni(
            pSyusyouhncd,
            pSyusyouhnsdno,
            C_Hrkkaisuu.NEN,
            pKiteichkchannelcd,
            pKiteichkoyadrtencd,
            tuukasyu);

        if (hrkptani.compareTo(BizCurrency.valueOf(0, currencyType)) <= 0) {

            logger.debug("△ 指定額範囲内年払相当Ｐ算出（前納Ｐ指定）　終了");

            return jyuutoup;
        }

        BizCurrency tyouseigoGk = roundDownHaraikomiPTanni(
            sisanjyuutoup,
            hrkptani);

        if (tyouseigoGk.compareTo(BizCurrency.valueOf(0, currencyType)) <= 0) {

            logger.debug("△ 指定額範囲内年払相当Ｐ算出（前納Ｐ指定）　終了");

            return jyuutoup;
        }

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(0, currencyType);
        BizCurrency jyuutoupTemp = tyouseigoGk;

        do {

            jyuutoupTemp = jyuutoupTemp.add(hrkptani);

            zennoupsyonendo = getZennouPFromNenbaraiPforMsg(
                true,
                pSyusyouhncd,
                pSyusyouhnsdno,
                pSyuryouritusdno,
                pKijyunymd,
                jyuutoupTemp,
                hrkptani,
                pZnnkaisyonendo,
                0);

            if (zennoupsyonendo.compareTo(BizCurrency.valueOf(0, currencyType)) <= 0) {

                logger.debug("△ 指定額範囲内年払相当Ｐ算出（前納Ｐ指定）　終了");

                return jyuutoup;
            }
        }
        while (zennoupsyonendo.compareTo(pZennoupsyonendo) <= 0);

        jyuutoup = jyuutoupTemp.subtract(hrkptani);

        logger.debug("△ 指定額範囲内年払相当Ｐ算出（前納Ｐ指定）　終了");

        return jyuutoup;
    }

    public BizCurrency getZennouPFromNenbaraiPforMsg(
        boolean pMaxkngkkansflg,
        String pSyusyouhncd,
        Integer pSyusyouhnsdno,
        String pSyuryouritusdno,
        BizDate pKijyunymd,
        BizCurrency pKijyunymdnjyuutoup,
        BizCurrency pHrkptani,
        Integer pZnnkaisyonendo,
        int pZennoupsiteitaniskru) {

        logger.debug("▽ 年払相当Ｐ→前納Ｐ計算（メッセージ勧奨用）　開始");

        BizCurrency zennoupsyonendo = null;

        CurrencyType currencyType = null;

        if (pKijyunymdnjyuutoup == null || pKijyunymdnjyuutoup.isOptional()) {

            currencyType = BizCurrencyTypes.YEN;

            zennoupsyonendo = BizCurrency.valueOf(0, currencyType);
        }
        else {

            currencyType = pKijyunymdnjyuutoup.getType();

            zennoupsyonendo = BizCurrency.valueOf(0, currencyType);
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(currencyType);


        if (BizUtil.isBlank(pSyusyouhncd)) {

            logger.debug("△ 年払相当Ｐ→前納Ｐ計算（メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        if (pSyusyouhnsdno == null || pSyusyouhnsdno <= 0) {

            logger.debug("△ 年払相当Ｐ→前納Ｐ計算（メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        if (BizUtil.isBlank(pSyuryouritusdno)) {

            logger.debug("△ 年払相当Ｐ→前納Ｐ計算（メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        if (pKijyunymd == null) {

            logger.debug("△ 年払相当Ｐ→前納Ｐ計算（メッセージ勧奨用）　終了");

            return zennoupsyonendo;

        }

        if (!pKijyunymd.isRekijyou()) {

            logger.debug("△ 年払相当Ｐ→前納Ｐ計算（メッセージ勧奨用）　終了");

            return zennoupsyonendo;

        }

        if (pKijyunymdnjyuutoup == null || pKijyunymdnjyuutoup.isOptional()
            || pKijyunymdnjyuutoup.compareTo(BizCurrency.valueOf(0, currencyType)) <= 0) {

            logger.debug("△ 年払相当Ｐ→前納Ｐ計算（メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        if (pHrkptani == null || pHrkptani.isOptional()
            || pHrkptani.compareTo(BizCurrency.valueOf(0, currencyType)) <= 0) {

            logger.debug("△ 年払相当Ｐ→前納Ｐ計算（メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        if (pZnnkaisyonendo == null || pZnnkaisyonendo <= 1) {

            logger.debug("△ 年払相当Ｐ→前納Ｐ計算（メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }


        BizCurrency kijyunymdnjyuutouptyousei = null;

        if (pMaxkngkkansflg && pZennoupsiteitaniskru != 0) {

            kijyunymdnjyuutouptyousei = pKijyunymdnjyuutoup.add(pHrkptani);
        }
        else {

            kijyunymdnjyuutouptyousei = pKijyunymdnjyuutoup;
        }

        KeisanZennouNyuukinGk2 keisanZennouNyuukinGk2 = SWAKInjector.getInstance(KeisanZennouNyuukinGk2.class);

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk2.execKeisanSinkeiyakuDoujiZennouNyuukinGk(
            pKijyunymd,
            kijyunymdnjyuutouptyousei,
            pZnnkaisyonendo - 1,
            C_Tuukasyu.BLNK,
            null,
            null);

        if (!C_ErrorKbn.OK.eq(errorKbn)) {

            logger.debug("△ 年払相当Ｐ→前納Ｐ計算（メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        BizCurrency zennouNyuukinGk = keisanZennouNyuukinGk2.getZennouNyuukinGk();

        if (zennouNyuukinGk == null
            || zennouNyuukinGk.compareTo(BizCurrency.valueOf(0, currencyType)) <= 0) {

            logger.debug("△ 年払相当Ｐ→前納Ｐ計算（メッセージ勧奨用）　終了");

            return zennoupsyonendo;
        }

        if (pMaxkngkkansflg) {

            zennoupsyonendo = zennouNyuukinGk.round(pZennoupsiteitaniskru, RoundingMode.DOWN);
        }
        else {

            zennoupsyonendo = zennouNyuukinGk.round(pZennoupsiteitaniskru, RoundingMode.UP);
        }

        logger.debug("△ 年払相当Ｐ→前納Ｐ計算（メッセージ勧奨用）　終了");

        return zennoupsyonendo;
    }

    private BizCurrency roundDownHaraikomiPTanni(
        BizCurrency pSisantkbrip,
        BizCurrency pTkbrihrkptani) {

        BizCurrency tyouseigoGk = pTkbrihrkptani.multiply(
            pSisantkbrip.divideBizCurrency(
                pTkbrihrkptani,
                0,
                RoundingMode.DOWN));

        return tyouseigoGk;
    }

    private BizCurrency getNenbaraiPFromZennouP(
        BizDate pKijyunymd,
        Integer pZnnkaisyonendo,
        BizCurrency pZennoupsyonendo) {


        BizCurrency sisanjyuutoup;

        CurrencyType currencyType;

        if (pZennoupsyonendo == null || pZennoupsyonendo.isOptional()) {

            currencyType = BizCurrencyTypes.YEN;
            sisanjyuutoup = BizCurrency.valueOf(0, currencyType);

            return sisanjyuutoup;
        }

        currencyType = pZennoupsyonendo.getType();
        sisanjyuutoup = BizCurrency.valueOf(0, currencyType);

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        C_Tuukasyu tuukaSyu = henkanTuuka.henkanTuukaTypeToKbn(currencyType);

        List<BM_ZennouGenkaRitu2> zennouGenkaRituList = sKZennouIkkatuUtilDao.getZennouGenkaRitu2(
            tuukaSyu,
            pZnnkaisyonendo - 1,
            pKijyunymd);

        if (zennouGenkaRituList == null || zennouGenkaRituList.size() == 0) {

            return sisanjyuutoup;
        }

        sisanjyuutoup = pZennoupsyonendo.divide(
            zennouGenkaRituList.get(0).getZennougenkaritu().add(BizNumber.ONE),
            0,
            RoundingMode.DOWN);

        return sisanjyuutoup;
    }

    private BizCurrency getTukibaraiPFromIkkatuPYen(
        String pSyusyouhncd,
        String pSyusyouhnsdno,
        C_IkkatubaraiKaisuuKbn pIkkatubaraiKaisuuKbn,
        BizCurrency pSisanjyuutoup) {

        BizCurrency sisantkbrip = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        Integer ikkatubaraiKaisuu = Integer.valueOf(pIkkatubaraiKaisuuKbn.getValue());

        BM_IkkatuKeisuu ikkatuKeisuu = sKZennouIkkatuUtilDao.getIkkatuKeisuu(
            pSyusyouhncd,
            pSyusyouhnsdno,
            BizNumber.ZERO,
            0,
            ikkatubaraiKaisuu);

        if (ikkatuKeisuu == null) {

            return sisantkbrip;
        }

        sisantkbrip = pSisanjyuutoup.divide(
            BizNumber.valueOf(ikkatubaraiKaisuu).subtract(ikkatuKeisuu.getIktkeisuu()),
            0,
            RoundingMode.DOWN);

        return sisantkbrip;
    }
}