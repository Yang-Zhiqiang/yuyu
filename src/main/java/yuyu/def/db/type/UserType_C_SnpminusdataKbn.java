package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SnpminusdataKbn;

/**
 * {@link C_SnpminusdataKbn 収入Ｐマイナスデータ区分} の Hibernate ユーザー定義型です。<br />
 * 収入Ｐマイナスデータ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SnpminusdataKbn extends AbstractUserType<C_SnpminusdataKbn> {

    @Override
    protected Class<C_SnpminusdataKbn> returnType() {
        return C_SnpminusdataKbn.class;
    }

    @Override
    protected C_SnpminusdataKbn valueOf(String pValue) {
        return C_SnpminusdataKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SnpminusdataKbn pValue) {
        return pValue.getValue();
    }
}
