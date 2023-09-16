package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.db.entity.IT_Tokusin;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_TokusinKbn;

/**
 * 特伸テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_Tokusin extends AbstractExDBTable<IT_Tokusin> {

    public GenQIT_Tokusin() {
        this("IT_Tokusin");
    }

    public GenQIT_Tokusin(String pAlias) {
        super("IT_Tokusin", IT_Tokusin.class, pAlias);
    }

    public String IT_Tokusin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_Tokusin, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_Tokusin, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_Tokusin, C_TokusinKbn> tokusinkbn = new ExDBFieldString<>("tokusinkbn", this, UserType_C_TokusinKbn.class);

    public final ExDBFieldString<IT_Tokusin, BizDate> tokusinsyoriymd = new ExDBFieldString<>("tokusinsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_Tokusin, BizDate> hsgymd = new ExDBFieldString<>("hsgymd", this, BizDateType.class);

    public final ExDBFieldString<IT_Tokusin, BizDate> tokusinendymd = new ExDBFieldString<>("tokusinendymd", this, BizDateType.class);

    public final ExDBFieldString<IT_Tokusin, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_Tokusin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_Tokusin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
