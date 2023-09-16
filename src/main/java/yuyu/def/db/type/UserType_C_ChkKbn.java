package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ChkKbn;

/**
 * {@link C_ChkKbn チェック区分} の Hibernate ユーザー定義型です。<br />
 * チェック区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ChkKbn extends AbstractUserType<C_ChkKbn> {

    @Override
    protected Class<C_ChkKbn> returnType() {
        return C_ChkKbn.class;
    }

    @Override
    protected C_ChkKbn valueOf(String pValue) {
        return C_ChkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ChkKbn pValue) {
        return pValue.getValue();
    }
}
