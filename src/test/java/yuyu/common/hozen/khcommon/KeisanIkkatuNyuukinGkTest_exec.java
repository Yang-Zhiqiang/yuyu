package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * KeisanIkkatuNyuukinGkクラスのメソッド {@link KeisanIkkatuNyuukinGk#exec(String,BizDate,BizDateYM,Integer)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanIkkatuNyuukinGkTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_一括入金額計算";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanIkkatuWaribikiP.class).to(KeisanIkkatuWaribikiPMockForKhansyuu.class);
                bind(KeisanIkkatuWaribikiKikan.class).to(KeisanIkkatuWaribikiKikanMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanIkkatuWaribikiPMockForKhansyuu.caller = KeisanIkkatuNyuukinGkTest_exec.class;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.caller = KeisanIkkatuNyuukinGkTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        KeisanIkkatuWaribikiPMockForKhansyuu.caller = null;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.caller = null;
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = null;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = null;

        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanIkkatuNyuukinGkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1001");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("0");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(0));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(0);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        boolean pIktwaribikifuyouFlg = false;

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
    }
    @Test
    @TestOrder(20)
    public void testExec_A2() {
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1001");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("001");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(1);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        boolean pIktwaribikifuyouFlg = true;

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(100), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(100), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),1, "割引適用期間外月数");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN1;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(2);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        boolean pIktwaribikifuyouFlg = false;

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);

        String syouhnCd = (String)MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 0);
        exStringEquals(syouhnCd, "1003", "商品コード");

        String ryouritusdNo = (String) MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 1);
        exStringEquals(ryouritusdNo, "003", "料率世代番号");

        C_Hrkkaisuu hrkkaisuu = (C_Hrkkaisuu) MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 2);
        exClassificationEquals(hrkkaisuu, C_Hrkkaisuu.TUKI, "払込回数");

        int keikamon = (int) MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 3);
        exNumericEquals(keikamon, 2, "一括月数");

        BizCurrency hokenryou = (BizCurrency) MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 4);
        exBizCalcbleEquals(hokenryou, BizCurrency.valueOf(100), "割引前保険料");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 2, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1004");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("004");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(6);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);
        boolean pIktwaribikifuyouFlg = false;

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(600), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(600), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),6, "割引適用期間外月数");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN3;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("3005");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("005");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1005");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("005");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(7);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        boolean pIktwaribikifuyouFlg = false;

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(1400), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(1400), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 7, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN5;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1006");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("006");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1006");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(2);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("006");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(11);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);
        boolean pIktwaribikifuyouFlg = false;

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(2200), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(1100), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(2200), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 11, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN4;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1007");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("007");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        boolean pIktwaribikifuyouFlg = false;

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(1000), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(1000), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(1000), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 12, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1008");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("008");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(0));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(13);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        boolean pIktwaribikifuyouFlg = false;

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN1;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(2);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
        boolean pIktwaribikifuyouFlg = false;

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 2, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
    }

    @Test
    @TestOrder(95)
    public void testExec_A10() {

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(2);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        boolean pIktwaribikifuyouFlg = true;

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(2400), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(2400), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),12, "割引適用期間外月数");
    }


    @Test
    @TestOrder(100)
    public void testExec_B1() {

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1001");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("0");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(0));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(0);

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180101"),BizDateYM.valueOf("201805"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
    }
    @Test
    @TestOrder(110)
    public void testExec_B2() {

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1001");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("0");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(0));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(13);

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180101"),BizDateYM.valueOf("201805"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
    }

    @Test
    @TestOrder(120)
    public void testExec_B3() {

        MockObjectManager.initialize();
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(1);

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201804"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(100), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(100), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),1, "割引適用期間外月数");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanIkkatuWaribikiKikanMockForKhansyuu.class,
            "exec", 0, 0), BizDate.valueOf("20180801"), "領収日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanIkkatuWaribikiKikanMockForKhansyuu.class,
            "exec", 0, 1), BizDateYM.valueOf(201804), "充当年月");
        exNumericEquals((Integer)MockObjectManager.getArgument(KeisanIkkatuWaribikiKikanMockForKhansyuu.class,
            "exec", 0, 2), 1, "充当月数");
    }

    @Test
    @TestOrder(130)
    public void testExec_B4() {

        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2004");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("004");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(1);

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201805"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(100), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(100), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),1, "割引適用期間外月数");
    }

    @Test
    @TestOrder(140)
    public void testExec_B5() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN3;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2005");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("005");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(2);

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201805"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(200), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(100), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(100), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 1, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),1, "割引適用期間外月数");
    }


    @Test
    @TestOrder(150)
    public void testExec_B6() {

        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2005");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(3);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("005");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(1);

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201805"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(100), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(100), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),1, "割引適用期間外月数");
    }

    @Test
    @TestOrder(160)
    public void testExec_B7() {

        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN4;
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN1;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2006");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("006");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(6);

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201806"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 6, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
    }

    @Test
    @TestOrder(170)
    public void testExec_B8() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN5;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN5;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2007");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("007");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(11);

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201806"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(1100), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(1100), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(1100), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 11, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
    }

    @Test
    @TestOrder(180)
    public void testExec_B9() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN4;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN6;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2008");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("008");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201807"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(1000), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(1000), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(1000), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 12, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
    }

    @Test
    @TestOrder(190)
    public void testExec_B10() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN6;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN7;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2009");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("009");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(1000));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2009");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(2);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("009");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(1000));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2009");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(3);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("009");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(1000));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2009");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(4);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("009");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(1000));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2009");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(5);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("009");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(1000));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);

        KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180901"),BizDateYM.valueOf("201805"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(52004), "一括入金額");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(804), "一括割引料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(42004), "割引適用期間保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(10000), "割引適用期間外保険料");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyokkntksu(), 10, "割引適用期間月数");
        exNumericEquals(keisanIkkatuNyuukinGk.getWrbktkyukkngitksu(),2, "割引適用期間外月数");
    }
}