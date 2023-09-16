package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IkkatuyouptknKbn;

/**
 * {@link C_IkkatuyouptknKbn 一括要Ｐ特認区分} の Hibernate ユーザー定義型です。<br />
 * 一括要Ｐ特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IkkatuyouptknKbn extends AbstractUserType<C_IkkatuyouptknKbn> {

    @Override
    protected Class<C_IkkatuyouptknKbn> returnType() {
        return C_IkkatuyouptknKbn.class;
    }

    @Override
    protected C_IkkatuyouptknKbn valueOf(String pValue) {
        return C_IkkatuyouptknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IkkatuyouptknKbn pValue) {
        return pValue.getValue();
    }
}
