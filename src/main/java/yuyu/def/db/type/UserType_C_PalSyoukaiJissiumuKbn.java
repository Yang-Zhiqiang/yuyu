package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;

/**
 * {@link C_PalSyoukaiJissiumuKbn ＰＡＬあて照会実施有無区分} の Hibernate ユーザー定義型です。<br />
 * ＰＡＬあて照会実施有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PalSyoukaiJissiumuKbn extends AbstractUserType<C_PalSyoukaiJissiumuKbn> {

    @Override
    protected Class<C_PalSyoukaiJissiumuKbn> returnType() {
        return C_PalSyoukaiJissiumuKbn.class;
    }

    @Override
    protected C_PalSyoukaiJissiumuKbn valueOf(String pValue) {
        return C_PalSyoukaiJissiumuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PalSyoukaiJissiumuKbn pValue) {
        return pValue.getValue();
    }
}
