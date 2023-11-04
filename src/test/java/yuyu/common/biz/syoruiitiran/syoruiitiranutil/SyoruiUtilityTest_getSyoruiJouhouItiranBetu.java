package yuyu.common.biz.syoruiitiran.syoruiitiranutil;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfImageClientMockForBiz;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 書類情報一覧ユーティリティクラスのメソッド {@link SyoruiUtility#getSyoruiJohoItiran(String[])} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyoruiUtilityTest_getSyoruiJouhouItiranBetu {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_書類情報一覧ユーティリティ";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SyoruiUtilityTest_getSyoruiJouhouItiranBetu.class, fileName,
                    sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        IwfCoreDomManager iwfCoreDomManager = SWAKInjector.getInstance(IwfCoreDomManager.class);

        bizDomManager.delete(bizDomManager.getAllTorikomiSyoruiHukaInfo());
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
        iwfCoreDomManager.delete(iwfCoreDomManager.getAllTorikomiSyorui());
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(IwfImageClient.class).to(IwfImageClientMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        IwfImageClientMockForBiz.caller = "Test";
    }

    @Test
    @TestOrder(10)
    public void testGetSyoruiJouhouItiranBetu_A1() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId("yuyu");

        IwfImageClientMockForBiz.mode = "qs-04";

        String[] kouteikanriId = new String[1];

        kouteikanriId[0] = "sk011";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 0, "書類情報一覧Beanリスト件数");

    }

    @Test
    @TestOrder(20)
    public void testGetSyoruiJouhouItiranBetu_A2() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKMOUSIKOMISYO);

        IwfImageClientMockForBiz.mode = "qs-06";

        String[] kouteikanriId = new String[1];

        kouteikanriId[0] = "sk071";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 0, "書類情報一覧Beanリスト件数");

    }

    @Test
    @TestOrder(30)
    public void testGetSyoruiJouhouItiranBetu_A3() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKMOUSIKOMISYO);

        IwfImageClientMockForBiz.mode = "qs-01";

        String[] kouteikanriId = new String[1];

        kouteikanriId[0] = "sk011";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        exStringEquals( outBean.getSyorikekkaStatus(), SyoruiResultConstants.RESULT_NG, "処理結果ステータス");

    }

    @Test
    @TestOrder(40)
    public void testGetSyoruiJouhouItiranBetu_A4() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKMOUSIKOMISYO);

        IwfImageClientMockForBiz.mode = "qs-07";

        String[] kouteikanriId = new String[16];

        kouteikanriId[0] = "sk001";
        kouteikanriId[1] = "sk007";
        kouteikanriId[2] = "sk008";
        kouteikanriId[3] = "sk009";
        kouteikanriId[4] = "sk005";
        kouteikanriId[5] = "sk011";
        kouteikanriId[6] = "sk006";
        kouteikanriId[7] = "sk010";
        kouteikanriId[8] = "sk032";
        kouteikanriId[9] = "sk014";
        kouteikanriId[10] = "sk013";
        kouteikanriId[11] = "sk002";
        kouteikanriId[12] = "sk012";
        kouteikanriId[13] = "sk016";
        kouteikanriId[14] = "sk017";
        kouteikanriId[15] = "sk018";


        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        exStringEquals(outBean.getSyorikekkaStatus(), "0", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), null, "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), null, "詳細メッセージ");

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 31, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean resultBean0 = resultBeanLst.get(0);

        exStringEquals(resultBean0.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean0.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean0.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean0.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean0.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean0.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean0.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean0.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean0.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean1 = resultBeanLst.get(1);

        exStringEquals(resultBean1.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean1.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean1.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean1.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean1.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean1.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean1.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean1.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean1.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean2 = resultBeanLst.get(2);

        exStringEquals(resultBean2.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean2.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean2.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean2.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean2.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean2.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean2.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean2.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean2.getSortNo(), 10, "ソート番号");



        SyoruiJohoItiranBean resultBean3 = resultBeanLst.get(3);

        exStringEquals(resultBean3.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean3.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean3.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean3.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean3.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean3.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean3.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean3.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean3.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean4 = resultBeanLst.get(4);

        exStringEquals(resultBean4.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean4.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean4.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean4.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean4.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean4.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean4.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean4.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean4.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean5 = resultBeanLst.get(5);

        exStringEquals(resultBean5.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean5.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean5.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean5.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean5.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean5.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean5.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean5.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean5.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean6 = resultBeanLst.get(6);

        exStringEquals(resultBean6.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean6.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean6.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean6.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean6.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean6.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean6.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean6.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean6.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean7 = resultBeanLst.get(7);

        exStringEquals(resultBean7.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean7.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean7.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean7.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean7.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean7.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean7.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean7.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean7.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean8 = resultBeanLst.get(8);

        exStringEquals(resultBean8.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean8.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean8.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean8.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean8.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean8.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean8.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean8.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean8.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean9 = resultBeanLst.get(9);

        exStringEquals(resultBean9.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean9.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean9.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean9.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean9.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean9.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean9.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean9.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean9.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean10 = resultBeanLst.get(10);

        exStringEquals(resultBean10.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean10.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean10.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean10.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean10.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean10.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean10.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean10.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean10.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean11 = resultBeanLst.get(11);

        exStringEquals(resultBean11.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean11.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean11.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean11.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean11.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean11.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean11.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean11.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean11.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean12 = resultBeanLst.get(12);

        exStringEquals(resultBean12.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean12.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean12.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean12.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean12.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean12.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean12.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean12.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean12.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean13 = resultBeanLst.get(13);

        exStringEquals(resultBean13.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean13.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean13.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean13.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean13.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean13.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean13.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean13.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean13.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean14 = resultBeanLst.get(14);

        exStringEquals(resultBean14.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean14.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean14.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean14.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean14.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean14.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean14.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean14.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean14.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean15 = resultBeanLst.get(15);

        exStringEquals(resultBean15.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean15.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean15.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean15.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean15.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean15.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean15.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean15.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean15.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean16 = resultBeanLst.get(16);

        exStringEquals(resultBean16.getSyoruiNnm(), "ペーパーレス申込書兼意向確認書", "取込書類名");

        exStringEquals(resultBean16.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean16.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean16.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean16.getImageId(), "", "イメージID");

        exStringEquals(resultBean16.getTorikomiSyoruiCd(), "sk002", "取込書類コード");

        exStringEquals(resultBean16.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean16.getKouteikanriId(), "sk002", "工程管理ＩＤ");

        exNumericEquals(resultBean16.getSortNo(), 20, "ソート番号");


        SyoruiJohoItiranBean resultBean17 = resultBeanLst.get(17);

        exStringEquals(resultBean17.getSyoruiNnm(), "意向確認書", "取込書類名");

        exStringEquals(resultBean17.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean17.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean17.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean17.getImageId(), "", "イメージID");

        exStringEquals(resultBean17.getTorikomiSyoruiCd(), "sk005", "取込書類コード");

        exStringEquals(resultBean17.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean17.getKouteikanriId(), "sk005", "工程管理ＩＤ");

        exNumericEquals(resultBean17.getSortNo(), 50, "ソート番号");


        SyoruiJohoItiranBean resultBean18 = resultBeanLst.get(18);

        exStringEquals(resultBean18.getSyoruiNnm(), "意向確認書（訂正用）", "取込書類名");

        exStringEquals(resultBean18.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean18.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean18.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean18.getImageId(), "", "イメージID");

        exStringEquals(resultBean18.getTorikomiSyoruiCd(), "sk006", "取込書類コード");

        exStringEquals(resultBean18.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean18.getKouteikanriId(), "sk006", "工程管理ＩＤ");

        exNumericEquals(resultBean18.getSortNo(), 60, "ソート番号");


        SyoruiJohoItiranBean resultBean19 = resultBeanLst.get(19);

        exStringEquals(resultBean19.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean19.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean19.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean19.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean19.getImageId(), "", "イメージID");

        exStringEquals(resultBean19.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean19.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean19.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean19.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean20 = resultBeanLst.get(20);

        exStringEquals(resultBean20.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean20.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean20.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean20.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean20.getImageId(), "", "イメージID");

        exStringEquals(resultBean20.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean20.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean20.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean20.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean21 = resultBeanLst.get(21);

        exStringEquals(resultBean21.getSyoruiNnm(), "第三者受取報告書", "取込書類名");

        exStringEquals(resultBean21.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean21.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean21.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean21.getImageId(), "", "イメージID");

        exStringEquals(resultBean21.getTorikomiSyoruiCd(), "sk009", "取込書類コード");

        exStringEquals(resultBean21.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean21.getKouteikanriId(), "sk009", "工程管理ＩＤ");

        exNumericEquals(resultBean21.getSortNo(), 90, "ソート番号");


        SyoruiJohoItiranBean resultBean22 = resultBeanLst.get(22);

        exStringEquals(resultBean22.getSyoruiNnm(), "ＦＡＴＣＡ確認書", "取込書類名");

        exStringEquals(resultBean22.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean22.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean22.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean22.getImageId(), "", "イメージID");

        exStringEquals(resultBean22.getTorikomiSyoruiCd(), "sk010", "取込書類コード");

        exStringEquals(resultBean22.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean22.getKouteikanriId(), "sk010", "工程管理ＩＤ");

        exNumericEquals(resultBean22.getSortNo(), 100, "ソート番号");


        SyoruiJohoItiranBean resultBean23 = resultBeanLst.get(23);

        exStringEquals(resultBean23.getSyoruiNnm(), "取扱報告書", "取込書類名");

        exStringEquals(resultBean23.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean23.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean23.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean23.getImageId(), "", "イメージID");

        exStringEquals(resultBean23.getTorikomiSyoruiCd(), "sk011", "取込書類コード");

        exStringEquals(resultBean23.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean23.getKouteikanriId(), "sk011", "工程管理ＩＤ");

        exNumericEquals(resultBean23.getSortNo(), 110, "ソート番号");


        SyoruiJohoItiranBean resultBean24 = resultBeanLst.get(24);

        exStringEquals(resultBean24.getSyoruiNnm(), "ペーパーレス取扱報告書", "取込書類名");

        exStringEquals(resultBean24.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean24.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean24.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean24.getImageId(), "", "イメージID");

        exStringEquals(resultBean24.getTorikomiSyoruiCd(), "sk012", "取込書類コード");

        exStringEquals(resultBean24.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean24.getKouteikanriId(), "sk012", "工程管理ＩＤ");

        exNumericEquals(resultBean24.getSortNo(), 120, "ソート番号");


        SyoruiJohoItiranBean resultBean25 = resultBeanLst.get(25);

        exStringEquals(resultBean25.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean25.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean25.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean25.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean25.getImageId(), "", "イメージID");

        exStringEquals(resultBean25.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean25.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean25.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean25.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean26 = resultBeanLst.get(26);

        exStringEquals(resultBean26.getSyoruiNnm(), "変更訂正書", "取込書類名");

        exStringEquals(resultBean26.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean26.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean26.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean26.getImageId(), "", "イメージID");

        exStringEquals(resultBean26.getTorikomiSyoruiCd(), "sk014", "取込書類コード");

        exStringEquals(resultBean26.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean26.getKouteikanriId(), "sk014", "工程管理ＩＤ");

        exNumericEquals(resultBean26.getSortNo(), 140, "ソート番号");


        SyoruiJohoItiranBean resultBean27 = resultBeanLst.get(27);

        exStringEquals(resultBean27.getSyoruiNnm(), "不備通知書", "取込書類名");

        exStringEquals(resultBean27.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean27.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean27.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean27.getImageId(), "", "イメージID");

        exStringEquals(resultBean27.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(resultBean27.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean27.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exNumericEquals(resultBean27.getSortNo(), 150, "ソート番号");


        SyoruiJohoItiranBean resultBean28 = resultBeanLst.get(28);

        exStringEquals(resultBean28.getSyoruiNnm(), "生命保険料支払申込書", "取込書類名");

        exStringEquals(resultBean28.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean28.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean28.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean28.getImageId(), "", "イメージID");

        exStringEquals(resultBean28.getTorikomiSyoruiCd(), "sk016", "取込書類コード");

        exStringEquals(resultBean28.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean28.getKouteikanriId(), "sk016", "工程管理ＩＤ");

        exNumericEquals(resultBean28.getSortNo(), 210, "ソート番号");


        SyoruiJohoItiranBean resultBean29 = resultBeanLst.get(29);

        exStringEquals(resultBean29.getSyoruiNnm(), "代筆報告書", "取込書類名");

        exStringEquals(resultBean29.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean29.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean29.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean29.getImageId(), "", "イメージID");

        exStringEquals(resultBean29.getTorikomiSyoruiCd(), "sk017", "取込書類コード");

        exStringEquals(resultBean29.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean29.getKouteikanriId(), "sk017", "工程管理ＩＤ");

        exNumericEquals(resultBean29.getSortNo(), 220, "ソート番号");


        SyoruiJohoItiranBean resultBean30 = resultBeanLst.get(30);

        exStringEquals(resultBean30.getSyoruiNnm(), "非対面チェックシート", "取込書類名");

        exStringEquals(resultBean30.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean30.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean30.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean30.getImageId(), "", "イメージID");

        exStringEquals(resultBean30.getTorikomiSyoruiCd(), "sk018", "取込書類コード");

        exStringEquals(resultBean30.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean30.getKouteikanriId(), "sk018", "工程管理ＩＤ");

        exNumericEquals(resultBean30.getSortNo(), 240, "ソート番号");


    }

    @Test
    @TestOrder(50)
    public void testGetSyoruiJouhouItiranBetu_A5() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKKOKUTISYO);

        IwfImageClientMockForBiz.mode = "qs-08";

        String[] kouteikanriId = new String[7];

        kouteikanriId[0] = "sk001";
        kouteikanriId[1] = "sk003";
        kouteikanriId[2] = "sk032";
        kouteikanriId[3] = "sk014";
        kouteikanriId[4] = "sk013";
        kouteikanriId[5] = "sk002";
        kouteikanriId[6] = "sk004";


        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        exStringEquals(outBean.getSyorikekkaStatus(), "0", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), null, "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), null, "詳細メッセージ");

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 14, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean resultBean0 = resultBeanLst.get(0);

        exStringEquals(resultBean0.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean0.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean0.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean0.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean0.getImageId(), "", "イメージID");

        exStringEquals(resultBean0.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean0.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean0.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean0.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean1 = resultBeanLst.get(1);

        exStringEquals(resultBean1.getSyoruiNnm(), "ペーパーレス申込書兼意向確認書", "取込書類名");

        exStringEquals(resultBean1.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean1.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean1.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean1.getImageId(), "", "イメージID");

        exStringEquals(resultBean1.getTorikomiSyoruiCd(), "sk002", "取込書類コード");

        exStringEquals(resultBean1.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean1.getKouteikanriId(), "sk002", "工程管理ＩＤ");

        exNumericEquals(resultBean1.getSortNo(), 20, "ソート番号");


        SyoruiJohoItiranBean resultBean2 = resultBeanLst.get(2);

        exStringEquals(resultBean2.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean2.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean2.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean2.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean2.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean2.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean2.getHyoujiLinkFlg(), "0", "表示リンクフラグ");

        exStringEquals(resultBean2.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean2.getSortNo(), 30, "ソート番号");


        SyoruiJohoItiranBean resultBean3 = resultBeanLst.get(3);

        exStringEquals(resultBean3.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean3.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean3.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean3.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean3.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean3.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean3.getHyoujiLinkFlg(), "0", "表示リンクフラグ");

        exStringEquals(resultBean3.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean3.getSortNo(), 30, "ソート番号");


        SyoruiJohoItiranBean resultBean4 = resultBeanLst.get(4);

        exStringEquals(resultBean4.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean4.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean4.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean4.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean4.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean4.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean4.getHyoujiLinkFlg(), "0", "表示リンクフラグ");

        exStringEquals(resultBean4.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean4.getSortNo(), 30, "ソート番号");


        SyoruiJohoItiranBean resultBean5 = resultBeanLst.get(5);

        exStringEquals(resultBean5.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean5.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean5.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean5.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean5.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean5.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean5.getHyoujiLinkFlg(), "0", "表示リンクフラグ");

        exStringEquals(resultBean5.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean5.getSortNo(), 30, "ソート番号");


        SyoruiJohoItiranBean resultBean6 = resultBeanLst.get(6);

        exStringEquals(resultBean6.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean6.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean6.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean6.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean6.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean6.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean6.getHyoujiLinkFlg(), "0", "表示リンクフラグ");

        exStringEquals(resultBean6.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean6.getSortNo(), 30, "ソート番号");


        SyoruiJohoItiranBean resultBean7 = resultBeanLst.get(7);

        exStringEquals(resultBean7.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean7.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean7.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean7.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean7.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean7.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean7.getHyoujiLinkFlg(), "0", "表示リンクフラグ");

        exStringEquals(resultBean7.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean7.getSortNo(), 30, "ソート番号");


        SyoruiJohoItiranBean resultBean8 = resultBeanLst.get(8);

        exStringEquals(resultBean8.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean8.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean8.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean8.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean8.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean8.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean8.getHyoujiLinkFlg(), "0", "表示リンクフラグ");

        exStringEquals(resultBean8.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean8.getSortNo(), 30, "ソート番号");


        SyoruiJohoItiranBean resultBean9 = resultBeanLst.get(9);

        exStringEquals(resultBean9.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean9.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean9.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean9.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean9.getImageId(), "", "イメージID");

        exStringEquals(resultBean9.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean9.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean9.getKouteikanriId(), "sk003", "工程管理ＩＤ");

        exNumericEquals(resultBean9.getSortNo(), 30, "ソート番号");


        SyoruiJohoItiranBean resultBean10 = resultBeanLst.get(10);

        exStringEquals(resultBean10.getSyoruiNnm(), "ペーパーレス告知書", "取込書類名");

        exStringEquals(resultBean10.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean10.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean10.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean10.getImageId(), "", "イメージID");

        exStringEquals(resultBean10.getTorikomiSyoruiCd(), "sk004", "取込書類コード");

        exStringEquals(resultBean10.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean10.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean10.getSortNo(), 40, "ソート番号");


        SyoruiJohoItiranBean resultBean11 = resultBeanLst.get(11);

        exStringEquals(resultBean11.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean11.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean11.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean11.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean11.getImageId(), "", "イメージID");

        exStringEquals(resultBean11.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean11.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean11.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean11.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean12 = resultBeanLst.get(12);

        exStringEquals(resultBean12.getSyoruiNnm(), "変更訂正書", "取込書類名");

        exStringEquals(resultBean12.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean12.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean12.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean12.getImageId(), "", "イメージID");

        exStringEquals(resultBean12.getTorikomiSyoruiCd(), "sk014", "取込書類コード");

        exStringEquals(resultBean12.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean12.getKouteikanriId(), "sk014", "工程管理ＩＤ");

        exNumericEquals(resultBean12.getSortNo(), 140, "ソート番号");


        SyoruiJohoItiranBean resultBean13 = resultBeanLst.get(13);

        exStringEquals(resultBean13.getSyoruiNnm(), "不備通知書", "取込書類名");

        exStringEquals(resultBean13.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean13.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean13.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean13.getImageId(), "", "イメージID");

        exStringEquals(resultBean13.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(resultBean13.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean13.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exNumericEquals(resultBean13.getSortNo(), 150, "ソート番号");

    }

    @Test
    @TestOrder(60)
    public void testGetSyoruiJouhouItiranBetu_A6() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKMOUSIKOMITENKEN);

        IwfImageClientMockForBiz.mode = "qs-09";

        String[] kouteikanriId = new String[23];

        kouteikanriId[0] = "sk001";
        kouteikanriId[1] = "sk007";
        kouteikanriId[2] = "sk008";
        kouteikanriId[3] = "sk009";
        kouteikanriId[4] = "sk005";
        kouteikanriId[5] = "sk011";
        kouteikanriId[6] = "sk006";
        kouteikanriId[7] = "sk010";
        kouteikanriId[8] = "sk033";
        kouteikanriId[9] = "sk034";
        kouteikanriId[10] = "sk003";
        kouteikanriId[11] = "sk032";
        kouteikanriId[12] = "sk014";
        kouteikanriId[13] = "sk013";
        kouteikanriId[14] = "sk071";
        kouteikanriId[15] = "sk038";
        kouteikanriId[16] = "sk002";
        kouteikanriId[17] = "sk004";
        kouteikanriId[18] = "sk012";
        kouteikanriId[19] = "sk016";
        kouteikanriId[20] = "sk017";
        kouteikanriId[21] = "sk046";
        kouteikanriId[22] = "sk018";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        exStringEquals(outBean.getSyorikekkaStatus(), "0", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), null, "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), null, "詳細メッセージ");

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 45, "書類情報一覧Beanリスト件数");


        SyoruiJohoItiranBean resultBean0 = resultBeanLst.get(0);

        exStringEquals(resultBean0.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean0.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean0.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean0.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean0.getImageId(), "", "イメージID");

        exStringEquals(resultBean0.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean0.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean0.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean0.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean1 = resultBeanLst.get(1);

        exStringEquals(resultBean1.getSyoruiNnm(), "ペーパーレス申込書兼意向確認書", "取込書類名");

        exStringEquals(resultBean1.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean1.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean1.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean1.getImageId(), "", "イメージID");

        exStringEquals(resultBean1.getTorikomiSyoruiCd(), "sk002", "取込書類コード");

        exStringEquals(resultBean1.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean1.getKouteikanriId(), "sk002", "工程管理ＩＤ");

        exNumericEquals(resultBean1.getSortNo(), 20, "ソート番号");


        SyoruiJohoItiranBean resultBean2 = resultBeanLst.get(2);

        exStringEquals(resultBean2.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean2.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean2.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean2.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean2.getImageId(), "", "イメージID");

        exStringEquals(resultBean2.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean2.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean2.getKouteikanriId(), "sk003", "工程管理ＩＤ");

        exNumericEquals(resultBean2.getSortNo(), 30, "ソート番号");



        SyoruiJohoItiranBean resultBean3 = resultBeanLst.get(3);

        exStringEquals(resultBean3.getSyoruiNnm(), "ペーパーレス告知書", "取込書類名");

        exStringEquals(resultBean3.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean3.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean3.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean3.getImageId(), "", "イメージID");

        exStringEquals(resultBean3.getTorikomiSyoruiCd(), "sk004", "取込書類コード");

        exStringEquals(resultBean3.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean3.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean3.getSortNo(), 40, "ソート番号");


        SyoruiJohoItiranBean resultBean4 = resultBeanLst.get(4);

        exStringEquals(resultBean4.getSyoruiNnm(), "意向確認書", "取込書類名");

        exStringEquals(resultBean4.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean4.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean4.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean4.getImageId(), "", "イメージID");

        exStringEquals(resultBean4.getTorikomiSyoruiCd(), "sk005", "取込書類コード");

        exStringEquals(resultBean4.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean4.getKouteikanriId(), "sk005", "工程管理ＩＤ");

        exNumericEquals(resultBean4.getSortNo(), 50, "ソート番号");


        SyoruiJohoItiranBean resultBean5 = resultBeanLst.get(5);

        exStringEquals(resultBean5.getSyoruiNnm(), "意向確認書（訂正用）", "取込書類名");

        exStringEquals(resultBean5.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean5.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean5.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean5.getImageId(), "", "イメージID");

        exStringEquals(resultBean5.getTorikomiSyoruiCd(), "sk006", "取込書類コード");

        exStringEquals(resultBean5.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean5.getKouteikanriId(), "sk006", "工程管理ＩＤ");

        exNumericEquals(resultBean5.getSortNo(), 60, "ソート番号");


        SyoruiJohoItiranBean resultBean6 = resultBeanLst.get(6);

        exStringEquals(resultBean6.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean6.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean6.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean6.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean6.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean6.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean6.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean6.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean6.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean7 = resultBeanLst.get(7);

        exStringEquals(resultBean7.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean7.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean7.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean7.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean7.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean7.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean7.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean7.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean7.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean8 = resultBeanLst.get(8);

        exStringEquals(resultBean8.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean8.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean8.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean8.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean8.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean8.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean8.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean8.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean8.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean9 = resultBeanLst.get(9);

        exStringEquals(resultBean9.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean9.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean9.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean9.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean9.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean9.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean9.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean9.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean9.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean10 = resultBeanLst.get(10);

        exStringEquals(resultBean10.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean10.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean10.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean10.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean10.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean10.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean10.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean10.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean10.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean11 = resultBeanLst.get(11);

        exStringEquals(resultBean11.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean11.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean11.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean11.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean11.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean11.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean11.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean11.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean11.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean12 = resultBeanLst.get(12);

        exStringEquals(resultBean12.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean12.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean12.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean12.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean12.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean12.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean12.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean12.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean12.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean13 = resultBeanLst.get(13);

        exStringEquals(resultBean13.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean13.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean13.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean13.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean13.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean13.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean13.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean13.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean13.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean14 = resultBeanLst.get(14);

        exStringEquals(resultBean14.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean14.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean14.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean14.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean14.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean14.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean14.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean14.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean14.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean15 = resultBeanLst.get(15);

        exStringEquals(resultBean15.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean15.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean15.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean15.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean15.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean15.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean15.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean15.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean15.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean16 = resultBeanLst.get(16);

        exStringEquals(resultBean16.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean16.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean16.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean16.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean16.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean16.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean16.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean16.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean16.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean17 = resultBeanLst.get(17);

        exStringEquals(resultBean17.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean17.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean17.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean17.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean17.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean17.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean17.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean17.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean17.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean18 = resultBeanLst.get(18);

        exStringEquals(resultBean18.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean18.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean18.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean18.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean18.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean18.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean18.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean18.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean18.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean19 = resultBeanLst.get(19);

        exStringEquals(resultBean19.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean19.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean19.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean19.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean19.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean19.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean19.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean19.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean19.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean20 = resultBeanLst.get(20);

        exStringEquals(resultBean20.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean20.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean20.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean20.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean20.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean20.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean20.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean20.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean20.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean21 = resultBeanLst.get(21);

        exStringEquals(resultBean21.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean21.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean21.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean21.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean21.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean21.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean21.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean21.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean21.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean22 = resultBeanLst.get(22);

        exStringEquals(resultBean22.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean22.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean22.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean22.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean22.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean22.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean22.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean22.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean22.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean23 = resultBeanLst.get(23);

        exStringEquals(resultBean23.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean23.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean23.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean23.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean23.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean23.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean23.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean23.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean23.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean24 = resultBeanLst.get(24);

        exStringEquals(resultBean24.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean24.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean24.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean24.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean24.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean24.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean24.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean24.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean24.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean25 = resultBeanLst.get(25);

        exStringEquals(resultBean25.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean25.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean25.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean25.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean25.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean25.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean25.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean25.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean25.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean26 = resultBeanLst.get(26);

        exStringEquals(resultBean26.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean26.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean26.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean26.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean26.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean26.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean26.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean26.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean26.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean27 = resultBeanLst.get(27);

        exStringEquals(resultBean27.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean27.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean27.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean27.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean27.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean27.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean27.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean27.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean27.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean28 = resultBeanLst.get(28);

        exStringEquals(resultBean28.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean28.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean28.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean28.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean28.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean28.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean28.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean28.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean28.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean29 = resultBeanLst.get(29);

        exStringEquals(resultBean29.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean29.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean29.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean29.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean29.getImageId(), "", "イメージID");

        exStringEquals(resultBean29.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean29.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean29.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean29.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean30 = resultBeanLst.get(30);

        exStringEquals(resultBean30.getSyoruiNnm(), "第三者受取報告書", "取込書類名");

        exStringEquals(resultBean30.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean30.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean30.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean30.getImageId(), "", "イメージID");

        exStringEquals(resultBean30.getTorikomiSyoruiCd(), "sk009", "取込書類コード");

        exStringEquals(resultBean30.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean30.getKouteikanriId(), "sk009", "工程管理ＩＤ");

        exNumericEquals(resultBean30.getSortNo(), 90, "ソート番号");


        SyoruiJohoItiranBean resultBean31 = resultBeanLst.get(31);

        exStringEquals(resultBean31.getSyoruiNnm(), "ＦＡＴＣＡ確認書", "取込書類名");

        exStringEquals(resultBean31.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean31.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean31.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean31.getImageId(), "", "イメージID");

        exStringEquals(resultBean31.getTorikomiSyoruiCd(), "sk010", "取込書類コード");

        exStringEquals(resultBean31.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean31.getKouteikanriId(), "sk010", "工程管理ＩＤ");

        exNumericEquals(resultBean31.getSortNo(), 100, "ソート番号");


        SyoruiJohoItiranBean resultBean32 = resultBeanLst.get(32);

        exStringEquals(resultBean32.getSyoruiNnm(), "取扱報告書", "取込書類名");

        exStringEquals(resultBean32.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean32.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean32.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean32.getImageId(), "", "イメージID");

        exStringEquals(resultBean32.getTorikomiSyoruiCd(), "sk011", "取込書類コード");

        exStringEquals(resultBean32.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean32.getKouteikanriId(), "sk011", "工程管理ＩＤ");

        exNumericEquals(resultBean32.getSortNo(), 110, "ソート番号");


        SyoruiJohoItiranBean resultBean33 = resultBeanLst.get(33);

        exStringEquals(resultBean33.getSyoruiNnm(), "ペーパーレス取扱報告書", "取込書類名");

        exStringEquals(resultBean33.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean33.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean33.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean33.getImageId(), "", "イメージID");

        exStringEquals(resultBean33.getTorikomiSyoruiCd(), "sk012", "取込書類コード");

        exStringEquals(resultBean33.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean33.getKouteikanriId(), "sk012", "工程管理ＩＤ");

        exNumericEquals(resultBean33.getSortNo(), 120, "ソート番号");


        SyoruiJohoItiranBean resultBean34 = resultBeanLst.get(34);

        exStringEquals(resultBean34.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean34.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean34.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean34.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean34.getImageId(), "", "イメージID");

        exStringEquals(resultBean34.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean34.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean34.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean34.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean35 = resultBeanLst.get(35);

        exStringEquals(resultBean35.getSyoruiNnm(), "変更訂正書", "取込書類名");

        exStringEquals(resultBean35.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean35.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean35.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean35.getImageId(), "", "イメージID");

        exStringEquals(resultBean35.getTorikomiSyoruiCd(), "sk014", "取込書類コード");

        exStringEquals(resultBean35.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean35.getKouteikanriId(), "sk014", "工程管理ＩＤ");

        exNumericEquals(resultBean35.getSortNo(), 140, "ソート番号");


        SyoruiJohoItiranBean resultBean36 = resultBeanLst.get(36);

        exStringEquals(resultBean36.getSyoruiNnm(), "不備通知書", "取込書類名");

        exStringEquals(resultBean36.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean36.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean36.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean36.getImageId(), "", "イメージID");

        exStringEquals(resultBean36.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(resultBean36.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean36.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exNumericEquals(resultBean36.getSortNo(), 150, "ソート番号");


        SyoruiJohoItiranBean resultBean37 = resultBeanLst.get(37);

        exStringEquals(resultBean37.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean37.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean37.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean37.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean37.getImageId(), "", "イメージID");

        exStringEquals(resultBean37.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean37.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean37.getKouteikanriId(), "sk033", "工程管理ＩＤ");

        exNumericEquals(resultBean37.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean38 = resultBeanLst.get(38);

        exStringEquals(resultBean38.getSyoruiNnm(), "契約確認回答書", "取込書類名");

        exStringEquals(resultBean38.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean38.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean38.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean38.getImageId(), "", "イメージID");

        exStringEquals(resultBean38.getTorikomiSyoruiCd(), "sk034", "取込書類コード");

        exStringEquals(resultBean38.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean38.getKouteikanriId(), "sk034", "工程管理ＩＤ");

        exNumericEquals(resultBean38.getSortNo(), 170, "ソート番号");


        SyoruiJohoItiranBean resultBean39 = resultBeanLst.get(39);

        exStringEquals(resultBean39.getSyoruiNnm(), "取消請求書", "取込書類名");

        exStringEquals(resultBean39.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean39.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean39.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean39.getImageId(), "", "イメージID");

        exStringEquals(resultBean39.getTorikomiSyoruiCd(), "sk038", "取込書類コード");

        exStringEquals(resultBean39.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean39.getKouteikanriId(), "sk038", "工程管理ＩＤ");

        exNumericEquals(resultBean39.getSortNo(), 180, "ソート番号");


        SyoruiJohoItiranBean resultBean40 = resultBeanLst.get(40);

        exStringEquals(resultBean40.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean40.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean40.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean40.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean40.getImageId(), "", "イメージID");

        exStringEquals(resultBean40.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean40.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean40.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean40.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean41 = resultBeanLst.get(41);

        exStringEquals(resultBean41.getSyoruiNnm(), "生命保険料支払申込書", "取込書類名");

        exStringEquals(resultBean41.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean41.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean41.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean41.getImageId(), "", "イメージID");

        exStringEquals(resultBean41.getTorikomiSyoruiCd(), "sk016", "取込書類コード");

        exStringEquals(resultBean41.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean41.getKouteikanriId(), "sk016", "工程管理ＩＤ");

        exNumericEquals(resultBean41.getSortNo(), 210, "ソート番号");


        SyoruiJohoItiranBean resultBean42 = resultBeanLst.get(42);

        exStringEquals(resultBean42.getSyoruiNnm(), "代筆報告書", "取込書類名");

        exStringEquals(resultBean42.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean42.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean42.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean42.getImageId(), "", "イメージID");

        exStringEquals(resultBean42.getTorikomiSyoruiCd(), "sk017", "取込書類コード");

        exStringEquals(resultBean42.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean42.getKouteikanriId(), "sk017", "工程管理ＩＤ");

        exNumericEquals(resultBean42.getSortNo(), 220, "ソート番号");


        SyoruiJohoItiranBean resultBean43 = resultBeanLst.get(43);

        exStringEquals(resultBean43.getSyoruiNnm(), "契約内容登録制度照会票", "取込書類名");

        exStringEquals(resultBean43.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean43.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean43.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean43.getImageId(), "", "イメージID");

        exStringEquals(resultBean43.getTorikomiSyoruiCd(), "sk046", "取込書類コード");

        exStringEquals(resultBean43.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean43.getKouteikanriId(), "sk046", "工程管理ＩＤ");

        exNumericEquals(resultBean43.getSortNo(), 230, "ソート番号");


        SyoruiJohoItiranBean resultBean44 = resultBeanLst.get(44);

        exStringEquals(resultBean44.getSyoruiNnm(), "非対面チェックシート", "取込書類名");

        exStringEquals(resultBean44.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean44.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean44.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean44.getImageId(), "", "イメージID");

        exStringEquals(resultBean44.getTorikomiSyoruiCd(), "sk018", "取込書類コード");

        exStringEquals(resultBean44.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean44.getKouteikanriId(), "sk018", "工程管理ＩＤ");

        exNumericEquals(resultBean44.getSortNo(), 240, "ソート番号");


    }

    @Test
    @TestOrder(70)
    public void testGetSyoruiJouhouItiranBetu_A7() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKKANKYOUSATEI);

        IwfImageClientMockForBiz.mode = "qs-10";

        String[] kouteikanriId = new String[23];

        kouteikanriId[0] = "sk001";
        kouteikanriId[1] = "sk007";
        kouteikanriId[2] = "sk008";
        kouteikanriId[3] = "sk009";
        kouteikanriId[4] = "sk005";
        kouteikanriId[5] = "sk011";
        kouteikanriId[6] = "sk006";
        kouteikanriId[7] = "sk010";
        kouteikanriId[8] = "sk033";
        kouteikanriId[9] = "sk034";
        kouteikanriId[10] = "sk003";
        kouteikanriId[11] = "sk032";
        kouteikanriId[12] = "sk014";
        kouteikanriId[13] = "sk013";
        kouteikanriId[14] = "sk071";
        kouteikanriId[15] = "sk038";
        kouteikanriId[16] = "sk002";
        kouteikanriId[17] = "sk004";
        kouteikanriId[18] = "sk012";
        kouteikanriId[19] = "sk016";
        kouteikanriId[20] = "sk017";
        kouteikanriId[21] = "sk046";
        kouteikanriId[22] = "sk018";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        exStringEquals(outBean.getSyorikekkaStatus(), "0", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), null, "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), null, "詳細メッセージ");

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 45, "書類情報一覧Beanリスト件数");


        SyoruiJohoItiranBean resultBean0 = resultBeanLst.get(0);

        exStringEquals(resultBean0.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean0.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean0.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean0.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean0.getImageId(), "", "イメージID");

        exStringEquals(resultBean0.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean0.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean0.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean0.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean1 = resultBeanLst.get(1);

        exStringEquals(resultBean1.getSyoruiNnm(), "ペーパーレス申込書兼意向確認書", "取込書類名");

        exStringEquals(resultBean1.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean1.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean1.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean1.getImageId(), "", "イメージID");

        exStringEquals(resultBean1.getTorikomiSyoruiCd(), "sk002", "取込書類コード");

        exStringEquals(resultBean1.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean1.getKouteikanriId(), "sk002", "工程管理ＩＤ");

        exNumericEquals(resultBean1.getSortNo(), 20, "ソート番号");


        SyoruiJohoItiranBean resultBean2 = resultBeanLst.get(2);

        exStringEquals(resultBean2.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean2.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean2.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean2.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean2.getImageId(), "", "イメージID");

        exStringEquals(resultBean2.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean2.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean2.getKouteikanriId(), "sk003", "工程管理ＩＤ");

        exNumericEquals(resultBean2.getSortNo(), 30, "ソート番号");


        SyoruiJohoItiranBean resultBean3 = resultBeanLst.get(3);

        exStringEquals(resultBean3.getSyoruiNnm(), "ペーパーレス告知書", "取込書類名");

        exStringEquals(resultBean3.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean3.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean3.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean3.getImageId(), "", "イメージID");

        exStringEquals(resultBean3.getTorikomiSyoruiCd(), "sk004", "取込書類コード");

        exStringEquals(resultBean3.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean3.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean3.getSortNo(), 40, "ソート番号");


        SyoruiJohoItiranBean resultBean4 = resultBeanLst.get(4);

        exStringEquals(resultBean4.getSyoruiNnm(), "意向確認書", "取込書類名");

        exStringEquals(resultBean4.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean4.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean4.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean4.getImageId(), "", "イメージID");

        exStringEquals(resultBean4.getTorikomiSyoruiCd(), "sk005", "取込書類コード");

        exStringEquals(resultBean4.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean4.getKouteikanriId(), "sk005", "工程管理ＩＤ");

        exNumericEquals(resultBean4.getSortNo(), 50, "ソート番号");


        SyoruiJohoItiranBean resultBean5 = resultBeanLst.get(5);

        exStringEquals(resultBean5.getSyoruiNnm(), "意向確認書（訂正用）", "取込書類名");

        exStringEquals(resultBean5.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean5.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean5.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean5.getImageId(), "", "イメージID");

        exStringEquals(resultBean5.getTorikomiSyoruiCd(), "sk006", "取込書類コード");

        exStringEquals(resultBean5.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean5.getKouteikanriId(), "sk006", "工程管理ＩＤ");

        exNumericEquals(resultBean5.getSortNo(), 60, "ソート番号");


        SyoruiJohoItiranBean resultBean6 = resultBeanLst.get(6);

        exStringEquals(resultBean6.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean6.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean6.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean6.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean6.getImageId(), "", "イメージID");

        exStringEquals(resultBean6.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean6.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean6.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean6.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean7 = resultBeanLst.get(7);

        exStringEquals(resultBean7.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean7.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean7.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean7.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean7.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean7.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean7.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean7.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean7.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean8 = resultBeanLst.get(8);

        exStringEquals(resultBean8.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean8.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean8.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean8.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean8.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean8.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean8.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean8.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean8.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean9 = resultBeanLst.get(9);

        exStringEquals(resultBean9.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean9.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean9.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean9.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean9.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean9.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean9.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean9.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean9.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean10 = resultBeanLst.get(10);

        exStringEquals(resultBean10.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean10.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean10.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean10.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean10.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean10.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean10.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean10.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean10.getSortNo(), 80, "ソート番号");



        SyoruiJohoItiranBean resultBean11 = resultBeanLst.get(11);

        exStringEquals(resultBean11.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean11.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean11.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean11.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean11.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean11.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean11.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean11.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean11.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean12 = resultBeanLst.get(12);

        exStringEquals(resultBean12.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean12.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean12.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean12.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean12.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean12.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean12.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean12.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean12.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean13 = resultBeanLst.get(13);

        exStringEquals(resultBean13.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean13.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean13.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean13.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean13.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean13.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean13.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean13.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean13.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean14 = resultBeanLst.get(14);

        exStringEquals(resultBean14.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean14.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean14.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean14.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean14.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean14.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean14.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean14.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean14.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean15 = resultBeanLst.get(15);

        exStringEquals(resultBean15.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean15.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean15.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean15.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean15.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean15.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean15.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean15.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean15.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean16 = resultBeanLst.get(16);

        exStringEquals(resultBean16.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean16.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean16.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean16.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean16.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean16.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean16.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean16.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean16.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean17 = resultBeanLst.get(17);

        exStringEquals(resultBean17.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean17.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean17.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean17.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean17.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean17.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean17.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean17.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean17.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean18 = resultBeanLst.get(18);

        exStringEquals(resultBean18.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean18.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean18.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean18.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean18.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean18.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean18.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean18.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean18.getSortNo(), 80, "ソート番号");



        SyoruiJohoItiranBean resultBean19 = resultBeanLst.get(19);

        exStringEquals(resultBean19.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean19.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean19.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean19.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean19.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean19.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean19.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean19.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean19.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean20 = resultBeanLst.get(20);

        exStringEquals(resultBean20.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean20.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean20.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean20.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean20.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean20.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean20.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean20.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean20.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean21 = resultBeanLst.get(21);

        exStringEquals(resultBean21.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean21.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean21.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean21.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean21.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean21.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean21.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean21.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean21.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean22 = resultBeanLst.get(22);

        exStringEquals(resultBean22.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean22.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean22.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean22.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean22.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean22.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean22.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean22.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean22.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean23 = resultBeanLst.get(23);

        exStringEquals(resultBean23.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean23.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean23.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean23.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean23.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean23.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean23.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean23.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean23.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean24 = resultBeanLst.get(24);

        exStringEquals(resultBean24.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean24.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean24.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean24.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean24.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean24.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean24.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean24.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean24.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean25 = resultBeanLst.get(25);

        exStringEquals(resultBean25.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean25.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean25.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean25.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean25.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean25.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean25.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean25.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean25.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean26 = resultBeanLst.get(26);

        exStringEquals(resultBean26.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean26.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean26.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean26.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean26.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean26.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean26.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean26.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean26.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean27 = resultBeanLst.get(27);

        exStringEquals(resultBean27.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean27.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean27.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean27.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean27.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean27.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean27.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean27.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean27.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean28 = resultBeanLst.get(28);

        exStringEquals(resultBean28.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean28.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean28.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean28.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean28.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean28.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean28.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean28.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean28.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean29 = resultBeanLst.get(29);

        exStringEquals(resultBean29.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean29.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean29.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean29.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean29.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean29.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean29.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean29.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean29.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean30 = resultBeanLst.get(30);

        exStringEquals(resultBean30.getSyoruiNnm(), "第三者受取報告書", "取込書類名");

        exStringEquals(resultBean30.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean30.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean30.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean30.getImageId(), "", "イメージID");

        exStringEquals(resultBean30.getTorikomiSyoruiCd(), "sk009", "取込書類コード");

        exStringEquals(resultBean30.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean30.getKouteikanriId(), "sk009", "工程管理ＩＤ");

        exNumericEquals(resultBean30.getSortNo(), 90, "ソート番号");


        SyoruiJohoItiranBean resultBean31 = resultBeanLst.get(31);

        exStringEquals(resultBean31.getSyoruiNnm(), "ＦＡＴＣＡ確認書", "取込書類名");

        exStringEquals(resultBean31.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean31.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean31.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean31.getImageId(), "", "イメージID");

        exStringEquals(resultBean31.getTorikomiSyoruiCd(), "sk010", "取込書類コード");

        exStringEquals(resultBean31.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean31.getKouteikanriId(), "sk010", "工程管理ＩＤ");

        exNumericEquals(resultBean31.getSortNo(), 100, "ソート番号");


        SyoruiJohoItiranBean resultBean32 = resultBeanLst.get(32);

        exStringEquals(resultBean32.getSyoruiNnm(), "取扱報告書", "取込書類名");

        exStringEquals(resultBean32.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean32.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean32.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean32.getImageId(), "", "イメージID");

        exStringEquals(resultBean32.getTorikomiSyoruiCd(), "sk011", "取込書類コード");

        exStringEquals(resultBean32.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean32.getKouteikanriId(), "sk011", "工程管理ＩＤ");

        exNumericEquals(resultBean32.getSortNo(), 110, "ソート番号");


        SyoruiJohoItiranBean resultBean33 = resultBeanLst.get(33);

        exStringEquals(resultBean33.getSyoruiNnm(), "ペーパーレス取扱報告書", "取込書類名");

        exStringEquals(resultBean33.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean33.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean33.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean33.getImageId(), "", "イメージID");

        exStringEquals(resultBean33.getTorikomiSyoruiCd(), "sk012", "取込書類コード");

        exStringEquals(resultBean33.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean33.getKouteikanriId(), "sk012", "工程管理ＩＤ");

        exNumericEquals(resultBean33.getSortNo(), 120, "ソート番号");


        SyoruiJohoItiranBean resultBean34 = resultBeanLst.get(34);

        exStringEquals(resultBean34.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean34.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean34.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean34.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean34.getImageId(), "", "イメージID");

        exStringEquals(resultBean34.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean34.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean34.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean34.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean35 = resultBeanLst.get(35);

        exStringEquals(resultBean35.getSyoruiNnm(), "変更訂正書", "取込書類名");

        exStringEquals(resultBean35.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean35.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean35.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean35.getImageId(), "", "イメージID");

        exStringEquals(resultBean35.getTorikomiSyoruiCd(), "sk014", "取込書類コード");

        exStringEquals(resultBean35.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean35.getKouteikanriId(), "sk014", "工程管理ＩＤ");

        exNumericEquals(resultBean35.getSortNo(), 140, "ソート番号");


        SyoruiJohoItiranBean resultBean36 = resultBeanLst.get(36);

        exStringEquals(resultBean36.getSyoruiNnm(), "不備通知書", "取込書類名");

        exStringEquals(resultBean36.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean36.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean36.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean36.getImageId(), "", "イメージID");

        exStringEquals(resultBean36.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(resultBean36.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean36.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exNumericEquals(resultBean36.getSortNo(), 150, "ソート番号");


        SyoruiJohoItiranBean resultBean37 = resultBeanLst.get(37);

        exStringEquals(resultBean37.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean37.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean37.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean37.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean37.getImageId(), "", "イメージID");

        exStringEquals(resultBean37.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean37.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean37.getKouteikanriId(), "sk033", "工程管理ＩＤ");

        exNumericEquals(resultBean37.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean38 = resultBeanLst.get(38);

        exStringEquals(resultBean38.getSyoruiNnm(), "契約確認回答書", "取込書類名");

        exStringEquals(resultBean38.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean38.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean38.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean38.getImageId(), "", "イメージID");

        exStringEquals(resultBean38.getTorikomiSyoruiCd(), "sk034", "取込書類コード");

        exStringEquals(resultBean38.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean38.getKouteikanriId(), "sk034", "工程管理ＩＤ");

        exNumericEquals(resultBean38.getSortNo(), 170, "ソート番号");


        SyoruiJohoItiranBean resultBean39 = resultBeanLst.get(39);

        exStringEquals(resultBean39.getSyoruiNnm(), "取消請求書", "取込書類名");

        exStringEquals(resultBean39.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean39.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean39.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean39.getImageId(), "", "イメージID");

        exStringEquals(resultBean39.getTorikomiSyoruiCd(), "sk038", "取込書類コード");

        exStringEquals(resultBean39.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean39.getKouteikanriId(), "sk038", "工程管理ＩＤ");

        exNumericEquals(resultBean39.getSortNo(), 180, "ソート番号");


        SyoruiJohoItiranBean resultBean40 = resultBeanLst.get(40);

        exStringEquals(resultBean40.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean40.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean40.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean40.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean40.getImageId(), "", "イメージID");

        exStringEquals(resultBean40.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean40.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean40.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean40.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean41 = resultBeanLst.get(41);

        exStringEquals(resultBean41.getSyoruiNnm(), "生命保険料支払申込書", "取込書類名");

        exStringEquals(resultBean41.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean41.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean41.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean41.getImageId(), "", "イメージID");

        exStringEquals(resultBean41.getTorikomiSyoruiCd(), "sk016", "取込書類コード");

        exStringEquals(resultBean41.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean41.getKouteikanriId(), "sk016", "工程管理ＩＤ");

        exNumericEquals(resultBean41.getSortNo(), 210, "ソート番号");


        SyoruiJohoItiranBean resultBean42 = resultBeanLst.get(42);

        exStringEquals(resultBean42.getSyoruiNnm(), "代筆報告書", "取込書類名");

        exStringEquals(resultBean42.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean42.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean42.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean42.getImageId(), "", "イメージID");

        exStringEquals(resultBean42.getTorikomiSyoruiCd(), "sk017", "取込書類コード");

        exStringEquals(resultBean42.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean42.getKouteikanriId(), "sk017", "工程管理ＩＤ");

        exNumericEquals(resultBean42.getSortNo(), 220, "ソート番号");


        SyoruiJohoItiranBean resultBean43 = resultBeanLst.get(43);

        exStringEquals(resultBean43.getSyoruiNnm(), "契約内容登録制度照会票", "取込書類名");

        exStringEquals(resultBean43.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean43.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean43.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean43.getImageId(), "", "イメージID");

        exStringEquals(resultBean43.getTorikomiSyoruiCd(), "sk046", "取込書類コード");

        exStringEquals(resultBean43.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean43.getKouteikanriId(), "sk046", "工程管理ＩＤ");

        exNumericEquals(resultBean43.getSortNo(), 230, "ソート番号");


        SyoruiJohoItiranBean resultBean44 = resultBeanLst.get(44);

        exStringEquals(resultBean44.getSyoruiNnm(), "非対面チェックシート", "取込書類名");

        exStringEquals(resultBean44.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean44.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean44.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean44.getImageId(), "", "イメージID");

        exStringEquals(resultBean44.getTorikomiSyoruiCd(), "sk018", "取込書類コード");

        exStringEquals(resultBean44.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean44.getKouteikanriId(), "sk018", "工程管理ＩＤ");

        exNumericEquals(resultBean44.getSortNo(), 240, "ソート番号");

    }

    @Test
    @TestOrder(80)
    public void testGetSyoruiJouhouItiranBetu_A8() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKIMUSATEI);

        IwfImageClientMockForBiz.mode = "qs-11";

        String[] kouteikanriId = new String[10];

        kouteikanriId[0] = "sk001";
        kouteikanriId[1] = "sk011";
        kouteikanriId[2] = "sk006";
        kouteikanriId[3] = "sk034";
        kouteikanriId[4] = "sk003";
        kouteikanriId[5] = "sk032";
        kouteikanriId[6] = "sk014";
        kouteikanriId[7] = "sk013";
        kouteikanriId[8] = "sk002";
        kouteikanriId[9] = "sk004";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);


        exStringEquals(outBean.getSyorikekkaStatus(), "0", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), null, "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), null, "詳細メッセージ");

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 19, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean resultBean0 = resultBeanLst.get(0);

        exStringEquals(resultBean0.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean0.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean0.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean0.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean0.getImageId(), "", "イメージID");

        exStringEquals(resultBean0.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean0.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean0.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean0.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean1 = resultBeanLst.get(1);

        exStringEquals(resultBean1.getSyoruiNnm(), "ペーパーレス申込書兼意向確認書", "取込書類名");

        exStringEquals(resultBean1.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean1.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean1.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean1.getImageId(), "", "イメージID");

        exStringEquals(resultBean1.getTorikomiSyoruiCd(), "sk002", "取込書類コード");

        exStringEquals(resultBean1.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean1.getKouteikanriId(), "sk002", "工程管理ＩＤ");

        exNumericEquals(resultBean1.getSortNo(), 20, "ソート番号");


        SyoruiJohoItiranBean resultBean2 = resultBeanLst.get(2);

        exStringEquals(resultBean2.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean2.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean2.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean2.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean2.getImageId(), "", "イメージID");

        exStringEquals(resultBean2.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean2.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean2.getKouteikanriId(), "sk003", "工程管理ＩＤ");

        exNumericEquals(resultBean2.getSortNo(), 30, "ソート番号");


        SyoruiJohoItiranBean resultBean3 = resultBeanLst.get(3);

        exStringEquals(resultBean3.getSyoruiNnm(), "ペーパーレス告知書", "取込書類名");

        exStringEquals(resultBean3.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean3.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean3.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean3.getImageId(), "", "イメージID");

        exStringEquals(resultBean3.getTorikomiSyoruiCd(), "sk004", "取込書類コード");

        exStringEquals(resultBean3.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean3.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean3.getSortNo(), 40, "ソート番号");


        SyoruiJohoItiranBean resultBean4 = resultBeanLst.get(4);

        exStringEquals(resultBean4.getSyoruiNnm(), "意向確認書（訂正用）", "取込書類名");

        exStringEquals(resultBean4.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean4.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean4.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean4.getImageId(), "", "イメージID");

        exStringEquals(resultBean4.getTorikomiSyoruiCd(), "sk006", "取込書類コード");

        exStringEquals(resultBean4.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean4.getKouteikanriId(), "sk006", "工程管理ＩＤ");

        exNumericEquals(resultBean4.getSortNo(), 60, "ソート番号");


        SyoruiJohoItiranBean resultBean5 = resultBeanLst.get(5);

        exStringEquals(resultBean5.getSyoruiNnm(), "取扱報告書", "取込書類名");

        exStringEquals(resultBean5.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean5.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean5.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean5.getImageId(), "", "イメージID");

        exStringEquals(resultBean5.getTorikomiSyoruiCd(), "sk011", "取込書類コード");

        exStringEquals(resultBean5.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean5.getKouteikanriId(), "sk011", "工程管理ＩＤ");

        exNumericEquals(resultBean5.getSortNo(), 110, "ソート番号");


        SyoruiJohoItiranBean resultBean6 = resultBeanLst.get(6);

        exStringEquals(resultBean6.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean6.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean6.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean6.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean6.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean6.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean6.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean6.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean6.getSortNo(), 130, "ソート番号");



        SyoruiJohoItiranBean resultBean7 = resultBeanLst.get(7);

        exStringEquals(resultBean7.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean7.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean7.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean7.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean7.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean7.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean7.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean7.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean7.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean8 = resultBeanLst.get(8);

        exStringEquals(resultBean8.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean8.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean8.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean8.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean8.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean8.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean8.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean8.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean8.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean9 = resultBeanLst.get(9);

        exStringEquals(resultBean9.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean9.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean9.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean9.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean9.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean9.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean9.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean9.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean9.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean10 = resultBeanLst.get(10);

        exStringEquals(resultBean10.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean10.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean10.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean10.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean10.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean10.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean10.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean10.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean10.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean11 = resultBeanLst.get(11);

        exStringEquals(resultBean11.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean11.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean11.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean11.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean11.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean11.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean11.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean11.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean11.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean12 = resultBeanLst.get(12);

        exStringEquals(resultBean12.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean12.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean12.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean12.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean12.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean12.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean12.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean12.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean12.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean13 = resultBeanLst.get(13);

        exStringEquals(resultBean13.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean13.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean13.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean13.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean13.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean13.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean13.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean13.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean13.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean14 = resultBeanLst.get(14);

        exStringEquals(resultBean14.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean14.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean14.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean14.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean14.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean14.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean14.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean14.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean14.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean15 = resultBeanLst.get(15);

        exStringEquals(resultBean15.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean15.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean15.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean15.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean15.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean15.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean15.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean15.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean15.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean16 = resultBeanLst.get(16);

        exStringEquals(resultBean16.getSyoruiNnm(), "変更訂正書", "取込書類名");

        exStringEquals(resultBean16.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean16.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean16.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean16.getImageId(), "", "イメージID");

        exStringEquals(resultBean16.getTorikomiSyoruiCd(), "sk014", "取込書類コード");

        exStringEquals(resultBean16.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean16.getKouteikanriId(), "sk014", "工程管理ＩＤ");

        exNumericEquals(resultBean16.getSortNo(), 140, "ソート番号");


        SyoruiJohoItiranBean resultBean17 = resultBeanLst.get(17);

        exStringEquals(resultBean17.getSyoruiNnm(), "不備通知書", "取込書類名");

        exStringEquals(resultBean17.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean17.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean17.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean17.getImageId(), "", "イメージID");

        exStringEquals(resultBean17.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(resultBean17.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean17.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exNumericEquals(resultBean17.getSortNo(), 150, "ソート番号");


        SyoruiJohoItiranBean resultBean18 = resultBeanLst.get(18);

        exStringEquals(resultBean18.getSyoruiNnm(), "契約確認回答書", "取込書類名");

        exStringEquals(resultBean18.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean18.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean18.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean18.getImageId(), "", "イメージID");

        exStringEquals(resultBean18.getTorikomiSyoruiCd(), "sk034", "取込書類コード");

        exStringEquals(resultBean18.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean18.getKouteikanriId(), "sk034", "工程管理ＩＤ");

        exNumericEquals(resultBean18.getSortNo(), 170, "ソート番号");


    }

    @Test
    @TestOrder(90)
    public void testGetSyoruiJouhouItiranBetu_A9() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKKEIYAKUKAKUNINKEKKA);

        IwfImageClientMockForBiz.mode = "qs-12";

        String[] kouteikanriId = new String[6];

        kouteikanriId[0] = "sk033";
        kouteikanriId[1] = "sk034";
        kouteikanriId[2] = "sk032";
        kouteikanriId[3] = "sk014";
        kouteikanriId[4] = "sk013";
        kouteikanriId[5] = "sk046";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        exStringEquals(outBean.getSyorikekkaStatus(), "0", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), null, "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), null, "詳細メッセージ");

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 18, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean resultBean0 = resultBeanLst.get(0);

        exStringEquals(resultBean0.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean0.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean0.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean0.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean0.getImageId(), "", "イメージID");

        exStringEquals(resultBean0.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean0.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean0.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean0.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean1 = resultBeanLst.get(1);

        exStringEquals(resultBean1.getSyoruiNnm(), "変更訂正書", "取込書類名");

        exStringEquals(resultBean1.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean1.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean1.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean1.getImageId(), "", "イメージID");

        exStringEquals(resultBean1.getTorikomiSyoruiCd(), "sk014", "取込書類コード");

        exStringEquals(resultBean1.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean1.getKouteikanriId(), "sk014", "工程管理ＩＤ");

        exNumericEquals(resultBean1.getSortNo(), 140, "ソート番号");


        SyoruiJohoItiranBean resultBean2 = resultBeanLst.get(2);

        exStringEquals(resultBean2.getSyoruiNnm(), "不備通知書", "取込書類名");

        exStringEquals(resultBean2.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean2.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean2.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean2.getImageId(), "", "イメージID");

        exStringEquals(resultBean2.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(resultBean2.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean2.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exNumericEquals(resultBean2.getSortNo(), 150, "ソート番号");


        SyoruiJohoItiranBean resultBean3 = resultBeanLst.get(3);

        exStringEquals(resultBean3.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean3.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean3.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean3.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean3.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean3.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean3.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean3.getKouteikanriId(), "gyoumukey2", "工程管理ＩＤ");

        exNumericEquals(resultBean3.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean4 = resultBeanLst.get(4);

        exStringEquals(resultBean4.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean4.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean4.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean4.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean4.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean4.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean4.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean4.getKouteikanriId(), "gyoumukey2", "工程管理ＩＤ");

        exNumericEquals(resultBean4.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean5 = resultBeanLst.get(5);

        exStringEquals(resultBean5.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean5.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean5.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean5.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean5.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean5.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean5.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean5.getKouteikanriId(), "gyoumukey2", "工程管理ＩＤ");

        exNumericEquals(resultBean5.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean6 = resultBeanLst.get(6);

        exStringEquals(resultBean6.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean6.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean6.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean6.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean6.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean6.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean6.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean6.getKouteikanriId(), "gyoumukey2", "工程管理ＩＤ");

        exNumericEquals(resultBean6.getSortNo(), 160, "ソート番号");



        SyoruiJohoItiranBean resultBean7 = resultBeanLst.get(7);

        exStringEquals(resultBean7.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean7.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean7.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean7.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean7.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean7.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean7.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean7.getKouteikanriId(), "gyoumukey2", "工程管理ＩＤ");

        exNumericEquals(resultBean7.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean8 = resultBeanLst.get(8);

        exStringEquals(resultBean8.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean8.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean8.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean8.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean8.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean8.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean8.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean8.getKouteikanriId(), "gyoumukey2", "工程管理ＩＤ");

        exNumericEquals(resultBean8.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean9 = resultBeanLst.get(9);

        exStringEquals(resultBean9.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean9.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exStringEquals(resultBean9.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean9.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean9.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean9.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean9.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean9.getKouteikanriId(), "gyoumukey1", "工程管理ＩＤ");

        exNumericEquals(resultBean9.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean10 = resultBeanLst.get(10);

        exStringEquals(resultBean10.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean10.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exStringEquals(resultBean10.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean10.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean10.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean10.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean10.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean10.getKouteikanriId(), "gyoumukey1", "工程管理ＩＤ");

        exNumericEquals(resultBean10.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean11 = resultBeanLst.get(11);

        exStringEquals(resultBean11.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean11.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exStringEquals(resultBean11.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean11.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean11.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean11.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean11.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean11.getKouteikanriId(), "gyoumukey1", "工程管理ＩＤ");

        exNumericEquals(resultBean11.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean12 = resultBeanLst.get(12);

        exStringEquals(resultBean12.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean12.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exStringEquals(resultBean12.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean12.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean12.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean12.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean12.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean12.getKouteikanriId(), "gyoumukey1", "工程管理ＩＤ");

        exNumericEquals(resultBean12.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean13 = resultBeanLst.get(13);

        exStringEquals(resultBean13.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean13.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exStringEquals(resultBean13.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean13.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean13.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean13.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean13.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean13.getKouteikanriId(), "gyoumukey1", "工程管理ＩＤ");

        exNumericEquals(resultBean13.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean14 = resultBeanLst.get(14);

        exStringEquals(resultBean14.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean14.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exStringEquals(resultBean14.getHituyouSyorui(), "", "書類名");

        exStringEquals(resultBean14.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean14.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean14.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean14.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean14.getKouteikanriId(), "gyoumukey1", "工程管理ＩＤ");

        exNumericEquals(resultBean14.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean15 = resultBeanLst.get(15);

        exStringEquals(resultBean15.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean15.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean15.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean15.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean15.getImageId(), "", "イメージID");

        exStringEquals(resultBean15.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean15.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean15.getKouteikanriId(), "sk033", "工程管理ＩＤ");

        exNumericEquals(resultBean15.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean16 = resultBeanLst.get(16);

        exStringEquals(resultBean16.getSyoruiNnm(), "契約確認回答書", "取込書類名");

        exStringEquals(resultBean16.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean16.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean16.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean16.getImageId(), "", "イメージID");

        exStringEquals(resultBean16.getTorikomiSyoruiCd(), "sk034", "取込書類コード");

        exStringEquals(resultBean16.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean16.getKouteikanriId(), "sk034", "工程管理ＩＤ");

        exNumericEquals(resultBean16.getSortNo(), 170, "ソート番号");


        SyoruiJohoItiranBean resultBean17 = resultBeanLst.get(17);

        exStringEquals(resultBean17.getSyoruiNnm(), "契約内容登録制度照会票", "取込書類名");

        exStringEquals(resultBean17.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean17.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean17.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean17.getImageId(), "", "イメージID");

        exStringEquals(resultBean17.getTorikomiSyoruiCd(), "sk046", "取込書類コード");

        exStringEquals(resultBean17.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean17.getKouteikanriId(), "sk046", "工程管理ＩＤ");

        exNumericEquals(resultBean17.getSortNo(), 230, "ソート番号");

    }

    @Test
    @TestOrder(100)
    public void testGetSyoruiJouhouItiranBetu_A10() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKHENKIN);

        IwfImageClientMockForBiz.mode = "qs-13";

        String[] kouteikanriId = new String[7];

        kouteikanriId[0] = "sk032";
        kouteikanriId[1] = "sk014";
        kouteikanriId[2] = "sk013";
        kouteikanriId[3] = "sk071";
        kouteikanriId[4] = "sk038";
        kouteikanriId[5] = "sk016";
        kouteikanriId[6] = "sk046";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        exStringEquals(outBean.getSyorikekkaStatus(), "0", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), null, "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), null, "詳細メッセージ");

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 7, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean resultBean0 = resultBeanLst.get(0);

        exStringEquals(resultBean0.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean0.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean0.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean0.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean0.getImageId(), "", "イメージID");

        exStringEquals(resultBean0.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean0.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean0.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean0.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean1 = resultBeanLst.get(1);

        exStringEquals(resultBean1.getSyoruiNnm(), "変更訂正書", "取込書類名");

        exStringEquals(resultBean1.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean1.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean1.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean1.getImageId(), "", "イメージID");

        exStringEquals(resultBean1.getTorikomiSyoruiCd(), "sk014", "取込書類コード");

        exStringEquals(resultBean1.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean1.getKouteikanriId(), "sk014", "工程管理ＩＤ");

        exNumericEquals(resultBean1.getSortNo(), 140, "ソート番号");


        SyoruiJohoItiranBean resultBean2 = resultBeanLst.get(2);

        exStringEquals(resultBean2.getSyoruiNnm(), "不備通知書", "取込書類名");

        exStringEquals(resultBean2.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean2.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean2.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean2.getImageId(), "", "イメージID");

        exStringEquals(resultBean2.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(resultBean2.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean2.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exNumericEquals(resultBean2.getSortNo(), 150, "ソート番号");


        SyoruiJohoItiranBean resultBean3 = resultBeanLst.get(3);

        exStringEquals(resultBean3.getSyoruiNnm(), "取消請求書", "取込書類名");

        exStringEquals(resultBean3.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean3.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean3.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean3.getImageId(), "", "イメージID");

        exStringEquals(resultBean3.getTorikomiSyoruiCd(), "sk038", "取込書類コード");

        exStringEquals(resultBean3.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean3.getKouteikanriId(), "sk038", "工程管理ＩＤ");

        exNumericEquals(resultBean3.getSortNo(), 180, "ソート番号");


        SyoruiJohoItiranBean resultBean4 = resultBeanLst.get(4);

        exStringEquals(resultBean4.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean4.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean4.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean4.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean4.getImageId(), "", "イメージID");

        exStringEquals(resultBean4.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean4.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean4.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean4.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean5 = resultBeanLst.get(5);

        exStringEquals(resultBean5.getSyoruiNnm(), "生命保険料支払申込書", "取込書類名");

        exStringEquals(resultBean5.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean5.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean5.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean5.getImageId(), "", "イメージID");

        exStringEquals(resultBean5.getTorikomiSyoruiCd(), "sk016", "取込書類コード");

        exStringEquals(resultBean5.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean5.getKouteikanriId(), "sk016", "工程管理ＩＤ");

        exNumericEquals(resultBean5.getSortNo(), 210, "ソート番号");


        SyoruiJohoItiranBean resultBean6 = resultBeanLst.get(6);

        exStringEquals(resultBean6.getSyoruiNnm(), "契約内容登録制度照会票", "取込書類名");

        exStringEquals(resultBean6.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean6.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean6.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean6.getImageId(), "", "イメージID");

        exStringEquals(resultBean6.getTorikomiSyoruiCd(), "sk046", "取込書類コード");

        exStringEquals(resultBean6.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean6.getKouteikanriId(), "sk046", "工程管理ＩＤ");

        exNumericEquals(resultBean6.getSortNo(), 230, "ソート番号");


    }

    @Test
    @TestOrder(110)
    public void testGetSyoruiJouhouItiranBetu_A11() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKMOSSYOUKAI);

        IwfImageClientMockForBiz.mode = "qs-14";

        String[] kouteikanriId = new String[23];

        kouteikanriId[0] = "sk001";
        kouteikanriId[1] = "sk007";
        kouteikanriId[2] = "sk008";
        kouteikanriId[3] = "sk009";
        kouteikanriId[4] = "sk005";
        kouteikanriId[5] = "sk011";
        kouteikanriId[6] = "sk006";
        kouteikanriId[7] = "sk010";
        kouteikanriId[8] = "sk033";
        kouteikanriId[9] = "sk034";
        kouteikanriId[10] = "sk003";
        kouteikanriId[11] = "sk032";
        kouteikanriId[12] = "sk014";
        kouteikanriId[13] = "sk013";
        kouteikanriId[14] = "sk071";
        kouteikanriId[15] = "sk038";
        kouteikanriId[16] = "sk002";
        kouteikanriId[17] = "sk004";
        kouteikanriId[18] = "sk012";
        kouteikanriId[19] = "sk016";
        kouteikanriId[20] = "sk017";
        kouteikanriId[21] = "sk046";
        kouteikanriId[22] = "sk018";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        exStringEquals(outBean.getSyorikekkaStatus(), "0", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), null, "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), null, "詳細メッセージ");

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 45, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean resultBean0 = resultBeanLst.get(0);

        exStringEquals(resultBean0.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean0.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean0.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean0.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean0.getImageId(), "", "イメージID");

        exStringEquals(resultBean0.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean0.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean0.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean0.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean1 = resultBeanLst.get(1);

        exStringEquals(resultBean1.getSyoruiNnm(), "ペーパーレス申込書兼意向確認書", "取込書類名");

        exStringEquals(resultBean1.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean1.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean1.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean1.getImageId(), "", "イメージID");

        exStringEquals(resultBean1.getTorikomiSyoruiCd(), "sk002", "取込書類コード");

        exStringEquals(resultBean1.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean1.getKouteikanriId(), "sk002", "工程管理ＩＤ");

        exNumericEquals(resultBean1.getSortNo(), 20, "ソート番号");


        SyoruiJohoItiranBean resultBean2 = resultBeanLst.get(2);

        exStringEquals(resultBean2.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean2.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean2.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean2.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean2.getImageId(), "", "イメージID");

        exStringEquals(resultBean2.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean2.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean2.getKouteikanriId(), "sk003", "工程管理ＩＤ");

        exNumericEquals(resultBean2.getSortNo(), 30, "ソート番号");



        SyoruiJohoItiranBean resultBean3 = resultBeanLst.get(3);

        exStringEquals(resultBean3.getSyoruiNnm(), "ペーパーレス告知書", "取込書類名");

        exStringEquals(resultBean3.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean3.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean3.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean3.getImageId(), "", "イメージID");

        exStringEquals(resultBean3.getTorikomiSyoruiCd(), "sk004", "取込書類コード");

        exStringEquals(resultBean3.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean3.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean3.getSortNo(), 40, "ソート番号");


        SyoruiJohoItiranBean resultBean4 = resultBeanLst.get(4);

        exStringEquals(resultBean4.getSyoruiNnm(), "意向確認書", "取込書類名");

        exStringEquals(resultBean4.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean4.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean4.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean4.getImageId(), "", "イメージID");

        exStringEquals(resultBean4.getTorikomiSyoruiCd(), "sk005", "取込書類コード");

        exStringEquals(resultBean4.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean4.getKouteikanriId(), "sk005", "工程管理ＩＤ");

        exNumericEquals(resultBean4.getSortNo(), 50, "ソート番号");


        SyoruiJohoItiranBean resultBean5 = resultBeanLst.get(5);

        exStringEquals(resultBean5.getSyoruiNnm(), "意向確認書（訂正用）", "取込書類名");

        exStringEquals(resultBean5.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean5.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean5.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean5.getImageId(), "", "イメージID");

        exStringEquals(resultBean5.getTorikomiSyoruiCd(), "sk006", "取込書類コード");

        exStringEquals(resultBean5.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean5.getKouteikanriId(), "sk006", "工程管理ＩＤ");

        exNumericEquals(resultBean5.getSortNo(), 60, "ソート番号");


        SyoruiJohoItiranBean resultBean6 = resultBeanLst.get(6);

        exStringEquals(resultBean6.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean6.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean6.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean6.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean6.getImageId(), "", "イメージID");

        exStringEquals(resultBean6.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean6.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean6.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean6.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean7 = resultBeanLst.get(7);

        exStringEquals(resultBean7.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean7.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean7.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean7.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean7.getImageId(), "", "イメージID");

        exStringEquals(resultBean7.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean7.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean7.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean7.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean8 = resultBeanLst.get(8);

        exStringEquals(resultBean8.getSyoruiNnm(), "第三者受取報告書", "取込書類名");

        exStringEquals(resultBean8.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean8.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean8.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean8.getImageId(), "", "イメージID");

        exStringEquals(resultBean8.getTorikomiSyoruiCd(), "sk009", "取込書類コード");

        exStringEquals(resultBean8.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean8.getKouteikanriId(), "sk009", "工程管理ＩＤ");

        exNumericEquals(resultBean8.getSortNo(), 90, "ソート番号");


        SyoruiJohoItiranBean resultBean9 = resultBeanLst.get(9);

        exStringEquals(resultBean9.getSyoruiNnm(), "ＦＡＴＣＡ確認書", "取込書類名");

        exStringEquals(resultBean9.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean9.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean9.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean9.getImageId(), "", "イメージID");

        exStringEquals(resultBean9.getTorikomiSyoruiCd(), "sk010", "取込書類コード");

        exStringEquals(resultBean9.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean9.getKouteikanriId(), "sk010", "工程管理ＩＤ");

        exNumericEquals(resultBean9.getSortNo(), 100, "ソート番号");


        SyoruiJohoItiranBean resultBean10 = resultBeanLst.get(10);

        exStringEquals(resultBean10.getSyoruiNnm(), "取扱報告書", "取込書類名");

        exStringEquals(resultBean10.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean10.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean10.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean10.getImageId(), "", "イメージID");

        exStringEquals(resultBean10.getTorikomiSyoruiCd(), "sk011", "取込書類コード");

        exStringEquals(resultBean10.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean10.getKouteikanriId(), "sk011", "工程管理ＩＤ");

        exNumericEquals(resultBean10.getSortNo(), 110, "ソート番号");


        SyoruiJohoItiranBean resultBean11 = resultBeanLst.get(11);

        exStringEquals(resultBean11.getSyoruiNnm(), "ペーパーレス取扱報告書", "取込書類名");

        exStringEquals(resultBean11.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean11.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean11.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean11.getImageId(), "", "イメージID");

        exStringEquals(resultBean11.getTorikomiSyoruiCd(), "sk012", "取込書類コード");

        exStringEquals(resultBean11.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean11.getKouteikanriId(), "sk012", "工程管理ＩＤ");

        exNumericEquals(resultBean11.getSortNo(), 120, "ソート番号");


        SyoruiJohoItiranBean resultBean12 = resultBeanLst.get(12);

        exStringEquals(resultBean12.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean12.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean12.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean12.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean12.getImageId(), "", "イメージID");

        exStringEquals(resultBean12.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean12.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean12.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean12.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean13 = resultBeanLst.get(13);

        exStringEquals(resultBean13.getSyoruiNnm(), "変更訂正書", "取込書類名");

        exStringEquals(resultBean13.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean13.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean13.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean13.getImageId(), "", "イメージID");

        exStringEquals(resultBean13.getTorikomiSyoruiCd(), "sk014", "取込書類コード");

        exStringEquals(resultBean13.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean13.getKouteikanriId(), "sk014", "工程管理ＩＤ");

        exNumericEquals(resultBean13.getSortNo(), 140, "ソート番号");


        SyoruiJohoItiranBean resultBean14 = resultBeanLst.get(14);

        exStringEquals(resultBean14.getSyoruiNnm(), "不備通知書", "取込書類名");

        exStringEquals(resultBean14.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean14.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean14.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean14.getImageId(), "", "イメージID");

        exStringEquals(resultBean14.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(resultBean14.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean14.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exNumericEquals(resultBean14.getSortNo(), 150, "ソート番号");


        SyoruiJohoItiranBean resultBean15 = resultBeanLst.get(15);

        exStringEquals(resultBean15.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean15.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean15.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean15.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean15.getImageId(), "", "イメージID");

        exStringEquals(resultBean15.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean15.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean15.getKouteikanriId(), "sk033", "工程管理ＩＤ");

        exNumericEquals(resultBean15.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean16 = resultBeanLst.get(16);

        exStringEquals(resultBean16.getSyoruiNnm(), "契約確認回答書", "取込書類名");

        exStringEquals(resultBean16.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean16.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean16.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean16.getImageId(), "", "イメージID");

        exStringEquals(resultBean16.getTorikomiSyoruiCd(), "sk034", "取込書類コード");

        exStringEquals(resultBean16.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean16.getKouteikanriId(), "sk034", "工程管理ＩＤ");

        exNumericEquals(resultBean16.getSortNo(), 170, "ソート番号");


        SyoruiJohoItiranBean resultBean17 = resultBeanLst.get(17);

        exStringEquals(resultBean17.getSyoruiNnm(), "取消請求書", "取込書類名");

        exStringEquals(resultBean17.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean17.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean17.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean17.getImageId(), "", "イメージID");

        exStringEquals(resultBean17.getTorikomiSyoruiCd(), "sk038", "取込書類コード");

        exStringEquals(resultBean17.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean17.getKouteikanriId(), "sk038", "工程管理ＩＤ");

        exNumericEquals(resultBean17.getSortNo(), 180, "ソート番号");


        SyoruiJohoItiranBean resultBean18 = resultBeanLst.get(18);

        exStringEquals(resultBean18.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean18.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean18.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean18.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean18.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean18.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean18.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean18.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean18.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean19 = resultBeanLst.get(19);

        exStringEquals(resultBean19.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean19.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean19.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean19.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean19.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean19.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean19.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean19.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean19.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean20 = resultBeanLst.get(20);

        exStringEquals(resultBean20.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean20.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean20.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean20.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean20.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean20.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean20.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean20.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean20.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean21 = resultBeanLst.get(21);

        exStringEquals(resultBean21.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean21.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean21.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean21.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean21.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean21.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean21.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean21.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean21.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean22 = resultBeanLst.get(22);

        exStringEquals(resultBean22.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean22.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean22.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean22.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean22.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean22.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean22.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean22.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean22.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean23 = resultBeanLst.get(23);

        exStringEquals(resultBean23.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean23.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean23.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean23.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean23.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean23.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean23.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean23.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean23.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean24 = resultBeanLst.get(24);

        exStringEquals(resultBean24.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean24.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean24.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean24.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean24.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean24.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean24.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean24.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean24.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean25 = resultBeanLst.get(25);

        exStringEquals(resultBean25.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean25.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean25.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean25.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean25.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean25.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean25.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean25.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean25.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean26 = resultBeanLst.get(26);

        exStringEquals(resultBean26.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean26.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean26.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean26.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean26.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean26.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean26.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean26.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean26.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean27 = resultBeanLst.get(27);

        exStringEquals(resultBean27.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean27.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean27.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean27.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean27.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean27.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean27.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean27.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean27.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean28 = resultBeanLst.get(28);

        exStringEquals(resultBean28.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean28.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean28.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean28.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean28.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean28.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean28.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean28.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean28.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean29 = resultBeanLst.get(29);

        exStringEquals(resultBean29.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean29.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean29.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean29.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean29.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean29.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean29.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean29.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean29.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean30 = resultBeanLst.get(30);

        exStringEquals(resultBean30.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean30.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean30.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean30.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean30.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean30.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean30.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean30.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean30.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean31 = resultBeanLst.get(31);

        exStringEquals(resultBean31.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean31.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean31.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean31.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean31.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean31.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean31.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean31.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean31.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean32 = resultBeanLst.get(32);

        exStringEquals(resultBean32.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean32.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean32.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean32.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean32.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean32.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean32.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean32.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean32.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean33 = resultBeanLst.get(33);

        exStringEquals(resultBean33.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean33.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean33.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean33.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean33.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean33.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean33.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean33.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean33.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean34 = resultBeanLst.get(34);

        exStringEquals(resultBean34.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean34.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean34.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean34.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean34.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean34.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean34.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean34.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean34.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean35 = resultBeanLst.get(35);

        exStringEquals(resultBean35.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean35.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean35.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean35.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean35.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean35.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean35.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean35.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean35.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean36 = resultBeanLst.get(36);

        exStringEquals(resultBean36.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean36.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean36.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean36.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean36.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean36.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean36.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean36.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean36.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean37 = resultBeanLst.get(37);

        exStringEquals(resultBean37.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean37.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean37.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean37.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean37.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean37.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean37.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean37.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean37.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean38 = resultBeanLst.get(38);

        exStringEquals(resultBean38.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean38.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean38.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean38.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean38.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean38.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean38.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean38.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean38.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean39 = resultBeanLst.get(39);

        exStringEquals(resultBean39.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean39.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean39.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean39.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean39.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean39.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean39.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean39.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean39.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean40 = resultBeanLst.get(40);

        exStringEquals(resultBean40.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean40.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean40.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean40.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean40.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean40.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean40.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean40.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean40.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean41 = resultBeanLst.get(41);

        exStringEquals(resultBean41.getSyoruiNnm(), "生命保険料支払申込書", "取込書類名");

        exStringEquals(resultBean41.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean41.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean41.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean41.getImageId(), "", "イメージID");

        exStringEquals(resultBean41.getTorikomiSyoruiCd(), "sk016", "取込書類コード");

        exStringEquals(resultBean41.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean41.getKouteikanriId(), "sk016", "工程管理ＩＤ");

        exNumericEquals(resultBean41.getSortNo(), 210, "ソート番号");


        SyoruiJohoItiranBean resultBean42 = resultBeanLst.get(42);

        exStringEquals(resultBean42.getSyoruiNnm(), "代筆報告書", "取込書類名");

        exStringEquals(resultBean42.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean42.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean42.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean42.getImageId(), "", "イメージID");

        exStringEquals(resultBean42.getTorikomiSyoruiCd(), "sk017", "取込書類コード");

        exStringEquals(resultBean42.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean42.getKouteikanriId(), "sk017", "工程管理ＩＤ");

        exNumericEquals(resultBean42.getSortNo(), 220, "ソート番号");


        SyoruiJohoItiranBean resultBean43 = resultBeanLst.get(43);

        exStringEquals(resultBean43.getSyoruiNnm(), "契約内容登録制度照会票", "取込書類名");

        exStringEquals(resultBean43.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean43.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean43.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean43.getImageId(), "", "イメージID");

        exStringEquals(resultBean43.getTorikomiSyoruiCd(), "sk046", "取込書類コード");

        exStringEquals(resultBean43.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean43.getKouteikanriId(), "sk046", "工程管理ＩＤ");

        exNumericEquals(resultBean43.getSortNo(), 230, "ソート番号");


        SyoruiJohoItiranBean resultBean44 = resultBeanLst.get(44);

        exStringEquals(resultBean44.getSyoruiNnm(), "非対面チェックシート", "取込書類名");

        exStringEquals(resultBean44.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean44.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean44.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean44.getImageId(), "", "イメージID");

        exStringEquals(resultBean44.getTorikomiSyoruiCd(), "sk018", "取込書類コード");

        exStringEquals(resultBean44.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean44.getKouteikanriId(), "sk018", "工程管理ＩＤ");

        exNumericEquals(resultBean44.getSortNo(), 240, "ソート番号");

    }

    @Test
    @TestOrder(120)
    public void testGetSyoruiJouhouItiranBetu_A12() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKHUBITOUROKU);

        IwfImageClientMockForBiz.mode = "qs-15";

        String[] kouteikanriId = new String[23];

        kouteikanriId[0] = "sk001";
        kouteikanriId[1] = "sk007";
        kouteikanriId[2] = "sk008";
        kouteikanriId[3] = "sk009";
        kouteikanriId[4] = "sk005";
        kouteikanriId[5] = "sk011";
        kouteikanriId[6] = "sk006";
        kouteikanriId[7] = "sk010";
        kouteikanriId[8] = "sk033";
        kouteikanriId[9] = "sk034";
        kouteikanriId[10] = "sk003";
        kouteikanriId[11] = "sk032";
        kouteikanriId[12] = "sk014";
        kouteikanriId[13] = "sk013";
        kouteikanriId[14] = "sk071";
        kouteikanriId[15] = "sk038";
        kouteikanriId[16] = "sk002";
        kouteikanriId[17] = "sk004";
        kouteikanriId[18] = "sk012";
        kouteikanriId[19] = "sk016";
        kouteikanriId[20] = "sk017";
        kouteikanriId[21] = "sk046";
        kouteikanriId[22] = "sk018";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        exStringEquals(outBean.getSyorikekkaStatus(), "0", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), null, "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), null, "詳細メッセージ");

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 23, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean resultBean0 = resultBeanLst.get(0);

        exStringEquals(resultBean0.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean0.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean0.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean0.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean0.getImageId(), "", "イメージID");

        exStringEquals(resultBean0.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean0.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean0.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean0.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean1 = resultBeanLst.get(1);

        exStringEquals(resultBean1.getSyoruiNnm(), "ペーパーレス申込書兼意向確認書", "取込書類名");

        exStringEquals(resultBean1.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean1.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean1.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean1.getImageId(), "", "イメージID");

        exStringEquals(resultBean1.getTorikomiSyoruiCd(), "sk002", "取込書類コード");

        exStringEquals(resultBean1.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean1.getKouteikanriId(), "sk002", "工程管理ＩＤ");

        exNumericEquals(resultBean1.getSortNo(), 20, "ソート番号");


        SyoruiJohoItiranBean resultBean2 = resultBeanLst.get(2);

        exStringEquals(resultBean2.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean2.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean2.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean2.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean2.getImageId(), "", "イメージID");

        exStringEquals(resultBean2.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean2.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean2.getKouteikanriId(), "sk003", "工程管理ＩＤ");

        exNumericEquals(resultBean2.getSortNo(), 30, "ソート番号");



        SyoruiJohoItiranBean resultBean3 = resultBeanLst.get(3);

        exStringEquals(resultBean3.getSyoruiNnm(), "ペーパーレス告知書", "取込書類名");

        exStringEquals(resultBean3.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean3.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean3.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean3.getImageId(), "", "イメージID");

        exStringEquals(resultBean3.getTorikomiSyoruiCd(), "sk004", "取込書類コード");

        exStringEquals(resultBean3.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean3.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean3.getSortNo(), 40, "ソート番号");


        SyoruiJohoItiranBean resultBean4 = resultBeanLst.get(4);

        exStringEquals(resultBean4.getSyoruiNnm(), "意向確認書", "取込書類名");

        exStringEquals(resultBean4.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean4.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean4.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean4.getImageId(), "", "イメージID");

        exStringEquals(resultBean4.getTorikomiSyoruiCd(), "sk005", "取込書類コード");

        exStringEquals(resultBean4.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean4.getKouteikanriId(), "sk005", "工程管理ＩＤ");

        exNumericEquals(resultBean4.getSortNo(), 50, "ソート番号");


        SyoruiJohoItiranBean resultBean5 = resultBeanLst.get(5);

        exStringEquals(resultBean5.getSyoruiNnm(), "意向確認書（訂正用）", "取込書類名");

        exStringEquals(resultBean5.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean5.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean5.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean5.getImageId(), "", "イメージID");

        exStringEquals(resultBean5.getTorikomiSyoruiCd(), "sk006", "取込書類コード");

        exStringEquals(resultBean5.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean5.getKouteikanriId(), "sk006", "工程管理ＩＤ");

        exNumericEquals(resultBean5.getSortNo(), 60, "ソート番号");


        SyoruiJohoItiranBean resultBean6 = resultBeanLst.get(6);

        exStringEquals(resultBean6.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean6.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean6.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean6.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean6.getImageId(), "", "イメージID");

        exStringEquals(resultBean6.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean6.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean6.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean6.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean7 = resultBeanLst.get(7);

        exStringEquals(resultBean7.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean7.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean7.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean7.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean7.getImageId(), "", "イメージID");

        exStringEquals(resultBean7.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean7.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean7.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean7.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean8 = resultBeanLst.get(8);

        exStringEquals(resultBean8.getSyoruiNnm(), "第三者受取報告書", "取込書類名");

        exStringEquals(resultBean8.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean8.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean8.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean8.getImageId(), "", "イメージID");

        exStringEquals(resultBean8.getTorikomiSyoruiCd(), "sk009", "取込書類コード");

        exStringEquals(resultBean8.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean8.getKouteikanriId(), "sk009", "工程管理ＩＤ");

        exNumericEquals(resultBean8.getSortNo(), 90, "ソート番号");


        SyoruiJohoItiranBean resultBean9 = resultBeanLst.get(9);

        exStringEquals(resultBean9.getSyoruiNnm(), "ＦＡＴＣＡ確認書", "取込書類名");

        exStringEquals(resultBean9.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean9.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean9.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean9.getImageId(), "", "イメージID");

        exStringEquals(resultBean9.getTorikomiSyoruiCd(), "sk010", "取込書類コード");

        exStringEquals(resultBean9.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean9.getKouteikanriId(), "sk010", "工程管理ＩＤ");

        exNumericEquals(resultBean9.getSortNo(), 100, "ソート番号");


        SyoruiJohoItiranBean resultBean10 = resultBeanLst.get(10);

        exStringEquals(resultBean10.getSyoruiNnm(), "取扱報告書", "取込書類名");

        exStringEquals(resultBean10.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean10.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean10.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean10.getImageId(), "", "イメージID");

        exStringEquals(resultBean10.getTorikomiSyoruiCd(), "sk011", "取込書類コード");

        exStringEquals(resultBean10.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean10.getKouteikanriId(), "sk011", "工程管理ＩＤ");

        exNumericEquals(resultBean10.getSortNo(), 110, "ソート番号");


        SyoruiJohoItiranBean resultBean11 = resultBeanLst.get(11);

        exStringEquals(resultBean11.getSyoruiNnm(), "ペーパーレス取扱報告書", "取込書類名");

        exStringEquals(resultBean11.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean11.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean11.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean11.getImageId(), "", "イメージID");

        exStringEquals(resultBean11.getTorikomiSyoruiCd(), "sk012", "取込書類コード");

        exStringEquals(resultBean11.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean11.getKouteikanriId(), "sk012", "工程管理ＩＤ");

        exNumericEquals(resultBean11.getSortNo(), 120, "ソート番号");


        SyoruiJohoItiranBean resultBean12 = resultBeanLst.get(12);

        exStringEquals(resultBean12.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean12.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean12.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean12.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean12.getImageId(), "", "イメージID");

        exStringEquals(resultBean12.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean12.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean12.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean12.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean13 = resultBeanLst.get(13);

        exStringEquals(resultBean13.getSyoruiNnm(), "変更訂正書", "取込書類名");

        exStringEquals(resultBean13.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean13.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean13.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean13.getImageId(), "", "イメージID");

        exStringEquals(resultBean13.getTorikomiSyoruiCd(), "sk014", "取込書類コード");

        exStringEquals(resultBean13.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean13.getKouteikanriId(), "sk014", "工程管理ＩＤ");

        exNumericEquals(resultBean13.getSortNo(), 140, "ソート番号");


        SyoruiJohoItiranBean resultBean14 = resultBeanLst.get(14);

        exStringEquals(resultBean14.getSyoruiNnm(), "不備通知書", "取込書類名");

        exStringEquals(resultBean14.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean14.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean14.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean14.getImageId(), "", "イメージID");

        exStringEquals(resultBean14.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(resultBean14.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean14.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exNumericEquals(resultBean14.getSortNo(), 150, "ソート番号");


        SyoruiJohoItiranBean resultBean15 = resultBeanLst.get(15);

        exStringEquals(resultBean15.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean15.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean15.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean15.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean15.getImageId(), "", "イメージID");

        exStringEquals(resultBean15.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean15.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean15.getKouteikanriId(), "sk033", "工程管理ＩＤ");

        exNumericEquals(resultBean15.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean16 = resultBeanLst.get(16);

        exStringEquals(resultBean16.getSyoruiNnm(), "契約確認回答書", "取込書類名");

        exStringEquals(resultBean16.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean16.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean16.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean16.getImageId(), "", "イメージID");

        exStringEquals(resultBean16.getTorikomiSyoruiCd(), "sk034", "取込書類コード");

        exStringEquals(resultBean16.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean16.getKouteikanriId(), "sk034", "工程管理ＩＤ");

        exNumericEquals(resultBean16.getSortNo(), 170, "ソート番号");


        SyoruiJohoItiranBean resultBean17 = resultBeanLst.get(17);

        exStringEquals(resultBean17.getSyoruiNnm(), "取消請求書", "取込書類名");

        exStringEquals(resultBean17.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean17.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean17.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean17.getImageId(), "", "イメージID");

        exStringEquals(resultBean17.getTorikomiSyoruiCd(), "sk038", "取込書類コード");

        exStringEquals(resultBean17.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean17.getKouteikanriId(), "sk038", "工程管理ＩＤ");

        exNumericEquals(resultBean17.getSortNo(), 180, "ソート番号");


        SyoruiJohoItiranBean resultBean18 = resultBeanLst.get(18);

        exStringEquals(resultBean18.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean18.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean18.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean18.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean18.getImageId(), "", "イメージID");

        exStringEquals(resultBean18.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean18.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean18.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean18.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean19 = resultBeanLst.get(19);

        exStringEquals(resultBean19.getSyoruiNnm(), "生命保険料支払申込書", "取込書類名");

        exStringEquals(resultBean19.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean19.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean19.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean19.getImageId(), "", "イメージID");

        exStringEquals(resultBean19.getTorikomiSyoruiCd(), "sk016", "取込書類コード");

        exStringEquals(resultBean19.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean19.getKouteikanriId(), "sk016", "工程管理ＩＤ");

        exNumericEquals(resultBean19.getSortNo(), 210, "ソート番号");


        SyoruiJohoItiranBean resultBean20 = resultBeanLst.get(20);

        exStringEquals(resultBean20.getSyoruiNnm(), "代筆報告書", "取込書類名");

        exStringEquals(resultBean20.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean20.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean20.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean20.getImageId(), "", "イメージID");

        exStringEquals(resultBean20.getTorikomiSyoruiCd(), "sk017", "取込書類コード");

        exStringEquals(resultBean20.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean20.getKouteikanriId(), "sk017", "工程管理ＩＤ");

        exNumericEquals(resultBean20.getSortNo(), 220, "ソート番号");


        SyoruiJohoItiranBean resultBean21 = resultBeanLst.get(21);

        exStringEquals(resultBean21.getSyoruiNnm(), "契約内容登録制度照会票", "取込書類名");

        exStringEquals(resultBean21.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean21.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean21.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean21.getImageId(), "", "イメージID");

        exStringEquals(resultBean21.getTorikomiSyoruiCd(), "sk046", "取込書類コード");

        exStringEquals(resultBean21.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean21.getKouteikanriId(), "sk046", "工程管理ＩＤ");

        exNumericEquals(resultBean21.getSortNo(), 230, "ソート番号");


        SyoruiJohoItiranBean resultBean22 = resultBeanLst.get(22);

        exStringEquals(resultBean22.getSyoruiNnm(), "非対面チェックシート", "取込書類名");

        exStringEquals(resultBean22.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean22.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean22.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean22.getImageId(), "", "イメージID");

        exStringEquals(resultBean22.getTorikomiSyoruiCd(), "sk018", "取込書類コード");

        exStringEquals(resultBean22.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean22.getKouteikanriId(), "sk018", "工程管理ＩＤ");

        exNumericEquals(resultBean22.getSortNo(), 240, "ソート番号");

    }

    @Test
    @TestOrder(130)
    public void testGetSyoruiJouhouItiranBetu_A13() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKHUBIKAISYOU);

        IwfImageClientMockForBiz.mode = "qs-16";

        String[] kouteikanriId = new String[22];

        kouteikanriId[0] = "sk001";
        kouteikanriId[1] = "sk007";
        kouteikanriId[2] = "sk008";
        kouteikanriId[3] = "sk005";
        kouteikanriId[4] = "sk011";
        kouteikanriId[5] = "sk006";
        kouteikanriId[6] = "sk010";
        kouteikanriId[7] = "sk033";
        kouteikanriId[8] = "sk034";
        kouteikanriId[9] = "sk003";
        kouteikanriId[10] = "sk032";
        kouteikanriId[11] = "sk014";
        kouteikanriId[12] = "sk013";
        kouteikanriId[13] = "sk071";
        kouteikanriId[14] = "sk038";
        kouteikanriId[15] = "sk002";
        kouteikanriId[16] = "sk004";
        kouteikanriId[17] = "sk012";
        kouteikanriId[18] = "sk016";
        kouteikanriId[19] = "sk017";
        kouteikanriId[20] = "sk046";
        kouteikanriId[21] = "sk018";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        exStringEquals(outBean.getSyorikekkaStatus(), "0", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), null, "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), null, "詳細メッセージ");

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 22, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean resultBean0 = resultBeanLst.get(0);

        exStringEquals(resultBean0.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean0.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean0.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean0.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean0.getImageId(), "", "イメージID");

        exStringEquals(resultBean0.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean0.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean0.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean0.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean1 = resultBeanLst.get(1);

        exStringEquals(resultBean1.getSyoruiNnm(), "ペーパーレス申込書兼意向確認書", "取込書類名");

        exStringEquals(resultBean1.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean1.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean1.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean1.getImageId(), "", "イメージID");

        exStringEquals(resultBean1.getTorikomiSyoruiCd(), "sk002", "取込書類コード");

        exStringEquals(resultBean1.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean1.getKouteikanriId(), "sk002", "工程管理ＩＤ");

        exNumericEquals(resultBean1.getSortNo(), 20, "ソート番号");


        SyoruiJohoItiranBean resultBean2 = resultBeanLst.get(2);

        exStringEquals(resultBean2.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean2.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean2.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean2.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean2.getImageId(), "", "イメージID");

        exStringEquals(resultBean2.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean2.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean2.getKouteikanriId(), "sk003", "工程管理ＩＤ");

        exNumericEquals(resultBean2.getSortNo(), 30, "ソート番号");



        SyoruiJohoItiranBean resultBean3 = resultBeanLst.get(3);

        exStringEquals(resultBean3.getSyoruiNnm(), "ペーパーレス告知書", "取込書類名");

        exStringEquals(resultBean3.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean3.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean3.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean3.getImageId(), "", "イメージID");

        exStringEquals(resultBean3.getTorikomiSyoruiCd(), "sk004", "取込書類コード");

        exStringEquals(resultBean3.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean3.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean3.getSortNo(), 40, "ソート番号");


        SyoruiJohoItiranBean resultBean4 = resultBeanLst.get(4);

        exStringEquals(resultBean4.getSyoruiNnm(), "意向確認書", "取込書類名");

        exStringEquals(resultBean4.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean4.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean4.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean4.getImageId(), "", "イメージID");

        exStringEquals(resultBean4.getTorikomiSyoruiCd(), "sk005", "取込書類コード");

        exStringEquals(resultBean4.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean4.getKouteikanriId(), "sk005", "工程管理ＩＤ");

        exNumericEquals(resultBean4.getSortNo(), 50, "ソート番号");


        SyoruiJohoItiranBean resultBean5 = resultBeanLst.get(5);

        exStringEquals(resultBean5.getSyoruiNnm(), "意向確認書（訂正用）", "取込書類名");

        exStringEquals(resultBean5.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean5.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean5.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean5.getImageId(), "", "イメージID");

        exStringEquals(resultBean5.getTorikomiSyoruiCd(), "sk006", "取込書類コード");

        exStringEquals(resultBean5.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean5.getKouteikanriId(), "sk006", "工程管理ＩＤ");

        exNumericEquals(resultBean5.getSortNo(), 60, "ソート番号");


        SyoruiJohoItiranBean resultBean6 = resultBeanLst.get(6);

        exStringEquals(resultBean6.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean6.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean6.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean6.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean6.getImageId(), "", "イメージID");

        exStringEquals(resultBean6.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean6.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean6.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean6.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean7 = resultBeanLst.get(7);

        exStringEquals(resultBean7.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean7.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean7.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean7.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean7.getImageId(), "", "イメージID");

        exStringEquals(resultBean7.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean7.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean7.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean7.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean8 = resultBeanLst.get(8);

        exStringEquals(resultBean8.getSyoruiNnm(), "ＦＡＴＣＡ確認書", "取込書類名");

        exStringEquals(resultBean8.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean8.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean8.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean8.getImageId(), "", "イメージID");

        exStringEquals(resultBean8.getTorikomiSyoruiCd(), "sk010", "取込書類コード");

        exStringEquals(resultBean8.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean8.getKouteikanriId(), "sk010", "工程管理ＩＤ");

        exNumericEquals(resultBean8.getSortNo(), 100, "ソート番号");


        SyoruiJohoItiranBean resultBean9 = resultBeanLst.get(9);

        exStringEquals(resultBean9.getSyoruiNnm(), "取扱報告書", "取込書類名");

        exStringEquals(resultBean9.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean9.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean9.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean9.getImageId(), "", "イメージID");

        exStringEquals(resultBean9.getTorikomiSyoruiCd(), "sk011", "取込書類コード");

        exStringEquals(resultBean9.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean9.getKouteikanriId(), "sk011", "工程管理ＩＤ");

        exNumericEquals(resultBean9.getSortNo(), 110, "ソート番号");


        SyoruiJohoItiranBean resultBean10 = resultBeanLst.get(10);

        exStringEquals(resultBean10.getSyoruiNnm(), "ペーパーレス取扱報告書", "取込書類名");

        exStringEquals(resultBean10.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean10.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean10.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean10.getImageId(), "", "イメージID");

        exStringEquals(resultBean10.getTorikomiSyoruiCd(), "sk012", "取込書類コード");

        exStringEquals(resultBean10.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean10.getKouteikanriId(), "sk012", "工程管理ＩＤ");

        exNumericEquals(resultBean10.getSortNo(), 120, "ソート番号");


        SyoruiJohoItiranBean resultBean11 = resultBeanLst.get(11);

        exStringEquals(resultBean11.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean11.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean11.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean11.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean11.getImageId(), "", "イメージID");

        exStringEquals(resultBean11.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean11.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean11.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean11.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean12 = resultBeanLst.get(12);

        exStringEquals(resultBean12.getSyoruiNnm(), "変更訂正書", "取込書類名");

        exStringEquals(resultBean12.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean12.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean12.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean12.getImageId(), "", "イメージID");

        exStringEquals(resultBean12.getTorikomiSyoruiCd(), "sk014", "取込書類コード");

        exStringEquals(resultBean12.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean12.getKouteikanriId(), "sk014", "工程管理ＩＤ");

        exNumericEquals(resultBean12.getSortNo(), 140, "ソート番号");


        SyoruiJohoItiranBean resultBean13 = resultBeanLst.get(13);

        exStringEquals(resultBean13.getSyoruiNnm(), "不備通知書", "取込書類名");

        exStringEquals(resultBean13.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean13.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean13.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean13.getImageId(), "", "イメージID");

        exStringEquals(resultBean13.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(resultBean13.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean13.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exNumericEquals(resultBean13.getSortNo(), 150, "ソート番号");


        SyoruiJohoItiranBean resultBean14 = resultBeanLst.get(14);

        exStringEquals(resultBean14.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean14.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean14.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean14.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean14.getImageId(), "", "イメージID");

        exStringEquals(resultBean14.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean14.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean14.getKouteikanriId(), "sk033", "工程管理ＩＤ");

        exNumericEquals(resultBean14.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean15 = resultBeanLst.get(15);

        exStringEquals(resultBean15.getSyoruiNnm(), "契約確認回答書", "取込書類名");

        exStringEquals(resultBean15.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean15.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean15.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean15.getImageId(), "", "イメージID");

        exStringEquals(resultBean15.getTorikomiSyoruiCd(), "sk034", "取込書類コード");

        exStringEquals(resultBean15.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean15.getKouteikanriId(), "sk034", "工程管理ＩＤ");

        exNumericEquals(resultBean15.getSortNo(), 170, "ソート番号");


        SyoruiJohoItiranBean resultBean16 = resultBeanLst.get(16);

        exStringEquals(resultBean16.getSyoruiNnm(), "取消請求書", "取込書類名");

        exStringEquals(resultBean16.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean16.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean16.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean16.getImageId(), "", "イメージID");

        exStringEquals(resultBean16.getTorikomiSyoruiCd(), "sk038", "取込書類コード");

        exStringEquals(resultBean16.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean16.getKouteikanriId(), "sk038", "工程管理ＩＤ");

        exNumericEquals(resultBean16.getSortNo(), 180, "ソート番号");


        SyoruiJohoItiranBean resultBean17 = resultBeanLst.get(17);

        exStringEquals(resultBean17.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean17.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean17.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean17.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean17.getImageId(), "", "イメージID");

        exStringEquals(resultBean17.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean17.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean17.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean17.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean18 = resultBeanLst.get(18);

        exStringEquals(resultBean18.getSyoruiNnm(), "生命保険料支払申込書", "取込書類名");

        exStringEquals(resultBean18.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean18.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean18.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean18.getImageId(), "", "イメージID");

        exStringEquals(resultBean18.getTorikomiSyoruiCd(), "sk016", "取込書類コード");

        exStringEquals(resultBean18.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean18.getKouteikanriId(), "sk016", "工程管理ＩＤ");

        exNumericEquals(resultBean18.getSortNo(), 210, "ソート番号");


        SyoruiJohoItiranBean resultBean19 = resultBeanLst.get(19);

        exStringEquals(resultBean19.getSyoruiNnm(), "代筆報告書", "取込書類名");

        exStringEquals(resultBean19.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean19.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean19.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean19.getImageId(), "", "イメージID");

        exStringEquals(resultBean19.getTorikomiSyoruiCd(), "sk017", "取込書類コード");

        exStringEquals(resultBean19.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean19.getKouteikanriId(), "sk017", "工程管理ＩＤ");

        exNumericEquals(resultBean19.getSortNo(), 220, "ソート番号");


        SyoruiJohoItiranBean resultBean20 = resultBeanLst.get(20);

        exStringEquals(resultBean20.getSyoruiNnm(), "契約内容登録制度照会票", "取込書類名");

        exStringEquals(resultBean20.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean20.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean20.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean20.getImageId(), "", "イメージID");

        exStringEquals(resultBean20.getTorikomiSyoruiCd(), "sk046", "取込書類コード");

        exStringEquals(resultBean20.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean20.getKouteikanriId(), "sk046", "工程管理ＩＤ");

        exNumericEquals(resultBean20.getSortNo(), 230, "ソート番号");


        SyoruiJohoItiranBean resultBean21 = resultBeanLst.get(21);

        exStringEquals(resultBean21.getSyoruiNnm(), "非対面チェックシート", "取込書類名");

        exStringEquals(resultBean21.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean21.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean21.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean21.getImageId(), "", "イメージID");

        exStringEquals(resultBean21.getTorikomiSyoruiCd(), "sk018", "取込書類コード");

        exStringEquals(resultBean21.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean21.getKouteikanriId(), "sk018", "工程管理ＩＤ");

        exNumericEquals(resultBean21.getSortNo(), 240, "ソート番号");

    }

    @Test
    @TestOrder(140)
    public void testGetSyoruiJouhouItiranBetu_A14() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKMOUSIKOMITORIKESI);

        IwfImageClientMockForBiz.mode = "qs-09";

        String[] kouteikanriId = new String[23];

        kouteikanriId[0] = "sk001";
        kouteikanriId[1] = "sk007";
        kouteikanriId[2] = "sk008";
        kouteikanriId[3] = "sk009";
        kouteikanriId[4] = "sk005";
        kouteikanriId[5] = "sk011";
        kouteikanriId[6] = "sk006";
        kouteikanriId[7] = "sk010";
        kouteikanriId[8] = "sk033";
        kouteikanriId[9] = "sk034";
        kouteikanriId[10] = "sk003";
        kouteikanriId[11] = "sk032";
        kouteikanriId[12] = "sk014";
        kouteikanriId[13] = "sk013";
        kouteikanriId[14] = "sk071";
        kouteikanriId[15] = "sk038";
        kouteikanriId[16] = "sk002";
        kouteikanriId[17] = "sk004";
        kouteikanriId[18] = "sk012";
        kouteikanriId[19] = "sk016";
        kouteikanriId[20] = "sk017";
        kouteikanriId[21] = "sk046";
        kouteikanriId[22] = "sk018";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        exStringEquals(outBean.getSyorikekkaStatus(), "0", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), null, "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), null, "詳細メッセージ");

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 45, "書類情報一覧Beanリスト件数");


        SyoruiJohoItiranBean resultBean0 = resultBeanLst.get(0);

        exStringEquals(resultBean0.getSyoruiNnm(), "申込書", "取込書類名");

        exStringEquals(resultBean0.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean0.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean0.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean0.getImageId(), "", "イメージID");

        exStringEquals(resultBean0.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(resultBean0.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean0.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exNumericEquals(resultBean0.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean resultBean1 = resultBeanLst.get(1);

        exStringEquals(resultBean1.getSyoruiNnm(), "ペーパーレス申込書兼意向確認書", "取込書類名");

        exStringEquals(resultBean1.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean1.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean1.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean1.getImageId(), "", "イメージID");

        exStringEquals(resultBean1.getTorikomiSyoruiCd(), "sk002", "取込書類コード");

        exStringEquals(resultBean1.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean1.getKouteikanriId(), "sk002", "工程管理ＩＤ");

        exNumericEquals(resultBean1.getSortNo(), 20, "ソート番号");


        SyoruiJohoItiranBean resultBean2 = resultBeanLst.get(2);

        exStringEquals(resultBean2.getSyoruiNnm(), "告知書", "取込書類名");

        exStringEquals(resultBean2.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean2.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean2.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean2.getImageId(), "", "イメージID");

        exStringEquals(resultBean2.getTorikomiSyoruiCd(), "sk003", "取込書類コード");

        exStringEquals(resultBean2.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean2.getKouteikanriId(), "sk003", "工程管理ＩＤ");

        exNumericEquals(resultBean2.getSortNo(), 30, "ソート番号");



        SyoruiJohoItiranBean resultBean3 = resultBeanLst.get(3);

        exStringEquals(resultBean3.getSyoruiNnm(), "ペーパーレス告知書", "取込書類名");

        exStringEquals(resultBean3.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean3.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean3.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean3.getImageId(), "", "イメージID");

        exStringEquals(resultBean3.getTorikomiSyoruiCd(), "sk004", "取込書類コード");

        exStringEquals(resultBean3.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean3.getKouteikanriId(), "sk004", "工程管理ＩＤ");

        exNumericEquals(resultBean3.getSortNo(), 40, "ソート番号");


        SyoruiJohoItiranBean resultBean4 = resultBeanLst.get(4);

        exStringEquals(resultBean4.getSyoruiNnm(), "意向確認書", "取込書類名");

        exStringEquals(resultBean4.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean4.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean4.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean4.getImageId(), "", "イメージID");

        exStringEquals(resultBean4.getTorikomiSyoruiCd(), "sk005", "取込書類コード");

        exStringEquals(resultBean4.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean4.getKouteikanriId(), "sk005", "工程管理ＩＤ");

        exNumericEquals(resultBean4.getSortNo(), 50, "ソート番号");


        SyoruiJohoItiranBean resultBean5 = resultBeanLst.get(5);

        exStringEquals(resultBean5.getSyoruiNnm(), "意向確認書（訂正用）", "取込書類名");

        exStringEquals(resultBean5.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean5.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean5.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean5.getImageId(), "", "イメージID");

        exStringEquals(resultBean5.getTorikomiSyoruiCd(), "sk006", "取込書類コード");

        exStringEquals(resultBean5.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean5.getKouteikanriId(), "sk006", "工程管理ＩＤ");

        exNumericEquals(resultBean5.getSortNo(), 60, "ソート番号");


        SyoruiJohoItiranBean resultBean6 = resultBeanLst.get(6);

        exStringEquals(resultBean6.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean6.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean6.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean6.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean6.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean6.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean6.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean6.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean6.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean7 = resultBeanLst.get(7);

        exStringEquals(resultBean7.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean7.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean7.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean7.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean7.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean7.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean7.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean7.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean7.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean8 = resultBeanLst.get(8);

        exStringEquals(resultBean8.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean8.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean8.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean8.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean8.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean8.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean8.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean8.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean8.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean9 = resultBeanLst.get(9);

        exStringEquals(resultBean9.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean9.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean9.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean9.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean9.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean9.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean9.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean9.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean9.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean10 = resultBeanLst.get(10);

        exStringEquals(resultBean10.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean10.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean10.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean10.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean10.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean10.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean10.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean10.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean10.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean11 = resultBeanLst.get(11);

        exStringEquals(resultBean11.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean11.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean11.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean11.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean11.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean11.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean11.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean11.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean11.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean12 = resultBeanLst.get(12);

        exStringEquals(resultBean12.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean12.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean12.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean12.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean12.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean12.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean12.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean12.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean12.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean13 = resultBeanLst.get(13);

        exStringEquals(resultBean13.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean13.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean13.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean13.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean13.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean13.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean13.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean13.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean13.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean14 = resultBeanLst.get(14);

        exStringEquals(resultBean14.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean14.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean14.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean14.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean14.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean14.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean14.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean14.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean14.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean15 = resultBeanLst.get(15);

        exStringEquals(resultBean15.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean15.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean15.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean15.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean15.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean15.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean15.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean15.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean15.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean16 = resultBeanLst.get(16);

        exStringEquals(resultBean16.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean16.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean16.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean16.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean16.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean16.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean16.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean16.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean16.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean17 = resultBeanLst.get(17);

        exStringEquals(resultBean17.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean17.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean17.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean17.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean17.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean17.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean17.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean17.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean17.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean18 = resultBeanLst.get(18);

        exStringEquals(resultBean18.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean18.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean18.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean18.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean18.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean18.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean18.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean18.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean18.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean19 = resultBeanLst.get(19);

        exStringEquals(resultBean19.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean19.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean19.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean19.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean19.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean19.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean19.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean19.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean19.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean20 = resultBeanLst.get(20);

        exStringEquals(resultBean20.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean20.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean20.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean20.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean20.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean20.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean20.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean20.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean20.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean21 = resultBeanLst.get(21);

        exStringEquals(resultBean21.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean21.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean21.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean21.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean21.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean21.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean21.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean21.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean21.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean22 = resultBeanLst.get(22);

        exStringEquals(resultBean22.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean22.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean22.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean22.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean22.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean22.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean22.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean22.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean22.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean23 = resultBeanLst.get(23);

        exStringEquals(resultBean23.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean23.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean23.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean23.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean23.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean23.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean23.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean23.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean23.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean24 = resultBeanLst.get(24);

        exStringEquals(resultBean24.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean24.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean24.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean24.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean24.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean24.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean24.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean24.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean24.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean25 = resultBeanLst.get(25);

        exStringEquals(resultBean25.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean25.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean25.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean25.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean25.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean25.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean25.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean25.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean25.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean26 = resultBeanLst.get(26);

        exStringEquals(resultBean26.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean26.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean26.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean26.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean26.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean26.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean26.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean26.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean26.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean27 = resultBeanLst.get(27);

        exStringEquals(resultBean27.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean27.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean27.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean27.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean27.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean27.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean27.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean27.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean27.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean28 = resultBeanLst.get(28);

        exStringEquals(resultBean28.getSyoruiNnm(), "受取人複数指定書", "取込書類名");

        exStringEquals(resultBean28.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exStringEquals(resultBean28.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean28.getHyoujiLink(), "1", "表示リンク");

        exStringEquals(resultBean28.getImageId(), "ImageId1", "イメージID");

        exStringEquals(resultBean28.getTorikomiSyoruiCd(), "sk007", "取込書類コード");

        exStringEquals(resultBean28.getHyoujiLinkFlg(), "1", "表示リンクフラグ");

        exStringEquals(resultBean28.getKouteikanriId(), "sk007", "工程管理ＩＤ");

        exNumericEquals(resultBean28.getSortNo(), 70, "ソート番号");


        SyoruiJohoItiranBean resultBean29 = resultBeanLst.get(29);

        exStringEquals(resultBean29.getSyoruiNnm(), "受取人事前照会票", "取込書類名");

        exStringEquals(resultBean29.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean29.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean29.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean29.getImageId(), "", "イメージID");

        exStringEquals(resultBean29.getTorikomiSyoruiCd(), "sk008", "取込書類コード");

        exStringEquals(resultBean29.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean29.getKouteikanriId(), "sk008", "工程管理ＩＤ");

        exNumericEquals(resultBean29.getSortNo(), 80, "ソート番号");


        SyoruiJohoItiranBean resultBean30 = resultBeanLst.get(30);

        exStringEquals(resultBean30.getSyoruiNnm(), "第三者受取報告書", "取込書類名");

        exStringEquals(resultBean30.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean30.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean30.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean30.getImageId(), "", "イメージID");

        exStringEquals(resultBean30.getTorikomiSyoruiCd(), "sk009", "取込書類コード");

        exStringEquals(resultBean30.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean30.getKouteikanriId(), "sk009", "工程管理ＩＤ");

        exNumericEquals(resultBean30.getSortNo(), 90, "ソート番号");


        SyoruiJohoItiranBean resultBean31 = resultBeanLst.get(31);

        exStringEquals(resultBean31.getSyoruiNnm(), "ＦＡＴＣＡ確認書", "取込書類名");

        exStringEquals(resultBean31.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean31.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean31.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean31.getImageId(), "", "イメージID");

        exStringEquals(resultBean31.getTorikomiSyoruiCd(), "sk010", "取込書類コード");

        exStringEquals(resultBean31.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean31.getKouteikanriId(), "sk010", "工程管理ＩＤ");

        exNumericEquals(resultBean31.getSortNo(), 100, "ソート番号");


        SyoruiJohoItiranBean resultBean32 = resultBeanLst.get(32);

        exStringEquals(resultBean32.getSyoruiNnm(), "取扱報告書", "取込書類名");

        exStringEquals(resultBean32.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean32.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean32.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean32.getImageId(), "", "イメージID");

        exStringEquals(resultBean32.getTorikomiSyoruiCd(), "sk011", "取込書類コード");

        exStringEquals(resultBean32.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean32.getKouteikanriId(), "sk011", "工程管理ＩＤ");

        exNumericEquals(resultBean32.getSortNo(), 110, "ソート番号");


        SyoruiJohoItiranBean resultBean33 = resultBeanLst.get(33);

        exStringEquals(resultBean33.getSyoruiNnm(), "ペーパーレス取扱報告書", "取込書類名");

        exStringEquals(resultBean33.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean33.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean33.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean33.getImageId(), "", "イメージID");

        exStringEquals(resultBean33.getTorikomiSyoruiCd(), "sk012", "取込書類コード");

        exStringEquals(resultBean33.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean33.getKouteikanriId(), "sk012", "工程管理ＩＤ");

        exNumericEquals(resultBean33.getSortNo(), 120, "ソート番号");


        SyoruiJohoItiranBean resultBean34 = resultBeanLst.get(34);

        exStringEquals(resultBean34.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean34.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean34.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean34.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean34.getImageId(), "", "イメージID");

        exStringEquals(resultBean34.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean34.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean34.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean34.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean35 = resultBeanLst.get(35);

        exStringEquals(resultBean35.getSyoruiNnm(), "変更訂正書", "取込書類名");

        exStringEquals(resultBean35.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean35.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean35.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean35.getImageId(), "", "イメージID");

        exStringEquals(resultBean35.getTorikomiSyoruiCd(), "sk014", "取込書類コード");

        exStringEquals(resultBean35.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean35.getKouteikanriId(), "sk014", "工程管理ＩＤ");

        exNumericEquals(resultBean35.getSortNo(), 140, "ソート番号");


        SyoruiJohoItiranBean resultBean36 = resultBeanLst.get(36);

        exStringEquals(resultBean36.getSyoruiNnm(), "不備通知書", "取込書類名");

        exStringEquals(resultBean36.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean36.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean36.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean36.getImageId(), "", "イメージID");

        exStringEquals(resultBean36.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(resultBean36.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean36.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exNumericEquals(resultBean36.getSortNo(), 150, "ソート番号");


        SyoruiJohoItiranBean resultBean37 = resultBeanLst.get(37);

        exStringEquals(resultBean37.getSyoruiNnm(), "契約確認依頼書", "取込書類名");

        exStringEquals(resultBean37.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean37.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean37.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean37.getImageId(), "", "イメージID");

        exStringEquals(resultBean37.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(resultBean37.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean37.getKouteikanriId(), "sk033", "工程管理ＩＤ");

        exNumericEquals(resultBean37.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean resultBean38 = resultBeanLst.get(38);

        exStringEquals(resultBean38.getSyoruiNnm(), "契約確認回答書", "取込書類名");

        exStringEquals(resultBean38.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean38.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean38.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean38.getImageId(), "", "イメージID");

        exStringEquals(resultBean38.getTorikomiSyoruiCd(), "sk034", "取込書類コード");

        exStringEquals(resultBean38.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean38.getKouteikanriId(), "sk034", "工程管理ＩＤ");

        exNumericEquals(resultBean38.getSortNo(), 170, "ソート番号");


        SyoruiJohoItiranBean resultBean39 = resultBeanLst.get(39);

        exStringEquals(resultBean39.getSyoruiNnm(), "取消請求書", "取込書類名");

        exStringEquals(resultBean39.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean39.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean39.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean39.getImageId(), "", "イメージID");

        exStringEquals(resultBean39.getTorikomiSyoruiCd(), "sk038", "取込書類コード");

        exStringEquals(resultBean39.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean39.getKouteikanriId(), "sk038", "工程管理ＩＤ");

        exNumericEquals(resultBean39.getSortNo(), 180, "ソート番号");


        SyoruiJohoItiranBean resultBean40 = resultBeanLst.get(40);

        exStringEquals(resultBean40.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean40.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean40.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean40.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean40.getImageId(), "", "イメージID");

        exStringEquals(resultBean40.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean40.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean40.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean40.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean41 = resultBeanLst.get(41);

        exStringEquals(resultBean41.getSyoruiNnm(), "生命保険料支払申込書", "取込書類名");

        exStringEquals(resultBean41.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean41.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean41.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean41.getImageId(), "", "イメージID");

        exStringEquals(resultBean41.getTorikomiSyoruiCd(), "sk016", "取込書類コード");

        exStringEquals(resultBean41.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean41.getKouteikanriId(), "sk016", "工程管理ＩＤ");

        exNumericEquals(resultBean41.getSortNo(), 210, "ソート番号");


        SyoruiJohoItiranBean resultBean42 = resultBeanLst.get(42);

        exStringEquals(resultBean42.getSyoruiNnm(), "代筆報告書", "取込書類名");

        exStringEquals(resultBean42.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean42.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean42.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean42.getImageId(), "", "イメージID");

        exStringEquals(resultBean42.getTorikomiSyoruiCd(), "sk017", "取込書類コード");

        exStringEquals(resultBean42.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean42.getKouteikanriId(), "sk017", "工程管理ＩＤ");

        exNumericEquals(resultBean42.getSortNo(), 220, "ソート番号");


        SyoruiJohoItiranBean resultBean43 = resultBeanLst.get(43);

        exStringEquals(resultBean43.getSyoruiNnm(), "契約内容登録制度照会票", "取込書類名");

        exStringEquals(resultBean43.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean43.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean43.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean43.getImageId(), "", "イメージID");

        exStringEquals(resultBean43.getTorikomiSyoruiCd(), "sk046", "取込書類コード");

        exStringEquals(resultBean43.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean43.getKouteikanriId(), "sk046", "工程管理ＩＤ");

        exNumericEquals(resultBean43.getSortNo(), 230, "ソート番号");


        SyoruiJohoItiranBean resultBean44 = resultBeanLst.get(44);

        exStringEquals(resultBean44.getSyoruiNnm(), "非対面チェックシート", "取込書類名");

        exStringEquals(resultBean44.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean44.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean44.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean44.getImageId(), "", "イメージID");

        exStringEquals(resultBean44.getTorikomiSyoruiCd(), "sk018", "取込書類コード");

        exStringEquals(resultBean44.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean44.getKouteikanriId(), "sk018", "工程管理ＩＤ");

        exNumericEquals(resultBean44.getSortNo(), 240, "ソート番号");

    }

    @Test
    @TestOrder(150)
    public void testGetSyoruiJouhouItiranBetu_A15() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKHENKINKIBOU);

        IwfImageClientMockForBiz.mode = "qs-13";

        String[] kouteikanriId = new String[7];

        kouteikanriId[0] = "sk032";
        kouteikanriId[1] = "sk014";
        kouteikanriId[2] = "sk013";
        kouteikanriId[3] = "sk071";
        kouteikanriId[4] = "sk038";
        kouteikanriId[5] = "sk016";
        kouteikanriId[6] = "sk046";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        exStringEquals(outBean.getSyorikekkaStatus(), "0", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), null, "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), null, "詳細メッセージ");

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 7, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean resultBean0 = resultBeanLst.get(0);

        exStringEquals(resultBean0.getSyoruiNnm(), "その他付属資料", "取込書類名");

        exStringEquals(resultBean0.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean0.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean0.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean0.getImageId(), "", "イメージID");

        exStringEquals(resultBean0.getTorikomiSyoruiCd(), "sk013", "取込書類コード");

        exStringEquals(resultBean0.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean0.getKouteikanriId(), "sk013", "工程管理ＩＤ");

        exNumericEquals(resultBean0.getSortNo(), 130, "ソート番号");


        SyoruiJohoItiranBean resultBean1 = resultBeanLst.get(1);

        exStringEquals(resultBean1.getSyoruiNnm(), "変更訂正書", "取込書類名");

        exStringEquals(resultBean1.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean1.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean1.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean1.getImageId(), "", "イメージID");

        exStringEquals(resultBean1.getTorikomiSyoruiCd(), "sk014", "取込書類コード");

        exStringEquals(resultBean1.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean1.getKouteikanriId(), "sk014", "工程管理ＩＤ");

        exNumericEquals(resultBean1.getSortNo(), 140, "ソート番号");


        SyoruiJohoItiranBean resultBean2 = resultBeanLst.get(2);

        exStringEquals(resultBean2.getSyoruiNnm(), "不備通知書", "取込書類名");

        exStringEquals(resultBean2.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean2.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean2.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean2.getImageId(), "", "イメージID");

        exStringEquals(resultBean2.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(resultBean2.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean2.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exNumericEquals(resultBean2.getSortNo(), 150, "ソート番号");


        SyoruiJohoItiranBean resultBean3 = resultBeanLst.get(3);

        exStringEquals(resultBean3.getSyoruiNnm(), "取消請求書", "取込書類名");

        exStringEquals(resultBean3.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean3.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean3.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean3.getImageId(), "", "イメージID");

        exStringEquals(resultBean3.getTorikomiSyoruiCd(), "sk038", "取込書類コード");

        exStringEquals(resultBean3.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean3.getKouteikanriId(), "sk038", "工程管理ＩＤ");

        exNumericEquals(resultBean3.getSortNo(), 180, "ソート番号");


        SyoruiJohoItiranBean resultBean4 = resultBeanLst.get(4);

        exStringEquals(resultBean4.getSyoruiNnm(), "返金依頼書", "取込書類名");

        exStringEquals(resultBean4.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean4.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean4.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean4.getImageId(), "", "イメージID");

        exStringEquals(resultBean4.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(resultBean4.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean4.getKouteikanriId(), "sk071", "工程管理ＩＤ");

        exNumericEquals(resultBean4.getSortNo(), 190, "ソート番号");


        SyoruiJohoItiranBean resultBean5 = resultBeanLst.get(5);

        exStringEquals(resultBean5.getSyoruiNnm(), "生命保険料支払申込書", "取込書類名");

        exStringEquals(resultBean5.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean5.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean5.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean5.getImageId(), "", "イメージID");

        exStringEquals(resultBean5.getTorikomiSyoruiCd(), "sk016", "取込書類コード");

        exStringEquals(resultBean5.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean5.getKouteikanriId(), "sk016", "工程管理ＩＤ");

        exNumericEquals(resultBean5.getSortNo(), 210, "ソート番号");


        SyoruiJohoItiranBean resultBean6 = resultBeanLst.get(6);

        exStringEquals(resultBean6.getSyoruiNnm(), "契約内容登録制度照会票", "取込書類名");

        exStringEquals(resultBean6.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean6.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean6.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean6.getImageId(), "", "イメージID");

        exStringEquals(resultBean6.getTorikomiSyoruiCd(), "sk046", "取込書類コード");

        exStringEquals(resultBean6.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean6.getKouteikanriId(), "sk046", "工程管理ＩＤ");

        exNumericEquals(resultBean6.getSortNo(), 230, "ソート番号");


    }

    @Test
    @TestOrder(160)
    public void testGetSyoruiJouhouItiranBetu_A16() {

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        kinou.setKinouId(SyoruiResultConstants.SKHENKINKIBOU);

        IwfImageClientMockForBiz.mode = "qs-102";

        String[] kouteikanriId = new String[1];

        kouteikanriId[0] = "sk016";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJouhouItiranBetu(kouteikanriId);

        exStringEquals(outBean.getSyorikekkaStatus(), "0", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), null, "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), null, "詳細メッセージ");

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 1, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean resultBean0 = resultBeanLst.get(0);

        exStringEquals(resultBean0.getSyoruiNnm(), "生命保険料支払申込書", "取込書類名");

        exStringEquals(resultBean0.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exStringEquals(resultBean0.getHituyouSyorui(), "○", "書類名");

        exStringEquals(resultBean0.getHyoujiLink(), "", "表示リンク");

        exStringEquals(resultBean0.getImageId(), "", "イメージID");

        exStringEquals(resultBean0.getTorikomiSyoruiCd(), "sk016", "取込書類コード");

        exStringEquals(resultBean0.getHyoujiLinkFlg(), "", "表示リンクフラグ");

        exStringEquals(resultBean0.getKouteikanriId(), "sk016", "工程管理ＩＤ");

        exNumericEquals(resultBean0.getSortNo(), 210, "ソート番号");
    }



}
