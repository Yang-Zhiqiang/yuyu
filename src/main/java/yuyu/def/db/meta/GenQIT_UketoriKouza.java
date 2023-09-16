package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_UketoriKouza;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_UktsyuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 受取口座テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_UketoriKouza extends AbstractExDBTable<IT_UketoriKouza> {

    public GenQIT_UketoriKouza() {
        this("IT_UketoriKouza");
    }

    public GenQIT_UketoriKouza(String pAlias) {
        super("IT_UketoriKouza", IT_UketoriKouza.class, pAlias);
    }

    public String IT_UketoriKouza() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_UketoriKouza, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_UketoriKouza, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_UketoriKouza, C_UktsyuKbn> uktsyukbn = new ExDBFieldString<>("uktsyukbn", this, UserType_C_UktsyuKbn.class);

    public final ExDBFieldNumber<IT_UketoriKouza, Integer> uktsyurenno = new ExDBFieldNumber<>("uktsyurenno", this);

    public final ExDBFieldString<IT_UketoriKouza, C_KouzasyuruiKbn> kzsyuruikbn = new ExDBFieldString<>("kzsyuruikbn", this, UserType_C_KouzasyuruiKbn.class);

    public final ExDBFieldString<IT_UketoriKouza, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_UketoriKouza, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_UketoriKouza, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_UketoriKouza, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_UketoriKouza, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_UketoriKouza, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_UketoriKouza, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_UketoriKouza, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
