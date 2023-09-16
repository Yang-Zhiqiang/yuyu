package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KawaserateTr;
import yuyu.def.db.mapping.GenZT_KawaserateTr;
import yuyu.def.db.meta.GenQZT_KawaserateTr;
import yuyu.def.db.meta.QZT_KawaserateTr;

/**
 * 為替レートテーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KawaserateTr}</td><td colspan="3">為替レートテーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrkwsratekjymd ztrkwsratekjymd}</td><td>（取込用）為替レート基準日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrkawaserendoukbn ztrkawaserendoukbn}</td><td>（取込用）為替レート連動区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv91</td><td>（取込用）予備項目Ｖ９１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrusdjpytts</td><td>（取込用）米ドル－円（ＴＴＳ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztrusdjpyttb</td><td>（取込用）米ドル－円（ＴＴＢ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztrusdjpyttm</td><td>（取込用）米ドル－円（ＴＴＭ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztreurjpytts</td><td>（取込用）ユーロ－円（ＴＴＳ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztreurjpyttb</td><td>（取込用）ユーロ－円（ＴＴＢ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztreurjpyttm</td><td>（取込用）ユーロ－円（ＴＴＭ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztraudjpytts</td><td>（取込用）豪ドル－円（ＴＴＳ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztraudjpyttb</td><td>（取込用）豪ドル－円（ＴＴＢ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztraudjpyttm</td><td>（取込用）豪ドル－円（ＴＴＭ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9</td><td>（取込用）予備項目Ｎ９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x2</td><td>（取込用）予備項目Ｎ９＿２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x3</td><td>（取込用）予備項目Ｎ９＿３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x4</td><td>（取込用）予備項目Ｎ９＿４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x5</td><td>（取込用）予備項目Ｎ９＿５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x6</td><td>（取込用）予備項目Ｎ９＿６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x7</td><td>（取込用）予備項目Ｎ９＿７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x8</td><td>（取込用）予備項目Ｎ９＿８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x9</td><td>（取込用）予備項目Ｎ９＿９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x10</td><td>（取込用）予備項目Ｎ９＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x11</td><td>（取込用）予備項目Ｎ９＿１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x12</td><td>（取込用）予備項目Ｎ９＿１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x13</td><td>（取込用）予備項目Ｎ９＿１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x14</td><td>（取込用）予備項目Ｎ９＿１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x15</td><td>（取込用）予備項目Ｎ９＿１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x16</td><td>（取込用）予備項目Ｎ９＿１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x17</td><td>（取込用）予備項目Ｎ９＿１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x18</td><td>（取込用）予備項目Ｎ９＿１８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x19</td><td>（取込用）予備項目Ｎ９＿１９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x20</td><td>（取込用）予備項目Ｎ９＿２０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x21</td><td>（取込用）予備項目Ｎ９＿２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztrusdjpynykn</td><td>（取込用）米ドル－円（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztreurjpynykn</td><td>（取込用）ユーロ－円（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztraudjpynykn</td><td>（取込用）豪ドル－円（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x101</td><td>（取込用）予備項目Ｎ９＿１０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x102</td><td>（取込用）予備項目Ｎ９＿１０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x103</td><td>（取込用）予備項目Ｎ９＿１０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x104</td><td>（取込用）予備項目Ｎ９＿１０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x105</td><td>（取込用）予備項目Ｎ９＿１０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x106</td><td>（取込用）予備項目Ｎ９＿１０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x107</td><td>（取込用）予備項目Ｎ９＿１０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztrusdeurnykn</td><td>（取込用）米ドル－ユーロ（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztrusdaudnykn</td><td>（取込用）米ドル－豪ドル（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x111</td><td>（取込用）予備項目Ｎ９＿１１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x112</td><td>（取込用）予備項目Ｎ９＿１１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x113</td><td>（取込用）予備項目Ｎ９＿１１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x114</td><td>（取込用）予備項目Ｎ９＿１１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x115</td><td>（取込用）予備項目Ｎ９＿１１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x116</td><td>（取込用）予備項目Ｎ９＿１１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x117</td><td>（取込用）予備項目Ｎ９＿１１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztreurusdnykn</td><td>（取込用）ユーロ－米ドル（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztreuraudnykn</td><td>（取込用）ユーロ－豪ドル（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x121</td><td>（取込用）予備項目Ｎ９＿１２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x122</td><td>（取込用）予備項目Ｎ９＿１２２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x123</td><td>（取込用）予備項目Ｎ９＿１２３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x124</td><td>（取込用）予備項目Ｎ９＿１２４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x125</td><td>（取込用）予備項目Ｎ９＿１２５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x126</td><td>（取込用）予備項目Ｎ９＿１２６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x127</td><td>（取込用）予備項目Ｎ９＿１２７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztraudusenykn</td><td>（取込用）豪ドル－米ドル（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztraudeurnykn</td><td>（取込用）豪ドル－ユーロ（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x131</td><td>（取込用）予備項目Ｎ９＿１３１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x132</td><td>（取込用）予備項目Ｎ９＿１３２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x133</td><td>（取込用）予備項目Ｎ９＿１３３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x134</td><td>（取込用）予備項目Ｎ９＿１３４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x135</td><td>（取込用）予備項目Ｎ９＿１３５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x136</td><td>（取込用）予備項目Ｎ９＿１３６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x137</td><td>（取込用）予備項目Ｎ９＿１３７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x141</td><td>（取込用）予備項目Ｎ９＿１４１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x142</td><td>（取込用）予備項目Ｎ９＿１４２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x143</td><td>（取込用）予備項目Ｎ９＿１４３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x144</td><td>（取込用）予備項目Ｎ９＿１４４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x145</td><td>（取込用）予備項目Ｎ９＿１４５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x146</td><td>（取込用）予備項目Ｎ９＿１４６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x147</td><td>（取込用）予備項目Ｎ９＿１４７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x148</td><td>（取込用）予備項目Ｎ９＿１４８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x149</td><td>（取込用）予備項目Ｎ９＿１４９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x151</td><td>（取込用）予備項目Ｎ９＿１５１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x152</td><td>（取込用）予備項目Ｎ９＿１５２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x153</td><td>（取込用）予備項目Ｎ９＿１５３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x154</td><td>（取込用）予備項目Ｎ９＿１５４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x155</td><td>（取込用）予備項目Ｎ９＿１５５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x156</td><td>（取込用）予備項目Ｎ９＿１５６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x157</td><td>（取込用）予備項目Ｎ９＿１５７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x158</td><td>（取込用）予備項目Ｎ９＿１５８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x159</td><td>（取込用）予備項目Ｎ９＿１５９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x161</td><td>（取込用）予備項目Ｎ９＿１６１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x162</td><td>（取込用）予備項目Ｎ９＿１６２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x163</td><td>（取込用）予備項目Ｎ９＿１６３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x164</td><td>（取込用）予備項目Ｎ９＿１６４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x165</td><td>（取込用）予備項目Ｎ９＿１６５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x166</td><td>（取込用）予備項目Ｎ９＿１６６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x167</td><td>（取込用）予備項目Ｎ９＿１６７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x168</td><td>（取込用）予備項目Ｎ９＿１６８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x169</td><td>（取込用）予備項目Ｎ９＿１６９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x171</td><td>（取込用）予備項目Ｎ９＿１７１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x172</td><td>（取込用）予備項目Ｎ９＿１７２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x173</td><td>（取込用）予備項目Ｎ９＿１７３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x174</td><td>（取込用）予備項目Ｎ９＿１７４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x175</td><td>（取込用）予備項目Ｎ９＿１７５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x176</td><td>（取込用）予備項目Ｎ９＿１７６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x177</td><td>（取込用）予備項目Ｎ９＿１７７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x178</td><td>（取込用）予備項目Ｎ９＿１７８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x179</td><td>（取込用）予備項目Ｎ９＿１７９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x181</td><td>（取込用）予備項目Ｎ９＿１８１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x182</td><td>（取込用）予備項目Ｎ９＿１８２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x183</td><td>（取込用）予備項目Ｎ９＿１８３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x184</td><td>（取込用）予備項目Ｎ９＿１８４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x185</td><td>（取込用）予備項目Ｎ９＿１８５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x186</td><td>（取込用）予備項目Ｎ９＿１８６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x187</td><td>（取込用）予備項目Ｎ９＿１８７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x188</td><td>（取込用）予備項目Ｎ９＿１８８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x189</td><td>（取込用）予備項目Ｎ９＿１８９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x191</td><td>（取込用）予備項目Ｎ９＿１９１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x192</td><td>（取込用）予備項目Ｎ９＿１９２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x193</td><td>（取込用）予備項目Ｎ９＿１９３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x194</td><td>（取込用）予備項目Ｎ９＿１９４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x195</td><td>（取込用）予備項目Ｎ９＿１９５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x196</td><td>（取込用）予備項目Ｎ９＿１９６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x197</td><td>（取込用）予備項目Ｎ９＿１９７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x198</td><td>（取込用）予備項目Ｎ９＿１９８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x199</td><td>（取込用）予備項目Ｎ９＿１９９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x201</td><td>（取込用）予備項目Ｎ９＿２０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x202</td><td>（取込用）予備項目Ｎ９＿２０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x203</td><td>（取込用）予備項目Ｎ９＿２０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x204</td><td>（取込用）予備項目Ｎ９＿２０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x205</td><td>（取込用）予備項目Ｎ９＿２０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x206</td><td>（取込用）予備項目Ｎ９＿２０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x207</td><td>（取込用）予備項目Ｎ９＿２０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x208</td><td>（取込用）予備項目Ｎ９＿２０８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x209</td><td>（取込用）予備項目Ｎ９＿２０９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztrusdjpysykn</td><td>（取込用）米ドル－円（出金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztreurjpysykn</td><td>（取込用）ユーロ－円（出金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztraudjpysykn</td><td>（取込用）豪ドル－円（出金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x301</td><td>（取込用）予備項目Ｎ９＿３０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x302</td><td>（取込用）予備項目Ｎ９＿３０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x303</td><td>（取込用）予備項目Ｎ９＿３０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x304</td><td>（取込用）予備項目Ｎ９＿３０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x305</td><td>（取込用）予備項目Ｎ９＿３０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x306</td><td>（取込用）予備項目Ｎ９＿３０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x307</td><td>（取込用）予備項目Ｎ９＿３０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztrusdjpytts17pm</td><td>（取込用）米ドル－円（ＴＴＳ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztrusdjpyttb17pm</td><td>（取込用）米ドル－円（ＴＴＢ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztrusdjpyttm17pm</td><td>（取込用）米ドル－円（ＴＴＭ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztreurjpytts17pm</td><td>（取込用）ユーロ－円（ＴＴＳ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztreurjpyttb17pm</td><td>（取込用）ユーロ－円（ＴＴＢ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztreurjpyttm17pm</td><td>（取込用）ユーロ－円（ＴＴＭ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztraudjpytts17pm</td><td>（取込用）豪ドル－円（ＴＴＳ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztraudjpyttb17pm</td><td>（取込用）豪ドル－円（ＴＴＢ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztraudjpyttm17pm</td><td>（取込用）豪ドル－円（ＴＴＭ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x501</td><td>（取込用）予備項目Ｎ９＿５０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x502</td><td>（取込用）予備項目Ｎ９＿５０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x503</td><td>（取込用）予備項目Ｎ９＿５０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x504</td><td>（取込用）予備項目Ｎ９＿５０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x505</td><td>（取込用）予備項目Ｎ９＿５０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x506</td><td>（取込用）予備項目Ｎ９＿５０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x507</td><td>（取込用）予備項目Ｎ９＿５０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x508</td><td>（取込用）予備項目Ｎ９＿５０８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x509</td><td>（取込用）予備項目Ｎ９＿５０９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x510</td><td>（取込用）予備項目Ｎ９＿５１０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x511</td><td>（取込用）予備項目Ｎ９＿５１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x512</td><td>（取込用）予備項目Ｎ９＿５１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x513</td><td>（取込用）予備項目Ｎ９＿５１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x514</td><td>（取込用）予備項目Ｎ９＿５１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x515</td><td>（取込用）予備項目Ｎ９＿５１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x516</td><td>（取込用）予備項目Ｎ９＿５１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x517</td><td>（取込用）予備項目Ｎ９＿５１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x518</td><td>（取込用）予備項目Ｎ９＿５１８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x519</td><td>（取込用）予備項目Ｎ９＿５１９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x520</td><td>（取込用）予備項目Ｎ９＿５２０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztryobin9x521</td><td>（取込用）予備項目Ｎ９＿５２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 * </table>
 * @see     ZT_KawaserateTr
 * @see     GenZT_KawaserateTr
 * @see     QZT_KawaserateTr
 * @see     GenQZT_KawaserateTr
 */
public class PKZT_KawaserateTr extends AbstractExDBPrimaryKey<ZT_KawaserateTr, PKZT_KawaserateTr> {

    private static final long serialVersionUID = 1L;

    public PKZT_KawaserateTr() {
    }

    public PKZT_KawaserateTr(String pZtrkwsratekjymd, String pZtrkawaserendoukbn) {
        ztrkwsratekjymd = pZtrkwsratekjymd;
        ztrkawaserendoukbn = pZtrkawaserendoukbn;
    }

    @Transient
    @Override
    public Class<ZT_KawaserateTr> getEntityClass() {
        return ZT_KawaserateTr.class;
    }

    private String ztrkwsratekjymd;

    public String getZtrkwsratekjymd() {
        return ztrkwsratekjymd;
    }

    public void setZtrkwsratekjymd(String pZtrkwsratekjymd) {
        ztrkwsratekjymd = pZtrkwsratekjymd;
    }
    private String ztrkawaserendoukbn;

    public String getZtrkawaserendoukbn() {
        return ztrkawaserendoukbn;
    }

    public void setZtrkawaserendoukbn(String pZtrkawaserendoukbn) {
        ztrkawaserendoukbn = pZtrkawaserendoukbn;
    }

}