package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykkakjkKbn;

/**
 * {@link C_KykkakjkKbn 契約確認状況区分} の Hibernate ユーザー定義型です。<br />
 * 契約確認状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykkakjkKbn extends AbstractUserType<C_KykkakjkKbn> {

    @Override
    protected Class<C_KykkakjkKbn> returnType() {
        return C_KykkakjkKbn.class;
    }

    @Override
    protected C_KykkakjkKbn valueOf(String pValue) {
        return C_KykkakjkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykkakjkKbn pValue) {
        return pValue.getValue();
    }
}
