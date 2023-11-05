package yuyu.common.biz.bznayose;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HouteiTyotkseiSyouhnHyjKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import yuyu.def.db.entity.BT_IdouNkBosyuudr;
import yuyu.def.db.entity.BT_IdouNkMeigi;
import yuyu.def.db.entity.BT_IdouSkBosyuudr;
import yuyu.def.db.entity.BT_IdouSkMeigi;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.BT_YoukyuuNoKanri;
import yuyu.infrext.mq.MqApiCaller;
import yuyu.infrext.mq.MqApiCallerStubForSinkeiyaku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * PALあて契約内容反映（MQ）クラスのメソッド {@link BzKykNaiyouHaneiMq#exec(BzKykNaiyouHaneiYokenBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzKykNaiyouHaneiMqTest_exec2 {

    @Inject
    BzKykNaiyouHaneiMqTest_exec1 test1;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_PALあて契約内容反映（MQ）";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){

        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(MqApiCaller.class).to(MqApiCallerStubForSinkeiyaku.class);
            }
        });
    }

    @AfterClass
    public static void testClear() {
        MqApiCallerStubForSinkeiyaku.caller = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        MqApiCallerStubForSinkeiyaku.caller = BzKykNaiyouHaneiMqTest_exec2.class;

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzKykNaiyouHaneiMqTest_exec2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
        bizDomManager.delete(bizDomManager.getAllTjtIdouNySk());
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyNk());
        bizDomManager.delete(bizDomManager.getAllMqBatchSosiki());
        bizDomManager.delete(bizDomManager.getAllYoukyuuNoKanri());
    }

    @Test
    @TestOrder(10)
    public void testExec2_A1() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN1;

        MockObjectManager.initialize();

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        test1.editYokenData(bzKykNaiyouHaneiYokenBean);
        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);
        test1.editYokenKbnToDefault(bzKykNaiyouHaneiYokenBean);

        bzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(1234, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(1231, BizCurrencyTypes.EURO));
        bzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(987, BizCurrencyTypes.AU_DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(4567, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(876, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(123, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(1233, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(1235, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setNktsnnkgns(BizCurrency.valueOf(765, BizCurrencyTypes.DOLLAR));

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0),
            "PAR2", "処理コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 2),
            "sscd001", "組織コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 3),
            "                    ", "半角スペース20桁");
        String bzKyknaiyouHanei = (String) MockObjectManager.getArgument(
            MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        exStringEquals(bzKyknaiyouHanei.substring(0, 4), "PAR2", "処理コード");
        exStringEquals(bzKyknaiyouHanei.substring(4, 5), ".", "区切符号");
        exStringEquals(bzKyknaiyouHanei.substring(5, 6), " ", "普保Ⅱ契約番号区分");
        exStringEquals(bzKyknaiyouHanei.substring(6, 17), "79807111114", "普保Ⅱ契約番号");
        exStringEquals(bzKyknaiyouHanei.substring(17, 18), "4", "レコード削除表示");
        exStringEquals(bzKyknaiyouHanei.substring(18, 20), "Kh", "（契約保全）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(20, 22), "  ", "（契約保全）契約状態");
        exStringEquals(bzKyknaiyouHanei.substring(22, 30), "20160401", "（契約保全）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(30, 31), " ", "（契約保全）有効消滅区分");
        exStringEquals(bzKyknaiyouHanei.substring(31, 33), "00", "（契約保全）消滅事由");
        exStringEquals(bzKyknaiyouHanei.substring(33, 41), "20160311", "（契約保全）消滅日");
        exStringEquals(bzKyknaiyouHanei.substring(41, 44), "JPY", "（契約保全）通算用通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(44, 55), "00000123400", "（契約保全）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(55, 66), "00000123100", "（契約保全）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(66, 77), "00000098700", "（契約保全）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(77, 79), "12", "（契約保全）払込期間");
        exStringEquals(bzKyknaiyouHanei.substring(79, 81), "  ", "（契約保全）選択方法区分");
        exStringEquals(bzKyknaiyouHanei.substring(81, 87), "201605", "（契約保全）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(87, 88), "6", "（契約保全）契約者被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(88, 90), "  ", "（契約保全）手続注意区分１");
        exStringEquals(bzKyknaiyouHanei.substring(90, 92), "  ", "（契約保全）手続注意区分２");
        exStringEquals(bzKyknaiyouHanei.substring(92, 94), "  ", "（契約保全）手続注意区分３");
        exStringEquals(bzKyknaiyouHanei.substring(94, 96), "  ", "（契約保全）手続注意区分４");
        exStringEquals(bzKyknaiyouHanei.substring(96, 98), "  ", "（契約保全）手続注意区分５");
        exStringEquals(bzKyknaiyouHanei.substring(98, 100), "11", "（契約保全）商品世代番号");
        exStringEquals(bzKyknaiyouHanei.substring(100, 101), "0", "（契約保全）介護前払特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(101, 102), "1", "（契約保全）保険料円入金特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(102, 113), "00000456700", "（契約保全）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(113, 122), "764123598", "（契約保全）新契約時申込番号");
        exStringEquals(bzKyknaiyouHanei.substring(122, 123), " ", "（契約保全）法定貯蓄性有表示");
        exStringEquals(bzKyknaiyouHanei.substring(123, 124), " ", "（契約保全）成立時取引時確認区分");
        exStringEquals(bzKyknaiyouHanei.substring(124, 125), "6", "（契約保全）払込経路");

        exStringEquals(bzKyknaiyouHanei.substring(125, 127), "Sk", "（新契約）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(127, 135), "20160311", "（新契約）申込日");
        exStringEquals(bzKyknaiyouHanei.substring(135, 143), "20160411", "（新契約）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(143, 151), "20160511", "（新契約）責任開始日");
        exStringEquals(bzKyknaiyouHanei.substring(151, 152), " ", "（新契約）成立区分");
        exStringEquals(bzKyknaiyouHanei.substring(152, 160), "20160416", "（新契約）成立処理日");
        exStringEquals(bzKyknaiyouHanei.substring(160, 161), "1", "（新契約）ＭＦ連動済フラグ");
        exStringEquals(bzKyknaiyouHanei.substring(161, 172), "10000000003", "（新契約）証券番号");
        exStringEquals(bzKyknaiyouHanei.substring(172, 175), "JPY", "（新契約）通算用通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(175, 186), "00000087600", "（新契約）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(186, 197), "00000012300", "（新契約）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(197, 208), "00000123300", "（新契約）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(208, 210), "10", "（新契約）払込期間");
        exStringEquals(bzKyknaiyouHanei.substring(210, 212), "  ", "（新契約）選択方法区分");
        exStringEquals(bzKyknaiyouHanei.substring(212, 218), "201604", "（新契約）募集年月");
        exStringEquals(bzKyknaiyouHanei.substring(218, 219), "1", "（新契約）契約者被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(219, 220), " ", "（新契約）申込消滅区分");
        exStringEquals(bzKyknaiyouHanei.substring(220, 222), "21", "（新契約）商品世代番号");
        exStringEquals(bzKyknaiyouHanei.substring(222, 223), "1", "（新契約）介護前払特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(223, 224), "0", "（新契約）保険料円入金特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(224, 235), "00000123500", "（新契約）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(235, 236), "6", "（新契約）払込経路");

        exStringEquals(bzKyknaiyouHanei.substring(236, 238), "Nk", "（年金支払）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(238, 246), "20160412", "（年金支払）年金支払開始日");
        exStringEquals(bzKyknaiyouHanei.substring(246, 254), "20160512", "（年金支払）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(254, 256), "  ", "（年金支払）年金消滅コード");
        exStringEquals(bzKyknaiyouHanei.substring(256, 264), "20160312", "（年金支払）消滅日");
        exStringEquals(bzKyknaiyouHanei.substring(264, 267), "   ", "（年金支払）支払通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(267, 269), "21", "（年金支払）定額年金年金種類");
        exStringEquals(bzKyknaiyouHanei.substring(269, 280), "00000076500", "（年金支払）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(280, 281), "1", "（年金支払）年金受取人被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(281, 283), "31", "（年金支払）商品世代番号");

        exStringEquals(bzKyknaiyouHanei.substring(283, 301), "ﾋﾎｹﾝｼｬ            ", "被保険者名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(301, 316), "被保険者名　　　　　　　　　　", "被保険者名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(316, 324), "19881206", "被保険者生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(324, 325), " ", "被保険者性別");
        exStringEquals(bzKyknaiyouHanei.substring(325, 332), "4354001", "被保険者郵便番号");
        exStringEquals(bzKyknaiyouHanei.substring(332, 394),
            "住所１２３４５６７８住所２２３４５６７８住所３２３４５６７８　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　", "被保険者住所");
        exStringEquals(bzKyknaiyouHanei.substring(394, 408), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(bzKyknaiyouHanei.substring(408, 411), "004", "被保険者職業コード");
        exStringEquals(bzKyknaiyouHanei.substring(411, 429), "ｹｲﾔｸｼｬ            ", "契約者名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(429, 444), "佐佐木　　　　　　　　　　　　", "契約者名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(444, 452), "19900406", "契約者生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(452, 470), "ﾈﾝｷﾝ              ", "年金受取人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(470, 485), "年金受取人　　　　　　　　　　", "年金受取人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(485, 493), "19881112", "年金受取人生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(493, 500), "4354112", "通信先郵便番号");
        exStringEquals(bzKyknaiyouHanei.substring(500, 562),
            "通信先住所１２３４５通信先住所２２３４５通信先住所３２３４５　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　", "通信先住所");
        exStringEquals(bzKyknaiyouHanei.substring(562, 576), "0200-0714-6642", "通信先電話番号");
        exStringEquals(bzKyknaiyouHanei.substring(576, 594), "ｼﾎﾞｳｲﾁ            ", "死亡受取人名（カナ）１");
        exStringEquals(bzKyknaiyouHanei.substring(594, 609), "死亡受取人１　　　　　　　　　", "死亡受取人名（漢字）１");
        exStringEquals(bzKyknaiyouHanei.substring(609, 627), "ｼﾎﾞｳﾆ             ", "死亡受取人名（カナ）２");
        exStringEquals(bzKyknaiyouHanei.substring(627, 642), "死亡受取人２　　　　　　　　　", "死亡受取人名（漢字）２");
        exStringEquals(bzKyknaiyouHanei.substring(642, 660), "ｼﾎﾞｳｻﾝ            ", "死亡受取人名（カナ）３");
        exStringEquals(bzKyknaiyouHanei.substring(660, 675), "死亡受取人３　　　　　　　　　", "死亡受取人名（漢字）３");
        exStringEquals(bzKyknaiyouHanei.substring(675, 693), "ｼﾎﾞｳﾖ             ", "死亡受取人名（カナ）４");
        exStringEquals(bzKyknaiyouHanei.substring(693, 708), "死亡受取人４　　　　　　　　　", "死亡受取人名（漢字）４");
        exStringEquals(bzKyknaiyouHanei.substring(708, 726), "ｼﾃｲﾀﾞｲﾘ           ", "指定代理請求人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(726, 741), "指定代理　　　　　　　　　　　", "指定代理請求人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(741, 759), "ｳｹｵｲｷﾞｮ           ", "契約者代理人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(759, 774), "契約者代理　　　　　　　　　　", "契約者代理人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(774, 792), "ｶｿﾞｸﾀﾞｲ           ", "家族登録名（カナ）１");
        exStringEquals(bzKyknaiyouHanei.substring(792, 807), "家族登録名１　　　　　　　　　", "家族登録名（漢字）１");
        exStringEquals(bzKyknaiyouHanei.substring(807, 825), "ｶｿﾞｸﾀﾞﾆ           ", "家族登録名（カナ）２");
        exStringEquals(bzKyknaiyouHanei.substring(825, 840), "家族登録名２　　　　　　　　　", "家族登録名（漢字）２");
        exStringEquals(bzKyknaiyouHanei.substring(840, 844), "1234", "銀行コード");
        exStringEquals(bzKyknaiyouHanei.substring(844, 847), "123", "支店コード");
        exStringEquals(bzKyknaiyouHanei.substring(847, 848), "1", "預金種目区分");
        exStringEquals(bzKyknaiyouHanei.substring(848, 855), "2345678", "口座番号");
        exStringEquals(bzKyknaiyouHanei.substring(855, 885), "ｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝ", "口座名義人氏名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(885, 886), "0", "口座名義契約者同一人区分");
        exStringEquals(bzKyknaiyouHanei.substring(886, 893), "DLCode1", "代理店コード１");
        exStringEquals(bzKyknaiyouHanei.substring(893, 896), "101", "分担割合１");
        exStringEquals(bzKyknaiyouHanei.substring(896, 903), "DLCode2", "代理店コード２");
        exStringEquals(bzKyknaiyouHanei.substring(903, 906), "202", "分担割合２");
        exStringEquals(bzKyknaiyouHanei.substring(906, 913), "Kanri01", "管理組織コード１");
        exStringEquals(bzKyknaiyouHanei.substring(913, 920), "Kanri02", "管理組織コード２");
        exStringEquals(bzKyknaiyouHanei.substring(920), "000000000000000060", "要求通番");

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getAcserrcd(), "5434", "ACS基盤エラーコード");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIERROR, "契約内容反映エラー区分");
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000060");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000060", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "5434", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIERROR,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testExec2_A2() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN2;

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        bzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        test1.editYokenData(bzKykNaiyouHaneiYokenBean);

        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIOK, "契約内容反映エラー区分");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUNONE,
            "被保険者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino(), "", "被保険者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI,
            "契約者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino(), "1234567890", "契約者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI,
            "年金受取人名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno(), "2234567890", "年金受取人索引名番号");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getYoukyuuno(), "000000000000000070", "要求通番");
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BT_TjtIdouNyKh tjtIdouNyKh = bzKykNaiyouHaneiKekkaBean.getTjtidounykh();

        exStringEquals(tjtIdouNyKh.getSyono(), "79807111114", "証券番号");
        exNumericEquals(tjtIdouNyKh.getRenno3keta(), 5, "連番(３桁)");
        exNumericEquals(tjtIdouNyKh.getRecordsakujyohyouji(), 4, "レコード削除表示");
        exStringEquals(tjtIdouNyKh.getYoukyuuno(), "000000000000000070", "要求通番");
        exStringEquals(tjtIdouNyKh.getSyouhncd(), "Kh", "商品コード");
        exClassificationEquals(tjtIdouNyKh.getKykjyoutai(), C_Kykjyoutai.ENTYOU, "契約状態");
        exDateEquals(tjtIdouNyKh.getKykymd(), BizDate.valueOf(20160401), "契約日");
        exClassificationEquals(tjtIdouNyKh.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tjtIdouNyKh.getSyoumetujiyuu(), C_Syoumetujiyuu.MENSEKI, "消滅事由");
        exDateEquals(tjtIdouNyKh.getSyoumetuymd(), BizDate.valueOf(20160311), "消滅日");
        exClassificationEquals(tjtIdouNyKh.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(tjtIdouNyKh.getTsnyousibous().toString(), Long.toString(1234), "通算用死亡Ｓ");
        exStringEquals(tjtIdouNyKh.getTsnyouitijip().toString(), Long.toString(1231), "通算用一時払Ｐ");
        exStringEquals(tjtIdouNyKh.getTsnyounkgns().toString(), Long.toString(987), "通算用年金原資");
        exNumericEquals(tjtIdouNyKh.getHrkkkn(), 12, "払込期間");
        exClassificationEquals(tjtIdouNyKh.getSntkhoukbn(), C_SntkhouKbn.NONE, "選択方法区分");
        exDateYMEquals(tjtIdouNyKh.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exNumericEquals(tjtIdouNyKh.getKykhhkndouhyouji(), 6, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn1(), C_TtdktyuuiKbn.HOZENSONOTA, "手続注意区分１");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn2(), C_TtdktyuuiKbn.SYOUMETUJISEISAN, "手続注意区分２");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn3(), C_TtdktyuuiKbn.IKUEISIKINANNAITYUUI, "手続注意区分３");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn4(), C_TtdktyuuiKbn.KAIGAITOKOU, "手続注意区分４");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn5(), C_TtdktyuuiKbn.ADRHUMEI, "手続注意区分５");
        exNumericEquals(tjtIdouNyKh.getSyouhnsdno(), 11, "商品世代番号");
        exClassificationEquals(tjtIdouNyKh.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNyKh.getPyennykntkykumukbn(), C_UmuKbn.ARI, "保険料円入金特約有無区分");
        exStringEquals(tjtIdouNyKh.getTsnyennyknkgk().toString(), Long.toString(4567), "通算用円入金額");
        exStringEquals(tjtIdouNyKh.getSkjmosno(), "764123598", "新契約時申込番号");

        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();

        exStringEquals(idouKhMeigi.getSyono(), "79807111114", "証券番号");
        exNumericEquals(idouKhMeigi.getRenno3keta(), 5, "連番(３桁)");
        exStringEquals(idouKhMeigi.getHhknnmkn(), "ﾋﾎｹﾝｼｬ", "被保険者名（カナ）");
        exStringEquals(idouKhMeigi.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exDateEquals(idouKhMeigi.getHhknseiymd(), BizDate.valueOf(19881206), "被保険者生年月日");
        exClassificationEquals(idouKhMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouKhMeigi.getHhknyno(), "4354001", "被保険者郵便番号");
        exStringEquals(idouKhMeigi.getHhknadr1kj(),
            "住所１２３４５６７８", "被保険者住所１（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr2kj(),
            "住所２２３４５６７８", "被保険者住所２（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr3kj(),
            "住所３２３４５６７８", "被保険者住所３（漢字）");
        exStringEquals(idouKhMeigi.getHhkntelno(), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(idouKhMeigi.getHhknsykgycd(), "004", "被保険者職業コード");
        exStringEquals(idouKhMeigi.getKyknmkn(), "ｹｲﾔｸｼｬ", "契約者名（カナ）");
        exStringEquals(idouKhMeigi.getKyknmkj(), "佐佐木", "契約者名（漢字）");
        exDateEquals(idouKhMeigi.getKykseiymd(), BizDate.valueOf(19900406), "契約者生年月日");
        exStringEquals(idouKhMeigi.getNenkinuktnmkana(), "ﾈﾝｷﾝ", "年金受取人名（カナ）");
        exStringEquals(idouKhMeigi.getNenkinuktnmkanji(), "年金受取人", "年金受取人名（漢字）");
        exDateEquals(idouKhMeigi.getNenkinuktseiymd(), BizDate.valueOf(19881112), "年金受取人生年月日");
        exStringEquals(idouKhMeigi.getTsinyno(), "4354112", "通信先郵便番号");
        exStringEquals(idouKhMeigi.getTsinadr1kj(),
            "通信先住所１２３４５", "通信先住所１（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr2kj(),
            "通信先住所２２３４５", "通信先住所２（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr3kj(),
            "通信先住所３２３４５", "通信先住所３（漢字）");
        exStringEquals(idouKhMeigi.getTsintelno(), "0200-0714-6642", "通信先電話番号");
        exStringEquals(idouKhMeigi.getSbuktnmkn1(), "ｼﾎﾞｳｲﾁ", "死亡受取人名（カナ）１");
        exStringEquals(idouKhMeigi.getSbuktnmkj1(), "死亡受取人１", "死亡受取人名（漢字）１");
        exStringEquals(idouKhMeigi.getSbuktnmkn2(), "ｼﾎﾞｳﾆ", "死亡受取人名（カナ）２");
        exStringEquals(idouKhMeigi.getSbuktnmkj2(), "死亡受取人２", "死亡受取人名（漢字）２");
        exStringEquals(idouKhMeigi.getSbuktnmkn3(), "ｼﾎﾞｳｻﾝ", "死亡受取人名（カナ）３");
        exStringEquals(idouKhMeigi.getSbuktnmkj3(), "死亡受取人３", "死亡受取人名（漢字）３");
        exStringEquals(idouKhMeigi.getSbuktnmkn4(), "ｼﾎﾞｳﾖ", "死亡受取人名（カナ）４");
        exStringEquals(idouKhMeigi.getSbuktnmkj4(), "死亡受取人４", "死亡受取人名（漢字）４");
        exStringEquals(idouKhMeigi.getStdrsknmkn(), "ｼﾃｲﾀﾞｲﾘ", "指定代理請求人名（カナ）");
        exStringEquals(idouKhMeigi.getStdrsknmkj(), "指定代理", "指定代理請求人名（漢字）");
        exStringEquals(idouKhMeigi.getKykdairinmkn(), "ｳｹｵｲｷﾞｮ", "契約者代理人名（カナ）");
        exStringEquals(idouKhMeigi.getKykdairinmkj(), "契約者代理", "契約者代理人名（漢字）");
        exStringEquals(idouKhMeigi.getKzktourokunmkn1(), "ｶｿﾞｸﾀﾞｲ", "家族登録名（カナ）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkj1(), "家族登録名１", "家族登録名（漢字）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkn2(), "ｶｿﾞｸﾀﾞﾆ", "家族登録名（カナ）２");
        exStringEquals(idouKhMeigi.getKzktourokunmkj2(), "家族登録名２", "家族登録名（漢字）２");

        BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.getIdouKhBosyuudr();

        exStringEquals(idouKhBosyuudr.getSyono(), "79807111114", "証券番号");
        exNumericEquals(idouKhBosyuudr.getRenno3keta(), 5, "連番(３桁)");
        exStringEquals(idouKhBosyuudr.getDairitencd1(), "DLCode1", "代理店コード１");
        exStringEquals(idouKhBosyuudr.getBunwari1().toString(), "101", "分担割合１");
        exStringEquals(idouKhBosyuudr.getDairitencd2(), "DLCode2", "代理店コード2");
        exStringEquals(idouKhBosyuudr.getBunwari2().toString(), "202", "分担割合２");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd1(), "Kanri01", "管理組織コード１");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd2(), "Kanri02", "管理組織コード２");


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000070");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000070", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "0000", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIOK,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testExec2_A3() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN3;

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        bzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        test1.editYokenData(bzKykNaiyouHaneiYokenBean);

        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);

        bzKykNaiyouHaneiYokenBean.setHuho2kykno("791112238");
        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIOK, "契約内容反映エラー区分");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUNONE,
            "被保険者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino(), "", "被保険者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI,
            "契約者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino(), "1234567890", "契約者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI,
            "年金受取人名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno(), "2234567890", "年金受取人索引名番号");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getYoukyuuno(), "000000000000000080", "要求通番");
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BT_TjtIdouNySk tjtIdouNySk = bzKykNaiyouHaneiKekkaBean.getTjtidounysk();

        exStringEquals(tjtIdouNySk.getMosno(), "791112238", "申込番号");
        exNumericEquals(tjtIdouNySk.getRenno3keta(), 3, "連番(３桁)");
        exNumericEquals(tjtIdouNySk.getRecordsakujyohyouji(), 4, "レコード削除表示");
        exStringEquals(tjtIdouNySk.getYoukyuuno(), "000000000000000080", "要求通番");
        exStringEquals(tjtIdouNySk.getSyouhncd(), "Sk", "商品コード");
        exDateEquals(tjtIdouNySk.getMosymd(), BizDate.valueOf(20160311), "申込日");
        exDateEquals(tjtIdouNySk.getKykymd(), BizDate.valueOf(20160411), "契約日");
        exDateEquals(tjtIdouNySk.getSknnkaisiymd(), BizDate.valueOf(20160511), "責任開始日");
        exClassificationEquals(tjtIdouNySk.getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exDateEquals(tjtIdouNySk.getSrsyoriymd(), BizDate.valueOf(20160416), "成立処理日");
        exClassificationEquals(tjtIdouNySk.getMfrenflg(), C_Mfrenflg.SUMI, "ＭＦ連動済フラグ");
        exStringEquals(tjtIdouNySk.getSyono(), "10000000003", "証券番号");
        exClassificationEquals(tjtIdouNySk.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(tjtIdouNySk.getTsnyousibous().toString(), Long.toString(876), "通算用死亡Ｓ");
        exStringEquals(tjtIdouNySk.getTsnyouitijip().toString(), Long.toString(123), "通算用一時払Ｐ");
        exStringEquals(tjtIdouNySk.getTsnyounkgns().toString(), Long.toString(1233), "通算用年金原資");
        exNumericEquals(tjtIdouNySk.getHrkkkn(), 10, "払込期間");
        exClassificationEquals(tjtIdouNySk.getSntkhoukbn(), C_SntkhouKbn.HJY, "選択方法区分");
        exDateYMEquals(tjtIdouNySk.getBosyuuym(), BizDateYM.valueOf(201604), "募集年月");
        exNumericEquals(tjtIdouNySk.getKykhhkndouhyouji(), 1, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNySk.getMossyoumetukbn(), C_MossyoumetuKbn.ENKI, "申込消滅区分");
        exNumericEquals(tjtIdouNySk.getSyouhnsdno(), 21, "商品世代番号");
        exClassificationEquals(tjtIdouNySk.getKaigomaehrtkykumukbn(), C_UmuKbn.ARI, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNySk.getPyennykntkykumukbn(), C_UmuKbn.NONE, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyennyknkgk(), BizCurrency.valueOf(1235), "通算用円入金額");
        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();

        exStringEquals(idouSkMeigi.getMosno(), "791112238", "申込番号");
        exNumericEquals(idouSkMeigi.getRenno3keta(), 3, "連番(３桁)");
        exStringEquals(idouSkMeigi.getHhknnmkn(), "ﾋﾎｹﾝｼｬ", "被保険者名（カナ）");
        exStringEquals(idouSkMeigi.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exDateEquals(idouSkMeigi.getHhknseiymd(), BizDate.valueOf(19881206), "被保険者生年月日");
        exClassificationEquals(idouSkMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouSkMeigi.getHhknyno(), "4354001", "被保険者郵便番号");
        exStringEquals(idouSkMeigi.getHhknadr1kj(),
            "住所１２３４５６７８", "被保険者住所１（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr2kj(),
            "住所２２３４５６７８", "被保険者住所２（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr3kj(),
            "住所３２３４５６７８", "被保険者住所３（漢字）");
        exStringEquals(idouSkMeigi.getHhkntelno(), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(idouSkMeigi.getHhknsykgycd(), "004", "被保険者職業コード");
        exStringEquals(idouSkMeigi.getKyknmkn(), "ｹｲﾔｸｼｬ", "契約者名（カナ）");
        exStringEquals(idouSkMeigi.getKyknmkj(), "佐佐木", "契約者名（漢字）");
        exDateEquals(idouSkMeigi.getKykseiymd(), BizDate.valueOf(19900406), "契約者生年月日");
        exStringEquals(idouSkMeigi.getNenkinuktnmkana(), "ﾈﾝｷﾝ", "年金受取人名（カナ）");
        exStringEquals(idouSkMeigi.getNenkinuktnmkanji(), "年金受取人", "年金受取人名（漢字）");
        exDateEquals(idouSkMeigi.getNenkinuktseiymd(), BizDate.valueOf(19881112), "年金受取人生年月日");
        exStringEquals(idouSkMeigi.getTsinyno(), "4354112", "通信先郵便番号");
        exStringEquals(idouSkMeigi.getTsinadr1kj(),
            "通信先住所１２３４５", "通信先住所１（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr2kj(),
            "通信先住所２２３４５", "通信先住所２（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr3kj(),
            "通信先住所３２３４５", "通信先住所３（漢字）");
        exStringEquals(idouSkMeigi.getTsintelno(), "0200-0714-6642", "通信先電話番号");
        exStringEquals(idouSkMeigi.getSbuktnmkn1(), "ｼﾎﾞｳｲﾁ", "死亡受取人名（カナ）１");
        exStringEquals(idouSkMeigi.getSbuktnmkj1(), "死亡受取人１", "死亡受取人名（漢字）１");
        exStringEquals(idouSkMeigi.getSbuktnmkn2(), "ｼﾎﾞｳﾆ", "死亡受取人名（カナ）２");
        exStringEquals(idouSkMeigi.getSbuktnmkj2(), "死亡受取人２", "死亡受取人名（漢字）２");
        exStringEquals(idouSkMeigi.getSbuktnmkn3(), "ｼﾎﾞｳｻﾝ", "死亡受取人名（カナ）３");
        exStringEquals(idouSkMeigi.getSbuktnmkj3(), "死亡受取人３", "死亡受取人名（漢字）３");
        exStringEquals(idouSkMeigi.getSbuktnmkn4(), "ｼﾎﾞｳﾖ", "死亡受取人名（カナ）４");
        exStringEquals(idouSkMeigi.getSbuktnmkj4(), "死亡受取人４", "死亡受取人名（漢字）４");
        exStringEquals(idouSkMeigi.getStdrsknmkn(), "ｼﾃｲﾀﾞｲﾘ", "指定代理請求人名（カナ）");
        exStringEquals(idouSkMeigi.getStdrsknmkj(), "指定代理", "指定代理請求人名（漢字）");
        exStringEquals(idouSkMeigi.getKykdairinmkn(), "ｳｹｵｲｷﾞｮ", "契約者代理人名（カナ）");
        exStringEquals(idouSkMeigi.getKykdairinmkj(), "契約者代理", "契約者代理人名（漢字）");
        exStringEquals(idouSkMeigi.getKzktourokunmkn1(), "ｶｿﾞｸﾀﾞｲ", "家族登録名（カナ）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkj1(), "家族登録名１", "家族登録名（漢字）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkn2(), "ｶｿﾞｸﾀﾞﾆ", "家族登録名（カナ）２");
        exStringEquals(idouSkMeigi.getKzktourokunmkj2(), "家族登録名２", "家族登録名（漢字）２");

        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();

        exStringEquals(idouSkBosyuudr.getMosno(), "791112238", "申込番号");
        exNumericEquals(idouSkBosyuudr.getRenno3keta(), 3, "連番(３桁)");
        exStringEquals(idouSkBosyuudr.getDairitencd1(), "DLCode1", "代理店コード１");
        exStringEquals(idouSkBosyuudr.getBunwari1().toString(), "101", "分担割合１");
        exStringEquals(idouSkBosyuudr.getDairitencd2(), "DLCode2", "代理店コード2");
        exStringEquals(idouSkBosyuudr.getBunwari2().toString(), "202", "分担割合２");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd1(), "Kanri01", "管理組織コード１");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd2(), "Kanri02", "管理組織コード２");

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000080");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000080", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "791112238", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "0000", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIOK,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(40)
    public void testExec2_A4() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN4;

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        bzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.NKSYSYNO);
        test1.editYokenData(bzKykNaiyouHaneiYokenBean);

        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIOK, "契約内容反映エラー区分");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUNONE,
            "被保険者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino(), "", "被保険者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI,
            "契約者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino(), "1234567890", "契約者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI,
            "年金受取人名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno(), "2234567890", "年金受取人索引名番号");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getYoukyuuno(), "000000000000000090", "要求通番");
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());

        BT_TjtIdouNyNk tjtIdouNyNk = bzKykNaiyouHaneiKekkaBean.getTjtidounynk();

        exStringEquals(tjtIdouNyNk.getNksysyno(), "79807111114", "年金証書番号");
        exNumericEquals(tjtIdouNyNk.getRenno3keta(), 4, "連番(３桁)");
        exNumericEquals(tjtIdouNyNk.getRecordsakujyohyouji(), 4, "レコード削除表示");
        exStringEquals(tjtIdouNyNk.getYoukyuuno(), "000000000000000090", "要求通番");
        exStringEquals(tjtIdouNyNk.getSyouhncd(), "Nk", "商品コード");
        exDateEquals(tjtIdouNyNk.getNkshrstartymd(), BizDate.valueOf(20160412), "年金支払開始日");
        exDateEquals(tjtIdouNyNk.getKykymd(), BizDate.valueOf(20160512), "契約日");
        exClassificationEquals(tjtIdouNyNk.getNksyoumetucd(), C_NkSyoumetuCd.NKTORIKESI, "年金消滅コード");
        exDateEquals(tjtIdouNyNk.getSyoumetuymd(), BizDate.valueOf(20160312), "消滅日");
        exClassificationEquals(tjtIdouNyNk.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(tjtIdouNyNk.getTeinksyu(), "21", "定額年金年金種類");
        exStringEquals(tjtIdouNyNk.getTsnyounkgns().toString(), Long.toString(765), "通算用年金原資");
        exNumericEquals(tjtIdouNyNk.getNkukthhkndouhyouji(), 1, "年金受取人被保険者同一表示");
        exNumericEquals(tjtIdouNyNk.getSyouhnsdno(), 31, "商品世代番号");

        BT_IdouNkMeigi idouNkMeigi = tjtIdouNyNk.getIdouNkMeigi();

        exStringEquals(idouNkMeigi.getNksysyno(), "79807111114", "年金証書番号");
        exNumericEquals(idouNkMeigi.getRenno3keta(), 4, "連番(３桁)");
        exStringEquals(idouNkMeigi.getHhknnmkn(), "ﾋﾎｹﾝｼｬ", "被保険者名（カナ）");
        exStringEquals(idouNkMeigi.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exDateEquals(idouNkMeigi.getHhknseiymd(), BizDate.valueOf(19881206), "被保険者生年月日");
        exClassificationEquals(idouNkMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouNkMeigi.getHhknyno(), "4354001", "被保険者郵便番号");
        exStringEquals(idouNkMeigi.getHhknadr1kj(),
            "住所１２３４５６７８", "被保険者住所１（漢字）");
        exStringEquals(idouNkMeigi.getHhknadr2kj(),
            "住所２２３４５６７８", "被保険者住所２（漢字）");
        exStringEquals(idouNkMeigi.getHhknadr3kj(),
            "住所３２３４５６７８", "被保険者住所３（漢字）");
        exStringEquals(idouNkMeigi.getHhkntelno(), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(idouNkMeigi.getHhknsykgycd(), "004", "被保険者職業コード");
        exStringEquals(idouNkMeigi.getNenkinuktnmkana(), "ﾈﾝｷﾝ", "年金受取人名（カナ）");
        exStringEquals(idouNkMeigi.getNenkinuktnmkanji(), "年金受取人", "年金受取人名（漢字）");
        exDateEquals(idouNkMeigi.getNenkinuktseiymd(), BizDate.valueOf(19881112), "年金受取人生年月日");
        exStringEquals(idouNkMeigi.getTsinyno(), "4354112", "通信先郵便番号");
        exStringEquals(idouNkMeigi.getTsinadr1kj(),
            "通信先住所１２３４５", "通信先住所１（漢字）");
        exStringEquals(idouNkMeigi.getTsinadr2kj(),
            "通信先住所２２３４５", "通信先住所２（漢字）");
        exStringEquals(idouNkMeigi.getTsinadr3kj(),
            "通信先住所３２３４５", "通信先住所３（漢字）");
        exStringEquals(idouNkMeigi.getTsintelno(), "0200-0714-6642", "通信先電話番号");

        BT_IdouNkBosyuudr idouNkBosyuudr = tjtIdouNyNk.getIdouNkBosyuudr();

        exStringEquals(idouNkBosyuudr.getNksysyno(), "79807111114", "年金証書番号");
        exNumericEquals(idouNkBosyuudr.getRenno3keta(), 4, "連番(３桁)");
        exStringEquals(idouNkBosyuudr.getDairitencd1(), "DLCode1", "代理店コード１");
        exStringEquals(idouNkBosyuudr.getBunwari1().toString(), "101", "分担割合１");
        exStringEquals(idouNkBosyuudr.getDairitencd2(), "DLCode2", "代理店コード2");
        exStringEquals(idouNkBosyuudr.getBunwari2().toString(), "202", "分担割合２");
        exStringEquals(idouNkBosyuudr.getKanrisosikicd1(), "Kanri01", "管理組織コード１");
        exStringEquals(idouNkBosyuudr.getKanrisosikicd2(), "Kanri02", "管理組織コード２");

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000090");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000090", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.NKSYSYNO, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "0000", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIOK,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(50)
    public void testExec2_A5() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN5;

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        bzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.NKSYSYNO);
        test1.editYokenData(bzKykNaiyouHaneiYokenBean);

        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU, "契約内容反映エラー区分");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUNONE,
            "被保険者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino(), "", "被保険者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI,
            "契約者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino(), "1234567890", "契約者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI,
            "年金受取人名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno(), "2234567890", "年金受取人索引名番号");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getYoukyuuno(), "000000000000000100", "要求通番");
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000100");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000100", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.NKSYSYNO, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "0000", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(60)
    public void testExec2_A6() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN6;

        MockObjectManager.initialize();

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        test1.editYokenData(bzKykNaiyouHaneiYokenBean);
        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);
        test1.editYokenKbnToNull(bzKykNaiyouHaneiYokenBean);

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0),
            "PAR2", "処理コード");
        String bzKyknaiyouHanei = (String) MockObjectManager.getArgument(
            MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        exStringEquals(bzKyknaiyouHanei.substring(0, 4), "PAR2", "処理コード");
        exStringEquals(bzKyknaiyouHanei.substring(4, 5), ".", "区切符号");
        exStringEquals(bzKyknaiyouHanei.substring(5, 6), " ", "普保Ⅱ契約番号区分");
        exStringEquals(bzKyknaiyouHanei.substring(6, 17), "79807111114", "普保Ⅱ契約番号");
        exStringEquals(bzKyknaiyouHanei.substring(17, 18), " ", "レコード削除表示");
        exStringEquals(bzKyknaiyouHanei.substring(18, 20), "Kh", "（契約保全）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(20, 22), "  ", "（契約保全）契約状態");
        exStringEquals(bzKyknaiyouHanei.substring(22, 30), "20160401", "（契約保全）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(30, 31), " ", "（契約保全）有効消滅区分");
        exStringEquals(bzKyknaiyouHanei.substring(31, 33), "  ", "（契約保全）消滅事由");
        exStringEquals(bzKyknaiyouHanei.substring(33, 41), "20160311", "（契約保全）消滅日");
        exStringEquals(bzKyknaiyouHanei.substring(41, 44), "   ", "（契約保全）通算用通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(44, 55), "00000000000", "（契約保全）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(55, 66), "00000000000", "（契約保全）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(66, 77), "00000000000", "（契約保全）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(77, 79), "00", "（契約保全）払込期間");
        exStringEquals(bzKyknaiyouHanei.substring(79, 81), "  ", "（契約保全）選択方法区分");
        exStringEquals(bzKyknaiyouHanei.substring(81, 87), "201605", "（契約保全）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(87, 88), " ", "（契約保全）契約者被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(88, 90), "  ", "（契約保全）手続注意区分１");
        exStringEquals(bzKyknaiyouHanei.substring(90, 92), "  ", "（契約保全）手続注意区分２");
        exStringEquals(bzKyknaiyouHanei.substring(92, 94), "  ", "（契約保全）手続注意区分３");
        exStringEquals(bzKyknaiyouHanei.substring(94, 96), "  ", "（契約保全）手続注意区分４");
        exStringEquals(bzKyknaiyouHanei.substring(96, 98), "  ", "（契約保全）手続注意区分５");
        exStringEquals(bzKyknaiyouHanei.substring(98, 100), "00", "（契約保全）商品世代番号");
        exStringEquals(bzKyknaiyouHanei.substring(100, 101), " ", "（契約保全）介護前払特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(101, 102), " ", "（契約保全）保険料円入金特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(102, 113), "00000000000", "（契約保全）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(113, 122), "764123598", "（契約保全）新契約時申込番号");
        exStringEquals(bzKyknaiyouHanei.substring(122, 123), " ", "（契約保全）法定貯蓄性有表示");
        exStringEquals(bzKyknaiyouHanei.substring(123, 124), " ", "（契約保全）成立時取引時確認区分");
        exStringEquals(bzKyknaiyouHanei.substring(124, 125), " ", "（契約保全）払込経路");

        exStringEquals(bzKyknaiyouHanei.substring(125, 127), "Sk", "（新契約）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(127, 135), "20160311", "（新契約）申込日");
        exStringEquals(bzKyknaiyouHanei.substring(135, 143), "20160411", "（新契約）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(143, 151), "20160511", "（新契約）責任開始日");
        exStringEquals(bzKyknaiyouHanei.substring(151, 152), " ", "（新契約）成立区分");
        exStringEquals(bzKyknaiyouHanei.substring(152, 160), "20160416", "（新契約）成立処理日");
        exStringEquals(bzKyknaiyouHanei.substring(160, 161), " ", "（新契約）ＭＦ連動済フラグ");
        exStringEquals(bzKyknaiyouHanei.substring(161, 172), "10000000003", "（新契約）証券番号");
        exStringEquals(bzKyknaiyouHanei.substring(172, 175), "   ", "（新契約）通算用通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(175, 186), "00000000000", "（新契約）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(186, 197), "00000000000", "（新契約）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(197, 208), "00000000000", "（新契約）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(208, 210), "00", "（新契約）払込期間");
        exStringEquals(bzKyknaiyouHanei.substring(210, 212), "  ", "（新契約）選択方法区分");
        exStringEquals(bzKyknaiyouHanei.substring(212, 218), "201604", "（新契約）募集年月");
        exStringEquals(bzKyknaiyouHanei.substring(218, 219), " ", "（新契約）契約者被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(219, 220), " ", "（新契約）申込消滅区分");
        exStringEquals(bzKyknaiyouHanei.substring(220, 222), "00", "（新契約）商品世代番号");
        exStringEquals(bzKyknaiyouHanei.substring(222, 223), " ", "（新契約）介護前払特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(223, 224), " ", "（新契約）保険料円入金特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(224, 235), "00000000000", "（新契約）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(235, 236), " ", "（新契約）払込経路");

        exStringEquals(bzKyknaiyouHanei.substring(236, 238), "Nk", "（年金支払）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(238, 246), "20160412", "（年金支払）年金支払開始日");
        exStringEquals(bzKyknaiyouHanei.substring(246, 254), "20160512", "（年金支払）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(254, 256), "  ", "（年金支払）年金消滅コード");
        exStringEquals(bzKyknaiyouHanei.substring(256, 264), "20160312", "（年金支払）消滅日");
        exStringEquals(bzKyknaiyouHanei.substring(264, 267), "   ", "（年金支払）支払通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(267, 269), "21", "（年金支払）定額年金年金種類");
        exStringEquals(bzKyknaiyouHanei.substring(269, 280), "00000000000", "（年金支払）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(280, 281), " ", "（年金支払）年金受取人被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(281, 283), "00", "（年金支払）商品世代番号");

        exStringEquals(bzKyknaiyouHanei.substring(283, 301), "ﾋﾎｹﾝｼｬ            ", "被保険者名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(301, 316), "被保険者名　　　　　　　　　　", "被保険者名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(316, 324), "19881206", "被保険者生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(324, 325), " ", "被保険者性別");
        exStringEquals(bzKyknaiyouHanei.substring(325, 332), "4354001", "被保険者郵便番号");
        exStringEquals(bzKyknaiyouHanei.substring(332, 394),
            "住所１２３４５６７８住所２２３４５６７８住所３２３４５６７８　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　", "被保険者住所");
        exStringEquals(bzKyknaiyouHanei.substring(394, 408), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(bzKyknaiyouHanei.substring(408, 411), "004", "被保険者職業コード");
        exStringEquals(bzKyknaiyouHanei.substring(411, 429), "ｹｲﾔｸｼｬ            ", "契約者名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(429, 444), "佐佐木　　　　　　　　　　　　", "契約者名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(444, 452), "19900406", "契約者生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(452, 470), "ﾈﾝｷﾝ              ", "年金受取人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(470, 485), "年金受取人　　　　　　　　　　", "年金受取人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(485, 493), "19881112", "年金受取人生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(493, 500), "4354112", "通信先郵便番号");
        exStringEquals(bzKyknaiyouHanei.substring(500, 562),
            "通信先住所１２３４５通信先住所２２３４５通信先住所３２３４５　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　", "通信先住所");
        exStringEquals(bzKyknaiyouHanei.substring(562, 576), "0200-0714-6642", "通信先電話番号");
        exStringEquals(bzKyknaiyouHanei.substring(576, 594), "ｼﾎﾞｳｲﾁ            ", "死亡受取人名（カナ）１");
        exStringEquals(bzKyknaiyouHanei.substring(594, 609), "死亡受取人１　　　　　　　　　", "死亡受取人名（漢字）１");
        exStringEquals(bzKyknaiyouHanei.substring(609, 627), "ｼﾎﾞｳﾆ             ", "死亡受取人名（カナ）２");
        exStringEquals(bzKyknaiyouHanei.substring(627, 642), "死亡受取人２　　　　　　　　　", "死亡受取人名（漢字）２");
        exStringEquals(bzKyknaiyouHanei.substring(642, 660), "ｼﾎﾞｳｻﾝ            ", "死亡受取人名（カナ）３");
        exStringEquals(bzKyknaiyouHanei.substring(660, 675), "死亡受取人３　　　　　　　　　", "死亡受取人名（漢字）３");
        exStringEquals(bzKyknaiyouHanei.substring(675, 693), "ｼﾎﾞｳﾖ             ", "死亡受取人名（カナ）４");
        exStringEquals(bzKyknaiyouHanei.substring(693, 708), "死亡受取人４　　　　　　　　　", "死亡受取人名（漢字）４");
        exStringEquals(bzKyknaiyouHanei.substring(708, 726), "ｼﾃｲﾀﾞｲﾘ           ", "指定代理請求人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(726, 741), "指定代理　　　　　　　　　　　", "指定代理請求人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(741, 759), "ｳｹｵｲｷﾞｮ           ", "契約者代理人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(759, 774), "契約者代理　　　　　　　　　　", "契約者代理人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(774, 792), "ｶｿﾞｸﾀﾞｲ           ", "家族登録名（カナ）１");
        exStringEquals(bzKyknaiyouHanei.substring(792, 807), "家族登録名１　　　　　　　　　", "家族登録名（漢字）１");
        exStringEquals(bzKyknaiyouHanei.substring(807, 825), "ｶｿﾞｸﾀﾞﾆ           ", "家族登録名（カナ）２");
        exStringEquals(bzKyknaiyouHanei.substring(825, 840), "家族登録名２　　　　　　　　　", "家族登録名（漢字）２");
        exStringEquals(bzKyknaiyouHanei.substring(840, 844), "1234", "銀行コード");
        exStringEquals(bzKyknaiyouHanei.substring(844, 847), "123", "支店コード");
        exStringEquals(bzKyknaiyouHanei.substring(847, 848), " ", "預金種目区分");
        exStringEquals(bzKyknaiyouHanei.substring(848, 855), "2345678", "口座番号");
        exStringEquals(bzKyknaiyouHanei.substring(855, 885), "ｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝ", "口座名義人氏名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(885, 886), "0", "口座名義契約者同一人区分");
        exStringEquals(bzKyknaiyouHanei.substring(886, 893), "DLCode1", "代理店コード１");
        exStringEquals(bzKyknaiyouHanei.substring(893, 896), "000", "分担割合１");
        exStringEquals(bzKyknaiyouHanei.substring(896, 903), "DLCode2", "代理店コード２");
        exStringEquals(bzKyknaiyouHanei.substring(903, 906), "000", "分担割合２");
        exStringEquals(bzKyknaiyouHanei.substring(906, 913), "Kanri01", "管理組織コード１");
        exStringEquals(bzKyknaiyouHanei.substring(913, 920), "Kanri02", "管理組織コード２");
        exStringEquals(bzKyknaiyouHanei.substring(920), "000000000000000110", "要求通番");

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getAcserrcd(), "5434", "ACS基盤エラーコード");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIERROR, "契約内容反映エラー区分");
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容契約保全テーブルエンティティ", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブルエンティティ", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブルエンティティ", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000110");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000110", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "5434", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIERROR,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(70)
    public void testExec2_A7() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN7;

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        bzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        test1.editYokenData(bzKykNaiyouHaneiYokenBean);

        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIOK, "契約内容反映エラー区分");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn(), C_NayoseJissiKekkaKbn.BLNK,
            "被保険者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino(), "", "被保険者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn(), C_NayoseJissiKekkaKbn.BLNK,
            "契約者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino(), "1234567890", "契約者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn(), C_NayoseJissiKekkaKbn.BLNK,
            "年金受取人名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno(), "2234567890", "年金受取人索引名番号");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getYoukyuuno(), "000000000000000120", "要求通番");
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BT_TjtIdouNyKh tjtIdouNyKh = bzKykNaiyouHaneiKekkaBean.getTjtidounykh();

        exStringEquals(tjtIdouNyKh.getSyono(), "79807111114", "証券番号");
        exNumericEquals(tjtIdouNyKh.getRenno3keta(), 5, "連番(３桁)");
        exNumericEquals(tjtIdouNyKh.getRecordsakujyohyouji(), 4, "レコード削除表示");
        exStringEquals(tjtIdouNyKh.getYoukyuuno(), "000000000000000120", "要求通番");
        exStringEquals(tjtIdouNyKh.getSyouhncd(), "Kh", "商品コード");
        exClassificationEquals(tjtIdouNyKh.getKykjyoutai(), C_Kykjyoutai.ENTYOU, "契約状態");
        exDateEquals(tjtIdouNyKh.getKykymd(), BizDate.valueOf(20160401), "契約日");
        exClassificationEquals(tjtIdouNyKh.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tjtIdouNyKh.getSyoumetujiyuu(), C_Syoumetujiyuu.MENSEKI, "消滅事由");
        exDateEquals(tjtIdouNyKh.getSyoumetuymd(), BizDate.valueOf(20160311), "消滅日");
        exClassificationEquals(tjtIdouNyKh.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(tjtIdouNyKh.getTsnyousibous().toString(), Long.toString(1234), "通算用死亡Ｓ");
        exStringEquals(tjtIdouNyKh.getTsnyouitijip().toString(), Long.toString(1231), "通算用一時払Ｐ");
        exStringEquals(tjtIdouNyKh.getTsnyounkgns().toString(), Long.toString(987), "通算用年金原資");
        exNumericEquals(tjtIdouNyKh.getHrkkkn(), 12, "払込期間");
        exClassificationEquals(tjtIdouNyKh.getSntkhoukbn(), C_SntkhouKbn.NONE, "選択方法区分");
        exDateYMEquals(tjtIdouNyKh.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exNumericEquals(tjtIdouNyKh.getKykhhkndouhyouji(), 6, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn1(), C_TtdktyuuiKbn.HOZENSONOTA, "手続注意区分１");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn2(), C_TtdktyuuiKbn.SYOUMETUJISEISAN, "手続注意区分２");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn3(), C_TtdktyuuiKbn.IKUEISIKINANNAITYUUI, "手続注意区分３");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn4(), C_TtdktyuuiKbn.KAIGAITOKOU, "手続注意区分４");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn5(), C_TtdktyuuiKbn.ADRHUMEI, "手続注意区分５");
        exNumericEquals(tjtIdouNyKh.getSyouhnsdno(), 11, "商品世代番号");
        exClassificationEquals(tjtIdouNyKh.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNyKh.getPyennykntkykumukbn(), C_UmuKbn.ARI, "保険料円入金特約有無区分");
        exStringEquals(tjtIdouNyKh.getTsnyennyknkgk().toString(), Long.toString(4567), "通算用円入金額");
        exStringEquals(tjtIdouNyKh.getSkjmosno(), "764123598", "新契約時申込番号");

        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();

        exStringEquals(idouKhMeigi.getSyono(), "79807111114", "証券番号");
        exNumericEquals(idouKhMeigi.getRenno3keta(), 5, "連番(３桁)");
        exStringEquals(idouKhMeigi.getHhknnmkn(), "ﾋﾎｹﾝｼｬ", "被保険者名（カナ）");
        exStringEquals(idouKhMeigi.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exDateEquals(idouKhMeigi.getHhknseiymd(), BizDate.valueOf(19881206), "被保険者生年月日");
        exClassificationEquals(idouKhMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouKhMeigi.getHhknyno(), "4354001", "被保険者郵便番号");
        exStringEquals(idouKhMeigi.getHhknadr1kj(),
            "住所１２３４５６７８", "被保険者住所１（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr2kj(),
            "住所２２３４５６７８", "被保険者住所２（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr3kj(),
            "住所３２３４５６７８", "被保険者住所３（漢字）");
        exStringEquals(idouKhMeigi.getHhkntelno(), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(idouKhMeigi.getHhknsykgycd(), "004", "被保険者職業コード");
        exStringEquals(idouKhMeigi.getKyknmkn(), "ｹｲﾔｸｼｬ", "契約者名（カナ）");
        exStringEquals(idouKhMeigi.getKyknmkj(), "佐佐木", "契約者名（漢字）");
        exDateEquals(idouKhMeigi.getKykseiymd(), BizDate.valueOf(19900406), "契約者生年月日");
        exStringEquals(idouKhMeigi.getNenkinuktnmkana(), "ﾈﾝｷﾝ", "年金受取人名（カナ）");
        exStringEquals(idouKhMeigi.getNenkinuktnmkanji(), "年金受取人", "年金受取人名（漢字）");
        exDateEquals(idouKhMeigi.getNenkinuktseiymd(), BizDate.valueOf(19881112), "年金受取人生年月日");
        exStringEquals(idouKhMeigi.getTsinyno(), "4354112", "通信先郵便番号");
        exStringEquals(idouKhMeigi.getTsinadr1kj(),
            "通信先住所１２３４５", "通信先住所１（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr2kj(),
            "通信先住所２２３４５", "通信先住所２（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr3kj(),
            "通信先住所３２３４５", "通信先住所３（漢字）");
        exStringEquals(idouKhMeigi.getTsintelno(), "0200-0714-6642", "通信先電話番号");
        exStringEquals(idouKhMeigi.getSbuktnmkn1(), "ｼﾎﾞｳｲﾁ", "死亡受取人名（カナ）１");
        exStringEquals(idouKhMeigi.getSbuktnmkj1(), "死亡受取人１", "死亡受取人名（漢字）１");
        exStringEquals(idouKhMeigi.getSbuktnmkn2(), "ｼﾎﾞｳﾆ", "死亡受取人名（カナ）２");
        exStringEquals(idouKhMeigi.getSbuktnmkj2(), "死亡受取人２", "死亡受取人名（漢字）２");
        exStringEquals(idouKhMeigi.getSbuktnmkn3(), "ｼﾎﾞｳｻﾝ", "死亡受取人名（カナ）３");
        exStringEquals(idouKhMeigi.getSbuktnmkj3(), "死亡受取人３", "死亡受取人名（漢字）３");
        exStringEquals(idouKhMeigi.getSbuktnmkn4(), "ｼﾎﾞｳﾖ", "死亡受取人名（カナ）４");
        exStringEquals(idouKhMeigi.getSbuktnmkj4(), "死亡受取人４", "死亡受取人名（漢字）４");
        exStringEquals(idouKhMeigi.getStdrsknmkn(), "ｼﾃｲﾀﾞｲﾘ", "指定代理請求人名（カナ）");
        exStringEquals(idouKhMeigi.getStdrsknmkj(), "指定代理", "指定代理請求人名（漢字）");
        exStringEquals(idouKhMeigi.getKykdairinmkn(), "ｳｹｵｲｷﾞｮ", "契約者代理人名（カナ）");
        exStringEquals(idouKhMeigi.getKykdairinmkj(), "契約者代理", "契約者代理人名（漢字）");
        exStringEquals(idouKhMeigi.getKzktourokunmkn1(), "ｶｿﾞｸﾀﾞｲ", "家族登録名（カナ）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkj1(), "家族登録名１", "家族登録名（漢字）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkn2(), "ｶｿﾞｸﾀﾞﾆ", "家族登録名（カナ）２");
        exStringEquals(idouKhMeigi.getKzktourokunmkj2(), "家族登録名２", "家族登録名（漢字）２");

        BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.getIdouKhBosyuudr();

        exStringEquals(idouKhBosyuudr.getSyono(), "79807111114", "証券番号");
        exNumericEquals(idouKhBosyuudr.getRenno3keta(), 5, "連番(３桁)");
        exStringEquals(idouKhBosyuudr.getDairitencd1(), "DLCode1", "代理店コード１");
        exStringEquals(idouKhBosyuudr.getBunwari1().toString(), "101", "分担割合１");
        exStringEquals(idouKhBosyuudr.getDairitencd2(), "DLCode2", "代理店コード2");
        exStringEquals(idouKhBosyuudr.getBunwari2().toString(), "202", "分担割合２");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd1(), "Kanri01", "管理組織コード１");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd2(), "Kanri02", "管理組織コード２");

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000120");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000120", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "0000", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIOK,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(80)
    public void testExec2_A8() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN2;

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        bzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzKykNaiyouHaneiYokenBean.setHouteityotkseihyj(null);
        bzKykNaiyouHaneiYokenBean.setSeiritujitrhkjikakkbn(null);
        test1.editYokenData(bzKykNaiyouHaneiYokenBean);

        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIOK, "契約内容反映エラー区分");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUNONE,
            "被保険者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino(), "", "被保険者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI,
            "契約者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino(), "1234567890", "契約者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI,
            "年金受取人名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno(), "2234567890", "年金受取人索引名番号");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getYoukyuuno(), "000000000000000130", "要求通番");
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BT_TjtIdouNyKh tjtIdouNyKh = bzKykNaiyouHaneiKekkaBean.getTjtidounykh();

        exStringEquals(tjtIdouNyKh.getSyono(), "79807111114", "証券番号");
        exNumericEquals(tjtIdouNyKh.getRenno3keta(), 5, "連番(３桁)");
        exNumericEquals(tjtIdouNyKh.getRecordsakujyohyouji(), 4, "レコード削除表示");
        exStringEquals(tjtIdouNyKh.getYoukyuuno(), "000000000000000130", "要求通番");
        exStringEquals(tjtIdouNyKh.getSyouhncd(), "Kh", "商品コード");
        exClassificationEquals(tjtIdouNyKh.getKykjyoutai(), C_Kykjyoutai.ENTYOU, "契約状態");
        exDateEquals(tjtIdouNyKh.getKykymd(), BizDate.valueOf(20160401), "契約日");
        exClassificationEquals(tjtIdouNyKh.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tjtIdouNyKh.getSyoumetujiyuu(), C_Syoumetujiyuu.MENSEKI, "消滅事由");
        exDateEquals(tjtIdouNyKh.getSyoumetuymd(), BizDate.valueOf(20160311), "消滅日");
        exClassificationEquals(tjtIdouNyKh.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(tjtIdouNyKh.getTsnyousibous().toString(), Long.toString(1234), "通算用死亡Ｓ");
        exStringEquals(tjtIdouNyKh.getTsnyouitijip().toString(), Long.toString(1231), "通算用一時払Ｐ");
        exStringEquals(tjtIdouNyKh.getTsnyounkgns().toString(), Long.toString(987), "通算用年金原資");
        exNumericEquals(tjtIdouNyKh.getHrkkkn(), 12, "払込期間");
        exClassificationEquals(tjtIdouNyKh.getSntkhoukbn(), C_SntkhouKbn.NONE, "選択方法区分");
        exDateYMEquals(tjtIdouNyKh.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exNumericEquals(tjtIdouNyKh.getKykhhkndouhyouji(), 6, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn1(), C_TtdktyuuiKbn.HOZENSONOTA, "手続注意区分１");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn2(), C_TtdktyuuiKbn.SYOUMETUJISEISAN, "手続注意区分２");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn3(), C_TtdktyuuiKbn.IKUEISIKINANNAITYUUI, "手続注意区分３");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn4(), C_TtdktyuuiKbn.KAIGAITOKOU, "手続注意区分４");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn5(), C_TtdktyuuiKbn.ADRHUMEI, "手続注意区分５");
        exNumericEquals(tjtIdouNyKh.getSyouhnsdno(), 11, "商品世代番号");
        exClassificationEquals(tjtIdouNyKh.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNyKh.getPyennykntkykumukbn(), C_UmuKbn.ARI, "保険料円入金特約有無区分");
        exStringEquals(tjtIdouNyKh.getTsnyennyknkgk().toString(), Long.toString(4567), "通算用円入金額");
        exStringEquals(tjtIdouNyKh.getSkjmosno(), "764123598", "新契約時申込番号");
        exClassificationEquals(tjtIdouNyKh.getHouteityotkseisyouhnhyj(), C_HouteiTyotkseiSyouhnHyjKbn.HIGAITOU, "法定貯蓄性商品表示");
        exClassificationEquals(tjtIdouNyKh.getSeiritujitrhkjikakkbn(), C_TrhkjiKakKbn.BLNK, "成立時取引時確認区分");

        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();

        exStringEquals(idouKhMeigi.getSyono(), "79807111114", "証券番号");
        exNumericEquals(idouKhMeigi.getRenno3keta(), 5, "連番(３桁)");
        exStringEquals(idouKhMeigi.getHhknnmkn(), "ﾋﾎｹﾝｼｬ", "被保険者名（カナ）");
        exStringEquals(idouKhMeigi.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exDateEquals(idouKhMeigi.getHhknseiymd(), BizDate.valueOf(19881206), "被保険者生年月日");
        exClassificationEquals(idouKhMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouKhMeigi.getHhknyno(), "4354001", "被保険者郵便番号");
        exStringEquals(idouKhMeigi.getHhknadr1kj(),
            "住所１２３４５６７８", "被保険者住所１（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr2kj(),
            "住所２２３４５６７８", "被保険者住所２（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr3kj(),
            "住所３２３４５６７８", "被保険者住所３（漢字）");
        exStringEquals(idouKhMeigi.getHhkntelno(), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(idouKhMeigi.getHhknsykgycd(), "004", "被保険者職業コード");
        exStringEquals(idouKhMeigi.getKyknmkn(), "ｹｲﾔｸｼｬ", "契約者名（カナ）");
        exStringEquals(idouKhMeigi.getKyknmkj(), "佐佐木", "契約者名（漢字）");
        exDateEquals(idouKhMeigi.getKykseiymd(), BizDate.valueOf(19900406), "契約者生年月日");
        exStringEquals(idouKhMeigi.getNenkinuktnmkana(), "ﾈﾝｷﾝ", "年金受取人名（カナ）");
        exStringEquals(idouKhMeigi.getNenkinuktnmkanji(), "年金受取人", "年金受取人名（漢字）");
        exDateEquals(idouKhMeigi.getNenkinuktseiymd(), BizDate.valueOf(19881112), "年金受取人生年月日");
        exStringEquals(idouKhMeigi.getTsinyno(), "4354112", "通信先郵便番号");
        exStringEquals(idouKhMeigi.getTsinadr1kj(),
            "通信先住所１２３４５", "通信先住所１（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr2kj(),
            "通信先住所２２３４５", "通信先住所２（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr3kj(),
            "通信先住所３２３４５", "通信先住所３（漢字）");
        exStringEquals(idouKhMeigi.getTsintelno(), "0200-0714-6642", "通信先電話番号");
        exStringEquals(idouKhMeigi.getSbuktnmkn1(), "ｼﾎﾞｳｲﾁ", "死亡受取人名（カナ）１");
        exStringEquals(idouKhMeigi.getSbuktnmkj1(), "死亡受取人１", "死亡受取人名（漢字）１");
        exStringEquals(idouKhMeigi.getSbuktnmkn2(), "ｼﾎﾞｳﾆ", "死亡受取人名（カナ）２");
        exStringEquals(idouKhMeigi.getSbuktnmkj2(), "死亡受取人２", "死亡受取人名（漢字）２");
        exStringEquals(idouKhMeigi.getSbuktnmkn3(), "ｼﾎﾞｳｻﾝ", "死亡受取人名（カナ）３");
        exStringEquals(idouKhMeigi.getSbuktnmkj3(), "死亡受取人３", "死亡受取人名（漢字）３");
        exStringEquals(idouKhMeigi.getSbuktnmkn4(), "ｼﾎﾞｳﾖ", "死亡受取人名（カナ）４");
        exStringEquals(idouKhMeigi.getSbuktnmkj4(), "死亡受取人４", "死亡受取人名（漢字）４");
        exStringEquals(idouKhMeigi.getStdrsknmkn(), "ｼﾃｲﾀﾞｲﾘ", "指定代理請求人名（カナ）");
        exStringEquals(idouKhMeigi.getStdrsknmkj(), "指定代理", "指定代理請求人名（漢字）");
        exStringEquals(idouKhMeigi.getKykdairinmkn(), "ｳｹｵｲｷﾞｮ", "契約者代理人名（カナ）");
        exStringEquals(idouKhMeigi.getKykdairinmkj(), "契約者代理", "契約者代理人名（漢字）");
        exStringEquals(idouKhMeigi.getKzktourokunmkn1(), "ｶｿﾞｸﾀﾞｲ", "家族登録名（カナ）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkj1(), "家族登録名１", "家族登録名（漢字）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkn2(), "ｶｿﾞｸﾀﾞﾆ", "家族登録名（カナ）２");
        exStringEquals(idouKhMeigi.getKzktourokunmkj2(), "家族登録名２", "家族登録名（漢字）２");

        BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.getIdouKhBosyuudr();

        exStringEquals(idouKhBosyuudr.getSyono(), "79807111114", "証券番号");
        exNumericEquals(idouKhBosyuudr.getRenno3keta(), 5, "連番(３桁)");
        exStringEquals(idouKhBosyuudr.getDairitencd1(), "DLCode1", "代理店コード１");
        exStringEquals(idouKhBosyuudr.getBunwari1().toString(), "101", "分担割合１");
        exStringEquals(idouKhBosyuudr.getDairitencd2(), "DLCode2", "代理店コード2");
        exStringEquals(idouKhBosyuudr.getBunwari2().toString(), "202", "分担割合２");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd1(), "Kanri01", "管理組織コード１");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd2(), "Kanri02", "管理組織コード２");


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000130");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000130", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "0000", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIOK,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(90)
    public void testExec2_A9() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN2;

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        bzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzKykNaiyouHaneiYokenBean.setHouteityotkseihyj(C_HouteiTyotkseiSyouhnHyjKbn.GAITOU);
        bzKykNaiyouHaneiYokenBean.setSeiritujitrhkjikakkbn(C_TrhkjiKakKbn.BLNK);
        test1.editYokenData(bzKykNaiyouHaneiYokenBean);

        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIOK, "契約内容反映エラー区分");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUNONE,
            "被保険者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino(), "", "被保険者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI,
            "契約者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino(), "1234567890", "契約者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI,
            "年金受取人名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno(), "2234567890", "年金受取人索引名番号");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getYoukyuuno(), "000000000000000140", "要求通番");
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BT_TjtIdouNyKh tjtIdouNyKh = bzKykNaiyouHaneiKekkaBean.getTjtidounykh();

        exStringEquals(tjtIdouNyKh.getSyono(), "79807111114", "証券番号");
        exNumericEquals(tjtIdouNyKh.getRenno3keta(), 5, "連番(３桁)");
        exNumericEquals(tjtIdouNyKh.getRecordsakujyohyouji(), 4, "レコード削除表示");
        exStringEquals(tjtIdouNyKh.getYoukyuuno(), "000000000000000140", "要求通番");
        exStringEquals(tjtIdouNyKh.getSyouhncd(), "Kh", "商品コード");
        exClassificationEquals(tjtIdouNyKh.getKykjyoutai(), C_Kykjyoutai.ENTYOU, "契約状態");
        exDateEquals(tjtIdouNyKh.getKykymd(), BizDate.valueOf(20160401), "契約日");
        exClassificationEquals(tjtIdouNyKh.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tjtIdouNyKh.getSyoumetujiyuu(), C_Syoumetujiyuu.MENSEKI, "消滅事由");
        exDateEquals(tjtIdouNyKh.getSyoumetuymd(), BizDate.valueOf(20160311), "消滅日");
        exClassificationEquals(tjtIdouNyKh.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(tjtIdouNyKh.getTsnyousibous().toString(), Long.toString(1234), "通算用死亡Ｓ");
        exStringEquals(tjtIdouNyKh.getTsnyouitijip().toString(), Long.toString(1231), "通算用一時払Ｐ");
        exStringEquals(tjtIdouNyKh.getTsnyounkgns().toString(), Long.toString(987), "通算用年金原資");
        exNumericEquals(tjtIdouNyKh.getHrkkkn(), 12, "払込期間");
        exClassificationEquals(tjtIdouNyKh.getSntkhoukbn(), C_SntkhouKbn.NONE, "選択方法区分");
        exDateYMEquals(tjtIdouNyKh.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exNumericEquals(tjtIdouNyKh.getKykhhkndouhyouji(), 6, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn1(), C_TtdktyuuiKbn.HOZENSONOTA, "手続注意区分１");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn2(), C_TtdktyuuiKbn.SYOUMETUJISEISAN, "手続注意区分２");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn3(), C_TtdktyuuiKbn.IKUEISIKINANNAITYUUI, "手続注意区分３");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn4(), C_TtdktyuuiKbn.KAIGAITOKOU, "手続注意区分４");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn5(), C_TtdktyuuiKbn.ADRHUMEI, "手続注意区分５");
        exNumericEquals(tjtIdouNyKh.getSyouhnsdno(), 11, "商品世代番号");
        exClassificationEquals(tjtIdouNyKh.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNyKh.getPyennykntkykumukbn(), C_UmuKbn.ARI, "保険料円入金特約有無区分");
        exStringEquals(tjtIdouNyKh.getTsnyennyknkgk().toString(), Long.toString(4567), "通算用円入金額");
        exStringEquals(tjtIdouNyKh.getSkjmosno(), "764123598", "新契約時申込番号");
        exClassificationEquals(tjtIdouNyKh.getHouteityotkseisyouhnhyj(), C_HouteiTyotkseiSyouhnHyjKbn.GAITOU, "法定貯蓄性商品表示");
        exClassificationEquals(tjtIdouNyKh.getSeiritujitrhkjikakkbn(), C_TrhkjiKakKbn.BLNK, "成立時取引時確認区分");

        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();

        exStringEquals(idouKhMeigi.getSyono(), "79807111114", "証券番号");
        exNumericEquals(idouKhMeigi.getRenno3keta(), 5, "連番(３桁)");
        exStringEquals(idouKhMeigi.getHhknnmkn(), "ﾋﾎｹﾝｼｬ", "被保険者名（カナ）");
        exStringEquals(idouKhMeigi.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exDateEquals(idouKhMeigi.getHhknseiymd(), BizDate.valueOf(19881206), "被保険者生年月日");
        exClassificationEquals(idouKhMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouKhMeigi.getHhknyno(), "4354001", "被保険者郵便番号");
        exStringEquals(idouKhMeigi.getHhknadr1kj(),
            "住所１２３４５６７８", "被保険者住所１（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr2kj(),
            "住所２２３４５６７８", "被保険者住所２（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr3kj(),
            "住所３２３４５６７８", "被保険者住所３（漢字）");
        exStringEquals(idouKhMeigi.getHhkntelno(), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(idouKhMeigi.getHhknsykgycd(), "004", "被保険者職業コード");
        exStringEquals(idouKhMeigi.getKyknmkn(), "ｹｲﾔｸｼｬ", "契約者名（カナ）");
        exStringEquals(idouKhMeigi.getKyknmkj(), "佐佐木", "契約者名（漢字）");
        exDateEquals(idouKhMeigi.getKykseiymd(), BizDate.valueOf(19900406), "契約者生年月日");
        exStringEquals(idouKhMeigi.getNenkinuktnmkana(), "ﾈﾝｷﾝ", "年金受取人名（カナ）");
        exStringEquals(idouKhMeigi.getNenkinuktnmkanji(), "年金受取人", "年金受取人名（漢字）");
        exDateEquals(idouKhMeigi.getNenkinuktseiymd(), BizDate.valueOf(19881112), "年金受取人生年月日");
        exStringEquals(idouKhMeigi.getTsinyno(), "4354112", "通信先郵便番号");
        exStringEquals(idouKhMeigi.getTsinadr1kj(),
            "通信先住所１２３４５", "通信先住所１（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr2kj(),
            "通信先住所２２３４５", "通信先住所２（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr3kj(),
            "通信先住所３２３４５", "通信先住所３（漢字）");
        exStringEquals(idouKhMeigi.getTsintelno(), "0200-0714-6642", "通信先電話番号");
        exStringEquals(idouKhMeigi.getSbuktnmkn1(), "ｼﾎﾞｳｲﾁ", "死亡受取人名（カナ）１");
        exStringEquals(idouKhMeigi.getSbuktnmkj1(), "死亡受取人１", "死亡受取人名（漢字）１");
        exStringEquals(idouKhMeigi.getSbuktnmkn2(), "ｼﾎﾞｳﾆ", "死亡受取人名（カナ）２");
        exStringEquals(idouKhMeigi.getSbuktnmkj2(), "死亡受取人２", "死亡受取人名（漢字）２");
        exStringEquals(idouKhMeigi.getSbuktnmkn3(), "ｼﾎﾞｳｻﾝ", "死亡受取人名（カナ）３");
        exStringEquals(idouKhMeigi.getSbuktnmkj3(), "死亡受取人３", "死亡受取人名（漢字）３");
        exStringEquals(idouKhMeigi.getSbuktnmkn4(), "ｼﾎﾞｳﾖ", "死亡受取人名（カナ）４");
        exStringEquals(idouKhMeigi.getSbuktnmkj4(), "死亡受取人４", "死亡受取人名（漢字）４");
        exStringEquals(idouKhMeigi.getStdrsknmkn(), "ｼﾃｲﾀﾞｲﾘ", "指定代理請求人名（カナ）");
        exStringEquals(idouKhMeigi.getStdrsknmkj(), "指定代理", "指定代理請求人名（漢字）");
        exStringEquals(idouKhMeigi.getKykdairinmkn(), "ｳｹｵｲｷﾞｮ", "契約者代理人名（カナ）");
        exStringEquals(idouKhMeigi.getKykdairinmkj(), "契約者代理", "契約者代理人名（漢字）");
        exStringEquals(idouKhMeigi.getKzktourokunmkn1(), "ｶｿﾞｸﾀﾞｲ", "家族登録名（カナ）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkj1(), "家族登録名１", "家族登録名（漢字）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkn2(), "ｶｿﾞｸﾀﾞﾆ", "家族登録名（カナ）２");
        exStringEquals(idouKhMeigi.getKzktourokunmkj2(), "家族登録名２", "家族登録名（漢字）２");

        BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.getIdouKhBosyuudr();

        exStringEquals(idouKhBosyuudr.getSyono(), "79807111114", "証券番号");
        exNumericEquals(idouKhBosyuudr.getRenno3keta(), 5, "連番(３桁)");
        exStringEquals(idouKhBosyuudr.getDairitencd1(), "DLCode1", "代理店コード１");
        exStringEquals(idouKhBosyuudr.getBunwari1().toString(), "101", "分担割合１");
        exStringEquals(idouKhBosyuudr.getDairitencd2(), "DLCode2", "代理店コード2");
        exStringEquals(idouKhBosyuudr.getBunwari2().toString(), "202", "分担割合２");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd1(), "Kanri01", "管理組織コード１");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd2(), "Kanri02", "管理組織コード２");


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000140");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000140", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "0000", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIOK,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(100)
    public void testExec2_A10() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN2;

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        bzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzKykNaiyouHaneiYokenBean.setHouteityotkseihyj(C_HouteiTyotkseiSyouhnHyjKbn.GAITOU);
        bzKykNaiyouHaneiYokenBean.setSeiritujitrhkjikakkbn(C_TrhkjiKakKbn.NONE);
        test1.editYokenData(bzKykNaiyouHaneiYokenBean);

        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIOK, "契約内容反映エラー区分");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUNONE,
            "被保険者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino(), "", "被保険者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI,
            "契約者名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino(), "1234567890", "契約者索引名番号");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI,
            "年金受取人名寄せ実施結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno(), "2234567890", "年金受取人索引名番号");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getYoukyuuno(), "000000000000000150", "要求通番");
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BT_TjtIdouNyKh tjtIdouNyKh = bzKykNaiyouHaneiKekkaBean.getTjtidounykh();

        exStringEquals(tjtIdouNyKh.getSyono(), "79807111114", "証券番号");
        exNumericEquals(tjtIdouNyKh.getRenno3keta(), 5, "連番(３桁)");
        exNumericEquals(tjtIdouNyKh.getRecordsakujyohyouji(), 4, "レコード削除表示");
        exStringEquals(tjtIdouNyKh.getYoukyuuno(), "000000000000000150", "要求通番");
        exStringEquals(tjtIdouNyKh.getSyouhncd(), "Kh", "商品コード");
        exClassificationEquals(tjtIdouNyKh.getKykjyoutai(), C_Kykjyoutai.ENTYOU, "契約状態");
        exDateEquals(tjtIdouNyKh.getKykymd(), BizDate.valueOf(20160401), "契約日");
        exClassificationEquals(tjtIdouNyKh.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tjtIdouNyKh.getSyoumetujiyuu(), C_Syoumetujiyuu.MENSEKI, "消滅事由");
        exDateEquals(tjtIdouNyKh.getSyoumetuymd(), BizDate.valueOf(20160311), "消滅日");
        exClassificationEquals(tjtIdouNyKh.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(tjtIdouNyKh.getTsnyousibous().toString(), Long.toString(1234), "通算用死亡Ｓ");
        exStringEquals(tjtIdouNyKh.getTsnyouitijip().toString(), Long.toString(1231), "通算用一時払Ｐ");
        exStringEquals(tjtIdouNyKh.getTsnyounkgns().toString(), Long.toString(987), "通算用年金原資");
        exNumericEquals(tjtIdouNyKh.getHrkkkn(), 12, "払込期間");
        exClassificationEquals(tjtIdouNyKh.getSntkhoukbn(), C_SntkhouKbn.NONE, "選択方法区分");
        exDateYMEquals(tjtIdouNyKh.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exNumericEquals(tjtIdouNyKh.getKykhhkndouhyouji(), 6, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn1(), C_TtdktyuuiKbn.HOZENSONOTA, "手続注意区分１");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn2(), C_TtdktyuuiKbn.SYOUMETUJISEISAN, "手続注意区分２");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn3(), C_TtdktyuuiKbn.IKUEISIKINANNAITYUUI, "手続注意区分３");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn4(), C_TtdktyuuiKbn.KAIGAITOKOU, "手続注意区分４");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn5(), C_TtdktyuuiKbn.ADRHUMEI, "手続注意区分５");
        exNumericEquals(tjtIdouNyKh.getSyouhnsdno(), 11, "商品世代番号");
        exClassificationEquals(tjtIdouNyKh.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNyKh.getPyennykntkykumukbn(), C_UmuKbn.ARI, "保険料円入金特約有無区分");
        exStringEquals(tjtIdouNyKh.getTsnyennyknkgk().toString(), Long.toString(4567), "通算用円入金額");
        exStringEquals(tjtIdouNyKh.getSkjmosno(), "764123598", "新契約時申込番号");
        exClassificationEquals(tjtIdouNyKh.getHouteityotkseisyouhnhyj(), C_HouteiTyotkseiSyouhnHyjKbn.GAITOU, "法定貯蓄性商品表示");
        exClassificationEquals(tjtIdouNyKh.getSeiritujitrhkjikakkbn(), C_TrhkjiKakKbn.NONE, "成立時取引時確認区分");

        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();

        exStringEquals(idouKhMeigi.getSyono(), "79807111114", "証券番号");
        exNumericEquals(idouKhMeigi.getRenno3keta(), 5, "連番(３桁)");
        exStringEquals(idouKhMeigi.getHhknnmkn(), "ﾋﾎｹﾝｼｬ", "被保険者名（カナ）");
        exStringEquals(idouKhMeigi.getHhknnmkj(), "被保険者名", "被保険者名（漢字）");
        exDateEquals(idouKhMeigi.getHhknseiymd(), BizDate.valueOf(19881206), "被保険者生年月日");
        exClassificationEquals(idouKhMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouKhMeigi.getHhknyno(), "4354001", "被保険者郵便番号");
        exStringEquals(idouKhMeigi.getHhknadr1kj(),
            "住所１２３４５６７８", "被保険者住所１（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr2kj(),
            "住所２２３４５６７８", "被保険者住所２（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr3kj(),
            "住所３２３４５６７８", "被保険者住所３（漢字）");
        exStringEquals(idouKhMeigi.getHhkntelno(), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(idouKhMeigi.getHhknsykgycd(), "004", "被保険者職業コード");
        exStringEquals(idouKhMeigi.getKyknmkn(), "ｹｲﾔｸｼｬ", "契約者名（カナ）");
        exStringEquals(idouKhMeigi.getKyknmkj(), "佐佐木", "契約者名（漢字）");
        exDateEquals(idouKhMeigi.getKykseiymd(), BizDate.valueOf(19900406), "契約者生年月日");
        exStringEquals(idouKhMeigi.getNenkinuktnmkana(), "ﾈﾝｷﾝ", "年金受取人名（カナ）");
        exStringEquals(idouKhMeigi.getNenkinuktnmkanji(), "年金受取人", "年金受取人名（漢字）");
        exDateEquals(idouKhMeigi.getNenkinuktseiymd(), BizDate.valueOf(19881112), "年金受取人生年月日");
        exStringEquals(idouKhMeigi.getTsinyno(), "4354112", "通信先郵便番号");
        exStringEquals(idouKhMeigi.getTsinadr1kj(),
            "通信先住所１２３４５", "通信先住所１（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr2kj(),
            "通信先住所２２３４５", "通信先住所２（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr3kj(),
            "通信先住所３２３４５", "通信先住所３（漢字）");
        exStringEquals(idouKhMeigi.getTsintelno(), "0200-0714-6642", "通信先電話番号");
        exStringEquals(idouKhMeigi.getSbuktnmkn1(), "ｼﾎﾞｳｲﾁ", "死亡受取人名（カナ）１");
        exStringEquals(idouKhMeigi.getSbuktnmkj1(), "死亡受取人１", "死亡受取人名（漢字）１");
        exStringEquals(idouKhMeigi.getSbuktnmkn2(), "ｼﾎﾞｳﾆ", "死亡受取人名（カナ）２");
        exStringEquals(idouKhMeigi.getSbuktnmkj2(), "死亡受取人２", "死亡受取人名（漢字）２");
        exStringEquals(idouKhMeigi.getSbuktnmkn3(), "ｼﾎﾞｳｻﾝ", "死亡受取人名（カナ）３");
        exStringEquals(idouKhMeigi.getSbuktnmkj3(), "死亡受取人３", "死亡受取人名（漢字）３");
        exStringEquals(idouKhMeigi.getSbuktnmkn4(), "ｼﾎﾞｳﾖ", "死亡受取人名（カナ）４");
        exStringEquals(idouKhMeigi.getSbuktnmkj4(), "死亡受取人４", "死亡受取人名（漢字）４");
        exStringEquals(idouKhMeigi.getStdrsknmkn(), "ｼﾃｲﾀﾞｲﾘ", "指定代理請求人名（カナ）");
        exStringEquals(idouKhMeigi.getStdrsknmkj(), "指定代理", "指定代理請求人名（漢字）");
        exStringEquals(idouKhMeigi.getKykdairinmkn(), "ｳｹｵｲｷﾞｮ", "契約者代理人名（カナ）");
        exStringEquals(idouKhMeigi.getKykdairinmkj(), "契約者代理", "契約者代理人名（漢字）");
        exStringEquals(idouKhMeigi.getKzktourokunmkn1(), "ｶｿﾞｸﾀﾞｲ", "家族登録名（カナ）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkj1(), "家族登録名１", "家族登録名（漢字）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkn2(), "ｶｿﾞｸﾀﾞﾆ", "家族登録名（カナ）２");
        exStringEquals(idouKhMeigi.getKzktourokunmkj2(), "家族登録名２", "家族登録名（漢字）２");

        BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.getIdouKhBosyuudr();

        exStringEquals(idouKhBosyuudr.getSyono(), "79807111114", "証券番号");
        exNumericEquals(idouKhBosyuudr.getRenno3keta(), 5, "連番(３桁)");
        exStringEquals(idouKhBosyuudr.getDairitencd1(), "DLCode1", "代理店コード１");
        exStringEquals(idouKhBosyuudr.getBunwari1().toString(), "101", "分担割合１");
        exStringEquals(idouKhBosyuudr.getDairitencd2(), "DLCode2", "代理店コード2");
        exStringEquals(idouKhBosyuudr.getBunwari2().toString(), "202", "分担割合２");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd1(), "Kanri01", "管理組織コード１");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd2(), "Kanri02", "管理組織コード２");


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000150");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000150", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "0000", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIOK,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(110)
    public void testExec2_A11() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN1;

        MockObjectManager.initialize();

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        test1.editYokenData1(bzKykNaiyouHaneiYokenBean);
        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);
        test1.editYokenKbnToDefault(bzKykNaiyouHaneiYokenBean);

        bzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(1234, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(1231, BizCurrencyTypes.EURO));
        bzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(987, BizCurrencyTypes.AU_DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(4567, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(876, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(123, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(1233, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(1235, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setNktsnnkgns(BizCurrency.valueOf(765, BizCurrencyTypes.DOLLAR));

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0),
            "PAR2", "処理コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 2),
            "sscd001", "組織コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 3),
            "                    ", "半角スペース20桁");
        String bzKyknaiyouHanei = (String) MockObjectManager.getArgument(
            MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        exStringEquals(bzKyknaiyouHanei.substring(0, 4), "PAR2", "処理コード");
        exStringEquals(bzKyknaiyouHanei.substring(4, 5), ".", "区切符号");
        exStringEquals(bzKyknaiyouHanei.substring(5, 6), " ", "普保Ⅱ契約番号区分");
        exStringEquals(bzKyknaiyouHanei.substring(6, 17), "79807111114", "普保Ⅱ契約番号");
        exStringEquals(bzKyknaiyouHanei.substring(17, 18), "4", "レコード削除表示");
        exStringEquals(bzKyknaiyouHanei.substring(18, 20), "Kh", "（契約保全）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(20, 22), "  ", "（契約保全）契約状態");
        exStringEquals(bzKyknaiyouHanei.substring(22, 30), "20160401", "（契約保全）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(30, 31), " ", "（契約保全）有効消滅区分");
        exStringEquals(bzKyknaiyouHanei.substring(31, 33), "00", "（契約保全）消滅事由");
        exStringEquals(bzKyknaiyouHanei.substring(33, 41), "20160311", "（契約保全）消滅日");
        exStringEquals(bzKyknaiyouHanei.substring(41, 44), "   ", "（契約保全）通算用通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(44, 55), "00000123400", "（契約保全）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(55, 66), "00000123100", "（契約保全）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(66, 77), "00000098700", "（契約保全）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(77, 79), "12", "（契約保全）払込期間");
        exStringEquals(bzKyknaiyouHanei.substring(79, 81), "  ", "（契約保全）選択方法区分");
        exStringEquals(bzKyknaiyouHanei.substring(81, 87), "201605", "（契約保全）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(87, 88), "6", "（契約保全）契約者被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(88, 90), "  ", "（契約保全）手続注意区分１");
        exStringEquals(bzKyknaiyouHanei.substring(90, 92), "  ", "（契約保全）手続注意区分２");
        exStringEquals(bzKyknaiyouHanei.substring(92, 94), "  ", "（契約保全）手続注意区分３");
        exStringEquals(bzKyknaiyouHanei.substring(94, 96), "  ", "（契約保全）手続注意区分４");
        exStringEquals(bzKyknaiyouHanei.substring(96, 98), "  ", "（契約保全）手続注意区分５");
        exStringEquals(bzKyknaiyouHanei.substring(98, 100), "11", "（契約保全）商品世代番号");
        exStringEquals(bzKyknaiyouHanei.substring(100, 101), "0", "（契約保全）介護前払特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(101, 102), "1", "（契約保全）保険料円入金特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(102, 113), "00000456700", "（契約保全）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(113, 122), "764123598", "（契約保全）新契約時申込番号");
        exStringEquals(bzKyknaiyouHanei.substring(122, 123), " ", "（契約保全）法定貯蓄性有表示");
        exStringEquals(bzKyknaiyouHanei.substring(123, 124), " ", "（契約保全）成立時取引時確認区分");
        exStringEquals(bzKyknaiyouHanei.substring(124, 125), " ", "（契約保全）払込経路");

        exStringEquals(bzKyknaiyouHanei.substring(125, 127), "Sk", "（新契約）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(127, 135), "20160311", "（新契約）申込日");
        exStringEquals(bzKyknaiyouHanei.substring(135, 143), "20160411", "（新契約）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(143, 151), "20160511", "（新契約）責任開始日");
        exStringEquals(bzKyknaiyouHanei.substring(151, 152), " ", "（新契約）成立区分");
        exStringEquals(bzKyknaiyouHanei.substring(152, 160), "20160416", "（新契約）成立処理日");
        exStringEquals(bzKyknaiyouHanei.substring(160, 161), "1", "（新契約）ＭＦ連動済フラグ");
        exStringEquals(bzKyknaiyouHanei.substring(161, 172), "10000000003", "（新契約）証券番号");
        exStringEquals(bzKyknaiyouHanei.substring(172, 175), "   ", "（新契約）通算用通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(175, 186), "00000087600", "（新契約）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(186, 197), "00000012300", "（新契約）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(197, 208), "00000123300", "（新契約）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(208, 210), "10", "（新契約）払込期間");
        exStringEquals(bzKyknaiyouHanei.substring(210, 212), "  ", "（新契約）選択方法区分");
        exStringEquals(bzKyknaiyouHanei.substring(212, 218), "201604", "（新契約）募集年月");
        exStringEquals(bzKyknaiyouHanei.substring(218, 219), "1", "（新契約）契約者被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(219, 220), " ", "（新契約）申込消滅区分");
        exStringEquals(bzKyknaiyouHanei.substring(220, 222), "21", "（新契約）商品世代番号");
        exStringEquals(bzKyknaiyouHanei.substring(222, 223), "1", "（新契約）介護前払特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(223, 224), "0", "（新契約）保険料円入金特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(224, 235), "00000123500", "（新契約）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(235, 236), " ", "（新契約）払込経路");

        exStringEquals(bzKyknaiyouHanei.substring(236, 238), "Nk", "（年金支払）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(238, 246), "20160412", "（年金支払）年金支払開始日");
        exStringEquals(bzKyknaiyouHanei.substring(246, 254), "20160512", "（年金支払）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(254, 256), "  ", "（年金支払）年金消滅コード");
        exStringEquals(bzKyknaiyouHanei.substring(256, 264), "20160312", "（年金支払）消滅日");
        exStringEquals(bzKyknaiyouHanei.substring(264, 267), "   ", "（年金支払）支払通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(267, 269), "21", "（年金支払）定額年金年金種類");
        exStringEquals(bzKyknaiyouHanei.substring(269, 280), "00000076500", "（年金支払）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(280, 281), "1", "（年金支払）年金受取人被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(281, 283), "31", "（年金支払）商品世代番号");

        exStringEquals(bzKyknaiyouHanei.substring(283, 301), "ﾋﾎｹﾝｼｬ            ", "被保険者名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(301, 316), "被保険者名　　　　　　　　　　", "被保険者名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(316, 324), "19881206", "被保険者生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(324, 325), " ", "被保険者性別");
        exStringEquals(bzKyknaiyouHanei.substring(325, 332), "4354001", "被保険者郵便番号");
        exStringEquals(bzKyknaiyouHanei.substring(332, 394),
            "住所１２３４５６７８住所２２３４５６７８住所３２３４５６７８　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　", "被保険者住所");
        exStringEquals(bzKyknaiyouHanei.substring(394, 408), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(bzKyknaiyouHanei.substring(408, 411), "004", "被保険者職業コード");
        exStringEquals(bzKyknaiyouHanei.substring(411, 429), "ｹｲﾔｸｼｬ            ", "契約者名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(429, 444), "佐佐木　　　　　　　　　　　　", "契約者名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(444, 452), "19900406", "契約者生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(452, 470), "ﾈﾝｷﾝ              ", "年金受取人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(470, 485), "年金受取人　　　　　　　　　　", "年金受取人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(485, 493), "19881112", "年金受取人生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(493, 500), "4354112", "通信先郵便番号");
        exStringEquals(bzKyknaiyouHanei.substring(500, 562),
            "通信先住所１２３４５通信先住所２２３４５通信先住所３２３４５　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　", "通信先住所");
        exStringEquals(bzKyknaiyouHanei.substring(562, 576), "0200-0714-6642", "通信先電話番号");
        exStringEquals(bzKyknaiyouHanei.substring(576, 594), "ｼﾎﾞｳｲﾁ            ", "死亡受取人名（カナ）１");
        exStringEquals(bzKyknaiyouHanei.substring(594, 609), "死亡受取人１　　　　　　　　　", "死亡受取人名（漢字）１");
        exStringEquals(bzKyknaiyouHanei.substring(609, 627), "ｼﾎﾞｳﾆ             ", "死亡受取人名（カナ）２");
        exStringEquals(bzKyknaiyouHanei.substring(627, 642), "死亡受取人２　　　　　　　　　", "死亡受取人名（漢字）２");
        exStringEquals(bzKyknaiyouHanei.substring(642, 660), "ｼﾎﾞｳｻﾝ            ", "死亡受取人名（カナ）３");
        exStringEquals(bzKyknaiyouHanei.substring(660, 675), "死亡受取人３　　　　　　　　　", "死亡受取人名（漢字）３");
        exStringEquals(bzKyknaiyouHanei.substring(675, 693), "ｼﾎﾞｳﾖ             ", "死亡受取人名（カナ）４");
        exStringEquals(bzKyknaiyouHanei.substring(693, 708), "死亡受取人４　　　　　　　　　", "死亡受取人名（漢字）４");
        exStringEquals(bzKyknaiyouHanei.substring(708, 726), "ｼﾃｲﾀﾞｲﾘ           ", "指定代理請求人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(726, 741), "指定代理　　　　　　　　　　　", "指定代理請求人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(741, 759), "ｳｹｵｲｷﾞｮ           ", "契約者代理人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(759, 774), "契約者代理　　　　　　　　　　", "契約者代理人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(774, 792), "ｶｿﾞｸﾀﾞｲ           ", "家族登録名（カナ）１");
        exStringEquals(bzKyknaiyouHanei.substring(792, 807), "家族登録名１　　　　　　　　　", "家族登録名（漢字）１");
        exStringEquals(bzKyknaiyouHanei.substring(807, 825), "ｶｿﾞｸﾀﾞﾆ           ", "家族登録名（カナ）２");
        exStringEquals(bzKyknaiyouHanei.substring(825, 840), "家族登録名２　　　　　　　　　", "家族登録名（漢字）２");
        exStringEquals(bzKyknaiyouHanei.substring(840, 844), "    ", "銀行コード");
        exStringEquals(bzKyknaiyouHanei.substring(844, 847), "   ", "支店コード");
        exStringEquals(bzKyknaiyouHanei.substring(847, 848), " ", "預金種目区分");
        exStringEquals(bzKyknaiyouHanei.substring(848, 855), "       ", "口座番号");
        exStringEquals(bzKyknaiyouHanei.substring(855, 885), "ｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝ", "口座名義人氏名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(885, 886), "0", "口座名義契約者同一人区分");
        exStringEquals(bzKyknaiyouHanei.substring(886, 893), "DLCode1", "代理店コード１");
        exStringEquals(bzKyknaiyouHanei.substring(893, 896), "101", "分担割合１");
        exStringEquals(bzKyknaiyouHanei.substring(896, 903), "DLCode2", "代理店コード２");
        exStringEquals(bzKyknaiyouHanei.substring(903, 906), "202", "分担割合２");
        exStringEquals(bzKyknaiyouHanei.substring(906, 913), "Kanri01", "管理組織コード１");
        exStringEquals(bzKyknaiyouHanei.substring(913, 920), "Kanri02", "管理組織コード２");
        exStringEquals(bzKyknaiyouHanei.substring(920), "000000000000000160", "要求通番");

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getAcserrcd(), "5434", "ACS基盤エラーコード");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIERROR, "契約内容反映エラー区分");
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000060");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000060", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "5434", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIERROR,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(120)
    public void testExec2_A12() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN1;

        MockObjectManager.initialize();

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        test1.editYokenData2(bzKykNaiyouHaneiYokenBean);
        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);
        test1.editYokenKbnToDefault(bzKykNaiyouHaneiYokenBean);

        bzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(1234, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(1231, BizCurrencyTypes.EURO));
        bzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(987, BizCurrencyTypes.AU_DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(4567, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(876, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(123, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(1233, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(1235, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setNktsnnkgns(BizCurrency.valueOf(765, BizCurrencyTypes.DOLLAR));

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0),
            "PAR2", "処理コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 2),
            "sscd001", "組織コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 3),
            "                    ", "半角スペース20桁");
        String bzKyknaiyouHanei = (String) MockObjectManager.getArgument(
            MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        exStringEquals(bzKyknaiyouHanei.substring(0, 4), "PAR2", "処理コード");
        exStringEquals(bzKyknaiyouHanei.substring(4, 5), ".", "区切符号");
        exStringEquals(bzKyknaiyouHanei.substring(5, 6), " ", "普保Ⅱ契約番号区分");
        exStringEquals(bzKyknaiyouHanei.substring(6, 17), "79807111114", "普保Ⅱ契約番号");
        exStringEquals(bzKyknaiyouHanei.substring(17, 18), "4", "レコード削除表示");
        exStringEquals(bzKyknaiyouHanei.substring(18, 20), "Kh", "（契約保全）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(20, 22), "  ", "（契約保全）契約状態");
        exStringEquals(bzKyknaiyouHanei.substring(22, 30), "20160401", "（契約保全）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(30, 31), " ", "（契約保全）有効消滅区分");
        exStringEquals(bzKyknaiyouHanei.substring(31, 33), "00", "（契約保全）消滅事由");
        exStringEquals(bzKyknaiyouHanei.substring(33, 41), "20160311", "（契約保全）消滅日");
        exStringEquals(bzKyknaiyouHanei.substring(41, 44), "JPY", "（契約保全）通算用通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(44, 55), "00000123400", "（契約保全）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(55, 66), "00000123100", "（契約保全）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(66, 77), "00000098700", "（契約保全）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(77, 79), "12", "（契約保全）払込期間");
        exStringEquals(bzKyknaiyouHanei.substring(79, 81), "  ", "（契約保全）選択方法区分");
        exStringEquals(bzKyknaiyouHanei.substring(81, 87), "201605", "（契約保全）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(87, 88), "6", "（契約保全）契約者被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(88, 90), "  ", "（契約保全）手続注意区分１");
        exStringEquals(bzKyknaiyouHanei.substring(90, 92), "  ", "（契約保全）手続注意区分２");
        exStringEquals(bzKyknaiyouHanei.substring(92, 94), "  ", "（契約保全）手続注意区分３");
        exStringEquals(bzKyknaiyouHanei.substring(94, 96), "  ", "（契約保全）手続注意区分４");
        exStringEquals(bzKyknaiyouHanei.substring(96, 98), "  ", "（契約保全）手続注意区分５");
        exStringEquals(bzKyknaiyouHanei.substring(98, 100), "11", "（契約保全）商品世代番号");
        exStringEquals(bzKyknaiyouHanei.substring(100, 101), "0", "（契約保全）介護前払特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(101, 102), "1", "（契約保全）保険料円入金特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(102, 113), "00000456700", "（契約保全）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(113, 122), "764123598", "（契約保全）新契約時申込番号");
        exStringEquals(bzKyknaiyouHanei.substring(122, 123), " ", "（契約保全）法定貯蓄性有表示");
        exStringEquals(bzKyknaiyouHanei.substring(123, 124), " ", "（契約保全）成立時取引時確認区分");
        exStringEquals(bzKyknaiyouHanei.substring(124, 125), "6", "（契約保全）払込経路");

        exStringEquals(bzKyknaiyouHanei.substring(125, 127), "Sk", "（新契約）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(127, 135), "20160311", "（新契約）申込日");
        exStringEquals(bzKyknaiyouHanei.substring(135, 143), "20160411", "（新契約）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(143, 151), "20160511", "（新契約）責任開始日");
        exStringEquals(bzKyknaiyouHanei.substring(151, 152), " ", "（新契約）成立区分");
        exStringEquals(bzKyknaiyouHanei.substring(152, 160), "20160416", "（新契約）成立処理日");
        exStringEquals(bzKyknaiyouHanei.substring(160, 161), "1", "（新契約）ＭＦ連動済フラグ");
        exStringEquals(bzKyknaiyouHanei.substring(161, 172), "10000000003", "（新契約）証券番号");
        exStringEquals(bzKyknaiyouHanei.substring(172, 175), "JPY", "（新契約）通算用通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(175, 186), "00000087600", "（新契約）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(186, 197), "00000012300", "（新契約）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(197, 208), "00000123300", "（新契約）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(208, 210), "10", "（新契約）払込期間");
        exStringEquals(bzKyknaiyouHanei.substring(210, 212), "  ", "（新契約）選択方法区分");
        exStringEquals(bzKyknaiyouHanei.substring(212, 218), "201604", "（新契約）募集年月");
        exStringEquals(bzKyknaiyouHanei.substring(218, 219), "1", "（新契約）契約者被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(219, 220), " ", "（新契約）申込消滅区分");
        exStringEquals(bzKyknaiyouHanei.substring(220, 222), "21", "（新契約）商品世代番号");
        exStringEquals(bzKyknaiyouHanei.substring(222, 223), "1", "（新契約）介護前払特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(223, 224), "0", "（新契約）保険料円入金特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(224, 235), "00000123500", "（新契約）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(235, 236), "6", "（新契約）払込経路");

        exStringEquals(bzKyknaiyouHanei.substring(236, 238), "Nk", "（年金支払）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(238, 246), "20160412", "（年金支払）年金支払開始日");
        exStringEquals(bzKyknaiyouHanei.substring(246, 254), "20160512", "（年金支払）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(254, 256), "  ", "（年金支払）年金消滅コード");
        exStringEquals(bzKyknaiyouHanei.substring(256, 264), "20160312", "（年金支払）消滅日");
        exStringEquals(bzKyknaiyouHanei.substring(264, 267), "   ", "（年金支払）支払通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(267, 269), "21", "（年金支払）定額年金年金種類");
        exStringEquals(bzKyknaiyouHanei.substring(269, 280), "00000076500", "（年金支払）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(280, 281), "1", "（年金支払）年金受取人被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(281, 283), "31", "（年金支払）商品世代番号");

        exStringEquals(bzKyknaiyouHanei.substring(283, 301), "ﾋﾎｹﾝｼｬ            ", "被保険者名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(301, 316), "被保険者名　　　　　　　　　　", "被保険者名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(316, 324), "19881206", "被保険者生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(324, 325), " ", "被保険者性別");
        exStringEquals(bzKyknaiyouHanei.substring(325, 332), "4354001", "被保険者郵便番号");
        exStringEquals(bzKyknaiyouHanei.substring(332, 394),
            "住所１２３４５６７８住所２２３４５６７８住所３２３４５６７８　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　", "被保険者住所");
        exStringEquals(bzKyknaiyouHanei.substring(394, 408), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(bzKyknaiyouHanei.substring(408, 411), "004", "被保険者職業コード");
        exStringEquals(bzKyknaiyouHanei.substring(411, 429), "ｹｲﾔｸｼｬ            ", "契約者名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(429, 444), "佐佐木　　　　　　　　　　　　", "契約者名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(444, 452), "19900406", "契約者生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(452, 470), "ﾈﾝｷﾝ              ", "年金受取人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(470, 485), "年金受取人　　　　　　　　　　", "年金受取人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(485, 493), "19881112", "年金受取人生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(493, 500), "4354112", "通信先郵便番号");
        exStringEquals(bzKyknaiyouHanei.substring(500, 562),
            "通信先住所１２３４５通信先住所２２３４５通信先住所３２３４５　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　", "通信先住所");
        exStringEquals(bzKyknaiyouHanei.substring(562, 576), "0200-0714-6642", "通信先電話番号");
        exStringEquals(bzKyknaiyouHanei.substring(576, 594), "ｼﾎﾞｳｲﾁ            ", "死亡受取人名（カナ）１");
        exStringEquals(bzKyknaiyouHanei.substring(594, 609), "死亡受取人１　　　　　　　　　", "死亡受取人名（漢字）１");
        exStringEquals(bzKyknaiyouHanei.substring(609, 627), "ｼﾎﾞｳﾆ             ", "死亡受取人名（カナ）２");
        exStringEquals(bzKyknaiyouHanei.substring(627, 642), "死亡受取人２　　　　　　　　　", "死亡受取人名（漢字）２");
        exStringEquals(bzKyknaiyouHanei.substring(642, 660), "ｼﾎﾞｳｻﾝ            ", "死亡受取人名（カナ）３");
        exStringEquals(bzKyknaiyouHanei.substring(660, 675), "死亡受取人３　　　　　　　　　", "死亡受取人名（漢字）３");
        exStringEquals(bzKyknaiyouHanei.substring(675, 693), "ｼﾎﾞｳﾖ             ", "死亡受取人名（カナ）４");
        exStringEquals(bzKyknaiyouHanei.substring(693, 708), "死亡受取人４　　　　　　　　　", "死亡受取人名（漢字）４");
        exStringEquals(bzKyknaiyouHanei.substring(708, 726), "ｼﾃｲﾀﾞｲﾘ           ", "指定代理請求人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(726, 741), "指定代理　　　　　　　　　　　", "指定代理請求人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(741, 759), "ｳｹｵｲｷﾞｮ           ", "契約者代理人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(759, 774), "契約者代理　　　　　　　　　　", "契約者代理人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(774, 792), "ｶｿﾞｸﾀﾞｲ           ", "家族登録名（カナ）１");
        exStringEquals(bzKyknaiyouHanei.substring(792, 807), "家族登録名１　　　　　　　　　", "家族登録名（漢字）１");
        exStringEquals(bzKyknaiyouHanei.substring(807, 825), "ｶｿﾞｸﾀﾞﾆ           ", "家族登録名（カナ）２");
        exStringEquals(bzKyknaiyouHanei.substring(825, 840), "家族登録名２　　　　　　　　　", "家族登録名（漢字）２");
        exStringEquals(bzKyknaiyouHanei.substring(840, 844), "0123", "銀行コード");
        exStringEquals(bzKyknaiyouHanei.substring(844, 847), "002", "支店コード");
        exStringEquals(bzKyknaiyouHanei.substring(847, 848), "1", "預金種目区分");
        exStringEquals(bzKyknaiyouHanei.substring(848, 855), "0012345", "口座番号");
        exStringEquals(bzKyknaiyouHanei.substring(855, 885), "ｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝ", "口座名義人氏名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(885, 886), "1", "口座名義契約者同一人区分");
        exStringEquals(bzKyknaiyouHanei.substring(886, 893), "DLCode1", "代理店コード１");
        exStringEquals(bzKyknaiyouHanei.substring(893, 896), "101", "分担割合１");
        exStringEquals(bzKyknaiyouHanei.substring(896, 903), "DLCode2", "代理店コード２");
        exStringEquals(bzKyknaiyouHanei.substring(903, 906), "202", "分担割合２");
        exStringEquals(bzKyknaiyouHanei.substring(906, 913), "Kanri01", "管理組織コード１");
        exStringEquals(bzKyknaiyouHanei.substring(913, 920), "Kanri02", "管理組織コード２");
        exStringEquals(bzKyknaiyouHanei.substring(920), "000000000000000170", "要求通番");

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getAcserrcd(), "5434", "ACS基盤エラーコード");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIERROR, "契約内容反映エラー区分");
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000060");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000060", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "5434", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIERROR,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(130)
    public void testExec2_A13() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN1;

        MockObjectManager.initialize();

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        test1.editYokenData3(bzKykNaiyouHaneiYokenBean);
        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);
        test1.editYokenKbnToDefault(bzKykNaiyouHaneiYokenBean);

        bzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(1234, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(1231, BizCurrencyTypes.EURO));
        bzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(987, BizCurrencyTypes.AU_DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(4567, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(876, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(123, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(1233, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(1235, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setNktsnnkgns(BizCurrency.valueOf(765, BizCurrencyTypes.DOLLAR));

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0),
            "PAR2", "処理コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 2),
            "sscd001", "組織コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 3),
            "                    ", "半角スペース20桁");
        String bzKyknaiyouHanei = (String) MockObjectManager.getArgument(
            MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        exStringEquals(bzKyknaiyouHanei.substring(0, 4), "PAR2", "処理コード");
        exStringEquals(bzKyknaiyouHanei.substring(4, 5), ".", "区切符号");
        exStringEquals(bzKyknaiyouHanei.substring(5, 6), " ", "普保Ⅱ契約番号区分");
        exStringEquals(bzKyknaiyouHanei.substring(6, 17), "79807111114", "普保Ⅱ契約番号");
        exStringEquals(bzKyknaiyouHanei.substring(17, 18), "4", "レコード削除表示");
        exStringEquals(bzKyknaiyouHanei.substring(18, 20), "Kh", "（契約保全）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(20, 22), "  ", "（契約保全）契約状態");
        exStringEquals(bzKyknaiyouHanei.substring(22, 30), "20160401", "（契約保全）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(30, 31), " ", "（契約保全）有効消滅区分");
        exStringEquals(bzKyknaiyouHanei.substring(31, 33), "00", "（契約保全）消滅事由");
        exStringEquals(bzKyknaiyouHanei.substring(33, 41), "20160311", "（契約保全）消滅日");
        exStringEquals(bzKyknaiyouHanei.substring(41, 44), "   ", "（契約保全）通算用通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(44, 55), "00000123400", "（契約保全）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(55, 66), "00000123100", "（契約保全）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(66, 77), "00000098700", "（契約保全）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(77, 79), "12", "（契約保全）払込期間");
        exStringEquals(bzKyknaiyouHanei.substring(79, 81), "  ", "（契約保全）選択方法区分");
        exStringEquals(bzKyknaiyouHanei.substring(81, 87), "201605", "（契約保全）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(87, 88), "6", "（契約保全）契約者被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(88, 90), "  ", "（契約保全）手続注意区分１");
        exStringEquals(bzKyknaiyouHanei.substring(90, 92), "  ", "（契約保全）手続注意区分２");
        exStringEquals(bzKyknaiyouHanei.substring(92, 94), "  ", "（契約保全）手続注意区分３");
        exStringEquals(bzKyknaiyouHanei.substring(94, 96), "  ", "（契約保全）手続注意区分４");
        exStringEquals(bzKyknaiyouHanei.substring(96, 98), "  ", "（契約保全）手続注意区分５");
        exStringEquals(bzKyknaiyouHanei.substring(98, 100), "11", "（契約保全）商品世代番号");
        exStringEquals(bzKyknaiyouHanei.substring(100, 101), "0", "（契約保全）介護前払特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(101, 102), "1", "（契約保全）保険料円入金特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(102, 113), "00000456700", "（契約保全）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(113, 122), "764123598", "（契約保全）新契約時申込番号");
        exStringEquals(bzKyknaiyouHanei.substring(122, 123), " ", "（契約保全）法定貯蓄性有表示");
        exStringEquals(bzKyknaiyouHanei.substring(123, 124), " ", "（契約保全）成立時取引時確認区分");
        exStringEquals(bzKyknaiyouHanei.substring(124, 125), "6", "（契約保全）払込経路");

        exStringEquals(bzKyknaiyouHanei.substring(125, 127), "Sk", "（新契約）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(127, 135), "20160311", "（新契約）申込日");
        exStringEquals(bzKyknaiyouHanei.substring(135, 143), "20160411", "（新契約）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(143, 151), "20160511", "（新契約）責任開始日");
        exStringEquals(bzKyknaiyouHanei.substring(151, 152), " ", "（新契約）成立区分");
        exStringEquals(bzKyknaiyouHanei.substring(152, 160), "20160416", "（新契約）成立処理日");
        exStringEquals(bzKyknaiyouHanei.substring(160, 161), "1", "（新契約）ＭＦ連動済フラグ");
        exStringEquals(bzKyknaiyouHanei.substring(161, 172), "10000000003", "（新契約）証券番号");
        exStringEquals(bzKyknaiyouHanei.substring(172, 175), "JPY", "（新契約）通算用通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(175, 186), "00000087600", "（新契約）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(186, 197), "00000012300", "（新契約）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(197, 208), "00000123300", "（新契約）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(208, 210), "10", "（新契約）払込期間");
        exStringEquals(bzKyknaiyouHanei.substring(210, 212), "  ", "（新契約）選択方法区分");
        exStringEquals(bzKyknaiyouHanei.substring(212, 218), "201604", "（新契約）募集年月");
        exStringEquals(bzKyknaiyouHanei.substring(218, 219), "1", "（新契約）契約者被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(219, 220), " ", "（新契約）申込消滅区分");
        exStringEquals(bzKyknaiyouHanei.substring(220, 222), "21", "（新契約）商品世代番号");
        exStringEquals(bzKyknaiyouHanei.substring(222, 223), "1", "（新契約）介護前払特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(223, 224), "0", "（新契約）保険料円入金特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(224, 235), "00000123500", "（新契約）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(235, 236), "2", "（新契約）払込経路");

        exStringEquals(bzKyknaiyouHanei.substring(236, 238), "Nk", "（年金支払）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(238, 246), "20160412", "（年金支払）年金支払開始日");
        exStringEquals(bzKyknaiyouHanei.substring(246, 254), "20160512", "（年金支払）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(254, 256), "  ", "（年金支払）年金消滅コード");
        exStringEquals(bzKyknaiyouHanei.substring(256, 264), "20160312", "（年金支払）消滅日");
        exStringEquals(bzKyknaiyouHanei.substring(264, 267), "   ", "（年金支払）支払通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(267, 269), "21", "（年金支払）定額年金年金種類");
        exStringEquals(bzKyknaiyouHanei.substring(269, 280), "00000076500", "（年金支払）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(280, 281), "1", "（年金支払）年金受取人被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(281, 283), "31", "（年金支払）商品世代番号");

        exStringEquals(bzKyknaiyouHanei.substring(283, 301), "ﾋﾎｹﾝｼｬ            ", "被保険者名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(301, 316), "被保険者名　　　　　　　　　　", "被保険者名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(316, 324), "19881206", "被保険者生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(324, 325), " ", "被保険者性別");
        exStringEquals(bzKyknaiyouHanei.substring(325, 332), "4354001", "被保険者郵便番号");
        exStringEquals(bzKyknaiyouHanei.substring(332, 394),
            "住所１２３４５６７８住所２２３４５６７８住所３２３４５６７８　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　", "被保険者住所");
        exStringEquals(bzKyknaiyouHanei.substring(394, 408), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(bzKyknaiyouHanei.substring(408, 411), "004", "被保険者職業コード");
        exStringEquals(bzKyknaiyouHanei.substring(411, 429), "ｹｲﾔｸｼｬ            ", "契約者名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(429, 444), "佐佐木　　　　　　　　　　　　", "契約者名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(444, 452), "19900406", "契約者生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(452, 470), "ﾈﾝｷﾝ              ", "年金受取人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(470, 485), "年金受取人　　　　　　　　　　", "年金受取人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(485, 493), "19881112", "年金受取人生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(493, 500), "4354112", "通信先郵便番号");
        exStringEquals(bzKyknaiyouHanei.substring(500, 562),
            "通信先住所１２３４５通信先住所２２３４５通信先住所３２３４５　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　", "通信先住所");
        exStringEquals(bzKyknaiyouHanei.substring(562, 576), "0200-0714-6642", "通信先電話番号");
        exStringEquals(bzKyknaiyouHanei.substring(576, 594), "ｼﾎﾞｳｲﾁ            ", "死亡受取人名（カナ）１");
        exStringEquals(bzKyknaiyouHanei.substring(594, 609), "死亡受取人１　　　　　　　　　", "死亡受取人名（漢字）１");
        exStringEquals(bzKyknaiyouHanei.substring(609, 627), "ｼﾎﾞｳﾆ             ", "死亡受取人名（カナ）２");
        exStringEquals(bzKyknaiyouHanei.substring(627, 642), "死亡受取人２　　　　　　　　　", "死亡受取人名（漢字）２");
        exStringEquals(bzKyknaiyouHanei.substring(642, 660), "ｼﾎﾞｳｻﾝ            ", "死亡受取人名（カナ）３");
        exStringEquals(bzKyknaiyouHanei.substring(660, 675), "死亡受取人３　　　　　　　　　", "死亡受取人名（漢字）３");
        exStringEquals(bzKyknaiyouHanei.substring(675, 693), "ｼﾎﾞｳﾖ             ", "死亡受取人名（カナ）４");
        exStringEquals(bzKyknaiyouHanei.substring(693, 708), "死亡受取人４　　　　　　　　　", "死亡受取人名（漢字）４");
        exStringEquals(bzKyknaiyouHanei.substring(708, 726), "ｼﾃｲﾀﾞｲﾘ           ", "指定代理請求人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(726, 741), "指定代理　　　　　　　　　　　", "指定代理請求人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(741, 759), "ｳｹｵｲｷﾞｮ           ", "契約者代理人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(759, 774), "契約者代理　　　　　　　　　　", "契約者代理人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(774, 792), "ｶｿﾞｸﾀﾞｲ           ", "家族登録名（カナ）１");
        exStringEquals(bzKyknaiyouHanei.substring(792, 807), "家族登録名１　　　　　　　　　", "家族登録名（漢字）１");
        exStringEquals(bzKyknaiyouHanei.substring(807, 825), "ｶｿﾞｸﾀﾞﾆ           ", "家族登録名（カナ）２");
        exStringEquals(bzKyknaiyouHanei.substring(825, 840), "家族登録名２　　　　　　　　　", "家族登録名（漢字）２");
        exStringEquals(bzKyknaiyouHanei.substring(840, 844), "1234", "銀行コード");
        exStringEquals(bzKyknaiyouHanei.substring(844, 847), "123", "支店コード");
        exStringEquals(bzKyknaiyouHanei.substring(847, 848), "1", "預金種目区分");
        exStringEquals(bzKyknaiyouHanei.substring(848, 855), "2345678", "口座番号");
        exStringEquals(bzKyknaiyouHanei.substring(855, 885), "ｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝ", "口座名義人氏名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(885, 886), "1", "口座名義契約者同一人区分");
        exStringEquals(bzKyknaiyouHanei.substring(886, 893), "DLCode1", "代理店コード１");
        exStringEquals(bzKyknaiyouHanei.substring(893, 896), "101", "分担割合１");
        exStringEquals(bzKyknaiyouHanei.substring(896, 903), "DLCode2", "代理店コード２");
        exStringEquals(bzKyknaiyouHanei.substring(903, 906), "202", "分担割合２");
        exStringEquals(bzKyknaiyouHanei.substring(906, 913), "Kanri01", "管理組織コード１");
        exStringEquals(bzKyknaiyouHanei.substring(913, 920), "Kanri02", "管理組織コード２");
        exStringEquals(bzKyknaiyouHanei.substring(920), "000000000000000180", "要求通番");

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getAcserrcd(), "5434", "ACS基盤エラーコード");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIERROR, "契約内容反映エラー区分");
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000060");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000060", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "5434", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIERROR,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(140)
    public void testExec2_A14() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN1;

        MockObjectManager.initialize();

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        test1.editYokenData4(bzKykNaiyouHaneiYokenBean);
        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);
        test1.editYokenKbnToDefault(bzKykNaiyouHaneiYokenBean);

        bzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(1234, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(1231, BizCurrencyTypes.EURO));
        bzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(987, BizCurrencyTypes.AU_DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(4567, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(876, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(123, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(1233, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(1235, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setNktsnnkgns(BizCurrency.valueOf(765, BizCurrencyTypes.DOLLAR));

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0),
            "PAR2", "処理コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 2),
            "sscd001", "組織コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 3),
            "                    ", "半角スペース20桁");
        String bzKyknaiyouHanei = (String) MockObjectManager.getArgument(
            MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        exStringEquals(bzKyknaiyouHanei.substring(0, 4), "PAR2", "処理コード");
        exStringEquals(bzKyknaiyouHanei.substring(4, 5), ".", "区切符号");
        exStringEquals(bzKyknaiyouHanei.substring(5, 6), " ", "普保Ⅱ契約番号区分");
        exStringEquals(bzKyknaiyouHanei.substring(6, 17), "79807111114", "普保Ⅱ契約番号");
        exStringEquals(bzKyknaiyouHanei.substring(17, 18), "4", "レコード削除表示");
        exStringEquals(bzKyknaiyouHanei.substring(18, 20), "Kh", "（契約保全）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(20, 22), "  ", "（契約保全）契約状態");
        exStringEquals(bzKyknaiyouHanei.substring(22, 30), "20160401", "（契約保全）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(30, 31), " ", "（契約保全）有効消滅区分");
        exStringEquals(bzKyknaiyouHanei.substring(31, 33), "00", "（契約保全）消滅事由");
        exStringEquals(bzKyknaiyouHanei.substring(33, 41), "20160311", "（契約保全）消滅日");
        exStringEquals(bzKyknaiyouHanei.substring(41, 44), "   ", "（契約保全）通算用通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(44, 55), "00000123400", "（契約保全）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(55, 66), "00000123100", "（契約保全）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(66, 77), "00000098700", "（契約保全）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(77, 79), "12", "（契約保全）払込期間");
        exStringEquals(bzKyknaiyouHanei.substring(79, 81), "  ", "（契約保全）選択方法区分");
        exStringEquals(bzKyknaiyouHanei.substring(81, 87), "201605", "（契約保全）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(87, 88), "6", "（契約保全）契約者被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(88, 90), "  ", "（契約保全）手続注意区分１");
        exStringEquals(bzKyknaiyouHanei.substring(90, 92), "  ", "（契約保全）手続注意区分２");
        exStringEquals(bzKyknaiyouHanei.substring(92, 94), "  ", "（契約保全）手続注意区分３");
        exStringEquals(bzKyknaiyouHanei.substring(94, 96), "  ", "（契約保全）手続注意区分４");
        exStringEquals(bzKyknaiyouHanei.substring(96, 98), "  ", "（契約保全）手続注意区分５");
        exStringEquals(bzKyknaiyouHanei.substring(98, 100), "11", "（契約保全）商品世代番号");
        exStringEquals(bzKyknaiyouHanei.substring(100, 101), "0", "（契約保全）介護前払特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(101, 102), "1", "（契約保全）保険料円入金特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(102, 113), "00000456700", "（契約保全）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(113, 122), "764123598", "（契約保全）新契約時申込番号");
        exStringEquals(bzKyknaiyouHanei.substring(122, 123), " ", "（契約保全）法定貯蓄性有表示");
        exStringEquals(bzKyknaiyouHanei.substring(123, 124), " ", "（契約保全）成立時取引時確認区分");
        exStringEquals(bzKyknaiyouHanei.substring(124, 125), " ", "（契約保全）払込経路");

        exStringEquals(bzKyknaiyouHanei.substring(125, 127), "Sk", "（新契約）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(127, 135), "20160311", "（新契約）申込日");
        exStringEquals(bzKyknaiyouHanei.substring(135, 143), "20160411", "（新契約）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(143, 151), "20160511", "（新契約）責任開始日");
        exStringEquals(bzKyknaiyouHanei.substring(151, 152), " ", "（新契約）成立区分");
        exStringEquals(bzKyknaiyouHanei.substring(152, 160), "20160416", "（新契約）成立処理日");
        exStringEquals(bzKyknaiyouHanei.substring(160, 161), "1", "（新契約）ＭＦ連動済フラグ");
        exStringEquals(bzKyknaiyouHanei.substring(161, 172), "10000000003", "（新契約）証券番号");
        exStringEquals(bzKyknaiyouHanei.substring(172, 175), "   ", "（新契約）通算用通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(175, 186), "00000087600", "（新契約）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(186, 197), "00000012300", "（新契約）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(197, 208), "00000123300", "（新契約）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(208, 210), "10", "（新契約）払込期間");
        exStringEquals(bzKyknaiyouHanei.substring(210, 212), "  ", "（新契約）選択方法区分");
        exStringEquals(bzKyknaiyouHanei.substring(212, 218), "201604", "（新契約）募集年月");
        exStringEquals(bzKyknaiyouHanei.substring(218, 219), "1", "（新契約）契約者被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(219, 220), " ", "（新契約）申込消滅区分");
        exStringEquals(bzKyknaiyouHanei.substring(220, 222), "21", "（新契約）商品世代番号");
        exStringEquals(bzKyknaiyouHanei.substring(222, 223), "1", "（新契約）介護前払特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(223, 224), "0", "（新契約）保険料円入金特約有表示");
        exStringEquals(bzKyknaiyouHanei.substring(224, 235), "00000123500", "（新契約）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(235, 236), " ", "（新契約）払込経路");

        exStringEquals(bzKyknaiyouHanei.substring(236, 238), "Nk", "（年金支払）商品コード");
        exStringEquals(bzKyknaiyouHanei.substring(238, 246), "20160412", "（年金支払）年金支払開始日");
        exStringEquals(bzKyknaiyouHanei.substring(246, 254), "20160512", "（年金支払）契約日");
        exStringEquals(bzKyknaiyouHanei.substring(254, 256), "  ", "（年金支払）年金消滅コード");
        exStringEquals(bzKyknaiyouHanei.substring(256, 264), "20160312", "（年金支払）消滅日");
        exStringEquals(bzKyknaiyouHanei.substring(264, 267), "   ", "（年金支払）支払通貨種類");
        exStringEquals(bzKyknaiyouHanei.substring(267, 269), "21", "（年金支払）定額年金年金種類");
        exStringEquals(bzKyknaiyouHanei.substring(269, 280), "00000076500", "（年金支払）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(280, 281), "1", "（年金支払）年金受取人被保険者同一表示");
        exStringEquals(bzKyknaiyouHanei.substring(281, 283), "31", "（年金支払）商品世代番号");

        exStringEquals(bzKyknaiyouHanei.substring(283, 301), "ﾋﾎｹﾝｼｬ            ", "被保険者名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(301, 316), "被保険者名　　　　　　　　　　", "被保険者名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(316, 324), "19881206", "被保険者生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(324, 325), " ", "被保険者性別");
        exStringEquals(bzKyknaiyouHanei.substring(325, 332), "4354001", "被保険者郵便番号");
        exStringEquals(bzKyknaiyouHanei.substring(332, 394),
            "住所１２３４５６７８住所２２３４５６７８住所３２３４５６７８　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　", "被保険者住所");
        exStringEquals(bzKyknaiyouHanei.substring(394, 408), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(bzKyknaiyouHanei.substring(408, 411), "004", "被保険者職業コード");
        exStringEquals(bzKyknaiyouHanei.substring(411, 429), "ｹｲﾔｸｼｬ            ", "契約者名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(429, 444), "佐佐木　　　　　　　　　　　　", "契約者名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(444, 452), "19900406", "契約者生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(452, 470), "ﾈﾝｷﾝ              ", "年金受取人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(470, 485), "年金受取人　　　　　　　　　　", "年金受取人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(485, 493), "19881112", "年金受取人生年月日");
        exStringEquals(bzKyknaiyouHanei.substring(493, 500), "4354112", "通信先郵便番号");
        exStringEquals(bzKyknaiyouHanei.substring(500, 562),
            "通信先住所１２３４５通信先住所２２３４５通信先住所３２３４５　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　", "通信先住所");
        exStringEquals(bzKyknaiyouHanei.substring(562, 576), "0200-0714-6642", "通信先電話番号");
        exStringEquals(bzKyknaiyouHanei.substring(576, 594), "ｼﾎﾞｳｲﾁ            ", "死亡受取人名（カナ）１");
        exStringEquals(bzKyknaiyouHanei.substring(594, 609), "死亡受取人１　　　　　　　　　", "死亡受取人名（漢字）１");
        exStringEquals(bzKyknaiyouHanei.substring(609, 627), "ｼﾎﾞｳﾆ             ", "死亡受取人名（カナ）２");
        exStringEquals(bzKyknaiyouHanei.substring(627, 642), "死亡受取人２　　　　　　　　　", "死亡受取人名（漢字）２");
        exStringEquals(bzKyknaiyouHanei.substring(642, 660), "ｼﾎﾞｳｻﾝ            ", "死亡受取人名（カナ）３");
        exStringEquals(bzKyknaiyouHanei.substring(660, 675), "死亡受取人３　　　　　　　　　", "死亡受取人名（漢字）３");
        exStringEquals(bzKyknaiyouHanei.substring(675, 693), "ｼﾎﾞｳﾖ             ", "死亡受取人名（カナ）４");
        exStringEquals(bzKyknaiyouHanei.substring(693, 708), "死亡受取人４　　　　　　　　　", "死亡受取人名（漢字）４");
        exStringEquals(bzKyknaiyouHanei.substring(708, 726), "ｼﾃｲﾀﾞｲﾘ           ", "指定代理請求人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(726, 741), "指定代理　　　　　　　　　　　", "指定代理請求人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(741, 759), "ｳｹｵｲｷﾞｮ           ", "契約者代理人名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(759, 774), "契約者代理　　　　　　　　　　", "契約者代理人名（漢字）");
        exStringEquals(bzKyknaiyouHanei.substring(774, 792), "ｶｿﾞｸﾀﾞｲ           ", "家族登録名（カナ）１");
        exStringEquals(bzKyknaiyouHanei.substring(792, 807), "家族登録名１　　　　　　　　　", "家族登録名（漢字）１");
        exStringEquals(bzKyknaiyouHanei.substring(807, 825), "ｶｿﾞｸﾀﾞﾆ           ", "家族登録名（カナ）２");
        exStringEquals(bzKyknaiyouHanei.substring(825, 840), "家族登録名２　　　　　　　　　", "家族登録名（漢字）２");
        exStringEquals(bzKyknaiyouHanei.substring(840, 844), "    ", "銀行コード");
        exStringEquals(bzKyknaiyouHanei.substring(844, 847), "   ", "支店コード");
        exStringEquals(bzKyknaiyouHanei.substring(847, 848), " ", "預金種目区分");
        exStringEquals(bzKyknaiyouHanei.substring(848, 855), "       ", "口座番号");
        exStringEquals(bzKyknaiyouHanei.substring(855, 885), "                              ", "口座名義人氏名（カナ）");
        exStringEquals(bzKyknaiyouHanei.substring(885, 886), " ", "口座名義契約者同一人区分");
        exStringEquals(bzKyknaiyouHanei.substring(886, 893), "DLCode1", "代理店コード１");
        exStringEquals(bzKyknaiyouHanei.substring(893, 896), "101", "分担割合１");
        exStringEquals(bzKyknaiyouHanei.substring(896, 903), "DLCode2", "代理店コード２");
        exStringEquals(bzKyknaiyouHanei.substring(903, 906), "202", "分担割合２");
        exStringEquals(bzKyknaiyouHanei.substring(906, 913), "Kanri01", "管理組織コード１");
        exStringEquals(bzKyknaiyouHanei.substring(913, 920), "Kanri02", "管理組織コード２");
        exStringEquals(bzKyknaiyouHanei.substring(920), "000000000000000190", "要求通番");

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getAcserrcd(), "5434", "ACS基盤エラーコード");
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIERROR, "契約内容反映エラー区分");
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000060");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000060", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "5434", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIERROR,
            "契約内容反映エラー区分");
    }
}
