package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HnsychkTaisyousyaKbn;

/**
 * {@link C_HnsychkTaisyousyaKbn 反社チェック対象者区分} の Hibernate ユーザー定義型です。<br />
 * 反社チェック対象者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HnsychkTaisyousyaKbn extends AbstractUserType<C_HnsychkTaisyousyaKbn> {

    @Override
    protected Class<C_HnsychkTaisyousyaKbn> returnType() {
        return C_HnsychkTaisyousyaKbn.class;
    }

    @Override
    protected C_HnsychkTaisyousyaKbn valueOf(String pValue) {
        return C_HnsychkTaisyousyaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HnsychkTaisyousyaKbn pValue) {
        return pValue.getValue();
    }
}
