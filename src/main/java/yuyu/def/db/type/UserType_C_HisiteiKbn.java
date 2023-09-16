package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HisiteiKbn;

/**
 * {@link C_HisiteiKbn 日指定区分} の Hibernate ユーザー定義型です。<br />
 * 日指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HisiteiKbn extends AbstractUserType<C_HisiteiKbn> {

    @Override
    protected Class<C_HisiteiKbn> returnType() {
        return C_HisiteiKbn.class;
    }

    @Override
    protected C_HisiteiKbn valueOf(String pValue) {
        return C_HisiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HisiteiKbn pValue) {
        return pValue.getValue();
    }
}
