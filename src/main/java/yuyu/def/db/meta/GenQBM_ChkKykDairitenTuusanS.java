package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.db.entity.BM_ChkKykDairitenTuusanS;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_KihonssyuruiKbn;

/**
 * 契約者同一代理店通算Ｓチェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkKykDairitenTuusanS extends AbstractExDBTable<BM_ChkKykDairitenTuusanS> {

    public GenQBM_ChkKykDairitenTuusanS() {
        this("BM_ChkKykDairitenTuusanS");
    }

    public GenQBM_ChkKykDairitenTuusanS(String pAlias) {
        super("BM_ChkKykDairitenTuusanS", BM_ChkKykDairitenTuusanS.class, pAlias);
    }

    public String BM_ChkKykDairitenTuusanS() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkKykDairitenTuusanS, C_KihonssyuruiKbn> kihonssyuruikbn = new ExDBFieldString<>("kihonssyuruikbn", this, UserType_C_KihonssyuruiKbn.class);

    public final ExDBFieldBizCurrency<BM_ChkKykDairitenTuusanS> gnds = new ExDBFieldBizCurrency<>("gnds", this);
}
