package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyouteiSyouinKbn;

/**
 * {@link C_KyouteiSyouinKbn 協定消因区分} の Hibernate ユーザー定義型です。<br />
 * 協定消因区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyouteiSyouinKbn extends AbstractUserType<C_KyouteiSyouinKbn> {

    @Override
    protected Class<C_KyouteiSyouinKbn> returnType() {
        return C_KyouteiSyouinKbn.class;
    }

    @Override
    protected C_KyouteiSyouinKbn valueOf(String pValue) {
        return C_KyouteiSyouinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyouteiSyouinKbn pValue) {
        return pValue.getValue();
    }
}
