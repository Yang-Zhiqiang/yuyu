package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.dao.IT_KhTtdkRirekiDao;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.result.bean.HoyuuKhTtdkRirekiByPkBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 保有明細情報作成<br />
 * 保有契約商品情報Beanリスト取得　証券番号 主契約特約区分のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getHoyuuKhTtdkRirekiByPk {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111152";

    static String P_HENKOUSIKIBETUKEY_01 = "KEY00001";
    static String P_HENKOUSIKIBETUKEY_02 = "KEY00002";

    static BizDate P_SYOUMETUYMD_01 = BizDate.valueOf(20160320);
    static BizDate P_SYOUMETUYMD_02 = BizDate.valueOf(20160321);

    @BeforeClass
    @Transactional
    public static void preProcess() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhTtdkRirekiDao iT_KhTtdkRirekiDao = SWAKInjector.getInstance(IT_KhTtdkRirekiDao.class);
        HoyuuKhTtdkRirekiByPkBean bean = iT_KhTtdkRirekiDao.getHoyuuKhTtdkRirekiByPk(P_SYONO_01, P_HENKOUSIKIBETUKEY_01);
        Assert.assertNull(bean);


        IT_KykKihon iT_KykKihon1 = new IT_KykKihon(P_SYONO_01);
        IT_KhTtdkRireki rireki1 = iT_KykKihon1.createKhTtdkRireki();
        rireki1.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);
        rireki1.setSyoriYmd(P_SYOUMETUYMD_01);

        hozenDomManager.insert(iT_KykKihon1);


        IT_KykKihon iT_KykKihon2 = new IT_KykKihon(P_SYONO_02);
        IT_KhTtdkRireki rireki21 = iT_KykKihon2.createKhTtdkRireki();
        rireki21.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);
        rireki21.setSyoriYmd(P_SYOUMETUYMD_01);

        IT_KhTtdkRireki rireki122 = iT_KykKihon2.createKhTtdkRireki();
        rireki122.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_02);
        rireki122.setSyoriYmd(P_SYOUMETUYMD_02);

        hozenDomManager.insert(iT_KykKihon2);
    }


    @AfterClass
    @Transactional
    public static void deleteTestData(){
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        HoyuuKhTtdkRirekiByPkBean bean = hozenDomManager.getHoyuuKhTtdkRirekiByPk(P_SYONO_01, P_HENKOUSIKIBETUKEY_02);
        Assert.assertNull(bean);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HoyuuKhTtdkRirekiByPkBean bean = hozenDomManager.getHoyuuKhTtdkRirekiByPk(P_SYONO_01, P_HENKOUSIKIBETUKEY_01);
        Assert.assertEquals(P_SYOUMETUYMD_01, bean.getSyoriymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        HoyuuKhTtdkRirekiByPkBean bean = hozenDomManager.getHoyuuKhTtdkRirekiByPk(P_SYONO_02, P_HENKOUSIKIBETUKEY_02);
        Assert.assertEquals(P_SYOUMETUYMD_02, bean.getSyoriymd());
    }

    @Test
    @TestOrder(40)
    public void blank1() {
        HoyuuKhTtdkRirekiByPkBean bean = hozenDomManager.getHoyuuKhTtdkRirekiByPk("", P_HENKOUSIKIBETUKEY_02);
        Assert.assertNull(bean);

    }
    @Test
    @TestOrder(50)
    public void blank2() {
        HoyuuKhTtdkRirekiByPkBean bean = hozenDomManager.getHoyuuKhTtdkRirekiByPk(P_SYONO_02, "");
        Assert.assertNull(bean);

    }
    @Test
    @TestOrder(60)
    public void blank3() {
        HoyuuKhTtdkRirekiByPkBean bean = hozenDomManager.getHoyuuKhTtdkRirekiByPk("", "");
        Assert.assertNull(bean);

    }
}
