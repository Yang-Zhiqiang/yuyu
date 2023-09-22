package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;

/**
 * 新契約 申込内容チェック 生年月日範囲チェック
 */
public class CheckSeiYmd {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckSeiYmd() {
        super();
    }

    public void exec(MosnaiCheckParam pMP, BizDate pSeiYmd, String pHubiMsg) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 生年月日範囲チェック 開始");
        }

        if (pSeiYmd == null) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 生年月日範囲チェック 終了（生年月日＝ブランク）");
            }
            return;
        }

        BizDate sysDate = pMP.getSysDate();

        if (pSeiYmd.compareTo(sysDate) > 0) {
            if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE, makeMsg(MessageId.EBC0046, MessageId.EBC0046, pHubiMsg), pMP,
                    C_TknKbn.NONE, C_MsgKbn.ERROR);
            }
            if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {
                setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1013, pHubiMsg),
                    C_SekmossakuseiErroutKbn.GAMEN, pMP);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 生年月日範囲チェック 終了");
        }
    }

    private String makeMsg(String pInMessageID, String pMsgID, String pReplaceMsg1) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg1));
        return ret.toString();
    }
}