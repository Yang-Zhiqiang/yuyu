package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MukouHyj;

/**
 * {@link C_MukouHyj 無効表示} の Hibernate ユーザー定義型です。<br />
 * 無効表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MukouHyj extends AbstractUserType<C_MukouHyj> {

    @Override
    protected Class<C_MukouHyj> returnType() {
        return C_MukouHyj.class;
    }

    @Override
    protected C_MukouHyj valueOf(String pValue) {
        return C_MukouHyj.valueOf(pValue);
    }

    @Override
    protected String toString(C_MukouHyj pValue) {
        return pValue.getValue();
    }
}
