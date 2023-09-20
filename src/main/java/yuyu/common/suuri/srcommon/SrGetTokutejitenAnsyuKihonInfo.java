package yuyu.common.suuri.srcommon;

import java.util.Iterator;
import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SeihowebIdouRireki;

/**
 * 数理 数理共通 特定時点案内収納基本情報取得
 */
public class SrGetTokutejitenAnsyuKihonInfo {

    @Inject
    private static Logger logger;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public SrGetTokutejitenAnsyuKihonInfo() {
        super();
    }

    public BizDateYM exec(String pSyono, BizDate pKijyunymd, BizDateYM pJkipjytym, String pHenkousikibetukey) {

        logger.debug("▽ 特定時点案内収納基本情報取得 開始");
        BizDateYM jkipjytym = pJkipjytym;

        if (pKijyunymd != null) {
            try (ExDBResults<IT_NyknJissekiRireki> nyknJissekiRirekiLst = srCommonKinouDao.getNyknJissekiRirekis(pSyono,
                pKijyunymd)) {
                Iterator<IT_NyknJissekiRireki> nyknJissekiRirekiIteratorLst = nyknJissekiRirekiLst.iterator();

                if (nyknJissekiRirekiIteratorLst.hasNext()) {
                    BizDateYM jkipjytymTemp = getJkipjytym(pSyono, nyknJissekiRirekiIteratorLst, pKijyunymd);

                    if (jkipjytymTemp != null) {
                        jkipjytym = jkipjytymTemp;
                    }
                }
            }
        }

        if (pHenkousikibetukey != null) {
            BizDateYM jkipjytymTemp = getJkipjytym(pSyono, pHenkousikibetukey);

            if (jkipjytymTemp != null) {
                jkipjytym = jkipjytymTemp;
            }
        }

        logger.debug("△ 特定時点案内収納基本情報取得 終了");

        return jkipjytym;
    }

    private BizDateYM getJkipjytym(String pSyono, Iterator<IT_NyknJissekiRireki> pNyknJissekiRirekiIterator,
        BizDate pKijyunYmd) {

        BizDateYM jkipjytym = null;
        Boolean nyuukihFlag = false;
        Boolean recordGetFlag = false;
        BizDateYM jyutouStartYm = null;
        BizDateYM jyutouEndYm = null;


        while (pNyknJissekiRirekiIterator.hasNext()) {
            IT_NyknJissekiRireki nyknJissekiRireki = pNyknJissekiRirekiIterator.next();
            if ((BizDateUtil.compareYmd(nyknJissekiRireki.getRyosyuymd(), pKijyunYmd) == BizDateUtil.COMPARE_EQUAL
                && nyknJissekiRireki.getNyktrksymd() == null)
                || (BizDateUtil.compareYmd(nyknJissekiRireki.getNyktrksymd(), pKijyunYmd) == BizDateUtil.COMPARE_EQUAL)) {
                break;
            }

            if (BizDateUtil.compareYmd(nyknJissekiRireki.getRyosyuymd(), pKijyunYmd) == BizDateUtil.COMPARE_GREATER
                && nyknJissekiRireki.getNyktrksymd() != null) {
                continue;
            }

            if (BizDateUtil.compareYmd(nyknJissekiRireki.getRyosyuymd(), pKijyunYmd) != BizDateUtil.COMPARE_GREATER
                && nyknJissekiRireki.getNyktrksymd() != null) {
                nyuukihFlag = false;
                recordGetFlag = true;
                jyutouEndYm = nyknJissekiRireki.getJyutouendym();
            }

            if (BizDateUtil.compareYmd(nyknJissekiRireki.getRyosyuymd(), pKijyunYmd) == BizDateUtil.COMPARE_GREATER
                && nyknJissekiRireki.getNyktrksymd() == null) {
                nyuukihFlag = true;
                recordGetFlag = true;
                jyutouStartYm = nyknJissekiRireki.getJyutoustartym();
            }
        }

        if (recordGetFlag == true) {
            if (nyuukihFlag == true) {
                jkipjytym = jyutouStartYm;
            }
            else {
                if (jyutouEndYm != null) {
                    jkipjytym = jyutouEndYm.addMonths(SrCommonConstants.KIKAN_1M);
                }
            }
        }

        return jkipjytym;
    }


    private BizDateYM getJkipjytym(String pSyono, String pHenkousikibetukey) {

        BizDateYM jkipjytym = null;

        IT_SeihowebIdouRireki seihowebIdouRireki = srCommonKinouDao.getSeihowebIdouRireki(pSyono, pHenkousikibetukey);

        if (seihowebIdouRireki != null) {
            jkipjytym = seihowebIdouRireki.getJkipjytym();
        }

        return jkipjytym;
    }
}
