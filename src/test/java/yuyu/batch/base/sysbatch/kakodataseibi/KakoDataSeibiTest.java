package yuyu.batch.base.sysbatch.kakodataseibi;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.batch.test.BatchTestRunner;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.BatchTester;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.classification.C_BatchKidouKbn;
import yuyu.def.db.entity.AS_Sakujyotaisyo;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.infr.batch.BatchParam;
import yuyu.testinfr.AbstractBatchTest;

/**
 * 過去データ整備バッチ の単体テストです。
 */
@RunWith(BatchTestRunner.class)
@BatchTester("kakodataseibi")
public class KakoDataSeibiTest extends AbstractBatchTest {

    @Inject
    private ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

    @Inject
    private KakoDataSeibiBatch batch;

    @Inject
    private BatchParam param;

    private static final BizDate syoriYmd = BizDate.getSysDate();

    @Before
    public void setup() {
        param.setKidouKbn(C_BatchKidouKbn.BATCH);
        param.setUserId("JUnitTest");
        param.setSyoriYmd(syoriYmd);
    }

    @Override
    public void preTestCase(String caseName) {
        File taihiData = new File(YuyuBaseConfig.getInstance().getBatchOutputDir(), "20130321AT_AccessLog.csv");
        if (taihiData.exists()) {
            taihiData.delete();
        }
        clearTable(AS_Sakujyotaisyo.class);
        clearTable(AT_AccessLog.class);
        initTable(caseName, AS_Sakujyotaisyo.class);
        initTable(caseName, AT_AccessLog.class);
    }

    @Test
    public void test_Case1() throws Exception {

//        File taihiDir = new File(YuyuBaseConfig.getInstance().getBatchOutputDir());
//        delete(taihiDir);

        List<AT_AccessLog> all = em.findAll(AT_AccessLog.class);
        exNumericEquals(16, all.size(), "過去データ整備前");
        em.clear();

        batch.execute();

        all = em.findAll(AT_AccessLog.class);
        exNumericEquals(0, all.size(), "過去データ整備後");
        File taihiData = new File(YuyuBaseConfig.getInstance().getBatchOutputDir(), "20130321AT_AccessLog.csv");
        exBooleanEquals(taihiData.exists(), true, "退避データ");
    }

    @Test
    public void test_Case2() throws Exception {
        List<AT_AccessLog> all = em.findAll(AT_AccessLog.class);
        exNumericEquals(all.size(), 16, "過去データ整備前");
        em.clear();

        batch.execute();

        all = em.findAll(AT_AccessLog.class);
        exNumericEquals(all.size(), 3, "過去データ整備後");
        File taihiData = new File(YuyuBaseConfig.getInstance().getBatchOutputDir(), "20130321AT_AccessLog.csv");
        exBooleanEquals(taihiData.exists(), false, "退避データ");
    }

    @Test
    public void test_Case3() throws Exception {
        List<AT_AccessLog> all = em.findAll(AT_AccessLog.class);
        exNumericEquals(all.size(), 16, "過去データ整備前");
        em.clear();

        batch.execute();

        all = em.findAll(AT_AccessLog.class);
        exNumericEquals(all.size(), 12, "過去データ整備後");
        File taihiData = new File(YuyuBaseConfig.getInstance().getBatchOutputDir(), "20130321AT_AccessLog.csv");
        exBooleanEquals(taihiData.exists(), true, "退避データ");
    }

    @Test
    public void test_Case4() throws Exception {
        List<AT_AccessLog> all = em.findAll(AT_AccessLog.class);
        exNumericEquals(all.size(), 16, "過去データ整備前");
        em.clear();

        batch.execute();

        all = em.findAll(AT_AccessLog.class);
        exNumericEquals(all.size(), 11, "過去データ整備後");
        File taihiData = new File(YuyuBaseConfig.getInstance().getBatchOutputDir(), "20130321AT_AccessLog.csv");
        exBooleanEquals(taihiData.exists(), true, "退避データ");
    }

    private void delete(File pTarget) {

        if( pTarget.exists()==false ){
            return ;
        }

        if(pTarget.isFile()){
            pTarget.delete();
        }

        if(pTarget.isDirectory()){
            File[] files=pTarget.listFiles();
            for(int i=0; i<files.length; i++){
                delete( files[i] );
            }
            pTarget.delete();
        }
    }

}
