package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HengakuDenpyourecdKbn;

/**
 * {@link C_HengakuDenpyourecdKbn 変額伝票レコード区分} の Hibernate ユーザー定義型です。<br />
 * 変額伝票レコード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HengakuDenpyourecdKbn extends AbstractUserType<C_HengakuDenpyourecdKbn> {

    @Override
    protected Class<C_HengakuDenpyourecdKbn> returnType() {
        return C_HengakuDenpyourecdKbn.class;
    }

    @Override
    protected C_HengakuDenpyourecdKbn valueOf(String pValue) {
        return C_HengakuDenpyourecdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HengakuDenpyourecdKbn pValue) {
        return pValue.getValue();
    }
}
