package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getHozenHenkouUktkrenNo()} テスト用クラスです。<br />
 * ※テストケースA1、A2、A3、C1、C2<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getHozenHenkouUktkrenNo {

    @Test
    public void testHozenHenkouUktkrenNo_A1() {

        String syoNo = "111111";

        String result = SaibanBiz.getHozenHenkouUktkrenNo(syoNo);

        exStringEquals(result, "1", "結果");
    }

    @Test
    public void testHozenHenkouUktkrenNo_A2() {

        String syoNo = "222222";

        String result = SaibanBiz.getHozenHenkouUktkrenNo(syoNo);

        exStringEquals(result, "101", "結果");
    }

    @Test
    public void testHozenHenkouUktkrenNo_A3() {

        String syoNo = "333333";

        String result = SaibanBiz.getHozenHenkouUktkrenNo(syoNo);

        exStringEquals(result, "99999", "結果");
    }

    @Test(expected = BizAppException.class)
    public void testHozenHenkouUktkrenNo_C1() {
        try{
            SaibanBiz.getHozenHenkouUktkrenNo("");
        }catch(BizAppException e){
            exStringEquals(e.getMessage(), "引数が不正です。", "証券番号");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    public void testHozenHenkouUktkrenNo_C2() {
        try{
            SaibanBiz.getHozenHenkouUktkrenNo(null);
        }catch(BizAppException e){
            exStringEquals(e.getMessage(), "引数が不正です。", "証券番号");
            throw e;
        }
    }

}
