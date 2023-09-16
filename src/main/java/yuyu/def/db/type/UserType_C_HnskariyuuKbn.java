package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HnskariyuuKbn;

/**
 * {@link C_HnskariyuuKbn 本社回送理由区分} の Hibernate ユーザー定義型です。<br />
 * 本社回送理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HnskariyuuKbn extends AbstractUserType<C_HnskariyuuKbn> {

    @Override
    protected Class<C_HnskariyuuKbn> returnType() {
        return C_HnskariyuuKbn.class;
    }

    @Override
    protected C_HnskariyuuKbn valueOf(String pValue) {
        return C_HnskariyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HnskariyuuKbn pValue) {
        return pValue.getValue();
    }
}
