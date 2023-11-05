package yuyu.common.biz.workflow;

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

import jp.co.slcs.swak.date.BizDate;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.image.DropImageInBean;
import yuyu.common.biz.workflow.io.image.PutImageInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageById;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageResponse;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.testinfr.OrderedRunner;

/**
 * イメージ削除Webサービス {@link WSDropImageById#executeBizMain(WSDropImageByIdRequest)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DropImageByIdWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;
    @Inject
    IwfImageClient iwfImageClient;

    @Test(expected = RuntimeException.class)
    public void testValidationNG01() {

        iwfImageClient.execDropImage(null);
    }

    @Test
    public void testValidationNG02() {
        DropImageInBean dropImageInBean = new DropImageInBean();
        dropImageInBean.setAccountid("Tt");
        dropImageInBean.setImageids(null);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        dropImageInBean.setExtInfo(extinfoMapList);
        WSDropImageByIdResponse wSDropImageByIdResponse = iwfImageClient.execDropImage(dropImageInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSDropImageByIdResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", wSDropImageByIdResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：イメージＩＤ配列", wSDropImageByIdResponse.getSyousaimsg());

    }

    @Test
    public void testValidationNG03() {
        DropImageInBean dropImageInBean = new DropImageInBean();
        dropImageInBean.setAccountid("Tt");
        dropImageInBean.setImageids(new String[0]);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        dropImageInBean.setExtInfo(extinfoMapList);
        WSDropImageByIdResponse wSDropImageByIdResponse = iwfImageClient.execDropImage(dropImageInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSDropImageByIdResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", wSDropImageByIdResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：イメージＩＤ配列", wSDropImageByIdResponse.getSyousaimsg());

    }

    @Test
    public void testValidationOK01() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String lockKey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid("09");
        befProcessCreateInBean.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid("Tt");
        inBean.setSyoruicd("200");
        inBean.setFlowid("09");
        inBean.setImagedata(readTestFile("Test.pdf"));
        inBean.setGyoumukey(gyoumukey);
        String imgId = iwfImageClient.execPutImage(inBean).getImgid();

        DropImageInBean dropImageInBean = new DropImageInBean();
        dropImageInBean.setAccountid("Tt");
        dropImageInBean.setImageids(new String[] {imgId});
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", null);
        extinfoMapList.add(extinfoMap);
        dropImageInBean.setExtInfo(extinfoMapList);
        WSDropImageByIdResponse wSDropImageByIdResponse = iwfImageClient.execDropImage(dropImageInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid("09");
        aftProcessCancelInBean.setAccountid("Tt");
        aftProcessCancelInBean.setLockkey(lockKey);
        IwfCoreConfig.getInstance().setLockYouhi(false);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSDropImageByIdResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSDropImageByIdResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ID指定イメージ削除正常終了しました。", wSDropImageByIdResponse.getSyousaimsg());

    }

    @Test
    public void testValidationOK02() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String lockKey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid("09");
        befProcessCreateInBean.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid("Tt");
        inBean.setSyoruicd("200");
        inBean.setFlowid("09");
        inBean.setImagedata(readTestFile("Test.pdf"));
        inBean.setGyoumukey(gyoumukey);
        String imgId = iwfImageClient.execPutImage(inBean).getImgid();

        DropImageInBean dropImageInBean = new DropImageInBean();
        dropImageInBean.setAccountid("Tt");
        dropImageInBean.setImageids(new String[] {imgId});
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "");
        extinfoMapList.add(extinfoMap);
        dropImageInBean.setExtInfo(extinfoMapList);
        WSDropImageByIdResponse wSDropImageByIdResponse = iwfImageClient.execDropImage(dropImageInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid("09");
        aftProcessCancelInBean.setAccountid("Tt");
        aftProcessCancelInBean.setLockkey(lockKey);
        IwfCoreConfig.getInstance().setLockYouhi(false);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSDropImageByIdResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSDropImageByIdResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ID指定イメージ削除正常終了しました。", wSDropImageByIdResponse.getSyousaimsg());

    }

    @Test
    public void testKyoukaiOK01() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String lockKey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid("09");
        befProcessCreateInBean.setAccountid("Tt1234567890123456789012345678");

        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid("Tt1234567890123456789012345678");
        inBean.setSyoruicd("200");
        inBean.setFlowid("09");
        inBean.setImagedata(readTestFile("Test.pdf"));
        inBean.setGyoumukey(gyoumukey);
        String imgId = iwfImageClient.execPutImage(inBean).getImgid();

        DropImageInBean dropImageInBean = new DropImageInBean();
        dropImageInBean.setAccountid("Tt1234567890123456789012345678");
        dropImageInBean.setImageids(new String[] {imgId});
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        dropImageInBean.setExtInfo(extinfoMapList);
        WSDropImageByIdResponse wSDropImageByIdResponse = iwfImageClient.execDropImage(dropImageInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid("09");
        aftProcessCancelInBean.setAccountid("Tt1234567890123456789012345678");
        aftProcessCancelInBean.setLockkey(lockKey);
        IwfCoreConfig.getInstance().setLockYouhi(false);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSDropImageByIdResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSDropImageByIdResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ID指定イメージ削除正常終了しました。", wSDropImageByIdResponse.getSyousaimsg());

    }

    @Test
    public void testKyoukaiNG01() {
        DropImageInBean dropImageInBean = new DropImageInBean();
        dropImageInBean.setAccountid("Tt12345678901234567890123456789");
        dropImageInBean.setImageids(new String[] {"イメージＩＤ配列2_3"});
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        dropImageInBean.setExtInfo(extinfoMapList);
        WSDropImageByIdResponse wSDropImageByIdResponse = iwfImageClient.execDropImage(dropImageInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSDropImageByIdResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", wSDropImageByIdResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "アカウントＩＤは30文字以内で入力してください。", wSDropImageByIdResponse.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG01() {
        DropImageInBean dropImageInBean = new DropImageInBean();
        dropImageInBean.setAccountid("Tt");
        dropImageInBean.setImageids(new String[] {"無効なイメージＩＤ配列"});
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        dropImageInBean.setExtInfo(extinfoMapList);
        WSDropImageByIdResponse wSDropImageByIdResponse = iwfImageClient.execDropImage(dropImageInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSDropImageByIdResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3073", wSDropImageByIdResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "指定されたイメージIDに該当するイメージは存在しません。", wSDropImageByIdResponse.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG02() {
        DropImageInBean dropImageInBean = new DropImageInBean();
        dropImageInBean.setAccountid("Tt");
        dropImageInBean.setImageids(new String[] {"イメージ_取込書類_NG"});
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        dropImageInBean.setExtInfo(extinfoMapList);
        WSDropImageByIdResponse wSDropImageByIdResponse = iwfImageClient.execDropImage(dropImageInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSDropImageByIdResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3072", wSDropImageByIdResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "取込書類マスタから、レコードが取得できませんでした。", wSDropImageByIdResponse.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG03() {
        DropImageInBean dropImageInBean = new DropImageInBean();
        dropImageInBean.setAccountid("Tt");
        dropImageInBean.setImageids(new String[] {"イメージＩＤ配列2_3"});
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        dropImageInBean.setExtInfo(extinfoMapList);
        WSDropImageByIdResponse wSDropImageByIdResponse = iwfImageClient.execDropImage(dropImageInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), wSDropImageByIdResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3071", wSDropImageByIdResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "トークンIDが取得できませんでした。", wSDropImageByIdResponse.getSyousaimsg());

    }

    @Test
    public void testSyoriLogicOK01() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String lockKey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid("09");
        befProcessCreateInBean.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid("Tt");
        inBean.setSyoruicd("200");
        inBean.setFlowid("09");
        inBean.setImagedata(readTestFile("Test.pdf"));
        inBean.setGyoumukey(gyoumukey);
        String imgId = iwfImageClient.execPutImage(inBean).getImgid();

        DropImageInBean dropImageInBean = new DropImageInBean();
        dropImageInBean.setAccountid("Tt");
        dropImageInBean.setImageids(new String[] {imgId});
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        dropImageInBean.setExtInfo(extinfoMapList);
        WSDropImageByIdResponse wSDropImageByIdResponse = iwfImageClient.execDropImage(dropImageInBean);

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid("09");
        aftProcessCancelInBean.setAccountid("Tt");
        aftProcessCancelInBean.setLockkey(lockKey);
        IwfCoreConfig.getInstance().setLockYouhi(false);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSDropImageByIdResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSDropImageByIdResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ID指定イメージ削除正常終了しました。", wSDropImageByIdResponse.getSyousaimsg());

    }

    @Test
    public void testSyoriLogicOK02() throws Exception {

        String gyoumukey1 = BizDate.getSysDateTimeMilli();
        String lockKey1 = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean1 = new ProcessCreateInBean();
        befProcessCreateInBean1.setGyoumukey(gyoumukey1);
        befProcessCreateInBean1.setFlowid("09");
        befProcessCreateInBean1.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean1 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean1.getKekkastatus())) {
            throw new Exception("前処理：工程作成１実行失敗！");
        }

        String gyoumukey2 = BizDate.getSysDateTimeMilli();
        String lockKey2 = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean2 = new ProcessCreateInBean();
        befProcessCreateInBean2.setGyoumukey(gyoumukey2);
        befProcessCreateInBean2.setFlowid("09");
        befProcessCreateInBean2.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean2 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean2.getKekkastatus())) {
            throw new Exception("前処理：工程作成２実行失敗！");
        }

        String gyoumukey3 = BizDate.getSysDateTimeMilli();
        String lockKey3 = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean3 = new ProcessCreateInBean();
        befProcessCreateInBean3.setGyoumukey(gyoumukey3);
        befProcessCreateInBean3.setFlowid("09");
        befProcessCreateInBean3.setAccountid("Tt");
        ProcessCreateOutBean befProcessCreateOutBean3 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean3.getKekkastatus())) {
            throw new Exception("前処理：工程作成３実行失敗！");
        }

        String psAccountid = "Tt";
        String sSyoruicd = "200";
        String psFlowid = "09";
        byte[] pbImagedata = readTestFile("Test.pdf");

        PutImageInBean inBean = new PutImageInBean();
        inBean.setAccountid(psAccountid);
        inBean.setSyoruicd(sSyoruicd);
        inBean.setFlowid(psFlowid);
        inBean.setImagedata(pbImagedata);
        inBean.setGyoumukey(gyoumukey1);
        WSPutImageResponse response1 = iwfImageClient.execPutImage(inBean);
        inBean.setGyoumukey(gyoumukey2);
        WSPutImageResponse response2 = iwfImageClient.execPutImage(inBean);
        inBean.setGyoumukey(gyoumukey3);
        WSPutImageResponse response3 = iwfImageClient.execPutImage(inBean);

        DropImageInBean dropImageInBean = new DropImageInBean();
        dropImageInBean.setAccountid("Tt");
        dropImageInBean.setImageids(new String[] {response1.getImgid(), response2.getImgid(), response3.getImgid()});
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", "付加情報");
        extinfoMapList.add(extinfoMap);
        dropImageInBean.setExtInfo(extinfoMapList);
        WSDropImageByIdResponse wSDropImageByIdResponse = iwfImageClient.execDropImage(dropImageInBean);

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey(gyoumukey1);
        aftProcessCancelInBean1.setFlowid("09");
        aftProcessCancelInBean1.setAccountid("Tt");
        aftProcessCancelInBean1.setLockkey(lockKey1);
        IwfCoreConfig.getInstance().setLockYouhi(false);
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey(gyoumukey2);
        aftProcessCancelInBean2.setFlowid("09");
        aftProcessCancelInBean2.setAccountid("Tt");
        aftProcessCancelInBean2.setLockkey(lockKey2);
        IwfCoreConfig.getInstance().setLockYouhi(false);
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey(gyoumukey3);
        aftProcessCancelInBean3.setFlowid("09");
        aftProcessCancelInBean3.setAccountid("Tt");
        aftProcessCancelInBean3.setLockkey(lockKey3);
        IwfCoreConfig.getInstance().setLockYouhi(false);
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSDropImageByIdResponse.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSDropImageByIdResponse.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ID指定イメージ削除正常終了しました。", wSDropImageByIdResponse.getSyousaimsg());

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
