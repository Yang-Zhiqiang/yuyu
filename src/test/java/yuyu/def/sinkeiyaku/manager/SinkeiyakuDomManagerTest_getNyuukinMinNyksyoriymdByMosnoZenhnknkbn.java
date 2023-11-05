package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 本社統計情報作成<br />
 * 入金テーブルの最小入金処理日取得　申込番号かつ全額返金区分固定値のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getNyuukinMinNyksyoriymdByMosnoZenhnknkbn {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112238";
    static String P_MOSNO_03 = "791112246";
    static Integer P_RENNO_01 = new Integer(01);
    static Integer P_RENNO_02 = new Integer(02);
    static Integer P_RENNO_03 = new Integer(03);
    static Integer P_RENNO_04 = new Integer(04);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        BizDate minNyksyoriymd = sinkeiyakuDomManager.getNyuukinMinNyksyoriymdByMosnoZenhnknkbn(P_MOSNO_01);
        Assert.assertNull(minNyksyoriymd);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL(P_MOSNO_01);

        HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
        nyuukin1.setRenno(01);
        nyuukin1.setNyksyoriymd(BizDate.valueOf(20160419));
        nyuukin1.setZenhnknkbn(C_ZenhnknKbn.BLNK);

        HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
        nyuukin2.setRenno(02);
        nyuukin2.setNyksyoriymd(BizDate.valueOf(20160420));
        nyuukin2.setZenhnknkbn(C_ZenhnknKbn.BLNK);

        HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
        nyuukin3.setRenno(03);
        nyuukin3.setNyksyoriymd(BizDate.valueOf(20160421));
        nyuukin3.setZenhnknkbn(C_ZenhnknKbn.BLNK);

        HT_Nyuukin nyuukin4 = syoriCTL1.createNyuukin();
        nyuukin4.setRenno(04);
        nyuukin4.setNyksyoriymd(BizDate.valueOf(20160419));
        nyuukin4.setZenhnknkbn(C_ZenhnknKbn.SUMI);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL(P_MOSNO_02);

        HT_Nyuukin nyuukin5 = syoriCTL2.createNyuukin();
        nyuukin5.setRenno(04);
        nyuukin5.setNyksyoriymd(BizDate.valueOf(20160419));
        nyuukin5.setZenhnknkbn(C_ZenhnknKbn.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL2);
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

        BizDate minNyksyoriymd = sinkeiyakuDomManager.getNyuukinMinNyksyoriymdByMosnoZenhnknkbn(P_MOSNO_03);
        Assert.assertNull(minNyksyoriymd);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        BizDate minNyksyoriymd = sinkeiyakuDomManager.getNyuukinMinNyksyoriymdByMosnoZenhnknkbn(P_MOSNO_01);
        Assert.assertEquals(BizDate.valueOf(20160419), minNyksyoriymd);
    }

    @Test
    @TestOrder(30)
    public void blank() {

        BizDate minNyksyoriymd = sinkeiyakuDomManager.getNyuukinMinNyksyoriymdByMosnoZenhnknkbn("");
        Assert.assertNull(minNyksyoriymd);
    }
}
