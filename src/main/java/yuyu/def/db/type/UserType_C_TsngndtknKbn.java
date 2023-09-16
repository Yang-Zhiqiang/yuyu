package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsngndtknKbn;

/**
 * {@link C_TsngndtknKbn 通算限度特認区分} の Hibernate ユーザー定義型です。<br />
 * 通算限度特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsngndtknKbn extends AbstractUserType<C_TsngndtknKbn> {

    @Override
    protected Class<C_TsngndtknKbn> returnType() {
        return C_TsngndtknKbn.class;
    }

    @Override
    protected C_TsngndtknKbn valueOf(String pValue) {
        return C_TsngndtknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsngndtknKbn pValue) {
        return pValue.getValue();
    }
}
