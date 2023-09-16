package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KohtnpKbn;
import yuyu.def.classification.C_TknzkKbn;
import yuyu.def.classification.C_TumahtnpKbn;
import yuyu.def.db.entity.HT_SyouhnTokujyouRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_KohtnpKbn;
import yuyu.def.db.type.UserType_C_TknzkKbn;
import yuyu.def.db.type.UserType_C_TumahtnpKbn;

/**
 * 商品別特条条件付履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SyouhnTokujyouRireki extends AbstractExDBTable<HT_SyouhnTokujyouRireki> {

    public GenQHT_SyouhnTokujyouRireki() {
        this("HT_SyouhnTokujyouRireki");
    }

    public GenQHT_SyouhnTokujyouRireki(String pAlias) {
        super("HT_SyouhnTokujyouRireki", HT_SyouhnTokujyouRireki.class, pAlias);
    }

    public String HT_SyouhnTokujyouRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SyouhnTokujyouRireki, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_SyouhnTokujyouRireki, Integer> dakuhiktrenno = new ExDBFieldNumber<>("dakuhiktrenno", this);

    public final ExDBFieldString<HT_SyouhnTokujyouRireki, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<HT_SyouhnTokujyouRireki, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<HT_SyouhnTokujyouRireki, C_TknzkKbn> tknzkkbn = new ExDBFieldString<>("tknzkkbn", this, UserType_C_TknzkKbn.class);

    public final ExDBFieldString<HT_SyouhnTokujyouRireki, C_TumahtnpKbn> tumahtnpkbn = new ExDBFieldString<>("tumahtnpkbn", this, UserType_C_TumahtnpKbn.class);

    public final ExDBFieldString<HT_SyouhnTokujyouRireki, C_KohtnpKbn> kohtnpkbn = new ExDBFieldString<>("kohtnpkbn", this, UserType_C_KohtnpKbn.class);

    public final ExDBFieldBizCurrency<HT_SyouhnTokujyouRireki> seigens = new ExDBFieldBizCurrency<>("seigens", this);

    public final ExDBFieldString<HT_SyouhnTokujyouRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SyouhnTokujyouRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
