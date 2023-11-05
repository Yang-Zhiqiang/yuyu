package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.viewshrgoukei.ViewShrGoukeiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsiharaiinfo.ViewSiharaiInfoUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.common.siharai.siview.viewzeimuinfo.ViewZeimuInfoUiBeanParamImpl;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setSiharaiKingakuKeisanResult(CommonViewUiBeanParam, SiHkkingakuSisanParamBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setSiharaiKingakuKeisanResult {

    @Test
    @TestOrder(10)
    public void testSetSiharaiKingakuKeisanResult_A1() {

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);
        CommonViewUiBeanParam commonViewUiBeanParam = null;
        SiSetUiBean.setSiharaiKingakuKeisanResult(commonViewUiBeanParam, siHkkingakuSisanParamBean);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetSiharaiKingakuKeisanResult_A2() {

        ViewSiharaiInfoUiBeanParamImpl viewSiharaiInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiInfoUiBeanParamImpl.class);
        viewSiharaiInfoUiBeanParamImpl.setShrtuukasyu(C_Tuukasyu.BLNK);
        viewSiharaiInfoUiBeanParamImpl.setShrkwsratekjnymd(BizDate.valueOf(20160314));
        viewSiharaiInfoUiBeanParamImpl.setShrkwsrate(BizNumber.valueOf(10));
        viewSiharaiInfoUiBeanParamImpl.setDispsyoruiukeymd(BizDate.valueOf(20160315));
        viewSiharaiInfoUiBeanParamImpl.setDisphubikanryouymd(BizDate.valueOf(20160316));
        viewSiharaiInfoUiBeanParamImpl.setShrymd(BizDate.valueOf(20160317));
        viewSiharaiInfoUiBeanParamImpl.setDispsinsagendokknkbn(C_SinsaGendoKknKbn.BLNK);
        viewSiharaiInfoUiBeanParamImpl.setDisprkktydnnissuu(11);

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);
        siHkkingakuSisanParamBean.setShrTuukasyu(C_Tuukasyu.JPY);
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(12));
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20150314));
        siHkkingakuSisanParamBean.setShrYmd(BizDate.valueOf(20150317));

        SiSetUiBean.setSiharaiKingakuKeisanResult(viewSiharaiInfoUiBeanParamImpl, siHkkingakuSisanParamBean);

        exClassificationEquals(viewSiharaiInfoUiBeanParamImpl.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exDateEquals(viewSiharaiInfoUiBeanParamImpl.getShrkwsratekjnymd(), BizDate.valueOf(20150314), "支払時為替レート基準日");
        exBizCalcbleEquals(viewSiharaiInfoUiBeanParamImpl.getShrkwsrate(), BizNumber.valueOf(12), "支払時為替レート");
        exDateEquals(viewSiharaiInfoUiBeanParamImpl.getDispsyoruiukeymd(), BizDate.valueOf(20160315), "（表示用）書類受付日");
        exDateEquals(viewSiharaiInfoUiBeanParamImpl.getDisphubikanryouymd(), BizDate.valueOf(20160316), "（表示用）不備完了日");
        exDateEquals(viewSiharaiInfoUiBeanParamImpl.getShrymd(), BizDate.valueOf(20150317), "支払日");
        exClassificationEquals(viewSiharaiInfoUiBeanParamImpl.getDispsinsagendokknkbn(), C_SinsaGendoKknKbn.BLNK,
            "（表示用）審査限度期間区分");
        exNumericEquals(viewSiharaiInfoUiBeanParamImpl.getDisprkktydnnissuu(), 11, "（表示用）履行期中断日数");

    }

    @Test
    @TestOrder(30)
    public void testSetSiharaiKingakuKeisanResult_A3() {

        ViewShrGoukeiUiBeanParamImpl viewShrGoukeiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewShrGoukeiUiBeanParamImpl.class);
        viewShrGoukeiUiBeanParamImpl.setShrgk(BizCurrency.valueOf(11));
        viewShrGoukeiUiBeanParamImpl.setHokenkngkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setTienrisokukisanymd(BizDate.valueOf(20160301));
        viewShrGoukeiUiBeanParamImpl.setTienrsknissuu(33);
        viewShrGoukeiUiBeanParamImpl.setShrtienrsk(BizCurrency.valueOf(44));
        viewShrGoukeiUiBeanParamImpl.setYenshrgk(BizCurrency.valueOf(55));
        viewShrGoukeiUiBeanParamImpl.setYenhkgkgoukei(BizCurrency.valueOf(66));
        viewShrGoukeiUiBeanParamImpl.setYenshrtienrsk(BizCurrency.valueOf(77));

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);
        siHkkingakuSisanParamBean.setTienRisokuKisanYmd(BizDate.valueOf(20150301));
        siHkkingakuSisanParamBean.setTienRskNissuu(88);
        siHkkingakuSisanParamBean.setHokenknGk(BizCurrency.valueOf(99));
        siHkkingakuSisanParamBean.setTienRsk(BizCurrency.valueOf(100));
        siHkkingakuSisanParamBean.setYenHokenknGk(BizCurrency.valueOf(101));
        siHkkingakuSisanParamBean.setYenTienRsk(BizCurrency.valueOf(102));

        SiSetUiBean.setSiharaiKingakuKeisanResult(viewShrGoukeiUiBeanParamImpl, siHkkingakuSisanParamBean);

        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getShrgk(), BizCurrency.valueOf(199), "支払金額");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getHokenkngkgoukei(), BizCurrency.valueOf(99), "保険金額合計");
        exDateEquals(viewShrGoukeiUiBeanParamImpl.getTienrisokukisanymd(), BizDate.valueOf(20150301), "遅延利息起算日");
        exNumericEquals(viewShrGoukeiUiBeanParamImpl.getTienrsknissuu(), 88, "遅延利息日数");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getShrtienrsk(), BizCurrency.valueOf(100), "支払遅延利息");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenshrgk(), BizCurrency.valueOf(203), "円換算支払金額");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenhkgkgoukei(), BizCurrency.valueOf(101), "円換算保険金額合計");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenshrtienrsk(), BizCurrency.valueOf(102), "円換算支払遅延利息");
        assertNull("円支払遅延利息起算日", viewShrGoukeiUiBeanParamImpl.getYentienrisokukisanymd());
        assertNull("円支払遅延利息日数", viewShrGoukeiUiBeanParamImpl.getYentienrsknissuu());

    }

    @Test
    @TestOrder(40)
    public void testSetSiharaiKingakuKeisanResult_A4() {

        ViewKingakuInfoUiBeanParamImpl kingakuInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewKingakuInfoUiBeanParamImpl.class);
        kingakuInfoUiBeanParamImpl.setHokenryoustgk(BizCurrency.valueOf(11));
        kingakuInfoUiBeanParamImpl.setYenhokenryoustgk(BizCurrency.valueOf(12));
        kingakuInfoUiBeanParamImpl.setTutakngk(BizCurrency.valueOf(13));
        kingakuInfoUiBeanParamImpl.setYentutakngk(BizCurrency.valueOf(14));
        kingakuInfoUiBeanParamImpl.setKaiyakuhr(BizCurrency.valueOf(15));
        kingakuInfoUiBeanParamImpl.setYenkaiyakuhr(BizCurrency.valueOf(16));
        kingakuInfoUiBeanParamImpl.setKihonhokenkngk(BizCurrency.valueOf(17));
        kingakuInfoUiBeanParamImpl.setYenkihonhokenkngk(BizCurrency.valueOf(18));
        kingakuInfoUiBeanParamImpl.setSaigais(BizCurrency.valueOf(19));
        kingakuInfoUiBeanParamImpl.setYensaigais(BizCurrency.valueOf(20));
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);
        siHkkingakuSisanParamBean.setHokenryoustGk(BizCurrency.valueOf(21));
        siHkkingakuSisanParamBean.setYenHokenryoustGk(BizCurrency.valueOf(22));
        siHkkingakuSisanParamBean.setTutaknGk(BizCurrency.valueOf(23));
        siHkkingakuSisanParamBean.setYenTutaknGk(BizCurrency.valueOf(24));
        siHkkingakuSisanParamBean.setKaiyakuHr(BizCurrency.valueOf(25));
        siHkkingakuSisanParamBean.setYenKaiyakuHr(BizCurrency.valueOf(26));
        siHkkingakuSisanParamBean.setKihonHokenKngk(BizCurrency.valueOf(27));
        siHkkingakuSisanParamBean.setYenKihonHokenKngk(BizCurrency.valueOf(28));
        siHkkingakuSisanParamBean.setSaigaiS(BizCurrency.valueOf(29));
        siHkkingakuSisanParamBean.setYenSaigaiS(BizCurrency.valueOf(30));
        siHkkingakuSisanParamBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
        SiSetUiBean.setSiharaiKingakuKeisanResult(kingakuInfoUiBeanParamImpl, siHkkingakuSisanParamBean);

        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getHokenryoustgk(), BizCurrency.valueOf(21),
            "保険料相当額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYenhokenryoustgk(), BizCurrency.valueOf(22),
            " 円換算保険料相当額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getTutakngk(), BizCurrency.valueOf(23),
            "積立金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYentutakngk(), BizCurrency.valueOf(24),
            "円換算積立金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getKaiyakuhr(), BizCurrency.valueOf(25),
            "解約返戻金");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYenkaiyakuhr(), BizCurrency.valueOf(26),
            "円換算解約返戻金");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getKihonhokenkngk(), BizCurrency.valueOf(27),
            "基本保険金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYenkihonhokenkngk(), BizCurrency.valueOf(28),
            "円換算基本保険金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getSaigais(), BizCurrency.valueOf(29),
            "災害保険金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYensaigais(), BizCurrency.valueOf(30),
            "円換算災害保険金額");


    }

    @Test
    @TestOrder(50)
    public void testSetSiharaiKingakuKeisanResult_A5() {

        ViewZeimuInfoUiBeanParamImpl viewZeimuInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewZeimuInfoUiBeanParamImpl.class);
        viewZeimuInfoUiBeanParamImpl.setZeitratkikbn(C_ZeitratkiKbn.BLNK);
        viewZeimuInfoUiBeanParamImpl.setGoukeihituyoukeihi(BizCurrency.valueOf(11));

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);
        siHkkingakuSisanParamBean.setYenHtyKeihi(BizCurrency.valueOf(12));

        SiSetUiBean.setSiharaiKingakuKeisanResult(viewZeimuInfoUiBeanParamImpl, siHkkingakuSisanParamBean);

        exClassificationEquals(viewZeimuInfoUiBeanParamImpl.getZeitratkikbn(), C_ZeitratkiKbn.BLNK, "税取扱区分");
        exBizCalcbleEquals(viewZeimuInfoUiBeanParamImpl.getGoukeihituyoukeihi(), BizCurrency.valueOf(12), "合計必要経費");

    }

    @Test
    @TestOrder(60)
    public void testSetSiharaiKingakuKeisanResult_A6() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        SiSetUiBean.setSiharaiKingakuKeisanResult(viewSkKihonUiBeanParamImpl, null);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

    }

    @Test
    @TestOrder(70)
    public void testSetSiharaiKingakuKeisanResult_A7() {

        ViewShrGoukeiUiBeanParamImpl viewShrGoukeiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewShrGoukeiUiBeanParamImpl.class);
        viewShrGoukeiUiBeanParamImpl.setShrgk(BizCurrency.valueOf(11));
        viewShrGoukeiUiBeanParamImpl.setHokenkngkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setTienrisokukisanymd(BizDate.valueOf(20160301));
        viewShrGoukeiUiBeanParamImpl.setTienrsknissuu(33);
        viewShrGoukeiUiBeanParamImpl.setShrtienrsk(BizCurrency.valueOf(44));
        viewShrGoukeiUiBeanParamImpl.setYenshrgk(BizCurrency.valueOf(55));
        viewShrGoukeiUiBeanParamImpl.setYenhkgkgoukei(BizCurrency.valueOf(66));
        viewShrGoukeiUiBeanParamImpl.setYenshrtienrsk(BizCurrency.valueOf(77));

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);
        siHkkingakuSisanParamBean.setTienRisokuKisanYmd(BizDate.valueOf(20150301));
        siHkkingakuSisanParamBean.setTienRskNissuu(88);
        siHkkingakuSisanParamBean.setHokenknGk(BizCurrency.valueOf(99));
        siHkkingakuSisanParamBean.setTienRsk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setYenHokenknGk(BizCurrency.valueOf(101));
        siHkkingakuSisanParamBean.setYenTienRsk(BizCurrency.valueOf(0));

        SiSetUiBean.setSiharaiKingakuKeisanResult(viewShrGoukeiUiBeanParamImpl, siHkkingakuSisanParamBean);

        assertNull("遅延利息起算日", viewShrGoukeiUiBeanParamImpl.getTienrisokukisanymd());
        assertNull("遅延利息日数", viewShrGoukeiUiBeanParamImpl.getTienrsknissuu());
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        assertNull("円支払遅延利息起算日", viewShrGoukeiUiBeanParamImpl.getYentienrisokukisanymd());
        assertNull("円支払遅延利息日数", viewShrGoukeiUiBeanParamImpl.getYentienrsknissuu());
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenshrtienrsk(), BizCurrency.valueOf(0), "円換算支払遅延利息");

    }

    @Test
    @TestOrder(80)
    public void testSetSiharaiKingakuKeisanResult_A8() {

        ViewShrGoukeiUiBeanParamImpl viewShrGoukeiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewShrGoukeiUiBeanParamImpl.class);
        viewShrGoukeiUiBeanParamImpl.setShrgk(BizCurrency.valueOf(11));
        viewShrGoukeiUiBeanParamImpl.setHokenkngkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setTienrisokukisanymd(BizDate.valueOf(20160301));
        viewShrGoukeiUiBeanParamImpl.setTienrsknissuu(33);
        viewShrGoukeiUiBeanParamImpl.setShrtienrsk(BizCurrency.valueOf(44));
        viewShrGoukeiUiBeanParamImpl.setYenshrgk(BizCurrency.valueOf(55));
        viewShrGoukeiUiBeanParamImpl.setYenhkgkgoukei(BizCurrency.valueOf(66));
        viewShrGoukeiUiBeanParamImpl.setYenshrtienrsk(BizCurrency.valueOf(77));

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);
        siHkkingakuSisanParamBean.setTienRisokuKisanYmd(BizDate.valueOf(20150301));
        siHkkingakuSisanParamBean.setTienRskNissuu(88);
        siHkkingakuSisanParamBean.setHokenknGk(BizCurrency.valueOf(99));
        siHkkingakuSisanParamBean.setTienRsk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setYenHokenknGk(BizCurrency.valueOf(101));
        siHkkingakuSisanParamBean.setYenTienRsk(BizCurrency.valueOf(102));
        siHkkingakuSisanParamBean.setShrTuukasyu(C_Tuukasyu.JPY);

        SiSetUiBean.setSiharaiKingakuKeisanResult(viewShrGoukeiUiBeanParamImpl, siHkkingakuSisanParamBean);

        assertNull("遅延利息起算日", viewShrGoukeiUiBeanParamImpl.getTienrisokukisanymd());
        assertNull("遅延利息日数", viewShrGoukeiUiBeanParamImpl.getTienrsknissuu());
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exDateEquals(viewShrGoukeiUiBeanParamImpl.getYentienrisokukisanymd(), BizDate.valueOf(20150301), "円支払遅延利息起算日");
        exNumericEquals(viewShrGoukeiUiBeanParamImpl.getYentienrsknissuu(), 88, "円支払遅延利息日数");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenshrtienrsk(), BizCurrency.valueOf(102), "円換算支払遅延利息");

    }

    @Test
    @TestOrder(90)
    public void testSetSiharaiKingakuKeisanResult_A9() {

        ViewShrGoukeiUiBeanParamImpl viewShrGoukeiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewShrGoukeiUiBeanParamImpl.class);
        viewShrGoukeiUiBeanParamImpl.setShrgk(BizCurrency.valueOf(11));
        viewShrGoukeiUiBeanParamImpl.setHokenkngkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setTienrisokukisanymd(BizDate.valueOf(20160301));
        viewShrGoukeiUiBeanParamImpl.setTienrsknissuu(33);
        viewShrGoukeiUiBeanParamImpl.setShrtienrsk(BizCurrency.valueOf(44));
        viewShrGoukeiUiBeanParamImpl.setYenshrgk(BizCurrency.valueOf(55));
        viewShrGoukeiUiBeanParamImpl.setYenhkgkgoukei(BizCurrency.valueOf(66));
        viewShrGoukeiUiBeanParamImpl.setYenshrtienrsk(BizCurrency.valueOf(77));

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);
        siHkkingakuSisanParamBean.setTienRisokuKisanYmd(BizDate.valueOf(20150301));
        siHkkingakuSisanParamBean.setTienRskNissuu(88);
        siHkkingakuSisanParamBean.setHokenknGk(BizCurrency.valueOf(99));
        siHkkingakuSisanParamBean.setTienRsk(BizCurrency.valueOf(100));
        siHkkingakuSisanParamBean.setYenHokenknGk(BizCurrency.valueOf(101));
        siHkkingakuSisanParamBean.setYenTienRsk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setShrTuukasyu(C_Tuukasyu.JPY);

        SiSetUiBean.setSiharaiKingakuKeisanResult(viewShrGoukeiUiBeanParamImpl, siHkkingakuSisanParamBean);

        assertNull("遅延利息起算日", viewShrGoukeiUiBeanParamImpl.getTienrisokukisanymd());
        assertNull("遅延利息日数", viewShrGoukeiUiBeanParamImpl.getTienrsknissuu());
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getShrtienrsk(), BizCurrency.valueOf(100), "支払遅延利息");
        exDateEquals(viewShrGoukeiUiBeanParamImpl.getYentienrisokukisanymd(), BizDate.valueOf(20150301), "円支払遅延利息起算日");
        exNumericEquals(viewShrGoukeiUiBeanParamImpl.getYentienrsknissuu(), 88, "円支払遅延利息日数");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenshrtienrsk(), BizCurrency.valueOf(0), "円換算支払遅延利息");

    }

    @Test
    @TestOrder(100)
    public void testSetSiharaiKingakuKeisanResult_A10() {

        ViewKingakuInfoUiBeanParamImpl kingakuInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewKingakuInfoUiBeanParamImpl.class);
        kingakuInfoUiBeanParamImpl.setHokenryoustgk(BizCurrency.valueOf(11));
        kingakuInfoUiBeanParamImpl.setYenhokenryoustgk(BizCurrency.valueOf(12));
        kingakuInfoUiBeanParamImpl.setTutakngk(BizCurrency.valueOf(13));
        kingakuInfoUiBeanParamImpl.setYentutakngk(BizCurrency.valueOf(14));
        kingakuInfoUiBeanParamImpl.setKaiyakuhr(BizCurrency.valueOf(15));
        kingakuInfoUiBeanParamImpl.setYenkaiyakuhr(BizCurrency.valueOf(16));
        kingakuInfoUiBeanParamImpl.setKihonhokenkngk(BizCurrency.valueOf(17));
        kingakuInfoUiBeanParamImpl.setYenkihonhokenkngk(BizCurrency.valueOf(18));
        kingakuInfoUiBeanParamImpl.setSaigais(BizCurrency.valueOf(19));
        kingakuInfoUiBeanParamImpl.setYensaigais(BizCurrency.valueOf(20));

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);
        siHkkingakuSisanParamBean.setHokenryoustGk(BizCurrency.valueOf(21));
        siHkkingakuSisanParamBean.setYenHokenryoustGk(BizCurrency.valueOf(22));
        siHkkingakuSisanParamBean.setTutaknGk(BizCurrency.valueOf(23));
        siHkkingakuSisanParamBean.setYenTutaknGk(BizCurrency.valueOf(24));
        siHkkingakuSisanParamBean.setKaiyakuHr(BizCurrency.valueOf(25));
        siHkkingakuSisanParamBean.setYenKaiyakuHr(BizCurrency.valueOf(26));
        siHkkingakuSisanParamBean.setKihonHokenKngk(BizCurrency.valueOf(27));
        siHkkingakuSisanParamBean.setYenKihonHokenKngk(BizCurrency.valueOf(28));
        siHkkingakuSisanParamBean.setSaigaiS(BizCurrency.valueOf(29));
        siHkkingakuSisanParamBean.setYenSaigaiS(BizCurrency.valueOf(30));
        siHkkingakuSisanParamBean.setHknKknKbn(C_HknKknKbn.DAI2HKNKKN);
        SiSetUiBean.setSiharaiKingakuKeisanResult(kingakuInfoUiBeanParamImpl, siHkkingakuSisanParamBean);

        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getHokenryoustgk(), BizCurrency.valueOf(21),
            "保険料相当額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYenhokenryoustgk(), BizCurrency.valueOf(22),
            " 円換算保険料相当額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getTutakngk(), BizCurrency.valueOf(23),
            "積立金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYentutakngk(), BizCurrency.valueOf(24),
            "円換算積立金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getKaiyakuhr(), BizCurrency.valueOf(25),
            "解約返戻金");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYenkaiyakuhr(), BizCurrency.valueOf(26),
            "円換算解約返戻金");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getKihonhokenkngk(), BizCurrency.valueOf(27),
            "基本保険金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYenkihonhokenkngk(), BizCurrency.valueOf(28),
            "円換算基本保険金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getSaigais(), BizCurrency.optional(),
            "災害保険金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYensaigais(), BizCurrency.optional(),
            "円換算災害保険金額");

    }

    @Test
    @TestOrder(110)
    public void testSetSiharaiKingakuKeisanResult_A11() {

        ViewShrGoukeiUiBeanParamImpl viewShrGoukeiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewShrGoukeiUiBeanParamImpl.class);
        viewShrGoukeiUiBeanParamImpl.setShrgk(BizCurrency.valueOf(11));
        viewShrGoukeiUiBeanParamImpl.setHokenkngkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setTienrisokukisanymd(BizDate.valueOf(20160301));
        viewShrGoukeiUiBeanParamImpl.setTienrsknissuu(33);
        viewShrGoukeiUiBeanParamImpl.setShrtienrsk(BizCurrency.valueOf(44));
        viewShrGoukeiUiBeanParamImpl.setYenshrgk(BizCurrency.valueOf(55));
        viewShrGoukeiUiBeanParamImpl.setYenhkgkgoukei(BizCurrency.valueOf(66));
        viewShrGoukeiUiBeanParamImpl.setYenshrtienrsk(BizCurrency.valueOf(77));

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);
        siHkkingakuSisanParamBean.setTienRisokuKisanYmd(BizDate.valueOf(20150301));
        siHkkingakuSisanParamBean.setTienRskNissuu(88);
        siHkkingakuSisanParamBean.setHokenknGk(BizCurrency.valueOf(99));
        siHkkingakuSisanParamBean.setTienRsk(BizCurrency.valueOf(100));
        siHkkingakuSisanParamBean.setYenHokenknGk(BizCurrency.valueOf(101));
        siHkkingakuSisanParamBean.setYenTienRsk(BizCurrency.valueOf(102));
        siHkkingakuSisanParamBean.setShrTuukasyu(C_Tuukasyu.JPY);
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.JPY);

        SiSetUiBean.setSiharaiKingakuKeisanResult(viewShrGoukeiUiBeanParamImpl, siHkkingakuSisanParamBean);

        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getShrgk(), BizCurrency.valueOf(199), "支払金額");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getHokenkngkgoukei(), BizCurrency.valueOf(99), "保険金額合計");
        exDateEquals(viewShrGoukeiUiBeanParamImpl.getTienrisokukisanymd(), BizDate.valueOf(20150301), "遅延利息起算日");
        exNumericEquals(viewShrGoukeiUiBeanParamImpl.getTienrsknissuu(), 88, "遅延利息日数");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getShrtienrsk(), BizCurrency.valueOf(100), "支払遅延利息");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenshrgk(), BizCurrency.valueOf(203), "円換算支払金額");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenhkgkgoukei(), BizCurrency.valueOf(101), "円換算保険金額合計");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenshrtienrsk(), BizCurrency.valueOf(102), "円換算支払遅延利息");
        assertNull("円支払遅延利息起算日", viewShrGoukeiUiBeanParamImpl.getYentienrisokukisanymd());
        assertNull("円支払遅延利息日数", viewShrGoukeiUiBeanParamImpl.getYentienrsknissuu());

    }

    @Test
    @TestOrder(120)
    public void testSetSiharaiKingakuKeisanResult_A12() {

        ViewKingakuInfoUiBeanParamImpl kingakuInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewKingakuInfoUiBeanParamImpl.class);
        kingakuInfoUiBeanParamImpl.setHokenryoustgk(BizCurrency.valueOf(11));
        kingakuInfoUiBeanParamImpl.setYenhokenryoustgk(BizCurrency.valueOf(12));
        kingakuInfoUiBeanParamImpl.setTutakngk(BizCurrency.valueOf(13));
        kingakuInfoUiBeanParamImpl.setYentutakngk(BizCurrency.valueOf(14));
        kingakuInfoUiBeanParamImpl.setKaiyakuhr(BizCurrency.valueOf(15));
        kingakuInfoUiBeanParamImpl.setYenkaiyakuhr(BizCurrency.valueOf(16));
        kingakuInfoUiBeanParamImpl.setKihonhokenkngk(BizCurrency.valueOf(17));
        kingakuInfoUiBeanParamImpl.setYenkihonhokenkngk(BizCurrency.valueOf(18));
        kingakuInfoUiBeanParamImpl.setSaigais(BizCurrency.valueOf(19));
        kingakuInfoUiBeanParamImpl.setYensaigais(BizCurrency.valueOf(20));

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);
        siHkkingakuSisanParamBean.setHokenryoustGk(BizCurrency.valueOf(21));
        siHkkingakuSisanParamBean.setYenHokenryoustGk(BizCurrency.valueOf(22));
        siHkkingakuSisanParamBean.setTutaknGk(BizCurrency.valueOf(23));
        siHkkingakuSisanParamBean.setYenTutaknGk(BizCurrency.valueOf(24));
        siHkkingakuSisanParamBean.setKaiyakuHr(BizCurrency.valueOf(25));
        siHkkingakuSisanParamBean.setYenKaiyakuHr(BizCurrency.valueOf(26));
        siHkkingakuSisanParamBean.setKihonHokenKngk(BizCurrency.valueOf(27));
        siHkkingakuSisanParamBean.setYenKihonHokenKngk(BizCurrency.valueOf(28));
        siHkkingakuSisanParamBean.setSaigaiS(BizCurrency.valueOf(29));
        siHkkingakuSisanParamBean.setYenSaigaiS(BizCurrency.valueOf(30));
        siHkkingakuSisanParamBean.setHknKknKbn(C_HknKknKbn.DAI2HKNKKN);
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.JPY);
        SiSetUiBean.setSiharaiKingakuKeisanResult(kingakuInfoUiBeanParamImpl, siHkkingakuSisanParamBean);

        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getHokenryoustgk(), BizCurrency.valueOf(21),
            "保険料相当額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYenhokenryoustgk(), BizCurrency.optional(),
            " 円換算保険料相当額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getTutakngk(), BizCurrency.valueOf(23),
            "積立金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYentutakngk(), BizCurrency.optional(),
            "円換算積立金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getKaiyakuhr(), BizCurrency.valueOf(25),
            "解約返戻金");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYenkaiyakuhr(), BizCurrency.optional(),
            "円換算解約返戻金");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getKihonhokenkngk(), BizCurrency.valueOf(27),
            "基本保険金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYenkihonhokenkngk(), BizCurrency.optional(),
            "円換算基本保険金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getSaigais(), BizCurrency.optional(),
            "災害保険金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYensaigais(), BizCurrency.optional(),
            "円換算災害保険金額");

    }

    @Test
    @TestOrder(130)
    public void testSetSiharaiKingakuKeisanResult_A13() {

        ViewKingakuInfoUiBeanParamImpl kingakuInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewKingakuInfoUiBeanParamImpl.class);
        kingakuInfoUiBeanParamImpl.setHokenryoustgk(BizCurrency.valueOf(11));
        kingakuInfoUiBeanParamImpl.setYenhokenryoustgk(BizCurrency.valueOf(12));
        kingakuInfoUiBeanParamImpl.setTutakngk(BizCurrency.valueOf(13));
        kingakuInfoUiBeanParamImpl.setYentutakngk(BizCurrency.valueOf(14));
        kingakuInfoUiBeanParamImpl.setKaiyakuhr(BizCurrency.valueOf(15));
        kingakuInfoUiBeanParamImpl.setYenkaiyakuhr(BizCurrency.valueOf(16));
        kingakuInfoUiBeanParamImpl.setKihonhokenkngk(BizCurrency.valueOf(17));
        kingakuInfoUiBeanParamImpl.setYenkihonhokenkngk(BizCurrency.valueOf(18));
        kingakuInfoUiBeanParamImpl.setSaigais(BizCurrency.valueOf(19));
        kingakuInfoUiBeanParamImpl.setYensaigais(BizCurrency.valueOf(20));

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);
        siHkkingakuSisanParamBean.setHokenryoustGk(BizCurrency.valueOf(21));
        siHkkingakuSisanParamBean.setYenHokenryoustGk(BizCurrency.valueOf(22));
        siHkkingakuSisanParamBean.setTutaknGk(BizCurrency.valueOf(23));
        siHkkingakuSisanParamBean.setYenTutaknGk(BizCurrency.valueOf(24));
        siHkkingakuSisanParamBean.setKaiyakuHr(BizCurrency.valueOf(25));
        siHkkingakuSisanParamBean.setYenKaiyakuHr(BizCurrency.valueOf(26));
        siHkkingakuSisanParamBean.setKihonHokenKngk(BizCurrency.valueOf(27));
        siHkkingakuSisanParamBean.setYenKihonHokenKngk(BizCurrency.valueOf(28));
        siHkkingakuSisanParamBean.setSaigaiS(BizCurrency.valueOf(29));
        siHkkingakuSisanParamBean.setYenSaigaiS(BizCurrency.valueOf(30));
        siHkkingakuSisanParamBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.JPY);
        SiSetUiBean.setSiharaiKingakuKeisanResult(kingakuInfoUiBeanParamImpl, siHkkingakuSisanParamBean);

        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getHokenryoustgk(), BizCurrency.valueOf(21),
            "保険料相当額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYenhokenryoustgk(), BizCurrency.optional(),
            " 円換算保険料相当額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getTutakngk(), BizCurrency.valueOf(23),
            "積立金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYentutakngk(), BizCurrency.optional(),
            "円換算積立金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getKaiyakuhr(), BizCurrency.valueOf(25),
            "解約返戻金");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYenkaiyakuhr(), BizCurrency.optional(),
            "円換算解約返戻金");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getKihonhokenkngk(), BizCurrency.valueOf(27),
            "基本保険金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYenkihonhokenkngk(), BizCurrency.optional(),
            "円換算基本保険金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getSaigais(), BizCurrency.valueOf(29),
            "災害保険金額");
        exBizCalcbleEquals(kingakuInfoUiBeanParamImpl.getYensaigais(), BizCurrency.optional(),
            "円換算災害保険金額");

    }

}
