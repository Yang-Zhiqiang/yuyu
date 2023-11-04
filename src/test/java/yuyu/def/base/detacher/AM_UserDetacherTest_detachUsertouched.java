package yuyu.def.base.detacher;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_User;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ユーザーマスタ(AM_User) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class AM_UserDetacherTest_detachUsertouched {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AM_User user1 = new AM_User("UI00000001");
        user1.setUserNm("テストユーザ１");
        user1.setPassword("PWD0000001");

        baseDomManager.insert(user1);

        AM_User user2 = new AM_User("UI00000002");
        user2.setUserNm("テストユーザ２");
        user2.setPassword("PWD0000002");

        baseDomManager.insert(user2);



    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllUsers());
    }

    @Test
    @TestOrder(10)
    public void testDetach() {

        AM_User user = baseDomManager.getUser("UI00000001");

        if (user != null) {
            user = AM_UserDetacher.detachUsertouched(user);

            ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

            boolean result = em.getEntityManager().contains(user);

            Assert.assertFalse(result);
        }
        else {
            Assert.assertTrue(false);
        }
    }
    @Test
    @TestOrder(20)
    public void testDetach2() {

        AM_User user = baseDomManager.getUser("UI00000003");

        user = AM_UserDetacher.detachUsertouched(user);

        Assert.assertNull(user);
    }
}
