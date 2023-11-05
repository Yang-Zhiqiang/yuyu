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
 * getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd("11807111118", "");

        Assert.assertEquals(0,smbcStyKanriLst.size());

        HT_SmbcStyKanri smbcStyKanri1 = new HT_SmbcStyKanri(BizDate.valueOf(20160201), BizNumber.ONE);
        smbcStyKanri1.setSyono("11807111118");
        smbcStyKanri1.setSmbcseihosyknhkkzmymd("20000001");

        sinkeiyakuDomManager.insert(smbcStyKanri1);

        HT_SmbcStyKanri smbcStyKanri2 = new HT_SmbcStyKanri(BizDate.valueOf(20160201), BizNumber.TEN);
        smbcStyKanri2.setSyono("11807111129");
        smbcStyKanri2.setSmbcseihosyknhkkzmymd("20000001");

        sinkeiyakuDomManager.insert(smbcStyKanri2);

        HT_SmbcStyKanri smbcStyKanri3 = new HT_SmbcStyKanri(BizDate.valueOf(20160201), BizNumber.ZERO);
        smbcStyKanri3.setSyono("11807111118");

        sinkeiyakuDomManager.insert(smbcStyKanri3);

        HT_SmbcStyKanri smbcStyKanri4 = new HT_SmbcStyKanri(BizDate.valueOf(20160202), BizNumber.ONE);
        smbcStyKanri4.setSyono("11807111130");
        smbcStyKanri4.setSmbcseihosyknhkkzmymd("20000002");

        sinkeiyakuDomManager.insert(smbcStyKanri4);

        HT_SmbcStyKanri smbcStyKanri5 = new HT_SmbcStyKanri(BizDate.valueOf(20160203), BizNumber.TEN);
        smbcStyKanri5.setSyono("11807111130");
        smbcStyKanri5.setSmbcseihosyknhkkzmymd("20000002");

        sinkeiyakuDomManager.insert(smbcStyKanri5);

        HT_SmbcStyKanri smbcStyKanri6 = new HT_SmbcStyKanri(BizDate.valueOf(20160204), BizNumber.ZERO);
        smbcStyKanri6.setSyono("11807111130");
        smbcStyKanri6.setSmbcseihosyknhkkzmymd("20000002");

        sinkeiyakuDomManager.insert(smbcStyKanri6);

        HT_SmbcStyKanri smbcStyKanri7 = new HT_SmbcStyKanri(BizDate.valueOf(20160220), BizNumber.ZERO);
        smbcStyKanri7.setSyono("11807111118");
        smbcStyKanri7.setSmbcseihosyknhkkzmymd("");

        sinkeiyakuDomManager.insert(smbcStyKanri7);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd("11807111141", "");

        assertEquals(0, smbcStyKanriLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd("11807111118", "");

        assertEquals(1, smbcStyKanriLst.size());
        assertEquals(BizDate.valueOf(20160201), smbcStyKanriLst.get(0).getDatarenymd());
        assertEquals(BizNumber.ONE,smbcStyKanriLst.get(0).getDatasakuseirenno());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(BizDate.valueOf(20160202),BizNumber.ONE), "1");
        datamap.put($(BizDate.valueOf(20160203),BizNumber.TEN), "1");
        datamap.put($(BizDate.valueOf(20160204),BizNumber.ZERO), "1");

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd("11807111130", "");
        for(HT_SmbcStyKanri smbcStyKanri:smbcStyKanriLst){
            datamap.remove($(
                smbcStyKanri.getDatarenymd(),
                smbcStyKanri.getDatasakuseirenno()));
        }

        assertEquals(3, smbcStyKanriLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void normal3(){

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd("11807111118", "20000001");

        assertEquals(1, smbcStyKanriLst.size());
        assertEquals(BizDate.valueOf(20160220), smbcStyKanriLst.get(0).getDatarenymd());
        assertEquals(BizNumber.ZERO,smbcStyKanriLst.get(0).getDatasakuseirenno());
    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd("", "");

        assertEquals(0, smbcStyKanriLst.size());

    }
}

