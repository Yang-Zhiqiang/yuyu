package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyorisimetknKbn;

/**
 * {@link C_SyorisimetknKbn 処理締切日特認区分} の Hibernate ユーザー定義型です。<br />
 * 処理締切日特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyorisimetknKbn extends AbstractUserType<C_SyorisimetknKbn> {

    @Override
    protected Class<C_SyorisimetknKbn> returnType() {
        return C_SyorisimetknKbn.class;
    }

    @Override
    protected C_SyorisimetknKbn valueOf(String pValue) {
        return C_SyorisimetknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyorisimetknKbn pValue) {
        return pValue.getValue();
    }
}
