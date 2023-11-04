package yuyu.common.suuri.srcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
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
import yuyu.common.hozen.khcommon.KeisanVHeijyun;
import yuyu.common.hozen.khcommon.KeisanVHeijyunBean;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 数理平準払用保険料積立金計算のメソッド {@link SrSuuriKeisanVHeijyun#exec(String, TkJitenKeiyakuSyouhinKijyunBean,
        List<SV_KiykSyuhnData>, List<IT_HokenryouTmttkn>, BizDateYM, BizDateYM, C_Hrkkaisuu, BizDate, Boolean)}
        テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrSuuriKeisanVHeijyunTest_exec {

    @Inject
    private SrSuuriKeisanVHeijyun srSuuriKeisanVHeijyun;

    private final static String fileName = "UT_SP_単体テスト仕様書_数理平準払用保険料積立金計算";

    private final static String sheetName = "INデータ";

    public static int kaisuu = 0;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SrSuuriKeisanVHeijyunTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
    }

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(KeisanVHeijyun.class).to(KeisanVHeijyunMockForSuuri.class);
                bind(SrGetTokutejitenSyohnInfo.class).to(SrGetTokutejitenSyohnInfoMockForSuuri.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanVHeijyunMockForSuuri.caller = SrSuuriKeisanVHeijyunTest_exec.class;
        SrGetTokutejitenSyohnInfoMockForSuuri.caller = SrSuuriKeisanVHeijyunTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        KeisanVHeijyunMockForSuuri.caller = null;
        KeisanVHeijyunMockForSuuri.SYORIPTN = null;
        SrGetTokutejitenSyohnInfoMockForSuuri.SYORIPTN = null;
        SrGetTokutejitenSyohnInfoMockForSuuri.caller = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        SrGetTokutejitenSyohnInfoMockForSuuri.SYORIPTN = SrGetTokutejitenSyohnInfoMockForSuuri.TESTPATTERN1;
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN1;

        String syono = "18806000014";

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = new TkJitenKeiyakuSyouhinKijyunBean();

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = new ArrayList<>();
        SV_KiykSyuhnData sV_KiykSyuhnData = new SV_KiykSyuhnData();
        sV_KiykSyuhnData.setSyono("18806000025");
        kiykSyuhnDataLst.add(sV_KiykSyuhnData);

        List<IT_HokenryouTmttkn> hokenryouTmttknLst = new ArrayList<>();

        IT_HokenryouTmttkn hokenryouTmttkn = new IT_HokenryouTmttkn();
        hokenryouTmttkn.setSyono(syono);
        hokenryouTmttkn.setTmttkntaisyouym(BizDateYM.valueOf(201601));
        hokenryouTmttkn.setPtmttkngk(BizCurrency.valueOf(150));
        hokenryouTmttkn.setKihrkmpstgk(BizCurrency.valueOf(200));
        hokenryouTmttkn.setRenno(1);
        hokenryouTmttknLst.add(hokenryouTmttkn);

        BizDateYM kijyunymdfrom = BizDateYM.valueOf(201602);

        BizDateYM kijyunymdto = BizDateYM.valueOf(201603);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BizDate fstpryosyu = BizDate.valueOf(20160501);

        Boolean nkgnsCalcymFlg = true;

        BizDate kwsratekjymd = BizDate.valueOf("20190305");

        Boolean nkgnsZenKeisanFlg = false;

        C_ErrorKbn errorKbn = srSuuriKeisanVHeijyun.exec(syono, tkJitenKeiyakuSyouhinKijyunBean, kiykSyuhnDataLst,
            hokenryouTmttknLst, kijyunymdfrom,
            kijyunymdto, hrkkaisuu, fstpryosyu, nkgnsCalcymFlg,kwsratekjymd,nkgnsZenKeisanFlg,false);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<SrTmttknBean> srTmttknBeanLst = srSuuriKeisanVHeijyun.getSrTmttknBeanList();
        exNumericEquals(srTmttknBeanLst.size(), 0, "数理用積立金Beanリストの件数");

        KeisanVHeijyunBean keisanVHeijyunBean = (KeisanVHeijyunBean) MockObjectManager.getArgument(
            KeisanVHeijyunMockForSuuri.class, "exec", 0, 0);
        exDateYMEquals(keisanVHeijyunBean.getTmttkntaisyouym(), BizDateYM.valueOf(201601), "保険料積立金計算年月");
        exBizCalcbleEquals(keisanVHeijyunBean.getCalckaisiYmjitensump(), BizCurrency.valueOf(200), "計算開始年月時点累計Ｐ");
        exBizCalcbleEquals(keisanVHeijyunBean.getCalckaisiYmjitenv(), BizCurrency.valueOf(150), "計算開始年月時点Ｖ");
        exClassificationEquals(keisanVHeijyunBean.getSisansyuruikbn(), C_KhSisanSyuruiKbn.JISSEKI, "試算種類区分");
        exDateEquals(keisanVHeijyunBean.getSisansyoriYmd(), null, "予測計算開始日");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisanyoteiriritu(), null, "予測計算予定利率");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisankawaserate(), null, "予測計算為替レート");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN2;
        SrGetTokutejitenSyohnInfoMockForSuuri.SYORIPTN = SrGetTokutejitenSyohnInfoMockForSuuri.TESTPATTERN1;

        String syono = "18806000025";

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = new TkJitenKeiyakuSyouhinKijyunBean();
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhncd("M210");
        tkJitenKeiyakuSyouhinKijyunBean.setRyouritusdno("1");
        tkJitenKeiyakuSyouhinKijyunBean.setKykymd(BizDate.valueOf(20160302));
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknmanryouymd(BizDate.valueOf(20160322));
        tkJitenKeiyakuSyouhinKijyunBean.setHokenryou(BizCurrency.valueOf(1000));
        tkJitenKeiyakuSyouhinKijyunBean.setKyktuukasyu(C_Tuukasyu.JPY);
        tkJitenKeiyakuSyouhinKijyunBean.setHhknsei(C_Hhknsei.MALE);
        tkJitenKeiyakuSyouhinKijyunBean.setHhknnen(22);
        tkJitenKeiyakuSyouhinKijyunBean.setHknkkn(11);
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknsmnKbn(C_HknkknsmnKbn.SAIMANKI);
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkkn(10);
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
        tkJitenKeiyakuSyouhinKijyunBean.setYoteirrthendohosyurrt(BizNumber.valueOf(100));

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = new ArrayList<>();
        SV_KiykSyuhnData sV_KiykSyuhnData = new SV_KiykSyuhnData();
        sV_KiykSyuhnData.setSyono("18806000025");
        kiykSyuhnDataLst.add(sV_KiykSyuhnData);

        List<IT_HokenryouTmttkn> hokenryouTmttknLst = new ArrayList<>();

        IT_HokenryouTmttkn hokenryouTmttkn1 = new IT_HokenryouTmttkn();
        hokenryouTmttkn1.setSyono(syono);
        hokenryouTmttkn1.setTmttkntaisyouym(BizDateYM.valueOf(201602));
        hokenryouTmttkn1.setGyoumuKousinKinou("khgengaku");
        hokenryouTmttkn1.setRenno(2);
        hokenryouTmttknLst.add(hokenryouTmttkn1);

        IT_HokenryouTmttkn hokenryouTmttkn2 = new IT_HokenryouTmttkn();
        hokenryouTmttkn2.setSyono("18806000036");
        hokenryouTmttkn2.setTmttkntaisyouym(BizDateYM.valueOf(201602));
        hokenryouTmttkn2.setGyoumuKousinKinou("khkouzainfocheck");
        hokenryouTmttkn2.setRenno(3);
        hokenryouTmttknLst.add(hokenryouTmttkn2);

        IT_HokenryouTmttkn hokenryouTmttkn3 = new IT_HokenryouTmttkn();
        hokenryouTmttkn3.setSyono("18806000047");
        hokenryouTmttkn3.setTmttkntaisyouym(BizDateYM.valueOf(201602));
        hokenryouTmttkn3.setGyoumuKousinKinou("khseinengappiseiteisei");
        hokenryouTmttkn3.setRenno(4);
        hokenryouTmttknLst.add(hokenryouTmttkn3);

        BizDateYM kijyunymdfrom = BizDateYM.valueOf(201601);

        BizDateYM kijyunymdto = BizDateYM.valueOf(201601);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BizDate fstpryosyu = BizDate.valueOf(20160501);

        Boolean nkgnsCalcymFlg = true;

        BizDate kwsratekjymd = BizDate.valueOf("20190305");

        Boolean nkgnsZenKeisanFlg = false;

        C_ErrorKbn errorKbn = srSuuriKeisanVHeijyun.exec(syono, tkJitenKeiyakuSyouhinKijyunBean, kiykSyuhnDataLst,
            hokenryouTmttknLst, kijyunymdfrom,
            kijyunymdto, hrkkaisuu, fstpryosyu, nkgnsCalcymFlg, kwsratekjymd, nkgnsZenKeisanFlg,true);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<SrTmttknBean> srTmttknBeanLst = srSuuriKeisanVHeijyun.getSrTmttknBeanList();
        exNumericEquals(srTmttknBeanLst.size(), 1, "数理用積立金Beanリストの件数");
        SrTmttknBean srTmttknBean = srTmttknBeanLst.get(0);
        exDateYMEquals(srTmttknBean.getTumitateYM(), BizDateYM.valueOf(201601), "保険料積立金計算年月");
        exBizCalcbleEquals(srTmttknBean.getTmttKngk(), BizCurrency.valueOf(100), "保険料積立金");
        exBizCalcbleEquals(srTmttknBean.getvTyouseimae(), BizCurrency.valueOf(90), "保険料積立金（調整前）");
        exBizCalcbleEquals(srTmttknBean.getKiharaikomiP(), BizCurrency.valueOf(200), "既払込保険料相当額");
        exBizCalcbleEquals(srTmttknBean.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(40), "予定新契約費率");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituPhirei(), BizNumber.valueOf(50), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituVhirei(), BizNumber.valueOf(60), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiSyuukinhiritu(), BizNumber.valueOf(30), "予定集金費率");
        exBizCalcbleEquals(srTmttknBean.getKogakuWaribikiritu(), BizNumber.valueOf(10), "高額割引率");
        exBizCalcbleEquals(srTmttknBean.getZettaiSibouritu(), BizNumber.valueOf(20), "絶対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiSibouritu(), BizNumber.valueOf(70), "相対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiKaiyakuritu(), BizNumber.valueOf(75), "相対解約率");
        exBizCalcbleEquals(srTmttknBean.getYoteiriritu(), BizNumber.valueOf(80), "予定利率");
        exBizCalcbleEquals(srTmttknBean.getKawaserate(), BizNumber.valueOf(25), "為替レート");

        KeisanVHeijyunBean keisanVHeijyunBean = (KeisanVHeijyunBean) MockObjectManager.getArgument(
            KeisanVHeijyunMockForSuuri.class, "exec", 0, 0);
        exStringEquals(keisanVHeijyunBean.getSyouhncd(), "M210", "商品コード");
        exStringEquals(keisanVHeijyunBean.getRyouritusdno(), "1", "料率世代番号");
        exDateEquals(keisanVHeijyunBean.getKykymd(), BizDate.valueOf(20160302), "契約日");
        exBizCalcbleEquals(keisanVHeijyunBean.getHokenryou(), BizCurrency.valueOf(1000), "保険料");
        exClassificationEquals(keisanVHeijyunBean.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanVHeijyunBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(keisanVHeijyunBean.getHhknnen(), 22, "被保険者年齢");
        exNumericEquals(keisanVHeijyunBean.getHknkkn(), 11, "保険期間");
        exClassificationEquals(keisanVHeijyunBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanVHeijyunBean.getHrkkkn(), 10, "払込期間");
        exClassificationEquals(keisanVHeijyunBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
        exBizCalcbleEquals(keisanVHeijyunBean.getSitihsyuriritu(), BizNumber.valueOf(100), "予定利率変動時保証利率");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN3;
        SrGetTokutejitenSyohnInfoMockForSuuri.SYORIPTN = SrGetTokutejitenSyohnInfoMockForSuuri.TESTPATTERN1;

        String syono = "18806000058";

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = new TkJitenKeiyakuSyouhinKijyunBean();
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhncd("M210");
        tkJitenKeiyakuSyouhinKijyunBean.setRyouritusdno("1");
        tkJitenKeiyakuSyouhinKijyunBean.setKykymd(BizDate.valueOf(20160302));
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknmanryouymd(BizDate.valueOf(20160322));
        tkJitenKeiyakuSyouhinKijyunBean.setHokenryou(BizCurrency.valueOf(1000));
        tkJitenKeiyakuSyouhinKijyunBean.setKyktuukasyu(C_Tuukasyu.JPY);
        tkJitenKeiyakuSyouhinKijyunBean.setHhknsei(C_Hhknsei.MALE);
        tkJitenKeiyakuSyouhinKijyunBean.setHhknnen(22);
        tkJitenKeiyakuSyouhinKijyunBean.setHknkkn(11);
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknsmnKbn(C_HknkknsmnKbn.SAIMANKI);
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkkn(10);
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
        tkJitenKeiyakuSyouhinKijyunBean.setYoteirrthendohosyurrt(BizNumber.valueOf(100));

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = new ArrayList<>();

        List<IT_HokenryouTmttkn> hokenryouTmttknLst = new ArrayList<>();

        BizDateYM kijyunymdfrom = BizDateYM.valueOf(201601);

        BizDateYM kijyunymdto = BizDateYM.valueOf(201602);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BizDate fstpryosyu = BizDate.valueOf(20160501);

        Boolean nkgnsCalcymFlg = true;

        BizDate kwsratekjymd = BizDate.valueOf("20190305");

        Boolean nkgnsZenKeisanFlg = true;

        C_ErrorKbn errorKbn = srSuuriKeisanVHeijyun.exec(syono, tkJitenKeiyakuSyouhinKijyunBean, kiykSyuhnDataLst,
            hokenryouTmttknLst, kijyunymdfrom,
            kijyunymdto, hrkkaisuu, fstpryosyu, nkgnsCalcymFlg, kwsratekjymd, nkgnsZenKeisanFlg,false);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<SrTmttknBean> srTmttknBeanLst = srSuuriKeisanVHeijyun.getSrTmttknBeanList();
        exNumericEquals(srTmttknBeanLst.size(), 2, "数理用積立金Beanリストの件数");
        SrTmttknBean srTmttknBean = srTmttknBeanLst.get(0);
        exDateYMEquals(srTmttknBean.getTumitateYM(), BizDateYM.valueOf(201603), "保険料積立金計算年月");
        exBizCalcbleEquals(srTmttknBean.getTmttKngk(), BizCurrency.valueOf(100), "保険料積立金");
        exBizCalcbleEquals(srTmttknBean.getvTyouseimae(), BizCurrency.valueOf(90), "保険料積立金（調整前）");
        exBizCalcbleEquals(srTmttknBean.getKiharaikomiP(), BizCurrency.valueOf(200), "既払込保険料相当額");
        exBizCalcbleEquals(srTmttknBean.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(40), "予定新契約費率");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituPhirei(), BizNumber.valueOf(50), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituVhirei(), BizNumber.valueOf(60), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiSyuukinhiritu(), BizNumber.valueOf(30), "予定集金費率");
        exBizCalcbleEquals(srTmttknBean.getKogakuWaribikiritu(), BizNumber.valueOf(10), "高額割引率");
        exBizCalcbleEquals(srTmttknBean.getZettaiSibouritu(), BizNumber.valueOf(20), "絶対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiSibouritu(), BizNumber.valueOf(70), "相対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiKaiyakuritu(), BizNumber.valueOf(75), "相対解約率");
        exBizCalcbleEquals(srTmttknBean.getYoteiriritu(), BizNumber.valueOf(80), "予定利率");
        exBizCalcbleEquals(srTmttknBean.getKawaserate(), BizNumber.valueOf(25), "為替レート");

        srTmttknBean = srTmttknBeanLst.get(1);
        exDateYMEquals(srTmttknBean.getTumitateYM(), BizDateYM.valueOf(201604), "保険料積立金計算年月");
        exBizCalcbleEquals(srTmttknBean.getTmttKngk(), BizCurrency.valueOf(100), "保険料積立金");
        exBizCalcbleEquals(srTmttknBean.getvTyouseimae(), BizCurrency.valueOf(90), "保険料積立金（調整前）");
        exBizCalcbleEquals(srTmttknBean.getKiharaikomiP(), BizCurrency.valueOf(200), "既払込保険料相当額");
        exBizCalcbleEquals(srTmttknBean.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(40), "予定新契約費率");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituPhirei(), BizNumber.valueOf(50), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituVhirei(), BizNumber.valueOf(60), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiSyuukinhiritu(), BizNumber.valueOf(30), "予定集金費率");
        exBizCalcbleEquals(srTmttknBean.getKogakuWaribikiritu(), BizNumber.valueOf(10), "高額割引率");
        exBizCalcbleEquals(srTmttknBean.getZettaiSibouritu(), BizNumber.valueOf(20), "絶対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiSibouritu(), BizNumber.valueOf(70), "相対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiKaiyakuritu(), BizNumber.valueOf(75), "相対解約率");
        exBizCalcbleEquals(srTmttknBean.getYoteiriritu(), BizNumber.valueOf(80), "予定利率");
        exBizCalcbleEquals(srTmttknBean.getKawaserate(), BizNumber.valueOf(25), "為替レート");

        KeisanVHeijyunBean keisanVHeijyunBean = (KeisanVHeijyunBean) MockObjectManager.getArgument(
            KeisanVHeijyunMockForSuuri.class, "exec", 1, 0);
        exStringEquals(keisanVHeijyunBean.getSyouhncd(), "M210", "商品コード");
        exStringEquals(keisanVHeijyunBean.getRyouritusdno(), "1", "料率世代番号");
        exDateYMEquals(keisanVHeijyunBean.getCalckijyunYm(), BizDateYM.valueOf(201603), "計算基準年月");
        exDateEquals(keisanVHeijyunBean.getKykymd(), BizDate.valueOf(20160302), "契約日");
        exBizCalcbleEquals(keisanVHeijyunBean.getHokenryou(), BizCurrency.valueOf(1000), "保険料");
        exClassificationEquals(keisanVHeijyunBean.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanVHeijyunBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(keisanVHeijyunBean.getHhknnen(), 22, "被保険者年齢");
        exNumericEquals(keisanVHeijyunBean.getHknkkn(), 11, "保険期間");
        exClassificationEquals(keisanVHeijyunBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanVHeijyunBean.getHrkkkn(), 10, "払込期間");
        exClassificationEquals(keisanVHeijyunBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
        exBizCalcbleEquals(keisanVHeijyunBean.getSitihsyuriritu(), BizNumber.valueOf(100), "予定利率変動時保証利率");

        exClassificationEquals(keisanVHeijyunBean.getSisansyuruikbn(), C_KhSisanSyuruiKbn.SISAN, "試算種類区分");
        exDateEquals(keisanVHeijyunBean.getSisansyoriYmd(), BizDate.valueOf("20160302"), "予測計算開始日");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisanyoteiriritu(), BizNumber.valueOf(100), "予測計算予定利率");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisankawaserate(), BizNumber.valueOf(100.26), "予測計算為替レート");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN3;
        SrGetTokutejitenSyohnInfoMockForSuuri.SYORIPTN = SrGetTokutejitenSyohnInfoMockForSuuri.TESTPATTERN1;

        String syono = "18806000069";

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = new TkJitenKeiyakuSyouhinKijyunBean();
        tkJitenKeiyakuSyouhinKijyunBean.setSyono("M210");
        tkJitenKeiyakuSyouhinKijyunBean.setRyouritusdno("1");
        tkJitenKeiyakuSyouhinKijyunBean.setKykymd(BizDate.valueOf(20160302));
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknmanryouymd(BizDate.valueOf(20160322));
        tkJitenKeiyakuSyouhinKijyunBean.setHokenryou(BizCurrency.valueOf(1000));
        tkJitenKeiyakuSyouhinKijyunBean.setKyktuukasyu(C_Tuukasyu.JPY);
        tkJitenKeiyakuSyouhinKijyunBean.setHhknsei(C_Hhknsei.MALE);
        tkJitenKeiyakuSyouhinKijyunBean.setHhknnen(22);
        tkJitenKeiyakuSyouhinKijyunBean.setHknkkn(11);
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknsmnKbn(C_HknkknsmnKbn.SAIMANKI);
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkkn(10);
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
        tkJitenKeiyakuSyouhinKijyunBean.setYoteirrthendohosyurrt(BizNumber.valueOf(100));

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = new ArrayList<>();

        List<IT_HokenryouTmttkn> hokenryouTmttknLst = new ArrayList<>();

        BizDateYM kijyunymdfrom = BizDateYM.valueOf(201601);

        BizDateYM kijyunymdto = BizDateYM.valueOf(201605);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BizDate fstpryosyu = BizDate.valueOf(20160501);

        Boolean nkgnsCalcymFlg = false;

        BizDate kwsratekjymd = BizDate.valueOf("20190305");

        Boolean nkgnsZenKeisanFlg = false;

        C_ErrorKbn errorKbn = srSuuriKeisanVHeijyun.exec(syono, tkJitenKeiyakuSyouhinKijyunBean, kiykSyuhnDataLst,
            hokenryouTmttknLst, kijyunymdfrom,
            kijyunymdto, hrkkaisuu, fstpryosyu, nkgnsCalcymFlg, kwsratekjymd, nkgnsZenKeisanFlg,false);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<SrTmttknBean> srTmttknBeanLst = srSuuriKeisanVHeijyun.getSrTmttknBeanList();
        exNumericEquals(srTmttknBeanLst.size(), 5, "数理用積立金Beanリストの件数");
        SrTmttknBean srTmttknBean = srTmttknBeanLst.get(0);
        exDateYMEquals(srTmttknBean.getTumitateYM(), BizDateYM.valueOf(201603), "保険料積立金計算年月");
        exBizCalcbleEquals(srTmttknBean.getTmttKngk(), BizCurrency.valueOf(100), "保険料積立金");
        exBizCalcbleEquals(srTmttknBean.getvTyouseimae(), BizCurrency.valueOf(90), "保険料積立金（調整前）");
        exBizCalcbleEquals(srTmttknBean.getKiharaikomiP(), BizCurrency.valueOf(200), "既払込保険料相当額");
        exBizCalcbleEquals(srTmttknBean.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(40), "予定新契約費率");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituPhirei(), BizNumber.valueOf(50), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituVhirei(), BizNumber.valueOf(60), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiSyuukinhiritu(), BizNumber.valueOf(30), "予定集金費率");
        exBizCalcbleEquals(srTmttknBean.getKogakuWaribikiritu(), BizNumber.valueOf(10), "高額割引率");
        exBizCalcbleEquals(srTmttknBean.getZettaiSibouritu(), BizNumber.valueOf(20), "絶対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiSibouritu(), BizNumber.valueOf(70), "相対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiKaiyakuritu(), BizNumber.valueOf(75), "相対解約率");
        exBizCalcbleEquals(srTmttknBean.getYoteiriritu(), BizNumber.valueOf(80), "予定利率");
        exBizCalcbleEquals(srTmttknBean.getKawaserate(), BizNumber.valueOf(25), "為替レート");

        srTmttknBean = srTmttknBeanLst.get(1);
        exDateYMEquals(srTmttknBean.getTumitateYM(), BizDateYM.valueOf(201603), "保険料積立金計算年月");
        exBizCalcbleEquals(srTmttknBean.getTmttKngk(), BizCurrency.valueOf(100), "保険料積立金");
        exBizCalcbleEquals(srTmttknBean.getvTyouseimae(), BizCurrency.valueOf(90), "保険料積立金（調整前）");
        exBizCalcbleEquals(srTmttknBean.getKiharaikomiP(), BizCurrency.valueOf(200), "既払込保険料相当額");
        exBizCalcbleEquals(srTmttknBean.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(40), "予定新契約費率");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituPhirei(), BizNumber.valueOf(50), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituVhirei(), BizNumber.valueOf(60), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiSyuukinhiritu(), BizNumber.valueOf(30), "予定集金費率");
        exBizCalcbleEquals(srTmttknBean.getKogakuWaribikiritu(), BizNumber.valueOf(10), "高額割引率");
        exBizCalcbleEquals(srTmttknBean.getZettaiSibouritu(), BizNumber.valueOf(20), "絶対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiSibouritu(), BizNumber.valueOf(70), "相対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiKaiyakuritu(), BizNumber.valueOf(75), "相対解約率");
        exBizCalcbleEquals(srTmttknBean.getYoteiriritu(), BizNumber.valueOf(80), "予定利率");
        exBizCalcbleEquals(srTmttknBean.getKawaserate(), BizNumber.valueOf(25), "為替レート");

        srTmttknBean = srTmttknBeanLst.get(2);
        exDateYMEquals(srTmttknBean.getTumitateYM(), BizDateYM.valueOf(201603), "保険料積立金計算年月");
        exBizCalcbleEquals(srTmttknBean.getTmttKngk(), BizCurrency.valueOf(100), "保険料積立金");
        exBizCalcbleEquals(srTmttknBean.getvTyouseimae(), BizCurrency.valueOf(90), "保険料積立金（調整前）");
        exBizCalcbleEquals(srTmttknBean.getKiharaikomiP(), BizCurrency.valueOf(200), "既払込保険料相当額");
        exBizCalcbleEquals(srTmttknBean.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(40), "予定新契約費率");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituPhirei(), BizNumber.valueOf(50), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituVhirei(), BizNumber.valueOf(60), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiSyuukinhiritu(), BizNumber.valueOf(30), "予定集金費率");
        exBizCalcbleEquals(srTmttknBean.getKogakuWaribikiritu(), BizNumber.valueOf(10), "高額割引率");
        exBizCalcbleEquals(srTmttknBean.getZettaiSibouritu(), BizNumber.valueOf(20), "絶対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiSibouritu(), BizNumber.valueOf(70), "相対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiKaiyakuritu(), BizNumber.valueOf(75), "相対解約率");
        exBizCalcbleEquals(srTmttknBean.getYoteiriritu(), BizNumber.valueOf(80), "予定利率");
        exBizCalcbleEquals(srTmttknBean.getKawaserate(), BizNumber.valueOf(25), "為替レート");

        srTmttknBean = srTmttknBeanLst.get(3);
        exDateYMEquals(srTmttknBean.getTumitateYM(), BizDateYM.valueOf(201603), "保険料積立金計算年月");
        exBizCalcbleEquals(srTmttknBean.getTmttKngk(), BizCurrency.valueOf(100), "保険料積立金");
        exBizCalcbleEquals(srTmttknBean.getvTyouseimae(), BizCurrency.valueOf(90), "保険料積立金（調整前）");
        exBizCalcbleEquals(srTmttknBean.getKiharaikomiP(), BizCurrency.valueOf(200), "既払込保険料相当額");
        exBizCalcbleEquals(srTmttknBean.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(40), "予定新契約費率");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituPhirei(), BizNumber.valueOf(50), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituVhirei(), BizNumber.valueOf(60), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiSyuukinhiritu(), BizNumber.valueOf(30), "予定集金費率");
        exBizCalcbleEquals(srTmttknBean.getKogakuWaribikiritu(), BizNumber.valueOf(10), "高額割引率");
        exBizCalcbleEquals(srTmttknBean.getZettaiSibouritu(), BizNumber.valueOf(20), "絶対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiSibouritu(), BizNumber.valueOf(70), "相対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiKaiyakuritu(), BizNumber.valueOf(75), "相対解約率");
        exBizCalcbleEquals(srTmttknBean.getYoteiriritu(), BizNumber.valueOf(80), "予定利率");
        exBizCalcbleEquals(srTmttknBean.getKawaserate(), BizNumber.valueOf(25), "為替レート");

        srTmttknBean = srTmttknBeanLst.get(4);
        exDateYMEquals(srTmttknBean.getTumitateYM(), BizDateYM.valueOf(201603), "保険料積立金計算年月");
        exBizCalcbleEquals(srTmttknBean.getTmttKngk(), BizCurrency.valueOf(100), "保険料積立金");
        exBizCalcbleEquals(srTmttknBean.getvTyouseimae(), BizCurrency.valueOf(90), "保険料積立金（調整前）");
        exBizCalcbleEquals(srTmttknBean.getKiharaikomiP(), BizCurrency.valueOf(200), "既払込保険料相当額");
        exBizCalcbleEquals(srTmttknBean.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(40), "予定新契約費率");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituPhirei(), BizNumber.valueOf(50), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituVhirei(), BizNumber.valueOf(60), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiSyuukinhiritu(), BizNumber.valueOf(30), "予定集金費率");
        exBizCalcbleEquals(srTmttknBean.getKogakuWaribikiritu(), BizNumber.valueOf(10), "高額割引率");
        exBizCalcbleEquals(srTmttknBean.getZettaiSibouritu(), BizNumber.valueOf(20), "絶対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiSibouritu(), BizNumber.valueOf(70), "相対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiKaiyakuritu(), BizNumber.valueOf(75), "相対解約率");
        exBizCalcbleEquals(srTmttknBean.getYoteiriritu(), BizNumber.valueOf(80), "予定利率");
        exBizCalcbleEquals(srTmttknBean.getKawaserate(), BizNumber.valueOf(25), "為替レート");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN3;
        SrGetTokutejitenSyohnInfoMockForSuuri.SYORIPTN = SrGetTokutejitenSyohnInfoMockForSuuri.TESTPATTERN2;

        String syono = "18806000070";

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = new TkJitenKeiyakuSyouhinKijyunBean();
        tkJitenKeiyakuSyouhinKijyunBean.setSyono("M210");
        tkJitenKeiyakuSyouhinKijyunBean.setRyouritusdno("1");
        tkJitenKeiyakuSyouhinKijyunBean.setKykymd(BizDate.valueOf(20160302));
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknmanryouymd(BizDate.valueOf(20160322));
        tkJitenKeiyakuSyouhinKijyunBean.setHokenryou(BizCurrency.valueOf(1000));
        tkJitenKeiyakuSyouhinKijyunBean.setKyktuukasyu(C_Tuukasyu.JPY);
        tkJitenKeiyakuSyouhinKijyunBean.setHhknsei(C_Hhknsei.MALE);
        tkJitenKeiyakuSyouhinKijyunBean.setHhknnen(22);
        tkJitenKeiyakuSyouhinKijyunBean.setHknkkn(11);
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknsmnKbn(C_HknkknsmnKbn.SAIMANKI);
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkkn(10);
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
        tkJitenKeiyakuSyouhinKijyunBean.setYoteirrthendohosyurrt(BizNumber.valueOf(100));

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = new ArrayList<>();
        SV_KiykSyuhnData sV_KiykSyuhnData = new SV_KiykSyuhnData();
        sV_KiykSyuhnData.setSyono("18806000070");
        kiykSyuhnDataLst.add(sV_KiykSyuhnData);

        List<IT_HokenryouTmttkn> hokenryouTmttknLst = new ArrayList<>();

        IT_HokenryouTmttkn hokenryouTmttkn1 = new IT_HokenryouTmttkn();
        hokenryouTmttkn1.setSyono(syono);
        hokenryouTmttkn1.setTmttkntaisyouym(BizDateYM.valueOf(201602));
        hokenryouTmttkn1.setGyoumuKousinKinou("khseinengappiseiteisei");
        hokenryouTmttkn1.setRenno(1);
        hokenryouTmttknLst.add(hokenryouTmttkn1);

        IT_HokenryouTmttkn hokenryouTmttkn2 = new IT_HokenryouTmttkn();
        hokenryouTmttkn2.setSyono("18806000036");
        hokenryouTmttkn2.setTmttkntaisyouym(BizDateYM.valueOf(201602));
        hokenryouTmttkn2.setGyoumuKousinKinou("khseinengappiseiteisei");
        hokenryouTmttkn2.setRenno(2);
        hokenryouTmttknLst.add(hokenryouTmttkn2);

        BizDateYM kijyunymdfrom = BizDateYM.valueOf(201601);

        BizDateYM kijyunymdto = BizDateYM.valueOf(201601);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BizDate fstpryosyu = BizDate.valueOf(20160501);

        Boolean nkgnsCalcymFlg = true;

        BizDate kwsratekjymd = BizDate.valueOf("20190309");

        Boolean nkgnsZenKeisanFlg = true;

        C_ErrorKbn errorKbn = srSuuriKeisanVHeijyun.exec(syono, tkJitenKeiyakuSyouhinKijyunBean, kiykSyuhnDataLst,
            hokenryouTmttknLst, kijyunymdfrom,
            kijyunymdto, hrkkaisuu, fstpryosyu, nkgnsCalcymFlg, kwsratekjymd, nkgnsZenKeisanFlg,false);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<SrTmttknBean> srTmttknBeanLst = srSuuriKeisanVHeijyun.getSrTmttknBeanList();
        exNumericEquals(srTmttknBeanLst.size(), 1, "数理用積立金Beanリストの件数");

        SrTmttknBean srTmttknBean = srTmttknBeanLst.get(0);
        exDateYMEquals(srTmttknBean.getTumitateYM(), BizDateYM.valueOf(201603), "保険料積立金計算年月");
        exBizCalcbleEquals(srTmttknBean.getTmttKngk(), BizCurrency.valueOf(100), "保険料積立金");
        exBizCalcbleEquals(srTmttknBean.getvTyouseimae(), BizCurrency.valueOf(90), "保険料積立金（調整前）");
        exBizCalcbleEquals(srTmttknBean.getKiharaikomiP(), BizCurrency.valueOf(200), "既払込保険料相当額");
        exBizCalcbleEquals(srTmttknBean.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(40), "予定新契約費率");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituPhirei(), BizNumber.valueOf(50), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituVhirei(), BizNumber.valueOf(60), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiSyuukinhiritu(), BizNumber.valueOf(30), "予定集金費率");
        exBizCalcbleEquals(srTmttknBean.getKogakuWaribikiritu(), BizNumber.valueOf(10), "高額割引率");
        exBizCalcbleEquals(srTmttknBean.getZettaiSibouritu(), BizNumber.valueOf(20), "絶対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiSibouritu(), BizNumber.valueOf(70), "相対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiKaiyakuritu(), BizNumber.valueOf(75), "相対解約率");
        exBizCalcbleEquals(srTmttknBean.getYoteiriritu(), BizNumber.valueOf(80), "予定利率");
        exBizCalcbleEquals(srTmttknBean.getKawaserate(), BizNumber.valueOf(25), "為替レート");

        exClassificationEquals(
            (C_TokutejitenSyoriKbn) MockObjectManager.getArgument(SrGetTokutejitenSyohnInfoMockForSuuri.class, "exec", 0, 0),
            C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO, "特定時点判定処理区分");
        exStringEquals((String) MockObjectManager.getArgument(SrGetTokutejitenSyohnInfoMockForSuuri.class, "exec", 0, 1),
            syono, "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(SrGetTokutejitenSyohnInfoMockForSuuri.class, "exec", 0, 2),
            BizDate.valueOf(20151231), "特定時点判定基準日");
        exStringEquals((String) MockObjectManager.getArgument(SrGetTokutejitenSyohnInfoMockForSuuri.class, "exec", 0, 3), "",
            "特定時点判定変更識別キー");
        List<SV_KiykSyuhnData> KiykSyuhnDataList = (List<SV_KiykSyuhnData>) MockObjectManager.getArgument(
            SrGetTokutejitenSyohnInfoMockForSuuri.class, "exec", 0, 4);
        exStringEquals(KiykSyuhnDataList.get(0).getSyono(), "18806000070", "証券番号");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN3;
        SrGetTokutejitenSyohnInfoMockForSuuri.SYORIPTN = SrGetTokutejitenSyohnInfoMockForSuuri.TESTPATTERN1;
        String syono = "18806000025";

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = new TkJitenKeiyakuSyouhinKijyunBean();
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhncd("M210");
        tkJitenKeiyakuSyouhinKijyunBean.setRyouritusdno("1");
        tkJitenKeiyakuSyouhinKijyunBean.setKykymd(BizDate.valueOf(20160302));
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknmanryouymd(BizDate.valueOf(20160322));
        tkJitenKeiyakuSyouhinKijyunBean.setHokenryou(BizCurrency.valueOf(1000));
        tkJitenKeiyakuSyouhinKijyunBean.setKyktuukasyu(C_Tuukasyu.JPY);
        tkJitenKeiyakuSyouhinKijyunBean.setHhknsei(C_Hhknsei.MALE);
        tkJitenKeiyakuSyouhinKijyunBean.setHhknnen(22);
        tkJitenKeiyakuSyouhinKijyunBean.setHknkkn(11);
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknsmnKbn(C_HknkknsmnKbn.SAIMANKI);
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkkn(10);
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
        tkJitenKeiyakuSyouhinKijyunBean.setYoteirrthendohosyurrt(BizNumber.valueOf(100));

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = new ArrayList<>();
        SV_KiykSyuhnData sV_KiykSyuhnData = new SV_KiykSyuhnData();
        sV_KiykSyuhnData.setSyono("18806000025");
        kiykSyuhnDataLst.add(sV_KiykSyuhnData);

        List<IT_HokenryouTmttkn> hokenryouTmttknLst = new ArrayList<>();

        IT_HokenryouTmttkn hokenryouTmttkn1 = new IT_HokenryouTmttkn();
        hokenryouTmttkn1.setSyono("18806000058");
        hokenryouTmttkn1.setTmttkntaisyouym(BizDateYM.valueOf(201602));
        hokenryouTmttkn1.setGyoumuKousinKinou("khseinengappiseiteisei");
        hokenryouTmttkn1.setRenno(5);
        hokenryouTmttknLst.add(hokenryouTmttkn1);

        BizDateYM kijyunymdfrom = BizDateYM.valueOf(201601);

        BizDateYM kijyunymdto = BizDateYM.valueOf(201602);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BizDate fstpryosyu = BizDate.valueOf(20160501);

        Boolean nkgnsCalcymFlg = true;

        BizDate kwsratekjymd = BizDate.valueOf("20190305");

        Boolean nkgnsZenKeisanFlg = false;

        C_ErrorKbn errorKbn = srSuuriKeisanVHeijyun.exec(syono, tkJitenKeiyakuSyouhinKijyunBean, kiykSyuhnDataLst,
            hokenryouTmttknLst, kijyunymdfrom,
            kijyunymdto, hrkkaisuu, fstpryosyu, nkgnsCalcymFlg, kwsratekjymd, nkgnsZenKeisanFlg,false);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<SrTmttknBean> srTmttknBeanLst = srSuuriKeisanVHeijyun.getSrTmttknBeanList();
        exNumericEquals(srTmttknBeanLst.size(), 2, "数理用積立金Beanリストの件数");

        SrTmttknBean srTmttknBean = srTmttknBeanLst.get(0);
        exDateYMEquals(srTmttknBean.getTumitateYM(), BizDateYM.valueOf(201603), "保険料積立金計算年月");
        exBizCalcbleEquals(srTmttknBean.getTmttKngk(), BizCurrency.valueOf(100), "保険料積立金");
        exBizCalcbleEquals(srTmttknBean.getvTyouseimae(), BizCurrency.valueOf(90), "保険料積立金（調整前）");
        exBizCalcbleEquals(srTmttknBean.getKiharaikomiP(), BizCurrency.valueOf(200), "既払込保険料相当額");
        exBizCalcbleEquals(srTmttknBean.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(40), "予定新契約費率");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituPhirei(), BizNumber.valueOf(50), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituVhirei(), BizNumber.valueOf(60), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiSyuukinhiritu(), BizNumber.valueOf(30), "予定集金費率");
        exBizCalcbleEquals(srTmttknBean.getKogakuWaribikiritu(), BizNumber.valueOf(10), "高額割引率");
        exBizCalcbleEquals(srTmttknBean.getZettaiSibouritu(), BizNumber.valueOf(20), "絶対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiSibouritu(), BizNumber.valueOf(70), "相対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiKaiyakuritu(), BizNumber.valueOf(75), "相対解約率");
        exBizCalcbleEquals(srTmttknBean.getYoteiriritu(), BizNumber.valueOf(80), "予定利率");
        exBizCalcbleEquals(srTmttknBean.getKawaserate(), BizNumber.valueOf(25), "為替レート");

        srTmttknBean = srTmttknBeanLst.get(1);
        exDateYMEquals(srTmttknBean.getTumitateYM(), BizDateYM.valueOf(201604), "保険料積立金計算年月");
        exBizCalcbleEquals(srTmttknBean.getTmttKngk(), BizCurrency.valueOf(100), "保険料積立金");
        exBizCalcbleEquals(srTmttknBean.getvTyouseimae(), BizCurrency.valueOf(90), "保険料積立金（調整前）");
        exBizCalcbleEquals(srTmttknBean.getKiharaikomiP(), BizCurrency.valueOf(200), "既払込保険料相当額");
        exBizCalcbleEquals(srTmttknBean.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(40), "予定新契約費率");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituPhirei(), BizNumber.valueOf(50), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituVhirei(), BizNumber.valueOf(60), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiSyuukinhiritu(), BizNumber.valueOf(30), "予定集金費率");
        exBizCalcbleEquals(srTmttknBean.getKogakuWaribikiritu(), BizNumber.valueOf(10), "高額割引率");
        exBizCalcbleEquals(srTmttknBean.getZettaiSibouritu(), BizNumber.valueOf(20), "絶対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiSibouritu(), BizNumber.valueOf(70), "相対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiKaiyakuritu(), BizNumber.valueOf(75), "相対解約率");
        exBizCalcbleEquals(srTmttknBean.getYoteiriritu(), BizNumber.valueOf(80), "予定利率");
        exBizCalcbleEquals(srTmttknBean.getKawaserate(), BizNumber.valueOf(25), "為替レート");

        KeisanVHeijyunBean keisanVHeijyunBean = (KeisanVHeijyunBean) MockObjectManager.getArgument(
            KeisanVHeijyunMockForSuuri.class, "exec", 0, 0);
        exStringEquals(keisanVHeijyunBean.getSyouhncd(), "M210", "商品コード");
        exStringEquals(keisanVHeijyunBean.getRyouritusdno(), "1", "料率世代番号");
        exDateEquals(keisanVHeijyunBean.getKykymd(), BizDate.valueOf(20160302), "契約日");
        exBizCalcbleEquals(keisanVHeijyunBean.getHokenryou(), BizCurrency.valueOf(1000), "保険料");
        exClassificationEquals(keisanVHeijyunBean.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanVHeijyunBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(keisanVHeijyunBean.getHhknnen(), 22, "被保険者年齢");
        exNumericEquals(keisanVHeijyunBean.getHknkkn(), 11, "保険期間");
        exClassificationEquals(keisanVHeijyunBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanVHeijyunBean.getHrkkkn(), 10, "払込期間");
        exClassificationEquals(keisanVHeijyunBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
        exBizCalcbleEquals(keisanVHeijyunBean.getSitihsyuriritu(), BizNumber.valueOf(100), "予定利率変動時保証利率");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN3;
        SrGetTokutejitenSyohnInfoMockForSuuri.SYORIPTN = SrGetTokutejitenSyohnInfoMockForSuuri.TESTPATTERN1;

        String syono = "18806000025";

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = new TkJitenKeiyakuSyouhinKijyunBean();
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhncd("M210");
        tkJitenKeiyakuSyouhinKijyunBean.setRyouritusdno("1");
        tkJitenKeiyakuSyouhinKijyunBean.setKykymd(BizDate.valueOf(20160302));
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknmanryouymd(BizDate.valueOf(20160322));
        tkJitenKeiyakuSyouhinKijyunBean.setHokenryou(BizCurrency.valueOf(1000));
        tkJitenKeiyakuSyouhinKijyunBean.setKyktuukasyu(C_Tuukasyu.JPY);
        tkJitenKeiyakuSyouhinKijyunBean.setHhknsei(C_Hhknsei.MALE);
        tkJitenKeiyakuSyouhinKijyunBean.setHhknnen(22);
        tkJitenKeiyakuSyouhinKijyunBean.setHknkkn(11);
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknsmnKbn(C_HknkknsmnKbn.SAIMANKI);
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkkn(10);
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
        tkJitenKeiyakuSyouhinKijyunBean.setYoteirrthendohosyurrt(BizNumber.valueOf(100));

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = new ArrayList<>();
        SV_KiykSyuhnData sV_KiykSyuhnData = new SV_KiykSyuhnData();
        sV_KiykSyuhnData.setSyono("18806000025");
        kiykSyuhnDataLst.add(sV_KiykSyuhnData);

        List<IT_HokenryouTmttkn> hokenryouTmttknLst = new ArrayList<>();

        IT_HokenryouTmttkn hokenryouTmttkn1 = new IT_HokenryouTmttkn();
        hokenryouTmttkn1.setSyono("18806000058");
        hokenryouTmttkn1.setTmttkntaisyouym(BizDateYM.valueOf(201602));
        hokenryouTmttkn1.setGyoumuKousinKinou("khkouzainfocheck");
        hokenryouTmttkn1.setRenno(5);
        hokenryouTmttknLst.add(hokenryouTmttkn1);

        BizDateYM kijyunymdfrom = BizDateYM.valueOf(201601);

        BizDateYM kijyunymdto = BizDateYM.valueOf(201601);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BizDate fstpryosyu = BizDate.valueOf(20160501);

        Boolean nkgnsCalcymFlg = true;

        BizDate kwsratekjymd = BizDate.valueOf("20190305");

        Boolean nkgnsZenKeisanFlg = false;

        C_ErrorKbn errorKbn = srSuuriKeisanVHeijyun.exec(syono, tkJitenKeiyakuSyouhinKijyunBean, kiykSyuhnDataLst,
            hokenryouTmttknLst, kijyunymdfrom,
            kijyunymdto, hrkkaisuu, fstpryosyu, nkgnsCalcymFlg, kwsratekjymd, nkgnsZenKeisanFlg,true);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<SrTmttknBean> srTmttknBeanLst = srSuuriKeisanVHeijyun.getSrTmttknBeanList();
        exNumericEquals(srTmttknBeanLst.size(), 2, "数理用積立金Beanリストの件数");

        SrTmttknBean srTmttknBean = srTmttknBeanLst.get(0);
        exDateYMEquals(srTmttknBean.getTumitateYM(), BizDateYM.valueOf(201603), "保険料積立金計算年月");
        exBizCalcbleEquals(srTmttknBean.getTmttKngk(), BizCurrency.valueOf(100), "保険料積立金");
        exBizCalcbleEquals(srTmttknBean.getvTyouseimae(), BizCurrency.valueOf(90), "保険料積立金（調整前）");
        exBizCalcbleEquals(srTmttknBean.getKiharaikomiP(), BizCurrency.valueOf(200), "既払込保険料相当額");
        exBizCalcbleEquals(srTmttknBean.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(40), "予定新契約費率");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituPhirei(), BizNumber.valueOf(50), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituVhirei(), BizNumber.valueOf(60), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiSyuukinhiritu(), BizNumber.valueOf(30), "予定集金費率");
        exBizCalcbleEquals(srTmttknBean.getKogakuWaribikiritu(), BizNumber.valueOf(10), "高額割引率");
        exBizCalcbleEquals(srTmttknBean.getZettaiSibouritu(), BizNumber.valueOf(20), "絶対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiSibouritu(), BizNumber.valueOf(70), "相対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiKaiyakuritu(), BizNumber.valueOf(75), "相対解約率");
        exBizCalcbleEquals(srTmttknBean.getYoteiriritu(), BizNumber.valueOf(80), "予定利率");
        exBizCalcbleEquals(srTmttknBean.getKawaserate(), BizNumber.valueOf(25), "為替レート");

        srTmttknBean = srTmttknBeanLst.get(1);
        exDateYMEquals(srTmttknBean.getTumitateYM(), BizDateYM.valueOf(201604), "保険料積立金計算年月");
        exBizCalcbleEquals(srTmttknBean.getTmttKngk(), BizCurrency.valueOf(100), "保険料積立金");
        exBizCalcbleEquals(srTmttknBean.getvTyouseimae(), BizCurrency.valueOf(90), "保険料積立金（調整前）");
        exBizCalcbleEquals(srTmttknBean.getKiharaikomiP(), BizCurrency.valueOf(200), "既払込保険料相当額");
        exBizCalcbleEquals(srTmttknBean.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(40), "予定新契約費率");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituPhirei(), BizNumber.valueOf(50), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiIjihirituVhirei(), BizNumber.valueOf(60), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(srTmttknBean.getYoteiSyuukinhiritu(), BizNumber.valueOf(30), "予定集金費率");
        exBizCalcbleEquals(srTmttknBean.getKogakuWaribikiritu(), BizNumber.valueOf(10), "高額割引率");
        exBizCalcbleEquals(srTmttknBean.getZettaiSibouritu(), BizNumber.valueOf(20), "絶対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiSibouritu(), BizNumber.valueOf(70), "相対死亡率");
        exBizCalcbleEquals(srTmttknBean.getSoutaiKaiyakuritu(), BizNumber.valueOf(75), "相対解約率");
        exBizCalcbleEquals(srTmttknBean.getYoteiriritu(), BizNumber.valueOf(80), "予定利率");
        exBizCalcbleEquals(srTmttknBean.getKawaserate(), BizNumber.valueOf(25), "為替レート");

        KeisanVHeijyunBean keisanVHeijyunBean = (KeisanVHeijyunBean) MockObjectManager.getArgument(
            KeisanVHeijyunMockForSuuri.class, "exec", 0, 0);
        exStringEquals(keisanVHeijyunBean.getSyouhncd(), "M210", "商品コード");
        exStringEquals(keisanVHeijyunBean.getRyouritusdno(), "1", "料率世代番号");
        exDateEquals(keisanVHeijyunBean.getKykymd(), BizDate.valueOf(20160302), "契約日");
        exBizCalcbleEquals(keisanVHeijyunBean.getHokenryou(), BizCurrency.valueOf(1000), "保険料");
        exClassificationEquals(keisanVHeijyunBean.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanVHeijyunBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(keisanVHeijyunBean.getHhknnen(), 22, "被保険者年齢");
        exNumericEquals(keisanVHeijyunBean.getHknkkn(), 11, "保険期間");
        exClassificationEquals(keisanVHeijyunBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanVHeijyunBean.getHrkkkn(), 10, "払込期間");
        exClassificationEquals(keisanVHeijyunBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
        exBizCalcbleEquals(keisanVHeijyunBean.getSitihsyuriritu(), BizNumber.valueOf(100), "予定利率変動時保証利率");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        SrGetTokutejitenSyohnInfoMockForSuuri.SYORIPTN = SrGetTokutejitenSyohnInfoMockForSuuri.TESTPATTERN1;
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN1;

        String syono = "18806000014";

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = new TkJitenKeiyakuSyouhinKijyunBean();

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = new ArrayList<>();
        SV_KiykSyuhnData sV_KiykSyuhnData = new SV_KiykSyuhnData();
        sV_KiykSyuhnData.setSyono("18806000025");
        kiykSyuhnDataLst.add(sV_KiykSyuhnData);

        List<IT_HokenryouTmttkn> hokenryouTmttknLst = new ArrayList<>();

        IT_HokenryouTmttkn hokenryouTmttkn = new IT_HokenryouTmttkn();
        hokenryouTmttkn.setSyono(syono);
        hokenryouTmttkn.setTmttkntaisyouym(BizDateYM.valueOf(201602));
        hokenryouTmttkn.setPtmttkngk(BizCurrency.valueOf(150));
        hokenryouTmttkn.setKihrkmpstgk(BizCurrency.valueOf(200));
        hokenryouTmttkn.setRenno(1);
        hokenryouTmttknLst.add(hokenryouTmttkn);

        BizDateYM kijyunymdfrom = BizDateYM.valueOf(201602);

        BizDateYM kijyunymdto = BizDateYM.valueOf(201603);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BizDate fstpryosyu = BizDate.valueOf(20160501);

        Boolean nkgnsCalcymFlg = true;

        BizDate kwsratekjymd = BizDate.valueOf("20190305");

        Boolean nkgnsZenKeisanFlg = false;

        C_ErrorKbn errorKbn = srSuuriKeisanVHeijyun.exec(syono, tkJitenKeiyakuSyouhinKijyunBean, kiykSyuhnDataLst,
            hokenryouTmttknLst, kijyunymdfrom,
            kijyunymdto, hrkkaisuu, fstpryosyu, nkgnsCalcymFlg,kwsratekjymd,nkgnsZenKeisanFlg,false);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<SrTmttknBean> srTmttknBeanLst = srSuuriKeisanVHeijyun.getSrTmttknBeanList();
        exNumericEquals(srTmttknBeanLst.size(), 0, "数理用積立金Beanリストの件数");

        KeisanVHeijyunBean keisanVHeijyunBean = (KeisanVHeijyunBean) MockObjectManager.getArgument(
            KeisanVHeijyunMockForSuuri.class, "exec", 0, 0);
        exDateYMEquals(keisanVHeijyunBean.getTmttkntaisyouym(), BizDateYM.valueOf(201602), "保険料積立金計算年月");
        exBizCalcbleEquals(keisanVHeijyunBean.getCalckaisiYmjitensump(), BizCurrency.valueOf(200), "計算開始年月時点累計Ｐ");
        exBizCalcbleEquals(keisanVHeijyunBean.getCalckaisiYmjitenv(), BizCurrency.valueOf(150), "計算開始年月時点Ｖ");
        exClassificationEquals(keisanVHeijyunBean.getSisansyuruikbn(), C_KhSisanSyuruiKbn.JISSEKI, "試算種類区分");
        exDateEquals(keisanVHeijyunBean.getSisansyoriYmd(), null, "予測計算開始日");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisanyoteiriritu(), null, "予測計算予定利率");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisankawaserate(), null, "予測計算為替レート");
    }
}
