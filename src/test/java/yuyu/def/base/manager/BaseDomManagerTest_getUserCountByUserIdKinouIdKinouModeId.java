package yuyu.def.base.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AT_KinouKengen;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BaseDomManagerクラスの、<br />
 * getUserCountByUserIdKinouIdKinouModeId() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BaseDomManagerTest_getUserCountByUserIdKinouIdKinouModeId {

    @Inject
    private BaseDomManager baseDomManager;

    private static String pUserId1 = "UI00000001";
    private static String pUserId2 = "UI00000002";
    private static String pUserId3 = "UI00000003";

    private static String pUserNm1 = "テストユーザ１";
    private static String pUserNm2 = "テストユーザ２";
    private static String pUserNm3 = "テストユーザ３";

    private static String pPassword1 = "PWD0000001";
    private static String pPassword2 = "PWD0000002";
    private static String pPassword3 = "PWD0000003";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        Long count = baseDomManager.getUserCountByUserIdKinouIdKinouModeId(pUserId1, "A1000000001", "B1000000001");
        Assert.assertEquals(new Long(0), count);

        AM_User user1 = new AM_User();
        user1.setUserId(pUserId1);
        user1.setUserNm(pUserNm1);
        user1.setPassword(pPassword1);
        AT_UserRole userRole1 = user1.createUserRole();
        userRole1.setRoleCd("C1000000001");

        baseDomManager.insert(user1);

        AM_User user2 = new AM_User();
        user2.setUserId(pUserId2);
        user2.setUserNm(pUserNm2);
        user2.setPassword(pPassword2);
        AT_UserRole userRole2 = user2.createUserRole();
        userRole2.setRoleCd("C1000000002");

        AT_UserRole userRole3 = user2.createUserRole();
        userRole3.setRoleCd("C1000000003");

        AT_UserRole userRole4 = user2.createUserRole();
        userRole4.setRoleCd("C1000000004");

        baseDomManager.insert(user2);

        AM_User user3 = new AM_User();
        user3.setUserId(pUserId3);
        user3.setUserNm(pUserNm3);
        user3.setPassword(pPassword3);
        AT_UserRole userRole5 = user3.createUserRole();
        userRole5.setRoleCd("C1000000001");

        baseDomManager.insert(user3);

        AM_Role role1 = new AM_Role();
        role1.setRoleCd("C1000000001");
        baseDomManager.insert(role1);

        AM_Role role2 = new AM_Role();
        role2.setRoleCd("C1000000002");
        baseDomManager.insert(role2);

        AM_Role role3 = new AM_Role();
        role3.setRoleCd("C1000000003");
        baseDomManager.insert(role3);

        AM_Role role4 = new AM_Role();
        role4.setRoleCd("C1000000004");
        baseDomManager.insert(role4);

        AM_Role role5 = new AM_Role();
        role5.setRoleCd("C1000000005");
        baseDomManager.insert(role5);

        AT_KinouKengen kinouKengen1 = new AT_KinouKengen();
        kinouKengen1.setKinouId("A1000000001");
        kinouKengen1.setKinouModeId("B1000000001");
        kinouKengen1.setRoleCd("C1000000001");
        baseDomManager.insert(kinouKengen1);

        AT_KinouKengen kinouKengen2 = new AT_KinouKengen();
        kinouKengen2.setKinouId("A1000000003");
        kinouKengen2.setKinouModeId("B1000000003");
        kinouKengen2.setRoleCd("C1000000002");
        baseDomManager.insert(kinouKengen2);

        AT_KinouKengen kinouKengen3 = new AT_KinouKengen();
        kinouKengen3.setKinouId("A1000000003");
        kinouKengen3.setKinouModeId("B1000000003");
        kinouKengen3.setRoleCd("C1000000003");
        baseDomManager.insert(kinouKengen3);

        AT_KinouKengen kinouKengen4 = new AT_KinouKengen();
        kinouKengen4.setKinouId("A1000000003");
        kinouKengen4.setKinouModeId("B1000000003");
        kinouKengen4.setRoleCd("C1000000004");
        baseDomManager.insert(kinouKengen4);

        AS_Kinou kinou1 = new AS_Kinou("A1000000001");
        AS_KinouMode KinouMode1 = kinou1.createKinouMode();
        KinouMode1.setKinouModeId("B1000000001");

        AS_KinouMode KinouMode2 = kinou1.createKinouMode();
        KinouMode2.setKinouModeId("B1000000002");

        baseDomManager.insert(kinou1);

        AS_Kinou kinou2 = new AS_Kinou("A1000000002");
        AS_KinouMode KinouMode3 = kinou2.createKinouMode();
        KinouMode3.setKinouModeId("B1000000001");

        baseDomManager.insert(kinou2);


        AS_Kinou kinou3 = new AS_Kinou("A1000000003");
        AS_KinouMode KinouMode4 = kinou3.createKinouMode();
        KinouMode4.setKinouModeId("B1000000003");

        baseDomManager.insert(kinou3);

    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllUsers());
        baseDomManager.delete(baseDomManager.getAllRoles());
        baseDomManager.delete(baseDomManager.getAllKinous());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        Long count = baseDomManager.getUserCountByUserIdKinouIdKinouModeId(pUserId2, "A1000000001", "B1000000003");
        Assert.assertEquals(new Long(0), count);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Long count = baseDomManager.getUserCountByUserIdKinouIdKinouModeId(pUserId1, "A1000000001", "B1000000001");
        Assert.assertEquals(new Long(1), count);
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        Long count = baseDomManager.getUserCountByUserIdKinouIdKinouModeId(pUserId2, "A1000000003", "B1000000003");
        Assert.assertEquals(new Long(3), count);
    }
    @Test
    @TestOrder(40)
    public void blanktest1() {

        Long count = baseDomManager.getUserCountByUserIdKinouIdKinouModeId("", "A1000000001", "B1000000001");
        Assert.assertEquals(new Long(0), count);
    }
    @Test
    @TestOrder(50)
    public void blanktest2() {

        Long count = baseDomManager.getUserCountByUserIdKinouIdKinouModeId(pUserId1, "", "B1000000001");
        Assert.assertEquals(new Long(0), count);
    }
    @Test
    @TestOrder(60)
    public void blanktest3() {

        Long count = baseDomManager.getUserCountByUserIdKinouIdKinouModeId(pUserId1, "A1000000001", "");
        Assert.assertEquals(new Long(0), count);
    }
}

