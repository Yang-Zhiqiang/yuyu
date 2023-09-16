package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SegbunruiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnbetuSegment;
import yuyu.def.db.type.UserType_C_SegbunruiKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 商品別セグメントマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_SyouhnbetuSegment extends AbstractExDBTable<BM_SyouhnbetuSegment> {

    public GenQBM_SyouhnbetuSegment() {
        this("BM_SyouhnbetuSegment");
    }

    public GenQBM_SyouhnbetuSegment(String pAlias) {
        super("BM_SyouhnbetuSegment", BM_SyouhnbetuSegment.class, pAlias);
    }

    public String BM_SyouhnbetuSegment() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_SyouhnbetuSegment, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BM_SyouhnbetuSegment, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_SyouhnbetuSegment, C_SegbunruiKbn> segbunrui1 = new ExDBFieldString<>("segbunrui1", this, UserType_C_SegbunruiKbn.class);

    public final ExDBFieldString<BM_SyouhnbetuSegment, C_SegbunruiKbn> segbunrui2 = new ExDBFieldString<>("segbunrui2", this, UserType_C_SegbunruiKbn.class);

    public final ExDBFieldString<BM_SyouhnbetuSegment, C_Segcd> segcd = new ExDBFieldString<>("segcd", this, UserType_C_Segcd.class);
}
