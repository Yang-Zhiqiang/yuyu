package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MeigihnknaiyouKbn;

/**
 * {@link C_MeigihnknaiyouKbn 名義変更内容区分} の Hibernate ユーザー定義型です。<br />
 * 名義変更内容区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MeigihnknaiyouKbn extends AbstractUserType<C_MeigihnknaiyouKbn> {

    @Override
    protected Class<C_MeigihnknaiyouKbn> returnType() {
        return C_MeigihnknaiyouKbn.class;
    }

    @Override
    protected C_MeigihnknaiyouKbn valueOf(String pValue) {
        return C_MeigihnknaiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MeigihnknaiyouKbn pValue) {
        return pValue.getValue();
    }
}
