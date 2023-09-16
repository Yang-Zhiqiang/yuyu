package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HoyuuskeiKbn;

/**
 * {@link C_HoyuuskeiKbn 保有新契約区分} の Hibernate ユーザー定義型です。<br />
 * 保有新契約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HoyuuskeiKbn extends AbstractUserType<C_HoyuuskeiKbn> {

    @Override
    protected Class<C_HoyuuskeiKbn> returnType() {
        return C_HoyuuskeiKbn.class;
    }

    @Override
    protected C_HoyuuskeiKbn valueOf(String pValue) {
        return C_HoyuuskeiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HoyuuskeiKbn pValue) {
        return pValue.getValue();
    }
}
