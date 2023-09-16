package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsPhrkhouhenkouKahiSeigyoKbn;

/**
 * {@link C_DsPhrkhouhenkouKahiSeigyoKbn ＤＳ保険料払込方法変更可否制御区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ保険料払込方法変更可否制御区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsPhrkhouhenkouKahiSeigyoKbn extends AbstractUserType<C_DsPhrkhouhenkouKahiSeigyoKbn> {

    @Override
    protected Class<C_DsPhrkhouhenkouKahiSeigyoKbn> returnType() {
        return C_DsPhrkhouhenkouKahiSeigyoKbn.class;
    }

    @Override
    protected C_DsPhrkhouhenkouKahiSeigyoKbn valueOf(String pValue) {
        return C_DsPhrkhouhenkouKahiSeigyoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsPhrkhouhenkouKahiSeigyoKbn pValue) {
        return pValue.getValue();
    }
}
