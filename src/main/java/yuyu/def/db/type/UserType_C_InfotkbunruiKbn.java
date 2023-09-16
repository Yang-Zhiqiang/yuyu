package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_InfotkbunruiKbn;

/**
 * {@link C_InfotkbunruiKbn 情報系特約分類区分} の Hibernate ユーザー定義型です。<br />
 * 情報系特約分類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_InfotkbunruiKbn extends AbstractUserType<C_InfotkbunruiKbn> {

    @Override
    protected Class<C_InfotkbunruiKbn> returnType() {
        return C_InfotkbunruiKbn.class;
    }

    @Override
    protected C_InfotkbunruiKbn valueOf(String pValue) {
        return C_InfotkbunruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_InfotkbunruiKbn pValue) {
        return pValue.getValue();
    }
}
