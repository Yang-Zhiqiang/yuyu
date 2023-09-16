package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_KawaserateTr;
import yuyu.def.db.id.PKZT_KawaserateTr;
import yuyu.def.db.meta.GenQZT_KawaserateTr;
import yuyu.def.db.meta.QZT_KawaserateTr;

/**
 * 為替レートテーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_KawaserateTr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KawaserateTr}</td><td colspan="3">為替レートテーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrkwsratekjymd ztrkwsratekjymd}</td><td>（取込用）為替レート基準日</td><td align="center">{@link PKZT_KawaserateTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkawaserendoukbn ztrkawaserendoukbn}</td><td>（取込用）為替レート連動区分</td><td align="center">{@link PKZT_KawaserateTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv91 ztryobiv91}</td><td>（取込用）予備項目Ｖ９１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrusdjpytts ztrusdjpytts}</td><td>（取込用）米ドル－円（ＴＴＳ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtrusdjpyttb ztrusdjpyttb}</td><td>（取込用）米ドル－円（ＴＴＢ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtrusdjpyttm ztrusdjpyttm}</td><td>（取込用）米ドル－円（ＴＴＭ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtreurjpytts ztreurjpytts}</td><td>（取込用）ユーロ－円（ＴＴＳ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtreurjpyttb ztreurjpyttb}</td><td>（取込用）ユーロ－円（ＴＴＢ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtreurjpyttm ztreurjpyttm}</td><td>（取込用）ユーロ－円（ＴＴＭ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtraudjpytts ztraudjpytts}</td><td>（取込用）豪ドル－円（ＴＴＳ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtraudjpyttb ztraudjpyttb}</td><td>（取込用）豪ドル－円（ＴＴＢ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtraudjpyttm ztraudjpyttm}</td><td>（取込用）豪ドル－円（ＴＴＭ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9 ztryobin9}</td><td>（取込用）予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x2 ztryobin9x2}</td><td>（取込用）予備項目Ｎ９＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x3 ztryobin9x3}</td><td>（取込用）予備項目Ｎ９＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x4 ztryobin9x4}</td><td>（取込用）予備項目Ｎ９＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x5 ztryobin9x5}</td><td>（取込用）予備項目Ｎ９＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x6 ztryobin9x6}</td><td>（取込用）予備項目Ｎ９＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x7 ztryobin9x7}</td><td>（取込用）予備項目Ｎ９＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x8 ztryobin9x8}</td><td>（取込用）予備項目Ｎ９＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x9 ztryobin9x9}</td><td>（取込用）予備項目Ｎ９＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x10 ztryobin9x10}</td><td>（取込用）予備項目Ｎ９＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x11 ztryobin9x11}</td><td>（取込用）予備項目Ｎ９＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x12 ztryobin9x12}</td><td>（取込用）予備項目Ｎ９＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x13 ztryobin9x13}</td><td>（取込用）予備項目Ｎ９＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x14 ztryobin9x14}</td><td>（取込用）予備項目Ｎ９＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x15 ztryobin9x15}</td><td>（取込用）予備項目Ｎ９＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x16 ztryobin9x16}</td><td>（取込用）予備項目Ｎ９＿１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x17 ztryobin9x17}</td><td>（取込用）予備項目Ｎ９＿１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x18 ztryobin9x18}</td><td>（取込用）予備項目Ｎ９＿１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x19 ztryobin9x19}</td><td>（取込用）予備項目Ｎ９＿１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x20 ztryobin9x20}</td><td>（取込用）予備項目Ｎ９＿２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x21 ztryobin9x21}</td><td>（取込用）予備項目Ｎ９＿２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtrusdjpynykn ztrusdjpynykn}</td><td>（取込用）米ドル－円（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtreurjpynykn ztreurjpynykn}</td><td>（取込用）ユーロ－円（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtraudjpynykn ztraudjpynykn}</td><td>（取込用）豪ドル－円（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x101 ztryobin9x101}</td><td>（取込用）予備項目Ｎ９＿１０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x102 ztryobin9x102}</td><td>（取込用）予備項目Ｎ９＿１０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x103 ztryobin9x103}</td><td>（取込用）予備項目Ｎ９＿１０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x104 ztryobin9x104}</td><td>（取込用）予備項目Ｎ９＿１０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x105 ztryobin9x105}</td><td>（取込用）予備項目Ｎ９＿１０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x106 ztryobin9x106}</td><td>（取込用）予備項目Ｎ９＿１０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x107 ztryobin9x107}</td><td>（取込用）予備項目Ｎ９＿１０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtrusdeurnykn ztrusdeurnykn}</td><td>（取込用）米ドル－ユーロ（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtrusdaudnykn ztrusdaudnykn}</td><td>（取込用）米ドル－豪ドル（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x111 ztryobin9x111}</td><td>（取込用）予備項目Ｎ９＿１１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x112 ztryobin9x112}</td><td>（取込用）予備項目Ｎ９＿１１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x113 ztryobin9x113}</td><td>（取込用）予備項目Ｎ９＿１１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x114 ztryobin9x114}</td><td>（取込用）予備項目Ｎ９＿１１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x115 ztryobin9x115}</td><td>（取込用）予備項目Ｎ９＿１１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x116 ztryobin9x116}</td><td>（取込用）予備項目Ｎ９＿１１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x117 ztryobin9x117}</td><td>（取込用）予備項目Ｎ９＿１１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtreurusdnykn ztreurusdnykn}</td><td>（取込用）ユーロ－米ドル（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtreuraudnykn ztreuraudnykn}</td><td>（取込用）ユーロ－豪ドル（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x121 ztryobin9x121}</td><td>（取込用）予備項目Ｎ９＿１２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x122 ztryobin9x122}</td><td>（取込用）予備項目Ｎ９＿１２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x123 ztryobin9x123}</td><td>（取込用）予備項目Ｎ９＿１２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x124 ztryobin9x124}</td><td>（取込用）予備項目Ｎ９＿１２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x125 ztryobin9x125}</td><td>（取込用）予備項目Ｎ９＿１２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x126 ztryobin9x126}</td><td>（取込用）予備項目Ｎ９＿１２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x127 ztryobin9x127}</td><td>（取込用）予備項目Ｎ９＿１２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtraudusenykn ztraudusenykn}</td><td>（取込用）豪ドル－米ドル（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtraudeurnykn ztraudeurnykn}</td><td>（取込用）豪ドル－ユーロ（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x131 ztryobin9x131}</td><td>（取込用）予備項目Ｎ９＿１３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x132 ztryobin9x132}</td><td>（取込用）予備項目Ｎ９＿１３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x133 ztryobin9x133}</td><td>（取込用）予備項目Ｎ９＿１３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x134 ztryobin9x134}</td><td>（取込用）予備項目Ｎ９＿１３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x135 ztryobin9x135}</td><td>（取込用）予備項目Ｎ９＿１３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x136 ztryobin9x136}</td><td>（取込用）予備項目Ｎ９＿１３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x137 ztryobin9x137}</td><td>（取込用）予備項目Ｎ９＿１３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x141 ztryobin9x141}</td><td>（取込用）予備項目Ｎ９＿１４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x142 ztryobin9x142}</td><td>（取込用）予備項目Ｎ９＿１４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x143 ztryobin9x143}</td><td>（取込用）予備項目Ｎ９＿１４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x144 ztryobin9x144}</td><td>（取込用）予備項目Ｎ９＿１４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x145 ztryobin9x145}</td><td>（取込用）予備項目Ｎ９＿１４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x146 ztryobin9x146}</td><td>（取込用）予備項目Ｎ９＿１４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x147 ztryobin9x147}</td><td>（取込用）予備項目Ｎ９＿１４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x148 ztryobin9x148}</td><td>（取込用）予備項目Ｎ９＿１４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x149 ztryobin9x149}</td><td>（取込用）予備項目Ｎ９＿１４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x151 ztryobin9x151}</td><td>（取込用）予備項目Ｎ９＿１５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x152 ztryobin9x152}</td><td>（取込用）予備項目Ｎ９＿１５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x153 ztryobin9x153}</td><td>（取込用）予備項目Ｎ９＿１５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x154 ztryobin9x154}</td><td>（取込用）予備項目Ｎ９＿１５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x155 ztryobin9x155}</td><td>（取込用）予備項目Ｎ９＿１５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x156 ztryobin9x156}</td><td>（取込用）予備項目Ｎ９＿１５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x157 ztryobin9x157}</td><td>（取込用）予備項目Ｎ９＿１５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x158 ztryobin9x158}</td><td>（取込用）予備項目Ｎ９＿１５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x159 ztryobin9x159}</td><td>（取込用）予備項目Ｎ９＿１５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x161 ztryobin9x161}</td><td>（取込用）予備項目Ｎ９＿１６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x162 ztryobin9x162}</td><td>（取込用）予備項目Ｎ９＿１６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x163 ztryobin9x163}</td><td>（取込用）予備項目Ｎ９＿１６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x164 ztryobin9x164}</td><td>（取込用）予備項目Ｎ９＿１６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x165 ztryobin9x165}</td><td>（取込用）予備項目Ｎ９＿１６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x166 ztryobin9x166}</td><td>（取込用）予備項目Ｎ９＿１６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x167 ztryobin9x167}</td><td>（取込用）予備項目Ｎ９＿１６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x168 ztryobin9x168}</td><td>（取込用）予備項目Ｎ９＿１６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x169 ztryobin9x169}</td><td>（取込用）予備項目Ｎ９＿１６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x171 ztryobin9x171}</td><td>（取込用）予備項目Ｎ９＿１７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x172 ztryobin9x172}</td><td>（取込用）予備項目Ｎ９＿１７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x173 ztryobin9x173}</td><td>（取込用）予備項目Ｎ９＿１７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x174 ztryobin9x174}</td><td>（取込用）予備項目Ｎ９＿１７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x175 ztryobin9x175}</td><td>（取込用）予備項目Ｎ９＿１７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x176 ztryobin9x176}</td><td>（取込用）予備項目Ｎ９＿１７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x177 ztryobin9x177}</td><td>（取込用）予備項目Ｎ９＿１７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x178 ztryobin9x178}</td><td>（取込用）予備項目Ｎ９＿１７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x179 ztryobin9x179}</td><td>（取込用）予備項目Ｎ９＿１７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x181 ztryobin9x181}</td><td>（取込用）予備項目Ｎ９＿１８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x182 ztryobin9x182}</td><td>（取込用）予備項目Ｎ９＿１８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x183 ztryobin9x183}</td><td>（取込用）予備項目Ｎ９＿１８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x184 ztryobin9x184}</td><td>（取込用）予備項目Ｎ９＿１８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x185 ztryobin9x185}</td><td>（取込用）予備項目Ｎ９＿１８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x186 ztryobin9x186}</td><td>（取込用）予備項目Ｎ９＿１８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x187 ztryobin9x187}</td><td>（取込用）予備項目Ｎ９＿１８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x188 ztryobin9x188}</td><td>（取込用）予備項目Ｎ９＿１８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x189 ztryobin9x189}</td><td>（取込用）予備項目Ｎ９＿１８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x191 ztryobin9x191}</td><td>（取込用）予備項目Ｎ９＿１９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x192 ztryobin9x192}</td><td>（取込用）予備項目Ｎ９＿１９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x193 ztryobin9x193}</td><td>（取込用）予備項目Ｎ９＿１９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x194 ztryobin9x194}</td><td>（取込用）予備項目Ｎ９＿１９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x195 ztryobin9x195}</td><td>（取込用）予備項目Ｎ９＿１９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x196 ztryobin9x196}</td><td>（取込用）予備項目Ｎ９＿１９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x197 ztryobin9x197}</td><td>（取込用）予備項目Ｎ９＿１９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x198 ztryobin9x198}</td><td>（取込用）予備項目Ｎ９＿１９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x199 ztryobin9x199}</td><td>（取込用）予備項目Ｎ９＿１９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x201 ztryobin9x201}</td><td>（取込用）予備項目Ｎ９＿２０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x202 ztryobin9x202}</td><td>（取込用）予備項目Ｎ９＿２０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x203 ztryobin9x203}</td><td>（取込用）予備項目Ｎ９＿２０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x204 ztryobin9x204}</td><td>（取込用）予備項目Ｎ９＿２０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x205 ztryobin9x205}</td><td>（取込用）予備項目Ｎ９＿２０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x206 ztryobin9x206}</td><td>（取込用）予備項目Ｎ９＿２０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x207 ztryobin9x207}</td><td>（取込用）予備項目Ｎ９＿２０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x208 ztryobin9x208}</td><td>（取込用）予備項目Ｎ９＿２０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x209 ztryobin9x209}</td><td>（取込用）予備項目Ｎ９＿２０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtrusdjpysykn ztrusdjpysykn}</td><td>（取込用）米ドル－円（出金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtreurjpysykn ztreurjpysykn}</td><td>（取込用）ユーロ－円（出金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtraudjpysykn ztraudjpysykn}</td><td>（取込用）豪ドル－円（出金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x301 ztryobin9x301}</td><td>（取込用）予備項目Ｎ９＿３０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x302 ztryobin9x302}</td><td>（取込用）予備項目Ｎ９＿３０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x303 ztryobin9x303}</td><td>（取込用）予備項目Ｎ９＿３０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x304 ztryobin9x304}</td><td>（取込用）予備項目Ｎ９＿３０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x305 ztryobin9x305}</td><td>（取込用）予備項目Ｎ９＿３０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x306 ztryobin9x306}</td><td>（取込用）予備項目Ｎ９＿３０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x307 ztryobin9x307}</td><td>（取込用）予備項目Ｎ９＿３０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtrusdjpytts17pm ztrusdjpytts17pm}</td><td>（取込用）米ドル－円（ＴＴＳ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtrusdjpyttb17pm ztrusdjpyttb17pm}</td><td>（取込用）米ドル－円（ＴＴＢ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtrusdjpyttm17pm ztrusdjpyttm17pm}</td><td>（取込用）米ドル－円（ＴＴＭ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtreurjpytts17pm ztreurjpytts17pm}</td><td>（取込用）ユーロ－円（ＴＴＳ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtreurjpyttb17pm ztreurjpyttb17pm}</td><td>（取込用）ユーロ－円（ＴＴＢ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtreurjpyttm17pm ztreurjpyttm17pm}</td><td>（取込用）ユーロ－円（ＴＴＭ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtraudjpytts17pm ztraudjpytts17pm}</td><td>（取込用）豪ドル－円（ＴＴＳ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtraudjpyttb17pm ztraudjpyttb17pm}</td><td>（取込用）豪ドル－円（ＴＴＢ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtraudjpyttm17pm ztraudjpyttm17pm}</td><td>（取込用）豪ドル－円（ＴＴＭ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x501 ztryobin9x501}</td><td>（取込用）予備項目Ｎ９＿５０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x502 ztryobin9x502}</td><td>（取込用）予備項目Ｎ９＿５０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x503 ztryobin9x503}</td><td>（取込用）予備項目Ｎ９＿５０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x504 ztryobin9x504}</td><td>（取込用）予備項目Ｎ９＿５０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x505 ztryobin9x505}</td><td>（取込用）予備項目Ｎ９＿５０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x506 ztryobin9x506}</td><td>（取込用）予備項目Ｎ９＿５０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x507 ztryobin9x507}</td><td>（取込用）予備項目Ｎ９＿５０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x508 ztryobin9x508}</td><td>（取込用）予備項目Ｎ９＿５０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x509 ztryobin9x509}</td><td>（取込用）予備項目Ｎ９＿５０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x510 ztryobin9x510}</td><td>（取込用）予備項目Ｎ９＿５１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x511 ztryobin9x511}</td><td>（取込用）予備項目Ｎ９＿５１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x512 ztryobin9x512}</td><td>（取込用）予備項目Ｎ９＿５１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x513 ztryobin9x513}</td><td>（取込用）予備項目Ｎ９＿５１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x514 ztryobin9x514}</td><td>（取込用）予備項目Ｎ９＿５１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x515 ztryobin9x515}</td><td>（取込用）予備項目Ｎ９＿５１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x516 ztryobin9x516}</td><td>（取込用）予備項目Ｎ９＿５１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x517 ztryobin9x517}</td><td>（取込用）予備項目Ｎ９＿５１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x518 ztryobin9x518}</td><td>（取込用）予備項目Ｎ９＿５１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x519 ztryobin9x519}</td><td>（取込用）予備項目Ｎ９＿５１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x520 ztryobin9x520}</td><td>（取込用）予備項目Ｎ９＿５２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtryobin9x521 ztryobin9x521}</td><td>（取込用）予備項目Ｎ９＿５２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 * </table>
 * @see     ZT_KawaserateTr
 * @see     PKZT_KawaserateTr
 * @see     QZT_KawaserateTr
 * @see     GenQZT_KawaserateTr
 */
@MappedSuperclass
@Table(name=GenZT_KawaserateTr.TABLE_NAME)
@IdClass(value=PKZT_KawaserateTr.class)
public abstract class GenZT_KawaserateTr extends AbstractExDBEntity<ZT_KawaserateTr, PKZT_KawaserateTr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KawaserateTr";
    public static final String ZTRKWSRATEKJYMD          = "ztrkwsratekjymd";
    public static final String ZTRKAWASERENDOUKBN       = "ztrkawaserendoukbn";
    public static final String ZTRYOBIV91               = "ztryobiv91";
    public static final String ZTRUSDJPYTTS             = "ztrusdjpytts";
    public static final String ZTRUSDJPYTTB             = "ztrusdjpyttb";
    public static final String ZTRUSDJPYTTM             = "ztrusdjpyttm";
    public static final String ZTREURJPYTTS             = "ztreurjpytts";
    public static final String ZTREURJPYTTB             = "ztreurjpyttb";
    public static final String ZTREURJPYTTM             = "ztreurjpyttm";
    public static final String ZTRAUDJPYTTS             = "ztraudjpytts";
    public static final String ZTRAUDJPYTTB             = "ztraudjpyttb";
    public static final String ZTRAUDJPYTTM             = "ztraudjpyttm";
    public static final String ZTRYOBIN9                = "ztryobin9";
    public static final String ZTRYOBIN9X2              = "ztryobin9x2";
    public static final String ZTRYOBIN9X3              = "ztryobin9x3";
    public static final String ZTRYOBIN9X4              = "ztryobin9x4";
    public static final String ZTRYOBIN9X5              = "ztryobin9x5";
    public static final String ZTRYOBIN9X6              = "ztryobin9x6";
    public static final String ZTRYOBIN9X7              = "ztryobin9x7";
    public static final String ZTRYOBIN9X8              = "ztryobin9x8";
    public static final String ZTRYOBIN9X9              = "ztryobin9x9";
    public static final String ZTRYOBIN9X10             = "ztryobin9x10";
    public static final String ZTRYOBIN9X11             = "ztryobin9x11";
    public static final String ZTRYOBIN9X12             = "ztryobin9x12";
    public static final String ZTRYOBIN9X13             = "ztryobin9x13";
    public static final String ZTRYOBIN9X14             = "ztryobin9x14";
    public static final String ZTRYOBIN9X15             = "ztryobin9x15";
    public static final String ZTRYOBIN9X16             = "ztryobin9x16";
    public static final String ZTRYOBIN9X17             = "ztryobin9x17";
    public static final String ZTRYOBIN9X18             = "ztryobin9x18";
    public static final String ZTRYOBIN9X19             = "ztryobin9x19";
    public static final String ZTRYOBIN9X20             = "ztryobin9x20";
    public static final String ZTRYOBIN9X21             = "ztryobin9x21";
    public static final String ZTRUSDJPYNYKN            = "ztrusdjpynykn";
    public static final String ZTREURJPYNYKN            = "ztreurjpynykn";
    public static final String ZTRAUDJPYNYKN            = "ztraudjpynykn";
    public static final String ZTRYOBIN9X101            = "ztryobin9x101";
    public static final String ZTRYOBIN9X102            = "ztryobin9x102";
    public static final String ZTRYOBIN9X103            = "ztryobin9x103";
    public static final String ZTRYOBIN9X104            = "ztryobin9x104";
    public static final String ZTRYOBIN9X105            = "ztryobin9x105";
    public static final String ZTRYOBIN9X106            = "ztryobin9x106";
    public static final String ZTRYOBIN9X107            = "ztryobin9x107";
    public static final String ZTRUSDEURNYKN            = "ztrusdeurnykn";
    public static final String ZTRUSDAUDNYKN            = "ztrusdaudnykn";
    public static final String ZTRYOBIN9X111            = "ztryobin9x111";
    public static final String ZTRYOBIN9X112            = "ztryobin9x112";
    public static final String ZTRYOBIN9X113            = "ztryobin9x113";
    public static final String ZTRYOBIN9X114            = "ztryobin9x114";
    public static final String ZTRYOBIN9X115            = "ztryobin9x115";
    public static final String ZTRYOBIN9X116            = "ztryobin9x116";
    public static final String ZTRYOBIN9X117            = "ztryobin9x117";
    public static final String ZTREURUSDNYKN            = "ztreurusdnykn";
    public static final String ZTREURAUDNYKN            = "ztreuraudnykn";
    public static final String ZTRYOBIN9X121            = "ztryobin9x121";
    public static final String ZTRYOBIN9X122            = "ztryobin9x122";
    public static final String ZTRYOBIN9X123            = "ztryobin9x123";
    public static final String ZTRYOBIN9X124            = "ztryobin9x124";
    public static final String ZTRYOBIN9X125            = "ztryobin9x125";
    public static final String ZTRYOBIN9X126            = "ztryobin9x126";
    public static final String ZTRYOBIN9X127            = "ztryobin9x127";
    public static final String ZTRAUDUSENYKN            = "ztraudusenykn";
    public static final String ZTRAUDEURNYKN            = "ztraudeurnykn";
    public static final String ZTRYOBIN9X131            = "ztryobin9x131";
    public static final String ZTRYOBIN9X132            = "ztryobin9x132";
    public static final String ZTRYOBIN9X133            = "ztryobin9x133";
    public static final String ZTRYOBIN9X134            = "ztryobin9x134";
    public static final String ZTRYOBIN9X135            = "ztryobin9x135";
    public static final String ZTRYOBIN9X136            = "ztryobin9x136";
    public static final String ZTRYOBIN9X137            = "ztryobin9x137";
    public static final String ZTRYOBIN9X141            = "ztryobin9x141";
    public static final String ZTRYOBIN9X142            = "ztryobin9x142";
    public static final String ZTRYOBIN9X143            = "ztryobin9x143";
    public static final String ZTRYOBIN9X144            = "ztryobin9x144";
    public static final String ZTRYOBIN9X145            = "ztryobin9x145";
    public static final String ZTRYOBIN9X146            = "ztryobin9x146";
    public static final String ZTRYOBIN9X147            = "ztryobin9x147";
    public static final String ZTRYOBIN9X148            = "ztryobin9x148";
    public static final String ZTRYOBIN9X149            = "ztryobin9x149";
    public static final String ZTRYOBIN9X151            = "ztryobin9x151";
    public static final String ZTRYOBIN9X152            = "ztryobin9x152";
    public static final String ZTRYOBIN9X153            = "ztryobin9x153";
    public static final String ZTRYOBIN9X154            = "ztryobin9x154";
    public static final String ZTRYOBIN9X155            = "ztryobin9x155";
    public static final String ZTRYOBIN9X156            = "ztryobin9x156";
    public static final String ZTRYOBIN9X157            = "ztryobin9x157";
    public static final String ZTRYOBIN9X158            = "ztryobin9x158";
    public static final String ZTRYOBIN9X159            = "ztryobin9x159";
    public static final String ZTRYOBIN9X161            = "ztryobin9x161";
    public static final String ZTRYOBIN9X162            = "ztryobin9x162";
    public static final String ZTRYOBIN9X163            = "ztryobin9x163";
    public static final String ZTRYOBIN9X164            = "ztryobin9x164";
    public static final String ZTRYOBIN9X165            = "ztryobin9x165";
    public static final String ZTRYOBIN9X166            = "ztryobin9x166";
    public static final String ZTRYOBIN9X167            = "ztryobin9x167";
    public static final String ZTRYOBIN9X168            = "ztryobin9x168";
    public static final String ZTRYOBIN9X169            = "ztryobin9x169";
    public static final String ZTRYOBIN9X171            = "ztryobin9x171";
    public static final String ZTRYOBIN9X172            = "ztryobin9x172";
    public static final String ZTRYOBIN9X173            = "ztryobin9x173";
    public static final String ZTRYOBIN9X174            = "ztryobin9x174";
    public static final String ZTRYOBIN9X175            = "ztryobin9x175";
    public static final String ZTRYOBIN9X176            = "ztryobin9x176";
    public static final String ZTRYOBIN9X177            = "ztryobin9x177";
    public static final String ZTRYOBIN9X178            = "ztryobin9x178";
    public static final String ZTRYOBIN9X179            = "ztryobin9x179";
    public static final String ZTRYOBIN9X181            = "ztryobin9x181";
    public static final String ZTRYOBIN9X182            = "ztryobin9x182";
    public static final String ZTRYOBIN9X183            = "ztryobin9x183";
    public static final String ZTRYOBIN9X184            = "ztryobin9x184";
    public static final String ZTRYOBIN9X185            = "ztryobin9x185";
    public static final String ZTRYOBIN9X186            = "ztryobin9x186";
    public static final String ZTRYOBIN9X187            = "ztryobin9x187";
    public static final String ZTRYOBIN9X188            = "ztryobin9x188";
    public static final String ZTRYOBIN9X189            = "ztryobin9x189";
    public static final String ZTRYOBIN9X191            = "ztryobin9x191";
    public static final String ZTRYOBIN9X192            = "ztryobin9x192";
    public static final String ZTRYOBIN9X193            = "ztryobin9x193";
    public static final String ZTRYOBIN9X194            = "ztryobin9x194";
    public static final String ZTRYOBIN9X195            = "ztryobin9x195";
    public static final String ZTRYOBIN9X196            = "ztryobin9x196";
    public static final String ZTRYOBIN9X197            = "ztryobin9x197";
    public static final String ZTRYOBIN9X198            = "ztryobin9x198";
    public static final String ZTRYOBIN9X199            = "ztryobin9x199";
    public static final String ZTRYOBIN9X201            = "ztryobin9x201";
    public static final String ZTRYOBIN9X202            = "ztryobin9x202";
    public static final String ZTRYOBIN9X203            = "ztryobin9x203";
    public static final String ZTRYOBIN9X204            = "ztryobin9x204";
    public static final String ZTRYOBIN9X205            = "ztryobin9x205";
    public static final String ZTRYOBIN9X206            = "ztryobin9x206";
    public static final String ZTRYOBIN9X207            = "ztryobin9x207";
    public static final String ZTRYOBIN9X208            = "ztryobin9x208";
    public static final String ZTRYOBIN9X209            = "ztryobin9x209";
    public static final String ZTRUSDJPYSYKN            = "ztrusdjpysykn";
    public static final String ZTREURJPYSYKN            = "ztreurjpysykn";
    public static final String ZTRAUDJPYSYKN            = "ztraudjpysykn";
    public static final String ZTRYOBIN9X301            = "ztryobin9x301";
    public static final String ZTRYOBIN9X302            = "ztryobin9x302";
    public static final String ZTRYOBIN9X303            = "ztryobin9x303";
    public static final String ZTRYOBIN9X304            = "ztryobin9x304";
    public static final String ZTRYOBIN9X305            = "ztryobin9x305";
    public static final String ZTRYOBIN9X306            = "ztryobin9x306";
    public static final String ZTRYOBIN9X307            = "ztryobin9x307";
    public static final String ZTRUSDJPYTTS17PM         = "ztrusdjpytts17pm";
    public static final String ZTRUSDJPYTTB17PM         = "ztrusdjpyttb17pm";
    public static final String ZTRUSDJPYTTM17PM         = "ztrusdjpyttm17pm";
    public static final String ZTREURJPYTTS17PM         = "ztreurjpytts17pm";
    public static final String ZTREURJPYTTB17PM         = "ztreurjpyttb17pm";
    public static final String ZTREURJPYTTM17PM         = "ztreurjpyttm17pm";
    public static final String ZTRAUDJPYTTS17PM         = "ztraudjpytts17pm";
    public static final String ZTRAUDJPYTTB17PM         = "ztraudjpyttb17pm";
    public static final String ZTRAUDJPYTTM17PM         = "ztraudjpyttm17pm";
    public static final String ZTRYOBIN9X501            = "ztryobin9x501";
    public static final String ZTRYOBIN9X502            = "ztryobin9x502";
    public static final String ZTRYOBIN9X503            = "ztryobin9x503";
    public static final String ZTRYOBIN9X504            = "ztryobin9x504";
    public static final String ZTRYOBIN9X505            = "ztryobin9x505";
    public static final String ZTRYOBIN9X506            = "ztryobin9x506";
    public static final String ZTRYOBIN9X507            = "ztryobin9x507";
    public static final String ZTRYOBIN9X508            = "ztryobin9x508";
    public static final String ZTRYOBIN9X509            = "ztryobin9x509";
    public static final String ZTRYOBIN9X510            = "ztryobin9x510";
    public static final String ZTRYOBIN9X511            = "ztryobin9x511";
    public static final String ZTRYOBIN9X512            = "ztryobin9x512";
    public static final String ZTRYOBIN9X513            = "ztryobin9x513";
    public static final String ZTRYOBIN9X514            = "ztryobin9x514";
    public static final String ZTRYOBIN9X515            = "ztryobin9x515";
    public static final String ZTRYOBIN9X516            = "ztryobin9x516";
    public static final String ZTRYOBIN9X517            = "ztryobin9x517";
    public static final String ZTRYOBIN9X518            = "ztryobin9x518";
    public static final String ZTRYOBIN9X519            = "ztryobin9x519";
    public static final String ZTRYOBIN9X520            = "ztryobin9x520";
    public static final String ZTRYOBIN9X521            = "ztryobin9x521";

    private final PKZT_KawaserateTr primaryKey;

    public GenZT_KawaserateTr() {
        primaryKey = new PKZT_KawaserateTr();
    }

    public GenZT_KawaserateTr(String pZtrkwsratekjymd, String pZtrkawaserendoukbn) {
        primaryKey = new PKZT_KawaserateTr(pZtrkwsratekjymd, pZtrkawaserendoukbn);
    }

    @Transient
    @Override
    public PKZT_KawaserateTr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KawaserateTr> getMetaClass() {
        return QZT_KawaserateTr.class;
    }

    @Id
    @Column(name=GenZT_KawaserateTr.ZTRKWSRATEKJYMD)
    public String getZtrkwsratekjymd() {
        return getPrimaryKey().getZtrkwsratekjymd();
    }

    public void setZtrkwsratekjymd(String pZtrkwsratekjymd) {
        getPrimaryKey().setZtrkwsratekjymd(pZtrkwsratekjymd);
    }

    @Id
    @Column(name=GenZT_KawaserateTr.ZTRKAWASERENDOUKBN)
    public String getZtrkawaserendoukbn() {
        return getPrimaryKey().getZtrkawaserendoukbn();
    }

    public void setZtrkawaserendoukbn(String pZtrkawaserendoukbn) {
        getPrimaryKey().setZtrkawaserendoukbn(pZtrkawaserendoukbn);
    }

    private String ztryobiv91;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIV91)
    public String getZtryobiv91() {
        return ztryobiv91;
    }

    public void setZtryobiv91(String pZtryobiv91) {
        ztryobiv91 = pZtryobiv91;
    }

    private Double ztrusdjpytts;

    @Column(name=GenZT_KawaserateTr.ZTRUSDJPYTTS)
    public Double getZtrusdjpytts() {
        return ztrusdjpytts;
    }

    public void setZtrusdjpytts(Double pZtrusdjpytts) {
        ztrusdjpytts = pZtrusdjpytts;
    }

    private Double ztrusdjpyttb;

    @Column(name=GenZT_KawaserateTr.ZTRUSDJPYTTB)
    public Double getZtrusdjpyttb() {
        return ztrusdjpyttb;
    }

    public void setZtrusdjpyttb(Double pZtrusdjpyttb) {
        ztrusdjpyttb = pZtrusdjpyttb;
    }

    private Double ztrusdjpyttm;

    @Column(name=GenZT_KawaserateTr.ZTRUSDJPYTTM)
    public Double getZtrusdjpyttm() {
        return ztrusdjpyttm;
    }

    public void setZtrusdjpyttm(Double pZtrusdjpyttm) {
        ztrusdjpyttm = pZtrusdjpyttm;
    }

    private Double ztreurjpytts;

    @Column(name=GenZT_KawaserateTr.ZTREURJPYTTS)
    public Double getZtreurjpytts() {
        return ztreurjpytts;
    }

    public void setZtreurjpytts(Double pZtreurjpytts) {
        ztreurjpytts = pZtreurjpytts;
    }

    private Double ztreurjpyttb;

    @Column(name=GenZT_KawaserateTr.ZTREURJPYTTB)
    public Double getZtreurjpyttb() {
        return ztreurjpyttb;
    }

    public void setZtreurjpyttb(Double pZtreurjpyttb) {
        ztreurjpyttb = pZtreurjpyttb;
    }

    private Double ztreurjpyttm;

    @Column(name=GenZT_KawaserateTr.ZTREURJPYTTM)
    public Double getZtreurjpyttm() {
        return ztreurjpyttm;
    }

    public void setZtreurjpyttm(Double pZtreurjpyttm) {
        ztreurjpyttm = pZtreurjpyttm;
    }

    private Double ztraudjpytts;

    @Column(name=GenZT_KawaserateTr.ZTRAUDJPYTTS)
    public Double getZtraudjpytts() {
        return ztraudjpytts;
    }

    public void setZtraudjpytts(Double pZtraudjpytts) {
        ztraudjpytts = pZtraudjpytts;
    }

    private Double ztraudjpyttb;

    @Column(name=GenZT_KawaserateTr.ZTRAUDJPYTTB)
    public Double getZtraudjpyttb() {
        return ztraudjpyttb;
    }

    public void setZtraudjpyttb(Double pZtraudjpyttb) {
        ztraudjpyttb = pZtraudjpyttb;
    }

    private Double ztraudjpyttm;

    @Column(name=GenZT_KawaserateTr.ZTRAUDJPYTTM)
    public Double getZtraudjpyttm() {
        return ztraudjpyttm;
    }

    public void setZtraudjpyttm(Double pZtraudjpyttm) {
        ztraudjpyttm = pZtraudjpyttm;
    }

    private Double ztryobin9;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9)
    public Double getZtryobin9() {
        return ztryobin9;
    }

    public void setZtryobin9(Double pZtryobin9) {
        ztryobin9 = pZtryobin9;
    }

    private Double ztryobin9x2;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X2)
    public Double getZtryobin9x2() {
        return ztryobin9x2;
    }

    public void setZtryobin9x2(Double pZtryobin9x2) {
        ztryobin9x2 = pZtryobin9x2;
    }

    private Double ztryobin9x3;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X3)
    public Double getZtryobin9x3() {
        return ztryobin9x3;
    }

    public void setZtryobin9x3(Double pZtryobin9x3) {
        ztryobin9x3 = pZtryobin9x3;
    }

    private Double ztryobin9x4;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X4)
    public Double getZtryobin9x4() {
        return ztryobin9x4;
    }

    public void setZtryobin9x4(Double pZtryobin9x4) {
        ztryobin9x4 = pZtryobin9x4;
    }

    private Double ztryobin9x5;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X5)
    public Double getZtryobin9x5() {
        return ztryobin9x5;
    }

    public void setZtryobin9x5(Double pZtryobin9x5) {
        ztryobin9x5 = pZtryobin9x5;
    }

    private Double ztryobin9x6;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X6)
    public Double getZtryobin9x6() {
        return ztryobin9x6;
    }

    public void setZtryobin9x6(Double pZtryobin9x6) {
        ztryobin9x6 = pZtryobin9x6;
    }

    private Double ztryobin9x7;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X7)
    public Double getZtryobin9x7() {
        return ztryobin9x7;
    }

    public void setZtryobin9x7(Double pZtryobin9x7) {
        ztryobin9x7 = pZtryobin9x7;
    }

    private Double ztryobin9x8;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X8)
    public Double getZtryobin9x8() {
        return ztryobin9x8;
    }

    public void setZtryobin9x8(Double pZtryobin9x8) {
        ztryobin9x8 = pZtryobin9x8;
    }

    private Double ztryobin9x9;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X9)
    public Double getZtryobin9x9() {
        return ztryobin9x9;
    }

    public void setZtryobin9x9(Double pZtryobin9x9) {
        ztryobin9x9 = pZtryobin9x9;
    }

    private Double ztryobin9x10;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X10)
    public Double getZtryobin9x10() {
        return ztryobin9x10;
    }

    public void setZtryobin9x10(Double pZtryobin9x10) {
        ztryobin9x10 = pZtryobin9x10;
    }

    private Double ztryobin9x11;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X11)
    public Double getZtryobin9x11() {
        return ztryobin9x11;
    }

    public void setZtryobin9x11(Double pZtryobin9x11) {
        ztryobin9x11 = pZtryobin9x11;
    }

    private Double ztryobin9x12;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X12)
    public Double getZtryobin9x12() {
        return ztryobin9x12;
    }

    public void setZtryobin9x12(Double pZtryobin9x12) {
        ztryobin9x12 = pZtryobin9x12;
    }

    private Double ztryobin9x13;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X13)
    public Double getZtryobin9x13() {
        return ztryobin9x13;
    }

    public void setZtryobin9x13(Double pZtryobin9x13) {
        ztryobin9x13 = pZtryobin9x13;
    }

    private Double ztryobin9x14;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X14)
    public Double getZtryobin9x14() {
        return ztryobin9x14;
    }

    public void setZtryobin9x14(Double pZtryobin9x14) {
        ztryobin9x14 = pZtryobin9x14;
    }

    private Double ztryobin9x15;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X15)
    public Double getZtryobin9x15() {
        return ztryobin9x15;
    }

    public void setZtryobin9x15(Double pZtryobin9x15) {
        ztryobin9x15 = pZtryobin9x15;
    }

    private Double ztryobin9x16;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X16)
    public Double getZtryobin9x16() {
        return ztryobin9x16;
    }

    public void setZtryobin9x16(Double pZtryobin9x16) {
        ztryobin9x16 = pZtryobin9x16;
    }

    private Double ztryobin9x17;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X17)
    public Double getZtryobin9x17() {
        return ztryobin9x17;
    }

    public void setZtryobin9x17(Double pZtryobin9x17) {
        ztryobin9x17 = pZtryobin9x17;
    }

    private Double ztryobin9x18;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X18)
    public Double getZtryobin9x18() {
        return ztryobin9x18;
    }

    public void setZtryobin9x18(Double pZtryobin9x18) {
        ztryobin9x18 = pZtryobin9x18;
    }

    private Double ztryobin9x19;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X19)
    public Double getZtryobin9x19() {
        return ztryobin9x19;
    }

    public void setZtryobin9x19(Double pZtryobin9x19) {
        ztryobin9x19 = pZtryobin9x19;
    }

    private Double ztryobin9x20;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X20)
    public Double getZtryobin9x20() {
        return ztryobin9x20;
    }

    public void setZtryobin9x20(Double pZtryobin9x20) {
        ztryobin9x20 = pZtryobin9x20;
    }

    private Double ztryobin9x21;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X21)
    public Double getZtryobin9x21() {
        return ztryobin9x21;
    }

    public void setZtryobin9x21(Double pZtryobin9x21) {
        ztryobin9x21 = pZtryobin9x21;
    }

    private Double ztrusdjpynykn;

    @Column(name=GenZT_KawaserateTr.ZTRUSDJPYNYKN)
    public Double getZtrusdjpynykn() {
        return ztrusdjpynykn;
    }

    public void setZtrusdjpynykn(Double pZtrusdjpynykn) {
        ztrusdjpynykn = pZtrusdjpynykn;
    }

    private Double ztreurjpynykn;

    @Column(name=GenZT_KawaserateTr.ZTREURJPYNYKN)
    public Double getZtreurjpynykn() {
        return ztreurjpynykn;
    }

    public void setZtreurjpynykn(Double pZtreurjpynykn) {
        ztreurjpynykn = pZtreurjpynykn;
    }

    private Double ztraudjpynykn;

    @Column(name=GenZT_KawaserateTr.ZTRAUDJPYNYKN)
    public Double getZtraudjpynykn() {
        return ztraudjpynykn;
    }

    public void setZtraudjpynykn(Double pZtraudjpynykn) {
        ztraudjpynykn = pZtraudjpynykn;
    }

    private Double ztryobin9x101;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X101)
    public Double getZtryobin9x101() {
        return ztryobin9x101;
    }

    public void setZtryobin9x101(Double pZtryobin9x101) {
        ztryobin9x101 = pZtryobin9x101;
    }

    private Double ztryobin9x102;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X102)
    public Double getZtryobin9x102() {
        return ztryobin9x102;
    }

    public void setZtryobin9x102(Double pZtryobin9x102) {
        ztryobin9x102 = pZtryobin9x102;
    }

    private Double ztryobin9x103;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X103)
    public Double getZtryobin9x103() {
        return ztryobin9x103;
    }

    public void setZtryobin9x103(Double pZtryobin9x103) {
        ztryobin9x103 = pZtryobin9x103;
    }

    private Double ztryobin9x104;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X104)
    public Double getZtryobin9x104() {
        return ztryobin9x104;
    }

    public void setZtryobin9x104(Double pZtryobin9x104) {
        ztryobin9x104 = pZtryobin9x104;
    }

    private Double ztryobin9x105;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X105)
    public Double getZtryobin9x105() {
        return ztryobin9x105;
    }

    public void setZtryobin9x105(Double pZtryobin9x105) {
        ztryobin9x105 = pZtryobin9x105;
    }

    private Double ztryobin9x106;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X106)
    public Double getZtryobin9x106() {
        return ztryobin9x106;
    }

    public void setZtryobin9x106(Double pZtryobin9x106) {
        ztryobin9x106 = pZtryobin9x106;
    }

    private Double ztryobin9x107;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X107)
    public Double getZtryobin9x107() {
        return ztryobin9x107;
    }

    public void setZtryobin9x107(Double pZtryobin9x107) {
        ztryobin9x107 = pZtryobin9x107;
    }

    private Double ztrusdeurnykn;

    @Column(name=GenZT_KawaserateTr.ZTRUSDEURNYKN)
    public Double getZtrusdeurnykn() {
        return ztrusdeurnykn;
    }

    public void setZtrusdeurnykn(Double pZtrusdeurnykn) {
        ztrusdeurnykn = pZtrusdeurnykn;
    }

    private Double ztrusdaudnykn;

    @Column(name=GenZT_KawaserateTr.ZTRUSDAUDNYKN)
    public Double getZtrusdaudnykn() {
        return ztrusdaudnykn;
    }

    public void setZtrusdaudnykn(Double pZtrusdaudnykn) {
        ztrusdaudnykn = pZtrusdaudnykn;
    }

    private Double ztryobin9x111;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X111)
    public Double getZtryobin9x111() {
        return ztryobin9x111;
    }

    public void setZtryobin9x111(Double pZtryobin9x111) {
        ztryobin9x111 = pZtryobin9x111;
    }

    private Double ztryobin9x112;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X112)
    public Double getZtryobin9x112() {
        return ztryobin9x112;
    }

    public void setZtryobin9x112(Double pZtryobin9x112) {
        ztryobin9x112 = pZtryobin9x112;
    }

    private Double ztryobin9x113;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X113)
    public Double getZtryobin9x113() {
        return ztryobin9x113;
    }

    public void setZtryobin9x113(Double pZtryobin9x113) {
        ztryobin9x113 = pZtryobin9x113;
    }

    private Double ztryobin9x114;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X114)
    public Double getZtryobin9x114() {
        return ztryobin9x114;
    }

    public void setZtryobin9x114(Double pZtryobin9x114) {
        ztryobin9x114 = pZtryobin9x114;
    }

    private Double ztryobin9x115;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X115)
    public Double getZtryobin9x115() {
        return ztryobin9x115;
    }

    public void setZtryobin9x115(Double pZtryobin9x115) {
        ztryobin9x115 = pZtryobin9x115;
    }

    private Double ztryobin9x116;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X116)
    public Double getZtryobin9x116() {
        return ztryobin9x116;
    }

    public void setZtryobin9x116(Double pZtryobin9x116) {
        ztryobin9x116 = pZtryobin9x116;
    }

    private Double ztryobin9x117;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X117)
    public Double getZtryobin9x117() {
        return ztryobin9x117;
    }

    public void setZtryobin9x117(Double pZtryobin9x117) {
        ztryobin9x117 = pZtryobin9x117;
    }

    private Double ztreurusdnykn;

    @Column(name=GenZT_KawaserateTr.ZTREURUSDNYKN)
    public Double getZtreurusdnykn() {
        return ztreurusdnykn;
    }

    public void setZtreurusdnykn(Double pZtreurusdnykn) {
        ztreurusdnykn = pZtreurusdnykn;
    }

    private Double ztreuraudnykn;

    @Column(name=GenZT_KawaserateTr.ZTREURAUDNYKN)
    public Double getZtreuraudnykn() {
        return ztreuraudnykn;
    }

    public void setZtreuraudnykn(Double pZtreuraudnykn) {
        ztreuraudnykn = pZtreuraudnykn;
    }

    private Double ztryobin9x121;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X121)
    public Double getZtryobin9x121() {
        return ztryobin9x121;
    }

    public void setZtryobin9x121(Double pZtryobin9x121) {
        ztryobin9x121 = pZtryobin9x121;
    }

    private Double ztryobin9x122;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X122)
    public Double getZtryobin9x122() {
        return ztryobin9x122;
    }

    public void setZtryobin9x122(Double pZtryobin9x122) {
        ztryobin9x122 = pZtryobin9x122;
    }

    private Double ztryobin9x123;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X123)
    public Double getZtryobin9x123() {
        return ztryobin9x123;
    }

    public void setZtryobin9x123(Double pZtryobin9x123) {
        ztryobin9x123 = pZtryobin9x123;
    }

    private Double ztryobin9x124;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X124)
    public Double getZtryobin9x124() {
        return ztryobin9x124;
    }

    public void setZtryobin9x124(Double pZtryobin9x124) {
        ztryobin9x124 = pZtryobin9x124;
    }

    private Double ztryobin9x125;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X125)
    public Double getZtryobin9x125() {
        return ztryobin9x125;
    }

    public void setZtryobin9x125(Double pZtryobin9x125) {
        ztryobin9x125 = pZtryobin9x125;
    }

    private Double ztryobin9x126;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X126)
    public Double getZtryobin9x126() {
        return ztryobin9x126;
    }

    public void setZtryobin9x126(Double pZtryobin9x126) {
        ztryobin9x126 = pZtryobin9x126;
    }

    private Double ztryobin9x127;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X127)
    public Double getZtryobin9x127() {
        return ztryobin9x127;
    }

    public void setZtryobin9x127(Double pZtryobin9x127) {
        ztryobin9x127 = pZtryobin9x127;
    }

    private Double ztraudusenykn;

    @Column(name=GenZT_KawaserateTr.ZTRAUDUSENYKN)
    public Double getZtraudusenykn() {
        return ztraudusenykn;
    }

    public void setZtraudusenykn(Double pZtraudusenykn) {
        ztraudusenykn = pZtraudusenykn;
    }

    private Double ztraudeurnykn;

    @Column(name=GenZT_KawaserateTr.ZTRAUDEURNYKN)
    public Double getZtraudeurnykn() {
        return ztraudeurnykn;
    }

    public void setZtraudeurnykn(Double pZtraudeurnykn) {
        ztraudeurnykn = pZtraudeurnykn;
    }

    private Double ztryobin9x131;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X131)
    public Double getZtryobin9x131() {
        return ztryobin9x131;
    }

    public void setZtryobin9x131(Double pZtryobin9x131) {
        ztryobin9x131 = pZtryobin9x131;
    }

    private Double ztryobin9x132;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X132)
    public Double getZtryobin9x132() {
        return ztryobin9x132;
    }

    public void setZtryobin9x132(Double pZtryobin9x132) {
        ztryobin9x132 = pZtryobin9x132;
    }

    private Double ztryobin9x133;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X133)
    public Double getZtryobin9x133() {
        return ztryobin9x133;
    }

    public void setZtryobin9x133(Double pZtryobin9x133) {
        ztryobin9x133 = pZtryobin9x133;
    }

    private Double ztryobin9x134;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X134)
    public Double getZtryobin9x134() {
        return ztryobin9x134;
    }

    public void setZtryobin9x134(Double pZtryobin9x134) {
        ztryobin9x134 = pZtryobin9x134;
    }

    private Double ztryobin9x135;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X135)
    public Double getZtryobin9x135() {
        return ztryobin9x135;
    }

    public void setZtryobin9x135(Double pZtryobin9x135) {
        ztryobin9x135 = pZtryobin9x135;
    }

    private Double ztryobin9x136;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X136)
    public Double getZtryobin9x136() {
        return ztryobin9x136;
    }

    public void setZtryobin9x136(Double pZtryobin9x136) {
        ztryobin9x136 = pZtryobin9x136;
    }

    private Double ztryobin9x137;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X137)
    public Double getZtryobin9x137() {
        return ztryobin9x137;
    }

    public void setZtryobin9x137(Double pZtryobin9x137) {
        ztryobin9x137 = pZtryobin9x137;
    }

    private Double ztryobin9x141;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X141)
    public Double getZtryobin9x141() {
        return ztryobin9x141;
    }

    public void setZtryobin9x141(Double pZtryobin9x141) {
        ztryobin9x141 = pZtryobin9x141;
    }

    private Double ztryobin9x142;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X142)
    public Double getZtryobin9x142() {
        return ztryobin9x142;
    }

    public void setZtryobin9x142(Double pZtryobin9x142) {
        ztryobin9x142 = pZtryobin9x142;
    }

    private Double ztryobin9x143;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X143)
    public Double getZtryobin9x143() {
        return ztryobin9x143;
    }

    public void setZtryobin9x143(Double pZtryobin9x143) {
        ztryobin9x143 = pZtryobin9x143;
    }

    private Double ztryobin9x144;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X144)
    public Double getZtryobin9x144() {
        return ztryobin9x144;
    }

    public void setZtryobin9x144(Double pZtryobin9x144) {
        ztryobin9x144 = pZtryobin9x144;
    }

    private Double ztryobin9x145;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X145)
    public Double getZtryobin9x145() {
        return ztryobin9x145;
    }

    public void setZtryobin9x145(Double pZtryobin9x145) {
        ztryobin9x145 = pZtryobin9x145;
    }

    private Double ztryobin9x146;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X146)
    public Double getZtryobin9x146() {
        return ztryobin9x146;
    }

    public void setZtryobin9x146(Double pZtryobin9x146) {
        ztryobin9x146 = pZtryobin9x146;
    }

    private Double ztryobin9x147;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X147)
    public Double getZtryobin9x147() {
        return ztryobin9x147;
    }

    public void setZtryobin9x147(Double pZtryobin9x147) {
        ztryobin9x147 = pZtryobin9x147;
    }

    private Double ztryobin9x148;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X148)
    public Double getZtryobin9x148() {
        return ztryobin9x148;
    }

    public void setZtryobin9x148(Double pZtryobin9x148) {
        ztryobin9x148 = pZtryobin9x148;
    }

    private Double ztryobin9x149;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X149)
    public Double getZtryobin9x149() {
        return ztryobin9x149;
    }

    public void setZtryobin9x149(Double pZtryobin9x149) {
        ztryobin9x149 = pZtryobin9x149;
    }

    private Double ztryobin9x151;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X151)
    public Double getZtryobin9x151() {
        return ztryobin9x151;
    }

    public void setZtryobin9x151(Double pZtryobin9x151) {
        ztryobin9x151 = pZtryobin9x151;
    }

    private Double ztryobin9x152;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X152)
    public Double getZtryobin9x152() {
        return ztryobin9x152;
    }

    public void setZtryobin9x152(Double pZtryobin9x152) {
        ztryobin9x152 = pZtryobin9x152;
    }

    private Double ztryobin9x153;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X153)
    public Double getZtryobin9x153() {
        return ztryobin9x153;
    }

    public void setZtryobin9x153(Double pZtryobin9x153) {
        ztryobin9x153 = pZtryobin9x153;
    }

    private Double ztryobin9x154;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X154)
    public Double getZtryobin9x154() {
        return ztryobin9x154;
    }

    public void setZtryobin9x154(Double pZtryobin9x154) {
        ztryobin9x154 = pZtryobin9x154;
    }

    private Double ztryobin9x155;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X155)
    public Double getZtryobin9x155() {
        return ztryobin9x155;
    }

    public void setZtryobin9x155(Double pZtryobin9x155) {
        ztryobin9x155 = pZtryobin9x155;
    }

    private Double ztryobin9x156;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X156)
    public Double getZtryobin9x156() {
        return ztryobin9x156;
    }

    public void setZtryobin9x156(Double pZtryobin9x156) {
        ztryobin9x156 = pZtryobin9x156;
    }

    private Double ztryobin9x157;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X157)
    public Double getZtryobin9x157() {
        return ztryobin9x157;
    }

    public void setZtryobin9x157(Double pZtryobin9x157) {
        ztryobin9x157 = pZtryobin9x157;
    }

    private Double ztryobin9x158;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X158)
    public Double getZtryobin9x158() {
        return ztryobin9x158;
    }

    public void setZtryobin9x158(Double pZtryobin9x158) {
        ztryobin9x158 = pZtryobin9x158;
    }

    private Double ztryobin9x159;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X159)
    public Double getZtryobin9x159() {
        return ztryobin9x159;
    }

    public void setZtryobin9x159(Double pZtryobin9x159) {
        ztryobin9x159 = pZtryobin9x159;
    }

    private Double ztryobin9x161;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X161)
    public Double getZtryobin9x161() {
        return ztryobin9x161;
    }

    public void setZtryobin9x161(Double pZtryobin9x161) {
        ztryobin9x161 = pZtryobin9x161;
    }

    private Double ztryobin9x162;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X162)
    public Double getZtryobin9x162() {
        return ztryobin9x162;
    }

    public void setZtryobin9x162(Double pZtryobin9x162) {
        ztryobin9x162 = pZtryobin9x162;
    }

    private Double ztryobin9x163;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X163)
    public Double getZtryobin9x163() {
        return ztryobin9x163;
    }

    public void setZtryobin9x163(Double pZtryobin9x163) {
        ztryobin9x163 = pZtryobin9x163;
    }

    private Double ztryobin9x164;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X164)
    public Double getZtryobin9x164() {
        return ztryobin9x164;
    }

    public void setZtryobin9x164(Double pZtryobin9x164) {
        ztryobin9x164 = pZtryobin9x164;
    }

    private Double ztryobin9x165;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X165)
    public Double getZtryobin9x165() {
        return ztryobin9x165;
    }

    public void setZtryobin9x165(Double pZtryobin9x165) {
        ztryobin9x165 = pZtryobin9x165;
    }

    private Double ztryobin9x166;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X166)
    public Double getZtryobin9x166() {
        return ztryobin9x166;
    }

    public void setZtryobin9x166(Double pZtryobin9x166) {
        ztryobin9x166 = pZtryobin9x166;
    }

    private Double ztryobin9x167;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X167)
    public Double getZtryobin9x167() {
        return ztryobin9x167;
    }

    public void setZtryobin9x167(Double pZtryobin9x167) {
        ztryobin9x167 = pZtryobin9x167;
    }

    private Double ztryobin9x168;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X168)
    public Double getZtryobin9x168() {
        return ztryobin9x168;
    }

    public void setZtryobin9x168(Double pZtryobin9x168) {
        ztryobin9x168 = pZtryobin9x168;
    }

    private Double ztryobin9x169;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X169)
    public Double getZtryobin9x169() {
        return ztryobin9x169;
    }

    public void setZtryobin9x169(Double pZtryobin9x169) {
        ztryobin9x169 = pZtryobin9x169;
    }

    private Double ztryobin9x171;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X171)
    public Double getZtryobin9x171() {
        return ztryobin9x171;
    }

    public void setZtryobin9x171(Double pZtryobin9x171) {
        ztryobin9x171 = pZtryobin9x171;
    }

    private Double ztryobin9x172;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X172)
    public Double getZtryobin9x172() {
        return ztryobin9x172;
    }

    public void setZtryobin9x172(Double pZtryobin9x172) {
        ztryobin9x172 = pZtryobin9x172;
    }

    private Double ztryobin9x173;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X173)
    public Double getZtryobin9x173() {
        return ztryobin9x173;
    }

    public void setZtryobin9x173(Double pZtryobin9x173) {
        ztryobin9x173 = pZtryobin9x173;
    }

    private Double ztryobin9x174;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X174)
    public Double getZtryobin9x174() {
        return ztryobin9x174;
    }

    public void setZtryobin9x174(Double pZtryobin9x174) {
        ztryobin9x174 = pZtryobin9x174;
    }

    private Double ztryobin9x175;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X175)
    public Double getZtryobin9x175() {
        return ztryobin9x175;
    }

    public void setZtryobin9x175(Double pZtryobin9x175) {
        ztryobin9x175 = pZtryobin9x175;
    }

    private Double ztryobin9x176;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X176)
    public Double getZtryobin9x176() {
        return ztryobin9x176;
    }

    public void setZtryobin9x176(Double pZtryobin9x176) {
        ztryobin9x176 = pZtryobin9x176;
    }

    private Double ztryobin9x177;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X177)
    public Double getZtryobin9x177() {
        return ztryobin9x177;
    }

    public void setZtryobin9x177(Double pZtryobin9x177) {
        ztryobin9x177 = pZtryobin9x177;
    }

    private Double ztryobin9x178;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X178)
    public Double getZtryobin9x178() {
        return ztryobin9x178;
    }

    public void setZtryobin9x178(Double pZtryobin9x178) {
        ztryobin9x178 = pZtryobin9x178;
    }

    private Double ztryobin9x179;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X179)
    public Double getZtryobin9x179() {
        return ztryobin9x179;
    }

    public void setZtryobin9x179(Double pZtryobin9x179) {
        ztryobin9x179 = pZtryobin9x179;
    }

    private Double ztryobin9x181;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X181)
    public Double getZtryobin9x181() {
        return ztryobin9x181;
    }

    public void setZtryobin9x181(Double pZtryobin9x181) {
        ztryobin9x181 = pZtryobin9x181;
    }

    private Double ztryobin9x182;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X182)
    public Double getZtryobin9x182() {
        return ztryobin9x182;
    }

    public void setZtryobin9x182(Double pZtryobin9x182) {
        ztryobin9x182 = pZtryobin9x182;
    }

    private Double ztryobin9x183;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X183)
    public Double getZtryobin9x183() {
        return ztryobin9x183;
    }

    public void setZtryobin9x183(Double pZtryobin9x183) {
        ztryobin9x183 = pZtryobin9x183;
    }

    private Double ztryobin9x184;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X184)
    public Double getZtryobin9x184() {
        return ztryobin9x184;
    }

    public void setZtryobin9x184(Double pZtryobin9x184) {
        ztryobin9x184 = pZtryobin9x184;
    }

    private Double ztryobin9x185;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X185)
    public Double getZtryobin9x185() {
        return ztryobin9x185;
    }

    public void setZtryobin9x185(Double pZtryobin9x185) {
        ztryobin9x185 = pZtryobin9x185;
    }

    private Double ztryobin9x186;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X186)
    public Double getZtryobin9x186() {
        return ztryobin9x186;
    }

    public void setZtryobin9x186(Double pZtryobin9x186) {
        ztryobin9x186 = pZtryobin9x186;
    }

    private Double ztryobin9x187;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X187)
    public Double getZtryobin9x187() {
        return ztryobin9x187;
    }

    public void setZtryobin9x187(Double pZtryobin9x187) {
        ztryobin9x187 = pZtryobin9x187;
    }

    private Double ztryobin9x188;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X188)
    public Double getZtryobin9x188() {
        return ztryobin9x188;
    }

    public void setZtryobin9x188(Double pZtryobin9x188) {
        ztryobin9x188 = pZtryobin9x188;
    }

    private Double ztryobin9x189;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X189)
    public Double getZtryobin9x189() {
        return ztryobin9x189;
    }

    public void setZtryobin9x189(Double pZtryobin9x189) {
        ztryobin9x189 = pZtryobin9x189;
    }

    private Double ztryobin9x191;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X191)
    public Double getZtryobin9x191() {
        return ztryobin9x191;
    }

    public void setZtryobin9x191(Double pZtryobin9x191) {
        ztryobin9x191 = pZtryobin9x191;
    }

    private Double ztryobin9x192;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X192)
    public Double getZtryobin9x192() {
        return ztryobin9x192;
    }

    public void setZtryobin9x192(Double pZtryobin9x192) {
        ztryobin9x192 = pZtryobin9x192;
    }

    private Double ztryobin9x193;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X193)
    public Double getZtryobin9x193() {
        return ztryobin9x193;
    }

    public void setZtryobin9x193(Double pZtryobin9x193) {
        ztryobin9x193 = pZtryobin9x193;
    }

    private Double ztryobin9x194;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X194)
    public Double getZtryobin9x194() {
        return ztryobin9x194;
    }

    public void setZtryobin9x194(Double pZtryobin9x194) {
        ztryobin9x194 = pZtryobin9x194;
    }

    private Double ztryobin9x195;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X195)
    public Double getZtryobin9x195() {
        return ztryobin9x195;
    }

    public void setZtryobin9x195(Double pZtryobin9x195) {
        ztryobin9x195 = pZtryobin9x195;
    }

    private Double ztryobin9x196;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X196)
    public Double getZtryobin9x196() {
        return ztryobin9x196;
    }

    public void setZtryobin9x196(Double pZtryobin9x196) {
        ztryobin9x196 = pZtryobin9x196;
    }

    private Double ztryobin9x197;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X197)
    public Double getZtryobin9x197() {
        return ztryobin9x197;
    }

    public void setZtryobin9x197(Double pZtryobin9x197) {
        ztryobin9x197 = pZtryobin9x197;
    }

    private Double ztryobin9x198;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X198)
    public Double getZtryobin9x198() {
        return ztryobin9x198;
    }

    public void setZtryobin9x198(Double pZtryobin9x198) {
        ztryobin9x198 = pZtryobin9x198;
    }

    private Double ztryobin9x199;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X199)
    public Double getZtryobin9x199() {
        return ztryobin9x199;
    }

    public void setZtryobin9x199(Double pZtryobin9x199) {
        ztryobin9x199 = pZtryobin9x199;
    }

    private Double ztryobin9x201;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X201)
    public Double getZtryobin9x201() {
        return ztryobin9x201;
    }

    public void setZtryobin9x201(Double pZtryobin9x201) {
        ztryobin9x201 = pZtryobin9x201;
    }

    private Double ztryobin9x202;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X202)
    public Double getZtryobin9x202() {
        return ztryobin9x202;
    }

    public void setZtryobin9x202(Double pZtryobin9x202) {
        ztryobin9x202 = pZtryobin9x202;
    }

    private Double ztryobin9x203;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X203)
    public Double getZtryobin9x203() {
        return ztryobin9x203;
    }

    public void setZtryobin9x203(Double pZtryobin9x203) {
        ztryobin9x203 = pZtryobin9x203;
    }

    private Double ztryobin9x204;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X204)
    public Double getZtryobin9x204() {
        return ztryobin9x204;
    }

    public void setZtryobin9x204(Double pZtryobin9x204) {
        ztryobin9x204 = pZtryobin9x204;
    }

    private Double ztryobin9x205;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X205)
    public Double getZtryobin9x205() {
        return ztryobin9x205;
    }

    public void setZtryobin9x205(Double pZtryobin9x205) {
        ztryobin9x205 = pZtryobin9x205;
    }

    private Double ztryobin9x206;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X206)
    public Double getZtryobin9x206() {
        return ztryobin9x206;
    }

    public void setZtryobin9x206(Double pZtryobin9x206) {
        ztryobin9x206 = pZtryobin9x206;
    }

    private Double ztryobin9x207;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X207)
    public Double getZtryobin9x207() {
        return ztryobin9x207;
    }

    public void setZtryobin9x207(Double pZtryobin9x207) {
        ztryobin9x207 = pZtryobin9x207;
    }

    private Double ztryobin9x208;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X208)
    public Double getZtryobin9x208() {
        return ztryobin9x208;
    }

    public void setZtryobin9x208(Double pZtryobin9x208) {
        ztryobin9x208 = pZtryobin9x208;
    }

    private Double ztryobin9x209;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X209)
    public Double getZtryobin9x209() {
        return ztryobin9x209;
    }

    public void setZtryobin9x209(Double pZtryobin9x209) {
        ztryobin9x209 = pZtryobin9x209;
    }

    private Double ztrusdjpysykn;

    @Column(name=GenZT_KawaserateTr.ZTRUSDJPYSYKN)
    public Double getZtrusdjpysykn() {
        return ztrusdjpysykn;
    }

    public void setZtrusdjpysykn(Double pZtrusdjpysykn) {
        ztrusdjpysykn = pZtrusdjpysykn;
    }

    private Double ztreurjpysykn;

    @Column(name=GenZT_KawaserateTr.ZTREURJPYSYKN)
    public Double getZtreurjpysykn() {
        return ztreurjpysykn;
    }

    public void setZtreurjpysykn(Double pZtreurjpysykn) {
        ztreurjpysykn = pZtreurjpysykn;
    }

    private Double ztraudjpysykn;

    @Column(name=GenZT_KawaserateTr.ZTRAUDJPYSYKN)
    public Double getZtraudjpysykn() {
        return ztraudjpysykn;
    }

    public void setZtraudjpysykn(Double pZtraudjpysykn) {
        ztraudjpysykn = pZtraudjpysykn;
    }

    private Double ztryobin9x301;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X301)
    public Double getZtryobin9x301() {
        return ztryobin9x301;
    }

    public void setZtryobin9x301(Double pZtryobin9x301) {
        ztryobin9x301 = pZtryobin9x301;
    }

    private Double ztryobin9x302;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X302)
    public Double getZtryobin9x302() {
        return ztryobin9x302;
    }

    public void setZtryobin9x302(Double pZtryobin9x302) {
        ztryobin9x302 = pZtryobin9x302;
    }

    private Double ztryobin9x303;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X303)
    public Double getZtryobin9x303() {
        return ztryobin9x303;
    }

    public void setZtryobin9x303(Double pZtryobin9x303) {
        ztryobin9x303 = pZtryobin9x303;
    }

    private Double ztryobin9x304;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X304)
    public Double getZtryobin9x304() {
        return ztryobin9x304;
    }

    public void setZtryobin9x304(Double pZtryobin9x304) {
        ztryobin9x304 = pZtryobin9x304;
    }

    private Double ztryobin9x305;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X305)
    public Double getZtryobin9x305() {
        return ztryobin9x305;
    }

    public void setZtryobin9x305(Double pZtryobin9x305) {
        ztryobin9x305 = pZtryobin9x305;
    }

    private Double ztryobin9x306;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X306)
    public Double getZtryobin9x306() {
        return ztryobin9x306;
    }

    public void setZtryobin9x306(Double pZtryobin9x306) {
        ztryobin9x306 = pZtryobin9x306;
    }

    private Double ztryobin9x307;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X307)
    public Double getZtryobin9x307() {
        return ztryobin9x307;
    }

    public void setZtryobin9x307(Double pZtryobin9x307) {
        ztryobin9x307 = pZtryobin9x307;
    }

    private Double ztrusdjpytts17pm;

    @Column(name=GenZT_KawaserateTr.ZTRUSDJPYTTS17PM)
    public Double getZtrusdjpytts17pm() {
        return ztrusdjpytts17pm;
    }

    public void setZtrusdjpytts17pm(Double pZtrusdjpytts17pm) {
        ztrusdjpytts17pm = pZtrusdjpytts17pm;
    }

    private Double ztrusdjpyttb17pm;

    @Column(name=GenZT_KawaserateTr.ZTRUSDJPYTTB17PM)
    public Double getZtrusdjpyttb17pm() {
        return ztrusdjpyttb17pm;
    }

    public void setZtrusdjpyttb17pm(Double pZtrusdjpyttb17pm) {
        ztrusdjpyttb17pm = pZtrusdjpyttb17pm;
    }

    private Double ztrusdjpyttm17pm;

    @Column(name=GenZT_KawaserateTr.ZTRUSDJPYTTM17PM)
    public Double getZtrusdjpyttm17pm() {
        return ztrusdjpyttm17pm;
    }

    public void setZtrusdjpyttm17pm(Double pZtrusdjpyttm17pm) {
        ztrusdjpyttm17pm = pZtrusdjpyttm17pm;
    }

    private Double ztreurjpytts17pm;

    @Column(name=GenZT_KawaserateTr.ZTREURJPYTTS17PM)
    public Double getZtreurjpytts17pm() {
        return ztreurjpytts17pm;
    }

    public void setZtreurjpytts17pm(Double pZtreurjpytts17pm) {
        ztreurjpytts17pm = pZtreurjpytts17pm;
    }

    private Double ztreurjpyttb17pm;

    @Column(name=GenZT_KawaserateTr.ZTREURJPYTTB17PM)
    public Double getZtreurjpyttb17pm() {
        return ztreurjpyttb17pm;
    }

    public void setZtreurjpyttb17pm(Double pZtreurjpyttb17pm) {
        ztreurjpyttb17pm = pZtreurjpyttb17pm;
    }

    private Double ztreurjpyttm17pm;

    @Column(name=GenZT_KawaserateTr.ZTREURJPYTTM17PM)
    public Double getZtreurjpyttm17pm() {
        return ztreurjpyttm17pm;
    }

    public void setZtreurjpyttm17pm(Double pZtreurjpyttm17pm) {
        ztreurjpyttm17pm = pZtreurjpyttm17pm;
    }

    private Double ztraudjpytts17pm;

    @Column(name=GenZT_KawaserateTr.ZTRAUDJPYTTS17PM)
    public Double getZtraudjpytts17pm() {
        return ztraudjpytts17pm;
    }

    public void setZtraudjpytts17pm(Double pZtraudjpytts17pm) {
        ztraudjpytts17pm = pZtraudjpytts17pm;
    }

    private Double ztraudjpyttb17pm;

    @Column(name=GenZT_KawaserateTr.ZTRAUDJPYTTB17PM)
    public Double getZtraudjpyttb17pm() {
        return ztraudjpyttb17pm;
    }

    public void setZtraudjpyttb17pm(Double pZtraudjpyttb17pm) {
        ztraudjpyttb17pm = pZtraudjpyttb17pm;
    }

    private Double ztraudjpyttm17pm;

    @Column(name=GenZT_KawaserateTr.ZTRAUDJPYTTM17PM)
    public Double getZtraudjpyttm17pm() {
        return ztraudjpyttm17pm;
    }

    public void setZtraudjpyttm17pm(Double pZtraudjpyttm17pm) {
        ztraudjpyttm17pm = pZtraudjpyttm17pm;
    }

    private Double ztryobin9x501;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X501)
    public Double getZtryobin9x501() {
        return ztryobin9x501;
    }

    public void setZtryobin9x501(Double pZtryobin9x501) {
        ztryobin9x501 = pZtryobin9x501;
    }

    private Double ztryobin9x502;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X502)
    public Double getZtryobin9x502() {
        return ztryobin9x502;
    }

    public void setZtryobin9x502(Double pZtryobin9x502) {
        ztryobin9x502 = pZtryobin9x502;
    }

    private Double ztryobin9x503;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X503)
    public Double getZtryobin9x503() {
        return ztryobin9x503;
    }

    public void setZtryobin9x503(Double pZtryobin9x503) {
        ztryobin9x503 = pZtryobin9x503;
    }

    private Double ztryobin9x504;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X504)
    public Double getZtryobin9x504() {
        return ztryobin9x504;
    }

    public void setZtryobin9x504(Double pZtryobin9x504) {
        ztryobin9x504 = pZtryobin9x504;
    }

    private Double ztryobin9x505;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X505)
    public Double getZtryobin9x505() {
        return ztryobin9x505;
    }

    public void setZtryobin9x505(Double pZtryobin9x505) {
        ztryobin9x505 = pZtryobin9x505;
    }

    private Double ztryobin9x506;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X506)
    public Double getZtryobin9x506() {
        return ztryobin9x506;
    }

    public void setZtryobin9x506(Double pZtryobin9x506) {
        ztryobin9x506 = pZtryobin9x506;
    }

    private Double ztryobin9x507;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X507)
    public Double getZtryobin9x507() {
        return ztryobin9x507;
    }

    public void setZtryobin9x507(Double pZtryobin9x507) {
        ztryobin9x507 = pZtryobin9x507;
    }

    private Double ztryobin9x508;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X508)
    public Double getZtryobin9x508() {
        return ztryobin9x508;
    }

    public void setZtryobin9x508(Double pZtryobin9x508) {
        ztryobin9x508 = pZtryobin9x508;
    }

    private Double ztryobin9x509;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X509)
    public Double getZtryobin9x509() {
        return ztryobin9x509;
    }

    public void setZtryobin9x509(Double pZtryobin9x509) {
        ztryobin9x509 = pZtryobin9x509;
    }

    private Double ztryobin9x510;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X510)
    public Double getZtryobin9x510() {
        return ztryobin9x510;
    }

    public void setZtryobin9x510(Double pZtryobin9x510) {
        ztryobin9x510 = pZtryobin9x510;
    }

    private Double ztryobin9x511;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X511)
    public Double getZtryobin9x511() {
        return ztryobin9x511;
    }

    public void setZtryobin9x511(Double pZtryobin9x511) {
        ztryobin9x511 = pZtryobin9x511;
    }

    private Double ztryobin9x512;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X512)
    public Double getZtryobin9x512() {
        return ztryobin9x512;
    }

    public void setZtryobin9x512(Double pZtryobin9x512) {
        ztryobin9x512 = pZtryobin9x512;
    }

    private Double ztryobin9x513;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X513)
    public Double getZtryobin9x513() {
        return ztryobin9x513;
    }

    public void setZtryobin9x513(Double pZtryobin9x513) {
        ztryobin9x513 = pZtryobin9x513;
    }

    private Double ztryobin9x514;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X514)
    public Double getZtryobin9x514() {
        return ztryobin9x514;
    }

    public void setZtryobin9x514(Double pZtryobin9x514) {
        ztryobin9x514 = pZtryobin9x514;
    }

    private Double ztryobin9x515;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X515)
    public Double getZtryobin9x515() {
        return ztryobin9x515;
    }

    public void setZtryobin9x515(Double pZtryobin9x515) {
        ztryobin9x515 = pZtryobin9x515;
    }

    private Double ztryobin9x516;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X516)
    public Double getZtryobin9x516() {
        return ztryobin9x516;
    }

    public void setZtryobin9x516(Double pZtryobin9x516) {
        ztryobin9x516 = pZtryobin9x516;
    }

    private Double ztryobin9x517;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X517)
    public Double getZtryobin9x517() {
        return ztryobin9x517;
    }

    public void setZtryobin9x517(Double pZtryobin9x517) {
        ztryobin9x517 = pZtryobin9x517;
    }

    private Double ztryobin9x518;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X518)
    public Double getZtryobin9x518() {
        return ztryobin9x518;
    }

    public void setZtryobin9x518(Double pZtryobin9x518) {
        ztryobin9x518 = pZtryobin9x518;
    }

    private Double ztryobin9x519;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X519)
    public Double getZtryobin9x519() {
        return ztryobin9x519;
    }

    public void setZtryobin9x519(Double pZtryobin9x519) {
        ztryobin9x519 = pZtryobin9x519;
    }

    private Double ztryobin9x520;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X520)
    public Double getZtryobin9x520() {
        return ztryobin9x520;
    }

    public void setZtryobin9x520(Double pZtryobin9x520) {
        ztryobin9x520 = pZtryobin9x520;
    }

    private Double ztryobin9x521;

    @Column(name=GenZT_KawaserateTr.ZTRYOBIN9X521)
    public Double getZtryobin9x521() {
        return ztryobin9x521;
    }

    public void setZtryobin9x521(Double pZtryobin9x521) {
        ztryobin9x521 = pZtryobin9x521;
    }
}
