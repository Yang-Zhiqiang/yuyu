package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.WT_TorikomiKanri;

/**
 * 取込管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWT_TorikomiKanri extends AbstractExDBTable<WT_TorikomiKanri> {

    public GenQWT_TorikomiKanri() {
        this("WT_TorikomiKanri");
    }

    public GenQWT_TorikomiKanri(String pAlias) {
        super("WT_TorikomiKanri", WT_TorikomiKanri.class, pAlias);
    }

    public String WT_TorikomiKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WT_TorikomiKanri, String> iwfImageId = new ExDBFieldString<>("iwfImageId", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> torikomiSyoruiCd = new ExDBFieldString<>("torikomiSyoruiCd", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> tourokuId = new ExDBFieldString<>("tourokuId", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> tourokuTime = new ExDBFieldString<>("tourokuTime", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam1 = new ExDBFieldString<>("extParam1", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam2 = new ExDBFieldString<>("extParam2", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam3 = new ExDBFieldString<>("extParam3", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam4 = new ExDBFieldString<>("extParam4", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam5 = new ExDBFieldString<>("extParam5", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam6 = new ExDBFieldString<>("extParam6", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam7 = new ExDBFieldString<>("extParam7", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam8 = new ExDBFieldString<>("extParam8", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam9 = new ExDBFieldString<>("extParam9", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam10 = new ExDBFieldString<>("extParam10", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam11 = new ExDBFieldString<>("extParam11", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam12 = new ExDBFieldString<>("extParam12", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam13 = new ExDBFieldString<>("extParam13", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam14 = new ExDBFieldString<>("extParam14", this);

    public final ExDBFieldString<WT_TorikomiKanri, String> extParam15 = new ExDBFieldString<>("extParam15", this);
}
