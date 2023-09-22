package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Livhukaumu;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック リビングニーズ付加有無チェック
 */
public class CheckLivHuka {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckLivHuka() {
        super();
    }

    public void exec(MosnaiCheckParam pMP, BM_SyouhnZokusei pSyouhinZokusei) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ リビングニーズ付加有無チェック 開始");
        }

        HT_SyoriCTL syoriControl = pMP.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriControl.getMosKihon();
        C_Livhukaumu livhukaumu = mosKihon.getLivhukaumu();
        C_StknsetKbn stknSetKbn = mosKihon.getStknsetkbn();
        C_Kyksei kykSei = mosKihon.getKyksei();
        C_UmuKbn livTkUmu = pSyouhinZokusei.getLivtkumu();
        String syouhnNm = pSyouhinZokusei.getSyouhnnm();

        if (C_Livhukaumu.BLNK.eq(livhukaumu)) {
            if (C_UmuKbn.ARI.eq(livTkUmu)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, makeMsg(MessageId.EBC0045,
                    MessageId.EBC0045, ICommonKoumoku.DISP_N_LIVTKUMU), pMP);
            }
        }
        else if (C_Livhukaumu.ARI.eq(livhukaumu)) {
            if (C_UmuKbn.ARI.eq(livTkUmu)) {
                if (C_Kyksei.HJNKYK.eq(kykSei)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, makeMsg(MessageId.EHC0016,
                        MessageId.EHC0016, kykSei.getContent()), pMP);
                }
                if (C_StknsetKbn.ARI.eq(stknSetKbn)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        makeMsg(MessageId.EHC0017, MessageId.EHC0017), pMP);
                }
            }
            else if (C_UmuKbn.NONE.eq(livTkUmu)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    makeMsg(MessageId.EHC0016, MessageId.EHC0016, syouhnNm), pMP);
            }
        }
        else if (C_Livhukaumu.NONE.eq(livhukaumu)) {
            if (C_UmuKbn.NONE.eq(livTkUmu)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    makeMsg(MessageId.EHC0016, MessageId.EHC0016, syouhnNm), pMP);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ リビングニーズ付加有無チェック 終了");
        }
    }

    private String makeMsg(String pInMessageID, String pMsgID) {
        return makeMsg(pInMessageID, pMsgID, null);
    }

    private String makeMsg(String pInMessageID, String pMsgID, String pReplaceMsg) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        if (pReplaceMsg != null) {
            ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg));
        }
        else {
            ret.append(MessageUtil.getMessage(pMsgID));
        }
        return ret.toString();
    }

}
