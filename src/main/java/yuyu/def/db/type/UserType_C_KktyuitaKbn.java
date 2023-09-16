package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KktyuitaKbn;

/**
 * {@link C_KktyuitaKbn 契約管理注意取扱区分} の Hibernate ユーザー定義型です。<br />
 * 契約管理注意取扱区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KktyuitaKbn extends AbstractUserType<C_KktyuitaKbn> {

    @Override
    protected Class<C_KktyuitaKbn> returnType() {
        return C_KktyuitaKbn.class;
    }

    @Override
    protected C_KktyuitaKbn valueOf(String pValue) {
        return C_KktyuitaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KktyuitaKbn pValue) {
        return pValue.getValue();
    }
}
