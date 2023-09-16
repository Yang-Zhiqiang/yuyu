package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.JM_Syujyutu;

/**
 * 手術マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJM_Syujyutu extends AbstractExDBTable<JM_Syujyutu> {

    public GenQJM_Syujyutu() {
        this("JM_Syujyutu");
    }

    public GenQJM_Syujyutu(String pAlias) {
        super("JM_Syujyutu", JM_Syujyutu.class, pAlias);
    }

    public String JM_Syujyutu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JM_Syujyutu, String> syujyututourokuno = new ExDBFieldString<>("syujyututourokuno", this);

    public final ExDBFieldString<JM_Syujyutu, String> kjcd1 = new ExDBFieldString<>("kjcd1", this);

    public final ExDBFieldString<JM_Syujyutu, String> kjcd2 = new ExDBFieldString<>("kjcd2", this);

    public final ExDBFieldString<JM_Syujyutu, String> kjcd3 = new ExDBFieldString<>("kjcd3", this);

    public final ExDBFieldString<JM_Syujyutu, String> syujyutunmkn = new ExDBFieldString<>("syujyutunmkn", this);

    public final ExDBFieldString<JM_Syujyutu, String> syujyutunmkj = new ExDBFieldString<>("syujyutunmkj", this);

    public final ExDBFieldString<JM_Syujyutu, String> jyouken = new ExDBFieldString<>("jyouken", this);

    public final ExDBFieldString<JM_Syujyutu, String> syujyutubunruicd = new ExDBFieldString<>("syujyutubunruicd", this);

    public final ExDBFieldString<JM_Syujyutu, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JM_Syujyutu, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
