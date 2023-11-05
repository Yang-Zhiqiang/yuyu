package yuyu.common.biz.bznayose;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousinTest_exec;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_TjtIdouNySk;

/**
 * {@link BzKykNaiyouHaneiMq}のモッククラスです。<br />
 */
public class BzKykNaiyouHaneiMqMock extends BzKykNaiyouHaneiMq {

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

    @Override
    public BzKykNaiyouHaneiKekkaBean exec(BzKykNaiyouHaneiYokenBean pBzKykNaiyouHaneiYokenBean) {
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean = SWAKInjector.getInstance(BzKykNaiyouHaneiKekkaBean.class);

        if (caller == PALKykNaiyouKousinTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
        }
        else if (caller == PALKykNaiyouKousinTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);
        }
        else if (caller == PALKykNaiyouKousinTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU);
        }
        else if (caller == PALKykNaiyouKousinTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("1000000001");
            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("1000000001");
            bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
            BT_TjtIdouNyKh tjtIdouNyKh = new BT_TjtIdouNyKh();
            tjtIdouNyKh.setSyono(pBzKykNaiyouHaneiYokenBean.getHuho2kykno());
            tjtIdouNyKh.setRenno3keta(1);
            tjtIdouNyKh.setRecordsakujyohyouji(0);
            tjtIdouNyKh.setYoukyuuno("");
            tjtIdouNyKh.setSyouhncd("");
            tjtIdouNyKh.setKykjyoutai(C_Kykjyoutai.BLNK);
            tjtIdouNyKh.setKykymd(null);
            tjtIdouNyKh.setYuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);
            tjtIdouNyKh.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);
            tjtIdouNyKh.setSyoumetuymd(null);
            tjtIdouNyKh.setKyktuukasyu(C_Tuukasyu.BLNK);
            tjtIdouNyKh.setTsntuukasyu(C_Tuukasyu.JPY);
            tjtIdouNyKh.setTsnyousibous(BizCurrency.valueOf(0));
            tjtIdouNyKh.setTsnyouitijip(BizCurrency.valueOf(0));
            tjtIdouNyKh.setTsnyounkgns(BizCurrency.valueOf(0));
            tjtIdouNyKh.setHrkkkn(0);
            tjtIdouNyKh.setSntkhoukbn(C_SntkhouKbn.BLNK);
            tjtIdouNyKh.setBosyuuym(null);
            tjtIdouNyKh.setKykhhkndouhyouji(0);
            tjtIdouNyKh.setTtdktyuuikbn1(C_TtdktyuuiKbn.BLNK);
            tjtIdouNyKh.setTtdktyuuikbn2(C_TtdktyuuiKbn.BLNK);
            tjtIdouNyKh.setTtdktyuuikbn3(C_TtdktyuuiKbn.BLNK);
            tjtIdouNyKh.setTtdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
            tjtIdouNyKh.setTtdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
            tjtIdouNyKh.setTsnyennyknkgk(BizCurrency.valueOf(0));
            tjtIdouNyKh.setHrkkeiro(C_Hrkkeiro.BLNK);
            tjtIdouNyKh.setGyoumuKousinKinou("");
            tjtIdouNyKh.setGyoumuKousinsyaId("");
            tjtIdouNyKh.setGyoumuKousinTime("");

            bzKykNaiyouHaneiKekkaBean.setTjtidounykh(tjtIdouNyKh);
        }
        else if (caller == PALKykNaiyouKousinTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("1000000001");
            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("1000000001");
            bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
            BT_TjtIdouNyKh tjtIdouNyKh = new BT_TjtIdouNyKh();
            tjtIdouNyKh.setSyono("12806345742");
            tjtIdouNyKh.setRenno3keta(111);
            tjtIdouNyKh.setRecordsakujyohyouji(2);
            tjtIdouNyKh.setYoukyuuno("ykno10000187654321");
            tjtIdouNyKh.setSyouhncd("MD11");
            tjtIdouNyKh.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
            tjtIdouNyKh.setKykymd(BizDate.valueOf(20160301));
            tjtIdouNyKh.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
            tjtIdouNyKh.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
            tjtIdouNyKh.setSyoumetuymd(BizDate.valueOf(20160302));
            tjtIdouNyKh.setKyktuukasyu(C_Tuukasyu.JPY);
            tjtIdouNyKh.setTsntuukasyu(C_Tuukasyu.JPY);
            tjtIdouNyKh.setTsnyousibous(BizCurrency.valueOf(456));
            tjtIdouNyKh.setTsnyouitijip(BizCurrency.valueOf(789));
            tjtIdouNyKh.setTsnyounkgns(BizCurrency.valueOf(123));
            tjtIdouNyKh.setHrkkkn(10);
            tjtIdouNyKh.setSntkhoukbn(C_SntkhouKbn.KKT);
            tjtIdouNyKh.setBosyuuym(BizDateYM.valueOf(201603));
            tjtIdouNyKh.setKykhhkndouhyouji(9);
            tjtIdouNyKh.setTtdktyuuikbn1(C_TtdktyuuiKbn.TTDKTYUUOUTAITYUUI);
            tjtIdouNyKh.setTtdktyuuikbn2(C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI);
            tjtIdouNyKh.setTtdktyuuikbn3(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
            tjtIdouNyKh.setTtdktyuuikbn4(C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE);
            tjtIdouNyKh.setTtdktyuuikbn5(C_TtdktyuuiKbn.KYKSYAYUKUEHUMEI);
            tjtIdouNyKh.setTsnyennyknkgk(BizCurrency.valueOf(10000));
            tjtIdouNyKh.setHrkkeiro(C_Hrkkeiro.KOUHURI);
            tjtIdouNyKh.setGyoumuKousinKinou("PALKykNaiyouKousin");
            tjtIdouNyKh.setGyoumuKousinsyaId("khcommon");
            tjtIdouNyKh.setGyoumuKousinTime("20160303121212999");

            bzKykNaiyouHaneiKekkaBean.setTjtidounykh(tjtIdouNyKh);
        }
        else if (caller == PALKykNaiyouKousinTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU);
            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("1000000001");
            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("1000000001");
            bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
        }
        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN1.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
            BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
            tjtIdouNySk.setMosno("791112253");
            tjtIdouNySk.setRenno3keta(1);
            bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

            return bzKykNaiyouHaneiKekkaBean;
        }
        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN2.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);

            return bzKykNaiyouHaneiKekkaBean;
        }
        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN3.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU);
            bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
            return bzKykNaiyouHaneiKekkaBean;
        }
        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN4.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);
            BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
            tjtIdouNySk.setMosno("791112253");
            tjtIdouNySk.setRenno3keta(1);
            bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

            return bzKykNaiyouHaneiKekkaBean;
        }
        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN5.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
            BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
            tjtIdouNySk.setMosno("791112337");
            tjtIdouNySk.setRenno3keta(1);
            bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

            return bzKykNaiyouHaneiKekkaBean;
        }
        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN6.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
            BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
            tjtIdouNySk.setMosno("791112352");
            tjtIdouNySk.setRenno3keta(1);
            bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

            return bzKykNaiyouHaneiKekkaBean;
        }
        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN7.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
            BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
            tjtIdouNySk.setMosno("791112360");
            tjtIdouNySk.setRenno3keta(1);
            bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("10");
            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("20");

            return bzKykNaiyouHaneiKekkaBean;
        }
        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN8.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
            BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
            tjtIdouNySk.setMosno("791112378");
            tjtIdouNySk.setRenno3keta(1);
            bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("10");
            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("20");

            return bzKykNaiyouHaneiKekkaBean;
        }
        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN9.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
            BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
            tjtIdouNySk.setMosno("791112386");
            tjtIdouNySk.setRenno3keta(1);
            bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);
            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("10");
            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("20");

            return bzKykNaiyouHaneiKekkaBean;
        }
        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN10.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
            BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
            tjtIdouNySk.setMosno("791112394");
            tjtIdouNySk.setRenno3keta(1);
            bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("10");
            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("20");

            return bzKykNaiyouHaneiKekkaBean;
        }
        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN11.equals(SYORIPTN)) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
            BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
            tjtIdouNySk.setMosno("791112402");
            tjtIdouNySk.setRenno3keta(1);
            bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.HINDOOVERSYORIHUNOU);
            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("10");
            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("20");

            return bzKykNaiyouHaneiKekkaBean;
        }
        else {
            bzKykNaiyouHaneiKekkaBean = super.exec(pBzKykNaiyouHaneiYokenBean);
        }

        return bzKykNaiyouHaneiKekkaBean;
    }
}
