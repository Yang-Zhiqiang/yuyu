package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_WariatenasiriyuuKbn;

/**
 * {@link C_WariatenasiriyuuKbn 割当無し理由区分} の Hibernate ユーザー定義型です。<br />
 * 割当無し理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_WariatenasiriyuuKbn extends AbstractUserType<C_WariatenasiriyuuKbn> {

    @Override
    protected Class<C_WariatenasiriyuuKbn> returnType() {
        return C_WariatenasiriyuuKbn.class;
    }

    @Override
    protected C_WariatenasiriyuuKbn valueOf(String pValue) {
        return C_WariatenasiriyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_WariatenasiriyuuKbn pValue) {
        return pValue.getValue();
    }
}
