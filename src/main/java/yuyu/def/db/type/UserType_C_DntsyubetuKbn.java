package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DntsyubetuKbn;

/**
 * {@link C_DntsyubetuKbn 団体種別区分} の Hibernate ユーザー定義型です。<br />
 * 団体種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DntsyubetuKbn extends AbstractUserType<C_DntsyubetuKbn> {

    @Override
    protected Class<C_DntsyubetuKbn> returnType() {
        return C_DntsyubetuKbn.class;
    }

    @Override
    protected C_DntsyubetuKbn valueOf(String pValue) {
        return C_DntsyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DntsyubetuKbn pValue) {
        return pValue.getValue();
    }
}
