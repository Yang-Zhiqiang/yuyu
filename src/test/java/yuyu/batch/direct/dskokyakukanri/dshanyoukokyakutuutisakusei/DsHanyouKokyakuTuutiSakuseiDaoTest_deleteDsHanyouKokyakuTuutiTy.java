package yuyu.batch.direct.dskokyakukanri.dshanyoukokyakutuutisakusei;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.ZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ汎用顧客宛通知テーブル（中）のテストクラス <br />
 */
@RunWith(OrderedRunner.class)
public class DsHanyouKokyakuTuutiSakuseiDaoTest_deleteDsHanyouKokyakuTuutiTy {

    @Inject
    private DsHanyouKokyakuTuutiSakuseiDao dsHanyouKokyakuTuutiSakuseiDao;

    @BeforeClass
    @Transactional
    public static void TestDatapersist() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        ZT_DsHanyouKokyakuTuutiTy dsHanyouKokyakuTuutiTy1 = new ZT_DsHanyouKokyakuTuutiTy("1001", "20011002", "1");
        dsHanyouKokyakuTuutiTy1.setZtyatesakiyno("1");

        zdbDomManager.insert(dsHanyouKokyakuTuutiTy1);

        ZT_DsHanyouKokyakuTuutiTy dsHanyouKokyakuTuutiTy2 = new ZT_DsHanyouKokyakuTuutiTy("1002", "20011002", "1");
        dsHanyouKokyakuTuutiTy2.setZtyatesakiyno("1");

        zdbDomManager.insert(dsHanyouKokyakuTuutiTy2);

        ZT_DsHanyouKokyakuTuutiTy dsHanyouKokyakuTuutiTy3 = new ZT_DsHanyouKokyakuTuutiTy("1003", "20011002", "1");
        dsHanyouKokyakuTuutiTy3.setZtyatesakiyno("1");

        zdbDomManager.insert(dsHanyouKokyakuTuutiTy3);

        ZT_DsHanyouKokyakuTuutiTy dsHanyouKokyakuTuutiTy4 = new ZT_DsHanyouKokyakuTuutiTy("1004", "20011002", "1");
        dsHanyouKokyakuTuutiTy4.setZtyatesakiyno("1");

        zdbDomManager.insert(dsHanyouKokyakuTuutiTy4);
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_001() {

        dsHanyouKokyakuTuutiSakuseiDao.deleteDsHanyouKokyakuTuutiTy();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal2() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        List<ZT_DsHanyouKokyakuTuutiTy> dsHanyouKokyakuTuutiTyList = em.findAll(ZT_DsHanyouKokyakuTuutiTy.class);
        assertEquals(0, dsHanyouKokyakuTuutiTyList.size());
    }
}
