package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BT_FBSoukinHukaInfo;

/**
 * ＦＢ送金付加情報データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_FBSoukinHukaInfo extends AbstractExDBTable<BT_FBSoukinHukaInfo> {

    public GenQBT_FBSoukinHukaInfo() {
        this("BT_FBSoukinHukaInfo");
    }

    public GenQBT_FBSoukinHukaInfo(String pAlias) {
        super("BT_FBSoukinHukaInfo", BT_FBSoukinHukaInfo.class, pAlias);
    }

    public String BT_FBSoukinHukaInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_FBSoukinHukaInfo, String> fbsoukindatasikibetukey = new ExDBFieldString<>("fbsoukindatasikibetukey", this);

    public final ExDBFieldString<BT_FBSoukinHukaInfo, String> kokcd1 = new ExDBFieldString<>("kokcd1", this);
}
