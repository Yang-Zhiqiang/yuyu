package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 保険金給付金備金情報抽出<br />
 * 保険金給付金備金管理テーブルエンティティリスト取得　部分主キーのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiBikinkanrisBySknoSyonoKessankijyunymdBkncdkbn {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySknoSyonoKessankijyunymdBkncdkbn(
            "11807111111","11807111118",BizDate.valueOf(20160804),C_BkncdKbn.valueOf("PC02") );
        Assert.assertEquals(0, sibikinkanriLst.size());

        JT_SiBikinkanri siBikinkanri1 = new JT_SiBikinkanri("11807111111", "11807111118", BizDate.valueOf(20160804),
            C_BkncdKbn.valueOf("PC02"), BizDate.valueOf(20160731), "1111");

        siharaiDomManager.insert(siBikinkanri1);

        JT_SiBikinkanri siBikinkanri2 = new JT_SiBikinkanri("11807111111", "11807111118", BizDate.valueOf(20160804),
            C_BkncdKbn.valueOf("PC12"), BizDate.valueOf(20160731), "1118");

        siharaiDomManager.insert(siBikinkanri2);

        JT_SiBikinkanri siBikinkanri3 = new JT_SiBikinkanri("11807111111", "11807111118", BizDate.valueOf(20160803),
            C_BkncdKbn.valueOf("PC02"), BizDate.valueOf(20160731), "1112");

        siharaiDomManager.insert(siBikinkanri3);

        JT_SiBikinkanri siBikinkanri4 = new JT_SiBikinkanri("11807111111", "11807111129", BizDate.valueOf(20160804),
            C_BkncdKbn.valueOf("PC02"), BizDate.valueOf(20160731), "1116");

        siharaiDomManager.insert(siBikinkanri4);

        JT_SiBikinkanri siBikinkanri5 = new JT_SiBikinkanri("11807111112", "11807111118", BizDate.valueOf(20160804),
            C_BkncdKbn.valueOf("PC02"), BizDate.valueOf(20160731), "1117");

        siharaiDomManager.insert(siBikinkanri5);

        JT_SiBikinkanri siBikinkanri6 = new JT_SiBikinkanri("11807111111", "11807111118", BizDate.valueOf(20160802),
            C_BkncdKbn.valueOf("PC02"), BizDate.valueOf(20160731), "1113");

        siharaiDomManager.insert(siBikinkanri6);

        JT_SiBikinkanri siBikinkanri7 = new JT_SiBikinkanri("11807111111", "11807111118", BizDate.valueOf(20160802),
            C_BkncdKbn.valueOf("PC02"), BizDate.valueOf(20160731), "1114");

        siharaiDomManager.insert(siBikinkanri7);

        JT_SiBikinkanri siBikinkanri8 = new JT_SiBikinkanri("11807111111", "11807111118", BizDate.valueOf(20160802),
            C_BkncdKbn.valueOf("PC02"), BizDate.valueOf(20160731), "1115");

        siharaiDomManager.insert(siBikinkanri8);



    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiBikinkanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySknoSyonoKessankijyunymdBkncdkbn(
            "11807111111", "11807111118", BizDate.valueOf(20160801), C_BkncdKbn.valueOf("PC02"));

        Assert.assertEquals(0, sibikinkanriLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySknoSyonoKessankijyunymdBkncdkbn(
            "11807111111", "11807111118", BizDate.valueOf(20160804), C_BkncdKbn.valueOf("PC02"));

        Assert.assertEquals(1, sibikinkanriLst.size());

        Assert.assertEquals("11807111111", sibikinkanriLst.get(0).getSkno());
        Assert.assertEquals( "11807111118", sibikinkanriLst.get(0).getSyono());
        Assert.assertEquals(BizDate.valueOf(20160804), sibikinkanriLst.get(0).getKessankijyunymd());
        Assert.assertEquals(C_BkncdKbn.valueOf("PC02"), sibikinkanriLst.get(0).getBkncdkbn());
        Assert.assertEquals(BizDate.valueOf(20160731), sibikinkanriLst.get(0).getBknkktymd());
        Assert.assertEquals( "1111", sibikinkanriLst.get(0).getKyuuhucd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("11807111111", "11807111118",BizDate.valueOf(20160802),C_BkncdKbn.valueOf("PC02"),BizDate.valueOf(20160731), "1113"), "1");
        datamap.put($("11807111111", "11807111118",BizDate.valueOf(20160802),C_BkncdKbn.valueOf("PC02"),BizDate.valueOf(20160731), "1114"), "1");
        datamap.put($("11807111111", "11807111118",BizDate.valueOf(20160802),C_BkncdKbn.valueOf("PC02"),BizDate.valueOf(20160731), "1115"), "1");

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySknoSyonoKessankijyunymdBkncdkbn(
            "11807111111", "11807111118", BizDate.valueOf(20160802),C_BkncdKbn.valueOf("PC02"));

        for(JT_SiBikinkanri siBikinkanri:sibikinkanriLst){
            datamap.remove($(
                siBikinkanri.getSkno(),
                siBikinkanri.getSyono(),
                siBikinkanri.getKessankijyunymd(),
                siBikinkanri.getBkncdkbn(),
                siBikinkanri.getBknkktymd(),
                siBikinkanri.getKyuuhucd()));
        }

        Assert.assertEquals(3, sibikinkanriLst.size());

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void normal3() {

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySknoSyonoKessankijyunymdBkncdkbn(
            "", "11807111118", BizDate.valueOf(20160804), C_BkncdKbn.valueOf("PC02"));
        Assert.assertEquals(0, sibikinkanriLst.size());

    }

    @Test
    @TestOrder(50)
    public void normal4() {

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySknoSyonoKessankijyunymdBkncdkbn(
            "11807111111", "", BizDate.valueOf(20160804), C_BkncdKbn.valueOf("PC02"));

        Assert.assertEquals(0, sibikinkanriLst.size());

    }
}
