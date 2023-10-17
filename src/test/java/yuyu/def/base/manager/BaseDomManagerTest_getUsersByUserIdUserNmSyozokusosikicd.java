package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AM_IdCard;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AT_UserIdKanren;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BaseDomManagerクラスの、<br />
 * getUsersByUserIdUserNmSyozokusosikicd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BaseDomManagerTest_getUsersByUserIdUserNmSyozokusosikicd {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        List<AM_User> userLst = baseDomManager.getUsersByUserIdUserNmSyozokusosikicd("A", "い", "30");
        assertEquals(0, userLst.size());

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AM_User user1 = new AM_User("ABB");
        user1.setUserNm("あ");
        user1.setUserGroupCd("1");
        user1.setPassword("password");

        baseDomManager.insert(user1);

        AM_User user2 = new AM_User("BAA");
        user2.setUserNm("あ");
        user2.setUserGroupCd("2");
        user2.setPassword("password");
        baseDomManager.insert(user2);

        AM_User user3 = new AM_User("A");
        user3.setUserNm("あ");
        user3.setUserGroupCd("3");
        user3.setPassword("password");
        baseDomManager.insert(user3);

        AM_User user4 = new AM_User("B");
        user4.setUserNm("あ");
        user4.setUserGroupCd("4");
        user4.setPassword("password");
        baseDomManager.insert(user4);

        AM_User user5 = new AM_User("AAA");
        user5.setUserNm("あ");
        user5.setUserGroupCd("5");
        user5.setPassword("password");
        baseDomManager.insert(user5);

        AM_User user6 = new AM_User("BBB");
        user6.setUserNm("あ");
        user6.setUserGroupCd("6");
        user6.setPassword("password");
        baseDomManager.insert(user6);

        AM_User user7 = new AM_User("E");
        user7.setUserNm("あ");
        user7.setUserGroupCd("7");
        user7.setPassword("password");
        baseDomManager.insert(user7);

        AM_User user8 = new AM_User("C");
        user8.setUserNm("うえお");
        user8.setUserGroupCd("8");
        user8.setPassword("password");
        baseDomManager.insert(user8);

        AM_User user9 = new AM_User("CC");
        user9.setUserNm("あいあ");
        user9.setUserGroupCd("9");
        user9.setPassword("password");
        baseDomManager.insert(user9);

        AM_User user10 = new AM_User("CCC");
        user10.setUserNm("いあい");
        user10.setUserGroupCd("10");
        user10.setPassword("password");
        baseDomManager.insert(user10);

        AM_User user11 = new AM_User("CCCC");
        user11.setUserNm("い");
        user11.setUserGroupCd("11");
        user11.setPassword("password");
        baseDomManager.insert(user11);

        AM_User user12 = new AM_User("CCCCC");
        user12.setUserNm("あ");
        user12.setUserGroupCd("12");
        user12.setPassword("password");
        baseDomManager.insert(user12);

        AM_User user13 = new AM_User("CCCCCC");
        user13.setUserNm("いいい");
        user13.setUserGroupCd("13");
        user13.setPassword("password");
        baseDomManager.insert(user13);

        AM_User user14 = new AM_User("CCCCCCC");
        user14.setUserNm("あああ");
        user14.setUserGroupCd("14");
        user14.setPassword("password");
        baseDomManager.insert(user14);

        AM_IdCard idCard1 = new AM_IdCard("01", "id001");
        idCard1.setTanmatusiyoukbn("1");

        baseDomManager.insert(idCard1);

        AM_IdCard idCard2 = new AM_IdCard("01", "id002");
        idCard2.setTanmatusiyoukbn("1");
        idCard2.setSyozokusosikicd("300000");

        baseDomManager.insert(idCard2);

        AM_IdCard idCard3 = new AM_IdCard("01", "id003");
        idCard3.setTanmatusiyoukbn("1");
        idCard3.setSyozokusosikicd("003030");

        baseDomManager.insert(idCard3);

        AM_IdCard idCard4 = new AM_IdCard("01", "id004");
        idCard4.setTanmatusiyoukbn("1");
        idCard4.setSyozokusosikicd("30");

        baseDomManager.insert(idCard4);

        AM_IdCard idCard5 = new AM_IdCard("01", "id005");
        idCard5.setTanmatusiyoukbn("1");
        idCard5.setSyozokusosikicd("00");

        baseDomManager.insert(idCard5);

        AM_IdCard idCard6 = new AM_IdCard("01", "id006");
        idCard6.setTanmatusiyoukbn("1");
        idCard6.setSyozokusosikicd("303030");

        baseDomManager.insert(idCard6);

        AM_IdCard idCard7 = new AM_IdCard("01", "id007");
        idCard7.setTanmatusiyoukbn("1");
        idCard7.setSyozokusosikicd("000000");

        baseDomManager.insert(idCard7);

        AM_IdCard idCard8 = new AM_IdCard("01", "id008");
        idCard8.setTanmatusiyoukbn("1");
        idCard8.setSyozokusosikicd("3000111");

        baseDomManager.insert(idCard8);

        AM_IdCard idCard9 = new AM_IdCard("01", "id009");
        idCard9.setTanmatusiyoukbn("1");
        idCard9.setSyozokusosikicd("4000111");

        baseDomManager.insert(idCard9);

        AM_IdCard idCard10 = new AM_IdCard("01", "id010");
        idCard10.setTanmatusiyoukbn("1");
        idCard10.setSyozokusosikicd("2990111");

        baseDomManager.insert(idCard10);

        AM_IdCard idCard11 = new AM_IdCard("01", "id011");
        idCard11.setTanmatusiyoukbn("1");
        idCard11.setSyozokusosikicd("3010111");

        baseDomManager.insert(idCard11);

        AM_IdCard idCard12 = new AM_IdCard("01", "id012");
        idCard12.setTanmatusiyoukbn("1");
        idCard12.setSyozokusosikicd("3001111");

        baseDomManager.insert(idCard12);

        AM_IdCard idCard13 = new AM_IdCard("01", "id013");
        idCard13.setTanmatusiyoukbn("1");
        idCard13.setSyozokusosikicd("3000112");

        baseDomManager.insert(idCard13);

        AM_IdCard idCard14 = new AM_IdCard("01", "id014");
        idCard14.setTanmatusiyoukbn("1");
        idCard14.setSyozokusosikicd("3000112");

        baseDomManager.insert(idCard14);

        AM_IdCard idCard15 = new AM_IdCard("01", "id015");
        idCard15.setTanmatusiyoukbn("1");
        idCard15.setSyozokusosikicd("3000112");

        baseDomManager.insert(idCard15);

        AM_IdCard idCard16 = new AM_IdCard("01", "id016");
        idCard16.setTanmatusiyoukbn("1");
        idCard16.setSyozokusosikicd("3000112");

        baseDomManager.insert(idCard16);

        AT_UserIdKanren userIdKanren1 = new AT_UserIdKanren("02", "id001");
        userIdKanren1.setUserId("ABB");
        baseDomManager.insert(userIdKanren1);

        AT_UserIdKanren userIdKanren2 = new AT_UserIdKanren("01", "id021");
        userIdKanren2.setUserId("ABB");
        baseDomManager.insert(userIdKanren2);

        AT_UserIdKanren userIdKanren3 = new AT_UserIdKanren("01", "id001");
        userIdKanren3.setUserId("BAA");
        baseDomManager.insert(userIdKanren3);

        AT_UserIdKanren userIdKanren4 = new AT_UserIdKanren("01", "id004");
        userIdKanren4.setUserId("A");
        baseDomManager.insert(userIdKanren4);

        AT_UserIdKanren userIdKanren5 = new AT_UserIdKanren("01", "id005");
        userIdKanren5.setUserId("B");
        baseDomManager.insert(userIdKanren5);

        AT_UserIdKanren userIdKanren6 = new AT_UserIdKanren("01", "id002");
        userIdKanren6.setUserId("ABB");
        baseDomManager.insert(userIdKanren6);

        AT_UserIdKanren userIdKanren7 = new AT_UserIdKanren("01", "id008");
        userIdKanren7.setUserId("A");
        baseDomManager.insert(userIdKanren7);

        AT_UserIdKanren userIdKanren8 = new AT_UserIdKanren("01", "id013");
        userIdKanren8.setUserId("AAA");
        baseDomManager.insert(userIdKanren8);

        AT_UserIdKanren userIdKanren9 = new AT_UserIdKanren("01", "id006");
        userIdKanren9.setUserId("BBB");
        baseDomManager.insert(userIdKanren9);

        AT_UserIdKanren userIdKanren10 = new AT_UserIdKanren("01", "id014");
        userIdKanren10.setUserId("CCCC");
        baseDomManager.insert(userIdKanren10);

        AT_UserIdKanren userIdKanren11 = new AT_UserIdKanren("01", "id015");
        userIdKanren11.setUserId("CCCCCC");
        baseDomManager.insert(userIdKanren11);

        AT_UserIdKanren userIdKanren12 = new AT_UserIdKanren("01", "id016");
        userIdKanren12.setUserId("C");
        baseDomManager.insert(userIdKanren12);

    }

    @Test
    @TestOrder(20)
    public void noResult1() {

        List<AM_User> userLst = baseDomManager.getUsersByUserIdUserNmSyozokusosikicd("A", "い", "50");
        assertEquals(0, userLst.size());
    }

    @Test
    @TestOrder(30)
    public void normal1() {

        List<AM_User> userLst1 = baseDomManager.getUsersByUserIdUserNmSyozokusosikicd("C", "え", "30");
        assertEquals(1, userLst1.size());

        assertEquals("C", userLst1.get(0).getUserId());

        List<AM_User> userLst2 = baseDomManager.getUsersByUserIdUserNmSyozokusosikicd("CC", "いい", "30");
        assertEquals(1, userLst2.size());

        assertEquals("CCCCCC", userLst2.get(0).getUserId());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<AM_User> userLst1 = baseDomManager.getUsersByUserIdUserNmSyozokusosikicd("A", "あ", "30");
        assertEquals(3, userLst1.size());

        assertEquals("A", userLst1.get(0).getUserId());
        assertEquals("AAA", userLst1.get(1).getUserId());
        assertEquals("ABB", userLst1.get(2).getUserId());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<AM_User> userLst1 = baseDomManager.getUsersByUserIdUserNmSyozokusosikicd("", "あ", "30");
        assertEquals(4, userLst1.size());

        assertEquals("A", userLst1.get(0).getUserId());
        assertEquals("AAA", userLst1.get(1).getUserId());
        assertEquals("ABB", userLst1.get(2).getUserId());
        assertEquals("BBB", userLst1.get(3).getUserId());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<AM_User> userLst1 = baseDomManager.getUsersByUserIdUserNmSyozokusosikicd("A", "", "30");
        assertEquals(3, userLst1.size());

        assertEquals("A", userLst1.get(0).getUserId());
        assertEquals("AAA", userLst1.get(1).getUserId());
        assertEquals("ABB", userLst1.get(2).getUserId());

    }

    @Test
    @TestOrder(60)
    public void blankCondition3() {

        List<AM_User> userLst1 = baseDomManager.getUsersByUserIdUserNmSyozokusosikicd("A", "あ", "");
        assertEquals(4, userLst1.size());

        assertEquals("A", userLst1.get(0).getUserId());
        assertEquals("A", userLst1.get(1).getUserId());
        assertEquals("AAA", userLst1.get(2).getUserId());
        assertEquals("ABB", userLst1.get(3).getUserId());

    }

    @Test
    @TestOrder(70)
    public void blankCondition4() {

        List<AM_User> userLst1 = baseDomManager.getUsersByUserIdUserNmSyozokusosikicd("", "", "");
        assertEquals(10, userLst1.size());

        assertEquals("A", userLst1.get(0).getUserId());
        assertEquals("A", userLst1.get(1).getUserId());
        assertEquals("AAA", userLst1.get(2).getUserId());
        assertEquals("ABB", userLst1.get(3).getUserId());
        assertEquals("B", userLst1.get(4).getUserId());
        assertEquals("BAA", userLst1.get(5).getUserId());
        assertEquals("BBB", userLst1.get(6).getUserId());
        assertEquals("C", userLst1.get(7).getUserId());
        assertEquals("CCCC", userLst1.get(8).getUserId());
        assertEquals("CCCCCC", userLst1.get(9).getUserId());

    }

    @Test
    @TestOrder(80)
    public void blankCondition5() {

        List<AM_User> userLst1 = baseDomManager.getUsersByUserIdUserNmSyozokusosikicd(null, "あ", "30");
        assertEquals(4, userLst1.size());

        assertEquals("A", userLst1.get(0).getUserId());
        assertEquals("AAA", userLst1.get(1).getUserId());
        assertEquals("ABB", userLst1.get(2).getUserId());
        assertEquals("BBB", userLst1.get(3).getUserId());

    }

    @Test
    @TestOrder(90)
    public void blankCondition6() {

        List<AM_User> userLst1 = baseDomManager.getUsersByUserIdUserNmSyozokusosikicd("A", null, "30");
        assertEquals(3, userLst1.size());

        assertEquals("A", userLst1.get(0).getUserId());
        assertEquals("AAA", userLst1.get(1).getUserId());
        assertEquals("ABB", userLst1.get(2).getUserId());

    }

    @Test
    @TestOrder(100)
    public void blankCondition7() {

        List<AM_User> userLst1 = baseDomManager.getUsersByUserIdUserNmSyozokusosikicd("A", "あ", null);
        assertEquals(4, userLst1.size());

        assertEquals("A", userLst1.get(0).getUserId());
        assertEquals("A", userLst1.get(1).getUserId());
        assertEquals("AAA", userLst1.get(2).getUserId());
        assertEquals("ABB", userLst1.get(3).getUserId());

    }

    @Test
    @TestOrder(110)
    public void blankCondition8() {

        List<AM_User> userLst1 = baseDomManager.getUsersByUserIdUserNmSyozokusosikicd(null, null, null);
        assertEquals(10, userLst1.size());

        assertEquals("A", userLst1.get(0).getUserId());
        assertEquals("A", userLst1.get(1).getUserId());
        assertEquals("AAA", userLst1.get(2).getUserId());
        assertEquals("ABB", userLst1.get(3).getUserId());
        assertEquals("B", userLst1.get(4).getUserId());
        assertEquals("BAA", userLst1.get(5).getUserId());
        assertEquals("BBB", userLst1.get(6).getUserId());
        assertEquals("C", userLst1.get(7).getUserId());
        assertEquals("CCCC", userLst1.get(8).getUserId());
        assertEquals("CCCCCC", userLst1.get(9).getUserId());
    }

    @Transactional
    public static void deleteTestSubData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        List<AM_User> userList = baseDomManager.getAllUsers();
        if(userList.size() > 0){
            baseDomManager.delete(userList);
        }
        List<AM_IdCard> idCardList = baseDomManager.getAllIdCards();
        if(idCardList.size() > 0){
            baseDomManager.delete(idCardList);
        }
        List<AT_UserIdKanren> userIdKanrenList = baseDomManager.getAllUserIdKanrens();
        if(userIdKanrenList.size() > 0){
            baseDomManager.delete(userIdKanrenList);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }

}
