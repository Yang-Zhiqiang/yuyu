package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsSyomenTtdkHyouji;

/**
 * {@link C_DsSyomenTtdkHyouji ＤＳ書面手続表示} の Hibernate ユーザー定義型です。<br />
 * ＤＳ書面手続表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsSyomenTtdkHyouji extends AbstractUserType<C_DsSyomenTtdkHyouji> {

    @Override
    protected Class<C_DsSyomenTtdkHyouji> returnType() {
        return C_DsSyomenTtdkHyouji.class;
    }

    @Override
    protected C_DsSyomenTtdkHyouji valueOf(String pValue) {
        return C_DsSyomenTtdkHyouji.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsSyomenTtdkHyouji pValue) {
        return pValue.getValue();
    }
}
