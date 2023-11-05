package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.image.GetImageInBean;
import yuyu.common.biz.workflow.io.image.GetImagePropsInBean;
import yuyu.common.biz.workflow.io.image.GetImagePropsOutBean;
import yuyu.common.biz.workflow.io.image.PutArrivalImageInBean;
import yuyu.common.biz.workflow.io.image.PutImageInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageById;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdResponse.ImageInfoBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageResponse;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.testinfr.TestOrder;

/**
 * イメージ取得Webサービス {@link WSGetImageById#executeBizMain(WSGetImageByIdRequest)}
 * テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetImageByIdWebServiceTest {

    @Inject
    IwfImageClient iwfImageClient;
    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    @TestOrder(1)
    public void test_GetImageById_1_1() {
        iwfImageClient.execGetImage(null);
    }

    @Test
    @TestOrder(2)
    public void test_GetImageById_1_2() {
        GetImageInBean inBean = new GetImageInBean();

        WSGetImageByIdResponse response = iwfImageClient.execGetImage(inBean);

        System.out.println(response.getKekkastatus() + "::"
                + response.getSyousaimsgcd() + "::" + response.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
                response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：アカウントＩＤ",
                response.getSyousaimsg());
    }

    @Test
    @TestOrder(3)
    public void test_GetImageById_1_3() {
        GetImageInBean inBean = new GetImageInBean();

        String psAccountid = "ACID00000000000000000000000001";

        String[] psImageids = {};
        inBean.setAccountid(psAccountid);

        WSGetImageByIdResponse response = iwfImageClient.execGetImage(inBean);

        System.out.println(response.getKekkastatus() + "::"
                + response.getSyousaimsgcd() + "::" + response.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
                response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：イメージＩＤ配列",
                response.getSyousaimsg());

        inBean.setAccountid(psAccountid);
        inBean.setImageids(psImageids);

        response = iwfImageClient.execGetImage(inBean);

        System.out.println(response.getKekkastatus() + "::"
                + response.getSyousaimsgcd() + "::" + response.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
                response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：イメージＩＤ配列",
                response.getSyousaimsg());
    }

    @Test
    @TestOrder(7)
    public void test_GetImageById_1_4() {
        String psAccountid = "JUnit";
        String[] psImageids = { "12q2dlecu84tutansy" };

        GetImageInBean inBean = new GetImageInBean();

        inBean.setAccountid(psAccountid);
        inBean.setImageids(psImageids);

        WSGetImageByIdResponse response = iwfImageClient.execGetImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::"
                + response.getSyousaimsgcd() + ":::" + response.getSyousaimsg()
                + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
                response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3052", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "取込書類マスタから、レコードが取得できませんでした。",
                response.getSyousaimsg());
    }

    @Test
    @TestOrder(8)
    public void test_GetImageById_1_5() {
        String psAccountid = "JUnit";
        String[] psImageids = { "0rc2den11lm2f0c1s2" };

        GetImageInBean inBean = new GetImageInBean();

        inBean.setAccountid(psAccountid);
        inBean.setImageids(psImageids);

        WSGetImageByIdResponse response = iwfImageClient.execGetImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::"
                + response.getSyousaimsgcd() + ":::" + response.getSyousaimsg()
                + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
                response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3050", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "トークンIDが取得できませんでした。", response.getSyousaimsg());
    }

    @Test
    @TestOrder(9)
    public void test_GetImageById_1_6() {
        String psAccountid = "JUnit";
        String[] psImageids = { "2cdby5oz8nu3pxgw" };

        GetImageInBean inBean = new GetImageInBean();

        inBean.setAccountid(psAccountid);
        inBean.setImageids(psImageids);

        WSGetImageByIdResponse response = iwfImageClient.execGetImage(inBean);

        System.out.println("============" + response.getKekkastatus() + ":::"
                + response.getSyousaimsgcd() + ":::" + response.getSyousaimsg()
                + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
                response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3051", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "プロセス定義が取得できませんでした。", response.getSyousaimsg());
    }

    @Test
    @TestOrder(4)
    public void test_GetImageById_2_1() throws IOException {
        String psAccountid = "Junit";
        String[] psImageids = { "0p72ddd67kqhbsisch" };

        GetImageInBean inBean = new GetImageInBean();

        inBean.setAccountid(psAccountid);
        inBean.setImageids(psImageids);

        WSGetImageByIdResponse response = iwfImageClient.execGetImage(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
                response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ID指定イメージ取得正常終了しました。",
                response.getSyousaimsg());
        assertEquals("検索件数:", 1, response.getImageinfolist().size());

        ImageInfoBean imageInfoBean = response.getImageinfolist().get(0);

        System.out.println(imageInfoBean.getImageid() + "::"
                + imageInfoBean.getGyoumukey() + "::"
                + imageInfoBean.getTorikomisyoruicd() + "::"
                + imageInfoBean.getSyoruitoutyakutime() + "::"
                + imageInfoBean.getKengenumu());

        createFile("D:/test.pdf", imageInfoBean.getPdfimage());
    }

    @Test
    @TestOrder(5)
    public void test_GetImageById_3_1() {
        String psAccountid = "JUnit";
        String[] psImageids = { "2cdam62vsfnl6o01" };

        GetImageInBean inBean = new GetImageInBean();

        inBean.setAccountid(psAccountid);
        inBean.setImageids(psImageids);

        WSGetImageByIdResponse response = iwfImageClient.execGetImage(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
                response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ID指定イメージ取得正常終了しました。",
                response.getSyousaimsg());
        assertEquals("検索件数:", 0, response.getImageinfolist().size());
    }

    @Test
    @TestOrder(6)
    public void test_GetImageById_3_2() {
        String psAccountid = "JUnit";
        String[] psImageids = { "12u2dlewsa95jgzz0i", "12g2dle7j8tcoly7lu",
        "12h2dle84cyslndiwy" };

        GetImageInBean inBean = new GetImageInBean();

        inBean.setAccountid(psAccountid);
        inBean.setImageids(psImageids);

        WSGetImageByIdResponse response = iwfImageClient.execGetImage(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
                response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ID指定イメージ取得正常終了しました。",
                response.getSyousaimsg());
        assertEquals("検索件数:", true, response.getImageinfolist().size() >= 2);
    }

    @Test
    @TestOrder(10)
    public void testSyoriLogicOK03() throws Exception {

        IwfCoreConfig.getInstance().setLockYouhi(false);

        String gyoumukey = TestUtil.nString_zenkaku(9);
        String gyoumukey1 = TestUtil.nString_zenkaku(10);
        String arrivekey = "20160411092737928";
        String lockkey = TestUtil.nString_zenkaku(12);
        String lockkey1 = TestUtil.nString_zenkaku(13);
        String flowId = "tt4";
        String accountid = "JUnit";
        String syoruicd = "kk016";
        ProcessCreateInBean befProcessCreateInBean1 = new ProcessCreateInBean();
        befProcessCreateInBean1.setGyoumukey(gyoumukey);
        befProcessCreateInBean1.setFlowid(flowId);
        befProcessCreateInBean1.setAccountid(accountid);
        ProcessCreateOutBean befProcessCreateOutBean1 = iwfKouteiClient
                .execProcessCreate(befProcessCreateInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(
                befProcessCreateOutBean1.getKekkastatus())) {
            throw new Exception("前処理：工程作成１実行失敗！");
        }

        PutImageInBean befPutImageInBean = new PutImageInBean();
        befPutImageInBean.setSyoruicd(syoruicd);
        befPutImageInBean.setAccountid(accountid);
        befPutImageInBean.setFlowid(flowId);
        befPutImageInBean.setImagedata(readTestFile("putimage/Test.pdf"));
        befPutImageInBean.setGyoumukey(gyoumukey);
        WSPutImageResponse befWSPutImageResponse = iwfImageClient
                .execPutImage(befPutImageInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
                befWSPutImageResponse.getKekkastatus())) {
            throw new Exception("前処理：イメージ登録実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean2 = new ProcessCreateInBean();
        befProcessCreateInBean2.setGyoumukey(gyoumukey1);
        befProcessCreateInBean2.setFlowid(flowId);
        befProcessCreateInBean2.setAccountid(accountid);
        ProcessCreateOutBean befProcessCreateOutBean2 = iwfKouteiClient
                .execProcessCreate(befProcessCreateInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(
                befProcessCreateOutBean2.getKekkastatus())) {
            throw new Exception("前処理：工程作成２実行失敗！");
        }

        PutArrivalImageInBean befPutArrivalImageInBean = new PutArrivalImageInBean();
        befPutArrivalImageInBean.setArrivekey(arrivekey);
        befPutArrivalImageInBean
        .setImagedata(readTestFile("putimage/Test.pdf"));
        WSPutArrivalImageResponse befWSPutArrivalImageResponse = iwfImageClient
                .PutArrivalImage(befPutArrivalImageInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
                befWSPutArrivalImageResponse.getKekkastatus())) {
            throw new Exception("前処理：到着イメージ登録実行失敗！");
        }

        GetImagePropsInBean befGetImagePropsInBean = new GetImagePropsInBean();
        befGetImagePropsInBean.setAccountid(accountid);
        befGetImagePropsInBean.setFlowid(flowId);
        befGetImagePropsInBean.setGyoumukey(gyoumukey1);
        befGetImagePropsInBean.setTorikomisyoruicd(syoruicd);
        GetImagePropsOutBean befGetImagePropsOutBean = iwfImageClient
                .execGetImageProps(befGetImagePropsInBean);
        if (!C_ResultCdKbn.OK.toString().equals(
                befGetImagePropsOutBean.getKekkastatus())) {
            throw new Exception("前処理：イメージプロパティ取得実行失敗！");
        }

        GetImageInBean getImageInBean = new GetImageInBean();
        getImageInBean
        .setImageids(new String[] {
                befWSPutImageResponse.getImgid() });
        getImageInBean.setAccountid(accountid);
        WSGetImageByIdResponse wSGetImageByIdResponse = iwfImageClient
                .execGetImage(getImageInBean);

        boolean result = true;
        result = result
                && C_ResultCdKbn.OK.toString().equals(
                        wSGetImageByIdResponse.getKekkastatus());
        result = result
                && "IWF0000".equals(wSGetImageByIdResponse.getSyousaimsgcd());
        result = result
                && "ID指定イメージ取得正常終了しました。".equals(wSGetImageByIdResponse
                        .getSyousaimsg());
        result = result
                && 1 == wSGetImageByIdResponse.getImageinfolist().size();

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey(gyoumukey);
        aftProcessCancelInBean1.setFlowid(flowId);
        aftProcessCancelInBean1.setAccountid(accountid);
        aftProcessCancelInBean1.setLockkey(lockkey);
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient
                .execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(
                aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey(gyoumukey1);
        aftProcessCancelInBean2.setFlowid(flowId);
        aftProcessCancelInBean2.setAccountid(accountid);
        aftProcessCancelInBean2.setLockkey(lockkey1);
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient
                .execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(
                aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(true);
    }

    private byte[] readTestFile(String pdfName) throws Exception {

        String sPath = this.getClass().getResource("").toString();
        if (sPath.startsWith("file:/")) {
            sPath = sPath.substring(6);
        }

        File oFile = new File(sPath + pdfName);

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(
                oFile));

        try {

            ByteArrayOutputStream bos = new ByteArrayOutputStream(
                    (int) oFile.length());

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

    private void createFile(String path, byte[] content) throws IOException {
        try {
            FileOutputStream fos;

            fos = new FileOutputStream(path);
            fos.write(content);
            fos.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}
