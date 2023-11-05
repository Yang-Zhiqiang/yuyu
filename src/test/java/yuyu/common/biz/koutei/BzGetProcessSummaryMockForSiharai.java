package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.siharai.chksk.ChkSubDoujiSeikyuuSyoriTest_exec;
import yuyu.common.siharai.chksk.ChkSubKhSyorityuuTest_exec;
import yuyu.common.siharai.chksk.ChkSubKijyunYmdTest_exec;
import yuyu.common.siharai.koutei.SiProcessForwardTest_exec;
import yuyu.common.siharai.sicommon.BetuskSyorityuChkTest_exec;
import yuyu.common.siharai.sicommon.DouituSyonoStyChkTest_exec;
import yuyu.common.siharai.sicommon.SateiKekkaNyuuryokuChkTest_exec;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SikinouModeIdKbn;

/**
 * {@link BzGetProcessSummary}のモッククラスです。<br />
 */
public class BzGetProcessSummaryMockForSiharai extends BzGetProcessSummary {

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

    public static final String TESTPATTERN25 = "25";

    public static final String TESTPATTERN26_1 = "26-1";

    public static final String TESTPATTERN26_2 = "26-2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public List<BzGetProcessSummaryOutBean> exec(BzGetProcessSummaryInBean pBzGetProcessSummaryInBean) {

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = new ArrayList<>();

        if (caller == ChkSubDoujiSeikyuuSyoriTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setSyoNo("SN002001");

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean1.setSyoNo("SN002002");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setSyoNo("SN002001");

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean1.setSyoNo("SN001001");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setSyoNo("SN002001");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setSyoNo("SN001001");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                return bzGetProcessSummaryOutBeanLst;
            }
        }

        else if (caller == ChkSubKhSyorityuuTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU);
                bzGetProcessSummaryOutBean.setJimuStartYmd(null);
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("解約");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                return bzGetProcessSummaryOutBeanLst;
            }

            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU);
                bzGetProcessSummaryOutBean.setJimuStartYmd(BizDate.valueOf("20160201"));
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("解約");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                return bzGetProcessSummaryOutBeanLst;
            }

            else if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean1.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_GENGAKU);
                bzGetProcessSummaryOutBean1.setJimuStartYmd(BizDate.valueOf("20160201"));
                bzGetProcessSummaryOutBean1.setJimuTetuzukiNm("減額");

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean2.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_STDRSKYTKYKTYTHK);
                bzGetProcessSummaryOutBean2.setJimuStartYmd(BizDate.valueOf("20160201"));
                bzGetProcessSummaryOutBean2.setJimuTetuzukiNm("指定代理請求特約中途付加");

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean3 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean3.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIGOMAEBARAITKHENKOU);
                bzGetProcessSummaryOutBean3.setJimuStartYmd(BizDate.valueOf("20160201"));
                bzGetProcessSummaryOutBean3.setJimuTetuzukiNm("重度介護前払特約変更");

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean4 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean4.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHMKHGKHENKOU);
                bzGetProcessSummaryOutBean4.setJimuStartYmd(BizDate.valueOf("20160201"));
                bzGetProcessSummaryOutBean4.setJimuTetuzukiNm("目標額変更");

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean5 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean5.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHTMTTKINITEN);
                bzGetProcessSummaryOutBean5.setJimuStartYmd(BizDate.valueOf("20160201"));
                bzGetProcessSummaryOutBean5.setJimuTetuzukiNm("積立金移転");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean3);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean4);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean5);

                return bzGetProcessSummaryOutBeanLst;
            }

            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return bzGetProcessSummaryOutBeanLst;
            }

            else if (TESTPATTERN5.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("testJimucd");
                bzGetProcessSummaryOutBean1.setJimuStartYmd(BizDate.valueOf("20160201"));
                bzGetProcessSummaryOutBean1.setJimuTetuzukiNm("テスト事務手続名");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);

                return bzGetProcessSummaryOutBeanLst;
            }

        }

        else if (caller == ChkSubKijyunYmdTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();

                bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();

                bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.KANRYOU);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                return bzGetProcessSummaryOutBeanLst;
            }
        }

        else if (caller == BetuskSyorityuChkTest_exec.class ) {

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                .getInstance(BzGetProcessSummaryOutBean.class);
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return bzGetProcessSummaryOutBeanLst;
            }else if(TESTPATTERN2.equals(SYORIPTN)){
                bzGetProcessSummaryOutBean.setSkNo("00000000002");
                bzGetProcessSummaryOutBean.setNowNodoId("skuke_jingdong");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("");
                bzGetProcessSummaryOutBean.setNowNodoNm("");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }else if(TESTPATTERN3.equals(SYORIPTN)){
                bzGetProcessSummaryOutBean.setSkNo("00000000003");
                bzGetProcessSummaryOutBean.setNowNodoId(TeisuuSiharai.NODEID_INPUT);
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("");
                bzGetProcessSummaryOutBean.setNowNodoNm("");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }else if(TESTPATTERN4.equals(SYORIPTN)){
                bzGetProcessSummaryOutBean.setSkNo("00000000003");
                bzGetProcessSummaryOutBean.setNowNodoId("skuke1_weixin");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("");
                bzGetProcessSummaryOutBean.setNowNodoNm("");
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean1.setSkNo("00000000004");
                bzGetProcessSummaryOutBean1.setNowNodoId(TeisuuSiharai.NODEID_TENKEN);
                bzGetProcessSummaryOutBean1.setJimuTetuzukiNm("");
                bzGetProcessSummaryOutBean1.setNowNodoNm("");
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean2.setSkNo("00000000005");
                bzGetProcessSummaryOutBean2.setNowNodoId("satei1_taobao");
                bzGetProcessSummaryOutBean2.setJimuTetuzukiNm("transaction");
                bzGetProcessSummaryOutBean2.setNowNodoNm("nodeName");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if(TESTPATTERN5.equals(SYORIPTN)){
                bzGetProcessSummaryOutBean.setSkNo("00000000006");
                bzGetProcessSummaryOutBean.setNowNodoId("skuke1_weixin");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("");
                bzGetProcessSummaryOutBean.setNowNodoNm("");
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean1.setSkNo("00000000007");
                bzGetProcessSummaryOutBean1.setNowNodoId("satei1_taobao");
                bzGetProcessSummaryOutBean1.setJimuTetuzukiNm("");
                bzGetProcessSummaryOutBean1.setNowNodoNm("");
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean2.setSkNo("00000000008");
                bzGetProcessSummaryOutBean2.setNowNodoId(TeisuuSiharai.NODEID_SATEI1);
                bzGetProcessSummaryOutBean2.setJimuTetuzukiNm("transaction");
                bzGetProcessSummaryOutBean2.setNowNodoNm("nodeName");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                return bzGetProcessSummaryOutBeanLst;
            }
        }

        else if (caller == SiProcessForwardTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =SWAKInjector.getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowNodoId(C_SikinouModeIdKbn.SATEI1.toString());
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =SWAKInjector.getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowNodoId(C_SikinouModeIdKbn.SATEI2.toString());
                bzGetProcessSummaryOutBean.setKouteiKanriId("10000002");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =SWAKInjector.getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowNodoId(C_SikinouModeIdKbn.SATEI3.toString());
                bzGetProcessSummaryOutBean.setKouteiKanriId("10000002");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =SWAKInjector.getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowNodoId(C_SikinouModeIdKbn.SATEI4.toString());
                bzGetProcessSummaryOutBean.setKouteiKanriId("10000002");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =SWAKInjector.getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowNodoId(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.toString());
                bzGetProcessSummaryOutBean.setKouteiKanriId("10000002");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =SWAKInjector.getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowNodoId(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.toString());
                bzGetProcessSummaryOutBean.setKouteiKanriId("10000002");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =SWAKInjector.getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowNodoId(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.toString());
                bzGetProcessSummaryOutBean.setKouteiKanriId("10000002");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =SWAKInjector.getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowNodoId(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.toString());
                bzGetProcessSummaryOutBean.setKouteiKanriId("10000002");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =SWAKInjector.getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowNodoId(C_SikinouModeIdKbn.SESSYOU2.toString());
                bzGetProcessSummaryOutBean.setKouteiKanriId("10000002");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowNodoId(C_SikinouModeIdKbn.TENKEN.toString());
                bzGetProcessSummaryOutBean.setKouteiKanriId("10000002");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =SWAKInjector.getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowNodoId(C_SikinouModeIdKbn.HUBIKANRITYUU.toString());
                bzGetProcessSummaryOutBean.setKouteiKanriId("10000002");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =SWAKInjector.getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowNodoId(C_SikinouModeIdKbn.HUBISYOUNIN.toString());
                bzGetProcessSummaryOutBean.setKouteiKanriId("10000002");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            return bzGetProcessSummaryOutBeanLst;
        }

        if (caller == SateiKekkaNyuuryokuChkTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setSyoNo("80000000026");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }

        if (caller == DouituSyonoStyChkTest_exec.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                super.exec(pBzGetProcessSummaryInBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                super.exec(pBzGetProcessSummaryInBean);
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setSyoNo("80000000026");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        return super.exec(pBzGetProcessSummaryInBean);
    }
}