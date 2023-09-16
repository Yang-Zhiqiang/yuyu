package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ImagerenkeiKbn;

/**
 * {@link C_ImagerenkeiKbn イメージ連携区分} の Hibernate ユーザー定義型です。<br />
 * イメージ連携区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ImagerenkeiKbn extends AbstractUserType<C_ImagerenkeiKbn> {

    @Override
    protected Class<C_ImagerenkeiKbn> returnType() {
        return C_ImagerenkeiKbn.class;
    }

    @Override
    protected C_ImagerenkeiKbn valueOf(String pValue) {
        return C_ImagerenkeiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ImagerenkeiKbn pValue) {
        return pValue.getValue();
    }
}
