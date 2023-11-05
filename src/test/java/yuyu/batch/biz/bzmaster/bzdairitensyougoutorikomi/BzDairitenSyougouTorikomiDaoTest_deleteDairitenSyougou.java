package yuyu.batch.biz.bzmaster.bzdairitensyougoutorikomi;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.bzmaster.bzdairitensyougoutorikomi.BzDairitenSyougouTorikomiDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_DairitenSyougou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * マスタ取込（代理店法人商号マスタ）<br />
 * deleteDairitenSyougou() メソッドのテストクラス <br />
 */
@RunWith(OrderedRunner.class)
public class BzDairitenSyougouTorikomiDaoTest_deleteDairitenSyougou {

    @Inject
    private BzDairitenSyougouTorikomiDao BzDairitenSyougouTorikomiDao;
    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_DairitenSyougou dairitenSyougou = new BM_DairitenSyougou();
        dairitenSyougou.setDrtencd("001");
        bizDomManager.insert(dairitenSyougou);

        BM_DairitenSyougou dairitenSyougou2 = new BM_DairitenSyougou();
        dairitenSyougou2.setDrtencd("002");
        bizDomManager.insert(dairitenSyougou2);

        BM_DairitenSyougou dairitenSyougou3 = new BM_DairitenSyougou();
        dairitenSyougou3.setDrtencd("003");
        bizDomManager.insert(dairitenSyougou3);

        BM_DairitenSyougou dairitenSyougou4 = new BM_DairitenSyougou();
        dairitenSyougou4.setDrtencd("004");
        bizDomManager.insert(dairitenSyougou4);

        BM_DairitenSyougou dairitenSyougou5 = new BM_DairitenSyougou();
        dairitenSyougou5.setDrtencd("005");
        bizDomManager.insert(dairitenSyougou5);
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal1() {

        BzDairitenSyougouTorikomiDao.deleteDairitenSyougou();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal2() {

        assertEquals(0, bizDomManager.getAllDairitenSyougou().size());
    }
}
