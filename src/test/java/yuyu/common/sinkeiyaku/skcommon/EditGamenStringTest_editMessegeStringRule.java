package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.MessageId;
import yuyu.def.db.entity.HT_RuleHanteiMsg;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 画面用文字列編集のメソッド {@link EditGamenString#editStringSbstr(List<HT_RuleHanteiMsg>,int)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditGamenStringTest_editMessegeStringRule {

    @Test
    @TestOrder(10)
    public void testEditMessegeStringRule_A1() {
        List<HT_RuleHanteiMsg> ruleHanteiMsgList = null;


        String henkougoWkMojiretu = EditGamenString.editMessegeStringRule(ruleHanteiMsgList);

        exStringEquals(henkougoWkMojiretu, "", "編集用文字列");

    }

    @Test
    @TestOrder(20)
    public void testEditMessegeStringRule_A2() {
        List<HT_RuleHanteiMsg> ruleHanteiMsgList = new ArrayList<>();

        HT_RuleHanteiMsg ruleHanteiMsg1 =new HT_RuleHanteiMsg();
        HT_RuleHanteiMsg ruleHanteiMsg2 =new HT_RuleHanteiMsg();
        HT_RuleHanteiMsg ruleHanteiMsg3 =new HT_RuleHanteiMsg();
        ruleHanteiMsg1.setRulehanteimsgid(MessageId.EBA0079);

        ruleHanteiMsg2.setRulehanteimsgid(MessageId.EBA0080);

        ruleHanteiMsg3.setRulehanteimsgid(MessageId.EBA0081);

        ruleHanteiMsgList.add(ruleHanteiMsg1);
        ruleHanteiMsgList.add(ruleHanteiMsg2);
        ruleHanteiMsgList.add(ruleHanteiMsg3);
        String henkougoWkMojiretu = EditGamenString.editMessegeStringRule(ruleHanteiMsgList);

        exStringEquals(henkougoWkMojiretu, "対象が選択されていません。\n指定されたデータに送信済みのデータが含まれているため、処理できません。"
                + "\n再アップロード許可対象のデータが存在しないため、処理できません。", "編集用文字列");
    }

    @Test
    @TestOrder(30)
    public void testEditMessegeStringRule_A3() {
        List<HT_RuleHanteiMsg> ruleHanteiMsgList = new ArrayList<>();

        HT_RuleHanteiMsg ruleHanteiMsg1 =new HT_RuleHanteiMsg();
        ruleHanteiMsg1.setRulehanteimsgid(MessageId.EBA0079);

        ruleHanteiMsgList.add(ruleHanteiMsg1);
        String henkougoWkMojiretu = EditGamenString.editMessegeStringRule(ruleHanteiMsgList);

        exStringEquals(henkougoWkMojiretu, "対象が選択されていません。", "編集用文字列");
    }

    @Test
    @TestOrder(40)
    public void testEditMessegeStringRule_A4() {
        List<HT_RuleHanteiMsg> ruleHanteiMsgList = new ArrayList<>();

        String henkougoWkMojiretu = EditGamenString.editMessegeStringRule(ruleHanteiMsgList);

        exStringEquals(henkougoWkMojiretu, "", "編集用文字列");
    }

}
