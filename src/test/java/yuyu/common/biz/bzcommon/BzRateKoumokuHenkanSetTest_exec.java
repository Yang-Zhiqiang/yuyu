package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_RyourituKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * レート用項目変換設定クラスのメソッド {@link BzRateKoumokuHenkanSet#exec(String, String, BizNumber, C_Hrkkaisuu, C_Hhknsei, int,
 * C_HknkknsmnKbn, int, int, C_Kykjyoutai, C_Tuukasyu, int, C_RyourituKbn, C_NaiteiKakuteiKbn)} テスト用クラスです。 <br />
 */
@RunWith(OrderedRunner.class)
public class BzRateKoumokuHenkanSetTest_exec {

    @Inject
    private BzRateKoumokuHenkanSet bzRateKoumokuHenkanSet;

    @Test
    @TestOrder(10)
    public void testExce_A1() {

        String syouhncd = "W1c";

        String ryouritusdno = "K1";

        BizNumber yoteiriritu = BizNumber.valueOf(0.005);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_Hhknsei hhknsei = C_Hhknsei.MALE;

        int hhknnen = 23;

        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.SAIMANKI;

        int hknkkn = 6;

        int hrkkkn = 5;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HRKMTYUU;

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        int dai1hknkkn = 4;

        C_RyourituKbn ryouritukbn = C_RyourituKbn.OTHER;

        C_NaiteiKakuteiKbn naiteikakuteikbn = C_NaiteiKakuteiKbn.KAKUTEI;

        BzRateKoumokuHenkanSetBean bean = bzRateKoumokuHenkanSet.exec(syouhncd, ryouritusdno, yoteiriritu, hrkkaisuu,
            hhknsei, hhknnen, hknkknsmnkbn, hknkkn, hrkkkn, kykjyoutai, tuukasyu, dai1hknkkn, ryouritukbn, naiteikakuteikbn);

        exStringEquals(bean.getHknsyukigou(),"W1","保険種類記号");
        exStringEquals(bean.getHokensyuruikigousdicode(),"J","保険種類記号世代コード");
        exStringEquals(bean.getYoteiriritu(),"050","予定利率");
        exStringEquals(bean.getHrkkaisuu(),"0","払込回数");
        exStringEquals(bean.getHhknsei(),"1","被保険者性別");
        exStringEquals(bean.getKeiyakujihhknnen(),"023","契約時被保険者年令");
        exStringEquals(bean.getSaimankikeiyakuhyouji(),"1","才満期契約表示");
        exStringEquals(bean.getHknkkn(),"06","保険期間");
        exStringEquals(bean.getPharaikomikikan(),"05","Ｐ払込期間");
        exStringEquals(bean.getAnnaihuyouriyuukbn(),"00","案内不要理由区分");
        exStringEquals(bean.getTuukasyukbn(),"1","通貨種類区分");
        exStringEquals(bean.getDai1hknkkn(),"04","第１保険期間");
        exStringEquals(bean.getRyouritukbn(),"0","料率区分");
        exStringEquals(bean.getPaldratenaikakucode(),"0","Ｄレート内定確定コード");

    }

    @Test
    @TestOrder(20)
    public void testExce_A2() {

        String syouhncd = null;

        String ryouritusdno = null;

        BizNumber yoteiriritu = null;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.HALFY;

        C_Hhknsei hhknsei = C_Hhknsei.FEMALE;

        int hhknnen = 123;

        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.NENMANKI;

        int hknkkn = 66;

        int hrkkkn = 55;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HARAIMAN;

        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;

        int dai1hknkkn = 44;

        C_RyourituKbn ryouritukbn = C_RyourituKbn.DANTAI_A;

        C_NaiteiKakuteiKbn naiteikakuteikbn = C_NaiteiKakuteiKbn.NAITEI;

        BzRateKoumokuHenkanSetBean bean = bzRateKoumokuHenkanSet.exec(syouhncd, ryouritusdno, yoteiriritu, hrkkaisuu,
            hhknsei, hhknnen, hknkknsmnkbn, hknkkn, hrkkkn, kykjyoutai, tuukasyu, dai1hknkkn, ryouritukbn, naiteikakuteikbn);

        exStringEquals(bean.getHknsyukigou(),null,"保険種類記号");
        exStringEquals(bean.getHokensyuruikigousdicode(),null,"保険種類記号世代コード");
        exStringEquals(bean.getYoteiriritu(),null,"予定利率");
        exStringEquals(bean.getHrkkaisuu(),"3","払込回数");
        exStringEquals(bean.getHhknsei(),"2","被保険者性別");
        exStringEquals(bean.getKeiyakujihhknnen(),"123","契約時被保険者年令");
        exStringEquals(bean.getSaimankikeiyakuhyouji(),"0","才満期契約表示");
        exStringEquals(bean.getHknkkn(),"66","保険期間");
        exStringEquals(bean.getPharaikomikikan(),"55","Ｐ払込期間");
        exStringEquals(bean.getAnnaihuyouriyuukbn(),"02","案内不要理由区分");
        exStringEquals(bean.getTuukasyukbn(),"2","通貨種類区分");
        exStringEquals(bean.getDai1hknkkn(),"44","第１保険期間");
        exStringEquals(bean.getRyouritukbn(),"1","料率区分");
        exStringEquals(bean.getPaldratenaikakucode(),"1","Ｄレート内定確定コード");

    }

    @Test
    @TestOrder(30)
    public void testExce_A3() {

        String syouhncd = "W3";

        String ryouritusdno = "A";

        BizNumber yoteiriritu = BizNumber.valueOf(0.05);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.NEN;

        C_Hhknsei hhknsei = C_Hhknsei.BLNK;

        int hhknnen = 1234;

        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.BLNK;

        int hknkkn = 666;

        int hrkkkn = 555;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;

        C_Tuukasyu tuukasyu = C_Tuukasyu.EUR;

        int dai1hknkkn = 444;

        C_RyourituKbn ryouritukbn = C_RyourituKbn.DANTAI_B;

        C_NaiteiKakuteiKbn naiteikakuteikbn = C_NaiteiKakuteiKbn.BLNK;

        BzRateKoumokuHenkanSetBean bean = bzRateKoumokuHenkanSet.exec(syouhncd, ryouritusdno, yoteiriritu, hrkkaisuu,
            hhknsei, hhknnen, hknkknsmnkbn, hknkkn, hrkkkn, kykjyoutai, tuukasyu, dai1hknkkn, ryouritukbn, naiteikakuteikbn);

        exStringEquals(bean.getHknsyukigou(),"W3","保険種類記号");
        exStringEquals(bean.getHokensyuruikigousdicode(),"A","保険種類記号世代コード");
        exStringEquals(bean.getYoteiriritu(),"500","予定利率");
        exStringEquals(bean.getHrkkaisuu(),"3","払込回数");
        exStringEquals(bean.getHhknsei(),null,"被保険者性別");
        exStringEquals(bean.getKeiyakujihhknnen(),"1234","契約時被保険者年令");
        exStringEquals(bean.getSaimankikeiyakuhyouji(),null,"才満期契約表示");
        exStringEquals(bean.getHknkkn(),"666","保険期間");
        exStringEquals(bean.getPharaikomikikan(),"555","Ｐ払込期間");
        exStringEquals(bean.getAnnaihuyouriyuukbn(),"01","案内不要理由区分");
        exStringEquals(bean.getTuukasyukbn(),"3","通貨種類区分");
        exStringEquals(bean.getDai1hknkkn(),"444","第１保険期間");
        exStringEquals(bean.getRyouritukbn(),"2","料率区分");
        exStringEquals(bean.getPaldratenaikakucode(),null,"Ｄレート内定確定コード");

    }

    @Test
    @TestOrder(40)
    public void testExce_A4() {

        String syouhncd = "W4";

        String ryouritusdno = "A";

        BizNumber yoteiriritu = BizNumber.valueOf(0.5);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_Hhknsei hhknsei = C_Hhknsei.MALE;

        int hhknnen = 23;

        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.SAIMANKI;

        int hknkkn = 6;

        int hrkkkn = 5;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HARAIZUMI;

        C_Tuukasyu tuukasyu = C_Tuukasyu.AUD;

        int dai1hknkkn = 4;

        C_RyourituKbn ryouritukbn = C_RyourituKbn.KOUHURI;

        C_NaiteiKakuteiKbn naiteikakuteikbn = C_NaiteiKakuteiKbn.KAKUTEI;

        BzRateKoumokuHenkanSetBean bean = bzRateKoumokuHenkanSet.exec(syouhncd, ryouritusdno, yoteiriritu, hrkkaisuu,
            hhknsei, hhknnen, hknkknsmnkbn, hknkkn, hrkkkn, kykjyoutai, tuukasyu, dai1hknkkn, ryouritukbn, naiteikakuteikbn);

        exStringEquals(bean.getHknsyukigou(),"W4","保険種類記号");
        exStringEquals(bean.getHokensyuruikigousdicode(),"A","保険種類記号世代コード");
        exStringEquals(bean.getYoteiriritu(),"5000","予定利率");
        exStringEquals(bean.getHrkkaisuu(),"3","払込回数");
        exStringEquals(bean.getHhknsei(),"1","被保険者性別");
        exStringEquals(bean.getKeiyakujihhknnen(),"023","契約時被保険者年令");
        exStringEquals(bean.getSaimankikeiyakuhyouji(),"1","才満期契約表示");
        exStringEquals(bean.getHknkkn(),"06","保険期間");
        exStringEquals(bean.getPharaikomikikan(),"05","Ｐ払込期間");
        exStringEquals(bean.getAnnaihuyouriyuukbn(),null,"案内不要理由区分");
        exStringEquals(bean.getTuukasyukbn(),"4","通貨種類区分");
        exStringEquals(bean.getDai1hknkkn(),"04","第１保険期間");
        exStringEquals(bean.getRyouritukbn(),"3","料率区分");
        exStringEquals(bean.getPaldratenaikakucode(),"0","Ｄレート内定確定コード");

    }

    @Test
    @TestOrder(50)
    public void testExce_A5() {

        String syouhncd = "W5";

        String ryouritusdno = "A";

        BizNumber yoteiriritu = BizNumber.valueOf(0.005);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        C_Hhknsei hhknsei = C_Hhknsei.MALE;

        int hhknnen = 23;

        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.SAIMANKI;

        int hknkkn = 6;

        int hrkkkn = 5;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HRKMTYUU;

        C_Tuukasyu tuukasyu = C_Tuukasyu.BLNK;

        int dai1hknkkn = 4;

        C_RyourituKbn ryouritukbn = C_RyourituKbn.SYUUDAN;

        C_NaiteiKakuteiKbn naiteikakuteikbn = C_NaiteiKakuteiKbn.KAKUTEI;

        BzRateKoumokuHenkanSetBean bean = bzRateKoumokuHenkanSet.exec(syouhncd, ryouritusdno, yoteiriritu, hrkkaisuu,
            hhknsei, hhknnen, hknkknsmnkbn, hknkkn, hrkkkn, kykjyoutai, tuukasyu, dai1hknkkn, ryouritukbn, naiteikakuteikbn);

        exStringEquals(bean.getHknsyukigou(),"W5","保険種類記号");
        exStringEquals(bean.getHokensyuruikigousdicode(),"A","保険種類記号世代コード");
        exStringEquals(bean.getYoteiriritu(),"050","予定利率");
        exStringEquals(bean.getHrkkaisuu(),null,"払込回数");
        exStringEquals(bean.getHhknsei(),"1","被保険者性別");
        exStringEquals(bean.getKeiyakujihhknnen(),"023","契約時被保険者年令");
        exStringEquals(bean.getSaimankikeiyakuhyouji(),"1","才満期契約表示");
        exStringEquals(bean.getHknkkn(),"06","保険期間");
        exStringEquals(bean.getPharaikomikikan(),"05","Ｐ払込期間");
        exStringEquals(bean.getAnnaihuyouriyuukbn(),"00","案内不要理由区分");
        exStringEquals(bean.getTuukasyukbn(),null,"通貨種類区分");
        exStringEquals(bean.getDai1hknkkn(),"04","第１保険期間");
        exStringEquals(bean.getRyouritukbn(),"4","料率区分");
        exStringEquals(bean.getPaldratenaikakucode(),"0","Ｄレート内定確定コード");

    }

    @Test
    @TestOrder(60)
    public void testExce_A6() {

        String syouhncd = "W6";

        String ryouritusdno = "A";

        BizNumber yoteiriritu = BizNumber.valueOf(0.005);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_Hhknsei hhknsei = C_Hhknsei.MALE;

        int hhknnen = 23;

        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.SAIMANKI;

        int hknkkn = 6;

        int hrkkkn = 5;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HRKMTYUU;

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        int dai1hknkkn = 4;

        C_RyourituKbn ryouritukbn = C_RyourituKbn.CREDIT;

        C_NaiteiKakuteiKbn naiteikakuteikbn = C_NaiteiKakuteiKbn.KAKUTEI;

        BzRateKoumokuHenkanSetBean bean = bzRateKoumokuHenkanSet.exec(syouhncd, ryouritusdno, yoteiriritu, hrkkaisuu,
            hhknsei, hhknnen, hknkknsmnkbn, hknkkn, hrkkkn, kykjyoutai, tuukasyu, dai1hknkkn, ryouritukbn, naiteikakuteikbn);

        exStringEquals(bean.getHknsyukigou(),"W6","保険種類記号");
        exStringEquals(bean.getHokensyuruikigousdicode(),"A","保険種類記号世代コード");
        exStringEquals(bean.getYoteiriritu(),"050","予定利率");
        exStringEquals(bean.getHrkkaisuu(),"0","払込回数");
        exStringEquals(bean.getHhknsei(),"1","被保険者性別");
        exStringEquals(bean.getKeiyakujihhknnen(),"023","契約時被保険者年令");
        exStringEquals(bean.getSaimankikeiyakuhyouji(),"1","才満期契約表示");
        exStringEquals(bean.getHknkkn(),"06","保険期間");
        exStringEquals(bean.getPharaikomikikan(),"05","Ｐ払込期間");
        exStringEquals(bean.getAnnaihuyouriyuukbn(),"00","案内不要理由区分");
        exStringEquals(bean.getTuukasyukbn(),"1","通貨種類区分");
        exStringEquals(bean.getDai1hknkkn(),"04","第１保険期間");
        exStringEquals(bean.getRyouritukbn(),"5","料率区分");
        exStringEquals(bean.getPaldratenaikakucode(),"0","Ｄレート内定確定コード");

    }

    @Test
    @TestOrder(70)
    public void testExce_A7() {

        String syouhncd = "W7";

        String ryouritusdno = "A";

        BizNumber yoteiriritu = BizNumber.valueOf(0.005);

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_Hhknsei hhknsei = C_Hhknsei.MALE;

        int hhknnen = 23;

        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.SAIMANKI;

        int hknkkn = 6;

        int hrkkkn = 5;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HRKMTYUU;

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        int dai1hknkkn = 4;

        C_RyourituKbn ryouritukbn = C_RyourituKbn.BLNK;

        C_NaiteiKakuteiKbn naiteikakuteikbn = C_NaiteiKakuteiKbn.KAKUTEI;

        BzRateKoumokuHenkanSetBean bean = bzRateKoumokuHenkanSet.exec(syouhncd, ryouritusdno, yoteiriritu, hrkkaisuu,
            hhknsei, hhknnen, hknkknsmnkbn, hknkkn, hrkkkn, kykjyoutai, tuukasyu, dai1hknkkn, ryouritukbn, naiteikakuteikbn);

        exStringEquals(bean.getHknsyukigou(),"W7","保険種類記号");
        exStringEquals(bean.getHokensyuruikigousdicode(),"A","保険種類記号世代コード");
        exStringEquals(bean.getYoteiriritu(),"050","予定利率");
        exStringEquals(bean.getHrkkaisuu(),"0","払込回数");
        exStringEquals(bean.getHhknsei(),"1","被保険者性別");
        exStringEquals(bean.getKeiyakujihhknnen(),"023","契約時被保険者年令");
        exStringEquals(bean.getSaimankikeiyakuhyouji(),"1","才満期契約表示");
        exStringEquals(bean.getHknkkn(),"06","保険期間");
        exStringEquals(bean.getPharaikomikikan(),"05","Ｐ払込期間");
        exStringEquals(bean.getAnnaihuyouriyuukbn(),"00","案内不要理由区分");
        exStringEquals(bean.getTuukasyukbn(),"1","通貨種類区分");
        exStringEquals(bean.getDai1hknkkn(),"04","第１保険期間");
        exStringEquals(bean.getRyouritukbn(),null,"料率区分");
        exStringEquals(bean.getPaldratenaikakucode(),"0","Ｄレート内定確定コード");

    }

}
