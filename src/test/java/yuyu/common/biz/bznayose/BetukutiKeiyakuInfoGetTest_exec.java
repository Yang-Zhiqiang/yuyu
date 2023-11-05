package yuyu.common.biz.bznayose;

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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_SysCdKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 別口契約情報取得のメソッド {@link BetukutiKeiyakuInfoGet#exec(BetukutiKeiyakuInfoGetParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BetukutiKeiyakuInfoGetTest_exec extends AbstractTest{

    @Inject
    private BetukutiKeiyakuInfoGet betukutiKeiyakuInfoGet;

    private final static String fileName = "UT-SP_単体テスト仕様書_別口契約情報取得";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BetukutiKeiyakuInfoGetTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzSakuinTsnSyoukaiMq.class).to(BzSakuinTsnSyoukaiMqMockForSiharai.class);
            }
        });
    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @BeforeClass
    public static void testInit(){
        BzSakuinTsnSyoukaiMqMockForSiharai.caller = BetukutiKeiyakuInfoGetTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.caller = null;
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN7;

        BetukutiKeiyakuInfoGetParam param = SWAKInjector.getInstance(BetukutiKeiyakuInfoGetParam.class);
        param.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        param.setHuho2kykno("10000000001");
        param.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);
        BetukutiKeiyakuInfoResultBean result = betukutiKeiyakuInfoGet.exec(param) ;
        exNumericEquals(result.getBetukutiKeiyakuInfoBeanLst().size(), 0, "別口契約情報Beanリストの件数");
        exClassificationEquals(result.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(result.getPalsyoukaijissiumukbn(), C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
        exClassificationEquals(result.getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIOK, "索引情報照会エラー区分");
        exClassificationEquals(result.getKykensuutyoukaumu(), C_BlnktkumuKbn.BLNK, "契約管理件数超過有無区分");
        exClassificationEquals(result.getNkkensuutyoukaumu(), C_BlnktkumuKbn.BLNK, "年金支払件数超過有無区分");
        exClassificationEquals(result.getKykmfkensuutyoukaumu(), C_BlnktkumuKbn.BLNK, "契約ＭＦ件数超過有無区分");
        exClassificationEquals(result.getNkfkensuutyoukaumu(), C_BlnktkumuKbn.BLNK, "年金Ｆ件数超過有無区分");
        exClassificationEquals(result.getSueokifkensuutyoukaumu(), C_BlnktkumuKbn.BLNK, "据置Ｆ件数超過有無区分");
    }

    @Test
    @TestOrder(10)
    public void testExec_A2() {
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN8;

        BetukutiKeiyakuInfoGetParam param = SWAKInjector.getInstance(BetukutiKeiyakuInfoGetParam.class);
        param.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        param.setHuho2kykno("10000000002");
        param.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);
        BetukutiKeiyakuInfoResultBean result = betukutiKeiyakuInfoGet.exec(param) ;
        exNumericEquals(result.getBetukutiKeiyakuInfoBeanLst().size(), 0, "別口契約情報Beanリストの件数");
        exClassificationEquals(result.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(result.getPalsyoukaijissiumukbn(), C_PalSyoukaiJissiumuKbn.NONE, "ＰＡＬあて照会実施有無区分");
        exClassificationEquals(result.getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIOK, "索引情報照会エラー区分");
        exClassificationEquals(result.getKykensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約管理件数超過有無区分");
        exClassificationEquals(result.getNkkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金支払件数超過有無区分");
        exClassificationEquals(result.getKykmfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約ＭＦ件数超過有無区分");
        exClassificationEquals(result.getNkfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金Ｆ件数超過有無区分");
        exClassificationEquals(result.getSueokifkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "据置Ｆ件数超過有無区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN9;

        BetukutiKeiyakuInfoGetParam param = SWAKInjector.getInstance(BetukutiKeiyakuInfoGetParam.class);
        param.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        param.setHuho2kykno("10000000003");
        param.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);
        BetukutiKeiyakuInfoResultBean result = betukutiKeiyakuInfoGet.exec(param) ;
        exNumericEquals(result.getBetukutiKeiyakuInfoBeanLst().size(), 0, "別口契約情報Beanリストの件数");
        exClassificationEquals(result.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(result.getPalsyoukaijissiumukbn(), C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
        exClassificationEquals(result.getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIOK, "索引情報照会エラー区分");
        exClassificationEquals(result.getKykensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約管理件数超過有無区分");
        exClassificationEquals(result.getNkkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金支払件数超過有無区分");
        exClassificationEquals(result.getKykmfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約ＭＦ件数超過有無区分");
        exClassificationEquals(result.getNkfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金Ｆ件数超過有無区分");
        exClassificationEquals(result.getSueokifkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "据置Ｆ件数超過有無区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();

        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN10;

        BetukutiKeiyakuInfoGetParam param = SWAKInjector.getInstance(BetukutiKeiyakuInfoGetParam.class);
        param.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        param.setHuho2kykno("10000000004");
        param.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);
        BetukutiKeiyakuInfoResultBean result = betukutiKeiyakuInfoGet.exec(param) ;
        exNumericEquals(result.getBetukutiKeiyakuInfoBeanLst().size(), 1, "別口契約情報Beanリストの件数");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean = result.getBetukutiKeiyakuInfoBeanLst().get(0);
        exStringEquals(betukutiKeiyakuInfoBean.getBtkyksyono(), "10000000004", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean.getKankeisyakbnname(), "年金受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean.getSyoumetuymd(), BizDate.valueOf(20160128), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean.getSyoumetujiyuuname(), "年金終了", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean.getSyouhnnm(), "入院保険", "商品名");

        exClassificationEquals(result.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(result.getPalsyoukaijissiumukbn(), C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
        exClassificationEquals(result.getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIOK, "索引情報照会エラー区分");
        exClassificationEquals(result.getKykensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約管理件数超過有無区分");
        exClassificationEquals(result.getNkkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金支払件数超過有無区分");
        exClassificationEquals(result.getKykmfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約ＭＦ件数超過有無区分");
        exClassificationEquals(result.getNkfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金Ｆ件数超過有無区分");
        exClassificationEquals(result.getSueokifkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "据置Ｆ件数超過有無区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();

        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN11;

        BetukutiKeiyakuInfoGetParam param = SWAKInjector.getInstance(BetukutiKeiyakuInfoGetParam.class);
        param.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        param.setHuho2kykno("10000000005");
        param.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);
        BetukutiKeiyakuInfoResultBean result = betukutiKeiyakuInfoGet.exec(param) ;
        exNumericEquals(result.getBetukutiKeiyakuInfoBeanLst().size(), 10, "別口契約情報Beanリストの件数");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean0 = result.getBetukutiKeiyakuInfoBeanLst().get(0);
        exStringEquals(betukutiKeiyakuInfoBean0.getBtkyksyono(), "10000000005", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean0.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean0.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean0.getKankeisyakbnname(), "年金受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean0.getSyoumetuymd(), BizDate.valueOf(20160128), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean0.getSyoumetujiyuuname(), "年金終了", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean0.getSyouhnnm(), "入院保険", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean1 = result.getBetukutiKeiyakuInfoBeanLst().get(1);
        exStringEquals(betukutiKeiyakuInfoBean1.getBtkyksyono(), "10000000015", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean1.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean1.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean1.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean1.getSyoumetuymd(), BizDate.valueOf(20160129), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean1.getSyoumetujiyuuname(), "年金終了", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean1.getSyouhnnm(), "長期入院保険", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean2 = result.getBetukutiKeiyakuInfoBeanLst().get(2);
        exStringEquals(betukutiKeiyakuInfoBean2.getBtkyksyono(), "10000000025", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean2.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean2.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean2.getKankeisyakbnname(), "年金受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean2.getSyoumetuymd(), BizDate.valueOf(20160128), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean2.getSyoumetujiyuuname(), "年金終了", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean2.getSyouhnnm(), "入院保険", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean3 = result.getBetukutiKeiyakuInfoBeanLst().get(3);
        exStringEquals(betukutiKeiyakuInfoBean3.getBtkyksyono(), "10000000035", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean3.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean3.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean3.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean3.getSyoumetuymd(), BizDate.valueOf(20160129), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean3.getSyoumetujiyuuname(), "年金終了", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean3.getSyouhnnm(), "長期入院保険", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean4 = result.getBetukutiKeiyakuInfoBeanLst().get(4);
        exStringEquals(betukutiKeiyakuInfoBean4.getBtkyksyono(), "10000000045", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean4.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean4.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean4.getKankeisyakbnname(), "年金受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean4.getSyoumetuymd(), BizDate.valueOf(20160128), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean4.getSyoumetujiyuuname(), "年金終了", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean4.getSyouhnnm(), "入院保険", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean5 = result.getBetukutiKeiyakuInfoBeanLst().get(5);
        exStringEquals(betukutiKeiyakuInfoBean5.getBtkyksyono(), "10000000055", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean5.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean5.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean5.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean5.getSyoumetuymd(), BizDate.valueOf(20160129), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean5.getSyoumetujiyuuname(), "年金終了", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean5.getSyouhnnm(), "長期入院保険", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean6 = result.getBetukutiKeiyakuInfoBeanLst().get(6);
        exStringEquals(betukutiKeiyakuInfoBean6.getBtkyksyono(), "10000000065", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean6.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean6.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean6.getKankeisyakbnname(), "年金受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean6.getSyoumetuymd(), BizDate.valueOf(20160128), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean6.getSyoumetujiyuuname(), "年金終了", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean6.getSyouhnnm(), "入院保険", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean7 = result.getBetukutiKeiyakuInfoBeanLst().get(7);
        exStringEquals(betukutiKeiyakuInfoBean7.getBtkyksyono(), "10000000075", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean7.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean7.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean7.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean7.getSyoumetuymd(), BizDate.valueOf(20160129), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean7.getSyoumetujiyuuname(), "年金終了", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean7.getSyouhnnm(), "長期入院保険", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean8 = result.getBetukutiKeiyakuInfoBeanLst().get(8);
        exStringEquals(betukutiKeiyakuInfoBean8.getBtkyksyono(), "10000000085", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean8.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean8.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean8.getKankeisyakbnname(), "年金受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean8.getSyoumetuymd(), BizDate.valueOf(20160128), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean8.getSyoumetujiyuuname(), "年金終了", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean8.getSyouhnnm(), "入院保険", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean9 = result.getBetukutiKeiyakuInfoBeanLst().get(9);
        exStringEquals(betukutiKeiyakuInfoBean9.getBtkyksyono(), "10000000095", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean9.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean9.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean9.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean9.getSyoumetuymd(), BizDate.valueOf(20160129), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean9.getSyoumetujiyuuname(), "年金終了", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean9.getSyouhnnm(), "長期入院保険", "商品名");

        exClassificationEquals(result.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(result.getPalsyoukaijissiumukbn(), C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
        exClassificationEquals(result.getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIOK, "索引情報照会エラー区分");
        exClassificationEquals(result.getKykensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約管理件数超過有無区分");
        exClassificationEquals(result.getNkkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金支払件数超過有無区分");
        exClassificationEquals(result.getKykmfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約ＭＦ件数超過有無区分");
        exClassificationEquals(result.getNkfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金Ｆ件数超過有無区分");
        exClassificationEquals(result.getSueokifkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "据置Ｆ件数超過有無区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();

        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN12;

        BetukutiKeiyakuInfoGetParam param = SWAKInjector.getInstance(BetukutiKeiyakuInfoGetParam.class);
        param.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        param.setHuho2kykno("10000000006");
        param.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);
        BetukutiKeiyakuInfoResultBean result = betukutiKeiyakuInfoGet.exec(param) ;
        exNumericEquals(result.getBetukutiKeiyakuInfoBeanLst().size(), 1, "別口契約情報Beanリストの件数");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean = result.getBetukutiKeiyakuInfoBeanLst().get(0);
        exStringEquals(betukutiKeiyakuInfoBean.getBtkyksyono(), "10000000006", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean.getKankeisyakbnname(), "契約者", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean.getSyoumetuymd(), BizDate.valueOf(20160201), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean.getSyoumetujiyuuname(), "契約取消", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean.getSyouhnnm(), "入院保険", "商品名");

        exClassificationEquals(result.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(result.getPalsyoukaijissiumukbn(), C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
        exClassificationEquals(result.getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIOK, "索引情報照会エラー区分");
        exClassificationEquals(result.getKykensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約管理件数超過有無区分");
        exClassificationEquals(result.getNkkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金支払件数超過有無区分");
        exClassificationEquals(result.getKykmfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約ＭＦ件数超過有無区分");
        exClassificationEquals(result.getNkfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金Ｆ件数超過有無区分");
        exClassificationEquals(result.getSueokifkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "据置Ｆ件数超過有無区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();

        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN13;

        BetukutiKeiyakuInfoGetParam param = SWAKInjector.getInstance(BetukutiKeiyakuInfoGetParam.class);
        param.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        param.setHuho2kykno("10000000007");
        param.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);
        BetukutiKeiyakuInfoResultBean result = betukutiKeiyakuInfoGet.exec(param) ;
        exNumericEquals(result.getBetukutiKeiyakuInfoBeanLst().size(), 10, "別口契約情報Beanリストの件数");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean0 = result.getBetukutiKeiyakuInfoBeanLst().get(0);
        exStringEquals(betukutiKeiyakuInfoBean0.getBtkyksyono(), "10000000007", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean0.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean0.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean0.getKankeisyakbnname(), "契約者", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean0.getSyoumetuymd(), BizDate.valueOf(20160201), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean0.getSyoumetujiyuuname(), "契約取消", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean0.getSyouhnnm(), "入院保険", "商品名");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean1 = result.getBetukutiKeiyakuInfoBeanLst().get(1);
        exStringEquals(betukutiKeiyakuInfoBean1.getBtkyksyono(), "10000000017", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean1.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean1.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean1.getKankeisyakbnname(), "据置受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean1.getSyoumetuymd(), BizDate.valueOf(20160202), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean1.getSyoumetujiyuuname(), "契約取消", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean1.getSyouhnnm(), "長期入院保険", "商品名");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean2 = result.getBetukutiKeiyakuInfoBeanLst().get(2);
        exStringEquals(betukutiKeiyakuInfoBean2.getBtkyksyono(), "10000000027", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean2.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean2.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean2.getKankeisyakbnname(), "契約者", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean2.getSyoumetuymd(), BizDate.valueOf(20160201), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean2.getSyoumetujiyuuname(), "契約取消", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean2.getSyouhnnm(), "入院保険", "商品名");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean3 = result.getBetukutiKeiyakuInfoBeanLst().get(3);
        exStringEquals(betukutiKeiyakuInfoBean3.getBtkyksyono(), "10000000037", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean3.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean3.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean3.getKankeisyakbnname(), "据置受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean3.getSyoumetuymd(), BizDate.valueOf(20160202), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean3.getSyoumetujiyuuname(), "契約取消", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean3.getSyouhnnm(), "長期入院保険", "商品名");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean4 = result.getBetukutiKeiyakuInfoBeanLst().get(4);
        exStringEquals(betukutiKeiyakuInfoBean4.getBtkyksyono(), "10000000047", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean4.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean4.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean4.getKankeisyakbnname(), "契約者", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean4.getSyoumetuymd(), BizDate.valueOf(20160201), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean4.getSyoumetujiyuuname(), "契約取消", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean4.getSyouhnnm(), "入院保険", "商品名");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean5 = result.getBetukutiKeiyakuInfoBeanLst().get(5);
        exStringEquals(betukutiKeiyakuInfoBean5.getBtkyksyono(), "10000000057", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean5.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean5.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean5.getKankeisyakbnname(), "据置受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean5.getSyoumetuymd(), BizDate.valueOf(20160202), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean5.getSyoumetujiyuuname(), "契約取消", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean5.getSyouhnnm(), "長期入院保険", "商品名");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean6 = result.getBetukutiKeiyakuInfoBeanLst().get(6);
        exStringEquals(betukutiKeiyakuInfoBean6.getBtkyksyono(), "10000000067", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean6.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean6.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean6.getKankeisyakbnname(), "契約者", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean6.getSyoumetuymd(), BizDate.valueOf(20160201), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean6.getSyoumetujiyuuname(), "契約取消", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean6.getSyouhnnm(), "入院保険", "商品名");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean7 = result.getBetukutiKeiyakuInfoBeanLst().get(7);
        exStringEquals(betukutiKeiyakuInfoBean7.getBtkyksyono(), "10000000077", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean7.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean7.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean7.getKankeisyakbnname(), "据置受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean7.getSyoumetuymd(), BizDate.valueOf(20160202), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean7.getSyoumetujiyuuname(), "契約取消", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean7.getSyouhnnm(), "長期入院保険", "商品名");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean8 = result.getBetukutiKeiyakuInfoBeanLst().get(8);
        exStringEquals(betukutiKeiyakuInfoBean8.getBtkyksyono(), "10000000087", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean8.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean8.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean8.getKankeisyakbnname(), "契約者", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean8.getSyoumetuymd(), BizDate.valueOf(20160201), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean8.getSyoumetujiyuuname(), "契約取消", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean8.getSyouhnnm(), "入院保険", "商品名");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean9 = result.getBetukutiKeiyakuInfoBeanLst().get(9);
        exStringEquals(betukutiKeiyakuInfoBean9.getBtkyksyono(), "10000000097", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean9.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean9.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean9.getKankeisyakbnname(), "据置受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean9.getSyoumetuymd(), BizDate.valueOf(20160202), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean9.getSyoumetujiyuuname(), "契約取消", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean9.getSyouhnnm(), "長期入院保険", "商品名");

        exClassificationEquals(result.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(result.getPalsyoukaijissiumukbn(), C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
        exClassificationEquals(result.getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIOK, "索引情報照会エラー区分");
        exClassificationEquals(result.getKykensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約管理件数超過有無区分");
        exClassificationEquals(result.getNkkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金支払件数超過有無区分");
        exClassificationEquals(result.getKykmfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約ＭＦ件数超過有無区分");
        exClassificationEquals(result.getNkfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金Ｆ件数超過有無区分");
        exClassificationEquals(result.getSueokifkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "据置Ｆ件数超過有無区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();

        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN14;

        BetukutiKeiyakuInfoGetParam param = SWAKInjector.getInstance(BetukutiKeiyakuInfoGetParam.class);
        param.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        param.setHuho2kykno("10000000008");
        param.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);
        BetukutiKeiyakuInfoResultBean result = betukutiKeiyakuInfoGet.exec(param) ;
        exNumericEquals(result.getBetukutiKeiyakuInfoBeanLst().size(), 2, "別口契約情報Beanリストの件数");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean0 = result.getBetukutiKeiyakuInfoBeanLst().get(0);
        exStringEquals(betukutiKeiyakuInfoBean0.getBtkyksyono(), "10000000008", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean0.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean0.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean0.getKankeisyakbnname(), "契約者", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean0.getSyoumetuymd(), BizDate.valueOf(20160201), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean0.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean0.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean1 = result.getBetukutiKeiyakuInfoBeanLst().get(1);
        exStringEquals(betukutiKeiyakuInfoBean1.getBtkyksyono(), "10000000018", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean1.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean1.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean1.getKankeisyakbnname(), "年金受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean1.getSyoumetuymd(), BizDate.valueOf(20160202), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean1.getSyoumetujiyuuname(), "その他", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean1.getSyouhnnm(), "", "商品名");

        exClassificationEquals(result.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(result.getPalsyoukaijissiumukbn(), C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
        exClassificationEquals(result.getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIOK, "索引情報照会エラー区分");
        exClassificationEquals(result.getKykensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約管理件数超過有無区分");
        exClassificationEquals(result.getNkkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金支払件数超過有無区分");
        exClassificationEquals(result.getKykmfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約ＭＦ件数超過有無区分");
        exClassificationEquals(result.getNkfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金Ｆ件数超過有無区分");
        exClassificationEquals(result.getSueokifkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "据置Ｆ件数超過有無区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        MockObjectManager.initialize();

        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN15;

        BetukutiKeiyakuInfoGetParam param = SWAKInjector.getInstance(BetukutiKeiyakuInfoGetParam.class);
        param.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        param.setHuho2kykno("10000000009");
        param.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);
        BetukutiKeiyakuInfoResultBean result = betukutiKeiyakuInfoGet.exec(param) ;
        exNumericEquals(result.getBetukutiKeiyakuInfoBeanLst().size(), 1, "別口契約情報Beanリストの件数");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean = result.getBetukutiKeiyakuInfoBeanLst().get(0);
        exStringEquals(betukutiKeiyakuInfoBean.getBtkyksyono(), "10000000009", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.SUEOKI, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean.getKankeisyakbnname(), "据置受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean.getSyoumetuymd(), null, "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean.getSyouhnnm(), "", "商品名");

        exClassificationEquals(result.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(result.getPalsyoukaijissiumukbn(), C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
        exClassificationEquals(result.getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIOK, "索引情報照会エラー区分");
        exClassificationEquals(result.getKykensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約管理件数超過有無区分");
        exClassificationEquals(result.getNkkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金支払件数超過有無区分");
        exClassificationEquals(result.getKykmfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約ＭＦ件数超過有無区分");
        exClassificationEquals(result.getNkfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金Ｆ件数超過有無区分");
        exClassificationEquals(result.getSueokifkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "据置Ｆ件数超過有無区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        MockObjectManager.initialize();

        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN16;

        BetukutiKeiyakuInfoGetParam param = SWAKInjector.getInstance(BetukutiKeiyakuInfoGetParam.class);
        param.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        param.setHuho2kykno("10000000010");
        param.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);
        BetukutiKeiyakuInfoResultBean result = betukutiKeiyakuInfoGet.exec(param) ;
        exNumericEquals(result.getBetukutiKeiyakuInfoBeanLst().size(), 30, "別口契約情報Beanリストの件数");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean0 = result.getBetukutiKeiyakuInfoBeanLst().get(0);
        exStringEquals(betukutiKeiyakuInfoBean0.getBtkyksyono(), "10000000010", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean0.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean0.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean0.getKankeisyakbnname(), "契約者", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean0.getSyoumetuymd(), BizDate.valueOf(20160203), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean0.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean0.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean1 = result.getBetukutiKeiyakuInfoBeanLst().get(1);
        exStringEquals(betukutiKeiyakuInfoBean1.getBtkyksyono(), "10000000011", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean1.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean1.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean1.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean1.getSyoumetuymd(), BizDate.valueOf(20160204), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean1.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean1.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean2 = result.getBetukutiKeiyakuInfoBeanLst().get(2);
        exStringEquals(betukutiKeiyakuInfoBean2.getBtkyksyono(), "10000000012", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean2.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean2.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean2.getKankeisyakbnname(), "契約者", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean2.getSyoumetuymd(), BizDate.valueOf(20160203), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean2.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean2.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean3 = result.getBetukutiKeiyakuInfoBeanLst().get(3);
        exStringEquals(betukutiKeiyakuInfoBean3.getBtkyksyono(), "10000000013", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean3.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean3.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean3.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean3.getSyoumetuymd(), BizDate.valueOf(20160204), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean3.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean3.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean4 = result.getBetukutiKeiyakuInfoBeanLst().get(4);
        exStringEquals(betukutiKeiyakuInfoBean4.getBtkyksyono(), "10000000014", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean4.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean4.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean4.getKankeisyakbnname(), "契約者", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean4.getSyoumetuymd(), BizDate.valueOf(20160203), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean4.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean4.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean5 = result.getBetukutiKeiyakuInfoBeanLst().get(5);
        exStringEquals(betukutiKeiyakuInfoBean5.getBtkyksyono(), "10000000015", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean5.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean5.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean5.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean5.getSyoumetuymd(), BizDate.valueOf(20160204), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean5.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean5.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean6 = result.getBetukutiKeiyakuInfoBeanLst().get(6);
        exStringEquals(betukutiKeiyakuInfoBean6.getBtkyksyono(), "10000000016", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean6.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean6.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean6.getKankeisyakbnname(), "契約者", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean6.getSyoumetuymd(), BizDate.valueOf(20160203), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean6.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean6.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean7 = result.getBetukutiKeiyakuInfoBeanLst().get(7);
        exStringEquals(betukutiKeiyakuInfoBean7.getBtkyksyono(), "10000000017", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean7.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean7.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean7.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean7.getSyoumetuymd(), BizDate.valueOf(20160204), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean7.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean7.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean8 = result.getBetukutiKeiyakuInfoBeanLst().get(8);
        exStringEquals(betukutiKeiyakuInfoBean8.getBtkyksyono(), "10000000018", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean8.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean8.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean8.getKankeisyakbnname(), "契約者", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean8.getSyoumetuymd(), BizDate.valueOf(20160203), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean8.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean8.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean9 = result.getBetukutiKeiyakuInfoBeanLst().get(9);
        exStringEquals(betukutiKeiyakuInfoBean9.getBtkyksyono(), "10000000019", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean9.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean9.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean9.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean9.getSyoumetuymd(), BizDate.valueOf(20160204), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean9.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean9.getSyouhnnm(), "", "商品名");


        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean10 = result.getBetukutiKeiyakuInfoBeanLst().get(10);
        exStringEquals(betukutiKeiyakuInfoBean10.getBtkyksyono(), "10000000020", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean10.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean10.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean10.getKankeisyakbnname(), "年金受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean10.getSyoumetuymd(), BizDate.valueOf(20160205), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean10.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean10.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean11 = result.getBetukutiKeiyakuInfoBeanLst().get(11);
        exStringEquals(betukutiKeiyakuInfoBean11.getBtkyksyono(), "10000000021", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean11.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean11.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean11.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean11.getSyoumetuymd(), BizDate.valueOf(20160206), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean11.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean11.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean12 = result.getBetukutiKeiyakuInfoBeanLst().get(12);
        exStringEquals(betukutiKeiyakuInfoBean12.getBtkyksyono(), "10000000022", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean12.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean12.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean12.getKankeisyakbnname(), "年金受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean12.getSyoumetuymd(), BizDate.valueOf(20160205), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean12.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean12.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean13 = result.getBetukutiKeiyakuInfoBeanLst().get(13);
        exStringEquals(betukutiKeiyakuInfoBean13.getBtkyksyono(), "10000000023", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean13.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean13.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean13.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean13.getSyoumetuymd(), BizDate.valueOf(20160206), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean13.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean13.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean14 = result.getBetukutiKeiyakuInfoBeanLst().get(14);
        exStringEquals(betukutiKeiyakuInfoBean14.getBtkyksyono(), "10000000024", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean14.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean14.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean14.getKankeisyakbnname(), "年金受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean14.getSyoumetuymd(), BizDate.valueOf(20160205), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean14.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean14.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean15 = result.getBetukutiKeiyakuInfoBeanLst().get(15);
        exStringEquals(betukutiKeiyakuInfoBean15.getBtkyksyono(), "10000000025", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean15.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean15.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean15.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean15.getSyoumetuymd(), BizDate.valueOf(20160206), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean15.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean15.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean16 = result.getBetukutiKeiyakuInfoBeanLst().get(16);
        exStringEquals(betukutiKeiyakuInfoBean16.getBtkyksyono(), "10000000026", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean16.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean16.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean16.getKankeisyakbnname(), "年金受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean16.getSyoumetuymd(), BizDate.valueOf(20160205), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean16.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean16.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean17 = result.getBetukutiKeiyakuInfoBeanLst().get(17);
        exStringEquals(betukutiKeiyakuInfoBean17.getBtkyksyono(), "10000000027", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean17.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean17.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean17.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean17.getSyoumetuymd(), BizDate.valueOf(20160206), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean17.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean17.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean18 = result.getBetukutiKeiyakuInfoBeanLst().get(18);
        exStringEquals(betukutiKeiyakuInfoBean18.getBtkyksyono(), "10000000028", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean18.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean18.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean18.getKankeisyakbnname(), "年金受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean18.getSyoumetuymd(), BizDate.valueOf(20160205), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean18.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean18.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean19 = result.getBetukutiKeiyakuInfoBeanLst().get(19);
        exStringEquals(betukutiKeiyakuInfoBean19.getBtkyksyono(), "10000000029", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean19.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean19.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean19.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean19.getSyoumetuymd(), BizDate.valueOf(20160206), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean19.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean19.getSyouhnnm(), "", "商品名");


        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean20 = result.getBetukutiKeiyakuInfoBeanLst().get(20);
        exStringEquals(betukutiKeiyakuInfoBean20.getBtkyksyono(), "10000000030", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean20.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean20.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.SUEOKI, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean20.getKankeisyakbnname(), "据置受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean20.getSyoumetuymd(), null, "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean20.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean20.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean21 = result.getBetukutiKeiyakuInfoBeanLst().get(21);
        exStringEquals(betukutiKeiyakuInfoBean21.getBtkyksyono(), "10000000031", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean21.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean21.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.SUEOKI, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean21.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean21.getSyoumetuymd(), null, "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean21.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean21.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean22 = result.getBetukutiKeiyakuInfoBeanLst().get(22);
        exStringEquals(betukutiKeiyakuInfoBean22.getBtkyksyono(), "10000000032", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean22.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean22.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.SUEOKI, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean22.getKankeisyakbnname(), "据置受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean22.getSyoumetuymd(), null, "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean22.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean22.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean23 = result.getBetukutiKeiyakuInfoBeanLst().get(23);
        exStringEquals(betukutiKeiyakuInfoBean23.getBtkyksyono(), "10000000033", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean23.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean23.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.SUEOKI, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean23.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean23.getSyoumetuymd(), null, "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean23.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean23.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean24 = result.getBetukutiKeiyakuInfoBeanLst().get(24);
        exStringEquals(betukutiKeiyakuInfoBean24.getBtkyksyono(), "10000000034", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean24.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean24.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.SUEOKI, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean24.getKankeisyakbnname(), "据置受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean24.getSyoumetuymd(), null, "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean24.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean24.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean25 = result.getBetukutiKeiyakuInfoBeanLst().get(25);
        exStringEquals(betukutiKeiyakuInfoBean25.getBtkyksyono(), "10000000035", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean25.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean25.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.SUEOKI, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean25.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean25.getSyoumetuymd(), null, "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean25.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean25.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean26 = result.getBetukutiKeiyakuInfoBeanLst().get(26);
        exStringEquals(betukutiKeiyakuInfoBean26.getBtkyksyono(), "10000000036", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean26.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean26.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.SUEOKI, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean26.getKankeisyakbnname(), "据置受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean26.getSyoumetuymd(), null, "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean26.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean26.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean27 = result.getBetukutiKeiyakuInfoBeanLst().get(27);
        exStringEquals(betukutiKeiyakuInfoBean27.getBtkyksyono(), "10000000037", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean27.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean27.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.SUEOKI, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean27.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean27.getSyoumetuymd(), null, "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean27.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean27.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean28 = result.getBetukutiKeiyakuInfoBeanLst().get(28);
        exStringEquals(betukutiKeiyakuInfoBean28.getBtkyksyono(), "10000000038", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean28.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean28.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.SUEOKI, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean28.getKankeisyakbnname(), "据置受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean28.getSyoumetuymd(), null, "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean28.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean28.getSyouhnnm(), "", "商品名");

        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean29 = result.getBetukutiKeiyakuInfoBeanLst().get(29);
        exStringEquals(betukutiKeiyakuInfoBean29.getBtkyksyono(), "10000000039", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean29.getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean29.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.SUEOKI, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean29.getKankeisyakbnname(), "", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean29.getSyoumetuymd(), null, "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean29.getSyoumetujiyuuname(), "", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean29.getSyouhnnm(), "", "商品名");

        exClassificationEquals(result.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(result.getPalsyoukaijissiumukbn(), C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
        exClassificationEquals(result.getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIOK, "索引情報照会エラー区分");
        exClassificationEquals(result.getKykensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約管理件数超過有無区分");
        exClassificationEquals(result.getNkkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金支払件数超過有無区分");
        exClassificationEquals(result.getKykmfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約ＭＦ件数超過有無区分");
        exClassificationEquals(result.getNkfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金Ｆ件数超過有無区分");
        exClassificationEquals(result.getSueokifkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "据置Ｆ件数超過有無区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(2018, 4, 20));

        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN17;

        BetukutiKeiyakuInfoGetParam param = SWAKInjector.getInstance(BetukutiKeiyakuInfoGetParam.class);
        param.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        param.setHuho2kykno("10000000110");
        param.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);
        BetukutiKeiyakuInfoResultBean result = betukutiKeiyakuInfoGet.exec(param) ;
        exNumericEquals(result.getBetukutiKeiyakuInfoBeanLst().size(), 2, "別口契約情報Beanリストの件数");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean0 = result.getBetukutiKeiyakuInfoBeanLst().get(0);
        exStringEquals(betukutiKeiyakuInfoBean0.getBtkyksyono(), "10000000110", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean0.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean0.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.KEIYAKU, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean0.getKankeisyakbnname(), "契約者", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean0.getSyoumetuymd(), BizDate.valueOf(20170505), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean0.getSyoumetujiyuuname(), "契約取消", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean0.getSyouhnnm(), "入院保険", "商品名");
        BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean1 = result.getBetukutiKeiyakuInfoBeanLst().get(1);
        exStringEquals(betukutiKeiyakuInfoBean1.getBtkyksyono(), "10000000120", "別契約証券番号");
        exClassificationEquals(betukutiKeiyakuInfoBean1.getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(betukutiKeiyakuInfoBean1.getBetukutikeiyakukbn(), C_BetukutiKeiyakuKbn.NENKIN, "別口契約区分");
        exStringEquals(betukutiKeiyakuInfoBean1.getKankeisyakbnname(), "年金受取人", "関係者区分名称");
        exDateEquals(betukutiKeiyakuInfoBean1.getSyoumetuymd(), BizDate.valueOf(20170505), "消滅日");
        exStringEquals(betukutiKeiyakuInfoBean1.getSyoumetujiyuuname(), "年金終了", "消滅事由名称");
        exStringEquals(betukutiKeiyakuInfoBean1.getSyouhnnm(), "入院保険２", "商品名");

        exClassificationEquals(result.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(result.getPalsyoukaijissiumukbn(), C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
        exClassificationEquals(result.getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIOK, "索引情報照会エラー区分");
        exClassificationEquals(result.getKykensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約管理件数超過有無区分");
        exClassificationEquals(result.getNkkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金支払件数超過有無区分");
        exClassificationEquals(result.getKykmfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "契約ＭＦ件数超過有無区分");
        exClassificationEquals(result.getNkfkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "年金Ｆ件数超過有無区分");
        exClassificationEquals(result.getSueokifkensuutyoukaumu(), C_BlnktkumuKbn.ARI, "据置Ｆ件数超過有無区分");
    }
}
