package yuyu.common.sinkeiyaku.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BzGetImage;
import yuyu.common.biz.bzcommon.BzGetImageMockForSinkeiyaku;
import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzForceProcessForward;
import yuyu.common.biz.koutei.BzForceProcessForwardMock;
import yuyu.common.biz.koutei.BzForceProcessForwardMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzLockProcess;
import yuyu.common.biz.koutei.BzLockProcessMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzOutputProcessRecordMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzUnlockProcess;
import yuyu.common.biz.koutei.BzUnlockProcessMockForSinkeiyaku;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessCreateクラスのメソッド {@link SkProcessCreate#exec(SkProcessCreateInBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessCreateTest_exec {

    @Inject
    private SkProcessCreate skProcessCreate;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzProcessCreate.class).to(BzProcessCreateMockForSinkeiyaku.class);
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForSinkeiyaku.class);
                bind(BzGetImageProps.class).to(BzGetImagePropsMockForSinkeiyaku.class);
                bind(BzGetImage.class).to(BzGetImageMockForSinkeiyaku.class);
                bind(BzLockProcess.class).to(BzLockProcessMockForSinkeiyaku.class);
                bind(BzForceProcessForward.class).to(BzForceProcessForwardMockForSinkeiyaku.class);
                bind(BzUnlockProcess.class).to(BzUnlockProcessMockForSinkeiyaku.class);
                bind(BzOutputProcessRecord.class).to(BzOutputProcessRecordMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void testInit() {
        BzProcessCreateMockForSinkeiyaku.caller = SkProcessCreateTest_exec.class;
        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessCreateTest_exec.class;
        IwfKouteiClientMockForSinkeiyaku.caller2 = SkProcessCreateTest_exec.class;
        BzGetImagePropsMockForSinkeiyaku.caller = SkProcessCreateTest_exec.class;
        BzGetImageMockForSinkeiyaku.caller = SkProcessCreateTest_exec.class;
        BzLockProcessMockForSinkeiyaku.caller = SkProcessCreateTest_exec.class;
        BzForceProcessForwardMockForSinkeiyaku.caller = SkProcessCreateTest_exec.class;
        BzUnlockProcessMockForSinkeiyaku.caller = SkProcessCreateTest_exec.class;
        BzOutputProcessRecordMockForSinkeiyaku.caller = SkProcessCreateTest_exec.class;
    }

    @AfterClass
    @Transactional
    public static void testClear() {

        BzProcessCreateMockForSinkeiyaku.caller = null;
        BzGetProcessSummaryMockForSinkeiyaku.caller =null;
        IwfKouteiClientMockForSinkeiyaku.caller2 = null;
        BzProcessCreateMockForSinkeiyaku.SYORIPTN =null;
        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        IwfKouteiClientMockForSinkeiyaku.mode = null;

        BzGetImagePropsMockForSinkeiyaku.caller = null;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = null;
        BzGetImageMockForSinkeiyaku.caller = null;
        BzGetImageMockForSinkeiyaku.SYORIPTN = null;
        BzLockProcessMockForSinkeiyaku.caller = null;
        BzLockProcessMockForSinkeiyaku.SYORIPTN = null;
        BzForceProcessForwardMock.caller = null;
        BzForceProcessForwardMock.SYORIPTN = null;
        BzUnlockProcessMockForSinkeiyaku.caller = null;
        BzUnlockProcessMockForSinkeiyaku.SYORIPTN = null;
        BzOutputProcessRecordMockForSinkeiyaku.caller = null;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = null;

        MockObjectManager.initialize();

    }
    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN1;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;

        SkProcessCreateInBean skProcessCreateInBean = SWAKInjector.getInstance(SkProcessCreateInBean.class);
        skProcessCreateInBean.setSkeiJimuKbn(C_SkeijimuKbn.SMBC);
        skProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        skProcessCreateInBean.setHknSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skProcessCreateInBean.setDairitenCd1("001");
        skProcessCreateInBean.setDairitenCd2("002");
        skProcessCreateInBean.setJimuyouCd("003");
        skProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.ARI);
        skProcessCreateInBean.setDoujimosUmu(C_UmuKbn.ARI);
        skProcessCreateInBean.setMosYmd(BizDate.valueOf(20160229));
        skProcessCreateInBean.setJimuStartYmd("20160310");
        skProcessCreateInBean.setSyoNo("11807111118");
        skProcessCreateInBean.setMosNo("791112238");
        skProcessCreateInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        skProcessCreateInBean.setKetteiKbns(null);
        skProcessCreateInBean.setSeirituKbn(null);
        skProcessCreateInBean.setLincjkKbn(null);

        String kouteiKanriId = skProcessCreate.exec(skProcessCreateInBean);
        exStringEquals(kouteiKanriId, "10010", "工程管理ID");

        BzProcessCreateInBean bzProcessCreateInBean = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreateMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessCreateInBean.getSubSystemId(),ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU, "サブシステムＩＤ");
        exClassificationEquals(bzProcessCreateInBean.getSkeijimuKbn(),C_SkeijimuKbn.SMBC, "新契約事務区分");
        exClassificationEquals(bzProcessCreateInBean.getMosUketukeKbn(),C_MosUketukeKbn.MOSKIT, "申込受付区分");
        exClassificationEquals(bzProcessCreateInBean.getHknsyuruiNo(),C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exStringEquals(bzProcessCreateInBean.getDairitenCd1(), "001", "代理店コード１");
        exStringEquals(bzProcessCreateInBean.getDairitenCd2(), "002", "代理店コード２");
        exStringEquals(bzProcessCreateInBean.getJimuyouCd(), "003", "事務用コード");
        exClassificationEquals(bzProcessCreateInBean.getJmycdMisetteiKbn(),C_UmuKbn.NONE, "事務用コード未設定区分");
        exClassificationEquals(bzProcessCreateInBean.getDoujiMosumu(),C_UmuKbn.ARI, "同時申込有無");
        exDateEquals(bzProcessCreateInBean.getMosymd(),BizDate.valueOf(20160229), "申込日");
        exStringEquals(bzProcessCreateInBean.getJimustartYmd(), "20160310", "事務開始日");
        exStringEquals(bzProcessCreateInBean.getSyoNo(), "11807111118", "証券番号");
        exStringEquals(bzProcessCreateInBean.getMosNo(), "791112238", "申込番号");
        exStringEquals(bzProcessCreateInBean.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzProcessCreateInBean.getKetteiKbn(), C_KetteiKbn.NONE , "決定状態区分");
        exClassificationEquals(bzProcessCreateInBean.getSeirituKbn(), C_SeirituKbn.NONE , "成立区分");
        exClassificationEquals(bzProcessCreateInBean.getLincjkKbn(), C_LincjkKbn.MIHANTEI, "ＬＩＮＣ状況区分");
        exStringEquals(bzProcessCreateInBean.getOyaKouteiKanriId(), null, "親工程管理ID");
        exStringEquals(bzProcessCreateInBean.getOyaKouteiJimuTetuzukiCd(), null, "親工程事務手続コード");

        BzProcessCreateInBean bzProcessCreateInBean1 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreateMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessCreateInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTMOS, "事務手続コード");
        exStringEquals(bzProcessCreateInBean1.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean1.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

        BzProcessCreateInBean bzProcessCreateInBean2 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreateMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessCreateInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exStringEquals(bzProcessCreateInBean2.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean2.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

        BzProcessCreateInBean bzProcessCreateInBean3 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreateMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessCreateInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessCreateInBean3.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean3.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

        BzProcessCreateInBean bzProcessCreateInBean4 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreateMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzProcessCreateInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessCreateInBean4.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean4.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

        BzProcessCreateInBean bzProcessCreateInBean5 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreateMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzProcessCreateInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessCreateInBean5.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean5.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

        BzProcessCreateInBean bzProcessCreateInBean6 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreateMockForSinkeiyaku.class, "exec", 6, 0);
        exStringEquals(bzProcessCreateInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessCreateInBean6.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean6.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN1;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;

        SkProcessCreateInBean skProcessCreateInBean = SWAKInjector.getInstance(SkProcessCreateInBean.class);
        skProcessCreateInBean.setSkeiJimuKbn(C_SkeijimuKbn.SMBC);
        skProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        skProcessCreateInBean.setHknSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skProcessCreateInBean.setDairitenCd1("001");
        skProcessCreateInBean.setDairitenCd2("002");
        skProcessCreateInBean.setJimuyouCd("");
        skProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        skProcessCreateInBean.setDoujimosUmu(C_UmuKbn.ARI);
        skProcessCreateInBean.setMosYmd(BizDate.valueOf(20160229));
        skProcessCreateInBean.setJimuStartYmd("20160310");
        skProcessCreateInBean.setSyoNo("11807111118");
        skProcessCreateInBean.setMosNo("791112238");
        skProcessCreateInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        skProcessCreateInBean.setKetteiKbns(C_KetteiKbn.KETTEI_SUMI);
        skProcessCreateInBean.setSeirituKbn(C_SeirituKbn.SEIRITU);
        skProcessCreateInBean.setLincjkKbn(C_LincjkKbn.SYOUKAITAISYOUGAI);

        String kouteiKanriId = skProcessCreate.exec(skProcessCreateInBean);
        exStringEquals(kouteiKanriId, "10010", "工程管理ID");

        BzProcessCreateInBean bzProcessCreateInBean = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreateMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessCreateInBean.getSubSystemId(),ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU, "サブシステムＩＤ");
        exClassificationEquals(bzProcessCreateInBean.getSkeijimuKbn(),C_SkeijimuKbn.SMBC, "新契約事務区分");
        exClassificationEquals(bzProcessCreateInBean.getMosUketukeKbn(),C_MosUketukeKbn.MOSKIT, "申込受付区分");
        exClassificationEquals(bzProcessCreateInBean.getHknsyuruiNo(),C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exStringEquals(bzProcessCreateInBean.getDairitenCd1(), "001", "代理店コード１");
        exStringEquals(bzProcessCreateInBean.getDairitenCd2(), "002", "代理店コード２");
        exStringEquals(bzProcessCreateInBean.getJimuyouCd(), "", "事務用コード");
        exClassificationEquals(bzProcessCreateInBean.getJmycdMisetteiKbn(),C_UmuKbn.ARI, "事務用コード未設定区分");
        exClassificationEquals(bzProcessCreateInBean.getDoujiMosumu(),C_UmuKbn.ARI, "同時申込有無");
        exDateEquals(bzProcessCreateInBean.getMosymd(),BizDate.valueOf(20160229), "申込日");
        exStringEquals(bzProcessCreateInBean.getJimustartYmd(), "20160310", "事務開始日");
        exStringEquals(bzProcessCreateInBean.getSyoNo(), "11807111118", "証券番号");
        exStringEquals(bzProcessCreateInBean.getMosNo(), "791112238", "申込番号");
        exStringEquals(bzProcessCreateInBean.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzProcessCreateInBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI , "決定状態区分");
        exClassificationEquals(bzProcessCreateInBean.getSeirituKbn(), C_SeirituKbn.SEIRITU , "成立区分");
        exClassificationEquals(bzProcessCreateInBean.getLincjkKbn(), C_LincjkKbn.SYOUKAITAISYOUGAI, "ＬＩＮＣ状況区分");
        exStringEquals(bzProcessCreateInBean.getOyaKouteiKanriId(), null, "親工程管理ID");
        exStringEquals(bzProcessCreateInBean.getOyaKouteiJimuTetuzukiCd(), null, "親工程事務手続コード");

        BzProcessCreateInBean bzProcessCreateInBean1 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreateMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessCreateInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTMOS, "事務手続コード");
        exStringEquals(bzProcessCreateInBean1.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean1.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

        BzProcessCreateInBean bzProcessCreateInBean2 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreateMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessCreateInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exStringEquals(bzProcessCreateInBean2.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean2.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

        BzProcessCreateInBean bzProcessCreateInBean3 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreateMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessCreateInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessCreateInBean3.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean3.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

        BzProcessCreateInBean bzProcessCreateInBean4 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreateMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzProcessCreateInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessCreateInBean4.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean4.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

        BzProcessCreateInBean bzProcessCreateInBean5 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreateMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzProcessCreateInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessCreateInBean5.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean5.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

        BzProcessCreateInBean bzProcessCreateInBean6 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreateMockForSinkeiyaku.class, "exec", 6, 0);
        exStringEquals(bzProcessCreateInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessCreateInBean6.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean6.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN2;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        SkProcessCreateInBean skProcessCreateInBean = SWAKInjector.getInstance(SkProcessCreateInBean.class);
        skProcessCreateInBean.setSkeiJimuKbn(C_SkeijimuKbn.SMBC);
        skProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        skProcessCreateInBean.setHknSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skProcessCreateInBean.setDairitenCd1("001");
        skProcessCreateInBean.setDairitenCd2("002");
        skProcessCreateInBean.setJimuyouCd("003");
        skProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.ARI);
        skProcessCreateInBean.setDoujimosUmu(C_UmuKbn.ARI);
        skProcessCreateInBean.setMosYmd(BizDate.valueOf(20160229));
        skProcessCreateInBean.setJimuStartYmd("20160310");
        skProcessCreateInBean.setSyoNo("11807111118");
        skProcessCreateInBean.setMosNo("791112238");
        skProcessCreateInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU);
        skProcessCreateInBean.setKetteiKbns(C_KetteiKbn.BLNK);
        skProcessCreateInBean.setSeirituKbn(C_SeirituKbn.BLNK);
        skProcessCreateInBean.setLincjkKbn(C_LincjkKbn.MIHANTEI);

        String kouteiKanriId = skProcessCreate.exec(skProcessCreateInBean);

        exStringEquals(kouteiKanriId, "10010", "工程管理ID");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112238", "申込番号");

        BzProcessCreateInBean bzProcessCreateInBean1 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreate.class, "exec", 0, 0);
        exStringEquals(bzProcessCreateInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");
        exStringEquals(bzProcessCreateInBean1.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean1.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN2;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        SkProcessCreateInBean skProcessCreateInBean = SWAKInjector.getInstance(SkProcessCreateInBean.class);
        skProcessCreateInBean.setSkeiJimuKbn(C_SkeijimuKbn.SMBC);
        skProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        skProcessCreateInBean.setHknSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skProcessCreateInBean.setDairitenCd1("001");
        skProcessCreateInBean.setDairitenCd2("002");
        skProcessCreateInBean.setJimuyouCd("003");
        skProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.ARI);
        skProcessCreateInBean.setDoujimosUmu(C_UmuKbn.ARI);
        skProcessCreateInBean.setMosYmd(BizDate.valueOf(20160229));
        skProcessCreateInBean.setJimuStartYmd("20160310");
        skProcessCreateInBean.setSyoNo("11807111118");
        skProcessCreateInBean.setMosNo("791112238");
        skProcessCreateInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN);
        skProcessCreateInBean.setKetteiKbns(C_KetteiKbn.BLNK);
        skProcessCreateInBean.setSeirituKbn(C_SeirituKbn.BLNK);
        skProcessCreateInBean.setLincjkKbn(C_LincjkKbn.MIHANTEI);

        String kouteiKanriId = skProcessCreate.exec(skProcessCreateInBean);

        exStringEquals(kouteiKanriId, "10010", "工程管理ID");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112238", "申込番号");

        BzProcessCreateInBean bzProcessCreateInBean1 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreate.class, "exec",0, 0);
        exStringEquals(bzProcessCreateInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");
        exStringEquals(bzProcessCreateInBean1.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean1.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN2;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        SkProcessCreateInBean skProcessCreateInBean = SWAKInjector.getInstance(SkProcessCreateInBean.class);
        skProcessCreateInBean.setSkeiJimuKbn(C_SkeijimuKbn.SMBC);
        skProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        skProcessCreateInBean.setHknSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skProcessCreateInBean.setDairitenCd1("001");
        skProcessCreateInBean.setDairitenCd2("002");
        skProcessCreateInBean.setJimuyouCd("003");
        skProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.ARI);
        skProcessCreateInBean.setDoujimosUmu(C_UmuKbn.ARI);
        skProcessCreateInBean.setMosYmd(BizDate.valueOf(20160229));
        skProcessCreateInBean.setJimuStartYmd("20160310");
        skProcessCreateInBean.setSyoNo("11807111118");
        skProcessCreateInBean.setMosNo("791112238");
        skProcessCreateInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI);
        skProcessCreateInBean.setKetteiKbns(C_KetteiKbn.BLNK);
        skProcessCreateInBean.setSeirituKbn(C_SeirituKbn.BLNK);
        skProcessCreateInBean.setLincjkKbn(C_LincjkKbn.MIHANTEI);

        String kouteiKanriId = skProcessCreate.exec(skProcessCreateInBean);

        exStringEquals(kouteiKanriId, "10010", "工程管理ID");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112238", "申込番号");

        BzProcessCreateInBean bzProcessCreateInBean1 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreate.class, "exec", 0, 0);
        exStringEquals(bzProcessCreateInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI, "事務手続コード");
        exStringEquals(bzProcessCreateInBean1.getOyaKouteiKanriId(), "10010", "工程管理ID");
        exStringEquals(bzProcessCreateInBean1.getOyaKouteiJimuTetuzukiCd(), "skmaindairiten", "親工程事務手続コード");

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN2;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        SkProcessCreateInBean skProcessCreateInBean = SWAKInjector.getInstance(SkProcessCreateInBean.class);
        skProcessCreateInBean.setSkeiJimuKbn(C_SkeijimuKbn.SMBC);
        skProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        skProcessCreateInBean.setHknSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skProcessCreateInBean.setDairitenCd1("001");
        skProcessCreateInBean.setDairitenCd2("002");
        skProcessCreateInBean.setJimuyouCd("003");
        skProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.ARI);
        skProcessCreateInBean.setDoujimosUmu(C_UmuKbn.ARI);
        skProcessCreateInBean.setMosYmd(BizDate.valueOf(20160229));
        skProcessCreateInBean.setJimuStartYmd("20160310");
        skProcessCreateInBean.setSyoNo("11807111118");
        skProcessCreateInBean.setMosNo("791112238");
        skProcessCreateInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);
        skProcessCreateInBean.setKetteiKbns(C_KetteiKbn.BLNK);
        skProcessCreateInBean.setSeirituKbn(C_SeirituKbn.BLNK);
        skProcessCreateInBean.setLincjkKbn(C_LincjkKbn.MIHANTEI);

        String kouteiKanriId = skProcessCreate.exec(skProcessCreateInBean);

        exStringEquals(kouteiKanriId, "10010", "工程管理ID");

        BzProcessCreateInBean bzProcessCreateInBean1 = (BzProcessCreateInBean)MockObjectManager.getArgument(BzProcessCreate.class, "exec", 0, 0);
        exStringEquals(bzProcessCreateInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN, "事務手続コード");
        exStringEquals(bzProcessCreateInBean1.getOyaKouteiKanriId(), null, "工程管理ID");
        exStringEquals(bzProcessCreateInBean1.getOyaKouteiJimuTetuzukiCd(), null, "親工程事務手続コード");

    }

    @Test(expected = BizAppException.class)
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {
        try{
            MockObjectManager.initialize();
            BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN3;
            BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
            SkProcessCreateInBean skProcessCreateInBean = SWAKInjector.getInstance(SkProcessCreateInBean.class);
            skProcessCreateInBean.setSkeiJimuKbn(C_SkeijimuKbn.SMBC);
            skProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
            skProcessCreateInBean.setHknSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
            skProcessCreateInBean.setDairitenCd1("001");
            skProcessCreateInBean.setDairitenCd2("002");
            skProcessCreateInBean.setJimuyouCd("003");
            skProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.ARI);
            skProcessCreateInBean.setDoujimosUmu(C_UmuKbn.ARI);
            skProcessCreateInBean.setMosYmd(BizDate.valueOf(20160229));
            skProcessCreateInBean.setJimuStartYmd("20160310");
            skProcessCreateInBean.setSyoNo("11807111118");
            skProcessCreateInBean.setMosNo("791112238");
            skProcessCreateInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);
            skProcessCreateInBean.setKetteiKbns(C_KetteiKbn.BLNK);
            skProcessCreateInBean.setSeirituKbn(C_SeirituKbn.BLNK);
            skProcessCreateInBean.setLincjkKbn(C_LincjkKbn.MIHANTEI);

            skProcessCreate.exec(skProcessCreateInBean);
        } catch(BizAppException e) {
            exStringEquals(e.getMessage(), "工程作成に失敗しました。", "エラーメッセージ");
            throw e;

        }

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN3;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        SkProcessCreateInBean skProcessCreateInBean = SWAKInjector.getInstance(SkProcessCreateInBean.class);
        skProcessCreateInBean.setSkeiJimuKbn(C_SkeijimuKbn.SMBC);
        skProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        skProcessCreateInBean.setHknSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skProcessCreateInBean.setDairitenCd1("001");
        skProcessCreateInBean.setDairitenCd2("002");
        skProcessCreateInBean.setJimuyouCd("003");
        skProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.ARI);
        skProcessCreateInBean.setDoujimosUmu(C_UmuKbn.ARI);
        skProcessCreateInBean.setMosYmd(BizDate.valueOf(20160229));
        skProcessCreateInBean.setJimuStartYmd("20160310");
        skProcessCreateInBean.setSyoNo("11807111118");
        skProcessCreateInBean.setMosNo("791112238");
        skProcessCreateInBean.setJimuTetuzukiCd(ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU);
        skProcessCreateInBean.setKetteiKbns(C_KetteiKbn.BLNK);
        skProcessCreateInBean.setSeirituKbn(C_SeirituKbn.BLNK);
        skProcessCreateInBean.setLincjkKbn(C_LincjkKbn.MIHANTEI);

        String kouteiKanriId = skProcessCreate.exec(skProcessCreateInBean);
        exStringEquals(kouteiKanriId, "", "工程管理ID");

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_B1_1() {
        MockObjectManager.initialize();
        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("テスト");

        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos(null, "222222226", "11111111110", kinouMode);
        exStringEquals(aiteKouteiKanriID, "", "工程管理ID");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_B1_2() {
        MockObjectManager.initialize();
        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("テスト");

        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos("111111118", null, "11111111110", kinouMode);
        exStringEquals(aiteKouteiKanriID, "", "工程管理ID");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_B1_3() {
        MockObjectManager.initialize();
        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("テスト");

        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos("111111118", "222222226", null, kinouMode);
        exStringEquals(aiteKouteiKanriID, "", "工程管理ID");
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_B1_4() {
        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos("111111118", "222222226", "11111111110", null);
        exStringEquals(aiteKouteiKanriID, "", "工程管理ID");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_B1_5() {
        MockObjectManager.initialize();
        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode(null);

        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos("111111118", "222222226", "11111111110", kinouMode);
        exStringEquals(aiteKouteiKanriID, "", "工程管理ID");
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testExec_B2_1() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("テスト");

        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos("111111118", "222222226", "11111111110", kinouMode);
        exStringEquals(aiteKouteiKanriID, "", "工程管理ID");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testExec_B2_2() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("テスト");

        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos("111111118", "222222226", "11111111110", kinouMode);
        exStringEquals(aiteKouteiKanriID, "", "工程管理ID");
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testExec_B2_3() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN4;

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("テスト");

        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos("111111118", "222222226", "11111111110", kinouMode);
        exStringEquals(aiteKouteiKanriID, "", "工程管理ID");
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testExec_B2_4() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN5;

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("テスト");

        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos("111111118", "222222226", "11111111110", kinouMode);
        exStringEquals(aiteKouteiKanriID, "", "工程管理ID");
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testExec_B2_5() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN5;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN1;

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("テスト");

        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos("111111118", "222222226", "11111111110", kinouMode);
        exStringEquals(aiteKouteiKanriID, "", "工程管理ID");
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testExec_B2_6() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN5;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN1;
        BzGetImageMockForSinkeiyaku.SYORIPTN = BzGetImageMockForSinkeiyaku.TESTPATTERN1;

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("テスト");

        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos("111111118", "222222226", "11111111110", kinouMode);
        exStringEquals(aiteKouteiKanriID, "", "工程管理ID");
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testExec_B2_7() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN26_1;
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN5;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("テスト");

        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos("111111118", "222222226", "11111111110", kinouMode);
        exStringEquals(aiteKouteiKanriID, "", "工程管理ID");
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testExec_B2_8() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN5;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        BzLockProcessMockForSinkeiyaku.SYORIPTN = BzLockProcessMockForSinkeiyaku.TESTPATTERN1;

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("テスト");

        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos("111111118", "222222226", "11111111110", kinouMode);
        exStringEquals(aiteKouteiKanriID, "", "工程管理ID");
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testExec_B2_9() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN5;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        BzLockProcessMockForSinkeiyaku.SYORIPTN = BzLockProcessMockForSinkeiyaku.TESTPATTERN2;
        BzForceProcessForwardMockForSinkeiyaku.SYORIPTN = BzForceProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzUnlockProcessMockForSinkeiyaku.SYORIPTN = BzUnlockProcessMockForSinkeiyaku.TESTPATTERN1;

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("テスト");

        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos("111111118", "222222226", "11111111110", kinouMode);
        exStringEquals(aiteKouteiKanriID, "", "工程管理ID");

        MockObjectManager.assertArgumentPassed(BzUnlockProcessMockForSinkeiyaku.class, "exec", 0, "TEST");
        MockObjectManager.assertArgumentPassed(BzUnlockProcessMockForSinkeiyaku.class, "exec", 1, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        MockObjectManager.assertArgumentPassed(BzUnlockProcessMockForSinkeiyaku.class, "exec", 2, "LOCK_TEST_KEY");
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testExec_B3_1() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessCreateMockForSinkeiyaku.SYORIPTN = BzProcessCreateMockForSinkeiyaku.TESTPATTERN5;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        BzLockProcessMockForSinkeiyaku.SYORIPTN = BzLockProcessMockForSinkeiyaku.TESTPATTERN2;
        BzForceProcessForwardMockForSinkeiyaku.SYORIPTN = BzForceProcessForwardMockForSinkeiyaku.TESTPATTERN2;
        BzUnlockProcessMockForSinkeiyaku.SYORIPTN = BzUnlockProcessMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        KinouMode kinouMode = new KinouMode();
        kinouMode.setKinouMode("テスト");

        String aiteKouteiKanriID = skProcessCreate.copyKouteiInfos("111111118", "222222226", "11111111110", kinouMode);
        exStringEquals(aiteKouteiKanriID, "TEST", "工程管理ID");
    }
}
