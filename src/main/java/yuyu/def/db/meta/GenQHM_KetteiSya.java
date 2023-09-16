package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_ImusateirankKbn;
import yuyu.def.classification.C_KnksateirankKbn;
import yuyu.def.classification.C_MostenkenRankKbn;
import yuyu.def.db.entity.HM_KetteiSya;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_ImusateirankKbn;
import yuyu.def.db.type.UserType_C_KnksateirankKbn;
import yuyu.def.db.type.UserType_C_MostenkenRankKbn;

/**
 * 決定者マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_KetteiSya extends AbstractExDBTable<HM_KetteiSya> {

    public GenQHM_KetteiSya() {
        this("HM_KetteiSya");
    }

    public GenQHM_KetteiSya(String pAlias) {
        super("HM_KetteiSya", HM_KetteiSya.class, pAlias);
    }

    public String HM_KetteiSya() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_KetteiSya, String> ketsyacd = new ExDBFieldString<>("ketsyacd", this);

    public final ExDBFieldString<HM_KetteiSya, String> palketsyacd = new ExDBFieldString<>("palketsyacd", this);

    public final ExDBFieldString<HM_KetteiSya, String> ketsyanm = new ExDBFieldString<>("ketsyanm", this);

    public final ExDBFieldString<HM_KetteiSya, C_MostenkenRankKbn> mostenkenrankkbn = new ExDBFieldString<>("mostenkenrankkbn", this, UserType_C_MostenkenRankKbn.class);

    public final ExDBFieldString<HM_KetteiSya, C_KnksateirankKbn> knksateirankkbn = new ExDBFieldString<>("knksateirankkbn", this, UserType_C_KnksateirankKbn.class);

    public final ExDBFieldBizCurrency<HM_KetteiSya> knksateijygns = new ExDBFieldBizCurrency<>("knksateijygns", this);

    public final ExDBFieldString<HM_KetteiSya, C_ImusateirankKbn> imusateirankkbn = new ExDBFieldString<>("imusateirankkbn", this, UserType_C_ImusateirankKbn.class);

    public final ExDBFieldBizCurrency<HM_KetteiSya> imusateijygns = new ExDBFieldBizCurrency<>("imusateijygns", this);

    public final ExDBFieldString<HM_KetteiSya, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HM_KetteiSya, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
