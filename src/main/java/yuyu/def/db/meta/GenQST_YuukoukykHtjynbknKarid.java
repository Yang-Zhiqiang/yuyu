package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_SrHaitoukinSyuukeiPtnKbn;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknKarid;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_SrHaitoukinSyuukeiPtnKbn;

/**
 * 有効契約配当準備金（仮割当Ｄ）テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQST_YuukoukykHtjynbknKarid extends AbstractExDBTable<ST_YuukoukykHtjynbknKarid> {

    public GenQST_YuukoukykHtjynbknKarid() {
        this("ST_YuukoukykHtjynbknKarid");
    }

    public GenQST_YuukoukykHtjynbknKarid(String pAlias) {
        super("ST_YuukoukykHtjynbknKarid", ST_YuukoukykHtjynbknKarid.class, pAlias);
    }

    public String ST_YuukoukykHtjynbknKarid() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> kakutyoujobcd = new ExDBFieldString<>("kakutyoujobcd", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> hknsyukigou = new ExDBFieldString<>("hknsyukigou", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> haraikomikaisukbn = new ExDBFieldString<>("haraikomikaisukbn", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> hrkkeirokbn = new ExDBFieldString<>("hrkkeirokbn", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> annaihuyouriyuukbn = new ExDBFieldString<>("annaihuyouriyuukbn", this);

    public final ExDBFieldBizCurrency<ST_YuukoukykHtjynbknKarid> znnndkrkskrwratdruigk = new ExDBFieldBizCurrency<>("znnndkrkskrwratdruigk", this);

    public final ExDBFieldBizCurrency<ST_YuukoukykHtjynbknKarid> tounendokariwariated = new ExDBFieldBizCurrency<>("tounendokariwariated", this);

    public final ExDBFieldBizCurrency<ST_YuukoukykHtjynbknKarid> tndmatukrkskrwratdruigk = new ExDBFieldBizCurrency<>("tndmatukrkskrwratdruigk", this);

    public final ExDBFieldBizCurrency<ST_YuukoukykHtjynbknKarid> kariwariatedrisoku = new ExDBFieldBizCurrency<>("kariwariatedrisoku", this);

    public final ExDBFieldBizCurrency<ST_YuukoukykHtjynbknKarid> hsys = new ExDBFieldBizCurrency<>("hsys", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> yobiv3 = new ExDBFieldString<>("yobiv3", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> srutiwake = new ExDBFieldString<>("srutiwake", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> srkijyunym = new ExDBFieldString<>("srkijyunym", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> kbnkeiriyousegmentkbn = new ExDBFieldString<>("kbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> kbnkeiriyourgnbnskkbn = new ExDBFieldString<>("kbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> seisikiwariatenendohyj = new ExDBFieldString<>("seisikiwariatenendohyj", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, BizDateYM> mankitouraiym = new ExDBFieldString<>("mankitouraiym", this, BizDateYMType.class);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> syukeiyakusyuruicd = new ExDBFieldString<>("syukeiyakusyuruicd", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> kyknendo = new ExDBFieldString<>("kyknendo", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, BizNumber> daihyouyoteiriritu = new ExDBFieldString<>("daihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> haraikatakbn = new ExDBFieldString<>("haraikatakbn", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, String> yobiv20 = new ExDBFieldString<>("yobiv20", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknKarid, C_SrHaitoukinSyuukeiPtnKbn> srhaitoukinsyuukeiptnkbn = new ExDBFieldString<>("srhaitoukinsyuukeiptnkbn", this, UserType_C_SrHaitoukinSyuukeiPtnKbn.class);
}
