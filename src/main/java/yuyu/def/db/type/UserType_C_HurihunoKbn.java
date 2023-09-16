package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HurihunoKbn;

/**
 * {@link C_HurihunoKbn 振替不能理由区分} の Hibernate ユーザー定義型です。<br />
 * 振替不能理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HurihunoKbn extends AbstractUserType<C_HurihunoKbn> {

    @Override
    protected Class<C_HurihunoKbn> returnType() {
        return C_HurihunoKbn.class;
    }

    @Override
    protected C_HurihunoKbn valueOf(String pValue) {
        return C_HurihunoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HurihunoKbn pValue) {
        return pValue.getValue();
    }
}
