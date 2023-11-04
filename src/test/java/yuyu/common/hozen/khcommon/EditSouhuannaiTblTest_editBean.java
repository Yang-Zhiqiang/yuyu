package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
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
import yuyu.common.direct.dscommon.CheckDsTorihikiService;
import yuyu.common.direct.dscommon.CheckDsTorihikiServiceMockForHozen;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_JyudkaigomaebaraiTkykhnkKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_Khhrshrjiyuu;
import yuyu.def.classification.C_Khskssakuseijiyuu;
import yuyu.def.classification.C_KykMsnKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_MousideIkouKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_NstkhKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TargetTkHenkouKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.hozen.bean.report.KhHanyouSouhuannaiBean;
import yuyu.def.hozen.bean.report.KhSouhuannaiBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.auth.RayHttpHeaderBean;
import yuyu.infr.auth.RayHttpHeaderBeanMockForHozen;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 送付案内TBL編集クラスのメソッド {@link EditSouhuannaiTbl#editBean(C_SyoruiCdKbn, String, KhozenCommonParam, EditSouhuannaiParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSouhuannaiTblTest_editBean extends AbstractTest{

    private final static String syono0 = "12806345672";
    private final static String syono1 = "12806345683";
    private final static String syono2 = "12806345694";
    private final static String syono3 = "12806345708";
    private final static String syono4 = "17806000013";
    private final static String syono5 = "17806000024";
    private final static String syono6 = "99806030513";
    private final static String syono7 = "99806030524";
    private final static String syono8 = "17806000301";
    private final static String syono9 = "17806000297";
    private final static String syono10 = "17806000286";
    private final static String syono11 = "17810000016";
    private static String hokenKaisyaNmKanji;
    private static String callcentersosikicd;
    private static String uketimecallcenter1;
    private static String uketimecallcenter2;
    private static String uketimetantousitu1;
    private static String uketimetantousitu2;

    @Inject
    private EditSouhuannaiParam editSouhuannaiParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private EditSouhuannaiTbl editSouhuannaiTbl;

    private final static String fileName = "UT_SP_単体テスト仕様書_送付案内TBL編集";

    private final static String sheetName = "テストデータ";

    @Inject
    private AS_Kinou kinoInfo;

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.caller =null;
        CheckDsTorihikiServiceMockForHozen.SYORIPTN =null;
        RayHttpHeaderBeanMockForHozen.caller = null;
        RayHttpHeaderBeanMockForHozen.SYORIPTN = null;

    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckDsTorihikiService.class).to(CheckDsTorihikiServiceMockForHozen.class);
                bind(RayHttpHeaderBean.class).to(RayHttpHeaderBeanMockForHozen.class);
            }
        });
        CheckDsTorihikiServiceMockForHozen.caller = EditSouhuannaiTblTest_editBean.class;
        RayHttpHeaderBeanMockForHozen.caller = EditSouhuannaiTblTest_editBean.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSouhuannaiTblTest_editBean.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
            hokenKaisyaNmKanji = YuyuBizConfig.getInstance().getHokenKaisyaNmKanji();
            callcentersosikicd = YuyuBizConfig.getInstance().getCallcentersosikicd();
            uketimecallcenter1 = YuyuBizConfig.getInstance().getUketimecallcenter1();
            uketimecallcenter2 = YuyuBizConfig.getInstance().getUketimecallcenter2();
            uketimetantousitu1 = YuyuBizConfig.getInstance().getUketimetantousitu1();
            uketimetantousitu2 = YuyuBizConfig.getInstance().getUketimetantousitu2();
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
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllSosikiMadoguti());
        hozenDomManager.delete(hozenDomManager.getAllKhTyouhyoumsg2());
        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji(hokenKaisyaNmKanji);
        YuyuBizConfig.getInstance().setCallcentersosikicd(callcentersosikicd);
        YuyuBizConfig.getInstance().setUketimecallcenter1(uketimecallcenter1);
        YuyuBizConfig.getInstance().setUketimecallcenter2(uketimecallcenter2);
        YuyuBizConfig.getInstance().setUketimetantousitu1(uketimetantousitu1);
        YuyuBizConfig.getInstance().setUketimetantousitu2(uketimetantousitu2);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testEditBean_A1() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khsouhuannaisakusei");
        kinoInfo.setCategoryId("khcommon");

        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("1234567");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);

        try{

            editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono0, khozenCommonParam, editSouhuannaiParam);
        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。契約保全帳票メッセージMSTにデータが存在しません。", "エラーメッセージ");
            throw e;

        }
    }

    @Test
    @TestOrder(20)
    public void testEditBean_A2() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khsouhuannaisakusei");
        kinoInfo.setCategoryId("khcommon");

        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_SOUHUANNAI, syono1, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_SOUHUANNAI.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono1, "検索キー");

        KhHanyouSouhuannaiBean khHanyouSouhuannaiBean = (KhHanyouSouhuannaiBean)kHSBean[0];

        exStringEquals(khHanyouSouhuannaiBean.getIrHanyoushannaityouhyounm(), "汎用送付案内帳票名", "（ＩＲ）汎用送付案内帳票名");
        exStringEquals(khHanyouSouhuannaiBean.getIrHanyoushannaiinjinaiyou(), "汎用送付案内印字内容", "（ＩＲ）汎用送付案内印字内容");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "7654321", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "保険会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名０１組織区分名０１", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "testUser01", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "777-8888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "漢字組織住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "漢字組織住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(),null ,"（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), null, "（ＩＲ）問合せ先電話受付可能時間２");

    }

    @Test
    @TestOrder(30)
    public void testEditBean_A3() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setCategoryId("khcommon");

        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test02");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("1234567");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_SOUHUANNAI, syono1, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_SOUHUANNAI.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono1, "検索キー");

        KhHanyouSouhuannaiBean khHanyouSouhuannaiBean = (KhHanyouSouhuannaiBean)kHSBean[0];

        exStringEquals(khHanyouSouhuannaiBean.getIrHanyoushannaityouhyounm(), "汎用送付案内帳票名", "（ＩＲ）汎用送付案内帳票名");
        exStringEquals(khHanyouSouhuannaiBean.getIrHanyoushannaiinjinaiyou(), "汎用送付案内印字内容", "（ＩＲ）汎用送付案内印字内容");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "送付先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "送付先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "送付先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "送付先氏名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "保険会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名０１組織区分名０１", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "testUser01", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "777-8888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "漢字組織住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "漢字組織住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), null, "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), null, "（ＩＲ）問合せ先電話受付可能時間２");

    }

    @Test
    @TestOrder(40)
    public void testEditBean_A4() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");

        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("1234567");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYKSB);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.ARI);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(10000));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180301"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180306"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setCalckijyunymd(BizDate.valueOf("20180308"));
        editSouhuannaiParam.setTmtthtkinzndk(BizCurrency.valueOf(1));

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU, syono2, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono2, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ１０", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono2, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.ARI, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYKSB, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk118　101", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh02", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.MISEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(10000), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 1日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月 6日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.NONE, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.KA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY, "（ＩＲ）積立金配分状態");
        exStringEquals(khSouhuannaiBean.getIrCalckijyunymd(),"2018年 3月 8日", "（ＩＲ）計算基準日");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTmtthtkinzndk(), BizCurrency.valueOf(1), "（ＩＲ）積立配当金残高");
        exClassificationEquals(khSouhuannaiBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrKykjyoutai(), C_Kykjyoutai.HARAIZUMI, "（ＩＲ）契約状態");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.NONE, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");
        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "7654321", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "保険会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名０１組織区分名０１", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "testUser01", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "777-8888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "漢字組織住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "漢字組織住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), null, "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), null, "（ＩＲ）問合せ先電話受付可能時間２");


        exStringEquals((String) MockObjectManager.getArgument(
            SyouhinUtil.class, "hantei", 0, 0), "MD11", "商品コード");

    }

    @Test
    @TestOrder(50)
    public void testEditBean_A5() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");
        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("1234567");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.ARI);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.KOBETUKANSYOU);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180305"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180310"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setSyoumetuymd(BizDate.valueOf("20190315"));
        editSouhuannaiParam.setHaraimodosikngk(BizCurrency.valueOf(99999999));

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU, syono1, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono1, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ１０", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono1, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.ARI, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.BLNK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk118　102", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）FATCA確認要否区分");

        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh02", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.SEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(0), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.KOBETUKANSYOU, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 5日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月10日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.ARI, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.HUKA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY, "（ＩＲ）積立金配分状態");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenuktkkahikbn(), C_KahiKbn.HUKA, "（ＩＲ）積立金移転受付可否区分");
        exStringEquals(khSouhuannaiBean.getIrSyoumetuymd(), "2019年 3月15日", "（ＩＲ）消滅日");
        exBizCalcbleEquals(khSouhuannaiBean.getIrHaraimodosikngk(), BizCurrency.valueOf(99999999), "（ＩＲ）払戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.NONE, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "送付先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "送付先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "送付先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "送付先氏名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "保険会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名０１組織区分名０１", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "testUser01", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "777-8888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "漢字組織住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "漢字組織住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), null, "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), null, "（ＩＲ）問合せ先電話受付可能時間２");

    }

    @Test
    @TestOrder(60)
    public void testEditBean_A6() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;


        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");
        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180305"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180310"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.ARI);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU, syono3, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono3, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ１０", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono3, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.NONE, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.BLNK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.BLNK, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk118　0", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");

        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh01", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.SEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(0), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 5日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月10日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.ARI, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.HUKA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.SISUU_ONLY, "（ＩＲ）積立金配分状態");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.NONE, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "保険会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名０１組織区分名０１", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "testUser01", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "777-8888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "漢字組織住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "漢字組織住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), null, "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(),null ,"（ＩＲ）問合せ先電話受付可能時間２");

    }

    @Test
    @TestOrder(70)
    public void testEditBean_A7() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;


        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");
        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);

        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.KYKSB);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(50000));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180305"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180310"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setTmttknitenuktkkahikbn(C_KahiKbn.KA);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU, syono3, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono3, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ１０", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono3, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.NONE, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.BLNK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.BLNK, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk119　201", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");

        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh01", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.SEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(50000), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.KYKSB, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.ITEN, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 5日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月10日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.ARI, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.HUKA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.SISUU_ONLY, "（ＩＲ）積立金配分状態");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenuktkkahikbn(), C_KahiKbn.KA, "（ＩＲ）積立金移転受付可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.NONE, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "保険会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名０１組織区分名０１", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "testUser01", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "777-8888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "漢字組織住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "漢字組織住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), null, "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), null, "（ＩＲ）問合せ先電話受付可能時間２");

    }

    @Test
    @TestOrder(80)
    public void testEditBean_A8() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;


        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");
        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);

        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(50000));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180305"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180310"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.ARI);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU, syono3, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono3, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ１０", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono3, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.NONE, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.BLNK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.BLNK, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk119　202", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");

        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh01", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.SEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(50000), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.ITEN_TORIKESI, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 5日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月10日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.ARI, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.HUKA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.SISUU_ONLY, "（ＩＲ）積立金配分状態");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenuktkkahikbn(), C_KahiKbn.HUKA, "（ＩＲ）積立金移転受付可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.NONE, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "保険会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名０１組織区分名０１", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "testUser01", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "777-8888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "漢字組織住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "漢字組織住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), null, "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), null, "（ＩＲ）問合せ先電話受付可能時間２");

    }

    @Test
    @TestOrder(90)
    public void testEditBean_A9() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;


        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");
        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);

        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(50000));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180305"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180310"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.ARI);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU, syono3, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono3, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ１０", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono3, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.NONE, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.BLNK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.BLNK, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk119　0", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");

        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh01", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.SEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(50000), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 5日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月10日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.ARI, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.HUKA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.SISUU_ONLY, "（ＩＲ）積立金配分状態");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenuktkkahikbn(), C_KahiKbn.HUKA, "（ＩＲ）積立金移転受付可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.NONE, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "保険会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名０１組織区分名０１", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "testUser01", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "777-8888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "漢字組織住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "漢字組織住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), null, "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), null, "（ＩＲ）問合せ先電話受付可能時間２");

    }

    @Test
    @TestOrder(100)
    public void testEditBean_A10() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");
        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);

        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(0));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180305"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180310"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setMynosinkokutaisyouumukbn(C_UmuKbn.ARI);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU, syono3, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono3, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ１０", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono3, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.NONE, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.BLNK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.BLNK, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk150　0", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");

        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh01", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.SEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(0), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 5日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月10日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.ARI, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.HUKA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.SISUU_ONLY, "（ＩＲ）積立金配分状態");
        exStringEquals(khSouhuannaiBean.getIrKykymd(), "2019年 9月23日", "（ＩＲ）契約日");
        exClassificationEquals(khSouhuannaiBean.getIrMynosinkokutaisyouumukbn(), C_UmuKbn.ARI, "（ＩＲ）マイナンバー申告対象有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.NONE, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月27日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "保険会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名０１組織区分名０１", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "testUser01", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "777-8888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "漢字組織住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "漢字組織住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), null, "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), null, "（ＩＲ）問合せ先電話受付可能時間２");

    }

    @Test
    @TestOrder(110)
    public void testEditBean_A11() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");
        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(0));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180305"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180310"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setMynosinkokutaisyouumukbn(C_UmuKbn.ARI);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU, syono4, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU.getValue());

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "9999995", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "受取人住所１５", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "受取人住所２５", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "受取人住所３５", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "受取人名（漢字）５", "（ＩＲ）送付先氏名（漢字）");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];
        exClassificationEquals(khSouhuannaiBean.getIrKykdrknhatudoujyoutai(),C_KykdrknHtdjytKbn.SETTEI, "（ＩＲ）契約者代理権発動状態");
    }

    @Test
    @TestOrder(120)
    public void testEditBean_A12() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");
        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(0));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180305"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180310"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setMynosinkokutaisyouumukbn(C_UmuKbn.ARI);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU, syono5, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU.getValue());

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "7654321", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];
        exClassificationEquals(khSouhuannaiBean.getIrKykdrknhatudoujyoutai(),C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");

    }

    @Test
    @TestOrder(130)
    public void testEditBean_A13() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khsouhuannaisakusei");
        kinoInfo.setCategoryId("khcommon");
        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khsouhuannaisakusei");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("");

        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(0));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180305"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180310"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setMynosinkokutaisyouumukbn(C_UmuKbn.ARI);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU, syono4, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU.getValue());

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "9999995", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "受取人住所１５", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "受取人住所２５", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "受取人住所３５", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "受取人名（漢字）５", "（ＩＲ）送付先氏名（漢字）");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];
        exClassificationEquals(khSouhuannaiBean.getIrKykdrknhatudoujyoutai(),C_KykdrknHtdjytKbn.SETTEI, "（ＩＲ）契約者代理権発動状態");

    }

    @Test
    @TestOrder(140)
    public void testEditBean_A14() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khsouhuannaisakusei");
        kinoInfo.setCategoryId("khcommon");
        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khsouhuannaisakusei");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("");

        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(0));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180305"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180310"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setMynosinkokutaisyouumukbn(C_UmuKbn.ARI);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU, syono5, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU.getValue());

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "7654321", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];
        exClassificationEquals(khSouhuannaiBean.getIrKykdrknhatudoujyoutai(),C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");

    }

    @Test
    @TestOrder(150)
    public void testEditBean_A15() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khsouhuannaisakusei");
        kinoInfo.setCategoryId("khcommon");
        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khsouhuannaisakusei");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("1234567");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");

        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(0));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180305"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180310"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setMynosinkokutaisyouumukbn(C_UmuKbn.ARI);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU, syono5, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU.getValue());

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "送付先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "送付先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "送付先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "送付先氏名", "（ＩＲ）送付先氏名（漢字）");
    }

    @Test
    @TestOrder(160)
    public void testEditBean_A16() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khsouhuannaisakusei");
        kinoInfo.setCategoryId("khcommon");
        changeSystemDate(BizDate.valueOf(2015, 12, 27));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khsouhuannaisakusei");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("1234567");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("");

        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(0));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180305"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180310"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setMynosinkokutaisyouumukbn(C_UmuKbn.ARI);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU, syono5, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_HUBITEISEISYO_SOUHU.getValue());

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "送付先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "送付先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "送付先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "", "（ＩＲ）送付先氏名（漢字）");
    }

    @Test
    @TestOrder(170)
    public void testEditBean_A17() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");

        changeSystemDate(BizDate.valueOf(2015, 12, 1));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("1234567");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(10000));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180301"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180306"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setCalckijyunymd(BizDate.valueOf("20180308"));
        editSouhuannaiParam.setTmtthtkinzndk(BizCurrency.valueOf(1));
        editSouhuannaiParam .setMousideninkbn(C_MousideninKbn.KYKHONNIN);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU,
            syono2, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono2, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月 1日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ１１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ２２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ３３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ４４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ５５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ６６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ７７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ８８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ９９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ１０１", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono2, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.ARI, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.BLNK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk122　301", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh02", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.MISEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(10000), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 1日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月 6日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.NONE, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.KA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY, "（ＩＲ）積立金配分状態");
        exStringEquals(khSouhuannaiBean.getIrCalckijyunymd(),"2018年 3月 8日", "（ＩＲ）計算基準日");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTmtthtkinzndk(), BizCurrency.valueOf(1), "（ＩＲ）積立配当金残高");
        exClassificationEquals(khSouhuannaiBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrKykjyoutai(), C_Kykjyoutai.HARAIZUMI, "（ＩＲ）契約状態");
        exClassificationEquals(khSouhuannaiBean.getIrKykdrknhatudoujyoutai(),C_KykdrknHtdjytKbn.BLNK,"（ＩＲ）契約者代理権発動状態");
        exClassificationEquals(khSouhuannaiBean.getIrMousideninkbn(), C_MousideninKbn.KYKHONNIN, "（ＩＲ）申出人区分");
        exStringEquals(khSouhuannaiBean.getIrSksnm(),"請求書名9","（ＩＲ）請求書名");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.NONE, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月 1日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "7654321", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "保険会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名０１組織区分名０１", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "testUser01", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "777-8888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "漢字組織住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "漢字組織住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), null, "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), null, "（ＩＲ）問合せ先電話受付可能時間２");

        exStringEquals((String) MockObjectManager.getArgument(
            SyouhinUtil.class, "hantei", 0, 0), "MD11", "商品コード");
    }

    @Test
    @TestOrder(180)
    public void testEditBean_A18() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");

        changeSystemDate(BizDate.valueOf(2015, 12, 1));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("1234567");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(10000));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180301"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180306"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setCalckijyunymd(BizDate.valueOf("20180308"));
        editSouhuannaiParam.setTmtthtkinzndk(BizCurrency.valueOf(1));
        editSouhuannaiParam .setMousideninkbn(C_MousideninKbn.KYKHONNIN);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU,
            syono7, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono7, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月 1日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ０１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ０２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ０３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ０４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ０５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ０６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ０７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ０８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ０９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ００１", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono7, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.ARI, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.BLNK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk122　0", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh02", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.SEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(10000), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 1日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月 6日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.NONE, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.KA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY, "（ＩＲ）積立金配分状態");
        exStringEquals(khSouhuannaiBean.getIrCalckijyunymd(),"2018年 3月 8日", "（ＩＲ）計算基準日");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTmtthtkinzndk(), BizCurrency.valueOf(1), "（ＩＲ）積立配当金残高");
        exClassificationEquals(khSouhuannaiBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrKykjyoutai(), C_Kykjyoutai.HARAIZUMI, "（ＩＲ）契約状態");
        exClassificationEquals(khSouhuannaiBean.getIrKykdrknhatudoujyoutai(),C_KykdrknHtdjytKbn.SETTEI,"（ＩＲ）契約者代理権発動状態");
        exClassificationEquals(khSouhuannaiBean.getIrMousideninkbn(), C_MousideninKbn.KYKHONNIN, "（ＩＲ）申出人区分");
        exStringEquals(khSouhuannaiBean.getIrSksnm(),"請求書名10","（ＩＲ）請求書名");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.NONE, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月 1日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "9999993", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "受取人住所１３", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "受取人住所２３", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "受取人住所３３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "受取人名（漢字）３", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "保険会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名０１組織区分名０１", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "testUser01", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "777-8888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "漢字組織住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "漢字組織住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), null, "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), null, "（ＩＲ）問合せ先電話受付可能時間２");

        exStringEquals((String) MockObjectManager.getArgument(
            SyouhinUtil.class, "hantei", 0, 0), "MD11", "商品コード");
    }

    @Test
    @TestOrder(190)
    public void testEditBean_A19() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");

        changeSystemDate(BizDate.valueOf(2015, 12, 1));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("1234567");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(10000));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180301"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180306"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setCalckijyunymd(BizDate.valueOf("20180308"));
        editSouhuannaiParam.setTmtthtkinzndk(BizCurrency.valueOf(1));
        editSouhuannaiParam .setMousideninkbn(C_MousideninKbn.BLNK);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU, syono6, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono6, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月 1日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ０１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ０２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ０３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ０４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ０５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ０６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ０７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ０８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ０９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ００１", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono6, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.ARI, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.BLNK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk122　0", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh02", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.SEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(10000), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 1日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月 6日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.NONE, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.KA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY, "（ＩＲ）積立金配分状態");
        exStringEquals(khSouhuannaiBean.getIrCalckijyunymd(),"2018年 3月 8日", "（ＩＲ）計算基準日");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTmtthtkinzndk(), BizCurrency.valueOf(1), "（ＩＲ）積立配当金残高");
        exClassificationEquals(khSouhuannaiBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrKykjyoutai(), C_Kykjyoutai.HARAIZUMI, "（ＩＲ）契約状態");
        exClassificationEquals(khSouhuannaiBean.getIrKykdrknhatudoujyoutai(),C_KykdrknHtdjytKbn.BLNK,"（ＩＲ）契約者代理権発動状態");
        exClassificationEquals(khSouhuannaiBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exStringEquals(khSouhuannaiBean.getIrSksnm(),"請求書名10","（ＩＲ）請求書名");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.NONE, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2015年12月 1日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "7654321", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "保険会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名０１組織区分名０１", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "testUser01", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "777-8888", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "漢字組織住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "漢字組織住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), null, "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), null, "（ＩＲ）問合せ先電話受付可能時間２");

        exStringEquals((String) MockObjectManager.getArgument(
            SyouhinUtil.class, "hantei", 0, 0), "MD11", "商品コード");

    }
    @Test
    @TestOrder(200)
    public void testEditBean_A20() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");

        changeSystemDate(BizDate.valueOf(2015, 12, 1));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("1234567");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(10000));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180301"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180306"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setCalckijyunymd(BizDate.valueOf("20180308"));
        editSouhuannaiParam.setTmtthtkinzndk(BizCurrency.valueOf(1));
        editSouhuannaiParam .setMousideninkbn(C_MousideninKbn.KYKHONNIN);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_YENDTHNK_SOUHU,
            syono8, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_YENDTHNK_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono8, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月 1日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ１１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ１２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ１３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ１４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ１５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ１６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ１７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ１８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ１９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ２０", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono8, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.ARI, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_YENDTHNK_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.BLNK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk121　401", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh03", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.MISEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(10000), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 1日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月 6日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.NONE, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.KA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY, "（ＩＲ）積立金配分状態");
        exStringEquals(khSouhuannaiBean.getIrCalckijyunymd(),"2018年 3月 8日", "（ＩＲ）計算基準日");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTmtthtkinzndk(), BizCurrency.valueOf(1), "（ＩＲ）積立配当金残高");
        exClassificationEquals(khSouhuannaiBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrKykjyoutai(), C_Kykjyoutai.HARAIZUMI, "（ＩＲ）契約状態");
        exClassificationEquals(khSouhuannaiBean.getIrKykdrknhatudoujyoutai(),C_KykdrknHtdjytKbn.BLNK,"（ＩＲ）契約者代理権発動状態");
        exClassificationEquals(khSouhuannaiBean.getIrMousideninkbn(), C_MousideninKbn.KYKHONNIN, "（ＩＲ）申出人区分");
        exStringEquals(khSouhuannaiBean.getIrSksnm(),"請求書名11","（ＩＲ）請求書名");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.YENSYUUSIN, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");
    }

    @Test
    @TestOrder(210)
    public void testEditBean_A21() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");

        changeSystemDate(BizDate.valueOf(2015, 12, 1));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("1234567");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(10000));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180301"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180306"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setCalckijyunymd(BizDate.valueOf("20180308"));
        editSouhuannaiParam.setTmtthtkinzndk(BizCurrency.valueOf(1));
        editSouhuannaiParam .setMousideninkbn(C_MousideninKbn.KYKHONNIN);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_YENDTHNK_SOUHU,
            syono9, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_YENDTHNK_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono9, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月 1日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ２１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ２２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ２３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ２４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ２５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ２６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ２７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ２８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ２９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ３０", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono9, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.ARI, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_YENDTHNK_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.BLNK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk121　402", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh04", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.MISEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(10000), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 1日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月 6日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.NONE, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.KA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY, "（ＩＲ）積立金配分状態");
        exStringEquals(khSouhuannaiBean.getIrCalckijyunymd(),"2018年 3月 8日", "（ＩＲ）計算基準日");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTmtthtkinzndk(), BizCurrency.valueOf(1), "（ＩＲ）積立配当金残高");
        exClassificationEquals(khSouhuannaiBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrKykjyoutai(), C_Kykjyoutai.HARAIZUMI, "（ＩＲ）契約状態");
        exClassificationEquals(khSouhuannaiBean.getIrKykdrknhatudoujyoutai(),C_KykdrknHtdjytKbn.BLNK,"（ＩＲ）契約者代理権発動状態");
        exClassificationEquals(khSouhuannaiBean.getIrMousideninkbn(), C_MousideninKbn.KYKHONNIN, "（ＩＲ）申出人区分");
        exStringEquals(khSouhuannaiBean.getIrSksnm(),"請求書名12","（ＩＲ）請求書名");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.YENNENKIN, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");

    }

    @Test
    @TestOrder(220)
    public void testEditBean_A22() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");

        changeSystemDate(BizDate.valueOf(2015, 12, 1));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("1234567");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(10000));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180301"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180306"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setCalckijyunymd(BizDate.valueOf("20180308"));
        editSouhuannaiParam.setTmtthtkinzndk(BizCurrency.valueOf(1));
        editSouhuannaiParam .setMousideninkbn(C_MousideninKbn.KYKHONNIN);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_YENDTHNK_SOUHU,
            syono10, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_YENDTHNK_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono10, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月 1日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ３１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ３２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ３３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ３４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ３５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ３６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ３７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ３８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ３９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ４０", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono10, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.ARI, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_YENDTHNK_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.BLNK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk121　0", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh05", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.MISEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(10000), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 1日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月 6日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.NONE, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.KA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY, "（ＩＲ）積立金配分状態");
        exStringEquals(khSouhuannaiBean.getIrCalckijyunymd(),"2018年 3月 8日", "（ＩＲ）計算基準日");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTmtthtkinzndk(), BizCurrency.valueOf(1), "（ＩＲ）積立配当金残高");
        exClassificationEquals(khSouhuannaiBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrKykjyoutai(), C_Kykjyoutai.HARAIZUMI, "（ＩＲ）契約状態");
        exClassificationEquals(khSouhuannaiBean.getIrKykdrknhatudoujyoutai(),C_KykdrknHtdjytKbn.BLNK,"（ＩＲ）契約者代理権発動状態");
        exClassificationEquals(khSouhuannaiBean.getIrMousideninkbn(), C_MousideninKbn.KYKHONNIN, "（ＩＲ）申出人区分");
        exStringEquals(khSouhuannaiBean.getIrSksnm(),"請求書名13","（ＩＲ）請求書名");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.NONE, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");

    }

    @Test
    @TestOrder(230)
    public void testEditBean_A23() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");

        changeSystemDate(BizDate.valueOf(2015, 12, 1));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("1234567");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(10000));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180301"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180306"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setCalckijyunymd(BizDate.valueOf("20180308"));
        editSouhuannaiParam.setTmtthtkinzndk(BizCurrency.valueOf(1));
        editSouhuannaiParam .setMousideninkbn(C_MousideninKbn.KYKHONNIN);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_SHIHARAI_SOUHU,
            syono8, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_SHIHARAI_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono8, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月 1日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ４１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ４２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ４３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ４４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ４５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ４６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ４７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ４８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ４９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ５０", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono8, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.ARI, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_SHIHARAI_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.BLNK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk271　501", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh03", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.MISEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(10000), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 1日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月 6日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.NONE, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.KA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY, "（ＩＲ）積立金配分状態");
        exStringEquals(khSouhuannaiBean.getIrCalckijyunymd(),"2018年 3月 8日", "（ＩＲ）計算基準日");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTmtthtkinzndk(), BizCurrency.valueOf(1), "（ＩＲ）積立配当金残高");
        exClassificationEquals(khSouhuannaiBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrKykjyoutai(), C_Kykjyoutai.HARAIZUMI, "（ＩＲ）契約状態");
        exClassificationEquals(khSouhuannaiBean.getIrKykdrknhatudoujyoutai(),C_KykdrknHtdjytKbn.BLNK,"（ＩＲ）契約者代理権発動状態");
        exClassificationEquals(khSouhuannaiBean.getIrMousideninkbn(), C_MousideninKbn.KYKHONNIN, "（ＩＲ）申出人区分");
        exStringEquals(khSouhuannaiBean.getIrSksnm(),"請求書名14","（ＩＲ）請求書名");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.NONE, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");
    }

    @Test
    @TestOrder(240)
    public void testEditBean_A24() {

        MockObjectManager.initialize();
        CheckDsTorihikiServiceMockForHozen.SYORIPTN = CheckDsTorihikiServiceMockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserNm("testUser01");
        baseUserInfo.getUser().setUserId("test01");

        kinoInfo.setKinouId("khkaiyaku");
        kinoInfo.setCategoryId("khcommon");

        changeSystemDate(BizDate.valueOf(2015, 12, 1));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("khkaiyaku");
        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");
        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160201");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160202");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160203");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160204");

        editSouhuannaiParam.setShsyno("1234567");
        editSouhuannaiParam.setShsadr1kj("送付先住所１");
        editSouhuannaiParam.setShsadr2kj("送付先住所２");
        editSouhuannaiParam.setShsadr3kj("送付先住所３");
        editSouhuannaiParam.setShsnmkj("送付先氏名");
        editSouhuannaiParam.setHyshantyouhyounm("汎用送付案内帳票名");
        editSouhuannaiParam.setHyshaninjinaiyou("汎用送付案内印字内容");
        editSouhuannaiParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
        editSouhuannaiParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSouhuannaiParam.setHrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSouhuannaiParam.setTargetTkHkUmu(C_UmuKbn.ARI);
        editSouhuannaiParam.setTargetTkKbn(C_TargetTkKbn.BLNK);
        editSouhuannaiParam.setNextTkshrkjt(BizDate.valueOf(20160227));
        editSouhuannaiParam.setSeikyuukigenYmd(BizDate.valueOf(20160228));
        editSouhuannaiParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.BLNK);
        editSouhuannaiParam.setHenkankinumuKbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkinUmu(C_UmuKbn.NONE);
        editSouhuannaiParam.setTuikaHrkkin(BizCurrency.valueOf(9999));
        editSouhuannaiParam.setNkshrtkykhnkKbn(C_NstkhKbn.BLNK);
        editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
        editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.NONE);
        editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSouhuannaiParam.setSkssakuseijiyuu(C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE);
        editSouhuannaiParam.setYendthnkhrgk(BizCurrency.valueOf(10000));
        editSouhuannaiParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSouhuannaiParam.setTmttknitenuktkstartymd(BizDate.valueOf("20180301"));
        editSouhuannaiParam.setSyoruiuktkkigenymd(BizDate.valueOf("20180306"));
        editSouhuannaiParam.setGsbunritaisyouumukbn(C_UmuKbn.NONE);
        editSouhuannaiParam.setCalckijyunymd(BizDate.valueOf("20180308"));
        editSouhuannaiParam.setTmtthtkinzndk(BizCurrency.valueOf(1));
        editSouhuannaiParam .setMousideninkbn(C_MousideninKbn.KYKHONNIN);

        ReportServicesBean  reportServicesBean = editSouhuannaiTbl.editBean(C_SyoruiCdKbn.KK_SHIHARAI_SOUHU,
            syono11, khozenCommonParam, editSouhuannaiParam);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_SHIHARAI_SOUHU.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");
        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono11, "検索キー");

        KhSouhuannaiBean khSouhuannaiBean = (KhSouhuannaiBean)kHSBean[0];

        exStringEquals(khSouhuannaiBean.getIrTyouhyousakuseiymd(), "2015年12月 1日", "（ＩＲ）帳票作成日");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg1(), "送付案内メッセージ５１", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg2(), "送付案内メッセージ５２", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg3(), "送付案内メッセージ５３", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg4(), "送付案内メッセージ５４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg5(), "送付案内メッセージ５５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg6(), "送付案内メッセージ５６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg7(), "送付案内メッセージ５７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg8(), "送付案内メッセージ５８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg9(), "送付案内メッセージ５９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSouhuannaiBean.getIrSouhuannaimsg10(), "送付案内メッセージ６０", "（ＩＲ）送付案内メッセージ１０");
        exStringEquals(khSouhuannaiBean.getIrSyono(), syono11, "（ＩＲ）証券番号");
        exStringEquals(khSouhuannaiBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhkumu(), C_UmuKbn.ARI, "（ＩＲ）ターゲット特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exStringEquals(khSouhuannaiBean.getIrSyosaihkymd(), "2016年 2月27日", "（ＩＲ）証券再発行年月日");
        exStringEquals(khSouhuannaiBean.getIrNexttkshrkjt(), "2016年 2月27日", "（ＩＲ）次回定期金支払日期日");
        exStringEquals(khSouhuannaiBean.getIrSeikyuukigenymd(), "2016年 2月28日", "（ＩＲ）請求期限日");
        exClassificationEquals(khSouhuannaiBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_SHIHARAI_SOUHU, "（ＩＲ）書類コード");
        exClassificationEquals(khSouhuannaiBean.getIrHengakuumukbn(), C_UmuKbn.ARI, "（ＩＲ）変額保険有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSibousumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrSiboukyhkumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrStdrsktkyumukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.BLNK, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exClassificationEquals(khSouhuannaiBean.getIrHenkankinumukbn(), C_UmuKbn.NONE, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSouhuannaiBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.BLNK, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.BLNK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSouhuannaiBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exStringEquals(khSouhuannaiBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khSouhuannaiBean.getIrTyouhyoutitle(), "kk271　502", "（ＩＲ）帳票タイトル");
        exClassificationEquals(khSouhuannaiBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTrhkjikakumukbn(), C_UmuKbn.ARI, "（ＩＲ）取引時確認有無区分");
        exStringEquals(khSouhuannaiBean.getIrSyouhnnm(), "Kh03", "（ＩＲ）商品名");
        exClassificationEquals(khSouhuannaiBean.getIrKykmsnkbn(), C_KykMsnKbn.MISEINEN, "（ＩＲ）契約者未成年区分");
        exClassificationEquals(khSouhuannaiBean.getIrJyudkaigomaebrtkykhnkkbn(),
            C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseiymdhenkouumu(),
            C_UmuKbn.NONE, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSouhuannaiBean.getIrHhknseihenkouumu(),
            C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");

        exClassificationEquals(khSouhuannaiBean.getIrKyktuukasyu(),
            C_Tuukasyu.USD, "（ＩＲ）契約通貨種類");
        exBizCalcbleEquals(khSouhuannaiBean.getIrYendthnkHrgk(),
            BizCurrency.valueOf(10000), "（ＩＲ）円建変更時返戻金額");
        exClassificationEquals(khSouhuannaiBean.getIrKhhrshrjiyuu(),
            C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSouhuannaiBean.getIrKhskssakuseijiyuu(),
            C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE, "（ＩＲ）契約保全請求書作成事由");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknitenkbn(),
            C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSouhuannaiBean.getIrTmttknitenuktkstartymd(), "2018年 3月 1日", "（ＩＲ）積立金移転受付開始日");
        exStringEquals(khSouhuannaiBean.getIrSyoruiuktkkigenymd(), "2018年 3月 6日", "（ＩＲ）書類受付期限日");
        exClassificationEquals(khSouhuannaiBean.getIrGsbunritaisyouumukbn(), C_UmuKbn.NONE, "（ＩＲ）源泉分離課税対象有無区分");
        exNumericEquals(khSouhuannaiBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSouhuannaiBean.getIrDskaiyakukahikbn(), C_KahiKbn.KA, "（ＩＲ）ＤＳ解約可否区分");
        exClassificationEquals(khSouhuannaiBean.getIrTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY, "（ＩＲ）積立金配分状態");
        exStringEquals(khSouhuannaiBean.getIrCalckijyunymd(),"2018年 3月 8日", "（ＩＲ）計算基準日");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTmtthtkinzndk(), BizCurrency.valueOf(1), "（ＩＲ）積立配当金残高");
        exClassificationEquals(khSouhuannaiBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSouhuannaiBean.getIrKykjyoutai(), C_Kykjyoutai.HARAIZUMI, "（ＩＲ）契約状態");
        exClassificationEquals(khSouhuannaiBean.getIrKykdrknhatudoujyoutai(),C_KykdrknHtdjytKbn.BLNK,"（ＩＲ）契約者代理権発動状態");
        exClassificationEquals(khSouhuannaiBean.getIrMousideninkbn(), C_MousideninKbn.KYKHONNIN, "（ＩＲ）申出人区分");
        exStringEquals(khSouhuannaiBean.getIrSksnm(),"請求書名15","（ＩＲ）請求書名");
        exClassificationEquals(khSouhuannaiBean.getIrMousideikoukbn(), C_MousideIkouKbn.NONE, "（ＩＲ）申出移行区分");
        exClassificationEquals(khSouhuannaiBean.getIrTuikahrkkinumu(), C_UmuKbn.NONE, "（ＩＲ）追加払込金有無区分");
        exBizCalcbleEquals(khSouhuannaiBean.getIrTuikahrkkin(), BizCurrency.valueOf(9999), "（ＩＲ）追加払込金額");
        exStringEquals(khSouhuannaiBean.getIrYendthnkymd(), "2020年12月10日", "（ＩＲ）円建変更日");
    }
}