package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約申込未確定情報作成クラスのメソッド {@link SkMosMikakuteiInfoSks#mosMikakuteiInfoSksMany(ArrayList<SkMosMikakuteiJyouhouKanriSksInBean> )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkMosMikakuteiInfoSksTest_mosMikakuteiInfoSksMany extends AbstractTest {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SkMosMikakuteiInfoSks skMosMikakuteiInfoSks;

    @Test
    @Transactional
    @TestOrder(10)
    public void testMosMikakuteiInfoSksMany_A1() {
        ArrayList<SkMosMikakuteiJyouhouKanriSksInBean> skMosMikakuteiJyouhouKanriSksInBeanLst= null;
        skMosMikakuteiInfoSks.mosMikakuteiInfoSksMany(skMosMikakuteiJyouhouKanriSksInBeanLst);

        List<HT_MosMikakuteiJyouhouKanri> mosMikakuteiJyouhouKanriLst = sinkeiyakuDomManager.getAllMosMikakuteiJyouhouKanri();
        List<HT_MosMikakuteiSyorui>  mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getAllMosMikakuteiSyorui();

        exNumericEquals(mosMikakuteiJyouhouKanriLst.size(), 0, "申込未確定情報管理テーブルリストの件数");
        exNumericEquals(mosMikakuteiSyoruiLst.size(), 0, "申込未確定書類テーブルリストの件数");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testMosMikakuteiInfoSksMany_A2() {
        ArrayList<SkMosMikakuteiJyouhouKanriSksInBean> skMosMikakuteiJyouhouKanriSksInBeanLst= new ArrayList<>();
        skMosMikakuteiInfoSks.mosMikakuteiInfoSksMany(skMosMikakuteiJyouhouKanriSksInBeanLst);

        List<HT_MosMikakuteiJyouhouKanri> mosMikakuteiJyouhouKanriLst = sinkeiyakuDomManager.getAllMosMikakuteiJyouhouKanri();
        List<HT_MosMikakuteiSyorui>  mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getAllMosMikakuteiSyorui();

        exNumericEquals(mosMikakuteiJyouhouKanriLst.size(), 0, "申込未確定情報管理テーブルリストの件数");
        exNumericEquals(mosMikakuteiSyoruiLst.size(), 0, "申込未確定書類テーブルリストの件数");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testMosMikakuteiInfoSksMany_A3() {
        SkMosMikakuteiJyouhouKanriSksInBean skMosMikakuteiJyouhouKanriSksInBean =
            SWAKInjector.getInstance(SkMosMikakuteiJyouhouKanriSksInBean.class);
        ArrayList<SkMosMikakuteiJyouhouKanriSksInBean> skMosMikakuteiJyouhouKanriSksInBeanLst= new ArrayList<>();
        ArrayList<SkMosMikakuteiSyoruiSksInBean> skMosMikakuteiSyoruiSksInBeanLst = new ArrayList<>();

        skMosMikakuteiJyouhouKanriSksInBean.setMosNo("791112253");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuTetuzukiCd("1000000000000000001");
        skMosMikakuteiJyouhouKanriSksInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        skMosMikakuteiJyouhouKanriSksInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        skMosMikakuteiJyouhouKanriSksInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd1("1000002");
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd2("1000002");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuyouCd("101");
        skMosMikakuteiJyouhouKanriSksInBean.setDoujiMosUmu(C_UmuKbn.ARI);
        skMosMikakuteiJyouhouKanriSksInBean.setSyoNo("11807111129");
        skMosMikakuteiJyouhouKanriSksInBean.setSyoriYmd(BizDate.valueOf("20150101"));
        skMosMikakuteiJyouhouKanriSksInBean.setSetMosno1("989800008");
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinsyaId("user001");
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinTime("20150101111000000");
        skMosMikakuteiJyouhouKanriSksInBean.setSkMosMikakuteiSyoruiSksInBeanLst(skMosMikakuteiSyoruiSksInBeanLst);
        skMosMikakuteiJyouhouKanriSksInBeanLst.add(skMosMikakuteiJyouhouKanriSksInBean);

        skMosMikakuteiJyouhouKanriSksInBean = new SkMosMikakuteiJyouhouKanriSksInBean();
        skMosMikakuteiJyouhouKanriSksInBean.setMosNo("791112261");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuTetuzukiCd("1000000000000000001");
        skMosMikakuteiJyouhouKanriSksInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        skMosMikakuteiJyouhouKanriSksInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        skMosMikakuteiJyouhouKanriSksInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd1("1000002");
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd2("1000002");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuyouCd("101");
        skMosMikakuteiJyouhouKanriSksInBean.setDoujiMosUmu(C_UmuKbn.ARI);
        skMosMikakuteiJyouhouKanriSksInBean.setSyoNo("11807111129");
        skMosMikakuteiJyouhouKanriSksInBean.setSyoriYmd(BizDate.valueOf("20150101"));
        skMosMikakuteiJyouhouKanriSksInBean.setSetMosno1(null);
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinsyaId("user001");
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinTime("20150101111000000");

        skMosMikakuteiSyoruiSksInBeanLst = new ArrayList<>();
        SkMosMikakuteiSyoruiSksInBean skMosMikakuteiSyoruiSksInBean2 = new SkMosMikakuteiSyoruiSksInBean();
        skMosMikakuteiSyoruiSksInBean2.setSyoruiCd(C_SyoruiCdKbn.SK_MOSSYO);
        skMosMikakuteiSyoruiSksInBean2.setDocumentId("111111111111111111111112");
        skMosMikakuteiSyoruiSksInBeanLst.add(skMosMikakuteiSyoruiSksInBean2);
        skMosMikakuteiJyouhouKanriSksInBean.setSkMosMikakuteiSyoruiSksInBeanLst(skMosMikakuteiSyoruiSksInBeanLst);
        skMosMikakuteiJyouhouKanriSksInBeanLst.add(skMosMikakuteiJyouhouKanriSksInBean);

        skMosMikakuteiJyouhouKanriSksInBean = new SkMosMikakuteiJyouhouKanriSksInBean();
        skMosMikakuteiJyouhouKanriSksInBean.setMosNo("791112279");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuTetuzukiCd("1000000000000000001");
        skMosMikakuteiJyouhouKanriSksInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        skMosMikakuteiJyouhouKanriSksInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        skMosMikakuteiJyouhouKanriSksInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd1("1000002");
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd2("1000002");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuyouCd("101");
        skMosMikakuteiJyouhouKanriSksInBean.setDoujiMosUmu(C_UmuKbn.ARI);
        skMosMikakuteiJyouhouKanriSksInBean.setSyoNo("11807111129");
        skMosMikakuteiJyouhouKanriSksInBean.setSyoriYmd(BizDate.valueOf("20150101"));
        skMosMikakuteiJyouhouKanriSksInBean.setSetMosno1("989800016");
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinsyaId("user001");
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinTime("20150101111000000");

        skMosMikakuteiSyoruiSksInBeanLst = new ArrayList<>();
        SkMosMikakuteiSyoruiSksInBean skMosMikakuteiSyoruiSksInBean3 = new SkMosMikakuteiSyoruiSksInBean();
        skMosMikakuteiSyoruiSksInBean3.setSyoruiCd(C_SyoruiCdKbn.SK_MOSSYO);
        skMosMikakuteiSyoruiSksInBean3.setDocumentId("111111111111111111111113");
        skMosMikakuteiSyoruiSksInBeanLst.add(skMosMikakuteiSyoruiSksInBean3);

        SkMosMikakuteiSyoruiSksInBean skMosMikakuteiSyoruiSksInBean4 = new SkMosMikakuteiSyoruiSksInBean();
        skMosMikakuteiSyoruiSksInBean4.setSyoruiCd(C_SyoruiCdKbn.SK_IKOUKAKSYO);
        skMosMikakuteiSyoruiSksInBean4.setDocumentId("111111111111111111111114");
        skMosMikakuteiSyoruiSksInBeanLst.add(skMosMikakuteiSyoruiSksInBean4);

        SkMosMikakuteiSyoruiSksInBean skMosMikakuteiSyoruiSksInBean5 = new SkMosMikakuteiSyoruiSksInBean();
        skMosMikakuteiSyoruiSksInBean5.setSyoruiCd(C_SyoruiCdKbn.SK_TORIHOUSYO);
        skMosMikakuteiSyoruiSksInBean5.setDocumentId("111111111111111111111115");
        skMosMikakuteiSyoruiSksInBeanLst.add(skMosMikakuteiSyoruiSksInBean5);

        skMosMikakuteiJyouhouKanriSksInBean.setSkMosMikakuteiSyoruiSksInBeanLst(skMosMikakuteiSyoruiSksInBeanLst);
        skMosMikakuteiJyouhouKanriSksInBeanLst.add(skMosMikakuteiJyouhouKanriSksInBean);

        skMosMikakuteiInfoSks.mosMikakuteiInfoSksMany(skMosMikakuteiJyouhouKanriSksInBeanLst);

        List<HT_MosMikakuteiJyouhouKanri> mosMikakuteiJyouhouKanriLst = sinkeiyakuDomManager.getAllMosMikakuteiJyouhouKanri();

        exNumericEquals(mosMikakuteiJyouhouKanriLst.size(), 3, "申込未確定情報管理テーブルリストの件数");

        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getMosno(), "791112253", "申込番号");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getJimutetuzukicd(), "1000000000000000001", "事務手続コード");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(0).getSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(0).getMosuketukekbn(), C_MosUketukeKbn.MOSKIT, "申込受付区分");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(0).getHknsyuruino(), C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getDairitencd1(), "1000002", "代理店コード１");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getDairitencd2(), "1000002", "代理店コード２");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getJimuyoucd(), "101", "事務用コード");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(0).getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getSyono(), "11807111129", "証券番号");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(0).getSyorizumiflg(), C_Syorizumiflg.MISYORI, "処理済フラグ");
        exDateEquals(mosMikakuteiJyouhouKanriLst.get(0).getSakujoyoteiymd(), BizDate.valueOf("20150411"), "削除予定日");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getSetmosno1(), "989800008", "セット申込番号１");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");

        List<HT_MosMikakuteiSyorui>  mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno("791112253");
        exNumericEquals(mosMikakuteiSyoruiLst.size(), 0, "申込未確定書類テーブルリストの件数");

        exStringEquals(mosMikakuteiJyouhouKanriLst.get(1).getMosno(), "791112261", "申込番号");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(1).getJimutetuzukicd(), "1000000000000000001", "事務手続コード");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(1).getSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(1).getMosuketukekbn(), C_MosUketukeKbn.MOSKIT, "申込受付区分");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(1).getHknsyuruino(), C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(1).getDairitencd1(), "1000002", "代理店コード１");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(1).getDairitencd2(), "1000002", "代理店コード２");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(1).getJimuyoucd(), "101", "事務用コード");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(1).getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(1).getSyono(), "11807111129", "証券番号");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(1).getSyorizumiflg(), C_Syorizumiflg.MISYORI, "処理済フラグ");
        exDateEquals(mosMikakuteiJyouhouKanriLst.get(1).getSakujoyoteiymd(), BizDate.valueOf("20150411"), "削除予定日");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(1).getSetmosno1(), "", "セット申込番号１");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(1).getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");

        mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno("791112261");

        exNumericEquals(mosMikakuteiSyoruiLst.size(), 1, "申込未確定書類テーブルリストの件数");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getDocumentid(), "111111111111111111111112", "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getMosno(), "791112261", "申込番号");
        exClassificationEquals(mosMikakuteiSyoruiLst.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_MOSSYO, "書類コード");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");

        exStringEquals(mosMikakuteiJyouhouKanriLst.get(2).getMosno(), "791112279", "申込番号");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(2).getJimutetuzukicd(), "1000000000000000001", "事務手続コード");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(2).getSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(2).getMosuketukekbn(), C_MosUketukeKbn.MOSKIT, "申込受付区分");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(2).getHknsyuruino(), C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(2).getDairitencd1(), "1000002", "代理店コード１");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(2).getDairitencd2(), "1000002", "代理店コード２");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(2).getJimuyoucd(), "101", "事務用コード");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(2).getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(2).getSyono(), "11807111129", "証券番号");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(2).getSyorizumiflg(), C_Syorizumiflg.MISYORI, "処理済フラグ");
        exDateEquals(mosMikakuteiJyouhouKanriLst.get(2).getSakujoyoteiymd(), BizDate.valueOf("20150411"), "削除予定日");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(2).getSetmosno1(), "989800016", "セット申込番号１");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(2).getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");

        mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno("791112279");

        exNumericEquals(mosMikakuteiSyoruiLst.size(), 3, "申込未確定書類テーブルリストの件数");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getDocumentid(), "111111111111111111111113", "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getMosno(), "791112279", "申込番号");
        exClassificationEquals(mosMikakuteiSyoruiLst.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_MOSSYO, "書類コード");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");

        exStringEquals(mosMikakuteiSyoruiLst.get(1).getDocumentid(), "111111111111111111111114", "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(1).getMosno(), "791112279", "申込番号");
        exClassificationEquals(mosMikakuteiSyoruiLst.get(1).getSyoruiCd(), C_SyoruiCdKbn.SK_IKOUKAKSYO, "書類コード");
        exStringEquals(mosMikakuteiSyoruiLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(1).getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");

        exStringEquals(mosMikakuteiSyoruiLst.get(2).getDocumentid(), "111111111111111111111115", "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(2).getMosno(), "791112279", "申込番号");
        exClassificationEquals(mosMikakuteiSyoruiLst.get(2).getSyoruiCd(), C_SyoruiCdKbn.SK_TORIHOUSYO, "書類コード");
        exStringEquals(mosMikakuteiSyoruiLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(2).getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");

        deleteTestData();
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testMosMikakuteiInfoSksMany_A4() {
        SkMosMikakuteiJyouhouKanriSksInBean skMosMikakuteiJyouhouKanriSksInBean =
            SWAKInjector.getInstance(SkMosMikakuteiJyouhouKanriSksInBean.class);
        ArrayList<SkMosMikakuteiJyouhouKanriSksInBean> skMosMikakuteiJyouhouKanriSksInBeanLst= new ArrayList<>();
        skMosMikakuteiJyouhouKanriSksInBean.setMosNo("791112246");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuTetuzukiCd("1000000000000000001");
        skMosMikakuteiJyouhouKanriSksInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        skMosMikakuteiJyouhouKanriSksInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        skMosMikakuteiJyouhouKanriSksInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd1("1000002");
        skMosMikakuteiJyouhouKanriSksInBean.setDairitenCd2("1000002");
        skMosMikakuteiJyouhouKanriSksInBean.setJimuyouCd("101");
        skMosMikakuteiJyouhouKanriSksInBean.setDoujiMosUmu(C_UmuKbn.ARI);
        skMosMikakuteiJyouhouKanriSksInBean.setSyoNo("11807111129");
        skMosMikakuteiJyouhouKanriSksInBean.setSyoriYmd(BizDate.valueOf("20150101"));
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinsyaId("user001");
        skMosMikakuteiJyouhouKanriSksInBean.setGyoumuKousinTime("20150101111000000");
        SkMosMikakuteiSyoruiSksInBean skMosMikakuteiSyoruiSksInBean = SWAKInjector.getInstance(SkMosMikakuteiSyoruiSksInBean.class);
        ArrayList<SkMosMikakuteiSyoruiSksInBean> skMosMikakuteiSyoruiSksInBeanLst = new ArrayList<>();
        skMosMikakuteiSyoruiSksInBean.setSyoruiCd(C_SyoruiCdKbn.SK_MOSSYO);
        skMosMikakuteiSyoruiSksInBean.setDocumentId("111111111111111111111115");
        skMosMikakuteiSyoruiSksInBeanLst.add(skMosMikakuteiSyoruiSksInBean);
        skMosMikakuteiJyouhouKanriSksInBean.setSkMosMikakuteiSyoruiSksInBeanLst(skMosMikakuteiSyoruiSksInBeanLst);
        skMosMikakuteiJyouhouKanriSksInBeanLst.add(skMosMikakuteiJyouhouKanriSksInBean);

        skMosMikakuteiInfoSks.mosMikakuteiInfoSksMany(skMosMikakuteiJyouhouKanriSksInBeanLst);

        List<HT_MosMikakuteiJyouhouKanri> mosMikakuteiJyouhouKanriLst = sinkeiyakuDomManager.getAllMosMikakuteiJyouhouKanri();
        List<HT_MosMikakuteiSyorui>  mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getAllMosMikakuteiSyorui();
        exNumericEquals(mosMikakuteiJyouhouKanriLst.size(), 1, "申込未確定情報管理テーブルリストの件数");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getMosno(), "791112246", "申込番号");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getJimutetuzukicd(), "1000000000000000001", "事務手続コード");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(0).getSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(0).getMosuketukekbn(), C_MosUketukeKbn.MOSKIT, "申込受付区分");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(0).getHknsyuruino(), C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getDairitencd1(), "1000002", "代理店コード１");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getDairitencd2(), "1000002", "代理店コード２");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getJimuyoucd(), "101", "事務用コード");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(0).getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getSyono(), "11807111129", "証券番号");
        exClassificationEquals(mosMikakuteiJyouhouKanriLst.get(0).getSyorizumiflg(), C_Syorizumiflg.MISYORI, "処理済フラグ");
        exDateEquals(mosMikakuteiJyouhouKanriLst.get(0).getSakujoyoteiymd(), BizDate.valueOf("20150411"), "削除予定日");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiJyouhouKanriLst.get(0).getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");

        exNumericEquals(mosMikakuteiSyoruiLst.size(), 1, "申込未確定書類テーブルリストの件数");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getDocumentid(), "111111111111111111111115", "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getMosno(), "791112246", "申込番号");
        exClassificationEquals(mosMikakuteiSyoruiLst.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_MOSSYO, "書類コード");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosMikakuteiSyoruiLst.get(0).getGyoumuKousinTime(), "20150101111000000", "業務用更新時間");

        deleteTestData();
    }

    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiJyouhouKanri());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiSyorui());

    }
}
