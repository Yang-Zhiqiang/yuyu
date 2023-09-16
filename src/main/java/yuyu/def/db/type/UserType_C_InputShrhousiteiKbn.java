package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_InputShrhousiteiKbn;

/**
 * {@link C_InputShrhousiteiKbn 入力用支払方法指定区分} の Hibernate ユーザー定義型です。<br />
 * 入力用支払方法指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_InputShrhousiteiKbn extends AbstractUserType<C_InputShrhousiteiKbn> {

    @Override
    protected Class<C_InputShrhousiteiKbn> returnType() {
        return C_InputShrhousiteiKbn.class;
    }

    @Override
    protected C_InputShrhousiteiKbn valueOf(String pValue) {
        return C_InputShrhousiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_InputShrhousiteiKbn pValue) {
        return pValue.getValue();
    }
}
