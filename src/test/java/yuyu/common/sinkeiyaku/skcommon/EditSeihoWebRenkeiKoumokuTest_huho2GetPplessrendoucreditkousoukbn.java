package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_PplessrendoucreditkousouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#huho2GetPplessrendoucreditkousoukbn()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_huho2GetPplessrendoucreditkousoukbn {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHuho2GetPplessrendoucreditkousoukbn_A1(){

        String pHrkkeiro = "7";
        String pKuhrshmnttdkhyj = "1";
        C_PplessrendoucreditkousouKbn huho2PplessrendoucreditkousouKbn =
            editSeihoWebRenkeiKoumoku.huho2GetPplessrendoucreditkousoukbn(pHrkkeiro, pKuhrshmnttdkhyj);
        exClassificationEquals(huho2PplessrendoucreditkousouKbn, C_PplessrendoucreditkousouKbn.ARI,
            "普保Ⅱペーパーレス連動時クレカ申込書後送区分");
    }

    @Test
    @TestOrder(20)
    public void testHuho2GetPplessrendoucreditkousoukbn_A2(){

        String pHrkkeiro = "7";
        String pKuhrshmnttdkhyj = "0";
        C_PplessrendoucreditkousouKbn huho2PplessrendoucreditkousouKbn =
            editSeihoWebRenkeiKoumoku.huho2GetPplessrendoucreditkousoukbn(pHrkkeiro, pKuhrshmnttdkhyj);
        exClassificationEquals(huho2PplessrendoucreditkousouKbn, C_PplessrendoucreditkousouKbn.NONE,
            "普保Ⅱペーパーレス連動時クレカ申込書後送区分");
    }

    @Test
    @TestOrder(30)
    public void testHuho2GetPplessrendoucreditkousoukbn_A3(){

        String pHrkkeiro = "6";
        String pKuhrshmnttdkhyj = "1";
        C_PplessrendoucreditkousouKbn huho2PplessrendoucreditkousouKbn =
            editSeihoWebRenkeiKoumoku.huho2GetPplessrendoucreditkousoukbn(pHrkkeiro, pKuhrshmnttdkhyj);
        exClassificationEquals(huho2PplessrendoucreditkousouKbn, C_PplessrendoucreditkousouKbn.OTHER,
            "普保Ⅱペーパーレス連動時クレカ申込書後送区分");
    }

    @Test
    @TestOrder(40)
    public void testHuho2GetPplessrendoucreditkousoukbn_A4(){

        String pHrkkeiro = "6";
        String pKuhrshmnttdkhyj = "0";
        C_PplessrendoucreditkousouKbn huho2PplessrendoucreditkousouKbn =
            editSeihoWebRenkeiKoumoku.huho2GetPplessrendoucreditkousoukbn(pHrkkeiro, pKuhrshmnttdkhyj);
        exClassificationEquals(huho2PplessrendoucreditkousouKbn, C_PplessrendoucreditkousouKbn.OTHER,
            "普保Ⅱペーパーレス連動時クレカ申込書後送区分");
    }
}
