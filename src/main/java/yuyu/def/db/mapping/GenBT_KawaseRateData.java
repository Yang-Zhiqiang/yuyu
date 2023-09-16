package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.db.entity.BT_KawaseRateData;
import yuyu.def.db.id.PKBT_KawaseRateData;
import yuyu.def.db.meta.GenQBT_KawaseRateData;
import yuyu.def.db.meta.QBT_KawaseRateData;
import yuyu.def.db.type.UserType_C_KwsrendouKbn;

/**
 * 為替レートデータテーブル テーブルのマッピング情報クラスで、 {@link BT_KawaseRateData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_KawaseRateData}</td><td colspan="3">為替レートデータテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKwsratekjymd kwsratekjymd}</td><td>為替レート基準日</td><td align="center">{@link PKBT_KawaseRateData ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKwsrendoukbn kwsrendoukbn}</td><td>為替レート連動区分</td><td align="center">{@link PKBT_KawaseRateData ○}</td><td align="center">V</td><td>{@link C_KwsrendouKbn}</td></tr>
 *  <tr><td>{@link #getYobiv91 yobiv91}</td><td>予備項目Ｖ９１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUsdjpytts usdjpytts}</td><td>米ドル－円（ＴＴＳ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getUsdjpyttb usdjpyttb}</td><td>米ドル－円（ＴＴＢ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getUsdjpyttm usdjpyttm}</td><td>米ドル－円（ＴＴＭ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getEurjpytts eurjpytts}</td><td>ユーロ－円（ＴＴＳ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getEurjpyttb eurjpyttb}</td><td>ユーロ－円（ＴＴＢ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getEurjpyttm eurjpyttm}</td><td>ユーロ－円（ＴＴＭ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getAudjpytts audjpytts}</td><td>豪ドル－円（ＴＴＳ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getAudjpyttb audjpyttb}</td><td>豪ドル－円（ＴＴＢ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getAudjpyttm audjpyttm}</td><td>豪ドル－円（ＴＴＭ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9 yobin9}</td><td>予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x2 yobin9x2}</td><td>予備項目Ｎ９＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x3 yobin9x3}</td><td>予備項目Ｎ９＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x4 yobin9x4}</td><td>予備項目Ｎ９＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x5 yobin9x5}</td><td>予備項目Ｎ９＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x6 yobin9x6}</td><td>予備項目Ｎ９＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x7 yobin9x7}</td><td>予備項目Ｎ９＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x8 yobin9x8}</td><td>予備項目Ｎ９＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x9 yobin9x9}</td><td>予備項目Ｎ９＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x10 yobin9x10}</td><td>予備項目Ｎ９＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x11 yobin9x11}</td><td>予備項目Ｎ９＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x12 yobin9x12}</td><td>予備項目Ｎ９＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x13 yobin9x13}</td><td>予備項目Ｎ９＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x14 yobin9x14}</td><td>予備項目Ｎ９＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x15 yobin9x15}</td><td>予備項目Ｎ９＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x16 yobin9x16}</td><td>予備項目Ｎ９＿１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x17 yobin9x17}</td><td>予備項目Ｎ９＿１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x18 yobin9x18}</td><td>予備項目Ｎ９＿１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x19 yobin9x19}</td><td>予備項目Ｎ９＿１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x20 yobin9x20}</td><td>予備項目Ｎ９＿２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x21 yobin9x21}</td><td>予備項目Ｎ９＿２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getUsdjpynykn usdjpynykn}</td><td>米ドル－円（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getEurjpynykn eurjpynykn}</td><td>ユーロ－円（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getAudjpynykn audjpynykn}</td><td>豪ドル－円（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x101 yobin9x101}</td><td>予備項目Ｎ９＿１０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x102 yobin9x102}</td><td>予備項目Ｎ９＿１０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x103 yobin9x103}</td><td>予備項目Ｎ９＿１０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x104 yobin9x104}</td><td>予備項目Ｎ９＿１０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x105 yobin9x105}</td><td>予備項目Ｎ９＿１０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x106 yobin9x106}</td><td>予備項目Ｎ９＿１０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x107 yobin9x107}</td><td>予備項目Ｎ９＿１０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getUsdeurnykn usdeurnykn}</td><td>米ドル－ユーロ（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getUsdaudnykn usdaudnykn}</td><td>米ドル－豪ドル（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x111 yobin9x111}</td><td>予備項目Ｎ９＿１１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x112 yobin9x112}</td><td>予備項目Ｎ９＿１１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x113 yobin9x113}</td><td>予備項目Ｎ９＿１１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x114 yobin9x114}</td><td>予備項目Ｎ９＿１１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x115 yobin9x115}</td><td>予備項目Ｎ９＿１１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x116 yobin9x116}</td><td>予備項目Ｎ９＿１１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x117 yobin9x117}</td><td>予備項目Ｎ９＿１１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getEurusdnykn eurusdnykn}</td><td>ユーロ－米ドル（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getEuraudnykn euraudnykn}</td><td>ユーロ－豪ドル（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x121 yobin9x121}</td><td>予備項目Ｎ９＿１２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x122 yobin9x122}</td><td>予備項目Ｎ９＿１２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x123 yobin9x123}</td><td>予備項目Ｎ９＿１２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x124 yobin9x124}</td><td>予備項目Ｎ９＿１２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x125 yobin9x125}</td><td>予備項目Ｎ９＿１２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x126 yobin9x126}</td><td>予備項目Ｎ９＿１２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x127 yobin9x127}</td><td>予備項目Ｎ９＿１２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getAudusdnykn audusdnykn}</td><td>豪ドル－米ドル（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getAudeurnykn audeurnykn}</td><td>豪ドル－ユーロ（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x131 yobin9x131}</td><td>予備項目Ｎ９＿１３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x132 yobin9x132}</td><td>予備項目Ｎ９＿１３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x133 yobin9x133}</td><td>予備項目Ｎ９＿１３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x134 yobin9x134}</td><td>予備項目Ｎ９＿１３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x135 yobin9x135}</td><td>予備項目Ｎ９＿１３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x136 yobin9x136}</td><td>予備項目Ｎ９＿１３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x137 yobin9x137}</td><td>予備項目Ｎ９＿１３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x141 yobin9x141}</td><td>予備項目Ｎ９＿１４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x142 yobin9x142}</td><td>予備項目Ｎ９＿１４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x143 yobin9x143}</td><td>予備項目Ｎ９＿１４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x144 yobin9x144}</td><td>予備項目Ｎ９＿１４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x145 yobin9x145}</td><td>予備項目Ｎ９＿１４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x146 yobin9x146}</td><td>予備項目Ｎ９＿１４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x147 yobin9x147}</td><td>予備項目Ｎ９＿１４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x148 yobin9x148}</td><td>予備項目Ｎ９＿１４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x149 yobin9x149}</td><td>予備項目Ｎ９＿１４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x151 yobin9x151}</td><td>予備項目Ｎ９＿１５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x152 yobin9x152}</td><td>予備項目Ｎ９＿１５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x153 yobin9x153}</td><td>予備項目Ｎ９＿１５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x154 yobin9x154}</td><td>予備項目Ｎ９＿１５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x155 yobin9x155}</td><td>予備項目Ｎ９＿１５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x156 yobin9x156}</td><td>予備項目Ｎ９＿１５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x157 yobin9x157}</td><td>予備項目Ｎ９＿１５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x158 yobin9x158}</td><td>予備項目Ｎ９＿１５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x159 yobin9x159}</td><td>予備項目Ｎ９＿１５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x161 yobin9x161}</td><td>予備項目Ｎ９＿１６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x162 yobin9x162}</td><td>予備項目Ｎ９＿１６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x163 yobin9x163}</td><td>予備項目Ｎ９＿１６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x164 yobin9x164}</td><td>予備項目Ｎ９＿１６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x165 yobin9x165}</td><td>予備項目Ｎ９＿１６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x166 yobin9x166}</td><td>予備項目Ｎ９＿１６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x167 yobin9x167}</td><td>予備項目Ｎ９＿１６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x168 yobin9x168}</td><td>予備項目Ｎ９＿１６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x169 yobin9x169}</td><td>予備項目Ｎ９＿１６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x171 yobin9x171}</td><td>予備項目Ｎ９＿１７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x172 yobin9x172}</td><td>予備項目Ｎ９＿１７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x173 yobin9x173}</td><td>予備項目Ｎ９＿１７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x174 yobin9x174}</td><td>予備項目Ｎ９＿１７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x175 yobin9x175}</td><td>予備項目Ｎ９＿１７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x176 yobin9x176}</td><td>予備項目Ｎ９＿１７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x177 yobin9x177}</td><td>予備項目Ｎ９＿１７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x178 yobin9x178}</td><td>予備項目Ｎ９＿１７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x179 yobin9x179}</td><td>予備項目Ｎ９＿１７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x181 yobin9x181}</td><td>予備項目Ｎ９＿１８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x182 yobin9x182}</td><td>予備項目Ｎ９＿１８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x183 yobin9x183}</td><td>予備項目Ｎ９＿１８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x184 yobin9x184}</td><td>予備項目Ｎ９＿１８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x185 yobin9x185}</td><td>予備項目Ｎ９＿１８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x186 yobin9x186}</td><td>予備項目Ｎ９＿１８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x187 yobin9x187}</td><td>予備項目Ｎ９＿１８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x188 yobin9x188}</td><td>予備項目Ｎ９＿１８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x189 yobin9x189}</td><td>予備項目Ｎ９＿１８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x191 yobin9x191}</td><td>予備項目Ｎ９＿１９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x192 yobin9x192}</td><td>予備項目Ｎ９＿１９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x193 yobin9x193}</td><td>予備項目Ｎ９＿１９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x194 yobin9x194}</td><td>予備項目Ｎ９＿１９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x195 yobin9x195}</td><td>予備項目Ｎ９＿１９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x196 yobin9x196}</td><td>予備項目Ｎ９＿１９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x197 yobin9x197}</td><td>予備項目Ｎ９＿１９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x198 yobin9x198}</td><td>予備項目Ｎ９＿１９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x199 yobin9x199}</td><td>予備項目Ｎ９＿１９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x201 yobin9x201}</td><td>予備項目Ｎ９＿２０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x202 yobin9x202}</td><td>予備項目Ｎ９＿２０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x203 yobin9x203}</td><td>予備項目Ｎ９＿２０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x204 yobin9x204}</td><td>予備項目Ｎ９＿２０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x205 yobin9x205}</td><td>予備項目Ｎ９＿２０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x206 yobin9x206}</td><td>予備項目Ｎ９＿２０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x207 yobin9x207}</td><td>予備項目Ｎ９＿２０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x208 yobin9x208}</td><td>予備項目Ｎ９＿２０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x209 yobin9x209}</td><td>予備項目Ｎ９＿２０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getUsdjpysykn usdjpysykn}</td><td>米ドル－円（出金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getEurjpysykn eurjpysykn}</td><td>ユーロ－円（出金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getAudjpysykn audjpysykn}</td><td>豪ドル－円（出金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x301 yobin9x301}</td><td>予備項目Ｎ９＿３０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x302 yobin9x302}</td><td>予備項目Ｎ９＿３０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x303 yobin9x303}</td><td>予備項目Ｎ９＿３０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x304 yobin9x304}</td><td>予備項目Ｎ９＿３０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x305 yobin9x305}</td><td>予備項目Ｎ９＿３０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x306 yobin9x306}</td><td>予備項目Ｎ９＿３０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x307 yobin9x307}</td><td>予備項目Ｎ９＿３０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getUsdjpytts17pm usdjpytts17pm}</td><td>米ドル－円（ＴＴＳ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getUsdjpyttb17pm usdjpyttb17pm}</td><td>米ドル－円（ＴＴＢ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getUsdjpyttm17pm usdjpyttm17pm}</td><td>米ドル－円（ＴＴＭ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getEurjpytts17pm eurjpytts17pm}</td><td>ユーロ－円（ＴＴＳ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getEurjpyttb17pm eurjpyttb17pm}</td><td>ユーロ－円（ＴＴＢ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getEurjpyttm17pm eurjpyttm17pm}</td><td>ユーロ－円（ＴＴＭ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getAudjpytts17pm audjpytts17pm}</td><td>豪ドル－円（ＴＴＳ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getAudjpyttb17pm audjpyttb17pm}</td><td>豪ドル－円（ＴＴＢ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getAudjpyttm17pm audjpyttm17pm}</td><td>豪ドル－円（ＴＴＭ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x501 yobin9x501}</td><td>予備項目Ｎ９＿５０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x502 yobin9x502}</td><td>予備項目Ｎ９＿５０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x503 yobin9x503}</td><td>予備項目Ｎ９＿５０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x504 yobin9x504}</td><td>予備項目Ｎ９＿５０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x505 yobin9x505}</td><td>予備項目Ｎ９＿５０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x506 yobin9x506}</td><td>予備項目Ｎ９＿５０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x507 yobin9x507}</td><td>予備項目Ｎ９＿５０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x508 yobin9x508}</td><td>予備項目Ｎ９＿５０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x509 yobin9x509}</td><td>予備項目Ｎ９＿５０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x510 yobin9x510}</td><td>予備項目Ｎ９＿５１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x511 yobin9x511}</td><td>予備項目Ｎ９＿５１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x512 yobin9x512}</td><td>予備項目Ｎ９＿５１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x513 yobin9x513}</td><td>予備項目Ｎ９＿５１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x514 yobin9x514}</td><td>予備項目Ｎ９＿５１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x515 yobin9x515}</td><td>予備項目Ｎ９＿５１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x516 yobin9x516}</td><td>予備項目Ｎ９＿５１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x517 yobin9x517}</td><td>予備項目Ｎ９＿５１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x518 yobin9x518}</td><td>予備項目Ｎ９＿５１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x519 yobin9x519}</td><td>予備項目Ｎ９＿５１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x520 yobin9x520}</td><td>予備項目Ｎ９＿５２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getYobin9x521 yobin9x521}</td><td>予備項目Ｎ９＿５２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 * </table>
 * @see     BT_KawaseRateData
 * @see     PKBT_KawaseRateData
 * @see     QBT_KawaseRateData
 * @see     GenQBT_KawaseRateData
 */
@MappedSuperclass
@Table(name=GenBT_KawaseRateData.TABLE_NAME)
@IdClass(value=PKBT_KawaseRateData.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KwsrendouKbn", typeClass=UserType_C_KwsrendouKbn.class)
})
public abstract class GenBT_KawaseRateData extends AbstractExDBEntity<BT_KawaseRateData, PKBT_KawaseRateData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_KawaseRateData";
    public static final String KWSRATEKJYMD             = "kwsratekjymd";
    public static final String KWSRENDOUKBN             = "kwsrendoukbn";
    public static final String YOBIV91                  = "yobiv91";
    public static final String USDJPYTTS                = "usdjpytts";
    public static final String USDJPYTTB                = "usdjpyttb";
    public static final String USDJPYTTM                = "usdjpyttm";
    public static final String EURJPYTTS                = "eurjpytts";
    public static final String EURJPYTTB                = "eurjpyttb";
    public static final String EURJPYTTM                = "eurjpyttm";
    public static final String AUDJPYTTS                = "audjpytts";
    public static final String AUDJPYTTB                = "audjpyttb";
    public static final String AUDJPYTTM                = "audjpyttm";
    public static final String YOBIN9                   = "yobin9";
    public static final String YOBIN9X2                 = "yobin9x2";
    public static final String YOBIN9X3                 = "yobin9x3";
    public static final String YOBIN9X4                 = "yobin9x4";
    public static final String YOBIN9X5                 = "yobin9x5";
    public static final String YOBIN9X6                 = "yobin9x6";
    public static final String YOBIN9X7                 = "yobin9x7";
    public static final String YOBIN9X8                 = "yobin9x8";
    public static final String YOBIN9X9                 = "yobin9x9";
    public static final String YOBIN9X10                = "yobin9x10";
    public static final String YOBIN9X11                = "yobin9x11";
    public static final String YOBIN9X12                = "yobin9x12";
    public static final String YOBIN9X13                = "yobin9x13";
    public static final String YOBIN9X14                = "yobin9x14";
    public static final String YOBIN9X15                = "yobin9x15";
    public static final String YOBIN9X16                = "yobin9x16";
    public static final String YOBIN9X17                = "yobin9x17";
    public static final String YOBIN9X18                = "yobin9x18";
    public static final String YOBIN9X19                = "yobin9x19";
    public static final String YOBIN9X20                = "yobin9x20";
    public static final String YOBIN9X21                = "yobin9x21";
    public static final String USDJPYNYKN               = "usdjpynykn";
    public static final String EURJPYNYKN               = "eurjpynykn";
    public static final String AUDJPYNYKN               = "audjpynykn";
    public static final String YOBIN9X101               = "yobin9x101";
    public static final String YOBIN9X102               = "yobin9x102";
    public static final String YOBIN9X103               = "yobin9x103";
    public static final String YOBIN9X104               = "yobin9x104";
    public static final String YOBIN9X105               = "yobin9x105";
    public static final String YOBIN9X106               = "yobin9x106";
    public static final String YOBIN9X107               = "yobin9x107";
    public static final String USDEURNYKN               = "usdeurnykn";
    public static final String USDAUDNYKN               = "usdaudnykn";
    public static final String YOBIN9X111               = "yobin9x111";
    public static final String YOBIN9X112               = "yobin9x112";
    public static final String YOBIN9X113               = "yobin9x113";
    public static final String YOBIN9X114               = "yobin9x114";
    public static final String YOBIN9X115               = "yobin9x115";
    public static final String YOBIN9X116               = "yobin9x116";
    public static final String YOBIN9X117               = "yobin9x117";
    public static final String EURUSDNYKN               = "eurusdnykn";
    public static final String EURAUDNYKN               = "euraudnykn";
    public static final String YOBIN9X121               = "yobin9x121";
    public static final String YOBIN9X122               = "yobin9x122";
    public static final String YOBIN9X123               = "yobin9x123";
    public static final String YOBIN9X124               = "yobin9x124";
    public static final String YOBIN9X125               = "yobin9x125";
    public static final String YOBIN9X126               = "yobin9x126";
    public static final String YOBIN9X127               = "yobin9x127";
    public static final String AUDUSDNYKN               = "audusdnykn";
    public static final String AUDEURNYKN               = "audeurnykn";
    public static final String YOBIN9X131               = "yobin9x131";
    public static final String YOBIN9X132               = "yobin9x132";
    public static final String YOBIN9X133               = "yobin9x133";
    public static final String YOBIN9X134               = "yobin9x134";
    public static final String YOBIN9X135               = "yobin9x135";
    public static final String YOBIN9X136               = "yobin9x136";
    public static final String YOBIN9X137               = "yobin9x137";
    public static final String YOBIN9X141               = "yobin9x141";
    public static final String YOBIN9X142               = "yobin9x142";
    public static final String YOBIN9X143               = "yobin9x143";
    public static final String YOBIN9X144               = "yobin9x144";
    public static final String YOBIN9X145               = "yobin9x145";
    public static final String YOBIN9X146               = "yobin9x146";
    public static final String YOBIN9X147               = "yobin9x147";
    public static final String YOBIN9X148               = "yobin9x148";
    public static final String YOBIN9X149               = "yobin9x149";
    public static final String YOBIN9X151               = "yobin9x151";
    public static final String YOBIN9X152               = "yobin9x152";
    public static final String YOBIN9X153               = "yobin9x153";
    public static final String YOBIN9X154               = "yobin9x154";
    public static final String YOBIN9X155               = "yobin9x155";
    public static final String YOBIN9X156               = "yobin9x156";
    public static final String YOBIN9X157               = "yobin9x157";
    public static final String YOBIN9X158               = "yobin9x158";
    public static final String YOBIN9X159               = "yobin9x159";
    public static final String YOBIN9X161               = "yobin9x161";
    public static final String YOBIN9X162               = "yobin9x162";
    public static final String YOBIN9X163               = "yobin9x163";
    public static final String YOBIN9X164               = "yobin9x164";
    public static final String YOBIN9X165               = "yobin9x165";
    public static final String YOBIN9X166               = "yobin9x166";
    public static final String YOBIN9X167               = "yobin9x167";
    public static final String YOBIN9X168               = "yobin9x168";
    public static final String YOBIN9X169               = "yobin9x169";
    public static final String YOBIN9X171               = "yobin9x171";
    public static final String YOBIN9X172               = "yobin9x172";
    public static final String YOBIN9X173               = "yobin9x173";
    public static final String YOBIN9X174               = "yobin9x174";
    public static final String YOBIN9X175               = "yobin9x175";
    public static final String YOBIN9X176               = "yobin9x176";
    public static final String YOBIN9X177               = "yobin9x177";
    public static final String YOBIN9X178               = "yobin9x178";
    public static final String YOBIN9X179               = "yobin9x179";
    public static final String YOBIN9X181               = "yobin9x181";
    public static final String YOBIN9X182               = "yobin9x182";
    public static final String YOBIN9X183               = "yobin9x183";
    public static final String YOBIN9X184               = "yobin9x184";
    public static final String YOBIN9X185               = "yobin9x185";
    public static final String YOBIN9X186               = "yobin9x186";
    public static final String YOBIN9X187               = "yobin9x187";
    public static final String YOBIN9X188               = "yobin9x188";
    public static final String YOBIN9X189               = "yobin9x189";
    public static final String YOBIN9X191               = "yobin9x191";
    public static final String YOBIN9X192               = "yobin9x192";
    public static final String YOBIN9X193               = "yobin9x193";
    public static final String YOBIN9X194               = "yobin9x194";
    public static final String YOBIN9X195               = "yobin9x195";
    public static final String YOBIN9X196               = "yobin9x196";
    public static final String YOBIN9X197               = "yobin9x197";
    public static final String YOBIN9X198               = "yobin9x198";
    public static final String YOBIN9X199               = "yobin9x199";
    public static final String YOBIN9X201               = "yobin9x201";
    public static final String YOBIN9X202               = "yobin9x202";
    public static final String YOBIN9X203               = "yobin9x203";
    public static final String YOBIN9X204               = "yobin9x204";
    public static final String YOBIN9X205               = "yobin9x205";
    public static final String YOBIN9X206               = "yobin9x206";
    public static final String YOBIN9X207               = "yobin9x207";
    public static final String YOBIN9X208               = "yobin9x208";
    public static final String YOBIN9X209               = "yobin9x209";
    public static final String USDJPYSYKN               = "usdjpysykn";
    public static final String EURJPYSYKN               = "eurjpysykn";
    public static final String AUDJPYSYKN               = "audjpysykn";
    public static final String YOBIN9X301               = "yobin9x301";
    public static final String YOBIN9X302               = "yobin9x302";
    public static final String YOBIN9X303               = "yobin9x303";
    public static final String YOBIN9X304               = "yobin9x304";
    public static final String YOBIN9X305               = "yobin9x305";
    public static final String YOBIN9X306               = "yobin9x306";
    public static final String YOBIN9X307               = "yobin9x307";
    public static final String USDJPYTTS17PM            = "usdjpytts17pm";
    public static final String USDJPYTTB17PM            = "usdjpyttb17pm";
    public static final String USDJPYTTM17PM            = "usdjpyttm17pm";
    public static final String EURJPYTTS17PM            = "eurjpytts17pm";
    public static final String EURJPYTTB17PM            = "eurjpyttb17pm";
    public static final String EURJPYTTM17PM            = "eurjpyttm17pm";
    public static final String AUDJPYTTS17PM            = "audjpytts17pm";
    public static final String AUDJPYTTB17PM            = "audjpyttb17pm";
    public static final String AUDJPYTTM17PM            = "audjpyttm17pm";
    public static final String YOBIN9X501               = "yobin9x501";
    public static final String YOBIN9X502               = "yobin9x502";
    public static final String YOBIN9X503               = "yobin9x503";
    public static final String YOBIN9X504               = "yobin9x504";
    public static final String YOBIN9X505               = "yobin9x505";
    public static final String YOBIN9X506               = "yobin9x506";
    public static final String YOBIN9X507               = "yobin9x507";
    public static final String YOBIN9X508               = "yobin9x508";
    public static final String YOBIN9X509               = "yobin9x509";
    public static final String YOBIN9X510               = "yobin9x510";
    public static final String YOBIN9X511               = "yobin9x511";
    public static final String YOBIN9X512               = "yobin9x512";
    public static final String YOBIN9X513               = "yobin9x513";
    public static final String YOBIN9X514               = "yobin9x514";
    public static final String YOBIN9X515               = "yobin9x515";
    public static final String YOBIN9X516               = "yobin9x516";
    public static final String YOBIN9X517               = "yobin9x517";
    public static final String YOBIN9X518               = "yobin9x518";
    public static final String YOBIN9X519               = "yobin9x519";
    public static final String YOBIN9X520               = "yobin9x520";
    public static final String YOBIN9X521               = "yobin9x521";

    private final PKBT_KawaseRateData primaryKey;

    public GenBT_KawaseRateData() {
        primaryKey = new PKBT_KawaseRateData();
    }

    public GenBT_KawaseRateData(BizDate pKwsratekjymd, C_KwsrendouKbn pKwsrendoukbn) {
        primaryKey = new PKBT_KawaseRateData(pKwsratekjymd, pKwsrendoukbn);
    }

    @Transient
    @Override
    public PKBT_KawaseRateData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_KawaseRateData> getMetaClass() {
        return QBT_KawaseRateData.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBT_KawaseRateData.KWSRATEKJYMD)
    public BizDate getKwsratekjymd() {
        return getPrimaryKey().getKwsratekjymd();
    }

    public void setKwsratekjymd(BizDate pKwsratekjymd) {
        getPrimaryKey().setKwsratekjymd(pKwsratekjymd);
    }

    @Id
    @Type(type="UserType_C_KwsrendouKbn")
    @Column(name=GenBT_KawaseRateData.KWSRENDOUKBN)
    public C_KwsrendouKbn getKwsrendoukbn() {
        return getPrimaryKey().getKwsrendoukbn();
    }

    public void setKwsrendoukbn(C_KwsrendouKbn pKwsrendoukbn) {
        getPrimaryKey().setKwsrendoukbn(pKwsrendoukbn);
    }

    private String yobiv91;

    @Column(name=GenBT_KawaseRateData.YOBIV91)
    public String getYobiv91() {
        return yobiv91;
    }

    public void setYobiv91(String pYobiv91) {
        yobiv91 = pYobiv91;
    }

    private Double usdjpytts;

    @Column(name=GenBT_KawaseRateData.USDJPYTTS)
    public Double getUsdjpytts() {
        return usdjpytts;
    }

    public void setUsdjpytts(Double pUsdjpytts) {
        usdjpytts = pUsdjpytts;
    }

    private Double usdjpyttb;

    @Column(name=GenBT_KawaseRateData.USDJPYTTB)
    public Double getUsdjpyttb() {
        return usdjpyttb;
    }

    public void setUsdjpyttb(Double pUsdjpyttb) {
        usdjpyttb = pUsdjpyttb;
    }

    private Double usdjpyttm;

    @Column(name=GenBT_KawaseRateData.USDJPYTTM)
    public Double getUsdjpyttm() {
        return usdjpyttm;
    }

    public void setUsdjpyttm(Double pUsdjpyttm) {
        usdjpyttm = pUsdjpyttm;
    }

    private Double eurjpytts;

    @Column(name=GenBT_KawaseRateData.EURJPYTTS)
    public Double getEurjpytts() {
        return eurjpytts;
    }

    public void setEurjpytts(Double pEurjpytts) {
        eurjpytts = pEurjpytts;
    }

    private Double eurjpyttb;

    @Column(name=GenBT_KawaseRateData.EURJPYTTB)
    public Double getEurjpyttb() {
        return eurjpyttb;
    }

    public void setEurjpyttb(Double pEurjpyttb) {
        eurjpyttb = pEurjpyttb;
    }

    private Double eurjpyttm;

    @Column(name=GenBT_KawaseRateData.EURJPYTTM)
    public Double getEurjpyttm() {
        return eurjpyttm;
    }

    public void setEurjpyttm(Double pEurjpyttm) {
        eurjpyttm = pEurjpyttm;
    }

    private Double audjpytts;

    @Column(name=GenBT_KawaseRateData.AUDJPYTTS)
    public Double getAudjpytts() {
        return audjpytts;
    }

    public void setAudjpytts(Double pAudjpytts) {
        audjpytts = pAudjpytts;
    }

    private Double audjpyttb;

    @Column(name=GenBT_KawaseRateData.AUDJPYTTB)
    public Double getAudjpyttb() {
        return audjpyttb;
    }

    public void setAudjpyttb(Double pAudjpyttb) {
        audjpyttb = pAudjpyttb;
    }

    private Double audjpyttm;

    @Column(name=GenBT_KawaseRateData.AUDJPYTTM)
    public Double getAudjpyttm() {
        return audjpyttm;
    }

    public void setAudjpyttm(Double pAudjpyttm) {
        audjpyttm = pAudjpyttm;
    }

    private Double yobin9;

    @Column(name=GenBT_KawaseRateData.YOBIN9)
    public Double getYobin9() {
        return yobin9;
    }

    public void setYobin9(Double pYobin9) {
        yobin9 = pYobin9;
    }

    private Double yobin9x2;

    @Column(name=GenBT_KawaseRateData.YOBIN9X2)
    public Double getYobin9x2() {
        return yobin9x2;
    }

    public void setYobin9x2(Double pYobin9x2) {
        yobin9x2 = pYobin9x2;
    }

    private Double yobin9x3;

    @Column(name=GenBT_KawaseRateData.YOBIN9X3)
    public Double getYobin9x3() {
        return yobin9x3;
    }

    public void setYobin9x3(Double pYobin9x3) {
        yobin9x3 = pYobin9x3;
    }

    private Double yobin9x4;

    @Column(name=GenBT_KawaseRateData.YOBIN9X4)
    public Double getYobin9x4() {
        return yobin9x4;
    }

    public void setYobin9x4(Double pYobin9x4) {
        yobin9x4 = pYobin9x4;
    }

    private Double yobin9x5;

    @Column(name=GenBT_KawaseRateData.YOBIN9X5)
    public Double getYobin9x5() {
        return yobin9x5;
    }

    public void setYobin9x5(Double pYobin9x5) {
        yobin9x5 = pYobin9x5;
    }

    private Double yobin9x6;

    @Column(name=GenBT_KawaseRateData.YOBIN9X6)
    public Double getYobin9x6() {
        return yobin9x6;
    }

    public void setYobin9x6(Double pYobin9x6) {
        yobin9x6 = pYobin9x6;
    }

    private Double yobin9x7;

    @Column(name=GenBT_KawaseRateData.YOBIN9X7)
    public Double getYobin9x7() {
        return yobin9x7;
    }

    public void setYobin9x7(Double pYobin9x7) {
        yobin9x7 = pYobin9x7;
    }

    private Double yobin9x8;

    @Column(name=GenBT_KawaseRateData.YOBIN9X8)
    public Double getYobin9x8() {
        return yobin9x8;
    }

    public void setYobin9x8(Double pYobin9x8) {
        yobin9x8 = pYobin9x8;
    }

    private Double yobin9x9;

    @Column(name=GenBT_KawaseRateData.YOBIN9X9)
    public Double getYobin9x9() {
        return yobin9x9;
    }

    public void setYobin9x9(Double pYobin9x9) {
        yobin9x9 = pYobin9x9;
    }

    private Double yobin9x10;

    @Column(name=GenBT_KawaseRateData.YOBIN9X10)
    public Double getYobin9x10() {
        return yobin9x10;
    }

    public void setYobin9x10(Double pYobin9x10) {
        yobin9x10 = pYobin9x10;
    }

    private Double yobin9x11;

    @Column(name=GenBT_KawaseRateData.YOBIN9X11)
    public Double getYobin9x11() {
        return yobin9x11;
    }

    public void setYobin9x11(Double pYobin9x11) {
        yobin9x11 = pYobin9x11;
    }

    private Double yobin9x12;

    @Column(name=GenBT_KawaseRateData.YOBIN9X12)
    public Double getYobin9x12() {
        return yobin9x12;
    }

    public void setYobin9x12(Double pYobin9x12) {
        yobin9x12 = pYobin9x12;
    }

    private Double yobin9x13;

    @Column(name=GenBT_KawaseRateData.YOBIN9X13)
    public Double getYobin9x13() {
        return yobin9x13;
    }

    public void setYobin9x13(Double pYobin9x13) {
        yobin9x13 = pYobin9x13;
    }

    private Double yobin9x14;

    @Column(name=GenBT_KawaseRateData.YOBIN9X14)
    public Double getYobin9x14() {
        return yobin9x14;
    }

    public void setYobin9x14(Double pYobin9x14) {
        yobin9x14 = pYobin9x14;
    }

    private Double yobin9x15;

    @Column(name=GenBT_KawaseRateData.YOBIN9X15)
    public Double getYobin9x15() {
        return yobin9x15;
    }

    public void setYobin9x15(Double pYobin9x15) {
        yobin9x15 = pYobin9x15;
    }

    private Double yobin9x16;

    @Column(name=GenBT_KawaseRateData.YOBIN9X16)
    public Double getYobin9x16() {
        return yobin9x16;
    }

    public void setYobin9x16(Double pYobin9x16) {
        yobin9x16 = pYobin9x16;
    }

    private Double yobin9x17;

    @Column(name=GenBT_KawaseRateData.YOBIN9X17)
    public Double getYobin9x17() {
        return yobin9x17;
    }

    public void setYobin9x17(Double pYobin9x17) {
        yobin9x17 = pYobin9x17;
    }

    private Double yobin9x18;

    @Column(name=GenBT_KawaseRateData.YOBIN9X18)
    public Double getYobin9x18() {
        return yobin9x18;
    }

    public void setYobin9x18(Double pYobin9x18) {
        yobin9x18 = pYobin9x18;
    }

    private Double yobin9x19;

    @Column(name=GenBT_KawaseRateData.YOBIN9X19)
    public Double getYobin9x19() {
        return yobin9x19;
    }

    public void setYobin9x19(Double pYobin9x19) {
        yobin9x19 = pYobin9x19;
    }

    private Double yobin9x20;

    @Column(name=GenBT_KawaseRateData.YOBIN9X20)
    public Double getYobin9x20() {
        return yobin9x20;
    }

    public void setYobin9x20(Double pYobin9x20) {
        yobin9x20 = pYobin9x20;
    }

    private Double yobin9x21;

    @Column(name=GenBT_KawaseRateData.YOBIN9X21)
    public Double getYobin9x21() {
        return yobin9x21;
    }

    public void setYobin9x21(Double pYobin9x21) {
        yobin9x21 = pYobin9x21;
    }

    private Double usdjpynykn;

    @Column(name=GenBT_KawaseRateData.USDJPYNYKN)
    public Double getUsdjpynykn() {
        return usdjpynykn;
    }

    public void setUsdjpynykn(Double pUsdjpynykn) {
        usdjpynykn = pUsdjpynykn;
    }

    private Double eurjpynykn;

    @Column(name=GenBT_KawaseRateData.EURJPYNYKN)
    public Double getEurjpynykn() {
        return eurjpynykn;
    }

    public void setEurjpynykn(Double pEurjpynykn) {
        eurjpynykn = pEurjpynykn;
    }

    private Double audjpynykn;

    @Column(name=GenBT_KawaseRateData.AUDJPYNYKN)
    public Double getAudjpynykn() {
        return audjpynykn;
    }

    public void setAudjpynykn(Double pAudjpynykn) {
        audjpynykn = pAudjpynykn;
    }

    private Double yobin9x101;

    @Column(name=GenBT_KawaseRateData.YOBIN9X101)
    public Double getYobin9x101() {
        return yobin9x101;
    }

    public void setYobin9x101(Double pYobin9x101) {
        yobin9x101 = pYobin9x101;
    }

    private Double yobin9x102;

    @Column(name=GenBT_KawaseRateData.YOBIN9X102)
    public Double getYobin9x102() {
        return yobin9x102;
    }

    public void setYobin9x102(Double pYobin9x102) {
        yobin9x102 = pYobin9x102;
    }

    private Double yobin9x103;

    @Column(name=GenBT_KawaseRateData.YOBIN9X103)
    public Double getYobin9x103() {
        return yobin9x103;
    }

    public void setYobin9x103(Double pYobin9x103) {
        yobin9x103 = pYobin9x103;
    }

    private Double yobin9x104;

    @Column(name=GenBT_KawaseRateData.YOBIN9X104)
    public Double getYobin9x104() {
        return yobin9x104;
    }

    public void setYobin9x104(Double pYobin9x104) {
        yobin9x104 = pYobin9x104;
    }

    private Double yobin9x105;

    @Column(name=GenBT_KawaseRateData.YOBIN9X105)
    public Double getYobin9x105() {
        return yobin9x105;
    }

    public void setYobin9x105(Double pYobin9x105) {
        yobin9x105 = pYobin9x105;
    }

    private Double yobin9x106;

    @Column(name=GenBT_KawaseRateData.YOBIN9X106)
    public Double getYobin9x106() {
        return yobin9x106;
    }

    public void setYobin9x106(Double pYobin9x106) {
        yobin9x106 = pYobin9x106;
    }

    private Double yobin9x107;

    @Column(name=GenBT_KawaseRateData.YOBIN9X107)
    public Double getYobin9x107() {
        return yobin9x107;
    }

    public void setYobin9x107(Double pYobin9x107) {
        yobin9x107 = pYobin9x107;
    }

    private Double usdeurnykn;

    @Column(name=GenBT_KawaseRateData.USDEURNYKN)
    public Double getUsdeurnykn() {
        return usdeurnykn;
    }

    public void setUsdeurnykn(Double pUsdeurnykn) {
        usdeurnykn = pUsdeurnykn;
    }

    private Double usdaudnykn;

    @Column(name=GenBT_KawaseRateData.USDAUDNYKN)
    public Double getUsdaudnykn() {
        return usdaudnykn;
    }

    public void setUsdaudnykn(Double pUsdaudnykn) {
        usdaudnykn = pUsdaudnykn;
    }

    private Double yobin9x111;

    @Column(name=GenBT_KawaseRateData.YOBIN9X111)
    public Double getYobin9x111() {
        return yobin9x111;
    }

    public void setYobin9x111(Double pYobin9x111) {
        yobin9x111 = pYobin9x111;
    }

    private Double yobin9x112;

    @Column(name=GenBT_KawaseRateData.YOBIN9X112)
    public Double getYobin9x112() {
        return yobin9x112;
    }

    public void setYobin9x112(Double pYobin9x112) {
        yobin9x112 = pYobin9x112;
    }

    private Double yobin9x113;

    @Column(name=GenBT_KawaseRateData.YOBIN9X113)
    public Double getYobin9x113() {
        return yobin9x113;
    }

    public void setYobin9x113(Double pYobin9x113) {
        yobin9x113 = pYobin9x113;
    }

    private Double yobin9x114;

    @Column(name=GenBT_KawaseRateData.YOBIN9X114)
    public Double getYobin9x114() {
        return yobin9x114;
    }

    public void setYobin9x114(Double pYobin9x114) {
        yobin9x114 = pYobin9x114;
    }

    private Double yobin9x115;

    @Column(name=GenBT_KawaseRateData.YOBIN9X115)
    public Double getYobin9x115() {
        return yobin9x115;
    }

    public void setYobin9x115(Double pYobin9x115) {
        yobin9x115 = pYobin9x115;
    }

    private Double yobin9x116;

    @Column(name=GenBT_KawaseRateData.YOBIN9X116)
    public Double getYobin9x116() {
        return yobin9x116;
    }

    public void setYobin9x116(Double pYobin9x116) {
        yobin9x116 = pYobin9x116;
    }

    private Double yobin9x117;

    @Column(name=GenBT_KawaseRateData.YOBIN9X117)
    public Double getYobin9x117() {
        return yobin9x117;
    }

    public void setYobin9x117(Double pYobin9x117) {
        yobin9x117 = pYobin9x117;
    }

    private Double eurusdnykn;

    @Column(name=GenBT_KawaseRateData.EURUSDNYKN)
    public Double getEurusdnykn() {
        return eurusdnykn;
    }

    public void setEurusdnykn(Double pEurusdnykn) {
        eurusdnykn = pEurusdnykn;
    }

    private Double euraudnykn;

    @Column(name=GenBT_KawaseRateData.EURAUDNYKN)
    public Double getEuraudnykn() {
        return euraudnykn;
    }

    public void setEuraudnykn(Double pEuraudnykn) {
        euraudnykn = pEuraudnykn;
    }

    private Double yobin9x121;

    @Column(name=GenBT_KawaseRateData.YOBIN9X121)
    public Double getYobin9x121() {
        return yobin9x121;
    }

    public void setYobin9x121(Double pYobin9x121) {
        yobin9x121 = pYobin9x121;
    }

    private Double yobin9x122;

    @Column(name=GenBT_KawaseRateData.YOBIN9X122)
    public Double getYobin9x122() {
        return yobin9x122;
    }

    public void setYobin9x122(Double pYobin9x122) {
        yobin9x122 = pYobin9x122;
    }

    private Double yobin9x123;

    @Column(name=GenBT_KawaseRateData.YOBIN9X123)
    public Double getYobin9x123() {
        return yobin9x123;
    }

    public void setYobin9x123(Double pYobin9x123) {
        yobin9x123 = pYobin9x123;
    }

    private Double yobin9x124;

    @Column(name=GenBT_KawaseRateData.YOBIN9X124)
    public Double getYobin9x124() {
        return yobin9x124;
    }

    public void setYobin9x124(Double pYobin9x124) {
        yobin9x124 = pYobin9x124;
    }

    private Double yobin9x125;

    @Column(name=GenBT_KawaseRateData.YOBIN9X125)
    public Double getYobin9x125() {
        return yobin9x125;
    }

    public void setYobin9x125(Double pYobin9x125) {
        yobin9x125 = pYobin9x125;
    }

    private Double yobin9x126;

    @Column(name=GenBT_KawaseRateData.YOBIN9X126)
    public Double getYobin9x126() {
        return yobin9x126;
    }

    public void setYobin9x126(Double pYobin9x126) {
        yobin9x126 = pYobin9x126;
    }

    private Double yobin9x127;

    @Column(name=GenBT_KawaseRateData.YOBIN9X127)
    public Double getYobin9x127() {
        return yobin9x127;
    }

    public void setYobin9x127(Double pYobin9x127) {
        yobin9x127 = pYobin9x127;
    }

    private Double audusdnykn;

    @Column(name=GenBT_KawaseRateData.AUDUSDNYKN)
    public Double getAudusdnykn() {
        return audusdnykn;
    }

    public void setAudusdnykn(Double pAudusdnykn) {
        audusdnykn = pAudusdnykn;
    }

    private Double audeurnykn;

    @Column(name=GenBT_KawaseRateData.AUDEURNYKN)
    public Double getAudeurnykn() {
        return audeurnykn;
    }

    public void setAudeurnykn(Double pAudeurnykn) {
        audeurnykn = pAudeurnykn;
    }

    private Double yobin9x131;

    @Column(name=GenBT_KawaseRateData.YOBIN9X131)
    public Double getYobin9x131() {
        return yobin9x131;
    }

    public void setYobin9x131(Double pYobin9x131) {
        yobin9x131 = pYobin9x131;
    }

    private Double yobin9x132;

    @Column(name=GenBT_KawaseRateData.YOBIN9X132)
    public Double getYobin9x132() {
        return yobin9x132;
    }

    public void setYobin9x132(Double pYobin9x132) {
        yobin9x132 = pYobin9x132;
    }

    private Double yobin9x133;

    @Column(name=GenBT_KawaseRateData.YOBIN9X133)
    public Double getYobin9x133() {
        return yobin9x133;
    }

    public void setYobin9x133(Double pYobin9x133) {
        yobin9x133 = pYobin9x133;
    }

    private Double yobin9x134;

    @Column(name=GenBT_KawaseRateData.YOBIN9X134)
    public Double getYobin9x134() {
        return yobin9x134;
    }

    public void setYobin9x134(Double pYobin9x134) {
        yobin9x134 = pYobin9x134;
    }

    private Double yobin9x135;

    @Column(name=GenBT_KawaseRateData.YOBIN9X135)
    public Double getYobin9x135() {
        return yobin9x135;
    }

    public void setYobin9x135(Double pYobin9x135) {
        yobin9x135 = pYobin9x135;
    }

    private Double yobin9x136;

    @Column(name=GenBT_KawaseRateData.YOBIN9X136)
    public Double getYobin9x136() {
        return yobin9x136;
    }

    public void setYobin9x136(Double pYobin9x136) {
        yobin9x136 = pYobin9x136;
    }

    private Double yobin9x137;

    @Column(name=GenBT_KawaseRateData.YOBIN9X137)
    public Double getYobin9x137() {
        return yobin9x137;
    }

    public void setYobin9x137(Double pYobin9x137) {
        yobin9x137 = pYobin9x137;
    }

    private Double yobin9x141;

    @Column(name=GenBT_KawaseRateData.YOBIN9X141)
    public Double getYobin9x141() {
        return yobin9x141;
    }

    public void setYobin9x141(Double pYobin9x141) {
        yobin9x141 = pYobin9x141;
    }

    private Double yobin9x142;

    @Column(name=GenBT_KawaseRateData.YOBIN9X142)
    public Double getYobin9x142() {
        return yobin9x142;
    }

    public void setYobin9x142(Double pYobin9x142) {
        yobin9x142 = pYobin9x142;
    }

    private Double yobin9x143;

    @Column(name=GenBT_KawaseRateData.YOBIN9X143)
    public Double getYobin9x143() {
        return yobin9x143;
    }

    public void setYobin9x143(Double pYobin9x143) {
        yobin9x143 = pYobin9x143;
    }

    private Double yobin9x144;

    @Column(name=GenBT_KawaseRateData.YOBIN9X144)
    public Double getYobin9x144() {
        return yobin9x144;
    }

    public void setYobin9x144(Double pYobin9x144) {
        yobin9x144 = pYobin9x144;
    }

    private Double yobin9x145;

    @Column(name=GenBT_KawaseRateData.YOBIN9X145)
    public Double getYobin9x145() {
        return yobin9x145;
    }

    public void setYobin9x145(Double pYobin9x145) {
        yobin9x145 = pYobin9x145;
    }

    private Double yobin9x146;

    @Column(name=GenBT_KawaseRateData.YOBIN9X146)
    public Double getYobin9x146() {
        return yobin9x146;
    }

    public void setYobin9x146(Double pYobin9x146) {
        yobin9x146 = pYobin9x146;
    }

    private Double yobin9x147;

    @Column(name=GenBT_KawaseRateData.YOBIN9X147)
    public Double getYobin9x147() {
        return yobin9x147;
    }

    public void setYobin9x147(Double pYobin9x147) {
        yobin9x147 = pYobin9x147;
    }

    private Double yobin9x148;

    @Column(name=GenBT_KawaseRateData.YOBIN9X148)
    public Double getYobin9x148() {
        return yobin9x148;
    }

    public void setYobin9x148(Double pYobin9x148) {
        yobin9x148 = pYobin9x148;
    }

    private Double yobin9x149;

    @Column(name=GenBT_KawaseRateData.YOBIN9X149)
    public Double getYobin9x149() {
        return yobin9x149;
    }

    public void setYobin9x149(Double pYobin9x149) {
        yobin9x149 = pYobin9x149;
    }

    private Double yobin9x151;

    @Column(name=GenBT_KawaseRateData.YOBIN9X151)
    public Double getYobin9x151() {
        return yobin9x151;
    }

    public void setYobin9x151(Double pYobin9x151) {
        yobin9x151 = pYobin9x151;
    }

    private Double yobin9x152;

    @Column(name=GenBT_KawaseRateData.YOBIN9X152)
    public Double getYobin9x152() {
        return yobin9x152;
    }

    public void setYobin9x152(Double pYobin9x152) {
        yobin9x152 = pYobin9x152;
    }

    private Double yobin9x153;

    @Column(name=GenBT_KawaseRateData.YOBIN9X153)
    public Double getYobin9x153() {
        return yobin9x153;
    }

    public void setYobin9x153(Double pYobin9x153) {
        yobin9x153 = pYobin9x153;
    }

    private Double yobin9x154;

    @Column(name=GenBT_KawaseRateData.YOBIN9X154)
    public Double getYobin9x154() {
        return yobin9x154;
    }

    public void setYobin9x154(Double pYobin9x154) {
        yobin9x154 = pYobin9x154;
    }

    private Double yobin9x155;

    @Column(name=GenBT_KawaseRateData.YOBIN9X155)
    public Double getYobin9x155() {
        return yobin9x155;
    }

    public void setYobin9x155(Double pYobin9x155) {
        yobin9x155 = pYobin9x155;
    }

    private Double yobin9x156;

    @Column(name=GenBT_KawaseRateData.YOBIN9X156)
    public Double getYobin9x156() {
        return yobin9x156;
    }

    public void setYobin9x156(Double pYobin9x156) {
        yobin9x156 = pYobin9x156;
    }

    private Double yobin9x157;

    @Column(name=GenBT_KawaseRateData.YOBIN9X157)
    public Double getYobin9x157() {
        return yobin9x157;
    }

    public void setYobin9x157(Double pYobin9x157) {
        yobin9x157 = pYobin9x157;
    }

    private Double yobin9x158;

    @Column(name=GenBT_KawaseRateData.YOBIN9X158)
    public Double getYobin9x158() {
        return yobin9x158;
    }

    public void setYobin9x158(Double pYobin9x158) {
        yobin9x158 = pYobin9x158;
    }

    private Double yobin9x159;

    @Column(name=GenBT_KawaseRateData.YOBIN9X159)
    public Double getYobin9x159() {
        return yobin9x159;
    }

    public void setYobin9x159(Double pYobin9x159) {
        yobin9x159 = pYobin9x159;
    }

    private Double yobin9x161;

    @Column(name=GenBT_KawaseRateData.YOBIN9X161)
    public Double getYobin9x161() {
        return yobin9x161;
    }

    public void setYobin9x161(Double pYobin9x161) {
        yobin9x161 = pYobin9x161;
    }

    private Double yobin9x162;

    @Column(name=GenBT_KawaseRateData.YOBIN9X162)
    public Double getYobin9x162() {
        return yobin9x162;
    }

    public void setYobin9x162(Double pYobin9x162) {
        yobin9x162 = pYobin9x162;
    }

    private Double yobin9x163;

    @Column(name=GenBT_KawaseRateData.YOBIN9X163)
    public Double getYobin9x163() {
        return yobin9x163;
    }

    public void setYobin9x163(Double pYobin9x163) {
        yobin9x163 = pYobin9x163;
    }

    private Double yobin9x164;

    @Column(name=GenBT_KawaseRateData.YOBIN9X164)
    public Double getYobin9x164() {
        return yobin9x164;
    }

    public void setYobin9x164(Double pYobin9x164) {
        yobin9x164 = pYobin9x164;
    }

    private Double yobin9x165;

    @Column(name=GenBT_KawaseRateData.YOBIN9X165)
    public Double getYobin9x165() {
        return yobin9x165;
    }

    public void setYobin9x165(Double pYobin9x165) {
        yobin9x165 = pYobin9x165;
    }

    private Double yobin9x166;

    @Column(name=GenBT_KawaseRateData.YOBIN9X166)
    public Double getYobin9x166() {
        return yobin9x166;
    }

    public void setYobin9x166(Double pYobin9x166) {
        yobin9x166 = pYobin9x166;
    }

    private Double yobin9x167;

    @Column(name=GenBT_KawaseRateData.YOBIN9X167)
    public Double getYobin9x167() {
        return yobin9x167;
    }

    public void setYobin9x167(Double pYobin9x167) {
        yobin9x167 = pYobin9x167;
    }

    private Double yobin9x168;

    @Column(name=GenBT_KawaseRateData.YOBIN9X168)
    public Double getYobin9x168() {
        return yobin9x168;
    }

    public void setYobin9x168(Double pYobin9x168) {
        yobin9x168 = pYobin9x168;
    }

    private Double yobin9x169;

    @Column(name=GenBT_KawaseRateData.YOBIN9X169)
    public Double getYobin9x169() {
        return yobin9x169;
    }

    public void setYobin9x169(Double pYobin9x169) {
        yobin9x169 = pYobin9x169;
    }

    private Double yobin9x171;

    @Column(name=GenBT_KawaseRateData.YOBIN9X171)
    public Double getYobin9x171() {
        return yobin9x171;
    }

    public void setYobin9x171(Double pYobin9x171) {
        yobin9x171 = pYobin9x171;
    }

    private Double yobin9x172;

    @Column(name=GenBT_KawaseRateData.YOBIN9X172)
    public Double getYobin9x172() {
        return yobin9x172;
    }

    public void setYobin9x172(Double pYobin9x172) {
        yobin9x172 = pYobin9x172;
    }

    private Double yobin9x173;

    @Column(name=GenBT_KawaseRateData.YOBIN9X173)
    public Double getYobin9x173() {
        return yobin9x173;
    }

    public void setYobin9x173(Double pYobin9x173) {
        yobin9x173 = pYobin9x173;
    }

    private Double yobin9x174;

    @Column(name=GenBT_KawaseRateData.YOBIN9X174)
    public Double getYobin9x174() {
        return yobin9x174;
    }

    public void setYobin9x174(Double pYobin9x174) {
        yobin9x174 = pYobin9x174;
    }

    private Double yobin9x175;

    @Column(name=GenBT_KawaseRateData.YOBIN9X175)
    public Double getYobin9x175() {
        return yobin9x175;
    }

    public void setYobin9x175(Double pYobin9x175) {
        yobin9x175 = pYobin9x175;
    }

    private Double yobin9x176;

    @Column(name=GenBT_KawaseRateData.YOBIN9X176)
    public Double getYobin9x176() {
        return yobin9x176;
    }

    public void setYobin9x176(Double pYobin9x176) {
        yobin9x176 = pYobin9x176;
    }

    private Double yobin9x177;

    @Column(name=GenBT_KawaseRateData.YOBIN9X177)
    public Double getYobin9x177() {
        return yobin9x177;
    }

    public void setYobin9x177(Double pYobin9x177) {
        yobin9x177 = pYobin9x177;
    }

    private Double yobin9x178;

    @Column(name=GenBT_KawaseRateData.YOBIN9X178)
    public Double getYobin9x178() {
        return yobin9x178;
    }

    public void setYobin9x178(Double pYobin9x178) {
        yobin9x178 = pYobin9x178;
    }

    private Double yobin9x179;

    @Column(name=GenBT_KawaseRateData.YOBIN9X179)
    public Double getYobin9x179() {
        return yobin9x179;
    }

    public void setYobin9x179(Double pYobin9x179) {
        yobin9x179 = pYobin9x179;
    }

    private Double yobin9x181;

    @Column(name=GenBT_KawaseRateData.YOBIN9X181)
    public Double getYobin9x181() {
        return yobin9x181;
    }

    public void setYobin9x181(Double pYobin9x181) {
        yobin9x181 = pYobin9x181;
    }

    private Double yobin9x182;

    @Column(name=GenBT_KawaseRateData.YOBIN9X182)
    public Double getYobin9x182() {
        return yobin9x182;
    }

    public void setYobin9x182(Double pYobin9x182) {
        yobin9x182 = pYobin9x182;
    }

    private Double yobin9x183;

    @Column(name=GenBT_KawaseRateData.YOBIN9X183)
    public Double getYobin9x183() {
        return yobin9x183;
    }

    public void setYobin9x183(Double pYobin9x183) {
        yobin9x183 = pYobin9x183;
    }

    private Double yobin9x184;

    @Column(name=GenBT_KawaseRateData.YOBIN9X184)
    public Double getYobin9x184() {
        return yobin9x184;
    }

    public void setYobin9x184(Double pYobin9x184) {
        yobin9x184 = pYobin9x184;
    }

    private Double yobin9x185;

    @Column(name=GenBT_KawaseRateData.YOBIN9X185)
    public Double getYobin9x185() {
        return yobin9x185;
    }

    public void setYobin9x185(Double pYobin9x185) {
        yobin9x185 = pYobin9x185;
    }

    private Double yobin9x186;

    @Column(name=GenBT_KawaseRateData.YOBIN9X186)
    public Double getYobin9x186() {
        return yobin9x186;
    }

    public void setYobin9x186(Double pYobin9x186) {
        yobin9x186 = pYobin9x186;
    }

    private Double yobin9x187;

    @Column(name=GenBT_KawaseRateData.YOBIN9X187)
    public Double getYobin9x187() {
        return yobin9x187;
    }

    public void setYobin9x187(Double pYobin9x187) {
        yobin9x187 = pYobin9x187;
    }

    private Double yobin9x188;

    @Column(name=GenBT_KawaseRateData.YOBIN9X188)
    public Double getYobin9x188() {
        return yobin9x188;
    }

    public void setYobin9x188(Double pYobin9x188) {
        yobin9x188 = pYobin9x188;
    }

    private Double yobin9x189;

    @Column(name=GenBT_KawaseRateData.YOBIN9X189)
    public Double getYobin9x189() {
        return yobin9x189;
    }

    public void setYobin9x189(Double pYobin9x189) {
        yobin9x189 = pYobin9x189;
    }

    private Double yobin9x191;

    @Column(name=GenBT_KawaseRateData.YOBIN9X191)
    public Double getYobin9x191() {
        return yobin9x191;
    }

    public void setYobin9x191(Double pYobin9x191) {
        yobin9x191 = pYobin9x191;
    }

    private Double yobin9x192;

    @Column(name=GenBT_KawaseRateData.YOBIN9X192)
    public Double getYobin9x192() {
        return yobin9x192;
    }

    public void setYobin9x192(Double pYobin9x192) {
        yobin9x192 = pYobin9x192;
    }

    private Double yobin9x193;

    @Column(name=GenBT_KawaseRateData.YOBIN9X193)
    public Double getYobin9x193() {
        return yobin9x193;
    }

    public void setYobin9x193(Double pYobin9x193) {
        yobin9x193 = pYobin9x193;
    }

    private Double yobin9x194;

    @Column(name=GenBT_KawaseRateData.YOBIN9X194)
    public Double getYobin9x194() {
        return yobin9x194;
    }

    public void setYobin9x194(Double pYobin9x194) {
        yobin9x194 = pYobin9x194;
    }

    private Double yobin9x195;

    @Column(name=GenBT_KawaseRateData.YOBIN9X195)
    public Double getYobin9x195() {
        return yobin9x195;
    }

    public void setYobin9x195(Double pYobin9x195) {
        yobin9x195 = pYobin9x195;
    }

    private Double yobin9x196;

    @Column(name=GenBT_KawaseRateData.YOBIN9X196)
    public Double getYobin9x196() {
        return yobin9x196;
    }

    public void setYobin9x196(Double pYobin9x196) {
        yobin9x196 = pYobin9x196;
    }

    private Double yobin9x197;

    @Column(name=GenBT_KawaseRateData.YOBIN9X197)
    public Double getYobin9x197() {
        return yobin9x197;
    }

    public void setYobin9x197(Double pYobin9x197) {
        yobin9x197 = pYobin9x197;
    }

    private Double yobin9x198;

    @Column(name=GenBT_KawaseRateData.YOBIN9X198)
    public Double getYobin9x198() {
        return yobin9x198;
    }

    public void setYobin9x198(Double pYobin9x198) {
        yobin9x198 = pYobin9x198;
    }

    private Double yobin9x199;

    @Column(name=GenBT_KawaseRateData.YOBIN9X199)
    public Double getYobin9x199() {
        return yobin9x199;
    }

    public void setYobin9x199(Double pYobin9x199) {
        yobin9x199 = pYobin9x199;
    }

    private Double yobin9x201;

    @Column(name=GenBT_KawaseRateData.YOBIN9X201)
    public Double getYobin9x201() {
        return yobin9x201;
    }

    public void setYobin9x201(Double pYobin9x201) {
        yobin9x201 = pYobin9x201;
    }

    private Double yobin9x202;

    @Column(name=GenBT_KawaseRateData.YOBIN9X202)
    public Double getYobin9x202() {
        return yobin9x202;
    }

    public void setYobin9x202(Double pYobin9x202) {
        yobin9x202 = pYobin9x202;
    }

    private Double yobin9x203;

    @Column(name=GenBT_KawaseRateData.YOBIN9X203)
    public Double getYobin9x203() {
        return yobin9x203;
    }

    public void setYobin9x203(Double pYobin9x203) {
        yobin9x203 = pYobin9x203;
    }

    private Double yobin9x204;

    @Column(name=GenBT_KawaseRateData.YOBIN9X204)
    public Double getYobin9x204() {
        return yobin9x204;
    }

    public void setYobin9x204(Double pYobin9x204) {
        yobin9x204 = pYobin9x204;
    }

    private Double yobin9x205;

    @Column(name=GenBT_KawaseRateData.YOBIN9X205)
    public Double getYobin9x205() {
        return yobin9x205;
    }

    public void setYobin9x205(Double pYobin9x205) {
        yobin9x205 = pYobin9x205;
    }

    private Double yobin9x206;

    @Column(name=GenBT_KawaseRateData.YOBIN9X206)
    public Double getYobin9x206() {
        return yobin9x206;
    }

    public void setYobin9x206(Double pYobin9x206) {
        yobin9x206 = pYobin9x206;
    }

    private Double yobin9x207;

    @Column(name=GenBT_KawaseRateData.YOBIN9X207)
    public Double getYobin9x207() {
        return yobin9x207;
    }

    public void setYobin9x207(Double pYobin9x207) {
        yobin9x207 = pYobin9x207;
    }

    private Double yobin9x208;

    @Column(name=GenBT_KawaseRateData.YOBIN9X208)
    public Double getYobin9x208() {
        return yobin9x208;
    }

    public void setYobin9x208(Double pYobin9x208) {
        yobin9x208 = pYobin9x208;
    }

    private Double yobin9x209;

    @Column(name=GenBT_KawaseRateData.YOBIN9X209)
    public Double getYobin9x209() {
        return yobin9x209;
    }

    public void setYobin9x209(Double pYobin9x209) {
        yobin9x209 = pYobin9x209;
    }

    private Double usdjpysykn;

    @Column(name=GenBT_KawaseRateData.USDJPYSYKN)
    public Double getUsdjpysykn() {
        return usdjpysykn;
    }

    public void setUsdjpysykn(Double pUsdjpysykn) {
        usdjpysykn = pUsdjpysykn;
    }

    private Double eurjpysykn;

    @Column(name=GenBT_KawaseRateData.EURJPYSYKN)
    public Double getEurjpysykn() {
        return eurjpysykn;
    }

    public void setEurjpysykn(Double pEurjpysykn) {
        eurjpysykn = pEurjpysykn;
    }

    private Double audjpysykn;

    @Column(name=GenBT_KawaseRateData.AUDJPYSYKN)
    public Double getAudjpysykn() {
        return audjpysykn;
    }

    public void setAudjpysykn(Double pAudjpysykn) {
        audjpysykn = pAudjpysykn;
    }

    private Double yobin9x301;

    @Column(name=GenBT_KawaseRateData.YOBIN9X301)
    public Double getYobin9x301() {
        return yobin9x301;
    }

    public void setYobin9x301(Double pYobin9x301) {
        yobin9x301 = pYobin9x301;
    }

    private Double yobin9x302;

    @Column(name=GenBT_KawaseRateData.YOBIN9X302)
    public Double getYobin9x302() {
        return yobin9x302;
    }

    public void setYobin9x302(Double pYobin9x302) {
        yobin9x302 = pYobin9x302;
    }

    private Double yobin9x303;

    @Column(name=GenBT_KawaseRateData.YOBIN9X303)
    public Double getYobin9x303() {
        return yobin9x303;
    }

    public void setYobin9x303(Double pYobin9x303) {
        yobin9x303 = pYobin9x303;
    }

    private Double yobin9x304;

    @Column(name=GenBT_KawaseRateData.YOBIN9X304)
    public Double getYobin9x304() {
        return yobin9x304;
    }

    public void setYobin9x304(Double pYobin9x304) {
        yobin9x304 = pYobin9x304;
    }

    private Double yobin9x305;

    @Column(name=GenBT_KawaseRateData.YOBIN9X305)
    public Double getYobin9x305() {
        return yobin9x305;
    }

    public void setYobin9x305(Double pYobin9x305) {
        yobin9x305 = pYobin9x305;
    }

    private Double yobin9x306;

    @Column(name=GenBT_KawaseRateData.YOBIN9X306)
    public Double getYobin9x306() {
        return yobin9x306;
    }

    public void setYobin9x306(Double pYobin9x306) {
        yobin9x306 = pYobin9x306;
    }

    private Double yobin9x307;

    @Column(name=GenBT_KawaseRateData.YOBIN9X307)
    public Double getYobin9x307() {
        return yobin9x307;
    }

    public void setYobin9x307(Double pYobin9x307) {
        yobin9x307 = pYobin9x307;
    }

    private Double usdjpytts17pm;

    @Column(name=GenBT_KawaseRateData.USDJPYTTS17PM)
    public Double getUsdjpytts17pm() {
        return usdjpytts17pm;
    }

    public void setUsdjpytts17pm(Double pUsdjpytts17pm) {
        usdjpytts17pm = pUsdjpytts17pm;
    }

    private Double usdjpyttb17pm;

    @Column(name=GenBT_KawaseRateData.USDJPYTTB17PM)
    public Double getUsdjpyttb17pm() {
        return usdjpyttb17pm;
    }

    public void setUsdjpyttb17pm(Double pUsdjpyttb17pm) {
        usdjpyttb17pm = pUsdjpyttb17pm;
    }

    private Double usdjpyttm17pm;

    @Column(name=GenBT_KawaseRateData.USDJPYTTM17PM)
    public Double getUsdjpyttm17pm() {
        return usdjpyttm17pm;
    }

    public void setUsdjpyttm17pm(Double pUsdjpyttm17pm) {
        usdjpyttm17pm = pUsdjpyttm17pm;
    }

    private Double eurjpytts17pm;

    @Column(name=GenBT_KawaseRateData.EURJPYTTS17PM)
    public Double getEurjpytts17pm() {
        return eurjpytts17pm;
    }

    public void setEurjpytts17pm(Double pEurjpytts17pm) {
        eurjpytts17pm = pEurjpytts17pm;
    }

    private Double eurjpyttb17pm;

    @Column(name=GenBT_KawaseRateData.EURJPYTTB17PM)
    public Double getEurjpyttb17pm() {
        return eurjpyttb17pm;
    }

    public void setEurjpyttb17pm(Double pEurjpyttb17pm) {
        eurjpyttb17pm = pEurjpyttb17pm;
    }

    private Double eurjpyttm17pm;

    @Column(name=GenBT_KawaseRateData.EURJPYTTM17PM)
    public Double getEurjpyttm17pm() {
        return eurjpyttm17pm;
    }

    public void setEurjpyttm17pm(Double pEurjpyttm17pm) {
        eurjpyttm17pm = pEurjpyttm17pm;
    }

    private Double audjpytts17pm;

    @Column(name=GenBT_KawaseRateData.AUDJPYTTS17PM)
    public Double getAudjpytts17pm() {
        return audjpytts17pm;
    }

    public void setAudjpytts17pm(Double pAudjpytts17pm) {
        audjpytts17pm = pAudjpytts17pm;
    }

    private Double audjpyttb17pm;

    @Column(name=GenBT_KawaseRateData.AUDJPYTTB17PM)
    public Double getAudjpyttb17pm() {
        return audjpyttb17pm;
    }

    public void setAudjpyttb17pm(Double pAudjpyttb17pm) {
        audjpyttb17pm = pAudjpyttb17pm;
    }

    private Double audjpyttm17pm;

    @Column(name=GenBT_KawaseRateData.AUDJPYTTM17PM)
    public Double getAudjpyttm17pm() {
        return audjpyttm17pm;
    }

    public void setAudjpyttm17pm(Double pAudjpyttm17pm) {
        audjpyttm17pm = pAudjpyttm17pm;
    }

    private Double yobin9x501;

    @Column(name=GenBT_KawaseRateData.YOBIN9X501)
    public Double getYobin9x501() {
        return yobin9x501;
    }

    public void setYobin9x501(Double pYobin9x501) {
        yobin9x501 = pYobin9x501;
    }

    private Double yobin9x502;

    @Column(name=GenBT_KawaseRateData.YOBIN9X502)
    public Double getYobin9x502() {
        return yobin9x502;
    }

    public void setYobin9x502(Double pYobin9x502) {
        yobin9x502 = pYobin9x502;
    }

    private Double yobin9x503;

    @Column(name=GenBT_KawaseRateData.YOBIN9X503)
    public Double getYobin9x503() {
        return yobin9x503;
    }

    public void setYobin9x503(Double pYobin9x503) {
        yobin9x503 = pYobin9x503;
    }

    private Double yobin9x504;

    @Column(name=GenBT_KawaseRateData.YOBIN9X504)
    public Double getYobin9x504() {
        return yobin9x504;
    }

    public void setYobin9x504(Double pYobin9x504) {
        yobin9x504 = pYobin9x504;
    }

    private Double yobin9x505;

    @Column(name=GenBT_KawaseRateData.YOBIN9X505)
    public Double getYobin9x505() {
        return yobin9x505;
    }

    public void setYobin9x505(Double pYobin9x505) {
        yobin9x505 = pYobin9x505;
    }

    private Double yobin9x506;

    @Column(name=GenBT_KawaseRateData.YOBIN9X506)
    public Double getYobin9x506() {
        return yobin9x506;
    }

    public void setYobin9x506(Double pYobin9x506) {
        yobin9x506 = pYobin9x506;
    }

    private Double yobin9x507;

    @Column(name=GenBT_KawaseRateData.YOBIN9X507)
    public Double getYobin9x507() {
        return yobin9x507;
    }

    public void setYobin9x507(Double pYobin9x507) {
        yobin9x507 = pYobin9x507;
    }

    private Double yobin9x508;

    @Column(name=GenBT_KawaseRateData.YOBIN9X508)
    public Double getYobin9x508() {
        return yobin9x508;
    }

    public void setYobin9x508(Double pYobin9x508) {
        yobin9x508 = pYobin9x508;
    }

    private Double yobin9x509;

    @Column(name=GenBT_KawaseRateData.YOBIN9X509)
    public Double getYobin9x509() {
        return yobin9x509;
    }

    public void setYobin9x509(Double pYobin9x509) {
        yobin9x509 = pYobin9x509;
    }

    private Double yobin9x510;

    @Column(name=GenBT_KawaseRateData.YOBIN9X510)
    public Double getYobin9x510() {
        return yobin9x510;
    }

    public void setYobin9x510(Double pYobin9x510) {
        yobin9x510 = pYobin9x510;
    }

    private Double yobin9x511;

    @Column(name=GenBT_KawaseRateData.YOBIN9X511)
    public Double getYobin9x511() {
        return yobin9x511;
    }

    public void setYobin9x511(Double pYobin9x511) {
        yobin9x511 = pYobin9x511;
    }

    private Double yobin9x512;

    @Column(name=GenBT_KawaseRateData.YOBIN9X512)
    public Double getYobin9x512() {
        return yobin9x512;
    }

    public void setYobin9x512(Double pYobin9x512) {
        yobin9x512 = pYobin9x512;
    }

    private Double yobin9x513;

    @Column(name=GenBT_KawaseRateData.YOBIN9X513)
    public Double getYobin9x513() {
        return yobin9x513;
    }

    public void setYobin9x513(Double pYobin9x513) {
        yobin9x513 = pYobin9x513;
    }

    private Double yobin9x514;

    @Column(name=GenBT_KawaseRateData.YOBIN9X514)
    public Double getYobin9x514() {
        return yobin9x514;
    }

    public void setYobin9x514(Double pYobin9x514) {
        yobin9x514 = pYobin9x514;
    }

    private Double yobin9x515;

    @Column(name=GenBT_KawaseRateData.YOBIN9X515)
    public Double getYobin9x515() {
        return yobin9x515;
    }

    public void setYobin9x515(Double pYobin9x515) {
        yobin9x515 = pYobin9x515;
    }

    private Double yobin9x516;

    @Column(name=GenBT_KawaseRateData.YOBIN9X516)
    public Double getYobin9x516() {
        return yobin9x516;
    }

    public void setYobin9x516(Double pYobin9x516) {
        yobin9x516 = pYobin9x516;
    }

    private Double yobin9x517;

    @Column(name=GenBT_KawaseRateData.YOBIN9X517)
    public Double getYobin9x517() {
        return yobin9x517;
    }

    public void setYobin9x517(Double pYobin9x517) {
        yobin9x517 = pYobin9x517;
    }

    private Double yobin9x518;

    @Column(name=GenBT_KawaseRateData.YOBIN9X518)
    public Double getYobin9x518() {
        return yobin9x518;
    }

    public void setYobin9x518(Double pYobin9x518) {
        yobin9x518 = pYobin9x518;
    }

    private Double yobin9x519;

    @Column(name=GenBT_KawaseRateData.YOBIN9X519)
    public Double getYobin9x519() {
        return yobin9x519;
    }

    public void setYobin9x519(Double pYobin9x519) {
        yobin9x519 = pYobin9x519;
    }

    private Double yobin9x520;

    @Column(name=GenBT_KawaseRateData.YOBIN9X520)
    public Double getYobin9x520() {
        return yobin9x520;
    }

    public void setYobin9x520(Double pYobin9x520) {
        yobin9x520 = pYobin9x520;
    }

    private Double yobin9x521;

    @Column(name=GenBT_KawaseRateData.YOBIN9X521)
    public Double getYobin9x521() {
        return yobin9x521;
    }

    public void setYobin9x521(Double pYobin9x521) {
        yobin9x521 = pYobin9x521;
    }
}
