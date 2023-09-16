package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KgkyojusikibetuKbn;

/**
 * {@link C_KgkyojusikibetuKbn 海外居住者識別区分} の Hibernate ユーザー定義型です。<br />
 * 海外居住者識別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KgkyojusikibetuKbn extends AbstractUserType<C_KgkyojusikibetuKbn> {

    @Override
    protected Class<C_KgkyojusikibetuKbn> returnType() {
        return C_KgkyojusikibetuKbn.class;
    }

    @Override
    protected C_KgkyojusikibetuKbn valueOf(String pValue) {
        return C_KgkyojusikibetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KgkyojusikibetuKbn pValue) {
        return pValue.getValue();
    }
}
