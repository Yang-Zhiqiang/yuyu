package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 契約者性別チェック
 */
public class CheckKykSeibetu {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckKykSeibetu() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {
        if (logger.isDebugEnabled()) {
            logger.debug("▽ 契約者性別チェック 開始");
        }
        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        C_Kyksei kykSei = mosKihon.getKyksei();
        C_KykKbn kykKbn = mosKihon.getKykkbn();

        if (C_Kyksei.MALE.eq(kykSei) || C_Kyksei.FEMALE.eq(kykSei)) {
            if (C_KykKbn.KEIHI_DOUITU.eq(kykKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE, makeMsg(MessageId.EBC0007, MessageId.EBC0007,
                        ICommonKoumoku.DISP_N_KYKSEI), pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }
        }
        else if (C_Kyksei.HJNKYK.eq(kykSei)) {
            if (C_KykKbn.KEIHI_DOUITU.eq(kykKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE, makeMsg(MessageId.EHC0019, MessageId.EHC0019,
                        kykSei.getContent(), kykKbn.getContent()), pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }
        }
        else if (C_Kyksei.BLNK.eq(kykSei)) {
            if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE, makeMsg(MessageId.EBC0045, MessageId.EBC0045,
                        ICommonKoumoku.DISP_N_KYKSEI), pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 契約者性別チェック 終了");
        }
    }

    private String makeMsg(String pInMessageID, String pMsgID, String pReplaceMsg) {
        return makeMsg(pInMessageID, pMsgID, pReplaceMsg, null);
    }

    private String makeMsg(String pInMessageID, String pMsgID, String pReplaceMsg1, String pReplaceMsg2) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        if (pReplaceMsg2 != null) {
            ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg1, pReplaceMsg2));
        }
        else {
            ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg1));
        }
        return ret.toString();
    }
}
