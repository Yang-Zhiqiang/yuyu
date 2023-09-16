package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_ChkNenkinSaiteiS;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;

/**
 * 年金支払特約最低Ｓチェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkNenkinSaiteiS extends AbstractExDBTable<BM_ChkNenkinSaiteiS> {

    public GenQBM_ChkNenkinSaiteiS() {
        this("BM_ChkNenkinSaiteiS");
    }

    public GenQBM_ChkNenkinSaiteiS(String pAlias) {
        super("BM_ChkNenkinSaiteiS", BM_ChkNenkinSaiteiS.class, pAlias);
    }

    public String BM_ChkNenkinSaiteiS() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<BM_ChkNenkinSaiteiS, Integer> nenkinkkn = new ExDBFieldNumber<>("nenkinkkn", this);

    public final ExDBFieldString<BM_ChkNenkinSaiteiS, String> nenkinsyu = new ExDBFieldString<>("nenkinsyu", this);

    public final ExDBFieldBizCurrency<BM_ChkNenkinSaiteiS> saiteis = new ExDBFieldBizCurrency<>("saiteis", this);
}
