package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_PmnjtkhukaKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;

/**
 * 新契約 申込内容チェック 保険料免除特約関連チェック
 */
public class CheckPmentkKanren {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private BizDomManager bizDomManager;

    public CheckPmentkKanren() {

        super();
    }

    public void exec(MosnaiCheckParam pMp, BM_SyouhnZokusei pSyouhnZokusei) {

        HT_MosKihon mosKihon = null;
        C_PmnjtkhukaKbn pmnjtkhukaKbn = null;
        C_PmnjtkKbn pmnjtkKbn = null;
        HT_SyoriCTL syoriCTL = null;
        C_UmuKbn pmnjtkUmu = null;
        C_SysKbn sysKbn = null;
        C_NenkkntknKbn nenreiTokuninUmu = null;

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 保険料免除特約関連チェック 開始");
        }

        mosKihon = pMp.getDataSyoriControl().getMosKihon();
        pmnjtkhukaKbn = mosKihon.getPmnjtkhukakbn();
        pmnjtkKbn = mosKihon.getPmnjtkkbn();
        pmnjtkUmu = pSyouhnZokusei.getPmnjtkumu();
        sysKbn = pMp.getSysKbn();

        if (C_UmuKbn.ARI.eq(pmnjtkUmu) && C_PmnjtkhukaKbn.BLNK.eq(pmnjtkhukaKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    makeMsg(MessageId.EBC0045, MessageId.EBC0045, "保険料免除特約"),
                    pMp,
                    C_TknKbn.NONE,
                    C_MsgKbn.ERROR);
        }

        if (C_UmuKbn.NONE.eq(pmnjtkUmu)
                && !C_PmnjtkhukaKbn.BLNK.eq(pmnjtkhukaKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    makeMsg(MessageId.EBC0014, MessageId.EBC0014, pmnjtkKbn.getContent()),
                    pMp,
                    C_TknKbn.NONE,
                    C_MsgKbn.ERROR);
        }

        if (!C_PmnjtkKbn.NONE.eq(pmnjtkKbn)) {

            syoriCTL = pMp.getDataSyoriControl();

            if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                nenreiTokuninUmu = C_NenkkntknKbn.NONE;
            }
            else {
                HT_Tokunin toKunin = syoriCTL.getTokunin();

                if (toKunin == null ) {
                    nenreiTokuninUmu = C_NenkkntknKbn.NONE;
                }
                else {
                    if (C_NenkkntknKbn.NONE.eq(toKunin.getNenkkntknkbn())) {
                        nenreiTokuninUmu = C_NenkkntknKbn.NONE;
                    }
                    else {
                        nenreiTokuninUmu = C_NenkkntknKbn.ARI;
                    }
                }
            }

            if (C_NenkkntknKbn.NONE.eq(nenreiTokuninUmu)) {
                int hhknNen = mosKihon.getHhknnen();

                long tkSyuNenreiHani = bizDomManager.getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(pmnjtkKbn, hhknNen);
                if (tkSyuNenreiHani == 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            makeMsg(MessageId.EHC0028, MessageId.EHC0028, pmnjtkKbn.getContent()),
                            pMp,
                            C_TknKbn.KANOU,
                            C_MsgKbn.ERROR);
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 保険料免除特約関連チェック 終了");
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