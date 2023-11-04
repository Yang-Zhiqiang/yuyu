package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getTyouhyouKensakuListBySyoruiCdSyoriYmdOutCount() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getTyouhyouKensakuListBySyoruiCdSyoriYmdOutCount extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        C_SyoruiCdKbn pSyoruiCd1 = C_SyoruiCdKbn.BLNK;
        C_SyoruiCdKbn pSyoruiCd2 = C_SyoruiCdKbn.USERITIRANHYOU;

        AM_SyoruiZokusei aM_SyoruiZokusei1 = baseDomManager.getSyoruiZokusei(pSyoruiCd1);
        if ( null == aM_SyoruiZokusei1 ){

            aM_SyoruiZokusei1 = new AM_SyoruiZokusei();
            aM_SyoruiZokusei1.setSyoruiCd(pSyoruiCd1);

            baseDomManager.insert(aM_SyoruiZokusei1);
        }

        AM_SyoruiZokusei aM_SyoruiZokusei2 = baseDomManager.getSyoruiZokusei(pSyoruiCd2);
        if ( null == aM_SyoruiZokusei2 ){

            aM_SyoruiZokusei2 = new AM_SyoruiZokusei();
            aM_SyoruiZokusei2.setSyoruiCd(pSyoruiCd2);

            baseDomManager.insert(aM_SyoruiZokusei2);
        }

        String pSubSystemId1 = "SSI0000001";
        String pSubSystemId2 = "SSI0000002";
        String pSubSystemId3 = "SSI0000003";

        AS_SubSystem aS_SubSystem1 = baseDomManager.getSubSystem(pSubSystemId1);
        if ( null == aS_SubSystem1 ) {

            aS_SubSystem1 = new AS_SubSystem();
            aS_SubSystem1.setSubSystemId(pSubSystemId1);

            baseDomManager.insert(aS_SubSystem1);
        }

        AS_SubSystem aS_SubSystem2 = baseDomManager.getSubSystem(pSubSystemId2);
        if ( null == aS_SubSystem2 ) {

            aS_SubSystem2 = new AS_SubSystem();
            aS_SubSystem2.setSubSystemId(pSubSystemId2);

            baseDomManager.insert(aS_SubSystem2);
        }

        AS_SubSystem aS_SubSystem3 = baseDomManager.getSubSystem(pSubSystemId3);
        if ( null == aS_SubSystem3 ) {

            aS_SubSystem3 = new AS_SubSystem();
            aS_SubSystem3.setSubSystemId(pSubSystemId3);

            baseDomManager.insert(aS_SubSystem3);
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
        String pUniqueId12 = "UNI0000012";
        String pUniqueId13 = "UNI0000013";
        String pUniqueId14 = "UNI0000014";
        String pUniqueId15 = "UNI0000015";
        String pUniqueId16 = "UNI0000016";
        BizDate pSyoriYmd1 = BizDate.valueOf("20150309");
        BizDate pSyoriYmd2 = BizDate.valueOf("20150409");
        BizDate pSyoriYmd3 = BizDate.valueOf("20150509");
        int pOutCount1 = 0;
        int pOutCount2 = 2;
        int pOutCount3 = 3;
        int pOutCount4 = 4;
        int pOutCount5 = 5;
        int pOutCount6 = 6;
        int pOutCount7 = 7;
        int pOutCount8 = 8;
        int pPageCount1 = 0;
        int pPageCount2 = 1;
        int pPageCount3 = 2;
        int pPageCount4 = 3;
        int pPageCount5 = 4;
        String pKensakuKey1 = "CK1";
        String pKensakuKey2 = "CK2";
        String pKensakuKey3 = "CK3";
        String pKensakuKey4 = "CK4";
        String pKensakuKey5 = "CK5";


        AT_TyouhyouKensaku aT_TyouhyouKensaku1 = baseDomManager.getTyouhyouKensaku(pUniqueId1);
        if ( null == aT_TyouhyouKensaku1 ) {

            aT_TyouhyouKensaku1 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku1.setSubSystemId(pSubSystemId1);
            aT_TyouhyouKensaku1.setUniqueId(pUniqueId1);
            aT_TyouhyouKensaku1.setSyoriYmd(pSyoriYmd1);
            aT_TyouhyouKensaku1.setOutCount(pOutCount1);
            aT_TyouhyouKensaku1.setSyoruiCd(pSyoruiCd1);
            aT_TyouhyouKensaku1.setPageCount(pPageCount1);
            aT_TyouhyouKensaku1.setKensakuKey1(pKensakuKey1);
            aT_TyouhyouKensaku1.setKensakuKey2(pKensakuKey2);
            aT_TyouhyouKensaku1.setKensakuKey3(pKensakuKey3);
            aT_TyouhyouKensaku1.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku1.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku1);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku2 = baseDomManager.getTyouhyouKensaku(pUniqueId2);
        if ( null == aT_TyouhyouKensaku2 ) {

            aT_TyouhyouKensaku2 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku2.setSubSystemId(pSubSystemId2);
            aT_TyouhyouKensaku2.setUniqueId(pUniqueId2);
            aT_TyouhyouKensaku2.setSyoriYmd(pSyoriYmd2);
            aT_TyouhyouKensaku2.setOutCount(pOutCount1);
            aT_TyouhyouKensaku2.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku2.setPageCount(pPageCount1);
            aT_TyouhyouKensaku2.setKensakuKey1(pKensakuKey1);
            aT_TyouhyouKensaku2.setKensakuKey2(pKensakuKey2);
            aT_TyouhyouKensaku2.setKensakuKey3(pKensakuKey3);
            aT_TyouhyouKensaku2.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku2.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku2);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku3 = baseDomManager.getTyouhyouKensaku(pUniqueId3);
        if ( null == aT_TyouhyouKensaku3 ) {

            aT_TyouhyouKensaku3 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku3.setSubSystemId(pSubSystemId2);
            aT_TyouhyouKensaku3.setUniqueId(pUniqueId3);
            aT_TyouhyouKensaku3.setSyoriYmd(pSyoriYmd2);
            aT_TyouhyouKensaku3.setOutCount(pOutCount1);
            aT_TyouhyouKensaku3.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku3.setPageCount(pPageCount1);
            aT_TyouhyouKensaku3.setKensakuKey1(pKensakuKey1);
            aT_TyouhyouKensaku3.setKensakuKey2(pKensakuKey2);
            aT_TyouhyouKensaku3.setKensakuKey3(pKensakuKey3);
            aT_TyouhyouKensaku3.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku3.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku3);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku4 = baseDomManager.getTyouhyouKensaku(pUniqueId4);
        if ( null == aT_TyouhyouKensaku4 ) {

            aT_TyouhyouKensaku4 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku4.setSubSystemId(pSubSystemId2);
            aT_TyouhyouKensaku4.setUniqueId(pUniqueId4);
            aT_TyouhyouKensaku4.setSyoriYmd(pSyoriYmd2);
            aT_TyouhyouKensaku4.setOutCount(pOutCount1);
            aT_TyouhyouKensaku4.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku4.setPageCount(pPageCount1);
            aT_TyouhyouKensaku4.setKensakuKey1(pKensakuKey1);
            aT_TyouhyouKensaku4.setKensakuKey2(pKensakuKey2);
            aT_TyouhyouKensaku4.setKensakuKey3(pKensakuKey3);
            aT_TyouhyouKensaku4.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku4.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku4);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku5 = baseDomManager.getTyouhyouKensaku(pUniqueId5);
        if ( null == aT_TyouhyouKensaku5 ) {

            aT_TyouhyouKensaku5 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku5.setSubSystemId(pSubSystemId3);
            aT_TyouhyouKensaku5.setUniqueId(pUniqueId5);
            aT_TyouhyouKensaku5.setSyoriYmd(pSyoriYmd3);
            aT_TyouhyouKensaku5.setOutCount(pOutCount2);
            aT_TyouhyouKensaku5.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku5.setPageCount(pPageCount2);
            aT_TyouhyouKensaku5.setKensakuKey1(pKensakuKey1);
            aT_TyouhyouKensaku5.setKensakuKey2(pKensakuKey2);
            aT_TyouhyouKensaku5.setKensakuKey3(pKensakuKey3);
            aT_TyouhyouKensaku5.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku5.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku5);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku6 = baseDomManager.getTyouhyouKensaku(pUniqueId6);
        if ( null == aT_TyouhyouKensaku6 ) {

            aT_TyouhyouKensaku6 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku6.setSubSystemId(pSubSystemId3);
            aT_TyouhyouKensaku6.setUniqueId(pUniqueId6);
            aT_TyouhyouKensaku6.setSyoriYmd(pSyoriYmd3);
            aT_TyouhyouKensaku6.setOutCount(pOutCount3);
            aT_TyouhyouKensaku6.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku6.setPageCount(pPageCount3);
            aT_TyouhyouKensaku6.setKensakuKey1(pKensakuKey1);
            aT_TyouhyouKensaku6.setKensakuKey2(pKensakuKey2);
            aT_TyouhyouKensaku6.setKensakuKey3(pKensakuKey3);
            aT_TyouhyouKensaku6.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku6.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku6);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku7 = baseDomManager.getTyouhyouKensaku(pUniqueId7);
        if ( null == aT_TyouhyouKensaku7 ) {

            aT_TyouhyouKensaku7 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku7.setSubSystemId(pSubSystemId3);
            aT_TyouhyouKensaku7.setUniqueId(pUniqueId7);
            aT_TyouhyouKensaku7.setSyoriYmd(pSyoriYmd3);
            aT_TyouhyouKensaku7.setOutCount(pOutCount4);
            aT_TyouhyouKensaku7.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku7.setPageCount(pPageCount4);
            aT_TyouhyouKensaku7.setKensakuKey1(pKensakuKey1);
            aT_TyouhyouKensaku7.setKensakuKey2(pKensakuKey2);
            aT_TyouhyouKensaku7.setKensakuKey3(pKensakuKey3);
            aT_TyouhyouKensaku7.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku7.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku7);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku8 = baseDomManager.getTyouhyouKensaku(pUniqueId8);
        if ( null == aT_TyouhyouKensaku8 ) {

            aT_TyouhyouKensaku8 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku8.setSubSystemId(pSubSystemId3);
            aT_TyouhyouKensaku8.setUniqueId(pUniqueId8);
            aT_TyouhyouKensaku8.setSyoriYmd(pSyoriYmd3);
            aT_TyouhyouKensaku8.setOutCount(pOutCount5);
            aT_TyouhyouKensaku8.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku8.setPageCount(pPageCount4);
            aT_TyouhyouKensaku8.setKensakuKey1(pKensakuKey2);
            aT_TyouhyouKensaku8.setKensakuKey2(pKensakuKey2);
            aT_TyouhyouKensaku8.setKensakuKey3(pKensakuKey3);
            aT_TyouhyouKensaku8.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku8.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku8);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku9 = baseDomManager.getTyouhyouKensaku(pUniqueId9);
        if ( null == aT_TyouhyouKensaku9 ) {

            aT_TyouhyouKensaku9 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku9.setSubSystemId(pSubSystemId3);
            aT_TyouhyouKensaku9.setUniqueId(pUniqueId9);
            aT_TyouhyouKensaku9.setSyoriYmd(pSyoriYmd3);
            aT_TyouhyouKensaku9.setOutCount(pOutCount6);
            aT_TyouhyouKensaku9.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku9.setPageCount(pPageCount5);
            aT_TyouhyouKensaku9.setKensakuKey1(pKensakuKey3);
            aT_TyouhyouKensaku9.setKensakuKey2(pKensakuKey4);
            aT_TyouhyouKensaku9.setKensakuKey3(pKensakuKey3);
            aT_TyouhyouKensaku9.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku9.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku9);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku10 = baseDomManager.getTyouhyouKensaku(pUniqueId10);
        if ( null == aT_TyouhyouKensaku10 ) {

            aT_TyouhyouKensaku10 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku10.setSubSystemId(pSubSystemId3);
            aT_TyouhyouKensaku10.setUniqueId(pUniqueId10);
            aT_TyouhyouKensaku10.setSyoriYmd(pSyoriYmd3);
            aT_TyouhyouKensaku10.setOutCount(pOutCount7);
            aT_TyouhyouKensaku10.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku10.setPageCount(pPageCount5);
            aT_TyouhyouKensaku10.setKensakuKey1(pKensakuKey3);
            aT_TyouhyouKensaku10.setKensakuKey2(pKensakuKey1);
            aT_TyouhyouKensaku10.setKensakuKey3(pKensakuKey3);
            aT_TyouhyouKensaku10.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku10.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku10);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku11 = baseDomManager.getTyouhyouKensaku(pUniqueId11);
        if ( null == aT_TyouhyouKensaku11 ) {

            aT_TyouhyouKensaku11 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku11.setSubSystemId(pSubSystemId3);
            aT_TyouhyouKensaku11.setUniqueId(pUniqueId11);
            aT_TyouhyouKensaku11.setSyoriYmd(pSyoriYmd3);
            aT_TyouhyouKensaku11.setOutCount(pOutCount8);
            aT_TyouhyouKensaku11.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku11.setPageCount(pPageCount2);
            aT_TyouhyouKensaku11.setKensakuKey1(pKensakuKey2);
            aT_TyouhyouKensaku11.setKensakuKey2(pKensakuKey2);
            aT_TyouhyouKensaku11.setKensakuKey3(pKensakuKey1);
            aT_TyouhyouKensaku11.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku11.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku11);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku12 = baseDomManager.getTyouhyouKensaku(pUniqueId12);
        if ( null == aT_TyouhyouKensaku12 ) {

            aT_TyouhyouKensaku12 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku12.setSubSystemId(pSubSystemId3);
            aT_TyouhyouKensaku12.setUniqueId(pUniqueId12);
            aT_TyouhyouKensaku12.setSyoriYmd(pSyoriYmd3);
            aT_TyouhyouKensaku12.setOutCount(pOutCount1);
            aT_TyouhyouKensaku12.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku12.setPageCount(pPageCount2);
            aT_TyouhyouKensaku12.setKensakuKey1(pKensakuKey2);
            aT_TyouhyouKensaku12.setKensakuKey2(pKensakuKey2);
            aT_TyouhyouKensaku12.setKensakuKey3(pKensakuKey5);
            aT_TyouhyouKensaku12.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku12.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku12);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku13 = baseDomManager.getTyouhyouKensaku(pUniqueId13);
        if ( null == aT_TyouhyouKensaku13 ) {

            aT_TyouhyouKensaku13 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku13.setSubSystemId(pSubSystemId3);
            aT_TyouhyouKensaku13.setUniqueId(pUniqueId13);
            aT_TyouhyouKensaku13.setSyoriYmd(pSyoriYmd3);
            aT_TyouhyouKensaku13.setOutCount(pOutCount1);
            aT_TyouhyouKensaku13.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku13.setPageCount(pPageCount4);
            aT_TyouhyouKensaku13.setKensakuKey1(pKensakuKey1);
            aT_TyouhyouKensaku13.setKensakuKey2(pKensakuKey3);
            aT_TyouhyouKensaku13.setKensakuKey3(pKensakuKey3);
            aT_TyouhyouKensaku13.setKensakuKey4(pKensakuKey5);
            aT_TyouhyouKensaku13.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku13);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku14 = baseDomManager.getTyouhyouKensaku(pUniqueId14);
        if ( null == aT_TyouhyouKensaku14 ) {

            aT_TyouhyouKensaku14 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku14.setSubSystemId(pSubSystemId3);
            aT_TyouhyouKensaku14.setUniqueId(pUniqueId14);
            aT_TyouhyouKensaku14.setSyoriYmd(pSyoriYmd3);
            aT_TyouhyouKensaku14.setOutCount(pOutCount1);
            aT_TyouhyouKensaku14.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku14.setPageCount(pPageCount4);
            aT_TyouhyouKensaku14.setKensakuKey1(pKensakuKey1);
            aT_TyouhyouKensaku14.setKensakuKey2(pKensakuKey3);
            aT_TyouhyouKensaku14.setKensakuKey3(pKensakuKey3);
            aT_TyouhyouKensaku14.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku14.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku14);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku15 = baseDomManager.getTyouhyouKensaku(pUniqueId15);
        if ( null == aT_TyouhyouKensaku15 ) {

            aT_TyouhyouKensaku15 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku15.setSubSystemId(pSubSystemId3);
            aT_TyouhyouKensaku15.setUniqueId(pUniqueId15);
            aT_TyouhyouKensaku15.setSyoriYmd(pSyoriYmd3);
            aT_TyouhyouKensaku15.setOutCount(pOutCount1);
            aT_TyouhyouKensaku15.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku15.setPageCount(pPageCount2);
            aT_TyouhyouKensaku15.setKensakuKey1(pKensakuKey4);
            aT_TyouhyouKensaku15.setKensakuKey2(pKensakuKey1);
            aT_TyouhyouKensaku15.setKensakuKey3(pKensakuKey2);
            aT_TyouhyouKensaku15.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku15.setKensakuKey5(pKensakuKey5);

            baseDomManager.insert(aT_TyouhyouKensaku15);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku16 = baseDomManager.getTyouhyouKensaku(pUniqueId16);
        if ( null == aT_TyouhyouKensaku16 ) {

            aT_TyouhyouKensaku16 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku16.setSubSystemId(pSubSystemId3);
            aT_TyouhyouKensaku16.setUniqueId(pUniqueId16);
            aT_TyouhyouKensaku16.setSyoriYmd(pSyoriYmd3);
            aT_TyouhyouKensaku16.setOutCount(pOutCount1);
            aT_TyouhyouKensaku16.setSyoruiCd(pSyoruiCd2);
            aT_TyouhyouKensaku16.setPageCount(pPageCount2);
            aT_TyouhyouKensaku16.setKensakuKey1(pKensakuKey4);
            aT_TyouhyouKensaku16.setKensakuKey2(pKensakuKey1);
            aT_TyouhyouKensaku16.setKensakuKey3(pKensakuKey2);
            aT_TyouhyouKensaku16.setKensakuKey4(pKensakuKey4);
            aT_TyouhyouKensaku16.setKensakuKey5(pKensakuKey1);

            baseDomManager.insert(aT_TyouhyouKensaku16);
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
        String pUniqueId12 = "UNI0000012";
        String pUniqueId13 = "UNI0000013";
        String pUniqueId14 = "UNI0000014";
        String pUniqueId15 = "UNI0000015";
        String pUniqueId16 = "UNI0000016";

        AT_TyouhyouKensaku aT_TyouhyouKensaku1 = baseDomManager.getTyouhyouKensaku(pUniqueId1);
        if ( null != aT_TyouhyouKensaku1 ) {

            baseDomManager.delete(aT_TyouhyouKensaku1);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku2 = baseDomManager.getTyouhyouKensaku(pUniqueId2);
        if ( null != aT_TyouhyouKensaku2 ) {

            baseDomManager.delete(aT_TyouhyouKensaku2);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku3 = baseDomManager.getTyouhyouKensaku(pUniqueId3);
        if ( null != aT_TyouhyouKensaku3 ) {

            baseDomManager.delete(aT_TyouhyouKensaku3);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku4 = baseDomManager.getTyouhyouKensaku(pUniqueId4);
        if ( null != aT_TyouhyouKensaku4 ) {

            baseDomManager.delete(aT_TyouhyouKensaku4);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku5 = baseDomManager.getTyouhyouKensaku(pUniqueId5);
        if ( null != aT_TyouhyouKensaku5 ) {

            baseDomManager.delete(aT_TyouhyouKensaku5);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku6 = baseDomManager.getTyouhyouKensaku(pUniqueId6);
        if ( null != aT_TyouhyouKensaku6 ) {

            baseDomManager.delete(aT_TyouhyouKensaku6);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku7 = baseDomManager.getTyouhyouKensaku(pUniqueId7);
        if ( null != aT_TyouhyouKensaku7 ) {

            baseDomManager.delete(aT_TyouhyouKensaku7);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku8 = baseDomManager.getTyouhyouKensaku(pUniqueId8);
        if ( null != aT_TyouhyouKensaku8 ) {

            baseDomManager.delete(aT_TyouhyouKensaku8);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku9 = baseDomManager.getTyouhyouKensaku(pUniqueId9);
        if ( null != aT_TyouhyouKensaku9 ) {

            baseDomManager.delete(aT_TyouhyouKensaku9);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku10 = baseDomManager.getTyouhyouKensaku(pUniqueId10);
        if ( null != aT_TyouhyouKensaku10 ) {

            baseDomManager.delete(aT_TyouhyouKensaku10);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku11 = baseDomManager.getTyouhyouKensaku(pUniqueId11);
        if ( null != aT_TyouhyouKensaku11 ) {

            baseDomManager.delete(aT_TyouhyouKensaku11);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku12 = baseDomManager.getTyouhyouKensaku(pUniqueId12);
        if ( null != aT_TyouhyouKensaku12 ) {

            baseDomManager.delete(aT_TyouhyouKensaku12);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku13 = baseDomManager.getTyouhyouKensaku(pUniqueId13);
        if ( null != aT_TyouhyouKensaku13 ) {

            baseDomManager.delete(aT_TyouhyouKensaku13);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku14 = baseDomManager.getTyouhyouKensaku(pUniqueId14);
        if ( null != aT_TyouhyouKensaku14 ) {

            baseDomManager.delete(aT_TyouhyouKensaku14);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku15 = baseDomManager.getTyouhyouKensaku(pUniqueId15);
        if ( null != aT_TyouhyouKensaku15 ) {

            baseDomManager.delete(aT_TyouhyouKensaku15);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku16 = baseDomManager.getTyouhyouKensaku(pUniqueId16);
        if ( null != aT_TyouhyouKensaku16 ) {

            baseDomManager.delete(aT_TyouhyouKensaku16);
        }

        String pSubSystemId1 = "SSI0000001";
        String pSubSystemId2 = "SSI0000002";
        String pSubSystemId3 = "SSI0000003";

        AS_SubSystem aS_SubSystem1 = baseDomManager.getSubSystem(pSubSystemId1);
        if ( null != aS_SubSystem1 ) {

            baseDomManager.delete(aS_SubSystem1);
        }

        AS_SubSystem aS_SubSystem2 = baseDomManager.getSubSystem(pSubSystemId2);
        if ( null != aS_SubSystem2 ) {

            baseDomManager.delete(aS_SubSystem2);
        }

        AS_SubSystem aS_SubSystem3 = baseDomManager.getSubSystem(pSubSystemId3);
        if ( null != aS_SubSystem3 ) {

            baseDomManager.delete(aS_SubSystem3);
        }

        C_SyoruiCdKbn pSyoruiCd1 = C_SyoruiCdKbn.BLNK;
        C_SyoruiCdKbn pSyoruiCd2 = C_SyoruiCdKbn.USERITIRANHYOU;
        AM_SyoruiZokusei aM_SyoruiZokusei1 = baseDomManager.getSyoruiZokusei(pSyoruiCd1);
        if ( null != aM_SyoruiZokusei1 ) {

            baseDomManager.delete(aM_SyoruiZokusei1);
        }

        AM_SyoruiZokusei aM_SyoruiZokusei2 = baseDomManager.getSyoruiZokusei(pSyoruiCd2);
        if ( null != aM_SyoruiZokusei2 ) {

            baseDomManager.delete(aM_SyoruiZokusei2);
        }

    }

    @Test
    public void test001(){
        C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.BLNK;
        BizDate pSyoriYmd = BizDate.valueOf("20151231");
        String pOutCount = "0";
        List<AT_TyouhyouKensaku> aT_TyouhyouKensakuList = baseDomManager.getTyouhyouKensakuListBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);

        assertEquals(0, aT_TyouhyouKensakuList.size());

    }

    @Test
    public void test002(){
        C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.BLNK;
        BizDate pSyoriYmd = BizDate.valueOf("20150309");
        String pOutCount = "0";
        List<AT_TyouhyouKensaku> aT_TyouhyouKensakuList = baseDomManager.getTyouhyouKensakuListBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);

        assertEquals(1, aT_TyouhyouKensakuList.size());


    }

    @Test
    public void test003(){
        C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.USERITIRANHYOU;
        BizDate pSyoriYmd = BizDate.valueOf("20150409");
        String pOutCount = "0";
        List<AT_TyouhyouKensaku> aT_TyouhyouKensakuList = baseDomManager.getTyouhyouKensakuListBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);

        assertEquals(3, aT_TyouhyouKensakuList.size());


    }

    @Test
    public void test004(){
        C_SyoruiCdKbn pSyoruiCd = null;
        BizDate pSyoriYmd = null;
        String pOutCount = null;
        List<AT_TyouhyouKensaku> aT_TyouhyouKensakuList = baseDomManager.getTyouhyouKensakuListBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);

        assertEquals(0, aT_TyouhyouKensakuList.size());

    }

    @Test
    public void test005(){
        C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.USERITIRANHYOU;
        BizDate pSyoriYmd = BizDate.valueOf("20150509");
        String pOutCount = "3";
        List<AT_TyouhyouKensaku> aT_TyouhyouKensakuList = baseDomManager.getTyouhyouKensakuListBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);

        assertEquals(6, aT_TyouhyouKensakuList.size());

    }

    @Test
    public void test006(){
        C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.USERITIRANHYOU;
        BizDate pSyoriYmd = BizDate.valueOf("20150509");
        String pOutCount = "0";
        List<AT_TyouhyouKensaku> aT_TyouhyouKensakuList = baseDomManager.getTyouhyouKensakuListBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);

        C_SyoruiCdKbn pSyoruiCd1 = C_SyoruiCdKbn.USERITIRANHYOU;
        Integer pPageCount1 = 1;
        Integer pPageCount2 = 2;
        Integer pPageCount3 = 3;
        Integer pPageCount4 = 4;
        String pKensakuKey1 = "CK1";
        String pKensakuKey2 = "CK2";
        String pKensakuKey3 = "CK3";
        String pKensakuKey4 = "CK4";
        String pKensakuKey5 = "CK5";

        assertEquals(pSyoruiCd1, aT_TyouhyouKensakuList.get(0).getSyoruiCd());
        assertEquals(pPageCount4, aT_TyouhyouKensakuList.get(0).getPageCount());
        assertEquals(pKensakuKey3, aT_TyouhyouKensakuList.get(0).getKensakuKey1());
        assertEquals(pKensakuKey1, aT_TyouhyouKensakuList.get(0).getKensakuKey2());
        assertEquals(pKensakuKey3, aT_TyouhyouKensakuList.get(0).getKensakuKey3());
        assertEquals(pKensakuKey4, aT_TyouhyouKensakuList.get(0).getKensakuKey4());
        assertEquals(pKensakuKey5, aT_TyouhyouKensakuList.get(0).getKensakuKey5());

        assertEquals(pSyoruiCd1, aT_TyouhyouKensakuList.get(1).getSyoruiCd());
        assertEquals(pPageCount4, aT_TyouhyouKensakuList.get(1).getPageCount());
        assertEquals(pKensakuKey3, aT_TyouhyouKensakuList.get(1).getKensakuKey1());
        assertEquals(pKensakuKey4, aT_TyouhyouKensakuList.get(1).getKensakuKey2());
        assertEquals(pKensakuKey3, aT_TyouhyouKensakuList.get(1).getKensakuKey3());
        assertEquals(pKensakuKey4, aT_TyouhyouKensakuList.get(1).getKensakuKey4());
        assertEquals(pKensakuKey5, aT_TyouhyouKensakuList.get(1).getKensakuKey5());

        assertEquals(pSyoruiCd1, aT_TyouhyouKensakuList.get(2).getSyoruiCd());
        assertEquals(pPageCount3, aT_TyouhyouKensakuList.get(2).getPageCount());
        assertEquals(pKensakuKey1, aT_TyouhyouKensakuList.get(2).getKensakuKey1());
        assertEquals(pKensakuKey2, aT_TyouhyouKensakuList.get(2).getKensakuKey2());
        assertEquals(pKensakuKey3, aT_TyouhyouKensakuList.get(2).getKensakuKey3());
        assertEquals(pKensakuKey4, aT_TyouhyouKensakuList.get(2).getKensakuKey4());
        assertEquals(pKensakuKey5, aT_TyouhyouKensakuList.get(2).getKensakuKey5());

        assertEquals(pSyoruiCd1, aT_TyouhyouKensakuList.get(3).getSyoruiCd());
        assertEquals(pPageCount3, aT_TyouhyouKensakuList.get(3).getPageCount());
        assertEquals(pKensakuKey1, aT_TyouhyouKensakuList.get(3).getKensakuKey1());
        assertEquals(pKensakuKey3, aT_TyouhyouKensakuList.get(3).getKensakuKey2());
        assertEquals(pKensakuKey3, aT_TyouhyouKensakuList.get(3).getKensakuKey3());
        assertEquals(pKensakuKey4, aT_TyouhyouKensakuList.get(3).getKensakuKey4());
        assertEquals(pKensakuKey5, aT_TyouhyouKensakuList.get(3).getKensakuKey5());

        assertEquals(pSyoruiCd1, aT_TyouhyouKensakuList.get(4).getSyoruiCd());
        assertEquals(pPageCount3, aT_TyouhyouKensakuList.get(4).getPageCount());
        assertEquals(pKensakuKey1, aT_TyouhyouKensakuList.get(4).getKensakuKey1());
        assertEquals(pKensakuKey3, aT_TyouhyouKensakuList.get(4).getKensakuKey2());
        assertEquals(pKensakuKey3, aT_TyouhyouKensakuList.get(4).getKensakuKey3());
        assertEquals(pKensakuKey5, aT_TyouhyouKensakuList.get(4).getKensakuKey4());
        assertEquals(pKensakuKey5, aT_TyouhyouKensakuList.get(4).getKensakuKey5());

        assertEquals(pSyoruiCd1, aT_TyouhyouKensakuList.get(5).getSyoruiCd());
        assertEquals(pPageCount3, aT_TyouhyouKensakuList.get(5).getPageCount());
        assertEquals(pKensakuKey2, aT_TyouhyouKensakuList.get(5).getKensakuKey1());
        assertEquals(pKensakuKey2, aT_TyouhyouKensakuList.get(5).getKensakuKey2());
        assertEquals(pKensakuKey3, aT_TyouhyouKensakuList.get(5).getKensakuKey3());
        assertEquals(pKensakuKey4, aT_TyouhyouKensakuList.get(5).getKensakuKey4());
        assertEquals(pKensakuKey5, aT_TyouhyouKensakuList.get(5).getKensakuKey5());

        assertEquals(pSyoruiCd1, aT_TyouhyouKensakuList.get(6).getSyoruiCd());
        assertEquals(pPageCount2, aT_TyouhyouKensakuList.get(6).getPageCount());
        assertEquals(pKensakuKey1, aT_TyouhyouKensakuList.get(6).getKensakuKey1());
        assertEquals(pKensakuKey2, aT_TyouhyouKensakuList.get(6).getKensakuKey2());
        assertEquals(pKensakuKey3, aT_TyouhyouKensakuList.get(6).getKensakuKey3());
        assertEquals(pKensakuKey4, aT_TyouhyouKensakuList.get(6).getKensakuKey4());
        assertEquals(pKensakuKey5, aT_TyouhyouKensakuList.get(6).getKensakuKey5());

        assertEquals(pSyoruiCd1, aT_TyouhyouKensakuList.get(7).getSyoruiCd());
        assertEquals(pPageCount1, aT_TyouhyouKensakuList.get(7).getPageCount());
        assertEquals(pKensakuKey1, aT_TyouhyouKensakuList.get(7).getKensakuKey1());
        assertEquals(pKensakuKey2, aT_TyouhyouKensakuList.get(7).getKensakuKey2());
        assertEquals(pKensakuKey3, aT_TyouhyouKensakuList.get(7).getKensakuKey3());
        assertEquals(pKensakuKey4, aT_TyouhyouKensakuList.get(7).getKensakuKey4());
        assertEquals(pKensakuKey5, aT_TyouhyouKensakuList.get(7).getKensakuKey5());

        assertEquals(pSyoruiCd1, aT_TyouhyouKensakuList.get(8).getSyoruiCd());
        assertEquals(pPageCount1, aT_TyouhyouKensakuList.get(8).getPageCount());
        assertEquals(pKensakuKey2, aT_TyouhyouKensakuList.get(8).getKensakuKey1());
        assertEquals(pKensakuKey2, aT_TyouhyouKensakuList.get(8).getKensakuKey2());
        assertEquals(pKensakuKey1, aT_TyouhyouKensakuList.get(8).getKensakuKey3());
        assertEquals(pKensakuKey4, aT_TyouhyouKensakuList.get(8).getKensakuKey4());
        assertEquals(pKensakuKey5, aT_TyouhyouKensakuList.get(8).getKensakuKey5());

        assertEquals(pSyoruiCd1, aT_TyouhyouKensakuList.get(9).getSyoruiCd());
        assertEquals(pPageCount1, aT_TyouhyouKensakuList.get(9).getPageCount());
        assertEquals(pKensakuKey2, aT_TyouhyouKensakuList.get(9).getKensakuKey1());
        assertEquals(pKensakuKey2, aT_TyouhyouKensakuList.get(9).getKensakuKey2());
        assertEquals(pKensakuKey5, aT_TyouhyouKensakuList.get(9).getKensakuKey3());
        assertEquals(pKensakuKey4, aT_TyouhyouKensakuList.get(9).getKensakuKey4());
        assertEquals(pKensakuKey5, aT_TyouhyouKensakuList.get(9).getKensakuKey5());

        assertEquals(pSyoruiCd1, aT_TyouhyouKensakuList.get(10).getSyoruiCd());
        assertEquals(pPageCount1, aT_TyouhyouKensakuList.get(10).getPageCount());
        assertEquals(pKensakuKey4, aT_TyouhyouKensakuList.get(10).getKensakuKey1());
        assertEquals(pKensakuKey1, aT_TyouhyouKensakuList.get(10).getKensakuKey2());
        assertEquals(pKensakuKey2, aT_TyouhyouKensakuList.get(10).getKensakuKey3());
        assertEquals(pKensakuKey4, aT_TyouhyouKensakuList.get(10).getKensakuKey4());
        assertEquals(pKensakuKey1, aT_TyouhyouKensakuList.get(10).getKensakuKey5());

        assertEquals(pSyoruiCd1, aT_TyouhyouKensakuList.get(11).getSyoruiCd());
        assertEquals(pPageCount1, aT_TyouhyouKensakuList.get(11).getPageCount());
        assertEquals(pKensakuKey4, aT_TyouhyouKensakuList.get(11).getKensakuKey1());
        assertEquals(pKensakuKey1, aT_TyouhyouKensakuList.get(11).getKensakuKey2());
        assertEquals(pKensakuKey2, aT_TyouhyouKensakuList.get(11).getKensakuKey3());
        assertEquals(pKensakuKey4, aT_TyouhyouKensakuList.get(11).getKensakuKey4());
        assertEquals(pKensakuKey5, aT_TyouhyouKensakuList.get(11).getKensakuKey5());

    }
}
