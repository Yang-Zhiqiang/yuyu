package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
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
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwari;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwariMockForHozen;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiMq;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiMqMockForHozen;
import yuyu.common.biz.bznayose.BzTrksIraiMq;
import yuyu.common.biz.bznayose.BzTrksIraiMqMockForHozen;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＰＡＬ契約内容更新処理クラスのメソッド {@link PALKykNaiyouKousin#exec(IT_KykKihon)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class PALKykNaiyouKousinTest_exec {

    private final static String syoNo2 = "12806345683";

    private final static String syoNo8 = "12806345742";

    @Inject
    private PALKykNaiyouKousin palKykNaiyouKousin;

    @Inject
    private HozenDomManager hozenManager;

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＰＡＬ契約内容更新処理";
    private final static String sheetName = "テストデータ";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(BzKykNaiyouHaneiMq.class).to(BzKykNaiyouHaneiMqMockForHozen.class);
                bind(BzTrksIraiMq.class).to(BzTrksIraiMqMockForHozen.class);
                bind(BzGetTuukeiBunwari.class).to(BzGetTuukeiBunwariMockForHozen.class);
                bind(GetKhTuusanyouKngk.class).to(GetKhTuusanyouKngkMockForHozen.class);
            }
        });
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        try {
            BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN1;
            BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN1;
            GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
            IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345672");

            palKykNaiyouKousin.exec(itKykKihon);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "ＰＡＬ契約内容更新処理が実施不可のため、処理できませんでした。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        try {
            BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN2;
            BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN1;
            GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
            IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345672");

            palKykNaiyouKousin.exec(itKykKihon);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "ＰＡＬあて反映不能です。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        try {
            BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN4;
            BzTrksIraiMqMockForHozen.SYORIPTN = BzTrksIraiMqMockForHozen.TESTPATTERN1;
            BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN1;
            GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;

            IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345672");

            palKykNaiyouKousin.exec(itKykKihon);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "ＰＡＬ契約内容更新エラーのため、処理できませんでした。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        try {
            BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN4;
            BzTrksIraiMqMockForHozen.SYORIPTN = BzTrksIraiMqMockForHozen.TESTPATTERN2;
            BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN1;
            GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;

            IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345672");

            palKykNaiyouKousin.exec(itKykKihon);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "ＰＡＬのみ処理済です。データ修正を行ってください。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        try {
            BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN4;
            BzTrksIraiMqMockForHozen.SYORIPTN = BzTrksIraiMqMockForHozen.TESTPATTERN4;
            BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN1;
            GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;

            IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345672");

            palKykNaiyouKousin.exec(itKykKihon);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "ＰＡＬのみ処理済の可能性があります。処理済の場合はデータ修正を行ってください。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(140)
    public void testExec_A6() {
        try {
            BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN1;
            BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN2;
            GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
            IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345672");

            palKykNaiyouKousin.exec(itKykKihon);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。通計用代理店分担割合取得が実行できませんでした。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_B1() {

        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN3;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN1;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345683");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        BT_TjtIdouNyKh tjtIdouNyKh = bizDomManager.getTjtIdouNyKh(syoNo2, 1);
        exStringEquals(tjtIdouNyKh.getSyono(), "12806345683", "証券番号");
        exNumericEquals(tjtIdouNyKh.getRenno3keta(), 1, "連番（３桁）");
        exNumericEquals(tjtIdouNyKh.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exStringEquals(tjtIdouNyKh.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNyKh.getSyouhncd(), "", "商品コード");
        exClassificationEquals(tjtIdouNyKh.getKykjyoutai(), C_Kykjyoutai.BLNK, "契約状態");
        exDateEquals(tjtIdouNyKh.getKykymd(), null, "契約日");
        exClassificationEquals(tjtIdouNyKh.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.BLNK, "有効消滅区分");
        exClassificationEquals(tjtIdouNyKh.getSyoumetujiyuu(), C_Syoumetujiyuu.BLNK, "消滅事由");
        exDateEquals(tjtIdouNyKh.getSyoumetuymd(), null, "消滅日");
        exClassificationEquals(tjtIdouNyKh.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exClassificationEquals(tjtIdouNyKh.getTsntuukasyu(), C_Tuukasyu.JPY, "通算用通貨種類");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyousibous(), BizCurrency.valueOf(0), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyouitijip(), BizCurrency.valueOf(0), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyounkgns(), BizCurrency.valueOf(0), "通算用年金原資");
        exNumericEquals(tjtIdouNyKh.getHrkkkn(), 0, "払込期間");
        exClassificationEquals(tjtIdouNyKh.getSntkhoukbn(), C_SntkhouKbn.BLNK, "選択方法区分");
        exDateYMEquals(tjtIdouNyKh.getBosyuuym(), null, "募集年月");
        exNumericEquals(tjtIdouNyKh.getKykhhkndouhyouji(), 0, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn1(), C_TtdktyuuiKbn.BLNK, "手続注意区分１");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn2(), C_TtdktyuuiKbn.BLNK, "手続注意区分２");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn3(), C_TtdktyuuiKbn.BLNK, "手続注意区分３");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn4(), C_TtdktyuuiKbn.BLNK, "手続注意区分４");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn5(), C_TtdktyuuiKbn.BLNK, "手続注意区分５");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyennyknkgk(), BizCurrency.valueOf(0), "通算用円入金額");
        exClassificationEquals(tjtIdouNyKh.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exStringEquals(tjtIdouNyKh.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNyKh.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(tjtIdouNyKh.getGyoumuKousinTime(), "", "業務用更新時間");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_B2() {

        MockObjectManager.initialize();
        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN6;
        BzTrksIraiMqMockForHozen.SYORIPTN = BzTrksIraiMqMockForHozen.TESTPATTERN3;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN1;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;

        IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345694");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        exStringEquals((String) MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 0), "d010101", "代理店コード１");
        assertNull("親代理店コード１", MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 1));
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 2), BizNumber.valueOf(50), "分担割合１");
        exStringEquals((String) MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 3), "d020202", "代理店コード２");
        assertNull("親代理店コード２", MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 4));
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 5), BizNumber.valueOf(50), "分担割合２");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 6), BizDateYM.valueOf(201708), "基準年月");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn) MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 7), C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKAKJNNKITIJI, "代理店商品識別区分");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 8), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals((C_DiritenplannmKbn) MockObjectManager.getArgument(BzGetTuukeiBunwariMockForHozen.class, "exec", 0, 9), C_DiritenplannmKbn.BLNK, "代理店プラン名区分");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_B3() {

        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN3;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN1;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345708");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_B4() {

        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN3;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN1;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345719");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_B5() {

        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN3;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN1;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345720");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_B6() {

        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN3;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN1;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345731");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_B7() {

        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN5;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = BzGetTuukeiBunwariMockForHozen.TESTPATTERN1;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345742");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        BT_TjtIdouNyKh tjtIdouNyKh = bizDomManager.getTjtIdouNyKh(syoNo8, 111);
        exStringEquals(tjtIdouNyKh.getSyono(), "12806345742", "証券番号");
        exNumericEquals(tjtIdouNyKh.getRenno3keta(), 111, "連番（３桁）");
        exNumericEquals(tjtIdouNyKh.getRecordsakujyohyouji(), 2, "レコード削除表示");
        exStringEquals(tjtIdouNyKh.getYoukyuuno(), "ykno10000187654321", "要求通番");
        exStringEquals(tjtIdouNyKh.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(tjtIdouNyKh.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(tjtIdouNyKh.getKykymd(), BizDate.valueOf(20160301), "契約日");
        exClassificationEquals(tjtIdouNyKh.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tjtIdouNyKh.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tjtIdouNyKh.getSyoumetuymd(), BizDate.valueOf(20160302), "消滅日");
        exClassificationEquals(tjtIdouNyKh.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(tjtIdouNyKh.getTsntuukasyu(), C_Tuukasyu.JPY, "通算用通貨種類");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyousibous(), BizCurrency.valueOf(456), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyouitijip(), BizCurrency.valueOf(789), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyounkgns(), BizCurrency.valueOf(123), "通算用年金原資");
        exNumericEquals(tjtIdouNyKh.getHrkkkn(), 10, "払込期間");
        exClassificationEquals(tjtIdouNyKh.getSntkhoukbn(), C_SntkhouKbn.KKT, "選択方法区分");
        exDateYMEquals(tjtIdouNyKh.getBosyuuym(), BizDateYM.valueOf(201603), "募集年月");
        exNumericEquals(tjtIdouNyKh.getKykhhkndouhyouji(), 9, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn1(), C_TtdktyuuiKbn.TTDKTYUUOUTAITYUUI, "手続注意区分１");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn2(), C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI, "手続注意区分２");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn3(), C_TtdktyuuiKbn.HASANOYOBITOUSAN, "手続注意区分３");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn4(), C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE, "手続注意区分４");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn5(), C_TtdktyuuiKbn.KYKSYAYUKUEHUMEI, "手続注意区分５");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyennyknkgk(), BizCurrency.valueOf(10000), "通算用円入金額");
        exClassificationEquals(tjtIdouNyKh.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exStringEquals(tjtIdouNyKh.getGyoumuKousinKinou(), "PALKykNaiyouKousin", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNyKh.getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");
        exStringEquals(tjtIdouNyKh.getGyoumuKousinTime(), "20160303121212999", "業務用更新時間");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_B8() {

        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN3;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345753");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_C1() {

        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN3;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345764");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_C2() {

        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN3;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345775");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_C3() {

        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN3;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        IT_KykKihon itKykKihon = hozenManager.getKykKihon("12806345786");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExec_D1() {

        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN3;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        IT_KykKihon itKykKihon = hozenManager.getKykKihon("99806030029");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExec_D2() {

        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN3;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        IT_KykKihon itKykKihon = hozenManager.getKykKihon("99806030063");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExec_D3() {

        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN3;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        IT_KykKihon itKykKihon = hozenManager.getKykKihon("99806030096");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExec_D4() {

        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = BzKykNaiyouHaneiMqMockForHozen.TESTPATTERN3;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = GetKhTuusanyouKngkMockForHozen.TESTPATTERN1;
        IT_KykKihon itKykKihon = hozenManager.getKykKihon("99806034713");

        palKykNaiyouKousin.exec(itKykKihon);

        exClassificationEquals(palKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "被保険者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getHhknSakuinmeino(), "1000000001", "被保険者索引名番号");
        exClassificationEquals(palKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "契約者名寄せ実施結果区分");
        exStringEquals(palKykNaiyouKousin.getKykSakuinmeino(), "1000000001", "契約者索引名番号");
        exStringEquals(palKykNaiyouKousin.getYoukyuuno(), "ykno10000187654321", "要求通番");

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @BeforeClass
    public static void testInit(){

        BzKykNaiyouHaneiMqMockForHozen.caller = PALKykNaiyouKousinTest_exec.class;
        BzGetTuukeiBunwariMockForHozen.caller = PALKykNaiyouKousinTest_exec.class;
        BzTrksIraiMqMockForHozen.caller = PALKykNaiyouKousinTest_exec.class;
        GetKhTuusanyouKngkMockForHozen.caller = PALKykNaiyouKousinTest_exec.class;
        BzKykNaiyouHaneiMqMockForHozen.SYORIPTN = null;
        BzGetTuukeiBunwariMockForHozen.SYORIPTN = null;
        BzTrksIraiMqMockForHozen.SYORIPTN = null;
        GetKhTuusanyouKngkMockForHozen.SYORIPTN = null;
    }

    @AfterClass
    public static void testClear() {
        BzKykNaiyouHaneiMqMockForHozen.caller = null;
        BzGetTuukeiBunwariMockForHozen.caller = null;
        BzTrksIraiMqMockForHozen.caller = null;
        GetKhTuusanyouKngkMockForHozen.caller = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(PALKykNaiyouKousinTest_exec.class, fileName,
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
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }
}
