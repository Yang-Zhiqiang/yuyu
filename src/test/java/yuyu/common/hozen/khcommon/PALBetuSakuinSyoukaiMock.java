package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.hozen.setuibean.SetBetukykTest_exec;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * {@link PALBetuSakuinSyoukai}のモッククラスです。<br />
 */
public class PALBetuSakuinSyoukaiMock extends PALBetuSakuinSyoukai {

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

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private PALBetuSakuinSyoukaiKekkaBean palBetuSakuinSyoukaiKekkaBean;

    private List<String> worningMsgIdList;

    private List<String> worningMsgList;

    @Override
    public boolean exec(String pSyono, C_SakuintsnTaisyouKbn pCSakuintsnTaisyouKbn,
        C_SakuintaisyoukykKbn pCSakuintaisyoukykKbn) {

        palBetuSakuinSyoukaiKekkaBean = SWAKInjector.getInstance(PALBetuSakuinSyoukaiKekkaBean.class);

        worningMsgIdList = new ArrayList<String>();
        worningMsgList = new ArrayList<String>();

        if (TESTPATTERN1.equals(SYORIPTN) && caller == SetBetukykTest_exec.class) {

            palBetuSakuinSyoukaiKekkaBean.setKkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(0);
            worningMsgIdList.add("WIA1006");
            worningMsgList.add("別契約欄に表示できない契約があります。索引照会で確認してください。");

        }
        else if (TESTPATTERN2.equals(SYORIPTN) && caller == SetBetukykTest_exec.class)
        {
            palBetuSakuinSyoukaiKekkaBean.setKkkensuu(1);
            palBetuSakuinSyoukaiKekkaBean.setNkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(0);

            List<KykSakuinKekkaBean> kykSakuinKekkaBeanList = new ArrayList<>();
            KykSakuinKekkaBean kykSakuinKekkaBean = new KykSakuinKekkaBean();
            kykSakuinKekkaBean.setKhSyouhnCd("1");
            kykSakuinKekkaBean.setKhsyouhnsdno(0);
            kykSakuinKekkaBean.setKykSyoNo("17806000035");
            kykSakuinKekkaBean.setKykYuukSumtKbn(C_YuukousyoumetuKbn.YUUKOU);
            kykSakuinKekkaBean.setKykKykJyoutai(C_Kykjyoutai.HARAIMAN);
            kykSakuinKekkaBean.setKykKykYMD(BizDate.valueOf(20140101));
            kykSakuinKekkaBean.setKykSumetuJiyuu(C_Syoumetujiyuu.KYKTORIKESI);
            kykSakuinKekkaBean.setKykSyoumetuYMD(BizDate.valueOf(20140102));
            kykSakuinKekkaBeanList.add(kykSakuinKekkaBean);

            palBetuSakuinSyoukaiKekkaBean.setKykSakuinKekkaBeanList(kykSakuinKekkaBeanList);
        }
        else if (TESTPATTERN3.equals(SYORIPTN) && caller == SetBetukykTest_exec.class)
        {

            palBetuSakuinSyoukaiKekkaBean.setKkkensuu(1);
            palBetuSakuinSyoukaiKekkaBean.setNkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(0);

            List<KykSakuinKekkaBean> kykSakuinKekkaBeanList = new ArrayList<>();
            KykSakuinKekkaBean kykSakuinKekkaBean = new KykSakuinKekkaBean();
            kykSakuinKekkaBean.setKhSyouhnCd("1");
            kykSakuinKekkaBean.setKhsyouhnsdno(2);
            kykSakuinKekkaBean.setKykSyoNo("17806000057");
            kykSakuinKekkaBean.setKykYuukSumtKbn(C_YuukousyoumetuKbn.YUUKOU);
            kykSakuinKekkaBean.setKykKykJyoutai(C_Kykjyoutai.HARAIMAN);
            kykSakuinKekkaBean.setKykKykYMD(BizDate.valueOf(20140101));
            kykSakuinKekkaBean.setKykSumetuJiyuu(C_Syoumetujiyuu.KYKTORIKESI);
            kykSakuinKekkaBean.setKykSyoumetuYMD(BizDate.valueOf(20140102));
            kykSakuinKekkaBeanList.add(kykSakuinKekkaBean);

            palBetuSakuinSyoukaiKekkaBean.setKykSakuinKekkaBeanList(kykSakuinKekkaBeanList);
        }
        else if (TESTPATTERN4.equals(SYORIPTN) && caller == SetBetukykTest_exec.class)
        {

            palBetuSakuinSyoukaiKekkaBean.setKkkensuu(3);
            palBetuSakuinSyoukaiKekkaBean.setNkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(0);

            List<KykSakuinKekkaBean> kykSakuinKekkaBeanList = new ArrayList<>();
            KykSakuinKekkaBean kykSakuinKekkaBean1 = new KykSakuinKekkaBean();
            kykSakuinKekkaBean1.setKhSyouhnCd("1");
            kykSakuinKekkaBean1.setKhsyouhnsdno(0);
            kykSakuinKekkaBean1.setKykSyoNo("17806000068");
            kykSakuinKekkaBean1.setKykYuukSumtKbn(C_YuukousyoumetuKbn.YUUKOU);
            kykSakuinKekkaBean1.setKykKykJyoutai(C_Kykjyoutai.HARAIMAN);
            kykSakuinKekkaBean1.setKykKykYMD(BizDate.valueOf(20140101));
            kykSakuinKekkaBean1.setKykSumetuJiyuu(C_Syoumetujiyuu.KYKTORIKESI);
            kykSakuinKekkaBean1.setKykSyoumetuYMD(BizDate.valueOf(20140102));
            kykSakuinKekkaBeanList.add(kykSakuinKekkaBean1);

            KykSakuinKekkaBean kykSakuinKekkaBean2 = new KykSakuinKekkaBean();
            kykSakuinKekkaBean2.setKhSyouhnCd("1");
            kykSakuinKekkaBean2.setKhsyouhnsdno(1);
            kykSakuinKekkaBean2.setKykSyoNo("17806000068");
            kykSakuinKekkaBean2.setKykYuukSumtKbn(C_YuukousyoumetuKbn.SYOUMETU);
            kykSakuinKekkaBean2.setKykKykJyoutai(C_Kykjyoutai.HRKMTYUU);
            kykSakuinKekkaBean2.setKykKykYMD(BizDate.valueOf(20150101));
            kykSakuinKekkaBean2.setKykSumetuJiyuu(C_Syoumetujiyuu.MUKOU);
            kykSakuinKekkaBean2.setKykSyoumetuYMD(BizDate.valueOf(20150102));
            kykSakuinKekkaBeanList.add(kykSakuinKekkaBean2);

            KykSakuinKekkaBean kykSakuinKekkaBean3 = new KykSakuinKekkaBean();
            kykSakuinKekkaBean3.setKhSyouhnCd("1");
            kykSakuinKekkaBean3.setKhsyouhnsdno(1);
            kykSakuinKekkaBean3.setKykSyoNo("17806000068");
            kykSakuinKekkaBean3.setKykYuukSumtKbn(C_YuukousyoumetuKbn.SYOUMETU);
            kykSakuinKekkaBean3.setKykKykJyoutai(C_Kykjyoutai.HRKMTYUU);
            kykSakuinKekkaBean3.setKykKykYMD(BizDate.valueOf(20160101));
            kykSakuinKekkaBean3.setKykSumetuJiyuu(C_Syoumetujiyuu.MUKOU);
            kykSakuinKekkaBean3.setKykSyoumetuYMD(BizDate.valueOf(20160102));
            kykSakuinKekkaBeanList.add(kykSakuinKekkaBean3);

            palBetuSakuinSyoukaiKekkaBean.setKykSakuinKekkaBeanList(kykSakuinKekkaBeanList);
        }
        else if (TESTPATTERN5.equals(SYORIPTN) && caller == SetBetukykTest_exec.class)
        {

            palBetuSakuinSyoukaiKekkaBean.setKkkensuu(3);
            palBetuSakuinSyoukaiKekkaBean.setNkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(0);

            List<KykSakuinKekkaBean> kykSakuinKekkaBeanList = new ArrayList<>();
            KykSakuinKekkaBean kykSakuinKekkaBean1 = new KykSakuinKekkaBean();
            kykSakuinKekkaBean1.setKhSyouhnCd("1");
            kykSakuinKekkaBean1.setKhsyouhnsdno(2);
            kykSakuinKekkaBean1.setKykSyoNo("17806000079");
            kykSakuinKekkaBean1.setKykYuukSumtKbn(C_YuukousyoumetuKbn.YUUKOU);
            kykSakuinKekkaBean1.setKykKykJyoutai(C_Kykjyoutai.HARAIMAN);
            kykSakuinKekkaBean1.setKykKykYMD(BizDate.valueOf(20140101));
            kykSakuinKekkaBean1.setKykSumetuJiyuu(C_Syoumetujiyuu.KYKTORIKESI);
            kykSakuinKekkaBean1.setKykSyoumetuYMD(BizDate.valueOf(20140102));
            kykSakuinKekkaBeanList.add(kykSakuinKekkaBean1);

            KykSakuinKekkaBean kykSakuinKekkaBean2 = new KykSakuinKekkaBean();
            kykSakuinKekkaBean2.setKhSyouhnCd("1");
            kykSakuinKekkaBean2.setKhsyouhnsdno(2);
            kykSakuinKekkaBean2.setKykSyoNo("17806000079");
            kykSakuinKekkaBean2.setKykYuukSumtKbn(C_YuukousyoumetuKbn.SYOUMETU);
            kykSakuinKekkaBean2.setKykKykJyoutai(C_Kykjyoutai.HRKMTYUU);
            kykSakuinKekkaBean2.setKykKykYMD(BizDate.valueOf(20150101));
            kykSakuinKekkaBean2.setKykSumetuJiyuu(C_Syoumetujiyuu.MUKOU);
            kykSakuinKekkaBean2.setKykSyoumetuYMD(BizDate.valueOf(20150102));
            kykSakuinKekkaBeanList.add(kykSakuinKekkaBean2);

            KykSakuinKekkaBean kykSakuinKekkaBean3 = new KykSakuinKekkaBean();
            kykSakuinKekkaBean3.setKhSyouhnCd("1");
            kykSakuinKekkaBean3.setKhsyouhnsdno(2);
            kykSakuinKekkaBean3.setKykSyoNo("17806000079");
            kykSakuinKekkaBean3.setKykYuukSumtKbn(C_YuukousyoumetuKbn.SYOUMETU);
            kykSakuinKekkaBean3.setKykKykJyoutai(C_Kykjyoutai.HRKMTYUU);
            kykSakuinKekkaBean3.setKykKykYMD(BizDate.valueOf(20150101));
            kykSakuinKekkaBean3.setKykSumetuJiyuu(C_Syoumetujiyuu.MUKOU);
            kykSakuinKekkaBean3.setKykSyoumetuYMD(BizDate.valueOf(20150102));
            kykSakuinKekkaBeanList.add(kykSakuinKekkaBean3);

            palBetuSakuinSyoukaiKekkaBean.setKykSakuinKekkaBeanList(kykSakuinKekkaBeanList);
        }
        else if (TESTPATTERN6.equals(SYORIPTN) && caller == SetBetukykTest_exec.class)
        {

            palBetuSakuinSyoukaiKekkaBean.setKkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkkensuu(1);
            palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(0);

            List<NenkinSakuinKekkaBean> nenkinSakuinKekkaBeanList = new ArrayList<>();
            NenkinSakuinKekkaBean nenkinSakuinKekkaBean = new NenkinSakuinKekkaBean();
            nenkinSakuinKekkaBean.setKykNkSysyNo("17806000091");
            nenkinSakuinKekkaBean.setKykNkShrsYMD(BizDate.valueOf(20140101));
            nenkinSakuinKekkaBean.setKykNkSymtJiyuu(C_NkSyoumetuCd.LASTNKSHR);
            nenkinSakuinKekkaBean.setKykNkSymtYMD(BizDate.valueOf(20140101));
            nenkinSakuinKekkaBeanList.add(nenkinSakuinKekkaBean);

            palBetuSakuinSyoukaiKekkaBean.setNenkinSakuinKekkaBeanList(nenkinSakuinKekkaBeanList);
        }
        else if (TESTPATTERN7.equals(SYORIPTN) && caller == SetBetukykTest_exec.class)
        {

            palBetuSakuinSyoukaiKekkaBean.setKkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkkensuu(3);
            palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(0);

            List<NenkinSakuinKekkaBean> nenkinSakuinKekkaBeanList = new ArrayList<>();
            NenkinSakuinKekkaBean nenkinSakuinKekkaBean1 = new NenkinSakuinKekkaBean();
            nenkinSakuinKekkaBean1.setKykNkSysyNo("17806000105");
            nenkinSakuinKekkaBean1.setKykNkShrsYMD(BizDate.valueOf(20140101));
            nenkinSakuinKekkaBean1.setKykNkSymtJiyuu(C_NkSyoumetuCd.NKSEISAN);
            nenkinSakuinKekkaBean1.setKykNkSymtYMD(BizDate.valueOf(20140102));
            nenkinSakuinKekkaBeanList.add(nenkinSakuinKekkaBean1);

            NenkinSakuinKekkaBean nenkinSakuinKekkaBean2 = new NenkinSakuinKekkaBean();
            nenkinSakuinKekkaBean2.setKykNkSysyNo("17806000105");
            nenkinSakuinKekkaBean2.setKykNkShrsYMD(BizDate.valueOf(20150101));
            nenkinSakuinKekkaBean2.setKykNkSymtJiyuu(C_NkSyoumetuCd.LASTNKSHR);
            nenkinSakuinKekkaBean2.setKykNkSymtYMD(BizDate.valueOf(20150102));
            nenkinSakuinKekkaBeanList.add(nenkinSakuinKekkaBean2);

            NenkinSakuinKekkaBean nenkinSakuinKekkaBean3 = new NenkinSakuinKekkaBean();
            nenkinSakuinKekkaBean3.setKykNkSysyNo("17806000105");
            nenkinSakuinKekkaBean3.setKykNkShrsYMD(BizDate.valueOf(20150101));
            nenkinSakuinKekkaBean3.setKykNkSymtJiyuu(C_NkSyoumetuCd.LASTNKSHR);
            nenkinSakuinKekkaBean3.setKykNkSymtYMD(BizDate.valueOf(20150102));
            nenkinSakuinKekkaBeanList.add(nenkinSakuinKekkaBean3);

            palBetuSakuinSyoukaiKekkaBean.setNenkinSakuinKekkaBeanList(nenkinSakuinKekkaBeanList);
        }
        else if (TESTPATTERN8.equals(SYORIPTN) && caller == SetBetukykTest_exec.class)
        {

            palBetuSakuinSyoukaiKekkaBean.setKkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(1);
            palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(0);

            List<PALKykMFSakuinKekkaBean> pALKykMFSakuinKekkaBeanList = new ArrayList<>();
            PALKykMFSakuinKekkaBean pALKykMFSakuinKekkaBean = new PALKykMFSakuinKekkaBean();
            pALKykMFSakuinKekkaBean.setPalBtkykSyoNo("17806000127");
            pALKykMFSakuinKekkaBean.setPalBtkykKykYMD(BizDate.valueOf(20140101));
            pALKykMFSakuinKekkaBean.setPalBtkykSymtCd("1234");
            pALKykMFSakuinKekkaBean.setPalBtkykSymtYMD(BizDate.valueOf(20140102));
            pALKykMFSakuinKekkaBeanList.add(pALKykMFSakuinKekkaBean);

            palBetuSakuinSyoukaiKekkaBean.setPalKykMFSakuinKekkaBeanList(pALKykMFSakuinKekkaBeanList);

        }
        else if (TESTPATTERN9.equals(SYORIPTN) && caller == SetBetukykTest_exec.class)
        {

            palBetuSakuinSyoukaiKekkaBean.setKkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(3);
            palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(0);

            List<PALKykMFSakuinKekkaBean> pALKykMFSakuinKekkaBeanList = new ArrayList<>();
            PALKykMFSakuinKekkaBean pALKykMFSakuinKekkaBean1 = new PALKykMFSakuinKekkaBean();
            pALKykMFSakuinKekkaBean1.setPalBtkykSyoNo("17806000138");
            pALKykMFSakuinKekkaBean1.setPalBtkykKykYMD(BizDate.valueOf(20140101));
            pALKykMFSakuinKekkaBean1.setPalBtkykSymtCd("1111");
            pALKykMFSakuinKekkaBean1.setPalBtkykSymtYMD(BizDate.valueOf(20140102));
            pALKykMFSakuinKekkaBeanList.add(pALKykMFSakuinKekkaBean1);

            PALKykMFSakuinKekkaBean pALKykMFSakuinKekkaBean2 = new PALKykMFSakuinKekkaBean();
            pALKykMFSakuinKekkaBean2.setPalBtkykSyoNo("17806000138");
            pALKykMFSakuinKekkaBean2.setPalBtkykKykYMD(BizDate.valueOf(20150101));
            pALKykMFSakuinKekkaBean2.setPalBtkykSymtCd("2222");
            pALKykMFSakuinKekkaBean2.setPalBtkykSymtYMD(BizDate.valueOf(20150102));
            pALKykMFSakuinKekkaBeanList.add(pALKykMFSakuinKekkaBean2);

            PALKykMFSakuinKekkaBean pALKykMFSakuinKekkaBean3 = new PALKykMFSakuinKekkaBean();
            pALKykMFSakuinKekkaBean3.setPalBtkykSyoNo("17806000138");
            pALKykMFSakuinKekkaBean3.setPalBtkykKykYMD(BizDate.valueOf(20150101));
            pALKykMFSakuinKekkaBean3.setPalBtkykSymtCd("3333");
            pALKykMFSakuinKekkaBean3.setPalBtkykSymtYMD(BizDate.valueOf(20150102));
            pALKykMFSakuinKekkaBeanList.add(pALKykMFSakuinKekkaBean3);

            palBetuSakuinSyoukaiKekkaBean.setPalKykMFSakuinKekkaBeanList(pALKykMFSakuinKekkaBeanList);

        }
        else if (TESTPATTERN10.equals(SYORIPTN) && caller == SetBetukykTest_exec.class)
        {

            palBetuSakuinSyoukaiKekkaBean.setKkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(1);
            palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(0);

            List<PALSouNenkinFSakuinKekkaBean> pALSouNenkinFSakuinKekkaBeanList = new ArrayList<>();
            PALSouNenkinFSakuinKekkaBean pALSouNenkinFSakuinKekkaBean = new PALSouNenkinFSakuinKekkaBean();
            pALSouNenkinFSakuinKekkaBean.setPalBtkykNkSysyNo("17806000150");
            pALSouNenkinFSakuinKekkaBean.setPalBtkykNkShrYMD(BizDate.valueOf(20140101));
            pALSouNenkinFSakuinKekkaBean.setPalBtkykNkSymtCd("1234");
            pALSouNenkinFSakuinKekkaBean.setPalBtkykNkSymtYMD(BizDate.valueOf(20140102));
            pALSouNenkinFSakuinKekkaBeanList.add(pALSouNenkinFSakuinKekkaBean);

            palBetuSakuinSyoukaiKekkaBean.setPalSouNenkinFSakuinKekkaBeanList(pALSouNenkinFSakuinKekkaBeanList);

        }
        else if (TESTPATTERN11.equals(SYORIPTN) && caller == SetBetukykTest_exec.class)
        {

            palBetuSakuinSyoukaiKekkaBean.setKkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(3);
            palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(0);

            List<PALSouNenkinFSakuinKekkaBean> pALSouNenkinFSakuinKekkaBeanList = new ArrayList<>();
            PALSouNenkinFSakuinKekkaBean pALSouNenkinFSakuinKekkaBean1 = new PALSouNenkinFSakuinKekkaBean();
            pALSouNenkinFSakuinKekkaBean1.setPalBtkykNkSysyNo("17806000161");
            pALSouNenkinFSakuinKekkaBean1.setPalBtkykNkShrYMD(BizDate.valueOf(20150101));
            pALSouNenkinFSakuinKekkaBean1.setPalBtkykNkSymtCd("4567");
            pALSouNenkinFSakuinKekkaBean1.setPalBtkykNkSymtYMD(BizDate.valueOf(20140102));
            pALSouNenkinFSakuinKekkaBeanList.add(pALSouNenkinFSakuinKekkaBean1);

            PALSouNenkinFSakuinKekkaBean pALSouNenkinFSakuinKekkaBean2 = new PALSouNenkinFSakuinKekkaBean();
            pALSouNenkinFSakuinKekkaBean2.setPalBtkykNkSysyNo("17806000161");
            pALSouNenkinFSakuinKekkaBean2.setPalBtkykNkShrYMD(BizDate.valueOf(20140101));
            pALSouNenkinFSakuinKekkaBean2.setPalBtkykNkSymtCd("1234");
            pALSouNenkinFSakuinKekkaBean2.setPalBtkykNkSymtYMD(BizDate.valueOf(20140102));
            pALSouNenkinFSakuinKekkaBeanList.add(pALSouNenkinFSakuinKekkaBean2);

            PALSouNenkinFSakuinKekkaBean pALSouNenkinFSakuinKekkaBean3 = new PALSouNenkinFSakuinKekkaBean();
            pALSouNenkinFSakuinKekkaBean3.setPalBtkykNkSysyNo("17806000161");
            pALSouNenkinFSakuinKekkaBean3.setPalBtkykNkShrYMD(BizDate.valueOf(20140101));
            pALSouNenkinFSakuinKekkaBean3.setPalBtkykNkSymtCd("1234");
            pALSouNenkinFSakuinKekkaBean3.setPalBtkykNkSymtYMD(BizDate.valueOf(20140102));
            pALSouNenkinFSakuinKekkaBeanList.add(pALSouNenkinFSakuinKekkaBean3);

            palBetuSakuinSyoukaiKekkaBean.setPalSouNenkinFSakuinKekkaBeanList(pALSouNenkinFSakuinKekkaBeanList);
        }
        else if (TESTPATTERN12.equals(SYORIPTN) && caller == SetBetukykTest_exec.class)
        {

            palBetuSakuinSyoukaiKekkaBean.setKkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(1);

            List<PALSueokiFSakuinKekkaBean> pALSueokiFSakuinKekkaBeanList = new ArrayList<>();
            PALSueokiFSakuinKekkaBean pALSueokiFSakuinKekkaBean = new PALSueokiFSakuinKekkaBean();
            pALSueokiFSakuinKekkaBean.setPalBtkykSosysyNo("17806000183");
            pALSueokiFSakuinKekkaBean.setPalBtkykSosYMD(BizDate.valueOf(20140101));
            pALSueokiFSakuinKekkaBeanList.add(pALSueokiFSakuinKekkaBean);

            palBetuSakuinSyoukaiKekkaBean.setPalSueokiFSakuinKekkaBeanList(pALSueokiFSakuinKekkaBeanList);

        }
        else if (TESTPATTERN13.equals(SYORIPTN) && caller == SetBetukykTest_exec.class)
        {

            palBetuSakuinSyoukaiKekkaBean.setKkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(0);
            palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(3);

            List<PALSueokiFSakuinKekkaBean> pALSueokiFSakuinKekkaBeanList = new ArrayList<>();
            PALSueokiFSakuinKekkaBean pALSueokiFSakuinKekkaBean1 = new PALSueokiFSakuinKekkaBean();
            pALSueokiFSakuinKekkaBean1.setPalBtkykSosysyNo("17806000194");
            pALSueokiFSakuinKekkaBean1.setPalBtkykSosYMD(BizDate.valueOf(20140101));
            pALSueokiFSakuinKekkaBeanList.add(pALSueokiFSakuinKekkaBean1);

            PALSueokiFSakuinKekkaBean pALSueokiFSakuinKekkaBean2 = new PALSueokiFSakuinKekkaBean();
            pALSueokiFSakuinKekkaBean2.setPalBtkykSosysyNo("17806000194");
            pALSueokiFSakuinKekkaBean2.setPalBtkykSosYMD(BizDate.valueOf(20150101));
            pALSueokiFSakuinKekkaBeanList.add(pALSueokiFSakuinKekkaBean2);

            PALSueokiFSakuinKekkaBean pALSueokiFSakuinKekkaBean3 = new PALSueokiFSakuinKekkaBean();
            pALSueokiFSakuinKekkaBean3.setPalBtkykSosysyNo("17806000194");
            pALSueokiFSakuinKekkaBean3.setPalBtkykSosYMD(BizDate.valueOf(20150101));
            pALSueokiFSakuinKekkaBeanList.add(pALSueokiFSakuinKekkaBean3);

            palBetuSakuinSyoukaiKekkaBean.setPalSueokiFSakuinKekkaBeanList(pALSueokiFSakuinKekkaBeanList);
        }
        else {
            boolean result = super.exec(pSyono, pCSakuintsnTaisyouKbn, pCSakuintaisyoukykKbn);
            palBetuSakuinSyoukaiKekkaBean = super.getPALBetuSakuinSyoukaiKekkaBean();
            worningMsgIdList = super.getWarningMsgIdList();
            worningMsgList = super.getWarningMsgList();
            return result;
        }
        return true;
    }

    @Override
    public List<String> getWarningMsgIdList() {
        return worningMsgIdList;
    }

    @Override
    public List<String> getWarningMsgList() {
        return worningMsgList;
    }

    @Override
    public PALBetuSakuinSyoukaiKekkaBean getPALBetuSakuinSyoukaiKekkaBean() {
        return palBetuSakuinSyoukaiKekkaBean;
    }

}
