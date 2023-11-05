package yuyu.def.siharai.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.entity.JT_SiHubiDetail;
import yuyu.def.siharai.result.bean.HubiTourokuInfosByHasinymdBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getByoumeisByByoumeikjByoumeiknByoumeicd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getHubiTourokuInfosByHasinymd {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        ExDBResults<HubiTourokuInfosByHasinymdBean> beans = siharaiDomManager.
                getHubiTourokuInfosByHasinymd(BizDate.valueOf(20160310));

        int iCount = 0;
        for (HubiTourokuInfosByHasinymdBean HTIBbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        JT_SiHubi siHubi1 = new JT_SiHubi("10000000070");
        siHubi1.setSyono("11807111118");

        siharaiDomManager.insert(siHubi1);

        JT_SiHubi siHubi2 = new JT_SiHubi("10000000080");
        siHubi2.setSyono("11807111130");

        JT_SiHubiDetail siHubiDetail1 = siHubi2.createSiHubiDetail();
        siHubiDetail1.setRenno3keta(100);
        siHubiDetail1.setHasinymd(BizDate.valueOf(20160310));
        siHubiDetail1.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));

        JT_SiHubiDetail siHubiDetail2 = siHubi2.createSiHubiDetail();
        siHubiDetail2.setRenno3keta(101);
        siHubiDetail2.setHasinymd(BizDate.valueOf(20160310));
        siHubiDetail2.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));

        JT_SiHubiDetail siHubiDetail3 = siHubi2.createSiHubiDetail();
        siHubiDetail3.setRenno3keta(102);
        siHubiDetail3.setHasinymd(BizDate.valueOf(20160311));
        siHubiDetail3.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));

        JT_SiHubiDetail siHubiDetail4 = siHubi2.createSiHubiDetail();
        siHubiDetail4.setRenno3keta(103);
        siHubiDetail4.setHasinymd(BizDate.valueOf(20160310));
        siHubiDetail4.setKaisyouymd(BizDate.valueOf(20160311));
        siHubiDetail4.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));

        JT_SiHubiDetail siHubiDetail8 = siHubi2.createSiHubiDetail();
        siHubiDetail8.setRenno3keta(104);
        siHubiDetail8.setHasinymd(BizDate.valueOf(20160410));
        siHubiDetail8.setHassinsakikbn(C_HassinsakiKbn.valueOf("3"));

        JT_SiHubiDetail siHubiDetail9 = siHubi2.createSiHubiDetail();
        siHubiDetail9.setRenno3keta(105);
        siHubiDetail9.setHasinymd(BizDate.valueOf(20160410));
        siHubiDetail9.setHassinsakikbn(C_HassinsakiKbn.valueOf("2"));

        JT_SiHubiDetail siHubiDetail10 = siHubi2.createSiHubiDetail();
        siHubiDetail10.setRenno3keta(106);
        siHubiDetail10.setHasinymd(BizDate.valueOf(20160410));
        siHubiDetail10.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));

        JT_SiHubiDetail siHubiDetail11 = siHubi2.createSiHubiDetail();
        siHubiDetail11.setRenno3keta(107);
        siHubiDetail11.setHasinymd(BizDate.valueOf(20160410));
        siHubiDetail11.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));

        siharaiDomManager.insert(siHubi2);

        JT_SiHubi siHubi3 = new JT_SiHubi("10000000081");
        siHubi3.setSyono("11807111118");

        JT_SiHubiDetail siHubiDetail7 = siHubi3.createSiHubiDetail();
        siHubiDetail7.setRenno3keta(100);
        siHubiDetail7.setHasinymd(BizDate.valueOf(20160410));
        siHubiDetail7.setHassinsakikbn(C_HassinsakiKbn.valueOf("3"));

        siharaiDomManager.insert(siHubi3);

        JT_SiHubi siHubi4 = new JT_SiHubi("10000000082");
        siHubi4.setSyono("11807111118");

        JT_SiHubiDetail siHubiDetail5 = siHubi4.createSiHubiDetail();
        siHubiDetail5.setRenno3keta(100);
        siHubiDetail5.setHasinymd(BizDate.valueOf(20160410));
        siHubiDetail5.setHassinsakikbn(C_HassinsakiKbn.valueOf("3"));

        JT_SiHubiDetail siHubiDetail6 = siHubi4.createSiHubiDetail();
        siHubiDetail6.setRenno3keta(101);
        siHubiDetail6.setHasinymd(BizDate.valueOf(20160410));
        siHubiDetail6.setHassinsakikbn(C_HassinsakiKbn.valueOf("3"));

        siharaiDomManager.insert(siHubi4);



    }


    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiHubi());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        ExDBResults<HubiTourokuInfosByHasinymdBean> beans = siharaiDomManager.getHubiTourokuInfosByHasinymd(BizDate.valueOf(20150310));

        int iCount = 0;
        for (HubiTourokuInfosByHasinymdBean HTIBbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        ExDBResults<HubiTourokuInfosByHasinymdBean> beans = siharaiDomManager.getHubiTourokuInfosByHasinymd(BizDate.valueOf(20160310));

        int iCount = 0;
        for (HubiTourokuInfosByHasinymdBean HTIBbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("10000000080", HTIBbean.getJT_SiHubi().getHubisikibetukey());
                Assert.assertEquals("11807111130", HTIBbean.getJT_SiHubi().getSyono());

                Assert.assertEquals("10000000080", HTIBbean.getHubisikibetukey());
                Assert.assertEquals(BizDate.valueOf(20160310), HTIBbean.getHasinymd());
                Assert.assertEquals(C_HassinsakiKbn.SYA, HTIBbean.getHassinsakikbn());

            }

            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        ExDBResults<HubiTourokuInfosByHasinymdBean> beans = siharaiDomManager.getHubiTourokuInfosByHasinymd(BizDate.valueOf(20160410));

        int iCount = 0;
        for (HubiTourokuInfosByHasinymdBean HTIBbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("10000000081", HTIBbean.getJT_SiHubi().getHubisikibetukey());
                Assert.assertEquals("11807111118", HTIBbean.getJT_SiHubi().getSyono());

                Assert.assertEquals("10000000081", HTIBbean.getHubisikibetukey());
                Assert.assertEquals(BizDate.valueOf(20160410), HTIBbean.getHasinymd());
                Assert.assertEquals(C_HassinsakiKbn.DRTEN, HTIBbean.getHassinsakikbn());

            }

            if (2 == iCount) {

                Assert.assertEquals("10000000082", HTIBbean.getJT_SiHubi().getHubisikibetukey());
                Assert.assertEquals("11807111118", HTIBbean.getJT_SiHubi().getSyono());

                Assert.assertEquals("10000000082", HTIBbean.getHubisikibetukey());
                Assert.assertEquals(BizDate.valueOf(20160410), HTIBbean.getHasinymd());
                Assert.assertEquals(C_HassinsakiKbn.DRTEN, HTIBbean.getHassinsakikbn());

            }

            if (3 == iCount) {

                Assert.assertEquals("10000000080", HTIBbean.getJT_SiHubi().getHubisikibetukey());
                Assert.assertEquals("11807111130", HTIBbean.getJT_SiHubi().getSyono());

                Assert.assertEquals("10000000080", HTIBbean.getHubisikibetukey());
                Assert.assertEquals(BizDate.valueOf(20160410), HTIBbean.getHasinymd());
                Assert.assertEquals(C_HassinsakiKbn.SYA, HTIBbean.getHassinsakikbn());

            }

            if (4 == iCount) {

                Assert.assertEquals("10000000080", HTIBbean.getJT_SiHubi().getHubisikibetukey());
                Assert.assertEquals("11807111130", HTIBbean.getJT_SiHubi().getSyono());

                Assert.assertEquals("10000000080", HTIBbean.getHubisikibetukey());
                Assert.assertEquals(BizDate.valueOf(20160410), HTIBbean.getHasinymd());
                Assert.assertEquals(C_HassinsakiKbn.KOK, HTIBbean.getHassinsakikbn());

            }

            if (5 == iCount) {

                Assert.assertEquals("10000000080", HTIBbean.getJT_SiHubi().getHubisikibetukey());
                Assert.assertEquals("11807111130", HTIBbean.getJT_SiHubi().getSyono());

                Assert.assertEquals("10000000080", HTIBbean.getHubisikibetukey());
                Assert.assertEquals(BizDate.valueOf(20160410), HTIBbean.getHasinymd());
                Assert.assertEquals(C_HassinsakiKbn.DRTEN, HTIBbean.getHassinsakikbn());

            }
        }
        Assert.assertEquals(5, iCount);

    }
}