package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ItkkoukaikijyunKbn;

/**
 * {@link C_ItkkoukaikijyunKbn 委託更改基準区分} の Hibernate ユーザー定義型です。<br />
 * 委託更改基準区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ItkkoukaikijyunKbn extends AbstractUserType<C_ItkkoukaikijyunKbn> {

    @Override
    protected Class<C_ItkkoukaikijyunKbn> returnType() {
        return C_ItkkoukaikijyunKbn.class;
    }

    @Override
    protected C_ItkkoukaikijyunKbn valueOf(String pValue) {
        return C_ItkkoukaikijyunKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ItkkoukaikijyunKbn pValue) {
        return pValue.getValue();
    }
}
