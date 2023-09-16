package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SinsabaKbn;

/**
 * {@link C_SinsabaKbn 診査場所区分} の Hibernate ユーザー定義型です。<br />
 * 診査場所区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SinsabaKbn extends AbstractUserType<C_SinsabaKbn> {

    @Override
    protected Class<C_SinsabaKbn> returnType() {
        return C_SinsabaKbn.class;
    }

    @Override
    protected C_SinsabaKbn valueOf(String pValue) {
        return C_SinsabaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SinsabaKbn pValue) {
        return pValue.getValue();
    }
}
