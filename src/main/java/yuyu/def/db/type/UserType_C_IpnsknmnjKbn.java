package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IpnsknmnjKbn;

/**
 * {@link C_IpnsknmnjKbn 一般課程試験免除区分} の Hibernate ユーザー定義型です。<br />
 * 一般課程試験免除区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IpnsknmnjKbn extends AbstractUserType<C_IpnsknmnjKbn> {

    @Override
    protected Class<C_IpnsknmnjKbn> returnType() {
        return C_IpnsknmnjKbn.class;
    }

    @Override
    protected C_IpnsknmnjKbn valueOf(String pValue) {
        return C_IpnsknmnjKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IpnsknmnjKbn pValue) {
        return pValue.getValue();
    }
}
