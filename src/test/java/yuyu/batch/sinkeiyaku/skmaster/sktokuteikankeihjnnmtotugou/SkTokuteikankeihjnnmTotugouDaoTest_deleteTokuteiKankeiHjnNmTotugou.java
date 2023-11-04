package yuyu.batch.sinkeiyaku.skmaster.sktokuteikankeihjnnmtotugou;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 特定関係法人名突合マスタ反映<br />
 * deleteTokuteiKankeiHjnNmTotugou() メソッドのテストクラス <br />
 */
@RunWith(OrderedRunner.class)
public class SkTokuteikankeihjnnmTotugouDaoTest_deleteTokuteiKankeiHjnNmTotugou {

    @Inject
    private SkTokuteikankeihjnnmTotugouDao skTokuteikankeihjnnmTotugouDao;
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        SkTokuteikankeihjnnmTotugouDao skTokuteikankeihjnnmTotugouDaoDao = SWAKInjector
            .getInstance(SkTokuteikankeihjnnmTotugouDao.class);

        skTokuteikankeihjnnmTotugouDaoDao.deleteTokuteiKankeiHjnNmTotugou();

        assertEquals(0, sinkeiyakuDomManager.getAllTokuteiKankeiHjnNmTotugou().size());

        HM_TokuteiKankeiHjnNmTotugou tokuteiKankeiHjnNmTotugou1 = new HM_TokuteiKankeiHjnNmTotugou();
        tokuteiKankeiHjnNmTotugou1.setTkhjnkinyuucd("0001");
        tokuteiKankeiHjnNmTotugou1.setMeisaino(BizNumber.ONE);
        tokuteiKankeiHjnNmTotugou1.setRenno(new Integer(1));

        sinkeiyakuDomManager.insert(tokuteiKankeiHjnNmTotugou1);

        HM_TokuteiKankeiHjnNmTotugou tokuteiKankeiHjnNmTotugou2 = new HM_TokuteiKankeiHjnNmTotugou();
        tokuteiKankeiHjnNmTotugou2.setTkhjnkinyuucd("0002");
        tokuteiKankeiHjnNmTotugou2.setMeisaino(BizNumber.ONE);
        tokuteiKankeiHjnNmTotugou2.setRenno(new Integer(1));

        sinkeiyakuDomManager.insert(tokuteiKankeiHjnNmTotugou2);

        HM_TokuteiKankeiHjnNmTotugou tokuteiKankeiHjnNmTotugou3 = new HM_TokuteiKankeiHjnNmTotugou();
        tokuteiKankeiHjnNmTotugou3.setTkhjnkinyuucd("0003");
        tokuteiKankeiHjnNmTotugou3.setMeisaino(BizNumber.ONE);
        tokuteiKankeiHjnNmTotugou3.setRenno(new Integer(1));

        sinkeiyakuDomManager.insert(tokuteiKankeiHjnNmTotugou3);

        HM_TokuteiKankeiHjnNmTotugou tokuteiKankeiHjnNmTotugou4 = new HM_TokuteiKankeiHjnNmTotugou();
        tokuteiKankeiHjnNmTotugou4.setTkhjnkinyuucd("0004");
        tokuteiKankeiHjnNmTotugou4.setMeisaino(BizNumber.ONE);
        tokuteiKankeiHjnNmTotugou4.setRenno(new Integer(1));

        sinkeiyakuDomManager.insert(tokuteiKankeiHjnNmTotugou4);

        HM_TokuteiKankeiHjnNmTotugou tokuteiKankeiHjnNmTotugou5 = new HM_TokuteiKankeiHjnNmTotugou();
        tokuteiKankeiHjnNmTotugou5.setTkhjnkinyuucd("0005");
        tokuteiKankeiHjnNmTotugou5.setMeisaino(BizNumber.ONE);
        tokuteiKankeiHjnNmTotugou5.setRenno(new Integer(1));

        sinkeiyakuDomManager.insert(tokuteiKankeiHjnNmTotugou5);
    }

    @Test
    @TestOrder(10)
    public void normal1() {

        assertEquals(5, sinkeiyakuDomManager.getAllTokuteiKankeiHjnNmTotugou().size());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal2() {

        skTokuteikankeihjnnmTotugouDao.deleteTokuteiKankeiHjnNmTotugou();
    }

    @Test
    @TestOrder(30)
    public void normal3() {

        assertEquals(0, sinkeiyakuDomManager.getAllTokuteiKankeiHjnNmTotugou().size());
    }
}
