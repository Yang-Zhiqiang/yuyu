package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BT_WariateHukaInfo;

/**
 * 割当不可情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_WariateHukaInfo extends AbstractExDBTable<BT_WariateHukaInfo> {

    public GenQBT_WariateHukaInfo() {
        this("BT_WariateHukaInfo");
    }

    public GenQBT_WariateHukaInfo(String pAlias) {
        super("BT_WariateHukaInfo", BT_WariateHukaInfo.class, pAlias);
    }

    public String BT_WariateHukaInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_WariateHukaInfo, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<BT_WariateHukaInfo, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<BT_WariateHukaInfo, String> jimutetuzukicd = new ExDBFieldString<>("jimutetuzukicd", this);

    public final ExDBFieldString<BT_WariateHukaInfo, String> wrthukatskid = new ExDBFieldString<>("wrthukatskid", this);

    public final ExDBFieldString<BT_WariateHukaInfo, String> userId = new ExDBFieldString<>("userId", this);

    public final ExDBFieldString<BT_WariateHukaInfo, String> wrthukakaijyotskid = new ExDBFieldString<>("wrthukakaijyotskid", this);

    public final ExDBFieldString<BT_WariateHukaInfo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BT_WariateHukaInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_WariateHukaInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
