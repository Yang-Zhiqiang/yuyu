package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_HutanpoBui;

/**
 * 不担保部位マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_HutanpoBui extends AbstractExDBTable<BM_HutanpoBui> {

    public GenQBM_HutanpoBui() {
        this("BM_HutanpoBui");
    }

    public GenQBM_HutanpoBui(String pAlias) {
        super("BM_HutanpoBui", BM_HutanpoBui.class, pAlias);
    }

    public String BM_HutanpoBui() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_HutanpoBui, String> htnpbuicd = new ExDBFieldString<>("htnpbuicd", this);

    public final ExDBFieldString<BM_HutanpoBui, String> htnpbuinm = new ExDBFieldString<>("htnpbuinm", this);

    public final ExDBFieldString<BM_HutanpoBui, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_HutanpoBui, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
