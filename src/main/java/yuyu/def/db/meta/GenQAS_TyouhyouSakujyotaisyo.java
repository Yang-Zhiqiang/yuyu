package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NengetuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_TyouhyouSakujyotaisyo;
import yuyu.def.db.type.UserType_C_NengetuKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 帳票削除対象基幹テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAS_TyouhyouSakujyotaisyo extends AbstractExDBTable<AS_TyouhyouSakujyotaisyo> {

    public GenQAS_TyouhyouSakujyotaisyo() {
        this("AS_TyouhyouSakujyotaisyo");
    }

    public GenQAS_TyouhyouSakujyotaisyo(String pAlias) {
        super("AS_TyouhyouSakujyotaisyo", AS_TyouhyouSakujyotaisyo.class, pAlias);
    }

    public String AS_TyouhyouSakujyotaisyo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AS_TyouhyouSakujyotaisyo, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldNumber<AS_TyouhyouSakujyotaisyo, Integer> hozonKikan = new ExDBFieldNumber<>("hozonKikan", this);

    public final ExDBFieldString<AS_TyouhyouSakujyotaisyo, C_NengetuKbn> nengetukbn = new ExDBFieldString<>("nengetukbn", this, UserType_C_NengetuKbn.class);
}
