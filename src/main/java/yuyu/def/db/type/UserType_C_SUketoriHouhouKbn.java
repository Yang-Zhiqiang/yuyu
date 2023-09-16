package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SUketoriHouhouKbn;

/**
 * {@link C_SUketoriHouhouKbn 保険金受取方法区分} の Hibernate ユーザー定義型です。<br />
 * 保険金受取方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SUketoriHouhouKbn extends AbstractUserType<C_SUketoriHouhouKbn> {

    @Override
    protected Class<C_SUketoriHouhouKbn> returnType() {
        return C_SUketoriHouhouKbn.class;
    }

    @Override
    protected C_SUketoriHouhouKbn valueOf(String pValue) {
        return C_SUketoriHouhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SUketoriHouhouKbn pValue) {
        return pValue.getValue();
    }
}
