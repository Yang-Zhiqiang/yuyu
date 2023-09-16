package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AS_BatchHeisouList;

/**
 * バッチ並走リスト基幹テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAS_BatchHeisouList extends AbstractExDBTable<AS_BatchHeisouList> {

    public GenQAS_BatchHeisouList() {
        this("AS_BatchHeisouList");
    }

    public GenQAS_BatchHeisouList(String pAlias) {
        super("AS_BatchHeisouList", AS_BatchHeisouList.class, pAlias);
    }

    public String AS_BatchHeisouList() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AS_BatchHeisouList, String> selfKinouId = new ExDBFieldString<>("selfKinouId", this);

    public final ExDBFieldString<AS_BatchHeisouList, String> targetKinouId = new ExDBFieldString<>("targetKinouId", this);
}
