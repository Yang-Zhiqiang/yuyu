package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 契約情報取込<br />
 * 入金テーブル件数取得(申込番号)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getNyuukinCountByMosnoZenhnknkbnSrgonyknumuNyknsyubetu {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112238";
    static String P_MOSNO_03 = "791112246";
    static Integer P_RENNO_01 = new Integer(1);
    static Integer P_RENNO_02 = new Integer(2);
    static Integer P_RENNO_03 = new Integer(3);
    static Integer P_RENNO_04 = new Integer(4);
    static Integer P_RENNO_05 = new Integer(5);
    static Integer P_RENNO_06 = new Integer(6);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Long lCount = sinkeiyakuDomManager.getNyuukinCountByMosnoZenhnknkbnSrgonyknumuNyknsyubetu(P_MOSNO_01);
        Assert.assertEquals(0, lCount.intValue());

        HT_SyoriCTL hT_SyoriCtl1 = new HT_SyoriCTL(P_MOSNO_01);

        HT_Nyuukin hT_Nyuukin11 = hT_SyoriCtl1.createNyuukin();
        hT_Nyuukin11.setRenno(P_RENNO_01);
        hT_Nyuukin11.setNyknsyubetu(C_NyknsyubetuKbn.KOUHURI);
        hT_Nyuukin11.setZenhnknkbn(C_ZenhnknKbn.BLNK);
        hT_Nyuukin11.setSrgonyknumu(C_UmuKbn.NONE);

        HT_Nyuukin hT_Nyuukin12 = hT_SyoriCtl1.createNyuukin();
        hT_Nyuukin12.setRenno(P_RENNO_02);
        hT_Nyuukin12.setNyknsyubetu(C_NyknsyubetuKbn.KOUHURI);
        hT_Nyuukin12.setZenhnknkbn(C_ZenhnknKbn.BLNK);
        hT_Nyuukin12.setSrgonyknumu(C_UmuKbn.NONE);

        HT_Nyuukin hT_Nyuukin13 = hT_SyoriCtl1.createNyuukin();
        hT_Nyuukin13.setRenno(P_RENNO_03);
        hT_Nyuukin13.setNyknsyubetu(C_NyknsyubetuKbn.KOUHURI);
        hT_Nyuukin13.setZenhnknkbn(C_ZenhnknKbn.BLNK);
        hT_Nyuukin13.setSrgonyknumu(C_UmuKbn.NONE);

        HT_Nyuukin hT_Nyuukin14 = hT_SyoriCtl1.createNyuukin();
        hT_Nyuukin14.setRenno(P_RENNO_04);
        hT_Nyuukin14.setNyknsyubetu(C_NyknsyubetuKbn.HURIKOMI);
        hT_Nyuukin14.setZenhnknkbn(C_ZenhnknKbn.BLNK);
        hT_Nyuukin14.setSrgonyknumu(C_UmuKbn.NONE);

        HT_Nyuukin hT_Nyuukin15 = hT_SyoriCtl1.createNyuukin();
        hT_Nyuukin15.setRenno(P_RENNO_05);
        hT_Nyuukin15.setNyknsyubetu(C_NyknsyubetuKbn.KOUHURI);
        hT_Nyuukin15.setZenhnknkbn(C_ZenhnknKbn.BLNK);
        hT_Nyuukin15.setSrgonyknumu(C_UmuKbn.ARI);

        HT_Nyuukin hT_Nyuukin16 = hT_SyoriCtl1.createNyuukin();
        hT_Nyuukin16.setRenno(P_RENNO_06);
        hT_Nyuukin16.setNyknsyubetu(C_NyknsyubetuKbn.KOUHURI);
        hT_Nyuukin16.setZenhnknkbn(C_ZenhnknKbn.SUMI);
        hT_Nyuukin16.setSrgonyknumu(C_UmuKbn.NONE);

        sinkeiyakuDomManager.insert(hT_SyoriCtl1);

        HT_SyoriCTL hT_SyoriCtl2 = new HT_SyoriCTL(P_MOSNO_02);

        HT_Nyuukin hT_Nyuukin21 = hT_SyoriCtl2.createNyuukin();
        hT_Nyuukin21.setRenno(P_RENNO_01);
        hT_Nyuukin21.setNyknsyubetu(C_NyknsyubetuKbn.KOUHURI);
        hT_Nyuukin21.setZenhnknkbn(C_ZenhnknKbn.BLNK);
        hT_Nyuukin21.setSrgonyknumu(C_UmuKbn.NONE);

        sinkeiyakuDomManager.insert(hT_SyoriCtl2);
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

        Long lCount = sinkeiyakuDomManager.getNyuukinCountByMosnoZenhnknkbnSrgonyknumuNyknsyubetu(P_MOSNO_03);

        Assert.assertEquals(0, lCount.intValue());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Long lCount = sinkeiyakuDomManager.getNyuukinCountByMosnoZenhnknkbnSrgonyknumuNyknsyubetu(P_MOSNO_01);

        Assert.assertEquals(3, lCount.intValue());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        Long lCount = sinkeiyakuDomManager.getNyuukinCountByMosnoZenhnknkbnSrgonyknumuNyknsyubetu("");

        Assert.assertEquals(0, lCount.intValue());
    }
}
