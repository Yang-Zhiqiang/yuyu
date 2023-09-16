package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;

/**
 * 業務用工程情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_GyoumuKouteiInfo extends AbstractExDBTable<BT_GyoumuKouteiInfo> {

    public GenQBT_GyoumuKouteiInfo() {
        this("BT_GyoumuKouteiInfo");
    }

    public GenQBT_GyoumuKouteiInfo(String pAlias) {
        super("BT_GyoumuKouteiInfo", BT_GyoumuKouteiInfo.class, pAlias);
    }

    public String BT_GyoumuKouteiInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_GyoumuKouteiInfo, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<BT_GyoumuKouteiInfo, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<BT_GyoumuKouteiInfo, String> jimutetuzukicd = new ExDBFieldString<>("jimutetuzukicd", this);

    public final ExDBFieldString<BT_GyoumuKouteiInfo, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<BT_GyoumuKouteiInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<BT_GyoumuKouteiInfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<BT_GyoumuKouteiInfo, String> nksysyno = new ExDBFieldString<>("nksysyno", this);

    public final ExDBFieldString<BT_GyoumuKouteiInfo, String> syukouteikanriid = new ExDBFieldString<>("syukouteikanriid", this);

    public final ExDBFieldString<BT_GyoumuKouteiInfo, String> syukouteijimutetuzukicd = new ExDBFieldString<>("syukouteijimutetuzukicd", this);

    public final ExDBFieldString<BT_GyoumuKouteiInfo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BT_GyoumuKouteiInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_GyoumuKouteiInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
