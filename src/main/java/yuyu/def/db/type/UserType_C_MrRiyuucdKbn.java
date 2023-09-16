package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MrRiyuucdKbn;

/**
 * {@link C_MrRiyuucdKbn ＭＲ理由コード区分} の Hibernate ユーザー定義型です。<br />
 * ＭＲ理由コード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MrRiyuucdKbn extends AbstractUserType<C_MrRiyuucdKbn> {

    @Override
    protected Class<C_MrRiyuucdKbn> returnType() {
        return C_MrRiyuucdKbn.class;
    }

    @Override
    protected C_MrRiyuucdKbn valueOf(String pValue) {
        return C_MrRiyuucdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MrRiyuucdKbn pValue) {
        return pValue.getValue();
    }
}
