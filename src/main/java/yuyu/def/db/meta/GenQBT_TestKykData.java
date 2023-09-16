package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BT_TestKykData;

/**
 * テスト用契約データ抽出テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_TestKykData extends AbstractExDBTable<BT_TestKykData> {

    public GenQBT_TestKykData() {
        this("BT_TestKykData");
    }

    public GenQBT_TestKykData(String pAlias) {
        super("BT_TestKykData", BT_TestKykData.class, pAlias);
    }

    public String BT_TestKykData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_TestKykData, String> uniqueId = new ExDBFieldString<>("uniqueId", this);

    public final ExDBFieldString<BT_TestKykData, String> fileNm = new ExDBFieldString<>("fileNm", this);

    public final ExDBFieldString<BT_TestKykData, byte[]> testfilecontents = new ExDBFieldString<>("testfilecontents", this);
}
