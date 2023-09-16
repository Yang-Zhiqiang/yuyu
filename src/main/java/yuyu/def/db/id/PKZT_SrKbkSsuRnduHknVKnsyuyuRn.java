package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SrKbkSsuRnduHknVKnsyuyuRn;
import yuyu.def.db.mapping.GenZT_SrKbkSsuRnduHknVKnsyuyuRn;
import yuyu.def.db.meta.GenQZT_SrKbkSsuRnduHknVKnsyuyuRn;
import yuyu.def.db.meta.QZT_SrKbkSsuRnduHknVKnsyuyuRn;

/**
 * 株価指数連動保険Ｖ検証用Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SrKbkSsuRnduHknVKnsyuyuRn}</td><td colspan="3">株価指数連動保険Ｖ検証用Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyuukourecordlength</td><td>（連携用）有効レコード長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnrdwarea</td><td>（連携用）ＲＤＷ領域</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeijyouym</td><td>（連携用）計上年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnraysystemhyj</td><td>（連携用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndatakanrino</td><td>（連携用）データ管理番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruikigousedaikbn</td><td>（連携用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsotodasipmenkbn</td><td>（連携用）外出Ｐ免区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsotodasimanagehyouji</td><td>（連携用）外出満年令表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin6</td><td>（連携用）数理用予備項目Ｎ６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv12</td><td>（連携用）予備項目Ｖ１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkbnkeiriyousegmentkbn</td><td>（連携用）区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkbnkeiriyourgnbnskkbn</td><td>（連携用）区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuurisyuruicd</td><td>（連携用）数理種類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin6x2</td><td>（連携用）数理用予備項目Ｎ６＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8</td><td>（連携用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknkkn</td><td>（連携用）保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphrkkikn</td><td>（連携用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaimnkkykhyj</td><td>（連携用）才満期契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhihokensyaagev2</td><td>（連携用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkuriagekurisagekbn</td><td>（連携用）繰上げ繰下げ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin6x3</td><td>（連携用）数理用予備項目Ｎ６＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8x2</td><td>（連携用）予備項目Ｖ８＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakujiyoteiriritu</td><td>（連携用）契約時予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsrkaiyakusjkkktyouseirrt</td><td>（連携用）数理用解約時市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsrkyksjkkktyouseiriritu</td><td>（連携用）数理用契約時市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnmvatyouseikou</td><td>（連携用）ＭＶＡ調整項</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsisuurendourate</td><td>（連携用）指数連動部分割合</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuukbn</td><td>（連携用）指数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngaikakbn</td><td>（連携用）外貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkimatukawaserate</td><td>（連携用）期末為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkaiyakukoujyoritu</td><td>（連携用）解約控除率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntumitateriritu</td><td>（連携用）積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsknnkaisiymd</td><td>（連携用）責任開始日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrendouritu</td><td>（連携用）連動率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsuuriyouyobin3</td><td>（連携用）数理用予備項目Ｎ３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv5</td><td>（連携用）予備項目Ｖ５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukeiyakup</td><td>（連携用）主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmvatyouseigow</td><td>（連携用）ＭＶＡ調整後Ｗ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmvakeisanjisknnjynbkn</td><td>（連携用）ＭＶＡ計算時責任準備金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkmtsisuurentumitatekn</td><td>（連携用）期末指数連動部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkmttirttmtttumitatekn</td><td>（連携用）期末定率積立部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkmtsisuurentyokugotmttkn</td><td>（連携用）期末指数連動部分直後積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x4</td><td>（連携用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x5</td><td>（連携用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymd</td><td>（連携用）指数部分計算基準日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekin</td><td>（連携用）指数部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuu</td><td>（連携用）当期指数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymd</td><td>（連携用）当期指数基準年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuu</td><td>（連携用）前期指数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymd</td><td>（連携用）前期指数基準年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritu</td><td>（連携用）積立金増加率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikin</td><td>（連携用）当期積増金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9</td><td>（連携用）予備項目Ｖ９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymdx2</td><td>（連携用）指数部分計算基準日＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekinx2</td><td>（連携用）指数部分積立金＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuux2</td><td>（連携用）当期指数＿２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymdx2</td><td>（連携用）当期指数基準年月日＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuux2</td><td>（連携用）前期指数＿２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymdx2</td><td>（連携用）前期指数基準年月日＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritux2</td><td>（連携用）積立金増加率＿２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikinx2</td><td>（連携用）当期積増金＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x2</td><td>（連携用）予備項目Ｖ９＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymdx3</td><td>（連携用）指数部分計算基準日＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekinx3</td><td>（連携用）指数部分積立金＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuux3</td><td>（連携用）当期指数＿３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymdx3</td><td>（連携用）当期指数基準年月日＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuux3</td><td>（連携用）前期指数＿３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymdx3</td><td>（連携用）前期指数基準年月日＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritux3</td><td>（連携用）積立金増加率＿３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikinx3</td><td>（連携用）当期積増金＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x3</td><td>（連携用）予備項目Ｖ９＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymdx4</td><td>（連携用）指数部分計算基準日＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekinx4</td><td>（連携用）指数部分積立金＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuux4</td><td>（連携用）当期指数＿４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymdx4</td><td>（連携用）当期指数基準年月日＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuux4</td><td>（連携用）前期指数＿４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymdx4</td><td>（連携用）前期指数基準年月日＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritux4</td><td>（連携用）積立金増加率＿４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikinx4</td><td>（連携用）当期積増金＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x4</td><td>（連携用）予備項目Ｖ９＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymdx5</td><td>（連携用）指数部分計算基準日＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekinx5</td><td>（連携用）指数部分積立金＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuux5</td><td>（連携用）当期指数＿５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymdx5</td><td>（連携用）当期指数基準年月日＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuux5</td><td>（連携用）前期指数＿５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymdx5</td><td>（連携用）前期指数基準年月日＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritux5</td><td>（連携用）積立金増加率＿５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikinx5</td><td>（連携用）当期積増金＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x5</td><td>（連携用）予備項目Ｖ９＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymdx6</td><td>（連携用）指数部分計算基準日＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekinx6</td><td>（連携用）指数部分積立金＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuux6</td><td>（連携用）当期指数＿６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymdx6</td><td>（連携用）当期指数基準年月日＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuux6</td><td>（連携用）前期指数＿６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymdx6</td><td>（連携用）前期指数基準年月日＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritux6</td><td>（連携用）積立金増加率＿６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikinx6</td><td>（連携用）当期積増金＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x6</td><td>（連携用）予備項目Ｖ９＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymdx7</td><td>（連携用）指数部分計算基準日＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekinx7</td><td>（連携用）指数部分積立金＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuux7</td><td>（連携用）当期指数＿７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymdx7</td><td>（連携用）当期指数基準年月日＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuux7</td><td>（連携用）前期指数＿７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymdx7</td><td>（連携用）前期指数基準年月日＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritux7</td><td>（連携用）積立金増加率＿７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikinx7</td><td>（連携用）当期積増金＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x7</td><td>（連携用）予備項目Ｖ９＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymdx8</td><td>（連携用）指数部分計算基準日＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekinx8</td><td>（連携用）指数部分積立金＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuux8</td><td>（連携用）当期指数＿８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymdx8</td><td>（連携用）当期指数基準年月日＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuux8</td><td>（連携用）前期指数＿８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymdx8</td><td>（連携用）前期指数基準年月日＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritux8</td><td>（連携用）積立金増加率＿８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikinx8</td><td>（連携用）当期積増金＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x8</td><td>（連携用）予備項目Ｖ９＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymdx9</td><td>（連携用）指数部分計算基準日＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekinx9</td><td>（連携用）指数部分積立金＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuux9</td><td>（連携用）当期指数＿９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymdx9</td><td>（連携用）当期指数基準年月日＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuux9</td><td>（連携用）前期指数＿９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymdx9</td><td>（連携用）前期指数基準年月日＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritux9</td><td>（連携用）積立金増加率＿９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikinx9</td><td>（連携用）当期積増金＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x9</td><td>（連携用）予備項目Ｖ９＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymdx10</td><td>（連携用）指数部分計算基準日＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekinx10</td><td>（連携用）指数部分積立金＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuux10</td><td>（連携用）当期指数＿１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymdx10</td><td>（連携用）当期指数基準年月日＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuux10</td><td>（連携用）前期指数＿１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymdx10</td><td>（連携用）前期指数基準年月日＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritux10</td><td>（連携用）積立金増加率＿１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikinx10</td><td>（連携用）当期積増金＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x10</td><td>（連携用）予備項目Ｖ９＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymdx11</td><td>（連携用）指数部分計算基準日＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekinx11</td><td>（連携用）指数部分積立金＿１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuux11</td><td>（連携用）当期指数＿１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymdx11</td><td>（連携用）当期指数基準年月日＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuux11</td><td>（連携用）前期指数＿１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymdx11</td><td>（連携用）前期指数基準年月日＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritux11</td><td>（連携用）積立金増加率＿１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikinx11</td><td>（連携用）当期積増金＿１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x11</td><td>（連携用）予備項目Ｖ９＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymdx12</td><td>（連携用）指数部分計算基準日＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekinx12</td><td>（連携用）指数部分積立金＿１２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuux12</td><td>（連携用）当期指数＿１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymdx12</td><td>（連携用）当期指数基準年月日＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuux12</td><td>（連携用）前期指数＿１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymdx12</td><td>（連携用）前期指数基準年月日＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritux12</td><td>（連携用）積立金増加率＿１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikinx12</td><td>（連携用）当期積増金＿１２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x12</td><td>（連携用）予備項目Ｖ９＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymdx13</td><td>（連携用）指数部分計算基準日＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekinx13</td><td>（連携用）指数部分積立金＿１３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuux13</td><td>（連携用）当期指数＿１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymdx13</td><td>（連携用）当期指数基準年月日＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuux13</td><td>（連携用）前期指数＿１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymdx13</td><td>（連携用）前期指数基準年月日＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritux13</td><td>（連携用）積立金増加率＿１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikinx13</td><td>（連携用）当期積増金＿１３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x13</td><td>（連携用）予備項目Ｖ９＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymdx14</td><td>（連携用）指数部分計算基準日＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekinx14</td><td>（連携用）指数部分積立金＿１４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuux14</td><td>（連携用）当期指数＿１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymdx14</td><td>（連携用）当期指数基準年月日＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuux14</td><td>（連携用）前期指数＿１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymdx14</td><td>（連携用）前期指数基準年月日＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritux14</td><td>（連携用）積立金増加率＿１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikinx14</td><td>（連携用）当期積増金＿１４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x14</td><td>（連携用）予備項目Ｖ９＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbncalckijyunymdx15</td><td>（連携用）指数部分計算基準日＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuubbntumitatekinx15</td><td>（連携用）指数部分積立金＿１５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukisisuux15</td><td>（連携用）当期指数＿１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukisisuukijyunymdx15</td><td>（連携用）当期指数基準年月日＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkisisuux15</td><td>（連携用）前期指数＿１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzenkisisuukijyunymdx15</td><td>（連携用）前期指数基準年月日＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritux15</td><td>（連携用）積立金増加率＿１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntoukitumimasikinx15</td><td>（連携用）当期積増金＿１５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x15</td><td>（連携用）予備項目Ｖ９＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymd</td><td>（連携用）定率部分計算基準日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekin</td><td>（連携用）定率部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16</td><td>（連携用）予備項目Ｖ１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymdx2</td><td>（連携用）定率部分計算基準日＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekinx2</td><td>（連携用）定率部分積立金＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16x2</td><td>（連携用）予備項目Ｖ１６＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymdx3</td><td>（連携用）定率部分計算基準日＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekinx3</td><td>（連携用）定率部分積立金＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16x3</td><td>（連携用）予備項目Ｖ１６＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymdx4</td><td>（連携用）定率部分計算基準日＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekinx4</td><td>（連携用）定率部分積立金＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16x4</td><td>（連携用）予備項目Ｖ１６＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymdx5</td><td>（連携用）定率部分計算基準日＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekinx5</td><td>（連携用）定率部分積立金＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16x5</td><td>（連携用）予備項目Ｖ１６＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymdx6</td><td>（連携用）定率部分計算基準日＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekinx6</td><td>（連携用）定率部分積立金＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16x6</td><td>（連携用）予備項目Ｖ１６＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymdx7</td><td>（連携用）定率部分計算基準日＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekinx7</td><td>（連携用）定率部分積立金＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16x7</td><td>（連携用）予備項目Ｖ１６＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymdx8</td><td>（連携用）定率部分計算基準日＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekinx8</td><td>（連携用）定率部分積立金＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16x8</td><td>（連携用）予備項目Ｖ１６＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymdx9</td><td>（連携用）定率部分計算基準日＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekinx9</td><td>（連携用）定率部分積立金＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16x9</td><td>（連携用）予備項目Ｖ１６＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymdx10</td><td>（連携用）定率部分計算基準日＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekinx10</td><td>（連携用）定率部分積立金＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16x10</td><td>（連携用）予備項目Ｖ１６＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymdx11</td><td>（連携用）定率部分計算基準日＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekinx11</td><td>（連携用）定率部分積立金＿１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16x11</td><td>（連携用）予備項目Ｖ１６＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymdx12</td><td>（連携用）定率部分計算基準日＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekinx12</td><td>（連携用）定率部分積立金＿１２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16x12</td><td>（連携用）予備項目Ｖ１６＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymdx13</td><td>（連携用）定率部分計算基準日＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekinx13</td><td>（連携用）定率部分積立金＿１３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16x13</td><td>（連携用）予備項目Ｖ１６＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymdx14</td><td>（連携用）定率部分計算基準日＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekinx14</td><td>（連携用）定率部分積立金＿１４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16x14</td><td>（連携用）予備項目Ｖ１６＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritucalckijyunymdx15</td><td>（連携用）定率部分計算基準日＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteiritutumitatekinx15</td><td>（連携用）定率部分積立金＿１５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv16x15</td><td>（連携用）予備項目Ｖ１６＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngengakujicalckijyunymd</td><td>（連携用）減額時計算基準年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngengakujisisuutmttkn</td><td>（連携用）減額時指数部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngengakujiteiritutmttkn</td><td>（連携用）減額時定率部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv10</td><td>（連携用）予備項目Ｖ１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobin11x6</td><td>（連携用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x7</td><td>（連携用）予備項目Ｎ１１＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x8</td><td>（連携用）予備項目Ｎ１１＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x9</td><td>（連携用）予備項目Ｎ１１＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsuuriyouyobin14</td><td>（連携用）数理用予備項目Ｎ１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv20</td><td>（連携用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SrKbkSsuRnduHknVKnsyuyuRn
 * @see     GenZT_SrKbkSsuRnduHknVKnsyuyuRn
 * @see     QZT_SrKbkSsuRnduHknVKnsyuyuRn
 * @see     GenQZT_SrKbkSsuRnduHknVKnsyuyuRn
 */
public class PKZT_SrKbkSsuRnduHknVKnsyuyuRn extends AbstractExDBPrimaryKey<ZT_SrKbkSsuRnduHknVKnsyuyuRn, PKZT_SrKbkSsuRnduHknVKnsyuyuRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SrKbkSsuRnduHknVKnsyuyuRn() {
    }

    public PKZT_SrKbkSsuRnduHknVKnsyuyuRn(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    @Transient
    @Override
    public Class<ZT_SrKbkSsuRnduHknVKnsyuyuRn> getEntityClass() {
        return ZT_SrKbkSsuRnduHknVKnsyuyuRn.class;
    }

    private Integer zrnsequenceno;

    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

}