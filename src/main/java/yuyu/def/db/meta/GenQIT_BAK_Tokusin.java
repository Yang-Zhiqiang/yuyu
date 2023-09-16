package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.db.entity.IT_BAK_Tokusin;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_TokusinKbn;

/**
 * 特伸バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_Tokusin extends AbstractExDBTable<IT_BAK_Tokusin> {

    public GenQIT_BAK_Tokusin() {
        this("IT_BAK_Tokusin");
    }

    public GenQIT_BAK_Tokusin(String pAlias) {
        super("IT_BAK_Tokusin", IT_BAK_Tokusin.class, pAlias);
    }

    public String IT_BAK_Tokusin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_Tokusin, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_Tokusin, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_Tokusin, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_Tokusin, C_TokusinKbn> tokusinkbn = new ExDBFieldString<>("tokusinkbn", this, UserType_C_TokusinKbn.class);

    public final ExDBFieldString<IT_BAK_Tokusin, BizDate> tokusinsyoriymd = new ExDBFieldString<>("tokusinsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Tokusin, BizDate> hsgymd = new ExDBFieldString<>("hsgymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Tokusin, BizDate> tokusinendymd = new ExDBFieldString<>("tokusinendymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Tokusin, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_Tokusin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_Tokusin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
