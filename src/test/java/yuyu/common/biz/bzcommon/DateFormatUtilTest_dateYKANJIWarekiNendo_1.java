package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月区切り日付編集（和暦年度）処理メソッド（BizDate）{@link DateFormatUtil#dateYKANJIWarekiNendo(BizDate)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateYKANJIWarekiNendo_1{
    private BizDate   dateBD;
    private String    result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(210)
    public void testNormalParam46(){
        dateBD = BizDate.valueOf("20030101");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "平成14年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(220)
    public void testIllegalParam141(){
        dateBD = null;
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, null, "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(230)
    public void testIllegalParam142(){
        dateBD = BizDate.valueOf("05000101");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "05000101", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(240)
    public void testIllegalParam143(){
        dateBD = BizDate.valueOf("00000101");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "00000101", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(250)
    public void testNormalParam47(){
        dateBD = BizDate.valueOf("99991231");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "平成8011年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(260)
    public void testNormalParam48(){
        dateBD = BizDate.valueOf("20901231");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "平成102年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(270)
    public void testNormalParam49(){
        dateBD = BizDate.valueOf("19890108");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "昭和63年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(280)
    public void testNormalParam50(){
        dateBD = BizDate.valueOf("19261226");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "大正15年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(290)
    public void testNormalParam51(){
        dateBD = BizDate.valueOf("19120730");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "明治45年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(300)
    public void testNormalParam52(){
        dateBD = BizDate.valueOf("18681023");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "明治 1年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(310)
    public void testNormalParam53(){
        dateBD = BizDate.valueOf("19890107");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "昭和63年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(320)
    public void testNormalParam54(){
        dateBD = BizDate.valueOf("19261225");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "大正15年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(330)
    public void testNormalParam55(){
        dateBD = BizDate.valueOf("19120729");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "明治45年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(340)
    public void testNormalParam56(){
        dateBD = BizDate.valueOf("19271226");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "昭和 2年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(350)
    public void testNormalParam57(){
        dateBD = BizDate.valueOf("19130730");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "大正 2年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(360)
    public void testNormalParam58(){
        dateBD = BizDate.valueOf("19881231");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "昭和63年度", "漢字和暦年度編集処理結果");
    }


    @Test
    @TestOrder(370)
    public void testNormalParam59(){
        dateBD = BizDate.valueOf("19890101");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "昭和63年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(380)
    public void testNormalParam60(){
        dateBD = BizDate.valueOf("20160229");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "平成27年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(390)
    public void testNormalParam61(){
        dateBD = BizDate.valueOf("19890331");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "昭和63年度", "漢字和暦年度編集処理結果");
    }

    @Test
    @TestOrder(400)
    public void testNormalParam62(){
        dateBD = BizDate.valueOf("19890401");
        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "平成 1年度", "漢字和暦年度編集処理結果");
    }




}