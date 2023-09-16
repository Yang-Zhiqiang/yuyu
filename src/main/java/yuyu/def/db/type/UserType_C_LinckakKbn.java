package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LinckakKbn;

/**
 * {@link C_LinckakKbn ＬＩＮＣ確認区分} の Hibernate ユーザー定義型です。<br />
 * ＬＩＮＣ確認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LinckakKbn extends AbstractUserType<C_LinckakKbn> {

    @Override
    protected Class<C_LinckakKbn> returnType() {
        return C_LinckakKbn.class;
    }

    @Override
    protected C_LinckakKbn valueOf(String pValue) {
        return C_LinckakKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LinckakKbn pValue) {
        return pValue.getValue();
    }
}
