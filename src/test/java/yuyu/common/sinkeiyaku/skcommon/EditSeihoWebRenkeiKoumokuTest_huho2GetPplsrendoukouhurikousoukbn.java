package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_PplessrendoukouhurikousouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#huho2GetPplsrendoukouhurikousoukbn()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_huho2GetPplsrendoukouhurikousoukbn {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHuho2GetPplsrendoukouhurikousoukbn_A1(){

        String pHrkkeiro = "1";
        String pKuhrshmnttdkhyj = "1";
        C_PplessrendoukouhurikousouKbn huho2Pplsrendoukouhurikousoukbn =
            editSeihoWebRenkeiKoumoku.huho2GetPplsrendoukouhurikousoukbn(pHrkkeiro, pKuhrshmnttdkhyj);
        exClassificationEquals(huho2Pplsrendoukouhurikousoukbn, C_PplessrendoukouhurikousouKbn.ARI,
            "普保Ⅱペーパーレス連動時口振申込書後送区分");
    }

    @Test
    @TestOrder(20)
    public void testHuho2GetPplsrendoukouhurikousoukbn_A2(){

        String pHrkkeiro = "1";
        String pKuhrshmnttdkhyj = "0";
        C_PplessrendoukouhurikousouKbn huho2Pplsrendoukouhurikousoukbn =
            editSeihoWebRenkeiKoumoku.huho2GetPplsrendoukouhurikousoukbn(pHrkkeiro, pKuhrshmnttdkhyj);
        exClassificationEquals(huho2Pplsrendoukouhurikousoukbn, C_PplessrendoukouhurikousouKbn.NONE,
            "普保Ⅱペーパーレス連動時口振申込書後送区分");
    }

    @Test
    @TestOrder(30)
    public void testHuho2GetPplsrendoukouhurikousoukbn_A3(){

        String pHrkkeiro = "6";
        String pKuhrshmnttdkhyj = "1";
        C_PplessrendoukouhurikousouKbn huho2Pplsrendoukouhurikousoukbn =
            editSeihoWebRenkeiKoumoku.huho2GetPplsrendoukouhurikousoukbn(pHrkkeiro, pKuhrshmnttdkhyj);
        exClassificationEquals(huho2Pplsrendoukouhurikousoukbn, C_PplessrendoukouhurikousouKbn.OTHER,
            "普保Ⅱペーパーレス連動時口振申込書後送区分");
    }

    @Test
    @TestOrder(40)
    public void testHuho2GetPplsrendoukouhurikousoukbn_A4(){

        String pHrkkeiro = "6";
        String pKuhrshmnttdkhyj = "0";
        C_PplessrendoukouhurikousouKbn huho2Pplsrendoukouhurikousoukbn =
            editSeihoWebRenkeiKoumoku.huho2GetPplsrendoukouhurikousoukbn(pHrkkeiro, pKuhrshmnttdkhyj);
        exClassificationEquals(huho2Pplsrendoukouhurikousoukbn, C_PplessrendoukouhurikousouKbn.OTHER,
            "普保Ⅱペーパーレス連動時口振申込書後送区分");
    }
}
