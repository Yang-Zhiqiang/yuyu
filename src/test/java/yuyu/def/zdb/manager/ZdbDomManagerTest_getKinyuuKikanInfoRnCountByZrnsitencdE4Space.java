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

import yuyu.def.db.entity.ZT_KinyuuKikanInfoRn;
import yuyu.def.db.meta.QZT_KinyuuKikanInfoRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 金融機関情報連動ファイルテーブル（連）のテストクラス<br />
 */

@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getKinyuuKikanInfoRnCountByZrnsitencdE4Space {

    @Inject
    ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        Long kinyuukikaninfoSize= zdbDomManager.getKinyuuKikanInfoRnCountByZrnsitencdE4Space();

        Assert.assertEquals(0,kinyuukikaninfoSize.intValue());

        ZT_KinyuuKikanInfoRn kinyuuKikanInfoRn1 = new ZT_KinyuuKikanInfoRn("A001", "a123");
        kinyuuKikanInfoRn1.setZrntenpokbn("01");
        kinyuuKikanInfoRn1.setZrnkousinymd("20150101");
        kinyuuKikanInfoRn1.setZrnsinsetuymd("20150101");
        kinyuuKikanInfoRn1.setZrnhaisiymd("20150101");
        kinyuuKikanInfoRn1.setZrnkanakinyuukikannm("ｷﾝﾕｳｷｷﾝﾕｳｷｷﾝﾕｳｷｷﾝﾕｳｷｷﾝﾕｳｷ");
        kinyuuKikanInfoRn1.setZrnkanasitennm("ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒｲ");
        kinyuuKikanInfoRn1.setZrnkanjikinyuukikannm("金融");
        kinyuuKikanInfoRn1.setZrnkanjisitennm("支店");
        kinyuuKikanInfoRn1.setZrneijikinyuukikannm("abcdefghijkabcdefghijkabcdefghijkabcdefghijkabcdefghijkabcde");
        kinyuuKikanInfoRn1.setZrneijisitennm("abcdefghijkabcdefghijkabcdefghijkabcdefghijkabcdefghijkabcde");
        kinyuuKikanInfoRn1.setZrncsskyouteikaisiymd("20161114");
        kinyuuKikanInfoRn1.setZrncsskyouteikaijyoymd("20161114");
        kinyuuKikanInfoRn1.setZrnkokunaikawasehyouji("1");
        kinyuuKikanInfoRn1.setZrnhurikomikanousitenhyouji("1");
        kinyuuKikanInfoRn1.setZrngyoutaikbn("01");
        kinyuuKikanInfoRn1.setZrnyofurikyouteikaisiymd("20181212");
        kinyuuKikanInfoRn1.setZrnyofurikyouteikaijyoymd("20181212");
        kinyuuKikanInfoRn1.setZrnitakusyakinyuucd("1111");
        kinyuuKikanInfoRn1.setZrnitakusyasitencd("2222");
        kinyuuKikanInfoRn1.setZrnitakusyayokinkbn("1");
        kinyuuKikanInfoRn1.setZrnitakusyakouzano("12345678");
        kinyuuKikanInfoRn1.setZrntsrkeisanhoukbn("1");
        kinyuuKikanInfoRn1.setZrnkinyuutesuuryou(10000);
        kinyuuKikanInfoRn1.setZrnitakusyacd("0123456789");
        kinyuuKikanInfoRn1.setZrntapekoukankbn1("1");
        kinyuuKikanInfoRn1.setZrnmdsisyacd("1234567");
        kinyuuKikanInfoRn1.setZrnzzkkyouteikaisiymd("20181212");
        kinyuuKikanInfoRn1.setZrnzzkkyouteikaijyoymd("20181212");
        kinyuuKikanInfoRn1.setZrnhuhoyofuriinfokousinymd("20181212");
        kinyuuKikanInfoRn1.setZrnyobiv17("12345678901234567");
        zdbDomManager.insert(kinyuuKikanInfoRn1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_KinyuuKikanInfoRn qZT_KinyuuKikanInfoRn = new QZT_KinyuuKikanInfoRn("qZT_KinyuuKikanInfoRn");
        String jpql1 = $DELETE_FROM(qZT_KinyuuKikanInfoRn) ;
        em.createJPQL(jpql1).bind(qZT_KinyuuKikanInfoRn).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        Long kinyuukikaninfoSize= zdbDomManager.getKinyuuKikanInfoRnCountByZrnsitencdE4Space();

        Assert.assertEquals(0,kinyuukikaninfoSize.intValue());

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1(){

        ZdbDomManager zdbdomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        ZT_KinyuuKikanInfoRn kinyuuKikanInfoRn2 = new ZT_KinyuuKikanInfoRn("A002", "");
        kinyuuKikanInfoRn2.setZrntenpokbn("01");
        kinyuuKikanInfoRn2.setZrnkousinymd("20150101");
        kinyuuKikanInfoRn2.setZrnsinsetuymd("20150101");
        kinyuuKikanInfoRn2.setZrnhaisiymd("20150101");
        kinyuuKikanInfoRn2.setZrnkanakinyuukikannm("ｷﾝﾕｳｷｷﾝﾕｳｷｷﾝﾕｳｷｷﾝﾕｳｷｷﾝﾕｳｷ");
        kinyuuKikanInfoRn2.setZrnkanasitennm("ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒｲ");
        kinyuuKikanInfoRn2.setZrnkanjikinyuukikannm("金融");
        kinyuuKikanInfoRn2.setZrnkanjisitennm("支店");
        kinyuuKikanInfoRn2.setZrneijikinyuukikannm("abcdefghijkabcdefghijkabcdefghijkabcdefghijkabcdefghijkabcde");
        kinyuuKikanInfoRn2.setZrneijisitennm("abcdefghijkabcdefghijkabcdefghijkabcdefghijkabcdefghijkabcde");
        kinyuuKikanInfoRn2.setZrncsskyouteikaisiymd("20161114");
        kinyuuKikanInfoRn2.setZrncsskyouteikaijyoymd("20161114");
        kinyuuKikanInfoRn2.setZrnkokunaikawasehyouji("1");
        kinyuuKikanInfoRn2.setZrnhurikomikanousitenhyouji("1");
        kinyuuKikanInfoRn2.setZrngyoutaikbn("01");
        kinyuuKikanInfoRn2.setZrnyofurikyouteikaisiymd("20181212");
        kinyuuKikanInfoRn2.setZrnyofurikyouteikaijyoymd("20181212");
        kinyuuKikanInfoRn2.setZrnitakusyakinyuucd("1111");
        kinyuuKikanInfoRn2.setZrnitakusyasitencd("2222");
        kinyuuKikanInfoRn2.setZrnitakusyayokinkbn("1");
        kinyuuKikanInfoRn2.setZrnitakusyakouzano("12345678");
        kinyuuKikanInfoRn2.setZrntsrkeisanhoukbn("1");
        kinyuuKikanInfoRn2.setZrnkinyuutesuuryou(10000);
        kinyuuKikanInfoRn2.setZrnitakusyacd("0123456789");
        kinyuuKikanInfoRn2.setZrntapekoukankbn1("1");
        kinyuuKikanInfoRn2.setZrnmdsisyacd("1234567");
        kinyuuKikanInfoRn2.setZrnzzkkyouteikaisiymd("20181212");
        kinyuuKikanInfoRn2.setZrnzzkkyouteikaijyoymd("20181212");
        kinyuuKikanInfoRn2.setZrnhuhoyofuriinfokousinymd("20181212");
        kinyuuKikanInfoRn2.setZrnyobiv17("12345678901234567");
        zdbdomManager.insert(kinyuuKikanInfoRn2);

        ZT_KinyuuKikanInfoRn kinyuuKikanInfoRn3 = new ZT_KinyuuKikanInfoRn("A003", "");
        kinyuuKikanInfoRn3.setZrntenpokbn("01");
        kinyuuKikanInfoRn3.setZrnkousinymd("20150101");
        kinyuuKikanInfoRn3.setZrnsinsetuymd("20150101");
        kinyuuKikanInfoRn3.setZrnhaisiymd("20150101");
        kinyuuKikanInfoRn3.setZrnkanakinyuukikannm("ｷﾝﾕｳｷｷﾝﾕｳｷｷﾝﾕｳｷｷﾝﾕｳｷｷﾝﾕｳｷ");
        kinyuuKikanInfoRn3.setZrnkanasitennm("ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒｲ");
        kinyuuKikanInfoRn3.setZrnkanjikinyuukikannm("金融");
        kinyuuKikanInfoRn3.setZrnkanjisitennm("支店");
        kinyuuKikanInfoRn3.setZrneijikinyuukikannm("abcdefghijkabcdefghijkabcdefghijkabcdefghijkabcdefghijkabcde");
        kinyuuKikanInfoRn3.setZrneijisitennm("abcdefghijkabcdefghijkabcdefghijkabcdefghijkabcdefghijkabcde");
        kinyuuKikanInfoRn3.setZrncsskyouteikaisiymd("20161114");
        kinyuuKikanInfoRn3.setZrncsskyouteikaijyoymd("20161114");
        kinyuuKikanInfoRn3.setZrnkokunaikawasehyouji("1");
        kinyuuKikanInfoRn3.setZrnhurikomikanousitenhyouji("1");
        kinyuuKikanInfoRn3.setZrngyoutaikbn("01");
        kinyuuKikanInfoRn3.setZrnyofurikyouteikaisiymd("20181212");
        kinyuuKikanInfoRn3.setZrnyofurikyouteikaijyoymd("20181212");
        kinyuuKikanInfoRn3.setZrnitakusyakinyuucd("1111");
        kinyuuKikanInfoRn3.setZrnitakusyasitencd("2222");
        kinyuuKikanInfoRn3.setZrnitakusyayokinkbn("1");
        kinyuuKikanInfoRn3.setZrnitakusyakouzano("12345678");
        kinyuuKikanInfoRn3.setZrntsrkeisanhoukbn("1");
        kinyuuKikanInfoRn3.setZrnkinyuutesuuryou(10000);
        kinyuuKikanInfoRn3.setZrnitakusyacd("0123456789");
        kinyuuKikanInfoRn3.setZrntapekoukankbn1("1");
        kinyuuKikanInfoRn3.setZrnmdsisyacd("1234567");
        kinyuuKikanInfoRn3.setZrnzzkkyouteikaisiymd("20181212");
        kinyuuKikanInfoRn3.setZrnzzkkyouteikaijyoymd("20181212");
        kinyuuKikanInfoRn3.setZrnhuhoyofuriinfokousinymd("20181212");
        kinyuuKikanInfoRn3.setZrnyobiv17("12345678901234567");
        zdbdomManager.insert(kinyuuKikanInfoRn3);

        ZT_KinyuuKikanInfoRn kinyuuKikanInfoRn4 = new ZT_KinyuuKikanInfoRn("A004", "");
        kinyuuKikanInfoRn4.setZrntenpokbn("01");
        kinyuuKikanInfoRn4.setZrnkousinymd("20150101");
        kinyuuKikanInfoRn4.setZrnsinsetuymd("20150101");
        kinyuuKikanInfoRn4.setZrnhaisiymd("20150101");
        kinyuuKikanInfoRn4.setZrnkanakinyuukikannm("ｷﾝﾕｳｷｷﾝﾕｳｷｷﾝﾕｳｷｷﾝﾕｳｷｷﾝﾕｳｷ");
        kinyuuKikanInfoRn4.setZrnkanasitennm("ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒｲ");
        kinyuuKikanInfoRn4.setZrnkanjikinyuukikannm("金融");
        kinyuuKikanInfoRn4.setZrnkanjisitennm("支店");
        kinyuuKikanInfoRn4.setZrneijikinyuukikannm("abcdefghijkabcdefghijkabcdefghijkabcdefghijkabcdefghijkabcde");
        kinyuuKikanInfoRn4.setZrneijisitennm("abcdefghijkabcdefghijkabcdefghijkabcdefghijkabcdefghijkabcde");
        kinyuuKikanInfoRn4.setZrncsskyouteikaisiymd("20161114");
        kinyuuKikanInfoRn4.setZrncsskyouteikaijyoymd("20161114");
        kinyuuKikanInfoRn4.setZrnkokunaikawasehyouji("1");
        kinyuuKikanInfoRn4.setZrnhurikomikanousitenhyouji("1");
        kinyuuKikanInfoRn4.setZrngyoutaikbn("01");
        kinyuuKikanInfoRn4.setZrnyofurikyouteikaisiymd("20181212");
        kinyuuKikanInfoRn4.setZrnyofurikyouteikaijyoymd("20181212");
        kinyuuKikanInfoRn4.setZrnitakusyakinyuucd("1111");
        kinyuuKikanInfoRn4.setZrnitakusyasitencd("2222");
        kinyuuKikanInfoRn4.setZrnitakusyayokinkbn("1");
        kinyuuKikanInfoRn4.setZrnitakusyakouzano("12345678");
        kinyuuKikanInfoRn4.setZrntsrkeisanhoukbn("1");
        kinyuuKikanInfoRn4.setZrnkinyuutesuuryou(10000);
        kinyuuKikanInfoRn4.setZrnitakusyacd("0123456789");
        kinyuuKikanInfoRn4.setZrntapekoukankbn1("1");
        kinyuuKikanInfoRn4.setZrnmdsisyacd("1234567");
        kinyuuKikanInfoRn4.setZrnzzkkyouteikaisiymd("20181212");
        kinyuuKikanInfoRn4.setZrnzzkkyouteikaijyoymd("20181212");
        kinyuuKikanInfoRn4.setZrnhuhoyofuriinfokousinymd("20181212");
        kinyuuKikanInfoRn4.setZrnyobiv17("12345678901234567");
        zdbdomManager.insert(kinyuuKikanInfoRn4);

        Long kinyuukikaninfoSize = zdbdomManager.getKinyuuKikanInfoRnCountByZrnsitencdE4Space();

        Assert.assertEquals(3,kinyuukikaninfoSize.intValue());

    }
}
