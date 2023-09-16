package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TkjitensiteiKbn;

/**
 * {@link C_TkjitensiteiKbn 特定時点指定区分} の Hibernate ユーザー定義型です。<br />
 * 特定時点指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TkjitensiteiKbn extends AbstractUserType<C_TkjitensiteiKbn> {

    @Override
    protected Class<C_TkjitensiteiKbn> returnType() {
        return C_TkjitensiteiKbn.class;
    }

    @Override
    protected C_TkjitensiteiKbn valueOf(String pValue) {
        return C_TkjitensiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TkjitensiteiKbn pValue) {
        return pValue.getValue();
    }
}
