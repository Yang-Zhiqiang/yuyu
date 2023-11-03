package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約当日異動内容編集クラスのメソッド {@link SkToujituIdounaiyouEdit#skIdounaiyouHenkouCheck(ExDBEntity<?,?>,SkIdounaiyouBeforeBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkToujituIdounaiyouEditTest_skIdounaiyouHenkouCheck {

    @Inject
    private SkToujituIdounaiyouEdit skToujituIdounaiyouEdit;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約当日異動内容編集";

    private final static String sheetName = "INデータ";
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkToujituIdounaiyouEditTest_skIdounaiyouHenkouCheck.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testSkIdounaiyouHenkouCheck_A1() {

        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(null,skIdounaiyouBeforeBean);

        exBooleanEquals(result, false, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testSkIdounaiyouHenkouCheck_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, false, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testSkIdounaiyouHenkouCheck_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = null;
        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, false, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testSkIdounaiyouHenkouCheck_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        HT_SyoriCTL syoriCTL2 = sinkeiyakuDomManager.getSyoriCTL("791112246");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testSkIdounaiyouHenkouCheck_A5() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112261");
        syoriCTL2.setSeiritukbn(C_SeirituKbn.HUSEIRITU);
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testSkIdounaiyouHenkouCheck_A6() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112279");
        syoriCTL2.setSrsyoriymd(BizDate.valueOf("20160428"));
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testSkIdounaiyouHenkouCheck_A7() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112287");
        syoriCTL2.setMfrenflg(C_Mfrenflg.NONE);
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testSkIdounaiyouHenkouCheck_A8() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112295");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112295");
        syoriCTL2.setSyono("11807111174");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testSkIdounaiyouHenkouCheck_A9() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112303");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112303");
        syoriCTL2.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL2.setSrsyoriymd(BizDate.valueOf("20160427"));
        syoriCTL2.setMfrenflg(C_Mfrenflg.SUMI);
        syoriCTL2.setSyono("11807111196");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112303");
        mosKihon.setMosymd(BizDate.valueOf("20160429"));
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testSkIdounaiyouHenkouCheck_A10() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112311");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112311");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112311");
        mosKihon.setKykymd(BizDate.valueOf("20160429"));
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testSkIdounaiyouHenkouCheck_A11() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112329");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112329");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112329");
        mosKihon.setSknnkaisiymd(BizDate.valueOf("20160429"));
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testSkIdounaiyouHenkouCheck_A12() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112337");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112337");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112337");
        mosKihon.setKyktuukasyu(C_Tuukasyu.USD);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testSkIdounaiyouHenkouCheck_A13() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112345");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112345");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112345");
        mosKihon.setSntkhoukbn(C_SntkhouKbn.KKT);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testSkIdounaiyouHenkouCheck_A14() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112352");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112352");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112352");
        mosKihon.setHhknnmkn("カナカナ");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testSkIdounaiyouHenkouCheck_A15() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112360");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112360");
        mosKihon.setHhknnmkj("漢字漢字");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testSkIdounaiyouHenkouCheck_A16() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112378");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112378");
        mosKihon.setHhknseiymd(BizDate.valueOf("20160429"));
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testSkIdounaiyouHenkouCheck_A17() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112386");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112386");
        mosKihon.setHhknsei(C_Hhknsei.MALE);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testSkIdounaiyouHenkouCheck_A18() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112394");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112394");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112394");
        mosKihon.setHhknyno("1140002");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testSkIdounaiyouHenkouCheck_A19() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112402");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112402");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112402");
        mosKihon.setHhknadr1kj("漢字漢字");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testSkIdounaiyouHenkouCheck_A20() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112410");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112410");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112410");
        mosKihon.setHhknadr2kj("漢字漢字");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testSkIdounaiyouHenkouCheck_A21() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112428");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112428");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112428");
        mosKihon.setHhknadr3kj("漢字漢字");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testSkIdounaiyouHenkouCheck_A22() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112436");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112436");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112436");
        mosKihon.setHhkntelno("023-4560-7891");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testSkIdounaiyouHenkouCheck_A23() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112444");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112444");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112444");
        mosKihon.setHhknsykgycd("061");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testSkIdounaiyouHenkouCheck_A24() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112451");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112451");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112451");
        mosKihon.setKyknmkn("カナカナ");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testSkIdounaiyouHenkouCheck_A25() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112469");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112469");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112469");
        mosKihon.setKyknmkj("漢字漢字");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testSkIdounaiyouHenkouCheck_A26() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112477");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112477");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112477");
        mosKihon.setKykseiymd(BizDate.valueOf("20160429"));
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testSkIdounaiyouHenkouCheck_A27() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112485");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112485");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112485");
        mosKihon.setTsinyno("0234560");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(280)
    public void testSkIdounaiyouHenkouCheck_A28() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112493");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112493");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112493");
        mosKihon.setTsinadr1kj("漢字漢字");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(290)
    public void testSkIdounaiyouHenkouCheck_A29() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112501");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112501");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112501");
        mosKihon.setTsinadr2kj("漢字漢字");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(300)
    public void testSkIdounaiyouHenkouCheck_A30() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112519");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112519");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112519");
        mosKihon.setTsinadr3kj("漢字漢字");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(310)
    public void testSkIdounaiyouHenkouCheck_A31() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112527");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112527");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112527");
        mosKihon.setTsintelno("023-4560-7890");
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testSkIdounaiyouHenkouCheck_A32() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112535");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112535");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112535");
        mosKihon.setBosyuuym(BizDateYM.valueOf("201605"));
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(330)
    public void testSkIdounaiyouHenkouCheck_A33() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112543");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112543");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112543");
        mosKihon.setKykkbn(C_KykKbn.KEIHI_DOUITU);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(340)
    public void testSkIdounaiyouHenkouCheck_A34() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112550");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112550");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosymd(BizDate.valueOf("20160428"));
        mosKihon.setKykymd(BizDate.valueOf("20160429"));
        mosKihon.setSknnkaisiymd(BizDate.valueOf("20160430"));
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setSntkhoukbn(C_SntkhouKbn.HJY);
        mosKihon.setHhknnmkn("カナ");
        mosKihon.setHhknnmkj("漢字");
        mosKihon.setHhknseiymd(BizDate.valueOf("20160401"));
        mosKihon.setHhknsei(C_Hhknsei.FEMALE);
        mosKihon.setHhknyno("1140001");
        mosKihon.setHhknadr1kj("漢字");
        mosKihon.setHhknadr2kj("漢字");
        mosKihon.setHhknadr3kj("漢字");
        mosKihon.setHhkntelno("023-4560-7890");
        mosKihon.setHhknsykgycd("060");
        mosKihon.setKyknmkn("カナ");
        mosKihon.setKyknmkj("漢字");
        mosKihon.setKykseiymd(BizDate.valueOf("20160402"));
        mosKihon.setTsinyno("0234561");
        mosKihon.setTsinadr1kj("漢字");
        mosKihon.setTsinadr2kj("漢字");
        mosKihon.setTsinadr3kj("漢字");
        mosKihon.setTsintelno("023-4560-7890");
        mosKihon.setBosyuuym(BizDateYM.valueOf("201604"));
        mosKihon.setKykkbn(C_KykKbn.KEIHI_BETU);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(350)
    public void testSkIdounaiyouHenkouCheck_A35() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112568");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112568");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, false, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(360)
    public void testSkIdounaiyouHenkouCheck_A36() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112576");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112576");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(500));

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112576");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(370)
    public void testSkIdounaiyouHenkouCheck_A37() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112584");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112584");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112584");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(380)
    public void testSkIdounaiyouHenkouCheck_A38() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112592");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112592");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(600));

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112592");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(390)
    public void testSkIdounaiyouHenkouCheck_A39() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112600");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112600");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(400));

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112600");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(400)
    public void testSkIdounaiyouHenkouCheck_A40() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112618");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112618");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(600));

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112618");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(410)
    public void testSkIdounaiyouHenkouCheck_A41() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112626");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112626");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112626");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112626");
        mosSyouhn.setSyouhncd("ｱ2");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(420)
    public void testSkIdounaiyouHenkouCheck_A42() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112634");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112634");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112634");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112634");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(2);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(430)
    public void testSkIdounaiyouHenkouCheck_A43() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112642");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112642");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112642");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112642");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(440)
    public void testSkIdounaiyouHenkouCheck_A44() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112659");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112659");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(1);
        skIdounaiyouBeforeBean.setStDrSkNin(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112659");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112659");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(450)
    public void testSkIdounaiyouHenkouCheck_A45() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112667");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112667");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(1);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112667");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112667");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(460)
    public void testSkIdounaiyouHenkouCheck_A46() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112675");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112675");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(1);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112675");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112675");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin = new HT_Uketorinin();
        uketorinin.setUktnmkn("カナカナ");
        skIdounaiyouBeforeBean.setSbUketorinin1(uketorinin);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(470)
    public void testSkIdounaiyouHenkouCheck_A47() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112683");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112683");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(1);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112683");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112683");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin = new HT_Uketorinin();
        uketorinin.setUktnmkj("漢字漢字");
        skIdounaiyouBeforeBean.setSbUketorinin1(uketorinin);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(480)
    public void testSkIdounaiyouHenkouCheck_A48() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112691");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112691");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(2);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112691");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112691");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin = new HT_Uketorinin();
        uketorinin.setUktnmkn("カナ");
        uketorinin.setUktnmkj("漢字");
        skIdounaiyouBeforeBean.setSbUketorinin1(uketorinin);
        HT_Uketorinin uketorinin2 = new HT_Uketorinin();
        uketorinin2.setUktnmkn("カナカナ");
        skIdounaiyouBeforeBean.setSbUketorinin2(uketorinin2);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(490)
    public void testSkIdounaiyouHenkouCheck_A49() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112709");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112709");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(1);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112709");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112709");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin2 = new HT_Uketorinin();
        uketorinin2.setUktnmkj("漢字漢字");
        skIdounaiyouBeforeBean.setSbUketorinin2(uketorinin2);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(500)
    public void testSkIdounaiyouHenkouCheck_A50() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112717");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112717");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(2);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112717");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112717");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin2 = new HT_Uketorinin();
        uketorinin2.setUktnmkj("漢字");
        uketorinin2.setUktnmkn("カナ");
        skIdounaiyouBeforeBean.setSbUketorinin2(uketorinin2);

        HT_Uketorinin uketorinin3 = new HT_Uketorinin();
        uketorinin3.setUktnmkn("カナカナ");
        skIdounaiyouBeforeBean.setSbUketorinin3(uketorinin3);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(510)
    public void testSkIdounaiyouHenkouCheck_A51() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112725");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112725");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(1);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112725");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112725");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin3 = new HT_Uketorinin();
        uketorinin3.setUktnmkj("漢字漢字");
        skIdounaiyouBeforeBean.setSbUketorinin3(uketorinin3);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(520)
    public void testSkIdounaiyouHenkouCheck_A52() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112733");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112733");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(2);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112733");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112733");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin3 = new HT_Uketorinin();
        uketorinin3.setUktnmkj("漢字");
        uketorinin3.setUktnmkn("カナ");
        skIdounaiyouBeforeBean.setSbUketorinin3(uketorinin3);

        HT_Uketorinin uketorinin4 = new HT_Uketorinin();
        uketorinin4.setUktnmkn("カナカナ");
        skIdounaiyouBeforeBean.setSbUketorinin4(uketorinin4);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(530)
    public void testSkIdounaiyouHenkouCheck_A53() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112741");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112741");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(1);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112741");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112741");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin4 = new HT_Uketorinin();
        uketorinin4.setUktnmkj("漢字漢字");
        skIdounaiyouBeforeBean.setSbUketorinin4(uketorinin4);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(540)
    public void testSkIdounaiyouHenkouCheck_A54() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112758");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112758");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112758");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112758");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin5 = new HT_Uketorinin();
        uketorinin5.setUktnmkn("カナカナ");
        skIdounaiyouBeforeBean.setStDrSkUketorinin1(uketorinin5);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(550)
    public void testSkIdounaiyouHenkouCheck_A55() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112766");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112766");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112766");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112766");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin5 = new HT_Uketorinin();
        uketorinin5.setUktnmkj("漢字漢字");
        skIdounaiyouBeforeBean.setStDrSkUketorinin1(uketorinin5);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(560)
    public void testSkIdounaiyouHenkouCheck_A56() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112774");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112774");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112774");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112774");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin5 = new HT_Uketorinin();
        uketorinin5.setUktnmkj("漢字");
        uketorinin5.setUktnmkn("カナ");
        skIdounaiyouBeforeBean.setStDrSkUketorinin1(uketorinin5);

        HT_MosDairiten mosDairiten = new HT_MosDairiten();
        mosDairiten.setTratkiagcd("7000002");
        skIdounaiyouBeforeBean.setMosDairiten1(mosDairiten);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(570)
    public void testSkIdounaiyouHenkouCheck_A57() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112782");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112782");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112782");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112782");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten = new HT_MosDairiten();
        mosDairiten.setBunwari(BizNumber.valueOf(2));
        skIdounaiyouBeforeBean.setMosDairiten1(mosDairiten);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(580)
    public void testSkIdounaiyouHenkouCheck_A58() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112790");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112790");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112790");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112790");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten = new HT_MosDairiten();
        mosDairiten.setRenno(1);
        mosDairiten.setDrtenkanrisosikicd("D002");
        skIdounaiyouBeforeBean.setMosDairiten1(mosDairiten);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(590)
    public void testSkIdounaiyouHenkouCheck_A59() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112808");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112808");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112808");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112808");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten = new HT_MosDairiten();
        mosDairiten.setRenno(1);
        mosDairiten.setTratkiagcd("7000001");
        mosDairiten.setBunwari(BizNumber.valueOf(1));
        mosDairiten.setDrtenkanrisosikicd("D001");
        skIdounaiyouBeforeBean.setMosDairiten1(mosDairiten);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setRenno(2);
        mosDairiten2.setTratkiagcd("7000002");
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(600)
    public void testSkIdounaiyouHenkouCheck_A60() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112816");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112816");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112816");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112816");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setRenno(2);
        mosDairiten2.setBunwari(BizNumber.valueOf(2));
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(610)
    public void testSkIdounaiyouHenkouCheck_A61() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112824");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112824");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112824");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112824");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setRenno(2);
        mosDairiten2.setDrtenkanrisosikicd("D002");
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(620)
    public void testSkIdounaiyouHenkouCheck_A62() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112832");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112832");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112832");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112832");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setTratkiagcd("7000001");
        mosDairiten2.setBunwari(BizNumber.valueOf(1));
        mosDairiten2.setDrtenkanrisosikicd("D001");
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, false, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(630)
    public void testSkIdounaiyouHenkouCheck_A63() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112840");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112840");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(0);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112840");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112840");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, false, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(640)
    public void testSkIdounaiyouHenkouCheck_A64() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112857");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112857");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(600));

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112857");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112857");
        mosSyouhn.setSyouhncd("ｱ2");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(650)
    public void testSkIdounaiyouHenkouCheck_A65() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112865");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112865");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112865");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112865");
        mosSyouhn.setSyouhncd("ｱ2");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(660)
    public void testSkIdounaiyouHenkouCheck_A66() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112873");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112873");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112873");
        mosKihon.setYennykntkhkkbn(C_Tkhukaumu.HUKA);
        mosKihon.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.HUKA);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(670)
    public void testSkIdounaiyouHenkouCheck_A67() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112881");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112881");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112881");
        mosKihon.setYennykntkhkkbn(C_Tkhukaumu.HUKA);
        mosKihon.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.HUKA);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(680)
    public void testSkIdounaiyouHenkouCheck_A68() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112899");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112899");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112899");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112899");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(2);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(690)
    public void testSkIdounaiyouHenkouCheck_A69() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112907");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112907");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(1);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112907");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112907");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin = new HT_Uketorinin();
        uketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
        skIdounaiyouBeforeBean.setSbUketorinin1(uketorinin);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(700)
    public void testSkIdounaiyouHenkouCheck_A70() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112915");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112915");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(1);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112915");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112915");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin = new HT_Uketorinin();
        uketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
        skIdounaiyouBeforeBean.setSbUketorinin2(uketorinin);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(710)
    public void testSkIdounaiyouHenkouCheck_A71() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112923");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112923");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(1);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112923");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112923");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin = new HT_Uketorinin();
        uketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
        skIdounaiyouBeforeBean.setSbUketorinin3(uketorinin);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(720)
    public void testSkIdounaiyouHenkouCheck_A72() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112931");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112931");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(1);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112931");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112931");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin = new HT_Uketorinin();
        uketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
        skIdounaiyouBeforeBean.setSbUketorinin4(uketorinin);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(730)
    public void testSkIdounaiyouHenkouCheck_A73() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112949");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112949");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112949");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112949");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_Uketorinin uketorinin5 = new HT_Uketorinin();
        uketorinin5.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
        skIdounaiyouBeforeBean.setStDrSkUketorinin1(uketorinin5);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(740)
    public void testSkIdounaiyouHenkouCheck_A74() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112956");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112956");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112956");
        mosKihon.setHhknnmkjkhukakbn(C_KjkhukaKbn.BLNK);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(750)
    public void testSkIdounaiyouHenkouCheck_A75() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112964");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112964");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112964");
        mosKihon.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(760)
    public void testSkIdounaiyouHenkouCheck_A76() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112972");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112972");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112972");
        mosKihon.setHrkkeiro(C_Hrkkeiro.DANTAI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(770)
    public void testSkIdounaiyouHenkouCheck_A77() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112980");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112980");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112980");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setHrkkeiro(C_Hrkkeiro.DANTAI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112980");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_KouzaJyouhou kouzaJyouhou = new HT_KouzaJyouhou();
        kouzaJyouhou.setMosno("791112980");
        skIdounaiyouBeforeBean.setKouzaJyouhou(kouzaJyouhou);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(780)
    public void testSkIdounaiyouHenkouCheck_A78() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112998");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791112998");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791112998");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791112998");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_KouzaJyouhou kouzaJyouhou = new HT_KouzaJyouhou();
        kouzaJyouhou.setMosno("791112998");
        kouzaJyouhou.setMosno("791112998");
        skIdounaiyouBeforeBean.setKouzaJyouhou(kouzaJyouhou);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(790)
    public void testSkIdounaiyouHenkouCheck_A79() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113004");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791113004");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791113004");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791113004");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(800)
    public void testSkIdounaiyouHenkouCheck_A80() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113012");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791113012");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791113012");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791113012");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setTratkiagcd("7000001");
        mosDairiten2.setBunwari(BizNumber.valueOf(1));
        mosDairiten2.setDrtenkanrisosikicd("D001");
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        HT_KouzaJyouhou kouzaJyouhou = new HT_KouzaJyouhou();
        kouzaJyouhou.setMosno("791113012");
        kouzaJyouhou.setBankcd("1004");
        kouzaJyouhou.setSitencd("104");
        kouzaJyouhou.setYokinkbn(C_YokinKbn.TYOTIKU);
        kouzaJyouhou.setKouzano("123451000013");
        kouzaJyouhou.setKzmeiginmkn("コウザメイギニンシメイカナ４");
        kouzaJyouhou.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
        skIdounaiyouBeforeBean.setKouzaJyouhou(kouzaJyouhou);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, false, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(810)
    public void testSkIdounaiyouHenkouCheck_A81() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113020");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791113020");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791113020");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791113020");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setTratkiagcd("7000001");
        mosDairiten2.setBunwari(BizNumber.valueOf(1));
        mosDairiten2.setDrtenkanrisosikicd("D001");
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        HT_KouzaJyouhou kouzaJyouhou = new HT_KouzaJyouhou();
        kouzaJyouhou.setMosno("791113020");
        kouzaJyouhou.setBankcd("1004");
        skIdounaiyouBeforeBean.setKouzaJyouhou(kouzaJyouhou);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(820)
    public void testSkIdounaiyouHenkouCheck_A82() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113038");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791113038");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791113038");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791113038");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setTratkiagcd("7000001");
        mosDairiten2.setBunwari(BizNumber.valueOf(1));
        mosDairiten2.setDrtenkanrisosikicd("D001");
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        HT_KouzaJyouhou kouzaJyouhou = new HT_KouzaJyouhou();
        kouzaJyouhou.setMosno("791113038");
        kouzaJyouhou.setSitencd("105");
        skIdounaiyouBeforeBean.setKouzaJyouhou(kouzaJyouhou);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(830)
    public void testSkIdounaiyouHenkouCheck_A83() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113046");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791113046");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791113046");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791113046");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setTratkiagcd("7000001");
        mosDairiten2.setBunwari(BizNumber.valueOf(1));
        mosDairiten2.setDrtenkanrisosikicd("D001");
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        HT_KouzaJyouhou kouzaJyouhou = new HT_KouzaJyouhou();
        kouzaJyouhou.setMosno("791113046");
        kouzaJyouhou.setYokinkbn(C_YokinKbn.TEIKI);
        skIdounaiyouBeforeBean.setKouzaJyouhou(kouzaJyouhou);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(840)
    public void testSkIdounaiyouHenkouCheck_A84() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113053");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791113053");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791113053");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791113053");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setTratkiagcd("7000001");
        mosDairiten2.setBunwari(BizNumber.valueOf(1));
        mosDairiten2.setDrtenkanrisosikicd("D001");
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        HT_KouzaJyouhou kouzaJyouhou = new HT_KouzaJyouhou();
        kouzaJyouhou.setMosno("791113053");
        kouzaJyouhou.setKouzano("123451000016");
        skIdounaiyouBeforeBean.setKouzaJyouhou(kouzaJyouhou);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(850)
    public void testSkIdounaiyouHenkouCheck_A85() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113061");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791113061");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791113061");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791113061");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setTratkiagcd("7000001");
        mosDairiten2.setBunwari(BizNumber.valueOf(1));
        mosDairiten2.setDrtenkanrisosikicd("D001");
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        HT_KouzaJyouhou kouzaJyouhou = new HT_KouzaJyouhou();
        kouzaJyouhou.setMosno("791113061");
        kouzaJyouhou.setKzmeiginmkn("コウザメイギニンシメイカナ７");
        skIdounaiyouBeforeBean.setKouzaJyouhou(kouzaJyouhou);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(860)
    public void testSkIdounaiyouHenkouCheck_A86() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113079");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791113079");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791113079");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791113079");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setTratkiagcd("7000001");
        mosDairiten2.setBunwari(BizNumber.valueOf(1));
        mosDairiten2.setDrtenkanrisosikicd("D001");
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        HT_KouzaJyouhou kouzaJyouhou = new HT_KouzaJyouhou();
        kouzaJyouhou.setMosno("791113079");
        kouzaJyouhou.setKzkykdoukbn(C_KzkykdouKbn.DOUITU);
        skIdounaiyouBeforeBean.setKouzaJyouhou(kouzaJyouhou);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(870)
    public void testSkIdounaiyouHenkouCheck_A87() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113087");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791113087");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791113087");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791113087");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setTratkiagcd("7000001");
        mosDairiten2.setBunwari(BizNumber.valueOf(1));
        mosDairiten2.setDrtenkanrisosikicd("D001");
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        HT_KouzaJyouhou kouzaJyouhou = new HT_KouzaJyouhou();
        kouzaJyouhou.setMosno("791113087");
        kouzaJyouhou.setHbcmnt("不備コメント１");
        skIdounaiyouBeforeBean.setKouzaJyouhou(kouzaJyouhou);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, false, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(880)
    public void testSkIdounaiyouHenkouCheck_A88() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113095");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791113095");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791113095");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791113095");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setTratkiagcd("7000001");
        mosDairiten2.setBunwari(BizNumber.valueOf(1));
        mosDairiten2.setDrtenkanrisosikicd("D001");
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        HT_KouzaJyouhou kouzaJyouhou = new HT_KouzaJyouhou();
        kouzaJyouhou.setMosno("791113095");
        kouzaJyouhou.setBankcd("1011");
        kouzaJyouhou.setHbcmnt("不備コメント２");
        kouzaJyouhou.setKouzajyouhounyuuryokuymd(BizDate.valueOf(20181112));
        skIdounaiyouBeforeBean.setKouzaJyouhou(kouzaJyouhou);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(890)
    public void testSkIdounaiyouHenkouCheck_A89() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113103");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791113103");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.USD);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791113103");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791113103");
        mosSyouhn.setSyouhncd("ﾕﾁ");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setTratkiagcd("7000001");
        mosDairiten2.setBunwari(BizNumber.valueOf(1));
        mosDairiten2.setDrtenkanrisosikicd("D001");
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, false, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(900)
    public void testSkIdounaiyouHenkouCheck_A90() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113111");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("791113111");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.AUD);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(1);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("791113111");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        mosKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("791113111");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosDairiten mosDairiten2 = new HT_MosDairiten();
        mosDairiten2.setTratkiagcd("7000001");
        mosDairiten2.setBunwari(BizNumber.valueOf(1));
        mosDairiten2.setDrtenkanrisosikicd("D001");
        skIdounaiyouBeforeBean.setMosDairiten2(mosDairiten2);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(940)
    public void testSkIdounaiyouHenkouCheck_A94() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000108");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("860000108");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(0);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("860000108");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("860000108");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosTrkKzk mosTrkKzk = new HT_MosTrkKzk();
        mosTrkKzk.setTrkkzknmkn("カナカナ１");
        skIdounaiyouBeforeBean.setMosTrkKzk1(mosTrkKzk);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(950)
    public void testSkIdounaiyouHenkouCheck_A95() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000447");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("860000447");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(0);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("860000447");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("860000447");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosTrkKzk mosTrkKzk = new HT_MosTrkKzk();
        mosTrkKzk.setTrkkzknmkj("漢字漢字１");
        skIdounaiyouBeforeBean.setMosTrkKzk1(mosTrkKzk);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(960)
    public void testSkIdounaiyouHenkouCheck_A96() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000322");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("860000322");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(0);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("860000322");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("860000322");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosTrkKzk mosTrkKzk = new HT_MosTrkKzk();
        mosTrkKzk.setTrkkzknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        skIdounaiyouBeforeBean.setMosTrkKzk1(mosTrkKzk);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(970)
    public void testSkIdounaiyouHenkouCheck_A97() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000504");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("860000504");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(2);
        skIdounaiyouBeforeBean.setMosDrt(0);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("860000504");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("860000504");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosTrkKzk mosTrkKzk1 = new HT_MosTrkKzk();
        mosTrkKzk1.setTrkkzknmkn("カナ１");
        mosTrkKzk1.setTrkkzknmkj("漢字１");
        skIdounaiyouBeforeBean.setMosTrkKzk1(mosTrkKzk1);

        HT_MosTrkKzk mosTrkKzk = new HT_MosTrkKzk();
        mosTrkKzk.setTrkkzknmkn("カナカナ２");
        skIdounaiyouBeforeBean.setMosTrkKzk2(mosTrkKzk);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(980)
    public void testSkIdounaiyouHenkouCheck_A98() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000116");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("860000116");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(0);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("860000116");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("860000116");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosTrkKzk mosTrkKzk = new HT_MosTrkKzk();
        mosTrkKzk.setTrkkzknmkj("漢字漢字２");
        skIdounaiyouBeforeBean.setMosTrkKzk2(mosTrkKzk);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(990)
    public void testSkIdounaiyouHenkouCheck_A99() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001153");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("870001153");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(0);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("870001153");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("870001153");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosTrkKzk mosTrkKzk = new HT_MosTrkKzk();
        mosTrkKzk.setTrkkzknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        skIdounaiyouBeforeBean.setMosTrkKzk2(mosTrkKzk);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(1000)
    public void testSkIdounaiyouHenkouCheck_A100() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001146");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("870001146");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(0);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("870001146");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("870001146");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosTrkKzk mosTrkKzk = new HT_MosTrkKzk();
        mosTrkKzk.setTrkkzknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
        skIdounaiyouBeforeBean.setMosTrkKzk2(mosTrkKzk);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, false, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(1020)
    public void testSkIdounaiyouHenkouCheck_A102() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000023");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("870000023");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(1);
        skIdounaiyouBeforeBean.setMosDrt(0);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("870000023");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("870000023");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosTrkKzk mosTrkKzk = new HT_MosTrkKzk();
        mosTrkKzk.setTrkkzknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
        skIdounaiyouBeforeBean.setMosTrkKzk1(mosTrkKzk);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, false, "判定結果");
    }

    @Test
    @Transactional
    @TestOrder(1030)
    public void testSkIdounaiyouHenkouCheck_A103() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000015");
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = new  SkIdounaiyouBeforeBean();
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("870000015");
        skIdounaiyouBeforeBean.setSyoriCTL(syoriCTL2);
        skIdounaiyouBeforeBean.setTsnSibouS(BizCurrency.valueOf(400));
        skIdounaiyouBeforeBean.setItijiP(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setTsnyouNkGns(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyEnNyknkGk(BizCurrency.valueOf(0));
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(0);

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno("870000015");
        mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
        skIdounaiyouBeforeBean.setMosKihon(mosKihon);

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno("870000015");
        mosSyouhn.setSyouhncd("ｱ1");
        mosSyouhn.setSyouhnsdno(1);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        mosSyouhn.setHrkkkn(1);
        mosSyouhn.setKihons(BizCurrency.valueOf(400));
        mosSyouhn.setSyutkp(BizCurrency.valueOf(500));
        skIdounaiyouBeforeBean.setMosSyouhn(mosSyouhn);

        HT_MosTrkKzk mosTrkKzk = new HT_MosTrkKzk();
        mosTrkKzk.setTrkkzknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
        skIdounaiyouBeforeBean.setMosTrkKzk2(mosTrkKzk);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,skIdounaiyouBeforeBean);

        exBooleanEquals(result, true, "判定結果");
    }
}
