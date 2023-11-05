package yuyu.batch.biz.bznayose.bztjtidounyitjhzntblsakujyo;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.ZT_DsKariPasswordTuutiTy;
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 当日異動内容一時保存TBL削除DAOクラスの<br />
 * deleteByTableid のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzTjtIdouNyItjhznTblSakujyoDaoTest_deleteByTableid {

    @Inject
    private BzTjtIdouNyItjhznTblSakujyoDao bzTjtIdouNyItjhznTblSakujyoDao;
    @Inject
    private ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

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

        ZT_TuutirirekiMeisaiFRn tuutirirekiMeisaiFRn2 = new ZT_TuutirirekiMeisaiFRn("1234567890123", "20170121", "11");
        tuutirirekiMeisaiFRn2.setZrntuutisyuruicd("12345678");
        tuutirirekiMeisaiFRn2.setZrnhyoujiyoutuutisksymd("12345678");
        tuutirirekiMeisaiFRn2.setZrnyobiv11("12345678901");

        em.persist(tuutirirekiMeisaiFRn2);

        ZT_TuutirirekiMeisaiFRn tuutirirekiMeisaiFRn3 = new ZT_TuutirirekiMeisaiFRn("1234567890123", "20170122", "12");
        tuutirirekiMeisaiFRn3.setZrntuutisyuruicd("12345678");
        tuutirirekiMeisaiFRn3.setZrnhyoujiyoutuutisksymd("12345678");
        tuutirirekiMeisaiFRn3.setZrnyobiv11("12345678901");

        em.persist(tuutirirekiMeisaiFRn3);

        ZT_TuutirirekiMeisaiFRn tuutirirekiMeisaiFRn4 = new ZT_TuutirirekiMeisaiFRn("1234567890123", "20170123", "13");
        tuutirirekiMeisaiFRn4.setZrntuutisyuruicd("12345678");
        tuutirirekiMeisaiFRn4.setZrnhyoujiyoutuutisksymd("12345678");
        tuutirirekiMeisaiFRn4.setZrnyobiv11("12345678901");

        em.persist(tuutirirekiMeisaiFRn4);

        ZT_TuutirirekiMeisaiFRn tuutirirekiMeisaiFRn5 = new ZT_TuutirirekiMeisaiFRn("1234567890123", "20170124", "14");
        tuutirirekiMeisaiFRn5.setZrntuutisyuruicd("12345678");
        tuutirirekiMeisaiFRn5.setZrnhyoujiyoutuutisksymd("12345678");
        tuutirirekiMeisaiFRn5.setZrnyobiv11("12345678901");

        em.persist(tuutirirekiMeisaiFRn5);

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_001() {

        bzTjtIdouNyItjhznTblSakujyoDao.deleteByTableid("ZT_DsKariPasswordTuutiTy");

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void Test_001rs() {

        Assert.assertFalse(zdbDomManager.getAllDsKariPasswordTuutiTy().iterator().hasNext());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void Test_002() {

        bzTjtIdouNyItjhznTblSakujyoDao.deleteByTableid("ZT_TuutirirekiMeisaiFRn");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void Test_002rs() {

        Assert.assertFalse(zdbDomManager.getAllTuutirirekiMeisaiFRn().iterator().hasNext());
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void Test_003() {

        try {
            bzTjtIdouNyItjhznTblSakujyoDao.deleteByTableid("ZT_DsKariPassword");
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
