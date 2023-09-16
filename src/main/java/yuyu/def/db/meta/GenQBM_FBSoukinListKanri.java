package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_Tantositucd;

/**
 * ＦＢ送金リスト管理マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_FBSoukinListKanri extends AbstractExDBTable<BM_FBSoukinListKanri> {

    public GenQBM_FBSoukinListKanri() {
        this("BM_FBSoukinListKanri");
    }

    public GenQBM_FBSoukinListKanri(String pAlias) {
        super("BM_FBSoukinListKanri", BM_FBSoukinListKanri.class, pAlias);
    }

    public String BM_FBSoukinListKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_FBSoukinListKanri, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<BM_FBSoukinListKanri, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<BM_FBSoukinListKanri, C_Tantositucd> tantositucd = new ExDBFieldString<>("tantositucd", this, UserType_C_Tantositucd.class);

    public final ExDBFieldString<BM_FBSoukinListKanri, C_SyoruiCdKbn> fbmeisaisyoruicd = new ExDBFieldString<>("fbmeisaisyoruicd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<BM_FBSoukinListKanri, C_SyoruiCdKbn> gkfbmeisaisyoruicd = new ExDBFieldString<>("gkfbmeisaisyoruicd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<BM_FBSoukinListKanri, C_SyoruiCdKbn> fbgoukeisyoruicd = new ExDBFieldString<>("fbgoukeisyoruicd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<BM_FBSoukinListKanri, C_SyoruiCdKbn> gkfbgoukeisyoruicd = new ExDBFieldString<>("gkfbgoukeisyoruicd", this, UserType_C_SyoruiCdKbn.class);
}
