package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LinckknnjkKbn;

/**
 * {@link C_LinckknnjkKbn ＬＩＮＣ確認状況区分} の Hibernate ユーザー定義型です。<br />
 * ＬＩＮＣ確認状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LinckknnjkKbn extends AbstractUserType<C_LinckknnjkKbn> {

    @Override
    protected Class<C_LinckknnjkKbn> returnType() {
        return C_LinckknnjkKbn.class;
    }

    @Override
    protected C_LinckknnjkKbn valueOf(String pValue) {
        return C_LinckknnjkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LinckknnjkKbn pValue) {
        return pValue.getValue();
    }
}
