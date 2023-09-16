package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BT_TyouhyouOutputKengen;
import yuyu.def.db.type.UserType_C_KahiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 帳票出力権限テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_TyouhyouOutputKengen extends AbstractExDBTable<BT_TyouhyouOutputKengen> {

    public GenQBT_TyouhyouOutputKengen() {
        this("BT_TyouhyouOutputKengen");
    }

    public GenQBT_TyouhyouOutputKengen(String pAlias) {
        super("BT_TyouhyouOutputKengen", BT_TyouhyouOutputKengen.class, pAlias);
    }

    public String BT_TyouhyouOutputKengen() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_TyouhyouOutputKengen, String> roleCd = new ExDBFieldString<>("roleCd", this);

    public final ExDBFieldString<BT_TyouhyouOutputKengen, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<BT_TyouhyouOutputKengen, C_KahiKbn> ikkatuoutputkahikbn = new ExDBFieldString<>("ikkatuoutputkahikbn", this, UserType_C_KahiKbn.class);

    public final ExDBFieldString<BT_TyouhyouOutputKengen, C_KahiKbn> kobetuoutputkahikbn = new ExDBFieldString<>("kobetuoutputkahikbn", this, UserType_C_KahiKbn.class);

    public final ExDBFieldString<BT_TyouhyouOutputKengen, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_TyouhyouOutputKengen, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
