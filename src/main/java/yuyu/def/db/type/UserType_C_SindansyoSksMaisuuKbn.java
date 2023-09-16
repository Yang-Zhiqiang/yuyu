package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SindansyoSksMaisuuKbn;

/**
 * {@link C_SindansyoSksMaisuuKbn 診断書作成枚数区分} の Hibernate ユーザー定義型です。<br />
 * 診断書作成枚数区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SindansyoSksMaisuuKbn extends AbstractUserType<C_SindansyoSksMaisuuKbn> {

    @Override
    protected Class<C_SindansyoSksMaisuuKbn> returnType() {
        return C_SindansyoSksMaisuuKbn.class;
    }

    @Override
    protected C_SindansyoSksMaisuuKbn valueOf(String pValue) {
        return C_SindansyoSksMaisuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SindansyoSksMaisuuKbn pValue) {
        return pValue.getValue();
    }
}
