package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SskmdHassouKbn;
import yuyu.def.db.entity.BM_SosikiMadoguti;
import yuyu.def.db.type.UserType_C_SskmdHassouKbn;

/**
 * 組織窓口情報マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_SosikiMadoguti extends AbstractExDBTable<BM_SosikiMadoguti> {

    public GenQBM_SosikiMadoguti() {
        this("BM_SosikiMadoguti");
    }

    public GenQBM_SosikiMadoguti(String pAlias) {
        super("BM_SosikiMadoguti", BM_SosikiMadoguti.class, pAlias);
    }

    public String BM_SosikiMadoguti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_SosikiMadoguti, String> sskmdsosikicd = new ExDBFieldString<>("sskmdsosikicd", this);

    public final ExDBFieldString<BM_SosikiMadoguti, C_SskmdHassouKbn> sskmdhassoukbn = new ExDBFieldString<>("sskmdhassoukbn", this, UserType_C_SskmdHassouKbn.class);

    public final ExDBFieldString<BM_SosikiMadoguti, String> sskmdkanjisosikinm = new ExDBFieldString<>("sskmdkanjisosikinm", this);

    public final ExDBFieldString<BM_SosikiMadoguti, String> sskmdkanjisosikiadr1 = new ExDBFieldString<>("sskmdkanjisosikiadr1", this);

    public final ExDBFieldString<BM_SosikiMadoguti, String> sskmdkanjisosikiadr2 = new ExDBFieldString<>("sskmdkanjisosikiadr2", this);

    public final ExDBFieldString<BM_SosikiMadoguti, String> sskmdkanjisosikiadr3 = new ExDBFieldString<>("sskmdkanjisosikiadr3", this);

    public final ExDBFieldString<BM_SosikiMadoguti, String> sskmdpostalcd = new ExDBFieldString<>("sskmdpostalcd", this);

    public final ExDBFieldString<BM_SosikiMadoguti, String> sskmdtelno = new ExDBFieldString<>("sskmdtelno", this);

    public final ExDBFieldString<BM_SosikiMadoguti, String> sskmdfaxno = new ExDBFieldString<>("sskmdfaxno", this);

    public final ExDBFieldString<BM_SosikiMadoguti, String> sskmdsisyaharaidasikznm = new ExDBFieldString<>("sskmdsisyaharaidasikznm", this);

    public final ExDBFieldString<BM_SosikiMadoguti, String> sskmdkouzanocd = new ExDBFieldString<>("sskmdkouzanocd", this);

    public final ExDBFieldString<BM_SosikiMadoguti, String> sskmdsisyaharaidasikouzano = new ExDBFieldString<>("sskmdsisyaharaidasikouzano", this);

    public final ExDBFieldString<BM_SosikiMadoguti, String> sskmdsosikikbnnm = new ExDBFieldString<>("sskmdsosikikbnnm", this);
}
