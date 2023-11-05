package yuyu.common.biz.bznayose;

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
import yuyu.common.base.BaseUserInfo;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_JdTrksPalTrksZanKbn;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MqkousintrksiraiKbn;
import yuyu.def.classification.C_TorikesiKekkaKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_YoukyuuNoKanri;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 要求通番管理テーブル追加更新クラスのメソッド
 * {@link BzYoukyuuNoKanriTblTuikaKousin#exec(BzYoukyuuNoKanriTblTuikaKousinBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzYoukyuuNoKanriTblTuikaKousinTest_exec extends AbstractTest {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    AS_Kinou asKinou;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_要求通番管理テーブル追加更新";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzYoukyuuNoKanriTblTuikaKousinTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllYoukyuuNoKanri());

        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzYoukyuuNoKanriTblTuikaKousinBean bzYoukyuuNoKanriTblTuikaKousinBean = SWAKInjector
            .getInstance(BzYoukyuuNoKanriTblTuikaKousinBean.class);

        BzYoukyuuNoKanriTblTuikaKousin bzYoukyuuNoKanriTblTuikaKousin = SWAKInjector
            .getInstance(BzYoukyuuNoKanriTblTuikaKousin.class);

        bzYoukyuuNoKanriTblTuikaKousinBean.setMqkousintrksiraiKbn(C_MqkousintrksiraiKbn.MQ_KOUSIN);
        bzYoukyuuNoKanriTblTuikaKousinBean.setYoukyuuNo("1234567890abcdefgh");
        bzYoukyuuNoKanriTblTuikaKousinBean.setHuho2KykNoKbn(C_Huho2kyknoKbn.MOSNO);
        bzYoukyuuNoKanriTblTuikaKousinBean.setHuho2KykNo("780123451");
        bzYoukyuuNoKanriTblTuikaKousinBean.setMqSyorikekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
        bzYoukyuuNoKanriTblTuikaKousinBean.setAcserrcd("A001");
        bzYoukyuuNoKanriTblTuikaKousinBean.setKyknaiyouhaneiErrKbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
        bzYoukyuuNoKanriTblTuikaKousinBean.setTorikesiKekkaKbn(C_TorikesiKekkaKbn.BLNK);
        bzYoukyuuNoKanriTblTuikaKousinBean.setJdTrksPalTrksZanKbn(C_JdTrksPalTrksZanKbn.BLNK);

        asKinou.setKinouId("bzYoukyuuNoKanriTblTuikaKousin");

        AM_User aMUser = new AM_User();

        aMUser.setUserId("CNC123456");

        changeCurrentUser(baseUserInfo, aMUser);

        bzYoukyuuNoKanriTblTuikaKousin.exec(bzYoukyuuNoKanriTblTuikaKousinBean);

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getAllYoukyuuNoKanri().get(0);

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "1234567890abcdefgh", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "780123451", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "A001", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.BLNK,
            "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqtrksiraiacserrcd(), "", "（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIOK,
            "契約内容反映エラー区分");
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.BLNK, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.BLNK,
            "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "bzYoukyuuNoKanriTblTuikaKousin", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "CNC123456", "業務用更新者ID");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BzYoukyuuNoKanriTblTuikaKousinBean bzYoukyuuNoKanriTblTuikaKousinBean = SWAKInjector
            .getInstance(BzYoukyuuNoKanriTblTuikaKousinBean.class);

        BzYoukyuuNoKanriTblTuikaKousin bzYoukyuuNoKanriTblTuikaKousin = SWAKInjector
            .getInstance(BzYoukyuuNoKanriTblTuikaKousin.class);
        bzYoukyuuNoKanriTblTuikaKousinBean.setMqkousintrksiraiKbn(C_MqkousintrksiraiKbn.MQ_TRKSIRAI);
        bzYoukyuuNoKanriTblTuikaKousinBean.setYoukyuuNo("1234567890abcdefgz");
        bzYoukyuuNoKanriTblTuikaKousinBean.setHuho2KykNoKbn(C_Huho2kyknoKbn.MOSNO);
        bzYoukyuuNoKanriTblTuikaKousinBean.setHuho2KykNo("780123451");
        bzYoukyuuNoKanriTblTuikaKousinBean.setMqSyorikekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
        bzYoukyuuNoKanriTblTuikaKousinBean.setAcserrcd("A001");
        bzYoukyuuNoKanriTblTuikaKousinBean.setKyknaiyouhaneiErrKbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
        bzYoukyuuNoKanriTblTuikaKousinBean.setTorikesiKekkaKbn(C_TorikesiKekkaKbn.TORIKESIOK);
        bzYoukyuuNoKanriTblTuikaKousinBean.setJdTrksPalTrksZanKbn(C_JdTrksPalTrksZanKbn.NONE);

        asKinou.setKinouId("bzYoukyuuNoKanriTblTuikaKousin");

        AM_User aMUser = new AM_User();

        aMUser.setUserId("CNC123456");

        changeCurrentUser(baseUserInfo, aMUser);

        bzYoukyuuNoKanriTblTuikaKousin.exec(bzYoukyuuNoKanriTblTuikaKousinBean);

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("1234567890abcdefgz");
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU,
            "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqtrksiraiacserrcd(), "A001", "（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.TORIKESIOK, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.NONE,
            "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "bzYoukyuuNoKanriTblTuikaKousin", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "CNC123456", "業務用更新者ID");

    }
}
