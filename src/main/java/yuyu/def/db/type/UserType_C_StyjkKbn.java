package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_StyjkKbn;

/**
 * {@link C_StyjkKbn 進捗状況区分} の Hibernate ユーザー定義型です。<br />
 * 進捗状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_StyjkKbn extends AbstractUserType<C_StyjkKbn> {

    @Override
    protected Class<C_StyjkKbn> returnType() {
        return C_StyjkKbn.class;
    }

    @Override
    protected C_StyjkKbn valueOf(String pValue) {
        return C_StyjkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_StyjkKbn pValue) {
        return pValue.getValue();
    }
}
