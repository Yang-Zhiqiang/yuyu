package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NayoseJyoutaiKbn;

/**
 * {@link C_NayoseJyoutaiKbn 名寄せ状態区分} の Hibernate ユーザー定義型です。<br />
 * 名寄せ状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NayoseJyoutaiKbn extends AbstractUserType<C_NayoseJyoutaiKbn> {

    @Override
    protected Class<C_NayoseJyoutaiKbn> returnType() {
        return C_NayoseJyoutaiKbn.class;
    }

    @Override
    protected C_NayoseJyoutaiKbn valueOf(String pValue) {
        return C_NayoseJyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NayoseJyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
