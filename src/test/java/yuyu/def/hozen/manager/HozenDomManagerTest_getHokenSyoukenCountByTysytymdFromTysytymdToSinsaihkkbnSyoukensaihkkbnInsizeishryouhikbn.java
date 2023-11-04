package yuyu.def.hozen.manager;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 証券印紙税リスト作成<br />
 * 保険証券テーブル件数取得（抽出日(自）、抽出日(至）、新規再発行区分、証券再発行区分、印紙税支払要否区分）<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbnInsizeishryouhikbn {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        assertEquals(0, hozenDomManager.getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbnInsizeishryouhikbn(
                BizDate.valueOf("20160101"), BizDate.valueOf("20160109"), C_SinsaihkKbn.SIN,
                C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, C_InsizeiShryouhiKbn.HUYOU).intValue());

        IT_KykKihon iT_KykKihon = new IT_KykKihon("11807111118");

        IT_HokenSyouken hokenSyouken1 = iT_KykKihon.createHokenSyouken();
        hokenSyouken1.setTyouhyouymd(BizDate.valueOf("20160103"));
        hokenSyouken1.setSinsaihkkbn(C_SinsaihkKbn.BLNK);
        hokenSyouken1.setSyoukensaihkkbn(C_SyoukensaihkKbn.BLNK);
        hokenSyouken1.setInsizeishryouhikbn(C_InsizeiShryouhiKbn.YOU);

        IT_HokenSyouken hokenSyouken2 = iT_KykKihon.createHokenSyouken();
        hokenSyouken2.setTyouhyouymd(BizDate.valueOf("20160104"));
        hokenSyouken2.setSinsaihkkbn(C_SinsaihkKbn.BLNK);
        hokenSyouken2.setSyoukensaihkkbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        hokenSyouken2.setInsizeishryouhikbn(C_InsizeiShryouhiKbn.HUYOU);

        IT_HokenSyouken hokenSyouken3 = iT_KykKihon.createHokenSyouken();
        hokenSyouken3.setTyouhyouymd(BizDate.valueOf("20160105"));
        hokenSyouken3.setSinsaihkkbn(C_SinsaihkKbn.SIN);
        hokenSyouken3.setSyoukensaihkkbn(C_SyoukensaihkKbn.BLNK);
        hokenSyouken3.setInsizeishryouhikbn(C_InsizeiShryouhiKbn.HUYOU);

        IT_HokenSyouken hokenSyouken4 = iT_KykKihon.createHokenSyouken();
        hokenSyouken4.setTyouhyouymd(BizDate.valueOf("20160106"));
        hokenSyouken4.setSinsaihkkbn(C_SinsaihkKbn.SIN);
        hokenSyouken4.setSyoukensaihkkbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        hokenSyouken4.setInsizeishryouhikbn(C_InsizeiShryouhiKbn.YOU);

        IT_HokenSyouken hokenSyouken5 = iT_KykKihon.createHokenSyouken();
        hokenSyouken5.setTyouhyouymd(BizDate.valueOf("20160101"));
        hokenSyouken5.setSinsaihkkbn(C_SinsaihkKbn.SIN);
        hokenSyouken5.setSyoukensaihkkbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        hokenSyouken5.setInsizeishryouhikbn(C_InsizeiShryouhiKbn.HUYOU);

        IT_HokenSyouken hokenSyouken6 = iT_KykKihon.createHokenSyouken();
        hokenSyouken6.setTyouhyouymd(BizDate.valueOf("20160109"));
        hokenSyouken6.setSinsaihkkbn(C_SinsaihkKbn.SIN);
        hokenSyouken6.setSyoukensaihkkbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        hokenSyouken6.setInsizeishryouhikbn(C_InsizeiShryouhiKbn.HUYOU);

        IT_HokenSyouken hokenSyouken7 = iT_KykKihon.createHokenSyouken();
        hokenSyouken7.setTyouhyouymd(BizDate.valueOf("20160102"));
        hokenSyouken7.setSinsaihkkbn(C_SinsaihkKbn.SIN);
        hokenSyouken7.setSyoukensaihkkbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        hokenSyouken7.setInsizeishryouhikbn(C_InsizeiShryouhiKbn.HUYOU);

        IT_HokenSyouken hokenSyouken8 = iT_KykKihon.createHokenSyouken();
        hokenSyouken8.setTyouhyouymd(BizDate.valueOf("20160108"));
        hokenSyouken8.setSinsaihkkbn(C_SinsaihkKbn.SIN);
        hokenSyouken8.setSyoukensaihkkbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        hokenSyouken8.setInsizeishryouhikbn(C_InsizeiShryouhiKbn.HUYOU);

        IT_HokenSyouken hokenSyouken9 = iT_KykKihon.createHokenSyouken();
        hokenSyouken9.setTyouhyouymd(BizDate.valueOf("20151231"));
        hokenSyouken9.setSinsaihkkbn(C_SinsaihkKbn.SIN);
        hokenSyouken9.setSyoukensaihkkbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        hokenSyouken9.setInsizeishryouhikbn(C_InsizeiShryouhiKbn.HUYOU);

        IT_HokenSyouken hokenSyouken10 = iT_KykKihon.createHokenSyouken();
        hokenSyouken10.setTyouhyouymd(BizDate.valueOf("20160110"));
        hokenSyouken10.setSinsaihkkbn(C_SinsaihkKbn.SIN);
        hokenSyouken10.setSyoukensaihkkbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        hokenSyouken10.setInsizeishryouhikbn(C_InsizeiShryouhiKbn.HUYOU);

        hozenDomManager.insert(iT_KykKihon);
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

        assertEquals(0, hozenDomManager.getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbnInsizeishryouhikbn(
                BizDate.valueOf("20160310"), BizDate.valueOf("20160410"), C_SinsaihkKbn.BLNK,
                C_SyoukensaihkKbn.BLNK, C_InsizeiShryouhiKbn.YOU).intValue());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        assertEquals(4, hozenDomManager.getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbnInsizeishryouhikbn(
                BizDate.valueOf("20160101"), BizDate.valueOf("20160109"), C_SinsaihkKbn.SIN,
                C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, C_InsizeiShryouhiKbn.HUYOU).intValue());
    }
}
