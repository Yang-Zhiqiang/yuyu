package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FstphrkkeiroKbn;

/**
 * {@link C_FstphrkkeiroKbn 初回保険料払込経路区分} の Hibernate ユーザー定義型です。<br />
 * 初回保険料払込経路区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FstphrkkeiroKbn extends AbstractUserType<C_FstphrkkeiroKbn> {

    @Override
    protected Class<C_FstphrkkeiroKbn> returnType() {
        return C_FstphrkkeiroKbn.class;
    }

    @Override
    protected C_FstphrkkeiroKbn valueOf(String pValue) {
        return C_FstphrkkeiroKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FstphrkkeiroKbn pValue) {
        return pValue.getValue();
    }
}
