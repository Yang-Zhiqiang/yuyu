package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HnsyaSosikiKengenKbn;

/**
 * {@link C_HnsyaSosikiKengenKbn 本社組織権限区分} の Hibernate ユーザー定義型です。<br />
 * 本社組織権限区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HnsyaSosikiKengenKbn extends AbstractUserType<C_HnsyaSosikiKengenKbn> {

    @Override
    protected Class<C_HnsyaSosikiKengenKbn> returnType() {
        return C_HnsyaSosikiKengenKbn.class;
    }

    @Override
    protected C_HnsyaSosikiKengenKbn valueOf(String pValue) {
        return C_HnsyaSosikiKengenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HnsyaSosikiKengenKbn pValue) {
        return pValue.getValue();
    }
}
