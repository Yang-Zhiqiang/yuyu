package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShiharaikekkadataKbn;

/**
 * {@link C_ShiharaikekkadataKbn 支払結果データ区分} の Hibernate ユーザー定義型です。<br />
 * 支払結果データ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShiharaikekkadataKbn extends AbstractUserType<C_ShiharaikekkadataKbn> {

    @Override
    protected Class<C_ShiharaikekkadataKbn> returnType() {
        return C_ShiharaikekkadataKbn.class;
    }

    @Override
    protected C_ShiharaikekkadataKbn valueOf(String pValue) {
        return C_ShiharaikekkadataKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShiharaikekkadataKbn pValue) {
        return pValue.getValue();
    }
}
