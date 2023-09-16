package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PmnjtkkzkyouhiKbn;

/**
 * {@link C_PmnjtkkzkyouhiKbn 保険料免除特約継続要否区分} の Hibernate ユーザー定義型です。<br />
 * 保険料免除特約継続要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PmnjtkkzkyouhiKbn extends AbstractUserType<C_PmnjtkkzkyouhiKbn> {

    @Override
    protected Class<C_PmnjtkkzkyouhiKbn> returnType() {
        return C_PmnjtkkzkyouhiKbn.class;
    }

    @Override
    protected C_PmnjtkkzkyouhiKbn valueOf(String pValue) {
        return C_PmnjtkkzkyouhiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PmnjtkkzkyouhiKbn pValue) {
        return pValue.getValue();
    }
}
