package yuyu.def.db.entity;

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

import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SumKihrkmpSeisanRirekiBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 既払込Ｐ精算履歴合計Bean取得<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getSumKihrkmpSeisanRirekiBean {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("17806000013");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("01", "17806000013");

            SumKihrkmpSeisanRirekiBean sumKihrkmpSeisanRirekiBean = kykKihon1.getSumKihrkmpSeisanRirekiBean();
            Assert.assertEquals(0, sumKihrkmpSeisanRirekiBean.getSumYenkansantuityoukin().size());
            Assert.assertEquals(0, sumKihrkmpSeisanRirekiBean.getSumYenkansanhenkankin().size());

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki1 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki1.setRenno(1);

            kihrkmpSeisanRireki1.setYenkansantuityoukin(BizCurrency.valueOf(101,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki1.setYenkansanhenkankin(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));


            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki2 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki2.setRenno(2);
            kihrkmpSeisanRireki2.setYenkansantuityoukin(BizCurrency.valueOf(102,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki2.setYenkansanhenkankin(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));


            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki3 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki3.setRenno(3);
            kihrkmpSeisanRireki3.setYenkansantuityoukin(BizCurrency.valueOf(103,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki3.setYenkansanhenkankin(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));


            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki4 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki4.setRenno(4);
            kihrkmpSeisanRireki4.setYenkansantuityoukin(BizCurrency.valueOf(104,BizCurrencyTypes.DOLLAR));
            kihrkmpSeisanRireki4.setYenkansanhenkankin(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki5 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki5.setRenno(5);
            kihrkmpSeisanRireki5.setYenkansantuityoukin(BizCurrency.valueOf(105,BizCurrencyTypes.MANYEN));
            kihrkmpSeisanRireki5.setYenkansanhenkankin(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki6 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki6.setRenno(6);
            kihrkmpSeisanRireki6.setYenkansanhenkankin(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki6.setYenkansantuityoukin(null);
            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki7 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki7.setRenno(7);
            kihrkmpSeisanRireki7.setYenkansantuityoukin(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki7.setYenkansanhenkankin(BizCurrency.valueOf(401,BizCurrencyTypes.YEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki8 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki8.setRenno(8);
            kihrkmpSeisanRireki8.setYenkansantuityoukin(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki8.setYenkansanhenkankin(BizCurrency.valueOf(402,BizCurrencyTypes.YEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki9 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki9.setRenno(9);
            kihrkmpSeisanRireki9.setYenkansantuityoukin(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki9.setYenkansanhenkankin(BizCurrency.valueOf(403,BizCurrencyTypes.YEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki10 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki10.setRenno(10);
            kihrkmpSeisanRireki10.setYenkansantuityoukin(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki10.setYenkansanhenkankin(BizCurrency.valueOf(404,BizCurrencyTypes.DOLLAR));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki11 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki11.setRenno(11);
            kihrkmpSeisanRireki11.setYenkansantuityoukin(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki11.setYenkansanhenkankin(BizCurrency.valueOf(405,BizCurrencyTypes.MANYEN));

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki12 = kykKihon1.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki12.setRenno(12);
            kihrkmpSeisanRireki12.setYenkansantuityoukin(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki12.setYenkansanhenkankin(null);

            hozenDomManager.insert(kykKihon1);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("17806000024");
        if (kykKihon2 == null) {
            kykKihon2 = new IT_KykKihon("02", "17806000024");
            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki1 = kykKihon2.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki1.setRenno(1);
            kihrkmpSeisanRireki1.setYenkansantuityoukin(BizCurrency.valueOf(101,BizCurrencyTypes.YEN));
            kihrkmpSeisanRireki1.setYenkansanhenkankin(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));

            hozenDomManager.insert(kykKihon2);
        }

        IT_KykKihon kykKihon3 = hozenDomManager.getKykKihon("17806000035");
        if (kykKihon3 == null) {
            kykKihon3 = new IT_KykKihon("03", "17806000035");
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000035");
        SumKihrkmpSeisanRirekiBean sumKihrkmpSeisanRirekiBean = kykKihon.getSumKihrkmpSeisanRirekiBean();
        Assert.assertEquals(0, sumKihrkmpSeisanRirekiBean.getSumYenkansantuityoukin().size());
        Assert.assertEquals(0, sumKihrkmpSeisanRirekiBean.getSumYenkansanhenkankin().size());


    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000024");
        SumKihrkmpSeisanRirekiBean sumKihrkmpSeisanRirekiBean = kykKihon.getSumKihrkmpSeisanRirekiBean();

        Assert.assertEquals(1, sumKihrkmpSeisanRirekiBean.getSumYenkansantuityoukin().size());
        Assert.assertEquals(BizCurrency.valueOf(101), sumKihrkmpSeisanRirekiBean.getSumYenkansantuityoukin().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(1, sumKihrkmpSeisanRirekiBean.getSumYenkansanhenkankin().size());
        Assert.assertEquals(BizCurrency.valueOf(0), sumKihrkmpSeisanRirekiBean.getSumYenkansanhenkankin().get(BizCurrencyTypes.YEN));

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        SumKihrkmpSeisanRirekiBean sumKihrkmpSeisanRirekiBean = kykKihon.getSumKihrkmpSeisanRirekiBean();

        Assert.assertEquals(3, sumKihrkmpSeisanRirekiBean.getSumYenkansantuityoukin().size());
        Assert.assertEquals(BizCurrency.valueOf(306), sumKihrkmpSeisanRirekiBean.getSumYenkansantuityoukin().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(104,BizCurrencyTypes.DOLLAR), sumKihrkmpSeisanRirekiBean.getSumYenkansantuityoukin().get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(105,BizCurrencyTypes.MANYEN), sumKihrkmpSeisanRirekiBean.getSumYenkansantuityoukin().get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(3, sumKihrkmpSeisanRirekiBean.getSumYenkansanhenkankin().size());
        Assert.assertEquals(BizCurrency.valueOf(1206), sumKihrkmpSeisanRirekiBean.getSumYenkansanhenkankin().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(404,BizCurrencyTypes.DOLLAR), sumKihrkmpSeisanRirekiBean.getSumYenkansanhenkankin().get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(405,BizCurrencyTypes.MANYEN), sumKihrkmpSeisanRirekiBean.getSumYenkansanhenkankin().get(BizCurrencyTypes.MANYEN));
    }
}
