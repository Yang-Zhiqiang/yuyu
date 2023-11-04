package yuyu.def.biz.manager;

import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.result.bean.UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AT_KinouKengen;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.def.db.entity.WT_KengenKoutei;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        IwfCoreDomManager iwfCoreDomManager = SWAKInjector.getInstance(IwfCoreDomManager.class);

        List<UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean> userList = bizDomManager.getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId("1001", "10001", "222", "12340", "1234567801");

        Assert.assertEquals(0,userList.size());

        AS_Kinou kinou1 = new AS_Kinou("1001");

        AS_KinouMode kinouMode1 = kinou1.createKinouMode();
        kinouMode1.setKinouModeId("10001");

        AT_KinouKengen kinouKengen1 = kinouMode1.createKinouKengen();
        kinouKengen1.setRoleCd("10");

        AT_KinouKengen kinouKengen2 = kinouMode1.createKinouKengen();
        kinouKengen2.setRoleCd("15");

        AS_KinouMode kinouMode3 = kinou1.createKinouMode();
        kinouMode3.setKinouModeId("10000");

        AT_KinouKengen kinouKengen4 = kinouMode3.createKinouKengen();
        kinouKengen4.setRoleCd("10");

        baseDomManager.insert(kinou1);

        AS_Kinou kinou2 = new AS_Kinou("1000");

        AS_KinouMode kinouMode2 = kinou2.createKinouMode();
        kinouMode2.setKinouModeId("10001");

        AT_KinouKengen kinouKengen3 = kinouMode2.createKinouKengen();
        kinouKengen3.setRoleCd("10");

        baseDomManager.insert(kinou2);

        AS_Kinou kinou3 = new AS_Kinou("1002");

        AS_KinouMode kinouMode7 = kinou3.createKinouMode();
        kinouMode7.setKinouModeId("10001");

        AT_KinouKengen kinouKengen5 = kinouMode7.createKinouKengen();
        kinouKengen5.setRoleCd("10");

        AT_KinouKengen kinouKengen6 = kinouMode7.createKinouKengen();
        kinouKengen6.setRoleCd("15");

        AT_KinouKengen kinouKengen7 = kinouMode7.createKinouKengen();
        kinouKengen7.setRoleCd("12");

        baseDomManager.insert(kinou3);

        WT_KengenKoutei kengenKoutei1 = new WT_KengenKoutei("15", "12340", "1234567801");

        iwfCoreDomManager.insert(kengenKoutei1);

        WT_KengenKoutei kengenKoutei2 = new WT_KengenKoutei("12", "12340", "1234567801");

        iwfCoreDomManager.insert(kengenKoutei2);

        WT_KengenKoutei kengenKoutei3 = new WT_KengenKoutei("10", "12340", "1234567801");

        iwfCoreDomManager.insert(kengenKoutei3);

        WT_KengenKoutei kengenKoutei4 = new WT_KengenKoutei("11", "12340", "1234567801");

        iwfCoreDomManager.insert(kengenKoutei4);

        WT_KengenKoutei kengenKoutei5 = new WT_KengenKoutei("10", "10000", "1234567801");

        iwfCoreDomManager.insert(kengenKoutei5);

        WT_KengenKoutei kengenKoutei6 = new WT_KengenKoutei("10", "12340", "1234567800");

        iwfCoreDomManager.insert(kengenKoutei6);

        AM_User user1 = new AM_User("111");
        user1.setUserNm("ユーザー名１");
        user1.setPassword("123456");

        AT_UserRole userRole1 = user1.createUserRole();
        userRole1.setRoleCd("10");

        AT_UserRole userRole2 = user1.createUserRole();
        userRole2.setRoleCd("15");

        baseDomManager.insert(user1);

        AM_User user2 = new AM_User("222");
        user2.setUserNm("ユーザー名２");
        user2.setPassword("123456");

        AT_UserRole userRole3 = user2.createUserRole();
        userRole3.setRoleCd("10");

        baseDomManager.insert(user2);

        AM_User user3 = new AM_User("333");
        user3.setUserNm("ユーザー名３");
        user3.setPassword("123456");

        baseDomManager.insert(user3);

        AT_UserRole userRole5 = user3.createUserRole();
        userRole5.setRoleCd("12");

        baseDomManager.insert(user3);

        AM_User user4 = new AM_User("444");
        user4.setUserNm("ユーザー名４");
        user4.setPassword("123456");

        AT_UserRole userRole4 = user4.createUserRole();
        userRole4.setRoleCd("12");

        baseDomManager.insert(user4);

        AM_Role role1 = new AM_Role("10");
        role1.setRoleNm("ロール名１");

        baseDomManager.insert(role1);

        AM_Role role2 = new AM_Role("11");
        role2.setRoleNm("ロール名２");

        baseDomManager.insert(role2);

        AM_Role role3 = new AM_Role("12");
        role3.setRoleNm("ロール名３");

        baseDomManager.insert(role3);

        AM_Role role4 = new AM_Role("15");
        role4.setRoleNm("ロール名５");

        baseDomManager.insert(role4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        IwfCoreDomManager iwfCoreDomManager = SWAKInjector.getInstance(IwfCoreDomManager.class);
        baseDomManager.delete(baseDomManager.getAllUsers());
        baseDomManager.delete(baseDomManager.getAllKinous());
        baseDomManager.delete(baseDomManager.getAllRoles());
        iwfCoreDomManager.delete(iwfCoreDomManager.getAllKengenKoutei());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean> userList = bizDomManager.getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId("1002", "10002", "222", "12340", "1234567801");

        Assert.assertEquals(0,userList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean> userList = bizDomManager.getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId("1001", "10001", "222", "12340", "1234567801");

        Assert.assertEquals(1, userList.size());

        Assert.assertEquals("111", userList.get(0).getUserId());
        Assert.assertEquals("ユーザー名１", userList.get(0).getUserNm());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean> userList = bizDomManager.getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId("1002", "10001", "444", "12340", "1234567801");

        Assert.assertEquals(3,userList.size());

        Assert.assertEquals("111", userList.get(0).getUserId());
        Assert.assertEquals("ユーザー名１", userList.get(0).getUserNm());
        Assert.assertEquals("222", userList.get(1).getUserId());
        Assert.assertEquals("ユーザー名２", userList.get(1).getUserNm());
        Assert.assertEquals("333", userList.get(2).getUserId());
        Assert.assertEquals("ユーザー名３", userList.get(2).getUserNm());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean> userList = bizDomManager.getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId("", "10001", "444", "12340", "1234567801");

        Assert.assertEquals(0,userList.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean> userList = bizDomManager.getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId("1001", "", "444", "12340", "1234567801");

        Assert.assertEquals(0,userList.size());

    }

    @Test
    @TestOrder(60)
    public void blankCondition3() {

        List<UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean> userList = bizDomManager.getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId("1001", "10001", "", "12340", "1234567801");

        Assert.assertEquals(2, userList.size());

    }

    @Test
    @TestOrder(70)
    public void blankCondition4() {

        List<UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean> userList = bizDomManager.getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId("1001", "10001", "444", "", "1234567801");

        Assert.assertEquals(0,userList.size());

    }

    @Test
    @TestOrder(80)
    public void blankCondition5() {

        List<UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean> userList = bizDomManager.getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId("1001", "10001", "444", "12340", "");

        Assert.assertEquals(0,userList.size());

    }
}
