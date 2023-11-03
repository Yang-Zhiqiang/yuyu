package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.MessageId;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#addListMessage(int, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_addListMessage {

    @Inject
    private SiSetUiBean siSetUiBean;

    @Inject
    private MessageManager messageManager;

    @Test
    @TestOrder(10)
    public void testAddListMessage_A1() {

        siSetUiBean.addListMessage(SiMessageGroupConstants.GROUP_MESSAGELIST1, MessageId.WJA0048, MessageUtil.getMessage(MessageId.WJA0048));

        String message = messageManager.getConversationMessages().get(0).getMessageArgs()[0].toString();
        String messageID = messageManager.getConversationMessages().get(0).getMessageId();
        int group = messageManager.getConversationMessages().get(0).getGroup();

        exStringEquals(message, "契約保全にて処理を行っています。", "メッセージ");
        exStringEquals(messageID, "WBC0001", "メッセージID");
        exNumericEquals(group, 20, "メッセージグループ");

        messageManager.removeConversationMessage(20);
    }

    @Test
    @TestOrder(20)
    public void testAddListMessage_A2() {

        siSetUiBean.addListMessage(SiMessageGroupConstants.GROUP_MESSAGELIST1, "", MessageUtil.getMessage(MessageId.WJA0048));

        exNumericEquals(messageManager.getConversationMessages().size(), 0, "メッセージのリストの件数");
    }

    @Test
    @TestOrder(30)
    public void testAddListMessage_A3() {

        siSetUiBean.addListMessage(SiMessageGroupConstants.GROUP_MESSAGELIST1, MessageId.WJA0048, "");

        exNumericEquals(messageManager.getConversationMessages().size(), 0, "メッセージのリストの件数");
    }

    @Test
    @TestOrder(40)
    public void testAddListMessage_A4() {

        siSetUiBean.addListMessage(SiMessageGroupConstants.GROUP_MESSAGELIST1, null, MessageUtil.getMessage(MessageId.WJA0048));

        exNumericEquals(messageManager.getConversationMessages().size(), 0, "メッセージのリストの件数");
    }

    @Test
    @TestOrder(50)
    public void testAddListMessage_A5() {

        siSetUiBean.addListMessage(SiMessageGroupConstants.GROUP_MESSAGELIST1, MessageId.WJA0048, null);

        exNumericEquals(messageManager.getConversationMessages().size(), 0, "メッセージのリストの件数");

        MockObjectManager.initialize();
    }
}
