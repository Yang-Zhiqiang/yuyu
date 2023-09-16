package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TekikknsiteiKbn;

/**
 * {@link C_TekikknsiteiKbn 適用期間指定区分} の Hibernate ユーザー定義型です。<br />
 * 適用期間指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TekikknsiteiKbn extends AbstractUserType<C_TekikknsiteiKbn> {

    @Override
    protected Class<C_TekikknsiteiKbn> returnType() {
        return C_TekikknsiteiKbn.class;
    }

    @Override
    protected C_TekikknsiteiKbn valueOf(String pValue) {
        return C_TekikknsiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TekikknsiteiKbn pValue) {
        return pValue.getValue();
    }
}
