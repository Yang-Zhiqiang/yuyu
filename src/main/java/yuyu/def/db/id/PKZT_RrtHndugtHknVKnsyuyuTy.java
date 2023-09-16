package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_RrtHndugtHknVKnsyuyuTy;
import yuyu.def.db.mapping.GenZT_RrtHndugtHknVKnsyuyuTy;
import yuyu.def.db.meta.GenQZT_RrtHndugtHknVKnsyuyuTy;
import yuyu.def.db.meta.QZT_RrtHndugtHknVKnsyuyuTy;

/**
 * 利率変動型保険Ｖ検証用Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RrtHndugtHknVKnsyuyuTy}</td><td colspan="3">利率変動型保険Ｖ検証用Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyuukourecordlength</td><td>（中継用）有効レコード長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyrdwarea</td><td>（中継用）ＲＤＷ領域</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeijyouym</td><td>（中継用）計上年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyraysystemhyj</td><td>（中継用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatakanrino</td><td>（中継用）データ管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruikigousedaikbn</td><td>（中継用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasipmenkbn</td><td>（中継用）外出Ｐ免区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasimanagehyouji</td><td>（中継用）外出満年令表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysrdai1hknkkn</td><td>（中継用）数理用第１保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin4</td><td>（中継用）数理用予備項目Ｎ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuukasyukbn</td><td>（中継用）通貨種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv11</td><td>（中継用）予備項目Ｖ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyousegmentkbn</td><td>（中継用）区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyourgnbnskkbn</td><td>（中継用）区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuurisyuruicd</td><td>（中継用）数理種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin6x2</td><td>（中継用）数理用予備項目Ｎ６＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8</td><td>（中継用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkikn</td><td>（中継用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaimnkkykhyj</td><td>（中継用）才満期契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhihokensyaagev2</td><td>（中継用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykuriagekurisagekbn</td><td>（中継用）繰上げ繰下げ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakupwaribikikbn</td><td>（中継用）主契約Ｐ割引区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjikaipjyuutouym2</td><td>（中継用）次回Ｐ充当年月２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokainyknjikawasekjnymd</td><td>（中継用）初回入金時為替基準年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin6x3</td><td>（中継用）数理用予備項目Ｎ６＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv7</td><td>（中継用）予備項目Ｖ７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygaikakbn</td><td>（中継用）外貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykimatukawaserate</td><td>（中継用）期末為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5</td><td>（中継用）予定利率Ｎ５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x2</td><td>（中継用）予定利率Ｎ５＿２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x3</td><td>（中継用）予定利率Ｎ５＿３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x4</td><td>（中継用）予定利率Ｎ５＿４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x5</td><td>（中継用）予定利率Ｎ５＿５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x6</td><td>（中継用）予定利率Ｎ５＿６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x7</td><td>（中継用）予定利率Ｎ５＿７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x8</td><td>（中継用）予定利率Ｎ５＿８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x9</td><td>（中継用）予定利率Ｎ５＿９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x10</td><td>（中継用）予定利率Ｎ５＿１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x11</td><td>（中継用）予定利率Ｎ５＿１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x12</td><td>（中継用）予定利率Ｎ５＿１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x13</td><td>（中継用）予定利率Ｎ５＿１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x14</td><td>（中継用）予定利率Ｎ５＿１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x15</td><td>（中継用）予定利率Ｎ５＿１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyoteiriritun5x16</td><td>（中継用）予定利率Ｎ５＿１６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyobiv6</td><td>（中継用）予備項目Ｖ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakup</td><td>（中継用）主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyuptumitatekin</td><td>（中継用）主契約保険料積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekin</td><td>（中継用）保険料積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx2</td><td>（中継用）保険料積立金＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx3</td><td>（中継用）保険料積立金＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx4</td><td>（中継用）保険料積立金＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx5</td><td>（中継用）保険料積立金＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx6</td><td>（中継用）保険料積立金＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx7</td><td>（中継用）保険料積立金＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx8</td><td>（中継用）保険料積立金＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx9</td><td>（中継用）保険料積立金＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx10</td><td>（中継用）保険料積立金＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx11</td><td>（中継用）保険料積立金＿１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx12</td><td>（中継用）保険料積立金＿１２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx13</td><td>（中継用）保険料積立金＿１３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx14</td><td>（中継用）保険料積立金＿１４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx15</td><td>（中継用）保険料積立金＿１５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyptumitatekinx16</td><td>（中継用）保険料積立金＿１６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoup</td><td>（中継用）外貨建充当Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx2</td><td>（中継用）外貨建充当Ｐ＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx3</td><td>（中継用）外貨建充当Ｐ＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx4</td><td>（中継用）外貨建充当Ｐ＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx5</td><td>（中継用）外貨建充当Ｐ＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx6</td><td>（中継用）外貨建充当Ｐ＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx7</td><td>（中継用）外貨建充当Ｐ＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx8</td><td>（中継用）外貨建充当Ｐ＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx9</td><td>（中継用）外貨建充当Ｐ＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx10</td><td>（中継用）外貨建充当Ｐ＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx11</td><td>（中継用）外貨建充当Ｐ＿１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx12</td><td>（中継用）外貨建充当Ｐ＿１２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx13</td><td>（中継用）外貨建充当Ｐ＿１３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx14</td><td>（中継用）外貨建充当Ｐ＿１４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx15</td><td>（中継用）外貨建充当Ｐ＿１５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatejyuutoupx16</td><td>（中継用）外貨建充当Ｐ＿１６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysykykkitmttvkeisanym1</td><td>（中継用）主契約既積立Ｖ計算年月１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykykkitmttv1</td><td>（中継用）主契約既積立Ｖ１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysykykkitmttvkeisanym2</td><td>（中継用）主契約既積立Ｖ計算年月２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykykkitmttv2</td><td>（中継用）主契約既積立Ｖ２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyrrthnduhknvkisovkisnyu1</td><td>（中継用）利率変動保険Ｖ基礎Ｖ計算用１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyrrthnduhknvkisovkisnyu2</td><td>（中継用）利率変動保険Ｖ基礎Ｖ計算用２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyrrthnduhknvkisovkisnyu3</td><td>（中継用）利率変動保険Ｖ基礎Ｖ計算用３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyrrthnduhknvkisovkisnyu4</td><td>（中継用）利率変動保険Ｖ基礎Ｖ計算用４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyrrthnduhknvkiso</td><td>（中継用）利率変動保険Ｖ基礎Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysuuriyouyobin9</td><td>（中継用）数理用予備項目Ｎ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv14</td><td>（中継用）予備項目Ｖ１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_RrtHndugtHknVKnsyuyuTy
 * @see     GenZT_RrtHndugtHknVKnsyuyuTy
 * @see     QZT_RrtHndugtHknVKnsyuyuTy
 * @see     GenQZT_RrtHndugtHknVKnsyuyuTy
 */
public class PKZT_RrtHndugtHknVKnsyuyuTy extends AbstractExDBPrimaryKey<ZT_RrtHndugtHknVKnsyuyuTy, PKZT_RrtHndugtHknVKnsyuyuTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_RrtHndugtHknVKnsyuyuTy() {
    }

    public PKZT_RrtHndugtHknVKnsyuyuTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_RrtHndugtHknVKnsyuyuTy> getEntityClass() {
        return ZT_RrtHndugtHknVKnsyuyuTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}