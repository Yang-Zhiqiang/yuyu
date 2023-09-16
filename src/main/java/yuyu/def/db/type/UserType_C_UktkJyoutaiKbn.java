package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UktkJyoutaiKbn;

/**
 * {@link C_UktkJyoutaiKbn 受付状態区分} の Hibernate ユーザー定義型です。<br />
 * 受付状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UktkJyoutaiKbn extends AbstractUserType<C_UktkJyoutaiKbn> {

    @Override
    protected Class<C_UktkJyoutaiKbn> returnType() {
        return C_UktkJyoutaiKbn.class;
    }

    @Override
    protected C_UktkJyoutaiKbn valueOf(String pValue) {
        return C_UktkJyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UktkJyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
