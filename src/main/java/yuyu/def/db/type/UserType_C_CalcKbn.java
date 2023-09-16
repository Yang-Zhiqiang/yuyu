package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CalcKbn;

/**
 * {@link C_CalcKbn 計算区分} の Hibernate ユーザー定義型です。<br />
 * 計算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CalcKbn extends AbstractUserType<C_CalcKbn> {

    @Override
    protected Class<C_CalcKbn> returnType() {
        return C_CalcKbn.class;
    }

    @Override
    protected C_CalcKbn valueOf(String pValue) {
        return C_CalcKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CalcKbn pValue) {
        return pValue.getValue();
    }
}
