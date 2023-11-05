package yuyu.common.biz.exception;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通 例外クラス 工程例外クラスのメソッド
 * {@link KouteiExceptionTest#KouteiException} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KouteiExceptionTest_KouteiException {

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testKouteiException_A1() {
        try {
            KouteiException exception = new KouteiException();
            throw exception;
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "機能連携情報が見つからないため処理を継続できません。<br />  長時間アクセスがなかったか、ブラウザの戻るボタン押下等が行われた可能性があります。<br />  メニューから再度機能を立ち上げ、処理をやりなおしてください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testKouteiException_A2() {

        try {
            KouteiException exception = new KouteiException("テストエラーメッセージ");
            throw exception;
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "機能連携情報が見つからないため処理を継続できません。<br />  長時間アクセスがなかったか、ブラウザの戻るボタン押下等が行われた可能性があります。<br />  メニューから再度機能を立ち上げ、処理をやりなおしてください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testKouteiException_A3() {
        try {
            Throwable throwable = new Throwable();
            KouteiException exception = new KouteiException(throwable, "テストエラーメッセージ");
            throw exception;
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "機能連携情報が見つからないため処理を継続できません。<br />  長時間アクセスがなかったか、ブラウザの戻るボタン押下等が行われた可能性があります。<br />  メニューから再度機能を立ち上げ、処理をやりなおしてください。", "エラーメッセージ");
            throw e;
        }
    }
}
