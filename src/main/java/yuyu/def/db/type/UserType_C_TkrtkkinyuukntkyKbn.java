package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TkrtkkinyuukntkyKbn;

/**
 * {@link C_TkrtkkinyuukntkyKbn 特例地域金融機関適用区分} の Hibernate ユーザー定義型です。<br />
 * 特例地域金融機関適用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TkrtkkinyuukntkyKbn extends AbstractUserType<C_TkrtkkinyuukntkyKbn> {

    @Override
    protected Class<C_TkrtkkinyuukntkyKbn> returnType() {
        return C_TkrtkkinyuukntkyKbn.class;
    }

    @Override
    protected C_TkrtkkinyuukntkyKbn valueOf(String pValue) {
        return C_TkrtkkinyuukntkyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TkrtkkinyuukntkyKbn pValue) {
        return pValue.getValue();
    }
}
