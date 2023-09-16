package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HasseijikazeisyoriKbn;

/**
 * {@link C_HasseijikazeisyoriKbn 発生時課税処理区分} の Hibernate ユーザー定義型です。<br />
 * 発生時課税処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HasseijikazeisyoriKbn extends AbstractUserType<C_HasseijikazeisyoriKbn> {

    @Override
    protected Class<C_HasseijikazeisyoriKbn> returnType() {
        return C_HasseijikazeisyoriKbn.class;
    }

    @Override
    protected C_HasseijikazeisyoriKbn valueOf(String pValue) {
        return C_HasseijikazeisyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HasseijikazeisyoriKbn pValue) {
        return pValue.getValue();
    }
}
