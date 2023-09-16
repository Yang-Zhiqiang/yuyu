package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DensyoriKbn;

/**
 * {@link C_DensyoriKbn 伝票処理区分} の Hibernate ユーザー定義型です。<br />
 * 伝票処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DensyoriKbn extends AbstractUserType<C_DensyoriKbn> {

    @Override
    protected Class<C_DensyoriKbn> returnType() {
        return C_DensyoriKbn.class;
    }

    @Override
    protected C_DensyoriKbn valueOf(String pValue) {
        return C_DensyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DensyoriKbn pValue) {
        return pValue.getValue();
    }
}
