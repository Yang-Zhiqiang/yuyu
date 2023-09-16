package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_TknzkKbn;
import yuyu.def.db.entity.HT_SonotaTkykJktkRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_TknzkKbn;

/**
 * その他特約条件付履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SonotaTkykJktkRireki extends AbstractExDBTable<HT_SonotaTkykJktkRireki> {

    public GenQHT_SonotaTkykJktkRireki() {
        this("HT_SonotaTkykJktkRireki");
    }

    public GenQHT_SonotaTkykJktkRireki(String pAlias) {
        super("HT_SonotaTkykJktkRireki", HT_SonotaTkykJktkRireki.class, pAlias);
    }

    public String HT_SonotaTkykJktkRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SonotaTkykJktkRireki, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_SonotaTkykJktkRireki, Integer> dakuhiktrenno = new ExDBFieldNumber<>("dakuhiktrenno", this);

    public final ExDBFieldString<HT_SonotaTkykJktkRireki, C_PmnjtkKbn> pmnjtkkbn = new ExDBFieldString<>("pmnjtkkbn", this, UserType_C_PmnjtkKbn.class);

    public final ExDBFieldString<HT_SonotaTkykJktkRireki, C_TknzkKbn> tknzkkbn = new ExDBFieldString<>("tknzkkbn", this, UserType_C_TknzkKbn.class);

    public final ExDBFieldBizCurrency<HT_SonotaTkykJktkRireki> seigens = new ExDBFieldBizCurrency<>("seigens", this);

    public final ExDBFieldString<HT_SonotaTkykJktkRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SonotaTkykJktkRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
