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

import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn(
            "1234430", "791112238",C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);

        Assert.assertEquals(0, syoriCTLLst.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSeiritukbn(C_SeirituKbn.NONE);

        HT_NayoseKekka nayoseKekka1 = syoriCTL1.createNayoseKekka();
        nayoseKekka1.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        nayoseKekka1.setEdano(1);
        nayoseKekka1.setSakuinnmno("1234430");

        HT_NayoseKekka nayoseKekka2 = syoriCTL1.createNayoseKekka();
        nayoseKekka2.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        nayoseKekka2.setEdano(2);
        nayoseKekka2.setSakuinnmno("1234431");

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112329");
        syoriCTL2.setSeiritukbn(C_SeirituKbn.NONE);

        HT_NayoseKekka nayoseKekka4 = syoriCTL2.createNayoseKekka();
        nayoseKekka4.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.HIHOKENSYA);
        nayoseKekka4.setEdano(4);
        nayoseKekka4.setSakuinnmno("1234430");

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112238");
        syoriCTL3.setSeiritukbn(C_SeirituKbn.ITIPMATI);

        HT_NayoseKekka nayoseKekka3 = syoriCTL3.createNayoseKekka();
        nayoseKekka3.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        nayoseKekka3.setEdano(3);
        nayoseKekka3.setSakuinnmno("1234430");

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112246");
        syoriCTL4.setSeiritukbn(C_SeirituKbn.NONE);

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112253");
        syoriCTL5.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_NayoseKekka nayoseKekka5 = syoriCTL5.createNayoseKekka();
        nayoseKekka5.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        nayoseKekka5.setEdano(5);
        nayoseKekka5.setSakuinnmno("1234430");

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112261");
        syoriCTL6.setSeiritukbn(C_SeirituKbn.HUSEIRITU);

        HT_NayoseKekka nayoseKekka6 = syoriCTL6.createNayoseKekka();
        nayoseKekka6.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        nayoseKekka6.setEdano(6);
        nayoseKekka6.setSakuinnmno("1234430");

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112279");
        syoriCTL7.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_NayoseKekka nayoseKekka7 = syoriCTL7.createNayoseKekka();
        nayoseKekka7.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        nayoseKekka7.setEdano(7);
        nayoseKekka7.setSakuinnmno("1234430");

        sinkeiyakuDomManager.insert(syoriCTL7);

        HT_SyoriCTL syoriCTL8 = new HT_SyoriCTL("791112287");
        syoriCTL8.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_NayoseKekka nayoseKekka8 = syoriCTL8.createNayoseKekka();
        nayoseKekka8.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        nayoseKekka8.setEdano(8);
        nayoseKekka8.setSakuinnmno("1234430");

        sinkeiyakuDomManager.insert(syoriCTL8);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn(
            "1234450", "791112238", C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);

        Assert.assertEquals(0, syoriCTLLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn(
            "1234431", "791112238", C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);

        Assert.assertEquals(1, syoriCTLLst.size());
        Assert.assertEquals("791112220", syoriCTLLst.get(0).getMosno());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112220"), "1");
        datamap.put($("791112279"), "1");
        datamap.put($("791112287"), "1");


        List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn(
            "1234430", "791112238", C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);

        for(HT_SyoriCTL syoriCTL:syoriCTLLst){
            datamap.remove($(
                syoriCTL.getMosno()));
        }

        Assert.assertEquals(3, syoriCTLLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void blankCondition1(){

        List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn(
            "", "791112238", C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);

        Assert.assertEquals(0, syoriCTLLst.size());
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void blankCondition2(){
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112220"), "1");
        datamap.put($("791112238"), "1");
        datamap.put($("791112279"), "1");
        datamap.put($("791112287"), "1");


        List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn(
            "1234430", "", C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);

        for(HT_SyoriCTL syoriCTL:syoriCTLLst){
            datamap.remove($(
                syoriCTL.getMosno()));
        }

        Assert.assertEquals(4, syoriCTLLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }
}
