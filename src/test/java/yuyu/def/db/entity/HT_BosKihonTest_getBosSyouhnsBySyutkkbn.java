package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 募集基本テーブルエンティティから、<br />
 * 主契約特約区分を指定して<br />
 * 募集商品テーブルエンティティリストを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_BosKihonTest_getBosSyouhnsBySyutkkbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_SYOUHNCD_01 = "M110";
    static String P_SYOUHNCD_02 = "M120";
    static String P_SYOUHNCD_03 = "M130";
    static String P_SYOUHNCD_04 = "M140";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_BosKihon bosKihon1 = new HT_BosKihon(P_MOSNO_01);

        List<HT_BosSyouhn> bosKihonLst = bosKihon1.getBosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Assert.assertEquals(0, bosKihonLst.size());

        HT_BosSyouhn bosSyouhn1 = bosKihon1.createBosSyouhn();
        bosSyouhn1.setSyouhncd(P_SYOUHNCD_01);
        bosSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);

        HT_BosSyouhn bosSyouhn2 = bosKihon1.createBosSyouhn();
        bosSyouhn2.setSyouhncd(P_SYOUHNCD_02);
        bosSyouhn2.setSyutkkbn(C_SyutkKbn.TK);

        HT_BosSyouhn bosSyouhn3 = bosKihon1.createBosSyouhn();
        bosSyouhn3.setSyouhncd(P_SYOUHNCD_03);
        bosSyouhn3.setSyutkkbn(C_SyutkKbn.TK);

        HT_BosSyouhn bosSyouhn4 = bosKihon1.createBosSyouhn();
        bosSyouhn4.setSyouhncd(P_SYOUHNCD_04);
        bosSyouhn4.setSyutkkbn(C_SyutkKbn.TK);

        sinkeiyakuDomManager.insert(bosKihon1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBosKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        HT_BosKihon bosKihon1 = sinkeiyakuDomManager.getBosKihon(P_MOSNO_01);
        List<HT_BosSyouhn> bosKihonLst = bosKihon1.getBosSyouhnsBySyutkkbn(C_SyutkKbn.NONE);

        Assert.assertEquals(0, bosKihonLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_BosKihon bosKihon1 = sinkeiyakuDomManager.getBosKihon(P_MOSNO_01);
        List<HT_BosSyouhn> bosKihonLst = bosKihon1.getBosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        Assert.assertEquals(1, bosKihonLst.size());

        Assert.assertEquals(P_MOSNO_01, bosKihonLst.get(0).getMosno());
        Assert.assertEquals(P_SYOUHNCD_01, bosKihonLst.get(0).getSyouhncd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_BosKihon bosKihon1 = sinkeiyakuDomManager.getBosKihon(P_MOSNO_01);
        List<HT_BosSyouhn> bosKihonLst = bosKihon1.getBosSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        Assert.assertEquals(3, bosKihonLst.size());

        Assert.assertEquals(P_MOSNO_01, bosKihonLst.get(0).getMosno());
        Assert.assertEquals(P_SYOUHNCD_02, bosKihonLst.get(0).getSyouhncd());

        Assert.assertEquals(P_MOSNO_01, bosKihonLst.get(1).getMosno());
        Assert.assertEquals(P_SYOUHNCD_03, bosKihonLst.get(1).getSyouhncd());

        Assert.assertEquals(P_MOSNO_01, bosKihonLst.get(2).getMosno());
        Assert.assertEquals(P_SYOUHNCD_04, bosKihonLst.get(2).getSyouhncd());
    }
}

