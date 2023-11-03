package yuyu.batch.base.sysbatch.kakodataseibi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.testinfr.AbstractTest;

/**
 * 過去データ整備DAOクラスの<br />
 * getTyouhyouKensakuListBySyoruiCdSyoriYmd のテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class KakoDataSeibiTest_getTyouhyouKensakuListBySyoruiCdSyoriYmd extends AbstractTest {

    @Inject
    private KakoDataSeibiDao kakoDataSeibiDao;

    @Inject
    private BaseDomManager baseDomManager;

    @Test
    @Transactional
    public void test001() {

        insertTest002();

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.USERITIRANHYOU;
        BizDate syoriYmd = BizDate.valueOf("20160415");

        List<AT_TyouhyouKensaku> tyouhyouKensakuList = new ArrayList<AT_TyouhyouKensaku>();

        try (ExDBResults<AT_TyouhyouKensaku> resultEntityList = kakoDataSeibiDao.getTyouhyouKensakuListBySyoruiCdSyoriYmd(syoruiCd, syoriYmd)) {

            for (AT_TyouhyouKensaku resultEntity : resultEntityList) {

                AT_TyouhyouKensaku tyouhyouKensaku = new AT_TyouhyouKensaku();

                tyouhyouKensaku.setUniqueId(resultEntity.getUniqueId());
                tyouhyouKensaku.setReportKey(resultEntity.getReportKey());
                tyouhyouKensaku.setSyoruiCd(C_SyoruiCdKbn.USERITIRANHYOU);
                tyouhyouKensaku.setSubSystemId(resultEntity.getSubSystemId());
                tyouhyouKensaku.setCategoryId(resultEntity.getCategoryId());
                tyouhyouKensaku.setKinouId(resultEntity.getKinouId());
                tyouhyouKensaku.setKensakuKey1(resultEntity.getKensakuKey1());
                tyouhyouKensaku.setKensakuKey2(resultEntity.getKensakuKey2());
                tyouhyouKensaku.setKensakuKey3(resultEntity.getKensakuKey3());
                tyouhyouKensaku.setKensakuKey4(resultEntity.getKensakuKey4());
                tyouhyouKensaku.setKensakuKey5(resultEntity.getKensakuKey5());
                tyouhyouKensaku.setSyoriYmd(resultEntity.getSyoriYmd());
                tyouhyouKensaku.setFirstOutYmd(resultEntity.getFirstOutYmd());
                tyouhyouKensaku.setLastOutYmd(resultEntity.getLastOutYmd());
                tyouhyouKensaku.setOutCount(resultEntity.getOutCount());
                tyouhyouKensaku.setLastOutUserId(resultEntity.getLastOutUserId());
                tyouhyouKensaku.setSyoruiKetugouUmuKbn(resultEntity.getSyoruiKetugouUmuKbn());
                tyouhyouKensaku.setFileSize(resultEntity.getFileSize());
                tyouhyouKensaku.setPageCount(resultEntity.getPageCount());
                tyouhyouKensaku.setKousinsyaId(resultEntity.getKousinsyaId());
                tyouhyouKensaku.setKousinTime(resultEntity.getKousinTime());
                tyouhyouKensaku.setVersion(resultEntity.getVersion());

                tyouhyouKensakuList.add(tyouhyouKensaku);

            }

        }

        String uniqueId1 = "0102dn7l9mjcknvn02";
        String uniqueId2 = "0102dn7l9mjcknvn03";

        assertEquals(2, tyouhyouKensakuList.size());

        assertEquals(uniqueId1, tyouhyouKensakuList.get(0).getUniqueId());
        assertEquals(uniqueId2, tyouhyouKensakuList.get(1).getUniqueId());

        deleteTest002();

    }

    @Test
    @Transactional
    public void test002() {

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.USERITIRANHYOU;
        BizDate syoriYmd = BizDate.valueOf("20160415");


        List<AT_TyouhyouKensaku> tyouhyouKensakuList = new ArrayList<AT_TyouhyouKensaku>();

        try (ExDBResults<AT_TyouhyouKensaku> resultEntityList = kakoDataSeibiDao.getTyouhyouKensakuListBySyoruiCdSyoriYmd(syoruiCd, syoriYmd)) {

            for (AT_TyouhyouKensaku resultEntity : resultEntityList) {

                AT_TyouhyouKensaku tyouhyouKensaku = new AT_TyouhyouKensaku();

                tyouhyouKensaku.setUniqueId(resultEntity.getUniqueId());
                tyouhyouKensaku.setReportKey(resultEntity.getReportKey());
                tyouhyouKensaku.setSyoruiCd(C_SyoruiCdKbn.USERITIRANHYOU);
                tyouhyouKensaku.setSubSystemId(resultEntity.getSubSystemId());
                tyouhyouKensaku.setCategoryId(resultEntity.getCategoryId());
                tyouhyouKensaku.setKinouId(resultEntity.getKinouId());
                tyouhyouKensaku.setKensakuKey1(resultEntity.getKensakuKey1());
                tyouhyouKensaku.setKensakuKey2(resultEntity.getKensakuKey2());
                tyouhyouKensaku.setKensakuKey3(resultEntity.getKensakuKey3());
                tyouhyouKensaku.setKensakuKey4(resultEntity.getKensakuKey4());
                tyouhyouKensaku.setKensakuKey5(resultEntity.getKensakuKey5());
                tyouhyouKensaku.setSyoriYmd(resultEntity.getSyoriYmd());
                tyouhyouKensaku.setFirstOutYmd(resultEntity.getFirstOutYmd());
                tyouhyouKensaku.setLastOutYmd(resultEntity.getLastOutYmd());
                tyouhyouKensaku.setOutCount(resultEntity.getOutCount());
                tyouhyouKensaku.setLastOutUserId(resultEntity.getLastOutUserId());
                tyouhyouKensaku.setSyoruiKetugouUmuKbn(resultEntity.getSyoruiKetugouUmuKbn());
                tyouhyouKensaku.setFileSize(resultEntity.getFileSize());
                tyouhyouKensaku.setPageCount(resultEntity.getPageCount());
                tyouhyouKensaku.setKousinsyaId(resultEntity.getKousinsyaId());
                tyouhyouKensaku.setKousinTime(resultEntity.getKousinTime());
                tyouhyouKensaku.setVersion(resultEntity.getVersion());

                tyouhyouKensakuList.add(tyouhyouKensaku);

            }

        }

        assertEquals(0, tyouhyouKensakuList.size());

    }

    @Test
    @Transactional
    public void test003() {

        insertTest001();

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.USERITIRANHYOU;
        BizDate syoriYmd = BizDate.valueOf("20160415");


        List<AT_TyouhyouKensaku> tyouhyouKensakuList = new ArrayList<AT_TyouhyouKensaku>();

        try (ExDBResults<AT_TyouhyouKensaku> resultEntityList = kakoDataSeibiDao.getTyouhyouKensakuListBySyoruiCdSyoriYmd(syoruiCd, syoriYmd)) {

            for (AT_TyouhyouKensaku resultEntity : resultEntityList) {

                AT_TyouhyouKensaku tyouhyouKensaku = new AT_TyouhyouKensaku();

                tyouhyouKensaku.setUniqueId(resultEntity.getUniqueId());
                tyouhyouKensaku.setReportKey(resultEntity.getReportKey());
                tyouhyouKensaku.setSyoruiCd(C_SyoruiCdKbn.USERITIRANHYOU);
                tyouhyouKensaku.setSubSystemId(resultEntity.getSubSystemId());
                tyouhyouKensaku.setCategoryId(resultEntity.getCategoryId());
                tyouhyouKensaku.setKinouId(resultEntity.getKinouId());
                tyouhyouKensaku.setKensakuKey1(resultEntity.getKensakuKey1());
                tyouhyouKensaku.setKensakuKey2(resultEntity.getKensakuKey2());
                tyouhyouKensaku.setKensakuKey3(resultEntity.getKensakuKey3());
                tyouhyouKensaku.setKensakuKey4(resultEntity.getKensakuKey4());
                tyouhyouKensaku.setKensakuKey5(resultEntity.getKensakuKey5());
                tyouhyouKensaku.setSyoriYmd(resultEntity.getSyoriYmd());
                tyouhyouKensaku.setFirstOutYmd(resultEntity.getFirstOutYmd());
                tyouhyouKensaku.setLastOutYmd(resultEntity.getLastOutYmd());
                tyouhyouKensaku.setOutCount(resultEntity.getOutCount());
                tyouhyouKensaku.setLastOutUserId(resultEntity.getLastOutUserId());
                tyouhyouKensaku.setSyoruiKetugouUmuKbn(resultEntity.getSyoruiKetugouUmuKbn());
                tyouhyouKensaku.setFileSize(resultEntity.getFileSize());
                tyouhyouKensaku.setPageCount(resultEntity.getPageCount());
                tyouhyouKensaku.setKousinsyaId(resultEntity.getKousinsyaId());
                tyouhyouKensaku.setKousinTime(resultEntity.getKousinTime());
                tyouhyouKensaku.setVersion(resultEntity.getVersion());

                tyouhyouKensakuList.add(tyouhyouKensaku);

            }

        }

        String uniqueId1 = "0102dn7l9mjcknvn01";

        assertEquals(1, tyouhyouKensakuList.size());

        assertEquals(uniqueId1, tyouhyouKensakuList.get(0).getUniqueId());

        deleteTest001();

    }

    @Test
    @Transactional
    public void test004() {

        insertTest004();

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.USERITIRANHYOU;
        BizDate syoriYmd = BizDate.valueOf("20160415");


        List<AT_TyouhyouKensaku> tyouhyouKensakuList = new ArrayList<AT_TyouhyouKensaku>();

        try (ExDBResults<AT_TyouhyouKensaku> resultEntityList = kakoDataSeibiDao.getTyouhyouKensakuListBySyoruiCdSyoriYmd(syoruiCd, syoriYmd)) {

            for (AT_TyouhyouKensaku resultEntity : resultEntityList) {

                AT_TyouhyouKensaku tyouhyouKensaku = new AT_TyouhyouKensaku();

                tyouhyouKensaku.setUniqueId(resultEntity.getUniqueId());
                tyouhyouKensaku.setReportKey(resultEntity.getReportKey());
                tyouhyouKensaku.setSyoruiCd(C_SyoruiCdKbn.USERITIRANHYOU);
                tyouhyouKensaku.setSubSystemId(resultEntity.getSubSystemId());
                tyouhyouKensaku.setCategoryId(resultEntity.getCategoryId());
                tyouhyouKensaku.setKinouId(resultEntity.getKinouId());
                tyouhyouKensaku.setKensakuKey1(resultEntity.getKensakuKey1());
                tyouhyouKensaku.setKensakuKey2(resultEntity.getKensakuKey2());
                tyouhyouKensaku.setKensakuKey3(resultEntity.getKensakuKey3());
                tyouhyouKensaku.setKensakuKey4(resultEntity.getKensakuKey4());
                tyouhyouKensaku.setKensakuKey5(resultEntity.getKensakuKey5());
                tyouhyouKensaku.setSyoriYmd(resultEntity.getSyoriYmd());
                tyouhyouKensaku.setFirstOutYmd(resultEntity.getFirstOutYmd());
                tyouhyouKensaku.setLastOutYmd(resultEntity.getLastOutYmd());
                tyouhyouKensaku.setOutCount(resultEntity.getOutCount());
                tyouhyouKensaku.setLastOutUserId(resultEntity.getLastOutUserId());
                tyouhyouKensaku.setSyoruiKetugouUmuKbn(resultEntity.getSyoruiKetugouUmuKbn());
                tyouhyouKensaku.setFileSize(resultEntity.getFileSize());
                tyouhyouKensaku.setPageCount(resultEntity.getPageCount());
                tyouhyouKensaku.setKousinsyaId(resultEntity.getKousinsyaId());
                tyouhyouKensaku.setKousinTime(resultEntity.getKousinTime());
                tyouhyouKensaku.setVersion(resultEntity.getVersion());

                tyouhyouKensakuList.add(tyouhyouKensaku);

            }

        }

        BizDate syoriYmd1 = BizDate.valueOf("20160410");
        String uniqueId1  = "0102dn7l9mjcknvn01";

        BizDate syoriYmd2 = BizDate.valueOf("20160410");
        String uniqueId2  = "0102dn7l9mjcknvn02";

        BizDate syoriYmd3 = BizDate.valueOf("20160410");
        String uniqueId3  = "0102dn7l9mjcknvn03";

        BizDate syoriYmd4 = BizDate.valueOf("20160413");
        String uniqueId4  = "0102dn7l9mjcknvn05";

        BizDate syoriYmd5 = BizDate.valueOf("20160414");
        String uniqueId5  = "0102dn7l9mjcknvn06";

        BizDate syoriYmd6 = BizDate.valueOf("20160415");
        String uniqueId6  = "0102dn7l9mjcknvn04";

        assertEquals(6, tyouhyouKensakuList.size());

        assertEquals(syoriYmd1, tyouhyouKensakuList.get(0).getSyoriYmd());
        assertEquals(uniqueId1, tyouhyouKensakuList.get(0).getUniqueId());

        assertEquals(syoriYmd2, tyouhyouKensakuList.get(1).getSyoriYmd());
        assertEquals(uniqueId2, tyouhyouKensakuList.get(1).getUniqueId());

        assertEquals(syoriYmd3, tyouhyouKensakuList.get(2).getSyoriYmd());
        assertEquals(uniqueId3, tyouhyouKensakuList.get(2).getUniqueId());

        assertEquals(syoriYmd4, tyouhyouKensakuList.get(3).getSyoriYmd());
        assertEquals(uniqueId4, tyouhyouKensakuList.get(3).getUniqueId());

        assertEquals(syoriYmd5, tyouhyouKensakuList.get(4).getSyoriYmd());
        assertEquals(uniqueId5, tyouhyouKensakuList.get(4).getUniqueId());

        assertEquals(syoriYmd6, tyouhyouKensakuList.get(5).getSyoriYmd());
        assertEquals(uniqueId6, tyouhyouKensakuList.get(5).getUniqueId());

        deleteTest004();

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
            tyouhyouKensaku001.setKousinsyaId("Junit");
            tyouhyouKensaku001.setKousinTime("20160324092418999");
            tyouhyouKensaku001.setKousinKinou("Junit");
            tyouhyouKensaku001.setVersion(0);

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
            tyouhyouKensaku001.setKousinsyaId("Junit");
            tyouhyouKensaku001.setKousinTime("20160324092418999");
            tyouhyouKensaku001.setKousinKinou("Junit");
            tyouhyouKensaku001.setVersion(0);

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
            tyouhyouKensaku002.setKousinsyaId("Junit");
            tyouhyouKensaku002.setKousinTime("20160324092418999");
            tyouhyouKensaku002.setKousinKinou("Junit");
            tyouhyouKensaku002.setVersion(0);

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
            tyouhyouKensaku003.setKousinsyaId("Junit");
            tyouhyouKensaku003.setKousinTime("20160324092418999");
            tyouhyouKensaku003.setKousinKinou("Junit");
            tyouhyouKensaku003.setVersion(0);

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
            tyouhyouKensaku004.setKousinsyaId("Junit");
            tyouhyouKensaku004.setKousinTime("20160324092418999");
            tyouhyouKensaku004.setKousinKinou("Junit");
            tyouhyouKensaku004.setVersion(0);

            baseDomManager.insert(tyouhyouKensaku004);
        }

    }

    @Transactional
    private void insertTest004() {

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
            tyouhyouKensaku001.setSyoriYmd(BizDate.valueOf("20160410"));
            tyouhyouKensaku001.setFirstOutYmd(null);
            tyouhyouKensaku001.setLastOutYmd(null);
            tyouhyouKensaku001.setOutCount(0);
            tyouhyouKensaku001.setLastOutUserId(null);
            tyouhyouKensaku001.setSyoruiKetugouUmuKbn(null);
            tyouhyouKensaku001.setFileSize(Long.valueOf(62966));
            tyouhyouKensaku001.setPageCount(10);

            baseDomManager.insert(tyouhyouKensaku001);
        }

        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn03") == null) {

            AT_TyouhyouKensaku tyouhyouKensaku002 = new AT_TyouhyouKensaku();

            tyouhyouKensaku002.setUniqueId("0102dn7l9mjcknvn03");
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
            tyouhyouKensaku002.setSyoriYmd(BizDate.valueOf("20160410"));
            tyouhyouKensaku002.setFirstOutYmd(null);
            tyouhyouKensaku002.setLastOutYmd(null);
            tyouhyouKensaku002.setOutCount(0);
            tyouhyouKensaku002.setLastOutUserId(null);
            tyouhyouKensaku002.setSyoruiKetugouUmuKbn(null);
            tyouhyouKensaku002.setFileSize(Long.valueOf(62966));
            tyouhyouKensaku002.setPageCount(10);

            baseDomManager.insert(tyouhyouKensaku002);
        }

        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn02") == null) {

            AT_TyouhyouKensaku tyouhyouKensaku003 = new AT_TyouhyouKensaku();

            tyouhyouKensaku003.setUniqueId("0102dn7l9mjcknvn02");
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
            tyouhyouKensaku003.setSyoriYmd(BizDate.valueOf("20160410"));
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
            tyouhyouKensaku004.setSyoriYmd(BizDate.valueOf("20160415"));
            tyouhyouKensaku004.setFirstOutYmd(null);
            tyouhyouKensaku004.setLastOutYmd(null);
            tyouhyouKensaku004.setOutCount(0);
            tyouhyouKensaku004.setLastOutUserId(null);
            tyouhyouKensaku004.setSyoruiKetugouUmuKbn(null);
            tyouhyouKensaku004.setFileSize(Long.valueOf(62966));
            tyouhyouKensaku004.setPageCount(10);

            baseDomManager.insert(tyouhyouKensaku004);
        }


        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn05") == null) {

            AT_TyouhyouKensaku tyouhyouKensaku005 = new AT_TyouhyouKensaku();

            tyouhyouKensaku005.setUniqueId("0102dn7l9mjcknvn05");
            tyouhyouKensaku005.setReportKey("0102dn7l9agpmja61u");
            tyouhyouKensaku005.setSyoruiCd(C_SyoruiCdKbn.USERITIRANHYOU);
            tyouhyouKensaku005.setSubSystemId("bsae");
            tyouhyouKensaku005.setCategoryId("system");
            tyouhyouKensaku005.setKinouId("useritiranhyou");
            tyouhyouKensaku005.setKensakuKey1("zokuseicd");
            tyouhyouKensaku005.setKensakuKey2(null);
            tyouhyouKensaku005.setKensakuKey3(null);
            tyouhyouKensaku005.setKensakuKey4(null);
            tyouhyouKensaku005.setKensakuKey5(null);
            tyouhyouKensaku005.setSyoriYmd(BizDate.valueOf("20160413"));
            tyouhyouKensaku005.setFirstOutYmd(null);
            tyouhyouKensaku005.setLastOutYmd(null);
            tyouhyouKensaku005.setOutCount(0);
            tyouhyouKensaku005.setLastOutUserId(null);
            tyouhyouKensaku005.setSyoruiKetugouUmuKbn(null);
            tyouhyouKensaku005.setFileSize(Long.valueOf(62966));
            tyouhyouKensaku005.setPageCount(10);

            baseDomManager.insert(tyouhyouKensaku005);
        }


        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn06") == null) {

            AT_TyouhyouKensaku tyouhyouKensaku006 = new AT_TyouhyouKensaku();

            tyouhyouKensaku006.setUniqueId("0102dn7l9mjcknvn06");
            tyouhyouKensaku006.setReportKey("0102dn7l9agpmja61u");
            tyouhyouKensaku006.setSyoruiCd(C_SyoruiCdKbn.USERITIRANHYOU);
            tyouhyouKensaku006.setSubSystemId("bsae");
            tyouhyouKensaku006.setCategoryId("system");
            tyouhyouKensaku006.setKinouId("useritiranhyou");
            tyouhyouKensaku006.setKensakuKey1("zokuseicd");
            tyouhyouKensaku006.setKensakuKey2(null);
            tyouhyouKensaku006.setKensakuKey3(null);
            tyouhyouKensaku006.setKensakuKey4(null);
            tyouhyouKensaku006.setKensakuKey5(null);
            tyouhyouKensaku006.setSyoriYmd(BizDate.valueOf("20160414"));
            tyouhyouKensaku006.setFirstOutYmd(null);
            tyouhyouKensaku006.setLastOutYmd(null);
            tyouhyouKensaku006.setOutCount(0);
            tyouhyouKensaku006.setLastOutUserId(null);
            tyouhyouKensaku006.setSyoruiKetugouUmuKbn(null);
            tyouhyouKensaku006.setFileSize(Long.valueOf(62966));
            tyouhyouKensaku006.setPageCount(10);

            baseDomManager.insert(tyouhyouKensaku006);
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

    @Transactional
    private void deleteTest004() {

        baseDomManager.clear();

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

        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn05") != null) {

            baseDomManager.delete(baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn05"));

        }

        if (baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn06") != null) {

            baseDomManager.delete(baseDomManager.getTyouhyouKensaku("0102dn7l9mjcknvn06"));

        }
    }
}
