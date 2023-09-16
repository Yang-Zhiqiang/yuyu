package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_InputnaiyoukakKbn;

/**
 * {@link C_InputnaiyoukakKbn 入力内容確認区分} の Hibernate ユーザー定義型です。<br />
 * 入力内容確認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_InputnaiyoukakKbn extends AbstractUserType<C_InputnaiyoukakKbn> {

    @Override
    protected Class<C_InputnaiyoukakKbn> returnType() {
        return C_InputnaiyoukakKbn.class;
    }

    @Override
    protected C_InputnaiyoukakKbn valueOf(String pValue) {
        return C_InputnaiyoukakKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_InputnaiyoukakKbn pValue) {
        return pValue.getValue();
    }
}
