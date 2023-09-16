package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HijynbrsikinidouyouKbn;

/**
 * {@link C_HijynbrsikinidouyouKbn 平準払資金移動要区分} の Hibernate ユーザー定義型です。<br />
 * 平準払資金移動要区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HijynbrsikinidouyouKbn extends AbstractUserType<C_HijynbrsikinidouyouKbn> {

    @Override
    protected Class<C_HijynbrsikinidouyouKbn> returnType() {
        return C_HijynbrsikinidouyouKbn.class;
    }

    @Override
    protected C_HijynbrsikinidouyouKbn valueOf(String pValue) {
        return C_HijynbrsikinidouyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HijynbrsikinidouyouKbn pValue) {
        return pValue.getValue();
    }
}
