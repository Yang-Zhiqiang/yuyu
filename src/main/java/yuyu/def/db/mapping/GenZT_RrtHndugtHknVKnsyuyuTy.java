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
import yuyu.def.db.entity.ZT_RrtHndugtHknVKnsyuyuTy;
import yuyu.def.db.id.PKZT_RrtHndugtHknVKnsyuyuTy;
import yuyu.def.db.meta.GenQZT_RrtHndugtHknVKnsyuyuTy;
import yuyu.def.db.meta.QZT_RrtHndugtHknVKnsyuyuTy;

/**
 * 利率変動型保険Ｖ検証用Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_RrtHndugtHknVKnsyuyuTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RrtHndugtHknVKnsyuyuTy}</td><td colspan="3">利率変動型保険Ｖ検証用Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_RrtHndugtHknVKnsyuyuTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyuukourecordlength ztyyuukourecordlength}</td><td>（中継用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrdwarea ztyrdwarea}</td><td>（中継用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeijyouym ztykeijyouym}</td><td>（中継用）計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasipmenkbn ztysotodasipmenkbn}</td><td>（中継用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasimanagehyouji ztysotodasimanagehyouji}</td><td>（中継用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrdai1hknkkn ztysrdai1hknkkn}</td><td>（中継用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin4 ztysuuriyouyobin4}</td><td>（中継用）数理用予備項目Ｎ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuukasyukbn ztytuukasyukbn}</td><td>（中継用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv11 ztyyobiv11}</td><td>（中継用）予備項目Ｖ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentkbn ztykbnkeiriyousegmentkbn}</td><td>（中継用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyourgnbnskkbn ztykbnkeiriyourgnbnskkbn}</td><td>（中継用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuurisyuruicd ztysuurisyuruicd}</td><td>（中継用）数理種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin6x2 ztysuuriyouyobin6x2}</td><td>（中継用）数理用予備項目Ｎ６＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8 ztyyobiv8}</td><td>（中継用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyaagev2 ztyhihokensyaagev2}</td><td>（中継用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykuriagekurisagekbn ztykuriagekurisagekbn}</td><td>（中継用）繰上げ繰下げ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakupwaribikikbn ztysyukeiyakupwaribikikbn}</td><td>（中継用）主契約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikaipjyuutouym2 ztyjikaipjyuutouym2}</td><td>（中継用）次回Ｐ充当年月２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokainyknjikawasekjnymd ztysyokainyknjikawasekjnymd}</td><td>（中継用）初回入金時為替基準年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin6x3 ztysuuriyouyobin6x3}</td><td>（中継用）数理用予備項目Ｎ６＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7 ztyyobiv7}</td><td>（中継用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykimatukawaserate ztykimatukawaserate}</td><td>（中継用）期末為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5 ztyyoteiriritun5}</td><td>（中継用）予定利率Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x2 ztyyoteiriritun5x2}</td><td>（中継用）予定利率Ｎ５＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x3 ztyyoteiriritun5x3}</td><td>（中継用）予定利率Ｎ５＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x4 ztyyoteiriritun5x4}</td><td>（中継用）予定利率Ｎ５＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x5 ztyyoteiriritun5x5}</td><td>（中継用）予定利率Ｎ５＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x6 ztyyoteiriritun5x6}</td><td>（中継用）予定利率Ｎ５＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x7 ztyyoteiriritun5x7}</td><td>（中継用）予定利率Ｎ５＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x8 ztyyoteiriritun5x8}</td><td>（中継用）予定利率Ｎ５＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x9 ztyyoteiriritun5x9}</td><td>（中継用）予定利率Ｎ５＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x10 ztyyoteiriritun5x10}</td><td>（中継用）予定利率Ｎ５＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x11 ztyyoteiriritun5x11}</td><td>（中継用）予定利率Ｎ５＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x12 ztyyoteiriritun5x12}</td><td>（中継用）予定利率Ｎ５＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x13 ztyyoteiriritun5x13}</td><td>（中継用）予定利率Ｎ５＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x14 ztyyoteiriritun5x14}</td><td>（中継用）予定利率Ｎ５＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x15 ztyyoteiriritun5x15}</td><td>（中継用）予定利率Ｎ５＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5x16 ztyyoteiriritun5x16}</td><td>（中継用）予定利率Ｎ５＿１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyobiv6 ztyyobiv6}</td><td>（中継用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakup ztysyukeiyakup}</td><td>（中継用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyuptumitatekin ztysyuptumitatekin}</td><td>（中継用）主契約保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekin ztyptumitatekin}</td><td>（中継用）保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx2 ztyptumitatekinx2}</td><td>（中継用）保険料積立金＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx3 ztyptumitatekinx3}</td><td>（中継用）保険料積立金＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx4 ztyptumitatekinx4}</td><td>（中継用）保険料積立金＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx5 ztyptumitatekinx5}</td><td>（中継用）保険料積立金＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx6 ztyptumitatekinx6}</td><td>（中継用）保険料積立金＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx7 ztyptumitatekinx7}</td><td>（中継用）保険料積立金＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx8 ztyptumitatekinx8}</td><td>（中継用）保険料積立金＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx9 ztyptumitatekinx9}</td><td>（中継用）保険料積立金＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx10 ztyptumitatekinx10}</td><td>（中継用）保険料積立金＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx11 ztyptumitatekinx11}</td><td>（中継用）保険料積立金＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx12 ztyptumitatekinx12}</td><td>（中継用）保険料積立金＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx13 ztyptumitatekinx13}</td><td>（中継用）保険料積立金＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx14 ztyptumitatekinx14}</td><td>（中継用）保険料積立金＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx15 ztyptumitatekinx15}</td><td>（中継用）保険料積立金＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyptumitatekinx16 ztyptumitatekinx16}</td><td>（中継用）保険料積立金＿１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoup ztygaikadatejyuutoup}</td><td>（中継用）外貨建充当Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx2 ztygaikadatejyuutoupx2}</td><td>（中継用）外貨建充当Ｐ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx3 ztygaikadatejyuutoupx3}</td><td>（中継用）外貨建充当Ｐ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx4 ztygaikadatejyuutoupx4}</td><td>（中継用）外貨建充当Ｐ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx5 ztygaikadatejyuutoupx5}</td><td>（中継用）外貨建充当Ｐ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx6 ztygaikadatejyuutoupx6}</td><td>（中継用）外貨建充当Ｐ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx7 ztygaikadatejyuutoupx7}</td><td>（中継用）外貨建充当Ｐ＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx8 ztygaikadatejyuutoupx8}</td><td>（中継用）外貨建充当Ｐ＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx9 ztygaikadatejyuutoupx9}</td><td>（中継用）外貨建充当Ｐ＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx10 ztygaikadatejyuutoupx10}</td><td>（中継用）外貨建充当Ｐ＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx11 ztygaikadatejyuutoupx11}</td><td>（中継用）外貨建充当Ｐ＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx12 ztygaikadatejyuutoupx12}</td><td>（中継用）外貨建充当Ｐ＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx13 ztygaikadatejyuutoupx13}</td><td>（中継用）外貨建充当Ｐ＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx14 ztygaikadatejyuutoupx14}</td><td>（中継用）外貨建充当Ｐ＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx15 ztygaikadatejyuutoupx15}</td><td>（中継用）外貨建充当Ｐ＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoupx16 ztygaikadatejyuutoupx16}</td><td>（中継用）外貨建充当Ｐ＿１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysykykkitmttvkeisanym1 ztysykykkitmttvkeisanym1}</td><td>（中継用）主契約既積立Ｖ計算年月１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykykkitmttv1 ztysykykkitmttv1}</td><td>（中継用）主契約既積立Ｖ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysykykkitmttvkeisanym2 ztysykykkitmttvkeisanym2}</td><td>（中継用）主契約既積立Ｖ計算年月２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykykkitmttv2 ztysykykkitmttv2}</td><td>（中継用）主契約既積立Ｖ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrrthnduhknvkisovkisnyu1 ztyrrthnduhknvkisovkisnyu1}</td><td>（中継用）利率変動保険Ｖ基礎Ｖ計算用１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrrthnduhknvkisovkisnyu2 ztyrrthnduhknvkisovkisnyu2}</td><td>（中継用）利率変動保険Ｖ基礎Ｖ計算用２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrrthnduhknvkisovkisnyu3 ztyrrthnduhknvkisovkisnyu3}</td><td>（中継用）利率変動保険Ｖ基礎Ｖ計算用３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrrthnduhknvkisovkisnyu4 ztyrrthnduhknvkisovkisnyu4}</td><td>（中継用）利率変動保険Ｖ基礎Ｖ計算用４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrrthnduhknvkiso ztyrrthnduhknvkiso}</td><td>（中継用）利率変動保険Ｖ基礎Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin9 ztysuuriyouyobin9}</td><td>（中継用）数理用予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv14 ztyyobiv14}</td><td>（中継用）予備項目Ｖ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_RrtHndugtHknVKnsyuyuTy
 * @see     PKZT_RrtHndugtHknVKnsyuyuTy
 * @see     QZT_RrtHndugtHknVKnsyuyuTy
 * @see     GenQZT_RrtHndugtHknVKnsyuyuTy
 */
@MappedSuperclass
@Table(name=GenZT_RrtHndugtHknVKnsyuyuTy.TABLE_NAME)
@IdClass(value=PKZT_RrtHndugtHknVKnsyuyuTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_RrtHndugtHknVKnsyuyuTy extends AbstractExDBEntity<ZT_RrtHndugtHknVKnsyuyuTy, PKZT_RrtHndugtHknVKnsyuyuTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_RrtHndugtHknVKnsyuyuTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYUUKOURECORDLENGTH    = "ztyyuukourecordlength";
    public static final String ZTYRDWAREA               = "ztyrdwarea";
    public static final String ZTYKEIJYOUYM             = "ztykeijyouym";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYSOTODASIPMENKBN       = "ztysotodasipmenkbn";
    public static final String ZTYSOTODASIMANAGEHYOUJI  = "ztysotodasimanagehyouji";
    public static final String ZTYSRDAI1HKNKKN          = "ztysrdai1hknkkn";
    public static final String ZTYSUURIYOUYOBIN4        = "ztysuuriyouyobin4";
    public static final String ZTYTUUKASYUKBN           = "ztytuukasyukbn";
    public static final String ZTYYOBIV11               = "ztyyobiv11";
    public static final String ZTYKBNKEIRIYOUSEGMENTKBN = "ztykbnkeiriyousegmentkbn";
    public static final String ZTYKBNKEIRIYOURGNBNSKKBN = "ztykbnkeiriyourgnbnskkbn";
    public static final String ZTYSUURISYURUICD         = "ztysuurisyuruicd";
    public static final String ZTYSUURIYOUYOBIN6X2      = "ztysuuriyouyobin6x2";
    public static final String ZTYYOBIV8                = "ztyyobiv8";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHIHOKENSYAAGEV2       = "ztyhihokensyaagev2";
    public static final String ZTYKURIAGEKURISAGEKBN    = "ztykuriagekurisagekbn";
    public static final String ZTYSYUKEIYAKUPWARIBIKIKBN = "ztysyukeiyakupwaribikikbn";
    public static final String ZTYJIKAIPJYUUTOUYM2      = "ztyjikaipjyuutouym2";
    public static final String ZTYSYOKAINYKNJIKAWASEKJNYMD = "ztysyokainyknjikawasekjnymd";
    public static final String ZTYSUURIYOUYOBIN6X3      = "ztysuuriyouyobin6x3";
    public static final String ZTYYOBIV7                = "ztyyobiv7";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYKIMATUKAWASERATE      = "ztykimatukawaserate";
    public static final String ZTYYOTEIRIRITUN5         = "ztyyoteiriritun5";
    public static final String ZTYYOTEIRIRITUN5X2       = "ztyyoteiriritun5x2";
    public static final String ZTYYOTEIRIRITUN5X3       = "ztyyoteiriritun5x3";
    public static final String ZTYYOTEIRIRITUN5X4       = "ztyyoteiriritun5x4";
    public static final String ZTYYOTEIRIRITUN5X5       = "ztyyoteiriritun5x5";
    public static final String ZTYYOTEIRIRITUN5X6       = "ztyyoteiriritun5x6";
    public static final String ZTYYOTEIRIRITUN5X7       = "ztyyoteiriritun5x7";
    public static final String ZTYYOTEIRIRITUN5X8       = "ztyyoteiriritun5x8";
    public static final String ZTYYOTEIRIRITUN5X9       = "ztyyoteiriritun5x9";
    public static final String ZTYYOTEIRIRITUN5X10      = "ztyyoteiriritun5x10";
    public static final String ZTYYOTEIRIRITUN5X11      = "ztyyoteiriritun5x11";
    public static final String ZTYYOTEIRIRITUN5X12      = "ztyyoteiriritun5x12";
    public static final String ZTYYOTEIRIRITUN5X13      = "ztyyoteiriritun5x13";
    public static final String ZTYYOTEIRIRITUN5X14      = "ztyyoteiriritun5x14";
    public static final String ZTYYOTEIRIRITUN5X15      = "ztyyoteiriritun5x15";
    public static final String ZTYYOTEIRIRITUN5X16      = "ztyyoteiriritun5x16";
    public static final String ZTYYOBIV6                = "ztyyobiv6";
    public static final String ZTYSYUKEIYAKUP           = "ztysyukeiyakup";
    public static final String ZTYSYUPTUMITATEKIN       = "ztysyuptumitatekin";
    public static final String ZTYPTUMITATEKIN          = "ztyptumitatekin";
    public static final String ZTYPTUMITATEKINX2        = "ztyptumitatekinx2";
    public static final String ZTYPTUMITATEKINX3        = "ztyptumitatekinx3";
    public static final String ZTYPTUMITATEKINX4        = "ztyptumitatekinx4";
    public static final String ZTYPTUMITATEKINX5        = "ztyptumitatekinx5";
    public static final String ZTYPTUMITATEKINX6        = "ztyptumitatekinx6";
    public static final String ZTYPTUMITATEKINX7        = "ztyptumitatekinx7";
    public static final String ZTYPTUMITATEKINX8        = "ztyptumitatekinx8";
    public static final String ZTYPTUMITATEKINX9        = "ztyptumitatekinx9";
    public static final String ZTYPTUMITATEKINX10       = "ztyptumitatekinx10";
    public static final String ZTYPTUMITATEKINX11       = "ztyptumitatekinx11";
    public static final String ZTYPTUMITATEKINX12       = "ztyptumitatekinx12";
    public static final String ZTYPTUMITATEKINX13       = "ztyptumitatekinx13";
    public static final String ZTYPTUMITATEKINX14       = "ztyptumitatekinx14";
    public static final String ZTYPTUMITATEKINX15       = "ztyptumitatekinx15";
    public static final String ZTYPTUMITATEKINX16       = "ztyptumitatekinx16";
    public static final String ZTYGAIKADATEJYUUTOUP     = "ztygaikadatejyuutoup";
    public static final String ZTYGAIKADATEJYUUTOUPX2   = "ztygaikadatejyuutoupx2";
    public static final String ZTYGAIKADATEJYUUTOUPX3   = "ztygaikadatejyuutoupx3";
    public static final String ZTYGAIKADATEJYUUTOUPX4   = "ztygaikadatejyuutoupx4";
    public static final String ZTYGAIKADATEJYUUTOUPX5   = "ztygaikadatejyuutoupx5";
    public static final String ZTYGAIKADATEJYUUTOUPX6   = "ztygaikadatejyuutoupx6";
    public static final String ZTYGAIKADATEJYUUTOUPX7   = "ztygaikadatejyuutoupx7";
    public static final String ZTYGAIKADATEJYUUTOUPX8   = "ztygaikadatejyuutoupx8";
    public static final String ZTYGAIKADATEJYUUTOUPX9   = "ztygaikadatejyuutoupx9";
    public static final String ZTYGAIKADATEJYUUTOUPX10  = "ztygaikadatejyuutoupx10";
    public static final String ZTYGAIKADATEJYUUTOUPX11  = "ztygaikadatejyuutoupx11";
    public static final String ZTYGAIKADATEJYUUTOUPX12  = "ztygaikadatejyuutoupx12";
    public static final String ZTYGAIKADATEJYUUTOUPX13  = "ztygaikadatejyuutoupx13";
    public static final String ZTYGAIKADATEJYUUTOUPX14  = "ztygaikadatejyuutoupx14";
    public static final String ZTYGAIKADATEJYUUTOUPX15  = "ztygaikadatejyuutoupx15";
    public static final String ZTYGAIKADATEJYUUTOUPX16  = "ztygaikadatejyuutoupx16";
    public static final String ZTYSYKYKKITMTTVKEISANYM1 = "ztysykykkitmttvkeisanym1";
    public static final String ZTYSYKYKKITMTTV1         = "ztysykykkitmttv1";
    public static final String ZTYSYKYKKITMTTVKEISANYM2 = "ztysykykkitmttvkeisanym2";
    public static final String ZTYSYKYKKITMTTV2         = "ztysykykkitmttv2";
    public static final String ZTYRRTHNDUHKNVKISOVKISNYU1 = "ztyrrthnduhknvkisovkisnyu1";
    public static final String ZTYRRTHNDUHKNVKISOVKISNYU2 = "ztyrrthnduhknvkisovkisnyu2";
    public static final String ZTYRRTHNDUHKNVKISOVKISNYU3 = "ztyrrthnduhknvkisovkisnyu3";
    public static final String ZTYRRTHNDUHKNVKISOVKISNYU4 = "ztyrrthnduhknvkisovkisnyu4";
    public static final String ZTYRRTHNDUHKNVKISO       = "ztyrrthnduhknvkiso";
    public static final String ZTYSUURIYOUYOBIN9        = "ztysuuriyouyobin9";
    public static final String ZTYYOBIV14               = "ztyyobiv14";

    private final PKZT_RrtHndugtHknVKnsyuyuTy primaryKey;

    public GenZT_RrtHndugtHknVKnsyuyuTy() {
        primaryKey = new PKZT_RrtHndugtHknVKnsyuyuTy();
    }

    public GenZT_RrtHndugtHknVKnsyuyuTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_RrtHndugtHknVKnsyuyuTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_RrtHndugtHknVKnsyuyuTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_RrtHndugtHknVKnsyuyuTy> getMetaClass() {
        return QZT_RrtHndugtHknVKnsyuyuTy.class;
    }

    @Id
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztykeijyouym;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYKEIJYOUYM)
    public String getZtykeijyouym() {
        return ztykeijyouym;
    }

    public void setZtykeijyouym(String pZtykeijyouym) {
        ztykeijyouym = pZtykeijyouym;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztydatakanrino;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztysotodasipmenkbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSOTODASIPMENKBN)
    public String getZtysotodasipmenkbn() {
        return ztysotodasipmenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasipmenkbn(String pZtysotodasipmenkbn) {
        ztysotodasipmenkbn = pZtysotodasipmenkbn;
    }

    private String ztysotodasimanagehyouji;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSOTODASIMANAGEHYOUJI)
    public String getZtysotodasimanagehyouji() {
        return ztysotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasimanagehyouji(String pZtysotodasimanagehyouji) {
        ztysotodasimanagehyouji = pZtysotodasimanagehyouji;
    }

    private String ztysrdai1hknkkn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSRDAI1HKNKKN)
    public String getZtysrdai1hknkkn() {
        return ztysrdai1hknkkn;
    }

    public void setZtysrdai1hknkkn(String pZtysrdai1hknkkn) {
        ztysrdai1hknkkn = pZtysrdai1hknkkn;
    }

    private String ztysuuriyouyobin4;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSUURIYOUYOBIN4)
    public String getZtysuuriyouyobin4() {
        return ztysuuriyouyobin4;
    }

    public void setZtysuuriyouyobin4(String pZtysuuriyouyobin4) {
        ztysuuriyouyobin4 = pZtysuuriyouyobin4;
    }

    private String ztytuukasyukbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYTUUKASYUKBN)
    public String getZtytuukasyukbn() {
        return ztytuukasyukbn;
    }

    public void setZtytuukasyukbn(String pZtytuukasyukbn) {
        ztytuukasyukbn = pZtytuukasyukbn;
    }

    private String ztyyobiv11;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOBIV11)
    public String getZtyyobiv11() {
        return ztyyobiv11;
    }

    public void setZtyyobiv11(String pZtyyobiv11) {
        ztyyobiv11 = pZtyyobiv11;
    }

    private String ztykbnkeiriyousegmentkbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYKBNKEIRIYOUSEGMENTKBN)
    public String getZtykbnkeiriyousegmentkbn() {
        return ztykbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyousegmentkbn(String pZtykbnkeiriyousegmentkbn) {
        ztykbnkeiriyousegmentkbn = pZtykbnkeiriyousegmentkbn;
    }

    private String ztykbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYKBNKEIRIYOURGNBNSKKBN)
    public String getZtykbnkeiriyourgnbnskkbn() {
        return ztykbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyourgnbnskkbn(String pZtykbnkeiriyourgnbnskkbn) {
        ztykbnkeiriyourgnbnskkbn = pZtykbnkeiriyourgnbnskkbn;
    }

    private String ztysuurisyuruicd;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSUURISYURUICD)
    public String getZtysuurisyuruicd() {
        return ztysuurisyuruicd;
    }

    public void setZtysuurisyuruicd(String pZtysuurisyuruicd) {
        ztysuurisyuruicd = pZtysuurisyuruicd;
    }

    private String ztysuuriyouyobin6x2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSUURIYOUYOBIN6X2)
    public String getZtysuuriyouyobin6x2() {
        return ztysuuriyouyobin6x2;
    }

    public void setZtysuuriyouyobin6x2(String pZtysuuriyouyobin6x2) {
        ztysuuriyouyobin6x2 = pZtysuuriyouyobin6x2;
    }

    private String ztyyobiv8;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOBIV8)
    public String getZtyyobiv8() {
        return ztyyobiv8;
    }

    public void setZtyyobiv8(String pZtyyobiv8) {
        ztyyobiv8 = pZtyyobiv8;
    }

    private String ztykykymd;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String ztykuriagekurisagekbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYKURIAGEKURISAGEKBN)
    public String getZtykuriagekurisagekbn() {
        return ztykuriagekurisagekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykuriagekurisagekbn(String pZtykuriagekurisagekbn) {
        ztykuriagekurisagekbn = pZtykuriagekurisagekbn;
    }

    private String ztysyukeiyakupwaribikikbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSYUKEIYAKUPWARIBIKIKBN)
    public String getZtysyukeiyakupwaribikikbn() {
        return ztysyukeiyakupwaribikikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysyukeiyakupwaribikikbn(String pZtysyukeiyakupwaribikikbn) {
        ztysyukeiyakupwaribikikbn = pZtysyukeiyakupwaribikikbn;
    }

    private String ztyjikaipjyuutouym2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYJIKAIPJYUUTOUYM2)
    public String getZtyjikaipjyuutouym2() {
        return ztyjikaipjyuutouym2;
    }

    public void setZtyjikaipjyuutouym2(String pZtyjikaipjyuutouym2) {
        ztyjikaipjyuutouym2 = pZtyjikaipjyuutouym2;
    }

    private String ztysyokainyknjikawasekjnymd;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSYOKAINYKNJIKAWASEKJNYMD)
    public String getZtysyokainyknjikawasekjnymd() {
        return ztysyokainyknjikawasekjnymd;
    }

    public void setZtysyokainyknjikawasekjnymd(String pZtysyokainyknjikawasekjnymd) {
        ztysyokainyknjikawasekjnymd = pZtysyokainyknjikawasekjnymd;
    }

    private String ztysuuriyouyobin6x3;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSUURIYOUYOBIN6X3)
    public String getZtysuuriyouyobin6x3() {
        return ztysuuriyouyobin6x3;
    }

    public void setZtysuuriyouyobin6x3(String pZtysuuriyouyobin6x3) {
        ztysuuriyouyobin6x3 = pZtysuuriyouyobin6x3;
    }

    private String ztyyobiv7;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOBIV7)
    public String getZtyyobiv7() {
        return ztyyobiv7;
    }

    public void setZtyyobiv7(String pZtyyobiv7) {
        ztyyobiv7 = pZtyyobiv7;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private BizNumber ztykimatukawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYKIMATUKAWASERATE)
    public BizNumber getZtykimatukawaserate() {
        return ztykimatukawaserate;
    }

    public void setZtykimatukawaserate(BizNumber pZtykimatukawaserate) {
        ztykimatukawaserate = pZtykimatukawaserate;
    }

    private BizNumber ztyyoteiriritun5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5)
    public BizNumber getZtyyoteiriritun5() {
        return ztyyoteiriritun5;
    }

    public void setZtyyoteiriritun5(BizNumber pZtyyoteiriritun5) {
        ztyyoteiriritun5 = pZtyyoteiriritun5;
    }

    private BizNumber ztyyoteiriritun5x2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X2)
    public BizNumber getZtyyoteiriritun5x2() {
        return ztyyoteiriritun5x2;
    }

    public void setZtyyoteiriritun5x2(BizNumber pZtyyoteiriritun5x2) {
        ztyyoteiriritun5x2 = pZtyyoteiriritun5x2;
    }

    private BizNumber ztyyoteiriritun5x3;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X3)
    public BizNumber getZtyyoteiriritun5x3() {
        return ztyyoteiriritun5x3;
    }

    public void setZtyyoteiriritun5x3(BizNumber pZtyyoteiriritun5x3) {
        ztyyoteiriritun5x3 = pZtyyoteiriritun5x3;
    }

    private BizNumber ztyyoteiriritun5x4;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X4)
    public BizNumber getZtyyoteiriritun5x4() {
        return ztyyoteiriritun5x4;
    }

    public void setZtyyoteiriritun5x4(BizNumber pZtyyoteiriritun5x4) {
        ztyyoteiriritun5x4 = pZtyyoteiriritun5x4;
    }

    private BizNumber ztyyoteiriritun5x5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X5)
    public BizNumber getZtyyoteiriritun5x5() {
        return ztyyoteiriritun5x5;
    }

    public void setZtyyoteiriritun5x5(BizNumber pZtyyoteiriritun5x5) {
        ztyyoteiriritun5x5 = pZtyyoteiriritun5x5;
    }

    private BizNumber ztyyoteiriritun5x6;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X6)
    public BizNumber getZtyyoteiriritun5x6() {
        return ztyyoteiriritun5x6;
    }

    public void setZtyyoteiriritun5x6(BizNumber pZtyyoteiriritun5x6) {
        ztyyoteiriritun5x6 = pZtyyoteiriritun5x6;
    }

    private BizNumber ztyyoteiriritun5x7;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X7)
    public BizNumber getZtyyoteiriritun5x7() {
        return ztyyoteiriritun5x7;
    }

    public void setZtyyoteiriritun5x7(BizNumber pZtyyoteiriritun5x7) {
        ztyyoteiriritun5x7 = pZtyyoteiriritun5x7;
    }

    private BizNumber ztyyoteiriritun5x8;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X8)
    public BizNumber getZtyyoteiriritun5x8() {
        return ztyyoteiriritun5x8;
    }

    public void setZtyyoteiriritun5x8(BizNumber pZtyyoteiriritun5x8) {
        ztyyoteiriritun5x8 = pZtyyoteiriritun5x8;
    }

    private BizNumber ztyyoteiriritun5x9;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X9)
    public BizNumber getZtyyoteiriritun5x9() {
        return ztyyoteiriritun5x9;
    }

    public void setZtyyoteiriritun5x9(BizNumber pZtyyoteiriritun5x9) {
        ztyyoteiriritun5x9 = pZtyyoteiriritun5x9;
    }

    private BizNumber ztyyoteiriritun5x10;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X10)
    public BizNumber getZtyyoteiriritun5x10() {
        return ztyyoteiriritun5x10;
    }

    public void setZtyyoteiriritun5x10(BizNumber pZtyyoteiriritun5x10) {
        ztyyoteiriritun5x10 = pZtyyoteiriritun5x10;
    }

    private BizNumber ztyyoteiriritun5x11;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X11)
    public BizNumber getZtyyoteiriritun5x11() {
        return ztyyoteiriritun5x11;
    }

    public void setZtyyoteiriritun5x11(BizNumber pZtyyoteiriritun5x11) {
        ztyyoteiriritun5x11 = pZtyyoteiriritun5x11;
    }

    private BizNumber ztyyoteiriritun5x12;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X12)
    public BizNumber getZtyyoteiriritun5x12() {
        return ztyyoteiriritun5x12;
    }

    public void setZtyyoteiriritun5x12(BizNumber pZtyyoteiriritun5x12) {
        ztyyoteiriritun5x12 = pZtyyoteiriritun5x12;
    }

    private BizNumber ztyyoteiriritun5x13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X13)
    public BizNumber getZtyyoteiriritun5x13() {
        return ztyyoteiriritun5x13;
    }

    public void setZtyyoteiriritun5x13(BizNumber pZtyyoteiriritun5x13) {
        ztyyoteiriritun5x13 = pZtyyoteiriritun5x13;
    }

    private BizNumber ztyyoteiriritun5x14;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X14)
    public BizNumber getZtyyoteiriritun5x14() {
        return ztyyoteiriritun5x14;
    }

    public void setZtyyoteiriritun5x14(BizNumber pZtyyoteiriritun5x14) {
        ztyyoteiriritun5x14 = pZtyyoteiriritun5x14;
    }

    private BizNumber ztyyoteiriritun5x15;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X15)
    public BizNumber getZtyyoteiriritun5x15() {
        return ztyyoteiriritun5x15;
    }

    public void setZtyyoteiriritun5x15(BizNumber pZtyyoteiriritun5x15) {
        ztyyoteiriritun5x15 = pZtyyoteiriritun5x15;
    }

    private BizNumber ztyyoteiriritun5x16;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOTEIRIRITUN5X16)
    public BizNumber getZtyyoteiriritun5x16() {
        return ztyyoteiriritun5x16;
    }

    public void setZtyyoteiriritun5x16(BizNumber pZtyyoteiriritun5x16) {
        ztyyoteiriritun5x16 = pZtyyoteiriritun5x16;
    }

    private String ztyyobiv6;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }

    private Long ztysyukeiyakup;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSYUKEIYAKUP)
    public Long getZtysyukeiyakup() {
        return ztysyukeiyakup;
    }

    public void setZtysyukeiyakup(Long pZtysyukeiyakup) {
        ztysyukeiyakup = pZtysyukeiyakup;
    }

    private Long ztysyuptumitatekin;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSYUPTUMITATEKIN)
    public Long getZtysyuptumitatekin() {
        return ztysyuptumitatekin;
    }

    public void setZtysyuptumitatekin(Long pZtysyuptumitatekin) {
        ztysyuptumitatekin = pZtysyuptumitatekin;
    }

    private Long ztyptumitatekin;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKIN)
    public Long getZtyptumitatekin() {
        return ztyptumitatekin;
    }

    public void setZtyptumitatekin(Long pZtyptumitatekin) {
        ztyptumitatekin = pZtyptumitatekin;
    }

    private Long ztyptumitatekinx2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX2)
    public Long getZtyptumitatekinx2() {
        return ztyptumitatekinx2;
    }

    public void setZtyptumitatekinx2(Long pZtyptumitatekinx2) {
        ztyptumitatekinx2 = pZtyptumitatekinx2;
    }

    private Long ztyptumitatekinx3;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX3)
    public Long getZtyptumitatekinx3() {
        return ztyptumitatekinx3;
    }

    public void setZtyptumitatekinx3(Long pZtyptumitatekinx3) {
        ztyptumitatekinx3 = pZtyptumitatekinx3;
    }

    private Long ztyptumitatekinx4;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX4)
    public Long getZtyptumitatekinx4() {
        return ztyptumitatekinx4;
    }

    public void setZtyptumitatekinx4(Long pZtyptumitatekinx4) {
        ztyptumitatekinx4 = pZtyptumitatekinx4;
    }

    private Long ztyptumitatekinx5;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX5)
    public Long getZtyptumitatekinx5() {
        return ztyptumitatekinx5;
    }

    public void setZtyptumitatekinx5(Long pZtyptumitatekinx5) {
        ztyptumitatekinx5 = pZtyptumitatekinx5;
    }

    private Long ztyptumitatekinx6;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX6)
    public Long getZtyptumitatekinx6() {
        return ztyptumitatekinx6;
    }

    public void setZtyptumitatekinx6(Long pZtyptumitatekinx6) {
        ztyptumitatekinx6 = pZtyptumitatekinx6;
    }

    private Long ztyptumitatekinx7;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX7)
    public Long getZtyptumitatekinx7() {
        return ztyptumitatekinx7;
    }

    public void setZtyptumitatekinx7(Long pZtyptumitatekinx7) {
        ztyptumitatekinx7 = pZtyptumitatekinx7;
    }

    private Long ztyptumitatekinx8;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX8)
    public Long getZtyptumitatekinx8() {
        return ztyptumitatekinx8;
    }

    public void setZtyptumitatekinx8(Long pZtyptumitatekinx8) {
        ztyptumitatekinx8 = pZtyptumitatekinx8;
    }

    private Long ztyptumitatekinx9;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX9)
    public Long getZtyptumitatekinx9() {
        return ztyptumitatekinx9;
    }

    public void setZtyptumitatekinx9(Long pZtyptumitatekinx9) {
        ztyptumitatekinx9 = pZtyptumitatekinx9;
    }

    private Long ztyptumitatekinx10;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX10)
    public Long getZtyptumitatekinx10() {
        return ztyptumitatekinx10;
    }

    public void setZtyptumitatekinx10(Long pZtyptumitatekinx10) {
        ztyptumitatekinx10 = pZtyptumitatekinx10;
    }

    private Long ztyptumitatekinx11;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX11)
    public Long getZtyptumitatekinx11() {
        return ztyptumitatekinx11;
    }

    public void setZtyptumitatekinx11(Long pZtyptumitatekinx11) {
        ztyptumitatekinx11 = pZtyptumitatekinx11;
    }

    private Long ztyptumitatekinx12;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX12)
    public Long getZtyptumitatekinx12() {
        return ztyptumitatekinx12;
    }

    public void setZtyptumitatekinx12(Long pZtyptumitatekinx12) {
        ztyptumitatekinx12 = pZtyptumitatekinx12;
    }

    private Long ztyptumitatekinx13;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX13)
    public Long getZtyptumitatekinx13() {
        return ztyptumitatekinx13;
    }

    public void setZtyptumitatekinx13(Long pZtyptumitatekinx13) {
        ztyptumitatekinx13 = pZtyptumitatekinx13;
    }

    private Long ztyptumitatekinx14;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX14)
    public Long getZtyptumitatekinx14() {
        return ztyptumitatekinx14;
    }

    public void setZtyptumitatekinx14(Long pZtyptumitatekinx14) {
        ztyptumitatekinx14 = pZtyptumitatekinx14;
    }

    private Long ztyptumitatekinx15;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX15)
    public Long getZtyptumitatekinx15() {
        return ztyptumitatekinx15;
    }

    public void setZtyptumitatekinx15(Long pZtyptumitatekinx15) {
        ztyptumitatekinx15 = pZtyptumitatekinx15;
    }

    private Long ztyptumitatekinx16;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYPTUMITATEKINX16)
    public Long getZtyptumitatekinx16() {
        return ztyptumitatekinx16;
    }

    public void setZtyptumitatekinx16(Long pZtyptumitatekinx16) {
        ztyptumitatekinx16 = pZtyptumitatekinx16;
    }

    private Long ztygaikadatejyuutoup;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUP)
    public Long getZtygaikadatejyuutoup() {
        return ztygaikadatejyuutoup;
    }

    public void setZtygaikadatejyuutoup(Long pZtygaikadatejyuutoup) {
        ztygaikadatejyuutoup = pZtygaikadatejyuutoup;
    }

    private Long ztygaikadatejyuutoupx2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX2)
    public Long getZtygaikadatejyuutoupx2() {
        return ztygaikadatejyuutoupx2;
    }

    public void setZtygaikadatejyuutoupx2(Long pZtygaikadatejyuutoupx2) {
        ztygaikadatejyuutoupx2 = pZtygaikadatejyuutoupx2;
    }

    private Long ztygaikadatejyuutoupx3;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX3)
    public Long getZtygaikadatejyuutoupx3() {
        return ztygaikadatejyuutoupx3;
    }

    public void setZtygaikadatejyuutoupx3(Long pZtygaikadatejyuutoupx3) {
        ztygaikadatejyuutoupx3 = pZtygaikadatejyuutoupx3;
    }

    private Long ztygaikadatejyuutoupx4;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX4)
    public Long getZtygaikadatejyuutoupx4() {
        return ztygaikadatejyuutoupx4;
    }

    public void setZtygaikadatejyuutoupx4(Long pZtygaikadatejyuutoupx4) {
        ztygaikadatejyuutoupx4 = pZtygaikadatejyuutoupx4;
    }

    private Long ztygaikadatejyuutoupx5;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX5)
    public Long getZtygaikadatejyuutoupx5() {
        return ztygaikadatejyuutoupx5;
    }

    public void setZtygaikadatejyuutoupx5(Long pZtygaikadatejyuutoupx5) {
        ztygaikadatejyuutoupx5 = pZtygaikadatejyuutoupx5;
    }

    private Long ztygaikadatejyuutoupx6;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX6)
    public Long getZtygaikadatejyuutoupx6() {
        return ztygaikadatejyuutoupx6;
    }

    public void setZtygaikadatejyuutoupx6(Long pZtygaikadatejyuutoupx6) {
        ztygaikadatejyuutoupx6 = pZtygaikadatejyuutoupx6;
    }

    private Long ztygaikadatejyuutoupx7;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX7)
    public Long getZtygaikadatejyuutoupx7() {
        return ztygaikadatejyuutoupx7;
    }

    public void setZtygaikadatejyuutoupx7(Long pZtygaikadatejyuutoupx7) {
        ztygaikadatejyuutoupx7 = pZtygaikadatejyuutoupx7;
    }

    private Long ztygaikadatejyuutoupx8;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX8)
    public Long getZtygaikadatejyuutoupx8() {
        return ztygaikadatejyuutoupx8;
    }

    public void setZtygaikadatejyuutoupx8(Long pZtygaikadatejyuutoupx8) {
        ztygaikadatejyuutoupx8 = pZtygaikadatejyuutoupx8;
    }

    private Long ztygaikadatejyuutoupx9;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX9)
    public Long getZtygaikadatejyuutoupx9() {
        return ztygaikadatejyuutoupx9;
    }

    public void setZtygaikadatejyuutoupx9(Long pZtygaikadatejyuutoupx9) {
        ztygaikadatejyuutoupx9 = pZtygaikadatejyuutoupx9;
    }

    private Long ztygaikadatejyuutoupx10;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX10)
    public Long getZtygaikadatejyuutoupx10() {
        return ztygaikadatejyuutoupx10;
    }

    public void setZtygaikadatejyuutoupx10(Long pZtygaikadatejyuutoupx10) {
        ztygaikadatejyuutoupx10 = pZtygaikadatejyuutoupx10;
    }

    private Long ztygaikadatejyuutoupx11;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX11)
    public Long getZtygaikadatejyuutoupx11() {
        return ztygaikadatejyuutoupx11;
    }

    public void setZtygaikadatejyuutoupx11(Long pZtygaikadatejyuutoupx11) {
        ztygaikadatejyuutoupx11 = pZtygaikadatejyuutoupx11;
    }

    private Long ztygaikadatejyuutoupx12;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX12)
    public Long getZtygaikadatejyuutoupx12() {
        return ztygaikadatejyuutoupx12;
    }

    public void setZtygaikadatejyuutoupx12(Long pZtygaikadatejyuutoupx12) {
        ztygaikadatejyuutoupx12 = pZtygaikadatejyuutoupx12;
    }

    private Long ztygaikadatejyuutoupx13;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX13)
    public Long getZtygaikadatejyuutoupx13() {
        return ztygaikadatejyuutoupx13;
    }

    public void setZtygaikadatejyuutoupx13(Long pZtygaikadatejyuutoupx13) {
        ztygaikadatejyuutoupx13 = pZtygaikadatejyuutoupx13;
    }

    private Long ztygaikadatejyuutoupx14;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX14)
    public Long getZtygaikadatejyuutoupx14() {
        return ztygaikadatejyuutoupx14;
    }

    public void setZtygaikadatejyuutoupx14(Long pZtygaikadatejyuutoupx14) {
        ztygaikadatejyuutoupx14 = pZtygaikadatejyuutoupx14;
    }

    private Long ztygaikadatejyuutoupx15;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX15)
    public Long getZtygaikadatejyuutoupx15() {
        return ztygaikadatejyuutoupx15;
    }

    public void setZtygaikadatejyuutoupx15(Long pZtygaikadatejyuutoupx15) {
        ztygaikadatejyuutoupx15 = pZtygaikadatejyuutoupx15;
    }

    private Long ztygaikadatejyuutoupx16;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYGAIKADATEJYUUTOUPX16)
    public Long getZtygaikadatejyuutoupx16() {
        return ztygaikadatejyuutoupx16;
    }

    public void setZtygaikadatejyuutoupx16(Long pZtygaikadatejyuutoupx16) {
        ztygaikadatejyuutoupx16 = pZtygaikadatejyuutoupx16;
    }

    private String ztysykykkitmttvkeisanym1;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSYKYKKITMTTVKEISANYM1)
    public String getZtysykykkitmttvkeisanym1() {
        return ztysykykkitmttvkeisanym1;
    }

    public void setZtysykykkitmttvkeisanym1(String pZtysykykkitmttvkeisanym1) {
        ztysykykkitmttvkeisanym1 = pZtysykykkitmttvkeisanym1;
    }

    private Long ztysykykkitmttv1;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSYKYKKITMTTV1)
    public Long getZtysykykkitmttv1() {
        return ztysykykkitmttv1;
    }

    public void setZtysykykkitmttv1(Long pZtysykykkitmttv1) {
        ztysykykkitmttv1 = pZtysykykkitmttv1;
    }

    private String ztysykykkitmttvkeisanym2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSYKYKKITMTTVKEISANYM2)
    public String getZtysykykkitmttvkeisanym2() {
        return ztysykykkitmttvkeisanym2;
    }

    public void setZtysykykkitmttvkeisanym2(String pZtysykykkitmttvkeisanym2) {
        ztysykykkitmttvkeisanym2 = pZtysykykkitmttvkeisanym2;
    }

    private Long ztysykykkitmttv2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSYKYKKITMTTV2)
    public Long getZtysykykkitmttv2() {
        return ztysykykkitmttv2;
    }

    public void setZtysykykkitmttv2(Long pZtysykykkitmttv2) {
        ztysykykkitmttv2 = pZtysykykkitmttv2;
    }

    private Long ztyrrthnduhknvkisovkisnyu1;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYRRTHNDUHKNVKISOVKISNYU1)
    public Long getZtyrrthnduhknvkisovkisnyu1() {
        return ztyrrthnduhknvkisovkisnyu1;
    }

    public void setZtyrrthnduhknvkisovkisnyu1(Long pZtyrrthnduhknvkisovkisnyu1) {
        ztyrrthnduhknvkisovkisnyu1 = pZtyrrthnduhknvkisovkisnyu1;
    }

    private Long ztyrrthnduhknvkisovkisnyu2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYRRTHNDUHKNVKISOVKISNYU2)
    public Long getZtyrrthnduhknvkisovkisnyu2() {
        return ztyrrthnduhknvkisovkisnyu2;
    }

    public void setZtyrrthnduhknvkisovkisnyu2(Long pZtyrrthnduhknvkisovkisnyu2) {
        ztyrrthnduhknvkisovkisnyu2 = pZtyrrthnduhknvkisovkisnyu2;
    }

    private Long ztyrrthnduhknvkisovkisnyu3;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYRRTHNDUHKNVKISOVKISNYU3)
    public Long getZtyrrthnduhknvkisovkisnyu3() {
        return ztyrrthnduhknvkisovkisnyu3;
    }

    public void setZtyrrthnduhknvkisovkisnyu3(Long pZtyrrthnduhknvkisovkisnyu3) {
        ztyrrthnduhknvkisovkisnyu3 = pZtyrrthnduhknvkisovkisnyu3;
    }

    private Long ztyrrthnduhknvkisovkisnyu4;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYRRTHNDUHKNVKISOVKISNYU4)
    public Long getZtyrrthnduhknvkisovkisnyu4() {
        return ztyrrthnduhknvkisovkisnyu4;
    }

    public void setZtyrrthnduhknvkisovkisnyu4(Long pZtyrrthnduhknvkisovkisnyu4) {
        ztyrrthnduhknvkisovkisnyu4 = pZtyrrthnduhknvkisovkisnyu4;
    }

    private Long ztyrrthnduhknvkiso;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYRRTHNDUHKNVKISO)
    public Long getZtyrrthnduhknvkiso() {
        return ztyrrthnduhknvkiso;
    }

    public void setZtyrrthnduhknvkiso(Long pZtyrrthnduhknvkiso) {
        ztyrrthnduhknvkiso = pZtyrrthnduhknvkiso;
    }

    private String ztysuuriyouyobin9;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYSUURIYOUYOBIN9)
    public String getZtysuuriyouyobin9() {
        return ztysuuriyouyobin9;
    }

    public void setZtysuuriyouyobin9(String pZtysuuriyouyobin9) {
        ztysuuriyouyobin9 = pZtysuuriyouyobin9;
    }

    private String ztyyobiv14;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuTy.ZTYYOBIV14)
    public String getZtyyobiv14() {
        return ztyyobiv14;
    }

    public void setZtyyobiv14(String pZtyyobiv14) {
        ztyyobiv14 = pZtyyobiv14;
    }
}