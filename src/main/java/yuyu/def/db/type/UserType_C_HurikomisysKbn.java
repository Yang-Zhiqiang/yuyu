package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HurikomisysKbn;

/**
 * {@link C_HurikomisysKbn 振込システム区分} の Hibernate ユーザー定義型です。<br />
 * 振込システム区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HurikomisysKbn extends AbstractUserType<C_HurikomisysKbn> {

    @Override
    protected Class<C_HurikomisysKbn> returnType() {
        return C_HurikomisysKbn.class;
    }

    @Override
    protected C_HurikomisysKbn valueOf(String pValue) {
        return C_HurikomisysKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HurikomisysKbn pValue) {
        return pValue.getValue();
    }
}
