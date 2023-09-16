package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.IT_BAK_KhSisuurendoTmttkn;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 指数連動積増型年金積立金バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhSisuurendoTmttkn extends AbstractExDBTable<IT_BAK_KhSisuurendoTmttkn> {

    public GenQIT_BAK_KhSisuurendoTmttkn() {
        this("IT_BAK_KhSisuurendoTmttkn");
    }

    public GenQIT_BAK_KhSisuurendoTmttkn(String pAlias) {
        super("IT_BAK_KhSisuurendoTmttkn", IT_BAK_KhSisuurendoTmttkn.class, pAlias);
    }

    public String IT_BAK_KhSisuurendoTmttkn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhSisuurendoTmttkn, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KhSisuurendoTmttkn, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KhSisuurendoTmttkn, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KhSisuurendoTmttkn, BizDateYM> tmttkntaisyouym = new ExDBFieldString<>("tmttkntaisyouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_BAK_KhSisuurendoTmttkn, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_BAK_KhSisuurendoTmttkn, BizDate> tmttknkouryokukaisiymd = new ExDBFieldString<>("tmttknkouryokukaisiymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhSisuurendoTmttkn> teiritutmttkngk = new ExDBFieldBizCurrency<>("teiritutmttkngk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhSisuurendoTmttkn> sisuurendoutmttkngk = new ExDBFieldBizCurrency<>("sisuurendoutmttkngk", this);

    public final ExDBFieldString<IT_BAK_KhSisuurendoTmttkn, BizNumber> sisuuupritu = new ExDBFieldString<>("sisuuupritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KhSisuurendoTmttkn, BizNumber> tmttknzoukaritu = new ExDBFieldString<>("tmttknzoukaritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KhSisuurendoTmttkn, BizDate> tmttknhaneitmmshanteiymd = new ExDBFieldString<>("tmttknhaneitmmshanteiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhSisuurendoTmttkn, BizNumber> tmttknhaneisisuu = new ExDBFieldString<>("tmttknhaneisisuu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KhSisuurendoTmttkn, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KhSisuurendoTmttkn, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhSisuurendoTmttkn, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhSisuurendoTmttkn> itenmaeteiritutmttkngk = new ExDBFieldBizCurrency<>("itenmaeteiritutmttkngk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhSisuurendoTmttkn> itenmaesisuurendoutmttkngk = new ExDBFieldBizCurrency<>("itenmaesisuurendoutmttkngk", this);
}
