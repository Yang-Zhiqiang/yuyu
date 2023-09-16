package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import yuyu.def.db.entity.HM_ChkTesuuryou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;

/**
 * 手数料チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_ChkTesuuryou extends AbstractExDBTable<HM_ChkTesuuryou> {

    public GenQHM_ChkTesuuryou() {
        this("HM_ChkTesuuryou");
    }

    public GenQHM_ChkTesuuryou(String pAlias) {
        super("HM_ChkTesuuryou", HM_ChkTesuuryou.class, pAlias);
    }

    public String HM_ChkTesuuryou() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<HM_ChkTesuuryou, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldBizCurrency<HM_ChkTesuuryou> hrkmtsry = new ExDBFieldBizCurrency<>("hrkmtsry", this);
}
