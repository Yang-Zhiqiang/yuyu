package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;

/**
 * {@link C_MQSyoukaiErrorKbn ＭＱ照会エラー区分} の Hibernate ユーザー定義型です。<br />
 * ＭＱ照会エラー区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MQSyoukaiErrorKbn extends AbstractUserType<C_MQSyoukaiErrorKbn> {

    @Override
    protected Class<C_MQSyoukaiErrorKbn> returnType() {
        return C_MQSyoukaiErrorKbn.class;
    }

    @Override
    protected C_MQSyoukaiErrorKbn valueOf(String pValue) {
        return C_MQSyoukaiErrorKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MQSyoukaiErrorKbn pValue) {
        return pValue.getValue();
    }
}
