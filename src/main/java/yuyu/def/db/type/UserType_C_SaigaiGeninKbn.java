package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SaigaiGeninKbn;

/**
 * {@link C_SaigaiGeninKbn 災害原因区分} の Hibernate ユーザー定義型です。<br />
 * 災害原因区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SaigaiGeninKbn extends AbstractUserType<C_SaigaiGeninKbn> {

    @Override
    protected Class<C_SaigaiGeninKbn> returnType() {
        return C_SaigaiGeninKbn.class;
    }

    @Override
    protected C_SaigaiGeninKbn valueOf(String pValue) {
        return C_SaigaiGeninKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SaigaiGeninKbn pValue) {
        return pValue.getValue();
    }
}
