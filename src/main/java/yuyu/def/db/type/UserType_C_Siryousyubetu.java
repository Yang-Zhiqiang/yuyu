package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Siryousyubetu;

/**
 * {@link C_Siryousyubetu 資料種別} の Hibernate ユーザー定義型です。<br />
 * 資料種別 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Siryousyubetu extends AbstractUserType<C_Siryousyubetu> {

    @Override
    protected Class<C_Siryousyubetu> returnType() {
        return C_Siryousyubetu.class;
    }

    @Override
    protected C_Siryousyubetu valueOf(String pValue) {
        return C_Siryousyubetu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Siryousyubetu pValue) {
        return pValue.getValue();
    }
}
