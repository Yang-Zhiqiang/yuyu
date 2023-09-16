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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.number.BizCurrency;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.db.entity.IT_KessanYokukiP;
import yuyu.def.db.id.PKIT_KessanYokukiP;
import yuyu.def.db.meta.GenQIT_KessanYokukiP;
import yuyu.def.db.meta.QIT_KessanYokukiP;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 決算用翌期Ｐテーブル テーブルのマッピング情報クラスで、 {@link IT_KessanYokukiP} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KessanYokukiP}</td><td colspan="3">決算用翌期Ｐテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KessanYokukiP ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeijyouym keijyouym}</td><td>計上年月</td><td align="center">{@link PKIT_KessanYokukiP ○}</td><td align="center">N</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KessanYokukiP ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyukigou hknsyukigou}</td><td>保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyukigousdkbn1keta hknsyukigousdkbn1keta}</td><td>保険種類記号世代区分（１桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x1 hokensyuruikigouyobi1x1}</td><td>保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x2 hokensyuruikigouyobi1x2}</td><td>保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x3 hokensyuruikigouyobi1x3}</td><td>保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x4 hokensyuruikigouyobi1x4}</td><td>保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x5 hokensyuruikigouyobi1x5}</td><td>保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x6 hokensyuruikigouyobi1x6}</td><td>保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x7 hokensyuruikigouyobi1x7}</td><td>保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x8 hokensyuruikigouyobi1x8}</td><td>保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x9 hokensyuruikigouyobi1x9}</td><td>保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x10 hokensyuruikigouyobi1x10}</td><td>保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x11 hokensyuruikigouyobi1x11}</td><td>保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x12 hokensyuruikigouyobi1x12}</td><td>保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x13 hokensyuruikigouyobi1x13}</td><td>保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x14 hokensyuruikigouyobi1x14}</td><td>保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi1x15 hokensyuruikigouyobi1x15}</td><td>保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi2x1 hokensyuruikigouyobi2x1}</td><td>保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi2x2 hokensyuruikigouyobi2x2}</td><td>保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi2x3 hokensyuruikigouyobi2x3}</td><td>保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi2x4 hokensyuruikigouyobi2x4}</td><td>保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi2x5 hokensyuruikigouyobi2x5}</td><td>保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi2x6 hokensyuruikigouyobi2x6}</td><td>保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi2x7 hokensyuruikigouyobi2x7}</td><td>保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi2x8 hokensyuruikigouyobi2x8}</td><td>保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi2x9 hokensyuruikigouyobi2x9}</td><td>保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi2x10 hokensyuruikigouyobi2x10}</td><td>保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi3x1 hokensyuruikigouyobi3x1}</td><td>保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi3x2 hokensyuruikigouyobi3x2}</td><td>保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi3x3 hokensyuruikigouyobi3x3}</td><td>保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi3x4 hokensyuruikigouyobi3x4}</td><td>保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi3x5 hokensyuruikigouyobi3x5}</td><td>保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi3x6 hokensyuruikigouyobi3x6}</td><td>保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi3x7 hokensyuruikigouyobi3x7}</td><td>保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi3x8 hokensyuruikigouyobi3x8}</td><td>保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi3x9 hokensyuruikigouyobi3x9}</td><td>保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigouyobi3x10 hokensyuruikigouyobi3x10}</td><td>保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAnnaihuyouriyuukbn annaihuyouriyuukbn}</td><td>案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoumetucd syoumetucd}</td><td>消滅コード</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getHaraikomip haraikomip}</td><td>払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyukykp syukykp}</td><td>主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennyknmonth zennyknmonth}</td><td>前回入金月数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZenyuukinymd zenyuukinymd}</td><td>前回入金年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJidoukousinhyouji jidoukousinhyouji}</td><td>自動更新表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTenkanhyouji tenkanhyouji}</td><td>転換表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHosyouikkatumnoshyouji hosyouikkatumnoshyouji}</td><td>保障一括見直表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYobi01xv40 yobi01xv40}</td><td>予備０１＿Ｖ４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTkkzkp tkkzkp}</td><td>特約継続Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKeizokuphurikaekngk keizokuphurikaekngk}</td><td>継続Ｐ振替金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKeizokuphurikaekaisiym keizokuphurikaekaisiym}</td><td>継続Ｐ振替開始年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getHaraikomipannaisaikaiym haraikomipannaisaikaiym}</td><td>払込Ｐ案内再開年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getTkkzkkouryokukaisiymd tkkzkkouryokukaisiymd}</td><td>特約継続効力開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrimngtkykpjyuutouhoukbn hrimngtkykpjyuutouhoukbn}</td><td>払満後特約Ｐ充当方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJkitkpjytym jkitkpjytym}</td><td>次回特約Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getItijibrzugktkp itijibrzugktkp}</td><td>一時払増額特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getPazukarikingk pazukarikingk}</td><td>Ｐ預り金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZennoukbn zennoukbn}</td><td>前納区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennoukaisiymd zennoukaisiymd}</td><td>前納開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennounyuukinymd zennounyuukinymd}</td><td>前納入金年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYokukipbunruicd yokukipbunruicd}</td><td>翌期Ｐ分類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMisyoricd1 misyoricd1}</td><td>未処理コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMisyoricd2 misyoricd2}</td><td>未処理コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMisyoricd3 misyoricd3}</td><td>未処理コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMisyoricd4 misyoricd4}</td><td>未処理コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMisyoricd5 misyoricd5}</td><td>未処理コード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMisyoricd6 misyoricd6}</td><td>未処理コード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMisyoricd7 misyoricd7}</td><td>未処理コード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMisyoricd8 misyoricd8}</td><td>未処理コード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMisyoricd9 misyoricd9}</td><td>未処理コード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMisyoricd10 misyoricd10}</td><td>未処理コード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYobi02xv39 yobi02xv39}</td><td>予備０２＿Ｖ３９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKbnkeiriyousegmentkbn kbnkeiriyousegmentkbn}</td><td>区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKbnkeiriyourgnbnskkbn kbnkeiriyourgnbnskkbn}</td><td>区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSuurisyuruicd suurisyuruicd}</td><td>数理種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getKyknendo kyknendo}</td><td>契約年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeiyakum keiyakum}</td><td>契約月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaraikatakbn haraikatakbn}</td><td>払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIktyknndp iktyknndp}</td><td>一括払翌年度保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKigetumaenyknyknndp kigetumaenyknyknndp}</td><td>期月前入金翌年度保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYknndpkei yknndpkei}</td><td>翌年度保険料合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYobi03xn13 yobi03xn13}</td><td>予備０３＿Ｎ１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYobi04xv23 yobi04xv23}</td><td>予備０４＿Ｖ２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KessanYokukiP
 * @see     PKIT_KessanYokukiP
 * @see     QIT_KessanYokukiP
 * @see     GenQIT_KessanYokukiP
 */
@MappedSuperclass
@Table(name=GenIT_KessanYokukiP.TABLE_NAME)
@IdClass(value=PKIT_KessanYokukiP.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class)
})
public abstract class GenIT_KessanYokukiP extends AbstractExDBEntity<IT_KessanYokukiP, PKIT_KessanYokukiP> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KessanYokukiP";
    public static final String KBNKEY                   = "kbnkey";
    public static final String KEIJYOUYM                = "keijyouym";
    public static final String SYONO                    = "syono";
    public static final String HKNSYUKIGOU              = "hknsyukigou";
    public static final String HKNSYUKIGOUSDKBN1KETA    = "hknsyukigousdkbn1keta";
    public static final String HOKENSYURUIKIGOUYOBI1X1  = "hokensyuruikigouyobi1x1";
    public static final String HOKENSYURUIKIGOUYOBI1X2  = "hokensyuruikigouyobi1x2";
    public static final String HOKENSYURUIKIGOUYOBI1X3  = "hokensyuruikigouyobi1x3";
    public static final String HOKENSYURUIKIGOUYOBI1X4  = "hokensyuruikigouyobi1x4";
    public static final String HOKENSYURUIKIGOUYOBI1X5  = "hokensyuruikigouyobi1x5";
    public static final String HOKENSYURUIKIGOUYOBI1X6  = "hokensyuruikigouyobi1x6";
    public static final String HOKENSYURUIKIGOUYOBI1X7  = "hokensyuruikigouyobi1x7";
    public static final String HOKENSYURUIKIGOUYOBI1X8  = "hokensyuruikigouyobi1x8";
    public static final String HOKENSYURUIKIGOUYOBI1X9  = "hokensyuruikigouyobi1x9";
    public static final String HOKENSYURUIKIGOUYOBI1X10 = "hokensyuruikigouyobi1x10";
    public static final String HOKENSYURUIKIGOUYOBI1X11 = "hokensyuruikigouyobi1x11";
    public static final String HOKENSYURUIKIGOUYOBI1X12 = "hokensyuruikigouyobi1x12";
    public static final String HOKENSYURUIKIGOUYOBI1X13 = "hokensyuruikigouyobi1x13";
    public static final String HOKENSYURUIKIGOUYOBI1X14 = "hokensyuruikigouyobi1x14";
    public static final String HOKENSYURUIKIGOUYOBI1X15 = "hokensyuruikigouyobi1x15";
    public static final String HOKENSYURUIKIGOUYOBI2X1  = "hokensyuruikigouyobi2x1";
    public static final String HOKENSYURUIKIGOUYOBI2X2  = "hokensyuruikigouyobi2x2";
    public static final String HOKENSYURUIKIGOUYOBI2X3  = "hokensyuruikigouyobi2x3";
    public static final String HOKENSYURUIKIGOUYOBI2X4  = "hokensyuruikigouyobi2x4";
    public static final String HOKENSYURUIKIGOUYOBI2X5  = "hokensyuruikigouyobi2x5";
    public static final String HOKENSYURUIKIGOUYOBI2X6  = "hokensyuruikigouyobi2x6";
    public static final String HOKENSYURUIKIGOUYOBI2X7  = "hokensyuruikigouyobi2x7";
    public static final String HOKENSYURUIKIGOUYOBI2X8  = "hokensyuruikigouyobi2x8";
    public static final String HOKENSYURUIKIGOUYOBI2X9  = "hokensyuruikigouyobi2x9";
    public static final String HOKENSYURUIKIGOUYOBI2X10 = "hokensyuruikigouyobi2x10";
    public static final String HOKENSYURUIKIGOUYOBI3X1  = "hokensyuruikigouyobi3x1";
    public static final String HOKENSYURUIKIGOUYOBI3X2  = "hokensyuruikigouyobi3x2";
    public static final String HOKENSYURUIKIGOUYOBI3X3  = "hokensyuruikigouyobi3x3";
    public static final String HOKENSYURUIKIGOUYOBI3X4  = "hokensyuruikigouyobi3x4";
    public static final String HOKENSYURUIKIGOUYOBI3X5  = "hokensyuruikigouyobi3x5";
    public static final String HOKENSYURUIKIGOUYOBI3X6  = "hokensyuruikigouyobi3x6";
    public static final String HOKENSYURUIKIGOUYOBI3X7  = "hokensyuruikigouyobi3x7";
    public static final String HOKENSYURUIKIGOUYOBI3X8  = "hokensyuruikigouyobi3x8";
    public static final String HOKENSYURUIKIGOUYOBI3X9  = "hokensyuruikigouyobi3x9";
    public static final String HOKENSYURUIKIGOUYOBI3X10 = "hokensyuruikigouyobi3x10";
    public static final String KYKYMD                   = "kykymd";
    public static final String ANNAIHUYOURIYUUKBN       = "annaihuyouriyuukbn";
    public static final String SYOUMETUCD               = "syoumetucd";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String HARAIKOMIP               = "haraikomip";
    public static final String SYUKYKP                  = "syukykp";
    public static final String ZENNYKNMONTH             = "zennyknmonth";
    public static final String ZENYUUKINYMD             = "zenyuukinymd";
    public static final String JIDOUKOUSINHYOUJI        = "jidoukousinhyouji";
    public static final String TENKANHYOUJI             = "tenkanhyouji";
    public static final String HOSYOUIKKATUMNOSHYOUJI   = "hosyouikkatumnoshyouji";
    public static final String YOBI01XV40               = "yobi01xv40";
    public static final String TKKZKP                   = "tkkzkp";
    public static final String KEIZOKUPHURIKAEKNGK      = "keizokuphurikaekngk";
    public static final String KEIZOKUPHURIKAEKAISIYM   = "keizokuphurikaekaisiym";
    public static final String HARAIKOMIPANNAISAIKAIYM  = "haraikomipannaisaikaiym";
    public static final String TKKZKKOURYOKUKAISIYMD    = "tkkzkkouryokukaisiymd";
    public static final String HRIMNGTKYKPJYUUTOUHOUKBN = "hrimngtkykpjyuutouhoukbn";
    public static final String JKITKPJYTYM              = "jkitkpjytym";
    public static final String ITIJIBRZUGKTKP           = "itijibrzugktkp";
    public static final String PAZUKARIKINGK            = "pazukarikingk";
    public static final String ZENNOUKBN                = "zennoukbn";
    public static final String ZENNOUKAISIYMD           = "zennoukaisiymd";
    public static final String ZENNOUNYUUKINYMD         = "zennounyuukinymd";
    public static final String YOKUKIPBUNRUICD          = "yokukipbunruicd";
    public static final String MISYORICD1               = "misyoricd1";
    public static final String MISYORICD2               = "misyoricd2";
    public static final String MISYORICD3               = "misyoricd3";
    public static final String MISYORICD4               = "misyoricd4";
    public static final String MISYORICD5               = "misyoricd5";
    public static final String MISYORICD6               = "misyoricd6";
    public static final String MISYORICD7               = "misyoricd7";
    public static final String MISYORICD8               = "misyoricd8";
    public static final String MISYORICD9               = "misyoricd9";
    public static final String MISYORICD10              = "misyoricd10";
    public static final String YOBI02XV39               = "yobi02xv39";
    public static final String KBNKEIRIYOUSEGMENTKBN    = "kbnkeiriyousegmentkbn";
    public static final String KBNKEIRIYOURGNBNSKKBN    = "kbnkeiriyourgnbnskkbn";
    public static final String SUURISYURUICD            = "suurisyuruicd";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String KYKNENDO                 = "kyknendo";
    public static final String KEIYAKUM                 = "keiyakum";
    public static final String HARAIKATAKBN             = "haraikatakbn";
    public static final String IKTYKNNDP                = "iktyknndp";
    public static final String KIGETUMAENYKNYKNNDP      = "kigetumaenyknyknndp";
    public static final String YKNNDPKEI                = "yknndpkei";
    public static final String YOBI03XN13               = "yobi03xn13";
    public static final String YOBI04XV23               = "yobi04xv23";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KessanYokukiP primaryKey;

    public GenIT_KessanYokukiP() {
        primaryKey = new PKIT_KessanYokukiP();
    }

    public GenIT_KessanYokukiP(
        String pKbnkey,
        BizDateYM pKeijyouym,
        String pSyono
    ) {
        primaryKey = new PKIT_KessanYokukiP(
            pKbnkey,
            pKeijyouym,
            pSyono
        );
    }

    @Transient
    @Override
    public PKIT_KessanYokukiP getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KessanYokukiP> getMetaClass() {
        return QIT_KessanYokukiP.class;
    }

    @Id
    @Column(name=GenIT_KessanYokukiP.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Type(type="BizDateYMType")
    @Column(name=GenIT_KessanYokukiP.KEIJYOUYM)
    public BizDateYM getKeijyouym() {
        return getPrimaryKey().getKeijyouym();
    }

    public void setKeijyouym(BizDateYM pKeijyouym) {
        getPrimaryKey().setKeijyouym(pKeijyouym);
    }

    @Id
    @Column(name=GenIT_KessanYokukiP.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private String hknsyukigou;

    @Column(name=GenIT_KessanYokukiP.HKNSYUKIGOU)
    public String getHknsyukigou() {
        return hknsyukigou;
    }

    public void setHknsyukigou(String pHknsyukigou) {
        hknsyukigou = pHknsyukigou;
    }

    private String hknsyukigousdkbn1keta;

    @Column(name=GenIT_KessanYokukiP.HKNSYUKIGOUSDKBN1KETA)
    public String getHknsyukigousdkbn1keta() {
        return hknsyukigousdkbn1keta;
    }

    public void setHknsyukigousdkbn1keta(String pHknsyukigousdkbn1keta) {
        hknsyukigousdkbn1keta = pHknsyukigousdkbn1keta;
    }

    private String hokensyuruikigouyobi1x1;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X1)
    public String getHokensyuruikigouyobi1x1() {
        return hokensyuruikigouyobi1x1;
    }

    public void setHokensyuruikigouyobi1x1(String pHokensyuruikigouyobi1x1) {
        hokensyuruikigouyobi1x1 = pHokensyuruikigouyobi1x1;
    }

    private String hokensyuruikigouyobi1x2;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X2)
    public String getHokensyuruikigouyobi1x2() {
        return hokensyuruikigouyobi1x2;
    }

    public void setHokensyuruikigouyobi1x2(String pHokensyuruikigouyobi1x2) {
        hokensyuruikigouyobi1x2 = pHokensyuruikigouyobi1x2;
    }

    private String hokensyuruikigouyobi1x3;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X3)
    public String getHokensyuruikigouyobi1x3() {
        return hokensyuruikigouyobi1x3;
    }

    public void setHokensyuruikigouyobi1x3(String pHokensyuruikigouyobi1x3) {
        hokensyuruikigouyobi1x3 = pHokensyuruikigouyobi1x3;
    }

    private String hokensyuruikigouyobi1x4;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X4)
    public String getHokensyuruikigouyobi1x4() {
        return hokensyuruikigouyobi1x4;
    }

    public void setHokensyuruikigouyobi1x4(String pHokensyuruikigouyobi1x4) {
        hokensyuruikigouyobi1x4 = pHokensyuruikigouyobi1x4;
    }

    private String hokensyuruikigouyobi1x5;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X5)
    public String getHokensyuruikigouyobi1x5() {
        return hokensyuruikigouyobi1x5;
    }

    public void setHokensyuruikigouyobi1x5(String pHokensyuruikigouyobi1x5) {
        hokensyuruikigouyobi1x5 = pHokensyuruikigouyobi1x5;
    }

    private String hokensyuruikigouyobi1x6;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X6)
    public String getHokensyuruikigouyobi1x6() {
        return hokensyuruikigouyobi1x6;
    }

    public void setHokensyuruikigouyobi1x6(String pHokensyuruikigouyobi1x6) {
        hokensyuruikigouyobi1x6 = pHokensyuruikigouyobi1x6;
    }

    private String hokensyuruikigouyobi1x7;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X7)
    public String getHokensyuruikigouyobi1x7() {
        return hokensyuruikigouyobi1x7;
    }

    public void setHokensyuruikigouyobi1x7(String pHokensyuruikigouyobi1x7) {
        hokensyuruikigouyobi1x7 = pHokensyuruikigouyobi1x7;
    }

    private String hokensyuruikigouyobi1x8;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X8)
    public String getHokensyuruikigouyobi1x8() {
        return hokensyuruikigouyobi1x8;
    }

    public void setHokensyuruikigouyobi1x8(String pHokensyuruikigouyobi1x8) {
        hokensyuruikigouyobi1x8 = pHokensyuruikigouyobi1x8;
    }

    private String hokensyuruikigouyobi1x9;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X9)
    public String getHokensyuruikigouyobi1x9() {
        return hokensyuruikigouyobi1x9;
    }

    public void setHokensyuruikigouyobi1x9(String pHokensyuruikigouyobi1x9) {
        hokensyuruikigouyobi1x9 = pHokensyuruikigouyobi1x9;
    }

    private String hokensyuruikigouyobi1x10;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X10)
    public String getHokensyuruikigouyobi1x10() {
        return hokensyuruikigouyobi1x10;
    }

    public void setHokensyuruikigouyobi1x10(String pHokensyuruikigouyobi1x10) {
        hokensyuruikigouyobi1x10 = pHokensyuruikigouyobi1x10;
    }

    private String hokensyuruikigouyobi1x11;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X11)
    public String getHokensyuruikigouyobi1x11() {
        return hokensyuruikigouyobi1x11;
    }

    public void setHokensyuruikigouyobi1x11(String pHokensyuruikigouyobi1x11) {
        hokensyuruikigouyobi1x11 = pHokensyuruikigouyobi1x11;
    }

    private String hokensyuruikigouyobi1x12;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X12)
    public String getHokensyuruikigouyobi1x12() {
        return hokensyuruikigouyobi1x12;
    }

    public void setHokensyuruikigouyobi1x12(String pHokensyuruikigouyobi1x12) {
        hokensyuruikigouyobi1x12 = pHokensyuruikigouyobi1x12;
    }

    private String hokensyuruikigouyobi1x13;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X13)
    public String getHokensyuruikigouyobi1x13() {
        return hokensyuruikigouyobi1x13;
    }

    public void setHokensyuruikigouyobi1x13(String pHokensyuruikigouyobi1x13) {
        hokensyuruikigouyobi1x13 = pHokensyuruikigouyobi1x13;
    }

    private String hokensyuruikigouyobi1x14;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X14)
    public String getHokensyuruikigouyobi1x14() {
        return hokensyuruikigouyobi1x14;
    }

    public void setHokensyuruikigouyobi1x14(String pHokensyuruikigouyobi1x14) {
        hokensyuruikigouyobi1x14 = pHokensyuruikigouyobi1x14;
    }

    private String hokensyuruikigouyobi1x15;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI1X15)
    public String getHokensyuruikigouyobi1x15() {
        return hokensyuruikigouyobi1x15;
    }

    public void setHokensyuruikigouyobi1x15(String pHokensyuruikigouyobi1x15) {
        hokensyuruikigouyobi1x15 = pHokensyuruikigouyobi1x15;
    }

    private String hokensyuruikigouyobi2x1;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI2X1)
    public String getHokensyuruikigouyobi2x1() {
        return hokensyuruikigouyobi2x1;
    }

    public void setHokensyuruikigouyobi2x1(String pHokensyuruikigouyobi2x1) {
        hokensyuruikigouyobi2x1 = pHokensyuruikigouyobi2x1;
    }

    private String hokensyuruikigouyobi2x2;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI2X2)
    public String getHokensyuruikigouyobi2x2() {
        return hokensyuruikigouyobi2x2;
    }

    public void setHokensyuruikigouyobi2x2(String pHokensyuruikigouyobi2x2) {
        hokensyuruikigouyobi2x2 = pHokensyuruikigouyobi2x2;
    }

    private String hokensyuruikigouyobi2x3;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI2X3)
    public String getHokensyuruikigouyobi2x3() {
        return hokensyuruikigouyobi2x3;
    }

    public void setHokensyuruikigouyobi2x3(String pHokensyuruikigouyobi2x3) {
        hokensyuruikigouyobi2x3 = pHokensyuruikigouyobi2x3;
    }

    private String hokensyuruikigouyobi2x4;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI2X4)
    public String getHokensyuruikigouyobi2x4() {
        return hokensyuruikigouyobi2x4;
    }

    public void setHokensyuruikigouyobi2x4(String pHokensyuruikigouyobi2x4) {
        hokensyuruikigouyobi2x4 = pHokensyuruikigouyobi2x4;
    }

    private String hokensyuruikigouyobi2x5;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI2X5)
    public String getHokensyuruikigouyobi2x5() {
        return hokensyuruikigouyobi2x5;
    }

    public void setHokensyuruikigouyobi2x5(String pHokensyuruikigouyobi2x5) {
        hokensyuruikigouyobi2x5 = pHokensyuruikigouyobi2x5;
    }

    private String hokensyuruikigouyobi2x6;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI2X6)
    public String getHokensyuruikigouyobi2x6() {
        return hokensyuruikigouyobi2x6;
    }

    public void setHokensyuruikigouyobi2x6(String pHokensyuruikigouyobi2x6) {
        hokensyuruikigouyobi2x6 = pHokensyuruikigouyobi2x6;
    }

    private String hokensyuruikigouyobi2x7;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI2X7)
    public String getHokensyuruikigouyobi2x7() {
        return hokensyuruikigouyobi2x7;
    }

    public void setHokensyuruikigouyobi2x7(String pHokensyuruikigouyobi2x7) {
        hokensyuruikigouyobi2x7 = pHokensyuruikigouyobi2x7;
    }

    private String hokensyuruikigouyobi2x8;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI2X8)
    public String getHokensyuruikigouyobi2x8() {
        return hokensyuruikigouyobi2x8;
    }

    public void setHokensyuruikigouyobi2x8(String pHokensyuruikigouyobi2x8) {
        hokensyuruikigouyobi2x8 = pHokensyuruikigouyobi2x8;
    }

    private String hokensyuruikigouyobi2x9;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI2X9)
    public String getHokensyuruikigouyobi2x9() {
        return hokensyuruikigouyobi2x9;
    }

    public void setHokensyuruikigouyobi2x9(String pHokensyuruikigouyobi2x9) {
        hokensyuruikigouyobi2x9 = pHokensyuruikigouyobi2x9;
    }

    private String hokensyuruikigouyobi2x10;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI2X10)
    public String getHokensyuruikigouyobi2x10() {
        return hokensyuruikigouyobi2x10;
    }

    public void setHokensyuruikigouyobi2x10(String pHokensyuruikigouyobi2x10) {
        hokensyuruikigouyobi2x10 = pHokensyuruikigouyobi2x10;
    }

    private String hokensyuruikigouyobi3x1;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI3X1)
    public String getHokensyuruikigouyobi3x1() {
        return hokensyuruikigouyobi3x1;
    }

    public void setHokensyuruikigouyobi3x1(String pHokensyuruikigouyobi3x1) {
        hokensyuruikigouyobi3x1 = pHokensyuruikigouyobi3x1;
    }

    private String hokensyuruikigouyobi3x2;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI3X2)
    public String getHokensyuruikigouyobi3x2() {
        return hokensyuruikigouyobi3x2;
    }

    public void setHokensyuruikigouyobi3x2(String pHokensyuruikigouyobi3x2) {
        hokensyuruikigouyobi3x2 = pHokensyuruikigouyobi3x2;
    }

    private String hokensyuruikigouyobi3x3;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI3X3)
    public String getHokensyuruikigouyobi3x3() {
        return hokensyuruikigouyobi3x3;
    }

    public void setHokensyuruikigouyobi3x3(String pHokensyuruikigouyobi3x3) {
        hokensyuruikigouyobi3x3 = pHokensyuruikigouyobi3x3;
    }

    private String hokensyuruikigouyobi3x4;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI3X4)
    public String getHokensyuruikigouyobi3x4() {
        return hokensyuruikigouyobi3x4;
    }

    public void setHokensyuruikigouyobi3x4(String pHokensyuruikigouyobi3x4) {
        hokensyuruikigouyobi3x4 = pHokensyuruikigouyobi3x4;
    }

    private String hokensyuruikigouyobi3x5;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI3X5)
    public String getHokensyuruikigouyobi3x5() {
        return hokensyuruikigouyobi3x5;
    }

    public void setHokensyuruikigouyobi3x5(String pHokensyuruikigouyobi3x5) {
        hokensyuruikigouyobi3x5 = pHokensyuruikigouyobi3x5;
    }

    private String hokensyuruikigouyobi3x6;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI3X6)
    public String getHokensyuruikigouyobi3x6() {
        return hokensyuruikigouyobi3x6;
    }

    public void setHokensyuruikigouyobi3x6(String pHokensyuruikigouyobi3x6) {
        hokensyuruikigouyobi3x6 = pHokensyuruikigouyobi3x6;
    }

    private String hokensyuruikigouyobi3x7;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI3X7)
    public String getHokensyuruikigouyobi3x7() {
        return hokensyuruikigouyobi3x7;
    }

    public void setHokensyuruikigouyobi3x7(String pHokensyuruikigouyobi3x7) {
        hokensyuruikigouyobi3x7 = pHokensyuruikigouyobi3x7;
    }

    private String hokensyuruikigouyobi3x8;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI3X8)
    public String getHokensyuruikigouyobi3x8() {
        return hokensyuruikigouyobi3x8;
    }

    public void setHokensyuruikigouyobi3x8(String pHokensyuruikigouyobi3x8) {
        hokensyuruikigouyobi3x8 = pHokensyuruikigouyobi3x8;
    }

    private String hokensyuruikigouyobi3x9;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI3X9)
    public String getHokensyuruikigouyobi3x9() {
        return hokensyuruikigouyobi3x9;
    }

    public void setHokensyuruikigouyobi3x9(String pHokensyuruikigouyobi3x9) {
        hokensyuruikigouyobi3x9 = pHokensyuruikigouyobi3x9;
    }

    private String hokensyuruikigouyobi3x10;

    @Column(name=GenIT_KessanYokukiP.HOKENSYURUIKIGOUYOBI3X10)
    public String getHokensyuruikigouyobi3x10() {
        return hokensyuruikigouyobi3x10;
    }

    public void setHokensyuruikigouyobi3x10(String pHokensyuruikigouyobi3x10) {
        hokensyuruikigouyobi3x10 = pHokensyuruikigouyobi3x10;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KessanYokukiP.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private String annaihuyouriyuukbn;

    @Column(name=GenIT_KessanYokukiP.ANNAIHUYOURIYUUKBN)
    public String getAnnaihuyouriyuukbn() {
        return annaihuyouriyuukbn;
    }

    public void setAnnaihuyouriyuukbn(String pAnnaihuyouriyuukbn) {
        annaihuyouriyuukbn = pAnnaihuyouriyuukbn;
    }

    private Integer syoumetucd;

    @Column(name=GenIT_KessanYokukiP.SYOUMETUCD)
    public Integer getSyoumetucd() {
        return syoumetucd;
    }

    public void setSyoumetucd(Integer pSyoumetucd) {
        syoumetucd = pSyoumetucd;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KessanYokukiP.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private BizCurrency haraikomip;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHaraikomip() {
        return haraikomip;
    }

    public void setHaraikomip(BizCurrency pHaraikomip) {
        haraikomip = pHaraikomip;
        haraikomipValue = null;
        haraikomipType  = null;
    }

    transient private BigDecimal haraikomipValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HARAIKOMIP, nullable=true)
    protected BigDecimal getHaraikomipValue() {
        if (haraikomipValue == null && haraikomip != null) {
            if (haraikomip.isOptional()) return null;
            return haraikomip.absolute();
        }
        return haraikomipValue;
    }

    protected void setHaraikomipValue(BigDecimal value) {
        haraikomipValue = value;
        haraikomip = Optional.fromNullable(toCurrencyType(haraikomipType))
            .transform(bizCurrencyTransformer(getHaraikomipValue()))
            .orNull();
    }

    transient private String haraikomipType = null;

    @Column(name=HARAIKOMIP + "$", nullable=true)
    protected String getHaraikomipType() {
        if (haraikomipType == null && haraikomip != null) return haraikomip.getType().toString();
        if (haraikomipType == null && getHaraikomipValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'haraikomip$' should not be NULL."));
        }
        return haraikomipType;
    }

    protected void setHaraikomipType(String type) {
        haraikomipType = type;
        haraikomip = Optional.fromNullable(toCurrencyType(haraikomipType))
            .transform(bizCurrencyTransformer(getHaraikomipValue()))
            .orNull();
    }

    private BizCurrency syukykp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyukykp() {
        return syukykp;
    }

    public void setSyukykp(BizCurrency pSyukykp) {
        syukykp = pSyukykp;
        syukykpValue = null;
        syukykpType  = null;
    }

    transient private BigDecimal syukykpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUKYKP, nullable=true)
    protected BigDecimal getSyukykpValue() {
        if (syukykpValue == null && syukykp != null) {
            if (syukykp.isOptional()) return null;
            return syukykp.absolute();
        }
        return syukykpValue;
    }

    protected void setSyukykpValue(BigDecimal value) {
        syukykpValue = value;
        syukykp = Optional.fromNullable(toCurrencyType(syukykpType))
            .transform(bizCurrencyTransformer(getSyukykpValue()))
            .orNull();
    }

    transient private String syukykpType = null;

    @Column(name=SYUKYKP + "$", nullable=true)
    protected String getSyukykpType() {
        if (syukykpType == null && syukykp != null) return syukykp.getType().toString();
        if (syukykpType == null && getSyukykpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syukykp$' should not be NULL."));
        }
        return syukykpType;
    }

    protected void setSyukykpType(String type) {
        syukykpType = type;
        syukykp = Optional.fromNullable(toCurrencyType(syukykpType))
            .transform(bizCurrencyTransformer(getSyukykpValue()))
            .orNull();
    }

    private Integer zennyknmonth;

    @Column(name=GenIT_KessanYokukiP.ZENNYKNMONTH)
    public Integer getZennyknmonth() {
        return zennyknmonth;
    }

    public void setZennyknmonth(Integer pZennyknmonth) {
        zennyknmonth = pZennyknmonth;
    }

    private BizDate zenyuukinymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KessanYokukiP.ZENYUUKINYMD)
    public BizDate getZenyuukinymd() {
        return zenyuukinymd;
    }

    public void setZenyuukinymd(BizDate pZenyuukinymd) {
        zenyuukinymd = pZenyuukinymd;
    }

    private String jidoukousinhyouji;

    @Column(name=GenIT_KessanYokukiP.JIDOUKOUSINHYOUJI)
    public String getJidoukousinhyouji() {
        return jidoukousinhyouji;
    }

    public void setJidoukousinhyouji(String pJidoukousinhyouji) {
        jidoukousinhyouji = pJidoukousinhyouji;
    }

    private String tenkanhyouji;

    @Column(name=GenIT_KessanYokukiP.TENKANHYOUJI)
    public String getTenkanhyouji() {
        return tenkanhyouji;
    }

    public void setTenkanhyouji(String pTenkanhyouji) {
        tenkanhyouji = pTenkanhyouji;
    }

    private String hosyouikkatumnoshyouji;

    @Column(name=GenIT_KessanYokukiP.HOSYOUIKKATUMNOSHYOUJI)
    public String getHosyouikkatumnoshyouji() {
        return hosyouikkatumnoshyouji;
    }

    public void setHosyouikkatumnoshyouji(String pHosyouikkatumnoshyouji) {
        hosyouikkatumnoshyouji = pHosyouikkatumnoshyouji;
    }

    private String yobi01xv40;

    @Column(name=GenIT_KessanYokukiP.YOBI01XV40)
    public String getYobi01xv40() {
        return yobi01xv40;
    }

    public void setYobi01xv40(String pYobi01xv40) {
        yobi01xv40 = pYobi01xv40;
    }

    private BizCurrency tkkzkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTkkzkp() {
        return tkkzkp;
    }

    public void setTkkzkp(BizCurrency pTkkzkp) {
        tkkzkp = pTkkzkp;
        tkkzkpValue = null;
        tkkzkpType  = null;
    }

    transient private BigDecimal tkkzkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TKKZKP, nullable=true)
    protected BigDecimal getTkkzkpValue() {
        if (tkkzkpValue == null && tkkzkp != null) {
            if (tkkzkp.isOptional()) return null;
            return tkkzkp.absolute();
        }
        return tkkzkpValue;
    }

    protected void setTkkzkpValue(BigDecimal value) {
        tkkzkpValue = value;
        tkkzkp = Optional.fromNullable(toCurrencyType(tkkzkpType))
            .transform(bizCurrencyTransformer(getTkkzkpValue()))
            .orNull();
    }

    transient private String tkkzkpType = null;

    @Column(name=TKKZKP + "$", nullable=true)
    protected String getTkkzkpType() {
        if (tkkzkpType == null && tkkzkp != null) return tkkzkp.getType().toString();
        if (tkkzkpType == null && getTkkzkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tkkzkp$' should not be NULL."));
        }
        return tkkzkpType;
    }

    protected void setTkkzkpType(String type) {
        tkkzkpType = type;
        tkkzkp = Optional.fromNullable(toCurrencyType(tkkzkpType))
            .transform(bizCurrencyTransformer(getTkkzkpValue()))
            .orNull();
    }

    private BizCurrency keizokuphurikaekngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKeizokuphurikaekngk() {
        return keizokuphurikaekngk;
    }

    public void setKeizokuphurikaekngk(BizCurrency pKeizokuphurikaekngk) {
        keizokuphurikaekngk = pKeizokuphurikaekngk;
        keizokuphurikaekngkValue = null;
        keizokuphurikaekngkType  = null;
    }

    transient private BigDecimal keizokuphurikaekngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KEIZOKUPHURIKAEKNGK, nullable=true)
    protected BigDecimal getKeizokuphurikaekngkValue() {
        if (keizokuphurikaekngkValue == null && keizokuphurikaekngk != null) {
            if (keizokuphurikaekngk.isOptional()) return null;
            return keizokuphurikaekngk.absolute();
        }
        return keizokuphurikaekngkValue;
    }

    protected void setKeizokuphurikaekngkValue(BigDecimal value) {
        keizokuphurikaekngkValue = value;
        keizokuphurikaekngk = Optional.fromNullable(toCurrencyType(keizokuphurikaekngkType))
            .transform(bizCurrencyTransformer(getKeizokuphurikaekngkValue()))
            .orNull();
    }

    transient private String keizokuphurikaekngkType = null;

    @Column(name=KEIZOKUPHURIKAEKNGK + "$", nullable=true)
    protected String getKeizokuphurikaekngkType() {
        if (keizokuphurikaekngkType == null && keizokuphurikaekngk != null) return keizokuphurikaekngk.getType().toString();
        if (keizokuphurikaekngkType == null && getKeizokuphurikaekngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'keizokuphurikaekngk$' should not be NULL."));
        }
        return keizokuphurikaekngkType;
    }

    protected void setKeizokuphurikaekngkType(String type) {
        keizokuphurikaekngkType = type;
        keizokuphurikaekngk = Optional.fromNullable(toCurrencyType(keizokuphurikaekngkType))
            .transform(bizCurrencyTransformer(getKeizokuphurikaekngkValue()))
            .orNull();
    }

    private BizDateYM keizokuphurikaekaisiym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KessanYokukiP.KEIZOKUPHURIKAEKAISIYM)
    public BizDateYM getKeizokuphurikaekaisiym() {
        return keizokuphurikaekaisiym;
    }

    public void setKeizokuphurikaekaisiym(BizDateYM pKeizokuphurikaekaisiym) {
        keizokuphurikaekaisiym = pKeizokuphurikaekaisiym;
    }

    private BizDateYM haraikomipannaisaikaiym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KessanYokukiP.HARAIKOMIPANNAISAIKAIYM)
    public BizDateYM getHaraikomipannaisaikaiym() {
        return haraikomipannaisaikaiym;
    }

    public void setHaraikomipannaisaikaiym(BizDateYM pHaraikomipannaisaikaiym) {
        haraikomipannaisaikaiym = pHaraikomipannaisaikaiym;
    }

    private BizDate tkkzkkouryokukaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KessanYokukiP.TKKZKKOURYOKUKAISIYMD)
    public BizDate getTkkzkkouryokukaisiymd() {
        return tkkzkkouryokukaisiymd;
    }

    public void setTkkzkkouryokukaisiymd(BizDate pTkkzkkouryokukaisiymd) {
        tkkzkkouryokukaisiymd = pTkkzkkouryokukaisiymd;
    }

    private String hrimngtkykpjyuutouhoukbn;

    @Column(name=GenIT_KessanYokukiP.HRIMNGTKYKPJYUUTOUHOUKBN)
    public String getHrimngtkykpjyuutouhoukbn() {
        return hrimngtkykpjyuutouhoukbn;
    }

    public void setHrimngtkykpjyuutouhoukbn(String pHrimngtkykpjyuutouhoukbn) {
        hrimngtkykpjyuutouhoukbn = pHrimngtkykpjyuutouhoukbn;
    }

    private BizDateYM jkitkpjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KessanYokukiP.JKITKPJYTYM)
    public BizDateYM getJkitkpjytym() {
        return jkitkpjytym;
    }

    public void setJkitkpjytym(BizDateYM pJkitkpjytym) {
        jkitkpjytym = pJkitkpjytym;
    }

    private Long itijibrzugktkp;

    @Column(name=GenIT_KessanYokukiP.ITIJIBRZUGKTKP)
    public Long getItijibrzugktkp() {
        return itijibrzugktkp;
    }

    public void setItijibrzugktkp(Long pItijibrzugktkp) {
        itijibrzugktkp = pItijibrzugktkp;
    }

    private Long pazukarikingk;

    @Column(name=GenIT_KessanYokukiP.PAZUKARIKINGK)
    public Long getPazukarikingk() {
        return pazukarikingk;
    }

    public void setPazukarikingk(Long pPazukarikingk) {
        pazukarikingk = pPazukarikingk;
    }

    private String zennoukbn;

    @Column(name=GenIT_KessanYokukiP.ZENNOUKBN)
    public String getZennoukbn() {
        return zennoukbn;
    }

    public void setZennoukbn(String pZennoukbn) {
        zennoukbn = pZennoukbn;
    }

    private BizDate zennoukaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KessanYokukiP.ZENNOUKAISIYMD)
    public BizDate getZennoukaisiymd() {
        return zennoukaisiymd;
    }

    public void setZennoukaisiymd(BizDate pZennoukaisiymd) {
        zennoukaisiymd = pZennoukaisiymd;
    }

    private BizDate zennounyuukinymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KessanYokukiP.ZENNOUNYUUKINYMD)
    public BizDate getZennounyuukinymd() {
        return zennounyuukinymd;
    }

    public void setZennounyuukinymd(BizDate pZennounyuukinymd) {
        zennounyuukinymd = pZennounyuukinymd;
    }

    private String yokukipbunruicd;

    @Column(name=GenIT_KessanYokukiP.YOKUKIPBUNRUICD)
    public String getYokukipbunruicd() {
        return yokukipbunruicd;
    }

    public void setYokukipbunruicd(String pYokukipbunruicd) {
        yokukipbunruicd = pYokukipbunruicd;
    }

    private String misyoricd1;

    @Column(name=GenIT_KessanYokukiP.MISYORICD1)
    public String getMisyoricd1() {
        return misyoricd1;
    }

    public void setMisyoricd1(String pMisyoricd1) {
        misyoricd1 = pMisyoricd1;
    }

    private String misyoricd2;

    @Column(name=GenIT_KessanYokukiP.MISYORICD2)
    public String getMisyoricd2() {
        return misyoricd2;
    }

    public void setMisyoricd2(String pMisyoricd2) {
        misyoricd2 = pMisyoricd2;
    }

    private String misyoricd3;

    @Column(name=GenIT_KessanYokukiP.MISYORICD3)
    public String getMisyoricd3() {
        return misyoricd3;
    }

    public void setMisyoricd3(String pMisyoricd3) {
        misyoricd3 = pMisyoricd3;
    }

    private String misyoricd4;

    @Column(name=GenIT_KessanYokukiP.MISYORICD4)
    public String getMisyoricd4() {
        return misyoricd4;
    }

    public void setMisyoricd4(String pMisyoricd4) {
        misyoricd4 = pMisyoricd4;
    }

    private String misyoricd5;

    @Column(name=GenIT_KessanYokukiP.MISYORICD5)
    public String getMisyoricd5() {
        return misyoricd5;
    }

    public void setMisyoricd5(String pMisyoricd5) {
        misyoricd5 = pMisyoricd5;
    }

    private String misyoricd6;

    @Column(name=GenIT_KessanYokukiP.MISYORICD6)
    public String getMisyoricd6() {
        return misyoricd6;
    }

    public void setMisyoricd6(String pMisyoricd6) {
        misyoricd6 = pMisyoricd6;
    }

    private String misyoricd7;

    @Column(name=GenIT_KessanYokukiP.MISYORICD7)
    public String getMisyoricd7() {
        return misyoricd7;
    }

    public void setMisyoricd7(String pMisyoricd7) {
        misyoricd7 = pMisyoricd7;
    }

    private String misyoricd8;

    @Column(name=GenIT_KessanYokukiP.MISYORICD8)
    public String getMisyoricd8() {
        return misyoricd8;
    }

    public void setMisyoricd8(String pMisyoricd8) {
        misyoricd8 = pMisyoricd8;
    }

    private String misyoricd9;

    @Column(name=GenIT_KessanYokukiP.MISYORICD9)
    public String getMisyoricd9() {
        return misyoricd9;
    }

    public void setMisyoricd9(String pMisyoricd9) {
        misyoricd9 = pMisyoricd9;
    }

    private String misyoricd10;

    @Column(name=GenIT_KessanYokukiP.MISYORICD10)
    public String getMisyoricd10() {
        return misyoricd10;
    }

    public void setMisyoricd10(String pMisyoricd10) {
        misyoricd10 = pMisyoricd10;
    }

    private String yobi02xv39;

    @Column(name=GenIT_KessanYokukiP.YOBI02XV39)
    public String getYobi02xv39() {
        return yobi02xv39;
    }

    public void setYobi02xv39(String pYobi02xv39) {
        yobi02xv39 = pYobi02xv39;
    }

    private String kbnkeiriyousegmentkbn;

    @Column(name=GenIT_KessanYokukiP.KBNKEIRIYOUSEGMENTKBN)
    public String getKbnkeiriyousegmentkbn() {
        return kbnkeiriyousegmentkbn;
    }

    public void setKbnkeiriyousegmentkbn(String pKbnkeiriyousegmentkbn) {
        kbnkeiriyousegmentkbn = pKbnkeiriyousegmentkbn;
    }

    private String kbnkeiriyourgnbnskkbn;

    @Column(name=GenIT_KessanYokukiP.KBNKEIRIYOURGNBNSKKBN)
    public String getKbnkeiriyourgnbnskkbn() {
        return kbnkeiriyourgnbnskkbn;
    }

    public void setKbnkeiriyourgnbnskkbn(String pKbnkeiriyourgnbnskkbn) {
        kbnkeiriyourgnbnskkbn = pKbnkeiriyourgnbnskkbn;
    }

    private String suurisyuruicd;

    @Column(name=GenIT_KessanYokukiP.SUURISYURUICD)
    public String getSuurisyuruicd() {
        return suurisyuruicd;
    }

    public void setSuurisyuruicd(String pSuurisyuruicd) {
        suurisyuruicd = pSuurisyuruicd;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_KessanYokukiP.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private String kyknendo;

    @Column(name=GenIT_KessanYokukiP.KYKNENDO)
    public String getKyknendo() {
        return kyknendo;
    }

    public void setKyknendo(String pKyknendo) {
        kyknendo = pKyknendo;
    }

    private String keiyakum;

    @Column(name=GenIT_KessanYokukiP.KEIYAKUM)
    public String getKeiyakum() {
        return keiyakum;
    }

    public void setKeiyakum(String pKeiyakum) {
        keiyakum = pKeiyakum;
    }

    private String haraikatakbn;

    @Column(name=GenIT_KessanYokukiP.HARAIKATAKBN)
    public String getHaraikatakbn() {
        return haraikatakbn;
    }

    public void setHaraikatakbn(String pHaraikatakbn) {
        haraikatakbn = pHaraikatakbn;
    }

    private BizCurrency iktyknndp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getIktyknndp() {
        return iktyknndp;
    }

    public void setIktyknndp(BizCurrency pIktyknndp) {
        iktyknndp = pIktyknndp;
        iktyknndpValue = null;
        iktyknndpType  = null;
    }

    transient private BigDecimal iktyknndpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=IKTYKNNDP, nullable=true)
    protected BigDecimal getIktyknndpValue() {
        if (iktyknndpValue == null && iktyknndp != null) {
            if (iktyknndp.isOptional()) return null;
            return iktyknndp.absolute();
        }
        return iktyknndpValue;
    }

    protected void setIktyknndpValue(BigDecimal value) {
        iktyknndpValue = value;
        iktyknndp = Optional.fromNullable(toCurrencyType(iktyknndpType))
            .transform(bizCurrencyTransformer(getIktyknndpValue()))
            .orNull();
    }

    transient private String iktyknndpType = null;

    @Column(name=IKTYKNNDP + "$", nullable=true)
    protected String getIktyknndpType() {
        if (iktyknndpType == null && iktyknndp != null) return iktyknndp.getType().toString();
        if (iktyknndpType == null && getIktyknndpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'iktyknndp$' should not be NULL."));
        }
        return iktyknndpType;
    }

    protected void setIktyknndpType(String type) {
        iktyknndpType = type;
        iktyknndp = Optional.fromNullable(toCurrencyType(iktyknndpType))
            .transform(bizCurrencyTransformer(getIktyknndpValue()))
            .orNull();
    }

    private BizCurrency kigetumaenyknyknndp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKigetumaenyknyknndp() {
        return kigetumaenyknyknndp;
    }

    public void setKigetumaenyknyknndp(BizCurrency pKigetumaenyknyknndp) {
        kigetumaenyknyknndp = pKigetumaenyknyknndp;
        kigetumaenyknyknndpValue = null;
        kigetumaenyknyknndpType  = null;
    }

    transient private BigDecimal kigetumaenyknyknndpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIGETUMAENYKNYKNNDP, nullable=true)
    protected BigDecimal getKigetumaenyknyknndpValue() {
        if (kigetumaenyknyknndpValue == null && kigetumaenyknyknndp != null) {
            if (kigetumaenyknyknndp.isOptional()) return null;
            return kigetumaenyknyknndp.absolute();
        }
        return kigetumaenyknyknndpValue;
    }

    protected void setKigetumaenyknyknndpValue(BigDecimal value) {
        kigetumaenyknyknndpValue = value;
        kigetumaenyknyknndp = Optional.fromNullable(toCurrencyType(kigetumaenyknyknndpType))
            .transform(bizCurrencyTransformer(getKigetumaenyknyknndpValue()))
            .orNull();
    }

    transient private String kigetumaenyknyknndpType = null;

    @Column(name=KIGETUMAENYKNYKNNDP + "$", nullable=true)
    protected String getKigetumaenyknyknndpType() {
        if (kigetumaenyknyknndpType == null && kigetumaenyknyknndp != null) return kigetumaenyknyknndp.getType().toString();
        if (kigetumaenyknyknndpType == null && getKigetumaenyknyknndpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kigetumaenyknyknndp$' should not be NULL."));
        }
        return kigetumaenyknyknndpType;
    }

    protected void setKigetumaenyknyknndpType(String type) {
        kigetumaenyknyknndpType = type;
        kigetumaenyknyknndp = Optional.fromNullable(toCurrencyType(kigetumaenyknyknndpType))
            .transform(bizCurrencyTransformer(getKigetumaenyknyknndpValue()))
            .orNull();
    }

    private BizCurrency yknndpkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYknndpkei() {
        return yknndpkei;
    }

    public void setYknndpkei(BizCurrency pYknndpkei) {
        yknndpkei = pYknndpkei;
        yknndpkeiValue = null;
        yknndpkeiType  = null;
    }

    transient private BigDecimal yknndpkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YKNNDPKEI, nullable=true)
    protected BigDecimal getYknndpkeiValue() {
        if (yknndpkeiValue == null && yknndpkei != null) {
            if (yknndpkei.isOptional()) return null;
            return yknndpkei.absolute();
        }
        return yknndpkeiValue;
    }

    protected void setYknndpkeiValue(BigDecimal value) {
        yknndpkeiValue = value;
        yknndpkei = Optional.fromNullable(toCurrencyType(yknndpkeiType))
            .transform(bizCurrencyTransformer(getYknndpkeiValue()))
            .orNull();
    }

    transient private String yknndpkeiType = null;

    @Column(name=YKNNDPKEI + "$", nullable=true)
    protected String getYknndpkeiType() {
        if (yknndpkeiType == null && yknndpkei != null) return yknndpkei.getType().toString();
        if (yknndpkeiType == null && getYknndpkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yknndpkei$' should not be NULL."));
        }
        return yknndpkeiType;
    }

    protected void setYknndpkeiType(String type) {
        yknndpkeiType = type;
        yknndpkei = Optional.fromNullable(toCurrencyType(yknndpkeiType))
            .transform(bizCurrencyTransformer(getYknndpkeiValue()))
            .orNull();
    }

    private BizCurrency yobi03xn13;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYobi03xn13() {
        return yobi03xn13;
    }

    public void setYobi03xn13(BizCurrency pYobi03xn13) {
        yobi03xn13 = pYobi03xn13;
        yobi03xn13Value = null;
        yobi03xn13Type  = null;
    }

    transient private BigDecimal yobi03xn13Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=YOBI03XN13, nullable=true)
    protected BigDecimal getYobi03xn13Value() {
        if (yobi03xn13Value == null && yobi03xn13 != null) {
            if (yobi03xn13.isOptional()) return null;
            return yobi03xn13.absolute();
        }
        return yobi03xn13Value;
    }

    protected void setYobi03xn13Value(BigDecimal value) {
        yobi03xn13Value = value;
        yobi03xn13 = Optional.fromNullable(toCurrencyType(yobi03xn13Type))
            .transform(bizCurrencyTransformer(getYobi03xn13Value()))
            .orNull();
    }

    transient private String yobi03xn13Type = null;

    @Column(name=YOBI03XN13 + "$", nullable=true)
    protected String getYobi03xn13Type() {
        if (yobi03xn13Type == null && yobi03xn13 != null) return yobi03xn13.getType().toString();
        if (yobi03xn13Type == null && getYobi03xn13Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yobi03xn13$' should not be NULL."));
        }
        return yobi03xn13Type;
    }

    protected void setYobi03xn13Type(String type) {
        yobi03xn13Type = type;
        yobi03xn13 = Optional.fromNullable(toCurrencyType(yobi03xn13Type))
            .transform(bizCurrencyTransformer(getYobi03xn13Value()))
            .orNull();
    }

    private String yobi04xv23;

    @Column(name=GenIT_KessanYokukiP.YOBI04XV23)
    public String getYobi04xv23() {
        return yobi04xv23;
    }

    public void setYobi04xv23(String pYobi04xv23) {
        yobi04xv23 = pYobi04xv23;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KessanYokukiP.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KessanYokukiP.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KessanYokukiP.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}