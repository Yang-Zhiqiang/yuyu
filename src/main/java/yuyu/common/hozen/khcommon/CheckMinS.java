package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkJhSaiteiS;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 契約保全 契約保全共通 最低Ｓチェック
 */
public class CheckMinS {

    private final List<String> warningMsgIdLst = new ArrayList<>();

    private final List<String> warningMsgLst = new ArrayList<>();

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public CheckMinS() {
        super();
    }

    public List<String> getWarningMsgIdList() {
        return warningMsgIdLst;
    }

    public List<String> getWarningMsgList() {
        return warningMsgLst;
    }

    public boolean exec(String pSyouhncd, int pSyouhnsdno, C_HrkkknsmnKbn pHrkkknsmnKbn, int pHknkkn,
        C_Tuukasyu pTuukasyu, BM_SyouhnZokusei pSyouhnZokusei, BizCurrency pHanteiKihonHokenkngk) {

        logger.debug("▽ 最低Ｓチェック 開始");

        boolean warningUmuFlg = true;

        List<BM_ChkJhSaiteiS> chkJhSaiteiSLst =
            bizDomManager.getChkJhSaiteiSsByPk(pSyouhncd,
                pSyouhnsdno,
                Integer.parseInt(C_UmuKbn.NONE.getValue()),
                Integer.parseInt(C_UmuKbn.NONE.getValue()),
                Integer.parseInt(pHrkkknsmnKbn.getValue()),
                BizNumber.valueOf(pHknkkn),
                Integer.parseInt(C_UmuKbn.NONE.getValue()),
                Integer.parseInt(C_UmuKbn.NONE.getValue()),
                pTuukasyu);

        if (chkJhSaiteiSLst.size() == 0) {
            throw new CommonBizAppException("最低Ｓ事方書チェックマスタにデータが存在しません。");
        }

        if (chkJhSaiteiSLst.get(0).getSaiteis().compareTo(pHanteiKihonHokenkngk) > 0) {
            throw new BizLogicException(MessageId.EIC1007,
                pSyouhnZokusei.getSyouhnnm(),
                pSyouhnZokusei.getKihonssyuruikbn().getContent(C_KihonssyuruiKbn.PATTERN_CHECK),
                ViewReport.editCommaTuuka(chkJhSaiteiSLst.get(0).getSaiteis(), BizUtil.ZERO_FILL));
        }

        if (warningMsgIdLst.size() > 0) {
            warningUmuFlg = false;
        }

        logger.debug("△ 最低Ｓチェック 終了");

        return warningUmuFlg;
    }
}
