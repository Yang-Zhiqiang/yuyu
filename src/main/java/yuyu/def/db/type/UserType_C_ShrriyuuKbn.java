package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrriyuuKbn;

/**
 * {@link C_ShrriyuuKbn 支払理由区分} の Hibernate ユーザー定義型です。<br />
 * 支払理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrriyuuKbn extends AbstractUserType<C_ShrriyuuKbn> {

    @Override
    protected Class<C_ShrriyuuKbn> returnType() {
        return C_ShrriyuuKbn.class;
    }

    @Override
    protected C_ShrriyuuKbn valueOf(String pValue) {
        return C_ShrriyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrriyuuKbn pValue) {
        return pValue.getValue();
    }
}
