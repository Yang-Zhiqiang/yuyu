package yuyu.batch.base.sysbatch.kakodataseibi;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.testinfr.AbstractTest;

/**
 * 過去データ整備DAOクラスの<br />
 * getCountTyouhyouKensakuListBySyoruiCdSyoriYmd のテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class KakoDataSeibiTest_getCountTyouhyouKensakuListBySyoruiCdSyoriYmd extends AbstractTest {

    @Inject
    private KakoDataSeibiDao kakoDataSeibiDao;

    @Inject
    private BaseDomManager baseDomManager;

    @Test
    @Transactional
    public void test001() {

        insertTest001();

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.USERITIRANHYOU;
        BizDate syoriYmd = null;

        try {
            kakoDataSeibiDao.getCountTyouhyouKensakuListBySyoruiCdSyoriYmd(syoruiCd, syoriYmd);

        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }

        deleteTest001();

    }

    @Test
    @Transactional
    public void test002() {

        insertTest001();

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.USERITIRANHYOU;
        BizDate syoriYmd = BizDate.valueOf("20160415");

        long resultCount = kakoDataSeibiDao.getCountTyouhyouKensakuListBySyoruiCdSyoriYmd(syoruiCd, syoriYmd);

        assertEquals(1, resultCount);

        deleteTest001();

    }

    @Test
    @Transactional
    public void test003() {

        insertTest002();

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.USERITIRANHYOU;
        BizDate syoriYmd = BizDate.valueOf("20160415");

        long resultCount = kakoDataSeibiDao.getCountTyouhyouKensakuListBySyoruiCdSyoriYmd(syoruiCd, syoriYmd);

        assertEquals(2, resultCount);

        deleteTest002();

    }

    @Test
    @Transactional
    public void test004() {

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.USERITIRANHYOU;
        BizDate syoriYmd = BizDate.valueOf("20160415");

        long resultCount = kakoDataSeibiDao.getCountTyouhyouKensakuListBySyoruiCdSyoriYmd(syoruiCd, syoriYmd);

        assertEquals(0, resultCount);

    }

    @Test
    @Transactional
    public void test005() {

        insertTest001();

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.USERITIRANHYOU;
        BizDate syoriYmd = BizDate.valueOf("20160415");

        long resultCount = kakoDataSeibiDao.getCountTyouhyouKensakuListBySyoruiCdSyoriYmd(syoruiCd, syoriYmd);

        assertEquals(1, resultCount);

        deleteTest001();

    }

    @Transactional
    private void insertTest001() {

        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn01") == null) {

            AT_TyouhyouKensaku tyouhyouKensaku001 = new AT_TyouhyouKensaku();

            tyouhyouKensaku001.setUniqueId("0102dn7l9mjcknvn01");
            tyouhyouKensaku001.setReportKey("0102dn7l9agpmja61u");
            tyouhyouKensaku001.setSyoruiCd(C_SyoruiCdKbn.USERITIRANHYOU);
            tyouhyouKensaku001.setSubSystemId("bsae");
            tyouhyouKensaku001.setCategoryId("system");
            tyouhyouKensaku001.setKinouId("useritiranhyou");
            tyouhyouKensaku001.setKensakuKey1("zokuseicd");
            tyouhyouKensaku001.setKensakuKey2(null);
            tyouhyouKensaku001.setKensakuKey3(null);
            tyouhyouKensaku001.setKensakuKey4(null);
            tyouhyouKensaku001.setKensakuKey5(null);
            tyouhyouKensaku001.setSyoriYmd(BizDate.valueOf("20160415"));
            tyouhyouKensaku001.setFirstOutYmd(null);
            tyouhyouKensaku001.setLastOutYmd(null);
            tyouhyouKensaku001.setOutCount(0);
            tyouhyouKensaku001.setLastOutUserId(null);
            tyouhyouKensaku001.setSyoruiKetugouUmuKbn(null);
            tyouhyouKensaku001.setFileSize(Long.valueOf(62966));
            tyouhyouKensaku001.setPageCount(10);

            baseDomManager.insert(tyouhyouKensaku001);
        }

    }

    @Transactional
    private void insertTest002() {

        if (baseDomManager.getSyoruiZokusei(C_SyoruiCdKbn.BLNK) == null) {

            AM_SyoruiZokusei syoruiZokusei = new AM_SyoruiZokusei();

            syoruiZokusei.setSyoruiCd(C_SyoruiCdKbn.BLNK);

            baseDomManager.insert(syoruiZokusei);
        }

        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn01") == null) {

            AT_TyouhyouKensaku tyouhyouKensaku001 = new AT_TyouhyouKensaku();

            tyouhyouKensaku001.setUniqueId("0102dn7l9mjcknvn01");
            tyouhyouKensaku001.setReportKey("0102dn7l9agpmja61u");
            tyouhyouKensaku001.setSyoruiCd(C_SyoruiCdKbn.BLNK);
            tyouhyouKensaku001.setSubSystemId("bsae");
            tyouhyouKensaku001.setCategoryId("system");
            tyouhyouKensaku001.setKinouId("useritiranhyou");
            tyouhyouKensaku001.setKensakuKey1("zokuseicd");
            tyouhyouKensaku001.setKensakuKey2(null);
            tyouhyouKensaku001.setKensakuKey3(null);
            tyouhyouKensaku001.setKensakuKey4(null);
            tyouhyouKensaku001.setKensakuKey5(null);
            tyouhyouKensaku001.setSyoriYmd(BizDate.valueOf("20160415"));
            tyouhyouKensaku001.setFirstOutYmd(null);
            tyouhyouKensaku001.setLastOutYmd(null);
            tyouhyouKensaku001.setOutCount(0);
            tyouhyouKensaku001.setLastOutUserId(null);
            tyouhyouKensaku001.setSyoruiKetugouUmuKbn(null);
            tyouhyouKensaku001.setFileSize(Long.valueOf(62966));
            tyouhyouKensaku001.setPageCount(10);

            baseDomManager.insert(tyouhyouKensaku001);
        }

        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn02") == null) {

            AT_TyouhyouKensaku tyouhyouKensaku002 = new AT_TyouhyouKensaku();

            tyouhyouKensaku002.setUniqueId("0102dn7l9mjcknvn02");
            tyouhyouKensaku002.setReportKey("0102dn7l9agpmja61u");
            tyouhyouKensaku002.setSyoruiCd(C_SyoruiCdKbn.USERITIRANHYOU);
            tyouhyouKensaku002.setSubSystemId("bsae");
            tyouhyouKensaku002.setCategoryId("system");
            tyouhyouKensaku002.setKinouId("useritiranhyou");
            tyouhyouKensaku002.setKensakuKey1("zokuseicd");
            tyouhyouKensaku002.setKensakuKey2(null);
            tyouhyouKensaku002.setKensakuKey3(null);
            tyouhyouKensaku002.setKensakuKey4(null);
            tyouhyouKensaku002.setKensakuKey5(null);
            tyouhyouKensaku002.setSyoriYmd(BizDate.valueOf("20160414"));
            tyouhyouKensaku002.setFirstOutYmd(null);
            tyouhyouKensaku002.setLastOutYmd(null);
            tyouhyouKensaku002.setOutCount(0);
            tyouhyouKensaku002.setLastOutUserId(null);
            tyouhyouKensaku002.setSyoruiKetugouUmuKbn(null);
            tyouhyouKensaku002.setFileSize(Long.valueOf(62966));
            tyouhyouKensaku002.setPageCount(10);

            baseDomManager.insert(tyouhyouKensaku002);
        }

        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn03") == null) {

            AT_TyouhyouKensaku tyouhyouKensaku003 = new AT_TyouhyouKensaku();

            tyouhyouKensaku003.setUniqueId("0102dn7l9mjcknvn03");
            tyouhyouKensaku003.setReportKey("0102dn7l9agpmja61u");
            tyouhyouKensaku003.setSyoruiCd(C_SyoruiCdKbn.USERITIRANHYOU);
            tyouhyouKensaku003.setSubSystemId("bsae");
            tyouhyouKensaku003.setCategoryId("system");
            tyouhyouKensaku003.setKinouId("useritiranhyou");
            tyouhyouKensaku003.setKensakuKey1("zokuseicd");
            tyouhyouKensaku003.setKensakuKey2(null);
            tyouhyouKensaku003.setKensakuKey3(null);
            tyouhyouKensaku003.setKensakuKey4(null);
            tyouhyouKensaku003.setKensakuKey5(null);
            tyouhyouKensaku003.setSyoriYmd(BizDate.valueOf("20160415"));
            tyouhyouKensaku003.setFirstOutYmd(null);
            tyouhyouKensaku003.setLastOutYmd(null);
            tyouhyouKensaku003.setOutCount(0);
            tyouhyouKensaku003.setLastOutUserId(null);
            tyouhyouKensaku003.setSyoruiKetugouUmuKbn(null);
            tyouhyouKensaku003.setFileSize(Long.valueOf(62966));
            tyouhyouKensaku003.setPageCount(10);

            baseDomManager.insert(tyouhyouKensaku003);
        }

        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn04") == null) {

            AT_TyouhyouKensaku tyouhyouKensaku004 = new AT_TyouhyouKensaku();

            tyouhyouKensaku004.setUniqueId("0102dn7l9mjcknvn04");
            tyouhyouKensaku004.setReportKey("0102dn7l9agpmja61u");
            tyouhyouKensaku004.setSyoruiCd(C_SyoruiCdKbn.USERITIRANHYOU);
            tyouhyouKensaku004.setSubSystemId("bsae");
            tyouhyouKensaku004.setCategoryId("system");
            tyouhyouKensaku004.setKinouId("useritiranhyou");
            tyouhyouKensaku004.setKensakuKey1("zokuseicd");
            tyouhyouKensaku004.setKensakuKey2(null);
            tyouhyouKensaku004.setKensakuKey3(null);
            tyouhyouKensaku004.setKensakuKey4(null);
            tyouhyouKensaku004.setKensakuKey5(null);
            tyouhyouKensaku004.setSyoriYmd(BizDate.valueOf("20160416"));
            tyouhyouKensaku004.setFirstOutYmd(null);
            tyouhyouKensaku004.setLastOutYmd(null);
            tyouhyouKensaku004.setOutCount(0);
            tyouhyouKensaku004.setLastOutUserId(null);
            tyouhyouKensaku004.setSyoruiKetugouUmuKbn(null);
            tyouhyouKensaku004.setFileSize(Long.valueOf(62966));
            tyouhyouKensaku004.setPageCount(10);

            baseDomManager.insert(tyouhyouKensaku004);
        }

    }

    @Transactional
    private void deleteTest001() {

        baseDomManager.clear();

        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn01") != null) {

            baseDomManager.delete(baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn01"));

        }

    }

    @Transactional
    private void deleteTest002() {

        baseDomManager.clear();

        if (baseDomManager.getSyoruiZokusei(C_SyoruiCdKbn.BLNK) != null) {

            baseDomManager.delete(baseDomManager.getSyoruiZokusei(C_SyoruiCdKbn.BLNK));
        }

        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn01") != null) {

            baseDomManager.delete(baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn01"));

        }

        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn02") != null) {

            baseDomManager.delete(baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn02"));

        }

        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn03") != null) {

            baseDomManager.delete(baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn03"));

        }

        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn04") != null) {

            baseDomManager.delete(baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn04"));

        }
    }

}
