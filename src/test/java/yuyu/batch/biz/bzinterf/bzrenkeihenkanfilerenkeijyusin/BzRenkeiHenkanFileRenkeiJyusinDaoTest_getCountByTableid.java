package yuyu.batch.biz.bzinterf.bzrenkeihenkanfilerenkeijyusin;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.ZT_DsKariPasswordTuutiTy;
import yuyu.def.db.entity.ZT_TokuteiKankeiHoujinRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 連携項目変換処理（ファイル連携方式受信）DAOクラスの<br />
 * getCountByTableid のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzRenkeiHenkanFileRenkeiJyusinDaoTest_getCountByTableid {

    @Inject
    private BzRenkeiHenkanFileRenkeiJyusinDao bzRenkeiHenkanFileRenkeiJyusinDao;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        BzRenkeiHenkanFileRenkeiJyusinDao bzRenkeiHenkanFileRenkeiJyusinDao = SWAKInjector.getInstance(BzRenkeiHenkanFileRenkeiJyusinDao.class);

        Long rs =  bzRenkeiHenkanFileRenkeiJyusinDao.getCountByTableid("ZT_DsKariPasswordTuutiTy");
        Assert.assertEquals(new Long(0),rs);

        ZT_TokuteiKankeiHoujinRn tokuteiKankeiHoujinRn1 = new ZT_TokuteiKankeiHoujinRn("ab23", "ab12");
        tokuteiKankeiHoujinRn1.setZrnmarukinhyouji("1");
        tokuteiKankeiHoujinRn1.setZrntkhjnkjdrtennm("店名");
        tokuteiKankeiHoujinRn1.setZrndairitenbetutuuban("0001");
        tokuteiKankeiHoujinRn1.setZrnkanjitokuteikankeinm("人名");
        tokuteiKankeiHoujinRn1.setZrntokuteikankeihoujinnm("法人名");
        tokuteiKankeiHoujinRn1.setZrnkousinymd("20160411");
        tokuteiKankeiHoujinRn1.setZrnyobiv79("v79");

        em.persist(tokuteiKankeiHoujinRn1);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy3 = new ZT_DsKariPasswordTuutiTy("abc231");

        em.persist(dsKariPasswordTuutiTy3);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy4 = new ZT_DsKariPasswordTuutiTy("abc321");

        em.persist(dsKariPasswordTuutiTy4);
        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy1 = new ZT_DsKariPasswordTuutiTy("abc123");

        em.persist(dsKariPasswordTuutiTy1);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy2 = new ZT_DsKariPasswordTuutiTy("abc132");

        em.persist(dsKariPasswordTuutiTy2);

    }


    @AfterClass
    @Transactional
    public static void deleteTestData(){
        BzRenkeiHenkanFileRenkeiJyusinDao bzRenkeiHenkanFileRenkeiJyusinDao = SWAKInjector.getInstance(BzRenkeiHenkanFileRenkeiJyusinDao.class);
        bzRenkeiHenkanFileRenkeiJyusinDao.deleteByTableid("ZT_DsKariPasswordTuutiTy");
        bzRenkeiHenkanFileRenkeiJyusinDao.deleteByTableid("ZT_TokuteiKankeiHoujinRn");
    }

    @Test
    @TestOrder(10)
    public void Test_000() {

        Long rs =  bzRenkeiHenkanFileRenkeiJyusinDao.getCountByTableid("ZT_SyainMeiboTy");
        Assert.assertEquals(new Long(0),rs);

    }

    @Test
    @TestOrder(10)
    public void Test_001() {

        Long rs =  bzRenkeiHenkanFileRenkeiJyusinDao.getCountByTableid("ZT_TokuteiKankeiHoujinRn");
        Assert.assertEquals(new Long(1),rs);

    }

    @Test
    @TestOrder(10)
    public void Test_002() {

        Long rs =  bzRenkeiHenkanFileRenkeiJyusinDao.getCountByTableid("ZT_DsKariPasswordTuutiTy");
        Assert.assertEquals(new Long(4),rs);
    }

    @Test
    @TestOrder(10)
    public void Test_003() {

        try{
            bzRenkeiHenkanFileRenkeiJyusinDao.getCountByTableid("ZT_DsKariPassword");
            assertTrue(false);
        }catch (Exception e) {
            assertTrue(true);
        }
    }
}
