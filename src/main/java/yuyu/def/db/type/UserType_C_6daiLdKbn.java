package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_6daiLdKbn;

/**
 * {@link C_6daiLdKbn ６大生活習慣病追加給付型区分} の Hibernate ユーザー定義型です。<br />
 * ６大生活習慣病追加給付型区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_6daiLdKbn extends AbstractUserType<C_6daiLdKbn> {

    @Override
    protected Class<C_6daiLdKbn> returnType() {
        return C_6daiLdKbn.class;
    }

    @Override
    protected C_6daiLdKbn valueOf(String pValue) {
        return C_6daiLdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_6daiLdKbn pValue) {
        return pValue.getValue();
    }
}
