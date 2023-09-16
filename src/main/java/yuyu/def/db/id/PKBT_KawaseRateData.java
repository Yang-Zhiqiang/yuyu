package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.db.entity.BT_KawaseRateData;
import yuyu.def.db.mapping.GenBT_KawaseRateData;
import yuyu.def.db.meta.GenQBT_KawaseRateData;
import yuyu.def.db.meta.QBT_KawaseRateData;

/**
 * 為替レートデータテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_KawaseRateData}</td><td colspan="3">為替レートデータテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKwsratekjymd kwsratekjymd}</td><td>為替レート基準日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKwsrendoukbn kwsrendoukbn}</td><td>為替レート連動区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KwsrendouKbn}</td></tr>
 *  <tr><td>yobiv91</td><td>予備項目Ｖ９１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>usdjpytts</td><td>米ドル－円（ＴＴＳ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>usdjpyttb</td><td>米ドル－円（ＴＴＢ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>usdjpyttm</td><td>米ドル－円（ＴＴＭ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>eurjpytts</td><td>ユーロ－円（ＴＴＳ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>eurjpyttb</td><td>ユーロ－円（ＴＴＢ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>eurjpyttm</td><td>ユーロ－円（ＴＴＭ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>audjpytts</td><td>豪ドル－円（ＴＴＳ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>audjpyttb</td><td>豪ドル－円（ＴＴＢ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>audjpyttm</td><td>豪ドル－円（ＴＴＭ）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9</td><td>予備項目Ｎ９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x2</td><td>予備項目Ｎ９＿２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x3</td><td>予備項目Ｎ９＿３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x4</td><td>予備項目Ｎ９＿４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x5</td><td>予備項目Ｎ９＿５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x6</td><td>予備項目Ｎ９＿６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x7</td><td>予備項目Ｎ９＿７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x8</td><td>予備項目Ｎ９＿８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x9</td><td>予備項目Ｎ９＿９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x10</td><td>予備項目Ｎ９＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x11</td><td>予備項目Ｎ９＿１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x12</td><td>予備項目Ｎ９＿１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x13</td><td>予備項目Ｎ９＿１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x14</td><td>予備項目Ｎ９＿１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x15</td><td>予備項目Ｎ９＿１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x16</td><td>予備項目Ｎ９＿１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x17</td><td>予備項目Ｎ９＿１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x18</td><td>予備項目Ｎ９＿１８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x19</td><td>予備項目Ｎ９＿１９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x20</td><td>予備項目Ｎ９＿２０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x21</td><td>予備項目Ｎ９＿２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>usdjpynykn</td><td>米ドル－円（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>eurjpynykn</td><td>ユーロ－円（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>audjpynykn</td><td>豪ドル－円（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x101</td><td>予備項目Ｎ９＿１０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x102</td><td>予備項目Ｎ９＿１０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x103</td><td>予備項目Ｎ９＿１０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x104</td><td>予備項目Ｎ９＿１０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x105</td><td>予備項目Ｎ９＿１０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x106</td><td>予備項目Ｎ９＿１０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x107</td><td>予備項目Ｎ９＿１０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>usdeurnykn</td><td>米ドル－ユーロ（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>usdaudnykn</td><td>米ドル－豪ドル（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x111</td><td>予備項目Ｎ９＿１１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x112</td><td>予備項目Ｎ９＿１１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x113</td><td>予備項目Ｎ９＿１１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x114</td><td>予備項目Ｎ９＿１１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x115</td><td>予備項目Ｎ９＿１１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x116</td><td>予備項目Ｎ９＿１１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x117</td><td>予備項目Ｎ９＿１１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>eurusdnykn</td><td>ユーロ－米ドル（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>euraudnykn</td><td>ユーロ－豪ドル（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x121</td><td>予備項目Ｎ９＿１２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x122</td><td>予備項目Ｎ９＿１２２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x123</td><td>予備項目Ｎ９＿１２３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x124</td><td>予備項目Ｎ９＿１２４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x125</td><td>予備項目Ｎ９＿１２５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x126</td><td>予備項目Ｎ９＿１２６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x127</td><td>予備項目Ｎ９＿１２７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>audusdnykn</td><td>豪ドル－米ドル（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>audeurnykn</td><td>豪ドル－ユーロ（入金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x131</td><td>予備項目Ｎ９＿１３１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x132</td><td>予備項目Ｎ９＿１３２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x133</td><td>予備項目Ｎ９＿１３３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x134</td><td>予備項目Ｎ９＿１３４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x135</td><td>予備項目Ｎ９＿１３５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x136</td><td>予備項目Ｎ９＿１３６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x137</td><td>予備項目Ｎ９＿１３７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x141</td><td>予備項目Ｎ９＿１４１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x142</td><td>予備項目Ｎ９＿１４２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x143</td><td>予備項目Ｎ９＿１４３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x144</td><td>予備項目Ｎ９＿１４４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x145</td><td>予備項目Ｎ９＿１４５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x146</td><td>予備項目Ｎ９＿１４６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x147</td><td>予備項目Ｎ９＿１４７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x148</td><td>予備項目Ｎ９＿１４８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x149</td><td>予備項目Ｎ９＿１４９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x151</td><td>予備項目Ｎ９＿１５１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x152</td><td>予備項目Ｎ９＿１５２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x153</td><td>予備項目Ｎ９＿１５３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x154</td><td>予備項目Ｎ９＿１５４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x155</td><td>予備項目Ｎ９＿１５５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x156</td><td>予備項目Ｎ９＿１５６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x157</td><td>予備項目Ｎ９＿１５７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x158</td><td>予備項目Ｎ９＿１５８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x159</td><td>予備項目Ｎ９＿１５９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x161</td><td>予備項目Ｎ９＿１６１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x162</td><td>予備項目Ｎ９＿１６２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x163</td><td>予備項目Ｎ９＿１６３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x164</td><td>予備項目Ｎ９＿１６４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x165</td><td>予備項目Ｎ９＿１６５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x166</td><td>予備項目Ｎ９＿１６６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x167</td><td>予備項目Ｎ９＿１６７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x168</td><td>予備項目Ｎ９＿１６８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x169</td><td>予備項目Ｎ９＿１６９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x171</td><td>予備項目Ｎ９＿１７１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x172</td><td>予備項目Ｎ９＿１７２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x173</td><td>予備項目Ｎ９＿１７３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x174</td><td>予備項目Ｎ９＿１７４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x175</td><td>予備項目Ｎ９＿１７５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x176</td><td>予備項目Ｎ９＿１７６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x177</td><td>予備項目Ｎ９＿１７７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x178</td><td>予備項目Ｎ９＿１７８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x179</td><td>予備項目Ｎ９＿１７９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x181</td><td>予備項目Ｎ９＿１８１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x182</td><td>予備項目Ｎ９＿１８２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x183</td><td>予備項目Ｎ９＿１８３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x184</td><td>予備項目Ｎ９＿１８４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x185</td><td>予備項目Ｎ９＿１８５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x186</td><td>予備項目Ｎ９＿１８６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x187</td><td>予備項目Ｎ９＿１８７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x188</td><td>予備項目Ｎ９＿１８８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x189</td><td>予備項目Ｎ９＿１８９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x191</td><td>予備項目Ｎ９＿１９１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x192</td><td>予備項目Ｎ９＿１９２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x193</td><td>予備項目Ｎ９＿１９３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x194</td><td>予備項目Ｎ９＿１９４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x195</td><td>予備項目Ｎ９＿１９５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x196</td><td>予備項目Ｎ９＿１９６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x197</td><td>予備項目Ｎ９＿１９７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x198</td><td>予備項目Ｎ９＿１９８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x199</td><td>予備項目Ｎ９＿１９９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x201</td><td>予備項目Ｎ９＿２０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x202</td><td>予備項目Ｎ９＿２０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x203</td><td>予備項目Ｎ９＿２０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x204</td><td>予備項目Ｎ９＿２０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x205</td><td>予備項目Ｎ９＿２０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x206</td><td>予備項目Ｎ９＿２０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x207</td><td>予備項目Ｎ９＿２０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x208</td><td>予備項目Ｎ９＿２０８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x209</td><td>予備項目Ｎ９＿２０９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>usdjpysykn</td><td>米ドル－円（出金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>eurjpysykn</td><td>ユーロ－円（出金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>audjpysykn</td><td>豪ドル－円（出金用）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x301</td><td>予備項目Ｎ９＿３０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x302</td><td>予備項目Ｎ９＿３０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x303</td><td>予備項目Ｎ９＿３０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x304</td><td>予備項目Ｎ９＿３０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x305</td><td>予備項目Ｎ９＿３０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x306</td><td>予備項目Ｎ９＿３０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x307</td><td>予備項目Ｎ９＿３０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>usdjpytts17pm</td><td>米ドル－円（ＴＴＳ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>usdjpyttb17pm</td><td>米ドル－円（ＴＴＢ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>usdjpyttm17pm</td><td>米ドル－円（ＴＴＭ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>eurjpytts17pm</td><td>ユーロ－円（ＴＴＳ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>eurjpyttb17pm</td><td>ユーロ－円（ＴＴＢ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>eurjpyttm17pm</td><td>ユーロ－円（ＴＴＭ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>audjpytts17pm</td><td>豪ドル－円（ＴＴＳ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>audjpyttb17pm</td><td>豪ドル－円（ＴＴＢ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>audjpyttm17pm</td><td>豪ドル－円（ＴＴＭ）１７時</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x501</td><td>予備項目Ｎ９＿５０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x502</td><td>予備項目Ｎ９＿５０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x503</td><td>予備項目Ｎ９＿５０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x504</td><td>予備項目Ｎ９＿５０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x505</td><td>予備項目Ｎ９＿５０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x506</td><td>予備項目Ｎ９＿５０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x507</td><td>予備項目Ｎ９＿５０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x508</td><td>予備項目Ｎ９＿５０８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x509</td><td>予備項目Ｎ９＿５０９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x510</td><td>予備項目Ｎ９＿５１０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x511</td><td>予備項目Ｎ９＿５１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x512</td><td>予備項目Ｎ９＿５１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x513</td><td>予備項目Ｎ９＿５１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x514</td><td>予備項目Ｎ９＿５１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x515</td><td>予備項目Ｎ９＿５１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x516</td><td>予備項目Ｎ９＿５１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x517</td><td>予備項目Ｎ９＿５１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x518</td><td>予備項目Ｎ９＿５１８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x519</td><td>予備項目Ｎ９＿５１９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x520</td><td>予備項目Ｎ９＿５２０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>yobin9x521</td><td>予備項目Ｎ９＿５２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 * </table>
 * @see     BT_KawaseRateData
 * @see     GenBT_KawaseRateData
 * @see     QBT_KawaseRateData
 * @see     GenQBT_KawaseRateData
 */
public class PKBT_KawaseRateData extends AbstractExDBPrimaryKey<BT_KawaseRateData, PKBT_KawaseRateData> {

    private static final long serialVersionUID = 1L;

    public PKBT_KawaseRateData() {
    }

    public PKBT_KawaseRateData(BizDate pKwsratekjymd, C_KwsrendouKbn pKwsrendoukbn) {
        kwsratekjymd = pKwsratekjymd;
        kwsrendoukbn = pKwsrendoukbn;
    }

    @Transient
    @Override
    public Class<BT_KawaseRateData> getEntityClass() {
        return BT_KawaseRateData.class;
    }

    private BizDate kwsratekjymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKwsratekjymd() {
        return kwsratekjymd;
    }

    public void setKwsratekjymd(BizDate pKwsratekjymd) {
        kwsratekjymd = pKwsratekjymd;
    }
    private C_KwsrendouKbn kwsrendoukbn;

    @org.hibernate.annotations.Type(type="UserType_C_KwsrendouKbn")
    public C_KwsrendouKbn getKwsrendoukbn() {
        return kwsrendoukbn;
    }

    public void setKwsrendoukbn(C_KwsrendouKbn pKwsrendoukbn) {
        kwsrendoukbn = pKwsrendoukbn;
    }

}