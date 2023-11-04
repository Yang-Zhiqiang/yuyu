package yuyu.common.biz.bzdairiten;

import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai.HbSeihoWebMosSyoukaiTest_execPostForm;
import yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai.HbSeihoWebMosSyoukaiTest_execPostForm2;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_Tuukasyu;


/**
 * {@link DairitenTesuuryouInfoSyutoku}のモッククラスです。<br />
 */
public class DairitenTesuuryouInfoSyutokuMockForSinkeiyaku extends DairitenTesuuryouInfoSyutoku {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    @Override
    public DairitenTesuuryouInfoSyutokuKekkaBean exec(DairitenTsrSyutokuYokenBean pDairitenTsrSyutokuYokenBean,
        KeijouYmSyutokuYokenBean pKeijouYmSyutokuYokenBean) {

        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean = SWAKInjector.getInstance(
                    DairitenTesuuryouInfoSyutokuKekkaBean.class);
                CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
                super.exec(pDairitenTsrSyutokuYokenBean, pKeijouYmSyutokuYokenBean);
                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.ERROR);
                dairitenTesuuryouInfoSyutokuKekkaBean.setTsrSisanKekkaKbn(C_ErrorKbn.OK);
                dairitenTesuuryouInfoSyutokuKekkaBean.setAcsKibanKekkaKbn(C_ErrorKbn.OK);

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean = SWAKInjector.getInstance(
                    DairitenTesuuryouInfoSyutokuKekkaBean.class);
                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
                dairitenTesuuryouInfoSyutokuKekkaBean.setTsrSisanKekkaKbn(C_ErrorKbn.ERROR);

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean = SWAKInjector.getInstance(
                    DairitenTesuuryouInfoSyutokuKekkaBean.class);
                dairitenTesuuryouInfoSyutokuKekkaBean.setTsryCd("8888888");
                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
                dairitenTesuuryouInfoSyutokuKekkaBean.setTsrSisanKekkaKbn(C_ErrorKbn.OK);
                dairitenTesuuryouInfoSyutokuKekkaBean.setAcsKibanKekkaKbn(C_ErrorKbn.ERROR);

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean = SWAKInjector.getInstance(
                    DairitenTesuuryouInfoSyutokuKekkaBean.class);
                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
                dairitenTesuuryouInfoSyutokuKekkaBean.setTsrSisanKekkaKbn(C_ErrorKbn.OK);

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }else if (TESTPATTERN5.equals(SYORIPTN)) {
                DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean = SWAKInjector.getInstance(
                    DairitenTesuuryouInfoSyutokuKekkaBean.class);
                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
                dairitenTesuuryouInfoSyutokuKekkaBean.setTsrSisanKekkaKbn(C_ErrorKbn.OK);
                dairitenTesuuryouInfoSyutokuKekkaBean.setTsryCd("T001");

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }else if (TESTPATTERN6.equals(SYORIPTN)) {
                DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean = SWAKInjector.getInstance(
                    DairitenTesuuryouInfoSyutokuKekkaBean.class);
                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
                dairitenTesuuryouInfoSyutokuKekkaBean.setTsrSisanKekkaKbn(C_ErrorKbn.OK);
                dairitenTesuuryouInfoSyutokuKekkaBean.setAcsKibanKekkaKbn(C_ErrorKbn.ERROR);
                dairitenTesuuryouInfoSyutokuKekkaBean.setTsryCd("T001");

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }else if (TESTPATTERN7.equals(SYORIPTN)) {

                pDairitenTsrSyutokuYokenBean.setSyuKeiyakuPTuukaSyu(null);
                return super.exec(pDairitenTsrSyutokuYokenBean, pKeijouYmSyutokuYokenBean);

            }else if (TESTPATTERN8.equals(SYORIPTN)) {


                throw new CommonBizAppException("他システム連動用区分値変換に失敗しました。"
                    + "区分名：" + "払込回数区分" + "　　区分値：" + "2");

            }  else if (TESTPATTERN9.equals(SYORIPTN)) {
                DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean = SWAKInjector.getInstance(
                    DairitenTesuuryouInfoSyutokuKekkaBean.class);
                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
                dairitenTesuuryouInfoSyutokuKekkaBean.setTsrSisanKekkaKbn(C_ErrorKbn.OK);
                dairitenTesuuryouInfoSyutokuKekkaBean.setAcsKibanKekkaKbn(C_ErrorKbn.OK);
                dairitenTesuuryouInfoSyutokuKekkaBean.setTsryCd("T001");
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryRuiGkYen(BizCurrency.valueOf(1100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruiGkYen(BizCurrency.valueOf(2100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSoutsryGkYen(BizCurrency.valueOf(3100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryRuiGkGaika(BizCurrency.valueOf(200 ,BizCurrencyTypes.DOLLAR));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryruigkTuukasyu(C_Tuukasyu.USD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruiGkGaika(BizCurrency.valueOf(300,BizCurrencyTypes.DOLLAR));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruigkTuukasyu(C_Tuukasyu.USD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setSoutsryGkGaika(BizCurrency.valueOf(400,BizCurrencyTypes.DOLLAR));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSoutsrygkTuukasyu(C_Tuukasyu.USD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryGkYen(BizCurrency.valueOf(200,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryGkYen(BizCurrency.valueOf(8100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryGkKykTuuka(BizCurrency.valueOf(9100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryGkKykTuuka(BizCurrency.valueOf(100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsrygkTuukasyu(C_Tuukasyu.USD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsrygkTuukasyu(C_Tuukasyu.USD);

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }
        }

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            if (TESTPATTERN8.equals(SYORIPTN)) {

                DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean = SWAKInjector.getInstance(
                    DairitenTesuuryouInfoSyutokuKekkaBean.class);

                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
                dairitenTesuuryouInfoSyutokuKekkaBean.setTsrSisanKekkaKbn(C_ErrorKbn.ERROR);
                dairitenTesuuryouInfoSyutokuKekkaBean.setAcsKibanKekkaKbn(C_ErrorKbn.OK);
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryRuiGkYen(BizCurrency.valueOf(1100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruiGkYen(BizCurrency.valueOf(2100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSoutsryGkYen(BizCurrency.valueOf(3100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryRuiGkGaika(BizCurrency.valueOf(4100,BizCurrencyTypes.DOLLAR));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryruigkTuukasyu(C_Tuukasyu.USD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruiGkGaika(BizCurrency.valueOf(5100,BizCurrencyTypes.DOLLAR));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruigkTuukasyu(C_Tuukasyu.USD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setSoutsryGkGaika(BizCurrency.valueOf(6100,BizCurrencyTypes.DOLLAR));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSoutsrygkTuukasyu(C_Tuukasyu.USD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryGkYen(BizCurrency.valueOf(7100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryGkYen(BizCurrency.valueOf(8100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryGkKykTuuka(BizCurrency.valueOf(9100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryGkKykTuuka(BizCurrency.valueOf(11000,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsrygkTuukasyu(C_Tuukasyu.USD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsrygkTuukasyu(C_Tuukasyu.USD);

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }else if (TESTPATTERN9.equals(SYORIPTN)) {

                DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean = SWAKInjector.getInstance(
                    DairitenTesuuryouInfoSyutokuKekkaBean.class);

                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
                dairitenTesuuryouInfoSyutokuKekkaBean.setTsrSisanKekkaKbn(C_ErrorKbn.OK);
                dairitenTesuuryouInfoSyutokuKekkaBean.setAcsKibanKekkaKbn(C_ErrorKbn.OK);
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryRuiGkYen(BizCurrency.valueOf(1100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruiGkYen(BizCurrency.valueOf(2100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSoutsryGkYen(BizCurrency.valueOf(3100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryRuiGkGaika(BizCurrency.valueOf(4100,BizCurrencyTypes.DOLLAR));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryruigkTuukasyu(C_Tuukasyu.USD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruiGkGaika(BizCurrency.valueOf(5100,BizCurrencyTypes.DOLLAR));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruigkTuukasyu(C_Tuukasyu.USD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setSoutsryGkGaika(BizCurrency.valueOf(6100,BizCurrencyTypes.DOLLAR));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSoutsrygkTuukasyu(C_Tuukasyu.USD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryGkYen(BizCurrency.valueOf(7100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryGkYen(BizCurrency.valueOf(8100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryGkKykTuuka(BizCurrency.valueOf(9100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryGkKykTuuka(BizCurrency.valueOf(11000,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsrygkTuukasyu(C_Tuukasyu.USD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsrygkTuukasyu(C_Tuukasyu.USD);

                return dairitenTesuuryouInfoSyutokuKekkaBean;

            }else if (TESTPATTERN10.equals(SYORIPTN)) {

                DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean = SWAKInjector.getInstance(
                    DairitenTesuuryouInfoSyutokuKekkaBean.class);

                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
                dairitenTesuuryouInfoSyutokuKekkaBean.setTsrSisanKekkaKbn(C_ErrorKbn.OK);
                dairitenTesuuryouInfoSyutokuKekkaBean.setAcsKibanKekkaKbn(C_ErrorKbn.OK);
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryRuiGkYen(BizCurrency.valueOf(1100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruiGkYen(BizCurrency.valueOf(2100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSoutsryGkYen(BizCurrency.valueOf(3100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryRuiGkGaika(BizCurrency.valueOf(4100,BizCurrencyTypes.AU_DOLLAR));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryruigkTuukasyu(C_Tuukasyu.AUD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruiGkGaika(BizCurrency.valueOf(5100,BizCurrencyTypes.AU_DOLLAR));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruigkTuukasyu(C_Tuukasyu.AUD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setSoutsryGkGaika(BizCurrency.valueOf(6100,BizCurrencyTypes.AU_DOLLAR));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSoutsrygkTuukasyu(C_Tuukasyu.AUD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryGkYen(BizCurrency.valueOf(7100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryGkYen(BizCurrency.valueOf(8100,BizCurrencyTypes.YEN));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryGkKykTuuka(BizCurrency.valueOf(9100,BizCurrencyTypes.AU_DOLLAR));
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryGkKykTuuka(BizCurrency.valueOf(11000,BizCurrencyTypes.AU_DOLLAR));
                dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsrygkTuukasyu(C_Tuukasyu.AUD);
                dairitenTesuuryouInfoSyutokuKekkaBean.setJitsrygkTuukasyu(C_Tuukasyu.AUD);

                return dairitenTesuuryouInfoSyutokuKekkaBean;

            }
        }

        if (caller == HbSeihoWebMosSyoukaiTest_execPostForm.class) {

            DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean = SWAKInjector.getInstance(
                DairitenTesuuryouInfoSyutokuKekkaBean.class);

            if (TESTPATTERN1.equals(SYORIPTN)) {
                super.exec(pDairitenTsrSyutokuYokenBean, pKeijouYmSyutokuYokenBean);
                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.ERROR);

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                super.exec(pDairitenTsrSyutokuYokenBean, pKeijouYmSyutokuYokenBean);

                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
                dairitenTesuuryouInfoSyutokuKekkaBean.setKeijyouYmSyoukaiKekkaKbn(C_ErrorKbn.ERROR);

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                super.exec(pDairitenTsrSyutokuYokenBean, pKeijouYmSyutokuYokenBean);

                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
                dairitenTesuuryouInfoSyutokuKekkaBean.setKeijyouYmSyoukaiKekkaKbn(C_ErrorKbn.OK);
                dairitenTesuuryouInfoSyutokuKekkaBean.setKeijyouYm(BizDateYM.valueOf(201603));

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }

            return dairitenTesuuryouInfoSyutokuKekkaBean;
        }

        if (caller == HbSeihoWebMosSyoukaiTest_execPostForm2.class) {

            DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean = SWAKInjector.getInstance(
                DairitenTesuuryouInfoSyutokuKekkaBean.class);

            if (TESTPATTERN1.equals(SYORIPTN)) {
                super.exec(pDairitenTsrSyutokuYokenBean, pKeijouYmSyutokuYokenBean);
                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.ERROR);

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                super.exec(pDairitenTsrSyutokuYokenBean, pKeijouYmSyutokuYokenBean);

                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
                dairitenTesuuryouInfoSyutokuKekkaBean.setKeijyouYmSyoukaiKekkaKbn(C_ErrorKbn.ERROR);

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                super.exec(pDairitenTsrSyutokuYokenBean, pKeijouYmSyutokuYokenBean);

                dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
                dairitenTesuuryouInfoSyutokuKekkaBean.setKeijyouYmSyoukaiKekkaKbn(C_ErrorKbn.OK);
                dairitenTesuuryouInfoSyutokuKekkaBean.setKeijyouYm(BizDateYM.valueOf(201603));

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }

            return dairitenTesuuryouInfoSyutokuKekkaBean;
        }

        return super.exec(pDairitenTsrSyutokuYokenBean, pKeijouYmSyutokuYokenBean);
    }
}