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
 * SiharaiDomManagerクラスの、<br />
 * getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns{

    @Inject
    SiharaiDomManager siharaiDomManager;

    private final static C_BkncdKbn[] bkncdkbn1 = {C_BkncdKbn.BLNK,C_BkncdKbn.GENGK};
    private final static C_BkncdKbn[] bkncdkbn2 = {C_BkncdKbn.KAIYAKU,C_BkncdKbn.SIBOUUKETUKE,C_BkncdKbn.SIBOUKARIUKETUKE};
    private final static C_BkncdKbn[] bkncdkbn3 = {C_BkncdKbn.BLNK,C_BkncdKbn.GENGK,C_BkncdKbn.KAIYAKU};
    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SiBikinkanri> JT_SiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns("11807111118",BizDate.valueOf(20160804),bkncdkbn1);

        Assert.assertEquals(0,JT_SiBikinkanriLst.size());

        JT_SiBikinkanri siBikinkanri1 = new JT_SiBikinkanri("0001", "11807111118", BizDate.valueOf(20160804), C_BkncdKbn.valueOf("0"), BizDate.valueOf(20160807), "01");

        siharaiDomManager.insert(siBikinkanri1);

        JT_SiBikinkanri siBikinkanri2 = new JT_SiBikinkanri("0001", "11807111129", BizDate.valueOf(20160804), C_BkncdKbn.valueOf("0"), BizDate.valueOf(20160807), "02");

        siharaiDomManager.insert(siBikinkanri2);

        JT_SiBikinkanri siBikinkanri3 = new JT_SiBikinkanri("0001", "11807111118", BizDate.valueOf(20160803), C_BkncdKbn.valueOf("0"), BizDate.valueOf(20160807), "03");

        siharaiDomManager.insert(siBikinkanri3);

        JT_SiBikinkanri siBikinkanri4 = new JT_SiBikinkanri("0001", "11807111118", BizDate.valueOf(20160804), C_BkncdKbn.valueOf("PED2"), BizDate.valueOf(20160807), "04");

        siharaiDomManager.insert(siBikinkanri4);

        JT_SiBikinkanri siBikinkanri5 = new JT_SiBikinkanri("0002", "11807111130", BizDate.valueOf(20160804), C_BkncdKbn.valueOf("0"), BizDate.valueOf(20160807), "05");

        siharaiDomManager.insert(siBikinkanri5);

        JT_SiBikinkanri siBikinkanri6 = new JT_SiBikinkanri("0003", "11807111130", BizDate.valueOf(20160804), C_BkncdKbn.valueOf("PC02"), BizDate.valueOf(20160807), "06");

        siharaiDomManager.insert(siBikinkanri6);

        JT_SiBikinkanri siBikinkanri7 = new JT_SiBikinkanri("0004", "11807111130", BizDate.valueOf(20160804), C_BkncdKbn.valueOf("PC12"), BizDate.valueOf(20160807), "07");

        siharaiDomManager.insert(siBikinkanri7);

    }


    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiBikinkanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<JT_SiBikinkanri> JT_SiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns("11807111118",BizDate.valueOf(20160804),bkncdkbn2);

        Assert.assertEquals(0,JT_SiBikinkanriLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<JT_SiBikinkanri> JT_SiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns("11807111118",BizDate.valueOf(20160804),bkncdkbn1);

        Assert.assertEquals(1,JT_SiBikinkanriLst.size());

        Assert.assertEquals("0001", JT_SiBikinkanriLst.get(0).getSkno());
        Assert.assertEquals("11807111118", JT_SiBikinkanriLst.get(0).getSyono());
        Assert.assertEquals(BizDate.valueOf(20160804), JT_SiBikinkanriLst.get(0).getKessankijyunymd());
        Assert.assertEquals(C_BkncdKbn.BLNK, JT_SiBikinkanriLst.get(0).getBkncdkbn());
        Assert.assertEquals(BizDate.valueOf(20160807), JT_SiBikinkanriLst.get(0).getBknkktymd());
        Assert.assertEquals("01", JT_SiBikinkanriLst.get(0).getKyuuhucd());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("0002","11807111130",BizDate.valueOf(20160804),C_BkncdKbn.BLNK,BizDate.valueOf(20160807),"05"), "1");
        datamap.put($("0003","11807111130",BizDate.valueOf(20160804),C_BkncdKbn.GENGK,BizDate.valueOf(20160807),"06"), "2");
        datamap.put($("0004","11807111130",BizDate.valueOf(20160804),C_BkncdKbn.KAIYAKU,BizDate.valueOf(20160807),"07"), "2");

        List<JT_SiBikinkanri> JT_SiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns("11807111130",BizDate.valueOf(20160804),bkncdkbn3);

        for(JT_SiBikinkanri siBikinkanri:JT_SiBikinkanriLst){
            datamap.remove($(
                siBikinkanri.getSkno(),
                siBikinkanri.getSyono(),
                siBikinkanri.getKessankijyunymd(),
                siBikinkanri.getBkncdkbn(),
                siBikinkanri.getBknkktymd(),
                siBikinkanri.getKyuuhucd()));
        }

        Assert.assertEquals(3,JT_SiBikinkanriLst.size());

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void normal3(){

        List<JT_SiBikinkanri> JT_SiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns("",BizDate.valueOf(20160804),bkncdkbn3);

        Assert.assertEquals(0,JT_SiBikinkanriLst.size());
    }

}