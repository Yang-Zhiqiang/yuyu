package yuyu.def.biz.manager;

import static org.junit.Assert.*;

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
import yuyu.def.biz.result.bean.UsersByKinouIdKinouModeIdUserIdBean;
import yuyu.def.db.entity.AM_IdCard;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AT_KinouKengen;
import yuyu.def.db.entity.AT_UserIdKanren;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getUsersByKinouIdKinouModeIdUserId() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getUsersByKinouIdKinouModeIdUserId {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        deleteTestSubData();

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<UsersByKinouIdKinouModeIdUserIdBean> beanLst = bizDomManager.getUsersByKinouIdKinouModeIdUserId("1001", "10001", "A001");

        Assert.assertEquals(0, beanLst.size());

        AS_Kinou kinou1 = new AS_Kinou("1001");

        AS_KinouMode kinouMode1 = kinou1.createKinouMode();
        kinouMode1.setKinouModeId("10001");

        AT_KinouKengen kinouKengen1 = kinouMode1.createKinouKengen();
        kinouKengen1.setRoleCd("88");

        AT_KinouKengen kinouKengen2 = kinouMode1.createKinouKengen();
        kinouKengen2.setRoleCd("99");

        AS_KinouMode kinouMode2 = kinou1.createKinouMode();
        kinouMode2.setKinouModeId("10002");

        AT_KinouKengen kinouKengen3 = kinouMode2.createKinouKengen();
        kinouKengen3.setRoleCd("88");

        baseDomManager.insert(kinou1);

        AS_Kinou kinou2 = new AS_Kinou("1002");

        AS_KinouMode kinouMode3 = kinou2.createKinouMode();
        kinouMode3.setKinouModeId("10001");

        AT_KinouKengen kinouKengen4 = kinouMode3.createKinouKengen();
        kinouKengen4.setRoleCd("88");

        baseDomManager.insert(kinou2);

        AS_Kinou kinou3 = new AS_Kinou("1003");

        AS_KinouMode kinouMode4 = kinou3.createKinouMode();
        kinouMode4.setKinouModeId("10003");

        AT_KinouKengen kinouKengen5 = kinouMode4.createKinouKengen();
        kinouKengen5.setRoleCd("77");

        AT_KinouKengen kinouKengen6 = kinouMode4.createKinouKengen();
        kinouKengen6.setRoleCd("55");

        AT_KinouKengen kinouKengen7 = kinouMode4.createKinouKengen();
        kinouKengen7.setRoleCd("66");

        baseDomManager.insert(kinou3);

        AM_User user1 = new AM_User("111");
        user1.setUserNm("ユーザー名１");
        user1.setPassword("123456");

        AT_UserRole userRole1 = user1.createUserRole();
        userRole1.setRoleCd("88");

        AT_UserRole userRole2 = user1.createUserRole();
        userRole2.setRoleCd("99");

        AT_UserRole userRole3 = user1.createUserRole();
        userRole3.setRoleCd("100");

        baseDomManager.insert(user1);

        AM_User user2 = new AM_User("222");
        user2.setUserNm("ユーザー名２");
        user2.setPassword("123456");

        baseDomManager.insert(user2);

        AM_User user3 = new AM_User("A001");
        user3.setUserNm("ユーザー名２");
        user3.setPassword("123456");

        AT_UserRole userRole4 = user3.createUserRole();
        userRole4.setRoleCd("99");

        baseDomManager.insert(user3);

        AM_User user4 = new AM_User("1008");
        user4.setUserNm("ユーザー名３");
        user4.setPassword("123456");

        AT_UserRole userRole5 = user4.createUserRole();
        userRole5.setRoleCd("77");

        baseDomManager.insert(user4);

        AM_User user5 = new AM_User("1007");
        user5.setUserNm("ユーザー名４");
        user5.setPassword("123456");

        AT_UserRole userRole6 = user5.createUserRole();
        userRole6.setRoleCd("55");

        baseDomManager.insert(user5);

        AM_User user6 = new AM_User("1006");
        user6.setUserNm("ユーザー名５");
        user6.setPassword("123456");

        AT_UserRole userRole7 = user6.createUserRole();
        userRole7.setRoleCd("66");

        baseDomManager.insert(user6);

        AM_Role role1 = new AM_Role("88");
        role1.setRoleNm("ロール名１");

        baseDomManager.insert(role1);

        AM_Role role2 = new AM_Role("99");
        role2.setRoleNm("ロール名２");

        baseDomManager.insert(role2);

        AM_Role role3 = new AM_Role("100");
        role3.setRoleNm("ロール名６");

        baseDomManager.insert(role3);

        AM_Role role4 = new AM_Role("66");
        role4.setRoleNm("ロール名３");

        baseDomManager.insert(role4);

        AM_Role role5 = new AM_Role("77");
        role5.setRoleNm("ロール名４");

        baseDomManager.insert(role5);

        AM_Role role6 = new AM_Role("55");
        role6.setRoleNm("ロール名５");

        baseDomManager.insert(role6);

        AT_UserIdKanren userIdKanren1 = new AT_UserIdKanren();
        userIdKanren1.setIdkbn("11");
        userIdKanren1.setIdcd("1");
        userIdKanren1.setUserId("111");

        baseDomManager.insert(userIdKanren1);

        AT_UserIdKanren userIdKanren2 = new AT_UserIdKanren();
        userIdKanren2.setIdkbn("A0");
        userIdKanren2.setIdcd("01");
        userIdKanren2.setUserId("A001");

        baseDomManager.insert(userIdKanren2);

        AT_UserIdKanren userIdKanren3 = new AT_UserIdKanren();
        userIdKanren3.setIdkbn("10");
        userIdKanren3.setIdcd("08");
        userIdKanren3.setUserId("1008");

        baseDomManager.insert(userIdKanren3);

        AT_UserIdKanren userIdKanren4 = new AT_UserIdKanren();
        userIdKanren4.setIdkbn("10");
        userIdKanren4.setIdcd("07");
        userIdKanren4.setUserId("1007");

        baseDomManager.insert(userIdKanren4);

        AT_UserIdKanren userIdKanren5 = new AT_UserIdKanren();
        userIdKanren5.setIdkbn("10");
        userIdKanren5.setIdcd("06");
        userIdKanren5.setUserId("1006");

        baseDomManager.insert(userIdKanren5);

        AM_IdCard idCard1 = new AM_IdCard();
        idCard1.setIdkbn("11");
        idCard1.setIdcd("1");
        idCard1.setSyozokusosikicd("3330000");

        baseDomManager.insert(idCard1);

        AM_IdCard idCard2 = new AM_IdCard();
        idCard2.setIdkbn("A0");
        idCard2.setIdcd("01");
        idCard2.setSyozokusosikicd("3330000");

        baseDomManager.insert(idCard2);

        AM_IdCard idCard3 = new AM_IdCard();
        idCard3.setIdkbn("10");
        idCard3.setIdcd("08");
        idCard3.setSyozokusosikicd("2220000");

        baseDomManager.insert(idCard3);

        AM_IdCard idCard4 = new AM_IdCard();
        idCard4.setIdkbn("10");
        idCard4.setIdcd("07");
        idCard4.setSyozokusosikicd("1110000");

        baseDomManager.insert(idCard4);

        AM_IdCard idCard5 = new AM_IdCard();
        idCard5.setIdkbn("10");
        idCard5.setIdcd("06");
        idCard5.setSyozokusosikicd("2220000");

        baseDomManager.insert(idCard5);

        AM_Sosiki sosiki1 = new AM_Sosiki("1110000");
        sosiki1.setKanjisosikinm20("組織名１");

        baseDomManager.insert(sosiki1);

        AM_Sosiki sosiki2 = new AM_Sosiki("2220000");
        sosiki2.setKanjisosikinm20("組織名２");

        baseDomManager.insert(sosiki2);

        AM_Sosiki sosiki3 = new AM_Sosiki("3330000");
        sosiki3.setKanjisosikinm20("組織名３");

        baseDomManager.insert(sosiki3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){
        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<UsersByKinouIdKinouModeIdUserIdBean> beanLst = bizDomManager.getUsersByKinouIdKinouModeIdUserId("1004", "10001", "A001");

        Assert.assertEquals(0, beanLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<UsersByKinouIdKinouModeIdUserIdBean> beanLst = bizDomManager.getUsersByKinouIdKinouModeIdUserId("1001", "10001", "A001");

        Assert.assertEquals(1, beanLst.size());
        assertEquals("111", beanLst.get(0).getUserId());
        assertEquals("ユーザー名１", beanLst.get(0).getUserNm());
        assertEquals("3330000", beanLst.get(0).getSosikiCd());
        assertEquals("組織名３", beanLst.get(0).getSosikiNm());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<UsersByKinouIdKinouModeIdUserIdBean> beanLst = bizDomManager.getUsersByKinouIdKinouModeIdUserId("1003", "10003", "A001");

        Assert.assertEquals(3, beanLst.size());
        assertEquals("1007", beanLst.get(0).getUserId());
        assertEquals("ユーザー名４", beanLst.get(0).getUserNm());
        assertEquals("1110000", beanLst.get(0).getSosikiCd());
        assertEquals("組織名１", beanLst.get(0).getSosikiNm());

        assertEquals("1006", beanLst.get(1).getUserId());
        assertEquals("ユーザー名５", beanLst.get(1).getUserNm());
        assertEquals("2220000", beanLst.get(1).getSosikiCd());
        assertEquals("組織名２", beanLst.get(1).getSosikiNm());

        assertEquals("1008", beanLst.get(2).getUserId());
        assertEquals("ユーザー名３", beanLst.get(2).getUserNm());
        assertEquals("2220000", beanLst.get(2).getSosikiCd());
        assertEquals("組織名２", beanLst.get(2).getSosikiNm());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<UsersByKinouIdKinouModeIdUserIdBean> beanLst = bizDomManager.getUsersByKinouIdKinouModeIdUserId("", "10001", "A001");

        Assert.assertEquals(0, beanLst.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<UsersByKinouIdKinouModeIdUserIdBean> beanLst = bizDomManager.getUsersByKinouIdKinouModeIdUserId("1001", "", "A001");

        Assert.assertEquals(0, beanLst.size());

    }

    @Test
    @TestOrder(60)
    public void blankCondition3() {

        List<UsersByKinouIdKinouModeIdUserIdBean> beanLst = bizDomManager.getUsersByKinouIdKinouModeIdUserId("1004", "10001", "");

        Assert.assertEquals(0, beanLst.size());

    }

    @Transactional
    public static void deleteTestSubData(){
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        List<AM_User> userLst = baseDomManager.getAllUsers();
        if(userLst.size() > 0 ) {
            baseDomManager.delete(userLst);
        }

        List<AS_Kinou> kinouLst = baseDomManager.getAllKinous();
        if(kinouLst.size() > 0 ) {
            baseDomManager.delete(kinouLst);
        }

        List<AM_Role> roleLst = baseDomManager.getAllRoles();
        if(roleLst.size() > 0 ) {
            baseDomManager.delete(roleLst);
        }
        List<AT_UserIdKanren> userIdKanrenLst = baseDomManager.getAllUserIdKanrens();
        if(userIdKanrenLst.size() > 0 ) {
            baseDomManager.delete(userIdKanrenLst);
        }

        List<AM_IdCard> idCardLst = baseDomManager.getAllIdCards();
        if(idCardLst.size() > 0 ) {
            baseDomManager.delete(idCardLst);
        }

        List<AM_Sosiki> sosikiLst = baseDomManager.getAllSosikis();
        if(sosikiLst.size() > 0 ) {
            baseDomManager.delete(sosikiLst);
        }
    }

}
