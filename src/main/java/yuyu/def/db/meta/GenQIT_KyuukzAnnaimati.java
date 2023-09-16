package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.IT_KyuukzAnnaimati;
import yuyu.def.db.type.UserType_C_Syorizumiflg;

/**
 * 旧口座案内待ちテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KyuukzAnnaimati extends AbstractExDBTable<IT_KyuukzAnnaimati> {

    public GenQIT_KyuukzAnnaimati() {
        this("IT_KyuukzAnnaimati");
    }

    public GenQIT_KyuukzAnnaimati(String pAlias) {
        super("IT_KyuukzAnnaimati", IT_KyuukzAnnaimati.class, pAlias);
    }

    public String IT_KyuukzAnnaimati() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KyuukzAnnaimati, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IT_KyuukzAnnaimati, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KyuukzAnnaimati, C_Syorizumiflg> syorizumiflg = new ExDBFieldString<>("syorizumiflg", this, UserType_C_Syorizumiflg.class);

    public final ExDBFieldString<IT_KyuukzAnnaimati, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KyuukzAnnaimati, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KyuukzAnnaimati, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
