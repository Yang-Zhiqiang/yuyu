package yuyu.def.hozen.manager;

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
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全備金管理テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhBikinkanrisByPKWithoutRenno {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhBikinkanri> khBikinkanriLst = hozenDomManager.getKhBikinkanrisByPKWithoutRenno("11807111118",BizDate.valueOf(20160725),
            C_BkncdKbn.valueOf("PC02"),BizDate.valueOf(20160725));
        Assert.assertEquals(0, khBikinkanriLst.size());

        IT_KhBikinkanri khBikinkanri1 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160725),
            C_BkncdKbn.valueOf("PC02"), BizDate.valueOf(20160725), 1);

        hozenDomManager.insert(khBikinkanri1);

        IT_KhBikinkanri khBikinkanri2 = new IT_KhBikinkanri("11807111129", BizDate.valueOf(20160725),
            C_BkncdKbn.valueOf("PC02"), BizDate.valueOf(20160725), 1);

        hozenDomManager.insert(khBikinkanri2);

        IT_KhBikinkanri khBikinkanri3 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160726),
            C_BkncdKbn.valueOf("PC02"), BizDate.valueOf(20160725), 1);

        hozenDomManager.insert(khBikinkanri3);

        IT_KhBikinkanri khBikinkanri4 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160725),
            C_BkncdKbn.valueOf("PC12"), BizDate.valueOf(20160725), 1);

        hozenDomManager.insert(khBikinkanri4);

        IT_KhBikinkanri khBikinkanri5 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160725),
            C_BkncdKbn.valueOf("PC02"), BizDate.valueOf(20160726), 1);

        hozenDomManager.insert(khBikinkanri5);

        IT_KhBikinkanri khBikinkanri6 = new IT_KhBikinkanri("11807111130", BizDate.valueOf(20160727),
            C_BkncdKbn.valueOf("PEC2"), BizDate.valueOf(20160727), 2);

        hozenDomManager.insert(khBikinkanri6);

        IT_KhBikinkanri khBikinkanri7 = new IT_KhBikinkanri("11807111130", BizDate.valueOf(20160727),
            C_BkncdKbn.valueOf("PEC2"), BizDate.valueOf(20160727), 3);

        hozenDomManager.insert(khBikinkanri7);

        IT_KhBikinkanri khBikinkanri8 = new IT_KhBikinkanri("11807111130", BizDate.valueOf(20160727),
            C_BkncdKbn.valueOf("PEC2"), BizDate.valueOf(20160727), 4);

        hozenDomManager.insert(khBikinkanri8);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhBikinkanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_KhBikinkanri> khBikinkanriLst = hozenDomManager.getKhBikinkanrisByPKWithoutRenno("11807111141",BizDate.valueOf(20160728),
            C_BkncdKbn.valueOf("PED2"),BizDate.valueOf(20160728));
        Assert.assertEquals(0, khBikinkanriLst.size());

    }


    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KhBikinkanri> khBikinkanriLst = hozenDomManager.getKhBikinkanrisByPKWithoutRenno("11807111118",BizDate.valueOf(20160725),
            C_BkncdKbn.valueOf("PC02"),BizDate.valueOf(20160725));
        Assert.assertEquals(1, khBikinkanriLst.size());

        Assert.assertEquals("11807111118", khBikinkanriLst.get(0).getSyono());
        Assert.assertEquals(BizDate.valueOf(20160725), khBikinkanriLst.get(0).getKessankijyunymd());
        Assert.assertEquals(C_BkncdKbn.valueOf("PC02"), khBikinkanriLst.get(0).getBkncdkbn());
        Assert.assertEquals(BizDate.valueOf(20160725), khBikinkanriLst.get(0).getBknkktymd());
        Assert.assertEquals(Integer.valueOf(1), khBikinkanriLst.get(0).getRenno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("11807111130","20160727","PEC2","20160727","2"), "1");
        datamap.put($("11807111130","20160727","PEC2","20160727","3"), "2");
        datamap.put($("11807111130","20160727","PEC2","20160727","4"), "3");

        List<IT_KhBikinkanri> khBikinkanriLst = hozenDomManager.getKhBikinkanrisByPKWithoutRenno("11807111130",BizDate.valueOf(20160727),
            C_BkncdKbn.valueOf("PEC2"),BizDate.valueOf(20160727));

        for(IT_KhBikinkanri khBikinkanri:khBikinkanriLst){
            datamap.remove($(
                khBikinkanri.getSyono(),
                khBikinkanri.getKessankijyunymd(),
                khBikinkanri.getBkncdkbn(),
                khBikinkanri.getBknkktymd(),
                khBikinkanri.getRenno()
                ));
        }

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_KhBikinkanri> khBikinkanriLst = hozenDomManager.getKhBikinkanrisByPKWithoutRenno("",BizDate.valueOf(20160725),
            C_BkncdKbn.valueOf("PC12"),BizDate.valueOf(20160725));

        Assert.assertEquals(0, khBikinkanriLst.size());
    }

}
