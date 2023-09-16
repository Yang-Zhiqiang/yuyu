package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YoteikykymdKbn;

/**
 * {@link C_YoteikykymdKbn 予定契約日区分} の Hibernate ユーザー定義型です。<br />
 * 予定契約日区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YoteikykymdKbn extends AbstractUserType<C_YoteikykymdKbn> {

    @Override
    protected Class<C_YoteikykymdKbn> returnType() {
        return C_YoteikykymdKbn.class;
    }

    @Override
    protected C_YoteikykymdKbn valueOf(String pValue) {
        return C_YoteikykymdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YoteikykymdKbn pValue) {
        return pValue.getValue();
    }
}
