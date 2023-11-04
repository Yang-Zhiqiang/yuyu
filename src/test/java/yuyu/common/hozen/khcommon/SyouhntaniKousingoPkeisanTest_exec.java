package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 商品単位更新後保険料計算クラスのメソッド {@link SyouhntaniKousingoPkeisan#exec()} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhntaniKousingoPkeisanTest_exec {

    @Inject
    private SyouhntaniKousingoPkeisan syouhntaniKousingoPkeisan;

    private final static String fileName = "UT_SP_単体テスト仕様書_商品単位更新後保険料計算";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SyouhntaniKousingoPkeisanTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        syouhntaniKousingoPkeisan.setSyouhncd("T110");
        syouhntaniKousingoPkeisan.setSyouhnSdno(4);
        syouhntaniKousingoPkeisan.setKatakbn(C_KataKbn.BLNK);
        syouhntaniKousingoPkeisan.setKyhgndKatakbn(C_KyhgndkataKbn.BLNK);
        syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(C_SyukyhkinkataKbn.BLNK);
        syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(C_KhnkyhkgbairituKbn.BLNK);
        syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(C_6daiLdKbn.BLNK);
        syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(C_PmnjtkKbn.NONE);
        syouhntaniKousingoPkeisan.setHrkkknSmnkbn(C_HrkkknsmnKbn.BLNK);
        syouhntaniKousingoPkeisan.setHhknSei(C_Hhknsei.BLNK);
        syouhntaniKousingoPkeisan.setHrkKaisuu(C_Hrkkaisuu.BLNK);
        syouhntaniKousingoPkeisan.setHrkKeiro(C_Hrkkeiro.BLNK);
        syouhntaniKousingoPkeisan.setSdPdKbn(C_Sdpd.BLNK);
        syouhntaniKousingoPkeisan.setS(BizCurrency.valueOf(0));

        try {

            syouhntaniKousingoPkeisan.exec();

        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。商品属性MSTにデータが存在しません。", "エラーメッセージ");

            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_B1() {

        syouhntaniKousingoPkeisan.setSyouhncd("M110");
        syouhntaniKousingoPkeisan.setSyouhnSdno(1);

        C_ErrorKbn errorKbn = syouhntaniKousingoPkeisan.exec();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        exNumericEquals(syouhntaniKousingoPkeisan.getKoskaisu(), 0, "更新回数");
        assertNull(syouhntaniKousingoPkeisan.getKosnaiymeiskmk());
    }

    @Test
    @TestOrder(30)
    public void testExec_C1() {

        syouhntaniKousingoPkeisan.setSyouhncd("T110");
        syouhntaniKousingoPkeisan.setSyouhnSdno(1);
        syouhntaniKousingoPkeisan.setHknkknSmnkbn(C_HknkknsmnKbn.SAIMANKI);

        C_ErrorKbn errorKbn = syouhntaniKousingoPkeisan.exec();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(syouhntaniKousingoPkeisan.getKoskaisu(), 0, "更新回数");
        assertNull(syouhntaniKousingoPkeisan.getKosnaiymeiskmk());
    }

    @Test
    @TestOrder(40)
    public void testExec_D1() {

        syouhntaniKousingoPkeisan.setSyouhncd("T110");
        syouhntaniKousingoPkeisan.setSyouhnSdno(1);
        syouhntaniKousingoPkeisan.setHknkknSmnkbn(C_HknkknsmnKbn.NENMANKI);
        syouhntaniKousingoPkeisan.setHhknNen(75);
        syouhntaniKousingoPkeisan.setHknkkn(10);

        C_ErrorKbn errorKbn = syouhntaniKousingoPkeisan.exec();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(syouhntaniKousingoPkeisan.getKoskaisu(), 0, "更新回数");
        assertNull(syouhntaniKousingoPkeisan.getKosnaiymeiskmk());
    }

    @Test
    @TestOrder(50)
    public void testExec_D2() {

        syouhntaniKousingoPkeisan.setSyouhncd("T110");
        syouhntaniKousingoPkeisan.setSyouhnSdno(1);
        syouhntaniKousingoPkeisan.setHknkknSmnkbn(C_HknkknsmnKbn.NENMANKI);
        syouhntaniKousingoPkeisan.setHhknNen(75);
        syouhntaniKousingoPkeisan.setHknkkn(5);

        C_ErrorKbn errorKbn = syouhntaniKousingoPkeisan.exec();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(syouhntaniKousingoPkeisan.getKoskaisu(), 0, "更新回数");
        assertNull(syouhntaniKousingoPkeisan.getKosnaiymeiskmk());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(60)
    public void testExec_D3() {

        syouhntaniKousingoPkeisan.setSyouhncd("T120");
        syouhntaniKousingoPkeisan.setSyouhnSdno(1);
        syouhntaniKousingoPkeisan.setHknkknSmnkbn(C_HknkknsmnKbn.NENMANKI);
        syouhntaniKousingoPkeisan.setHhknNen(60);
        syouhntaniKousingoPkeisan.setHknkkn(5);
        syouhntaniKousingoPkeisan.setKeiyakubi(BizDate.valueOf("20250701"));

        try {

            syouhntaniKousingoPkeisan.exec();

        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。商品属性MSTにデータが存在しません。", "エラーメッセージ");

            throw e;
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_D4() {

        syouhntaniKousingoPkeisan.setSyouhncd("T110");
        syouhntaniKousingoPkeisan.setSyouhnSdno(1);
        syouhntaniKousingoPkeisan.setHknkknSmnkbn(C_HknkknsmnKbn.NENMANKI);
        syouhntaniKousingoPkeisan.setHhknNen(78);
        syouhntaniKousingoPkeisan.setHknkkn(1);
        syouhntaniKousingoPkeisan.setKeiyakubi(BizDate.valueOf("20150701"));
        syouhntaniKousingoPkeisan.setHrkkkn(0);

        C_ErrorKbn errorKbn = syouhntaniKousingoPkeisan.exec();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(syouhntaniKousingoPkeisan.getKoskaisu(), 1, "更新回数");
        KousinBean[] kosnaiyMeisKmks = syouhntaniKousingoPkeisan.getKosnaiymeiskmk();

        exDateEquals(kosnaiyMeisKmks[0].getKoushinbi(), BizDate.valueOf("20160701"), "更新日");
        exBizCalcbleEquals(kosnaiyMeisKmks[0].getHknry(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(kosnaiyMeisKmks[0].getSyouhncd(), "T110", "商品コード");
        exNumericEquals(kosnaiyMeisKmks[0].getSyouhnSdno(), 1, "商品世代番号");
        exNumericEquals(kosnaiyMeisKmks[0].getHknkkn(), 1, "保険期間");
        exNumericEquals(kosnaiyMeisKmks[0].getHrkkkn(), 0, "払込期間");
        exNumericEquals(kosnaiyMeisKmks[0].getHhknNen(), 79, "被保険者年齢");
    }

    @Test
    @TestOrder(80)
    public void testExec_D5() {

        syouhntaniKousingoPkeisan.setSyouhncd("T110");
        syouhntaniKousingoPkeisan.setSyouhnSdno(1);
        syouhntaniKousingoPkeisan.setHknkknSmnkbn(C_HknkknsmnKbn.NENMANKI);
        syouhntaniKousingoPkeisan.setHhknNen(77);
        syouhntaniKousingoPkeisan.setHknkkn(2);
        syouhntaniKousingoPkeisan.setKeiyakubi(BizDate.valueOf("20150701"));
        syouhntaniKousingoPkeisan.setHrkkkn(0);

        C_ErrorKbn errorKbn = syouhntaniKousingoPkeisan.exec();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(syouhntaniKousingoPkeisan.getKoskaisu(), 1, "更新回数");
        KousinBean[] kosnaiyMeisKmks = syouhntaniKousingoPkeisan.getKosnaiymeiskmk();

        exDateEquals(kosnaiyMeisKmks[0].getKoushinbi(), BizDate.valueOf("20170701"), "更新日");
        exBizCalcbleEquals(kosnaiyMeisKmks[0].getHknry(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(kosnaiyMeisKmks[0].getSyouhncd(), "T110", "商品コード");
        exNumericEquals(kosnaiyMeisKmks[0].getSyouhnSdno(), 1, "商品世代番号");
        exNumericEquals(kosnaiyMeisKmks[0].getHknkkn(), 1, "保険期間");
        exNumericEquals(kosnaiyMeisKmks[0].getHrkkkn(), 1, "払込期間");
        exNumericEquals(kosnaiyMeisKmks[0].getHhknNen(), 79, "被保険者年齢");
    }

    @Test
    @TestOrder(90)
    public void testExec_D6() {

        syouhntaniKousingoPkeisan.setSyouhncd("T110");
        syouhntaniKousingoPkeisan.setSyouhnSdno(1);
        syouhntaniKousingoPkeisan.setHknkknSmnkbn(C_HknkknsmnKbn.NENMANKI);
        syouhntaniKousingoPkeisan.setHhknNen(72);
        syouhntaniKousingoPkeisan.setHknkkn(2);
        syouhntaniKousingoPkeisan.setKeiyakubi(BizDate.valueOf("20150701"));
        syouhntaniKousingoPkeisan.setHrkkkn(0);

        C_ErrorKbn errorKbn = syouhntaniKousingoPkeisan.exec();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(syouhntaniKousingoPkeisan.getKoskaisu(), 3, "更新回数");
        KousinBean[] kosnaiyMeisKmks = syouhntaniKousingoPkeisan.getKosnaiymeiskmk();

        exDateEquals(kosnaiyMeisKmks[0].getKoushinbi(), BizDate.valueOf("20170701"), "更新日");
        exBizCalcbleEquals(kosnaiyMeisKmks[0].getHknry(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(kosnaiyMeisKmks[0].getSyouhncd(), "T110", "商品コード");
        exNumericEquals(kosnaiyMeisKmks[0].getSyouhnSdno(), 1, "商品世代番号");
        exNumericEquals(kosnaiyMeisKmks[0].getHknkkn(), 2, "保険期間");
        exNumericEquals(kosnaiyMeisKmks[0].getHrkkkn(), 0, "払込期間");
        exNumericEquals(kosnaiyMeisKmks[0].getHhknNen(), 74, "被保険者年齢");

        exDateEquals(kosnaiyMeisKmks[1].getKoushinbi(), BizDate.valueOf("20190701"), "更新日");
        exBizCalcbleEquals(kosnaiyMeisKmks[1].getHknry(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(kosnaiyMeisKmks[1].getSyouhncd(), "T110", "商品コード");
        exNumericEquals(kosnaiyMeisKmks[1].getSyouhnSdno(), 2, "商品世代番号");
        exNumericEquals(kosnaiyMeisKmks[1].getHknkkn(), 2, "保険期間");
        exNumericEquals(kosnaiyMeisKmks[1].getHrkkkn(), 0, "払込期間");
        exNumericEquals(kosnaiyMeisKmks[1].getHhknNen(), 76, "被保険者年齢");

        exDateEquals(kosnaiyMeisKmks[2].getKoushinbi(), BizDate.valueOf("20210701"), "更新日");
        exBizCalcbleEquals(kosnaiyMeisKmks[2].getHknry(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(kosnaiyMeisKmks[2].getSyouhncd(), "T110", "商品コード");
        exNumericEquals(kosnaiyMeisKmks[2].getSyouhnSdno(), 3, "商品世代番号");
        exNumericEquals(kosnaiyMeisKmks[2].getHknkkn(), 2, "保険期間");
        exNumericEquals(kosnaiyMeisKmks[2].getHrkkkn(), 0, "払込期間");
        exNumericEquals(kosnaiyMeisKmks[2].getHhknNen(), 78, "被保険者年齢");
    }
}