package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HosyouKinouKbn;

/**
 * {@link C_HosyouKinouKbn 保障機能区分} の Hibernate ユーザー定義型です。<br />
 * 保障機能区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HosyouKinouKbn extends AbstractUserType<C_HosyouKinouKbn> {

    @Override
    protected Class<C_HosyouKinouKbn> returnType() {
        return C_HosyouKinouKbn.class;
    }

    @Override
    protected C_HosyouKinouKbn valueOf(String pValue) {
        return C_HosyouKinouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HosyouKinouKbn pValue) {
        return pValue.getValue();
    }
}
