package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#huho2GetZnnkai()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_huho2GetZnnkai {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHuho2GetZnnkai_A1(){

        Integer pZennoukikan = 0;
        Integer huho2Znnkai = editSeihoWebRenkeiKoumoku.huho2GetZnnkai(pZennoukikan);
        exNumericEquals(huho2Znnkai, 0, "普保Ⅱ前納回数");
    }

    @Test
    @TestOrder(20)
    public void testHuho2GetZnnkai_A2(){

        Integer pZennoukikan = 1;
        Integer huho2Znnkai = editSeihoWebRenkeiKoumoku.huho2GetZnnkai(pZennoukikan);
        exNumericEquals(huho2Znnkai, 0, "普保Ⅱ前納回数");
    }

    @Test
    @TestOrder(30)
    public void testHuho2GetZnnkai_A3(){

        Integer pZennoukikan = 2;
        Integer huho2Znnkai = editSeihoWebRenkeiKoumoku.huho2GetZnnkai(pZennoukikan);
        exNumericEquals(huho2Znnkai, 1, "普保Ⅱ前納回数");
    }
}
