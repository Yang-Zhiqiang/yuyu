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
import yuyu.def.db.entity.ZT_RisaTjHitNplusZeroTy;
import yuyu.def.db.id.PKZT_RisaTjHitNplusZeroTy;
import yuyu.def.db.meta.GenQZT_RisaTjHitNplusZeroTy;
import yuyu.def.db.meta.QZT_RisaTjHitNplusZeroTy;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ＋０）テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_RisaTjHitNplusZeroTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RisaTjHitNplusZeroTy}</td><td colspan="3">利差のみ通常配当所要額Ｆ（Ｎ＋０）テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_RisaTjHitNplusZeroTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyuukourecordlength ztyyuukourecordlength}</td><td>（中継用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrdwarea ztyrdwarea}</td><td>（中継用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyerrkbnv1 ztyerrkbnv1}</td><td>（中継用）エラー区分Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyratekbn ztyratekbn}</td><td>（中継用）レート区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuurisyuruicd ztysuurisyuruicd}</td><td>（中継用）数理種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2 ztyyobiv2}</td><td>（中継用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentkbn ztykbnkeiriyousegmentkbn}</td><td>（中継用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyourgnbnskkbn ztykbnkeiriyourgnbnskkbn}</td><td>（中継用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x1 ztyhokensyuruikigouyobi1x1}</td><td>（中継用）保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x2 ztyhokensyuruikigouyobi1x2}</td><td>（中継用）保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x3 ztyhokensyuruikigouyobi1x3}</td><td>（中継用）保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x4 ztyhokensyuruikigouyobi1x4}</td><td>（中継用）保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x5 ztyhokensyuruikigouyobi1x5}</td><td>（中継用）保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x6 ztyhokensyuruikigouyobi1x6}</td><td>（中継用）保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x7 ztyhokensyuruikigouyobi1x7}</td><td>（中継用）保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x8 ztyhokensyuruikigouyobi1x8}</td><td>（中継用）保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x9 ztyhokensyuruikigouyobi1x9}</td><td>（中継用）保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x10 ztyhokensyuruikigouyobi1x10}</td><td>（中継用）保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x11 ztyhokensyuruikigouyobi1x11}</td><td>（中継用）保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x12 ztyhokensyuruikigouyobi1x12}</td><td>（中継用）保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x13 ztyhokensyuruikigouyobi1x13}</td><td>（中継用）保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x14 ztyhokensyuruikigouyobi1x14}</td><td>（中継用）保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x15 ztyhokensyuruikigouyobi1x15}</td><td>（中継用）保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x1 ztyhokensyuruikigouyobi2x1}</td><td>（中継用）保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x2 ztyhokensyuruikigouyobi2x2}</td><td>（中継用）保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x3 ztyhokensyuruikigouyobi2x3}</td><td>（中継用）保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x4 ztyhokensyuruikigouyobi2x4}</td><td>（中継用）保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x5 ztyhokensyuruikigouyobi2x5}</td><td>（中継用）保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x6 ztyhokensyuruikigouyobi2x6}</td><td>（中継用）保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x7 ztyhokensyuruikigouyobi2x7}</td><td>（中継用）保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x8 ztyhokensyuruikigouyobi2x8}</td><td>（中継用）保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x9 ztyhokensyuruikigouyobi2x9}</td><td>（中継用）保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x10 ztyhokensyuruikigouyobi2x10}</td><td>（中継用）保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x1 ztyhokensyuruikigouyobi3x1}</td><td>（中継用）保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x2 ztyhokensyuruikigouyobi3x2}</td><td>（中継用）保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x3 ztyhokensyuruikigouyobi3x3}</td><td>（中継用）保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x4 ztyhokensyuruikigouyobi3x4}</td><td>（中継用）保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x5 ztyhokensyuruikigouyobi3x5}</td><td>（中継用）保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x6 ztyhokensyuruikigouyobi3x6}</td><td>（中継用）保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x7 ztyhokensyuruikigouyobi3x7}</td><td>（中継用）保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x8 ztyhokensyuruikigouyobi3x8}</td><td>（中継用）保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x9 ztyhokensyuruikigouyobi3x9}</td><td>（中継用）保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x10 ztyhokensyuruikigouyobi3x10}</td><td>（中継用）保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyharaikatakbn ztyharaikatakbn}</td><td>（中継用）払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakunendo ztykeiyakunendo}</td><td>（中継用）契約年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakum ztykeiyakum}</td><td>（中継用）契約月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyaagev2 ztyhihokensyaagev2}</td><td>（中継用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZty5nenmeoutoubikbn zty5nenmeoutoubikbn}</td><td>（中継用）５年目応当日区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeijyouym ztykeijyouym}</td><td>（中継用）計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuoutoubikbn ztykeiyakuoutoubikbn}</td><td>（中継用）契約応当日区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1 ztysuuriyouyobin1}</td><td>（中継用）数理用予備項目Ｎ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin11 ztysuuriyouyobin11}</td><td>（中継用）数理用予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisitutokuyakuhukasuu ztysaisitutokuyakuhukasuu}</td><td>（中継用）災疾特約付加数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykihons ztykihons}</td><td>（中継用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysibous ztysibous}</td><td>（中継用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytounendmtwrhrgkruikeigk ztytounendmtwrhrgkruikeigk}</td><td>（中継用）当年度末割振額累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtywarihurigakurisoku1 ztywarihurigakurisoku1}</td><td>（中継用）割振額利息１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtywarihurigakurisoku2 ztywarihurigakurisoku2}</td><td>（中継用）割振額利息２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyokunendosyoyougakuyou ztyyokunendosyoyougakuyou}</td><td>（中継用）翌年度所要額用</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyokuyokunendosyoyougkyou ztyyokuyokunendosyoyougkyou}</td><td>（中継用）翌々年度所要額用</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyuukoutyuusyoyougaku ztyyuukoutyuusyoyougaku}</td><td>（中継用）有効中所要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyoumetuyousyoyougaku1 ztysyoumetuyousyoyougaku1}</td><td>（中継用）消滅用所要額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyoumetuyousyoyougaku2 ztysyoumetuyousyoyougaku2}</td><td>（中継用）消滅用所要額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanyousyoyougaku1 ztytenkanyousyoyougaku1}</td><td>（中継用）転換用所要額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanyousyoyougaku2 ztytenkanyousyoyougaku2}</td><td>（中継用）転換用所要額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyutuujyoudsyoyougk1 ztytnknyutuujyoudsyoyougk1}</td><td>（中継用）転換用通常Ｄ所要額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyutuujyoudsyoyougk2 ztytnknyutuujyoudsyoyougk2}</td><td>（中継用）転換用通常Ｄ所要額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyuhrkbbnksyoyougk1 ztytnknyuhrkbbnksyoyougk1}</td><td>（中継用）転換用払込部分Ｋ所要額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyuhrkbbnksyoyougk2 ztytnknyuhrkbbnksyoyougk2}</td><td>（中継用）転換用払込部分Ｋ所要額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyuhrkbbnknnknsnp1 ztytnknyuhrkbbnknnknsnp1}</td><td>（中継用）転換用払込部分Ｋ年換算Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyuhrkbbnknnknsnp2 ztytnknyuhrkbbnknnknsnp2}</td><td>（中継用）転換用払込部分Ｋ年換算Ｐ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyutnknhktgksyoyougk1 ztytnknyutnknhktgksyoyougk1}</td><td>（中継用）転換用転換引継Ｋ所要額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyutnknhktgksyoyougk2 ztytnknyutnknhktgksyoyougk2}</td><td>（中継用）転換用転換引継Ｋ所要額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyutnknhktgknnknsnp1 ztytnknyutnknhktgknnknsnp1}</td><td>（中継用）転換用転換引継Ｋ年換算Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyutnknhktgknnknsnp2 ztytnknyutnknhktgknnknsnp2}</td><td>（中継用）転換用転換引継Ｋ年換算Ｐ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyusaisituksyoyougk1 ztytnknyusaisituksyoyougk1}</td><td>（中継用）転換用災疾Ｋ所要額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyusaisituksyoyougk2 ztytnknyusaisituksyoyougk2}</td><td>（中継用）転換用災疾Ｋ所要額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyusaisitukkyhntgk1 ztytnknyusaisitukkyhntgk1}</td><td>（中継用）転換用災疾Ｋ給付日額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyusaisitukkyhntgk2 ztytnknyusaisitukkyhntgk2}</td><td>（中継用）転換用災疾Ｋ給付日額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhrkbbnkdsyoyougk ztyhrkbbnkdsyoyougk}</td><td>（中継用）払込部分ＫＤ所要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhrkbbnkdtisyunnknsnp ztyhrkbbnkdtisyunnknsnp}</td><td>（中継用）払込部分ＫＤ対象年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytusangohrkbbnkappad ztytusangohrkbbnkappad}</td><td>（中継用）通算後払込部分カッパーＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknhktgkdsyoyougk ztytnknhktgkdsyoyougk}</td><td>（中継用）転換引継ＫＤ所要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknhktgkdtisyunenknsnp ztytnknhktgkdtisyunenknsnp}</td><td>（中継用）転換引継ＫＤ対象年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytusangotnknhktgkappad ztytusangotnknhktgkappad}</td><td>（中継用）通算後転換引継カッパーＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytuusangohutuusiboukappad ztytuusangohutuusiboukappad}</td><td>（中継用）通算後普通死亡カッパーＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysaisitukappadsyoyougaku ztysaisitukappadsyoyougaku}</td><td>（中継用）災疾カッパーＤ所要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytuusangosaisitukappad ztytuusangosaisitukappad}</td><td>（中継用）通算後災疾カッパーＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysistkappadtisyukyhntgk ztysistkappadtisyukyhntgk}</td><td>（中継用）災疾カッパーＤ対象給付日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytuusangogoukeikappad ztytuusangogoukeikappad}</td><td>（中継用）通算後合計カッパーＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydtaisyouv ztydtaisyouv}</td><td>（中継用）Ｄ対象Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydaihyouyoteiriritu ztydaihyouyoteiriritu}</td><td>（中継用）代表予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrt ztyknkuzusnzyrt}</td><td>（中継用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbn ztyzyrthntiyustatuskbn}</td><td>（中継用）乗率判定用ステータス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7 ztyyobiv7}</td><td>（中継用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknyusyusistksyoyougk1 ztytnknyusyusistksyoyougk1}</td><td>（中継用）転換用主契約災疾Ｋ所要額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyusyusistksyoyougk2 ztytnknyusyusistksyoyougk2}</td><td>（中継用）転換用主契約災疾Ｋ所要額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyusyusistkkyhntgk1 ztytnknyusyusistkkyhntgk1}</td><td>（中継用）転換用主契約災疾Ｋ給付日額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknyusyusistkkyhntgk2 ztytnknyusyusistkkyhntgk2}</td><td>（中継用）転換用主契約災疾Ｋ給付日額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyusistkappadsyoyougk ztysyusistkappadsyoyougk}</td><td>（中継用）主契約災疾カッパーＤ所要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyusistkdtisyukyhntgk ztysyusistkdtisyukyhntgk}</td><td>（中継用）主契約災疾ＫＤ対象給付日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x8 ztyyobin11x8}</td><td>（中継用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x9 ztyyobin11x9}</td><td>（中継用）予備項目Ｎ１１＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x10 ztyyobin11x10}</td><td>（中継用）予備項目Ｎ１１＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x11 ztyyobin11x11}</td><td>（中継用）予備項目Ｎ１１＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaserate ztykawaserate}</td><td>（中継用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaseratetekiyouymd ztykawaseratetekiyouymd}</td><td>（中継用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakujiyoteiriritu ztykeiyakujiyoteiriritu}</td><td>（中継用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyenkdtsbujsitihsyukngk ztyenkdtsbujsitihsyukngk}</td><td>（中継用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytumitatekin ztytumitatekin}</td><td>（中継用）積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykiharaikomip ztykiharaikomip}</td><td>（中継用）既払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatesyukeiyakup ztygaikadatesyukeiyakup}</td><td>（中継用）外貨建主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytuukasyukbn ztytuukasyukbn}</td><td>（中継用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1 ztyyobiv1}</td><td>（中継用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksjitirttumitatekin ztynksjitirttumitatekin}</td><td>（中継用）年金開始時定率部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysisuurentumitatekin ztysisuurentumitatekin}</td><td>（中継用）指数連動部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakup ztysyukeiyakup}</td><td>（中継用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiririturironbase ztyyoteiririturironbase}</td><td>（中継用）予定利率（理論ベース）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtygkdtyknndsyoyougakuyou ztygkdtyknndsyoyougakuyou}</td><td>（中継用）外貨建翌年度所要額用</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygkdtykyknndsyoyougakuyou ztygkdtykyknndsyoyougakuyou}</td><td>（中継用）外貨建翌々年度所要額用</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydkeisanjikwsrate ztydkeisanjikwsrate}</td><td>（中継用）Ｄ計算時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtydkeisanjikwsratetkyymd ztydkeisanjikwsratetkyymd}</td><td>（中継用）Ｄ計算時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6 ztyyobiv6}</td><td>（中継用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6x2 ztyyobiv6x2}</td><td>（中継用）予備項目Ｖ６＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6x3 ztyyobiv6x3}</td><td>（中継用）予備項目Ｖ６＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrdai1hknkkn ztysrdai1hknkkn}</td><td>（中継用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv5 ztyyobiv5}</td><td>（中継用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120 ztytokuyakukoumokuv120}</td><td>（中継用）特約項目Ｖ１２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x2 ztytokuyakukoumokuv120x2}</td><td>（中継用）特約項目Ｖ１２０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x3 ztytokuyakukoumokuv120x3}</td><td>（中継用）特約項目Ｖ１２０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x4 ztytokuyakukoumokuv120x4}</td><td>（中継用）特約項目Ｖ１２０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x5 ztytokuyakukoumokuv120x5}</td><td>（中継用）特約項目Ｖ１２０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x6 ztytokuyakukoumokuv120x6}</td><td>（中継用）特約項目Ｖ１２０＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x7 ztytokuyakukoumokuv120x7}</td><td>（中継用）特約項目Ｖ１２０＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x8 ztytokuyakukoumokuv120x8}</td><td>（中継用）特約項目Ｖ１２０＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x9 ztytokuyakukoumokuv120x9}</td><td>（中継用）特約項目Ｖ１２０＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x10 ztytokuyakukoumokuv120x10}</td><td>（中継用）特約項目Ｖ１２０＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x11 ztytokuyakukoumokuv120x11}</td><td>（中継用）特約項目Ｖ１２０＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x12 ztytokuyakukoumokuv120x12}</td><td>（中継用）特約項目Ｖ１２０＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x13 ztytokuyakukoumokuv120x13}</td><td>（中継用）特約項目Ｖ１２０＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x14 ztytokuyakukoumokuv120x14}</td><td>（中継用）特約項目Ｖ１２０＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x15 ztytokuyakukoumokuv120x15}</td><td>（中継用）特約項目Ｖ１２０＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x16 ztytokuyakukoumokuv120x16}</td><td>（中継用）特約項目Ｖ１２０＿１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x17 ztytokuyakukoumokuv120x17}</td><td>（中継用）特約項目Ｖ１２０＿１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x18 ztytokuyakukoumokuv120x18}</td><td>（中継用）特約項目Ｖ１２０＿１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x19 ztytokuyakukoumokuv120x19}</td><td>（中継用）特約項目Ｖ１２０＿１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x20 ztytokuyakukoumokuv120x20}</td><td>（中継用）特約項目Ｖ１２０＿２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x21 ztytokuyakukoumokuv120x21}</td><td>（中継用）特約項目Ｖ１２０＿２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x22 ztytokuyakukoumokuv120x22}</td><td>（中継用）特約項目Ｖ１２０＿２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x23 ztytokuyakukoumokuv120x23}</td><td>（中継用）特約項目Ｖ１２０＿２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x24 ztytokuyakukoumokuv120x24}</td><td>（中継用）特約項目Ｖ１２０＿２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x25 ztytokuyakukoumokuv120x25}</td><td>（中継用）特約項目Ｖ１２０＿２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x26 ztytokuyakukoumokuv120x26}</td><td>（中継用）特約項目Ｖ１２０＿２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x27 ztytokuyakukoumokuv120x27}</td><td>（中継用）特約項目Ｖ１２０＿２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x28 ztytokuyakukoumokuv120x28}</td><td>（中継用）特約項目Ｖ１２０＿２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x29 ztytokuyakukoumokuv120x29}</td><td>（中継用）特約項目Ｖ１２０＿２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x30 ztytokuyakukoumokuv120x30}</td><td>（中継用）特約項目Ｖ１２０＿３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x31 ztytokuyakukoumokuv120x31}</td><td>（中継用）特約項目Ｖ１２０＿３１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x32 ztytokuyakukoumokuv120x32}</td><td>（中継用）特約項目Ｖ１２０＿３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x33 ztytokuyakukoumokuv120x33}</td><td>（中継用）特約項目Ｖ１２０＿３３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x34 ztytokuyakukoumokuv120x34}</td><td>（中継用）特約項目Ｖ１２０＿３４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x35 ztytokuyakukoumokuv120x35}</td><td>（中継用）特約項目Ｖ１２０＿３５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x36 ztytokuyakukoumokuv120x36}</td><td>（中継用）特約項目Ｖ１２０＿３６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x37 ztytokuyakukoumokuv120x37}</td><td>（中継用）特約項目Ｖ１２０＿３７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x38 ztytokuyakukoumokuv120x38}</td><td>（中継用）特約項目Ｖ１２０＿３８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x39 ztytokuyakukoumokuv120x39}</td><td>（中継用）特約項目Ｖ１２０＿３９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv120x40 ztytokuyakukoumokuv120x40}</td><td>（中継用）特約項目Ｖ１２０＿４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_RisaTjHitNplusZeroTy
 * @see     PKZT_RisaTjHitNplusZeroTy
 * @see     QZT_RisaTjHitNplusZeroTy
 * @see     GenQZT_RisaTjHitNplusZeroTy
 */
@MappedSuperclass
@Table(name=GenZT_RisaTjHitNplusZeroTy.TABLE_NAME)
@IdClass(value=PKZT_RisaTjHitNplusZeroTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_RisaTjHitNplusZeroTy extends AbstractExDBEntity<ZT_RisaTjHitNplusZeroTy, PKZT_RisaTjHitNplusZeroTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_RisaTjHitNplusZeroTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYUUKOURECORDLENGTH    = "ztyyuukourecordlength";
    public static final String ZTYRDWAREA               = "ztyrdwarea";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYERRKBNV1              = "ztyerrkbnv1";
    public static final String ZTYRATEKBN               = "ztyratekbn";
    public static final String ZTYSUURISYURUICD         = "ztysuurisyuruicd";
    public static final String ZTYYOBIV2                = "ztyyobiv2";
    public static final String ZTYKBNKEIRIYOUSEGMENTKBN = "ztykbnkeiriyousegmentkbn";
    public static final String ZTYKBNKEIRIYOURGNBNSKKBN = "ztykbnkeiriyourgnbnskkbn";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X1 = "ztyhokensyuruikigouyobi1x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X2 = "ztyhokensyuruikigouyobi1x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X3 = "ztyhokensyuruikigouyobi1x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X4 = "ztyhokensyuruikigouyobi1x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X5 = "ztyhokensyuruikigouyobi1x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X6 = "ztyhokensyuruikigouyobi1x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X7 = "ztyhokensyuruikigouyobi1x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X8 = "ztyhokensyuruikigouyobi1x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X9 = "ztyhokensyuruikigouyobi1x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X10 = "ztyhokensyuruikigouyobi1x10";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X11 = "ztyhokensyuruikigouyobi1x11";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X12 = "ztyhokensyuruikigouyobi1x12";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X13 = "ztyhokensyuruikigouyobi1x13";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X14 = "ztyhokensyuruikigouyobi1x14";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X15 = "ztyhokensyuruikigouyobi1x15";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X1 = "ztyhokensyuruikigouyobi2x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X2 = "ztyhokensyuruikigouyobi2x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X3 = "ztyhokensyuruikigouyobi2x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X4 = "ztyhokensyuruikigouyobi2x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X5 = "ztyhokensyuruikigouyobi2x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X6 = "ztyhokensyuruikigouyobi2x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X7 = "ztyhokensyuruikigouyobi2x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X8 = "ztyhokensyuruikigouyobi2x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X9 = "ztyhokensyuruikigouyobi2x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X10 = "ztyhokensyuruikigouyobi2x10";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X1 = "ztyhokensyuruikigouyobi3x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X2 = "ztyhokensyuruikigouyobi3x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X3 = "ztyhokensyuruikigouyobi3x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X4 = "ztyhokensyuruikigouyobi3x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X5 = "ztyhokensyuruikigouyobi3x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X6 = "ztyhokensyuruikigouyobi3x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X7 = "ztyhokensyuruikigouyobi3x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X8 = "ztyhokensyuruikigouyobi3x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X9 = "ztyhokensyuruikigouyobi3x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X10 = "ztyhokensyuruikigouyobi3x10";
    public static final String ZTYHARAIKATAKBN          = "ztyharaikatakbn";
    public static final String ZTYKEIYAKUNENDO          = "ztykeiyakunendo";
    public static final String ZTYKEIYAKUM              = "ztykeiyakum";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHIHOKENSYAAGEV2       = "ztyhihokensyaagev2";
    public static final String ZTY5NENMEOUTOUBIKBN      = "zty5nenmeoutoubikbn";
    public static final String ZTYKEIJYOUYM             = "ztykeijyouym";
    public static final String ZTYKEIYAKUOUTOUBIKBN     = "ztykeiyakuoutoubikbn";
    public static final String ZTYSUURIYOUYOBIN1        = "ztysuuriyouyobin1";
    public static final String ZTYSUURIYOUYOBIN11       = "ztysuuriyouyobin11";
    public static final String ZTYSAISITUTOKUYAKUHUKASUU = "ztysaisitutokuyakuhukasuu";
    public static final String ZTYKIHONS                = "ztykihons";
    public static final String ZTYSIBOUS                = "ztysibous";
    public static final String ZTYTOUNENDMTWRHRGKRUIKEIGK = "ztytounendmtwrhrgkruikeigk";
    public static final String ZTYWARIHURIGAKURISOKU1   = "ztywarihurigakurisoku1";
    public static final String ZTYWARIHURIGAKURISOKU2   = "ztywarihurigakurisoku2";
    public static final String ZTYYOKUNENDOSYOYOUGAKUYOU = "ztyyokunendosyoyougakuyou";
    public static final String ZTYYOKUYOKUNENDOSYOYOUGKYOU = "ztyyokuyokunendosyoyougkyou";
    public static final String ZTYYUUKOUTYUUSYOYOUGAKU  = "ztyyuukoutyuusyoyougaku";
    public static final String ZTYSYOUMETUYOUSYOYOUGAKU1 = "ztysyoumetuyousyoyougaku1";
    public static final String ZTYSYOUMETUYOUSYOYOUGAKU2 = "ztysyoumetuyousyoyougaku2";
    public static final String ZTYTENKANYOUSYOYOUGAKU1  = "ztytenkanyousyoyougaku1";
    public static final String ZTYTENKANYOUSYOYOUGAKU2  = "ztytenkanyousyoyougaku2";
    public static final String ZTYTNKNYUTUUJYOUDSYOYOUGK1 = "ztytnknyutuujyoudsyoyougk1";
    public static final String ZTYTNKNYUTUUJYOUDSYOYOUGK2 = "ztytnknyutuujyoudsyoyougk2";
    public static final String ZTYTNKNYUHRKBBNKSYOYOUGK1 = "ztytnknyuhrkbbnksyoyougk1";
    public static final String ZTYTNKNYUHRKBBNKSYOYOUGK2 = "ztytnknyuhrkbbnksyoyougk2";
    public static final String ZTYTNKNYUHRKBBNKNNKNSNP1 = "ztytnknyuhrkbbnknnknsnp1";
    public static final String ZTYTNKNYUHRKBBNKNNKNSNP2 = "ztytnknyuhrkbbnknnknsnp2";
    public static final String ZTYTNKNYUTNKNHKTGKSYOYOUGK1 = "ztytnknyutnknhktgksyoyougk1";
    public static final String ZTYTNKNYUTNKNHKTGKSYOYOUGK2 = "ztytnknyutnknhktgksyoyougk2";
    public static final String ZTYTNKNYUTNKNHKTGKNNKNSNP1 = "ztytnknyutnknhktgknnknsnp1";
    public static final String ZTYTNKNYUTNKNHKTGKNNKNSNP2 = "ztytnknyutnknhktgknnknsnp2";
    public static final String ZTYTNKNYUSAISITUKSYOYOUGK1 = "ztytnknyusaisituksyoyougk1";
    public static final String ZTYTNKNYUSAISITUKSYOYOUGK2 = "ztytnknyusaisituksyoyougk2";
    public static final String ZTYTNKNYUSAISITUKKYHNTGK1 = "ztytnknyusaisitukkyhntgk1";
    public static final String ZTYTNKNYUSAISITUKKYHNTGK2 = "ztytnknyusaisitukkyhntgk2";
    public static final String ZTYHRKBBNKDSYOYOUGK      = "ztyhrkbbnkdsyoyougk";
    public static final String ZTYHRKBBNKDTISYUNNKNSNP  = "ztyhrkbbnkdtisyunnknsnp";
    public static final String ZTYTUSANGOHRKBBNKAPPAD   = "ztytusangohrkbbnkappad";
    public static final String ZTYTNKNHKTGKDSYOYOUGK    = "ztytnknhktgkdsyoyougk";
    public static final String ZTYTNKNHKTGKDTISYUNENKNSNP = "ztytnknhktgkdtisyunenknsnp";
    public static final String ZTYTUSANGOTNKNHKTGKAPPAD = "ztytusangotnknhktgkappad";
    public static final String ZTYTUUSANGOHUTUUSIBOUKAPPAD = "ztytuusangohutuusiboukappad";
    public static final String ZTYSAISITUKAPPADSYOYOUGAKU = "ztysaisitukappadsyoyougaku";
    public static final String ZTYTUUSANGOSAISITUKAPPAD = "ztytuusangosaisitukappad";
    public static final String ZTYSISTKAPPADTISYUKYHNTGK = "ztysistkappadtisyukyhntgk";
    public static final String ZTYTUUSANGOGOUKEIKAPPAD  = "ztytuusangogoukeikappad";
    public static final String ZTYDTAISYOUV             = "ztydtaisyouv";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYDAIHYOUYOTEIRIRITU    = "ztydaihyouyoteiriritu";
    public static final String ZTYKNKUZUSNZYRT          = "ztyknkuzusnzyrt";
    public static final String ZTYZYRTHNTIYUSTATUSKBN   = "ztyzyrthntiyustatuskbn";
    public static final String ZTYYOBIV7                = "ztyyobiv7";
    public static final String ZTYTNKNYUSYUSISTKSYOYOUGK1 = "ztytnknyusyusistksyoyougk1";
    public static final String ZTYTNKNYUSYUSISTKSYOYOUGK2 = "ztytnknyusyusistksyoyougk2";
    public static final String ZTYTNKNYUSYUSISTKKYHNTGK1 = "ztytnknyusyusistkkyhntgk1";
    public static final String ZTYTNKNYUSYUSISTKKYHNTGK2 = "ztytnknyusyusistkkyhntgk2";
    public static final String ZTYSYUSISTKAPPADSYOYOUGK = "ztysyusistkappadsyoyougk";
    public static final String ZTYSYUSISTKDTISYUKYHNTGK = "ztysyusistkdtisyukyhntgk";
    public static final String ZTYYOBIN11X8             = "ztyyobin11x8";
    public static final String ZTYYOBIN11X9             = "ztyyobin11x9";
    public static final String ZTYYOBIN11X10            = "ztyyobin11x10";
    public static final String ZTYYOBIN11X11            = "ztyyobin11x11";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYKAWASERATE            = "ztykawaserate";
    public static final String ZTYKAWASERATETEKIYOUYMD  = "ztykawaseratetekiyouymd";
    public static final String ZTYKEIYAKUJIYOTEIRIRITU  = "ztykeiyakujiyoteiriritu";
    public static final String ZTYENKDTSBUJSITIHSYUKNGK = "ztyenkdtsbujsitihsyukngk";
    public static final String ZTYTUMITATEKIN           = "ztytumitatekin";
    public static final String ZTYKIHARAIKOMIP          = "ztykiharaikomip";
    public static final String ZTYGAIKADATESYUKEIYAKUP  = "ztygaikadatesyukeiyakup";
    public static final String ZTYTUUKASYUKBN           = "ztytuukasyukbn";
    public static final String ZTYYOBIV1                = "ztyyobiv1";
    public static final String ZTYNKSJITIRTTUMITATEKIN  = "ztynksjitirttumitatekin";
    public static final String ZTYSISUURENTUMITATEKIN   = "ztysisuurentumitatekin";
    public static final String ZTYSYUKEIYAKUP           = "ztysyukeiyakup";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYYOTEIRIRITURIRONBASE  = "ztyyoteiririturironbase";
    public static final String ZTYGKDTYKNNDSYOYOUGAKUYOU = "ztygkdtyknndsyoyougakuyou";
    public static final String ZTYGKDTYKYKNNDSYOYOUGAKUYOU = "ztygkdtykyknndsyoyougakuyou";
    public static final String ZTYDKEISANJIKWSRATE      = "ztydkeisanjikwsrate";
    public static final String ZTYDKEISANJIKWSRATETKYYMD = "ztydkeisanjikwsratetkyymd";
    public static final String ZTYYOBIV6                = "ztyyobiv6";
    public static final String ZTYYOBIV6X2              = "ztyyobiv6x2";
    public static final String ZTYYOBIV6X3              = "ztyyobiv6x3";
    public static final String ZTYSRDAI1HKNKKN          = "ztysrdai1hknkkn";
    public static final String ZTYYOBIV5                = "ztyyobiv5";
    public static final String ZTYTOKUYAKUKOUMOKUV120   = "ztytokuyakukoumokuv120";
    public static final String ZTYTOKUYAKUKOUMOKUV120X2 = "ztytokuyakukoumokuv120x2";
    public static final String ZTYTOKUYAKUKOUMOKUV120X3 = "ztytokuyakukoumokuv120x3";
    public static final String ZTYTOKUYAKUKOUMOKUV120X4 = "ztytokuyakukoumokuv120x4";
    public static final String ZTYTOKUYAKUKOUMOKUV120X5 = "ztytokuyakukoumokuv120x5";
    public static final String ZTYTOKUYAKUKOUMOKUV120X6 = "ztytokuyakukoumokuv120x6";
    public static final String ZTYTOKUYAKUKOUMOKUV120X7 = "ztytokuyakukoumokuv120x7";
    public static final String ZTYTOKUYAKUKOUMOKUV120X8 = "ztytokuyakukoumokuv120x8";
    public static final String ZTYTOKUYAKUKOUMOKUV120X9 = "ztytokuyakukoumokuv120x9";
    public static final String ZTYTOKUYAKUKOUMOKUV120X10 = "ztytokuyakukoumokuv120x10";
    public static final String ZTYTOKUYAKUKOUMOKUV120X11 = "ztytokuyakukoumokuv120x11";
    public static final String ZTYTOKUYAKUKOUMOKUV120X12 = "ztytokuyakukoumokuv120x12";
    public static final String ZTYTOKUYAKUKOUMOKUV120X13 = "ztytokuyakukoumokuv120x13";
    public static final String ZTYTOKUYAKUKOUMOKUV120X14 = "ztytokuyakukoumokuv120x14";
    public static final String ZTYTOKUYAKUKOUMOKUV120X15 = "ztytokuyakukoumokuv120x15";
    public static final String ZTYTOKUYAKUKOUMOKUV120X16 = "ztytokuyakukoumokuv120x16";
    public static final String ZTYTOKUYAKUKOUMOKUV120X17 = "ztytokuyakukoumokuv120x17";
    public static final String ZTYTOKUYAKUKOUMOKUV120X18 = "ztytokuyakukoumokuv120x18";
    public static final String ZTYTOKUYAKUKOUMOKUV120X19 = "ztytokuyakukoumokuv120x19";
    public static final String ZTYTOKUYAKUKOUMOKUV120X20 = "ztytokuyakukoumokuv120x20";
    public static final String ZTYTOKUYAKUKOUMOKUV120X21 = "ztytokuyakukoumokuv120x21";
    public static final String ZTYTOKUYAKUKOUMOKUV120X22 = "ztytokuyakukoumokuv120x22";
    public static final String ZTYTOKUYAKUKOUMOKUV120X23 = "ztytokuyakukoumokuv120x23";
    public static final String ZTYTOKUYAKUKOUMOKUV120X24 = "ztytokuyakukoumokuv120x24";
    public static final String ZTYTOKUYAKUKOUMOKUV120X25 = "ztytokuyakukoumokuv120x25";
    public static final String ZTYTOKUYAKUKOUMOKUV120X26 = "ztytokuyakukoumokuv120x26";
    public static final String ZTYTOKUYAKUKOUMOKUV120X27 = "ztytokuyakukoumokuv120x27";
    public static final String ZTYTOKUYAKUKOUMOKUV120X28 = "ztytokuyakukoumokuv120x28";
    public static final String ZTYTOKUYAKUKOUMOKUV120X29 = "ztytokuyakukoumokuv120x29";
    public static final String ZTYTOKUYAKUKOUMOKUV120X30 = "ztytokuyakukoumokuv120x30";
    public static final String ZTYTOKUYAKUKOUMOKUV120X31 = "ztytokuyakukoumokuv120x31";
    public static final String ZTYTOKUYAKUKOUMOKUV120X32 = "ztytokuyakukoumokuv120x32";
    public static final String ZTYTOKUYAKUKOUMOKUV120X33 = "ztytokuyakukoumokuv120x33";
    public static final String ZTYTOKUYAKUKOUMOKUV120X34 = "ztytokuyakukoumokuv120x34";
    public static final String ZTYTOKUYAKUKOUMOKUV120X35 = "ztytokuyakukoumokuv120x35";
    public static final String ZTYTOKUYAKUKOUMOKUV120X36 = "ztytokuyakukoumokuv120x36";
    public static final String ZTYTOKUYAKUKOUMOKUV120X37 = "ztytokuyakukoumokuv120x37";
    public static final String ZTYTOKUYAKUKOUMOKUV120X38 = "ztytokuyakukoumokuv120x38";
    public static final String ZTYTOKUYAKUKOUMOKUV120X39 = "ztytokuyakukoumokuv120x39";
    public static final String ZTYTOKUYAKUKOUMOKUV120X40 = "ztytokuyakukoumokuv120x40";

    private final PKZT_RisaTjHitNplusZeroTy primaryKey;

    public GenZT_RisaTjHitNplusZeroTy() {
        primaryKey = new PKZT_RisaTjHitNplusZeroTy();
    }

    public GenZT_RisaTjHitNplusZeroTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_RisaTjHitNplusZeroTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_RisaTjHitNplusZeroTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_RisaTjHitNplusZeroTy> getMetaClass() {
        return QZT_RisaTjHitNplusZeroTy.class;
    }

    @Id
    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztydatakanrino;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

    private String ztyerrkbnv1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYERRKBNV1)
    public String getZtyerrkbnv1() {
        return ztyerrkbnv1;
    }

    public void setZtyerrkbnv1(String pZtyerrkbnv1) {
        ztyerrkbnv1 = pZtyerrkbnv1;
    }

    private String ztyratekbn;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYRATEKBN)
    public String getZtyratekbn() {
        return ztyratekbn;
    }

    public void setZtyratekbn(String pZtyratekbn) {
        ztyratekbn = pZtyratekbn;
    }

    private String ztysuurisyuruicd;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSUURISYURUICD)
    public String getZtysuurisyuruicd() {
        return ztysuurisyuruicd;
    }

    public void setZtysuurisyuruicd(String pZtysuurisyuruicd) {
        ztysuurisyuruicd = pZtysuurisyuruicd;
    }

    private String ztyyobiv2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOBIV2)
    public String getZtyyobiv2() {
        return ztyyobiv2;
    }

    public void setZtyyobiv2(String pZtyyobiv2) {
        ztyyobiv2 = pZtyyobiv2;
    }

    private String ztykbnkeiriyousegmentkbn;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYKBNKEIRIYOUSEGMENTKBN)
    public String getZtykbnkeiriyousegmentkbn() {
        return ztykbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyousegmentkbn(String pZtykbnkeiriyousegmentkbn) {
        ztykbnkeiriyousegmentkbn = pZtykbnkeiriyousegmentkbn;
    }

    private String ztykbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYKBNKEIRIYOURGNBNSKKBN)
    public String getZtykbnkeiriyourgnbnskkbn() {
        return ztykbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyourgnbnskkbn(String pZtykbnkeiriyourgnbnskkbn) {
        ztykbnkeiriyourgnbnskkbn = pZtykbnkeiriyourgnbnskkbn;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztyhokensyuruikigouyobi1x1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X1)
    public String getZtyhokensyuruikigouyobi1x1() {
        return ztyhokensyuruikigouyobi1x1;
    }

    public void setZtyhokensyuruikigouyobi1x1(String pZtyhokensyuruikigouyobi1x1) {
        ztyhokensyuruikigouyobi1x1 = pZtyhokensyuruikigouyobi1x1;
    }

    private String ztyhokensyuruikigouyobi1x2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X2)
    public String getZtyhokensyuruikigouyobi1x2() {
        return ztyhokensyuruikigouyobi1x2;
    }

    public void setZtyhokensyuruikigouyobi1x2(String pZtyhokensyuruikigouyobi1x2) {
        ztyhokensyuruikigouyobi1x2 = pZtyhokensyuruikigouyobi1x2;
    }

    private String ztyhokensyuruikigouyobi1x3;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X3)
    public String getZtyhokensyuruikigouyobi1x3() {
        return ztyhokensyuruikigouyobi1x3;
    }

    public void setZtyhokensyuruikigouyobi1x3(String pZtyhokensyuruikigouyobi1x3) {
        ztyhokensyuruikigouyobi1x3 = pZtyhokensyuruikigouyobi1x3;
    }

    private String ztyhokensyuruikigouyobi1x4;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X4)
    public String getZtyhokensyuruikigouyobi1x4() {
        return ztyhokensyuruikigouyobi1x4;
    }

    public void setZtyhokensyuruikigouyobi1x4(String pZtyhokensyuruikigouyobi1x4) {
        ztyhokensyuruikigouyobi1x4 = pZtyhokensyuruikigouyobi1x4;
    }

    private String ztyhokensyuruikigouyobi1x5;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X5)
    public String getZtyhokensyuruikigouyobi1x5() {
        return ztyhokensyuruikigouyobi1x5;
    }

    public void setZtyhokensyuruikigouyobi1x5(String pZtyhokensyuruikigouyobi1x5) {
        ztyhokensyuruikigouyobi1x5 = pZtyhokensyuruikigouyobi1x5;
    }

    private String ztyhokensyuruikigouyobi1x6;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X6)
    public String getZtyhokensyuruikigouyobi1x6() {
        return ztyhokensyuruikigouyobi1x6;
    }

    public void setZtyhokensyuruikigouyobi1x6(String pZtyhokensyuruikigouyobi1x6) {
        ztyhokensyuruikigouyobi1x6 = pZtyhokensyuruikigouyobi1x6;
    }

    private String ztyhokensyuruikigouyobi1x7;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X7)
    public String getZtyhokensyuruikigouyobi1x7() {
        return ztyhokensyuruikigouyobi1x7;
    }

    public void setZtyhokensyuruikigouyobi1x7(String pZtyhokensyuruikigouyobi1x7) {
        ztyhokensyuruikigouyobi1x7 = pZtyhokensyuruikigouyobi1x7;
    }

    private String ztyhokensyuruikigouyobi1x8;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X8)
    public String getZtyhokensyuruikigouyobi1x8() {
        return ztyhokensyuruikigouyobi1x8;
    }

    public void setZtyhokensyuruikigouyobi1x8(String pZtyhokensyuruikigouyobi1x8) {
        ztyhokensyuruikigouyobi1x8 = pZtyhokensyuruikigouyobi1x8;
    }

    private String ztyhokensyuruikigouyobi1x9;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X9)
    public String getZtyhokensyuruikigouyobi1x9() {
        return ztyhokensyuruikigouyobi1x9;
    }

    public void setZtyhokensyuruikigouyobi1x9(String pZtyhokensyuruikigouyobi1x9) {
        ztyhokensyuruikigouyobi1x9 = pZtyhokensyuruikigouyobi1x9;
    }

    private String ztyhokensyuruikigouyobi1x10;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X10)
    public String getZtyhokensyuruikigouyobi1x10() {
        return ztyhokensyuruikigouyobi1x10;
    }

    public void setZtyhokensyuruikigouyobi1x10(String pZtyhokensyuruikigouyobi1x10) {
        ztyhokensyuruikigouyobi1x10 = pZtyhokensyuruikigouyobi1x10;
    }

    private String ztyhokensyuruikigouyobi1x11;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X11)
    public String getZtyhokensyuruikigouyobi1x11() {
        return ztyhokensyuruikigouyobi1x11;
    }

    public void setZtyhokensyuruikigouyobi1x11(String pZtyhokensyuruikigouyobi1x11) {
        ztyhokensyuruikigouyobi1x11 = pZtyhokensyuruikigouyobi1x11;
    }

    private String ztyhokensyuruikigouyobi1x12;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X12)
    public String getZtyhokensyuruikigouyobi1x12() {
        return ztyhokensyuruikigouyobi1x12;
    }

    public void setZtyhokensyuruikigouyobi1x12(String pZtyhokensyuruikigouyobi1x12) {
        ztyhokensyuruikigouyobi1x12 = pZtyhokensyuruikigouyobi1x12;
    }

    private String ztyhokensyuruikigouyobi1x13;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X13)
    public String getZtyhokensyuruikigouyobi1x13() {
        return ztyhokensyuruikigouyobi1x13;
    }

    public void setZtyhokensyuruikigouyobi1x13(String pZtyhokensyuruikigouyobi1x13) {
        ztyhokensyuruikigouyobi1x13 = pZtyhokensyuruikigouyobi1x13;
    }

    private String ztyhokensyuruikigouyobi1x14;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X14)
    public String getZtyhokensyuruikigouyobi1x14() {
        return ztyhokensyuruikigouyobi1x14;
    }

    public void setZtyhokensyuruikigouyobi1x14(String pZtyhokensyuruikigouyobi1x14) {
        ztyhokensyuruikigouyobi1x14 = pZtyhokensyuruikigouyobi1x14;
    }

    private String ztyhokensyuruikigouyobi1x15;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X15)
    public String getZtyhokensyuruikigouyobi1x15() {
        return ztyhokensyuruikigouyobi1x15;
    }

    public void setZtyhokensyuruikigouyobi1x15(String pZtyhokensyuruikigouyobi1x15) {
        ztyhokensyuruikigouyobi1x15 = pZtyhokensyuruikigouyobi1x15;
    }

    private String ztyhokensyuruikigouyobi2x1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X1)
    public String getZtyhokensyuruikigouyobi2x1() {
        return ztyhokensyuruikigouyobi2x1;
    }

    public void setZtyhokensyuruikigouyobi2x1(String pZtyhokensyuruikigouyobi2x1) {
        ztyhokensyuruikigouyobi2x1 = pZtyhokensyuruikigouyobi2x1;
    }

    private String ztyhokensyuruikigouyobi2x2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X2)
    public String getZtyhokensyuruikigouyobi2x2() {
        return ztyhokensyuruikigouyobi2x2;
    }

    public void setZtyhokensyuruikigouyobi2x2(String pZtyhokensyuruikigouyobi2x2) {
        ztyhokensyuruikigouyobi2x2 = pZtyhokensyuruikigouyobi2x2;
    }

    private String ztyhokensyuruikigouyobi2x3;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X3)
    public String getZtyhokensyuruikigouyobi2x3() {
        return ztyhokensyuruikigouyobi2x3;
    }

    public void setZtyhokensyuruikigouyobi2x3(String pZtyhokensyuruikigouyobi2x3) {
        ztyhokensyuruikigouyobi2x3 = pZtyhokensyuruikigouyobi2x3;
    }

    private String ztyhokensyuruikigouyobi2x4;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X4)
    public String getZtyhokensyuruikigouyobi2x4() {
        return ztyhokensyuruikigouyobi2x4;
    }

    public void setZtyhokensyuruikigouyobi2x4(String pZtyhokensyuruikigouyobi2x4) {
        ztyhokensyuruikigouyobi2x4 = pZtyhokensyuruikigouyobi2x4;
    }

    private String ztyhokensyuruikigouyobi2x5;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X5)
    public String getZtyhokensyuruikigouyobi2x5() {
        return ztyhokensyuruikigouyobi2x5;
    }

    public void setZtyhokensyuruikigouyobi2x5(String pZtyhokensyuruikigouyobi2x5) {
        ztyhokensyuruikigouyobi2x5 = pZtyhokensyuruikigouyobi2x5;
    }

    private String ztyhokensyuruikigouyobi2x6;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X6)
    public String getZtyhokensyuruikigouyobi2x6() {
        return ztyhokensyuruikigouyobi2x6;
    }

    public void setZtyhokensyuruikigouyobi2x6(String pZtyhokensyuruikigouyobi2x6) {
        ztyhokensyuruikigouyobi2x6 = pZtyhokensyuruikigouyobi2x6;
    }

    private String ztyhokensyuruikigouyobi2x7;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X7)
    public String getZtyhokensyuruikigouyobi2x7() {
        return ztyhokensyuruikigouyobi2x7;
    }

    public void setZtyhokensyuruikigouyobi2x7(String pZtyhokensyuruikigouyobi2x7) {
        ztyhokensyuruikigouyobi2x7 = pZtyhokensyuruikigouyobi2x7;
    }

    private String ztyhokensyuruikigouyobi2x8;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X8)
    public String getZtyhokensyuruikigouyobi2x8() {
        return ztyhokensyuruikigouyobi2x8;
    }

    public void setZtyhokensyuruikigouyobi2x8(String pZtyhokensyuruikigouyobi2x8) {
        ztyhokensyuruikigouyobi2x8 = pZtyhokensyuruikigouyobi2x8;
    }

    private String ztyhokensyuruikigouyobi2x9;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X9)
    public String getZtyhokensyuruikigouyobi2x9() {
        return ztyhokensyuruikigouyobi2x9;
    }

    public void setZtyhokensyuruikigouyobi2x9(String pZtyhokensyuruikigouyobi2x9) {
        ztyhokensyuruikigouyobi2x9 = pZtyhokensyuruikigouyobi2x9;
    }

    private String ztyhokensyuruikigouyobi2x10;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X10)
    public String getZtyhokensyuruikigouyobi2x10() {
        return ztyhokensyuruikigouyobi2x10;
    }

    public void setZtyhokensyuruikigouyobi2x10(String pZtyhokensyuruikigouyobi2x10) {
        ztyhokensyuruikigouyobi2x10 = pZtyhokensyuruikigouyobi2x10;
    }

    private String ztyhokensyuruikigouyobi3x1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X1)
    public String getZtyhokensyuruikigouyobi3x1() {
        return ztyhokensyuruikigouyobi3x1;
    }

    public void setZtyhokensyuruikigouyobi3x1(String pZtyhokensyuruikigouyobi3x1) {
        ztyhokensyuruikigouyobi3x1 = pZtyhokensyuruikigouyobi3x1;
    }

    private String ztyhokensyuruikigouyobi3x2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X2)
    public String getZtyhokensyuruikigouyobi3x2() {
        return ztyhokensyuruikigouyobi3x2;
    }

    public void setZtyhokensyuruikigouyobi3x2(String pZtyhokensyuruikigouyobi3x2) {
        ztyhokensyuruikigouyobi3x2 = pZtyhokensyuruikigouyobi3x2;
    }

    private String ztyhokensyuruikigouyobi3x3;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X3)
    public String getZtyhokensyuruikigouyobi3x3() {
        return ztyhokensyuruikigouyobi3x3;
    }

    public void setZtyhokensyuruikigouyobi3x3(String pZtyhokensyuruikigouyobi3x3) {
        ztyhokensyuruikigouyobi3x3 = pZtyhokensyuruikigouyobi3x3;
    }

    private String ztyhokensyuruikigouyobi3x4;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X4)
    public String getZtyhokensyuruikigouyobi3x4() {
        return ztyhokensyuruikigouyobi3x4;
    }

    public void setZtyhokensyuruikigouyobi3x4(String pZtyhokensyuruikigouyobi3x4) {
        ztyhokensyuruikigouyobi3x4 = pZtyhokensyuruikigouyobi3x4;
    }

    private String ztyhokensyuruikigouyobi3x5;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X5)
    public String getZtyhokensyuruikigouyobi3x5() {
        return ztyhokensyuruikigouyobi3x5;
    }

    public void setZtyhokensyuruikigouyobi3x5(String pZtyhokensyuruikigouyobi3x5) {
        ztyhokensyuruikigouyobi3x5 = pZtyhokensyuruikigouyobi3x5;
    }

    private String ztyhokensyuruikigouyobi3x6;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X6)
    public String getZtyhokensyuruikigouyobi3x6() {
        return ztyhokensyuruikigouyobi3x6;
    }

    public void setZtyhokensyuruikigouyobi3x6(String pZtyhokensyuruikigouyobi3x6) {
        ztyhokensyuruikigouyobi3x6 = pZtyhokensyuruikigouyobi3x6;
    }

    private String ztyhokensyuruikigouyobi3x7;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X7)
    public String getZtyhokensyuruikigouyobi3x7() {
        return ztyhokensyuruikigouyobi3x7;
    }

    public void setZtyhokensyuruikigouyobi3x7(String pZtyhokensyuruikigouyobi3x7) {
        ztyhokensyuruikigouyobi3x7 = pZtyhokensyuruikigouyobi3x7;
    }

    private String ztyhokensyuruikigouyobi3x8;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X8)
    public String getZtyhokensyuruikigouyobi3x8() {
        return ztyhokensyuruikigouyobi3x8;
    }

    public void setZtyhokensyuruikigouyobi3x8(String pZtyhokensyuruikigouyobi3x8) {
        ztyhokensyuruikigouyobi3x8 = pZtyhokensyuruikigouyobi3x8;
    }

    private String ztyhokensyuruikigouyobi3x9;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X9)
    public String getZtyhokensyuruikigouyobi3x9() {
        return ztyhokensyuruikigouyobi3x9;
    }

    public void setZtyhokensyuruikigouyobi3x9(String pZtyhokensyuruikigouyobi3x9) {
        ztyhokensyuruikigouyobi3x9 = pZtyhokensyuruikigouyobi3x9;
    }

    private String ztyhokensyuruikigouyobi3x10;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X10)
    public String getZtyhokensyuruikigouyobi3x10() {
        return ztyhokensyuruikigouyobi3x10;
    }

    public void setZtyhokensyuruikigouyobi3x10(String pZtyhokensyuruikigouyobi3x10) {
        ztyhokensyuruikigouyobi3x10 = pZtyhokensyuruikigouyobi3x10;
    }

    private String ztyharaikatakbn;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHARAIKATAKBN)
    public String getZtyharaikatakbn() {
        return ztyharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyharaikatakbn(String pZtyharaikatakbn) {
        ztyharaikatakbn = pZtyharaikatakbn;
    }

    private String ztykeiyakunendo;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYKEIYAKUNENDO)
    public String getZtykeiyakunendo() {
        return ztykeiyakunendo;
    }

    public void setZtykeiyakunendo(String pZtykeiyakunendo) {
        ztykeiyakunendo = pZtykeiyakunendo;
    }

    private String ztykeiyakum;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYKEIYAKUM)
    public String getZtykeiyakum() {
        return ztykeiyakum;
    }

    public void setZtykeiyakum(String pZtykeiyakum) {
        ztykeiyakum = pZtykeiyakum;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String zty5nenmeoutoubikbn;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTY5NENMEOUTOUBIKBN)
    public String getZty5nenmeoutoubikbn() {
        return zty5nenmeoutoubikbn;
    }

    public void setZty5nenmeoutoubikbn(String pZty5nenmeoutoubikbn) {
        zty5nenmeoutoubikbn = pZty5nenmeoutoubikbn;
    }

    private String ztykeijyouym;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYKEIJYOUYM)
    public String getZtykeijyouym() {
        return ztykeijyouym;
    }

    public void setZtykeijyouym(String pZtykeijyouym) {
        ztykeijyouym = pZtykeijyouym;
    }

    private String ztykeiyakuoutoubikbn;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYKEIYAKUOUTOUBIKBN)
    public String getZtykeiyakuoutoubikbn() {
        return ztykeiyakuoutoubikbn;
    }

    public void setZtykeiyakuoutoubikbn(String pZtykeiyakuoutoubikbn) {
        ztykeiyakuoutoubikbn = pZtykeiyakuoutoubikbn;
    }

    private String ztysuuriyouyobin1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSUURIYOUYOBIN1)
    public String getZtysuuriyouyobin1() {
        return ztysuuriyouyobin1;
    }

    public void setZtysuuriyouyobin1(String pZtysuuriyouyobin1) {
        ztysuuriyouyobin1 = pZtysuuriyouyobin1;
    }

    private String ztysuuriyouyobin11;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSUURIYOUYOBIN11)
    public String getZtysuuriyouyobin11() {
        return ztysuuriyouyobin11;
    }

    public void setZtysuuriyouyobin11(String pZtysuuriyouyobin11) {
        ztysuuriyouyobin11 = pZtysuuriyouyobin11;
    }

    private Integer ztysaisitutokuyakuhukasuu;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSAISITUTOKUYAKUHUKASUU)
    public Integer getZtysaisitutokuyakuhukasuu() {
        return ztysaisitutokuyakuhukasuu;
    }

    public void setZtysaisitutokuyakuhukasuu(Integer pZtysaisitutokuyakuhukasuu) {
        ztysaisitutokuyakuhukasuu = pZtysaisitutokuyakuhukasuu;
    }

    private Long ztykihons;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYKIHONS)
    public Long getZtykihons() {
        return ztykihons;
    }

    public void setZtykihons(Long pZtykihons) {
        ztykihons = pZtykihons;
    }

    private Long ztysibous;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSIBOUS)
    public Long getZtysibous() {
        return ztysibous;
    }

    public void setZtysibous(Long pZtysibous) {
        ztysibous = pZtysibous;
    }

    private Long ztytounendmtwrhrgkruikeigk;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOUNENDMTWRHRGKRUIKEIGK)
    public Long getZtytounendmtwrhrgkruikeigk() {
        return ztytounendmtwrhrgkruikeigk;
    }

    public void setZtytounendmtwrhrgkruikeigk(Long pZtytounendmtwrhrgkruikeigk) {
        ztytounendmtwrhrgkruikeigk = pZtytounendmtwrhrgkruikeigk;
    }

    private Long ztywarihurigakurisoku1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYWARIHURIGAKURISOKU1)
    public Long getZtywarihurigakurisoku1() {
        return ztywarihurigakurisoku1;
    }

    public void setZtywarihurigakurisoku1(Long pZtywarihurigakurisoku1) {
        ztywarihurigakurisoku1 = pZtywarihurigakurisoku1;
    }

    private Long ztywarihurigakurisoku2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYWARIHURIGAKURISOKU2)
    public Long getZtywarihurigakurisoku2() {
        return ztywarihurigakurisoku2;
    }

    public void setZtywarihurigakurisoku2(Long pZtywarihurigakurisoku2) {
        ztywarihurigakurisoku2 = pZtywarihurigakurisoku2;
    }

    private Long ztyyokunendosyoyougakuyou;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOKUNENDOSYOYOUGAKUYOU)
    public Long getZtyyokunendosyoyougakuyou() {
        return ztyyokunendosyoyougakuyou;
    }

    public void setZtyyokunendosyoyougakuyou(Long pZtyyokunendosyoyougakuyou) {
        ztyyokunendosyoyougakuyou = pZtyyokunendosyoyougakuyou;
    }

    private Long ztyyokuyokunendosyoyougkyou;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOKUYOKUNENDOSYOYOUGKYOU)
    public Long getZtyyokuyokunendosyoyougkyou() {
        return ztyyokuyokunendosyoyougkyou;
    }

    public void setZtyyokuyokunendosyoyougkyou(Long pZtyyokuyokunendosyoyougkyou) {
        ztyyokuyokunendosyoyougkyou = pZtyyokuyokunendosyoyougkyou;
    }

    private Long ztyyuukoutyuusyoyougaku;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYUUKOUTYUUSYOYOUGAKU)
    public Long getZtyyuukoutyuusyoyougaku() {
        return ztyyuukoutyuusyoyougaku;
    }

    public void setZtyyuukoutyuusyoyougaku(Long pZtyyuukoutyuusyoyougaku) {
        ztyyuukoutyuusyoyougaku = pZtyyuukoutyuusyoyougaku;
    }

    private Long ztysyoumetuyousyoyougaku1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSYOUMETUYOUSYOYOUGAKU1)
    public Long getZtysyoumetuyousyoyougaku1() {
        return ztysyoumetuyousyoyougaku1;
    }

    public void setZtysyoumetuyousyoyougaku1(Long pZtysyoumetuyousyoyougaku1) {
        ztysyoumetuyousyoyougaku1 = pZtysyoumetuyousyoyougaku1;
    }

    private Long ztysyoumetuyousyoyougaku2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSYOUMETUYOUSYOYOUGAKU2)
    public Long getZtysyoumetuyousyoyougaku2() {
        return ztysyoumetuyousyoyougaku2;
    }

    public void setZtysyoumetuyousyoyougaku2(Long pZtysyoumetuyousyoyougaku2) {
        ztysyoumetuyousyoyougaku2 = pZtysyoumetuyousyoyougaku2;
    }

    private Long ztytenkanyousyoyougaku1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTENKANYOUSYOYOUGAKU1)
    public Long getZtytenkanyousyoyougaku1() {
        return ztytenkanyousyoyougaku1;
    }

    public void setZtytenkanyousyoyougaku1(Long pZtytenkanyousyoyougaku1) {
        ztytenkanyousyoyougaku1 = pZtytenkanyousyoyougaku1;
    }

    private Long ztytenkanyousyoyougaku2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTENKANYOUSYOYOUGAKU2)
    public Long getZtytenkanyousyoyougaku2() {
        return ztytenkanyousyoyougaku2;
    }

    public void setZtytenkanyousyoyougaku2(Long pZtytenkanyousyoyougaku2) {
        ztytenkanyousyoyougaku2 = pZtytenkanyousyoyougaku2;
    }

    private Long ztytnknyutuujyoudsyoyougk1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUTUUJYOUDSYOYOUGK1)
    public Long getZtytnknyutuujyoudsyoyougk1() {
        return ztytnknyutuujyoudsyoyougk1;
    }

    public void setZtytnknyutuujyoudsyoyougk1(Long pZtytnknyutuujyoudsyoyougk1) {
        ztytnknyutuujyoudsyoyougk1 = pZtytnknyutuujyoudsyoyougk1;
    }

    private Long ztytnknyutuujyoudsyoyougk2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUTUUJYOUDSYOYOUGK2)
    public Long getZtytnknyutuujyoudsyoyougk2() {
        return ztytnknyutuujyoudsyoyougk2;
    }

    public void setZtytnknyutuujyoudsyoyougk2(Long pZtytnknyutuujyoudsyoyougk2) {
        ztytnknyutuujyoudsyoyougk2 = pZtytnknyutuujyoudsyoyougk2;
    }

    private Long ztytnknyuhrkbbnksyoyougk1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUHRKBBNKSYOYOUGK1)
    public Long getZtytnknyuhrkbbnksyoyougk1() {
        return ztytnknyuhrkbbnksyoyougk1;
    }

    public void setZtytnknyuhrkbbnksyoyougk1(Long pZtytnknyuhrkbbnksyoyougk1) {
        ztytnknyuhrkbbnksyoyougk1 = pZtytnknyuhrkbbnksyoyougk1;
    }

    private Long ztytnknyuhrkbbnksyoyougk2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUHRKBBNKSYOYOUGK2)
    public Long getZtytnknyuhrkbbnksyoyougk2() {
        return ztytnknyuhrkbbnksyoyougk2;
    }

    public void setZtytnknyuhrkbbnksyoyougk2(Long pZtytnknyuhrkbbnksyoyougk2) {
        ztytnknyuhrkbbnksyoyougk2 = pZtytnknyuhrkbbnksyoyougk2;
    }

    private Long ztytnknyuhrkbbnknnknsnp1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUHRKBBNKNNKNSNP1)
    public Long getZtytnknyuhrkbbnknnknsnp1() {
        return ztytnknyuhrkbbnknnknsnp1;
    }

    public void setZtytnknyuhrkbbnknnknsnp1(Long pZtytnknyuhrkbbnknnknsnp1) {
        ztytnknyuhrkbbnknnknsnp1 = pZtytnknyuhrkbbnknnknsnp1;
    }

    private Long ztytnknyuhrkbbnknnknsnp2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUHRKBBNKNNKNSNP2)
    public Long getZtytnknyuhrkbbnknnknsnp2() {
        return ztytnknyuhrkbbnknnknsnp2;
    }

    public void setZtytnknyuhrkbbnknnknsnp2(Long pZtytnknyuhrkbbnknnknsnp2) {
        ztytnknyuhrkbbnknnknsnp2 = pZtytnknyuhrkbbnknnknsnp2;
    }

    private Long ztytnknyutnknhktgksyoyougk1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUTNKNHKTGKSYOYOUGK1)
    public Long getZtytnknyutnknhktgksyoyougk1() {
        return ztytnknyutnknhktgksyoyougk1;
    }

    public void setZtytnknyutnknhktgksyoyougk1(Long pZtytnknyutnknhktgksyoyougk1) {
        ztytnknyutnknhktgksyoyougk1 = pZtytnknyutnknhktgksyoyougk1;
    }

    private Long ztytnknyutnknhktgksyoyougk2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUTNKNHKTGKSYOYOUGK2)
    public Long getZtytnknyutnknhktgksyoyougk2() {
        return ztytnknyutnknhktgksyoyougk2;
    }

    public void setZtytnknyutnknhktgksyoyougk2(Long pZtytnknyutnknhktgksyoyougk2) {
        ztytnknyutnknhktgksyoyougk2 = pZtytnknyutnknhktgksyoyougk2;
    }

    private Long ztytnknyutnknhktgknnknsnp1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUTNKNHKTGKNNKNSNP1)
    public Long getZtytnknyutnknhktgknnknsnp1() {
        return ztytnknyutnknhktgknnknsnp1;
    }

    public void setZtytnknyutnknhktgknnknsnp1(Long pZtytnknyutnknhktgknnknsnp1) {
        ztytnknyutnknhktgknnknsnp1 = pZtytnknyutnknhktgknnknsnp1;
    }

    private Long ztytnknyutnknhktgknnknsnp2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUTNKNHKTGKNNKNSNP2)
    public Long getZtytnknyutnknhktgknnknsnp2() {
        return ztytnknyutnknhktgknnknsnp2;
    }

    public void setZtytnknyutnknhktgknnknsnp2(Long pZtytnknyutnknhktgknnknsnp2) {
        ztytnknyutnknhktgknnknsnp2 = pZtytnknyutnknhktgknnknsnp2;
    }

    private Long ztytnknyusaisituksyoyougk1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUSAISITUKSYOYOUGK1)
    public Long getZtytnknyusaisituksyoyougk1() {
        return ztytnknyusaisituksyoyougk1;
    }

    public void setZtytnknyusaisituksyoyougk1(Long pZtytnknyusaisituksyoyougk1) {
        ztytnknyusaisituksyoyougk1 = pZtytnknyusaisituksyoyougk1;
    }

    private Long ztytnknyusaisituksyoyougk2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUSAISITUKSYOYOUGK2)
    public Long getZtytnknyusaisituksyoyougk2() {
        return ztytnknyusaisituksyoyougk2;
    }

    public void setZtytnknyusaisituksyoyougk2(Long pZtytnknyusaisituksyoyougk2) {
        ztytnknyusaisituksyoyougk2 = pZtytnknyusaisituksyoyougk2;
    }

    private Long ztytnknyusaisitukkyhntgk1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUSAISITUKKYHNTGK1)
    public Long getZtytnknyusaisitukkyhntgk1() {
        return ztytnknyusaisitukkyhntgk1;
    }

    public void setZtytnknyusaisitukkyhntgk1(Long pZtytnknyusaisitukkyhntgk1) {
        ztytnknyusaisitukkyhntgk1 = pZtytnknyusaisitukkyhntgk1;
    }

    private Long ztytnknyusaisitukkyhntgk2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUSAISITUKKYHNTGK2)
    public Long getZtytnknyusaisitukkyhntgk2() {
        return ztytnknyusaisitukkyhntgk2;
    }

    public void setZtytnknyusaisitukkyhntgk2(Long pZtytnknyusaisitukkyhntgk2) {
        ztytnknyusaisitukkyhntgk2 = pZtytnknyusaisitukkyhntgk2;
    }

    private Long ztyhrkbbnkdsyoyougk;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHRKBBNKDSYOYOUGK)
    public Long getZtyhrkbbnkdsyoyougk() {
        return ztyhrkbbnkdsyoyougk;
    }

    public void setZtyhrkbbnkdsyoyougk(Long pZtyhrkbbnkdsyoyougk) {
        ztyhrkbbnkdsyoyougk = pZtyhrkbbnkdsyoyougk;
    }

    private Long ztyhrkbbnkdtisyunnknsnp;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHRKBBNKDTISYUNNKNSNP)
    public Long getZtyhrkbbnkdtisyunnknsnp() {
        return ztyhrkbbnkdtisyunnknsnp;
    }

    public void setZtyhrkbbnkdtisyunnknsnp(Long pZtyhrkbbnkdtisyunnknsnp) {
        ztyhrkbbnkdtisyunnknsnp = pZtyhrkbbnkdtisyunnknsnp;
    }

    private Long ztytusangohrkbbnkappad;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTUSANGOHRKBBNKAPPAD)
    public Long getZtytusangohrkbbnkappad() {
        return ztytusangohrkbbnkappad;
    }

    public void setZtytusangohrkbbnkappad(Long pZtytusangohrkbbnkappad) {
        ztytusangohrkbbnkappad = pZtytusangohrkbbnkappad;
    }

    private Long ztytnknhktgkdsyoyougk;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNHKTGKDSYOYOUGK)
    public Long getZtytnknhktgkdsyoyougk() {
        return ztytnknhktgkdsyoyougk;
    }

    public void setZtytnknhktgkdsyoyougk(Long pZtytnknhktgkdsyoyougk) {
        ztytnknhktgkdsyoyougk = pZtytnknhktgkdsyoyougk;
    }

    private Long ztytnknhktgkdtisyunenknsnp;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNHKTGKDTISYUNENKNSNP)
    public Long getZtytnknhktgkdtisyunenknsnp() {
        return ztytnknhktgkdtisyunenknsnp;
    }

    public void setZtytnknhktgkdtisyunenknsnp(Long pZtytnknhktgkdtisyunenknsnp) {
        ztytnknhktgkdtisyunenknsnp = pZtytnknhktgkdtisyunenknsnp;
    }

    private Long ztytusangotnknhktgkappad;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTUSANGOTNKNHKTGKAPPAD)
    public Long getZtytusangotnknhktgkappad() {
        return ztytusangotnknhktgkappad;
    }

    public void setZtytusangotnknhktgkappad(Long pZtytusangotnknhktgkappad) {
        ztytusangotnknhktgkappad = pZtytusangotnknhktgkappad;
    }

    private Long ztytuusangohutuusiboukappad;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTUUSANGOHUTUUSIBOUKAPPAD)
    public Long getZtytuusangohutuusiboukappad() {
        return ztytuusangohutuusiboukappad;
    }

    public void setZtytuusangohutuusiboukappad(Long pZtytuusangohutuusiboukappad) {
        ztytuusangohutuusiboukappad = pZtytuusangohutuusiboukappad;
    }

    private Long ztysaisitukappadsyoyougaku;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSAISITUKAPPADSYOYOUGAKU)
    public Long getZtysaisitukappadsyoyougaku() {
        return ztysaisitukappadsyoyougaku;
    }

    public void setZtysaisitukappadsyoyougaku(Long pZtysaisitukappadsyoyougaku) {
        ztysaisitukappadsyoyougaku = pZtysaisitukappadsyoyougaku;
    }

    private Long ztytuusangosaisitukappad;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTUUSANGOSAISITUKAPPAD)
    public Long getZtytuusangosaisitukappad() {
        return ztytuusangosaisitukappad;
    }

    public void setZtytuusangosaisitukappad(Long pZtytuusangosaisitukappad) {
        ztytuusangosaisitukappad = pZtytuusangosaisitukappad;
    }

    private Long ztysistkappadtisyukyhntgk;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSISTKAPPADTISYUKYHNTGK)
    public Long getZtysistkappadtisyukyhntgk() {
        return ztysistkappadtisyukyhntgk;
    }

    public void setZtysistkappadtisyukyhntgk(Long pZtysistkappadtisyukyhntgk) {
        ztysistkappadtisyukyhntgk = pZtysistkappadtisyukyhntgk;
    }

    private Long ztytuusangogoukeikappad;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTUUSANGOGOUKEIKAPPAD)
    public Long getZtytuusangogoukeikappad() {
        return ztytuusangogoukeikappad;
    }

    public void setZtytuusangogoukeikappad(Long pZtytuusangogoukeikappad) {
        ztytuusangogoukeikappad = pZtytuusangogoukeikappad;
    }

    private Long ztydtaisyouv;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYDTAISYOUV)
    public Long getZtydtaisyouv() {
        return ztydtaisyouv;
    }

    public void setZtydtaisyouv(Long pZtydtaisyouv) {
        ztydtaisyouv = pZtydtaisyouv;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private BizNumber ztydaihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYDAIHYOUYOTEIRIRITU)
    public BizNumber getZtydaihyouyoteiriritu() {
        return ztydaihyouyoteiriritu;
    }

    public void setZtydaihyouyoteiriritu(BizNumber pZtydaihyouyoteiriritu) {
        ztydaihyouyoteiriritu = pZtydaihyouyoteiriritu;
    }

    private String ztyknkuzusnzyrt;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYKNKUZUSNZYRT)
    public String getZtyknkuzusnzyrt() {
        return ztyknkuzusnzyrt;
    }

    public void setZtyknkuzusnzyrt(String pZtyknkuzusnzyrt) {
        ztyknkuzusnzyrt = pZtyknkuzusnzyrt;
    }

    private String ztyzyrthntiyustatuskbn;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYZYRTHNTIYUSTATUSKBN)
    public String getZtyzyrthntiyustatuskbn() {
        return ztyzyrthntiyustatuskbn;
    }

    public void setZtyzyrthntiyustatuskbn(String pZtyzyrthntiyustatuskbn) {
        ztyzyrthntiyustatuskbn = pZtyzyrthntiyustatuskbn;
    }

    private String ztyyobiv7;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOBIV7)
    public String getZtyyobiv7() {
        return ztyyobiv7;
    }

    public void setZtyyobiv7(String pZtyyobiv7) {
        ztyyobiv7 = pZtyyobiv7;
    }

    private Long ztytnknyusyusistksyoyougk1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUSYUSISTKSYOYOUGK1)
    public Long getZtytnknyusyusistksyoyougk1() {
        return ztytnknyusyusistksyoyougk1;
    }

    public void setZtytnknyusyusistksyoyougk1(Long pZtytnknyusyusistksyoyougk1) {
        ztytnknyusyusistksyoyougk1 = pZtytnknyusyusistksyoyougk1;
    }

    private Long ztytnknyusyusistksyoyougk2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUSYUSISTKSYOYOUGK2)
    public Long getZtytnknyusyusistksyoyougk2() {
        return ztytnknyusyusistksyoyougk2;
    }

    public void setZtytnknyusyusistksyoyougk2(Long pZtytnknyusyusistksyoyougk2) {
        ztytnknyusyusistksyoyougk2 = pZtytnknyusyusistksyoyougk2;
    }

    private Long ztytnknyusyusistkkyhntgk1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUSYUSISTKKYHNTGK1)
    public Long getZtytnknyusyusistkkyhntgk1() {
        return ztytnknyusyusistkkyhntgk1;
    }

    public void setZtytnknyusyusistkkyhntgk1(Long pZtytnknyusyusistkkyhntgk1) {
        ztytnknyusyusistkkyhntgk1 = pZtytnknyusyusistkkyhntgk1;
    }

    private Long ztytnknyusyusistkkyhntgk2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTNKNYUSYUSISTKKYHNTGK2)
    public Long getZtytnknyusyusistkkyhntgk2() {
        return ztytnknyusyusistkkyhntgk2;
    }

    public void setZtytnknyusyusistkkyhntgk2(Long pZtytnknyusyusistkkyhntgk2) {
        ztytnknyusyusistkkyhntgk2 = pZtytnknyusyusistkkyhntgk2;
    }

    private Long ztysyusistkappadsyoyougk;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSYUSISTKAPPADSYOYOUGK)
    public Long getZtysyusistkappadsyoyougk() {
        return ztysyusistkappadsyoyougk;
    }

    public void setZtysyusistkappadsyoyougk(Long pZtysyusistkappadsyoyougk) {
        ztysyusistkappadsyoyougk = pZtysyusistkappadsyoyougk;
    }

    private Long ztysyusistkdtisyukyhntgk;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSYUSISTKDTISYUKYHNTGK)
    public Long getZtysyusistkdtisyukyhntgk() {
        return ztysyusistkdtisyukyhntgk;
    }

    public void setZtysyusistkdtisyukyhntgk(Long pZtysyusistkdtisyukyhntgk) {
        ztysyusistkdtisyukyhntgk = pZtysyusistkdtisyukyhntgk;
    }

    private Long ztyyobin11x8;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOBIN11X8)
    public Long getZtyyobin11x8() {
        return ztyyobin11x8;
    }

    public void setZtyyobin11x8(Long pZtyyobin11x8) {
        ztyyobin11x8 = pZtyyobin11x8;
    }

    private Long ztyyobin11x9;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOBIN11X9)
    public Long getZtyyobin11x9() {
        return ztyyobin11x9;
    }

    public void setZtyyobin11x9(Long pZtyyobin11x9) {
        ztyyobin11x9 = pZtyyobin11x9;
    }

    private Long ztyyobin11x10;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOBIN11X10)
    public Long getZtyyobin11x10() {
        return ztyyobin11x10;
    }

    public void setZtyyobin11x10(Long pZtyyobin11x10) {
        ztyyobin11x10 = pZtyyobin11x10;
    }

    private Long ztyyobin11x11;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOBIN11X11)
    public Long getZtyyobin11x11() {
        return ztyyobin11x11;
    }

    public void setZtyyobin11x11(Long pZtyyobin11x11) {
        ztyyobin11x11 = pZtyyobin11x11;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private BizNumber ztykawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYKAWASERATE)
    public BizNumber getZtykawaserate() {
        return ztykawaserate;
    }

    public void setZtykawaserate(BizNumber pZtykawaserate) {
        ztykawaserate = pZtykawaserate;
    }

    private String ztykawaseratetekiyouymd;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYKAWASERATETEKIYOUYMD)
    public String getZtykawaseratetekiyouymd() {
        return ztykawaseratetekiyouymd;
    }

    public void setZtykawaseratetekiyouymd(String pZtykawaseratetekiyouymd) {
        ztykawaseratetekiyouymd = pZtykawaseratetekiyouymd;
    }

    private BizNumber ztykeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZtykeiyakujiyoteiriritu() {
        return ztykeiyakujiyoteiriritu;
    }

    public void setZtykeiyakujiyoteiriritu(BizNumber pZtykeiyakujiyoteiriritu) {
        ztykeiyakujiyoteiriritu = pZtykeiyakujiyoteiriritu;
    }

    private Long ztyenkdtsbujsitihsyukngk;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYENKDTSBUJSITIHSYUKNGK)
    public Long getZtyenkdtsbujsitihsyukngk() {
        return ztyenkdtsbujsitihsyukngk;
    }

    public void setZtyenkdtsbujsitihsyukngk(Long pZtyenkdtsbujsitihsyukngk) {
        ztyenkdtsbujsitihsyukngk = pZtyenkdtsbujsitihsyukngk;
    }

    private Long ztytumitatekin;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTUMITATEKIN)
    public Long getZtytumitatekin() {
        return ztytumitatekin;
    }

    public void setZtytumitatekin(Long pZtytumitatekin) {
        ztytumitatekin = pZtytumitatekin;
    }

    private Long ztykiharaikomip;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYKIHARAIKOMIP)
    public Long getZtykiharaikomip() {
        return ztykiharaikomip;
    }

    public void setZtykiharaikomip(Long pZtykiharaikomip) {
        ztykiharaikomip = pZtykiharaikomip;
    }

    private Long ztygaikadatesyukeiyakup;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYGAIKADATESYUKEIYAKUP)
    public Long getZtygaikadatesyukeiyakup() {
        return ztygaikadatesyukeiyakup;
    }

    public void setZtygaikadatesyukeiyakup(Long pZtygaikadatesyukeiyakup) {
        ztygaikadatesyukeiyakup = pZtygaikadatesyukeiyakup;
    }

    private String ztytuukasyukbn;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTUUKASYUKBN)
    public String getZtytuukasyukbn() {
        return ztytuukasyukbn;
    }

    public void setZtytuukasyukbn(String pZtytuukasyukbn) {
        ztytuukasyukbn = pZtytuukasyukbn;
    }

    private String ztyyobiv1;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOBIV1)
    public String getZtyyobiv1() {
        return ztyyobiv1;
    }

    public void setZtyyobiv1(String pZtyyobiv1) {
        ztyyobiv1 = pZtyyobiv1;
    }

    private Long ztynksjitirttumitatekin;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYNKSJITIRTTUMITATEKIN)
    public Long getZtynksjitirttumitatekin() {
        return ztynksjitirttumitatekin;
    }

    public void setZtynksjitirttumitatekin(Long pZtynksjitirttumitatekin) {
        ztynksjitirttumitatekin = pZtynksjitirttumitatekin;
    }

    private Long ztysisuurentumitatekin;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSISUURENTUMITATEKIN)
    public Long getZtysisuurentumitatekin() {
        return ztysisuurentumitatekin;
    }

    public void setZtysisuurentumitatekin(Long pZtysisuurentumitatekin) {
        ztysisuurentumitatekin = pZtysisuurentumitatekin;
    }

    private Long ztysyukeiyakup;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSYUKEIYAKUP)
    public Long getZtysyukeiyakup() {
        return ztysyukeiyakup;
    }

    public void setZtysyukeiyakup(Long pZtysyukeiyakup) {
        ztysyukeiyakup = pZtysyukeiyakup;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private BizNumber ztyyoteiririturironbase;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOTEIRIRITURIRONBASE)
    public BizNumber getZtyyoteiririturironbase() {
        return ztyyoteiririturironbase;
    }

    public void setZtyyoteiririturironbase(BizNumber pZtyyoteiririturironbase) {
        ztyyoteiririturironbase = pZtyyoteiririturironbase;
    }

    private Long ztygkdtyknndsyoyougakuyou;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYGKDTYKNNDSYOYOUGAKUYOU)
    public Long getZtygkdtyknndsyoyougakuyou() {
        return ztygkdtyknndsyoyougakuyou;
    }

    public void setZtygkdtyknndsyoyougakuyou(Long pZtygkdtyknndsyoyougakuyou) {
        ztygkdtyknndsyoyougakuyou = pZtygkdtyknndsyoyougakuyou;
    }

    private Long ztygkdtykyknndsyoyougakuyou;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYGKDTYKYKNNDSYOYOUGAKUYOU)
    public Long getZtygkdtykyknndsyoyougakuyou() {
        return ztygkdtykyknndsyoyougakuyou;
    }

    public void setZtygkdtykyknndsyoyougakuyou(Long pZtygkdtykyknndsyoyougakuyou) {
        ztygkdtykyknndsyoyougakuyou = pZtygkdtykyknndsyoyougakuyou;
    }

    private BizNumber ztydkeisanjikwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYDKEISANJIKWSRATE)
    public BizNumber getZtydkeisanjikwsrate() {
        return ztydkeisanjikwsrate;
    }

    public void setZtydkeisanjikwsrate(BizNumber pZtydkeisanjikwsrate) {
        ztydkeisanjikwsrate = pZtydkeisanjikwsrate;
    }

    private String ztydkeisanjikwsratetkyymd;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYDKEISANJIKWSRATETKYYMD)
    public String getZtydkeisanjikwsratetkyymd() {
        return ztydkeisanjikwsratetkyymd;
    }

    public void setZtydkeisanjikwsratetkyymd(String pZtydkeisanjikwsratetkyymd) {
        ztydkeisanjikwsratetkyymd = pZtydkeisanjikwsratetkyymd;
    }

    private String ztyyobiv6;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }

    private String ztyyobiv6x2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOBIV6X2)
    public String getZtyyobiv6x2() {
        return ztyyobiv6x2;
    }

    public void setZtyyobiv6x2(String pZtyyobiv6x2) {
        ztyyobiv6x2 = pZtyyobiv6x2;
    }

    private String ztyyobiv6x3;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOBIV6X3)
    public String getZtyyobiv6x3() {
        return ztyyobiv6x3;
    }

    public void setZtyyobiv6x3(String pZtyyobiv6x3) {
        ztyyobiv6x3 = pZtyyobiv6x3;
    }

    private String ztysrdai1hknkkn;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYSRDAI1HKNKKN)
    public String getZtysrdai1hknkkn() {
        return ztysrdai1hknkkn;
    }

    public void setZtysrdai1hknkkn(String pZtysrdai1hknkkn) {
        ztysrdai1hknkkn = pZtysrdai1hknkkn;
    }

    private String ztyyobiv5;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYYOBIV5)
    public String getZtyyobiv5() {
        return ztyyobiv5;
    }

    public void setZtyyobiv5(String pZtyyobiv5) {
        ztyyobiv5 = pZtyyobiv5;
    }

    private String ztytokuyakukoumokuv120;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120)
    public String getZtytokuyakukoumokuv120() {
        return ztytokuyakukoumokuv120;
    }

    public void setZtytokuyakukoumokuv120(String pZtytokuyakukoumokuv120) {
        ztytokuyakukoumokuv120 = pZtytokuyakukoumokuv120;
    }

    private String ztytokuyakukoumokuv120x2;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X2)
    public String getZtytokuyakukoumokuv120x2() {
        return ztytokuyakukoumokuv120x2;
    }

    public void setZtytokuyakukoumokuv120x2(String pZtytokuyakukoumokuv120x2) {
        ztytokuyakukoumokuv120x2 = pZtytokuyakukoumokuv120x2;
    }

    private String ztytokuyakukoumokuv120x3;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X3)
    public String getZtytokuyakukoumokuv120x3() {
        return ztytokuyakukoumokuv120x3;
    }

    public void setZtytokuyakukoumokuv120x3(String pZtytokuyakukoumokuv120x3) {
        ztytokuyakukoumokuv120x3 = pZtytokuyakukoumokuv120x3;
    }

    private String ztytokuyakukoumokuv120x4;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X4)
    public String getZtytokuyakukoumokuv120x4() {
        return ztytokuyakukoumokuv120x4;
    }

    public void setZtytokuyakukoumokuv120x4(String pZtytokuyakukoumokuv120x4) {
        ztytokuyakukoumokuv120x4 = pZtytokuyakukoumokuv120x4;
    }

    private String ztytokuyakukoumokuv120x5;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X5)
    public String getZtytokuyakukoumokuv120x5() {
        return ztytokuyakukoumokuv120x5;
    }

    public void setZtytokuyakukoumokuv120x5(String pZtytokuyakukoumokuv120x5) {
        ztytokuyakukoumokuv120x5 = pZtytokuyakukoumokuv120x5;
    }

    private String ztytokuyakukoumokuv120x6;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X6)
    public String getZtytokuyakukoumokuv120x6() {
        return ztytokuyakukoumokuv120x6;
    }

    public void setZtytokuyakukoumokuv120x6(String pZtytokuyakukoumokuv120x6) {
        ztytokuyakukoumokuv120x6 = pZtytokuyakukoumokuv120x6;
    }

    private String ztytokuyakukoumokuv120x7;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X7)
    public String getZtytokuyakukoumokuv120x7() {
        return ztytokuyakukoumokuv120x7;
    }

    public void setZtytokuyakukoumokuv120x7(String pZtytokuyakukoumokuv120x7) {
        ztytokuyakukoumokuv120x7 = pZtytokuyakukoumokuv120x7;
    }

    private String ztytokuyakukoumokuv120x8;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X8)
    public String getZtytokuyakukoumokuv120x8() {
        return ztytokuyakukoumokuv120x8;
    }

    public void setZtytokuyakukoumokuv120x8(String pZtytokuyakukoumokuv120x8) {
        ztytokuyakukoumokuv120x8 = pZtytokuyakukoumokuv120x8;
    }

    private String ztytokuyakukoumokuv120x9;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X9)
    public String getZtytokuyakukoumokuv120x9() {
        return ztytokuyakukoumokuv120x9;
    }

    public void setZtytokuyakukoumokuv120x9(String pZtytokuyakukoumokuv120x9) {
        ztytokuyakukoumokuv120x9 = pZtytokuyakukoumokuv120x9;
    }

    private String ztytokuyakukoumokuv120x10;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X10)
    public String getZtytokuyakukoumokuv120x10() {
        return ztytokuyakukoumokuv120x10;
    }

    public void setZtytokuyakukoumokuv120x10(String pZtytokuyakukoumokuv120x10) {
        ztytokuyakukoumokuv120x10 = pZtytokuyakukoumokuv120x10;
    }

    private String ztytokuyakukoumokuv120x11;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X11)
    public String getZtytokuyakukoumokuv120x11() {
        return ztytokuyakukoumokuv120x11;
    }

    public void setZtytokuyakukoumokuv120x11(String pZtytokuyakukoumokuv120x11) {
        ztytokuyakukoumokuv120x11 = pZtytokuyakukoumokuv120x11;
    }

    private String ztytokuyakukoumokuv120x12;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X12)
    public String getZtytokuyakukoumokuv120x12() {
        return ztytokuyakukoumokuv120x12;
    }

    public void setZtytokuyakukoumokuv120x12(String pZtytokuyakukoumokuv120x12) {
        ztytokuyakukoumokuv120x12 = pZtytokuyakukoumokuv120x12;
    }

    private String ztytokuyakukoumokuv120x13;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X13)
    public String getZtytokuyakukoumokuv120x13() {
        return ztytokuyakukoumokuv120x13;
    }

    public void setZtytokuyakukoumokuv120x13(String pZtytokuyakukoumokuv120x13) {
        ztytokuyakukoumokuv120x13 = pZtytokuyakukoumokuv120x13;
    }

    private String ztytokuyakukoumokuv120x14;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X14)
    public String getZtytokuyakukoumokuv120x14() {
        return ztytokuyakukoumokuv120x14;
    }

    public void setZtytokuyakukoumokuv120x14(String pZtytokuyakukoumokuv120x14) {
        ztytokuyakukoumokuv120x14 = pZtytokuyakukoumokuv120x14;
    }

    private String ztytokuyakukoumokuv120x15;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X15)
    public String getZtytokuyakukoumokuv120x15() {
        return ztytokuyakukoumokuv120x15;
    }

    public void setZtytokuyakukoumokuv120x15(String pZtytokuyakukoumokuv120x15) {
        ztytokuyakukoumokuv120x15 = pZtytokuyakukoumokuv120x15;
    }

    private String ztytokuyakukoumokuv120x16;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X16)
    public String getZtytokuyakukoumokuv120x16() {
        return ztytokuyakukoumokuv120x16;
    }

    public void setZtytokuyakukoumokuv120x16(String pZtytokuyakukoumokuv120x16) {
        ztytokuyakukoumokuv120x16 = pZtytokuyakukoumokuv120x16;
    }

    private String ztytokuyakukoumokuv120x17;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X17)
    public String getZtytokuyakukoumokuv120x17() {
        return ztytokuyakukoumokuv120x17;
    }

    public void setZtytokuyakukoumokuv120x17(String pZtytokuyakukoumokuv120x17) {
        ztytokuyakukoumokuv120x17 = pZtytokuyakukoumokuv120x17;
    }

    private String ztytokuyakukoumokuv120x18;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X18)
    public String getZtytokuyakukoumokuv120x18() {
        return ztytokuyakukoumokuv120x18;
    }

    public void setZtytokuyakukoumokuv120x18(String pZtytokuyakukoumokuv120x18) {
        ztytokuyakukoumokuv120x18 = pZtytokuyakukoumokuv120x18;
    }

    private String ztytokuyakukoumokuv120x19;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X19)
    public String getZtytokuyakukoumokuv120x19() {
        return ztytokuyakukoumokuv120x19;
    }

    public void setZtytokuyakukoumokuv120x19(String pZtytokuyakukoumokuv120x19) {
        ztytokuyakukoumokuv120x19 = pZtytokuyakukoumokuv120x19;
    }

    private String ztytokuyakukoumokuv120x20;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X20)
    public String getZtytokuyakukoumokuv120x20() {
        return ztytokuyakukoumokuv120x20;
    }

    public void setZtytokuyakukoumokuv120x20(String pZtytokuyakukoumokuv120x20) {
        ztytokuyakukoumokuv120x20 = pZtytokuyakukoumokuv120x20;
    }

    private String ztytokuyakukoumokuv120x21;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X21)
    public String getZtytokuyakukoumokuv120x21() {
        return ztytokuyakukoumokuv120x21;
    }

    public void setZtytokuyakukoumokuv120x21(String pZtytokuyakukoumokuv120x21) {
        ztytokuyakukoumokuv120x21 = pZtytokuyakukoumokuv120x21;
    }

    private String ztytokuyakukoumokuv120x22;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X22)
    public String getZtytokuyakukoumokuv120x22() {
        return ztytokuyakukoumokuv120x22;
    }

    public void setZtytokuyakukoumokuv120x22(String pZtytokuyakukoumokuv120x22) {
        ztytokuyakukoumokuv120x22 = pZtytokuyakukoumokuv120x22;
    }

    private String ztytokuyakukoumokuv120x23;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X23)
    public String getZtytokuyakukoumokuv120x23() {
        return ztytokuyakukoumokuv120x23;
    }

    public void setZtytokuyakukoumokuv120x23(String pZtytokuyakukoumokuv120x23) {
        ztytokuyakukoumokuv120x23 = pZtytokuyakukoumokuv120x23;
    }

    private String ztytokuyakukoumokuv120x24;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X24)
    public String getZtytokuyakukoumokuv120x24() {
        return ztytokuyakukoumokuv120x24;
    }

    public void setZtytokuyakukoumokuv120x24(String pZtytokuyakukoumokuv120x24) {
        ztytokuyakukoumokuv120x24 = pZtytokuyakukoumokuv120x24;
    }

    private String ztytokuyakukoumokuv120x25;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X25)
    public String getZtytokuyakukoumokuv120x25() {
        return ztytokuyakukoumokuv120x25;
    }

    public void setZtytokuyakukoumokuv120x25(String pZtytokuyakukoumokuv120x25) {
        ztytokuyakukoumokuv120x25 = pZtytokuyakukoumokuv120x25;
    }

    private String ztytokuyakukoumokuv120x26;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X26)
    public String getZtytokuyakukoumokuv120x26() {
        return ztytokuyakukoumokuv120x26;
    }

    public void setZtytokuyakukoumokuv120x26(String pZtytokuyakukoumokuv120x26) {
        ztytokuyakukoumokuv120x26 = pZtytokuyakukoumokuv120x26;
    }

    private String ztytokuyakukoumokuv120x27;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X27)
    public String getZtytokuyakukoumokuv120x27() {
        return ztytokuyakukoumokuv120x27;
    }

    public void setZtytokuyakukoumokuv120x27(String pZtytokuyakukoumokuv120x27) {
        ztytokuyakukoumokuv120x27 = pZtytokuyakukoumokuv120x27;
    }

    private String ztytokuyakukoumokuv120x28;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X28)
    public String getZtytokuyakukoumokuv120x28() {
        return ztytokuyakukoumokuv120x28;
    }

    public void setZtytokuyakukoumokuv120x28(String pZtytokuyakukoumokuv120x28) {
        ztytokuyakukoumokuv120x28 = pZtytokuyakukoumokuv120x28;
    }

    private String ztytokuyakukoumokuv120x29;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X29)
    public String getZtytokuyakukoumokuv120x29() {
        return ztytokuyakukoumokuv120x29;
    }

    public void setZtytokuyakukoumokuv120x29(String pZtytokuyakukoumokuv120x29) {
        ztytokuyakukoumokuv120x29 = pZtytokuyakukoumokuv120x29;
    }

    private String ztytokuyakukoumokuv120x30;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X30)
    public String getZtytokuyakukoumokuv120x30() {
        return ztytokuyakukoumokuv120x30;
    }

    public void setZtytokuyakukoumokuv120x30(String pZtytokuyakukoumokuv120x30) {
        ztytokuyakukoumokuv120x30 = pZtytokuyakukoumokuv120x30;
    }

    private String ztytokuyakukoumokuv120x31;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X31)
    public String getZtytokuyakukoumokuv120x31() {
        return ztytokuyakukoumokuv120x31;
    }

    public void setZtytokuyakukoumokuv120x31(String pZtytokuyakukoumokuv120x31) {
        ztytokuyakukoumokuv120x31 = pZtytokuyakukoumokuv120x31;
    }

    private String ztytokuyakukoumokuv120x32;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X32)
    public String getZtytokuyakukoumokuv120x32() {
        return ztytokuyakukoumokuv120x32;
    }

    public void setZtytokuyakukoumokuv120x32(String pZtytokuyakukoumokuv120x32) {
        ztytokuyakukoumokuv120x32 = pZtytokuyakukoumokuv120x32;
    }

    private String ztytokuyakukoumokuv120x33;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X33)
    public String getZtytokuyakukoumokuv120x33() {
        return ztytokuyakukoumokuv120x33;
    }

    public void setZtytokuyakukoumokuv120x33(String pZtytokuyakukoumokuv120x33) {
        ztytokuyakukoumokuv120x33 = pZtytokuyakukoumokuv120x33;
    }

    private String ztytokuyakukoumokuv120x34;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X34)
    public String getZtytokuyakukoumokuv120x34() {
        return ztytokuyakukoumokuv120x34;
    }

    public void setZtytokuyakukoumokuv120x34(String pZtytokuyakukoumokuv120x34) {
        ztytokuyakukoumokuv120x34 = pZtytokuyakukoumokuv120x34;
    }

    private String ztytokuyakukoumokuv120x35;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X35)
    public String getZtytokuyakukoumokuv120x35() {
        return ztytokuyakukoumokuv120x35;
    }

    public void setZtytokuyakukoumokuv120x35(String pZtytokuyakukoumokuv120x35) {
        ztytokuyakukoumokuv120x35 = pZtytokuyakukoumokuv120x35;
    }

    private String ztytokuyakukoumokuv120x36;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X36)
    public String getZtytokuyakukoumokuv120x36() {
        return ztytokuyakukoumokuv120x36;
    }

    public void setZtytokuyakukoumokuv120x36(String pZtytokuyakukoumokuv120x36) {
        ztytokuyakukoumokuv120x36 = pZtytokuyakukoumokuv120x36;
    }

    private String ztytokuyakukoumokuv120x37;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X37)
    public String getZtytokuyakukoumokuv120x37() {
        return ztytokuyakukoumokuv120x37;
    }

    public void setZtytokuyakukoumokuv120x37(String pZtytokuyakukoumokuv120x37) {
        ztytokuyakukoumokuv120x37 = pZtytokuyakukoumokuv120x37;
    }

    private String ztytokuyakukoumokuv120x38;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X38)
    public String getZtytokuyakukoumokuv120x38() {
        return ztytokuyakukoumokuv120x38;
    }

    public void setZtytokuyakukoumokuv120x38(String pZtytokuyakukoumokuv120x38) {
        ztytokuyakukoumokuv120x38 = pZtytokuyakukoumokuv120x38;
    }

    private String ztytokuyakukoumokuv120x39;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X39)
    public String getZtytokuyakukoumokuv120x39() {
        return ztytokuyakukoumokuv120x39;
    }

    public void setZtytokuyakukoumokuv120x39(String pZtytokuyakukoumokuv120x39) {
        ztytokuyakukoumokuv120x39 = pZtytokuyakukoumokuv120x39;
    }

    private String ztytokuyakukoumokuv120x40;

    @Column(name=GenZT_RisaTjHitNplusZeroTy.ZTYTOKUYAKUKOUMOKUV120X40)
    public String getZtytokuyakukoumokuv120x40() {
        return ztytokuyakukoumokuv120x40;
    }

    public void setZtytokuyakukoumokuv120x40(String pZtytokuyakukoumokuv120x40) {
        ztytokuyakukoumokuv120x40 = pZtytokuyakukoumokuv120x40;
    }
}