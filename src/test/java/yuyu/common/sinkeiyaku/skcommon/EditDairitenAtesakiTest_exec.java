package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約 新契約共通 代理店宛先編集のメソッド
 * {@link EditDairitenAtesaki#exec(EditDairitenAtesakiBean)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class EditDairitenAtesakiTest_exec {

    private final static String mosNo1 = "860000025";

    private final static String mosNo2 = "860000033";

    private final static String mosNo3 = "860000041";

    private final static String mosNo4 = "860000058";

    private final static String mosNo5 = "860000066";

    private final static String mosNo6 = "860000074";

    private final static String mosNo7 = "860000082";

    private final static String mosNo8 = "860000090";

    private final static String mosNo9 = "860000108";

    private final static String mosNo10 = "860000116";

    private final static String mosNo11 = "860000124";

    private final static String mosNo12 = "860000132";

    private final static String mosNo13 = "860000140";

    private final static String mosNo14 = "860000157";

    private final static String mosNo15 = "860000165";

    private final static String mosNo16 = "860000173";

    private final static String mosNo17 = "860000181";

    private final static String mosNo18 = "860000199";

    private final static String mosNo19 = "860000207";

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_代理店宛先編集";

    private final static String sheetName = "INデータ";

    @Inject
    private EditDairitenAtesaki editDairitenAtesaki;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditDairitenAtesakiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkDairitenKobetuJyouhou());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);
        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);
        editDairitenAtesakiBean.setMosDairiten(null);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        editDairitenAtesakiBean.setKetkekkaCd(C_Ketkekkacd.MIAWASE);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "（保険窓販ご担当者様）", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "新契約チーム", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "2018年 3月 7日", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), "", "（ＩＲ）代理店発送月日");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        editDairitenAtesakiBean.setKetkekkaCd(C_Ketkekkacd.MIAWASE);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "（保険窓販ご担当者様）", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "機関名１０２", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "FAX", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "06-6937-1137", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "新契約チーム", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "2018年 3月 7日", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), "", "（ＩＲ）代理店発送月日");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(C_SeirituKbn.SEIRITU);
        editDairitenAtesakiBean.setKetkekkaCd(C_Ketkekkacd.MIAWASE);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "（保険窓販ご担当者様）", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "FAX", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "06-6937-1137", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "2018年 3月 7日", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), "", "（ＩＲ）代理店発送月日");

    }

    @Test()
    @TestOrder(40)
    public void testExec_A4() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        editDairitenAtesakiBean.setKetkekkaCd(C_Ketkekkacd.JYOUKENTUKI);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "（保険窓販ご担当者様）", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "機関名１０４", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "（機関名２０４）", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "FAX", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "06-6937-1137", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "2018年 3月 7日", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), "", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(50)
    public void testExec_A5() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_KYKHUSEIRITU);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(null);
        editDairitenAtesakiBean.setKetkekkaCd(null);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "機関名１０５", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "（機関名２０５）", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "FAX：", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "06-6937-1137", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), " 3月 7日", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(60)
    public void testExec_A6() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_KYKHUSEIRITU);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(null);
        editDairitenAtesakiBean.setKetkekkaCd(null);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "募集人名０１", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "機関名１０６", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "（リテール業務センター）", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "代理店０１", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "FAX：", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "06-6937-1137", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), " 3月 7日", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(70)
    public void testExec_A7() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(null);
        editDairitenAtesakiBean.setKetkekkaCd(null);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "募集人名０１", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "代理店０１", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "FAX：", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "06-6937-1137", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), " 3月 7日", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(80)
    public void testExec_A8() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(null);
        editDairitenAtesakiBean.setKetkekkaCd(null);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "募集人名０１", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "機関名１０６", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "（機関名２０６）", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "代理店０１", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "FAX：", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "06-6937-1137", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), " 3月 7日", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(90)
    public void testExec_A9() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(null);
        editDairitenAtesakiBean.setKetkekkaCd(null);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "募集人名０１", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "機関名１０６", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "（機関名２０６）", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "代理店０１", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "FAX：", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "06-6937-1137", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), " 3月 7日", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(100)
    public void testExec_A10() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_KYKKAKUNINKAITOUSYO);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(null);
        editDairitenAtesakiBean.setKetkekkaCd(null);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), "", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(110)
    public void testExec_A11() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo10);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_KYKHUSEIRITU);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(null);
        editDairitenAtesakiBean.setKetkekkaCd(null);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "FAX：", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "06-6937-1137", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), " 3月 7日", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(120)
    public void testExec_A12() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_MosDairiten mosDairiten = null;

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_KYKHUSEIRITU);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(null);
        editDairitenAtesakiBean.setKetkekkaCd(null);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), " 3月 7日", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(130)
    public void testExec_A13() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo11);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(null);
        editDairitenAtesakiBean.setKetkekkaCd(null);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "募集人名０１", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "機関名１０８", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "代理店０１", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "FAX：", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "06-6937-1137", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), " 3月 7日", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(140)
    public void testExec_A14() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo12);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_KYKHUSEIRITU);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(null);
        editDairitenAtesakiBean.setKetkekkaCd(null);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "機関名１０９", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "FAX：", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "06-6937-1137", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), " 3月 7日", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(150)
    public void testExec_A15() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo13);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        editDairitenAtesakiBean.setKetkekkaCd(C_Ketkekkacd.JYOUKENTUKI);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "（保険窓販ご担当者様）", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "（機関名２１０）", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "FAX", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "06-6937-1137", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "2018年 3月 7日", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), "", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(160)
    public void testExec_A16() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo14);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        editDairitenAtesakiBean.setKetkekkaCd(C_Ketkekkacd.COOLINGOFF);
        editDairitenAtesakiBean.setSkeijimuKbn(C_SkeijimuKbn.SHOP);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "募集人名０１　様", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "機関名１０６", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "（機関名２０６）", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.SHOP, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "2018年 3月 7日", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), "", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(170)
    public void testExec_A17() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo15);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        editDairitenAtesakiBean.setKetkekkaCd(C_Ketkekkacd.COOLINGOFF);
        editDairitenAtesakiBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "（保険窓販ご担当者様）", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "2018年 3月 7日", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), "", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(180)
    public void testExec_A18() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo16);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(null);
        editDairitenAtesakiBean.setKetkekkaCd(null);
        editDairitenAtesakiBean.setSkeijimuKbn(C_SkeijimuKbn.SHOP);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "募集人名０１", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "機関名１０６", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "（機関名２０６）", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "代理店０１", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.SHOP, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), " 3月 7日", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(190)
    public void testExec_A19() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo17);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(null);
        editDairitenAtesakiBean.setKetkekkaCd(null);
        editDairitenAtesakiBean.setSkeijimuKbn(C_SkeijimuKbn.BLNK);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "募集人名０１", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), null, "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), " 3月 7日", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(200)
    public void testExec_A20() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo18);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        editDairitenAtesakiBean.setKetkekkaCd(C_Ketkekkacd.COOLINGOFF);
        editDairitenAtesakiBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "（保険窓販ご担当者様）", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), "", "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "（機関名２１０）", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "FAX", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "06-6937-1137", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "2018年 3月 7日", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), "", "（ＩＲ）代理店発送月日");
    }

    @Test()
    @TestOrder(210)
    public void testExec_A21() {

        EditDairitenAtesakiBean editDairitenAtesakiBean = SWAKInjector.getInstance(EditDairitenAtesakiBean.class);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo19);
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitens().get(0);

        editDairitenAtesakiBean.setSyoruiCdKbn(C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU);
        editDairitenAtesakiBean.setMosDairiten(mosDairiten);
        editDairitenAtesakiBean.setHassouYmd(BizDate.valueOf("20180307"));
        editDairitenAtesakiBean.setSeirituKbn(null);
        editDairitenAtesakiBean.setKetkekkaCd(null);
        editDairitenAtesakiBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);

        BzDairitenAtesakiBean bzDairitenAtesakiBean = editDairitenAtesaki.exec(editDairitenAtesakiBean);

        exStringEquals(bzDairitenAtesakiBean.getIrTratkitantounmkj(), "募集人名０１", "（ＩＲ）取扱担当者名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm1(), null, "（ＩＲ）代理店打出機関名１");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenutdskknnm2(), "（機関名２１０）", "（ＩＲ）代理店打出機関名２");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtennmkj(), "代理店０１", "（ＩＲ）代理店名（漢字）");
        exClassificationEquals(bzDairitenAtesakiBean.getIrSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "（ＩＲ）新契約事務区分");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxmidasi(), "FAX：", "（ＩＲ）問合せ先ＦＡＸ見出し");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasefaxno(), "06-6937-1137", "（ＩＲ）問合せ先ＦＡＸ番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetelno(), "0120-232-303", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasesosiki(), "代理店契約室", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzDairitenAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzDairitenAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(bzDairitenAtesakiBean.getIrTyouhyousakuseiymd(), "", "（ＩＲ）帳票作成日");
        exStringEquals(bzDairitenAtesakiBean.getIrDrtenhassouymd(), " 3月 7日", "（ＩＲ）代理店発送月日");
    }
}

