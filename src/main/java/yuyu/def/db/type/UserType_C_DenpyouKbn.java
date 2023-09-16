package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DenpyouKbn;

/**
 * {@link C_DenpyouKbn 伝票区分} の Hibernate ユーザー定義型です。<br />
 * 伝票区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DenpyouKbn extends AbstractUserType<C_DenpyouKbn> {

    @Override
    protected Class<C_DenpyouKbn> returnType() {
        return C_DenpyouKbn.class;
    }

    @Override
    protected C_DenpyouKbn valueOf(String pValue) {
        return C_DenpyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DenpyouKbn pValue) {
        return pValue.getValue();
    }
}
