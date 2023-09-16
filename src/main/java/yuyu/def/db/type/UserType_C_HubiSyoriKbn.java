package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HubiSyoriKbn;

/**
 * {@link C_HubiSyoriKbn 不備用処理区分} の Hibernate ユーザー定義型です。<br />
 * 不備用処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HubiSyoriKbn extends AbstractUserType<C_HubiSyoriKbn> {

    @Override
    protected Class<C_HubiSyoriKbn> returnType() {
        return C_HubiSyoriKbn.class;
    }

    @Override
    protected C_HubiSyoriKbn valueOf(String pValue) {
        return C_HubiSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HubiSyoriKbn pValue) {
        return pValue.getValue();
    }
}
