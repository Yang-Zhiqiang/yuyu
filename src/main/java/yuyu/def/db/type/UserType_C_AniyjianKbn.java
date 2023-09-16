package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AniyjianKbn;

/**
 * {@link C_AniyjianKbn 案内要事案区分} の Hibernate ユーザー定義型です。<br />
 * 案内要事案区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AniyjianKbn extends AbstractUserType<C_AniyjianKbn> {

    @Override
    protected Class<C_AniyjianKbn> returnType() {
        return C_AniyjianKbn.class;
    }

    @Override
    protected C_AniyjianKbn valueOf(String pValue) {
        return C_AniyjianKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AniyjianKbn pValue) {
        return pValue.getValue();
    }
}
