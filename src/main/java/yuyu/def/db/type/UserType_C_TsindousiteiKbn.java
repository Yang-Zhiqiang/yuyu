package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsindousiteiKbn;

/**
 * {@link C_TsindousiteiKbn 通信先同一指定区分} の Hibernate ユーザー定義型です。<br />
 * 通信先同一指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsindousiteiKbn extends AbstractUserType<C_TsindousiteiKbn> {

    @Override
    protected Class<C_TsindousiteiKbn> returnType() {
        return C_TsindousiteiKbn.class;
    }

    @Override
    protected C_TsindousiteiKbn valueOf(String pValue) {
        return C_TsindousiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsindousiteiKbn pValue) {
        return pValue.getValue();
    }
}
