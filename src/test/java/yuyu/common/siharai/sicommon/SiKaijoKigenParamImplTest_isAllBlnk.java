package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.siharai.edittbl.SiKaijoKigenParamImpl;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 解除期限日入力Paramインターフェース実装クラスのメソッド{@link SiKaijoKigenParamImpl#isAllBlnk()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiKaijoKigenParamImplTest_isAllBlnk {

    @Inject
    SiKaijoKigenParamImpl siKaijoKigenParamImpl;

    @Test
    @TestOrder(10)
    public void testIsAllBlnk_A1(){
        siKaijoKigenParamImpl.setKaijokigenymd(null);

        boolean result = siKaijoKigenParamImpl.isAllBlnk();

        assertTrue(result);
    }

    @Test
    @TestOrder(20)
    public void testIsAllBlnk_A2(){
        siKaijoKigenParamImpl.setKaijokigenymd(BizDate.valueOf("20160202"));

        boolean result = siKaijoKigenParamImpl.isAllBlnk();

        assertFalse(result);

        MockObjectManager.initialize();
    }
}
