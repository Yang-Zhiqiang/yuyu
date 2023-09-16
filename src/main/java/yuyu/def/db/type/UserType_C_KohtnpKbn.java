package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KohtnpKbn;

/**
 * {@link C_KohtnpKbn 子不担保区分} の Hibernate ユーザー定義型です。<br />
 * 子不担保区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KohtnpKbn extends AbstractUserType<C_KohtnpKbn> {

    @Override
    protected Class<C_KohtnpKbn> returnType() {
        return C_KohtnpKbn.class;
    }

    @Override
    protected C_KohtnpKbn valueOf(String pValue) {
        return C_KohtnpKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KohtnpKbn pValue) {
        return pValue.getValue();
    }
}
