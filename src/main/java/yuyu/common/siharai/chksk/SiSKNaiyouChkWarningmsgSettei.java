package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

/**
 * 保険金給付金支払 請求内容チェック 請求内容チェック警告メッセージ設定
 */
public class SiSKNaiyouChkWarningmsgSettei {

    @Inject
    private MessageManager messageManager;

    @Inject
    private static Logger logger;

    public SiSKNaiyouChkWarningmsgSettei() {
        super();
    }

    public void exec(int pGroupNo, List<String> pSeikyuuNaiyouChkKekkaAlertLst) {

        logger.debug("▽ 請求内容チェック警告メッセージ設定 開始");

        if (pSeikyuuNaiyouChkKekkaAlertLst.size() > 0) {
            for (int n = 0; n < pSeikyuuNaiyouChkKekkaAlertLst.size(); n = n + 6) {
                if (pGroupNo == 0) {
                    messageManager.addConversationMessageId(pSeikyuuNaiyouChkKekkaAlertLst.get(n),
                            pSeikyuuNaiyouChkKekkaAlertLst.get(n + 1),
                            pSeikyuuNaiyouChkKekkaAlertLst.get(n + 2),
                            pSeikyuuNaiyouChkKekkaAlertLst.get(n + 3),
                            pSeikyuuNaiyouChkKekkaAlertLst.get(n + 4),
                            pSeikyuuNaiyouChkKekkaAlertLst.get(n + 5));
                } else {
                    messageManager.addConversationMessageId(pGroupNo,
                            pSeikyuuNaiyouChkKekkaAlertLst.get(n),
                            pSeikyuuNaiyouChkKekkaAlertLst.get(n + 1),
                            pSeikyuuNaiyouChkKekkaAlertLst.get(n + 2),
                            pSeikyuuNaiyouChkKekkaAlertLst.get(n + 3),
                            pSeikyuuNaiyouChkKekkaAlertLst.get(n + 4),
                            pSeikyuuNaiyouChkKekkaAlertLst.get(n + 5));
                }
            }
        }
        logger.debug("△ 請求内容チェック警告メッセージ設定 終了");
    }
}
