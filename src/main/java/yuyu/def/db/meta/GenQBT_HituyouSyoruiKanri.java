package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 必要書類管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_HituyouSyoruiKanri extends AbstractExDBTable<BT_HituyouSyoruiKanri> {

    public GenQBT_HituyouSyoruiKanri() {
        this("BT_HituyouSyoruiKanri");
    }

    public GenQBT_HituyouSyoruiKanri(String pAlias) {
        super("BT_HituyouSyoruiKanri", BT_HituyouSyoruiKanri.class, pAlias);
    }

    public String BT_HituyouSyoruiKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_HituyouSyoruiKanri, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<BT_HituyouSyoruiKanri, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<BT_HituyouSyoruiKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_HituyouSyoruiKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
