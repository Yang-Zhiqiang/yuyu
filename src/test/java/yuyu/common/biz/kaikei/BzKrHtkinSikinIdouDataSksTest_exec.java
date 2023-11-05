package yuyu.common.biz.kaikei;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BW_HtkinSikinIdouWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通 経理・会計 経理配当金資金移動データ作成のメソッド {@link BzKrHtkinSikinIdouDataSks#exec()}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzKrHtkinSikinIdouDataSksTest_exec {

    @Inject
    private BzKrHtkinSikinIdouDataSks bzKrHtkinSikinIdouDataSks;

    @BeforeClass
    @Transactional
    @AfterClass
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllIdCards());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        HtkinSikinIdouDataBean htkinSikinIdouDataBean = SWAKInjector.getInstance(HtkinSikinIdouDataBean.class);

        BW_HtkinSikinIdouWk htkinsikinidouwk = new BW_HtkinSikinIdouWk();

        htkinSikinIdouDataBean.setSyono("11807130766");
        htkinSikinIdouDataBean.setKijyunymd(BizDate.valueOf(20190331));
        htkinSikinIdouDataBean.setKakutyoujobcd("RGHJM001");
        htkinSikinIdouDataBean.setKyktuukasyu(C_Tuukasyu.USD);
        htkinSikinIdouDataBean.setGonenmeoutoubikbn("1");
        htkinSikinIdouDataBean.setYuukoutyuusyoyougaku(BizCurrency.valueOf(12345678));
        htkinSikinIdouDataBean.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        htkinSikinIdouDataBean.setKawaserate(BizNumber.valueOf(123.4567));

        htkinsikinidouwk = bzKrHtkinSikinIdouDataSks.exec(htkinSikinIdouDataBean);

        exStringEquals(htkinsikinidouwk.getSyono(), "11807130766", "証券番号");
        exDateEquals(htkinsikinidouwk.getKijyunymd(), BizDate.valueOf(20190331), "基準年月日");
        exDateYEquals(htkinsikinidouwk.getHaitounendo(), BizDateY.valueOf(2019), "配当年度");
        exClassificationEquals(htkinsikinidouwk.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(htkinsikinidouwk.getSeisikiwariategaku(), BizCurrency.valueOf(12345678), "正式割当額");
        exClassificationEquals(htkinsikinidouwk.getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exBizCalcbleEquals(htkinsikinidouwk.getSikinidoukawaserate(), BizNumber.valueOf(123.4567), "資金移動用為替レート");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        HtkinSikinIdouDataBean htkinSikinIdouDataBean = SWAKInjector.getInstance(HtkinSikinIdouDataBean.class);

        BW_HtkinSikinIdouWk htkinsikinidouwk = new BW_HtkinSikinIdouWk();

        htkinSikinIdouDataBean.setSyono("11807130766");
        htkinSikinIdouDataBean.setKijyunymd(BizDate.valueOf(20190330));
        htkinSikinIdouDataBean.setKakutyoujobcd("RGHJM004");
        htkinSikinIdouDataBean.setKyktuukasyu(C_Tuukasyu.USD);
        htkinSikinIdouDataBean.setGonenmeoutoubikbn("1");
        htkinSikinIdouDataBean.setYuukoutyuusyoyougaku(BizCurrency.valueOf(12345678));
        htkinSikinIdouDataBean.setSeg1cd(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        htkinSikinIdouDataBean.setKawaserate(BizNumber.valueOf(123.4567));

        htkinsikinidouwk = bzKrHtkinSikinIdouDataSks.exec(htkinSikinIdouDataBean);

        assertNull(htkinsikinidouwk);
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        HtkinSikinIdouDataBean htkinSikinIdouDataBean = SWAKInjector.getInstance(HtkinSikinIdouDataBean.class);

        BW_HtkinSikinIdouWk htkinsikinidouwk = new BW_HtkinSikinIdouWk();

        htkinSikinIdouDataBean.setSyono("11807130766");
        htkinSikinIdouDataBean.setKijyunymd(BizDate.valueOf(20190331));
        htkinSikinIdouDataBean.setKakutyoujobcd("qwerty");
        htkinSikinIdouDataBean.setKyktuukasyu(C_Tuukasyu.USD);
        htkinSikinIdouDataBean.setGonenmeoutoubikbn("1");
        htkinSikinIdouDataBean.setYuukoutyuusyoyougaku(BizCurrency.valueOf(12345678));
        htkinSikinIdouDataBean.setSeg1cd(C_Segcd.USDKOJINNENKINHIJYNBRJYUNYUUHAI);
        htkinSikinIdouDataBean.setKawaserate(BizNumber.valueOf(123.4567));

        htkinsikinidouwk = bzKrHtkinSikinIdouDataSks.exec(htkinSikinIdouDataBean);

        assertNull(htkinsikinidouwk);
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        HtkinSikinIdouDataBean htkinSikinIdouDataBean = SWAKInjector.getInstance(HtkinSikinIdouDataBean.class);

        BW_HtkinSikinIdouWk htkinsikinidouwk = new BW_HtkinSikinIdouWk();

        htkinSikinIdouDataBean.setSyono("11807130766");
        htkinSikinIdouDataBean.setKijyunymd(BizDate.valueOf(20190331));
        htkinSikinIdouDataBean.setKakutyoujobcd("RGHJM001");
        htkinSikinIdouDataBean.setKyktuukasyu(C_Tuukasyu.JPY);
        htkinSikinIdouDataBean.setGonenmeoutoubikbn("1");
        htkinSikinIdouDataBean.setYuukoutyuusyoyougaku(BizCurrency.valueOf(12345678));
        htkinSikinIdouDataBean.setSeg1cd(C_Segcd.JPYSYUUSIN);
        htkinSikinIdouDataBean.setKawaserate(BizNumber.valueOf(123.4567));

        htkinsikinidouwk = bzKrHtkinSikinIdouDataSks.exec(htkinSikinIdouDataBean);

        assertNull(htkinsikinidouwk);
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        HtkinSikinIdouDataBean htkinSikinIdouDataBean = SWAKInjector.getInstance(HtkinSikinIdouDataBean.class);

        BW_HtkinSikinIdouWk htkinsikinidouwk = new BW_HtkinSikinIdouWk();

        htkinSikinIdouDataBean.setSyono("11807130766");
        htkinSikinIdouDataBean.setKijyunymd(BizDate.valueOf(20190331));
        htkinSikinIdouDataBean.setKakutyoujobcd("RGHJM004");
        htkinSikinIdouDataBean.setKyktuukasyu(C_Tuukasyu.BLNK);
        htkinSikinIdouDataBean.setGonenmeoutoubikbn("1");
        htkinSikinIdouDataBean.setYuukoutyuusyoyougaku(BizCurrency.valueOf(12345678));
        htkinSikinIdouDataBean.setSeg1cd(C_Segcd.BLNK);
        htkinSikinIdouDataBean.setKawaserate(BizNumber.valueOf(123.4567));

        htkinsikinidouwk = bzKrHtkinSikinIdouDataSks.exec(htkinSikinIdouDataBean);

        assertNull(htkinsikinidouwk);
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        HtkinSikinIdouDataBean htkinSikinIdouDataBean = SWAKInjector.getInstance(HtkinSikinIdouDataBean.class);

        BW_HtkinSikinIdouWk htkinsikinidouwk = new BW_HtkinSikinIdouWk();

        htkinSikinIdouDataBean.setSyono("11807130766");
        htkinSikinIdouDataBean.setKijyunymd(BizDate.valueOf(20190331));
        htkinSikinIdouDataBean.setKakutyoujobcd("RGHJM001");
        htkinSikinIdouDataBean.setKyktuukasyu(C_Tuukasyu.USD);
        htkinSikinIdouDataBean.setGonenmeoutoubikbn("2");
        htkinSikinIdouDataBean.setYuukoutyuusyoyougaku(BizCurrency.valueOf(12345678));
        htkinSikinIdouDataBean.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAI19JYUNYUUHAI);
        htkinSikinIdouDataBean.setKawaserate(BizNumber.valueOf(123.4567));

        htkinsikinidouwk = bzKrHtkinSikinIdouDataSks.exec(htkinSikinIdouDataBean);

        assertNull(htkinsikinidouwk);
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        HtkinSikinIdouDataBean htkinSikinIdouDataBean = SWAKInjector.getInstance(HtkinSikinIdouDataBean.class);

        BW_HtkinSikinIdouWk htkinsikinidouwk = new BW_HtkinSikinIdouWk();

        htkinSikinIdouDataBean.setSyono("11807130766");
        htkinSikinIdouDataBean.setKijyunymd(BizDate.valueOf(20190331));
        htkinSikinIdouDataBean.setKakutyoujobcd("RGHJM004");
        htkinSikinIdouDataBean.setKyktuukasyu(C_Tuukasyu.USD);
        htkinSikinIdouDataBean.setGonenmeoutoubikbn("1");
        htkinSikinIdouDataBean.setYuukoutyuusyoyougaku(BizCurrency.valueOf(-1234));
        htkinSikinIdouDataBean.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        htkinSikinIdouDataBean.setKawaserate(BizNumber.valueOf(123.4567));

        htkinsikinidouwk = bzKrHtkinSikinIdouDataSks.exec(htkinSikinIdouDataBean);

        assertNull(htkinsikinidouwk);
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        HtkinSikinIdouDataBean htkinSikinIdouDataBean = SWAKInjector.getInstance(HtkinSikinIdouDataBean.class);

        BW_HtkinSikinIdouWk htkinsikinidouwk = new BW_HtkinSikinIdouWk();

        htkinSikinIdouDataBean.setSyono("11807130766");
        htkinSikinIdouDataBean.setKijyunymd(BizDate.valueOf(20190331));
        htkinSikinIdouDataBean.setKakutyoujobcd("RGHJM001");
        htkinSikinIdouDataBean.setKyktuukasyu(C_Tuukasyu.USD);
        htkinSikinIdouDataBean.setGonenmeoutoubikbn("1");
        htkinSikinIdouDataBean.setYuukoutyuusyoyougaku(BizCurrency.valueOf(0));
        htkinSikinIdouDataBean.setSeg1cd(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        htkinSikinIdouDataBean.setKawaserate(BizNumber.valueOf(123.4567));

        htkinsikinidouwk = bzKrHtkinSikinIdouDataSks.exec(htkinSikinIdouDataBean);

        assertNull(htkinsikinidouwk);
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        HtkinSikinIdouDataBean htkinSikinIdouDataBean = SWAKInjector.getInstance(HtkinSikinIdouDataBean.class);

        BW_HtkinSikinIdouWk htkinsikinidouwk = new BW_HtkinSikinIdouWk();

        htkinSikinIdouDataBean.setSyono("11807130766");
        htkinSikinIdouDataBean.setKijyunymd(BizDate.valueOf(20190330));
        htkinSikinIdouDataBean.setKakutyoujobcd("qwerty");
        htkinSikinIdouDataBean.setKyktuukasyu(C_Tuukasyu.BLNK);
        htkinSikinIdouDataBean.setGonenmeoutoubikbn("2");
        htkinSikinIdouDataBean.setYuukoutyuusyoyougaku(BizCurrency.valueOf(-1234));
        htkinSikinIdouDataBean.setSeg1cd(C_Segcd.BLNK);
        htkinSikinIdouDataBean.setKawaserate(BizNumber.valueOf(123.4567));

        htkinsikinidouwk = bzKrHtkinSikinIdouDataSks.exec(htkinSikinIdouDataBean);

        assertNull(htkinsikinidouwk);
    }
}