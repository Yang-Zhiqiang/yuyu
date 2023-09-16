package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AS_Category;

/**
 * カテゴリ基幹テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAS_Category extends AbstractExDBTable<AS_Category> {

    public GenQAS_Category() {
        this("AS_Category");
    }

    public GenQAS_Category(String pAlias) {
        super("AS_Category", AS_Category.class, pAlias);
    }

    public String AS_Category() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AS_Category, String> categoryId = new ExDBFieldString<>("categoryId", this);

    public final ExDBFieldString<AS_Category, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<AS_Category, String> categoryNm = new ExDBFieldString<>("categoryNm", this);

    public final ExDBFieldNumber<AS_Category, Integer> sortNo = new ExDBFieldNumber<>("sortNo", this);

    public final ExDBFieldString<AS_Category, String> linkImage = new ExDBFieldString<>("linkImage", this);

    public final ExDBFieldString<AS_Category, String> titleStyle = new ExDBFieldString<>("titleStyle", this);
}
