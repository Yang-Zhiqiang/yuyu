package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UktkaijyoKbn;

/**
 * {@link C_UktkaijyoKbn 受取人解除区分} の Hibernate ユーザー定義型です。<br />
 * 受取人解除区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UktkaijyoKbn extends AbstractUserType<C_UktkaijyoKbn> {

    @Override
    protected Class<C_UktkaijyoKbn> returnType() {
        return C_UktkaijyoKbn.class;
    }

    @Override
    protected C_UktkaijyoKbn valueOf(String pValue) {
        return C_UktkaijyoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UktkaijyoKbn pValue) {
        return pValue.getValue();
    }
}
