package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AnnaijyoutaiKbn;

/**
 * {@link C_AnnaijyoutaiKbn 案内状態区分} の Hibernate ユーザー定義型です。<br />
 * 案内状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AnnaijyoutaiKbn extends AbstractUserType<C_AnnaijyoutaiKbn> {

    @Override
    protected Class<C_AnnaijyoutaiKbn> returnType() {
        return C_AnnaijyoutaiKbn.class;
    }

    @Override
    protected C_AnnaijyoutaiKbn valueOf(String pValue) {
        return C_AnnaijyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AnnaijyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
