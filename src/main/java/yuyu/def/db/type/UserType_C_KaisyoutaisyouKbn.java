package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KaisyoutaisyouKbn;

/**
 * {@link C_KaisyoutaisyouKbn 解消対象区分} の Hibernate ユーザー定義型です。<br />
 * 解消対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KaisyoutaisyouKbn extends AbstractUserType<C_KaisyoutaisyouKbn> {

    @Override
    protected Class<C_KaisyoutaisyouKbn> returnType() {
        return C_KaisyoutaisyouKbn.class;
    }

    @Override
    protected C_KaisyoutaisyouKbn valueOf(String pValue) {
        return C_KaisyoutaisyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KaisyoutaisyouKbn pValue) {
        return pValue.getValue();
    }
}
