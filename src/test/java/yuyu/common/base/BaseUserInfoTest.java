package yuyu.common.base;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.auth.SubSystem;
import yuyu.testinfr.YuyuFunctionTestUtil;

/**
 * Injector から BaseUserInfo を取得するテストです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseUserInfoTest {

    @Inject
    private static Logger logger;

    @Inject
    private BaseUserInfo loginUserInfo;

    @Inject
    private BaseDomManager manager;

    @Test
    public void test00() {
        logger.debug("loginUserInfo        = {}", loginUserInfo);
        logger.debug("loginUserInfo.userId = {}", loginUserInfo.getUserId());
        logger.debug("loginUserInfo.userNm = {}", loginUserInfo.getUserNm());
        logger.debug("loginUserInfo.user   = {}", loginUserInfo.getUser());

        assertEquals("loginUserInfo.userId", "JUnit", loginUserInfo.getUserId());
        assertEquals("loginUserInfo.userNm", "JUnit", loginUserInfo.getUserNm());
        assertEquals("loginUserInfo.user.specialUserKbn", C_SpecialUserKbn.TOKKEN, loginUserInfo.getUser().getSpecialUserKbn());

    }

    @Inject
    private AS_Kinou currentKinou;

    @Test
    public void test01_ChangeCurrentUser() {

        currentKinou.setKinouId("usertouroku");

        YuyuFunctionTestUtil.changeCurrentUser(loginUserInfo, manager.getUser("administrator"));

        boolean b = loginUserInfo.hasAuthenticatedFunctionMode("default");
        exBooleanEquals(b, true, "認証結果");

        List<String> list = loginUserInfo.getAuthenticatedFunctionModes();
        exStringEquals(list.get(0), "default", "機能モード");

        list = loginUserInfo.getAuthenticatedFunctionModes("usertouroku");
        exStringEquals(list.get(0), "default", "機能モード");

        List<SubSystem> subSystem = loginUserInfo.getAuthenticatedSubSystems();
        exStringEquals(subSystem.get(0).getSubSystemId(), "base", "サブシステム");
    }

    @Test
    public void test02_getAuthenticatedFunctionModes() {

        assertEquals("AuthenticatedFunctionModes", 0, loginUserInfo.getAuthenticatedFunctionModes().size());
        assertEquals("AuthenticatedFunctionModes", 1, loginUserInfo.getAuthenticatedFunctionModes("usertouroku").size());
        assertFalse( "AuthenticatedFunctionModes", loginUserInfo.hasAuthenticatedFunctionMode("default"));
        assertFalse( "AuthenticatedFunctionModes", loginUserInfo.hasAuthenticatedFunctionMode());
        assertTrue(  "AuthenticatedFunctionModes", loginUserInfo.hasAuthenticatedFunctionModeByFunctionId("usertouroku", "default", ""));

        // assertNotEquals("AuthenticatedFunctionModes", 0, ss.size());

    }

    @Test
    public void test03_ExEquals() {
        BizDate bizDate = BizDate.getSysDate();

        BizDateY bizDateY1 = bizDate.getBizDateY();
        BizDateY bizDateY2 = bizDate.getBizDateY();
        exDateYEquals(bizDateY1, bizDateY2, "BizDateY");

        BizDateYM bizDateYM1 = bizDate.getBizDateYM();
        BizDateYM bizDateYM2 = bizDate.getBizDateYM();
        exDateYMEquals(bizDateYM1, bizDateYM2, "BizDateYM");

        BizDateMD bizDateMD1 = bizDate.getBizDateMD();
        BizDateMD bizDateMD2 = bizDate.getBizDateMD();
        assertEquals(bizDateMD1, bizDateMD2);
        exDateMDEquals(bizDateMD1, bizDateMD2, "BizDateMD");

        BizDateSpan span1 = new BizDateSpan(1, 2, 3);
        BizDateSpan span2 = new BizDateSpan(1, 2, 3);
        exDateSpanEquals(span1, span2, "BizDateSpan");
    }

}
