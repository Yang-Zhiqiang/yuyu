package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KawaserateRn;
import yuyu.def.db.mapping.GenZT_KawaserateRn;
import yuyu.def.db.meta.GenQZT_KawaserateRn;
import yuyu.def.db.meta.QZT_KawaserateRn;

/**
 * 為替レートテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KawaserateRn}</td><td colspan="3">為替レートテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkwsratekjymd zrnkwsratekjymd}</td><td>（連携用）為替レート基準日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkawaserendoukbn zrnkawaserendoukbn}</td><td>（連携用）為替レート連動区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv91</td><td>（連携用）予備項目Ｖ９１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnusdjpytts</td><td>（連携用）米ドル－円（ＴＴＳ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnusdjpyttb</td><td>（連携用）米ドル－円（ＴＴＢ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnusdjpyttm</td><td>（連携用）米ドル－円（ＴＴＭ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrneurjpytts</td><td>（連携用）ユーロ－円（ＴＴＳ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrneurjpyttb</td><td>（連携用）ユーロ－円（ＴＴＢ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrneurjpyttm</td><td>（連携用）ユーロ－円（ＴＴＭ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnaudjpytts</td><td>（連携用）豪ドル－円（ＴＴＳ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnaudjpyttb</td><td>（連携用）豪ドル－円（ＴＴＢ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnaudjpyttm</td><td>（連携用）豪ドル－円（ＴＴＭ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9</td><td>（連携用）予備項目Ｎ９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x2</td><td>（連携用）予備項目Ｎ９＿２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x3</td><td>（連携用）予備項目Ｎ９＿３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x4</td><td>（連携用）予備項目Ｎ９＿４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x5</td><td>（連携用）予備項目Ｎ９＿５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x6</td><td>（連携用）予備項目Ｎ９＿６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x7</td><td>（連携用）予備項目Ｎ９＿７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x8</td><td>（連携用）予備項目Ｎ９＿８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x9</td><td>（連携用）予備項目Ｎ９＿９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x10</td><td>（連携用）予備項目Ｎ９＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x11</td><td>（連携用）予備項目Ｎ９＿１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x12</td><td>（連携用）予備項目Ｎ９＿１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x13</td><td>（連携用）予備項目Ｎ９＿１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x14</td><td>（連携用）予備項目Ｎ９＿１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x15</td><td>（連携用）予備項目Ｎ９＿１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x16</td><td>（連携用）予備項目Ｎ９＿１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x17</td><td>（連携用）予備項目Ｎ９＿１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x18</td><td>（連携用）予備項目Ｎ９＿１８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x19</td><td>（連携用）予備項目Ｎ９＿１９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x20</td><td>（連携用）予備項目Ｎ９＿２０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x21</td><td>（連携用）予備項目Ｎ９＿２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnusdjpynykn</td><td>（連携用）米ドル－円（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrneurjpynykn</td><td>（連携用）ユーロ－円（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnaudjpynykn</td><td>（連携用）豪ドル－円（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x101</td><td>（連携用）予備項目Ｎ９＿１０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x102</td><td>（連携用）予備項目Ｎ９＿１０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x103</td><td>（連携用）予備項目Ｎ９＿１０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x104</td><td>（連携用）予備項目Ｎ９＿１０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x105</td><td>（連携用）予備項目Ｎ９＿１０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x106</td><td>（連携用）予備項目Ｎ９＿１０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x107</td><td>（連携用）予備項目Ｎ９＿１０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnusdeurnykn</td><td>（連携用）米ドル－ユーロ（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnusdaudnykn</td><td>（連携用）米ドル－豪ドル（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x111</td><td>（連携用）予備項目Ｎ９＿１１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x112</td><td>（連携用）予備項目Ｎ９＿１１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x113</td><td>（連携用）予備項目Ｎ９＿１１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x114</td><td>（連携用）予備項目Ｎ９＿１１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x115</td><td>（連携用）予備項目Ｎ９＿１１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x116</td><td>（連携用）予備項目Ｎ９＿１１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x117</td><td>（連携用）予備項目Ｎ９＿１１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrneurusdnykn</td><td>（連携用）ユーロ－米ドル（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrneuraudnykn</td><td>（連携用）ユーロ－豪ドル（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x121</td><td>（連携用）予備項目Ｎ９＿１２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x122</td><td>（連携用）予備項目Ｎ９＿１２２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x123</td><td>（連携用）予備項目Ｎ９＿１２３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x124</td><td>（連携用）予備項目Ｎ９＿１２４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x125</td><td>（連携用）予備項目Ｎ９＿１２５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x126</td><td>（連携用）予備項目Ｎ９＿１２６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x127</td><td>（連携用）予備項目Ｎ９＿１２７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnaudusenykn</td><td>（連携用）豪ドル－米ドル（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnaudeurnykn</td><td>（連携用）豪ドル－ユーロ（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x131</td><td>（連携用）予備項目Ｎ９＿１３１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x132</td><td>（連携用）予備項目Ｎ９＿１３２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x133</td><td>（連携用）予備項目Ｎ９＿１３３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x134</td><td>（連携用）予備項目Ｎ９＿１３４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x135</td><td>（連携用）予備項目Ｎ９＿１３５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x136</td><td>（連携用）予備項目Ｎ９＿１３６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x137</td><td>（連携用）予備項目Ｎ９＿１３７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x141</td><td>（連携用）予備項目Ｎ９＿１４１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x142</td><td>（連携用）予備項目Ｎ９＿１４２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x143</td><td>（連携用）予備項目Ｎ９＿１４３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x144</td><td>（連携用）予備項目Ｎ９＿１４４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x145</td><td>（連携用）予備項目Ｎ９＿１４５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x146</td><td>（連携用）予備項目Ｎ９＿１４６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x147</td><td>（連携用）予備項目Ｎ９＿１４７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x148</td><td>（連携用）予備項目Ｎ９＿１４８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x149</td><td>（連携用）予備項目Ｎ９＿１４９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x151</td><td>（連携用）予備項目Ｎ９＿１５１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x152</td><td>（連携用）予備項目Ｎ９＿１５２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x153</td><td>（連携用）予備項目Ｎ９＿１５３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x154</td><td>（連携用）予備項目Ｎ９＿１５４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x155</td><td>（連携用）予備項目Ｎ９＿１５５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x156</td><td>（連携用）予備項目Ｎ９＿１５６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x157</td><td>（連携用）予備項目Ｎ９＿１５７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x158</td><td>（連携用）予備項目Ｎ９＿１５８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x159</td><td>（連携用）予備項目Ｎ９＿１５９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x161</td><td>（連携用）予備項目Ｎ９＿１６１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x162</td><td>（連携用）予備項目Ｎ９＿１６２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x163</td><td>（連携用）予備項目Ｎ９＿１６３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x164</td><td>（連携用）予備項目Ｎ９＿１６４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x165</td><td>（連携用）予備項目Ｎ９＿１６５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x166</td><td>（連携用）予備項目Ｎ９＿１６６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x167</td><td>（連携用）予備項目Ｎ９＿１６７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x168</td><td>（連携用）予備項目Ｎ９＿１６８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x169</td><td>（連携用）予備項目Ｎ９＿１６９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x171</td><td>（連携用）予備項目Ｎ９＿１７１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x172</td><td>（連携用）予備項目Ｎ９＿１７２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x173</td><td>（連携用）予備項目Ｎ９＿１７３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x174</td><td>（連携用）予備項目Ｎ９＿１７４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x175</td><td>（連携用）予備項目Ｎ９＿１７５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x176</td><td>（連携用）予備項目Ｎ９＿１７６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x177</td><td>（連携用）予備項目Ｎ９＿１７７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x178</td><td>（連携用）予備項目Ｎ９＿１７８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x179</td><td>（連携用）予備項目Ｎ９＿１７９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x181</td><td>（連携用）予備項目Ｎ９＿１８１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x182</td><td>（連携用）予備項目Ｎ９＿１８２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x183</td><td>（連携用）予備項目Ｎ９＿１８３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x184</td><td>（連携用）予備項目Ｎ９＿１８４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x185</td><td>（連携用）予備項目Ｎ９＿１８５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x186</td><td>（連携用）予備項目Ｎ９＿１８６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x187</td><td>（連携用）予備項目Ｎ９＿１８７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x188</td><td>（連携用）予備項目Ｎ９＿１８８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x189</td><td>（連携用）予備項目Ｎ９＿１８９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x191</td><td>（連携用）予備項目Ｎ９＿１９１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x192</td><td>（連携用）予備項目Ｎ９＿１９２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x193</td><td>（連携用）予備項目Ｎ９＿１９３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x194</td><td>（連携用）予備項目Ｎ９＿１９４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x195</td><td>（連携用）予備項目Ｎ９＿１９５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x196</td><td>（連携用）予備項目Ｎ９＿１９６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x197</td><td>（連携用）予備項目Ｎ９＿１９７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x198</td><td>（連携用）予備項目Ｎ９＿１９８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x199</td><td>（連携用）予備項目Ｎ９＿１９９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x201</td><td>（連携用）予備項目Ｎ９＿２０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x202</td><td>（連携用）予備項目Ｎ９＿２０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x203</td><td>（連携用）予備項目Ｎ９＿２０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x204</td><td>（連携用）予備項目Ｎ９＿２０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x205</td><td>（連携用）予備項目Ｎ９＿２０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x206</td><td>（連携用）予備項目Ｎ９＿２０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x207</td><td>（連携用）予備項目Ｎ９＿２０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x208</td><td>（連携用）予備項目Ｎ９＿２０８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x209</td><td>（連携用）予備項目Ｎ９＿２０９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnusdjpysykn</td><td>（連携用）米ドル－円（出金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrneurjpysykn</td><td>（連携用）ユーロ－円（出金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnaudjpysykn</td><td>（連携用）豪ドル－円（出金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x301</td><td>（連携用）予備項目Ｎ９＿３０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x302</td><td>（連携用）予備項目Ｎ９＿３０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x303</td><td>（連携用）予備項目Ｎ９＿３０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x304</td><td>（連携用）予備項目Ｎ９＿３０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x305</td><td>（連携用）予備項目Ｎ９＿３０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x306</td><td>（連携用）予備項目Ｎ９＿３０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x307</td><td>（連携用）予備項目Ｎ９＿３０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnusdjpytts17pm</td><td>（連携用）米ドル－円（ＴＴＳ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnusdjpyttb17pm</td><td>（連携用）米ドル－円（ＴＴＢ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnusdjpyttm17pm</td><td>（連携用）米ドル－円（ＴＴＭ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrneurjpytts17pm</td><td>（連携用）ユーロ－円（ＴＴＳ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrneurjpyttb17pm</td><td>（連携用）ユーロ－円（ＴＴＢ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrneurjpyttm17pm</td><td>（連携用）ユーロ－円（ＴＴＭ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnaudjpytts17pm</td><td>（連携用）豪ドル－円（ＴＴＳ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnaudjpyttb17pm</td><td>（連携用）豪ドル－円（ＴＴＢ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnaudjpyttm17pm</td><td>（連携用）豪ドル－円（ＴＴＭ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x501</td><td>（連携用）予備項目Ｎ９＿５０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x502</td><td>（連携用）予備項目Ｎ９＿５０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x503</td><td>（連携用）予備項目Ｎ９＿５０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x504</td><td>（連携用）予備項目Ｎ９＿５０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x505</td><td>（連携用）予備項目Ｎ９＿５０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x506</td><td>（連携用）予備項目Ｎ９＿５０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x507</td><td>（連携用）予備項目Ｎ９＿５０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x508</td><td>（連携用）予備項目Ｎ９＿５０８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x509</td><td>（連携用）予備項目Ｎ９＿５０９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x510</td><td>（連携用）予備項目Ｎ９＿５１０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x511</td><td>（連携用）予備項目Ｎ９＿５１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x512</td><td>（連携用）予備項目Ｎ９＿５１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x513</td><td>（連携用）予備項目Ｎ９＿５１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x514</td><td>（連携用）予備項目Ｎ９＿５１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x515</td><td>（連携用）予備項目Ｎ９＿５１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x516</td><td>（連携用）予備項目Ｎ９＿５１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x517</td><td>（連携用）予備項目Ｎ９＿５１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x518</td><td>（連携用）予備項目Ｎ９＿５１８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x519</td><td>（連携用）予備項目Ｎ９＿５１９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x520</td><td>（連携用）予備項目Ｎ９＿５２０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobin9x521</td><td>（連携用）予備項目Ｎ９＿５２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 * </table>
 * @see     ZT_KawaserateRn
 * @see     GenZT_KawaserateRn
 * @see     QZT_KawaserateRn
 * @see     GenQZT_KawaserateRn
 */
public class PKZT_KawaserateRn extends AbstractExDBPrimaryKey<ZT_KawaserateRn, PKZT_KawaserateRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KawaserateRn() {
    }

    public PKZT_KawaserateRn(String pZrnkwsratekjymd, String pZrnkawaserendoukbn) {
        zrnkwsratekjymd = pZrnkwsratekjymd;
        zrnkawaserendoukbn = pZrnkawaserendoukbn;
    }

    @Transient
    @Override
    public Class<ZT_KawaserateRn> getEntityClass() {
        return ZT_KawaserateRn.class;
    }

    private String zrnkwsratekjymd;

    public String getZrnkwsratekjymd() {
        return zrnkwsratekjymd;
    }

    public void setZrnkwsratekjymd(String pZrnkwsratekjymd) {
        zrnkwsratekjymd = pZrnkwsratekjymd;
    }
    private String zrnkawaserendoukbn;

    public String getZrnkawaserendoukbn() {
        return zrnkawaserendoukbn;
    }

    public void setZrnkawaserendoukbn(String pZrnkawaserendoukbn) {
        zrnkawaserendoukbn = pZrnkawaserendoukbn;
    }

}