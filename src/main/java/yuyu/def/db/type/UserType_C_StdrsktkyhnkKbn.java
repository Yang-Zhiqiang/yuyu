package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_StdrsktkyhnkKbn;

/**
 * {@link C_StdrsktkyhnkKbn 指定代理請求特約変更区分} の Hibernate ユーザー定義型です。<br />
 * 指定代理請求特約変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_StdrsktkyhnkKbn extends AbstractUserType<C_StdrsktkyhnkKbn> {

    @Override
    protected Class<C_StdrsktkyhnkKbn> returnType() {
        return C_StdrsktkyhnkKbn.class;
    }

    @Override
    protected C_StdrsktkyhnkKbn valueOf(String pValue) {
        return C_StdrsktkyhnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_StdrsktkyhnkKbn pValue) {
        return pValue.getValue();
    }
}
