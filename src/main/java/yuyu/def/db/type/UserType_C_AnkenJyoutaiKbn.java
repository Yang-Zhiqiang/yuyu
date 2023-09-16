package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AnkenJyoutaiKbn;

/**
 * {@link C_AnkenJyoutaiKbn 案件状態区分} の Hibernate ユーザー定義型です。<br />
 * 案件状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AnkenJyoutaiKbn extends AbstractUserType<C_AnkenJyoutaiKbn> {

    @Override
    protected Class<C_AnkenJyoutaiKbn> returnType() {
        return C_AnkenJyoutaiKbn.class;
    }

    @Override
    protected C_AnkenJyoutaiKbn valueOf(String pValue) {
        return C_AnkenJyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AnkenJyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
