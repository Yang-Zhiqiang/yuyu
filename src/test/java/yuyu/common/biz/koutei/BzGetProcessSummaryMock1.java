package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutoku;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiTest_exec;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.siharai.chksk.ChkSubKhSyorityuuTest_exec;
import yuyu.common.siharai.sicommon.BetuskSyorityuChkTest_exec;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardImuSateiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKankyouSateiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdateTest_editProcessUpdateForBatchInfo;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_Kouteikanristatus;

/**
 * {@link BzGetProcessSummaryMock}のモッククラスです。<br />
 */
public class BzGetProcessSummaryMock1 extends BzGetProcessSummaryMock {

    @Override
    public List<BzGetProcessSummaryOutBean> exec(BzGetProcessSummaryInBean pBzGetProcessSummaryInBean) {

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = new ArrayList<>();

        if (caller == CheckYuukouJyoutaiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("1234");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名");
                bzGetProcessSummaryOutBean.setNowNodoId("khhubikaisyoa");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("1234");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名");
                bzGetProcessSummaryOutBean.setNowNodoId("khhubikaisyob");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("2345");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名１");
                bzGetProcessSummaryOutBean.setNowNodoId("khhubikaisyob");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名１");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("3456");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名２");
                bzGetProcessSummaryOutBean.setNowNodoId("khhubikaisyoa");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名２");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("1234");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名");
                bzGetProcessSummaryOutBean.setNowNodoId("khhubikaisyob");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("2345");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名１");
                bzGetProcessSummaryOutBean.setNowNodoId("khhubikaisyob");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名１");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("3456");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名２");
                bzGetProcessSummaryOutBean.setNowNodoId("khhubikaisyoa");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名２");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("4567");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名３");
                bzGetProcessSummaryOutBean.setNowNodoId("state-seikyuusyosakusei");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名３");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("5678");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名４");
                bzGetProcessSummaryOutBean.setNowNodoId("state-syoruitoutyaku");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名４");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);


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
        else if (caller == HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutoku.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU ||
                    pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000105");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1");
                    bzGetProcessSummaryOutBean.setJimuStartYmd(BizDate.valueOf("20161101"));
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000116");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000127");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setSkNo("17806000138");
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean1.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean1.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean1.setKouteiKanriId("4");

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }

                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setSkNo("17806000138");
                    bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("khjyuusyohenkou");
                    bzGetProcessSummaryOutBean2.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean2.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean2.setKouteiKanriId("1");

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }


                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setSkNo("17806000149");
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean1.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean1.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean1.setKouteiKanriId("5");

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }

                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setSkNo("17806000149");
                    bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("khjyuusyohenkou");
                    bzGetProcessSummaryOutBean2.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean2.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean2.setKouteiKanriId("2");

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000150");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khjyuusyohenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
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
        else if (caller == HbKeiyakuSyoukaiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean.setNowNodoId("input");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean.setNowNodoId("tenken");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("khsyoukensaihakkou");
                bzGetProcessSummaryOutBean1.setNowNodoId("input");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("khsyoukensaihakkou");
                bzGetProcessSummaryOutBean2.setNowNodoId("tenken");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean3 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean3.setJimuTetuzukiCd("khsyoukensaihakkou");
                bzGetProcessSummaryOutBean3.setNowNodoId("syonin");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean3);
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {

                return bzGetProcessSummaryOutBeanLst;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean1.setNowNodoId("state-seikyuusyosakusei");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean2.setNowNodoId("tenken");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean3 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean3.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean3.setNowNodoId("syonin");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean3);
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean1.setNowNodoId("state-seikyuusyosakusei");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean2.setNowNodoId("tenken");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean3 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean3.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean3.setNowNodoId("input");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean3);
            }
        }
        else if (caller == HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU ||
                    pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000013");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1");
                    bzGetProcessSummaryOutBean.setJimuStartYmd(BizDate.valueOf("20161101"));
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000116");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000127");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setSkNo("17806000138");

                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("khmeigihenkou");

                    bzGetProcessSummaryOutBean1.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean1.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean1.setKouteiKanriId("4");

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }

                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setSkNo("17806000138");

                    bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("khjyuusyohenkou");

                    bzGetProcessSummaryOutBean2.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean2.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean2.setKouteiKanriId("1");
                    bzGetProcessSummaryOutBean2.setJimuStartYmd(BizDate.valueOf("20161101"));

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setSkNo("17806000149");
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean1.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean1.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean1.setKouteiKanriId("5");

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }

                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setSkNo("17806000149");
                    bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("khjyuusyohenkou");
                    bzGetProcessSummaryOutBean2.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean2.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean2.setKouteiKanriId("2");

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000150");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khjyuusyohenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return bzGetProcessSummaryOutBeanLst;
            }
        }

        else if (caller == SkProcessForwardKankyouSateiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1005");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010005");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1006");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010006");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1007");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010007");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1008");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010008");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1008");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010008");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1008");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010008");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1008");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010008");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1003");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010003");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1002");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010002");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1004");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010004");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1001");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("100010001");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }

        }
        else if (caller == SkProcessForwardImuSateiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5102");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skimu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5103");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5104");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5105");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubikaisyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5106");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkeiyakukakunin");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5107");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktorikesi");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5112");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skinputkokuti");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5102");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skimu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5103");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5104");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5102");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skimu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN
                    .equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5108");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("sktenken");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5103");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skkankyou");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5104");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5102");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skimu");
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5104");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skhubitouroku");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5101");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("skmaindairiten");
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        else if (caller == SkProcessUpdateTest_editProcessUpdateForBatchInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5201");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    return bzGetProcessSummaryOutBeanLst;
                }
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);

                if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(pBzGetProcessSummaryInBean
                    .getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5301");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
                else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN.equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriId("5302");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);
                }
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }

        else {

            super.exec(pBzGetProcessSummaryInBean);
        }

        return bzGetProcessSummaryOutBeanLst;
    }
}