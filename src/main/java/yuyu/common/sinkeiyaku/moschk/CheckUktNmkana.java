package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Uketorinin;

/**
 * 新契約 申込内容チェック 受取人名（カナ）チェック
 */
public class CheckUktNmkana {

    @Inject
    private static Logger logger;

    @Inject
    private CheckSimeiKana checkSimeiKana;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckUktNmkana() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 受取人名（カナ）チェック 開始");
        }

        String mosNo = pMp.getDataSyoriControl().getMosno();

        checkKana(mosNo, C_UktsyuKbn.SBUKT, ICommonKoumoku.DISP_S_SBUKTNMKN, pMp);

        checkKana(mosNo, C_UktsyuKbn.STDRSK, ICommonKoumoku.DISP_S_SITEIDAIRINMKN, pMp);

        if (logger.isDebugEnabled()) {
            logger.debug("△ 受取人名（カナ）チェック 終了");
        }
    }

    private void checkKana(String pMosNo, C_UktsyuKbn pUktSyuKbn,
        String pHubiMsg, MosnaiCheckParam pMp) {

        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorininsByUktsyukbn(pUktSyuKbn);

        if (uketorininLst == null || uketorininLst.size() == 0) {
            return;
        }

        String uktNmKn = uketorininLst.get(0).getUktnmkn();

        boolean kanaChk = true;

        if (!BizUtil.isBlank(uktNmKn)) {
            kanaChk = CheckMeigininNmKana.isCheckOK(uktNmKn, C_Kojinhjn.KOJIN);
        }

        if (kanaChk) {
            checkSimeiKana.exec(pMp, uktNmKn, pHubiMsg);
        }
        else {
            setHubiMsg(pMp, pHubiMsg);
        }
    }

    private void setHubiMsg(MosnaiCheckParam pMp, String pMessage) {

        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
            makeMsg(MessageId.EBC0046, MessageId.EBC0046, pMessage), pMp);
    }

    private String makeMsg(String pInMessageID, String pMsgID, String pReplaceMsg1) {
        StringBuffer ret = new StringBuffer();

        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg1));

        return ret.toString();
    }
}
