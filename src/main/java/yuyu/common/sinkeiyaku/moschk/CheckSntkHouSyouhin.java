package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 新契約 申込内容チェック 選択方法商品属性チェック
 */
public class CheckSntkHouSyouhin {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckSntkHouSyouhin() {
        super();
    }

    public void exec(MosnaiCheckParam pMP, BM_SyouhnZokusei pSyouhinZokusei){

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 選択方法商品属性チェック 開始");
        }

        C_SntkhouKbn sntkhouKbn = pMP.getDataSyoriControl().getMosKihon().getSntkhoukbn();

        if (C_SntkhouKbn.KKT.eq(sntkhouKbn)) {
            if (C_UmuKbn.NONE.eq(pSyouhinZokusei.getKktumu())) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, makeMsg(MessageId.EHC0019,
                        MessageId.EHC0019, pSyouhinZokusei.getSyouhnnm(), sntkhouKbn.getContent()),
                        pMP);
            }
        }
        else if (C_SntkhouKbn.HJY.eq(sntkhouKbn)) {
            if (C_UmuKbn.NONE.eq(pSyouhinZokusei.getHjyumu())) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, makeMsg(MessageId.EHC0019,
                        MessageId.EHC0019, pSyouhinZokusei.getSyouhnnm(), sntkhouKbn.getContent()),
                        pMP);
            }
        }
        else if (C_SntkhouKbn.NONE.eq(sntkhouKbn)) {
            if (C_UmuKbn.NONE.eq(pSyouhinZokusei.getMusenumu())) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, makeMsg(MessageId.EHC0019,
                        MessageId.EHC0019, pSyouhinZokusei.getSyouhnnm(), sntkhouKbn.getContent()),
                        pMP);
            }
        }
        else if (C_SntkhouKbn.SYOKUGYOU.eq(sntkhouKbn)) {
            if (C_UmuKbn.NONE.eq(pSyouhinZokusei.getSyokugyoukktumu())) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, makeMsg(MessageId.EHC0019,
                        MessageId.EHC0019, pSyouhinZokusei.getSyouhnnm(), sntkhouKbn.getContent()),
                        pMP);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 選択方法商品属性チェック 終了");
        }
    }

    private String makeMsg(String pInMessageID, String pMsgID, String pReplaceMsg1,
            String pReplaceMsg2) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg1, pReplaceMsg2));
        return ret.toString();
    }

}