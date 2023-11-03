package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JT_SiHubi;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiHubisBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiHubisBySyono {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SiHubi> siHubiLst = siharaiDomManager.getSiHubisBySyono("11807111118");
        Assert.assertEquals(0, siHubiLst.size());

        JT_SiHubi siHubi1 = new JT_SiHubi("10012002");
        siHubi1.setSyono("11807111118");

        siharaiDomManager.insert(siHubi1);

        JT_SiHubi siHubi2 = new JT_SiHubi("10012003");
        siHubi2.setSyono("11807111129");

        siharaiDomManager.insert(siHubi2);

        JT_SiHubi siHubi3 = new JT_SiHubi("20021101");
        siHubi3.setSyono("11807111152");

        siharaiDomManager.insert(siHubi3);

        JT_SiHubi siHubi4 = new JT_SiHubi("20021102");
        siHubi4.setSyono("11807111152");

        siharaiDomManager.insert(siHubi4);

        JT_SiHubi siHubi5 = new JT_SiHubi("20021103");
        siHubi5.setSyono("11807111152");

        siharaiDomManager.insert(siHubi5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiHubi());
    }


    @Test
    @TestOrder(10)
    public void noResult1() {
        List<JT_SiHubi> siHubiLst = siharaiDomManager.getSiHubisBySyono("11807111174");
        Assert.assertEquals(0, siHubiLst.size());
    }

    @Test
    @TestOrder(20)
    public void blankCondition1() {
        List<JT_SiHubi> siHubiLst = siharaiDomManager.getSiHubisBySyono("");
        Assert.assertEquals(0, siHubiLst.size());
    }

    @Test
    @TestOrder(30)
    public void normal1() {
        List<JT_SiHubi> siHubiLst = siharaiDomManager.getSiHubisBySyono("11807111118");
        Assert.assertEquals(1, siHubiLst.size());

        Assert.assertEquals("10012002", siHubiLst.get(0).getHubisikibetukey());

    }

    @Test
    @TestOrder(40)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("20021101"), "1");
        datamap.put($("20021102"), "1");
        datamap.put($("20021103"), "1");

        List<JT_SiHubi> siHubiLst = siharaiDomManager.getSiHubisBySyono("11807111152");

        for(JT_SiHubi siHubi:siHubiLst){
            datamap.remove($(siHubi.getHubisikibetukey()));
        }
        Assert.assertEquals(3, siHubiLst.size());

        Assert.assertTrue(datamap.isEmpty());
    }

}
