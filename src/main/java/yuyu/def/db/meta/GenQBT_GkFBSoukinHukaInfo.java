package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BT_GkFBSoukinHukaInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;

/**
 * 外貨ＦＢ送金付加情報データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_GkFBSoukinHukaInfo extends AbstractExDBTable<BT_GkFBSoukinHukaInfo> {

    public GenQBT_GkFBSoukinHukaInfo() {
        this("BT_GkFBSoukinHukaInfo");
    }

    public GenQBT_GkFBSoukinHukaInfo(String pAlias) {
        super("BT_GkFBSoukinHukaInfo", BT_GkFBSoukinHukaInfo.class, pAlias);
    }

    public String BT_GkFBSoukinHukaInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_GkFBSoukinHukaInfo, String> fbsoukindatasikibetukey = new ExDBFieldString<>("fbsoukindatasikibetukey", this);

    public final ExDBFieldString<BT_GkFBSoukinHukaInfo, String> fbtrhksyoukaino = new ExDBFieldString<>("fbtrhksyoukaino", this);

    public final ExDBFieldBizCurrency<BT_GkFBSoukinHukaInfo> dengk = new ExDBFieldBizCurrency<>("dengk", this);
}
