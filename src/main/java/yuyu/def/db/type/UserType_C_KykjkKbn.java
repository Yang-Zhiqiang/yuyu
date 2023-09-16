package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykjkKbn;

/**
 * {@link C_KykjkKbn 契約状況区分} の Hibernate ユーザー定義型です。<br />
 * 契約状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykjkKbn extends AbstractUserType<C_KykjkKbn> {

    @Override
    protected Class<C_KykjkKbn> returnType() {
        return C_KykjkKbn.class;
    }

    @Override
    protected C_KykjkKbn valueOf(String pValue) {
        return C_KykjkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykjkKbn pValue) {
        return pValue.getValue();
    }
}
