package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkHrkPTani;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 契約保全 契約保全共通 Ｐ単位チェック
 */
public class CheckPTani {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    private ArrayList<String> warningMessageIDList = new ArrayList<>();

    private ArrayList<String> warningMessageList = new ArrayList<>();

    public CheckPTani() {
        super();
    }

    public boolean exec (String pSyouhnCd, C_Hrkkaisuu pHrkKaisuu, Integer pSyouhnsdno, C_Channelcd pChannelcd,
        C_Tuukasyu pHrktuukasyu, BM_SyouhnZokusei pSyouhnZokusei, BizCurrency pHntiP) {

        logger.debug("▽ Ｐ単位チェック 開始");

        boolean warningUmuFlg = true;

        List<BM_ChkHrkPTani> chkHrkPTaniList = bizDomManager.getChkHrkPTanisByPK(pSyouhnCd,
            pHrkKaisuu,
            pSyouhnsdno,
            pChannelcd,
            pHrktuukasyu);

        if (chkHrkPTaniList.size() == 0) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIC1005, "払込Ｐ単位チェックマスタ"));
        }

        BizCurrency hrkptani = chkHrkPTaniList.get(0).getHrkptani();

        BizCurrency hntiP = hrkptani.multiply(pHntiP.divideBizCurrency(hrkptani, 0, RoundingMode.HALF_UP));

        if (pHntiP.compareTo(hntiP) != 0) {
            throw new BizLogicException(MessageId.EIC1008,
                pSyouhnZokusei.getSyouhnnm(), "払込保険料", ViewReport.editCommaTuuka(hrkptani, BizUtil.ZERO_FILL));
        }

        if (warningMessageIDList.size() > 0) {

            warningUmuFlg = false;

        }

        logger.debug("△ Ｐ単位チェック 終了");

        return warningUmuFlg;
    }

    public List<String> getWarningMsgIdList() {

        return warningMessageIDList;
    }

    public List<String> getWarningMsgList() {

        return warningMessageList;
    }
}
