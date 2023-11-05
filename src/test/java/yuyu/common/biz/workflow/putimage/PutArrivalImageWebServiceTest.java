package yuyu.common.biz.workflow.putimage;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.workflowcore.configration.IwfCoreConfig;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.image.CreateExpectedArrivalNoticeInBean;
import yuyu.common.biz.workflow.io.image.PutArrivalImageInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImage;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageResponse;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.testinfr.TestOrder;

/**
 * イメージ到着Webサービス {@link WSPutArrivalImage#executeBizMain(WSPutArrivalImageRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class PutArrivalImageWebServiceTest {

    @Inject
    IwfImageClient iwfImageClient;
    @Inject
    IwfKouteiClient iwfKouteiClient;

    public void testOK() throws Exception {
        String psArrivekey = "tangtao";

        PutArrivalImageInBean inBean = new PutArrivalImageInBean();
        inBean.setImagedata(readTestFile());
        inBean.setArrivekey(psArrivekey);

        WSPutArrivalImageResponse response = iwfImageClient.PutArrivalImage(inBean);
        assertEquals(C_ResultCdKbn.OK.toString(), response.getKekkastatus());
    }

    @Test(expected=RuntimeException.class)
    @TestOrder(2)
    public void test_PutArrivalImage_01() {
        iwfImageClient.PutArrivalImage(null);
    }

    @Test
    @TestOrder(3)
    public void test_PutArrivalImage_02() throws Exception {

        PutArrivalImageInBean inBean = new PutArrivalImageInBean();

        inBean.setArrivekey(null);
        inBean.setImagedata(readTestFile());

        WSPutArrivalImageResponse response = iwfImageClient.PutArrivalImage(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0002", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(4)
    public void test_PutArrivalImage_03() throws Exception {

        PutArrivalImageInBean inBean = new PutArrivalImageInBean();

        inBean.setArrivekey("");
        inBean.setImagedata(readTestFile());

        WSPutArrivalImageResponse response = iwfImageClient.PutArrivalImage(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0002", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(5)
    public void test_PutArrivalImage_04() throws Exception {

        PutArrivalImageInBean inBean = new PutArrivalImageInBean();

        inBean.setArrivekey(BizDate.getSysDateTimeMilli());
        inBean.setImagedata(null);

        WSPutArrivalImageResponse response = iwfImageClient.PutArrivalImage(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0002", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(6)
    public void test_PutArrivalImage_05() throws Exception {

        PutArrivalImageInBean inBean = new PutArrivalImageInBean();

        inBean.setArrivekey(BizDate.getSysDateTimeMilli());
        inBean.setImagedata("".getBytes());

        WSPutArrivalImageResponse response = iwfImageClient.PutArrivalImage(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0002", response.getSyousaimsgcd());

    }

    public void test_PutArrivalImage_06() throws Exception {

        String arriveKey = BizDate.getSysDateTimeMilli()+"八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十";
        putArrivalNotice(arriveKey);

        PutArrivalImageInBean inBean = new PutArrivalImageInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setImagedata(readTestFile());

        WSPutArrivalImageResponse response = iwfImageClient.PutArrivalImage(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("IWF0000", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(8)
    public void test_PutArrivalImage_07() throws Exception {

        PutArrivalImageInBean inBean = new PutArrivalImageInBean();

        inBean.setArrivekey(BizDate.getSysDateTimeMilli()+"八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一");
        inBean.setImagedata(readTestFile());

        WSPutArrivalImageResponse response = iwfImageClient.PutArrivalImage(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0008", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(9)
    public void test_PutArrivalImage_08() throws Exception {

        String arriveKey = "20160412095054996";
        putArrivalNotice(arriveKey);

        PutArrivalImageInBean inBean = new PutArrivalImageInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setImagedata(readTestFile());

        WSPutArrivalImageResponse response = iwfImageClient.PutArrivalImage(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("IWF0000", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(10)
    public void test_PutArrivalImage_09() throws Exception {

        String arriveKey = BizDate.getSysDateTimeMilli();
        putArrivalNotice(arriveKey);

        PutArrivalImageInBean inBean = new PutArrivalImageInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setImagedata(readTestFile());

        iwfImageClient.PutArrivalImage(inBean);
        WSPutArrivalImageResponse response = iwfImageClient.PutArrivalImage(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("IWF0000", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(11)
    public void test_PutArrivalImage_10() throws Exception {

        PutArrivalImageInBean inBean = new PutArrivalImageInBean();

        inBean.setArrivekey("NoData");
        inBean.setImagedata(readTestFile());

        WSPutArrivalImageResponse response = iwfImageClient.PutArrivalImage(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF3081", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(12)
    public void test_PutArrivalImage_11() throws Exception {

        String arriveKey = BizDate.getSysDateTimeMilli();
        putArrivalNotice(arriveKey);

        PutArrivalImageInBean inBean = new PutArrivalImageInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setImagedata(readTestFile());

        WSPutArrivalImageResponse response = iwfImageClient.PutArrivalImage(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("IWF0000", response.getSyousaimsgcd());

    }

    public void test_PutArrivalImage_12() throws Exception {

        String arriveKey = BizDate.getSysDateTimeMilli();
        putArrivalNotice(arriveKey);

        PutArrivalImageInBean inBean = new PutArrivalImageInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setImagedata(readTextFile());

        WSPutArrivalImageResponse response = iwfImageClient.PutArrivalImage(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0001", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(14)
    public void test_PutArrivalImage_13() throws Exception {

        String arriveKey = BizDate.getSysDateTimeMilli();
        putArrivalNotice(arriveKey);

        PutArrivalImageInBean inBean = new PutArrivalImageInBean();

        inBean.setArrivekey(arriveKey);
        byte[] pdfByte = readTestFile();
        inBean.setImagedata(pdfByte);

        WSPutArrivalImageResponse response = iwfImageClient.PutArrivalImage(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF3090", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(14)
    public void testSyoriLogicOK07() throws Exception {

        IwfCoreConfig.getInstance().setLockYouhi(false);

        String gyoumuKey = BizDate.getSysDateTimeMilli();
        String flowId = "tt4";
        String accountId = "JUnit";
        String lockkey = BizDate.getSysDateTimeMilli();

        putArrivalNotice(gyoumuKey);
        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumuKey);
        befProcessCreateInBean.setFlowid(flowId);
        befProcessCreateInBean.setAccountid(accountId);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        PutArrivalImageInBean putArrivalImageInBean = new PutArrivalImageInBean();
        putArrivalImageInBean.setArrivekey(gyoumuKey);
        putArrivalImageInBean.setImagedata(readTestFile());
        WSPutArrivalImageResponse wSPutArrivalImageResponse = iwfImageClient.PutArrivalImage(putArrivalImageInBean);


        assertEquals(C_ResultCdKbn.OK.toString(), wSPutArrivalImageResponse.getKekkastatus());
        assertEquals("IWF0000", wSPutArrivalImageResponse.getSyousaimsgcd());
        assertEquals("到着イメージ登録正常終了しました。", wSPutArrivalImageResponse.getSyousaimsg());

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumuKey);
        aftProcessCancelInBean.setFlowid(flowId);
        aftProcessCancelInBean.setAccountid(accountId);
        aftProcessCancelInBean.setLockkey(lockkey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        IwfCoreConfig.getInstance().setLockYouhi(true);

    }

    private byte[] readTestFile() throws Exception {

        String sPath = this.getClass().getResource("").toString();
        if (sPath.startsWith("file:/")) {
            sPath = sPath.substring(6);
        }

        File oFile = new File(sPath + "Test.pdf");

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
            throw e;
        } finally {
            in.close();
        }
    }

    private byte[] readTextFile() throws Exception {

        String sPath = this.getClass().getResource("").toString();
        if (sPath.startsWith("file:/")) {
            sPath = sPath.substring(6);
        }

        File oFile = new File(sPath + "Test.txt");

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
            throw e;
        } finally {
            in.close();
        }
    }

    private void putArrivalNotice(String psArriveKey) {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey(psArriveKey);
        inBean.setGyoumukey("wf001");
        inBean.setTorikomisyoruicd("wf001");
        inBean.setFlowid("tt4");
        inBean.setSubsystemid("hozen");

        iwfImageClient.CreateExpectedArrivalNotice(inBean);

    }
}


