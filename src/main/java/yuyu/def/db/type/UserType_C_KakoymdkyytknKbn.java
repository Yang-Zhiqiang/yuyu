package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KakoymdkyytknKbn;

/**
 * {@link C_KakoymdkyytknKbn 過去日付許容特認区分} の Hibernate ユーザー定義型です。<br />
 * 過去日付許容特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KakoymdkyytknKbn extends AbstractUserType<C_KakoymdkyytknKbn> {

    @Override
    protected Class<C_KakoymdkyytknKbn> returnType() {
        return C_KakoymdkyytknKbn.class;
    }

    @Override
    protected C_KakoymdkyytknKbn valueOf(String pValue) {
        return C_KakoymdkyytknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KakoymdkyytknKbn pValue) {
        return pValue.getValue();
    }
}
