package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KawasetsryKbn;

/**
 * {@link C_KawasetsryKbn 為替手数料区分} の Hibernate ユーザー定義型です。<br />
 * 為替手数料区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KawasetsryKbn extends AbstractUserType<C_KawasetsryKbn> {

    @Override
    protected Class<C_KawasetsryKbn> returnType() {
        return C_KawasetsryKbn.class;
    }

    @Override
    protected C_KawasetsryKbn valueOf(String pValue) {
        return C_KawasetsryKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KawasetsryKbn pValue) {
        return pValue.getValue();
    }
}
