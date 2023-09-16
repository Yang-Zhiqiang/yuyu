package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_RrtHndugtHknKsnJigyohiTy;
import yuyu.def.db.id.PKZT_RrtHndugtHknKsnJigyohiTy;
import yuyu.def.db.meta.GenQZT_RrtHndugtHknKsnJigyohiTy;
import yuyu.def.db.meta.QZT_RrtHndugtHknKsnJigyohiTy;

/**
 * 利率変動型保険決算用事業費Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_RrtHndugtHknKsnJigyohiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RrtHndugtHknKsnJigyohiTy}</td><td colspan="3">利率変動型保険決算用事業費Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_RrtHndugtHknKsnJigyohiTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyuukourecordlength ztyyuukourecordlength}</td><td>（中継用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrdwarea ztyrdwarea}</td><td>（中継用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeijyouym ztykeijyouym}</td><td>（中継用）計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyoupjytouym ztysuuriyoupjytouym}</td><td>（中継用）数理用Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysihankibikinkbn ztysihankibikinkbn}</td><td>（中継用）四半期備金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhenkousyoriymd ztyhenkousyoriymd}</td><td>（中継用）変更処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydenymd ztydenymd}</td><td>（中継用）伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymdmaekykhyj ztykykymdmaekykhyj}</td><td>（中継用）契約日前契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykarikasikbn ztykarikasikbn}</td><td>（中継用）借方貸方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8 ztysuuriyouyobin8}</td><td>（中継用）数理用予備項目Ｎ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7 ztyyobiv7}</td><td>（中継用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasipmenkbn ztysotodasipmenkbn}</td><td>（中継用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdssytikbn ztystdssytikbn}</td><td>（中継用）外出集定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdssnskbn ztystdssnskbn}</td><td>（中継用）外出診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasimanagehyouji ztysotodasimanagehyouji}</td><td>（中継用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasiphkbnmnoshyouji ztysotodasiphkbnmnoshyouji}</td><td>（中継用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdsstkjytkyuhyj ztystdsstkjytkyuhyj}</td><td>（中継用）外出新特条適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyoumetuzumihyouji ztykyksyoumetuzumihyouji}</td><td>（中継用）契約消滅済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrdai1hknkkn ztysrdai1hknkkn}</td><td>（中継用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin2 ztysuuriyouyobin2}</td><td>（中継用）数理用予備項目Ｎ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuukasyukbn ztytuukasyukbn}</td><td>（中継用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3 ztyyobiv3}</td><td>（中継用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentkbn ztykbnkeiriyousegmentkbn}</td><td>（中継用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyourgnbnskkbn ztykbnkeiriyourgnbnskkbn}</td><td>（中継用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuurisyuruicd ztysuurisyuruicd}</td><td>（中継用）数理種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyoukinoukbn ztyhosyoukinoukbn}</td><td>（中継用）保障機能区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydaikbn ztydaikbn}</td><td>（中継用）大区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyuukbn ztytyuukbn}</td><td>（中継用）中区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoukbn ztysyoukbn}</td><td>（中継用）小区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysedaikbn ztysedaikbn}</td><td>（中継用）世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyharaikatakbn ztyharaikatakbn}</td><td>（中継用）払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysdpdkbn ztysdpdkbn}</td><td>（中継用）Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryouritukbn ztyryouritukbn}</td><td>（中継用）料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyaagev2 ztyhihokensyaagev2}</td><td>（中継用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnentysihyj ztyhhknnentysihyj}</td><td>（中継用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakupwaribikikbn ztysyukeiyakupwaribikikbn}</td><td>（中継用）主契約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykuriagekurisagekbn ztykuriagekurisagekbn}</td><td>（中継用）繰上げ繰下げ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin11 ztysuuriyouyobin11}</td><td>（中継用）数理用予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10 ztyyobiv10}</td><td>（中継用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyalmyousohutomeisyoukbn ztyalmyousohutomeisyoukbn}</td><td>（中継用）ＡＬＭ用ソフト名称区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnkyksoftmeisyoukbn ztysnkyksoftmeisyoukbn}</td><td>（中継用）新契約ソフト名称区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysoftmeisyoukbn ztysoftmeisyoukbn}</td><td>（中継用）ソフト名称区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkaisinendo ztynenkinkaisinendo}</td><td>（中継用）年金開始年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkingatakbn ztynenkingatakbn}</td><td>（中継用）年金型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynknshry ztynknshry}</td><td>（中継用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuukeitaikbn ztybosyuukeitaikbn}</td><td>（中継用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8x2 ztysuuriyouyobin8x2}</td><td>（中継用）数理用予備項目Ｎ８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6 ztyyobiv6}</td><td>（中継用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakup ztysyukeiyakup}</td><td>（中継用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykihons ztykihons}</td><td>（中継用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtypjuutoujikawaserate ztypjuutoujikawaserate}</td><td>（中継用）保険料充当時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtypjuutoujikawasekijyunymd ztypjuutoujikawasekijyunymd}</td><td>（中継用）保険料充当時為替基準年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygessitumitatekin ztygessitumitatekin}</td><td>（中継用）月始積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5 ztyyoteiriritun5}</td><td>（中継用）予定利率Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytumitateriritu ztytumitateriritu}</td><td>（中継用）積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtygaikadatetougetujuutoup ztygaikadatetougetujuutoup}</td><td>（中継用）外貨建当月充当Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykiharaikomip ztykiharaikomip}</td><td>（中継用）既払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykeisanhanteiyoutmttkn ztykeisanhanteiyoutmttkn}</td><td>（中継用）計算判定用積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzettaisibouritu ztyzettaisibouritu}</td><td>（中継用）絶対死亡率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysoutaisibouritu ztysoutaisibouritu}</td><td>（中継用）相対死亡率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysoutaikaiyakuritu ztysoutaikaiyakuritu}</td><td>（中継用）相対解約率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyvhireilritu ztyvhireilritu}</td><td>（中継用）Ｖ比例Ｌ率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyobin13 ztyyobin13}</td><td>（中継用）予備項目Ｎ１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyphireilwrbkritu ztyphireilwrbkritu}</td><td>（中継用）Ｐ比例Ｌ割引率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtygetumatutumitatekin ztygetumatutumitatekin}</td><td>（中継用）月末積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzennoujiikkatubaraijytgk ztyzennoujiikkatubaraijytgk}</td><td>（中継用）前納時一括払充当額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatenkgns ztygaikadatenkgns}</td><td>（中継用）外貨建年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyphireialpha ztyphireialpha}</td><td>（中継用）Ｐ比例α</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyphireibeta ztyphireibeta}</td><td>（中継用）Ｐ比例β</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyphireiganma ztyphireiganma}</td><td>（中継用）Ｐ比例γ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykykjikawaserate ztykykjikawaserate}</td><td>（中継用）契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykykjikawaseratetkyuymd ztykykjikawaseratetkyuymd}</td><td>（中継用）契約時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv11 ztyyobiv11}</td><td>（中継用）予備項目Ｖ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_RrtHndugtHknKsnJigyohiTy
 * @see     PKZT_RrtHndugtHknKsnJigyohiTy
 * @see     QZT_RrtHndugtHknKsnJigyohiTy
 * @see     GenQZT_RrtHndugtHknKsnJigyohiTy
 */
@MappedSuperclass
@Table(name=GenZT_RrtHndugtHknKsnJigyohiTy.TABLE_NAME)
@IdClass(value=PKZT_RrtHndugtHknKsnJigyohiTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_RrtHndugtHknKsnJigyohiTy extends AbstractExDBEntity<ZT_RrtHndugtHknKsnJigyohiTy, PKZT_RrtHndugtHknKsnJigyohiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_RrtHndugtHknKsnJigyohiTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYUUKOURECORDLENGTH    = "ztyyuukourecordlength";
    public static final String ZTYRDWAREA               = "ztyrdwarea";
    public static final String ZTYKEIJYOUYM             = "ztykeijyouym";
    public static final String ZTYSUURIYOUPJYTOUYM      = "ztysuuriyoupjytouym";
    public static final String ZTYSIHANKIBIKINKBN       = "ztysihankibikinkbn";
    public static final String ZTYHENKOUSYORIYMD        = "ztyhenkousyoriymd";
    public static final String ZTYDENYMD                = "ztydenymd";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYKYKYMDMAEKYKHYJ       = "ztykykymdmaekykhyj";
    public static final String ZTYKARIKASIKBN           = "ztykarikasikbn";
    public static final String ZTYSUURIYOUYOBIN8        = "ztysuuriyouyobin8";
    public static final String ZTYYOBIV7                = "ztyyobiv7";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYSOTODASIPMENKBN       = "ztysotodasipmenkbn";
    public static final String ZTYSTDSSYTIKBN           = "ztystdssytikbn";
    public static final String ZTYSTDSSNSKBN            = "ztystdssnskbn";
    public static final String ZTYSOTODASIMANAGEHYOUJI  = "ztysotodasimanagehyouji";
    public static final String ZTYSOTODASIPHKBNMNOSHYOUJI = "ztysotodasiphkbnmnoshyouji";
    public static final String ZTYSTDSSTKJYTKYUHYJ      = "ztystdsstkjytkyuhyj";
    public static final String ZTYKYKSYOUMETUZUMIHYOUJI = "ztykyksyoumetuzumihyouji";
    public static final String ZTYSRDAI1HKNKKN          = "ztysrdai1hknkkn";
    public static final String ZTYSUURIYOUYOBIN2        = "ztysuuriyouyobin2";
    public static final String ZTYTUUKASYUKBN           = "ztytuukasyukbn";
    public static final String ZTYYOBIV3                = "ztyyobiv3";
    public static final String ZTYKBNKEIRIYOUSEGMENTKBN = "ztykbnkeiriyousegmentkbn";
    public static final String ZTYKBNKEIRIYOURGNBNSKKBN = "ztykbnkeiriyourgnbnskkbn";
    public static final String ZTYSUURISYURUICD         = "ztysuurisyuruicd";
    public static final String ZTYHOSYOUKINOUKBN        = "ztyhosyoukinoukbn";
    public static final String ZTYDAIKBN                = "ztydaikbn";
    public static final String ZTYTYUUKBN               = "ztytyuukbn";
    public static final String ZTYSYOUKBN               = "ztysyoukbn";
    public static final String ZTYSEDAIKBN              = "ztysedaikbn";
    public static final String ZTYHARAIKATAKBN          = "ztyharaikatakbn";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYSDPDKBN               = "ztysdpdkbn";
    public static final String ZTYRYOURITUKBN           = "ztyryouritukbn";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHIHOKENSYAAGEV2       = "ztyhihokensyaagev2";
    public static final String ZTYHHKNNENTYSIHYJ        = "ztyhhknnentysihyj";
    public static final String ZTYSYUKEIYAKUPWARIBIKIKBN = "ztysyukeiyakupwaribikikbn";
    public static final String ZTYKURIAGEKURISAGEKBN    = "ztykuriagekurisagekbn";
    public static final String ZTYSUURIYOUYOBIN11       = "ztysuuriyouyobin11";
    public static final String ZTYYOBIV10               = "ztyyobiv10";
    public static final String ZTYALMYOUSOHUTOMEISYOUKBN = "ztyalmyousohutomeisyoukbn";
    public static final String ZTYSNKYKSOFTMEISYOUKBN   = "ztysnkyksoftmeisyoukbn";
    public static final String ZTYSOFTMEISYOUKBN        = "ztysoftmeisyoukbn";
    public static final String ZTYNENKINKAISINENDO      = "ztynenkinkaisinendo";
    public static final String ZTYNENKINGATAKBN         = "ztynenkingatakbn";
    public static final String ZTYNKNSHRY               = "ztynknshry";
    public static final String ZTYBOSYUUKEITAIKBN       = "ztybosyuukeitaikbn";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYSUURIYOUYOBIN8X2      = "ztysuuriyouyobin8x2";
    public static final String ZTYYOBIV6                = "ztyyobiv6";
    public static final String ZTYSYUKEIYAKUP           = "ztysyukeiyakup";
    public static final String ZTYKIHONS                = "ztykihons";
    public static final String ZTYPJUUTOUJIKAWASERATE   = "ztypjuutoujikawaserate";
    public static final String ZTYPJUUTOUJIKAWASEKIJYUNYMD = "ztypjuutoujikawasekijyunymd";
    public static final String ZTYGESSITUMITATEKIN      = "ztygessitumitatekin";
    public static final String ZTYYOTEIRIRITUN5         = "ztyyoteiriritun5";
    public static final String ZTYTUMITATERIRITU        = "ztytumitateriritu";
    public static final String ZTYGAIKADATETOUGETUJUUTOUP = "ztygaikadatetougetujuutoup";
    public static final String ZTYKIHARAIKOMIP          = "ztykiharaikomip";
    public static final String ZTYKEISANHANTEIYOUTMTTKN = "ztykeisanhanteiyoutmttkn";
    public static final String ZTYZETTAISIBOURITU       = "ztyzettaisibouritu";
    public static final String ZTYSOUTAISIBOURITU       = "ztysoutaisibouritu";
    public static final String ZTYSOUTAIKAIYAKURITU     = "ztysoutaikaiyakuritu";
    public static final String ZTYVHIREILRITU           = "ztyvhireilritu";
    public static final String ZTYYOBIN13               = "ztyyobin13";
    public static final String ZTYPHIREILWRBKRITU       = "ztyphireilwrbkritu";
    public static final String ZTYGETUMATUTUMITATEKIN   = "ztygetumatutumitatekin";
    public static final String ZTYZENNOUJIIKKATUBARAIJYTGK = "ztyzennoujiikkatubaraijytgk";
    public static final String ZTYGAIKADATENKGNS        = "ztygaikadatenkgns";
    public static final String ZTYPHIREIALPHA           = "ztyphireialpha";
    public static final String ZTYPHIREIBETA            = "ztyphireibeta";
    public static final String ZTYPHIREIGANMA           = "ztyphireiganma";
    public static final String ZTYKYKJIKAWASERATE       = "ztykykjikawaserate";
    public static final String ZTYKYKJIKAWASERATETKYUYMD = "ztykykjikawaseratetkyuymd";
    public static final String ZTYYOBIV11               = "ztyyobiv11";

    private final PKZT_RrtHndugtHknKsnJigyohiTy primaryKey;

    public GenZT_RrtHndugtHknKsnJigyohiTy() {
        primaryKey = new PKZT_RrtHndugtHknKsnJigyohiTy();
    }

    public GenZT_RrtHndugtHknKsnJigyohiTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_RrtHndugtHknKsnJigyohiTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_RrtHndugtHknKsnJigyohiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_RrtHndugtHknKsnJigyohiTy> getMetaClass() {
        return QZT_RrtHndugtHknKsnJigyohiTy.class;
    }

    @Id
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztykeijyouym;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYKEIJYOUYM)
    public String getZtykeijyouym() {
        return ztykeijyouym;
    }

    public void setZtykeijyouym(String pZtykeijyouym) {
        ztykeijyouym = pZtykeijyouym;
    }

    private String ztysuuriyoupjytouym;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSUURIYOUPJYTOUYM)
    public String getZtysuuriyoupjytouym() {
        return ztysuuriyoupjytouym;
    }

    public void setZtysuuriyoupjytouym(String pZtysuuriyoupjytouym) {
        ztysuuriyoupjytouym = pZtysuuriyoupjytouym;
    }

    private String ztysihankibikinkbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSIHANKIBIKINKBN)
    public String getZtysihankibikinkbn() {
        return ztysihankibikinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysihankibikinkbn(String pZtysihankibikinkbn) {
        ztysihankibikinkbn = pZtysihankibikinkbn;
    }

    private String ztyhenkousyoriymd;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYHENKOUSYORIYMD)
    public String getZtyhenkousyoriymd() {
        return ztyhenkousyoriymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhenkousyoriymd(String pZtyhenkousyoriymd) {
        ztyhenkousyoriymd = pZtyhenkousyoriymd;
    }

    private String ztydenymd;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYDENYMD)
    public String getZtydenymd() {
        return ztydenymd;
    }

    public void setZtydenymd(String pZtydenymd) {
        ztydenymd = pZtydenymd;
    }

    private String ztysyoricd;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    private String ztykykymdmaekykhyj;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYKYKYMDMAEKYKHYJ)
    public String getZtykykymdmaekykhyj() {
        return ztykykymdmaekykhyj;
    }

    public void setZtykykymdmaekykhyj(String pZtykykymdmaekykhyj) {
        ztykykymdmaekykhyj = pZtykykymdmaekykhyj;
    }

    private String ztykarikasikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYKARIKASIKBN)
    public String getZtykarikasikbn() {
        return ztykarikasikbn;
    }

    public void setZtykarikasikbn(String pZtykarikasikbn) {
        ztykarikasikbn = pZtykarikasikbn;
    }

    private String ztysuuriyouyobin8;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSUURIYOUYOBIN8)
    public String getZtysuuriyouyobin8() {
        return ztysuuriyouyobin8;
    }

    public void setZtysuuriyouyobin8(String pZtysuuriyouyobin8) {
        ztysuuriyouyobin8 = pZtysuuriyouyobin8;
    }

    private String ztyyobiv7;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYYOBIV7)
    public String getZtyyobiv7() {
        return ztyyobiv7;
    }

    public void setZtyyobiv7(String pZtyyobiv7) {
        ztyyobiv7 = pZtyyobiv7;
    }

    private String ztydatakanrino;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztysotodasipmenkbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSOTODASIPMENKBN)
    public String getZtysotodasipmenkbn() {
        return ztysotodasipmenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasipmenkbn(String pZtysotodasipmenkbn) {
        ztysotodasipmenkbn = pZtysotodasipmenkbn;
    }

    private String ztystdssytikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSTDSSYTIKBN)
    public String getZtystdssytikbn() {
        return ztystdssytikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdssytikbn(String pZtystdssytikbn) {
        ztystdssytikbn = pZtystdssytikbn;
    }

    private String ztystdssnskbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSTDSSNSKBN)
    public String getZtystdssnskbn() {
        return ztystdssnskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdssnskbn(String pZtystdssnskbn) {
        ztystdssnskbn = pZtystdssnskbn;
    }

    private String ztysotodasimanagehyouji;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSOTODASIMANAGEHYOUJI)
    public String getZtysotodasimanagehyouji() {
        return ztysotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasimanagehyouji(String pZtysotodasimanagehyouji) {
        ztysotodasimanagehyouji = pZtysotodasimanagehyouji;
    }

    private String ztysotodasiphkbnmnoshyouji;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSOTODASIPHKBNMNOSHYOUJI)
    public String getZtysotodasiphkbnmnoshyouji() {
        return ztysotodasiphkbnmnoshyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasiphkbnmnoshyouji(String pZtysotodasiphkbnmnoshyouji) {
        ztysotodasiphkbnmnoshyouji = pZtysotodasiphkbnmnoshyouji;
    }

    private String ztystdsstkjytkyuhyj;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSTDSSTKJYTKYUHYJ)
    public String getZtystdsstkjytkyuhyj() {
        return ztystdsstkjytkyuhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdsstkjytkyuhyj(String pZtystdsstkjytkyuhyj) {
        ztystdsstkjytkyuhyj = pZtystdsstkjytkyuhyj;
    }

    private String ztykyksyoumetuzumihyouji;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYKYKSYOUMETUZUMIHYOUJI)
    public String getZtykyksyoumetuzumihyouji() {
        return ztykyksyoumetuzumihyouji;
    }

    public void setZtykyksyoumetuzumihyouji(String pZtykyksyoumetuzumihyouji) {
        ztykyksyoumetuzumihyouji = pZtykyksyoumetuzumihyouji;
    }

    private String ztysrdai1hknkkn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSRDAI1HKNKKN)
    public String getZtysrdai1hknkkn() {
        return ztysrdai1hknkkn;
    }

    public void setZtysrdai1hknkkn(String pZtysrdai1hknkkn) {
        ztysrdai1hknkkn = pZtysrdai1hknkkn;
    }

    private String ztysuuriyouyobin2;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSUURIYOUYOBIN2)
    public String getZtysuuriyouyobin2() {
        return ztysuuriyouyobin2;
    }

    public void setZtysuuriyouyobin2(String pZtysuuriyouyobin2) {
        ztysuuriyouyobin2 = pZtysuuriyouyobin2;
    }

    private String ztytuukasyukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYTUUKASYUKBN)
    public String getZtytuukasyukbn() {
        return ztytuukasyukbn;
    }

    public void setZtytuukasyukbn(String pZtytuukasyukbn) {
        ztytuukasyukbn = pZtytuukasyukbn;
    }

    private String ztyyobiv3;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYYOBIV3)
    public String getZtyyobiv3() {
        return ztyyobiv3;
    }

    public void setZtyyobiv3(String pZtyyobiv3) {
        ztyyobiv3 = pZtyyobiv3;
    }

    private String ztykbnkeiriyousegmentkbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYKBNKEIRIYOUSEGMENTKBN)
    public String getZtykbnkeiriyousegmentkbn() {
        return ztykbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyousegmentkbn(String pZtykbnkeiriyousegmentkbn) {
        ztykbnkeiriyousegmentkbn = pZtykbnkeiriyousegmentkbn;
    }

    private String ztykbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYKBNKEIRIYOURGNBNSKKBN)
    public String getZtykbnkeiriyourgnbnskkbn() {
        return ztykbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyourgnbnskkbn(String pZtykbnkeiriyourgnbnskkbn) {
        ztykbnkeiriyourgnbnskkbn = pZtykbnkeiriyourgnbnskkbn;
    }

    private String ztysuurisyuruicd;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSUURISYURUICD)
    public String getZtysuurisyuruicd() {
        return ztysuurisyuruicd;
    }

    public void setZtysuurisyuruicd(String pZtysuurisyuruicd) {
        ztysuurisyuruicd = pZtysuurisyuruicd;
    }

    private String ztyhosyoukinoukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYHOSYOUKINOUKBN)
    public String getZtyhosyoukinoukbn() {
        return ztyhosyoukinoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhosyoukinoukbn(String pZtyhosyoukinoukbn) {
        ztyhosyoukinoukbn = pZtyhosyoukinoukbn;
    }

    private String ztydaikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYDAIKBN)
    public String getZtydaikbn() {
        return ztydaikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydaikbn(String pZtydaikbn) {
        ztydaikbn = pZtydaikbn;
    }

    private String ztytyuukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYTYUUKBN)
    public String getZtytyuukbn() {
        return ztytyuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtytyuukbn(String pZtytyuukbn) {
        ztytyuukbn = pZtytyuukbn;
    }

    private String ztysyoukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSYOUKBN)
    public String getZtysyoukbn() {
        return ztysyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtysyoukbn(String pZtysyoukbn) {
        ztysyoukbn = pZtysyoukbn;
    }

    private String ztysedaikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSEDAIKBN)
    public String getZtysedaikbn() {
        return ztysedaikbn;
    }

    public void setZtysedaikbn(String pZtysedaikbn) {
        ztysedaikbn = pZtysedaikbn;
    }

    private String ztyharaikatakbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYHARAIKATAKBN)
    public String getZtyharaikatakbn() {
        return ztyharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyharaikatakbn(String pZtyharaikatakbn) {
        ztyharaikatakbn = pZtyharaikatakbn;
    }

    private String ztykykymd;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztysdpdkbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSDPDKBN)
    public String getZtysdpdkbn() {
        return ztysdpdkbn;
    }

    public void setZtysdpdkbn(String pZtysdpdkbn) {
        ztysdpdkbn = pZtysdpdkbn;
    }

    private String ztyryouritukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYRYOURITUKBN)
    public String getZtyryouritukbn() {
        return ztyryouritukbn;
    }

    public void setZtyryouritukbn(String pZtyryouritukbn) {
        ztyryouritukbn = pZtyryouritukbn;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String ztyhhknnentysihyj;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYHHKNNENTYSIHYJ)
    public String getZtyhhknnentysihyj() {
        return ztyhhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhhknnentysihyj(String pZtyhhknnentysihyj) {
        ztyhhknnentysihyj = pZtyhhknnentysihyj;
    }

    private String ztysyukeiyakupwaribikikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSYUKEIYAKUPWARIBIKIKBN)
    public String getZtysyukeiyakupwaribikikbn() {
        return ztysyukeiyakupwaribikikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysyukeiyakupwaribikikbn(String pZtysyukeiyakupwaribikikbn) {
        ztysyukeiyakupwaribikikbn = pZtysyukeiyakupwaribikikbn;
    }

    private String ztykuriagekurisagekbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYKURIAGEKURISAGEKBN)
    public String getZtykuriagekurisagekbn() {
        return ztykuriagekurisagekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykuriagekurisagekbn(String pZtykuriagekurisagekbn) {
        ztykuriagekurisagekbn = pZtykuriagekurisagekbn;
    }

    private String ztysuuriyouyobin11;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSUURIYOUYOBIN11)
    public String getZtysuuriyouyobin11() {
        return ztysuuriyouyobin11;
    }

    public void setZtysuuriyouyobin11(String pZtysuuriyouyobin11) {
        ztysuuriyouyobin11 = pZtysuuriyouyobin11;
    }

    private String ztyyobiv10;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYYOBIV10)
    public String getZtyyobiv10() {
        return ztyyobiv10;
    }

    public void setZtyyobiv10(String pZtyyobiv10) {
        ztyyobiv10 = pZtyyobiv10;
    }

    private String ztyalmyousohutomeisyoukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYALMYOUSOHUTOMEISYOUKBN)
    public String getZtyalmyousohutomeisyoukbn() {
        return ztyalmyousohutomeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyalmyousohutomeisyoukbn(String pZtyalmyousohutomeisyoukbn) {
        ztyalmyousohutomeisyoukbn = pZtyalmyousohutomeisyoukbn;
    }

    private String ztysnkyksoftmeisyoukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSNKYKSOFTMEISYOUKBN)
    public String getZtysnkyksoftmeisyoukbn() {
        return ztysnkyksoftmeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysnkyksoftmeisyoukbn(String pZtysnkyksoftmeisyoukbn) {
        ztysnkyksoftmeisyoukbn = pZtysnkyksoftmeisyoukbn;
    }

    private String ztysoftmeisyoukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSOFTMEISYOUKBN)
    public String getZtysoftmeisyoukbn() {
        return ztysoftmeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysoftmeisyoukbn(String pZtysoftmeisyoukbn) {
        ztysoftmeisyoukbn = pZtysoftmeisyoukbn;
    }

    private String ztynenkinkaisinendo;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYNENKINKAISINENDO)
    public String getZtynenkinkaisinendo() {
        return ztynenkinkaisinendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtynenkinkaisinendo(String pZtynenkinkaisinendo) {
        ztynenkinkaisinendo = pZtynenkinkaisinendo;
    }

    private String ztynenkingatakbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYNENKINGATAKBN)
    public String getZtynenkingatakbn() {
        return ztynenkingatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtynenkingatakbn(String pZtynenkingatakbn) {
        ztynenkingatakbn = pZtynenkingatakbn;
    }

    private String ztynknshry;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYNKNSHRY)
    public String getZtynknshry() {
        return ztynknshry;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtynknshry(String pZtynknshry) {
        ztynknshry = pZtynknshry;
    }

    private String ztybosyuukeitaikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYBOSYUUKEITAIKBN)
    public String getZtybosyuukeitaikbn() {
        return ztybosyuukeitaikbn;
    }

    public void setZtybosyuukeitaikbn(String pZtybosyuukeitaikbn) {
        ztybosyuukeitaikbn = pZtybosyuukeitaikbn;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private String ztysuuriyouyobin8x2;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSUURIYOUYOBIN8X2)
    public String getZtysuuriyouyobin8x2() {
        return ztysuuriyouyobin8x2;
    }

    public void setZtysuuriyouyobin8x2(String pZtysuuriyouyobin8x2) {
        ztysuuriyouyobin8x2 = pZtysuuriyouyobin8x2;
    }

    private String ztyyobiv6;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }

    private Long ztysyukeiyakup;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSYUKEIYAKUP)
    public Long getZtysyukeiyakup() {
        return ztysyukeiyakup;
    }

    public void setZtysyukeiyakup(Long pZtysyukeiyakup) {
        ztysyukeiyakup = pZtysyukeiyakup;
    }

    private Long ztykihons;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYKIHONS)
    public Long getZtykihons() {
        return ztykihons;
    }

    public void setZtykihons(Long pZtykihons) {
        ztykihons = pZtykihons;
    }

    private BizNumber ztypjuutoujikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYPJUUTOUJIKAWASERATE)
    public BizNumber getZtypjuutoujikawaserate() {
        return ztypjuutoujikawaserate;
    }

    public void setZtypjuutoujikawaserate(BizNumber pZtypjuutoujikawaserate) {
        ztypjuutoujikawaserate = pZtypjuutoujikawaserate;
    }

    private String ztypjuutoujikawasekijyunymd;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYPJUUTOUJIKAWASEKIJYUNYMD)
    public String getZtypjuutoujikawasekijyunymd() {
        return ztypjuutoujikawasekijyunymd;
    }

    public void setZtypjuutoujikawasekijyunymd(String pZtypjuutoujikawasekijyunymd) {
        ztypjuutoujikawasekijyunymd = pZtypjuutoujikawasekijyunymd;
    }

    private Long ztygessitumitatekin;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYGESSITUMITATEKIN)
    public Long getZtygessitumitatekin() {
        return ztygessitumitatekin;
    }

    public void setZtygessitumitatekin(Long pZtygessitumitatekin) {
        ztygessitumitatekin = pZtygessitumitatekin;
    }

    private BizNumber ztyyoteiriritun5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYYOTEIRIRITUN5)
    public BizNumber getZtyyoteiriritun5() {
        return ztyyoteiriritun5;
    }

    public void setZtyyoteiriritun5(BizNumber pZtyyoteiriritun5) {
        ztyyoteiriritun5 = pZtyyoteiriritun5;
    }

    private BizNumber ztytumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYTUMITATERIRITU)
    public BizNumber getZtytumitateriritu() {
        return ztytumitateriritu;
    }

    public void setZtytumitateriritu(BizNumber pZtytumitateriritu) {
        ztytumitateriritu = pZtytumitateriritu;
    }

    private Long ztygaikadatetougetujuutoup;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYGAIKADATETOUGETUJUUTOUP)
    public Long getZtygaikadatetougetujuutoup() {
        return ztygaikadatetougetujuutoup;
    }

    public void setZtygaikadatetougetujuutoup(Long pZtygaikadatetougetujuutoup) {
        ztygaikadatetougetujuutoup = pZtygaikadatetougetujuutoup;
    }

    private Long ztykiharaikomip;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYKIHARAIKOMIP)
    public Long getZtykiharaikomip() {
        return ztykiharaikomip;
    }

    public void setZtykiharaikomip(Long pZtykiharaikomip) {
        ztykiharaikomip = pZtykiharaikomip;
    }

    private Long ztykeisanhanteiyoutmttkn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYKEISANHANTEIYOUTMTTKN)
    public Long getZtykeisanhanteiyoutmttkn() {
        return ztykeisanhanteiyoutmttkn;
    }

    public void setZtykeisanhanteiyoutmttkn(Long pZtykeisanhanteiyoutmttkn) {
        ztykeisanhanteiyoutmttkn = pZtykeisanhanteiyoutmttkn;
    }

    private BizNumber ztyzettaisibouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYZETTAISIBOURITU)
    public BizNumber getZtyzettaisibouritu() {
        return ztyzettaisibouritu;
    }

    public void setZtyzettaisibouritu(BizNumber pZtyzettaisibouritu) {
        ztyzettaisibouritu = pZtyzettaisibouritu;
    }

    private BizNumber ztysoutaisibouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSOUTAISIBOURITU)
    public BizNumber getZtysoutaisibouritu() {
        return ztysoutaisibouritu;
    }

    public void setZtysoutaisibouritu(BizNumber pZtysoutaisibouritu) {
        ztysoutaisibouritu = pZtysoutaisibouritu;
    }

    private BizNumber ztysoutaikaiyakuritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYSOUTAIKAIYAKURITU)
    public BizNumber getZtysoutaikaiyakuritu() {
        return ztysoutaikaiyakuritu;
    }

    public void setZtysoutaikaiyakuritu(BizNumber pZtysoutaikaiyakuritu) {
        ztysoutaikaiyakuritu = pZtysoutaikaiyakuritu;
    }

    private BizNumber ztyvhireilritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYVHIREILRITU)
    public BizNumber getZtyvhireilritu() {
        return ztyvhireilritu;
    }

    public void setZtyvhireilritu(BizNumber pZtyvhireilritu) {
        ztyvhireilritu = pZtyvhireilritu;
    }

    private Long ztyyobin13;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYYOBIN13)
    public Long getZtyyobin13() {
        return ztyyobin13;
    }

    public void setZtyyobin13(Long pZtyyobin13) {
        ztyyobin13 = pZtyyobin13;
    }

    private BizNumber ztyphireilwrbkritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYPHIREILWRBKRITU)
    public BizNumber getZtyphireilwrbkritu() {
        return ztyphireilwrbkritu;
    }

    public void setZtyphireilwrbkritu(BizNumber pZtyphireilwrbkritu) {
        ztyphireilwrbkritu = pZtyphireilwrbkritu;
    }

    private Long ztygetumatutumitatekin;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYGETUMATUTUMITATEKIN)
    public Long getZtygetumatutumitatekin() {
        return ztygetumatutumitatekin;
    }

    public void setZtygetumatutumitatekin(Long pZtygetumatutumitatekin) {
        ztygetumatutumitatekin = pZtygetumatutumitatekin;
    }

    private Long ztyzennoujiikkatubaraijytgk;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYZENNOUJIIKKATUBARAIJYTGK)
    public Long getZtyzennoujiikkatubaraijytgk() {
        return ztyzennoujiikkatubaraijytgk;
    }

    public void setZtyzennoujiikkatubaraijytgk(Long pZtyzennoujiikkatubaraijytgk) {
        ztyzennoujiikkatubaraijytgk = pZtyzennoujiikkatubaraijytgk;
    }

    private Long ztygaikadatenkgns;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYGAIKADATENKGNS)
    public Long getZtygaikadatenkgns() {
        return ztygaikadatenkgns;
    }

    public void setZtygaikadatenkgns(Long pZtygaikadatenkgns) {
        ztygaikadatenkgns = pZtygaikadatenkgns;
    }

    private BizNumber ztyphireialpha;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYPHIREIALPHA)
    public BizNumber getZtyphireialpha() {
        return ztyphireialpha;
    }

    public void setZtyphireialpha(BizNumber pZtyphireialpha) {
        ztyphireialpha = pZtyphireialpha;
    }

    private BizNumber ztyphireibeta;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYPHIREIBETA)
    public BizNumber getZtyphireibeta() {
        return ztyphireibeta;
    }

    public void setZtyphireibeta(BizNumber pZtyphireibeta) {
        ztyphireibeta = pZtyphireibeta;
    }

    private BizNumber ztyphireiganma;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYPHIREIGANMA)
    public BizNumber getZtyphireiganma() {
        return ztyphireiganma;
    }

    public void setZtyphireiganma(BizNumber pZtyphireiganma) {
        ztyphireiganma = pZtyphireiganma;
    }

    private BizNumber ztykykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYKYKJIKAWASERATE)
    public BizNumber getZtykykjikawaserate() {
        return ztykykjikawaserate;
    }

    public void setZtykykjikawaserate(BizNumber pZtykykjikawaserate) {
        ztykykjikawaserate = pZtykykjikawaserate;
    }

    private String ztykykjikawaseratetkyuymd;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYKYKJIKAWASERATETKYUYMD)
    public String getZtykykjikawaseratetkyuymd() {
        return ztykykjikawaseratetkyuymd;
    }

    public void setZtykykjikawaseratetkyuymd(String pZtykykjikawaseratetkyuymd) {
        ztykykjikawaseratetkyuymd = pZtykykjikawaseratetkyuymd;
    }

    private String ztyyobiv11;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiTy.ZTYYOBIV11)
    public String getZtyyobiv11() {
        return ztyyobiv11;
    }

    public void setZtyyobiv11(String pZtyyobiv11) {
        ztyyobiv11 = pZtyyobiv11;
    }
}