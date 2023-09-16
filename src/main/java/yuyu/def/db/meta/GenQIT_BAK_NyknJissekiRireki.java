package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_BAK_NyknJissekiRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_Nyktrksflg;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 入金実績履歴バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_NyknJissekiRireki extends AbstractExDBTable<IT_BAK_NyknJissekiRireki> {

    public GenQIT_BAK_NyknJissekiRireki() {
        this("IT_BAK_NyknJissekiRireki");
    }

    public GenQIT_BAK_NyknJissekiRireki(String pAlias) {
        super("IT_BAK_NyknJissekiRireki", IT_BAK_NyknJissekiRireki.class, pAlias);
    }

    public String IT_BAK_NyknJissekiRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, BizDateYM> jyutoustartym = new ExDBFieldString<>("jyutoustartym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_BAK_NyknJissekiRireki, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, BizDateYM> jyutouendym = new ExDBFieldString<>("jyutouendym", this, BizDateYMType.class);

    public final ExDBFieldBizCurrency<IT_BAK_NyknJissekiRireki> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, C_Tuukasyu> rstuukasyu = new ExDBFieldString<>("rstuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, BizDate> ryosyukwsratekjymd = new ExDBFieldString<>("ryosyukwsratekjymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, BizNumber> ryosyukwsrate = new ExDBFieldString<>("ryosyukwsrate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_NyknJissekiRireki> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldBizCurrency<IT_BAK_NyknJissekiRireki> iktwaribikikgk = new ExDBFieldBizCurrency<>("iktwaribikikgk", this);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, BizDate> nyksyoriymd = new ExDBFieldString<>("nyksyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, String> nykdenno = new ExDBFieldString<>("nykdenno", this);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, BizDate> nykdenymd = new ExDBFieldString<>("nykdenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, C_Nykkeiro> nykkeiro = new ExDBFieldString<>("nykkeiro", this, UserType_C_Nykkeiro.class);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldNumber<IT_BAK_NyknJissekiRireki, Integer> ikkatuyoupkaisuu = new ExDBFieldNumber<>("ikkatuyoupkaisuu", this);

    public final ExDBFieldNumber<IT_BAK_NyknJissekiRireki, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_BAK_NyknJissekiRireki, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, C_UmuKbn> iktnyuukinnumu = new ExDBFieldString<>("iktnyuukinnumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, C_Nyktrksflg> nyktrksflg = new ExDBFieldString<>("nyktrksflg", this, UserType_C_Nyktrksflg.class);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, BizDate> nyktrksymd = new ExDBFieldString<>("nyktrksymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, String> nyktrksdenno = new ExDBFieldString<>("nyktrksdenno", this);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, BizDate> nyktrksdenymd = new ExDBFieldString<>("nyktrksdenymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_BAK_NyknJissekiRireki> yenkansannyknkingk = new ExDBFieldBizCurrency<>("yenkansannyknkingk", this);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, BizDate> yenkansantkykwsrateymd = new ExDBFieldString<>("yenkansantkykwsrateymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, BizNumber> yenkansantkykwsrate = new ExDBFieldString<>("yenkansantkykwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_BAK_NyknJissekiRireki, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);
}
