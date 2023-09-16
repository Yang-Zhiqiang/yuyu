package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_KawaserateRn;
import yuyu.def.db.id.PKZT_KawaserateRn;
import yuyu.def.db.meta.GenQZT_KawaserateRn;
import yuyu.def.db.meta.QZT_KawaserateRn;

/**
 * 為替レートテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KawaserateRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KawaserateRn}</td><td colspan="3">為替レートテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnkwsratekjymd zrnkwsratekjymd}</td><td>（連携用）為替レート基準日</td><td align="center">{@link PKZT_KawaserateRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaserendoukbn zrnkawaserendoukbn}</td><td>（連携用）為替レート連動区分</td><td align="center">{@link PKZT_KawaserateRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv91 zrnyobiv91}</td><td>（連携用）予備項目Ｖ９１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnusdjpytts zrnusdjpytts}</td><td>（連携用）米ドル－円（ＴＴＳ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnusdjpyttb zrnusdjpyttb}</td><td>（連携用）米ドル－円（ＴＴＢ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnusdjpyttm zrnusdjpyttm}</td><td>（連携用）米ドル－円（ＴＴＭ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrneurjpytts zrneurjpytts}</td><td>（連携用）ユーロ－円（ＴＴＳ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrneurjpyttb zrneurjpyttb}</td><td>（連携用）ユーロ－円（ＴＴＢ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrneurjpyttm zrneurjpyttm}</td><td>（連携用）ユーロ－円（ＴＴＭ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnaudjpytts zrnaudjpytts}</td><td>（連携用）豪ドル－円（ＴＴＳ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnaudjpyttb zrnaudjpyttb}</td><td>（連携用）豪ドル－円（ＴＴＢ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnaudjpyttm zrnaudjpyttm}</td><td>（連携用）豪ドル－円（ＴＴＭ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9 zrnyobin9}</td><td>（連携用）予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x2 zrnyobin9x2}</td><td>（連携用）予備項目Ｎ９＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x3 zrnyobin9x3}</td><td>（連携用）予備項目Ｎ９＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x4 zrnyobin9x4}</td><td>（連携用）予備項目Ｎ９＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x5 zrnyobin9x5}</td><td>（連携用）予備項目Ｎ９＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x6 zrnyobin9x6}</td><td>（連携用）予備項目Ｎ９＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x7 zrnyobin9x7}</td><td>（連携用）予備項目Ｎ９＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x8 zrnyobin9x8}</td><td>（連携用）予備項目Ｎ９＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x9 zrnyobin9x9}</td><td>（連携用）予備項目Ｎ９＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x10 zrnyobin9x10}</td><td>（連携用）予備項目Ｎ９＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x11 zrnyobin9x11}</td><td>（連携用）予備項目Ｎ９＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x12 zrnyobin9x12}</td><td>（連携用）予備項目Ｎ９＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x13 zrnyobin9x13}</td><td>（連携用）予備項目Ｎ９＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x14 zrnyobin9x14}</td><td>（連携用）予備項目Ｎ９＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x15 zrnyobin9x15}</td><td>（連携用）予備項目Ｎ９＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x16 zrnyobin9x16}</td><td>（連携用）予備項目Ｎ９＿１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x17 zrnyobin9x17}</td><td>（連携用）予備項目Ｎ９＿１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x18 zrnyobin9x18}</td><td>（連携用）予備項目Ｎ９＿１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x19 zrnyobin9x19}</td><td>（連携用）予備項目Ｎ９＿１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x20 zrnyobin9x20}</td><td>（連携用）予備項目Ｎ９＿２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x21 zrnyobin9x21}</td><td>（連携用）予備項目Ｎ９＿２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnusdjpynykn zrnusdjpynykn}</td><td>（連携用）米ドル－円（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrneurjpynykn zrneurjpynykn}</td><td>（連携用）ユーロ－円（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnaudjpynykn zrnaudjpynykn}</td><td>（連携用）豪ドル－円（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x101 zrnyobin9x101}</td><td>（連携用）予備項目Ｎ９＿１０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x102 zrnyobin9x102}</td><td>（連携用）予備項目Ｎ９＿１０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x103 zrnyobin9x103}</td><td>（連携用）予備項目Ｎ９＿１０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x104 zrnyobin9x104}</td><td>（連携用）予備項目Ｎ９＿１０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x105 zrnyobin9x105}</td><td>（連携用）予備項目Ｎ９＿１０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x106 zrnyobin9x106}</td><td>（連携用）予備項目Ｎ９＿１０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x107 zrnyobin9x107}</td><td>（連携用）予備項目Ｎ９＿１０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnusdeurnykn zrnusdeurnykn}</td><td>（連携用）米ドル－ユーロ（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnusdaudnykn zrnusdaudnykn}</td><td>（連携用）米ドル－豪ドル（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x111 zrnyobin9x111}</td><td>（連携用）予備項目Ｎ９＿１１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x112 zrnyobin9x112}</td><td>（連携用）予備項目Ｎ９＿１１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x113 zrnyobin9x113}</td><td>（連携用）予備項目Ｎ９＿１１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x114 zrnyobin9x114}</td><td>（連携用）予備項目Ｎ９＿１１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x115 zrnyobin9x115}</td><td>（連携用）予備項目Ｎ９＿１１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x116 zrnyobin9x116}</td><td>（連携用）予備項目Ｎ９＿１１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x117 zrnyobin9x117}</td><td>（連携用）予備項目Ｎ９＿１１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrneurusdnykn zrneurusdnykn}</td><td>（連携用）ユーロ－米ドル（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrneuraudnykn zrneuraudnykn}</td><td>（連携用）ユーロ－豪ドル（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x121 zrnyobin9x121}</td><td>（連携用）予備項目Ｎ９＿１２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x122 zrnyobin9x122}</td><td>（連携用）予備項目Ｎ９＿１２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x123 zrnyobin9x123}</td><td>（連携用）予備項目Ｎ９＿１２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x124 zrnyobin9x124}</td><td>（連携用）予備項目Ｎ９＿１２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x125 zrnyobin9x125}</td><td>（連携用）予備項目Ｎ９＿１２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x126 zrnyobin9x126}</td><td>（連携用）予備項目Ｎ９＿１２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x127 zrnyobin9x127}</td><td>（連携用）予備項目Ｎ９＿１２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnaudusenykn zrnaudusenykn}</td><td>（連携用）豪ドル－米ドル（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnaudeurnykn zrnaudeurnykn}</td><td>（連携用）豪ドル－ユーロ（入金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x131 zrnyobin9x131}</td><td>（連携用）予備項目Ｎ９＿１３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x132 zrnyobin9x132}</td><td>（連携用）予備項目Ｎ９＿１３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x133 zrnyobin9x133}</td><td>（連携用）予備項目Ｎ９＿１３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x134 zrnyobin9x134}</td><td>（連携用）予備項目Ｎ９＿１３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x135 zrnyobin9x135}</td><td>（連携用）予備項目Ｎ９＿１３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x136 zrnyobin9x136}</td><td>（連携用）予備項目Ｎ９＿１３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x137 zrnyobin9x137}</td><td>（連携用）予備項目Ｎ９＿１３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x141 zrnyobin9x141}</td><td>（連携用）予備項目Ｎ９＿１４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x142 zrnyobin9x142}</td><td>（連携用）予備項目Ｎ９＿１４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x143 zrnyobin9x143}</td><td>（連携用）予備項目Ｎ９＿１４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x144 zrnyobin9x144}</td><td>（連携用）予備項目Ｎ９＿１４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x145 zrnyobin9x145}</td><td>（連携用）予備項目Ｎ９＿１４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x146 zrnyobin9x146}</td><td>（連携用）予備項目Ｎ９＿１４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x147 zrnyobin9x147}</td><td>（連携用）予備項目Ｎ９＿１４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x148 zrnyobin9x148}</td><td>（連携用）予備項目Ｎ９＿１４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x149 zrnyobin9x149}</td><td>（連携用）予備項目Ｎ９＿１４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x151 zrnyobin9x151}</td><td>（連携用）予備項目Ｎ９＿１５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x152 zrnyobin9x152}</td><td>（連携用）予備項目Ｎ９＿１５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x153 zrnyobin9x153}</td><td>（連携用）予備項目Ｎ９＿１５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x154 zrnyobin9x154}</td><td>（連携用）予備項目Ｎ９＿１５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x155 zrnyobin9x155}</td><td>（連携用）予備項目Ｎ９＿１５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x156 zrnyobin9x156}</td><td>（連携用）予備項目Ｎ９＿１５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x157 zrnyobin9x157}</td><td>（連携用）予備項目Ｎ９＿１５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x158 zrnyobin9x158}</td><td>（連携用）予備項目Ｎ９＿１５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x159 zrnyobin9x159}</td><td>（連携用）予備項目Ｎ９＿１５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x161 zrnyobin9x161}</td><td>（連携用）予備項目Ｎ９＿１６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x162 zrnyobin9x162}</td><td>（連携用）予備項目Ｎ９＿１６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x163 zrnyobin9x163}</td><td>（連携用）予備項目Ｎ９＿１６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x164 zrnyobin9x164}</td><td>（連携用）予備項目Ｎ９＿１６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x165 zrnyobin9x165}</td><td>（連携用）予備項目Ｎ９＿１６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x166 zrnyobin9x166}</td><td>（連携用）予備項目Ｎ９＿１６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x167 zrnyobin9x167}</td><td>（連携用）予備項目Ｎ９＿１６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x168 zrnyobin9x168}</td><td>（連携用）予備項目Ｎ９＿１６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x169 zrnyobin9x169}</td><td>（連携用）予備項目Ｎ９＿１６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x171 zrnyobin9x171}</td><td>（連携用）予備項目Ｎ９＿１７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x172 zrnyobin9x172}</td><td>（連携用）予備項目Ｎ９＿１７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x173 zrnyobin9x173}</td><td>（連携用）予備項目Ｎ９＿１７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x174 zrnyobin9x174}</td><td>（連携用）予備項目Ｎ９＿１７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x175 zrnyobin9x175}</td><td>（連携用）予備項目Ｎ９＿１７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x176 zrnyobin9x176}</td><td>（連携用）予備項目Ｎ９＿１７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x177 zrnyobin9x177}</td><td>（連携用）予備項目Ｎ９＿１７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x178 zrnyobin9x178}</td><td>（連携用）予備項目Ｎ９＿１７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x179 zrnyobin9x179}</td><td>（連携用）予備項目Ｎ９＿１７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x181 zrnyobin9x181}</td><td>（連携用）予備項目Ｎ９＿１８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x182 zrnyobin9x182}</td><td>（連携用）予備項目Ｎ９＿１８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x183 zrnyobin9x183}</td><td>（連携用）予備項目Ｎ９＿１８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x184 zrnyobin9x184}</td><td>（連携用）予備項目Ｎ９＿１８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x185 zrnyobin9x185}</td><td>（連携用）予備項目Ｎ９＿１８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x186 zrnyobin9x186}</td><td>（連携用）予備項目Ｎ９＿１８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x187 zrnyobin9x187}</td><td>（連携用）予備項目Ｎ９＿１８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x188 zrnyobin9x188}</td><td>（連携用）予備項目Ｎ９＿１８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x189 zrnyobin9x189}</td><td>（連携用）予備項目Ｎ９＿１８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x191 zrnyobin9x191}</td><td>（連携用）予備項目Ｎ９＿１９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x192 zrnyobin9x192}</td><td>（連携用）予備項目Ｎ９＿１９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x193 zrnyobin9x193}</td><td>（連携用）予備項目Ｎ９＿１９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x194 zrnyobin9x194}</td><td>（連携用）予備項目Ｎ９＿１９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x195 zrnyobin9x195}</td><td>（連携用）予備項目Ｎ９＿１９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x196 zrnyobin9x196}</td><td>（連携用）予備項目Ｎ９＿１９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x197 zrnyobin9x197}</td><td>（連携用）予備項目Ｎ９＿１９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x198 zrnyobin9x198}</td><td>（連携用）予備項目Ｎ９＿１９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x199 zrnyobin9x199}</td><td>（連携用）予備項目Ｎ９＿１９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x201 zrnyobin9x201}</td><td>（連携用）予備項目Ｎ９＿２０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x202 zrnyobin9x202}</td><td>（連携用）予備項目Ｎ９＿２０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x203 zrnyobin9x203}</td><td>（連携用）予備項目Ｎ９＿２０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x204 zrnyobin9x204}</td><td>（連携用）予備項目Ｎ９＿２０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x205 zrnyobin9x205}</td><td>（連携用）予備項目Ｎ９＿２０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x206 zrnyobin9x206}</td><td>（連携用）予備項目Ｎ９＿２０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x207 zrnyobin9x207}</td><td>（連携用）予備項目Ｎ９＿２０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x208 zrnyobin9x208}</td><td>（連携用）予備項目Ｎ９＿２０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x209 zrnyobin9x209}</td><td>（連携用）予備項目Ｎ９＿２０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnusdjpysykn zrnusdjpysykn}</td><td>（連携用）米ドル－円（出金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrneurjpysykn zrneurjpysykn}</td><td>（連携用）ユーロ－円（出金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnaudjpysykn zrnaudjpysykn}</td><td>（連携用）豪ドル－円（出金用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x301 zrnyobin9x301}</td><td>（連携用）予備項目Ｎ９＿３０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x302 zrnyobin9x302}</td><td>（連携用）予備項目Ｎ９＿３０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x303 zrnyobin9x303}</td><td>（連携用）予備項目Ｎ９＿３０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x304 zrnyobin9x304}</td><td>（連携用）予備項目Ｎ９＿３０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x305 zrnyobin9x305}</td><td>（連携用）予備項目Ｎ９＿３０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x306 zrnyobin9x306}</td><td>（連携用）予備項目Ｎ９＿３０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x307 zrnyobin9x307}</td><td>（連携用）予備項目Ｎ９＿３０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnusdjpytts17pm zrnusdjpytts17pm}</td><td>（連携用）米ドル－円（ＴＴＳ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnusdjpyttb17pm zrnusdjpyttb17pm}</td><td>（連携用）米ドル－円（ＴＴＢ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnusdjpyttm17pm zrnusdjpyttm17pm}</td><td>（連携用）米ドル－円（ＴＴＭ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrneurjpytts17pm zrneurjpytts17pm}</td><td>（連携用）ユーロ－円（ＴＴＳ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrneurjpyttb17pm zrneurjpyttb17pm}</td><td>（連携用）ユーロ－円（ＴＴＢ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrneurjpyttm17pm zrneurjpyttm17pm}</td><td>（連携用）ユーロ－円（ＴＴＭ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnaudjpytts17pm zrnaudjpytts17pm}</td><td>（連携用）豪ドル－円（ＴＴＳ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnaudjpyttb17pm zrnaudjpyttb17pm}</td><td>（連携用）豪ドル－円（ＴＴＢ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnaudjpyttm17pm zrnaudjpyttm17pm}</td><td>（連携用）豪ドル－円（ＴＴＭ）１７時</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x501 zrnyobin9x501}</td><td>（連携用）予備項目Ｎ９＿５０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x502 zrnyobin9x502}</td><td>（連携用）予備項目Ｎ９＿５０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x503 zrnyobin9x503}</td><td>（連携用）予備項目Ｎ９＿５０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x504 zrnyobin9x504}</td><td>（連携用）予備項目Ｎ９＿５０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x505 zrnyobin9x505}</td><td>（連携用）予備項目Ｎ９＿５０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x506 zrnyobin9x506}</td><td>（連携用）予備項目Ｎ９＿５０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x507 zrnyobin9x507}</td><td>（連携用）予備項目Ｎ９＿５０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x508 zrnyobin9x508}</td><td>（連携用）予備項目Ｎ９＿５０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x509 zrnyobin9x509}</td><td>（連携用）予備項目Ｎ９＿５０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x510 zrnyobin9x510}</td><td>（連携用）予備項目Ｎ９＿５１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x511 zrnyobin9x511}</td><td>（連携用）予備項目Ｎ９＿５１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x512 zrnyobin9x512}</td><td>（連携用）予備項目Ｎ９＿５１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x513 zrnyobin9x513}</td><td>（連携用）予備項目Ｎ９＿５１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x514 zrnyobin9x514}</td><td>（連携用）予備項目Ｎ９＿５１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x515 zrnyobin9x515}</td><td>（連携用）予備項目Ｎ９＿５１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x516 zrnyobin9x516}</td><td>（連携用）予備項目Ｎ９＿５１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x517 zrnyobin9x517}</td><td>（連携用）予備項目Ｎ９＿５１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x518 zrnyobin9x518}</td><td>（連携用）予備項目Ｎ９＿５１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x519 zrnyobin9x519}</td><td>（連携用）予備項目Ｎ９＿５１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x520 zrnyobin9x520}</td><td>（連携用）予備項目Ｎ９＿５２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobin9x521 zrnyobin9x521}</td><td>（連携用）予備項目Ｎ９＿５２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 * </table>
 * @see     ZT_KawaserateRn
 * @see     PKZT_KawaserateRn
 * @see     QZT_KawaserateRn
 * @see     GenQZT_KawaserateRn
 */
@MappedSuperclass
@Table(name=GenZT_KawaserateRn.TABLE_NAME)
@IdClass(value=PKZT_KawaserateRn.class)
public abstract class GenZT_KawaserateRn extends AbstractExDBEntityForZDB<ZT_KawaserateRn, PKZT_KawaserateRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KawaserateRn";
    public static final String ZRNKWSRATEKJYMD          = "zrnkwsratekjymd";
    public static final String ZRNKAWASERENDOUKBN       = "zrnkawaserendoukbn";
    public static final String ZRNYOBIV91               = "zrnyobiv91";
    public static final String ZRNUSDJPYTTS             = "zrnusdjpytts";
    public static final String ZRNUSDJPYTTB             = "zrnusdjpyttb";
    public static final String ZRNUSDJPYTTM             = "zrnusdjpyttm";
    public static final String ZRNEURJPYTTS             = "zrneurjpytts";
    public static final String ZRNEURJPYTTB             = "zrneurjpyttb";
    public static final String ZRNEURJPYTTM             = "zrneurjpyttm";
    public static final String ZRNAUDJPYTTS             = "zrnaudjpytts";
    public static final String ZRNAUDJPYTTB             = "zrnaudjpyttb";
    public static final String ZRNAUDJPYTTM             = "zrnaudjpyttm";
    public static final String ZRNYOBIN9                = "zrnyobin9";
    public static final String ZRNYOBIN9X2              = "zrnyobin9x2";
    public static final String ZRNYOBIN9X3              = "zrnyobin9x3";
    public static final String ZRNYOBIN9X4              = "zrnyobin9x4";
    public static final String ZRNYOBIN9X5              = "zrnyobin9x5";
    public static final String ZRNYOBIN9X6              = "zrnyobin9x6";
    public static final String ZRNYOBIN9X7              = "zrnyobin9x7";
    public static final String ZRNYOBIN9X8              = "zrnyobin9x8";
    public static final String ZRNYOBIN9X9              = "zrnyobin9x9";
    public static final String ZRNYOBIN9X10             = "zrnyobin9x10";
    public static final String ZRNYOBIN9X11             = "zrnyobin9x11";
    public static final String ZRNYOBIN9X12             = "zrnyobin9x12";
    public static final String ZRNYOBIN9X13             = "zrnyobin9x13";
    public static final String ZRNYOBIN9X14             = "zrnyobin9x14";
    public static final String ZRNYOBIN9X15             = "zrnyobin9x15";
    public static final String ZRNYOBIN9X16             = "zrnyobin9x16";
    public static final String ZRNYOBIN9X17             = "zrnyobin9x17";
    public static final String ZRNYOBIN9X18             = "zrnyobin9x18";
    public static final String ZRNYOBIN9X19             = "zrnyobin9x19";
    public static final String ZRNYOBIN9X20             = "zrnyobin9x20";
    public static final String ZRNYOBIN9X21             = "zrnyobin9x21";
    public static final String ZRNUSDJPYNYKN            = "zrnusdjpynykn";
    public static final String ZRNEURJPYNYKN            = "zrneurjpynykn";
    public static final String ZRNAUDJPYNYKN            = "zrnaudjpynykn";
    public static final String ZRNYOBIN9X101            = "zrnyobin9x101";
    public static final String ZRNYOBIN9X102            = "zrnyobin9x102";
    public static final String ZRNYOBIN9X103            = "zrnyobin9x103";
    public static final String ZRNYOBIN9X104            = "zrnyobin9x104";
    public static final String ZRNYOBIN9X105            = "zrnyobin9x105";
    public static final String ZRNYOBIN9X106            = "zrnyobin9x106";
    public static final String ZRNYOBIN9X107            = "zrnyobin9x107";
    public static final String ZRNUSDEURNYKN            = "zrnusdeurnykn";
    public static final String ZRNUSDAUDNYKN            = "zrnusdaudnykn";
    public static final String ZRNYOBIN9X111            = "zrnyobin9x111";
    public static final String ZRNYOBIN9X112            = "zrnyobin9x112";
    public static final String ZRNYOBIN9X113            = "zrnyobin9x113";
    public static final String ZRNYOBIN9X114            = "zrnyobin9x114";
    public static final String ZRNYOBIN9X115            = "zrnyobin9x115";
    public static final String ZRNYOBIN9X116            = "zrnyobin9x116";
    public static final String ZRNYOBIN9X117            = "zrnyobin9x117";
    public static final String ZRNEURUSDNYKN            = "zrneurusdnykn";
    public static final String ZRNEURAUDNYKN            = "zrneuraudnykn";
    public static final String ZRNYOBIN9X121            = "zrnyobin9x121";
    public static final String ZRNYOBIN9X122            = "zrnyobin9x122";
    public static final String ZRNYOBIN9X123            = "zrnyobin9x123";
    public static final String ZRNYOBIN9X124            = "zrnyobin9x124";
    public static final String ZRNYOBIN9X125            = "zrnyobin9x125";
    public static final String ZRNYOBIN9X126            = "zrnyobin9x126";
    public static final String ZRNYOBIN9X127            = "zrnyobin9x127";
    public static final String ZRNAUDUSENYKN            = "zrnaudusenykn";
    public static final String ZRNAUDEURNYKN            = "zrnaudeurnykn";
    public static final String ZRNYOBIN9X131            = "zrnyobin9x131";
    public static final String ZRNYOBIN9X132            = "zrnyobin9x132";
    public static final String ZRNYOBIN9X133            = "zrnyobin9x133";
    public static final String ZRNYOBIN9X134            = "zrnyobin9x134";
    public static final String ZRNYOBIN9X135            = "zrnyobin9x135";
    public static final String ZRNYOBIN9X136            = "zrnyobin9x136";
    public static final String ZRNYOBIN9X137            = "zrnyobin9x137";
    public static final String ZRNYOBIN9X141            = "zrnyobin9x141";
    public static final String ZRNYOBIN9X142            = "zrnyobin9x142";
    public static final String ZRNYOBIN9X143            = "zrnyobin9x143";
    public static final String ZRNYOBIN9X144            = "zrnyobin9x144";
    public static final String ZRNYOBIN9X145            = "zrnyobin9x145";
    public static final String ZRNYOBIN9X146            = "zrnyobin9x146";
    public static final String ZRNYOBIN9X147            = "zrnyobin9x147";
    public static final String ZRNYOBIN9X148            = "zrnyobin9x148";
    public static final String ZRNYOBIN9X149            = "zrnyobin9x149";
    public static final String ZRNYOBIN9X151            = "zrnyobin9x151";
    public static final String ZRNYOBIN9X152            = "zrnyobin9x152";
    public static final String ZRNYOBIN9X153            = "zrnyobin9x153";
    public static final String ZRNYOBIN9X154            = "zrnyobin9x154";
    public static final String ZRNYOBIN9X155            = "zrnyobin9x155";
    public static final String ZRNYOBIN9X156            = "zrnyobin9x156";
    public static final String ZRNYOBIN9X157            = "zrnyobin9x157";
    public static final String ZRNYOBIN9X158            = "zrnyobin9x158";
    public static final String ZRNYOBIN9X159            = "zrnyobin9x159";
    public static final String ZRNYOBIN9X161            = "zrnyobin9x161";
    public static final String ZRNYOBIN9X162            = "zrnyobin9x162";
    public static final String ZRNYOBIN9X163            = "zrnyobin9x163";
    public static final String ZRNYOBIN9X164            = "zrnyobin9x164";
    public static final String ZRNYOBIN9X165            = "zrnyobin9x165";
    public static final String ZRNYOBIN9X166            = "zrnyobin9x166";
    public static final String ZRNYOBIN9X167            = "zrnyobin9x167";
    public static final String ZRNYOBIN9X168            = "zrnyobin9x168";
    public static final String ZRNYOBIN9X169            = "zrnyobin9x169";
    public static final String ZRNYOBIN9X171            = "zrnyobin9x171";
    public static final String ZRNYOBIN9X172            = "zrnyobin9x172";
    public static final String ZRNYOBIN9X173            = "zrnyobin9x173";
    public static final String ZRNYOBIN9X174            = "zrnyobin9x174";
    public static final String ZRNYOBIN9X175            = "zrnyobin9x175";
    public static final String ZRNYOBIN9X176            = "zrnyobin9x176";
    public static final String ZRNYOBIN9X177            = "zrnyobin9x177";
    public static final String ZRNYOBIN9X178            = "zrnyobin9x178";
    public static final String ZRNYOBIN9X179            = "zrnyobin9x179";
    public static final String ZRNYOBIN9X181            = "zrnyobin9x181";
    public static final String ZRNYOBIN9X182            = "zrnyobin9x182";
    public static final String ZRNYOBIN9X183            = "zrnyobin9x183";
    public static final String ZRNYOBIN9X184            = "zrnyobin9x184";
    public static final String ZRNYOBIN9X185            = "zrnyobin9x185";
    public static final String ZRNYOBIN9X186            = "zrnyobin9x186";
    public static final String ZRNYOBIN9X187            = "zrnyobin9x187";
    public static final String ZRNYOBIN9X188            = "zrnyobin9x188";
    public static final String ZRNYOBIN9X189            = "zrnyobin9x189";
    public static final String ZRNYOBIN9X191            = "zrnyobin9x191";
    public static final String ZRNYOBIN9X192            = "zrnyobin9x192";
    public static final String ZRNYOBIN9X193            = "zrnyobin9x193";
    public static final String ZRNYOBIN9X194            = "zrnyobin9x194";
    public static final String ZRNYOBIN9X195            = "zrnyobin9x195";
    public static final String ZRNYOBIN9X196            = "zrnyobin9x196";
    public static final String ZRNYOBIN9X197            = "zrnyobin9x197";
    public static final String ZRNYOBIN9X198            = "zrnyobin9x198";
    public static final String ZRNYOBIN9X199            = "zrnyobin9x199";
    public static final String ZRNYOBIN9X201            = "zrnyobin9x201";
    public static final String ZRNYOBIN9X202            = "zrnyobin9x202";
    public static final String ZRNYOBIN9X203            = "zrnyobin9x203";
    public static final String ZRNYOBIN9X204            = "zrnyobin9x204";
    public static final String ZRNYOBIN9X205            = "zrnyobin9x205";
    public static final String ZRNYOBIN9X206            = "zrnyobin9x206";
    public static final String ZRNYOBIN9X207            = "zrnyobin9x207";
    public static final String ZRNYOBIN9X208            = "zrnyobin9x208";
    public static final String ZRNYOBIN9X209            = "zrnyobin9x209";
    public static final String ZRNUSDJPYSYKN            = "zrnusdjpysykn";
    public static final String ZRNEURJPYSYKN            = "zrneurjpysykn";
    public static final String ZRNAUDJPYSYKN            = "zrnaudjpysykn";
    public static final String ZRNYOBIN9X301            = "zrnyobin9x301";
    public static final String ZRNYOBIN9X302            = "zrnyobin9x302";
    public static final String ZRNYOBIN9X303            = "zrnyobin9x303";
    public static final String ZRNYOBIN9X304            = "zrnyobin9x304";
    public static final String ZRNYOBIN9X305            = "zrnyobin9x305";
    public static final String ZRNYOBIN9X306            = "zrnyobin9x306";
    public static final String ZRNYOBIN9X307            = "zrnyobin9x307";
    public static final String ZRNUSDJPYTTS17PM         = "zrnusdjpytts17pm";
    public static final String ZRNUSDJPYTTB17PM         = "zrnusdjpyttb17pm";
    public static final String ZRNUSDJPYTTM17PM         = "zrnusdjpyttm17pm";
    public static final String ZRNEURJPYTTS17PM         = "zrneurjpytts17pm";
    public static final String ZRNEURJPYTTB17PM         = "zrneurjpyttb17pm";
    public static final String ZRNEURJPYTTM17PM         = "zrneurjpyttm17pm";
    public static final String ZRNAUDJPYTTS17PM         = "zrnaudjpytts17pm";
    public static final String ZRNAUDJPYTTB17PM         = "zrnaudjpyttb17pm";
    public static final String ZRNAUDJPYTTM17PM         = "zrnaudjpyttm17pm";
    public static final String ZRNYOBIN9X501            = "zrnyobin9x501";
    public static final String ZRNYOBIN9X502            = "zrnyobin9x502";
    public static final String ZRNYOBIN9X503            = "zrnyobin9x503";
    public static final String ZRNYOBIN9X504            = "zrnyobin9x504";
    public static final String ZRNYOBIN9X505            = "zrnyobin9x505";
    public static final String ZRNYOBIN9X506            = "zrnyobin9x506";
    public static final String ZRNYOBIN9X507            = "zrnyobin9x507";
    public static final String ZRNYOBIN9X508            = "zrnyobin9x508";
    public static final String ZRNYOBIN9X509            = "zrnyobin9x509";
    public static final String ZRNYOBIN9X510            = "zrnyobin9x510";
    public static final String ZRNYOBIN9X511            = "zrnyobin9x511";
    public static final String ZRNYOBIN9X512            = "zrnyobin9x512";
    public static final String ZRNYOBIN9X513            = "zrnyobin9x513";
    public static final String ZRNYOBIN9X514            = "zrnyobin9x514";
    public static final String ZRNYOBIN9X515            = "zrnyobin9x515";
    public static final String ZRNYOBIN9X516            = "zrnyobin9x516";
    public static final String ZRNYOBIN9X517            = "zrnyobin9x517";
    public static final String ZRNYOBIN9X518            = "zrnyobin9x518";
    public static final String ZRNYOBIN9X519            = "zrnyobin9x519";
    public static final String ZRNYOBIN9X520            = "zrnyobin9x520";
    public static final String ZRNYOBIN9X521            = "zrnyobin9x521";

    private final PKZT_KawaserateRn primaryKey;

    public GenZT_KawaserateRn() {
        primaryKey = new PKZT_KawaserateRn();
    }

    public GenZT_KawaserateRn(String pZrnkwsratekjymd, String pZrnkawaserendoukbn) {
        primaryKey = new PKZT_KawaserateRn(pZrnkwsratekjymd, pZrnkawaserendoukbn);
    }

    @Transient
    @Override
    public PKZT_KawaserateRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KawaserateRn> getMetaClass() {
        return QZT_KawaserateRn.class;
    }

    @Id
    @Column(name=GenZT_KawaserateRn.ZRNKWSRATEKJYMD)
    public String getZrnkwsratekjymd() {
        return getPrimaryKey().getZrnkwsratekjymd();
    }

    public void setZrnkwsratekjymd(String pZrnkwsratekjymd) {
        getPrimaryKey().setZrnkwsratekjymd(pZrnkwsratekjymd);
    }

    @Id
    @Column(name=GenZT_KawaserateRn.ZRNKAWASERENDOUKBN)
    public String getZrnkawaserendoukbn() {
        return getPrimaryKey().getZrnkawaserendoukbn();
    }

    public void setZrnkawaserendoukbn(String pZrnkawaserendoukbn) {
        getPrimaryKey().setZrnkawaserendoukbn(pZrnkawaserendoukbn);
    }

    private String zrnyobiv91;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIV91)
    public String getZrnyobiv91() {
        return zrnyobiv91;
    }

    public void setZrnyobiv91(String pZrnyobiv91) {
        zrnyobiv91 = pZrnyobiv91;
    }

    private Double zrnusdjpytts;

    @Column(name=GenZT_KawaserateRn.ZRNUSDJPYTTS)
    public Double getZrnusdjpytts() {
        return zrnusdjpytts;
    }

    public void setZrnusdjpytts(Double pZrnusdjpytts) {
        zrnusdjpytts = pZrnusdjpytts;
    }

    private Double zrnusdjpyttb;

    @Column(name=GenZT_KawaserateRn.ZRNUSDJPYTTB)
    public Double getZrnusdjpyttb() {
        return zrnusdjpyttb;
    }

    public void setZrnusdjpyttb(Double pZrnusdjpyttb) {
        zrnusdjpyttb = pZrnusdjpyttb;
    }

    private Double zrnusdjpyttm;

    @Column(name=GenZT_KawaserateRn.ZRNUSDJPYTTM)
    public Double getZrnusdjpyttm() {
        return zrnusdjpyttm;
    }

    public void setZrnusdjpyttm(Double pZrnusdjpyttm) {
        zrnusdjpyttm = pZrnusdjpyttm;
    }

    private Double zrneurjpytts;

    @Column(name=GenZT_KawaserateRn.ZRNEURJPYTTS)
    public Double getZrneurjpytts() {
        return zrneurjpytts;
    }

    public void setZrneurjpytts(Double pZrneurjpytts) {
        zrneurjpytts = pZrneurjpytts;
    }

    private Double zrneurjpyttb;

    @Column(name=GenZT_KawaserateRn.ZRNEURJPYTTB)
    public Double getZrneurjpyttb() {
        return zrneurjpyttb;
    }

    public void setZrneurjpyttb(Double pZrneurjpyttb) {
        zrneurjpyttb = pZrneurjpyttb;
    }

    private Double zrneurjpyttm;

    @Column(name=GenZT_KawaserateRn.ZRNEURJPYTTM)
    public Double getZrneurjpyttm() {
        return zrneurjpyttm;
    }

    public void setZrneurjpyttm(Double pZrneurjpyttm) {
        zrneurjpyttm = pZrneurjpyttm;
    }

    private Double zrnaudjpytts;

    @Column(name=GenZT_KawaserateRn.ZRNAUDJPYTTS)
    public Double getZrnaudjpytts() {
        return zrnaudjpytts;
    }

    public void setZrnaudjpytts(Double pZrnaudjpytts) {
        zrnaudjpytts = pZrnaudjpytts;
    }

    private Double zrnaudjpyttb;

    @Column(name=GenZT_KawaserateRn.ZRNAUDJPYTTB)
    public Double getZrnaudjpyttb() {
        return zrnaudjpyttb;
    }

    public void setZrnaudjpyttb(Double pZrnaudjpyttb) {
        zrnaudjpyttb = pZrnaudjpyttb;
    }

    private Double zrnaudjpyttm;

    @Column(name=GenZT_KawaserateRn.ZRNAUDJPYTTM)
    public Double getZrnaudjpyttm() {
        return zrnaudjpyttm;
    }

    public void setZrnaudjpyttm(Double pZrnaudjpyttm) {
        zrnaudjpyttm = pZrnaudjpyttm;
    }

    private Double zrnyobin9;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9)
    public Double getZrnyobin9() {
        return zrnyobin9;
    }

    public void setZrnyobin9(Double pZrnyobin9) {
        zrnyobin9 = pZrnyobin9;
    }

    private Double zrnyobin9x2;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X2)
    public Double getZrnyobin9x2() {
        return zrnyobin9x2;
    }

    public void setZrnyobin9x2(Double pZrnyobin9x2) {
        zrnyobin9x2 = pZrnyobin9x2;
    }

    private Double zrnyobin9x3;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X3)
    public Double getZrnyobin9x3() {
        return zrnyobin9x3;
    }

    public void setZrnyobin9x3(Double pZrnyobin9x3) {
        zrnyobin9x3 = pZrnyobin9x3;
    }

    private Double zrnyobin9x4;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X4)
    public Double getZrnyobin9x4() {
        return zrnyobin9x4;
    }

    public void setZrnyobin9x4(Double pZrnyobin9x4) {
        zrnyobin9x4 = pZrnyobin9x4;
    }

    private Double zrnyobin9x5;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X5)
    public Double getZrnyobin9x5() {
        return zrnyobin9x5;
    }

    public void setZrnyobin9x5(Double pZrnyobin9x5) {
        zrnyobin9x5 = pZrnyobin9x5;
    }

    private Double zrnyobin9x6;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X6)
    public Double getZrnyobin9x6() {
        return zrnyobin9x6;
    }

    public void setZrnyobin9x6(Double pZrnyobin9x6) {
        zrnyobin9x6 = pZrnyobin9x6;
    }

    private Double zrnyobin9x7;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X7)
    public Double getZrnyobin9x7() {
        return zrnyobin9x7;
    }

    public void setZrnyobin9x7(Double pZrnyobin9x7) {
        zrnyobin9x7 = pZrnyobin9x7;
    }

    private Double zrnyobin9x8;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X8)
    public Double getZrnyobin9x8() {
        return zrnyobin9x8;
    }

    public void setZrnyobin9x8(Double pZrnyobin9x8) {
        zrnyobin9x8 = pZrnyobin9x8;
    }

    private Double zrnyobin9x9;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X9)
    public Double getZrnyobin9x9() {
        return zrnyobin9x9;
    }

    public void setZrnyobin9x9(Double pZrnyobin9x9) {
        zrnyobin9x9 = pZrnyobin9x9;
    }

    private Double zrnyobin9x10;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X10)
    public Double getZrnyobin9x10() {
        return zrnyobin9x10;
    }

    public void setZrnyobin9x10(Double pZrnyobin9x10) {
        zrnyobin9x10 = pZrnyobin9x10;
    }

    private Double zrnyobin9x11;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X11)
    public Double getZrnyobin9x11() {
        return zrnyobin9x11;
    }

    public void setZrnyobin9x11(Double pZrnyobin9x11) {
        zrnyobin9x11 = pZrnyobin9x11;
    }

    private Double zrnyobin9x12;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X12)
    public Double getZrnyobin9x12() {
        return zrnyobin9x12;
    }

    public void setZrnyobin9x12(Double pZrnyobin9x12) {
        zrnyobin9x12 = pZrnyobin9x12;
    }

    private Double zrnyobin9x13;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X13)
    public Double getZrnyobin9x13() {
        return zrnyobin9x13;
    }

    public void setZrnyobin9x13(Double pZrnyobin9x13) {
        zrnyobin9x13 = pZrnyobin9x13;
    }

    private Double zrnyobin9x14;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X14)
    public Double getZrnyobin9x14() {
        return zrnyobin9x14;
    }

    public void setZrnyobin9x14(Double pZrnyobin9x14) {
        zrnyobin9x14 = pZrnyobin9x14;
    }

    private Double zrnyobin9x15;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X15)
    public Double getZrnyobin9x15() {
        return zrnyobin9x15;
    }

    public void setZrnyobin9x15(Double pZrnyobin9x15) {
        zrnyobin9x15 = pZrnyobin9x15;
    }

    private Double zrnyobin9x16;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X16)
    public Double getZrnyobin9x16() {
        return zrnyobin9x16;
    }

    public void setZrnyobin9x16(Double pZrnyobin9x16) {
        zrnyobin9x16 = pZrnyobin9x16;
    }

    private Double zrnyobin9x17;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X17)
    public Double getZrnyobin9x17() {
        return zrnyobin9x17;
    }

    public void setZrnyobin9x17(Double pZrnyobin9x17) {
        zrnyobin9x17 = pZrnyobin9x17;
    }

    private Double zrnyobin9x18;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X18)
    public Double getZrnyobin9x18() {
        return zrnyobin9x18;
    }

    public void setZrnyobin9x18(Double pZrnyobin9x18) {
        zrnyobin9x18 = pZrnyobin9x18;
    }

    private Double zrnyobin9x19;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X19)
    public Double getZrnyobin9x19() {
        return zrnyobin9x19;
    }

    public void setZrnyobin9x19(Double pZrnyobin9x19) {
        zrnyobin9x19 = pZrnyobin9x19;
    }

    private Double zrnyobin9x20;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X20)
    public Double getZrnyobin9x20() {
        return zrnyobin9x20;
    }

    public void setZrnyobin9x20(Double pZrnyobin9x20) {
        zrnyobin9x20 = pZrnyobin9x20;
    }

    private Double zrnyobin9x21;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X21)
    public Double getZrnyobin9x21() {
        return zrnyobin9x21;
    }

    public void setZrnyobin9x21(Double pZrnyobin9x21) {
        zrnyobin9x21 = pZrnyobin9x21;
    }

    private Double zrnusdjpynykn;

    @Column(name=GenZT_KawaserateRn.ZRNUSDJPYNYKN)
    public Double getZrnusdjpynykn() {
        return zrnusdjpynykn;
    }

    public void setZrnusdjpynykn(Double pZrnusdjpynykn) {
        zrnusdjpynykn = pZrnusdjpynykn;
    }

    private Double zrneurjpynykn;

    @Column(name=GenZT_KawaserateRn.ZRNEURJPYNYKN)
    public Double getZrneurjpynykn() {
        return zrneurjpynykn;
    }

    public void setZrneurjpynykn(Double pZrneurjpynykn) {
        zrneurjpynykn = pZrneurjpynykn;
    }

    private Double zrnaudjpynykn;

    @Column(name=GenZT_KawaserateRn.ZRNAUDJPYNYKN)
    public Double getZrnaudjpynykn() {
        return zrnaudjpynykn;
    }

    public void setZrnaudjpynykn(Double pZrnaudjpynykn) {
        zrnaudjpynykn = pZrnaudjpynykn;
    }

    private Double zrnyobin9x101;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X101)
    public Double getZrnyobin9x101() {
        return zrnyobin9x101;
    }

    public void setZrnyobin9x101(Double pZrnyobin9x101) {
        zrnyobin9x101 = pZrnyobin9x101;
    }

    private Double zrnyobin9x102;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X102)
    public Double getZrnyobin9x102() {
        return zrnyobin9x102;
    }

    public void setZrnyobin9x102(Double pZrnyobin9x102) {
        zrnyobin9x102 = pZrnyobin9x102;
    }

    private Double zrnyobin9x103;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X103)
    public Double getZrnyobin9x103() {
        return zrnyobin9x103;
    }

    public void setZrnyobin9x103(Double pZrnyobin9x103) {
        zrnyobin9x103 = pZrnyobin9x103;
    }

    private Double zrnyobin9x104;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X104)
    public Double getZrnyobin9x104() {
        return zrnyobin9x104;
    }

    public void setZrnyobin9x104(Double pZrnyobin9x104) {
        zrnyobin9x104 = pZrnyobin9x104;
    }

    private Double zrnyobin9x105;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X105)
    public Double getZrnyobin9x105() {
        return zrnyobin9x105;
    }

    public void setZrnyobin9x105(Double pZrnyobin9x105) {
        zrnyobin9x105 = pZrnyobin9x105;
    }

    private Double zrnyobin9x106;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X106)
    public Double getZrnyobin9x106() {
        return zrnyobin9x106;
    }

    public void setZrnyobin9x106(Double pZrnyobin9x106) {
        zrnyobin9x106 = pZrnyobin9x106;
    }

    private Double zrnyobin9x107;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X107)
    public Double getZrnyobin9x107() {
        return zrnyobin9x107;
    }

    public void setZrnyobin9x107(Double pZrnyobin9x107) {
        zrnyobin9x107 = pZrnyobin9x107;
    }

    private Double zrnusdeurnykn;

    @Column(name=GenZT_KawaserateRn.ZRNUSDEURNYKN)
    public Double getZrnusdeurnykn() {
        return zrnusdeurnykn;
    }

    public void setZrnusdeurnykn(Double pZrnusdeurnykn) {
        zrnusdeurnykn = pZrnusdeurnykn;
    }

    private Double zrnusdaudnykn;

    @Column(name=GenZT_KawaserateRn.ZRNUSDAUDNYKN)
    public Double getZrnusdaudnykn() {
        return zrnusdaudnykn;
    }

    public void setZrnusdaudnykn(Double pZrnusdaudnykn) {
        zrnusdaudnykn = pZrnusdaudnykn;
    }

    private Double zrnyobin9x111;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X111)
    public Double getZrnyobin9x111() {
        return zrnyobin9x111;
    }

    public void setZrnyobin9x111(Double pZrnyobin9x111) {
        zrnyobin9x111 = pZrnyobin9x111;
    }

    private Double zrnyobin9x112;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X112)
    public Double getZrnyobin9x112() {
        return zrnyobin9x112;
    }

    public void setZrnyobin9x112(Double pZrnyobin9x112) {
        zrnyobin9x112 = pZrnyobin9x112;
    }

    private Double zrnyobin9x113;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X113)
    public Double getZrnyobin9x113() {
        return zrnyobin9x113;
    }

    public void setZrnyobin9x113(Double pZrnyobin9x113) {
        zrnyobin9x113 = pZrnyobin9x113;
    }

    private Double zrnyobin9x114;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X114)
    public Double getZrnyobin9x114() {
        return zrnyobin9x114;
    }

    public void setZrnyobin9x114(Double pZrnyobin9x114) {
        zrnyobin9x114 = pZrnyobin9x114;
    }

    private Double zrnyobin9x115;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X115)
    public Double getZrnyobin9x115() {
        return zrnyobin9x115;
    }

    public void setZrnyobin9x115(Double pZrnyobin9x115) {
        zrnyobin9x115 = pZrnyobin9x115;
    }

    private Double zrnyobin9x116;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X116)
    public Double getZrnyobin9x116() {
        return zrnyobin9x116;
    }

    public void setZrnyobin9x116(Double pZrnyobin9x116) {
        zrnyobin9x116 = pZrnyobin9x116;
    }

    private Double zrnyobin9x117;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X117)
    public Double getZrnyobin9x117() {
        return zrnyobin9x117;
    }

    public void setZrnyobin9x117(Double pZrnyobin9x117) {
        zrnyobin9x117 = pZrnyobin9x117;
    }

    private Double zrneurusdnykn;

    @Column(name=GenZT_KawaserateRn.ZRNEURUSDNYKN)
    public Double getZrneurusdnykn() {
        return zrneurusdnykn;
    }

    public void setZrneurusdnykn(Double pZrneurusdnykn) {
        zrneurusdnykn = pZrneurusdnykn;
    }

    private Double zrneuraudnykn;

    @Column(name=GenZT_KawaserateRn.ZRNEURAUDNYKN)
    public Double getZrneuraudnykn() {
        return zrneuraudnykn;
    }

    public void setZrneuraudnykn(Double pZrneuraudnykn) {
        zrneuraudnykn = pZrneuraudnykn;
    }

    private Double zrnyobin9x121;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X121)
    public Double getZrnyobin9x121() {
        return zrnyobin9x121;
    }

    public void setZrnyobin9x121(Double pZrnyobin9x121) {
        zrnyobin9x121 = pZrnyobin9x121;
    }

    private Double zrnyobin9x122;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X122)
    public Double getZrnyobin9x122() {
        return zrnyobin9x122;
    }

    public void setZrnyobin9x122(Double pZrnyobin9x122) {
        zrnyobin9x122 = pZrnyobin9x122;
    }

    private Double zrnyobin9x123;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X123)
    public Double getZrnyobin9x123() {
        return zrnyobin9x123;
    }

    public void setZrnyobin9x123(Double pZrnyobin9x123) {
        zrnyobin9x123 = pZrnyobin9x123;
    }

    private Double zrnyobin9x124;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X124)
    public Double getZrnyobin9x124() {
        return zrnyobin9x124;
    }

    public void setZrnyobin9x124(Double pZrnyobin9x124) {
        zrnyobin9x124 = pZrnyobin9x124;
    }

    private Double zrnyobin9x125;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X125)
    public Double getZrnyobin9x125() {
        return zrnyobin9x125;
    }

    public void setZrnyobin9x125(Double pZrnyobin9x125) {
        zrnyobin9x125 = pZrnyobin9x125;
    }

    private Double zrnyobin9x126;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X126)
    public Double getZrnyobin9x126() {
        return zrnyobin9x126;
    }

    public void setZrnyobin9x126(Double pZrnyobin9x126) {
        zrnyobin9x126 = pZrnyobin9x126;
    }

    private Double zrnyobin9x127;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X127)
    public Double getZrnyobin9x127() {
        return zrnyobin9x127;
    }

    public void setZrnyobin9x127(Double pZrnyobin9x127) {
        zrnyobin9x127 = pZrnyobin9x127;
    }

    private Double zrnaudusenykn;

    @Column(name=GenZT_KawaserateRn.ZRNAUDUSENYKN)
    public Double getZrnaudusenykn() {
        return zrnaudusenykn;
    }

    public void setZrnaudusenykn(Double pZrnaudusenykn) {
        zrnaudusenykn = pZrnaudusenykn;
    }

    private Double zrnaudeurnykn;

    @Column(name=GenZT_KawaserateRn.ZRNAUDEURNYKN)
    public Double getZrnaudeurnykn() {
        return zrnaudeurnykn;
    }

    public void setZrnaudeurnykn(Double pZrnaudeurnykn) {
        zrnaudeurnykn = pZrnaudeurnykn;
    }

    private Double zrnyobin9x131;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X131)
    public Double getZrnyobin9x131() {
        return zrnyobin9x131;
    }

    public void setZrnyobin9x131(Double pZrnyobin9x131) {
        zrnyobin9x131 = pZrnyobin9x131;
    }

    private Double zrnyobin9x132;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X132)
    public Double getZrnyobin9x132() {
        return zrnyobin9x132;
    }

    public void setZrnyobin9x132(Double pZrnyobin9x132) {
        zrnyobin9x132 = pZrnyobin9x132;
    }

    private Double zrnyobin9x133;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X133)
    public Double getZrnyobin9x133() {
        return zrnyobin9x133;
    }

    public void setZrnyobin9x133(Double pZrnyobin9x133) {
        zrnyobin9x133 = pZrnyobin9x133;
    }

    private Double zrnyobin9x134;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X134)
    public Double getZrnyobin9x134() {
        return zrnyobin9x134;
    }

    public void setZrnyobin9x134(Double pZrnyobin9x134) {
        zrnyobin9x134 = pZrnyobin9x134;
    }

    private Double zrnyobin9x135;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X135)
    public Double getZrnyobin9x135() {
        return zrnyobin9x135;
    }

    public void setZrnyobin9x135(Double pZrnyobin9x135) {
        zrnyobin9x135 = pZrnyobin9x135;
    }

    private Double zrnyobin9x136;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X136)
    public Double getZrnyobin9x136() {
        return zrnyobin9x136;
    }

    public void setZrnyobin9x136(Double pZrnyobin9x136) {
        zrnyobin9x136 = pZrnyobin9x136;
    }

    private Double zrnyobin9x137;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X137)
    public Double getZrnyobin9x137() {
        return zrnyobin9x137;
    }

    public void setZrnyobin9x137(Double pZrnyobin9x137) {
        zrnyobin9x137 = pZrnyobin9x137;
    }

    private Double zrnyobin9x141;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X141)
    public Double getZrnyobin9x141() {
        return zrnyobin9x141;
    }

    public void setZrnyobin9x141(Double pZrnyobin9x141) {
        zrnyobin9x141 = pZrnyobin9x141;
    }

    private Double zrnyobin9x142;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X142)
    public Double getZrnyobin9x142() {
        return zrnyobin9x142;
    }

    public void setZrnyobin9x142(Double pZrnyobin9x142) {
        zrnyobin9x142 = pZrnyobin9x142;
    }

    private Double zrnyobin9x143;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X143)
    public Double getZrnyobin9x143() {
        return zrnyobin9x143;
    }

    public void setZrnyobin9x143(Double pZrnyobin9x143) {
        zrnyobin9x143 = pZrnyobin9x143;
    }

    private Double zrnyobin9x144;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X144)
    public Double getZrnyobin9x144() {
        return zrnyobin9x144;
    }

    public void setZrnyobin9x144(Double pZrnyobin9x144) {
        zrnyobin9x144 = pZrnyobin9x144;
    }

    private Double zrnyobin9x145;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X145)
    public Double getZrnyobin9x145() {
        return zrnyobin9x145;
    }

    public void setZrnyobin9x145(Double pZrnyobin9x145) {
        zrnyobin9x145 = pZrnyobin9x145;
    }

    private Double zrnyobin9x146;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X146)
    public Double getZrnyobin9x146() {
        return zrnyobin9x146;
    }

    public void setZrnyobin9x146(Double pZrnyobin9x146) {
        zrnyobin9x146 = pZrnyobin9x146;
    }

    private Double zrnyobin9x147;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X147)
    public Double getZrnyobin9x147() {
        return zrnyobin9x147;
    }

    public void setZrnyobin9x147(Double pZrnyobin9x147) {
        zrnyobin9x147 = pZrnyobin9x147;
    }

    private Double zrnyobin9x148;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X148)
    public Double getZrnyobin9x148() {
        return zrnyobin9x148;
    }

    public void setZrnyobin9x148(Double pZrnyobin9x148) {
        zrnyobin9x148 = pZrnyobin9x148;
    }

    private Double zrnyobin9x149;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X149)
    public Double getZrnyobin9x149() {
        return zrnyobin9x149;
    }

    public void setZrnyobin9x149(Double pZrnyobin9x149) {
        zrnyobin9x149 = pZrnyobin9x149;
    }

    private Double zrnyobin9x151;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X151)
    public Double getZrnyobin9x151() {
        return zrnyobin9x151;
    }

    public void setZrnyobin9x151(Double pZrnyobin9x151) {
        zrnyobin9x151 = pZrnyobin9x151;
    }

    private Double zrnyobin9x152;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X152)
    public Double getZrnyobin9x152() {
        return zrnyobin9x152;
    }

    public void setZrnyobin9x152(Double pZrnyobin9x152) {
        zrnyobin9x152 = pZrnyobin9x152;
    }

    private Double zrnyobin9x153;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X153)
    public Double getZrnyobin9x153() {
        return zrnyobin9x153;
    }

    public void setZrnyobin9x153(Double pZrnyobin9x153) {
        zrnyobin9x153 = pZrnyobin9x153;
    }

    private Double zrnyobin9x154;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X154)
    public Double getZrnyobin9x154() {
        return zrnyobin9x154;
    }

    public void setZrnyobin9x154(Double pZrnyobin9x154) {
        zrnyobin9x154 = pZrnyobin9x154;
    }

    private Double zrnyobin9x155;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X155)
    public Double getZrnyobin9x155() {
        return zrnyobin9x155;
    }

    public void setZrnyobin9x155(Double pZrnyobin9x155) {
        zrnyobin9x155 = pZrnyobin9x155;
    }

    private Double zrnyobin9x156;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X156)
    public Double getZrnyobin9x156() {
        return zrnyobin9x156;
    }

    public void setZrnyobin9x156(Double pZrnyobin9x156) {
        zrnyobin9x156 = pZrnyobin9x156;
    }

    private Double zrnyobin9x157;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X157)
    public Double getZrnyobin9x157() {
        return zrnyobin9x157;
    }

    public void setZrnyobin9x157(Double pZrnyobin9x157) {
        zrnyobin9x157 = pZrnyobin9x157;
    }

    private Double zrnyobin9x158;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X158)
    public Double getZrnyobin9x158() {
        return zrnyobin9x158;
    }

    public void setZrnyobin9x158(Double pZrnyobin9x158) {
        zrnyobin9x158 = pZrnyobin9x158;
    }

    private Double zrnyobin9x159;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X159)
    public Double getZrnyobin9x159() {
        return zrnyobin9x159;
    }

    public void setZrnyobin9x159(Double pZrnyobin9x159) {
        zrnyobin9x159 = pZrnyobin9x159;
    }

    private Double zrnyobin9x161;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X161)
    public Double getZrnyobin9x161() {
        return zrnyobin9x161;
    }

    public void setZrnyobin9x161(Double pZrnyobin9x161) {
        zrnyobin9x161 = pZrnyobin9x161;
    }

    private Double zrnyobin9x162;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X162)
    public Double getZrnyobin9x162() {
        return zrnyobin9x162;
    }

    public void setZrnyobin9x162(Double pZrnyobin9x162) {
        zrnyobin9x162 = pZrnyobin9x162;
    }

    private Double zrnyobin9x163;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X163)
    public Double getZrnyobin9x163() {
        return zrnyobin9x163;
    }

    public void setZrnyobin9x163(Double pZrnyobin9x163) {
        zrnyobin9x163 = pZrnyobin9x163;
    }

    private Double zrnyobin9x164;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X164)
    public Double getZrnyobin9x164() {
        return zrnyobin9x164;
    }

    public void setZrnyobin9x164(Double pZrnyobin9x164) {
        zrnyobin9x164 = pZrnyobin9x164;
    }

    private Double zrnyobin9x165;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X165)
    public Double getZrnyobin9x165() {
        return zrnyobin9x165;
    }

    public void setZrnyobin9x165(Double pZrnyobin9x165) {
        zrnyobin9x165 = pZrnyobin9x165;
    }

    private Double zrnyobin9x166;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X166)
    public Double getZrnyobin9x166() {
        return zrnyobin9x166;
    }

    public void setZrnyobin9x166(Double pZrnyobin9x166) {
        zrnyobin9x166 = pZrnyobin9x166;
    }

    private Double zrnyobin9x167;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X167)
    public Double getZrnyobin9x167() {
        return zrnyobin9x167;
    }

    public void setZrnyobin9x167(Double pZrnyobin9x167) {
        zrnyobin9x167 = pZrnyobin9x167;
    }

    private Double zrnyobin9x168;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X168)
    public Double getZrnyobin9x168() {
        return zrnyobin9x168;
    }

    public void setZrnyobin9x168(Double pZrnyobin9x168) {
        zrnyobin9x168 = pZrnyobin9x168;
    }

    private Double zrnyobin9x169;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X169)
    public Double getZrnyobin9x169() {
        return zrnyobin9x169;
    }

    public void setZrnyobin9x169(Double pZrnyobin9x169) {
        zrnyobin9x169 = pZrnyobin9x169;
    }

    private Double zrnyobin9x171;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X171)
    public Double getZrnyobin9x171() {
        return zrnyobin9x171;
    }

    public void setZrnyobin9x171(Double pZrnyobin9x171) {
        zrnyobin9x171 = pZrnyobin9x171;
    }

    private Double zrnyobin9x172;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X172)
    public Double getZrnyobin9x172() {
        return zrnyobin9x172;
    }

    public void setZrnyobin9x172(Double pZrnyobin9x172) {
        zrnyobin9x172 = pZrnyobin9x172;
    }

    private Double zrnyobin9x173;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X173)
    public Double getZrnyobin9x173() {
        return zrnyobin9x173;
    }

    public void setZrnyobin9x173(Double pZrnyobin9x173) {
        zrnyobin9x173 = pZrnyobin9x173;
    }

    private Double zrnyobin9x174;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X174)
    public Double getZrnyobin9x174() {
        return zrnyobin9x174;
    }

    public void setZrnyobin9x174(Double pZrnyobin9x174) {
        zrnyobin9x174 = pZrnyobin9x174;
    }

    private Double zrnyobin9x175;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X175)
    public Double getZrnyobin9x175() {
        return zrnyobin9x175;
    }

    public void setZrnyobin9x175(Double pZrnyobin9x175) {
        zrnyobin9x175 = pZrnyobin9x175;
    }

    private Double zrnyobin9x176;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X176)
    public Double getZrnyobin9x176() {
        return zrnyobin9x176;
    }

    public void setZrnyobin9x176(Double pZrnyobin9x176) {
        zrnyobin9x176 = pZrnyobin9x176;
    }

    private Double zrnyobin9x177;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X177)
    public Double getZrnyobin9x177() {
        return zrnyobin9x177;
    }

    public void setZrnyobin9x177(Double pZrnyobin9x177) {
        zrnyobin9x177 = pZrnyobin9x177;
    }

    private Double zrnyobin9x178;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X178)
    public Double getZrnyobin9x178() {
        return zrnyobin9x178;
    }

    public void setZrnyobin9x178(Double pZrnyobin9x178) {
        zrnyobin9x178 = pZrnyobin9x178;
    }

    private Double zrnyobin9x179;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X179)
    public Double getZrnyobin9x179() {
        return zrnyobin9x179;
    }

    public void setZrnyobin9x179(Double pZrnyobin9x179) {
        zrnyobin9x179 = pZrnyobin9x179;
    }

    private Double zrnyobin9x181;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X181)
    public Double getZrnyobin9x181() {
        return zrnyobin9x181;
    }

    public void setZrnyobin9x181(Double pZrnyobin9x181) {
        zrnyobin9x181 = pZrnyobin9x181;
    }

    private Double zrnyobin9x182;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X182)
    public Double getZrnyobin9x182() {
        return zrnyobin9x182;
    }

    public void setZrnyobin9x182(Double pZrnyobin9x182) {
        zrnyobin9x182 = pZrnyobin9x182;
    }

    private Double zrnyobin9x183;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X183)
    public Double getZrnyobin9x183() {
        return zrnyobin9x183;
    }

    public void setZrnyobin9x183(Double pZrnyobin9x183) {
        zrnyobin9x183 = pZrnyobin9x183;
    }

    private Double zrnyobin9x184;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X184)
    public Double getZrnyobin9x184() {
        return zrnyobin9x184;
    }

    public void setZrnyobin9x184(Double pZrnyobin9x184) {
        zrnyobin9x184 = pZrnyobin9x184;
    }

    private Double zrnyobin9x185;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X185)
    public Double getZrnyobin9x185() {
        return zrnyobin9x185;
    }

    public void setZrnyobin9x185(Double pZrnyobin9x185) {
        zrnyobin9x185 = pZrnyobin9x185;
    }

    private Double zrnyobin9x186;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X186)
    public Double getZrnyobin9x186() {
        return zrnyobin9x186;
    }

    public void setZrnyobin9x186(Double pZrnyobin9x186) {
        zrnyobin9x186 = pZrnyobin9x186;
    }

    private Double zrnyobin9x187;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X187)
    public Double getZrnyobin9x187() {
        return zrnyobin9x187;
    }

    public void setZrnyobin9x187(Double pZrnyobin9x187) {
        zrnyobin9x187 = pZrnyobin9x187;
    }

    private Double zrnyobin9x188;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X188)
    public Double getZrnyobin9x188() {
        return zrnyobin9x188;
    }

    public void setZrnyobin9x188(Double pZrnyobin9x188) {
        zrnyobin9x188 = pZrnyobin9x188;
    }

    private Double zrnyobin9x189;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X189)
    public Double getZrnyobin9x189() {
        return zrnyobin9x189;
    }

    public void setZrnyobin9x189(Double pZrnyobin9x189) {
        zrnyobin9x189 = pZrnyobin9x189;
    }

    private Double zrnyobin9x191;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X191)
    public Double getZrnyobin9x191() {
        return zrnyobin9x191;
    }

    public void setZrnyobin9x191(Double pZrnyobin9x191) {
        zrnyobin9x191 = pZrnyobin9x191;
    }

    private Double zrnyobin9x192;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X192)
    public Double getZrnyobin9x192() {
        return zrnyobin9x192;
    }

    public void setZrnyobin9x192(Double pZrnyobin9x192) {
        zrnyobin9x192 = pZrnyobin9x192;
    }

    private Double zrnyobin9x193;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X193)
    public Double getZrnyobin9x193() {
        return zrnyobin9x193;
    }

    public void setZrnyobin9x193(Double pZrnyobin9x193) {
        zrnyobin9x193 = pZrnyobin9x193;
    }

    private Double zrnyobin9x194;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X194)
    public Double getZrnyobin9x194() {
        return zrnyobin9x194;
    }

    public void setZrnyobin9x194(Double pZrnyobin9x194) {
        zrnyobin9x194 = pZrnyobin9x194;
    }

    private Double zrnyobin9x195;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X195)
    public Double getZrnyobin9x195() {
        return zrnyobin9x195;
    }

    public void setZrnyobin9x195(Double pZrnyobin9x195) {
        zrnyobin9x195 = pZrnyobin9x195;
    }

    private Double zrnyobin9x196;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X196)
    public Double getZrnyobin9x196() {
        return zrnyobin9x196;
    }

    public void setZrnyobin9x196(Double pZrnyobin9x196) {
        zrnyobin9x196 = pZrnyobin9x196;
    }

    private Double zrnyobin9x197;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X197)
    public Double getZrnyobin9x197() {
        return zrnyobin9x197;
    }

    public void setZrnyobin9x197(Double pZrnyobin9x197) {
        zrnyobin9x197 = pZrnyobin9x197;
    }

    private Double zrnyobin9x198;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X198)
    public Double getZrnyobin9x198() {
        return zrnyobin9x198;
    }

    public void setZrnyobin9x198(Double pZrnyobin9x198) {
        zrnyobin9x198 = pZrnyobin9x198;
    }

    private Double zrnyobin9x199;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X199)
    public Double getZrnyobin9x199() {
        return zrnyobin9x199;
    }

    public void setZrnyobin9x199(Double pZrnyobin9x199) {
        zrnyobin9x199 = pZrnyobin9x199;
    }

    private Double zrnyobin9x201;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X201)
    public Double getZrnyobin9x201() {
        return zrnyobin9x201;
    }

    public void setZrnyobin9x201(Double pZrnyobin9x201) {
        zrnyobin9x201 = pZrnyobin9x201;
    }

    private Double zrnyobin9x202;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X202)
    public Double getZrnyobin9x202() {
        return zrnyobin9x202;
    }

    public void setZrnyobin9x202(Double pZrnyobin9x202) {
        zrnyobin9x202 = pZrnyobin9x202;
    }

    private Double zrnyobin9x203;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X203)
    public Double getZrnyobin9x203() {
        return zrnyobin9x203;
    }

    public void setZrnyobin9x203(Double pZrnyobin9x203) {
        zrnyobin9x203 = pZrnyobin9x203;
    }

    private Double zrnyobin9x204;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X204)
    public Double getZrnyobin9x204() {
        return zrnyobin9x204;
    }

    public void setZrnyobin9x204(Double pZrnyobin9x204) {
        zrnyobin9x204 = pZrnyobin9x204;
    }

    private Double zrnyobin9x205;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X205)
    public Double getZrnyobin9x205() {
        return zrnyobin9x205;
    }

    public void setZrnyobin9x205(Double pZrnyobin9x205) {
        zrnyobin9x205 = pZrnyobin9x205;
    }

    private Double zrnyobin9x206;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X206)
    public Double getZrnyobin9x206() {
        return zrnyobin9x206;
    }

    public void setZrnyobin9x206(Double pZrnyobin9x206) {
        zrnyobin9x206 = pZrnyobin9x206;
    }

    private Double zrnyobin9x207;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X207)
    public Double getZrnyobin9x207() {
        return zrnyobin9x207;
    }

    public void setZrnyobin9x207(Double pZrnyobin9x207) {
        zrnyobin9x207 = pZrnyobin9x207;
    }

    private Double zrnyobin9x208;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X208)
    public Double getZrnyobin9x208() {
        return zrnyobin9x208;
    }

    public void setZrnyobin9x208(Double pZrnyobin9x208) {
        zrnyobin9x208 = pZrnyobin9x208;
    }

    private Double zrnyobin9x209;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X209)
    public Double getZrnyobin9x209() {
        return zrnyobin9x209;
    }

    public void setZrnyobin9x209(Double pZrnyobin9x209) {
        zrnyobin9x209 = pZrnyobin9x209;
    }

    private Double zrnusdjpysykn;

    @Column(name=GenZT_KawaserateRn.ZRNUSDJPYSYKN)
    public Double getZrnusdjpysykn() {
        return zrnusdjpysykn;
    }

    public void setZrnusdjpysykn(Double pZrnusdjpysykn) {
        zrnusdjpysykn = pZrnusdjpysykn;
    }

    private Double zrneurjpysykn;

    @Column(name=GenZT_KawaserateRn.ZRNEURJPYSYKN)
    public Double getZrneurjpysykn() {
        return zrneurjpysykn;
    }

    public void setZrneurjpysykn(Double pZrneurjpysykn) {
        zrneurjpysykn = pZrneurjpysykn;
    }

    private Double zrnaudjpysykn;

    @Column(name=GenZT_KawaserateRn.ZRNAUDJPYSYKN)
    public Double getZrnaudjpysykn() {
        return zrnaudjpysykn;
    }

    public void setZrnaudjpysykn(Double pZrnaudjpysykn) {
        zrnaudjpysykn = pZrnaudjpysykn;
    }

    private Double zrnyobin9x301;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X301)
    public Double getZrnyobin9x301() {
        return zrnyobin9x301;
    }

    public void setZrnyobin9x301(Double pZrnyobin9x301) {
        zrnyobin9x301 = pZrnyobin9x301;
    }

    private Double zrnyobin9x302;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X302)
    public Double getZrnyobin9x302() {
        return zrnyobin9x302;
    }

    public void setZrnyobin9x302(Double pZrnyobin9x302) {
        zrnyobin9x302 = pZrnyobin9x302;
    }

    private Double zrnyobin9x303;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X303)
    public Double getZrnyobin9x303() {
        return zrnyobin9x303;
    }

    public void setZrnyobin9x303(Double pZrnyobin9x303) {
        zrnyobin9x303 = pZrnyobin9x303;
    }

    private Double zrnyobin9x304;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X304)
    public Double getZrnyobin9x304() {
        return zrnyobin9x304;
    }

    public void setZrnyobin9x304(Double pZrnyobin9x304) {
        zrnyobin9x304 = pZrnyobin9x304;
    }

    private Double zrnyobin9x305;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X305)
    public Double getZrnyobin9x305() {
        return zrnyobin9x305;
    }

    public void setZrnyobin9x305(Double pZrnyobin9x305) {
        zrnyobin9x305 = pZrnyobin9x305;
    }

    private Double zrnyobin9x306;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X306)
    public Double getZrnyobin9x306() {
        return zrnyobin9x306;
    }

    public void setZrnyobin9x306(Double pZrnyobin9x306) {
        zrnyobin9x306 = pZrnyobin9x306;
    }

    private Double zrnyobin9x307;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X307)
    public Double getZrnyobin9x307() {
        return zrnyobin9x307;
    }

    public void setZrnyobin9x307(Double pZrnyobin9x307) {
        zrnyobin9x307 = pZrnyobin9x307;
    }

    private Double zrnusdjpytts17pm;

    @Column(name=GenZT_KawaserateRn.ZRNUSDJPYTTS17PM)
    public Double getZrnusdjpytts17pm() {
        return zrnusdjpytts17pm;
    }

    public void setZrnusdjpytts17pm(Double pZrnusdjpytts17pm) {
        zrnusdjpytts17pm = pZrnusdjpytts17pm;
    }

    private Double zrnusdjpyttb17pm;

    @Column(name=GenZT_KawaserateRn.ZRNUSDJPYTTB17PM)
    public Double getZrnusdjpyttb17pm() {
        return zrnusdjpyttb17pm;
    }

    public void setZrnusdjpyttb17pm(Double pZrnusdjpyttb17pm) {
        zrnusdjpyttb17pm = pZrnusdjpyttb17pm;
    }

    private Double zrnusdjpyttm17pm;

    @Column(name=GenZT_KawaserateRn.ZRNUSDJPYTTM17PM)
    public Double getZrnusdjpyttm17pm() {
        return zrnusdjpyttm17pm;
    }

    public void setZrnusdjpyttm17pm(Double pZrnusdjpyttm17pm) {
        zrnusdjpyttm17pm = pZrnusdjpyttm17pm;
    }

    private Double zrneurjpytts17pm;

    @Column(name=GenZT_KawaserateRn.ZRNEURJPYTTS17PM)
    public Double getZrneurjpytts17pm() {
        return zrneurjpytts17pm;
    }

    public void setZrneurjpytts17pm(Double pZrneurjpytts17pm) {
        zrneurjpytts17pm = pZrneurjpytts17pm;
    }

    private Double zrneurjpyttb17pm;

    @Column(name=GenZT_KawaserateRn.ZRNEURJPYTTB17PM)
    public Double getZrneurjpyttb17pm() {
        return zrneurjpyttb17pm;
    }

    public void setZrneurjpyttb17pm(Double pZrneurjpyttb17pm) {
        zrneurjpyttb17pm = pZrneurjpyttb17pm;
    }

    private Double zrneurjpyttm17pm;

    @Column(name=GenZT_KawaserateRn.ZRNEURJPYTTM17PM)
    public Double getZrneurjpyttm17pm() {
        return zrneurjpyttm17pm;
    }

    public void setZrneurjpyttm17pm(Double pZrneurjpyttm17pm) {
        zrneurjpyttm17pm = pZrneurjpyttm17pm;
    }

    private Double zrnaudjpytts17pm;

    @Column(name=GenZT_KawaserateRn.ZRNAUDJPYTTS17PM)
    public Double getZrnaudjpytts17pm() {
        return zrnaudjpytts17pm;
    }

    public void setZrnaudjpytts17pm(Double pZrnaudjpytts17pm) {
        zrnaudjpytts17pm = pZrnaudjpytts17pm;
    }

    private Double zrnaudjpyttb17pm;

    @Column(name=GenZT_KawaserateRn.ZRNAUDJPYTTB17PM)
    public Double getZrnaudjpyttb17pm() {
        return zrnaudjpyttb17pm;
    }

    public void setZrnaudjpyttb17pm(Double pZrnaudjpyttb17pm) {
        zrnaudjpyttb17pm = pZrnaudjpyttb17pm;
    }

    private Double zrnaudjpyttm17pm;

    @Column(name=GenZT_KawaserateRn.ZRNAUDJPYTTM17PM)
    public Double getZrnaudjpyttm17pm() {
        return zrnaudjpyttm17pm;
    }

    public void setZrnaudjpyttm17pm(Double pZrnaudjpyttm17pm) {
        zrnaudjpyttm17pm = pZrnaudjpyttm17pm;
    }

    private Double zrnyobin9x501;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X501)
    public Double getZrnyobin9x501() {
        return zrnyobin9x501;
    }

    public void setZrnyobin9x501(Double pZrnyobin9x501) {
        zrnyobin9x501 = pZrnyobin9x501;
    }

    private Double zrnyobin9x502;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X502)
    public Double getZrnyobin9x502() {
        return zrnyobin9x502;
    }

    public void setZrnyobin9x502(Double pZrnyobin9x502) {
        zrnyobin9x502 = pZrnyobin9x502;
    }

    private Double zrnyobin9x503;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X503)
    public Double getZrnyobin9x503() {
        return zrnyobin9x503;
    }

    public void setZrnyobin9x503(Double pZrnyobin9x503) {
        zrnyobin9x503 = pZrnyobin9x503;
    }

    private Double zrnyobin9x504;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X504)
    public Double getZrnyobin9x504() {
        return zrnyobin9x504;
    }

    public void setZrnyobin9x504(Double pZrnyobin9x504) {
        zrnyobin9x504 = pZrnyobin9x504;
    }

    private Double zrnyobin9x505;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X505)
    public Double getZrnyobin9x505() {
        return zrnyobin9x505;
    }

    public void setZrnyobin9x505(Double pZrnyobin9x505) {
        zrnyobin9x505 = pZrnyobin9x505;
    }

    private Double zrnyobin9x506;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X506)
    public Double getZrnyobin9x506() {
        return zrnyobin9x506;
    }

    public void setZrnyobin9x506(Double pZrnyobin9x506) {
        zrnyobin9x506 = pZrnyobin9x506;
    }

    private Double zrnyobin9x507;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X507)
    public Double getZrnyobin9x507() {
        return zrnyobin9x507;
    }

    public void setZrnyobin9x507(Double pZrnyobin9x507) {
        zrnyobin9x507 = pZrnyobin9x507;
    }

    private Double zrnyobin9x508;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X508)
    public Double getZrnyobin9x508() {
        return zrnyobin9x508;
    }

    public void setZrnyobin9x508(Double pZrnyobin9x508) {
        zrnyobin9x508 = pZrnyobin9x508;
    }

    private Double zrnyobin9x509;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X509)
    public Double getZrnyobin9x509() {
        return zrnyobin9x509;
    }

    public void setZrnyobin9x509(Double pZrnyobin9x509) {
        zrnyobin9x509 = pZrnyobin9x509;
    }

    private Double zrnyobin9x510;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X510)
    public Double getZrnyobin9x510() {
        return zrnyobin9x510;
    }

    public void setZrnyobin9x510(Double pZrnyobin9x510) {
        zrnyobin9x510 = pZrnyobin9x510;
    }

    private Double zrnyobin9x511;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X511)
    public Double getZrnyobin9x511() {
        return zrnyobin9x511;
    }

    public void setZrnyobin9x511(Double pZrnyobin9x511) {
        zrnyobin9x511 = pZrnyobin9x511;
    }

    private Double zrnyobin9x512;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X512)
    public Double getZrnyobin9x512() {
        return zrnyobin9x512;
    }

    public void setZrnyobin9x512(Double pZrnyobin9x512) {
        zrnyobin9x512 = pZrnyobin9x512;
    }

    private Double zrnyobin9x513;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X513)
    public Double getZrnyobin9x513() {
        return zrnyobin9x513;
    }

    public void setZrnyobin9x513(Double pZrnyobin9x513) {
        zrnyobin9x513 = pZrnyobin9x513;
    }

    private Double zrnyobin9x514;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X514)
    public Double getZrnyobin9x514() {
        return zrnyobin9x514;
    }

    public void setZrnyobin9x514(Double pZrnyobin9x514) {
        zrnyobin9x514 = pZrnyobin9x514;
    }

    private Double zrnyobin9x515;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X515)
    public Double getZrnyobin9x515() {
        return zrnyobin9x515;
    }

    public void setZrnyobin9x515(Double pZrnyobin9x515) {
        zrnyobin9x515 = pZrnyobin9x515;
    }

    private Double zrnyobin9x516;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X516)
    public Double getZrnyobin9x516() {
        return zrnyobin9x516;
    }

    public void setZrnyobin9x516(Double pZrnyobin9x516) {
        zrnyobin9x516 = pZrnyobin9x516;
    }

    private Double zrnyobin9x517;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X517)
    public Double getZrnyobin9x517() {
        return zrnyobin9x517;
    }

    public void setZrnyobin9x517(Double pZrnyobin9x517) {
        zrnyobin9x517 = pZrnyobin9x517;
    }

    private Double zrnyobin9x518;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X518)
    public Double getZrnyobin9x518() {
        return zrnyobin9x518;
    }

    public void setZrnyobin9x518(Double pZrnyobin9x518) {
        zrnyobin9x518 = pZrnyobin9x518;
    }

    private Double zrnyobin9x519;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X519)
    public Double getZrnyobin9x519() {
        return zrnyobin9x519;
    }

    public void setZrnyobin9x519(Double pZrnyobin9x519) {
        zrnyobin9x519 = pZrnyobin9x519;
    }

    private Double zrnyobin9x520;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X520)
    public Double getZrnyobin9x520() {
        return zrnyobin9x520;
    }

    public void setZrnyobin9x520(Double pZrnyobin9x520) {
        zrnyobin9x520 = pZrnyobin9x520;
    }

    private Double zrnyobin9x521;

    @Column(name=GenZT_KawaserateRn.ZRNYOBIN9X521)
    public Double getZrnyobin9x521() {
        return zrnyobin9x521;
    }

    public void setZrnyobin9x521(Double pZrnyobin9x521) {
        zrnyobin9x521 = pZrnyobin9x521;
    }
}