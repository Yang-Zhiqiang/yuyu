package yuyu.common.biz.workflow.putimage;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.workflowcore.configration.IwfCoreConfig;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.image.PutImageInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.IWSPutImageIOKey;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImage;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageResponse;

/**
 * イメージ登録Webサービス {@link WSPutImage#executeBizMain(WSPutImageRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class PutImageWebServiceTest {

    @Inject
    IwfImageClient iwfImageClient;
    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void test_PutImage_01() {

        PutImageInBean inBean = null;
        iwfImageClient.execPutImage(inBean);
    }

    @Test
    public void test_PutImage_02() {

        String psAccountid = "Tt";
        String sSyoruicd = null;

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：取込書類コード",
            response.getSyousaimsg());
    }

    @Test
    public void test_PutImage_03() {

        String psAccountid = "Tt";
        String sSyoruicd = "200";
        String psFlowid = null;

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：フローＩＤ",
            response.getSyousaimsg());
    }

    @Test
    public void test_PutImage_04() {

        String psAccountid = "Tt";
        String sSyoruicd = "200";
        String psFlowid = "09";
        byte[] pbImagedata = null;

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);
        inBean.setImagedata(pbImagedata);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：イメージデータ",
            response.getSyousaimsg());
    }

    @Test
    public void test_PutImage_05() throws Exception {

        String psAccountid = "ACID00000000000000000000000001";
        String sSyoruicd = "TOCD00000000000000000000000001";
        String psFlowid = "FLID000000000000001";
        byte[] pbImagedata = readTestFile("Test.pdf");
        String psGyoumukey = "20150803112547415";
        String psSyoruitoutyakutime = "20150801010111123";
        String psTourokutime = "20150808010111123";

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);
        inBean.setImagedata(pbImagedata);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setSyoruitoutyakutime(psSyoruitoutyakutime);
        inBean.setTourokutime(psTourokutime);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "イメージ登録正常終了しました。",
            response.getSyousaimsg());
    }

    @Test
    public void test_PutImage_06() throws Exception {

        String psAccountid = "ACID00000000000000000000000001";
        String sSyoruicd = "TOCD000000000000000000000000012";
        String psFlowid = "FLID000000000000001";
        byte[] pbImagedata = readTestFile("Test.pdf");
        String psGyoumukey = "20150803112547415";
        String psSyoruitoutyakutime = "20150801010111123";

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);
        inBean.setImagedata(pbImagedata);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setSyoruitoutyakutime(psSyoruitoutyakutime);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "取込書類コードは30文字以内で入力してください。",
            response.getSyousaimsg());

    }

    @Test
    public void test_PutImage_07() throws Exception {

        String psAccountid = "ACID000000000000000000000000012";
        String sSyoruicd = "TOCD00000000000000000000000001";
        String psFlowid = "FLID000000000000001";
        byte[] pbImagedata = readTestFile("Test.pdf");
        String psGyoumukey = "20150803112547415";
        String psSyoruitoutyakutime = "20150801010111123";

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);
        inBean.setImagedata(pbImagedata);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setSyoruitoutyakutime(psSyoruitoutyakutime);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "アカウントＩＤは30文字以内で入力してください。",
            response.getSyousaimsg());

    }

    @Test
    public void test_PutImage_08() throws Exception {

        String psAccountid = "ACID00000000000000000000000001";
        String sSyoruicd = "TOCD00000000000000000000000001";
        String psFlowid = "FLID0000000000000012";
        byte[] pbImagedata = readTestFile("Test.pdf");
        String psGyoumukey = "20150803112547415";
        String psSyoruitoutyakutime = "20150801010111123";

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);
        inBean.setImagedata(pbImagedata);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setSyoruitoutyakutime(psSyoruitoutyakutime);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "フローＩＤは19文字以内で入力してください。",
            response.getSyousaimsg());
    }

    @Test
    public void test_PutImage_09() throws Exception {

        String psAccountid = "ACID00000000000000000000000001";
        String sSyoruicd = "TOCD00000000000000000000000001";
        String psFlowid = "FLID000000000000001";
        byte[] pbImagedata = readTestFile("Test.pdf");
        String psGyoumukey = "201508031125474151234";
        String psSyoruitoutyakutime = "20150801010111123";

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);
        inBean.setImagedata(pbImagedata);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setSyoruitoutyakutime(psSyoruitoutyakutime);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "業務キーは20文字以内で入力してください。",
            response.getSyousaimsg());
    }

    @Test
    public void test_PutImage_10() throws Exception {

        String psAccountid = "ACID00000000000000000000000001";
        String sSyoruicd = "TOCD00000000000000000000000009";
        String psFlowid = "FLID000000000000001";
        byte[] pbImagedata = readTestFile("Test.pdf");
        String psGyoumukey = "20150803112547415";
        String psSyoruitoutyakutime = "20150801010111123";

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);
        inBean.setImagedata(pbImagedata);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setSyoruitoutyakutime(psSyoruitoutyakutime);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3092", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "取込書類マスタのレコードが取得できませんでした。",
            response.getSyousaimsg());
    }

    @Test
    public void test_PutImage_11() throws Exception {

        String psAccountid = "ACID00000000000000000000000001";
        String sSyoruicd = "TOCD00000000000000000000000001";
        String psFlowid = "FLID000000000000009";
        byte[] pbImagedata = readTestFile("Test.pdf");
        String psGyoumukey = "20150803112547415";
        String psSyoruitoutyakutime = "20150801010111123";

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);
        inBean.setImagedata(pbImagedata);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setSyoruitoutyakutime(psSyoruitoutyakutime);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3091", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "プロセス定義が取得できませんでした。",
            response.getSyousaimsg());
    }

    @Test
    public void test_PutImage_12() throws Exception {

        String psAccountid = "ACID00000000000000000000000001";
        String sSyoruicd = "TOCD00000000000000000000000001";
        String psFlowid = "FLID000000000000001";
        byte[] pbImagedata = readTestFile("Test.pdf");
        String psGyoumukey = "201508031125474151";
        String psSyoruitoutyakutime = "20150801010111123";

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);
        inBean.setImagedata(pbImagedata);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setSyoruitoutyakutime(psSyoruitoutyakutime);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3093", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "トークンIDが取得できませんでした。",
            response.getSyousaimsg());
    }

    @Test
    public void test_PutImage_13() throws Exception {

        String psAccountid = "ACID00000000000000000000000001";
        String sSyoruicd = "TOCD00000000000000000000000001";
        String psFlowid = "FLID000000000000001";
        byte[] pbImagedata = readTestFile("Test.pdf");
        String psGyoumukey = "20150803112547415";

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);
        inBean.setImagedata(pbImagedata);
        inBean.setGyoumukey(psGyoumukey);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "イメージ登録正常終了しました。",
            response.getSyousaimsg());
    }

    @Test
    public void test_PutImage_14() throws Exception {
        String psAccountid = "ACID00000000000000000000000001";
        String psFlowid = "FLID000000000000001";
        String psGyoumukey = "20150803112547415";
        String psTorikomisyoruicd = "TOCD00000000000000000000000001";
        String psSyoruitoutyakutime = "20150801010111123";
        String psTourokutime = "20150808010111123";
        byte[] pbImagedata = readTestFile("Test.pdf");

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSPutImageIOKey.IN.sS_EXT_INFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("拡張パラメータ１");
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues("拡張パラメータ２");
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues("拡張パラメータ３");
        WSExtParam poExtparam4 = new WSExtParam();
        poExtparam4.setValues("拡張パラメータ４");
        WSExtParam poExtparam5 = new WSExtParam();
        poExtparam5.setValues("拡張パラメータ５");
        WSExtParam poExtparam6 = new WSExtParam();
        poExtparam6.setValues("拡張パラメータ６");
        WSExtParam poExtparam7 = new WSExtParam();
        poExtparam7.setValues("拡張パラメータ７");
        WSExtParam poExtparam8 = new WSExtParam();
        poExtparam8.setValues("拡張パラメータ８");
        WSExtParam poExtparam9 = new WSExtParam();
        poExtparam9.setValues("拡張パラメータ９");
        WSExtParam poExtparam10 = new WSExtParam();
        poExtparam10.setValues("拡張パラメータ１０");
        WSExtParam poExtparam11 = new WSExtParam();
        poExtparam11.setValues("拡張パラメータ１１");
        WSExtParam poExtparam12 = new WSExtParam();
        poExtparam12.setValues("拡張パラメータ１２");
        WSExtParam poExtparam13 = new WSExtParam();
        poExtparam13.setValues("拡張パラメータ１３");
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues("拡張パラメータ１４");
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues("拡張パラメータ１５");

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setFlowid(psFlowid);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setImagedata(pbImagedata);
        inBean.setSyoruicd(psTorikomisyoruicd);
        inBean.setSyoruitoutyakutime(psSyoruitoutyakutime);
        inBean.setTourokutime(psTourokutime);

        inBean.setExtInfo(poExtinfoMapList);
        inBean.setExtParam1(poExtparam1);
        inBean.setExtParam2(poExtparam2);
        inBean.setExtParam3(poExtparam3);
        inBean.setExtParam4(poExtparam4);
        inBean.setExtParam5(poExtparam5);
        inBean.setExtParam6(poExtparam6);
        inBean.setExtParam7(poExtparam7);
        inBean.setExtParam8(poExtparam8);
        inBean.setExtParam9(poExtparam9);
        inBean.setExtParam10(poExtparam10);
        inBean.setExtParam11(poExtparam11);
        inBean.setExtParam12(poExtparam12);
        inBean.setExtParam13(poExtparam13);
        inBean.setExtParam14(poExtparam14);
        inBean.setExtParam15(poExtparam15);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "イメージ登録正常終了しました。",
            response.getSyousaimsg());
    }

    @Test
    public void test_PutImage_15() throws Exception {

        String psAccountid = "ACID00000000000000000000000001";
        String sSyoruicd = "TOCD00000000000000000000000001";
        String psFlowid = "FLID000000000000001";
        byte[] pbImagedata = readTestFile("Test.pdf");
        String psGyoumukey = "20150803112547415";
        String psSyoruitoutyakutime = "201508010101111234";
        String psTourokutime = "20150808010111123";

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);
        inBean.setImagedata(pbImagedata);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setSyoruitoutyakutime(psSyoruitoutyakutime);
        inBean.setTourokutime(psTourokutime);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "書類到着日時は17文字以内で入力してください。",
            response.getSyousaimsg());
    }

    @Test
    public void test_PutImage_16() throws Exception {

        String psAccountid = "ACID00000000000000000000000001";
        String sSyoruicd = "TOCD00000000000000000000000001";
        String psFlowid = "FLID000000000000001";
        byte[] pbImagedata = readTestFile("Test.pdf");
        String psGyoumukey = "20150803112547415";
        String psSyoruitoutyakutime = "20150801010111123";
        String psTourokutime = "201508080101111234";

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);
        inBean.setImagedata(pbImagedata);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setSyoruitoutyakutime(psSyoruitoutyakutime);
        inBean.setTourokutime(psTourokutime);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "登録日時は17文字以内で入力してください。",
            response.getSyousaimsg());
    }

    @Test
    public void test_PutImage_17() throws Exception {

        String psAccountid = "ACID00000000000000000000000001";
        String sSyoruicd = "TOCD00000000000000000000000001";
        String psFlowid = "FLID000000000000001";
        byte[] pbImagedata = readTestFile("Test1.pdf");
        String psGyoumukey = "20150803112547415";

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);
        inBean.setImagedata(pbImagedata);
        inBean.setGyoumukey(psGyoumukey);

        WSPutImageResponse response = iwfImageClient.execPutImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::" + response.getSyousaimsgcd() + ":::"
            + response.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "イメージ登録正常終了しました。",
            response.getSyousaimsg());
    }

    @Test
    public void testSyoriLogicOK03() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid("09");
        befProcessCreateInBean.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        PutImageInBean putImageInBean = new PutImageInBean();
        putImageInBean.setSyoruicd("200");
        putImageInBean.setAccountid("Tt");
        putImageInBean.setFlowid("09");
        putImageInBean.setImagedata(readTestFile("Test.pdf"));
        putImageInBean.setGyoumukey(gyoumukey);
        WSPutImageResponse wSPutImageResponse = iwfImageClient.execPutImage(putImageInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid("09");
        aftProcessCancelInBean.setAccountid("Tt");
        aftProcessCancelInBean.setLockkey("ロックキー2_3");
        IwfCoreConfig.getInstance().setLockYouhi(false);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSPutImageResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSPutImageResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "イメージ登録正常終了しました。", wSPutImageResponse.getSyousaimsg());
        assertNotEquals("", wSPutImageResponse.getImgid());

    }

    private byte[] readTestFile(String pdfName) throws Exception {

        String sPath = this.getClass().getResource("").toString();
        if (sPath.startsWith("file:/")) {
            sPath = sPath.substring(6);
        }

        File oFile = new File(sPath + pdfName);

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(oFile));

        try {

            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) oFile.length());

            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            in.close();
        }
    }

}
