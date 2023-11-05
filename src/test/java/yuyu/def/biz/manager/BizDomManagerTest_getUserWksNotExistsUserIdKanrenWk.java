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

import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.db.entity.BW_UserIdKanrenWk;
import yuyu.def.db.entity.BW_UserWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getUserWksNotExistsUserIdKanrenWk() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getUserWksNotExistsUserIdKanrenWk {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBUpdatableResults<BW_UserWk> beans = bizDomManager.getUserWksNotExistsUserIdKanrenWk()) {
            Assert.assertFalse(beans.iterator().hasNext());
        }

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BW_UserWk userWk1 = new BW_UserWk("888");
        userWk1.setUserNm("きき");
        userWk1.setSpecialUserKbn(C_SpecialUserKbn.SUPER);

        bizDomManager.insert(userWk1);

        BW_UserWk userWk2 = new BW_UserWk("777");
        userWk2.setUserNm("かか");
        userWk2.setSpecialUserKbn(C_SpecialUserKbn.IPPAN);

        bizDomManager.insert(userWk2);

        BW_UserIdKanrenWk userIdKanrenWk1 = new BW_UserIdKanrenWk("01", "01");
        userIdKanrenWk1.setUserId("777");

        bizDomManager.insert(userIdKanrenWk1);
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBUpdatableResults<BW_UserWk> beans = bizDomManager.getUserWksNotExistsUserIdKanrenWk()) {
            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {

        bizDomManager.delete(bizDomManager.getAllUserWk());
        bizDomManager.delete(bizDomManager.getAllUserIdKanrenWk());

        BW_UserWk userWk1 = new BW_UserWk("999");
        userWk1.setUserNm("きき");
        userWk1.setSpecialUserKbn(C_SpecialUserKbn.IPPAN);

        bizDomManager.insert(userWk1);

        BW_UserWk userWk2 = new BW_UserWk("888");
        userWk2.setUserNm("かか");
        userWk2.setSpecialUserKbn(C_SpecialUserKbn.SUPER);

        bizDomManager.insert(userWk2);

        BW_UserWk userWk3 = new BW_UserWk("777");
        userWk3.setUserNm("びび");
        userWk3.setSpecialUserKbn(C_SpecialUserKbn.IPPAN);

        bizDomManager.insert(userWk3);

        BW_UserIdKanrenWk userIdKanrenWk1 = new BW_UserIdKanrenWk("01", "01");
        userIdKanrenWk1.setUserId("777");

        bizDomManager.insert(userIdKanrenWk1);

    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {

        try (ExDBUpdatableResults<BW_UserWk> beans = bizDomManager.getUserWksNotExistsUserIdKanrenWk()) {
            int iCount = 0;
            Iterator<BW_UserWk> iter = beans.iterator();
            BW_UserWk bW_UserWk = null;
            while (iter.hasNext()) {

                bW_UserWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("999", bW_UserWk.getUserId());

                    continue;
                }
            }
            Assert.assertEquals(1,iCount);
        }
    }
    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {

        bizDomManager.delete(bizDomManager.getAllUserWk());
        bizDomManager.delete(bizDomManager.getAllUserIdKanrenWk());

        BW_UserWk userWk1 = new BW_UserWk("666");
        userWk1.setUserNm("きき");
        userWk1.setSpecialUserKbn(C_SpecialUserKbn.IPPAN);

        bizDomManager.insert(userWk1);

        BW_UserWk userWk2 = new BW_UserWk("555");
        userWk2.setUserNm("かか");
        userWk2.setSpecialUserKbn(C_SpecialUserKbn.IPPAN);

        bizDomManager.insert(userWk2);

        BW_UserWk userWk3 = new BW_UserWk("444");
        userWk3.setUserNm("びび");
        userWk3.setSpecialUserKbn(C_SpecialUserKbn.IPPAN);

        bizDomManager.insert(userWk3);

        BW_UserIdKanrenWk userIdKanrenWk1 = new BW_UserIdKanrenWk("01", "01");
        userIdKanrenWk1.setUserId("777");

        bizDomManager.insert(userIdKanrenWk1);

    }

    @Test
    @TestOrder(31)
    @Transactional
    public void normal31() {

        try (ExDBUpdatableResults<BW_UserWk> beans = bizDomManager.getUserWksNotExistsUserIdKanrenWk()) {
            int iCount = 0;
            Iterator<BW_UserWk> iter = beans.iterator();
            BW_UserWk bW_UserWk = null;
            while (iter.hasNext()) {

                bW_UserWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("444", bW_UserWk.getUserId());

                    continue;
                }
                if (2 == iCount) {

                    Assert.assertEquals("555", bW_UserWk.getUserId());

                    continue;
                }
                if (3 == iCount) {

                    Assert.assertEquals("666", bW_UserWk.getUserId());

                    continue;
                }
            }
            Assert.assertEquals(3,iCount);
        }
    }



    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BW_UserWk> userWkList = bizDomManager.getAllUserWk();
        if(userWkList.size() > 0){
            bizDomManager.delete(userWkList);
        }
        List<BW_UserIdKanrenWk> userIdKanrenWkList = bizDomManager.getAllUserIdKanrenWk();
        if(userIdKanrenWkList.size() > 0){
            bizDomManager.delete(userIdKanrenWkList);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
