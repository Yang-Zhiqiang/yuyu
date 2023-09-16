package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;

/**
 * {@link C_DsSousinMailSyubetuKbn ＤＳ送信メール種別区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ送信メール種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsSousinMailSyubetuKbn extends AbstractUserType<C_DsSousinMailSyubetuKbn> {

    @Override
    protected Class<C_DsSousinMailSyubetuKbn> returnType() {
        return C_DsSousinMailSyubetuKbn.class;
    }

    @Override
    protected C_DsSousinMailSyubetuKbn valueOf(String pValue) {
        return C_DsSousinMailSyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsSousinMailSyubetuKbn pValue) {
        return pValue.getValue();
    }
}
