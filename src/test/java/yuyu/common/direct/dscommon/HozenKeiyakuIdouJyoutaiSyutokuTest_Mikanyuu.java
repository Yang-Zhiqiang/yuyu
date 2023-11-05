package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMock;
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukshantkekKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保全契約異動状態取得のメソッド
 * {@link HozenKeiyakuIdouJyoutaiSyutoku#hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class HozenKeiyakuIdouJyoutaiSyutokuTest_Mikanyuu {

    @Inject
    private HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku;

    @BeforeClass
    @Transactional
    public static void testInit() {

        HozenKeiyakuIdouJyoutaiSyutokuMock.caller = HozenKeiyakuIdouJyoutaiSyutokuTest_Mikanyuu.class;
        BzGetProcessSummaryMock.caller = HozenKeiyakuIdouJyoutaiSyutokuTest_Mikanyuu.class;
        IwfKouteiClientMock.caller = "Test";
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        IT_KykKihon kykKihon2 = new IT_KykKihon("05", "17806000057");

        sinkeiyakuDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("06", "17806000068");

        IT_KykSya kykSya1 = kykKihon3.createKykSya();
        kykSya1.setKyknmkn("ア");
        kykSya1.setKyknmkj("李");
        kykSya1.setKykseiymd(BizDate.valueOf(19800101));
        kykSya1.setTsinyno("1100001");

        sinkeiyakuDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("07", "17806000079");

        IT_KykSya kykSya2 = kykKihon4.createKykSya();
        kykSya2.setKyknmkn("カ");
        kykSya2.setKyknmkj("王");
        kykSya2.setKykseiymd(BizDate.valueOf(19800101));
        kykSya2.setTsinyno("1100001");

        sinkeiyakuDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("08", "17806000080");

        IT_KykSya kykSya3 = kykKihon5.createKykSya();
        kykSya3.setKyknmkn("ア");
        kykSya3.setKyknmkj("王");
        kykSya3.setKykseiymd(BizDate.valueOf(19801111));
        kykSya3.setTsinyno("1100001");

        sinkeiyakuDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("09", "17806000091");

        IT_KykSya kykSya4 = kykKihon6.createKykSya();
        kykSya4.setKyknmkn("ア");
        kykSya4.setKyknmkj("王");
        kykSya4.setKykseiymd(BizDate.valueOf(19800101));
        kykSya4.setTsinyno("1010100");

        sinkeiyakuDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("00", "17806000105");

        IT_KykSya kykSya5 = kykKihon7.createKykSya();
        kykSya5.setKyknmkn("ア");
        kykSya5.setKyknmkj("王");
        kykSya5.setKykseiymd(BizDate.valueOf(19800101));
        kykSya5.setTsinyno("1100001");

        sinkeiyakuDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("01", "17806000116");

        IT_KykSya kykSya6 = kykKihon8.createKykSya();
        kykSya6.setKyknmkn("ア");
        kykSya6.setKyknmkj("王");
        kykSya6.setKykseiymd(BizDate.valueOf(19800101));
        kykSya6.setTsinyno("1100001");

        sinkeiyakuDomManager.insert(kykKihon8);

        IT_KykKihon kykKihon9 = new IT_KykKihon("02", "17806000127");

        IT_KykSya kykSya7 = kykKihon9.createKykSya();
        kykSya7.setKyknmkn("ア");
        kykSya7.setKyknmkj("王");
        kykSya7.setKykseiymd(BizDate.valueOf(19800101));
        kykSya7.setTsinyno("1100001");

        sinkeiyakuDomManager.insert(kykKihon9);

        IT_KykKihon kykKihon10 = new IT_KykKihon("03", "17806000138");

        IT_KykSya kykSya8 = kykKihon10.createKykSya();
        kykSya8.setKyknmkn("ア");
        kykSya8.setKyknmkj("王");
        kykSya8.setKykseiymd(BizDate.valueOf(19800101));
        kykSya8.setTsinyno("1100001");

        sinkeiyakuDomManager.insert(kykKihon10);

        IT_KykKihon kykKihon11 = new IT_KykKihon("04", "17806000149");

        IT_KykSya kykSya9 = kykKihon11.createKykSya();
        kykSya9.setKyknmkn("ア");
        kykSya9.setKyknmkj("王");
        kykSya9.setKykseiymd(BizDate.valueOf(19800101));
        kykSya9.setTsinyno("1100001");

        sinkeiyakuDomManager.insert(kykKihon11);

        IT_KykKihon kykKihon12 = new IT_KykKihon("05", "17806000150");

        IT_KykSya kykSya10 = kykKihon12.createKykSya();
        kykSya10.setKyknmkn("ア");
        kykSya10.setKyknmkj("王");
        kykSya10.setKykseiymd(BizDate.valueOf(19800101));
        kykSya10.setTsinyno("1100001");

        sinkeiyakuDomManager.insert(kykKihon12);

        IT_KykKihon kykKihon13 = new IT_KykKihon("06", "17806000161");

        IT_KykSya kykSya11 = kykKihon13.createKykSya();
        kykSya11.setKyknmkn("ア");
        kykSya11.setKyknmkj("王");
        kykSya11.setKykseiymd(BizDate.valueOf(19800101));
        kykSya11.setTsinyno("1100001");

        sinkeiyakuDomManager.insert(kykKihon13);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("1000000001");
        dsKokyakuKanri1.setDskokyakunmkn("ア");
        dsKokyakuKanri1.setDskokyakunmkj("王");
        dsKokyakuKanri1.setDskokyakuseiymd(BizDate.valueOf(19800101));
        dsKokyakuKanri1.setDskokyakuyno("1100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setSyono("17806000046");
        dsKokyakuKeiyaku1.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        sinkeiyakuDomManager.insert(dsKokyakuKanri1);

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri("1000000002");
        dsKokyakuKanri2.setDskokyakunmkn("ア");
        dsKokyakuKanri2.setDskokyakunmkj("王");
        dsKokyakuKanri2.setDskokyakuseiymd(BizDate.valueOf(19800101));
        dsKokyakuKanri2.setDskokyakuyno("1100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku2 = dsKokyakuKanri2.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku2.setSyono("17806000057");
        dsKokyakuKeiyaku2.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        sinkeiyakuDomManager.insert(dsKokyakuKanri2);

        MT_DsKokyakuKanri dsKokyakuKanri3 = new MT_DsKokyakuKanri("1000000003");
        dsKokyakuKanri3.setDskokyakunmkn("ア");
        dsKokyakuKanri3.setDskokyakunmkj("王");
        dsKokyakuKanri3.setDskokyakuseiymd(BizDate.valueOf(19800101));
        dsKokyakuKanri3.setDskokyakuyno("1100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku3 = dsKokyakuKanri3.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku3.setSyono("17806000068");
        dsKokyakuKeiyaku3.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        sinkeiyakuDomManager.insert(dsKokyakuKanri3);

        MT_DsKokyakuKanri dsKokyakuKanri4 = new MT_DsKokyakuKanri("1000000004");
        dsKokyakuKanri4.setDskokyakunmkn("ア");
        dsKokyakuKanri4.setDskokyakunmkj("王");
        dsKokyakuKanri4.setDskokyakuseiymd(BizDate.valueOf(19800101));
        dsKokyakuKanri4.setDskokyakuyno("1100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku4 = dsKokyakuKanri4.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku4.setSyono("17806000079");
        dsKokyakuKeiyaku4.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        sinkeiyakuDomManager.insert(dsKokyakuKanri4);

        MT_DsKokyakuKanri dsKokyakuKanri5 = new MT_DsKokyakuKanri("1000000005");
        dsKokyakuKanri5.setDskokyakunmkn("ア");
        dsKokyakuKanri5.setDskokyakunmkj("王");
        dsKokyakuKanri5.setDskokyakuseiymd(BizDate.valueOf(19800101));
        dsKokyakuKanri5.setDskokyakuyno("1100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku5 = dsKokyakuKanri5.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku5.setSyono("17806000080");
        dsKokyakuKeiyaku5.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        sinkeiyakuDomManager.insert(dsKokyakuKanri5);

        MT_DsKokyakuKanri dsKokyakuKanri6 = new MT_DsKokyakuKanri("1000000006");
        dsKokyakuKanri6.setDskokyakunmkn("ア");
        dsKokyakuKanri6.setDskokyakunmkj("王");
        dsKokyakuKanri6.setDskokyakuseiymd(BizDate.valueOf(19800101));
        dsKokyakuKanri6.setDskokyakuyno("1100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku6 = dsKokyakuKanri6.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku6.setSyono("17806000091");
        dsKokyakuKeiyaku6.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        sinkeiyakuDomManager.insert(dsKokyakuKanri6);

        MT_DsKokyakuKanri dsKokyakuKanri7 = new MT_DsKokyakuKanri("1000000007");
        dsKokyakuKanri7.setDskokyakunmkn("ア");
        dsKokyakuKanri7.setDskokyakunmkj("王");
        dsKokyakuKanri7.setDskokyakuseiymd(BizDate.valueOf(19800101));
        dsKokyakuKanri7.setDskokyakuyno("1100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku7 = dsKokyakuKanri7.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku7.setSyono("17806000105");
        dsKokyakuKeiyaku7.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        sinkeiyakuDomManager.insert(dsKokyakuKanri7);

        MT_DsKokyakuKanri dsKokyakuKanri8 = new MT_DsKokyakuKanri("1000000008");
        dsKokyakuKanri8.setDskokyakunmkn("ア");
        dsKokyakuKanri8.setDskokyakunmkj("王");
        dsKokyakuKanri8.setDskokyakuseiymd(BizDate.valueOf(19800101));
        dsKokyakuKanri8.setDskokyakuyno("1100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku8 = dsKokyakuKanri8.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku8.setSyono("17806000116");
        dsKokyakuKeiyaku8.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        sinkeiyakuDomManager.insert(dsKokyakuKanri8);

        MT_DsKokyakuKanri dsKokyakuKanri9 = new MT_DsKokyakuKanri("1000000009");
        dsKokyakuKanri9.setDskokyakunmkn("ア");
        dsKokyakuKanri9.setDskokyakunmkj("王");
        dsKokyakuKanri9.setDskokyakuseiymd(BizDate.valueOf(19800101));
        dsKokyakuKanri9.setDskokyakuyno("1100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku9 = dsKokyakuKanri9.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku9.setSyono("17806000127");
        dsKokyakuKeiyaku9.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        sinkeiyakuDomManager.insert(dsKokyakuKanri9);

        MT_DsKokyakuKanri dsKokyakuKanri10 = new MT_DsKokyakuKanri("1000000010");
        dsKokyakuKanri10.setDskokyakunmkn("ア");
        dsKokyakuKanri10.setDskokyakunmkj("王");
        dsKokyakuKanri10.setDskokyakuseiymd(BizDate.valueOf(19800101));
        dsKokyakuKanri10.setDskokyakuyno("1100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku10 = dsKokyakuKanri10.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku10.setSyono("17806000138");
        dsKokyakuKeiyaku10.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        sinkeiyakuDomManager.insert(dsKokyakuKanri10);

        MT_DsKokyakuKanri dsKokyakuKanri11 = new MT_DsKokyakuKanri("1000000011");
        dsKokyakuKanri11.setDskokyakunmkn("ア");
        dsKokyakuKanri11.setDskokyakunmkj("王");
        dsKokyakuKanri11.setDskokyakuseiymd(BizDate.valueOf(19800101));
        dsKokyakuKanri11.setDskokyakuyno("1100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku11 = dsKokyakuKanri11.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku11.setSyono("17806000149");
        dsKokyakuKeiyaku11.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        sinkeiyakuDomManager.insert(dsKokyakuKanri11);

        MT_DsKokyakuKanri dsKokyakuKanri12 = new MT_DsKokyakuKanri("1000000012");
        dsKokyakuKanri12.setDskokyakunmkn("ア");
        dsKokyakuKanri12.setDskokyakunmkj("王");
        dsKokyakuKanri12.setDskokyakuseiymd(BizDate.valueOf(19800101));
        dsKokyakuKanri12.setDskokyakuyno("1100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku12 = dsKokyakuKanri12.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku12.setSyono("17806000150");
        dsKokyakuKeiyaku12.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        sinkeiyakuDomManager.insert(dsKokyakuKanri12);

        MT_DsKokyakuKanri dsKokyakuKanri13 = new MT_DsKokyakuKanri("1000000013");
        dsKokyakuKanri13.setDskokyakunmkn("ア");
        dsKokyakuKanri13.setDskokyakunmkj("王");
        dsKokyakuKanri13.setDskokyakuseiymd(BizDate.valueOf(19800101));
        dsKokyakuKanri13.setDskokyakuyno("1100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku13 = dsKokyakuKanri13.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku13.setSyono("17806000161");
        dsKokyakuKeiyaku13.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        sinkeiyakuDomManager.insert(dsKokyakuKanri13);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhMeigiHenkouWk());

        hozenDomManager.delete(hozenDomManager.getAllKhJyuusyoHenkouWk());

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A1() {
        HozenKeiyakuIdouJyoutaiSyutokuMock.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMock.TESTPATTERN2;

        String pSyoNo = "11111111111";

        HozenKeiyakuIdouJyoutaiSyutokuBean  idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);

        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();
        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.ERROR, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.ERROR, "異動中区分");

        String syoNo = (String)MockObjectManager.
            getArgument(HozenKeiyakuIdouJyoutaiSyutoku.class, "keiyakuJyoutaiYuukouseiHantei", 0, 0);

        exStringEquals(syoNo, "11111111111", "証券番号");
    }

    @Test
    @TestOrder(20)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A2() {

        HozenKeiyakuIdouJyoutaiSyutokuMock.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMock.TESTPATTERN3;
        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN1;
        IwfKouteiClientMock.mode="01-05";

        String pSyoNo = "17806000013";

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);

        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();
        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(),
            IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0],
            C_Kouteikanristatus.SYORITYUU, " (配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getSyoNo(), "17806000013", "証券番号");
        exStringEquals(bzGetProcessSummaryInBean.getSubSystemId(),
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "サブシステムID");
    }

    @Test
    @TestOrder(30)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A3() {
        MockObjectManager.initialize();

        HozenKeiyakuIdouJyoutaiSyutokuMock.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMock.TESTPATTERN3;
        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN6;
        IwfKouteiClientMock.mode="01-05";

        String pSyoNo = "17806000024";

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);

        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();
        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUNASHI, "異動中区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 =
            (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(),
            IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0],
            C_Kouteikanristatus.SYORITYUU, " (配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getSyoNo(), "17806000024", "証券番号");
        exStringEquals(bzGetProcessSummaryInBean2.getSubSystemId(),
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "サブシステムID");
    }


    @Test
    @TestOrder(40)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A4() {

        HozenKeiyakuIdouJyoutaiSyutokuMock.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMock.TESTPATTERN3;
        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN7;
        IwfKouteiClientMock.mode="01-05";
        String pSyoNo = "17806000035";

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);
        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN7;
        IwfKouteiClientMock.mode="01-05";

        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();
        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUNASHI, "異動中区分");
    }

    @Test
    @TestOrder(50)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A5() {
        HozenKeiyakuIdouJyoutaiSyutokuMock.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMock.TESTPATTERN3;

        String pSyoNo = "17806000046";

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);

        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();
        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.ERROR, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.ERROR, "異動中区分");
    }


    @Test
    @TestOrder(60)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A6() {
        HozenKeiyakuIdouJyoutaiSyutokuMock.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMock.TESTPATTERN3;

        String pSyoNo = "17806000057";

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);

        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();
        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.ERROR, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.ERROR, "異動中区分");
    }

    @Test
    @TestOrder(70)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A7() {
        HozenKeiyakuIdouJyoutaiSyutokuMock.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMock.TESTPATTERN3;

        String pSyoNo = "17806000068";

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);

        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();
        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
    }

    @Test
    @TestOrder(80)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A8() {
        HozenKeiyakuIdouJyoutaiSyutokuMock.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMock.TESTPATTERN3;

        String pSyoNo = "17806000079";

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);

        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();
        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
    }

    @Test
    @TestOrder(90)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A9() {
        HozenKeiyakuIdouJyoutaiSyutokuMock.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMock.TESTPATTERN3;

        String pSyoNo = "17806000080";

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);

        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();
        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
    }

    @Test
    @TestOrder(100)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A10() {
        HozenKeiyakuIdouJyoutaiSyutokuMock.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMock.TESTPATTERN3;

        String pSyoNo = "17806000091";

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);

        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();
        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
    }

    @Test
    @TestOrder(110)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A11() {
        HozenKeiyakuIdouJyoutaiSyutokuMock.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMock.TESTPATTERN3;
        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN1;
        IwfKouteiClientMock.mode="01-05";

        String pSyoNo = "17806000105";

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);

        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();
        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();
        C_UmuKbn meigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn();
        C_UmuKbn juushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getJuushoHenkouUmuKbn();
        C_UmuKbn srMeigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrMeigiHenkouUmuKbn();
        C_UmuKbn srJuushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrJuushoHenkouUmuKbn();
        C_UmuKbn yotenSouiUmuKbn = idouJyoutaiSyutokuBean.getYotenSouiUmuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
        exClassificationEquals(meigiHenkouUmuKbn, C_UmuKbn.NONE, "名義変更有無区分");
        exClassificationEquals(juushoHenkouUmuKbn, C_UmuKbn.NONE, "住所変更有無区");
        exClassificationEquals(srMeigiHenkouUmuKbn, C_UmuKbn.ARI, "処理中名義変更有無区分");
        exClassificationEquals(srJuushoHenkouUmuKbn, C_UmuKbn.ARI, "処理中住所変更有無区分");
        exClassificationEquals(yotenSouiUmuKbn, C_UmuKbn.ARI, "四点相違有無区分");
    }

    @Test
    @TestOrder(120)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A12() {
        HozenKeiyakuIdouJyoutaiSyutokuMock.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMock.TESTPATTERN3;
        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN2;
        IwfKouteiClientMock.mode="01-05";

        String pSyoNo = "17806000116";

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);

        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();
        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();
        C_UmuKbn meigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn();
        C_UmuKbn juushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getJuushoHenkouUmuKbn();
        C_UmuKbn srMeigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrMeigiHenkouUmuKbn();
        C_UmuKbn srJuushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrJuushoHenkouUmuKbn();
        C_UmuKbn yotenSouiUmuKbn = idouJyoutaiSyutokuBean.getYotenSouiUmuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUNASHI, "異動中区分");
        exClassificationEquals(meigiHenkouUmuKbn, C_UmuKbn.NONE, "名義変更有無区分");
        exClassificationEquals(juushoHenkouUmuKbn, C_UmuKbn.NONE, "住所変更有無区");
        exClassificationEquals(srMeigiHenkouUmuKbn, C_UmuKbn.NONE, "処理中名義変更有無区分");
        exClassificationEquals(srJuushoHenkouUmuKbn, C_UmuKbn.NONE, "処理中住所変更有無区分");
        exClassificationEquals(yotenSouiUmuKbn, C_UmuKbn.NONE, "四点相違有無区分");
    }

    @Test
    @TestOrder(130)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A13() {
        HozenKeiyakuIdouJyoutaiSyutokuMock.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMock.TESTPATTERN3;
        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN3;
        IwfKouteiClientMock.mode="01-05";

        String pSyoNo = "17806000127";

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);

        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();
        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();
        C_UmuKbn meigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn();
        C_UmuKbn juushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getJuushoHenkouUmuKbn();
        C_UmuKbn srMeigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrMeigiHenkouUmuKbn();
        C_UmuKbn srJuushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrJuushoHenkouUmuKbn();
        C_UmuKbn yotenSouiUmuKbn = idouJyoutaiSyutokuBean.getYotenSouiUmuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUNASHI, "異動中区分");
        exClassificationEquals(meigiHenkouUmuKbn, C_UmuKbn.NONE, "名義変更有無区分");
        exClassificationEquals(juushoHenkouUmuKbn, C_UmuKbn.NONE, "住所変更有無区");
        exClassificationEquals(srMeigiHenkouUmuKbn, C_UmuKbn.NONE, "処理中名義変更有無区分");
        exClassificationEquals(srJuushoHenkouUmuKbn, C_UmuKbn.NONE, "処理中住所変更有無区分");
        exClassificationEquals(yotenSouiUmuKbn, C_UmuKbn.NONE, "四点相違有無区分");
    }

    @Test
    @TestOrder(140)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A14() {

        MockObjectManager.initialize();

        HozenKeiyakuIdouJyoutaiSyutokuMock.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMock.TESTPATTERN3;
        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN4;
        IwfKouteiClientMock.mode="01-05";

        String pSyoNo = "17806000024";

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);

        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();
        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 =
            (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(),
            IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0],
            C_Kouteikanristatus.SYORITYUU, " (配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getSyoNo(), "17806000024", "証券番号");
        exStringEquals(bzGetProcessSummaryInBean2.getSubSystemId(),
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "サブシステムID");
    }
}