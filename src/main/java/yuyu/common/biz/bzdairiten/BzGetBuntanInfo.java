package yuyu.common.biz.bzdairiten;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_DrtsyouhincdHrkkaisuu;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.db.entity.BT_BuntanInfo;

/**
 * 業務共通 代理店 分担情報取得クラス
 */
public class BzGetBuntanInfo {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    private C_ErrorKbn errorKbn = C_ErrorKbn.OK;

    private BizNumber tesuuryouBuntanWariaiJibun = BizNumber.valueOf(0);

    private BizNumber tesuuryouBuntanWariaiAite = BizNumber.valueOf(0);

    public BzGetBuntanInfo() {
        super();
    }

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public BizNumber getTesuuryouBuntanWariaiJibun() {
        return tesuuryouBuntanWariaiJibun;
    }

    public BizNumber getTesuuryouBuntanWariaiAite() {
        return tesuuryouBuntanWariaiAite;
    }

    public void exec(String pDrtenCd, String pTesuuryouBuntanDrtenCd, BizDateYM pKijyunYm,
            C_DrtSyouhinSikibetuKbn pDrtSyouhinSikibetuKbn, C_Hrkkaisuu pHrkkaisuu, C_DiritenplannmKbn pDiritenplannmKbn) {

        logger.debug("▽ 分担情報取得 開始");

        if (BizUtil.isBlank(pDrtenCd) ||
                BizUtil.isBlank(pTesuuryouBuntanDrtenCd) ||
                pKijyunYm == null ||
                pDrtSyouhinSikibetuKbn == null ||
                pHrkkaisuu == null ||
                pDiritenplannmKbn == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 分担情報取得 終了");

            return;

        }
        C_DrtsyouhincdHrkkaisuu Hrkhou = C_DrtsyouhincdHrkkaisuu.BLNK;
        if (C_Hrkkaisuu.TUKI.eq(pHrkkaisuu) || C_Hrkkaisuu.HALFY.eq(pHrkkaisuu) || C_Hrkkaisuu.NEN.eq(pHrkkaisuu)) {

            Hrkhou = C_DrtsyouhincdHrkkaisuu.HEIJYUN;

        }
        else if (C_Hrkkaisuu.ITIJI.eq(pHrkkaisuu)) {

            Hrkhou = C_DrtsyouhincdHrkkaisuu.ITIJI;

        }
        else {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 分担情報取得 終了");

            return;
        }

        String dairitenSyouhinCd = pDrtSyouhinSikibetuKbn.getValue().concat(Hrkhou.getValue())
                .concat(pDiritenplannmKbn.getValue());

        List<BT_BuntanInfo> buntanInfoLst = bizDomManager.getBuntanInfosByPK(pDrtenCd, dairitenSyouhinCd,
                pTesuuryouBuntanDrtenCd, pKijyunYm);

        if (buntanInfoLst.size() != 1) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 分担情報取得 終了");

            return;
        }
        if (buntanInfoLst.get(0).getTesuuryoubuntanwariai()  == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 分担情報取得 終了");

            return;
        }
        tesuuryouBuntanWariaiJibun = buntanInfoLst.get(0).getTesuuryoubuntanwariai();

        tesuuryouBuntanWariaiAite = BizNumber.valueOf(100).subtract(buntanInfoLst.get(0).getTesuuryoubuntanwariai());

        errorKbn = C_ErrorKbn.OK;

        logger.debug("△ 分担情報取得 終了");

        return;

    }

    public List<BT_BuntanInfo> execBuntanaiteSiteinasi(String pDrtenCd, BizDateYM pKijyunYm,
            C_DrtSyouhinSikibetuKbn pDrtSyouhinSikibetuKbn, C_Hrkkaisuu pHrkkaisuu, C_DiritenplannmKbn pDiritenplannmKbn) {

        logger.debug("▽ 分担情報取得 開始");

        List<BT_BuntanInfo> buntanInfoLst = new ArrayList<BT_BuntanInfo>();

        if (BizUtil.isBlank(pDrtenCd) ||
                pKijyunYm == null ||
                pDrtSyouhinSikibetuKbn == null ||
                pHrkkaisuu == null ||
                pDiritenplannmKbn == null) {

            logger.debug("△ 分担情報取得 終了");

            return buntanInfoLst;

        }
        C_DrtsyouhincdHrkkaisuu Hrkhou = C_DrtsyouhincdHrkkaisuu.BLNK;
        if (C_Hrkkaisuu.TUKI.eq(pHrkkaisuu) || C_Hrkkaisuu.HALFY.eq(pHrkkaisuu) || C_Hrkkaisuu.NEN.eq(pHrkkaisuu)) {

            Hrkhou = C_DrtsyouhincdHrkkaisuu.HEIJYUN;

        }
        else if (C_Hrkkaisuu.ITIJI.eq(pHrkkaisuu)) {

            Hrkhou = C_DrtsyouhincdHrkkaisuu.ITIJI;

        }
        else {

            logger.debug("△ 分担情報取得 終了");

            return buntanInfoLst;
        }

        String dairitenSyouhinCd = pDrtSyouhinSikibetuKbn.getValue().concat(Hrkhou.getValue())
                .concat(pDiritenplannmKbn.getValue());

        buntanInfoLst = bizDomManager.getBuntanInfosAitedrtenSiteinasi(pDrtenCd, dairitenSyouhinCd, pKijyunYm);

        logger.debug("△ 分担情報取得 終了");

        return buntanInfoLst;

    }
}
