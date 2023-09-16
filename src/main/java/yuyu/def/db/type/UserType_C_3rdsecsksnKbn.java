package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_3rdsecsksnKbn;

/**
 * {@link C_3rdsecsksnKbn 第三分野Ｓ計算区分} の Hibernate ユーザー定義型です。<br />
 * 第三分野Ｓ計算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_3rdsecsksnKbn extends AbstractUserType<C_3rdsecsksnKbn> {

    @Override
    protected Class<C_3rdsecsksnKbn> returnType() {
        return C_3rdsecsksnKbn.class;
    }

    @Override
    protected C_3rdsecsksnKbn valueOf(String pValue) {
        return C_3rdsecsksnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_3rdsecsksnKbn pValue) {
        return pValue.getValue();
    }
}
