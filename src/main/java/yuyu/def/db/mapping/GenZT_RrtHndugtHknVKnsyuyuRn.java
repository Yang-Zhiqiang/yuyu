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
import yuyu.def.db.entity.ZT_RrtHndugtHknVKnsyuyuRn;
import yuyu.def.db.id.PKZT_RrtHndugtHknVKnsyuyuRn;
import yuyu.def.db.meta.GenQZT_RrtHndugtHknVKnsyuyuRn;
import yuyu.def.db.meta.QZT_RrtHndugtHknVKnsyuyuRn;

/**
 * 利率変動型保険Ｖ検証用Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_RrtHndugtHknVKnsyuyuRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RrtHndugtHknVKnsyuyuRn}</td><td colspan="3">利率変動型保険Ｖ検証用Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_RrtHndugtHknVKnsyuyuRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyuukourecordlength zrnyuukourecordlength}</td><td>（連携用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrdwarea zrnrdwarea}</td><td>（連携用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeijyouym zrnkeijyouym}</td><td>（連携用）計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasipmenkbn zrnsotodasipmenkbn}</td><td>（連携用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasimanagehyouji zrnsotodasimanagehyouji}</td><td>（連携用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrdai1hknkkn zrnsrdai1hknkkn}</td><td>（連携用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin4 zrnsuuriyouyobin4}</td><td>（連携用）数理用予備項目Ｎ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv11 zrnyobiv11}</td><td>（連携用）予備項目Ｖ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentkbn zrnkbnkeiriyousegmentkbn}</td><td>（連携用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyourgnbnskkbn zrnkbnkeiriyourgnbnskkbn}</td><td>（連携用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuurisyuruicd zrnsuurisyuruicd}</td><td>（連携用）数理種類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin6x2 zrnsuuriyouyobin6x2}</td><td>（連携用）数理用予備項目Ｎ６＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8 zrnyobiv8}</td><td>（連携用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyaagev2 zrnhihokensyaagev2}</td><td>（連携用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkuriagekurisagekbn zrnkuriagekurisagekbn}</td><td>（連携用）繰上げ繰下げ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakupwaribikikbn zrnsyukeiyakupwaribikikbn}</td><td>（連携用）主契約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikaipjyuutouym2 zrnjikaipjyuutouym2}</td><td>（連携用）次回Ｐ充当年月２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokainyknjikawasekjnymd zrnsyokainyknjikawasekjnymd}</td><td>（連携用）初回入金時為替基準年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin6x3 zrnsuuriyouyobin6x3}</td><td>（連携用）数理用予備項目Ｎ６＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7 zrnyobiv7}</td><td>（連携用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkimatukawaserate zrnkimatukawaserate}</td><td>（連携用）期末為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5 zrnyoteiriritun5}</td><td>（連携用）予定利率Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x2 zrnyoteiriritun5x2}</td><td>（連携用）予定利率Ｎ５＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x3 zrnyoteiriritun5x3}</td><td>（連携用）予定利率Ｎ５＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x4 zrnyoteiriritun5x4}</td><td>（連携用）予定利率Ｎ５＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x5 zrnyoteiriritun5x5}</td><td>（連携用）予定利率Ｎ５＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x6 zrnyoteiriritun5x6}</td><td>（連携用）予定利率Ｎ５＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x7 zrnyoteiriritun5x7}</td><td>（連携用）予定利率Ｎ５＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x8 zrnyoteiriritun5x8}</td><td>（連携用）予定利率Ｎ５＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x9 zrnyoteiriritun5x9}</td><td>（連携用）予定利率Ｎ５＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x10 zrnyoteiriritun5x10}</td><td>（連携用）予定利率Ｎ５＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x11 zrnyoteiriritun5x11}</td><td>（連携用）予定利率Ｎ５＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x12 zrnyoteiriritun5x12}</td><td>（連携用）予定利率Ｎ５＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x13 zrnyoteiriritun5x13}</td><td>（連携用）予定利率Ｎ５＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x14 zrnyoteiriritun5x14}</td><td>（連携用）予定利率Ｎ５＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x15 zrnyoteiriritun5x15}</td><td>（連携用）予定利率Ｎ５＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5x16 zrnyoteiriritun5x16}</td><td>（連携用）予定利率Ｎ５＿１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyobiv6 zrnyobiv6}</td><td>（連携用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakup zrnsyukeiyakup}</td><td>（連携用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyuptumitatekin zrnsyuptumitatekin}</td><td>（連携用）主契約保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekin zrnptumitatekin}</td><td>（連携用）保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx2 zrnptumitatekinx2}</td><td>（連携用）保険料積立金＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx3 zrnptumitatekinx3}</td><td>（連携用）保険料積立金＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx4 zrnptumitatekinx4}</td><td>（連携用）保険料積立金＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx5 zrnptumitatekinx5}</td><td>（連携用）保険料積立金＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx6 zrnptumitatekinx6}</td><td>（連携用）保険料積立金＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx7 zrnptumitatekinx7}</td><td>（連携用）保険料積立金＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx8 zrnptumitatekinx8}</td><td>（連携用）保険料積立金＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx9 zrnptumitatekinx9}</td><td>（連携用）保険料積立金＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx10 zrnptumitatekinx10}</td><td>（連携用）保険料積立金＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx11 zrnptumitatekinx11}</td><td>（連携用）保険料積立金＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx12 zrnptumitatekinx12}</td><td>（連携用）保険料積立金＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx13 zrnptumitatekinx13}</td><td>（連携用）保険料積立金＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx14 zrnptumitatekinx14}</td><td>（連携用）保険料積立金＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx15 zrnptumitatekinx15}</td><td>（連携用）保険料積立金＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnptumitatekinx16 zrnptumitatekinx16}</td><td>（連携用）保険料積立金＿１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoup zrngaikadatejyuutoup}</td><td>（連携用）外貨建充当Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx2 zrngaikadatejyuutoupx2}</td><td>（連携用）外貨建充当Ｐ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx3 zrngaikadatejyuutoupx3}</td><td>（連携用）外貨建充当Ｐ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx4 zrngaikadatejyuutoupx4}</td><td>（連携用）外貨建充当Ｐ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx5 zrngaikadatejyuutoupx5}</td><td>（連携用）外貨建充当Ｐ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx6 zrngaikadatejyuutoupx6}</td><td>（連携用）外貨建充当Ｐ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx7 zrngaikadatejyuutoupx7}</td><td>（連携用）外貨建充当Ｐ＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx8 zrngaikadatejyuutoupx8}</td><td>（連携用）外貨建充当Ｐ＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx9 zrngaikadatejyuutoupx9}</td><td>（連携用）外貨建充当Ｐ＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx10 zrngaikadatejyuutoupx10}</td><td>（連携用）外貨建充当Ｐ＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx11 zrngaikadatejyuutoupx11}</td><td>（連携用）外貨建充当Ｐ＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx12 zrngaikadatejyuutoupx12}</td><td>（連携用）外貨建充当Ｐ＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx13 zrngaikadatejyuutoupx13}</td><td>（連携用）外貨建充当Ｐ＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx14 zrngaikadatejyuutoupx14}</td><td>（連携用）外貨建充当Ｐ＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx15 zrngaikadatejyuutoupx15}</td><td>（連携用）外貨建充当Ｐ＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoupx16 zrngaikadatejyuutoupx16}</td><td>（連携用）外貨建充当Ｐ＿１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsykykkitmttvkeisanym1 zrnsykykkitmttvkeisanym1}</td><td>（連携用）主契約既積立Ｖ計算年月１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykykkitmttv1 zrnsykykkitmttv1}</td><td>（連携用）主契約既積立Ｖ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsykykkitmttvkeisanym2 zrnsykykkitmttvkeisanym2}</td><td>（連携用）主契約既積立Ｖ計算年月２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykykkitmttv2 zrnsykykkitmttv2}</td><td>（連携用）主契約既積立Ｖ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrrthnduhknvkisovkisnyu1 zrnrrthnduhknvkisovkisnyu1}</td><td>（連携用）利率変動保険Ｖ基礎Ｖ計算用１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrrthnduhknvkisovkisnyu2 zrnrrthnduhknvkisovkisnyu2}</td><td>（連携用）利率変動保険Ｖ基礎Ｖ計算用２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrrthnduhknvkisovkisnyu3 zrnrrthnduhknvkisovkisnyu3}</td><td>（連携用）利率変動保険Ｖ基礎Ｖ計算用３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrrthnduhknvkisovkisnyu4 zrnrrthnduhknvkisovkisnyu4}</td><td>（連携用）利率変動保険Ｖ基礎Ｖ計算用４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrrthnduhknvkiso zrnrrthnduhknvkiso}</td><td>（連携用）利率変動保険Ｖ基礎Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin9 zrnsuuriyouyobin9}</td><td>（連携用）数理用予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv14 zrnyobiv14}</td><td>（連携用）予備項目Ｖ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_RrtHndugtHknVKnsyuyuRn
 * @see     PKZT_RrtHndugtHknVKnsyuyuRn
 * @see     QZT_RrtHndugtHknVKnsyuyuRn
 * @see     GenQZT_RrtHndugtHknVKnsyuyuRn
 */
@MappedSuperclass
@Table(name=GenZT_RrtHndugtHknVKnsyuyuRn.TABLE_NAME)
@IdClass(value=PKZT_RrtHndugtHknVKnsyuyuRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_RrtHndugtHknVKnsyuyuRn extends AbstractExDBEntityForZDB<ZT_RrtHndugtHknVKnsyuyuRn, PKZT_RrtHndugtHknVKnsyuyuRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_RrtHndugtHknVKnsyuyuRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYUUKOURECORDLENGTH    = "zrnyuukourecordlength";
    public static final String ZRNRDWAREA               = "zrnrdwarea";
    public static final String ZRNKEIJYOUYM             = "zrnkeijyouym";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNSOTODASIPMENKBN       = "zrnsotodasipmenkbn";
    public static final String ZRNSOTODASIMANAGEHYOUJI  = "zrnsotodasimanagehyouji";
    public static final String ZRNSRDAI1HKNKKN          = "zrnsrdai1hknkkn";
    public static final String ZRNSUURIYOUYOBIN4        = "zrnsuuriyouyobin4";
    public static final String ZRNTUUKASYUKBN           = "zrntuukasyukbn";
    public static final String ZRNYOBIV11               = "zrnyobiv11";
    public static final String ZRNKBNKEIRIYOUSEGMENTKBN = "zrnkbnkeiriyousegmentkbn";
    public static final String ZRNKBNKEIRIYOURGNBNSKKBN = "zrnkbnkeiriyourgnbnskkbn";
    public static final String ZRNSUURISYURUICD         = "zrnsuurisyuruicd";
    public static final String ZRNSUURIYOUYOBIN6X2      = "zrnsuuriyouyobin6x2";
    public static final String ZRNYOBIV8                = "zrnyobiv8";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHIHOKENSYAAGEV2       = "zrnhihokensyaagev2";
    public static final String ZRNKURIAGEKURISAGEKBN    = "zrnkuriagekurisagekbn";
    public static final String ZRNSYUKEIYAKUPWARIBIKIKBN = "zrnsyukeiyakupwaribikikbn";
    public static final String ZRNJIKAIPJYUUTOUYM2      = "zrnjikaipjyuutouym2";
    public static final String ZRNSYOKAINYKNJIKAWASEKJNYMD = "zrnsyokainyknjikawasekjnymd";
    public static final String ZRNSUURIYOUYOBIN6X3      = "zrnsuuriyouyobin6x3";
    public static final String ZRNYOBIV7                = "zrnyobiv7";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNKIMATUKAWASERATE      = "zrnkimatukawaserate";
    public static final String ZRNYOTEIRIRITUN5         = "zrnyoteiriritun5";
    public static final String ZRNYOTEIRIRITUN5X2       = "zrnyoteiriritun5x2";
    public static final String ZRNYOTEIRIRITUN5X3       = "zrnyoteiriritun5x3";
    public static final String ZRNYOTEIRIRITUN5X4       = "zrnyoteiriritun5x4";
    public static final String ZRNYOTEIRIRITUN5X5       = "zrnyoteiriritun5x5";
    public static final String ZRNYOTEIRIRITUN5X6       = "zrnyoteiriritun5x6";
    public static final String ZRNYOTEIRIRITUN5X7       = "zrnyoteiriritun5x7";
    public static final String ZRNYOTEIRIRITUN5X8       = "zrnyoteiriritun5x8";
    public static final String ZRNYOTEIRIRITUN5X9       = "zrnyoteiriritun5x9";
    public static final String ZRNYOTEIRIRITUN5X10      = "zrnyoteiriritun5x10";
    public static final String ZRNYOTEIRIRITUN5X11      = "zrnyoteiriritun5x11";
    public static final String ZRNYOTEIRIRITUN5X12      = "zrnyoteiriritun5x12";
    public static final String ZRNYOTEIRIRITUN5X13      = "zrnyoteiriritun5x13";
    public static final String ZRNYOTEIRIRITUN5X14      = "zrnyoteiriritun5x14";
    public static final String ZRNYOTEIRIRITUN5X15      = "zrnyoteiriritun5x15";
    public static final String ZRNYOTEIRIRITUN5X16      = "zrnyoteiriritun5x16";
    public static final String ZRNYOBIV6                = "zrnyobiv6";
    public static final String ZRNSYUKEIYAKUP           = "zrnsyukeiyakup";
    public static final String ZRNSYUPTUMITATEKIN       = "zrnsyuptumitatekin";
    public static final String ZRNPTUMITATEKIN          = "zrnptumitatekin";
    public static final String ZRNPTUMITATEKINX2        = "zrnptumitatekinx2";
    public static final String ZRNPTUMITATEKINX3        = "zrnptumitatekinx3";
    public static final String ZRNPTUMITATEKINX4        = "zrnptumitatekinx4";
    public static final String ZRNPTUMITATEKINX5        = "zrnptumitatekinx5";
    public static final String ZRNPTUMITATEKINX6        = "zrnptumitatekinx6";
    public static final String ZRNPTUMITATEKINX7        = "zrnptumitatekinx7";
    public static final String ZRNPTUMITATEKINX8        = "zrnptumitatekinx8";
    public static final String ZRNPTUMITATEKINX9        = "zrnptumitatekinx9";
    public static final String ZRNPTUMITATEKINX10       = "zrnptumitatekinx10";
    public static final String ZRNPTUMITATEKINX11       = "zrnptumitatekinx11";
    public static final String ZRNPTUMITATEKINX12       = "zrnptumitatekinx12";
    public static final String ZRNPTUMITATEKINX13       = "zrnptumitatekinx13";
    public static final String ZRNPTUMITATEKINX14       = "zrnptumitatekinx14";
    public static final String ZRNPTUMITATEKINX15       = "zrnptumitatekinx15";
    public static final String ZRNPTUMITATEKINX16       = "zrnptumitatekinx16";
    public static final String ZRNGAIKADATEJYUUTOUP     = "zrngaikadatejyuutoup";
    public static final String ZRNGAIKADATEJYUUTOUPX2   = "zrngaikadatejyuutoupx2";
    public static final String ZRNGAIKADATEJYUUTOUPX3   = "zrngaikadatejyuutoupx3";
    public static final String ZRNGAIKADATEJYUUTOUPX4   = "zrngaikadatejyuutoupx4";
    public static final String ZRNGAIKADATEJYUUTOUPX5   = "zrngaikadatejyuutoupx5";
    public static final String ZRNGAIKADATEJYUUTOUPX6   = "zrngaikadatejyuutoupx6";
    public static final String ZRNGAIKADATEJYUUTOUPX7   = "zrngaikadatejyuutoupx7";
    public static final String ZRNGAIKADATEJYUUTOUPX8   = "zrngaikadatejyuutoupx8";
    public static final String ZRNGAIKADATEJYUUTOUPX9   = "zrngaikadatejyuutoupx9";
    public static final String ZRNGAIKADATEJYUUTOUPX10  = "zrngaikadatejyuutoupx10";
    public static final String ZRNGAIKADATEJYUUTOUPX11  = "zrngaikadatejyuutoupx11";
    public static final String ZRNGAIKADATEJYUUTOUPX12  = "zrngaikadatejyuutoupx12";
    public static final String ZRNGAIKADATEJYUUTOUPX13  = "zrngaikadatejyuutoupx13";
    public static final String ZRNGAIKADATEJYUUTOUPX14  = "zrngaikadatejyuutoupx14";
    public static final String ZRNGAIKADATEJYUUTOUPX15  = "zrngaikadatejyuutoupx15";
    public static final String ZRNGAIKADATEJYUUTOUPX16  = "zrngaikadatejyuutoupx16";
    public static final String ZRNSYKYKKITMTTVKEISANYM1 = "zrnsykykkitmttvkeisanym1";
    public static final String ZRNSYKYKKITMTTV1         = "zrnsykykkitmttv1";
    public static final String ZRNSYKYKKITMTTVKEISANYM2 = "zrnsykykkitmttvkeisanym2";
    public static final String ZRNSYKYKKITMTTV2         = "zrnsykykkitmttv2";
    public static final String ZRNRRTHNDUHKNVKISOVKISNYU1 = "zrnrrthnduhknvkisovkisnyu1";
    public static final String ZRNRRTHNDUHKNVKISOVKISNYU2 = "zrnrrthnduhknvkisovkisnyu2";
    public static final String ZRNRRTHNDUHKNVKISOVKISNYU3 = "zrnrrthnduhknvkisovkisnyu3";
    public static final String ZRNRRTHNDUHKNVKISOVKISNYU4 = "zrnrrthnduhknvkisovkisnyu4";
    public static final String ZRNRRTHNDUHKNVKISO       = "zrnrrthnduhknvkiso";
    public static final String ZRNSUURIYOUYOBIN9        = "zrnsuuriyouyobin9";
    public static final String ZRNYOBIV14               = "zrnyobiv14";

    private final PKZT_RrtHndugtHknVKnsyuyuRn primaryKey;

    public GenZT_RrtHndugtHknVKnsyuyuRn() {
        primaryKey = new PKZT_RrtHndugtHknVKnsyuyuRn();
    }

    public GenZT_RrtHndugtHknVKnsyuyuRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_RrtHndugtHknVKnsyuyuRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_RrtHndugtHknVKnsyuyuRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_RrtHndugtHknVKnsyuyuRn> getMetaClass() {
        return QZT_RrtHndugtHknVKnsyuyuRn.class;
    }

    @Id
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private Integer zrnyuukourecordlength;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYUUKOURECORDLENGTH)
    public Integer getZrnyuukourecordlength() {
        return zrnyuukourecordlength;
    }

    public void setZrnyuukourecordlength(Integer pZrnyuukourecordlength) {
        zrnyuukourecordlength = pZrnyuukourecordlength;
    }

    private String zrnrdwarea;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNRDWAREA)
    public String getZrnrdwarea() {
        return zrnrdwarea;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnrdwarea(String pZrnrdwarea) {
        zrnrdwarea = pZrnrdwarea;
    }

    private String zrnkeijyouym;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNKEIJYOUYM)
    public String getZrnkeijyouym() {
        return zrnkeijyouym;
    }

    public void setZrnkeijyouym(String pZrnkeijyouym) {
        zrnkeijyouym = pZrnkeijyouym;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrndatakanrino;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnsotodasipmenkbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSOTODASIPMENKBN)
    public String getZrnsotodasipmenkbn() {
        return zrnsotodasipmenkbn;
    }

    public void setZrnsotodasipmenkbn(String pZrnsotodasipmenkbn) {
        zrnsotodasipmenkbn = pZrnsotodasipmenkbn;
    }

    private String zrnsotodasimanagehyouji;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSOTODASIMANAGEHYOUJI)
    public String getZrnsotodasimanagehyouji() {
        return zrnsotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsotodasimanagehyouji(String pZrnsotodasimanagehyouji) {
        zrnsotodasimanagehyouji = pZrnsotodasimanagehyouji;
    }

    private String zrnsrdai1hknkkn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSRDAI1HKNKKN)
    public String getZrnsrdai1hknkkn() {
        return zrnsrdai1hknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsrdai1hknkkn(String pZrnsrdai1hknkkn) {
        zrnsrdai1hknkkn = pZrnsrdai1hknkkn;
    }

    private String zrnsuuriyouyobin4;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSUURIYOUYOBIN4)
    public String getZrnsuuriyouyobin4() {
        return zrnsuuriyouyobin4;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnsuuriyouyobin4(String pZrnsuuriyouyobin4) {
        zrnsuuriyouyobin4 = pZrnsuuriyouyobin4;
    }

    private String zrntuukasyukbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNTUUKASYUKBN)
    public String getZrntuukasyukbn() {
        return zrntuukasyukbn;
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        zrntuukasyukbn = pZrntuukasyukbn;
    }

    private String zrnyobiv11;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOBIV11)
    public String getZrnyobiv11() {
        return zrnyobiv11;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnyobiv11(String pZrnyobiv11) {
        zrnyobiv11 = pZrnyobiv11;
    }

    private String zrnkbnkeiriyousegmentkbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNKBNKEIRIYOUSEGMENTKBN)
    public String getZrnkbnkeiriyousegmentkbn() {
        return zrnkbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyousegmentkbn(String pZrnkbnkeiriyousegmentkbn) {
        zrnkbnkeiriyousegmentkbn = pZrnkbnkeiriyousegmentkbn;
    }

    private String zrnkbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNKBNKEIRIYOURGNBNSKKBN)
    public String getZrnkbnkeiriyourgnbnskkbn() {
        return zrnkbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyourgnbnskkbn(String pZrnkbnkeiriyourgnbnskkbn) {
        zrnkbnkeiriyourgnbnskkbn = pZrnkbnkeiriyourgnbnskkbn;
    }

    private String zrnsuurisyuruicd;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSUURISYURUICD)
    public String getZrnsuurisyuruicd() {
        return zrnsuurisyuruicd;
    }

    public void setZrnsuurisyuruicd(String pZrnsuurisyuruicd) {
        zrnsuurisyuruicd = pZrnsuurisyuruicd;
    }

    private String zrnsuuriyouyobin6x2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSUURIYOUYOBIN6X2)
    public String getZrnsuuriyouyobin6x2() {
        return zrnsuuriyouyobin6x2;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsuuriyouyobin6x2(String pZrnsuuriyouyobin6x2) {
        zrnsuuriyouyobin6x2 = pZrnsuuriyouyobin6x2;
    }

    private String zrnyobiv8;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOBIV8)
    public String getZrnyobiv8() {
        return zrnyobiv8;
    }

    public void setZrnyobiv8(String pZrnyobiv8) {
        zrnyobiv8 = pZrnyobiv8;
    }

    private String zrnkykymd;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhihokensyaagev2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNHIHOKENSYAAGEV2)
    public String getZrnhihokensyaagev2() {
        return zrnhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyaagev2(String pZrnhihokensyaagev2) {
        zrnhihokensyaagev2 = pZrnhihokensyaagev2;
    }

    private String zrnkuriagekurisagekbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNKURIAGEKURISAGEKBN)
    public String getZrnkuriagekurisagekbn() {
        return zrnkuriagekurisagekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkuriagekurisagekbn(String pZrnkuriagekurisagekbn) {
        zrnkuriagekurisagekbn = pZrnkuriagekurisagekbn;
    }

    private String zrnsyukeiyakupwaribikikbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSYUKEIYAKUPWARIBIKIKBN)
    public String getZrnsyukeiyakupwaribikikbn() {
        return zrnsyukeiyakupwaribikikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyukeiyakupwaribikikbn(String pZrnsyukeiyakupwaribikikbn) {
        zrnsyukeiyakupwaribikikbn = pZrnsyukeiyakupwaribikikbn;
    }

    private String zrnjikaipjyuutouym2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNJIKAIPJYUUTOUYM2)
    public String getZrnjikaipjyuutouym2() {
        return zrnjikaipjyuutouym2;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnjikaipjyuutouym2(String pZrnjikaipjyuutouym2) {
        zrnjikaipjyuutouym2 = pZrnjikaipjyuutouym2;
    }

    private String zrnsyokainyknjikawasekjnymd;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSYOKAINYKNJIKAWASEKJNYMD)
    public String getZrnsyokainyknjikawasekjnymd() {
        return zrnsyokainyknjikawasekjnymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsyokainyknjikawasekjnymd(String pZrnsyokainyknjikawasekjnymd) {
        zrnsyokainyknjikawasekjnymd = pZrnsyokainyknjikawasekjnymd;
    }

    private String zrnsuuriyouyobin6x3;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSUURIYOUYOBIN6X3)
    public String getZrnsuuriyouyobin6x3() {
        return zrnsuuriyouyobin6x3;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsuuriyouyobin6x3(String pZrnsuuriyouyobin6x3) {
        zrnsuuriyouyobin6x3 = pZrnsuuriyouyobin6x3;
    }

    private String zrnyobiv7;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOBIV7)
    public String getZrnyobiv7() {
        return zrnyobiv7;
    }

    public void setZrnyobiv7(String pZrnyobiv7) {
        zrnyobiv7 = pZrnyobiv7;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private BizNumber zrnkimatukawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNKIMATUKAWASERATE)
    public BizNumber getZrnkimatukawaserate() {
        return zrnkimatukawaserate;
    }

    public void setZrnkimatukawaserate(BizNumber pZrnkimatukawaserate) {
        zrnkimatukawaserate = pZrnkimatukawaserate;
    }

    private BizNumber zrnyoteiriritun5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5)
    public BizNumber getZrnyoteiriritun5() {
        return zrnyoteiriritun5;
    }

    public void setZrnyoteiriritun5(BizNumber pZrnyoteiriritun5) {
        zrnyoteiriritun5 = pZrnyoteiriritun5;
    }

    private BizNumber zrnyoteiriritun5x2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X2)
    public BizNumber getZrnyoteiriritun5x2() {
        return zrnyoteiriritun5x2;
    }

    public void setZrnyoteiriritun5x2(BizNumber pZrnyoteiriritun5x2) {
        zrnyoteiriritun5x2 = pZrnyoteiriritun5x2;
    }

    private BizNumber zrnyoteiriritun5x3;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X3)
    public BizNumber getZrnyoteiriritun5x3() {
        return zrnyoteiriritun5x3;
    }

    public void setZrnyoteiriritun5x3(BizNumber pZrnyoteiriritun5x3) {
        zrnyoteiriritun5x3 = pZrnyoteiriritun5x3;
    }

    private BizNumber zrnyoteiriritun5x4;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X4)
    public BizNumber getZrnyoteiriritun5x4() {
        return zrnyoteiriritun5x4;
    }

    public void setZrnyoteiriritun5x4(BizNumber pZrnyoteiriritun5x4) {
        zrnyoteiriritun5x4 = pZrnyoteiriritun5x4;
    }

    private BizNumber zrnyoteiriritun5x5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X5)
    public BizNumber getZrnyoteiriritun5x5() {
        return zrnyoteiriritun5x5;
    }

    public void setZrnyoteiriritun5x5(BizNumber pZrnyoteiriritun5x5) {
        zrnyoteiriritun5x5 = pZrnyoteiriritun5x5;
    }

    private BizNumber zrnyoteiriritun5x6;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X6)
    public BizNumber getZrnyoteiriritun5x6() {
        return zrnyoteiriritun5x6;
    }

    public void setZrnyoteiriritun5x6(BizNumber pZrnyoteiriritun5x6) {
        zrnyoteiriritun5x6 = pZrnyoteiriritun5x6;
    }

    private BizNumber zrnyoteiriritun5x7;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X7)
    public BizNumber getZrnyoteiriritun5x7() {
        return zrnyoteiriritun5x7;
    }

    public void setZrnyoteiriritun5x7(BizNumber pZrnyoteiriritun5x7) {
        zrnyoteiriritun5x7 = pZrnyoteiriritun5x7;
    }

    private BizNumber zrnyoteiriritun5x8;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X8)
    public BizNumber getZrnyoteiriritun5x8() {
        return zrnyoteiriritun5x8;
    }

    public void setZrnyoteiriritun5x8(BizNumber pZrnyoteiriritun5x8) {
        zrnyoteiriritun5x8 = pZrnyoteiriritun5x8;
    }

    private BizNumber zrnyoteiriritun5x9;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X9)
    public BizNumber getZrnyoteiriritun5x9() {
        return zrnyoteiriritun5x9;
    }

    public void setZrnyoteiriritun5x9(BizNumber pZrnyoteiriritun5x9) {
        zrnyoteiriritun5x9 = pZrnyoteiriritun5x9;
    }

    private BizNumber zrnyoteiriritun5x10;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X10)
    public BizNumber getZrnyoteiriritun5x10() {
        return zrnyoteiriritun5x10;
    }

    public void setZrnyoteiriritun5x10(BizNumber pZrnyoteiriritun5x10) {
        zrnyoteiriritun5x10 = pZrnyoteiriritun5x10;
    }

    private BizNumber zrnyoteiriritun5x11;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X11)
    public BizNumber getZrnyoteiriritun5x11() {
        return zrnyoteiriritun5x11;
    }

    public void setZrnyoteiriritun5x11(BizNumber pZrnyoteiriritun5x11) {
        zrnyoteiriritun5x11 = pZrnyoteiriritun5x11;
    }

    private BizNumber zrnyoteiriritun5x12;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X12)
    public BizNumber getZrnyoteiriritun5x12() {
        return zrnyoteiriritun5x12;
    }

    public void setZrnyoteiriritun5x12(BizNumber pZrnyoteiriritun5x12) {
        zrnyoteiriritun5x12 = pZrnyoteiriritun5x12;
    }

    private BizNumber zrnyoteiriritun5x13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X13)
    public BizNumber getZrnyoteiriritun5x13() {
        return zrnyoteiriritun5x13;
    }

    public void setZrnyoteiriritun5x13(BizNumber pZrnyoteiriritun5x13) {
        zrnyoteiriritun5x13 = pZrnyoteiriritun5x13;
    }

    private BizNumber zrnyoteiriritun5x14;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X14)
    public BizNumber getZrnyoteiriritun5x14() {
        return zrnyoteiriritun5x14;
    }

    public void setZrnyoteiriritun5x14(BizNumber pZrnyoteiriritun5x14) {
        zrnyoteiriritun5x14 = pZrnyoteiriritun5x14;
    }

    private BizNumber zrnyoteiriritun5x15;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X15)
    public BizNumber getZrnyoteiriritun5x15() {
        return zrnyoteiriritun5x15;
    }

    public void setZrnyoteiriritun5x15(BizNumber pZrnyoteiriritun5x15) {
        zrnyoteiriritun5x15 = pZrnyoteiriritun5x15;
    }

    private BizNumber zrnyoteiriritun5x16;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOTEIRIRITUN5X16)
    public BizNumber getZrnyoteiriritun5x16() {
        return zrnyoteiriritun5x16;
    }

    public void setZrnyoteiriritun5x16(BizNumber pZrnyoteiriritun5x16) {
        zrnyoteiriritun5x16 = pZrnyoteiriritun5x16;
    }

    private String zrnyobiv6;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOBIV6)
    public String getZrnyobiv6() {
        return zrnyobiv6;
    }

    public void setZrnyobiv6(String pZrnyobiv6) {
        zrnyobiv6 = pZrnyobiv6;
    }

    private Long zrnsyukeiyakup;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSYUKEIYAKUP)
    public Long getZrnsyukeiyakup() {
        return zrnsyukeiyakup;
    }

    public void setZrnsyukeiyakup(Long pZrnsyukeiyakup) {
        zrnsyukeiyakup = pZrnsyukeiyakup;
    }

    private Long zrnsyuptumitatekin;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSYUPTUMITATEKIN)
    public Long getZrnsyuptumitatekin() {
        return zrnsyuptumitatekin;
    }

    public void setZrnsyuptumitatekin(Long pZrnsyuptumitatekin) {
        zrnsyuptumitatekin = pZrnsyuptumitatekin;
    }

    private Long zrnptumitatekin;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKIN)
    public Long getZrnptumitatekin() {
        return zrnptumitatekin;
    }

    public void setZrnptumitatekin(Long pZrnptumitatekin) {
        zrnptumitatekin = pZrnptumitatekin;
    }

    private Long zrnptumitatekinx2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX2)
    public Long getZrnptumitatekinx2() {
        return zrnptumitatekinx2;
    }

    public void setZrnptumitatekinx2(Long pZrnptumitatekinx2) {
        zrnptumitatekinx2 = pZrnptumitatekinx2;
    }

    private Long zrnptumitatekinx3;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX3)
    public Long getZrnptumitatekinx3() {
        return zrnptumitatekinx3;
    }

    public void setZrnptumitatekinx3(Long pZrnptumitatekinx3) {
        zrnptumitatekinx3 = pZrnptumitatekinx3;
    }

    private Long zrnptumitatekinx4;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX4)
    public Long getZrnptumitatekinx4() {
        return zrnptumitatekinx4;
    }

    public void setZrnptumitatekinx4(Long pZrnptumitatekinx4) {
        zrnptumitatekinx4 = pZrnptumitatekinx4;
    }

    private Long zrnptumitatekinx5;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX5)
    public Long getZrnptumitatekinx5() {
        return zrnptumitatekinx5;
    }

    public void setZrnptumitatekinx5(Long pZrnptumitatekinx5) {
        zrnptumitatekinx5 = pZrnptumitatekinx5;
    }

    private Long zrnptumitatekinx6;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX6)
    public Long getZrnptumitatekinx6() {
        return zrnptumitatekinx6;
    }

    public void setZrnptumitatekinx6(Long pZrnptumitatekinx6) {
        zrnptumitatekinx6 = pZrnptumitatekinx6;
    }

    private Long zrnptumitatekinx7;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX7)
    public Long getZrnptumitatekinx7() {
        return zrnptumitatekinx7;
    }

    public void setZrnptumitatekinx7(Long pZrnptumitatekinx7) {
        zrnptumitatekinx7 = pZrnptumitatekinx7;
    }

    private Long zrnptumitatekinx8;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX8)
    public Long getZrnptumitatekinx8() {
        return zrnptumitatekinx8;
    }

    public void setZrnptumitatekinx8(Long pZrnptumitatekinx8) {
        zrnptumitatekinx8 = pZrnptumitatekinx8;
    }

    private Long zrnptumitatekinx9;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX9)
    public Long getZrnptumitatekinx9() {
        return zrnptumitatekinx9;
    }

    public void setZrnptumitatekinx9(Long pZrnptumitatekinx9) {
        zrnptumitatekinx9 = pZrnptumitatekinx9;
    }

    private Long zrnptumitatekinx10;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX10)
    public Long getZrnptumitatekinx10() {
        return zrnptumitatekinx10;
    }

    public void setZrnptumitatekinx10(Long pZrnptumitatekinx10) {
        zrnptumitatekinx10 = pZrnptumitatekinx10;
    }

    private Long zrnptumitatekinx11;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX11)
    public Long getZrnptumitatekinx11() {
        return zrnptumitatekinx11;
    }

    public void setZrnptumitatekinx11(Long pZrnptumitatekinx11) {
        zrnptumitatekinx11 = pZrnptumitatekinx11;
    }

    private Long zrnptumitatekinx12;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX12)
    public Long getZrnptumitatekinx12() {
        return zrnptumitatekinx12;
    }

    public void setZrnptumitatekinx12(Long pZrnptumitatekinx12) {
        zrnptumitatekinx12 = pZrnptumitatekinx12;
    }

    private Long zrnptumitatekinx13;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX13)
    public Long getZrnptumitatekinx13() {
        return zrnptumitatekinx13;
    }

    public void setZrnptumitatekinx13(Long pZrnptumitatekinx13) {
        zrnptumitatekinx13 = pZrnptumitatekinx13;
    }

    private Long zrnptumitatekinx14;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX14)
    public Long getZrnptumitatekinx14() {
        return zrnptumitatekinx14;
    }

    public void setZrnptumitatekinx14(Long pZrnptumitatekinx14) {
        zrnptumitatekinx14 = pZrnptumitatekinx14;
    }

    private Long zrnptumitatekinx15;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX15)
    public Long getZrnptumitatekinx15() {
        return zrnptumitatekinx15;
    }

    public void setZrnptumitatekinx15(Long pZrnptumitatekinx15) {
        zrnptumitatekinx15 = pZrnptumitatekinx15;
    }

    private Long zrnptumitatekinx16;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNPTUMITATEKINX16)
    public Long getZrnptumitatekinx16() {
        return zrnptumitatekinx16;
    }

    public void setZrnptumitatekinx16(Long pZrnptumitatekinx16) {
        zrnptumitatekinx16 = pZrnptumitatekinx16;
    }

    private Long zrngaikadatejyuutoup;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUP)
    public Long getZrngaikadatejyuutoup() {
        return zrngaikadatejyuutoup;
    }

    public void setZrngaikadatejyuutoup(Long pZrngaikadatejyuutoup) {
        zrngaikadatejyuutoup = pZrngaikadatejyuutoup;
    }

    private Long zrngaikadatejyuutoupx2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX2)
    public Long getZrngaikadatejyuutoupx2() {
        return zrngaikadatejyuutoupx2;
    }

    public void setZrngaikadatejyuutoupx2(Long pZrngaikadatejyuutoupx2) {
        zrngaikadatejyuutoupx2 = pZrngaikadatejyuutoupx2;
    }

    private Long zrngaikadatejyuutoupx3;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX3)
    public Long getZrngaikadatejyuutoupx3() {
        return zrngaikadatejyuutoupx3;
    }

    public void setZrngaikadatejyuutoupx3(Long pZrngaikadatejyuutoupx3) {
        zrngaikadatejyuutoupx3 = pZrngaikadatejyuutoupx3;
    }

    private Long zrngaikadatejyuutoupx4;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX4)
    public Long getZrngaikadatejyuutoupx4() {
        return zrngaikadatejyuutoupx4;
    }

    public void setZrngaikadatejyuutoupx4(Long pZrngaikadatejyuutoupx4) {
        zrngaikadatejyuutoupx4 = pZrngaikadatejyuutoupx4;
    }

    private Long zrngaikadatejyuutoupx5;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX5)
    public Long getZrngaikadatejyuutoupx5() {
        return zrngaikadatejyuutoupx5;
    }

    public void setZrngaikadatejyuutoupx5(Long pZrngaikadatejyuutoupx5) {
        zrngaikadatejyuutoupx5 = pZrngaikadatejyuutoupx5;
    }

    private Long zrngaikadatejyuutoupx6;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX6)
    public Long getZrngaikadatejyuutoupx6() {
        return zrngaikadatejyuutoupx6;
    }

    public void setZrngaikadatejyuutoupx6(Long pZrngaikadatejyuutoupx6) {
        zrngaikadatejyuutoupx6 = pZrngaikadatejyuutoupx6;
    }

    private Long zrngaikadatejyuutoupx7;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX7)
    public Long getZrngaikadatejyuutoupx7() {
        return zrngaikadatejyuutoupx7;
    }

    public void setZrngaikadatejyuutoupx7(Long pZrngaikadatejyuutoupx7) {
        zrngaikadatejyuutoupx7 = pZrngaikadatejyuutoupx7;
    }

    private Long zrngaikadatejyuutoupx8;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX8)
    public Long getZrngaikadatejyuutoupx8() {
        return zrngaikadatejyuutoupx8;
    }

    public void setZrngaikadatejyuutoupx8(Long pZrngaikadatejyuutoupx8) {
        zrngaikadatejyuutoupx8 = pZrngaikadatejyuutoupx8;
    }

    private Long zrngaikadatejyuutoupx9;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX9)
    public Long getZrngaikadatejyuutoupx9() {
        return zrngaikadatejyuutoupx9;
    }

    public void setZrngaikadatejyuutoupx9(Long pZrngaikadatejyuutoupx9) {
        zrngaikadatejyuutoupx9 = pZrngaikadatejyuutoupx9;
    }

    private Long zrngaikadatejyuutoupx10;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX10)
    public Long getZrngaikadatejyuutoupx10() {
        return zrngaikadatejyuutoupx10;
    }

    public void setZrngaikadatejyuutoupx10(Long pZrngaikadatejyuutoupx10) {
        zrngaikadatejyuutoupx10 = pZrngaikadatejyuutoupx10;
    }

    private Long zrngaikadatejyuutoupx11;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX11)
    public Long getZrngaikadatejyuutoupx11() {
        return zrngaikadatejyuutoupx11;
    }

    public void setZrngaikadatejyuutoupx11(Long pZrngaikadatejyuutoupx11) {
        zrngaikadatejyuutoupx11 = pZrngaikadatejyuutoupx11;
    }

    private Long zrngaikadatejyuutoupx12;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX12)
    public Long getZrngaikadatejyuutoupx12() {
        return zrngaikadatejyuutoupx12;
    }

    public void setZrngaikadatejyuutoupx12(Long pZrngaikadatejyuutoupx12) {
        zrngaikadatejyuutoupx12 = pZrngaikadatejyuutoupx12;
    }

    private Long zrngaikadatejyuutoupx13;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX13)
    public Long getZrngaikadatejyuutoupx13() {
        return zrngaikadatejyuutoupx13;
    }

    public void setZrngaikadatejyuutoupx13(Long pZrngaikadatejyuutoupx13) {
        zrngaikadatejyuutoupx13 = pZrngaikadatejyuutoupx13;
    }

    private Long zrngaikadatejyuutoupx14;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX14)
    public Long getZrngaikadatejyuutoupx14() {
        return zrngaikadatejyuutoupx14;
    }

    public void setZrngaikadatejyuutoupx14(Long pZrngaikadatejyuutoupx14) {
        zrngaikadatejyuutoupx14 = pZrngaikadatejyuutoupx14;
    }

    private Long zrngaikadatejyuutoupx15;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX15)
    public Long getZrngaikadatejyuutoupx15() {
        return zrngaikadatejyuutoupx15;
    }

    public void setZrngaikadatejyuutoupx15(Long pZrngaikadatejyuutoupx15) {
        zrngaikadatejyuutoupx15 = pZrngaikadatejyuutoupx15;
    }

    private Long zrngaikadatejyuutoupx16;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNGAIKADATEJYUUTOUPX16)
    public Long getZrngaikadatejyuutoupx16() {
        return zrngaikadatejyuutoupx16;
    }

    public void setZrngaikadatejyuutoupx16(Long pZrngaikadatejyuutoupx16) {
        zrngaikadatejyuutoupx16 = pZrngaikadatejyuutoupx16;
    }

    private String zrnsykykkitmttvkeisanym1;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSYKYKKITMTTVKEISANYM1)
    public String getZrnsykykkitmttvkeisanym1() {
        return zrnsykykkitmttvkeisanym1;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsykykkitmttvkeisanym1(String pZrnsykykkitmttvkeisanym1) {
        zrnsykykkitmttvkeisanym1 = pZrnsykykkitmttvkeisanym1;
    }

    private Long zrnsykykkitmttv1;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSYKYKKITMTTV1)
    public Long getZrnsykykkitmttv1() {
        return zrnsykykkitmttv1;
    }

    public void setZrnsykykkitmttv1(Long pZrnsykykkitmttv1) {
        zrnsykykkitmttv1 = pZrnsykykkitmttv1;
    }

    private String zrnsykykkitmttvkeisanym2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSYKYKKITMTTVKEISANYM2)
    public String getZrnsykykkitmttvkeisanym2() {
        return zrnsykykkitmttvkeisanym2;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsykykkitmttvkeisanym2(String pZrnsykykkitmttvkeisanym2) {
        zrnsykykkitmttvkeisanym2 = pZrnsykykkitmttvkeisanym2;
    }

    private Long zrnsykykkitmttv2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSYKYKKITMTTV2)
    public Long getZrnsykykkitmttv2() {
        return zrnsykykkitmttv2;
    }

    public void setZrnsykykkitmttv2(Long pZrnsykykkitmttv2) {
        zrnsykykkitmttv2 = pZrnsykykkitmttv2;
    }

    private Long zrnrrthnduhknvkisovkisnyu1;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNRRTHNDUHKNVKISOVKISNYU1)
    public Long getZrnrrthnduhknvkisovkisnyu1() {
        return zrnrrthnduhknvkisovkisnyu1;
    }

    public void setZrnrrthnduhknvkisovkisnyu1(Long pZrnrrthnduhknvkisovkisnyu1) {
        zrnrrthnduhknvkisovkisnyu1 = pZrnrrthnduhknvkisovkisnyu1;
    }

    private Long zrnrrthnduhknvkisovkisnyu2;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNRRTHNDUHKNVKISOVKISNYU2)
    public Long getZrnrrthnduhknvkisovkisnyu2() {
        return zrnrrthnduhknvkisovkisnyu2;
    }

    public void setZrnrrthnduhknvkisovkisnyu2(Long pZrnrrthnduhknvkisovkisnyu2) {
        zrnrrthnduhknvkisovkisnyu2 = pZrnrrthnduhknvkisovkisnyu2;
    }

    private Long zrnrrthnduhknvkisovkisnyu3;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNRRTHNDUHKNVKISOVKISNYU3)
    public Long getZrnrrthnduhknvkisovkisnyu3() {
        return zrnrrthnduhknvkisovkisnyu3;
    }

    public void setZrnrrthnduhknvkisovkisnyu3(Long pZrnrrthnduhknvkisovkisnyu3) {
        zrnrrthnduhknvkisovkisnyu3 = pZrnrrthnduhknvkisovkisnyu3;
    }

    private Long zrnrrthnduhknvkisovkisnyu4;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNRRTHNDUHKNVKISOVKISNYU4)
    public Long getZrnrrthnduhknvkisovkisnyu4() {
        return zrnrrthnduhknvkisovkisnyu4;
    }

    public void setZrnrrthnduhknvkisovkisnyu4(Long pZrnrrthnduhknvkisovkisnyu4) {
        zrnrrthnduhknvkisovkisnyu4 = pZrnrrthnduhknvkisovkisnyu4;
    }

    private Long zrnrrthnduhknvkiso;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNRRTHNDUHKNVKISO)
    public Long getZrnrrthnduhknvkiso() {
        return zrnrrthnduhknvkiso;
    }

    public void setZrnrrthnduhknvkiso(Long pZrnrrthnduhknvkiso) {
        zrnrrthnduhknvkiso = pZrnrrthnduhknvkiso;
    }

    private String zrnsuuriyouyobin9;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNSUURIYOUYOBIN9)
    public String getZrnsuuriyouyobin9() {
        return zrnsuuriyouyobin9;
    }

    @Padding(mode = "left", padChar = '0', length = 9)
    public void setZrnsuuriyouyobin9(String pZrnsuuriyouyobin9) {
        zrnsuuriyouyobin9 = pZrnsuuriyouyobin9;
    }

    private String zrnyobiv14;

    @Column(name=GenZT_RrtHndugtHknVKnsyuyuRn.ZRNYOBIV14)
    public String getZrnyobiv14() {
        return zrnyobiv14;
    }

    public void setZrnyobiv14(String pZrnyobiv14) {
        zrnyobiv14 = pZrnyobiv14;
    }
}