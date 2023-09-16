package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.IT_CardTourokuMati;
import yuyu.def.db.type.UserType_C_Syorizumiflg;

/**
 * カード情報登録待ちテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_CardTourokuMati extends AbstractExDBTable<IT_CardTourokuMati> {

    public GenQIT_CardTourokuMati() {
        this("IT_CardTourokuMati");
    }

    public GenQIT_CardTourokuMati(String pAlias) {
        super("IT_CardTourokuMati", IT_CardTourokuMati.class, pAlias);
    }

    public String IT_CardTourokuMati() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_CardTourokuMati, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IT_CardTourokuMati, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_CardTourokuMati, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_CardTourokuMati, C_Syorizumiflg> syorizumiflg = new ExDBFieldString<>("syorizumiflg", this, UserType_C_Syorizumiflg.class);

    public final ExDBFieldString<IT_CardTourokuMati, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_CardTourokuMati, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_CardTourokuMati, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
