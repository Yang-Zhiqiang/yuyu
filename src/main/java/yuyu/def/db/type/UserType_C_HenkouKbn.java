package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HenkouKbn;

/**
 * {@link C_HenkouKbn 変更区分} の Hibernate ユーザー定義型です。<br />
 * 変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HenkouKbn extends AbstractUserType<C_HenkouKbn> {

    @Override
    protected Class<C_HenkouKbn> returnType() {
        return C_HenkouKbn.class;
    }

    @Override
    protected C_HenkouKbn valueOf(String pValue) {
        return C_HenkouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HenkouKbn pValue) {
        return pValue.getValue();
    }
}
