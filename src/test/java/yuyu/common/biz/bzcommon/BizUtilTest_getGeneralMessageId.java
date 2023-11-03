package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.MessageId;


/**
 * 業務汎用ユーティリティクラスの汎用メッセージID取得メソッド {@link BizUtil#getGeneralMessageId(String)} テスト用クラスです。<br />
 *
 */
@RunWith(SWAKTestRunner.class)
public class BizUtilTest_getGeneralMessageId {

    @Test
    public void testGetGeneralMessageId1() {
        String messageId = MessageId.EAC0047;
        String result = BizUtil.getGeneralMessageId(messageId);
        exStringEquals(result, MessageId.EBC0001, "戻り値判定結果");
    }

    @Test
    public void testGetGeneralMessageId2() {
        String messageId = MessageId.WBC0030;
        String result = BizUtil.getGeneralMessageId(messageId);
        exStringEquals(result, MessageId.WBC0001, "戻り値判定結果");
    }

    @Test
    public void testGetGeneralMessageId3() {
        String messageId = MessageId.IKW0045;
        String result = BizUtil.getGeneralMessageId(messageId);
        exStringEquals(result, MessageId.IBC0001, "戻り値判定結果");
    }

    @Test
    public void testGetGeneralMessageId4() {
        String messageId = MessageId.QHA0009;
        String result = BizUtil.getGeneralMessageId(messageId);
        exStringEquals(result, MessageId.QBC0001, "戻り値判定結果");
    }

    @Test
    public void testGetGeneralMessageId5() {
        String messageId = "KHA9999";
        String result = BizUtil.getGeneralMessageId(messageId);
        exStringEquals(result, MessageId.KBC0001, "戻り値判定結果");
    }

    @Test
    public void testGetGeneralMessageId6() {
        String messageId = "THA9999";
        String result = BizUtil.getGeneralMessageId(messageId);
        exStringEquals(result, MessageId.TBC0001, "戻り値判定結果");
    }

    @Test
    public void testGetGeneralMessageId7() {
        String messageId = "FHA9999";
        String result = BizUtil.getGeneralMessageId(messageId);
        exStringEquals(result, "FHA9999", "戻り値判定結果");
    }

    @Test(expected = BizAppException.class)
    public void testGetGeneralMessageId8() {
        String messageId = null;
        try {
            BizUtil.getGeneralMessageId(messageId);
        } catch(BizAppException e) {
            String errorMsg = e.getMessage();
            exStringEquals(errorMsg, "引数が不正です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    public void testGetGeneralMessageId9() {
        String messageId = "";
        String result = BizUtil.getGeneralMessageId(messageId);
        exStringEquals(result, "", "戻り値判定結果");
    }


}
