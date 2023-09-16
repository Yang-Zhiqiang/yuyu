package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Teigikmhyoujijyun;

/**
 * {@link C_Teigikmhyoujijyun 定義項目表示順} の Hibernate ユーザー定義型です。<br />
 * 定義項目表示順 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Teigikmhyoujijyun extends AbstractUserType<C_Teigikmhyoujijyun> {

    @Override
    protected Class<C_Teigikmhyoujijyun> returnType() {
        return C_Teigikmhyoujijyun.class;
    }

    @Override
    protected C_Teigikmhyoujijyun valueOf(String pValue) {
        return C_Teigikmhyoujijyun.valueOf(pValue);
    }

    @Override
    protected String toString(C_Teigikmhyoujijyun pValue) {
        return pValue.getValue();
    }
}
