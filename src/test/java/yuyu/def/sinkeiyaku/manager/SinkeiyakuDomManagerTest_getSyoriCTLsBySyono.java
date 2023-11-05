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

import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 新契約共通DBアクセス（取得）<br />
 * 処理コントロールテーブルエンティティリスト取得(証券番号)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsBySyono {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112221";
    static String P_MOSNO_03 = "791112222";
    static String P_MOSNO_04 = "791112223";
    static String P_MOSNO_05 = "791112224";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111119";
    static String P_SYONO_03 = "11807111120";
    static String P_SYONO_04 = "11807111121";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SyoriCTL> hT_SyoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsBySyono(P_SYONO_01);

        Assert.assertEquals(0, hT_SyoriCTLLst.size());

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(P_MOSNO_01);
        hT_SyoriCTL1.setSyono(P_SYONO_01);
        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(P_MOSNO_02);
        hT_SyoriCTL2.setSyono(P_SYONO_02);
        sinkeiyakuDomManager.insert(hT_SyoriCTL2);

        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL(P_MOSNO_03);
        hT_SyoriCTL3.setSyono(P_SYONO_02);
        sinkeiyakuDomManager.insert(hT_SyoriCTL3);

        HT_SyoriCTL hT_SyoriCTL4 = new HT_SyoriCTL(P_MOSNO_04);
        hT_SyoriCTL4.setSyono(P_SYONO_02);
        sinkeiyakuDomManager.insert(hT_SyoriCTL4);

        HT_SyoriCTL hT_SyoriCTL5 = new HT_SyoriCTL(P_MOSNO_05);
        hT_SyoriCTL5.setSyono(P_SYONO_04);
        sinkeiyakuDomManager.insert(hT_SyoriCTL5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HT_SyoriCTL> hT_SyoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsBySyono(P_SYONO_03);

        Assert.assertEquals(0, hT_SyoriCTLLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_SyoriCTL> hT_SyoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsBySyono(P_SYONO_01);
        Assert.assertEquals(1, hT_SyoriCTLLst.size());

        Assert.assertEquals(P_MOSNO_01, hT_SyoriCTLLst.get(0).getMosno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(P_SYONO_02,P_MOSNO_02), "1");
        datamap.put($(P_SYONO_02,P_MOSNO_03), "1");
        datamap.put($(P_SYONO_02,P_MOSNO_04), "1");

        List<HT_SyoriCTL> hT_SyoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsBySyono(P_SYONO_02);

        for(HT_SyoriCTL syoriCTL : hT_SyoriCTLLst){
            datamap.remove($(
                syoriCTL.getSyono(),
                syoriCTL.getMosno()));
        }

        Assert.assertEquals(3, hT_SyoriCTLLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<HT_SyoriCTL> hT_SyoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsBySyono("");

        assertEquals(0, hT_SyoriCTLLst.size());
    }
}
