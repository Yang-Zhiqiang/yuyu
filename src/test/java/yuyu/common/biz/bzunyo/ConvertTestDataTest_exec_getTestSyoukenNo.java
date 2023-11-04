package yuyu.common.biz.bzunyo;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_TestSyonokanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * テストデータ変換クラス<br />
 * getBikinIdouMeisaisByBknjkukbnBknrigikbnKessankijyunymd() メソッドのテストクラス<br />
 */
@RunWith(OrderedRunner.class)

public class ConvertTestDataTest_exec_getTestSyoukenNo{

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private ConvertTestData convertTestData;

    @Inject
    BM_TestSyonokanri bmTestSyonokanri = new BM_TestSyonokanri();

    @Inject
    ConvertTestDataOutBean convertTestDataOutBean1 = new ConvertTestDataOutBean();

    @Test
    @TestOrder(10)
    @Transactional
    public void test1(){

        BM_TestSyonokanri bmTestSyonokanri0 = new BM_TestSyonokanri("17","808",1950);
        bizDomManager.insert(bmTestSyonokanri0);

        convertTestDataOutBean1 = convertTestData.getTestSyoukenNo("860000017", "808", "56510405");
        assertEquals("17808019516",convertTestDataOutBean1.getTestSyono());
        assertEquals("01",convertTestDataOutBean1.getKbnKey());

        List<BM_TestSyonokanri> testSyonokanriLst = bizDomManager.getAllTestSyonokanri();
        for (BM_TestSyonokanri testSyonokanri : testSyonokanriLst) {
            if (testSyonokanri.getSeirekinen2keta().equals("17") &&
                testSyonokanri.getBosyuusosikicd().equals("808")) {
                bizDomManager.delete(testSyonokanri);
            }
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void test2(){

        BM_TestSyonokanri bmTestSyonokanri1 = new BM_TestSyonokanri("17","808",1563);
        bizDomManager.insert(bmTestSyonokanri1);

        convertTestDataOutBean1 = convertTestData.getTestSyoukenNo("860000017", "808", "56510405");
        assertEquals("17808015659",convertTestDataOutBean1.getTestSyono());
        assertEquals("05",convertTestDataOutBean1.getKbnKey());

        List<BM_TestSyonokanri> testSyonokanriLst = bizDomManager.getAllTestSyonokanri();
        for (BM_TestSyonokanri testSyonokanri : testSyonokanriLst) {
            if (testSyonokanri.getSeirekinen2keta().equals("17") &&
                testSyonokanri.getBosyuusosikicd().equals("808")) {
                bizDomManager.delete(testSyonokanri);
            }
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void test3(){

        BM_TestSyonokanri bmTestSyonokanri2 = new BM_TestSyonokanri("17","808",0);
        bizDomManager.insert(bmTestSyonokanri2);

        convertTestDataOutBean1 = convertTestData.getTestSyoukenNo("860000017", "808", "56510405");
        assertEquals("17808000019",convertTestDataOutBean1.getTestSyono());
        assertEquals("01",convertTestDataOutBean1.getKbnKey());

        List<BM_TestSyonokanri> testSyonokanriLst = bizDomManager.getAllTestSyonokanri();
        for (BM_TestSyonokanri testSyonokanri : testSyonokanriLst) {
            if (testSyonokanri.getSeirekinen2keta().equals("17") &&
                testSyonokanri.getBosyuusosikicd().equals("808")) {
                bizDomManager.delete(testSyonokanri);
            }
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void test4(){

        convertTestDataOutBean1 = convertTestData.getTestSyoukenNo("860000017", "808", "56510405");
        assertEquals("17808000019",convertTestDataOutBean1.getTestSyono());
        assertEquals("01",convertTestDataOutBean1.getKbnKey());

        List<BM_TestSyonokanri> testSyonokanriLst = bizDomManager.getAllTestSyonokanri();
        for (BM_TestSyonokanri testSyonokanri : testSyonokanriLst) {
            if (testSyonokanri.getSeirekinen2keta().equals("17") &&
                testSyonokanri.getBosyuusosikicd().equals("808")) {
                bizDomManager.delete(testSyonokanri);
            }
        }
    }
}