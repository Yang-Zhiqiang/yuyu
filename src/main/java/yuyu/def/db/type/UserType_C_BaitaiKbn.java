package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BaitaiKbn;

/**
 * {@link C_BaitaiKbn 媒体区分} の Hibernate ユーザー定義型です。<br />
 * 媒体区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BaitaiKbn extends AbstractUserType<C_BaitaiKbn> {

    @Override
    protected Class<C_BaitaiKbn> returnType() {
        return C_BaitaiKbn.class;
    }

    @Override
    protected C_BaitaiKbn valueOf(String pValue) {
        return C_BaitaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BaitaiKbn pValue) {
        return pValue.getValue();
    }
}
