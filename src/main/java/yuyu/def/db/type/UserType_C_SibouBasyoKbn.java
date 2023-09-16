package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SibouBasyoKbn;

/**
 * {@link C_SibouBasyoKbn 死亡場所区分} の Hibernate ユーザー定義型です。<br />
 * 死亡場所区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SibouBasyoKbn extends AbstractUserType<C_SibouBasyoKbn> {

    @Override
    protected Class<C_SibouBasyoKbn> returnType() {
        return C_SibouBasyoKbn.class;
    }

    @Override
    protected C_SibouBasyoKbn valueOf(String pValue) {
        return C_SibouBasyoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SibouBasyoKbn pValue) {
        return pValue.getValue();
    }
}
