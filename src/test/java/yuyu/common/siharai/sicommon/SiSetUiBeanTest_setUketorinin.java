package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setUketorinin(ViewUketorininSBUiBeanParam, JT_SiKykKihon, List<JT_SiUkt>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setUketorinin {

    @Test
    @TestOrder(10)
    public void testSetUketorinin_A1() {

        ViewUketorininSBUiBeanParamImpl viewUketorininSBUiBeanParamImpl = null;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        List<JT_SiUkt> siUktLst = new ArrayList<>();
        boolean result = SiSetUiBean.setUketorinin(viewUketorininSBUiBeanParamImpl, siKykKihon, siUktLst);

        exBooleanEquals(result, false, "結果");

    }

    @Test
    @TestOrder(20)
    public void testSetUketorinin_A2() {

        ViewUketorininSBUiBeanParamImpl viewUketorininSBUiBeanParamImpl = SWAKInjector
                .getInstance(ViewUketorininSBUiBeanParamImpl.class);
        viewUketorininSBUiBeanParamImpl.setSbuktnin(11);

        JT_SiKykKihon siKykKihon = null;

        List<JT_SiUkt> siUktLst = new ArrayList<>();

        boolean result = SiSetUiBean.setUketorinin(viewUketorininSBUiBeanParamImpl, siKykKihon, siUktLst);

        exBooleanEquals(result, false, "結果");

    }

    @Test
    @TestOrder(30)
    public void testSetUketorinin_A3() {

        ViewUketorininSBUiBeanParamImpl viewUketorininSBUiBeanParamImpl = SWAKInjector
                .getInstance(ViewUketorininSBUiBeanParamImpl.class);
        viewUketorininSBUiBeanParamImpl.setSbuktnin(11);

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        List<JT_SiUkt> siUktLst = null;

        boolean result = SiSetUiBean.setUketorinin(viewUketorininSBUiBeanParamImpl, siKykKihon, siUktLst);

        exBooleanEquals(result, false, "結果");

    }

    @Test
    @TestOrder(40)
    public void testSetUketorinin_A4() {

        ViewUketorininSBUiBeanParamImpl viewUketorininSBUiBeanParamImpl = SWAKInjector
                .getInstance(ViewUketorininSBUiBeanParamImpl.class);
        viewUketorininSBUiBeanParamImpl.setSbuktnin(11);

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        List<JT_SiUkt> siUktLst = new ArrayList<>();

        boolean result = SiSetUiBean.setUketorinin(viewUketorininSBUiBeanParamImpl, siKykKihon, siUktLst);

        exBooleanEquals(result, true, "結果");

        assertNull(viewUketorininSBUiBeanParamImpl.getSbuktnin());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktkbn1());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkn1());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkj1());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktseiymd1());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispmskmjskjuktnen1());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktbnwari1());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktkbn2());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkn2());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkj2());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktseiymd2());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispmskmjskjuktnen2());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktbnwari2());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktkbn3());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkn3());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkj3());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktseiymd3());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispmskmjskjuktnen3());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktbnwari3());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktkbn4());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkn4());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkj4());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktseiymd4());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispmskmjskjuktnen4());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktbnwari4());

    }

    @Test
    @TestOrder(50)
    public void testSetUketorinin_A5() {

        ViewUketorininSBUiBeanParamImpl viewUketorininSBUiBeanParamImpl = SWAKInjector
                .getInstance(ViewUketorininSBUiBeanParamImpl.class);
        viewUketorininSBUiBeanParamImpl.setSbuktnin(11);

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(22);

        List<JT_SiUkt> siUktLst = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUkt.setUktnmkn("AA");
        siUkt.setUktnmkj("BB");
        siUkt.setUktseiymd(BizDate.valueOf(20160301));
        siUkt.setUktbnwari(BizNumber.valueOf(51));
        siUktLst.add(siUkt);

        boolean result = SiSetUiBean.setUketorinin(viewUketorininSBUiBeanParamImpl, siKykKihon, siUktLst);

        exBooleanEquals(result, true, "結果");

        exNumericEquals(viewUketorininSBUiBeanParamImpl.getSbuktnin(), 22, "死亡受取人人数");
        exClassificationEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktkbn1(), C_UktKbn.KYK, "（表示用）死亡受取人区分１");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkn1(), "AA", "（表示用）死亡受取人氏名（カナ）１");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkj1(), "BB", "（表示用）死亡受取人氏名（漢字）１");
        exDateEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktseiymd1(), BizDate.valueOf(20160301),
                "（表示用）死亡受取人生年月日１");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispmskmjskjuktnen1(), "", "（表示用）申込時請求時受取人年齢１");
        exBizCalcbleEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktbnwari1(), BizNumber.valueOf(51),
                "（表示用）死亡受取人分割割合１");
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktkbn2());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkn2());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkj2());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktseiymd2());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispmskmjskjuktnen2());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktbnwari2());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktkbn3());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkn3());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkj3());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktseiymd3());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispmskmjskjuktnen3());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktbnwari3());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktkbn4());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkn4());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkj4());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktseiymd4());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispmskmjskjuktnen4());
        assertNull(viewUketorininSBUiBeanParamImpl.getDispsbuktbnwari4());

    }

    @Test
    @TestOrder(60)
    public void testSetUketorinin_A6() {

        ViewUketorininSBUiBeanParamImpl viewUketorininSBUiBeanParamImpl = SWAKInjector
                .getInstance(ViewUketorininSBUiBeanParamImpl.class);
        viewUketorininSBUiBeanParamImpl.setSbuktnin(11);

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(22);

        List<JT_SiUkt> siUktLst = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUkt.setUktnmkn("A");
        siUkt.setUktnmkj("B");
        siUkt.setUktseiymd(BizDate.valueOf(20160301));
        siUkt.setUktbnwari(BizNumber.valueOf(51));
        siUktLst.add(siUkt);
        JT_SiUkt siUkt2 = new JT_SiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktkbn(C_UktKbn.HHKN);
        siUkt2.setUktnmkn("AA");
        siUkt2.setUktnmkj("BB");
        siUkt2.setUktseiymd(BizDate.valueOf(20160302));
        siUkt2.setUktbnwari(BizNumber.valueOf(52));
        siUktLst.add(siUkt2);
        JT_SiUkt siUkt3 = new JT_SiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.KYFKUKT);
        siUkt3.setUktkbn(C_UktKbn.STDRNIN);
        siUkt3.setUktnmkn("AAA");
        siUkt3.setUktnmkj("BBB");
        siUkt3.setUktseiymd(BizDate.valueOf(20160303));
        siUkt3.setUktbnwari(BizNumber.valueOf(53));
        siUktLst.add(siUkt3);
        JT_SiUkt siUkt4 = new JT_SiUkt();
        siUkt4.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt4.setUktkbn(C_UktKbn.HUKUSUU);
        siUkt4.setUktnmkn("AAAA");
        siUkt4.setUktnmkj("BBBB");
        siUkt4.setUktseiymd(BizDate.valueOf(20160304));
        siUkt4.setUktbnwari(BizNumber.valueOf(54));
        siUktLst.add(siUkt4);
        JT_SiUkt siUkt5 = new JT_SiUkt();
        siUkt5.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt5.setUktkbn(C_UktKbn.SOUZOKUNIN);
        siUkt5.setUktnmkn("AAAAA");
        siUkt5.setUktnmkj("BBBBB");
        siUkt5.setUktseiymd(BizDate.valueOf(20160305));
        siUkt5.setUktbnwari(BizNumber.valueOf(55));
        siUktLst.add(siUkt5);
        JT_SiUkt siUkt6 = new JT_SiUkt();
        siUkt6.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt6.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
        siUkt6.setUktnmkn("AAAAAA");
        siUkt6.setUktnmkj("BBBBBB");
        siUkt6.setUktseiymd(BizDate.valueOf(20160306));
        siUkt6.setUktbnwari(BizNumber.valueOf(56));
        siUktLst.add(siUkt6);

        boolean result = SiSetUiBean.setUketorinin(viewUketorininSBUiBeanParamImpl, siKykKihon, siUktLst);

        exBooleanEquals(result, true, "結果");

        exNumericEquals(viewUketorininSBUiBeanParamImpl.getSbuktnin(), 22, "死亡受取人人数");
        exClassificationEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktkbn1(), C_UktKbn.KYK, "（表示用）死亡受取人区分１");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkn1(), "A", "（表示用）死亡受取人氏名（カナ）１");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkj1(), "B", "（表示用）死亡受取人氏名（漢字）１");
        exDateEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktseiymd1(), BizDate.valueOf(20160301),
                "（表示用）死亡受取人生年月日１");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispmskmjskjuktnen1(), "", "（表示用）申込時請求時受取人年齢１");
        exBizCalcbleEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktbnwari1(), BizNumber.valueOf(51),
                "（表示用）死亡受取人分割割合１");

        exClassificationEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktkbn2(), C_UktKbn.HHKN, "（表示用）死亡受取人区分２");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkn2(), "AA", "（表示用）死亡受取人氏名（カナ）２");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkj2(), "BB", "（表示用）死亡受取人氏名（漢字）２");
        exDateEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktseiymd2(), BizDate.valueOf(20160302),
                "（表示用）死亡受取人生年月日２");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispmskmjskjuktnen2(), "", "（表示用）申込時請求時受取人年齢２");
        exBizCalcbleEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktbnwari2(), BizNumber.valueOf(52),
                "（表示用）死亡受取人分割割合２");

        exClassificationEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktkbn3(), C_UktKbn.HUKUSUU, "（表示用）死亡受取人区分３");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkn3(), "AAAA", "（表示用）死亡受取人氏名（カナ）３");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkj3(), "BBBB", "（表示用）死亡受取人氏名（漢字）３");
        exDateEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktseiymd3(), BizDate.valueOf(20160304),
                "（表示用）死亡受取人生年月日３");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispmskmjskjuktnen3(), "", "（表示用）申込時請求時受取人年齢３");
        exBizCalcbleEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktbnwari3(), BizNumber.valueOf(54),
                "（表示用）死亡受取人分割割合３");

        exClassificationEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktkbn4(), C_UktKbn.SOUZOKUNIN, "（表示用）死亡受取人区分４");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkn4(), "AAAAA", "（表示用）死亡受取人氏名（カナ）４");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktnmkj4(), "BBBBB", "（表示用）死亡受取人氏名（漢字）４");
        exDateEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktseiymd4(), BizDate.valueOf(20160305),
                "（表示用）死亡受取人生年月日３");
        exStringEquals(viewUketorininSBUiBeanParamImpl.getDispmskmjskjuktnen4(), "", "（表示用）申込時請求時受取人年齢４");
        exBizCalcbleEquals(viewUketorininSBUiBeanParamImpl.getDispsbuktbnwari4(), BizNumber.valueOf(55),
                "（表示用）死亡受取人分割割合４");
    }

}
