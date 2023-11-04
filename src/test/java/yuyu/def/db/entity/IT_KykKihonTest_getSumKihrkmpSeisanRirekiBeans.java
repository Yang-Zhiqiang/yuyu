package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SumKihrkmpSeisanRirekiBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 既払込Ｐ精算履歴合計値Beanリスト取得<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getSumKihrkmpSeisanRirekiBeans {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("10000000001");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10", "10000000001");

            List<SumKihrkmpSeisanRirekiBean> sumKihrkmpSeisanRirekiBeanLst = kykKihon1.getSumKihrkmpSeisanRirekiBeans();
            Assert.assertEquals(0, sumKihrkmpSeisanRirekiBeanLst.size());

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki1 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki1.setRenno(1);
            kihrkmpSeisanRireki1.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MISYUUP);
            kihrkmpSeisanRireki1.setSeisanpgoukei(BizCurrency.valueOf(101,BizCurrencyTypes.YEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki2 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki2.setRenno(2);
            kihrkmpSeisanRireki2.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MISYUUP);
            kihrkmpSeisanRireki2.setSeisanpgoukei(BizCurrency.valueOf(102,BizCurrencyTypes.YEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki3 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki3.setRenno(3);
            kihrkmpSeisanRireki3.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MIKEIKAP);
            kihrkmpSeisanRireki3.setSeisanpgoukei(BizCurrency.valueOf(103,BizCurrencyTypes.YEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki4 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki4.setRenno(4);
            kihrkmpSeisanRireki4.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MISYUUP);
            kihrkmpSeisanRireki4.setSeisanpgoukei(BizCurrency.valueOf(104,BizCurrencyTypes.DOLLAR));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki5 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki5.setRenno(5);
            kihrkmpSeisanRireki5.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MISYUUP);
            kihrkmpSeisanRireki5.setSeisanpgoukei(BizCurrency.valueOf(105,BizCurrencyTypes.MANYEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki6 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki6.setRenno(6);
            kihrkmpSeisanRireki6.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MISYUUP);

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki7 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki7.setRenno(7);
            kihrkmpSeisanRireki7.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MISYUUP);
            kihrkmpSeisanRireki7.setYenkansansspgoukei(BizCurrency.valueOf(401,BizCurrencyTypes.YEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki8 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki8.setRenno(8);
            kihrkmpSeisanRireki8.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MISYUUP);
            kihrkmpSeisanRireki8.setYenkansansspgoukei(BizCurrency.valueOf(402,BizCurrencyTypes.YEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki9 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki9.setRenno(9);
            kihrkmpSeisanRireki9.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MISYUUP);
            kihrkmpSeisanRireki9.setSeisanpgoukei(BizCurrency.valueOf(3,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki9.setYenkansansspgoukei(BizCurrency.valueOf(403,BizCurrencyTypes.YEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki10 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki10.setRenno(10);
            kihrkmpSeisanRireki10.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MIKEIKAP);
            kihrkmpSeisanRireki10.setSeisanpgoukei(BizCurrency.valueOf(20,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki10.setYenkansansspgoukei(BizCurrency.valueOf(404,BizCurrencyTypes.DOLLAR));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki11 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki11.setRenno(11);
            kihrkmpSeisanRireki11.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MISYUUP);
            kihrkmpSeisanRireki11.setYenkansansspgoukei(BizCurrency.valueOf(405,BizCurrencyTypes.MANYEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki12 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki12.setRenno(13);
            kihrkmpSeisanRireki12.setMisyuumikeikakbn(C_MisyuumikeikaKbn.BLNK);
            kihrkmpSeisanRireki12.setYenkansansspgoukei(BizCurrency.valueOf(406,BizCurrencyTypes.MANYEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki14 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki14.setRenno(14);
            kihrkmpSeisanRireki14.setMisyuumikeikakbn(C_MisyuumikeikaKbn.BLNK);
            kihrkmpSeisanRireki14.setSeisanpgoukei(BizCurrency.valueOf(11,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki14.setYenkansansspgoukei(BizCurrency.valueOf(406,BizCurrencyTypes.MANYEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki15 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki15.setRenno(15);
            kihrkmpSeisanRireki15.setMisyuumikeikakbn(C_MisyuumikeikaKbn.BLNK);
            kihrkmpSeisanRireki15.setSeisanpgoukei(BizCurrency.valueOf(12,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki15.setYenkansansspgoukei(BizCurrency.valueOf(406,BizCurrencyTypes.MANYEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki16 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki16.setRenno(16);
            kihrkmpSeisanRireki16.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MIKEIKAP);
            kihrkmpSeisanRireki16.setYenkansansspgoukei(BizCurrency.valueOf(50.5,BizCurrencyTypes.DOLLAR));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki13 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki13.setRenno(12);
            kihrkmpSeisanRireki13.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MISYUUP);

            hozenDomManager.insert(kykKihon1);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("10000000002");
        if (null == kykKihon2) {

            kykKihon2 = new IT_KykKihon("10","10000000002");

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki14 = kykKihon2.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki14.setRenno(1);
            kihrkmpSeisanRireki14.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MISYUUP);
            kihrkmpSeisanRireki14.setSeisanpgoukei(BizCurrency.valueOf(101,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki14.setYenkansansspgoukei(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));

            hozenDomManager.insert(kykKihon2);
        }

        IT_KykKihon kykKihon3 = hozenDomManager.getKykKihon("10000000003");
        if (null == kykKihon3) {

            kykKihon3 = new IT_KykKihon("10","10000000003");

            hozenDomManager.insert(kykKihon3);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000003");
        List<SumKihrkmpSeisanRirekiBean> sumKihrkmpSeisanRirekiBeanLst = kykKihon.getSumKihrkmpSeisanRirekiBeans();
        Assert.assertEquals(0, sumKihrkmpSeisanRirekiBeanLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000002");
        List<SumKihrkmpSeisanRirekiBean> sumKihrkmpSeisanRirekiBeanLst = kykKihon.getSumKihrkmpSeisanRirekiBeans();
        Assert.assertEquals(C_MisyuumikeikaKbn.MISYUUP, sumKihrkmpSeisanRirekiBeanLst.get(0).getMisyuumikeikakbn());
        Assert.assertEquals(1, sumKihrkmpSeisanRirekiBeanLst.size());
        Assert.assertEquals(1, sumKihrkmpSeisanRirekiBeanLst.get(0).getSumSeisanpgoukei().size());
        Assert.assertEquals(BizCurrency.valueOf(101), sumKihrkmpSeisanRirekiBeanLst.get(0).getSumSeisanpgoukei().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(0), sumKihrkmpSeisanRirekiBeanLst.get(0).getSumYenkansansspgoukei().get(BizCurrencyTypes.YEN));

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000001");
        List<SumKihrkmpSeisanRirekiBean> sumKihrkmpSeisanRirekiBeanLst = kykKihon.getSumKihrkmpSeisanRirekiBeans();
        Assert.assertEquals(3, sumKihrkmpSeisanRirekiBeanLst.size());

        Assert.assertEquals(C_MisyuumikeikaKbn.MIKEIKAP, sumKihrkmpSeisanRirekiBeanLst.get(0).getMisyuumikeikakbn());
        Assert.assertEquals(1, sumKihrkmpSeisanRirekiBeanLst.get(0).getSumSeisanpgoukei().size());
        Assert.assertEquals(BizCurrency.valueOf(123), sumKihrkmpSeisanRirekiBeanLst.get(0).getSumSeisanpgoukei().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(1, sumKihrkmpSeisanRirekiBeanLst.get(0).getSumYenkansansspgoukei().size());
        Assert.assertEquals(BizCurrency.valueOf(454.5,BizCurrencyTypes.DOLLAR), sumKihrkmpSeisanRirekiBeanLst.get(0).getSumYenkansansspgoukei().get(BizCurrencyTypes.DOLLAR));

        Assert.assertEquals(C_MisyuumikeikaKbn.MISYUUP, sumKihrkmpSeisanRirekiBeanLst.get(1).getMisyuumikeikakbn());
        Assert.assertEquals(3, sumKihrkmpSeisanRirekiBeanLst.get(1).getSumSeisanpgoukei().size());
        Assert.assertEquals(BizCurrency.valueOf(206), sumKihrkmpSeisanRirekiBeanLst.get(1).getSumSeisanpgoukei().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(104,BizCurrencyTypes.DOLLAR), sumKihrkmpSeisanRirekiBeanLst.get(1).getSumSeisanpgoukei().get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(105,BizCurrencyTypes.MANYEN), sumKihrkmpSeisanRirekiBeanLst.get(1).getSumSeisanpgoukei().get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(2, sumKihrkmpSeisanRirekiBeanLst.get(1).getSumYenkansansspgoukei().size());
        Assert.assertEquals(BizCurrency.valueOf(1206), sumKihrkmpSeisanRirekiBeanLst.get(1).getSumYenkansansspgoukei().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(405,BizCurrencyTypes.MANYEN), sumKihrkmpSeisanRirekiBeanLst.get(1).getSumYenkansansspgoukei().get(BizCurrencyTypes.MANYEN));

        Assert.assertEquals(C_MisyuumikeikaKbn.BLNK, sumKihrkmpSeisanRirekiBeanLst.get(2).getMisyuumikeikakbn());
        Assert.assertEquals(1, sumKihrkmpSeisanRirekiBeanLst.get(2).getSumSeisanpgoukei().size());
        Assert.assertEquals(BizCurrency.valueOf(23), sumKihrkmpSeisanRirekiBeanLst.get(2).getSumSeisanpgoukei().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(1, sumKihrkmpSeisanRirekiBeanLst.get(2).getSumYenkansansspgoukei().size());
        Assert.assertEquals(BizCurrency.valueOf(1218,BizCurrencyTypes.MANYEN), sumKihrkmpSeisanRirekiBeanLst.get(2).getSumYenkansansspgoukei().get(BizCurrencyTypes.MANYEN));
    }
}
