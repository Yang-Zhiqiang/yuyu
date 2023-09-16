package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_TknzkKbn;
import yuyu.def.db.entity.HT_SonotaTkykJktk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_TknzkKbn;

/**
 * その他特約条件付テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SonotaTkykJktk extends AbstractExDBTable<HT_SonotaTkykJktk> {

    public GenQHT_SonotaTkykJktk() {
        this("HT_SonotaTkykJktk");
    }

    public GenQHT_SonotaTkykJktk(String pAlias) {
        super("HT_SonotaTkykJktk", HT_SonotaTkykJktk.class, pAlias);
    }

    public String HT_SonotaTkykJktk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SonotaTkykJktk, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SonotaTkykJktk, C_PmnjtkKbn> pmnjtkkbn = new ExDBFieldString<>("pmnjtkkbn", this, UserType_C_PmnjtkKbn.class);

    public final ExDBFieldString<HT_SonotaTkykJktk, C_TknzkKbn> tknzkkbn = new ExDBFieldString<>("tknzkkbn", this, UserType_C_TknzkKbn.class);

    public final ExDBFieldBizCurrency<HT_SonotaTkykJktk> seigens = new ExDBFieldBizCurrency<>("seigens", this);

    public final ExDBFieldString<HT_SonotaTkykJktk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SonotaTkykJktk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
