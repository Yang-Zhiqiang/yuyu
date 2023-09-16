package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HensyuunaiyouKbn;

/**
 * {@link C_HensyuunaiyouKbn 編集内容状態区分} の Hibernate ユーザー定義型です。<br />
 * 編集内容状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HensyuunaiyouKbn extends AbstractUserType<C_HensyuunaiyouKbn> {

    @Override
    protected Class<C_HensyuunaiyouKbn> returnType() {
        return C_HensyuunaiyouKbn.class;
    }

    @Override
    protected C_HensyuunaiyouKbn valueOf(String pValue) {
        return C_HensyuunaiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HensyuunaiyouKbn pValue) {
        return pValue.getValue();
    }
}
