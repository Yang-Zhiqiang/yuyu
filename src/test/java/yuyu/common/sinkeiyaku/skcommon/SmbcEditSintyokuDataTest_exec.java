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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SMBC進捗管理データ編集クラスのメソッド {@link SmbcEditSintyokuData#exec(HT_SyoriCTL, BizDate, HashMap<String, Object>)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SmbcEditSintyokuDataTest_exec {

    @Inject
    private SmbcEditSintyokuData smbcEditSintyokuData;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_SMBC進捗管理データ編集";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SmbcEditSintyokuDataTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanriSsRireki());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHONYKNZMYMD), "", "ＳＭＢＣ＿生保入金済DATE");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());

        try {
            smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=860000025", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHONYKNZMYMD), "20160102", "ＳＭＢＣ＿生保入金済DATE");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_B1() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "20160202", "ＳＭＢＣ＿生保不備DATE");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_B2() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "20160101", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_B3() {
        BizDate syoriDate = BizDate.valueOf(20160110);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, null);

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "20160110", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_B4() {
        BizDate syoriDate = BizDate.valueOf(20160120);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000074");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "20160120", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_B5() {
        BizDate syoriDate = BizDate.valueOf(20160120);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000082");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "20160120", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_B6() {
        BizDate syoriDate = BizDate.valueOf(20160115);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000090");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "20160115", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_B7() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000108");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "20160101", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_B8() {
        BizDate syoriDate = BizDate.valueOf(20160120);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000751");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "20160103", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_B9() {
        BizDate syoriDate = BizDate.valueOf(20160120);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000769");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160105");
        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "20160105", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_C1() {
        BizDate syoriDate = BizDate.valueOf(20160110);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000116");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "20160203", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_C2() {
        BizDate syoriDate = BizDate.valueOf(20160110);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000124");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_C3() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000132");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, null);

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "20160101", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_C4() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000140");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160101");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "20160101");

        smbcEditSintyokuData.setFstrndumuflg(C_UmuKbn.ARI);
        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_C5() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000157");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160101");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "20160101");

        smbcEditSintyokuData.setFstrndumuflg(C_UmuKbn.NONE);
        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_C6() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000165");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD + "RRK", "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160101");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "20160101");

        smbcEditSintyokuData.setFstrndumuflg(C_UmuKbn.NONE);
        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "20160203", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_C7() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000173");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD + "RRK", "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160101");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "20160101");

        smbcEditSintyokuData.setFstrndumuflg(C_UmuKbn.NONE);
        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "20160101", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_C8() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000181");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD + "RRK", "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160101");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "20160101");

        smbcEditSintyokuData.setFstrndumuflg(C_UmuKbn.NONE);
        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "20160101", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_C9() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000199");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "20160202", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_C10() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000207");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());

        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "20160202", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_C11() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000215");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "20160101", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_C12() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000223");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "20160202", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testExec_C13() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000777");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160101");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "20160101");

        smbcEditSintyokuData.setFstrndumuflg(C_UmuKbn.NONE);
        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testExec_C14() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000785");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD + "RRK", null);
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160101");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "20160101");

        smbcEditSintyokuData.setFstrndumuflg(C_UmuKbn.NONE);
        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "20160101", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testExec_C15() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000868");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160101");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "20160202", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(280)
    public void testExec_C16() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000876");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160101");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "20160101", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(290)
    public void testExec_C17() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000884");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160101");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "20160101", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(300)
    public void testExec_C18() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000892");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160101");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "20160101", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(310)
    public void testExec_C19() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000900");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD), "20160202", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD), "", "ＳＭＢＣ＿生保不備解消DATE");
    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testExec_D1() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000231");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSYKNHKKZMYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOSYKNHKKZMYMD), "", "ＳＭＢＣ＿生保証券発行済DATE");
    }

    @Test
    @Transactional
    @TestOrder(330)
    public void testExec_D2() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000249");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSYKNHKKZMYMD, "20160204");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOSYKNHKKZMYMD), "20160204", "ＳＭＢＣ＿生保証券発行済DATE");
    }

    @Test
    @Transactional
    @TestOrder(340)
    public void testExec_D3() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000256");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSYKNHKKZMYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOSYKNHKKZMYMD), "20160102", "ＳＭＢＣ＿生保証券発行済DATE");
    }

    @Test
    @Transactional
    @TestOrder(350)
    public void testExec_D4() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000793");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSYKNHKKZMYMD, null);

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOSYKNHKKZMYMD), "20160102", "ＳＭＢＣ＿生保証券発行済DATE");
    }

    @Test
    @Transactional
    @TestOrder(360)
    public void testExec_E1() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000264");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD), "", "ＳＭＢＣ＿生保取消DATE");
    }

    @Test
    @Transactional
    @TestOrder(370)
    public void testExec_E2() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000272");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "20160101");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160204");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD), "20160204", "ＳＭＢＣ＿生保取消DATE");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(380)
    public void testExec_E3() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000280");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "20160101");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "");

        try {
            smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=860000280", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(390)
    public void testExec_E4() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000298");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "20160101");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, null);

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD), "20160102", "ＳＭＢＣ＿生保取消DATE");
    }

    @Test
    @Transactional
    @TestOrder(400)
    public void testExec_E5() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000306");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "20160101");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD), "20160103", "ＳＭＢＣ＿生保取消DATE");
    }

    @Test
    @Transactional
    @TestOrder(410)
    public void testExec_E6() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000314");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "20160101");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD), "", "ＳＭＢＣ＿生保取消DATE");
    }

    @Test
    @Transactional
    @TestOrder(420)
    public void testExec_F1() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000322");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160204");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHKTYMD), "", "ＳＭＢＣ＿生保否決DATE");
    }

    @Test
    @Transactional
    @TestOrder(430)
    public void testExec_F2() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000330");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160204");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "20160107");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHKTYMD), "20160107", "ＳＭＢＣ＿生保否決DATE");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(440)
    public void testExec_F3() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000348");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160204");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "");

        try {
            smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=860000348", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(450)
    public void testExec_F4() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000355");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160204");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, null);

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHKTYMD), "20160106", "ＳＭＢＣ＿生保否決DATE");
    }

    @Test
    @Transactional
    @TestOrder(460)
    public void testExec_F5() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000363");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160204");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHKTYMD), "20160107", "ＳＭＢＣ＿生保否決DATE");
    }

    @Test
    @Transactional
    @TestOrder(470)
    public void testExec_F6() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000371");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160204");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHKTYMD), "20160108", "ＳＭＢＣ＿生保否決DATE");
    }

    @Test
    @Transactional
    @TestOrder(480)
    public void testExec_F7() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000389");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160204");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHKTYMD), "20160109", "ＳＭＢＣ＿生保否決DATE");
    }

    @Test
    @Transactional
    @TestOrder(490)
    public void testExec_F8() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000397");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, "20160204");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHKTYMD), "", "ＳＭＢＣ＿生保否決DATE");
    }

    @Test
    @Transactional
    @TestOrder(500)
    public void testExec_G1() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000405");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD), "", "ＳＭＢＣ＿生保審査済DATE");
    }

    @Test
    @Transactional
    @TestOrder(510)
    public void testExec_G2() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000413");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD), "", "ＳＭＢＣ＿生保審査済DATE");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(520)
    public void testExec_G3() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000421");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD, "");

        try {
            smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=860000421", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(530)
    public void testExec_G4() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000439");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD), "20160101", "ＳＭＢＣ＿生保審査済DATE");
    }

    @Test
    @Transactional
    @TestOrder(540)
    public void testExec_G5() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000447");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD), "20160103", "ＳＭＢＣ＿生保審査済DATE");
    }

    @Test
    @Transactional
    @TestOrder(550)
    public void testExec_H1() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000454");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD), "", "ＳＭＢＣ＿生保報状到着DATE");
    }

    @Test
    @Transactional
    @TestOrder(560)
    public void testExec_H2() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000462");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD), "", "ＳＭＢＣ＿生保報状到着DATE");
    }

    @Test
    @Transactional
    @TestOrder(570)
    public void testExec_H3() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000470");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD), "", "ＳＭＢＣ＿生保報状到着DATE");
    }

    @Test
    @Transactional
    @TestOrder(580)
    public void testExec_H4() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000488");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD), "20160102", "ＳＭＢＣ＿生保報状到着DATE");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(590)
    public void testExec_H5() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000496");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "");

        try {
            smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=860000496", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(600)
    public void testExec_H6() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000504");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, null);

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD), "20160103", "ＳＭＢＣ＿生保報状到着DATE");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(610)
    public void testExec_H7() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000512");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "");

        try {
            smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=860000512", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(620)
    public void testExec_H8() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000520");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD), "20160104", "ＳＭＢＣ＿生保報状到着DATE");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(630)
    public void testExec_H9() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000538");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "");

        try {
            smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=860000538", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(640)
    public void testExec_H10() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000546");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD), "20160105", "ＳＭＢＣ＿生保報状到着DATE");
    }

    @Test
    @Transactional
    @TestOrder(650)
    public void testExec_H11() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000553");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD), "", "ＳＭＢＣ＿生保報状到着DATE");
    }

    @Test
    @Transactional
    @TestOrder(660)
    public void testExec_I1() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000561");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160102");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD), "20160102", "ＳＭＢＣ＿生保受付済DATE");
    }

    @Test
    @Transactional
    @TestOrder(670)
    public void testExec_I2() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000579");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals(
            (String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD), "20160107", "ＳＭＢＣ＿生保受付済DATE");
    }

    @Test
    @Transactional
    @TestOrder(680)
    public void testExec_I3() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000587");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, null);

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD), null, "ＳＭＢＣ＿生保受付済DATE");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(690)
    public void testExec_J1() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000595");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        try {
            smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=860000595", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(700)
    public void testExec_J2() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000603");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        try {
            smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=860000603", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(710)
    public void testExec_J3() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000611");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "0", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(720)
    public void testExec_J4() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000629");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(730)
    public void testExec_J5() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000637");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        try {
            smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=860000637", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(740)
    public void testExec_J6() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000645");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "1", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(750)
    public void testExec_J7() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000652");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "1", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(760)
    public void testExec_J8() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000660");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "1", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(770)
    public void testExec_J9() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000678");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "1", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(780)
    public void testExec_J10() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000686");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "1", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(790)
    public void testExec_J11() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000694");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "1", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(800)
    public void testExec_J12() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000702");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "0", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(810)
    public void testExec_J13() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000710");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "0", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(820)
    public void testExec_J14() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000801");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "0", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(830)
    public void testExec_J15() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000819");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "0", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(840)
    public void testExec_J16() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000827");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "0", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(850)
    public void testExec_J17() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000835");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "0", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(860)
    public void testExec_J18() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000843");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "0", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(870)
    public void testExec_J19() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000850");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCJKTKFLG), "0", "ＳＭＢＣ＿条件付フラグ");
    }

    @Test
    @Transactional
    @TestOrder(880)
    public void testExec_K1() {
        BizDate syoriDate = BizDate.valueOf(20160101);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000728");

        HashMap<String, Object> smbcStyKanriMp = new HashMap<>();
        smbcStyKanriMp.put(HT_SyoriCTL.MOSNO, syoriCTL.getMosno());
        smbcStyKanriMp.put(HT_SyoriCTL.SYONO, syoriCTL.getSyono());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, "20160202");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, "20160203");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, "20160102");
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, "20160103");

        smbcEditSintyokuData.exec(syoriCTL, syoriDate, smbcStyKanriMp);

        exStringEquals((String)smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOSYURUI), "70", "ＳＭＢＣ＿生保種類");
    }
}
