package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * KeisanWKijunYMクラスのメソッド {@link KeisanWKijunYM#exec(BizDate,BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanWKijunYMTest_exec {

    @Inject
    private KeisanWKijunYM keisanWKijunYM;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate keiyakuYMD = BizDate.valueOf(20190520);
        BizDate calcKijyunYMD = BizDate.valueOf(20190520);
        BizDateYM jkipjytYM = BizDateYM.valueOf(201503);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        String syouhncd = "ﾕｹ";
        BizDate yendthnkymd = BizDate.valueOf(20190504);

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYMD, calcKijyunYMD, jkipjytYM, hrkkaisuu,
            kykjyoutai, syouhncd, yendthnkymd);

        exDateYMEquals(kaiyakuhrKisnKijyunYM, BizDateYM.valueOf(201906), "解約返戻金計算基準年月");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate keiyakuYMD = BizDate.valueOf(20190605);
        BizDate calcKijyunYMD = BizDate.valueOf(20190620);
        BizDateYM jkipjytYM = BizDateYM.valueOf(201503);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        String syouhncd = "ﾕA";
        BizDate yendthnkymd = BizDate.valueOf(20190620);

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYMD, calcKijyunYMD, jkipjytYM, hrkkaisuu,
            kykjyoutai, syouhncd, yendthnkymd);

        exDateYMEquals(kaiyakuhrKisnKijyunYM, BizDateYM.valueOf(201907), "解約返戻金計算基準年月");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate keiyakuYMD = BizDate.valueOf(20190606);
        BizDate calcKijyunYMD = BizDate.valueOf(20190620);
        BizDateYM jkipjytYM = BizDateYM.valueOf(201503);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        String syouhncd = "ﾕｻ";
        BizDate yendthnkymd = null;

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYMD, calcKijyunYMD, jkipjytYM, hrkkaisuu,
            kykjyoutai, syouhncd, yendthnkymd);

        exDateYMEquals(kaiyakuhrKisnKijyunYM, BizDateYM.valueOf(201906), "解約返戻金計算基準年月");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDate keiyakuYMD = BizDate.valueOf(20190501);
        BizDate calcKijyunYMD = BizDate.valueOf(20190520);
        BizDateYM jkipjytYM = BizDateYM.valueOf(201503);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        String syouhncd = "ﾕｹ";
        BizDate yendthnkymd = BizDate.valueOf(20190520);

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYMD, calcKijyunYMD, jkipjytYM, hrkkaisuu,
            kykjyoutai, syouhncd, yendthnkymd);

        exDateYMEquals(kaiyakuhrKisnKijyunYM, BizDateYM.valueOf(201905), "解約返戻金計算基準年月");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizDate keiyakuYMD = BizDate.valueOf(20190501);
        BizDate calcKijyunYMD = BizDate.valueOf(20190504);
        BizDateYM jkipjytYM = BizDateYM.valueOf(201503);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        String syouhncd = "ﾕｹ";
        BizDate yendthnkymd = BizDate.valueOf(20190520);

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYMD, calcKijyunYMD, jkipjytYM, hrkkaisuu,
            kykjyoutai, syouhncd, yendthnkymd);

        exDateYMEquals(kaiyakuhrKisnKijyunYM, BizDateYM.valueOf(201904), "解約返戻金計算基準年月");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizDate keiyakuYMD = BizDate.valueOf(20190505);
        BizDate calcKijyunYMD = BizDate.valueOf(20190505);
        BizDateYM jkipjytYM = BizDateYM.valueOf(201503);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        String syouhncd = "ﾕｹ";
        BizDate yendthnkymd = BizDate.valueOf(20190520);

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYMD, calcKijyunYMD, jkipjytYM, hrkkaisuu,
            kykjyoutai, syouhncd, yendthnkymd);

        exDateYMEquals(kaiyakuhrKisnKijyunYM, BizDateYM.valueOf(201905), "解約返戻金計算基準年月");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDate keiyakuYMD = BizDate.valueOf(20190519);
        BizDate calcKijyunYMD = BizDate.valueOf(20190506);
        BizDateYM jkipjytYM = BizDateYM.valueOf(201503);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        String syouhncd = "ﾕｹ";
        BizDate yendthnkymd = BizDate.valueOf(20190520);

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYMD, calcKijyunYMD, jkipjytYM, hrkkaisuu,
            kykjyoutai, syouhncd, yendthnkymd);

        exDateYMEquals(kaiyakuhrKisnKijyunYM, BizDateYM.valueOf(201905), "解約返戻金計算基準年月");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BizDate keiyakuYMD = BizDate.valueOf(20151218);
        BizDate calcKijyunYMD = BizDate.valueOf(20160208);
        BizDateYM jkipjytYM = BizDateYM.valueOf(201601);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.PMEN;
        String syouhncd = "ﾕｹ";
        BizDate yendthnkymd = BizDate.valueOf(20190501);

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYMD, calcKijyunYMD, jkipjytYM, hrkkaisuu,
            kykjyoutai, syouhncd, yendthnkymd);

        exDateYMEquals(kaiyakuhrKisnKijyunYM, BizDateYM.valueOf(201601), "解約返戻金計算基準年月");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BizDate keiyakuYMD = BizDate.valueOf(20151218);
        BizDate calcKijyunYMD = BizDate.valueOf(20160208);
        BizDateYM jkipjytYM = BizDateYM.valueOf(201602);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.PMEN;
        String syouhncd = "ﾕｹ";
        BizDate yendthnkymd = BizDate.valueOf(20190501);

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYMD, calcKijyunYMD, jkipjytYM, hrkkaisuu,
            kykjyoutai, syouhncd, yendthnkymd);

        exDateYMEquals(kaiyakuhrKisnKijyunYM, BizDateYM.valueOf(201602), "解約返戻金計算基準年月");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BizDate keiyakuYMD = BizDate.valueOf(20210430);
        BizDate calcKijyunYMD = BizDate.valueOf(20220131);
        BizDateYM jkipjytYM = BizDateYM.valueOf(202203);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HRKMTYUU;
        String syouhncd = "ﾕｹ";
        BizDate yendthnkymd = BizDate.valueOf(20190501);

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYMD, calcKijyunYMD, jkipjytYM, hrkkaisuu,
            kykjyoutai, syouhncd, yendthnkymd);

        exDateYMEquals(kaiyakuhrKisnKijyunYM, BizDateYM.valueOf(202202), "解約返戻金計算基準年月");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        BizDate keiyakuYMD = BizDate.valueOf(20190605);
        BizDate calcKijyunYMD = BizDate.valueOf(20200630);
        BizDateYM jkipjytYM = BizDateYM.valueOf(201503);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        String syouhncd = "ﾕF";
        BizDate yendthnkymd = BizDate.valueOf(20200615);

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYMD, calcKijyunYMD, jkipjytYM, hrkkaisuu,
            kykjyoutai, syouhncd, yendthnkymd);

        exDateYMEquals(kaiyakuhrKisnKijyunYM, BizDateYM.valueOf(202007), "解約返戻金計算基準年月");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        BizDate keiyakuYMD = BizDate.valueOf(20190605);
        BizDate calcKijyunYMD = BizDate.valueOf(20190620);
        BizDateYM jkipjytYM = BizDateYM.valueOf(201503);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        String syouhncd = "ﾕﾉ";
        BizDate yendthnkymd = null;

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYMD, calcKijyunYMD, jkipjytYM, hrkkaisuu,
            kykjyoutai, syouhncd, yendthnkymd);

        exDateYMEquals(kaiyakuhrKisnKijyunYM, BizDateYM.valueOf(201907), "解約返戻金計算基準年月");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        BizDate keiyakuYMD = BizDate.valueOf(20210430);
        BizDate calcKijyunYMD = BizDate.valueOf(20220130);
        BizDateYM jkipjytYM = BizDateYM.valueOf(202203);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.HALFY;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HRKMTYUU;
        String syouhncd = "ﾕｹ";
        BizDate yendthnkymd = BizDate.valueOf(20190501);

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYMD, calcKijyunYMD, jkipjytYM, hrkkaisuu,
            kykjyoutai, syouhncd, yendthnkymd);

        exDateYMEquals(kaiyakuhrKisnKijyunYM, BizDateYM.valueOf(202202), "解約返戻金計算基準年月");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        BizDate keiyakuYMD = BizDate.valueOf(20210430);
        BizDate calcKijyunYMD = BizDate.valueOf(20220129);
        BizDateYM jkipjytYM = BizDateYM.valueOf(202203);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HRKMTYUU;
        String syouhncd = "ﾕｹ";
        BizDate yendthnkymd = BizDate.valueOf(20190501);

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYMD, calcKijyunYMD, jkipjytYM, hrkkaisuu,
            kykjyoutai, syouhncd, yendthnkymd);

        exDateYMEquals(kaiyakuhrKisnKijyunYM, BizDateYM.valueOf(202201), "解約返戻金計算基準年月");
    }
}