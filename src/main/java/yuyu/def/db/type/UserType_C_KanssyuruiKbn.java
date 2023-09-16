package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KanssyuruiKbn;

/**
 * {@link C_KanssyuruiKbn 勧奨種類区分} の Hibernate ユーザー定義型です。<br />
 * 勧奨種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KanssyuruiKbn extends AbstractUserType<C_KanssyuruiKbn> {

    @Override
    protected Class<C_KanssyuruiKbn> returnType() {
        return C_KanssyuruiKbn.class;
    }

    @Override
    protected C_KanssyuruiKbn valueOf(String pValue) {
        return C_KanssyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KanssyuruiKbn pValue) {
        return pValue.getValue();
    }
}
