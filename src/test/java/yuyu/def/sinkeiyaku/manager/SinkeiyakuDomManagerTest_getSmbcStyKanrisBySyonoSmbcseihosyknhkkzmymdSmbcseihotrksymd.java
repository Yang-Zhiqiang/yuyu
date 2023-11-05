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
 * getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd("11807111118", "", "");

        Assert.assertEquals(0, smbcStyKanriLst.size());

        HT_SmbcStyKanri smbcStyKanri1 = new HT_SmbcStyKanri(BizDate.valueOf(20160218), BizNumber.ZERO);
        smbcStyKanri1.setSyono("11807111118");
        smbcStyKanri1.setSmbcseihosyknhkkzmymd("10000001");
        smbcStyKanri1.setSmbcseihotrksymd("20000001");

        sinkeiyakuDomManager.insert(smbcStyKanri1);

        HT_SmbcStyKanri smbcStyKanri2 = new HT_SmbcStyKanri(BizDate.valueOf(20160218), BizNumber.ONE);
        smbcStyKanri2.setSyono("11807111129");
        smbcStyKanri2.setSmbcseihosyknhkkzmymd("10000001");
        smbcStyKanri2.setSmbcseihotrksymd("20000001");

        sinkeiyakuDomManager.insert(smbcStyKanri2);

        HT_SmbcStyKanri smbcStyKanri3 = new HT_SmbcStyKanri(BizDate.valueOf(20160218), BizNumber.TEN);
        smbcStyKanri3.setSyono("11807111118");
        smbcStyKanri3.setSmbcseihotrksymd("20000001");

        sinkeiyakuDomManager.insert(smbcStyKanri3);

        HT_SmbcStyKanri smbcStyKanri4 = new HT_SmbcStyKanri(BizDate.valueOf(20160217), BizNumber.TEN);
        smbcStyKanri4.setSyono("11807111118");
        smbcStyKanri4.setSmbcseihosyknhkkzmymd("10000001");

        sinkeiyakuDomManager.insert(smbcStyKanri4);

        HT_SmbcStyKanri smbcStyKanri5 = new HT_SmbcStyKanri(BizDate.valueOf(20160219), BizNumber.ZERO);
        smbcStyKanri5.setSyono("11807111130");
        smbcStyKanri5.setSmbcseihosyknhkkzmymd("10000002");
        smbcStyKanri5.setSmbcseihotrksymd("20000002");

        sinkeiyakuDomManager.insert(smbcStyKanri5);

        HT_SmbcStyKanri smbcStyKanri6 = new HT_SmbcStyKanri(BizDate.valueOf(20160219), BizNumber.ONE);
        smbcStyKanri6.setSyono("11807111130");
        smbcStyKanri6.setSmbcseihosyknhkkzmymd("10000002");
        smbcStyKanri6.setSmbcseihotrksymd("20000002");

        sinkeiyakuDomManager.insert(smbcStyKanri6);

        HT_SmbcStyKanri smbcStyKanri7 = new HT_SmbcStyKanri(BizDate.valueOf(20160219), BizNumber.TEN);
        smbcStyKanri7.setSyono("11807111130");
        smbcStyKanri7.setSmbcseihosyknhkkzmymd("10000002");
        smbcStyKanri7.setSmbcseihotrksymd("20000002");

        sinkeiyakuDomManager.insert(smbcStyKanri7);

        HT_SmbcStyKanri smbcStyKanri8 = new HT_SmbcStyKanri(BizDate.valueOf(20160220), BizNumber.ZERO);
        smbcStyKanri8.setSyono("11807111118");
        smbcStyKanri8.setSmbcseihosyknhkkzmymd("");
        smbcStyKanri8.setSmbcseihotrksymd("");

        sinkeiyakuDomManager.insert(smbcStyKanri8);


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

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd("11807111141", "", "");

        assertEquals(0, smbcStyKanriLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd("11807111118", "", "");

        assertEquals(1, smbcStyKanriLst.size());
        assertEquals(BizDate.valueOf("20160218"), smbcStyKanriLst.get(0).getDatarenymd());
        assertEquals(BizNumber.ZERO,smbcStyKanriLst.get(0).getDatasakuseirenno());
    }

    @Test
    @TestOrder(30)
    public void normal2(){
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(BizDate.valueOf("20160219"),BizNumber.ZERO), "1");
        datamap.put($(BizDate.valueOf("20160219"),BizNumber.ONE), "1");
        datamap.put($(BizDate.valueOf("20160219"),BizNumber.TEN), "1");

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd("11807111130", "", "");

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

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd("11807111118", "10000001", "20000001");

        assertEquals(1, smbcStyKanriLst.size());
        assertEquals(BizDate.valueOf("20160220"), smbcStyKanriLst.get(0).getDatarenymd());
        assertEquals(BizNumber.ZERO,smbcStyKanriLst.get(0).getDatasakuseirenno());
    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd("", "", "");

        assertEquals(0, smbcStyKanriLst.size());

    }
}

