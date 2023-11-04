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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwari;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwariMockForHozen;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HouteiTyotkseiSyouhnHyjKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＰＡＬ契約内容作成クラスのメソッド {@link PALKykNaiyouSakusei#exec(PALKykNaiyouSakuseiBean)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class PALKykNaiyouSakuseiTest_exec {

    @Inject
    private PALKykNaiyouSakusei palKykNaiyouSakusei;

    @Inject
    HozenDomManager hozenDomManager;

    @Inject
    SiharaiDomManager siharaiDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＰＡＬ契約内容作成";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(GetKhTuusanyouKngk.class).to(GetKhTuusanyouKngkMockForHozen.class);
                bind(BzGetTuukeiBunwari.class).to(BzGetTuukeiBunwariMockForHozen.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(PALKykNaiyouSakuseiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

    }

    @BeforeClass
    public static void testInit() {
        GetKhTuusanyouKngkMockForHozen.caller = PALKykNaiyouSakuseiTest_exec.class;
        BzGetTuukeiBunwariMockForHozen.caller = PALKykNaiyouSakuseiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        GetKhTuusanyouKngkMockForHozen.caller = null;
        BzGetTuukeiBunwariMockForHozen.caller = null;
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000012");
        PALKykNaiyouSakuseiBean pPALKykNaiyouSakuseiBean = new PALKykNaiyouSakuseiBean();
        pPALKykNaiyouSakuseiBean.setKykKihon(pKykKihon);

        C_ErrorKbn errorKbn = palKykNaiyouSakusei.exec(pPALKykNaiyouSakuseiBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000013");
        PALKykNaiyouSakuseiBean pPALKykNaiyouSakuseiBean = new PALKykNaiyouSakuseiBean();
        pPALKykNaiyouSakuseiBean.setKykKihon(pKykKihon);

        C_ErrorKbn errorKbn = palKykNaiyouSakusei.exec(pPALKykNaiyouSakuseiBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000024");
        PALKykNaiyouSakuseiBean pPALKykNaiyouSakuseiBean = new PALKykNaiyouSakuseiBean();
        pPALKykNaiyouSakuseiBean.setKykKihon(pKykKihon);

        baseUserInfo.getUser().setUserId("JUnit");

        C_ErrorKbn errorKbn = palKykNaiyouSakusei.exec(pPALKykNaiyouSakuseiBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BT_TjtIdouNyKh tjtIdouNyKh = palKykNaiyouSakusei.getTjtIdouNyKh();
        exStringEquals(tjtIdouNyKh.getSyono(), "17806000024", "証券番号");
        exNumericEquals(tjtIdouNyKh.getRenno3keta(), 1, "連番（３桁）");
        exNumericEquals(tjtIdouNyKh.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exStringEquals(tjtIdouNyKh.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNyKh.getSyouhncd(), "0002", "商品コード");
        exClassificationEquals(tjtIdouNyKh.getKykjyoutai(), C_Kykjyoutai.BLNK, "契約状態");
        exDateEquals(tjtIdouNyKh.getKykymd(), null, "契約日");
        exClassificationEquals(tjtIdouNyKh.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.BLNK, "有効消滅区分");
        exClassificationEquals(tjtIdouNyKh.getSyoumetujiyuu(), C_Syoumetujiyuu.BLNK, "消滅事由");
        exDateEquals(tjtIdouNyKh.getSyoumetuymd(), null, "消滅日");
        exClassificationEquals(tjtIdouNyKh.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyousibous(), BizCurrency.valueOf(1000), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyouitijip(), BizCurrency.valueOf(2000), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyounkgns(), BizCurrency.valueOf(3000), "通算用年金原資");
        exNumericEquals(tjtIdouNyKh.getHrkkkn(), 0, "払込期間");
        exClassificationEquals(tjtIdouNyKh.getSntkhoukbn(), C_SntkhouKbn.BLNK, "選択方法区分");
        exDateYMEquals(tjtIdouNyKh.getBosyuuym(), null, "募集年月");
        exNumericEquals(tjtIdouNyKh.getKykhhkndouhyouji(), 1, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn1(), C_TtdktyuuiKbn.BLNK, "手続注意区分１");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn2(), C_TtdktyuuiKbn.BLNK, "手続注意区分２");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn3(), C_TtdktyuuiKbn.BLNK, "手続注意区分３");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn4(), C_TtdktyuuiKbn.BLNK, "手続注意区分４");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn5(), C_TtdktyuuiKbn.BLNK, "手続注意区分５");
        exNumericEquals(tjtIdouNyKh.getSyouhnsdno(), 2, "商品世代番号");
        exClassificationEquals(tjtIdouNyKh.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNyKh.getPyennykntkykumukbn(), C_UmuKbn.NONE, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyennyknkgk(), BizCurrency.valueOf(4000), "通算用円入金額");
        exStringEquals(tjtIdouNyKh.getSkjmosno(), "", "新契約時申込番号");
        exStringEquals(tjtIdouNyKh.getGyoumuKousinKinou(), "PALKykNaiyouSakuseiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNyKh.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(tjtIdouNyKh.getSeiritujitrhkjikakkbn(), C_TrhkjiKakKbn.BLNK, "成立時取引時確認区分");
        exClassificationEquals(tjtIdouNyKh.getHouteityotkseisyouhnhyj(), C_HouteiTyotkseiSyouhnHyjKbn.HIGAITOU, "法定貯蓄性商品表示");
        exClassificationEquals(tjtIdouNyKh.getTsntuukasyu(), C_Tuukasyu.JPY, "通算用通貨種類");
        exClassificationEquals(tjtIdouNyKh.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");

        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();
        exStringEquals(idouKhMeigi.getSyono(), "17806000024", "証券番号");
        exNumericEquals(idouKhMeigi.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouKhMeigi.getHhknnmkn(), "", "被保険者名（カナ）");
        exStringEquals(idouKhMeigi.getHhknnmkj(), "", "被保険者名（漢字）");
        exDateEquals(idouKhMeigi.getHhknseiymd(), null, "被保険者生年月日");
        exClassificationEquals(idouKhMeigi.getHhknsei(), C_Hhknsei.BLNK, "被保険者性別");
        exStringEquals(idouKhMeigi.getHhknyno(), "", "被保険者郵便番号");
        exStringEquals(idouKhMeigi.getHhknadr1kj(), "", "被保険者住所１（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr2kj(), "", "被保険者住所２（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr3kj(), "", "被保険者住所３（漢字）");
        exStringEquals(idouKhMeigi.getHhkntelno(), "", "被保険者電話番号");
        exStringEquals(idouKhMeigi.getHhknsykgycd(), "", "被保険者職業コード");
        exStringEquals(idouKhMeigi.getKyknmkn(), "", "契約者名（カナ）");
        exStringEquals(idouKhMeigi.getKyknmkj(), "", "契約者名（漢字）");
        exDateEquals(idouKhMeigi.getKykseiymd(), null, "契約者生年月日");
        exStringEquals(idouKhMeigi.getNenkinuktnmkana(), "", "年金受取人名（カナ）");
        exStringEquals(idouKhMeigi.getNenkinuktnmkanji(), "", "年金受取人名（漢字）");
        exDateEquals(idouKhMeigi.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exStringEquals(idouKhMeigi.getTsinyno(), "", "通信先郵便番号");
        exStringEquals(idouKhMeigi.getTsinadr1kj(), "", "通信先住所１（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr2kj(), "", "通信先住所２（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr3kj(), "", "通信先住所２（漢字）");
        exStringEquals(idouKhMeigi.getTsintelno(), "", "通信先電話番号");
        exStringEquals(idouKhMeigi.getSbuktnmkn1(), "", "死亡受取人名（カナ）１");
        exStringEquals(idouKhMeigi.getSbuktnmkj1(), "", "死亡受取人名（漢字）１");
        exStringEquals(idouKhMeigi.getSbuktnmkn2(), "", "死亡受取人名（カナ）２");
        exStringEquals(idouKhMeigi.getSbuktnmkj2(), "", "死亡受取人名（漢字）２");
        exStringEquals(idouKhMeigi.getSbuktnmkn3(), "", "死亡受取人名（カナ）３");
        exStringEquals(idouKhMeigi.getSbuktnmkj3(), "", "死亡受取人名（漢字）３");
        exStringEquals(idouKhMeigi.getSbuktnmkn4(), "", "死亡受取人名（カナ）４");
        exStringEquals(idouKhMeigi.getSbuktnmkj4(), "", "死亡受取人名（漢字）４");
        exStringEquals(idouKhMeigi.getStdrsknmkn(), "", "指定代理請求人名（カナ）");
        exStringEquals(idouKhMeigi.getStdrsknmkj(), "", "指定代理請求人名（漢字）");
        exStringEquals(idouKhMeigi.getBankcd(), "", "銀行コード");
        exStringEquals(idouKhMeigi.getSitencd(), "", "支店コード");
        exClassificationEquals(idouKhMeigi.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(idouKhMeigi.getKouzano(), "", "口座番号");
        exStringEquals(idouKhMeigi.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(idouKhMeigi.getKzkykdoukbn(), C_KzkykdouKbn.BLNK, "口座名義契約者同一人区分");

        BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.getIdouKhBosyuudr();
        exStringEquals(idouKhBosyuudr.getSyono(), "17806000024", "証券番号");
        exNumericEquals(idouKhBosyuudr.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouKhBosyuudr.getDairitencd1(), "1232", "代理店コード１");
        exBizCalcbleEquals(idouKhBosyuudr.getBunwari1(), BizNumber.valueOf(21), "分担割合１");
        exStringEquals(idouKhBosyuudr.getDairitencd2(), "", "代理店コード２");
        exBizCalcbleEquals(idouKhBosyuudr.getBunwari2(), BizNumber.ZERO, "分担割合２");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd2(), "", "管理組織コード２");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN2;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000035");
        PALKykNaiyouSakuseiBean pPALKykNaiyouSakuseiBean = new PALKykNaiyouSakuseiBean();
        pPALKykNaiyouSakuseiBean.setKykKihon(pKykKihon);

        baseUserInfo.getUser().setUserId("JUnit");

        C_ErrorKbn errorKbn = palKykNaiyouSakusei.exec(pPALKykNaiyouSakuseiBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BT_TjtIdouNyKh tjtIdouNyKh = palKykNaiyouSakusei.getTjtIdouNyKh();
        exStringEquals(tjtIdouNyKh.getSyono(), "17806000035", "証券番号");
        exNumericEquals(tjtIdouNyKh.getRenno3keta(), 131, "連番（３桁）");
        exNumericEquals(tjtIdouNyKh.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exStringEquals(tjtIdouNyKh.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNyKh.getSyouhncd(), "0003", "商品コード");
        exClassificationEquals(tjtIdouNyKh.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(tjtIdouNyKh.getKykymd(), BizDate.valueOf(20170601), "契約日");
        exClassificationEquals(tjtIdouNyKh.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tjtIdouNyKh.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tjtIdouNyKh.getSyoumetuymd(), BizDate.valueOf(20180201), "消滅日");
        exClassificationEquals(tjtIdouNyKh.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyousibous(), BizCurrency.valueOf(1000), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyouitijip(), BizCurrency.valueOf(2000), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyounkgns(), BizCurrency.valueOf(3000), "通算用年金原資");
        exNumericEquals(tjtIdouNyKh.getHrkkkn(), 66, "払込期間");
        exClassificationEquals(tjtIdouNyKh.getSntkhoukbn(), C_SntkhouKbn.KKT, "選択方法区分");
        exDateYMEquals(tjtIdouNyKh.getBosyuuym(), BizDateYM.valueOf(201706), "募集年月");
        exNumericEquals(tjtIdouNyKh.getKykhhkndouhyouji(), 0, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn1(), C_TtdktyuuiKbn.TTDKTYUUOUTAITYUUI, "手続注意区分１");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn2(), C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI, "手続注意区分２");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn3(), C_TtdktyuuiKbn.HASANOYOBITOUSAN, "手続注意区分３");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn4(), C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE, "手続注意区分４");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn5(), C_TtdktyuuiKbn.KYKSYAYUKUEHUMEI, "手続注意区分５");
        exNumericEquals(tjtIdouNyKh.getSyouhnsdno(), 3, "商品世代番号");
        exClassificationEquals(tjtIdouNyKh.getKaigomaehrtkykumukbn(), C_UmuKbn.ARI, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNyKh.getPyennykntkykumukbn(), C_UmuKbn.ARI, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyennyknkgk(), BizCurrency.valueOf(4000), "通算用円入金額");
        exStringEquals(tjtIdouNyKh.getSkjmosno(), "860000017", "新契約時申込番号");
        exStringEquals(tjtIdouNyKh.getGyoumuKousinKinou(), "PALKykNaiyouSakuseiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNyKh.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(tjtIdouNyKh.getSeiritujitrhkjikakkbn(), C_TrhkjiKakKbn.KAKUNINZUMI, "成立時取引時確認区分");
        exClassificationEquals(tjtIdouNyKh.getHouteityotkseisyouhnhyj(), C_HouteiTyotkseiSyouhnHyjKbn.GAITOU, "法定貯蓄性商品表示");
        exClassificationEquals(tjtIdouNyKh.getTsntuukasyu(), C_Tuukasyu.JPY, "通算用通貨種類");
        exClassificationEquals(tjtIdouNyKh.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");

        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();
        exStringEquals(idouKhMeigi.getSyono(), "17806000035", "証券番号");
        exNumericEquals(idouKhMeigi.getRenno3keta(), 131, "連番（３桁）");
        exStringEquals(idouKhMeigi.getHhknnmkn(), "ヒホケンシジシニカナ", "被保険者名（カナ）");
        exStringEquals(idouKhMeigi.getHhknnmkj(), "被保険者名漢字３", "被保険者名（漢字）");
        exDateEquals(idouKhMeigi.getHhknseiymd(), BizDate.valueOf(20160303), "被保険者生年月日");
        exClassificationEquals(idouKhMeigi.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(idouKhMeigi.getHhknyno(), "3333333", "被保険者郵便番号");
        exStringEquals(idouKhMeigi.getHhknadr1kj(), "", "被保険者住所１（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr2kj(), "", "被保険者住所２（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr3kj(), "", "被保険者住所３（漢字）");
        exStringEquals(idouKhMeigi.getHhkntelno(), "", "被保険者電話番号");
        exStringEquals(idouKhMeigi.getHhknsykgycd(), "003", "被保険者職業コード");
        exStringEquals(idouKhMeigi.getKyknmkn(), "ヒホケンシジシニカナ", "契約者名（カナ）");
        exStringEquals(idouKhMeigi.getKyknmkj(), "契約者名漢字３", "契約者名（漢字）");
        exDateEquals(idouKhMeigi.getKykseiymd(), BizDate.valueOf(20180412), "契約者生年月日");
        exStringEquals(idouKhMeigi.getNenkinuktnmkana(), "", "年金受取人名（カナ）");
        exStringEquals(idouKhMeigi.getNenkinuktnmkanji(), "", "年金受取人名（漢字）");
        exDateEquals(idouKhMeigi.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exStringEquals(idouKhMeigi.getTsinyno(), "3000000", "通信先郵便番号");
        exStringEquals(idouKhMeigi.getTsinadr1kj(), "通信先住所１漢字", "通信先住所１（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr2kj(), "通信先住所２漢字", "通信先住所２（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr3kj(), "通信先住所３漢字", "通信先住所２（漢字）");
        exStringEquals(idouKhMeigi.getTsintelno(), "010-5677-8999", "通信先電話番号");
        exStringEquals(idouKhMeigi.getSbuktnmkn1(), "ヒホケンシジシニカナ１", "死亡受取人名（カナ）１");
        exStringEquals(idouKhMeigi.getSbuktnmkj1(), "受取人名漢字１", "死亡受取人名（漢字）１");
        exStringEquals(idouKhMeigi.getSbuktnmkn2(), "ヒホケンシジシニカナ２", "死亡受取人名（カナ）２");
        exStringEquals(idouKhMeigi.getSbuktnmkj2(), "", "死亡受取人名（漢字）２");
        exStringEquals(idouKhMeigi.getSbuktnmkn3(), "ヒホケンシジシニカナ３", "死亡受取人名（カナ）３");
        exStringEquals(idouKhMeigi.getSbuktnmkj3(), "受取人名漢字３", "死亡受取人名（漢字）３");
        exStringEquals(idouKhMeigi.getSbuktnmkn4(), "ヒホケンシジシニカナ４", "死亡受取人名（カナ）４");
        exStringEquals(idouKhMeigi.getSbuktnmkj4(), "受取人名漢字４", "死亡受取人名（漢字）４");
        exStringEquals(idouKhMeigi.getStdrsknmkn(), "ヒホケンシジシニカナ５", "指定代理請求人名（カナ）");
        exStringEquals(idouKhMeigi.getStdrsknmkj(), "受取人名漢字５", "指定代理請求人名（漢字）");
        exStringEquals(idouKhMeigi.getBankcd(), "3001", "銀行コード");
        exStringEquals(idouKhMeigi.getSitencd(), "311", "支店コード");
        exClassificationEquals(idouKhMeigi.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(idouKhMeigi.getKouzano(), "32001", "口座番号");
        exStringEquals(idouKhMeigi.getKzmeiginmkn(), "ヒホケンシジシニカナ", "口座名義人氏名（カナ）");
        exClassificationEquals(idouKhMeigi.getKzkykdoukbn(), C_KzkykdouKbn.DOUITU, "口座名義契約者同一人区分");

        BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.getIdouKhBosyuudr();
        exStringEquals(idouKhBosyuudr.getSyono(), "17806000035", "証券番号");
        exNumericEquals(idouKhBosyuudr.getRenno3keta(), 131, "連番（３桁）");
        exStringEquals(idouKhBosyuudr.getDairitencd1(), "1000", "代理店コード１");
        exBizCalcbleEquals(idouKhBosyuudr.getBunwari1(), BizNumber.valueOf(10), "分担割合１");
        exStringEquals(idouKhBosyuudr.getDairitencd2(), "2000", "代理店コード２");
        exBizCalcbleEquals(idouKhBosyuudr.getBunwari2(), BizNumber.valueOf(20), "分担割合２");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd1(), "33001", "管理組織コード１");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd2(), "33002", "管理組織コード２");

        exStringEquals((String)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 0),
            "3001", "代理店コード１");
        exStringEquals((String)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 1),
            "31001", "親代理店コード１");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(31), "分担割合１");
        exStringEquals((String)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 3),
            "3002", "代理店コード２");
        exStringEquals((String)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 4),
            "31002", "親代理店コード２");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec",
            0, 5), BizNumber.valueOf(32), "分担割合２");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 6),
            BizDateYM.valueOf(201803), "基準年月");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class,
            "exec", 0, 7),C_DrtSyouhinSikibetuKbn.YTIRRTHENDOUGATAGONENRISAHAITOUSITEITUUKAKJNNK, "代理店商品識別区分");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class,
            "exec", 0, 8),C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals((C_DiritenplannmKbn)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class,
            "exec", 0, 9),C_DiritenplannmKbn.BLNK, "代理店プラン名区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000046");
        PALKykNaiyouSakuseiBean pPALKykNaiyouSakuseiBean = new PALKykNaiyouSakuseiBean();
        pPALKykNaiyouSakuseiBean.setKykKihon(pKykKihon);

        baseUserInfo.getUser().setUserId("JUnit");

        C_ErrorKbn errorKbn = palKykNaiyouSakusei.exec(pPALKykNaiyouSakuseiBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BT_TjtIdouNyKh tjtIdouNyKh = palKykNaiyouSakusei.getTjtIdouNyKh();
        exStringEquals(tjtIdouNyKh.getSyono(), "17806000046", "証券番号");
        exNumericEquals(tjtIdouNyKh.getRenno3keta(), 141, "連番（３桁）");
        exNumericEquals(tjtIdouNyKh.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exStringEquals(tjtIdouNyKh.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNyKh.getSyouhncd(), "0004", "商品コード");
        exClassificationEquals(tjtIdouNyKh.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(tjtIdouNyKh.getKykymd(), BizDate.valueOf(20170601), "契約日");
        exClassificationEquals(tjtIdouNyKh.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tjtIdouNyKh.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tjtIdouNyKh.getSyoumetuymd(), BizDate.valueOf(20180201), "消滅日");
        exClassificationEquals(tjtIdouNyKh.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyousibous(), BizCurrency.valueOf(1000), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyouitijip(), BizCurrency.valueOf(2000), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyounkgns(), BizCurrency.valueOf(3000), "通算用年金原資");
        exNumericEquals(tjtIdouNyKh.getHrkkkn(), 66, "払込期間");
        exClassificationEquals(tjtIdouNyKh.getSntkhoukbn(), C_SntkhouKbn.KKT, "選択方法区分");
        exDateYMEquals(tjtIdouNyKh.getBosyuuym(), BizDateYM.valueOf(201706), "募集年月");
        exNumericEquals(tjtIdouNyKh.getKykhhkndouhyouji(), 0, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn1(), C_TtdktyuuiKbn.KYKSYAYUKUEHUMEI, "手続注意区分１");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn2(), C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE, "手続注意区分２");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn3(), C_TtdktyuuiKbn.HASANOYOBITOUSAN, "手続注意区分３");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn4(), C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI, "手続注意区分４");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn5(), C_TtdktyuuiKbn.TTDKTYUUOUTAITYUUI, "手続注意区分５");
        exNumericEquals(tjtIdouNyKh.getSyouhnsdno(), 4, "商品世代番号");
        exClassificationEquals(tjtIdouNyKh.getKaigomaehrtkykumukbn(), C_UmuKbn.ARI, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNyKh.getPyennykntkykumukbn(), C_UmuKbn.ARI, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyennyknkgk(), BizCurrency.valueOf(4000), "通算用円入金額");
        exStringEquals(tjtIdouNyKh.getSkjmosno(), "860000017", "新契約時申込番号");
        exStringEquals(tjtIdouNyKh.getGyoumuKousinKinou(), "PALKykNaiyouSakuseiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNyKh.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(tjtIdouNyKh.getSeiritujitrhkjikakkbn(), C_TrhkjiKakKbn.KAKUNINZUMI, "成立時取引時確認区分");
        exClassificationEquals(tjtIdouNyKh.getHouteityotkseisyouhnhyj(), C_HouteiTyotkseiSyouhnHyjKbn.GAITOU, "法定貯蓄性商品表示");
        exClassificationEquals(tjtIdouNyKh.getTsntuukasyu(), C_Tuukasyu.JPY, "通算用通貨種類");
        exClassificationEquals(tjtIdouNyKh.getHrkkeiro(), C_Hrkkeiro.DANTAI, "払込経路");

        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();
        exStringEquals(idouKhMeigi.getSyono(), "17806000046", "証券番号");
        exNumericEquals(idouKhMeigi.getRenno3keta(), 141, "連番（３桁）");
        exStringEquals(idouKhMeigi.getHhknnmkn(), "ヒホケンシジシニカナ", "被保険者名（カナ）");
        exStringEquals(idouKhMeigi.getHhknnmkj(), "", "被保険者名（漢字）");
        exDateEquals(idouKhMeigi.getHhknseiymd(), BizDate.valueOf(20160404), "被保険者生年月日");
        exClassificationEquals(idouKhMeigi.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(idouKhMeigi.getHhknyno(), "4444444", "被保険者郵便番号");
        exStringEquals(idouKhMeigi.getHhknadr1kj(), "", "被保険者住所１（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr2kj(), "", "被保険者住所２（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr3kj(), "", "被保険者住所３（漢字）");
        exStringEquals(idouKhMeigi.getHhkntelno(), "", "被保険者電話番号");
        exStringEquals(idouKhMeigi.getHhknsykgycd(), "004", "被保険者職業コード");
        exStringEquals(idouKhMeigi.getKyknmkn(), "ヒホケンシジシニカナ", "契約者名（カナ）");
        exStringEquals(idouKhMeigi.getKyknmkj(), "", "契約者名（漢字）");
        exDateEquals(idouKhMeigi.getKykseiymd(), BizDate.valueOf(20180413), "契約者生年月日");
        exStringEquals(idouKhMeigi.getNenkinuktnmkana(), "", "年金受取人名（カナ）");
        exStringEquals(idouKhMeigi.getNenkinuktnmkanji(), "", "年金受取人名（漢字）");
        exDateEquals(idouKhMeigi.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exStringEquals(idouKhMeigi.getTsinyno(), "4000000", "通信先郵便番号");
        exStringEquals(idouKhMeigi.getTsinadr1kj(), "通信先住所１漢字", "通信先住所１（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr2kj(), "通信先住所２漢字", "通信先住所２（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr3kj(), "通信先住所３漢字", "通信先住所２（漢字）");
        exStringEquals(idouKhMeigi.getTsintelno(), "010-5677-8999", "通信先電話番号");
        exStringEquals(idouKhMeigi.getSbuktnmkn1(), "", "死亡受取人名（カナ）１");
        exStringEquals(idouKhMeigi.getSbuktnmkj1(), "", "死亡受取人名（漢字）１");
        exStringEquals(idouKhMeigi.getSbuktnmkn2(), "", "死亡受取人名（カナ）２");
        exStringEquals(idouKhMeigi.getSbuktnmkj2(), "", "死亡受取人名（漢字）２");
        exStringEquals(idouKhMeigi.getSbuktnmkn3(), "", "死亡受取人名（カナ）３");
        exStringEquals(idouKhMeigi.getSbuktnmkj3(), "", "死亡受取人名（漢字）３");
        exStringEquals(idouKhMeigi.getSbuktnmkn4(), "", "死亡受取人名（カナ）４");
        exStringEquals(idouKhMeigi.getSbuktnmkj4(), "", "死亡受取人名（漢字）４");
        exStringEquals(idouKhMeigi.getStdrsknmkn(), "", "指定代理請求人名（カナ）");
        exStringEquals(idouKhMeigi.getStdrsknmkj(), "", "指定代理請求人名（漢字）");
        exStringEquals(idouKhMeigi.getBankcd(), "", "銀行コード");
        exStringEquals(idouKhMeigi.getSitencd(), "", "支店コード");
        exClassificationEquals(idouKhMeigi.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(idouKhMeigi.getKouzano(), "", "口座番号");
        exStringEquals(idouKhMeigi.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(idouKhMeigi.getKzkykdoukbn(), C_KzkykdouKbn.BLNK, "口座名義契約者同一人区分");

        BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.getIdouKhBosyuudr();
        exStringEquals(idouKhBosyuudr.getSyono(), "17806000046", "証券番号");
        exNumericEquals(idouKhBosyuudr.getRenno3keta(), 141, "連番（３桁）");
        exStringEquals(idouKhBosyuudr.getDairitencd1(), "4001", "代理店コード１");
        exBizCalcbleEquals(idouKhBosyuudr.getBunwari1(), BizNumber.valueOf(41), "分担割合１");
        exStringEquals(idouKhBosyuudr.getDairitencd2(), "", "代理店コード２");
        exBizCalcbleEquals(idouKhBosyuudr.getBunwari2(), BizNumber.ZERO, "分担割合２");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd1(), "43001", "管理組織コード１");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd2(), "", "管理組織コード２");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN2;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000057");
        PALKykNaiyouSakuseiBean pPALKykNaiyouSakuseiBean = new PALKykNaiyouSakuseiBean();
        pPALKykNaiyouSakuseiBean.setKykKihon(pKykKihon);

        baseUserInfo.getUser().setUserId("JUnit");

        C_ErrorKbn errorKbn = palKykNaiyouSakusei.exec(pPALKykNaiyouSakuseiBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BT_TjtIdouNyKh tjtIdouNyKh = palKykNaiyouSakusei.getTjtIdouNyKh();
        exStringEquals(tjtIdouNyKh.getSyono(), "17806000057", "証券番号");
        exNumericEquals(tjtIdouNyKh.getRenno3keta(), 151, "連番（３桁）");
        exNumericEquals(tjtIdouNyKh.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exStringEquals(tjtIdouNyKh.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNyKh.getSyouhncd(), "0005", "商品コード");
        exClassificationEquals(tjtIdouNyKh.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(tjtIdouNyKh.getKykymd(), BizDate.valueOf(20170601), "契約日");
        exClassificationEquals(tjtIdouNyKh.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tjtIdouNyKh.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tjtIdouNyKh.getSyoumetuymd(), BizDate.valueOf(20180201), "消滅日");
        exClassificationEquals(tjtIdouNyKh.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyousibous(), BizCurrency.valueOf(1000), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyouitijip(), BizCurrency.valueOf(2000), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyounkgns(), BizCurrency.valueOf(3000), "通算用年金原資");
        exNumericEquals(tjtIdouNyKh.getHrkkkn(), 66, "払込期間");
        exClassificationEquals(tjtIdouNyKh.getSntkhoukbn(), C_SntkhouKbn.KKT, "選択方法区分");
        exDateYMEquals(tjtIdouNyKh.getBosyuuym(), BizDateYM.valueOf(201706), "募集年月");
        exNumericEquals(tjtIdouNyKh.getKykhhkndouhyouji(), 0, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn1(), C_TtdktyuuiKbn.TTDKTYUUOUTAITYUUI, "手続注意区分１");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn2(), C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI, "手続注意区分２");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn3(), C_TtdktyuuiKbn.HASANOYOBITOUSAN, "手続注意区分３");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn4(), C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE, "手続注意区分４");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn5(), C_TtdktyuuiKbn.KYKSYAYUKUEHUMEI, "手続注意区分５");
        exNumericEquals(tjtIdouNyKh.getSyouhnsdno(), 5, "商品世代番号");
        exClassificationEquals(tjtIdouNyKh.getKaigomaehrtkykumukbn(), C_UmuKbn.ARI, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNyKh.getPyennykntkykumukbn(), C_UmuKbn.ARI, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyennyknkgk(), BizCurrency.valueOf(4000), "通算用円入金額");
        exStringEquals(tjtIdouNyKh.getSkjmosno(), "860000017", "新契約時申込番号");
        exStringEquals(tjtIdouNyKh.getGyoumuKousinKinou(), "PALKykNaiyouSakuseiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNyKh.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(tjtIdouNyKh.getSeiritujitrhkjikakkbn(), C_TrhkjiKakKbn.KAKUNINZUMI, "成立時取引時確認区分");
        exClassificationEquals(tjtIdouNyKh.getHouteityotkseisyouhnhyj(), C_HouteiTyotkseiSyouhnHyjKbn.GAITOU, "法定貯蓄性商品表示");
        exClassificationEquals(tjtIdouNyKh.getTsntuukasyu(), C_Tuukasyu.JPY, "通算用通貨種類");
        exClassificationEquals(tjtIdouNyKh.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");

        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();
        exStringEquals(idouKhMeigi.getSyono(), "17806000057", "証券番号");
        exNumericEquals(idouKhMeigi.getRenno3keta(), 151, "連番（３桁）");
        exStringEquals(idouKhMeigi.getHhknnmkn(), "ヒホケンシジシニカナ", "被保険者名（カナ）");
        exStringEquals(idouKhMeigi.getHhknnmkj(), "被保険者名漢字５", "被保険者名（漢字）");
        exDateEquals(idouKhMeigi.getHhknseiymd(), BizDate.valueOf(20160303), "被保険者生年月日");
        exClassificationEquals(idouKhMeigi.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(idouKhMeigi.getHhknyno(), "3333333", "被保険者郵便番号");
        exStringEquals(idouKhMeigi.getHhknadr1kj(), "", "被保険者住所１（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr2kj(), "", "被保険者住所２（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr3kj(), "", "被保険者住所３（漢字）");
        exStringEquals(idouKhMeigi.getHhkntelno(), "", "被保険者電話番号");
        exStringEquals(idouKhMeigi.getHhknsykgycd(), "003", "被保険者職業コード");
        exStringEquals(idouKhMeigi.getKyknmkn(), "ヒホケンシジシニカナ", "契約者名（カナ）");
        exStringEquals(idouKhMeigi.getKyknmkj(), "契約者名漢字５", "契約者名（漢字）");
        exDateEquals(idouKhMeigi.getKykseiymd(), BizDate.valueOf(20180412), "契約者生年月日");
        exStringEquals(idouKhMeigi.getNenkinuktnmkana(), "", "年金受取人名（カナ）");
        exStringEquals(idouKhMeigi.getNenkinuktnmkanji(), "", "年金受取人名（漢字）");
        exDateEquals(idouKhMeigi.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exStringEquals(idouKhMeigi.getTsinyno(), "3000000", "通信先郵便番号");
        exStringEquals(idouKhMeigi.getTsinadr1kj(), "通信先住所１漢字", "通信先住所１（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr2kj(), "通信先住所２漢字", "通信先住所２（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr3kj(), "通信先住所３漢字", "通信先住所２（漢字）");
        exStringEquals(idouKhMeigi.getTsintelno(), "010-5677-8999", "通信先電話番号");
        exStringEquals(idouKhMeigi.getSbuktnmkn1(), "ヒホケンシジシニカナ１", "死亡受取人名（カナ）１");
        exStringEquals(idouKhMeigi.getSbuktnmkj1(), "受取人名漢字１", "死亡受取人名（漢字）１");
        exStringEquals(idouKhMeigi.getSbuktnmkn2(), "", "死亡受取人名（カナ）２");
        exStringEquals(idouKhMeigi.getSbuktnmkj2(), "", "死亡受取人名（漢字）２");
        exStringEquals(idouKhMeigi.getSbuktnmkn3(), "", "死亡受取人名（カナ）３");
        exStringEquals(idouKhMeigi.getSbuktnmkj3(), "", "死亡受取人名（漢字）３");
        exStringEquals(idouKhMeigi.getSbuktnmkn4(), "", "死亡受取人名（カナ）４");
        exStringEquals(idouKhMeigi.getSbuktnmkj4(), "", "死亡受取人名（漢字）４");
        exStringEquals(idouKhMeigi.getStdrsknmkn(), "ヒホケンシジシニカナ２", "指定代理請求人名（カナ）");
        exStringEquals(idouKhMeigi.getStdrsknmkj(), "", "指定代理請求人名（漢字）");
        exStringEquals(idouKhMeigi.getKykdairinmkn(), "", "契約者代理人名（カナ）");
        exStringEquals(idouKhMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouKhMeigi.getBankcd(), "3001", "銀行コード");
        exStringEquals(idouKhMeigi.getSitencd(), "311", "支店コード");
        exClassificationEquals(idouKhMeigi.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(idouKhMeigi.getKouzano(), "32001", "口座番号");
        exStringEquals(idouKhMeigi.getKzmeiginmkn(), "ヒホケンシジシニカナ", "口座名義人氏名（カナ）");
        exClassificationEquals(idouKhMeigi.getKzkykdoukbn(), C_KzkykdouKbn.DOUITU, "口座名義契約者同一人区分");
        exStringEquals(idouKhMeigi.getKzktourokunmkn1(), "", "家族登録名（カナ）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkn2(), "", "家族登録名（カナ）２");
        exStringEquals(idouKhMeigi.getKzktourokunmkj2(), "", "家族登録名（漢字）２");

        BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.getIdouKhBosyuudr();
        exStringEquals(idouKhBosyuudr.getSyono(), "17806000057", "証券番号");
        exNumericEquals(idouKhBosyuudr.getRenno3keta(), 151, "連番（３桁）");
        exStringEquals(idouKhBosyuudr.getDairitencd1(), "1000", "代理店コード１");
        exBizCalcbleEquals(idouKhBosyuudr.getBunwari1(), BizNumber.valueOf(10), "分担割合１");
        exStringEquals(idouKhBosyuudr.getDairitencd2(), "2000", "代理店コード２");
        exBizCalcbleEquals(idouKhBosyuudr.getBunwari2(), BizNumber.valueOf(20), "分担割合２");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd1(), "33001", "管理組織コード１");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd2(), "33002", "管理組織コード２");

        exStringEquals((String)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 0),
            "3001", "代理店コード１");
        exStringEquals((String)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 1),
            "31001", "親代理店コード１");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(31), "分担割合１");
        exStringEquals((String)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 3),
            "3002", "代理店コード２");
        exStringEquals((String)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 4),
            "31002", "親代理店コード２");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec",
            0, 5), BizNumber.valueOf(32), "分担割合２");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 6),
            BizDateYM.valueOf(201803), "基準年月");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class,
            "exec", 0, 7),C_DrtSyouhinSikibetuKbn.YTIRRTHENDOUGATAGONENRISAHAITOUSITEITUUKAKJNNK, "代理店商品識別区分");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class,
            "exec", 0, 8),C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals((C_DiritenplannmKbn)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class,
            "exec", 0, 9),C_DiritenplannmKbn.BLNK, "代理店プラン名区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN2;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000068");
        PALKykNaiyouSakuseiBean pPALKykNaiyouSakuseiBean = new PALKykNaiyouSakuseiBean();
        pPALKykNaiyouSakuseiBean.setKykKihon(pKykKihon);

        C_ErrorKbn errorKbn = palKykNaiyouSakusei.exec(pPALKykNaiyouSakuseiBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BT_TjtIdouNyKh tjtIdouNyKh = palKykNaiyouSakusei.getTjtIdouNyKh();
        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();
        exStringEquals(idouKhMeigi.getKykdairinmkn(), "ヒホケンシジシニカナ７", "契約者代理人名（カナ）");
        exStringEquals(idouKhMeigi.getKykdairinmkj(), "受取人名漢字７", "契約者代理人名（漢字）");
        exStringEquals(idouKhMeigi.getKzktourokunmkn1(), "", "家族登録名（カナ）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkn2(), "", "家族登録名（カナ）２");
        exStringEquals(idouKhMeigi.getKzktourokunmkj2(), "", "家族登録名（漢字）２");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN2;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000079");
        PALKykNaiyouSakuseiBean pPALKykNaiyouSakuseiBean = new PALKykNaiyouSakuseiBean();
        pPALKykNaiyouSakuseiBean.setKykKihon(pKykKihon);

        C_ErrorKbn errorKbn = palKykNaiyouSakusei.exec(pPALKykNaiyouSakuseiBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BT_TjtIdouNyKh tjtIdouNyKh = palKykNaiyouSakusei.getTjtIdouNyKh();
        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();
        exStringEquals(idouKhMeigi.getKykdairinmkn(), "", "契約者代理人名（カナ）");
        exStringEquals(idouKhMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouKhMeigi.getKzktourokunmkn1(), "", "家族登録名（カナ）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkn2(), "", "家族登録名（カナ）２");
        exStringEquals(idouKhMeigi.getKzktourokunmkj2(), "", "家族登録名（漢字）２");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN2;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000116");
        PALKykNaiyouSakuseiBean pPALKykNaiyouSakuseiBean = new PALKykNaiyouSakuseiBean();
        pPALKykNaiyouSakuseiBean.setKykKihon(pKykKihon);

        C_ErrorKbn errorKbn = palKykNaiyouSakusei.exec(pPALKykNaiyouSakuseiBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BT_TjtIdouNyKh tjtIdouNyKh = palKykNaiyouSakusei.getTjtIdouNyKh();
        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();
        exStringEquals(idouKhMeigi.getKykdairinmkn(), "ヒホケンシジシニカナ９", "契約者代理人名（カナ）");
        exStringEquals(idouKhMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouKhMeigi.getKzktourokunmkn1(), "", "家族登録名（カナ）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkn2(), "", "家族登録名（カナ）２");
        exStringEquals(idouKhMeigi.getKzktourokunmkj2(), "", "家族登録名（漢字）２");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN2;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000080");
        PALKykNaiyouSakuseiBean pPALKykNaiyouSakuseiBean = new PALKykNaiyouSakuseiBean();
        pPALKykNaiyouSakuseiBean.setKykKihon(pKykKihon);

        C_ErrorKbn errorKbn = palKykNaiyouSakusei.exec(pPALKykNaiyouSakuseiBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BT_TjtIdouNyKh tjtIdouNyKh = palKykNaiyouSakusei.getTjtIdouNyKh();
        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();
        exStringEquals(idouKhMeigi.getKykdairinmkn(), "ヒホケンシジシニカナ９", "契約者代理人名（カナ）");
        exStringEquals(idouKhMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouKhMeigi.getKzktourokunmkn1(), "トウロクカゾクメイニカナ１", "家族登録名（カナ）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkj1(), "登録家族名漢字１", "家族登録名（漢字）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkn2(), "", "家族登録名（カナ）２");
        exStringEquals(idouKhMeigi.getKzktourokunmkj2(), "", "家族登録名（漢字）２");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN2;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000091");
        PALKykNaiyouSakuseiBean pPALKykNaiyouSakuseiBean = new PALKykNaiyouSakuseiBean();
        pPALKykNaiyouSakuseiBean.setKykKihon(pKykKihon);

        C_ErrorKbn errorKbn = palKykNaiyouSakusei.exec(pPALKykNaiyouSakuseiBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BT_TjtIdouNyKh tjtIdouNyKh = palKykNaiyouSakusei.getTjtIdouNyKh();
        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();
        exStringEquals(idouKhMeigi.getKykdairinmkn(), "ヒホケンシジシニカナ１０", "契約者代理人名（カナ）");
        exStringEquals(idouKhMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouKhMeigi.getKzktourokunmkn1(), "", "家族登録名（カナ）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkn2(), "トウロクカゾクメイニカナ２", "家族登録名（カナ）２");
        exStringEquals(idouKhMeigi.getKzktourokunmkj2(), "登録家族名漢字２", "家族登録名（漢字）２");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN2;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000105");
        PALKykNaiyouSakuseiBean pPALKykNaiyouSakuseiBean = new PALKykNaiyouSakuseiBean();
        pPALKykNaiyouSakuseiBean.setKykKihon(pKykKihon);

        C_ErrorKbn errorKbn = palKykNaiyouSakusei.exec(pPALKykNaiyouSakuseiBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BT_TjtIdouNyKh tjtIdouNyKh = palKykNaiyouSakusei.getTjtIdouNyKh();
        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();
        exStringEquals(idouKhMeigi.getKykdairinmkn(), "ヒホケンシジシニカナ１１", "契約者代理人名（カナ）");
        exStringEquals(idouKhMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouKhMeigi.getKzktourokunmkn1(), "トウロクカゾクメイニカナ１", "家族登録名（カナ）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkn2(), "トウロクカゾクメイニカナ２", "家族登録名（カナ）２");
        exStringEquals(idouKhMeigi.getKzktourokunmkj2(), "", "家族登録名（漢字）２");

    }
}
