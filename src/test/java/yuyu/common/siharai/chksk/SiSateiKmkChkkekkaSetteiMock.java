package yuyu.common.siharai.chksk;

import java.util.List;

import com.google.common.collect.Lists;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SikinouModeIdKbn;

/**
 * {@link SiSateiKmkChkkekkaSettei}のモッククラスです。<br />
 */
public class SiSateiKmkChkkekkaSetteiMock extends SiSateiKmkChkkekkaSettei {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(C_SeikyuuSyubetu pSeikyuuSyubetu, String pYobidasiMotoKinouID,
        C_SikinouModeIdKbn pYobidasiMotoTaskID,
        CheckSbSkNaiyouKekkaBean pCheckSbSkNaiyouKekkaBean, CheckKdSkNaiyouKekkaBean pCheckKdSkNaiyouKekkaBean,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                List<ChkKekkaBean> list = Lists.newArrayList();

                ChkKekkaBean chkKekkaBean1 = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean1.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_KSYOUHI);
                list.add(chkKekkaBean1);

                ChkKekkaBean chkKekkaBean2 = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean2.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_HUSYOU_BYOUMEI);
                list.add(chkKekkaBean2);

                ChkKekkaBean chkKekkaBean3 = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean3.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_KAIGAISIBOU);
                list.add(chkKekkaBean3);

                ChkKekkaBean chkKekkaBean4 = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean4.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_HANSYA);
                list.add(chkKekkaBean4);

                pCheckSbSkNaiyouKekkaBean.setChkKekkaBeanList(list);

                pCheckSbSkNaiyouKekkaBean.setSateiKoumokuMessage("名義変更査定要,不詳の死,海外死亡,反社");
                return;

            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                List<ChkKekkaBean> list = Lists.newArrayList();

                ChkKekkaBean chkKekkaBean1 = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean1.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI);
                list.add(chkKekkaBean1);

                pCheckSbSkNaiyouKekkaBean.setChkKekkaBeanList(list);

                pCheckSbSkNaiyouKekkaBean.setSateiKoumokuMessage("免責期間中の自殺");
                return;

            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                List<ChkKekkaBean> list = Lists.newArrayList();

                ChkKekkaBean chkKekkaBean1 = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean1.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SKNNKAISIYMD);
                list.add(chkKekkaBean1);

                pCheckSbSkNaiyouKekkaBean.setChkKekkaBeanList(list);

                pCheckSbSkNaiyouKekkaBean.setSateiKoumokuMessage("早期支払請求 解除注意");
                return;

            }

            if (TESTPATTERN4.equals(SYORIPTN)) {

                List<ChkKekkaBean> list = Lists.newArrayList();

                ChkKekkaBean chkKekkaBean1 = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean1.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_STKNSET_UMU);
                list.add(chkKekkaBean1);

                pCheckSbSkNaiyouKekkaBean.setChkKekkaBeanList(list);

                pCheckSbSkNaiyouKekkaBean.setSateiKoumokuMessage("質権設定契約");
                return;

            }

            if (TESTPATTERN5.equals(SYORIPTN)) {

                List<ChkKekkaBean> list = Lists.newArrayList();

                ChkKekkaBean chkKekkaBean1 = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean1.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_HASANTOUSAN);
                list.add(chkKekkaBean1);

                pCheckSbSkNaiyouKekkaBean.setChkKekkaBeanList(list);

                pCheckSbSkNaiyouKekkaBean.setSateiKoumokuMessage("破産および倒産");
                return;

            }

            if (TESTPATTERN6.equals(SYORIPTN)) {

                List<ChkKekkaBean> list = Lists.newArrayList();

                ChkKekkaBean chkKekkaBean1 = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean1.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SASIOSAE);
                list.add(chkKekkaBean1);

                pCheckSbSkNaiyouKekkaBean.setChkKekkaBeanList(list);

                pCheckSbSkNaiyouKekkaBean.setSateiKoumokuMessage("差押");
                return;

            }

            if (TESTPATTERN7.equals(SYORIPTN)) {

                List<ChkKekkaBean> list = Lists.newArrayList();

                ChkKekkaBean chkKekkaBean1 = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean1.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SOUSASYOUKAI);
                list.add(chkKekkaBean1);

                pCheckSbSkNaiyouKekkaBean.setChkKekkaBeanList(list);

                pCheckSbSkNaiyouKekkaBean.setSateiKoumokuMessage("捜査照会");
                return;

            }

            if (TESTPATTERN8.equals(SYORIPTN)) {

                List<ChkKekkaBean> list = Lists.newArrayList();

                ChkKekkaBean chkKekkaBean1 = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean1.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SKSYORUI);
                list.add(chkKekkaBean1);

                pCheckSbSkNaiyouKekkaBean.setChkKekkaBeanList(list);

                pCheckSbSkNaiyouKekkaBean.setSateiKoumokuMessage("精算金振込依頼書あり");
                return;

            }

        }

        super.exec(pSeikyuuSyubetu, pYobidasiMotoKinouID, pYobidasiMotoTaskID, pCheckSbSkNaiyouKekkaBean,
            pCheckKdSkNaiyouKekkaBean, pChkKekkaBeanLst);
    }

}
