package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MinyuunaiyouKbn;

/**
 * {@link C_MinyuunaiyouKbn 未入内容区分} の Hibernate ユーザー定義型です。<br />
 * 未入内容区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MinyuunaiyouKbn extends AbstractUserType<C_MinyuunaiyouKbn> {

    @Override
    protected Class<C_MinyuunaiyouKbn> returnType() {
        return C_MinyuunaiyouKbn.class;
    }

    @Override
    protected C_MinyuunaiyouKbn valueOf(String pValue) {
        return C_MinyuunaiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MinyuunaiyouKbn pValue) {
        return pValue.getValue();
    }
}
