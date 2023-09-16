package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HassouKbn;

/**
 * {@link C_HassouKbn 発送区分} の Hibernate ユーザー定義型です。<br />
 * 発送区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HassouKbn extends AbstractUserType<C_HassouKbn> {

    @Override
    protected Class<C_HassouKbn> returnType() {
        return C_HassouKbn.class;
    }

    @Override
    protected C_HassouKbn valueOf(String pValue) {
        return C_HassouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HassouKbn pValue) {
        return pValue.getValue();
    }
}
