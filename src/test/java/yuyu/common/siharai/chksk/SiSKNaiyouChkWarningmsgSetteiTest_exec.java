package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.web.message.MessageManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 請求内容チェック警告メッセージ設定のメソッド
 * {@link SiSKNaiyouChkWarningmsgSetteiTest_exec#exec(int,List<String>)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSKNaiyouChkWarningmsgSetteiTest_exec {

    @Inject
    private SiSKNaiyouChkWarningmsgSettei siSKNaiyouChkWarningmsgSettei;

    @Inject
    private MessageManager messageManager;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        int groupNo = 0;
        List<String> seikyuuNaiyouChkKekkaAlert = new ArrayList<>();
        siSKNaiyouChkWarningmsgSettei.exec(groupNo, seikyuuNaiyouChkKekkaAlert);
        exNumericEquals(messageManager.getConversationMessages().size(),0, "サイズ");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        int groupNo = 0;
        List<String> seikyuuNaiyouChkKekkaAlert = new ArrayList<>();
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ２");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ３");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ４");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ５");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ６");
        siSKNaiyouChkWarningmsgSettei.exec(groupNo, seikyuuNaiyouChkKekkaAlert);

        exNumericEquals(messageManager.getConversationMessages().size(),1, "サイズ");
        exNumericEquals(messageManager.getConversationMessages().get(0).getMessageArgs().length,5, "サイズ");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageId(),
            "テストメッセージ１", "メッセージＩＤ");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[0].toString(),
            "テストメッセージ２", "引数１");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[1].toString(),
            "テストメッセージ３", "引数２");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[2].toString(),
            "テストメッセージ４", "引数３");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[3].toString(),
            "テストメッセージ５", "引数４");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[4].toString(),
            "テストメッセージ６", "引数５");
        messageManager.removeConversationMessage(groupNo);

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        int groupNo = 1;
        List<String> seikyuuNaiyouChkKekkaAlert = new ArrayList<>();
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ２");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ３");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ４");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ５");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ６");
        siSKNaiyouChkWarningmsgSettei.exec(groupNo, seikyuuNaiyouChkKekkaAlert);

        exNumericEquals(messageManager.getConversationMessages().size(),1, "サイズ");
        exNumericEquals(messageManager.getConversationMessages().get(0).getMessageArgs().length,5, "サイズ");
        exNumericEquals(messageManager.getConversationMessages().get(0).getGroup(),
            1, "グループ番号");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageId(),
            "テストメッセージ１", "メッセージＩＤ");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[0].toString(),
            "テストメッセージ２", "引数１");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[1].toString(),
            "テストメッセージ３", "引数２");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[2].toString(),
            "テストメッセージ４", "引数３");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[3].toString(),
            "テストメッセージ５", "引数４");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[4].toString(),
            "テストメッセージ６", "引数５");
        messageManager.removeConversationMessage(groupNo);

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        int groupNo = 0;
        List<String> seikyuuNaiyouChkKekkaAlert = new ArrayList<>();
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ２");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ３");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ４");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ５");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ６");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ７");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ８");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ９");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１０");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１１");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１２");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１３");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１４");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１５");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１６");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１７");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１８");

        siSKNaiyouChkWarningmsgSettei.exec(groupNo, seikyuuNaiyouChkKekkaAlert);

        exNumericEquals(messageManager.getConversationMessages().size(),3, "サイズ");
        exNumericEquals(messageManager.getConversationMessages().get(0).getMessageArgs().length,5, "サイズ");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageId(),
            "テストメッセージ１", "メッセージＩＤ１");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[0].toString(),
            "テストメッセージ２", "引数１");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[1].toString(),
            "テストメッセージ３", "引数２");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[2].toString(),
            "テストメッセージ４", "引数３");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[3].toString(),
            "テストメッセージ５", "引数４");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[4].toString(),
            "テストメッセージ６", "引数５");
        exNumericEquals(messageManager.getConversationMessages().get(1).getMessageArgs().length,5, "サイズ");
        exStringEquals(messageManager.getConversationMessages().get(1).getMessageId(),
            "テストメッセージ７", "メッセージＩＤ２");
        exStringEquals(messageManager.getConversationMessages().get(1).getMessageArgs()[0].toString(),
            "テストメッセージ８", "引数１");
        exStringEquals(messageManager.getConversationMessages().get(1).getMessageArgs()[1].toString(),
            "テストメッセージ９", "引数２");
        exStringEquals(messageManager.getConversationMessages().get(1).getMessageArgs()[2].toString(),
            "テストメッセージ１０", "引数３");
        exStringEquals(messageManager.getConversationMessages().get(1).getMessageArgs()[3].toString(),
            "テストメッセージ１１", "引数４");
        exStringEquals(messageManager.getConversationMessages().get(1).getMessageArgs()[4].toString(),
            "テストメッセージ１２", "引数５");
        exNumericEquals(messageManager.getConversationMessages().get(2).getMessageArgs().length,5, "サイズ");
        exStringEquals(messageManager.getConversationMessages().get(2).getMessageId(),
            "テストメッセージ１３", "メッセージＩＤ３");
        exStringEquals(messageManager.getConversationMessages().get(2).getMessageArgs()[0].toString(),
            "テストメッセージ１４", "引数１");
        exStringEquals(messageManager.getConversationMessages().get(2).getMessageArgs()[1].toString(),
            "テストメッセージ１５", "引数２");
        exStringEquals(messageManager.getConversationMessages().get(2).getMessageArgs()[2].toString(),
            "テストメッセージ１６", "引数３");
        exStringEquals(messageManager.getConversationMessages().get(2).getMessageArgs()[3].toString(),
            "テストメッセージ１７", "引数４");
        exStringEquals(messageManager.getConversationMessages().get(2).getMessageArgs()[4].toString(),
            "テストメッセージ１８", "引数５");
        messageManager.removeConversationMessage(groupNo);

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        int groupNo = 1;
        List<String> seikyuuNaiyouChkKekkaAlert = new ArrayList<>();
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ２");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ３");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ４");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ５");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ６");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ７");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ８");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ９");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１０");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１１");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１２");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１３");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１４");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１５");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１６");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１７");
        seikyuuNaiyouChkKekkaAlert.add("テストメッセージ１８");

        siSKNaiyouChkWarningmsgSettei.exec(groupNo, seikyuuNaiyouChkKekkaAlert);

        exNumericEquals(messageManager.getConversationMessages().size(),3, "サイズ");
        exNumericEquals(messageManager.getConversationMessages().get(0).getGroup(),
            1, "グループ番号");
        exNumericEquals(messageManager.getConversationMessages().get(0).getMessageArgs().length,5, "サイズ");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageId(),
            "テストメッセージ１", "メッセージＩＤ１");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[0].toString(),
            "テストメッセージ２", "引数１");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[1].toString(),
            "テストメッセージ３", "引数２");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[2].toString(),
            "テストメッセージ４", "引数３");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[3].toString(),
            "テストメッセージ５", "引数４");
        exStringEquals(messageManager.getConversationMessages().get(0).getMessageArgs()[4].toString(),
            "テストメッセージ６", "引数５");
        exNumericEquals(messageManager.getConversationMessages().get(1).getGroup(),
            1, "グループ番号");
        exNumericEquals(messageManager.getConversationMessages().get(1).getMessageArgs().length,5, "サイズ");
        exStringEquals(messageManager.getConversationMessages().get(1).getMessageId(),
            "テストメッセージ７", "メッセージＩＤ２");
        exStringEquals(messageManager.getConversationMessages().get(1).getMessageArgs()[0].toString(),
            "テストメッセージ８", "引数１");
        exStringEquals(messageManager.getConversationMessages().get(1).getMessageArgs()[1].toString(),
            "テストメッセージ９", "引数２");
        exStringEquals(messageManager.getConversationMessages().get(1).getMessageArgs()[2].toString(),
            "テストメッセージ１０", "引数３");
        exStringEquals(messageManager.getConversationMessages().get(1).getMessageArgs()[3].toString(),
            "テストメッセージ１１", "引数４");
        exStringEquals(messageManager.getConversationMessages().get(1).getMessageArgs()[4].toString(),
            "テストメッセージ１２", "引数５");
        exNumericEquals(messageManager.getConversationMessages().get(2).getGroup(),
            1, "グループ番号");
        exNumericEquals(messageManager.getConversationMessages().get(2).getMessageArgs().length,5, "サイズ");
        exStringEquals(messageManager.getConversationMessages().get(2).getMessageId(),
            "テストメッセージ１３", "メッセージＩＤ３");
        exStringEquals(messageManager.getConversationMessages().get(2).getMessageArgs()[0].toString(),
            "テストメッセージ１４", "引数１");
        exStringEquals(messageManager.getConversationMessages().get(2).getMessageArgs()[1].toString(),
            "テストメッセージ１５", "引数２");
        exStringEquals(messageManager.getConversationMessages().get(2).getMessageArgs()[2].toString(),
            "テストメッセージ１６", "引数３");
        exStringEquals(messageManager.getConversationMessages().get(2).getMessageArgs()[3].toString(),
            "テストメッセージ１７", "引数４");
        exStringEquals(messageManager.getConversationMessages().get(2).getMessageArgs()[4].toString(),
            "テストメッセージ１８", "引数５");
        messageManager.removeConversationMessage(groupNo);

    }

}
