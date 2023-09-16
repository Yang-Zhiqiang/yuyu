package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NyuukinHenkinSyoriKbn;

/**
 * {@link C_NyuukinHenkinSyoriKbn 入金返金処理区分} の Hibernate ユーザー定義型です。<br />
 * 入金返金処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NyuukinHenkinSyoriKbn extends AbstractUserType<C_NyuukinHenkinSyoriKbn> {

    @Override
    protected Class<C_NyuukinHenkinSyoriKbn> returnType() {
        return C_NyuukinHenkinSyoriKbn.class;
    }

    @Override
    protected C_NyuukinHenkinSyoriKbn valueOf(String pValue) {
        return C_NyuukinHenkinSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NyuukinHenkinSyoriKbn pValue) {
        return pValue.getValue();
    }
}
