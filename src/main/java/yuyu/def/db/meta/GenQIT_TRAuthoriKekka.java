package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_AuthoritrkKbn;
import yuyu.def.db.entity.IT_TRAuthoriKekka;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_AuthorijkKbn;
import yuyu.def.db.type.UserType_C_AuthoritrkKbn;

/**
 * オーソリ結果ＴＲテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_TRAuthoriKekka extends AbstractExDBTable<IT_TRAuthoriKekka> {

    public GenQIT_TRAuthoriKekka() {
        this("IT_TRAuthoriKekka");
    }

    public GenQIT_TRAuthoriKekka(String pAlias) {
        super("IT_TRAuthoriKekka", IT_TRAuthoriKekka.class, pAlias);
    }

    public String IT_TRAuthoriKekka() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_TRAuthoriKekka, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_TRAuthoriKekka, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRAuthoriKekka, String> authorikktrrenno = new ExDBFieldString<>("authorikktrrenno", this);

    public final ExDBFieldString<IT_TRAuthoriKekka, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IT_TRAuthoriKekka, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IT_TRAuthoriKekka, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IT_TRAuthoriKekka, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IT_TRAuthoriKekka, C_AuthorijkKbn> authorijkkbn = new ExDBFieldString<>("authorijkkbn", this, UserType_C_AuthorijkKbn.class);

    public final ExDBFieldString<IT_TRAuthoriKekka, C_AuthoritrkKbn> authoritrkkbn = new ExDBFieldString<>("authoritrkkbn", this, UserType_C_AuthoritrkKbn.class);

    public final ExDBFieldBizCurrency<IT_TRAuthoriKekka> authorigk = new ExDBFieldBizCurrency<>("authorigk", this);

    public final ExDBFieldString<IT_TRAuthoriKekka, BizDate> authorikanryoymd = new ExDBFieldString<>("authorikanryoymd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRAuthoriKekka, String> syouninno = new ExDBFieldString<>("syouninno", this);

    public final ExDBFieldString<IT_TRAuthoriKekka, String> tanmatusyorino = new ExDBFieldString<>("tanmatusyorino", this);

    public final ExDBFieldString<IT_TRAuthoriKekka, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_TRAuthoriKekka, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_TRAuthoriKekka, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
