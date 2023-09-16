package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CheckKaiyakuUketukeKekkaKbn;

/**
 * {@link C_CheckKaiyakuUketukeKekkaKbn 解約受付チェック結果区分} の Hibernate ユーザー定義型です。<br />
 * 解約受付チェック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CheckKaiyakuUketukeKekkaKbn extends AbstractUserType<C_CheckKaiyakuUketukeKekkaKbn> {

    @Override
    protected Class<C_CheckKaiyakuUketukeKekkaKbn> returnType() {
        return C_CheckKaiyakuUketukeKekkaKbn.class;
    }

    @Override
    protected C_CheckKaiyakuUketukeKekkaKbn valueOf(String pValue) {
        return C_CheckKaiyakuUketukeKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CheckKaiyakuUketukeKekkaKbn pValue) {
        return pValue.getValue();
    }
}
