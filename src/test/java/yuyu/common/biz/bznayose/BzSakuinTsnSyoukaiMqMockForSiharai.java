package yuyu.common.biz.bznayose;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.siharai.chksk.CheckSbSkNaiyouTest_exec;
import yuyu.common.siharai.sicommon.HanteiSateiRankTest_exec;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_NkKankeisyaKbn;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_Syoumetujiyuu;

/**
 * {@link BzSakuinTsnSyoukaiMq}のモッククラスです。<br />
 */
public class BzSakuinTsnSyoukaiMqMockForSiharai extends BzSakuinTsnSyoukaiMq {

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


    @Override
    public BzSakuinTsnSyoukaiKekkaBean exec(BzSakuinTsnSyoukaiYokenBean pBzSakuinTsnSyoukaiYokenBean) {
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = SWAKInjector
            .getInstance(BzSakuinTsnSyoukaiKekkaBean.class);

        if (caller == HanteiSateiRankTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);
                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(50000001));
                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(50000001));
                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(50000001));
                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(50000000));
                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(49999999));
                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setTsnsibous(BizCurrency.valueOf(49999999));
                return bzSakuinTsnSyoukaiKekkaBean;
            }
        }

        if (caller == CheckSbSkNaiyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setSntkinfohnsyumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSignalinfoumukbn(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsysyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.ARI);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsysyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsysyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsysyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIERROR);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsysyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
        }

        if (caller == BetukutiKeiyakuInfoGetTest_exec.class) {
            if (TESTPATTERN7.equals(SYORIPTN)) {
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuutyoukaumu(C_BlnktkumuKbn.BLNK);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuutyoukaumu(C_BlnktkumuKbn.BLNK);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuutyoukaumu(C_BlnktkumuKbn.BLNK);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuutyoukaumu(C_BlnktkumuKbn.BLNK);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuutyoukaumu(C_BlnktkumuKbn.BLNK);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.NONE);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuutyoukaumu(C_BlnktkumuKbn.ARI);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuu(0);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {
                List<BzNenkinSiharaiSakuinKekkaBean> lst = new ArrayList<>();
                BzNenkinSiharaiSakuinKekkaBean bean = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                bean.setNknksysyno("10000000004");
                bean.setNknkkankeisyakbn(C_NkKankeisyaKbn.NKUKT);
                bean.setNkkykymd(BizDate.valueOf(20160128));
                bean.setNksyoumetuymd(BizDate.valueOf(20160128));
                bean.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                bean.setNksyouhncd("M110");
                bean.setNksyouhnsdno(1);
                lst.add(bean);

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuu(1);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setBznenkinsiharaisakuinkekkabeanlist(lst);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {
                List<BzNenkinSiharaiSakuinKekkaBean> lst = new ArrayList<>();
                BzNenkinSiharaiSakuinKekkaBean bean1 = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                bean1.setNknksysyno("10000000005");
                bean1.setNknkkankeisyakbn(C_NkKankeisyaKbn.NKUKT);
                bean1.setNkkykymd(BizDate.valueOf(20160128));
                bean1.setNksyoumetuymd(BizDate.valueOf(20160128));
                bean1.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                bean1.setNksyouhncd("M110");
                bean1.setNksyouhnsdno(1);
                BzNenkinSiharaiSakuinKekkaBean bean2 = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                bean2.setNknksysyno("10000000015");
                bean2.setNknkkankeisyakbn(C_NkKankeisyaKbn.BLNK);
                bean2.setNkkykymd(BizDate.valueOf(20160128));
                bean2.setNksyoumetuymd(BizDate.valueOf(20160129));
                bean2.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                bean2.setNksyouhncd("M120");
                bean2.setNksyouhnsdno(1);
                BzNenkinSiharaiSakuinKekkaBean bean3 = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                bean3.setNknksysyno("10000000025");
                bean3.setNknkkankeisyakbn(C_NkKankeisyaKbn.NKUKT);
                bean3.setNkkykymd(BizDate.valueOf(20160128));
                bean3.setNksyoumetuymd(BizDate.valueOf(20160128));
                bean3.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                bean3.setNksyouhncd("M110");
                bean3.setNksyouhnsdno(1);
                BzNenkinSiharaiSakuinKekkaBean bean4 = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                bean4.setNknksysyno("10000000035");
                bean4.setNknkkankeisyakbn(C_NkKankeisyaKbn.BLNK);
                bean4.setNkkykymd(BizDate.valueOf(20160128));
                bean4.setNksyoumetuymd(BizDate.valueOf(20160129));
                bean4.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                bean4.setNksyouhncd("M120");
                bean4.setNksyouhnsdno(1);
                BzNenkinSiharaiSakuinKekkaBean bean5 = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                bean5.setNknksysyno("10000000045");
                bean5.setNknkkankeisyakbn(C_NkKankeisyaKbn.NKUKT);
                bean5.setNkkykymd(BizDate.valueOf(20160128));
                bean5.setNksyoumetuymd(BizDate.valueOf(20160128));
                bean5.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                bean5.setNksyouhncd("M110");
                bean5.setNksyouhnsdno(1);
                BzNenkinSiharaiSakuinKekkaBean bean6 = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                bean6.setNknksysyno("10000000055");
                bean6.setNknkkankeisyakbn(C_NkKankeisyaKbn.BLNK);
                bean6.setNkkykymd(BizDate.valueOf(20160128));
                bean6.setNksyoumetuymd(BizDate.valueOf(20160129));
                bean6.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                bean6.setNksyouhncd("M120");
                bean6.setNksyouhnsdno(1);
                BzNenkinSiharaiSakuinKekkaBean bean7 = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                bean7.setNknksysyno("10000000065");
                bean7.setNknkkankeisyakbn(C_NkKankeisyaKbn.NKUKT);
                bean7.setNkkykymd(BizDate.valueOf(20160128));
                bean7.setNksyoumetuymd(BizDate.valueOf(20160128));
                bean7.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                bean7.setNksyouhncd("M110");
                bean7.setNksyouhnsdno(1);
                BzNenkinSiharaiSakuinKekkaBean bean8 = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                bean8.setNknksysyno("10000000075");
                bean8.setNknkkankeisyakbn(C_NkKankeisyaKbn.BLNK);
                bean8.setNkkykymd(BizDate.valueOf(20160128));
                bean8.setNksyoumetuymd(BizDate.valueOf(20160129));
                bean8.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                bean8.setNksyouhncd("M120");
                bean8.setNksyouhnsdno(1);
                BzNenkinSiharaiSakuinKekkaBean bean9 = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                bean9.setNknksysyno("10000000085");
                bean9.setNknkkankeisyakbn(C_NkKankeisyaKbn.NKUKT);
                bean9.setNkkykymd(BizDate.valueOf(20160128));
                bean9.setNksyoumetuymd(BizDate.valueOf(20160128));
                bean9.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                bean9.setNksyouhncd("M110");
                bean9.setNksyouhnsdno(1);
                BzNenkinSiharaiSakuinKekkaBean bean10 = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                bean10.setNknksysyno("10000000095");
                bean10.setNknkkankeisyakbn(C_NkKankeisyaKbn.BLNK);
                bean10.setNkkykymd(BizDate.valueOf(20160128));
                bean10.setNksyoumetuymd(BizDate.valueOf(20160129));
                bean10.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                bean10.setNksyouhncd("M120");
                bean10.setNksyouhnsdno(1);
                lst.add(bean1);
                lst.add(bean2);
                lst.add(bean3);
                lst.add(bean4);
                lst.add(bean5);
                lst.add(bean6);
                lst.add(bean7);
                lst.add(bean8);
                lst.add(bean9);
                lst.add(bean10);

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuu(10);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setBznenkinsiharaisakuinkekkabeanlist(lst);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {
                List<BzKeiyakuHozenSakuinKekkaBean> lst = new ArrayList<>();
                BzKeiyakuHozenSakuinKekkaBean bean = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                bean.setKhsyono("10000000006");
                bean.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bean.setKhkykymd(BizDate.valueOf(20160128));
                bean.setKhsyoumetuymd(BizDate.valueOf(20160201));
                bean.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                bean.setKhsyouhncd("M110");
                bean.setKhsyouhnsdno(1);
                lst.add(bean);

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(1);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(lst);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN13.equals(SYORIPTN)) {
                List<BzKeiyakuHozenSakuinKekkaBean> lst = new ArrayList<>();
                BzKeiyakuHozenSakuinKekkaBean bean0 = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                bean0.setKhsyono("10000000027");
                bean0.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bean0.setKhkykymd(BizDate.valueOf(20160128));
                bean0.setKhsyoumetuymd(BizDate.valueOf(20160201));
                bean0.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                bean0.setKhsyouhncd("M110");
                bean0.setKhsyouhnsdno(1);
                BzKeiyakuHozenSakuinKekkaBean bean1 = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                bean1.setKhsyono("10000000007");
                bean1.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bean1.setKhkykymd(BizDate.valueOf(20160128));
                bean1.setKhsyoumetuymd(BizDate.valueOf(20160201));
                bean1.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                bean1.setKhsyouhncd("M110");
                bean1.setKhsyouhnsdno(1);
                BzKeiyakuHozenSakuinKekkaBean bean2 = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                bean2.setKhsyono("10000000017");
                bean2.setKhkykkankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);
                bean2.setKhkykymd(BizDate.valueOf(20160128));
                bean2.setKhsyoumetuymd(BizDate.valueOf(20160202));
                bean2.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                bean2.setKhsyouhncd("M120");
                bean2.setKhsyouhnsdno(1);
                BzKeiyakuHozenSakuinKekkaBean bean3 = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                bean3.setKhsyono("10000000037");
                bean3.setKhkykkankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);
                bean3.setKhkykymd(BizDate.valueOf(20160128));
                bean3.setKhsyoumetuymd(BizDate.valueOf(20160202));
                bean3.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                bean3.setKhsyouhncd("M120");
                bean3.setKhsyouhnsdno(1);
                BzKeiyakuHozenSakuinKekkaBean bean4 = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                bean4.setKhsyono("10000000047");
                bean4.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bean4.setKhkykymd(BizDate.valueOf(20160128));
                bean4.setKhsyoumetuymd(BizDate.valueOf(20160201));
                bean4.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                bean4.setKhsyouhncd("M110");
                bean4.setKhsyouhnsdno(1);
                BzKeiyakuHozenSakuinKekkaBean bean5 = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                bean5.setKhsyono("10000000057");
                bean5.setKhkykkankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);
                bean5.setKhkykymd(BizDate.valueOf(20160128));
                bean5.setKhsyoumetuymd(BizDate.valueOf(20160202));
                bean5.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                bean5.setKhsyouhncd("M120");
                bean5.setKhsyouhnsdno(1);
                BzKeiyakuHozenSakuinKekkaBean bean6 = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                bean6.setKhsyono("10000000067");
                bean6.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bean6.setKhkykymd(BizDate.valueOf(20160128));
                bean6.setKhsyoumetuymd(BizDate.valueOf(20160201));
                bean6.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                bean6.setKhsyouhncd("M110");
                bean6.setKhsyouhnsdno(1);
                BzKeiyakuHozenSakuinKekkaBean bean7 = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                bean7.setKhsyono("10000000077");
                bean7.setKhkykkankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);
                bean7.setKhkykymd(BizDate.valueOf(20160128));
                bean7.setKhsyoumetuymd(BizDate.valueOf(20160202));
                bean7.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                bean7.setKhsyouhncd("M120");
                bean7.setKhsyouhnsdno(1);
                BzKeiyakuHozenSakuinKekkaBean bean8 = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                bean8.setKhsyono("10000000097");
                bean8.setKhkykkankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);
                bean8.setKhkykymd(BizDate.valueOf(20160128));
                bean8.setKhsyoumetuymd(BizDate.valueOf(20160202));
                bean8.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                bean8.setKhsyouhncd("M120");
                bean8.setKhsyouhnsdno(1);
                BzKeiyakuHozenSakuinKekkaBean bean9 = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                bean9.setKhsyono("10000000087");
                bean9.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bean9.setKhkykymd(BizDate.valueOf(20160128));
                bean9.setKhsyoumetuymd(BizDate.valueOf(20160201));
                bean9.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                bean9.setKhsyouhncd("M110");
                bean9.setKhsyouhnsdno(1);

                lst.add(bean0);
                lst.add(bean1);
                lst.add(bean2);
                lst.add(bean3);
                lst.add(bean4);
                lst.add(bean5);
                lst.add(bean6);
                lst.add(bean7);
                lst.add(bean8);
                lst.add(bean9);

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(10);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(lst);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN14.equals(SYORIPTN)) {
                List<BzKeiyakuMfSakuinKekkaBean> lst1 = new ArrayList<>();
                BzKeiyakuMfSakuinKekkaBean bean1 = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                bean1.setKykmfsyono("10000000008");
                bean1.setKykmfkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bean1.setKykmfkykymd(BizDate.valueOf(20160128));
                bean1.setKykmfsyoumetuymd(BizDate.valueOf(20160201));
                bean1.setKykmfsyoumetucd(null);
                List<BzSougouNenkinSiharaiFSakuinKekkaBean> lst2 = new ArrayList<>();
                BzSougouNenkinSiharaiFSakuinKekkaBean bean2 = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                bean2.setSounenfnksysyno("10000000018");
                bean2.setSounenfnkkankeisyakbn(C_NkKankeisyaKbn.NKUKT);
                bean2.setSounenfkykymd(BizDate.valueOf(20160128));
                bean2.setSounenfsyoumetuymd(BizDate.valueOf(20160202));
                bean2.setSounenfnksyoumetucd("年金終了");
                lst1.add(bean1);
                lst2.add(bean2);

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(1);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuu(1);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(lst1);
                bzSakuinTsnSyoukaiKekkaBean.setBzsougounenkinsiharaifsakuinkekkabeanlist(lst2);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN15.equals(SYORIPTN)) {
                List<BzHokenkinSueokiFSakuinKekkaBean> lst = new ArrayList<>();
                BzHokenkinSueokiFSakuinKekkaBean bean = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                bean.setSueokifsysyno("10000000009");
                bean.setSueokifhknkinkankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);
                lst.add(bean);

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuu(1);
                bzSakuinTsnSyoukaiKekkaBean.setBzhokenkinsueokifsakuinkekkabeanlist(lst);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN16.equals(SYORIPTN)) {
                List<BzKeiyakuMfSakuinKekkaBean> lst1 = new ArrayList<>();
                BzKeiyakuMfSakuinKekkaBean bean0 = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                bean0.setKykmfsyono("10000000010");
                bean0.setKykmfkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bean0.setKykmfkykymd(BizDate.valueOf(20160128));
                bean0.setKykmfsyoumetuymd(BizDate.valueOf(20160203));
                BzKeiyakuMfSakuinKekkaBean bean1 = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                bean1.setKykmfsyono("10000000011");
                bean1.setKykmfkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bean1.setKykmfkykymd(BizDate.valueOf(20160128));
                bean1.setKykmfsyoumetuymd(BizDate.valueOf(20160204));
                BzKeiyakuMfSakuinKekkaBean bean2 = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                bean2.setKykmfsyono("10000000012");
                bean2.setKykmfkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bean2.setKykmfkykymd(BizDate.valueOf(20160128));
                bean2.setKykmfsyoumetuymd(BizDate.valueOf(20160203));
                BzKeiyakuMfSakuinKekkaBean bean3 = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                bean3.setKykmfsyono("10000000013");
                bean3.setKykmfkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bean3.setKykmfkykymd(BizDate.valueOf(20160128));
                bean3.setKykmfsyoumetuymd(BizDate.valueOf(20160204));
                BzKeiyakuMfSakuinKekkaBean bean4 = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                bean4.setKykmfsyono("10000000014");
                bean4.setKykmfkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bean4.setKykmfkykymd(BizDate.valueOf(20160128));
                bean4.setKykmfsyoumetuymd(BizDate.valueOf(20160203));
                BzKeiyakuMfSakuinKekkaBean bean5 = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                bean5.setKykmfsyono("10000000015");
                bean5.setKykmfkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bean5.setKykmfkykymd(BizDate.valueOf(20160128));
                bean5.setKykmfsyoumetuymd(BizDate.valueOf(20160204));
                BzKeiyakuMfSakuinKekkaBean bean6 = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                bean6.setKykmfsyono("10000000016");
                bean6.setKykmfkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bean6.setKykmfkykymd(BizDate.valueOf(20160128));
                bean6.setKykmfsyoumetuymd(BizDate.valueOf(20160203));
                BzKeiyakuMfSakuinKekkaBean bean7 = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                bean7.setKykmfsyono("10000000017");
                bean7.setKykmfkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bean7.setKykmfkykymd(BizDate.valueOf(20160128));
                bean7.setKykmfsyoumetuymd(BizDate.valueOf(20160204));
                BzKeiyakuMfSakuinKekkaBean bean8 = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                bean8.setKykmfsyono("10000000018");
                bean8.setKykmfkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bean8.setKykmfkykymd(BizDate.valueOf(20160128));
                bean8.setKykmfsyoumetuymd(BizDate.valueOf(20160203));
                BzKeiyakuMfSakuinKekkaBean bean9 = SWAKInjector.getInstance(BzKeiyakuMfSakuinKekkaBean.class);
                bean9.setKykmfsyono("10000000019");
                bean9.setKykmfkykkankeisyakbn(C_KankeisyaKbn.BLNK);
                bean9.setKykmfkykymd(BizDate.valueOf(20160128));
                bean9.setKykmfsyoumetuymd(BizDate.valueOf(20160204));
                lst1.add(bean0);
                lst1.add(bean1);
                lst1.add(bean2);
                lst1.add(bean3);
                lst1.add(bean4);
                lst1.add(bean5);
                lst1.add(bean6);
                lst1.add(bean7);
                lst1.add(bean8);
                lst1.add(bean9);

                List<BzSougouNenkinSiharaiFSakuinKekkaBean> lst2 = new ArrayList<>();
                BzSougouNenkinSiharaiFSakuinKekkaBean bean10 = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                bean10.setSounenfnksysyno("10000000020");
                bean10.setSounenfnkkankeisyakbn(C_NkKankeisyaKbn.NKUKT);
                bean10.setSounenfkykymd(BizDate.valueOf(20160128));
                bean10.setSounenfsyoumetuymd(BizDate.valueOf(20160205));
                BzSougouNenkinSiharaiFSakuinKekkaBean bean11 = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                bean11.setSounenfnksysyno("10000000021");
                bean11.setSounenfnkkankeisyakbn(C_NkKankeisyaKbn.BLNK);
                bean11.setSounenfkykymd(BizDate.valueOf(20160128));
                bean11.setSounenfsyoumetuymd(BizDate.valueOf(20160206));
                BzSougouNenkinSiharaiFSakuinKekkaBean bean12 = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                bean12.setSounenfnksysyno("10000000022");
                bean12.setSounenfnkkankeisyakbn(C_NkKankeisyaKbn.NKUKT);
                bean12.setSounenfkykymd(BizDate.valueOf(20160128));
                bean12.setSounenfsyoumetuymd(BizDate.valueOf(20160205));
                BzSougouNenkinSiharaiFSakuinKekkaBean bean13 = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                bean13.setSounenfnksysyno("10000000023");
                bean13.setSounenfnkkankeisyakbn(C_NkKankeisyaKbn.BLNK);
                bean13.setSounenfkykymd(BizDate.valueOf(20160128));
                bean13.setSounenfsyoumetuymd(BizDate.valueOf(20160206));
                BzSougouNenkinSiharaiFSakuinKekkaBean bean14 = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                bean14.setSounenfnksysyno("10000000024");
                bean14.setSounenfnkkankeisyakbn(C_NkKankeisyaKbn.NKUKT);
                bean14.setSounenfkykymd(BizDate.valueOf(20160128));
                bean14.setSounenfsyoumetuymd(BizDate.valueOf(20160205));
                BzSougouNenkinSiharaiFSakuinKekkaBean bean15 = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                bean15.setSounenfnksysyno("10000000025");
                bean15.setSounenfnkkankeisyakbn(C_NkKankeisyaKbn.BLNK);
                bean15.setSounenfkykymd(BizDate.valueOf(20160128));
                bean15.setSounenfsyoumetuymd(BizDate.valueOf(20160206));
                BzSougouNenkinSiharaiFSakuinKekkaBean bean16 = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                bean16.setSounenfnksysyno("10000000026");
                bean16.setSounenfnkkankeisyakbn(C_NkKankeisyaKbn.NKUKT);
                bean16.setSounenfkykymd(BizDate.valueOf(20160128));
                bean16.setSounenfsyoumetuymd(BizDate.valueOf(20160205));
                BzSougouNenkinSiharaiFSakuinKekkaBean bean17 = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                bean17.setSounenfnksysyno("10000000027");
                bean17.setSounenfnkkankeisyakbn(C_NkKankeisyaKbn.BLNK);
                bean17.setSounenfkykymd(BizDate.valueOf(20160128));
                bean17.setSounenfsyoumetuymd(BizDate.valueOf(20160206));
                BzSougouNenkinSiharaiFSakuinKekkaBean bean18 = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                bean18.setSounenfnksysyno("10000000028");
                bean18.setSounenfnkkankeisyakbn(C_NkKankeisyaKbn.NKUKT);
                bean18.setSounenfkykymd(BizDate.valueOf(20160128));
                bean18.setSounenfsyoumetuymd(BizDate.valueOf(20160205));
                BzSougouNenkinSiharaiFSakuinKekkaBean bean19 = SWAKInjector.getInstance(BzSougouNenkinSiharaiFSakuinKekkaBean.class);
                bean19.setSounenfnksysyno("10000000029");
                bean19.setSounenfnkkankeisyakbn(C_NkKankeisyaKbn.BLNK);
                bean19.setSounenfkykymd(BizDate.valueOf(20160128));
                bean19.setSounenfsyoumetuymd(BizDate.valueOf(20160206));
                lst2.add(bean10);
                lst2.add(bean11);
                lst2.add(bean12);
                lst2.add(bean13);
                lst2.add(bean14);
                lst2.add(bean15);
                lst2.add(bean16);
                lst2.add(bean17);
                lst2.add(bean18);
                lst2.add(bean19);

                List<BzHokenkinSueokiFSakuinKekkaBean> lst3 = new ArrayList<>();
                BzHokenkinSueokiFSakuinKekkaBean bean20 = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                bean20.setSueokifsysyno("10000000030");
                bean20.setSueokifhknkinkankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);
                BzHokenkinSueokiFSakuinKekkaBean bean21 = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                bean21.setSueokifsysyno("10000000031");
                bean21.setSueokifhknkinkankeisyakbn(C_KankeisyaKbn.BLNK);
                BzHokenkinSueokiFSakuinKekkaBean bean22 = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                bean22.setSueokifsysyno("10000000032");
                bean22.setSueokifhknkinkankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);
                BzHokenkinSueokiFSakuinKekkaBean bean23 = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                bean23.setSueokifsysyno("10000000033");
                bean23.setSueokifhknkinkankeisyakbn(C_KankeisyaKbn.BLNK);
                BzHokenkinSueokiFSakuinKekkaBean bean24 = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                bean24.setSueokifsysyno("10000000034");
                bean24.setSueokifhknkinkankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);
                BzHokenkinSueokiFSakuinKekkaBean bean25 = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                bean25.setSueokifsysyno("10000000035");
                bean25.setSueokifhknkinkankeisyakbn(C_KankeisyaKbn.BLNK);
                BzHokenkinSueokiFSakuinKekkaBean bean26 = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                bean26.setSueokifsysyno("10000000036");
                bean26.setSueokifhknkinkankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);
                BzHokenkinSueokiFSakuinKekkaBean bean27 = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                bean27.setSueokifsysyno("10000000037");
                bean27.setSueokifhknkinkankeisyakbn(C_KankeisyaKbn.BLNK);
                BzHokenkinSueokiFSakuinKekkaBean bean28 = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                bean28.setSueokifsysyno("10000000038");
                bean28.setSueokifhknkinkankeisyakbn(C_KankeisyaKbn.SUEOKIUKT);
                BzHokenkinSueokiFSakuinKekkaBean bean29 = SWAKInjector.getInstance(BzHokenkinSueokiFSakuinKekkaBean.class);
                bean29.setSueokifsysyno("10000000039");
                bean29.setSueokifhknkinkankeisyakbn(C_KankeisyaKbn.BLNK);
                lst3.add(bean20);
                lst3.add(bean21);
                lst3.add(bean22);
                lst3.add(bean23);
                lst3.add(bean24);
                lst3.add(bean25);
                lst3.add(bean26);
                lst3.add(bean27);
                lst3.add(bean28);
                lst3.add(bean29);

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(10);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuu(10);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuu(10);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakumfsakuinkekkabeanlist(lst1);
                bzSakuinTsnSyoukaiKekkaBean.setBzsougounenkinsiharaifsakuinkekkabeanlist(lst2);
                bzSakuinTsnSyoukaiKekkaBean.setBzhokenkinsueokifsakuinkekkabeanlist(lst3);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
            else if (TESTPATTERN17.equals(SYORIPTN)) {
                List<BzKeiyakuHozenSakuinKekkaBean> lst1 = new ArrayList<>();
                BzKeiyakuHozenSakuinKekkaBean bean1 = SWAKInjector.getInstance(BzKeiyakuHozenSakuinKekkaBean.class);
                bean1.setKhsyono("10000000110");
                bean1.setKhkykkankeisyakbn(C_KankeisyaKbn.KYK);
                bean1.setKhkykymd(BizDate.valueOf(20160128));
                bean1.setKhsyoumetuymd(BizDate.valueOf(20170505));
                bean1.setKhsyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
                bean1.setKhsyouhncd("M110");
                bean1.setKhsyouhnsdno(1);
                lst1.add(bean1);

                List<BzNenkinSiharaiSakuinKekkaBean> lst2 = new ArrayList<>();
                BzNenkinSiharaiSakuinKekkaBean bean2 = SWAKInjector.getInstance(BzNenkinSiharaiSakuinKekkaBean.class);
                bean2.setNknksysyno("10000000120");
                bean2.setNknkkankeisyakbn(C_NkKankeisyaKbn.NKUKT);
                bean2.setNkkykymd(BizDate.valueOf(20160130));
                bean2.setNksyoumetuymd(BizDate.valueOf(20170505));
                bean2.setNknksyoumetucd(C_NkSyoumetuCd.SYUURYOU);
                bean2.setNksyouhncd("M110");
                bean2.setNksyouhnsdno(2);
                lst2.add(bean2);

                bzSakuinTsnSyoukaiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzSakuinTsnSyoukaiKekkaBean.setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn.SYOUKAIOK);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuutyoukaumu(C_BlnktkumuKbn.ARI);
                bzSakuinTsnSyoukaiKekkaBean.setKhkensuu(1);
                bzSakuinTsnSyoukaiKekkaBean.setNkkensuu(1);
                bzSakuinTsnSyoukaiKekkaBean.setKykmfkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setNkfkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setSueokifkensuu(0);
                bzSakuinTsnSyoukaiKekkaBean.setBzkeiyakuhozensakuinkekkabeanlist(lst1);
                bzSakuinTsnSyoukaiKekkaBean.setBznenkinsiharaisakuinkekkabeanlist(lst2);

                return bzSakuinTsnSyoukaiKekkaBean;
            }
        }
        return super.exec(pBzSakuinTsnSyoukaiYokenBean);
    }
}
