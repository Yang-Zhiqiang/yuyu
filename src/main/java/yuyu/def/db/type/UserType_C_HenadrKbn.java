package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HenadrKbn;

/**
 * {@link C_HenadrKbn 住所変更内容区分} の Hibernate ユーザー定義型です。<br />
 * 住所変更内容区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HenadrKbn extends AbstractUserType<C_HenadrKbn> {

    @Override
    protected Class<C_HenadrKbn> returnType() {
        return C_HenadrKbn.class;
    }

    @Override
    protected C_HenadrKbn valueOf(String pValue) {
        return C_HenadrKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HenadrKbn pValue) {
        return pValue.getValue();
    }
}
