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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgakuMockForKhansyuu;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZennouSeisanSyoriKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 契約変更時前納充当取消および更新のメソッド {@link KykHenkoujiZnnJytTrksKsn#exec(KhozenCommonParam, String, BizDate, BizDateYM, C_ZennouSeisanSyoriKbn
 * )} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KykHenkoujiZnnJytTrksKsnTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書_契約変更時前納充当取消および更新";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @Inject
    private KykHenkoujiZnnJytTrksKsn kykHenkoujiZnnJytTrksKsn;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Before
    public void before() {

        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(EditKoujyonaiyouTbl.class).to(EditKoujyonaiyouTblMockForKhansyuu.class);
                bind(KeisanRsgaku.class).to(KeisanRsgakuMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        EditKoujyonaiyouTblMockForKhansyuu.caller = KykHenkoujiZnnJytTrksKsnTest_exec.class;
        KeisanRsgakuMockForKhansyuu.caller = KykHenkoujiZnnJytTrksKsnTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        EditKoujyonaiyouTblMockForKhansyuu.caller = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(KykHenkoujiZnnJytTrksKsnTest_exec.class, fileName, sheetName);
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
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String syoNo = "17806000013";
        BizDate syoriYmd = BizDate.valueOf(20181105);
        BizDateYM zennouseisankgkStartYmd = BizDateYM.valueOf(201901);
        C_ZennouSeisanSyoriKbn zennouSeisanSyoriKbn = C_ZennouSeisanSyoriKbn.BLNK;
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            kykHenkoujiZnnJytTrksKsn.exec(khozenCommonParam, syoNo, syoriYmd, zennouseisankgkStartYmd,
                zennouSeisanSyoriKbn);
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約基本テーブルが取得できませんでした。 証券番号 ＝17806000013", "エラーメッセージ");
            throw e;
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        KhozenCommonParam khozenCommonParam = new KhozenCommonParam();
        String syoNo = "17806000024";
        BizDate syoriYmd = BizDate.valueOf(20181105);
        BizDateYM zennouseisankgkStartYmd = BizDateYM.valueOf(201901);
        C_ZennouSeisanSyoriKbn zennouSeisanSyoriKbn = C_ZennouSeisanSyoriKbn.BLNK;
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            kykHenkoujiZnnJytTrksKsn.exec(khozenCommonParam, syoNo, syoriYmd, zennouseisankgkStartYmd,
                zennouSeisanSyoriKbn);
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。案内収納基本テーブルが取得できませんでした。 証券番号 ＝17806000024", "エラーメッセージ");
            throw e;
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {

        KhozenCommonParam khozenCommonParam = new KhozenCommonParam();
        String syoNo = "17806000035";
        BizDate syoriYmd = BizDate.valueOf(20181105);
        BizDateYM zennouseisankgkStartYmd = BizDateYM.valueOf(201901);
        C_ZennouSeisanSyoriKbn zennouSeisanSyoriKbn = C_ZennouSeisanSyoriKbn.GENGAKU;
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            kykHenkoujiZnnJytTrksKsn.exec(khozenCommonParam, syoNo, syoriYmd, zennouseisankgkStartYmd,
                zennouSeisanSyoriKbn);
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約商品テーブルリストが取得できませんでした。 証券番号 ＝ 17806000035", "エラーメッセージ");
            throw e;
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {

        String syoNo = "17806000046";
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        BizDate syoriYmd = BizDate.valueOf(20181105);
        BizDateYM zennouseisankgkStartYmd = BizDateYM.valueOf(201901);
        C_ZennouSeisanSyoriKbn zennouSeisanSyoriKbn = C_ZennouSeisanSyoriKbn.GENGAKU;
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        try {
            kykHenkoujiZnnJytTrksKsn.exec(khozenCommonParam, syoNo, syoriYmd, zennouseisankgkStartYmd,
                zennouSeisanSyoriKbn);
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約商品テーブル（主契約）が取得できませんでした。 証券番号 ＝ 17806000046", "エラーメッセージ");
            throw e;
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(50)
    public void testExec_A5() {

        String syoNo = "17806000057";
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        BizDate syoriYmd = BizDate.valueOf(20181105);
        BizDateYM zennouseisankgkStartYmd = BizDateYM.valueOf(201901);
        C_ZennouSeisanSyoriKbn zennouSeisanSyoriKbn = C_ZennouSeisanSyoriKbn.GENGAKU;
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        try {
            kykHenkoujiZnnJytTrksKsn.exec(khozenCommonParam, syoNo, syoriYmd, zennouseisankgkStartYmd,
                zennouSeisanSyoriKbn);
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。前納テーブルが取得できませんでした。 証券番号 ＝ 17806000057", "エラーメッセージ");
            throw e;
        }
    }


    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String syoNo = "17806000068";
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        BizDate syoriYmd = BizDate.valueOf(20181105);
        BizDateYM zennouseisankgkStartYmd = BizDateYM.valueOf(201901);
        C_ZennouSeisanSyoriKbn zennouSeisanSyoriKbn = C_ZennouSeisanSyoriKbn.GENGAKU;
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        kykHenkoujiZnnJytTrksKsn.exec(khozenCommonParam, syoNo, syoriYmd, zennouseisankgkStartYmd,
            zennouSeisanSyoriKbn);

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        exNumericEquals(nyknJissekiRirekiLst.size(), 0, "取消後入金実績履歴テーブルエンティティリストの件数");

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("userID");

        String syoNo = "17806000079";
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        khozenCommonParam.setFunctionId("kinouId");
        List<IT_Zennou> zennouLst = ansyuKihon.getZennouMsisnsBySyono();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        IT_KykSyouhn kykSyouhn = syuKykSyouhnLst.get(0);

        BizDate syoriYmd = BizDate.valueOf(20181105);
        BizDateYM zennouseisankgkStartYmd = BizDateYM.valueOf(201906);
        C_ZennouSeisanSyoriKbn zennouSeisanSyoriKbn = C_ZennouSeisanSyoriKbn.GENGAKU;
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        kykHenkoujiZnnJytTrksKsn.exec(khozenCommonParam, syoNo, syoriYmd, zennouseisankgkStartYmd,
            zennouSeisanSyoriKbn);

        IT_NyknJissekiRireki nyknJissekiRireki = kykKihon.getNyknJissekiRirekiByJyutoustartymRenno(
            zennouseisankgkStartYmd, 3);
        exDateYMEquals(nyknJissekiRireki.getJyutoustartym(), BizDateYM.valueOf(201906), "充当開始年月");
        exNumericEquals(nyknJissekiRireki.getRenno(), 3, "連番");
        exDateYMEquals(nyknJissekiRireki.getJyutouendym(), BizDateYM.valueOf(201907), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRireki.getRsgaku(), BizCurrency.valueOf(400), "領収金額");
        exClassificationEquals(nyknJissekiRireki.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyknJissekiRireki.getRyosyukwsratekjymd(), BizDate.valueOf(20180101), "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRireki.getRyosyukwsrate(), BizNumber.valueOf(6.5), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRireki.getHrkp(), BizCurrency.valueOf(500), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRireki.getIktwaribikikgk(), BizCurrency.valueOf(1000), "一括割引料");
        exDateEquals(nyknJissekiRireki.getNyksyoriymd(), BizDate.valueOf(20180701), "入金処理日");
        exDateEquals(nyknJissekiRireki.getRyosyuymd(), BizDate.valueOf(20181001), "領収日");
        exStringEquals(nyknJissekiRireki.getNykdenno(), "100100100", "入金伝票番号");
        exDateEquals(nyknJissekiRireki.getNykdenymd(), BizDate.valueOf(20181002), "入金伝票日付");
        exClassificationEquals(nyknJissekiRireki.getNykkeiro(), C_Nykkeiro.SKEI, "入金経路");
        exClassificationEquals(nyknJissekiRireki.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(nyknJissekiRireki.getJyutoukaisuuy(), 18, "充当回数（年）");
        exNumericEquals(nyknJissekiRireki.getJyutoukaisuum(), 10, "充当回数（月）");
        exClassificationEquals(nyknJissekiRireki.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRireki.getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exDateEquals(nyknJissekiRireki.getYenkansantkykwsrateymd(), BizDate.valueOf(20181003), " 円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRireki.getYenkansantkykwsrate(), BizNumber.valueOf(7.8), "円換算適用為替レート");
        exStringEquals(nyknJissekiRireki.getHenkousikibetukey(), "7", "変更識別キー");
        exStringEquals(nyknJissekiRireki.getGyoumuKousinKinou(), "kinouId", "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRireki.getGyoumuKousinsyaId(), "userID", "業務用更新者ＩＤ");
        exNumericEquals(nyknJissekiRireki.getIkkatuyoupkaisuu(), 1, "一括要Ｐ回数");
        exClassificationEquals(nyknJissekiRireki.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(nyknJissekiRireki.getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRireki.getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRireki.getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRireki.getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRireki.getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exStringEquals(nyknJissekiRireki.getCreditkessaiyouno(), "80008270621", "クレジットカード決済用番号");

        IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon.getNyknJissekiRirekiByJyutoustartymRenno(
            zennouseisankgkStartYmd, 1);
        exDateYMEquals(nyknJissekiRireki1.getJyutoustartym(), BizDateYM.valueOf(201906), "充当開始年月");
        exNumericEquals(nyknJissekiRireki1.getRenno(), 1, "連番");
        exDateYMEquals(nyknJissekiRireki1.getJyutouendym(), BizDateYM.valueOf(201907), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRireki1.getRsgaku(), BizCurrency.valueOf(400), "領収金額");
        exClassificationEquals(nyknJissekiRireki1.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyknJissekiRireki1.getRyosyukwsratekjymd(), BizDate.valueOf(20180101), "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRireki1.getRyosyukwsrate(), BizNumber.valueOf(6.5), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRireki1.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRireki1.getIktwaribikikgk(), BizCurrency.valueOf(5), "一括割引料");
        exDateEquals(nyknJissekiRireki1.getNyksyoriymd(), BizDate.valueOf(20180701), "入金処理日");
        exDateEquals(nyknJissekiRireki1.getRyosyuymd(), BizDate.valueOf(20181001), "領収日");
        exStringEquals(nyknJissekiRireki1.getNykdenno(), "100100100", "入金伝票番号");
        exDateEquals(nyknJissekiRireki1.getNykdenymd(), BizDate.valueOf(20181002), "入金伝票日付");
        exClassificationEquals(nyknJissekiRireki1.getNykkeiro(), C_Nykkeiro.SKEI, "入金経路");
        exClassificationEquals(nyknJissekiRireki1.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(nyknJissekiRireki1.getJyutoukaisuuy(), 18, "充当回数（年）");
        exNumericEquals(nyknJissekiRireki1.getJyutoukaisuum(), 10, "充当回数（月）");
        exClassificationEquals(nyknJissekiRireki1.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRireki1.getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exStringEquals(nyknJissekiRireki1.getNyktrksdenno(), "0", "入金取消伝票番号");
        exDateEquals(nyknJissekiRireki1.getNyktrksdenymd(), null, " 入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRireki1.getYenkansannyknkingk(), null, "円換算入金額");
        exDateEquals(nyknJissekiRireki1.getYenkansantkykwsrateymd(), BizDate.valueOf(20181003), " 円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRireki1.getYenkansantkykwsrate(), BizNumber.valueOf(7.8), "円換算適用為替レート");
        exStringEquals(nyknJissekiRireki1.getHenkousikibetukey(), "01", "変更識別キー");
        exNumericEquals(nyknJissekiRireki1.getIkkatuyoupkaisuu(), 1, "一括要Ｐ回数");
        exClassificationEquals(nyknJissekiRireki1.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(nyknJissekiRireki1.getNyktrksflg(), C_Nyktrksflg.TORIKESI, "入金取消フラグ");
        exDateEquals(nyknJissekiRireki1.getNyktrksymd(), BizDate.valueOf(20181105), "入金取消処理日");
        exStringEquals(nyknJissekiRireki1.getGyoumuKousinKinou(), "kinouId", "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRireki1.getGyoumuKousinsyaId(), "userID", "業務用更新者ＩＤ");
        exStringEquals(nyknJissekiRireki1.getCreditkessaiyouno(), "80008270621", "クレジットカード決済用番号");

        exClassificationEquals(
            (C_UmuKbn) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "setIkkatuNyknUmu", 0, 0),
            C_UmuKbn.ARI, "一括入金有無");

        exDateYMEquals(
            (BizDateYM) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "setNyknJskStartYm", 0, 0),
            BizDateYM.valueOf(201906), "入金実績充当開始年月");

        exDateYMEquals(
            (BizDateYM) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "setNyknJskEndYm", 0, 0),
            BizDateYM.valueOf(201907), "入金実績充当終了年月");

        exNumericEquals((int) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "setNyknJskRenno", 0, 0),
            3, "入金実績連番");

        exDateEquals(
            (BizDate) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "setNyknJskRyosyuYmd", 0, 0),
            BizDate.valueOf(20181001), "入金実績領収日");

        exNumericEquals(
            (int) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "setNyknJskJytKaisuuY", 0, 0),
            18, "入金実績充当回数（年）");

        exNumericEquals(
            (int) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "setNyknJskJytKaisuuM", 0, 0),
            10, "入金実績充当回数（月）");

        exBizCalcbleEquals(
            (BizNumber) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "setNyknJskRysKwsrate", 0, 0),
            BizNumber.valueOf(6.5), "入金実績領収為替レート");

        ZennouKoujyogakuKeisanParam ZennouKoujyogakuKeisanParam =
            (ZennouKoujyogakuKeisanParam) MockObjectManager.getArgument(
                EditKoujyonaiyouTblMockForKhansyuu.class, "setZennouKoujyogakuKeisanParam", 0, 0);
        exDateEquals(ZennouKoujyogakuKeisanParam.getKjsmyouzennoukaisiymd(), BizDate.valueOf(20170101), "控除証明用前納開始年月日");

        exStringEquals(ZennouKoujyogakuKeisanParam.getKjsmyouzennoukikanm(), "12", "控除証明用前納期間（月）");

        exBizCalcbleEquals(ZennouKoujyogakuKeisanParam.getKjsmyouzennounyuukinkgk(), BizCurrency.valueOf(600),
            "控除証明用前納入金額");

        exBizCalcbleEquals(ZennouKoujyogakuKeisanParam.getHrkp(), BizCurrency.valueOf(500), "払込保険料");

        exClassificationEquals(ZennouKoujyogakuKeisanParam.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");

        exDateEquals(ZennouKoujyogakuKeisanParam.getZennoukaisiymd(), BizDate.valueOf(20170101), "前納開始年月日");

        exNumericEquals(ZennouKoujyogakuKeisanParam.getZennourenno(), 1, "前納連番");

        exBizCalcbleEquals(ZennouKoujyogakuKeisanParam.getKjsmyouyenknsnkawaserate(), BizNumber.valueOf(8.8), "前納連番");

        KhozenCommonParam khozenCommonParam1 =
            (KhozenCommonParam) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "exec", 0, 0);

        exStringEquals(khozenCommonParam1.getFunctionId(), "kinouId", "機能ID");

        exStringEquals(khozenCommonParam1.getUserID(), "userID", "ユーザID");

        exStringEquals((String) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "exec", 0, 1),
            "17806000079", "証券番号");

        exClassificationEquals(
            (C_KjsymnytblhensyuusyoriKbn) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "exec", 0, 2),
            C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, "控除証明内容ＴＢＬ編集処理区分");

        exDateEquals((BizDate) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "exec", 0, 3),
            BizDate.valueOf(20181105), "処理日");
    }


    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("userID");

        String syoNo = "17806000080";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        khozenCommonParam.setFunctionId("kinouId");

        List<IT_Zennou> zennouLst = ansyuKihon.getZennouMsisnsBySyono();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        IT_KykSyouhn kykSyouhn = syuKykSyouhnLst.get(0);
        BizDate syoriYmd = BizDate.valueOf(20181105);
        BizDateYM zennouseisankgkStartYmd = BizDateYM.valueOf(201905);
        C_ZennouSeisanSyoriKbn zennouSeisanSyoriKbn = C_ZennouSeisanSyoriKbn.GENGAKU;
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        kykHenkoujiZnnJytTrksKsn.exec(khozenCommonParam, syoNo, syoriYmd, zennouseisankgkStartYmd,
            zennouSeisanSyoriKbn);

        IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon.getNyknJissekiRirekiByJyutoustartymRenno(
            BizDateYM.valueOf(201906), 3);
        IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon.getNyknJissekiRirekiByJyutoustartymRenno(
            BizDateYM.valueOf(201907), 2);
        IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon.getNyknJissekiRirekiByJyutoustartymRenno(
            BizDateYM.valueOf(201906), 4);
        IT_NyknJissekiRireki nyknJissekiRireki4 = kykKihon.getNyknJissekiRirekiByJyutoustartymRenno(
            BizDateYM.valueOf(201905), 2);

        exDateYMEquals(nyknJissekiRireki1.getJyutoustartym(), BizDateYM.valueOf(201906), "充当開始年月");
        exNumericEquals(nyknJissekiRireki1.getRenno(), 3, "連番");
        exDateYMEquals(nyknJissekiRireki1.getJyutouendym(), BizDateYM.valueOf(201907), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRireki1.getRsgaku(), BizCurrency.valueOf(400), "領収金額");
        exClassificationEquals(nyknJissekiRireki1.getRstuukasyu(), C_Tuukasyu.USD, "領収通貨種類");
        exDateEquals(nyknJissekiRireki1.getRyosyukwsratekjymd(), BizDate.valueOf(20180105), "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRireki1.getRyosyukwsrate(), BizNumber.valueOf(6.5), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRireki1.getHrkp(), BizCurrency.valueOf(500), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRireki1.getIktwaribikikgk(), BizCurrency.valueOf(1000), "一括割引料");
        exDateEquals(nyknJissekiRireki1.getNyksyoriymd(), BizDate.valueOf(20180701), "入金処理日");
        exDateEquals(nyknJissekiRireki1.getRyosyuymd(), BizDate.valueOf(20181001), "領収日");
        exStringEquals(nyknJissekiRireki1.getNykdenno(), "100100100", "入金伝票番号");
        exDateEquals(nyknJissekiRireki1.getNykdenymd(), BizDate.valueOf(20181003), "入金伝票日付");
        exClassificationEquals(nyknJissekiRireki1.getNykkeiro(), C_Nykkeiro.SKEI, "入金経路");
        exClassificationEquals(nyknJissekiRireki1.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(nyknJissekiRireki1.getJyutoukaisuuy(), 18, "充当回数（年）");
        exNumericEquals(nyknJissekiRireki1.getJyutoukaisuum(), 10, "充当回数（月）");
        exClassificationEquals(nyknJissekiRireki1.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRireki1.getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exDateEquals(nyknJissekiRireki1.getYenkansantkykwsrateymd(), BizDate.valueOf(20181009), " 円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRireki1.getYenkansantkykwsrate(), BizNumber.valueOf(7.8), "円換算適用為替レート");
        exStringEquals(nyknJissekiRireki1.getHenkousikibetukey(), "8", "変更識別キー");
        exStringEquals(nyknJissekiRireki1.getGyoumuKousinKinou(), "kinouId", "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRireki1.getGyoumuKousinsyaId(), "userID", "業務用更新者ＩＤ");
        exNumericEquals(nyknJissekiRireki1.getIkkatuyoupkaisuu(), 1, "一括要Ｐ回数");
        exClassificationEquals(nyknJissekiRireki1.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(nyknJissekiRireki1.getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRireki1.getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRireki1.getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRireki1.getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRireki1.getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exStringEquals(nyknJissekiRireki1.getCreditkessaiyouno(), "80008270665", "クレジットカード決済用番号");
        exDateYMEquals(nyknJissekiRireki2.getJyutoustartym(), BizDateYM.valueOf(201907), "充当開始年月");
        exNumericEquals(nyknJissekiRireki2.getRenno(), 2, "連番");
        exDateYMEquals(nyknJissekiRireki2.getJyutouendym(), BizDateYM.valueOf(201908), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRireki2.getRsgaku(), BizCurrency.valueOf(400), "領収金額");
        exClassificationEquals(nyknJissekiRireki2.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyknJissekiRireki2.getRyosyukwsratekjymd(), BizDate.valueOf(20180106), "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRireki2.getRyosyukwsrate(), BizNumber.valueOf(6.6), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRireki2.getHrkp(), BizCurrency.valueOf(500), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRireki2.getIktwaribikikgk(), BizCurrency.valueOf(1000), "一括割引料");
        exDateEquals(nyknJissekiRireki2.getNyksyoriymd(), BizDate.valueOf(20180702), "入金処理日");
        exDateEquals(nyknJissekiRireki2.getRyosyuymd(), BizDate.valueOf(20181002), "領収日");
        exStringEquals(nyknJissekiRireki2.getNykdenno(), "100100101", "入金伝票番号");
        exDateEquals(nyknJissekiRireki2.getNykdenymd(), BizDate.valueOf(20181004), "入金伝票日付");
        exClassificationEquals(nyknJissekiRireki2.getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exClassificationEquals(nyknJissekiRireki2.getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exNumericEquals(nyknJissekiRireki2.getJyutoukaisuuy(), 17, "充当回数（年）");
        exNumericEquals(nyknJissekiRireki2.getJyutoukaisuum(), 11, "充当回数（月）");
        exClassificationEquals(nyknJissekiRireki2.getNyknaiyoukbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRireki2.getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exDateEquals(nyknJissekiRireki2.getYenkansantkykwsrateymd(), BizDate.valueOf(20181010), " 円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRireki2.getYenkansantkykwsrate(), BizNumber.valueOf(7.9), "円換算適用為替レート");
        exStringEquals(nyknJissekiRireki2.getHenkousikibetukey(), "8", "変更識別キー");
        exStringEquals(nyknJissekiRireki2.getGyoumuKousinKinou(), "kinouId", "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRireki2.getGyoumuKousinsyaId(), "userID", "業務用更新者ＩＤ");
        exNumericEquals(nyknJissekiRireki2.getIkkatuyoupkaisuu(), 1, "一括要Ｐ回数");
        exClassificationEquals(nyknJissekiRireki2.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(nyknJissekiRireki2.getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRireki2.getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRireki2.getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRireki2.getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRireki2.getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exStringEquals(nyknJissekiRireki1.getCreditkessaiyouno(), "80008270665", "クレジットカード決済用番号");
        exDateYMEquals(nyknJissekiRireki3.getJyutoustartym(), BizDateYM.valueOf(201906), "充当開始年月");
        exNumericEquals(nyknJissekiRireki3.getRenno(), 4, "連番");
        exDateYMEquals(nyknJissekiRireki3.getJyutouendym(), BizDateYM.valueOf(201907), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRireki3.getRsgaku(), BizCurrency.valueOf(400), "領収金額");
        exClassificationEquals(nyknJissekiRireki3.getRstuukasyu(), C_Tuukasyu.USD, "領収通貨種類");
        exDateEquals(nyknJissekiRireki3.getRyosyukwsratekjymd(), BizDate.valueOf(20180107), "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRireki3.getRyosyukwsrate(), BizNumber.valueOf(6.7), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRireki3.getHrkp(), BizCurrency.valueOf(500), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRireki3.getIktwaribikikgk(), BizCurrency.valueOf(1000), "一括割引料");
        exDateEquals(nyknJissekiRireki3.getNyksyoriymd(), BizDate.valueOf(20180703), "入金処理日");
        exDateEquals(nyknJissekiRireki3.getRyosyuymd(), BizDate.valueOf(20181003), "領収日");
        exStringEquals(nyknJissekiRireki3.getNykdenno(), "100100102", "入金伝票番号");
        exDateEquals(nyknJissekiRireki3.getNykdenymd(), BizDate.valueOf(20181005), "入金伝票日付");
        exClassificationEquals(nyknJissekiRireki3.getNykkeiro(), C_Nykkeiro.CONVENI, "入金経路");
        exClassificationEquals(nyknJissekiRireki3.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exNumericEquals(nyknJissekiRireki3.getJyutoukaisuuy(), 16, "充当回数（年）");
        exNumericEquals(nyknJissekiRireki3.getJyutoukaisuum(), 12, "充当回数（月）");
        exClassificationEquals(nyknJissekiRireki3.getNyknaiyoukbn(), C_NyknaiyouKbn.HENKOUGOP, "入金内容区分");
        exClassificationEquals(nyknJissekiRireki3.getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exDateEquals(nyknJissekiRireki3.getYenkansantkykwsrateymd(), BizDate.valueOf(20181011), " 円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRireki3.getYenkansantkykwsrate(), BizNumber.valueOf(8.1), "円換算適用為替レート");
        exStringEquals(nyknJissekiRireki3.getHenkousikibetukey(), "8", "変更識別キー");
        exStringEquals(nyknJissekiRireki3.getGyoumuKousinKinou(), "kinouId", "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRireki3.getGyoumuKousinsyaId(), "userID", "業務用更新者ＩＤ");
        exNumericEquals(nyknJissekiRireki3.getIkkatuyoupkaisuu(), 1, "一括要Ｐ回数");
        exClassificationEquals(nyknJissekiRireki3.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(nyknJissekiRireki3.getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRireki3.getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRireki3.getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRireki3.getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRireki3.getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exStringEquals(nyknJissekiRireki1.getCreditkessaiyouno(), "80008270665", "クレジットカード決済用番号");
        exDateYMEquals(nyknJissekiRireki4.getJyutoustartym(), BizDateYM.valueOf(201905), "充当開始年月");
        exNumericEquals(nyknJissekiRireki4.getRenno(), 2, "連番");
        exDateYMEquals(nyknJissekiRireki4.getJyutouendym(), BizDateYM.valueOf(201907), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRireki4.getRsgaku(), BizCurrency.valueOf(400), "領収金額");
        exClassificationEquals(nyknJissekiRireki4.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyknJissekiRireki4.getRyosyukwsratekjymd(), BizDate.valueOf(20180108), "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRireki4.getRyosyukwsrate(), BizNumber.valueOf(6.8), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRireki4.getHrkp(), BizCurrency.valueOf(500), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRireki4.getIktwaribikikgk(), BizCurrency.valueOf(1000), "一括割引料");
        exDateEquals(nyknJissekiRireki4.getNyksyoriymd(), BizDate.valueOf(20180704), "入金処理日");
        exDateEquals(nyknJissekiRireki4.getRyosyuymd(), BizDate.valueOf(20181004), "領収日");
        exStringEquals(nyknJissekiRireki4.getNykdenno(), "100100103", "入金伝票番号");
        exDateEquals(nyknJissekiRireki4.getNykdenymd(), BizDate.valueOf(20181006), "入金伝票日付");
        exClassificationEquals(nyknJissekiRireki4.getNykkeiro(), C_Nykkeiro.ZENNOUJYUUTOU, "入金経路");
        exClassificationEquals(nyknJissekiRireki4.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exNumericEquals(nyknJissekiRireki4.getJyutoukaisuuy(), 15, "充当回数（年）");
        exNumericEquals(nyknJissekiRireki4.getJyutoukaisuum(), 12, "充当回数（月）");
        exClassificationEquals(nyknJissekiRireki4.getNyknaiyoukbn(), C_NyknaiyouKbn.HUKKATUYOUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRireki4.getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exDateEquals(nyknJissekiRireki4.getYenkansantkykwsrateymd(), BizDate.valueOf(20181012), " 円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRireki4.getYenkansantkykwsrate(), BizNumber.valueOf(8.2), "円換算適用為替レート");
        exStringEquals(nyknJissekiRireki4.getHenkousikibetukey(), "8", "変更識別キー");
        exStringEquals(nyknJissekiRireki4.getGyoumuKousinKinou(), "kinouId", "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRireki4.getGyoumuKousinsyaId(), "userID", "業務用更新者ＩＤ");
        exNumericEquals(nyknJissekiRireki4.getIkkatuyoupkaisuu(), 1, "一括要Ｐ回数");
        exClassificationEquals(nyknJissekiRireki4.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(nyknJissekiRireki4.getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRireki4.getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRireki4.getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRireki4.getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRireki4.getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exStringEquals(nyknJissekiRireki1.getCreditkessaiyouno(), "80008270665", "クレジットカード決済用番号");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        baseUserInfo.getUser().setUserId("userID");
        String syoNo = "17806000091";
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        khozenCommonParam.setFunctionId("kinouId");
        BizDate syoriYmd = BizDate.valueOf(20181105);
        BizDateYM zennouseisankgkStartYmd = BizDateYM.valueOf(201901);
        C_ZennouSeisanSyoriKbn zennouSeisanSyoriKbn = C_ZennouSeisanSyoriKbn.SYOUMETU;
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        kykHenkoujiZnnJytTrksKsn.exec(khozenCommonParam, syoNo, syoriYmd, zennouseisankgkStartYmd,
            zennouSeisanSyoriKbn);

        ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);

        exDateYMEquals(ansyuKihon.getJkipjytym(), BizDateYM.valueOf(201807), "次回Ｐ充当年月");
        exStringEquals(ansyuKihon.getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");
        exStringEquals(ansyuKihon.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        baseUserInfo.getUser().setUserId("userID");
        String syoNo = "17806000105";
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        khozenCommonParam.setFunctionId("kinouId");
        BizDate syoriYmd = BizDate.valueOf(20181105);
        BizDateYM zennouseisankgkStartYmd = BizDateYM.valueOf(201901);
        C_ZennouSeisanSyoriKbn zennouSeisanSyoriKbn = C_ZennouSeisanSyoriKbn.SYOUMETU;
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        kykHenkoujiZnnJytTrksKsn.exec(khozenCommonParam, syoNo, syoriYmd, zennouseisankgkStartYmd,
            zennouSeisanSyoriKbn);

        ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);

        exDateYMEquals(ansyuKihon.getJkipjytym(), BizDateYM.valueOf(201906), "次回Ｐ充当年月");
        exStringEquals(ansyuKihon.getGyoumuKousinKinou(), "kinouId", "業務用更新機能ＩＤ");
        exStringEquals(ansyuKihon.getGyoumuKousinsyaId(), "userID", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("userID");

        String syoNo = "17806000301";
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        khozenCommonParam.setFunctionId("kinouId");
        List<IT_Zennou> zennouLst = ansyuKihon.getZennouMsisnsBySyono();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        IT_KykSyouhn kykSyouhn = syuKykSyouhnLst.get(0);

        BizDate syoriYmd = BizDate.valueOf(20181105);
        BizDateYM zennouseisankgkStartYmd = BizDateYM.valueOf(201906);
        C_ZennouSeisanSyoriKbn zennouSeisanSyoriKbn = C_ZennouSeisanSyoriKbn.GENGAKU;
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        kykHenkoujiZnnJytTrksKsn.exec(khozenCommonParam, syoNo, syoriYmd, zennouseisankgkStartYmd,
            zennouSeisanSyoriKbn);

        IT_NyknJissekiRireki nyknJissekiRireki = kykKihon.getNyknJissekiRirekiByJyutoustartymRenno(
            zennouseisankgkStartYmd, 3);
        exDateYMEquals(nyknJissekiRireki.getJyutoustartym(), BizDateYM.valueOf(201906), "充当開始年月");
        exNumericEquals(nyknJissekiRireki.getRenno(), 3, "連番");
        exDateYMEquals(nyknJissekiRireki.getJyutouendym(), BizDateYM.valueOf(201907), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRireki.getRsgaku(), BizCurrency.valueOf(40492, BizCurrencyTypes.DOLLAR), "領収金額");
        exClassificationEquals(nyknJissekiRireki.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyknJissekiRireki.getRyosyukwsratekjymd(), BizDate.valueOf(20180101), "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRireki.getRyosyukwsrate(), BizNumber.valueOf(6.5), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRireki.getHrkp(), BizCurrency.valueOf(500), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRireki.getIktwaribikikgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "一括割引料");
        exDateEquals(nyknJissekiRireki.getNyksyoriymd(), BizDate.valueOf(20180701), "入金処理日");
        exDateEquals(nyknJissekiRireki.getRyosyuymd(), BizDate.valueOf(20181001), "領収日");
        exStringEquals(nyknJissekiRireki.getNykdenno(), "100100100", "入金伝票番号");
        exDateEquals(nyknJissekiRireki.getNykdenymd(), BizDate.valueOf(20181002), "入金伝票日付");
        exClassificationEquals(nyknJissekiRireki.getNykkeiro(), C_Nykkeiro.SKEI, "入金経路");
        exClassificationEquals(nyknJissekiRireki.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(nyknJissekiRireki.getJyutoukaisuuy(), 18, "充当回数（年）");
        exNumericEquals(nyknJissekiRireki.getJyutoukaisuum(), 10, "充当回数（月）");
        exClassificationEquals(nyknJissekiRireki.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRireki.getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exDateEquals(nyknJissekiRireki.getYenkansantkykwsrateymd(), BizDate.valueOf(20181003), " 円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRireki.getYenkansantkykwsrate(), BizNumber.valueOf(7.8), "円換算適用為替レート");
        exStringEquals(nyknJissekiRireki.getHenkousikibetukey(), "7", "変更識別キー");
        exStringEquals(nyknJissekiRireki.getGyoumuKousinKinou(), "kinouId", "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRireki.getGyoumuKousinsyaId(), "userID", "業務用更新者ＩＤ");
        exNumericEquals(nyknJissekiRireki.getIkkatuyoupkaisuu(), 1, "一括要Ｐ回数");
        exClassificationEquals(nyknJissekiRireki.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(nyknJissekiRireki.getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRireki.getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRireki.getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRireki.getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRireki.getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exStringEquals(nyknJissekiRireki.getCreditkessaiyouno(), "80008270621", "クレジットカード決済用番号");
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN2;

        baseUserInfo.getUser().setUserId("userID");

        String syoNo = "17806000404";
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        khozenCommonParam.setFunctionId("kinouId");
        List<IT_Zennou> zennouLst = ansyuKihon.getZennouMsisnsBySyono();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        IT_KykSyouhn kykSyouhn = syuKykSyouhnLst.get(0);

        BizDate syoriYmd = BizDate.valueOf(20181105);
        BizDateYM zennouseisankgkStartYmd = BizDateYM.valueOf(201906);
        C_ZennouSeisanSyoriKbn zennouSeisanSyoriKbn = C_ZennouSeisanSyoriKbn.GENGAKU;
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        try {
            kykHenkoujiZnnJytTrksKsn.exec(khozenCommonParam, syoNo, syoriYmd, zennouseisankgkStartYmd,
                zennouSeisanSyoriKbn);
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。領収金額計算でエラーが発生しました。証券番号＝17806000404", "エラーメッセージ");
            throw e;
        }
    }
}
