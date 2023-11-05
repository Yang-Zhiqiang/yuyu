package yuyu.batch.biz.bzmaster.bzbuntaninfotorikomi;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.bzmaster.bzbuntaninfotorikomi.BzBuntanInfoTorikomiDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_BuntanInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * マスタ取込（分担情報テーブル）DAOクラスの、<br />
 * deleteBuntanInfo() メソッドのテストクラスです。
 */

@RunWith(OrderedRunner.class)
public class BzBuntanInfoTorikomiDaoTest_deleteBuntanInfo {

    @Inject
    private BzBuntanInfoTorikomiDao BzBuntanInfoTorikomiDao;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        BT_BuntanInfo BT_BuntanInfo = new BT_BuntanInfo();
        BT_BuntanInfo.setDrtencd(String.format("001"));
        BT_BuntanInfo.setDairitensyouhincd(String.format("01"));
        BT_BuntanInfo.setTesuuryoubuntandrtencd(String.format("01"));
        BT_BuntanInfo.setTesuuryoubuntanstartym(BizDateYM.valueOf(01));
        em.persist(BT_BuntanInfo);

        BT_BuntanInfo = new BT_BuntanInfo();
        BT_BuntanInfo.setDrtencd(String.format("002"));
        BT_BuntanInfo.setDairitensyouhincd(String.format("02"));
        BT_BuntanInfo.setTesuuryoubuntandrtencd(String.format("02"));
        BT_BuntanInfo.setTesuuryoubuntanstartym(BizDateYM.valueOf(02));
        em.persist(BT_BuntanInfo);

        BT_BuntanInfo = new BT_BuntanInfo();
        BT_BuntanInfo.setDrtencd(String.format("003"));
        BT_BuntanInfo.setDairitensyouhincd(String.format("03"));
        BT_BuntanInfo.setTesuuryoubuntandrtencd(String.format("03"));
        BT_BuntanInfo.setTesuuryoubuntanstartym(BizDateYM.valueOf(03));
        em.persist(BT_BuntanInfo);

        BT_BuntanInfo = new BT_BuntanInfo();
        BT_BuntanInfo.setDrtencd(String.format("004"));
        BT_BuntanInfo.setDairitensyouhincd(String.format("04"));
        BT_BuntanInfo.setTesuuryoubuntandrtencd(String.format("04"));
        BT_BuntanInfo.setTesuuryoubuntanstartym(BizDateYM.valueOf(04));
        em.persist(BT_BuntanInfo);
    }

    @AfterClass
    @Transactional
    public static void TestDataDelete() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_BuntanInfo where drtencd like '0%'").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal1() {
        BzBuntanInfoTorikomiDao.deleteBuntanInfo();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal2() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        List<BT_BuntanInfo> BT_BuntanInfoList = em.findAll(BT_BuntanInfo.class);
        assertEquals(0, BT_BuntanInfoList.size());
    }

}
