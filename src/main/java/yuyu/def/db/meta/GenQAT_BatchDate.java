package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_BatchDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * バッチ日付テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_BatchDate extends AbstractExDBTable<AT_BatchDate> {

    public GenQAT_BatchDate() {
        this("AT_BatchDate");
    }

    public GenQAT_BatchDate(String pAlias) {
        super("AT_BatchDate", AT_BatchDate.class, pAlias);
    }

    public String AT_BatchDate() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_BatchDate, BizDate> batchExecDate = new ExDBFieldString<>("batchExecDate", this, BizDateType.class);
}
