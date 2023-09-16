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
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateMDType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_SknnkaisikitkKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YennykntksyuruiKbn;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.id.PKIT_KykSonotaTkyk;
import yuyu.def.db.meta.GenQIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.type.UserType_C_Htnpkkn;
import yuyu.def.db.type.UserType_C_Nstknsyu;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_SknnkaisikitkKbn;
import yuyu.def.db.type.UserType_C_TargetTkKbn;
import yuyu.def.db.type.UserType_C_TokkoudosghtnpKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YennykntksyuruiKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約その他特約テーブル テーブルのマッピング情報クラスで、 {@link IT_KykSonotaTkyk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KykSonotaTkyk}</td><td colspan="3">契約その他特約テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KykSonotaTkyk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KykSonotaTkyk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLivingneedshukaumu livingneedshukaumu}</td><td>リビングニーズ特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getStdrsktkyhkumu stdrsktkyhkumu}</td><td>被保険者代理特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getStdrsktkyhkymd stdrsktkyhkymd}</td><td>被保険者代理特約付加日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYennykntkhkumu yennykntkhkumu}</td><td>円入金特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGaikanykntkhkumu gaikanykntkhkumu}</td><td>外貨入金特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getYenshrtkhkumu yenshrtkhkumu}</td><td>円支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getYenshrkykkykhenkoymd yenshrkykkykhenkoymd}</td><td>円支払特約契約変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkgkkateitkumu nkgkkateitkumu}</td><td>年金額確定特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNksgkhosyuwari nksgkhosyuwari}</td><td>年金総額保証割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSkjbrnktsumu skjbrnktsumu}</td><td>即時払年金特則有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNenkingaku8waritkumu nenkingaku8waritkumu}</td><td>年金額８割保証特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNenkingaku9waritkumu nenkingaku9waritkumu}</td><td>年金額９割保証特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNkyentkhukaumu nkyentkhukaumu}</td><td>年金円支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKwsttkhukaumu kwsttkhukaumu}</td><td>為替ターゲット特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKwstargetrate kwstargetrate}</td><td>為替ターゲットレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTargettkhkumu targettkhkumu}</td><td>ターゲット特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTargettkykkykhenkoymd targettkykkykhenkoymd}</td><td>ターゲット特約契約変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTargettkkbn targettkkbn}</td><td>ターゲット特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TargetTkKbn}</td></tr>
 *  <tr><td>{@link #getTargettkmokuhyouti targettkmokuhyouti}</td><td>ターゲット特約目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getYsknkshtkumu ysknkshtkumu}</td><td>新遺族年金支払特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getPmnjtkkbn pmnjtkkbn}</td><td>保険料免除特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PmnjtkKbn}</td></tr>
 *  <tr><td>{@link #getPmnjtkkykymd pmnjtkkykymd}</td><td>保険料免除特約契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getPmnjtksknnkaisiymd pmnjtksknnkaisiymd}</td><td>保険料免除特約責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getPmnjtkgansknnkaisiymd pmnjtkgansknnkaisiymd}</td><td>保険料免除特約がん責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getPmhktsknnkaisiymd pmhktsknnkaisiymd}</td><td>保険料免除特約復活責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getPmnjhktgansknnkaisiymd pmnjhktgansknnkaisiymd}</td><td>保険料免除特約復活がん責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getPmnjtkhtnpbuicd1 pmnjtkhtnpbuicd1}</td><td>保険料免除特約不担保部位コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPmnjtkhtnpkkn1 pmnjtkhtnpkkn1}</td><td>保険料免除特約不担保期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getPmnjtkhtnpbuicd2 pmnjtkhtnpbuicd2}</td><td>保険料免除特約不担保部位コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPmnjtkhtnpkkn2 pmnjtkhtnpkkn2}</td><td>保険料免除特約不担保期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getPmnjtkhtnpbuicd3 pmnjtkhtnpbuicd3}</td><td>保険料免除特約不担保部位コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPmnjtkhtnpkkn3 pmnjtkhtnpkkn3}</td><td>保険料免除特約不担保期間３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getPmnjtkhtnpbuicd4 pmnjtkhtnpbuicd4}</td><td>保険料免除特約不担保部位コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPmnjtkhtnpkkn4 pmnjtkhtnpkkn4}</td><td>保険料免除特約不担保期間４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getPmnjtokkoudosghtnpkbn pmnjtokkoudosghtnpkbn}</td><td>保険料免除特約特定高度障害不担保区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokkoudosghtnpKbn}</td></tr>
 *  <tr><td>{@link #getSknnkaisikitkkbn sknnkaisikitkkbn}</td><td>責任開始期特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SknnkaisikitkKbn}</td></tr>
 *  <tr><td>{@link #getNstkhkumu nstkhkumu}</td><td>年金支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNkshrtkykhenkoymd nkshrtkykhenkoymd}</td><td>年金支払特約契約変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkshrtkyknksyukbn nkshrtkyknksyukbn}</td><td>年金支払特約年金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nstknsyu}</td></tr>
 *  <tr><td>{@link #getNkshrtkyknksyukkn nkshrtkyknksyukkn}</td><td>年金支払特約年金期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getInitsbjiyensitihsytkhukaumu initsbjiyensitihsytkhukaumu}</td><td>初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getInitsbjiyenkasaiteihsygk initsbjiyenkasaiteihsygk}</td><td>初期死亡時円換算最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getJyudkaigomeharaitkhukaumu jyudkaigomeharaitkhukaumu}</td><td>重度介護前払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getJyudkaigomeharaitkhukaymd jyudkaigomeharaitkhukaymd}</td><td>重度介護前払特約付加日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTargettkykhkymd targettkykhkymd}</td><td>ターゲット特約付加日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTargettkykkijyungk targettkykkijyungk}</td><td>ターゲット特約基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZeiseitkkktkykhukaumu zeiseitkkktkykhukaumu}</td><td>税制適格特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getZeiseitkkktkykhukaymd zeiseitkkktkykhukaymd}</td><td>税制適格特約付加日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZeiseitkkktkyksyoumetuymd zeiseitkkktkyksyoumetuymd}</td><td>税制適格特約消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYennyknsyuruikbn yennyknsyuruikbn}</td><td>円入金特約種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YennykntksyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKykdrtkykhukaumu kykdrtkykhukaumu}</td><td>契約者代理特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKykdrtkykhukaymd kykdrtkykhukaymd}</td><td>契約者代理特約付加日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykdrtkykkaiyakuymd kykdrtkykkaiyakuymd}</td><td>契約者代理特約解約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTeikishrtkykhukaumu teikishrtkykhukaumu}</td><td>定期支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTeikishrkinshrtuukasyu teikishrkinshrtuukasyu}</td><td>定期支払金支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getTeikishrkinshrmd teikishrkinshrmd}</td><td>定期支払金支払月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateMD</td></tr>
 * </table>
 * @see     IT_KykSonotaTkyk
 * @see     PKIT_KykSonotaTkyk
 * @see     QIT_KykSonotaTkyk
 * @see     GenQIT_KykSonotaTkyk
 */
@MappedSuperclass
@Table(name=GenIT_KykSonotaTkyk.TABLE_NAME)
@IdClass(value=PKIT_KykSonotaTkyk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateMDType", typeClass=BizDateMDType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Htnpkkn", typeClass=UserType_C_Htnpkkn.class),
    @TypeDef(name="UserType_C_Nstknsyu", typeClass=UserType_C_Nstknsyu.class),
    @TypeDef(name="UserType_C_PmnjtkKbn", typeClass=UserType_C_PmnjtkKbn.class),
    @TypeDef(name="UserType_C_SknnkaisikitkKbn", typeClass=UserType_C_SknnkaisikitkKbn.class),
    @TypeDef(name="UserType_C_TargetTkKbn", typeClass=UserType_C_TargetTkKbn.class),
    @TypeDef(name="UserType_C_TokkoudosghtnpKbn", typeClass=UserType_C_TokkoudosghtnpKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YennykntksyuruiKbn", typeClass=UserType_C_YennykntksyuruiKbn.class)
})
public abstract class GenIT_KykSonotaTkyk extends AbstractExDBEntity<IT_KykSonotaTkyk, PKIT_KykSonotaTkyk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KykSonotaTkyk";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String LIVINGNEEDSHUKAUMU       = "livingneedshukaumu";
    public static final String STDRSKTKYHKUMU           = "stdrsktkyhkumu";
    public static final String STDRSKTKYHKYMD           = "stdrsktkyhkymd";
    public static final String YENNYKNTKHKUMU           = "yennykntkhkumu";
    public static final String GAIKANYKNTKHKUMU         = "gaikanykntkhkumu";
    public static final String YENSHRTKHKUMU            = "yenshrtkhkumu";
    public static final String YENSHRKYKKYKHENKOYMD     = "yenshrkykkykhenkoymd";
    public static final String NKGKKATEITKUMU           = "nkgkkateitkumu";
    public static final String NKSGKHOSYUWARI           = "nksgkhosyuwari";
    public static final String SKJBRNKTSUMU             = "skjbrnktsumu";
    public static final String NENKINGAKU8WARITKUMU     = "nenkingaku8waritkumu";
    public static final String NENKINGAKU9WARITKUMU     = "nenkingaku9waritkumu";
    public static final String NKYENTKHUKAUMU           = "nkyentkhukaumu";
    public static final String KWSTTKHUKAUMU            = "kwsttkhukaumu";
    public static final String KWSTARGETRATE            = "kwstargetrate";
    public static final String TARGETTKHKUMU            = "targettkhkumu";
    public static final String TARGETTKYKKYKHENKOYMD    = "targettkykkykhenkoymd";
    public static final String TARGETTKKBN              = "targettkkbn";
    public static final String TARGETTKMOKUHYOUTI       = "targettkmokuhyouti";
    public static final String YSKNKSHTKUMU             = "ysknkshtkumu";
    public static final String PMNJTKKBN                = "pmnjtkkbn";
    public static final String PMNJTKKYKYMD             = "pmnjtkkykymd";
    public static final String PMNJTKSKNNKAISIYMD       = "pmnjtksknnkaisiymd";
    public static final String PMNJTKGANSKNNKAISIYMD    = "pmnjtkgansknnkaisiymd";
    public static final String PMHKTSKNNKAISIYMD        = "pmhktsknnkaisiymd";
    public static final String PMNJHKTGANSKNNKAISIYMD   = "pmnjhktgansknnkaisiymd";
    public static final String PMNJTKHTNPBUICD1         = "pmnjtkhtnpbuicd1";
    public static final String PMNJTKHTNPKKN1           = "pmnjtkhtnpkkn1";
    public static final String PMNJTKHTNPBUICD2         = "pmnjtkhtnpbuicd2";
    public static final String PMNJTKHTNPKKN2           = "pmnjtkhtnpkkn2";
    public static final String PMNJTKHTNPBUICD3         = "pmnjtkhtnpbuicd3";
    public static final String PMNJTKHTNPKKN3           = "pmnjtkhtnpkkn3";
    public static final String PMNJTKHTNPBUICD4         = "pmnjtkhtnpbuicd4";
    public static final String PMNJTKHTNPKKN4           = "pmnjtkhtnpkkn4";
    public static final String PMNJTOKKOUDOSGHTNPKBN    = "pmnjtokkoudosghtnpkbn";
    public static final String SKNNKAISIKITKKBN         = "sknnkaisikitkkbn";
    public static final String NSTKHKUMU                = "nstkhkumu";
    public static final String NKSHRTKYKHENKOYMD        = "nkshrtkykhenkoymd";
    public static final String NKSHRTKYKNKSYUKBN        = "nkshrtkyknksyukbn";
    public static final String NKSHRTKYKNKSYUKKN        = "nkshrtkyknksyukkn";
    public static final String INITSBJIYENSITIHSYTKHUKAUMU = "initsbjiyensitihsytkhukaumu";
    public static final String INITSBJIYENKASAITEIHSYGK = "initsbjiyenkasaiteihsygk";
    public static final String JYUDKAIGOMEHARAITKHUKAUMU = "jyudkaigomeharaitkhukaumu";
    public static final String JYUDKAIGOMEHARAITKHUKAYMD = "jyudkaigomeharaitkhukaymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String TARGETTKYKHKYMD          = "targettkykhkymd";
    public static final String TARGETTKYKKIJYUNGK       = "targettkykkijyungk";
    public static final String ZEISEITKKKTKYKHUKAUMU    = "zeiseitkkktkykhukaumu";
    public static final String ZEISEITKKKTKYKHUKAYMD    = "zeiseitkkktkykhukaymd";
    public static final String ZEISEITKKKTKYKSYOUMETUYMD = "zeiseitkkktkyksyoumetuymd";
    public static final String YENNYKNSYURUIKBN         = "yennyknsyuruikbn";
    public static final String KYKDRTKYKHUKAUMU         = "kykdrtkykhukaumu";
    public static final String KYKDRTKYKHUKAYMD         = "kykdrtkykhukaymd";
    public static final String KYKDRTKYKKAIYAKUYMD      = "kykdrtkykkaiyakuymd";
    public static final String TEIKISHRTKYKHUKAUMU      = "teikishrtkykhukaumu";
    public static final String TEIKISHRKINSHRTUUKASYU   = "teikishrkinshrtuukasyu";
    public static final String TEIKISHRKINSHRMD         = "teikishrkinshrmd";

    private final PKIT_KykSonotaTkyk primaryKey;

    public GenIT_KykSonotaTkyk() {
        primaryKey = new PKIT_KykSonotaTkyk();
    }

    public GenIT_KykSonotaTkyk(String pKbnkey, String pSyono) {
        primaryKey = new PKIT_KykSonotaTkyk(pKbnkey, pSyono);
    }

    @Transient
    @Override
    public PKIT_KykSonotaTkyk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KykSonotaTkyk> getMetaClass() {
        return QIT_KykSonotaTkyk.class;
    }

    @Id
    @Column(name=GenIT_KykSonotaTkyk.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KykSonotaTkyk.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private C_UmuKbn livingneedshukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.LIVINGNEEDSHUKAUMU)
    public C_UmuKbn getLivingneedshukaumu() {
        return livingneedshukaumu;
    }

    public void setLivingneedshukaumu(C_UmuKbn pLivingneedshukaumu) {
        livingneedshukaumu = pLivingneedshukaumu;
    }

    private C_UmuKbn stdrsktkyhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.STDRSKTKYHKUMU)
    public C_UmuKbn getStdrsktkyhkumu() {
        return stdrsktkyhkumu;
    }

    public void setStdrsktkyhkumu(C_UmuKbn pStdrsktkyhkumu) {
        stdrsktkyhkumu = pStdrsktkyhkumu;
    }

    private BizDate stdrsktkyhkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.STDRSKTKYHKYMD)
    public BizDate getStdrsktkyhkymd() {
        return stdrsktkyhkymd;
    }

    @Trim("both")
    public void setStdrsktkyhkymd(BizDate pStdrsktkyhkymd) {
        stdrsktkyhkymd = pStdrsktkyhkymd;
    }

    private C_UmuKbn yennykntkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.YENNYKNTKHKUMU)
    public C_UmuKbn getYennykntkhkumu() {
        return yennykntkhkumu;
    }

    public void setYennykntkhkumu(C_UmuKbn pYennykntkhkumu) {
        yennykntkhkumu = pYennykntkhkumu;
    }

    private C_UmuKbn gaikanykntkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.GAIKANYKNTKHKUMU)
    public C_UmuKbn getGaikanykntkhkumu() {
        return gaikanykntkhkumu;
    }

    public void setGaikanykntkhkumu(C_UmuKbn pGaikanykntkhkumu) {
        gaikanykntkhkumu = pGaikanykntkhkumu;
    }

    private C_UmuKbn yenshrtkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.YENSHRTKHKUMU)
    public C_UmuKbn getYenshrtkhkumu() {
        return yenshrtkhkumu;
    }

    public void setYenshrtkhkumu(C_UmuKbn pYenshrtkhkumu) {
        yenshrtkhkumu = pYenshrtkhkumu;
    }

    private BizDate yenshrkykkykhenkoymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.YENSHRKYKKYKHENKOYMD)
    @ValidDate
    public BizDate getYenshrkykkykhenkoymd() {
        return yenshrkykkykhenkoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenshrkykkykhenkoymd(BizDate pYenshrkykkykhenkoymd) {
        yenshrkykkykhenkoymd = pYenshrkykkykhenkoymd;
    }

    private C_UmuKbn nkgkkateitkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.NKGKKATEITKUMU)
    public C_UmuKbn getNkgkkateitkumu() {
        return nkgkkateitkumu;
    }

    public void setNkgkkateitkumu(C_UmuKbn pNkgkkateitkumu) {
        nkgkkateitkumu = pNkgkkateitkumu;
    }

    private BizNumber nksgkhosyuwari;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KykSonotaTkyk.NKSGKHOSYUWARI)
    public BizNumber getNksgkhosyuwari() {
        return nksgkhosyuwari;
    }

    @Trim("both")
    public void setNksgkhosyuwari(BizNumber pNksgkhosyuwari) {
        nksgkhosyuwari = pNksgkhosyuwari;
    }

    private C_UmuKbn skjbrnktsumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.SKJBRNKTSUMU)
    public C_UmuKbn getSkjbrnktsumu() {
        return skjbrnktsumu;
    }

    public void setSkjbrnktsumu(C_UmuKbn pSkjbrnktsumu) {
        skjbrnktsumu = pSkjbrnktsumu;
    }

    private C_UmuKbn nenkingaku8waritkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.NENKINGAKU8WARITKUMU)
    public C_UmuKbn getNenkingaku8waritkumu() {
        return nenkingaku8waritkumu;
    }

    public void setNenkingaku8waritkumu(C_UmuKbn pNenkingaku8waritkumu) {
        nenkingaku8waritkumu = pNenkingaku8waritkumu;
    }

    private C_UmuKbn nenkingaku9waritkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.NENKINGAKU9WARITKUMU)
    public C_UmuKbn getNenkingaku9waritkumu() {
        return nenkingaku9waritkumu;
    }

    public void setNenkingaku9waritkumu(C_UmuKbn pNenkingaku9waritkumu) {
        nenkingaku9waritkumu = pNenkingaku9waritkumu;
    }

    private C_UmuKbn nkyentkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.NKYENTKHUKAUMU)
    public C_UmuKbn getNkyentkhukaumu() {
        return nkyentkhukaumu;
    }

    public void setNkyentkhukaumu(C_UmuKbn pNkyentkhukaumu) {
        nkyentkhukaumu = pNkyentkhukaumu;
    }

    private C_UmuKbn kwsttkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.KWSTTKHUKAUMU)
    public C_UmuKbn getKwsttkhukaumu() {
        return kwsttkhukaumu;
    }

    public void setKwsttkhukaumu(C_UmuKbn pKwsttkhukaumu) {
        kwsttkhukaumu = pKwsttkhukaumu;
    }

    private Integer kwstargetrate;

    @Column(name=GenIT_KykSonotaTkyk.KWSTARGETRATE)
    public Integer getKwstargetrate() {
        return kwstargetrate;
    }

    public void setKwstargetrate(Integer pKwstargetrate) {
        kwstargetrate = pKwstargetrate;
    }

    private C_UmuKbn targettkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.TARGETTKHKUMU)
    public C_UmuKbn getTargettkhkumu() {
        return targettkhkumu;
    }

    public void setTargettkhkumu(C_UmuKbn pTargettkhkumu) {
        targettkhkumu = pTargettkhkumu;
    }

    private BizDate targettkykkykhenkoymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.TARGETTKYKKYKHENKOYMD)
    @ValidDate
    public BizDate getTargettkykkykhenkoymd() {
        return targettkykkykhenkoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTargettkykkykhenkoymd(BizDate pTargettkykkykhenkoymd) {
        targettkykkykhenkoymd = pTargettkykkykhenkoymd;
    }

    private C_TargetTkKbn targettkkbn;

    @Type(type="UserType_C_TargetTkKbn")
    @Column(name=GenIT_KykSonotaTkyk.TARGETTKKBN)
    public C_TargetTkKbn getTargettkkbn() {
        return targettkkbn;
    }

    public void setTargettkkbn(C_TargetTkKbn pTargettkkbn) {
        targettkkbn = pTargettkkbn;
    }

    private Integer targettkmokuhyouti;

    @Column(name=GenIT_KykSonotaTkyk.TARGETTKMOKUHYOUTI)
    public Integer getTargettkmokuhyouti() {
        return targettkmokuhyouti;
    }

    public void setTargettkmokuhyouti(Integer pTargettkmokuhyouti) {
        targettkmokuhyouti = pTargettkmokuhyouti;
    }

    private C_UmuKbn ysknkshtkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.YSKNKSHTKUMU)
    public C_UmuKbn getYsknkshtkumu() {
        return ysknkshtkumu;
    }

    public void setYsknkshtkumu(C_UmuKbn pYsknkshtkumu) {
        ysknkshtkumu = pYsknkshtkumu;
    }

    private C_PmnjtkKbn pmnjtkkbn;

    @Type(type="UserType_C_PmnjtkKbn")
    @Column(name=GenIT_KykSonotaTkyk.PMNJTKKBN)
    public C_PmnjtkKbn getPmnjtkkbn() {
        return pmnjtkkbn;
    }

    public void setPmnjtkkbn(C_PmnjtkKbn pPmnjtkkbn) {
        pmnjtkkbn = pPmnjtkkbn;
    }

    private BizDate pmnjtkkykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.PMNJTKKYKYMD)
    public BizDate getPmnjtkkykymd() {
        return pmnjtkkykymd;
    }

    @Trim("both")
    public void setPmnjtkkykymd(BizDate pPmnjtkkykymd) {
        pmnjtkkykymd = pPmnjtkkykymd;
    }

    private BizDate pmnjtksknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.PMNJTKSKNNKAISIYMD)
    public BizDate getPmnjtksknnkaisiymd() {
        return pmnjtksknnkaisiymd;
    }

    @Trim("both")
    public void setPmnjtksknnkaisiymd(BizDate pPmnjtksknnkaisiymd) {
        pmnjtksknnkaisiymd = pPmnjtksknnkaisiymd;
    }

    private BizDate pmnjtkgansknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.PMNJTKGANSKNNKAISIYMD)
    public BizDate getPmnjtkgansknnkaisiymd() {
        return pmnjtkgansknnkaisiymd;
    }

    @Trim("both")
    public void setPmnjtkgansknnkaisiymd(BizDate pPmnjtkgansknnkaisiymd) {
        pmnjtkgansknnkaisiymd = pPmnjtkgansknnkaisiymd;
    }

    private BizDate pmhktsknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.PMHKTSKNNKAISIYMD)
    public BizDate getPmhktsknnkaisiymd() {
        return pmhktsknnkaisiymd;
    }

    @Trim("both")
    public void setPmhktsknnkaisiymd(BizDate pPmhktsknnkaisiymd) {
        pmhktsknnkaisiymd = pPmhktsknnkaisiymd;
    }

    private BizDate pmnjhktgansknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.PMNJHKTGANSKNNKAISIYMD)
    public BizDate getPmnjhktgansknnkaisiymd() {
        return pmnjhktgansknnkaisiymd;
    }

    @Trim("both")
    public void setPmnjhktgansknnkaisiymd(BizDate pPmnjhktgansknnkaisiymd) {
        pmnjhktgansknnkaisiymd = pPmnjhktgansknnkaisiymd;
    }

    private String pmnjtkhtnpbuicd1;

    @Column(name=GenIT_KykSonotaTkyk.PMNJTKHTNPBUICD1)
    public String getPmnjtkhtnpbuicd1() {
        return pmnjtkhtnpbuicd1;
    }

    public void setPmnjtkhtnpbuicd1(String pPmnjtkhtnpbuicd1) {
        pmnjtkhtnpbuicd1 = pPmnjtkhtnpbuicd1;
    }

    private C_Htnpkkn pmnjtkhtnpkkn1;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenIT_KykSonotaTkyk.PMNJTKHTNPKKN1)
    public C_Htnpkkn getPmnjtkhtnpkkn1() {
        return pmnjtkhtnpkkn1;
    }

    public void setPmnjtkhtnpkkn1(C_Htnpkkn pPmnjtkhtnpkkn1) {
        pmnjtkhtnpkkn1 = pPmnjtkhtnpkkn1;
    }

    private String pmnjtkhtnpbuicd2;

    @Column(name=GenIT_KykSonotaTkyk.PMNJTKHTNPBUICD2)
    public String getPmnjtkhtnpbuicd2() {
        return pmnjtkhtnpbuicd2;
    }

    public void setPmnjtkhtnpbuicd2(String pPmnjtkhtnpbuicd2) {
        pmnjtkhtnpbuicd2 = pPmnjtkhtnpbuicd2;
    }

    private C_Htnpkkn pmnjtkhtnpkkn2;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenIT_KykSonotaTkyk.PMNJTKHTNPKKN2)
    public C_Htnpkkn getPmnjtkhtnpkkn2() {
        return pmnjtkhtnpkkn2;
    }

    public void setPmnjtkhtnpkkn2(C_Htnpkkn pPmnjtkhtnpkkn2) {
        pmnjtkhtnpkkn2 = pPmnjtkhtnpkkn2;
    }

    private String pmnjtkhtnpbuicd3;

    @Column(name=GenIT_KykSonotaTkyk.PMNJTKHTNPBUICD3)
    public String getPmnjtkhtnpbuicd3() {
        return pmnjtkhtnpbuicd3;
    }

    public void setPmnjtkhtnpbuicd3(String pPmnjtkhtnpbuicd3) {
        pmnjtkhtnpbuicd3 = pPmnjtkhtnpbuicd3;
    }

    private C_Htnpkkn pmnjtkhtnpkkn3;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenIT_KykSonotaTkyk.PMNJTKHTNPKKN3)
    public C_Htnpkkn getPmnjtkhtnpkkn3() {
        return pmnjtkhtnpkkn3;
    }

    public void setPmnjtkhtnpkkn3(C_Htnpkkn pPmnjtkhtnpkkn3) {
        pmnjtkhtnpkkn3 = pPmnjtkhtnpkkn3;
    }

    private String pmnjtkhtnpbuicd4;

    @Column(name=GenIT_KykSonotaTkyk.PMNJTKHTNPBUICD4)
    public String getPmnjtkhtnpbuicd4() {
        return pmnjtkhtnpbuicd4;
    }

    public void setPmnjtkhtnpbuicd4(String pPmnjtkhtnpbuicd4) {
        pmnjtkhtnpbuicd4 = pPmnjtkhtnpbuicd4;
    }

    private C_Htnpkkn pmnjtkhtnpkkn4;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenIT_KykSonotaTkyk.PMNJTKHTNPKKN4)
    public C_Htnpkkn getPmnjtkhtnpkkn4() {
        return pmnjtkhtnpkkn4;
    }

    public void setPmnjtkhtnpkkn4(C_Htnpkkn pPmnjtkhtnpkkn4) {
        pmnjtkhtnpkkn4 = pPmnjtkhtnpkkn4;
    }

    private C_TokkoudosghtnpKbn pmnjtokkoudosghtnpkbn;

    @Type(type="UserType_C_TokkoudosghtnpKbn")
    @Column(name=GenIT_KykSonotaTkyk.PMNJTOKKOUDOSGHTNPKBN)
    public C_TokkoudosghtnpKbn getPmnjtokkoudosghtnpkbn() {
        return pmnjtokkoudosghtnpkbn;
    }

    public void setPmnjtokkoudosghtnpkbn(C_TokkoudosghtnpKbn pPmnjtokkoudosghtnpkbn) {
        pmnjtokkoudosghtnpkbn = pPmnjtokkoudosghtnpkbn;
    }

    private C_SknnkaisikitkKbn sknnkaisikitkkbn;

    @Type(type="UserType_C_SknnkaisikitkKbn")
    @Column(name=GenIT_KykSonotaTkyk.SKNNKAISIKITKKBN)
    public C_SknnkaisikitkKbn getSknnkaisikitkkbn() {
        return sknnkaisikitkkbn;
    }

    public void setSknnkaisikitkkbn(C_SknnkaisikitkKbn pSknnkaisikitkkbn) {
        sknnkaisikitkkbn = pSknnkaisikitkkbn;
    }

    private C_UmuKbn nstkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.NSTKHKUMU)
    public C_UmuKbn getNstkhkumu() {
        return nstkhkumu;
    }

    public void setNstkhkumu(C_UmuKbn pNstkhkumu) {
        nstkhkumu = pNstkhkumu;
    }

    private BizDate nkshrtkykhenkoymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.NKSHRTKYKHENKOYMD)
    @ValidDate
    public BizDate getNkshrtkykhenkoymd() {
        return nkshrtkykhenkoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkshrtkykhenkoymd(BizDate pNkshrtkykhenkoymd) {
        nkshrtkykhenkoymd = pNkshrtkykhenkoymd;
    }

    private C_Nstknsyu nkshrtkyknksyukbn;

    @Type(type="UserType_C_Nstknsyu")
    @Column(name=GenIT_KykSonotaTkyk.NKSHRTKYKNKSYUKBN)
    public C_Nstknsyu getNkshrtkyknksyukbn() {
        return nkshrtkyknksyukbn;
    }

    public void setNkshrtkyknksyukbn(C_Nstknsyu pNkshrtkyknksyukbn) {
        nkshrtkyknksyukbn = pNkshrtkyknksyukbn;
    }

    private Integer nkshrtkyknksyukkn;

    @Column(name=GenIT_KykSonotaTkyk.NKSHRTKYKNKSYUKKN)
    @Range(min="0", max="99")
    public Integer getNkshrtkyknksyukkn() {
        return nkshrtkyknksyukkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkshrtkyknksyukkn(Integer pNkshrtkyknksyukkn) {
        nkshrtkyknksyukkn = pNkshrtkyknksyukkn;
    }

    private C_UmuKbn initsbjiyensitihsytkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.INITSBJIYENSITIHSYTKHUKAUMU)
    public C_UmuKbn getInitsbjiyensitihsytkhukaumu() {
        return initsbjiyensitihsytkhukaumu;
    }

    public void setInitsbjiyensitihsytkhukaumu(C_UmuKbn pInitsbjiyensitihsytkhukaumu) {
        initsbjiyensitihsytkhukaumu = pInitsbjiyensitihsytkhukaumu;
    }

    private BizCurrency initsbjiyenkasaiteihsygk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getInitsbjiyenkasaiteihsygk() {
        return initsbjiyenkasaiteihsygk;
    }

    public void setInitsbjiyenkasaiteihsygk(BizCurrency pInitsbjiyenkasaiteihsygk) {
        initsbjiyenkasaiteihsygk = pInitsbjiyenkasaiteihsygk;
        initsbjiyenkasaiteihsygkValue = null;
        initsbjiyenkasaiteihsygkType  = null;
    }

    transient private BigDecimal initsbjiyenkasaiteihsygkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=INITSBJIYENKASAITEIHSYGK, nullable=true)
    protected BigDecimal getInitsbjiyenkasaiteihsygkValue() {
        if (initsbjiyenkasaiteihsygkValue == null && initsbjiyenkasaiteihsygk != null) {
            if (initsbjiyenkasaiteihsygk.isOptional()) return null;
            return initsbjiyenkasaiteihsygk.absolute();
        }
        return initsbjiyenkasaiteihsygkValue;
    }

    protected void setInitsbjiyenkasaiteihsygkValue(BigDecimal value) {
        initsbjiyenkasaiteihsygkValue = value;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    transient private String initsbjiyenkasaiteihsygkType = null;

    @Column(name=INITSBJIYENKASAITEIHSYGK + "$", nullable=true)
    protected String getInitsbjiyenkasaiteihsygkType() {
        if (initsbjiyenkasaiteihsygkType == null && initsbjiyenkasaiteihsygk != null) return initsbjiyenkasaiteihsygk.getType().toString();
        if (initsbjiyenkasaiteihsygkType == null && getInitsbjiyenkasaiteihsygkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'initsbjiyenkasaiteihsygk$' should not be NULL."));
        }
        return initsbjiyenkasaiteihsygkType;
    }

    protected void setInitsbjiyenkasaiteihsygkType(String type) {
        initsbjiyenkasaiteihsygkType = type;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    private C_UmuKbn jyudkaigomeharaitkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.JYUDKAIGOMEHARAITKHUKAUMU)
    public C_UmuKbn getJyudkaigomeharaitkhukaumu() {
        return jyudkaigomeharaitkhukaumu;
    }

    public void setJyudkaigomeharaitkhukaumu(C_UmuKbn pJyudkaigomeharaitkhukaumu) {
        jyudkaigomeharaitkhukaumu = pJyudkaigomeharaitkhukaumu;
    }

    private BizDate jyudkaigomeharaitkhukaymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.JYUDKAIGOMEHARAITKHUKAYMD)
    public BizDate getJyudkaigomeharaitkhukaymd() {
        return jyudkaigomeharaitkhukaymd;
    }

    public void setJyudkaigomeharaitkhukaymd(BizDate pJyudkaigomeharaitkhukaymd) {
        jyudkaigomeharaitkhukaymd = pJyudkaigomeharaitkhukaymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KykSonotaTkyk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KykSonotaTkyk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KykSonotaTkyk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private BizDate targettkykhkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.TARGETTKYKHKYMD)
    @ValidDate
    public BizDate getTargettkykhkymd() {
        return targettkykhkymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTargettkykhkymd(BizDate pTargettkykhkymd) {
        targettkykhkymd = pTargettkykhkymd;
    }

    private BizCurrency targettkykkijyungk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTargettkykkijyungk() {
        return targettkykkijyungk;
    }

    public void setTargettkykkijyungk(BizCurrency pTargettkykkijyungk) {
        targettkykkijyungk = pTargettkykkijyungk;
        targettkykkijyungkValue = null;
        targettkykkijyungkType  = null;
    }

    transient private BigDecimal targettkykkijyungkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TARGETTKYKKIJYUNGK, nullable=true)
    protected BigDecimal getTargettkykkijyungkValue() {
        if (targettkykkijyungkValue == null && targettkykkijyungk != null) {
            if (targettkykkijyungk.isOptional()) return null;
            return targettkykkijyungk.absolute();
        }
        return targettkykkijyungkValue;
    }

    protected void setTargettkykkijyungkValue(BigDecimal value) {
        targettkykkijyungkValue = value;
        targettkykkijyungk = Optional.fromNullable(toCurrencyType(targettkykkijyungkType))
            .transform(bizCurrencyTransformer(getTargettkykkijyungkValue()))
            .orNull();
    }

    transient private String targettkykkijyungkType = null;

    @Column(name=TARGETTKYKKIJYUNGK + "$", nullable=true)
    protected String getTargettkykkijyungkType() {
        if (targettkykkijyungkType == null && targettkykkijyungk != null) return targettkykkijyungk.getType().toString();
        if (targettkykkijyungkType == null && getTargettkykkijyungkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'targettkykkijyungk$' should not be NULL."));
        }
        return targettkykkijyungkType;
    }

    protected void setTargettkykkijyungkType(String type) {
        targettkykkijyungkType = type;
        targettkykkijyungk = Optional.fromNullable(toCurrencyType(targettkykkijyungkType))
            .transform(bizCurrencyTransformer(getTargettkykkijyungkValue()))
            .orNull();
    }

    private C_UmuKbn zeiseitkkktkykhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.ZEISEITKKKTKYKHUKAUMU)
    public C_UmuKbn getZeiseitkkktkykhukaumu() {
        return zeiseitkkktkykhukaumu;
    }

    public void setZeiseitkkktkykhukaumu(C_UmuKbn pZeiseitkkktkykhukaumu) {
        zeiseitkkktkykhukaumu = pZeiseitkkktkykhukaumu;
    }

    private BizDate zeiseitkkktkykhukaymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.ZEISEITKKKTKYKHUKAYMD)
    @ValidDate
    public BizDate getZeiseitkkktkykhukaymd() {
        return zeiseitkkktkykhukaymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZeiseitkkktkykhukaymd(BizDate pZeiseitkkktkykhukaymd) {
        zeiseitkkktkykhukaymd = pZeiseitkkktkykhukaymd;
    }

    private BizDate zeiseitkkktkyksyoumetuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.ZEISEITKKKTKYKSYOUMETUYMD)
    @ValidDate
    public BizDate getZeiseitkkktkyksyoumetuymd() {
        return zeiseitkkktkyksyoumetuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZeiseitkkktkyksyoumetuymd(BizDate pZeiseitkkktkyksyoumetuymd) {
        zeiseitkkktkyksyoumetuymd = pZeiseitkkktkyksyoumetuymd;
    }

    private C_YennykntksyuruiKbn yennyknsyuruikbn;

    @Type(type="UserType_C_YennykntksyuruiKbn")
    @Column(name=GenIT_KykSonotaTkyk.YENNYKNSYURUIKBN)
    public C_YennykntksyuruiKbn getYennyknsyuruikbn() {
        return yennyknsyuruikbn;
    }

    public void setYennyknsyuruikbn(C_YennykntksyuruiKbn pYennyknsyuruikbn) {
        yennyknsyuruikbn = pYennyknsyuruikbn;
    }

    private C_UmuKbn kykdrtkykhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.KYKDRTKYKHUKAUMU)
    public C_UmuKbn getKykdrtkykhukaumu() {
        return kykdrtkykhukaumu;
    }

    public void setKykdrtkykhukaumu(C_UmuKbn pKykdrtkykhukaumu) {
        kykdrtkykhukaumu = pKykdrtkykhukaumu;
    }

    private BizDate kykdrtkykhukaymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.KYKDRTKYKHUKAYMD)
    @ValidDate
    public BizDate getKykdrtkykhukaymd() {
        return kykdrtkykhukaymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdrtkykhukaymd(BizDate pKykdrtkykhukaymd) {
        kykdrtkykhukaymd = pKykdrtkykhukaymd;
    }

    private BizDate kykdrtkykkaiyakuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSonotaTkyk.KYKDRTKYKKAIYAKUYMD)
    @ValidDate
    public BizDate getKykdrtkykkaiyakuymd() {
        return kykdrtkykkaiyakuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdrtkykkaiyakuymd(BizDate pKykdrtkykkaiyakuymd) {
        kykdrtkykkaiyakuymd = pKykdrtkykkaiyakuymd;
    }

    private C_UmuKbn teikishrtkykhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSonotaTkyk.TEIKISHRTKYKHUKAUMU)
    public C_UmuKbn getTeikishrtkykhukaumu() {
        return teikishrtkykhukaumu;
    }

    public void setTeikishrtkykhukaumu(C_UmuKbn pTeikishrtkykhukaumu) {
        teikishrtkykhukaumu = pTeikishrtkykhukaumu;
    }

    private C_Tuukasyu teikishrkinshrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_KykSonotaTkyk.TEIKISHRKINSHRTUUKASYU)
    public C_Tuukasyu getTeikishrkinshrtuukasyu() {
        return teikishrkinshrtuukasyu;
    }

    public void setTeikishrkinshrtuukasyu(C_Tuukasyu pTeikishrkinshrtuukasyu) {
        teikishrkinshrtuukasyu = pTeikishrkinshrtuukasyu;
    }

    private BizDateMD teikishrkinshrmd;

    @Type(type="BizDateMDType")
    @Column(name=GenIT_KykSonotaTkyk.TEIKISHRKINSHRMD)
    public BizDateMD getTeikishrkinshrmd() {
        return teikishrkinshrmd;
    }

    public void setTeikishrkinshrmd(BizDateMD pTeikishrkinshrmd) {
        teikishrkinshrmd = pTeikishrkinshrmd;
    }
}