package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KouteihiteiKbn;

/**
 * {@link C_KouteihiteiKbn 肯定否定区分} の Hibernate ユーザー定義型です。<br />
 * 肯定否定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KouteihiteiKbn extends AbstractUserType<C_KouteihiteiKbn> {

    @Override
    protected Class<C_KouteihiteiKbn> returnType() {
        return C_KouteihiteiKbn.class;
    }

    @Override
    protected C_KouteihiteiKbn valueOf(String pValue) {
        return C_KouteihiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KouteihiteiKbn pValue) {
        return pValue.getValue();
    }
}
