package yuyu.batch.biz.bzmaster.bztokuteikankeihoujintorikomi;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.bzmaster.bztokuteikankeihoujintorikomi.BzTokuteiKankeiHoujinTorikomiDao;
import yuyu.def.db.entity.HM_TokuteiKankeiHoujin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * マスタ取込（特定関係法人マスタ）<br />
 * deleteTokuteiKankeiHoujin() メソッドのテストクラス <br />
 */
@RunWith(OrderedRunner.class)
public class BzTokuteiKankeiHoujinTorikomiDaoTest_deleteTokuteiKankeiHoujin {

    @Inject
    private BzTokuteiKankeiHoujinTorikomiDao bzTokuteiKankeiHoujinTorikomiDao;
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin1 = new HM_TokuteiKankeiHoujin("001", BizNumber.valueOf(001));
        tokuteiKankeiHoujin1.setDairitenbtno(0);

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin1);

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin2 = new HM_TokuteiKankeiHoujin("002", BizNumber.valueOf(002));
        tokuteiKankeiHoujin2.setDairitenbtno(0);

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin2);

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin3 = new HM_TokuteiKankeiHoujin("003", BizNumber.valueOf(003));
        tokuteiKankeiHoujin3.setDairitenbtno(0);

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin3);

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin4 = new HM_TokuteiKankeiHoujin("004", BizNumber.valueOf(004));
        tokuteiKankeiHoujin4.setDairitenbtno(0);

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin4);

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin5 = new HM_TokuteiKankeiHoujin("005", BizNumber.valueOf(005));
        tokuteiKankeiHoujin5.setDairitenbtno(0);

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin5);
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal1() {

        bzTokuteiKankeiHoujinTorikomiDao.deleteTokuteiKankeiHoujin();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal2() {

        assertEquals(0, sinkeiyakuDomManager.getAllTokuteiKankeiHoujin().size());
    }
}

