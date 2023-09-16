package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NkegsyokuinKbn;

/**
 * {@link C_NkegsyokuinKbn 内勤営業職員区分} の Hibernate ユーザー定義型です。<br />
 * 内勤営業職員区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NkegsyokuinKbn extends AbstractUserType<C_NkegsyokuinKbn> {

    @Override
    protected Class<C_NkegsyokuinKbn> returnType() {
        return C_NkegsyokuinKbn.class;
    }

    @Override
    protected C_NkegsyokuinKbn valueOf(String pValue) {
        return C_NkegsyokuinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NkegsyokuinKbn pValue) {
        return pValue.getValue();
    }
}
