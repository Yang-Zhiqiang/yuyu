package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_CreditTrkjkKbn;
import yuyu.def.classification.C_CreditYuukoukakKbn;
import yuyu.def.classification.C_FatcakakkekkaKbn;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_ImusateikaniyhKbn;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Knkysatei1jiyhKbn;
import yuyu.def.classification.C_Knkysatei2jiyhKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_KoukankykKbn;
import yuyu.def.classification.C_KouseiinkykKbn;
import yuyu.def.classification.C_KsktkanKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_LincdatasousinKbn;
import yuyu.def.classification.C_LincgthtkekKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_LinckknnjkKbn;
import yuyu.def.classification.C_Lincsousinflg;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MosUktkErrKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyssrhKbn;
import yuyu.def.classification.C_TkhjnKbn;
import yuyu.def.classification.C_TyhysakuseiKbn;
import yuyu.def.classification.C_UktkakKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UriagesousinKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_AeoiKekkaKbn;
import yuyu.def.db.type.UserType_C_CreditTrkjkKbn;
import yuyu.def.db.type.UserType_C_CreditYuukoukakKbn;
import yuyu.def.db.type.UserType_C_FatcakakkekkaKbn;
import yuyu.def.db.type.UserType_C_HubikaisyoujoutaiKbn;
import yuyu.def.db.type.UserType_C_ImusateijyouKbn;
import yuyu.def.db.type.UserType_C_ImusateikaniyhKbn;
import yuyu.def.db.type.UserType_C_JimusrhKbn;
import yuyu.def.db.type.UserType_C_KetteiKbn;
import yuyu.def.db.type.UserType_C_Knkysatei1jiyhKbn;
import yuyu.def.db.type.UserType_C_Knkysatei2jiyhKbn;
import yuyu.def.db.type.UserType_C_KnkysateijyouKbn;
import yuyu.def.db.type.UserType_C_KoukankykKbn;
import yuyu.def.db.type.UserType_C_KouseiinkykKbn;
import yuyu.def.db.type.UserType_C_KsktkanKbn;
import yuyu.def.db.type.UserType_C_KykkakjkKbn;
import yuyu.def.db.type.UserType_C_LincdatasousinKbn;
import yuyu.def.db.type.UserType_C_LincgthtkekKbn;
import yuyu.def.db.type.UserType_C_LincjkKbn;
import yuyu.def.db.type.UserType_C_LinckknnjkKbn;
import yuyu.def.db.type.UserType_C_Lincsousinflg;
import yuyu.def.db.type.UserType_C_Mfrenflg;
import yuyu.def.db.type.UserType_C_MosUketukeKbn;
import yuyu.def.db.type.UserType_C_MosUktkErrKbn;
import yuyu.def.db.type.UserType_C_MostenkenjyouKbn;
import yuyu.def.db.type.UserType_C_MostenkenyhKbn;
import yuyu.def.db.type.UserType_C_NyuukinjyoutaiKbn;
import yuyu.def.db.type.UserType_C_SateijtKbn;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;
import yuyu.def.db.type.UserType_C_SyssrhKbn;
import yuyu.def.db.type.UserType_C_TkhjnKbn;
import yuyu.def.db.type.UserType_C_TyhysakuseiKbn;
import yuyu.def.db.type.UserType_C_UktkakKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_UriagesousinKbn;
import yuyu.def.db.type.UserType_C_VrfjkKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * 処理コントロールテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SyoriCTL extends AbstractExDBTable<HT_SyoriCTL> {

    public GenQHT_SyoriCTL() {
        this("HT_SyoriCTL");
    }

    public GenQHT_SyoriCTL(String pAlias) {
        super("HT_SyoriCTL", HT_SyoriCTL.class, pAlias);
    }

    public String HT_SyoriCTL() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SyoriCTL, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SyoriCTL, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<HT_SyoriCTL, String> kaisyacd = new ExDBFieldString<>("kaisyacd", this);

    public final ExDBFieldString<HT_SyoriCTL, C_MosUketukeKbn> mosuketukekbn = new ExDBFieldString<>("mosuketukekbn", this, UserType_C_MosUketukeKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_MosUktkErrKbn> mosuktkerrkbn = new ExDBFieldString<>("mosuktkerrkbn", this, UserType_C_MosUktkErrKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_SkeijimuKbn> skeijimukbn = new ExDBFieldString<>("skeijimukbn", this, UserType_C_SkeijimuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> mosnrkumu = new ExDBFieldString<>("mosnrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_VrfjkKbn> mosnrkvrfjkkbn = new ExDBFieldString<>("mosnrkvrfjkkbn", this, UserType_C_VrfjkKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, BizDate> mosnrkymd = new ExDBFieldString<>("mosnrkymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> kznrkumu = new ExDBFieldString<>("kznrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> kznrkhbumu = new ExDBFieldString<>("kznrkhbumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_VrfjkKbn> kznrkvrfjkkbn = new ExDBFieldString<>("kznrkvrfjkkbn", this, UserType_C_VrfjkKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> dntnrkumu = new ExDBFieldString<>("dntnrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> sdnnrkumu = new ExDBFieldString<>("sdnnrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> kktnrkumu = new ExDBFieldString<>("kktnrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> kktnrkhbumu = new ExDBFieldString<>("kktnrkhbumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_VrfjkKbn> kktnrkvrfjkkbn = new ExDBFieldString<>("kktnrkvrfjkkbn", this, UserType_C_VrfjkKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, BizDate> kktymd = new ExDBFieldString<>("kktymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> hjynrkumu = new ExDBFieldString<>("hjynrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> hjynrkhbumu = new ExDBFieldString<>("hjynrkhbumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> nyknnrkumu = new ExDBFieldString<>("nyknnrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_NyuukinjyoutaiKbn> nyuukinjoutaikbn = new ExDBFieldString<>("nyuukinjoutaikbn", this, UserType_C_NyuukinjyoutaiKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SyoriCTL, BizDate> nyknkwsratekijyunymd = new ExDBFieldString<>("nyknkwsratekijyunymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SyoriCTL, BizNumber> nyknkwsrate = new ExDBFieldString<>("nyknkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<HT_SyoriCTL, BizDate> authorikakymd = new ExDBFieldString<>("authorikakymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UriagesousinKbn> uriagesousinkbn = new ExDBFieldString<>("uriagesousinkbn", this, UserType_C_UriagesousinKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_CreditTrkjkKbn> credittrkjkkbn = new ExDBFieldString<>("credittrkjkkbn", this, UserType_C_CreditTrkjkKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_CreditYuukoukakKbn> credityuukoukakkbn = new ExDBFieldString<>("credityuukoukakkbn", this, UserType_C_CreditYuukoukakKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_MostenkenyhKbn> mostenken1jiyhkbn = new ExDBFieldString<>("mostenken1jiyhkbn", this, UserType_C_MostenkenyhKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_MostenkenyhKbn> mostenken2jiyhkbn = new ExDBFieldString<>("mostenken2jiyhkbn", this, UserType_C_MostenkenyhKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_MostenkenyhKbn> mostenken3jiyhkbn = new ExDBFieldString<>("mostenken3jiyhkbn", this, UserType_C_MostenkenyhKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> mostenkenrrkumu = new ExDBFieldString<>("mostenkenrrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_MostenkenjyouKbn> mostenkenjoukbn = new ExDBFieldString<>("mostenkenjoukbn", this, UserType_C_MostenkenjyouKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_Knkysatei1jiyhKbn> knkysatei1jiyhkbn = new ExDBFieldString<>("knkysatei1jiyhkbn", this, UserType_C_Knkysatei1jiyhKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_Knkysatei2jiyhKbn> knkysatei2jiyhkbn = new ExDBFieldString<>("knkysatei2jiyhkbn", this, UserType_C_Knkysatei2jiyhKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> knkysateirrkumu = new ExDBFieldString<>("knkysateirrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_KnkysateijyouKbn> knkysateijyoukbn = new ExDBFieldString<>("knkysateijyoukbn", this, UserType_C_KnkysateijyouKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_ImusateikaniyhKbn> imusateikaniyhkbn = new ExDBFieldString<>("imusateikaniyhkbn", this, UserType_C_ImusateikaniyhKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> imusateirrkumu = new ExDBFieldString<>("imusateirrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_ImusateijyouKbn> imusateijyoukbn = new ExDBFieldString<>("imusateijyoukbn", this, UserType_C_ImusateijyouKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> mihassinhubiumu = new ExDBFieldString<>("mihassinhubiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_HubikaisyoujoutaiKbn> hubikaisyoujoutaikbn = new ExDBFieldString<>("hubikaisyoujoutaikbn", this, UserType_C_HubikaisyoujoutaiKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> kthhbkbn = new ExDBFieldString<>("kthhbkbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> srhhbkbn = new ExDBFieldString<>("srhhbkbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> khnhbkbn = new ExDBFieldString<>("khnhbkbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_KykkakjkKbn> kykkakjkkbn = new ExDBFieldString<>("kykkakjkkbn", this, UserType_C_KykkakjkKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_KetteiKbn> ketteikbn = new ExDBFieldString<>("ketteikbn", this, UserType_C_KetteiKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_SateijtKbn> sateijtkbn = new ExDBFieldString<>("sateijtkbn", this, UserType_C_SateijtKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, BizDate> sateizumiymd = new ExDBFieldString<>("sateizumiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> doujimosumu = new ExDBFieldString<>("doujimosumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> paldoujimosumu = new ExDBFieldString<>("paldoujimosumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> raydoujimosumu = new ExDBFieldString<>("raydoujimosumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_LincgthtkekKbn> lincgthtkekkbn = new ExDBFieldString<>("lincgthtkekkbn", this, UserType_C_LincgthtkekKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_LincjkKbn> lincjkkbn = new ExDBFieldString<>("lincjkkbn", this, UserType_C_LincjkKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_Lincsousinflg> lincsousinflg = new ExDBFieldString<>("lincsousinflg", this, UserType_C_Lincsousinflg.class);

    public final ExDBFieldString<HT_SyoriCTL, C_LinckknnjkKbn> linckknnjkkbn = new ExDBFieldString<>("linckknnjkkbn", this, UserType_C_LinckknnjkKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_LincdatasousinKbn> lincdatasousinkbn = new ExDBFieldString<>("lincdatasousinkbn", this, UserType_C_LincdatasousinKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UktkakKbn> uktkakkbn = new ExDBFieldString<>("uktkakkbn", this, UserType_C_UktkakKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_TkhjnKbn> tkhjnkbn = new ExDBFieldString<>("tkhjnkbn", this, UserType_C_TkhjnKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_YouhiKbn> tktkhjnkakuninyouhikbn = new ExDBFieldString<>("tktkhjnkakuninyouhikbn", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_KouseiinkykKbn> kouseiinkykkbn = new ExDBFieldString<>("kouseiinkykkbn", this, UserType_C_KouseiinkykKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_KoukankykKbn> koukankykkbn = new ExDBFieldString<>("koukankykkbn", this, UserType_C_KoukankykKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_FatcakakkekkaKbn> fatcakakkekkakbn = new ExDBFieldString<>("fatcakakkekkakbn", this, UserType_C_FatcakakkekkaKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_AeoiKekkaKbn> aeoikekkakbn = new ExDBFieldString<>("aeoikekkakbn", this, UserType_C_AeoiKekkaKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> tkhsyouryakuumukbn = new ExDBFieldString<>("tkhsyouryakuumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_KsktkanKbn> kykksktkankbn = new ExDBFieldString<>("kykksktkankbn", this, UserType_C_KsktkanKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_KsktkanKbn> hhknksktkankbn = new ExDBFieldString<>("hhknksktkankbn", this, UserType_C_KsktkanKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_SeirituKbn> seiritukbn = new ExDBFieldString<>("seiritukbn", this, UserType_C_SeirituKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, BizDate> srsyoriymd = new ExDBFieldString<>("srsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> minyknkurikosiumu = new ExDBFieldString<>("minyknkurikosiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> kettienkurikosiumu = new ExDBFieldString<>("kettienkurikosiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> srhkurikosiumu = new ExDBFieldString<>("srhkurikosiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, String> daimosno = new ExDBFieldString<>("daimosno", this);

    public final ExDBFieldString<HT_SyoriCTL, C_Mfrenflg> mfrenflg = new ExDBFieldString<>("mfrenflg", this, UserType_C_Mfrenflg.class);

    public final ExDBFieldString<HT_SyoriCTL, BizDate> mfrenymd = new ExDBFieldString<>("mfrenymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SyoriCTL, C_JimusrhKbn> jimusrhkbn = new ExDBFieldString<>("jimusrhkbn", this, UserType_C_JimusrhKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_SyssrhKbn> syssrhkbn = new ExDBFieldString<>("syssrhkbn", this, UserType_C_SyssrhKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_TyhysakuseiKbn> annaisakuseikbn = new ExDBFieldString<>("annaisakuseikbn", this, UserType_C_TyhysakuseiKbn.class);

    public final ExDBFieldNumber<HT_SyoriCTL, Integer> annaikaisuu = new ExDBFieldNumber<>("annaikaisuu", this);

    public final ExDBFieldString<HT_SyoriCTL, C_UmuKbn> tkbtkktumu = new ExDBFieldString<>("tkbtkktumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, C_YouhiKbn> kansyoutuutiyhkbn = new ExDBFieldString<>("kansyoutuutiyhkbn", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<HT_SyoriCTL, String> lastkossyoricd = new ExDBFieldString<>("lastkossyoricd", this);

    public final ExDBFieldString<HT_SyoriCTL, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SyoriCTL, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<HT_SyoriCTL, BizDate> yoteirirituhenkourenrakuymd = new ExDBFieldString<>("yoteirirituhenkourenrakuymd", this, BizDateType.class);
}
