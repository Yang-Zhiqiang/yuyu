package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備メッセージ設定クラスのメソッド {@link SetHubiMsg#editMsg(String, C_SysKbn, C_TknKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHubiMsgTest_editMsg {

    @Inject
    private SetHubiMsg setHubiMsg;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testEditMsg_A1() {

        List<String> msgList = setHubiMsg.editMsg("", C_SysKbn.ESHIEN, C_TknKbn.NONE);

        exStringEquals(msgList.get(0), "", "メッセージ文言リスト1件目");
        exStringEquals(msgList.get(1), "", "メッセージ文言リスト2件目");
        exStringEquals(msgList.get(2), "", "メッセージ文言リスト3件目");
    }

    @Test
    @TestOrder(20)
    public void testEditMsg_A2() {

        List<String> msgList = setHubiMsg.editMsg("あああああてすと", C_SysKbn.ESHIEN, C_TknKbn.NONE);

        exStringEquals(msgList.get(0), "", "メッセージ文言リスト1件目");
        exStringEquals(msgList.get(1), "", "メッセージ文言リスト2件目");
        exStringEquals(msgList.get(2), "あああああてすと", "メッセージ文言リスト3件目");
    }

    @Test
    @TestOrder(30)
    public void testEditMsg_A3() {

        List<String> msgList = setHubiMsg.editMsg("あああああてすとお", C_SysKbn.ESHIEN, C_TknKbn.SUMI);

        exStringEquals(msgList.get(0), "あああああてす", "メッセージ文言リスト1件目");
        exStringEquals(msgList.get(1), "あああああてす", "メッセージ文言リスト2件目");
        exStringEquals(msgList.get(2), "お", "メッセージ文言リスト3件目");
    }

    @Test
    @TestOrder(40)
    public void testEditMsg_A4() {

        List<String> msgList = setHubiMsg.editMsg("EBC1014 抽出条件ああああああああああいいいいいいいいいいおおおおおおおおおおううううううううううええええええええええかかかかかかかかかかききききききききききここここここここここくくくくくくくくくくけけけけけけけけけけささささささささささＡＡＡＡＡＡＡＡＡＡ１２３４５６７８９０ＡＢＣＥＦを設定してください。", C_SysKbn.SKEI, C_TknKbn.NONE);

        exStringEquals(msgList.get(0), "EBC1014", "メッセージ文言リスト1件目");
        exStringEquals(msgList.get(1), "EBC1014", "メッセージ文言リスト2件目");
        exStringEquals(msgList.get(2), "抽出条件ああああああああああいいいいいいいいいいおおおおおおおおおおううううううううううええええええええええかかかかかかかかかかききききききききききここここここここここくくくくくくくくくくけけけけけけけけけけささささささささささＡＡＡＡＡＡＡＡＡＡ１２３４５６７８９０ＡＢＣＥＦを設定してください。", "メッセージ文言リスト3件目");
    }

    @Test
    @TestOrder(50)
    public void testEditMsg_A5() {

        List<String> msgList = setHubiMsg.editMsg("EBC1014 抽出条件ああああああああああいいいいいいいいいいおおおおおおおおおおううううううううううええええええええええかかかかかかかかかかききききききききききここここここここここくくくくくくくくくくけけけけけけけけけけささささささささささＡＡＡＡＡＡＡＡＡＡ１２３４５６７８９０ＡＢＣＥＦＧを設定してください。", C_SysKbn.SKEI, C_TknKbn.NONE);

        exStringEquals(msgList.get(0), "EBC1014", "メッセージ文言リスト1件目");
        exStringEquals(msgList.get(1), "EBC1014", "メッセージ文言リスト2件目");
        exStringEquals(msgList.get(2), "抽出条件ああああああああああいいいいいいいいいいおおおおおおおおおおううううううううううええええええええええかかかかかかかかかかききききききききききここここここここここくくくくくくくくくくけけけけけけけけけけささささささささささＡＡＡＡＡＡＡＡＡＡ１２３４５６７８９０ＡＢＣＥＦＧを設定してください。", "メッセージ文言リスト3件目");
    }

    @Test
    @TestOrder(60)
    public void testEditMsg_A6() {

        List<String> msgList = setHubiMsg.editMsg("EBC1014 抽出条件ああああああああああいいいいいいいいいいおおおおおおおおおおううううううううううええええええええええかかかかかかかかかかききききききききききここここここここここくくくくくくくくくくけけけけけけけけけけささささささささささＡＡＡＡＡＡＡＡＡＡ１２３４５６７８９０ＡＢＣＥＦＧＨを設定してください。", C_SysKbn.SKEI, C_TknKbn.NONE);

        exStringEquals(msgList.get(0), "EBC1014", "メッセージ文言リスト1件目");
        exStringEquals(msgList.get(1), "EBC1014", "メッセージ文言リスト2件目");
        exStringEquals(msgList.get(2), "抽出条件ああああああああああいいいいいいいいいいおおおおおおおおおおううううううううううええええええええええかかかかかかかかかかききききききききききここここここここここくくくくくくくくくくけけけけけけけけけけささささささささささＡＡＡＡＡＡＡＡＡＡ１２３４５６７８９０ＡＢＣＥＦＧＨを設定してくださ…", "メッセージ文言リスト3件目");
    }

    @Test
    @TestOrder(70)
    public void testEditMsg_A7() {

        String msg = "EBC1014 抽出条件ああああああああああいいいいいいいいいいおおおおおおおおおおううううううううううええええええええええかかかかかかかかかかききききききききききここここここここここくくくくくくくくくくけけけけけけけけけけささささささささささＡＡＡＡＡＡＡＡＡＡ１２３４５６７８９０Ａを設定してください。";

        String resultMsg = "（特認済）抽出条件ああああああああああいいいいいいいいいいおおおおおおおおおおううううううううううええええええええええかかかかかかかかかかききききききききききここここここここここくくくくくくくくくくけけけけけけけけけけささささささささささＡＡＡＡＡＡＡＡＡＡ１２３４５６７８９０Ａを設定してください。";

        List<String> msgList = setHubiMsg.editMsg(msg, C_SysKbn.SKEI, C_TknKbn.SUMI);

        exStringEquals(msgList.get(0), "EBC1014", "メッセージ文言リスト1件目");
        exStringEquals(msgList.get(1), "KBC1014", "メッセージ文言リスト2件目");
        exStringEquals(msgList.get(2), resultMsg, "メッセージ文言リスト3件目");
    }

    @Test
    @TestOrder(80)
    public void testEditMsg_A8() {

        String msg = "EBC1014 抽出条件ああああああああああいいいいいいいいいいおおおおおおおおおおううううううううううええええええええええかかかかかかかかかかききききききききききここここここここここくくくくくくくくくくけけけけけけけけけけささささささささささＡＡＡＡＡＡＡＡＡＡ１２３４５６７８９０ＢＣＤＥＦＧＦを設定してください。";

        String resultMsg = "【特認可能】抽出条件ああああああああああいいいいいいいいいいおおおおおおおおおおううううううううううええええええええええかかかかかかかかかかききききききききききここここここここここくくくくくくくくくくけけけけけけけけけけささささささささささＡＡＡＡＡＡＡＡＡＡ１２３４５６７８９０ＢＣＤＥＦＧＦを設…";

        List<String> msgList = setHubiMsg.editMsg(msg, C_SysKbn.SKEI, C_TknKbn.KANOU);

        exStringEquals(msgList.get(0), "EBC1014", "メッセージ文言リスト1件目");
        exStringEquals(msgList.get(1), "TBC1014", "メッセージ文言リスト2件目");
        exStringEquals(msgList.get(2), resultMsg, "メッセージ文言リスト3件目");
    }


}
