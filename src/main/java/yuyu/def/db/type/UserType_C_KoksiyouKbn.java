package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KoksiyouKbn;

/**
 * {@link C_KoksiyouKbn 顧客使用区分} の Hibernate ユーザー定義型です。<br />
 * 顧客使用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KoksiyouKbn extends AbstractUserType<C_KoksiyouKbn> {

    @Override
    protected Class<C_KoksiyouKbn> returnType() {
        return C_KoksiyouKbn.class;
    }

    @Override
    protected C_KoksiyouKbn valueOf(String pValue) {
        return C_KoksiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KoksiyouKbn pValue) {
        return pValue.getValue();
    }
}
