package yuyu.common.sinkeiyaku.skcommon;

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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約当日異動内容編集クラスのメソッド {@link SkToujituIdounaiyouEdit#setSkIdounaiyouBefore(HT_SyoriCTL)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkToujituIdounaiyouEditTest_setSkIdounaiyouBefore{

    @Inject
    private SkToujituIdounaiyouEdit skToujituIdounaiyouEdit;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約当日異動内容編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkToujituIdounaiyouEditTest_setSkIdounaiyouBefore.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testSetSkIdounaiyouBefore_A1() {

        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(null);

        assertNull(skIdounaiyouBeforeBean);
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testSetSkIdounaiyouBefore_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        exStringEquals(skIdounaiyouBeforeBean.getSyoriCTL().getMosno(), "791112220", "申込番号");
        exClassificationEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exDateEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSrsyoriymd(), BizDate.valueOf("20160401"), "成立処理日");
        exClassificationEquals(skIdounaiyouBeforeBean.getSyoriCTL().getMfrenflg(), C_Mfrenflg.SUMI, "MF連動済フラグ");
        exStringEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSyono(), "11807111118", "証券番号");

        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getMosymd(), null, "申込日");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getKykymd(), null, "契約日");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getSknnkaisiymd(), null, "責任開始日");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKyktuukasyu(), null, "契約通貨種類");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getSntkhoukbn(), null, "選択方法区分");
        exDateYMEquals(skIdounaiyouBeforeBean.getMosKihon().getBosyuuym(), null, "募集年月");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKykkbn(), null, "契約者区分");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getYennykntkhkkbn(), null, "円入金特約付加区分");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknnmkn(), null, "被保険者名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknnmkj(), null, "被保険者名（漢字）");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknseiymd(), null, "被保険者生年月日");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknsei(), null, "被保険者性別");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknyno(), null, "被保険者郵便番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr1kj(), null, "被保険者住所１（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr2kj(), null, "被保険者住所２（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr3kj(), null, "被保険者住所３（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhkntelno(), null, "被保険者電話番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknsykgycd(), null, "被保険者職業コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getKyknmkn(), null, "契約者名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getKyknmkj(), null, "契約者名（漢字）");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getKykseiymd(), null, "契約者生年月日");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinyno(), null, "通信先郵便番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr1kj(), null, "通信先住所１（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr2kj(), null, "通信先住所２（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr3kj(), null, "通信先住所３（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsintelno(), null, "通信先電話番号");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getJyudkaigomehrtkhkkbn(), null, "重度介護前払特約付加区分");

        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnSibouS(), null, "通算用死亡Ｓ");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getItijiP(), null, "通算用一時払Ｐ");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnyouNkGns(), null, "通算用年金原資");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnyEnNyknkGk(), null, "通算用円入金額");

        exStringEquals(skIdounaiyouBeforeBean.getMosSyouhn().getSyouhncd(), null, "商品コード");
        assertNull(skIdounaiyouBeforeBean.getMosSyouhn().getSyouhnsdno());
        assertNull(skIdounaiyouBeforeBean.getMosSyouhn().getHrkkkn());

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin1().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin1().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin2().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin2().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin3().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin3().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin4().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin4().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getStDrSkUketorinin1().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getStDrSkUketorinin1().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getDrtencd(), null, "代理店コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getTratkiagcd(), null, "取扱代理店コード");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getMosDairiten1().getBunwari(), null, "分担割合");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getDrtenkanrisosikicd(), null, "代理店管理組織コード");

        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getDrtencd(), null, "代理店コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getTratkiagcd(), null, "取扱代理店コード");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getMosDairiten2().getBunwari(), null, "分担割合");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getDrtenkanrisosikicd(), null, "代理店管理組織コード");

        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk1().getTrkkzknmkn(), null, "登録家族名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk1().getTrkkzknmkj(), null, "登録家族名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk2().getTrkkzknmkn(), null, "登録家族名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk2().getTrkkzknmkj(), null, "登録家族名（漢字）");

        exNumericEquals(skIdounaiyouBeforeBean.getSbUktNin(), 0, "死亡受取人人数");

        exNumericEquals(skIdounaiyouBeforeBean.getStDrSkNin(), 0, "指定代理請求人人数");

        exNumericEquals(skIdounaiyouBeforeBean.getMosDrt(), 0, "申込代理店数");

        exNumericEquals(skIdounaiyouBeforeBean.getMosTrkKzkNin(), 0, "申込登録家族人数");

        exClassificationEquals(skIdounaiyouBeforeBean.getTsnyTuukasyu(), C_Tuukasyu.BLNK, "通算用通貨種類");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testSetSkIdounaiyouBefore_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        exStringEquals(skIdounaiyouBeforeBean.getSyoriCTL().getMosno(), "791112238", "申込番号");
        exClassificationEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exDateEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSrsyoriymd(), BizDate.valueOf("20160401"), "成立処理日");
        exClassificationEquals(skIdounaiyouBeforeBean.getSyoriCTL().getMfrenflg(), C_Mfrenflg.SUMI, "MF連動済フラグ");
        exStringEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSyono(), "11807111118", "証券番号");

        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getMosymd(), BizDate.valueOf("20160402"), "申込日");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getKykymd(), BizDate.valueOf("20160403"), "契約日");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getSknnkaisiymd(), BizDate.valueOf("20160404"), "責任開始日");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getSntkhoukbn(), C_SntkhouKbn.HJY, "選択方法区分");
        exDateYMEquals(skIdounaiyouBeforeBean.getMosKihon().getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKykkbn(), C_KykKbn.KEIHI_BETU, "契約者区分");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getYennykntkhkkbn(), C_Tkhukaumu.HUKA, "円入金特約付加区分");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknnmkn(), "カナ", "被保険者名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknnmkj(), "漢字", "被保険者名（漢字）");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknseiymd(), BizDate.valueOf("20160405"), "被保険者生年月日");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknyno(), "1234567", "被保険者郵便番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr1kj(), "被保険者住所１", "被保険者住所１（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr2kj(), "被保険者住所２", "被保険者住所２（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr3kj(), "被保険者住所３", "被保険者住所３（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhkntelno(), "023-4560-7890", "被保険者電話番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getKyknmkn(), "カナカナ", "契約者名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getKyknmkj(), "漢字漢字", "契約者名（漢字）");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getKykseiymd(), BizDate.valueOf("20160406"), "契約者生年月日");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinyno(), "7654321", "通信先郵便番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsintelno(), "087-6540-3210", "通信先電話番号");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getJyudkaigomehrtkhkkbn(), C_Tkhukaumu.HUKA, "重度介護前払特約付加区分");

        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnSibouS(), BizCurrency.valueOf(1660), "通算用死亡Ｓ");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getItijiP(), BizCurrency.valueOf(500), "通算用一時払Ｐ");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnyouNkGns(), BizCurrency.valueOf(1000), "通算用年金原資");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnyEnNyknkGk(), BizCurrency.valueOf(0), "通算用円入金額");

        exStringEquals(skIdounaiyouBeforeBean.getMosSyouhn().getSyouhncd(), "ﾕｾ", "商品コード");
        exNumericEquals(skIdounaiyouBeforeBean.getMosSyouhn().getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(skIdounaiyouBeforeBean.getMosSyouhn().getHrkkkn(), 1, "払込期間");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin1().getUktnmkn(), "カナナ", "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin1().getUktnmkj(), "漢字字", "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin2().getUktnmkn(), "カナナナ", "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin2().getUktnmkj(), "漢字字字", "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin3().getUktnmkn(), "カナナナナ", "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin3().getUktnmkj(), "漢字字字字", "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin4().getUktnmkn(), "カナナナナナ", "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin4().getUktnmkj(), "漢字字字字字", "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getStDrSkUketorinin1().getUktnmkn(), "カナナナナナナ", "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getStDrSkUketorinin1().getUktnmkj(), "漢字字字字字字", "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getDrtencd(), null, "代理店コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getTratkiagcd(), "T001", "取扱代理店コード");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getMosDairiten1().getBunwari(), BizNumber.valueOf(1), "分担割合");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getDrtenkanrisosikicd(), "DK01", "代理店管理組織コード");

        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getDrtencd(), null, "代理店コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getTratkiagcd(), "T002", "取扱代理店コード");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getMosDairiten2().getBunwari(), BizNumber.valueOf(1), "分担割合");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getDrtenkanrisosikicd(), "DK02", "代理店管理組織コード");

        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk1().getTrkkzknmkn(), "カナカナカナ１", "登録家族名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk1().getTrkkzknmkj(), "漢字漢字漢字１", "登録家族名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk2().getTrkkzknmkn(), "カナカナカナ２", "登録家族名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk2().getTrkkzknmkj(), "漢字漢字漢字２", "登録家族名（漢字）");

        exNumericEquals(skIdounaiyouBeforeBean.getSbUktNin(), 4, "死亡受取人人数");

        exNumericEquals(skIdounaiyouBeforeBean.getStDrSkNin(),1, "指定代理請求人人数");

        exNumericEquals(skIdounaiyouBeforeBean.getMosTrkKzkNin(), 2, "申込登録家族人数");

        exNumericEquals(skIdounaiyouBeforeBean.getMosDrt(), 2, "申込代理店数");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testSetSkIdounaiyouBefore_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        exStringEquals(skIdounaiyouBeforeBean.getSyoriCTL().getMosno(), "791112246", "申込番号");
        exClassificationEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exDateEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSrsyoriymd(), BizDate.valueOf("20160401"), "成立処理日");
        exClassificationEquals(skIdounaiyouBeforeBean.getSyoriCTL().getMfrenflg(), C_Mfrenflg.SUMI, "MF連動済フラグ");
        exStringEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSyono(), "11807111118", "証券番号");

        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getMosymd(), BizDate.valueOf("20160402"), "申込日");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getKykymd(), BizDate.valueOf("20160403"), "契約日");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getSknnkaisiymd(), BizDate.valueOf("20160404"), "責任開始日");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getSntkhoukbn(), C_SntkhouKbn.HJY, "選択方法区分");
        exDateYMEquals(skIdounaiyouBeforeBean.getMosKihon().getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKykkbn(), C_KykKbn.KEIHI_BETU, "契約者区分");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getYennykntkhkkbn(), C_Tkhukaumu.HUKA, "円入金特約付加区分");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknnmkn(), "カナ", "被保険者名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknnmkj(), "漢字", "被保険者名（漢字）");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknseiymd(), BizDate.valueOf("20160405"), "被保険者生年月日");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknyno(), "1234567", "被保険者郵便番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr1kj(), "被保険者住所１", "被保険者住所１（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr2kj(), "被保険者住所２", "被保険者住所２（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr3kj(), "被保険者住所３", "被保険者住所３（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhkntelno(), "023-4560-7890", "被保険者電話番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getKyknmkn(), "カナカナ", "契約者名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getKyknmkj(), "漢字漢字", "契約者名（漢字）");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getKykseiymd(), BizDate.valueOf("20160406"), "契約者生年月日");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinyno(), "7654321", "通信先郵便番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsintelno(), "087-6540-3210", "通信先電話番号");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getJyudkaigomehrtkhkkbn(), C_Tkhukaumu.HUKA, "重度介護前払特約付加区分");

        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnSibouS(), BizCurrency.valueOf(0), "通算用死亡Ｓ");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getItijiP(), BizCurrency.valueOf(0), "通算用一時払Ｐ");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnyouNkGns(), BizCurrency.valueOf(0), "通算用年金原資");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnyEnNyknkGk(), BizCurrency.valueOf(0), "通算用円入金額");

        exStringEquals(skIdounaiyouBeforeBean.getMosSyouhn().getSyouhncd(), "ｲ1", "商品コード");
        exNumericEquals(skIdounaiyouBeforeBean.getMosSyouhn().getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(skIdounaiyouBeforeBean.getMosSyouhn().getHrkkkn(), 1, "払込期間");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin1().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin1().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin2().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin2().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin3().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin3().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin4().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin4().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getStDrSkUketorinin1().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getStDrSkUketorinin1().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getDrtencd(), null, "代理店コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getTratkiagcd(), null, "取扱代理店コード");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getMosDairiten1().getBunwari(), null, "分担割合");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getDrtenkanrisosikicd(), null, "代理店管理組織コード");

        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getDrtencd(), null, "代理店コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getTratkiagcd(), null, "取扱代理店コード");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getMosDairiten2().getBunwari(), null, "分担割合");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getDrtenkanrisosikicd(), null, "代理店管理組織コード");

        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk1().getTrkkzknmkn(), null, "登録家族名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk1().getTrkkzknmkj(), null, "登録家族名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk2().getTrkkzknmkn(), null, "登録家族名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk2().getTrkkzknmkj(), null, "登録家族名（漢字）");

        exNumericEquals(skIdounaiyouBeforeBean.getSbUktNin(), 0, "死亡受取人人数");

        exNumericEquals(skIdounaiyouBeforeBean.getStDrSkNin(), 0, "指定代理請求人人数");

        exNumericEquals(skIdounaiyouBeforeBean.getMosTrkKzkNin(), 0, "申込登録家族人数");

        exNumericEquals(skIdounaiyouBeforeBean.getMosDrt(), 0, "申込代理店数");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testSetSkIdounaiyouBefore_A5() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        exStringEquals(skIdounaiyouBeforeBean.getSyoriCTL().getMosno(), "791112253", "申込番号");
        exClassificationEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exDateEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSrsyoriymd(), BizDate.valueOf("20160401"), "成立処理日");
        exClassificationEquals(skIdounaiyouBeforeBean.getSyoriCTL().getMfrenflg(), C_Mfrenflg.SUMI, "MF連動済フラグ");
        exStringEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSyono(), "11807111118", "証券番号");

        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getMosymd(), BizDate.valueOf("20160402"), "申込日");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getKykymd(), BizDate.valueOf("20160403"), "契約日");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getSknnkaisiymd(), BizDate.valueOf("20160404"), "責任開始日");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getSntkhoukbn(), C_SntkhouKbn.HJY, "選択方法区分");
        exDateYMEquals(skIdounaiyouBeforeBean.getMosKihon().getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKykkbn(), C_KykKbn.KEIHI_BETU, "契約者区分");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getYennykntkhkkbn(), C_Tkhukaumu.HUKA, "円入金特約付加区分");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknnmkn(), "カナ", "被保険者名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknnmkj(), "漢字", "被保険者名（漢字）");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknseiymd(), BizDate.valueOf("20160405"), "被保険者生年月日");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknyno(), "1234567", "被保険者郵便番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr1kj(), "被保険者住所１", "被保険者住所１（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr2kj(), "被保険者住所２", "被保険者住所２（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr3kj(), "被保険者住所３", "被保険者住所３（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhkntelno(), "023-4560-7890", "被保険者電話番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getKyknmkn(), "カナカナ", "契約者名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getKyknmkj(), "漢字漢字", "契約者名（漢字）");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getKykseiymd(), BizDate.valueOf("20160406"), "契約者生年月日");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinyno(), "7654321", "通信先郵便番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsintelno(), "087-6540-3210", "通信先電話番号");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getJyudkaigomehrtkhkkbn(), C_Tkhukaumu.HUKA, "重度介護前払特約付加区分");

        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnSibouS(), BizCurrency.valueOf(0), "通算用死亡Ｓ");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getItijiP(), BizCurrency.valueOf(0), "通算用一時払Ｐ");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnyouNkGns(), BizCurrency.valueOf(0), "通算用年金原資");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnyEnNyknkGk(), BizCurrency.valueOf(0), "通算用円入金額");

        exStringEquals(skIdounaiyouBeforeBean.getMosSyouhn().getSyouhncd(), "ｳ1", "商品コード");
        exNumericEquals(skIdounaiyouBeforeBean.getMosSyouhn().getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(skIdounaiyouBeforeBean.getMosSyouhn().getHrkkkn(), 1, "払込期間");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin1().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin1().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin2().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin2().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin3().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin3().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin4().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin4().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getStDrSkUketorinin1().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getStDrSkUketorinin1().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getDrtencd(), null, "代理店コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getTratkiagcd(), null, "取扱代理店コード");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getMosDairiten1().getBunwari(), null, "分担割合");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getDrtenkanrisosikicd(), null, "代理店管理組織コード");

        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getDrtencd(), null, "代理店コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getTratkiagcd(), null, "取扱代理店コード");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getMosDairiten2().getBunwari(), null, "分担割合");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getDrtenkanrisosikicd(), null, "代理店管理組織コード");

        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk1().getTrkkzknmkn(), null, "登録家族名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk1().getTrkkzknmkj(), null, "登録家族名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk2().getTrkkzknmkn(), null, "登録家族名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk2().getTrkkzknmkj(), null, "登録家族名（漢字）");

        exNumericEquals(skIdounaiyouBeforeBean.getSbUktNin(), 0, "死亡受取人人数");

        exNumericEquals(skIdounaiyouBeforeBean.getStDrSkNin(), 0, "指定代理請求人人数");

        exNumericEquals(skIdounaiyouBeforeBean.getMosTrkKzkNin(), 0, "申込登録家族人数");

        exNumericEquals(skIdounaiyouBeforeBean.getMosDrt(), 0, "申込代理店数");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testSetSkIdounaiyouBefore_A6() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        exStringEquals(skIdounaiyouBeforeBean.getSyoriCTL().getMosno(), "791112261", "申込番号");
        exClassificationEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exDateEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSrsyoriymd(), BizDate.valueOf("20160401"), "成立処理日");
        exClassificationEquals(skIdounaiyouBeforeBean.getSyoriCTL().getMfrenflg(), C_Mfrenflg.SUMI, "MF連動済フラグ");
        exStringEquals(skIdounaiyouBeforeBean.getSyoriCTL().getSyono(), "11807111118", "証券番号");

        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getMosymd(), BizDate.valueOf("20160402"), "申込日");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getKykymd(), BizDate.valueOf("20160403"), "契約日");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getSknnkaisiymd(), BizDate.valueOf("20160404"), "責任開始日");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getSntkhoukbn(), C_SntkhouKbn.HJY, "選択方法区分");
        exDateYMEquals(skIdounaiyouBeforeBean.getMosKihon().getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKykkbn(), C_KykKbn.KEIHI_BETU, "契約者区分");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getYennykntkhkkbn(), C_Tkhukaumu.HUKA, "円入金特約付加区分");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknnmkn(), "カナ", "被保険者名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknnmkj(), "漢字", "被保険者名（漢字）");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknseiymd(), BizDate.valueOf("20160405"), "被保険者生年月日");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknyno(), "1234567", "被保険者郵便番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr1kj(), "被保険者住所１", "被保険者住所１（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr2kj(), "被保険者住所２", "被保険者住所２（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknadr3kj(), "被保険者住所３", "被保険者住所３（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhkntelno(), "023-4560-7890", "被保険者電話番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getKyknmkn(), "カナカナ", "契約者名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getKyknmkj(), "漢字漢字", "契約者名（漢字）");
        exDateEquals(skIdounaiyouBeforeBean.getMosKihon().getKykseiymd(), BizDate.valueOf("20160406"), "契約者生年月日");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinyno(), "7654321", "通信先郵便番号");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(skIdounaiyouBeforeBean.getMosKihon().getTsintelno(), "087-6540-3210", "通信先電話番号");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getJyudkaigomehrtkhkkbn(), C_Tkhukaumu.HUKA, "重度介護前払特約付加区分");

        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnSibouS(), BizCurrency.valueOf(0), "通算用死亡Ｓ");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getItijiP(), BizCurrency.valueOf(0), "通算用一時払Ｐ");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnyouNkGns(), BizCurrency.valueOf(0), "通算用年金原資");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnyEnNyknkGk(), BizCurrency.valueOf(0), "通算用円入金額");

        exStringEquals(skIdounaiyouBeforeBean.getMosSyouhn().getSyouhncd(), "ｳ1", "商品コード");
        exNumericEquals(skIdounaiyouBeforeBean.getMosSyouhn().getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(skIdounaiyouBeforeBean.getMosSyouhn().getHrkkkn(), 1, "払込期間");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin1().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin1().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin2().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin2().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin3().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin3().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin4().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getSbUketorinin4().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getStDrSkUketorinin1().getUktnmkn(), null, "受取人名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getStDrSkUketorinin1().getUktnmkj(), null, "受取人名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getDrtencd(), null, "代理店コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getTratkiagcd(), null, "取扱代理店コード");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getMosDairiten1().getBunwari(), null, "分担割合");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten1().getDrtenkanrisosikicd(), null, "代理店管理組織コード");

        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getDrtencd(), null, "代理店コード");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getTratkiagcd(), null, "取扱代理店コード");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getMosDairiten2().getBunwari(), null, "分担割合");
        exStringEquals(skIdounaiyouBeforeBean.getMosDairiten2().getDrtenkanrisosikicd(), null, "代理店管理組織コード");

        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk1().getTrkkzknmkn(), null, "登録家族名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk1().getTrkkzknmkj(), null, "登録家族名（漢字）");

        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk2().getTrkkzknmkn(), null, "登録家族名（カナ）");
        exStringEquals(skIdounaiyouBeforeBean.getMosTrkKzk2().getTrkkzknmkj(), null, "登録家族名（漢字）");

        exNumericEquals(skIdounaiyouBeforeBean.getSbUktNin(), 0, "死亡受取人人数");

        exNumericEquals(skIdounaiyouBeforeBean.getStDrSkNin(), 0, "指定代理請求人人数");

        exNumericEquals(skIdounaiyouBeforeBean.getMosTrkKzkNin(), 0, "申込登録家族人数");

        exNumericEquals(skIdounaiyouBeforeBean.getMosDrt(), 0, "申込代理店数");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(70)
    public void testSetSkIdounaiyouBefore_A7() {
        try {

            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");
            skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：791112279", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testSetSkIdounaiyouBefore_A8() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");

        exBooleanEquals((skIdounaiyouBeforeBean.getKouzaJyouhou() == null), true, "口座情報テーブルエンティティ");

        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnSibouS(), BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR),
            "通算用死亡Ｓ");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getItijiP(), BizCurrency.valueOf(2.1, BizCurrencyTypes.DOLLAR),
            "通算用一時払Ｐ");
        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnyouNkGns(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR),
            "通算用年金原資");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testSetSkIdounaiyouBefore_A9() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112295");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKyktuukasyu(), C_Tuukasyu.EUR, "契約通貨種類");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getHrkkeiro(), C_Hrkkeiro.DANTAI, "払込経路");

        exClassificationEquals(skIdounaiyouBeforeBean.getTsnyTuukasyu(), C_Tuukasyu.EUR, "通算用通貨種類");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testSetSkIdounaiyouBefore_A10() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112303");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKyktuukasyu(), C_Tuukasyu.AUD, "契約通貨種類");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");

        exClassificationEquals(skIdounaiyouBeforeBean.getTsnyTuukasyu(), C_Tuukasyu.JPY, "通算用通貨種類");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testSetSkIdounaiyouBefore_A11() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112311");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKyktuukasyu(), C_Tuukasyu.AUD, "契約通貨種類");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");

        exStringEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getBankcd(), "1001", "銀行番号");
        exStringEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getSitencd(), "101", "支店番号");
        exClassificationEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getKouzano(), "123451000010", "口座番号");
        exStringEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getKzmeiginmkn(), "ヒホケンメイカナ１", "口座名義人氏名（カナ）");
        exClassificationEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getKzkykdoukbn(), C_KzkykdouKbn.DOUITU,
            "口座名義契約者同一区分");

        exClassificationEquals(skIdounaiyouBeforeBean.getTsnyTuukasyu(), C_Tuukasyu.JPY, "通算用通貨種類");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testSetSkIdounaiyouBefore_A12() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112329");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKyktuukasyu(), C_Tuukasyu.AUD, "契約通貨種類");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");

        exStringEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getBankcd(), "1002", "銀行番号");
        exStringEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getSitencd(), "102", "支店番号");
        exClassificationEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getYokinkbn(), C_YokinKbn.TOUZA, "預金種目区分");
        exStringEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getKouzano(), "123451000011", "口座番号");
        exStringEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getKzmeiginmkn(), "ケイヤクメイカナ１", "口座名義人氏名（カナ）");
        exClassificationEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getKzkykdoukbn(), C_KzkykdouKbn.DOUITU,
            "口座名義契約者同一区分");

        exClassificationEquals(skIdounaiyouBeforeBean.getTsnyTuukasyu(), C_Tuukasyu.JPY, "通算用通貨種類");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testSetSkIdounaiyouBefore_A13() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112337");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getKyktuukasyu(), C_Tuukasyu.AUD, "契約通貨種類");
        exClassificationEquals(skIdounaiyouBeforeBean.getMosKihon().getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");

        exStringEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getBankcd(), "1003", "銀行番号");
        exStringEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getSitencd(), "103", "支店番号");
        exClassificationEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getYokinkbn(), C_YokinKbn.TTYOKIN, "預金種目区分");
        exStringEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getKouzano(), "123451000012", "口座番号");
        exStringEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getKzmeiginmkn(), "コウザメイギニンシメイカナ３", "口座名義人氏名（カナ）");
        exClassificationEquals(skIdounaiyouBeforeBean.getKouzaJyouhou().getKzkykdoukbn(), C_KzkykdouKbn.SITEI,
            "口座名義契約者同一区分");

        exClassificationEquals(skIdounaiyouBeforeBean.getTsnyTuukasyu(), C_Tuukasyu.JPY, "通算用通貨種類");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testSetSkIdounaiyouBefore_A14() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnyEnNyknkGk(), BizCurrency.valueOf(500), "通算用円入金額");

    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testSetSkIdounaiyouBefore_A15() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        exBizCalcbleEquals(skIdounaiyouBeforeBean.getTsnyEnNyknkGk(), BizCurrency.valueOf(0), "通算用円入金額");

    }

}
