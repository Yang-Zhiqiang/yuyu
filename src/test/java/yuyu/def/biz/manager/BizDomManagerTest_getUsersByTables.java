package yuyu.def.biz.manager;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_HnsyaSosikiKengenKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.BT_UserKengenHaneiSskInfo;
import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.def.db.entity.BW_UserIdKanrenWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getUsersByTables() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getUsersByTables {

    @Inject
    BizDomManager bizDomManager;
    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBUpdatableResults<AM_User> beans =
            bizDomManager.getUsersByTables()) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AM_User user1 = new AM_User("U1000002");
        user1.setUserNm("ユーザー名１");
        user1.setPassword("password1001");

        baseDomManager.insert(user1);

        BW_IdCardWk idCardWk1 = new BW_IdCardWk("01", "100001");
        idCardWk1.setSyozokusosikicd("1111111");

        bizDomManager.insert(idCardWk1);

        BW_UserIdKanrenWk userIdKanrenWk1 = new BW_UserIdKanrenWk("01", "100001");
        userIdKanrenWk1.setUserId("U1000001");

        bizDomManager.insert(userIdKanrenWk1);

        BT_UserKengenHaneiSskInfo userKengenHaneiSskInfo1 = new BT_UserKengenHaneiSskInfo("111");

        userKengenHaneiSskInfo1.setHnsyasosikikengenkbn(C_HnsyaSosikiKengenKbn.JIMU);

        bizDomManager.insert(userKengenHaneiSskInfo1);
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult10() {

        try (ExDBUpdatableResults<AM_User> beans =
            bizDomManager.getUsersByTables())  {

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(11)
    @Transactional
    public void noResult11() {

        bizDomManager.delete(bizDomManager.getAllUserKengenHaneiSskInfo());
        bizDomManager.delete(bizDomManager.getAllUserIdKanrenWk());
        bizDomManager.delete(bizDomManager.getAllIdCardWk());
        baseDomManager.delete(baseDomManager.getAllUsers());

        AM_User user1 = new AM_User("U1000001");
        user1.setUserNm("ユーザー名１");
        user1.setPassword("password1001");

        baseDomManager.insert(user1);

        AM_User user2 = new AM_User("U1000002");
        user2.setUserNm("ユーザー名１");
        user2.setPassword("password1001");

        baseDomManager.insert(user2);

        BW_IdCardWk idCardWk1 = new BW_IdCardWk("01", "100001");
        idCardWk1.setSyozokusosikicd("2111111");

        bizDomManager.insert(idCardWk1);

        BW_IdCardWk idCardWk2 = new BW_IdCardWk("02", "100001");
        idCardWk2.setSyozokusosikicd("2111111");

        bizDomManager.insert(idCardWk2);

        BW_IdCardWk idCardWk3 = new BW_IdCardWk("01", "100002");
        idCardWk3.setSyozokusosikicd("2111111");

        bizDomManager.insert(idCardWk3);

        BW_UserIdKanrenWk userIdKanrenWk1 = new BW_UserIdKanrenWk("01", "100001");
        userIdKanrenWk1.setUserId("U1000001");

        bizDomManager.insert(userIdKanrenWk1);

        BT_UserKengenHaneiSskInfo userKengenHaneiSskInfo1 = new BT_UserKengenHaneiSskInfo("111");

        userKengenHaneiSskInfo1.setHnsyasosikikengenkbn(C_HnsyaSosikiKengenKbn.JIMU);

        bizDomManager.insert(userKengenHaneiSskInfo1);

        BT_UserKengenHaneiSskInfo userKengenHaneiSskInfo2 = new BT_UserKengenHaneiSskInfo("211");

        userKengenHaneiSskInfo2.setHnsyasosikikengenkbn(C_HnsyaSosikiKengenKbn.JIMU);

        bizDomManager.insert(userKengenHaneiSskInfo2);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal10() {

        try (ExDBUpdatableResults<AM_User> beans =
            bizDomManager.getUsersByTables()) {

            int iCount = 0;
            Iterator<AM_User> iter = beans.iterator();
            AM_User user = null;
            while (iter.hasNext()) {

                user = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("U1000001", user.getUserId());

                    continue;
                }
            }
            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {

        bizDomManager.delete(bizDomManager.getAllUserKengenHaneiSskInfo());
        bizDomManager.delete(bizDomManager.getAllUserIdKanrenWk());
        bizDomManager.delete(bizDomManager.getAllIdCardWk());
        baseDomManager.delete(baseDomManager.getAllUsers());

        AM_User user1 = new AM_User("U1000003");
        user1.setUserNm("ユーザー名３");
        user1.setPassword("password1003");

        baseDomManager.insert(user1);

        AM_User user2 = new AM_User("U1000002");
        user2.setUserNm("ユーザー名２");
        user2.setPassword("password1002");

        baseDomManager.insert(user2);

        AM_User user3 = new AM_User("U1000001");
        user3.setUserNm("ユーザー名１");
        user3.setPassword("password1001");

        baseDomManager.insert(user3);

        AM_User user4 = new AM_User("U1000004");
        user4.setUserNm("ユーザー名４");
        user4.setPassword("password1004");

        baseDomManager.insert(user4);

        BW_IdCardWk idCardWk1 = new BW_IdCardWk("01", "100001");
        idCardWk1.setSyozokusosikicd("2213123");

        bizDomManager.insert(idCardWk1);

        BW_IdCardWk idCardWk2 = new BW_IdCardWk("02", "100002");
        idCardWk2.setSyozokusosikicd("1231231");

        bizDomManager.insert(idCardWk2);

        BW_IdCardWk idCardWk3 = new BW_IdCardWk("03", "100003");
        idCardWk3.setSyozokusosikicd("5421546");

        bizDomManager.insert(idCardWk3);

        BW_IdCardWk idCardWk4 = new BW_IdCardWk("04", "100004");
        idCardWk4.setSyozokusosikicd("999888");

        bizDomManager.insert(idCardWk4);

        BW_UserIdKanrenWk userIdKanrenWk1 = new BW_UserIdKanrenWk("01", "100001");
        userIdKanrenWk1.setUserId("U1000003");

        bizDomManager.insert(userIdKanrenWk1);

        BW_UserIdKanrenWk userIdKanrenWk2 = new BW_UserIdKanrenWk("02", "100002");
        userIdKanrenWk2.setUserId("U1000002");

        bizDomManager.insert(userIdKanrenWk2);

        BW_UserIdKanrenWk userIdKanrenWk3 = new BW_UserIdKanrenWk("03", "100003");
        userIdKanrenWk3.setUserId("U1000001");

        bizDomManager.insert(userIdKanrenWk3);

        BW_UserIdKanrenWk userIdKanrenWk4 = new BW_UserIdKanrenWk("04", "100004");
        userIdKanrenWk4.setUserId("U1000004");

        bizDomManager.insert(userIdKanrenWk4);

        BT_UserKengenHaneiSskInfo userKengenHaneiSskInfo1 = new BT_UserKengenHaneiSskInfo("221");

        userKengenHaneiSskInfo1.setHnsyasosikikengenkbn(C_HnsyaSosikiKengenKbn.JIMU);

        bizDomManager.insert(userKengenHaneiSskInfo1);

        BT_UserKengenHaneiSskInfo userKengenHaneiSskInfo2 = new BT_UserKengenHaneiSskInfo("123");

        userKengenHaneiSskInfo2.setHnsyasosikikengenkbn(C_HnsyaSosikiKengenKbn.JIMU);

        bizDomManager.insert(userKengenHaneiSskInfo2);

        BT_UserKengenHaneiSskInfo userKengenHaneiSskInfo3 = new BT_UserKengenHaneiSskInfo("542");

        userKengenHaneiSskInfo3.setHnsyasosikikengenkbn(C_HnsyaSosikiKengenKbn.JIMU);

        bizDomManager.insert(userKengenHaneiSskInfo3);

        BT_UserKengenHaneiSskInfo userKengenHaneiSskInfo4 = new BT_UserKengenHaneiSskInfo("999");

        userKengenHaneiSskInfo4.setHnsyasosikikengenkbn(C_HnsyaSosikiKengenKbn.SYOUKAI);

        bizDomManager.insert(userKengenHaneiSskInfo4);

    }
    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        try (ExDBUpdatableResults<AM_User> beans =
            bizDomManager.getUsersByTables()) {

            int iCount = 0;
            Iterator<AM_User> iter = beans.iterator();
            AM_User user = null;
            while (iter.hasNext()) {

                user = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("U1000001", user.getUserId());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("U1000002", user.getUserId());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("U1000003", user.getUserId());

                    continue;
                }
            }
            Assert.assertEquals(3, iCount);
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BT_UserKengenHaneiSskInfo> userKengenHaneiSskInfoList = bizDomManager.getAllUserKengenHaneiSskInfo();
        if(userKengenHaneiSskInfoList.size() > 0){
            bizDomManager.delete(userKengenHaneiSskInfoList);
        }

        List<BW_UserIdKanrenWk> userIdKanrenWkList = bizDomManager.getAllUserIdKanrenWk();
        if(userIdKanrenWkList.size() > 0){
            bizDomManager.delete(userIdKanrenWkList);
        }
        List<BW_IdCardWk> idCardWkList = bizDomManager.getAllIdCardWk();
        if(idCardWkList.size() > 0){
            bizDomManager.delete(idCardWkList);
        }
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        List<AM_User> userList = baseDomManager.getAllUsers();
        if(userList.size() > 0){
            bizDomManager.delete(userList);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
