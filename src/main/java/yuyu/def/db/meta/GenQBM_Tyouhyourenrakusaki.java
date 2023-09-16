package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.entity.BM_Tyouhyourenrakusaki;
import yuyu.def.db.type.UserType_C_TyhyrenrakusikibetuKbn;

/**
 * 帳票連絡先マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Tyouhyourenrakusaki extends AbstractExDBTable<BM_Tyouhyourenrakusaki> {

    public GenQBM_Tyouhyourenrakusaki() {
        this("BM_Tyouhyourenrakusaki");
    }

    public GenQBM_Tyouhyourenrakusaki(String pAlias) {
        super("BM_Tyouhyourenrakusaki", BM_Tyouhyourenrakusaki.class, pAlias);
    }

    public String BM_Tyouhyourenrakusaki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Tyouhyourenrakusaki, C_TyhyrenrakusikibetuKbn> tyhyrenrakusikibetukbn = new ExDBFieldString<>("tyhyrenrakusikibetukbn", this, UserType_C_TyhyrenrakusikibetuKbn.class);

    public final ExDBFieldString<BM_Tyouhyourenrakusaki, String> cctelno = new ExDBFieldString<>("cctelno", this);

    public final ExDBFieldString<BM_Tyouhyourenrakusaki, String> ccimagepath = new ExDBFieldString<>("ccimagepath", this);

    public final ExDBFieldString<BM_Tyouhyourenrakusaki, String> sapodetelno = new ExDBFieldString<>("sapodetelno", this);

    public final ExDBFieldString<BM_Tyouhyourenrakusaki, String> sapodeimagepath = new ExDBFieldString<>("sapodeimagepath", this);

    public final ExDBFieldString<BM_Tyouhyourenrakusaki, String> sapodefaxno = new ExDBFieldString<>("sapodefaxno", this);
}
