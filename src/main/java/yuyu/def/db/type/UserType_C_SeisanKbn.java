package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SeisanKbn;

/**
 * {@link C_SeisanKbn 精算区分} の Hibernate ユーザー定義型です。<br />
 * 精算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SeisanKbn extends AbstractUserType<C_SeisanKbn> {

    @Override
    protected Class<C_SeisanKbn> returnType() {
        return C_SeisanKbn.class;
    }

    @Override
    protected C_SeisanKbn valueOf(String pValue) {
        return C_SeisanKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SeisanKbn pValue) {
        return pValue.getValue();
    }
}
