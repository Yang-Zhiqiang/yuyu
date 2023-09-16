package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_TknzkKbn;
import yuyu.def.db.entity.HT_ImuSonotaTkykJktk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_TknzkKbn;

/**
 * 医務査定その他特約条件付テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_ImuSonotaTkykJktk extends AbstractExDBTable<HT_ImuSonotaTkykJktk> {

    public GenQHT_ImuSonotaTkykJktk() {
        this("HT_ImuSonotaTkykJktk");
    }

    public GenQHT_ImuSonotaTkykJktk(String pAlias) {
        super("HT_ImuSonotaTkykJktk", HT_ImuSonotaTkykJktk.class, pAlias);
    }

    public String HT_ImuSonotaTkykJktk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_ImuSonotaTkykJktk, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_ImuSonotaTkykJktk, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_ImuSonotaTkykJktk, C_PmnjtkKbn> pmnjtkkbn = new ExDBFieldString<>("pmnjtkkbn", this, UserType_C_PmnjtkKbn.class);

    public final ExDBFieldString<HT_ImuSonotaTkykJktk, C_TknzkKbn> tknzkkbn = new ExDBFieldString<>("tknzkkbn", this, UserType_C_TknzkKbn.class);

    public final ExDBFieldBizCurrency<HT_ImuSonotaTkykJktk> seigens = new ExDBFieldBizCurrency<>("seigens", this);

    public final ExDBFieldString<HT_ImuSonotaTkykJktk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_ImuSonotaTkykJktk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
