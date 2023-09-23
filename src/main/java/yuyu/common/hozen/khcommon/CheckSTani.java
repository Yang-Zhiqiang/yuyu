package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkSTani;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 契約保全 契約保全共通 Ｓ単位チェック

 */
public class CheckSTani {

    private ArrayList<String> warningMessageIDList = new ArrayList<>();

    private ArrayList<String> warningMessageList = new ArrayList<>();

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public CheckSTani() {
        super();
    }

    public boolean exec(String pSyouhncd, int pSyouhnsdno,
        int pHhknnen, C_Tuukasyu pTuukasyu, BM_SyouhnZokusei pSyouhnZokusei, BizCurrency pHanteiKihonHokenkngk) {

        logger.debug("▽ Ｓ単位チェック 開始");

        boolean warningUmuFlg = true;
        BizCurrency stani = BizCurrency.valueOf(0);

        List<BM_ChkSTani> chkSTaniLst = bizDomManager.getChkSTanisByPK(pSyouhncd, pSyouhnsdno,
            BizNumber.valueOf(pHhknnen), pTuukasyu);

        if (chkSTaniLst.size() == 0) {

            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIC1005, "Ｓ単位チェックマスタ"));

        }
        stani = chkSTaniLst.get(0).getStani();

        if (pHanteiKihonHokenkngk.compareTo(pHanteiKihonHokenkngk.divideCurrency(stani, 0
            , RoundingMode.HALF_UP).multiplyCurrency(stani)) != 0) {
            throw new BizLogicException(MessageId.EIC1008, pSyouhnZokusei.getSyouhnnm(),
                pSyouhnZokusei.getKihonssyuruikbn().getContent(C_KihonssyuruiKbn.PATTERN_CHECK),
                ViewReport.editCommaTuuka(stani, BizUtil.ZERO_FILL));
        }

        if (warningMessageIDList.size() > 0) {

            warningUmuFlg = false;

        }

        logger.debug("△ Ｓ単位チェック 終了");

        return warningUmuFlg;
    }

    public List<String> getWarningMsgIdList() {

        return warningMessageIDList;
    }

    public List<String> getWarningMsgList() {

        return warningMessageList;
    }

}