package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataMock;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.ViewSiharaiSateiShrRirekiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_Sk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setSateiSiharaiSateiShrRireki(CommonViewUiBeanParam, JT_SateiSyouninRireki, JT_Sk)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setSateiSiharaiSateiShrRireki {

    @Inject
    private SiSetUiBean siSetUiBean;

    @BeforeClass
    public static void testInit() {

        BzGetSosikiDataMock.caller = SiSetUiBeanTest_setSateiSiharaiSatei.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetSosikiDataMock.caller = null;
        BzGetSosikiDataMock.SYORIPTN= null;
    }

    @Test
    @TestOrder(10)
    public void testSetSateiSiharaiSateiShrRireki_A1() {

        CommonViewUiBeanParam commonViewUiBeanParam = null;
        JT_SateiSyouninRireki sateiSyouninRireki = new JT_SateiSyouninRireki();
        JT_Sk sk = new JT_Sk();
        siSetUiBean.setSateiSiharaiSateiShrRireki(commonViewUiBeanParam, sateiSyouninRireki, sk);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetSateiSiharaiSateiShrRireki_A2() {

        ViewSiharaiSateiShrRirekiUiBeanParamImpl viewSiharaiSateiShrRirekiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiSateiShrRirekiUiBeanParamImpl.class);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSessyouyhkbn(C_YouhiblnkKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSessyousisyacd(null);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSisyanm("AAA");
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSinsagendokknkbn(C_SinsaGendoKknKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setRikoukityuutuudannissuu(11);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setKaiketuymd(BizDate.valueOf(20160301));

        JT_SateiSyouninRireki sateiSyouninRireki = null;

        JT_Sk sk = null;

        siSetUiBean.setSateiSiharaiSateiShrRireki(viewSiharaiSateiShrRirekiUiBeanParamImpl, sateiSyouninRireki, sk);

        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSyorikekkakbn(), null, "処理結果区分");
        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getHushrgeninkbn(), null, "不支払原因区分");
        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSessyouyhkbn(), null, "折衝要否区分");
        exStringEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSessyousisyacd(), null, "折衝支社コード");
        exStringEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSisyanm(), "", "支社名");
        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSinsagendokknkbn(), null, "審査限度期間区分");
        assertNull(viewSiharaiSateiShrRirekiUiBeanParamImpl.getRikoukityuutuudannissuu());
        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSindansyoryoushryouhikbn(), null,
            "診断書料支払要否区分");
        exDateEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getKaiketuymd(), null, "解決日");

    }

    @Test
    @TestOrder(30)
    public void testSetSateiSiharaiSateiShrRireki_A3() {

        MockObjectManager.initialize();
        BzGetSosikiDataMock.SYORIPTN = "1";

        ViewSiharaiSateiShrRirekiUiBeanParamImpl viewSiharaiSateiShrRirekiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiSateiShrRirekiUiBeanParamImpl.class);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSessyouyhkbn(C_YouhiblnkKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSessyousisyacd(null);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSisyanm("AAA");
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSinsagendokknkbn(C_SinsaGendoKknKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setRikoukityuutuudannissuu(11);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setKaiketuymd(BizDate.valueOf(20160301));

        JT_SateiSyouninRireki sateiSyouninRireki = new JT_SateiSyouninRireki();
        sateiSyouninRireki.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        sateiSyouninRireki.setHushrgeninkbn(C_HushrGeninKbn.SONOTA);
        sateiSyouninRireki.setSessyouyhkbn(C_YouhiblnkKbn.HUYOU);
        sateiSyouninRireki.setSessyousisyacd("202");
        sateiSyouninRireki.setKaiketuymd(BizDate.valueOf(20150301));

        JT_Sk sk = new JT_Sk();
        sk.setSinsagendokknkbn(C_SinsaGendoKknKbn.D180);
        sk.setRikoukityuutuudannissuu(21);
        sk.setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn.SDSSHRYH);

        siSetUiBean.setSateiSiharaiSateiShrRireki(viewSiharaiSateiShrRirekiUiBeanParamImpl, sateiSyouninRireki, sk);

        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSyorikekkakbn(), C_SyorikekkaKbn.TENSOU,
            "処理結果区分");
        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getHushrgeninkbn(), C_HushrGeninKbn.SONOTA,
            "不支払原因区分");
        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSessyouyhkbn(), C_YouhiblnkKbn.HUYOU,
            "折衝要否区分");
        exStringEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSessyousisyacd(), "202", "折衝支社コード");
        exStringEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSisyanm(), "", "支社名");
        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSinsagendokknkbn(), C_SinsaGendoKknKbn.D180,
            "審査限度期間区分");
        exNumericEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getRikoukityuutuudannissuu(), 21, "履行期中断日数");
        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSindansyoryoushryouhikbn(),
            C_SindansyoRyouShrYouhiKbn.SDSSHRYH,
            "診断書料支払要否区分");
        exDateEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getKaiketuymd(), BizDate.valueOf(20150301), "解決日");

        MockObjectManager.assertArgumentPassed(BzGetSosikiData.class, "exec", 0, "2020000");
        MockObjectManager.assertArgumentPassed(BzGetSosikiData.class, "exec", 1, null);

    }

    @Test
    @TestOrder(40)
    public void testSetSateiSiharaiSateiShrRireki_A4() {

        MockObjectManager.initialize();
        BzGetSosikiDataMock.SYORIPTN = "2";

        ViewSiharaiSateiShrRirekiUiBeanParamImpl viewSiharaiSateiShrRirekiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiSateiShrRirekiUiBeanParamImpl.class);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSessyouyhkbn(C_YouhiblnkKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSessyousisyacd(null);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSisyanm("AAA");
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSinsagendokknkbn(C_SinsaGendoKknKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setRikoukityuutuudannissuu(11);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn.BLNK);
        viewSiharaiSateiShrRirekiUiBeanParamImpl.setKaiketuymd(BizDate.valueOf(20160301));

        JT_SateiSyouninRireki sateiSyouninRireki = new JT_SateiSyouninRireki();
        sateiSyouninRireki.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        sateiSyouninRireki.setHushrgeninkbn(C_HushrGeninKbn.SONOTA);
        sateiSyouninRireki.setSessyouyhkbn(C_YouhiblnkKbn.HUYOU);
        sateiSyouninRireki.setSessyousisyacd("202");
        sateiSyouninRireki.setKaiketuymd(BizDate.valueOf(20150301));

        JT_Sk sk = new JT_Sk();
        sk.setSinsagendokknkbn(C_SinsaGendoKknKbn.D180);
        sk.setRikoukityuutuudannissuu(21);
        sk.setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn.SDSSHRYH);

        siSetUiBean.setSateiSiharaiSateiShrRireki(viewSiharaiSateiShrRirekiUiBeanParamImpl, sateiSyouninRireki, sk);

        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSyorikekkakbn(), C_SyorikekkaKbn.TENSOU,
            "処理結果区分");
        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getHushrgeninkbn(), C_HushrGeninKbn.SONOTA,
            "不支払原因区分");
        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSessyouyhkbn(), C_YouhiblnkKbn.HUYOU,
            "折衝要否区分");
        exStringEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSessyousisyacd(), "202", "折衝支社コード");
        exStringEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSisyanm(), "DDD", "支社名");
        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSinsagendokknkbn(), C_SinsaGendoKknKbn.D180,
            "審査限度期間区分");
        exNumericEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getRikoukityuutuudannissuu(), 21, "履行期中断日数");
        exClassificationEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getSindansyoryoushryouhikbn(),
            C_SindansyoRyouShrYouhiKbn.SDSSHRYH,
            "診断書料支払要否区分");
        exDateEquals(viewSiharaiSateiShrRirekiUiBeanParamImpl.getKaiketuymd(), BizDate.valueOf(20150301), "解決日");

    }

    @Test
    @TestOrder(50)
    public void testSetSateiSiharaiSateiShrRireki_A5() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        JT_SiRireki siRireki = new JT_SiRireki();
        siRireki.setSkno("2001");
        JT_Sk sk = new JT_Sk();
        sk.setSkno("2003");

        SiSetUiBean.setZeimu(viewSkKihonUiBeanParamImpl, siRireki, sk);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

    }

}
