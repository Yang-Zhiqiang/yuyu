package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BoskyuusiRiyuuKbn;

/**
 * {@link C_BoskyuusiRiyuuKbn 募集休止理由区分} の Hibernate ユーザー定義型です。<br />
 * 募集休止理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BoskyuusiRiyuuKbn extends AbstractUserType<C_BoskyuusiRiyuuKbn> {

    @Override
    protected Class<C_BoskyuusiRiyuuKbn> returnType() {
        return C_BoskyuusiRiyuuKbn.class;
    }

    @Override
    protected C_BoskyuusiRiyuuKbn valueOf(String pValue) {
        return C_BoskyuusiRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BoskyuusiRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
