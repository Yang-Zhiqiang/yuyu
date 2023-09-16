package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MnkuktKbn;

/**
 * {@link C_MnkuktKbn 満期受取人区分} の Hibernate ユーザー定義型です。<br />
 * 満期受取人区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MnkuktKbn extends AbstractUserType<C_MnkuktKbn> {

    @Override
    protected Class<C_MnkuktKbn> returnType() {
        return C_MnkuktKbn.class;
    }

    @Override
    protected C_MnkuktKbn valueOf(String pValue) {
        return C_MnkuktKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MnkuktKbn pValue) {
        return pValue.getValue();
    }
}
