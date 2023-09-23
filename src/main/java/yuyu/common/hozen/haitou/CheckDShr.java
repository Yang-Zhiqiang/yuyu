package yuyu.common.hozen.haitou;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 配当 配当支払チェック
 */
public class CheckDShr extends BaseDCommon{

    private C_UmuKbn dHaneiYmdUmu;

    private C_UmuKbn dShrYmdUmu;

    @Inject
    private static Logger logger;

    {
        regErrorInfo("001", "入力エラー", "必須の入力項目にnullが含まれる");
    }

    public CheckDShr() {
        super();
    }

    public C_ErrorKbn checkExistsDHaneiYmd(String pSyono, BizDate pCalcKijyunYmd) {

        logger.debug("▽ 配当金反映日存在チェック 開始");
        clear();
        dHaneiYmdUmu = null;
        C_ErrorKbn errorKbn = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) ||  pCalcKijyunYmd == null) {

                errorKbn =  C_ErrorKbn.ERROR;

                setErrorInfo("001");

                logger.debug("△ 配当金反映日存在チェック 終了");

                return errorKbn;
            }


            DBAccessDCommon dBAccessDCommon = getInjectInstance(DBAccessDCommon.class);

            dBAccessDCommon.getCountKijyunymdGoHaitouKnari(pSyono, pCalcKijyunYmd);

            if (dBAccessDCommon.getKhHaitouKanriCount() > 0) {

                dHaneiYmdUmu = C_UmuKbn.ARI;
            }
            else {
                dHaneiYmdUmu = C_UmuKbn.NONE;
            }

            errorKbn = C_ErrorKbn.OK;

            logger.debug("△ 配当金反映日存在チェック 終了");

            return errorKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn checkExistsDShrYmd(String pSyono, BizDate pCalcKijyunYmd) {

        logger.debug("▽ 配当金支払日存在チェック 開始");
        clear();
        dShrYmdUmu = null;
        C_ErrorKbn errorKbn = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) ||  pCalcKijyunYmd == null) {

                errorKbn =  C_ErrorKbn.ERROR;

                setErrorInfo("001");

                logger.debug("△ 配当金支払日存在チェック 終了");

                return errorKbn;
            }

            DBAccessDCommon dBAccessDCommon = getInjectInstance(DBAccessDCommon.class);
            C_TumitateDSakuseiKbn[] tumitateDSakuseiKbns = {C_TumitateDSakuseiKbn.ITIBUHIKIDASI, C_TumitateDSakuseiKbn.ZENHIKIDASI};

            dBAccessDCommon.getCountKijyunymdGoTumitateDKanriTumitatedskskbn(pSyono, tumitateDSakuseiKbns, pCalcKijyunYmd);

            if (dBAccessDCommon.getKhTumitateDKanriCount() > 0) {

                dShrYmdUmu = C_UmuKbn.ARI;
            }
            else {
                dShrYmdUmu = C_UmuKbn.NONE;
            }

            errorKbn = C_ErrorKbn.OK;

            logger.debug("△ 配当金支払日存在チェック 終了");

            return errorKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_UmuKbn getDHaneiYmdUmu() {

        return dHaneiYmdUmu;
    }

    public C_UmuKbn getDShrYmdUmu() {

        return dShrYmdUmu;
    }

    protected void initCheckDShr() {
        dHaneiYmdUmu = null;
        dShrYmdUmu = null;
    }
}
