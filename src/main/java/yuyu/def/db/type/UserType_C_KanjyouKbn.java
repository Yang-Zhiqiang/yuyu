package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KanjyouKbn;

/**
 * {@link C_KanjyouKbn 勘定区分} の Hibernate ユーザー定義型です。<br />
 * 勘定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KanjyouKbn extends AbstractUserType<C_KanjyouKbn> {

    @Override
    protected Class<C_KanjyouKbn> returnType() {
        return C_KanjyouKbn.class;
    }

    @Override
    protected C_KanjyouKbn valueOf(String pValue) {
        return C_KanjyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KanjyouKbn pValue) {
        return pValue.getValue();
    }
}
