package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AdrhenKbn;

/**
 * {@link C_AdrhenKbn 住所変更対象区分} の Hibernate ユーザー定義型です。<br />
 * 住所変更対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AdrhenKbn extends AbstractUserType<C_AdrhenKbn> {

    @Override
    protected Class<C_AdrhenKbn> returnType() {
        return C_AdrhenKbn.class;
    }

    @Override
    protected C_AdrhenKbn valueOf(String pValue) {
        return C_AdrhenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AdrhenKbn pValue) {
        return pValue.getValue();
    }
}
