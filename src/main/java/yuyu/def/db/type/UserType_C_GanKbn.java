package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GanKbn;

/**
 * {@link C_GanKbn がん区分} の Hibernate ユーザー定義型です。<br />
 * がん区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GanKbn extends AbstractUserType<C_GanKbn> {

    @Override
    protected Class<C_GanKbn> returnType() {
        return C_GanKbn.class;
    }

    @Override
    protected C_GanKbn valueOf(String pValue) {
        return C_GanKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GanKbn pValue) {
        return pValue.getValue();
    }
}
