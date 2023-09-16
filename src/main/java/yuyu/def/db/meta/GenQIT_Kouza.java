package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_SinkeizkKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 口座テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_Kouza extends AbstractExDBTable<IT_Kouza> {

    public GenQIT_Kouza() {
        this("IT_Kouza");
    }

    public GenQIT_Kouza(String pAlias) {
        super("IT_Kouza", IT_Kouza.class, pAlias);
    }

    public String IT_Kouza() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_Kouza, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_Kouza, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_Kouza, String> kokno = new ExDBFieldString<>("kokno", this);

    public final ExDBFieldString<IT_Kouza, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_Kouza, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_Kouza, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_Kouza, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_Kouza, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_Kouza, C_SinkeizkKbn> sinkeizkkbn = new ExDBFieldString<>("sinkeizkkbn", this, UserType_C_SinkeizkKbn.class);

    public final ExDBFieldString<IT_Kouza, C_Syuudaikocd> syuudaikocd = new ExDBFieldString<>("syuudaikocd", this, UserType_C_Syuudaikocd.class);

    public final ExDBFieldString<IT_Kouza, C_KzkykdouKbn> kzkykdoukbn = new ExDBFieldString<>("kzkykdoukbn", this, UserType_C_KzkykdouKbn.class);

    public final ExDBFieldString<IT_Kouza, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_Kouza, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_Kouza, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
