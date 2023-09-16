package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZaimukaikeirecSyubetu;

/**
 * {@link C_ZaimukaikeirecSyubetu 財務会計レコード種別} の Hibernate ユーザー定義型です。<br />
 * 財務会計レコード種別 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZaimukaikeirecSyubetu extends AbstractUserType<C_ZaimukaikeirecSyubetu> {

    @Override
    protected Class<C_ZaimukaikeirecSyubetu> returnType() {
        return C_ZaimukaikeirecSyubetu.class;
    }

    @Override
    protected C_ZaimukaikeirecSyubetu valueOf(String pValue) {
        return C_ZaimukaikeirecSyubetu.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZaimukaikeirecSyubetu pValue) {
        return pValue.getValue();
    }
}
