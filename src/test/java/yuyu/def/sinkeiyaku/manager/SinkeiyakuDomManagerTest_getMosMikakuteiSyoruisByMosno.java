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

import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 新契約書類到着時管理情報取得処理<br />
 * 外申込未確定書類テーブルエンティティリスト取得(申込番号)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getMosMikakuteiSyoruisByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112238";
    static String P_MOSNO_03 = "791112246";
    static String P_MOSNO_04 = "791112253";
    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno(P_MOSNO_01);

        Assert.assertEquals(0, mosMikakuteiSyoruiLst.size());

        HT_MosMikakuteiSyorui mosMikakuteiSyorui1 = new HT_MosMikakuteiSyorui("1001");
        mosMikakuteiSyorui1.setMosno(P_MOSNO_01);

        sinkeiyakuDomManager.insert(mosMikakuteiSyorui1);

        HT_MosMikakuteiSyorui mosMikakuteiSyorui2 = new HT_MosMikakuteiSyorui("1002");
        mosMikakuteiSyorui2.setMosno(P_MOSNO_02);

        sinkeiyakuDomManager.insert(mosMikakuteiSyorui2);

        HT_MosMikakuteiSyorui mosMikakuteiSyorui3 = new HT_MosMikakuteiSyorui("1003");
        mosMikakuteiSyorui3.setMosno(P_MOSNO_03);

        sinkeiyakuDomManager.insert(mosMikakuteiSyorui3);

        HT_MosMikakuteiSyorui mosMikakuteiSyorui4 = new HT_MosMikakuteiSyorui("1004");
        mosMikakuteiSyorui4.setMosno(P_MOSNO_03);

        sinkeiyakuDomManager.insert(mosMikakuteiSyorui4);

        HT_MosMikakuteiSyorui mosMikakuteiSyorui5 = new HT_MosMikakuteiSyorui("1005");
        mosMikakuteiSyorui5.setMosno(P_MOSNO_03);

        sinkeiyakuDomManager.insert(mosMikakuteiSyorui5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiSyorui());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno(P_MOSNO_04);
        Assert.assertEquals(0, mosMikakuteiSyoruiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno(P_MOSNO_01);

        Assert.assertEquals(1, mosMikakuteiSyoruiLst.size());

        Assert.assertEquals("1001", mosMikakuteiSyoruiLst.get(0).getDocumentid());
        Assert.assertEquals(P_MOSNO_01, mosMikakuteiSyoruiLst.get(0).getMosno());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("1003",P_MOSNO_03), "1");
        datamap.put($("1004",P_MOSNO_03), "1");
        datamap.put($("1005",P_MOSNO_03), "1");

        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno(P_MOSNO_03);

        for(HT_MosMikakuteiSyorui mosMikakuteiSyorui:mosMikakuteiSyoruiLst){
            datamap.remove($(
                mosMikakuteiSyorui.getDocumentid(),
                mosMikakuteiSyorui.getMosno()));
        }

        Assert.assertEquals(3, mosMikakuteiSyoruiLst.size());

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void isBlank1(){

        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno("");
        Assert.assertEquals(0, mosMikakuteiSyoruiLst.size());
    }
}
