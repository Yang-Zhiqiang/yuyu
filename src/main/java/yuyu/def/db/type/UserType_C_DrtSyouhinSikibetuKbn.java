package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;

/**
 * {@link C_DrtSyouhinSikibetuKbn 代理店商品識別区分} の Hibernate ユーザー定義型です。<br />
 * 代理店商品識別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DrtSyouhinSikibetuKbn extends AbstractUserType<C_DrtSyouhinSikibetuKbn> {

    @Override
    protected Class<C_DrtSyouhinSikibetuKbn> returnType() {
        return C_DrtSyouhinSikibetuKbn.class;
    }

    @Override
    protected C_DrtSyouhinSikibetuKbn valueOf(String pValue) {
        return C_DrtSyouhinSikibetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DrtSyouhinSikibetuKbn pValue) {
        return pValue.getValue();
    }
}
