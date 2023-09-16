package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_ByoumeiGaitouKbn2;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.db.type.UserType_C_ByoumeiGaitouKbn2;

/**
 * 病名マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJM_Byoumei extends AbstractExDBTable<JM_Byoumei> {

    public GenQJM_Byoumei() {
        this("JM_Byoumei");
    }

    public GenQJM_Byoumei(String pAlias) {
        super("JM_Byoumei", JM_Byoumei.class, pAlias);
    }

    public String JM_Byoumei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JM_Byoumei, String> byoumeitourokuno = new ExDBFieldString<>("byoumeitourokuno", this);

    public final ExDBFieldString<JM_Byoumei, String> byoumeikj = new ExDBFieldString<>("byoumeikj", this);

    public final ExDBFieldString<JM_Byoumei, String> byoumeizenkaku = new ExDBFieldString<>("byoumeizenkaku", this);

    public final ExDBFieldString<JM_Byoumei, String> byoumeikn = new ExDBFieldString<>("byoumeikn", this);

    public final ExDBFieldString<JM_Byoumei, String> byoumeiknkensaku = new ExDBFieldString<>("byoumeiknkensaku", this);

    public final ExDBFieldString<JM_Byoumei, String> byoumeicd = new ExDBFieldString<>("byoumeicd", this);

    public final ExDBFieldString<JM_Byoumei, String> gaitoukbn1 = new ExDBFieldString<>("gaitoukbn1", this);

    public final ExDBFieldString<JM_Byoumei, C_ByoumeiGaitouKbn2> gaitoukbn2 = new ExDBFieldString<>("gaitoukbn2", this, UserType_C_ByoumeiGaitouKbn2.class);

    public final ExDBFieldString<JM_Byoumei, String> gaitoukbn3 = new ExDBFieldString<>("gaitoukbn3", this);

    public final ExDBFieldString<JM_Byoumei, String> gaitoukbn4 = new ExDBFieldString<>("gaitoukbn4", this);

    public final ExDBFieldString<JM_Byoumei, String> gaitoukbn5 = new ExDBFieldString<>("gaitoukbn5", this);

    public final ExDBFieldString<JM_Byoumei, String> tyuuimongon = new ExDBFieldString<>("tyuuimongon", this);
}
