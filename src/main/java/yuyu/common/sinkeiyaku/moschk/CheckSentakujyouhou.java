package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_YouhiblnkKbn;

/**
 * 新契約 申込内容チェック 選択情報チェック
 */
public class CheckSentakujyouhou {

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private CheckMRKanren checkMRKanren;

    public CheckSentakujyouhou() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
            if (C_YouhiblnkKbn.YOU.eq(pMP.getHhknItekisntkhndktYhKbn())) {

                setHubiMsg.exec(C_KetsrhkosKbn.WARNING, makeMsg(MessageId.WHC1004,
                        MessageUtil.getMessage(MessageId.WHC1004)),
                        pMP, C_TknKbn.NONE, C_MsgKbn.WARNING);
            }
        }
        checkMRKanren.exec(pMP);
    }

    private String makeMsg(String pInMessageID, String pMsg) {

        StringBuffer retMsg = new StringBuffer();
        retMsg.append(pInMessageID);
        retMsg.append(" ");
        retMsg.append(pMsg);

        return retMsg.toString();
    }
}
