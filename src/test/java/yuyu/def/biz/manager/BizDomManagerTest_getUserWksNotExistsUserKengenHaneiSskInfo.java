package yuyu.def.biz.manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.db.entity.BT_UserKengenHaneiSskInfo;
import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.def.db.entity.BW_UserIdKanrenWk;
import yuyu.def.db.entity.BW_UserRoleWk;
import yuyu.def.db.entity.BW_UserWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getUserWksNotExistsUserKengenHaneiSskInfo() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getUserWksNotExistsUserKengenHaneiSskInfo {


    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getUserWksNotExistsUserKengenHaneiSskInfo";

    private final static String sheetName = "INデータ";

    @Inject
    BizDomManager bizDomManager;

    static String[] sisyaAtukaiSosikiCdList1 = {"666","777","888"};
    static String[] sisyaAtukaiSosikiCdList2 = {"666","777","888","733"};
    static String[] sisyaAtukaiSosikiCdList3 = {""};
    static String[] sisyaAtukaiSosikiCdList5 = {"555","666","999","888"};

    static String[] sisyaReigaiSosikiCdList1 = {"555","777","888"};
    static String[] sisyaReigaiSosikiCdList2 = {"111","112","113"};
    static String[] sisyaReigaiSosikiCdList3 = {"555","999"};
    static String[] sisyaReigaiSosikiCdList4 = {""};
    static String[] sisyaReigaiSosikiCdList5 = {"111","222","333","666"};
    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBUpdatableResults<BW_UserWk> bW_UserWkResults =
            bizDomManager.getUserWksNotExistsUserKengenHaneiSskInfo(sisyaAtukaiSosikiCdList1,sisyaReigaiSosikiCdList1)) {

            Assert.assertFalse(bW_UserWkResults.iterator().hasNext());
        }

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BW_UserWk userWk1 = new BW_UserWk("111");
        userWk1.setUserNm("かか");

        bizDomManager.insert(userWk1);

        BW_UserWk userWk2 = new BW_UserWk("444");
        userWk2.setUserNm("かか");

        bizDomManager.insert(userWk2);

        BW_UserWk userWk3 = new BW_UserWk("222");
        userWk3.setUserNm("かか");

        bizDomManager.insert(userWk3);

        BW_UserWk userWk4 = new BW_UserWk("333");
        userWk4.setUserNm("かか");

        bizDomManager.insert(userWk4);




        BW_UserRoleWk userRoleWk1 = new BW_UserRoleWk("222", "222");

        bizDomManager.insert(userRoleWk1);

        BW_UserRoleWk userRoleWk2 = new BW_UserRoleWk("444", "444");

        bizDomManager.insert(userRoleWk2);

        BW_UserRoleWk userRoleWk3 = new BW_UserRoleWk("111", "111");

        bizDomManager.insert(userRoleWk3);





        BW_IdCardWk idCardWk1 = new BW_IdCardWk("01", "001");
        idCardWk1.setTanmatusiyoukbn("1");
        idCardWk1.setSyozokusosikicd("6660");

        bizDomManager.insert(idCardWk1);

        BW_IdCardWk idCardWk2 = new BW_IdCardWk("00", "001");
        idCardWk2.setTanmatusiyoukbn("1");
        idCardWk2.setSyozokusosikicd("6660");

        bizDomManager.insert(idCardWk2);

        BW_IdCardWk idCardWk3 = new BW_IdCardWk("01", "002");
        idCardWk3.setTanmatusiyoukbn("1");
        idCardWk3.setSyozokusosikicd("6660");

        bizDomManager.insert(idCardWk3);

        BW_IdCardWk idCardWk4 = new BW_IdCardWk("01", "003");
        idCardWk4.setTanmatusiyoukbn("1");
        idCardWk4.setSyozokusosikicd("6660");

        bizDomManager.insert(idCardWk4);

        BW_IdCardWk idCardWk5 = new BW_IdCardWk("01", "004");
        idCardWk5.setTanmatusiyoukbn("0");
        idCardWk5.setSyozokusosikicd("6660");

        bizDomManager.insert(idCardWk5);

        BW_IdCardWk idCardWk6 = new BW_IdCardWk("03", "001");
        idCardWk6.setTanmatusiyoukbn("1");
        idCardWk6.setSyozokusosikicd("8880");

        bizDomManager.insert(idCardWk6);

        BW_IdCardWk idCardWk7 = new BW_IdCardWk("03", "002");
        idCardWk7.setTanmatusiyoukbn("1");
        idCardWk7.setSyozokusosikicd("1000");

        bizDomManager.insert(idCardWk7);

        BW_IdCardWk idCardWk8 = new BW_IdCardWk("03", "003");
        idCardWk8.setTanmatusiyoukbn("1");
        idCardWk8.setSyozokusosikicd("7330");

        bizDomManager.insert(idCardWk8);

        BW_IdCardWk idCardWk9 = new BW_IdCardWk("03", "004");
        idCardWk9.setTanmatusiyoukbn("1");
        idCardWk9.setSyozokusosikicd("7770");

        bizDomManager.insert(idCardWk9);


        BW_UserIdKanrenWk userIdKanrenWk1 = new BW_UserIdKanrenWk("01", "001");
        userIdKanrenWk1.setUserId("111");

        bizDomManager.insert(userIdKanrenWk1);

        BW_UserIdKanrenWk userIdKanrenWk2 = new BW_UserIdKanrenWk("01", "003");
        userIdKanrenWk2.setUserId("222");

        bizDomManager.insert(userIdKanrenWk2);

        BW_UserIdKanrenWk userIdKanrenWk3 = new BW_UserIdKanrenWk("01", "004");
        userIdKanrenWk3.setUserId("333");

        bizDomManager.insert(userIdKanrenWk3);

        BW_UserIdKanrenWk userIdKanrenWk4 = new BW_UserIdKanrenWk("03", "001");
        userIdKanrenWk4.setUserId("222");

        bizDomManager.insert(userIdKanrenWk4);

        BW_UserIdKanrenWk userIdKanrenWk5 = new BW_UserIdKanrenWk("03", "002");
        userIdKanrenWk5.setUserId("111");

        bizDomManager.insert(userIdKanrenWk5);

        BW_UserIdKanrenWk userIdKanrenWk6 = new BW_UserIdKanrenWk("03", "003");
        userIdKanrenWk6.setUserId("444");

        bizDomManager.insert(userIdKanrenWk6);

        BW_UserIdKanrenWk userIdKanrenWk7 = new BW_UserIdKanrenWk("03", "004");
        userIdKanrenWk7.setUserId("111");

        bizDomManager.insert(userIdKanrenWk7);

        BT_UserKengenHaneiSskInfo userKengenHaneiSskInfo1 = new BT_UserKengenHaneiSskInfo("999");

        bizDomManager.insert(userKengenHaneiSskInfo1);

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBUpdatableResults<BW_UserWk> bW_UserWkResults =
            bizDomManager.getUserWksNotExistsUserKengenHaneiSskInfo(sisyaAtukaiSosikiCdList2,sisyaReigaiSosikiCdList2)) {
            Assert.assertFalse(bW_UserWkResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try (ExDBUpdatableResults<BW_UserWk> bW_UserWkResults =
            bizDomManager.getUserWksNotExistsUserKengenHaneiSskInfo(sisyaAtukaiSosikiCdList1,sisyaReigaiSosikiCdList3)) {

            int iCount = 0;
            Iterator<BW_UserWk> iter = bW_UserWkResults.iterator();
            BW_UserWk bW_UserWk = null;
            while (iter.hasNext()) {

                bW_UserWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("444", bW_UserWk.getUserId());
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

        try (ExDBUpdatableResults<BW_UserWk> bW_UserWkResults =
            bizDomManager.getUserWksNotExistsUserKengenHaneiSskInfo(sisyaAtukaiSosikiCdList1,sisyaReigaiSosikiCdList1)) {

            int iCount = 0;
            Iterator<BW_UserWk> iter = bW_UserWkResults.iterator();
            BW_UserWk bW_UserWk = null;
            while (iter.hasNext()) {

                bW_UserWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("111", bW_UserWk.getUserId());
                    continue;
                }
                if (2 == iCount) {

                    Assert.assertEquals("222", bW_UserWk.getUserId());
                    continue;
                }
                if (3 == iCount) {

                    Assert.assertEquals("444", bW_UserWk.getUserId());
                    continue;
                }
            }
            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void sisyaHenkou() {

        deleteTestSubData();
        insertSubData2();
        try (ExDBUpdatableResults<BW_UserWk> bW_UserWkResults =
            bizDomManager.getUserWksNotExistsUserKengenHaneiSskInfo(sisyaAtukaiSosikiCdList3,sisyaReigaiSosikiCdList4)) {

            int iCount = 0;
            Iterator<BW_UserWk> iter = bW_UserWkResults.iterator();
            BW_UserWk bW_UserWk = null;
            while (iter.hasNext()) {

                bW_UserWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("userId3102", bW_UserWk.getUserId());
                    continue;
                }
                if (2 == iCount) {

                    Assert.assertEquals("userId3103", bW_UserWk.getUserId());
                    continue;
                }
                if (3 == iCount) {

                    Assert.assertEquals("userId3104", bW_UserWk.getUserId());
                    continue;
                }
                if (4 == iCount) {

                    Assert.assertEquals("userId3105", bW_UserWk.getUserId());
                    continue;
                }
                if (5 == iCount) {

                    Assert.assertEquals("userId3107", bW_UserWk.getUserId());
                    continue;
                }
                if (6 == iCount) {

                    Assert.assertEquals("userId3108", bW_UserWk.getUserId());
                    continue;
                }
            }
            Assert.assertEquals(6, iCount);
        }
    }


    @Test
    @TestOrder(50)
    @Transactional
    public void normal5() {

        deleteTestSubData();

        insertSubDataByExcel();

        try (ExDBUpdatableResults<BW_UserWk> bW_UserWkResults =
            bizDomManager.getUserWksNotExistsUserKengenHaneiSskInfo(sisyaAtukaiSosikiCdList5,sisyaReigaiSosikiCdList5)) {

            int iCount = 0;
            Iterator<BW_UserWk> iter = bW_UserWkResults.iterator();
            BW_UserWk bW_UserWk = null;

            while (iter.hasNext()) {

                bW_UserWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("111", bW_UserWk.getUserId());
                    continue;
                }
                if (2 == iCount) {

                    Assert.assertEquals("222", bW_UserWk.getUserId());
                    continue;
                }
            }

            Assert.assertEquals(2, iCount);
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
        List<BT_UserKengenHaneiSskInfo> userKengenHaneiSskInfoList = bizDomManager.getAllUserKengenHaneiSskInfo();
        if(userKengenHaneiSskInfoList.size() > 0){
            bizDomManager.delete(userKengenHaneiSskInfoList);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }

    @Transactional
    public static void insertSubData2() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

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

    @Transactional
    public static void insertSubDataByExcel() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getUserWksNotExistsUserKengenHaneiSskInfo.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
