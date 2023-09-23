package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_MosKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkJhSaikouSSTani;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 契約保全 契約保全共通 最高ＳＳ単位チェック
 */
public class CheckMaxSStani {

    private final List<String> warningMsgIdLst = new ArrayList<>();

    private final List<String> warningMsgLst = new ArrayList<>();

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public CheckMaxSStani() {
        super();
    }

    public List<String> getWarningMsgIdList() {
        return warningMsgIdLst;
    }

    public List<String> getWarningMsgList() {
        return warningMsgLst;
    }

    public boolean exec(String pSyouhncd, int pSyouhnsdno, int pHhknnen, C_Tuukasyu pTuukasyu, BizDate pMosYmd,
        BM_SyouhnZokusei pSyouhnZokusei, BizCurrency pHanteiKihonHokenkngk, BizCurrency pHanteiItijibrp) {

        logger.debug("▽ 最高ＳＳ単位チェック 開始");

        boolean warningUmuFlg = true;

        GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);

        BizCurrency hanteiKihonHokenkngkYen = getKiteiCheckYenkansangk.exec(pMosYmd, pHanteiKihonHokenkngk, pTuukasyu);

        if (C_ErrorKbn.ERROR.eq(getKiteiCheckYenkansangk.getErrorKbn())) {
            throw new CommonBizAppException("基準判定用Ｓ計算処理でエラーが発生しました。");
        }

        List<BM_ChkJhSaikouSSTani> chkJhSaikouSSTaniLst =
            bizDomManager.getChkJhSaikouSSTanisByPk(pSyouhncd,
                pSyouhnsdno,
                BizNumber.valueOf(pHhknnen),
                Integer.parseInt(C_MosKbn.BLNK.getValue()),
                C_Tuukasyu.JPY);

        if (chkJhSaikouSSTaniLst.size() == 0) {
            throw new CommonBizAppException("最高ＳＳ単位チェックマスタ事方書にデータが存在しません。");
        }

        if (hanteiKihonHokenkngkYen.compareTo(chkJhSaikouSSTaniLst.get(0).getSaikous()) > 0) {
            throw new BizLogicException(MessageId.EIC0013,
                pSyouhnZokusei.getSyouhnnm(),
                pSyouhnZokusei.getKihonssyuruikbn().getContent(C_KihonssyuruiKbn.PATTERN_CHECK),
                ViewReport.editCommaTuuka(chkJhSaikouSSTaniLst.get(0).getSaikous(), BizUtil.ZERO_FILL));
        }

        if (warningMsgIdLst.size() > 0) {
            warningUmuFlg = false;
        }

        logger.debug("△ 最高ＳＳ単位チェック 終了");

        return warningUmuFlg;
    }
}
