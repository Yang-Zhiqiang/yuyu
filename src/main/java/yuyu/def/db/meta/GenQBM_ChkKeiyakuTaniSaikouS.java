package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_ChkKeiyakuTaniSaikouS;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;

/**
 * 契約単位最高Ｓチェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkKeiyakuTaniSaikouS extends AbstractExDBTable<BM_ChkKeiyakuTaniSaikouS> {

    public GenQBM_ChkKeiyakuTaniSaikouS() {
        this("BM_ChkKeiyakuTaniSaikouS");
    }

    public GenQBM_ChkKeiyakuTaniSaikouS(String pAlias) {
        super("BM_ChkKeiyakuTaniSaikouS", BM_ChkKeiyakuTaniSaikouS.class, pAlias);
    }

    public String BM_ChkKeiyakuTaniSaikouS() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkKeiyakuTaniSaikouS, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkKeiyakuTaniSaikouS, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkKeiyakuTaniSaikouS, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldBizCurrency<BM_ChkKeiyakuTaniSaikouS> saikous1 = new ExDBFieldBizCurrency<>("saikous1", this);

    public final ExDBFieldBizCurrency<BM_ChkKeiyakuTaniSaikouS> saikous2 = new ExDBFieldBizCurrency<>("saikous2", this);

    public final ExDBFieldBizCurrency<BM_ChkKeiyakuTaniSaikouS> saikous3 = new ExDBFieldBizCurrency<>("saikous3", this);
}
