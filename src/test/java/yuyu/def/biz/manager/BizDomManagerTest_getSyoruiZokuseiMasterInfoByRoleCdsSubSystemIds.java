package yuyu.def.biz.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.BM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.entity.BT_TyouhyouOutputKengen;
import yuyu.testinfr.TestOrder;


import jp.co.slcs.swak.core.test.SWAKTestRunner;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.result.bean.SyoruiZokuseiMasterInfoBean;

/**
 * マスタ情報取得（ロールコード、サブシステムID配列）のテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getSyoruiZokuseiMasterInfoByRoleCdsSubSystemIds {

    @Inject
    private BizDomManager bizDomManager;

    private final static String[] dRoleCd1 = {"rCd01","rCd02","rCd03"};
    private final static String[] dRoleCd2 = {"rCd04","rCd05","rCd06"};
    private final static String[] dRoleCd3 = {"rCd01","rCd05","rCd06"};
    private final static String[] dSubSystemId = {"sub05", "sub07"};

    @BeforeClass
    @Transactional
    public static void insertTestData() {


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<SyoruiZokuseiMasterInfoBean> bosyuuKihonLst = bizDomManager.getSyoruiZokuseiMasterInfoByRoleCdsSubSystemIds(dRoleCd1, dSubSystemId);
        Assert.assertEquals(0, bosyuuKihonLst.size());

        AM_SyoruiZokusei syoruiZokusei1 = new AM_SyoruiZokusei();
        syoruiZokusei1.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        syoruiZokusei1.setSyoruinm("取込用表紙");
        syoruiZokusei1.setSortNo(2);
        syoruiZokusei1.setKensakuKey1("kk11");
        syoruiZokusei1.setKensakuKey2("kk21");
        syoruiZokusei1.setKensakuKey3("kk31");
        syoruiZokusei1.setKensakuKey4("kk41");
        syoruiZokusei1.setKensakuKey5("kk51");
        bizDomManager.insert(syoruiZokusei1);

        AM_SyoruiZokusei syoruiZokusei2 = new AM_SyoruiZokusei();
        syoruiZokusei2.setSyoruiCd(C_SyoruiCdKbn.WF_QRSEAL);
        syoruiZokusei2.setSyoruinm("シール");
        syoruiZokusei2.setSortNo(1);
        syoruiZokusei2.setKensakuKey1("kk12");
        syoruiZokusei2.setKensakuKey2("kk22");
        syoruiZokusei2.setKensakuKey3("kk32");
        syoruiZokusei2.setKensakuKey4("kk42");
        syoruiZokusei2.setKensakuKey5("kk52");
        bizDomManager.insert(syoruiZokusei2);

        AM_SyoruiZokusei syoruiZokusei3 = new AM_SyoruiZokusei();
        syoruiZokusei3.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        syoruiZokusei3.setSyoruinm("給付金請求書");
        syoruiZokusei3.setSortNo(3);
        syoruiZokusei3.setKensakuKey1("kk13");
        syoruiZokusei3.setKensakuKey2("kk23");
        syoruiZokusei3.setKensakuKey3("kk33");
        syoruiZokusei3.setKensakuKey4("kk43");
        syoruiZokusei3.setKensakuKey5("kk53");
        bizDomManager.insert(syoruiZokusei3);

        AM_SyoruiZokusei syoruiZokusei4 = new AM_SyoruiZokusei();
        syoruiZokusei4.setSyoruiCd(C_SyoruiCdKbn.HK_SHMEISAI_SDS);
        syoruiZokusei4.setSyoruinm("死亡返還金請求書");
        syoruiZokusei4.setSortNo(4);
        syoruiZokusei4.setKensakuKey1("kk14");
        syoruiZokusei4.setKensakuKey2("kk24");
        syoruiZokusei4.setKensakuKey3("kk34");
        syoruiZokusei4.setKensakuKey4("kk44");
        syoruiZokusei4.setKensakuKey5("kk54");
        bizDomManager.insert(syoruiZokusei4);

        AM_SyoruiZokusei syoruiZokusei5 = new AM_SyoruiZokusei();
        syoruiZokusei5.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);
        syoruiZokusei5.setSyoruinm("死亡保険金請求書");
        syoruiZokusei5.setSortNo(5);
        syoruiZokusei5.setKensakuKey1("kk15");
        syoruiZokusei5.setKensakuKey2("kk25");
        syoruiZokusei5.setKensakuKey3("kk35");
        syoruiZokusei5.setKensakuKey4("kk45");
        syoruiZokusei5.setKensakuKey5("kk55");
        bizDomManager.insert(syoruiZokusei5);

        AM_SyoruiZokusei syoruiZokusei6 = new AM_SyoruiZokusei();
        syoruiZokusei6.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);
        syoruiZokusei6.setSyoruinm("高度障害保険金請求書");
        syoruiZokusei6.setSortNo(6);
        syoruiZokusei6.setKensakuKey1("kk16");
        syoruiZokusei6.setKensakuKey2("kk26");
        syoruiZokusei6.setKensakuKey3("kk36");
        syoruiZokusei6.setKensakuKey4("kk46");
        syoruiZokusei6.setKensakuKey5("kk56");
        bizDomManager.insert(syoruiZokusei6);

        AM_SyoruiZokusei syoruiZokusei7 = new AM_SyoruiZokusei();
        syoruiZokusei7.setSyoruiCd(C_SyoruiCdKbn.HK_SB_DAIHYOU);
        syoruiZokusei7.setSyoruinm("年金基金変更請求書兼一時金請求書（死亡）");
        syoruiZokusei7.setSortNo(7);
        syoruiZokusei7.setKensakuKey1("kk17");
        syoruiZokusei7.setKensakuKey2("kk27");
        syoruiZokusei7.setKensakuKey3("kk37");
        syoruiZokusei7.setKensakuKey4("kk47");
        syoruiZokusei7.setKensakuKey5("kk57");
        bizDomManager.insert(syoruiZokusei7);

        AM_SyoruiZokusei syoruiZokusei8 = new AM_SyoruiZokusei();
        syoruiZokusei8.setSyoruiCd(C_SyoruiCdKbn.HK_KD_JIKOJKS);
        syoruiZokusei8.setSyoruinm("年金基金変更請求書兼一時金請求書（高度障害）");
        syoruiZokusei8.setSortNo(8);
        syoruiZokusei8.setKensakuKey1("kk18");
        syoruiZokusei8.setKensakuKey2("kk28");
        syoruiZokusei8.setKensakuKey3("kk38");
        syoruiZokusei8.setKensakuKey4("kk48");
        syoruiZokusei8.setKensakuKey5("kk58");
        bizDomManager.insert(syoruiZokusei8);

        AM_SyoruiZokusei syoruiZokusei9 = new AM_SyoruiZokusei();
        syoruiZokusei9.setSyoruiCd(C_SyoruiCdKbn.HK_SB_SONOTA_SKS);
        syoruiZokusei9.setSyoruinm("その他請求書類（死亡）");
        syoruiZokusei9.setSortNo(9);
        syoruiZokusei9.setKensakuKey1("kk19");
        syoruiZokusei9.setKensakuKey2("kk29");
        syoruiZokusei9.setKensakuKey3("kk39");
        syoruiZokusei9.setKensakuKey4("kk49");
        syoruiZokusei9.setKensakuKey5("kk59");
        bizDomManager.insert(syoruiZokusei9);

        AS_SubSystem subSystem1 = new AS_SubSystem();
        subSystem1.setSubSystemId("sub01");
        subSystem1.setSubSystemNm("サブシステム０１");
        subSystem1.setSortNo(3);
        bizDomManager.insert(subSystem1);

        AS_SubSystem subSystem2 = new AS_SubSystem();
        subSystem2.setSubSystemId("sub02");
        subSystem2.setSubSystemNm("サブシステム０２");
        subSystem2.setSortNo(3);
        bizDomManager.insert(subSystem2);

        AS_SubSystem subSystem3 = new AS_SubSystem();
        subSystem3.setSubSystemId("sub03");
        subSystem3.setSubSystemNm("サブシステム０３");
        subSystem3.setSortNo(1);
        bizDomManager.insert(subSystem3);

        AS_SubSystem subSystem4 = new AS_SubSystem();
        subSystem4.setSubSystemId("sub05");
        subSystem4.setSubSystemNm("サブシステム０５");
        subSystem4.setSortNo(2);
        bizDomManager.insert(subSystem4);

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo1 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo1.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        syoruiZokuseiHukaInfo1.setSubSystemId("sub01");

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo2 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo2.setSyoruiCd(C_SyoruiCdKbn.WF_QRSEAL);
        syoruiZokuseiHukaInfo2.setSubSystemId("sub02");

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo3 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo3.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        syoruiZokuseiHukaInfo3.setSubSystemId("sub03");

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo4 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo4.setSyoruiCd(C_SyoruiCdKbn.HK_SHMEISAI_SDS);
        syoruiZokuseiHukaInfo4.setSubSystemId("sub04");

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo5 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo5.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);
        syoruiZokuseiHukaInfo5.setSubSystemId("sub05");

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo6 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo6.setSyoruiCd(C_SyoruiCdKbn.HK_KD_JIKOJKS);
        syoruiZokuseiHukaInfo6.setSubSystemId("sub03");

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo7 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo7.setSyoruiCd(C_SyoruiCdKbn.HK_SB_DAIHYOU);
        syoruiZokuseiHukaInfo7.setSubSystemId("sub03");

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo8 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo8.setSyoruiCd(C_SyoruiCdKbn.HK_SB_SONOTA_SKS);
        syoruiZokuseiHukaInfo8.setSubSystemId("sub03");

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo9 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo9.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen1 = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen1.setRoleCd("rCd01");
        tyouhyouOutputKengen1.setKobetuoutputkahikbn(C_KahiKbn.KA);
        tyouhyouOutputKengen1.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);


        BT_TyouhyouOutputKengen tyouhyouOutputKengen2 = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen2.setRoleCd("rCd02");
        tyouhyouOutputKengen2.setKobetuoutputkahikbn(C_KahiKbn.KA);
        tyouhyouOutputKengen2.setSyoruiCd(C_SyoruiCdKbn.WF_QRSEAL);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen3 = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen3.setRoleCd("rCd03");
        tyouhyouOutputKengen3.setKobetuoutputkahikbn(C_KahiKbn.KA);
        tyouhyouOutputKengen3.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen4 = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen4.setRoleCd("rCd03");
        tyouhyouOutputKengen4.setKobetuoutputkahikbn(C_KahiKbn.KA);
        tyouhyouOutputKengen4.setSyoruiCd(C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen5 = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen5.setRoleCd("rCd03");
        tyouhyouOutputKengen5.setKobetuoutputkahikbn(C_KahiKbn.KA);
        tyouhyouOutputKengen5.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen6 = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen6.setRoleCd("rCd03");
        tyouhyouOutputKengen6.setKobetuoutputkahikbn(C_KahiKbn.KA);
        tyouhyouOutputKengen6.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen7 = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen7.setRoleCd("rCd03");
        tyouhyouOutputKengen7.setKobetuoutputkahikbn(C_KahiKbn.KA);
        tyouhyouOutputKengen7.setSyoruiCd(C_SyoruiCdKbn.HK_KD_JIKOJKS);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen8 = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen8.setRoleCd("rCd08");
        tyouhyouOutputKengen8.setKobetuoutputkahikbn(C_KahiKbn.KA);
        tyouhyouOutputKengen8.setSyoruiCd(C_SyoruiCdKbn.HK_SB_DAIHYOU);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen9 = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen9.setRoleCd("rCd01");
        tyouhyouOutputKengen9.setKobetuoutputkahikbn(C_KahiKbn.HUKA);
        tyouhyouOutputKengen9.setSyoruiCd(C_SyoruiCdKbn.HK_SB_SONOTA_SKS);

        bizDomManager.insert(syoruiZokuseiHukaInfo1);
        bizDomManager.insert(syoruiZokuseiHukaInfo2);
        bizDomManager.insert(syoruiZokuseiHukaInfo3);
        bizDomManager.insert(syoruiZokuseiHukaInfo4);
        bizDomManager.insert(syoruiZokuseiHukaInfo5);
        bizDomManager.insert(syoruiZokuseiHukaInfo6);
        bizDomManager.insert(syoruiZokuseiHukaInfo7);
        bizDomManager.insert(syoruiZokuseiHukaInfo8);
        bizDomManager.insert(syoruiZokuseiHukaInfo9);

        bizDomManager.insert(tyouhyouOutputKengen1);
        bizDomManager.insert(tyouhyouOutputKengen2);
        bizDomManager.insert(tyouhyouOutputKengen3);
        bizDomManager.insert(tyouhyouOutputKengen4);
        bizDomManager.insert(tyouhyouOutputKengen5);
        bizDomManager.insert(tyouhyouOutputKengen6);
        bizDomManager.insert(tyouhyouOutputKengen7);
        bizDomManager.insert(tyouhyouOutputKengen8);
        bizDomManager.insert(tyouhyouOutputKengen9);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyoruiZokuseiHukaInfo());
        bizDomManager.delete(bizDomManager.getAllTyouhyouOutputKengen());
        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());
        baseDomManager.delete(baseDomManager.getSubSystem("sub01"));
        baseDomManager.delete(baseDomManager.getSubSystem("sub02"));
        baseDomManager.delete(baseDomManager.getSubSystem("sub03"));
        baseDomManager.delete(baseDomManager.getSubSystem("sub05"));


    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        List<SyoruiZokuseiMasterInfoBean> bosyuuKihonLst = bizDomManager.getSyoruiZokuseiMasterInfoByRoleCdsSubSystemIds(dRoleCd2, dSubSystemId);
        Assert.assertEquals(0, bosyuuKihonLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<SyoruiZokuseiMasterInfoBean> bosyuuKihonLst = bizDomManager.getSyoruiZokuseiMasterInfoByRoleCdsSubSystemIds(dRoleCd3, dSubSystemId);

        Assert.assertEquals(1, bosyuuKihonLst.size());

        Assert.assertEquals(C_SyoruiCdKbn.WF_HYOUSI, bosyuuKihonLst.get(0).getSyoruiCd());
        Assert.assertEquals("取込用表紙", bosyuuKihonLst.get(0).getSyoruinm());
        Assert.assertEquals("sub01", bosyuuKihonLst.get(0).getSubSystemId());
        Assert.assertEquals("サブシステム０１", bosyuuKihonLst.get(0).getSubSystemNm());
        Assert.assertEquals("kk11", bosyuuKihonLst.get(0).getKensakuKey1());
        Assert.assertEquals("kk21", bosyuuKihonLst.get(0).getKensakuKey2());
        Assert.assertEquals("kk31", bosyuuKihonLst.get(0).getKensakuKey3());
        Assert.assertEquals("kk41", bosyuuKihonLst.get(0).getKensakuKey4());
        Assert.assertEquals("kk51", bosyuuKihonLst.get(0).getKensakuKey5());
        Assert.assertEquals(Integer.valueOf(2), bosyuuKihonLst.get(0).getSyoruiZokuseiSortNo());
        Assert.assertEquals(Integer.valueOf(3), bosyuuKihonLst.get(0).getSubSystemSortNo());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<SyoruiZokuseiMasterInfoBean> bosyuuKihonLst = bizDomManager.getSyoruiZokuseiMasterInfoByRoleCdsSubSystemIds(dRoleCd1, dSubSystemId);
        Assert.assertEquals(4, bosyuuKihonLst.size());

        Assert.assertEquals(C_SyoruiCdKbn.HK_SHRMESS, bosyuuKihonLst.get(0).getSyoruiCd());
        Assert.assertEquals("給付金請求書", bosyuuKihonLst.get(0).getSyoruinm());
        Assert.assertEquals("sub03", bosyuuKihonLst.get(0).getSubSystemId());
        Assert.assertEquals("サブシステム０３", bosyuuKihonLst.get(0).getSubSystemNm());
        Assert.assertEquals("kk13", bosyuuKihonLst.get(0).getKensakuKey1());
        Assert.assertEquals("kk23", bosyuuKihonLst.get(0).getKensakuKey2());
        Assert.assertEquals("kk33", bosyuuKihonLst.get(0).getKensakuKey3());
        Assert.assertEquals("kk43", bosyuuKihonLst.get(0).getKensakuKey4());
        Assert.assertEquals("kk53", bosyuuKihonLst.get(0).getKensakuKey5());
        Assert.assertEquals(Integer.valueOf(3), bosyuuKihonLst.get(0).getSyoruiZokuseiSortNo());
        Assert.assertEquals(Integer.valueOf(1), bosyuuKihonLst.get(0).getSubSystemSortNo());

        Assert.assertEquals(C_SyoruiCdKbn.HK_KD_JIKOJKS, bosyuuKihonLst.get(1).getSyoruiCd());
        Assert.assertEquals("年金基金変更請求書兼一時金請求書（高度障害）", bosyuuKihonLst.get(1).getSyoruinm());
        Assert.assertEquals("sub03", bosyuuKihonLst.get(1).getSubSystemId());
        Assert.assertEquals("サブシステム０３", bosyuuKihonLst.get(1).getSubSystemNm());
        Assert.assertEquals("kk18", bosyuuKihonLst.get(1).getKensakuKey1());
        Assert.assertEquals("kk28", bosyuuKihonLst.get(1).getKensakuKey2());
        Assert.assertEquals("kk38", bosyuuKihonLst.get(1).getKensakuKey3());
        Assert.assertEquals("kk48", bosyuuKihonLst.get(1).getKensakuKey4());
        Assert.assertEquals("kk58", bosyuuKihonLst.get(1).getKensakuKey5());
        Assert.assertEquals(Integer.valueOf(8), bosyuuKihonLst.get(1).getSyoruiZokuseiSortNo());
        Assert.assertEquals(Integer.valueOf(1), bosyuuKihonLst.get(1).getSubSystemSortNo());

        Assert.assertEquals(C_SyoruiCdKbn.WF_QRSEAL, bosyuuKihonLst.get(2).getSyoruiCd());
        Assert.assertEquals("シール", bosyuuKihonLst.get(2).getSyoruinm());
        Assert.assertEquals("sub02", bosyuuKihonLst.get(2).getSubSystemId());
        Assert.assertEquals("サブシステム０２", bosyuuKihonLst.get(2).getSubSystemNm());
        Assert.assertEquals("kk12", bosyuuKihonLst.get(2).getKensakuKey1());
        Assert.assertEquals("kk22", bosyuuKihonLst.get(2).getKensakuKey2());
        Assert.assertEquals("kk32", bosyuuKihonLst.get(2).getKensakuKey3());
        Assert.assertEquals("kk42", bosyuuKihonLst.get(2).getKensakuKey4());
        Assert.assertEquals("kk52", bosyuuKihonLst.get(2).getKensakuKey5());
        Assert.assertEquals(Integer.valueOf(1), bosyuuKihonLst.get(2).getSyoruiZokuseiSortNo());
        Assert.assertEquals(Integer.valueOf(3), bosyuuKihonLst.get(2).getSubSystemSortNo());

        Assert.assertEquals(C_SyoruiCdKbn.WF_HYOUSI, bosyuuKihonLst.get(3).getSyoruiCd());
        Assert.assertEquals("取込用表紙", bosyuuKihonLst.get(3).getSyoruinm());
        Assert.assertEquals("sub01", bosyuuKihonLst.get(3).getSubSystemId());
        Assert.assertEquals("サブシステム０１", bosyuuKihonLst.get(3).getSubSystemNm());
        Assert.assertEquals("kk11", bosyuuKihonLst.get(3).getKensakuKey1());
        Assert.assertEquals("kk21", bosyuuKihonLst.get(3).getKensakuKey2());
        Assert.assertEquals("kk31", bosyuuKihonLst.get(3).getKensakuKey3());
        Assert.assertEquals("kk41", bosyuuKihonLst.get(3).getKensakuKey4());
        Assert.assertEquals("kk51", bosyuuKihonLst.get(3).getKensakuKey5());
        Assert.assertEquals(Integer.valueOf(2), bosyuuKihonLst.get(3).getSyoruiZokuseiSortNo());
        Assert.assertEquals(Integer.valueOf(3), bosyuuKihonLst.get(3).getSubSystemSortNo());


    }
}
