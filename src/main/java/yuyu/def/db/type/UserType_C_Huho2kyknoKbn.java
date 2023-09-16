package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Huho2kyknoKbn;

/**
 * {@link C_Huho2kyknoKbn 普保Ⅱ契約番号区分} の Hibernate ユーザー定義型です。<br />
 * 普保Ⅱ契約番号区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Huho2kyknoKbn extends AbstractUserType<C_Huho2kyknoKbn> {

    @Override
    protected Class<C_Huho2kyknoKbn> returnType() {
        return C_Huho2kyknoKbn.class;
    }

    @Override
    protected C_Huho2kyknoKbn valueOf(String pValue) {
        return C_Huho2kyknoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Huho2kyknoKbn pValue) {
        return pValue.getValue();
    }
}
