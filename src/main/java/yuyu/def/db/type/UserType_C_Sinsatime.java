package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Sinsatime;

/**
 * {@link C_Sinsatime 診査時刻} の Hibernate ユーザー定義型です。<br />
 * 診査時刻 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Sinsatime extends AbstractUserType<C_Sinsatime> {

    @Override
    protected Class<C_Sinsatime> returnType() {
        return C_Sinsatime.class;
    }

    @Override
    protected C_Sinsatime valueOf(String pValue) {
        return C_Sinsatime.valueOf(pValue);
    }

    @Override
    protected String toString(C_Sinsatime pValue) {
        return pValue.getValue();
    }
}
