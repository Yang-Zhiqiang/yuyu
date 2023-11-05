package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_HrkmNyknSakujyo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSyonokanrisBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst = sinkeiyakuDomManager.getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg(
            "010",
            "10000000060",
            "茅野",
            BizCurrency.valueOf(6),
            C_Tuukasyu.JPY,
            C_Syorizumiflg.MISYORI);

        Assert.assertEquals(0,hrkmNyknSakujyoLst.size());

        if (hrkmNyknSakujyoLst.size() == 0) {
            HT_HrkmNyknSakujyo hrkmNyknSakujyo = new HT_HrkmNyknSakujyo();
            hrkmNyknSakujyo.setHrkmdeldataskbtkey("100000000");
            hrkmNyknSakujyo.setOyadrtencd("010");
            hrkmNyknSakujyo.setNykmosno("10000000060");
            hrkmNyknSakujyo.setHrkmirninnm("茅野");
            hrkmNyknSakujyo.setTrhkkgk(BizCurrency.valueOf(6));
            hrkmNyknSakujyo.setRstuukasyu(C_Tuukasyu.JPY);
            hrkmNyknSakujyo.setSyorizumiflg(C_Syorizumiflg.MISYORI);
            sinkeiyakuDomManager.insert(hrkmNyknSakujyo);

            HT_HrkmNyknSakujyo hrkmNyknSakujyo2 = new HT_HrkmNyknSakujyo();
            hrkmNyknSakujyo2.setHrkmdeldataskbtkey("200000000");
            hrkmNyknSakujyo2.setOyadrtencd("020");
            hrkmNyknSakujyo2.setNykmosno("10000000070");
            hrkmNyknSakujyo2.setHrkmirninnm("早見");
            hrkmNyknSakujyo2.setTrhkkgk(BizCurrency.valueOf(7));
            hrkmNyknSakujyo2.setRstuukasyu(C_Tuukasyu.JPY);
            hrkmNyknSakujyo2.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
            sinkeiyakuDomManager.insert(hrkmNyknSakujyo2);

            HT_HrkmNyknSakujyo hrkmNyknSakujyo3 = new HT_HrkmNyknSakujyo();
            hrkmNyknSakujyo3.setHrkmdeldataskbtkey("300000000");
            hrkmNyknSakujyo3.setOyadrtencd("020");
            hrkmNyknSakujyo3.setNykmosno("10000000070");
            hrkmNyknSakujyo3.setHrkmirninnm("早見");
            hrkmNyknSakujyo3.setTrhkkgk(BizCurrency.valueOf(7));
            hrkmNyknSakujyo3.setRstuukasyu(C_Tuukasyu.JPY);
            hrkmNyknSakujyo3.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
            sinkeiyakuDomManager.insert(hrkmNyknSakujyo3);

            HT_HrkmNyknSakujyo hrkmNyknSakujyo4 = new HT_HrkmNyknSakujyo();
            hrkmNyknSakujyo4.setHrkmdeldataskbtkey("400000000");
            hrkmNyknSakujyo4.setOyadrtencd("020");
            hrkmNyknSakujyo4.setNykmosno("10000000070");
            hrkmNyknSakujyo4.setHrkmirninnm("早見");
            hrkmNyknSakujyo4.setTrhkkgk(BizCurrency.valueOf(7));
            hrkmNyknSakujyo4.setRstuukasyu(C_Tuukasyu.JPY);
            hrkmNyknSakujyo4.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
            sinkeiyakuDomManager.insert(hrkmNyknSakujyo4);

            HT_HrkmNyknSakujyo hrkmNyknSakujyo5 = new HT_HrkmNyknSakujyo();
            hrkmNyknSakujyo5.setHrkmdeldataskbtkey("100000010");
            hrkmNyknSakujyo5.setOyadrtencd("090");
            hrkmNyknSakujyo5.setNykmosno("10000000060");
            hrkmNyknSakujyo5.setHrkmirninnm("茅野");
            hrkmNyknSakujyo5.setTrhkkgk(BizCurrency.valueOf(6));
            hrkmNyknSakujyo5.setRstuukasyu(C_Tuukasyu.JPY);
            hrkmNyknSakujyo5.setSyorizumiflg(C_Syorizumiflg.MISYORI);
            sinkeiyakuDomManager.insert(hrkmNyknSakujyo5);

            HT_HrkmNyknSakujyo hrkmNyknSakujyo6 = new HT_HrkmNyknSakujyo();
            hrkmNyknSakujyo6.setHrkmdeldataskbtkey("100000020");
            hrkmNyknSakujyo6.setOyadrtencd("010");
            hrkmNyknSakujyo6.setNykmosno("10000000160");
            hrkmNyknSakujyo6.setHrkmirninnm("茅野");
            hrkmNyknSakujyo6.setTrhkkgk(BizCurrency.valueOf(6));
            hrkmNyknSakujyo6.setRstuukasyu(C_Tuukasyu.JPY);
            hrkmNyknSakujyo6.setSyorizumiflg(C_Syorizumiflg.MISYORI);
            sinkeiyakuDomManager.insert(hrkmNyknSakujyo6);

            HT_HrkmNyknSakujyo hrkmNyknSakujyo7 = new HT_HrkmNyknSakujyo();
            hrkmNyknSakujyo7.setHrkmdeldataskbtkey("100000030");
            hrkmNyknSakujyo7.setOyadrtencd("010");
            hrkmNyknSakujyo7.setNykmosno("10000000060");
            hrkmNyknSakujyo7.setHrkmirninnm("田中");
            hrkmNyknSakujyo7.setTrhkkgk(BizCurrency.valueOf(6));
            hrkmNyknSakujyo7.setRstuukasyu(C_Tuukasyu.JPY);
            hrkmNyknSakujyo7.setSyorizumiflg(C_Syorizumiflg.MISYORI);
            sinkeiyakuDomManager.insert(hrkmNyknSakujyo7);

            HT_HrkmNyknSakujyo hrkmNyknSakujyo8 = new HT_HrkmNyknSakujyo();
            hrkmNyknSakujyo8.setHrkmdeldataskbtkey("100000040");
            hrkmNyknSakujyo8.setOyadrtencd("010");
            hrkmNyknSakujyo8.setNykmosno("10000000060");
            hrkmNyknSakujyo8.setHrkmirninnm("茅野");
            hrkmNyknSakujyo8.setTrhkkgk(BizCurrency.valueOf(1));
            hrkmNyknSakujyo8.setRstuukasyu(C_Tuukasyu.JPY);
            hrkmNyknSakujyo8.setSyorizumiflg(C_Syorizumiflg.MISYORI);
            sinkeiyakuDomManager.insert(hrkmNyknSakujyo8);

            HT_HrkmNyknSakujyo hrkmNyknSakujyo9 = new HT_HrkmNyknSakujyo();
            hrkmNyknSakujyo9.setHrkmdeldataskbtkey("100000050");
            hrkmNyknSakujyo9.setOyadrtencd("010");
            hrkmNyknSakujyo9.setNykmosno("10000000060");
            hrkmNyknSakujyo9.setHrkmirninnm("茅野");
            hrkmNyknSakujyo9.setTrhkkgk(BizCurrency.valueOf(6));
            hrkmNyknSakujyo9.setRstuukasyu(C_Tuukasyu.BLNK);
            hrkmNyknSakujyo9.setSyorizumiflg(C_Syorizumiflg.MISYORI);
            sinkeiyakuDomManager.insert(hrkmNyknSakujyo9);

            HT_HrkmNyknSakujyo hrkmNyknSakujyo10 = new HT_HrkmNyknSakujyo();
            hrkmNyknSakujyo10.setHrkmdeldataskbtkey("100000060");
            hrkmNyknSakujyo10.setOyadrtencd("010");
            hrkmNyknSakujyo10.setNykmosno("10000000060");
            hrkmNyknSakujyo10.setHrkmirninnm("茅野");
            hrkmNyknSakujyo10.setTrhkkgk(BizCurrency.valueOf(6));
            hrkmNyknSakujyo10.setRstuukasyu(C_Tuukasyu.JPY);
            hrkmNyknSakujyo10.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
            sinkeiyakuDomManager.insert(hrkmNyknSakujyo10);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHrkmNyknSakujyo());
    }

    @Test
    @TestOrder(40)
    public void noResult1(){

        List<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst = sinkeiyakuDomManager.getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg(
            "090",
            "10000000160",
            "田中",
            BizCurrency.valueOf(1),
            C_Tuukasyu.BLNK,
            C_Syorizumiflg.SYORIZUMI);

        Assert.assertEquals(0, hrkmNyknSakujyoLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst = sinkeiyakuDomManager.getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg(
            "010",
            "10000000060",
            "茅野",
            BizCurrency.valueOf(6),
            C_Tuukasyu.JPY,
            C_Syorizumiflg.MISYORI);
        Assert.assertEquals(1, hrkmNyknSakujyoLst.size());
        Assert.assertEquals("100000000", hrkmNyknSakujyoLst.get(0).getHrkmdeldataskbtkey());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("200000000"), "1");
        datamap.put($("300000000"), "1");
        datamap.put($("400000000"), "1");


        List<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst = sinkeiyakuDomManager.getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg(
            "020",
            "10000000070",
            "早見",
            BizCurrency.valueOf(7),
            C_Tuukasyu.JPY,
            C_Syorizumiflg.SYORIZUMI);


        for(HT_HrkmNyknSakujyo hrkmNyknSakujyo:hrkmNyknSakujyoLst){
            datamap.remove($(
                hrkmNyknSakujyo.getHrkmdeldataskbtkey()));
        }

        Assert.assertEquals(3, hrkmNyknSakujyoLst.size());

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        List<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst = sinkeiyakuDomManager.getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg(
            "",
            "10000000060",
            "茅野",
            BizCurrency.valueOf(7),
            C_Tuukasyu.JPY,
            C_Syorizumiflg.MISYORI);

        Assert.assertEquals(0, hrkmNyknSakujyoLst.size());
    }

    @Test
    @TestOrder(60)
    public void blankCondition2() {

        List<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst = sinkeiyakuDomManager.getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg(
            "010",
            "",
            "茅野",
            BizCurrency.valueOf(7),
            C_Tuukasyu.JPY,
            C_Syorizumiflg.MISYORI);

        Assert.assertEquals(0, hrkmNyknSakujyoLst.size());
    }

    @Test
    @TestOrder(70)
    public void blankCondition3() {

        List<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst = sinkeiyakuDomManager.getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg(
            "010",
            "10000000060",
            "",
            BizCurrency.valueOf(7),
            C_Tuukasyu.JPY,
            C_Syorizumiflg.MISYORI);

        Assert.assertEquals(0, hrkmNyknSakujyoLst.size());
    }
}
