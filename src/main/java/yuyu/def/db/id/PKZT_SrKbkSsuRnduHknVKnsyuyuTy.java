package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SrKbkSsuRnduHknVKnsyuyuTy;
import yuyu.def.db.mapping.GenZT_SrKbkSsuRnduHknVKnsyuyuTy;
import yuyu.def.db.meta.GenQZT_SrKbkSsuRnduHknVKnsyuyuTy;
import yuyu.def.db.meta.QZT_SrKbkSsuRnduHknVKnsyuyuTy;

/**
 * 株価指数連動保険Ｖ検証用Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SrKbkSsuRnduHknVKnsyuyuTy}</td><td colspan="3">株価指数連動保険Ｖ検証用Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyuukourecordlength</td><td>（中継用）有効レコード長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyrdwarea</td><td>（中継用）ＲＤＷ領域</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeijyouym</td><td>（中継用）計上年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyraysystemhyj</td><td>（中継用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatakanrino</td><td>（中継用）データ管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruikigousedaikbn</td><td>（中継用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasipmenkbn</td><td>（中継用）外出Ｐ免区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasimanagehyouji</td><td>（中継用）外出満年令表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin6</td><td>（中継用）数理用予備項目Ｎ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv12</td><td>（中継用）予備項目Ｖ１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyousegmentkbn</td><td>（中継用）区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyourgnbnskkbn</td><td>（中継用）区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuurisyuruicd</td><td>（中継用）数理種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin6x2</td><td>（中継用）数理用予備項目Ｎ６＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8</td><td>（中継用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkikn</td><td>（中継用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaimnkkykhyj</td><td>（中継用）才満期契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhihokensyaagev2</td><td>（中継用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykuriagekurisagekbn</td><td>（中継用）繰上げ繰下げ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin6x3</td><td>（中継用）数理用予備項目Ｎ６＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8x2</td><td>（中継用）予備項目Ｖ８＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakujiyoteiriritu</td><td>（中継用）契約時予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysrkaiyakusjkkktyouseirrt</td><td>（中継用）数理用解約時市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysrkyksjkkktyouseiriritu</td><td>（中継用）数理用契約時市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztymvatyouseikou</td><td>（中継用）ＭＶＡ調整項</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysisuurendourate</td><td>（中継用）指数連動部分割合</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuukbn</td><td>（中継用）指数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygaikakbn</td><td>（中継用）外貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykimatukawaserate</td><td>（中継用）期末為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykaiyakukoujyoritu</td><td>（中継用）解約控除率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytumitateriritu</td><td>（中継用）積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysknnkaisiymd</td><td>（中継用）責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrendouritu</td><td>（中継用）連動率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysuuriyouyobin3</td><td>（中継用）数理用予備項目Ｎ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv5</td><td>（中継用）予備項目Ｖ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakup</td><td>（中継用）主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymvatyouseigow</td><td>（中継用）ＭＶＡ調整後Ｗ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymvakeisanjisknnjynbkn</td><td>（中継用）ＭＶＡ計算時責任準備金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykmtsisuurentumitatekn</td><td>（中継用）期末指数連動部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykmttirttmtttumitatekn</td><td>（中継用）期末定率積立部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykmtsisuurentyokugotmttkn</td><td>（中継用）期末指数連動部分直後積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x4</td><td>（中継用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x5</td><td>（中継用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymd</td><td>（中継用）指数部分計算基準日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekin</td><td>（中継用）指数部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuu</td><td>（中継用）当期指数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymd</td><td>（中継用）当期指数基準年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuu</td><td>（中継用）前期指数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymd</td><td>（中継用）前期指数基準年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritu</td><td>（中継用）積立金増加率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikin</td><td>（中継用）当期積増金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9</td><td>（中継用）予備項目Ｖ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymdx2</td><td>（中継用）指数部分計算基準日＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekinx2</td><td>（中継用）指数部分積立金＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuux2</td><td>（中継用）当期指数＿２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymdx2</td><td>（中継用）当期指数基準年月日＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuux2</td><td>（中継用）前期指数＿２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymdx2</td><td>（中継用）前期指数基準年月日＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritux2</td><td>（中継用）積立金増加率＿２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikinx2</td><td>（中継用）当期積増金＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9x2</td><td>（中継用）予備項目Ｖ９＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymdx3</td><td>（中継用）指数部分計算基準日＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekinx3</td><td>（中継用）指数部分積立金＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuux3</td><td>（中継用）当期指数＿３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymdx3</td><td>（中継用）当期指数基準年月日＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuux3</td><td>（中継用）前期指数＿３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymdx3</td><td>（中継用）前期指数基準年月日＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritux3</td><td>（中継用）積立金増加率＿３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikinx3</td><td>（中継用）当期積増金＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9x3</td><td>（中継用）予備項目Ｖ９＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymdx4</td><td>（中継用）指数部分計算基準日＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekinx4</td><td>（中継用）指数部分積立金＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuux4</td><td>（中継用）当期指数＿４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymdx4</td><td>（中継用）当期指数基準年月日＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuux4</td><td>（中継用）前期指数＿４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymdx4</td><td>（中継用）前期指数基準年月日＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritux4</td><td>（中継用）積立金増加率＿４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikinx4</td><td>（中継用）当期積増金＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9x4</td><td>（中継用）予備項目Ｖ９＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymdx5</td><td>（中継用）指数部分計算基準日＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekinx5</td><td>（中継用）指数部分積立金＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuux5</td><td>（中継用）当期指数＿５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymdx5</td><td>（中継用）当期指数基準年月日＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuux5</td><td>（中継用）前期指数＿５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymdx5</td><td>（中継用）前期指数基準年月日＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritux5</td><td>（中継用）積立金増加率＿５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikinx5</td><td>（中継用）当期積増金＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9x5</td><td>（中継用）予備項目Ｖ９＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymdx6</td><td>（中継用）指数部分計算基準日＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekinx6</td><td>（中継用）指数部分積立金＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuux6</td><td>（中継用）当期指数＿６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymdx6</td><td>（中継用）当期指数基準年月日＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuux6</td><td>（中継用）前期指数＿６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymdx6</td><td>（中継用）前期指数基準年月日＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritux6</td><td>（中継用）積立金増加率＿６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikinx6</td><td>（中継用）当期積増金＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9x6</td><td>（中継用）予備項目Ｖ９＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymdx7</td><td>（中継用）指数部分計算基準日＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekinx7</td><td>（中継用）指数部分積立金＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuux7</td><td>（中継用）当期指数＿７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymdx7</td><td>（中継用）当期指数基準年月日＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuux7</td><td>（中継用）前期指数＿７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymdx7</td><td>（中継用）前期指数基準年月日＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritux7</td><td>（中継用）積立金増加率＿７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikinx7</td><td>（中継用）当期積増金＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9x7</td><td>（中継用）予備項目Ｖ９＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymdx8</td><td>（中継用）指数部分計算基準日＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekinx8</td><td>（中継用）指数部分積立金＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuux8</td><td>（中継用）当期指数＿８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymdx8</td><td>（中継用）当期指数基準年月日＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuux8</td><td>（中継用）前期指数＿８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymdx8</td><td>（中継用）前期指数基準年月日＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritux8</td><td>（中継用）積立金増加率＿８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikinx8</td><td>（中継用）当期積増金＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9x8</td><td>（中継用）予備項目Ｖ９＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymdx9</td><td>（中継用）指数部分計算基準日＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekinx9</td><td>（中継用）指数部分積立金＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuux9</td><td>（中継用）当期指数＿９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymdx9</td><td>（中継用）当期指数基準年月日＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuux9</td><td>（中継用）前期指数＿９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymdx9</td><td>（中継用）前期指数基準年月日＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritux9</td><td>（中継用）積立金増加率＿９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikinx9</td><td>（中継用）当期積増金＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9x9</td><td>（中継用）予備項目Ｖ９＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymdx10</td><td>（中継用）指数部分計算基準日＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekinx10</td><td>（中継用）指数部分積立金＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuux10</td><td>（中継用）当期指数＿１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymdx10</td><td>（中継用）当期指数基準年月日＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuux10</td><td>（中継用）前期指数＿１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymdx10</td><td>（中継用）前期指数基準年月日＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritux10</td><td>（中継用）積立金増加率＿１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikinx10</td><td>（中継用）当期積増金＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9x10</td><td>（中継用）予備項目Ｖ９＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymdx11</td><td>（中継用）指数部分計算基準日＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekinx11</td><td>（中継用）指数部分積立金＿１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuux11</td><td>（中継用）当期指数＿１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymdx11</td><td>（中継用）当期指数基準年月日＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuux11</td><td>（中継用）前期指数＿１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymdx11</td><td>（中継用）前期指数基準年月日＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritux11</td><td>（中継用）積立金増加率＿１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikinx11</td><td>（中継用）当期積増金＿１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9x11</td><td>（中継用）予備項目Ｖ９＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymdx12</td><td>（中継用）指数部分計算基準日＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekinx12</td><td>（中継用）指数部分積立金＿１２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuux12</td><td>（中継用）当期指数＿１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymdx12</td><td>（中継用）当期指数基準年月日＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuux12</td><td>（中継用）前期指数＿１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymdx12</td><td>（中継用）前期指数基準年月日＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritux12</td><td>（中継用）積立金増加率＿１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikinx12</td><td>（中継用）当期積増金＿１２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9x12</td><td>（中継用）予備項目Ｖ９＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymdx13</td><td>（中継用）指数部分計算基準日＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekinx13</td><td>（中継用）指数部分積立金＿１３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuux13</td><td>（中継用）当期指数＿１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymdx13</td><td>（中継用）当期指数基準年月日＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuux13</td><td>（中継用）前期指数＿１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymdx13</td><td>（中継用）前期指数基準年月日＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritux13</td><td>（中継用）積立金増加率＿１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikinx13</td><td>（中継用）当期積増金＿１３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9x13</td><td>（中継用）予備項目Ｖ９＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymdx14</td><td>（中継用）指数部分計算基準日＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekinx14</td><td>（中継用）指数部分積立金＿１４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuux14</td><td>（中継用）当期指数＿１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymdx14</td><td>（中継用）当期指数基準年月日＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuux14</td><td>（中継用）前期指数＿１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymdx14</td><td>（中継用）前期指数基準年月日＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritux14</td><td>（中継用）積立金増加率＿１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikinx14</td><td>（中継用）当期積増金＿１４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9x14</td><td>（中継用）予備項目Ｖ９＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbncalckijyunymdx15</td><td>（中継用）指数部分計算基準日＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuubbntumitatekinx15</td><td>（中継用）指数部分積立金＿１５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukisisuux15</td><td>（中継用）当期指数＿１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukisisuukijyunymdx15</td><td>（中継用）当期指数基準年月日＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkisisuux15</td><td>（中継用）前期指数＿１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzenkisisuukijyunymdx15</td><td>（中継用）前期指数基準年月日＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritux15</td><td>（中継用）積立金増加率＿１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytoukitumimasikinx15</td><td>（中継用）当期積増金＿１５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv9x15</td><td>（中継用）予備項目Ｖ９＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymd</td><td>（中継用）定率部分計算基準日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekin</td><td>（中継用）定率部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16</td><td>（中継用）予備項目Ｖ１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymdx2</td><td>（中継用）定率部分計算基準日＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekinx2</td><td>（中継用）定率部分積立金＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16x2</td><td>（中継用）予備項目Ｖ１６＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymdx3</td><td>（中継用）定率部分計算基準日＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekinx3</td><td>（中継用）定率部分積立金＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16x3</td><td>（中継用）予備項目Ｖ１６＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymdx4</td><td>（中継用）定率部分計算基準日＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekinx4</td><td>（中継用）定率部分積立金＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16x4</td><td>（中継用）予備項目Ｖ１６＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymdx5</td><td>（中継用）定率部分計算基準日＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekinx5</td><td>（中継用）定率部分積立金＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16x5</td><td>（中継用）予備項目Ｖ１６＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymdx6</td><td>（中継用）定率部分計算基準日＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekinx6</td><td>（中継用）定率部分積立金＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16x6</td><td>（中継用）予備項目Ｖ１６＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymdx7</td><td>（中継用）定率部分計算基準日＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekinx7</td><td>（中継用）定率部分積立金＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16x7</td><td>（中継用）予備項目Ｖ１６＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymdx8</td><td>（中継用）定率部分計算基準日＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekinx8</td><td>（中継用）定率部分積立金＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16x8</td><td>（中継用）予備項目Ｖ１６＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymdx9</td><td>（中継用）定率部分計算基準日＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekinx9</td><td>（中継用）定率部分積立金＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16x9</td><td>（中継用）予備項目Ｖ１６＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymdx10</td><td>（中継用）定率部分計算基準日＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekinx10</td><td>（中継用）定率部分積立金＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16x10</td><td>（中継用）予備項目Ｖ１６＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymdx11</td><td>（中継用）定率部分計算基準日＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekinx11</td><td>（中継用）定率部分積立金＿１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16x11</td><td>（中継用）予備項目Ｖ１６＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymdx12</td><td>（中継用）定率部分計算基準日＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekinx12</td><td>（中継用）定率部分積立金＿１２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16x12</td><td>（中継用）予備項目Ｖ１６＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymdx13</td><td>（中継用）定率部分計算基準日＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekinx13</td><td>（中継用）定率部分積立金＿１３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16x13</td><td>（中継用）予備項目Ｖ１６＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymdx14</td><td>（中継用）定率部分計算基準日＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekinx14</td><td>（中継用）定率部分積立金＿１４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16x14</td><td>（中継用）予備項目Ｖ１６＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritucalckijyunymdx15</td><td>（中継用）定率部分計算基準日＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteiritutumitatekinx15</td><td>（中継用）定率部分積立金＿１５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv16x15</td><td>（中継用）予備項目Ｖ１６＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygengakujicalckijyunymd</td><td>（中継用）減額時計算基準年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygengakujisisuutmttkn</td><td>（中継用）減額時指数部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygengakujiteiritutmttkn</td><td>（中継用）減額時定率部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv10</td><td>（中継用）予備項目Ｖ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobin11x6</td><td>（中継用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x7</td><td>（中継用）予備項目Ｎ１１＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x8</td><td>（中継用）予備項目Ｎ１１＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x9</td><td>（中継用）予備項目Ｎ１１＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysuuriyouyobin14</td><td>（中継用）数理用予備項目Ｎ１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv20</td><td>（中継用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SrKbkSsuRnduHknVKnsyuyuTy
 * @see     GenZT_SrKbkSsuRnduHknVKnsyuyuTy
 * @see     QZT_SrKbkSsuRnduHknVKnsyuyuTy
 * @see     GenQZT_SrKbkSsuRnduHknVKnsyuyuTy
 */
public class PKZT_SrKbkSsuRnduHknVKnsyuyuTy extends AbstractExDBPrimaryKey<ZT_SrKbkSsuRnduHknVKnsyuyuTy, PKZT_SrKbkSsuRnduHknVKnsyuyuTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SrKbkSsuRnduHknVKnsyuyuTy() {
    }

    public PKZT_SrKbkSsuRnduHknVKnsyuyuTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_SrKbkSsuRnduHknVKnsyuyuTy> getEntityClass() {
        return ZT_SrKbkSsuRnduHknVKnsyuyuTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}