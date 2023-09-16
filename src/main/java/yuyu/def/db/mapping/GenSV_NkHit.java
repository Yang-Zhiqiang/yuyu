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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.NaturalNumberBizCalcable;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_AnnaiKbn;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknhouskKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_NenkinJimuTesuuryouKbn;
import yuyu.def.classification.C_NenkinKbn;
import yuyu.def.classification.C_NenkinKigouSedaiKbn;
import yuyu.def.classification.C_NenreiCalcKbn;
import yuyu.def.classification.C_NkGnsKbn;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_Nkshrhsijiyuu;
import yuyu.def.classification.C_Nkshrjk;
import yuyu.def.classification.C_Nkukthou;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Sznjk;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_NkHit;
import yuyu.def.db.id.PKSV_NkHit;
import yuyu.def.db.meta.GenQSV_NkHit;
import yuyu.def.db.meta.QSV_NkHit;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_AnnaiKbn;
import yuyu.def.db.type.UserType_C_Bnshrkaisuu;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknhouskKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_NenkinJimuTesuuryouKbn;
import yuyu.def.db.type.UserType_C_NenkinKbn;
import yuyu.def.db.type.UserType_C_NenkinKigouSedaiKbn;
import yuyu.def.db.type.UserType_C_NenreiCalcKbn;
import yuyu.def.db.type.UserType_C_NkGnsKbn;
import yuyu.def.db.type.UserType_C_NkHaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_NkSyoumetuCd;
import yuyu.def.db.type.UserType_C_Nkshrhsijiyuu;
import yuyu.def.db.type.UserType_C_Nkshrjk;
import yuyu.def.db.type.UserType_C_Nkukthou;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Sznjk;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.NenkinSyousyoNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 年金配当所要額ビュー テーブルのマッピング情報クラスで、 {@link SV_NkHit} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_NkHit}</td><td colspan="3">年金配当所要額ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRenno8keta renno8keta}</td><td>連番（８桁）</td><td align="center">{@link PKSV_NkHit ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSznjk sznjk}</td><td>生存状況</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sznjk}</td></tr>
 *  <tr><td>{@link #getSeisikakymd seisikakymd}</td><td>生死確認日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNksysyno nksysyno}</td><td>年金証書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkkknsetymd nkkknsetymd}</td><td>年金基金設定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkshrstartymd nkshrstartymd}</td><td>年金支払開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkkknmanryouymd nkkknmanryouymd}</td><td>年金期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBnshrkaisuu bnshrkaisuu}</td><td>分割支払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Bnshrkaisuu}</td></tr>
 *  <tr><td>{@link #getJinendobnshrkaisuu jinendobnshrkaisuu}</td><td>次年度分割支払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Bnshrkaisuu}</td></tr>
 *  <tr><td>{@link #getNkukthou nkukthou}</td><td>年金受取方法</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nkukthou}</td></tr>
 *  <tr><td>{@link #getNkshrhsijiyuu nkshrhsijiyuu}</td><td>年金支払発生事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nkshrhsijiyuu}</td></tr>
 *  <tr><td>{@link #getNextnsymd nextnsymd}</td><td>次回年金支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNextnkshrkjt nextnkshrkjt}</td><td>次回年金支払期日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNextshryoteisakuseiymd nextshryoteisakuseiymd}</td><td>次回支払予定作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNexthurikaeymd nexthurikaeymd}</td><td>次回振替日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkshrjk nkshrjk}</td><td>年金支払状況</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nkshrjk}</td></tr>
 *  <tr><td>{@link #getNksyoumetucd nksyoumetucd}</td><td>年金消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NkSyoumetuCd}</td></tr>
 *  <tr><td>{@link #getSyoumetuymd syoumetuymd}</td><td>消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getIktumu iktumu}</td><td>一括支払有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNksysyhkymd nksysyhkymd}</td><td>年金証書発行日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNksysysaihkymd nksysysaihkymd}</td><td>年金証書再発行日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSsnannaisksiymd ssnannaisksiymd}</td><td>最新案内作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAnnaikbn annaikbn}</td><td>案内区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AnnaiKbn}</td></tr>
 *  <tr><td>{@link #getOyadairitencd1 oyadairitencd1}</td><td>親代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitencd1 dairitencd1}</td><td>代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd1 bosyuucd1}</td><td>募集人コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitenbuntanwariai1 dairitenbuntanwariai1}</td><td>代理店分担割合１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getOyadairitencd2 oyadairitencd2}</td><td>親代理店コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitencd2 dairitencd2}</td><td>代理店コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd2 bosyuucd2}</td><td>募集人コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitenbuntanwariai2 dairitenbuntanwariai2}</td><td>代理店分担割合２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd1 drtenkanrisosikicd1}</td><td>代理店管理組織コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanritodoufukencd drtenkanritodoufukencd}</td><td>代理店管理都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCifcd cifcd}</td><td>ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMotosyono motosyono}</td><td>元証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getAisyoumeikbn aisyoumeikbn}</td><td>愛称名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AisyoumeiKbn}</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHknhouskkbn hknhouskkbn}</td><td>保険法施行区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknhouskKbn}</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getYenshrtkumukbn yenshrtkumukbn}</td><td>円支払特約有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getStdrsktky stdrsktky}</td><td>指定代理請求特約</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKeizknenkinuktsiteitk keizknenkinuktsiteitk}</td><td>継続年金受取人指定特約</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getTeisyutkykbn teisyutkykbn}</td><td>定額年金主契約特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getNenkinkbn nenkinkbn}</td><td>年金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenkinKbn}</td></tr>
 *  <tr><td>{@link #getTeinksyu teinksyu}</td><td>定額年金年金種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTeinksyuruiversion teinksyuruiversion}</td><td>定額年金年金種類バージョン</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkigousedaikbn nenkinkigousedaikbn}</td><td>年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenkinKigouSedaiKbn}</td></tr>
 *  <tr><td>{@link #getTeinkspan teinkspan}</td><td>定額年金年金期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTeikihongk teikihongk}</td><td>定額年金基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTeihitukeihiyen teihitukeihiyen}</td><td>定額年金必要経費（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTeihitukeihigaika teihitukeihigaika}</td><td>定額年金必要経費（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTeihyounkspan teihyounkspan}</td><td>定額年金評価年金期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTeinkkikingk teinkkikingk}</td><td>定額年金年金基金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNkgnskbn nkgnskbn}</td><td>年金原資区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NkGnsKbn}</td></tr>
 *  <tr><td>{@link #getNenkinkaisigoyoteiriritukbn nenkinkaisigoyoteiriritukbn}</td><td>年金開始後予定利率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinjimutesuuryoukbn nenkinjimutesuuryoukbn}</td><td>年金事務手数料区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenkinJimuTesuuryouKbn}</td></tr>
 *  <tr><td>{@link #getKyktumitateriritu kyktumitateriritu}</td><td>契約時積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTumitateriritu tumitateriritu}</td><td>積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTumitatekijyunymd tumitatekijyunymd}</td><td>積立利率基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTumitatekijyunnen tumitatekijyunnen}</td><td>積立利率基準年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTumitatekijyunkkn tumitatekijyunkkn}</td><td>積立利率基準期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getFstinymd fstinymd}</td><td>初回取込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkhaitoukinuketorihoukbn nkhaitoukinuketorihoukbn}</td><td>年金配当金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NkHaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>{@link #getNenreicalckbn nenreicalckbn}</td><td>年齢計算区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenreiCalcKbn}</td></tr>
 *  <tr><td>{@link #getHhknnmkn hhknnmkn}</td><td>被保険者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknadrkj hhknadrkj}</td><td>被保険者住所（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknsakuinmeino hhknsakuinmeino}</td><td>被保険者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     SV_NkHit
 * @see     PKSV_NkHit
 * @see     QSV_NkHit
 * @see     GenQSV_NkHit
 */
@MappedSuperclass
@Table(name=GenSV_NkHit.TABLE_NAME)
@IdClass(value=PKSV_NkHit.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_AisyoumeiKbn", typeClass=UserType_C_AisyoumeiKbn.class),
    @TypeDef(name="UserType_C_AnnaiKbn", typeClass=UserType_C_AnnaiKbn.class),
    @TypeDef(name="UserType_C_Bnshrkaisuu", typeClass=UserType_C_Bnshrkaisuu.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_HknhouskKbn", typeClass=UserType_C_HknhouskKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_NenkinJimuTesuuryouKbn", typeClass=UserType_C_NenkinJimuTesuuryouKbn.class),
    @TypeDef(name="UserType_C_NenkinKbn", typeClass=UserType_C_NenkinKbn.class),
    @TypeDef(name="UserType_C_NenkinKigouSedaiKbn", typeClass=UserType_C_NenkinKigouSedaiKbn.class),
    @TypeDef(name="UserType_C_NenreiCalcKbn", typeClass=UserType_C_NenreiCalcKbn.class),
    @TypeDef(name="UserType_C_NkGnsKbn", typeClass=UserType_C_NkGnsKbn.class),
    @TypeDef(name="UserType_C_NkHaitoukinuketorihouKbn", typeClass=UserType_C_NkHaitoukinuketorihouKbn.class),
    @TypeDef(name="UserType_C_NkSyoumetuCd", typeClass=UserType_C_NkSyoumetuCd.class),
    @TypeDef(name="UserType_C_Nkshrhsijiyuu", typeClass=UserType_C_Nkshrhsijiyuu.class),
    @TypeDef(name="UserType_C_Nkshrjk", typeClass=UserType_C_Nkshrjk.class),
    @TypeDef(name="UserType_C_Nkukthou", typeClass=UserType_C_Nkukthou.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_Sznjk", typeClass=UserType_C_Sznjk.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenSV_NkHit extends AbstractExDBEntity<SV_NkHit, PKSV_NkHit> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "SV_NkHit";
    public static final String RENNO8KETA               = "renno8keta";
    public static final String SZNJK                    = "sznjk";
    public static final String SEISIKAKYMD              = "seisikakymd";
    public static final String NKSYSYNO                 = "nksysyno";
    public static final String NKKKNSETYMD              = "nkkknsetymd";
    public static final String NKSHRSTARTYMD            = "nkshrstartymd";
    public static final String NKKKNMANRYOUYMD          = "nkkknmanryouymd";
    public static final String BNSHRKAISUU              = "bnshrkaisuu";
    public static final String JINENDOBNSHRKAISUU       = "jinendobnshrkaisuu";
    public static final String NKUKTHOU                 = "nkukthou";
    public static final String NKSHRHSIJIYUU            = "nkshrhsijiyuu";
    public static final String NEXTNSYMD                = "nextnsymd";
    public static final String NEXTNKSHRKJT             = "nextnkshrkjt";
    public static final String NEXTSHRYOTEISAKUSEIYMD   = "nextshryoteisakuseiymd";
    public static final String NEXTHURIKAEYMD           = "nexthurikaeymd";
    public static final String NKSHRJK                  = "nkshrjk";
    public static final String NKSYOUMETUCD             = "nksyoumetucd";
    public static final String SYOUMETUYMD              = "syoumetuymd";
    public static final String IKTUMU                   = "iktumu";
    public static final String NKSYSYHKYMD              = "nksysyhkymd";
    public static final String NKSYSYSAIHKYMD           = "nksysysaihkymd";
    public static final String SSNANNAISKSIYMD          = "ssnannaisksiymd";
    public static final String ANNAIKBN                 = "annaikbn";
    public static final String OYADAIRITENCD1           = "oyadairitencd1";
    public static final String DAIRITENCD1              = "dairitencd1";
    public static final String BOSYUUCD1                = "bosyuucd1";
    public static final String DAIRITENBUNTANWARIAI1    = "dairitenbuntanwariai1";
    public static final String OYADAIRITENCD2           = "oyadairitencd2";
    public static final String DAIRITENCD2              = "dairitencd2";
    public static final String BOSYUUCD2                = "bosyuucd2";
    public static final String DAIRITENBUNTANWARIAI2    = "dairitenbuntanwariai2";
    public static final String DRTENKANRISOSIKICD1      = "drtenkanrisosikicd1";
    public static final String DRTENKANRITODOUFUKENCD   = "drtenkanritodoufukencd";
    public static final String CIFCD                    = "cifcd";
    public static final String MOTOSYONO                = "motosyono";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String AISYOUMEIKBN             = "aisyoumeikbn";
    public static final String KYKYMD                   = "kykymd";
    public static final String HKNHOUSKKBN              = "hknhouskkbn";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String YENSHRTKUMUKBN           = "yenshrtkumukbn";
    public static final String STDRSKTKY                = "stdrsktky";
    public static final String KEIZKNENKINUKTSITEITK    = "keizknenkinuktsiteitk";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String TEISYUTKYKBN             = "teisyutkykbn";
    public static final String NENKINKBN                = "nenkinkbn";
    public static final String TEINKSYU                 = "teinksyu";
    public static final String TEINKSYURUIVERSION       = "teinksyuruiversion";
    public static final String NENKINKIGOUSEDAIKBN      = "nenkinkigousedaikbn";
    public static final String TEINKSPAN                = "teinkspan";
    public static final String TEIKIHONGK               = "teikihongk";
    public static final String TEIHITUKEIHIYEN          = "teihitukeihiyen";
    public static final String TEIHITUKEIHIGAIKA        = "teihitukeihigaika";
    public static final String TEIHYOUNKSPAN            = "teihyounkspan";
    public static final String TEINKKIKINGK             = "teinkkikingk";
    public static final String NKGNSKBN                 = "nkgnskbn";
    public static final String NENKINKAISIGOYOTEIRIRITUKBN = "nenkinkaisigoyoteiriritukbn";
    public static final String NENKINJIMUTESUURYOUKBN   = "nenkinjimutesuuryoukbn";
    public static final String KYKTUMITATERIRITU        = "kyktumitateriritu";
    public static final String TUMITATERIRITU           = "tumitateriritu";
    public static final String TUMITATEKIJYUNYMD        = "tumitatekijyunymd";
    public static final String TUMITATEKIJYUNNEN        = "tumitatekijyunnen";
    public static final String TUMITATEKIJYUNKKN        = "tumitatekijyunkkn";
    public static final String FSTINYMD                 = "fstinymd";
    public static final String NKHAITOUKINUKETORIHOUKBN = "nkhaitoukinuketorihoukbn";
    public static final String NENREICALCKBN            = "nenreicalckbn";
    public static final String HHKNNMKN                 = "hhknnmkn";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNADRKJ                = "hhknadrkj";
    public static final String HHKNSAKUINMEINO          = "hhknsakuinmeino";

    private final PKSV_NkHit primaryKey;

    public GenSV_NkHit() {
        primaryKey = new PKSV_NkHit();
    }

    public GenSV_NkHit(Integer pRenno8keta) {
        primaryKey = new PKSV_NkHit(pRenno8keta);
    }

    @Transient
    @Override
    public PKSV_NkHit getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QSV_NkHit> getMetaClass() {
        return QSV_NkHit.class;
    }

    @Id
    @Column(name=GenSV_NkHit.RENNO8KETA)
    public Integer getRenno8keta() {
        return getPrimaryKey().getRenno8keta();
    }

    public void setRenno8keta(Integer pRenno8keta) {
        getPrimaryKey().setRenno8keta(pRenno8keta);
    }

    private C_Sznjk sznjk;

    @Type(type="UserType_C_Sznjk")
    @Column(name=GenSV_NkHit.SZNJK)
    public C_Sznjk getSznjk() {
        return sznjk;
    }

    public void setSznjk(C_Sznjk pSznjk) {
        sznjk = pSznjk;
    }

    private BizDate seisikakymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.SEISIKAKYMD)
    @ValidDate
    public BizDate getSeisikakymd() {
        return seisikakymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSeisikakymd(BizDate pSeisikakymd) {
        seisikakymd = pSeisikakymd;
    }

    private String nksysyno;

    @Column(name=GenSV_NkHit.NKSYSYNO)
    @NenkinSyousyoNo
    public String getNksysyno() {
        return nksysyno;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setNksysyno(String pNksysyno) {
        nksysyno = pNksysyno;
    }

    private BizDate nkkknsetymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.NKKKNSETYMD)
    @ValidDate
    public BizDate getNkkknsetymd() {
        return nkkknsetymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkkknsetymd(BizDate pNkkknsetymd) {
        nkkknsetymd = pNkkknsetymd;
    }

    private BizDate nkshrstartymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.NKSHRSTARTYMD)
    public BizDate getNkshrstartymd() {
        return nkshrstartymd;
    }

    @Trim("both")
    public void setNkshrstartymd(BizDate pNkshrstartymd) {
        nkshrstartymd = pNkshrstartymd;
    }

    private BizDate nkkknmanryouymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.NKKKNMANRYOUYMD)
    public BizDate getNkkknmanryouymd() {
        return nkkknmanryouymd;
    }

    public void setNkkknmanryouymd(BizDate pNkkknmanryouymd) {
        nkkknmanryouymd = pNkkknmanryouymd;
    }

    private C_Bnshrkaisuu bnshrkaisuu;

    @Type(type="UserType_C_Bnshrkaisuu")
    @Column(name=GenSV_NkHit.BNSHRKAISUU)
    public C_Bnshrkaisuu getBnshrkaisuu() {
        return bnshrkaisuu;
    }

    public void setBnshrkaisuu(C_Bnshrkaisuu pBnshrkaisuu) {
        bnshrkaisuu = pBnshrkaisuu;
    }

    private C_Bnshrkaisuu jinendobnshrkaisuu;

    @Type(type="UserType_C_Bnshrkaisuu")
    @Column(name=GenSV_NkHit.JINENDOBNSHRKAISUU)
    public C_Bnshrkaisuu getJinendobnshrkaisuu() {
        return jinendobnshrkaisuu;
    }

    public void setJinendobnshrkaisuu(C_Bnshrkaisuu pJinendobnshrkaisuu) {
        jinendobnshrkaisuu = pJinendobnshrkaisuu;
    }

    private C_Nkukthou nkukthou;

    @Type(type="UserType_C_Nkukthou")
    @Column(name=GenSV_NkHit.NKUKTHOU)
    public C_Nkukthou getNkukthou() {
        return nkukthou;
    }

    public void setNkukthou(C_Nkukthou pNkukthou) {
        nkukthou = pNkukthou;
    }

    private C_Nkshrhsijiyuu nkshrhsijiyuu;

    @Type(type="UserType_C_Nkshrhsijiyuu")
    @Column(name=GenSV_NkHit.NKSHRHSIJIYUU)
    public C_Nkshrhsijiyuu getNkshrhsijiyuu() {
        return nkshrhsijiyuu;
    }

    public void setNkshrhsijiyuu(C_Nkshrhsijiyuu pNkshrhsijiyuu) {
        nkshrhsijiyuu = pNkshrhsijiyuu;
    }

    private BizDate nextnsymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.NEXTNSYMD)
    @ValidDate
    public BizDate getNextnsymd() {
        return nextnsymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNextnsymd(BizDate pNextnsymd) {
        nextnsymd = pNextnsymd;
    }

    private BizDate nextnkshrkjt;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.NEXTNKSHRKJT)
    @ValidDate
    public BizDate getNextnkshrkjt() {
        return nextnkshrkjt;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNextnkshrkjt(BizDate pNextnkshrkjt) {
        nextnkshrkjt = pNextnkshrkjt;
    }

    private BizDate nextshryoteisakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.NEXTSHRYOTEISAKUSEIYMD)
    @ValidDate
    public BizDate getNextshryoteisakuseiymd() {
        return nextshryoteisakuseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNextshryoteisakuseiymd(BizDate pNextshryoteisakuseiymd) {
        nextshryoteisakuseiymd = pNextshryoteisakuseiymd;
    }

    private BizDate nexthurikaeymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.NEXTHURIKAEYMD)
    public BizDate getNexthurikaeymd() {
        return nexthurikaeymd;
    }

    public void setNexthurikaeymd(BizDate pNexthurikaeymd) {
        nexthurikaeymd = pNexthurikaeymd;
    }

    private C_Nkshrjk nkshrjk;

    @Type(type="UserType_C_Nkshrjk")
    @Column(name=GenSV_NkHit.NKSHRJK)
    public C_Nkshrjk getNkshrjk() {
        return nkshrjk;
    }

    public void setNkshrjk(C_Nkshrjk pNkshrjk) {
        nkshrjk = pNkshrjk;
    }

    private C_NkSyoumetuCd nksyoumetucd;

    @Type(type="UserType_C_NkSyoumetuCd")
    @Column(name=GenSV_NkHit.NKSYOUMETUCD)
    public C_NkSyoumetuCd getNksyoumetucd() {
        return nksyoumetucd;
    }

    public void setNksyoumetucd(C_NkSyoumetuCd pNksyoumetucd) {
        nksyoumetucd = pNksyoumetucd;
    }

    private BizDate syoumetuymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.SYOUMETUYMD)
    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    private C_UmuKbn iktumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_NkHit.IKTUMU)
    public C_UmuKbn getIktumu() {
        return iktumu;
    }

    public void setIktumu(C_UmuKbn pIktumu) {
        iktumu = pIktumu;
    }

    private BizDate nksysyhkymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.NKSYSYHKYMD)
    @ValidDate
    public BizDate getNksysyhkymd() {
        return nksysyhkymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNksysyhkymd(BizDate pNksysyhkymd) {
        nksysyhkymd = pNksysyhkymd;
    }

    private BizDate nksysysaihkymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.NKSYSYSAIHKYMD)
    @ValidDate
    public BizDate getNksysysaihkymd() {
        return nksysysaihkymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNksysysaihkymd(BizDate pNksysysaihkymd) {
        nksysysaihkymd = pNksysysaihkymd;
    }

    private BizDate ssnannaisksiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.SSNANNAISKSIYMD)
    @ValidDate
    public BizDate getSsnannaisksiymd() {
        return ssnannaisksiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSsnannaisksiymd(BizDate pSsnannaisksiymd) {
        ssnannaisksiymd = pSsnannaisksiymd;
    }

    private C_AnnaiKbn annaikbn;

    @Type(type="UserType_C_AnnaiKbn")
    @Column(name=GenSV_NkHit.ANNAIKBN)
    public C_AnnaiKbn getAnnaikbn() {
        return annaikbn;
    }

    public void setAnnaikbn(C_AnnaiKbn pAnnaikbn) {
        annaikbn = pAnnaikbn;
    }

    private String oyadairitencd1;

    @Column(name=GenSV_NkHit.OYADAIRITENCD1)
    @MaxLength(max=7)
    @AlphaDigit
    public String getOyadairitencd1() {
        return oyadairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadairitencd1(String pOyadairitencd1) {
        oyadairitencd1 = pOyadairitencd1;
    }

    private String dairitencd1;

    @Column(name=GenSV_NkHit.DAIRITENCD1)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd1() {
        return dairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd1(String pDairitencd1) {
        dairitencd1 = pDairitencd1;
    }

    private String bosyuucd1;

    @Column(name=GenSV_NkHit.BOSYUUCD1)
    @MaxLength(max=6)
    @AlphaDigit
    public String getBosyuucd1() {
        return bosyuucd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd1(String pBosyuucd1) {
        bosyuucd1 = pBosyuucd1;
    }

    private BizNumber dairitenbuntanwariai1;

    @Type(type="BizNumberType")
    @Column(name=GenSV_NkHit.DAIRITENBUNTANWARIAI1)
    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    public BizNumber getDairitenbuntanwariai1() {
        return dairitenbuntanwariai1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenbuntanwariai1(BizNumber pDairitenbuntanwariai1) {
        dairitenbuntanwariai1 = pDairitenbuntanwariai1;
    }

    private String oyadairitencd2;

    @Column(name=GenSV_NkHit.OYADAIRITENCD2)
    @MaxLength(max=7)
    @AlphaDigit
    public String getOyadairitencd2() {
        return oyadairitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadairitencd2(String pOyadairitencd2) {
        oyadairitencd2 = pOyadairitencd2;
    }

    private String dairitencd2;

    @Column(name=GenSV_NkHit.DAIRITENCD2)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd2() {
        return dairitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd2(String pDairitencd2) {
        dairitencd2 = pDairitencd2;
    }

    private String bosyuucd2;

    @Column(name=GenSV_NkHit.BOSYUUCD2)
    @MaxLength(max=6)
    @AlphaDigit
    public String getBosyuucd2() {
        return bosyuucd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd2(String pBosyuucd2) {
        bosyuucd2 = pBosyuucd2;
    }

    private BizNumber dairitenbuntanwariai2;

    @Type(type="BizNumberType")
    @Column(name=GenSV_NkHit.DAIRITENBUNTANWARIAI2)
    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    public BizNumber getDairitenbuntanwariai2() {
        return dairitenbuntanwariai2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenbuntanwariai2(BizNumber pDairitenbuntanwariai2) {
        dairitenbuntanwariai2 = pDairitenbuntanwariai2;
    }

    private String drtenkanrisosikicd1;

    @Column(name=GenSV_NkHit.DRTENKANRISOSIKICD1)
    @MaxLength(max=7)
    @SingleByteStrings
    public String getDrtenkanrisosikicd1() {
        return drtenkanrisosikicd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtenkanrisosikicd1(String pDrtenkanrisosikicd1) {
        drtenkanrisosikicd1 = pDrtenkanrisosikicd1;
    }

    private String drtenkanritodoufukencd;

    @Column(name=GenSV_NkHit.DRTENKANRITODOUFUKENCD)
    public String getDrtenkanritodoufukencd() {
        return drtenkanritodoufukencd;
    }

    public void setDrtenkanritodoufukencd(String pDrtenkanritodoufukencd) {
        drtenkanritodoufukencd = pDrtenkanritodoufukencd;
    }

    private String cifcd;

    @Column(name=GenSV_NkHit.CIFCD)
    @MaxLength(max=15)
    @AlphaDigit
    public String getCifcd() {
        return cifcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd(String pCifcd) {
        cifcd = pCifcd;
    }

    private String motosyono;

    @Column(name=GenSV_NkHit.MOTOSYONO)
    @SyoukenNo
    public String getMotosyono() {
        return motosyono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMotosyono(String pMotosyono) {
        motosyono = pMotosyono;
    }

    private String syouhncd;

    @Column(name=GenSV_NkHit.SYOUHNCD)
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

    @Column(name=GenSV_NkHit.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private C_AisyoumeiKbn aisyoumeikbn;

    @Type(type="UserType_C_AisyoumeiKbn")
    @Column(name=GenSV_NkHit.AISYOUMEIKBN)
    public C_AisyoumeiKbn getAisyoumeikbn() {
        return aisyoumeikbn;
    }

    public void setAisyoumeikbn(C_AisyoumeiKbn pAisyoumeikbn) {
        aisyoumeikbn = pAisyoumeikbn;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_HknhouskKbn hknhouskkbn;

    @Type(type="UserType_C_HknhouskKbn")
    @Column(name=GenSV_NkHit.HKNHOUSKKBN)
    public C_HknhouskKbn getHknhouskkbn() {
        return hknhouskkbn;
    }

    public void setHknhouskkbn(C_HknhouskKbn pHknhouskkbn) {
        hknhouskkbn = pHknhouskkbn;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenSV_NkHit.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_UmuKbn yenshrtkumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_NkHit.YENSHRTKUMUKBN)
    public C_UmuKbn getYenshrtkumukbn() {
        return yenshrtkumukbn;
    }

    public void setYenshrtkumukbn(C_UmuKbn pYenshrtkumukbn) {
        yenshrtkumukbn = pYenshrtkumukbn;
    }

    private C_UmuKbn stdrsktky;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_NkHit.STDRSKTKY)
    public C_UmuKbn getStdrsktky() {
        return stdrsktky;
    }

    public void setStdrsktky(C_UmuKbn pStdrsktky) {
        stdrsktky = pStdrsktky;
    }

    private C_UmuKbn keizknenkinuktsiteitk;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_NkHit.KEIZKNENKINUKTSITEITK)
    public C_UmuKbn getKeizknenkinuktsiteitk() {
        return keizknenkinuktsiteitk;
    }

    public void setKeizknenkinuktsiteitk(C_UmuKbn pKeizknenkinuktsiteitk) {
        keizknenkinuktsiteitk = pKeizknenkinuktsiteitk;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenSV_NkHit.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_SyutkKbn teisyutkykbn;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenSV_NkHit.TEISYUTKYKBN)
    public C_SyutkKbn getTeisyutkykbn() {
        return teisyutkykbn;
    }

    public void setTeisyutkykbn(C_SyutkKbn pTeisyutkykbn) {
        teisyutkykbn = pTeisyutkykbn;
    }

    private C_NenkinKbn nenkinkbn;

    @Type(type="UserType_C_NenkinKbn")
    @Column(name=GenSV_NkHit.NENKINKBN)
    public C_NenkinKbn getNenkinkbn() {
        return nenkinkbn;
    }

    public void setNenkinkbn(C_NenkinKbn pNenkinkbn) {
        nenkinkbn = pNenkinkbn;
    }

    private String teinksyu;

    @Column(name=GenSV_NkHit.TEINKSYU)
    public String getTeinksyu() {
        return teinksyu;
    }

    public void setTeinksyu(String pTeinksyu) {
        teinksyu = pTeinksyu;
    }

    private String teinksyuruiversion;

    @Column(name=GenSV_NkHit.TEINKSYURUIVERSION)
    public String getTeinksyuruiversion() {
        return teinksyuruiversion;
    }

    public void setTeinksyuruiversion(String pTeinksyuruiversion) {
        teinksyuruiversion = pTeinksyuruiversion;
    }

    private C_NenkinKigouSedaiKbn nenkinkigousedaikbn;

    @Type(type="UserType_C_NenkinKigouSedaiKbn")
    @Column(name=GenSV_NkHit.NENKINKIGOUSEDAIKBN)
    public C_NenkinKigouSedaiKbn getNenkinkigousedaikbn() {
        return nenkinkigousedaikbn;
    }

    public void setNenkinkigousedaikbn(C_NenkinKigouSedaiKbn pNenkinkigousedaikbn) {
        nenkinkigousedaikbn = pNenkinkigousedaikbn;
    }

    private String teinkspan;

    @Column(name=GenSV_NkHit.TEINKSPAN)
    public String getTeinkspan() {
        return teinkspan;
    }

    public void setTeinkspan(String pTeinkspan) {
        teinkspan = pTeinkspan;
    }

    private BizCurrency teikihongk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeikihongk() {
        return teikihongk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTeikihongk(BizCurrency pTeikihongk) {
        teikihongk = pTeikihongk;
        teikihongkValue = null;
        teikihongkType  = null;
    }

    transient private BigDecimal teikihongkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEIKIHONGK, nullable=true)
    protected BigDecimal getTeikihongkValue() {
        if (teikihongkValue == null && teikihongk != null) {
            if (teikihongk.isOptional()) return null;
            return teikihongk.absolute();
        }
        return teikihongkValue;
    }

    protected void setTeikihongkValue(BigDecimal value) {
        teikihongkValue = value;
        teikihongk = Optional.fromNullable(toCurrencyType(teikihongkType))
            .transform(bizCurrencyTransformer(getTeikihongkValue()))
            .orNull();
    }

    transient private String teikihongkType = null;

    @Column(name=TEIKIHONGK + "$", nullable=true)
    protected String getTeikihongkType() {
        if (teikihongkType == null && teikihongk != null) return teikihongk.getType().toString();
        if (teikihongkType == null && getTeikihongkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teikihongk$' should not be NULL."));
        }
        return teikihongkType;
    }

    protected void setTeikihongkType(String type) {
        teikihongkType = type;
        teikihongk = Optional.fromNullable(toCurrencyType(teikihongkType))
            .transform(bizCurrencyTransformer(getTeikihongkValue()))
            .orNull();
    }

    private BizCurrency teihitukeihiyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeihitukeihiyen() {
        return teihitukeihiyen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTeihitukeihiyen(BizCurrency pTeihitukeihiyen) {
        teihitukeihiyen = pTeihitukeihiyen;
        teihitukeihiyenValue = null;
        teihitukeihiyenType  = null;
    }

    transient private BigDecimal teihitukeihiyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEIHITUKEIHIYEN, nullable=true)
    protected BigDecimal getTeihitukeihiyenValue() {
        if (teihitukeihiyenValue == null && teihitukeihiyen != null) {
            if (teihitukeihiyen.isOptional()) return null;
            return teihitukeihiyen.absolute();
        }
        return teihitukeihiyenValue;
    }

    protected void setTeihitukeihiyenValue(BigDecimal value) {
        teihitukeihiyenValue = value;
        teihitukeihiyen = Optional.fromNullable(toCurrencyType(teihitukeihiyenType))
            .transform(bizCurrencyTransformer(getTeihitukeihiyenValue()))
            .orNull();
    }

    transient private String teihitukeihiyenType = null;

    @Column(name=TEIHITUKEIHIYEN + "$", nullable=true)
    protected String getTeihitukeihiyenType() {
        if (teihitukeihiyenType == null && teihitukeihiyen != null) return teihitukeihiyen.getType().toString();
        if (teihitukeihiyenType == null && getTeihitukeihiyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teihitukeihiyen$' should not be NULL."));
        }
        return teihitukeihiyenType;
    }

    protected void setTeihitukeihiyenType(String type) {
        teihitukeihiyenType = type;
        teihitukeihiyen = Optional.fromNullable(toCurrencyType(teihitukeihiyenType))
            .transform(bizCurrencyTransformer(getTeihitukeihiyenValue()))
            .orNull();
    }

    private BizCurrency teihitukeihigaika;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeihitukeihigaika() {
        return teihitukeihigaika;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTeihitukeihigaika(BizCurrency pTeihitukeihigaika) {
        teihitukeihigaika = pTeihitukeihigaika;
        teihitukeihigaikaValue = null;
        teihitukeihigaikaType  = null;
    }

    transient private BigDecimal teihitukeihigaikaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEIHITUKEIHIGAIKA, nullable=true)
    protected BigDecimal getTeihitukeihigaikaValue() {
        if (teihitukeihigaikaValue == null && teihitukeihigaika != null) {
            if (teihitukeihigaika.isOptional()) return null;
            return teihitukeihigaika.absolute();
        }
        return teihitukeihigaikaValue;
    }

    protected void setTeihitukeihigaikaValue(BigDecimal value) {
        teihitukeihigaikaValue = value;
        teihitukeihigaika = Optional.fromNullable(toCurrencyType(teihitukeihigaikaType))
            .transform(bizCurrencyTransformer(getTeihitukeihigaikaValue()))
            .orNull();
    }

    transient private String teihitukeihigaikaType = null;

    @Column(name=TEIHITUKEIHIGAIKA + "$", nullable=true)
    protected String getTeihitukeihigaikaType() {
        if (teihitukeihigaikaType == null && teihitukeihigaika != null) return teihitukeihigaika.getType().toString();
        if (teihitukeihigaikaType == null && getTeihitukeihigaikaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teihitukeihigaika$' should not be NULL."));
        }
        return teihitukeihigaikaType;
    }

    protected void setTeihitukeihigaikaType(String type) {
        teihitukeihigaikaType = type;
        teihitukeihigaika = Optional.fromNullable(toCurrencyType(teihitukeihigaikaType))
            .transform(bizCurrencyTransformer(getTeihitukeihigaikaValue()))
            .orNull();
    }

    private String teihyounkspan;

    @Column(name=GenSV_NkHit.TEIHYOUNKSPAN)
    public String getTeihyounkspan() {
        return teihyounkspan;
    }

    public void setTeihyounkspan(String pTeihyounkspan) {
        teihyounkspan = pTeihyounkspan;
    }

    private BizCurrency teinkkikingk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeinkkikingk() {
        return teinkkikingk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTeinkkikingk(BizCurrency pTeinkkikingk) {
        teinkkikingk = pTeinkkikingk;
        teinkkikingkValue = null;
        teinkkikingkType  = null;
    }

    transient private BigDecimal teinkkikingkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEINKKIKINGK, nullable=true)
    protected BigDecimal getTeinkkikingkValue() {
        if (teinkkikingkValue == null && teinkkikingk != null) {
            if (teinkkikingk.isOptional()) return null;
            return teinkkikingk.absolute();
        }
        return teinkkikingkValue;
    }

    protected void setTeinkkikingkValue(BigDecimal value) {
        teinkkikingkValue = value;
        teinkkikingk = Optional.fromNullable(toCurrencyType(teinkkikingkType))
            .transform(bizCurrencyTransformer(getTeinkkikingkValue()))
            .orNull();
    }

    transient private String teinkkikingkType = null;

    @Column(name=TEINKKIKINGK + "$", nullable=true)
    protected String getTeinkkikingkType() {
        if (teinkkikingkType == null && teinkkikingk != null) return teinkkikingk.getType().toString();
        if (teinkkikingkType == null && getTeinkkikingkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teinkkikingk$' should not be NULL."));
        }
        return teinkkikingkType;
    }

    protected void setTeinkkikingkType(String type) {
        teinkkikingkType = type;
        teinkkikingk = Optional.fromNullable(toCurrencyType(teinkkikingkType))
            .transform(bizCurrencyTransformer(getTeinkkikingkValue()))
            .orNull();
    }

    private C_NkGnsKbn nkgnskbn;

    @Type(type="UserType_C_NkGnsKbn")
    @Column(name=GenSV_NkHit.NKGNSKBN)
    public C_NkGnsKbn getNkgnskbn() {
        return nkgnskbn;
    }

    public void setNkgnskbn(C_NkGnsKbn pNkgnskbn) {
        nkgnskbn = pNkgnskbn;
    }

    private String nenkinkaisigoyoteiriritukbn;

    @Column(name=GenSV_NkHit.NENKINKAISIGOYOTEIRIRITUKBN)
    public String getNenkinkaisigoyoteiriritukbn() {
        return nenkinkaisigoyoteiriritukbn;
    }

    public void setNenkinkaisigoyoteiriritukbn(String pNenkinkaisigoyoteiriritukbn) {
        nenkinkaisigoyoteiriritukbn = pNenkinkaisigoyoteiriritukbn;
    }

    private C_NenkinJimuTesuuryouKbn nenkinjimutesuuryoukbn;

    @Type(type="UserType_C_NenkinJimuTesuuryouKbn")
    @Column(name=GenSV_NkHit.NENKINJIMUTESUURYOUKBN)
    public C_NenkinJimuTesuuryouKbn getNenkinjimutesuuryoukbn() {
        return nenkinjimutesuuryoukbn;
    }

    public void setNenkinjimutesuuryoukbn(C_NenkinJimuTesuuryouKbn pNenkinjimutesuuryoukbn) {
        nenkinjimutesuuryoukbn = pNenkinjimutesuuryoukbn;
    }

    private BizNumber kyktumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenSV_NkHit.KYKTUMITATERIRITU)
    public BizNumber getKyktumitateriritu() {
        return kyktumitateriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKyktumitateriritu(BizNumber pKyktumitateriritu) {
        kyktumitateriritu = pKyktumitateriritu;
    }

    private BizNumber tumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenSV_NkHit.TUMITATERIRITU)
    public BizNumber getTumitateriritu() {
        return tumitateriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTumitateriritu(BizNumber pTumitateriritu) {
        tumitateriritu = pTumitateriritu;
    }

    private BizDate tumitatekijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.TUMITATEKIJYUNYMD)
    @ValidDate
    public BizDate getTumitatekijyunymd() {
        return tumitatekijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTumitatekijyunymd(BizDate pTumitatekijyunymd) {
        tumitatekijyunymd = pTumitatekijyunymd;
    }

    private BizNumber tumitatekijyunnen;

    @Type(type="BizNumberType")
    @Column(name=GenSV_NkHit.TUMITATEKIJYUNNEN)
    public BizNumber getTumitatekijyunnen() {
        return tumitatekijyunnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTumitatekijyunnen(BizNumber pTumitatekijyunnen) {
        tumitatekijyunnen = pTumitatekijyunnen;
    }

    private BizNumber tumitatekijyunkkn;

    @Type(type="BizNumberType")
    @Column(name=GenSV_NkHit.TUMITATEKIJYUNKKN)
    public BizNumber getTumitatekijyunkkn() {
        return tumitatekijyunkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTumitatekijyunkkn(BizNumber pTumitatekijyunkkn) {
        tumitatekijyunkkn = pTumitatekijyunkkn;
    }

    private BizDate fstinymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.FSTINYMD)
    @ValidDate
    public BizDate getFstinymd() {
        return fstinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setFstinymd(BizDate pFstinymd) {
        fstinymd = pFstinymd;
    }

    private C_NkHaitoukinuketorihouKbn nkhaitoukinuketorihoukbn;

    @Type(type="UserType_C_NkHaitoukinuketorihouKbn")
    @Column(name=GenSV_NkHit.NKHAITOUKINUKETORIHOUKBN)
    public C_NkHaitoukinuketorihouKbn getNkhaitoukinuketorihoukbn() {
        return nkhaitoukinuketorihoukbn;
    }

    public void setNkhaitoukinuketorihoukbn(C_NkHaitoukinuketorihouKbn pNkhaitoukinuketorihoukbn) {
        nkhaitoukinuketorihoukbn = pNkhaitoukinuketorihoukbn;
    }

    private C_NenreiCalcKbn nenreicalckbn;

    @Type(type="UserType_C_NenreiCalcKbn")
    @Column(name=GenSV_NkHit.NENREICALCKBN)
    public C_NenreiCalcKbn getNenreicalckbn() {
        return nenreicalckbn;
    }

    public void setNenreicalckbn(C_NenreiCalcKbn pNenreicalckbn) {
        nenreicalckbn = pNenreicalckbn;
    }

    private String hhknnmkn;

    @Column(name=GenSV_NkHit.HHKNNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    private String hhknnmkj;

    @Column(name=GenSV_NkHit.HHKNNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkHit.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private Integer hhknnen;

    @Column(name=GenSV_NkHit.HHKNNEN)
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
    @Column(name=GenSV_NkHit.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private String hhknadrkj;

    @Column(name=GenSV_NkHit.HHKNADRKJ)
    @MaxLength(max=62)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadrkj() {
        return hhknadrkj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHhknadrkj(String pHhknadrkj) {
        hhknadrkj = pHhknadrkj;
    }

    private String hhknsakuinmeino;

    @Column(name=GenSV_NkHit.HHKNSAKUINMEINO)
    public String getHhknsakuinmeino() {
        return hhknsakuinmeino;
    }

    public void setHhknsakuinmeino(String pHhknsakuinmeino) {
        hhknsakuinmeino = pHhknsakuinmeino;
    }
}
