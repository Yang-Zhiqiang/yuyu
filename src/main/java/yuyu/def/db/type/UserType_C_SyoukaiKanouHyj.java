package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoukaiKanouHyj;

/**
 * {@link C_SyoukaiKanouHyj 照会可能表示} の Hibernate ユーザー定義型です。<br />
 * 照会可能表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoukaiKanouHyj extends AbstractUserType<C_SyoukaiKanouHyj> {

    @Override
    protected Class<C_SyoukaiKanouHyj> returnType() {
        return C_SyoukaiKanouHyj.class;
    }

    @Override
    protected C_SyoukaiKanouHyj valueOf(String pValue) {
        return C_SyoukaiKanouHyj.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoukaiKanouHyj pValue) {
        return pValue.getValue();
    }
}
