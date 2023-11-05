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
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全備金管理テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhBikinkanrisByKessankijyunymdBknrigikbn {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhBikinkanri> khBikinkanriLst = hozenDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbn(BizDate.valueOf(20150602), C_BknrigiKbn.DEL);
        Assert.assertEquals(0, khBikinkanriLst.size());

        IT_KhBikinkanri khBikinkanri1 = new IT_KhBikinkanri("11808111111", BizDate.valueOf(20150602), C_BkncdKbn.GENGK, BizDate.valueOf(20150708), 1);
        khBikinkanri1.setBknrigikbn(C_BknrigiKbn.DEL);

        hozenDomManager.insert(khBikinkanri1);

        IT_KhBikinkanri khBikinkanri2 = new IT_KhBikinkanri("11808111122", BizDate.valueOf(20150602), C_BkncdKbn.GENGK, BizDate.valueOf(20150708), 1);
        khBikinkanri2.setBknrigikbn(C_BknrigiKbn.DEL);

        hozenDomManager.insert(khBikinkanri2);

        IT_KhBikinkanri khBikinkanri3 = new IT_KhBikinkanri("11808111133", BizDate.valueOf(20150602), C_BkncdKbn.GENGK, BizDate.valueOf(20150708), 1);
        khBikinkanri3.setBknrigikbn(C_BknrigiKbn.DEL);

        hozenDomManager.insert(khBikinkanri3);

        IT_KhBikinkanri khBikinkanri4 = new IT_KhBikinkanri("11808111144", BizDate.valueOf(20150603), C_BkncdKbn.GENGK, BizDate.valueOf(20150708), 1);
        khBikinkanri4.setBknrigikbn(C_BknrigiKbn.DEL);

        hozenDomManager.insert(khBikinkanri4);

        IT_KhBikinkanri khBikinkanri5 = new IT_KhBikinkanri("11808111155", BizDate.valueOf(20150602), C_BkncdKbn.GENGK, BizDate.valueOf(20150708), 1);
        khBikinkanri5.setBknrigikbn(C_BknrigiKbn.BLNK);

        hozenDomManager.insert(khBikinkanri5);
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

        List<IT_KhBikinkanri> khBikinkanriLst = hozenDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbn(BizDate.valueOf(20150605), C_BknrigiKbn.DEL);
        Assert.assertEquals(0, khBikinkanriLst.size());

    }


    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KhBikinkanri> khBikinkanriLst = hozenDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbn(BizDate.valueOf(20150602), C_BknrigiKbn.BLNK);
        Assert.assertEquals(1, khBikinkanriLst.size());

        Assert.assertEquals("11808111155", khBikinkanriLst.get(0).getSyono());
        Assert.assertEquals(BizDate.valueOf(20150602), khBikinkanriLst.get(0).getKessankijyunymd());
        Assert.assertEquals(C_BkncdKbn.GENGK, khBikinkanriLst.get(0).getBkncdkbn());
        Assert.assertEquals(BizDate.valueOf(20150708), khBikinkanriLst.get(0).getBknkktymd());
        Assert.assertEquals(Integer.valueOf(1), khBikinkanriLst.get(0).getRenno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("11808111111","20150602","PC02","20150708","1"), "1");
        datamap.put($("11808111122","20150602","PC02","20150708","1"), "2");
        datamap.put($("11808111133","20150602","PC02","20150708","1"), "3");

        List<IT_KhBikinkanri> khBikinkanriLst = hozenDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbn(BizDate.valueOf(20150602), C_BknrigiKbn.DEL);

        for(IT_KhBikinkanri khBikinkanri:khBikinkanriLst){
            datamap.remove($(
                khBikinkanri.getSyono(),
                khBikinkanri.getKessankijyunymd(),
                khBikinkanri.getBkncdkbn(),
                khBikinkanri.getBknkktymd(),
                khBikinkanri.getRenno()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void delete1() {

        List<IT_KhBikinkanri> khBikinkanriLst = hozenDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbn(BizDate.valueOf(20150602), C_BknrigiKbn.DEL);
        Assert.assertEquals(3, khBikinkanriLst.size());
        hozenDomManager.delete(khBikinkanriLst);
    }
    @Test
    @TestOrder(50)
    public void delete2() {

        List<IT_KhBikinkanri> khBikinkanriLst = hozenDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbn(BizDate.valueOf(20150602), C_BknrigiKbn.DEL);
        Assert.assertEquals(0, khBikinkanriLst.size());
    }

}
