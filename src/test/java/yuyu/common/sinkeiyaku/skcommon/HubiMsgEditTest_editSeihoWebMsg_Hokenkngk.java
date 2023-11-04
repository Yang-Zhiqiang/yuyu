package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備メッセージ編集クラスのメソッド {@link HubiMsgEdit#editSeihoWebMsg_Hokenkngk(MosnaiCheckParam,HT_MosKihon,BM_SyouhnZokusei)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class HubiMsgEditTest_editSeihoWebMsg_Hokenkngk {

    private final static String fileName = "UT_SP_単体テスト仕様書_不備メッセージ編集";

    private final static String sheetName = "INデータ";

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HubiMsgEditTest_editSeihoWebMsg_Hokenkngk.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
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
    @TestOrder(10)
    public void testEditSeihoWebMsg_Hokenkngk1() {

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("5200015");
        mosnaiCheckParam.setSekmossakuseiHrksknnyrykUmuKbn(C_UmuKbn.NONE);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112238");
        HT_MosKihon mosKihon =  syoriCTL.getMosKihon();
        mosKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｳ", 1);

        String resultMsg = hubiMsgEdit.editSeihoWebMsg_Hokenkngk(mosnaiCheckParam, mosKihon, syouhnZokusei);

        exStringEquals(resultMsg, "保険金額", "編集後文字列");
    }
}
