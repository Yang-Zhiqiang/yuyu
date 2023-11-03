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

import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 未整理事由別明細作成処理<br />
 * 入金テーブルエンティティ領収日最大取得　申込番号のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getNyuukinMaxRyosyuymdByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        BizDate maxRyosyuymd = sinkeiyakuDomManager.getNyuukinMaxRyosyuymdByMosno("791112220");
        Assert.assertNull(maxRyosyuymd);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
        nyuukin1.setRenno(01);
        nyuukin1.setRyosyuymd(BizDate.valueOf(20160513));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_Nyuukin nyuukin2 = syoriCTL2.createNyuukin();
        nyuukin2.setRenno(02);
        nyuukin2.setRyosyuymd(BizDate.valueOf(20160510));

        HT_Nyuukin nyuukin3 = syoriCTL2.createNyuukin();
        nyuukin3.setRenno(03);
        nyuukin3.setRyosyuymd(BizDate.valueOf(20160512));

        HT_Nyuukin nyuukin4 = syoriCTL2.createNyuukin();
        nyuukin4.setRenno(04);
        nyuukin4.setRyosyuymd(BizDate.valueOf(20160511));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        sinkeiyakuDomManager.insert(syoriCTL3);
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

        BizDate maxRyosyuymd = sinkeiyakuDomManager.getNyuukinMaxRyosyuymdByMosno("791112246");
        Assert.assertNull(maxRyosyuymd);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        BizDate maxRyosyuymd = sinkeiyakuDomManager.getNyuukinMaxRyosyuymdByMosno("791112238");
        Assert.assertEquals(BizDate.valueOf(20160512), maxRyosyuymd);
    }

    @Test
    @TestOrder(30)
    public void blank() {

        BizDate maxRyosyuymd = sinkeiyakuDomManager.getNyuukinMaxRyosyuymdByMosno("");
        Assert.assertNull(maxRyosyuymd);
    }
}
