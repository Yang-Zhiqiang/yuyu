package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_BAK_SmbcStyKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getBAKSmbcStyKanrisByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getBAKSmbcStyKanrisByMosno {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_BAK_SmbcStyKanri> bAK_SmbcStyKanriLst = sinkeiyakuDomManager.getBAKSmbcStyKanrisByMosno("791112220");

        Assert.assertEquals(0,bAK_SmbcStyKanriLst.size());

        HT_BAK_SmbcStyKanri bAK_SmbcStyKanri1 = new HT_BAK_SmbcStyKanri(BizDate.valueOf(20160215), "201520161001", BizNumber.valueOf(1));
        bAK_SmbcStyKanri1.setMosno("791112220");

        sinkeiyakuDomManager.insert(bAK_SmbcStyKanri1);

        HT_BAK_SmbcStyKanri bAK_SmbcStyKanri2 = new HT_BAK_SmbcStyKanri(BizDate.valueOf(20160215), "201520161001", BizNumber.valueOf(0));
        bAK_SmbcStyKanri2.setMosno("791112238");

        sinkeiyakuDomManager.insert(bAK_SmbcStyKanri2);

        HT_BAK_SmbcStyKanri bAK_SmbcStyKanri3 = new HT_BAK_SmbcStyKanri(BizDate.valueOf(20160215), "201520161002", BizNumber.valueOf(0));
        bAK_SmbcStyKanri3.setMosno("791112246");

        sinkeiyakuDomManager.insert(bAK_SmbcStyKanri3);

        HT_BAK_SmbcStyKanri bAK_SmbcStyKanri4 = new HT_BAK_SmbcStyKanri(BizDate.valueOf(20160215), "201520161003", BizNumber.valueOf(1));
        bAK_SmbcStyKanri4.setMosno("791112246");

        sinkeiyakuDomManager.insert(bAK_SmbcStyKanri4);

        HT_BAK_SmbcStyKanri bAK_SmbcStyKanri5 = new HT_BAK_SmbcStyKanri(BizDate.valueOf(20160215), "201520161004", BizNumber.valueOf(10));
        bAK_SmbcStyKanri5.setMosno("791112246");

        sinkeiyakuDomManager.insert(bAK_SmbcStyKanri5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBAKSmbcStyKanri());

    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HT_BAK_SmbcStyKanri> bAK_SmbcStyKanriLst = sinkeiyakuDomManager.getBAKSmbcStyKanrisByMosno("791112253");

        Assert.assertEquals(0,bAK_SmbcStyKanriLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_BAK_SmbcStyKanri> bAK_SmbcStyKanriLst = sinkeiyakuDomManager.getBAKSmbcStyKanrisByMosno("791112220");

        Assert.assertEquals(1,bAK_SmbcStyKanriLst.size());

        assertEquals(BizDate.valueOf(20160215), bAK_SmbcStyKanriLst.get(0).getDatarenymd());
        assertEquals("201520161001",bAK_SmbcStyKanriLst.get(0).getTrkssikibetukey());
        assertEquals(BizNumber.ONE,bAK_SmbcStyKanriLst.get(0).getDatasakuseirenno());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(BizDate.valueOf(20160215),"201520161002",BizNumber.ZERO), "1");
        datamap.put($(BizDate.valueOf(20160215),"201520161003",BizNumber.ONE), "2");
        datamap.put($(BizDate.valueOf(20160215),"201520161004",BizNumber.TEN), "2");

        List<HT_BAK_SmbcStyKanri> bAK_SmbcStyKanriLst = sinkeiyakuDomManager.getBAKSmbcStyKanrisByMosno("791112246");

        for(HT_BAK_SmbcStyKanri baksmbcStyKanri:bAK_SmbcStyKanriLst){
            datamap.remove($(
                baksmbcStyKanri.getDatarenymd(),
                baksmbcStyKanri.getTrkssikibetukey(),
                baksmbcStyKanri.getDatasakuseirenno()));
        }

        Assert.assertEquals(3, bAK_SmbcStyKanriLst.size());

        Assert.assertTrue(datamap.isEmpty());

    }
    @Test
    @TestOrder(40)
    public void blank1() {

        List<HT_BAK_SmbcStyKanri> bAK_SmbcStyKanriLst = sinkeiyakuDomManager.getBAKSmbcStyKanrisByMosno("");

        Assert.assertEquals(0, bAK_SmbcStyKanriLst.size());

    }
}

