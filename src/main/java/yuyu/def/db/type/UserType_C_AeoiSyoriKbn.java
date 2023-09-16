package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AeoiSyoriKbn;

/**
 * {@link C_AeoiSyoriKbn ＡＥＯＩ処理区分} の Hibernate ユーザー定義型です。<br />
 * ＡＥＯＩ処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AeoiSyoriKbn extends AbstractUserType<C_AeoiSyoriKbn> {

    @Override
    protected Class<C_AeoiSyoriKbn> returnType() {
        return C_AeoiSyoriKbn.class;
    }

    @Override
    protected C_AeoiSyoriKbn valueOf(String pValue) {
        return C_AeoiSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AeoiSyoriKbn pValue) {
        return pValue.getValue();
    }
}
