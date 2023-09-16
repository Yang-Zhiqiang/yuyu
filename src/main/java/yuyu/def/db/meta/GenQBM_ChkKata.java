package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkKata;
import yuyu.def.db.type.UserType_C_KataKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 型区分チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkKata extends AbstractExDBTable<BM_ChkKata> {

    public GenQBM_ChkKata() {
        this("BM_ChkKata");
    }

    public GenQBM_ChkKata(String pAlias) {
        super("BM_ChkKata", BM_ChkKata.class, pAlias);
    }

    public String BM_ChkKata() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkKata, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkKata, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkKata, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkKata, C_UmuKbn> tktanbrumu = new ExDBFieldString<>("tktanbrumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_ChkKata, C_KataKbn> katakbn = new ExDBFieldString<>("katakbn", this, UserType_C_KataKbn.class);
}
