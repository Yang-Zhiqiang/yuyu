package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AeoiTaisyousyaKbn;

/**
 * {@link C_AeoiTaisyousyaKbn ＡＥＯＩ対象者区分} の Hibernate ユーザー定義型です。<br />
 * ＡＥＯＩ対象者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AeoiTaisyousyaKbn extends AbstractUserType<C_AeoiTaisyousyaKbn> {

    @Override
    protected Class<C_AeoiTaisyousyaKbn> returnType() {
        return C_AeoiTaisyousyaKbn.class;
    }

    @Override
    protected C_AeoiTaisyousyaKbn valueOf(String pValue) {
        return C_AeoiTaisyousyaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AeoiTaisyousyaKbn pValue) {
        return pValue.getValue();
    }
}
