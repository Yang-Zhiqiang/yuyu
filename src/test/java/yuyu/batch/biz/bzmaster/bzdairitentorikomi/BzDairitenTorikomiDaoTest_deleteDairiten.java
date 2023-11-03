package yuyu.batch.biz.bzmaster.bzdairitentorikomi;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.bzmaster.bzdairitentorikomi.BzDairitenTorikomiDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Dairiten;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * マスタ取込（代理店マスタ）<br />
 * deleteDairiten() メソッドのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzDairitenTorikomiDaoTest_deleteDairiten {

    @Inject
    private BzDairitenTorikomiDao bzDairitenTorikomiDao;
    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_Dairiten bM_Dairiten1 = new BM_Dairiten();
        bM_Dairiten1.setDrtencd(String.format("0111111"));

        bizDomManager.insert(bM_Dairiten1);

        BM_Dairiten bM_Dairiten2 = new BM_Dairiten();
        bM_Dairiten2.setDrtencd(String.format("0222222"));

        bizDomManager.insert(bM_Dairiten2);

        BM_Dairiten bM_Dairiten3= new BM_Dairiten();
        bM_Dairiten3.setDrtencd(String.format("0333333"));

        bizDomManager.insert(bM_Dairiten3);

        BM_Dairiten bM_Dairiten4= new BM_Dairiten();
        bM_Dairiten4.setDrtencd(String.format("0444444"));

        bizDomManager.insert(bM_Dairiten4);

        BM_Dairiten bM_Dairiten5= new BM_Dairiten();
        bM_Dairiten5.setDrtencd(String.format("0555555"));

        bizDomManager.insert(bM_Dairiten5);
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal1() {

        bzDairitenTorikomiDao.deleteDairiten();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal2() {

        assertEquals(0, bizDomManager.getAllDairiten().size());
    }

}
