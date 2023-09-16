package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_RateW;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * Ｗレートマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_RateW extends AbstractExDBTable<BM_RateW> {

    public GenQBM_RateW() {
        this("BM_RateW");
    }

    public GenQBM_RateW(String pAlias) {
        super("BM_RateW", BM_RateW.class, pAlias);
    }

    public String BM_RateW() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_RateW, String> palhokensyuruikigou = new ExDBFieldString<>("palhokensyuruikigou", this);

    public final ExDBFieldString<BM_RateW, String> palhokensyuruikigousdicode = new ExDBFieldString<>("palhokensyuruikigousdicode", this);

    public final ExDBFieldString<BM_RateW, String> palyoteiriritu = new ExDBFieldString<>("palyoteiriritu", this);

    public final ExDBFieldString<BM_RateW, String> palpmencode = new ExDBFieldString<>("palpmencode", this);

    public final ExDBFieldString<BM_RateW, String> palharaikomikaisuu = new ExDBFieldString<>("palharaikomikaisuu", this);

    public final ExDBFieldString<BM_RateW, String> palhhknsei = new ExDBFieldString<>("palhhknsei", this);

    public final ExDBFieldString<BM_RateW, String> palkeiyakujihhknnen = new ExDBFieldString<>("palkeiyakujihhknnen", this);

    public final ExDBFieldString<BM_RateW, String> palsaimankihyouji = new ExDBFieldString<>("palsaimankihyouji", this);

    public final ExDBFieldString<BM_RateW, String> palhokenkikan = new ExDBFieldString<>("palhokenkikan", this);

    public final ExDBFieldString<BM_RateW, String> palpharaikomikikan = new ExDBFieldString<>("palpharaikomikikan", this);

    public final ExDBFieldString<BM_RateW, String> palannaihuyouriyuukbn = new ExDBFieldString<>("palannaihuyouriyuukbn", this);

    public final ExDBFieldString<BM_RateW, String> ratetuukasyukbn = new ExDBFieldString<>("ratetuukasyukbn", this);

    public final ExDBFieldString<BM_RateW, String> ratedai1hknkkn = new ExDBFieldString<>("ratedai1hknkkn", this);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate00 = new ExDBFieldString<>("wrate00", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate01 = new ExDBFieldString<>("wrate01", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate02 = new ExDBFieldString<>("wrate02", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate03 = new ExDBFieldString<>("wrate03", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate04 = new ExDBFieldString<>("wrate04", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate05 = new ExDBFieldString<>("wrate05", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate06 = new ExDBFieldString<>("wrate06", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate07 = new ExDBFieldString<>("wrate07", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate08 = new ExDBFieldString<>("wrate08", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate09 = new ExDBFieldString<>("wrate09", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate10 = new ExDBFieldString<>("wrate10", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate11 = new ExDBFieldString<>("wrate11", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate12 = new ExDBFieldString<>("wrate12", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate13 = new ExDBFieldString<>("wrate13", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate14 = new ExDBFieldString<>("wrate14", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate15 = new ExDBFieldString<>("wrate15", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate16 = new ExDBFieldString<>("wrate16", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate17 = new ExDBFieldString<>("wrate17", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate18 = new ExDBFieldString<>("wrate18", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate19 = new ExDBFieldString<>("wrate19", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate20 = new ExDBFieldString<>("wrate20", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate21 = new ExDBFieldString<>("wrate21", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate22 = new ExDBFieldString<>("wrate22", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate23 = new ExDBFieldString<>("wrate23", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate24 = new ExDBFieldString<>("wrate24", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate25 = new ExDBFieldString<>("wrate25", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate26 = new ExDBFieldString<>("wrate26", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate27 = new ExDBFieldString<>("wrate27", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate28 = new ExDBFieldString<>("wrate28", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate29 = new ExDBFieldString<>("wrate29", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate30 = new ExDBFieldString<>("wrate30", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate31 = new ExDBFieldString<>("wrate31", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate32 = new ExDBFieldString<>("wrate32", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate33 = new ExDBFieldString<>("wrate33", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate34 = new ExDBFieldString<>("wrate34", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate35 = new ExDBFieldString<>("wrate35", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate36 = new ExDBFieldString<>("wrate36", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate37 = new ExDBFieldString<>("wrate37", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate38 = new ExDBFieldString<>("wrate38", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate39 = new ExDBFieldString<>("wrate39", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate40 = new ExDBFieldString<>("wrate40", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate41 = new ExDBFieldString<>("wrate41", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate42 = new ExDBFieldString<>("wrate42", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate43 = new ExDBFieldString<>("wrate43", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate44 = new ExDBFieldString<>("wrate44", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate45 = new ExDBFieldString<>("wrate45", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate46 = new ExDBFieldString<>("wrate46", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate47 = new ExDBFieldString<>("wrate47", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate48 = new ExDBFieldString<>("wrate48", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate49 = new ExDBFieldString<>("wrate49", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate50 = new ExDBFieldString<>("wrate50", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate51 = new ExDBFieldString<>("wrate51", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate52 = new ExDBFieldString<>("wrate52", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate53 = new ExDBFieldString<>("wrate53", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate54 = new ExDBFieldString<>("wrate54", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate55 = new ExDBFieldString<>("wrate55", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate56 = new ExDBFieldString<>("wrate56", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate57 = new ExDBFieldString<>("wrate57", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate58 = new ExDBFieldString<>("wrate58", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate59 = new ExDBFieldString<>("wrate59", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate60 = new ExDBFieldString<>("wrate60", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate61 = new ExDBFieldString<>("wrate61", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate62 = new ExDBFieldString<>("wrate62", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate63 = new ExDBFieldString<>("wrate63", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate64 = new ExDBFieldString<>("wrate64", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate65 = new ExDBFieldString<>("wrate65", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate66 = new ExDBFieldString<>("wrate66", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate67 = new ExDBFieldString<>("wrate67", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate68 = new ExDBFieldString<>("wrate68", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate69 = new ExDBFieldString<>("wrate69", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate70 = new ExDBFieldString<>("wrate70", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate71 = new ExDBFieldString<>("wrate71", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate72 = new ExDBFieldString<>("wrate72", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate73 = new ExDBFieldString<>("wrate73", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate74 = new ExDBFieldString<>("wrate74", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate75 = new ExDBFieldString<>("wrate75", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate76 = new ExDBFieldString<>("wrate76", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate77 = new ExDBFieldString<>("wrate77", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate78 = new ExDBFieldString<>("wrate78", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate79 = new ExDBFieldString<>("wrate79", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate80 = new ExDBFieldString<>("wrate80", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate81 = new ExDBFieldString<>("wrate81", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate82 = new ExDBFieldString<>("wrate82", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate83 = new ExDBFieldString<>("wrate83", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate84 = new ExDBFieldString<>("wrate84", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate85 = new ExDBFieldString<>("wrate85", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate86 = new ExDBFieldString<>("wrate86", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate87 = new ExDBFieldString<>("wrate87", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate88 = new ExDBFieldString<>("wrate88", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate89 = new ExDBFieldString<>("wrate89", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate90 = new ExDBFieldString<>("wrate90", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate91 = new ExDBFieldString<>("wrate91", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate92 = new ExDBFieldString<>("wrate92", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate93 = new ExDBFieldString<>("wrate93", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate94 = new ExDBFieldString<>("wrate94", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate95 = new ExDBFieldString<>("wrate95", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate96 = new ExDBFieldString<>("wrate96", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate97 = new ExDBFieldString<>("wrate97", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate98 = new ExDBFieldString<>("wrate98", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateW, BizNumber> wrate99 = new ExDBFieldString<>("wrate99", this, BizNumberType.class);
}
