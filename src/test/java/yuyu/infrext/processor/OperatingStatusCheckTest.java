package yuyu.infrext.processor;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_OnlineStatusKbn;
import yuyu.def.db.dao.AT_RinjiKadouTaisyoSosikiDao;
import yuyu.def.db.dao.AT_SystemControlInfoDao;
import yuyu.def.db.entity.AT_RinjiKadouTaisyoSosiki;
import yuyu.def.db.entity.AT_SystemControlInfo;
import yuyu.infr.auth.RayHttpHeaderBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * 稼動状態チェッククラス<br />
 * コントロール情報テーブルのオンライン状態区分を参照し、<br />
 * オンライン中であるかを判定します。<br />
 */
@RunWith(SWAKTestRunner.class)
public class OperatingStatusCheckTest extends AbstractTest {

    private static final String SYSTEM_CTRLINFO_KEY = "ctrlInfo";
    @Inject
    private OperatingStatusCheck operatingStatusCheck;
    @Inject
    private BaseDomManager manager;

    @Inject
    private AT_RinjiKadouTaisyoSosikiDao rinjiKadouDao;
    @Inject
    private AT_SystemControlInfoDao systemControlDao;

    private BaseUserInfo userInfo;

    private static final C_OnlineStatusKbn[] onlineStatusKbn = new C_OnlineStatusKbn[] {
        C_OnlineStatusKbn.ONLINE_HUKA,
        C_OnlineStatusKbn.ONLINE_KA,
        C_OnlineStatusKbn.ONLINE_KA_SOSIKI,
        C_OnlineStatusKbn.ONLINE_KA_SOSIKI
    };
    private static int count = 0;

    @Before
    @Transactional
    public void beforeTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        RayHttpHeaderBean bean = SWAKInjector.getInstance(RayHttpHeaderBean.class);
        Method method = bean.getClass().getDeclaredMethod("setTmSosikiCd", String.class);
        method.setAccessible(true);
        method.invoke(bean, "Test");

        userInfo = SWAKInjector.getInstance(BaseUserInfo.class);


        AT_SystemControlInfo systemInfo = systemControlDao.getSystemControlInfo(SYSTEM_CTRLINFO_KEY);
        systemInfo.setOnlineStatus(onlineStatusKbn[count++].toString());
        manager.update(systemInfo);
    }

    @Test
    @TestOrder(1)
    @Transactional
    public void test1() {
        assertFalse(operatingStatusCheck.isOnlineOpenOnOnline());
    }

    @Test
    @TestOrder(2)
    @Transactional
    public void test2() {
        assertTrue(operatingStatusCheck.isOnlineOpenOnOnline());
    }

    @Test
    @TestOrder(3)
    @Transactional
    public void test3() {
        String sosikiCd = userInfo.getTmSosikiCd();
        AT_RinjiKadouTaisyoSosiki rinjiSosiki = rinjiKadouDao.getRinjiKadouTaisyoSosiki(sosikiCd);

        if (rinjiSosiki != null) {
            manager.delete(rinjiSosiki);
            manager.flush();
        }

        assertFalse(operatingStatusCheck.isOnlineOpenOnOnline());

        if (rinjiSosiki != null) {
            manager.insert(rinjiSosiki);
        }

    }

    @Test
    @TestOrder(4)
    @Transactional
    public void test4() {
        String sosikiCd = userInfo.getTmSosikiCd();
        AT_RinjiKadouTaisyoSosiki rinjiSosiki = rinjiKadouDao.getRinjiKadouTaisyoSosiki(sosikiCd);
        boolean insFlg = false;
        if (rinjiSosiki == null) {
            rinjiSosiki = new AT_RinjiKadouTaisyoSosiki();
            rinjiSosiki.setKadouSosikiCd(sosikiCd);
            manager.insert(rinjiSosiki);
            insFlg = true;
            manager.flush();
        }

        assertTrue(operatingStatusCheck.isOnlineOpenOnOnline());

        if (insFlg) {
            manager.delete(rinjiSosiki);
        }
    }

}
