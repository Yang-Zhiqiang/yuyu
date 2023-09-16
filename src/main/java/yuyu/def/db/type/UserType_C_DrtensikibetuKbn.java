package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DrtensikibetuKbn;

/**
 * {@link C_DrtensikibetuKbn 代理店識別区分} の Hibernate ユーザー定義型です。<br />
 * 代理店識別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DrtensikibetuKbn extends AbstractUserType<C_DrtensikibetuKbn> {

    @Override
    protected Class<C_DrtensikibetuKbn> returnType() {
        return C_DrtensikibetuKbn.class;
    }

    @Override
    protected C_DrtensikibetuKbn valueOf(String pValue) {
        return C_DrtensikibetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DrtensikibetuKbn pValue) {
        return pValue.getValue();
    }
}
