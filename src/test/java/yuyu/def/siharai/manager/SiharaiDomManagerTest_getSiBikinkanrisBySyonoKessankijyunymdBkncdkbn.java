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
 * 保険金給付金備金管理テーブルエンティティリスト取得　死亡受付、死亡仮受付以外のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiBikinkanrisBySyonoKessankijyunymdBkncdkbn {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbn(
            "11807111118", BizDate.valueOf(20161111));
        Assert.assertEquals(0, sibikinkanriLst.size());

        JT_SiBikinkanri siBikinkanri1 = new JT_SiBikinkanri("B001", "11807111118", BizDate.valueOf(20161111),
            C_BkncdKbn.BLNK, BizDate.valueOf(20161010), "A001");

        siharaiDomManager.insert(siBikinkanri1);

        JT_SiBikinkanri siBikinkanri2 = new JT_SiBikinkanri("B001", "11807111129", BizDate.valueOf(20161111),
            C_BkncdKbn.BLNK, BizDate.valueOf(20161010), "A001");

        siharaiDomManager.insert(siBikinkanri2);

        JT_SiBikinkanri siBikinkanri3 = new JT_SiBikinkanri("B001", "11807111118", BizDate.valueOf(20160501),
            C_BkncdKbn.BLNK, BizDate.valueOf(20161010), "A001");

        siharaiDomManager.insert(siBikinkanri3);

        JT_SiBikinkanri siBikinkanri4 = new JT_SiBikinkanri("B001", "11807111118", BizDate.valueOf(20161111),
            C_BkncdKbn.SIBOUUKETUKE, BizDate.valueOf(20161010), "A001");

        siharaiDomManager.insert(siBikinkanri4);

        JT_SiBikinkanri siBikinkanri5 = new JT_SiBikinkanri("B001", "11807111118", BizDate.valueOf(20161111),
            C_BkncdKbn.SIBOUKARIUKETUKE, BizDate.valueOf(20161010), "A001");

        siharaiDomManager.insert(siBikinkanri5);

        JT_SiBikinkanri siBikinkanri6 = new JT_SiBikinkanri("B001", "11807111130", BizDate.valueOf(20161212),
            C_BkncdKbn.BLNK, BizDate.valueOf(20161010), "A001");

        siharaiDomManager.insert(siBikinkanri6);

        JT_SiBikinkanri siBikinkanri7 = new JT_SiBikinkanri("B002", "11807111130", BizDate.valueOf(20161212),
            C_BkncdKbn.BLNK, BizDate.valueOf(20161010), "A001");

        siharaiDomManager.insert(siBikinkanri7);

        JT_SiBikinkanri siBikinkanri8 = new JT_SiBikinkanri("B003", "11807111130", BizDate.valueOf(20161212),
            C_BkncdKbn.BLNK, BizDate.valueOf(20161010), "A001");

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

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbn(
            "11807111118", BizDate.valueOf(20160101));

        Assert.assertEquals(0, sibikinkanriLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbn(
            "11807111118", BizDate.valueOf(20161111));

        Assert.assertEquals(1, sibikinkanriLst.size());

        Assert.assertEquals("B001", sibikinkanriLst.get(0).getSkno());
        Assert.assertEquals("11807111118", sibikinkanriLst.get(0).getSyono());
        Assert.assertEquals(BizDate.valueOf(20161111), sibikinkanriLst.get(0).getKessankijyunymd());
        Assert.assertEquals(C_BkncdKbn.BLNK, sibikinkanriLst.get(0).getBkncdkbn());
        Assert.assertEquals(BizDate.valueOf(20161010), sibikinkanriLst.get(0).getBknkktymd());
        Assert.assertEquals("A001", sibikinkanriLst.get(0).getKyuuhucd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("B001","11807111130",BizDate.valueOf(20161212),C_BkncdKbn.BLNK,BizDate.valueOf(20161010),"A001"), "1");
        datamap.put($("B002","11807111130",BizDate.valueOf(20161212),C_BkncdKbn.BLNK,BizDate.valueOf(20161010),"A001"), "1");
        datamap.put($("B003","11807111130",BizDate.valueOf(20161212),C_BkncdKbn.BLNK,BizDate.valueOf(20161010),"A001"), "1");

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbn(
            "11807111130", BizDate.valueOf(20161212));

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

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbn(
            "", BizDate.valueOf(20161212));
        Assert.assertEquals(0, sibikinkanriLst.size());

    }
}
