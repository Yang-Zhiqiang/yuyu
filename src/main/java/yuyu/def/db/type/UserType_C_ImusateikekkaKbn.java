package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ImusateikekkaKbn;

/**
 * {@link C_ImusateikekkaKbn 医務査定結果区分} の Hibernate ユーザー定義型です。<br />
 * 医務査定結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ImusateikekkaKbn extends AbstractUserType<C_ImusateikekkaKbn> {

    @Override
    protected Class<C_ImusateikekkaKbn> returnType() {
        return C_ImusateikekkaKbn.class;
    }

    @Override
    protected C_ImusateikekkaKbn valueOf(String pValue) {
        return C_ImusateikekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ImusateikekkaKbn pValue) {
        return pValue.getValue();
    }
}
