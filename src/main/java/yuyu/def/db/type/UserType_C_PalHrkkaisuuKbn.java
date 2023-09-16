package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PalHrkkaisuuKbn;

/**
 * {@link C_PalHrkkaisuuKbn ＰＡＬ払込回数区分} の Hibernate ユーザー定義型です。<br />
 * ＰＡＬ払込回数区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PalHrkkaisuuKbn extends AbstractUserType<C_PalHrkkaisuuKbn> {

    @Override
    protected Class<C_PalHrkkaisuuKbn> returnType() {
        return C_PalHrkkaisuuKbn.class;
    }

    @Override
    protected C_PalHrkkaisuuKbn valueOf(String pValue) {
        return C_PalHrkkaisuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PalHrkkaisuuKbn pValue) {
        return pValue.getValue();
    }
}
