package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_SkKihon;

/**
 * 新契約 申込内容チェック 切替契約有効判定
 */
public class HanteiKirikaeYuukou {

    @Inject
    private static Logger logger;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    public HanteiKirikaeYuukou() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 切替有効判定 開始");
        }

        C_SysKbn sysKbn = pMp.getSysKbn();
        HT_MosKihon mosKihon = pMp.getDataSyoriControl().getMosKihon();
        String douKaiSyono = mosKihon.getDoujikaiyakusyono();
        C_YuukousyoumetuKbn yuukousyoumetuKbn = C_YuukousyoumetuKbn.BLNK;
        List<IT_KykSyouhn> kykSyouhnLst = khozenCommonParam.getKeiyakuSyouhin(douKaiSyono, C_SyutkKbn.SYU);

        if (kykSyouhnLst != null && kykSyouhnLst.size() > 0) {
            yuukousyoumetuKbn = kykSyouhnLst.get(0).getYuukousyoumetukbn();
        }

        if (kykSyouhnLst == null || kykSyouhnLst.size() == 0 ||
            C_YuukousyoumetuKbn.SYOUMETU.eq(yuukousyoumetuKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                makeMsg(MessageId.EHC0212, MessageId.EHC0212),
                pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
        }

        if (kykSyouhnLst != null && kykSyouhnLst.size() > 0) {
            if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    makeMsg(MessageId.EHC0215, MessageId.EHC0215),
                    pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }
            else {
                setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                    makeMsg(MessageId.WHC0082, MessageId.WHC0082),
                    pMp, C_TknKbn.NONE, C_MsgKbn.WARNING);
            }
        }

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyono(douKaiSyono);
        SortJT_SkKihon sortJT_SkKihon = SWAKInjector.getInstance(SortJT_SkKihon.class);
        skKihonLst = sortJT_SkKihon.OrderJT_SkKihonByPkAsc(skKihonLst);

        if (skKihonLst != null && skKihonLst.size() > 0) {

            for (JT_SkKihon skKihon : skKihonLst) {
                Integer  iMaxSeikyuurirekiNo = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(
                    skKihon.getSkno(), skKihon.getSyono());
                if (iMaxSeikyuurirekiNo != null) {
                    if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                            makeMsg(MessageId.EHC0216, MessageId.EHC0216),
                            pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                    }
                    else {
                        setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                            makeMsg(MessageId.WHC0083, MessageId.WHC0083),
                            pMp, C_TknKbn.NONE, C_MsgKbn.WARNING);
                    }
                    break;
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 切替有効判定 終了");
        }
    }

    private String makeMsg(String pInMessageId, String pMsgId) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageId);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgId));
        return ret.toString();
    }
}