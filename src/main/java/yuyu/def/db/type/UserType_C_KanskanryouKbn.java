package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KanskanryouKbn;

/**
 * {@link C_KanskanryouKbn 勧奨完了区分} の Hibernate ユーザー定義型です。<br />
 * 勧奨完了区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KanskanryouKbn extends AbstractUserType<C_KanskanryouKbn> {

    @Override
    protected Class<C_KanskanryouKbn> returnType() {
        return C_KanskanryouKbn.class;
    }

    @Override
    protected C_KanskanryouKbn valueOf(String pValue) {
        return C_KanskanryouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KanskanryouKbn pValue) {
        return pValue.getValue();
    }
}
