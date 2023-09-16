package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DatatorikomiKbn;

/**
 * {@link C_DatatorikomiKbn データ取込区分} の Hibernate ユーザー定義型です。<br />
 * データ取込区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DatatorikomiKbn extends AbstractUserType<C_DatatorikomiKbn> {

    @Override
    protected Class<C_DatatorikomiKbn> returnType() {
        return C_DatatorikomiKbn.class;
    }

    @Override
    protected C_DatatorikomiKbn valueOf(String pValue) {
        return C_DatatorikomiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DatatorikomiKbn pValue) {
        return pValue.getValue();
    }
}
