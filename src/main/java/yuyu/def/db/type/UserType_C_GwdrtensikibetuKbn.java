package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GwdrtensikibetuKbn;

/**
 * {@link C_GwdrtensikibetuKbn ＧＷ代理店識別区分} の Hibernate ユーザー定義型です。<br />
 * ＧＷ代理店識別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GwdrtensikibetuKbn extends AbstractUserType<C_GwdrtensikibetuKbn> {

    @Override
    protected Class<C_GwdrtensikibetuKbn> returnType() {
        return C_GwdrtensikibetuKbn.class;
    }

    @Override
    protected C_GwdrtensikibetuKbn valueOf(String pValue) {
        return C_GwdrtensikibetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GwdrtensikibetuKbn pValue) {
        return pValue.getValue();
    }
}
