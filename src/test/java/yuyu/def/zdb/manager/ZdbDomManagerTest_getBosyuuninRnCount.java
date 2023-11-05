package yuyu.def.zdb.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.ZT_BosyuuninRn;
import yuyu.def.db.meta.QZT_BosyuuninRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 募集人マスタのテストクラス<br />
 */
@RunWith(OrderedRunner.class)

public class ZdbDomManagerTest_getBosyuuninRnCount {

    @Inject
    private ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);
        Long count = zdbDomManager.getBosyuuninRnCount();
        Assert.assertEquals(new Long(0), count);

        ZT_BosyuuninRn bosyuuninRn1 = new ZT_BosyuuninRn("A00001");
        bosyuuninRn1.setZrnbosyuuninnm("A2");
        bosyuuninRn1.setZrnkanjibosyuuninnm("A3");
        bosyuuninRn1.setZrnitakuymd("A4");
        bosyuuninRn1.setZrndairitencd1("A5");
        bosyuuninRn1.setZrndairitencd2("A6");
        bosyuuninRn1.setZrndairitencd3("A7");
        bosyuuninRn1.setZrndairitenkanrisskcd1("A8");
        bosyuuninRn1.setZrndairitenkanrisskcd2("A9");
        bosyuuninRn1.setZrndairitenkanrisskcd3("A10");
        bosyuuninRn1.setZrnbosyuukbn("A");
        bosyuuninRn1.setZrnbosyuunintourokuymd("A12");
        bosyuuninRn1.setZrnbosyuuninkahikbn("A");
        bosyuuninRn1.setZrnbosyuuningyouhaiymd("A14");
        bosyuuninRn1.setZrnhengakutourokuymd("A15");
        bosyuuninRn1.setZrnhengakumassyouymd("A16");
        bosyuuninRn1.setZrnbosyuuseiymd("A17");
        bosyuuninRn1.setZrnitakukaiyakuymd("A18");
        bosyuuninRn1.setZrndaihyoubosyuunincd("A19");
        bosyuuninRn1.setZrnbosyuutourokuno("A20");
        bosyuuninRn1.setZrnyobiv5("A21");

        zdbDomManager.insert(bosyuuninRn1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_BosyuuninRn qZT_BosyuuninRn = new QZT_BosyuuninRn("qZT_BosyuuninRn");
        String jpql2 = $DELETE_FROM(qZT_BosyuuninRn) ;
        em.createJPQL(jpql2).bind(qZT_BosyuuninRn).executeUpdate();

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal1() {

        Long count = zdbDomManager.getBosyuuninRnCount();
        Assert.assertEquals(new Long(1), count);


    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {
        zdbDomManager.delete(zdbDomManager.getBosyuuninRn("A00001"));

        ZT_BosyuuninRn bosyuuninRn1 = new ZT_BosyuuninRn("A00001");
        bosyuuninRn1.setZrnbosyuuninnm("A2");
        bosyuuninRn1.setZrnkanjibosyuuninnm("A3");
        bosyuuninRn1.setZrnitakuymd("A4");
        bosyuuninRn1.setZrndairitencd1("A5");
        bosyuuninRn1.setZrndairitencd2("A6");
        bosyuuninRn1.setZrndairitencd3("A7");
        bosyuuninRn1.setZrndairitenkanrisskcd1("A8");
        bosyuuninRn1.setZrndairitenkanrisskcd2("A9");
        bosyuuninRn1.setZrndairitenkanrisskcd3("A10");
        bosyuuninRn1.setZrnbosyuukbn("A");
        bosyuuninRn1.setZrnbosyuunintourokuymd("A12");
        bosyuuninRn1.setZrnbosyuuninkahikbn("A");
        bosyuuninRn1.setZrnbosyuuningyouhaiymd("A14");
        bosyuuninRn1.setZrnhengakutourokuymd("A15");
        bosyuuninRn1.setZrnhengakumassyouymd("A16");
        bosyuuninRn1.setZrnbosyuuseiymd("A17");
        bosyuuninRn1.setZrnitakukaiyakuymd("A18");
        bosyuuninRn1.setZrndaihyoubosyuunincd("A19");
        bosyuuninRn1.setZrnbosyuutourokuno("A20");
        bosyuuninRn1.setZrnyobiv5("A21");

        zdbDomManager.insert(bosyuuninRn1);

        ZT_BosyuuninRn bosyuuninRn2 = new ZT_BosyuuninRn("B00001");
        bosyuuninRn2.setZrnbosyuuninnm("B2");
        bosyuuninRn2.setZrnkanjibosyuuninnm("B3");
        bosyuuninRn2.setZrnitakuymd("B4");
        bosyuuninRn2.setZrndairitencd1("B5");
        bosyuuninRn2.setZrndairitencd2("B6");
        bosyuuninRn2.setZrndairitencd3("B7");
        bosyuuninRn2.setZrndairitenkanrisskcd1("B8");
        bosyuuninRn2.setZrndairitenkanrisskcd2("B9");
        bosyuuninRn2.setZrndairitenkanrisskcd3("B10");
        bosyuuninRn2.setZrnbosyuukbn("B");
        bosyuuninRn2.setZrnbosyuunintourokuymd("B12");
        bosyuuninRn2.setZrnbosyuuninkahikbn("B");
        bosyuuninRn2.setZrnbosyuuningyouhaiymd("B14");
        bosyuuninRn2.setZrnhengakutourokuymd("B15");
        bosyuuninRn2.setZrnhengakumassyouymd("B16");
        bosyuuninRn2.setZrnbosyuuseiymd("B17");
        bosyuuninRn2.setZrnitakukaiyakuymd("B18");
        bosyuuninRn2.setZrndaihyoubosyuunincd("B19");
        bosyuuninRn2.setZrnbosyuutourokuno("B20");
        bosyuuninRn2.setZrnyobiv5("B21");

        zdbDomManager.insert(bosyuuninRn2);

        ZT_BosyuuninRn bosyuuninRn3 = new ZT_BosyuuninRn("C00001");
        bosyuuninRn3.setZrnbosyuuninnm("C2");
        bosyuuninRn3.setZrnkanjibosyuuninnm("C3");
        bosyuuninRn3.setZrnitakuymd("C4");
        bosyuuninRn3.setZrndairitencd1("C5");
        bosyuuninRn3.setZrndairitencd2("C6");
        bosyuuninRn3.setZrndairitencd3("C7");
        bosyuuninRn3.setZrndairitenkanrisskcd1("C8");
        bosyuuninRn3.setZrndairitenkanrisskcd2("C9");
        bosyuuninRn3.setZrndairitenkanrisskcd3("C10");
        bosyuuninRn3.setZrnbosyuukbn("C");
        bosyuuninRn3.setZrnbosyuunintourokuymd("C12");
        bosyuuninRn3.setZrnbosyuuninkahikbn("C");
        bosyuuninRn3.setZrnbosyuuningyouhaiymd("C14");
        bosyuuninRn3.setZrnhengakutourokuymd("C15");
        bosyuuninRn3.setZrnhengakumassyouymd("C16");
        bosyuuninRn3.setZrnbosyuuseiymd("C17");
        bosyuuninRn3.setZrnitakukaiyakuymd("C18");
        bosyuuninRn3.setZrndaihyoubosyuunincd("C19");
        bosyuuninRn3.setZrnbosyuutourokuno("C20");
        bosyuuninRn3.setZrnyobiv5("C21");

        zdbDomManager.insert(bosyuuninRn3);

        ZT_BosyuuninRn bosyuuninRn4 = new ZT_BosyuuninRn("D00001");
        bosyuuninRn4.setZrnbosyuuninnm("D2");
        bosyuuninRn4.setZrnkanjibosyuuninnm("D3");
        bosyuuninRn4.setZrnitakuymd("D4");
        bosyuuninRn4.setZrndairitencd1("D5");
        bosyuuninRn4.setZrndairitencd2("D6");
        bosyuuninRn4.setZrndairitencd3("D7");
        bosyuuninRn4.setZrndairitenkanrisskcd1("D8");
        bosyuuninRn4.setZrndairitenkanrisskcd2("D9");
        bosyuuninRn4.setZrndairitenkanrisskcd3("D10");
        bosyuuninRn4.setZrnbosyuukbn("D");
        bosyuuninRn4.setZrnbosyuunintourokuymd("D12");
        bosyuuninRn4.setZrnbosyuuninkahikbn("D");
        bosyuuninRn4.setZrnbosyuuningyouhaiymd("D14");
        bosyuuninRn4.setZrnhengakutourokuymd("D15");
        bosyuuninRn4.setZrnhengakumassyouymd("D16");
        bosyuuninRn4.setZrnbosyuuseiymd("D17");
        bosyuuninRn4.setZrnitakukaiyakuymd("D18");
        bosyuuninRn4.setZrndaihyoubosyuunincd("D19");
        bosyuuninRn4.setZrnbosyuutourokuno("D20");
        bosyuuninRn4.setZrnyobiv5("D21");

        zdbDomManager.insert(bosyuuninRn4);

        ZT_BosyuuninRn bosyuuninRn5 = new ZT_BosyuuninRn("E00001");
        bosyuuninRn5.setZrnbosyuuninnm("E2");
        bosyuuninRn5.setZrnkanjibosyuuninnm("E3");
        bosyuuninRn5.setZrnitakuymd("E4");
        bosyuuninRn5.setZrndairitencd1("E5");
        bosyuuninRn5.setZrndairitencd2("E6");
        bosyuuninRn5.setZrndairitencd3("E7");
        bosyuuninRn5.setZrndairitenkanrisskcd1("E8");
        bosyuuninRn5.setZrndairitenkanrisskcd2("E9");
        bosyuuninRn5.setZrndairitenkanrisskcd3("E10");
        bosyuuninRn5.setZrnbosyuukbn("E");
        bosyuuninRn5.setZrnbosyuunintourokuymd("E12");
        bosyuuninRn5.setZrnbosyuuninkahikbn("E");
        bosyuuninRn5.setZrnbosyuuningyouhaiymd("E14");
        bosyuuninRn5.setZrnhengakutourokuymd("E15");
        bosyuuninRn5.setZrnhengakumassyouymd("E16");
        bosyuuninRn5.setZrnbosyuuseiymd("E17");
        bosyuuninRn5.setZrnitakukaiyakuymd("E18");
        bosyuuninRn5.setZrndaihyoubosyuunincd("E19");
        bosyuuninRn5.setZrnbosyuutourokuno("E20");
        bosyuuninRn5.setZrnyobiv5("E21");

        zdbDomManager.insert(bosyuuninRn5);
    }

    @Test
    @TestOrder(21)
    public void normal21() {

        Long count = zdbDomManager.getBosyuuninRnCount();
        Assert.assertEquals(new Long(5), count);

    }

}
