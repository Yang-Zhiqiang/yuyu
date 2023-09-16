package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SykDrtenTsryTypeKbn;

/**
 * {@link C_SykDrtenTsryTypeKbn 紹介代理店手数料タイプ区分} の Hibernate ユーザー定義型です。<br />
 * 紹介代理店手数料タイプ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SykDrtenTsryTypeKbn extends AbstractUserType<C_SykDrtenTsryTypeKbn> {

    @Override
    protected Class<C_SykDrtenTsryTypeKbn> returnType() {
        return C_SykDrtenTsryTypeKbn.class;
    }

    @Override
    protected C_SykDrtenTsryTypeKbn valueOf(String pValue) {
        return C_SykDrtenTsryTypeKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SykDrtenTsryTypeKbn pValue) {
        return pValue.getValue();
    }
}
