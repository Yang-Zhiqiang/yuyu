package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Dsnflg;

/**
 * {@link C_Dsnflg 代申フラグ} の Hibernate ユーザー定義型です。<br />
 * 代申フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Dsnflg extends AbstractUserType<C_Dsnflg> {

    @Override
    protected Class<C_Dsnflg> returnType() {
        return C_Dsnflg.class;
    }

    @Override
    protected C_Dsnflg valueOf(String pValue) {
        return C_Dsnflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Dsnflg pValue) {
        return pValue.getValue();
    }
}
