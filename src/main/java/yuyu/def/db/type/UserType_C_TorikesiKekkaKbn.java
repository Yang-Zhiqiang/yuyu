package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TorikesiKekkaKbn;

/**
 * {@link C_TorikesiKekkaKbn 取消結果区分} の Hibernate ユーザー定義型です。<br />
 * 取消結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TorikesiKekkaKbn extends AbstractUserType<C_TorikesiKekkaKbn> {

    @Override
    protected Class<C_TorikesiKekkaKbn> returnType() {
        return C_TorikesiKekkaKbn.class;
    }

    @Override
    protected C_TorikesiKekkaKbn valueOf(String pValue) {
        return C_TorikesiKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TorikesiKekkaKbn pValue) {
        return pValue.getValue();
    }
}
