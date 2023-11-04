package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.MessageId;
import yuyu.def.classification.C_MsgHikisuuNaiyouKbn;
import yuyu.def.db.entity.JM_SkNaiyouChk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * メッセージ引数設定処理のメソッド{@link SiMsgHikisuuSettei#exec(JM_SkNaiyouChk, String, String, String, String,
 *              String)}テスト用クラスです。<br/>
 */
@RunWith(OrderedRunner.class)
public class SiMsgHikisuuSetteiTest_exec {

    @Inject
    private SiMsgHikisuuSettei siMsgHikisuuSettei;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(C_MsgHikisuuNaiyouKbn.MESSAGEID);
        skNaiyouChk.setMsghikisuunaiyoukbn2(null);
        skNaiyouChk.setMsghikisuunaiyoukbn3(null);
        skNaiyouChk.setMsghikisuunaiyoukbn4(null);
        skNaiyouChk.setMsghikisuunaiyoukbn5(null);
        skNaiyouChk.setMsghikisuu1(MessageId.WJA1039);
        skNaiyouChk.setMsghikisuu2("");
        skNaiyouChk.setMsghikisuu3("");
        skNaiyouChk.setMsghikisuu4("");
        skNaiyouChk.setMsghikisuu5("");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, MessageId.WJA1049, "", "", "", "");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "手続注意情報が登録されています。確認してください。", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "", "メッセージリスト[4]");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(C_MsgHikisuuNaiyouKbn.KOUMOKUMEI);
        skNaiyouChk.setMsghikisuunaiyoukbn2(null);
        skNaiyouChk.setMsghikisuunaiyoukbn3(null);
        skNaiyouChk.setMsghikisuunaiyoukbn4(null);
        skNaiyouChk.setMsghikisuunaiyoukbn5(null);
        skNaiyouChk.setMsghikisuu1("sknnkaisiymd");
        skNaiyouChk.setMsghikisuu2("");
        skNaiyouChk.setMsghikisuu3("");
        skNaiyouChk.setMsghikisuu4("");
        skNaiyouChk.setMsghikisuu5("");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "hksknnkaisiymd", "", "", "", "");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "責任開始日", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "", "メッセージリスト[4]");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(C_MsgHikisuuNaiyouKbn.INPUT);
        skNaiyouChk.setMsghikisuunaiyoukbn2(null);
        skNaiyouChk.setMsghikisuunaiyoukbn3(null);
        skNaiyouChk.setMsghikisuunaiyoukbn4(null);
        skNaiyouChk.setMsghikisuunaiyoukbn5(null);
        skNaiyouChk.setMsghikisuu1("支払なしの死亡請求です。");
        skNaiyouChk.setMsghikisuu2("");
        skNaiyouChk.setMsghikisuu3("");
        skNaiyouChk.setMsghikisuu4("");
        skNaiyouChk.setMsghikisuu5("");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "契約保全にて解約処理中です。処理を取消してから実施してください。", "", "", "", "");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "契約保全にて解約処理中です。処理を取消してから実施してください。", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "", "メッセージリスト[4]");

    }
    @Test
    @TestOrder(40)
    public void testExec_B1(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(null);
        skNaiyouChk.setMsghikisuunaiyoukbn2(C_MsgHikisuuNaiyouKbn.MESSAGEID);
        skNaiyouChk.setMsghikisuunaiyoukbn3(null);
        skNaiyouChk.setMsghikisuunaiyoukbn4(null);
        skNaiyouChk.setMsghikisuunaiyoukbn5(null);
        skNaiyouChk.setMsghikisuu1("");
        skNaiyouChk.setMsghikisuu2(MessageId.WJA1039);
        skNaiyouChk.setMsghikisuu3("");
        skNaiyouChk.setMsghikisuu4("");
        skNaiyouChk.setMsghikisuu5("");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "", MessageId.WJA1049, "", "", "");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "手続注意情報が登録されています。確認してください。", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "", "メッセージリスト[4]");

    }

    @Test
    @TestOrder(50)
    public void testExec_B2(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(null);
        skNaiyouChk.setMsghikisuunaiyoukbn2(C_MsgHikisuuNaiyouKbn.KOUMOKUMEI);
        skNaiyouChk.setMsghikisuunaiyoukbn3(null);
        skNaiyouChk.setMsghikisuunaiyoukbn4(null);
        skNaiyouChk.setMsghikisuunaiyoukbn5(null);
        skNaiyouChk.setMsghikisuu1("");
        skNaiyouChk.setMsghikisuu2("hksknnkaisiymd");
        skNaiyouChk.setMsghikisuu3("");
        skNaiyouChk.setMsghikisuu4("");
        skNaiyouChk.setMsghikisuu5("");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "", "sknnkaisiymd", "", "", "");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "復活責任開始日", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "", "メッセージリスト[4]");

    }

    @Test
    @TestOrder(60)
    public void testExec_B3(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(null);
        skNaiyouChk.setMsghikisuunaiyoukbn2(C_MsgHikisuuNaiyouKbn.INPUT);
        skNaiyouChk.setMsghikisuunaiyoukbn3(null);
        skNaiyouChk.setMsghikisuunaiyoukbn4(null);
        skNaiyouChk.setMsghikisuunaiyoukbn5(null);
        skNaiyouChk.setMsghikisuu1("");
        skNaiyouChk.setMsghikisuu2("支払なしの死亡請求です。");
        skNaiyouChk.setMsghikisuu3("");
        skNaiyouChk.setMsghikisuu4("");
        skNaiyouChk.setMsghikisuu5("");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "",
            "契約保全にて解約処理中です。処理を取消してから実施してください。", "", "", "");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "契約保全にて解約処理中です。処理を取消してから実施してください。",
            "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "", "メッセージリスト[4]");

    }

    @Test
    @TestOrder(70)
    public void testExec_C1(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(null);
        skNaiyouChk.setMsghikisuunaiyoukbn2(null);
        skNaiyouChk.setMsghikisuunaiyoukbn3(C_MsgHikisuuNaiyouKbn.MESSAGEID);
        skNaiyouChk.setMsghikisuunaiyoukbn4(null);
        skNaiyouChk.setMsghikisuunaiyoukbn5(null);
        skNaiyouChk.setMsghikisuu1("");
        skNaiyouChk.setMsghikisuu2("");
        skNaiyouChk.setMsghikisuu3(MessageId.WJA1039);
        skNaiyouChk.setMsghikisuu4("");
        skNaiyouChk.setMsghikisuu5("");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "", "", MessageId.WJA1049, "", "");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "手続注意情報が登録されています。確認してください。", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "", "メッセージリスト[4]");

    }

    @Test
    @TestOrder(80)
    public void testExec_C2(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(null);
        skNaiyouChk.setMsghikisuunaiyoukbn2(null);
        skNaiyouChk.setMsghikisuunaiyoukbn3(C_MsgHikisuuNaiyouKbn.KOUMOKUMEI);
        skNaiyouChk.setMsghikisuunaiyoukbn4(null);
        skNaiyouChk.setMsghikisuunaiyoukbn5(null);
        skNaiyouChk.setMsghikisuu1("");
        skNaiyouChk.setMsghikisuu2("");
        skNaiyouChk.setMsghikisuu3("sknnkaisiymd");
        skNaiyouChk.setMsghikisuu4("");
        skNaiyouChk.setMsghikisuu5("");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "", "", "hksknnkaisiymd", "", "");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "責任開始日", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "", "メッセージリスト[4]");

    }

    @Test
    @TestOrder(90)
    public void testExec_C3(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(null);
        skNaiyouChk.setMsghikisuunaiyoukbn2(null);
        skNaiyouChk.setMsghikisuunaiyoukbn3(C_MsgHikisuuNaiyouKbn.INPUT);
        skNaiyouChk.setMsghikisuunaiyoukbn4(null);
        skNaiyouChk.setMsghikisuunaiyoukbn5(null);
        skNaiyouChk.setMsghikisuu1("");
        skNaiyouChk.setMsghikisuu2("");
        skNaiyouChk.setMsghikisuu3("支払なしの死亡請求です。");
        skNaiyouChk.setMsghikisuu4("");
        skNaiyouChk.setMsghikisuu5("");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "", "", "契約保全にて解約処理中です。処理を取消してから実施してください。", "", "");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "契約保全にて解約処理中です。処理を取消してから実施してください。",
            "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "", "メッセージリスト[4]");

    }

    @Test
    @TestOrder(100)
    public void testExec_D1(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(null);
        skNaiyouChk.setMsghikisuunaiyoukbn2(null);
        skNaiyouChk.setMsghikisuunaiyoukbn3(null);
        skNaiyouChk.setMsghikisuunaiyoukbn4(C_MsgHikisuuNaiyouKbn.MESSAGEID);
        skNaiyouChk.setMsghikisuunaiyoukbn5(null);
        skNaiyouChk.setMsghikisuu1("");
        skNaiyouChk.setMsghikisuu2("");
        skNaiyouChk.setMsghikisuu3("");
        skNaiyouChk.setMsghikisuu4(MessageId.WJA1039);
        skNaiyouChk.setMsghikisuu5("");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "", "", "", MessageId.WJA1049, "");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "手続注意情報が登録されています。確認してください。", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "", "メッセージリスト[4]");

    }

    @Test
    @TestOrder(110)
    public void testExec_D2(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(null);
        skNaiyouChk.setMsghikisuunaiyoukbn2(null);
        skNaiyouChk.setMsghikisuunaiyoukbn3(null);
        skNaiyouChk.setMsghikisuunaiyoukbn4(C_MsgHikisuuNaiyouKbn.KOUMOKUMEI);
        skNaiyouChk.setMsghikisuunaiyoukbn5(null);
        skNaiyouChk.setMsghikisuu1("");
        skNaiyouChk.setMsghikisuu2("");
        skNaiyouChk.setMsghikisuu3("");
        skNaiyouChk.setMsghikisuu4("hksknnkaisiymd");
        skNaiyouChk.setMsghikisuu5("");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "", "", "", "sknnkaisiymd", "");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "復活責任開始日", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "", "メッセージリスト[4]");

    }

    @Test
    @TestOrder(120)
    public void testExec_D3(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(null);
        skNaiyouChk.setMsghikisuunaiyoukbn2(null);
        skNaiyouChk.setMsghikisuunaiyoukbn3(null);
        skNaiyouChk.setMsghikisuunaiyoukbn4(C_MsgHikisuuNaiyouKbn.INPUT);
        skNaiyouChk.setMsghikisuunaiyoukbn5(null);
        skNaiyouChk.setMsghikisuu1("");
        skNaiyouChk.setMsghikisuu2("");
        skNaiyouChk.setMsghikisuu3("");
        skNaiyouChk.setMsghikisuu4("支払なしの死亡請求です。");
        skNaiyouChk.setMsghikisuu5("");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "", "", "",
            "契約保全にて解約処理中です。処理を取消してから実施してください。", "");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "契約保全にて解約処理中です。処理を取消してから実施してください。", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "", "メッセージリスト[4]");

    }

    @Test
    @TestOrder(130)
    public void testExec_E1(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(null);
        skNaiyouChk.setMsghikisuunaiyoukbn2(null);
        skNaiyouChk.setMsghikisuunaiyoukbn3(null);
        skNaiyouChk.setMsghikisuunaiyoukbn4(null);
        skNaiyouChk.setMsghikisuunaiyoukbn5(C_MsgHikisuuNaiyouKbn.MESSAGEID);
        skNaiyouChk.setMsghikisuu1("");
        skNaiyouChk.setMsghikisuu2("");
        skNaiyouChk.setMsghikisuu3("");
        skNaiyouChk.setMsghikisuu4("");
        skNaiyouChk.setMsghikisuu5(MessageId.WJA1039);
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "", "", "", "", MessageId.WJA1049);
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "手続注意情報が登録されています。確認してください。", "メッセージリスト[4]");

    }

    @Test
    @TestOrder(140)
    public void testExec_E2(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(null);
        skNaiyouChk.setMsghikisuunaiyoukbn2(null);
        skNaiyouChk.setMsghikisuunaiyoukbn3(null);
        skNaiyouChk.setMsghikisuunaiyoukbn4(null);
        skNaiyouChk.setMsghikisuunaiyoukbn5(C_MsgHikisuuNaiyouKbn.KOUMOKUMEI);
        skNaiyouChk.setMsghikisuu1("");
        skNaiyouChk.setMsghikisuu2("");
        skNaiyouChk.setMsghikisuu3("");
        skNaiyouChk.setMsghikisuu4("");
        skNaiyouChk.setMsghikisuu5("sknnkaisiymd");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "", "", "", "", "hksknnkaisiymd");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "責任開始日", "メッセージリスト[4]");

    }

    @Test
    @TestOrder(150)
    public void testExec_E3(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(null);
        skNaiyouChk.setMsghikisuunaiyoukbn2(null);
        skNaiyouChk.setMsghikisuunaiyoukbn3(null);
        skNaiyouChk.setMsghikisuunaiyoukbn4(null);
        skNaiyouChk.setMsghikisuunaiyoukbn5(C_MsgHikisuuNaiyouKbn.INPUT);
        skNaiyouChk.setMsghikisuu1("");
        skNaiyouChk.setMsghikisuu2("");
        skNaiyouChk.setMsghikisuu3("");
        skNaiyouChk.setMsghikisuu4("");
        skNaiyouChk.setMsghikisuu5("支払なしの死亡請求です。");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "", "", "", "",
            "契約保全にて解約処理中です。処理を取消してから実施してください。");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "契約保全にて解約処理中です。処理を取消してから実施してください。",
            "メッセージリスト[4]");

    }

    @Test
    @TestOrder(160)
    public void testExec_F1(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(null);
        skNaiyouChk.setMsghikisuunaiyoukbn2(null);
        skNaiyouChk.setMsghikisuunaiyoukbn3(null);
        skNaiyouChk.setMsghikisuunaiyoukbn4(null);
        skNaiyouChk.setMsghikisuunaiyoukbn5(null);
        skNaiyouChk.setMsghikisuu1("");
        skNaiyouChk.setMsghikisuu2("");
        skNaiyouChk.setMsghikisuu3("");
        skNaiyouChk.setMsghikisuu4("");
        skNaiyouChk.setMsghikisuu5("");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, "", "", "", "", "");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "", "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "", "メッセージリスト[4]");

    }

    @Test
    @TestOrder(170)
    public void testExec_F2(){
        JM_SkNaiyouChk skNaiyouChk = new JM_SkNaiyouChk();
        skNaiyouChk.setMsghikisuunaiyoukbn1(C_MsgHikisuuNaiyouKbn.MESSAGEID);
        skNaiyouChk.setMsghikisuunaiyoukbn2(C_MsgHikisuuNaiyouKbn.KOUMOKUMEI);
        skNaiyouChk.setMsghikisuunaiyoukbn3(C_MsgHikisuuNaiyouKbn.INPUT);
        skNaiyouChk.setMsghikisuunaiyoukbn4(C_MsgHikisuuNaiyouKbn.KOUMOKUMEI);
        skNaiyouChk.setMsghikisuunaiyoukbn5(C_MsgHikisuuNaiyouKbn.INPUT);
        skNaiyouChk.setMsghikisuu1(MessageId.WJA1039);
        skNaiyouChk.setMsghikisuu2("sknnkaisiymd");
        skNaiyouChk.setMsghikisuu3("支払なしの死亡請求です。");
        skNaiyouChk.setMsghikisuu4("hksknnkaisiymd");
        skNaiyouChk.setMsghikisuu5("支払なしの死亡請求です。");
        List<String> msgLst = new ArrayList<>();
        msgLst =  siMsgHikisuuSettei.exec(skNaiyouChk, MessageId.WJA1049, "hksknnkaisiymd",
            "契約保全にて解約処理中です。処理を取消してから実施してください。", "sknnkaisiymd",
            "契約管理にて処理を行っています。");
        exNumericEquals(msgLst.size(), 5, "件数");
        exStringEquals(msgLst.get(0), "手続注意情報が登録されています。確認してください。", "メッセージリスト[0]");
        exStringEquals(msgLst.get(1), "責任開始日", "メッセージリスト[1]");
        exStringEquals(msgLst.get(2), "契約保全にて解約処理中です。処理を取消してから実施してください。",
            "メッセージリスト[2]");
        exStringEquals(msgLst.get(3), "復活責任開始日", "メッセージリスト[3]");
        exStringEquals(msgLst.get(4), "契約管理にて処理を行っています。", "メッセージリスト[4]");

    }

}