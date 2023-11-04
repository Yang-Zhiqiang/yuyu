package yuyu.common.hozen.haitou;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.hozen.haitou.SetHokenNnd.HokenNndBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険年度設定クラスのメソッド {@link SetHokenNnd#exec(BizDate, BizDate)}、<br />
 * {@link SetHokenNnd#exec(BizDate, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHokenNndTest_exec {

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        SetHokenNnd setHokenNnd = SWAKInjector.getInstance(SetHokenNnd.class);

        BizDate kijyunymd = null;
        BizDate hanteiymd = BizDate.valueOf(20181108);

        HokenNndBean hokenNndBean = setHokenNnd.exec(kijyunymd, hanteiymd);

        List<HaitouErrorInfo> HaitouErrorInfoLst = setHokenNnd.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(),  setHokenNnd.getClass().getSimpleName() , "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");

        assertNull(hokenNndBean);
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        SetHokenNnd setHokenNnd = SWAKInjector.getInstance(SetHokenNnd.class);

        BizDate kijyunymd = BizDate.valueOf(20181108);
        BizDate hanteiymd = null;

        HokenNndBean hokenNndBean = setHokenNnd.exec(kijyunymd, hanteiymd);

        List<HaitouErrorInfo> HaitouErrorInfoLst = setHokenNnd.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(),  setHokenNnd.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");

        assertNull(hokenNndBean);
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        SetHokenNnd setHokenNnd = SWAKInjector.getInstance(SetHokenNnd.class);

        BizDate kijyunymd = BizDate.valueOf(20181108);
        BizDate hanteiymd = BizDate.valueOf(20181107);

        HokenNndBean hokenNndBean = setHokenNnd.exec(kijyunymd, hanteiymd);

        List<HaitouErrorInfo> HaitouErrorInfoLst = setHokenNnd.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(),  setHokenNnd.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "基準日　＞　判定日", "エラー情報２（小分類）");

        assertNull(hokenNndBean);
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        SetHokenNnd setHokenNnd = SWAKInjector.getInstance(SetHokenNnd.class);

        BizDate kijyunymd = BizDate.valueOf(20181107);
        BizDate hanteiymd = BizDate.valueOf(20181108);

        HokenNndBean hokenNndBean = setHokenNnd.exec(kijyunymd, hanteiymd);

        List<HaitouErrorInfo> HaitouErrorInfoLst = setHokenNnd.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(),  setHokenNnd.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");

        exDateYEquals(hokenNndBean.getHokenNnd(), BizDateY.valueOf(2018), "保険年度");
        exDateEquals(hokenNndBean.getHokenNndStartymd(), BizDate.valueOf(20181107), "保険年度開始日");
        exDateEquals(hokenNndBean.getHokenNndEndymd(), BizDate.valueOf(20191107), "保険年度終了日");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        SetHokenNnd setHokenNnd = SWAKInjector.getInstance(SetHokenNnd.class);

        BizDate kijyunymd = BizDate.valueOf(20181107);
        BizDate hanteiymd = BizDate.valueOf(20181107);

        HokenNndBean hokenNndBean = setHokenNnd.exec(kijyunymd, hanteiymd);

        List<HaitouErrorInfo> HaitouErrorInfoLst = setHokenNnd.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(),  setHokenNnd.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");

        exDateYEquals(hokenNndBean.getHokenNnd(), BizDateY.valueOf(2018), "保険年度");
        exDateEquals(hokenNndBean.getHokenNndStartymd(), BizDate.valueOf(20181107), "保険年度開始日");
        exDateEquals(hokenNndBean.getHokenNndEndymd(), BizDate.valueOf(20191107), "保険年度終了日");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        SetHokenNnd setHokenNnd = SWAKInjector.getInstance(SetHokenNnd.class);

        BizDate kijyunymd = BizDate.valueOf(20181010);
        BizDate hanteiymd = BizDate.valueOf(20201010);

        HokenNndBean hokenNndBean = setHokenNnd.exec(kijyunymd, hanteiymd);

        List<HaitouErrorInfo> HaitouErrorInfoLst = setHokenNnd.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(),  setHokenNnd.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");

        exDateYEquals(hokenNndBean.getHokenNnd(), BizDateY.valueOf(2020), "保険年度");
        exDateEquals(hokenNndBean.getHokenNndStartymd(), BizDate.valueOf(20201010), "保険年度開始日");
        exDateEquals(hokenNndBean.getHokenNndEndymd(), BizDate.valueOf(20211010), "保険年度終了日");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        SetHokenNnd setHokenNnd = SWAKInjector.getInstance(SetHokenNnd.class);

        BizDate kijyunymd = BizDate.valueOf(20181010);
        BizDate hanteiymd = BizDate.valueOf(20200930);

        HokenNndBean hokenNndBean = setHokenNnd.exec(kijyunymd, hanteiymd);

        List<HaitouErrorInfo> HaitouErrorInfoLst = setHokenNnd.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(),  setHokenNnd.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");

        exDateYEquals(hokenNndBean.getHokenNnd(), BizDateY.valueOf(2019), "保険年度");
        exDateEquals(hokenNndBean.getHokenNndStartymd(), BizDate.valueOf(20191010), "保険年度開始日");
        exDateEquals(hokenNndBean.getHokenNndEndymd(), BizDate.valueOf(20201010), "保険年度終了日");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        SetHokenNnd setHokenNnd = SWAKInjector.getInstance(SetHokenNnd.class);

        BizDate kijyunymd = BizDate.valueOf(20180210);
        BizDate hanteiymd = BizDate.valueOf(20200210);

        HokenNndBean hokenNndBean = setHokenNnd.exec(kijyunymd, hanteiymd);

        List<HaitouErrorInfo> HaitouErrorInfoLst = setHokenNnd.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(),  setHokenNnd.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");

        exDateYEquals(hokenNndBean.getHokenNnd(), BizDateY.valueOf(2019), "保険年度");
        exDateEquals(hokenNndBean.getHokenNndStartymd(), BizDate.valueOf(20200210), "保険年度開始日");
        exDateEquals(hokenNndBean.getHokenNndEndymd(), BizDate.valueOf(20210210), "保険年度終了日");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        SetHokenNnd setHokenNnd = SWAKInjector.getInstance(SetHokenNnd.class);

        BizDate kijyunymd = BizDate.valueOf(20180210);
        BizDate hanteiymd = BizDate.valueOf(20200209);

        HokenNndBean hokenNndBean = setHokenNnd.exec(kijyunymd, hanteiymd);

        List<HaitouErrorInfo> HaitouErrorInfoLst = setHokenNnd.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(),  setHokenNnd.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");

        exDateYEquals(hokenNndBean.getHokenNnd(), BizDateY.valueOf(2018), "保険年度");
        exDateEquals(hokenNndBean.getHokenNndStartymd(), BizDate.valueOf(20190210), "保険年度開始日");
        exDateEquals(hokenNndBean.getHokenNndEndymd(), BizDate.valueOf(20200210), "保険年度終了日");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        SetHokenNnd setHokenNnd = SWAKInjector.getInstance(SetHokenNnd.class);

        BizDate kijyunymd = BizDate.valueOf(20200229);
        BizDate hanteiymd = BizDate.valueOf(20200229);

        HokenNndBean hokenNndBean = setHokenNnd.exec(kijyunymd, hanteiymd);

        List<HaitouErrorInfo> HaitouErrorInfoLst = setHokenNnd.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(),  setHokenNnd.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");

        exDateYEquals(hokenNndBean.getHokenNnd(), BizDateY.valueOf(2019), "保険年度");
        exDateEquals(hokenNndBean.getHokenNndStartymd(), BizDate.valueOf(20200229), "保険年度開始日");
        exDateEquals(hokenNndBean.getHokenNndEndymd(), BizDate.valueOf(20210228), "保険年度終了日");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        SetHokenNnd setHokenNnd = SWAKInjector.getInstance(SetHokenNnd.class);

        BizDate kijyunymd = BizDate.valueOf(20200229);
        BizDate hanteiymd = BizDate.valueOf(20210228);

        HokenNndBean hokenNndBean = setHokenNnd.exec(kijyunymd, hanteiymd);

        List<HaitouErrorInfo> HaitouErrorInfoLst = setHokenNnd.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(),  setHokenNnd.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");

        exDateYEquals(hokenNndBean.getHokenNnd(), BizDateY.valueOf(2020), "保険年度");
        exDateEquals(hokenNndBean.getHokenNndStartymd(), BizDate.valueOf(20210228), "保険年度開始日");
        exDateEquals(hokenNndBean.getHokenNndEndymd(), BizDate.valueOf(20220228), "保険年度終了日");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        SetHokenNnd setHokenNnd = SWAKInjector.getInstance(SetHokenNnd.class);

        BizDate kijyunymd = BizDate.valueOf(20200229);
        BizDate hanteiymd = BizDate.valueOf(20240229);

        HokenNndBean hokenNndBean = setHokenNnd.exec(kijyunymd, hanteiymd);

        List<HaitouErrorInfo> HaitouErrorInfoLst = setHokenNnd.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), setHokenNnd.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");

        exDateYEquals(hokenNndBean.getHokenNnd(), BizDateY.valueOf(2023), "保険年度");
        exDateEquals(hokenNndBean.getHokenNndStartymd(), BizDate.valueOf(20240229), "保険年度開始日");
        exDateEquals(hokenNndBean.getHokenNndEndymd(), BizDate.valueOf(20250228), "保険年度終了日");
    }

}
