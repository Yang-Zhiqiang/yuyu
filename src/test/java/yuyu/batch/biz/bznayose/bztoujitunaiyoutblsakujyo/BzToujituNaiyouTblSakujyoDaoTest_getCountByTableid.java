package yuyu.batch.biz.bznayose.bztoujitunaiyoutblsakujyo;

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
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 当日異動内容TBL削除DAOクラスの<br />
 * getCountByTableid のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzToujituNaiyouTblSakujyoDaoTest_getCountByTableid {

    @Inject
    private BzToujituNaiyouTblSakujyoDao bzToujituNaiyouTblSakujyoDao;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        deleteTestSubData();

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        BzToujituNaiyouTblSakujyoDao bzToujituNaiyouTblSakujyoDao = SWAKInjector
                .getInstance(BzToujituNaiyouTblSakujyoDao.class);

        Long rs = bzToujituNaiyouTblSakujyoDao.getCountByTableid("ZT_DsKariPasswordTuutiTy");
        Assert.assertEquals(new Long(0), rs);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy1 = new ZT_DsKariPasswordTuutiTy("abc231");

        em.persist(dsKariPasswordTuutiTy1);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy2 = new ZT_DsKariPasswordTuutiTy("abc321");

        em.persist(dsKariPasswordTuutiTy2);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy3 = new ZT_DsKariPasswordTuutiTy("abc123");

        em.persist(dsKariPasswordTuutiTy3);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy4 = new ZT_DsKariPasswordTuutiTy("abc132");

        em.persist(dsKariPasswordTuutiTy4);

        ZT_TuutirirekiMeisaiFRn tuutirirekiMeisaiFRn1 = new ZT_TuutirirekiMeisaiFRn("1234567890123", "20170120", "10");
        tuutirirekiMeisaiFRn1.setZrntuutisyuruicd("12345678");
        tuutirirekiMeisaiFRn1.setZrnhyoujiyoutuutisksymd("12345678");
        tuutirirekiMeisaiFRn1.setZrnyobiv11("12345678901");

        em.persist(tuutirirekiMeisaiFRn1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void Test_000() {

        Long rs = bzToujituNaiyouTblSakujyoDao.getCountByTableid("ZT_SyainMeiboTy");
        Assert.assertEquals(new Long(0), rs);

    }

    @Test
    @TestOrder(10)
    public void Test_001() {

        Long rs = bzToujituNaiyouTblSakujyoDao.getCountByTableid("ZT_TuutirirekiMeisaiFRn");
        Assert.assertEquals(new Long(1), rs);

    }

    @Test
    @TestOrder(10)
    public void Test_002() {

        Long rs = bzToujituNaiyouTblSakujyoDao.getCountByTableid("ZT_DsKariPasswordTuutiTy");
        Assert.assertEquals(new Long(4), rs);
    }

    @Test
    @TestOrder(10)
    public void Test_003() {

        try {
            bzToujituNaiyouTblSakujyoDao.getCountByTableid("ZT_DsKariPassword");
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BzToujituNaiyouTblSakujyoDao bzToujituNaiyouTblSakujyoDao = SWAKInjector
                .getInstance(BzToujituNaiyouTblSakujyoDao.class);
        bzToujituNaiyouTblSakujyoDao.deleteByTableid("ZT_DsKariPasswordTuutiTy");
        bzToujituNaiyouTblSakujyoDao.deleteByTableid("ZT_TuutirirekiMeisaiFRn");
    }
}
