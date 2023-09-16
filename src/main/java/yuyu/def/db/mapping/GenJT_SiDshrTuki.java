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
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.id.PKJT_SiDshrTuki;
import yuyu.def.db.meta.GenQJT_SiDshrTuki;
import yuyu.def.db.meta.QJT_SiDshrTuki;
import yuyu.def.db.type.UserType_C_HaitoukinsksKbn;
import yuyu.def.db.type.UserType_C_HaitoumeisaiKbn;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_NaiteiKakuteiKbn;
import yuyu.def.db.type.UserType_C_SyoriKbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_TumitateDSakuseiKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険金給付金Ｄ支払統計テーブル テーブルのマッピング情報クラスで、 {@link JT_SiDshrTuki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiDshrTuki}</td><td colspan="3">保険金給付金Ｄ支払統計テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDshrtoukeisikibetukey dshrtoukeisikibetukey}</td><td>Ｄ支払統計識別キー</td><td align="center">{@link PKJT_SiDshrTuki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyorikbn syorikbn}</td><td>処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoriKbn}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKykjyoutai kykjyoutai}</td><td>契約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kykjyoutai}</td></tr>
 *  <tr><td>{@link #getSyoumetujiyuu syoumetujiyuu}</td><td>消滅事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syoumetujiyuu}</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYendthnkymd yendthnkymd}</td><td>円建変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKihons kihons}</td><td>基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYoteiriritu yoteiriritu}</td><td>予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSiharaid siharaid}</td><td>支払Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getCalckijyunymd calckijyunymd}</td><td>計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoriymd2 syoriymd2}</td><td>処理年月日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKinoubetukijyunymd kinoubetukijyunymd}</td><td>機能別基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGengkwari gengkwari}</td><td>減額割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getItibushrgk itibushrgk}</td><td>一部支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHaitoushrkin haitoushrkin}</td><td>配当支払金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKariwariatedruigk kariwariatedruigk}</td><td>仮割当Ｄ累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKariwariatedgngkkngk kariwariatedgngkkngk}</td><td>仮割当Ｄ減額金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKariwariatedshrgk kariwariatedshrgk}</td><td>仮割当Ｄ支払額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDkeisanhaitoukin dkeisanhaitoukin}</td><td>配当金計算配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDkeisannaiteikakuteikbn dkeisannaiteikakuteikbn}</td><td>配当金計算内定確定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NaiteiKakuteiKbn}</td></tr>
 *  <tr><td>{@link #getHaitounendo haitounendo}</td><td>配当年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getHaitoushrkingk haitoushrkingk}</td><td>配当支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKariwariatedganrikindshr kariwariatedganrikindshr}</td><td>仮割当Ｄ元利金（配当支払金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTumitated tumitated}</td><td>積立Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTumitatedmodosimae tumitatedmodosimae}</td><td>積立Ｄ（割戻し前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTumitatedmodosigo tumitatedmodosigo}</td><td>積立Ｄ（割戻し後）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTkbthaitou tkbthaitou}</td><td>特別配当</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHaitounendo2 haitounendo2}</td><td>配当年度２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getHaitoukinskskbn haitoukinskskbn}</td><td>配当金作成区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitoukinsksKbn}</td></tr>
 *  <tr><td>{@link #getHaitoumeisaikbn haitoumeisaikbn}</td><td>配当明細区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitoumeisaiKbn}</td></tr>
 *  <tr><td>{@link #getFstkariwariatednendo fstkariwariatednendo}</td><td>初回仮割当Ｄ年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getTounendod tounendod}</td><td>当年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNaiteikakuteikbn naiteikakuteikbn}</td><td>内定確定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NaiteiKakuteiKbn}</td></tr>
 *  <tr><td>{@link #getKariwariatedshrymd kariwariatedshrymd}</td><td>仮割当Ｄ支払年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKariwariatedruigk2 kariwariatedruigk2}</td><td>仮割当Ｄ累計額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKariwariatedgngkkngk2 kariwariatedgngkkngk2}</td><td>仮割当Ｄ減額金額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKariwariatedshrgk2 kariwariatedshrgk2}</td><td>仮割当Ｄ支払額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTumitatedtumitateymd tumitatedtumitateymd}</td><td>積立Ｄ積立年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTumitatedskskbn tumitatedskskbn}</td><td>積立Ｄ作成区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TumitateDSakuseiKbn}</td></tr>
 *  <tr><td>{@link #getTumitated2 tumitated2}</td><td>積立Ｄ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTumitatedshrkrkymd tumitatedshrkrkymd}</td><td>積立Ｄ支払効力日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNaiteikakuteikbn2 naiteikakuteikbn2}</td><td>内定確定区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NaiteiKakuteiKbn}</td></tr>
 *  <tr><td>{@link #getHaitouganrikincalckari haitouganrikincalckari}</td><td>配当元利金計算（仮割当Ｄ元利金）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKariwariatedriritu1 kariwariatedriritu1}</td><td>仮割当Ｄ利率１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKariwariatedriritu2 kariwariatedriritu2}</td><td>仮割当Ｄ利率２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHaitouganrikincalctumi haitouganrikincalctumi}</td><td>配当元利金計算（積立Ｄ元利金）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTumitatedriritu1 tumitatedriritu1}</td><td>積立Ｄ利率１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTumitatedriritu2 tumitatedriritu2}</td><td>積立Ｄ利率２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiDshrTuki
 * @see     PKJT_SiDshrTuki
 * @see     QJT_SiDshrTuki
 * @see     GenQJT_SiDshrTuki
 */
@MappedSuperclass
@Table(name=GenJT_SiDshrTuki.TABLE_NAME)
@IdClass(value=PKJT_SiDshrTuki.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizDateYType", typeClass=BizDateYType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HaitoukinsksKbn", typeClass=UserType_C_HaitoukinsksKbn.class),
    @TypeDef(name="UserType_C_HaitoumeisaiKbn", typeClass=UserType_C_HaitoumeisaiKbn.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_Kykjyoutai", typeClass=UserType_C_Kykjyoutai.class),
    @TypeDef(name="UserType_C_NaiteiKakuteiKbn", typeClass=UserType_C_NaiteiKakuteiKbn.class),
    @TypeDef(name="UserType_C_SyoriKbn", typeClass=UserType_C_SyoriKbn.class),
    @TypeDef(name="UserType_C_Syoumetujiyuu", typeClass=UserType_C_Syoumetujiyuu.class),
    @TypeDef(name="UserType_C_TumitateDSakuseiKbn", typeClass=UserType_C_TumitateDSakuseiKbn.class)
})
public abstract class GenJT_SiDshrTuki extends AbstractExDBEntity<JT_SiDshrTuki, PKJT_SiDshrTuki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SiDshrTuki";
    public static final String DSHRTOUKEISIKIBETUKEY    = "dshrtoukeisikibetukey";
    public static final String RENNO                    = "renno";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYORIKBN                 = "syorikbn";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYKJYOUTAI               = "kykjyoutai";
    public static final String SYOUMETUJIYUU            = "syoumetujiyuu";
    public static final String KYKYMD                   = "kykymd";
    public static final String YENDTHNKYMD              = "yendthnkymd";
    public static final String KIHONS                   = "kihons";
    public static final String YOTEIRIRITU              = "yoteiriritu";
    public static final String DENYMD                   = "denymd";
    public static final String SIHARAID                 = "siharaid";
    public static final String CALCKIJYUNYMD            = "calckijyunymd";
    public static final String SYORIYMD2                = "syoriymd2";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String KINOUBETUKIJYUNYMD       = "kinoubetukijyunymd";
    public static final String GENGKWARI                = "gengkwari";
    public static final String ITIBUSHRGK               = "itibushrgk";
    public static final String HAITOUSHRKIN             = "haitoushrkin";
    public static final String KARIWARIATEDRUIGK        = "kariwariatedruigk";
    public static final String KARIWARIATEDGNGKKNGK     = "kariwariatedgngkkngk";
    public static final String KARIWARIATEDSHRGK        = "kariwariatedshrgk";
    public static final String DKEISANHAITOUKIN         = "dkeisanhaitoukin";
    public static final String DKEISANNAITEIKAKUTEIKBN  = "dkeisannaiteikakuteikbn";
    public static final String HAITOUNENDO              = "haitounendo";
    public static final String HAITOUSHRKINGK           = "haitoushrkingk";
    public static final String KARIWARIATEDGANRIKINDSHR = "kariwariatedganrikindshr";
    public static final String TUMITATED                = "tumitated";
    public static final String TUMITATEDMODOSIMAE       = "tumitatedmodosimae";
    public static final String TUMITATEDMODOSIGO        = "tumitatedmodosigo";
    public static final String TKBTHAITOU               = "tkbthaitou";
    public static final String HAITOUNENDO2             = "haitounendo2";
    public static final String HAITOUKINSKSKBN          = "haitoukinskskbn";
    public static final String HAITOUMEISAIKBN          = "haitoumeisaikbn";
    public static final String FSTKARIWARIATEDNENDO     = "fstkariwariatednendo";
    public static final String TOUNENDOD                = "tounendod";
    public static final String NAITEIKAKUTEIKBN         = "naiteikakuteikbn";
    public static final String KARIWARIATEDSHRYMD       = "kariwariatedshrymd";
    public static final String KARIWARIATEDRUIGK2       = "kariwariatedruigk2";
    public static final String KARIWARIATEDGNGKKNGK2    = "kariwariatedgngkkngk2";
    public static final String KARIWARIATEDSHRGK2       = "kariwariatedshrgk2";
    public static final String TUMITATEDTUMITATEYMD     = "tumitatedtumitateymd";
    public static final String TUMITATEDSKSKBN          = "tumitatedskskbn";
    public static final String TUMITATED2               = "tumitated2";
    public static final String TUMITATEDSHRKRKYMD       = "tumitatedshrkrkymd";
    public static final String NAITEIKAKUTEIKBN2        = "naiteikakuteikbn2";
    public static final String HAITOUGANRIKINCALCKARI   = "haitouganrikincalckari";
    public static final String KARIWARIATEDRIRITU1      = "kariwariatedriritu1";
    public static final String KARIWARIATEDRIRITU2      = "kariwariatedriritu2";
    public static final String HAITOUGANRIKINCALCTUMI   = "haitouganrikincalctumi";
    public static final String TUMITATEDRIRITU1         = "tumitatedriritu1";
    public static final String TUMITATEDRIRITU2         = "tumitatedriritu2";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SiDshrTuki primaryKey;

    public GenJT_SiDshrTuki() {
        primaryKey = new PKJT_SiDshrTuki();
    }

    public GenJT_SiDshrTuki(String pDshrtoukeisikibetukey) {
        primaryKey = new PKJT_SiDshrTuki(pDshrtoukeisikibetukey);
    }

    @Transient
    @Override
    public PKJT_SiDshrTuki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SiDshrTuki> getMetaClass() {
        return QJT_SiDshrTuki.class;
    }

    @Id
    @Column(name=GenJT_SiDshrTuki.DSHRTOUKEISIKIBETUKEY)
    public String getDshrtoukeisikibetukey() {
        return getPrimaryKey().getDshrtoukeisikibetukey();
    }

    public void setDshrtoukeisikibetukey(String pDshrtoukeisikibetukey) {
        getPrimaryKey().setDshrtoukeisikibetukey(pDshrtoukeisikibetukey);
    }

    private Integer renno;

    @Column(name=GenJT_SiDshrTuki.RENNO)
    public Integer getRenno() {
        return renno;
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

    private String skno;

    @Column(name=GenJT_SiDshrTuki.SKNO)
    public String getSkno() {
        return skno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    private String syono;

    @Column(name=GenJT_SiDshrTuki.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private Integer seikyuurirekino;

    @Column(name=GenJT_SiDshrTuki.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return seikyuurirekino;
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        seikyuurirekino = pSeikyuurirekino;
    }

    private String henkousikibetukey;

    @Column(name=GenJT_SiDshrTuki.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDshrTuki.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private C_SyoriKbn syorikbn;

    @Type(type="UserType_C_SyoriKbn")
    @Column(name=GenJT_SiDshrTuki.SYORIKBN)
    public C_SyoriKbn getSyorikbn() {
        return syorikbn;
    }

    public void setSyorikbn(C_SyoriKbn pSyorikbn) {
        syorikbn = pSyorikbn;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenJT_SiDshrTuki.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private String syouhncd;

    @Column(name=GenJT_SiDshrTuki.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return syouhncd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    private Integer syouhnsdno;

    @Column(name=GenJT_SiDshrTuki.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private C_Kykjyoutai kykjyoutai;

    @Type(type="UserType_C_Kykjyoutai")
    @Column(name=GenJT_SiDshrTuki.KYKJYOUTAI)
    public C_Kykjyoutai getKykjyoutai() {
        return kykjyoutai;
    }

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
        kykjyoutai = pKykjyoutai;
    }

    private C_Syoumetujiyuu syoumetujiyuu;

    @Type(type="UserType_C_Syoumetujiyuu")
    @Column(name=GenJT_SiDshrTuki.SYOUMETUJIYUU)
    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return syoumetujiyuu;
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        syoumetujiyuu = pSyoumetujiyuu;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDshrTuki.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDate yendthnkymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDshrTuki.YENDTHNKYMD)
    public BizDate getYendthnkymd() {
        return yendthnkymd;
    }

    public void setYendthnkymd(BizDate pYendthnkymd) {
        yendthnkymd = pYendthnkymd;
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

    private BizNumber yoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiDshrTuki.YOTEIRIRITU)
    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYoteiriritu(BizNumber pYoteiriritu) {
        yoteiriritu = pYoteiriritu;
    }

    private BizDate denymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDshrTuki.DENYMD)
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    private BizCurrency siharaid;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSiharaid() {
        return siharaid;
    }

    public void setSiharaid(BizCurrency pSiharaid) {
        siharaid = pSiharaid;
        siharaidValue = null;
        siharaidType  = null;
    }

    transient private BigDecimal siharaidValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SIHARAID, nullable=true)
    protected BigDecimal getSiharaidValue() {
        if (siharaidValue == null && siharaid != null) {
            if (siharaid.isOptional()) return null;
            return siharaid.absolute();
        }
        return siharaidValue;
    }

    protected void setSiharaidValue(BigDecimal value) {
        siharaidValue = value;
        siharaid = Optional.fromNullable(toCurrencyType(siharaidType))
            .transform(bizCurrencyTransformer(getSiharaidValue()))
            .orNull();
    }

    transient private String siharaidType = null;

    @Column(name=SIHARAID + "$", nullable=true)
    protected String getSiharaidType() {
        if (siharaidType == null && siharaid != null) return siharaid.getType().toString();
        if (siharaidType == null && getSiharaidValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'siharaid$' should not be NULL."));
        }
        return siharaidType;
    }

    protected void setSiharaidType(String type) {
        siharaidType = type;
        siharaid = Optional.fromNullable(toCurrencyType(siharaidType))
            .transform(bizCurrencyTransformer(getSiharaidValue()))
            .orNull();
    }

    private BizDate calckijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDshrTuki.CALCKIJYUNYMD)
    @ValidDate
    public BizDate getCalckijyunymd() {
        return calckijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCalckijyunymd(BizDate pCalckijyunymd) {
        calckijyunymd = pCalckijyunymd;
    }

    private BizDate syoriymd2;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDshrTuki.SYORIYMD2)
    public BizDate getSyoriymd2() {
        return syoriymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriymd2(BizDate pSyoriymd2) {
        syoriymd2 = pSyoriymd2;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenJT_SiDshrTuki.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private BizDate kinoubetukijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDshrTuki.KINOUBETUKIJYUNYMD)
    public BizDate getKinoubetukijyunymd() {
        return kinoubetukijyunymd;
    }

    public void setKinoubetukijyunymd(BizDate pKinoubetukijyunymd) {
        kinoubetukijyunymd = pKinoubetukijyunymd;
    }

    private BizNumber gengkwari;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiDshrTuki.GENGKWARI)
    public BizNumber getGengkwari() {
        return gengkwari;
    }

    public void setGengkwari(BizNumber pGengkwari) {
        gengkwari = pGengkwari;
    }

    private BizCurrency itibushrgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getItibushrgk() {
        return itibushrgk;
    }

    public void setItibushrgk(BizCurrency pItibushrgk) {
        itibushrgk = pItibushrgk;
        itibushrgkValue = null;
        itibushrgkType  = null;
    }

    transient private BigDecimal itibushrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ITIBUSHRGK, nullable=true)
    protected BigDecimal getItibushrgkValue() {
        if (itibushrgkValue == null && itibushrgk != null) {
            if (itibushrgk.isOptional()) return null;
            return itibushrgk.absolute();
        }
        return itibushrgkValue;
    }

    protected void setItibushrgkValue(BigDecimal value) {
        itibushrgkValue = value;
        itibushrgk = Optional.fromNullable(toCurrencyType(itibushrgkType))
            .transform(bizCurrencyTransformer(getItibushrgkValue()))
            .orNull();
    }

    transient private String itibushrgkType = null;

    @Column(name=ITIBUSHRGK + "$", nullable=true)
    protected String getItibushrgkType() {
        if (itibushrgkType == null && itibushrgk != null) return itibushrgk.getType().toString();
        if (itibushrgkType == null && getItibushrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'itibushrgk$' should not be NULL."));
        }
        return itibushrgkType;
    }

    protected void setItibushrgkType(String type) {
        itibushrgkType = type;
        itibushrgk = Optional.fromNullable(toCurrencyType(itibushrgkType))
            .transform(bizCurrencyTransformer(getItibushrgkValue()))
            .orNull();
    }

    private BizCurrency haitoushrkin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHaitoushrkin() {
        return haitoushrkin;
    }

    public void setHaitoushrkin(BizCurrency pHaitoushrkin) {
        haitoushrkin = pHaitoushrkin;
        haitoushrkinValue = null;
        haitoushrkinType  = null;
    }

    transient private BigDecimal haitoushrkinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HAITOUSHRKIN, nullable=true)
    protected BigDecimal getHaitoushrkinValue() {
        if (haitoushrkinValue == null && haitoushrkin != null) {
            if (haitoushrkin.isOptional()) return null;
            return haitoushrkin.absolute();
        }
        return haitoushrkinValue;
    }

    protected void setHaitoushrkinValue(BigDecimal value) {
        haitoushrkinValue = value;
        haitoushrkin = Optional.fromNullable(toCurrencyType(haitoushrkinType))
            .transform(bizCurrencyTransformer(getHaitoushrkinValue()))
            .orNull();
    }

    transient private String haitoushrkinType = null;

    @Column(name=HAITOUSHRKIN + "$", nullable=true)
    protected String getHaitoushrkinType() {
        if (haitoushrkinType == null && haitoushrkin != null) return haitoushrkin.getType().toString();
        if (haitoushrkinType == null && getHaitoushrkinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'haitoushrkin$' should not be NULL."));
        }
        return haitoushrkinType;
    }

    protected void setHaitoushrkinType(String type) {
        haitoushrkinType = type;
        haitoushrkin = Optional.fromNullable(toCurrencyType(haitoushrkinType))
            .transform(bizCurrencyTransformer(getHaitoushrkinValue()))
            .orNull();
    }

    private BizCurrency kariwariatedruigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKariwariatedruigk() {
        return kariwariatedruigk;
    }

    public void setKariwariatedruigk(BizCurrency pKariwariatedruigk) {
        kariwariatedruigk = pKariwariatedruigk;
        kariwariatedruigkValue = null;
        kariwariatedruigkType  = null;
    }

    transient private BigDecimal kariwariatedruigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIWARIATEDRUIGK, nullable=true)
    protected BigDecimal getKariwariatedruigkValue() {
        if (kariwariatedruigkValue == null && kariwariatedruigk != null) {
            if (kariwariatedruigk.isOptional()) return null;
            return kariwariatedruigk.absolute();
        }
        return kariwariatedruigkValue;
    }

    protected void setKariwariatedruigkValue(BigDecimal value) {
        kariwariatedruigkValue = value;
        kariwariatedruigk = Optional.fromNullable(toCurrencyType(kariwariatedruigkType))
            .transform(bizCurrencyTransformer(getKariwariatedruigkValue()))
            .orNull();
    }

    transient private String kariwariatedruigkType = null;

    @Column(name=KARIWARIATEDRUIGK + "$", nullable=true)
    protected String getKariwariatedruigkType() {
        if (kariwariatedruigkType == null && kariwariatedruigk != null) return kariwariatedruigk.getType().toString();
        if (kariwariatedruigkType == null && getKariwariatedruigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kariwariatedruigk$' should not be NULL."));
        }
        return kariwariatedruigkType;
    }

    protected void setKariwariatedruigkType(String type) {
        kariwariatedruigkType = type;
        kariwariatedruigk = Optional.fromNullable(toCurrencyType(kariwariatedruigkType))
            .transform(bizCurrencyTransformer(getKariwariatedruigkValue()))
            .orNull();
    }

    private BizCurrency kariwariatedgngkkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKariwariatedgngkkngk() {
        return kariwariatedgngkkngk;
    }

    public void setKariwariatedgngkkngk(BizCurrency pKariwariatedgngkkngk) {
        kariwariatedgngkkngk = pKariwariatedgngkkngk;
        kariwariatedgngkkngkValue = null;
        kariwariatedgngkkngkType  = null;
    }

    transient private BigDecimal kariwariatedgngkkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIWARIATEDGNGKKNGK, nullable=true)
    protected BigDecimal getKariwariatedgngkkngkValue() {
        if (kariwariatedgngkkngkValue == null && kariwariatedgngkkngk != null) {
            if (kariwariatedgngkkngk.isOptional()) return null;
            return kariwariatedgngkkngk.absolute();
        }
        return kariwariatedgngkkngkValue;
    }

    protected void setKariwariatedgngkkngkValue(BigDecimal value) {
        kariwariatedgngkkngkValue = value;
        kariwariatedgngkkngk = Optional.fromNullable(toCurrencyType(kariwariatedgngkkngkType))
            .transform(bizCurrencyTransformer(getKariwariatedgngkkngkValue()))
            .orNull();
    }

    transient private String kariwariatedgngkkngkType = null;

    @Column(name=KARIWARIATEDGNGKKNGK + "$", nullable=true)
    protected String getKariwariatedgngkkngkType() {
        if (kariwariatedgngkkngkType == null && kariwariatedgngkkngk != null) return kariwariatedgngkkngk.getType().toString();
        if (kariwariatedgngkkngkType == null && getKariwariatedgngkkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kariwariatedgngkkngk$' should not be NULL."));
        }
        return kariwariatedgngkkngkType;
    }

    protected void setKariwariatedgngkkngkType(String type) {
        kariwariatedgngkkngkType = type;
        kariwariatedgngkkngk = Optional.fromNullable(toCurrencyType(kariwariatedgngkkngkType))
            .transform(bizCurrencyTransformer(getKariwariatedgngkkngkValue()))
            .orNull();
    }

    private BizCurrency kariwariatedshrgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKariwariatedshrgk() {
        return kariwariatedshrgk;
    }

    public void setKariwariatedshrgk(BizCurrency pKariwariatedshrgk) {
        kariwariatedshrgk = pKariwariatedshrgk;
        kariwariatedshrgkValue = null;
        kariwariatedshrgkType  = null;
    }

    transient private BigDecimal kariwariatedshrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIWARIATEDSHRGK, nullable=true)
    protected BigDecimal getKariwariatedshrgkValue() {
        if (kariwariatedshrgkValue == null && kariwariatedshrgk != null) {
            if (kariwariatedshrgk.isOptional()) return null;
            return kariwariatedshrgk.absolute();
        }
        return kariwariatedshrgkValue;
    }

    protected void setKariwariatedshrgkValue(BigDecimal value) {
        kariwariatedshrgkValue = value;
        kariwariatedshrgk = Optional.fromNullable(toCurrencyType(kariwariatedshrgkType))
            .transform(bizCurrencyTransformer(getKariwariatedshrgkValue()))
            .orNull();
    }

    transient private String kariwariatedshrgkType = null;

    @Column(name=KARIWARIATEDSHRGK + "$", nullable=true)
    protected String getKariwariatedshrgkType() {
        if (kariwariatedshrgkType == null && kariwariatedshrgk != null) return kariwariatedshrgk.getType().toString();
        if (kariwariatedshrgkType == null && getKariwariatedshrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kariwariatedshrgk$' should not be NULL."));
        }
        return kariwariatedshrgkType;
    }

    protected void setKariwariatedshrgkType(String type) {
        kariwariatedshrgkType = type;
        kariwariatedshrgk = Optional.fromNullable(toCurrencyType(kariwariatedshrgkType))
            .transform(bizCurrencyTransformer(getKariwariatedshrgkValue()))
            .orNull();
    }

    private BizCurrency dkeisanhaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDkeisanhaitoukin() {
        return dkeisanhaitoukin;
    }

    public void setDkeisanhaitoukin(BizCurrency pDkeisanhaitoukin) {
        dkeisanhaitoukin = pDkeisanhaitoukin;
        dkeisanhaitoukinValue = null;
        dkeisanhaitoukinType  = null;
    }

    transient private BigDecimal dkeisanhaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DKEISANHAITOUKIN, nullable=true)
    protected BigDecimal getDkeisanhaitoukinValue() {
        if (dkeisanhaitoukinValue == null && dkeisanhaitoukin != null) {
            if (dkeisanhaitoukin.isOptional()) return null;
            return dkeisanhaitoukin.absolute();
        }
        return dkeisanhaitoukinValue;
    }

    protected void setDkeisanhaitoukinValue(BigDecimal value) {
        dkeisanhaitoukinValue = value;
        dkeisanhaitoukin = Optional.fromNullable(toCurrencyType(dkeisanhaitoukinType))
            .transform(bizCurrencyTransformer(getDkeisanhaitoukinValue()))
            .orNull();
    }

    transient private String dkeisanhaitoukinType = null;

    @Column(name=DKEISANHAITOUKIN + "$", nullable=true)
    protected String getDkeisanhaitoukinType() {
        if (dkeisanhaitoukinType == null && dkeisanhaitoukin != null) return dkeisanhaitoukin.getType().toString();
        if (dkeisanhaitoukinType == null && getDkeisanhaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dkeisanhaitoukin$' should not be NULL."));
        }
        return dkeisanhaitoukinType;
    }

    protected void setDkeisanhaitoukinType(String type) {
        dkeisanhaitoukinType = type;
        dkeisanhaitoukin = Optional.fromNullable(toCurrencyType(dkeisanhaitoukinType))
            .transform(bizCurrencyTransformer(getDkeisanhaitoukinValue()))
            .orNull();
    }

    private C_NaiteiKakuteiKbn dkeisannaiteikakuteikbn;

    @Type(type="UserType_C_NaiteiKakuteiKbn")
    @Column(name=GenJT_SiDshrTuki.DKEISANNAITEIKAKUTEIKBN)
    public C_NaiteiKakuteiKbn getDkeisannaiteikakuteikbn() {
        return dkeisannaiteikakuteikbn;
    }

    public void setDkeisannaiteikakuteikbn(C_NaiteiKakuteiKbn pDkeisannaiteikakuteikbn) {
        dkeisannaiteikakuteikbn = pDkeisannaiteikakuteikbn;
    }

    private BizDateY haitounendo;

    @Type(type="BizDateYType")
    @Column(name=GenJT_SiDshrTuki.HAITOUNENDO)
    public BizDateY getHaitounendo() {
        return haitounendo;
    }

    public void setHaitounendo(BizDateY pHaitounendo) {
        haitounendo = pHaitounendo;
    }

    private BizCurrency haitoushrkingk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHaitoushrkingk() {
        return haitoushrkingk;
    }

    public void setHaitoushrkingk(BizCurrency pHaitoushrkingk) {
        haitoushrkingk = pHaitoushrkingk;
        haitoushrkingkValue = null;
        haitoushrkingkType  = null;
    }

    transient private BigDecimal haitoushrkingkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HAITOUSHRKINGK, nullable=true)
    protected BigDecimal getHaitoushrkingkValue() {
        if (haitoushrkingkValue == null && haitoushrkingk != null) {
            if (haitoushrkingk.isOptional()) return null;
            return haitoushrkingk.absolute();
        }
        return haitoushrkingkValue;
    }

    protected void setHaitoushrkingkValue(BigDecimal value) {
        haitoushrkingkValue = value;
        haitoushrkingk = Optional.fromNullable(toCurrencyType(haitoushrkingkType))
            .transform(bizCurrencyTransformer(getHaitoushrkingkValue()))
            .orNull();
    }

    transient private String haitoushrkingkType = null;

    @Column(name=HAITOUSHRKINGK + "$", nullable=true)
    protected String getHaitoushrkingkType() {
        if (haitoushrkingkType == null && haitoushrkingk != null) return haitoushrkingk.getType().toString();
        if (haitoushrkingkType == null && getHaitoushrkingkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'haitoushrkingk$' should not be NULL."));
        }
        return haitoushrkingkType;
    }

    protected void setHaitoushrkingkType(String type) {
        haitoushrkingkType = type;
        haitoushrkingk = Optional.fromNullable(toCurrencyType(haitoushrkingkType))
            .transform(bizCurrencyTransformer(getHaitoushrkingkValue()))
            .orNull();
    }

    private BizCurrency kariwariatedganrikindshr;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKariwariatedganrikindshr() {
        return kariwariatedganrikindshr;
    }

    public void setKariwariatedganrikindshr(BizCurrency pKariwariatedganrikindshr) {
        kariwariatedganrikindshr = pKariwariatedganrikindshr;
        kariwariatedganrikindshrValue = null;
        kariwariatedganrikindshrType  = null;
    }

    transient private BigDecimal kariwariatedganrikindshrValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIWARIATEDGANRIKINDSHR, nullable=true)
    protected BigDecimal getKariwariatedganrikindshrValue() {
        if (kariwariatedganrikindshrValue == null && kariwariatedganrikindshr != null) {
            if (kariwariatedganrikindshr.isOptional()) return null;
            return kariwariatedganrikindshr.absolute();
        }
        return kariwariatedganrikindshrValue;
    }

    protected void setKariwariatedganrikindshrValue(BigDecimal value) {
        kariwariatedganrikindshrValue = value;
        kariwariatedganrikindshr = Optional.fromNullable(toCurrencyType(kariwariatedganrikindshrType))
            .transform(bizCurrencyTransformer(getKariwariatedganrikindshrValue()))
            .orNull();
    }

    transient private String kariwariatedganrikindshrType = null;

    @Column(name=KARIWARIATEDGANRIKINDSHR + "$", nullable=true)
    protected String getKariwariatedganrikindshrType() {
        if (kariwariatedganrikindshrType == null && kariwariatedganrikindshr != null) return kariwariatedganrikindshr.getType().toString();
        if (kariwariatedganrikindshrType == null && getKariwariatedganrikindshrValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kariwariatedganrikindshr$' should not be NULL."));
        }
        return kariwariatedganrikindshrType;
    }

    protected void setKariwariatedganrikindshrType(String type) {
        kariwariatedganrikindshrType = type;
        kariwariatedganrikindshr = Optional.fromNullable(toCurrencyType(kariwariatedganrikindshrType))
            .transform(bizCurrencyTransformer(getKariwariatedganrikindshrValue()))
            .orNull();
    }

    private BizCurrency tumitated;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTumitated() {
        return tumitated;
    }

    public void setTumitated(BizCurrency pTumitated) {
        tumitated = pTumitated;
        tumitatedValue = null;
        tumitatedType  = null;
    }

    transient private BigDecimal tumitatedValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUMITATED, nullable=true)
    protected BigDecimal getTumitatedValue() {
        if (tumitatedValue == null && tumitated != null) {
            if (tumitated.isOptional()) return null;
            return tumitated.absolute();
        }
        return tumitatedValue;
    }

    protected void setTumitatedValue(BigDecimal value) {
        tumitatedValue = value;
        tumitated = Optional.fromNullable(toCurrencyType(tumitatedType))
            .transform(bizCurrencyTransformer(getTumitatedValue()))
            .orNull();
    }

    transient private String tumitatedType = null;

    @Column(name=TUMITATED + "$", nullable=true)
    protected String getTumitatedType() {
        if (tumitatedType == null && tumitated != null) return tumitated.getType().toString();
        if (tumitatedType == null && getTumitatedValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tumitated$' should not be NULL."));
        }
        return tumitatedType;
    }

    protected void setTumitatedType(String type) {
        tumitatedType = type;
        tumitated = Optional.fromNullable(toCurrencyType(tumitatedType))
            .transform(bizCurrencyTransformer(getTumitatedValue()))
            .orNull();
    }

    private BizCurrency tumitatedmodosimae;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTumitatedmodosimae() {
        return tumitatedmodosimae;
    }

    public void setTumitatedmodosimae(BizCurrency pTumitatedmodosimae) {
        tumitatedmodosimae = pTumitatedmodosimae;
        tumitatedmodosimaeValue = null;
        tumitatedmodosimaeType  = null;
    }

    transient private BigDecimal tumitatedmodosimaeValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUMITATEDMODOSIMAE, nullable=true)
    protected BigDecimal getTumitatedmodosimaeValue() {
        if (tumitatedmodosimaeValue == null && tumitatedmodosimae != null) {
            if (tumitatedmodosimae.isOptional()) return null;
            return tumitatedmodosimae.absolute();
        }
        return tumitatedmodosimaeValue;
    }

    protected void setTumitatedmodosimaeValue(BigDecimal value) {
        tumitatedmodosimaeValue = value;
        tumitatedmodosimae = Optional.fromNullable(toCurrencyType(tumitatedmodosimaeType))
            .transform(bizCurrencyTransformer(getTumitatedmodosimaeValue()))
            .orNull();
    }

    transient private String tumitatedmodosimaeType = null;

    @Column(name=TUMITATEDMODOSIMAE + "$", nullable=true)
    protected String getTumitatedmodosimaeType() {
        if (tumitatedmodosimaeType == null && tumitatedmodosimae != null) return tumitatedmodosimae.getType().toString();
        if (tumitatedmodosimaeType == null && getTumitatedmodosimaeValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tumitatedmodosimae$' should not be NULL."));
        }
        return tumitatedmodosimaeType;
    }

    protected void setTumitatedmodosimaeType(String type) {
        tumitatedmodosimaeType = type;
        tumitatedmodosimae = Optional.fromNullable(toCurrencyType(tumitatedmodosimaeType))
            .transform(bizCurrencyTransformer(getTumitatedmodosimaeValue()))
            .orNull();
    }

    private BizCurrency tumitatedmodosigo;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTumitatedmodosigo() {
        return tumitatedmodosigo;
    }

    public void setTumitatedmodosigo(BizCurrency pTumitatedmodosigo) {
        tumitatedmodosigo = pTumitatedmodosigo;
        tumitatedmodosigoValue = null;
        tumitatedmodosigoType  = null;
    }

    transient private BigDecimal tumitatedmodosigoValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUMITATEDMODOSIGO, nullable=true)
    protected BigDecimal getTumitatedmodosigoValue() {
        if (tumitatedmodosigoValue == null && tumitatedmodosigo != null) {
            if (tumitatedmodosigo.isOptional()) return null;
            return tumitatedmodosigo.absolute();
        }
        return tumitatedmodosigoValue;
    }

    protected void setTumitatedmodosigoValue(BigDecimal value) {
        tumitatedmodosigoValue = value;
        tumitatedmodosigo = Optional.fromNullable(toCurrencyType(tumitatedmodosigoType))
            .transform(bizCurrencyTransformer(getTumitatedmodosigoValue()))
            .orNull();
    }

    transient private String tumitatedmodosigoType = null;

    @Column(name=TUMITATEDMODOSIGO + "$", nullable=true)
    protected String getTumitatedmodosigoType() {
        if (tumitatedmodosigoType == null && tumitatedmodosigo != null) return tumitatedmodosigo.getType().toString();
        if (tumitatedmodosigoType == null && getTumitatedmodosigoValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tumitatedmodosigo$' should not be NULL."));
        }
        return tumitatedmodosigoType;
    }

    protected void setTumitatedmodosigoType(String type) {
        tumitatedmodosigoType = type;
        tumitatedmodosigo = Optional.fromNullable(toCurrencyType(tumitatedmodosigoType))
            .transform(bizCurrencyTransformer(getTumitatedmodosigoValue()))
            .orNull();
    }

    private BizCurrency tkbthaitou;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTkbthaitou() {
        return tkbthaitou;
    }

    public void setTkbthaitou(BizCurrency pTkbthaitou) {
        tkbthaitou = pTkbthaitou;
        tkbthaitouValue = null;
        tkbthaitouType  = null;
    }

    transient private BigDecimal tkbthaitouValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TKBTHAITOU, nullable=true)
    protected BigDecimal getTkbthaitouValue() {
        if (tkbthaitouValue == null && tkbthaitou != null) {
            if (tkbthaitou.isOptional()) return null;
            return tkbthaitou.absolute();
        }
        return tkbthaitouValue;
    }

    protected void setTkbthaitouValue(BigDecimal value) {
        tkbthaitouValue = value;
        tkbthaitou = Optional.fromNullable(toCurrencyType(tkbthaitouType))
            .transform(bizCurrencyTransformer(getTkbthaitouValue()))
            .orNull();
    }

    transient private String tkbthaitouType = null;

    @Column(name=TKBTHAITOU + "$", nullable=true)
    protected String getTkbthaitouType() {
        if (tkbthaitouType == null && tkbthaitou != null) return tkbthaitou.getType().toString();
        if (tkbthaitouType == null && getTkbthaitouValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tkbthaitou$' should not be NULL."));
        }
        return tkbthaitouType;
    }

    protected void setTkbthaitouType(String type) {
        tkbthaitouType = type;
        tkbthaitou = Optional.fromNullable(toCurrencyType(tkbthaitouType))
            .transform(bizCurrencyTransformer(getTkbthaitouValue()))
            .orNull();
    }

    private BizDateY haitounendo2;

    @Type(type="BizDateYType")
    @Column(name=GenJT_SiDshrTuki.HAITOUNENDO2)
    public BizDateY getHaitounendo2() {
        return haitounendo2;
    }

    public void setHaitounendo2(BizDateY pHaitounendo2) {
        haitounendo2 = pHaitounendo2;
    }

    private C_HaitoukinsksKbn haitoukinskskbn;

    @Type(type="UserType_C_HaitoukinsksKbn")
    @Column(name=GenJT_SiDshrTuki.HAITOUKINSKSKBN)
    public C_HaitoukinsksKbn getHaitoukinskskbn() {
        return haitoukinskskbn;
    }

    public void setHaitoukinskskbn(C_HaitoukinsksKbn pHaitoukinskskbn) {
        haitoukinskskbn = pHaitoukinskskbn;
    }

    private C_HaitoumeisaiKbn haitoumeisaikbn;

    @Type(type="UserType_C_HaitoumeisaiKbn")
    @Column(name=GenJT_SiDshrTuki.HAITOUMEISAIKBN)
    public C_HaitoumeisaiKbn getHaitoumeisaikbn() {
        return haitoumeisaikbn;
    }

    public void setHaitoumeisaikbn(C_HaitoumeisaiKbn pHaitoumeisaikbn) {
        haitoumeisaikbn = pHaitoumeisaikbn;
    }

    private BizDateY fstkariwariatednendo;

    @Type(type="BizDateYType")
    @Column(name=GenJT_SiDshrTuki.FSTKARIWARIATEDNENDO)
    public BizDateY getFstkariwariatednendo() {
        return fstkariwariatednendo;
    }

    public void setFstkariwariatednendo(BizDateY pFstkariwariatednendo) {
        fstkariwariatednendo = pFstkariwariatednendo;
    }

    private BizCurrency tounendod;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTounendod() {
        return tounendod;
    }

    public void setTounendod(BizCurrency pTounendod) {
        tounendod = pTounendod;
        tounendodValue = null;
        tounendodType  = null;
    }

    transient private BigDecimal tounendodValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TOUNENDOD, nullable=true)
    protected BigDecimal getTounendodValue() {
        if (tounendodValue == null && tounendod != null) {
            if (tounendod.isOptional()) return null;
            return tounendod.absolute();
        }
        return tounendodValue;
    }

    protected void setTounendodValue(BigDecimal value) {
        tounendodValue = value;
        tounendod = Optional.fromNullable(toCurrencyType(tounendodType))
            .transform(bizCurrencyTransformer(getTounendodValue()))
            .orNull();
    }

    transient private String tounendodType = null;

    @Column(name=TOUNENDOD + "$", nullable=true)
    protected String getTounendodType() {
        if (tounendodType == null && tounendod != null) return tounendod.getType().toString();
        if (tounendodType == null && getTounendodValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tounendod$' should not be NULL."));
        }
        return tounendodType;
    }

    protected void setTounendodType(String type) {
        tounendodType = type;
        tounendod = Optional.fromNullable(toCurrencyType(tounendodType))
            .transform(bizCurrencyTransformer(getTounendodValue()))
            .orNull();
    }

    private C_NaiteiKakuteiKbn naiteikakuteikbn;

    @Type(type="UserType_C_NaiteiKakuteiKbn")
    @Column(name=GenJT_SiDshrTuki.NAITEIKAKUTEIKBN)
    public C_NaiteiKakuteiKbn getNaiteikakuteikbn() {
        return naiteikakuteikbn;
    }

    public void setNaiteikakuteikbn(C_NaiteiKakuteiKbn pNaiteikakuteikbn) {
        naiteikakuteikbn = pNaiteikakuteikbn;
    }

    private BizDate kariwariatedshrymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDshrTuki.KARIWARIATEDSHRYMD)
    public BizDate getKariwariatedshrymd() {
        return kariwariatedshrymd;
    }

    public void setKariwariatedshrymd(BizDate pKariwariatedshrymd) {
        kariwariatedshrymd = pKariwariatedshrymd;
    }

    private BizCurrency kariwariatedruigk2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKariwariatedruigk2() {
        return kariwariatedruigk2;
    }

    public void setKariwariatedruigk2(BizCurrency pKariwariatedruigk2) {
        kariwariatedruigk2 = pKariwariatedruigk2;
        kariwariatedruigk2Value = null;
        kariwariatedruigk2Type  = null;
    }

    transient private BigDecimal kariwariatedruigk2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIWARIATEDRUIGK2, nullable=true)
    protected BigDecimal getKariwariatedruigk2Value() {
        if (kariwariatedruigk2Value == null && kariwariatedruigk2 != null) {
            if (kariwariatedruigk2.isOptional()) return null;
            return kariwariatedruigk2.absolute();
        }
        return kariwariatedruigk2Value;
    }

    protected void setKariwariatedruigk2Value(BigDecimal value) {
        kariwariatedruigk2Value = value;
        kariwariatedruigk2 = Optional.fromNullable(toCurrencyType(kariwariatedruigk2Type))
            .transform(bizCurrencyTransformer(getKariwariatedruigk2Value()))
            .orNull();
    }

    transient private String kariwariatedruigk2Type = null;

    @Column(name=KARIWARIATEDRUIGK2 + "$", nullable=true)
    protected String getKariwariatedruigk2Type() {
        if (kariwariatedruigk2Type == null && kariwariatedruigk2 != null) return kariwariatedruigk2.getType().toString();
        if (kariwariatedruigk2Type == null && getKariwariatedruigk2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kariwariatedruigk2$' should not be NULL."));
        }
        return kariwariatedruigk2Type;
    }

    protected void setKariwariatedruigk2Type(String type) {
        kariwariatedruigk2Type = type;
        kariwariatedruigk2 = Optional.fromNullable(toCurrencyType(kariwariatedruigk2Type))
            .transform(bizCurrencyTransformer(getKariwariatedruigk2Value()))
            .orNull();
    }

    private BizCurrency kariwariatedgngkkngk2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKariwariatedgngkkngk2() {
        return kariwariatedgngkkngk2;
    }

    public void setKariwariatedgngkkngk2(BizCurrency pKariwariatedgngkkngk2) {
        kariwariatedgngkkngk2 = pKariwariatedgngkkngk2;
        kariwariatedgngkkngk2Value = null;
        kariwariatedgngkkngk2Type  = null;
    }

    transient private BigDecimal kariwariatedgngkkngk2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIWARIATEDGNGKKNGK2, nullable=true)
    protected BigDecimal getKariwariatedgngkkngk2Value() {
        if (kariwariatedgngkkngk2Value == null && kariwariatedgngkkngk2 != null) {
            if (kariwariatedgngkkngk2.isOptional()) return null;
            return kariwariatedgngkkngk2.absolute();
        }
        return kariwariatedgngkkngk2Value;
    }

    protected void setKariwariatedgngkkngk2Value(BigDecimal value) {
        kariwariatedgngkkngk2Value = value;
        kariwariatedgngkkngk2 = Optional.fromNullable(toCurrencyType(kariwariatedgngkkngk2Type))
            .transform(bizCurrencyTransformer(getKariwariatedgngkkngk2Value()))
            .orNull();
    }

    transient private String kariwariatedgngkkngk2Type = null;

    @Column(name=KARIWARIATEDGNGKKNGK2 + "$", nullable=true)
    protected String getKariwariatedgngkkngk2Type() {
        if (kariwariatedgngkkngk2Type == null && kariwariatedgngkkngk2 != null) return kariwariatedgngkkngk2.getType().toString();
        if (kariwariatedgngkkngk2Type == null && getKariwariatedgngkkngk2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kariwariatedgngkkngk2$' should not be NULL."));
        }
        return kariwariatedgngkkngk2Type;
    }

    protected void setKariwariatedgngkkngk2Type(String type) {
        kariwariatedgngkkngk2Type = type;
        kariwariatedgngkkngk2 = Optional.fromNullable(toCurrencyType(kariwariatedgngkkngk2Type))
            .transform(bizCurrencyTransformer(getKariwariatedgngkkngk2Value()))
            .orNull();
    }

    private BizCurrency kariwariatedshrgk2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKariwariatedshrgk2() {
        return kariwariatedshrgk2;
    }

    public void setKariwariatedshrgk2(BizCurrency pKariwariatedshrgk2) {
        kariwariatedshrgk2 = pKariwariatedshrgk2;
        kariwariatedshrgk2Value = null;
        kariwariatedshrgk2Type  = null;
    }

    transient private BigDecimal kariwariatedshrgk2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIWARIATEDSHRGK2, nullable=true)
    protected BigDecimal getKariwariatedshrgk2Value() {
        if (kariwariatedshrgk2Value == null && kariwariatedshrgk2 != null) {
            if (kariwariatedshrgk2.isOptional()) return null;
            return kariwariatedshrgk2.absolute();
        }
        return kariwariatedshrgk2Value;
    }

    protected void setKariwariatedshrgk2Value(BigDecimal value) {
        kariwariatedshrgk2Value = value;
        kariwariatedshrgk2 = Optional.fromNullable(toCurrencyType(kariwariatedshrgk2Type))
            .transform(bizCurrencyTransformer(getKariwariatedshrgk2Value()))
            .orNull();
    }

    transient private String kariwariatedshrgk2Type = null;

    @Column(name=KARIWARIATEDSHRGK2 + "$", nullable=true)
    protected String getKariwariatedshrgk2Type() {
        if (kariwariatedshrgk2Type == null && kariwariatedshrgk2 != null) return kariwariatedshrgk2.getType().toString();
        if (kariwariatedshrgk2Type == null && getKariwariatedshrgk2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kariwariatedshrgk2$' should not be NULL."));
        }
        return kariwariatedshrgk2Type;
    }

    protected void setKariwariatedshrgk2Type(String type) {
        kariwariatedshrgk2Type = type;
        kariwariatedshrgk2 = Optional.fromNullable(toCurrencyType(kariwariatedshrgk2Type))
            .transform(bizCurrencyTransformer(getKariwariatedshrgk2Value()))
            .orNull();
    }

    private BizDate tumitatedtumitateymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDshrTuki.TUMITATEDTUMITATEYMD)
    public BizDate getTumitatedtumitateymd() {
        return tumitatedtumitateymd;
    }

    public void setTumitatedtumitateymd(BizDate pTumitatedtumitateymd) {
        tumitatedtumitateymd = pTumitatedtumitateymd;
    }

    private C_TumitateDSakuseiKbn tumitatedskskbn;

    @Type(type="UserType_C_TumitateDSakuseiKbn")
    @Column(name=GenJT_SiDshrTuki.TUMITATEDSKSKBN)
    public C_TumitateDSakuseiKbn getTumitatedskskbn() {
        return tumitatedskskbn;
    }

    public void setTumitatedskskbn(C_TumitateDSakuseiKbn pTumitatedskskbn) {
        tumitatedskskbn = pTumitatedskskbn;
    }

    private BizCurrency tumitated2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTumitated2() {
        return tumitated2;
    }

    public void setTumitated2(BizCurrency pTumitated2) {
        tumitated2 = pTumitated2;
        tumitated2Value = null;
        tumitated2Type  = null;
    }

    transient private BigDecimal tumitated2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUMITATED2, nullable=true)
    protected BigDecimal getTumitated2Value() {
        if (tumitated2Value == null && tumitated2 != null) {
            if (tumitated2.isOptional()) return null;
            return tumitated2.absolute();
        }
        return tumitated2Value;
    }

    protected void setTumitated2Value(BigDecimal value) {
        tumitated2Value = value;
        tumitated2 = Optional.fromNullable(toCurrencyType(tumitated2Type))
            .transform(bizCurrencyTransformer(getTumitated2Value()))
            .orNull();
    }

    transient private String tumitated2Type = null;

    @Column(name=TUMITATED2 + "$", nullable=true)
    protected String getTumitated2Type() {
        if (tumitated2Type == null && tumitated2 != null) return tumitated2.getType().toString();
        if (tumitated2Type == null && getTumitated2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tumitated2$' should not be NULL."));
        }
        return tumitated2Type;
    }

    protected void setTumitated2Type(String type) {
        tumitated2Type = type;
        tumitated2 = Optional.fromNullable(toCurrencyType(tumitated2Type))
            .transform(bizCurrencyTransformer(getTumitated2Value()))
            .orNull();
    }

    private BizDate tumitatedshrkrkymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDshrTuki.TUMITATEDSHRKRKYMD)
    public BizDate getTumitatedshrkrkymd() {
        return tumitatedshrkrkymd;
    }

    public void setTumitatedshrkrkymd(BizDate pTumitatedshrkrkymd) {
        tumitatedshrkrkymd = pTumitatedshrkrkymd;
    }

    private C_NaiteiKakuteiKbn naiteikakuteikbn2;

    @Type(type="UserType_C_NaiteiKakuteiKbn")
    @Column(name=GenJT_SiDshrTuki.NAITEIKAKUTEIKBN2)
    public C_NaiteiKakuteiKbn getNaiteikakuteikbn2() {
        return naiteikakuteikbn2;
    }

    public void setNaiteikakuteikbn2(C_NaiteiKakuteiKbn pNaiteikakuteikbn2) {
        naiteikakuteikbn2 = pNaiteikakuteikbn2;
    }

    private BizCurrency haitouganrikincalckari;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHaitouganrikincalckari() {
        return haitouganrikincalckari;
    }

    public void setHaitouganrikincalckari(BizCurrency pHaitouganrikincalckari) {
        haitouganrikincalckari = pHaitouganrikincalckari;
        haitouganrikincalckariValue = null;
        haitouganrikincalckariType  = null;
    }

    transient private BigDecimal haitouganrikincalckariValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HAITOUGANRIKINCALCKARI, nullable=true)
    protected BigDecimal getHaitouganrikincalckariValue() {
        if (haitouganrikincalckariValue == null && haitouganrikincalckari != null) {
            if (haitouganrikincalckari.isOptional()) return null;
            return haitouganrikincalckari.absolute();
        }
        return haitouganrikincalckariValue;
    }

    protected void setHaitouganrikincalckariValue(BigDecimal value) {
        haitouganrikincalckariValue = value;
        haitouganrikincalckari = Optional.fromNullable(toCurrencyType(haitouganrikincalckariType))
            .transform(bizCurrencyTransformer(getHaitouganrikincalckariValue()))
            .orNull();
    }

    transient private String haitouganrikincalckariType = null;

    @Column(name=HAITOUGANRIKINCALCKARI + "$", nullable=true)
    protected String getHaitouganrikincalckariType() {
        if (haitouganrikincalckariType == null && haitouganrikincalckari != null) return haitouganrikincalckari.getType().toString();
        if (haitouganrikincalckariType == null && getHaitouganrikincalckariValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'haitouganrikincalckari$' should not be NULL."));
        }
        return haitouganrikincalckariType;
    }

    protected void setHaitouganrikincalckariType(String type) {
        haitouganrikincalckariType = type;
        haitouganrikincalckari = Optional.fromNullable(toCurrencyType(haitouganrikincalckariType))
            .transform(bizCurrencyTransformer(getHaitouganrikincalckariValue()))
            .orNull();
    }

    private BizNumber kariwariatedriritu1;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiDshrTuki.KARIWARIATEDRIRITU1)
    public BizNumber getKariwariatedriritu1() {
        return kariwariatedriritu1;
    }

    public void setKariwariatedriritu1(BizNumber pKariwariatedriritu1) {
        kariwariatedriritu1 = pKariwariatedriritu1;
    }

    private BizNumber kariwariatedriritu2;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiDshrTuki.KARIWARIATEDRIRITU2)
    public BizNumber getKariwariatedriritu2() {
        return kariwariatedriritu2;
    }

    public void setKariwariatedriritu2(BizNumber pKariwariatedriritu2) {
        kariwariatedriritu2 = pKariwariatedriritu2;
    }

    private BizCurrency haitouganrikincalctumi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHaitouganrikincalctumi() {
        return haitouganrikincalctumi;
    }

    public void setHaitouganrikincalctumi(BizCurrency pHaitouganrikincalctumi) {
        haitouganrikincalctumi = pHaitouganrikincalctumi;
        haitouganrikincalctumiValue = null;
        haitouganrikincalctumiType  = null;
    }

    transient private BigDecimal haitouganrikincalctumiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HAITOUGANRIKINCALCTUMI, nullable=true)
    protected BigDecimal getHaitouganrikincalctumiValue() {
        if (haitouganrikincalctumiValue == null && haitouganrikincalctumi != null) {
            if (haitouganrikincalctumi.isOptional()) return null;
            return haitouganrikincalctumi.absolute();
        }
        return haitouganrikincalctumiValue;
    }

    protected void setHaitouganrikincalctumiValue(BigDecimal value) {
        haitouganrikincalctumiValue = value;
        haitouganrikincalctumi = Optional.fromNullable(toCurrencyType(haitouganrikincalctumiType))
            .transform(bizCurrencyTransformer(getHaitouganrikincalctumiValue()))
            .orNull();
    }

    transient private String haitouganrikincalctumiType = null;

    @Column(name=HAITOUGANRIKINCALCTUMI + "$", nullable=true)
    protected String getHaitouganrikincalctumiType() {
        if (haitouganrikincalctumiType == null && haitouganrikincalctumi != null) return haitouganrikincalctumi.getType().toString();
        if (haitouganrikincalctumiType == null && getHaitouganrikincalctumiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'haitouganrikincalctumi$' should not be NULL."));
        }
        return haitouganrikincalctumiType;
    }

    protected void setHaitouganrikincalctumiType(String type) {
        haitouganrikincalctumiType = type;
        haitouganrikincalctumi = Optional.fromNullable(toCurrencyType(haitouganrikincalctumiType))
            .transform(bizCurrencyTransformer(getHaitouganrikincalctumiValue()))
            .orNull();
    }

    private BizNumber tumitatedriritu1;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiDshrTuki.TUMITATEDRIRITU1)
    public BizNumber getTumitatedriritu1() {
        return tumitatedriritu1;
    }

    public void setTumitatedriritu1(BizNumber pTumitatedriritu1) {
        tumitatedriritu1 = pTumitatedriritu1;
    }

    private BizNumber tumitatedriritu2;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiDshrTuki.TUMITATEDRIRITU2)
    public BizNumber getTumitatedriritu2() {
        return tumitatedriritu2;
    }

    public void setTumitatedriritu2(BizNumber pTumitatedriritu2) {
        tumitatedriritu2 = pTumitatedriritu2;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SiDshrTuki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenJT_SiDshrTuki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SiDshrTuki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}