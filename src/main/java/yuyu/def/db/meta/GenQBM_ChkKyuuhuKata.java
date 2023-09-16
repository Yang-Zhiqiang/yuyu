package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.db.entity.BM_ChkKyuuhuKata;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;

/**
 * 給付型チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkKyuuhuKata extends AbstractExDBTable<BM_ChkKyuuhuKata> {

    public GenQBM_ChkKyuuhuKata() {
        this("BM_ChkKyuuhuKata");
    }

    public GenQBM_ChkKyuuhuKata(String pAlias) {
        super("BM_ChkKyuuhuKata", BM_ChkKyuuhuKata.class, pAlias);
    }

    public String BM_ChkKyuuhuKata() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkKyuuhuKata, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkKyuuhuKata, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkKyuuhuKata, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkKyuuhuKata, C_KyhgndkataKbn> kyhkatakbn = new ExDBFieldString<>("kyhkatakbn", this, UserType_C_KyhgndkataKbn.class);
}
