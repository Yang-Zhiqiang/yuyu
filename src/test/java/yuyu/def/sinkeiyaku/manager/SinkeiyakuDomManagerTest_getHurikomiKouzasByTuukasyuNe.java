package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

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
 * getHurikomiKouzasByTuukasyuNe() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHurikomiKouzasByTuukasyuNe {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByTuukasyuNe(C_Tuukasyu.AUD);

        Assert.assertEquals(0, hurikomiKouzaLst.size());

        HM_HurikomiKouza hurikomiKouza1 = new HM_HurikomiKouza();
        hurikomiKouza1.setBankcd("1111");
        hurikomiKouza1.setSitencd("122");
        hurikomiKouza1.setKouzano("101");
        hurikomiKouza1.setTuukasyu(C_Tuukasyu.AUD);
        hurikomiKouza1.setHrkmirnincd("11");
        sinkeiyakuDomManager.insert(hurikomiKouza1);


        HM_HurikomiKouza hurikomiKouza3 = new HM_HurikomiKouza();
        hurikomiKouza3.setBankcd("2222");
        hurikomiKouza3.setSitencd("144");
        hurikomiKouza3.setKouzano("103");
        hurikomiKouza3.setTuukasyu(C_Tuukasyu.USD);
        hurikomiKouza3.setHrkmirnincd("13");
        sinkeiyakuDomManager.insert(hurikomiKouza3);

        HM_HurikomiKouza hurikomiKouza4 = new HM_HurikomiKouza();
        hurikomiKouza4.setBankcd("2222");
        hurikomiKouza4.setSitencd("155");
        hurikomiKouza4.setKouzano("104");
        hurikomiKouza4.setTuukasyu(C_Tuukasyu.USD);
        hurikomiKouza4.setHrkmirnincd("14");
        sinkeiyakuDomManager.insert(hurikomiKouza4);

        HM_HurikomiKouza hurikomiKouza5 = new HM_HurikomiKouza();
        hurikomiKouza5.setBankcd("5555");
        hurikomiKouza5.setSitencd("166");
        hurikomiKouza5.setKouzano("105");
        hurikomiKouza5.setTuukasyu(C_Tuukasyu.USD);
        hurikomiKouza5.setHrkmirnincd("15");
        sinkeiyakuDomManager.insert(hurikomiKouza5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHurikomiKouza());
    }

    @Test
    @TestOrder(40)
    public void noResult1() {

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByTuukasyuNe(C_Tuukasyu
            .AUD);

        Assert.assertEquals(0, hurikomiKouzaLst.size());

    }


    @Test
    @TestOrder(20)
    public void normal2() {

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByTuukasyuNe(C_Tuukasyu
            .USD);

        Assert.assertEquals(1, hurikomiKouzaLst.size());
        Assert.assertEquals("1111", hurikomiKouzaLst.get(0).getBankcd());
        Assert.assertEquals("122", hurikomiKouzaLst.get(0).getSitencd());
        Assert.assertEquals("101", hurikomiKouzaLst.get(0).getKouzano());
        Assert.assertEquals(C_Tuukasyu.AUD, hurikomiKouzaLst.get(0).getTuukasyu());
        Assert.assertEquals("11", hurikomiKouzaLst.get(0).getHrkmirnincd());

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal3() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("2222","144","103","13"), "1");
        datamap.put($("2222","155","104","14"), "1");
        datamap.put($("5555","166","105","15"), "1");

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByTuukasyuNe(C_Tuukasyu
            .AUD);

        for(HM_HurikomiKouza hurikomiKouza:hurikomiKouzaLst){
            datamap.remove($(
                hurikomiKouza.getBankcd(),
                hurikomiKouza.getSitencd(),
                hurikomiKouza.getKouzano(),
                hurikomiKouza.getHrkmirnincd()));
        }

        Assert.assertEquals(3, hurikomiKouzaLst.size());
        Assert.assertTrue(datamap.isEmpty());

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHurikomiKouza());

        HM_HurikomiKouza hurikomiKouza1 = new HM_HurikomiKouza();
        hurikomiKouza1.setBankcd("1111");
        hurikomiKouza1.setSitencd("122");
        hurikomiKouza1.setKouzano("101");
        hurikomiKouza1.setTuukasyu(C_Tuukasyu.AUD);
        hurikomiKouza1.setHrkmirnincd("11");
        sinkeiyakuDomManager.insert(hurikomiKouza1);

    }
}
