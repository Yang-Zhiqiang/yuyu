package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 契約者項目関連チェック
 */
public class CheckKykKanren {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckKykKanren() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 契約者項目関連チェック 開始");
        }

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        String kykNmKn = mosKihon.getKyknmkn();
        String kykNmKj = mosKihon.getKyknmkj();
        C_KjkhukaKbn kykKjHukaKbn = mosKihon.getKyknmkjkhukakbn();
        C_Tdk kyktdk = mosKihon.getKyktdk();
        C_KykKbn kykKbn = mosKihon.getKykkbn();
        C_SysKbn sysKbn = pMP.getSysKbn();

        if (C_KykKbn.KEIHI_DOUITU.eq(kykKbn)) {
            if (!BizUtil.isBlank(kykNmKn) || !BizUtil.isBlank(kykNmKj)
                || !isBlankKyktdk(kyktdk)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    makeMsg(MessageId.EBC0007, MessageId.EBC0007,
                        ICommonKoumoku.DISP_S_KYKNMKN + "・" +
                            ICommonKoumoku.DISP_S_KYKNMKJ + "・" +
                            ICommonKoumoku.DISP_N_KYKTDK), pMP);
            }

            if (!kykKjHukaKbn.eq(C_KjkhukaKbn.BLNK)) {
                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        makeMsg(MessageId.EHC0124, MessageId.EHC0124), pMP);
                }
            }
        }
        else {
            if (C_SysKbn.SKEI.eq(sysKbn)) {
                if (BizUtil.isBlank(kykNmKn) || BizUtil.isBlank(kykNmKj)
                    || isBlankKyktdk(kyktdk)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        makeMsg(MessageId.EBC0045, MessageId.EBC0045,
                            ICommonKoumoku.DISP_S_KYKNMKN + "・" + ICommonKoumoku.DISP_S_KYKNMKJ + "・" +
                                ICommonKoumoku.DISP_N_KYKTDK), pMP);
                }
            }
            else if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                if (BizUtil.isBlank(kykNmKn)  || isBlankKyktdk(kyktdk)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        makeMsg(MessageId.EBC0045, MessageId.EBC0045,
                            ICommonKoumoku.DISP_S_KYKNMKN + "・" + ICommonKoumoku.DISP_N_KYKTDK), pMP);
                }
            }

            C_Kyksei kykSei = mosKihon.getKyksei();
            C_Hhknsei hhknSei = mosKihon.getHhknsei();
            if (C_Tdk.HGU.eq(kyktdk) && kykSei.getValue().equals(hhknSei.getValue())) {
                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, makeMsg(MessageId.EHA0452, MessageId.EHA0452), pMP);
                }
                if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                    setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1014), C_SekmossakuseiErroutKbn.GAMEN, pMP);
                    logger.debug("△ 契約者項目関連チェック 終了");
                    return;
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 契約者項目関連チェック 終了");
        }
    }

    private String makeMsg(String pInMessageID, String pMsgID) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID));
        return ret.toString();
    }

    private String makeMsg(String pInMessageID, String pMsgID, String pReplaceMsg) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg));
        return ret.toString();
    }

    private boolean isBlankKyktdk(C_Tdk pTestSeiValue) {
        if (C_Tdk.BLNK.eq(pTestSeiValue)) {
            return true;
        }
        return false;
    }
}