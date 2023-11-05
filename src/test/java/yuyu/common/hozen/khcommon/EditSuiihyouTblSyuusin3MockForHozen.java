package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Zennou;

/**
 * {@link EditSuiihyouTblSyuusin3MockForHozen}のモッククラスです。<br />
 */
public class EditSuiihyouTblSyuusin3MockForHozen extends EditSuiihyouTblSyuusin3{

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

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public EditSuiihyouTblSyuusin3MockForHozen() {
        super();
    }

    @Override
    public void editTBL(KhozenCommonParam pKkanriCommonParam,
        IT_KykKihon pKykKihon,
        List<IT_KykSyouhn> pKykSyohnSyuLst,
        BizDate pSyoriYmd,
        EditHokenSyoukenParam pEditHokenSyoukenParam,
        C_SinsaihkKbn pCSinsaihkKbn,
        IT_Zennou pZennou) {

        if (caller == EditSyoukenTbltest_editTBL.class) {
            return;
        }

        super.editTBL(pKkanriCommonParam, pKykKihon, pKykSyohnSyuLst, pSyoriYmd, pEditHokenSyoukenParam, pCSinsaihkKbn, pZennou);
    }

    @Override
    public List<SibouSBean> getSibouSBeanList() {

        if (caller == EditSyoukenTbltest_editTBL.class) {

            List<SibouSBean> sibouSBeanList = new ArrayList<SibouSBean>();
            SibouSBean sibouSBean1 = new SibouSBean();
            sibouSBean1.setSibouS(BizCurrency.valueOf(11, BizCurrencyTypes.DOLLAR));
            sibouSBean1.setZennouZndk(BizCurrency.valueOf(12, BizCurrencyTypes.AU_DOLLAR));
            sibouSBean1.setSibouUktrgk(BizCurrency.valueOf(13, BizCurrencyTypes.EURO));
            sibouSBean1.setSibouUktrgkYendaka(BizCurrency.valueOf(14, BizCurrencyTypes.MANYEN));
            sibouSBean1.setSibouUktrgkYen(BizCurrency.valueOf(15));
            sibouSBean1.setSibouUktrgkYenyasu(BizCurrency.valueOf(16));
            sibouSBean1.setCalcKijyunYmd(BizDate.valueOf(20200101));

            SibouSBean sibouSBean2 = new SibouSBean();
            sibouSBean2.setSibouS(BizCurrency.valueOf(21, BizCurrencyTypes.DOLLAR));
            sibouSBean2.setZennouZndk(BizCurrency.valueOf(22, BizCurrencyTypes.AU_DOLLAR));
            sibouSBean2.setSibouUktrgk(BizCurrency.valueOf(23, BizCurrencyTypes.EURO));
            sibouSBean2.setSibouUktrgkYendaka(BizCurrency.valueOf(24, BizCurrencyTypes.MANYEN));
            sibouSBean2.setSibouUktrgkYen(BizCurrency.valueOf(25));
            sibouSBean2.setSibouUktrgkYenyasu(BizCurrency.valueOf(26));
            sibouSBean2.setCalcKijyunYmd(BizDate.valueOf(20200201));

            SibouSBean sibouSBean3 = new SibouSBean();
            sibouSBean3.setSibouS(BizCurrency.valueOf(31, BizCurrencyTypes.DOLLAR));
            sibouSBean3.setZennouZndk(BizCurrency.valueOf(32, BizCurrencyTypes.AU_DOLLAR));
            sibouSBean3.setSibouUktrgk(BizCurrency.valueOf(33, BizCurrencyTypes.EURO));
            sibouSBean3.setSibouUktrgkYendaka(BizCurrency.valueOf(34, BizCurrencyTypes.MANYEN));
            sibouSBean3.setSibouUktrgkYen(BizCurrency.valueOf(35));
            sibouSBean3.setSibouUktrgkYenyasu(BizCurrency.valueOf(36));
            sibouSBean3.setCalcKijyunYmd(BizDate.valueOf(20200301));

            SibouSBean sibouSBean4 = new SibouSBean();
            sibouSBean4.setSibouS(BizCurrency.valueOf(41, BizCurrencyTypes.DOLLAR));
            sibouSBean4.setZennouZndk(BizCurrency.valueOf(42, BizCurrencyTypes.AU_DOLLAR));
            sibouSBean4.setSibouUktrgk(BizCurrency.valueOf(43, BizCurrencyTypes.EURO));
            sibouSBean4.setSibouUktrgkYendaka(BizCurrency.valueOf(44, BizCurrencyTypes.MANYEN));
            sibouSBean4.setSibouUktrgkYen(BizCurrency.valueOf(45));
            sibouSBean4.setSibouUktrgkYenyasu(BizCurrency.valueOf(46));
            sibouSBean4.setCalcKijyunYmd(BizDate.valueOf(20200401));

            SibouSBean sibouSBean5 = new SibouSBean();
            sibouSBean5.setSibouS(BizCurrency.valueOf(51, BizCurrencyTypes.DOLLAR));
            sibouSBean5.setZennouZndk(BizCurrency.valueOf(52, BizCurrencyTypes.AU_DOLLAR));
            sibouSBean5.setSibouUktrgk(BizCurrency.valueOf(53, BizCurrencyTypes.EURO));
            sibouSBean5.setSibouUktrgkYendaka(BizCurrency.valueOf(54, BizCurrencyTypes.MANYEN));
            sibouSBean5.setSibouUktrgkYen(BizCurrency.valueOf(55));
            sibouSBean5.setSibouUktrgkYenyasu(BizCurrency.valueOf(56));
            sibouSBean5.setCalcKijyunYmd(BizDate.valueOf(20200501));

            SibouSBean sibouSBean6 = new SibouSBean();
            sibouSBean6.setCalcKijyunYmd(BizDate.valueOf(20200601));

            SibouSBean sibouSBean7 = new SibouSBean();
            sibouSBean7.setCalcKijyunYmd(BizDate.valueOf(20200701));

            SibouSBean sibouSBean8 = new SibouSBean();
            sibouSBean8.setCalcKijyunYmd(BizDate.valueOf(20200801));

            SibouSBean sibouSBean9 = new SibouSBean();
            sibouSBean9.setCalcKijyunYmd(BizDate.valueOf(20200901));

            SibouSBean sibouSBean10 = new SibouSBean();
            sibouSBean10.setCalcKijyunYmd(BizDate.valueOf(20201001));

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return sibouSBeanList;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                sibouSBeanList.add(sibouSBean1);
                return sibouSBeanList;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                sibouSBeanList.add(sibouSBean1);
                sibouSBeanList.add(sibouSBean2);
                return sibouSBeanList;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                sibouSBeanList.add(sibouSBean1);
                sibouSBeanList.add(sibouSBean2);
                sibouSBeanList.add(sibouSBean3);
                return sibouSBeanList;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                sibouSBeanList.add(sibouSBean1);
                sibouSBeanList.add(sibouSBean2);
                sibouSBeanList.add(sibouSBean3);
                sibouSBeanList.add(sibouSBean4);
                return sibouSBeanList;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                sibouSBeanList.add(sibouSBean1);
                sibouSBeanList.add(sibouSBean2);
                sibouSBeanList.add(sibouSBean3);
                sibouSBeanList.add(sibouSBean4);
                sibouSBeanList.add(sibouSBean5);
                return sibouSBeanList;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                sibouSBeanList.add(sibouSBean1);
                sibouSBeanList.add(sibouSBean2);
                sibouSBeanList.add(sibouSBean3);
                sibouSBeanList.add(sibouSBean4);
                sibouSBeanList.add(sibouSBean5);
                sibouSBeanList.add(sibouSBean6);
                return sibouSBeanList;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {

                sibouSBeanList.add(sibouSBean1);
                sibouSBeanList.add(sibouSBean2);
                sibouSBeanList.add(sibouSBean3);
                sibouSBeanList.add(sibouSBean4);
                sibouSBeanList.add(sibouSBean5);
                sibouSBeanList.add(sibouSBean6);
                sibouSBeanList.add(sibouSBean7);
                return sibouSBeanList;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {

                sibouSBeanList.add(sibouSBean1);
                sibouSBeanList.add(sibouSBean2);
                sibouSBeanList.add(sibouSBean3);
                sibouSBeanList.add(sibouSBean4);
                sibouSBeanList.add(sibouSBean5);
                sibouSBeanList.add(sibouSBean6);
                sibouSBeanList.add(sibouSBean7);
                sibouSBeanList.add(sibouSBean8);
                return sibouSBeanList;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {

                sibouSBeanList.add(sibouSBean1);
                sibouSBeanList.add(sibouSBean2);
                sibouSBeanList.add(sibouSBean3);
                sibouSBeanList.add(sibouSBean4);
                sibouSBeanList.add(sibouSBean5);
                sibouSBeanList.add(sibouSBean6);
                sibouSBeanList.add(sibouSBean7);
                sibouSBeanList.add(sibouSBean8);
                sibouSBeanList.add(sibouSBean9);
                return sibouSBeanList;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {

                sibouSBeanList.add(sibouSBean1);
                sibouSBeanList.add(sibouSBean2);
                sibouSBeanList.add(sibouSBean3);
                sibouSBeanList.add(sibouSBean4);
                sibouSBeanList.add(sibouSBean5);
                sibouSBeanList.add(sibouSBean6);
                sibouSBeanList.add(sibouSBean7);
                sibouSBeanList.add(sibouSBean8);
                sibouSBeanList.add(sibouSBean9);
                sibouSBeanList.add(sibouSBean10);
                return sibouSBeanList;
            }
        }

        return super.getSibouSBeanList();
    }
}
