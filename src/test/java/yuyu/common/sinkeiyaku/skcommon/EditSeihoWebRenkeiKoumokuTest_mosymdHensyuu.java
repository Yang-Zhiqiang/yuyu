package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド {@link EditSeihoWebRenkeiKoumoku#mosymdHensyuu(BizDate, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_mosymdHensyuu {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testMosymdHensyuu_A1() {

        BizDate mosymd = editSeihoWebRenkeiKoumoku.mosymdHensyuu(null, "4", "321");

        exDateEquals(mosymd, null, "申込日");

    }

    @Test
    @TestOrder(20)
    public void testMosymdHensyuu_A2() {

        BizDate mosymd = editSeihoWebRenkeiKoumoku.mosymdHensyuu(BizDate.valueOf(20160515), "4", "321");

        exDateEquals(mosymd, BizDate.valueOf(20160401), "申込日");

    }

    @Test
    @TestOrder(30)
    public void testMosymdHensyuu_A3() {

        BizDate mosymd = editSeihoWebRenkeiKoumoku.mosymdHensyuu(BizDate.valueOf(20160516), "4", "322");

        exDateEquals(mosymd, BizDate.valueOf(20160416), "申込日");

    }

    @Test
    @TestOrder(40)
    public void testMosymdHensyuu_A4() {

        BizDate mosymd = editSeihoWebRenkeiKoumoku.mosymdHensyuu(BizDate.valueOf(20160517), "4", "323");

        exDateEquals(mosymd, BizDate.valueOf(20160416), "申込日");

    }

    @Test
    @TestOrder(50)
    public void testMosymdHensyuu_A5() {

        BizDate mosymd = editSeihoWebRenkeiKoumoku.mosymdHensyuu(BizDate.valueOf(20160517), "4", "324");

        exDateEquals(mosymd, BizDate.valueOf(20160517), "申込日");

    }

    @Test
    @TestOrder(60)
    public void testMosymdHensyuu_A6() {

        BizDate mosymd = editSeihoWebRenkeiKoumoku.mosymdHensyuu(BizDate.valueOf(20160517), "5", "321");

        exDateEquals(mosymd, BizDate.valueOf(20160517), "申込日");

    }

}
