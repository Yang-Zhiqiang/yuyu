package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TokuyakuNenkinsyuKbn;

/**
 * {@link C_TokuyakuNenkinsyuKbn 年金支払特約年金種類区分} の Hibernate ユーザー定義型です。<br />
 * 年金支払特約年金種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TokuyakuNenkinsyuKbn extends AbstractUserType<C_TokuyakuNenkinsyuKbn> {

    @Override
    protected Class<C_TokuyakuNenkinsyuKbn> returnType() {
        return C_TokuyakuNenkinsyuKbn.class;
    }

    @Override
    protected C_TokuyakuNenkinsyuKbn valueOf(String pValue) {
        return C_TokuyakuNenkinsyuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TokuyakuNenkinsyuKbn pValue) {
        return pValue.getValue();
    }
}
