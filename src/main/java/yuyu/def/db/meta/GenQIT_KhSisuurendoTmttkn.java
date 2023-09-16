package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 指数連動積増型年金積立金テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhSisuurendoTmttkn extends AbstractExDBTable<IT_KhSisuurendoTmttkn> {

    public GenQIT_KhSisuurendoTmttkn() {
        this("IT_KhSisuurendoTmttkn");
    }

    public GenQIT_KhSisuurendoTmttkn(String pAlias) {
        super("IT_KhSisuurendoTmttkn", IT_KhSisuurendoTmttkn.class, pAlias);
    }

    public String IT_KhSisuurendoTmttkn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhSisuurendoTmttkn, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KhSisuurendoTmttkn, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhSisuurendoTmttkn, BizDateYM> tmttkntaisyouym = new ExDBFieldString<>("tmttkntaisyouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_KhSisuurendoTmttkn, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_KhSisuurendoTmttkn, BizDate> tmttknkouryokukaisiymd = new ExDBFieldString<>("tmttknkouryokukaisiymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KhSisuurendoTmttkn> teiritutmttkngk = new ExDBFieldBizCurrency<>("teiritutmttkngk", this);

    public final ExDBFieldBizCurrency<IT_KhSisuurendoTmttkn> sisuurendoutmttkngk = new ExDBFieldBizCurrency<>("sisuurendoutmttkngk", this);

    public final ExDBFieldString<IT_KhSisuurendoTmttkn, BizNumber> sisuuupritu = new ExDBFieldString<>("sisuuupritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_KhSisuurendoTmttkn, BizNumber> tmttknzoukaritu = new ExDBFieldString<>("tmttknzoukaritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_KhSisuurendoTmttkn, BizDate> tmttknhaneitmmshanteiymd = new ExDBFieldString<>("tmttknhaneitmmshanteiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhSisuurendoTmttkn, BizNumber> tmttknhaneisisuu = new ExDBFieldString<>("tmttknhaneisisuu", this, BizNumberType.class);

    public final ExDBFieldString<IT_KhSisuurendoTmttkn, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhSisuurendoTmttkn, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhSisuurendoTmttkn, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldBizCurrency<IT_KhSisuurendoTmttkn> itenmaeteiritutmttkngk = new ExDBFieldBizCurrency<>("itenmaeteiritutmttkngk", this);

    public final ExDBFieldBizCurrency<IT_KhSisuurendoTmttkn> itenmaesisuurendoutmttkngk = new ExDBFieldBizCurrency<>("itenmaesisuurendoutmttkngk", this);
}
