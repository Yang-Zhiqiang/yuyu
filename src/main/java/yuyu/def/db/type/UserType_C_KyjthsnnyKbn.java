package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyjthsnnyKbn;

/**
 * {@link C_KyjthsnnyKbn 休日不算入区分} の Hibernate ユーザー定義型です。<br />
 * 休日不算入区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyjthsnnyKbn extends AbstractUserType<C_KyjthsnnyKbn> {

    @Override
    protected Class<C_KyjthsnnyKbn> returnType() {
        return C_KyjthsnnyKbn.class;
    }

    @Override
    protected C_KyjthsnnyKbn valueOf(String pValue) {
        return C_KyjthsnnyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyjthsnnyKbn pValue) {
        return pValue.getValue();
    }
}
