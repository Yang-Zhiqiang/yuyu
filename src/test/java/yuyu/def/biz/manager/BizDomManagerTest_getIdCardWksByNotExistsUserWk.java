package yuyu.def.biz.manager;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.def.db.entity.BW_UserIdKanrenWk;
import yuyu.def.db.entity.BW_UserWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getIdCardWksByNotExistsUserWk() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getIdCardWksByNotExistsUserWk {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void preProcess(){

        deleteTestSubData();


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BW_IdCardWk> beans =
            bizDomManager.getIdCardWksByNotExistsUserWk()) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        insertSubData();

    }
    @Transactional()
    public static void insertSubData(){
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BW_IdCardWk idCardWk1 = new BW_IdCardWk("01", "000001");

        bizDomManager.insert(idCardWk1);

        BW_UserIdKanrenWk userIdKanrenWk1 = new BW_UserIdKanrenWk("01", "000001");
        userIdKanrenWk1.setUserId("11111");

        bizDomManager.insert(userIdKanrenWk1);

        BW_UserWk userWk1 = new BW_UserWk("11111");
        userWk1.setUserNm("じゃじゃ");
        userWk1.setPassword("1010");

        bizDomManager.insert(userWk1);

    }
    @Transactional
    public static void deleteTestSubData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BW_IdCardWk> idCardWkList =bizDomManager.getAllIdCardWk();
        List<BW_UserIdKanrenWk> userIdKanrenWkList = bizDomManager.getAllUserIdKanrenWk();
        List<BW_UserWk> userWkList = bizDomManager.getAllUserWk();

        if(idCardWkList.size() > 0){
            bizDomManager.delete(idCardWkList);
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

        try (ExDBResults<BW_IdCardWk> beans =
            bizDomManager.getIdCardWksByNotExistsUserWk()) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }
    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        deleteTestSubData();

        BW_IdCardWk idCardWk1 = new BW_IdCardWk("01", "000001");

        bizDomManager.insert(idCardWk1);

        BW_IdCardWk idCardWk2 = new BW_IdCardWk("02", "000002");

        bizDomManager.insert(idCardWk2);

        BW_IdCardWk idCardWk3 = new BW_IdCardWk("03", "000003");

        bizDomManager.insert(idCardWk3);

        BW_IdCardWk idCardWk4 = new BW_IdCardWk("05", "000001");

        bizDomManager.insert(idCardWk4);

        BW_UserIdKanrenWk userIdKanrenWk1 = new BW_UserIdKanrenWk("01", "000001");
        userIdKanrenWk1.setUserId("11111");

        bizDomManager.insert(userIdKanrenWk1);

        BW_UserIdKanrenWk userIdKanrenWk2 = new BW_UserIdKanrenWk("02", "000002");
        userIdKanrenWk2.setUserId("22222");

        bizDomManager.insert(userIdKanrenWk2);

        BW_UserIdKanrenWk userIdKanrenWk3 = new BW_UserIdKanrenWk("03", "333333");
        userIdKanrenWk3.setUserId("33333");

        bizDomManager.insert(userIdKanrenWk3);

        BW_UserWk userWk1 = new BW_UserWk("22222");
        userWk1.setUserNm("じゃじゃ");
        userWk1.setPassword("1010");

        bizDomManager.insert(userWk1);

    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {

        try (ExDBResults<BW_IdCardWk> beans = bizDomManager.getIdCardWksByNotExistsUserWk())
        {

            int iCount = 0;
            Iterator<BW_IdCardWk> iter = beans.iterator();
            BW_IdCardWk bW_IdCardWk = null;
            while (iter.hasNext()) {

                bW_IdCardWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("01", bW_IdCardWk.getIdkbn());
                    Assert.assertEquals("000001", bW_IdCardWk.getIdcd());
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
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        deleteTestSubData();


        BW_IdCardWk idCardWk1 = new BW_IdCardWk("05", "000004");

        bizDomManager.insert(idCardWk1);

        BW_IdCardWk idCardWk2 = new BW_IdCardWk("03", "000000");

        bizDomManager.insert(idCardWk2);

        BW_IdCardWk idCardWk3 = new BW_IdCardWk("01", "000003");

        bizDomManager.insert(idCardWk3);

        BW_IdCardWk idCardWk4 = new BW_IdCardWk("01", "000002");

        bizDomManager.insert(idCardWk4);

        BW_IdCardWk idCardWk5 = new BW_IdCardWk("01", "000001");

        bizDomManager.insert(idCardWk5);

        BW_UserIdKanrenWk userIdKanrenWk1 = new BW_UserIdKanrenWk("05", "000004");
        userIdKanrenWk1.setUserId("11111");

        bizDomManager.insert(userIdKanrenWk1);

        BW_UserIdKanrenWk userIdKanrenWk2 = new BW_UserIdKanrenWk("03", "000000");
        userIdKanrenWk2.setUserId("22222");

        bizDomManager.insert(userIdKanrenWk2);

        BW_UserIdKanrenWk userIdKanrenWk3 = new BW_UserIdKanrenWk("01", "000003");
        userIdKanrenWk3.setUserId("33333");

        bizDomManager.insert(userIdKanrenWk3);

        BW_UserIdKanrenWk userIdKanrenWk4 = new BW_UserIdKanrenWk("01", "000002");
        userIdKanrenWk4.setUserId("55555");

        bizDomManager.insert(userIdKanrenWk4);

        BW_UserIdKanrenWk userIdKanrenWk5 = new BW_UserIdKanrenWk("01", "000001");
        userIdKanrenWk5.setUserId("66666");

        bizDomManager.insert(userIdKanrenWk5);

        BW_UserWk userWk1 = new BW_UserWk("44444");
        userWk1.setUserNm("じゃじゃ");
        userWk1.setPassword("1010");

        bizDomManager.insert(userWk1);

    }

    @Test
    @TestOrder(31)
    public void normal31() {

        try (ExDBResults<BW_IdCardWk> beans = bizDomManager.getIdCardWksByNotExistsUserWk())
        {

            int iCount = 0;
            Iterator<BW_IdCardWk> iter = beans.iterator();
            BW_IdCardWk bW_IdCardWk = null;
            while (iter.hasNext()) {

                bW_IdCardWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("01", bW_IdCardWk.getIdkbn());
                    Assert.assertEquals("000001", bW_IdCardWk.getIdcd());
                    continue;
                }
                if (2 == iCount) {

                    Assert.assertEquals("01", bW_IdCardWk.getIdkbn());
                    Assert.assertEquals("000002", bW_IdCardWk.getIdcd());
                    continue;
                }
                if (3 == iCount) {

                    Assert.assertEquals("01", bW_IdCardWk.getIdkbn());
                    Assert.assertEquals("000003", bW_IdCardWk.getIdcd());
                    continue;
                }
                if (4 == iCount) {

                    Assert.assertEquals("03", bW_IdCardWk.getIdkbn());
                    Assert.assertEquals("000000", bW_IdCardWk.getIdcd());
                    continue;
                }
                if (5 == iCount) {

                    Assert.assertEquals("05", bW_IdCardWk.getIdkbn());
                    Assert.assertEquals("000004", bW_IdCardWk.getIdcd());
                    continue;
                }
            }

            Assert.assertEquals(5, iCount);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }

}


