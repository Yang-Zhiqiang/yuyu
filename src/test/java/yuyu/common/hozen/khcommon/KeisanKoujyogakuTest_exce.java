package yuyu.common.hozen.khcommon;

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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.KeisanPRsTuukaKnsn;
import yuyu.common.hozen.ascommon.KeisanPRsTuukaKnsnMockForKhansyuu;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_KjsmsyoriKbn;
import yuyu.def.classification.C_KoujyosyoumeimsgKbn;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 控除証明額計算クラスのメソッド {@link KeisanKoujyogaku#exec(String, String, C_KjsmsyoriKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanKoujyogakuTest_exce {

    private final static String syoNo1 = "17806000013";

    private final static String syoNo2 = "17806000024";

    private final static String syoNo3 = "17806000035";

    private final static String syoNo4 = "17806000046";

    private final static String syoNo5 = "17806000057";

    private final static String syoNo6 = "17806000068";

    private final static String syoNo7 = "17806000079";

    private final static String syoNo8 = "17806000080";

    private final static String syoNo9 = "17806000091";

    private final static String syoNo10 = "17806000105";

    private final static String syoNo11 = "17806000116";

    private final static String syoNo12 = "17806000127";

    private final static String syoNo13 = "17806000138";

    private final static String syoNo14 = "17806000149";

    private final static String syoNo15 = "17806000150";

    private final static String syoNo16 = "17806000161";

    private final static String syoNo17 = "17806000172";

    private final static String syoNo18 = "17806000183";

    private final static String syoNo19 = "17806000194";

    private final static String syoNo20 = "17806000208";

    private final static String syoNo23 = "17806000231";

    private final static String syoNo29 = "17806000297";

    private final static String syoNo30 = "17806000301";

    private final static String syoNo31 = "17806000312";

    private final static String syoNo32 = "17806000323";

    private final static String syoNo33 = "17806000378";

    private final static String syoNo34 = "17806000389";

    private final static String syoNo35 = "17809221136";

    private final static String syoNo36 = "11807111163";

    private final static String syoNo37 = "11807111255";

    private final static String syoNo38 = "11807111152";

    private final static String syoNo39 = "11807111129";

    private final static String syoNo40 = "11807111211";

    private final static String syoNo41 = "11807111130";

    private final static String syoNo42 = "11807111118";

    private final static String syoNo43 = "11807111141";

    private final static String syoNo44 = "11807111174";

    private final static String syoNo45 = "60806000033";

    private final static String syoNo46 = "12806345672";

    private final static String syoNo47 = "60806000044";

    private final static String syoNo48 = "11809111136";

    private final static String syoNo49 = "12806345694";

    private final static String syoNo50 = "11807111705";

    private final static String syoNo51 = "11807111691";

    private final static String syoNo52 = "11807111680";

    private final static String syoNo53 = "11807111679";

    private final static String syoNo54 = "11807111668";

    private final static String fileName = "UT_SP_単体テスト仕様書_控除証明額計算";

    private final static String sheetName = "INデータ";

    @Inject
    private KeisanKoujyogaku keisanKoujyogaku;

    @Inject
    private AS_Kinou asKinou;

    private static BizDate KoujyoSymZeiseiKaiseiYmd;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanZennouKoujyogaku.class).to(KeisanZennouKoujyogakuMockForKhansyuu.class);
                bind(KeisanPRsTuukaKnsn.class).to(KeisanPRsTuukaKnsnMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        KeisanZennouKoujyogakuMockForKhansyuu.caller = KeisanKoujyogakuTest_exce.class;
        KeisanPRsTuukaKnsnMockForKhansyuu.caller = KeisanKoujyogakuTest_exce.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        KeisanZennouKoujyogakuMockForKhansyuu.caller = null;
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = null;
        KeisanPRsTuukaKnsnMockForKhansyuu.caller = null;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = null;
    }


    @BeforeClass
    @Transactional
    public static void insertTestData(){

        KoujyoSymZeiseiKaiseiYmd = YuyuHozenConfig.getInstance().getKoujyoSymZeiseiKaiseiYmd();
        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanKoujyogakuTest_exce.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();
        YuyuHozenConfig.getInstance().setKoujyoSymZeiseiKaiseiYmd(KoujyoSymZeiseiKaiseiYmd);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        KeisanZennouKoujyogakuMockForKhansyuu.caller = null;
        KeisanPRsTuukaKnsnMockForKhansyuu.caller = null;
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            keisanKoujyogaku.exec(syoNo1, "2015");

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約基本テーブル  取得エラー  証券番号＝17806000013", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            keisanKoujyogaku.exec(syoNo2, "2015");

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約商品テーブル  取得エラー  証券番号＝17806000024", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            keisanKoujyogaku.exec(syoNo3, "2015");

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。控除証明内容テーブル  取得エラー  証券番号＝17806000035", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        asKinou.setKinouKbn(C_KinouKbn.BATCH);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        IT_KykKihon kykKihon = new IT_KykKihon("4", syoNo4);
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);

        IT_AnsyuKihon ansyuKihon = new IT_AnsyuKihon("4", syoNo4);

        IT_KykSyouhn kykSyouhn = kykKihon.createKykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn.setSyouhncd("JH04");
        kykSyouhn.setSyouhnsdno(1);
        kykSyouhn.setKyksyouhnrenno(1);
        kykSyouhn.setKykymd(BizDate.valueOf(20151216));

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.createKykSonotaTkyk();
        kykSonotaTkyk.setKbnkey("4");
        kykSonotaTkyk.setSyono(syoNo4);

        IT_KoujyoSymNaiyou koujyoSymNaiyou = kykKihon.createKoujyoSymNaiyou();
        koujyoSymNaiyou.setSyouhncd("JH04");
        koujyoSymNaiyou.setRenno3keta(1);
        koujyoSymNaiyou.setKoujyosyoumeinnd("2015");
        koujyoSymNaiyou.setSyoumeistartym(BizDateYM.valueOf(201505));
        koujyoSymNaiyou.setSyoumeiendym(BizDateYM.valueOf(201509));
        koujyoSymNaiyou.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
        koujyoSymNaiyou.setTekiyouseidokbn(C_TekiyouseidoKbn.NEWSD);
        koujyoSymNaiyou.setKoujyosyoumeigk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        koujyoSymNaiyou.setJyutoustartym(BizDateYM.valueOf(201506));
        koujyoSymNaiyou.setNyknjskrrkrenno(1);
        koujyoSymNaiyou.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);
        koujyoSymNaiyou.setSyoumeistartym(BizDateYM.valueOf(201505));

        IT_KoujyoSymNaiyou koujyoSymNaiyou2 = kykKihon.createKoujyoSymNaiyou();
        koujyoSymNaiyou2.setSyouhncd("JH04");
        koujyoSymNaiyou2.setRenno3keta(2);
        koujyoSymNaiyou2.setKoujyosyoumeinnd("2015");
        koujyoSymNaiyou2.setSyoumeistartym(BizDateYM.valueOf(201505));
        koujyoSymNaiyou2.setSyoumeiendym(BizDateYM.valueOf(201509));
        koujyoSymNaiyou2.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.KAIGOIRYOU);
        koujyoSymNaiyou2.setTekiyouseidokbn(C_TekiyouseidoKbn.NEWSD);
        koujyoSymNaiyou2.setKoujyosyoumeigk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        koujyoSymNaiyou2.setJyutoustartym(BizDateYM.valueOf(201506));
        koujyoSymNaiyou2.setNyknjskrrkrenno(1);
        koujyoSymNaiyou2.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);

        IT_KoujyoSymNaiyou koujyoSymNaiyou3 = kykKihon.createKoujyoSymNaiyou();
        koujyoSymNaiyou3.setSyouhncd("JH04");
        koujyoSymNaiyou3.setRenno3keta(3);
        koujyoSymNaiyou3.setKoujyosyoumeinnd("2015");
        koujyoSymNaiyou3.setSyoumeistartym(BizDateYM.valueOf(201505));
        koujyoSymNaiyou3.setSyoumeiendym(BizDateYM.valueOf(201509));
        koujyoSymNaiyou3.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.NENKIN);
        koujyoSymNaiyou3.setTekiyouseidokbn(C_TekiyouseidoKbn.NEWSD);
        koujyoSymNaiyou3.setKoujyosyoumeigk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        koujyoSymNaiyou3.setJyutoustartym(BizDateYM.valueOf(201506));
        koujyoSymNaiyou3.setNyknjskrrkrenno(1);
        koujyoSymNaiyou3.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);

        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        keisanKoujyogaku.setKhozenCommonParam(khozenCommonParam);

        keisanKoujyogaku.exec(syoNo4, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201512"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201512"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(1000), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(1000), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(1000), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(1000), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(1000), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(1000), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201512"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        asKinou.setKinouKbn(C_KinouKbn.BATCH);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        IT_KykKihon kykKihon = new IT_KykKihon("5", syoNo5);
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);

        IT_AnsyuKihon ansyuKihon = new IT_AnsyuKihon("5", syoNo5);

        IT_KykSyouhn kykSyouhn = kykKihon.createKykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn.setSyouhncd("JH05");
        kykSyouhn.setSyouhnsdno(1);
        kykSyouhn.setKyksyouhnrenno(1);
        kykSyouhn.setKykymd(BizDate.valueOf(20151216));

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.createKykSonotaTkyk();
        kykSonotaTkyk.setKbnkey("5");
        kykSonotaTkyk.setSyono(syoNo5);

        IT_KoujyoSymNaiyou koujyoSymNaiyou = kykKihon.createKoujyoSymNaiyou();
        koujyoSymNaiyou.setSyouhncd("JH05");
        koujyoSymNaiyou.setRenno3keta(1);
        koujyoSymNaiyou.setKoujyosyoumeinnd("2015");
        koujyoSymNaiyou.setSyoumeistartym(BizDateYM.valueOf(201505));
        koujyoSymNaiyou.setSyoumeiendym(BizDateYM.valueOf(201509));
        koujyoSymNaiyou.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.BLNK);
        koujyoSymNaiyou.setTekiyouseidokbn(C_TekiyouseidoKbn.NEWSD);
        koujyoSymNaiyou.setKoujyosyoumeigk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        koujyoSymNaiyou.setJyutoustartym(BizDateYM.valueOf(201506));
        koujyoSymNaiyou.setNyknjskrrkrenno(1);
        koujyoSymNaiyou.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);

        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        keisanKoujyogaku.setKhozenCommonParam(khozenCommonParam);

        keisanKoujyogaku.exec(syoNo5, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201512"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201512"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201512"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo6, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), null, "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        //        IT_KykKihon kykKihon = new IT_KykKihon("7", syoNo7);
        //        kykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        //
        //        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        //        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        //
        //        IT_KoujyoSymNaiyou koujyoSymNaiyou = kykKihon.createKoujyoSymNaiyou();
        //        koujyoSymNaiyou.setSyoumeistartym(BizDateYM.valueOf(201512));
        //        koujyoSymNaiyou.setSyoumeiendym(BizDateYM.valueOf(201512));
        //

        keisanKoujyogaku.exec(syoNo7, "2015");

        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201512"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo8, "2015");

        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), null, "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo9, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201511"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(),  BizDateYM.valueOf("201601"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(500), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(500), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(500), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(500), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(900), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(900), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(900), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(900), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(2100), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(2100), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(2100), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(2100), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201601"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo10, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), null, "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo11, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), null, "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo12, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201511"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201601"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(2000), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(2000), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(2000), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(2000), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201601"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo13, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201511"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201601"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(1000), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(1000), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(1000), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(1000), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201601"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo14, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201511"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201602"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(500), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(500), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(500), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(500), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(900), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(900), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(900), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(900), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(3000), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(3000), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(3000), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(3000), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201602"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo15, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201512"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201508"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(2914), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(2914), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(2914), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(2914), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201508"), "最終証明終了年月");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {

        asKinou.setKinouKbn(C_KinouKbn.BATCH);

        try {

            IT_KykKihon kykKihon = new IT_KykKihon("6", syoNo16);
            IT_AnsyuKihon ansyuKihon = new IT_AnsyuKihon("6", syoNo16);

            KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
            khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
            khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
            khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

            keisanKoujyogaku.setKhozenCommonParam(khozenCommonParam);
            keisanKoujyogaku.exec(syoNo16, "2015");

        } catch (AssertionError e) {
            exStringEquals(e.getMessage(), "契約商品テーブル  取得エラー  証券番号＝17806000161", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo17, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201506"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201508"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(1454), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(1854), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiHaitoukin(), BizCurrency.valueOf(100), "新制度一般実績配当金");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanHaitoukin(), BizCurrency.valueOf(100), "新制度一般年間配当金");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(1354), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(1754), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(1454), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(1854), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(1454), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(1854), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(400), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(400), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201512"), "最終証明終了年月");

    }


    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        YuyuHozenConfig.getInstance().setKoujyoSymZeiseiKaiseiYmd(BizDate.valueOf("20151217"));

        keisanKoujyogaku.exec(syoNo18, "2015");

        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), null, "最終証明終了年月");


    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        YuyuHozenConfig.getInstance().setKoujyoSymZeiseiKaiseiYmd(BizDate.valueOf("20151215"));

        keisanKoujyogaku.exec(syoNo19, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201504"), "最終証明終了年月");


    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_A20() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        YuyuHozenConfig.getInstance().setKoujyoSymZeiseiKaiseiYmd(BizDate.valueOf("20151217"));

        keisanKoujyogaku.exec(syoNo20, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201506"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201506"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(1454), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(1454), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(1454), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(1454), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(700), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(700), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201411"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_A21() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        YuyuHozenConfig.getInstance().setKoujyoSymZeiseiKaiseiYmd(BizDate.valueOf("20151217"));

        keisanKoujyogaku.exec(syoNo23, "2015");

        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), null, "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_A22() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        YuyuHozenConfig.getInstance().setKoujyoSymZeiseiKaiseiYmd(BizDate.valueOf("20151217"));

        keisanKoujyogaku.exec(syoNo29, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201506"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_A23() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        YuyuHozenConfig.getInstance().setKoujyoSymZeiseiKaiseiYmd(BizDate.valueOf("20151215"));

        keisanKoujyogaku.exec(syoNo30, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201506"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201506"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(1454), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(1454), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(1454), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(1454), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201506"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_A24() {

        asKinou.setKinouKbn(C_KinouKbn.BATCH);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        IT_KykKihon kykKihon = new IT_KykKihon("01", syoNo31);
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);

        IT_AnsyuKihon ansyuKihon = new IT_AnsyuKihon("01", syoNo31);

        IT_KykSyouhn kykSyouhn = kykKihon.createKykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn.setSyouhncd("JH31");
        kykSyouhn.setSyouhnsdno(1);
        kykSyouhn.setKyksyouhnrenno(1);
        kykSyouhn.setKykymd(BizDate.valueOf(20151216));

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.createKykSonotaTkyk();
        kykSonotaTkyk.setKbnkey("01");
        kykSonotaTkyk.setSyono(syoNo31);

        IT_KoujyoSymNaiyou koujyoSymNaiyou = kykKihon.createKoujyoSymNaiyou();
        koujyoSymNaiyou.setSyouhncd("JH31");
        koujyoSymNaiyou.setRenno3keta(1);
        koujyoSymNaiyou.setKoujyosyoumeinnd("2015");
        koujyoSymNaiyou.setSyoumeistartym(BizDateYM.valueOf(201505));
        koujyoSymNaiyou.setSyoumeiendym(BizDateYM.valueOf(201509));
        koujyoSymNaiyou.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.BLNK);
        koujyoSymNaiyou.setTekiyouseidokbn(C_TekiyouseidoKbn.NEWSD);
        koujyoSymNaiyou.setKoujyosyoumeigk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        koujyoSymNaiyou.setJyutoustartym(BizDateYM.valueOf(201506));
        koujyoSymNaiyou.setNyknjskrrkrenno(1);
        koujyoSymNaiyou.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);

        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        keisanKoujyogaku.setKhozenCommonParam(khozenCommonParam);

        keisanKoujyogaku.exec(syoNo31, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201512"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201512"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201512"), "最終証明終了年月");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(250)
    public void testExec_A25() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            keisanKoujyogaku.exec(syoNo32, "2015");

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。案内収納基本テーブル  取得エラー  証券番号＝17806000323", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testExec_A26() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        YuyuHozenConfig.getInstance().setKoujyoSymZeiseiKaiseiYmd(BizDate.valueOf("20151217"));

        keisanKoujyogaku.setKhozenCommonParam(khozenCommonParam);

        keisanKoujyogaku.exec(syoNo33, "2015");

        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(),null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201506"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testExec_A27() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        YuyuHozenConfig.getInstance().setKoujyoSymZeiseiKaiseiYmd(BizDate.valueOf("20151217"));

        keisanKoujyogaku.setKhozenCommonParam(khozenCommonParam);

        keisanKoujyogaku.exec(syoNo34, "2015");

        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201506"), "最終証明終了年月");

    }
    @Test
    @Transactional
    @TestOrder(280)
    public void testExec_A28() {

        MockObjectManager.initialize();
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI);

        YuyuHozenConfig.getInstance().setKoujyoSymZeiseiKaiseiYmd(BizDate.valueOf("20151217"));

        keisanKoujyogaku.setKhozenCommonParam(khozenCommonParam);

        keisanKoujyogaku.exec(syoNo35, "2017");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(5500), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(5500), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(),  BizDateYM.valueOf("201511"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(290)
    public void testExec_A29() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);



        keisanKoujyogaku.exec(syoNo36, "2015");

        exClassificationEquals(keisanKoujyogaku.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exStringEquals(keisanKoujyogaku.getMessage(),  "月払前納保険料の充当期間中に複数回の精算が行われているため計算できません。", "メッセージ");
        exStringEquals(keisanKoujyogaku.getMessageCode(), "3001", "メッセージコード");

    }

    @Test
    @Transactional
    @TestOrder(300)
    public void testExec_A30() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo37, "2015");


        exClassificationEquals(keisanKoujyogaku.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exStringEquals(keisanKoujyogaku.getMessage(),  "死亡に伴う未収Ｐの入金が行われているため計算できません。", "メッセージ");
        exStringEquals(keisanKoujyogaku.getMessageCode(), "3002", "メッセージコード");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(310)
    public void testExec_A31() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);


        try {
            keisanKoujyogaku.exec(syoNo38, "2015");

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。前納テーブル  取得エラー  証券番号＝11807111152", "エラーメッセージ");
            throw e;
        }


    }


    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(320)
    public void testExec_A32() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            keisanKoujyogaku.exec(syoNo39, "2015");

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。商品属性マスタ  取得エラー  証券番号＝11807111129", "エラーメッセージ");
            throw e;
        }
    }


    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(330)
    public void testExec_A33() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            keisanKoujyogaku.exec(syoNo40, "2015");

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。商品属性マスタ  取得エラー  証券番号＝11807111211", "エラーメッセージ");
            throw e;
        }
    }


    @Test
    @Transactional
    @TestOrder(340)
    public void testExec_A34() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            MockObjectManager.initialize();
            KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
            keisanKoujyogaku.exec(syoNo41, "2015");

        } catch (CommonBizAppException e) {


            List<KhWkgtZennouKoujyogakuBean> bean = (List<KhWkgtZennouKoujyogakuBean>)MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "exec", 0, 0);
            exClassificationEquals(bean.get(0).getKoujyosyoumeipKbn(), null, "控除証明保険料区分");
            assertNull(bean);

            throw e;
        }


    }

    @Test
    @Transactional
    @TestOrder(350)
    public void testExec_A35() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN2;
        keisanKoujyogaku.exec(syoNo42, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201506"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201506"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(10905), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(34205), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(10905), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(34205), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(23300), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(23300), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(23300), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(23300), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201511"), "最終証明終了年月");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 0), BizCurrency.valueOf(123456), "控除証明用前納入金額");
        exStringEquals((String) MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 1), "2017", "控除証明用前納期間（月）");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 2), BizDate.valueOf(20181010), "控除証明用前納開始年月日");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 3), null, "払込保険料");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 4),  C_Hrkkaisuu.TUKI, "払込回数");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 5), BizDateYM.valueOf(201507), "証明開始年月");
        exStringEquals( MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 6).toString(), "0", "証明回数（年）");
        exStringEquals( MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 7).toString(), "5", "証明回数（月）");

        exClassificationEquals(keisanKoujyogaku.getChkkekkaKbn(), null, "チェック結果区分");
        exStringEquals(keisanKoujyogaku.getMessage(),  null, "メッセージ");
        exStringEquals(keisanKoujyogaku.getMessageCode(), null, "メッセージコード");

    }

    @Test
    @Transactional
    @TestOrder(360)
    public void testExec_A36() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo43, "2015");


        exClassificationEquals(keisanKoujyogaku.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exStringEquals(keisanKoujyogaku.getMessage(),  "死亡に伴う未収Ｐの入金が行われているため計算できません。", "メッセージ");
        exStringEquals(keisanKoujyogaku.getMessageCode(), "3002", "メッセージコード");
    }


    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(370)
    public void testExec_A37() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            keisanKoujyogaku.exec(syoNo44, "2015");

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約商品テーブル、契約商品履歴テーブル  取得エラー  証券番号＝11807111174  変更識別キー＝1", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(380)
    public void testExec_A38() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN3;

        keisanKoujyogaku.exec(syoNo46, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201507"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(),  BizDateYM.valueOf("201508"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(8724), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(8724), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiHaitoukin(), BizCurrency.valueOf(600), "新制度一般実績配当金");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanHaitoukin(), BizCurrency.valueOf(600), "新制度一般年間配当金");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(8124), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(8124), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(23300), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(23300), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201511"), "最終証明終了年月");

        exClassificationEquals(keisanKoujyogaku.getChkkekkaKbn(), null, "チェック結果区分");
        exStringEquals(keisanKoujyogaku.getMessage(),  null, "メッセージ");
        exStringEquals(keisanKoujyogaku.getMessageCode(), null, "メッセージコード");

    }

    @Test
    @Transactional
    @TestOrder(390)
    public void testExec_A39() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN3;

        keisanKoujyogaku.exec(syoNo45, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201506"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(),  BizDateYM.valueOf("201507"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(3308), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(3308), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(3308), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(3308), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201507"), "最終証明終了年月");

        exClassificationEquals(keisanKoujyogaku.getChkkekkaKbn(), null, "チェック結果区分");
        exStringEquals(keisanKoujyogaku.getMessage(),  null, "メッセージ");
        exStringEquals(keisanKoujyogaku.getMessageCode(), null, "メッセージコード");

    }

    @Test
    @Transactional
    @TestOrder(400)
    public void testExec_A40() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo47, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201511"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(),  BizDateYM.valueOf("201512"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiHaitoukin(), BizCurrency.valueOf(0), "新制度一般実績配当金");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanHaitoukin(), BizCurrency.valueOf(0), "新制度一般年間配当金");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201512"), "最終証明終了年月");

        exClassificationEquals(keisanKoujyogaku.getChkkekkaKbn(), null, "チェック結果区分");
        exStringEquals(keisanKoujyogaku.getMessage(),  null, "メッセージ");
        exStringEquals(keisanKoujyogaku.getMessageCode(), null, "メッセージコード");

    }


    @Test
    @Transactional
    @TestOrder(410)
    public void testExec_A41() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo48, "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiHaitoukin(), BizCurrency.valueOf(0), "新制度一般実績配当金");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanHaitoukin(), BizCurrency.valueOf(0), "新制度一般年間配当金");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201602"), "最終証明終了年月");

        exClassificationEquals(keisanKoujyogaku.getChkkekkaKbn(), null, "チェック結果区分");
        exStringEquals(keisanKoujyogaku.getMessage(),  null, "メッセージ");
        exStringEquals(keisanKoujyogaku.getMessageCode(), null, "メッセージコード");

    }

    @Test
    @Transactional
    @TestOrder(420)
    public void testExec_A42() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo49, "2015");


        exClassificationEquals(keisanKoujyogaku.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exStringEquals(keisanKoujyogaku.getMessage(),  "", "メッセージ");
        exStringEquals(keisanKoujyogaku.getMessageCode(), "4003", "メッセージコード");
    }

    @Test
    @Transactional
    @TestOrder(430)
    public void testExec_A43() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN3;

        keisanKoujyogaku.exec("17806000518", "2015");

        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201507"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(),  BizDateYM.valueOf("201508"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(8724), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(8724), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiHaitoukin(), BizCurrency.valueOf(600), "新制度一般実績配当金");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanHaitoukin(), BizCurrency.valueOf(600), "新制度一般年間配当金");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(8124), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(8124), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(23300), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(23300), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201511"), "最終証明終了年月");

        exClassificationEquals(keisanKoujyogaku.getChkkekkaKbn(), null, "チェック結果区分");
        exStringEquals(keisanKoujyogaku.getMessage(),  null, "メッセージ");
        exStringEquals(keisanKoujyogaku.getMessageCode(), null, "メッセージコード");

    }

    @Test
    @Transactional
    @TestOrder(440)
    public void testExec_A44() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN3;

        keisanKoujyogaku.exec("99806001021", "2015");

        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201507"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(),  BizDateYM.valueOf("201508"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(8724), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(8724), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiHaitoukin(), BizCurrency.valueOf(0), "新制度一般実績配当金");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanHaitoukin(), BizCurrency.valueOf(0), "新制度一般年間配当金");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(8724), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(8724), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(23300), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(23300), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201511"), "最終証明終了年月");

        exClassificationEquals(keisanKoujyogaku.getChkkekkaKbn(), null, "チェック結果区分");
        exStringEquals(keisanKoujyogaku.getMessage(),  null, "メッセージ");
        exStringEquals(keisanKoujyogaku.getMessageCode(), null, "メッセージコード");

    }

    @Test
    @Transactional
    @TestOrder(450)
    public void testExec_A45() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo50, "2014");

        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201401"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201403"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(1454), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(1454), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(1454), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(1454), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201403"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(460)
    public void testExec_A46() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo51, "2015");

        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201512"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201512"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(500), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(500), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(500), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(500), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(900), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(900), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(900), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(900), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(3000), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(3000), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(3000), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(3000), "新制度年金年間証明額");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyosyoumeimsgKbn(), C_KoujyosyoumeimsgKbn.BLANK, "控除証明メッセージ区分");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201512"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(470)
    public void testExec_A47() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec(syoNo52, "2030");

        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiHaitoukin(), BizCurrency.valueOf(0), "新制度一般実績配当金");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanHaitoukin(), BizCurrency.valueOf(0), "新制度一般年間配当金");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyosyoumeimsgKbn(), C_KoujyosyoumeimsgKbn.YENHNDSNKKYTGKKSNHK, "控除証明メッセージ区分");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), null, "最終証明終了年月");

        exClassificationEquals(keisanKoujyogaku.getChkkekkaKbn(), null, "チェック結果区分");
        exStringEquals(keisanKoujyogaku.getMessage(),  null, "メッセージ");
        exStringEquals(keisanKoujyogaku.getMessageCode(), null, "メッセージコード");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(480)
    public void testExec_A48() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            YuyuHozenConfig.getInstance().setKoujyoSymZeiseiKaiseiYmd(BizDate.valueOf("20151217"));
            keisanKoujyogaku.exec(syoNo53, "2015");
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。保険料を通貨換算できません。 証券番号 ＝ 11807111679", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(490)
    public void testExec_A49() {

        MockObjectManager.initialize();
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN2;

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            keisanKoujyogaku.exec(syoNo54, "2017");
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。円換算保険料  取得エラー  証券番号＝11807111668", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(500)
    public void testExec_A50() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec("99806001102", "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), null, "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(510)
    public void testExec_A51() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        YuyuHozenConfig.getInstance().setKoujyoSymZeiseiKaiseiYmd(BizDate.valueOf("20151215"));

        keisanKoujyogaku.exec("99806001010", "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), null, "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), null, "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(0), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(0), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(0), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(0), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201503"), "最終証明終了年月");
    }

    @Test
    @Transactional
    @TestOrder(520)
    public void testExec_A52() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec("99806001124", "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201512"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201512"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(5000), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(5000), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(5000), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(5000), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(7000), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(7000), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(7000), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(7000), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(9000), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(9000), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(9000), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(9000), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201512"), "最終証明終了年月");

    }

    @Test
    @Transactional
    @TestOrder(530)
    public void testExec_A53() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec("99806001032", "2015");


        exClassificationEquals(keisanKoujyogaku.getParam().getSinkiSakusei(), null, "新規作成区分");
        exStringEquals(keisanKoujyogaku.getParam().getKoujyoNendo(), null, "控除証明年度");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSyuKbn(), null, "控除証明種類区分");
        exClassificationEquals(keisanKoujyogaku.getParam().getKoujyoSakuseiSyoriKbn(), null, "控除証明作成処理区分");
        exDateEquals(keisanKoujyogaku.getParam().getSyoumeiYmd(), null, "証明日");
        exClassificationEquals(keisanKoujyogaku.getParam().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanKoujyogaku.getParam().getTekiyouSeidoKbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiStartYm(), BizDateYM.valueOf("201511"), "証明開始年月");
        exDateYMEquals(keisanKoujyogaku.getParam().getSyoumeiEndYm(), BizDateYM.valueOf("201512"), "証明終了年月");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiP(), BizCurrency.valueOf(845), "新制度一般実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanP(), BizCurrency.valueOf(845), "新制度一般年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanJissekiSyoumeigk(), BizCurrency.valueOf(845), "新制度一般実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIppanNenkanSyoumeigk(), BizCurrency.valueOf(845), "新制度一般年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiP(), BizCurrency.valueOf(727), "新制度介護医療実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanP(), BizCurrency.valueOf(727), "新制度介護医療年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouJissekiSyoumeigk(), BizCurrency.valueOf(727), "新制度介護医療実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewIryouNenkanSyoumeigk(), BizCurrency.valueOf(727), "新制度介護医療年間証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiP(), BizCurrency.valueOf(0), "新制度年金実績保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanP(), BizCurrency.valueOf(0), "新制度年金年間保険料");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinJissekiSyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(keisanKoujyogaku.getParam().getNewNenkinNenkanSyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");

        exDateYMEquals(keisanKoujyogaku.getEndSyoumeiEndYm(), BizDateYM.valueOf("201512"), "最終証明終了年月");
    }

    @Test
    @Transactional
    @TestOrder(540)
    public void testExec_A54() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        YuyuHozenConfig.getInstance().setKoujyoSymZeiseiKaiseiYmd(BizDate.valueOf("20151215"));

        keisanKoujyogaku.exec("11807111635", "2015");

        exClassificationEquals(keisanKoujyogaku.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exStringEquals(keisanKoujyogaku.getMessage(),  "死亡に伴う未収Ｐの入金が行われているため計算できません。", "メッセージ");
        exStringEquals(keisanKoujyogaku.getMessageCode(), "3002", "メッセージコード");
    }

    @Test
    @Transactional
    @TestOrder(550)
    public void testExec_A55() {

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        keisanKoujyogaku.exec("11807111646", "2015");

        exClassificationEquals(keisanKoujyogaku.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exStringEquals(keisanKoujyogaku.getMessage(),  "死亡に伴う未収Ｐの入金が行われているため計算できません。", "メッセージ");
        exStringEquals(keisanKoujyogaku.getMessageCode(), "3002", "メッセージコード");

    }
}
