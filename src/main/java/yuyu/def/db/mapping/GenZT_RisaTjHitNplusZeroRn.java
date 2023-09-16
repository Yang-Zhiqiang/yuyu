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
import yuyu.def.db.entity.ZT_RisaTjHitNplusZeroRn;
import yuyu.def.db.id.PKZT_RisaTjHitNplusZeroRn;
import yuyu.def.db.meta.GenQZT_RisaTjHitNplusZeroRn;
import yuyu.def.db.meta.QZT_RisaTjHitNplusZeroRn;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ＋０）テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_RisaTjHitNplusZeroRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RisaTjHitNplusZeroRn}</td><td colspan="3">利差のみ通常配当所要額Ｆ（Ｎ＋０）テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_RisaTjHitNplusZeroRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyuukourecordlength zrnyuukourecordlength}</td><td>（連携用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrdwarea zrnrdwarea}</td><td>（連携用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnerrkbnv1 zrnerrkbnv1}</td><td>（連携用）エラー区分Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnratekbn zrnratekbn}</td><td>（連携用）レート区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuurisyuruicd zrnsuurisyuruicd}</td><td>（連携用）数理種類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2 zrnyobiv2}</td><td>（連携用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentkbn zrnkbnkeiriyousegmentkbn}</td><td>（連携用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyourgnbnskkbn zrnkbnkeiriyourgnbnskkbn}</td><td>（連携用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x1 zrnhokensyuruikigouyobi1x1}</td><td>（連携用）保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x2 zrnhokensyuruikigouyobi1x2}</td><td>（連携用）保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x3 zrnhokensyuruikigouyobi1x3}</td><td>（連携用）保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x4 zrnhokensyuruikigouyobi1x4}</td><td>（連携用）保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x5 zrnhokensyuruikigouyobi1x5}</td><td>（連携用）保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x6 zrnhokensyuruikigouyobi1x6}</td><td>（連携用）保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x7 zrnhokensyuruikigouyobi1x7}</td><td>（連携用）保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x8 zrnhokensyuruikigouyobi1x8}</td><td>（連携用）保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x9 zrnhokensyuruikigouyobi1x9}</td><td>（連携用）保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x10 zrnhokensyuruikigouyobi1x10}</td><td>（連携用）保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x11 zrnhokensyuruikigouyobi1x11}</td><td>（連携用）保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x12 zrnhokensyuruikigouyobi1x12}</td><td>（連携用）保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x13 zrnhokensyuruikigouyobi1x13}</td><td>（連携用）保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x14 zrnhokensyuruikigouyobi1x14}</td><td>（連携用）保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x15 zrnhokensyuruikigouyobi1x15}</td><td>（連携用）保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x1 zrnhokensyuruikigouyobi2x1}</td><td>（連携用）保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x2 zrnhokensyuruikigouyobi2x2}</td><td>（連携用）保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x3 zrnhokensyuruikigouyobi2x3}</td><td>（連携用）保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x4 zrnhokensyuruikigouyobi2x4}</td><td>（連携用）保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x5 zrnhokensyuruikigouyobi2x5}</td><td>（連携用）保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x6 zrnhokensyuruikigouyobi2x6}</td><td>（連携用）保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x7 zrnhokensyuruikigouyobi2x7}</td><td>（連携用）保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x8 zrnhokensyuruikigouyobi2x8}</td><td>（連携用）保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x9 zrnhokensyuruikigouyobi2x9}</td><td>（連携用）保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x10 zrnhokensyuruikigouyobi2x10}</td><td>（連携用）保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x1 zrnhokensyuruikigouyobi3x1}</td><td>（連携用）保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x2 zrnhokensyuruikigouyobi3x2}</td><td>（連携用）保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x3 zrnhokensyuruikigouyobi3x3}</td><td>（連携用）保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x4 zrnhokensyuruikigouyobi3x4}</td><td>（連携用）保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x5 zrnhokensyuruikigouyobi3x5}</td><td>（連携用）保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x6 zrnhokensyuruikigouyobi3x6}</td><td>（連携用）保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x7 zrnhokensyuruikigouyobi3x7}</td><td>（連携用）保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x8 zrnhokensyuruikigouyobi3x8}</td><td>（連携用）保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x9 zrnhokensyuruikigouyobi3x9}</td><td>（連携用）保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x10 zrnhokensyuruikigouyobi3x10}</td><td>（連携用）保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnharaikatakbn zrnharaikatakbn}</td><td>（連携用）払方区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakunendo zrnkeiyakunendo}</td><td>（連携用）契約年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakum zrnkeiyakum}</td><td>（連携用）契約月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyaagev2 zrnhihokensyaagev2}</td><td>（連携用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrn5nenmeoutoubikbn zrn5nenmeoutoubikbn}</td><td>（連携用）５年目応当日区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeijyouym zrnkeijyouym}</td><td>（連携用）計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuoutoubikbn zrnkeiyakuoutoubikbn}</td><td>（連携用）契約応当日区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1 zrnsuuriyouyobin1}</td><td>（連携用）数理用予備項目Ｎ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin11 zrnsuuriyouyobin11}</td><td>（連携用）数理用予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisitutokuyakuhukasuu zrnsaisitutokuyakuhukasuu}</td><td>（連携用）災疾特約付加数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkihons zrnkihons}</td><td>（連携用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsibous zrnsibous}</td><td>（連携用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntounendmtwrhrgkruikeigk zrntounendmtwrhrgkruikeigk}</td><td>（連携用）当年度末割振額累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnwarihurigakurisoku1 zrnwarihurigakurisoku1}</td><td>（連携用）割振額利息１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnwarihurigakurisoku2 zrnwarihurigakurisoku2}</td><td>（連携用）割振額利息２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyokunendosyoyougakuyou zrnyokunendosyoyougakuyou}</td><td>（連携用）翌年度所要額用</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyokuyokunendosyoyougkyou zrnyokuyokunendosyoyougkyou}</td><td>（連携用）翌々年度所要額用</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyuukoutyuusyoyougaku zrnyuukoutyuusyoyougaku}</td><td>（連携用）有効中所要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyoumetuyousyoyougaku1 zrnsyoumetuyousyoyougaku1}</td><td>（連携用）消滅用所要額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyoumetuyousyoyougaku2 zrnsyoumetuyousyoyougaku2}</td><td>（連携用）消滅用所要額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanyousyoyougaku1 zrntenkanyousyoyougaku1}</td><td>（連携用）転換用所要額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanyousyoyougaku2 zrntenkanyousyoyougaku2}</td><td>（連携用）転換用所要額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyutuujyoudsyoyougk1 zrntnknyutuujyoudsyoyougk1}</td><td>（連携用）転換用通常Ｄ所要額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyutuujyoudsyoyougk2 zrntnknyutuujyoudsyoyougk2}</td><td>（連携用）転換用通常Ｄ所要額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyuhrkbbnksyoyougk1 zrntnknyuhrkbbnksyoyougk1}</td><td>（連携用）転換用払込部分Ｋ所要額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyuhrkbbnksyoyougk2 zrntnknyuhrkbbnksyoyougk2}</td><td>（連携用）転換用払込部分Ｋ所要額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyuhrkbbnknnknsnp1 zrntnknyuhrkbbnknnknsnp1}</td><td>（連携用）転換用払込部分Ｋ年換算Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyuhrkbbnknnknsnp2 zrntnknyuhrkbbnknnknsnp2}</td><td>（連携用）転換用払込部分Ｋ年換算Ｐ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyutnknhktgksyoyougk1 zrntnknyutnknhktgksyoyougk1}</td><td>（連携用）転換用転換引継Ｋ所要額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyutnknhktgksyoyougk2 zrntnknyutnknhktgksyoyougk2}</td><td>（連携用）転換用転換引継Ｋ所要額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyutnknhktgknnknsnp1 zrntnknyutnknhktgknnknsnp1}</td><td>（連携用）転換用転換引継Ｋ年換算Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyutnknhktgknnknsnp2 zrntnknyutnknhktgknnknsnp2}</td><td>（連携用）転換用転換引継Ｋ年換算Ｐ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyusaisituksyoyougk1 zrntnknyusaisituksyoyougk1}</td><td>（連携用）転換用災疾Ｋ所要額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyusaisituksyoyougk2 zrntnknyusaisituksyoyougk2}</td><td>（連携用）転換用災疾Ｋ所要額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyusaisitukkyhntgk1 zrntnknyusaisitukkyhntgk1}</td><td>（連携用）転換用災疾Ｋ給付日額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyusaisitukkyhntgk2 zrntnknyusaisitukkyhntgk2}</td><td>（連携用）転換用災疾Ｋ給付日額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhrkbbnkdsyoyougk zrnhrkbbnkdsyoyougk}</td><td>（連携用）払込部分ＫＤ所要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhrkbbnkdtisyunnknsnp zrnhrkbbnkdtisyunnknsnp}</td><td>（連携用）払込部分ＫＤ対象年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntusangohrkbbnkappad zrntusangohrkbbnkappad}</td><td>（連携用）通算後払込部分カッパーＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknhktgkdsyoyougk zrntnknhktgkdsyoyougk}</td><td>（連携用）転換引継ＫＤ所要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknhktgkdtisyunenknsnp zrntnknhktgkdtisyunenknsnp}</td><td>（連携用）転換引継ＫＤ対象年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntusangotnknhktgkappad zrntusangotnknhktgkappad}</td><td>（連携用）通算後転換引継カッパーＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntuusangohutuusiboukappad zrntuusangohutuusiboukappad}</td><td>（連携用）通算後普通死亡カッパーＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsaisitukappadsyoyougaku zrnsaisitukappadsyoyougaku}</td><td>（連携用）災疾カッパーＤ所要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntuusangosaisitukappad zrntuusangosaisitukappad}</td><td>（連携用）通算後災疾カッパーＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsistkappadtisyukyhntgk zrnsistkappadtisyukyhntgk}</td><td>（連携用）災疾カッパーＤ対象給付日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntuusangogoukeikappad zrntuusangogoukeikappad}</td><td>（連携用）通算後合計カッパーＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndtaisyouv zrndtaisyouv}</td><td>（連携用）Ｄ対象Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndaihyouyoteiriritu zrndaihyouyoteiriritu}</td><td>（連携用）代表予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrt zrnknkuzusnzyrt}</td><td>（連携用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbn zrnzyrthntiyustatuskbn}</td><td>（連携用）乗率判定用ステータス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7 zrnyobiv7}</td><td>（連携用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknyusyusistksyoyougk1 zrntnknyusyusistksyoyougk1}</td><td>（連携用）転換用主契約災疾Ｋ所要額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyusyusistksyoyougk2 zrntnknyusyusistksyoyougk2}</td><td>（連携用）転換用主契約災疾Ｋ所要額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyusyusistkkyhntgk1 zrntnknyusyusistkkyhntgk1}</td><td>（連携用）転換用主契約災疾Ｋ給付日額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknyusyusistkkyhntgk2 zrntnknyusyusistkkyhntgk2}</td><td>（連携用）転換用主契約災疾Ｋ給付日額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyusistkappadsyoyougk zrnsyusistkappadsyoyougk}</td><td>（連携用）主契約災疾カッパーＤ所要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyusistkdtisyukyhntgk zrnsyusistkdtisyukyhntgk}</td><td>（連携用）主契約災疾ＫＤ対象給付日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x8 zrnyobin11x8}</td><td>（連携用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x9 zrnyobin11x9}</td><td>（連携用）予備項目Ｎ１１＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x10 zrnyobin11x10}</td><td>（連携用）予備項目Ｎ１１＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x11 zrnyobin11x11}</td><td>（連携用）予備項目Ｎ１１＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaserate zrnkawaserate}</td><td>（連携用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaseratetekiyouymd zrnkawaseratetekiyouymd}</td><td>（連携用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujiyoteiriritu zrnkeiyakujiyoteiriritu}</td><td>（連携用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnenkdtsbujsitihsyukngk zrnenkdtsbujsitihsyukngk}</td><td>（連携用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntumitatekin zrntumitatekin}</td><td>（連携用）積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkiharaikomip zrnkiharaikomip}</td><td>（連携用）既払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatesyukeiyakup zrngaikadatesyukeiyakup}</td><td>（連携用）外貨建主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksjitirttumitatekin zrnnksjitirttumitatekin}</td><td>（連携用）年金開始時定率部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsisuurentumitatekin zrnsisuurentumitatekin}</td><td>（連携用）指数連動部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakup zrnsyukeiyakup}</td><td>（連携用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiririturironbase zrnyoteiririturironbase}</td><td>（連携用）予定利率（理論ベース）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrngkdtyknndsyoyougakuyou zrngkdtyknndsyoyougakuyou}</td><td>（連携用）外貨建翌年度所要額用</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngkdtykyknndsyoyougakuyou zrngkdtykyknndsyoyougakuyou}</td><td>（連携用）外貨建翌々年度所要額用</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndkeisanjikwsrate zrndkeisanjikwsrate}</td><td>（連携用）Ｄ計算時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrndkeisanjikwsratetkyymd zrndkeisanjikwsratetkyymd}</td><td>（連携用）Ｄ計算時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6 zrnyobiv6}</td><td>（連携用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6x2 zrnyobiv6x2}</td><td>（連携用）予備項目Ｖ６＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6x3 zrnyobiv6x3}</td><td>（連携用）予備項目Ｖ６＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrdai1hknkkn zrnsrdai1hknkkn}</td><td>（連携用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv5 zrnyobiv5}</td><td>（連携用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120 zrntokuyakukoumokuv120}</td><td>（連携用）特約項目Ｖ１２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x2 zrntokuyakukoumokuv120x2}</td><td>（連携用）特約項目Ｖ１２０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x3 zrntokuyakukoumokuv120x3}</td><td>（連携用）特約項目Ｖ１２０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x4 zrntokuyakukoumokuv120x4}</td><td>（連携用）特約項目Ｖ１２０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x5 zrntokuyakukoumokuv120x5}</td><td>（連携用）特約項目Ｖ１２０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x6 zrntokuyakukoumokuv120x6}</td><td>（連携用）特約項目Ｖ１２０＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x7 zrntokuyakukoumokuv120x7}</td><td>（連携用）特約項目Ｖ１２０＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x8 zrntokuyakukoumokuv120x8}</td><td>（連携用）特約項目Ｖ１２０＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x9 zrntokuyakukoumokuv120x9}</td><td>（連携用）特約項目Ｖ１２０＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x10 zrntokuyakukoumokuv120x10}</td><td>（連携用）特約項目Ｖ１２０＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x11 zrntokuyakukoumokuv120x11}</td><td>（連携用）特約項目Ｖ１２０＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x12 zrntokuyakukoumokuv120x12}</td><td>（連携用）特約項目Ｖ１２０＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x13 zrntokuyakukoumokuv120x13}</td><td>（連携用）特約項目Ｖ１２０＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x14 zrntokuyakukoumokuv120x14}</td><td>（連携用）特約項目Ｖ１２０＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x15 zrntokuyakukoumokuv120x15}</td><td>（連携用）特約項目Ｖ１２０＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x16 zrntokuyakukoumokuv120x16}</td><td>（連携用）特約項目Ｖ１２０＿１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x17 zrntokuyakukoumokuv120x17}</td><td>（連携用）特約項目Ｖ１２０＿１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x18 zrntokuyakukoumokuv120x18}</td><td>（連携用）特約項目Ｖ１２０＿１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x19 zrntokuyakukoumokuv120x19}</td><td>（連携用）特約項目Ｖ１２０＿１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x20 zrntokuyakukoumokuv120x20}</td><td>（連携用）特約項目Ｖ１２０＿２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x21 zrntokuyakukoumokuv120x21}</td><td>（連携用）特約項目Ｖ１２０＿２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x22 zrntokuyakukoumokuv120x22}</td><td>（連携用）特約項目Ｖ１２０＿２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x23 zrntokuyakukoumokuv120x23}</td><td>（連携用）特約項目Ｖ１２０＿２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x24 zrntokuyakukoumokuv120x24}</td><td>（連携用）特約項目Ｖ１２０＿２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x25 zrntokuyakukoumokuv120x25}</td><td>（連携用）特約項目Ｖ１２０＿２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x26 zrntokuyakukoumokuv120x26}</td><td>（連携用）特約項目Ｖ１２０＿２６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x27 zrntokuyakukoumokuv120x27}</td><td>（連携用）特約項目Ｖ１２０＿２７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x28 zrntokuyakukoumokuv120x28}</td><td>（連携用）特約項目Ｖ１２０＿２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x29 zrntokuyakukoumokuv120x29}</td><td>（連携用）特約項目Ｖ１２０＿２９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x30 zrntokuyakukoumokuv120x30}</td><td>（連携用）特約項目Ｖ１２０＿３０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x31 zrntokuyakukoumokuv120x31}</td><td>（連携用）特約項目Ｖ１２０＿３１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x32 zrntokuyakukoumokuv120x32}</td><td>（連携用）特約項目Ｖ１２０＿３２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x33 zrntokuyakukoumokuv120x33}</td><td>（連携用）特約項目Ｖ１２０＿３３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x34 zrntokuyakukoumokuv120x34}</td><td>（連携用）特約項目Ｖ１２０＿３４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x35 zrntokuyakukoumokuv120x35}</td><td>（連携用）特約項目Ｖ１２０＿３５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x36 zrntokuyakukoumokuv120x36}</td><td>（連携用）特約項目Ｖ１２０＿３６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x37 zrntokuyakukoumokuv120x37}</td><td>（連携用）特約項目Ｖ１２０＿３７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x38 zrntokuyakukoumokuv120x38}</td><td>（連携用）特約項目Ｖ１２０＿３８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x39 zrntokuyakukoumokuv120x39}</td><td>（連携用）特約項目Ｖ１２０＿３９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv120x40 zrntokuyakukoumokuv120x40}</td><td>（連携用）特約項目Ｖ１２０＿４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_RisaTjHitNplusZeroRn
 * @see     PKZT_RisaTjHitNplusZeroRn
 * @see     QZT_RisaTjHitNplusZeroRn
 * @see     GenQZT_RisaTjHitNplusZeroRn
 */
@MappedSuperclass
@Table(name=GenZT_RisaTjHitNplusZeroRn.TABLE_NAME)
@IdClass(value=PKZT_RisaTjHitNplusZeroRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_RisaTjHitNplusZeroRn extends AbstractExDBEntityForZDB<ZT_RisaTjHitNplusZeroRn, PKZT_RisaTjHitNplusZeroRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_RisaTjHitNplusZeroRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYUUKOURECORDLENGTH    = "zrnyuukourecordlength";
    public static final String ZRNRDWAREA               = "zrnrdwarea";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNERRKBNV1              = "zrnerrkbnv1";
    public static final String ZRNRATEKBN               = "zrnratekbn";
    public static final String ZRNSUURISYURUICD         = "zrnsuurisyuruicd";
    public static final String ZRNYOBIV2                = "zrnyobiv2";
    public static final String ZRNKBNKEIRIYOUSEGMENTKBN = "zrnkbnkeiriyousegmentkbn";
    public static final String ZRNKBNKEIRIYOURGNBNSKKBN = "zrnkbnkeiriyourgnbnskkbn";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X1 = "zrnhokensyuruikigouyobi1x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X2 = "zrnhokensyuruikigouyobi1x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X3 = "zrnhokensyuruikigouyobi1x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X4 = "zrnhokensyuruikigouyobi1x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X5 = "zrnhokensyuruikigouyobi1x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X6 = "zrnhokensyuruikigouyobi1x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X7 = "zrnhokensyuruikigouyobi1x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X8 = "zrnhokensyuruikigouyobi1x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X9 = "zrnhokensyuruikigouyobi1x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X10 = "zrnhokensyuruikigouyobi1x10";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X11 = "zrnhokensyuruikigouyobi1x11";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X12 = "zrnhokensyuruikigouyobi1x12";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X13 = "zrnhokensyuruikigouyobi1x13";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X14 = "zrnhokensyuruikigouyobi1x14";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X15 = "zrnhokensyuruikigouyobi1x15";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X1 = "zrnhokensyuruikigouyobi2x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X2 = "zrnhokensyuruikigouyobi2x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X3 = "zrnhokensyuruikigouyobi2x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X4 = "zrnhokensyuruikigouyobi2x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X5 = "zrnhokensyuruikigouyobi2x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X6 = "zrnhokensyuruikigouyobi2x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X7 = "zrnhokensyuruikigouyobi2x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X8 = "zrnhokensyuruikigouyobi2x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X9 = "zrnhokensyuruikigouyobi2x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X10 = "zrnhokensyuruikigouyobi2x10";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X1 = "zrnhokensyuruikigouyobi3x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X2 = "zrnhokensyuruikigouyobi3x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X3 = "zrnhokensyuruikigouyobi3x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X4 = "zrnhokensyuruikigouyobi3x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X5 = "zrnhokensyuruikigouyobi3x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X6 = "zrnhokensyuruikigouyobi3x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X7 = "zrnhokensyuruikigouyobi3x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X8 = "zrnhokensyuruikigouyobi3x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X9 = "zrnhokensyuruikigouyobi3x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X10 = "zrnhokensyuruikigouyobi3x10";
    public static final String ZRNHARAIKATAKBN          = "zrnharaikatakbn";
    public static final String ZRNKEIYAKUNENDO          = "zrnkeiyakunendo";
    public static final String ZRNKEIYAKUM              = "zrnkeiyakum";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHIHOKENSYAAGEV2       = "zrnhihokensyaagev2";
    public static final String ZRN5NENMEOUTOUBIKBN      = "zrn5nenmeoutoubikbn";
    public static final String ZRNKEIJYOUYM             = "zrnkeijyouym";
    public static final String ZRNKEIYAKUOUTOUBIKBN     = "zrnkeiyakuoutoubikbn";
    public static final String ZRNSUURIYOUYOBIN1        = "zrnsuuriyouyobin1";
    public static final String ZRNSUURIYOUYOBIN11       = "zrnsuuriyouyobin11";
    public static final String ZRNSAISITUTOKUYAKUHUKASUU = "zrnsaisitutokuyakuhukasuu";
    public static final String ZRNKIHONS                = "zrnkihons";
    public static final String ZRNSIBOUS                = "zrnsibous";
    public static final String ZRNTOUNENDMTWRHRGKRUIKEIGK = "zrntounendmtwrhrgkruikeigk";
    public static final String ZRNWARIHURIGAKURISOKU1   = "zrnwarihurigakurisoku1";
    public static final String ZRNWARIHURIGAKURISOKU2   = "zrnwarihurigakurisoku2";
    public static final String ZRNYOKUNENDOSYOYOUGAKUYOU = "zrnyokunendosyoyougakuyou";
    public static final String ZRNYOKUYOKUNENDOSYOYOUGKYOU = "zrnyokuyokunendosyoyougkyou";
    public static final String ZRNYUUKOUTYUUSYOYOUGAKU  = "zrnyuukoutyuusyoyougaku";
    public static final String ZRNSYOUMETUYOUSYOYOUGAKU1 = "zrnsyoumetuyousyoyougaku1";
    public static final String ZRNSYOUMETUYOUSYOYOUGAKU2 = "zrnsyoumetuyousyoyougaku2";
    public static final String ZRNTENKANYOUSYOYOUGAKU1  = "zrntenkanyousyoyougaku1";
    public static final String ZRNTENKANYOUSYOYOUGAKU2  = "zrntenkanyousyoyougaku2";
    public static final String ZRNTNKNYUTUUJYOUDSYOYOUGK1 = "zrntnknyutuujyoudsyoyougk1";
    public static final String ZRNTNKNYUTUUJYOUDSYOYOUGK2 = "zrntnknyutuujyoudsyoyougk2";
    public static final String ZRNTNKNYUHRKBBNKSYOYOUGK1 = "zrntnknyuhrkbbnksyoyougk1";
    public static final String ZRNTNKNYUHRKBBNKSYOYOUGK2 = "zrntnknyuhrkbbnksyoyougk2";
    public static final String ZRNTNKNYUHRKBBNKNNKNSNP1 = "zrntnknyuhrkbbnknnknsnp1";
    public static final String ZRNTNKNYUHRKBBNKNNKNSNP2 = "zrntnknyuhrkbbnknnknsnp2";
    public static final String ZRNTNKNYUTNKNHKTGKSYOYOUGK1 = "zrntnknyutnknhktgksyoyougk1";
    public static final String ZRNTNKNYUTNKNHKTGKSYOYOUGK2 = "zrntnknyutnknhktgksyoyougk2";
    public static final String ZRNTNKNYUTNKNHKTGKNNKNSNP1 = "zrntnknyutnknhktgknnknsnp1";
    public static final String ZRNTNKNYUTNKNHKTGKNNKNSNP2 = "zrntnknyutnknhktgknnknsnp2";
    public static final String ZRNTNKNYUSAISITUKSYOYOUGK1 = "zrntnknyusaisituksyoyougk1";
    public static final String ZRNTNKNYUSAISITUKSYOYOUGK2 = "zrntnknyusaisituksyoyougk2";
    public static final String ZRNTNKNYUSAISITUKKYHNTGK1 = "zrntnknyusaisitukkyhntgk1";
    public static final String ZRNTNKNYUSAISITUKKYHNTGK2 = "zrntnknyusaisitukkyhntgk2";
    public static final String ZRNHRKBBNKDSYOYOUGK      = "zrnhrkbbnkdsyoyougk";
    public static final String ZRNHRKBBNKDTISYUNNKNSNP  = "zrnhrkbbnkdtisyunnknsnp";
    public static final String ZRNTUSANGOHRKBBNKAPPAD   = "zrntusangohrkbbnkappad";
    public static final String ZRNTNKNHKTGKDSYOYOUGK    = "zrntnknhktgkdsyoyougk";
    public static final String ZRNTNKNHKTGKDTISYUNENKNSNP = "zrntnknhktgkdtisyunenknsnp";
    public static final String ZRNTUSANGOTNKNHKTGKAPPAD = "zrntusangotnknhktgkappad";
    public static final String ZRNTUUSANGOHUTUUSIBOUKAPPAD = "zrntuusangohutuusiboukappad";
    public static final String ZRNSAISITUKAPPADSYOYOUGAKU = "zrnsaisitukappadsyoyougaku";
    public static final String ZRNTUUSANGOSAISITUKAPPAD = "zrntuusangosaisitukappad";
    public static final String ZRNSISTKAPPADTISYUKYHNTGK = "zrnsistkappadtisyukyhntgk";
    public static final String ZRNTUUSANGOGOUKEIKAPPAD  = "zrntuusangogoukeikappad";
    public static final String ZRNDTAISYOUV             = "zrndtaisyouv";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNDAIHYOUYOTEIRIRITU    = "zrndaihyouyoteiriritu";
    public static final String ZRNKNKUZUSNZYRT          = "zrnknkuzusnzyrt";
    public static final String ZRNZYRTHNTIYUSTATUSKBN   = "zrnzyrthntiyustatuskbn";
    public static final String ZRNYOBIV7                = "zrnyobiv7";
    public static final String ZRNTNKNYUSYUSISTKSYOYOUGK1 = "zrntnknyusyusistksyoyougk1";
    public static final String ZRNTNKNYUSYUSISTKSYOYOUGK2 = "zrntnknyusyusistksyoyougk2";
    public static final String ZRNTNKNYUSYUSISTKKYHNTGK1 = "zrntnknyusyusistkkyhntgk1";
    public static final String ZRNTNKNYUSYUSISTKKYHNTGK2 = "zrntnknyusyusistkkyhntgk2";
    public static final String ZRNSYUSISTKAPPADSYOYOUGK = "zrnsyusistkappadsyoyougk";
    public static final String ZRNSYUSISTKDTISYUKYHNTGK = "zrnsyusistkdtisyukyhntgk";
    public static final String ZRNYOBIN11X8             = "zrnyobin11x8";
    public static final String ZRNYOBIN11X9             = "zrnyobin11x9";
    public static final String ZRNYOBIN11X10            = "zrnyobin11x10";
    public static final String ZRNYOBIN11X11            = "zrnyobin11x11";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNKAWASERATE            = "zrnkawaserate";
    public static final String ZRNKAWASERATETEKIYOUYMD  = "zrnkawaseratetekiyouymd";
    public static final String ZRNKEIYAKUJIYOTEIRIRITU  = "zrnkeiyakujiyoteiriritu";
    public static final String ZRNENKDTSBUJSITIHSYUKNGK = "zrnenkdtsbujsitihsyukngk";
    public static final String ZRNTUMITATEKIN           = "zrntumitatekin";
    public static final String ZRNKIHARAIKOMIP          = "zrnkiharaikomip";
    public static final String ZRNGAIKADATESYUKEIYAKUP  = "zrngaikadatesyukeiyakup";
    public static final String ZRNTUUKASYUKBN           = "zrntuukasyukbn";
    public static final String ZRNYOBIV1                = "zrnyobiv1";
    public static final String ZRNNKSJITIRTTUMITATEKIN  = "zrnnksjitirttumitatekin";
    public static final String ZRNSISUURENTUMITATEKIN   = "zrnsisuurentumitatekin";
    public static final String ZRNSYUKEIYAKUP           = "zrnsyukeiyakup";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNYOTEIRIRITURIRONBASE  = "zrnyoteiririturironbase";
    public static final String ZRNGKDTYKNNDSYOYOUGAKUYOU = "zrngkdtyknndsyoyougakuyou";
    public static final String ZRNGKDTYKYKNNDSYOYOUGAKUYOU = "zrngkdtykyknndsyoyougakuyou";
    public static final String ZRNDKEISANJIKWSRATE      = "zrndkeisanjikwsrate";
    public static final String ZRNDKEISANJIKWSRATETKYYMD = "zrndkeisanjikwsratetkyymd";
    public static final String ZRNYOBIV6                = "zrnyobiv6";
    public static final String ZRNYOBIV6X2              = "zrnyobiv6x2";
    public static final String ZRNYOBIV6X3              = "zrnyobiv6x3";
    public static final String ZRNSRDAI1HKNKKN          = "zrnsrdai1hknkkn";
    public static final String ZRNYOBIV5                = "zrnyobiv5";
    public static final String ZRNTOKUYAKUKOUMOKUV120   = "zrntokuyakukoumokuv120";
    public static final String ZRNTOKUYAKUKOUMOKUV120X2 = "zrntokuyakukoumokuv120x2";
    public static final String ZRNTOKUYAKUKOUMOKUV120X3 = "zrntokuyakukoumokuv120x3";
    public static final String ZRNTOKUYAKUKOUMOKUV120X4 = "zrntokuyakukoumokuv120x4";
    public static final String ZRNTOKUYAKUKOUMOKUV120X5 = "zrntokuyakukoumokuv120x5";
    public static final String ZRNTOKUYAKUKOUMOKUV120X6 = "zrntokuyakukoumokuv120x6";
    public static final String ZRNTOKUYAKUKOUMOKUV120X7 = "zrntokuyakukoumokuv120x7";
    public static final String ZRNTOKUYAKUKOUMOKUV120X8 = "zrntokuyakukoumokuv120x8";
    public static final String ZRNTOKUYAKUKOUMOKUV120X9 = "zrntokuyakukoumokuv120x9";
    public static final String ZRNTOKUYAKUKOUMOKUV120X10 = "zrntokuyakukoumokuv120x10";
    public static final String ZRNTOKUYAKUKOUMOKUV120X11 = "zrntokuyakukoumokuv120x11";
    public static final String ZRNTOKUYAKUKOUMOKUV120X12 = "zrntokuyakukoumokuv120x12";
    public static final String ZRNTOKUYAKUKOUMOKUV120X13 = "zrntokuyakukoumokuv120x13";
    public static final String ZRNTOKUYAKUKOUMOKUV120X14 = "zrntokuyakukoumokuv120x14";
    public static final String ZRNTOKUYAKUKOUMOKUV120X15 = "zrntokuyakukoumokuv120x15";
    public static final String ZRNTOKUYAKUKOUMOKUV120X16 = "zrntokuyakukoumokuv120x16";
    public static final String ZRNTOKUYAKUKOUMOKUV120X17 = "zrntokuyakukoumokuv120x17";
    public static final String ZRNTOKUYAKUKOUMOKUV120X18 = "zrntokuyakukoumokuv120x18";
    public static final String ZRNTOKUYAKUKOUMOKUV120X19 = "zrntokuyakukoumokuv120x19";
    public static final String ZRNTOKUYAKUKOUMOKUV120X20 = "zrntokuyakukoumokuv120x20";
    public static final String ZRNTOKUYAKUKOUMOKUV120X21 = "zrntokuyakukoumokuv120x21";
    public static final String ZRNTOKUYAKUKOUMOKUV120X22 = "zrntokuyakukoumokuv120x22";
    public static final String ZRNTOKUYAKUKOUMOKUV120X23 = "zrntokuyakukoumokuv120x23";
    public static final String ZRNTOKUYAKUKOUMOKUV120X24 = "zrntokuyakukoumokuv120x24";
    public static final String ZRNTOKUYAKUKOUMOKUV120X25 = "zrntokuyakukoumokuv120x25";
    public static final String ZRNTOKUYAKUKOUMOKUV120X26 = "zrntokuyakukoumokuv120x26";
    public static final String ZRNTOKUYAKUKOUMOKUV120X27 = "zrntokuyakukoumokuv120x27";
    public static final String ZRNTOKUYAKUKOUMOKUV120X28 = "zrntokuyakukoumokuv120x28";
    public static final String ZRNTOKUYAKUKOUMOKUV120X29 = "zrntokuyakukoumokuv120x29";
    public static final String ZRNTOKUYAKUKOUMOKUV120X30 = "zrntokuyakukoumokuv120x30";
    public static final String ZRNTOKUYAKUKOUMOKUV120X31 = "zrntokuyakukoumokuv120x31";
    public static final String ZRNTOKUYAKUKOUMOKUV120X32 = "zrntokuyakukoumokuv120x32";
    public static final String ZRNTOKUYAKUKOUMOKUV120X33 = "zrntokuyakukoumokuv120x33";
    public static final String ZRNTOKUYAKUKOUMOKUV120X34 = "zrntokuyakukoumokuv120x34";
    public static final String ZRNTOKUYAKUKOUMOKUV120X35 = "zrntokuyakukoumokuv120x35";
    public static final String ZRNTOKUYAKUKOUMOKUV120X36 = "zrntokuyakukoumokuv120x36";
    public static final String ZRNTOKUYAKUKOUMOKUV120X37 = "zrntokuyakukoumokuv120x37";
    public static final String ZRNTOKUYAKUKOUMOKUV120X38 = "zrntokuyakukoumokuv120x38";
    public static final String ZRNTOKUYAKUKOUMOKUV120X39 = "zrntokuyakukoumokuv120x39";
    public static final String ZRNTOKUYAKUKOUMOKUV120X40 = "zrntokuyakukoumokuv120x40";

    private final PKZT_RisaTjHitNplusZeroRn primaryKey;

    public GenZT_RisaTjHitNplusZeroRn() {
        primaryKey = new PKZT_RisaTjHitNplusZeroRn();
    }

    public GenZT_RisaTjHitNplusZeroRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_RisaTjHitNplusZeroRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_RisaTjHitNplusZeroRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_RisaTjHitNplusZeroRn> getMetaClass() {
        return QZT_RisaTjHitNplusZeroRn.class;
    }

    @Id
    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private Integer zrnyuukourecordlength;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYUUKOURECORDLENGTH)
    public Integer getZrnyuukourecordlength() {
        return zrnyuukourecordlength;
    }

    public void setZrnyuukourecordlength(Integer pZrnyuukourecordlength) {
        zrnyuukourecordlength = pZrnyuukourecordlength;
    }

    private String zrnrdwarea;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNRDWAREA)
    public String getZrnrdwarea() {
        return zrnrdwarea;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnrdwarea(String pZrnrdwarea) {
        zrnrdwarea = pZrnrdwarea;
    }

    private String zrndatakanrino;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

    private String zrnerrkbnv1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNERRKBNV1)
    public String getZrnerrkbnv1() {
        return zrnerrkbnv1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnerrkbnv1(String pZrnerrkbnv1) {
        zrnerrkbnv1 = pZrnerrkbnv1;
    }

    private String zrnratekbn;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNRATEKBN)
    public String getZrnratekbn() {
        return zrnratekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnratekbn(String pZrnratekbn) {
        zrnratekbn = pZrnratekbn;
    }

    private String zrnsuurisyuruicd;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSUURISYURUICD)
    public String getZrnsuurisyuruicd() {
        return zrnsuurisyuruicd;
    }

    public void setZrnsuurisyuruicd(String pZrnsuurisyuruicd) {
        zrnsuurisyuruicd = pZrnsuurisyuruicd;
    }

    private String zrnyobiv2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOBIV2)
    public String getZrnyobiv2() {
        return zrnyobiv2;
    }

    public void setZrnyobiv2(String pZrnyobiv2) {
        zrnyobiv2 = pZrnyobiv2;
    }

    private String zrnkbnkeiriyousegmentkbn;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNKBNKEIRIYOUSEGMENTKBN)
    public String getZrnkbnkeiriyousegmentkbn() {
        return zrnkbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyousegmentkbn(String pZrnkbnkeiriyousegmentkbn) {
        zrnkbnkeiriyousegmentkbn = pZrnkbnkeiriyousegmentkbn;
    }

    private String zrnkbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNKBNKEIRIYOURGNBNSKKBN)
    public String getZrnkbnkeiriyourgnbnskkbn() {
        return zrnkbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyourgnbnskkbn(String pZrnkbnkeiriyourgnbnskkbn) {
        zrnkbnkeiriyourgnbnskkbn = pZrnkbnkeiriyourgnbnskkbn;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnhokensyuruikigouyobi1x1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X1)
    public String getZrnhokensyuruikigouyobi1x1() {
        return zrnhokensyuruikigouyobi1x1;
    }

    public void setZrnhokensyuruikigouyobi1x1(String pZrnhokensyuruikigouyobi1x1) {
        zrnhokensyuruikigouyobi1x1 = pZrnhokensyuruikigouyobi1x1;
    }

    private String zrnhokensyuruikigouyobi1x2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X2)
    public String getZrnhokensyuruikigouyobi1x2() {
        return zrnhokensyuruikigouyobi1x2;
    }

    public void setZrnhokensyuruikigouyobi1x2(String pZrnhokensyuruikigouyobi1x2) {
        zrnhokensyuruikigouyobi1x2 = pZrnhokensyuruikigouyobi1x2;
    }

    private String zrnhokensyuruikigouyobi1x3;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X3)
    public String getZrnhokensyuruikigouyobi1x3() {
        return zrnhokensyuruikigouyobi1x3;
    }

    public void setZrnhokensyuruikigouyobi1x3(String pZrnhokensyuruikigouyobi1x3) {
        zrnhokensyuruikigouyobi1x3 = pZrnhokensyuruikigouyobi1x3;
    }

    private String zrnhokensyuruikigouyobi1x4;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X4)
    public String getZrnhokensyuruikigouyobi1x4() {
        return zrnhokensyuruikigouyobi1x4;
    }

    public void setZrnhokensyuruikigouyobi1x4(String pZrnhokensyuruikigouyobi1x4) {
        zrnhokensyuruikigouyobi1x4 = pZrnhokensyuruikigouyobi1x4;
    }

    private String zrnhokensyuruikigouyobi1x5;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X5)
    public String getZrnhokensyuruikigouyobi1x5() {
        return zrnhokensyuruikigouyobi1x5;
    }

    public void setZrnhokensyuruikigouyobi1x5(String pZrnhokensyuruikigouyobi1x5) {
        zrnhokensyuruikigouyobi1x5 = pZrnhokensyuruikigouyobi1x5;
    }

    private String zrnhokensyuruikigouyobi1x6;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X6)
    public String getZrnhokensyuruikigouyobi1x6() {
        return zrnhokensyuruikigouyobi1x6;
    }

    public void setZrnhokensyuruikigouyobi1x6(String pZrnhokensyuruikigouyobi1x6) {
        zrnhokensyuruikigouyobi1x6 = pZrnhokensyuruikigouyobi1x6;
    }

    private String zrnhokensyuruikigouyobi1x7;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X7)
    public String getZrnhokensyuruikigouyobi1x7() {
        return zrnhokensyuruikigouyobi1x7;
    }

    public void setZrnhokensyuruikigouyobi1x7(String pZrnhokensyuruikigouyobi1x7) {
        zrnhokensyuruikigouyobi1x7 = pZrnhokensyuruikigouyobi1x7;
    }

    private String zrnhokensyuruikigouyobi1x8;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X8)
    public String getZrnhokensyuruikigouyobi1x8() {
        return zrnhokensyuruikigouyobi1x8;
    }

    public void setZrnhokensyuruikigouyobi1x8(String pZrnhokensyuruikigouyobi1x8) {
        zrnhokensyuruikigouyobi1x8 = pZrnhokensyuruikigouyobi1x8;
    }

    private String zrnhokensyuruikigouyobi1x9;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X9)
    public String getZrnhokensyuruikigouyobi1x9() {
        return zrnhokensyuruikigouyobi1x9;
    }

    public void setZrnhokensyuruikigouyobi1x9(String pZrnhokensyuruikigouyobi1x9) {
        zrnhokensyuruikigouyobi1x9 = pZrnhokensyuruikigouyobi1x9;
    }

    private String zrnhokensyuruikigouyobi1x10;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X10)
    public String getZrnhokensyuruikigouyobi1x10() {
        return zrnhokensyuruikigouyobi1x10;
    }

    public void setZrnhokensyuruikigouyobi1x10(String pZrnhokensyuruikigouyobi1x10) {
        zrnhokensyuruikigouyobi1x10 = pZrnhokensyuruikigouyobi1x10;
    }

    private String zrnhokensyuruikigouyobi1x11;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X11)
    public String getZrnhokensyuruikigouyobi1x11() {
        return zrnhokensyuruikigouyobi1x11;
    }

    public void setZrnhokensyuruikigouyobi1x11(String pZrnhokensyuruikigouyobi1x11) {
        zrnhokensyuruikigouyobi1x11 = pZrnhokensyuruikigouyobi1x11;
    }

    private String zrnhokensyuruikigouyobi1x12;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X12)
    public String getZrnhokensyuruikigouyobi1x12() {
        return zrnhokensyuruikigouyobi1x12;
    }

    public void setZrnhokensyuruikigouyobi1x12(String pZrnhokensyuruikigouyobi1x12) {
        zrnhokensyuruikigouyobi1x12 = pZrnhokensyuruikigouyobi1x12;
    }

    private String zrnhokensyuruikigouyobi1x13;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X13)
    public String getZrnhokensyuruikigouyobi1x13() {
        return zrnhokensyuruikigouyobi1x13;
    }

    public void setZrnhokensyuruikigouyobi1x13(String pZrnhokensyuruikigouyobi1x13) {
        zrnhokensyuruikigouyobi1x13 = pZrnhokensyuruikigouyobi1x13;
    }

    private String zrnhokensyuruikigouyobi1x14;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X14)
    public String getZrnhokensyuruikigouyobi1x14() {
        return zrnhokensyuruikigouyobi1x14;
    }

    public void setZrnhokensyuruikigouyobi1x14(String pZrnhokensyuruikigouyobi1x14) {
        zrnhokensyuruikigouyobi1x14 = pZrnhokensyuruikigouyobi1x14;
    }

    private String zrnhokensyuruikigouyobi1x15;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X15)
    public String getZrnhokensyuruikigouyobi1x15() {
        return zrnhokensyuruikigouyobi1x15;
    }

    public void setZrnhokensyuruikigouyobi1x15(String pZrnhokensyuruikigouyobi1x15) {
        zrnhokensyuruikigouyobi1x15 = pZrnhokensyuruikigouyobi1x15;
    }

    private String zrnhokensyuruikigouyobi2x1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X1)
    public String getZrnhokensyuruikigouyobi2x1() {
        return zrnhokensyuruikigouyobi2x1;
    }

    public void setZrnhokensyuruikigouyobi2x1(String pZrnhokensyuruikigouyobi2x1) {
        zrnhokensyuruikigouyobi2x1 = pZrnhokensyuruikigouyobi2x1;
    }

    private String zrnhokensyuruikigouyobi2x2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X2)
    public String getZrnhokensyuruikigouyobi2x2() {
        return zrnhokensyuruikigouyobi2x2;
    }

    public void setZrnhokensyuruikigouyobi2x2(String pZrnhokensyuruikigouyobi2x2) {
        zrnhokensyuruikigouyobi2x2 = pZrnhokensyuruikigouyobi2x2;
    }

    private String zrnhokensyuruikigouyobi2x3;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X3)
    public String getZrnhokensyuruikigouyobi2x3() {
        return zrnhokensyuruikigouyobi2x3;
    }

    public void setZrnhokensyuruikigouyobi2x3(String pZrnhokensyuruikigouyobi2x3) {
        zrnhokensyuruikigouyobi2x3 = pZrnhokensyuruikigouyobi2x3;
    }

    private String zrnhokensyuruikigouyobi2x4;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X4)
    public String getZrnhokensyuruikigouyobi2x4() {
        return zrnhokensyuruikigouyobi2x4;
    }

    public void setZrnhokensyuruikigouyobi2x4(String pZrnhokensyuruikigouyobi2x4) {
        zrnhokensyuruikigouyobi2x4 = pZrnhokensyuruikigouyobi2x4;
    }

    private String zrnhokensyuruikigouyobi2x5;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X5)
    public String getZrnhokensyuruikigouyobi2x5() {
        return zrnhokensyuruikigouyobi2x5;
    }

    public void setZrnhokensyuruikigouyobi2x5(String pZrnhokensyuruikigouyobi2x5) {
        zrnhokensyuruikigouyobi2x5 = pZrnhokensyuruikigouyobi2x5;
    }

    private String zrnhokensyuruikigouyobi2x6;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X6)
    public String getZrnhokensyuruikigouyobi2x6() {
        return zrnhokensyuruikigouyobi2x6;
    }

    public void setZrnhokensyuruikigouyobi2x6(String pZrnhokensyuruikigouyobi2x6) {
        zrnhokensyuruikigouyobi2x6 = pZrnhokensyuruikigouyobi2x6;
    }

    private String zrnhokensyuruikigouyobi2x7;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X7)
    public String getZrnhokensyuruikigouyobi2x7() {
        return zrnhokensyuruikigouyobi2x7;
    }

    public void setZrnhokensyuruikigouyobi2x7(String pZrnhokensyuruikigouyobi2x7) {
        zrnhokensyuruikigouyobi2x7 = pZrnhokensyuruikigouyobi2x7;
    }

    private String zrnhokensyuruikigouyobi2x8;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X8)
    public String getZrnhokensyuruikigouyobi2x8() {
        return zrnhokensyuruikigouyobi2x8;
    }

    public void setZrnhokensyuruikigouyobi2x8(String pZrnhokensyuruikigouyobi2x8) {
        zrnhokensyuruikigouyobi2x8 = pZrnhokensyuruikigouyobi2x8;
    }

    private String zrnhokensyuruikigouyobi2x9;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X9)
    public String getZrnhokensyuruikigouyobi2x9() {
        return zrnhokensyuruikigouyobi2x9;
    }

    public void setZrnhokensyuruikigouyobi2x9(String pZrnhokensyuruikigouyobi2x9) {
        zrnhokensyuruikigouyobi2x9 = pZrnhokensyuruikigouyobi2x9;
    }

    private String zrnhokensyuruikigouyobi2x10;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X10)
    public String getZrnhokensyuruikigouyobi2x10() {
        return zrnhokensyuruikigouyobi2x10;
    }

    public void setZrnhokensyuruikigouyobi2x10(String pZrnhokensyuruikigouyobi2x10) {
        zrnhokensyuruikigouyobi2x10 = pZrnhokensyuruikigouyobi2x10;
    }

    private String zrnhokensyuruikigouyobi3x1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X1)
    public String getZrnhokensyuruikigouyobi3x1() {
        return zrnhokensyuruikigouyobi3x1;
    }

    public void setZrnhokensyuruikigouyobi3x1(String pZrnhokensyuruikigouyobi3x1) {
        zrnhokensyuruikigouyobi3x1 = pZrnhokensyuruikigouyobi3x1;
    }

    private String zrnhokensyuruikigouyobi3x2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X2)
    public String getZrnhokensyuruikigouyobi3x2() {
        return zrnhokensyuruikigouyobi3x2;
    }

    public void setZrnhokensyuruikigouyobi3x2(String pZrnhokensyuruikigouyobi3x2) {
        zrnhokensyuruikigouyobi3x2 = pZrnhokensyuruikigouyobi3x2;
    }

    private String zrnhokensyuruikigouyobi3x3;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X3)
    public String getZrnhokensyuruikigouyobi3x3() {
        return zrnhokensyuruikigouyobi3x3;
    }

    public void setZrnhokensyuruikigouyobi3x3(String pZrnhokensyuruikigouyobi3x3) {
        zrnhokensyuruikigouyobi3x3 = pZrnhokensyuruikigouyobi3x3;
    }

    private String zrnhokensyuruikigouyobi3x4;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X4)
    public String getZrnhokensyuruikigouyobi3x4() {
        return zrnhokensyuruikigouyobi3x4;
    }

    public void setZrnhokensyuruikigouyobi3x4(String pZrnhokensyuruikigouyobi3x4) {
        zrnhokensyuruikigouyobi3x4 = pZrnhokensyuruikigouyobi3x4;
    }

    private String zrnhokensyuruikigouyobi3x5;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X5)
    public String getZrnhokensyuruikigouyobi3x5() {
        return zrnhokensyuruikigouyobi3x5;
    }

    public void setZrnhokensyuruikigouyobi3x5(String pZrnhokensyuruikigouyobi3x5) {
        zrnhokensyuruikigouyobi3x5 = pZrnhokensyuruikigouyobi3x5;
    }

    private String zrnhokensyuruikigouyobi3x6;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X6)
    public String getZrnhokensyuruikigouyobi3x6() {
        return zrnhokensyuruikigouyobi3x6;
    }

    public void setZrnhokensyuruikigouyobi3x6(String pZrnhokensyuruikigouyobi3x6) {
        zrnhokensyuruikigouyobi3x6 = pZrnhokensyuruikigouyobi3x6;
    }

    private String zrnhokensyuruikigouyobi3x7;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X7)
    public String getZrnhokensyuruikigouyobi3x7() {
        return zrnhokensyuruikigouyobi3x7;
    }

    public void setZrnhokensyuruikigouyobi3x7(String pZrnhokensyuruikigouyobi3x7) {
        zrnhokensyuruikigouyobi3x7 = pZrnhokensyuruikigouyobi3x7;
    }

    private String zrnhokensyuruikigouyobi3x8;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X8)
    public String getZrnhokensyuruikigouyobi3x8() {
        return zrnhokensyuruikigouyobi3x8;
    }

    public void setZrnhokensyuruikigouyobi3x8(String pZrnhokensyuruikigouyobi3x8) {
        zrnhokensyuruikigouyobi3x8 = pZrnhokensyuruikigouyobi3x8;
    }

    private String zrnhokensyuruikigouyobi3x9;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X9)
    public String getZrnhokensyuruikigouyobi3x9() {
        return zrnhokensyuruikigouyobi3x9;
    }

    public void setZrnhokensyuruikigouyobi3x9(String pZrnhokensyuruikigouyobi3x9) {
        zrnhokensyuruikigouyobi3x9 = pZrnhokensyuruikigouyobi3x9;
    }

    private String zrnhokensyuruikigouyobi3x10;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X10)
    public String getZrnhokensyuruikigouyobi3x10() {
        return zrnhokensyuruikigouyobi3x10;
    }

    public void setZrnhokensyuruikigouyobi3x10(String pZrnhokensyuruikigouyobi3x10) {
        zrnhokensyuruikigouyobi3x10 = pZrnhokensyuruikigouyobi3x10;
    }

    private String zrnharaikatakbn;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHARAIKATAKBN)
    public String getZrnharaikatakbn() {
        return zrnharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnharaikatakbn(String pZrnharaikatakbn) {
        zrnharaikatakbn = pZrnharaikatakbn;
    }

    private String zrnkeiyakunendo;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNKEIYAKUNENDO)
    public String getZrnkeiyakunendo() {
        return zrnkeiyakunendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkeiyakunendo(String pZrnkeiyakunendo) {
        zrnkeiyakunendo = pZrnkeiyakunendo;
    }

    private String zrnkeiyakum;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNKEIYAKUM)
    public String getZrnkeiyakum() {
        return zrnkeiyakum;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkeiyakum(String pZrnkeiyakum) {
        zrnkeiyakum = pZrnkeiyakum;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhihokensyaagev2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHIHOKENSYAAGEV2)
    public String getZrnhihokensyaagev2() {
        return zrnhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyaagev2(String pZrnhihokensyaagev2) {
        zrnhihokensyaagev2 = pZrnhihokensyaagev2;
    }

    private String zrn5nenmeoutoubikbn;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRN5NENMEOUTOUBIKBN)
    public String getZrn5nenmeoutoubikbn() {
        return zrn5nenmeoutoubikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrn5nenmeoutoubikbn(String pZrn5nenmeoutoubikbn) {
        zrn5nenmeoutoubikbn = pZrn5nenmeoutoubikbn;
    }

    private String zrnkeijyouym;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNKEIJYOUYM)
    public String getZrnkeijyouym() {
        return zrnkeijyouym;
    }

    public void setZrnkeijyouym(String pZrnkeijyouym) {
        zrnkeijyouym = pZrnkeijyouym;
    }

    private String zrnkeiyakuoutoubikbn;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNKEIYAKUOUTOUBIKBN)
    public String getZrnkeiyakuoutoubikbn() {
        return zrnkeiyakuoutoubikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkeiyakuoutoubikbn(String pZrnkeiyakuoutoubikbn) {
        zrnkeiyakuoutoubikbn = pZrnkeiyakuoutoubikbn;
    }

    private String zrnsuuriyouyobin1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSUURIYOUYOBIN1)
    public String getZrnsuuriyouyobin1() {
        return zrnsuuriyouyobin1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1(String pZrnsuuriyouyobin1) {
        zrnsuuriyouyobin1 = pZrnsuuriyouyobin1;
    }

    private String zrnsuuriyouyobin11;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSUURIYOUYOBIN11)
    public String getZrnsuuriyouyobin11() {
        return zrnsuuriyouyobin11;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnsuuriyouyobin11(String pZrnsuuriyouyobin11) {
        zrnsuuriyouyobin11 = pZrnsuuriyouyobin11;
    }

    private Integer zrnsaisitutokuyakuhukasuu;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSAISITUTOKUYAKUHUKASUU)
    public Integer getZrnsaisitutokuyakuhukasuu() {
        return zrnsaisitutokuyakuhukasuu;
    }

    public void setZrnsaisitutokuyakuhukasuu(Integer pZrnsaisitutokuyakuhukasuu) {
        zrnsaisitutokuyakuhukasuu = pZrnsaisitutokuyakuhukasuu;
    }

    private Long zrnkihons;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNKIHONS)
    public Long getZrnkihons() {
        return zrnkihons;
    }

    public void setZrnkihons(Long pZrnkihons) {
        zrnkihons = pZrnkihons;
    }

    private Long zrnsibous;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSIBOUS)
    public Long getZrnsibous() {
        return zrnsibous;
    }

    public void setZrnsibous(Long pZrnsibous) {
        zrnsibous = pZrnsibous;
    }

    private Long zrntounendmtwrhrgkruikeigk;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOUNENDMTWRHRGKRUIKEIGK)
    public Long getZrntounendmtwrhrgkruikeigk() {
        return zrntounendmtwrhrgkruikeigk;
    }

    public void setZrntounendmtwrhrgkruikeigk(Long pZrntounendmtwrhrgkruikeigk) {
        zrntounendmtwrhrgkruikeigk = pZrntounendmtwrhrgkruikeigk;
    }

    private Long zrnwarihurigakurisoku1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNWARIHURIGAKURISOKU1)
    public Long getZrnwarihurigakurisoku1() {
        return zrnwarihurigakurisoku1;
    }

    public void setZrnwarihurigakurisoku1(Long pZrnwarihurigakurisoku1) {
        zrnwarihurigakurisoku1 = pZrnwarihurigakurisoku1;
    }

    private Long zrnwarihurigakurisoku2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNWARIHURIGAKURISOKU2)
    public Long getZrnwarihurigakurisoku2() {
        return zrnwarihurigakurisoku2;
    }

    public void setZrnwarihurigakurisoku2(Long pZrnwarihurigakurisoku2) {
        zrnwarihurigakurisoku2 = pZrnwarihurigakurisoku2;
    }

    private Long zrnyokunendosyoyougakuyou;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOKUNENDOSYOYOUGAKUYOU)
    public Long getZrnyokunendosyoyougakuyou() {
        return zrnyokunendosyoyougakuyou;
    }

    public void setZrnyokunendosyoyougakuyou(Long pZrnyokunendosyoyougakuyou) {
        zrnyokunendosyoyougakuyou = pZrnyokunendosyoyougakuyou;
    }

    private Long zrnyokuyokunendosyoyougkyou;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOKUYOKUNENDOSYOYOUGKYOU)
    public Long getZrnyokuyokunendosyoyougkyou() {
        return zrnyokuyokunendosyoyougkyou;
    }

    public void setZrnyokuyokunendosyoyougkyou(Long pZrnyokuyokunendosyoyougkyou) {
        zrnyokuyokunendosyoyougkyou = pZrnyokuyokunendosyoyougkyou;
    }

    private Long zrnyuukoutyuusyoyougaku;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYUUKOUTYUUSYOYOUGAKU)
    public Long getZrnyuukoutyuusyoyougaku() {
        return zrnyuukoutyuusyoyougaku;
    }

    public void setZrnyuukoutyuusyoyougaku(Long pZrnyuukoutyuusyoyougaku) {
        zrnyuukoutyuusyoyougaku = pZrnyuukoutyuusyoyougaku;
    }

    private Long zrnsyoumetuyousyoyougaku1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSYOUMETUYOUSYOYOUGAKU1)
    public Long getZrnsyoumetuyousyoyougaku1() {
        return zrnsyoumetuyousyoyougaku1;
    }

    public void setZrnsyoumetuyousyoyougaku1(Long pZrnsyoumetuyousyoyougaku1) {
        zrnsyoumetuyousyoyougaku1 = pZrnsyoumetuyousyoyougaku1;
    }

    private Long zrnsyoumetuyousyoyougaku2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSYOUMETUYOUSYOYOUGAKU2)
    public Long getZrnsyoumetuyousyoyougaku2() {
        return zrnsyoumetuyousyoyougaku2;
    }

    public void setZrnsyoumetuyousyoyougaku2(Long pZrnsyoumetuyousyoyougaku2) {
        zrnsyoumetuyousyoyougaku2 = pZrnsyoumetuyousyoyougaku2;
    }

    private Long zrntenkanyousyoyougaku1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTENKANYOUSYOYOUGAKU1)
    public Long getZrntenkanyousyoyougaku1() {
        return zrntenkanyousyoyougaku1;
    }

    public void setZrntenkanyousyoyougaku1(Long pZrntenkanyousyoyougaku1) {
        zrntenkanyousyoyougaku1 = pZrntenkanyousyoyougaku1;
    }

    private Long zrntenkanyousyoyougaku2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTENKANYOUSYOYOUGAKU2)
    public Long getZrntenkanyousyoyougaku2() {
        return zrntenkanyousyoyougaku2;
    }

    public void setZrntenkanyousyoyougaku2(Long pZrntenkanyousyoyougaku2) {
        zrntenkanyousyoyougaku2 = pZrntenkanyousyoyougaku2;
    }

    private Long zrntnknyutuujyoudsyoyougk1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUTUUJYOUDSYOYOUGK1)
    public Long getZrntnknyutuujyoudsyoyougk1() {
        return zrntnknyutuujyoudsyoyougk1;
    }

    public void setZrntnknyutuujyoudsyoyougk1(Long pZrntnknyutuujyoudsyoyougk1) {
        zrntnknyutuujyoudsyoyougk1 = pZrntnknyutuujyoudsyoyougk1;
    }

    private Long zrntnknyutuujyoudsyoyougk2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUTUUJYOUDSYOYOUGK2)
    public Long getZrntnknyutuujyoudsyoyougk2() {
        return zrntnknyutuujyoudsyoyougk2;
    }

    public void setZrntnknyutuujyoudsyoyougk2(Long pZrntnknyutuujyoudsyoyougk2) {
        zrntnknyutuujyoudsyoyougk2 = pZrntnknyutuujyoudsyoyougk2;
    }

    private Long zrntnknyuhrkbbnksyoyougk1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUHRKBBNKSYOYOUGK1)
    public Long getZrntnknyuhrkbbnksyoyougk1() {
        return zrntnknyuhrkbbnksyoyougk1;
    }

    public void setZrntnknyuhrkbbnksyoyougk1(Long pZrntnknyuhrkbbnksyoyougk1) {
        zrntnknyuhrkbbnksyoyougk1 = pZrntnknyuhrkbbnksyoyougk1;
    }

    private Long zrntnknyuhrkbbnksyoyougk2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUHRKBBNKSYOYOUGK2)
    public Long getZrntnknyuhrkbbnksyoyougk2() {
        return zrntnknyuhrkbbnksyoyougk2;
    }

    public void setZrntnknyuhrkbbnksyoyougk2(Long pZrntnknyuhrkbbnksyoyougk2) {
        zrntnknyuhrkbbnksyoyougk2 = pZrntnknyuhrkbbnksyoyougk2;
    }

    private Long zrntnknyuhrkbbnknnknsnp1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUHRKBBNKNNKNSNP1)
    public Long getZrntnknyuhrkbbnknnknsnp1() {
        return zrntnknyuhrkbbnknnknsnp1;
    }

    public void setZrntnknyuhrkbbnknnknsnp1(Long pZrntnknyuhrkbbnknnknsnp1) {
        zrntnknyuhrkbbnknnknsnp1 = pZrntnknyuhrkbbnknnknsnp1;
    }

    private Long zrntnknyuhrkbbnknnknsnp2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUHRKBBNKNNKNSNP2)
    public Long getZrntnknyuhrkbbnknnknsnp2() {
        return zrntnknyuhrkbbnknnknsnp2;
    }

    public void setZrntnknyuhrkbbnknnknsnp2(Long pZrntnknyuhrkbbnknnknsnp2) {
        zrntnknyuhrkbbnknnknsnp2 = pZrntnknyuhrkbbnknnknsnp2;
    }

    private Long zrntnknyutnknhktgksyoyougk1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUTNKNHKTGKSYOYOUGK1)
    public Long getZrntnknyutnknhktgksyoyougk1() {
        return zrntnknyutnknhktgksyoyougk1;
    }

    public void setZrntnknyutnknhktgksyoyougk1(Long pZrntnknyutnknhktgksyoyougk1) {
        zrntnknyutnknhktgksyoyougk1 = pZrntnknyutnknhktgksyoyougk1;
    }

    private Long zrntnknyutnknhktgksyoyougk2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUTNKNHKTGKSYOYOUGK2)
    public Long getZrntnknyutnknhktgksyoyougk2() {
        return zrntnknyutnknhktgksyoyougk2;
    }

    public void setZrntnknyutnknhktgksyoyougk2(Long pZrntnknyutnknhktgksyoyougk2) {
        zrntnknyutnknhktgksyoyougk2 = pZrntnknyutnknhktgksyoyougk2;
    }

    private Long zrntnknyutnknhktgknnknsnp1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUTNKNHKTGKNNKNSNP1)
    public Long getZrntnknyutnknhktgknnknsnp1() {
        return zrntnknyutnknhktgknnknsnp1;
    }

    public void setZrntnknyutnknhktgknnknsnp1(Long pZrntnknyutnknhktgknnknsnp1) {
        zrntnknyutnknhktgknnknsnp1 = pZrntnknyutnknhktgknnknsnp1;
    }

    private Long zrntnknyutnknhktgknnknsnp2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUTNKNHKTGKNNKNSNP2)
    public Long getZrntnknyutnknhktgknnknsnp2() {
        return zrntnknyutnknhktgknnknsnp2;
    }

    public void setZrntnknyutnknhktgknnknsnp2(Long pZrntnknyutnknhktgknnknsnp2) {
        zrntnknyutnknhktgknnknsnp2 = pZrntnknyutnknhktgknnknsnp2;
    }

    private Long zrntnknyusaisituksyoyougk1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUSAISITUKSYOYOUGK1)
    public Long getZrntnknyusaisituksyoyougk1() {
        return zrntnknyusaisituksyoyougk1;
    }

    public void setZrntnknyusaisituksyoyougk1(Long pZrntnknyusaisituksyoyougk1) {
        zrntnknyusaisituksyoyougk1 = pZrntnknyusaisituksyoyougk1;
    }

    private Long zrntnknyusaisituksyoyougk2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUSAISITUKSYOYOUGK2)
    public Long getZrntnknyusaisituksyoyougk2() {
        return zrntnknyusaisituksyoyougk2;
    }

    public void setZrntnknyusaisituksyoyougk2(Long pZrntnknyusaisituksyoyougk2) {
        zrntnknyusaisituksyoyougk2 = pZrntnknyusaisituksyoyougk2;
    }

    private Long zrntnknyusaisitukkyhntgk1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUSAISITUKKYHNTGK1)
    public Long getZrntnknyusaisitukkyhntgk1() {
        return zrntnknyusaisitukkyhntgk1;
    }

    public void setZrntnknyusaisitukkyhntgk1(Long pZrntnknyusaisitukkyhntgk1) {
        zrntnknyusaisitukkyhntgk1 = pZrntnknyusaisitukkyhntgk1;
    }

    private Long zrntnknyusaisitukkyhntgk2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUSAISITUKKYHNTGK2)
    public Long getZrntnknyusaisitukkyhntgk2() {
        return zrntnknyusaisitukkyhntgk2;
    }

    public void setZrntnknyusaisitukkyhntgk2(Long pZrntnknyusaisitukkyhntgk2) {
        zrntnknyusaisitukkyhntgk2 = pZrntnknyusaisitukkyhntgk2;
    }

    private Long zrnhrkbbnkdsyoyougk;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHRKBBNKDSYOYOUGK)
    public Long getZrnhrkbbnkdsyoyougk() {
        return zrnhrkbbnkdsyoyougk;
    }

    public void setZrnhrkbbnkdsyoyougk(Long pZrnhrkbbnkdsyoyougk) {
        zrnhrkbbnkdsyoyougk = pZrnhrkbbnkdsyoyougk;
    }

    private Long zrnhrkbbnkdtisyunnknsnp;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHRKBBNKDTISYUNNKNSNP)
    public Long getZrnhrkbbnkdtisyunnknsnp() {
        return zrnhrkbbnkdtisyunnknsnp;
    }

    public void setZrnhrkbbnkdtisyunnknsnp(Long pZrnhrkbbnkdtisyunnknsnp) {
        zrnhrkbbnkdtisyunnknsnp = pZrnhrkbbnkdtisyunnknsnp;
    }

    private Long zrntusangohrkbbnkappad;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTUSANGOHRKBBNKAPPAD)
    public Long getZrntusangohrkbbnkappad() {
        return zrntusangohrkbbnkappad;
    }

    public void setZrntusangohrkbbnkappad(Long pZrntusangohrkbbnkappad) {
        zrntusangohrkbbnkappad = pZrntusangohrkbbnkappad;
    }

    private Long zrntnknhktgkdsyoyougk;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNHKTGKDSYOYOUGK)
    public Long getZrntnknhktgkdsyoyougk() {
        return zrntnknhktgkdsyoyougk;
    }

    public void setZrntnknhktgkdsyoyougk(Long pZrntnknhktgkdsyoyougk) {
        zrntnknhktgkdsyoyougk = pZrntnknhktgkdsyoyougk;
    }

    private Long zrntnknhktgkdtisyunenknsnp;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNHKTGKDTISYUNENKNSNP)
    public Long getZrntnknhktgkdtisyunenknsnp() {
        return zrntnknhktgkdtisyunenknsnp;
    }

    public void setZrntnknhktgkdtisyunenknsnp(Long pZrntnknhktgkdtisyunenknsnp) {
        zrntnknhktgkdtisyunenknsnp = pZrntnknhktgkdtisyunenknsnp;
    }

    private Long zrntusangotnknhktgkappad;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTUSANGOTNKNHKTGKAPPAD)
    public Long getZrntusangotnknhktgkappad() {
        return zrntusangotnknhktgkappad;
    }

    public void setZrntusangotnknhktgkappad(Long pZrntusangotnknhktgkappad) {
        zrntusangotnknhktgkappad = pZrntusangotnknhktgkappad;
    }

    private Long zrntuusangohutuusiboukappad;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTUUSANGOHUTUUSIBOUKAPPAD)
    public Long getZrntuusangohutuusiboukappad() {
        return zrntuusangohutuusiboukappad;
    }

    public void setZrntuusangohutuusiboukappad(Long pZrntuusangohutuusiboukappad) {
        zrntuusangohutuusiboukappad = pZrntuusangohutuusiboukappad;
    }

    private Long zrnsaisitukappadsyoyougaku;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSAISITUKAPPADSYOYOUGAKU)
    public Long getZrnsaisitukappadsyoyougaku() {
        return zrnsaisitukappadsyoyougaku;
    }

    public void setZrnsaisitukappadsyoyougaku(Long pZrnsaisitukappadsyoyougaku) {
        zrnsaisitukappadsyoyougaku = pZrnsaisitukappadsyoyougaku;
    }

    private Long zrntuusangosaisitukappad;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTUUSANGOSAISITUKAPPAD)
    public Long getZrntuusangosaisitukappad() {
        return zrntuusangosaisitukappad;
    }

    public void setZrntuusangosaisitukappad(Long pZrntuusangosaisitukappad) {
        zrntuusangosaisitukappad = pZrntuusangosaisitukappad;
    }

    private Long zrnsistkappadtisyukyhntgk;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSISTKAPPADTISYUKYHNTGK)
    public Long getZrnsistkappadtisyukyhntgk() {
        return zrnsistkappadtisyukyhntgk;
    }

    public void setZrnsistkappadtisyukyhntgk(Long pZrnsistkappadtisyukyhntgk) {
        zrnsistkappadtisyukyhntgk = pZrnsistkappadtisyukyhntgk;
    }

    private Long zrntuusangogoukeikappad;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTUUSANGOGOUKEIKAPPAD)
    public Long getZrntuusangogoukeikappad() {
        return zrntuusangogoukeikappad;
    }

    public void setZrntuusangogoukeikappad(Long pZrntuusangogoukeikappad) {
        zrntuusangogoukeikappad = pZrntuusangogoukeikappad;
    }

    private Long zrndtaisyouv;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNDTAISYOUV)
    public Long getZrndtaisyouv() {
        return zrndtaisyouv;
    }

    public void setZrndtaisyouv(Long pZrndtaisyouv) {
        zrndtaisyouv = pZrndtaisyouv;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private BizNumber zrndaihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNDAIHYOUYOTEIRIRITU)
    public BizNumber getZrndaihyouyoteiriritu() {
        return zrndaihyouyoteiriritu;
    }

    public void setZrndaihyouyoteiriritu(BizNumber pZrndaihyouyoteiriritu) {
        zrndaihyouyoteiriritu = pZrndaihyouyoteiriritu;
    }

    private String zrnknkuzusnzyrt;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNKNKUZUSNZYRT)
    public String getZrnknkuzusnzyrt() {
        return zrnknkuzusnzyrt;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnknkuzusnzyrt(String pZrnknkuzusnzyrt) {
        zrnknkuzusnzyrt = pZrnknkuzusnzyrt;
    }

    private String zrnzyrthntiyustatuskbn;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNZYRTHNTIYUSTATUSKBN)
    public String getZrnzyrthntiyustatuskbn() {
        return zrnzyrthntiyustatuskbn;
    }

    public void setZrnzyrthntiyustatuskbn(String pZrnzyrthntiyustatuskbn) {
        zrnzyrthntiyustatuskbn = pZrnzyrthntiyustatuskbn;
    }

    private String zrnyobiv7;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOBIV7)
    public String getZrnyobiv7() {
        return zrnyobiv7;
    }

    public void setZrnyobiv7(String pZrnyobiv7) {
        zrnyobiv7 = pZrnyobiv7;
    }

    private Long zrntnknyusyusistksyoyougk1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUSYUSISTKSYOYOUGK1)
    public Long getZrntnknyusyusistksyoyougk1() {
        return zrntnknyusyusistksyoyougk1;
    }

    public void setZrntnknyusyusistksyoyougk1(Long pZrntnknyusyusistksyoyougk1) {
        zrntnknyusyusistksyoyougk1 = pZrntnknyusyusistksyoyougk1;
    }

    private Long zrntnknyusyusistksyoyougk2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUSYUSISTKSYOYOUGK2)
    public Long getZrntnknyusyusistksyoyougk2() {
        return zrntnknyusyusistksyoyougk2;
    }

    public void setZrntnknyusyusistksyoyougk2(Long pZrntnknyusyusistksyoyougk2) {
        zrntnknyusyusistksyoyougk2 = pZrntnknyusyusistksyoyougk2;
    }

    private Long zrntnknyusyusistkkyhntgk1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUSYUSISTKKYHNTGK1)
    public Long getZrntnknyusyusistkkyhntgk1() {
        return zrntnknyusyusistkkyhntgk1;
    }

    public void setZrntnknyusyusistkkyhntgk1(Long pZrntnknyusyusistkkyhntgk1) {
        zrntnknyusyusistkkyhntgk1 = pZrntnknyusyusistkkyhntgk1;
    }

    private Long zrntnknyusyusistkkyhntgk2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTNKNYUSYUSISTKKYHNTGK2)
    public Long getZrntnknyusyusistkkyhntgk2() {
        return zrntnknyusyusistkkyhntgk2;
    }

    public void setZrntnknyusyusistkkyhntgk2(Long pZrntnknyusyusistkkyhntgk2) {
        zrntnknyusyusistkkyhntgk2 = pZrntnknyusyusistkkyhntgk2;
    }

    private Long zrnsyusistkappadsyoyougk;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSYUSISTKAPPADSYOYOUGK)
    public Long getZrnsyusistkappadsyoyougk() {
        return zrnsyusistkappadsyoyougk;
    }

    public void setZrnsyusistkappadsyoyougk(Long pZrnsyusistkappadsyoyougk) {
        zrnsyusistkappadsyoyougk = pZrnsyusistkappadsyoyougk;
    }

    private Long zrnsyusistkdtisyukyhntgk;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSYUSISTKDTISYUKYHNTGK)
    public Long getZrnsyusistkdtisyukyhntgk() {
        return zrnsyusistkdtisyukyhntgk;
    }

    public void setZrnsyusistkdtisyukyhntgk(Long pZrnsyusistkdtisyukyhntgk) {
        zrnsyusistkdtisyukyhntgk = pZrnsyusistkdtisyukyhntgk;
    }

    private Long zrnyobin11x8;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOBIN11X8)
    public Long getZrnyobin11x8() {
        return zrnyobin11x8;
    }

    public void setZrnyobin11x8(Long pZrnyobin11x8) {
        zrnyobin11x8 = pZrnyobin11x8;
    }

    private Long zrnyobin11x9;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOBIN11X9)
    public Long getZrnyobin11x9() {
        return zrnyobin11x9;
    }

    public void setZrnyobin11x9(Long pZrnyobin11x9) {
        zrnyobin11x9 = pZrnyobin11x9;
    }

    private Long zrnyobin11x10;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOBIN11X10)
    public Long getZrnyobin11x10() {
        return zrnyobin11x10;
    }

    public void setZrnyobin11x10(Long pZrnyobin11x10) {
        zrnyobin11x10 = pZrnyobin11x10;
    }

    private Long zrnyobin11x11;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOBIN11X11)
    public Long getZrnyobin11x11() {
        return zrnyobin11x11;
    }

    public void setZrnyobin11x11(Long pZrnyobin11x11) {
        zrnyobin11x11 = pZrnyobin11x11;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private BizNumber zrnkawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNKAWASERATE)
    public BizNumber getZrnkawaserate() {
        return zrnkawaserate;
    }

    public void setZrnkawaserate(BizNumber pZrnkawaserate) {
        zrnkawaserate = pZrnkawaserate;
    }

    private String zrnkawaseratetekiyouymd;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNKAWASERATETEKIYOUYMD)
    public String getZrnkawaseratetekiyouymd() {
        return zrnkawaseratetekiyouymd;
    }

    public void setZrnkawaseratetekiyouymd(String pZrnkawaseratetekiyouymd) {
        zrnkawaseratetekiyouymd = pZrnkawaseratetekiyouymd;
    }

    private BizNumber zrnkeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZrnkeiyakujiyoteiriritu() {
        return zrnkeiyakujiyoteiriritu;
    }

    public void setZrnkeiyakujiyoteiriritu(BizNumber pZrnkeiyakujiyoteiriritu) {
        zrnkeiyakujiyoteiriritu = pZrnkeiyakujiyoteiriritu;
    }

    private Long zrnenkdtsbujsitihsyukngk;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNENKDTSBUJSITIHSYUKNGK)
    public Long getZrnenkdtsbujsitihsyukngk() {
        return zrnenkdtsbujsitihsyukngk;
    }

    public void setZrnenkdtsbujsitihsyukngk(Long pZrnenkdtsbujsitihsyukngk) {
        zrnenkdtsbujsitihsyukngk = pZrnenkdtsbujsitihsyukngk;
    }

    private Long zrntumitatekin;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTUMITATEKIN)
    public Long getZrntumitatekin() {
        return zrntumitatekin;
    }

    public void setZrntumitatekin(Long pZrntumitatekin) {
        zrntumitatekin = pZrntumitatekin;
    }

    private Long zrnkiharaikomip;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNKIHARAIKOMIP)
    public Long getZrnkiharaikomip() {
        return zrnkiharaikomip;
    }

    public void setZrnkiharaikomip(Long pZrnkiharaikomip) {
        zrnkiharaikomip = pZrnkiharaikomip;
    }

    private Long zrngaikadatesyukeiyakup;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNGAIKADATESYUKEIYAKUP)
    public Long getZrngaikadatesyukeiyakup() {
        return zrngaikadatesyukeiyakup;
    }

    public void setZrngaikadatesyukeiyakup(Long pZrngaikadatesyukeiyakup) {
        zrngaikadatesyukeiyakup = pZrngaikadatesyukeiyakup;
    }

    private String zrntuukasyukbn;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTUUKASYUKBN)
    public String getZrntuukasyukbn() {
        return zrntuukasyukbn;
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        zrntuukasyukbn = pZrntuukasyukbn;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }

    private Long zrnnksjitirttumitatekin;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNNKSJITIRTTUMITATEKIN)
    public Long getZrnnksjitirttumitatekin() {
        return zrnnksjitirttumitatekin;
    }

    public void setZrnnksjitirttumitatekin(Long pZrnnksjitirttumitatekin) {
        zrnnksjitirttumitatekin = pZrnnksjitirttumitatekin;
    }

    private Long zrnsisuurentumitatekin;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSISUURENTUMITATEKIN)
    public Long getZrnsisuurentumitatekin() {
        return zrnsisuurentumitatekin;
    }

    public void setZrnsisuurentumitatekin(Long pZrnsisuurentumitatekin) {
        zrnsisuurentumitatekin = pZrnsisuurentumitatekin;
    }

    private Long zrnsyukeiyakup;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSYUKEIYAKUP)
    public Long getZrnsyukeiyakup() {
        return zrnsyukeiyakup;
    }

    public void setZrnsyukeiyakup(Long pZrnsyukeiyakup) {
        zrnsyukeiyakup = pZrnsyukeiyakup;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private BizNumber zrnyoteiririturironbase;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOTEIRIRITURIRONBASE)
    public BizNumber getZrnyoteiririturironbase() {
        return zrnyoteiririturironbase;
    }

    public void setZrnyoteiririturironbase(BizNumber pZrnyoteiririturironbase) {
        zrnyoteiririturironbase = pZrnyoteiririturironbase;
    }

    private Long zrngkdtyknndsyoyougakuyou;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNGKDTYKNNDSYOYOUGAKUYOU)
    public Long getZrngkdtyknndsyoyougakuyou() {
        return zrngkdtyknndsyoyougakuyou;
    }

    public void setZrngkdtyknndsyoyougakuyou(Long pZrngkdtyknndsyoyougakuyou) {
        zrngkdtyknndsyoyougakuyou = pZrngkdtyknndsyoyougakuyou;
    }

    private Long zrngkdtykyknndsyoyougakuyou;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNGKDTYKYKNNDSYOYOUGAKUYOU)
    public Long getZrngkdtykyknndsyoyougakuyou() {
        return zrngkdtykyknndsyoyougakuyou;
    }

    public void setZrngkdtykyknndsyoyougakuyou(Long pZrngkdtykyknndsyoyougakuyou) {
        zrngkdtykyknndsyoyougakuyou = pZrngkdtykyknndsyoyougakuyou;
    }

    private BizNumber zrndkeisanjikwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNDKEISANJIKWSRATE)
    public BizNumber getZrndkeisanjikwsrate() {
        return zrndkeisanjikwsrate;
    }

    public void setZrndkeisanjikwsrate(BizNumber pZrndkeisanjikwsrate) {
        zrndkeisanjikwsrate = pZrndkeisanjikwsrate;
    }

    private String zrndkeisanjikwsratetkyymd;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNDKEISANJIKWSRATETKYYMD)
    public String getZrndkeisanjikwsratetkyymd() {
        return zrndkeisanjikwsratetkyymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrndkeisanjikwsratetkyymd(String pZrndkeisanjikwsratetkyymd) {
        zrndkeisanjikwsratetkyymd = pZrndkeisanjikwsratetkyymd;
    }

    private String zrnyobiv6;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOBIV6)
    public String getZrnyobiv6() {
        return zrnyobiv6;
    }

    public void setZrnyobiv6(String pZrnyobiv6) {
        zrnyobiv6 = pZrnyobiv6;
    }

    private String zrnyobiv6x2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOBIV6X2)
    public String getZrnyobiv6x2() {
        return zrnyobiv6x2;
    }

    public void setZrnyobiv6x2(String pZrnyobiv6x2) {
        zrnyobiv6x2 = pZrnyobiv6x2;
    }

    private String zrnyobiv6x3;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOBIV6X3)
    public String getZrnyobiv6x3() {
        return zrnyobiv6x3;
    }

    public void setZrnyobiv6x3(String pZrnyobiv6x3) {
        zrnyobiv6x3 = pZrnyobiv6x3;
    }

    private String zrnsrdai1hknkkn;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNSRDAI1HKNKKN)
    public String getZrnsrdai1hknkkn() {
        return zrnsrdai1hknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsrdai1hknkkn(String pZrnsrdai1hknkkn) {
        zrnsrdai1hknkkn = pZrnsrdai1hknkkn;
    }

    private String zrnyobiv5;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNYOBIV5)
    public String getZrnyobiv5() {
        return zrnyobiv5;
    }

    public void setZrnyobiv5(String pZrnyobiv5) {
        zrnyobiv5 = pZrnyobiv5;
    }

    private String zrntokuyakukoumokuv120;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120)
    public String getZrntokuyakukoumokuv120() {
        return zrntokuyakukoumokuv120;
    }

    public void setZrntokuyakukoumokuv120(String pZrntokuyakukoumokuv120) {
        zrntokuyakukoumokuv120 = pZrntokuyakukoumokuv120;
    }

    private String zrntokuyakukoumokuv120x2;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X2)
    public String getZrntokuyakukoumokuv120x2() {
        return zrntokuyakukoumokuv120x2;
    }

    public void setZrntokuyakukoumokuv120x2(String pZrntokuyakukoumokuv120x2) {
        zrntokuyakukoumokuv120x2 = pZrntokuyakukoumokuv120x2;
    }

    private String zrntokuyakukoumokuv120x3;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X3)
    public String getZrntokuyakukoumokuv120x3() {
        return zrntokuyakukoumokuv120x3;
    }

    public void setZrntokuyakukoumokuv120x3(String pZrntokuyakukoumokuv120x3) {
        zrntokuyakukoumokuv120x3 = pZrntokuyakukoumokuv120x3;
    }

    private String zrntokuyakukoumokuv120x4;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X4)
    public String getZrntokuyakukoumokuv120x4() {
        return zrntokuyakukoumokuv120x4;
    }

    public void setZrntokuyakukoumokuv120x4(String pZrntokuyakukoumokuv120x4) {
        zrntokuyakukoumokuv120x4 = pZrntokuyakukoumokuv120x4;
    }

    private String zrntokuyakukoumokuv120x5;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X5)
    public String getZrntokuyakukoumokuv120x5() {
        return zrntokuyakukoumokuv120x5;
    }

    public void setZrntokuyakukoumokuv120x5(String pZrntokuyakukoumokuv120x5) {
        zrntokuyakukoumokuv120x5 = pZrntokuyakukoumokuv120x5;
    }

    private String zrntokuyakukoumokuv120x6;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X6)
    public String getZrntokuyakukoumokuv120x6() {
        return zrntokuyakukoumokuv120x6;
    }

    public void setZrntokuyakukoumokuv120x6(String pZrntokuyakukoumokuv120x6) {
        zrntokuyakukoumokuv120x6 = pZrntokuyakukoumokuv120x6;
    }

    private String zrntokuyakukoumokuv120x7;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X7)
    public String getZrntokuyakukoumokuv120x7() {
        return zrntokuyakukoumokuv120x7;
    }

    public void setZrntokuyakukoumokuv120x7(String pZrntokuyakukoumokuv120x7) {
        zrntokuyakukoumokuv120x7 = pZrntokuyakukoumokuv120x7;
    }

    private String zrntokuyakukoumokuv120x8;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X8)
    public String getZrntokuyakukoumokuv120x8() {
        return zrntokuyakukoumokuv120x8;
    }

    public void setZrntokuyakukoumokuv120x8(String pZrntokuyakukoumokuv120x8) {
        zrntokuyakukoumokuv120x8 = pZrntokuyakukoumokuv120x8;
    }

    private String zrntokuyakukoumokuv120x9;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X9)
    public String getZrntokuyakukoumokuv120x9() {
        return zrntokuyakukoumokuv120x9;
    }

    public void setZrntokuyakukoumokuv120x9(String pZrntokuyakukoumokuv120x9) {
        zrntokuyakukoumokuv120x9 = pZrntokuyakukoumokuv120x9;
    }

    private String zrntokuyakukoumokuv120x10;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X10)
    public String getZrntokuyakukoumokuv120x10() {
        return zrntokuyakukoumokuv120x10;
    }

    public void setZrntokuyakukoumokuv120x10(String pZrntokuyakukoumokuv120x10) {
        zrntokuyakukoumokuv120x10 = pZrntokuyakukoumokuv120x10;
    }

    private String zrntokuyakukoumokuv120x11;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X11)
    public String getZrntokuyakukoumokuv120x11() {
        return zrntokuyakukoumokuv120x11;
    }

    public void setZrntokuyakukoumokuv120x11(String pZrntokuyakukoumokuv120x11) {
        zrntokuyakukoumokuv120x11 = pZrntokuyakukoumokuv120x11;
    }

    private String zrntokuyakukoumokuv120x12;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X12)
    public String getZrntokuyakukoumokuv120x12() {
        return zrntokuyakukoumokuv120x12;
    }

    public void setZrntokuyakukoumokuv120x12(String pZrntokuyakukoumokuv120x12) {
        zrntokuyakukoumokuv120x12 = pZrntokuyakukoumokuv120x12;
    }

    private String zrntokuyakukoumokuv120x13;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X13)
    public String getZrntokuyakukoumokuv120x13() {
        return zrntokuyakukoumokuv120x13;
    }

    public void setZrntokuyakukoumokuv120x13(String pZrntokuyakukoumokuv120x13) {
        zrntokuyakukoumokuv120x13 = pZrntokuyakukoumokuv120x13;
    }

    private String zrntokuyakukoumokuv120x14;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X14)
    public String getZrntokuyakukoumokuv120x14() {
        return zrntokuyakukoumokuv120x14;
    }

    public void setZrntokuyakukoumokuv120x14(String pZrntokuyakukoumokuv120x14) {
        zrntokuyakukoumokuv120x14 = pZrntokuyakukoumokuv120x14;
    }

    private String zrntokuyakukoumokuv120x15;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X15)
    public String getZrntokuyakukoumokuv120x15() {
        return zrntokuyakukoumokuv120x15;
    }

    public void setZrntokuyakukoumokuv120x15(String pZrntokuyakukoumokuv120x15) {
        zrntokuyakukoumokuv120x15 = pZrntokuyakukoumokuv120x15;
    }

    private String zrntokuyakukoumokuv120x16;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X16)
    public String getZrntokuyakukoumokuv120x16() {
        return zrntokuyakukoumokuv120x16;
    }

    public void setZrntokuyakukoumokuv120x16(String pZrntokuyakukoumokuv120x16) {
        zrntokuyakukoumokuv120x16 = pZrntokuyakukoumokuv120x16;
    }

    private String zrntokuyakukoumokuv120x17;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X17)
    public String getZrntokuyakukoumokuv120x17() {
        return zrntokuyakukoumokuv120x17;
    }

    public void setZrntokuyakukoumokuv120x17(String pZrntokuyakukoumokuv120x17) {
        zrntokuyakukoumokuv120x17 = pZrntokuyakukoumokuv120x17;
    }

    private String zrntokuyakukoumokuv120x18;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X18)
    public String getZrntokuyakukoumokuv120x18() {
        return zrntokuyakukoumokuv120x18;
    }

    public void setZrntokuyakukoumokuv120x18(String pZrntokuyakukoumokuv120x18) {
        zrntokuyakukoumokuv120x18 = pZrntokuyakukoumokuv120x18;
    }

    private String zrntokuyakukoumokuv120x19;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X19)
    public String getZrntokuyakukoumokuv120x19() {
        return zrntokuyakukoumokuv120x19;
    }

    public void setZrntokuyakukoumokuv120x19(String pZrntokuyakukoumokuv120x19) {
        zrntokuyakukoumokuv120x19 = pZrntokuyakukoumokuv120x19;
    }

    private String zrntokuyakukoumokuv120x20;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X20)
    public String getZrntokuyakukoumokuv120x20() {
        return zrntokuyakukoumokuv120x20;
    }

    public void setZrntokuyakukoumokuv120x20(String pZrntokuyakukoumokuv120x20) {
        zrntokuyakukoumokuv120x20 = pZrntokuyakukoumokuv120x20;
    }

    private String zrntokuyakukoumokuv120x21;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X21)
    public String getZrntokuyakukoumokuv120x21() {
        return zrntokuyakukoumokuv120x21;
    }

    public void setZrntokuyakukoumokuv120x21(String pZrntokuyakukoumokuv120x21) {
        zrntokuyakukoumokuv120x21 = pZrntokuyakukoumokuv120x21;
    }

    private String zrntokuyakukoumokuv120x22;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X22)
    public String getZrntokuyakukoumokuv120x22() {
        return zrntokuyakukoumokuv120x22;
    }

    public void setZrntokuyakukoumokuv120x22(String pZrntokuyakukoumokuv120x22) {
        zrntokuyakukoumokuv120x22 = pZrntokuyakukoumokuv120x22;
    }

    private String zrntokuyakukoumokuv120x23;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X23)
    public String getZrntokuyakukoumokuv120x23() {
        return zrntokuyakukoumokuv120x23;
    }

    public void setZrntokuyakukoumokuv120x23(String pZrntokuyakukoumokuv120x23) {
        zrntokuyakukoumokuv120x23 = pZrntokuyakukoumokuv120x23;
    }

    private String zrntokuyakukoumokuv120x24;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X24)
    public String getZrntokuyakukoumokuv120x24() {
        return zrntokuyakukoumokuv120x24;
    }

    public void setZrntokuyakukoumokuv120x24(String pZrntokuyakukoumokuv120x24) {
        zrntokuyakukoumokuv120x24 = pZrntokuyakukoumokuv120x24;
    }

    private String zrntokuyakukoumokuv120x25;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X25)
    public String getZrntokuyakukoumokuv120x25() {
        return zrntokuyakukoumokuv120x25;
    }

    public void setZrntokuyakukoumokuv120x25(String pZrntokuyakukoumokuv120x25) {
        zrntokuyakukoumokuv120x25 = pZrntokuyakukoumokuv120x25;
    }

    private String zrntokuyakukoumokuv120x26;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X26)
    public String getZrntokuyakukoumokuv120x26() {
        return zrntokuyakukoumokuv120x26;
    }

    public void setZrntokuyakukoumokuv120x26(String pZrntokuyakukoumokuv120x26) {
        zrntokuyakukoumokuv120x26 = pZrntokuyakukoumokuv120x26;
    }

    private String zrntokuyakukoumokuv120x27;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X27)
    public String getZrntokuyakukoumokuv120x27() {
        return zrntokuyakukoumokuv120x27;
    }

    public void setZrntokuyakukoumokuv120x27(String pZrntokuyakukoumokuv120x27) {
        zrntokuyakukoumokuv120x27 = pZrntokuyakukoumokuv120x27;
    }

    private String zrntokuyakukoumokuv120x28;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X28)
    public String getZrntokuyakukoumokuv120x28() {
        return zrntokuyakukoumokuv120x28;
    }

    public void setZrntokuyakukoumokuv120x28(String pZrntokuyakukoumokuv120x28) {
        zrntokuyakukoumokuv120x28 = pZrntokuyakukoumokuv120x28;
    }

    private String zrntokuyakukoumokuv120x29;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X29)
    public String getZrntokuyakukoumokuv120x29() {
        return zrntokuyakukoumokuv120x29;
    }

    public void setZrntokuyakukoumokuv120x29(String pZrntokuyakukoumokuv120x29) {
        zrntokuyakukoumokuv120x29 = pZrntokuyakukoumokuv120x29;
    }

    private String zrntokuyakukoumokuv120x30;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X30)
    public String getZrntokuyakukoumokuv120x30() {
        return zrntokuyakukoumokuv120x30;
    }

    public void setZrntokuyakukoumokuv120x30(String pZrntokuyakukoumokuv120x30) {
        zrntokuyakukoumokuv120x30 = pZrntokuyakukoumokuv120x30;
    }

    private String zrntokuyakukoumokuv120x31;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X31)
    public String getZrntokuyakukoumokuv120x31() {
        return zrntokuyakukoumokuv120x31;
    }

    public void setZrntokuyakukoumokuv120x31(String pZrntokuyakukoumokuv120x31) {
        zrntokuyakukoumokuv120x31 = pZrntokuyakukoumokuv120x31;
    }

    private String zrntokuyakukoumokuv120x32;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X32)
    public String getZrntokuyakukoumokuv120x32() {
        return zrntokuyakukoumokuv120x32;
    }

    public void setZrntokuyakukoumokuv120x32(String pZrntokuyakukoumokuv120x32) {
        zrntokuyakukoumokuv120x32 = pZrntokuyakukoumokuv120x32;
    }

    private String zrntokuyakukoumokuv120x33;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X33)
    public String getZrntokuyakukoumokuv120x33() {
        return zrntokuyakukoumokuv120x33;
    }

    public void setZrntokuyakukoumokuv120x33(String pZrntokuyakukoumokuv120x33) {
        zrntokuyakukoumokuv120x33 = pZrntokuyakukoumokuv120x33;
    }

    private String zrntokuyakukoumokuv120x34;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X34)
    public String getZrntokuyakukoumokuv120x34() {
        return zrntokuyakukoumokuv120x34;
    }

    public void setZrntokuyakukoumokuv120x34(String pZrntokuyakukoumokuv120x34) {
        zrntokuyakukoumokuv120x34 = pZrntokuyakukoumokuv120x34;
    }

    private String zrntokuyakukoumokuv120x35;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X35)
    public String getZrntokuyakukoumokuv120x35() {
        return zrntokuyakukoumokuv120x35;
    }

    public void setZrntokuyakukoumokuv120x35(String pZrntokuyakukoumokuv120x35) {
        zrntokuyakukoumokuv120x35 = pZrntokuyakukoumokuv120x35;
    }

    private String zrntokuyakukoumokuv120x36;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X36)
    public String getZrntokuyakukoumokuv120x36() {
        return zrntokuyakukoumokuv120x36;
    }

    public void setZrntokuyakukoumokuv120x36(String pZrntokuyakukoumokuv120x36) {
        zrntokuyakukoumokuv120x36 = pZrntokuyakukoumokuv120x36;
    }

    private String zrntokuyakukoumokuv120x37;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X37)
    public String getZrntokuyakukoumokuv120x37() {
        return zrntokuyakukoumokuv120x37;
    }

    public void setZrntokuyakukoumokuv120x37(String pZrntokuyakukoumokuv120x37) {
        zrntokuyakukoumokuv120x37 = pZrntokuyakukoumokuv120x37;
    }

    private String zrntokuyakukoumokuv120x38;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X38)
    public String getZrntokuyakukoumokuv120x38() {
        return zrntokuyakukoumokuv120x38;
    }

    public void setZrntokuyakukoumokuv120x38(String pZrntokuyakukoumokuv120x38) {
        zrntokuyakukoumokuv120x38 = pZrntokuyakukoumokuv120x38;
    }

    private String zrntokuyakukoumokuv120x39;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X39)
    public String getZrntokuyakukoumokuv120x39() {
        return zrntokuyakukoumokuv120x39;
    }

    public void setZrntokuyakukoumokuv120x39(String pZrntokuyakukoumokuv120x39) {
        zrntokuyakukoumokuv120x39 = pZrntokuyakukoumokuv120x39;
    }

    private String zrntokuyakukoumokuv120x40;

    @Column(name=GenZT_RisaTjHitNplusZeroRn.ZRNTOKUYAKUKOUMOKUV120X40)
    public String getZrntokuyakukoumokuv120x40() {
        return zrntokuyakukoumokuv120x40;
    }

    public void setZrntokuyakukoumokuv120x40(String pZrntokuyakukoumokuv120x40) {
        zrntokuyakukoumokuv120x40 = pZrntokuyakukoumokuv120x40;
    }
}