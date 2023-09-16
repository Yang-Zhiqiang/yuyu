package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KikenshrsisuuKbn;

/**
 * {@link C_KikenshrsisuuKbn 危険支払指数区分} の Hibernate ユーザー定義型です。<br />
 * 危険支払指数区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KikenshrsisuuKbn extends AbstractUserType<C_KikenshrsisuuKbn> {

    @Override
    protected Class<C_KikenshrsisuuKbn> returnType() {
        return C_KikenshrsisuuKbn.class;
    }

    @Override
    protected C_KikenshrsisuuKbn valueOf(String pValue) {
        return C_KikenshrsisuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KikenshrsisuuKbn pValue) {
        return pValue.getValue();
    }
}
