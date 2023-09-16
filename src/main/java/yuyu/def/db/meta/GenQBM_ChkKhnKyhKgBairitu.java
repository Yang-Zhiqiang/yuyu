package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.db.entity.BM_ChkKhnKyhKgBairitu;
import yuyu.def.db.type.UserType_C_KhnkyhkgbairituKbn;

/**
 * 基本給付金額倍率チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkKhnKyhKgBairitu extends AbstractExDBTable<BM_ChkKhnKyhKgBairitu> {

    public GenQBM_ChkKhnKyhKgBairitu() {
        this("BM_ChkKhnKyhKgBairitu");
    }

    public GenQBM_ChkKhnKyhKgBairitu(String pAlias) {
        super("BM_ChkKhnKyhKgBairitu", BM_ChkKhnKyhKgBairitu.class, pAlias);
    }

    public String BM_ChkKhnKyhKgBairitu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkKhnKyhKgBairitu, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkKhnKyhKgBairitu, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkKhnKyhKgBairitu, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkKhnKyhKgBairitu, C_KhnkyhkgbairituKbn> khnkyhkgbairitukbn = new ExDBFieldString<>("khnkyhkgbairitukbn", this, UserType_C_KhnkyhkgbairituKbn.class);
}
