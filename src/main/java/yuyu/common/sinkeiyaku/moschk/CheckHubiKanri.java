package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 不備管理チェック
 */
public class CheckHubiKanri {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckHubiKanri() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 不備管理チェック 開始");
        }
        String msg = null;
        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();

        List<HT_SkHubi> skHubiLst = syoriCTL.getSkHubis();
        boolean hubiMsgSet = false;

        if (skHubiLst.size() > 0) {
            for (int index = 0; index < skHubiLst.size(); index++) {
                HT_SkHubi skHubi = skHubiLst.get(index);
                List<HT_SkHubiDetail> skHubiDetailLst = skHubi.getSkHubiDetailsByKaisyouymd(null);

                if (skHubiDetailLst.size() > 0) {
                    hubiMsgSet = true;
                    break;
                }
            }
        }

        if (hubiMsgSet) {
            msg = makeMsg(MessageId.EHC0160, MessageId.EHC0160);

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    msg,
                    pMp,
                    C_TknKbn.NONE,
                    C_MsgKbn.ERROR);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 不備管理チェック 終了");
        }
    }

    private String makeMsg(String pInMessageID, String pMsgID) {
        StringBuffer sbRet = new StringBuffer();

        sbRet.append(pInMessageID);
        sbRet.append(" ");
        sbRet.append(MessageUtil.getMessage(pMsgID));

        return sbRet.toString();
    }
}
