package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SateikekkaKbn;

/**
 * {@link C_SateikekkaKbn 査定結果区分} の Hibernate ユーザー定義型です。<br />
 * 査定結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SateikekkaKbn extends AbstractUserType<C_SateikekkaKbn> {

    @Override
    protected Class<C_SateikekkaKbn> returnType() {
        return C_SateikekkaKbn.class;
    }

    @Override
    protected C_SateikekkaKbn valueOf(String pValue) {
        return C_SateikekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SateikekkaKbn pValue) {
        return pValue.getValue();
    }
}
