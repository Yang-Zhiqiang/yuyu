package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkjyhyouten;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.id.PKJT_SiKykSyouhn;
import yuyu.def.db.meta.GenQJT_SiKykSyouhn;
import yuyu.def.db.meta.QJT_SiKykSyouhn;
import yuyu.def.db.type.UserType_C_6daiLdKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_Htnpkkn;
import yuyu.def.db.type.UserType_C_KataKbn;
import yuyu.def.db.type.UserType_C_KhnkyhkgbairituKbn;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_SyukyhkinkataKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Tkjyhyouten;
import yuyu.def.db.type.UserType_C_Tkjyskgnkkn;
import yuyu.def.db.type.UserType_C_TokkoudosghtnpKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払契約商品テーブル（物理テーブルなし） テーブルのマッピング情報クラスで、 {@link JT_SiKykSyouhn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiKykSyouhn}</td><td colspan="3">支払契約商品テーブル（物理テーブルなし）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SiKykSyouhn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">{@link PKJT_SiKykSyouhn ○}</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKJT_SiKykSyouhn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn kyhgndkatakbn}</td><td>給付限度型区分</td><td align="center">{@link PKJT_SiKykSyouhn ○}</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKJT_SiKykSyouhn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno kyksyouhnrenno}</td><td>契約商品連番</td><td align="center">{@link PKJT_SiKykSyouhn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhnnm syouhnnm}</td><td>商品名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnmgm syouhnnmgm}</td><td>商品名（画面用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnmtyhy syouhnnmtyhy}</td><td>商品名（帳票用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyhkinkatakbn syukyhkinkatakbn}</td><td>手術給付金型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>{@link #getKhnkyhkgbairitukbn khnkyhkgbairitukbn}</td><td>基本給付金額倍率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KhnkyhkgbairituKbn}</td></tr>
 *  <tr><td>{@link #getRokudaildkbn rokudaildkbn}</td><td>６大生活習慣病追加給付型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_6daiLdKbn}</td></tr>
 *  <tr><td>{@link #getPmnjtkkbn pmnjtkkbn}</td><td>保険料免除特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PmnjtkKbn}</td></tr>
 *  <tr><td>{@link #getYuukoukikanfrom yuukoukikanfrom}</td><td>有効期間（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYuukoukikanto yuukoukikanto}</td><td>有効期間（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSknnkaisiymd sknnkaisiymd}</td><td>責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGansknnkaisiymd gansknnkaisiymd}</td><td>がん責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHkgansknnkaisiymd hkgansknnkaisiymd}</td><td>復活がん責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYendthnkymd yendthnkymd}</td><td>円建変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykage kykage}</td><td>加入年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn hknkknsmnkbn}</td><td>保険期間歳満期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkkn hknkkn}</td><td>保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkknmanryouymd hknkknmanryouymd}</td><td>保険期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn hrkkknsmnkbn}</td><td>払込期間歳満期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHrkkkn hrkkkn}</td><td>払込期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkknmnryymd hrkkknmnryymd}</td><td>払込期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHokenryou hokenryou}</td><td>保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKihonsntgkumu kihonsntgkumu}</td><td>基本Ｓ日額有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKihons kihons}</td><td>基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKatakbn katakbn}</td><td>型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getTkjyhyouten tkjyhyouten}</td><td>特条標点</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkjyhyouten}</td></tr>
 *  <tr><td>{@link #getTkjyp tkjyp}</td><td>特条保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTkjyskgnkkn tkjyskgnkkn}</td><td>特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkjyskgnkkn}</td></tr>
 *  <tr><td>{@link #getHtnpbuicd1 htnpbuicd1}</td><td>不担保部位コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtnpkkn1 htnpkkn1}</td><td>不担保期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getHtnpbuicd2 htnpbuicd2}</td><td>不担保部位コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtnpkkn2 htnpkkn2}</td><td>不担保期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getHtnpbuicd3 htnpbuicd3}</td><td>不担保部位コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtnpkkn3 htnpkkn3}</td><td>不担保期間３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getHtnpbuicd4 htnpbuicd4}</td><td>不担保部位コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtnpkkn4 htnpkkn4}</td><td>不担保期間４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getTokkoudosghtnpkbn tokkoudosghtnpkbn}</td><td>特定高度障害不担保区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokkoudosghtnpKbn}</td></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYoteiriritu yoteiriritu}</td><td>予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getKyksjkkktyouseiriritu kyksjkkktyouseiriritu}</td><td>契約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYoteirrthendohosyurrt yoteirrthendohosyurrt}</td><td>予定利率変動時保証利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTumitateriritu tumitateriritu}</td><td>積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTmttknitenymd tmttknitenymd}</td><td>積立金移転日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDai1hknkkn dai1hknkkn}</td><td>第１保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiKykSyouhn
 * @see     PKJT_SiKykSyouhn
 * @see     QJT_SiKykSyouhn
 * @see     GenQJT_SiKykSyouhn
 */
@MappedSuperclass
@Table(name=GenJT_SiKykSyouhn.TABLE_NAME)
@IdClass(value=PKJT_SiKykSyouhn.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_6daiLdKbn", typeClass=UserType_C_6daiLdKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_HknkknsmnKbn", typeClass=UserType_C_HknkknsmnKbn.class),
    @TypeDef(name="UserType_C_HrkkknsmnKbn", typeClass=UserType_C_HrkkknsmnKbn.class),
    @TypeDef(name="UserType_C_Htnpkkn", typeClass=UserType_C_Htnpkkn.class),
    @TypeDef(name="UserType_C_KataKbn", typeClass=UserType_C_KataKbn.class),
    @TypeDef(name="UserType_C_KhnkyhkgbairituKbn", typeClass=UserType_C_KhnkyhkgbairituKbn.class),
    @TypeDef(name="UserType_C_KyhgndkataKbn", typeClass=UserType_C_KyhgndkataKbn.class),
    @TypeDef(name="UserType_C_PmnjtkKbn", typeClass=UserType_C_PmnjtkKbn.class),
    @TypeDef(name="UserType_C_SyukyhkinkataKbn", typeClass=UserType_C_SyukyhkinkataKbn.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_Tkjyhyouten", typeClass=UserType_C_Tkjyhyouten.class),
    @TypeDef(name="UserType_C_Tkjyskgnkkn", typeClass=UserType_C_Tkjyskgnkkn.class),
    @TypeDef(name="UserType_C_TokkoudosghtnpKbn", typeClass=UserType_C_TokkoudosghtnpKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJT_SiKykSyouhn extends AbstractExDBEntity<JT_SiKykSyouhn, PKJT_SiKykSyouhn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SiKykSyouhn";
    public static final String SYONO                    = "syono";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String KYHGNDKATAKBN            = "kyhgndkatakbn";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYKSYOUHNRENNO           = "kyksyouhnrenno";
    public static final String SYOUHNNM                 = "syouhnnm";
    public static final String SYOUHNNMGM               = "syouhnnmgm";
    public static final String SYOUHNNMTYHY             = "syouhnnmtyhy";
    public static final String SYUKYHKINKATAKBN         = "syukyhkinkatakbn";
    public static final String KHNKYHKGBAIRITUKBN       = "khnkyhkgbairitukbn";
    public static final String ROKUDAILDKBN             = "rokudaildkbn";
    public static final String PMNJTKKBN                = "pmnjtkkbn";
    public static final String YUUKOUKIKANFROM          = "yuukoukikanfrom";
    public static final String YUUKOUKIKANTO            = "yuukoukikanto";
    public static final String KYKYMD                   = "kykymd";
    public static final String SKNNKAISIYMD             = "sknnkaisiymd";
    public static final String GANSKNNKAISIYMD          = "gansknnkaisiymd";
    public static final String HKGANSKNNKAISIYMD        = "hkgansknnkaisiymd";
    public static final String YENDTHNKYMD              = "yendthnkymd";
    public static final String KYKAGE                   = "kykage";
    public static final String HKNKKNSMNKBN             = "hknkknsmnkbn";
    public static final String HKNKKN                   = "hknkkn";
    public static final String HKNKKNMANRYOUYMD         = "hknkknmanryouymd";
    public static final String HRKKKNSMNKBN             = "hrkkknsmnkbn";
    public static final String HRKKKN                   = "hrkkkn";
    public static final String HRKKKNMNRYYMD            = "hrkkknmnryymd";
    public static final String HOKENRYOU                = "hokenryou";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String KIHONSNTGKUMU            = "kihonsntgkumu";
    public static final String KIHONS                   = "kihons";
    public static final String KATAKBN                  = "katakbn";
    public static final String TKJYHYOUTEN              = "tkjyhyouten";
    public static final String TKJYP                    = "tkjyp";
    public static final String TKJYSKGNKKN              = "tkjyskgnkkn";
    public static final String HTNPBUICD1               = "htnpbuicd1";
    public static final String HTNPKKN1                 = "htnpkkn1";
    public static final String HTNPBUICD2               = "htnpbuicd2";
    public static final String HTNPKKN2                 = "htnpkkn2";
    public static final String HTNPBUICD3               = "htnpbuicd3";
    public static final String HTNPKKN3                 = "htnpkkn3";
    public static final String HTNPBUICD4               = "htnpbuicd4";
    public static final String HTNPKKN4                 = "htnpkkn4";
    public static final String TOKKOUDOSGHTNPKBN        = "tokkoudosghtnpkbn";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String YOTEIRIRITU              = "yoteiriritu";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String KYKSJKKKTYOUSEIRIRITU    = "kyksjkkktyouseiriritu";
    public static final String YOTEIRRTHENDOHOSYURRT    = "yoteirrthendohosyurrt";
    public static final String TUMITATERIRITU           = "tumitateriritu";
    public static final String TMTTKNITENYMD            = "tmttknitenymd";
    public static final String DAI1HKNKKN               = "dai1hknkkn";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SiKykSyouhn primaryKey;

    public GenJT_SiKykSyouhn() {
        primaryKey = new PKJT_SiKykSyouhn();
    }

    public GenJT_SiKykSyouhn(
        String pSyono,
        C_SyutkKbn pSyutkkbn,
        String pSyouhncd,
        C_KyhgndkataKbn pKyhgndkatakbn,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno
    ) {
        primaryKey = new PKJT_SiKykSyouhn(
            pSyono,
            pSyutkkbn,
            pSyouhncd,
            pKyhgndkatakbn,
            pSyouhnsdno,
            pKyksyouhnrenno
        );
    }

    @Transient
    @Override
    public PKJT_SiKykSyouhn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SiKykSyouhn> getMetaClass() {
        return QJT_SiKykSyouhn.class;
    }

    @Id
    @Column(name=GenJT_SiKykSyouhn.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenJT_SiKykSyouhn.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return getPrimaryKey().getSyutkkbn();
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        getPrimaryKey().setSyutkkbn(pSyutkkbn);
    }

    @Id
    @Column(name=GenJT_SiKykSyouhn.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenJT_SiKykSyouhn.KYHGNDKATAKBN)
    public C_KyhgndkataKbn getKyhgndkatakbn() {
        return getPrimaryKey().getKyhgndkatakbn();
    }

    public void setKyhgndkatakbn(C_KyhgndkataKbn pKyhgndkatakbn) {
        getPrimaryKey().setKyhgndkatakbn(pKyhgndkatakbn);
    }

    @Id
    @Column(name=GenJT_SiKykSyouhn.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    @Id
    @Column(name=GenJT_SiKykSyouhn.KYKSYOUHNRENNO)
    public Integer getKyksyouhnrenno() {
        return getPrimaryKey().getKyksyouhnrenno();
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        getPrimaryKey().setKyksyouhnrenno(pKyksyouhnrenno);
    }

    private String syouhnnm;

    @Column(name=GenJT_SiKykSyouhn.SYOUHNNM)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyouhnnm() {
        return syouhnnm;
    }

    @Trim("right")
    public void setSyouhnnm(String pSyouhnnm) {
        syouhnnm = pSyouhnnm;
    }

    private String syouhnnmgm;

    @Column(name=GenJT_SiKykSyouhn.SYOUHNNMGM)
    public String getSyouhnnmgm() {
        return syouhnnmgm;
    }

    public void setSyouhnnmgm(String pSyouhnnmgm) {
        syouhnnmgm = pSyouhnnmgm;
    }

    private String syouhnnmtyhy;

    @Column(name=GenJT_SiKykSyouhn.SYOUHNNMTYHY)
    public String getSyouhnnmtyhy() {
        return syouhnnmtyhy;
    }

    public void setSyouhnnmtyhy(String pSyouhnnmtyhy) {
        syouhnnmtyhy = pSyouhnnmtyhy;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenJT_SiKykSyouhn.SYUKYHKINKATAKBN)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn() {
        return syukyhkinkatakbn;
    }

    public void setSyukyhkinkatakbn(C_SyukyhkinkataKbn pSyukyhkinkatakbn) {
        syukyhkinkatakbn = pSyukyhkinkatakbn;
    }

    private C_KhnkyhkgbairituKbn khnkyhkgbairitukbn;

    @Type(type="UserType_C_KhnkyhkgbairituKbn")
    @Column(name=GenJT_SiKykSyouhn.KHNKYHKGBAIRITUKBN)
    public C_KhnkyhkgbairituKbn getKhnkyhkgbairitukbn() {
        return khnkyhkgbairitukbn;
    }

    public void setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn) {
        khnkyhkgbairitukbn = pKhnkyhkgbairitukbn;
    }

    private C_6daiLdKbn rokudaildkbn;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenJT_SiKykSyouhn.ROKUDAILDKBN)
    public C_6daiLdKbn getRokudaildkbn() {
        return rokudaildkbn;
    }

    public void setRokudaildkbn(C_6daiLdKbn pRokudaildkbn) {
        rokudaildkbn = pRokudaildkbn;
    }

    private C_PmnjtkKbn pmnjtkkbn;

    @Type(type="UserType_C_PmnjtkKbn")
    @Column(name=GenJT_SiKykSyouhn.PMNJTKKBN)
    public C_PmnjtkKbn getPmnjtkkbn() {
        return pmnjtkkbn;
    }

    public void setPmnjtkkbn(C_PmnjtkKbn pPmnjtkkbn) {
        pmnjtkkbn = pPmnjtkkbn;
    }

    private BizDate yuukoukikanfrom;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykSyouhn.YUUKOUKIKANFROM)
    public BizDate getYuukoukikanfrom() {
        return yuukoukikanfrom;
    }

    public void setYuukoukikanfrom(BizDate pYuukoukikanfrom) {
        yuukoukikanfrom = pYuukoukikanfrom;
    }

    private BizDate yuukoukikanto;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykSyouhn.YUUKOUKIKANTO)
    public BizDate getYuukoukikanto() {
        return yuukoukikanto;
    }

    public void setYuukoukikanto(BizDate pYuukoukikanto) {
        yuukoukikanto = pYuukoukikanto;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykSyouhn.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDate sknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykSyouhn.SKNNKAISIYMD)
    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private BizDate gansknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykSyouhn.GANSKNNKAISIYMD)
    public BizDate getGansknnkaisiymd() {
        return gansknnkaisiymd;
    }

    public void setGansknnkaisiymd(BizDate pGansknnkaisiymd) {
        gansknnkaisiymd = pGansknnkaisiymd;
    }

    private BizDate hkgansknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykSyouhn.HKGANSKNNKAISIYMD)
    @ValidDate
    public BizDate getHkgansknnkaisiymd() {
        return hkgansknnkaisiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHkgansknnkaisiymd(BizDate pHkgansknnkaisiymd) {
        hkgansknnkaisiymd = pHkgansknnkaisiymd;
    }

    private BizDate yendthnkymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykSyouhn.YENDTHNKYMD)
    public BizDate getYendthnkymd() {
        return yendthnkymd;
    }

    public void setYendthnkymd(BizDate pYendthnkymd) {
        yendthnkymd = pYendthnkymd;
    }

    private Integer kykage;

    @Column(name=GenJT_SiKykSyouhn.KYKAGE)
    public Integer getKykage() {
        return kykage;
    }

    public void setKykage(Integer pKykage) {
        kykage = pKykage;
    }

    private C_HknkknsmnKbn hknkknsmnkbn;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenJT_SiKykSyouhn.HKNKKNSMNKBN)
    public C_HknkknsmnKbn getHknkknsmnkbn() {
        return hknkknsmnkbn;
    }

    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {
        hknkknsmnkbn = pHknkknsmnkbn;
    }

    private Integer hknkkn;

    @Column(name=GenJT_SiKykSyouhn.HKNKKN)
    @Range(min="0", max="99")
    public Integer getHknkkn() {
        return hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkkn(Integer pHknkkn) {
        hknkkn = pHknkkn;
    }

    private BizDate hknkknmanryouymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykSyouhn.HKNKKNMANRYOUYMD)
    public BizDate getHknkknmanryouymd() {
        return hknkknmanryouymd;
    }

    public void setHknkknmanryouymd(BizDate pHknkknmanryouymd) {
        hknkknmanryouymd = pHknkknmanryouymd;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenJT_SiKykSyouhn.HRKKKNSMNKBN)
    public C_HrkkknsmnKbn getHrkkknsmnkbn() {
        return hrkkknsmnkbn;
    }

    public void setHrkkknsmnkbn(C_HrkkknsmnKbn pHrkkknsmnkbn) {
        hrkkknsmnkbn = pHrkkknsmnkbn;
    }

    private Integer hrkkkn;

    @Column(name=GenJT_SiKykSyouhn.HRKKKN)
    @Range(min="0", max="99")
    public Integer getHrkkkn() {
        return hrkkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkkkn(Integer pHrkkkn) {
        hrkkkn = pHrkkkn;
    }

    private BizDate hrkkknmnryymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykSyouhn.HRKKKNMNRYYMD)
    public BizDate getHrkkknmnryymd() {
        return hrkkknmnryymd;
    }

    public void setHrkkknmnryymd(BizDate pHrkkknmnryymd) {
        hrkkknmnryymd = pHrkkknmnryymd;
    }

    private BizCurrency hokenryou;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHokenryou() {
        return hokenryou;
    }

    public void setHokenryou(BizCurrency pHokenryou) {
        hokenryou = pHokenryou;
        hokenryouValue = null;
        hokenryouType  = null;
    }

    transient private BigDecimal hokenryouValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HOKENRYOU, nullable=true)
    protected BigDecimal getHokenryouValue() {
        if (hokenryouValue == null && hokenryou != null) {
            if (hokenryou.isOptional()) return null;
            return hokenryou.absolute();
        }
        return hokenryouValue;
    }

    protected void setHokenryouValue(BigDecimal value) {
        hokenryouValue = value;
        hokenryou = Optional.fromNullable(toCurrencyType(hokenryouType))
            .transform(bizCurrencyTransformer(getHokenryouValue()))
            .orNull();
    }

    transient private String hokenryouType = null;

    @Column(name=HOKENRYOU + "$", nullable=true)
    protected String getHokenryouType() {
        if (hokenryouType == null && hokenryou != null) return hokenryou.getType().toString();
        if (hokenryouType == null && getHokenryouValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hokenryou$' should not be NULL."));
        }
        return hokenryouType;
    }

    protected void setHokenryouType(String type) {
        hokenryouType = type;
        hokenryou = Optional.fromNullable(toCurrencyType(hokenryouType))
            .transform(bizCurrencyTransformer(getHokenryouValue()))
            .orNull();
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenJT_SiKykSyouhn.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_UmuKbn kihonsntgkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiKykSyouhn.KIHONSNTGKUMU)
    public C_UmuKbn getKihonsntgkumu() {
        return kihonsntgkumu;
    }

    public void setKihonsntgkumu(C_UmuKbn pKihonsntgkumu) {
        kihonsntgkumu = pKihonsntgkumu;
    }

    private BizCurrency kihons;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    public BizCurrency getKihons() {
        return kihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons(BizCurrency pKihons) {
        kihons = pKihons;
        kihonsValue = null;
        kihonsType  = null;
    }

    transient private BigDecimal kihonsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS, nullable=true)
    protected BigDecimal getKihonsValue() {
        if (kihonsValue == null && kihons != null) {
            if (kihons.isOptional()) return null;
            return kihons.absolute();
        }
        return kihonsValue;
    }

    protected void setKihonsValue(BigDecimal value) {
        kihonsValue = value;
        kihons = Optional.fromNullable(toCurrencyType(kihonsType))
            .transform(bizCurrencyTransformer(getKihonsValue()))
            .orNull();
    }

    transient private String kihonsType = null;

    @Column(name=KIHONS + "$", nullable=true)
    protected String getKihonsType() {
        if (kihonsType == null && kihons != null) return kihons.getType().toString();
        if (kihonsType == null && getKihonsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons$' should not be NULL."));
        }
        return kihonsType;
    }

    protected void setKihonsType(String type) {
        kihonsType = type;
        kihons = Optional.fromNullable(toCurrencyType(kihonsType))
            .transform(bizCurrencyTransformer(getKihonsValue()))
            .orNull();
    }

    private C_KataKbn katakbn;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenJT_SiKykSyouhn.KATAKBN)
    public C_KataKbn getKatakbn() {
        return katakbn;
    }

    public void setKatakbn(C_KataKbn pKatakbn) {
        katakbn = pKatakbn;
    }

    private C_Tkjyhyouten tkjyhyouten;

    @Type(type="UserType_C_Tkjyhyouten")
    @Column(name=GenJT_SiKykSyouhn.TKJYHYOUTEN)
    public C_Tkjyhyouten getTkjyhyouten() {
        return tkjyhyouten;
    }

    public void setTkjyhyouten(C_Tkjyhyouten pTkjyhyouten) {
        tkjyhyouten = pTkjyhyouten;
    }

    private BizCurrency tkjyp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTkjyp() {
        return tkjyp;
    }

    public void setTkjyp(BizCurrency pTkjyp) {
        tkjyp = pTkjyp;
        tkjypValue = null;
        tkjypType  = null;
    }

    transient private BigDecimal tkjypValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TKJYP, nullable=true)
    protected BigDecimal getTkjypValue() {
        if (tkjypValue == null && tkjyp != null) {
            if (tkjyp.isOptional()) return null;
            return tkjyp.absolute();
        }
        return tkjypValue;
    }

    protected void setTkjypValue(BigDecimal value) {
        tkjypValue = value;
        tkjyp = Optional.fromNullable(toCurrencyType(tkjypType))
            .transform(bizCurrencyTransformer(getTkjypValue()))
            .orNull();
    }

    transient private String tkjypType = null;

    @Column(name=TKJYP + "$", nullable=true)
    protected String getTkjypType() {
        if (tkjypType == null && tkjyp != null) return tkjyp.getType().toString();
        if (tkjypType == null && getTkjypValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tkjyp$' should not be NULL."));
        }
        return tkjypType;
    }

    protected void setTkjypType(String type) {
        tkjypType = type;
        tkjyp = Optional.fromNullable(toCurrencyType(tkjypType))
            .transform(bizCurrencyTransformer(getTkjypValue()))
            .orNull();
    }

    private C_Tkjyskgnkkn tkjyskgnkkn;

    @Type(type="UserType_C_Tkjyskgnkkn")
    @Column(name=GenJT_SiKykSyouhn.TKJYSKGNKKN)
    public C_Tkjyskgnkkn getTkjyskgnkkn() {
        return tkjyskgnkkn;
    }

    public void setTkjyskgnkkn(C_Tkjyskgnkkn pTkjyskgnkkn) {
        tkjyskgnkkn = pTkjyskgnkkn;
    }

    private String htnpbuicd1;

    @Column(name=GenJT_SiKykSyouhn.HTNPBUICD1)
    @MaxLength(max=3)
    @AlphaDigit
    public String getHtnpbuicd1() {
        return htnpbuicd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtnpbuicd1(String pHtnpbuicd1) {
        htnpbuicd1 = pHtnpbuicd1;
    }

    private C_Htnpkkn htnpkkn1;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenJT_SiKykSyouhn.HTNPKKN1)
    public C_Htnpkkn getHtnpkkn1() {
        return htnpkkn1;
    }

    public void setHtnpkkn1(C_Htnpkkn pHtnpkkn1) {
        htnpkkn1 = pHtnpkkn1;
    }

    private String htnpbuicd2;

    @Column(name=GenJT_SiKykSyouhn.HTNPBUICD2)
    @MaxLength(max=3)
    @AlphaDigit
    public String getHtnpbuicd2() {
        return htnpbuicd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtnpbuicd2(String pHtnpbuicd2) {
        htnpbuicd2 = pHtnpbuicd2;
    }

    private C_Htnpkkn htnpkkn2;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenJT_SiKykSyouhn.HTNPKKN2)
    public C_Htnpkkn getHtnpkkn2() {
        return htnpkkn2;
    }

    public void setHtnpkkn2(C_Htnpkkn pHtnpkkn2) {
        htnpkkn2 = pHtnpkkn2;
    }

    private String htnpbuicd3;

    @Column(name=GenJT_SiKykSyouhn.HTNPBUICD3)
    @MaxLength(max=3)
    @AlphaDigit
    public String getHtnpbuicd3() {
        return htnpbuicd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtnpbuicd3(String pHtnpbuicd3) {
        htnpbuicd3 = pHtnpbuicd3;
    }

    private C_Htnpkkn htnpkkn3;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenJT_SiKykSyouhn.HTNPKKN3)
    public C_Htnpkkn getHtnpkkn3() {
        return htnpkkn3;
    }

    public void setHtnpkkn3(C_Htnpkkn pHtnpkkn3) {
        htnpkkn3 = pHtnpkkn3;
    }

    private String htnpbuicd4;

    @Column(name=GenJT_SiKykSyouhn.HTNPBUICD4)
    @MaxLength(max=3)
    @AlphaDigit
    public String getHtnpbuicd4() {
        return htnpbuicd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtnpbuicd4(String pHtnpbuicd4) {
        htnpbuicd4 = pHtnpbuicd4;
    }

    private C_Htnpkkn htnpkkn4;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenJT_SiKykSyouhn.HTNPKKN4)
    public C_Htnpkkn getHtnpkkn4() {
        return htnpkkn4;
    }

    public void setHtnpkkn4(C_Htnpkkn pHtnpkkn4) {
        htnpkkn4 = pHtnpkkn4;
    }

    private C_TokkoudosghtnpKbn tokkoudosghtnpkbn;

    @Type(type="UserType_C_TokkoudosghtnpKbn")
    @Column(name=GenJT_SiKykSyouhn.TOKKOUDOSGHTNPKBN)
    public C_TokkoudosghtnpKbn getTokkoudosghtnpkbn() {
        return tokkoudosghtnpkbn;
    }

    public void setTokkoudosghtnpkbn(C_TokkoudosghtnpKbn pTokkoudosghtnpkbn) {
        tokkoudosghtnpkbn = pTokkoudosghtnpkbn;
    }

    private String ryouritusdno;

    @Column(name=GenJT_SiKykSyouhn.RYOURITUSDNO)
    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }

    private BizNumber yoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiKykSyouhn.YOTEIRIRITU)
    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYoteiriritu(BizNumber pYoteiriritu) {
        yoteiriritu = pYoteiriritu;
    }

    private Integer hhknnen;

    @Column(name=GenJT_SiKykSyouhn.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenJT_SiKykSyouhn.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private BizNumber kyksjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiKykSyouhn.KYKSJKKKTYOUSEIRIRITU)
    public BizNumber getKyksjkkktyouseiriritu() {
        return kyksjkkktyouseiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKyksjkkktyouseiriritu(BizNumber pKyksjkkktyouseiriritu) {
        kyksjkkktyouseiriritu = pKyksjkkktyouseiriritu;
    }

    private BizNumber yoteirrthendohosyurrt;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiKykSyouhn.YOTEIRRTHENDOHOSYURRT)
    public BizNumber getYoteirrthendohosyurrt() {
        return yoteirrthendohosyurrt;
    }

    public void setYoteirrthendohosyurrt(BizNumber pYoteirrthendohosyurrt) {
        yoteirrthendohosyurrt = pYoteirrthendohosyurrt;
    }

    private BizNumber tumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiKykSyouhn.TUMITATERIRITU)
    public BizNumber getTumitateriritu() {
        return tumitateriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTumitateriritu(BizNumber pTumitateriritu) {
        tumitateriritu = pTumitateriritu;
    }

    private BizDate tmttknitenymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKykSyouhn.TMTTKNITENYMD)
    public BizDate getTmttknitenymd() {
        return tmttknitenymd;
    }

    public void setTmttknitenymd(BizDate pTmttknitenymd) {
        tmttknitenymd = pTmttknitenymd;
    }

    private Integer dai1hknkkn;

    @Column(name=GenJT_SiKykSyouhn.DAI1HKNKKN)
    @Range(min="0", max="99")
    public Integer getDai1hknkkn() {
        return dai1hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai1hknkkn(Integer pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }

    private String kossyoricd;

    @Column(name=GenJT_SiKykSyouhn.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SiKykSyouhn.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SiKykSyouhn.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SiKykSyouhn.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}