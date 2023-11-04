package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizException;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * AnsyuKokTyouhyouHensyuuクラスのメソッド {@link AnsyuKokTyouhyouHensyuu#exec(String, String, C_AsTyouhyoukigouKbn, String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class AnsyuKokTyouhyouHensyuuTest_exec {
    @Inject
    private AnsyuKokTyouhyouHensyuu ansyuKokTyouhyouHensyuu;

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        try {
            ansyuKokTyouhyouHensyuu.exec("18807000017", "1", C_AsTyouhyoukigouKbn.BLNK, "000");
        } catch (BizException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。帳票記号が設定できませんでした。証券番号：" + "18807000017",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        try {
            ansyuKokTyouhyouHensyuu.exec("18807000017", "1", null, "000");
        } catch (BizException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。帳票記号が設定できませんでした。証券番号：" + "18807000017",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        ansyuKokTyouhyouHensyuu.exec("18807000017", "1", C_AsTyouhyoukigouKbn.AS_KOUHURIKAISIANNAI, "202");

        exStringEquals(ansyuKokTyouhyouHensyuu.getSakuseino(), "0000001-ﾕ01-202", "作成番号");

        exStringEquals(ansyuKokTyouhyouHensyuu.getSclatoSyono(), "07000017188", "スクランブル後証券番号");
    }
}
