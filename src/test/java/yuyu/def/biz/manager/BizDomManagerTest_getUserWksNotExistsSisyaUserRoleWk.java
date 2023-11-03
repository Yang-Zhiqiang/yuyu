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

import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.def.db.entity.BW_UserIdKanrenWk;
import yuyu.def.db.entity.BW_UserRoleWk;
import yuyu.def.db.entity.BW_UserWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getUserWksNotExistsSisyaUserRoleWk() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getUserWksNotExistsSisyaUserRoleWk {

    @Inject
    BizDomManager bizDomManager;

    private final static String[] dSisyaReigaiSosikiCdList1 = {"258","351","450","473","299"};
    private final static String[] dSisyaReigaiSosikiCdList2 = {"123","258","351","450","473"};
    private final static String[] dSisyaReigaiSosikiCdList3 = {"123","258"};
    private final static String[] dSisyaReigaiSosikiCdList4 = {""};

    private final static String[] dSisyayouRoleCdList1 = {"R100009","R100002","R100003"};
    private final static String[] dSisyayouRoleCdList2 = {"R100001","R100002","R100003","R100009"};
    private final static String[] dSisyayouRoleCdList3 = {"R100009","R100001"};
    private final static String[] dSisyayouRoleCdList4 = {""};

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksNotExistsSisyaUserRoleWk(dSisyaReigaiSosikiCdList1, dSisyayouRoleCdList1)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BW_UserWk userWk1 = new BW_UserWk("userId1001");
        userWk1.setUserNm("ユーザー名１");
        userWk1.setPassword("password1001");

        bizDomManager.insert(userWk1);

        BW_UserWk userWk2 = new BW_UserWk("userId1005");
        userWk2.setUserNm("ユーザー名２");
        userWk2.setPassword("password1002");

        bizDomManager.insert(userWk2);

        BW_UserWk userWk3 = new BW_UserWk("userId1004");
        userWk3.setUserNm("ユーザー名３");
        userWk3.setPassword("password1003");

        bizDomManager.insert(userWk3);

        BW_UserWk userWk4 = new BW_UserWk("userId1003");
        userWk4.setUserNm("ユーザー名４");
        userWk4.setPassword("password1004");

        bizDomManager.insert(userWk4);


        BW_UserWk userWk3100 = new BW_UserWk("userId3100");
        userWk3100.setUserNm("ユーザー名３１００");
        userWk3100.setPassword("password3100");

        bizDomManager.insert(userWk3100);

        BW_UserWk userWk3101 = new BW_UserWk("userId3101");
        userWk3101.setUserNm("ユーザー名３１０１");
        userWk3101.setPassword("password3101");

        bizDomManager.insert(userWk3101);

        BW_UserWk userWk3102 = new BW_UserWk("userId3102");
        userWk3102.setUserNm("ユーザー名３１０２");
        userWk3102.setPassword("password3102");

        bizDomManager.insert(userWk3102);

        BW_UserWk userWk3103 = new BW_UserWk("userId3103");
        userWk3103.setUserNm("ユーザー名３１０３");
        userWk3103.setPassword("password3103");

        bizDomManager.insert(userWk3103);

        BW_UserWk userWk3104 = new BW_UserWk("userId3104");
        userWk3104.setUserNm("ユーザー名３１０４");
        userWk3104.setPassword("password3104");

        bizDomManager.insert(userWk3104);

        BW_UserWk userWk3105 = new BW_UserWk("userId3105");
        userWk3105.setUserNm("ユーザー名３１０５");
        userWk3105.setPassword("password3105");

        bizDomManager.insert(userWk3105);

        BW_UserWk userWk3106 = new BW_UserWk("userId3106");
        userWk3106.setUserNm("ユーザー名３１０６");
        userWk3106.setPassword("password3106");

        bizDomManager.insert(userWk3106);

        BW_UserWk userWk3107 = new BW_UserWk("userId3107");
        userWk3107.setUserNm("ユーザー名３１０７");
        userWk3107.setPassword("password3107");

        bizDomManager.insert(userWk3107);

        BW_UserWk userWk3108 = new BW_UserWk("userId3108");
        userWk3108.setUserNm("ユーザー名３１０８");
        userWk3108.setPassword("password3108");

        bizDomManager.insert(userWk3108);

        BW_UserRoleWk userRoleWk1 = new BW_UserRoleWk("userId1001", "R100001");

        bizDomManager.insert(userRoleWk1);

        BW_UserRoleWk userRoleWk2 = new BW_UserRoleWk("userId1001", "R100009");

        bizDomManager.insert(userRoleWk2);

        BW_UserRoleWk userRoleWk3 = new BW_UserRoleWk("userId1005", "R100002");

        bizDomManager.insert(userRoleWk3);

        BW_UserRoleWk userRoleWk4 = new BW_UserRoleWk("userId1004", "R100003");

        bizDomManager.insert(userRoleWk4);

        BW_UserRoleWk userRoleWk3100     = new BW_UserRoleWk("userId3100",     "R100001");
        bizDomManager.insert(userRoleWk3100);

        BW_UserRoleWk userRoleWk3101     = new BW_UserRoleWk("userId3101",    "R100001");
        bizDomManager.insert(userRoleWk3101);

        BW_UserRoleWk userRoleWk3102     = new BW_UserRoleWk("userId3102",    "R100001");
        bizDomManager.insert(userRoleWk3102);

        BW_UserRoleWk userRoleWk3103     = new BW_UserRoleWk("userId3103",    "R100001");
        bizDomManager.insert(userRoleWk3103);

        BW_UserRoleWk userRoleWk3104     = new BW_UserRoleWk("userId3104",    "R100001");
        bizDomManager.insert(userRoleWk3104);

        BW_UserRoleWk userRoleWk3105     = new BW_UserRoleWk("userId3105",    "R100001");
        bizDomManager.insert(userRoleWk3105);

        BW_UserRoleWk userRoleWk3106     = new BW_UserRoleWk("userId3106",    "R100001");
        bizDomManager.insert(userRoleWk3106);

        BW_UserRoleWk userRoleWk3107     = new BW_UserRoleWk("userId3107",    "R100001");
        bizDomManager.insert(userRoleWk3107);

        BW_UserRoleWk userRoleWk3108     = new BW_UserRoleWk("userId3108",    "R100001");
        bizDomManager.insert(userRoleWk3108);

        BW_UserRoleWk userRoleWk3100_2     = new BW_UserRoleWk("userId3100",     "R100009");
        bizDomManager.insert(userRoleWk3100_2);

        BW_UserRoleWk userRoleWk3101_2     = new BW_UserRoleWk("userId3101",    "R100009");
        bizDomManager.insert(userRoleWk3101_2);

        BW_UserRoleWk userRoleWk3102_2     = new BW_UserRoleWk("userId3102",    "R100009");
        bizDomManager.insert(userRoleWk3102_2);

        BW_UserRoleWk userRoleWk3103_2     = new BW_UserRoleWk("userId3103",    "R100009");
        bizDomManager.insert(userRoleWk3103_2);

        BW_UserRoleWk userRoleWk3104_2    = new BW_UserRoleWk("userId3104",    "R100009");
        bizDomManager.insert(userRoleWk3104_2);

        BW_UserRoleWk userRoleWk3105_2     = new BW_UserRoleWk("userId3105",    "R100009");
        bizDomManager.insert(userRoleWk3105_2);

        BW_UserRoleWk userRoleWk3106_2     = new BW_UserRoleWk("userId3106",    "R100009");
        bizDomManager.insert(userRoleWk3106_2);

        BW_UserRoleWk userRoleWk3107_2     = new BW_UserRoleWk("userId3107",    "R100009");
        bizDomManager.insert(userRoleWk3107_2);

        BW_UserRoleWk userRoleWk3108_2     = new BW_UserRoleWk("userId3108",    "R100009");
        bizDomManager.insert(userRoleWk3108_2);

        BW_IdCardWk idCardWk1 = new BW_IdCardWk("01", "100001");
        idCardWk1.setTanmatusiyoukbn("1");
        idCardWk1.setSyozokusosikicd("1230567");

        bizDomManager.insert(idCardWk1);

        BW_IdCardWk idCardWk2 = new BW_IdCardWk("01", "100002");
        idCardWk2.setTanmatusiyoukbn("1");
        idCardWk2.setSyozokusosikicd("1230567");

        bizDomManager.insert(idCardWk2);

        BW_IdCardWk idCardWk3 = new BW_IdCardWk("02", "100001");
        idCardWk3.setTanmatusiyoukbn("1");
        idCardWk3.setSyozokusosikicd("1230567");

        bizDomManager.insert(idCardWk3);

        BW_IdCardWk idCardWk4 = new BW_IdCardWk("02", "100002");
        idCardWk4.setTanmatusiyoukbn("1");
        idCardWk4.setSyozokusosikicd("1230567");

        bizDomManager.insert(idCardWk4);

        BW_IdCardWk idCardWk5 = new BW_IdCardWk("01", "100003");
        idCardWk5.setTanmatusiyoukbn("1");
        idCardWk5.setSyozokusosikicd("3000567");

        bizDomManager.insert(idCardWk5);

        BW_IdCardWk idCardWk6 = new BW_IdCardWk("01", "100004");
        idCardWk6.setTanmatusiyoukbn("1");
        idCardWk6.setSyozokusosikicd("3010567");

        bizDomManager.insert(idCardWk6);

        BW_IdCardWk idCardWk7 = new BW_IdCardWk("01", "100005");
        idCardWk7.setTanmatusiyoukbn("0");
        idCardWk7.setSyozokusosikicd("1230567");

        bizDomManager.insert(idCardWk7);

        BW_IdCardWk idCardWk8 = new BW_IdCardWk("01", "100006");
        idCardWk8.setTanmatusiyoukbn("1");
        idCardWk8.setSyozokusosikicd("1231567");

        bizDomManager.insert(idCardWk8);

        BW_IdCardWk idCardWk9 = new BW_IdCardWk("01", "100007");
        idCardWk9.setTanmatusiyoukbn("1");
        idCardWk9.setSyozokusosikicd("2580147");

        bizDomManager.insert(idCardWk9);

        BW_IdCardWk idCardWk10 = new BW_IdCardWk("03", "100001");
        idCardWk10.setTanmatusiyoukbn("1");
        idCardWk10.setSyozokusosikicd("3510159");

        bizDomManager.insert(idCardWk10);

        BW_IdCardWk idCardWk11 = new BW_IdCardWk("03", "100002");
        idCardWk11.setTanmatusiyoukbn("1");
        idCardWk11.setSyozokusosikicd("4500123");

        bizDomManager.insert(idCardWk11);

        BW_IdCardWk idCardWk12 = new BW_IdCardWk("03", "100003");
        idCardWk12.setTanmatusiyoukbn("1");
        idCardWk12.setSyozokusosikicd("4730147");

        bizDomManager.insert(idCardWk12);


        BW_IdCardWk idCardWk3100    = new BW_IdCardWk("01", "310000");
        idCardWk3100.setTanmatusiyoukbn("1");
        idCardWk3100.setSyozokusosikicd("2990000");

        bizDomManager.insert(idCardWk3100);

        BW_IdCardWk idCardWk3101    = new BW_IdCardWk("01", "310001");
        idCardWk3101.setTanmatusiyoukbn("2");
        idCardWk3101.setSyozokusosikicd("2990000");

        bizDomManager.insert(idCardWk3101);

        BW_IdCardWk idCardWk3102    = new BW_IdCardWk("01", "310002");
        idCardWk3102.setTanmatusiyoukbn("3");
        idCardWk3102.setSyozokusosikicd("2990000");

        bizDomManager.insert(idCardWk3102);

        BW_IdCardWk idCardWk3103    = new BW_IdCardWk("02", "310003");
        idCardWk3103.setTanmatusiyoukbn("1");
        idCardWk3103.setSyozokusosikicd("2990000");

        bizDomManager.insert(idCardWk3103);

        BW_IdCardWk idCardWk3104    = new BW_IdCardWk("02", "310004");
        idCardWk3104.setTanmatusiyoukbn("2");
        idCardWk3104.setSyozokusosikicd("2990000");

        bizDomManager.insert(idCardWk3104);

        BW_IdCardWk idCardWk3105    = new BW_IdCardWk("02", "310005");
        idCardWk3105.setTanmatusiyoukbn("3");
        idCardWk3105.setSyozokusosikicd("2990000");

        bizDomManager.insert(idCardWk3105);

        BW_IdCardWk idCardWk3106    = new BW_IdCardWk("03", "310006");
        idCardWk3106.setTanmatusiyoukbn("1");
        idCardWk3106.setSyozokusosikicd("2990000");

        bizDomManager.insert(idCardWk3106);

        BW_IdCardWk idCardWk3107    = new BW_IdCardWk("03", "310007");
        idCardWk3107.setTanmatusiyoukbn("2");
        idCardWk3107.setSyozokusosikicd("2990000");

        bizDomManager.insert(idCardWk3107);

        BW_IdCardWk idCardWk3108    = new BW_IdCardWk("03", "310008");
        idCardWk3108.setTanmatusiyoukbn("3");
        idCardWk3108.setSyozokusosikicd("2990000");

        bizDomManager.insert(idCardWk3108);


        BW_UserIdKanrenWk userIdKanrenWk1 = new BW_UserIdKanrenWk("01", "100001");
        userIdKanrenWk1.setUserId("userId1001");

        bizDomManager.insert(userIdKanrenWk1);

        BW_UserIdKanrenWk userIdKanrenWk2 = new BW_UserIdKanrenWk("01", "100003");
        userIdKanrenWk2.setUserId("userId1001");

        bizDomManager.insert(userIdKanrenWk2);

        BW_UserIdKanrenWk userIdKanrenWk3 = new BW_UserIdKanrenWk("01", "100004");
        userIdKanrenWk3.setUserId("userId1001");

        bizDomManager.insert(userIdKanrenWk3);

        BW_UserIdKanrenWk userIdKanrenWk4 = new BW_UserIdKanrenWk("01", "100005");
        userIdKanrenWk4.setUserId("userId1001");

        bizDomManager.insert(userIdKanrenWk4);

        BW_UserIdKanrenWk userIdKanrenWk5 = new BW_UserIdKanrenWk("01", "100006");
        userIdKanrenWk5.setUserId("userId1001");

        bizDomManager.insert(userIdKanrenWk5);

        BW_UserIdKanrenWk userIdKanrenWk6 = new BW_UserIdKanrenWk("01", "100007");
        userIdKanrenWk6.setUserId("userId1001");

        bizDomManager.insert(userIdKanrenWk6);

        BW_UserIdKanrenWk userIdKanrenWk7 = new BW_UserIdKanrenWk("02", "100002");
        userIdKanrenWk7.setUserId("userId1002");

        bizDomManager.insert(userIdKanrenWk7);

        BW_UserIdKanrenWk userIdKanrenWk8 = new BW_UserIdKanrenWk("03", "100001");
        userIdKanrenWk8.setUserId("userId1005");

        bizDomManager.insert(userIdKanrenWk8);

        BW_UserIdKanrenWk userIdKanrenWk9 = new BW_UserIdKanrenWk("03", "100002");
        userIdKanrenWk9.setUserId("userId1004");

        bizDomManager.insert(userIdKanrenWk9);

        BW_UserIdKanrenWk userIdKanrenWk10 = new BW_UserIdKanrenWk("03", "100003");
        userIdKanrenWk10.setUserId("userId1003");

        bizDomManager.insert(userIdKanrenWk10);


        BW_UserIdKanrenWk userIdKanrenWk3100 = new BW_UserIdKanrenWk("01", "310000");
        userIdKanrenWk3100.setUserId("userId3100");

        bizDomManager.insert(userIdKanrenWk3100);

        BW_UserIdKanrenWk userIdKanrenWk3101 = new BW_UserIdKanrenWk("01", "310001");
        userIdKanrenWk3101.setUserId("userId3101");

        bizDomManager.insert(userIdKanrenWk3101);

        BW_UserIdKanrenWk userIdKanrenWk3102 = new BW_UserIdKanrenWk("01", "310002");
        userIdKanrenWk3102.setUserId("userId3102");

        bizDomManager.insert(userIdKanrenWk3102);

        BW_UserIdKanrenWk userIdKanrenWk3103 = new BW_UserIdKanrenWk("02", "310003");
        userIdKanrenWk3103.setUserId("userId3103");

        bizDomManager.insert(userIdKanrenWk3103);

        BW_UserIdKanrenWk userIdKanrenWk3104 = new BW_UserIdKanrenWk("02", "310004");
        userIdKanrenWk3104.setUserId("userId3104");

        bizDomManager.insert(userIdKanrenWk3104);

        BW_UserIdKanrenWk userIdKanrenWk3105 = new BW_UserIdKanrenWk("02", "310005");
        userIdKanrenWk3105.setUserId("userId3105");

        bizDomManager.insert(userIdKanrenWk3105);

        BW_UserIdKanrenWk userIdKanrenWk3106 = new BW_UserIdKanrenWk("03", "310006");
        userIdKanrenWk3106.setUserId("userId3106");

        bizDomManager.insert(userIdKanrenWk3106);

        BW_UserIdKanrenWk userIdKanrenWk3107 = new BW_UserIdKanrenWk("03", "310007");
        userIdKanrenWk3107.setUserId("userId3107");

        bizDomManager.insert(userIdKanrenWk3107);

        BW_UserIdKanrenWk userIdKanrenWk3108 = new BW_UserIdKanrenWk("03", "310008");
        userIdKanrenWk3108.setUserId("userId3108");

        bizDomManager.insert(userIdKanrenWk3108);


    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksNotExistsSisyaUserRoleWk(dSisyaReigaiSosikiCdList2, dSisyayouRoleCdList2))  {

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksNotExistsSisyaUserRoleWk(dSisyaReigaiSosikiCdList1, dSisyayouRoleCdList1)) {

            int iCount = 0;
            Iterator<BW_UserWk> iter = beans.iterator();
            BW_UserWk userWk = null;
            while (iter.hasNext()) {

                userWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("userId1001", userWk.getUserId());

                    continue;
                }
            }
            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksNotExistsSisyaUserRoleWk(dSisyaReigaiSosikiCdList3, dSisyayouRoleCdList3)) {

            int iCount = 0;
            Iterator<BW_UserWk> iter = beans.iterator();
            BW_UserWk userWk = null;
            while (iter.hasNext()) {

                userWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("userId1003", userWk.getUserId());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("userId1004", userWk.getUserId());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("userId1005", userWk.getUserId());

                    continue;
                }
            }
            Assert.assertEquals(3, iCount);
        }
    }
    @Test
    @TestOrder(40)
    @Transactional
    public void blankCondition1() {

        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksNotExistsSisyaUserRoleWk(dSisyaReigaiSosikiCdList4, dSisyayouRoleCdList3))  {

            int iCount = 0;
            Iterator<BW_UserWk> iter = beans.iterator();
            BW_UserWk userWk = null;
            while (iter.hasNext()) {

                userWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("userId1003", userWk.getUserId());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("userId1004", userWk.getUserId());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("userId1005", userWk.getUserId());

                    continue;
                }
            }
            Assert.assertEquals(3, iCount);
        }
    }
    @Test
    @TestOrder(50)
    @Transactional
    public void blankCondition2() {

        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksNotExistsSisyaUserRoleWk(dSisyaReigaiSosikiCdList1, dSisyayouRoleCdList4))  {

            int iCount = 0;
            Iterator<BW_UserWk> iter = beans.iterator();
            BW_UserWk userWk = null;
            while (iter.hasNext()) {

                userWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("userId1001", userWk.getUserId());

                    continue;
                }
            }
            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void sisyahenkou() {

        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksNotExistsSisyaUserRoleWk(dSisyaReigaiSosikiCdList2, dSisyayouRoleCdList4))  {

            int iCount = 0;
            Iterator<BW_UserWk> iter = beans.iterator();
            BW_UserWk userWk = null;
            while (iter.hasNext()) {

                userWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("userId3100", userWk.getUserId());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("userId3101", userWk.getUserId());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("userId3106", userWk.getUserId());

                    continue;
                }
            }
            Assert.assertEquals(3, iCount);
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BW_UserWk> userWkList = bizDomManager.getAllUserWk();
        if(userWkList.size() > 0){
            bizDomManager.delete(userWkList);
        }

        List<BW_UserRoleWk> userRoleWkList = bizDomManager.getAllUserRoleWk();
        if(userRoleWkList.size() > 0){
            bizDomManager.delete(userRoleWkList);
        }

        List<BW_UserIdKanrenWk> userIdKanrenWkList = bizDomManager.getAllUserIdKanrenWk();
        if(userIdKanrenWkList.size() > 0){
            bizDomManager.delete(userIdKanrenWkList);
        }
        List<BW_IdCardWk> idCardWkList = bizDomManager.getAllIdCardWk();
        if(idCardWkList.size() > 0){
            bizDomManager.delete(idCardWkList);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
