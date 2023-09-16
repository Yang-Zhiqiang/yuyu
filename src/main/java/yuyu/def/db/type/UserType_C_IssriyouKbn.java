package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IssriyouKbn;

/**
 * {@link C_IssriyouKbn ＩＳＳ利用区分} の Hibernate ユーザー定義型です。<br />
 * ＩＳＳ利用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IssriyouKbn extends AbstractUserType<C_IssriyouKbn> {

    @Override
    protected Class<C_IssriyouKbn> returnType() {
        return C_IssriyouKbn.class;
    }

    @Override
    protected C_IssriyouKbn valueOf(String pValue) {
        return C_IssriyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IssriyouKbn pValue) {
        return pValue.getValue();
    }
}
