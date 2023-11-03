package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約書類取込前処理 {@link SkPreSyoruiTorikomi#sinkykSyoruiTorikomiMany(
 * String, C_SyoruiCdKbn[], C_SkeijimuKbn, C_HknsyuruiNo, C_MosUketukeKbn, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkPreSyoruiTorikomiTest_sinkykSyoruiTorikomiMany {

    @Inject
    private SkPreSyoruiTorikomi skPreSyoruiTorikomi;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Test
    @Transactional
    @TestOrder(10)
    public void testSinkykSyoruiTorikomiMany_A1() {
        String pMosNo = "989800065";
        C_SyoruiCdKbn[] pSyoruiCds = new C_SyoruiCdKbn[]{};
        C_SkeijimuKbn pSkeijimuKbn = C_SkeijimuKbn.BLNK;
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.BLNK;
        C_MosUketukeKbn pMosUketukeKbn = C_MosUketukeKbn.BLNK;
        String pDrtenCd = "9011070";
        String pSetMosno1 = "";

        String[] strs = skPreSyoruiTorikomi.sinkykSyoruiTorikomiMany(pMosNo, pSyoruiCds, pSkeijimuKbn,
            pHknsyuruiNo, pMosUketukeKbn, pDrtenCd, pSetMosno1);

        exNumericEquals(strs.length, 0, "QRコード値配列．Length");

        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri("989800065");
        exStringEquals(mosMikakuteiJyouhouKanri.getMosno(), "989800065", "申込番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getJimutetuzukicd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getSkeijimukbn(), C_SkeijimuKbn.BLNK, "新契約事務区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getMosuketukekbn(), C_MosUketukeKbn.BLNK, "申込受付区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getHknsyuruino(), C_HknsyuruiNo.BLNK, "保険種類番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getDairitencd1(), "9011070", "代理店コード１");
        exStringEquals(mosMikakuteiJyouhouKanri.getSetmosno1(), "", "セット申込番号１");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testSinkykSyoruiTorikomiMany_A2() {
        String pMosNo = "860000082";
        C_SyoruiCdKbn[] pSyoruiCds = new C_SyoruiCdKbn[]{C_SyoruiCdKbn.HK_SHRMESS};
        C_SkeijimuKbn pSkeijimuKbn = C_SkeijimuKbn.BLNK;
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.BLNK;
        C_MosUketukeKbn pMosUketukeKbn = C_MosUketukeKbn.BLNK;
        String pDrtenCd = "9011080";
        String pSetMosno1 = "989800081";

        String[] strs = skPreSyoruiTorikomi.sinkykSyoruiTorikomiMany(pMosNo, pSyoruiCds, pSkeijimuKbn,
            pHknsyuruiNo, pMosUketukeKbn, pDrtenCd, pSetMosno1);

        exNumericEquals(strs.length, 1, "QRコード値配列．Length");
        exStringEquals(strs[0].substring(0, 3), "MOS", "QRコード値配列[0]");

        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri("860000082");
        exStringEquals(mosMikakuteiJyouhouKanri.getMosno(), "860000082", "申込番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getJimutetuzukicd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getSkeijimukbn(), C_SkeijimuKbn.BLNK, "新契約事務区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getMosuketukekbn(), C_MosUketukeKbn.BLNK, "申込受付区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getHknsyuruino(), C_HknsyuruiNo.BLNK, "保険種類番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getDairitencd1(), "9011080", "代理店コード１");
        exStringEquals(mosMikakuteiJyouhouKanri.getSetmosno1(), "989800081", "セット申込番号１");

        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno("860000082");
        exNumericEquals(mosMikakuteiSyoruiLst.size(), 1, "件数");

        HT_MosMikakuteiSyorui mosMikakuteiSyorui = mosMikakuteiSyoruiLst.get(0);
        exStringEquals(mosMikakuteiSyorui.getDocumentid(), strs[0], "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyorui.getMosno(), "860000082", "申込番号");
        exClassificationEquals(mosMikakuteiSyorui.getSyoruiCd(), C_SyoruiCdKbn.HK_SHRMESS, "書類コード");

        deleteTestData1();
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testSinkykSyoruiTorikomiMany_A3() {
        String pMosNo = "860000090";
        C_SyoruiCdKbn[] pSyoruiCds = new C_SyoruiCdKbn[]{C_SyoruiCdKbn.HK_SHRMESS, C_SyoruiCdKbn.HK_SHMEISAI_SDS, C_SyoruiCdKbn.HK_SB_HOKEN_SKS};
        C_SkeijimuKbn pSkeijimuKbn = C_SkeijimuKbn.BLNK;
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.BLNK;
        C_MosUketukeKbn pMosUketukeKbn = C_MosUketukeKbn.BLNK;
        String pDrtenCd = "9011090";
        String pSetMosno1 = "989800008";

        String[] strs = skPreSyoruiTorikomi.sinkykSyoruiTorikomiMany(pMosNo, pSyoruiCds, pSkeijimuKbn,
            pHknsyuruiNo, pMosUketukeKbn, pDrtenCd, pSetMosno1);

        exNumericEquals(strs.length, 3, "QRコード値配列．Length");
        exStringEquals(strs[0].substring(0, 3), "MOS", "QRコード値配列[0]");
        exStringEquals(strs[1].substring(0, 3), "MOS", "QRコード値配列[1]");
        exStringEquals(strs[2].substring(0, 3), "MOS", "QRコード値配列[2]");

        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri("860000090");
        exStringEquals(mosMikakuteiJyouhouKanri.getMosno(), "860000090", "申込番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getJimutetuzukicd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getSkeijimukbn(), C_SkeijimuKbn.BLNK, "新契約事務区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getMosuketukekbn(), C_MosUketukeKbn.BLNK, "申込受付区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getHknsyuruino(), C_HknsyuruiNo.BLNK, "保険種類番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getDairitencd1(), "9011090", "代理店コード１");
        exStringEquals(mosMikakuteiJyouhouKanri.getSetmosno1(), "989800008", "セット申込番号１");

        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno("860000090");
        exNumericEquals(mosMikakuteiSyoruiLst.size(), 3, "件数");

        HT_MosMikakuteiSyorui mosMikakuteiSyorui1 = mosMikakuteiSyoruiLst.get(0);
        exStringEquals(mosMikakuteiSyorui1.getDocumentid(), strs[0], "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyorui1.getMosno(), "860000090", "申込番号");
        exClassificationEquals(mosMikakuteiSyorui1.getSyoruiCd(), C_SyoruiCdKbn.HK_SHRMESS, "書類コード");

        HT_MosMikakuteiSyorui mosMikakuteiSyorui2 = mosMikakuteiSyoruiLst.get(1);
        exStringEquals(mosMikakuteiSyorui2.getDocumentid(), strs[1], "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyorui2.getMosno(), "860000090", "申込番号");
        exClassificationEquals(mosMikakuteiSyorui2.getSyoruiCd(), C_SyoruiCdKbn.HK_SHMEISAI_SDS, "書類コード");

        HT_MosMikakuteiSyorui mosMikakuteiSyorui3 = mosMikakuteiSyoruiLst.get(2);
        exStringEquals(mosMikakuteiSyorui3.getDocumentid(), strs[2], "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyorui3.getMosno(), "860000090", "申込番号");
        exClassificationEquals(mosMikakuteiSyorui3.getSyoruiCd(), C_SyoruiCdKbn.HK_SB_HOKEN_SKS, "書類コード");

        deleteTestData1();
    }

    @Transactional
    public static void deleteTestData1() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiJyouhouKanri());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiSyorui());
    }
}
