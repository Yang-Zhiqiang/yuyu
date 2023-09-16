package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SikinidoumeisaiKbn;

/**
 * {@link C_SikinidoumeisaiKbn 資金移動明細区分} の Hibernate ユーザー定義型です。<br />
 * 資金移動明細区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SikinidoumeisaiKbn extends AbstractUserType<C_SikinidoumeisaiKbn> {

    @Override
    protected Class<C_SikinidoumeisaiKbn> returnType() {
        return C_SikinidoumeisaiKbn.class;
    }

    @Override
    protected C_SikinidoumeisaiKbn valueOf(String pValue) {
        return C_SikinidoumeisaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SikinidoumeisaiKbn pValue) {
        return pValue.getValue();
    }
}
