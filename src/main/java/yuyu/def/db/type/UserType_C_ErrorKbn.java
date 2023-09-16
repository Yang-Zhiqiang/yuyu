package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link C_ErrorKbn エラー区分} の Hibernate ユーザー定義型です。<br />
 * エラー区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ErrorKbn extends AbstractUserType<C_ErrorKbn> {

    @Override
    protected Class<C_ErrorKbn> returnType() {
        return C_ErrorKbn.class;
    }

    @Override
    protected C_ErrorKbn valueOf(String pValue) {
        return C_ErrorKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ErrorKbn pValue) {
        return pValue.getValue();
    }
}
