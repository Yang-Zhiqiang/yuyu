package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 契約内容登録制度照会票PDF作成クラスのメソッド {@link EditPdfKyknaiyoutrseidoskhy#exec(HT_SyoriCTL, String, List<Integer>)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)

public class EditPdfKyknaiyoutrseidoskhyTest_exec {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;
    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約内容登録制度照会票PDF作成";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditPdfKyknaiyoutrseidoskhyTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        bizDomManager.delete(bizDomManager.getAllLincKaisyacd());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("790000012");
        String lincjyusintrrenno ="1000010001";
        List<Integer> rennoList= new ArrayList<Integer>();
        rennoList.add(1);
        EditPdfKyknaiyoutrseidoskhy editPdfKyknaiyoutrseidoskhy = SWAKInjector.getInstance(EditPdfKyknaiyoutrseidoskhy.class);
        List<String> tyouhyoukeyLst = editPdfKyknaiyoutrseidoskhy.exec(syoriCTL, lincjyusintrrenno, rennoList);
        exNumericEquals(tyouhyoukeyLst.size(), 0, "帳票キーリストの件数");


    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        String lincjyusintrrenno ="1000010001";
        List<Integer> rennoList= new ArrayList<Integer>();
        EditPdfKyknaiyoutrseidoskhy editPdfKyknaiyoutrseidoskhy = SWAKInjector.getInstance(EditPdfKyknaiyoutrseidoskhy.class);
        List<String> tyouhyoukeyLst = editPdfKyknaiyoutrseidoskhy.exec(syoriCTL, lincjyusintrrenno, rennoList);
        exNumericEquals(tyouhyoukeyLst.size(), 0, "帳票キーリストの件数");


    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        String lincjyusintrrenno ="1000010000";
        List<Integer> rennoList= new ArrayList<Integer>();
        rennoList.add(1);
        EditPdfKyknaiyoutrseidoskhy editPdfKyknaiyoutrseidoskhy = SWAKInjector.getInstance(EditPdfKyknaiyoutrseidoskhy.class);
        try{
            editPdfKyknaiyoutrseidoskhy.exec(syoriCTL, lincjyusintrrenno, rennoList);
        }catch(CommonBizAppException e){
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号＝860000017", "エラーメッセージ");
            throw e;
        }

    }

    @Transactional
    @Test
    @TestOrder(40)
    public void testExec_A4() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        String lincjyusintrrenno ="1000010001";
        List<Integer> rennoList= new ArrayList<Integer>();
        rennoList.add(1);
        EditPdfKyknaiyoutrseidoskhy editPdfKyknaiyoutrseidoskhy = SWAKInjector.getInstance(EditPdfKyknaiyoutrseidoskhy.class);
        List<String> tyouhyoukeyLst = editPdfKyknaiyoutrseidoskhy.exec(syoriCTL, lincjyusintrrenno, rennoList);

        exNumericEquals(tyouhyoukeyLst.size(), 1, "帳票キーリストの件数");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(50)
    public void testExec_A5() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        String lincjyusintrrenno ="1000010001";
        List<Integer> rennoList= new ArrayList<Integer>();
        rennoList.add(2);
        EditPdfKyknaiyoutrseidoskhy editPdfKyknaiyoutrseidoskhy = SWAKInjector.getInstance(EditPdfKyknaiyoutrseidoskhy.class);
        try{

            editPdfKyknaiyoutrseidoskhy.exec(syoriCTL, lincjyusintrrenno, rennoList);

        }catch(CommonBizAppException e){
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号＝860000025", "エラーメッセージ");
            throw e;
        }

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(60)
    public void testExec_A6() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        String lincjyusintrrenno ="1000010001";
        List<Integer> rennoList= new ArrayList<Integer>();
        rennoList.add(3);
        EditPdfKyknaiyoutrseidoskhy editPdfKyknaiyoutrseidoskhy = SWAKInjector.getInstance(EditPdfKyknaiyoutrseidoskhy.class);
        try{

            editPdfKyknaiyoutrseidoskhy.exec(syoriCTL, lincjyusintrrenno, rennoList);

        }catch(CommonBizAppException e){
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号＝860000033", "エラーメッセージ");
            throw e;
        }

    }

    @Transactional
    @Test
    @TestOrder(70)
    public void testExec_A7() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        String lincjyusintrrenno ="1000010001";
        List<Integer> rennoList= new ArrayList<Integer>();
        rennoList.add(4);
        rennoList.add(5);
        rennoList.add(6);
        EditPdfKyknaiyoutrseidoskhy editPdfKyknaiyoutrseidoskhy = SWAKInjector.getInstance(EditPdfKyknaiyoutrseidoskhy.class);
        List<String> tyouhyoukeyLst = editPdfKyknaiyoutrseidoskhy.exec(syoriCTL, lincjyusintrrenno, rennoList);
        exNumericEquals(tyouhyoukeyLst.size(), 3, "帳票キーリストの件数");


    }

    @Transactional
    @Test
    @TestOrder(80)
    public void testExec_A8() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
        String lincjyusintrrenno ="1000010001";
        List<Integer> rennoList= new ArrayList<Integer>();
        rennoList.add(7);
        EditPdfKyknaiyoutrseidoskhy editPdfKyknaiyoutrseidoskhy = SWAKInjector.getInstance(EditPdfKyknaiyoutrseidoskhy.class);
        List<String> tyouhyoukeyLst = editPdfKyknaiyoutrseidoskhy.exec(syoriCTL, lincjyusintrrenno, rennoList);
        exNumericEquals(tyouhyoukeyLst.size(),1, "帳票キーリストの件数");
    }
}

