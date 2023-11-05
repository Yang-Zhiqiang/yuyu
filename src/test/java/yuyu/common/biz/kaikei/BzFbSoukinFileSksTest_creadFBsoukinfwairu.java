package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.file.fixedlength.BzFbsoukinFixedlengthRecordLayoutFile;
import yuyu.def.classification.C_FbSoukinBatchKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＦＢ送金ファイル作成のＦＢ送金ファイル作成 {@link BzFbSoukinFileSks#creadFBsoukinfwairu(C_ShrhousiteiKbn,BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFbSoukinFileSksTest_creadFBsoukinfwairu {

    @Inject
    BzFbSoukinFileSks bzFbSoukinFileSks;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＦＢ送金ファイル作成";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzFbSoukinFileSksTest_creadFBsoukinfwairu.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        ExDBEntityManager em = SWAKInjector
            .getInstance(ExDBEntityManager.class);

        String jpql = "delete from " + "BT_FBSoukinData";
        em.createJPQL(jpql).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void testcreadFBsoukinfwairu_A1() {

        C_ShrhousiteiKbn[] shrhousiteiKbns = {C_ShrhousiteiKbn.FB_YOKUJITU};
        List<BzFbsoukinFixedlengthRecordLayoutFile> bzFbsoukinFixedlengthRecordLayoutFileLst =
            bzFbSoukinFileSks.creadFBsoukinfwairu(BizDate.valueOf(20160101), "RGDFD000",C_FbSoukinBatchKbn.NONE,
                shrhousiteiKbns);

        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(0).getIffFbfixedlengthdata(), "12110818192400ｽﾐﾄﾓｾｲﾒｲﾎｹﾝ                             01040009ﾐﾂｲｽﾐﾄﾓ        101ｵｵｻｶﾎﾝﾃﾝ       20234007             5650", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(1).getIffFbfixedlengthdata(), "8000000000000000000                                                                                                     ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(2).getIffFbfixedlengthdata(), "9                                                                                                                       ", "データレコード（固定長）");
        exNumericEquals(bzFbSoukinFileSks.getDateCount(), 0, "枝番号");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testcreadFBsoukinfwairu_A2() {

        C_ShrhousiteiKbn[] shrhousiteiKbns = {C_ShrhousiteiKbn.FB_2EIGYOUBI};
        List<BzFbsoukinFixedlengthRecordLayoutFile> bzFbsoukinFixedlengthRecordLayoutFileLst =
            bzFbSoukinFileSks.creadFBsoukinfwairu(BizDate.valueOf(20160202), "RGDFD000",C_FbSoukinBatchKbn.NONE,
                shrhousiteiKbns);

        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(0).getIffFbfixedlengthdata(), "12110818192400ｽﾐﾄﾓｾｲﾒｲﾎｹﾝ                             02020009ﾐﾂｲｽﾐﾄﾓ        101ｵｵｻｶﾎﾝﾃﾝ       20234007             9944", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(1).getIffFbfixedlengthdata(), "21002ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1102ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000021000002ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ1 10000000020102       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(2).getIffFbfixedlengthdata(), "8000001001000000002                                                                                                     ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(3).getIffFbfixedlengthdata(), "9                                                                                                                       ", "データレコード（固定長）");
        exNumericEquals(bzFbSoukinFileSks.getDateCount(), 1, "枝番号");

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testcreadFBsoukinfwairu_A3() {

        C_ShrhousiteiKbn[] shrhousiteiKbns = {C_ShrhousiteiKbn.FB_3EIGYOUBI};
        List<BzFbsoukinFixedlengthRecordLayoutFile> bzFbsoukinFixedlengthRecordLayoutFileLst =
            bzFbSoukinFileSks.creadFBsoukinfwairu(BizDate.valueOf(20160303), "RGDFD000", C_FbSoukinBatchKbn.BATCH,
                shrhousiteiKbns);

        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(0).getIffFbfixedlengthdata(), "12110818192400ｽﾐﾄﾓｾｲﾒｲﾎｹﾝ                             03030009ﾐﾂｲｽﾐﾄﾓ        101ｵｵｻｶﾎﾝﾃﾝ       20234007             9943", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(1).getIffFbfixedlengthdata(), "21005ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ4105ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ4000051000005ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ4 10000000050105       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(2).getIffFbfixedlengthdata(), "8000001001000000005                                                                                                     ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(3).getIffFbfixedlengthdata(), "12110818192400ｽﾐﾄﾓｾｲﾒｲﾎｹﾝ                             03030009ﾐﾂｲｽﾐﾄﾓ        101ｵｵｻｶﾎﾝﾃﾝ       20234007             9944", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(4).getIffFbfixedlengthdata(), "21004ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ3104ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ3000041000004ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ3 10000000040104       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(5).getIffFbfixedlengthdata(), "8000001001000000004                                                                                                     ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(6).getIffFbfixedlengthdata(), "9                                                                                                                       ", "データレコード（固定長）");
        exNumericEquals(bzFbSoukinFileSks.getDateCount(), 2, "枝番号");

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testcreadFBsoukinfwairu_A4() {

        C_ShrhousiteiKbn[] shrhousiteiKbns = {C_ShrhousiteiKbn.FB_YOKUJITU, C_ShrhousiteiKbn.FB_3EIGYOUBI};
        List<BzFbsoukinFixedlengthRecordLayoutFile> bzFbsoukinFixedlengthRecordLayoutFileLst =
            bzFbSoukinFileSks.creadFBsoukinfwairu(BizDate.valueOf(20180301), "RGDFD000", C_FbSoukinBatchKbn.NONE,
                shrhousiteiKbns);

        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(0).getIffFbfixedlengthdata(), "12110818192400ｽﾐﾄﾓｾｲﾒｲﾎｹﾝ                             02010009ﾐﾂｲｽﾐﾄﾓ        101ｵｵｻｶﾎﾝﾃﾝ       20234007             9901", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(1).getIffFbfixedlengthdata(), "22003ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1203ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000041000003ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ3 10000000150315       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(2).getIffFbfixedlengthdata(), "8000001001000000015                                                                                                     ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(3).getIffFbfixedlengthdata(), "12110818192400ｽﾐﾄﾓｾｲﾒｲﾎｹﾝ                             02020009ﾐﾂｲｽﾐﾄﾓ        101ｵｵｻｶﾎﾝﾃﾝ       20234007             9902", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(4).getIffFbfixedlengthdata(), "22003ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1203ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000041000003ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ3 10000000140314       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(5).getIffFbfixedlengthdata(), "8000001001000000014                                                                                                     ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(6).getIffFbfixedlengthdata(), "12110818192400ｽﾐﾄﾓｾｲﾒｲﾎｹﾝ                             02030009ﾐﾂｲｽﾐﾄﾓ        101ｵｵｻｶﾎﾝﾃﾝ       20234007             9903", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(7).getIffFbfixedlengthdata(), "22001ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1203ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000041000003ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ3 10000000130313       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(8).getIffFbfixedlengthdata(), "22002ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1203ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000041000003ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ3 10000000120312       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(9).getIffFbfixedlengthdata(), "22003ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1201ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000041000003ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ3 10000000110311       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(10).getIffFbfixedlengthdata(), "22003ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1202ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000041000003ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ3 10000000100310       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(11).getIffFbfixedlengthdata(), "22003ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1203ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000021000003ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ3 10000000090309       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(12).getIffFbfixedlengthdata(), "22003ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1203ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000031000003ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ3 10000000080308       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(13).getIffFbfixedlengthdata(), "22003ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1203ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000041000001ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ3 10000000070307       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(14).getIffFbfixedlengthdata(), "22003ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1203ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000041000002ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ3 10000000060306       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(15).getIffFbfixedlengthdata(), "22003ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1203ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000041000003ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ1 10000000050305       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(16).getIffFbfixedlengthdata(), "22003ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1203ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000041000003ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ2 10000000040304       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(17).getIffFbfixedlengthdata(), "22003ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1203ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000041000003ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ3 10000000030303       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(18).getIffFbfixedlengthdata(), "22003ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1203ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000041000003ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ3 10000000020302       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(19).getIffFbfixedlengthdata(), "22003ｷﾞﾝｺｳﾒｲｷﾞﾝｺｳﾒｲ1203ｼﾃﾝﾒｲｼﾃﾝﾒｲｼﾃﾝﾒ1000041000003ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲｺｳ3 10000000010301       00000000007        ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(20).getIffFbfixedlengthdata(), "8000013013000000091                                                                                                     ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(21).getIffFbfixedlengthdata(), "9                                                                                                                       ", "データレコード（固定長）");
        exNumericEquals(bzFbSoukinFileSks.getDateCount(), 15, "枝番号");

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testcreadFBsoukinfwairu_A5() {

        C_ShrhousiteiKbn[] shrhousiteiKbns = {C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI, C_ShrhousiteiKbn.FB_YOKUJITU};
        List<BzFbsoukinFixedlengthRecordLayoutFile> bzFbsoukinFixedlengthRecordLayoutFileLst =
            bzFbSoukinFileSks.creadFBsoukinfwairu(BizDate.valueOf(20160101), "RGDFD000",C_FbSoukinBatchKbn.NONE,
                shrhousiteiKbns);

        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(0).getIffFbfixedlengthdata(), "12110818192400ｽﾐﾄﾓｾｲﾒｲﾎｹﾝ                             01060009ﾐﾂｲｽﾐﾄﾓ        101ｵｵｻｶﾎﾝﾃﾝ       20234007             5650", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(1).getIffFbfixedlengthdata(), "8000000000000000000                                                                                                     ", "データレコード（固定長）");
        exStringEquals(bzFbsoukinFixedlengthRecordLayoutFileLst.get(2).getIffFbfixedlengthdata(), "9                                                                                                                       ", "データレコード（固定長）");
        exNumericEquals(bzFbSoukinFileSks.getDateCount(), 0, "枝番号");
    }
}
