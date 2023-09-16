package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.IT_KhShrRirekiDetail;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 契約保全支払履歴明細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhShrRirekiDetail extends AbstractExDBTable<IT_KhShrRirekiDetail> {

    public GenQIT_KhShrRirekiDetail() {
        this("IT_KhShrRirekiDetail");
    }

    public GenQIT_KhShrRirekiDetail(String pAlias) {
        super("IT_KhShrRirekiDetail", IT_KhShrRirekiDetail.class, pAlias);
    }

    public String IT_KhShrRirekiDetail() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhShrRirekiDetail, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KhShrRirekiDetail, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhShrRirekiDetail, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_KhShrRirekiDetail, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<IT_KhShrRirekiDetail, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldNumber<IT_KhShrRirekiDetail, Integer> kyksyouhnrenno = new ExDBFieldNumber<>("kyksyouhnrenno", this);

    public final ExDBFieldBizCurrency<IT_KhShrRirekiDetail> syushrgk = new ExDBFieldBizCurrency<>("syushrgk", this);

    public final ExDBFieldBizCurrency<IT_KhShrRirekiDetail> shrtstmttkin = new ExDBFieldBizCurrency<>("shrtstmttkin", this);

    public final ExDBFieldBizCurrency<IT_KhShrRirekiDetail> shrtstmttkinhngkbbn = new ExDBFieldBizCurrency<>("shrtstmttkinhngkbbn", this);

    public final ExDBFieldBizCurrency<IT_KhShrRirekiDetail> sjkkktyouseigk = new ExDBFieldBizCurrency<>("sjkkktyouseigk", this);

    public final ExDBFieldString<IT_KhShrRirekiDetail, BizNumber> kaiyakusjkkktyouseiritu = new ExDBFieldString<>("kaiyakusjkkktyouseiritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_KhShrRirekiDetail, BizNumber> kaiyakusjkkktyouseiriritu = new ExDBFieldString<>("kaiyakusjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_KhShrRirekiDetail> kaiyakukjgk = new ExDBFieldBizCurrency<>("kaiyakukjgk", this);

    public final ExDBFieldString<IT_KhShrRirekiDetail, BizNumber> kaiyakukoujyoritu = new ExDBFieldString<>("kaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_KhShrRirekiDetail, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhShrRirekiDetail, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhShrRirekiDetail, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldBizCurrency<IT_KhShrRirekiDetail> teiritutmttkngk = new ExDBFieldBizCurrency<>("teiritutmttkngk", this);

    public final ExDBFieldBizCurrency<IT_KhShrRirekiDetail> sisuurendoutmttkngk = new ExDBFieldBizCurrency<>("sisuurendoutmttkngk", this);
}
