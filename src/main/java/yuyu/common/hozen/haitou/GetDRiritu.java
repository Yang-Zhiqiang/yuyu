package yuyu.common.hozen.haitou;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.haitou.BaseDCommon;
import yuyu.common.hozen.haitou.dba4getdriritu.GetDRirituDao;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.BM_HaitouRiritu;

/**
 * 契約保全 配当 配当利率取得クラス
 */
public class GetDRiritu extends BaseDCommon {

    private BizNumber dRiritu;

    @Inject
    private static Logger logger;

    @Inject
    private GetDRirituDao getDRirituDao;

    {
        regErrorInfo("001", "入力値エラー", "計算基準日自 ＞ 計算基準日至");
        regErrorInfo("002", "入力値エラー", "計算基準日至 ＞ 計算基準日自 ＋ 1年");
        regErrorInfo("003", "配当利率マスタ取得エラー", "取得件数０件");
        regErrorInfo("004", "配当利率マスタ取得エラー", "計算基準日自 ＜ 配当利率マスタで最小の基準日（自）");
    }

    public GetDRiritu() {
        super();
    }

    public C_ErrorKbn exec(BizDate pCalcKijyunFromYmd, BizDate pCalcKijyunToYmd) {

        logger.debug("▽ 配当利率取得 開始");

        clear();

        dRiritu = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (pCalcKijyunFromYmd.compareTo(pCalcKijyunToYmd) > 0) {
                setErrorInfo("001");
                logger.debug("△ 配当利率取得 終了");
                return C_ErrorKbn.ERROR;
            }

            if (pCalcKijyunFromYmd.compareTo(pCalcKijyunToYmd.addYears(-1).getRekijyou()) < 0) {
                setErrorInfo("002");
                logger.debug("△ 配当利率取得 終了");
                return C_ErrorKbn.ERROR;
            }

            if (pCalcKijyunFromYmd.equals(pCalcKijyunToYmd)) {
                dRiritu = BizNumber.ZERO;
                logger.debug("△ 配当利率取得 終了");
                return C_ErrorKbn.OK;
            }

            BizDate calcKijyunToYmdPrevDay = pCalcKijyunToYmd.addDays(-1);

            List<BM_HaitouRiritu> dRirituList = getCopyBMHaitouRirituList(pCalcKijyunFromYmd, calcKijyunToYmdPrevDay);

            if (dRirituList.size() == 0) {
                setErrorInfo("003");
                logger.debug("△ 配当利率取得 終了");
                return C_ErrorKbn.ERROR;
            }

            if (pCalcKijyunFromYmd.compareTo(dRirituList.get(0).getKijyunfromymd()) < 0) {
                setErrorInfo("004");
                logger.debug("△ 配当利率取得 終了");
                return C_ErrorKbn.ERROR;
            }

            BizNumber ruikeiDRiritu = BizNumber.ZERO;
            BizNumber maxRiritu = BizNumber.ZERO;
            dRirituList.get(0).setKijyunfromymd(pCalcKijyunFromYmd);
            dRirituList.get(dRirituList.size() - 1).setKijyuntoymd(calcKijyunToYmdPrevDay);

            for (BM_HaitouRiritu dRirituEntity : dRirituList) {

                if (maxRiritu.compareTo(dRirituEntity.getHaitouriritu()) < 0) {
                    maxRiritu = dRirituEntity.getHaitouriritu();
                }

                int keikaNissuu = BizDateUtil.calcDifferenceDays(dRirituEntity.getKijyunfromymd(),
                    dRirituEntity.getKijyuntoymd()) + 1;

                ruikeiDRiritu = ruikeiDRiritu.add(dRirituEntity.getHaitouriritu().multiply(keikaNissuu));

                if (logger.isDebugEnabled()) {
                    logger.debug("｜▽ 配当利率情報");
                    logger.debug("｜｜ 配当利率：" + dRirituEntity.getHaitouriritu());
                    logger.debug("｜｜ 基準日（自）：" + dRirituEntity.getKijyunfromymd());
                    logger.debug("｜｜ 基準日（至）：" + dRirituEntity.getKijyuntoymd());
                    logger.debug("｜｜ 経過日数：" + keikaNissuu);
                    logger.debug("｜△");
                }
            }

            dRiritu = ruikeiDRiritu.divide(365, 10, RoundingMode.DOWN);

            if (maxRiritu.compareTo(dRiritu) < 0) {
                dRiritu = maxRiritu;
            }

            logger.debug("△ 配当利率取得 終了");

            return C_ErrorKbn.OK;
        } finally {
            collectEntity(collectEntityFlg);
        }
    }

    private List<BM_HaitouRiritu> getCopyBMHaitouRirituList(BizDate pCalcKijyunFromYmd, BizDate pCalcKijyunToYmd) {

        List<BM_HaitouRiritu> dRirituList = getDRirituDao.getHaitouRirituByPK(pCalcKijyunFromYmd, pCalcKijyunToYmd);

        List<BM_HaitouRiritu> dRirituCopyList = new ArrayList<BM_HaitouRiritu>();

        for (BM_HaitouRiritu dRirituEntity : dRirituList) {
            BM_HaitouRiritu dRirituCopyEntity = new BM_HaitouRiritu(dRirituEntity.getKijyunfromymd(),
                dRirituEntity.getKijyuntoymd());

            dRirituCopyEntity.setHaitouriritu(dRirituEntity.getHaitouriritu());
            dRirituCopyList.add(dRirituCopyEntity);
        }

        return dRirituCopyList;
    }

    public BizNumber getDRiritu() {

        return dRiritu;
    }

}
