package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#mosnoHensyuu()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_mosnoHensyuu {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testMosnoHensyuu_A1(){

        String pMosno = "123456789";
        String mosno = editSeihoWebRenkeiKoumoku.mosnoHensyuu(pMosno);
        exStringEquals(mosno, "123456789", "編集後申込番号");
    }

    @Test
    @TestOrder(20)
    public void testMosnoHensyuu_A2(){

        String pMosno = "12345678";
        String mosno = editSeihoWebRenkeiKoumoku.mosnoHensyuu(pMosno);
        exStringEquals(mosno, "012345678", "編集後申込番号");
    }

    @Test
    @TestOrder(30)
    public void testMosnoHensyuu_A3(){

        String pMosno = "1234567890";
        String mosno = editSeihoWebRenkeiKoumoku.mosnoHensyuu(pMosno);
        exStringEquals(mosno, "1234567890", "編集後申込番号");
    }
}
