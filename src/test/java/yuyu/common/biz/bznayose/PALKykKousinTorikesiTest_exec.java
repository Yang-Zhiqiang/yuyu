package yuyu.common.biz.bznayose;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＰＡＬ契約更新取消処理クラスのメソッド {@link PALKykKousinTorikesi#exec(C_Huho2kyknoKbn,String,String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class PALKykKousinTorikesiTest_exec {

    @Inject
    private PALKykKousinTorikesi palKykKousinTorikesi;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzTrksTjtIdouNaiyouSakujyo.class).to(BzTrksTjtIdouNaiyouSakujyoMockForSinkeiyaku.class);
                bind(BzTrksIraiMq.class).to(BzTrksIraiMqMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){

        BzTrksTjtIdouNaiyouSakujyoMockForSinkeiyaku.caller = PALKykKousinTorikesiTest_exec.class;
        BzTrksIraiMqMockForSinkeiyaku.caller = PALKykKousinTorikesiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzTrksTjtIdouNaiyouSakujyoMockForSinkeiyaku.caller = null;
        BzTrksIraiMqMockForSinkeiyaku.caller = null;
        BzTrksTjtIdouNaiyouSakujyoMockForSinkeiyaku.SYORIPTN = null;
        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = BzTrksIraiMqMockForSinkeiyaku.TESTPATTERN1;

        String huho2kykNo = "12806345672";
        String youkyuuNo = "ykno10000187654321";

        try {
            palKykKousinTorikesi.exec(C_Huho2kyknoKbn.SYONO, huho2kykNo, youkyuuNo);
        }
        catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "PAL取消依頼処理が実施不可のため、処理できませんでした。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = BzTrksIraiMqMockForSinkeiyaku.TESTPATTERN2;

        String huho2kykNo = "12806345683";
        String youkyuuNo = "ykno10000187654321";

        try {
            palKykKousinTorikesi.exec(C_Huho2kyknoKbn.SYONO, huho2kykNo, youkyuuNo);
        }
        catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "ＰＡＬの処理取消不能です。後処理があります。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = BzTrksIraiMqMockForSinkeiyaku.TESTPATTERN3;

        String huho2kykNo = "12806345694";
        String youkyuuNo = "ykno10000187654321";

        try {
            palKykKousinTorikesi.exec(C_Huho2kyknoKbn.SYONO, huho2kykNo, youkyuuNo);
        }
        catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "ＰＡＬの処理取消不能です。該当処理がありません。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = BzTrksIraiMqMockForSinkeiyaku.TESTPATTERN5;

        String huho2kykNo = "12806345688";
        String youkyuuNo = "ykno10000187654321";

        try {
            palKykKousinTorikesi.exec(C_Huho2kyknoKbn.SYONO, huho2kykNo, youkyuuNo);
        }
        catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "ＰＡＬの処理取消不能です。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = BzTrksIraiMqMockForSinkeiyaku.TESTPATTERN6;

        String huho2kykNo = "12806345677";
        String youkyuuNo = "ykno10000187654321";

        try {
            palKykKousinTorikesi.exec(C_Huho2kyknoKbn.SYONO, huho2kykNo, youkyuuNo);
        }
        catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "ＰＡＬのみ処理取消済の可能性があります。もう一度取消処理を行ってください。",
                "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = BzTrksIraiMqMockForSinkeiyaku.TESTPATTERN4;
        BzTrksTjtIdouNaiyouSakujyoMockForSinkeiyaku.SYORIPTN = BzTrksTjtIdouNaiyouSakujyoMockForSinkeiyaku.TESTPATTERN1;

        String huho2kykNo = "12806345708";
        String youkyuuNo = "ykno10000187654321";

        try {
            palKykKousinTorikesi.exec(C_Huho2kyknoKbn.SYONO, huho2kykNo, youkyuuNo);
        }
        catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "当日異動内容削除エラーのため、処理できませんでした。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_B1() {

        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = BzTrksIraiMqMockForSinkeiyaku.TESTPATTERN4;
        BzTrksTjtIdouNaiyouSakujyoMockForSinkeiyaku.SYORIPTN = BzTrksTjtIdouNaiyouSakujyoMockForSinkeiyaku.TESTPATTERN2;

        String huho2kykNo = "12806345719";
        String youkyuuNo = "ykno10000187654321";

        palKykKousinTorikesi.exec(C_Huho2kyknoKbn.SYONO, huho2kykNo, youkyuuNo);
    }
}
