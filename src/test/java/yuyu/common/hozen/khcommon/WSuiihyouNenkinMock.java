package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.db.entity.IT_Suiihyou;

/**
 * {@link WSuiihyouNenkin}のモッククラスです。<br />
 */
public class WSuiihyouNenkinMock extends WSuiihyouNenkin{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public List<IT_Suiihyou> exec(WSuiihyouParam pWSuiihyouParam) {

        List<IT_Suiihyou> suiihyouLst = new ArrayList<>();

        if (caller == EditSuiihyouTblTest_editTBL.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {

                IT_Suiihyou suiihyou0 = new IT_Suiihyou();
                suiihyou0.setKeikanensuu(1);
                suiihyou0.setCalckijyunymd(BizDate.valueOf(20160505));
                suiihyou0.setCalcym(BizDateYM.valueOf(201605));
                suiihyou0.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARI);
                suiihyou0.setSjkkktusirrtup(BizNumber.valueOf(10));
                suiihyou0.setSjkkktusirrtsame(BizNumber.valueOf(11));
                suiihyou0.setSjkkktusirrtdown(BizNumber.valueOf(12));
                suiihyou0.setSjkkktusirrthendouup(BizNumber.valueOf(13));
                suiihyou0.setSjkkktusirrthendoudown(BizNumber.valueOf(14));
                suiihyou0.setYenknsnkwsrateyendaka(BizNumber.valueOf(15));
                suiihyou0.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(16));
                suiihyou0.setYenknsnkwsrateyenyasu(BizNumber.valueOf(17));
                suiihyou0.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(200000));
                suiihyou0.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(201010));
                suiihyou0.setMvaariwup(BizCurrency.valueOf(101010));
                suiihyou0.setMvaariwsame(BizCurrency.valueOf(100000));
                suiihyou0.setMvaariwdown(BizCurrency.valueOf(212121));
                suiihyou0.setMvaariwyenupyendaka(BizCurrency.valueOf(202222));
                suiihyou0.setMvaariwyenupyenkijyun(BizCurrency.valueOf(454544));
                suiihyou0.setMvaariwyenupyenyasu(BizCurrency.valueOf(555555));
                suiihyou0.setMvaariwyensameyendaka(BizCurrency.valueOf(414141));
                suiihyou0.setMvaariwyensameyenkijyun(BizCurrency.valueOf(575755));
                suiihyou0.setMvaariwyensameyenyasu(BizCurrency.valueOf(577755));
                suiihyou0.setMvaariwyendownyendaka(BizCurrency.valueOf(847474));
                suiihyou0.setMvaariwyendownyenkijyun(BizCurrency.valueOf(785757));
                suiihyou0.setMvaariwyendownyenyasu(BizCurrency.valueOf(456343));
                suiihyou0.setMvaariptumitatekin(BizCurrency.valueOf(421758));
                suiihyou0.setMvanonewsame(BizCurrency.valueOf(453444));
                suiihyou0.setMvanonewyensameyendaka(BizCurrency.valueOf(444444));
                suiihyou0.setMvanonewyensameyenkijyun(BizCurrency.valueOf(788787));
                suiihyou0.setMvanonewyensameyenyasu(BizCurrency.valueOf(787878));
                suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(787878));
                suiihyou0.setMkhyouyensysnikougk(BizCurrency.valueOf(18));

                IT_Suiihyou suiihyou1 = new IT_Suiihyou();
                suiihyou1.setKeikanensuu(2);
                suiihyou1.setCalckijyunymd(BizDate.valueOf(20160505));
                suiihyou1.setCalcym(BizDateYM.valueOf(201605));
                suiihyou1.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.BLNK);
                suiihyou1.setSjkkktusirrtup(BizNumber.valueOf(20));
                suiihyou1.setSjkkktusirrtsame(BizNumber.valueOf(21));
                suiihyou1.setSjkkktusirrtdown(BizNumber.valueOf(22));
                suiihyou1.setSjkkktusirrthendouup(BizNumber.valueOf(23));
                suiihyou1.setSjkkktusirrthendoudown(BizNumber.valueOf(24));
                suiihyou1.setYenknsnkwsrateyendaka(BizNumber.valueOf(25));
                suiihyou1.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(26));
                suiihyou1.setYenknsnkwsrateyenyasu(BizNumber.valueOf(27));
                suiihyou1.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(200000));
                suiihyou1.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(201010));
                suiihyou1.setMvaariwup(BizCurrency.valueOf(101010));
                suiihyou1.setMvaariwsame(BizCurrency.valueOf(100000));
                suiihyou1.setMvaariwdown(BizCurrency.valueOf(212121));
                suiihyou1.setMvaariwyenupyendaka(BizCurrency.valueOf(202222));
                suiihyou1.setMvaariwyenupyenkijyun(BizCurrency.valueOf(454544));
                suiihyou1.setMvaariwyenupyenyasu(BizCurrency.valueOf(555555));
                suiihyou1.setMvaariwyensameyendaka(BizCurrency.valueOf(414141));
                suiihyou1.setMvaariwyensameyenkijyun(BizCurrency.valueOf(575755));
                suiihyou1.setMvaariwyensameyenyasu(BizCurrency.valueOf(577755));
                suiihyou1.setMvaariwyendownyendaka(BizCurrency.valueOf(847474));
                suiihyou1.setMvaariwyendownyenkijyun(BizCurrency.valueOf(785757));
                suiihyou1.setMvaariwyendownyenyasu(BizCurrency.valueOf(456343));
                suiihyou1.setMvaariptumitatekin(BizCurrency.valueOf(421758));
                suiihyou1.setMvanonewsame(BizCurrency.valueOf(453444));
                suiihyou1.setMvanonewyensameyendaka(BizCurrency.valueOf(444444));
                suiihyou1.setMvanonewyensameyenkijyun(BizCurrency.valueOf(788787));
                suiihyou1.setMvanonewyensameyenyasu(BizCurrency.valueOf(787878));
                suiihyou1.setMvanoneptumitatekin(BizCurrency.valueOf(787878));
                suiihyou1.setMkhyouyensysnikougk(BizCurrency.valueOf(28));

                IT_Suiihyou suiihyou2 = new IT_Suiihyou();
                suiihyou2.setKeikanensuu(3);
                suiihyou2.setCalckijyunymd(BizDate.valueOf(20160505));
                suiihyou2.setCalcym(BizDateYM.valueOf(201605));
                suiihyou2.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.BLNK);
                suiihyou2.setSjkkktusirrtup(BizNumber.valueOf(30));
                suiihyou2.setSjkkktusirrtsame(BizNumber.valueOf(31));
                suiihyou2.setSjkkktusirrtdown(BizNumber.valueOf(32));
                suiihyou2.setSjkkktusirrthendouup(BizNumber.valueOf(33));
                suiihyou2.setSjkkktusirrthendoudown(BizNumber.valueOf(34));
                suiihyou2.setYenknsnkwsrateyendaka(BizNumber.valueOf(35));
                suiihyou2.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(36));
                suiihyou2.setYenknsnkwsrateyenyasu(BizNumber.valueOf(37));
                suiihyou2.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(200000));
                suiihyou2.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(201010));
                suiihyou2.setMvaariwup(BizCurrency.valueOf(101010));
                suiihyou2.setMvaariwsame(BizCurrency.valueOf(100000));
                suiihyou2.setMvaariwdown(BizCurrency.valueOf(212121));
                suiihyou2.setMvaariwyenupyendaka(BizCurrency.valueOf(202222));
                suiihyou2.setMvaariwyenupyenkijyun(BizCurrency.valueOf(454544));
                suiihyou2.setMvaariwyenupyenyasu(BizCurrency.valueOf(555555));
                suiihyou2.setMvaariwyensameyendaka(BizCurrency.valueOf(414141));
                suiihyou2.setMvaariwyensameyenkijyun(BizCurrency.valueOf(575755));
                suiihyou2.setMvaariwyensameyenyasu(BizCurrency.valueOf(577755));
                suiihyou2.setMvaariwyendownyendaka(BizCurrency.valueOf(847474));
                suiihyou2.setMvaariwyendownyenkijyun(BizCurrency.valueOf(785757));
                suiihyou2.setMvaariwyendownyenyasu(BizCurrency.valueOf(456343));
                suiihyou2.setMvaariptumitatekin(BizCurrency.valueOf(421758));
                suiihyou2.setMvanonewsame(BizCurrency.valueOf(453444));
                suiihyou2.setMvanonewyensameyendaka(BizCurrency.valueOf(444444));
                suiihyou2.setMvanonewyensameyenkijyun(BizCurrency.valueOf(788787));
                suiihyou2.setMvanonewyensameyenyasu(BizCurrency.valueOf(787878));
                suiihyou2.setMvanoneptumitatekin(BizCurrency.valueOf(787878));
                suiihyou2.setMkhyouyensysnikougk(BizCurrency.valueOf(38));

                IT_Suiihyou suiihyou3 = new IT_Suiihyou();
                suiihyou3.setKeikanensuu(4);
                suiihyou3.setCalckijyunymd(BizDate.valueOf(20160505));
                suiihyou3.setCalcym(BizDateYM.valueOf(201605));
                suiihyou3.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.BLNK);
                suiihyou3.setSjkkktusirrtup(BizNumber.valueOf(40));
                suiihyou3.setSjkkktusirrtsame(BizNumber.valueOf(41));
                suiihyou3.setSjkkktusirrtdown(BizNumber.valueOf(42));
                suiihyou3.setSjkkktusirrthendouup(BizNumber.valueOf(43));
                suiihyou3.setSjkkktusirrthendoudown(BizNumber.valueOf(44));
                suiihyou3.setYenknsnkwsrateyendaka(BizNumber.valueOf(45));
                suiihyou3.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(46));
                suiihyou3.setYenknsnkwsrateyenyasu(BizNumber.valueOf(47));
                suiihyou3.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(200000));
                suiihyou3.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(201010));
                suiihyou3.setMvaariwup(BizCurrency.valueOf(101010));
                suiihyou3.setMvaariwsame(BizCurrency.valueOf(100000));
                suiihyou3.setMvaariwdown(BizCurrency.valueOf(212121));
                suiihyou3.setMvaariwyenupyendaka(BizCurrency.valueOf(202222));
                suiihyou3.setMvaariwyenupyenkijyun(BizCurrency.valueOf(454544));
                suiihyou3.setMvaariwyenupyenyasu(BizCurrency.valueOf(555555));
                suiihyou3.setMvaariwyensameyendaka(BizCurrency.valueOf(414141));
                suiihyou3.setMvaariwyensameyenkijyun(BizCurrency.valueOf(575755));
                suiihyou3.setMvaariwyensameyenyasu(BizCurrency.valueOf(577755));
                suiihyou3.setMvaariwyendownyendaka(BizCurrency.valueOf(847474));
                suiihyou3.setMvaariwyendownyenkijyun(BizCurrency.valueOf(785757));
                suiihyou3.setMvaariwyendownyenyasu(BizCurrency.valueOf(456343));
                suiihyou3.setMvaariptumitatekin(BizCurrency.valueOf(421758));
                suiihyou3.setMvanonewsame(BizCurrency.valueOf(453444));
                suiihyou3.setMvanonewyensameyendaka(BizCurrency.valueOf(444444));
                suiihyou3.setMvanonewyensameyenkijyun(BizCurrency.valueOf(788787));
                suiihyou3.setMvanonewyensameyenyasu(BizCurrency.valueOf(787878));
                suiihyou3.setMvanoneptumitatekin(BizCurrency.valueOf(787878));
                suiihyou3.setMkhyouyensysnikougk(BizCurrency.valueOf(48));

                IT_Suiihyou suiihyou4 = new IT_Suiihyou();
                suiihyou4.setKeikanensuu(5);
                suiihyou4.setCalckijyunymd(BizDate.valueOf(20160505));
                suiihyou4.setCalcym(BizDateYM.valueOf(201605));
                suiihyou4.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARINONE);
                suiihyou4.setSjkkktusirrtup(BizNumber.valueOf(50));
                suiihyou4.setSjkkktusirrtsame(BizNumber.valueOf(51));
                suiihyou4.setSjkkktusirrtdown(BizNumber.valueOf(52));
                suiihyou4.setSjkkktusirrthendouup(BizNumber.valueOf(53));
                suiihyou4.setSjkkktusirrthendoudown(BizNumber.valueOf(54));
                suiihyou4.setYenknsnkwsrateyendaka(BizNumber.valueOf(55));
                suiihyou4.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(56));
                suiihyou4.setYenknsnkwsrateyenyasu(BizNumber.valueOf(57));
                suiihyou4.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(200000));
                suiihyou4.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(201010));
                suiihyou4.setMvaariwup(BizCurrency.valueOf(101010));
                suiihyou4.setMvaariwsame(BizCurrency.valueOf(100000));
                suiihyou4.setMvaariwdown(BizCurrency.valueOf(212121));
                suiihyou4.setMvaariwyenupyendaka(BizCurrency.valueOf(202222));
                suiihyou4.setMvaariwyenupyenkijyun(BizCurrency.valueOf(454544));
                suiihyou4.setMvaariwyenupyenyasu(BizCurrency.valueOf(555555));
                suiihyou4.setMvaariwyensameyendaka(BizCurrency.valueOf(414141));
                suiihyou4.setMvaariwyensameyenkijyun(BizCurrency.valueOf(575755));
                suiihyou4.setMvaariwyensameyenyasu(BizCurrency.valueOf(577755));
                suiihyou4.setMvaariwyendownyendaka(BizCurrency.valueOf(847474));
                suiihyou4.setMvaariwyendownyenkijyun(BizCurrency.valueOf(785757));
                suiihyou4.setMvaariwyendownyenyasu(BizCurrency.valueOf(456343));
                suiihyou4.setMvaariptumitatekin(BizCurrency.valueOf(421758));
                suiihyou4.setMvanonewsame(BizCurrency.valueOf(453444));
                suiihyou4.setMvanonewyensameyendaka(BizCurrency.valueOf(444444));
                suiihyou4.setMvanonewyensameyenkijyun(BizCurrency.valueOf(788787));
                suiihyou4.setMvanonewyensameyenyasu(BizCurrency.valueOf(787878));
                suiihyou4.setMvanoneptumitatekin(BizCurrency.valueOf(787878));
                suiihyou4.setMkhyouyensysnikougk(BizCurrency.valueOf(58));

                IT_Suiihyou suiihyou5 = new IT_Suiihyou();
                suiihyou5.setKeikanensuu(6);
                suiihyou5.setCalckijyunymd(BizDate.valueOf(20160505));
                suiihyou5.setCalcym(BizDateYM.valueOf(201605));
                suiihyou5.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARI);
                suiihyou5.setSjkkktusirrtup(BizNumber.valueOf(60));
                suiihyou5.setSjkkktusirrtsame(BizNumber.valueOf(61));
                suiihyou5.setSjkkktusirrtdown(BizNumber.valueOf(62));
                suiihyou5.setSjkkktusirrthendouup(BizNumber.valueOf(63));
                suiihyou5.setSjkkktusirrthendoudown(BizNumber.valueOf(64));
                suiihyou5.setYenknsnkwsrateyendaka(BizNumber.valueOf(65));
                suiihyou5.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(66));
                suiihyou5.setYenknsnkwsrateyenyasu(BizNumber.valueOf(67));
                suiihyou5.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(200000));
                suiihyou5.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(201010));
                suiihyou5.setMvaariwup(BizCurrency.valueOf(101010));
                suiihyou5.setMvaariwsame(BizCurrency.valueOf(100000));
                suiihyou5.setMvaariwdown(BizCurrency.valueOf(212121));
                suiihyou5.setMvaariwyenupyendaka(BizCurrency.valueOf(202222));
                suiihyou5.setMvaariwyenupyenkijyun(BizCurrency.valueOf(454544));
                suiihyou5.setMvaariwyenupyenyasu(BizCurrency.valueOf(555555));
                suiihyou5.setMvaariwyensameyendaka(BizCurrency.valueOf(414141));
                suiihyou5.setMvaariwyensameyenkijyun(BizCurrency.valueOf(575755));
                suiihyou5.setMvaariwyensameyenyasu(BizCurrency.valueOf(577755));
                suiihyou5.setMvaariwyendownyendaka(BizCurrency.valueOf(847474));
                suiihyou5.setMvaariwyendownyenkijyun(BizCurrency.valueOf(785757));
                suiihyou5.setMvaariwyendownyenyasu(BizCurrency.valueOf(456343));
                suiihyou5.setMvaariptumitatekin(BizCurrency.valueOf(421758));
                suiihyou5.setMvanonewsame(BizCurrency.valueOf(453444));
                suiihyou5.setMvanonewyensameyendaka(BizCurrency.valueOf(444444));
                suiihyou5.setMvanonewyensameyenkijyun(BizCurrency.valueOf(788787));
                suiihyou5.setMvanonewyensameyenyasu(BizCurrency.valueOf(787878));
                suiihyou5.setMvanoneptumitatekin(BizCurrency.valueOf(787878));
                suiihyou5.setMkhyouyensysnikougk(BizCurrency.valueOf(68));

                IT_Suiihyou suiihyou6 = new IT_Suiihyou();
                suiihyou6.setKeikanensuu(7);
                suiihyou6.setCalckijyunymd(BizDate.valueOf(20160505));
                suiihyou6.setCalcym(BizDateYM.valueOf(201605));
                suiihyou6.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVANONE);
                suiihyou6.setSjkkktusirrtup(BizNumber.valueOf(70));
                suiihyou6.setSjkkktusirrtsame(BizNumber.valueOf(71));
                suiihyou6.setSjkkktusirrtdown(BizNumber.valueOf(72));
                suiihyou6.setSjkkktusirrthendouup(BizNumber.valueOf(73));
                suiihyou6.setSjkkktusirrthendoudown(BizNumber.valueOf(74));
                suiihyou6.setYenknsnkwsrateyendaka(BizNumber.valueOf(75));
                suiihyou6.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(76));
                suiihyou6.setYenknsnkwsrateyenyasu(BizNumber.valueOf(77));
                suiihyou6.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(200000));
                suiihyou6.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(201010));
                suiihyou6.setMvaariwup(BizCurrency.valueOf(101010));
                suiihyou6.setMvaariwsame(BizCurrency.valueOf(100000));
                suiihyou6.setMvaariwdown(BizCurrency.valueOf(212121));
                suiihyou6.setMvaariwyenupyendaka(BizCurrency.valueOf(202222));
                suiihyou6.setMvaariwyenupyenkijyun(BizCurrency.valueOf(454544));
                suiihyou6.setMvaariwyenupyenyasu(BizCurrency.valueOf(555555));
                suiihyou6.setMvaariwyensameyendaka(BizCurrency.valueOf(414141));
                suiihyou6.setMvaariwyensameyenkijyun(BizCurrency.valueOf(575755));
                suiihyou6.setMvaariwyensameyenyasu(BizCurrency.valueOf(577755));
                suiihyou6.setMvaariwyendownyendaka(BizCurrency.valueOf(847474));
                suiihyou6.setMvaariwyendownyenkijyun(BizCurrency.valueOf(785757));
                suiihyou6.setMvaariwyendownyenyasu(BizCurrency.valueOf(456343));
                suiihyou6.setMvaariptumitatekin(BizCurrency.valueOf(421758));
                suiihyou6.setMvanonewsame(BizCurrency.valueOf(453444));
                suiihyou6.setMvanonewyensameyendaka(BizCurrency.valueOf(444444));
                suiihyou6.setMvanonewyensameyenkijyun(BizCurrency.valueOf(788787));
                suiihyou6.setMvanonewyensameyenyasu(BizCurrency.valueOf(787878));
                suiihyou6.setMvanoneptumitatekin(BizCurrency.valueOf(787878));
                suiihyou6.setMkhyouyensysnikougk(BizCurrency.valueOf(78));

                IT_Suiihyou suiihyou7 = new IT_Suiihyou();
                IT_Suiihyou suiihyou8 = new IT_Suiihyou();

                IT_Suiihyou suiihyou9 = new IT_Suiihyou();
                suiihyou9.setKeikanensuu(10);
                suiihyou9.setCalckijyunymd(BizDate.valueOf(20160505));
                suiihyou9.setCalcym(BizDateYM.valueOf(201605));
                suiihyou9.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVANONE);
                suiihyou9.setSjkkktusirrtup(BizNumber.valueOf(100));
                suiihyou9.setSjkkktusirrtsame(BizNumber.valueOf(101));
                suiihyou9.setSjkkktusirrtdown(BizNumber.valueOf(102));
                suiihyou9.setSjkkktusirrthendouup(BizNumber.valueOf(103));
                suiihyou9.setSjkkktusirrthendoudown(BizNumber.valueOf(104));
                suiihyou9.setYenknsnkwsrateyendaka(BizNumber.valueOf(105));
                suiihyou9.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(106));
                suiihyou9.setYenknsnkwsrateyenyasu(BizNumber.valueOf(107));
                suiihyou9.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(200000));
                suiihyou9.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(201010));
                suiihyou9.setMvaariwup(BizCurrency.valueOf(101010));
                suiihyou9.setMvaariwsame(BizCurrency.valueOf(100000));
                suiihyou9.setMvaariwdown(BizCurrency.valueOf(212121));
                suiihyou9.setMvaariwyenupyendaka(BizCurrency.valueOf(202222));
                suiihyou9.setMvaariwyenupyenkijyun(BizCurrency.valueOf(454544));
                suiihyou9.setMvaariwyenupyenyasu(BizCurrency.valueOf(555555));
                suiihyou9.setMvaariwyensameyendaka(BizCurrency.valueOf(414141));
                suiihyou9.setMvaariwyensameyenkijyun(BizCurrency.valueOf(575755));
                suiihyou9.setMvaariwyensameyenyasu(BizCurrency.valueOf(577755));
                suiihyou9.setMvaariwyendownyendaka(BizCurrency.valueOf(847474));
                suiihyou9.setMvaariwyendownyenkijyun(BizCurrency.valueOf(785757));
                suiihyou9.setMvaariwyendownyenyasu(BizCurrency.valueOf(456343));
                suiihyou9.setMvaariptumitatekin(BizCurrency.valueOf(421758));
                suiihyou9.setMvanonewsame(BizCurrency.valueOf(453444));
                suiihyou9.setMvanonewyensameyendaka(BizCurrency.valueOf(444444));
                suiihyou9.setMvanonewyensameyenkijyun(BizCurrency.valueOf(788787));
                suiihyou9.setMvanonewyensameyenyasu(BizCurrency.valueOf(787878));
                suiihyou9.setMvanoneptumitatekin(BizCurrency.valueOf(787878));
                suiihyou9.setMkhyouyensysnikougk(BizCurrency.valueOf(108));

                IT_Suiihyou suiihyou10 = new IT_Suiihyou();
                suiihyou10.setKeikanensuu(11);
                suiihyou10.setCalckijyunymd(BizDate.valueOf(20160505));
                suiihyou10.setCalcym(BizDateYM.valueOf(201605));
                suiihyou10.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARINONE);
                suiihyou10.setSjkkktusirrtup(BizNumber.valueOf(110));
                suiihyou10.setSjkkktusirrtsame(BizNumber.valueOf(111));
                suiihyou10.setSjkkktusirrtdown(BizNumber.valueOf(112));
                suiihyou10.setSjkkktusirrthendouup(BizNumber.valueOf(113));
                suiihyou10.setSjkkktusirrthendoudown(BizNumber.valueOf(114));
                suiihyou10.setYenknsnkwsrateyendaka(BizNumber.valueOf(115));
                suiihyou10.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(116));
                suiihyou10.setYenknsnkwsrateyenyasu(BizNumber.valueOf(117));
                suiihyou10.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(200000));
                suiihyou10.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(201010));
                suiihyou10.setMvaariwup(BizCurrency.valueOf(101010));
                suiihyou10.setMvaariwsame(BizCurrency.valueOf(100000));
                suiihyou10.setMvaariwdown(BizCurrency.valueOf(212121));
                suiihyou10.setMvaariwyenupyendaka(BizCurrency.valueOf(202222));
                suiihyou10.setMvaariwyenupyenkijyun(BizCurrency.valueOf(454544));
                suiihyou10.setMvaariwyenupyenyasu(BizCurrency.valueOf(555555));
                suiihyou10.setMvaariwyensameyendaka(BizCurrency.valueOf(414141));
                suiihyou10.setMvaariwyensameyenkijyun(BizCurrency.valueOf(575755));
                suiihyou10.setMvaariwyensameyenyasu(BizCurrency.valueOf(577755));
                suiihyou10.setMvaariwyendownyendaka(BizCurrency.valueOf(847474));
                suiihyou10.setMvaariwyendownyenkijyun(BizCurrency.valueOf(785757));
                suiihyou10.setMvaariwyendownyenyasu(BizCurrency.valueOf(456343));
                suiihyou10.setMvaariptumitatekin(BizCurrency.valueOf(421758));
                suiihyou10.setMvanonewsame(BizCurrency.valueOf(453444));
                suiihyou10.setMvanonewyensameyendaka(BizCurrency.valueOf(444444));
                suiihyou10.setMvanonewyensameyenkijyun(BizCurrency.valueOf(788787));
                suiihyou10.setMvanonewyensameyenyasu(BizCurrency.valueOf(787878));
                suiihyou10.setMvanoneptumitatekin(BizCurrency.valueOf(787878));
                suiihyou10.setMkhyouyensysnikougk(BizCurrency.valueOf(118));

                IT_Suiihyou suiihyou11 = new IT_Suiihyou();
                IT_Suiihyou suiihyou12 = new IT_Suiihyou();
                IT_Suiihyou suiihyou13 = new IT_Suiihyou();
                IT_Suiihyou suiihyou14 = new IT_Suiihyou();



                IT_Suiihyou suiihyou15 = new IT_Suiihyou();
                suiihyou15.setKeikanensuu(11);
                suiihyou15.setCalckijyunymd(BizDate.valueOf(20160505));
                suiihyou15.setCalcym(BizDateYM.valueOf(201605));
                suiihyou15.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.BLNK);
                suiihyou15.setSjkkktusirrtup(BizNumber.valueOf(110));
                suiihyou15.setSjkkktusirrtsame(BizNumber.valueOf(111));
                suiihyou15.setSjkkktusirrtdown(BizNumber.valueOf(112));
                suiihyou15.setSjkkktusirrthendouup(BizNumber.valueOf(113));
                suiihyou15.setSjkkktusirrthendoudown(BizNumber.valueOf(114));
                suiihyou15.setYenknsnkwsrateyendaka(BizNumber.valueOf(115));
                suiihyou15.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(116));
                suiihyou15.setYenknsnkwsrateyenyasu(BizNumber.valueOf(117));
                suiihyou15.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(200000));
                suiihyou15.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(201010));
                suiihyou15.setMvaariwup(BizCurrency.valueOf(101010));
                suiihyou15.setMvaariwsame(BizCurrency.valueOf(100000));
                suiihyou15.setMvaariwdown(BizCurrency.valueOf(212121));
                suiihyou15.setMvaariwyenupyendaka(BizCurrency.valueOf(202222));
                suiihyou15.setMvaariwyenupyenkijyun(BizCurrency.valueOf(454544));
                suiihyou15.setMvaariwyenupyenyasu(BizCurrency.valueOf(555555));
                suiihyou15.setMvaariwyensameyendaka(BizCurrency.valueOf(414141));
                suiihyou15.setMvaariwyensameyenkijyun(BizCurrency.valueOf(575755));
                suiihyou15.setMvaariwyensameyenyasu(BizCurrency.valueOf(577755));
                suiihyou15.setMvaariwyendownyendaka(BizCurrency.valueOf(847474));
                suiihyou15.setMvaariwyendownyenkijyun(BizCurrency.valueOf(785757));
                suiihyou15.setMvaariwyendownyenyasu(BizCurrency.valueOf(456343));
                suiihyou15.setMvaariptumitatekin(BizCurrency.valueOf(421758));
                suiihyou15.setMvanonewsame(BizCurrency.valueOf(453444));
                suiihyou15.setMvanonewyensameyendaka(BizCurrency.valueOf(444444));
                suiihyou15.setMvanonewyensameyenkijyun(BizCurrency.valueOf(788787));
                suiihyou15.setMvanonewyensameyenyasu(BizCurrency.valueOf(787878));
                suiihyou15.setMvanoneptumitatekin(BizCurrency.valueOf(787878));
                suiihyou15.setMkhyouyensysnikougk(BizCurrency.valueOf(118));


                suiihyouLst.add(suiihyou0);
                suiihyouLst.add(suiihyou1);
                suiihyouLst.add(suiihyou2);
                suiihyouLst.add(suiihyou3);
                suiihyouLst.add(suiihyou4);
                suiihyouLst.add(suiihyou5);
                suiihyouLst.add(suiihyou6);
                suiihyouLst.add(suiihyou7);
                suiihyouLst.add(suiihyou8);
                suiihyouLst.add(suiihyou9);
                suiihyouLst.add(suiihyou10);
                suiihyouLst.add(suiihyou11);
                suiihyouLst.add(suiihyou12);
                suiihyouLst.add(suiihyou13);
                suiihyouLst.add(suiihyou14);
                suiihyouLst.add(suiihyou15);

                return suiihyouLst;
            }
        }

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {

            List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();
            return list;
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)) {

            List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();
            IT_Suiihyou suiihyou0 = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
            suiihyou0.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARI);
            suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
            suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
            suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

            suiihyou0.setMvanonewsame2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
            suiihyou0.setMvanonewsame(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
            suiihyou0.setMvanonewsame3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

            suiihyou0.setSjkkktusirrtsame(BizNumber.valueOf(3000));
            suiihyou0.setSjkkktusirrtup(BizNumber.valueOf(2000));
            suiihyou0.setSjkkktusirrtdown(BizNumber.valueOf(1000));

            suiihyou0.setMvaariptumitatekin2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setTutmttknutiwake11(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setTutmttknutiwake21(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
            suiihyou0.setTutmttknutiwake12(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setTutmttknutiwake22(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
            suiihyou0.setTutmttknutiwake13(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setTutmttknutiwake23(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariptumitatekin(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariptumitatekin3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwsame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwdown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwsame(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwup(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwdown(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwsame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwdown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));

            suiihyou0.setMvaariptumitatekin2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariptumitatekin(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariptumitatekin3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwsame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwdown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwsame(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwup(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwdown(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwsame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwdown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));

            list.add(suiihyou0);
            return list;
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)) {

            List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();
            IT_Suiihyou suiihyou0 = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
            suiihyou0.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARI);
            suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
            suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
            suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

            suiihyou0.setMvanonewsame2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
            suiihyou0.setMvanonewsame(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
            suiihyou0.setMvanonewsame3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

            suiihyou0.setSjkkktusirrtsame(BizNumber.valueOf(0.3));
            suiihyou0.setSjkkktusirrtup(BizNumber.valueOf(0.2));
            suiihyou0.setSjkkktusirrtdown(BizNumber.valueOf(0.1));

            suiihyou0.setMvaariptumitatekin2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setTutmttknutiwake11(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setTutmttknutiwake21(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
            suiihyou0.setTutmttknutiwake12(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setTutmttknutiwake22(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
            suiihyou0.setTutmttknutiwake13(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setTutmttknutiwake23(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariptumitatekin(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariptumitatekin3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwsame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwdown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwsame(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwup(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwdown(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwsame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwdown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));

            suiihyou0.setMvaariptumitatekin2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariptumitatekin(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariptumitatekin3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwsame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwdown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwsame(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwup(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwdown(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwsame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            suiihyou0.setMvaariwdown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));

            list.add(suiihyou0);
            return list;
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN4.equals(SYORIPTN)) {

            List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();
            IT_Suiihyou iT_Suiihyou = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
            iT_Suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVANONE);
            iT_Suiihyou.setMvanoneptumitatekin2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
            iT_Suiihyou.setMvanoneptumitatekin(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
            iT_Suiihyou.setMvanoneptumitatekin3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

            iT_Suiihyou.setMvanonewsame2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
            iT_Suiihyou.setMvanonewsame(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
            iT_Suiihyou.setMvanonewsame3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

            iT_Suiihyou.setSjkkktusirrtsame(BizNumber.valueOf(0.3));
            iT_Suiihyou.setSjkkktusirrtup(BizNumber.valueOf(0.2));
            iT_Suiihyou.setSjkkktusirrtdown(BizNumber.valueOf(0.1));

            list.add(iT_Suiihyou);
            return list;
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN5.equals(SYORIPTN)) {

            List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();

            IT_Suiihyou suiihyou0;

            for (int i = 0; i < 20; i++) {

                suiihyou0 = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                if (i == 0) {
                    suiihyou0.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARI);
                } else {
                    suiihyou0.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVANONE);
                }

                suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

                suiihyou0.setMvanonewsame2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

                if (i == 0) {
                    suiihyou0.setSjkkktusirrtsame(BizNumber.valueOf(-0.015));
                    suiihyou0.setSjkkktusirrtup(BizNumber.valueOf(-0.025));
                    suiihyou0.setSjkkktusirrtdown(BizNumber.valueOf(-0.035));
                }
                else if (i == 1) {
                    suiihyou0.setSjkkktusirrtsame(BizNumber.valueOf(0));
                    suiihyou0.setSjkkktusirrtup(BizNumber.valueOf(0));
                    suiihyou0.setSjkkktusirrtdown(BizNumber.valueOf(0));
                }

                else {
                    suiihyou0.setSjkkktusirrtsame(BizNumber.valueOf(0.03));
                    suiihyou0.setSjkkktusirrtup(BizNumber.valueOf(0.02));
                    suiihyou0.setSjkkktusirrtdown(BizNumber.valueOf(0.01));
                }

                suiihyou0.setMvaariptumitatekin2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake11(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake21(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake12(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake22(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake13(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake23(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariptumitatekin(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariptumitatekin3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));

                suiihyou0.setMvaariptumitatekin2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariptumitatekin(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariptumitatekin3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));

                list.add(suiihyou0);
            }

            return list;
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN6.equals(SYORIPTN)) {

            throw new CommonBizAppException("解約返戻金計算が実行できませんでした。");
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN7.equals(SYORIPTN)) {

            List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();

            IT_Suiihyou suiihyou0;

            for (int i = 0; i <= 50; i++) {

                suiihyou0 = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);

                suiihyou0.setKihrkmpyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                suiihyou0.setKihrkmp1(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
                suiihyou0.setZennouzndkyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame2(BizCurrency.valueOf(30, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame3(BizCurrency.valueOf(40, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(30, BizCurrencyTypes.YEN));
                suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));

                list.add(suiihyou0);
            }

            return list;
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN8.equals(SYORIPTN)) {

            List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();

            IT_Suiihyou suiihyou0;

            for (int i = 0; i <= 11; i++) {

                suiihyou0 = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);

                if (i == 0) {

                    suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(0));
                    suiihyou0.setZennouzndkyen1(null);
                    suiihyou0.setKihrkmp1(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));

                }
                else if (i == 1) {

                    suiihyou0.setZennouzndkyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                    suiihyou0.setKihrkmp1(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
                    suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));

                }
                else if (i == 3) {

                    suiihyou0.setZennouzndkyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                    suiihyou0.setKihrkmp1(BizCurrency.valueOf(3, BizCurrencyTypes.YEN));
                    suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));

                }
                else {

                    suiihyou0.setZennouzndkyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                    suiihyou0.setKihrkmp1(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
                    suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));
                }

                suiihyou0.setKihrkmpyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame2(BizCurrency.valueOf(30, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame3(BizCurrency.valueOf(40, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));


                list.add(suiihyou0);
            }

            return list;
        }

        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN9.equals(SYORIPTN)) {

            List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();

            IT_Suiihyou suiihyou0;

            for (int i = 0; i <= 11; i++) {

                suiihyou0 = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);

                if (i == 0) {

                    suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(0));
                    suiihyou0.setKihrkmp1(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
                }
                else if (i == 1) {

                    suiihyou0.setKihrkmp1(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
                    suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));

                }
                else if (i == 3) {

                    suiihyou0.setKihrkmp1(BizCurrency.valueOf(3, BizCurrencyTypes.YEN));
                    suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));

                }
                else {

                    suiihyou0.setKihrkmp1(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
                    suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));
                }

                suiihyou0.setKihrkmpyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                suiihyou0.setZennouzndkyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame2(BizCurrency.valueOf(30, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame3(BizCurrency.valueOf(40, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));


                list.add(suiihyou0);
            }

            return list;
        }
        if (caller == EditSuiihyouTblNenkinTest_editTBL.class) {
            List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();

            IT_Suiihyou suiihyou = null;
            if (TESTPATTERN1.equals(SYORIPTN)) {
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                suiihyou = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                suiihyou.setCalckijyunymd(BizDate.valueOf(20181001));
                suiihyou.setCalcym(BizDateYM.valueOf(201810));
                suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARI);
                suiihyou.setMkhyouyensysnikougk(BizCurrency.valueOf(1000));

                suiihyou.setSjkkktusirrtup2(BizNumber.valueOf(1));
                suiihyou.setSjkkktusirrtsame2(BizNumber.valueOf(2));
                suiihyou.setSjkkktusirrtdown2(BizNumber.valueOf(3));
                suiihyou.setSjkkktusirrthendouup2(BizNumber.valueOf(4));
                suiihyou.setSjkkktusirrthendoudown2(BizNumber.valueOf(5));
                suiihyou.setYenknsnkwsrateyendaka2(BizNumber.valueOf(6));
                suiihyou.setYenknsnkwsrateyenkijyun2(BizNumber.valueOf(7));
                suiihyou.setYenknsnkwsrateyenyasu2(BizNumber.valueOf(8));
                suiihyou.setYenknsnkwsrategkyendaka2(BizCurrency.valueOf(9));
                suiihyou.setYenknsnkwsrategkyenyasu2(BizCurrency.valueOf(10));
                suiihyou.setSisuuupritu2(BizNumber.valueOf(11));
                suiihyou.setTmttknzoukaritu2(BizNumber.valueOf(12));
                suiihyou.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(13));
                suiihyou.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(14));
                suiihyou.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(15));
                suiihyou.setMvaariwup2(BizCurrency.valueOf(16));
                suiihyou.setMvaariwsame2(BizCurrency.valueOf(17));
                suiihyou.setMvaariwdown2(BizCurrency.valueOf(18));
                suiihyou.setMvaariwyenupyendaka2(BizCurrency.valueOf(19));
                suiihyou.setMvaariwyenupyenkijyun2(BizCurrency.valueOf(20));
                suiihyou.setMvaariwyenupyenyasu2(BizCurrency.valueOf(21));
                suiihyou.setMvaariwyensameyendaka2(BizCurrency.valueOf(22));
                suiihyou.setMvaariwyensameyenkijyun2(BizCurrency.valueOf(23));
                suiihyou.setMvaariwyensameyenyasu2(BizCurrency.valueOf(24));
                suiihyou.setMvaariwyendownyendaka2(BizCurrency.valueOf(25));
                suiihyou.setMvaariwyendownyenkijyun2(BizCurrency.valueOf(26));
                suiihyou.setMvaariwyendownyenyasu2(BizCurrency.valueOf(27));
                suiihyou.setMvaariptumitatekin2(BizCurrency.valueOf(28));
                suiihyou.setMvanonewsame2(BizCurrency.valueOf(29));
                suiihyou.setMvanonewyensameyendaka2(BizCurrency.valueOf(30));
                suiihyou.setMvanonewyensameyenkijyun2(BizCurrency.valueOf(31));
                suiihyou.setMvanonewyensameyenyasu2(BizCurrency.valueOf(32));
                suiihyou.setMvanoneptumitatekin2(BizCurrency.valueOf(33));
                suiihyou.setTutmttknutiwake12(BizCurrency.valueOf(34));
                suiihyou.setTutmttknutiwake22(BizCurrency.valueOf(35));
                suiihyou.setSjkkktusirrtup3(BizNumber.valueOf(36));
                suiihyou.setSjkkktusirrtsame3(BizNumber.valueOf(37));
                suiihyou.setSjkkktusirrtdown3(BizNumber.valueOf(38));
                suiihyou.setSjkkktusirrthendouup3(BizNumber.valueOf(39));
                suiihyou.setSjkkktusirrthendoudown3(BizNumber.valueOf(40));
                suiihyou.setYenknsnkwsrateyendaka3(BizNumber.valueOf(41));
                suiihyou.setYenknsnkwsrateyenkijyun3(BizNumber.valueOf(42));
                suiihyou.setYenknsnkwsrateyenyasu3(BizNumber.valueOf(43));
                suiihyou.setYenknsnkwsrategkyendaka3(BizCurrency.valueOf(44));
                suiihyou.setYenknsnkwsrategkyenyasu3(BizCurrency.valueOf(45));
                suiihyou.setSisuuupritu3(BizNumber.valueOf(46));
                suiihyou.setTmttknzoukaritu3(BizNumber.valueOf(47));
                suiihyou.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(48));
                suiihyou.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(49));
                suiihyou.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(50));
                suiihyou.setMvaariwup3(BizCurrency.valueOf(51));
                suiihyou.setMvaariwsame3(BizCurrency.valueOf(52));
                suiihyou.setMvaariwdown3(BizCurrency.valueOf(53));
                suiihyou.setMvaariwyenupyendaka3(BizCurrency.valueOf(54));
                suiihyou.setMvaariwyenupyenkijyun3(BizCurrency.valueOf(55));
                suiihyou.setMvaariwyenupyenyasu3(BizCurrency.valueOf(56));
                suiihyou.setMvaariwyensameyendaka3(BizCurrency.valueOf(57));
                suiihyou.setMvaariwyensameyenkijyun3(BizCurrency.valueOf(58));
                suiihyou.setMvaariwyensameyenyasu3(BizCurrency.valueOf(59));
                suiihyou.setMvaariwyendownyendaka3(BizCurrency.valueOf(60));
                suiihyou.setMvaariwyendownyenkijyun3(BizCurrency.valueOf(61));
                suiihyou.setMvaariwyendownyenyasu3(BizCurrency.valueOf(62));
                suiihyou.setMvaariptumitatekin3(BizCurrency.valueOf(63));
                suiihyou.setMvanonewsame3(BizCurrency.valueOf(64));
                suiihyou.setMvanonewyensameyendaka3(BizCurrency.valueOf(65));
                suiihyou.setMvanonewyensameyenkijyun3(BizCurrency.valueOf(66));
                suiihyou.setMvanonewyensameyenyasu3(BizCurrency.valueOf(67));
                suiihyou.setMvanoneptumitatekin3(BizCurrency.valueOf(68));
                suiihyou.setTutmttknutiwake13(BizCurrency.valueOf(69));
                suiihyou.setTutmttknutiwake23(BizCurrency.valueOf(70));
                suiihyou.setSuiihyousyubetu("05");

                list.add(suiihyou);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                for (int i = 0; i <= 2; i++) {

                    suiihyou = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                    suiihyou.setCalckijyunymd(BizDate.valueOf(20181001));
                    suiihyou.setCalcym(BizDateYM.valueOf(201810));
                    suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARI);
                    suiihyou.setMkhyouyensysnikougk(BizCurrency.valueOf(1000));

                    suiihyou.setSjkkktusirrtup(BizNumber.valueOf(101));
                    suiihyou.setSjkkktusirrtsame(BizNumber.valueOf(102));
                    suiihyou.setSjkkktusirrtdown(BizNumber.valueOf(103));
                    suiihyou.setSjkkktusirrthendouup(BizNumber.valueOf(104));
                    suiihyou.setSjkkktusirrthendoudown(BizNumber.valueOf(105));
                    suiihyou.setYenknsnkwsrateyendaka(BizNumber.valueOf(106));
                    suiihyou.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(107));
                    suiihyou.setYenknsnkwsrateyenyasu(BizNumber.valueOf(108));
                    suiihyou.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(109));
                    suiihyou.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(110));
                    suiihyou.setMvaariwup(BizCurrency.valueOf(111));
                    suiihyou.setMvaariwsame(BizCurrency.valueOf(112));
                    suiihyou.setMvaariwdown(BizCurrency.valueOf(113));
                    suiihyou.setMvaariwyenupyendaka(BizCurrency.valueOf(114));
                    suiihyou.setMvaariwyenupyenkijyun(BizCurrency.valueOf(115));
                    suiihyou.setMvaariwyenupyenyasu(BizCurrency.valueOf(116));
                    suiihyou.setMvaariwyensameyendaka(BizCurrency.valueOf(117));
                    suiihyou.setMvaariwyensameyenkijyun(BizCurrency.valueOf(118));
                    suiihyou.setMvaariwyensameyenyasu(BizCurrency.valueOf(119));
                    suiihyou.setMvaariwyendownyendaka(BizCurrency.valueOf(120));
                    suiihyou.setMvaariwyendownyenkijyun(BizCurrency.valueOf(121));
                    suiihyou.setMvaariwyendownyenyasu(BizCurrency.valueOf(122));
                    suiihyou.setMvaariptumitatekin(BizCurrency.valueOf(123));
                    suiihyou.setMvanonewsame(BizCurrency.valueOf(124));
                    suiihyou.setMvanonewyensameyendaka(BizCurrency.valueOf(125));
                    suiihyou.setMvanonewyensameyenkijyun(BizCurrency.valueOf(126));
                    suiihyou.setMvanonewyensameyenyasu(BizCurrency.valueOf(127));
                    suiihyou.setMvanoneptumitatekin(BizCurrency.valueOf(128));
                    suiihyou.setSisuuupritu1(BizNumber.valueOf(129));
                    suiihyou.setTmttknzoukaritu1(BizNumber.valueOf(130));
                    suiihyou.setTutmttknutiwake11(BizCurrency.valueOf(131));
                    suiihyou.setTutmttknutiwake21(BizCurrency.valueOf(132));
                    suiihyou.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(133));
                    suiihyou.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(134));
                    suiihyou.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(135));

                    suiihyou.setSjkkktusirrtup2(BizNumber.valueOf(1));
                    suiihyou.setSjkkktusirrtsame2(BizNumber.valueOf(2));
                    suiihyou.setSjkkktusirrtdown2(BizNumber.valueOf(3));
                    suiihyou.setSjkkktusirrthendouup2(BizNumber.valueOf(4));
                    suiihyou.setSjkkktusirrthendoudown2(BizNumber.valueOf(5));
                    suiihyou.setYenknsnkwsrateyendaka2(BizNumber.valueOf(6));
                    suiihyou.setYenknsnkwsrateyenkijyun2(BizNumber.valueOf(7));
                    suiihyou.setYenknsnkwsrateyenyasu2(BizNumber.valueOf(8));
                    suiihyou.setYenknsnkwsrategkyendaka2(BizCurrency.valueOf(9));
                    suiihyou.setYenknsnkwsrategkyenyasu2(BizCurrency.valueOf(10));
                    suiihyou.setSisuuupritu2(BizNumber.valueOf(11));
                    suiihyou.setTmttknzoukaritu2(BizNumber.valueOf(12));
                    suiihyou.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(13));
                    suiihyou.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(14));
                    suiihyou.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(15));
                    suiihyou.setMvaariwup2(BizCurrency.valueOf(16));
                    suiihyou.setMvaariwsame2(BizCurrency.valueOf(17));
                    suiihyou.setMvaariwdown2(BizCurrency.valueOf(18));
                    suiihyou.setMvaariwyenupyendaka2(BizCurrency.valueOf(19));
                    suiihyou.setMvaariwyenupyenkijyun2(BizCurrency.valueOf(20));
                    suiihyou.setMvaariwyenupyenyasu2(BizCurrency.valueOf(21));
                    suiihyou.setMvaariwyensameyendaka2(BizCurrency.valueOf(22));
                    suiihyou.setMvaariwyensameyenkijyun2(BizCurrency.valueOf(23));
                    suiihyou.setMvaariwyensameyenyasu2(BizCurrency.valueOf(24));
                    suiihyou.setMvaariwyendownyendaka2(BizCurrency.valueOf(25));
                    suiihyou.setMvaariwyendownyenkijyun2(BizCurrency.valueOf(26));
                    suiihyou.setMvaariwyendownyenyasu2(BizCurrency.valueOf(27));
                    suiihyou.setMvaariptumitatekin2(BizCurrency.valueOf(28));
                    suiihyou.setMvanonewsame2(BizCurrency.valueOf(29));
                    suiihyou.setMvanonewyensameyendaka2(BizCurrency.valueOf(30));
                    suiihyou.setMvanonewyensameyenkijyun2(BizCurrency.valueOf(31));
                    suiihyou.setMvanonewyensameyenyasu2(BizCurrency.valueOf(32));
                    suiihyou.setMvanoneptumitatekin2(BizCurrency.valueOf(33));
                    suiihyou.setTutmttknutiwake12(BizCurrency.valueOf(34));
                    suiihyou.setTutmttknutiwake22(BizCurrency.valueOf(35));
                    suiihyou.setSjkkktusirrtup3(BizNumber.valueOf(36));
                    suiihyou.setSjkkktusirrtsame3(BizNumber.valueOf(37));
                    suiihyou.setSjkkktusirrtdown3(BizNumber.valueOf(38));
                    suiihyou.setSjkkktusirrthendouup3(BizNumber.valueOf(39));
                    suiihyou.setSjkkktusirrthendoudown3(BizNumber.valueOf(40));
                    suiihyou.setYenknsnkwsrateyendaka3(BizNumber.valueOf(41));
                    suiihyou.setYenknsnkwsrateyenkijyun3(BizNumber.valueOf(42));
                    suiihyou.setYenknsnkwsrateyenyasu3(BizNumber.valueOf(43));
                    suiihyou.setYenknsnkwsrategkyendaka3(BizCurrency.valueOf(44));
                    suiihyou.setYenknsnkwsrategkyenyasu3(BizCurrency.valueOf(45));
                    suiihyou.setSisuuupritu3(BizNumber.valueOf(46));
                    suiihyou.setTmttknzoukaritu3(BizNumber.valueOf(47));
                    suiihyou.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(48));
                    suiihyou.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(49));
                    suiihyou.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(50));
                    suiihyou.setMvaariwup3(BizCurrency.valueOf(51));
                    suiihyou.setMvaariwsame3(BizCurrency.valueOf(52));
                    suiihyou.setMvaariwdown3(BizCurrency.valueOf(53));
                    suiihyou.setMvaariwyenupyendaka3(BizCurrency.valueOf(54));
                    suiihyou.setMvaariwyenupyenkijyun3(BizCurrency.valueOf(55));
                    suiihyou.setMvaariwyenupyenyasu3(BizCurrency.valueOf(56));
                    suiihyou.setMvaariwyensameyendaka3(BizCurrency.valueOf(57));
                    suiihyou.setMvaariwyensameyenkijyun3(BizCurrency.valueOf(58));
                    suiihyou.setMvaariwyensameyenyasu3(BizCurrency.valueOf(59));
                    suiihyou.setMvaariwyendownyendaka3(BizCurrency.valueOf(60));
                    suiihyou.setMvaariwyendownyenkijyun3(BizCurrency.valueOf(61));
                    suiihyou.setMvaariwyendownyenyasu3(BizCurrency.valueOf(62));
                    suiihyou.setMvaariptumitatekin3(BizCurrency.valueOf(63));
                    suiihyou.setMvanonewsame3(BizCurrency.valueOf(64));
                    suiihyou.setMvanonewyensameyendaka3(BizCurrency.valueOf(65));
                    suiihyou.setMvanonewyensameyenkijyun3(BizCurrency.valueOf(66));
                    suiihyou.setMvanonewyensameyenyasu3(BizCurrency.valueOf(67));
                    suiihyou.setMvanoneptumitatekin3(BizCurrency.valueOf(68));
                    suiihyou.setTutmttknutiwake13(BizCurrency.valueOf(69));
                    suiihyou.setTutmttknutiwake23(BizCurrency.valueOf(70));
                    if (i == 0) {
                        suiihyou.setSuiihyousyubetu("00");
                    }
                    else if (i == 1) {
                        suiihyou.setSuiihyousyubetu("01");
                    }
                    else {
                        suiihyou.setSuiihyousyubetu("06");
                    }

                    list.add(suiihyou);
                }
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                suiihyou = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                suiihyou.setCalckijyunymd(BizDate.valueOf(20181001));
                suiihyou.setCalcym(BizDateYM.valueOf(201810));
                suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARI);
                suiihyou.setMkhyouyensysnikougk(BizCurrency.valueOf(1000));

                suiihyou.setSjkkktusirrtup(BizNumber.valueOf(101));
                suiihyou.setSjkkktusirrtsame(BizNumber.valueOf(102));
                suiihyou.setSjkkktusirrtdown(BizNumber.valueOf(103));
                suiihyou.setSjkkktusirrthendouup(BizNumber.valueOf(104));
                suiihyou.setSjkkktusirrthendoudown(BizNumber.valueOf(105));
                suiihyou.setYenknsnkwsrateyendaka(BizNumber.valueOf(106));
                suiihyou.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(107));
                suiihyou.setYenknsnkwsrateyenyasu(BizNumber.valueOf(108));
                suiihyou.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(109));
                suiihyou.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(110));
                suiihyou.setMvaariwup(BizCurrency.valueOf(111));
                suiihyou.setMvaariwsame(BizCurrency.valueOf(112));
                suiihyou.setMvaariwdown(BizCurrency.valueOf(113));
                suiihyou.setMvaariwyenupyendaka(BizCurrency.valueOf(114));
                suiihyou.setMvaariwyenupyenkijyun(BizCurrency.valueOf(115));
                suiihyou.setMvaariwyenupyenyasu(BizCurrency.valueOf(116));
                suiihyou.setMvaariwyensameyendaka(BizCurrency.valueOf(117));
                suiihyou.setMvaariwyensameyenkijyun(BizCurrency.valueOf(118));
                suiihyou.setMvaariwyensameyenyasu(BizCurrency.valueOf(119));
                suiihyou.setMvaariwyendownyendaka(BizCurrency.valueOf(120));
                suiihyou.setMvaariwyendownyenkijyun(BizCurrency.valueOf(121));
                suiihyou.setMvaariwyendownyenyasu(BizCurrency.valueOf(122));
                suiihyou.setMvaariptumitatekin(BizCurrency.valueOf(123));
                suiihyou.setMvanonewsame(BizCurrency.valueOf(124));
                suiihyou.setMvanonewyensameyendaka(BizCurrency.valueOf(125));
                suiihyou.setMvanonewyensameyenkijyun(BizCurrency.valueOf(126));
                suiihyou.setMvanonewyensameyenyasu(BizCurrency.valueOf(127));
                suiihyou.setMvanoneptumitatekin(BizCurrency.valueOf(128));
                suiihyou.setSisuuupritu1(BizNumber.valueOf(129));
                suiihyou.setTmttknzoukaritu1(BizNumber.valueOf(130));
                suiihyou.setTutmttknutiwake11(BizCurrency.valueOf(131));
                suiihyou.setTutmttknutiwake21(BizCurrency.valueOf(132));
                suiihyou.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(133));
                suiihyou.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(134));
                suiihyou.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(135));

                suiihyou.setSjkkktusirrtup2(BizNumber.valueOf(1));
                suiihyou.setSjkkktusirrtsame2(BizNumber.valueOf(2));
                suiihyou.setSjkkktusirrtdown2(BizNumber.valueOf(3));
                suiihyou.setSjkkktusirrthendouup2(BizNumber.valueOf(4));
                suiihyou.setSjkkktusirrthendoudown2(BizNumber.valueOf(5));
                suiihyou.setYenknsnkwsrateyendaka2(BizNumber.valueOf(6));
                suiihyou.setYenknsnkwsrateyenkijyun2(BizNumber.valueOf(7));
                suiihyou.setYenknsnkwsrateyenyasu2(BizNumber.valueOf(8));
                suiihyou.setYenknsnkwsrategkyendaka2(BizCurrency.valueOf(9));
                suiihyou.setYenknsnkwsrategkyenyasu2(BizCurrency.valueOf(10));
                suiihyou.setSisuuupritu2(BizNumber.valueOf(11));
                suiihyou.setTmttknzoukaritu2(BizNumber.valueOf(12));
                suiihyou.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(13));
                suiihyou.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(14));
                suiihyou.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(15));
                suiihyou.setMvaariwup2(BizCurrency.valueOf(16));
                suiihyou.setMvaariwsame2(BizCurrency.valueOf(17));
                suiihyou.setMvaariwdown2(BizCurrency.valueOf(18));
                suiihyou.setMvaariwyenupyendaka2(BizCurrency.valueOf(19));
                suiihyou.setMvaariwyenupyenkijyun2(BizCurrency.valueOf(20));
                suiihyou.setMvaariwyenupyenyasu2(BizCurrency.valueOf(21));
                suiihyou.setMvaariwyensameyendaka2(BizCurrency.valueOf(22));
                suiihyou.setMvaariwyensameyenkijyun2(BizCurrency.valueOf(23));
                suiihyou.setMvaariwyensameyenyasu2(BizCurrency.valueOf(24));
                suiihyou.setMvaariwyendownyendaka2(BizCurrency.valueOf(25));
                suiihyou.setMvaariwyendownyenkijyun2(BizCurrency.valueOf(26));
                suiihyou.setMvaariwyendownyenyasu2(BizCurrency.valueOf(27));
                suiihyou.setMvaariptumitatekin2(BizCurrency.valueOf(28));
                suiihyou.setMvanonewsame2(BizCurrency.valueOf(29));
                suiihyou.setMvanonewyensameyendaka2(BizCurrency.valueOf(30));
                suiihyou.setMvanonewyensameyenkijyun2(BizCurrency.valueOf(31));
                suiihyou.setMvanonewyensameyenyasu2(BizCurrency.valueOf(32));
                suiihyou.setMvanoneptumitatekin2(BizCurrency.valueOf(33));
                suiihyou.setTutmttknutiwake12(BizCurrency.valueOf(34));
                suiihyou.setTutmttknutiwake22(BizCurrency.valueOf(35));
                suiihyou.setSjkkktusirrtup3(BizNumber.valueOf(36));
                suiihyou.setSjkkktusirrtsame3(BizNumber.valueOf(37));
                suiihyou.setSjkkktusirrtdown3(BizNumber.valueOf(38));
                suiihyou.setSjkkktusirrthendouup3(BizNumber.valueOf(39));
                suiihyou.setSjkkktusirrthendoudown3(BizNumber.valueOf(40));
                suiihyou.setYenknsnkwsrateyendaka3(BizNumber.valueOf(41));
                suiihyou.setYenknsnkwsrateyenkijyun3(BizNumber.valueOf(42));
                suiihyou.setYenknsnkwsrateyenyasu3(BizNumber.valueOf(43));
                suiihyou.setYenknsnkwsrategkyendaka3(BizCurrency.valueOf(44));
                suiihyou.setYenknsnkwsrategkyenyasu3(BizCurrency.valueOf(45));
                suiihyou.setSisuuupritu3(BizNumber.valueOf(46));
                suiihyou.setTmttknzoukaritu3(BizNumber.valueOf(47));
                suiihyou.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(48));
                suiihyou.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(49));
                suiihyou.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(50));
                suiihyou.setMvaariwup3(BizCurrency.valueOf(51));
                suiihyou.setMvaariwsame3(BizCurrency.valueOf(52));
                suiihyou.setMvaariwdown3(BizCurrency.valueOf(53));
                suiihyou.setMvaariwyenupyendaka3(BizCurrency.valueOf(54));
                suiihyou.setMvaariwyenupyenkijyun3(BizCurrency.valueOf(55));
                suiihyou.setMvaariwyenupyenyasu3(BizCurrency.valueOf(56));
                suiihyou.setMvaariwyensameyendaka3(BizCurrency.valueOf(57));
                suiihyou.setMvaariwyensameyenkijyun3(BizCurrency.valueOf(58));
                suiihyou.setMvaariwyensameyenyasu3(BizCurrency.valueOf(59));
                suiihyou.setMvaariwyendownyendaka3(BizCurrency.valueOf(60));
                suiihyou.setMvaariwyendownyenkijyun3(BizCurrency.valueOf(61));
                suiihyou.setMvaariwyendownyenyasu3(BizCurrency.valueOf(62));
                suiihyou.setMvaariptumitatekin3(BizCurrency.valueOf(63));
                suiihyou.setMvanonewsame3(BizCurrency.valueOf(64));
                suiihyou.setMvanonewyensameyendaka3(BizCurrency.valueOf(65));
                suiihyou.setMvanonewyensameyenkijyun3(BizCurrency.valueOf(66));
                suiihyou.setMvanonewyensameyenyasu3(BizCurrency.valueOf(67));
                suiihyou.setMvanoneptumitatekin3(BizCurrency.valueOf(68));
                suiihyou.setTutmttknutiwake13(BizCurrency.valueOf(69));
                suiihyou.setTutmttknutiwake23(BizCurrency.valueOf(70));
                suiihyou.setSuiihyousyubetu("06");

                list.add(suiihyou);
            }

            return list;
        }

        return super.exec(pWSuiihyouParam);
    }

    @Override
    public List<SuiihyouExtBean> getSuiihyouExtBeanLst() {
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN5.equals(SYORIPTN)) {
            List<SuiihyouExtBean> suiihyouExtBeanList = new ArrayList<SuiihyouExtBean>();

            for (int i = 0; i < 20; i++) {

                SuiihyouExtBean suiihyouExtBean = new SuiihyouExtBean();

                if (i == 0) {
                    suiihyouExtBean.setSjkkktusirrtSame(BizNumber.valueOf(-0.015));
                    suiihyouExtBean.setSjkkktusirrtUp(BizNumber.valueOf(-0.025));
                    suiihyouExtBean.setSjkkktusirrtDown(BizNumber.valueOf(-0.035));
                }
                else if (i == 1) {
                    suiihyouExtBean.setSjkkktusirrtSame(BizNumber.valueOf(0));
                    suiihyouExtBean.setSjkkktusirrtUp(BizNumber.valueOf(0));
                    suiihyouExtBean.setSjkkktusirrtDown(BizNumber.valueOf(0));
                }
                else {
                    suiihyouExtBean.setSjkkktusirrtSame(BizNumber.valueOf(0.03));
                    suiihyouExtBean.setSjkkktusirrtUp(BizNumber.valueOf(0.02));
                    suiihyouExtBean.setSjkkktusirrtDown(BizNumber.valueOf(0.01));
                }

                suiihyouExtBean.setSjkkktusirrtHendouUp(null);
                suiihyouExtBean.setSjkkktusirrtHendouDown(null);
                suiihyouExtBean.setSisuuUpRitu(null);
                suiihyouExtBean.setMvaAriPTumitatekin(BizCurrency.valueOf(40000, BizCurrencyTypes.YEN));
                suiihyouExtBean.setMvaAriTmttkgkKykkjmaeUp(BizCurrency.valueOf(41000, BizCurrencyTypes.YEN));
                suiihyouExtBean.setMvaAriTmttkgkKykkjmaeSame(BizCurrency.valueOf(42000, BizCurrencyTypes.YEN));
                suiihyouExtBean.setMvaAriTmttkgkKykjmaeDown(BizCurrency.valueOf(43000, BizCurrencyTypes.YEN));
                suiihyouExtBean.setMvaAriWUp(BizCurrency.valueOf(44000, BizCurrencyTypes.YEN));
                suiihyouExtBean.setMvaAriWSame(BizCurrency.valueOf(45000, BizCurrencyTypes.YEN));
                suiihyouExtBean.setMvaAriWDown(BizCurrency.valueOf(46000, BizCurrencyTypes.YEN));
                suiihyouExtBean.setMvaNoneWSame(BizCurrency.valueOf(4700, BizCurrencyTypes.YEN));
                suiihyouExtBean.setMvaNonePTumitatekin(BizCurrency.valueOf(4800, BizCurrencyTypes.YEN));

                suiihyouExtBeanList.add(suiihyouExtBean);
            }

            return suiihyouExtBeanList;
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            List<SuiihyouExtBean> list = new ArrayList<SuiihyouExtBean>();

            return list;
        }

        return super.getSuiihyouExtBeanLst();
    }
}
