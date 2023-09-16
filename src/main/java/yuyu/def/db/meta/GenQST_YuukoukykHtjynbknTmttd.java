package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_SrHaitoukinSyuukeiPtnKbn;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknTmttd;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_SrHaitoukinSyuukeiPtnKbn;

/**
 * 有効契約配当準備金（積立Ｄ）テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQST_YuukoukykHtjynbknTmttd extends AbstractExDBTable<ST_YuukoukykHtjynbknTmttd> {

    public GenQST_YuukoukykHtjynbknTmttd() {
        this("ST_YuukoukykHtjynbknTmttd");
    }

    public GenQST_YuukoukykHtjynbknTmttd(String pAlias) {
        super("ST_YuukoukykHtjynbknTmttd", ST_YuukoukykHtjynbknTmttd.class, pAlias);
    }

    public String ST_YuukoukykHtjynbknTmttd() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> kakutyoujobcd = new ExDBFieldString<>("kakutyoujobcd", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> hknsyukigou = new ExDBFieldString<>("hknsyukigou", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> haraikomikaisukbn = new ExDBFieldString<>("haraikomikaisukbn", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> hrkkeirokbn = new ExDBFieldString<>("hrkkeirokbn", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> annaihuyouriyuukbn = new ExDBFieldString<>("annaihuyouriyuukbn", this);

    public final ExDBFieldBizCurrency<ST_YuukoukykHtjynbknTmttd> zennendkurikosid = new ExDBFieldBizCurrency<>("zennendkurikosid", this);

    public final ExDBFieldBizCurrency<ST_YuukoukykHtjynbknTmttd> tounendod = new ExDBFieldBizCurrency<>("tounendod", this);

    public final ExDBFieldBizCurrency<ST_YuukoukykHtjynbknTmttd> tndmatutumitated = new ExDBFieldBizCurrency<>("tndmatutumitated", this);

    public final ExDBFieldBizCurrency<ST_YuukoukykHtjynbknTmttd> tumitaterisoku = new ExDBFieldBizCurrency<>("tumitaterisoku", this);

    public final ExDBFieldBizCurrency<ST_YuukoukykHtjynbknTmttd> hsys = new ExDBFieldBizCurrency<>("hsys", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> syuruicd1 = new ExDBFieldString<>("syuruicd1", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> syuruicd3 = new ExDBFieldString<>("syuruicd3", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> srutiwake = new ExDBFieldString<>("srutiwake", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> srkijyunym = new ExDBFieldString<>("srkijyunym", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> kbnkeiriyousegmentkbn = new ExDBFieldString<>("kbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> kbnkeiriyourgnbnskkbn = new ExDBFieldString<>("kbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> syuruicd2 = new ExDBFieldString<>("syuruicd2", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, BizDateYM> mankitouraiym = new ExDBFieldString<>("mankitouraiym", this, BizDateYMType.class);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> syukeiyakusyuruicd = new ExDBFieldString<>("syukeiyakusyuruicd", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> kyknendo = new ExDBFieldString<>("kyknendo", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, BizNumber> daihyouyoteiriritu = new ExDBFieldString<>("daihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> haraikatakbn = new ExDBFieldString<>("haraikatakbn", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, String> yobiv20 = new ExDBFieldString<>("yobiv20", this);

    public final ExDBFieldString<ST_YuukoukykHtjynbknTmttd, C_SrHaitoukinSyuukeiPtnKbn> srhaitoukinsyuukeiptnkbn = new ExDBFieldString<>("srhaitoukinsyuukeiptnkbn", this, UserType_C_SrHaitoukinSyuukeiPtnKbn.class);
}
