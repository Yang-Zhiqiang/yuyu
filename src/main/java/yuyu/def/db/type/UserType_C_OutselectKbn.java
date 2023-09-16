package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_OutselectKbn;

/**
 * {@link C_OutselectKbn 出力選択区分} の Hibernate ユーザー定義型です。<br />
 * 出力選択区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_OutselectKbn extends AbstractUserType<C_OutselectKbn> {

    @Override
    protected Class<C_OutselectKbn> returnType() {
        return C_OutselectKbn.class;
    }

    @Override
    protected C_OutselectKbn valueOf(String pValue) {
        return C_OutselectKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_OutselectKbn pValue) {
        return pValue.getValue();
    }
}
