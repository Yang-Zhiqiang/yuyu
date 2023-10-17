package yuyu.batch.biz.bzinterf.bzrenkeihenkankyouyuudisc;

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

import yuyu.batch.biz.bzinterf.bzrenkeihenkankyouyuudisc.BzRenkeiHenkanKyouyuuDiscDao;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiTy;
import yuyu.def.db.entity.ZT_TokuteiKankeiHoujinRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 連携項目変換処理（共有ディスク方式）DAOクラスの<br />
 * getCountByTableid のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzRenkeiHenkanKyouyuuDiscDaoTest_getCountByTableid {

    @Inject
    private BzRenkeiHenkanKyouyuuDiscDao bzRenkeiHenkanKyouyuuDiscDao;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        BzRenkeiHenkanKyouyuuDiscDao bzRenkeiHenkanKyouyuuDiscDao = SWAKInjector.getInstance(BzRenkeiHenkanKyouyuuDiscDao.class);

        Long rs =  bzRenkeiHenkanKyouyuuDiscDao.getCountByTableid("ZT_DsKariPasswordTuutiTy");
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
        BzRenkeiHenkanKyouyuuDiscDao bzRenkeiHenkanKyouyuuDiscDao = SWAKInjector.getInstance(BzRenkeiHenkanKyouyuuDiscDao.class);
        bzRenkeiHenkanKyouyuuDiscDao.deleteByTableid("ZT_DsKariPasswordTuutiTy");
        bzRenkeiHenkanKyouyuuDiscDao.deleteByTableid("ZT_TokuteiKankeiHoujinRn");
    }

    @Test
    @TestOrder(10)
    public void Test_000() {

        Long rs =  bzRenkeiHenkanKyouyuuDiscDao.getCountByTableid("ZT_SyainMeiboTy");
        Assert.assertEquals(new Long(0),rs);

    }

    @Test
    @TestOrder(10)
    public void Test_001() {

        Long rs =  bzRenkeiHenkanKyouyuuDiscDao.getCountByTableid("ZT_TokuteiKankeiHoujinRn");
        Assert.assertEquals(new Long(1),rs);

    }

    @Test
    @TestOrder(10)
    public void Test_002() {

        Long rs =  bzRenkeiHenkanKyouyuuDiscDao.getCountByTableid("ZT_DsKariPasswordTuutiTy");
        Assert.assertEquals(new Long(4),rs);
    }

    @Test
    @TestOrder(10)
    public void Test_003() {

        try{
            bzRenkeiHenkanKyouyuuDiscDao.getCountByTableid("ZT_DsKariPassword");
            assertTrue(false);
        }catch (Exception e) {
            assertTrue(true);
        }
    }
}
