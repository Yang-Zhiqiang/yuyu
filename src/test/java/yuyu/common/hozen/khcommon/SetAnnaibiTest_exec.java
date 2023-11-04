package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 案内日設定クラスのメソッド {@link SetAnnaibi#exec(BizDateYM)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SetAnnaibiTest_exec {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetHurikaebi.class).to(SetHurikaebiMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        SetHurikaebiMockForKhansyuu.caller = SetAnnaibiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        SetHurikaebiMockForKhansyuu.caller = null;
        SetHurikaebiMockForKhansyuu.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();

        SetAnnaibi setAnnaibi = SWAKInjector.getInstance(SetAnnaibi.class);

        setAnnaibi.exec(BizDateYM.valueOf("201810"));

        exDateEquals(setAnnaibi.getSeijyouAnnaibi(), BizDate.valueOf("20180927"), "正常案内日");

        exDateEquals(setAnnaibi.getTinyuuAnnaibi(), BizDate.valueOf("20181027"), "遅入案内日");

        MockObjectManager.assertArgumentPassed(SetHurikaebiMockForKhansyuu.class, "exec", 0, BizDate.valueOf("20181101"));

    }

}
