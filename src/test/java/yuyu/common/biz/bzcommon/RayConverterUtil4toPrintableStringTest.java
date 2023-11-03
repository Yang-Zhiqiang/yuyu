package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
import static yuyu.def.YuyuStandardCharsets.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.report.TestBeanObject;
import yuyu.def.report.TestReport2Bean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.infr.report.swakreport.SyoruiZokusei;
import yuyu.infr.report.swakreport.SyoruiZokuseiReader;

/**
 *
 */
@RunWith(SWAKTestRunner.class)
public class RayConverterUtil4toPrintableStringTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private AS_Kinou asKinou;

    @Inject
    private static SyoruiZokuseiReader syoruiZokuseiReader;

    private static Map<String, SyoruiZokusei> zokuseiMap;

    private static SyoruiZokusei zokusei;

    @BeforeClass
    public static void beforeTest(){
        zokuseiMap = syoruiZokuseiReader.read();

        zokusei = zokuseiMap.get(C_SyoruiCdKbn.USERITIRANHYOU.getValue());
    }

    @Test
    public void testNull(){
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd(null);

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals(null,afterBean.getSosikiCd());

    }

    @Test
    public void testBlank(){
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd("");

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals("",afterBean.getSosikiCd());
    }

    @Test
    public void testMark(){
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd("、。／");

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals("、。／",afterBean.getSosikiCd());
    }

    @Test
    public void test1Suijun(){
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd("あア亜");

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals("あア亜",afterBean.getSosikiCd());
    }

    @Test
    public void test2Suijun(){
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd("弌冲勹");

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals("弌冲勹",afterBean.getSosikiCd());
    }

    @Test
    public void test3Suijun(){
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd("丨侊冝");

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals("丨侊冝",afterBean.getSosikiCd());
    }

    @Test
    public void test4Suijun(){
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd("伀侒侚");

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals("伀侒侚",afterBean.getSosikiCd());
    }

    @Test
    public void testSingleByte(){
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd("ｱA¥");

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals("ｱA¥",afterBean.getSosikiCd());
    }

    @Test
    public void testGaiji(){
        byte[] b = {(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x50,(byte)0xF0,(byte)0x8F};
        String beforeConvStr = new String(b,WINDOWS_31J);
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd(beforeConvStr);

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals("養挂窪",afterBean.getSosikiCd());
    }

    @Test
    public void testGaijiZenpou(){
        byte[] b = {(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x50,(byte)0xF0,(byte)0x8F};
        String beforeConvStr = new String(b,WINDOWS_31J) + "あ";
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd(beforeConvStr);

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals("養挂窪あ",afterBean.getSosikiCd());
    }

    @Test
    public void testGaijiBubun(){
        byte[] b = {(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x50,(byte)0xF0,(byte)0x8F};
        String beforeConvStr = "あ" + new String(b,WINDOWS_31J) + "あ";
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd(beforeConvStr);

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals("あ養挂窪あ",afterBean.getSosikiCd());
    }

    @Test
    public void testGaijiKouhou(){
        byte[] b = {(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x50,(byte)0xF0,(byte)0x8F};
        String beforeConvStr = "あ" + new String(b,WINDOWS_31J);
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd(beforeConvStr);

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals("あ養挂窪",afterBean.getSosikiCd());
    }

    @Test
    public void testGaijiBean(){
        byte[] b = {(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x50,(byte)0xF0,(byte)0x8F};
        String beforeConvStr = new String(b,WINDOWS_31J);
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd(beforeConvStr);
        pBean.setSikutyousonNmKj(beforeConvStr);
        pBean.setSikutyousonCd(beforeConvStr);

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals("養挂窪",afterBean.getSosikiCd());
        assertEquals("養挂窪",afterBean.getSikutyousonNmKj());
        assertEquals("養挂窪",afterBean.getSikutyousonCd());
    }


    @Test
    public void testGaijiBean2(){
        byte[] b = {(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x50,(byte)0xF0,(byte)0x8F};
        String beforeConvStr = new String(b,WINDOWS_31J);
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd(beforeConvStr);
        pBean.setSikutyousonNmKj("あいう");
        pBean.setSikutyousonCd(beforeConvStr);

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals("養挂窪",afterBean.getSosikiCd());
        assertEquals("あいう",afterBean.getSikutyousonNmKj());
        assertEquals("養挂窪",afterBean.getSikutyousonCd());
    }


    @Test
    public void testGaijiMoura(){
        byte[] b =
        {(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x41,(byte)0xF0,(byte)0x42,(byte)0xF0,(byte)0x43,(byte)0xF0,(byte)0x44,(byte)0xF0,(byte)0x45,
         (byte)0xF0,(byte)0x46,(byte)0xF0,(byte)0x47,(byte)0xF0,(byte)0x48,(byte)0xF0,(byte)0x5F,(byte)0xF0,(byte)0x75,(byte)0xF0,(byte)0x8D,
         (byte)0xF0,(byte)0x6A,(byte)0xF0,(byte)0x8A,(byte)0xF0,(byte)0x6D,(byte)0xF0,(byte)0x82,(byte)0xF0,(byte)0x58,(byte)0xF0,(byte)0x65,
         (byte)0xF0,(byte)0x59,(byte)0xF0,(byte)0x89,(byte)0xF0,(byte)0x70,(byte)0xF0,(byte)0x7A,(byte)0xF0,(byte)0x8B,(byte)0xF0,(byte)0x5B,
         (byte)0xF0,(byte)0x61,(byte)0xF0,(byte)0x69,(byte)0xF0,(byte)0x7C,(byte)0xF0,(byte)0x4C,(byte)0xF0,(byte)0x83,(byte)0xF0,(byte)0x80,
         (byte)0xF0,(byte)0x5A,(byte)0xF0,(byte)0x52,(byte)0xF0,(byte)0x4D,(byte)0xF0,(byte)0x88,(byte)0xF0,(byte)0x86,(byte)0xF0,(byte)0x63,
         (byte)0xF0,(byte)0x7D,(byte)0xF0,(byte)0x7B,(byte)0xF0,(byte)0x62,(byte)0xF0,(byte)0x5D,(byte)0xF0,(byte)0x73,(byte)0xF0,(byte)0x4E,
         (byte)0xF0,(byte)0x4F,(byte)0xF0,(byte)0x4A,(byte)0xF0,(byte)0x78,(byte)0xF0,(byte)0x50,(byte)0xF0,(byte)0x71,(byte)0xF0,(byte)0x49,
         (byte)0xF0,(byte)0x6E,(byte)0xF0,(byte)0x68,(byte)0xF0,(byte)0x5E,(byte)0xF0,(byte)0x55,(byte)0xF0,(byte)0x53,(byte)0xF0,(byte)0x87,
         (byte)0xF0,(byte)0x7E,(byte)0xF0,(byte)0x56,(byte)0xF0,(byte)0x6B,(byte)0xF0,(byte)0x6C,(byte)0xF0,(byte)0x5C,(byte)0xF0,(byte)0x54,
         (byte)0xF0,(byte)0x51,(byte)0xF0,(byte)0x72,(byte)0xF0,(byte)0x64,(byte)0xF0,(byte)0x8F,(byte)0xF0,(byte)0x8E,(byte)0xF0,(byte)0x8C,
         (byte)0xF0,(byte)0x84,(byte)0xF0,(byte)0x77,(byte)0xF0,(byte)0x66,(byte)0xF0,(byte)0x79,(byte)0xF0,(byte)0x81,(byte)0xF0,(byte)0x74,
         (byte)0xF0,(byte)0x6F,(byte)0xF0,(byte)0x60,(byte)0xF0,(byte)0x85,(byte)0xF0,(byte)0x67,(byte)0xF0,(byte)0x4B,(byte)0xF0,(byte)0x76,
         (byte)0xF0,(byte)0x57};

        String beforeConvStr = new String(b,WINDOWS_31J);
        TestReport2Bean pBean = new TestReport2Bean();
        pBean.setSosikiCd(beforeConvStr);

        ReportServicesBean serviceBean = createReportServiceBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestReport2Bean afterBean = (TestReport2Bean)serviceBean.getBeanDataSouceData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue()).get(0);
        assertEquals(
              "養統財ＤＰ分継新任桒"
            + "泰礼初裕真博喜廣吉槙"
            + "批週祥龍甎鑚閭叡藩壽"
            + "鱚管澤牛虫黄填雉滸勤"
            + "洗嗚烏緯堤挂精堰隹柵"
            + "拘其完砲徐希汕辛供筧"
            + "枷赧交窪簾冷密召国帝"
            + "屯草藁刑分乢巳貯邪"
            ,afterBean.getSosikiCd());
    }


    @Test
    public void testNullObject(){
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1(null);

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals(null,afterBean.getItem1());

    }

    @Test
    public void testBlankObject(){
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1("");

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals("",afterBean.getItem1());
    }

    @Test
    public void testMarkObject(){
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1("、。／");

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals("、。／",afterBean.getItem1());
    }

    @Test
    public void test1SuijunObject(){
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1("あア亜");

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals("あア亜",afterBean.getItem1());
    }

    @Test
    public void test2SuijunObject(){
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1("弌冲勹");

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals("弌冲勹",afterBean.getItem1());
    }

    @Test
    public void test3SuijunObject(){
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1("丨侊冝");

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals("丨侊冝",afterBean.getItem1());
    }

    @Test
    public void test4SuijunObject(){
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1("伀侒侚");

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals("伀侒侚",afterBean.getItem1());
    }

    @Test
    public void testSingleByteObject(){
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1("ｱA¥");

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals("ｱA¥",afterBean.getItem1());
    }

    @Test
    public void testGaijiObject(){
        byte[] b = {(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x50,(byte)0xF0,(byte)0x8F};
        String beforeConvStr = new String(b,WINDOWS_31J);
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1(beforeConvStr);

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals("養挂窪",afterBean.getItem1());
    }

    @Test
    public void testGaijiZenpouObject(){
        byte[] b = {(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x50,(byte)0xF0,(byte)0x8F};
        String beforeConvStr = new String(b,WINDOWS_31J) + "あ";
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1(beforeConvStr);

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals("養挂窪あ",afterBean.getItem1());
    }

    @Test
    public void testGaijiBubunObject(){
        byte[] b = {(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x50,(byte)0xF0,(byte)0x8F};
        String beforeConvStr = "あ" + new String(b,WINDOWS_31J) + "あ";
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1(beforeConvStr);

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals("あ養挂窪あ",afterBean.getItem1());
    }

    @Test
    public void testGaijiKouhouObject(){
        byte[] b = {(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x50,(byte)0xF0,(byte)0x8F};
        String beforeConvStr = "あ" + new String(b,WINDOWS_31J);
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1(beforeConvStr);

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals("あ養挂窪",afterBean.getItem1());
    }

    @Test
    public void testGaijiBeanObject(){
        byte[] b = {(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x50,(byte)0xF0,(byte)0x8F};
        String beforeConvStr = new String(b,WINDOWS_31J);
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1(beforeConvStr);
        pBean.setItem2(beforeConvStr);
        pBean.setItem3(beforeConvStr);

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals("養挂窪",afterBean.getItem1());
        assertEquals("養挂窪",afterBean.getItem2());
        assertEquals("養挂窪",afterBean.getItem3());
    }


    @Test
    public void testGaijiBean2Object(){
        byte[] b = {(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x50,(byte)0xF0,(byte)0x8F};
        String beforeConvStr = new String(b,WINDOWS_31J);
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1(beforeConvStr);
        pBean.setItem2("あいう");
        pBean.setItem3(beforeConvStr);

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals("養挂窪",afterBean.getItem1());
        assertEquals("あいう",afterBean.getItem2());
        assertEquals("養挂窪",afterBean.getItem3());
    }


    @Test
    public void testGaijiMouraObject(){
        byte[] b =
        {(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x41,(byte)0xF0,(byte)0x42,(byte)0xF0,(byte)0x43,(byte)0xF0,(byte)0x44,(byte)0xF0,(byte)0x45,
         (byte)0xF0,(byte)0x46,(byte)0xF0,(byte)0x47,(byte)0xF0,(byte)0x48,(byte)0xF0,(byte)0x5F,(byte)0xF0,(byte)0x75,(byte)0xF0,(byte)0x8D,
         (byte)0xF0,(byte)0x6A,(byte)0xF0,(byte)0x8A,(byte)0xF0,(byte)0x6D,(byte)0xF0,(byte)0x82,(byte)0xF0,(byte)0x58,(byte)0xF0,(byte)0x65,
         (byte)0xF0,(byte)0x59,(byte)0xF0,(byte)0x89,(byte)0xF0,(byte)0x70,(byte)0xF0,(byte)0x7A,(byte)0xF0,(byte)0x8B,(byte)0xF0,(byte)0x5B,
         (byte)0xF0,(byte)0x61,(byte)0xF0,(byte)0x69,(byte)0xF0,(byte)0x7C,(byte)0xF0,(byte)0x4C,(byte)0xF0,(byte)0x83,(byte)0xF0,(byte)0x80,
         (byte)0xF0,(byte)0x5A,(byte)0xF0,(byte)0x52,(byte)0xF0,(byte)0x4D,(byte)0xF0,(byte)0x88,(byte)0xF0,(byte)0x86,(byte)0xF0,(byte)0x63,
         (byte)0xF0,(byte)0x7D,(byte)0xF0,(byte)0x7B,(byte)0xF0,(byte)0x62,(byte)0xF0,(byte)0x5D,(byte)0xF0,(byte)0x73,(byte)0xF0,(byte)0x4E,
         (byte)0xF0,(byte)0x4F,(byte)0xF0,(byte)0x4A,(byte)0xF0,(byte)0x78,(byte)0xF0,(byte)0x50,(byte)0xF0,(byte)0x71,(byte)0xF0,(byte)0x49,
         (byte)0xF0,(byte)0x6E,(byte)0xF0,(byte)0x68,(byte)0xF0,(byte)0x5E,(byte)0xF0,(byte)0x55,(byte)0xF0,(byte)0x53,(byte)0xF0,(byte)0x87,
         (byte)0xF0,(byte)0x7E,(byte)0xF0,(byte)0x56,(byte)0xF0,(byte)0x6B,(byte)0xF0,(byte)0x6C,(byte)0xF0,(byte)0x5C,(byte)0xF0,(byte)0x54,
         (byte)0xF0,(byte)0x51,(byte)0xF0,(byte)0x72,(byte)0xF0,(byte)0x64,(byte)0xF0,(byte)0x8F,(byte)0xF0,(byte)0x8E,(byte)0xF0,(byte)0x8C,
         (byte)0xF0,(byte)0x84,(byte)0xF0,(byte)0x77,(byte)0xF0,(byte)0x66,(byte)0xF0,(byte)0x79,(byte)0xF0,(byte)0x81,(byte)0xF0,(byte)0x74,
         (byte)0xF0,(byte)0x6F,(byte)0xF0,(byte)0x60,(byte)0xF0,(byte)0x85,(byte)0xF0,(byte)0x67,(byte)0xF0,(byte)0x4B,(byte)0xF0,(byte)0x76,
         (byte)0xF0,(byte)0x57};

        String beforeConvStr = new String(b,WINDOWS_31J);
        TestBeanObject pBean = new TestBeanObject();
        pBean.setItem1(beforeConvStr);

        ReportServicesBean serviceBean = createParamaObjectBean(pBean);

        RayConvertUtil.toPrintableString(serviceBean);

        TestBeanObject afterBean = (TestBeanObject)serviceBean.getParamObjectsData().get(C_SyoruiCdKbn.USERITIRANHYOU.getValue())[0];
        assertEquals(
              "養統財ＤＰ分継新任桒"
            + "泰礼初裕真博喜廣吉槙"
            + "批週祥龍甎鑚閭叡藩壽"
            + "鱚管澤牛虫黄填雉滸勤"
            + "洗嗚烏緯堤挂精堰隹柵"
            + "拘其完砲徐希汕辛供筧"
            + "枷赧交窪簾冷密召国帝"
            + "屯草藁刑分乢巳貯邪"
            ,afterBean.getItem1());
    }

    private ReportServicesBean createReportServiceBean(TestReport2Bean pBean) {
        List<IReportDataSouceBean> rdsBeanList = new ArrayList<IReportDataSouceBean>();
        rdsBeanList.add(pBean);

        ReportServicesBean serviceBean = createReport.createNewReportServiceBean(asKinou.getSubSystemId(), asKinou.getCategoryId(), asKinou.getKinouId(), zokusei.getSyoruiCdKbn());
        serviceBean.addParamObjects(rdsBeanList);
        return serviceBean;
    }

    private ReportServicesBean createParamaObjectBean(TestBeanObject pBean){
        ReportServicesBean serviceBean = createReport.createNewReportServiceBean(asKinou.getSubSystemId(), asKinou.getCategoryId(), asKinou.getKinouId(), zokusei.getSyoruiCdKbn());
        serviceBean.addParamObjects(pBean);
        return serviceBean;
    }

}
