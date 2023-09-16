package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_TRNyuukin;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_CreditUriageSeikyuuKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 入金ＴＲテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_TRNyuukin extends AbstractExDBTable<IT_TRNyuukin> {

    public GenQIT_TRNyuukin() {
        this("IT_TRNyuukin");
    }

    public GenQIT_TRNyuukin(String pAlias) {
        super("IT_TRNyuukin", IT_TRNyuukin.class, pAlias);
    }

    public String IT_TRNyuukin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_TRNyuukin, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_TRNyuukin, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_TRNyuukin, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRNyuukin, String> nyktrrenno = new ExDBFieldString<>("nyktrrenno", this);

    public final ExDBFieldNumber<IT_TRNyuukin, Integer> datarenno = new ExDBFieldNumber<>("datarenno", this);

    public final ExDBFieldString<IT_TRNyuukin, C_Nykkeiro> nykkeiro = new ExDBFieldString<>("nykkeiro", this, UserType_C_Nykkeiro.class);

    public final ExDBFieldString<IT_TRNyuukin, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_TRNyuukin, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_TRNyuukin, C_UmuKbn> iktnyuukinnumu = new ExDBFieldString<>("iktnyuukinnumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_TRNyuukin, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_TRNyuukin, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_TRNyuukin, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldBizCurrency<IT_TRNyuukin> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<IT_TRNyuukin, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRNyuukin, String> kzhurikaebankcd = new ExDBFieldString<>("kzhurikaebankcd", this);

    public final ExDBFieldString<IT_TRNyuukin, String> kzhurikaesitencd = new ExDBFieldString<>("kzhurikaesitencd", this);

    public final ExDBFieldString<IT_TRNyuukin, BizDate> nykdenymd = new ExDBFieldString<>("nykdenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRNyuukin, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IT_TRNyuukin, C_Tuukasyu> rstuukasyu = new ExDBFieldString<>("rstuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_TRNyuukin, BizDate> nyknkwsratekijyunymd = new ExDBFieldString<>("nyknkwsratekijyunymd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRNyuukin, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_TRNyuukin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_TRNyuukin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_TRNyuukin, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_TRNyuukin, C_Syuudaikocd> syuudaikocd = new ExDBFieldString<>("syuudaikocd", this, UserType_C_Syuudaikocd.class);

    public final ExDBFieldString<IT_TRNyuukin, C_CreditUriageSeikyuuKbn> credituriageseikyuukbn = new ExDBFieldString<>("credituriageseikyuukbn", this, UserType_C_CreditUriageSeikyuuKbn.class);
}
