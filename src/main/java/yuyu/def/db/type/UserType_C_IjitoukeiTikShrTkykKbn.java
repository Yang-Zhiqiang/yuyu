package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IjitoukeiTikShrTkykKbn;

/**
 * {@link C_IjitoukeiTikShrTkykKbn 医事統計用定期支払特約区分} の Hibernate ユーザー定義型です。<br />
 * 医事統計用定期支払特約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IjitoukeiTikShrTkykKbn extends AbstractUserType<C_IjitoukeiTikShrTkykKbn> {

    @Override
    protected Class<C_IjitoukeiTikShrTkykKbn> returnType() {
        return C_IjitoukeiTikShrTkykKbn.class;
    }

    @Override
    protected C_IjitoukeiTikShrTkykKbn valueOf(String pValue) {
        return C_IjitoukeiTikShrTkykKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IjitoukeiTikShrTkykKbn pValue) {
        return pValue.getValue();
    }
}
