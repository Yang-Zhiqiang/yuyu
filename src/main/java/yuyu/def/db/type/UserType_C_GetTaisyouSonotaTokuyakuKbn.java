package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GetTaisyouSonotaTokuyakuKbn;

/**
 * {@link C_GetTaisyouSonotaTokuyakuKbn 取得対象その他特約区分} の Hibernate ユーザー定義型です。<br />
 * 取得対象その他特約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GetTaisyouSonotaTokuyakuKbn extends AbstractUserType<C_GetTaisyouSonotaTokuyakuKbn> {

    @Override
    protected Class<C_GetTaisyouSonotaTokuyakuKbn> returnType() {
        return C_GetTaisyouSonotaTokuyakuKbn.class;
    }

    @Override
    protected C_GetTaisyouSonotaTokuyakuKbn valueOf(String pValue) {
        return C_GetTaisyouSonotaTokuyakuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GetTaisyouSonotaTokuyakuKbn pValue) {
        return pValue.getValue();
    }
}
