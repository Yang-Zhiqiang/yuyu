package yuyu.common.biz.bznayose;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.sinkeiyaku.moschk.NayoseTest_exec;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_KykJyoutaiKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_NayoseJyoutaiKbn;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkinfoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 名寄せ PALあて索引通算照会（MQ）{@link BzSakuinTsnSyoukaiMq}のモッククラスです。<br />
 */
public class BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku extends BzSakuinTsnSyoukaiMq {

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

        if (caller == NayoseTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.NAYOSEHUMEI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setUktttdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.YOU);

                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(3);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean1 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean1.setSkmosno("791112220");
                bzSinkeiyakuSakuinKekkaBean1.setSkmfrenflg(C_Mfrenflg.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSktaisyousakuinnmno("1234567890");

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean2 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean2.setSkmosno("791112238");
                bzSinkeiyakuSakuinKekkaBean2.setSkmfrenflg(C_Mfrenflg.NONE);
                bzSinkeiyakuSakuinKekkaBean2.setSktaisyousakuinnmno("1234567890");

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean3 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean3.setSkmosno("791112220");
                bzSinkeiyakuSakuinKekkaBean3.setSkmfrenflg(C_Mfrenflg.SUMI);
                bzSinkeiyakuSakuinKekkaBean3.setSktaisyousakuinnmno("1234567890");

                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean1);
                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean2);
                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean3);
                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);

                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(1);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                BzSentakuInfoFSakuinKekkaBean bzSentakuInfoFSakuinKekkaBean1 = new BzSentakuInfoFSakuinKekkaBean();
                bzSentakuInfoFSakuinKekkaBean1.setHuho2mrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2decumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2kdumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2torikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfono("2");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokankeisyakbn(C_KankeisyaKbn.KYK);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfofkojinkbn("12");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokbn(C_SntkinfoKbn.SEIRITU);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfosakuseiymd(BizDate.valueOf("20160509"));
                bzSentakuInfoFSakuinKekkaBean1.setMrumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setDecumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setInfokoukanumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setNyuuinkyhkshrumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setSyujyutukyhkshrumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setSyougaikyhkshrumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setKoudosyougaiumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setPmenumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setTorikaijoumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setSoukikeakyhkshrumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setSonotakyhkshrumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setKghsjjtkyhkshrumukbn(C_BlnktkumuKbn.ARI);

                bzsentakuinfofsakuinkekkabeanLst.add(bzSentakuInfoFSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);
                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);

                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(1);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean1 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean1.setSkmosno("791112238");
                bzSinkeiyakuSakuinKekkaBean1.setSkmfrenflg(C_Mfrenflg.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSktaisyousakuinnmno("1234567890");

                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);

                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(1);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                BzSentakuInfoFSakuinKekkaBean bzSentakuInfoFSakuinKekkaBean1 = new BzSentakuInfoFSakuinKekkaBean();
                bzSentakuInfoFSakuinKekkaBean1.setHuho2mrumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2decumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2kdumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2torikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfono("2");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokankeisyakbn(C_KankeisyaKbn.KYK);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfofkojinkbn("12");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokbn(C_SntkinfoKbn.SEIRITU);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfosakuseiymd(BizDate.valueOf("20160509"));
                bzSentakuInfoFSakuinKekkaBean1.setMrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setDecumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setInfokoukanumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setNyuuinkyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSyujyutukyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSyougaikyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setKoudosyougaiumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setPmenumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setTorikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSoukikeakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSonotakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setKghsjjtkyhkshrumukbn(C_BlnktkumuKbn.NONE);

                bzsentakuinfofsakuinkekkabeanLst.add(bzSentakuInfoFSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(3);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean1 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean1.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bzKeiyakuHozenSakuinKekkaBean1.setKhtaisyouseiymd(BizDate.valueOf("20150607"));

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean2 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean2.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
                bzKeiyakuHozenSakuinKekkaBean2.setKhkykkankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzKeiyakuHozenSakuinKekkaBean2.setKhtaisyouseiymd(BizDate.valueOf("20150608"));

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean3 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean3.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean3.setKhkykkankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzKeiyakuHozenSakuinKekkaBean3.setKhtaisyouseiymd(BizDate.valueOf("20150608"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);
                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean2);
                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean3);

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);

                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(1);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean1 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean1.setSkmosno("791112238");
                bzSinkeiyakuSakuinKekkaBean1.setSkmfrenflg(C_Mfrenflg.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSktaisyousakuinnmno("1234567890");

                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);

                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(1);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                BzSentakuInfoFSakuinKekkaBean bzSentakuInfoFSakuinKekkaBean1 = new BzSentakuInfoFSakuinKekkaBean();
                bzSentakuInfoFSakuinKekkaBean1.setHuho2mrumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2decumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2kdumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2torikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfono("2");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokankeisyakbn(C_KankeisyaKbn.KYK);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfofkojinkbn("12");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokbn(C_SntkinfoKbn.SEIRITU);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfosakuseiymd(BizDate.valueOf("20160509"));
                bzSentakuInfoFSakuinKekkaBean1.setMrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setDecumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setInfokoukanumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setNyuuinkyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSyujyutukyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSyougaikyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setKoudosyougaiumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setPmenumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setTorikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSoukikeakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSonotakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setKghsjjtkyhkshrumukbn(C_BlnktkumuKbn.NONE);

                bzsentakuinfofsakuinkekkabeanLst.add(bzSentakuInfoFSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);


                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(3);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean1 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean1.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bzKeiyakuHozenSakuinKekkaBean1.setKhtaisyouseiymd(BizDate.valueOf("20150607"));

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean2 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean2.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
                bzKeiyakuHozenSakuinKekkaBean2.setKhkykkankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzKeiyakuHozenSakuinKekkaBean2.setKhtaisyouseiymd(BizDate.valueOf("20150608"));

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean3 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean3.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean3.setKhkykkankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzKeiyakuHozenSakuinKekkaBean3.setKhtaisyouseiymd(BizDate.valueOf("20150608"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);
                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean2);
                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean3);

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setUktttdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.YOU);


                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(0);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);

                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(1);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                BzSentakuInfoFSakuinKekkaBean bzSentakuInfoFSakuinKekkaBean1 = new BzSentakuInfoFSakuinKekkaBean();
                bzSentakuInfoFSakuinKekkaBean1.setHuho2mrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2decumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2kdumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2torikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfono("2");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokankeisyakbn(C_KankeisyaKbn.KYK);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfofkojinkbn("12");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokbn(C_SntkinfoKbn.SEIRITU);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfosakuseiymd(BizDate.valueOf("20160509"));
                bzSentakuInfoFSakuinKekkaBean1.setMrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setDecumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setInfokoukanumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setNyuuinkyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSyujyutukyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSyougaikyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setKoudosyougaiumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setPmenumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setTorikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSoukikeakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSonotakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setKghsjjtkyhkshrumukbn(C_BlnktkumuKbn.NONE);

                bzsentakuinfofsakuinkekkabeanLst.add(bzSentakuInfoFSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);


                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(3);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean1 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean1.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bzKeiyakuHozenSakuinKekkaBean1.setKhtaisyouseiymd(BizDate.valueOf("20150607"));

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean2 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean2.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
                bzKeiyakuHozenSakuinKekkaBean2.setKhkykkankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzKeiyakuHozenSakuinKekkaBean2.setKhtaisyouseiymd(BizDate.valueOf("20150608"));

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean3 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean3.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean3.setKhkykkankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzKeiyakuHozenSakuinKekkaBean3.setKhtaisyouseiymd(BizDate.valueOf("20150608"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);
                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean2);
                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean3);

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);

                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(10));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenmikeikas(BizCurrency.valueOf(11));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenkeikas(BizCurrency.valueOf(12));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous(BizCurrency.valueOf(13));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous2(BizCurrency.valueOf(14));
                bzSakuinTsnSyoukaiKekkaBean.setTsnsoukktjituhsgk(BizCurrency.valueOf(15));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk1(BizCurrency.valueOf(16));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk2(BizCurrency.valueOf(17));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktitijibrsysnjs(BizCurrency.valueOf(18));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnkgns(BizCurrency.valueOf(19));
                bzSakuinTsnSyoukaiKekkaBean.setTsnmsnynenbtsousbus(BizCurrency.valueOf(20));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnenbtitijibrssbs(BizCurrency.valueOf(21));


                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.NAYOSEHUMEI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);


                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(1);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean1 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean1.setSkmosno("791112253");
                bzSinkeiyakuSakuinKekkaBean1.setSkmfrenflg(C_Mfrenflg.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSktaisyousakuinnmno("1234567890");

                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);


                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(1);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                BzSentakuInfoFSakuinKekkaBean bzSentakuInfoFSakuinKekkaBean1 = new BzSentakuInfoFSakuinKekkaBean();
                bzSentakuInfoFSakuinKekkaBean1.setHuho2mrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2decumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2kdumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2torikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfono("2");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokankeisyakbn(C_KankeisyaKbn.KYK);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfofkojinkbn("12");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokbn(C_SntkinfoKbn.SEIRITU);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfosakuseiymd(BizDate.valueOf("20160509"));
                bzSentakuInfoFSakuinKekkaBean1.setMrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setDecumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setInfokoukanumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setNyuuinkyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSyujyutukyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSyougaikyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setKoudosyougaiumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setPmenumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setTorikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSoukikeakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSonotakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setKghsjjtkyhkshrumukbn(C_BlnktkumuKbn.NONE);

                bzsentakuinfofsakuinkekkabeanLst.add(bzSentakuInfoFSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);


                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(1);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean1 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean1.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bzKeiyakuHozenSakuinKekkaBean1.setKhtaisyouseiymd(BizDate.valueOf("20150607"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);

                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(10));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenmikeikas(BizCurrency.valueOf(11));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenkeikas(BizCurrency.valueOf(12));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous(BizCurrency.valueOf(13));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous2(BizCurrency.valueOf(14));
                bzSakuinTsnSyoukaiKekkaBean.setTsnsoukktjituhsgk(BizCurrency.valueOf(15));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk1(BizCurrency.valueOf(16));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk2(BizCurrency.valueOf(17));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktitijibrsysnjs(BizCurrency.valueOf(18));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnkgns(BizCurrency.valueOf(19));
                bzSakuinTsnSyoukaiKekkaBean.setTsnmsnynenbtsousbus(BizCurrency.valueOf(20));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnenbtitijibrssbs(BizCurrency.valueOf(21));

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.NAYOSEHUMEI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuinnmno("7894561230");
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsysyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setUktttdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.YOU);

                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(1);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean1 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean1.setSkmosno(null);
                bzSinkeiyakuSakuinKekkaBean1.setSkseiritukbn(C_SeirituKbn.ITIPMATI);

                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(3);
                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                BzKeiyakuMfSakuinKekkaBean bzKeiyakuMfSakuinKekkaBean1 = new BzKeiyakuMfSakuinKekkaBean();
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykjyoutaikbn(C_KykJyoutaiKbn.YUUKOU);
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bzKeiyakuMfSakuinKekkaBean1.setKykmftaisyouseiymd(BizDate.valueOf("20150606"));

                BzKeiyakuMfSakuinKekkaBean bzKeiyakuMfSakuinKekkaBean2 = new BzKeiyakuMfSakuinKekkaBean();
                bzKeiyakuMfSakuinKekkaBean2.setKykmfkykjyoutaikbn(C_KykJyoutaiKbn.SIKKOU);
                bzKeiyakuMfSakuinKekkaBean2.setKykmfkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bzKeiyakuMfSakuinKekkaBean2.setKykmftaisyouseiymd(BizDate.valueOf("20150607"));

                BzKeiyakuMfSakuinKekkaBean bzKeiyakuMfSakuinKekkaBean3 = new BzKeiyakuMfSakuinKekkaBean();
                bzKeiyakuMfSakuinKekkaBean3.setKykmfkykjyoutaikbn(C_KykJyoutaiKbn.YUUKOU);
                bzKeiyakuMfSakuinKekkaBean3.setKykmfkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bzKeiyakuMfSakuinKekkaBean3.setKykmftaisyouseiymd(BizDate.valueOf("20150608"));

                bzkeiyakumfsakuinkekkabeanLst.add(bzKeiyakuMfSakuinKekkaBean1);
                bzkeiyakumfsakuinkekkabeanLst.add(bzKeiyakuMfSakuinKekkaBean2);
                bzkeiyakumfsakuinkekkabeanLst.add(bzKeiyakuMfSakuinKekkaBean3);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(1);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                BzSentakuInfoFSakuinKekkaBean bzSentakuInfoFSakuinKekkaBean1 = new BzSentakuInfoFSakuinKekkaBean();
                bzSentakuInfoFSakuinKekkaBean1.setHuho2mrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2decumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2kdumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2torikaijoumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfono("2");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokankeisyakbn(C_KankeisyaKbn.KYK);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfofkojinkbn("12");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokbn(C_SntkinfoKbn.SEIRITU);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfosakuseiymd(BizDate.valueOf("20160509"));
                bzSentakuInfoFSakuinKekkaBean1.setMrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setDecumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setInfokoukanumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setNyuuinkyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSyujyutukyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSyougaikyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setKoudosyougaiumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setPmenumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setTorikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSoukikeakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSonotakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setKghsjjtkyhkshrumukbn(C_BlnktkumuKbn.NONE);

                bzsentakuinfofsakuinkekkabeanLst.add(bzSentakuInfoFSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(0);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);

                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(10));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenmikeikas(BizCurrency.valueOf(11));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenkeikas(BizCurrency.valueOf(12));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous(BizCurrency.valueOf(13));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous2(BizCurrency.valueOf(14));
                bzSakuinTsnSyoukaiKekkaBean.setTsnsoukktjituhsgk(BizCurrency.valueOf(15));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk1(BizCurrency.valueOf(16));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk2(BizCurrency.valueOf(17));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktitijibrsysnjs(BizCurrency.valueOf(18));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnkgns(BizCurrency.valueOf(19));
                bzSakuinTsnSyoukaiKekkaBean.setTsnmsnynenbtsousbus(BizCurrency.valueOf(20));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnenbtitijibrssbs(BizCurrency.valueOf(21));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenmikeikahtnkns(BizCurrency.valueOf(22));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenkeikadfp(BizCurrency.valueOf(23));
                bzSakuinTsnSyoukaiKekkaBean.setTsnitijibrsysnp(BizCurrency.valueOf(24));
                bzSakuinTsnSyoukaiKekkaBean.setTsnsntktuukahijynsysns(BizCurrency.valueOf(999));
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsns(BizCurrency.valueOf(25));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkaigomehrtkumukbn(C_UmuKbn.ARI);

                bzSakuinTsnSyoukaiKekkaBean.setMosfkensuu(4);
                List<BzMousikomiFSakuinKekkaBean> bzMousikomiFSakuinKekkaBeanLst = new ArrayList<>();

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean1 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean1.setMosfmosno("");
                bzMousikomiFSakuinKekkaBean1.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);

                bzMousikomiFSakuinKekkaBean1.setMosfmoskankeisyakbn(C_KankeisyaKbn.KYK);

                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean1);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean2 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean2.setMosfmosno(null);
                bzMousikomiFSakuinKekkaBean2.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);
                bzMousikomiFSakuinKekkaBean2.setMosfmoskankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);

                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean2);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean3 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean3.setMosfmosno("791112279");
                bzMousikomiFSakuinKekkaBean3.setMosfmossyoumetukbn(C_MossyoumetuKbn.SEIRITU);
                bzMousikomiFSakuinKekkaBean3.setMosfmoskankeisyakbn(C_KankeisyaKbn.DAI2HHKN_KYKDOUITU);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean3);
                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean4 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean4.setMosfmosno("791112261");
                bzMousikomiFSakuinKekkaBean4.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);
                bzMousikomiFSakuinKekkaBean4.setMosfmoskankeisyakbn(C_KankeisyaKbn.KYK);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean4);
                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                return bzSakuinTsnSyoukaiKekkaBean;

            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setNysjyoutaikbn(C_NayoseJyoutaiKbn.MIRYOU);
                bzSakuinTsnSyoukaiKekkaBean.setSakuinnmno("7894561230");
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsysyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);

                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(0);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean1 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean1.setSkmosno("");
                bzSinkeiyakuSakuinKekkaBean1.setSkmfrenflg(C_Mfrenflg.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSktaisyousakuinnmno("1234567890");

                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);


                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(0);
                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);


                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(1);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                BzSentakuInfoFSakuinKekkaBean bzSentakuInfoFSakuinKekkaBean1 = new BzSentakuInfoFSakuinKekkaBean();
                bzSentakuInfoFSakuinKekkaBean1.setHuho2mrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2decumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2kdumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2torikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfono("2");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokankeisyakbn(C_KankeisyaKbn.KYK);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfofkojinkbn("12");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokbn(C_SntkinfoKbn.SEIRITU);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfosakuseiymd(BizDate.valueOf("20160509"));
                bzSentakuInfoFSakuinKekkaBean1.setMrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setDecumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setInfokoukanumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setNyuuinkyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSyujyutukyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSyougaikyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setKoudosyougaiumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setPmenumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setTorikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSoukikeakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSonotakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setKghsjjtkyhkshrumukbn(C_BlnktkumuKbn.NONE);

                bzsentakuinfofsakuinkekkabeanLst.add(bzSentakuInfoFSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);


                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(4);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean1 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean1.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bzKeiyakuHozenSakuinKekkaBean1.setKhtaisyouseiymd(BizDate.valueOf("20150607"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);
                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean2 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean2.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
                bzKeiyakuHozenSakuinKekkaBean2.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bzKeiyakuHozenSakuinKekkaBean2.setKhtaisyouseiymd(BizDate.valueOf("20150606"));

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean3 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean3.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
                bzKeiyakuHozenSakuinKekkaBean3.setKhkykkankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzKeiyakuHozenSakuinKekkaBean3.setKhtaisyouseiymd(BizDate.valueOf("20150606"));

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean4 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean3.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean3.setKhkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bzKeiyakuHozenSakuinKekkaBean3.setKhtaisyouseiymd(BizDate.valueOf("20150606"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);
                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean2);
                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean3);
                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean4);

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);


                bzSakuinTsnSyoukaiKekkaBean.setMosfkensuu(6);
                List<BzMousikomiFSakuinKekkaBean> bzMousikomiFSakuinKekkaBeanLst = new ArrayList<>();

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean1 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean1.setMosfmosno("791112287");
                bzMousikomiFSakuinKekkaBean1.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);






                bzMousikomiFSakuinKekkaBean1.setMosfmoskankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);







                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean1);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean2 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean1.setMosfmosno("791112287");
                bzMousikomiFSakuinKekkaBean2.setMosfmossyoumetukbn(C_MossyoumetuKbn.SEIRITU);
                bzMousikomiFSakuinKekkaBean2.setMosfmoskankeisyakbn(C_KankeisyaKbn.KYK);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean2);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean3 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean1.setMosfmosno("791112287");
                bzMousikomiFSakuinKekkaBean3.setMosfmossyoumetukbn(C_MossyoumetuKbn.KOKOSEIRITU_KARISEIRITU);
                bzMousikomiFSakuinKekkaBean3.setMosfmoskankeisyakbn(C_KankeisyaKbn.KYK);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean3);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean4 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean1.setMosfmosno("791112287");
                bzMousikomiFSakuinKekkaBean4.setMosfmossyoumetukbn(C_MossyoumetuKbn.KOKOSEIRITU_KARISEIRITU);
                bzMousikomiFSakuinKekkaBean4.setMosfmoskankeisyakbn(C_KankeisyaKbn.DAI2HHKN_KYKDOUITU);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean4);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean5 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean1.setMosfmosno("791112287");
                bzMousikomiFSakuinKekkaBean5.setMosfmossyoumetukbn(C_MossyoumetuKbn.KOKOSEIRITU_KARISEIRITU);
                bzMousikomiFSakuinKekkaBean5.setMosfmoskankeisyakbn(C_KankeisyaKbn.BLNK);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean5);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean6 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean1.setMosfmosno("791112287");
                bzMousikomiFSakuinKekkaBean6.setMosfmossyoumetukbn(C_MossyoumetuKbn.BLNK);
                bzMousikomiFSakuinKekkaBean6.setMosfmoskankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean6);

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(10));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenmikeikas(BizCurrency.valueOf(11));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenkeikas(BizCurrency.valueOf(12));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous(BizCurrency.valueOf(13));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous2(BizCurrency.valueOf(14));
                bzSakuinTsnSyoukaiKekkaBean.setTsnsoukktjituhsgk(BizCurrency.valueOf(15));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk1(BizCurrency.valueOf(16));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk2(BizCurrency.valueOf(17));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktitijibrsysnjs(BizCurrency.valueOf(18));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnkgns(BizCurrency.valueOf(19));
                bzSakuinTsnSyoukaiKekkaBean.setTsnmsnynenbtsousbus(BizCurrency.valueOf(20));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnenbtitijibrssbs(BizCurrency.valueOf(21));

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNysjyoutaikbn(C_NayoseJyoutaiKbn.MIRYOU);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);

                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(0);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(1);
                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                BzKeiyakuMfSakuinKekkaBean bzKeiyakuMfSakuinKekkaBean1 = new BzKeiyakuMfSakuinKekkaBean();
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykjyoutaikbn(C_KykJyoutaiKbn.SIKKOU);
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bzKeiyakuMfSakuinKekkaBean1.setKykmftaisyouseiymd(BizDate.valueOf("20150608"));

                bzkeiyakumfsakuinkekkabeanLst.add(bzKeiyakuMfSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(3);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                BzSentakuInfoFSakuinKekkaBean bzSentakuInfoFSakuinKekkaBean1 = new BzSentakuInfoFSakuinKekkaBean();
                bzSentakuInfoFSakuinKekkaBean1.setHuho2mrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2decumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2kdumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setHuho2torikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfono("1");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokankeisyakbn(C_KankeisyaKbn.KYK);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfofkojinkbn("12");
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfokbn(C_SntkinfoKbn.SEIRITU);
                bzSentakuInfoFSakuinKekkaBean1.setSntkinfosakuseiymd(BizDate.valueOf("20160509"));
                bzSentakuInfoFSakuinKekkaBean1.setMrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setDecumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setInfokoukanumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setNyuuinkyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSyujyutukyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSyougaikyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setKoudosyougaiumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setPmenumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setTorikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSoukikeakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setSonotakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean1.setKghsjjtkyhkshrumukbn(C_BlnktkumuKbn.NONE);

                bzsentakuinfofsakuinkekkabeanLst.add(bzSentakuInfoFSakuinKekkaBean1);


                BzSentakuInfoFSakuinKekkaBean bzSentakuInfoFSakuinKekkaBean2 = new BzSentakuInfoFSakuinKekkaBean();
                bzSentakuInfoFSakuinKekkaBean2.setHuho2mrumukbn(C_BlnktkumuKbn.ARI);
                bzSentakuInfoFSakuinKekkaBean2.setHuho2decumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean2.setHuho2kdumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean2.setHuho2torikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean2.setSntkinfono("2");
                bzSentakuInfoFSakuinKekkaBean2.setSntkinfokankeisyakbn(C_KankeisyaKbn.KYK);
                bzSentakuInfoFSakuinKekkaBean2.setSntkinfofkojinkbn("12");
                bzSentakuInfoFSakuinKekkaBean2.setSntkinfokbn(C_SntkinfoKbn.SEIRITU);
                bzSentakuInfoFSakuinKekkaBean2.setSntkinfosakuseiymd(BizDate.valueOf("20160509"));
                bzSentakuInfoFSakuinKekkaBean2.setMrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean2.setDecumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean2.setInfokoukanumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean2.setNyuuinkyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean2.setSyujyutukyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean2.setSyougaikyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean2.setKoudosyougaiumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean2.setPmenumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean2.setTorikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean2.setSoukikeakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean2.setSonotakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean2.setKghsjjtkyhkshrumukbn(C_BlnktkumuKbn.NONE);

                bzsentakuinfofsakuinkekkabeanLst.add(bzSentakuInfoFSakuinKekkaBean2);

                BzSentakuInfoFSakuinKekkaBean bzSentakuInfoFSakuinKekkaBean3 = new BzSentakuInfoFSakuinKekkaBean();
                bzSentakuInfoFSakuinKekkaBean3.setHuho2mrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setHuho2decumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setHuho2kdumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setHuho2torikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setSntkinfono("3");
                bzSentakuInfoFSakuinKekkaBean3.setSntkinfokankeisyakbn(C_KankeisyaKbn.KYK);
                bzSentakuInfoFSakuinKekkaBean3.setSntkinfofkojinkbn("12");
                bzSentakuInfoFSakuinKekkaBean3.setSntkinfokbn(C_SntkinfoKbn.SEIRITU);
                bzSentakuInfoFSakuinKekkaBean3.setSntkinfosakuseiymd(BizDate.valueOf("20160509"));
                bzSentakuInfoFSakuinKekkaBean3.setMrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setDecumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setInfokoukanumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setNyuuinkyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setSyujyutukyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setSyougaikyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setKoudosyougaiumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setPmenumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setTorikaijoumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setSoukikeakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setSonotakyhkshrumukbn(C_BlnktkumuKbn.NONE);
                bzSentakuInfoFSakuinKekkaBean3.setKghsjjtkyhkshrumukbn(C_BlnktkumuKbn.NONE);

                bzsentakuinfofsakuinkekkabeanLst.add(bzSentakuInfoFSakuinKekkaBean3);

                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(1);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean1 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean1.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bzKeiyakuHozenSakuinKekkaBean1.setKhtaisyouseiymd(BizDate.valueOf("20150608"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);

                bzSakuinTsnSyoukaiKekkaBean.setMosfkensuu(1);
                List<BzMousikomiFSakuinKekkaBean> bzMousikomiFSakuinKekkaBeanLst = new ArrayList<>();


                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean1 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(10));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenmikeikas(BizCurrency.valueOf(11));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenkeikas(BizCurrency.valueOf(12));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous(BizCurrency.valueOf(13));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous2(BizCurrency.valueOf(14));
                bzSakuinTsnSyoukaiKekkaBean.setTsnsoukktjituhsgk(BizCurrency.valueOf(15));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk1(BizCurrency.valueOf(16));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk2(BizCurrency.valueOf(17));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktitijibrsysnjs(BizCurrency.valueOf(18));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnkgns(BizCurrency.valueOf(19));
                bzSakuinTsnSyoukaiKekkaBean.setTsnmsnynenbtsousbus(BizCurrency.valueOf(20));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnenbtitijibrssbs(BizCurrency.valueOf(21));

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                return bzSakuinTsnSyoukaiKekkaBean;

            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNysjyoutaikbn(C_NayoseJyoutaiKbn.MIRYOU);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setUktttdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);

                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(6);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean1 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean1.setSkmosno("791112287");
                bzSinkeiyakuSakuinKekkaBean1.setSkseiritukbn(C_SeirituKbn.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSkmoskankeisyakbn(C_KankeisyaKbn.DAI2HHKN_KYKDOUITU);
                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean1);

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean2 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean2.setSkmosno("791112287");
                bzSinkeiyakuSakuinKekkaBean2.setSkseiritukbn(C_SeirituKbn.SEIRITU);
                bzSinkeiyakuSakuinKekkaBean2.setSkmoskankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);
                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean2);

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean3 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean3.setSkmosno("");
                bzSinkeiyakuSakuinKekkaBean3.setSkseiritukbn(C_SeirituKbn.ITIPMATI);
                bzSinkeiyakuSakuinKekkaBean3.setSkmoskankeisyakbn(C_KankeisyaKbn.KYK);
                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean3);

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean4 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean4.setSkmosno(null);
                bzSinkeiyakuSakuinKekkaBean4.setSkseiritukbn(C_SeirituKbn.ITIPMATI);
                bzSinkeiyakuSakuinKekkaBean4.setSkmoskankeisyakbn(C_KankeisyaKbn.DAI2HHKN_KYKDOUITU);
                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean4);

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean5 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean5.setSkmosno("791112287");
                bzSinkeiyakuSakuinKekkaBean5.setSkseiritukbn(C_SeirituKbn.HUSEIRITU);
                bzSinkeiyakuSakuinKekkaBean5.setSkmoskankeisyakbn(C_KankeisyaKbn.DAI2HHKN_KYKDOUITU);
                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean5);

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean6 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean6.setSkmosno("791112303");
                bzSinkeiyakuSakuinKekkaBean6.setSkseiritukbn(C_SeirituKbn.ITIPMATI);
                bzSinkeiyakuSakuinKekkaBean6.setSkmoskankeisyakbn(C_KankeisyaKbn.DAI2HHKN_KYKDOUITU);
                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean6);

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean7 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean7.setSkmosno("791112303");
                bzSinkeiyakuSakuinKekkaBean7.setSkseiritukbn(C_SeirituKbn.ITIPMATI);
                bzSinkeiyakuSakuinKekkaBean7.setSkmoskankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean7);

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean8 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean8.setSkmosno("791112303");
                bzSinkeiyakuSakuinKekkaBean8.setSkseiritukbn(C_SeirituKbn.ITIPMATI);
                bzSinkeiyakuSakuinKekkaBean8.setSkmoskankeisyakbn(C_KankeisyaKbn.KYK);
                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean8);

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean9 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean9.setSkmosno("791112303");
                bzSinkeiyakuSakuinKekkaBean9.setSkseiritukbn(C_SeirituKbn.ITIPMATI);
                bzSinkeiyakuSakuinKekkaBean9.setSkmoskankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);
                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean9);

                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(1);
                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                BzKeiyakuMfSakuinKekkaBean bzKeiyakuMfSakuinKekkaBean1 = new BzKeiyakuMfSakuinKekkaBean();
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykjyoutaikbn(C_KykJyoutaiKbn.YUUKOU);
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bzKeiyakuMfSakuinKekkaBean1.setKykmftaisyouseiymd(BizDate.valueOf("20150606"));

                bzkeiyakumfsakuinkekkabeanLst.add(bzKeiyakuMfSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(0);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(1);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean1 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean1.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bzKeiyakuHozenSakuinKekkaBean1.setKhtaisyouseiymd(BizDate.valueOf("20150606"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);

                bzSakuinTsnSyoukaiKekkaBean.setMosfkensuu(1);
                List<BzMousikomiFSakuinKekkaBean> bzMousikomiFSakuinKekkaBeanLst = new ArrayList<>();

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean6 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean6.setMosfmosno("791112303");
                bzMousikomiFSakuinKekkaBean6.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);
                bzMousikomiFSakuinKekkaBean6.setMosfmoskankeisyakbn(C_KankeisyaKbn.DAI2HHKN_KYKDOUITU);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean7 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean7.setMosfmosno("791112303");
                bzMousikomiFSakuinKekkaBean7.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);
                bzMousikomiFSakuinKekkaBean7.setMosfmoskankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean8 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean8.setMosfmosno("791112303");
                bzMousikomiFSakuinKekkaBean8.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);
                bzMousikomiFSakuinKekkaBean8.setMosfmoskankeisyakbn(C_KankeisyaKbn.KYK);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean9 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean9.setMosfmosno("791112303");
                bzMousikomiFSakuinKekkaBean9.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);
                bzMousikomiFSakuinKekkaBean9.setMosfmoskankeisyakbn(C_KankeisyaKbn.DAI2HHKN_KYKDOUITU);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean10 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean10.setMosfmosno("791112303");
                bzMousikomiFSakuinKekkaBean10.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);
                bzMousikomiFSakuinKekkaBean10.setMosfmoskankeisyakbn(C_KankeisyaKbn.DAI2HHKN_KYKDOUITU);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean11 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean11.setMosfmosno("791112303");
                bzMousikomiFSakuinKekkaBean11.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);
                bzMousikomiFSakuinKekkaBean11.setMosfmoskankeisyakbn(C_KankeisyaKbn.DAI2HHKN_KYKDOUITU);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean12 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean12.setMosfmosno("791112303");
                bzMousikomiFSakuinKekkaBean12.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);
                bzMousikomiFSakuinKekkaBean12.setMosfmoskankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean13 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean13.setMosfmosno("791112303");
                bzMousikomiFSakuinKekkaBean13.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);
                bzMousikomiFSakuinKekkaBean13.setMosfmoskankeisyakbn(C_KankeisyaKbn.KYK);

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean14 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean14.setMosfmosno("791112303");
                bzMousikomiFSakuinKekkaBean14.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);
                bzMousikomiFSakuinKekkaBean14.setMosfmoskankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);

                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean6);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean7);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean8);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean9);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean10);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean11);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean12);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean13);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean14);

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(10));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenmikeikas(BizCurrency.valueOf(11));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenkeikas(BizCurrency.valueOf(12));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous(BizCurrency.valueOf(13));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous2(BizCurrency.valueOf(14));
                bzSakuinTsnSyoukaiKekkaBean.setTsnsoukktjituhsgk(BizCurrency.valueOf(15));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk1(BizCurrency.valueOf(16));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk2(BizCurrency.valueOf(17));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktitijibrsysnjs(BizCurrency.valueOf(18));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnkgns(BizCurrency.valueOf(19));
                bzSakuinTsnSyoukaiKekkaBean.setTsnmsnynenbtsousbus(BizCurrency.valueOf(20));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnenbtitijibrssbs(BizCurrency.valueOf(21));

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                return bzSakuinTsnSyoukaiKekkaBean;

            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNysjyoutaikbn(C_NayoseJyoutaiKbn.NAYOSEZUMI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);

                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(0);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean1 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean1.setSkmosno("");
                bzSinkeiyakuSakuinKekkaBean1.setSkmfrenflg(C_Mfrenflg.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSktaisyousakuinnmno("1234567890");
                bzSinkeiyakuSakuinKekkaBean1.setSkseiritukbn(C_SeirituKbn.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSkmoskankeisyakbn(C_KankeisyaKbn.KYK);

                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean1);


                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);


                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(0);
                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(0);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(3);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean1 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean1.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhkykkankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhtaisyouseiymd(BizDate.valueOf("20150607"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean2 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean2.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean2.setKhkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bzKeiyakuHozenSakuinKekkaBean2.setKhtaisyouseiymd(BizDate.valueOf("20150606"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean2);

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean3 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean3.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean3.setKhkykkankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzKeiyakuHozenSakuinKekkaBean3.setKhtaisyouseiymd(BizDate.valueOf("20150607"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean3);

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);

                bzSakuinTsnSyoukaiKekkaBean.setMosfkensuu(0);
                List<BzMousikomiFSakuinKekkaBean> bzMousikomiFSakuinKekkaBeanLst = new ArrayList<>();

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean6 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean6.setMosfmossyoumetukbn(C_MossyoumetuKbn.BLNK);
                bzMousikomiFSakuinKekkaBean6.setMosfmoskankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean6);

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(10));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenmikeikas(BizCurrency.valueOf(11));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenkeikas(BizCurrency.valueOf(12));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous(BizCurrency.valueOf(13));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous2(BizCurrency.valueOf(14));
                bzSakuinTsnSyoukaiKekkaBean.setTsnsoukktjituhsgk(BizCurrency.valueOf(15));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk1(BizCurrency.valueOf(16));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk2(BizCurrency.valueOf(17));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktitijibrsysnjs(BizCurrency.valueOf(18));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnkgns(BizCurrency.valueOf(19));
                bzSakuinTsnSyoukaiKekkaBean.setTsnmsnynenbtsousbus(BizCurrency.valueOf(20));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnenbtitijibrssbs(BizCurrency.valueOf(21));

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                return bzSakuinTsnSyoukaiKekkaBean;

            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);

                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(0);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean1 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean1.setSkmosno("");
                bzSinkeiyakuSakuinKekkaBean1.setSkmfrenflg(C_Mfrenflg.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSktaisyousakuinnmno("1234567890");
                bzSinkeiyakuSakuinKekkaBean1.setSkseiritukbn(C_SeirituKbn.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSkmoskankeisyakbn(C_KankeisyaKbn.KYK);

                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(1);
                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                BzKeiyakuMfSakuinKekkaBean bzKeiyakuMfSakuinKekkaBean1 = new BzKeiyakuMfSakuinKekkaBean();
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykjyoutaikbn(C_KykJyoutaiKbn.YUUKOU);
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykkankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzKeiyakuMfSakuinKekkaBean1.setKykmftaisyouseiymd(BizDate.valueOf("20150606"));

                bzkeiyakumfsakuinkekkabeanLst.add(bzKeiyakuMfSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(0);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(0);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean1 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean1.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bzKeiyakuHozenSakuinKekkaBean1.setKhtaisyouseiymd(BizDate.valueOf("20150607"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);

                bzSakuinTsnSyoukaiKekkaBean.setMosfkensuu(0);
                List<BzMousikomiFSakuinKekkaBean> bzMousikomiFSakuinKekkaBeanLst = new ArrayList<>();

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean6 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean6.setMosfmossyoumetukbn(C_MossyoumetuKbn.BLNK);
                bzMousikomiFSakuinKekkaBean6.setMosfmoskankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean6);

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(10));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenmikeikas(BizCurrency.valueOf(11));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenkeikas(BizCurrency.valueOf(12));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous(BizCurrency.valueOf(13));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous2(BizCurrency.valueOf(14));
                bzSakuinTsnSyoukaiKekkaBean.setTsnsoukktjituhsgk(BizCurrency.valueOf(15));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk1(BizCurrency.valueOf(16));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk2(BizCurrency.valueOf(17));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktitijibrsysnjs(BizCurrency.valueOf(18));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnkgns(BizCurrency.valueOf(19));
                bzSakuinTsnSyoukaiKekkaBean.setTsnmsnynenbtsousbus(BizCurrency.valueOf(20));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnenbtitijibrssbs(BizCurrency.valueOf(21));

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNysjyoutaikbn(C_NayoseJyoutaiKbn.NAYOSEZUMI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);

                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(0);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean1 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean1.setSkmosno("");
                bzSinkeiyakuSakuinKekkaBean1.setSkmfrenflg(C_Mfrenflg.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSktaisyousakuinnmno("1234567890");
                bzSinkeiyakuSakuinKekkaBean1.setSkseiritukbn(C_SeirituKbn.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSkmoskankeisyakbn(C_KankeisyaKbn.KYK);

                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(0);
                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(0);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(0);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean1 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean1.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bzKeiyakuHozenSakuinKekkaBean1.setKhtaisyouseiymd(BizDate.valueOf("20150607"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);

                bzSakuinTsnSyoukaiKekkaBean.setMosfkensuu(0);
                List<BzMousikomiFSakuinKekkaBean> bzMousikomiFSakuinKekkaBeanLst = new ArrayList<>();

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean6 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean6.setMosfmossyoumetukbn(C_MossyoumetuKbn.BLNK);
                bzMousikomiFSakuinKekkaBean6.setMosfmoskankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean6);

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(10));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenmikeikas(BizCurrency.valueOf(11));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenkeikas(BizCurrency.valueOf(12));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous(BizCurrency.valueOf(13));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous2(BizCurrency.valueOf(14));
                bzSakuinTsnSyoukaiKekkaBean.setTsnsoukktjituhsgk(BizCurrency.valueOf(15));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk1(BizCurrency.valueOf(16));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk2(BizCurrency.valueOf(17));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktitijibrsysnjs(BizCurrency.valueOf(18));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnkgns(BizCurrency.valueOf(19));
                bzSakuinTsnSyoukaiKekkaBean.setTsnmsnynenbtsousbus(BizCurrency.valueOf(20));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnenbtitijibrssbs(BizCurrency.valueOf(21));

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                return bzSakuinTsnSyoukaiKekkaBean;

            }
            else if (TESTPATTERN13.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNysjyoutaikbn(C_NayoseJyoutaiKbn.NAYOSEZUMI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);

                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(0);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean1 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean1.setSkmosno("");
                bzSinkeiyakuSakuinKekkaBean1.setSkmfrenflg(C_Mfrenflg.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSktaisyousakuinnmno("1234567890");
                bzSinkeiyakuSakuinKekkaBean1.setSkseiritukbn(C_SeirituKbn.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSkmoskankeisyakbn(C_KankeisyaKbn.KYK);

                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(1);
                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                BzKeiyakuMfSakuinKekkaBean bzKeiyakuMfSakuinKekkaBean1 = new BzKeiyakuMfSakuinKekkaBean();
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykjyoutaikbn(C_KykJyoutaiKbn.SIKKOU);
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bzKeiyakuMfSakuinKekkaBean1.setKykmftaisyouseiymd(BizDate.valueOf("20150607"));

                bzkeiyakumfsakuinkekkabeanLst.add(bzKeiyakuMfSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(0);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(1);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean1 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean1.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bzKeiyakuHozenSakuinKekkaBean1.setKhtaisyouseiymd(BizDate.valueOf("20150607"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);

                bzSakuinTsnSyoukaiKekkaBean.setMosfkensuu(0);
                List<BzMousikomiFSakuinKekkaBean> bzMousikomiFSakuinKekkaBeanLst = new ArrayList<>();

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean6 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean6.setMosfmossyoumetukbn(C_MossyoumetuKbn.BLNK);
                bzMousikomiFSakuinKekkaBean6.setMosfmoskankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean6);

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(10));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenmikeikas(BizCurrency.valueOf(11));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenkeikas(BizCurrency.valueOf(12));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous(BizCurrency.valueOf(13));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous2(BizCurrency.valueOf(14));
                bzSakuinTsnSyoukaiKekkaBean.setTsnsoukktjituhsgk(BizCurrency.valueOf(15));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk1(BizCurrency.valueOf(16));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk2(BizCurrency.valueOf(17));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktitijibrsysnjs(BizCurrency.valueOf(18));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnkgns(BizCurrency.valueOf(19));
                bzSakuinTsnSyoukaiKekkaBean.setTsnmsnynenbtsousbus(BizCurrency.valueOf(20));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnenbtitijibrssbs(BizCurrency.valueOf(21));

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                return bzSakuinTsnSyoukaiKekkaBean;

            }
            else if (TESTPATTERN14.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNysjyoutaikbn(C_NayoseJyoutaiKbn.NAYOSEZUMI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);

                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(0);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean1 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean1.setSkmosno("");
                bzSinkeiyakuSakuinKekkaBean1.setSkmfrenflg(C_Mfrenflg.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSktaisyousakuinnmno("1234567890");
                bzSinkeiyakuSakuinKekkaBean1.setSkseiritukbn(C_SeirituKbn.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSkmoskankeisyakbn(C_KankeisyaKbn.KYK);

                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(0);
                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                BzKeiyakuMfSakuinKekkaBean bzKeiyakuMfSakuinKekkaBean1 = new BzKeiyakuMfSakuinKekkaBean();
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykjyoutaikbn(C_KykJyoutaiKbn.YUUKOU);
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bzKeiyakuMfSakuinKekkaBean1.setKykmftaisyouseiymd(BizDate.valueOf("20150607"));

                bzkeiyakumfsakuinkekkabeanLst.add(bzKeiyakuMfSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(0);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(1);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean1 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean1.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bzKeiyakuHozenSakuinKekkaBean1.setKhtaisyouseiymd(BizDate.valueOf("20150606"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);

                bzSakuinTsnSyoukaiKekkaBean.setMosfkensuu(1);
                List<BzMousikomiFSakuinKekkaBean> bzMousikomiFSakuinKekkaBeanLst = new ArrayList<>();

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean6 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean6.setMosfmosno("791112352");
                bzMousikomiFSakuinKekkaBean6.setMosfmfrenflg(C_Mfrenflg.NONE);
                bzMousikomiFSakuinKekkaBean6.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);
                bzMousikomiFSakuinKekkaBean6.setMosfmoskankeisyakbn(C_KankeisyaKbn.KYK);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean6);

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(10));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenmikeikas(BizCurrency.valueOf(11));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenkeikas(BizCurrency.valueOf(12));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous(BizCurrency.valueOf(13));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous2(BizCurrency.valueOf(14));
                bzSakuinTsnSyoukaiKekkaBean.setTsnsoukktjituhsgk(BizCurrency.valueOf(15));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk1(BizCurrency.valueOf(16));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk2(BizCurrency.valueOf(17));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktitijibrsysnjs(BizCurrency.valueOf(18));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnkgns(BizCurrency.valueOf(19));
                bzSakuinTsnSyoukaiKekkaBean.setTsnmsnynenbtsousbus(BizCurrency.valueOf(20));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnenbtitijibrssbs(BizCurrency.valueOf(21));

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                return bzSakuinTsnSyoukaiKekkaBean;

            }
            else if (TESTPATTERN15.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNysjyoutaikbn(C_NayoseJyoutaiKbn.NAYOSEZUMI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);

                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(0);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean1 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean1.setSkmosno("");
                bzSinkeiyakuSakuinKekkaBean1.setSkmfrenflg(C_Mfrenflg.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSktaisyousakuinnmno("1234567890");
                bzSinkeiyakuSakuinKekkaBean1.setSkseiritukbn(C_SeirituKbn.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSkmoskankeisyakbn(C_KankeisyaKbn.KYK);

                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(0);
                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                BzKeiyakuMfSakuinKekkaBean bzKeiyakuMfSakuinKekkaBean1 = new BzKeiyakuMfSakuinKekkaBean();
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykjyoutaikbn(C_KykJyoutaiKbn.YUUKOU);
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bzKeiyakuMfSakuinKekkaBean1.setKykmftaisyouseiymd(BizDate.valueOf("20150607"));

                bzkeiyakumfsakuinkekkabeanLst.add(bzKeiyakuMfSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(0);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(1);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean1 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean1.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bzKeiyakuHozenSakuinKekkaBean1.setKhtaisyouseiymd(BizDate.valueOf("20150606"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);

                bzSakuinTsnSyoukaiKekkaBean.setMosfkensuu(1);
                List<BzMousikomiFSakuinKekkaBean> bzMousikomiFSakuinKekkaBeanLst = new ArrayList<>();

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean6 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean6.setMosfmosno("791112352");
                bzMousikomiFSakuinKekkaBean6.setMosfmfrenflg(C_Mfrenflg.NONE);
                bzMousikomiFSakuinKekkaBean6.setMosfmossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);
                bzMousikomiFSakuinKekkaBean6.setMosfmoskankeisyakbn(C_KankeisyaKbn.KYK);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean6);

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(10));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenmikeikas(BizCurrency.valueOf(11));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenkeikas(BizCurrency.valueOf(12));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous(BizCurrency.valueOf(13));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous2(BizCurrency.valueOf(14));
                bzSakuinTsnSyoukaiKekkaBean.setTsnsoukktjituhsgk(BizCurrency.valueOf(15));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk1(BizCurrency.valueOf(16));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk2(BizCurrency.valueOf(17));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktitijibrsysnjs(BizCurrency.valueOf(18));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnkgns(BizCurrency.valueOf(19));
                bzSakuinTsnSyoukaiKekkaBean.setTsnmsnynenbtsousbus(BizCurrency.valueOf(20));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnenbtitijibrssbs(BizCurrency.valueOf(21));

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                return bzSakuinTsnSyoukaiKekkaBean;

            }
            else if (TESTPATTERN24.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNysjyoutaikbn(C_NayoseJyoutaiKbn.NAYOSEZUMI);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfomrumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfohnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setGaikokupepsumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimositekihndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setDoujimosknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn.HUYOU);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setItekisntkhndktyhkbn(C_YouhiblnkKbn.YOU);
                bzSakuinTsnSyoukaiKekkaBean.setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn.YOU);

                bzSakuinTsnSyoukaiKekkaBean.setSkkensuu(0);
                List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanLst = new ArrayList<>();

                BzSinkeiyakuSakuinKekkaBean bzSinkeiyakuSakuinKekkaBean1 = new BzSinkeiyakuSakuinKekkaBean();
                bzSinkeiyakuSakuinKekkaBean1.setSkmosno("");
                bzSinkeiyakuSakuinKekkaBean1.setSkmfrenflg(C_Mfrenflg.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSktaisyousakuinnmno("1234567890");
                bzSinkeiyakuSakuinKekkaBean1.setSkseiritukbn(C_SeirituKbn.NONE);
                bzSinkeiyakuSakuinKekkaBean1.setSkmoskankeisyakbn(C_KankeisyaKbn.KYK);

                bzsinkeiyakusakuinkekkabeanLst.add(bzSinkeiyakuSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzsinkeiyakusakuinkekkabeanlist(bzsinkeiyakusakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(1);
                List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanLst = new ArrayList<>();

                BzKeiyakuMfSakuinKekkaBean bzKeiyakuMfSakuinKekkaBean1 = new BzKeiyakuMfSakuinKekkaBean();
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykjyoutaikbn(C_KykJyoutaiKbn.SIKKOU);
                bzKeiyakuMfSakuinKekkaBean1.setKykmfkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bzKeiyakuMfSakuinKekkaBean1.setKykmftaisyouseiymd(BizDate.valueOf("20150607"));

                bzkeiyakumfsakuinkekkabeanLst.add(bzKeiyakuMfSakuinKekkaBean1);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(bzkeiyakumfsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setSntkfkensuu(0);
                List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanLst = new ArrayList<>();

                bzSakuinTsnSyoukaiKekkaBean.setBzsentakuinfofsakuinkekkabeanlist(bzsentakuinfofsakuinkekkabeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(1);
                List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist = new ArrayList<>();

                BzKeiyakuHozenSakuinKekkaBean bzKeiyakuHozenSakuinKekkaBean1 = new BzKeiyakuHozenSakuinKekkaBean();
                bzKeiyakuHozenSakuinKekkaBean1.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
                bzKeiyakuHozenSakuinKekkaBean1.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bzKeiyakuHozenSakuinKekkaBean1.setKhtaisyouseiymd(BizDate.valueOf("20150607"));

                bzkeiyakuhozensakuinkekkabeanlist.add(bzKeiyakuHozenSakuinKekkaBean1);

                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(bzkeiyakuhozensakuinkekkabeanlist);

                bzSakuinTsnSyoukaiKekkaBean.setMosfkensuu(0);
                List<BzMousikomiFSakuinKekkaBean> bzMousikomiFSakuinKekkaBeanLst = new ArrayList<>();

                BzMousikomiFSakuinKekkaBean bzMousikomiFSakuinKekkaBean6 = new BzMousikomiFSakuinKekkaBean();
                bzMousikomiFSakuinKekkaBean6.setMosfmossyoumetukbn(C_MossyoumetuKbn.BLNK);
                bzMousikomiFSakuinKekkaBean6.setMosfmoskankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
                bzMousikomiFSakuinKekkaBeanLst.add(bzMousikomiFSakuinKekkaBean6);

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(10));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenmikeikas(BizCurrency.valueOf(11));
                bzSakuinTsnSyoukaiKekkaBean.setTsnninenkeikas(BizCurrency.valueOf(12));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous(BizCurrency.valueOf(13));
                bzSakuinTsnSyoukaiKekkaBean.setTsnketsibous2(BizCurrency.valueOf(14));
                bzSakuinTsnSyoukaiKekkaBean.setTsnsoukktjituhsgk(BizCurrency.valueOf(15));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk1(BizCurrency.valueOf(16));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktjituhsgk2(BizCurrency.valueOf(17));
                bzSakuinTsnSyoukaiKekkaBean.setTsnkktitijibrsysnjs(BizCurrency.valueOf(18));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnkgns(BizCurrency.valueOf(19));
                bzSakuinTsnSyoukaiKekkaBean.setTsnmsnynenbtsousbus(BizCurrency.valueOf(20));
                bzSakuinTsnSyoukaiKekkaBean.setTsnnenbtitijibrssbs(BizCurrency.valueOf(21));

                bzSakuinTsnSyoukaiKekkaBean.setBzmousikomifsakuinkekkabeanlist(bzMousikomiFSakuinKekkaBeanLst);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
        }

        return super.exec(pBzSakuinTsnSyoukaiYokenBean);
    }
}
