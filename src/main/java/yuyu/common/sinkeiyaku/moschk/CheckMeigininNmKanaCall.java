package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.db.entity.HT_MosKihon;

/**
 * 新契約 申込内容チェック カナ名義人チェック呼出し
 */
public class CheckMeigininNmKanaCall {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckMeigininNmKanaCall() {
        super();
    }

    public boolean execKyk(MosnaiCheckParam pMp) {
        boolean chkResult = true;

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 契約者名（カナ）チェック 開始");
        }

        HT_MosKihon mosKihon = pMp.getDataSyoriControl().getMosKihon();
        String kykNmKn  = mosKihon.getKyknmkn();
        C_Kyksei kykSei   = mosKihon.getKyksei();

        if (!BizUtil.isBlank(kykNmKn)) {
            C_Kojinhjn kojinHoujinKbn;
            if (C_Kyksei.HJNKYK.eq(kykSei)) {
                kojinHoujinKbn = C_Kojinhjn.HJN;
            }
            else {
                kojinHoujinKbn = C_Kojinhjn.KOJIN;
            }
            chkResult = checkMeigininNmKanaSpKsKhSt(kykNmKn,
                    kojinHoujinKbn, ICommonKoumoku.DISP_S_KYKNMKN, pMp);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 契約者名（カナ）チェック 終了");
        }
        return chkResult;
    }

    public boolean execHhkn(MosnaiCheckParam pMp) {
        boolean  chkResult = true;

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 被保険者名（カナ）チェック 開始");
        }

        String hhknNmKn = pMp.getDataSyoriControl().getMosKihon().getHhknnmkn();

        if (!BizUtil.isBlank(hhknNmKn)) {
            chkResult = checkMeigininNmKanaSpKsKhSt(hhknNmKn, C_Kojinhjn.KOJIN,
                    ICommonKoumoku.DISP_S_HHKNNMKN, pMp);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 被保険者名（カナ）チェック 終了");
        }
        return chkResult;
    }

    public boolean execKok(MosnaiCheckParam pMp) {
        boolean chkResult = true;

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 顧客名（カナ）チェック 開始");
        }

        HT_MosKihon mosKihon = pMp.getDataSyoriControl().getMosKihon();
        String kokNmKn = mosKihon.getKyknmkn();
        C_Kyksei kykSei = mosKihon.getKyksei();

        if(!BizUtil.isBlank(kokNmKn)) {
            C_Kojinhjn kojinHoujinKbn;
            if(C_Kyksei.HJNKYK.eq(kykSei)) {
                kojinHoujinKbn = C_Kojinhjn.HJN;
            }
            else {
                kojinHoujinKbn = C_Kojinhjn.KOJIN;
            }
            chkResult = checkMeigininNmKana(kokNmKn,
                    kojinHoujinKbn, ICommonKoumoku.DISP_S_KOKNMKN, pMp);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 顧客名（カナ）チェック 終了");
        }

        return chkResult;
    }

    private boolean checkMeigininNmKana(String pMeigininNmKana, C_Kojinhjn pKojinHoujinKbn,
            String pMessage, MosnaiCheckParam pMp) {

        if (!CheckMeigininNmKana.isCheckOK(pMeigininNmKana, pKojinHoujinKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    makeMsg(MessageId.EBC0046, MessageId.EBC0046, pMessage), pMp);
            return false;
        }
        return true;
    }

    private boolean checkMeigininNmKanaSpKsKhSt(String pMeigininNmKana, C_Kojinhjn pKojinHoujinKbn,
        String pMessage, MosnaiCheckParam pMp) {

        if (!CheckMeigininNmKana.isCheckOK(pMeigininNmKana, pKojinHoujinKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                C_SpKeisanKahiKbn.SPKEISANKA,
                C_HubisyubetusyousaiKbn.NONE,
                makeMsg(MessageId.EBC0046, MessageId.EBC0046, pMessage),
                pMp,
                C_TknKbn.NONE,
                C_MsgKbn.ERROR);
            return false;
        }
        return true;
    }

    private String makeMsg(String pMessageId, String pMsgId, String pReplaceMsg)  {

        StringBuffer ret = new StringBuffer();
        ret.append(pMessageId);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgId, pReplaceMsg));
        return ret.toString();
    }
}
