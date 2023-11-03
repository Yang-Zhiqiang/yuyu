package yuyu.batch.base.sysbatch.kakodataseibi;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.testinfr.AbstractTest;

/**
 * 過去データ整備DAOクラスの<br />
 * deleteTyouhyouHozonByReportKey のテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class KakoDataSeibiTest_deleteTyouhyouHozonByReportKey extends AbstractTest {

    @Inject
    private KakoDataSeibiDao kakoDataSeibiDao;

    @Inject
    private BaseDomManager baseDomManager;

    @Test
    @Transactional
    public void test001() {

        insertTest002();

        String reportKey = "0022din6wogztj1e01";

        long resultCount = kakoDataSeibiDao.deleteTyouhyouHozonByReportKey(reportKey);

        assertEquals(1, resultCount);

        deleteTest002();

    }

    @Test
    @Transactional
    public void test002() {

        String reportKey = "0022din6wogztj1e01";

        long resultCount = kakoDataSeibiDao.deleteTyouhyouHozonByReportKey(reportKey);

        assertEquals(0, resultCount);

    }

    @Test
    @Transactional
    public void test003() {

        insertTest001();

        String reportKey = "0022din6wogztj1e01";

        long resultCount = kakoDataSeibiDao.deleteTyouhyouHozonByReportKey(reportKey);

        assertEquals(1, resultCount);

        deleteTest001();

    }

    @Transactional
    private void insertTest001() {

        if (baseDomManager.getTyouhyouHozon("0022din6wogztj1e01") == null) {

            AT_TyouhyouHozon tyouhyouHozon001 = new AT_TyouhyouHozon();

            tyouhyouHozon001.setReportKey("0022din6wogztj1e01");
            tyouhyouHozon001.setTyouhyouJoinKey("0022din6wpext2cxv");
            tyouhyouHozon001.setAngoukaKbn(C_YesNoKbn.YES);
            tyouhyouHozon001.setPdfHozonKbn(C_YesNoKbn.NO);
            tyouhyouHozon001.setZipHozonKbn(C_YesNoKbn.NO);
            tyouhyouHozon001.setKousinsyaId("Junit");
            tyouhyouHozon001.setKousinTime("20160324092418999");
            tyouhyouHozon001.setKousinKinou("Junit");
            tyouhyouHozon001.setVersion(0);

            baseDomManager.insert(tyouhyouHozon001);
        }

    }

    @Transactional
    private void insertTest002() {

        if (baseDomManager.getTyouhyouHozon("0022din6wogztj1e01") == null) {

            AT_TyouhyouHozon tyouhyouHozon001 = new AT_TyouhyouHozon();

            tyouhyouHozon001.setReportKey("0022din6wogztj1e01");
            tyouhyouHozon001.setTyouhyouJoinKey("0022din6wpext2cxv");
            tyouhyouHozon001.setAngoukaKbn(C_YesNoKbn.YES);
            tyouhyouHozon001.setPdfHozonKbn(C_YesNoKbn.NO);
            tyouhyouHozon001.setZipHozonKbn(C_YesNoKbn.NO);
            tyouhyouHozon001.setKousinsyaId("Junit");
            tyouhyouHozon001.setKousinTime("20160324092418999");
            tyouhyouHozon001.setKousinKinou("Junit");
            tyouhyouHozon001.setVersion(0);

            baseDomManager.insert(tyouhyouHozon001);
        }

        if (baseDomManager.getTyouhyouHozon("0022din6wogztj1e02") == null) {

            AT_TyouhyouHozon tyouhyouHozon001 = new AT_TyouhyouHozon();

            tyouhyouHozon001.setReportKey("0022din6wogztj1e02");
            tyouhyouHozon001.setTyouhyouJoinKey("0022din6wpext2cxv");
            tyouhyouHozon001.setAngoukaKbn(C_YesNoKbn.YES);
            tyouhyouHozon001.setPdfHozonKbn(C_YesNoKbn.NO);
            tyouhyouHozon001.setZipHozonKbn(C_YesNoKbn.NO);
            tyouhyouHozon001.setKousinsyaId("Junit");
            tyouhyouHozon001.setKousinTime("20160324092418999");
            tyouhyouHozon001.setKousinKinou("Junit");
            tyouhyouHozon001.setVersion(0);

            baseDomManager.insert(tyouhyouHozon001);
        }

    }

    @Transactional
    private void deleteTest001() {

        baseDomManager.clear();

        if (baseDomManager.getTyouhyouHozon("0022din6wogztj1e01") != null) {

            baseDomManager.delete(baseDomManager.getTyouhyouHozon("0022din6wogztj1e01"));

        }

    }

    @Transactional
    private void deleteTest002() {

        baseDomManager.clear();

        if (baseDomManager.getTyouhyouHozon("0022din6wogztj1e01") != null) {

            baseDomManager.delete(baseDomManager.getTyouhyouHozon("0022din6wogztj1e01"));

        }

        if (baseDomManager.getTyouhyouHozon("0022din6wogztj1e02") != null) {

            baseDomManager.delete(baseDomManager.getTyouhyouHozon("0022din6wogztj1e02"));

        }
    }

}
