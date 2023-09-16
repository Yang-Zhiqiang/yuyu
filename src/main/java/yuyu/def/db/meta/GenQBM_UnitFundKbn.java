package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_UnitFundKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * ユニットファンド区分マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_UnitFundKbn extends AbstractExDBTable<BM_UnitFundKbn> {

    public GenQBM_UnitFundKbn() {
        this("BM_UnitFundKbn");
    }

    public GenQBM_UnitFundKbn(String pAlias) {
        super("BM_UnitFundKbn", BM_UnitFundKbn.class, pAlias);
    }

    public String BM_UnitFundKbn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_UnitFundKbn, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_UnitFundKbn, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<BM_UnitFundKbn, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldNumber<BM_UnitFundKbn, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<BM_UnitFundKbn, C_UnitFundKbn> unitfundkbn = new ExDBFieldString<>("unitfundkbn", this, UserType_C_UnitFundKbn.class);
}
