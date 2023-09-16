package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UkenoKbn;

/**
 * {@link C_UkenoKbn 受付番号区分} の Hibernate ユーザー定義型です。<br />
 * 受付番号区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UkenoKbn extends AbstractUserType<C_UkenoKbn> {

    @Override
    protected Class<C_UkenoKbn> returnType() {
        return C_UkenoKbn.class;
    }

    @Override
    protected C_UkenoKbn valueOf(String pValue) {
        return C_UkenoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UkenoKbn pValue) {
        return pValue.getValue();
    }
}
