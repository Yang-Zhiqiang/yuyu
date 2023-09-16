package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ImusateijyouKbn;

/**
 * {@link C_ImusateijyouKbn 医務査定状態区分} の Hibernate ユーザー定義型です。<br />
 * 医務査定状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ImusateijyouKbn extends AbstractUserType<C_ImusateijyouKbn> {

    @Override
    protected Class<C_ImusateijyouKbn> returnType() {
        return C_ImusateijyouKbn.class;
    }

    @Override
    protected C_ImusateijyouKbn valueOf(String pValue) {
        return C_ImusateijyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ImusateijyouKbn pValue) {
        return pValue.getValue();
    }
}
