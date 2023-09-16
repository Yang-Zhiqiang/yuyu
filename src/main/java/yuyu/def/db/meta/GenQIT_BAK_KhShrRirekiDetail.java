package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.IT_BAK_KhShrRirekiDetail;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 契約保全支払履歴明細バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhShrRirekiDetail extends AbstractExDBTable<IT_BAK_KhShrRirekiDetail> {

    public GenQIT_BAK_KhShrRirekiDetail() {
        this("IT_BAK_KhShrRirekiDetail");
    }

    public GenQIT_BAK_KhShrRirekiDetail(String pAlias) {
        super("IT_BAK_KhShrRirekiDetail", IT_BAK_KhShrRirekiDetail.class, pAlias);
    }

    public String IT_BAK_KhShrRirekiDetail() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhShrRirekiDetail, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KhShrRirekiDetail, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KhShrRirekiDetail, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KhShrRirekiDetail, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_KhShrRirekiDetail, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<IT_BAK_KhShrRirekiDetail, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldNumber<IT_BAK_KhShrRirekiDetail, Integer> kyksyouhnrenno = new ExDBFieldNumber<>("kyksyouhnrenno", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRirekiDetail> syushrgk = new ExDBFieldBizCurrency<>("syushrgk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRirekiDetail> shrtstmttkin = new ExDBFieldBizCurrency<>("shrtstmttkin", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRirekiDetail> shrtstmttkinhngkbbn = new ExDBFieldBizCurrency<>("shrtstmttkinhngkbbn", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRirekiDetail> sjkkktyouseigk = new ExDBFieldBizCurrency<>("sjkkktyouseigk", this);

    public final ExDBFieldString<IT_BAK_KhShrRirekiDetail, BizNumber> kaiyakusjkkktyouseiritu = new ExDBFieldString<>("kaiyakusjkkktyouseiritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KhShrRirekiDetail, BizNumber> kaiyakusjkkktyouseiriritu = new ExDBFieldString<>("kaiyakusjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRirekiDetail> kaiyakukjgk = new ExDBFieldBizCurrency<>("kaiyakukjgk", this);

    public final ExDBFieldString<IT_BAK_KhShrRirekiDetail, BizNumber> kaiyakukoujyoritu = new ExDBFieldString<>("kaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KhShrRirekiDetail, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KhShrRirekiDetail, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhShrRirekiDetail, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRirekiDetail> teiritutmttkngk = new ExDBFieldBizCurrency<>("teiritutmttkngk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRirekiDetail> sisuurendoutmttkngk = new ExDBFieldBizCurrency<>("sisuurendoutmttkngk", this);
}
