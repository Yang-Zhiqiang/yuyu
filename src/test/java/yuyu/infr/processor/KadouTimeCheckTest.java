package yuyu.infr.processor;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.auth.Credentials;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

@RunWith(SWAKTestRunner.class)
public class KadouTimeCheckTest extends AbstractTest{

    @Inject
    private static Logger logger;

    @Inject
    private Credentials credentials;

    @Inject
    private BaseDomManager manager;

    @Inject
    private KadouTimeCheck kadouTimeCheck;

    @Override
    protected void beforeAllTest() {
        SWAKInjector.getInstance(BaseUserInfo.class).getUser().setSpecialUserKbn(C_SpecialUserKbn.SUPER);
    }

    @Test
    @TestOrder(1)
    public void test1() {
        logger.debug("credentials.username = {}", credentials.getUsername());

        AS_Kinou kinou = manager.getKinou("holidaygrouptouroku");

        KinouMode kinouMode = new KinouMode();

        boolean chkKadouTimeFlg = kadouTimeCheck.isKadouTime("20130530161328", kinou,kinouMode);
        exBooleanEquals(chkKadouTimeFlg,true ,"チェック結果");
    }

    @Test
    @TestOrder(2)
    public void test2() {
        logger.debug("credentials.username = {}", credentials.getUsername());

        AS_Kinou kinou = manager.getKinou("holidaygrouptouroku");

        KinouMode kinouMode = new KinouMode();

        boolean chkKadouTimeFlg = kadouTimeCheck.isKadouTime("20130604161328", kinou,kinouMode);
        exBooleanEquals(chkKadouTimeFlg,true ,"チェック結果");
    }

    @Test
    @TestOrder(3)
    public void test3() {
        logger.debug("credentials.username = {}", credentials.getUsername());

        AS_Kinou kinou = manager.getKinou("holidaygrouptouroku");

        KinouMode kinouMode = new KinouMode();

        boolean chkKadouTimeFlg = kadouTimeCheck.isKadouTime("20130604120028", kinou, kinouMode);
        exBooleanEquals(chkKadouTimeFlg,true ,"チェック結果");
    }

    @Test
    @TestOrder(4)
    public void test4() {
        logger.debug("credentials.username = {}", credentials.getUsername());

        AS_Kinou kinou = manager.getKinou("holidaygrouptouroku");

        KinouMode kinouMode = new KinouMode();

        boolean chkKadouTimeFlg = kadouTimeCheck.isKadouTime("20130604120128", kinou, kinouMode);
        exBooleanEquals(chkKadouTimeFlg,true ,"チェック結果");
    }

    @Test
    @TestOrder(5)
    public void test5() {
        logger.debug("credentials.username = {}", credentials.getUsername());

        AS_Kinou kinou = manager.getKinou("holidaygrouptouroku");

        KinouMode kinouMode = new KinouMode();

        boolean chkKadouTimeFlg = kadouTimeCheck.isKadouTime("20130604195959", kinou, kinouMode);
        exBooleanEquals(chkKadouTimeFlg,true ,"チェック結果");
    }

    @Test
    @TestOrder(6)
    public void test6() {

        logger.debug("credentials.username = {}", credentials.getUsername());

        AS_Kinou kinou = manager.getKinou("holidaygrouptouroku");

        KinouMode kinouMode = new KinouMode();

        boolean chkKadouTimeFlg = kadouTimeCheck.isKadouTime("20130604200001", kinou, kinouMode);
        exBooleanEquals(chkKadouTimeFlg,false ,"チェック結果");
    }

    @Test(expected = RuntimeException.class)
    @TestOrder(7)
    public void test7() {
        logger.debug("credentials.username = {}", credentials.getUsername());

        AS_Kinou kinou = manager.getKinou("kinouteigitouroku");

        KinouMode kinouMode = new KinouMode();

        kadouTimeCheck.isKadouTime("20130604200001", kinou, kinouMode);
    }

    @Test
    @TestOrder(8)
    public void test8() {
        logger.debug("credentials.username = {}", credentials.getUsername());

        AS_Kinou kinou = manager.getKinou("kinouteigitouroku");

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("default1");

        boolean chkKadouTimeFlg = kadouTimeCheck.isKadouTime("20130601200001", kinou, kinouMode);
        exBooleanEquals(chkKadouTimeFlg,false ,"チェック結果");
    }

    @Test
    @TestOrder(9)
    public void test9() {
        logger.debug("credentials.username = {}", credentials.getUsername());

        AS_Kinou kinou = manager.getKinou("kadoutimetouroku");

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("default2");

        boolean chkKadouTimeFlg = kadouTimeCheck.isKadouTime("20130601200001", kinou, kinouMode);
        exBooleanEquals(chkKadouTimeFlg,true ,"チェック結果");
    }
    @Test
    @TestOrder(10)
    public void test10() {
        logger.debug("credentials.username = {}", credentials.getUsername());

        AS_Kinou kinou = manager.getKinou("kadoutimetouroku");

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("default2");

        boolean chkKadouTimeFlg = kadouTimeCheck.isKadouTime("20130602200001", kinou, kinouMode);
        exBooleanEquals(chkKadouTimeFlg,true ,"チェック結果");
    }

    @Test
    @TestOrder(11)
    public void test11() {
        logger.debug("credentials.username = {}", credentials.getUsername());

        AS_Kinou kinou = manager.getKinou("kadoutimetouroku");

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("default2");

        boolean chkKadouTimeFlg = kadouTimeCheck.isKadouTime("20130605200001", kinou, kinouMode);
        exBooleanEquals(chkKadouTimeFlg,true ,"チェック結果");
    }

    @Test
    @TestOrder(12)
    public void test12() {
        logger.debug("credentials.username = {}", credentials.getUsername());

        AS_Kinou kinou = manager.getKinou("kadoutimetouroku");

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("default2");

        boolean chkKadouTimeFlg = kadouTimeCheck.isKadouTime("20130606200001", kinou, kinouMode);
        exBooleanEquals(chkKadouTimeFlg,true ,"チェック結果");
    }

    @Test
    @TestOrder(13)
    public void test13() {
        logger.debug("credentials.username = {}", credentials.getUsername());

        AS_Kinou kinou = manager.getKinou("kadoutimetouroku");

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("default2");

        boolean chkKadouTimeFlg = kadouTimeCheck.isKadouTime("20130607200001", kinou, kinouMode);
        exBooleanEquals(chkKadouTimeFlg,false ,"チェック結果");
    }
}
