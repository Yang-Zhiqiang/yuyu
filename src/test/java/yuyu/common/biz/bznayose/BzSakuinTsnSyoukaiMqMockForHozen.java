package yuyu.common.biz.bznayose;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.hozen.khcommon.CheckHansyaSentakuInfoTest_exec;
import yuyu.common.hozen.khcommon.PALBetuSakuinSyoukaiTest_exec;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * PALあて索引通算照会（MQ）{@link BzSakuinTsnSyoukaiMq}のモッククラスです。<br />
 */
public class BzSakuinTsnSyoukaiMqMockForHozen extends BzSakuinTsnSyoukaiMq {

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

    public static final String TESTPATTERN13 = "13";

    public static final String TESTPATTERN14 = "14";

    public static final String TESTPATTERN15 = "15";

    public static final String TESTPATTERN16 = "16";

    public static final String TESTPATTERN17 = "17";

    public static final String TESTPATTERN18 = "18";

    public static final String TESTPATTERN19 = "19";

    public static final String TESTPATTERN20 = "20";

    public static final String TESTPATTERN21 = "21";

    public static final String TESTPATTERN22 = "22";

    public static final String TESTPATTERN23 = "23";

    public static final String TESTPATTERN24 = "24";
    @Override
    public BzSakuinTsnSyoukaiKekkaBean exec(BzSakuinTsnSyoukaiYokenBean pBzSakuinTsnSyoukaiYokenBean) {
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = SWAKInjector
            .getInstance(BzSakuinTsnSyoukaiKekkaBean.class);

        if(caller == CheckHansyaSentakuInfoTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.NONE);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.HINDOOVERSYORIHUNOU);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.NAYOSEHUMEI);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.HINDOOVERSYORIHUNOU);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.ARI);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.NONE);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.NAYOSEHUMEI);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.ARI);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsysyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsysyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.ARI);
                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN13.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsysyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.NONE);
                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN14.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN15.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
        }

        if(caller == PALBetuSakuinSyoukaiTest_exec.class){
            if(TESTPATTERN1.equals(SYORIPTN)){

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if(TESTPATTERN2.equals(SYORIPTN)){

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.NONE);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if(TESTPATTERN3.equals(SYORIPTN)){

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if(TESTPATTERN4.equals(SYORIPTN)){

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(1);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuu(1);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuu(1);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(1);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuu(1);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuutyoukaumu(C_BlnktkumuKbn.ARI);

                List<BzKeiyakuMfSakuinKekkaBean> keiyakumfsakuinkekkabeanList = new ArrayList<>();
                BzKeiyakuMfSakuinKekkaBean keiyakumfsakuinkekkabean = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                keiyakumfsakuinkekkabean.setKykmfsyono("12803345673");
                keiyakumfsakuinkekkabean.setKykmfkykymd(BizDate.valueOf(20160322));
                keiyakumfsakuinkekkabean.setKykmfsyoumetucd("0001");
                keiyakumfsakuinkekkabean.setKykmfsyoumetuymd(BizDate.valueOf(20160323));

                keiyakumfsakuinkekkabeanList.add(keiyakumfsakuinkekkabean);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(keiyakumfsakuinkekkabeanList);

                List<BzHokenkinSueokiFSakuinKekkaBean> hokenkinSueokiFSakuinKekkaBeanList = new ArrayList<>();
                BzHokenkinSueokiFSakuinKekkaBean hokenkinSueokiFSakuinKekkaBean = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                hokenkinSueokiFSakuinKekkaBean.setSueokifsysyno("12803345673");
                hokenkinSueokiFSakuinKekkaBean.setSueokifsueokikaisiymd(BizDate.valueOf(20160322));

                hokenkinSueokiFSakuinKekkaBeanList.add(hokenkinSueokiFSakuinKekkaBean);
                bzSakuinTsnSyoukaiKekkaBean.setBzhokenkinsueokifsakuinkekkabeanlist(hokenkinSueokiFSakuinKekkaBeanList);

                List<BzSougouNenkinSiharaiFSakuinKekkaBean> sougouNenkinSiharaiFSakuinKekkaBeanList = new ArrayList<>();
                BzSougouNenkinSiharaiFSakuinKekkaBean sougouNenkinSiharaiFSakuinKekkaBean = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfnksysyno("12803345673");
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfsyokainkshrymd(BizDate.valueOf(20160322));
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfnksyoumetucd("10");
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfsyoumetuymd(BizDate.valueOf(20160323));

                sougouNenkinSiharaiFSakuinKekkaBeanList.add(sougouNenkinSiharaiFSakuinKekkaBean);
                bzSakuinTsnSyoukaiKekkaBean.setBzsougounenkinsiharaifsakuinkekkabeanlist(sougouNenkinSiharaiFSakuinKekkaBeanList);

                List<BzKeiyakuHozenSakuinKekkaBean> keiyakuHozenSakuinKekkaBeanList = new ArrayList<>();
                BzKeiyakuHozenSakuinKekkaBean keiyakuHozenSakuinKekkaBean = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                keiyakuHozenSakuinKekkaBean.setKhsyono("12803345673");
                keiyakuHozenSakuinKekkaBean.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                keiyakuHozenSakuinKekkaBean.setKhkykjyoutai(C_Kykjyoutai.HRKMTYUU);
                keiyakuHozenSakuinKekkaBean.setKhkykymd(BizDate.valueOf(20160322));
                keiyakuHozenSakuinKekkaBean.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                keiyakuHozenSakuinKekkaBean.setKhsyoumetuymd(BizDate.valueOf(20160323));
                keiyakuHozenSakuinKekkaBean.setKhsyouhncd("MD11");
                keiyakuHozenSakuinKekkaBean.setKhsyouhnsdno(18);

                keiyakuHozenSakuinKekkaBeanList.add(keiyakuHozenSakuinKekkaBean);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(keiyakuHozenSakuinKekkaBeanList);

                List<BzNenkinSiharaiSakuinKekkaBean> nenkinSiharaiSakuinKekkaBeanLsit = new ArrayList<>();
                BzNenkinSiharaiSakuinKekkaBean nenkinSiharaiSakuinKekkaBean = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                nenkinSiharaiSakuinKekkaBean.setNknksysyno("12803345673");
                nenkinSiharaiSakuinKekkaBean.setNknkshrstartymd(BizDate.valueOf(20160322));
                nenkinSiharaiSakuinKekkaBean.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                nenkinSiharaiSakuinKekkaBean.setNksyoumetuymd(BizDate.valueOf(20160323));

                nenkinSiharaiSakuinKekkaBeanLsit.add(nenkinSiharaiSakuinKekkaBean);
                bzSakuinTsnSyoukaiKekkaBean.setBznenkinsiharaisakuinkekkabeanlist(nenkinSiharaiSakuinKekkaBeanLsit);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if(TESTPATTERN5.equals(SYORIPTN)){

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuutyoukaumu(C_BlnktkumuKbn.ARI);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if(TESTPATTERN6.equals(SYORIPTN)){

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuutyoukaumu(C_BlnktkumuKbn.ARI);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if(TESTPATTERN7.equals(SYORIPTN)){

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuutyoukaumu(C_BlnktkumuKbn.ARI);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if(TESTPATTERN8.equals(SYORIPTN)){

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuutyoukaumu(C_BlnktkumuKbn.ARI);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if(TESTPATTERN9.equals(SYORIPTN)){

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuutyoukaumu(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuutyoukaumu(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuutyoukaumu(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuutyoukaumu(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuutyoukaumu(C_BlnktkumuKbn.NONE);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if(TESTPATTERN10.equals(SYORIPTN)){

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(3);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuu(3);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuu(3);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(3);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuu(3);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuutyoukaumu(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuutyoukaumu(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuutyoukaumu(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuutyoukaumu(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuutyoukaumu(C_BlnktkumuKbn.NONE);

                List<BzKeiyakuMfSakuinKekkaBean> keiyakumfsakuinkekkabeanList = new ArrayList<>();
                BzKeiyakuMfSakuinKekkaBean keiyakumfsakuinkekkabean = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                keiyakumfsakuinkekkabean.setKykmfsyono("22806123457");
                keiyakumfsakuinkekkabean.setKykmfkykymd(BizDate.valueOf(20160420));
                keiyakumfsakuinkekkabean.setKykmfsyoumetucd("0001");
                keiyakumfsakuinkekkabean.setKykmfsyoumetuymd(BizDate.valueOf(20160421));

                keiyakumfsakuinkekkabeanList.add(keiyakumfsakuinkekkabean);

                keiyakumfsakuinkekkabean = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                keiyakumfsakuinkekkabean.setKykmfsyono("22806123457");
                keiyakumfsakuinkekkabean.setKykmfkykymd(BizDate.valueOf(20160422));
                keiyakumfsakuinkekkabean.setKykmfsyoumetucd("0002");
                keiyakumfsakuinkekkabean.setKykmfsyoumetuymd(BizDate.valueOf(20160423));

                keiyakumfsakuinkekkabeanList.add(keiyakumfsakuinkekkabean);

                keiyakumfsakuinkekkabean = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                keiyakumfsakuinkekkabean.setKykmfsyono("22806123457");
                keiyakumfsakuinkekkabean.setKykmfkykymd(BizDate.valueOf(20160424));
                keiyakumfsakuinkekkabean.setKykmfsyoumetucd("0003");
                keiyakumfsakuinkekkabean.setKykmfsyoumetuymd(BizDate.valueOf(20160425));

                keiyakumfsakuinkekkabeanList.add(keiyakumfsakuinkekkabean);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(keiyakumfsakuinkekkabeanList);

                List<BzHokenkinSueokiFSakuinKekkaBean> hokenkinSueokiFSakuinKekkaBeanList = new ArrayList<>();
                BzHokenkinSueokiFSakuinKekkaBean hokenkinSueokiFSakuinKekkaBean = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                hokenkinSueokiFSakuinKekkaBean.setSueokifsysyno("22806123457");
                hokenkinSueokiFSakuinKekkaBean.setSueokifsueokikaisiymd(BizDate.valueOf(20160420));

                hokenkinSueokiFSakuinKekkaBeanList.add(hokenkinSueokiFSakuinKekkaBean);

                hokenkinSueokiFSakuinKekkaBean = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                hokenkinSueokiFSakuinKekkaBean.setSueokifsysyno("22806123457");
                hokenkinSueokiFSakuinKekkaBean.setSueokifsueokikaisiymd(BizDate.valueOf(20160421));

                hokenkinSueokiFSakuinKekkaBeanList.add(hokenkinSueokiFSakuinKekkaBean);

                hokenkinSueokiFSakuinKekkaBean = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                hokenkinSueokiFSakuinKekkaBean.setSueokifsysyno("22806123457");
                hokenkinSueokiFSakuinKekkaBean.setSueokifsueokikaisiymd(BizDate.valueOf(20160422));

                hokenkinSueokiFSakuinKekkaBeanList.add(hokenkinSueokiFSakuinKekkaBean);
                bzSakuinTsnSyoukaiKekkaBean.setBzhokenkinsueokifsakuinkekkabeanlist(hokenkinSueokiFSakuinKekkaBeanList);

                List<BzSougouNenkinSiharaiFSakuinKekkaBean> sougouNenkinSiharaiFSakuinKekkaBeanList = new ArrayList<>();
                BzSougouNenkinSiharaiFSakuinKekkaBean sougouNenkinSiharaiFSakuinKekkaBean = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfnksysyno("22806123457");
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfsyokainkshrymd(BizDate.valueOf(20160420));
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfnksyoumetucd("10");
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfsyoumetuymd(BizDate.valueOf(20160423));

                sougouNenkinSiharaiFSakuinKekkaBeanList.add(sougouNenkinSiharaiFSakuinKekkaBean);

                sougouNenkinSiharaiFSakuinKekkaBean = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfnksysyno("22806123457");
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfsyokainkshrymd(BizDate.valueOf(20160421));
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfnksyoumetucd("10");
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfsyoumetuymd(BizDate.valueOf(20160424));

                sougouNenkinSiharaiFSakuinKekkaBeanList.add(sougouNenkinSiharaiFSakuinKekkaBean);

                sougouNenkinSiharaiFSakuinKekkaBean = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfnksysyno("22806123457");
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfsyokainkshrymd(BizDate.valueOf(20160422));
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfnksyoumetucd("10");
                sougouNenkinSiharaiFSakuinKekkaBean.setSounenfsyoumetuymd(BizDate.valueOf(20160425));

                sougouNenkinSiharaiFSakuinKekkaBeanList.add(sougouNenkinSiharaiFSakuinKekkaBean);
                bzSakuinTsnSyoukaiKekkaBean.setBzsougounenkinsiharaifsakuinkekkabeanlist(sougouNenkinSiharaiFSakuinKekkaBeanList);

                List<BzKeiyakuHozenSakuinKekkaBean> keiyakuHozenSakuinKekkaBeanList = new ArrayList<>();
                BzKeiyakuHozenSakuinKekkaBean keiyakuHozenSakuinKekkaBean = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                keiyakuHozenSakuinKekkaBean.setKhsyono("22806123457");
                keiyakuHozenSakuinKekkaBean.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                keiyakuHozenSakuinKekkaBean.setKhkykjyoutai(C_Kykjyoutai.HRKMTYUU);
                keiyakuHozenSakuinKekkaBean.setKhkykymd(BizDate.valueOf(20160420));
                keiyakuHozenSakuinKekkaBean.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                keiyakuHozenSakuinKekkaBean.setKhsyoumetuymd(BizDate.valueOf(20160424));
                keiyakuHozenSakuinKekkaBean.setKhsyouhncd("MD11");
                keiyakuHozenSakuinKekkaBean.setKhsyouhnsdno(21);

                keiyakuHozenSakuinKekkaBeanList.add(keiyakuHozenSakuinKekkaBean);

                keiyakuHozenSakuinKekkaBean = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                keiyakuHozenSakuinKekkaBean.setKhsyono("22806123457");
                keiyakuHozenSakuinKekkaBean.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                keiyakuHozenSakuinKekkaBean.setKhkykjyoutai(C_Kykjyoutai.HRKMTYUU);
                keiyakuHozenSakuinKekkaBean.setKhkykymd(BizDate.valueOf(20160421));
                keiyakuHozenSakuinKekkaBean.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                keiyakuHozenSakuinKekkaBean.setKhsyoumetuymd(BizDate.valueOf(20160425));
                keiyakuHozenSakuinKekkaBean.setKhsyouhncd("MD11");
                keiyakuHozenSakuinKekkaBean.setKhsyouhnsdno(22);

                keiyakuHozenSakuinKekkaBeanList.add(keiyakuHozenSakuinKekkaBean);

                keiyakuHozenSakuinKekkaBean = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                keiyakuHozenSakuinKekkaBean.setKhsyono("22806123457");
                keiyakuHozenSakuinKekkaBean.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                keiyakuHozenSakuinKekkaBean.setKhkykjyoutai(C_Kykjyoutai.HRKMTYUU);
                keiyakuHozenSakuinKekkaBean.setKhkykymd(BizDate.valueOf(20160423));
                keiyakuHozenSakuinKekkaBean.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                keiyakuHozenSakuinKekkaBean.setKhsyoumetuymd(BizDate.valueOf(20160426));
                keiyakuHozenSakuinKekkaBean.setKhsyouhncd("MD11");
                keiyakuHozenSakuinKekkaBean.setKhsyouhnsdno(23);

                keiyakuHozenSakuinKekkaBeanList.add(keiyakuHozenSakuinKekkaBean);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(keiyakuHozenSakuinKekkaBeanList);

                List<BzNenkinSiharaiSakuinKekkaBean> nenkinSiharaiSakuinKekkaBeanLsit = new ArrayList<>();
                BzNenkinSiharaiSakuinKekkaBean nenkinSiharaiSakuinKekkaBean = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                nenkinSiharaiSakuinKekkaBean.setNknksysyno("22806123457");
                nenkinSiharaiSakuinKekkaBean.setNknkshrstartymd(BizDate.valueOf(20160420));
                nenkinSiharaiSakuinKekkaBean.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                nenkinSiharaiSakuinKekkaBean.setNksyoumetuymd(BizDate.valueOf(20160423));

                nenkinSiharaiSakuinKekkaBeanLsit.add(nenkinSiharaiSakuinKekkaBean);

                nenkinSiharaiSakuinKekkaBean = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                nenkinSiharaiSakuinKekkaBean.setNknksysyno("22806123457");
                nenkinSiharaiSakuinKekkaBean.setNknkshrstartymd(BizDate.valueOf(20160421));
                nenkinSiharaiSakuinKekkaBean.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                nenkinSiharaiSakuinKekkaBean.setNksyoumetuymd(BizDate.valueOf(20160424));

                nenkinSiharaiSakuinKekkaBeanLsit.add(nenkinSiharaiSakuinKekkaBean);

                nenkinSiharaiSakuinKekkaBean = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                nenkinSiharaiSakuinKekkaBean.setNknksysyno("22806123457");
                nenkinSiharaiSakuinKekkaBean.setNknkshrstartymd(BizDate.valueOf(20160422));
                nenkinSiharaiSakuinKekkaBean.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                nenkinSiharaiSakuinKekkaBean.setNksyoumetuymd(BizDate.valueOf(20160425));

                nenkinSiharaiSakuinKekkaBeanLsit.add(nenkinSiharaiSakuinKekkaBean);
                bzSakuinTsnSyoukaiKekkaBean.setBznenkinsiharaisakuinkekkabeanlist(nenkinSiharaiSakuinKekkaBeanLsit);

                return bzSakuinTsnSyoukaiKekkaBean;
            }

        }
        return super.exec(pBzSakuinTsnSyoukaiYokenBean);
    }
}
