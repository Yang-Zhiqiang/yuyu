package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.WT_KouteiSummary;

/**
 * 工程サマリテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWT_KouteiSummary extends AbstractExDBTable<WT_KouteiSummary> {

    public GenQWT_KouteiSummary() {
        this("WT_KouteiSummary");
    }

    public GenQWT_KouteiSummary(String pAlias) {
        super("WT_KouteiSummary", WT_KouteiSummary.class, pAlias);
    }

    public String WT_KouteiSummary() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WT_KouteiSummary, String> gyoumuKey = new ExDBFieldString<>("gyoumuKey", this);

    public final ExDBFieldString<WT_KouteiSummary, String> flowId = new ExDBFieldString<>("flowId", this);

    public final ExDBFieldString<WT_KouteiSummary, String> lastSyoriTime = new ExDBFieldString<>("lastSyoriTime", this);

    public final ExDBFieldString<WT_KouteiSummary, String> syokaiAccountId = new ExDBFieldString<>("syokaiAccountId", this);

    public final ExDBFieldString<WT_KouteiSummary, String> zenkaiAccountId = new ExDBFieldString<>("zenkaiAccountId", this);

    public final ExDBFieldString<WT_KouteiSummary, String> zenkaiNodeNm = new ExDBFieldString<>("zenkaiNodeNm", this);

    public final ExDBFieldString<WT_KouteiSummary, String> zenkaiTaskLocalNm = new ExDBFieldString<>("zenkaiTaskLocalNm", this);

    public final ExDBFieldString<WT_KouteiSummary, String> nodeNm = new ExDBFieldString<>("nodeNm", this);

    public final ExDBFieldString<WT_KouteiSummary, String> genzaiAccountId = new ExDBFieldString<>("genzaiAccountId", this);

    public final ExDBFieldString<WT_KouteiSummary, String> genzaiTaskLocalNm = new ExDBFieldString<>("genzaiTaskLocalNm", this);

    public final ExDBFieldString<WT_KouteiSummary, String> iwfKouteiKaisiYmd = new ExDBFieldString<>("iwfKouteiKaisiYmd", this);

    public final ExDBFieldString<WT_KouteiSummary, String> kouteiKanryouYmd = new ExDBFieldString<>("kouteiKanryouYmd", this);

    public final ExDBFieldString<WT_KouteiSummary, String> syoriStatus = new ExDBFieldString<>("syoriStatus", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam1 = new ExDBFieldString<>("extParam1", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam2 = new ExDBFieldString<>("extParam2", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam3 = new ExDBFieldString<>("extParam3", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam4 = new ExDBFieldString<>("extParam4", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam5 = new ExDBFieldString<>("extParam5", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam6 = new ExDBFieldString<>("extParam6", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam7 = new ExDBFieldString<>("extParam7", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam8 = new ExDBFieldString<>("extParam8", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam9 = new ExDBFieldString<>("extParam9", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam10 = new ExDBFieldString<>("extParam10", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam11 = new ExDBFieldString<>("extParam11", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam12 = new ExDBFieldString<>("extParam12", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam13 = new ExDBFieldString<>("extParam13", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam14 = new ExDBFieldString<>("extParam14", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam15 = new ExDBFieldString<>("extParam15", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam16 = new ExDBFieldString<>("extParam16", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam17 = new ExDBFieldString<>("extParam17", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam18 = new ExDBFieldString<>("extParam18", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam19 = new ExDBFieldString<>("extParam19", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam20 = new ExDBFieldString<>("extParam20", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam21 = new ExDBFieldString<>("extParam21", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam22 = new ExDBFieldString<>("extParam22", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam23 = new ExDBFieldString<>("extParam23", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam24 = new ExDBFieldString<>("extParam24", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam25 = new ExDBFieldString<>("extParam25", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam26 = new ExDBFieldString<>("extParam26", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam27 = new ExDBFieldString<>("extParam27", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam28 = new ExDBFieldString<>("extParam28", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam29 = new ExDBFieldString<>("extParam29", this);

    public final ExDBFieldString<WT_KouteiSummary, String> extParam30 = new ExDBFieldString<>("extParam30", this);
}
