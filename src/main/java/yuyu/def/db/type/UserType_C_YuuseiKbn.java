package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YuuseiKbn;

/**
 * {@link C_YuuseiKbn 郵政区分} の Hibernate ユーザー定義型です。<br />
 * 郵政区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YuuseiKbn extends AbstractUserType<C_YuuseiKbn> {

    @Override
    protected Class<C_YuuseiKbn> returnType() {
        return C_YuuseiKbn.class;
    }

    @Override
    protected C_YuuseiKbn valueOf(String pValue) {
        return C_YuuseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YuuseiKbn pValue) {
        return pValue.getValue();
    }
}
