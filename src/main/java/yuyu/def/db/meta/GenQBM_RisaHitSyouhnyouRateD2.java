package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD2;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 利差配当商品用Ｄレートマスタ２ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_RisaHitSyouhnyouRateD2 extends AbstractExDBTable<BM_RisaHitSyouhnyouRateD2> {

    public GenQBM_RisaHitSyouhnyouRateD2() {
        this("BM_RisaHitSyouhnyouRateD2");
    }

    public GenQBM_RisaHitSyouhnyouRateD2(String pAlias) {
        super("BM_RisaHitSyouhnyouRateD2", BM_RisaHitSyouhnyouRateD2.class, pAlias);
    }

    public String BM_RisaHitSyouhnyouRateD2() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> palhokensyuruikigou = new ExDBFieldString<>("palhokensyuruikigou", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> palhokensyuruikigousdicode = new ExDBFieldString<>("palhokensyuruikigousdicode", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> palyoteiriritu = new ExDBFieldString<>("palyoteiriritu", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> palpmencode = new ExDBFieldString<>("palpmencode", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> palharaikomikaisuu = new ExDBFieldString<>("palharaikomikaisuu", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> palhhknsei = new ExDBFieldString<>("palhhknsei", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> palkeiyakujihhknnen = new ExDBFieldString<>("palkeiyakujihhknnen", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> palsaimankihyouji = new ExDBFieldString<>("palsaimankihyouji", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> palhokenkikan = new ExDBFieldString<>("palhokenkikan", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> palpharaikomikikan = new ExDBFieldString<>("palpharaikomikikan", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> palannaihuyouriyuukbn = new ExDBFieldString<>("palannaihuyouriyuukbn", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> ratetuukasyukbn = new ExDBFieldString<>("ratetuukasyukbn", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> ratedai1hknkkn = new ExDBFieldString<>("ratedai1hknkkn", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> paldnendo = new ExDBFieldString<>("paldnendo", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, String> paldratenaikakucode = new ExDBFieldString<>("paldratenaikakucode", this);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate00 = new ExDBFieldString<>("drate00", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate01 = new ExDBFieldString<>("drate01", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate02 = new ExDBFieldString<>("drate02", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate03 = new ExDBFieldString<>("drate03", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate04 = new ExDBFieldString<>("drate04", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate05 = new ExDBFieldString<>("drate05", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate06 = new ExDBFieldString<>("drate06", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate07 = new ExDBFieldString<>("drate07", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate08 = new ExDBFieldString<>("drate08", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate09 = new ExDBFieldString<>("drate09", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate10 = new ExDBFieldString<>("drate10", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate11 = new ExDBFieldString<>("drate11", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate12 = new ExDBFieldString<>("drate12", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate13 = new ExDBFieldString<>("drate13", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate14 = new ExDBFieldString<>("drate14", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate15 = new ExDBFieldString<>("drate15", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate16 = new ExDBFieldString<>("drate16", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate17 = new ExDBFieldString<>("drate17", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate18 = new ExDBFieldString<>("drate18", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate19 = new ExDBFieldString<>("drate19", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate20 = new ExDBFieldString<>("drate20", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate21 = new ExDBFieldString<>("drate21", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate22 = new ExDBFieldString<>("drate22", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate23 = new ExDBFieldString<>("drate23", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate24 = new ExDBFieldString<>("drate24", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate25 = new ExDBFieldString<>("drate25", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate26 = new ExDBFieldString<>("drate26", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate27 = new ExDBFieldString<>("drate27", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate28 = new ExDBFieldString<>("drate28", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate29 = new ExDBFieldString<>("drate29", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate30 = new ExDBFieldString<>("drate30", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate31 = new ExDBFieldString<>("drate31", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate32 = new ExDBFieldString<>("drate32", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate33 = new ExDBFieldString<>("drate33", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate34 = new ExDBFieldString<>("drate34", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate35 = new ExDBFieldString<>("drate35", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate36 = new ExDBFieldString<>("drate36", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate37 = new ExDBFieldString<>("drate37", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate38 = new ExDBFieldString<>("drate38", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate39 = new ExDBFieldString<>("drate39", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate40 = new ExDBFieldString<>("drate40", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate41 = new ExDBFieldString<>("drate41", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate42 = new ExDBFieldString<>("drate42", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate43 = new ExDBFieldString<>("drate43", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate44 = new ExDBFieldString<>("drate44", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate45 = new ExDBFieldString<>("drate45", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate46 = new ExDBFieldString<>("drate46", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate47 = new ExDBFieldString<>("drate47", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate48 = new ExDBFieldString<>("drate48", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate49 = new ExDBFieldString<>("drate49", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate50 = new ExDBFieldString<>("drate50", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate51 = new ExDBFieldString<>("drate51", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate52 = new ExDBFieldString<>("drate52", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate53 = new ExDBFieldString<>("drate53", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate54 = new ExDBFieldString<>("drate54", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate55 = new ExDBFieldString<>("drate55", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate56 = new ExDBFieldString<>("drate56", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate57 = new ExDBFieldString<>("drate57", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate58 = new ExDBFieldString<>("drate58", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate59 = new ExDBFieldString<>("drate59", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate60 = new ExDBFieldString<>("drate60", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate61 = new ExDBFieldString<>("drate61", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate62 = new ExDBFieldString<>("drate62", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate63 = new ExDBFieldString<>("drate63", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate64 = new ExDBFieldString<>("drate64", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate65 = new ExDBFieldString<>("drate65", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate66 = new ExDBFieldString<>("drate66", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate67 = new ExDBFieldString<>("drate67", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate68 = new ExDBFieldString<>("drate68", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate69 = new ExDBFieldString<>("drate69", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate70 = new ExDBFieldString<>("drate70", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate71 = new ExDBFieldString<>("drate71", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate72 = new ExDBFieldString<>("drate72", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate73 = new ExDBFieldString<>("drate73", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate74 = new ExDBFieldString<>("drate74", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate75 = new ExDBFieldString<>("drate75", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate76 = new ExDBFieldString<>("drate76", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate77 = new ExDBFieldString<>("drate77", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate78 = new ExDBFieldString<>("drate78", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate79 = new ExDBFieldString<>("drate79", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate80 = new ExDBFieldString<>("drate80", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate81 = new ExDBFieldString<>("drate81", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate82 = new ExDBFieldString<>("drate82", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate83 = new ExDBFieldString<>("drate83", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate84 = new ExDBFieldString<>("drate84", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate85 = new ExDBFieldString<>("drate85", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate86 = new ExDBFieldString<>("drate86", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate87 = new ExDBFieldString<>("drate87", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate88 = new ExDBFieldString<>("drate88", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate89 = new ExDBFieldString<>("drate89", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate90 = new ExDBFieldString<>("drate90", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate91 = new ExDBFieldString<>("drate91", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate92 = new ExDBFieldString<>("drate92", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate93 = new ExDBFieldString<>("drate93", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate94 = new ExDBFieldString<>("drate94", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate95 = new ExDBFieldString<>("drate95", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate96 = new ExDBFieldString<>("drate96", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate97 = new ExDBFieldString<>("drate97", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate98 = new ExDBFieldString<>("drate98", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> drate99 = new ExDBFieldString<>("drate99", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate00 = new ExDBFieldString<>("dyouvrate00", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate01 = new ExDBFieldString<>("dyouvrate01", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate02 = new ExDBFieldString<>("dyouvrate02", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate03 = new ExDBFieldString<>("dyouvrate03", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate04 = new ExDBFieldString<>("dyouvrate04", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate05 = new ExDBFieldString<>("dyouvrate05", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate06 = new ExDBFieldString<>("dyouvrate06", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate07 = new ExDBFieldString<>("dyouvrate07", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate08 = new ExDBFieldString<>("dyouvrate08", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate09 = new ExDBFieldString<>("dyouvrate09", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate10 = new ExDBFieldString<>("dyouvrate10", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate11 = new ExDBFieldString<>("dyouvrate11", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate12 = new ExDBFieldString<>("dyouvrate12", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate13 = new ExDBFieldString<>("dyouvrate13", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate14 = new ExDBFieldString<>("dyouvrate14", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate15 = new ExDBFieldString<>("dyouvrate15", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate16 = new ExDBFieldString<>("dyouvrate16", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate17 = new ExDBFieldString<>("dyouvrate17", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate18 = new ExDBFieldString<>("dyouvrate18", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate19 = new ExDBFieldString<>("dyouvrate19", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate20 = new ExDBFieldString<>("dyouvrate20", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate21 = new ExDBFieldString<>("dyouvrate21", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate22 = new ExDBFieldString<>("dyouvrate22", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate23 = new ExDBFieldString<>("dyouvrate23", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate24 = new ExDBFieldString<>("dyouvrate24", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate25 = new ExDBFieldString<>("dyouvrate25", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate26 = new ExDBFieldString<>("dyouvrate26", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate27 = new ExDBFieldString<>("dyouvrate27", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate28 = new ExDBFieldString<>("dyouvrate28", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate29 = new ExDBFieldString<>("dyouvrate29", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate30 = new ExDBFieldString<>("dyouvrate30", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate31 = new ExDBFieldString<>("dyouvrate31", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate32 = new ExDBFieldString<>("dyouvrate32", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate33 = new ExDBFieldString<>("dyouvrate33", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate34 = new ExDBFieldString<>("dyouvrate34", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate35 = new ExDBFieldString<>("dyouvrate35", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate36 = new ExDBFieldString<>("dyouvrate36", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate37 = new ExDBFieldString<>("dyouvrate37", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate38 = new ExDBFieldString<>("dyouvrate38", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate39 = new ExDBFieldString<>("dyouvrate39", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate40 = new ExDBFieldString<>("dyouvrate40", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate41 = new ExDBFieldString<>("dyouvrate41", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate42 = new ExDBFieldString<>("dyouvrate42", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate43 = new ExDBFieldString<>("dyouvrate43", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate44 = new ExDBFieldString<>("dyouvrate44", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate45 = new ExDBFieldString<>("dyouvrate45", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate46 = new ExDBFieldString<>("dyouvrate46", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate47 = new ExDBFieldString<>("dyouvrate47", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate48 = new ExDBFieldString<>("dyouvrate48", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate49 = new ExDBFieldString<>("dyouvrate49", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate50 = new ExDBFieldString<>("dyouvrate50", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate51 = new ExDBFieldString<>("dyouvrate51", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate52 = new ExDBFieldString<>("dyouvrate52", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate53 = new ExDBFieldString<>("dyouvrate53", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate54 = new ExDBFieldString<>("dyouvrate54", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate55 = new ExDBFieldString<>("dyouvrate55", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate56 = new ExDBFieldString<>("dyouvrate56", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate57 = new ExDBFieldString<>("dyouvrate57", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate58 = new ExDBFieldString<>("dyouvrate58", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate59 = new ExDBFieldString<>("dyouvrate59", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate60 = new ExDBFieldString<>("dyouvrate60", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate61 = new ExDBFieldString<>("dyouvrate61", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate62 = new ExDBFieldString<>("dyouvrate62", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate63 = new ExDBFieldString<>("dyouvrate63", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate64 = new ExDBFieldString<>("dyouvrate64", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate65 = new ExDBFieldString<>("dyouvrate65", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate66 = new ExDBFieldString<>("dyouvrate66", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate67 = new ExDBFieldString<>("dyouvrate67", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate68 = new ExDBFieldString<>("dyouvrate68", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate69 = new ExDBFieldString<>("dyouvrate69", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate70 = new ExDBFieldString<>("dyouvrate70", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate71 = new ExDBFieldString<>("dyouvrate71", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate72 = new ExDBFieldString<>("dyouvrate72", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate73 = new ExDBFieldString<>("dyouvrate73", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate74 = new ExDBFieldString<>("dyouvrate74", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate75 = new ExDBFieldString<>("dyouvrate75", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate76 = new ExDBFieldString<>("dyouvrate76", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate77 = new ExDBFieldString<>("dyouvrate77", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate78 = new ExDBFieldString<>("dyouvrate78", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate79 = new ExDBFieldString<>("dyouvrate79", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate80 = new ExDBFieldString<>("dyouvrate80", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate81 = new ExDBFieldString<>("dyouvrate81", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate82 = new ExDBFieldString<>("dyouvrate82", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate83 = new ExDBFieldString<>("dyouvrate83", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate84 = new ExDBFieldString<>("dyouvrate84", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate85 = new ExDBFieldString<>("dyouvrate85", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate86 = new ExDBFieldString<>("dyouvrate86", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate87 = new ExDBFieldString<>("dyouvrate87", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate88 = new ExDBFieldString<>("dyouvrate88", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate89 = new ExDBFieldString<>("dyouvrate89", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate90 = new ExDBFieldString<>("dyouvrate90", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate91 = new ExDBFieldString<>("dyouvrate91", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate92 = new ExDBFieldString<>("dyouvrate92", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate93 = new ExDBFieldString<>("dyouvrate93", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate94 = new ExDBFieldString<>("dyouvrate94", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate95 = new ExDBFieldString<>("dyouvrate95", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate96 = new ExDBFieldString<>("dyouvrate96", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate97 = new ExDBFieldString<>("dyouvrate97", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate98 = new ExDBFieldString<>("dyouvrate98", this, BizNumberType.class);

    public final ExDBFieldString<BM_RisaHitSyouhnyouRateD2, BizNumber> dyouvrate99 = new ExDBFieldString<>("dyouvrate99", this, BizNumberType.class);
}
