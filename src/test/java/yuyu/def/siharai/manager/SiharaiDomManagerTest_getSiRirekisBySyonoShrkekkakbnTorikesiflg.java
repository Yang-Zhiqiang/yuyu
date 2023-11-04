package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiRirekisBySyonoShrkekkakbnTorikesiflg() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class SiharaiDomManagerTest_getSiRirekisBySyonoShrkekkakbnTorikesiflg {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        List<JT_SiRireki> siRirekiLst = siharaiDomManager.getSiRirekisBySyonoShrkekkakbnTorikesiflg("10000000011", C_ShrKekkaKbn.HSHR,C_UmuKbn.NONE);

        Assert.assertEquals(0,siRirekiLst.size());

        JT_SkKihon skKihon1 = new JT_SkKihon("20160105000000001", "10000000011");
        JT_SiRireki siRireki1 = skKihon1.createSiRireki();
        siRireki1.setShrsikibetukey("SNK001");
        siRireki1.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki1.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("20160105000000002", "10000000011");
        JT_SiRireki siRireki2 = skKihon2.createSiRireki();
        siRireki2.setShrsikibetukey("SNK002");
        siRireki2.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki2.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("20160105000000003", "10000000011");
        JT_SiRireki siRireki3 = skKihon3.createSiRireki();
        siRireki3.setShrsikibetukey("SNK003");
        siRireki3.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki3.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("20160105000000001", "10000000012");
        JT_SiRireki siRireki4 = skKihon4.createSiRireki();
        siRireki4.setShrsikibetukey("SNK001");
        siRireki4.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki4.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("20160105000000004", "10000000011");
        JT_SiRireki siRireki5 = skKihon5.createSiRireki();
        siRireki5.setShrsikibetukey("SNK004");
        siRireki5.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki5.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(skKihon5);


        JT_SkKihon skKihon6 = new JT_SkKihon("20160105000000005", "10000000011");
        JT_SiRireki siRireki6 = skKihon6.createSiRireki();
        siRireki6.setShrsikibetukey("SNK005");
        siRireki6.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki6.setTorikesiflg(C_UmuKbn.ARI);
        siharaiDomManager.insert(skKihon6);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<JT_SiRireki> siRirekiLst = siharaiDomManager.getSiRirekisBySyonoShrkekkakbnTorikesiflg("10000000011", C_ShrKekkaKbn.SHR,C_UmuKbn.ARI);

        Assert.assertEquals(0, siRirekiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<JT_SiRireki> siRirekiLst = siharaiDomManager.getSiRirekisBySyonoShrkekkakbnTorikesiflg("10000000012", C_ShrKekkaKbn.HSHR,C_UmuKbn.NONE);


        Assert.assertEquals(1, siRirekiLst.size());
        Assert.assertEquals("20160105000000001", siRirekiLst.get(0).getSkno());
        Assert.assertEquals("10000000012", siRirekiLst.get(0).getSyono());
        Assert.assertEquals("SNK001", siRirekiLst.get(0).getShrsikibetukey());
        Assert.assertEquals(C_ShrKekkaKbn.HSHR, siRirekiLst.get(0).getShrkekkakbn());
        Assert.assertEquals(C_UmuKbn.NONE, siRirekiLst.get(0).getTorikesiflg());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("20160105000000001","10000000011","SNK001",C_ShrKekkaKbn.HSHR,C_UmuKbn.NONE), "1");
        datamap.put($("20160105000000002","10000000011","SNK002",C_ShrKekkaKbn.HSHR,C_UmuKbn.NONE), "1");
        datamap.put($("20160105000000003","10000000011","SNK003",C_ShrKekkaKbn.HSHR,C_UmuKbn.NONE), "1");

        List<JT_SiRireki> siRirekiLst = siharaiDomManager.getSiRirekisBySyonoShrkekkakbnTorikesiflg("10000000011", C_ShrKekkaKbn.HSHR,C_UmuKbn.NONE);

        for(JT_SiRireki siRireki:siRirekiLst){
            datamap.remove($(
                siRireki.getSkno(),
                siRireki.getSyono(),
                siRireki.getShrsikibetukey(),
                siRireki.getShrkekkakbn(),
                siRireki.getTorikesiflg()));

        }


        Assert.assertEquals(3, siRirekiLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }
}
