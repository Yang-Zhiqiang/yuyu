package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 同時申込チェッククラスのメソッド {@link CheckDoujiMos#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDoujiMosTest_exec {

    private final static String fileName = "UT_SP_単体テスト仕様書_同時申込チェック";

    private final static String sheetName = "テストデータ";

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckDoujiMosTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        CheckDoujiMos checkDoujiMos = SWAKInjector.getInstance(CheckDoujiMos.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791111115");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("TestUser");
        mosnaiCheckParam.setKosTime("20160206111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160206"));
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        List<String> skDoujiMosMosNoLstRAY = null;
        List<String> skDoujiMosMosNoLstPAL = null;

        checkDoujiMos.exec(mosnaiCheckParam, skDoujiMosMosNoLstRAY, skDoujiMosMosNoLstPAL);

        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリストのサイズ");

        exClassificationEquals(syoriCTL.getDoujimosumu(), C_UmuKbn.NONE, "同時申込有無");
        exClassificationEquals(syoriCTL.getRaydoujimosumu(), C_UmuKbn.NONE, "ＲＡＹ同時申込有無");
        exClassificationEquals(syoriCTL.getPaldoujimosumu(), C_UmuKbn.NONE, "ＰＡＬ同時申込有無");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        CheckDoujiMos checkDoujiMos = SWAKInjector.getInstance(CheckDoujiMos.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791111123");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("TestUser");
        mosnaiCheckParam.setKosTime("20160206111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160206"));
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        List<String> skDoujiMosMosNoLstRAY = new ArrayList<>();
        List<String> skDoujiMosMosNoLstPAL = new ArrayList<>();
        skDoujiMosMosNoLstPAL.add("799900006");

        checkDoujiMos.exec(mosnaiCheckParam, skDoujiMosMosNoLstRAY, skDoujiMosMosNoLstPAL);

        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsg.get(0).getMosno(), "791111123", "申込番号");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1002", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "同時申込契約（ＰＡＬ）があります。（申込番号：７９９９００００６）", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "TestUser", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20160206111400000", "業務用更新時間");

        exClassificationEquals(syoriCTL.getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exClassificationEquals(syoriCTL.getRaydoujimosumu(), C_UmuKbn.NONE, "ＲＡＹ同時申込有無");
        exClassificationEquals(syoriCTL.getPaldoujimosumu(), C_UmuKbn.ARI, "ＰＡＬ同時申込有無");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        CheckDoujiMos checkDoujiMos = SWAKInjector.getInstance(CheckDoujiMos.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791111131");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("TestUser");
        mosnaiCheckParam.setKosTime("20160206111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160206"));
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        List<String> skDoujiMosMosNoLstRAY = new ArrayList<>();
        skDoujiMosMosNoLstRAY.add("799900014");
        List<String> skDoujiMosMosNoLstPAL = new ArrayList<>();

        checkDoujiMos.exec(mosnaiCheckParam, skDoujiMosMosNoLstRAY, skDoujiMosMosNoLstPAL);

        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsg.get(0).getMosno(), "791111131", "申込番号");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1003", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "同時申込契約（ＲＡＹ）があります。（申込番号：７９９９０００１４）", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "TestUser", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20160206111400000", "業務用更新時間");

        exClassificationEquals(syoriCTL.getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exClassificationEquals(syoriCTL.getRaydoujimosumu(), C_UmuKbn.ARI, "ＲＡＹ同時申込有無");
        exClassificationEquals(syoriCTL.getPaldoujimosumu(), C_UmuKbn.NONE, "ＰＡＬ同時申込有無");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        CheckDoujiMos checkDoujiMos = SWAKInjector.getInstance(CheckDoujiMos.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791111149");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("TestUser");
        mosnaiCheckParam.setKosTime("20160206111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160206"));
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        List<String> skDoujiMosMosNoLstRAY = new ArrayList<>();
        skDoujiMosMosNoLstRAY.add("799900022");
        skDoujiMosMosNoLstRAY.add("799900030");
        skDoujiMosMosNoLstRAY.add("799900048");
        List<String> skDoujiMosMosNoLstPAL = new ArrayList<>();
        skDoujiMosMosNoLstPAL.add("799900055");
        skDoujiMosMosNoLstPAL.add("799900063");
        skDoujiMosMosNoLstPAL.add("799900071");

        checkDoujiMos.exec(mosnaiCheckParam, skDoujiMosMosNoLstRAY, skDoujiMosMosNoLstPAL);

        syoriCTL = mosnaiCheckParam.getDataSyoriControl();

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsg.get(0).getMosno(), "791111149", "申込番号");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1003", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "同時申込契約（ＲＡＹ）があります。（申込番号：７９９９０００２２、７９９９０００３０、７９９９０００４８）", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "TestUser", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20160206111400000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "791111149", "申込番号");
        exStringEquals(hubiMsg.get(1).getMessageId(), "WHC1002", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "同時申込契約（ＰＡＬ）があります。（申込番号：７９９９０００５５、７９９９０００６３、７９９９０００７１）", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "TestUser", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20160206111400000", "業務用更新時間");

        exClassificationEquals(syoriCTL.getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exClassificationEquals(syoriCTL.getRaydoujimosumu(), C_UmuKbn.ARI, "ＲＡＹ同時申込有無");
        exClassificationEquals(syoriCTL.getPaldoujimosumu(), C_UmuKbn.ARI, "ＰＡＬ同時申込有無");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        CheckDoujiMos checkDoujiMos = SWAKInjector.getInstance(CheckDoujiMos.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860083641");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("TestUser");
        mosnaiCheckParam.setKosTime("20160206111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160206"));
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        List<String> skDoujiMosMosNoLstRAY = new ArrayList<>();
        skDoujiMosMosNoLstRAY.add("860083674");
        skDoujiMosMosNoLstRAY.add("860083682");
        skDoujiMosMosNoLstRAY.add("860083690");
        skDoujiMosMosNoLstRAY.add("860083708");
        skDoujiMosMosNoLstRAY.add("860083716");
        skDoujiMosMosNoLstRAY.add("860083724");
        skDoujiMosMosNoLstRAY.add("860083732");
        skDoujiMosMosNoLstRAY.add("860083740");
        skDoujiMosMosNoLstRAY.add("860083757");
        List<String> skDoujiMosMosNoLstPAL = new ArrayList<>();
        skDoujiMosMosNoLstPAL.add("860083765");
        skDoujiMosMosNoLstPAL.add("860083773");
        skDoujiMosMosNoLstPAL.add("860083781");
        skDoujiMosMosNoLstPAL.add("860083799");
        skDoujiMosMosNoLstPAL.add("860083807");
        skDoujiMosMosNoLstPAL.add("860083815");
        skDoujiMosMosNoLstPAL.add("860083823");
        skDoujiMosMosNoLstPAL.add("860083831");
        skDoujiMosMosNoLstPAL.add("860083849");

        checkDoujiMos.exec(mosnaiCheckParam, skDoujiMosMosNoLstRAY, skDoujiMosMosNoLstPAL);

        List<HT_HubiMsg> hubiMsgList = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgList.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgList.get(0).getMosno(), "860083641", "申込番号");
        exStringEquals(hubiMsgList.get(0).getHubimsg(), "同時申込契約（ＲＡＹ）があります。（申込番号：８６００８３６７４、８６００８３６８２、８６００８３６９０、８６００８３７０８、８６００８３７１６、８６００８３７２４、８６００８３７３２、８６００８３７４０、８６００８３７５７）", "不備メッセージ");
        exClassificationEquals(hubiMsgList.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsgList.get(0).getGyoumuKousinsyaId(), "TestUser", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgList.get(0).getGyoumuKousinTime(), "20160206111400000", "業務用更新時間");

        exStringEquals(hubiMsgList.get(1).getMosno(), "860083641", "申込番号");
        exStringEquals(hubiMsgList.get(1).getHubimsg(), "同時申込契約（ＰＡＬ）があります。（申込番号：８６００８３７６５、８６００８３７７３、８６００８３７８１、８６００８３７９９、８６００８３８０７、８６００８３８１５、８６００８３８２３、８６００８３８３１、８６００８３８４９）", "不備メッセージ");
        exClassificationEquals(hubiMsgList.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsgList.get(1).getGyoumuKousinsyaId(), "TestUser", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgList.get(1).getGyoumuKousinTime(), "20160206111400000", "業務用更新時間");

        exClassificationEquals(syoriCTL.getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exClassificationEquals(syoriCTL.getRaydoujimosumu(), C_UmuKbn.ARI, "ＲＡＹ同時申込有無");
        exClassificationEquals(syoriCTL.getPaldoujimosumu(), C_UmuKbn.ARI, "ＰＡＬ同時申込有無");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        CheckDoujiMos checkDoujiMos = SWAKInjector.getInstance(CheckDoujiMos.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860083658");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("TestUser");
        mosnaiCheckParam.setKosTime("20160206111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160206"));
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        List<String> skDoujiMosMosNoLstRAY = new ArrayList<>();
        skDoujiMosMosNoLstRAY.add("860083856");
        skDoujiMosMosNoLstRAY.add("860083864");
        skDoujiMosMosNoLstRAY.add("860083872");
        skDoujiMosMosNoLstRAY.add("860083880");
        skDoujiMosMosNoLstRAY.add("860083898");
        skDoujiMosMosNoLstRAY.add("860083906");
        skDoujiMosMosNoLstRAY.add("860083914");
        skDoujiMosMosNoLstRAY.add("860083922");
        skDoujiMosMosNoLstRAY.add("860083930");
        skDoujiMosMosNoLstRAY.add("860083948");
        List<String> skDoujiMosMosNoLstPAL = new ArrayList<>();
        skDoujiMosMosNoLstPAL.add("860083955");
        skDoujiMosMosNoLstPAL.add("860083963");
        skDoujiMosMosNoLstPAL.add("860083971");
        skDoujiMosMosNoLstPAL.add("860083989");
        skDoujiMosMosNoLstPAL.add("860083997");
        skDoujiMosMosNoLstPAL.add("860084003");
        skDoujiMosMosNoLstPAL.add("860084011");
        skDoujiMosMosNoLstPAL.add("860084029");
        skDoujiMosMosNoLstPAL.add("860084037");
        skDoujiMosMosNoLstPAL.add("860084045");

        checkDoujiMos.exec(mosnaiCheckParam, skDoujiMosMosNoLstRAY, skDoujiMosMosNoLstPAL);

        List<HT_HubiMsg> hubiMsgList = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgList.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgList.get(0).getMosno(), "860083658", "申込番号");
        exStringEquals(hubiMsgList.get(0).getHubimsg(), "同時申込契約（ＲＡＹ）があります。（申込番号：８６００８３８５６、８６００８３８６４、８６００８３８７２、８６００８３８８０、８６００８３８９８、８６００８３９０６、８６００８３９１４、８６００８３９２２、８６００８３９３０、８６００８３９４８）", "不備メッセージ");
        exClassificationEquals(hubiMsgList.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsgList.get(0).getGyoumuKousinsyaId(), "TestUser", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgList.get(0).getGyoumuKousinTime(), "20160206111400000", "業務用更新時間");

        exStringEquals(hubiMsgList.get(1).getMosno(), "860083658", "申込番号");
        exStringEquals(hubiMsgList.get(1).getHubimsg(), "同時申込契約（ＰＡＬ）があります。（申込番号：８６００８３９５５、８６００８３９６３、８６００８３９７１、８６００８３９８９、８６００８３９９７、８６００８４００３、８６００８４０１１、８６００８４０２９、８６００８４０３７、８６００８４０４５）", "不備メッセージ");
        exClassificationEquals(hubiMsgList.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsgList.get(1).getGyoumuKousinsyaId(), "TestUser", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgList.get(1).getGyoumuKousinTime(), "20160206111400000", "業務用更新時間");

        exClassificationEquals(syoriCTL.getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exClassificationEquals(syoriCTL.getRaydoujimosumu(), C_UmuKbn.ARI, "ＲＡＹ同時申込有無");
        exClassificationEquals(syoriCTL.getPaldoujimosumu(), C_UmuKbn.ARI, "ＰＡＬ同時申込有無");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        CheckDoujiMos checkDoujiMos = SWAKInjector.getInstance(CheckDoujiMos.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860083666");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("TestUser");
        mosnaiCheckParam.setKosTime("20160206111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160206"));
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        List<String> skDoujiMosMosNoLstRAY = new ArrayList<>();
        skDoujiMosMosNoLstRAY.add("860084052");
        skDoujiMosMosNoLstRAY.add("860084060");
        skDoujiMosMosNoLstRAY.add("860084078");
        skDoujiMosMosNoLstRAY.add("860084086");
        skDoujiMosMosNoLstRAY.add("860084094");
        skDoujiMosMosNoLstRAY.add("860084102");
        skDoujiMosMosNoLstRAY.add("860084110");
        skDoujiMosMosNoLstRAY.add("860084128");
        skDoujiMosMosNoLstRAY.add("860084136");
        skDoujiMosMosNoLstRAY.add("860084144");
        skDoujiMosMosNoLstRAY.add("860084151");
        List<String> skDoujiMosMosNoLstPAL = new ArrayList<>();
        skDoujiMosMosNoLstPAL.add("860084169");
        skDoujiMosMosNoLstPAL.add("860084177");
        skDoujiMosMosNoLstPAL.add("860084185");
        skDoujiMosMosNoLstPAL.add("860084193");
        skDoujiMosMosNoLstPAL.add("860084201");
        skDoujiMosMosNoLstPAL.add("860084219");
        skDoujiMosMosNoLstPAL.add("860084227");
        skDoujiMosMosNoLstPAL.add("860084235");
        skDoujiMosMosNoLstPAL.add("860084243");
        skDoujiMosMosNoLstPAL.add("860084250");
        skDoujiMosMosNoLstPAL.add("860084268");

        checkDoujiMos.exec(mosnaiCheckParam, skDoujiMosMosNoLstRAY, skDoujiMosMosNoLstPAL);

        List<HT_HubiMsg> hubiMsgList = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgList.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgList.get(0).getMosno(), "860083666", "申込番号");
        exStringEquals(hubiMsgList.get(0).getHubimsg(), "同時申込契約（ＲＡＹ）があります。（申込番号：８６００８４０５２、８６００８４０６０、８６００８４０７８、８６００８４０８６、８６００８４０９４、８６００８４１０２、８６００８４１１０、８６００８４１２８、８６００８４１３６、８６００８４１４４）", "不備メッセージ");
        exClassificationEquals(hubiMsgList.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsgList.get(0).getGyoumuKousinsyaId(), "TestUser", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgList.get(0).getGyoumuKousinTime(), "20160206111400000", "業務用更新時間");

        exStringEquals(hubiMsgList.get(1).getMosno(), "860083666", "申込番号");
        exStringEquals(hubiMsgList.get(1).getHubimsg(), "同時申込契約（ＰＡＬ）があります。（申込番号：８６００８４１６９、８６００８４１７７、８６００８４１８５、８６００８４１９３、８６００８４２０１、８６００８４２１９、８６００８４２２７、８６００８４２３５、８６００８４２４３、８６００８４２５０）", "不備メッセージ");
        exClassificationEquals(hubiMsgList.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsgList.get(1).getGyoumuKousinsyaId(), "TestUser", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgList.get(1).getGyoumuKousinTime(), "20160206111400000", "業務用更新時間");

        exClassificationEquals(syoriCTL.getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exClassificationEquals(syoriCTL.getRaydoujimosumu(), C_UmuKbn.ARI, "ＲＡＹ同時申込有無");
        exClassificationEquals(syoriCTL.getPaldoujimosumu(), C_UmuKbn.ARI, "ＰＡＬ同時申込有無");
    }
}