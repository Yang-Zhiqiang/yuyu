package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsTtdksyubetuKbn;

/**
 * {@link C_DsTtdksyubetuKbn ＤＳ手続種別区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ手続種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsTtdksyubetuKbn extends AbstractUserType<C_DsTtdksyubetuKbn> {

    @Override
    protected Class<C_DsTtdksyubetuKbn> returnType() {
        return C_DsTtdksyubetuKbn.class;
    }

    @Override
    protected C_DsTtdksyubetuKbn valueOf(String pValue) {
        return C_DsTtdksyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsTtdksyubetuKbn pValue) {
        return pValue.getValue();
    }
}
