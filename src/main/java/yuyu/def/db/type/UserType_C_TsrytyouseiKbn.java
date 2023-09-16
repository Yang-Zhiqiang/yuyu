package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsrytyouseiKbn;

/**
 * {@link C_TsrytyouseiKbn 手数料調整区分} の Hibernate ユーザー定義型です。<br />
 * 手数料調整区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsrytyouseiKbn extends AbstractUserType<C_TsrytyouseiKbn> {

    @Override
    protected Class<C_TsrytyouseiKbn> returnType() {
        return C_TsrytyouseiKbn.class;
    }

    @Override
    protected C_TsrytyouseiKbn valueOf(String pValue) {
        return C_TsrytyouseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsrytyouseiKbn pValue) {
        return pValue.getValue();
    }
}
