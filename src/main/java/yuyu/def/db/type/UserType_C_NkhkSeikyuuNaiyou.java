package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NkhkSeikyuuNaiyou;

/**
 * {@link C_NkhkSeikyuuNaiyou 年金変更請求内容} の Hibernate ユーザー定義型です。<br />
 * 年金変更請求内容 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NkhkSeikyuuNaiyou extends AbstractUserType<C_NkhkSeikyuuNaiyou> {

    @Override
    protected Class<C_NkhkSeikyuuNaiyou> returnType() {
        return C_NkhkSeikyuuNaiyou.class;
    }

    @Override
    protected C_NkhkSeikyuuNaiyou valueOf(String pValue) {
        return C_NkhkSeikyuuNaiyou.valueOf(pValue);
    }

    @Override
    protected String toString(C_NkhkSeikyuuNaiyou pValue) {
        return pValue.getValue();
    }
}
