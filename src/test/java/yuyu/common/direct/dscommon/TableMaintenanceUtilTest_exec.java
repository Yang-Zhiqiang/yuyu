package yuyu.common.direct.dscommon;

import static org.junit.Assert.*;
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
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_BaitaiKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_SeisaHuyouHyj;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link TableMaintenanceUtil#}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class TableMaintenanceUtilTest_exec {


    @Inject
    private TableMaintenanceUtil tableMaintenanceUtil;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_テーブルメンテナンスユーティリティ";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(TableMaintenanceUtilTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
        directDomManager.delete(directDomManager.getAllBAKDsKokyakuKanri());

        MockObjectManager.initialize();
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testTableMaintenanceUtil_exec1() {

        MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = tableMaintenanceUtil.exec("123456701", "12345");

        assertNotNull(bakDsKokyakuKanri);
        exStringEquals(bakDsKokyakuKanri.getDskokno(), "123456701", "ＤＳ顧客番号");
        exStringEquals(bakDsKokyakuKanri.getTrkssikibetukey(), "12345", "取消識別キー");
        exClassificationEquals(bakDsKokyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.SEISA_SYOUMETU, "ＤＳ顧客状態区分");
        exDateEquals(bakDsKokyakuKanri.getDskokyakusakuseiymd(), BizDate.valueOf("20160401"), "ＤＳ顧客作成年月日");
        exClassificationEquals(bakDsKokyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.OMOUSIDE, "ＤＳ停止理由区分");
        exDateEquals(bakDsKokyakuKanri.getDskokyakumukouymd(), BizDate.valueOf("20160404"), "ＤＳ顧客無効年月日");
        exClassificationEquals(bakDsKokyakuKanri.getSeisahuyouhyj(), C_SeisaHuyouHyj.SEISA_HUYOU, "精査不要表示");
        exStringEquals(bakDsKokyakuKanri.getDskokyakunmkn(), "カナ", "ＤＳ顧客名（カナ)");
        exStringEquals(bakDsKokyakuKanri.getDskokyakunmkj(), "漢字", "ＤＳ顧客名（漢字）");
        exDateEquals(bakDsKokyakuKanri.getDskokyakuseiymd(), BizDate.valueOf("19881206"), "ＤＳ顧客生年月日");
        exStringEquals(bakDsKokyakuKanri.getDskokyakuyno(), "435400", "ＤＳ顧客郵便番号");
        exStringEquals(bakDsKokyakuKanri.getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(bakDsKokyakuKanri.getGyoumuKousinTime(),"20160411141111111","業務用更新時間");
        exStringEquals(bakDsKokyakuKanri.getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getDskokno(), "123456701", "ＤＳ顧客番号");
        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getTrkssikibetukey(), "12345", "取消識別キー");
        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getDskrhnnkakcd(), "A20010327", "ＤＳ仮本人確認コード");
        exClassificationEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getDskrhnnkakcdsetkbn(), C_DsKrHnnKakCdSetKbn.SAIHAKKOU, "ＤＳ仮本人確認コード設定区分");
        exDateEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getDskrhnnkakcdsetymd(), BizDate.valueOf("20160201"), "ＤＳ仮本人確認コード設定年月日");
        exDateEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getDskrhnnkakcdyuukouymd(), BizDate.valueOf("20160204"), "ＤＳ仮本人確認コード有効年月日");
        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getDshnnkakcd(), "B1989", "ＤＳ本人確認コード");
        exDateEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getDshnnkakcdsetymd(), BizDate.valueOf("20160206"), "ＤＳ本人確認コード設定年月日");
        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getZenkaidskrhnnkakcd(), "C1999", "前回ＤＳ仮本人確認コード");
        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getGyoumuKousinTime(),"20160411141111111","業務用更新時間");
        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        exStringEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getDskokno(), "123456701", "ＤＳ顧客番号");
        exStringEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getTrkssikibetukey(), "12345", "取消識別キー");
        exDateEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getSyokailoginymd(), BizDate.valueOf("20000121"), "初回ログイン年月日");
        exStringEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getSyokailogintime(), "142140", "初回ログイン時刻");
        exClassificationEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getSyokailoginbaitaikbn(), C_BaitaiKbn.PC, "初回ログイン媒体区分");
        exDateEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getSaisinloginymd(), BizDate.valueOf("20160311"), "最新ログイン年月日");
        exStringEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getSaisinlogintime(), "142021", "最新ログイン時刻");
        exClassificationEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getSaisinloginbaitaikbn(), C_BaitaiKbn.PC, "最新ログイン媒体区分");
        exNumericEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getDshnnkakcderrorkaisuu(), 5, "ＤＳ本人確認コードエラー回数");
        exNumericEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getDskokyakunmerrorkaisuu(), 3, "ＤＳ顧客名エラー回数");
        exNumericEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getDskokyakuseiymderrorkaisuu(), 7, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getDskokyakutelnoerrorkaisuu(), 2, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getGyoumuKousinTime(),"20160411141111111","業務用更新時間");
        exStringEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        exStringEquals(bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus().get(0).getDskokno(), "123456701", "ＤＳ顧客番号");
        exStringEquals(bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus().get(0).getTrkssikibetukey(), "12345", "取消識別キー");
        exStringEquals(bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus().get(0).getSyono(), "11807111118", "証券番号");
        exDateEquals(bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus().get(0).getDskykkanyuuymd(), BizDate.valueOf("20150311"), "ＤＳ契約加入年月日");
        exDateEquals(bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus().get(0).getDskykhenkouymd(), BizDate.valueOf("20150511"), "ＤＳ契約変更年月日");
        exClassificationEquals(bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus().get(0).getDskykmukouhyj(), C_MukouHyj.MUKOU, "ＤＳ契約無効表示");
        exDateEquals(bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus().get(0).getDskykmukouymd(), BizDate.valueOf("20150930"), "ＤＳ契約無効年月日");
        exStringEquals(bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus().get(0).getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus().get(0).getGyoumuKousinTime(),"20160411141111111","業務用更新時間");
        exStringEquals(bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus().get(0).getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        directDomManager.insert(bakDsKokyakuKanri);
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testTableMaintenanceUtil_exec2() {

        MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = tableMaintenanceUtil.exec("123456702", "12340");

        assertNull(bakDsKokyakuKanri);
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testTableMaintenanceUtil_exec3() {

        MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = tableMaintenanceUtil.exec("123456703", "12346");

        assertNotNull(bakDsKokyakuKanri);
        exStringEquals(bakDsKokyakuKanri.getDskokno(), "123456703", "ＤＳ顧客番号");
        exStringEquals(bakDsKokyakuKanri.getTrkssikibetukey(), "12346", "取消識別キー");
        exClassificationEquals(bakDsKokyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.SEISA_SYOUMETU, "ＤＳ顧客状態区分");
        exDateEquals(bakDsKokyakuKanri.getDskokyakusakuseiymd(), BizDate.valueOf("20160401"), "ＤＳ顧客作成年月日");
        exClassificationEquals(bakDsKokyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.OMOUSIDE, "ＤＳ停止理由区分");
        exDateEquals(bakDsKokyakuKanri.getDskokyakumukouymd(), BizDate.valueOf("20160404"), "ＤＳ顧客無効年月日");
        exClassificationEquals(bakDsKokyakuKanri.getSeisahuyouhyj(), C_SeisaHuyouHyj.SEISA_HUYOU, "精査不要表示");
        exStringEquals(bakDsKokyakuKanri.getDskokyakunmkn(), "カナ", "ＤＳ顧客名（カナ)");
        exStringEquals(bakDsKokyakuKanri.getDskokyakunmkj(), "漢字", "ＤＳ顧客名（漢字）");
        exDateEquals(bakDsKokyakuKanri.getDskokyakuseiymd(), BizDate.valueOf("19881206"), "ＤＳ顧客生年月日");
        exStringEquals(bakDsKokyakuKanri.getDskokyakuyno(), "435400", "ＤＳ顧客郵便番号");
        exStringEquals(bakDsKokyakuKanri.getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(bakDsKokyakuKanri.getGyoumuKousinTime(),"20160411141111111","業務用更新時間");
        exStringEquals(bakDsKokyakuKanri.getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getDskokno(), "123456703", "ＤＳ顧客番号");
        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getTrkssikibetukey(), "12346", "取消識別キー");
        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getDskrhnnkakcd(), "A20010327", "ＤＳ仮本人確認コード");
        exClassificationEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getDskrhnnkakcdsetkbn(), C_DsKrHnnKakCdSetKbn.SAIHAKKOU, "ＤＳ仮本人確認コード設定区分");
        exDateEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getDskrhnnkakcdsetymd(), BizDate.valueOf("20160201"), "ＤＳ仮本人確認コード設定年月日");
        exDateEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getDskrhnnkakcdyuukouymd(), BizDate.valueOf("20160204"), "ＤＳ仮本人確認コード有効年月日");
        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getDshnnkakcd(), "B1989", "ＤＳ本人確認コード");
        exDateEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getDshnnkakcdsetymd(), BizDate.valueOf("20160206"), "ＤＳ本人確認コード設定年月日");
        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getZenkaidskrhnnkakcd(), "C1999", "前回ＤＳ仮本人確認コード");
        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getGyoumuKousinTime(),"20160411141111111","業務用更新時間");
        exStringEquals(bakDsKokyakuKanri.getBAKDsHonninKakuninCd().getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        exStringEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getDskokno(), "123456703", "ＤＳ顧客番号");
        exStringEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getTrkssikibetukey(), "12346", "取消識別キー");
        exDateEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getSyokailoginymd(), BizDate.valueOf("20000120"), "初回ログイン年月日");
        exStringEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getSyokailogintime(), "142140", "初回ログイン時刻");
        exClassificationEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getSyokailoginbaitaikbn(), C_BaitaiKbn.PC, "初回ログイン媒体区分");
        exDateEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getSaisinloginymd(), BizDate.valueOf("20160311"), "最新ログイン年月日");
        exStringEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getSaisinlogintime(), "142021", "最新ログイン時刻");
        exClassificationEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getSaisinloginbaitaikbn(), C_BaitaiKbn.PC, "最新ログイン媒体区分");
        exNumericEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getDshnnkakcderrorkaisuu(), 5, "ＤＳ本人確認コードエラー回数");
        exNumericEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getDskokyakunmerrorkaisuu(), 3, "ＤＳ顧客名エラー回数");
        exNumericEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getDskokyakuseiymderrorkaisuu(), 7, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getDskokyakutelnoerrorkaisuu(), 2, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getGyoumuKousinTime(),"20160411141111111","業務用更新時間");
        exStringEquals(bakDsKokyakuKanri.getBAKDsLoginKanri().getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        exNumericEquals(bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus().size(), 0, "ＤＳ顧客契約テーブルリストサイズ");

    }
}
