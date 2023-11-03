package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * クレカ次回売上請求日設定のメソッド {@link SetCreditUriageSeikyuubi#exec(BizDate pCalckijyunYmd)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetCreditUriageSeikyuubiTest_exec {

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);

        BizDate pCalckijyunYmd = BizDate.valueOf("2019/08/05");

        setCreditUriageSeikyuubi.exec(pCalckijyunYmd);

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrsktysytbi(), BizDate.valueOf("2019/08/09"),"次回売上請求抽出日");

        exDateEquals(setCreditUriageSeikyuubi.getZenkaiUrskbi(), BizDate.valueOf("2019/07/15"),"前回売上請求日");

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrskbi(), BizDate.valueOf("2019/08/15"),"次回売上請求日");

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrskKekHaneibi(), BizDate.valueOf("2019/08/15"),"次回売上請求結果反映日");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);

        BizDate pCalckijyunYmd = BizDate.valueOf("2019/09/11");

        setCreditUriageSeikyuubi.exec(pCalckijyunYmd);

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrsktysytbi(), BizDate.valueOf("2019/09/11"),"次回売上請求抽出日");

        exDateEquals(setCreditUriageSeikyuubi.getZenkaiUrskbi(), BizDate.valueOf("2019/08/15"),"前回売上請求日");

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrskbi(), BizDate.valueOf("2019/09/15"),"次回売上請求日");

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrskKekHaneibi(), BizDate.valueOf("2019/09/17"),"次回売上請求結果反映日");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);

        BizDate pCalckijyunYmd = BizDate.valueOf("2019/07/20");

        setCreditUriageSeikyuubi.exec(pCalckijyunYmd);

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrsktysytbi(), BizDate.valueOf("2019/08/09"),"次回売上請求抽出日");

        exDateEquals(setCreditUriageSeikyuubi.getZenkaiUrskbi(), BizDate.valueOf("2019/07/15"),"前回売上請求日");

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrskbi(), BizDate.valueOf("2019/08/15"),"次回売上請求日");

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrskKekHaneibi(), BizDate.valueOf("2019/08/15"),"次回売上請求結果反映日");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);

        BizDate pCalckijyunYmd = BizDate.valueOf("2019/08/22");

        setCreditUriageSeikyuubi.exec(pCalckijyunYmd);

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrsktysytbi(), BizDate.valueOf("2019/09/11"),"次回売上請求抽出日");

        exDateEquals(setCreditUriageSeikyuubi.getZenkaiUrskbi(), BizDate.valueOf("2019/08/15"),"前回売上請求日");

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrskbi(), BizDate.valueOf("2019/09/15"),"次回売上請求日");

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrskKekHaneibi(), BizDate.valueOf("2019/09/17"),"次回売上請求結果反映日");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);

        BizDate pCalckijyunYmd = BizDate.valueOf("2019/09/15");

        setCreditUriageSeikyuubi.exec(pCalckijyunYmd);

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrsktysytbi(), BizDate.valueOf("2019/10/09"),"次回売上請求抽出日");

        exDateEquals(setCreditUriageSeikyuubi.getZenkaiUrskbi(), BizDate.valueOf("2019/08/15"),"前回売上請求日");

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrskbi(), BizDate.valueOf("2019/09/15"),"次回売上請求日");

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrskKekHaneibi(), BizDate.valueOf("2019/09/17"),"次回売上請求結果反映日");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);

        BizDate pCalckijyunYmd = BizDate.valueOf("2019/06/17");

        setCreditUriageSeikyuubi.exec(pCalckijyunYmd);

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrsktysytbi(), BizDate.valueOf("2019/07/10"),"次回売上請求抽出日");

        exDateEquals(setCreditUriageSeikyuubi.getZenkaiUrskbi(), BizDate.valueOf("2019/06/15"),"前回売上請求日");

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrskbi(), BizDate.valueOf("2019/07/15"),"次回売上請求日");

        exDateEquals(setCreditUriageSeikyuubi.getJikaiUrskKekHaneibi(), BizDate.valueOf("2019/06/17"),"次回売上請求結果反映日");
    }

}