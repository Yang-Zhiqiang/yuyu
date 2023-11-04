package yuyu.common.hozen.haitou;

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
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.haitou.SetDNnd.DRateBean;
import yuyu.common.hozen.haitou.SetDNnd.DRateSyutokuInfoBean;
import yuyu.common.hozen.haitou.SetDNnd.HaitouKaisuuBean;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * Dレート年度回数設定のメソッド {@link SetDNnd#exec(String, BizDate, BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SetDNndTest_exec {

    @Inject
    private SetDNnd setDNnd;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_Ｄレート年度回数設定";

    private final static String sheetName = "INデータ";

    @Before
    public void before() {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(NaiteiKakuteiRateHantei.class).to(NaiteiKakuteiRateHanteiMockForHozen.class);
                bind(SetHokenNnd.class).to(SetHokenNndMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        NaiteiKakuteiRateHanteiMockForHozen.caller = SetDNndTest_exec.class;
        SetHokenNndMockForHozen.caller = SetDNndTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.caller = SetDNndTest_exec.class;
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = null;
        SetHokenNndMockForHozen.caller = SetDNndTest_exec.class;
        SetHokenNndMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckDSeigouTest_init.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhHaitouKanri());
        hozenDomManager.delete(hozenDomManager.getAllKhTumitateDKanri());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN1;

        String syouhncd = "M210";

        String ryouritusdno = "001";

        BizNumber yoteiriritu = BizNumber.valueOf(0.0145);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.NEN;

        C_Hhknsei hhknsei = C_Hhknsei.MALE;

        int hhknnen = 34;

        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.SAIMANKI;

        int hknkkn = 1;

        int hrkkkn = 15;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        Integer dai1hknkkn = 1;

        BizDate dretokijyunymd = BizDate.valueOf(20171222);

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = BizDate.valueOf(20170201);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2015);

        BizDate calckijyunymd = BizDate.valueOf(20170101);

        BizDate syoriYmd = null;

        C_UmuKbn kessanumu = C_UmuKbn.ARI;

        DRateBean dRateBean = setDNnd.exec(syouhncd, ryouritusdno, yoteiriritu, hrkkaisuu, hhknsei, hhknnen,
            hknkknsmnkbn, hknkkn, hrkkkn, kykjyoutai, hrkkknsmnkbn, tuukasyu, dai1hknkkn, dretokijyunymd,
            kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd, syoriYmd, kessanumu);

        exDateEquals((BizDate) MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 0),
            syoriYmd, "処理年月日");
        exDateYEquals((BizDateY) MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 1),
            BizDateY.valueOf(2017), "Dレート年度");
        exClassificationEquals(
            (C_UmuKbn) MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 2), kessanumu,
            "決算使用有無");

        exBooleanEquals(dRateBean == null, true, "ＤレートBean");

        List<HaitouErrorInfo> haitouErrorInfoList = setDNnd.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), setDNnd.getClass().getSimpleName(), "機能ID");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = null;
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN1;

        String syouhncd = "M210";

        String ryouritusdno = "001";

        BizNumber yoteiriritu = BizNumber.valueOf(0.0145);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.NEN;

        C_Hhknsei hhknsei = C_Hhknsei.MALE;

        int hhknnen = 34;

        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.SAIMANKI;

        int hknkkn = 1;

        int hrkkkn = 15;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        Integer dai1hknkkn = 1;

        BizDate dretokijyunymd = BizDate.valueOf(20171222);

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = BizDate.valueOf(20170201);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2015);

        BizDate calckijyunymd = BizDate.valueOf(20170302);

        BizDate syoriYmd = BizDate.valueOf(20170420);

        C_UmuKbn kessanumu = C_UmuKbn.ARI;

        DRateBean dRateBean = setDNnd.exec(syouhncd, ryouritusdno, yoteiriritu, hrkkaisuu, hhknsei, hhknnen,
            hknkknsmnkbn, hknkkn, hrkkkn, kykjyoutai, hrkkknsmnkbn, tuukasyu, dai1hknkkn, dretokijyunymd,
            kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd, syoriYmd, kessanumu);

        exBooleanEquals(dRateBean == null, true, "ＤレートBean");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;

        String syouhncd = "M210";

        String ryouritusdno = "001";

        BizNumber yoteiriritu = BizNumber.valueOf(0.0145);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.NEN;

        C_Hhknsei hhknsei = C_Hhknsei.MALE;

        int hhknnen = 1;

        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.SAIMANKI;

        int hknkkn = 1;

        int hrkkkn = 15;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        Integer dai1hknkkn = 1;

        BizDate dretokijyunymd = BizDate.valueOf(20171222);

        BizDate kykymd = BizDate.valueOf(20180201);

        BizDate yendthnkymd = BizDate.valueOf(20160101);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2016);

        BizDate calckijyunymd = BizDate.valueOf(20170301);

        BizDate syoriYmd = BizDate.valueOf(20170420);

        C_UmuKbn kessanumu = C_UmuKbn.ARI;

        DRateBean dRateBean = setDNnd.exec(syouhncd, ryouritusdno, yoteiriritu, hrkkaisuu, hhknsei, hhknnen,
            hknkknsmnkbn, hknkkn, hrkkkn, kykjyoutai, hrkkknsmnkbn, tuukasyu, dai1hknkkn,dretokijyunymd, kykymd,
            yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd, syoriYmd, kessanumu);

        DRateSyutokuInfoBean dRateSyutokuInfoBean = dRateBean.getDRateSyutokuInfoBean();
        exStringEquals(dRateSyutokuInfoBean.getSyouhncd(), "M210", "商品コード");
        exStringEquals(dRateSyutokuInfoBean.getRyouritusdno(), "001", "料率世代番号");
        exBizCalcbleEquals(dRateSyutokuInfoBean.getYoteiriritu(), BizNumber.valueOf(0.0145), "予定利率");
        exClassificationEquals(dRateSyutokuInfoBean.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(dRateSyutokuInfoBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(dRateSyutokuInfoBean.getHhknnen(), 1, "被保険者年齢");
        exClassificationEquals(dRateSyutokuInfoBean.getHknkknsmnkbn(), hknkknsmnkbn, "保険期間歳満期区分");
        exNumericEquals(dRateSyutokuInfoBean.getHknkkn(), 1, "保険期間");
        exNumericEquals(dRateSyutokuInfoBean.getHrkkkn(), 15, "払込期間");
        exClassificationEquals(dRateSyutokuInfoBean.getKykjyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");
        exClassificationEquals(dRateSyutokuInfoBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exNumericEquals(dRateSyutokuInfoBean.getDai1hknkkn(), 1, "第１保険期間");
        exDateYEquals(dRateSyutokuInfoBean.getDratenendo(), BizDateY.valueOf(2017), "Ｄレート年度");
        exClassificationEquals(dRateSyutokuInfoBean.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20170101), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20170201), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20170201), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20170301), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.NEN);

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setSyono("60806000099");
        kykSyouhn.setSyouhncd("M210");
        kykSyouhn.setRyouritusdno("001");
        kykSyouhn.setYoteiriritu(BizNumber.valueOf(0.0145));
        kykSyouhn.setHhknsei(C_Hhknsei.MALE);
        kykSyouhn.setHhknnen(1);
        kykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        kykSyouhn.setHknkkn(1);
        kykSyouhn.setHrkkkn(15);
        kykSyouhn.setKykymd(BizDate.valueOf(20180201));
        kykSyouhn.setYendthnkymd(BizDate.valueOf(20160101));
        kykSyouhn.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        kykSyouhn.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
        kykSyouhn.setDai1hknkkn(1);
        BizDate dretokijyunymd = BizDate.valueOf(20171222);

        BizDate calckijyunymd = BizDate.valueOf(20170301);

        BizDate syoriYmd = BizDate.valueOf(20170420);

        C_UmuKbn kessanumu = C_UmuKbn.ARI;

        DRateBean dRateBean = setDNnd.exec(kykKihon, kykSyouhn, dretokijyunymd, calckijyunymd, syoriYmd, kessanumu);

        DRateSyutokuInfoBean dRateSyutokuInfoBean = dRateBean.getDRateSyutokuInfoBean();
        exStringEquals(dRateSyutokuInfoBean.getSyouhncd(), "M210", "商品コード");
        exStringEquals(dRateSyutokuInfoBean.getRyouritusdno(), "001", "料率世代番号");
        exBizCalcbleEquals(dRateSyutokuInfoBean.getYoteiriritu(), BizNumber.valueOf(0.0145), "予定利率");
        exClassificationEquals(dRateSyutokuInfoBean.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(dRateSyutokuInfoBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(dRateSyutokuInfoBean.getHhknnen(), 1, "被保険者年齢");
        exClassificationEquals(dRateSyutokuInfoBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(dRateSyutokuInfoBean.getHknkkn(), 1, "保険期間");
        exNumericEquals(dRateSyutokuInfoBean.getHrkkkn(), 15, "払込期間");
        exClassificationEquals(dRateSyutokuInfoBean.getKykjyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");
        exClassificationEquals(dRateSyutokuInfoBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exNumericEquals(dRateSyutokuInfoBean.getDai1hknkkn(), 1, "第１保険期間");
        exDateYEquals(dRateSyutokuInfoBean.getDratenendo(), BizDateY.valueOf(2017), "Ｄレート年度");
        exClassificationEquals(dRateSyutokuInfoBean.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20170101), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20170201), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20170201), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20170301), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN1;

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = BizDate.valueOf(20170201);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2015);

        BizDate calckijyunymd = BizDate.valueOf(20170302);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        exBooleanEquals(dRateBean == null, true, "ＤレートBean");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;

        BizDate kykymd = BizDate.valueOf(20180201);

        BizDate yendthnkymd = BizDate.valueOf(20160101);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2016);

        BizDate calckijyunymd = BizDate.valueOf(20170301);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20170101), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20170201), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20170201), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20170301), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2015);

        BizDate calckijyunymd = BizDate.valueOf(20170101);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();

        exNumericEquals(haitouKaisuuBeanList.size(), 0, "配当回数Beanリストの件数");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BizDate kykymd = BizDate.valueOf(20170302);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2016);

        BizDate calckijyunymd = BizDate.valueOf(20170301);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();

        exNumericEquals(haitouKaisuuBeanList.size(), 0, "配当回数Beanリストの件数");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN1;

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = BizDate.valueOf(20170101);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2015);

        BizDate calckijyunymd = BizDate.valueOf(20170501);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        exBooleanEquals(dRateBean == null, true, "ＤレートBean");

        List<HaitouErrorInfo> haitouErrorInfoList = setDNnd.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 1, "エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "期間不正", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "期間（自） > 期間（至） or 期間（至）－ 期間（自）＞ １年", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), setDNnd.getClass().getSimpleName(), "機能ID");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN3;

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = BizDate.valueOf(20160101);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2016);

        BizDate calckijyunymd = BizDate.valueOf(20170201);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        exBooleanEquals(dRateBean == null, true, "ＤレートBean");
        List<HaitouErrorInfo> haitouErrorInfoList = setDNnd.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(SetHokenNndMockForHozen.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), setDNnd.getClass().getSimpleName(), "機能ID");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;

        BizDate kykymd = BizDate.valueOf(20180201);

        BizDate yendthnkymd = BizDate.valueOf(20160101);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2016);

        BizDate calckijyunymd = BizDate.valueOf(20170301);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        exDateEquals((BizDate) MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180201), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(20180201), "判定日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 1, 0),
            BizDate.valueOf(20180201), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 1, 1),
            BizDate.valueOf(20180201), "判定日");
        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20170101), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20170201), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20170201), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20170301), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN4;

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = BizDate.valueOf(20160101);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2016);

        BizDate calckijyunymd = BizDate.valueOf(20170201);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        exBooleanEquals(dRateBean == null, true, "ＤレートBean");
        List<HaitouErrorInfo> haitouErrorInfoList = setDNnd.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(SetHokenNndMockForHozen.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), setDNnd.getClass().getSimpleName(), "機能ID");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN5;

        BizDate kykymd = BizDate.valueOf(20170202);

        BizDate yendthnkymd = BizDate.valueOf(20170302);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2016);

        BizDate calckijyunymd = BizDate.valueOf(20180301);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd,pCalckijyunYmdTyokuzenHaitounendo,  calckijyunymd);

        exDateEquals((BizDate) MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20170202), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(20170202), "判定日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 1, 0),
            BizDate.valueOf(20170202), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 1, 1),
            BizDate.valueOf(20190202), "判定日");
        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20170302), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180202), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 11, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20180202), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20180301), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN6;

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = BizDate.valueOf(20170202);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2017);

        BizDate calckijyunymd = BizDate.valueOf(20180301);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180202), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180301), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN6;

        BizDate kykymd = BizDate.valueOf(20170401);

        BizDate yendthnkymd = BizDate.valueOf(20170202);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2017);

        BizDate calckijyunymd = BizDate.valueOf(20180301);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180202), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180301), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN7;

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = BizDate.valueOf(20170301);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2016);

        BizDate calckijyunymd = BizDate.valueOf(20180301);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20170301), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180301), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN8;

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = BizDate.valueOf(20170201);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = null;

        BizDate calckijyunymd = BizDate.valueOf(20190201);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180201), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180301), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20180301), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20190201), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 11, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN8;

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = BizDate.valueOf(20170201);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2018);

        BizDate calckijyunymd = BizDate.valueOf(20190202);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20190201), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20190202), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN7;

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = BizDate.valueOf(20170301);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2016);

        BizDate calckijyunymd = BizDate.valueOf(20180301);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd,pCalckijyunYmdTyokuzenHaitounendo,  calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20170301), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180301), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN7;

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = BizDate.valueOf(20170301);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2016);

        BizDate calckijyunymd = BizDate.valueOf(20180220);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20170301), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180220), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN8;

        BizDate kykymd = BizDate.valueOf("20170301");

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2017);

        BizDate calckijyunymd = BizDate.valueOf(20180317);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180301), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180317), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN8;

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2017);

        BizDate calckijyunymd = BizDate.valueOf(20180316);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180301), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180316), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN8;

        BizDate kykymd = BizDate.valueOf(20170301);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2017);

        BizDate calckijyunymd = BizDate.valueOf(20180401);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180301), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180401), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN9;

        BizDate kykymd = BizDate.valueOf(20170317);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2017);

        BizDate calckijyunymd = BizDate.valueOf(20180401);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180317), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180401), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN9;

        BizDate kykymd = BizDate.valueOf(20170316);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2017);

        BizDate calckijyunymd = BizDate.valueOf(20180401);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180316), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180401), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN9;

        BizDate kykymd = BizDate.valueOf(20170315);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2017);

        BizDate calckijyunymd = BizDate.valueOf(20180401);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180315), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180401), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20200229);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        BizDate calckijyunymd = BizDate.valueOf(20210228);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200229), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 1, "配当回数");
    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20180401);

        BizDate yendthnkymd = BizDate.valueOf(20200229);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        BizDate calckijyunymd = BizDate.valueOf(20210228);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200229), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20200401), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20200401), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20210228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 11, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20200301);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        BizDate calckijyunymd = BizDate.valueOf(20210301);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo,  calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200301), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210301), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 1, "配当回数");
    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20180401);

        BizDate yendthnkymd = BizDate.valueOf(20200301);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        BizDate calckijyunymd = BizDate.valueOf(20210301);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200301), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20200401), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20200401), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20210301), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 11, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20200229);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        BizDate calckijyunymd = BizDate.valueOf(20210501);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210501), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 2, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");
    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20180401);

        BizDate yendthnkymd = BizDate.valueOf(20200229);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        BizDate calckijyunymd = BizDate.valueOf(20210501);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210401), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20210401), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20210501), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 4, "配当回数");
    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20200301);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        BizDate calckijyunymd = BizDate.valueOf(20210501);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210301), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210501), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 2, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");
    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20180401);

        BizDate yendthnkymd = BizDate.valueOf(20200301);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        BizDate calckijyunymd = BizDate.valueOf(20210501);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210301), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210401), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20210401), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20210501), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 4, "配当回数");
    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20200229);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2022);

        BizDate calckijyunymd = BizDate.valueOf(20240229);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20230228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20240229), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 4, "配当回数");
    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20160229);

        BizDate yendthnkymd = BizDate.valueOf(20200228);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        BizDate calckijyunymd = BizDate.valueOf(20210228);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo,  calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20200229), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 4, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20200229), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20210228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 5, "配当回数");
    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20160229);

        BizDate yendthnkymd = BizDate.valueOf(20200228);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        BizDate calckijyunymd = BizDate.valueOf(20220228);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 6, "配当回数");
    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20160229);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        BizDate calckijyunymd = BizDate.valueOf(20220228);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 6, "配当回数");
    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20160229);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2021);

        BizDate calckijyunymd = BizDate.valueOf(20220228);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20220228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 6, "配当回数");
    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20160229);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        BizDate calckijyunymd = BizDate.valueOf(20220228);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        if (dRateBean != null) {
            fail("期待値結果不一致");
        }
    }

    @Test
    @TestOrder(410)
    public void testExec_A41() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20160229);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2022);

        BizDate calckijyunymd = BizDate.valueOf(20220228);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        if (dRateBean != null) {
            fail("期待値結果不一致");
        }
    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20160229);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        BizDate calckijyunymd = BizDate.valueOf(20220227);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220227), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 6, "配当回数");
    }

    @Test
    @TestOrder(430)
    public void testExec_A43() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20160229);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2021);

        BizDate calckijyunymd = BizDate.valueOf(20220301);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20220228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220301), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 7, "配当回数");
    }

    @Test
    @TestOrder(440)
    public void testExec_A44() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20160229);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        BizDate calckijyunymd = BizDate.valueOf(20220301);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        if (dRateBean != null) {
            fail("期待値結果不一致");
        }
    }

    @Test
    @TestOrder(450)
    public void testExec_A45() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20160229);

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2022);

        BizDate calckijyunymd = BizDate.valueOf(20220228);

        DRateBean dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        if (dRateBean != null) {
            fail("期待値結果不一致");
        }
    }

    @Test
    @TestOrder(460)
    public void testExec_A46() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20180331);

        BizDate yendthnkymd = null;

        String syono = "60806000011";

        BizDate calckijyunymd;

        DRateBean dRateBean;

        List<HaitouKaisuuBean> haitouKaisuuBeanList;

        calckijyunymd = BizDate.valueOf(20190331);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20190331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20190331), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 1, "配当回数");

        calckijyunymd = BizDate.valueOf(20200331);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20200331), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");

        calckijyunymd = BizDate.valueOf(20210331);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210331), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");

        calckijyunymd = BizDate.valueOf(20220331);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20220331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220331), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 4, "配当回数");

        calckijyunymd = BizDate.valueOf(20230331);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20230331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20230331), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 5, "配当回数");
    }

    @Test
    @TestOrder(470)
    public void testExec_A47() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20180331);

        BizDate yendthnkymd = null;

        String syono = "60806000011";

        BizDate calckijyunymd;

        DRateBean dRateBean;

        List<HaitouKaisuuBean> haitouKaisuuBeanList;

        calckijyunymd = BizDate.valueOf(20190401);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20190331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20190401), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");

        calckijyunymd = BizDate.valueOf(20200401);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20200401), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");

        calckijyunymd = BizDate.valueOf(20210401);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210401), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 4, "配当回数");

        calckijyunymd = BizDate.valueOf(20220401);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20220331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220401), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 5, "配当回数");

        calckijyunymd = BizDate.valueOf(20230401);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20230331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20230401), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 6, "配当回数");
    }

    @Test
    @TestOrder(480)
    public void testExec_A48() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20180331);

        BizDate yendthnkymd = null;

        String syono = "60806000011";

        BizDate calckijyunymd;

        DRateBean dRateBean;

        List<HaitouKaisuuBean> haitouKaisuuBeanList;


        calckijyunymd = BizDate.valueOf(20190330);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20190330), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 1, "配当回数");

        calckijyunymd = BizDate.valueOf(20200330);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20190331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20200330), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");

        calckijyunymd = BizDate.valueOf(20210330);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210330), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");

        calckijyunymd = BizDate.valueOf(20220330);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220330), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 4, "配当回数");

        calckijyunymd = BizDate.valueOf(20230330);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20220331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20230330), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 5, "配当回数");

        calckijyunymd = BizDate.valueOf(20240330);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20230331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20240330), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 6, "配当回数");
    }

    @Test
    @TestOrder(490)
    public void testExec_A49() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20180331);

        BizDate yendthnkymd = null;

        String syono = "60806000022";

        BizDate calckijyunymd;

        DRateBean dRateBean;

        List<HaitouKaisuuBean> haitouKaisuuBeanList;


        calckijyunymd = BizDate.valueOf(20190331);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20190331), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 1, "配当回数");
    }

    @Test
    @TestOrder(500)
    public void testExec_A50() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20180331);

        BizDate yendthnkymd = null;

        String syono = "60806000033";

        BizDate calckijyunymd;

        DRateBean dRateBean;


        List<HaitouKaisuuBean> haitouKaisuuBeanList;

        calckijyunymd = BizDate.valueOf(20200331);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20190331), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20200331), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");
    }

    @Test
    @TestOrder(510)
    public void testExec_A51() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20200229);

        BizDate yendthnkymd = BizDate.valueOf(20220228);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo;

        BizDate calckijyunymd;

        DRateBean dRateBean;

        List<HaitouKaisuuBean> haitouKaisuuBeanList;


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        calckijyunymd = BizDate.valueOf(20210228);

        dRateBean = setDNnd.exec(kykymd, null, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200229), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 1, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        calckijyunymd = BizDate.valueOf(20210228);

        dRateBean = setDNnd.exec(kykymd, null, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 1, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        calckijyunymd = BizDate.valueOf(20220228);

        dRateBean = setDNnd.exec(kykymd, null, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2021);

        calckijyunymd = BizDate.valueOf(20220228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20220228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2021);

        calckijyunymd = BizDate.valueOf(20230228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20220228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20230228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2022);

        calckijyunymd = BizDate.valueOf(20230228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20230228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20230228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2022);

        calckijyunymd = BizDate.valueOf(20240228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20230228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20240228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 4, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2023);

        calckijyunymd = BizDate.valueOf(20240228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20240228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20240228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 4, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2023);

        calckijyunymd = BizDate.valueOf(20250228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20240228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20240229), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 4, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20240229), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20250228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 5, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2024);

        calckijyunymd = BizDate.valueOf(20250228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20250228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20250228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 5, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2024);

        calckijyunymd = BizDate.valueOf(20260228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20250228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20260228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 6, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2025);

        calckijyunymd = BizDate.valueOf(20260228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20260228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20260228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 6, "配当回数");
    }

    @Test
    @TestOrder(520)
    public void testExec_A52() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20190228);

        BizDate yendthnkymd = BizDate.valueOf(20200229);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo;

        BizDate calckijyunymd;

        DRateBean dRateBean;

        List<HaitouKaisuuBean> haitouKaisuuBeanList;


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2018);

        calckijyunymd = BizDate.valueOf(20200228);

        dRateBean = setDNnd.exec(kykymd, null, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20190228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20200228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 1, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        calckijyunymd = BizDate.valueOf(20200229);

        dRateBean = setDNnd.exec(kykymd, null, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20200229), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        calckijyunymd = BizDate.valueOf(20210228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200229), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        calckijyunymd = BizDate.valueOf(20220228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2021);

        calckijyunymd = BizDate.valueOf(20230228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20220228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20230228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 4, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2022);

        calckijyunymd = BizDate.valueOf(20240229);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20230228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20240228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 5, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20240228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20240229), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 6, "配当回数");
    }

    @Test
    @TestOrder(530)
    public void testExec_A53() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd;

        BizDate yendthnkymd = null;

        BizDateY pCalckijyunYmdTyokuzenHaitounendo;

        BizDate calckijyunymd;

        DRateBean dRateBean;

        List<HaitouKaisuuBean> haitouKaisuuBeanList;


        kykymd = BizDate.valueOf(20190301);

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        calckijyunymd = BizDate.valueOf(20200315);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200301), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20200315), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");


        kykymd = BizDate.valueOf(20190301);

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        calckijyunymd = BizDate.valueOf(20200316);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200301), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20200316), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");


        kykymd = BizDate.valueOf(20190320);

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        calckijyunymd = BizDate.valueOf(20200404);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200320), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20200404), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");

        kykymd = BizDate.valueOf(20190320);

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        calckijyunymd = BizDate.valueOf(20200405);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200320), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20200405), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");


        kykymd = BizDate.valueOf(20190401);

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        calckijyunymd = BizDate.valueOf(20210315);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200401), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210315), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 11, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");

        kykymd = BizDate.valueOf(20190401);

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        calckijyunymd = BizDate.valueOf(20210316);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200401), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210316), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");


        kykymd = BizDate.valueOf(20190420);

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        calckijyunymd = BizDate.valueOf(20210404);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200420), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210404), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 11, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");


        kykymd = BizDate.valueOf(20190420);

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        calckijyunymd = BizDate.valueOf(20210405);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200420), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210405), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");
    }

    @Test
    @TestOrder(540)
    public void testExec_A54() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20200229);

        BizDate yendthnkymd = BizDate.valueOf(20230213);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo;

        BizDate calckijyunymd;

        DRateBean dRateBean;

        List<HaitouKaisuuBean> haitouKaisuuBeanList;


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        calckijyunymd = BizDate.valueOf(20210228);

        dRateBean = setDNnd.exec(kykymd, null, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200229), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 1, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        calckijyunymd = BizDate.valueOf(20210228);

        dRateBean = setDNnd.exec(kykymd, null, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 1, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        calckijyunymd = BizDate.valueOf(20220228);

        dRateBean = setDNnd.exec(kykymd, null, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2021);

        calckijyunymd = BizDate.valueOf(20230213);

        dRateBean = setDNnd.exec(kykymd, null, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20220228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20230213), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2022);

        calckijyunymd = BizDate.valueOf(20230213);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20230213), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20230213), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2022);

        calckijyunymd = BizDate.valueOf(20240213);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20230213), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20230228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20230228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20240213), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 4, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2023);

        calckijyunymd = BizDate.valueOf(20240213);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20240213), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20240213), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 4, "配当回数");



        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2023);

        calckijyunymd = BizDate.valueOf(20250213);


        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);


        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20240213), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20240229), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 4, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20240229), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20250213), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 5, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2024);

        calckijyunymd = BizDate.valueOf(20260213);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20250213), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20250228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 5, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20250228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20260213), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 6, "配当回数");
    }

    @Test
    @TestOrder(550)
    public void testExec_A55() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20200229);

        BizDate yendthnkymd = BizDate.valueOf(20210313);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo;

        BizDate calckijyunymd;

        DRateBean dRateBean;

        List<HaitouKaisuuBean> haitouKaisuuBeanList;


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        calckijyunymd = BizDate.valueOf(20210228);

        dRateBean = setDNnd.exec(kykymd, null, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200229), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 1, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        calckijyunymd = BizDate.valueOf(20210313);

        dRateBean = setDNnd.exec(kykymd, null, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210313), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        calckijyunymd = BizDate.valueOf(20220313);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210313), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 11, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20220228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20220313), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 3, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2021);

        calckijyunymd = BizDate.valueOf(20230313);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20220313), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20230228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 11, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20230228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20230313), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 4, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2022);

        calckijyunymd = BizDate.valueOf(20240313);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20230313), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20240229), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 11, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 4, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20240229), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20240313), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 5, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2023);

        calckijyunymd = BizDate.valueOf(20250313);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20240313), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20250228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 11, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 5, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20250228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20250313), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 6, "配当回数");
    }

    @Test
    @TestOrder(560)
    public void testExec_A56() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

        BizDate kykymd = BizDate.valueOf(20200228);

        BizDate yendthnkymd = BizDate.valueOf(20220228);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo;

        BizDate calckijyunymd;

        DRateBean dRateBean;

        List<HaitouKaisuuBean> haitouKaisuuBeanList;

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2019);

        calckijyunymd = BizDate.valueOf(20210228);

        dRateBean = setDNnd.exec(kykymd, null, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20200228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 1, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        calckijyunymd = BizDate.valueOf(20210228);

        dRateBean = setDNnd.exec(kykymd, null, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20210228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 1, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2020);

        calckijyunymd = BizDate.valueOf(20220228);

        dRateBean = setDNnd.exec(kykymd, null, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20210228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2021);

        calckijyunymd = BizDate.valueOf(20220228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20220228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20220228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2021);

        calckijyunymd = BizDate.valueOf(20230228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20220228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20230228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2022);

        calckijyunymd = BizDate.valueOf(20230228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20230228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20230228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2022);

        calckijyunymd = BizDate.valueOf(20240228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20230228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20240228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 4, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2023);

        calckijyunymd = BizDate.valueOf(20240228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20240228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20240228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 4, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2023);

        calckijyunymd = BizDate.valueOf(20250228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20240228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20250228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 5, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2024);

        calckijyunymd = BizDate.valueOf(20250228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20250228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20250228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 5, "配当回数");

        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2024);

        calckijyunymd = BizDate.valueOf(20260228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20250228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20260228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 6, "配当回数");


        pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2025);

        calckijyunymd = BizDate.valueOf(20260228);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd);

        haitouKaisuuBeanList= dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20260228), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20260228), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 6, "配当回数");
    }

    @Test
    @TestOrder(570)
    public void testExec_A57() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN  = null;
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN1;

        BizDate kykymd = BizDate.valueOf(20180331);

        BizDate yendthnkymd = null;

        String syono = "60806000011";

        BizDate calckijyunymd;

        DRateBean dRateBean;

        calckijyunymd = BizDate.valueOf(20180331);

        dRateBean = setDNnd.exec(kykymd, yendthnkymd, syono, calckijyunymd);

        if (dRateBean != null) {
            fail("期待値結果不一致");
        }
    }

    @Test
    @TestOrder(580)
    public void testExec_A58() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.NEN);

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setSyono("60806000099");
        kykSyouhn.setSyouhncd("M210");
        kykSyouhn.setRyouritusdno("001");
        kykSyouhn.setYoteiriritu(BizNumber.valueOf(0.0145));
        kykSyouhn.setHhknsei(C_Hhknsei.MALE);
        kykSyouhn.setHhknnen(1);
        kykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        kykSyouhn.setHknkkn(1);
        kykSyouhn.setHrkkkn(15);
        kykSyouhn.setKykymd(BizDate.valueOf(20180201));
        kykSyouhn.setYendthnkymd(BizDate.valueOf(20160101));

        BizDate dretokijyunymd = BizDate.valueOf(20171222);

        BizDate calckijyunymd = null;

        BizDate syoriYmd = BizDate.valueOf(20170420);

        C_UmuKbn kessanumu = C_UmuKbn.ARI;


        DRateBean dRateBean = setDNnd.exec(kykKihon, kykSyouhn, dretokijyunymd, calckijyunymd, syoriYmd, kessanumu);

        exBooleanEquals(dRateBean == null, true, "ＤレートBean");

        List<HaitouErrorInfo> haitouErrorInfoList = setDNnd.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(DBAccessDCommon.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), setDNnd.getClass().getSimpleName(), "機能ID");
    }

    @Test
    @TestOrder(590)
    public void testExec_A59() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.NEN);

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setSyono("60806000099");
        kykSyouhn.setSyouhncd("M210");
        kykSyouhn.setRyouritusdno("001");
        kykSyouhn.setYoteiriritu(BizNumber.valueOf(0.0145));
        kykSyouhn.setHhknsei(C_Hhknsei.MALE);
        kykSyouhn.setHhknnen(1);
        kykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        kykSyouhn.setHknkkn(1);
        kykSyouhn.setHrkkkn(15);
        kykSyouhn.setKykymd(BizDate.valueOf(20180201));
        kykSyouhn.setYendthnkymd(BizDate.valueOf(20160101));

        BizDate dretokijyunymd = BizDate.valueOf(20171222);

        BizDate calckijyunymd = BizDate.valueOf(20160301);

        BizDate syoriYmd = BizDate.valueOf(20170420);

        C_UmuKbn kessanumu = C_UmuKbn.ARI;

        DRateBean dRateBean = setDNnd.exec(kykKihon, kykSyouhn, dretokijyunymd, calckijyunymd, syoriYmd, kessanumu);

        exBooleanEquals(dRateBean == null, true, "ＤレートBean");

        List<HaitouErrorInfo> haitouErrorInfoList = setDNnd.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(SetHokenNndMockForHozen.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), setDNnd.getClass().getSimpleName(), "機能ID");
    }

    @Test
    @TestOrder(600)
    public void testExec_A60() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;

        String syouhncd = "M210";

        String ryouritusdno = "001";

        BizNumber yoteiriritu = BizNumber.valueOf(0.0145);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.NEN;

        C_Hhknsei hhknsei = C_Hhknsei.MALE;

        int hhknnen = 10;

        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.SAIMANKI;

        int hknkkn = 1;

        int hrkkkn = 10;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        Integer dai1hknkkn = 1;

        BizDate dretokijyunymd = BizDate.valueOf(20171222);

        BizDate kykymd = BizDate.valueOf(20180204);

        BizDate yendthnkymd = BizDate.valueOf(20170101);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2017);

        BizDate calckijyunymd = BizDate.valueOf(20180204);

        BizDate syoriYmd = BizDate.valueOf(20170420);

        C_UmuKbn kessanumu = C_UmuKbn.ARI;

        DRateBean dRateBean = setDNnd.exec(syouhncd, ryouritusdno, yoteiriritu, hrkkaisuu, hhknsei, hhknnen,
            hknkknsmnkbn, hknkkn, hrkkkn, kykjyoutai, hrkkknsmnkbn, tuukasyu, dai1hknkkn,dretokijyunymd, kykymd,
            yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd, syoriYmd, kessanumu);

        DRateSyutokuInfoBean dRateSyutokuInfoBean = dRateBean.getDRateSyutokuInfoBean();
        exStringEquals(dRateSyutokuInfoBean.getSyouhncd(), "M210", "商品コード");
        exStringEquals(dRateSyutokuInfoBean.getRyouritusdno(), "001", "料率世代番号");
        exBizCalcbleEquals(dRateSyutokuInfoBean.getYoteiriritu(), BizNumber.valueOf(0.0145), "予定利率");
        exClassificationEquals(dRateSyutokuInfoBean.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(dRateSyutokuInfoBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(dRateSyutokuInfoBean.getHhknnen(), 10, "被保険者年齢");
        exClassificationEquals(dRateSyutokuInfoBean.getHknkknsmnkbn(), hknkknsmnkbn, "保険期間歳満期区分");
        exNumericEquals(dRateSyutokuInfoBean.getHknkkn(), 1, "保険期間");
        exNumericEquals(dRateSyutokuInfoBean.getHrkkkn(), 10, "払込期間");
        exClassificationEquals(dRateSyutokuInfoBean.getKykjyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");
        exClassificationEquals(dRateSyutokuInfoBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exNumericEquals(dRateSyutokuInfoBean.getDai1hknkkn(), 1, "第１保険期間");
        exDateYEquals(dRateSyutokuInfoBean.getDratenendo(), BizDateY.valueOf(2017), "Ｄレート年度");
        exClassificationEquals(dRateSyutokuInfoBean.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180101), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180204), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(610)
    public void testExec_A61() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;

        String syouhncd = "M210";

        String ryouritusdno = "001";

        BizNumber yoteiriritu = BizNumber.valueOf(0.0145);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.NEN;

        C_Hhknsei hhknsei = C_Hhknsei.MALE;

        int hhknnen = 10;

        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.SAIMANKI;

        int hknkkn = 1;

        int hrkkkn = 10;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ZENNOU;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        Integer dai1hknkkn = 1;

        BizDate dretokijyunymd = BizDate.valueOf(20171222);

        BizDate kykymd = BizDate.valueOf(20180204);

        BizDate yendthnkymd = BizDate.valueOf(20170101);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2017);

        BizDate calckijyunymd = BizDate.valueOf(20180204);

        BizDate syoriYmd = BizDate.valueOf(20170420);

        C_UmuKbn kessanumu = C_UmuKbn.ARI;

        DRateBean dRateBean = setDNnd.exec(syouhncd, ryouritusdno, yoteiriritu, hrkkaisuu, hhknsei, hhknnen,
            hknkknsmnkbn, hknkkn, hrkkkn, kykjyoutai, hrkkknsmnkbn, tuukasyu, dai1hknkkn,dretokijyunymd, kykymd,
            yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd, syoriYmd, kessanumu);

        DRateSyutokuInfoBean dRateSyutokuInfoBean = dRateBean.getDRateSyutokuInfoBean();
        exStringEquals(dRateSyutokuInfoBean.getSyouhncd(), "M210", "商品コード");
        exStringEquals(dRateSyutokuInfoBean.getRyouritusdno(), "001", "料率世代番号");
        exBizCalcbleEquals(dRateSyutokuInfoBean.getYoteiriritu(), BizNumber.valueOf(0.0145), "予定利率");
        exClassificationEquals(dRateSyutokuInfoBean.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(dRateSyutokuInfoBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(dRateSyutokuInfoBean.getHhknnen(), 10, "被保険者年齢");
        exClassificationEquals(dRateSyutokuInfoBean.getHknkknsmnkbn(), hknkknsmnkbn, "保険期間歳満期区分");
        exNumericEquals(dRateSyutokuInfoBean.getHknkkn(), 1, "保険期間");
        exNumericEquals(dRateSyutokuInfoBean.getHrkkkn(), 10, "払込期間");
        exClassificationEquals(dRateSyutokuInfoBean.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(dRateSyutokuInfoBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exNumericEquals(dRateSyutokuInfoBean.getDai1hknkkn(), 1, "第１保険期間");
        exDateYEquals(dRateSyutokuInfoBean.getDratenendo(), BizDateY.valueOf(2017), "Ｄレート年度");
        exClassificationEquals(dRateSyutokuInfoBean.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 1, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180101), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180204), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 3, "配当回数");
    }

    @Test
    @TestOrder(620)
    public void testExec_A62() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;

        String syouhncd = "M210";

        String ryouritusdno = "001";

        BizNumber yoteiriritu = BizNumber.valueOf(0.0145);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.NEN;

        C_Hhknsei hhknsei = C_Hhknsei.MALE;

        int hhknnen = 10;

        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.SAIMANKI;

        int hknkkn = 1;

        int hrkkkn = 10;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ZENNOU;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        Integer dai1hknkkn = 1;

        BizDate dretokijyunymd = BizDate.valueOf(20171222);

        BizDate kykymd = BizDate.valueOf(20180204);

        BizDate yendthnkymd = BizDate.valueOf(20170101);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2017);

        BizDate calckijyunymd = BizDate.valueOf(20180205);

        BizDate syoriYmd = BizDate.valueOf(20170420);

        C_UmuKbn kessanumu = C_UmuKbn.ARI;

        DRateBean dRateBean = setDNnd.exec(syouhncd, ryouritusdno, yoteiriritu, hrkkaisuu, hhknsei, hhknnen,
            hknkknsmnkbn, hknkkn, hrkkkn, kykjyoutai, hrkkknsmnkbn, tuukasyu, dai1hknkkn,dretokijyunymd, kykymd,
            yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd, syoriYmd, kessanumu);

        DRateSyutokuInfoBean dRateSyutokuInfoBean = dRateBean.getDRateSyutokuInfoBean();
        exStringEquals(dRateSyutokuInfoBean.getSyouhncd(), "M210", "商品コード");
        exStringEquals(dRateSyutokuInfoBean.getRyouritusdno(), "001", "料率世代番号");
        exBizCalcbleEquals(dRateSyutokuInfoBean.getYoteiriritu(), BizNumber.valueOf(0.0145), "予定利率");
        exClassificationEquals(dRateSyutokuInfoBean.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(dRateSyutokuInfoBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(dRateSyutokuInfoBean.getHhknnen(), 10, "被保険者年齢");
        exClassificationEquals(dRateSyutokuInfoBean.getHknkknsmnkbn(), hknkknsmnkbn, "保険期間歳満期区分");
        exNumericEquals(dRateSyutokuInfoBean.getHknkkn(), 1, "保険期間");
        exNumericEquals(dRateSyutokuInfoBean.getHrkkkn(), 10, "払込期間");
        exClassificationEquals(dRateSyutokuInfoBean.getKykjyoutai(), C_Kykjyoutai.HARAIMAN, "契約状態");
        exClassificationEquals(dRateSyutokuInfoBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exNumericEquals(dRateSyutokuInfoBean.getDai1hknkkn(), 1, "第１保険期間");
        exDateYEquals(dRateSyutokuInfoBean.getDratenendo(), BizDateY.valueOf(2017), "Ｄレート年度");
        exClassificationEquals(dRateSyutokuInfoBean.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180101), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180204), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");

        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20180204), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20180205), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 3, "配当回数");

    }

    @Test
    @TestOrder(630)
    public void testExec_A63() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;

        String syouhncd = "M210";

        String ryouritusdno = "001";

        BizNumber yoteiriritu = BizNumber.valueOf(0.0145);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.NEN;

        C_Hhknsei hhknsei = C_Hhknsei.MALE;

        int hhknnen = 10;

        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.SAIMANKI;

        int hknkkn = 1;

        int hrkkkn = 10;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ZENNOU;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        Integer dai1hknkkn = 1;

        BizDate dretokijyunymd = BizDate.valueOf(20171222);

        BizDate kykymd = BizDate.valueOf(20180204);

        BizDate yendthnkymd = BizDate.valueOf(20170101);

        BizDateY pCalckijyunYmdTyokuzenHaitounendo = BizDateY.valueOf(2017);

        BizDate calckijyunymd = BizDate.valueOf(20180206);

        BizDate syoriYmd = BizDate.valueOf(20170420);

        C_UmuKbn kessanumu = C_UmuKbn.ARI;

        DRateBean dRateBean = setDNnd.exec(syouhncd, ryouritusdno, yoteiriritu, hrkkaisuu, hhknsei, hhknnen,
            hknkknsmnkbn, hknkkn, hrkkkn, kykjyoutai, hrkkknsmnkbn, tuukasyu, dai1hknkkn,dretokijyunymd, kykymd,
            yendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, calckijyunymd, syoriYmd, kessanumu);

        DRateSyutokuInfoBean dRateSyutokuInfoBean = dRateBean.getDRateSyutokuInfoBean();
        exStringEquals(dRateSyutokuInfoBean.getSyouhncd(), "M210", "商品コード");
        exStringEquals(dRateSyutokuInfoBean.getRyouritusdno(), "001", "料率世代番号");
        exBizCalcbleEquals(dRateSyutokuInfoBean.getYoteiriritu(), BizNumber.valueOf(0.0145), "予定利率");
        exClassificationEquals(dRateSyutokuInfoBean.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(dRateSyutokuInfoBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(dRateSyutokuInfoBean.getHhknnen(), 10, "被保険者年齢");
        exClassificationEquals(dRateSyutokuInfoBean.getHknkknsmnkbn(), hknkknsmnkbn, "保険期間歳満期区分");
        exNumericEquals(dRateSyutokuInfoBean.getHknkkn(), 1, "保険期間");
        exNumericEquals(dRateSyutokuInfoBean.getHrkkkn(), 10, "払込期間");
        exClassificationEquals(dRateSyutokuInfoBean.getKykjyoutai(), C_Kykjyoutai.HARAIMAN, "契約状態");
        exClassificationEquals(dRateSyutokuInfoBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exNumericEquals(dRateSyutokuInfoBean.getDai1hknkkn(), 1, "第１保険期間");
        exDateYEquals(dRateSyutokuInfoBean.getDratenendo(), BizDateY.valueOf(2017), "Ｄレート年度");
        exClassificationEquals(dRateSyutokuInfoBean.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        List<HaitouKaisuuBean> haitouKaisuuBeanList = dRateBean.getHaitouKaisuuBeanLst();
        exNumericEquals(haitouKaisuuBeanList.size(), 2, "配当回数Beanリストの件数");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanfrom(), BizDate.valueOf(20180101), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(0).getKikanto(), BizDate.valueOf(20180204), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(0).getKeikamon(), 1, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(0).getHaitoukaisuu(), 2, "配当回数");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanfrom(), BizDate.valueOf(20180204), "期間（自）");
        exDateEquals(haitouKaisuuBeanList.get(1).getKikanto(), BizDate.valueOf(20180206), "期間（至）");
        exNumericEquals(haitouKaisuuBeanList.get(1).getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBeanList.get(1).getHaitoukaisuu(), 3, "配当回数");

    }



}
