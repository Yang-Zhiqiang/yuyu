package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyouhyousakuseiKbn;

/**
 * {@link C_TyouhyousakuseiKbn 帳票作成区分} の Hibernate ユーザー定義型です。<br />
 * 帳票作成区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyouhyousakuseiKbn extends AbstractUserType<C_TyouhyousakuseiKbn> {

    @Override
    protected Class<C_TyouhyousakuseiKbn> returnType() {
        return C_TyouhyousakuseiKbn.class;
    }

    @Override
    protected C_TyouhyousakuseiKbn valueOf(String pValue) {
        return C_TyouhyousakuseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyouhyousakuseiKbn pValue) {
        return pValue.getValue();
    }
}
