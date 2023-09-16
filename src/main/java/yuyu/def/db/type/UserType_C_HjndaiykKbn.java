package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HjndaiykKbn;

/**
 * {@link C_HjndaiykKbn 法人代表者役職区分} の Hibernate ユーザー定義型です。<br />
 * 法人代表者役職区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HjndaiykKbn extends AbstractUserType<C_HjndaiykKbn> {

    @Override
    protected Class<C_HjndaiykKbn> returnType() {
        return C_HjndaiykKbn.class;
    }

    @Override
    protected C_HjndaiykKbn valueOf(String pValue) {
        return C_HjndaiykKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HjndaiykKbn pValue) {
        return pValue.getValue();
    }
}
