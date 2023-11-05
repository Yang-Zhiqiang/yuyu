package yuyu.batch.biz.bzmaster.bzkouintorikomi;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.bzmaster.bzkouintorikomi.BzKouinTorikomiDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Kouin;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * マスタ取込（行員マスタ）<br />
 * deleteKouin() メソッドのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzKouinTorikomiDaoTest_deleteKouin {

    @Inject
    private BzKouinTorikomiDao ｂzKouinTorikomiDao;
    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_Kouin kouin1 = new BM_Kouin("1111", "1601");

        bizDomManager.insert(kouin1);

        BM_Kouin kouin2 = new BM_Kouin("2222", "1602");

        bizDomManager.insert(kouin2);

        BM_Kouin kouin3 = new BM_Kouin("3333", "1603");

        bizDomManager.insert(kouin3);

        BM_Kouin kouin4 = new BM_Kouin("4444", "1604");

        bizDomManager.insert(kouin4);

        BM_Kouin kouin5 = new BM_Kouin("5555", "1605");

        bizDomManager.insert(kouin5);
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal1() {

        ｂzKouinTorikomiDao.deleteKouin();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal2() {

        assertEquals(0, bizDomManager.getAllKouin().size());
    }
}
