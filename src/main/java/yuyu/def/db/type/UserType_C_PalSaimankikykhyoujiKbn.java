package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PalSaimankikykhyoujiKbn;

/**
 * {@link C_PalSaimankikykhyoujiKbn ＰＡＬ才満期契約表示区分} の Hibernate ユーザー定義型です。<br />
 * ＰＡＬ才満期契約表示区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PalSaimankikykhyoujiKbn extends AbstractUserType<C_PalSaimankikykhyoujiKbn> {

    @Override
    protected Class<C_PalSaimankikykhyoujiKbn> returnType() {
        return C_PalSaimankikykhyoujiKbn.class;
    }

    @Override
    protected C_PalSaimankikykhyoujiKbn valueOf(String pValue) {
        return C_PalSaimankikykhyoujiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PalSaimankikykhyoujiKbn pValue) {
        return pValue.getValue();
    }
}
