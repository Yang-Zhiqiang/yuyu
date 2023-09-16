package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YennykntksyuruiKbn;

/**
 * {@link C_YennykntksyuruiKbn 円入金特約種類区分} の Hibernate ユーザー定義型です。<br />
 * 円入金特約種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YennykntksyuruiKbn extends AbstractUserType<C_YennykntksyuruiKbn> {

    @Override
    protected Class<C_YennykntksyuruiKbn> returnType() {
        return C_YennykntksyuruiKbn.class;
    }

    @Override
    protected C_YennykntksyuruiKbn valueOf(String pValue) {
        return C_YennykntksyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YennykntksyuruiKbn pValue) {
        return pValue.getValue();
    }
}
