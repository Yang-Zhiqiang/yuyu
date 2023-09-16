package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HrshrbknKbn;

/**
 * {@link C_HrshrbknKbn 返戻金支払備金区分} の Hibernate ユーザー定義型です。<br />
 * 返戻金支払備金区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HrshrbknKbn extends AbstractUserType<C_HrshrbknKbn> {

    @Override
    protected Class<C_HrshrbknKbn> returnType() {
        return C_HrshrbknKbn.class;
    }

    @Override
    protected C_HrshrbknKbn valueOf(String pValue) {
        return C_HrshrbknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HrshrbknKbn pValue) {
        return pValue.getValue();
    }
}
