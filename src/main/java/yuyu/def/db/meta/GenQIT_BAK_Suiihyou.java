package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_BAK_Suiihyou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_MvaTekiyoujyoutaiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 推移表バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_Suiihyou extends AbstractExDBTable<IT_BAK_Suiihyou> {

    public GenQIT_BAK_Suiihyou() {
        this("IT_BAK_Suiihyou");
    }

    public GenQIT_BAK_Suiihyou(String pAlias) {
        super("IT_BAK_Suiihyou", IT_BAK_Suiihyou.class, pAlias);
    }

    public String IT_BAK_Suiihyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_Suiihyou, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_Suiihyou, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_Suiihyou, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_Suiihyou, Integer> keikanensuu = new ExDBFieldNumber<>("keikanensuu", this);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizDate> calckijyunymd = new ExDBFieldString<>("calckijyunymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizDateYM> calcym = new ExDBFieldString<>("calcym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, C_MvaTekiyoujyoutaiKbn> mvatekijyoutaikbn = new ExDBFieldString<>("mvatekijyoutaikbn", this, UserType_C_MvaTekiyoujyoutaiKbn.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrtup = new ExDBFieldString<>("sjkkktusirrtup", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrtsame = new ExDBFieldString<>("sjkkktusirrtsame", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrtdown = new ExDBFieldString<>("sjkkktusirrtdown", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrthendouup = new ExDBFieldString<>("sjkkktusirrthendouup", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrthendoudown = new ExDBFieldString<>("sjkkktusirrthendoudown", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> yenknsnkwsrateyendaka = new ExDBFieldString<>("yenknsnkwsrateyendaka", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> yenknsnkwsrateyenkijyun = new ExDBFieldString<>("yenknsnkwsrateyenkijyun", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> yenknsnkwsrateyenyasu = new ExDBFieldString<>("yenknsnkwsrateyenyasu", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> yenknsnkwsrategkyendaka = new ExDBFieldBizCurrency<>("yenknsnkwsrategkyendaka", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> yenknsnkwsrategkyenyasu = new ExDBFieldBizCurrency<>("yenknsnkwsrategkyenyasu", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwup = new ExDBFieldBizCurrency<>("mvaariwup", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwsame = new ExDBFieldBizCurrency<>("mvaariwsame", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwdown = new ExDBFieldBizCurrency<>("mvaariwdown", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyenupyendaka = new ExDBFieldBizCurrency<>("mvaariwyenupyendaka", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyenupyenkijyun = new ExDBFieldBizCurrency<>("mvaariwyenupyenkijyun", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyenupyenyasu = new ExDBFieldBizCurrency<>("mvaariwyenupyenyasu", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyensameyendaka = new ExDBFieldBizCurrency<>("mvaariwyensameyendaka", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyensameyenkijyun = new ExDBFieldBizCurrency<>("mvaariwyensameyenkijyun", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyensameyenyasu = new ExDBFieldBizCurrency<>("mvaariwyensameyenyasu", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyendownyendaka = new ExDBFieldBizCurrency<>("mvaariwyendownyendaka", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyendownyenkijyun = new ExDBFieldBizCurrency<>("mvaariwyendownyenkijyun", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyendownyenyasu = new ExDBFieldBizCurrency<>("mvaariwyendownyenyasu", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariptumitatekin = new ExDBFieldBizCurrency<>("mvaariptumitatekin", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanonewsame = new ExDBFieldBizCurrency<>("mvanonewsame", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanonewyensameyendaka = new ExDBFieldBizCurrency<>("mvanonewyensameyendaka", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanonewyensameyenkijyun = new ExDBFieldBizCurrency<>("mvanonewyensameyenkijyun", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanonewyensameyenyasu = new ExDBFieldBizCurrency<>("mvanonewyensameyenyasu", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanoneptumitatekin = new ExDBFieldBizCurrency<>("mvanoneptumitatekin", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mkhyouyensysnikougk = new ExDBFieldBizCurrency<>("mkhyouyensysnikougk", this);

    public final ExDBFieldString<IT_BAK_Suiihyou, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_Suiihyou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_Suiihyou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> tmttknzoukaritu1 = new ExDBFieldString<>("tmttknzoukaritu1", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> tmttknzoukaritu2 = new ExDBFieldString<>("tmttknzoukaritu2", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> tmttknzoukaritu3 = new ExDBFieldString<>("tmttknzoukaritu3", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrtup2 = new ExDBFieldString<>("sjkkktusirrtup2", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrtsame2 = new ExDBFieldString<>("sjkkktusirrtsame2", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrtdown2 = new ExDBFieldString<>("sjkkktusirrtdown2", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrthendouup2 = new ExDBFieldString<>("sjkkktusirrthendouup2", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrthendoudown2 = new ExDBFieldString<>("sjkkktusirrthendoudown2", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> yenknsnkwsrateyendaka2 = new ExDBFieldString<>("yenknsnkwsrateyendaka2", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> yenknsnkwsrateyenkijyun2 = new ExDBFieldString<>("yenknsnkwsrateyenkijyun2", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> yenknsnkwsrateyenyasu2 = new ExDBFieldString<>("yenknsnkwsrateyenyasu2", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> yenknsnkwsrategkyendaka2 = new ExDBFieldBizCurrency<>("yenknsnkwsrategkyendaka2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> yenknsnkwsrategkyenyasu2 = new ExDBFieldBizCurrency<>("yenknsnkwsrategkyenyasu2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwup2 = new ExDBFieldBizCurrency<>("mvaariwup2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwsame2 = new ExDBFieldBizCurrency<>("mvaariwsame2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwdown2 = new ExDBFieldBizCurrency<>("mvaariwdown2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyenupyendaka2 = new ExDBFieldBizCurrency<>("mvaariwyenupyendaka2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyenupyenkijyun2 = new ExDBFieldBizCurrency<>("mvaariwyenupyenkijyun2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyenupyenyasu2 = new ExDBFieldBizCurrency<>("mvaariwyenupyenyasu2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyensameyendaka2 = new ExDBFieldBizCurrency<>("mvaariwyensameyendaka2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyensameyenkijyun2 = new ExDBFieldBizCurrency<>("mvaariwyensameyenkijyun2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyensameyenyasu2 = new ExDBFieldBizCurrency<>("mvaariwyensameyenyasu2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyendownyendaka2 = new ExDBFieldBizCurrency<>("mvaariwyendownyendaka2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyendownyenkijyun2 = new ExDBFieldBizCurrency<>("mvaariwyendownyenkijyun2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyendownyenyasu2 = new ExDBFieldBizCurrency<>("mvaariwyendownyenyasu2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariptumitatekin2 = new ExDBFieldBizCurrency<>("mvaariptumitatekin2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanonewsame2 = new ExDBFieldBizCurrency<>("mvanonewsame2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanonewyensameyendaka2 = new ExDBFieldBizCurrency<>("mvanonewyensameyendaka2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanonewyensameyenkijyun2 = new ExDBFieldBizCurrency<>("mvanonewyensameyenkijyun2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanonewyensameyenyasu2 = new ExDBFieldBizCurrency<>("mvanonewyensameyenyasu2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanoneptumitatekin2 = new ExDBFieldBizCurrency<>("mvanoneptumitatekin2", this);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrtup3 = new ExDBFieldString<>("sjkkktusirrtup3", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrtsame3 = new ExDBFieldString<>("sjkkktusirrtsame3", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrtdown3 = new ExDBFieldString<>("sjkkktusirrtdown3", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrthendouup3 = new ExDBFieldString<>("sjkkktusirrthendouup3", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sjkkktusirrthendoudown3 = new ExDBFieldString<>("sjkkktusirrthendoudown3", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> yenknsnkwsrateyendaka3 = new ExDBFieldString<>("yenknsnkwsrateyendaka3", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> yenknsnkwsrateyenkijyun3 = new ExDBFieldString<>("yenknsnkwsrateyenkijyun3", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> yenknsnkwsrateyenyasu3 = new ExDBFieldString<>("yenknsnkwsrateyenyasu3", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> yenknsnkwsrategkyendaka3 = new ExDBFieldBizCurrency<>("yenknsnkwsrategkyendaka3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> yenknsnkwsrategkyenyasu3 = new ExDBFieldBizCurrency<>("yenknsnkwsrategkyenyasu3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwup3 = new ExDBFieldBizCurrency<>("mvaariwup3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwsame3 = new ExDBFieldBizCurrency<>("mvaariwsame3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwdown3 = new ExDBFieldBizCurrency<>("mvaariwdown3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyenupyendaka3 = new ExDBFieldBizCurrency<>("mvaariwyenupyendaka3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyenupyenkijyun3 = new ExDBFieldBizCurrency<>("mvaariwyenupyenkijyun3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyenupyenyasu3 = new ExDBFieldBizCurrency<>("mvaariwyenupyenyasu3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyensameyendaka3 = new ExDBFieldBizCurrency<>("mvaariwyensameyendaka3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyensameyenkijyun3 = new ExDBFieldBizCurrency<>("mvaariwyensameyenkijyun3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyensameyenyasu3 = new ExDBFieldBizCurrency<>("mvaariwyensameyenyasu3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyendownyendaka3 = new ExDBFieldBizCurrency<>("mvaariwyendownyendaka3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyendownyenkijyun3 = new ExDBFieldBizCurrency<>("mvaariwyendownyenkijyun3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariwyendownyenyasu3 = new ExDBFieldBizCurrency<>("mvaariwyendownyenyasu3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaariptumitatekin3 = new ExDBFieldBizCurrency<>("mvaariptumitatekin3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanonewsame3 = new ExDBFieldBizCurrency<>("mvanonewsame3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanonewyensameyendaka3 = new ExDBFieldBizCurrency<>("mvanonewyensameyendaka3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanonewyensameyenkijyun3 = new ExDBFieldBizCurrency<>("mvanonewyensameyenkijyun3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanonewyensameyenyasu3 = new ExDBFieldBizCurrency<>("mvanonewyensameyenyasu3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvanoneptumitatekin3 = new ExDBFieldBizCurrency<>("mvanoneptumitatekin3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> tutmttknutiwake11 = new ExDBFieldBizCurrency<>("tutmttknutiwake11", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> tutmttknutiwake21 = new ExDBFieldBizCurrency<>("tutmttknutiwake21", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> tutmttknutiwake12 = new ExDBFieldBizCurrency<>("tutmttknutiwake12", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> tutmttknutiwake22 = new ExDBFieldBizCurrency<>("tutmttknutiwake22", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> tutmttknutiwake13 = new ExDBFieldBizCurrency<>("tutmttknutiwake13", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> tutmttknutiwake23 = new ExDBFieldBizCurrency<>("tutmttknutiwake23", this);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sisuuupritu1 = new ExDBFieldString<>("sisuuupritu1", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sisuuupritu2 = new ExDBFieldString<>("sisuuupritu2", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> sisuuupritu3 = new ExDBFieldString<>("sisuuupritu3", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaaritmttkgkkykkjmaeup1 = new ExDBFieldBizCurrency<>("mvaaritmttkgkkykkjmaeup1", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaaritmttkgkkykkjmaeup2 = new ExDBFieldBizCurrency<>("mvaaritmttkgkkykkjmaeup2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaaritmttkgkkykkjmaeup3 = new ExDBFieldBizCurrency<>("mvaaritmttkgkkykkjmaeup3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaaritmttkgkkykkjmaesame1 = new ExDBFieldBizCurrency<>("mvaaritmttkgkkykkjmaesame1", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaaritmttkgkkykkjmaesame2 = new ExDBFieldBizCurrency<>("mvaaritmttkgkkykkjmaesame2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaaritmttkgkkykkjmaesame3 = new ExDBFieldBizCurrency<>("mvaaritmttkgkkykkjmaesame3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaaritmttkgkkykkjmaedown1 = new ExDBFieldBizCurrency<>("mvaaritmttkgkkykkjmaedown1", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaaritmttkgkkykkjmaedown2 = new ExDBFieldBizCurrency<>("mvaaritmttkgkkykkjmaedown2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> mvaaritmttkgkkykkjmaedown3 = new ExDBFieldBizCurrency<>("mvaaritmttkgkkykkjmaedown3", this);

    public final ExDBFieldString<IT_BAK_Suiihyou, String> suiihyousyubetu = new ExDBFieldString<>("suiihyousyubetu", this);

    public final ExDBFieldString<IT_BAK_Suiihyou, C_UmuKbn> hrkkknmnryumukbn = new ExDBFieldString<>("hrkkknmnryumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> ytirrtcalckijyunrrt1 = new ExDBFieldString<>("ytirrtcalckijyunrrt1", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> ytirrtcalckijyunrrt2 = new ExDBFieldString<>("ytirrtcalckijyunrrt2", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Suiihyou, BizNumber> ytirrtcalckijyunrrt3 = new ExDBFieldString<>("ytirrtcalckijyunrrt3", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> zennouzndkyen1 = new ExDBFieldBizCurrency<>("zennouzndkyen1", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> zennouzndkyen2 = new ExDBFieldBizCurrency<>("zennouzndkyen2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> zennouzndkyen3 = new ExDBFieldBizCurrency<>("zennouzndkyen3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> kihrkmpyen1 = new ExDBFieldBizCurrency<>("kihrkmpyen1", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> kihrkmpyen2 = new ExDBFieldBizCurrency<>("kihrkmpyen2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> kihrkmpyen3 = new ExDBFieldBizCurrency<>("kihrkmpyen3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> kihrkmp1 = new ExDBFieldBizCurrency<>("kihrkmp1", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> kihrkmp2 = new ExDBFieldBizCurrency<>("kihrkmp2", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> kihrkmp3 = new ExDBFieldBizCurrency<>("kihrkmp3", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> zennouzndk1 = new ExDBFieldBizCurrency<>("zennouzndk1", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> kaiyakujuktrgk = new ExDBFieldBizCurrency<>("kaiyakujuktrgk", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> kaiyakujuktrgkyendaka = new ExDBFieldBizCurrency<>("kaiyakujuktrgkyendaka", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> kaiyakujuktrgkyenkijyun = new ExDBFieldBizCurrency<>("kaiyakujuktrgkyenkijyun", this);

    public final ExDBFieldBizCurrency<IT_BAK_Suiihyou> kaiyakujuktrgkyenyasu = new ExDBFieldBizCurrency<>("kaiyakujuktrgkyenyasu", this);
}
