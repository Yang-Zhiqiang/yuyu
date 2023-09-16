package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_RateD;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * Ｄレートマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_RateD extends AbstractExDBTable<BM_RateD> {

    public GenQBM_RateD() {
        this("BM_RateD");
    }

    public GenQBM_RateD(String pAlias) {
        super("BM_RateD", BM_RateD.class, pAlias);
    }

    public String BM_RateD() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_RateD, String> palhokensyuruikigou = new ExDBFieldString<>("palhokensyuruikigou", this);

    public final ExDBFieldString<BM_RateD, String> palhokensyuruikigousdicode = new ExDBFieldString<>("palhokensyuruikigousdicode", this);

    public final ExDBFieldString<BM_RateD, String> palyoteiriritu = new ExDBFieldString<>("palyoteiriritu", this);

    public final ExDBFieldString<BM_RateD, String> palpmencode = new ExDBFieldString<>("palpmencode", this);

    public final ExDBFieldString<BM_RateD, String> palharaikomikaisuu = new ExDBFieldString<>("palharaikomikaisuu", this);

    public final ExDBFieldString<BM_RateD, String> palhhknsei = new ExDBFieldString<>("palhhknsei", this);

    public final ExDBFieldString<BM_RateD, String> palkeiyakujihhknnen = new ExDBFieldString<>("palkeiyakujihhknnen", this);

    public final ExDBFieldString<BM_RateD, String> palsaimankihyouji = new ExDBFieldString<>("palsaimankihyouji", this);

    public final ExDBFieldString<BM_RateD, String> palhokenkikan = new ExDBFieldString<>("palhokenkikan", this);

    public final ExDBFieldString<BM_RateD, String> palpharaikomikikan = new ExDBFieldString<>("palpharaikomikikan", this);

    public final ExDBFieldString<BM_RateD, String> paldnendo = new ExDBFieldString<>("paldnendo", this);

    public final ExDBFieldString<BM_RateD, String> paldratenaikakucode = new ExDBFieldString<>("paldratenaikakucode", this);

    public final ExDBFieldString<BM_RateD, BizNumber> drate00 = new ExDBFieldString<>("drate00", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate01 = new ExDBFieldString<>("drate01", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate02 = new ExDBFieldString<>("drate02", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate03 = new ExDBFieldString<>("drate03", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate04 = new ExDBFieldString<>("drate04", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate05 = new ExDBFieldString<>("drate05", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate06 = new ExDBFieldString<>("drate06", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate07 = new ExDBFieldString<>("drate07", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate08 = new ExDBFieldString<>("drate08", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate09 = new ExDBFieldString<>("drate09", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate10 = new ExDBFieldString<>("drate10", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate11 = new ExDBFieldString<>("drate11", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate12 = new ExDBFieldString<>("drate12", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate13 = new ExDBFieldString<>("drate13", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate14 = new ExDBFieldString<>("drate14", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate15 = new ExDBFieldString<>("drate15", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate16 = new ExDBFieldString<>("drate16", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate17 = new ExDBFieldString<>("drate17", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate18 = new ExDBFieldString<>("drate18", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate19 = new ExDBFieldString<>("drate19", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate20 = new ExDBFieldString<>("drate20", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate21 = new ExDBFieldString<>("drate21", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate22 = new ExDBFieldString<>("drate22", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate23 = new ExDBFieldString<>("drate23", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate24 = new ExDBFieldString<>("drate24", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate25 = new ExDBFieldString<>("drate25", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate26 = new ExDBFieldString<>("drate26", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate27 = new ExDBFieldString<>("drate27", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate28 = new ExDBFieldString<>("drate28", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate29 = new ExDBFieldString<>("drate29", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate30 = new ExDBFieldString<>("drate30", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate31 = new ExDBFieldString<>("drate31", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate32 = new ExDBFieldString<>("drate32", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate33 = new ExDBFieldString<>("drate33", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate34 = new ExDBFieldString<>("drate34", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate35 = new ExDBFieldString<>("drate35", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate36 = new ExDBFieldString<>("drate36", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate37 = new ExDBFieldString<>("drate37", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate38 = new ExDBFieldString<>("drate38", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate39 = new ExDBFieldString<>("drate39", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate40 = new ExDBFieldString<>("drate40", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate41 = new ExDBFieldString<>("drate41", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate42 = new ExDBFieldString<>("drate42", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate43 = new ExDBFieldString<>("drate43", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate44 = new ExDBFieldString<>("drate44", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate45 = new ExDBFieldString<>("drate45", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate46 = new ExDBFieldString<>("drate46", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate47 = new ExDBFieldString<>("drate47", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate48 = new ExDBFieldString<>("drate48", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate49 = new ExDBFieldString<>("drate49", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate50 = new ExDBFieldString<>("drate50", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate51 = new ExDBFieldString<>("drate51", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate52 = new ExDBFieldString<>("drate52", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate53 = new ExDBFieldString<>("drate53", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate54 = new ExDBFieldString<>("drate54", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate55 = new ExDBFieldString<>("drate55", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate56 = new ExDBFieldString<>("drate56", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate57 = new ExDBFieldString<>("drate57", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate58 = new ExDBFieldString<>("drate58", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate59 = new ExDBFieldString<>("drate59", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate60 = new ExDBFieldString<>("drate60", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate61 = new ExDBFieldString<>("drate61", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate62 = new ExDBFieldString<>("drate62", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate63 = new ExDBFieldString<>("drate63", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate64 = new ExDBFieldString<>("drate64", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate65 = new ExDBFieldString<>("drate65", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate66 = new ExDBFieldString<>("drate66", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate67 = new ExDBFieldString<>("drate67", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate68 = new ExDBFieldString<>("drate68", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate69 = new ExDBFieldString<>("drate69", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate70 = new ExDBFieldString<>("drate70", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate71 = new ExDBFieldString<>("drate71", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate72 = new ExDBFieldString<>("drate72", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate73 = new ExDBFieldString<>("drate73", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate74 = new ExDBFieldString<>("drate74", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate75 = new ExDBFieldString<>("drate75", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate76 = new ExDBFieldString<>("drate76", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate77 = new ExDBFieldString<>("drate77", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate78 = new ExDBFieldString<>("drate78", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate79 = new ExDBFieldString<>("drate79", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate80 = new ExDBFieldString<>("drate80", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate81 = new ExDBFieldString<>("drate81", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate82 = new ExDBFieldString<>("drate82", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate83 = new ExDBFieldString<>("drate83", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate84 = new ExDBFieldString<>("drate84", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate85 = new ExDBFieldString<>("drate85", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate86 = new ExDBFieldString<>("drate86", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate87 = new ExDBFieldString<>("drate87", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate88 = new ExDBFieldString<>("drate88", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate89 = new ExDBFieldString<>("drate89", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate90 = new ExDBFieldString<>("drate90", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate91 = new ExDBFieldString<>("drate91", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate92 = new ExDBFieldString<>("drate92", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate93 = new ExDBFieldString<>("drate93", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate94 = new ExDBFieldString<>("drate94", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate95 = new ExDBFieldString<>("drate95", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate96 = new ExDBFieldString<>("drate96", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate97 = new ExDBFieldString<>("drate97", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate98 = new ExDBFieldString<>("drate98", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> drate99 = new ExDBFieldString<>("drate99", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate00 = new ExDBFieldString<>("sisadrate00", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate01 = new ExDBFieldString<>("sisadrate01", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate02 = new ExDBFieldString<>("sisadrate02", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate03 = new ExDBFieldString<>("sisadrate03", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate04 = new ExDBFieldString<>("sisadrate04", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate05 = new ExDBFieldString<>("sisadrate05", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate06 = new ExDBFieldString<>("sisadrate06", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate07 = new ExDBFieldString<>("sisadrate07", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate08 = new ExDBFieldString<>("sisadrate08", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate09 = new ExDBFieldString<>("sisadrate09", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate10 = new ExDBFieldString<>("sisadrate10", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate11 = new ExDBFieldString<>("sisadrate11", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate12 = new ExDBFieldString<>("sisadrate12", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate13 = new ExDBFieldString<>("sisadrate13", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate14 = new ExDBFieldString<>("sisadrate14", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate15 = new ExDBFieldString<>("sisadrate15", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate16 = new ExDBFieldString<>("sisadrate16", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate17 = new ExDBFieldString<>("sisadrate17", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate18 = new ExDBFieldString<>("sisadrate18", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate19 = new ExDBFieldString<>("sisadrate19", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate20 = new ExDBFieldString<>("sisadrate20", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate21 = new ExDBFieldString<>("sisadrate21", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate22 = new ExDBFieldString<>("sisadrate22", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate23 = new ExDBFieldString<>("sisadrate23", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate24 = new ExDBFieldString<>("sisadrate24", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate25 = new ExDBFieldString<>("sisadrate25", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate26 = new ExDBFieldString<>("sisadrate26", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate27 = new ExDBFieldString<>("sisadrate27", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate28 = new ExDBFieldString<>("sisadrate28", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate29 = new ExDBFieldString<>("sisadrate29", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate30 = new ExDBFieldString<>("sisadrate30", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate31 = new ExDBFieldString<>("sisadrate31", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate32 = new ExDBFieldString<>("sisadrate32", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate33 = new ExDBFieldString<>("sisadrate33", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate34 = new ExDBFieldString<>("sisadrate34", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate35 = new ExDBFieldString<>("sisadrate35", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate36 = new ExDBFieldString<>("sisadrate36", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate37 = new ExDBFieldString<>("sisadrate37", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate38 = new ExDBFieldString<>("sisadrate38", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate39 = new ExDBFieldString<>("sisadrate39", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate40 = new ExDBFieldString<>("sisadrate40", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate41 = new ExDBFieldString<>("sisadrate41", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate42 = new ExDBFieldString<>("sisadrate42", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate43 = new ExDBFieldString<>("sisadrate43", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate44 = new ExDBFieldString<>("sisadrate44", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate45 = new ExDBFieldString<>("sisadrate45", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate46 = new ExDBFieldString<>("sisadrate46", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate47 = new ExDBFieldString<>("sisadrate47", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate48 = new ExDBFieldString<>("sisadrate48", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate49 = new ExDBFieldString<>("sisadrate49", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate50 = new ExDBFieldString<>("sisadrate50", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate51 = new ExDBFieldString<>("sisadrate51", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate52 = new ExDBFieldString<>("sisadrate52", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate53 = new ExDBFieldString<>("sisadrate53", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate54 = new ExDBFieldString<>("sisadrate54", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate55 = new ExDBFieldString<>("sisadrate55", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate56 = new ExDBFieldString<>("sisadrate56", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate57 = new ExDBFieldString<>("sisadrate57", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate58 = new ExDBFieldString<>("sisadrate58", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate59 = new ExDBFieldString<>("sisadrate59", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate60 = new ExDBFieldString<>("sisadrate60", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate61 = new ExDBFieldString<>("sisadrate61", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate62 = new ExDBFieldString<>("sisadrate62", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate63 = new ExDBFieldString<>("sisadrate63", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate64 = new ExDBFieldString<>("sisadrate64", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate65 = new ExDBFieldString<>("sisadrate65", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate66 = new ExDBFieldString<>("sisadrate66", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate67 = new ExDBFieldString<>("sisadrate67", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate68 = new ExDBFieldString<>("sisadrate68", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate69 = new ExDBFieldString<>("sisadrate69", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate70 = new ExDBFieldString<>("sisadrate70", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate71 = new ExDBFieldString<>("sisadrate71", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate72 = new ExDBFieldString<>("sisadrate72", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate73 = new ExDBFieldString<>("sisadrate73", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate74 = new ExDBFieldString<>("sisadrate74", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate75 = new ExDBFieldString<>("sisadrate75", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate76 = new ExDBFieldString<>("sisadrate76", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate77 = new ExDBFieldString<>("sisadrate77", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate78 = new ExDBFieldString<>("sisadrate78", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate79 = new ExDBFieldString<>("sisadrate79", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate80 = new ExDBFieldString<>("sisadrate80", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate81 = new ExDBFieldString<>("sisadrate81", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate82 = new ExDBFieldString<>("sisadrate82", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate83 = new ExDBFieldString<>("sisadrate83", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate84 = new ExDBFieldString<>("sisadrate84", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate85 = new ExDBFieldString<>("sisadrate85", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate86 = new ExDBFieldString<>("sisadrate86", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate87 = new ExDBFieldString<>("sisadrate87", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate88 = new ExDBFieldString<>("sisadrate88", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate89 = new ExDBFieldString<>("sisadrate89", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate90 = new ExDBFieldString<>("sisadrate90", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate91 = new ExDBFieldString<>("sisadrate91", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate92 = new ExDBFieldString<>("sisadrate92", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate93 = new ExDBFieldString<>("sisadrate93", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate94 = new ExDBFieldString<>("sisadrate94", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate95 = new ExDBFieldString<>("sisadrate95", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate96 = new ExDBFieldString<>("sisadrate96", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate97 = new ExDBFieldString<>("sisadrate97", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate98 = new ExDBFieldString<>("sisadrate98", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> sisadrate99 = new ExDBFieldString<>("sisadrate99", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate00 = new ExDBFieldString<>("risadrate00", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate01 = new ExDBFieldString<>("risadrate01", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate02 = new ExDBFieldString<>("risadrate02", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate03 = new ExDBFieldString<>("risadrate03", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate04 = new ExDBFieldString<>("risadrate04", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate05 = new ExDBFieldString<>("risadrate05", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate06 = new ExDBFieldString<>("risadrate06", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate07 = new ExDBFieldString<>("risadrate07", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate08 = new ExDBFieldString<>("risadrate08", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate09 = new ExDBFieldString<>("risadrate09", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate10 = new ExDBFieldString<>("risadrate10", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate11 = new ExDBFieldString<>("risadrate11", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate12 = new ExDBFieldString<>("risadrate12", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate13 = new ExDBFieldString<>("risadrate13", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate14 = new ExDBFieldString<>("risadrate14", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate15 = new ExDBFieldString<>("risadrate15", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate16 = new ExDBFieldString<>("risadrate16", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate17 = new ExDBFieldString<>("risadrate17", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate18 = new ExDBFieldString<>("risadrate18", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate19 = new ExDBFieldString<>("risadrate19", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate20 = new ExDBFieldString<>("risadrate20", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate21 = new ExDBFieldString<>("risadrate21", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate22 = new ExDBFieldString<>("risadrate22", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate23 = new ExDBFieldString<>("risadrate23", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate24 = new ExDBFieldString<>("risadrate24", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate25 = new ExDBFieldString<>("risadrate25", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate26 = new ExDBFieldString<>("risadrate26", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate27 = new ExDBFieldString<>("risadrate27", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate28 = new ExDBFieldString<>("risadrate28", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate29 = new ExDBFieldString<>("risadrate29", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate30 = new ExDBFieldString<>("risadrate30", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate31 = new ExDBFieldString<>("risadrate31", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate32 = new ExDBFieldString<>("risadrate32", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate33 = new ExDBFieldString<>("risadrate33", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate34 = new ExDBFieldString<>("risadrate34", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate35 = new ExDBFieldString<>("risadrate35", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate36 = new ExDBFieldString<>("risadrate36", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate37 = new ExDBFieldString<>("risadrate37", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate38 = new ExDBFieldString<>("risadrate38", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate39 = new ExDBFieldString<>("risadrate39", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate40 = new ExDBFieldString<>("risadrate40", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate41 = new ExDBFieldString<>("risadrate41", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate42 = new ExDBFieldString<>("risadrate42", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate43 = new ExDBFieldString<>("risadrate43", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate44 = new ExDBFieldString<>("risadrate44", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate45 = new ExDBFieldString<>("risadrate45", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate46 = new ExDBFieldString<>("risadrate46", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate47 = new ExDBFieldString<>("risadrate47", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate48 = new ExDBFieldString<>("risadrate48", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate49 = new ExDBFieldString<>("risadrate49", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate50 = new ExDBFieldString<>("risadrate50", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate51 = new ExDBFieldString<>("risadrate51", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate52 = new ExDBFieldString<>("risadrate52", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate53 = new ExDBFieldString<>("risadrate53", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate54 = new ExDBFieldString<>("risadrate54", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate55 = new ExDBFieldString<>("risadrate55", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate56 = new ExDBFieldString<>("risadrate56", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate57 = new ExDBFieldString<>("risadrate57", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate58 = new ExDBFieldString<>("risadrate58", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate59 = new ExDBFieldString<>("risadrate59", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate60 = new ExDBFieldString<>("risadrate60", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate61 = new ExDBFieldString<>("risadrate61", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate62 = new ExDBFieldString<>("risadrate62", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate63 = new ExDBFieldString<>("risadrate63", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate64 = new ExDBFieldString<>("risadrate64", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate65 = new ExDBFieldString<>("risadrate65", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate66 = new ExDBFieldString<>("risadrate66", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate67 = new ExDBFieldString<>("risadrate67", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate68 = new ExDBFieldString<>("risadrate68", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate69 = new ExDBFieldString<>("risadrate69", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate70 = new ExDBFieldString<>("risadrate70", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate71 = new ExDBFieldString<>("risadrate71", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate72 = new ExDBFieldString<>("risadrate72", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate73 = new ExDBFieldString<>("risadrate73", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate74 = new ExDBFieldString<>("risadrate74", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate75 = new ExDBFieldString<>("risadrate75", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate76 = new ExDBFieldString<>("risadrate76", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate77 = new ExDBFieldString<>("risadrate77", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate78 = new ExDBFieldString<>("risadrate78", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate79 = new ExDBFieldString<>("risadrate79", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate80 = new ExDBFieldString<>("risadrate80", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate81 = new ExDBFieldString<>("risadrate81", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate82 = new ExDBFieldString<>("risadrate82", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate83 = new ExDBFieldString<>("risadrate83", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate84 = new ExDBFieldString<>("risadrate84", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate85 = new ExDBFieldString<>("risadrate85", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate86 = new ExDBFieldString<>("risadrate86", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate87 = new ExDBFieldString<>("risadrate87", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate88 = new ExDBFieldString<>("risadrate88", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate89 = new ExDBFieldString<>("risadrate89", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate90 = new ExDBFieldString<>("risadrate90", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate91 = new ExDBFieldString<>("risadrate91", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate92 = new ExDBFieldString<>("risadrate92", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate93 = new ExDBFieldString<>("risadrate93", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate94 = new ExDBFieldString<>("risadrate94", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate95 = new ExDBFieldString<>("risadrate95", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate96 = new ExDBFieldString<>("risadrate96", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate97 = new ExDBFieldString<>("risadrate97", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate98 = new ExDBFieldString<>("risadrate98", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> risadrate99 = new ExDBFieldString<>("risadrate99", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate00 = new ExDBFieldString<>("hisadrate00", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate01 = new ExDBFieldString<>("hisadrate01", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate02 = new ExDBFieldString<>("hisadrate02", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate03 = new ExDBFieldString<>("hisadrate03", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate04 = new ExDBFieldString<>("hisadrate04", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate05 = new ExDBFieldString<>("hisadrate05", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate06 = new ExDBFieldString<>("hisadrate06", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate07 = new ExDBFieldString<>("hisadrate07", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate08 = new ExDBFieldString<>("hisadrate08", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate09 = new ExDBFieldString<>("hisadrate09", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate10 = new ExDBFieldString<>("hisadrate10", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate11 = new ExDBFieldString<>("hisadrate11", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate12 = new ExDBFieldString<>("hisadrate12", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate13 = new ExDBFieldString<>("hisadrate13", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate14 = new ExDBFieldString<>("hisadrate14", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate15 = new ExDBFieldString<>("hisadrate15", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate16 = new ExDBFieldString<>("hisadrate16", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate17 = new ExDBFieldString<>("hisadrate17", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate18 = new ExDBFieldString<>("hisadrate18", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate19 = new ExDBFieldString<>("hisadrate19", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate20 = new ExDBFieldString<>("hisadrate20", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate21 = new ExDBFieldString<>("hisadrate21", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate22 = new ExDBFieldString<>("hisadrate22", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate23 = new ExDBFieldString<>("hisadrate23", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate24 = new ExDBFieldString<>("hisadrate24", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate25 = new ExDBFieldString<>("hisadrate25", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate26 = new ExDBFieldString<>("hisadrate26", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate27 = new ExDBFieldString<>("hisadrate27", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate28 = new ExDBFieldString<>("hisadrate28", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate29 = new ExDBFieldString<>("hisadrate29", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate30 = new ExDBFieldString<>("hisadrate30", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate31 = new ExDBFieldString<>("hisadrate31", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate32 = new ExDBFieldString<>("hisadrate32", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate33 = new ExDBFieldString<>("hisadrate33", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate34 = new ExDBFieldString<>("hisadrate34", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate35 = new ExDBFieldString<>("hisadrate35", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate36 = new ExDBFieldString<>("hisadrate36", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate37 = new ExDBFieldString<>("hisadrate37", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate38 = new ExDBFieldString<>("hisadrate38", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate39 = new ExDBFieldString<>("hisadrate39", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate40 = new ExDBFieldString<>("hisadrate40", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate41 = new ExDBFieldString<>("hisadrate41", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate42 = new ExDBFieldString<>("hisadrate42", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate43 = new ExDBFieldString<>("hisadrate43", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate44 = new ExDBFieldString<>("hisadrate44", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate45 = new ExDBFieldString<>("hisadrate45", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate46 = new ExDBFieldString<>("hisadrate46", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate47 = new ExDBFieldString<>("hisadrate47", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate48 = new ExDBFieldString<>("hisadrate48", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate49 = new ExDBFieldString<>("hisadrate49", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate50 = new ExDBFieldString<>("hisadrate50", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate51 = new ExDBFieldString<>("hisadrate51", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate52 = new ExDBFieldString<>("hisadrate52", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate53 = new ExDBFieldString<>("hisadrate53", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate54 = new ExDBFieldString<>("hisadrate54", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate55 = new ExDBFieldString<>("hisadrate55", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate56 = new ExDBFieldString<>("hisadrate56", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate57 = new ExDBFieldString<>("hisadrate57", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate58 = new ExDBFieldString<>("hisadrate58", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate59 = new ExDBFieldString<>("hisadrate59", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate60 = new ExDBFieldString<>("hisadrate60", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate61 = new ExDBFieldString<>("hisadrate61", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate62 = new ExDBFieldString<>("hisadrate62", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate63 = new ExDBFieldString<>("hisadrate63", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate64 = new ExDBFieldString<>("hisadrate64", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate65 = new ExDBFieldString<>("hisadrate65", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate66 = new ExDBFieldString<>("hisadrate66", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate67 = new ExDBFieldString<>("hisadrate67", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate68 = new ExDBFieldString<>("hisadrate68", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate69 = new ExDBFieldString<>("hisadrate69", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate70 = new ExDBFieldString<>("hisadrate70", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate71 = new ExDBFieldString<>("hisadrate71", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate72 = new ExDBFieldString<>("hisadrate72", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate73 = new ExDBFieldString<>("hisadrate73", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate74 = new ExDBFieldString<>("hisadrate74", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate75 = new ExDBFieldString<>("hisadrate75", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate76 = new ExDBFieldString<>("hisadrate76", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate77 = new ExDBFieldString<>("hisadrate77", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate78 = new ExDBFieldString<>("hisadrate78", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate79 = new ExDBFieldString<>("hisadrate79", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate80 = new ExDBFieldString<>("hisadrate80", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate81 = new ExDBFieldString<>("hisadrate81", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate82 = new ExDBFieldString<>("hisadrate82", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate83 = new ExDBFieldString<>("hisadrate83", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate84 = new ExDBFieldString<>("hisadrate84", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate85 = new ExDBFieldString<>("hisadrate85", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate86 = new ExDBFieldString<>("hisadrate86", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate87 = new ExDBFieldString<>("hisadrate87", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate88 = new ExDBFieldString<>("hisadrate88", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate89 = new ExDBFieldString<>("hisadrate89", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate90 = new ExDBFieldString<>("hisadrate90", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate91 = new ExDBFieldString<>("hisadrate91", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate92 = new ExDBFieldString<>("hisadrate92", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate93 = new ExDBFieldString<>("hisadrate93", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate94 = new ExDBFieldString<>("hisadrate94", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate95 = new ExDBFieldString<>("hisadrate95", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate96 = new ExDBFieldString<>("hisadrate96", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate97 = new ExDBFieldString<>("hisadrate97", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate98 = new ExDBFieldString<>("hisadrate98", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> hisadrate99 = new ExDBFieldString<>("hisadrate99", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate00 = new ExDBFieldString<>("dyouvrate00", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate01 = new ExDBFieldString<>("dyouvrate01", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate02 = new ExDBFieldString<>("dyouvrate02", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate03 = new ExDBFieldString<>("dyouvrate03", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate04 = new ExDBFieldString<>("dyouvrate04", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate05 = new ExDBFieldString<>("dyouvrate05", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate06 = new ExDBFieldString<>("dyouvrate06", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate07 = new ExDBFieldString<>("dyouvrate07", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate08 = new ExDBFieldString<>("dyouvrate08", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate09 = new ExDBFieldString<>("dyouvrate09", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate10 = new ExDBFieldString<>("dyouvrate10", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate11 = new ExDBFieldString<>("dyouvrate11", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate12 = new ExDBFieldString<>("dyouvrate12", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate13 = new ExDBFieldString<>("dyouvrate13", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate14 = new ExDBFieldString<>("dyouvrate14", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate15 = new ExDBFieldString<>("dyouvrate15", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate16 = new ExDBFieldString<>("dyouvrate16", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate17 = new ExDBFieldString<>("dyouvrate17", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate18 = new ExDBFieldString<>("dyouvrate18", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate19 = new ExDBFieldString<>("dyouvrate19", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate20 = new ExDBFieldString<>("dyouvrate20", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate21 = new ExDBFieldString<>("dyouvrate21", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate22 = new ExDBFieldString<>("dyouvrate22", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate23 = new ExDBFieldString<>("dyouvrate23", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate24 = new ExDBFieldString<>("dyouvrate24", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate25 = new ExDBFieldString<>("dyouvrate25", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate26 = new ExDBFieldString<>("dyouvrate26", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate27 = new ExDBFieldString<>("dyouvrate27", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate28 = new ExDBFieldString<>("dyouvrate28", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate29 = new ExDBFieldString<>("dyouvrate29", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate30 = new ExDBFieldString<>("dyouvrate30", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate31 = new ExDBFieldString<>("dyouvrate31", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate32 = new ExDBFieldString<>("dyouvrate32", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate33 = new ExDBFieldString<>("dyouvrate33", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate34 = new ExDBFieldString<>("dyouvrate34", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate35 = new ExDBFieldString<>("dyouvrate35", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate36 = new ExDBFieldString<>("dyouvrate36", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate37 = new ExDBFieldString<>("dyouvrate37", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate38 = new ExDBFieldString<>("dyouvrate38", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate39 = new ExDBFieldString<>("dyouvrate39", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate40 = new ExDBFieldString<>("dyouvrate40", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate41 = new ExDBFieldString<>("dyouvrate41", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate42 = new ExDBFieldString<>("dyouvrate42", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate43 = new ExDBFieldString<>("dyouvrate43", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate44 = new ExDBFieldString<>("dyouvrate44", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate45 = new ExDBFieldString<>("dyouvrate45", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate46 = new ExDBFieldString<>("dyouvrate46", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate47 = new ExDBFieldString<>("dyouvrate47", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate48 = new ExDBFieldString<>("dyouvrate48", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate49 = new ExDBFieldString<>("dyouvrate49", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate50 = new ExDBFieldString<>("dyouvrate50", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate51 = new ExDBFieldString<>("dyouvrate51", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate52 = new ExDBFieldString<>("dyouvrate52", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate53 = new ExDBFieldString<>("dyouvrate53", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate54 = new ExDBFieldString<>("dyouvrate54", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate55 = new ExDBFieldString<>("dyouvrate55", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate56 = new ExDBFieldString<>("dyouvrate56", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate57 = new ExDBFieldString<>("dyouvrate57", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate58 = new ExDBFieldString<>("dyouvrate58", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate59 = new ExDBFieldString<>("dyouvrate59", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate60 = new ExDBFieldString<>("dyouvrate60", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate61 = new ExDBFieldString<>("dyouvrate61", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate62 = new ExDBFieldString<>("dyouvrate62", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate63 = new ExDBFieldString<>("dyouvrate63", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate64 = new ExDBFieldString<>("dyouvrate64", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate65 = new ExDBFieldString<>("dyouvrate65", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate66 = new ExDBFieldString<>("dyouvrate66", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate67 = new ExDBFieldString<>("dyouvrate67", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate68 = new ExDBFieldString<>("dyouvrate68", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate69 = new ExDBFieldString<>("dyouvrate69", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate70 = new ExDBFieldString<>("dyouvrate70", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate71 = new ExDBFieldString<>("dyouvrate71", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate72 = new ExDBFieldString<>("dyouvrate72", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate73 = new ExDBFieldString<>("dyouvrate73", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate74 = new ExDBFieldString<>("dyouvrate74", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate75 = new ExDBFieldString<>("dyouvrate75", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate76 = new ExDBFieldString<>("dyouvrate76", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate77 = new ExDBFieldString<>("dyouvrate77", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate78 = new ExDBFieldString<>("dyouvrate78", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate79 = new ExDBFieldString<>("dyouvrate79", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate80 = new ExDBFieldString<>("dyouvrate80", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate81 = new ExDBFieldString<>("dyouvrate81", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate82 = new ExDBFieldString<>("dyouvrate82", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate83 = new ExDBFieldString<>("dyouvrate83", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate84 = new ExDBFieldString<>("dyouvrate84", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate85 = new ExDBFieldString<>("dyouvrate85", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate86 = new ExDBFieldString<>("dyouvrate86", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate87 = new ExDBFieldString<>("dyouvrate87", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate88 = new ExDBFieldString<>("dyouvrate88", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate89 = new ExDBFieldString<>("dyouvrate89", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate90 = new ExDBFieldString<>("dyouvrate90", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate91 = new ExDBFieldString<>("dyouvrate91", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate92 = new ExDBFieldString<>("dyouvrate92", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate93 = new ExDBFieldString<>("dyouvrate93", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate94 = new ExDBFieldString<>("dyouvrate94", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate95 = new ExDBFieldString<>("dyouvrate95", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate96 = new ExDBFieldString<>("dyouvrate96", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate97 = new ExDBFieldString<>("dyouvrate97", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate98 = new ExDBFieldString<>("dyouvrate98", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> dyouvrate99 = new ExDBFieldString<>("dyouvrate99", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate00 = new ExDBFieldString<>("kikensrate00", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate01 = new ExDBFieldString<>("kikensrate01", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate02 = new ExDBFieldString<>("kikensrate02", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate03 = new ExDBFieldString<>("kikensrate03", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate04 = new ExDBFieldString<>("kikensrate04", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate05 = new ExDBFieldString<>("kikensrate05", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate06 = new ExDBFieldString<>("kikensrate06", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate07 = new ExDBFieldString<>("kikensrate07", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate08 = new ExDBFieldString<>("kikensrate08", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate09 = new ExDBFieldString<>("kikensrate09", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate10 = new ExDBFieldString<>("kikensrate10", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate11 = new ExDBFieldString<>("kikensrate11", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate12 = new ExDBFieldString<>("kikensrate12", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate13 = new ExDBFieldString<>("kikensrate13", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate14 = new ExDBFieldString<>("kikensrate14", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate15 = new ExDBFieldString<>("kikensrate15", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate16 = new ExDBFieldString<>("kikensrate16", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate17 = new ExDBFieldString<>("kikensrate17", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate18 = new ExDBFieldString<>("kikensrate18", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate19 = new ExDBFieldString<>("kikensrate19", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate20 = new ExDBFieldString<>("kikensrate20", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate21 = new ExDBFieldString<>("kikensrate21", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate22 = new ExDBFieldString<>("kikensrate22", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate23 = new ExDBFieldString<>("kikensrate23", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate24 = new ExDBFieldString<>("kikensrate24", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate25 = new ExDBFieldString<>("kikensrate25", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate26 = new ExDBFieldString<>("kikensrate26", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate27 = new ExDBFieldString<>("kikensrate27", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate28 = new ExDBFieldString<>("kikensrate28", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate29 = new ExDBFieldString<>("kikensrate29", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate30 = new ExDBFieldString<>("kikensrate30", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate31 = new ExDBFieldString<>("kikensrate31", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate32 = new ExDBFieldString<>("kikensrate32", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate33 = new ExDBFieldString<>("kikensrate33", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate34 = new ExDBFieldString<>("kikensrate34", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate35 = new ExDBFieldString<>("kikensrate35", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate36 = new ExDBFieldString<>("kikensrate36", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate37 = new ExDBFieldString<>("kikensrate37", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate38 = new ExDBFieldString<>("kikensrate38", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate39 = new ExDBFieldString<>("kikensrate39", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate40 = new ExDBFieldString<>("kikensrate40", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate41 = new ExDBFieldString<>("kikensrate41", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate42 = new ExDBFieldString<>("kikensrate42", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate43 = new ExDBFieldString<>("kikensrate43", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate44 = new ExDBFieldString<>("kikensrate44", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate45 = new ExDBFieldString<>("kikensrate45", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate46 = new ExDBFieldString<>("kikensrate46", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate47 = new ExDBFieldString<>("kikensrate47", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate48 = new ExDBFieldString<>("kikensrate48", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate49 = new ExDBFieldString<>("kikensrate49", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate50 = new ExDBFieldString<>("kikensrate50", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate51 = new ExDBFieldString<>("kikensrate51", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate52 = new ExDBFieldString<>("kikensrate52", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate53 = new ExDBFieldString<>("kikensrate53", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate54 = new ExDBFieldString<>("kikensrate54", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate55 = new ExDBFieldString<>("kikensrate55", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate56 = new ExDBFieldString<>("kikensrate56", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate57 = new ExDBFieldString<>("kikensrate57", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate58 = new ExDBFieldString<>("kikensrate58", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate59 = new ExDBFieldString<>("kikensrate59", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate60 = new ExDBFieldString<>("kikensrate60", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate61 = new ExDBFieldString<>("kikensrate61", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate62 = new ExDBFieldString<>("kikensrate62", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate63 = new ExDBFieldString<>("kikensrate63", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate64 = new ExDBFieldString<>("kikensrate64", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate65 = new ExDBFieldString<>("kikensrate65", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate66 = new ExDBFieldString<>("kikensrate66", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate67 = new ExDBFieldString<>("kikensrate67", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate68 = new ExDBFieldString<>("kikensrate68", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate69 = new ExDBFieldString<>("kikensrate69", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate70 = new ExDBFieldString<>("kikensrate70", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate71 = new ExDBFieldString<>("kikensrate71", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate72 = new ExDBFieldString<>("kikensrate72", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate73 = new ExDBFieldString<>("kikensrate73", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate74 = new ExDBFieldString<>("kikensrate74", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate75 = new ExDBFieldString<>("kikensrate75", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate76 = new ExDBFieldString<>("kikensrate76", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate77 = new ExDBFieldString<>("kikensrate77", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate78 = new ExDBFieldString<>("kikensrate78", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate79 = new ExDBFieldString<>("kikensrate79", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate80 = new ExDBFieldString<>("kikensrate80", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate81 = new ExDBFieldString<>("kikensrate81", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate82 = new ExDBFieldString<>("kikensrate82", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate83 = new ExDBFieldString<>("kikensrate83", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate84 = new ExDBFieldString<>("kikensrate84", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate85 = new ExDBFieldString<>("kikensrate85", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate86 = new ExDBFieldString<>("kikensrate86", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate87 = new ExDBFieldString<>("kikensrate87", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate88 = new ExDBFieldString<>("kikensrate88", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate89 = new ExDBFieldString<>("kikensrate89", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate90 = new ExDBFieldString<>("kikensrate90", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate91 = new ExDBFieldString<>("kikensrate91", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate92 = new ExDBFieldString<>("kikensrate92", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate93 = new ExDBFieldString<>("kikensrate93", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate94 = new ExDBFieldString<>("kikensrate94", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate95 = new ExDBFieldString<>("kikensrate95", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate96 = new ExDBFieldString<>("kikensrate96", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate97 = new ExDBFieldString<>("kikensrate97", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate98 = new ExDBFieldString<>("kikensrate98", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateD, BizNumber> kikensrate99 = new ExDBFieldString<>("kikensrate99", this, BizNumberType.class);
}
