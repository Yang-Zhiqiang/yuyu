package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import yuyu.def.classification.C_FileStatusKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、
 * getFileHozonInfoByAllConditionメソッドのテストクラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getFileHozonInfoByAllCondition extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        C_FileSyuruiCdKbn pFileSyuruiCd1 = C_FileSyuruiCdKbn.BLNK;
        C_FileSyuruiCdKbn pFileSyuruiCd2 = C_FileSyuruiCdKbn.BLNK;

        AS_FileSyurui aS_FileSyurui1 = baseDomManager.getFileSyurui(pFileSyuruiCd1);
        if ( null == aS_FileSyurui1 ) {

            aS_FileSyurui1 = new AS_FileSyurui();
            aS_FileSyurui1.setFileSyuruiCd(pFileSyuruiCd1);

            baseDomManager.insert(aS_FileSyurui1);
        }

        AS_FileSyurui aS_FileSyurui2 = baseDomManager.getFileSyurui(pFileSyuruiCd2);
        if ( null == aS_FileSyurui2 ) {

            aS_FileSyurui2 = new AS_FileSyurui();
            aS_FileSyurui2.setFileSyuruiCd(pFileSyuruiCd2);

            baseDomManager.insert(aS_FileSyurui2);
        }

        String pUniqueId1 = "UNI0000001";
        String pUniqueId2 = "UNI0000002";
        String pUniqueId3 = "UNI0000003";
        String pUniqueId4 = "UNI0000004";
        String pUniqueId5 = "UNI0000005";
        String pUniqueId6 = "UNI0000006";
        String pUniqueId7 = "UNI0000007";
        String pUniqueId8 = "UNI0000008";
        String pUniqueId9 = "UNI0000009";
        String pUniqueId10 = "UNI0000010";
        String pUniqueId11 = "UNI0000011";
        String pFileNm = "FN00000001";
        C_FileStatusKbn pFileStatusKbn = C_FileStatusKbn.NONE;
        String pHaitaKey = "HK00000001";
        String pTourokuTime1 = "20150602000000002";
        String pTourokuTime2 = "20150605000000007";
        String pTourokuTime3 = "20150602000000000";
        String pTourokuTime4 = "20150605000000000";
        String pTourokuTime5 = "20150610000000000";
        String pTourokuTime6 = "20150606000000000";
        String pTourokuTime7 = "20150608000000000";
        String pTourokuTime8 = "20150609000000000";
        String pTourokuTime9 = "20150605000000000";
        String pTourokuTime10 = "20150611000000000";
        String pTourokuTime11 = "20150607000000000";
        String pSakuseiKinouId = "SKI0000001";
        String pKousinsyaId = "KSI0000001";

        AT_FileHozonInfo aT_FileHozonInfo1 = baseDomManager.getFileHozonInfo(pUniqueId1);
        if ( null == aT_FileHozonInfo1 ) {

            aT_FileHozonInfo1 = new AT_FileHozonInfo();
            aT_FileHozonInfo1.setUniqueId(pUniqueId1);
            aT_FileHozonInfo1.setFileNm(pFileNm);
            aT_FileHozonInfo1.setFileSyuruiCd(pFileSyuruiCd1);
            aT_FileHozonInfo1.setFileStatusKbn(pFileStatusKbn);
            aT_FileHozonInfo1.setHaitaKey(pHaitaKey);
            aT_FileHozonInfo1.setTourokuTime(pTourokuTime1);
            aT_FileHozonInfo1.setSakuseiKinouId(pSakuseiKinouId);
            aT_FileHozonInfo1.setKousinsyaId(pKousinsyaId);

            baseDomManager.insert(aT_FileHozonInfo1);
        }


        AT_FileHozonInfo aT_FileHozonInfo2 = baseDomManager.getFileHozonInfo(pUniqueId2);
        if ( null == aT_FileHozonInfo2 ) {

            aT_FileHozonInfo2 = new AT_FileHozonInfo();
            aT_FileHozonInfo2.setUniqueId(pUniqueId2);
            aT_FileHozonInfo2.setFileNm(pFileNm);
            aT_FileHozonInfo2.setFileSyuruiCd(pFileSyuruiCd1);
            aT_FileHozonInfo2.setFileStatusKbn(pFileStatusKbn);
            aT_FileHozonInfo2.setHaitaKey(pHaitaKey);
            aT_FileHozonInfo2.setTourokuTime(pTourokuTime2);
            aT_FileHozonInfo2.setSakuseiKinouId(pSakuseiKinouId);
            aT_FileHozonInfo2.setKousinsyaId(pKousinsyaId);

            baseDomManager.insert(aT_FileHozonInfo2);
        }

        AT_FileHozonInfo aT_FileHozonInfo3 = baseDomManager.getFileHozonInfo(pUniqueId3);
        if ( null == aT_FileHozonInfo3 ) {

            aT_FileHozonInfo3 = new AT_FileHozonInfo();
            aT_FileHozonInfo3.setUniqueId(pUniqueId3);
            aT_FileHozonInfo3.setFileNm(pFileNm);
            aT_FileHozonInfo3.setFileSyuruiCd(pFileSyuruiCd1);
            aT_FileHozonInfo3.setFileStatusKbn(pFileStatusKbn);
            aT_FileHozonInfo3.setHaitaKey(pHaitaKey);
            aT_FileHozonInfo3.setTourokuTime(pTourokuTime3);
            aT_FileHozonInfo3.setSakuseiKinouId(pSakuseiKinouId);
            aT_FileHozonInfo3.setKousinsyaId(pKousinsyaId);

            baseDomManager.insert(aT_FileHozonInfo3);
        }

        AT_FileHozonInfo aT_FileHozonInfo4 = baseDomManager.getFileHozonInfo(pUniqueId4);
        if ( null == aT_FileHozonInfo4 ) {

            aT_FileHozonInfo4 = new AT_FileHozonInfo();
            aT_FileHozonInfo4.setUniqueId(pUniqueId4);
            aT_FileHozonInfo4.setFileNm(pFileNm);
            aT_FileHozonInfo4.setFileSyuruiCd(pFileSyuruiCd1);
            aT_FileHozonInfo4.setFileStatusKbn(pFileStatusKbn);
            aT_FileHozonInfo4.setHaitaKey(pHaitaKey);
            aT_FileHozonInfo4.setTourokuTime(pTourokuTime4);
            aT_FileHozonInfo4.setSakuseiKinouId(pSakuseiKinouId);
            aT_FileHozonInfo4.setKousinsyaId(pKousinsyaId);

            baseDomManager.insert(aT_FileHozonInfo4);
        }

        AT_FileHozonInfo aT_FileHozonInfo5 = baseDomManager.getFileHozonInfo(pUniqueId5);
        if ( null == aT_FileHozonInfo5 ) {

            aT_FileHozonInfo5 = new AT_FileHozonInfo();
            aT_FileHozonInfo5.setUniqueId(pUniqueId5);
            aT_FileHozonInfo5.setFileNm(pFileNm);
            aT_FileHozonInfo5.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo5.setFileStatusKbn(pFileStatusKbn);
            aT_FileHozonInfo5.setHaitaKey(pHaitaKey);
            aT_FileHozonInfo5.setTourokuTime(pTourokuTime5);
            aT_FileHozonInfo5.setSakuseiKinouId(pSakuseiKinouId);
            aT_FileHozonInfo5.setKousinsyaId(pKousinsyaId);

            baseDomManager.insert(aT_FileHozonInfo5);
        }

        AT_FileHozonInfo aT_FileHozonInfo6 = baseDomManager.getFileHozonInfo(pUniqueId6);
        if ( null == aT_FileHozonInfo6 ) {

            aT_FileHozonInfo6 = new AT_FileHozonInfo();
            aT_FileHozonInfo6.setUniqueId(pUniqueId6);
            aT_FileHozonInfo6.setFileNm(pFileNm);
            aT_FileHozonInfo6.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo6.setFileStatusKbn(pFileStatusKbn);
            aT_FileHozonInfo6.setHaitaKey(pHaitaKey);
            aT_FileHozonInfo6.setTourokuTime(pTourokuTime6);
            aT_FileHozonInfo6.setSakuseiKinouId(pSakuseiKinouId);
            aT_FileHozonInfo6.setKousinsyaId(pKousinsyaId);

            baseDomManager.insert(aT_FileHozonInfo6);
        }

        AT_FileHozonInfo aT_FileHozonInfo7 = baseDomManager.getFileHozonInfo(pUniqueId7);
        if ( null == aT_FileHozonInfo7 ) {

            aT_FileHozonInfo7 = new AT_FileHozonInfo();
            aT_FileHozonInfo7.setUniqueId(pUniqueId7);
            aT_FileHozonInfo7.setFileNm(pFileNm);
            aT_FileHozonInfo7.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo7.setFileStatusKbn(pFileStatusKbn);
            aT_FileHozonInfo7.setHaitaKey(pHaitaKey);
            aT_FileHozonInfo7.setTourokuTime(pTourokuTime7);
            aT_FileHozonInfo7.setSakuseiKinouId(pSakuseiKinouId);
            aT_FileHozonInfo7.setKousinsyaId(pKousinsyaId);

            baseDomManager.insert(aT_FileHozonInfo7);
        }

        AT_FileHozonInfo aT_FileHozonInfo8 = baseDomManager.getFileHozonInfo(pUniqueId8);
        if ( null == aT_FileHozonInfo8 ) {

            aT_FileHozonInfo8 = new AT_FileHozonInfo();
            aT_FileHozonInfo8.setUniqueId(pUniqueId8);
            aT_FileHozonInfo8.setFileNm(pFileNm);
            aT_FileHozonInfo8.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo8.setFileStatusKbn(pFileStatusKbn);
            aT_FileHozonInfo8.setHaitaKey(pHaitaKey);
            aT_FileHozonInfo8.setTourokuTime(pTourokuTime8);
            aT_FileHozonInfo8.setSakuseiKinouId(pSakuseiKinouId);
            aT_FileHozonInfo8.setKousinsyaId(pKousinsyaId);

            baseDomManager.insert(aT_FileHozonInfo8);
        }

        AT_FileHozonInfo aT_FileHozonInfo9 = baseDomManager.getFileHozonInfo(pUniqueId9);
        if ( null == aT_FileHozonInfo9 ) {

            aT_FileHozonInfo9 = new AT_FileHozonInfo();
            aT_FileHozonInfo9.setUniqueId(pUniqueId9);
            aT_FileHozonInfo9.setFileNm(pFileNm);
            aT_FileHozonInfo9.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo9.setFileStatusKbn(pFileStatusKbn);
            aT_FileHozonInfo9.setHaitaKey(pHaitaKey);
            aT_FileHozonInfo9.setTourokuTime(pTourokuTime9);
            aT_FileHozonInfo9.setSakuseiKinouId(pSakuseiKinouId);
            aT_FileHozonInfo9.setKousinsyaId(pKousinsyaId);

            baseDomManager.insert(aT_FileHozonInfo9);
        }

        AT_FileHozonInfo aT_FileHozonInfo10 = baseDomManager.getFileHozonInfo(pUniqueId10);
        if ( null == aT_FileHozonInfo10 ) {

            aT_FileHozonInfo10 = new AT_FileHozonInfo();
            aT_FileHozonInfo10.setUniqueId(pUniqueId10);
            aT_FileHozonInfo10.setFileNm(pFileNm);
            aT_FileHozonInfo10.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo10.setFileStatusKbn(pFileStatusKbn);
            aT_FileHozonInfo10.setHaitaKey(pHaitaKey);
            aT_FileHozonInfo10.setTourokuTime(pTourokuTime10);
            aT_FileHozonInfo10.setSakuseiKinouId(pSakuseiKinouId);
            aT_FileHozonInfo10.setKousinsyaId(pKousinsyaId);

            baseDomManager.insert(aT_FileHozonInfo10);
        }

        AT_FileHozonInfo aT_FileHozonInfo11 = baseDomManager.getFileHozonInfo(pUniqueId11);
        if ( null == aT_FileHozonInfo11 ) {

            aT_FileHozonInfo11 = new AT_FileHozonInfo();
            aT_FileHozonInfo11.setUniqueId(pUniqueId11);
            aT_FileHozonInfo11.setFileNm(pFileNm);
            aT_FileHozonInfo11.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo11.setFileStatusKbn(pFileStatusKbn);
            aT_FileHozonInfo11.setHaitaKey(pHaitaKey);
            aT_FileHozonInfo11.setTourokuTime(pTourokuTime11);
            aT_FileHozonInfo11.setSakuseiKinouId(pSakuseiKinouId);
            aT_FileHozonInfo11.setKousinsyaId(pKousinsyaId);

            baseDomManager.insert(aT_FileHozonInfo11);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUniqueId1 = "UNI0000001";
        String pUniqueId2 = "UNI0000002";
        String pUniqueId3 = "UNI0000003";
        String pUniqueId4 = "UNI0000004";
        String pUniqueId5 = "UNI0000005";
        String pUniqueId6 = "UNI0000006";
        String pUniqueId7 = "UNI0000007";
        String pUniqueId8 = "UNI0000008";
        String pUniqueId9 = "UNI0000009";
        String pUniqueId10 = "UNI0000010";
        String pUniqueId11 = "UNI0000011";

        AT_FileHozonInfo aT_FileHozonInfo1 = baseDomManager.getFileHozonInfo(pUniqueId1);
        if ( null != aT_FileHozonInfo1 ) {

            baseDomManager.delete(aT_FileHozonInfo1);
        }

        AT_FileHozonInfo aT_FileHozonInfo2 = baseDomManager.getFileHozonInfo(pUniqueId2);
        if ( null != aT_FileHozonInfo2 ) {

            baseDomManager.delete(aT_FileHozonInfo2);
        }

        AT_FileHozonInfo aT_FileHozonInfo3 = baseDomManager.getFileHozonInfo(pUniqueId3);
        if ( null != aT_FileHozonInfo3 ) {

            baseDomManager.delete(aT_FileHozonInfo3);
        }

        AT_FileHozonInfo aT_FileHozonInfo4 = baseDomManager.getFileHozonInfo(pUniqueId4);
        if ( null != aT_FileHozonInfo4 ) {

            baseDomManager.delete(aT_FileHozonInfo4);
        }

        AT_FileHozonInfo aT_FileHozonInfo5 = baseDomManager.getFileHozonInfo(pUniqueId5);
        if ( null != aT_FileHozonInfo5 ) {

            baseDomManager.delete(aT_FileHozonInfo5);
        }

        AT_FileHozonInfo aT_FileHozonInfo6 = baseDomManager.getFileHozonInfo(pUniqueId6);
        if ( null != aT_FileHozonInfo6 ) {

            baseDomManager.delete(aT_FileHozonInfo6);
        }

        AT_FileHozonInfo aT_FileHozonInfo7 = baseDomManager.getFileHozonInfo(pUniqueId7);
        if ( null != aT_FileHozonInfo7 ) {

            baseDomManager.delete(aT_FileHozonInfo7);
        }

        AT_FileHozonInfo aT_FileHozonInfo8 = baseDomManager.getFileHozonInfo(pUniqueId8);
        if ( null != aT_FileHozonInfo8 ) {

            baseDomManager.delete(aT_FileHozonInfo8);
        }

        AT_FileHozonInfo aT_FileHozonInfo9 = baseDomManager.getFileHozonInfo(pUniqueId9);
        if ( null != aT_FileHozonInfo9 ) {

            baseDomManager.delete(aT_FileHozonInfo9);
        }

        AT_FileHozonInfo aT_FileHozonInfo10 = baseDomManager.getFileHozonInfo(pUniqueId10);
        if ( null != aT_FileHozonInfo10 ) {

            baseDomManager.delete(aT_FileHozonInfo10);
        }

        AT_FileHozonInfo aT_FileHozonInfo11 = baseDomManager.getFileHozonInfo(pUniqueId11);
        if ( null != aT_FileHozonInfo11 ) {

            baseDomManager.delete(aT_FileHozonInfo11);
        }

        C_FileSyuruiCdKbn pFileSyuruiCd1 = C_FileSyuruiCdKbn.BLNK;
        C_FileSyuruiCdKbn pFileSyuruiCd2 = C_FileSyuruiCdKbn.BLNK;

        AS_FileSyurui aS_FileSyurui1 = baseDomManager.getFileSyurui(pFileSyuruiCd1);
        if ( null != aS_FileSyurui1 ) {

            baseDomManager.delete(aS_FileSyurui1);
        }

        AS_FileSyurui aS_FileSyurui2 = baseDomManager.getFileSyurui(pFileSyuruiCd2);
        if ( null != aS_FileSyurui2 ) {

            baseDomManager.delete(aS_FileSyurui2);
        }
    }

    @Test
    public void test001(){
        String pUniqueId = "UNI0000001";
        String pFileName = "FN00000001";
        C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        String pHaitaKey = "HK00000001";
        String pTourokuTimeFrom = "20150610000000000";
        String pTourokuTimeTo = "20150611000000000";
        String pSakuseiKinouId = "SKI0000001";
        String pSakuseiUserId = "KSI0000001";
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByAllCondition(pUniqueId, pFileName, pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo, pSakuseiKinouId, pSakuseiUserId);

        assertEquals(0, aT_FileHozonInfoList.size());

    }

    @Test
    public void test002(){
        String pUniqueId = "UNI0000001";
        String pFileName = "FN00000001";
        C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        String pHaitaKey = "HK00000001";
        String pTourokuTimeFrom = "20150602000000000";
        String pTourokuTimeTo = "20150602000000005";
        String pSakuseiKinouId = "SKI0000001";
        String pSakuseiUserId = "KSI0000001";
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByAllCondition(pUniqueId, pFileName, pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo, pSakuseiKinouId, pSakuseiUserId);

        assertEquals(1, aT_FileHozonInfoList.size());
    }

    @Test
    public void test003(){
        String pUniqueId = null;
        String pFileName = "FN00000001";
        C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        String pHaitaKey = "HK00000001";
        String pTourokuTimeFrom = "20150602000000000";
        String pTourokuTimeTo = "20150605000000005";
        String pSakuseiKinouId = "SKI0000001";
        String pSakuseiUserId = "KSI0000001";
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByAllCondition(pUniqueId, pFileName, pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo, pSakuseiKinouId, pSakuseiUserId);

        assertEquals(4, aT_FileHozonInfoList.size());
    }

    @Test
    public void test004(){
        String pUniqueId = "";
        String pFileName = "";
        C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        String pHaitaKey = "";
        String pTourokuTimeFrom = "";
        String pTourokuTimeTo = "";
        String pSakuseiKinouId = "";
        String pSakuseiUserId = "";
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByAllCondition(pUniqueId, pFileName, pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo, pSakuseiKinouId, pSakuseiUserId);

        assertEquals(0, aT_FileHozonInfoList.size());
    }

    @Test
    public void test005(){
        String pUniqueId = null;
        String pFileName = null;
        C_FileSyuruiCdKbn pFileSyuruiCd = null;
        String pHaitaKey = null;
        String pTourokuTimeFrom =null;
        String pTourokuTimeTo = null;
        String pSakuseiKinouId = null;
        String pSakuseiUserId = null;
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByAllCondition(pUniqueId, pFileName, pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo, pSakuseiKinouId, pSakuseiUserId);

        assertEquals(11, aT_FileHozonInfoList.size());
    }

    @Test
    public void test006(){
        String pUniqueId = null;
        String pFileName = "FN00000001";
        C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        String pHaitaKey = "HK00000001";
        String pTourokuTimeFrom = "20150606000000000";
        String pTourokuTimeTo = "20150610000000000";
        String pSakuseiKinouId = "SKI0000001";
        String pSakuseiUserId = "KSI0000001";
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByAllCondition(pUniqueId, pFileName, pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo, pSakuseiKinouId, pSakuseiUserId);

        assertEquals(5, aT_FileHozonInfoList.size());
    }

    @Test
    public void test007(){
        String pUniqueId = null;
        String pFileName = "FN00000001";
        C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        String pHaitaKey = "HK00000001";
        String pTourokuTimeFrom = "20150605000000000";
        String pTourokuTimeTo = "20150611000000000";
        String pSakuseiKinouId = "SKI0000001";
        String pSakuseiUserId = "KSI0000001";
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByAllCondition(pUniqueId, pFileName, pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo, pSakuseiKinouId, pSakuseiUserId);

        String pTourokuTime1 = "20150605000000000";
        String pTourokuTime2 = "20150605000000000";
        String pTourokuTime3 = "20150605000000007";
        String pTourokuTime4 = "20150606000000000";
        String pTourokuTime5 = "20150607000000000";
        String pTourokuTime6 = "20150608000000000";
        String pTourokuTime7 = "20150609000000000";
        String pTourokuTime8 = "20150610000000000";
        String pTourokuTime9 = "20150611000000000";

        assertEquals(pTourokuTime1, aT_FileHozonInfoList.get(0).getTourokuTime());
        assertEquals(pTourokuTime2, aT_FileHozonInfoList.get(1).getTourokuTime());
        assertEquals(pTourokuTime3, aT_FileHozonInfoList.get(2).getTourokuTime());
        assertEquals(pTourokuTime4, aT_FileHozonInfoList.get(3).getTourokuTime());
        assertEquals(pTourokuTime5, aT_FileHozonInfoList.get(4).getTourokuTime());
        assertEquals(pTourokuTime6, aT_FileHozonInfoList.get(5).getTourokuTime());
        assertEquals(pTourokuTime7, aT_FileHozonInfoList.get(6).getTourokuTime());
        assertEquals(pTourokuTime8, aT_FileHozonInfoList.get(7).getTourokuTime());
        assertEquals(pTourokuTime9, aT_FileHozonInfoList.get(8).getTourokuTime());
    }
}
