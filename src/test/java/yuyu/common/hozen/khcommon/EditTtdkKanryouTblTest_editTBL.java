package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoMockForHozen;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_HugouKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykniyuhenkouKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_SksmongonKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantousituKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YenShrTkHnkKbn;
import yuyu.def.classification.C_YendthnkzeimuinfohskKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.auth.RayHttpHeaderBean;
import yuyu.infr.auth.RayHttpHeaderBeanMockForHozen;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 手続完了TBL編集のメソッド{@link EditTtdkKanryouTbl#editTBL(KhozenCommonParam, IT_KykKihon, List, IT_KykSya, IT_HhknSya, EditTtdkKanryouParam, IT_KhShrRireki, IT_KykSonotaTkyk, BizDate, C_HassouKbn, C_SyoruiCdKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditTtdkKanryouTblTest_editTBL extends AbstractTest {

    @Inject
    private EditTtdkKanryouTbl editTtdkKanryouTbl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditTtdkKanryouParam editTtdkKanryouParam;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_手続完了TBL編集";

    private final static String sheetName = "INデータ";

    private static String callcentersosikicd;

    private static String uketimecallcenter1;

    private static String uketimecallcenter2;

    private static String uketimetantousitu1;

    private static String uketimetantousitu2;

    private IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinoInfo;

    @Before
    public void beforeTest() {
        changeSystemDate(BizDate.valueOf(2015, 12, 20));
    }

    @Before
    public void before() {
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(RayHttpHeaderBean.class).to(RayHttpHeaderBeanMockForHozen.class);
                bind(GetKhKykdrInfo.class).to(GetKhKykdrInfoForHozen.class);
                bind(BzGetSosikiMadogutiInfo.class).to(BzGetSosikiMadogutiInfoMockForHozen.class);
            }
        });
        RayHttpHeaderBeanMockForHozen.caller = EditTtdkKanryouTblTest_editTBL.class;
        GetKhKykdrInfoForHozen.caller = EditTtdkKanryouTblTest_editTBL.class;
        BzGetSosikiMadogutiInfoMockForHozen.caller = EditTtdkKanryouTblTest_editTBL.class;
    }
    @BeforeClass
    @Transactional
    public static void testInit() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = null;
        GetKhKykdrInfoForHozen.SYORIPTN = null;
        BzGetSosikiMadogutiInfoMockForHozen.SYORIPTN = null;
        callcentersosikicd = YuyuBizConfig.getInstance().getCallcentersosikicd();
        uketimecallcenter1 = YuyuBizConfig.getInstance().getUketimecallcenter1();
        uketimecallcenter2 = YuyuBizConfig.getInstance().getUketimecallcenter2();
        uketimetantousitu1 = YuyuBizConfig.getInstance().getUketimetantousitu1();
        uketimetantousitu2 = YuyuBizConfig.getInstance().getUketimetantousitu2();

        YuyuBizConfig.getInstance().setCallcentersosikicd("0010001");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160403");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160404");
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditTtdkKanryouTblTest_editTBL.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllSosikiMadoguti());
        bizDomManager.delete(bizDomManager.getAllGinkou());

        MockObjectManager.initialize();
        RayHttpHeaderBeanMockForHozen.caller = null;
        RayHttpHeaderBeanMockForHozen.SYORIPTN = null;

        GetKhKykdrInfoForHozen.caller = null;
        GetKhKykdrInfoForHozen.SYORIPTN = null;

        BzGetSosikiMadogutiInfoMockForHozen.caller = null;
        BzGetSosikiMadogutiInfoMockForHozen.SYORIPTN = null;

        YuyuBizConfig.getInstance().setCallcentersosikicd(callcentersosikicd);
        YuyuBizConfig.getInstance().setUketimecallcenter1(uketimecallcenter1);
        YuyuBizConfig.getInstance().setUketimecallcenter2(uketimecallcenter2);
        YuyuBizConfig.getInstance().setUketimetantousitu1(uketimetantousitu1);
        YuyuBizConfig.getInstance().setUketimetantousitu2(uketimetantousitu2);
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testEditTBL_A1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000063");
        List<IT_KykSyouhn> kykSyouhnLst = null;
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("100").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);
        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.BLNK);

        assertNull("手続完了テーブルエンティティ", ttdkKan);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testEditTBL_A2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000063");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("100").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);
        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.BLNK);

        assertNull("手続完了テーブルエンティティ", ttdkKan);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testEditTBL_A3() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000018");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.BLNK);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000018", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.BLNK, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), BizDate.valueOf(20170816), "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160403", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160404", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.NKTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.NONE, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), null, "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.BLNK, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(0), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.BLNK, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), null, "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.BLNK, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(199004163115L), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(327841), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.SKS, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１８年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "※ご契約期間中に契約者の変更がありました。", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "　確定申告については所轄の税務署にお問い合わせください。", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exStringEquals(ttdkKan.getOsirasemongon36(), "", "お知らせ文言３６");
        exStringEquals(ttdkKan.getOsirasemongon37(), "", "お知らせ文言３７");
        exStringEquals(ttdkKan.getOsirasemongon38(), "", "お知らせ文言３８");
        exStringEquals(ttdkKan.getOsirasemongon39(), "", "お知らせ文言３９");
        exStringEquals(ttdkKan.getOsirasemongon40(), "", "お知らせ文言４０");
        exStringEquals(ttdkKan.getOsirasemongon41(), "", "お知らせ文言４１");
        exStringEquals(ttdkKan.getOsirasemongon42(), "", "お知らせ文言４２");
        exStringEquals(ttdkKan.getOsirasemongon43(), "", "お知らせ文言４３");
        exStringEquals(ttdkKan.getOsirasemongon44(), "", "お知らせ文言４４");
        exStringEquals(ttdkKan.getOsirasemongon45(), "", "お知らせ文言４５");
        exStringEquals(ttdkKan.getOsirasemongon46(), "", "お知らせ文言４６");
        exStringEquals(ttdkKan.getOsirasemongon47(), "", "お知らせ文言４７");
        exStringEquals(ttdkKan.getOsirasemongon48(), "", "お知らせ文言４８");
        exStringEquals(ttdkKan.getOsirasemongon49(), "", "お知らせ文言４９");
        exStringEquals(ttdkKan.getOsirasemongon50(), "", "お知らせ文言５０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(787825), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI_HASSEIJI, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 1, "契約者変更回数");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.SHRTYSYTSG_KYKHNKARI, "円建変更時税務情報補足区分");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

        YuyuBizConfig.getInstance().setCallcentersosikicd("0010001");

        khHasseijiKazeiRireki = null;

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testEditTBL_A4_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000029");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;

        khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();

        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000029", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.NKTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.NONE, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), null, "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.BLNK, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(0), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.BLNK, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), null, "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.BLNK, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.ITJKNSHRTYOUSYO, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(199004163114L), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(327840), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１８年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "※ご契約期間中に契約者の変更がありました。", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "　確定申告については所轄の税務署にお問い合わせください。", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(787824), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI_HASSEIJI, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 1, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.SHRTYSYTS_KYKHNKARI, "円建変更時税務情報補足区分");

        khHasseijiKazeiRireki = null;
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testEditTBL_A4_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000030");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "MD11", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;

        khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();

        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000030", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.NKTKYKHUKA, "手続種類区分");

        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(199004163112L), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(327842), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１８年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.SHRTYSYTSG_KYKHNKNASI, "円建変更時税務情報補足区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");

        khHasseijiKazeiRireki = null;

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testEditTBL_A4_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T200", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;

        khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();

        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111118", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.NKTKYKHUKA, "手続種類区分");

        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.ITJKNSHRTYOUSYO, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(199004163110L), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(327843), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１８年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.SHRTYSYTS_KYKHNKNASI, "円建変更時税務情報補足区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");

        khHasseijiKazeiRireki = null;

    }

    @Test
    @TestOrder(70)
    public void testEditTBL_A4_4() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000041");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;

        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000041", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.NKTKYKHENKOU, "手続種類区分");

    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A4_5() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000052");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;

        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKKAIYAKU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000052", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.NKTKYKKAIYAKU, "手続種類区分");

    }

    @Test
    @TestOrder(90)
    public void testEditTBL_A4_6() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;

        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.BLNK);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111129", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.BLNK, "手続種類区分");

    }

    @Test
    @TestOrder(100)
    public void testEditTBL_A5_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000063");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;

        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_TARGETHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000063", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_TARGETHNK_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.TARGETSYUUSINHENKOU, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.NONE, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.NONE, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), null, "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), null, "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.BLNK, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(0), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.BLNK, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), null, "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.BLNK, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");
    }

    @Test
    @TestOrder(110)
    public void testEditTBL_A5_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000074");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;

        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETNKHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_TARGETHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "07", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000074", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_TARGETHNK_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.TARGETNKHENKOU, "手続種類区分");

    }

    @Test
    @TestOrder(120)
    public void testEditTBL_A5_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000085");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;

        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_TARGETHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000085", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_TARGETHNK_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.NKTKYKHENKOU, "手続種類区分");

    }

    @Test
    @TestOrder(130)
    public void testEditTBL_A6_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000096");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;

        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.NASI);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_STDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000096", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_STDRHNK_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.NKTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.NONE, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.ARI, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "　被保険者代理人は指定されていません。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "　被保険者代理人は、代理請求時に約款上の所定要件を満たしていることが必要です。", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　本特約の付加に伴う、保険料の変更はありません。", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "　詳しくは、「被保険者代理特約中途付加のしおり・約款」をご覧ください。", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "＊＊確認事項＊＊", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "　特約中途付加のお申込みのときに「被保険者代理特約中途付加のしおり・約款」を同封していますので", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "　大切に保管くださいますようお願いいたします。", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), null, "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), null, "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.BLNK, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(0), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.BLNK, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), null, "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.BLNK, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");
    }

    @Test
    @TestOrder(140)
    public void testEditTBL_A6_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000100");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;

        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_STDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000100", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_STDRHNK_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "　被保険者代理人は、指定代理請求人名　様です。", "手続内容１");

    }

    @Test
    @TestOrder(150)
    public void testEditTBL_A6_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000111");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;

        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.KJKHUKA);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_STDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000111", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_STDRHNK_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "　被保険者代理人は、代理請求人名　様です。", "手続内容１");

    }

    @Test
    @TestOrder(160)
    public void testEditTBL_A7_1() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000122");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.HHKN);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000122", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.TARGETSYUUSINHENKOU, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.ARI, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "　被保険者の生年月日・性を平成２８年　４月　１日　男性に訂正しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(12), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "9900", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "102", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "101010***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.ITJKNSHRTYOUSYO, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(170)
    public void testEditTBL_A7_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000133");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.HHKN);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000133", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "　被保険者の生年月日を平成２８年　４月　１日に訂正しました。", "手続内容１");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");

    }

    @Test
    @TestOrder(180)
    public void testEditTBL_A7_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000144");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.HHKN);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000144", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "　被保険者の性を男性に訂正しました。", "手続内容１");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");

    }

    @Test
    @TestOrder(190)
    public void testEditTBL_A8_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000155");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000155", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.TARGETSYUUSINHENKOU, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.ARI, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "　基本給付金額を１００　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(0.01, BizCurrencyTypes.AU_DOLLAR), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他支払金合計", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "（明細）", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "・保険料（円貨払込額）", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "・配当金", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "・特別配当金", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "源泉徴収税額", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "支払利息", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(1), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(1), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(1), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(Long.valueOf("9999999999999")), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0.01, BizCurrencyTypes.AU_DOLLAR), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.JPY, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.JPY, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.JPY, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.JPY, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・減額部分の解約返戻金は解約返戻金（外貨）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を円貨に換算した金額です。　（１）×（２）", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）適用為替レート：４５６．００　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）減額部分の解約返戻金（外貨）", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１３　円", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "・その他支払金合計はその他支払金明細の合計額です。", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "必要書類の受付日翌日から５営業日を超えた２３日分", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "102", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.ITJKNSHRTYOUSYO, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(111), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１６年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆税法上、源泉分離課税の対象となりますので、お支払金額から差し引きしています。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　　お支払金額明細に記載の源泉徴収税額は復興特別所得税を含んだ金額です。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(Long.valueOf("0")), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.HU, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(200)
    public void testEditTBL_A8_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000292");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000292", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "保険料", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "配当金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "特別配当金", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "支払利息", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(1), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(1), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(1), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "金額明細６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.JPY, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "必要書類の受付日翌日から５営業日を超えた２３日分", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(111), "必要経費");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【適用為替レートについて】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆円貨支払いのご請求により、解約返戻金を外貨（指定通貨または選択通貨）にかえて減額日時点の当社", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　　所定の為替レート（※１）で円貨に換算してお支払いしています。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）－５０銭」（※３）となります。", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　　　日とします。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　公示値とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＢを下回ることはありません。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」", "お知らせ文言１８");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");

    }

    @Test
    @TestOrder(210)
    public void testEditTBL_A8_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000013", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(99999), "支払時契約者必要経費");
        exStringEquals(ttdkKan.getZeimumongon2(), "※ご契約期間中に契約者の変更がありました。", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "　確定申告については所轄の税務署にお問い合わせください。", "税務文言３");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＢを下回ることはありません。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　◆税法上、源泉分離課税の対象となりますが、お支払金額から差し引かれる税額はありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 1, "契約者変更回数");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他支払金合計", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "（明細）", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "支払利息", "摘要５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(123), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(1), "金額明細５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.JPY, "金額明細通貨種類５");
        exStringEquals(ttdkKan.getBikou1(), "２２２　円", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "必要書類の受付日翌日から５営業日を超えた２４日分", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "適用為替レート：４５６．００　円", "備考６");

    }

    @Test
    @TestOrder(230)
    public void testEditTBL_A8_4() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000166");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000166", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "基準金額を１３　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（減額後毎回円貨払込額　２００　円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.AUD, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "豪ドル", "支払通貨種類略称");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.AUD, "返金通貨種類");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他精算金", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "源泉徴収税額", "摘要３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(Long.valueOf("235")), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(Long.valueOf("1")), "金額明細２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exStringEquals(ttdkKan.getBikou1(), "２２２　円", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【適用為替レートについて】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を減額日時点の当社所定の為替レート（※１）", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　　　日とします。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言１７");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");

    }

    @Test
    @TestOrder(240)
    public void testEditTBL_A8_5() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000035");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000035", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "基準金額を１３　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（減額後毎回円貨払込額　２００　円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.AUD, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "豪ドル", "支払通貨種類略称");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.AUD, "返金通貨種類");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【適用為替レートについて】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を減額日時点の当社所定の為替レート（※１）", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　　　日とします。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　公示値とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言１７");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他支払金合計", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "（明細）", "摘要３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(Long.valueOf("9999999999999")), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.AUD, "金額明細通貨種類２");
        exStringEquals(ttdkKan.getBikou2(), "　を外貨に換算した金額です。　（１）÷（２)", "備考１");
        exStringEquals(ttdkKan.getBikou3(), "　（１）その他支払金明細の合計額（円）", "備考２");
        exStringEquals(ttdkKan.getBikou4(), "　　　１３　円", "備考３");
        exStringEquals(ttdkKan.getBikou5(), "　（２）適用為替レート：１２．００　円", "備考４");
        exStringEquals(ttdkKan.getBikou6(), "", "備考５");

    }

    @Test
    @TestOrder(250)
    public void testEditTBL_A8_6() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000306");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000306", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.AUD, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "豪ドル", "支払通貨種類略称");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.AUD, "返金通貨種類");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(123), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【適用為替レートについて】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を減額日時点の当社所定の為替レート（※１）", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　　　日とします。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　公示値とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　◆既払込保険料等は既に払い込まれた円貨払込額の合計額等です。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getZeimumongon2(), "※ご契約期間中に契約者の変更がありました。", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "　確定申告については所轄の税務署にお問い合わせください。", "税務文言３");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(99999), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 1, "契約者変更回数");

    }

    @Test
    @TestOrder(270)
    public void testEditTBL_A8_7() {

        khozenCommonParam.setSikibetuKey("20151201102134233");
        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000323");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(-1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000323", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "支払利息", "摘要２");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(15), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "必要書類の受付日翌日から５営業日を超えた２４日分", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), -1, "契約者変更回数");

    }

    @Test
    @TestOrder(280)
    public void testEditTBL_A8_8() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000334");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(-1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000334", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.AUD, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "豪ドル", "支払通貨種類略称");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.AUD, "返金通貨種類");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(123), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【適用為替レートについて】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を減額日時点の当社所定の為替レート（※１）", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　　　日とします。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　公示値とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), -1, "契約者変更回数");

    }


    @Test
    @TestOrder(285)
    public void testEditTBL_A8_9() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806000077");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "07", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "60806000077", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＢを下回ることはありません。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　◆「お手続き完了のお知らせ」は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 1, "契約者変更回数");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "支払利息", "摘要２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "必要書類の受付日翌日から５営業日を超えた２４日分", "備考２");

    }

    @Test
    @TestOrder(290)
    public void testEditTBL_A9_1() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000177");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.HHKN);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl
            .editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
                editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
                C_SyoruiCdKbn.KK_SHRKZHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "07", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000177", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SHRKZHNK_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.TARGETSYUUSINHENKOU, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.NONE, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), null, "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), null, "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.BLNK, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(0), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.BLNK, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), null, "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "12121***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.BLNK, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名（カナ）", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(300)
    public void testEditTBL_A9_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000188");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.HHKN);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl
            .editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
                editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
                C_SyoruiCdKbn.KK_SHRKZHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000188", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SHRKZHNK_TTDKKR, "書類コード");

    }

    @Test
    @TestOrder(310)
    public void testEditTBL_A9_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.HHKN);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl
            .editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
                editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
                C_SyoruiCdKbn.KK_SHRKZHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111130", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SHRKZHNK_TTDKKR, "書類コード");

    }

    @Test
    @TestOrder(320)
    public void testEditTBL_A10_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000199");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000199", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENSIHARAISV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.TARGETSYUUSINHENKOU, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), BizDate.valueOf(20160401), "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(1), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他支払金合計", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "（明細）", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "・保険料（円貨払込額）", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "・その他精算金", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "・配当金", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "・特別配当金", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "源泉徴収税額", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "支払利息", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(1), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(1), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(1), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(1), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(Long.valueOf("9999999999999")), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(Long.valueOf("1")), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.JPY, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.JPY, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.JPY, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.JPY, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.JPY, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）×（３）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）保険料積立金", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　２３，５４３　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１１０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（３）適用為替レート：４５６．００　円", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "102", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(111), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.SKS, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１６年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【解約返戻金に対する税務のご説明】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆税法上、源泉分離課税の対象となりますので、お支払金額から差し引きしています。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　お支払金額明細に記載の源泉徴収税額は復興特別所得税を含んだ金額です。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(Long.valueOf("0")), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.HU, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(330)
    public void testEditTBL_A10_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000328");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｹ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000328", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他支払金合計", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "（明細）", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "源泉徴収税額", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "支払利息", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(1), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.AUD, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.AUD, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.AUD, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）－（３）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）積立金相当額", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　２３，５４８　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１４０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（３）解約控除額（※）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "必要書類の受付日翌日から５営業日を超えた２４日分", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");

    }

    @Test
    @TestOrder(340)
    public void testEditTBL_A10_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000317");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("12806000317");
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000317", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "（明細）", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "・解約返戻金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(Long.valueOf("9999999999999")), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額＝（１）×（２）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）適用為替レート：４５６．００　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（２）解約返戻金", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　１３　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　上記解約返戻金には以下の契約変更時返戻金（注）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　　を含みます。", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "・その他支払金合計はその他支払金明細の合計額です。", "備考８");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "（注）個人年金保険料税制適格特約（’９０）付加のため、契約変更時にお預かりしていた返戻金", "支払内容補足文言１");

    }

    @Test
    @TestOrder(350)
    public void testEditTBL_A10_4() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111152");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806004752");
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111152", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(Long.valueOf("234")), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額には以下の契約変更時返戻金（注）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を含みます。", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　１　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "・その他支払金合計はその他支払金明細の合計額（円）", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　を外貨に換算した金額です。　（１）÷（２)", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（１）その他支払金明細の合計額（円）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１３　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "　（２）適用為替レート：１２．００　円", "備考８");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "（注）個人年金保険料税制適格特約（’９０）付加のため、契約変更時にお預かりしていた返戻金", "支払内容補足文言１");

    }

    @Test
    @TestOrder(360)
    public void testEditTBL_A10_5() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("16806000012");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "16806000012", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "配当金", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "特別配当金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");

    }

    @Test
    @TestOrder(370)
    public void testEditTBL_A10_101() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000080");
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000080", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.AUD, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "豪ドル", "支払通貨種類略称");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.AUD, "返金通貨種類");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(99999), "支払時契約者必要経費");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(111), "必要経費");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１６年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "※ご契約期間中に契約者の変更がありました。", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "　確定申告については所轄の税務署にお問い合わせください。", "税務文言３");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI, "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を解約日時点の当社所定の為替レート（※１）", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 1, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(Long.valueOf("0")), "源泉分離課税対象差益");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exStringEquals(ttdkKan.getBikou1(), "・その他支払金合計はその他支払金明細の合計額（円）", "備考１");

        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");

    }

    @Test
    @TestOrder(380)
    public void testEditTBL_A10_102() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000091");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000091", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.AUD, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "豪ドル", "支払通貨種類略称");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.AUD, "返金通貨種類");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(99999), "支払時契約者必要経費");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(111), "必要経費");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１６年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "※収入金額にはその他返戻金は含まれておりません。", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "※ご契約期間中に契約者の変更がありました。", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "　確定申告については所轄の税務署にお問い合わせください。", "税務文言４");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI, "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　市場金利の変動に応じた市場価格調整（※）を適用し計算するため、解約日の保険料積立金額から", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　増減します。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "【適用為替レートについて】", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を解約日時点の当社所定の為替レート（※１）", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　日とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　　　　公示値とします。", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "　◆「お手続き完了のお知らせ」は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 1, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）保険料積立金", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　２３，５４３　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１１０．００００００００％", "備考５");

    }

    @Test
    @TestOrder(390)
    public void testEditTBL_A10_103() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000105");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000105", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.AUD, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "豪ドル", "支払通貨種類略称");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.AUD, "返金通貨種類");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(111), "必要経費");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１６年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "※収入金額にはその他返戻金は含まれておりません。", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【解約返戻金に対する税務のご説明】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　　は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他返戻金※", "摘要２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.AUD, "金額明細通貨種類２");

    }

    @Test
    @TestOrder(400)
    public void testEditTBL_A10_104() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000345");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｹ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000345", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆解約返戻金額は、市場金利の変動に応じた市場価格調整（※）を適用し計算するため、市場金利の", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　変動により解約日の積立金額から増減します。また、解約時等にかかる費用（解約控除）として、", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　基準金額の一定割合（契約日からの経過年数に応じた所定の控除率）を差し引きます。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "【適用為替レートについて】", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　◆円貨支払いのご請求により、解約返戻金を外貨（指定通貨または選択通貨）にかえて解約日時点の当社", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　所定の為替レート（※１）で円貨に換算してお支払いしています。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）－５０銭」（※３）となります。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　日とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　　　　公示値とします。", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＢを下回ることはありません。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), -1, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（（１）×（２）－（３））×（４）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）積立金相当額", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　２３，５４３　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１１０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（３）解約控除額（※）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　０　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "　（４）適用為替レート：４５６．００　円", "備考８");

    }

    @Test
    @TestOrder(410)
    public void testEditTBL_A10_105() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111141");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｹ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111141", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU, "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　日とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　　　　公示値とします。", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "　◆税務取扱および申告手続の詳細については、所轄の税務署にお問い合わせください。", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）－（３）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）積立金相当額", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　２３，５４４　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１５０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（３）解約控除額（※）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　－１　円", "備考７");

    }

    @Test
    @TestOrder(420)
    public void testEditTBL_A10_106() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004752");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806004752");
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004752", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU, "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　◆税務取扱および申告手続の詳細については、所轄の税務署にお問い合わせください。", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");

    }

    @Test
    @TestOrder(430)
    public void testEditTBL_A10_107() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806000088");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("60806000088");
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "60806000088", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "（明細）", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "・解約返戻金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(Long.valueOf("9999999999999")), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額＝（１）×（２）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）適用為替レート：４５６．００　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（２）解約返戻金", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　１３　円", "備考４");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");

    }

    @Test
    @TestOrder(440)
    public void testEditTBL_A10_108() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806000099");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("60806000099");
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "60806000099", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "（明細）", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "・解約返戻金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(Long.valueOf("9999999999999")), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額＝（１）×（２）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）適用為替レート：４５６．００　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（２）解約返戻金", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　１３　円", "備考４");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");

    }

    @Test
    @TestOrder(470)
    public void testEditTBL_A11_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111163");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111163", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.TARGETSYUUSINHENKOU, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), BizDate.valueOf(20160401), "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(1), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "源泉徴収税額", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "支払利息", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(Long.valueOf("9999999999999")), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(1), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.JPY, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.JPY, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）×（３）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）保険料積立金", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　２３，５４３　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１１０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（３）適用為替レート：４５６．００　円", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "102", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.SKS, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　市場金利の変動に応じた市場価格調整（※）を適用し計算するため、解約日の保険料積立金額から", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　増減します。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "【適用為替レートについて】", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　◆円貨支払いのご請求により、解約返戻金を外貨（指定通貨または選択通貨）にかえて解約日時点の当社", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　所定の為替レート（※１）で円貨に換算してお支払いしています。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）－５０銭」（※３）となります。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　日とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　　　　公示値とします。", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＢを下回ることはありません。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 1, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(Long.valueOf("0")), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.HU, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(480)
    public void testEditTBL_A11_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111174");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｹ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "07", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111174", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getShskyno(), "", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（（１）×（２）－（３））×（４）", "備考１");
        exStringEquals(ttdkKan.getBikou6(), "　（３）解約控除額（※）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "　（４）適用為替レート：４５６．００　円", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆解約返戻金額は、市場金利の変動に応じた市場価格調整（※）を適用し計算するため、市場金利の", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　変動により解約日の積立金額から増減します。また、解約時等にかかる費用（解約控除）として、", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　基準金額の一定割合（契約日からの経過年数に応じた所定の控除率）を差し引きます。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "【適用為替レートについて】", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　◆円貨支払いのご請求により、解約返戻金を外貨（指定通貨または選択通貨）にかえて解約日時点の当社", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　所定の為替レート（※１）で円貨に換算してお支払いしています。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）－５０銭」（※３）となります。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　日とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　　　　公示値とします。", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＢを下回ることはありません。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");

    }

    @Test
    @TestOrder(490)
    public void testEditTBL_A11_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111185");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111185", "証券番号");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");

    }

    @Test
    @TestOrder(500)
    public void testEditTBL_A11_4() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111196");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111196", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");

    }

    @Test
    @TestOrder(510)
    public void testEditTBL_A11_5() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111200");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111200", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");

    }

    @Test
    @TestOrder(520)
    public void testEditTBL_A11_6() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111211");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111211", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");

    }

    @Test
    @TestOrder(530)
    public void testEditTBL_A12() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000236");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.KYKTORIKESI);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_KYKTRKS_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000236", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KYKTRKS_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.TARGETSYUUSINHENKOU, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.KYKTORIKESI, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "102", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.ITJKNSHRTYOUSYO, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(540)
    public void testEditTBL_A13_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111222");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_KAIGOMAETKHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111222", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIGOMAETKHNK_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.NONE, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "　＊＊確認事項＊＊", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "　特約中途付加のお申込みのときに「重度介護前払特約中途付加のしおり・約款」を同封していますので", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　大切に保管くださいますようお願いいたします。", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), null, "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), null, "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.BLNK, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(0), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.BLNK, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), null, "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.BLNK, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(550)
    public void testEditTBL_A13_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111233");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.BLNK);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_KAIGOMAETKHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111233", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIGOMAETKHNK_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");

    }

    @Test
    @TestOrder(560)
    public void testEditTBL_A14_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111244");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111244", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.SBMUKOU_KIHRKPSHR, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(2.22, BizCurrencyTypes.AU_DOLLAR), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(570)
    public void testEditTBL_A14_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000214");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000214", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.SBKAIJO, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(1), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他支払金合計", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "（明細）", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "・保険料（円貨払込額）", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "・その他精算金", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "・配当金", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "・特別配当金", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "支払利息", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(1), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(1), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(1), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(1), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(1), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.JPY, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.JPY, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.JPY, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.JPY, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "外貨金額：１３　円", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "為替レート：１豪ドル　＝　４５６．００　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "換算基準日：２０１６年　４月　２日", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "102", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(580)
    public void testEditTBL_A14_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000225");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000225", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他支払金合計", "摘要２");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");

    }

    @Test
    @TestOrder(590)
    public void testEditTBL_A14_4() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000247");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000247", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他支払金合計", "摘要２");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");

    }

    @Test
    @TestOrder(600)
    public void testEditTBL_A14_5() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000258");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBMENSEKI);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000258", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "支払利息", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.AUD, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "必要書類の受付日翌日から５営業日を超えた２４日分", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");

    }

    @Test
    @TestOrder(610)
    public void testEditTBL_A14_6() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000269");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBMENSEKI);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000269", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");

    }

    @Test
    @TestOrder(620)
    public void testEditTBL_A14_7() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000270");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBMENSEKI);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "07", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000270", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");

    }

    @Test
    @TestOrder(621)
    public void testEditTBL_A14_8() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004006");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004006", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.SBKAIJO, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(1), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "配当金", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "特別配当金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "支払利息", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(1), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(1), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "102", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(622)
    public void testEditTBL_A14_9() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004017");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004017", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");

    }

    @Test
    @TestOrder(623)
    public void testEditTBL_A14_10() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004028");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004028", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");

    }

    @Test
    @TestOrder(630)
    public void testEditTBL_A14_11() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000281");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000281", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");

    }

    @Test
    @TestOrder(634)
    public void testEditTBL_A14_12() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806000103");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "60806000103", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.SBMUKOU_KIHRKPSHR, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(2.22, BizCurrencyTypes.AU_DOLLAR), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(638)
    public void testEditTBL_A14_13() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806000114");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "60806000114", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.SBMUKOU_KIHRKPSHR, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他精算金", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(2.22, BizCurrencyTypes.AU_DOLLAR), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(640)
    public void testEditTBL_A15_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000339");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000339", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "102", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(641)
    public void testEditTBL_A15_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004660");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004660", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.SBKAIJO, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(0.01, BizCurrencyTypes.AU_DOLLAR), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "支払利息", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0.01, BizCurrencyTypes.AU_DOLLAR), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "外貨金額：１３　円", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "為替レート：１豪ドル　＝　４５６．００　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "換算基準日：２０１６年　４月　２日", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "102", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(642)
    public void testEditTBL_A15_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004671");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBMENSEKI);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "07", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004671", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "支払利息", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(100), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.AUD, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "必要書類の受付日翌日から５営業日を超えた２４日分", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");

    }

    @Test
    @TestOrder(643)
    public void testEditTBL_A15_4() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004682");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBMENSEKI);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004682", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");

    }

    @Test
    @TestOrder(645)
    public void testEditTBL_A15_5() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004693");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004693", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");

    }

    @Test
    @TestOrder(650)
    public void testEditTBL_A16_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000340");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000340", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(651)
    public void testEditTBL_A16_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004707");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004707", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.SBKAIJO, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(0.01, BizCurrencyTypes.AU_DOLLAR), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "支払利息", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0.01, BizCurrencyTypes.AU_DOLLAR), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "外貨金額：１３　円", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "為替レート：１豪ドル　＝　４５６．００　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "換算基準日：２０１６年　４月　２日", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "102", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(652)
    public void testEditTBL_A16_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004718");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBMENSEKI);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004718", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "支払利息", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(100), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.AUD, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "必要書類の受付日翌日から５営業日を超えた２４日分", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");

    }

    @Test
    @TestOrder(653)
    public void testEditTBL_A16_4() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004729");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBMENSEKI);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004729", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");

    }

    @Test
    @TestOrder(655)
    public void testEditTBL_A16_5() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004730");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004730", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");

    }

    @Test
    @TestOrder(660)
    public void testEditTBL_A17_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000116");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000116", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "［税務に関するお知らせ］", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "・この通知は確定申告の際の参考資料になります。", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "・以下の金額で「保険契約者等の異動に関する調書」が作成されます。", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "　　解約返戻金相当額：　　　　　　　　　　　　　　１，０００，００１　円", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "　　既払込保険料等の総額：　　　　　　　　　　　　　　９９９，９９９　円", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　　直前契約者様の払込保険料等：　　　　　　　　　　　９９９，９９９　円", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "　　※生命保険契約における契約者変更に伴う相続については、", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "　　　解約返戻金相当額が権利の評価額とみなされます。", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "　　　詳細については、税務署・税理士等にご確認ください。", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(670)
    public void testEditTBL_A17_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000286");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000286", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(680)
    public void testEditTBL_A17_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000297");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000297", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(690)
    public void testEditTBL_A17_4() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000301");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000301", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(700)
    public void testEditTBL_A17_5() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000312");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000312", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(710)
    public void testEditTBL_A18_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000127");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000127", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(720)
    public void testEditTBL_A18_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000149");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000149", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(730)
    public void testEditTBL_A18_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000138");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000138", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.KYK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(111), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(740)
    public void testEditTBL_A18_4() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.KYK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(111), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(99999), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 1, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(750)
    public void testEditTBL_A18_5() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000367");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(-1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000367", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.KYK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(111), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), -1, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(760)
    public void testEditTBL_A19_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111255");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(-1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        editTtdkKanryouParam.setTargetTkMkhtKbn(C_TargetTkMokuhyoutiKbn.TARGET110);
        editTtdkKanryouParam.setTargetTkKykHenkouYmd(BizDate.valueOf(20171205));
        editTtdkKanryouParam.setTargetTkKbn(C_TargetTkKbn.SYUUSIN);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111255", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.DAIRITENJIMUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.ARI, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "目標額：基準金額の１１０％に変更しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "変更日：２０１７年１２月　５日", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.KYK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");

    }

    @Test
    @TestOrder(761)
    public void testEditTBL_A19_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004039");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(-1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        editTtdkKanryouParam.setTargetTkMkhtKbn(C_TargetTkMokuhyoutiKbn.TARGET110);
        editTtdkKanryouParam.setTargetTkKykHenkouYmd(BizDate.valueOf(20171205));
        editTtdkKanryouParam.setTargetTkKbn(C_TargetTkKbn.NENKIN);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004039", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "目標額：円建基準金額の１１０％に変更しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "変更日：２０１７年１２月　５日", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(770)
    public void testEditTBL_A19_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111266");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(-1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        editTtdkKanryouParam.setTargetTkMkhtKbn(C_TargetTkMokuhyoutiKbn.NOTARGET);
        editTtdkKanryouParam.setTargetTkKykHenkouYmd(BizDate.valueOf(20171205));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111266", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.DAIRITENJIMUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.ARI, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "目標額：目標額の設定を撤回しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "変更日：２０１７年１２月　５日", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(15), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "101", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "野江支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.KYK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(771)
    public void testEditTBL_A19_4() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004741");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(-1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        editTtdkKanryouParam.setTargetTkMkhtKbn(C_TargetTkMokuhyoutiKbn.TARGET110);
        editTtdkKanryouParam.setTargetTkKykHenkouYmd(BizDate.valueOf(20171205));
        editTtdkKanryouParam.setTargetTkKbn(C_TargetTkKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004741", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "目標額：１１０％に変更しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "変更日：２０１７年１２月　５日", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(800)
    public void testEditTBL_A20_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004512");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004512", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.DAIRITENJIMUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.TARGETSYUUSINHENKOU, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(1), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "その他返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "支払利息", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "円建変更時返戻金", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "102", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.SKS, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(810)
    public void testEditTBL_A20_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004523");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004523", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getTekiyou1(), "その他返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "円建変更時返戻金", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");

    }

    @Test
    @TestOrder(820)
    public void testEditTBL_A20_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004534");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004534", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "その他返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "円建変更時返戻金", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");

    }

    @Test
    @TestOrder(830)
    public void testEditTBL_A21_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004545");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf(20180801));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004545", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.DAIRITENJIMUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.TARGETSYUUSINHENKOU, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "●変更内容", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "積立金を指数連動部分から定率積立部分に移転します。", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "移転日　２０１８年　８月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "●変更後の内容について", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　・積立金移転後の積立金額は移転日以降にお送りします「ご契約内容のお知らせ」でご確認ください。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "　・定率積立へ移転後は、積立金（定率積立部分）から積立金（指数連動部分）へ戻すことはできません。", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(1), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "102", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.SKS, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(840)
    public void testEditTBL_A21_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004556");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004556", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "積立金移転手続きを取消しします。", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");

    }

    @Test
    @TestOrder(850)
    public void testEditTBL_A21_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004567");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004567", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");

    }

    @Test
    @TestOrder(860)
    public void testEditTBL_A22_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004578");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1111));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(9999));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(5555));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(8888));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2222));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(8888));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.JPY);
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(7777));
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(6666));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "07", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004578", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.MKHGKTTTYENDTHNK, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "６６，６６０　円（基準金額（※１）の１０００％）", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(5555), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(8888), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "（※１）基準金額は６，６６６　円です。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（※２）到達日の解約返戻金額は９，９９９　円です。", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　　　（円換算に使用した為替レート：１円＝２，２２２．００円）", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "（※３）円建終身保険の原資となる解約返戻金の円換算額は８，８８８　円です。", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "　　　　到達日の解約返戻金の円換算額との差額を円建変更時返戻金額としてお支払いいたします。", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　　　　お手続き方法などの詳細につきましては、裏面をご確認くださいますようお願いいたします。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "変更後の契約内容詳細につきましては、同封の保険証券をご確認ください。", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "代理店事務サービス室", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(1), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "102", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.SKS, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(870)
    public void testEditTBL_A22_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004589");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1111));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(9999));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(5555));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(8888));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2222));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(1));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.JPY);
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(7777));
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(6666));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004589", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(1), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類２");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "（※１）基準金額は６，６６６　円です。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "　　　（円換算に使用した為替レート：１円＝１，１１１．００円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "（※２）到達日の解約返戻金額は９，９９９　円です。", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "　　　（円換算に使用した為替レート：１円＝２，２２２．００円）", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "（※３）円建終身保険の原資となる解約返戻金の円換算額は８，８８８　円です。", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　　　　到達日の解約返戻金の円換算額との差額を円建変更時返戻金額としてお支払いいたします。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "　　　　お手続き方法などの詳細につきましては、裏面をご確認くださいますようお願いいたします。", "手続内容７");

    }

    @Test
    @TestOrder(880)
    public void testEditTBL_A22_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004590");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.YENDTHNKNINI_NEN);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1111));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(6666));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(5555));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(8888));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2222));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(0));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.JPY);
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(7777));
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(6666));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004590", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR, "書類コード");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "（※）基準金額は「変更請求日の解約返戻金額（６，６６６　円）の円換算額", "手続内容１");

    }

    @Test
    @TestOrder(890)
    public void testEditTBL_A22_4() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004604");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1111));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(9999));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(5555));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(8888));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2222));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(-1));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.JPY);
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(7777));
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(6666));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004604", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR, "書類コード");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");

    }

    @Test
    @TestOrder(900)
    public void testEditTBL_A23_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004615");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1111));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(9999));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(5555));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(8888));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2222));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(8888));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.JPY);
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(7777));
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(6666));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004615", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "7654321", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "漢字組織住所２１", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "漢字組織住所３１", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getTetudukisyukbn(), C_TetudukisyuKbn.MKHGKTTTYENDTHNK, "手続種類区分");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "商品名（証券用）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exClassificationEquals(ttdkKan.getYenshrtktekiumu(), C_UmuKbn.ARI, "円支払特約適用有無");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "６６，６６０　円（基準金額（※１）の１０００％）", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(5555), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(8888), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "（※１）基準金額は６，６６６　円です。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（※２）到達日の解約返戻金額は９，９９９　円です。", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　　　（円換算に使用した為替レート：１円＝２，２２２．００円）", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "変更後の契約内容詳細につきましては、同封の保険証券をご確認ください。", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
        exDateEquals(ttdkKan.getShrymd(), BizDate.valueOf(20160401), "支払日");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exDateEquals(ttdkKan.getKaiykymd(), null, "解約日");
        exClassificationEquals(ttdkKan.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(ttdkKan.getShrtuukasyuryk(), "円", "支払通貨種類略称");
        exBizCalcbleEquals(ttdkKan.getShrgkkei(), BizCurrency.valueOf(888), "支払額合計");
        exBizCalcbleEquals(ttdkKan.getHnkngk(), BizCurrency.valueOf(888), "返金額");
        exClassificationEquals(ttdkKan.getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(ttdkKan.getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(1), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");
        exStringEquals(ttdkKan.getBankcd(), "1001", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "102", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(ttdkKan.getKouzano(), "10101***", "口座番号");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "口座名義人氏名", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exClassificationEquals(ttdkKan.getHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "法定資料種類区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getKaiyakujiyuu(), C_Kaiyakujiyuu.SKS, "解約事由");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exClassificationEquals(ttdkKan.getYendthnkzeimuinfohskkbn(), C_YendthnkzeimuinfohskKbn.BLNK, "円建変更時税務情報補足区分");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(910)
    public void testEditTBL_A23_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004626");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1111));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(9999));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(5555));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(8888));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2222));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(1));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.JPY);
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(7777));
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(6666));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004626", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "通信先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "通信先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "通信先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "契約者名", "送付先氏名（漢字）");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(1), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類２");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "（※１）基準金額は６，６６６　円です。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "　　　（円換算に使用した為替レート：１円＝１，１１１．００円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "（※２）到達日の解約返戻金額は９，９９９　円です。", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "　　　（円換算に使用した為替レート：１円＝２，２２２．００円）", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "変更後の契約内容詳細につきましては、同封の保険証券をご確認ください。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");

    }

    @Test
    @TestOrder(920)
    public void testEditTBL_A23_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004637");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1111));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(9999));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(5555));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(8888));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2222));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(0));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.JPY);
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(7777));
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(6666));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004637", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR, "書類コード");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");

    }

    @Test
    @TestOrder(930)
    public void testEditTBL_A23_4() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004648");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1111));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(9999));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(5555));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(8888));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2222));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(-1));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.JPY);
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(7777));
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(6666));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806004648", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR, "書類コード");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");

    }

    @Test
    @TestOrder(940)
    public void testEditTBL_A24_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806345672");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);
        editTtdkKanryouParam.setTmtthtkinzndk(BizCurrency.valueOf(2));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DSHR_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "07", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806345672", "証券番号");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_DSHR_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.SYUUNOUSV, "担当室区分");
        exBizCalcbleEquals(ttdkKan.getShrtienrsk(), BizCurrency.valueOf(0.01, BizCurrencyTypes.AU_DOLLAR), "支払遅延利息");
        exStringEquals(ttdkKan.getTekiyou1(), "配当金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "支払利息", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0.01, BizCurrencyTypes.AU_DOLLAR), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "必要書類の受付日翌日から５営業日を超えた２３日分", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getOsirasemongon1(), "＜ご連絡事項＞", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　配当金は円貨でお支払いします。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　今回のお支払の結果、積立配当金残高は　2 円　になりました。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");

    }

    @Test
    @TestOrder(950)
    public void testEditTBL_A24_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("30806123469");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmtthtkinzndk(BizCurrency.valueOf(2));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DSHR_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "30806123469", "証券番号");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_DSHR_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "配当金", "摘要1");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要2");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(235), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getOsirasemongon1(), "＜ご連絡事項＞", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　配当金は円貨でお支払いします。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　今回のお支払の結果、積立配当金残高は　2 円　になりました。", "お知らせ文言３");

    }

    @Test
    @TestOrder(960)
    public void testEditTBL_A24_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("30806123458");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmtthtkinzndk(BizCurrency.valueOf(2));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DSHR_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "30806123458", "証券番号");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_DSHR_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "配当金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(235), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.AUD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
    }

    @Test
    @TestOrder(970)
    public void testEditTBL_A25_1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806000011");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "60806000011", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "基準金額を１３　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（減額後毎回円貨払込額　２００　円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "＜お預り金内容＞", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "　個人年金保険料税制適格特約（’９０）が付加されているため、減額部分の解約返戻金およびその他の支払金は、当社", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　所定の利率で利息をつけてすえ置いておき、年金支払開始日に年金額の増額に充てられます。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "　減額部分の解約返戻金　　　　　　　　　　　　　　　　　　　　　　　　０　円", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "　その他支払金（以下の合計）　　　　　　　　　　　　　　　　　　　１　円", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "　　保険料（円貨払込額）　　　　　　　　　　　　　　　　　　　　　１　円", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "　　その他精算金　　　　　　　　　　　　　　　　　　　　　　　　　１　円", "手続内容１０");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(980)
    public void testEditTBL_A25_2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806000022");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "60806000022", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "基準金額を１３　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（減額後毎回円貨払込額　２００　円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "＜お預り金内容＞", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "　個人年金保険料税制適格特約（’９０）が付加されているため、減額部分の解約返戻金およびその他の支払金は、当社", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　所定の利率で利息をつけてすえ置いておき、年金支払開始日に年金額の増額に充てられます。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "　減額部分の解約返戻金　　　　　　　　　　　　　　　　　　　　　　　　０　円", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "　その他支払金（以下の合計）　　　　　　　　　　　　　　　　　　　１　円", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "　　保険料（円貨払込額）　　　　　　　　　　　　　　　　　　　　　１　円", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");

    }

    @Test
    @TestOrder(990)
    public void testEditTBL_A25_3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806000033");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "60806000033", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "基準金額を１３　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（減額後毎回円貨払込額　２００　円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "＜お預り金内容＞", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "　個人年金保険料税制適格特約（’９０）が付加されているため、減額部分の解約返戻金およびその他の支払金は、当社", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　所定の利率で利息をつけてすえ置いておき、年金支払開始日に年金額の増額に充てられます。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "　減額部分の解約返戻金　　　　　　　　　　　　　　　　　　　　　　　　０　円", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "　その他支払金（以下の合計）　　　　　　　　　　　　　　　　　　　１　円", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "　　保険料（円貨払込額）　　　　　　　　　　　　　　　　　　　　　１　円", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
    }

    @Test
    @TestOrder(1000)
    public void testEditTBL_A25_4() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806000044");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "60806000044", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "基準金額を１３　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（減額後毎回円貨払込額　２００　円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "＜お預り金内容＞", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "　個人年金保険料税制適格特約（’９０）が付加されているため、減額部分の解約返戻金およびその他の支払金は、当社", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　所定の利率で利息をつけてすえ置いておき、年金支払開始日に年金額の増額に充てられます。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "　減額部分の解約返戻金　　　　　　　　　　　　　　　　　　　　　　　　０　円", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "　その他支払金（以下の合計）　　　　　　　　　　　　　　　　　　　１　円", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "　　その他精算金　　　　　　　　　　　　　　　　　　　　　　　　　１　円", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");

    }

    @Test
    @TestOrder(1010)
    public void testEditTBL_A25_5() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806000055");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "60806000055", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "基準金額を１３　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（減額後毎回円貨払込額　２００　円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "＜お預り金内容＞", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "　個人年金保険料税制適格特約（’９０）が付加されているため、減額部分の解約返戻金およびその他の支払金は、当社", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　所定の利率で利息をつけてすえ置いておき、年金支払開始日に年金額の増額に充てられます。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "　減額部分の解約返戻金　　　　　　　　　　　　　　　　　　　　　　　　０　円", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "　その他支払金（以下の合計）　　　　　　　　　　　　　　　　　　　１　円", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");

    }

    @Test
    @TestOrder(1020)
    public void testEditTBL_A25_6() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806000066");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "60806000066", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "基準金額を１３　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（減額後毎回円貨払込額　２００　円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "＜お預り金内容＞", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "　個人年金保険料税制適格特約（’９０）が付加されているため、減額部分の解約返戻金およびその他の支払金は、当社", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　所定の利率で利息をつけてすえ置いておき、年金支払開始日に年金額の増額に充てられます。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "　減額部分の解約返戻金　　　　　　　　　　　　　　　　　　　　　　　　０　円", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "　その他支払金（以下の合計）　　　　　　　　　　　　　　　　　　　１　円", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");

    }

    @Test
    @TestOrder(1030)
    public void testEditTBL_A25_7() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806000125");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "60806000125", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "基準金額を１３　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（減額後毎回円貨払込額　２００　円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "＜お預り金内容＞", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "　個人年金保険料税制適格特約（’９０）が付加されているため、減額部分の解約返戻金およびその他の支払金は、当社", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　所定の利率で利息をつけてすえ置いておき、年金支払開始日に年金額の増額に充てられます。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "　減額部分の解約返戻金　　　　　　　　　　　　　　　　　　　　　　　　０　円", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");

    }

    @Test
    @TestOrder(1040)
    public void testEditTBL_A25_8() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");

        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806000136");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "60806000136", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "基準金額を１３　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（減額後毎回円貨払込額　２００　円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "＜お預り金内容＞", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "　個人年金保険料税制適格特約（’９０）が付加されているため、減額部分の解約返戻金およびその他の支払金は、当社", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　所定の利率で利息をつけてすえ置いておき、年金支払開始日に年金額の増額に充てられます。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "　減額部分の解約返戻金　　　　　　　　　　　　　　　　　　　　　　　　０　円", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
    }
}