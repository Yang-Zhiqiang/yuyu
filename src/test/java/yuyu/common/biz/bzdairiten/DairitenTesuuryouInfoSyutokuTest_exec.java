package yuyu.common.biz.bzdairiten;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
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

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infrext.mq.MqApiCaller;
import yuyu.infrext.mq.MqApiCallerStubForSinkeiyaku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * DairitenTesuuryouInfoSyutokuクラスのメソッド {@link DairitenTesuuryouInfoSyutoku#exec(DairitenTsrSyutokuYokenBean, KeijouYmSyutokuYokenBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class DairitenTesuuryouInfoSyutokuTest_exec {

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(MqApiCaller.class).to(MqApiCallerStubForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        MqApiCallerStubForSinkeiyaku.caller = DairitenTesuuryouInfoSyutokuTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MqApiCallerStubForSinkeiyaku.caller = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = null;
        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = null;

        DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku = SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
        DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean =
            dairitenTesuuryouInfoSyutoku.exec(dairitenTsrSyutokuYokenBean, keijouYmSyutokuYokenBean);

        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getMqSyoriKekkaKbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getAcsKibanKekkaKbn(), C_ErrorKbn.ERROR, "ＡＣＳ基盤結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsrSisanKekkaKbn(), C_ErrorKbn.ERROR, "手数料試算結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYmSyoukaiKekkaKbn(), C_ErrorKbn.ERROR, "計上年月照会結果区分");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkYen(), BizCurrency.valueOf(0), "初年度手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkKykTuuka(), BizCurrency.valueOf(0), "初年度手数料額（契通）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkYen(), BizCurrency.valueOf(0), "次年度以降手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkKykTuuka(), BizCurrency.valueOf(0), "次年度以降手数料額（契通）");
        exStringEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsryCd(), "", "手数料コード");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsrygkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料額通貨種類");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsrygkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkYen(), BizCurrency.valueOf(0), "初年度手数料累計額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkGaika(), BizCurrency.valueOf(0), "初年度手数料累計額（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryruigkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料累計額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkYen(), BizCurrency.valueOf(0), "次年度以降手数料累計（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkGaika(), BizCurrency.valueOf(0), "次年度以降手数料累計（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruigkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料累計通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkYen(), BizCurrency.valueOf(0), "総額手数料（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkGaika(), BizCurrency.valueOf(0), "総額手数料（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsrygkTuukasyu(), C_Tuukasyu.BLNK, "総額手数料通貨種類");
        exDateYMEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYm(), null, "計上年月");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(20)
    public void testExec_A2() {

        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = new DairitenTsrSyutokuYokenBean();
        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = new KeijouYmSyutokuYokenBean();

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku = SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
        DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean =
            dairitenTesuuryouInfoSyutoku.exec(dairitenTsrSyutokuYokenBean, keijouYmSyutokuYokenBean);

        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getMqSyoriKekkaKbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getAcsKibanKekkaKbn(), C_ErrorKbn.ERROR, "ＡＣＳ基盤結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsrSisanKekkaKbn(), C_ErrorKbn.ERROR, "手数料試算結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYmSyoukaiKekkaKbn(), C_ErrorKbn.ERROR, "計上年月照会結果区分");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkYen(), BizCurrency.valueOf(0), "初年度手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkKykTuuka(), BizCurrency.valueOf(0), "初年度手数料額（契通）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkYen(), BizCurrency.valueOf(0), "次年度以降手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkKykTuuka(), BizCurrency.valueOf(0), "次年度以降手数料額（契通）");
        exStringEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsryCd(), "", "手数料コード");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsrygkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料額通貨種類");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsrygkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkYen(), BizCurrency.valueOf(0), "初年度手数料累計額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkGaika(), BizCurrency.valueOf(0), "初年度手数料累計額（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryruigkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料累計額通貨種類");

        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkYen(), BizCurrency.valueOf(0), "次年度以降手数料累計（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkGaika(), BizCurrency.valueOf(0), "次年度以降手数料累計（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruigkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料累計通貨種類");

        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkYen(), BizCurrency.valueOf(0), "総額手数料（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkGaika(), BizCurrency.valueOf(0), "総額手数料（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsrygkTuukasyu(), C_Tuukasyu.BLNK, "総額手数料通貨種類");

        exDateYMEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYm(), null, "計上年月");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN1;
        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = new DairitenTsrSyutokuYokenBean();
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuPTuukaSyu(C_Tuukasyu.JPY);
        dairitenTsrSyutokuYokenBean.setOyaDrtenCd("1234567");
        dairitenTsrSyutokuYokenBean.setSyouhnCd("ｱ1");
        dairitenTsrSyutokuYokenBean.setRyourituSdNo("1");
        dairitenTsrSyutokuYokenBean.setSaimankiKeiyakuHyouji("2");
        dairitenTsrSyutokuYokenBean.setHhknNen("27");
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuP(BizCurrency.valueOf(100));
        dairitenTsrSyutokuYokenBean.setDrtenTsryHushrKykHyouji("3");
        dairitenTsrSyutokuYokenBean.setYenKnsnTekiRate(BizNumber.valueOf(200));
        dairitenTsrSyutokuYokenBean.setYoteiRiritu(BizNumber.valueOf(0.0125));
        dairitenTsrSyutokuYokenBean.setCalckijyunymd(BizDate.valueOf(20161018));
        dairitenTsrSyutokuYokenBean.setSyupHrktuuka(BizCurrency.valueOf(110));
        dairitenTsrSyutokuYokenBean.setHrktuukasyu(C_Tuukasyu.USD);
        dairitenTsrSyutokuYokenBean.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikbn(C_IkkatubaraiKbn.BLNK);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);
        dairitenTsrSyutokuYokenBean.setKihonnS(BizCurrency.valueOf(333333333));

        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = null;

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku = SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
        DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean =
            dairitenTesuuryouInfoSyutoku.exec(dairitenTsrSyutokuYokenBean, keijouYmSyutokuYokenBean);

        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getMqSyoriKekkaKbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getAcsKibanKekkaKbn(), C_ErrorKbn.ERROR, "ＡＣＳ基盤結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsrSisanKekkaKbn(), C_ErrorKbn.ERROR, "手数料試算結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYmSyoukaiKekkaKbn(), C_ErrorKbn.ERROR, "計上年月照会結果区分");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkYen(), BizCurrency.valueOf(0), "初年度手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkKykTuuka(), BizCurrency.valueOf(0), "初年度手数料額（契通）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkYen(), BizCurrency.valueOf(0), "次年度以降手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkKykTuuka(), BizCurrency.valueOf(0), "次年度以降手数料額（契通）");
        exStringEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsryCd(), "", "手数料コード");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsrygkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料額通貨種類");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsrygkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkYen(), BizCurrency.valueOf(0), "初年度手数料累計額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkGaika(), BizCurrency.valueOf(0), "初年度手数料累計額（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryruigkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料累計額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkYen(), BizCurrency.valueOf(0), "次年度以降手数料累計（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkGaika(), BizCurrency.valueOf(0), "次年度以降手数料累計（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruigkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料累計通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkYen(), BizCurrency.valueOf(0), "総額手数料（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkGaika(), BizCurrency.valueOf(0), "総額手数料（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsrygkTuukasyu(), C_Tuukasyu.BLNK, "総額手数料通貨種類");
        exDateYMEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYm(), null, "計上年月");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN2;
        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = null;
        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = new KeijouYmSyutokuYokenBean();
        keijouYmSyutokuYokenBean.setTratkiagCd("7654321");
        keijouYmSyutokuYokenBean.setSyouhnCd("ｱ1");
        keijouYmSyutokuYokenBean.setKokutiymd(BizDate.valueOf("20160608"));
        keijouYmSyutokuYokenBean.setSyokaiPRyosyuuYmd(BizDate.valueOf("20160609"));
        keijouYmSyutokuYokenBean.setMosYmd(BizDate.valueOf("20160611"));
        keijouYmSyutokuYokenBean.setMosSyoumetuKbn("1");
        keijouYmSyutokuYokenBean.setBosyuuYm(BizDateYM.valueOf("201606"));
        keijouYmSyutokuYokenBean.setMosSyumtKktYmd(BizDate.valueOf("20160612"));

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku = SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
        DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean =
            dairitenTesuuryouInfoSyutoku.exec(dairitenTsrSyutokuYokenBean, keijouYmSyutokuYokenBean);

        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getMqSyoriKekkaKbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getAcsKibanKekkaKbn(), C_ErrorKbn.ERROR, "ＡＣＳ基盤結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsrSisanKekkaKbn(), C_ErrorKbn.ERROR, "手数料試算結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYmSyoukaiKekkaKbn(), C_ErrorKbn.ERROR, "計上年月照会結果区分");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkYen(), BizCurrency.valueOf(0), "初年度手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkKykTuuka(), BizCurrency.valueOf(0), "初年度手数料額（契通）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkYen(), BizCurrency.valueOf(0), "次年度以降手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkKykTuuka(), BizCurrency.valueOf(0), "次年度以降手数料額（契通）");
        exStringEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsryCd(), "", "手数料コード");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsrygkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料額通貨種類");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsrygkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkYen(), BizCurrency.valueOf(0), "初年度手数料累計額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkGaika(), BizCurrency.valueOf(0), "初年度手数料累計額（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryruigkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料累計額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkYen(), BizCurrency.valueOf(0), "次年度以降手数料累計（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkGaika(), BizCurrency.valueOf(0), "次年度以降手数料累計（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruigkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料累計通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkYen(), BizCurrency.valueOf(0), "総額手数料（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkGaika(), BizCurrency.valueOf(0), "総額手数料（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsrygkTuukasyu(), C_Tuukasyu.BLNK, "総額手数料通貨種類");
        exDateYMEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYm(), null, "計上年月");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN3;
        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = null;
        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = new KeijouYmSyutokuYokenBean();
        keijouYmSyutokuYokenBean.setTratkiagCd("7654321");
        keijouYmSyutokuYokenBean.setSyouhnCd("ｱ1");
        keijouYmSyutokuYokenBean.setMosYmd(BizDate.valueOf("20160611"));
        keijouYmSyutokuYokenBean.setMosSyoumetuKbn("0");
        keijouYmSyutokuYokenBean.setBosyuuYm(BizDateYM.valueOf("201606"));
        keijouYmSyutokuYokenBean.setMosSyumtKktYmd(BizDate.valueOf("20160612"));

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku = SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
        DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean =
            dairitenTesuuryouInfoSyutoku.exec(dairitenTsrSyutokuYokenBean, keijouYmSyutokuYokenBean);

        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getMqSyoriKekkaKbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getAcsKibanKekkaKbn(), C_ErrorKbn.ERROR, "ＡＣＳ基盤結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsrSisanKekkaKbn(), C_ErrorKbn.ERROR, "手数料試算結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYmSyoukaiKekkaKbn(), C_ErrorKbn.ERROR, "計上年月照会結果区分");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkYen(), BizCurrency.valueOf(0), "初年度手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkKykTuuka(), BizCurrency.valueOf(0), "初年度手数料額（契通）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkYen(), BizCurrency.valueOf(0), "次年度以降手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkKykTuuka(), BizCurrency.valueOf(0), "次年度以降手数料額（契通）");
        exStringEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsryCd(), "", "手数料コード");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsrygkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料額通貨種類");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsrygkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkYen(), BizCurrency.valueOf(0), "初年度手数料累計額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkGaika(), BizCurrency.valueOf(0), "初年度手数料累計額（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryruigkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料累計額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkYen(), BizCurrency.valueOf(0), "次年度以降手数料累計（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkGaika(), BizCurrency.valueOf(0), "次年度以降手数料累計（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruigkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料累計通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkYen(), BizCurrency.valueOf(0), "総額手数料（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkGaika(), BizCurrency.valueOf(0), "総額手数料（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsrygkTuukasyu(), C_Tuukasyu.BLNK, "総額手数料通貨種類");
        exDateYMEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYm(), null, "計上年月");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN4;
        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = new DairitenTsrSyutokuYokenBean();
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuPTuukaSyu(C_Tuukasyu.USD);
        dairitenTsrSyutokuYokenBean.setOyaDrtenCd("1234567");
        dairitenTsrSyutokuYokenBean.setSyouhnCd("ｱ1");
        dairitenTsrSyutokuYokenBean.setRyourituSdNo("321");
        dairitenTsrSyutokuYokenBean.setSaimankiKeiyakuHyouji("2");
        dairitenTsrSyutokuYokenBean.setHhknNen("27");
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuP(BizCurrency.valueOf(100));
        dairitenTsrSyutokuYokenBean.setDrtenTsryHushrKykHyouji("3");
        dairitenTsrSyutokuYokenBean.setYenKnsnTekiRate(BizNumber.valueOf(200));
        dairitenTsrSyutokuYokenBean.setYoteiRiritu(BizNumber.valueOf(0.0111));
        dairitenTsrSyutokuYokenBean.setCalckijyunymd(BizDate.valueOf(20161018));
        dairitenTsrSyutokuYokenBean.setSyupHrktuuka(BizCurrency.valueOf(120));
        dairitenTsrSyutokuYokenBean.setHrktuukasyu(C_Tuukasyu.EUR);
        dairitenTsrSyutokuYokenBean.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikbn(C_IkkatubaraiKbn.IKKATU);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.IKKATU6);
        dairitenTsrSyutokuYokenBean.setKihonnS(BizCurrency.valueOf(333333333));
        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = null;

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku = SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
        DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean =
            dairitenTesuuryouInfoSyutoku.exec(dairitenTsrSyutokuYokenBean, keijouYmSyutokuYokenBean);

        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getMqSyoriKekkaKbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getAcsKibanKekkaKbn(), C_ErrorKbn.ERROR, "ＡＣＳ基盤結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsrSisanKekkaKbn(), C_ErrorKbn.ERROR, "手数料試算結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYmSyoukaiKekkaKbn(), C_ErrorKbn.ERROR, "計上年月照会結果区分");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkYen(), BizCurrency.valueOf(0), "初年度手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkKykTuuka(), BizCurrency.valueOf(0), "初年度手数料額（契通）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkYen(), BizCurrency.valueOf(0), "次年度以降手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkKykTuuka(), BizCurrency.valueOf(0), "次年度以降手数料額（契通）");
        exStringEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsryCd(), "", "手数料コード");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsrygkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料額通貨種類");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsrygkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkYen(), BizCurrency.valueOf(0), "初年度手数料累計額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkGaika(), BizCurrency.valueOf(0), "初年度手数料累計額（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryruigkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料累計額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkYen(), BizCurrency.valueOf(0), "次年度以降手数料累計（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkGaika(), BizCurrency.valueOf(0), "次年度以降手数料累計（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruigkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料累計通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkYen(), BizCurrency.valueOf(0), "総額手数料（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkGaika(), BizCurrency.valueOf(0), "総額手数料（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsrygkTuukasyu(), C_Tuukasyu.BLNK, "総額手数料通貨種類");
        exDateYMEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYm(), null, "計上年月");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN5;
        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = new DairitenTsrSyutokuYokenBean();
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuPTuukaSyu(C_Tuukasyu.EUR);
        dairitenTsrSyutokuYokenBean.setOyaDrtenCd("1234567");
        dairitenTsrSyutokuYokenBean.setSyouhnCd("ｱ1");
        dairitenTsrSyutokuYokenBean.setRyourituSdNo("321");
        dairitenTsrSyutokuYokenBean.setSaimankiKeiyakuHyouji("2");
        dairitenTsrSyutokuYokenBean.setHhknNen("27");
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuP(BizCurrency.valueOf(100.34, BizCurrencyTypes.EURO));
        dairitenTsrSyutokuYokenBean.setDrtenTsryHushrKykHyouji("3");
        dairitenTsrSyutokuYokenBean.setYenKnsnTekiRate(BizNumber.valueOf(20.25));
        dairitenTsrSyutokuYokenBean.setYoteiRiritu(BizNumber.valueOf(0.0125));
        dairitenTsrSyutokuYokenBean.setCalckijyunymd(BizDate.valueOf(20161018));
        dairitenTsrSyutokuYokenBean.setSyupHrktuuka(BizCurrency.valueOf(130));
        dairitenTsrSyutokuYokenBean.setHrktuukasyu(C_Tuukasyu.AUD);
        dairitenTsrSyutokuYokenBean.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikbn(C_IkkatubaraiKbn.TEIKIIKKATU);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.IKKATU12);
        dairitenTsrSyutokuYokenBean.setKihonnS(BizCurrency.valueOf(333333333));
        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = new KeijouYmSyutokuYokenBean();
        keijouYmSyutokuYokenBean.setTratkiagCd("7654321");
        keijouYmSyutokuYokenBean.setSyouhnCd("ｱ1");
        keijouYmSyutokuYokenBean.setMosYmd(BizDate.valueOf("20160611"));
        keijouYmSyutokuYokenBean.setMosSyoumetuKbn("0");
        keijouYmSyutokuYokenBean.setBosyuuYm(BizDateYM.valueOf("201606"));
        keijouYmSyutokuYokenBean.setMosSyumtKktYmd(BizDate.valueOf("20160612"));

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku = SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
        DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean =
            dairitenTesuuryouInfoSyutoku.exec(dairitenTsrSyutokuYokenBean, keijouYmSyutokuYokenBean);

        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getMqSyoriKekkaKbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getAcsKibanKekkaKbn(), C_ErrorKbn.OK, "ＡＣＳ基盤結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsrSisanKekkaKbn(), C_ErrorKbn.OK, "手数料試算結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYmSyoukaiKekkaKbn(), C_ErrorKbn.OK, "計上年月照会結果区分");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkYen(), BizCurrency.valueOf(11000123456L), "初年度手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkKykTuuka(), BizCurrency.valueOf(0), "初年度手数料額（契通）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkYen(), BizCurrency.valueOf(13000123456L), "次年度以降手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkKykTuuka(), BizCurrency.valueOf(0), "次年度以降手数料額（契通）");
        exStringEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsryCd(), "1234567", "手数料コード");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsrygkTuukasyu(), C_Tuukasyu.JPY, "初年度手数料額通貨種類");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsrygkTuukasyu(), C_Tuukasyu.JPY, "次年度以降手数料額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkYen(), BizCurrency.valueOf(15000123456L), "初年度手数料累計額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkGaika(), BizCurrency.valueOf(0), "初年度手数料累計額（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryruigkTuukasyu(), C_Tuukasyu.JPY, "初年度手数料累計額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkYen(), BizCurrency.valueOf(17000123456L), "次年度以降手数料累計（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkGaika(), BizCurrency.valueOf(0), "次年度以降手数料累計（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruigkTuukasyu(), C_Tuukasyu.JPY, "次年度以降手数料累計通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkYen(), BizCurrency.valueOf(19000123456L), "総額手数料（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkGaika(), BizCurrency.valueOf(0), "総額手数料（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsrygkTuukasyu(), C_Tuukasyu.JPY, "総額手数料通貨種類");
        exDateYMEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYm(), BizDateYM.valueOf(201606), "計上年月");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN9;
        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = new DairitenTsrSyutokuYokenBean();
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuPTuukaSyu(C_Tuukasyu.AUD);
        dairitenTsrSyutokuYokenBean.setOyaDrtenCd("1234567");
        dairitenTsrSyutokuYokenBean.setSyouhnCd("ｱ1");
        dairitenTsrSyutokuYokenBean.setRyourituSdNo("321");
        dairitenTsrSyutokuYokenBean.setSaimankiKeiyakuHyouji("2");
        dairitenTsrSyutokuYokenBean.setHhknNen("27");
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuP(BizCurrency.valueOf(100));
        dairitenTsrSyutokuYokenBean.setDrtenTsryHushrKykHyouji("3");
        dairitenTsrSyutokuYokenBean.setYenKnsnTekiRate(BizNumber.valueOf(200));
        dairitenTsrSyutokuYokenBean.setYoteiRiritu(BizNumber.valueOf(0.9999));
        dairitenTsrSyutokuYokenBean.setCalckijyunymd(BizDate.valueOf(20161018));
        dairitenTsrSyutokuYokenBean.setSyupHrktuuka(BizCurrency.valueOf(140));
        dairitenTsrSyutokuYokenBean.setHrktuukasyu(C_Tuukasyu.JPY);
        dairitenTsrSyutokuYokenBean.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikbn(C_IkkatubaraiKbn.BLNK);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);
        dairitenTsrSyutokuYokenBean.setKihonnS(BizCurrency.valueOf(333333333));
        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = new KeijouYmSyutokuYokenBean();
        keijouYmSyutokuYokenBean.setTratkiagCd("7654321");
        keijouYmSyutokuYokenBean.setSyouhnCd("ｱ1");
        keijouYmSyutokuYokenBean.setMosYmd(BizDate.valueOf("20160611"));
        keijouYmSyutokuYokenBean.setMosSyoumetuKbn("0");
        keijouYmSyutokuYokenBean.setBosyuuYm(BizDateYM.valueOf("201606"));
        keijouYmSyutokuYokenBean.setMosSyumtKktYmd(BizDate.valueOf("20160612"));

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku = SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
        DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean =
            dairitenTesuuryouInfoSyutoku.exec(dairitenTsrSyutokuYokenBean, keijouYmSyutokuYokenBean);

        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getMqSyoriKekkaKbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getAcsKibanKekkaKbn(), C_ErrorKbn.OK, "ＡＣＳ基盤結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsrSisanKekkaKbn(), C_ErrorKbn.OK, "手数料試算結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYmSyoukaiKekkaKbn(), C_ErrorKbn.OK, "計上年月照会結果区分");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkYen(), BizCurrency.valueOf(0), "初年度手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkKykTuuka(), BizCurrency.valueOf(120001230.45, BizCurrencyTypes.DOLLAR), "初年度手数料額（契通）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkYen(), BizCurrency.valueOf(0), "次年度以降手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkKykTuuka(), BizCurrency.valueOf(140001230.46, BizCurrencyTypes.DOLLAR), "次年度以降手数料額（契通）");
        exStringEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsryCd(), "1234567", "手数料コード");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsrygkTuukasyu(), C_Tuukasyu.USD, "初年度手数料額通貨種類");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsrygkTuukasyu(), C_Tuukasyu.USD, "次年度以降手数料額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkYen(), BizCurrency.valueOf(0), "初年度手数料累計額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkGaika(), BizCurrency.valueOf(160001230.47, BizCurrencyTypes.DOLLAR), "初年度手数料累計額（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryruigkTuukasyu(), C_Tuukasyu.USD, "初年度手数料累計額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkYen(), BizCurrency.valueOf(0), "次年度以降手数料累計（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkGaika(), BizCurrency.valueOf(180001230.48, BizCurrencyTypes.DOLLAR), "次年度以降手数料累計（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruigkTuukasyu(), C_Tuukasyu.USD, "次年度以降手数料累計通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkYen(), BizCurrency.valueOf(0), "総額手数料（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkGaika(), BizCurrency.valueOf(200001230.49, BizCurrencyTypes.DOLLAR), "総額手数料（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsrygkTuukasyu(), C_Tuukasyu.USD, "総額手数料通貨種類");
        exDateYMEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYm(), BizDateYM.valueOf(201606), "計上年月");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(90)
    public void testExec_A9() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN10;
        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = new DairitenTsrSyutokuYokenBean();
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuPTuukaSyu(C_Tuukasyu.BLNK);
        dairitenTsrSyutokuYokenBean.setOyaDrtenCd("1234567");
        dairitenTsrSyutokuYokenBean.setSyouhnCd("ｱ1");
        dairitenTsrSyutokuYokenBean.setRyourituSdNo("1");
        dairitenTsrSyutokuYokenBean.setSaimankiKeiyakuHyouji("2");
        dairitenTsrSyutokuYokenBean.setHhknNen("27");
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuP(BizCurrency.valueOf(100));
        dairitenTsrSyutokuYokenBean.setDrtenTsryHushrKykHyouji("3");
        dairitenTsrSyutokuYokenBean.setYenKnsnTekiRate(BizNumber.valueOf(200));
        dairitenTsrSyutokuYokenBean.setYoteiRiritu(BizNumber.valueOf(0.9999));
        dairitenTsrSyutokuYokenBean.setCalckijyunymd(BizDate.valueOf(20161018));
        dairitenTsrSyutokuYokenBean.setSyupHrktuuka(BizCurrency.valueOf(0));
        dairitenTsrSyutokuYokenBean.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikbn(C_IkkatubaraiKbn.BLNK);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);
        dairitenTsrSyutokuYokenBean.setKihonnS(BizCurrency.valueOf(333333333));
        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = new KeijouYmSyutokuYokenBean();
        keijouYmSyutokuYokenBean.setTratkiagCd("7654321");
        keijouYmSyutokuYokenBean.setSyouhnCd("ｱ1");
        keijouYmSyutokuYokenBean.setMosYmd(BizDate.valueOf("20160611"));
        keijouYmSyutokuYokenBean.setMosSyoumetuKbn("0");
        keijouYmSyutokuYokenBean.setBosyuuYm(BizDateYM.valueOf("201606"));
        keijouYmSyutokuYokenBean.setMosSyumtKktYmd(BizDate.valueOf("20160612"));

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku = SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
        DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean =
            dairitenTesuuryouInfoSyutoku.exec(dairitenTsrSyutokuYokenBean, keijouYmSyutokuYokenBean);

        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getMqSyoriKekkaKbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getAcsKibanKekkaKbn(), C_ErrorKbn.OK, "ＡＣＳ基盤結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsrSisanKekkaKbn(), C_ErrorKbn.OK, "手数料試算結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYmSyoukaiKekkaKbn(), C_ErrorKbn.OK, "計上年月照会結果区分");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkYen(), BizCurrency.valueOf(0), "初年度手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkKykTuuka(), BizCurrency.valueOf(0), "初年度手数料額（契通）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkYen(), BizCurrency.valueOf(0), "次年度以降手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkKykTuuka(), BizCurrency.valueOf(0), "次年度以降手数料額（契通）");
        exStringEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsryCd(), "1234567", "手数料コード");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsrygkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料額通貨種類");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsrygkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkYen(), BizCurrency.valueOf(0), "初年度手数料累計額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkGaika(), BizCurrency.valueOf(0), "初年度手数料累計額（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryruigkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料累計額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkYen(), BizCurrency.valueOf(0), "次年度以降手数料累計（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkGaika(), BizCurrency.valueOf(0), "次年度以降手数料累計（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruigkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料累計通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkYen(), BizCurrency.valueOf(0), "総額手数料（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkGaika(), BizCurrency.valueOf(0), "総額手数料（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsrygkTuukasyu(), C_Tuukasyu.BLNK, "総額手数料通貨種類");
        exDateYMEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYm(), BizDateYM.valueOf(201606), "計上年月");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(100)
    public void testExec_A10() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN6;
        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = new DairitenTsrSyutokuYokenBean();
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuPTuukaSyu(C_Tuukasyu.BLNK);
        dairitenTsrSyutokuYokenBean.setOyaDrtenCd("1234567");
        dairitenTsrSyutokuYokenBean.setSyouhnCd("ｱ1");
        dairitenTsrSyutokuYokenBean.setRyourituSdNo("1");
        dairitenTsrSyutokuYokenBean.setSaimankiKeiyakuHyouji("2");
        dairitenTsrSyutokuYokenBean.setHhknNen("27");
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuP(BizCurrency.valueOf(100));
        dairitenTsrSyutokuYokenBean.setDrtenTsryHushrKykHyouji("3");
        dairitenTsrSyutokuYokenBean.setYenKnsnTekiRate(BizNumber.valueOf(200));
        dairitenTsrSyutokuYokenBean.setYoteiRiritu(BizNumber.valueOf(0.9999));
        dairitenTsrSyutokuYokenBean.setCalckijyunymd(BizDate.valueOf(20161018));
        dairitenTsrSyutokuYokenBean.setSyupHrktuuka(BizCurrency.valueOf(0));
        dairitenTsrSyutokuYokenBean.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikbn(C_IkkatubaraiKbn.BLNK);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);
        dairitenTsrSyutokuYokenBean.setKihonnS(BizCurrency.valueOf(333333333));
        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = new KeijouYmSyutokuYokenBean();
        keijouYmSyutokuYokenBean.setTratkiagCd("7654321");
        keijouYmSyutokuYokenBean.setSyouhnCd("ｱ1");
        keijouYmSyutokuYokenBean.setMosYmd(BizDate.valueOf("20160611"));
        keijouYmSyutokuYokenBean.setMosSyoumetuKbn("0");
        keijouYmSyutokuYokenBean.setBosyuuYm(BizDateYM.valueOf("201606"));
        keijouYmSyutokuYokenBean.setMosSyumtKktYmd(BizDate.valueOf("20160612"));

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku = SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
        DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean =
            dairitenTesuuryouInfoSyutoku.exec(dairitenTsrSyutokuYokenBean, keijouYmSyutokuYokenBean);

        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getMqSyoriKekkaKbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getAcsKibanKekkaKbn(), C_ErrorKbn.OK, "ＡＣＳ基盤結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsrSisanKekkaKbn(), C_ErrorKbn.ERROR, "手数料試算結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYmSyoukaiKekkaKbn(), C_ErrorKbn.ERROR, "計上年月照会結果区分");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkYen(), BizCurrency.valueOf(0), "初年度手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkKykTuuka(), BizCurrency.valueOf(0), "初年度手数料額（契通）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkYen(), BizCurrency.valueOf(0), "次年度以降手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkKykTuuka(), BizCurrency.valueOf(0), "次年度以降手数料額（契通）");
        exStringEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsryCd(), "", "手数料コード");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsrygkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料額通貨種類");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsrygkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkYen(), BizCurrency.valueOf(0), "初年度手数料累計額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkGaika(), BizCurrency.valueOf(0), "初年度手数料累計額（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryruigkTuukasyu(), C_Tuukasyu.BLNK, "初年度手数料累計額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkYen(), BizCurrency.valueOf(0), "次年度以降手数料累計（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkGaika(), BizCurrency.valueOf(0), "次年度以降手数料累計（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruigkTuukasyu(), C_Tuukasyu.BLNK, "次年度以降手数料累計通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkYen(), BizCurrency.valueOf(0), "総額手数料（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkGaika(), BizCurrency.valueOf(0), "総額手数料（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsrygkTuukasyu(), C_Tuukasyu.BLNK, "総額手数料通貨種類");
        exDateYMEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYm(), null, "計上年月");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(110)
    public void testExec_A11() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN7;
        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = new DairitenTsrSyutokuYokenBean();
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuPTuukaSyu(C_Tuukasyu.USD);
        dairitenTsrSyutokuYokenBean.setOyaDrtenCd("1234567");
        dairitenTsrSyutokuYokenBean.setSyouhnCd("ｱ1");
        dairitenTsrSyutokuYokenBean.setRyourituSdNo("321");
        dairitenTsrSyutokuYokenBean.setSaimankiKeiyakuHyouji("2");
        dairitenTsrSyutokuYokenBean.setHhknNen("27");
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuP(BizCurrency.valueOf(100));
        dairitenTsrSyutokuYokenBean.setDrtenTsryHushrKykHyouji("3");
        dairitenTsrSyutokuYokenBean.setYenKnsnTekiRate(BizNumber.valueOf(200));
        dairitenTsrSyutokuYokenBean.setYoteiRiritu(BizNumber.valueOf(0.9999));
        dairitenTsrSyutokuYokenBean.setCalckijyunymd(BizDate.valueOf(20161018));
        dairitenTsrSyutokuYokenBean.setSyupHrktuuka(BizCurrency.valueOf(140));
        dairitenTsrSyutokuYokenBean.setHrktuukasyu(C_Tuukasyu.JPY);
        dairitenTsrSyutokuYokenBean.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikbn(C_IkkatubaraiKbn.BLNK);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);
        dairitenTsrSyutokuYokenBean.setKihonnS(BizCurrency.valueOf(333333333));
        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = new KeijouYmSyutokuYokenBean();
        keijouYmSyutokuYokenBean.setTratkiagCd("7654321");
        keijouYmSyutokuYokenBean.setSyouhnCd("ｱ1");
        keijouYmSyutokuYokenBean.setMosYmd(BizDate.valueOf("20160611"));
        keijouYmSyutokuYokenBean.setMosSyoumetuKbn("0");
        keijouYmSyutokuYokenBean.setBosyuuYm(BizDateYM.valueOf("201606"));
        keijouYmSyutokuYokenBean.setMosSyumtKktYmd(BizDate.valueOf("20160612"));

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku = SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
        DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean =
            dairitenTesuuryouInfoSyutoku.exec(dairitenTsrSyutokuYokenBean, keijouYmSyutokuYokenBean);

        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getMqSyoriKekkaKbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getAcsKibanKekkaKbn(), C_ErrorKbn.OK, "ＡＣＳ基盤結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsrSisanKekkaKbn(), C_ErrorKbn.OK, "手数料試算結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYmSyoukaiKekkaKbn(), C_ErrorKbn.OK, "計上年月照会結果区分");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkYen(), BizCurrency.valueOf(11000123456L), "初年度手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkKykTuuka(), BizCurrency.valueOf(0), "初年度手数料額（契通）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkYen(), BizCurrency.valueOf(13000123456L), "次年度以降手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkKykTuuka(), BizCurrency.valueOf(0), "次年度以降手数料額（契通）");
        exStringEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsryCd(), "1234567", "手数料コード");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsrygkTuukasyu(), C_Tuukasyu.JPY, "初年度手数料額通貨種類");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsrygkTuukasyu(), C_Tuukasyu.JPY, "次年度以降手数料額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkYen(), BizCurrency.valueOf(15000123456L), "初年度手数料累計額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkGaika(), BizCurrency.valueOf(0), "初年度手数料累計額（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryruigkTuukasyu(), C_Tuukasyu.JPY, "初年度手数料累計額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkYen(), BizCurrency.valueOf(0), "次年度以降手数料累計（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkGaika(), BizCurrency.valueOf(180001.2348, BizCurrencyTypes.DOLLAR), "次年度以降手数料累計（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruigkTuukasyu(), C_Tuukasyu.USD, "次年度以降手数料累計通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkYen(), BizCurrency.valueOf(0), "総額手数料（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkGaika(), BizCurrency.valueOf(200001.2349, BizCurrencyTypes.DOLLAR), "総額手数料（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsrygkTuukasyu(), C_Tuukasyu.USD, "総額手数料通貨種類");
        exDateYMEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYm(), BizDateYM.valueOf(201606), "計上年月");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(120)
    public void testExec_A12() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN8;
        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = new DairitenTsrSyutokuYokenBean();
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuPTuukaSyu(C_Tuukasyu.AUD);
        dairitenTsrSyutokuYokenBean.setOyaDrtenCd("1234567");
        dairitenTsrSyutokuYokenBean.setSyouhnCd("ｱ1");
        dairitenTsrSyutokuYokenBean.setRyourituSdNo("321");
        dairitenTsrSyutokuYokenBean.setSaimankiKeiyakuHyouji("2");
        dairitenTsrSyutokuYokenBean.setHhknNen("27");
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuP(BizCurrency.valueOf(100));
        dairitenTsrSyutokuYokenBean.setDrtenTsryHushrKykHyouji("3");
        dairitenTsrSyutokuYokenBean.setYenKnsnTekiRate(BizNumber.valueOf(200));
        dairitenTsrSyutokuYokenBean.setYoteiRiritu(BizNumber.valueOf(0.9999));
        dairitenTsrSyutokuYokenBean.setCalckijyunymd(BizDate.valueOf(20161018));
        dairitenTsrSyutokuYokenBean.setSyupHrktuuka(BizCurrency.valueOf(140));
        dairitenTsrSyutokuYokenBean.setHrktuukasyu(C_Tuukasyu.EUR);
        dairitenTsrSyutokuYokenBean.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikbn(C_IkkatubaraiKbn.BLNK);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);
        dairitenTsrSyutokuYokenBean.setKihonnS(BizCurrency.valueOf(333333333));
        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = new KeijouYmSyutokuYokenBean();
        keijouYmSyutokuYokenBean.setTratkiagCd("7654321");
        keijouYmSyutokuYokenBean.setSyouhnCd("ｱ1");
        keijouYmSyutokuYokenBean.setMosYmd(BizDate.valueOf("20160611"));
        keijouYmSyutokuYokenBean.setMosSyoumetuKbn("0");
        keijouYmSyutokuYokenBean.setBosyuuYm(BizDateYM.valueOf("201606"));
        keijouYmSyutokuYokenBean.setMosSyumtKktYmd(BizDate.valueOf("20160612"));

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku = SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
        DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean =
            dairitenTesuuryouInfoSyutoku.exec(dairitenTsrSyutokuYokenBean, keijouYmSyutokuYokenBean);

        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getMqSyoriKekkaKbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getAcsKibanKekkaKbn(), C_ErrorKbn.OK, "ＡＣＳ基盤結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsrSisanKekkaKbn(), C_ErrorKbn.OK, "手数料試算結果区分");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYmSyoukaiKekkaKbn(), C_ErrorKbn.OK, "計上年月照会結果区分");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkYen(), BizCurrency.valueOf(11000123456L), "初年度手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryGkKykTuuka(), BizCurrency.valueOf(0), "初年度手数料額（契通）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkYen(), BizCurrency.valueOf(13000123456L), "次年度以降手数料額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryGkKykTuuka(), BizCurrency.valueOf(0), "次年度以降手数料額（契通）");
        exStringEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getTsryCd(), "1234567", "手数料コード");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsrygkTuukasyu(), C_Tuukasyu.JPY, "初年度手数料額通貨種類");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsrygkTuukasyu(), C_Tuukasyu.JPY, "次年度以降手数料額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkYen(), BizCurrency.valueOf(0), "初年度手数料累計額（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryRuiGkGaika(), BizCurrency.valueOf(160001.2347, BizCurrencyTypes.EURO), "初年度手数料累計額（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSyotsryruigkTuukasyu(), C_Tuukasyu.EUR, "初年度手数料累計額通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkYen(), BizCurrency.valueOf(0), "次年度以降手数料累計（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruiGkGaika(), BizCurrency.valueOf(180001.2348, BizCurrencyTypes.AU_DOLLAR), "次年度以降手数料累計（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getJitsryruigkTuukasyu(), C_Tuukasyu.AUD, "次年度以降手数料累計通貨種類");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkYen(), BizCurrency.valueOf(0), "総額手数料（円）");
        exBizCalcbleEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsryGkGaika(), BizCurrency.valueOf(200001.2349, BizCurrencyTypes.AU_DOLLAR), "総額手数料（外貨）");
        exClassificationEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getSoutsrygkTuukasyu(), C_Tuukasyu.AUD, "総額手数料通貨種類");
        exDateYMEquals(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYm(), BizDateYM.valueOf(201606), "計上年月");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(130)
    public void testExec_A13() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN8;
        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = new DairitenTsrSyutokuYokenBean();
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuPTuukaSyu(C_Tuukasyu.AUD);
        dairitenTsrSyutokuYokenBean.setOyaDrtenCd("1234567");
        dairitenTsrSyutokuYokenBean.setSyouhnCd("ｱ1");
        dairitenTsrSyutokuYokenBean.setRyourituSdNo("321");
        dairitenTsrSyutokuYokenBean.setSaimankiKeiyakuHyouji("3");
        dairitenTsrSyutokuYokenBean.setHhknNen("27");
        dairitenTsrSyutokuYokenBean.setSyuKeiyakuP(BizCurrency.valueOf(100));
        dairitenTsrSyutokuYokenBean.setDrtenTsryHushrKykHyouji("3");
        dairitenTsrSyutokuYokenBean.setYenKnsnTekiRate(BizNumber.valueOf(200));
        dairitenTsrSyutokuYokenBean.setYoteiRiritu(BizNumber.valueOf(0.9999));
        dairitenTsrSyutokuYokenBean.setCalckijyunymd(BizDate.valueOf(20161018));
        dairitenTsrSyutokuYokenBean.setSyupHrktuuka(BizCurrency.valueOf(140));
        dairitenTsrSyutokuYokenBean.setHrktuukasyu(C_Tuukasyu.EUR);
        dairitenTsrSyutokuYokenBean.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikbn(C_IkkatubaraiKbn.BLNK);
        dairitenTsrSyutokuYokenBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);
        dairitenTsrSyutokuYokenBean.setKihonnS(BizCurrency.valueOf(333333333));
        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = new KeijouYmSyutokuYokenBean();
        keijouYmSyutokuYokenBean.setTratkiagCd("7654321");
        keijouYmSyutokuYokenBean.setSyouhnCd("ｱ1");
        keijouYmSyutokuYokenBean.setMosYmd(BizDate.valueOf("20160611"));
        keijouYmSyutokuYokenBean.setMosSyoumetuKbn("0");
        keijouYmSyutokuYokenBean.setBosyuuYm(BizDateYM.valueOf("201606"));
        keijouYmSyutokuYokenBean.setMosSyumtKktYmd(BizDate.valueOf("20160612"));

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        try{
            DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku = SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
            dairitenTesuuryouInfoSyutoku.exec(dairitenTsrSyutokuYokenBean, keijouYmSyutokuYokenBean);
        }catch(Exception e){
            exStringEquals(e.getMessage(), "システム整合性エラーです。他システム連動用区分値変換に失敗しました。区分名：保険期間歳満期区分　　区分値：3","エラーメッセージ");
        }
    }
}
