package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_BoskyuusiRiyuuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;

/**
 * {@link SetKisoKoumoku}のモッククラスです。<br />
 */
public class SetKisoKoumokuMockForSinkeiyaku extends SetKisoKoumoku{

    @Inject
    private static Logger logger;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMP) {

        if (caller == MosnaiCheckTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                if (logger.isDebugEnabled()) {
                    logger.debug("▽ 基礎項目設定 開始");
                    logger.debug("△ 基礎項目設定 終了");
                }
            }
            return;
        }
        else if (caller == SeihowebMosnaiCheckTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                logger.debug("▽ 基礎項目設定 開始");

                pMP.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

                logger.debug("△ 基礎項目設定 終了");
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                logger.debug("△ 基礎項目設定 終了");
                return;
            }
        }
        super.exec(pMP);
    }

    @Override
    public BizDate setkykymdHantei(HT_MosKihon pMosKihon, HT_MosSyouhn pMosSyouhn, BizDate pRsYmd,
        BizDate pMosYmd, BizDate pSknnKaisiYmd, BizDate pSyoriYmd, C_SysKbn pSysKbn, C_YoteikykymdKbn pYoteiKykymdKbn) {

        if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                BizDate kariKykkykymdMosymdKijyun = BizDate.valueOf(20180203);

                logger.debug("△ 基礎項目設定 終了");

                return kariKykkykymdMosymdKijyun;
            }

            else if (TESTPATTERN2.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                BizDate kariKykkykymdMosymdKijyun = BizDate.valueOf(20180303);

                logger.debug("△ 基礎項目設定 終了");

                return kariKykkykymdMosymdKijyun;
            }

            else if (TESTPATTERN3.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                BizDate kariKykkykymdMosymdKijyun = BizDate.valueOf(20180503);

                logger.debug("△ 基礎項目設定 終了");

                return kariKykkykymdMosymdKijyun;
            }
            else if (TESTPATTERN4.equals(SYORIPTN) || TESTPATTERN6.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160701)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdMosymdKijyun = BizDate.valueOf(20180503);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdMosymdKijyun;
                }
                else if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160907)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdSyoriymdKijyun = BizDate.valueOf(20180504);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdSyoriymdKijyun;
                }
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160701)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdMosymdKijyun = BizDate.valueOf(20180503);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdMosymdKijyun;
                }
                else if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160907)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdSyoriymdKijyun = BizDate.valueOf(20180503);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdSyoriymdKijyun;
                }
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160701)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdMosymdKijyun = BizDate.valueOf(20180502);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdMosymdKijyun;
                }
                else if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160907)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdSyoriymdKijyun = BizDate.valueOf(20180504);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdSyoriymdKijyun;
                }
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160701)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdMosymdKijyun = BizDate.valueOf(20180503);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdMosymdKijyun;
                }
                else if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160907)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdSyoriymdKijyun = BizDate.valueOf(20180505);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdSyoriymdKijyun;
                }
            }

            else if (TESTPATTERN9.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160701)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdMosymdKijyun = BizDate.valueOf(20180505);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdMosymdKijyun;
                }
                else if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160907)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdSyoriymdKijyun = BizDate.valueOf(20180504);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdSyoriymdKijyun;
                }
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160701)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdMosymdKijyun = BizDate.valueOf(20180503);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdMosymdKijyun;
                }
                else if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160907)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdSyoriymdKijyun = BizDate.valueOf(20170331);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdSyoriymdKijyun;
                }
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160701)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdMosymdKijyun = BizDate.valueOf(20180503);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdMosymdKijyun;
                }
                else if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160907)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdSyoriymdKijyun = BizDate.valueOf(20160331);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdSyoriymdKijyun;
                }
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160701)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdMosymdKijyun = BizDate.valueOf(20180503);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdMosymdKijyun;
                }
                else if (BizDateUtil.compareYmd(pMosYmd, BizDate.valueOf(20160907)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate kariKykkykymdSyoriymdKijyun = BizDate.valueOf(20171119);

                    logger.debug("△ 基礎項目設定 終了");

                    return kariKykkykymdSyoriymdKijyun;
                }
            }
        }
        return super.setkykymdHantei(pMosKihon, pMosSyouhn, pRsYmd, pMosYmd, pSknnKaisiYmd, pSyoriYmd, pSysKbn, pYoteiKykymdKbn);
    }

    @Override
    public BizDate getNextkykymd(HT_MosKihon pMosKihon, HT_MosSyouhn pSyuMosSyouhn, BizDate pKijyunYmd) {

        if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {

            if (TESTPATTERN4.equals(SYORIPTN) || TESTPATTERN5.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                if (BizDateUtil.compareYmd(pKijyunYmd, BizDate.valueOf(20180504)) == BizDateUtil.COMPARE_EQUAL
                    || BizDateUtil.compareYmd(pKijyunYmd, BizDate.valueOf(20180505)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate nextKykymd = BizDate.valueOf(20180505);

                    logger.debug("△ 基礎項目設定 終了");

                    return nextKykymd;
                }
                else if (BizDateUtil.compareYmd(pKijyunYmd, BizDate.valueOf(20160907)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate nextKykymd = BizDate.valueOf(20180605);

                    logger.debug("△ 基礎項目設定 終了");

                    return nextKykymd;
                }
            }

            else if (TESTPATTERN6.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");


                if (BizDateUtil.compareYmd(pKijyunYmd, BizDate.valueOf(20180505)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate nextKykymd = BizDate.valueOf(20180506);

                    logger.debug("△ 基礎項目設定 終了");

                    return nextKykymd;
                }
                else if (BizDateUtil.compareYmd(pKijyunYmd, BizDate.valueOf(20160907)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate nextKykymd = BizDate.valueOf(20180605);

                    logger.debug("△ 基礎項目設定 終了");

                    return nextKykymd;
                }
            }
            else if (TESTPATTERN10.equals(SYORIPTN) || TESTPATTERN11.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                if (BizDateUtil.compareYmd(pKijyunYmd, BizDate.valueOf(20160401)) == BizDateUtil.COMPARE_EQUAL
                    || BizDateUtil.compareYmd(pKijyunYmd, BizDate.valueOf(20170401)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate nextKykymd = BizDate.valueOf(20180331);

                    logger.debug("△ 基礎項目設定 終了");

                    return nextKykymd;
                }
                else if (BizDateUtil.compareYmd(pKijyunYmd, BizDate.valueOf(20160907)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate nextKykymd = BizDate.valueOf(20180605);

                    logger.debug("△ 基礎項目設定 終了");

                    return nextKykymd;
                }
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {

                logger.debug("▽ 基礎項目設定 開始");

                if (BizDateUtil.compareYmd(pKijyunYmd, BizDate.valueOf(20171120)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate nextKykymd = BizDate.valueOf(20180423);

                    logger.debug("△ 基礎項目設定 終了");

                    return nextKykymd;
                }
                else if (BizDateUtil.compareYmd(pKijyunYmd, BizDate.valueOf(20160907)) == BizDateUtil.COMPARE_EQUAL) {

                    BizDate nextKykymd = BizDate.valueOf(20180605);

                    logger.debug("△ 基礎項目設定 終了");

                    return nextKykymd;
                }
            }
        }
        return super.getNextkykymd(pMosKihon, pSyuMosSyouhn, pKijyunYmd);
    }

    @Override
    public C_ErrorKbn checkBosyuuKyuusi(MosnaiCheckParam pMP, String pSyouhncd, String pYoteiRiriTutkybr1
        , String pYoteiRiriTutkybr2, C_SkeijimuKbn pSkeijimuKbn, C_BoskyuusiRiyuuKbn pBoskyuusiRiyuuKbn){

        if (caller == CheckTblMosDairitenTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
        }

        return super.checkBosyuuKyuusi(pMP, pSyouhncd, pYoteiRiriTutkybr1, pYoteiRiriTutkybr2, pSkeijimuKbn, pBoskyuusiRiyuuKbn);
    }
}
