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

import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSmbcStyKanrisByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSmbcStyKanrisByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SmbcStyKanri> smbcStyKanriLLst = sinkeiyakuDomManager
            .getSmbcStyKanrisByMosno("791112220");

        Assert.assertEquals(0, smbcStyKanriLLst.size());

        HT_SmbcStyKanri smbcStyKanri1 = new HT_SmbcStyKanri(BizDate.valueOf(20160503), BizNumber.valueOf(101));
        smbcStyKanri1.setMosno("791112220");

        sinkeiyakuDomManager.insert(smbcStyKanri1);

        HT_SmbcStyKanri smbcStyKanri2 = new HT_SmbcStyKanri(BizDate.valueOf(20160503), BizNumber.valueOf(105));
        smbcStyKanri2.setMosno("791112246");

        sinkeiyakuDomManager.insert(smbcStyKanri2);

        HT_SmbcStyKanri smbcStyKanri3 = new HT_SmbcStyKanri(BizDate.valueOf(20160503), BizNumber.valueOf(102));
        smbcStyKanri3.setMosno("791112238");

        sinkeiyakuDomManager.insert(smbcStyKanri3);

        HT_SmbcStyKanri smbcStyKanri4 = new HT_SmbcStyKanri(BizDate.valueOf(20160503), BizNumber.valueOf(103));
        smbcStyKanri4.setMosno("791112238");

        sinkeiyakuDomManager.insert(smbcStyKanri4);

        HT_SmbcStyKanri smbcStyKanri5 = new HT_SmbcStyKanri(BizDate.valueOf(20160503), BizNumber.valueOf(104));
        smbcStyKanri5.setMosno("791112238");

        sinkeiyakuDomManager.insert(smbcStyKanri5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanri());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HT_SmbcStyKanri> smbcStyKanriLLst = sinkeiyakuDomManager.getSmbcStyKanrisByMosno(
            "791112279");

        assertEquals(0, smbcStyKanriLLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_SmbcStyKanri> smbcStyKanriLLst = sinkeiyakuDomManager.getSmbcStyKanrisByMosno(
            "791112220");

        assertEquals(1, smbcStyKanriLLst.size());

        assertEquals(BizDate.valueOf(20160503), smbcStyKanriLLst.get(0).getDatarenymd());
        assertEquals(BizNumber.valueOf(101), smbcStyKanriLLst.get(0).getDatasakuseirenno());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(BizDate.valueOf(20160503),BizNumber.valueOf(102)), "1");
        datamap.put($(BizDate.valueOf(20160503),BizNumber.valueOf(103)), "1");
        datamap.put($(BizDate.valueOf(20160503),BizNumber.valueOf(104)), "1");

        List<HT_SmbcStyKanri> smbcStyKanriLLst = sinkeiyakuDomManager.getSmbcStyKanrisByMosno(
            "791112238");

        for(HT_SmbcStyKanri smbcStyKanri:smbcStyKanriLLst){
            datamap.remove($(
                smbcStyKanri.getDatarenymd(),
                smbcStyKanri.getDatasakuseirenno()));
        }

        assertEquals(3, smbcStyKanriLLst.size());
        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HT_SmbcStyKanri> smbcStyKanriLLst = sinkeiyakuDomManager.getSmbcStyKanrisByMosno(
            "");
        Assert.assertEquals(0, smbcStyKanriLLst.size());

    }
}
