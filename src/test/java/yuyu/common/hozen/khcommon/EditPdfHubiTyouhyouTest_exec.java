package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.app.hozen.khhubikanri.khhubitouroku.EditPdfHubiTyouhyou;
import yuyu.app.hozen.khhubikanri.khhubitouroku.HubiList2DataSourceBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.dao.WT_KouteiSummaryDao;
import yuyu.def.db.entity.AM_User;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備帳票PDF作成クラスのメソッド {@link EditPdfHubiTyouhyou#exec(KhozenCommonParam,C_SyoruiCdKbn,String,C_KhkinouModeIdKbn,C_UmuKbn,C_UmuKbn,String,BizDate,List,BzKokyakuAtesakiBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPdfHubiTyouhyouTest_exec extends AbstractTest {

    private final static String syoNo1 = "12806345672";

    private final static String fileName = "UT_SP_単体テスト仕様書_不備帳票PDF作成";

    private final static String sheetName = "テストデータ";


    @Inject
    private EditPdfHubiTyouhyou editPdfHubiTyouhyou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @BeforeClass
    @Transactional
    public static void testInit() {

        KhozenCommonParamMock.caller = EditPdfHubiTyouhyouTest_exec.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditPdfHubiTyouhyouTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        WT_KouteiSummaryDao kouteiSummaryDao = SWAKInjector.getInstance(WT_KouteiSummaryDao.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());
        bizDomManager.delete(bizDomManager.getAllSosikiMadoguti());
        baseDomManager.delete(kouteiSummaryDao.getAllKouteiSummary());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();


        String tyouhyouKey = editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_ADRHNK_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);

        exStringEquals(tyouhyouKey, "" ,"帳票結合キー");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１５１");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_SYOSAIHK_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１５２");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.NONE);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_MEIGIHNK_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１５３");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_STDRHNK_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１５４");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_SEINENGAPPISEI_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１５５");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_GENGAKU_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBISYOUNIN, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１５８");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_MKHGKHNK_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１６０");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_KAIGOMAETKHNK_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１６１");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_KAIYAKU_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１６２");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_ADRHNK_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１６３");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_KYKTORIKESI_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１６４");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_CLGOFF_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１６５");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_KAIJYO_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１６６");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_MUKOU_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１６７");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_SBMUKOU_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１６８");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_SBMUKOUNOSHR_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１６９");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_SBKAIJYO_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１７０");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_SBMENSEKI_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１７０");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_SBMENSEKINOSHR_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_A20() {

        KhozenCommonParamMock.SYORIPTN = "1";

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１６９");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_ADRHNK_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.ARI, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_A21() {

        KhozenCommonParamMock.SYORIPTN = "1";

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１７０");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.SYA);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_HUBI_KARISAKUSEI, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.ARI, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_A22() {

        KhozenCommonParamMock.SYORIPTN = "1";

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data = new HubiList2DataSourceBean();
        hubiList2Data.setDisphubinaiyoumsg("不備メッセージ１７１");
        hubiList2Data.setDisphassinsakikbn(C_HassinsakiKbn.SYA);
        hubiList2Data.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_YENDTHNKHNRKN_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.ARI, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }


    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_A23() {

        KhozenCommonParamMock.SYORIPTN = "1";

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        bzWorkflowInfo.setJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        AM_User aMUser = new AM_User();
        aMUser.setUserNm("ユーザ００１");
        aMUser.setUserId("Y001");
        changeCurrentUser(baseUserInfo, aMUser);

        changeSystemDate(BizDate.valueOf(2015, 11, 9));

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");


        String renrakuArea = "連絡欄テスト内容";
        BizDate hubiAnswerKjt = BizDate.valueOf(20160301);

        List<HubiList2DataSourceBean> hubiMsgList = new ArrayList<>();
        HubiList2DataSourceBean hubiList2Data1 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data2 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data3 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data4 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data5 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data6 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data7 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data8 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data9 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data10 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data11 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data12 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data13 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data14 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data15 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data16 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data17 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data18 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data19 = new HubiList2DataSourceBean();
        HubiList2DataSourceBean hubiList2Data20 = new HubiList2DataSourceBean();
        hubiList2Data1.setDisphubinaiyoumsg("不備メッセージ１");
        hubiList2Data2.setDisphubinaiyoumsg("不備メッセージ２");
        hubiList2Data3.setDisphubinaiyoumsg("不備メッセージ３");
        hubiList2Data4.setDisphubinaiyoumsg("不備メッセージ４");
        hubiList2Data5.setDisphubinaiyoumsg("不備メッセージ５");
        hubiList2Data6.setDisphubinaiyoumsg("不備メッセージ６");
        hubiList2Data7.setDisphubinaiyoumsg("不備メッセージ７");
        hubiList2Data8.setDisphubinaiyoumsg("不備メッセージ８");
        hubiList2Data9.setDisphubinaiyoumsg("不備メッセージ９");
        hubiList2Data10.setDisphubinaiyoumsg("不備メッセージ１０");
        hubiList2Data11.setDisphubinaiyoumsg("不備メッセージ１１");
        hubiList2Data12.setDisphubinaiyoumsg("不備メッセージ１２");
        hubiList2Data13.setDisphubinaiyoumsg("不備メッセージ１３");
        hubiList2Data14.setDisphubinaiyoumsg("不備メッセージ１４");
        hubiList2Data15.setDisphubinaiyoumsg("不備メッセージ１５");
        hubiList2Data16.setDisphubinaiyoumsg("不備メッセージ１６");
        hubiList2Data17.setDisphubinaiyoumsg("不備メッセージ１７");
        hubiList2Data18.setDisphubinaiyoumsg("不備メッセージ１８");
        hubiList2Data19.setDisphubinaiyoumsg("不備メッセージ１９");
        hubiList2Data20.setDisphubinaiyoumsg("不備メッセージ２０");

        hubiList2Data1.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data2.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data3.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data4.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data5.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data6.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data7.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data8.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data9.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data10.setDisphassinsakikbn(C_HassinsakiKbn.KOK);
        hubiList2Data11.setDisphassinsakikbn(C_HassinsakiKbn.SYA);
        hubiList2Data12.setDisphassinsakikbn(C_HassinsakiKbn.SYA);
        hubiList2Data13.setDisphassinsakikbn(C_HassinsakiKbn.SYA);
        hubiList2Data14.setDisphassinsakikbn(C_HassinsakiKbn.SYA);
        hubiList2Data15.setDisphassinsakikbn(C_HassinsakiKbn.SYA);
        hubiList2Data16.setDisphassinsakikbn(C_HassinsakiKbn.SYA);
        hubiList2Data17.setDisphassinsakikbn(C_HassinsakiKbn.SYA);
        hubiList2Data18.setDisphassinsakikbn(C_HassinsakiKbn.SYA);
        hubiList2Data19.setDisphassinsakikbn(C_HassinsakiKbn.SYA);
        hubiList2Data20.setDisphassinsakikbn(C_HassinsakiKbn.SYA);
        hubiList2Data1.setDispgenponhnkykumu(C_UmuKbn.NONE);
        hubiList2Data2.setDispgenponhnkykumu(C_UmuKbn.NONE);
        hubiList2Data3.setDispgenponhnkykumu(C_UmuKbn.NONE);
        hubiList2Data4.setDispgenponhnkykumu(C_UmuKbn.NONE);
        hubiList2Data5.setDispgenponhnkykumu(C_UmuKbn.NONE);
        hubiList2Data6.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiList2Data7.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiList2Data8.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiList2Data9.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiList2Data10.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiList2Data11.setDispgenponhnkykumu(C_UmuKbn.NONE);
        hubiList2Data12.setDispgenponhnkykumu(C_UmuKbn.NONE);
        hubiList2Data13.setDispgenponhnkykumu(C_UmuKbn.NONE);
        hubiList2Data14.setDispgenponhnkykumu(C_UmuKbn.NONE);
        hubiList2Data15.setDispgenponhnkykumu(C_UmuKbn.NONE);
        hubiList2Data16.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiList2Data17.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiList2Data18.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiList2Data19.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiList2Data20.setDispgenponhnkykumu(C_UmuKbn.ARI);
        hubiMsgList.add(hubiList2Data1);
        hubiMsgList.add(hubiList2Data2);
        hubiMsgList.add(hubiList2Data3);
        hubiMsgList.add(hubiList2Data4);
        hubiMsgList.add(hubiList2Data5);
        hubiMsgList.add(hubiList2Data6);
        hubiMsgList.add(hubiList2Data7);
        hubiMsgList.add(hubiList2Data8);
        hubiMsgList.add(hubiList2Data9);
        hubiMsgList.add(hubiList2Data10);
        hubiMsgList.add(hubiList2Data11);
        hubiMsgList.add(hubiList2Data12);
        hubiMsgList.add(hubiList2Data13);
        hubiMsgList.add(hubiList2Data14);
        hubiMsgList.add(hubiList2Data15);
        hubiMsgList.add(hubiList2Data16);
        hubiMsgList.add(hubiList2Data17);
        hubiMsgList.add(hubiList2Data18);
        hubiMsgList.add(hubiList2Data19);
        hubiMsgList.add(hubiList2Data20);
        BzKokyakuAtesakiBean kokyakuAtesakiBean = new BzKokyakuAtesakiBean();
        kokyakuAtesakiBean.setIrShsyno("1112222");
        kokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        kokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        kokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        kokyakuAtesakiBean.setIrShsnmkj("送付先氏名");


        editPdfHubiTyouhyou.exec(khozenCommonParam, C_SyoruiCdKbn.KK_TUMITATEKINITEN_HB, syoNo1,
            C_KhkinouModeIdKbn.HUBITOUROKU, C_UmuKbn.NONE, renrakuArea, hubiAnswerKjt,
            hubiMsgList ,kokyakuAtesakiBean);
    }
}