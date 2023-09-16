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
import yuyu.def.db.entity.ZT_RrtHndugtHknKsnJigyohiRn;
import yuyu.def.db.id.PKZT_RrtHndugtHknKsnJigyohiRn;
import yuyu.def.db.meta.GenQZT_RrtHndugtHknKsnJigyohiRn;
import yuyu.def.db.meta.QZT_RrtHndugtHknKsnJigyohiRn;

/**
 * 利率変動型保険決算用事業費Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_RrtHndugtHknKsnJigyohiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RrtHndugtHknKsnJigyohiRn}</td><td colspan="3">利率変動型保険決算用事業費Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_RrtHndugtHknKsnJigyohiRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyuukourecordlength zrnyuukourecordlength}</td><td>（連携用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrdwarea zrnrdwarea}</td><td>（連携用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeijyouym zrnkeijyouym}</td><td>（連携用）計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyoupjytouym zrnsuuriyoupjytouym}</td><td>（連携用）数理用Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsihankibikinkbn zrnsihankibikinkbn}</td><td>（連携用）四半期備金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhenkousyoriymd zrnhenkousyoriymd}</td><td>（連携用）変更処理年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndenymd zrndenymd}</td><td>（連携用）伝票日付</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymdmaekykhyj zrnkykymdmaekykhyj}</td><td>（連携用）契約日前契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkarikasikbn zrnkarikasikbn}</td><td>（連携用）借方貸方区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8 zrnsuuriyouyobin8}</td><td>（連携用）数理用予備項目Ｎ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7 zrnyobiv7}</td><td>（連携用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasipmenkbn zrnsotodasipmenkbn}</td><td>（連携用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdssytikbn zrnstdssytikbn}</td><td>（連携用）外出集定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdssnskbn zrnstdssnskbn}</td><td>（連携用）外出診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasimanagehyouji zrnsotodasimanagehyouji}</td><td>（連携用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasiphkbnmnoshyouji zrnsotodasiphkbnmnoshyouji}</td><td>（連携用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdsstkjytkyuhyj zrnstdsstkjytkyuhyj}</td><td>（連携用）外出新特条適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyoumetuzumihyouji zrnkyksyoumetuzumihyouji}</td><td>（連携用）契約消滅済表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrdai1hknkkn zrnsrdai1hknkkn}</td><td>（連携用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin2 zrnsuuriyouyobin2}</td><td>（連携用）数理用予備項目Ｎ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3 zrnyobiv3}</td><td>（連携用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentkbn zrnkbnkeiriyousegmentkbn}</td><td>（連携用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyourgnbnskkbn zrnkbnkeiriyourgnbnskkbn}</td><td>（連携用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuurisyuruicd zrnsuurisyuruicd}</td><td>（連携用）数理種類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyoukinoukbn zrnhosyoukinoukbn}</td><td>（連携用）保障機能区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaikbn zrndaikbn}</td><td>（連携用）大区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuukbn zrntyuukbn}</td><td>（連携用）中区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoukbn zrnsyoukbn}</td><td>（連携用）小区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsedaikbn zrnsedaikbn}</td><td>（連携用）世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnharaikatakbn zrnharaikatakbn}</td><td>（連携用）払方区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsdpdkbn zrnsdpdkbn}</td><td>（連携用）Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryouritukbn zrnryouritukbn}</td><td>（連携用）料率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyaagev2 zrnhihokensyaagev2}</td><td>（連携用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnentysihyj zrnhhknnentysihyj}</td><td>（連携用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakupwaribikikbn zrnsyukeiyakupwaribikikbn}</td><td>（連携用）主契約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkuriagekurisagekbn zrnkuriagekurisagekbn}</td><td>（連携用）繰上げ繰下げ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin11 zrnsuuriyouyobin11}</td><td>（連携用）数理用予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10 zrnyobiv10}</td><td>（連携用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnalmyousohutomeisyoukbn zrnalmyousohutomeisyoukbn}</td><td>（連携用）ＡＬＭ用ソフト名称区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnkyksoftmeisyoukbn zrnsnkyksoftmeisyoukbn}</td><td>（連携用）新契約ソフト名称区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsoftmeisyoukbn zrnsoftmeisyoukbn}</td><td>（連携用）ソフト名称区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisinendo zrnnenkinkaisinendo}</td><td>（連携用）年金開始年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkingatakbn zrnnenkingatakbn}</td><td>（連携用）年金型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknshry zrnnknshry}</td><td>（連携用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeitaikbn zrnbosyuukeitaikbn}</td><td>（連携用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8x2 zrnsuuriyouyobin8x2}</td><td>（連携用）数理用予備項目Ｎ８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6 zrnyobiv6}</td><td>（連携用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakup zrnsyukeiyakup}</td><td>（連携用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkihons zrnkihons}</td><td>（連携用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnpjuutoujikawaserate zrnpjuutoujikawaserate}</td><td>（連携用）保険料充当時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnpjuutoujikawasekijyunymd zrnpjuutoujikawasekijyunymd}</td><td>（連携用）保険料充当時為替基準年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngessitumitatekin zrngessitumitatekin}</td><td>（連携用）月始積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5 zrnyoteiriritun5}</td><td>（連携用）予定利率Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntumitateriritu zrntumitateriritu}</td><td>（連携用）積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrngaikadatetougetujuutoup zrngaikadatetougetujuutoup}</td><td>（連携用）外貨建当月充当Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkiharaikomip zrnkiharaikomip}</td><td>（連携用）既払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkeisanhanteiyoutmttkn zrnkeisanhanteiyoutmttkn}</td><td>（連携用）計算判定用積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzettaisibouritu zrnzettaisibouritu}</td><td>（連携用）絶対死亡率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsoutaisibouritu zrnsoutaisibouritu}</td><td>（連携用）相対死亡率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsoutaikaiyakuritu zrnsoutaikaiyakuritu}</td><td>（連携用）相対解約率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnvhireilritu zrnvhireilritu}</td><td>（連携用）Ｖ比例Ｌ率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyobin13 zrnyobin13}</td><td>（連携用）予備項目Ｎ１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnphireilwrbkritu zrnphireilwrbkritu}</td><td>（連携用）Ｐ比例Ｌ割引率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrngetumatutumitatekin zrngetumatutumitatekin}</td><td>（連携用）月末積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzennoujiikkatubaraijytgk zrnzennoujiikkatubaraijytgk}</td><td>（連携用）前納時一括払充当額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatenkgns zrngaikadatenkgns}</td><td>（連携用）外貨建年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnphireialpha zrnphireialpha}</td><td>（連携用）Ｐ比例α</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnphireibeta zrnphireibeta}</td><td>（連携用）Ｐ比例β</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnphireiganma zrnphireiganma}</td><td>（連携用）Ｐ比例γ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkykjikawaserate zrnkykjikawaserate}</td><td>（連携用）契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkykjikawaseratetkyuymd zrnkykjikawaseratetkyuymd}</td><td>（連携用）契約時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv11 zrnyobiv11}</td><td>（連携用）予備項目Ｖ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_RrtHndugtHknKsnJigyohiRn
 * @see     PKZT_RrtHndugtHknKsnJigyohiRn
 * @see     QZT_RrtHndugtHknKsnJigyohiRn
 * @see     GenQZT_RrtHndugtHknKsnJigyohiRn
 */
@MappedSuperclass
@Table(name=GenZT_RrtHndugtHknKsnJigyohiRn.TABLE_NAME)
@IdClass(value=PKZT_RrtHndugtHknKsnJigyohiRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_RrtHndugtHknKsnJigyohiRn extends AbstractExDBEntityForZDB<ZT_RrtHndugtHknKsnJigyohiRn, PKZT_RrtHndugtHknKsnJigyohiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_RrtHndugtHknKsnJigyohiRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYUUKOURECORDLENGTH    = "zrnyuukourecordlength";
    public static final String ZRNRDWAREA               = "zrnrdwarea";
    public static final String ZRNKEIJYOUYM             = "zrnkeijyouym";
    public static final String ZRNSUURIYOUPJYTOUYM      = "zrnsuuriyoupjytouym";
    public static final String ZRNSIHANKIBIKINKBN       = "zrnsihankibikinkbn";
    public static final String ZRNHENKOUSYORIYMD        = "zrnhenkousyoriymd";
    public static final String ZRNDENYMD                = "zrndenymd";
    public static final String ZRNSYORICD               = "zrnsyoricd";
    public static final String ZRNKYKYMDMAEKYKHYJ       = "zrnkykymdmaekykhyj";
    public static final String ZRNKARIKASIKBN           = "zrnkarikasikbn";
    public static final String ZRNSUURIYOUYOBIN8        = "zrnsuuriyouyobin8";
    public static final String ZRNYOBIV7                = "zrnyobiv7";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNSOTODASIPMENKBN       = "zrnsotodasipmenkbn";
    public static final String ZRNSTDSSYTIKBN           = "zrnstdssytikbn";
    public static final String ZRNSTDSSNSKBN            = "zrnstdssnskbn";
    public static final String ZRNSOTODASIMANAGEHYOUJI  = "zrnsotodasimanagehyouji";
    public static final String ZRNSOTODASIPHKBNMNOSHYOUJI = "zrnsotodasiphkbnmnoshyouji";
    public static final String ZRNSTDSSTKJYTKYUHYJ      = "zrnstdsstkjytkyuhyj";
    public static final String ZRNKYKSYOUMETUZUMIHYOUJI = "zrnkyksyoumetuzumihyouji";
    public static final String ZRNSRDAI1HKNKKN          = "zrnsrdai1hknkkn";
    public static final String ZRNSUURIYOUYOBIN2        = "zrnsuuriyouyobin2";
    public static final String ZRNTUUKASYUKBN           = "zrntuukasyukbn";
    public static final String ZRNYOBIV3                = "zrnyobiv3";
    public static final String ZRNKBNKEIRIYOUSEGMENTKBN = "zrnkbnkeiriyousegmentkbn";
    public static final String ZRNKBNKEIRIYOURGNBNSKKBN = "zrnkbnkeiriyourgnbnskkbn";
    public static final String ZRNSUURISYURUICD         = "zrnsuurisyuruicd";
    public static final String ZRNHOSYOUKINOUKBN        = "zrnhosyoukinoukbn";
    public static final String ZRNDAIKBN                = "zrndaikbn";
    public static final String ZRNTYUUKBN               = "zrntyuukbn";
    public static final String ZRNSYOUKBN               = "zrnsyoukbn";
    public static final String ZRNSEDAIKBN              = "zrnsedaikbn";
    public static final String ZRNHARAIKATAKBN          = "zrnharaikatakbn";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNSDPDKBN               = "zrnsdpdkbn";
    public static final String ZRNRYOURITUKBN           = "zrnryouritukbn";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHIHOKENSYAAGEV2       = "zrnhihokensyaagev2";
    public static final String ZRNHHKNNENTYSIHYJ        = "zrnhhknnentysihyj";
    public static final String ZRNSYUKEIYAKUPWARIBIKIKBN = "zrnsyukeiyakupwaribikikbn";
    public static final String ZRNKURIAGEKURISAGEKBN    = "zrnkuriagekurisagekbn";
    public static final String ZRNSUURIYOUYOBIN11       = "zrnsuuriyouyobin11";
    public static final String ZRNYOBIV10               = "zrnyobiv10";
    public static final String ZRNALMYOUSOHUTOMEISYOUKBN = "zrnalmyousohutomeisyoukbn";
    public static final String ZRNSNKYKSOFTMEISYOUKBN   = "zrnsnkyksoftmeisyoukbn";
    public static final String ZRNSOFTMEISYOUKBN        = "zrnsoftmeisyoukbn";
    public static final String ZRNNENKINKAISINENDO      = "zrnnenkinkaisinendo";
    public static final String ZRNNENKINGATAKBN         = "zrnnenkingatakbn";
    public static final String ZRNNKNSHRY               = "zrnnknshry";
    public static final String ZRNBOSYUUKEITAIKBN       = "zrnbosyuukeitaikbn";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNSUURIYOUYOBIN8X2      = "zrnsuuriyouyobin8x2";
    public static final String ZRNYOBIV6                = "zrnyobiv6";
    public static final String ZRNSYUKEIYAKUP           = "zrnsyukeiyakup";
    public static final String ZRNKIHONS                = "zrnkihons";
    public static final String ZRNPJUUTOUJIKAWASERATE   = "zrnpjuutoujikawaserate";
    public static final String ZRNPJUUTOUJIKAWASEKIJYUNYMD = "zrnpjuutoujikawasekijyunymd";
    public static final String ZRNGESSITUMITATEKIN      = "zrngessitumitatekin";
    public static final String ZRNYOTEIRIRITUN5         = "zrnyoteiriritun5";
    public static final String ZRNTUMITATERIRITU        = "zrntumitateriritu";
    public static final String ZRNGAIKADATETOUGETUJUUTOUP = "zrngaikadatetougetujuutoup";
    public static final String ZRNKIHARAIKOMIP          = "zrnkiharaikomip";
    public static final String ZRNKEISANHANTEIYOUTMTTKN = "zrnkeisanhanteiyoutmttkn";
    public static final String ZRNZETTAISIBOURITU       = "zrnzettaisibouritu";
    public static final String ZRNSOUTAISIBOURITU       = "zrnsoutaisibouritu";
    public static final String ZRNSOUTAIKAIYAKURITU     = "zrnsoutaikaiyakuritu";
    public static final String ZRNVHIREILRITU           = "zrnvhireilritu";
    public static final String ZRNYOBIN13               = "zrnyobin13";
    public static final String ZRNPHIREILWRBKRITU       = "zrnphireilwrbkritu";
    public static final String ZRNGETUMATUTUMITATEKIN   = "zrngetumatutumitatekin";
    public static final String ZRNZENNOUJIIKKATUBARAIJYTGK = "zrnzennoujiikkatubaraijytgk";
    public static final String ZRNGAIKADATENKGNS        = "zrngaikadatenkgns";
    public static final String ZRNPHIREIALPHA           = "zrnphireialpha";
    public static final String ZRNPHIREIBETA            = "zrnphireibeta";
    public static final String ZRNPHIREIGANMA           = "zrnphireiganma";
    public static final String ZRNKYKJIKAWASERATE       = "zrnkykjikawaserate";
    public static final String ZRNKYKJIKAWASERATETKYUYMD = "zrnkykjikawaseratetkyuymd";
    public static final String ZRNYOBIV11               = "zrnyobiv11";

    private final PKZT_RrtHndugtHknKsnJigyohiRn primaryKey;

    public GenZT_RrtHndugtHknKsnJigyohiRn() {
        primaryKey = new PKZT_RrtHndugtHknKsnJigyohiRn();
    }

    public GenZT_RrtHndugtHknKsnJigyohiRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_RrtHndugtHknKsnJigyohiRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_RrtHndugtHknKsnJigyohiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_RrtHndugtHknKsnJigyohiRn> getMetaClass() {
        return QZT_RrtHndugtHknKsnJigyohiRn.class;
    }

    @Id
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private Integer zrnyuukourecordlength;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNYUUKOURECORDLENGTH)
    public Integer getZrnyuukourecordlength() {
        return zrnyuukourecordlength;
    }

    public void setZrnyuukourecordlength(Integer pZrnyuukourecordlength) {
        zrnyuukourecordlength = pZrnyuukourecordlength;
    }

    private String zrnrdwarea;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNRDWAREA)
    public String getZrnrdwarea() {
        return zrnrdwarea;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnrdwarea(String pZrnrdwarea) {
        zrnrdwarea = pZrnrdwarea;
    }

    private String zrnkeijyouym;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNKEIJYOUYM)
    public String getZrnkeijyouym() {
        return zrnkeijyouym;
    }

    public void setZrnkeijyouym(String pZrnkeijyouym) {
        zrnkeijyouym = pZrnkeijyouym;
    }

    private String zrnsuuriyoupjytouym;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSUURIYOUPJYTOUYM)
    public String getZrnsuuriyoupjytouym() {
        return zrnsuuriyoupjytouym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsuuriyoupjytouym(String pZrnsuuriyoupjytouym) {
        zrnsuuriyoupjytouym = pZrnsuuriyoupjytouym;
    }

    private String zrnsihankibikinkbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSIHANKIBIKINKBN)
    public String getZrnsihankibikinkbn() {
        return zrnsihankibikinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsihankibikinkbn(String pZrnsihankibikinkbn) {
        zrnsihankibikinkbn = pZrnsihankibikinkbn;
    }

    private String zrnhenkousyoriymd;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNHENKOUSYORIYMD)
    public String getZrnhenkousyoriymd() {
        return zrnhenkousyoriymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhenkousyoriymd(String pZrnhenkousyoriymd) {
        zrnhenkousyoriymd = pZrnhenkousyoriymd;
    }

    private String zrndenymd;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNDENYMD)
    public String getZrndenymd() {
        return zrndenymd;
    }

    public void setZrndenymd(String pZrndenymd) {
        zrndenymd = pZrndenymd;
    }

    private String zrnsyoricd;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSYORICD)
    public String getZrnsyoricd() {
        return zrnsyoricd;
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        zrnsyoricd = pZrnsyoricd;
    }

    private String zrnkykymdmaekykhyj;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNKYKYMDMAEKYKHYJ)
    public String getZrnkykymdmaekykhyj() {
        return zrnkykymdmaekykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkykymdmaekykhyj(String pZrnkykymdmaekykhyj) {
        zrnkykymdmaekykhyj = pZrnkykymdmaekykhyj;
    }

    private String zrnkarikasikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNKARIKASIKBN)
    public String getZrnkarikasikbn() {
        return zrnkarikasikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkarikasikbn(String pZrnkarikasikbn) {
        zrnkarikasikbn = pZrnkarikasikbn;
    }

    private String zrnsuuriyouyobin8;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSUURIYOUYOBIN8)
    public String getZrnsuuriyouyobin8() {
        return zrnsuuriyouyobin8;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8(String pZrnsuuriyouyobin8) {
        zrnsuuriyouyobin8 = pZrnsuuriyouyobin8;
    }

    private String zrnyobiv7;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNYOBIV7)
    public String getZrnyobiv7() {
        return zrnyobiv7;
    }

    public void setZrnyobiv7(String pZrnyobiv7) {
        zrnyobiv7 = pZrnyobiv7;
    }

    private String zrndatakanrino;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnsotodasipmenkbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSOTODASIPMENKBN)
    public String getZrnsotodasipmenkbn() {
        return zrnsotodasipmenkbn;
    }

    public void setZrnsotodasipmenkbn(String pZrnsotodasipmenkbn) {
        zrnsotodasipmenkbn = pZrnsotodasipmenkbn;
    }

    private String zrnstdssytikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSTDSSYTIKBN)
    public String getZrnstdssytikbn() {
        return zrnstdssytikbn;
    }

    public void setZrnstdssytikbn(String pZrnstdssytikbn) {
        zrnstdssytikbn = pZrnstdssytikbn;
    }

    private String zrnstdssnskbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSTDSSNSKBN)
    public String getZrnstdssnskbn() {
        return zrnstdssnskbn;
    }

    public void setZrnstdssnskbn(String pZrnstdssnskbn) {
        zrnstdssnskbn = pZrnstdssnskbn;
    }

    private String zrnsotodasimanagehyouji;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSOTODASIMANAGEHYOUJI)
    public String getZrnsotodasimanagehyouji() {
        return zrnsotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsotodasimanagehyouji(String pZrnsotodasimanagehyouji) {
        zrnsotodasimanagehyouji = pZrnsotodasimanagehyouji;
    }

    private String zrnsotodasiphkbnmnoshyouji;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSOTODASIPHKBNMNOSHYOUJI)
    public String getZrnsotodasiphkbnmnoshyouji() {
        return zrnsotodasiphkbnmnoshyouji;
    }

    public void setZrnsotodasiphkbnmnoshyouji(String pZrnsotodasiphkbnmnoshyouji) {
        zrnsotodasiphkbnmnoshyouji = pZrnsotodasiphkbnmnoshyouji;
    }

    private String zrnstdsstkjytkyuhyj;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSTDSSTKJYTKYUHYJ)
    public String getZrnstdsstkjytkyuhyj() {
        return zrnstdsstkjytkyuhyj;
    }

    public void setZrnstdsstkjytkyuhyj(String pZrnstdsstkjytkyuhyj) {
        zrnstdsstkjytkyuhyj = pZrnstdsstkjytkyuhyj;
    }

    private String zrnkyksyoumetuzumihyouji;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNKYKSYOUMETUZUMIHYOUJI)
    public String getZrnkyksyoumetuzumihyouji() {
        return zrnkyksyoumetuzumihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkyksyoumetuzumihyouji(String pZrnkyksyoumetuzumihyouji) {
        zrnkyksyoumetuzumihyouji = pZrnkyksyoumetuzumihyouji;
    }

    private String zrnsrdai1hknkkn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSRDAI1HKNKKN)
    public String getZrnsrdai1hknkkn() {
        return zrnsrdai1hknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsrdai1hknkkn(String pZrnsrdai1hknkkn) {
        zrnsrdai1hknkkn = pZrnsrdai1hknkkn;
    }

    private String zrnsuuriyouyobin2;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSUURIYOUYOBIN2)
    public String getZrnsuuriyouyobin2() {
        return zrnsuuriyouyobin2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuuriyouyobin2(String pZrnsuuriyouyobin2) {
        zrnsuuriyouyobin2 = pZrnsuuriyouyobin2;
    }

    private String zrntuukasyukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNTUUKASYUKBN)
    public String getZrntuukasyukbn() {
        return zrntuukasyukbn;
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        zrntuukasyukbn = pZrntuukasyukbn;
    }

    private String zrnyobiv3;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNYOBIV3)
    public String getZrnyobiv3() {
        return zrnyobiv3;
    }

    public void setZrnyobiv3(String pZrnyobiv3) {
        zrnyobiv3 = pZrnyobiv3;
    }

    private String zrnkbnkeiriyousegmentkbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNKBNKEIRIYOUSEGMENTKBN)
    public String getZrnkbnkeiriyousegmentkbn() {
        return zrnkbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyousegmentkbn(String pZrnkbnkeiriyousegmentkbn) {
        zrnkbnkeiriyousegmentkbn = pZrnkbnkeiriyousegmentkbn;
    }

    private String zrnkbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNKBNKEIRIYOURGNBNSKKBN)
    public String getZrnkbnkeiriyourgnbnskkbn() {
        return zrnkbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyourgnbnskkbn(String pZrnkbnkeiriyourgnbnskkbn) {
        zrnkbnkeiriyourgnbnskkbn = pZrnkbnkeiriyourgnbnskkbn;
    }

    private String zrnsuurisyuruicd;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSUURISYURUICD)
    public String getZrnsuurisyuruicd() {
        return zrnsuurisyuruicd;
    }

    public void setZrnsuurisyuruicd(String pZrnsuurisyuruicd) {
        zrnsuurisyuruicd = pZrnsuurisyuruicd;
    }

    private String zrnhosyoukinoukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNHOSYOUKINOUKBN)
    public String getZrnhosyoukinoukbn() {
        return zrnhosyoukinoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhosyoukinoukbn(String pZrnhosyoukinoukbn) {
        zrnhosyoukinoukbn = pZrnhosyoukinoukbn;
    }

    private String zrndaikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNDAIKBN)
    public String getZrndaikbn() {
        return zrndaikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndaikbn(String pZrndaikbn) {
        zrndaikbn = pZrndaikbn;
    }

    private String zrntyuukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNTYUUKBN)
    public String getZrntyuukbn() {
        return zrntyuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrntyuukbn(String pZrntyuukbn) {
        zrntyuukbn = pZrntyuukbn;
    }

    private String zrnsyoukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSYOUKBN)
    public String getZrnsyoukbn() {
        return zrnsyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnsyoukbn(String pZrnsyoukbn) {
        zrnsyoukbn = pZrnsyoukbn;
    }

    private String zrnsedaikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSEDAIKBN)
    public String getZrnsedaikbn() {
        return zrnsedaikbn;
    }

    public void setZrnsedaikbn(String pZrnsedaikbn) {
        zrnsedaikbn = pZrnsedaikbn;
    }

    private String zrnharaikatakbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNHARAIKATAKBN)
    public String getZrnharaikatakbn() {
        return zrnharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnharaikatakbn(String pZrnharaikatakbn) {
        zrnharaikatakbn = pZrnharaikatakbn;
    }

    private String zrnkykymd;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnsdpdkbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSDPDKBN)
    public String getZrnsdpdkbn() {
        return zrnsdpdkbn;
    }

    public void setZrnsdpdkbn(String pZrnsdpdkbn) {
        zrnsdpdkbn = pZrnsdpdkbn;
    }

    private String zrnryouritukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNRYOURITUKBN)
    public String getZrnryouritukbn() {
        return zrnryouritukbn;
    }

    public void setZrnryouritukbn(String pZrnryouritukbn) {
        zrnryouritukbn = pZrnryouritukbn;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhihokensyaagev2;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNHIHOKENSYAAGEV2)
    public String getZrnhihokensyaagev2() {
        return zrnhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyaagev2(String pZrnhihokensyaagev2) {
        zrnhihokensyaagev2 = pZrnhihokensyaagev2;
    }

    private String zrnhhknnentysihyj;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNHHKNNENTYSIHYJ)
    public String getZrnhhknnentysihyj() {
        return zrnhhknnentysihyj;
    }

    public void setZrnhhknnentysihyj(String pZrnhhknnentysihyj) {
        zrnhhknnentysihyj = pZrnhhknnentysihyj;
    }

    private String zrnsyukeiyakupwaribikikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSYUKEIYAKUPWARIBIKIKBN)
    public String getZrnsyukeiyakupwaribikikbn() {
        return zrnsyukeiyakupwaribikikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyukeiyakupwaribikikbn(String pZrnsyukeiyakupwaribikikbn) {
        zrnsyukeiyakupwaribikikbn = pZrnsyukeiyakupwaribikikbn;
    }

    private String zrnkuriagekurisagekbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNKURIAGEKURISAGEKBN)
    public String getZrnkuriagekurisagekbn() {
        return zrnkuriagekurisagekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkuriagekurisagekbn(String pZrnkuriagekurisagekbn) {
        zrnkuriagekurisagekbn = pZrnkuriagekurisagekbn;
    }

    private String zrnsuuriyouyobin11;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSUURIYOUYOBIN11)
    public String getZrnsuuriyouyobin11() {
        return zrnsuuriyouyobin11;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnsuuriyouyobin11(String pZrnsuuriyouyobin11) {
        zrnsuuriyouyobin11 = pZrnsuuriyouyobin11;
    }

    private String zrnyobiv10;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNYOBIV10)
    public String getZrnyobiv10() {
        return zrnyobiv10;
    }

    public void setZrnyobiv10(String pZrnyobiv10) {
        zrnyobiv10 = pZrnyobiv10;
    }

    private String zrnalmyousohutomeisyoukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNALMYOUSOHUTOMEISYOUKBN)
    public String getZrnalmyousohutomeisyoukbn() {
        return zrnalmyousohutomeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnalmyousohutomeisyoukbn(String pZrnalmyousohutomeisyoukbn) {
        zrnalmyousohutomeisyoukbn = pZrnalmyousohutomeisyoukbn;
    }

    private String zrnsnkyksoftmeisyoukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSNKYKSOFTMEISYOUKBN)
    public String getZrnsnkyksoftmeisyoukbn() {
        return zrnsnkyksoftmeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsnkyksoftmeisyoukbn(String pZrnsnkyksoftmeisyoukbn) {
        zrnsnkyksoftmeisyoukbn = pZrnsnkyksoftmeisyoukbn;
    }

    private String zrnsoftmeisyoukbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSOFTMEISYOUKBN)
    public String getZrnsoftmeisyoukbn() {
        return zrnsoftmeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsoftmeisyoukbn(String pZrnsoftmeisyoukbn) {
        zrnsoftmeisyoukbn = pZrnsoftmeisyoukbn;
    }

    private String zrnnenkinkaisinendo;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNNENKINKAISINENDO)
    public String getZrnnenkinkaisinendo() {
        return zrnnenkinkaisinendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnnenkinkaisinendo(String pZrnnenkinkaisinendo) {
        zrnnenkinkaisinendo = pZrnnenkinkaisinendo;
    }

    private String zrnnenkingatakbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNNENKINGATAKBN)
    public String getZrnnenkingatakbn() {
        return zrnnenkingatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnenkingatakbn(String pZrnnenkingatakbn) {
        zrnnenkingatakbn = pZrnnenkingatakbn;
    }

    private String zrnnknshry;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNNKNSHRY)
    public String getZrnnknshry() {
        return zrnnknshry;
    }

    public void setZrnnknshry(String pZrnnknshry) {
        zrnnknshry = pZrnnknshry;
    }

    private String zrnbosyuukeitaikbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNBOSYUUKEITAIKBN)
    public String getZrnbosyuukeitaikbn() {
        return zrnbosyuukeitaikbn;
    }

    public void setZrnbosyuukeitaikbn(String pZrnbosyuukeitaikbn) {
        zrnbosyuukeitaikbn = pZrnbosyuukeitaikbn;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private String zrnsuuriyouyobin8x2;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSUURIYOUYOBIN8X2)
    public String getZrnsuuriyouyobin8x2() {
        return zrnsuuriyouyobin8x2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8x2(String pZrnsuuriyouyobin8x2) {
        zrnsuuriyouyobin8x2 = pZrnsuuriyouyobin8x2;
    }

    private String zrnyobiv6;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNYOBIV6)
    public String getZrnyobiv6() {
        return zrnyobiv6;
    }

    public void setZrnyobiv6(String pZrnyobiv6) {
        zrnyobiv6 = pZrnyobiv6;
    }

    private Long zrnsyukeiyakup;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSYUKEIYAKUP)
    public Long getZrnsyukeiyakup() {
        return zrnsyukeiyakup;
    }

    public void setZrnsyukeiyakup(Long pZrnsyukeiyakup) {
        zrnsyukeiyakup = pZrnsyukeiyakup;
    }

    private Long zrnkihons;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNKIHONS)
    public Long getZrnkihons() {
        return zrnkihons;
    }

    public void setZrnkihons(Long pZrnkihons) {
        zrnkihons = pZrnkihons;
    }

    private BizNumber zrnpjuutoujikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNPJUUTOUJIKAWASERATE)
    public BizNumber getZrnpjuutoujikawaserate() {
        return zrnpjuutoujikawaserate;
    }

    public void setZrnpjuutoujikawaserate(BizNumber pZrnpjuutoujikawaserate) {
        zrnpjuutoujikawaserate = pZrnpjuutoujikawaserate;
    }

    private String zrnpjuutoujikawasekijyunymd;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNPJUUTOUJIKAWASEKIJYUNYMD)
    public String getZrnpjuutoujikawasekijyunymd() {
        return zrnpjuutoujikawasekijyunymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnpjuutoujikawasekijyunymd(String pZrnpjuutoujikawasekijyunymd) {
        zrnpjuutoujikawasekijyunymd = pZrnpjuutoujikawasekijyunymd;
    }

    private Long zrngessitumitatekin;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNGESSITUMITATEKIN)
    public Long getZrngessitumitatekin() {
        return zrngessitumitatekin;
    }

    public void setZrngessitumitatekin(Long pZrngessitumitatekin) {
        zrngessitumitatekin = pZrngessitumitatekin;
    }

    private BizNumber zrnyoteiriritun5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNYOTEIRIRITUN5)
    public BizNumber getZrnyoteiriritun5() {
        return zrnyoteiriritun5;
    }

    public void setZrnyoteiriritun5(BizNumber pZrnyoteiriritun5) {
        zrnyoteiriritun5 = pZrnyoteiriritun5;
    }

    private BizNumber zrntumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNTUMITATERIRITU)
    public BizNumber getZrntumitateriritu() {
        return zrntumitateriritu;
    }

    public void setZrntumitateriritu(BizNumber pZrntumitateriritu) {
        zrntumitateriritu = pZrntumitateriritu;
    }

    private Long zrngaikadatetougetujuutoup;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNGAIKADATETOUGETUJUUTOUP)
    public Long getZrngaikadatetougetujuutoup() {
        return zrngaikadatetougetujuutoup;
    }

    public void setZrngaikadatetougetujuutoup(Long pZrngaikadatetougetujuutoup) {
        zrngaikadatetougetujuutoup = pZrngaikadatetougetujuutoup;
    }

    private Long zrnkiharaikomip;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNKIHARAIKOMIP)
    public Long getZrnkiharaikomip() {
        return zrnkiharaikomip;
    }

    public void setZrnkiharaikomip(Long pZrnkiharaikomip) {
        zrnkiharaikomip = pZrnkiharaikomip;
    }

    private Long zrnkeisanhanteiyoutmttkn;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNKEISANHANTEIYOUTMTTKN)
    public Long getZrnkeisanhanteiyoutmttkn() {
        return zrnkeisanhanteiyoutmttkn;
    }

    public void setZrnkeisanhanteiyoutmttkn(Long pZrnkeisanhanteiyoutmttkn) {
        zrnkeisanhanteiyoutmttkn = pZrnkeisanhanteiyoutmttkn;
    }

    private BizNumber zrnzettaisibouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNZETTAISIBOURITU)
    public BizNumber getZrnzettaisibouritu() {
        return zrnzettaisibouritu;
    }

    public void setZrnzettaisibouritu(BizNumber pZrnzettaisibouritu) {
        zrnzettaisibouritu = pZrnzettaisibouritu;
    }

    private BizNumber zrnsoutaisibouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSOUTAISIBOURITU)
    public BizNumber getZrnsoutaisibouritu() {
        return zrnsoutaisibouritu;
    }

    public void setZrnsoutaisibouritu(BizNumber pZrnsoutaisibouritu) {
        zrnsoutaisibouritu = pZrnsoutaisibouritu;
    }

    private BizNumber zrnsoutaikaiyakuritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNSOUTAIKAIYAKURITU)
    public BizNumber getZrnsoutaikaiyakuritu() {
        return zrnsoutaikaiyakuritu;
    }

    public void setZrnsoutaikaiyakuritu(BizNumber pZrnsoutaikaiyakuritu) {
        zrnsoutaikaiyakuritu = pZrnsoutaikaiyakuritu;
    }

    private BizNumber zrnvhireilritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNVHIREILRITU)
    public BizNumber getZrnvhireilritu() {
        return zrnvhireilritu;
    }

    public void setZrnvhireilritu(BizNumber pZrnvhireilritu) {
        zrnvhireilritu = pZrnvhireilritu;
    }

    private Long zrnyobin13;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNYOBIN13)
    public Long getZrnyobin13() {
        return zrnyobin13;
    }

    public void setZrnyobin13(Long pZrnyobin13) {
        zrnyobin13 = pZrnyobin13;
    }

    private BizNumber zrnphireilwrbkritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNPHIREILWRBKRITU)
    public BizNumber getZrnphireilwrbkritu() {
        return zrnphireilwrbkritu;
    }

    public void setZrnphireilwrbkritu(BizNumber pZrnphireilwrbkritu) {
        zrnphireilwrbkritu = pZrnphireilwrbkritu;
    }

    private Long zrngetumatutumitatekin;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNGETUMATUTUMITATEKIN)
    public Long getZrngetumatutumitatekin() {
        return zrngetumatutumitatekin;
    }

    public void setZrngetumatutumitatekin(Long pZrngetumatutumitatekin) {
        zrngetumatutumitatekin = pZrngetumatutumitatekin;
    }

    private Long zrnzennoujiikkatubaraijytgk;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNZENNOUJIIKKATUBARAIJYTGK)
    public Long getZrnzennoujiikkatubaraijytgk() {
        return zrnzennoujiikkatubaraijytgk;
    }

    public void setZrnzennoujiikkatubaraijytgk(Long pZrnzennoujiikkatubaraijytgk) {
        zrnzennoujiikkatubaraijytgk = pZrnzennoujiikkatubaraijytgk;
    }

    private Long zrngaikadatenkgns;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNGAIKADATENKGNS)
    public Long getZrngaikadatenkgns() {
        return zrngaikadatenkgns;
    }

    public void setZrngaikadatenkgns(Long pZrngaikadatenkgns) {
        zrngaikadatenkgns = pZrngaikadatenkgns;
    }

    private BizNumber zrnphireialpha;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNPHIREIALPHA)
    public BizNumber getZrnphireialpha() {
        return zrnphireialpha;
    }

    public void setZrnphireialpha(BizNumber pZrnphireialpha) {
        zrnphireialpha = pZrnphireialpha;
    }

    private BizNumber zrnphireibeta;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNPHIREIBETA)
    public BizNumber getZrnphireibeta() {
        return zrnphireibeta;
    }

    public void setZrnphireibeta(BizNumber pZrnphireibeta) {
        zrnphireibeta = pZrnphireibeta;
    }

    private BizNumber zrnphireiganma;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNPHIREIGANMA)
    public BizNumber getZrnphireiganma() {
        return zrnphireiganma;
    }

    public void setZrnphireiganma(BizNumber pZrnphireiganma) {
        zrnphireiganma = pZrnphireiganma;
    }

    private BizNumber zrnkykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNKYKJIKAWASERATE)
    public BizNumber getZrnkykjikawaserate() {
        return zrnkykjikawaserate;
    }

    public void setZrnkykjikawaserate(BizNumber pZrnkykjikawaserate) {
        zrnkykjikawaserate = pZrnkykjikawaserate;
    }

    private String zrnkykjikawaseratetkyuymd;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNKYKJIKAWASERATETKYUYMD)
    public String getZrnkykjikawaseratetkyuymd() {
        return zrnkykjikawaseratetkyuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkykjikawaseratetkyuymd(String pZrnkykjikawaseratetkyuymd) {
        zrnkykjikawaseratetkyuymd = pZrnkykjikawaseratetkyuymd;
    }

    private String zrnyobiv11;

    @Column(name=GenZT_RrtHndugtHknKsnJigyohiRn.ZRNYOBIV11)
    public String getZrnyobiv11() {
        return zrnyobiv11;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnyobiv11(String pZrnyobiv11) {
        zrnyobiv11 = pZrnyobiv11;
    }
}