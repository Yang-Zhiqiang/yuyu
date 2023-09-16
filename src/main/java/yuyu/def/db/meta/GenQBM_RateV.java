package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_RateV;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * Ｖレートマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_RateV extends AbstractExDBTable<BM_RateV> {

    public GenQBM_RateV() {
        this("BM_RateV");
    }

    public GenQBM_RateV(String pAlias) {
        super("BM_RateV", BM_RateV.class, pAlias);
    }

    public String BM_RateV() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_RateV, String> palhokensyuruikigou = new ExDBFieldString<>("palhokensyuruikigou", this);

    public final ExDBFieldString<BM_RateV, String> palhokensyuruikigousdicode = new ExDBFieldString<>("palhokensyuruikigousdicode", this);

    public final ExDBFieldString<BM_RateV, String> palyoteiriritu = new ExDBFieldString<>("palyoteiriritu", this);

    public final ExDBFieldString<BM_RateV, String> palpmencode = new ExDBFieldString<>("palpmencode", this);

    public final ExDBFieldString<BM_RateV, String> palharaikomikaisuu = new ExDBFieldString<>("palharaikomikaisuu", this);

    public final ExDBFieldString<BM_RateV, String> palhhknsei = new ExDBFieldString<>("palhhknsei", this);

    public final ExDBFieldString<BM_RateV, String> palkeiyakujihhknnen = new ExDBFieldString<>("palkeiyakujihhknnen", this);

    public final ExDBFieldString<BM_RateV, String> palsaimankihyouji = new ExDBFieldString<>("palsaimankihyouji", this);

    public final ExDBFieldString<BM_RateV, String> palhokenkikan = new ExDBFieldString<>("palhokenkikan", this);

    public final ExDBFieldString<BM_RateV, String> palpharaikomikikan = new ExDBFieldString<>("palpharaikomikikan", this);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate00 = new ExDBFieldString<>("vrate00", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate01 = new ExDBFieldString<>("vrate01", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate02 = new ExDBFieldString<>("vrate02", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate03 = new ExDBFieldString<>("vrate03", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate04 = new ExDBFieldString<>("vrate04", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate05 = new ExDBFieldString<>("vrate05", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate06 = new ExDBFieldString<>("vrate06", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate07 = new ExDBFieldString<>("vrate07", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate08 = new ExDBFieldString<>("vrate08", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate09 = new ExDBFieldString<>("vrate09", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate10 = new ExDBFieldString<>("vrate10", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate11 = new ExDBFieldString<>("vrate11", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate12 = new ExDBFieldString<>("vrate12", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate13 = new ExDBFieldString<>("vrate13", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate14 = new ExDBFieldString<>("vrate14", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate15 = new ExDBFieldString<>("vrate15", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate16 = new ExDBFieldString<>("vrate16", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate17 = new ExDBFieldString<>("vrate17", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate18 = new ExDBFieldString<>("vrate18", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate19 = new ExDBFieldString<>("vrate19", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate20 = new ExDBFieldString<>("vrate20", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate21 = new ExDBFieldString<>("vrate21", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate22 = new ExDBFieldString<>("vrate22", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate23 = new ExDBFieldString<>("vrate23", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate24 = new ExDBFieldString<>("vrate24", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate25 = new ExDBFieldString<>("vrate25", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate26 = new ExDBFieldString<>("vrate26", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate27 = new ExDBFieldString<>("vrate27", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate28 = new ExDBFieldString<>("vrate28", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate29 = new ExDBFieldString<>("vrate29", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate30 = new ExDBFieldString<>("vrate30", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate31 = new ExDBFieldString<>("vrate31", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate32 = new ExDBFieldString<>("vrate32", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate33 = new ExDBFieldString<>("vrate33", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate34 = new ExDBFieldString<>("vrate34", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate35 = new ExDBFieldString<>("vrate35", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate36 = new ExDBFieldString<>("vrate36", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate37 = new ExDBFieldString<>("vrate37", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate38 = new ExDBFieldString<>("vrate38", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate39 = new ExDBFieldString<>("vrate39", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate40 = new ExDBFieldString<>("vrate40", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate41 = new ExDBFieldString<>("vrate41", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate42 = new ExDBFieldString<>("vrate42", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate43 = new ExDBFieldString<>("vrate43", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate44 = new ExDBFieldString<>("vrate44", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate45 = new ExDBFieldString<>("vrate45", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate46 = new ExDBFieldString<>("vrate46", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate47 = new ExDBFieldString<>("vrate47", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate48 = new ExDBFieldString<>("vrate48", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate49 = new ExDBFieldString<>("vrate49", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate50 = new ExDBFieldString<>("vrate50", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate51 = new ExDBFieldString<>("vrate51", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate52 = new ExDBFieldString<>("vrate52", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate53 = new ExDBFieldString<>("vrate53", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate54 = new ExDBFieldString<>("vrate54", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate55 = new ExDBFieldString<>("vrate55", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate56 = new ExDBFieldString<>("vrate56", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate57 = new ExDBFieldString<>("vrate57", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate58 = new ExDBFieldString<>("vrate58", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate59 = new ExDBFieldString<>("vrate59", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate60 = new ExDBFieldString<>("vrate60", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate61 = new ExDBFieldString<>("vrate61", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate62 = new ExDBFieldString<>("vrate62", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate63 = new ExDBFieldString<>("vrate63", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate64 = new ExDBFieldString<>("vrate64", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate65 = new ExDBFieldString<>("vrate65", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate66 = new ExDBFieldString<>("vrate66", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate67 = new ExDBFieldString<>("vrate67", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate68 = new ExDBFieldString<>("vrate68", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate69 = new ExDBFieldString<>("vrate69", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate70 = new ExDBFieldString<>("vrate70", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate71 = new ExDBFieldString<>("vrate71", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate72 = new ExDBFieldString<>("vrate72", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate73 = new ExDBFieldString<>("vrate73", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate74 = new ExDBFieldString<>("vrate74", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate75 = new ExDBFieldString<>("vrate75", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate76 = new ExDBFieldString<>("vrate76", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate77 = new ExDBFieldString<>("vrate77", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate78 = new ExDBFieldString<>("vrate78", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate79 = new ExDBFieldString<>("vrate79", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate80 = new ExDBFieldString<>("vrate80", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate81 = new ExDBFieldString<>("vrate81", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate82 = new ExDBFieldString<>("vrate82", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate83 = new ExDBFieldString<>("vrate83", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate84 = new ExDBFieldString<>("vrate84", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate85 = new ExDBFieldString<>("vrate85", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate86 = new ExDBFieldString<>("vrate86", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate87 = new ExDBFieldString<>("vrate87", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate88 = new ExDBFieldString<>("vrate88", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate89 = new ExDBFieldString<>("vrate89", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate90 = new ExDBFieldString<>("vrate90", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate91 = new ExDBFieldString<>("vrate91", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate92 = new ExDBFieldString<>("vrate92", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate93 = new ExDBFieldString<>("vrate93", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate94 = new ExDBFieldString<>("vrate94", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate95 = new ExDBFieldString<>("vrate95", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate96 = new ExDBFieldString<>("vrate96", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate97 = new ExDBFieldString<>("vrate97", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate98 = new ExDBFieldString<>("vrate98", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateV, BizNumber> vrate99 = new ExDBFieldString<>("vrate99", this, BizNumberType.class);
}
