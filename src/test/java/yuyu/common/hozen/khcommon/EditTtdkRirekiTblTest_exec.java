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

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.auth.RayHttpHeaderBean;
import yuyu.infr.auth.RayHttpHeaderBeanMockForHozen;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 手続履歴TBL編集クラスのメソッド {@link EditTtdkRirekiTbl#exec(EditTtdkRirekiTblParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditTtdkRirekiTblTest_exec {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    private final static String fileName = "UT-SP_単体テスト仕様書_手続履歴TBL編集";

    private final static String sheetName = "INデータ";


    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        EditSeihowebIdouRirekiTblMockForHozen.caller = null;
        EditSeihowebIdouRirekiTblMockForHozen.SYORIPTN = null;
        RayHttpHeaderBeanMockForHozen.caller = null;
        EditKhHenkouRirekiTblMockForHozen.caller = null;
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(EditKhHenkouRirekiTbl.class).to(EditKhHenkouRirekiTblMockForHozen.class);
                bind(EditSeihowebIdouRirekiTbl.class).to(EditSeihowebIdouRirekiTblMockForHozen.class);
                bind(RayHttpHeaderBean.class).to(RayHttpHeaderBeanMockForHozen.class);
            }
        });
        RayHttpHeaderBeanMockForHozen.caller = EditTtdkRirekiTblTest_exec.class;
        EditKhHenkouRirekiTblMockForHozen.caller = EditTtdkRirekiTblTest_exec.class;
        EditSeihowebIdouRirekiTblMockForHozen.caller = EditTtdkRirekiTblTest_exec.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditTtdkRirekiTblTest_exec.class, fileName, sheetName);
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
        hozenDomManager.delete(hozenDomManager.getAllBAKKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
        hozenDomManager.delete(hozenDomManager.getAllBAKAnsyuKihon());
        hozenDomManager.delete(hozenDomManager.getAllNyuukinKakusyouData());

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
        EditSeihowebIdouRirekiTblMockForHozen.SYORIPTN = EditSeihowebIdouRirekiTblMockForHozen.TESTPATTERN1;

        khozenCommonParam.setSikibetuKey("12");
        khozenCommonParam.setFunctionId("KhozenCommonParam");

        IT_NyuukinKakusyouData nyuukinKakusyouData = hozenDomManager.getNyuukinKakusyouData("123456", "12806345672");

        AM_User aMUser = new AM_User();
        aMUser.setUserId("king");
        changeCurrentUser(baseUserInfo, aMUser);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo("12806345672");
        editTtdkRirekiTblParam.setSyoriYmd(BizDate.valueOf(20151228));
        editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.ARI);
        editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.MENSEKI);
        editTtdkRirekiTblParam.setHonninkakkekka(C_HonninKakninKekkaKbn.MIRYOU);
        editTtdkRirekiTblParam.setSysTime("20151228124020001");
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        editTtdkRirekiTblParam.setSmbcKanriId("2");
        editTtdkRirekiTblParam.setNayoseKihontblSkbtKey("3");
        editTtdkRirekiTblParam.setKouteiKanriId("4");
        editTtdkRirekiTblParam.setYoukyuuNo("5");
        editTtdkRirekiTblParam.setNyuukinKakusyouData(nyuukinKakusyouData);

        kinou.setKinouKbn(C_KinouKbn.ONLINE);
        kinou.setKinouId("KhozenCommonParam");

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
        exDateEquals((BizDate) MockObjectManager.getArgument(EditSeihowebIdouRirekiTblMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20151228), "異動発生年月日");
        exClassificationEquals((C_SyoriKbn) MockObjectManager.getArgument(EditSeihowebIdouRirekiTblMockForHozen.class, "exec", 0, 1),
            C_SyoriKbn.MENSEKI, "処理区分");
        exStringEquals((String) MockObjectManager.getArgument(EditSeihowebIdouRirekiTblMockForHozen.class, "exec", 0, 2),
            "12", "変更識別キー");
        exStringEquals((String) MockObjectManager.getArgument(EditSeihowebIdouRirekiTblMockForHozen.class, "exec", 0, 3),
            "KhozenCommonParam", "業務用更新機能ＩＤ");
        exStringEquals((String) MockObjectManager.getArgument(EditSeihowebIdouRirekiTblMockForHozen.class, "exec", 0, 4),
            "king", "業務用更新者ＩＤ");
        exStringEquals((String) MockObjectManager.getArgument(EditSeihowebIdouRirekiTblMockForHozen.class, "exec", 0, 5),
            "20151228124020001", "業務用更新時間");
        IT_KykKihon argKykKihon = (IT_KykKihon) MockObjectManager.getArgument(EditSeihowebIdouRirekiTblMockForHozen.class, "exec", 0, 6);
        exStringEquals(argKykKihon.getSyono(), "12806345672", "証券番号");
        IT_AnsyuKihon argAnsyuKihon = (IT_AnsyuKihon) MockObjectManager.getArgument(EditSeihowebIdouRirekiTblMockForHozen.class, "exec", 0, 7);
        exStringEquals(argAnsyuKihon.getSyono(), "12806345672", "証券番号");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_B1() {
        MockObjectManager.initialize();

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        khozenCommonParam.setSikibetuKey("13");
        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo("12806345672");
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_NyuukinKakusyouData nyuukinKakusyouData = hozenDomManager.getNyuukinKakusyouData("123456", "12806345672");

        editTtdkRirekiTblParam.setNyuukinKakusyouData(nyuukinKakusyouData);

        kinou.setKinouId("KhozenCommonParam");

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        IT_KykKihon argKykKihon = (IT_KykKihon) MockObjectManager.getArgument(EditKhHenkouRirekiTblMockForHozen.class, "exec", 0, 0);
        exStringEquals(argKykKihon.getSyono(), "12806345672", "証券番号");
        IT_BAK_KykKihon argBakKykKihon = (IT_BAK_KykKihon) MockObjectManager.getArgument(EditKhHenkouRirekiTblMockForHozen.class, "exec", 0, 1);
        exStringEquals(argBakKykKihon.getSyono(), "12806345672", "証券番号");
        exStringEquals(argBakKykKihon.getTrkssikibetukey(), "13", "取消識別キー");
        IT_AnsyuKihon argAnsyuKihon = (IT_AnsyuKihon) MockObjectManager.getArgument(EditKhHenkouRirekiTblMockForHozen.class, "exec", 0, 2);
        exStringEquals(argAnsyuKihon.getSyono(), "12806345672", "証券番号");
        IT_BAK_AnsyuKihon argBakAnsyuKihon = (IT_BAK_AnsyuKihon) MockObjectManager.getArgument(EditKhHenkouRirekiTblMockForHozen.class, "exec", 0, 3);
        exStringEquals(argBakAnsyuKihon.getSyono(), "12806345672", "証券番号");
        exStringEquals(argBakAnsyuKihon.getTrkssikibetukey(), "13", "変更識別キー");
        IT_NyuukinKakusyouData nyuukinKakusyou = (IT_NyuukinKakusyouData) MockObjectManager.getArgument(
            EditKhHenkouRirekiTblMockForHozen.class, "exec", 0, 4);
        exStringEquals(nyuukinKakusyou.getKbnkey(), "07", "区分キー");
        exStringEquals(nyuukinKakusyou.getNyuukinkakusyouno(), "123456", "入金確証番号");
        exStringEquals(nyuukinKakusyou.getSyono(), "12806345672", "証券番号");
        String henkouSikibetuKeyRenno = (String) MockObjectManager.getArgument(EditKhHenkouRirekiTblMockForHozen.class, "exec", 0, 5);
        exStringEquals(henkouSikibetuKeyRenno, "13", "変更識別キー連番");


    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_B2() {

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        khozenCommonParam.setSikibetuKey("14");
        khozenCommonParam.setFunctionId("KhozenCommonParam");

        AM_User aMUser = new AM_User();
        aMUser.setUserId("king");
        changeCurrentUser(baseUserInfo, aMUser);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo("12806345672");
        editTtdkRirekiTblParam.setSyoriYmd(BizDate.valueOf(20151228));
        editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.ARI);
        editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.MENSEKI);
        editTtdkRirekiTblParam.setHonninkakkekka(C_HonninKakninKekkaKbn.MIRYOU);
        editTtdkRirekiTblParam.setSysTime("20151228122040002");
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        editTtdkRirekiTblParam.setSmbcKanriId("2");
        editTtdkRirekiTblParam.setNayoseKihontblSkbtKey("3");
        editTtdkRirekiTblParam.setKouteiKanriId("4");
        editTtdkRirekiTblParam.setYoukyuuNo("5");

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_NyuukinKakusyouData nyuukinKakusyouData = hozenDomManager.getNyuukinKakusyouData("123456", "12806345672");

        editTtdkRirekiTblParam.setNyuukinKakusyouData(nyuukinKakusyouData);

        kinou.setKinouId("KhozenCommonParam");

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        IT_KhTtdkRireki khTtdkRireki =
            hozenDomManager.getKykKihon("12806345672").getKhTtdkRirekiByHenkousikibetukey("14");

        exStringEquals(khTtdkRireki.getSyono(), "12806345672", "証券番号");
        exStringEquals(khTtdkRireki.getHenkousikibetukey(), "14", "変更識別キー");
        exDateEquals(khTtdkRireki.getSyoriYmd(), BizDate.valueOf(20151228), "処理年月日");
        exStringEquals(khTtdkRireki.getSyorisosikicd(), "0010001", "処理組織コード");
        exClassificationEquals(khTtdkRireki.getShrsyousaiumu(), C_UmuKbn.ARI, "支払詳細有無");
        exClassificationEquals(khTtdkRireki.getSyorikbn(), C_SyoriKbn.MENSEKI, "処理区分");
        exClassificationEquals(khTtdkRireki.getHonninkakninkekkakbn(), C_HonninKakninKekkaKbn.MIRYOU, "本人確認結果");
        exClassificationEquals(khTtdkRireki.getHenkourrkumu(), C_UmuKbn.NONE, "変更履歴有無");
        exStringEquals(khTtdkRireki.getSmbckanriid(), "2", "ＳＭＢＣ受付管理ＩＤ");
        exStringEquals(khTtdkRireki.getNayosekihontblskbtkey(), "3", "名寄せ基本テーブル識別キー");
        exStringEquals(khTtdkRireki.getKouteikanriid(), "4", "工程管理ＩＤ");
        exStringEquals(khTtdkRireki .getGyoumuKousinKinou(), "KhozenCommonParam", "業務用更新機能ＩＤ");
        exStringEquals(khTtdkRireki .getGyoumuKousinsyaId(), "king", "業務用更新者ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinTime(), "20151228122040002", "業務用更新時間");
        exStringEquals(khTtdkRireki.getYoukyuuno(), "5", "要求通番");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_B3() {
        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        khozenCommonParam.setSikibetuKey("15");
        khozenCommonParam.setFunctionId("EditTtdkRirekiTbl");

        AM_User aMUser = new AM_User();
        aMUser.setUserId("Quen");
        changeCurrentUser(baseUserInfo, aMUser);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo("12806345672");
        editTtdkRirekiTblParam.setSyoriYmd(BizDate.valueOf(20151228));
        editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.ARI);
        editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.MENSEKI);
        editTtdkRirekiTblParam.setHonninkakkekka(C_HonninKakninKekkaKbn.MIRYOU);
        editTtdkRirekiTblParam.setSysTime("20151228122040001");
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        editTtdkRirekiTblParam.setSmbcKanriId("2");
        editTtdkRirekiTblParam.setNayoseKihontblSkbtKey("3");
        editTtdkRirekiTblParam.setKouteiKanriId("4");
        editTtdkRirekiTblParam.setYoukyuuNo("5");

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_NyuukinKakusyouData nyuukinKakusyouData = hozenDomManager.getNyuukinKakusyouData("123456", "12806345672");
        editTtdkRirekiTblParam.setNyuukinKakusyouData(nyuukinKakusyouData);
        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        IT_KhTtdkRireki khTtdkRireki =
            hozenDomManager.getKykKihon("12806345672").getKhTtdkRirekiByHenkousikibetukey("15");

        exStringEquals(khTtdkRireki.getSyono(), "12806345672", "証券番号");
        exStringEquals(khTtdkRireki.getHenkousikibetukey(), "15", "変更識別キー");
        exDateEquals(khTtdkRireki.getSyoriYmd(), BizDate.valueOf(20151228), "処理年月日");
        exStringEquals(khTtdkRireki.getSyorisosikicd(), "0010001", "処理組織コード");
        exClassificationEquals(khTtdkRireki.getShrsyousaiumu(), C_UmuKbn.ARI, "支払詳細有無");
        exClassificationEquals(khTtdkRireki.getSyorikbn(), C_SyoriKbn.MENSEKI, "処理区分");
        exClassificationEquals(khTtdkRireki.getHonninkakninkekkakbn(), C_HonninKakninKekkaKbn.MIRYOU, "本人確認結果");
        exClassificationEquals(khTtdkRireki.getHenkourrkumu(), C_UmuKbn.ARI, "変更履歴有無");
        exStringEquals(khTtdkRireki.getSmbckanriid(), "2", "ＳＭＢＣ受付管理ＩＤ");
        exStringEquals(khTtdkRireki.getNayosekihontblskbtkey(), "3", "名寄せ基本テーブル識別キー");
        exStringEquals(khTtdkRireki.getKouteikanriid(), "4", "工程管理ＩＤ");
        exStringEquals(khTtdkRireki .getGyoumuKousinKinou(), "EditTtdkRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(khTtdkRireki .getGyoumuKousinsyaId(), "Quen", "業務用更新者ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinTime(), "20151228122040001", "業務用更新時間");
        exStringEquals(khTtdkRireki.getYoukyuuno(), "5", "要求通番");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_B4() {

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        khozenCommonParam.setSikibetuKey("16");
        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo("12806345672");

        AM_User aMUser = new AM_User();
        aMUser.setUserId("");
        changeCurrentUser(baseUserInfo, aMUser);

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_NyuukinKakusyouData nyuukinKakusyouData = hozenDomManager.getNyuukinKakusyouData("123456", "12806345672");
        editTtdkRirekiTblParam.setNyuukinKakusyouData(nyuukinKakusyouData);

        //        kinou.setKinouId("EditTtdkRirekiTbl");
        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        IT_KhTtdkRireki khTtdkRireki =
            hozenDomManager.getKykKihon("12806345672").getKhTtdkRirekiByHenkousikibetukey("16");

        exStringEquals(khTtdkRireki.getSyono(), "12806345672", "証券番号");
        exStringEquals(khTtdkRireki.getHenkousikibetukey(), "16", "変更識別キー");
        exDateEquals(khTtdkRireki.getSyoriYmd(), null, "処理年月日");
        exStringEquals(khTtdkRireki.getSyorisosikicd(), "0010001", "処理組織コード");
        exClassificationEquals(khTtdkRireki.getShrsyousaiumu(), C_UmuKbn.NONE, "支払詳細有無");
        exClassificationEquals(khTtdkRireki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(khTtdkRireki.getHonninkakninkekkakbn(), C_HonninKakninKekkaKbn.BLNK, "本人確認結果");
        exClassificationEquals(khTtdkRireki.getHenkourrkumu(), C_UmuKbn.NONE, "変更履歴有無");
        exStringEquals(khTtdkRireki.getSmbckanriid(), "", "ＳＭＢＣ受付管理ＩＤ");
        exStringEquals(khTtdkRireki.getNayosekihontblskbtkey(), "", "名寄せ基本テーブル識別キー");
        exStringEquals(khTtdkRireki.getKouteikanriid(), "", "工程管理ＩＤ");
        exStringEquals(khTtdkRireki .getGyoumuKousinKinou(),kinou.getKinouId(), "業務用更新機能ＩＤ");
        exStringEquals(khTtdkRireki .getGyoumuKousinsyaId(),baseUserInfo.getUserId(), "業務用更新者ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinTime(), "", "業務用更新時間");
        exStringEquals(khTtdkRireki.getYoukyuuno(), "", "要求通番");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_B5() {

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        khozenCommonParam.setSikibetuKey("123456789012345678");
        khozenCommonParam.setFunctionId("asdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfg");

        AM_User aMUser = new AM_User();
        aMUser.setUserId("qwertqwertqwert");
        changeCurrentUser(baseUserInfo, aMUser);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo("12806345672");
        editTtdkRirekiTblParam.setSyoriYmd(BizDate.valueOf(20151228));
        editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.ARI);
        editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.MENSEKI);
        editTtdkRirekiTblParam.setHonninkakkekka(C_HonninKakninKekkaKbn.MIRYOU);
        editTtdkRirekiTblParam.setSysTime("20151228122040002");
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        editTtdkRirekiTblParam.setSmbcKanriId("12345678901");
        editTtdkRirekiTblParam.setNayoseKihontblSkbtKey("12345678901234567890");
        editTtdkRirekiTblParam.setKouteiKanriId("12345678909876543210");
        editTtdkRirekiTblParam.setYoukyuuNo("123456789012345678");

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_NyuukinKakusyouData nyuukinKakusyouData = null;
        editTtdkRirekiTblParam.setNyuukinKakusyouData(nyuukinKakusyouData);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        IT_KhTtdkRireki khTtdkRireki =
            hozenDomManager.getKykKihon("12806345672").getKhTtdkRirekiByHenkousikibetukey("123456789012345678");

        exStringEquals(khTtdkRireki.getSyono(), "12806345672", "証券番号");
        exStringEquals(khTtdkRireki.getHenkousikibetukey(), "123456789012345678", "変更識別キー");
        exDateEquals(khTtdkRireki.getSyoriYmd(), BizDate.valueOf(20151228), "処理年月日");
        exStringEquals(khTtdkRireki.getSyorisosikicd(), "0010001", "処理組織コード");
        exClassificationEquals(khTtdkRireki.getShrsyousaiumu(), C_UmuKbn.ARI, "支払詳細有無");
        exClassificationEquals(khTtdkRireki.getSyorikbn(), C_SyoriKbn.MENSEKI, "処理区分");
        exClassificationEquals(khTtdkRireki.getHonninkakninkekkakbn(), C_HonninKakninKekkaKbn.MIRYOU, "本人確認結果");
        exClassificationEquals(khTtdkRireki.getHenkourrkumu(), C_UmuKbn.NONE, "変更履歴有無");
        exStringEquals(khTtdkRireki.getSmbckanriid(), "12345678901", "ＳＭＢＣ受付管理ＩＤ");
        exStringEquals(khTtdkRireki.getNayosekihontblskbtkey(), "12345678901234567890", "名寄せ基本テーブル識別キー");
        exStringEquals(khTtdkRireki.getKouteikanriid(), "12345678909876543210", "工程管理ＩＤ");
        exStringEquals(khTtdkRireki .getGyoumuKousinKinou(),
            "asdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfg", "業務用更新機能ＩＤ");
        exStringEquals(khTtdkRireki .getGyoumuKousinsyaId(), "qwertqwertqwert", "業務用更新者ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinTime(), "20151228122040002", "業務用更新時間");
        exStringEquals(khTtdkRireki.getYoukyuuno(), "123456789012345678", "要求通番");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_B6() {
        MockObjectManager.initialize();

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        khozenCommonParam.setSikibetuKey("13");
        AM_User aMUser = new AM_User();
        aMUser.setUserId("Quen");
        changeCurrentUser(baseUserInfo, aMUser);
        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setSyono("10806000016");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
        khTtdkRireki.setHenkousikibetukey("13");

        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        IT_BAK_KykKihon bakKykKihon = new IT_BAK_KykKihon();
        bakKykKihon.setSyono("10806000016");
        bakKykKihon.setTrkssikibetukey("17");
        khozenCommonParam.setBatchBakKykKihon(bakKykKihon);
        IT_AnsyuKihon ansyuKihon = new IT_AnsyuKihon();
        ansyuKihon.setSyono("10806000016");
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        IT_BAK_AnsyuKihon bakAnsyuKihon = new IT_BAK_AnsyuKihon();
        bakAnsyuKihon.setSyono("10806000016");
        bakAnsyuKihon.setTrkssikibetukey("17");
        khozenCommonParam.setBatchBakAnsyuKihon(bakAnsyuKihon);
        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo("12806345672");
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

        kinou.setKinouKbn(C_KinouKbn.BATCH);

        IT_NyuukinKakusyouData nyuukinKakusyouData = hozenDomManager.getNyuukinKakusyouData("123456", "12806345672");

        editTtdkRirekiTblParam.setNyuukinKakusyouData(nyuukinKakusyouData);

        kinou.setKinouId("EditTtdkRirekiTbl");
        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        IT_KykKihon argKykKihon = (IT_KykKihon) MockObjectManager.getArgument(EditKhHenkouRirekiTblMockForHozen.class, "exec", 0, 0);
        exStringEquals(argKykKihon.getSyono(), "10806000016", "証券番号");
        IT_BAK_KykKihon argBakKykKihon = (IT_BAK_KykKihon) MockObjectManager.getArgument(EditKhHenkouRirekiTblMockForHozen.class, "exec", 0, 1);
        exStringEquals(argBakKykKihon.getSyono(), "10806000016", "証券番号");
        exStringEquals(argBakKykKihon.getTrkssikibetukey(), "17", "取消識別キー");
        IT_AnsyuKihon argAnsyuKihon = (IT_AnsyuKihon) MockObjectManager.getArgument(EditKhHenkouRirekiTblMockForHozen.class, "exec", 0, 2);
        exStringEquals(argAnsyuKihon.getSyono(), "10806000016", "証券番号");
        IT_BAK_AnsyuKihon argBakAnsyuKihon = (IT_BAK_AnsyuKihon) MockObjectManager.getArgument(EditKhHenkouRirekiTblMockForHozen.class, "exec", 0, 3);
        exStringEquals(argBakAnsyuKihon.getSyono(), "10806000016", "証券番号");
        exStringEquals(argBakAnsyuKihon.getTrkssikibetukey(), "17", "変更識別キー");
        IT_NyuukinKakusyouData nyuukinKakusyou = (IT_NyuukinKakusyouData) MockObjectManager.getArgument(
            EditKhHenkouRirekiTblMockForHozen.class, "exec", 0, 4);
        exStringEquals(nyuukinKakusyou.getKbnkey(), "07", "区分キー");
        exStringEquals(nyuukinKakusyou.getNyuukinkakusyouno(), "123456", "入金確証番号");
        exStringEquals(nyuukinKakusyou.getSyono(), "12806345672", "証券番号");
        String henkouSikibetuKeyRenno = (String) MockObjectManager.getArgument(EditKhHenkouRirekiTblMockForHozen.class, "exec", 0, 5);
        exStringEquals(henkouSikibetuKeyRenno, "13", "変更識別キー連番");
    }

}
