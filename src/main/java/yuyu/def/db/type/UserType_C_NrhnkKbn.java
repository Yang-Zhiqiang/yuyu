package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NrhnkKbn;

/**
 * {@link C_NrhnkKbn 年齢変更区分} の Hibernate ユーザー定義型です。<br />
 * 年齢変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NrhnkKbn extends AbstractUserType<C_NrhnkKbn> {

    @Override
    protected Class<C_NrhnkKbn> returnType() {
        return C_NrhnkKbn.class;
    }

    @Override
    protected C_NrhnkKbn valueOf(String pValue) {
        return C_NrhnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NrhnkKbn pValue) {
        return pValue.getValue();
    }
}
