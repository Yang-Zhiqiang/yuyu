package yuyu.batch.biz.bzmaster.bztuukabetukyuusibitorikomi;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.bzmaster.bztuukabetukyuusibitorikomi.BzTuukabetuKyuusibiTorikomiDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_TuukabetuKyuusibi;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * マスタ取込（通貨別取扱休止日マスタ）<br />
 * truncateTuukabetuKyuusibi() メソッドのテストクラス <br />
 */
@RunWith(OrderedRunner.class)
public class BzTuukabetuKyuusibiTorikomiDaoTest_truncateTuukabetuKyuusibi {

    @Inject
    private BzTuukabetuKyuusibiTorikomiDao bzTuukabetuKyuusibiTorikomiDao;
    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_TuukabetuKyuusibi tuukabetuKyuusibi1 = new BM_TuukabetuKyuusibi(BizDate.valueOf(20150301));
        bizDomManager.insert(tuukabetuKyuusibi1);

        BM_TuukabetuKyuusibi tuukabetuKyuusibi2 = new BM_TuukabetuKyuusibi(BizDate.valueOf(20150302));
        bizDomManager.insert(tuukabetuKyuusibi2);

        BM_TuukabetuKyuusibi tuukabetuKyuusibi3 = new BM_TuukabetuKyuusibi(BizDate.valueOf(20150303));
        bizDomManager.insert(tuukabetuKyuusibi3);

        BM_TuukabetuKyuusibi tuukabetuKyuusibi4 = new BM_TuukabetuKyuusibi(BizDate.valueOf(20150304));
        bizDomManager.insert(tuukabetuKyuusibi4);

        BM_TuukabetuKyuusibi tuukabetuKyuusibi5 = new BM_TuukabetuKyuusibi(BizDate.valueOf(20150305));
        bizDomManager.insert(tuukabetuKyuusibi5);
    }

    @Test
    @TestOrder(10)
    public void normal1() {

        bzTuukabetuKyuusibiTorikomiDao.truncateTuukabetuKyuusibi();
    }

    @Test
    @TestOrder(20)
    public void normal2() {

        assertEquals(0, bizDomManager.getAllTuukabetuKyuusibi().size());
    }
}
