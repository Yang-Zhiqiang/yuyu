package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.dao.HT_SyoriCTLDao;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 扱者TBL編集クラスのメソッド {@link EditTblAtukaisya#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditTblAtukaisyaTest_exec {

    private final static String mosno1 = "885012112";

    private final static String mosno2 = "885012120";

    private final static String mosno3 = "885012138";

    private final static String mosno4 = "885012146";

    @Inject
    private EditTblAtukaisya editTblAtukaisya;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_扱者TBL編集";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditTblAtukaisyaTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        HT_SyoriCTLDao syoriCTLDao = SWAKInjector.getInstance(HT_SyoriCTLDao.class);
        sinkeiyakuDomManager.delete(syoriCTLDao.selectAll());
        bizDomManager.delete(bizDomManager.getAllDairiten());
        bizDomManager.delete(bizDomManager.getAllBosyuunin());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        try{
            HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosno1);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);

            HT_MosKihon mosKihon = syoriCTL.createMosKihon();
            mosKihon.setMosymd(BizDate.valueOf("20150605"));
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);

            editTblAtukaisya.exec(mosnaiCheckParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込代理店TBLにデータ無（申込番号 = 885012112)", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosno2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setMosymd(BizDate.valueOf("20150605"));
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        ArrayList<Map<String,String>> atukaisyaLst = editTblAtukaisya.exec(mosnaiCheckParam);

        Map<String,String> atukaisyaMap = atukaisyaLst.get(0);

        exStringEquals(atukaisyaMap.get("01"), "1", "扱者情報キー（連番）");
        exStringEquals(atukaisyaMap.get("04"), "0000", "扱者情報キー（金融機関コード）");
        exStringEquals(atukaisyaMap.get("05"), "0000", "扱者情報キー（金融機関支店コード）");
        exStringEquals(atukaisyaMap.get("06"), "0000000", "扱者情報キー（代理店支店コード）");
        exStringEquals(atukaisyaMap.get("07"), "", "扱者情報キー（代理店名）");
        exStringEquals(atukaisyaMap.get("08"), "0000000", "扱者情報キー（取扱代理店コード）");
        exStringEquals(atukaisyaMap.get("09"), "", "扱者情報キー（取扱代理店名）");
        exStringEquals(atukaisyaMap.get("10"), "0000000", "扱者情報キー（親代理店コード）");
        exStringEquals(atukaisyaMap.get("11"), "", "扱者情報キー（親代理店名）");
        exStringEquals(atukaisyaMap.get("12"), "000000", "扱者情報キー（募集人コード）");
        exStringEquals(atukaisyaMap.get("13"), "", "扱者情報キー（募集人登録番号）");
        exStringEquals(atukaisyaMap.get("14"), "", "扱者情報キー（募集人名）");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosno3);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setMosymd(BizDate.valueOf("20150605"));

        List<HT_MosDairiten> mosDairitenList = new ArrayList<>();
        HT_MosDairiten mosDairiten = syoriCTL.createMosDairiten();
        mosDairiten.setRenno(1);
        mosDairiten.setKinyuucd("0001");
        mosDairiten.setKinyuusitencd("0002");
        mosDairiten.setDrtencd("0000003");
        mosDairiten.setTratkiagcd("0000004");
        mosDairiten.setOyadrtencd("0000005");
        mosDairiten.setBosyuutrkno("0000000000006");
        mosDairiten.setBosyuucd("000007");
        mosDairitenList.add(mosDairiten);
        syoriCTL.setMosDairitens(mosDairitenList);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        ArrayList<Map<String,String>> atukaisyaLst = editTblAtukaisya.exec(mosnaiCheckParam);

        Map<String,String> atukaisyaMap = atukaisyaLst.get(0);

        exStringEquals(atukaisyaMap.get("01"), "1", "扱者情報キー（連番）");
        exStringEquals(atukaisyaMap.get("04"), "0001", "扱者情報キー（金融機関コード）");
        exStringEquals(atukaisyaMap.get("05"), "0002", "扱者情報キー（金融機関支店コード）");
        exStringEquals(atukaisyaMap.get("06"), "0000003", "扱者情報キー（代理店支店コード）");
        exStringEquals(atukaisyaMap.get("07"), "", "扱者情報キー（代理店名）");
        exStringEquals(atukaisyaMap.get("08"), "0000004", "扱者情報キー（取扱代理店コード）");
        exStringEquals(atukaisyaMap.get("09"), "取扱代理店名", "扱者情報キー（取扱代理店名）");
        exStringEquals(atukaisyaMap.get("10"), "0000005", "扱者情報キー（親代理店コード）");
        exStringEquals(atukaisyaMap.get("11"), "親代理店名", "扱者情報キー（親代理店名）");
        exStringEquals(atukaisyaMap.get("12"), "000007", "扱者情報キー（募集人コード）");
        exStringEquals(atukaisyaMap.get("13"), "0000000000006", "扱者情報キー（募集人登録番号）");
        exStringEquals(atukaisyaMap.get("14"), "募集人名", "扱者情報キー（募集人名）");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosno4);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setMosymd(BizDate.valueOf("20150605"));

        List<HT_MosDairiten> mosDairitenList = new ArrayList<>();
        HT_MosDairiten mosDairiten = syoriCTL.createMosDairiten();
        mosDairiten.setRenno(1);
        mosDairiten.setKinyuucd("0001");
        mosDairiten.setKinyuusitencd("0002");
        mosDairiten.setDrtencd("0000003");
        mosDairiten.setTratkiagcd("0000004");
        mosDairiten.setOyadrtencd("0000005");
        mosDairiten.setBosyuutrkno("0000000000006");
        mosDairiten.setBosyuucd("000007");

        HT_MosDairiten mosDairiten2 = syoriCTL.createMosDairiten();
        mosDairiten2.setRenno(2);
        mosDairiten2.setKinyuucd("0008");
        mosDairiten2.setKinyuusitencd("0009");
        mosDairiten2.setDrtencd("0000010");
        mosDairiten2.setTratkiagcd("0000011");
        mosDairiten2.setOyadrtencd("0000012");
        mosDairiten2.setBosyuutrkno("0000000000013");
        mosDairiten2.setBosyuucd("000014");

        HT_MosDairiten mosDairiten3 = syoriCTL.createMosDairiten();
        mosDairiten3.setRenno(3);
        mosDairiten3.setKinyuucd("0015");
        mosDairiten3.setKinyuusitencd("0016");
        mosDairiten3.setDrtencd("0000017");
        mosDairiten3.setTratkiagcd("0000018");
        mosDairiten3.setOyadrtencd("0000019");
        mosDairiten3.setBosyuutrkno("0000000000020");
        mosDairiten3.setBosyuucd("000021");

        mosDairitenList.add(mosDairiten);
        mosDairitenList.add(mosDairiten2);
        mosDairitenList.add(mosDairiten3);
        syoriCTL.setMosDairitens(mosDairitenList);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        ArrayList<Map<String,String>> atukaisyaLst = editTblAtukaisya.exec(mosnaiCheckParam);

        Map<String,String> atukaisyaMap = atukaisyaLst.get(0);
        Map<String,String> atukaisyaMap2 = atukaisyaLst.get(1);
        Map<String,String> atukaisyaMap3 = atukaisyaLst.get(2);

        exStringEquals(atukaisyaMap.get("01"), "1", "扱者情報キー（連番）");
        exStringEquals(atukaisyaMap.get("04"), "0001", "扱者情報キー（金融機関コード）");
        exStringEquals(atukaisyaMap.get("05"), "0002", "扱者情報キー（金融機関支店コード）");
        exStringEquals(atukaisyaMap.get("06"), "0000003", "扱者情報キー（代理店支店コード）");
        exStringEquals(atukaisyaMap.get("07"), "", "扱者情報キー（代理店名）");
        exStringEquals(atukaisyaMap.get("08"), "0000004", "扱者情報キー（取扱代理店コード）");
        exStringEquals(atukaisyaMap.get("09"), "取扱代理店名", "扱者情報キー（取扱代理店名）");
        exStringEquals(atukaisyaMap.get("10"), "0000005", "扱者情報キー（親代理店コード）");
        exStringEquals(atukaisyaMap.get("11"), "親代理店名", "扱者情報キー（親代理店名）");
        exStringEquals(atukaisyaMap.get("12"), "000007", "扱者情報キー（募集人コード）");
        exStringEquals(atukaisyaMap.get("13"), "0000000000006", "扱者情報キー（募集人登録番号）");
        exStringEquals(atukaisyaMap.get("14"), "募集人名", "扱者情報キー（募集人名）");

        exStringEquals(atukaisyaMap2.get("01"), "2", "扱者情報キー（連番）");
        exStringEquals(atukaisyaMap2.get("04"), "0008", "扱者情報キー（金融機関コード）");
        exStringEquals(atukaisyaMap2.get("05"), "0009", "扱者情報キー（金融機関支店コード）");
        exStringEquals(atukaisyaMap2.get("06"), "0000010", "扱者情報キー（代理店支店コード）");
        exStringEquals(atukaisyaMap2.get("07"), "", "扱者情報キー（代理店名）");
        exStringEquals(atukaisyaMap2.get("08"), "0000011", "扱者情報キー（取扱代理店コード）");
        exStringEquals(atukaisyaMap2.get("09"), "取扱代理店名", "扱者情報キー（取扱代理店名）");
        exStringEquals(atukaisyaMap2.get("10"), "0000012", "扱者情報キー（親代理店コード）");
        exStringEquals(atukaisyaMap2.get("11"), "親代理店名", "扱者情報キー（親代理店名）");
        exStringEquals(atukaisyaMap2.get("12"), "000014", "扱者情報キー（募集人コード）");
        exStringEquals(atukaisyaMap2.get("13"), "0000000000013", "扱者情報キー（募集人登録番号）");
        exStringEquals(atukaisyaMap2.get("14"), "募集人名", "扱者情報キー（募集人名）");

        exStringEquals(atukaisyaMap3.get("01"), "3", "扱者情報キー（連番）");
        exStringEquals(atukaisyaMap3.get("04"), "0015", "扱者情報キー（金融機関コード）");
        exStringEquals(atukaisyaMap3.get("05"), "0016", "扱者情報キー（金融機関支店コード）");
        exStringEquals(atukaisyaMap3.get("06"), "0000017", "扱者情報キー（代理店支店コード）");
        exStringEquals(atukaisyaMap3.get("07"), "", "扱者情報キー（代理店名）");
        exStringEquals(atukaisyaMap3.get("08"), "0000018", "扱者情報キー（取扱代理店コード）");
        exStringEquals(atukaisyaMap3.get("09"), "取扱代理店名", "扱者情報キー（取扱代理店名）");
        exStringEquals(atukaisyaMap3.get("10"), "0000019", "扱者情報キー（親代理店コード）");
        exStringEquals(atukaisyaMap3.get("11"), "親代理店名", "扱者情報キー（親代理店名）");
        exStringEquals(atukaisyaMap3.get("12"), "000021", "扱者情報キー（募集人コード）");
        exStringEquals(atukaisyaMap3.get("13"), "0000000000020", "扱者情報キー（募集人登録番号）");
        exStringEquals(atukaisyaMap3.get("14"), "募集人名", "扱者情報キー（募集人名）");

    }

}