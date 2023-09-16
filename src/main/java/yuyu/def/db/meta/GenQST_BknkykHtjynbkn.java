package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ST_BknkykHtjynbkn;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 備金契約配当準備金テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQST_BknkykHtjynbkn extends AbstractExDBTable<ST_BknkykHtjynbkn> {

    public GenQST_BknkykHtjynbkn() {
        this("ST_BknkykHtjynbkn");
    }

    public GenQST_BknkykHtjynbkn(String pAlias) {
        super("ST_BknkykHtjynbkn", ST_BknkykHtjynbkn.class, pAlias);
    }

    public String ST_BknkykHtjynbkn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ST_BknkykHtjynbkn, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> kakutyoujobcd = new ExDBFieldString<>("kakutyoujobcd", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> hknsyukigou = new ExDBFieldString<>("hknsyukigou", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> haraikomikaisukbn = new ExDBFieldString<>("haraikomikaisukbn", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> hrkkeirokbn = new ExDBFieldString<>("hrkkeirokbn", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> annaihuyouriyuukbn = new ExDBFieldString<>("annaihuyouriyuukbn", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> bikinkbn = new ExDBFieldString<>("bikinkbn", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> bikinnendokbn = new ExDBFieldString<>("bikinnendokbn", this);

    public final ExDBFieldBizCurrency<ST_BknkykHtjynbkn> seisand = new ExDBFieldBizCurrency<>("seisand", this);

    public final ExDBFieldBizCurrency<ST_BknkykHtjynbkn> tumitaterisoku = new ExDBFieldBizCurrency<>("tumitaterisoku", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> syuruicd1 = new ExDBFieldString<>("syuruicd1", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> syuruicd3 = new ExDBFieldString<>("syuruicd3", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> srkijyunym = new ExDBFieldString<>("srkijyunym", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> kbnkeiriyousegmentkbn = new ExDBFieldString<>("kbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> kbnkeiriyourgnbnskkbn = new ExDBFieldString<>("kbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> syuruicd2 = new ExDBFieldString<>("syuruicd2", this);

    public final ExDBFieldBizCurrency<ST_BknkykHtjynbkn> kariwariatedganrikin = new ExDBFieldBizCurrency<>("kariwariatedganrikin", this);

    public final ExDBFieldBizCurrency<ST_BknkykHtjynbkn> kariwariatedrisoku = new ExDBFieldBizCurrency<>("kariwariatedrisoku", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> syukeiyakusyuruicd = new ExDBFieldString<>("syukeiyakusyuruicd", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> kyknendo = new ExDBFieldString<>("kyknendo", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, BizNumber> daihyouyoteiriritu = new ExDBFieldString<>("daihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> haraikatakbn = new ExDBFieldString<>("haraikatakbn", this);

    public final ExDBFieldString<ST_BknkykHtjynbkn, String> yobiv32 = new ExDBFieldString<>("yobiv32", this);
}
