package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HubiKouteiKekkaKbn;

/**
 * {@link C_HubiKouteiKekkaKbn 不備工程結果区分} の Hibernate ユーザー定義型です。<br />
 * 不備工程結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HubiKouteiKekkaKbn extends AbstractUserType<C_HubiKouteiKekkaKbn> {

    @Override
    protected Class<C_HubiKouteiKekkaKbn> returnType() {
        return C_HubiKouteiKekkaKbn.class;
    }

    @Override
    protected C_HubiKouteiKekkaKbn valueOf(String pValue) {
        return C_HubiKouteiKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HubiKouteiKekkaKbn pValue) {
        return pValue.getValue();
    }
}
