package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_TeikikinKouza;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 定期金支払口座テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_TeikikinKouza extends AbstractExDBTable<IT_TeikikinKouza> {

    public GenQIT_TeikikinKouza() {
        this("IT_TeikikinKouza");
    }

    public GenQIT_TeikikinKouza(String pAlias) {
        super("IT_TeikikinKouza", IT_TeikikinKouza.class, pAlias);
    }

    public String IT_TeikikinKouza() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_TeikikinKouza, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_TeikikinKouza, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_TeikikinKouza, C_KouzasyuruiKbn> kzsyuruikbn = new ExDBFieldString<>("kzsyuruikbn", this, UserType_C_KouzasyuruiKbn.class);

    public final ExDBFieldString<IT_TeikikinKouza, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_TeikikinKouza, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_TeikikinKouza, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_TeikikinKouza, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_TeikikinKouza, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_TeikikinKouza, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_TeikikinKouza, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_TeikikinKouza, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
