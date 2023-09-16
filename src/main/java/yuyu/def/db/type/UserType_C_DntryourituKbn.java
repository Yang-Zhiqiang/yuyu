package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DntryourituKbn;

/**
 * {@link C_DntryourituKbn 団体料率区分} の Hibernate ユーザー定義型です。<br />
 * 団体料率区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DntryourituKbn extends AbstractUserType<C_DntryourituKbn> {

    @Override
    protected Class<C_DntryourituKbn> returnType() {
        return C_DntryourituKbn.class;
    }

    @Override
    protected C_DntryourituKbn valueOf(String pValue) {
        return C_DntryourituKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DntryourituKbn pValue) {
        return pValue.getValue();
    }
}
