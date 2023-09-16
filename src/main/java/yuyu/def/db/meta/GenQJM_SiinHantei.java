package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_SiinHantei;
import yuyu.def.db.type.UserType_C_GeninKbn;
import yuyu.def.db.type.UserType_C_SiinKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 死因判定マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJM_SiinHantei extends AbstractExDBTable<JM_SiinHantei> {

    public GenQJM_SiinHantei() {
        this("JM_SiinHantei");
    }

    public GenQJM_SiinHantei(String pAlias) {
        super("JM_SiinHantei", JM_SiinHantei.class, pAlias);
    }

    public String JM_SiinHantei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JM_SiinHantei, C_GeninKbn> siboukariuketukejigeninkbn = new ExDBFieldString<>("siboukariuketukejigeninkbn", this, UserType_C_GeninKbn.class);

    public final ExDBFieldString<JM_SiinHantei, C_GeninKbn> seikyuuuketukejigeninkbn = new ExDBFieldString<>("seikyuuuketukejigeninkbn", this, UserType_C_GeninKbn.class);

    public final ExDBFieldString<JM_SiinHantei, C_UmuKbn> kansensyouumukbn = new ExDBFieldString<>("kansensyouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiinHantei, C_UmuKbn> saigaikanouseiumukbn = new ExDBFieldString<>("saigaikanouseiumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiinHantei, C_UmuKbn> husyounosiumukbn = new ExDBFieldString<>("husyounosiumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiinHantei, C_UmuKbn> sateikaksaigaikanouseikbn = new ExDBFieldString<>("sateikaksaigaikanouseikbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiinHantei, C_UmuKbn> sateikakhusyousikbn = new ExDBFieldString<>("sateikakhusyousikbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiinHantei, C_SiinKbn> siinkbn = new ExDBFieldString<>("siinkbn", this, UserType_C_SiinKbn.class);
}
