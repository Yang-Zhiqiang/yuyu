package yuyu.common.biz.bzdairiten;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;

/**
 * 業務共通 代理店 通計用代理店分担割合取得クラス
 */
public class BzGetTuukeiBunwari {

    private final BizNumber bunWari_100 = BizNumber.valueOf(100);

    private final BizNumber bunWari_50 = BizNumber.valueOf(50);

    private final BizNumber bunWari_0 = BizNumber.ZERO;

    private C_ErrorKbn errorKbn = C_ErrorKbn.OK;

    private String drtenCd1 = "";

    private BizNumber buntanWariai1 = bunWari_0;

    private String drtenCd2 = "";

    private BizNumber buntanWariai2 = bunWari_0;

    @Inject
    private static Logger logger;

    public BzGetTuukeiBunwari() {
        super();
    }

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public String getDrtencd1() {
        return drtenCd1;
    }

    public BizNumber getBuntanWariai1() {
        return buntanWariai1;
    }

    public String getDrtencd2() {
        return drtenCd2;
    }

    public BizNumber getBuntanWariai2() {
        return buntanWariai2;
    }

    public void exec(String pDrtenCd1, String pOyaDrtenCd1, BizNumber pBuntanWariai1,
        String pDrtenCd2, String pOyaDrtenCd2, BizNumber pBuntanWariai2, BizDateYM pKijyunYm,
        C_DrtSyouhinSikibetuKbn pDrtSyouhinSikibetuKbn, C_Hrkkaisuu pHrkkaisuu, C_DiritenplannmKbn pDiritenplannmKbn) {

        logger.debug("▽ 通計用代理店分担割合取得 開始");

        if (pKijyunYm == null ||
            pDrtSyouhinSikibetuKbn == null ||
            pHrkkaisuu == null ||
            pDiritenplannmKbn == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 通計用代理店分担割合取得 終了");

            return;
        }
        else if (BizUtil.isBlank(pDrtenCd1)) {

            logger.debug("△ 通計用代理店分担割合取得 終了");

            return;
        }
        else if (BizUtil.isBlank(pDrtenCd2)) {

            drtenCd1 = pDrtenCd1;
            buntanWariai1 = pBuntanWariai1;
            drtenCd2 = "";
            buntanWariai2 = pBuntanWariai2;

            logger.debug("△ 通計用代理店分担割合取得 終了");

            return;
        }
        if (pDrtenCd1.equals(pDrtenCd2)) {

            drtenCd1 = pDrtenCd1;
            buntanWariai1 = bunWari_100;
            drtenCd2 = "";
            buntanWariai2 = bunWari_0;

            logger.debug("△ 通計用代理店分担割合取得 終了");

            return;

        }
        drtenCd1 = pDrtenCd1;
        drtenCd2 = pDrtenCd2;

        if (pBuntanWariai1.compareTo(BizNumber.valueOf(0)) > 0) {

            buntanWariai1 = pBuntanWariai1;
            buntanWariai2 = pBuntanWariai2;

            logger.debug("△ 通計用代理店分担割合取得 終了");

            return;
        }
        BzGetBuntanInfo bzGetBuntanInfo = SWAKInjector.getInstance(BzGetBuntanInfo.class);

        bzGetBuntanInfo.exec(pDrtenCd1,
            pOyaDrtenCd2,
            pKijyunYm,
            pDrtSyouhinSikibetuKbn,
            pHrkkaisuu,
            pDiritenplannmKbn);

        if (C_ErrorKbn.OK.eq(bzGetBuntanInfo.getErrorKbn())) {

            buntanWariai1 = bzGetBuntanInfo.getTesuuryouBuntanWariaiJibun();
            buntanWariai2 = bzGetBuntanInfo.getTesuuryouBuntanWariaiAite();

            logger.debug("△ 通計用代理店分担割合取得 終了");

            return;
        }
        bzGetBuntanInfo.exec(pOyaDrtenCd1,
            pOyaDrtenCd2,
            pKijyunYm,
            pDrtSyouhinSikibetuKbn,
            pHrkkaisuu,
            pDiritenplannmKbn);

        if (C_ErrorKbn.OK.eq(bzGetBuntanInfo.getErrorKbn())) {

            buntanWariai1 = bzGetBuntanInfo.getTesuuryouBuntanWariaiJibun();
            buntanWariai2 = bzGetBuntanInfo.getTesuuryouBuntanWariaiAite();

            logger.debug("△ 通計用代理店分担割合取得 終了");

            return;
        }
        buntanWariai1 = bunWari_50;
        buntanWariai2 = bunWari_50;

        logger.debug("△ 通計用代理店分担割合取得 終了");

        return;
    }
}
