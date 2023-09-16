package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KankeisyaKbn;

/**
 * {@link C_KankeisyaKbn 関係者区分} の Hibernate ユーザー定義型です。<br />
 * 関係者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KankeisyaKbn extends AbstractUserType<C_KankeisyaKbn> {

    @Override
    protected Class<C_KankeisyaKbn> returnType() {
        return C_KankeisyaKbn.class;
    }

    @Override
    protected C_KankeisyaKbn valueOf(String pValue) {
        return C_KankeisyaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KankeisyaKbn pValue) {
        return pValue.getValue();
    }
}
