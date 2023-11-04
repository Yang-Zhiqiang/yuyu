package yuyu.batch.biz.bzinterf.bzrenkeihenkankyouyuudisc;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.bzinterf.bzrenkeihenkankyouyuudisc.BzRenkeiHenkanKyouyuuDiscDao;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiTy;
import yuyu.def.db.entity.ZT_TokuteiKankeiHoujinRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 連携項目変換処理（共有ディスク方式）DAOクラスの<br />
 * deleteByTableid のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzRenkeiHenkanKyouyuuDiscDaoTest_deleteByTableid {

    @Inject
    private BzRenkeiHenkanKyouyuuDiscDao bzRenkeiHenkanKyouyuuDiscDao;
    @Inject
    private ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy3 = new ZT_DsKariPasswordTuutiTy("abc231");

        em.persist(dsKariPasswordTuutiTy3);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy4 = new ZT_DsKariPasswordTuutiTy("abc321");

        em.persist(dsKariPasswordTuutiTy4);
        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy1 = new ZT_DsKariPasswordTuutiTy("abc123");

        em.persist(dsKariPasswordTuutiTy1);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy2 = new ZT_DsKariPasswordTuutiTy("abc132");

        em.persist(dsKariPasswordTuutiTy2);

        ZT_TokuteiKankeiHoujinRn tokuteiKankeiHoujinRn1 = new ZT_TokuteiKankeiHoujinRn("ab23", "ab12");
        tokuteiKankeiHoujinRn1.setZrnmarukinhyouji("1");
        tokuteiKankeiHoujinRn1.setZrntkhjnkjdrtennm("店名");
        tokuteiKankeiHoujinRn1.setZrndairitenbetutuuban("0001");
        tokuteiKankeiHoujinRn1.setZrnkanjitokuteikankeinm("人名");
        tokuteiKankeiHoujinRn1.setZrntokuteikankeihoujinnm("法人名");
        tokuteiKankeiHoujinRn1.setZrnkousinymd("20160411");
        tokuteiKankeiHoujinRn1.setZrnyobiv79("v79");

        em.persist(tokuteiKankeiHoujinRn1);

        ZT_TokuteiKankeiHoujinRn tokuteiKankeiHoujinRn2 = new ZT_TokuteiKankeiHoujinRn("ab12", "ab12");
        tokuteiKankeiHoujinRn2.setZrnmarukinhyouji("1");
        tokuteiKankeiHoujinRn2.setZrntkhjnkjdrtennm("店名");
        tokuteiKankeiHoujinRn2.setZrndairitenbetutuuban("0002");
        tokuteiKankeiHoujinRn2.setZrnkanjitokuteikankeinm("人名");
        tokuteiKankeiHoujinRn2.setZrntokuteikankeihoujinnm("法人名");
        tokuteiKankeiHoujinRn2.setZrnkousinymd("20160412");
        tokuteiKankeiHoujinRn2.setZrnyobiv79("v79");

        em.persist(tokuteiKankeiHoujinRn2);

        ZT_TokuteiKankeiHoujinRn tokuteiKankeiHoujinRn3 = new ZT_TokuteiKankeiHoujinRn("ab23", "ab32");
        tokuteiKankeiHoujinRn3.setZrnmarukinhyouji("1");
        tokuteiKankeiHoujinRn3.setZrntkhjnkjdrtennm("店名");
        tokuteiKankeiHoujinRn3.setZrndairitenbetutuuban("0003");
        tokuteiKankeiHoujinRn3.setZrnkanjitokuteikankeinm("人名");
        tokuteiKankeiHoujinRn3.setZrntokuteikankeihoujinnm("法人名");
        tokuteiKankeiHoujinRn3.setZrnkousinymd("20160413");
        tokuteiKankeiHoujinRn3.setZrnyobiv79("v79");

        em.persist(tokuteiKankeiHoujinRn3);

        ZT_TokuteiKankeiHoujinRn tokuteiKankeiHoujinRn4 = new ZT_TokuteiKankeiHoujinRn("ab23", "ab11");
        tokuteiKankeiHoujinRn4.setZrnmarukinhyouji("1");
        tokuteiKankeiHoujinRn4.setZrntkhjnkjdrtennm("店名");
        tokuteiKankeiHoujinRn4.setZrndairitenbetutuuban("0004");
        tokuteiKankeiHoujinRn4.setZrnkanjitokuteikankeinm("人名");
        tokuteiKankeiHoujinRn4.setZrntokuteikankeihoujinnm("法人名");
        tokuteiKankeiHoujinRn4.setZrnkousinymd("20160414");
        tokuteiKankeiHoujinRn4.setZrnyobiv79("v79");

        em.persist(tokuteiKankeiHoujinRn4);

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_001() {

        BzRenkeiHenkanKyouyuuDiscDao bzRenkeiHenkanKyouyuuDiscDao = SWAKInjector.getInstance(BzRenkeiHenkanKyouyuuDiscDao.class);
        bzRenkeiHenkanKyouyuuDiscDao.deleteByTableid("ZT_DsKariPasswordTuutiTy");

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_001rs() {

        Assert.assertFalse(zdbDomManager.getAllDsKariPasswordTuutiTy().iterator().hasNext());
    }
    @Test
    @TestOrder(10)
    @Transactional
    public void Test_002() {

        BzRenkeiHenkanKyouyuuDiscDao bzRenkeiHenkanKyouyuuDiscDao = SWAKInjector.getInstance(BzRenkeiHenkanKyouyuuDiscDao.class);
        bzRenkeiHenkanKyouyuuDiscDao.deleteByTableid("ZT_TokuteiKankeiHoujinRn");
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_002rs() {

        Assert.assertFalse(zdbDomManager.getAllTokuteiKankeiHoujinRn().iterator().hasNext());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_003() {

        try{
            bzRenkeiHenkanKyouyuuDiscDao.deleteByTableid("ZT_DsKariPassword");
            assertTrue(false);
        }catch (Exception e) {
            assertTrue(true);
        }
    }
}
