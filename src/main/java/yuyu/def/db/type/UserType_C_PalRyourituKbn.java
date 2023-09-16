package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PalRyourituKbn;

/**
 * {@link C_PalRyourituKbn ＰＡＬ料率区分} の Hibernate ユーザー定義型です。<br />
 * ＰＡＬ料率区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PalRyourituKbn extends AbstractUserType<C_PalRyourituKbn> {

    @Override
    protected Class<C_PalRyourituKbn> returnType() {
        return C_PalRyourituKbn.class;
    }

    @Override
    protected C_PalRyourituKbn valueOf(String pValue) {
        return C_PalRyourituKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PalRyourituKbn pValue) {
        return pValue.getValue();
    }
}
