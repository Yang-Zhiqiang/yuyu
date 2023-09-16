package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SikinidoulistKbn;

/**
 * {@link C_SikinidoulistKbn 資金移動リスト区分} の Hibernate ユーザー定義型です。<br />
 * 資金移動リスト区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SikinidoulistKbn extends AbstractUserType<C_SikinidoulistKbn> {

    @Override
    protected Class<C_SikinidoulistKbn> returnType() {
        return C_SikinidoulistKbn.class;
    }

    @Override
    protected C_SikinidoulistKbn valueOf(String pValue) {
        return C_SikinidoulistKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SikinidoulistKbn pValue) {
        return pValue.getValue();
    }
}
