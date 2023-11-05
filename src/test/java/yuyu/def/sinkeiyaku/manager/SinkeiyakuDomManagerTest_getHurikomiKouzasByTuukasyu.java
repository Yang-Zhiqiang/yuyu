package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getHurikomiKouzasByTuukasyu() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHurikomiKouzasByTuukasyu {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByTuukasyu(C_Tuukasyu.AUD);

        Assert.assertEquals(0,hurikomiKouzaLst.size());

        HM_HurikomiKouza hurikomiKouza = new HM_HurikomiKouza();
        hurikomiKouza.setBankcd("1001");
        hurikomiKouza.setSitencd("101");
        hurikomiKouza.setKouzano("10000000001");
        hurikomiKouza.setTuukasyu(C_Tuukasyu.AUD);
        hurikomiKouza.setHrkmirnincd("1000000001");
        sinkeiyakuDomManager.insert(hurikomiKouza);

        HM_HurikomiKouza hurikomiKouza2 = new HM_HurikomiKouza();
        hurikomiKouza2.setBankcd("1002");
        hurikomiKouza2.setSitencd("102");
        hurikomiKouza2.setKouzano("10000000002");
        hurikomiKouza2.setTuukasyu(C_Tuukasyu.BLNK);
        hurikomiKouza2.setHrkmirnincd("1000000002");
        sinkeiyakuDomManager.insert(hurikomiKouza2);

        HM_HurikomiKouza hurikomiKouza3 = new HM_HurikomiKouza();
        hurikomiKouza3.setBankcd("1003");
        hurikomiKouza3.setSitencd("103");
        hurikomiKouza3.setKouzano("10000000003");
        hurikomiKouza3.setTuukasyu(C_Tuukasyu.EUR);
        hurikomiKouza3.setHrkmirnincd("1000000003");
        sinkeiyakuDomManager.insert(hurikomiKouza3);

        HM_HurikomiKouza hurikomiKouza4 = new HM_HurikomiKouza();
        hurikomiKouza4.setBankcd("1004");
        hurikomiKouza4.setSitencd("104");
        hurikomiKouza4.setKouzano("10000000004");
        hurikomiKouza4.setTuukasyu(C_Tuukasyu.EUR);
        hurikomiKouza4.setHrkmirnincd("1000000004");
        sinkeiyakuDomManager.insert(hurikomiKouza4);

        HM_HurikomiKouza hurikomiKouza5 = new HM_HurikomiKouza();
        hurikomiKouza5.setBankcd("1005");
        hurikomiKouza5.setSitencd("105");
        hurikomiKouza5.setKouzano("10000000005");
        hurikomiKouza5.setTuukasyu(C_Tuukasyu.EUR);
        hurikomiKouza5.setHrkmirnincd("1000000005");
        sinkeiyakuDomManager.insert(hurikomiKouza5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHurikomiKouza());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByTuukasyu(C_Tuukasyu.JPY);

        assertEquals(0, hurikomiKouzaLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByTuukasyu(C_Tuukasyu.AUD);

        assertEquals(1, hurikomiKouzaLst.size());
        assertEquals("1001", hurikomiKouzaLst.get(0).getBankcd());
        assertEquals("101",hurikomiKouzaLst.get(0).getSitencd());
        assertEquals("10000000001",hurikomiKouzaLst.get(0).getKouzano());
        assertEquals(C_Tuukasyu.AUD, hurikomiKouzaLst.get(0).getTuukasyu());
        assertEquals("1000000001", hurikomiKouzaLst.get(0).getHrkmirnincd());
    }

    @Test
    @TestOrder(30)
    public void normal2(){
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("1003","103","10000000003",C_Tuukasyu.EUR,"1000000003"), "1");
        datamap.put($("1004","104","10000000004",C_Tuukasyu.EUR,"1000000004"), "1");
        datamap.put($("1005","105","10000000005",C_Tuukasyu.EUR,"1000000005"), "1");

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByTuukasyu(C_Tuukasyu.EUR);

        for(HM_HurikomiKouza hurikomiKouza:hurikomiKouzaLst){
            datamap.remove($(
                hurikomiKouza.getBankcd(),
                hurikomiKouza.getSitencd(),
                hurikomiKouza.getKouzano(),
                hurikomiKouza.getTuukasyu(),
                hurikomiKouza.getHrkmirnincd()));
        }

        assertEquals(3, hurikomiKouzaLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }
}
