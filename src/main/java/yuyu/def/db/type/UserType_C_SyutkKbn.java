package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyutkKbn;

/**
 * {@link C_SyutkKbn 主契約特約区分} の Hibernate ユーザー定義型です。<br />
 * 主契約特約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyutkKbn extends AbstractUserType<C_SyutkKbn> {

    @Override
    protected Class<C_SyutkKbn> returnType() {
        return C_SyutkKbn.class;
    }

    @Override
    protected C_SyutkKbn valueOf(String pValue) {
        return C_SyutkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyutkKbn pValue) {
        return pValue.getValue();
    }
}
