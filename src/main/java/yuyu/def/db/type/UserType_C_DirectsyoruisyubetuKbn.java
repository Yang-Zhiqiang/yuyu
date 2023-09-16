package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DirectsyoruisyubetuKbn;

/**
 * {@link C_DirectsyoruisyubetuKbn ダイレクト書類種別区分} の Hibernate ユーザー定義型です。<br />
 * ダイレクト書類種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DirectsyoruisyubetuKbn extends AbstractUserType<C_DirectsyoruisyubetuKbn> {

    @Override
    protected Class<C_DirectsyoruisyubetuKbn> returnType() {
        return C_DirectsyoruisyubetuKbn.class;
    }

    @Override
    protected C_DirectsyoruisyubetuKbn valueOf(String pValue) {
        return C_DirectsyoruisyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DirectsyoruisyubetuKbn pValue) {
        return pValue.getValue();
    }
}
