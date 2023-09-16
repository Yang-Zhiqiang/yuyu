package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JykyknhyksyuKbn;

/**
 * {@link C_JykyknhyksyuKbn 受給権評価種類区分} の Hibernate ユーザー定義型です。<br />
 * 受給権評価種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JykyknhyksyuKbn extends AbstractUserType<C_JykyknhyksyuKbn> {

    @Override
    protected Class<C_JykyknhyksyuKbn> returnType() {
        return C_JykyknhyksyuKbn.class;
    }

    @Override
    protected C_JykyknhyksyuKbn valueOf(String pValue) {
        return C_JykyknhyksyuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JykyknhyksyuKbn pValue) {
        return pValue.getValue();
    }
}
