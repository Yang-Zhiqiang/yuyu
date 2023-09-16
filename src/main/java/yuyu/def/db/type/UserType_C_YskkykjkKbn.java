package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YskkykjkKbn;

/**
 * {@link C_YskkykjkKbn 将来予測用契約状況区分} の Hibernate ユーザー定義型です。<br />
 * 将来予測用契約状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YskkykjkKbn extends AbstractUserType<C_YskkykjkKbn> {

    @Override
    protected Class<C_YskkykjkKbn> returnType() {
        return C_YskkykjkKbn.class;
    }

    @Override
    protected C_YskkykjkKbn valueOf(String pValue) {
        return C_YskkykjkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YskkykjkKbn pValue) {
        return pValue.getValue();
    }
}
