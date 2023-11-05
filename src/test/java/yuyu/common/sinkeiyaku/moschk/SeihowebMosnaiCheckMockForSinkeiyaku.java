package yuyu.common.sinkeiyaku.moschk;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_PWaribikitekiyouKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SekmossakuseiKbn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * {@link SeihowebMosnaiCheck}のモッククラスです。<br />
 */
public class SeihowebMosnaiCheckMockForSinkeiyaku extends SeihowebMosnaiCheck{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10= "10";

    public static final String TESTPATTERN11= "11";

    public static final String TESTPATTERN12= "12";

    public static final String TESTPATTERN13= "13";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMP) {

        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                pMP.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);
                pMP.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO);
                pMP.setNyuukinKawaseRate(BizNumber.valueOf(60));

                pMP.getDataSyoriControl().getMosDairitens().get(0).setOyadrtencd("5200025");

                pMP.getDataSyoriControl().getMosKihon().setHhknnen(10);
                pMP.getDataSyoriControl().getMosKihon().setSibouskei(BizCurrency.valueOf(11));
                pMP.getDataSyoriControl().getMosKihon().setSeitoufstpkei(BizCurrency.valueOf(14));
                pMP.getDataSyoriControl().getMosKihon().setFstphrkgk(BizCurrency.valueOf(15));

                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSeitoukihons(BizCurrency.valueOf(12));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSyutkp(BizCurrency.valueOf(13));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setYoteiriritu(BizNumber.valueOf(0.005));

                return;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                pMP.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);
                pMP.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);
                pMP.setNyuukinKawaseRate(BizNumber.valueOf(60));

                pMP.getDataSyoriControl().getMosDairitens().get(0).setOyadrtencd("5200024");

                pMP.getDataSyoriControl().getMosKihon().setHhknnen(10);
                pMP.getDataSyoriControl().getMosKihon().setSibouskei(BizCurrency.valueOf(11));
                pMP.getDataSyoriControl().getMosKihon().setSeitoufstpkei(BizCurrency.valueOf(14));
                pMP.getDataSyoriControl().getMosKihon().setFstphrkgk(BizCurrency.valueOf(15));

                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSeitoukihons(BizCurrency.valueOf(12));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSyutkp(BizCurrency.valueOf(13));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setYoteiriritu(BizNumber.valueOf(0.005));

                return;
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                pMP.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);
                pMP.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);
                pMP.setNyuukinKawaseRate(BizNumber.valueOf(60));

                pMP.getDataSyoriControl().getMosDairitens().get(0).setOyadrtencd("3000330");

                pMP.getDataSyoriControl().getMosKihon().setHhknnen(10);
                pMP.getDataSyoriControl().getMosKihon().setSibouskei(BizCurrency.valueOf(11));
                pMP.getDataSyoriControl().getMosKihon().setSeitoufstpkei(BizCurrency.valueOf(14));
                pMP.getDataSyoriControl().getMosKihon().setFstphrkgk(BizCurrency.valueOf(15));

                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSeitoukihons(BizCurrency.valueOf(12));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSyutkp(BizCurrency.valueOf(13));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setYoteiriritu(BizNumber.valueOf(0.005));

                return;
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                pMP.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);
                pMP.setNyuukinKawaseRate(BizNumber.valueOf(60));

                pMP.getDataSyoriControl().getMosDairitens().get(0).setOyadrtencd("3000896");

                pMP.getDataSyoriControl().getMosKihon().setHhknnen(10);
                pMP.getDataSyoriControl().getMosKihon().setSibouskei(BizCurrency.valueOf(11));
                pMP.getDataSyoriControl().getMosKihon().setSeitoufstpkei(BizCurrency.valueOf(14));
                pMP.getDataSyoriControl().getMosKihon().setFstphrkgk(BizCurrency.valueOf(15));

                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSeitoukihons(BizCurrency.valueOf(12));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSyutkp(BizCurrency.valueOf(13));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setYoteiriritu(BizNumber.valueOf(0.005));

                return;
            }else if (TESTPATTERN5.equals(SYORIPTN)) {
                pMP.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);
                pMP.setSekmossakuseiKbn(C_SekmossakuseiKbn.SISAN);
                pMP.setNyuukinKawaseRate(BizNumber.valueOf(60));

                pMP.getDataSyoriControl().getMosDairitens().get(0).setOyadrtencd("3000896");

                pMP.getDataSyoriControl().getMosKihon().setHhknnen(10);
                pMP.getDataSyoriControl().getMosKihon().setSibouskei(BizCurrency.valueOf(11));
                pMP.getDataSyoriControl().getMosKihon().setSeitoufstpkei(BizCurrency.valueOf(14));
                pMP.getDataSyoriControl().getMosKihon().setFstphrkgk(BizCurrency.valueOf(15));

                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSeitoukihons(BizCurrency.valueOf(12));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSyutkp(BizCurrency.valueOf(13));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setYoteiriritu(BizNumber.valueOf(0.005));

                return;
            }else if (TESTPATTERN6.equals(SYORIPTN)) {
                pMP.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);
                pMP.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);
                pMP.setNyuukinKawaseRate(BizNumber.valueOf(60));

                pMP.getDataSyoriControl().getMosDairitens().get(0).setOyadrtencd("3000897");

                pMP.getDataSyoriControl().getMosKihon().setHhknnen(10);
                pMP.getDataSyoriControl().getMosKihon().setSibouskei(BizCurrency.valueOf(11));
                pMP.getDataSyoriControl().getMosKihon().setSeitoufstpkei(BizCurrency.valueOf(14));
                pMP.getDataSyoriControl().getMosKihon().setFstphrkgk(BizCurrency.valueOf(15));

                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSeitoukihons(BizCurrency.valueOf(12));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSyutkp(BizCurrency.valueOf(13));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setYoteiriritu(BizNumber.valueOf(0.005));

                return;
            }else if (TESTPATTERN7.equals(SYORIPTN)) {
                pMP.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.GAMEN);
                pMP.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);
                pMP.setNyuukinKawaseRate(BizNumber.valueOf(60));

                pMP.getDataSyoriControl().getMosDairitens().get(0).setOyadrtencd("3000897");

                pMP.getDataSyoriControl().getMosKihon().setHhknnen(10);
                pMP.getDataSyoriControl().getMosKihon().setSibouskei(BizCurrency.valueOf(11));
                pMP.getDataSyoriControl().getMosKihon().setSeitoufstpkei(BizCurrency.valueOf(14));
                pMP.getDataSyoriControl().getMosKihon().setFstphrkgk(BizCurrency.valueOf(15));

                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSeitoukihons(BizCurrency.valueOf(12));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSyutkp(BizCurrency.valueOf(13));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setYoteiriritu(BizNumber.valueOf(0.005));

                return;
            }else if (TESTPATTERN8.equals(SYORIPTN)) {

                pMP.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);
                pMP.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);
                pMP.setNyuukinKawaseRate(BizNumber.valueOf(60));

                pMP.getDataSyoriControl().getMosDairitens().get(0).setOyadrtencd("3000897");

                pMP.getDataSyoriControl().getMosKihon().setHhknnen(10);
                pMP.getDataSyoriControl().getMosKihon().setSibouskei(BizCurrency.valueOf(11));
                pMP.getDataSyoriControl().getMosKihon().setSeitoufstpkei(BizCurrency.valueOf(14));
                pMP.getDataSyoriControl().getMosKihon().setFstphrkgk(BizCurrency.valueOf(15));

                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSeitoukihons(BizCurrency.valueOf(12));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSyutkp(BizCurrency.valueOf(13));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setYoteiriritu(BizNumber.valueOf(0.005));

                return;
            }else if (TESTPATTERN9.equals(SYORIPTN)) {

                pMP.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);
                pMP.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);
                pMP.setNyuukinKawaseRate(BizNumber.valueOf(60));

                pMP.getDataSyoriControl().getMosDairitens().get(0).setOyadrtencd("3000897");

                return;
            }else if (TESTPATTERN10.equals(SYORIPTN)) {

                pMP.setSysKbn(null);
                pMP.setKouzokuSyoriJikkouKbn(null);
                pMP.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);
                return;
            }else if (TESTPATTERN11.equals(SYORIPTN)) {

                HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
                String mosNo = syoriCTL.getMosno();
                throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + mosNo);
            }else if (TESTPATTERN12.equals(SYORIPTN)) {

                pMP.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);
                pMP.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);
                pMP.setNyuukinKawaseRate(BizNumber.valueOf(60));

                pMP.getDataSyoriControl().getMosDairitens().get(0).setOyadrtencd("3000897");

                pMP.getDataSyoriControl().getMosKihon().setHhknnen(10);
                pMP.getDataSyoriControl().getMosKihon().setSibouskei(BizCurrency.valueOf(11));
                pMP.getDataSyoriControl().getMosKihon().setSeitoufstpkei(BizCurrency.valueOf(14));
                pMP.getDataSyoriControl().getMosKihon().setFstphrkgk(BizCurrency.valueOf(15));

                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSeitoukihons(BizCurrency.valueOf(1200000000000L));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSyutkp(BizCurrency.valueOf(13));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setYoteiriritu(BizNumber.valueOf(0.005));

                return;
            }else if (TESTPATTERN13.equals(SYORIPTN)) {

                pMP.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);
                pMP.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO);
                pMP.setNyuukinKawaseRate(BizNumber.valueOf(60));

                pMP.getDataSyoriControl().getMosDairitens().get(0).setOyadrtencd("5200025");

                pMP.getDataSyoriControl().getMosKihon().setHhknnen(10);
                pMP.getDataSyoriControl().getMosKihon().setSibouskei(BizCurrency.valueOf(11));
                pMP.getDataSyoriControl().getMosKihon().setSeitoufstpkei(BizCurrency.valueOf(14));
                pMP.getDataSyoriControl().getMosKihon().setFstphrkgk(BizCurrency.valueOf(15));
                pMP.getDataSyoriControl().getMosKihon().setIkkatup(BizCurrency.valueOf(1200000000000L));

                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSeitoukihons(BizCurrency.valueOf(12));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSyutkp(BizCurrency.valueOf(13));
                pMP.getDataSyoriControl().getMosSyouhns().get(0).setYoteiriritu(BizNumber.valueOf(0.005));

                return;
            }
        }

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            pMP.getDataSyoriControl().getMosSyouhns().get(0).setRendouritu(BizNumber.valueOf(0.030));
            pMP.getDataSyoriControl().getMosSyouhns().get(0).setTeikisiharaikin(BizCurrency.valueOf(310, BizCurrencyTypes.DOLLAR));
            pMP.getDataSyoriControl().getMosKihon().setSknnkaisiymd(BizDate.valueOf(20180101));
            pMP.getDataSyoriControl().getMosKihon().setPwaribikitekiyoukbn(C_PWaribikitekiyouKbn.PWARISEIDO_RANK01);

            pMP.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);

            if (TESTPATTERN1.equals(SYORIPTN)) {

                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSyutkp(BizCurrency.valueOf(250, BizCurrencyTypes.DOLLAR));

                return;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {

                pMP.getDataSyoriControl().getMosSyouhns().get(0).setSyutkp(BizCurrency.valueOf(250));

                return;
            }
            return;
        }
        super.exec(pMP);
    }
}
