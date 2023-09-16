package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RendouKbn;

/**
 * {@link C_RendouKbn 連動区分} の Hibernate ユーザー定義型です。<br />
 * 連動区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RendouKbn extends AbstractUserType<C_RendouKbn> {

    @Override
    protected Class<C_RendouKbn> returnType() {
        return C_RendouKbn.class;
    }

    @Override
    protected C_RendouKbn valueOf(String pValue) {
        return C_RendouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RendouKbn pValue) {
        return pValue.getValue();
    }
}
