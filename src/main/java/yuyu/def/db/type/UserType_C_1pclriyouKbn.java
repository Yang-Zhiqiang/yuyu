package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_1pclriyouKbn;

/**
 * {@link C_1pclriyouKbn １ＰＣＬ利用区分} の Hibernate ユーザー定義型です。<br />
 * １ＰＣＬ利用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_1pclriyouKbn extends AbstractUserType<C_1pclriyouKbn> {

    @Override
    protected Class<C_1pclriyouKbn> returnType() {
        return C_1pclriyouKbn.class;
    }

    @Override
    protected C_1pclriyouKbn valueOf(String pValue) {
        return C_1pclriyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_1pclriyouKbn pValue) {
        return pValue.getValue();
    }
}
