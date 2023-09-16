package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.db.entity.IT_BAK_UriageSeikyuuData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AuthoriKbn;
import yuyu.def.db.type.UserType_C_CreditUriageSeikyuuKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;

/**
 * 売上請求データバックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_UriageSeikyuuData extends AbstractExDBTable<IT_BAK_UriageSeikyuuData> {

    public GenQIT_BAK_UriageSeikyuuData() {
        this("IT_BAK_UriageSeikyuuData");
    }

    public GenQIT_BAK_UriageSeikyuuData(String pAlias) {
        super("IT_BAK_UriageSeikyuuData", IT_BAK_UriageSeikyuuData.class, pAlias);
    }

    public String IT_BAK_UriageSeikyuuData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, BizDate> uriagenengappi = new ExDBFieldString<>("uriagenengappi", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_UriageSeikyuuData, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, String> recordno = new ExDBFieldString<>("recordno", this);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, C_CreditUriageSeikyuuKbn> credituriageseikyuukbn = new ExDBFieldString<>("credituriageseikyuukbn", this, UserType_C_CreditUriageSeikyuuKbn.class);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, C_AuthoriKbn> authorikbn = new ExDBFieldString<>("authorikbn", this, UserType_C_AuthoriKbn.class);

    public final ExDBFieldBizCurrency<IT_BAK_UriageSeikyuuData> credituriagegk = new ExDBFieldBizCurrency<>("credituriagegk", this);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, String> fukusuukameitennokey = new ExDBFieldString<>("fukusuukameitennokey", this);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_BAK_UriageSeikyuuData, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldNumber<IT_BAK_UriageSeikyuuData, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldNumber<IT_BAK_UriageSeikyuuData, Integer> annaino = new ExDBFieldNumber<>("annaino", this);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_UriageSeikyuuData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
