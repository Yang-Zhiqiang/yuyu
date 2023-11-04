package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataMock;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.viewsiharaisatei.ViewSiharaiSateiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setSateiSiharaiSatei(CommonViewUiBeanParam, JT_SateiSyouninRireki, JT_TtdkRireki, JT_Sk)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setSateiSiharaiSatei {

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
    public void testSetSateiSiharaiSatei_A1() {

        JT_SateiSyouninRireki sateiSyouninRireki = new JT_SateiSyouninRireki();
        JT_TtdkRireki ttdkRireki = new JT_TtdkRireki();
        JT_Sk sk = new JT_Sk();
        CommonViewUiBeanParam commonViewUiBeanParam = null;
        siSetUiBean.setSateiSiharaiSatei(commonViewUiBeanParam, sateiSyouninRireki, ttdkRireki, sk);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetSateiSiharaiSatei_A2() {

        ViewSiharaiSateiUiBeanParamImpl viewSiharaiSateiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiSateiUiBeanParamImpl.class);
        viewSiharaiSateiUiBeanParamImpl.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setTennousakisousasyacd("1001");
        viewSiharaiSateiUiBeanParamImpl.setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setSessyouyhkbn(C_YouhiblnkKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setSessyousisyacd(null);
        viewSiharaiSateiUiBeanParamImpl.setSisyanm("AAA");
        viewSiharaiSateiUiBeanParamImpl.setSinsagendokknkbn(C_SinsaGendoKknKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setRikoukityuutuudannissuu(11);
        viewSiharaiSateiUiBeanParamImpl.setSindansyoryoushryouhi(true);
        viewSiharaiSateiUiBeanParamImpl.setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setSyanaicomment("BBB");

        JT_SateiSyouninRireki sateiSyouninRireki = null;

        JT_TtdkRireki ttdkRireki = null;

        JT_Sk sk = null;

        siSetUiBean.setSateiSiharaiSatei(viewSiharaiSateiUiBeanParamImpl, sateiSyouninRireki, ttdkRireki, sk);

        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getSyorikekkakbn(), null, "処理結果区分");
        exStringEquals(viewSiharaiSateiUiBeanParamImpl.getTennousakisousasyacd(), null, "転送先操作者コード");
        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getHushrgeninkbn(), null, "不支払原因区分");
        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getSessyouyhkbn(), null, "折衝要否区分");
        exStringEquals(viewSiharaiSateiUiBeanParamImpl.getSessyousisyacd(), null, "折衝支社コード");
        exStringEquals(viewSiharaiSateiUiBeanParamImpl.getSisyanm(), "", "支社名");
        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getSinsagendokknkbn(), null, "審査限度期間区分");
        assertNull(viewSiharaiSateiUiBeanParamImpl.getRikoukityuutuudannissuu());
        exBooleanEquals(viewSiharaiSateiUiBeanParamImpl.getSindansyoryoushryouhi(),false,"診断書料支払要否");
        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getSindansyoryoushryouhikbn(), null, "診断書料支払要否区分");
        exStringEquals(viewSiharaiSateiUiBeanParamImpl.getSyanaicomment(), null, "社内用コメント");

    }

    @Test
    @TestOrder(30)
    public void testSetSateiSiharaiSatei_A3() {

        MockObjectManager.initialize();
        BzGetSosikiDataMock.SYORIPTN = "1";

        ViewSiharaiSateiUiBeanParamImpl viewSiharaiSateiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiSateiUiBeanParamImpl.class);
        viewSiharaiSateiUiBeanParamImpl.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setTennousakisousasyacd("1001");
        viewSiharaiSateiUiBeanParamImpl.setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setSessyouyhkbn(C_YouhiblnkKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setSessyousisyacd(null);
        viewSiharaiSateiUiBeanParamImpl.setSisyanm("AAA");
        viewSiharaiSateiUiBeanParamImpl.setSinsagendokknkbn(C_SinsaGendoKknKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setRikoukityuutuudannissuu(11);
        viewSiharaiSateiUiBeanParamImpl.setSindansyoryoushryouhi(true);
        viewSiharaiSateiUiBeanParamImpl.setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setSyanaicomment("BBB");

        JT_SateiSyouninRireki sateiSyouninRireki = new JT_SateiSyouninRireki();
        sateiSyouninRireki.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        sateiSyouninRireki.setTennousakisousasyacd("2001");
        sateiSyouninRireki.setHushrgeninkbn(C_HushrGeninKbn.SONOTA);
        sateiSyouninRireki.setSessyouyhkbn(C_YouhiblnkKbn.HUYOU);
        sateiSyouninRireki.setSessyousisyacd("202");

        JT_TtdkRireki ttdkRireki = new JT_TtdkRireki();

        JT_Sk sk = new JT_Sk();
        sk.setSinsagendokknkbn(C_SinsaGendoKknKbn.D180);
        sk.setRikoukityuutuudannissuu(21);
        sk.setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn.SDSSHRYH);

        siSetUiBean.setSateiSiharaiSatei(viewSiharaiSateiUiBeanParamImpl, sateiSyouninRireki, ttdkRireki, sk);

        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getSyorikekkakbn(), C_SyorikekkaKbn.TENSOU, "処理結果区分");
        exStringEquals(viewSiharaiSateiUiBeanParamImpl.getTennousakisousasyacd(), "2001", "転送先操作者コード");
        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getHushrgeninkbn(), C_HushrGeninKbn.SONOTA, "不支払原因区分");
        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getSessyouyhkbn(), C_YouhiblnkKbn.HUYOU, "折衝要否区分");
        exStringEquals(viewSiharaiSateiUiBeanParamImpl.getSessyousisyacd(), "202", "折衝支社コード");
        exStringEquals(viewSiharaiSateiUiBeanParamImpl.getSisyanm(), "", "支社名");
        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getSinsagendokknkbn(), C_SinsaGendoKknKbn.D180,
            "審査限度期間区分");
        exNumericEquals(viewSiharaiSateiUiBeanParamImpl.getRikoukityuutuudannissuu(), 21, "履行期中断日数");
        exBooleanEquals(viewSiharaiSateiUiBeanParamImpl.getSindansyoryoushryouhi(),false,"診断書料支払要否");
        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getSindansyoryoushryouhikbn(),
            C_SindansyoRyouShrYouhiKbn.SDSSHRYH, "診断書料支払要否区分");
        exStringEquals(viewSiharaiSateiUiBeanParamImpl.getSyanaicomment(), null, "社内用コメント");

        MockObjectManager.assertArgumentPassed(BzGetSosikiData.class, "exec", 0, "2020000");
        MockObjectManager.assertArgumentPassed(BzGetSosikiData.class, "exec", 1, null);

    }

    @Test
    @TestOrder(40)
    public void testSetSateiSiharaiSatei_A4() {

        MockObjectManager.initialize();
        BzGetSosikiDataMock.SYORIPTN = "2";

        ViewSiharaiSateiUiBeanParamImpl viewSiharaiSateiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiSateiUiBeanParamImpl.class);
        viewSiharaiSateiUiBeanParamImpl.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setTennousakisousasyacd("1001");
        viewSiharaiSateiUiBeanParamImpl.setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setSessyouyhkbn(C_YouhiblnkKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setSessyousisyacd(null);
        viewSiharaiSateiUiBeanParamImpl.setSisyanm("AAA");
        viewSiharaiSateiUiBeanParamImpl.setSinsagendokknkbn(C_SinsaGendoKknKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setRikoukityuutuudannissuu(11);
        viewSiharaiSateiUiBeanParamImpl.setSindansyoryoushryouhi(true);
        viewSiharaiSateiUiBeanParamImpl.setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn.BLNK);
        viewSiharaiSateiUiBeanParamImpl.setSyanaicomment("BBB");

        JT_SateiSyouninRireki sateiSyouninRireki = new JT_SateiSyouninRireki();
        sateiSyouninRireki.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        sateiSyouninRireki.setTennousakisousasyacd("2001");
        sateiSyouninRireki.setHushrgeninkbn(C_HushrGeninKbn.SONOTA);
        sateiSyouninRireki.setSessyouyhkbn(C_YouhiblnkKbn.HUYOU);
        sateiSyouninRireki.setSessyousisyacd("202");

        JT_TtdkRireki ttdkRireki = new JT_TtdkRireki();
        ttdkRireki.setSyanaicomment("CCC");

        JT_Sk sk = new JT_Sk();
        sk.setSinsagendokknkbn(C_SinsaGendoKknKbn.D180);
        sk.setRikoukityuutuudannissuu(21);
        sk.setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn.SDSSHRYH);

        siSetUiBean.setSateiSiharaiSatei(viewSiharaiSateiUiBeanParamImpl, sateiSyouninRireki, ttdkRireki, sk);

        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getSyorikekkakbn(), C_SyorikekkaKbn.TENSOU, "処理結果区分");
        exStringEquals(viewSiharaiSateiUiBeanParamImpl.getTennousakisousasyacd(), "2001", "転送先操作者コード");
        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getHushrgeninkbn(), C_HushrGeninKbn.SONOTA, "不支払原因区分");
        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getSessyouyhkbn(), C_YouhiblnkKbn.HUYOU, "折衝要否区分");
        exStringEquals(viewSiharaiSateiUiBeanParamImpl.getSessyousisyacd(), "202", "折衝支社コード");
        exStringEquals(viewSiharaiSateiUiBeanParamImpl.getSisyanm(), "DDD", "支社名");
        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getSinsagendokknkbn(), C_SinsaGendoKknKbn.D180,
            "審査限度期間区分");
        exNumericEquals(viewSiharaiSateiUiBeanParamImpl.getRikoukityuutuudannissuu(), 21, "履行期中断日数");
        exBooleanEquals(viewSiharaiSateiUiBeanParamImpl.getSindansyoryoushryouhi(),false,"診断書料支払要否");
        exClassificationEquals(viewSiharaiSateiUiBeanParamImpl.getSindansyoryoushryouhikbn(),
            C_SindansyoRyouShrYouhiKbn.SDSSHRYH, "診断書料支払要否区分");
        exStringEquals(viewSiharaiSateiUiBeanParamImpl.getSyanaicomment(), "CCC", "社内用コメント");


    }

    @Test
    @TestOrder(50)
    public void testSetSateiSiharaiSatei_A5() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        JT_SateiSyouninRireki sateiSyouninRireki = new JT_SateiSyouninRireki();
        sateiSyouninRireki.setSkno("2001");

        JT_TtdkRireki ttdkRireki = new JT_TtdkRireki();
        ttdkRireki.setSkno("2002");

        JT_Sk sk = new JT_Sk();
        sk.setSkno("2003");

        siSetUiBean.setSateiSiharaiSatei(viewSkKihonUiBeanParamImpl, sateiSyouninRireki, ttdkRireki, sk);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

    }

}
