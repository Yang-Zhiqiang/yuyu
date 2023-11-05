package yuyu.infr.processor;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.classification.C_YuukouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.infr.common.invalidfunctioncheck.InvalidFunctionChecker;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * バッチ実行に伴ってクラスを分離したため、この階層にないクラスをテストする。
 */
@RunWith(SWAKTestRunner.class)
public class InvalidFunctionCheckTest extends AbstractTest{

    @Inject
    private BaseDomManager manager;

    @Override
    protected void beforeAllTest() {
        SWAKInjector.getInstance(BaseUserInfo.class).getUser().setSpecialUserKbn(C_SpecialUserKbn.SUPER);
    }

    @Test
    @TestOrder(1)
    public void test1() {
        AS_Kinou kinou = manager.getKinou("roletouroku");
        KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
        AS_KinouMode kinouModeTbl = kinou.getKinouMode(kinouMode.getKinouMode());
        kinouModeTbl.setYuukouKbn(C_YuukouKbn.DISABLE);
        kinouModeTbl.setYuukouKaisiYmd(null);
        assertFalse(InvalidFunctionChecker.isValid(kinou, kinouModeTbl));
    }

    @Test
    @TestOrder(2)
    public void test2() {
        AS_Kinou kinou = manager.getKinou("roletouroku");
        KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
        AS_KinouMode kinouModeTbl = kinou.getKinouMode(kinouMode.getKinouMode());
        kinouModeTbl.setYuukouKbn(C_YuukouKbn.DISABLE);
        BizDate bizDate = BizDate.getSysDate();
        bizDate = bizDate.addBusinessDays(-1);
        kinouModeTbl.setYuukouKaisiYmd(bizDate);
        assertFalse(InvalidFunctionChecker.isValid(kinou, kinouModeTbl));
    }

    @Test
    @TestOrder(3)
    public void test3() {
        AS_Kinou kinou = manager.getKinou("roletouroku");
        KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
        AS_KinouMode kinouModeTbl = kinou.getKinouMode(kinouMode.getKinouMode());
        kinouModeTbl.setYuukouKbn(C_YuukouKbn.DISABLE);
        BizDate bizDate = BizDate.getSysDate();
        kinouModeTbl.setYuukouKaisiYmd(bizDate);
        assertFalse(InvalidFunctionChecker.isValid(kinou, kinouModeTbl));
    }

    @Test
    @TestOrder(4)
    public void test4() {
        AS_Kinou kinou = manager.getKinou("roletouroku");
        KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
        AS_KinouMode kinouModeTbl = kinou.getKinouMode(kinouMode.getKinouMode());
        kinouModeTbl.setYuukouKbn(C_YuukouKbn.DISABLE);
        BizDate bizDate = BizDate.getSysDate();
        bizDate = bizDate.addBusinessDays(1);
        kinouModeTbl.setYuukouKaisiYmd(bizDate);
        assertFalse(InvalidFunctionChecker.isValid(kinou, kinouModeTbl));
    }

    @Test
    @TestOrder(5)
    public void test5() {
        AS_Kinou kinou = manager.getKinou("roletouroku");
        KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
        AS_KinouMode kinouModeTbl = kinou.getKinouMode(kinouMode.getKinouMode());
        kinouModeTbl.setYuukouKbn(C_YuukouKbn.ENABLE);
        kinouModeTbl.setYuukouKaisiYmd(null);
        assertTrue(InvalidFunctionChecker.isValid(kinou, kinouModeTbl));
    }

    @Test
    @TestOrder(6)
    public void test6() {
        AS_Kinou kinou = manager.getKinou("roletouroku");
        KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
        AS_KinouMode kinouModeTbl = kinou.getKinouMode(kinouMode.getKinouMode());
        kinouModeTbl.setYuukouKbn(C_YuukouKbn.ENABLE);
        BizDate bizDate = BizDate.getSysDate();
        bizDate = bizDate.addBusinessDays(-1);
        kinouModeTbl.setYuukouKaisiYmd(bizDate);
        assertTrue(InvalidFunctionChecker.isValid(kinou, kinouModeTbl));
    }

    @Test
    @TestOrder(7)
    public void test7() {
        AS_Kinou kinou = manager.getKinou("roletouroku");
        KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
        AS_KinouMode kinouModeTbl = kinou.getKinouMode(kinouMode.getKinouMode());
        kinouModeTbl.setYuukouKbn(C_YuukouKbn.ENABLE);
        BizDate bizDate = BizDate.getSysDate();
        kinouModeTbl.setYuukouKaisiYmd(bizDate);
        assertTrue(InvalidFunctionChecker.isValid(kinou, kinouModeTbl));
    }

    @Test
    @TestOrder(8)
    public void test8() {
        AS_Kinou kinou = manager.getKinou("roletouroku");
        KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
        AS_KinouMode kinouModeTbl = kinou.getKinouMode(kinouMode.getKinouMode());
        kinouModeTbl.setYuukouKbn(C_YuukouKbn.ENABLE);
        BizDate bizDate = BizDate.getSysDate();
        bizDate = bizDate.addBusinessDays(1);
        kinouModeTbl.setYuukouKaisiYmd(bizDate);
        assertTrue(InvalidFunctionChecker.isValid(kinou, kinouModeTbl));
    }

    @Test
    @TestOrder(9)
    public void test9() {
        AS_Kinou kinou = manager.getKinou("roletouroku");
        KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
        AS_KinouMode kinouModeTbl = kinou.getKinouMode(kinouMode.getKinouMode());
        kinouModeTbl.setYuukouKbn(C_YuukouKbn.BYDATE);
        kinouModeTbl.setYuukouKaisiYmd(null);

        assertTrue(testRuntimeException(kinou, kinouModeTbl));
    }

    @Test
    @TestOrder(10)
    public void test10() {
        AS_Kinou kinou = manager.getKinou("roletouroku");
        KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
        AS_KinouMode kinouModeTbl = kinou.getKinouMode(kinouMode.getKinouMode());
        kinouModeTbl.setYuukouKbn(C_YuukouKbn.BYDATE);
        BizDate bizDate = BizDate.getSysDate();
        bizDate = bizDate.addBusinessDays(-1);
        kinouModeTbl.setYuukouKaisiYmd(bizDate);
        assertTrue(InvalidFunctionChecker.isValid(kinou, kinouModeTbl));
    }

    @Test
    @TestOrder(11)
    public void test11() {
        AS_Kinou kinou = manager.getKinou("roletouroku");
        KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
        AS_KinouMode kinouModeTbl = kinou.getKinouMode(kinouMode.getKinouMode());
        kinouModeTbl.setYuukouKbn(C_YuukouKbn.BYDATE);
        BizDate bizDate = BizDate.getSysDate();
        kinouModeTbl.setYuukouKaisiYmd(bizDate);
        assertTrue(InvalidFunctionChecker.isValid(kinou, kinouModeTbl));
    }

    @Test
    @TestOrder(12)
    public void test12() {
        AS_Kinou kinou = manager.getKinou("roletouroku");
        KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
        AS_KinouMode kinouModeTbl = kinou.getKinouMode(kinouMode.getKinouMode());
        kinouModeTbl.setYuukouKbn(C_YuukouKbn.BYDATE);
        BizDate bizDate = BizDate.getSysDate();
        bizDate = bizDate.addBusinessDays(1);
        kinouModeTbl.setYuukouKaisiYmd(bizDate);
        assertFalse(InvalidFunctionChecker.isValid(kinou, kinouModeTbl));
    }

    private boolean testRuntimeException(AS_Kinou kinou, AS_KinouMode kinouModeTbl) {
        try {
            InvalidFunctionChecker.isValid(kinou, kinouModeTbl);
        } catch (Exception ex) {
            if (ex instanceof RuntimeException) {
                return true;
            }
        }
        return false;
    }

}
