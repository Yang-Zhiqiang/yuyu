package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;

/**
 * {@link C_SntkInfoTaisyousyaKbn 選択情報対象者区分} の Hibernate ユーザー定義型です。<br />
 * 選択情報対象者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SntkInfoTaisyousyaKbn extends AbstractUserType<C_SntkInfoTaisyousyaKbn> {

    @Override
    protected Class<C_SntkInfoTaisyousyaKbn> returnType() {
        return C_SntkInfoTaisyousyaKbn.class;
    }

    @Override
    protected C_SntkInfoTaisyousyaKbn valueOf(String pValue) {
        return C_SntkInfoTaisyousyaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SntkInfoTaisyousyaKbn pValue) {
        return pValue.getValue();
    }
}
