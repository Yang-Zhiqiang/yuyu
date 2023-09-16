package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TkhjnsyoriKbn;

/**
 * {@link C_TkhjnsyoriKbn 特定関係法人処理区分} の Hibernate ユーザー定義型です。<br />
 * 特定関係法人処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TkhjnsyoriKbn extends AbstractUserType<C_TkhjnsyoriKbn> {

    @Override
    protected Class<C_TkhjnsyoriKbn> returnType() {
        return C_TkhjnsyoriKbn.class;
    }

    @Override
    protected C_TkhjnsyoriKbn valueOf(String pValue) {
        return C_TkhjnsyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TkhjnsyoriKbn pValue) {
        return pValue.getValue();
    }
}
