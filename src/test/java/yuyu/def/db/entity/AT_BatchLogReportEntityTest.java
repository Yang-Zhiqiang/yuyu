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
 * バッチログレポート エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_BatchLogReportEntityTest implements EntityTestInterface {

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

        String pReportKey1 = "CK00000001";
        String pReportKey2 = "CK00000002";
        String pReportKey3 = "CK00000003";
        String pReportKey4 = "CK00000004";
        String pReportKey5 = "CK00000005";

        AT_BatchLogReport aT_BatchLogReport1 = baseDomManager.getBatchJob(pBatchJobId).getBatchLogReport(pReportKey1);
        if ( null == aT_BatchLogReport1 ){

            aT_BatchLogReport1 = aT_BatchJob.createBatchLogReport();
            aT_BatchLogReport1.setReportKey(pReportKey1);
        }

        AT_BatchLogReport aT_BatchLogReport2 = baseDomManager.getBatchJob(pBatchJobId).getBatchLogReport(pReportKey2);
        if ( null == aT_BatchLogReport2 ){

            aT_BatchLogReport2 = aT_BatchJob.createBatchLogReport();
            aT_BatchLogReport2.setReportKey(pReportKey2);
        }

        AT_BatchLogReport aT_BatchLogReport3 = baseDomManager.getBatchJob(pBatchJobId).getBatchLogReport(pReportKey3);
        if ( null == aT_BatchLogReport3 ){

            aT_BatchLogReport3 = aT_BatchJob.createBatchLogReport();
            aT_BatchLogReport3.setReportKey(pReportKey3);
        }

        AT_BatchLogReport aT_BatchLogReport4 = baseDomManager.getBatchJob(pBatchJobId).getBatchLogReport(pReportKey4);
        if ( null == aT_BatchLogReport4 ){

            aT_BatchLogReport4 = aT_BatchJob.createBatchLogReport();
            aT_BatchLogReport4.setReportKey(pReportKey4);
        }

        AT_BatchLogReport aT_BatchLogReport5 = baseDomManager.getBatchJob(pBatchJobId).getBatchLogReport(pReportKey5);
        if ( null == aT_BatchLogReport5 ){

            aT_BatchLogReport5 = aT_BatchJob.createBatchLogReport();
            aT_BatchLogReport5.setReportKey(pReportKey5);
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

            aT_BatchJob.getBatchLogReports().removeAll(aT_BatchJob.getBatchLogReports());

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
        List<AT_BatchLogReport> batchLogReportList = baseDomManager.getBatchJob(pBatchJobId).getBatchLogReports();

        List<AT_BatchLogReport> resultBatchLogReportList = ImmutableList.copyOf(Iterables.filter(batchLogReportList, new Predicate<AT_BatchLogReport>() {

            @Override
            public boolean apply(AT_BatchLogReport pBatchLogReportEntity) {

                List<String> pReportKeyList = new ArrayList<String>();
                pReportKeyList.add("CK00000001");
                pReportKeyList.add("CK00000002");
                pReportKeyList.add("CK00000003");
                pReportKeyList.add("CK00000004");
                pReportKeyList.add("CK00000005");

                for (String reportKey : pReportKeyList) {
                    if (reportKey.equals(pBatchLogReportEntity.getReportKey())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultBatchLogReportList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pBatchJobId = "BJI0000001";
        String pReportKey = "CK00000001";
        AT_BatchLogReport aT_BatchLogReport = baseDomManager.getBatchJob(pBatchJobId).getBatchLogReport(pReportKey);

        assertEquals(pBatchJobId, aT_BatchLogReport.getBatchJobId());
        assertEquals(pReportKey, aT_BatchLogReport.getReportKey());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pBatchJobId = "BJI0000001";
        String pReportKey = "CK00000099";
        AT_BatchLogReport aT_BatchLogReport = baseDomManager.getBatchJob(pBatchJobId).getBatchLogReport(pReportKey);

        assertNull(aT_BatchLogReport);
    }

    @Override
    @Test
    public void blankCondition() {
        String pBatchJobId = "BJI0000001";
        String pReportKey = "";
        AT_BatchLogReport aT_BatchLogReport = baseDomManager.getBatchJob(pBatchJobId).getBatchLogReport(pReportKey);

        assertNull(aT_BatchLogReport);
    }

    @Override
    @Test
    public void nullCondition() {
        String pBatchJobId = "BJI0000001";
        String pReportKey = null;
        try {
            baseDomManager.getBatchJob(pBatchJobId).getBatchLogReport(pReportKey);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}

