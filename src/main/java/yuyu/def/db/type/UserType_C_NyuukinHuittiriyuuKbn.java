package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NyuukinHuittiriyuuKbn;

/**
 * {@link C_NyuukinHuittiriyuuKbn 入金不一致理由区分} の Hibernate ユーザー定義型です。<br />
 * 入金不一致理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NyuukinHuittiriyuuKbn extends AbstractUserType<C_NyuukinHuittiriyuuKbn> {

    @Override
    protected Class<C_NyuukinHuittiriyuuKbn> returnType() {
        return C_NyuukinHuittiriyuuKbn.class;
    }

    @Override
    protected C_NyuukinHuittiriyuuKbn valueOf(String pValue) {
        return C_NyuukinHuittiriyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NyuukinHuittiriyuuKbn pValue) {
        return pValue.getValue();
    }
}
