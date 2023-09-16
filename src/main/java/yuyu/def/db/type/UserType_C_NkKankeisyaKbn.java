package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NkKankeisyaKbn;

/**
 * {@link C_NkKankeisyaKbn 年金支払関係者区分} の Hibernate ユーザー定義型です。<br />
 * 年金支払関係者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NkKankeisyaKbn extends AbstractUserType<C_NkKankeisyaKbn> {

    @Override
    protected Class<C_NkKankeisyaKbn> returnType() {
        return C_NkKankeisyaKbn.class;
    }

    @Override
    protected C_NkKankeisyaKbn valueOf(String pValue) {
        return C_NkKankeisyaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NkKankeisyaKbn pValue) {
        return pValue.getValue();
    }
}
