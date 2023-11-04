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

import yuyu.def.classification.C_HnsyaSosikiKengenKbn;
import yuyu.def.db.entity.BT_UserKengenHaneiSskInfo;
import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.def.db.entity.BW_UserIdKanrenWk;
import yuyu.def.db.entity.BW_UserWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getUserWksBySyozokusosikicdKeta3() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getUserWksBySyozokusosikicdKeta3 {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void preProcess(){

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksBySyozokusosikicdKeta3()) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        insertSubData();

    }
    @Transactional()
    public static void insertSubData(){
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BW_IdCardWk idCardWk1 = new BW_IdCardWk("07", "333333");
        idCardWk1.setSyozokusosikicd("7654321");

        bizDomManager.insert(idCardWk1);

        BT_UserKengenHaneiSskInfo userKengenHaneiSskInfo1 = new BT_UserKengenHaneiSskInfo("123");

        bizDomManager.insert(userKengenHaneiSskInfo1);

        BW_UserIdKanrenWk userIdKanrenWk1 = new BW_UserIdKanrenWk("07", "333333");
        userIdKanrenWk1.setUserId("777");

        bizDomManager.insert(userIdKanrenWk1);

        BW_UserWk userWk1 = new BW_UserWk("777");
        userWk1.setUserNm("ユーザー名");

        bizDomManager.insert(userWk1);

    }

    @Transactional
    public static void deleteTestSubData(){
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BW_IdCardWk> idCardWkList = bizDomManager.getAllIdCardWk();
        List<BT_UserKengenHaneiSskInfo> userKengenHaneiSskInfoList = bizDomManager.getAllUserKengenHaneiSskInfo();
        List<BW_UserIdKanrenWk> userIdKanrenWkList = bizDomManager.getAllUserIdKanrenWk();
        List<BW_UserWk> userWkList = bizDomManager.getAllUserWk();

        if(idCardWkList.size() > 0){
            bizDomManager.delete(idCardWkList);
        }
        if(userKengenHaneiSskInfoList.size() > 0){
            bizDomManager.delete(userKengenHaneiSskInfoList);
        }
        if(userIdKanrenWkList.size() > 0){
            bizDomManager.delete(userIdKanrenWkList);
        }
        if(userWkList.size() > 0){
            bizDomManager.delete(userWkList);
        }

    }



    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksBySyozokusosikicdKeta3()) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {

        deleteTestSubData();

        BW_IdCardWk idCardWk1 = new BW_IdCardWk("00", "000001");
        idCardWk1.setSyozokusosikicd("1234567");

        bizDomManager.insert(idCardWk1);

        BT_UserKengenHaneiSskInfo userKengenHaneiSskInfo1 = new BT_UserKengenHaneiSskInfo("123");
        userKengenHaneiSskInfo1.setHnsyasosikikengenkbn(C_HnsyaSosikiKengenKbn.JIMU);

        bizDomManager.insert(userKengenHaneiSskInfo1);

        BT_UserKengenHaneiSskInfo userKengenHaneiSskInfo2 = new BT_UserKengenHaneiSskInfo("456");
        userKengenHaneiSskInfo2.setHnsyasosikikengenkbn(C_HnsyaSosikiKengenKbn.JIMU);

        bizDomManager.insert(userKengenHaneiSskInfo2);

        BW_UserIdKanrenWk userIdKanrenWk1 = new BW_UserIdKanrenWk("00", "000001");
        userIdKanrenWk1.setUserId("222");

        bizDomManager.insert(userIdKanrenWk1);

        BW_UserIdKanrenWk userIdKanrenWk2 = new BW_UserIdKanrenWk("00", "000002");
        userIdKanrenWk2.setUserId("222");

        bizDomManager.insert(userIdKanrenWk2);

        BW_UserIdKanrenWk userIdKanrenWk3 = new BW_UserIdKanrenWk("02", "000001");
        userIdKanrenWk3.setUserId("222");

        bizDomManager.insert(userIdKanrenWk3);

        BW_UserWk userWk1 = new BW_UserWk("222");
        userWk1.setUserNm("ユーザー名");

        bizDomManager.insert(userWk1);

        BW_UserWk userWk2 = new BW_UserWk("333");
        userWk2.setUserNm("ユーザー名");

        bizDomManager.insert(userWk2);

    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {

        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksBySyozokusosikicdKeta3()) {

            int iCount = 0;
            Iterator<BW_UserWk> iter = beans.iterator();
            BW_UserWk user = null;
            while (iter.hasNext()) {

                user = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("222", user.getUserId());
                    Assert.assertEquals("ユーザー名", user.getUserNm());

                    continue;
                }
            }
            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {

        deleteTestSubData();

        BW_IdCardWk idCardWk1 = new BW_IdCardWk("00", "111111");
        idCardWk1.setSyozokusosikicd("7654321");

        bizDomManager.insert(idCardWk1);

        BW_IdCardWk idCardWk2 = new BW_IdCardWk("08", "222222");
        idCardWk2.setSyozokusosikicd("7654321");

        bizDomManager.insert(idCardWk2);

        BW_IdCardWk idCardWk3 = new BW_IdCardWk("07", "333333");
        idCardWk3.setSyozokusosikicd("7654321");

        bizDomManager.insert(idCardWk3);

        BW_IdCardWk idCardWk4 = new BW_IdCardWk("06", "444444");
        idCardWk4.setSyozokusosikicd("1234567");

        bizDomManager.insert(idCardWk4);

        BT_UserKengenHaneiSskInfo userKengenHaneiSskInfo1 = new BT_UserKengenHaneiSskInfo("765");
        userKengenHaneiSskInfo1.setHnsyasosikikengenkbn(C_HnsyaSosikiKengenKbn.JIMU);
        bizDomManager.insert(userKengenHaneiSskInfo1);

        BT_UserKengenHaneiSskInfo userKengenHaneiSskInfo2 = new BT_UserKengenHaneiSskInfo("123");
        userKengenHaneiSskInfo2.setHnsyasosikikengenkbn(C_HnsyaSosikiKengenKbn.SYOUKAI);
        bizDomManager.insert(userKengenHaneiSskInfo2);

        BW_UserIdKanrenWk userIdKanrenWk1 = new BW_UserIdKanrenWk("00", "111111");
        userIdKanrenWk1.setUserId("999");

        bizDomManager.insert(userIdKanrenWk1);

        BW_UserIdKanrenWk userIdKanrenWk2 = new BW_UserIdKanrenWk("08", "222222");
        userIdKanrenWk2.setUserId("888");

        bizDomManager.insert(userIdKanrenWk2);

        BW_UserIdKanrenWk userIdKanrenWk3 = new BW_UserIdKanrenWk("07", "333333");
        userIdKanrenWk3.setUserId("777");

        bizDomManager.insert(userIdKanrenWk3);

        BW_UserIdKanrenWk userIdKanrenWk4 = new BW_UserIdKanrenWk("06", "444444");
        userIdKanrenWk4.setUserId("666");

        bizDomManager.insert(userIdKanrenWk4);

        BW_UserWk userWk1 = new BW_UserWk("999");
        userWk1.setUserNm("ユーザー名");

        bizDomManager.insert(userWk1);

        BW_UserWk userWk2 = new BW_UserWk("888");
        userWk2.setUserNm("ユーザー名");

        bizDomManager.insert(userWk2);

        BW_UserWk userWk3 = new BW_UserWk("777");
        userWk3.setUserNm("ユーザー名");

        bizDomManager.insert(userWk3);

        BW_UserWk userWk4 = new BW_UserWk("666");
        userWk4.setUserNm("ユーザー名");

        bizDomManager.insert(userWk4);

    }
    @Test
    @TestOrder(31)
    @Transactional
    public void normal31() {

        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksBySyozokusosikicdKeta3()) {

            int iCount = 0;
            Iterator<BW_UserWk> iter = beans.iterator();
            BW_UserWk user = null;
            while (iter.hasNext()) {

                user = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("777", user.getUserId());
                    Assert.assertEquals("ユーザー名", user.getUserNm());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("888", user.getUserId());
                    Assert.assertEquals("ユーザー名", user.getUserNm());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("999", user.getUserId());
                    Assert.assertEquals("ユーザー名", user.getUserNm());

                    continue;
                }
            }
            Assert.assertEquals(3, iCount);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}

