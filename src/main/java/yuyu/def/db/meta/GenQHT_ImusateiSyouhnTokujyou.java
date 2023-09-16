package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KohtnpKbn;
import yuyu.def.classification.C_TknzkKbn;
import yuyu.def.classification.C_TumahtnpKbn;
import yuyu.def.db.entity.HT_ImusateiSyouhnTokujyou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_KohtnpKbn;
import yuyu.def.db.type.UserType_C_TknzkKbn;
import yuyu.def.db.type.UserType_C_TumahtnpKbn;

/**
 * 医務査定商品別特条条件付テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_ImusateiSyouhnTokujyou extends AbstractExDBTable<HT_ImusateiSyouhnTokujyou> {

    public GenQHT_ImusateiSyouhnTokujyou() {
        this("HT_ImusateiSyouhnTokujyou");
    }

    public GenQHT_ImusateiSyouhnTokujyou(String pAlias) {
        super("HT_ImusateiSyouhnTokujyou", HT_ImusateiSyouhnTokujyou.class, pAlias);
    }

    public String HT_ImusateiSyouhnTokujyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_ImusateiSyouhnTokujyou, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_ImusateiSyouhnTokujyou, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_ImusateiSyouhnTokujyou, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<HT_ImusateiSyouhnTokujyou, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<HT_ImusateiSyouhnTokujyou, C_TknzkKbn> tknzkkbn = new ExDBFieldString<>("tknzkkbn", this, UserType_C_TknzkKbn.class);

    public final ExDBFieldString<HT_ImusateiSyouhnTokujyou, C_TumahtnpKbn> tumahtnpkbn = new ExDBFieldString<>("tumahtnpkbn", this, UserType_C_TumahtnpKbn.class);

    public final ExDBFieldString<HT_ImusateiSyouhnTokujyou, C_KohtnpKbn> kohtnpkbn = new ExDBFieldString<>("kohtnpkbn", this, UserType_C_KohtnpKbn.class);

    public final ExDBFieldBizCurrency<HT_ImusateiSyouhnTokujyou> seigens = new ExDBFieldBizCurrency<>("seigens", this);

    public final ExDBFieldString<HT_ImusateiSyouhnTokujyou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_ImusateiSyouhnTokujyou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
