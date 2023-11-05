package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozentetuduki.dwdenwakaiyakuuketuke.DwDenwaKaiyakuUketukeTest_execPostForm;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormPrepare;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormUpdate;
import yuyu.common.direct.dscommon.CheckKaiyakuUketukeTest_kaiyakusyokaiChk;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全 契約保全共通  解約共通計算計算クラス
 */
public class KeisanCommonKaiyakuMock extends KeisanCommonKaiyaku{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();

    private BizCurrency kaiyakuhrgoukeiYen = null;

    private BizCurrency kaiyakuHrYen = null;

    private BizCurrency yendthnkhrgk = null;

    private BizCurrency gstszeigkyen = null;

    private BizCurrency shrgkkeiyen = null;

    @Override
    public KeisanCommonKaiyakuOutBean getKeisanCommonKaiyakuOutBean () {

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keisanCommonKaiyakuOutBean.setShrgkkeiYen (BizCurrency.valueOf(88888888, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(BizCurrency.valueOf(33333333, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeigk(BizCurrency.valueOf(222222.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setZennouseisankYen(BizCurrency.valueOf(44444444, BizCurrencyTypes.YEN));
            }
        }

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keisanCommonKaiyakuOutBean.setShrgkkeiYen (BizCurrency.valueOf(8888, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setZennouseisankYen(BizCurrency.valueOf(4444, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(BizCurrency.valueOf(33333333, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeigk(BizCurrency.valueOf(222222.00, BizCurrencyTypes.DOLLAR));
            }

        }

        return keisanCommonKaiyakuOutBean;
    }

    @Override
    public C_ErrorKbn keisanKaiyakuseisankin(String pKinouBunrui, IT_KykKihon pKykKihon,
        BizDate pSyoriYmd, KeisanKaiyakuBean pKeisanKaiyakuBean) {

        if(caller == DwKaiyakuUketukeTest_execPostFormPrepare.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                kaiyakuhrgoukeiYen = BizCurrency.valueOf(new BigDecimal("1234546789999"), BizCurrencyTypes.YEN);
                kaiyakuHrYen = BizCurrency.valueOf(new BigDecimal("1234546789012"), BizCurrencyTypes.YEN);
                yendthnkhrgk = BizCurrency.valueOf(new BigDecimal("1234546789012"), BizCurrencyTypes.YEN);
                gstszeigkyen = BizCurrency.valueOf(new BigDecimal("1234546789012"), BizCurrencyTypes.YEN);
                shrgkkeiyen = BizCurrency.valueOf(new BigDecimal("1234546789012"), BizCurrencyTypes.YEN);

                keisanCommonKaiyakuOutBean.setShrgkkeiYen(shrgkkeiyen);
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(kaiyakuhrgoukeiYen);
                keisanCommonKaiyakuOutBean.setKaiyakuHrYen(kaiyakuHrYen);
                keisanCommonKaiyakuOutBean.setYendthnkkaiyakuhr(yendthnkhrgk);
                keisanCommonKaiyakuOutBean.setJpygstszeigk(gstszeigkyen);

                return C_ErrorKbn.OK;
            }
            else if(TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        if(caller == DwKaiyakuUketukeTest_execPostFormUpdate.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                kaiyakuhrgoukeiYen = BizCurrency.valueOf(new BigDecimal("1234546789999"), BizCurrencyTypes.YEN);
                kaiyakuHrYen = BizCurrency.valueOf(new BigDecimal("1234546789012"), BizCurrencyTypes.YEN);
                yendthnkhrgk = BizCurrency.valueOf(new BigDecimal("1234546789012"), BizCurrencyTypes.YEN);
                gstszeigkyen = BizCurrency.valueOf(new BigDecimal("1234546789012"), BizCurrencyTypes.YEN);
                shrgkkeiyen = BizCurrency.valueOf(new BigDecimal("1234546789012"), BizCurrencyTypes.YEN);

                keisanCommonKaiyakuOutBean.setShrgkkeiYen(shrgkkeiyen);
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(kaiyakuhrgoukeiYen);
                keisanCommonKaiyakuOutBean.setKaiyakuHrYen(kaiyakuHrYen);
                keisanCommonKaiyakuOutBean.setYendthnkkaiyakuhr(yendthnkhrgk);
                keisanCommonKaiyakuOutBean.setJpygstszeigk(gstszeigkyen);

                return C_ErrorKbn.OK;
            }
            else if(TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if(caller == CheckKaiyakuUketukeTest_kaiyakusyokaiChk.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if(TESTPATTERN2.equals(SYORIPTN)) {

                shrgkkeiyen = BizCurrency.valueOf(new BigDecimal("1234546789012"), BizCurrencyTypes.YEN);
                keisanCommonKaiyakuOutBean.setShrgkkeiYen(shrgkkeiyen);
                return C_ErrorKbn.OK;
            }
        }

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                shrgkkeiyen = BizCurrency.valueOf(new BigDecimal("100"), BizCurrencyTypes.YEN);
                keisanCommonKaiyakuOutBean.setShrgkkeiYen(shrgkkeiyen);
                return C_ErrorKbn.OK;
            }
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);
    }

}
