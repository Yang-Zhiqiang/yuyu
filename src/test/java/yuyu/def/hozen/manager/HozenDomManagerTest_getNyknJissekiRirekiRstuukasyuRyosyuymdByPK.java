package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.result.bean.NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金実績履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getNyknJissekiRirekiRstuukasyuRyosyuymdByPK {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean beanResult = hozenDomManager.getNyknJissekiRirekiRstuukasyuRyosyuymdByPK("11807111118", BizDateYM.valueOf("201601"), 21);
        Assert.assertNull(beanResult);

        IT_KykKihon kykKihon1 = new IT_KykKihon("11", "11807111118");

        IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201601));
        nyknJissekiRireki1.setRenno(21);
        nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.JPY);
        nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20170101));

        IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201601));
        nyknJissekiRireki2.setRenno(22);
        nyknJissekiRireki2.setRstuukasyu(C_Tuukasyu.USD);
        nyknJissekiRireki2.setRyosyuymd(BizDate.valueOf(20170102));
        hozenDomManager.insert(kykKihon1);

        IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf(201602));
        nyknJissekiRireki3.setRenno(21);
        nyknJissekiRireki3.setRstuukasyu(C_Tuukasyu.EUR);
        nyknJissekiRireki3.setRyosyuymd(BizDate.valueOf(20170103));
        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("11", "11807111129");

        IT_NyknJissekiRireki nyknJissekiRireki4 = kykKihon2.createNyknJissekiRireki();
        nyknJissekiRireki4.setJyutoustartym(BizDateYM.valueOf(201601));
        nyknJissekiRireki4.setRenno(21);
        nyknJissekiRireki4.setRstuukasyu(C_Tuukasyu.AUD);
        nyknJissekiRireki4.setRyosyuymd(BizDate.valueOf(20170104));

        hozenDomManager.insert(kykKihon2);
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
        NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean beanResult = hozenDomManager.getNyknJissekiRirekiRstuukasyuRyosyuymdByPK("11807111129", BizDateYM.valueOf("201612"), 21);
        Assert.assertNull(beanResult);

    }

    @Test
    @TestOrder(20)
    public void normal1() {
        NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean beanResult = hozenDomManager.getNyknJissekiRirekiRstuukasyuRyosyuymdByPK("11807111118", BizDateYM.valueOf("201601"), 21);
        Assert.assertEquals(C_Tuukasyu.JPY, beanResult.getRstuukasyu());
        Assert.assertEquals(BizDate.valueOf(20170101), beanResult.getRyosyuymd());

    }

    @Test
    @TestOrder(30)
    public void blank1() {
        NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean beanResult = hozenDomManager.getNyknJissekiRirekiRstuukasyuRyosyuymdByPK("", BizDateYM.valueOf("201608"), 21);
        Assert.assertNull(beanResult);

    }

}

