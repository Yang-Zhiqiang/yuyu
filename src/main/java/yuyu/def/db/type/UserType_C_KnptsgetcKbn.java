package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KnptsgetcKbn;

/**
 * {@link C_KnptsgetcKbn 健保対象外（その他）区分} の Hibernate ユーザー定義型です。<br />
 * 健保対象外（その他）区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KnptsgetcKbn extends AbstractUserType<C_KnptsgetcKbn> {

    @Override
    protected Class<C_KnptsgetcKbn> returnType() {
        return C_KnptsgetcKbn.class;
    }

    @Override
    protected C_KnptsgetcKbn valueOf(String pValue) {
        return C_KnptsgetcKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KnptsgetcKbn pValue) {
        return pValue.getValue();
    }
}
