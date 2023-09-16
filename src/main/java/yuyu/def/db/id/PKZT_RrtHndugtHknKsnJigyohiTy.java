package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_RrtHndugtHknKsnJigyohiTy;
import yuyu.def.db.mapping.GenZT_RrtHndugtHknKsnJigyohiTy;
import yuyu.def.db.meta.GenQZT_RrtHndugtHknKsnJigyohiTy;
import yuyu.def.db.meta.QZT_RrtHndugtHknKsnJigyohiTy;

/**
 * 利率変動型保険決算用事業費Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RrtHndugtHknKsnJigyohiTy}</td><td colspan="3">利率変動型保険決算用事業費Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyuukourecordlength</td><td>（中継用）有効レコード長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyrdwarea</td><td>（中継用）ＲＤＷ領域</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeijyouym</td><td>（中継用）計上年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyoupjytouym</td><td>（中継用）数理用Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysihankibikinkbn</td><td>（中継用）四半期備金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhenkousyoriymd</td><td>（中継用）変更処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydenymd</td><td>（中継用）伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoricd</td><td>（中継用）処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymdmaekykhyj</td><td>（中継用）契約日前契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykarikasikbn</td><td>（中継用）借方貸方区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin8</td><td>（中継用）数理用予備項目Ｎ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv7</td><td>（中継用）予備項目Ｖ７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatakanrino</td><td>（中継用）データ管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyraysystemhyj</td><td>（中継用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruikigousedaikbn</td><td>（中継用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasipmenkbn</td><td>（中継用）外出Ｐ免区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdssytikbn</td><td>（中継用）外出集定区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdssnskbn</td><td>（中継用）外出診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasimanagehyouji</td><td>（中継用）外出満年令表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasiphkbnmnoshyouji</td><td>（中継用）外出Ｐ不可分見直表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdsstkjytkyuhyj</td><td>（中継用）外出新特条適用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyoumetuzumihyouji</td><td>（中継用）契約消滅済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysrdai1hknkkn</td><td>（中継用）数理用第１保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin2</td><td>（中継用）数理用予備項目Ｎ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuukasyukbn</td><td>（中継用）通貨種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv3</td><td>（中継用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyousegmentkbn</td><td>（中継用）区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyourgnbnskkbn</td><td>（中継用）区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuurisyuruicd</td><td>（中継用）数理種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyoukinoukbn</td><td>（中継用）保障機能区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydaikbn</td><td>（中継用）大区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyuukbn</td><td>（中継用）中区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoukbn</td><td>（中継用）小区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysedaikbn</td><td>（中継用）世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyharaikatakbn</td><td>（中継用）払方区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkikn</td><td>（中継用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaimnkkykhyj</td><td>（中継用）才満期契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysdpdkbn</td><td>（中継用）Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyryouritukbn</td><td>（中継用）料率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhihokensyaagev2</td><td>（中継用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnentysihyj</td><td>（中継用）被保険者年令調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakupwaribikikbn</td><td>（中継用）主契約Ｐ割引区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykuriagekurisagekbn</td><td>（中継用）繰上げ繰下げ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin11</td><td>（中継用）数理用予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10</td><td>（中継用）予備項目Ｖ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyalmyousohutomeisyoukbn</td><td>（中継用）ＡＬＭ用ソフト名称区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysnkyksoftmeisyoukbn</td><td>（中継用）新契約ソフト名称区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysoftmeisyoukbn</td><td>（中継用）ソフト名称区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkaisinendo</td><td>（中継用）年金開始年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkingatakbn</td><td>（中継用）年金型区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynknshry</td><td>（中継用）年金支払期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuukeitaikbn</td><td>（中継用）募集形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygaikakbn</td><td>（中継用）外貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin8x2</td><td>（中継用）数理用予備項目Ｎ８＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv6</td><td>（中継用）予備項目Ｖ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakup</td><td>（中継用）主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykihons</td><td>（中継用）基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztypjuutoujikawaserate</td><td>（中継用）保険料充当時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztypjuutoujikawasekijyunymd</td><td>（中継用）保険料充当時為替基準年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygessitumitatekin</td><td>（中継用）月始積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyoteiriritun5</td><td>（中継用）予定利率Ｎ５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytumitateriritu</td><td>（中継用）積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztygaikadatetougetujuutoup</td><td>（中継用）外貨建当月充当Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykiharaikomip</td><td>（中継用）既払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykeisanhanteiyoutmttkn</td><td>（中継用）計算判定用積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzettaisibouritu</td><td>（中継用）絶対死亡率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysoutaisibouritu</td><td>（中継用）相対死亡率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysoutaikaiyakuritu</td><td>（中継用）相対解約率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyvhireilritu</td><td>（中継用）Ｖ比例Ｌ率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyobin13</td><td>（中継用）予備項目Ｎ１３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyphireilwrbkritu</td><td>（中継用）Ｐ比例Ｌ割引率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztygetumatutumitatekin</td><td>（中継用）月末積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzennoujiikkatubaraijytgk</td><td>（中継用）前納時一括払充当額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatenkgns</td><td>（中継用）外貨建年金原資</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyphireialpha</td><td>（中継用）Ｐ比例α</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyphireibeta</td><td>（中継用）Ｐ比例β</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyphireiganma</td><td>（中継用）Ｐ比例γ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykykjikawaserate</td><td>（中継用）契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykykjikawaseratetkyuymd</td><td>（中継用）契約時為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv11</td><td>（中継用）予備項目Ｖ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_RrtHndugtHknKsnJigyohiTy
 * @see     GenZT_RrtHndugtHknKsnJigyohiTy
 * @see     QZT_RrtHndugtHknKsnJigyohiTy
 * @see     GenQZT_RrtHndugtHknKsnJigyohiTy
 */
public class PKZT_RrtHndugtHknKsnJigyohiTy extends AbstractExDBPrimaryKey<ZT_RrtHndugtHknKsnJigyohiTy, PKZT_RrtHndugtHknKsnJigyohiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_RrtHndugtHknKsnJigyohiTy() {
    }

    public PKZT_RrtHndugtHknKsnJigyohiTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_RrtHndugtHknKsnJigyohiTy> getEntityClass() {
        return ZT_RrtHndugtHknKsnJigyohiTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}