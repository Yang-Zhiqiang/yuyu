package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KoujyosyoumeisakuseisyoriKbn;
import yuyu.def.classification.C_KoujyosyoumeisyuKbn;
import yuyu.def.classification.C_KykhnkKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SinsakuseiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_TuutisakuseitaisyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YykidouuktkKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.bean.report.SiEditEnkaryuuiBean;
import yuyu.infr.auth.RayHttpHeaderBean;
import yuyu.infr.auth.RayHttpHeaderBeanMockForHozen;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 契約保全帳票TBL編集コントロールクラスのメソッド {@link KhozenTyouhyouCtl#createTyouhyouTBL(KhozenCommonParam, String, C_SyoruiCdKbn[], C_YouhiKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KhozenTyouhyouCtlTest_createTyouhyouTBL extends AbstractTest {

    private final static String syoNo1 = "10806000016";

    private final static String syoNo2 = "10806000027";

    private final static String syoNo4 = "10806000049";

    private final static String syoNo5 = "10806000050";

    private final static String syoNo7 = "17806000507";

    private final static String syoNo8 = "17806000264";

    private final static String syoNo9 = "11807111255";

    private final static String syoNo10 = "17806000297";

    private final static String syoNo11 = "17806000046";

    private final static String syoNo2_1 = "20806000019";

    private final static String syoNo2_2 = "17806000172";

    private final static String syoNo16_1 = "16806000012";

    private final static String syoNo17_1 = "17806000013";

    private final static String syoNo18_1 = "18806000014";

    private final static String syoNo19_1 = "17806000208";

    private final static String syoNo20_1 = "17806000471";

    private final static String syoNo1_24 = "11807111118";

    private final static String syoNo1_13 = "17806000286";

    private final static String syoNo1_14 = "17806000220";

    private final static String syoNo1_15 = "11807111451";

    private final static String syoNo1_16 = "99806001010";

    private final static String syoNo1_17 = "99806001021";

    private final static String syoNo1_18 = "99806001032";

    private final static String syoNo1_19 = "17806000301";

    private final static String syoNo1_20 = "17806000275";

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditTtdkKanryouParam editTtdkKanryouParam;

    @Inject
    private EditSeikyuusyoParam editSeikyuusyoParam;

    @Inject
    private EditSouhuannaiParam editSouhuannaiParam;

    @Inject
    private EditKoujyoSyoumeiParam editKoujyoSyoumeiParam;

    @Inject
    private EditJimuRenrakuhyouParam editJimuRenrakuhyouParam;

    @Inject
    private EditKhMisslstParam editKhMisslstParam;

    @Inject
    private CreateReport createReport;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    BaseUserInfo baseUserInfo;

    private final static String fileName = "UT_SP_単体テスト仕様書_契約保全帳票TBL編集コントロール";
    private final static String sheetName = "テストデータ_20170728";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(EditTtdkKanryouTbl.class).to(EditTtdkKanryouTblMockForHozen.class);
                bind(EditSeikyuusyoTbl.class).to(EditSeikyuusyoTblMockForHozen.class);
                bind(EditSyoukenTbl.class).to(EditSyoukenTblMockForHozen.class);
                bind(EditKoujyoSyoumeiTbl.class).to(EditKoujyoSyoumeiTblMockForHozen.class);
                bind(RayHttpHeaderBean.class).to(RayHttpHeaderBeanMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){

        EditTtdkKanryouTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;
        EditTtdkKanryouTblMockForHozen.SYORIPTN = null;
        EditKoujyoSyoumeiTblMockForHozen.SYORIPTN = null;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        EditTtdkKanryouTblMockForHozen.caller = null;
        EditSeikyuusyoTblMockForHozen.caller = null;
        EditSyoukenTblMockForHozen.caller = null;
        EditKoujyoSyoumeiTblMockForHozen.caller = null;
        RayHttpHeaderBeanMockForHozen.caller = null;

        EditTtdkKanryouTblMockForHozen.SYORIPTN = null;
        EditKoujyoSyoumeiTblMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from AT_TyouhyouHozon ";
        em.createJPQL(jpql2).executeUpdate();
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(KhozenTyouhyouCtlTest_createTyouhyouTBL.class, fileName,
                sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        bizDomManager.delete(bizDomManager.getChannel(C_Channelcd.SONOTAMADOHAN));
        bizDomManager.delete(bizDomManager.getAllTyouhyourenrakusaki());
        hozenDomManager.delete(hozenDomManager.getAllKhTyouhyoumsg());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testCreateTyouhyouTBL_A1() {

        MockObjectManager.initialize();
        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_SYOSAIHK_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000001");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        hozenDomManager.getKykKihon(syoNo1).getTtdkKans().remove(
            hozenDomManager.getKykKihon(syoNo1).getTtdkKanByHenkousikibetukey("00000000001"));

        IT_KykKihon kykKihon = (IT_KykKihon) MockObjectManager.getArgument(EditTtdkKanryouTblMockForHozen.class, "editTBL", 0, 1);

        exStringEquals(kykKihon.getSyono(), "10806000016", "証券番号");

        List<IT_KykSyouhn> kykSyouhnLst = (List<IT_KykSyouhn>) MockObjectManager.getArgument(EditTtdkKanryouTblMockForHozen.class, "editTBL", 0, 2);

        exNumericEquals(kykSyouhnLst.size(), 1, "件数");
        exStringEquals(kykSyouhnLst.get(0).getSyono(), "10806000016", "証券番号");
        exClassificationEquals(kykSyouhnLst.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(kykSyouhnLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(kykSyouhnLst.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnLst.get(0).getKyksyouhnrenno(), 1, "契約商品連番");

        IT_KykSya kykSya = (IT_KykSya) MockObjectManager.getArgument(EditTtdkKanryouTblMockForHozen.class, "editTBL", 0, 3);

        exStringEquals(kykSya.getSyono(), "10806000016", "証券番号");

        IT_HhknSya hhknSya = (IT_HhknSya) MockObjectManager.getArgument(EditTtdkKanryouTblMockForHozen.class, "editTBL", 0, 4);

        exStringEquals(hhknSya.getSyono(), "10806000016", "証券番号");

        EditTtdkKanryouParam editTtdkKanryouParam1 = (EditTtdkKanryouParam) MockObjectManager.getArgument(EditTtdkKanryouTblMockForHozen.class, "editTBL", 0, 5);

        exClassificationEquals(editTtdkKanryouParam1.getTetudukiSyu(), C_TetudukisyuKbn.HRIHEN, "手続種類区分");
        exClassificationEquals(editTtdkKanryouParam1.getSiharaiUmu(), C_UmuKbn.NONE, "支払有無");
        exClassificationEquals(editTtdkKanryouParam1.getKaiyakuJiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(editTtdkKanryouParam1.getYykidouuktk(), C_YykidouuktkKbn.TAISYOU, "予約異動受付区分");
        exClassificationEquals(editTtdkKanryouParam1.getHrkkaisuuhnkumu(), C_UmuKbn.ARI, "払込回数変更有無区分");
        exClassificationEquals(editTtdkKanryouParam1.getHrkkeirohnkumu(), C_UmuKbn.ARI, "払込経路変更有無区分");

        MockObjectManager.assertArgumentPassed(EditTtdkKanryouTblMockForHozen.class, "editTBL", 6, null);

        MockObjectManager.assertArgumentPassed(EditTtdkKanryouTblMockForHozen.class, "editTBL", 7, null);

        IT_KykSonotaTkyk kykSonotaTkyk = (IT_KykSonotaTkyk) MockObjectManager.getArgument(EditTtdkKanryouTblMockForHozen.class, "editTBL", 0, 8);

        exStringEquals(kykSonotaTkyk.getSyono(), "10806000016", "証券番号");

        exDateEquals((BizDate) MockObjectManager.getArgument(EditTtdkKanryouTblMockForHozen.class, "editTBL", 0, 9),
            BizDate.valueOf(20160331), "処理日");

        exClassificationEquals((C_HassouKbn) MockObjectManager.getArgument(EditTtdkKanryouTblMockForHozen.class, "editTBL", 0, 10),
            null, "発送区分");

        exClassificationEquals((C_SyoruiCdKbn) MockObjectManager.getArgument(EditTtdkKanryouTblMockForHozen.class, "editTBL", 0, 11),
            C_SyoruiCdKbn.KK_SYOSAIHK_TTDKKR, "書類コード");
    }

    @Test
    @Transactional
    @TestOrder(11)
    public void testCreateTyouhyouTBL_A15() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000001");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");

        hozenDomManager.getKykKihon(syoNo1).getTtdkKans().remove(
            hozenDomManager.getKykKihon(syoNo1).getTtdkKanByHenkousikibetukey("00000000001"));
    }

    @Test
    @Transactional
    @TestOrder(12)
    public void testCreateTyouhyouTBL_A16() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_STDRHNK_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000001");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");

        hozenDomManager.getKykKihon(syoNo1).getTtdkKans().remove(
            hozenDomManager.getKykKihon(syoNo1).getTtdkKanByHenkousikibetukey("00000000001"));
    }

    @Test
    @Transactional
    @TestOrder(13)
    public void testCreateTyouhyouTBL_A17() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000001");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");

        hozenDomManager.getKykKihon(syoNo1).getTtdkKans().remove(
            hozenDomManager.getKykKihon(syoNo1).getTtdkKanByHenkousikibetukey("00000000001"));
    }

    @Test
    @Transactional
    @TestOrder(14)
    public void testCreateTyouhyouTBL_A18() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_GENGAKU_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000001");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");

        hozenDomManager.getKykKihon(syoNo1).getTtdkKans().remove(
            hozenDomManager.getKykKihon(syoNo1).getTtdkKanByHenkousikibetukey("00000000001"));
    }

    @Test
    @Transactional
    @TestOrder(15)
    public void testCreateTyouhyouTBL_A19() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000001");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");

        hozenDomManager.getKykKihon(syoNo1).getTtdkKans().remove(
            hozenDomManager.getKykKihon(syoNo1).getTtdkKanByHenkousikibetukey("00000000001"));
    }

    @Test
    @Transactional
    @TestOrder(16)
    public void testCreateTyouhyouTBL_A20() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_SHRKZHNK_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000001");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");

        hozenDomManager.getKykKihon(syoNo1).getTtdkKans().remove(
            hozenDomManager.getKykKihon(syoNo1).getTtdkKanByHenkousikibetukey("00000000001"));
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testCreateTyouhyouTBL_A2() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOUGAI);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR
            , C_SyoruiCdKbn.KK_KYKTRKS_KYKTRKSTTDKKR
            , C_SyoruiCdKbn.KK_CLGOFF_KYKTRKSTTDKKR
            , C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR
            , C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR
            , C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR
            , C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR
            , C_SyoruiCdKbn.KK_TARGETHNK_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000001");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1, syoruiCdKbn, C_YouhiKbn.YOU);

        List<IT_TtdkKan> ttdkKanLst = khozenCommonParam.getKeiyakuKihon(syoNo1).getTtdkKans();

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exNumericEquals(ttdkKanLst.size(), 0, "手続完了テーブルエンティティリストの件数");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testCreateTyouhyouTBL_A6() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOUGAI);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_ADRHNK_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000002");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2, syoruiCdKbn, C_YouhiKbn.YOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(90)
    public void testCreateTyouhyouTBL_A9() {

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.SEISANKINHURIKOMI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_ADRHNK_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000001");

        try {

            khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1, syoruiCdKbn, C_YouhiKbn.YOU);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約保全支払履歴テーブルにデータが存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testCreateTyouhyouTBL_A12() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOUGAI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_ADRHNK_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000005");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo5, syoruiCdKbn, C_YouhiKbn.YOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");

    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testCreateTyouhyouTBL_A13() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOUGAI);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_ADRHNK_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000004");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo4, syoruiCdKbn, C_YouhiKbn.YOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");

    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testCreateTyouhyouTBL_A14() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151201));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.NONE);
        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_ADRHNK_TTDKKR };

        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000004");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo4, syoruiCdKbn, C_YouhiKbn.HUYOU);

        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon(syoNo4);


        List<IT_TtdkKan> ttdkKanLst = kykKihon.getTtdkKans();

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(khozenTyouhyouCtl.getTyouhyouKey(), "", "帳票キー");
        exNumericEquals(ttdkKanLst.size(), 1, "手続完了テーブルエンティティリストの件数");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testCreateTyouhyouTBL_A21() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_ADRHNK_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000002");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2, syoruiCdKbn, C_YouhiKbn.YOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");

    }

    @Test
    @Transactional
    @TestOrder(400)
    public void testCreateTyouhyouTBL_A22() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151201));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KAIYAKU);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.NONE);
        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR };

        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000004");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo7, syoruiCdKbn, C_YouhiKbn.HUYOU);

        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon(syoNo7);


        List<IT_TtdkKan> ttdkKanLst = kykKihon.getTtdkKans();

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(khozenTyouhyouCtl.getTyouhyouKey(), "", "帳票キー");
        exNumericEquals(ttdkKanLst.size(), 1, "手続完了テーブルエンティティリストの件数");
    }

    @Test
    @Transactional
    @TestOrder(410)
    public void testCreateTyouhyouTBL_A23() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151201));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KAIYAKU);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.NONE);
        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_KAIGOMAETKHNK_TTDKKR };

        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000004");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo8, syoruiCdKbn, C_YouhiKbn.HUYOU);

        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon(syoNo8);


        List<IT_TtdkKan> ttdkKanLst = kykKihon.getTtdkKans();

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(khozenTyouhyouCtl.getTyouhyouKey(), "", "帳票キー");
        exNumericEquals(ttdkKanLst.size(), 1, "手続完了テーブルエンティティリストの件数");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(420)
    public void testCreateTyouhyouTBL_A24() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN2;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.SHRKZHENKOU);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_ADRHNK_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000001");

        try {

            khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1_24, syoruiCdKbn, C_YouhiKbn.YOU);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。手続完了テーブルにデータが存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(421)
    public void testCreateTyouhyouTBL_A25() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151201));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KAIYAKU);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.NONE);
        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR };

        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000004");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo9, syoruiCdKbn, C_YouhiKbn.HUYOU);

        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon(syoNo9);


        List<IT_TtdkKan> ttdkKanLst = kykKihon.getTtdkKans();

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exNumericEquals(ttdkKanLst.size(), 1, "手続完了テーブルエンティティリストの件数");
        exStringEquals(khozenTyouhyouCtl.getTyouhyouKey(), "", "帳票キー");
    }

    @Test
    @Transactional
    @TestOrder(422)
    public void testCreateTyouhyouTBL_A26() {

        MockObjectManager.initialize();
        EditTtdkKanryouTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;
        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN3;

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151201));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.NONE);
        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR
            , C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR };

        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000004");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo10, syoruiCdKbn, C_YouhiKbn.HUYOU);

        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon(syoNo10);

        List<IT_TtdkKan> ttdkKanLst = kykKihon.getTtdkKans();
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exNumericEquals(ttdkKanLst.size(), 2, "手続完了テーブルエンティティリストの件数");
        exStringEquals(khozenTyouhyouCtl.getTyouhyouKey(), "", "帳票キー");

        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = (IT_KhHasseijiKazeiRireki) MockObjectManager.getArgument(
            EditTtdkKanryouTblMockForHozen.class, "editTBL", 0, 7);

        exStringEquals(khHasseijiKazeiRireki.getSyono(), syoNo10, "証券番号");
    }

    @Test
    @Transactional
    @TestOrder(423)
    public void testCreateTyouhyouTBL_A27() {

        MockObjectManager.initialize();
        EditTtdkKanryouTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;
        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN3;
        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151201));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.NONE);
        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR
            , C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR };

        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000004");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo11, syoruiCdKbn, C_YouhiKbn.HUYOU);

        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon(syoNo11);

        List<IT_TtdkKan> ttdkKanLst = kykKihon.getTtdkKans();
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exNumericEquals(ttdkKanLst.size(), 2, "手続完了テーブルエンティティリストの件数");
        exStringEquals(khozenTyouhyouCtl.getTyouhyouKey(), "", "帳票キー");

        MockObjectManager.assertArgumentPassed(EditTtdkKanryouTblMockForHozen.class, "editTBL", 7, null);
    }

    @Test
    @Transactional
    @TestOrder(424)
    public void testCreateTyouhyouTBL_A28() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_DSHR_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000002");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2, syoruiCdKbn, C_YouhiKbn.YOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(425)
    public void testCreateTyouhyouTBL_A29() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000002");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2, syoruiCdKbn, C_YouhiKbn.YOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(426)
    public void testCreateTyouhyouTBL_A30() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000002");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2, syoruiCdKbn, C_YouhiKbn.YOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(427)
    public void testCreateTyouhyouTBL_A31() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000002");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2, syoruiCdKbn, C_YouhiKbn.YOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(428)
    public void testCreateTyouhyouTBL_A32() {

        MockObjectManager.initialize();
        EditTtdkKanryouTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;
        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN3;

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151201));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.NONE);
        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2};

        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000004");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1_13, syoruiCdKbn, C_YouhiKbn.HUYOU);

        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon(syoNo1_13);

        List<IT_TtdkKan> ttdkKanLst = kykKihon.getTtdkKans();
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exNumericEquals(ttdkKanLst.size(), 1, "手続完了テーブルエンティティリストの件数");
        exStringEquals(khozenTyouhyouCtl.getTyouhyouKey(), "", "帳票キー");

    }

    @Test
    @Transactional
    @TestOrder(429)
    public void testCreateTyouhyouTBL_A33() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000002");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2, syoruiCdKbn, C_YouhiKbn.YOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(430)
    public void testCreateTyouhyouTBL_A34() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR_ZEIMUNASI };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000002");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
    }
    @Test
    @Transactional
    @TestOrder(431)
    public void testCreateTyouhyouTBL_A35() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000002");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1_14, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(432)
    public void testCreateTyouhyouTBL_A36() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean = new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000002");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1_15, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(433)
    public void testCreateTyouhyouTBL_A37() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean = new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_3 };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000002");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1_16, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(434)
    public void testCreateTyouhyouTBL_A38() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean = new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR_2 };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000002");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1_17, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(435)
    public void testCreateTyouhyouTBL_A39() {

        C_SyoruiCdKbn[] syoruiCdKbn = {C_SyoruiCdKbn.KK_HKNSYKN };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);

        khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.BLNK);

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1_18, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(editHokenSyoukenParam.getTantoucd(), C_TantouCdKbn.DAIRITENJIMUHOZEN, "担当コード区分");

    }

    @Test
    @Transactional
    @TestOrder(436)
    public void testCreateTyouhyouTBL_A40() {

        C_SyoruiCdKbn[] syoruiCdKbn = {C_SyoruiCdKbn.KK_HKNSYKN };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);

        khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.BLNK);

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1_19, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(editHokenSyoukenParam.getTantoucd(), C_TantouCdKbn.DAIRITENJIMUHOZEN, "担当コード区分");

    }

    @Test
    @Transactional
    @TestOrder(437)
    public void testCreateTyouhyouTBL_A41() {

        C_SyoruiCdKbn[] syoruiCdKbn = {C_SyoruiCdKbn.KK_HKNSYKN };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);

        khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.BLNK);

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1_20, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(editHokenSyoukenParam.getTantoucd(), C_TantouCdKbn.DAIRITENJIMUHOZEN, "担当コード区分");

    }

    @Test
    @Transactional
    @TestOrder(438)
    public void testCreateTyouhyouTBL_A42() {

        EditTtdkKanryouTblMockForHozen.SYORIPTN = EditTtdkKanryouTblMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.HRIHEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setYykidouuktk(C_YykidouuktkKbn.TAISYOU);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHrkkeirohnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000001");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");

        hozenDomManager.getKykKihon(syoNo1).getTtdkKans().remove(
            hozenDomManager.getKykKihon(syoNo1).getTtdkKanByHenkousikibetukey("00000000001"));
    }


    @Test
    @Transactional
    @TestOrder(160)
    public void testCreateTyouhyouTBL_B1() {

        MockObjectManager.initialize();
        EditSeikyuusyoTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));

        C_KykhnkKbn[] kykhnkKbn = { C_KykhnkKbn.GENGAKU };
        editSeikyuusyoParam.setKykhnkkbn(kykhnkKbn);

        String[] syouhnnm = { "入院保険" };
        editSeikyuusyoParam.setSyouhnnm(syouhnnm);

        C_KihonssyuruiKbn[] kihonssyuruiKbn = { C_KihonssyuruiKbn.GETUGAKU };

        editSeikyuusyoParam.setKihonssyuruikbn(kihonssyuruiKbn);

        BizCurrency[] kihonS = { BizCurrency.valueOf(15) };

        editSeikyuusyoParam.setKihonS(kihonS);

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_SYOSAIHK_SKS
            , C_SyoruiCdKbn.KK_MEIGIHNK_SKS
            , C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS
            , C_SyoruiCdKbn.KK_GENGAKU_SKS
            , C_SyoruiCdKbn.KK_KAIYAKU_SKS
            , C_SyoruiCdKbn.KK_ADRHNK_SKS
            , C_SyoruiCdKbn.KK_STDRHNK_SKS
            , C_SyoruiCdKbn.KK_NKTKYKHNK_SKS
            , C_SyoruiCdKbn.KK_TARGETHNK_SKS
            , C_SyoruiCdKbn.KK_SHRKZHNK_SKS
            , C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SKS
            , C_SyoruiCdKbn.KK_MKHGKHNK_SKS
            , C_SyoruiCdKbn.KK_TUMITATEKINITEN_SKS
            , C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS
            , C_SyoruiCdKbn.KK_YENDTHNK_SKS
            , C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS
        };

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.setQrCodeYouhiKbn(C_YouhiKbn.YOU);
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exStringEquals(khozenTyouhyouCtl.getQrCode(), "qr001", "QRコード");
    }

    @Test
    @Transactional
    @TestOrder(161)
    public void testCreateTyouhyouTBL_B2() {

        MockObjectManager.initialize();
        EditSeikyuusyoTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;

        changeSystemDate(BizDate.valueOf(2016, 03, 31));

        C_KykhnkKbn[] kykhnkKbn = { C_KykhnkKbn.GENGAKU };
        editSeikyuusyoParam.setKykhnkkbn(kykhnkKbn);

        String[] syouhnnm = { "入院保険" };
        editSeikyuusyoParam.setSyouhnnm(syouhnnm);

        C_KihonssyuruiKbn[] kihonssyuruiKbn = { C_KihonssyuruiKbn.GETUGAKU };

        editSeikyuusyoParam.setKihonssyuruikbn(kihonssyuruiKbn);

        BizCurrency[] kihonS = { BizCurrency.valueOf(1) };

        editSeikyuusyoParam.setKihonS(kihonS);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_DSHR_SKS };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.setQrCodeYouhiKbn(C_YouhiKbn.YOU);
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exStringEquals(khozenTyouhyouCtl.getQrCode(), "qr001", "QRコード");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testCreateTyouhyouTBL_C1() {
        RayHttpHeaderBeanMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;

        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);

        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_SYOSAIHK_SOUHU
            , C_SyoruiCdKbn.KK_MEIGIHNK_SOUHU
            , C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU
            , C_SyoruiCdKbn.KK_GENGAKU_SOUHU
            , C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU
            , C_SyoruiCdKbn.KK_ADRHNK_SOUHU
            , C_SyoruiCdKbn.KK_SOUHUANNAI
            , C_SyoruiCdKbn.KK_STDRHNK_SOUHU
            , C_SyoruiCdKbn.KK_NKTKYKHNK_SOUHU
            , C_SyoruiCdKbn.KK_TARGETHNK_SOUHU
            , C_SyoruiCdKbn.KK_SHRKZHNK_SOUHU
            , C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU
            ,C_SyoruiCdKbn.KK_MKHGKHNK_SOUHU
            ,C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU
            ,C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU
            ,C_SyoruiCdKbn.KK_SHIHARAI_SOUHU
            ,C_SyoruiCdKbn.KK_YENDTHNK_SOUHU
            ,C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU
        };

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.setQrCodeYouhiKbn(C_YouhiKbn.HUYOU);
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exStringEquals(khozenTyouhyouCtl.getQrCode(), "", "QRコード");
    }

    @Test
    @Transactional
    @TestOrder(171)
    public void testCreateTyouhyouTBL_C2() {

        RayHttpHeaderBeanMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;

        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);

        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_DSHR_SOUHU };

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.setQrCodeYouhiKbn(C_YouhiKbn.HUYOU);
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exStringEquals(khozenTyouhyouCtl.getQrCode(), "", "QRコード");
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testCreateTyouhyouTBL_D1() {
        MockObjectManager.initialize();
        EditSyoukenTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_HKNSYKN };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));
        khozenTyouhyouCtl.setSinsaihkkbn(C_SinsaihkKbn.SIN);
        khozenTyouhyouCtl.setTetudukisyukbn(C_TetudukisyuKbn.ADRHNK);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);

        khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.BLNK);

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.HUYOU);

        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon(syoNo2_1);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();
        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exNumericEquals(hokenSyoukenLst.size(), 1, "保険証券テーブルエンティティリストの件数");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20150901), "帳票作成日");

        exNumericEquals(suiihyouLst.size(), 0, "推移表テーブルエンティティリストの件数");
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(190)
    public void testCreateTyouhyouTBL_D2() {

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_HKNSYKN };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));
        khozenTyouhyouCtl.setSinsaihkkbn(C_SinsaihkKbn.SIN);
        khozenTyouhyouCtl.setTetudukisyukbn(C_TetudukisyuKbn.ADRHNK);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);

        khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.BLNK);

        khozenCommonParam.setSikibetuKey("00000000021");

        try {
            khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_2, syoruiCdKbn, C_YouhiKbn.HUYOU);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),"システム整合性エラーです。入金実績履歴テーブルにデータが存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testCreateTyouhyouTBL_E1() {

        EditKoujyoSyoumeiTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;
        EditKoujyoSyoumeiTblMockForHozen.SYORIPTN = EditKoujyoSyoumeiTblMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS };

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setKoujyoNendo("2010");
        editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.IPPAN);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20151019));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));

        khozenTyouhyouCtl.setEditKoujyoSyoumeiParam(editKoujyoSyoumeiParam);

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testCreateTyouhyouTBL_E2() {

        EditKoujyoSyoumeiTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;
        EditKoujyoSyoumeiTblMockForHozen.SYORIPTN = EditKoujyoSyoumeiTblMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS };

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setKoujyoNendo("2011");
        editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.IPPAN);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20151019));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));

        khozenTyouhyouCtl.setEditKoujyoSyoumeiParam(editKoujyoSyoumeiParam);

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.HUYOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");

    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testCreateTyouhyouTBL_E3() {
        MockObjectManager.initialize();
        EditKoujyoSyoumeiTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;
        EditKoujyoSyoumeiTblMockForHozen.SYORIPTN = EditKoujyoSyoumeiTblMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS };

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.BLNK);
        editKoujyoSyoumeiParam.setKoujyoNendo("2010");
        editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.IPPAN);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20151019));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));

        khozenTyouhyouCtl.setEditKoujyoSyoumeiParam(editKoujyoSyoumeiParam);

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.YOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(221)
    public void testCreateTyouhyouTBL_E4() {
        MockObjectManager.initialize();
        EditKoujyoSyoumeiTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;
        EditKoujyoSyoumeiTblMockForHozen.SYORIPTN = EditKoujyoSyoumeiTblMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS };

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setKoujyoNendo("2010");
        editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.IPPAN);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20151019));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));

        khozenTyouhyouCtl.setEditKoujyoSyoumeiParam(editKoujyoSyoumeiParam);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "", C_SyoruiCdKbn.BLNK);

        khozenTyouhyouCtl.setReportServicesBean(reportServicesBean);

        ReportServicesBean[] reportServicesBeans = new ReportServicesBean[] { reportServicesBean };

        khozenTyouhyouCtl.setReportServicesBean(reportServicesBeans);

        khozenCommonParam.setSikibetuKey("00000000021");

        try {

            khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.YOU);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。控除証明書テーブルにデータが存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(222)
    public void testCreateTyouhyouTBL_E5() {
        MockObjectManager.initialize();
        EditKoujyoSyoumeiTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;
        EditKoujyoSyoumeiTblMockForHozen.SYORIPTN = EditKoujyoSyoumeiTblMockForHozen.TESTPATTERN2;

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS };

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setKoujyoNendo("2010");
        editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.IPPAN);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20151019));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));

        khozenTyouhyouCtl.setEditKoujyoSyoumeiParam(editKoujyoSyoumeiParam);

        khozenCommonParam.setSikibetuKey("00000000021");

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.YOU);

        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testCreateTyouhyouTBL_F1() {

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));

        String message1 = "EAC0015";
        List<String> messageLst = new ArrayList<>();

        messageLst.add(message1);

        editJimuRenrakuhyouParam.setJimurenrakuMsgList(messageLst);

        khozenTyouhyouCtl.setEditJimuRenrakuhyouParam(editJimuRenrakuhyouParam);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_JIMURENRAKU_KYKTORIKESI
            , C_SyoruiCdKbn.KK_JIMURENRAKU_GENGAKU
            , C_SyoruiCdKbn.KK_JIMURENRAKU_SEINENGAPPISEITEISEI
            , C_SyoruiCdKbn.KK_JIMURENRAKU_MEIGIHNK
            , C_SyoruiCdKbn.KK_JIMURENRAKU_TETUDUKITYUUI };

        khozenCommonParam.setSikibetuKey("00000000021");
        AM_User aMUser = new AM_User();
        aMUser.setUserId("user1234");
        changeCurrentUser(baseUserInfo, aMUser);
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testCreateTyouhyouTBL_G1() {

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));

        List<EditKhMisslstParam> editKkMisslstParamLst = new ArrayList<>();

        editKhMisslstParam.setDataNo(10);
        editKhMisslstParam.setSeqNo(1);
        editKhMisslstParam.setSyoNo(syoNo2_1);
        editKhMisslstParam.setDBhaneikbn(C_Dbhanei.SUMI);
        editKhMisslstParam.setMisslistMsg("EAC0015");

        editKkMisslstParamLst.add(editKhMisslstParam);

        khozenTyouhyouCtl.setEditKkMisslstParam(editKkMisslstParamLst);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_KYKINFOTORIKOMI_MISSLIST
            , C_SyoruiCdKbn.KK_SHRKEKKATORIKOMI_MISSLIST
            , C_SyoruiCdKbn.KK_KZHURIANNAISEL_MISSLIST
            , C_SyoruiCdKbn.KK_YUUKOUKEKKAHANEI_MISSLIST
            , C_SyoruiCdKbn.KK_AUTHORIKEKKAHANEI_MISSLIST
            , C_SyoruiCdKbn.KK_URIAGEKEKKATRSKS_MISSLIST
            , C_SyoruiCdKbn.KK_NYUUKIN_MISSLIST
            , C_SyoruiCdKbn.KK_KACHECK_YOHURI_MISSLIST
            , C_SyoruiCdKbn.KK_KACHECK_SHRKZ_MISSLIST
            , C_SyoruiCdKbn.KK_DHANEI_MISSLIST
            , C_SyoruiCdKbn.KK_BATCHKAIYAKU_MISSLIST
            , C_SyoruiCdKbn.KK_YENDTHNK_MISSLIST };

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(241)
    public void testCreateTyouhyouTBL_G2() {

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));

        List<EditKhMisslstParam> editKkMisslstParamLst = new ArrayList<>();

        editKhMisslstParam.setDataNo(10);
        editKhMisslstParam.setSeqNo(1);
        editKhMisslstParam.setSyoNo(syoNo2_1);
        editKhMisslstParam.setDBhaneikbn(C_Dbhanei.SUMI);
        editKhMisslstParam.setMisslistMsg("EAC0015");

        editKkMisslstParamLst.add(editKhMisslstParam);

        khozenTyouhyouCtl.setEditKkMisslstParam(editKkMisslstParamLst);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_YENDTHNKSEL_MISSLIST
            , C_SyoruiCdKbn.KK_SEISANDHANEI_MISSLIST
            , C_SyoruiCdKbn.KK_DSEISAN_MISSLIST
            , C_SyoruiCdKbn.KK_SISUURENDOTMTTKNHANEI_MISSLIST
            , C_SyoruiCdKbn.KK_GAIKAKOKYAKUTUUTISKS_MISSLIST
        };

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }


    @Test
    @Transactional
    @TestOrder(241)
    public void testCreateTyouhyouTBL_G3() {

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));

        List<EditKhMisslstParam> editKkMisslstParamLst = new ArrayList<>();

        editKhMisslstParam.setDataNo(10);
        editKhMisslstParam.setSeqNo(1);
        editKhMisslstParam.setSyoNo(syoNo2_1);
        editKhMisslstParam.setDBhaneikbn(C_Dbhanei.SUMI);
        editKhMisslstParam.setMisslistMsg("EAC0015");

        editKkMisslstParamLst.add(editKhMisslstParam);

        khozenTyouhyouCtl.setEditKkMisslstParam(editKkMisslstParamLst);

        C_SyoruiCdKbn[] syoruiCdKbn = {
            C_SyoruiCdKbn.KK_BATCHMKHGKHENKOU_MISSLIST
        };

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }


    // 「QA No.1578-001」回答により、テスト対象外です
    //    @Test
    //    @Transactional
    //    @TestOrder(250)
    //    public void testCreateTyouhyouTBL_H1() {
    //
    //        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));
    //
    //        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
    //            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
    //            "",
    //            "",
    //            C_SyoruiCdKbn.KK_MINYUUITIRAN);
    //
    //        khozenTyouhyouCtl.setReportServicesBean(reportServicesBean);
    //
    //        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_MINYUUITIRAN };
    //
    //        khozenCommonParam.setSikibetuKey("00000000021");
    //        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.YOU);
    //        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    //    }

    // 「QA No.1578-001」回答により、テスト対象外です
    //    @Test
    //    @Transactional
    //    @TestOrder(260)
    //    public void testCreateTyouhyouTBL_H2() {
    //        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
    //            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
    //            "",
    //            "",
    //            C_SyoruiCdKbn.KK_MINYUUITIRAN);
    //
    //        ReportServicesBean reportServicesBean2 = createReport.createNewReportServiceBean(
    //            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
    //            "",
    //            "KhozenTyouhyouCtl",
    //            C_SyoruiCdKbn.KK_MINYUUITIRAN);
    //
    //        ReportServicesBean reportServicesBean3 = createReport.createNewReportServiceBean(
    //            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
    //            "",
    //            "KhozenTyouhyouCtl",
    //            C_SyoruiCdKbn.KK_MINYUUITIRAN);
    //
    //        ReportServicesBean[] reportServicesBeanLst = new ReportServicesBean[3];
    //        reportServicesBeanLst[0] = reportServicesBean;
    //        reportServicesBeanLst[1] = reportServicesBean2;
    //        reportServicesBeanLst[2] = reportServicesBean3;
    //        khozenTyouhyouCtl.setReportServicesBean(reportServicesBeanLst);
    //        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));
    //
    //        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_MINYUUITIRAN };
    //
    //        khozenCommonParam.setSikibetuKey("00000000021");
    //        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.YOU);
    //        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    //    }

    // 「QA No.1578-001」回答により、テスト対象外です
    //    @Test
    //    @Transactional
    //    @TestOrder(270)
    //    public void testCreateTyouhyouTBL_I1() {
    //
    //        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));
    //
    //        ReportServicesBean reportServicesBean1 = createReport.createNewReportServiceBean(
    //            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
    //            "",
    //            "",
    //            C_SyoruiCdKbn.KK_SIKKOUITIRAN);
    //
    //        ReportServicesBean reportServicesBean2 = createReport.createNewReportServiceBean(
    //            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
    //            "",
    //            "",
    //            C_SyoruiCdKbn.KK_MINYUUITIRAN);
    //
    //        ReportServicesBean reportServicesBean3 = createReport.createNewReportServiceBean(
    //            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
    //            "",
    //            "",
    //            C_SyoruiCdKbn.KK_HANDKARIKANJYOU);
    //
    //        ReportServicesBean[] reportServicesBeanLst = { reportServicesBean1, reportServicesBean2, reportServicesBean3 };
    //
    //        khozenTyouhyouCtl.setReportServicesBean(reportServicesBeanLst);
    //
    //        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_SIKKOUITIRAN };
    //
    //        khozenCommonParam.setSikibetuKey("00000000021");
    //        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo2_1, syoruiCdKbn, C_YouhiKbn.YOU);
    //        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    //    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(320)
    public void testCreateTyouhyouTBL_M1() {

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.CM_ONLINE_GKFBFURIKOMIKEI_1 };

        khozenCommonParam.setSikibetuKey("00000000001");

        try {

            KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
            khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1, syoruiCdKbn, C_YouhiKbn.YOU);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。書類コード不正（cm005）", "エラーメッセージ");
            throw e;
        }

    }

    // 「QA No.1578-001」回答により、テスト対象外です
    //    @Test
    //    @Transactional
    //    @TestOrder(330)
    //    public void testCreateTyouhyouTBL_N1() {
    //        khozenTyouhyouCtl.setEditKoujyoSyoumeiParam(editKoujyoSyoumeiParam);
    //        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));
    //
    //        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
    //            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
    //            "",
    //            "",
    //            C_SyoruiCdKbn.KK_HANDKARIKANJYOU);
    //        ReportServicesBean[] reportServicesBeanLst = { reportServicesBean };
    //
    //        khozenTyouhyouCtl.setReportServicesBean(reportServicesBeanLst);
    //
    //        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_HANDKARIKANJYOU };
    //
    //        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoruiCdKbn, C_YouhiKbn.YOU);
    //        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    //    }

    @Test
    @Transactional
    @TestOrder(340)
    public void testCreateTyouhyouTBL_O1() {
        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));

        C_SyoruiCdKbn[] syoruiCdKbn = {};

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(360)
    public void testCreateTyouhyouTBL_P1() {

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151001));

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_NKTKYKHNK_GAIYOU };

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo16_1, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(370)
    public void testCreateTyouhyouTBL_Q1() {

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151001));

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_MEIGIHNK_DAIHYOUSN, C_SyoruiCdKbn.KK_KAIYAKU_DAIHYOUSN
            ,C_SyoruiCdKbn.KK_YENDTHNKHNRKN_DAIHYOUSN};

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenCommonParam.setFunctionId("KhozenTyouhyouCtl");
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo17_1, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(380)
    public void testCreateTyouhyouTBL_R1() {

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151001));

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK };

        khozenCommonParam.setSikibetuKey("00000000021");

        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYKSB);
        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo18_1, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(390)
    public void testCreateTyouhyouTBL_R2() {

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK };

        khozenCommonParam.setSikibetuKey("00000000021");

        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYKSB);
        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(360)
    public void testCreateTyouhyouTBL_S1() {

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151001));

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_KAIGOMAETK_KYKGAIYOU };

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo19_1, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(360)
    public void testCreateTyouhyouTBL_T1() {

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151001));

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_KAIGOMAETK_TYUUIKANKI };

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo20_1, syoruiCdKbn, C_YouhiKbn.YOU);
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
    }

    @Test
    @Transactional
    @TestOrder(435)
    public void testCreateTyouhyouTBL_U1() {

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.SHRKZHENKOU);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_MINYUUITIRAN };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000001");

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "siharai", "SiSiSanTest", C_SyoruiCdKbn.KK_MINYUUITIRAN);

        SiEditEnkaryuuiBean siEditEnkaryuuiBean = SWAKInjector.getInstance(SiEditEnkaryuuiBean.class);

        reportTestBean.addParamObjects(siEditEnkaryuuiBean);

        ReportServicesBean[] reportServicesBeans = new ReportServicesBean[]{reportTestBean};

        khozenTyouhyouCtl.setReportServicesBean(reportServicesBeans);

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1_24, syoruiCdKbn, C_YouhiKbn.YOU);
    }

    @Test
    @Transactional
    @TestOrder(440)
    public void testCreateTyouhyouTBL_U2() {

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.SHRKZHENKOU);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_SIKKOUITIRAN };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000001");

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "siharai", "SiSiSanTest", C_SyoruiCdKbn.KK_SIKKOUITIRAN);

        SiEditEnkaryuuiBean siEditEnkaryuuiBean = SWAKInjector.getInstance(SiEditEnkaryuuiBean.class);

        reportTestBean.addParamObjects(siEditEnkaryuuiBean);

        ReportServicesBean[] reportServicesBeans = new ReportServicesBean[]{reportTestBean};

        khozenTyouhyouCtl.setReportServicesBean(reportServicesBeans);

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1_24, syoruiCdKbn, C_YouhiKbn.YOU);
    }

    @Test
    @Transactional
    @TestOrder(450)
    public void testCreateTyouhyouTBL_U3() {

        changeSystemDate(BizDate.valueOf(2016, 03, 31));
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.SHRKZHENKOU);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setHrkkaisuuhnkumu(C_UmuKbn.ARI);

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_HANDKARIKANJYOU };

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenCommonParam.setSikibetuKey("00000000001");

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "siharai", "SiSiSanTest", C_SyoruiCdKbn.KK_HANDKARIKANJYOU);

        SiEditEnkaryuuiBean siEditEnkaryuuiBean = SWAKInjector.getInstance(SiEditEnkaryuuiBean.class);

        reportTestBean.addParamObjects(siEditEnkaryuuiBean);

        ReportServicesBean[] reportServicesBeans = new ReportServicesBean[]{reportTestBean};

        khozenTyouhyouCtl.setReportServicesBean(reportServicesBeans);

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo1_24, syoruiCdKbn, C_YouhiKbn.YOU);
    }

    @Test
    @Transactional
    @TestOrder(460)
    public void testCreateTyouhyouTBL_D3() {
        MockObjectManager.initialize();
        EditSyoukenTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;

        C_SyoruiCdKbn[] syoruiCdKbn = {C_SyoruiCdKbn.KK_HKNSYKN };

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setKoujyoNendo("2010");
        editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.IPPAN);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20151019));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setKoujyoSakuseiSyoriKbn(C_KoujyosyoumeisakuseisyoriKbn.HOKENSYOUKEN);

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditKoujyoSyoumeiParam(editKoujyoSyoumeiParam);

        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));
        khozenTyouhyouCtl.setSinsaihkkbn(C_SinsaihkKbn.SIN);
        khozenTyouhyouCtl.setTetudukisyukbn(C_TetudukisyuKbn.ADRHNK);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);

        khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.BLNK);

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, "11807111129", syoruiCdKbn, C_YouhiKbn.HUYOU);

        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon("11807111129");
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();
        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exNumericEquals(hokenSyoukenLst.size(), 1, "保険証券テーブルエンティティリストの件数");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20150901), "帳票作成日");

        exNumericEquals(suiihyouLst.size(), 0, "推移表テーブルエンティティリストの件数");
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");

    }

    @Test
    @Transactional
    @TestOrder(470)
    public void testCreateTyouhyouTBL_D4() {
        MockObjectManager.initialize();
        EditSyoukenTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;
        EditKoujyoSyoumeiTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;
        EditKoujyoSyoumeiTblMockForHozen.SYORIPTN = EditKoujyoSyoumeiTblMockForHozen.TESTPATTERN2;

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS , C_SyoruiCdKbn.KK_HKNSYKN };

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setKoujyoNendo("2010");
        editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.IPPAN);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20151019));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setKoujyoSakuseiSyoriKbn(C_KoujyosyoumeisakuseisyoriKbn.BLNK);

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditKoujyoSyoumeiParam(editKoujyoSyoumeiParam);

        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));
        khozenTyouhyouCtl.setSinsaihkkbn(C_SinsaihkKbn.SIN);
        khozenTyouhyouCtl.setTetudukisyukbn(C_TetudukisyuKbn.ADRHNK);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);

        khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.BLNK);

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, "11807111141", syoruiCdKbn, C_YouhiKbn.HUYOU);

        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon("11807111141");
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();
        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exNumericEquals(hokenSyoukenLst.size(), 2, "保険証券テーブルエンティティリストの件数");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20150901), "帳票作成日");
        exDateEquals(hokenSyoukenLst.get(1).getTyouhyouymd(), BizDate.valueOf(20151021), "帳票作成日");

        exNumericEquals(suiihyouLst.size(), 0, "推移表テーブルエンティティリストの件数");
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");

        EditHokenSyoukenParam editHokenSyoukenParam1 = (EditHokenSyoukenParam) MockObjectManager.getArgument(EditSyoukenTblMockForHozen.class, "editTBL", 0, 14);

        exClassificationEquals(editHokenSyoukenParam1.getTantoucd(), C_TantouCdKbn.DAIRITENJIMUHOZEN, "担当コード区分");

    }

    @Test
    @Transactional
    @TestOrder(480)
    public void testCreateTyouhyouTBL_D5() {
        MockObjectManager.initialize();
        EditSyoukenTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;
        EditKoujyoSyoumeiTblMockForHozen.caller = KhozenTyouhyouCtlTest_createTyouhyouTBL.class;
        EditKoujyoSyoumeiTblMockForHozen.SYORIPTN = EditKoujyoSyoumeiTblMockForHozen.TESTPATTERN2;

        C_SyoruiCdKbn[] syoruiCdKbn = { C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS , C_SyoruiCdKbn.KK_HKNSYKN };

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setKoujyoNendo("2010");
        editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.IPPAN);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20151019));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setKoujyoSakuseiSyoriKbn(C_KoujyosyoumeisakuseisyoriKbn.HOKENSYOUKEN);

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditKoujyoSyoumeiParam(editKoujyoSyoumeiParam);

        khozenTyouhyouCtl.setSyoriYmd(BizDate.valueOf(20151020));
        khozenTyouhyouCtl.setSinsaihkkbn(C_SinsaihkKbn.SIN);
        khozenTyouhyouCtl.setTetudukisyukbn(C_TetudukisyuKbn.ADRHNK);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);

        khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.BLNK);

        khozenCommonParam.setSikibetuKey("00000000021");
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, "11807111130", syoruiCdKbn, C_YouhiKbn.HUYOU);

        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon("11807111130");
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();
        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exNumericEquals(hokenSyoukenLst.size(), 1, "保険証券テーブルエンティティリストの件数");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20150901), "帳票作成日");

        exNumericEquals(suiihyouLst.size(), 0, "推移表テーブルエンティティリストの件数");
        exClassificationEquals(khozenTyouhyouCtl.getTyouhyoumuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");

    }

}
