package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ListpatternKbn;

/**
 * {@link C_ListpatternKbn リストパターン区分} の Hibernate ユーザー定義型です。<br />
 * リストパターン区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ListpatternKbn extends AbstractUserType<C_ListpatternKbn> {

    @Override
    protected Class<C_ListpatternKbn> returnType() {
        return C_ListpatternKbn.class;
    }

    @Override
    protected C_ListpatternKbn valueOf(String pValue) {
        return C_ListpatternKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ListpatternKbn pValue) {
        return pValue.getValue();
    }
}
