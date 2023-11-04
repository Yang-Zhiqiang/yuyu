package yuyu.def.db.entity;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchKidouKbn;
import yuyu.def.classification.C_BatchModeKbn;
import yuyu.def.classification.C_KahiKbn;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * バッチログファイル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_BatchLogFileEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId = "KI00000001";

        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);
        if ( null == aS_Kinou ){

            aS_Kinou = new AS_Kinou();
            aS_Kinou.setKinouId(pKinouId);

            baseDomManager.insert(aS_Kinou);
        }

        String pBatchClass = "BC00000001";
        C_KahiKbn pTajuukidouKahiKbn = C_KahiKbn.KA;
        C_BatchModeKbn pBatchMode = C_BatchModeKbn .HIDOUKI;
        C_KahiKbn pTyuudanKahi = C_KahiKbn.HUKA;

        AM_Batch aM_Batch = baseDomManager.getBatch(pKinouId);
        if ( null == aM_Batch ) {

            aM_Batch = new AM_Batch();
            aM_Batch.setKinouId(pKinouId);
            aM_Batch.setBatchClass(pBatchClass);
            aM_Batch.setTajuukidouKahiKbn(pTajuukidouKahiKbn);
            aM_Batch.setBatchMode(pBatchMode);
            aM_Batch.setTyuudanKahi(pTyuudanKahi);

            baseDomManager.insert(aM_Batch);
        }

        String pBatchJobId = "BJI0000001";
        C_BatchKidouKbn pBatchKidouKbn = C_BatchKidouKbn.BATCH;
        C_BatchJyoutaiKbn pBatchJyoutaiKbn =  C_BatchJyoutaiKbn.SYUURYOU;

        AT_BatchJob aT_BatchJob = baseDomManager.getBatchJob(pBatchJobId);
        if ( null == aT_BatchJob ) {

            aT_BatchJob = new AT_BatchJob();
            aT_BatchJob.setBatchJobId(pBatchJobId);
            aT_BatchJob.setBatchId(pKinouId);
            aT_BatchJob.setBatchKidouKbn(pBatchKidouKbn);
            aT_BatchJob.setBatchJyoutaiKbn(pBatchJyoutaiKbn);

            baseDomManager.insert(aT_BatchJob);

        }

        String pUniqueId1 = "UNI0000001";
        String pUniqueId2 = "UNI0000002";
        String pUniqueId3 = "UNI0000003";
        String pUniqueId4 = "UNI0000004";
        String pUniqueId5 = "UNI0000005";

        AT_BatchLogFile aT_BatchLogFile1 = baseDomManager.getBatchJob(pBatchJobId).getBatchLogFile(pUniqueId1);
        if ( null == aT_BatchLogFile1 ){

            aT_BatchLogFile1 = aT_BatchJob.createBatchLogFile();
            aT_BatchLogFile1.setUniqueId(pUniqueId1);
        }

        AT_BatchLogFile aT_BatchLogFile2 = baseDomManager.getBatchJob(pBatchJobId).getBatchLogFile(pUniqueId2);
        if ( null == aT_BatchLogFile2 ){

            aT_BatchLogFile2 = aT_BatchJob.createBatchLogFile();
            aT_BatchLogFile2.setUniqueId(pUniqueId2);
        }

        AT_BatchLogFile aT_BatchLogFile3 = baseDomManager.getBatchJob(pBatchJobId).getBatchLogFile(pUniqueId3);
        if ( null == aT_BatchLogFile3 ){

            aT_BatchLogFile3 = aT_BatchJob.createBatchLogFile();
            aT_BatchLogFile3.setUniqueId(pUniqueId3);
        }

        AT_BatchLogFile aT_BatchLogFile4 = baseDomManager.getBatchJob(pBatchJobId).getBatchLogFile(pUniqueId4);
        if ( null == aT_BatchLogFile4 ){

            aT_BatchLogFile4 = aT_BatchJob.createBatchLogFile();
            aT_BatchLogFile4.setUniqueId(pUniqueId4);
        }

        AT_BatchLogFile aT_BatchLogFile5 = baseDomManager.getBatchJob(pBatchJobId).getBatchLogFile(pUniqueId5);
        if ( null == aT_BatchLogFile5 ){

            aT_BatchLogFile5 = aT_BatchJob.createBatchLogFile();
            aT_BatchLogFile5.setUniqueId(pUniqueId5);
        }

        baseDomManager.update(aT_BatchJob);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pBatchJobId = "BJI0000001";

        AT_BatchJob aT_BatchJob = baseDomManager.getBatchJob(pBatchJobId);
        if ( null != aT_BatchJob ){

            aT_BatchJob.getBatchLogFiles().removeAll(aT_BatchJob.getBatchLogFiles());

            baseDomManager.update(aT_BatchJob);
            baseDomManager.delete(aT_BatchJob);
        }

        String pKinouId = "KI00000001";

        AM_Batch aM_Batch = baseDomManager.getBatch(pKinouId);
        if ( null != aM_Batch ) {

            baseDomManager.delete(aM_Batch);
        }

        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);
        if ( null != aS_Kinou ) {

            baseDomManager.delete(aS_Kinou);
        }
    }

    @Override
    @Test
    @Transactional
    public void getAll() {

        String pBatchJobId = "BJI0000001";
        List<AT_BatchLogFile> batchLogFileList = baseDomManager.getBatchJob(pBatchJobId).getBatchLogFiles();

        List<AT_BatchLogFile> resultBatchLogFileList = ImmutableList.copyOf(Iterables.filter(batchLogFileList, new Predicate<AT_BatchLogFile>() {

            @Override
            public boolean apply(AT_BatchLogFile pBatchLogFileEntity) {

                List<String> pUniqueIdList = new ArrayList<String>();
                pUniqueIdList.add("UNI0000001");
                pUniqueIdList.add("UNI0000002");
                pUniqueIdList.add("UNI0000003");
                pUniqueIdList.add("UNI0000004");
                pUniqueIdList.add("UNI0000005");

                for (String uniqueId : pUniqueIdList) {
                    if (uniqueId.equals(pBatchLogFileEntity.getUniqueId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultBatchLogFileList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pBatchJobId = "BJI0000001";
        String pUniqueId = "UNI0000001";
        AT_BatchLogFile aT_BatchLogFile = baseDomManager.getBatchJob(pBatchJobId).getBatchLogFile(pUniqueId);

        assertEquals(pBatchJobId, aT_BatchLogFile.getBatchJobId());
        assertEquals(pUniqueId, aT_BatchLogFile.getUniqueId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pBatchJobId = "BJI0000001";
        String pUniqueId = "UNI0000099";
        AT_BatchLogFile aT_BatchLogFile = baseDomManager.getBatchJob(pBatchJobId).getBatchLogFile(pUniqueId);

        assertNull(aT_BatchLogFile);
    }

    @Override
    @Test
    public void blankCondition() {
        String pBatchJobId = "BJI0000001";
        String pUniqueId = "";
        AT_BatchLogFile aT_BatchLogFile = baseDomManager.getBatchJob(pBatchJobId).getBatchLogFile(pUniqueId);

        assertNull(aT_BatchLogFile);
    }

    @Override
    @Test
    public void nullCondition() {
        String pBatchJobId = "BJI0000001";
        String pUniqueId = null;
        try {
            baseDomManager.getBatchJob(pBatchJobId).getBatchLogFile(pUniqueId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
