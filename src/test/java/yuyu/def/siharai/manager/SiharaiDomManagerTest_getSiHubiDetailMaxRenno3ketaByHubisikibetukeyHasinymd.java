package yuyu.def.siharai.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.entity.JT_SiHubiDetail;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiHubiDetailMaxRenno3ketaByHubisikibetukeyHasinymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiHubiDetailMaxRenno3ketaByHubisikibetukeyHasinymd {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        Integer maxRenno = siharaiDomManager.getSiHubiDetailMaxRenno3ketaByHubisikibetukeyHasinymd("10000000080");
        Assert.assertEquals(maxRenno, null);
        JT_SiHubi siHubi1 = new JT_SiHubi("10000000080");
        siHubi1.setSyono("11807111130");

        JT_SiHubiDetail siHubiDetail1 = siHubi1.createSiHubiDetail();
        siHubiDetail1.setRenno3keta(100);
        siHubiDetail1.setHasinymd(BizDate.valueOf(20160310));

        JT_SiHubiDetail siHubiDetail2 = siHubi1.createSiHubiDetail();
        siHubiDetail2.setRenno3keta(101);
        siHubiDetail2.setHasinymd(BizDate.valueOf(20160311));

        JT_SiHubiDetail siHubiDetail3 = siHubi1.createSiHubiDetail();
        siHubiDetail3.setRenno3keta(104);

        JT_SiHubiDetail siHubiDetail4 = siHubi1.createSiHubiDetail();
        siHubiDetail4.setRenno3keta(103);
        siHubiDetail4.setHasinymd(BizDate.valueOf(20160312));

        siharaiDomManager.insert(siHubi1);

        JT_SiHubi siHubi2 = new JT_SiHubi("10000000081");
        siHubi2.setSyono("11807111130");

        JT_SiHubiDetail siHubiDetail5 = siHubi2.createSiHubiDetail();
        siHubiDetail5.setRenno3keta(105);
        siHubiDetail5.setHasinymd(BizDate.valueOf(20160410));

        siharaiDomManager.insert(siHubi2);

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

        Integer maxRenno = siharaiDomManager.getSiHubiDetailMaxRenno3ketaByHubisikibetukeyHasinymd("10000000082");
        Assert.assertEquals(maxRenno, null);

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        Integer maxRenno = siharaiDomManager.getSiHubiDetailMaxRenno3ketaByHubisikibetukeyHasinymd("10000000080");
        Assert.assertEquals(maxRenno, new Integer(103));
    }

    @Test
    @TestOrder(30)
    public void blankCondition1(){

        Integer maxRenno = siharaiDomManager.getSiHubiDetailMaxRenno3ketaByHubisikibetukeyHasinymd("");
        Assert.assertEquals(maxRenno, null);
    }
}