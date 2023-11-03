package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.MessageId;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#addListWarningMessage(String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_addListWarningMessage {

    @Inject
    private SiSetUiBean siSetUiBean;

    @Inject
    private MessageManager messageManager;

    @Test
    @TestOrder(10)
    public void testAddListWarningMessage_A1() {

        siSetUiBean.addListWarningMessage(MessageId.WJA0048, MessageUtil.getMessage(MessageId.WJA0048));

        String message = messageManager.getConversationMessages().get(0).getMessageArgs()[0].toString();
        String messageID = messageManager.getConversationMessages().get(0).getMessageId();
        int group = messageManager.getConversationMessages().get(0).getGroup();

        exStringEquals(message, "契約保全にて処理を行っています。", "メッセージ");
        exStringEquals(messageID, "WBC0001", "メッセージID");
        exNumericEquals(group, 10, "メッセージグループ");

        messageManager.removeConversationMessage(10);
    }
}
