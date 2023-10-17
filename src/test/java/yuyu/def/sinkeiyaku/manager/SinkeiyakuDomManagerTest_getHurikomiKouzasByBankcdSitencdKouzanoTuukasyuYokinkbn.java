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
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 振込口座マスタ のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn("0001", "123", "1234567", C_Tuukasyu.JPY, C_YokinKbn.HUTUU);
        Assert.assertEquals(0, hurikomiKouzaLst.size());

        HM_HurikomiKouza hurikomiKouza1 = new HM_HurikomiKouza();
        hurikomiKouza1.setBankcd("0001");
        hurikomiKouza1.setSitencd("123");
        hurikomiKouza1.setKouzano("1234567");
        hurikomiKouza1.setTuukasyu(C_Tuukasyu.JPY);
        hurikomiKouza1.setHrkmirnincd("hk0001");
        hurikomiKouza1.setYokinkbn(C_YokinKbn.HUTUU);

        sinkeiyakuDomManager.insert(hurikomiKouza1);

        HM_HurikomiKouza hurikomiKouza2 = new HM_HurikomiKouza();
        hurikomiKouza2.setBankcd("0001");
        hurikomiKouza2.setSitencd("123");
        hurikomiKouza2.setKouzano("1234567");
        hurikomiKouza2.setTuukasyu(C_Tuukasyu.JPY);
        hurikomiKouza2.setHrkmirnincd("hk0002");
        hurikomiKouza2.setYokinkbn(C_YokinKbn.HUTUU);

        sinkeiyakuDomManager.insert(hurikomiKouza2);

        HM_HurikomiKouza hurikomiKouza3 = new HM_HurikomiKouza();
        hurikomiKouza3.setBankcd("0001");
        hurikomiKouza3.setSitencd("123");
        hurikomiKouza3.setKouzano("1234567");
        hurikomiKouza3.setTuukasyu(C_Tuukasyu.JPY);
        hurikomiKouza3.setHrkmirnincd("hk0003");
        hurikomiKouza3.setYokinkbn(C_YokinKbn.HUTUU);

        sinkeiyakuDomManager.insert(hurikomiKouza3);

        HM_HurikomiKouza hurikomiKouza4 = new HM_HurikomiKouza();
        hurikomiKouza4.setBankcd("0002");
        hurikomiKouza4.setSitencd("123");
        hurikomiKouza4.setKouzano("1234567");
        hurikomiKouza4.setTuukasyu(C_Tuukasyu.JPY);
        hurikomiKouza4.setHrkmirnincd("hk0004");
        hurikomiKouza4.setYokinkbn(C_YokinKbn.HUTUU);

        sinkeiyakuDomManager.insert(hurikomiKouza4);

        HM_HurikomiKouza hurikomiKouza5 = new HM_HurikomiKouza();
        hurikomiKouza5.setBankcd("0001");
        hurikomiKouza5.setSitencd("124");
        hurikomiKouza5.setKouzano("1234567");
        hurikomiKouza5.setTuukasyu(C_Tuukasyu.JPY);
        hurikomiKouza5.setHrkmirnincd("hk0005");
        hurikomiKouza5.setYokinkbn(C_YokinKbn.HUTUU);

        sinkeiyakuDomManager.insert(hurikomiKouza5);

        HM_HurikomiKouza hurikomiKouza6 = new HM_HurikomiKouza();
        hurikomiKouza6.setBankcd("0001");
        hurikomiKouza6.setSitencd("123");
        hurikomiKouza6.setKouzano("1234568");
        hurikomiKouza6.setTuukasyu(C_Tuukasyu.JPY);
        hurikomiKouza6.setHrkmirnincd("hk0006");
        hurikomiKouza6.setYokinkbn(C_YokinKbn.HUTUU);

        sinkeiyakuDomManager.insert(hurikomiKouza1);

        HM_HurikomiKouza hurikomiKouza7 = new HM_HurikomiKouza();
        hurikomiKouza7.setBankcd("0001");
        hurikomiKouza7.setSitencd("123");
        hurikomiKouza7.setKouzano("1234567");
        hurikomiKouza7.setTuukasyu(C_Tuukasyu.USD);
        hurikomiKouza7.setHrkmirnincd("hk0007");
        hurikomiKouza7.setYokinkbn(C_YokinKbn.HUTUU);

        sinkeiyakuDomManager.insert(hurikomiKouza7);

        HM_HurikomiKouza hurikomiKouza8 = new HM_HurikomiKouza();
        hurikomiKouza8.setBankcd("0001");
        hurikomiKouza8.setSitencd("123");
        hurikomiKouza8.setKouzano("1234567");
        hurikomiKouza8.setTuukasyu(C_Tuukasyu.JPY);
        hurikomiKouza8.setHrkmirnincd("hk0008");
        hurikomiKouza8.setYokinkbn(C_YokinKbn.TOUZA);

        sinkeiyakuDomManager.insert(hurikomiKouza8);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHurikomiKouza());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn("0003", "123", "1234567", C_Tuukasyu.JPY, C_YokinKbn.HUTUU);
        Assert.assertEquals(0, hurikomiKouzaLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn("0002", "123", "1234567", C_Tuukasyu.JPY, C_YokinKbn.HUTUU);
        Assert.assertEquals(1, hurikomiKouzaLst.size());

        Assert.assertEquals("0002", hurikomiKouzaLst.get(0).getBankcd());
        Assert.assertEquals("123", hurikomiKouzaLst.get(0).getSitencd());
        Assert.assertEquals("1234567", hurikomiKouzaLst.get(0).getKouzano());
        Assert.assertEquals(C_Tuukasyu.JPY, hurikomiKouzaLst.get(0).getTuukasyu());
        Assert.assertEquals("hk0004", hurikomiKouzaLst.get(0).getHrkmirnincd());
    }


    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("0001","123","1234567",C_Tuukasyu.JPY,"hk0001"), "1");
        datamap.put($("0001","123","1234567",C_Tuukasyu.JPY,"hk0002"), "1");
        datamap.put($("0001","123","1234567",C_Tuukasyu.JPY,"hk0003"), "1");

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn("0001", "123", "1234567", C_Tuukasyu.JPY, C_YokinKbn.HUTUU);

        for(HM_HurikomiKouza hurikomiKouza:hurikomiKouzaLst){
            datamap.remove($(
                hurikomiKouza.getBankcd(),
                hurikomiKouza.getSitencd(),
                hurikomiKouza.getKouzano(),
                hurikomiKouza.getTuukasyu(),
                hurikomiKouza.getHrkmirnincd()));
        }

        Assert.assertEquals(3, hurikomiKouzaLst.size());

        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn("", "123", "1234567", C_Tuukasyu.JPY, C_YokinKbn.HUTUU);
        Assert.assertEquals(0, hurikomiKouzaLst.size());

    }

    @Test
    @TestOrder(50)
    public void blank2() {

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn("0001", "", "1234567", C_Tuukasyu.JPY, C_YokinKbn.HUTUU);
        Assert.assertEquals(0, hurikomiKouzaLst.size());

    }

    @Test
    @TestOrder(60)
    public void blank3() {

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn("0001", "123", "", C_Tuukasyu.JPY, C_YokinKbn.HUTUU);
        Assert.assertEquals(0, hurikomiKouzaLst.size());

    }

}
